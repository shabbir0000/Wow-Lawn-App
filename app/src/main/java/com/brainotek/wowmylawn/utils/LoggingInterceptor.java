package com.brainotek.wowmylawn.utils;

import static com.brainotek.wowmylawn.utils.Constant.RetrofitConstants.RETROFIT_METHOD_GET;
import static com.brainotek.wowmylawn.utils.Constant.RetrofitConstants.RETROFIT_METHOD_POST;

import android.util.Log;

import com.brainotek.wowmylawn.R;
import com.brainotek.wowmylawn.koin.InjectUtils;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;


/***
 * Logging interceptor for Retrofit 2 which logs all request and response.
 */
public class LoggingInterceptor implements Interceptor {
    public static String TAG = LoggingInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
        String requestLog = String.format(
                InjectUtils.INSTANCE.getAppContext().getString(R.string.retrofit_logging_request),
                request.url(),
                chain.connection(),
                request.headers(),
                request.method() +
                        InjectUtils.INSTANCE.getAppContext().getString(R.string.retrofit_request_method_type));
        //YTimber.d(String.format("Sending request %s on %s%n%s",
        //        request.url(), chain.connection(), request.headers()));
        if (request.method().compareToIgnoreCase(RETROFIT_METHOD_POST) == 0) {
            requestLog = "\n" + requestLog + "\n" + bodyToString(request);
        } else if (request.method().compareToIgnoreCase(RETROFIT_METHOD_GET) != 0) {
            requestLog = "\n" + requestLog + "\n" + bodyToString(request);
        }
        Log.v(TAG, "request" + "\n" + requestLog);

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();

        String responseLog = String.format(Locale.US,
                InjectUtils.INSTANCE.getAppContext().getString(R.string.retrofit_logging_response),
                response.request().url(), (t2 - t1) / 1e6d, response.headers());

        String bodyString = response.body().string();

        Log.v(TAG, "response" + "\n" + request.method() + " Method" + "\n" + responseLog + "\n"
                + bodyString);

        return response.newBuilder()
                .body(ResponseBody.create(response.body()
                        .contentType(), bodyString))
                .build();
        //return response;
    }


    /***
     * Covert Request data into string which we will need for logging.
     * @param request Latest request model from OkHTTP3
     * @return converted string body.
     */
    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return e.getMessage();
        }
    }
}
