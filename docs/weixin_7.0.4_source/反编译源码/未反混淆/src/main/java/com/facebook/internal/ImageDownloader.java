package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookException;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.WorkQueue.WorkItem;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static Handler handler;
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    static class RequestKey {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        Uri uri;

        RequestKey(Uri uri, Object obj) {
            this.uri = uri;
            this.tag = obj;
        }

        public int hashCode() {
            AppMethodBeat.i(72372);
            int hashCode = ((this.uri.hashCode() + FilterEnum4Shaka.MIC_WEISHI_MENGHUANG) * 37) + this.tag.hashCode();
            AppMethodBeat.o(72372);
            return hashCode;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            if (requestKey.uri == this.uri && requestKey.tag == this.tag) {
                return true;
            }
            return false;
        }
    }

    static class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context, RequestKey requestKey) {
            this.context = context;
            this.key = requestKey;
        }

        public void run() {
            AppMethodBeat.i(72371);
            ImageDownloader.access$200(this.key, this.context);
            AppMethodBeat.o(72371);
        }
    }

    static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkItem workItem;

        private DownloaderContext() {
        }

        /* synthetic */ DownloaderContext(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context, RequestKey requestKey, boolean z) {
            this.context = context;
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        public void run() {
            AppMethodBeat.i(72370);
            ImageDownloader.access$100(this.key, this.context, this.allowCachedRedirects);
            AppMethodBeat.o(72370);
        }
    }

    static /* synthetic */ void access$100(RequestKey requestKey, Context context, boolean z) {
        AppMethodBeat.i(72385);
        readFromCache(requestKey, context, z);
        AppMethodBeat.o(72385);
    }

    static /* synthetic */ void access$200(RequestKey requestKey, Context context) {
        AppMethodBeat.i(72386);
        download(requestKey, context);
        AppMethodBeat.o(72386);
    }

    static {
        AppMethodBeat.i(72387);
        AppMethodBeat.o(72387);
    }

    public static void downloadAsync(ImageRequest imageRequest) {
        AppMethodBeat.i(72373);
        if (imageRequest == null) {
            AppMethodBeat.o(72373);
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            try {
                DownloaderContext downloaderContext = (DownloaderContext) pendingRequests.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.request = imageRequest;
                    downloaderContext.isCancelled = false;
                    downloaderContext.workItem.moveToFront();
                } else {
                    enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                }
            } finally {
                AppMethodBeat.o(72373);
            }
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        AppMethodBeat.i(72374);
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            try {
                DownloaderContext downloaderContext = (DownloaderContext) pendingRequests.get(requestKey);
                if (downloaderContext == null) {
                    z = false;
                } else if (downloaderContext.workItem.cancel()) {
                    pendingRequests.remove(requestKey);
                    z = true;
                } else {
                    downloaderContext.isCancelled = true;
                    z = true;
                }
            } finally {
                AppMethodBeat.o(72374);
            }
        }
        return z;
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        AppMethodBeat.i(72375);
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            try {
                DownloaderContext downloaderContext = (DownloaderContext) pendingRequests.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.workItem.moveToFront();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72375);
            }
        }
    }

    public static void clearCache(Context context) {
        AppMethodBeat.i(72376);
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache();
        AppMethodBeat.o(72376);
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        AppMethodBeat.i(72377);
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z));
        AppMethodBeat.o(72377);
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        AppMethodBeat.i(72378);
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
        AppMethodBeat.o(72378);
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        AppMethodBeat.i(72379);
        synchronized (pendingRequests) {
            try {
                DownloaderContext downloaderContext = new DownloaderContext();
                downloaderContext.request = imageRequest;
                pendingRequests.put(requestKey, downloaderContext);
                downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72379);
            }
        }
    }

    private static void issueResponse(RequestKey requestKey, Exception exception, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(72380);
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (!(removePendingRequest == null || removePendingRequest.isCancelled)) {
            final ImageRequest imageRequest = removePendingRequest.request;
            final Callback callback = imageRequest.getCallback();
            if (callback != null) {
                final Exception exception2 = exception;
                final boolean z2 = z;
                final Bitmap bitmap2 = bitmap;
                getHandler().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(72369);
                        callback.onCompleted(new ImageResponse(imageRequest, exception2, z2, bitmap2));
                        AppMethodBeat.o(72369);
                    }
                });
            }
        }
        AppMethodBeat.o(72380);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void readFromCache(RequestKey requestKey, Context context, boolean z) {
        InputStream cachedImageStream;
        boolean z2;
        InputStream cachedImageStream2;
        boolean z3 = false;
        AppMethodBeat.i(72381);
        if (z) {
            Uri redirectedUri = UrlRedirectCache.getRedirectedUri(requestKey.uri);
            if (redirectedUri != null) {
                cachedImageStream = ImageResponseCache.getCachedImageStream(redirectedUri, context);
                if (cachedImageStream != null) {
                    z3 = true;
                }
                z2 = z3;
                if (z2) {
                    cachedImageStream2 = ImageResponseCache.getCachedImageStream(requestKey.uri, context);
                } else {
                    cachedImageStream2 = cachedImageStream;
                }
                if (cachedImageStream2 == null) {
                    Bitmap decodeStream = BitmapFactory.decodeStream(cachedImageStream2);
                    Utility.closeQuietly(cachedImageStream2);
                    issueResponse(requestKey, null, decodeStream, z2);
                    AppMethodBeat.o(72381);
                    return;
                }
                DownloaderContext removePendingRequest = removePendingRequest(requestKey);
                if (!(removePendingRequest == null || removePendingRequest.isCancelled)) {
                    enqueueDownload(removePendingRequest.request, requestKey);
                }
                AppMethodBeat.o(72381);
                return;
            }
        }
        z2 = false;
        cachedImageStream = null;
        if (z2) {
        }
        if (cachedImageStream2 == null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c5 A:{Splitter:B:4:0x001b, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:32:0x008c, code skipped:
            com.facebook.internal.Utility.closeQuietly(r6);
            com.facebook.internal.Utility.disconnectQuietly(r0);
            r4 = r3;
            r0 = r5;
     */
    /* JADX WARNING: Missing block: B:46:0x00c5, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:47:0x00c6, code skipped:
            r6 = null;
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:50:0x00d0, code skipped:
            r3 = e;
     */
    /* JADX WARNING: Missing block: B:51:0x00d1, code skipped:
            r5 = true;
            r6 = null;
            r7 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void download(RequestKey requestKey, Context context) {
        Exception e;
        boolean z;
        URLConnection uRLConnection;
        Exception exception;
        Throwable th;
        URLConnection uRLConnection2;
        Bitmap bitmap = null;
        AppMethodBeat.i(72382);
        boolean z2 = true;
        Closeable interceptAndCacheImageStream;
        try {
            URLConnection uRLConnection3 = (HttpURLConnection) new URL(requestKey.uri.toString()).openConnection();
            try {
                uRLConnection3.setInstanceFollowRedirects(false);
                Bitmap decodeStream;
                Exception exception2;
                switch (uRLConnection3.getResponseCode()) {
                    case 200:
                        interceptAndCacheImageStream = ImageResponseCache.interceptAndCacheImageStream(context, uRLConnection3);
                        decodeStream = BitmapFactory.decodeStream(interceptAndCacheImageStream);
                        exception2 = null;
                        break;
                    case 301:
                    case 302:
                        String headerField = uRLConnection3.getHeaderField(b.LOCATION);
                        if (!Utility.isNullOrEmpty(headerField)) {
                            Uri parse = Uri.parse(headerField);
                            UrlRedirectCache.cacheUriRedirect(requestKey.uri, parse);
                            DownloaderContext removePendingRequest = removePendingRequest(requestKey);
                            if (!(removePendingRequest == null || removePendingRequest.isCancelled)) {
                                enqueueCacheRead(removePendingRequest.request, new RequestKey(parse, requestKey.tag), false);
                            }
                            z2 = false;
                            decodeStream = null;
                            exception2 = null;
                            interceptAndCacheImageStream = null;
                            break;
                        }
                        z2 = false;
                        decodeStream = null;
                        exception2 = null;
                        interceptAndCacheImageStream = null;
                        break;
                    default:
                        interceptAndCacheImageStream = uRLConnection3.getErrorStream();
                        try {
                            StringBuilder stringBuilder = new StringBuilder();
                            if (interceptAndCacheImageStream != null) {
                                InputStreamReader inputStreamReader = new InputStreamReader(interceptAndCacheImageStream);
                                char[] cArr = new char[128];
                                while (true) {
                                    int read = inputStreamReader.read(cArr, 0, 128);
                                    if (read > 0) {
                                        stringBuilder.append(cArr, 0, read);
                                    } else {
                                        Utility.closeQuietly(inputStreamReader);
                                    }
                                }
                            } else {
                                stringBuilder.append("Unexpected error while downloading an image.");
                            }
                            exception2 = new FacebookException(stringBuilder.toString());
                            decodeStream = null;
                            break;
                        } catch (IOException e2) {
                            e = e2;
                            z = true;
                            uRLConnection = uRLConnection3;
                            Utility.closeQuietly(interceptAndCacheImageStream);
                            Utility.disconnectQuietly(uRLConnection);
                            z2 = z;
                            exception = e;
                            if (z2) {
                            }
                            AppMethodBeat.o(72382);
                        } catch (Throwable th2) {
                            th = th2;
                            uRLConnection2 = uRLConnection3;
                            Utility.closeQuietly(interceptAndCacheImageStream);
                            Utility.disconnectQuietly(uRLConnection2);
                            AppMethodBeat.o(72382);
                            throw th;
                        }
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
                interceptAndCacheImageStream = null;
                uRLConnection = uRLConnection3;
            } catch (Throwable th3) {
            }
        } catch (IOException exception3) {
            e = exception3;
            z = true;
            interceptAndCacheImageStream = null;
            uRLConnection = null;
            Utility.closeQuietly(interceptAndCacheImageStream);
            Utility.disconnectQuietly(uRLConnection);
            z2 = z;
            exception3 = e;
            if (z2) {
                issueResponse(requestKey, exception3, bitmap, false);
            }
            AppMethodBeat.o(72382);
        } catch (Throwable th4) {
            th = th4;
            interceptAndCacheImageStream = null;
            uRLConnection2 = null;
            Utility.closeQuietly(interceptAndCacheImageStream);
            Utility.disconnectQuietly(uRLConnection2);
            AppMethodBeat.o(72382);
            throw th;
        }
    }

    private static synchronized Handler getHandler() {
        Handler handler;
        synchronized (ImageDownloader.class) {
            AppMethodBeat.i(72383);
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler = handler;
            AppMethodBeat.o(72383);
        }
        return handler;
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext downloaderContext;
        AppMethodBeat.i(72384);
        synchronized (pendingRequests) {
            try {
                downloaderContext = (DownloaderContext) pendingRequests.remove(requestKey);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72384);
            }
        }
        return downloaderContext;
    }
}
