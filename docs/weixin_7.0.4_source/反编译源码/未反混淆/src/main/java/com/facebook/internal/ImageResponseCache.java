package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

class ImageResponseCache {
    static final String TAG = ImageResponseCache.class.getSimpleName();
    private static FileLruCache imageCache;

    static class BufferedHttpInputStream extends BufferedInputStream {
        HttpURLConnection connection;

        BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            this.connection = httpURLConnection;
        }

        public void close() {
            AppMethodBeat.i(72392);
            super.close();
            Utility.disconnectQuietly(this.connection);
            AppMethodBeat.o(72392);
        }
    }

    ImageResponseCache() {
    }

    static {
        AppMethodBeat.i(72398);
        AppMethodBeat.o(72398);
    }

    static synchronized FileLruCache getCache(Context context) {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            AppMethodBeat.i(72393);
            if (imageCache == null) {
                imageCache = new FileLruCache(TAG, new Limits());
            }
            fileLruCache = imageCache;
            AppMethodBeat.o(72393);
        }
        return fileLruCache;
    }

    static InputStream getCachedImageStream(Uri uri, Context context) {
        AppMethodBeat.i(72394);
        InputStream inputStream = null;
        if (uri != null && isCDNURL(uri)) {
            try {
                inputStream = getCache(context).get(uri.toString());
            } catch (IOException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, e.toString());
            }
        }
        AppMethodBeat.o(72394);
        return inputStream;
    }

    static InputStream interceptAndCacheImageStream(Context context, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(72395);
        InputStream inputStream = null;
        if (httpURLConnection.getResponseCode() == 200) {
            Uri parse = Uri.parse(httpURLConnection.getURL().toString());
            inputStream = httpURLConnection.getInputStream();
            try {
                if (isCDNURL(parse)) {
                    inputStream = getCache(context).interceptAndPut(parse.toString(), new BufferedHttpInputStream(inputStream, httpURLConnection));
                }
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(72395);
        return inputStream;
    }

    private static boolean isCDNURL(Uri uri) {
        AppMethodBeat.i(72396);
        if (uri != null) {
            String host = uri.getHost();
            if (host.endsWith("fbcdn.net")) {
                AppMethodBeat.o(72396);
                return true;
            } else if (host.startsWith("fbcdn") && host.endsWith("akamaihd.net")) {
                AppMethodBeat.o(72396);
                return true;
            }
        }
        AppMethodBeat.o(72396);
        return false;
    }

    static void clearCache(Context context) {
        AppMethodBeat.i(72397);
        try {
            getCache(context).clearCache();
            AppMethodBeat.o(72397);
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
            AppMethodBeat.o(72397);
        }
    }
}
