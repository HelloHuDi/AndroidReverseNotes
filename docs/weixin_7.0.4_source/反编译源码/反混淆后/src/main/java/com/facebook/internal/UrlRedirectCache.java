package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG = (TAG + "_Redirect");
    static final String TAG = UrlRedirectCache.class.getSimpleName();
    private static FileLruCache urlRedirectCache;

    UrlRedirectCache() {
    }

    static {
        AppMethodBeat.m2504i(72489);
        AppMethodBeat.m2505o(72489);
    }

    static synchronized FileLruCache getCache() {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            AppMethodBeat.m2504i(72485);
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(TAG, new Limits());
            }
            fileLruCache = urlRedirectCache;
            AppMethodBeat.m2505o(72485);
        }
        return fileLruCache;
    }

    static Uri getRedirectedUri(Uri uri) {
        Closeable closeable;
        Throwable th;
        Uri uri2 = null;
        AppMethodBeat.m2504i(72486);
        if (uri == null) {
            AppMethodBeat.m2505o(72486);
        } else {
            String uri3 = uri.toString();
            Closeable inputStreamReader;
            try {
                FileLruCache cache = getCache();
                Object obj = null;
                closeable = uri2;
                while (true) {
                    try {
                        InputStream inputStream = cache.get(uri3, REDIRECT_CONTENT_TAG);
                        if (inputStream == null) {
                            break;
                        }
                        obj = 1;
                        inputStreamReader = new InputStreamReader(inputStream);
                        try {
                            char[] cArr = new char[128];
                            StringBuilder stringBuilder = new StringBuilder();
                            while (true) {
                                int read = inputStreamReader.read(cArr, 0, 128);
                                if (read <= 0) {
                                    break;
                                }
                                stringBuilder.append(cArr, 0, read);
                            }
                            Utility.closeQuietly(inputStreamReader);
                            uri3 = stringBuilder.toString();
                            closeable = inputStreamReader;
                        } catch (IOException e) {
                            Utility.closeQuietly(inputStreamReader);
                            AppMethodBeat.m2505o(72486);
                            return uri2;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = inputStreamReader;
                            Utility.closeQuietly(closeable);
                            AppMethodBeat.m2505o(72486);
                            throw th;
                        }
                    } catch (IOException e2) {
                        inputStreamReader = closeable;
                        Utility.closeQuietly(inputStreamReader);
                        AppMethodBeat.m2505o(72486);
                        return uri2;
                    } catch (Throwable th22) {
                        th = th22;
                        Utility.closeQuietly(closeable);
                        AppMethodBeat.m2505o(72486);
                        throw th;
                    }
                }
                if (obj != null) {
                    uri2 = Uri.parse(uri3);
                    Utility.closeQuietly(closeable);
                    AppMethodBeat.m2505o(72486);
                } else {
                    Utility.closeQuietly(closeable);
                    AppMethodBeat.m2505o(72486);
                }
            } catch (IOException e3) {
                Object inputStreamReader2 = uri2;
                Utility.closeQuietly(inputStreamReader2);
                AppMethodBeat.m2505o(72486);
                return uri2;
            } catch (Throwable th3) {
                th = th3;
                closeable = uri2;
                Utility.closeQuietly(closeable);
                AppMethodBeat.m2505o(72486);
                throw th;
            }
        }
        return uri2;
    }

    static void cacheUriRedirect(Uri uri, Uri uri2) {
        AppMethodBeat.m2504i(72487);
        if (uri == null || uri2 == null) {
            AppMethodBeat.m2505o(72487);
            return;
        }
        Closeable closeable = null;
        try {
            closeable = getCache().openPutStream(uri.toString(), REDIRECT_CONTENT_TAG);
            closeable.write(uri2.toString().getBytes());
        } catch (IOException e) {
        } finally {
            Utility.closeQuietly(closeable);
            AppMethodBeat.m2505o(72487);
        }
    }

    static void clearCache() {
        AppMethodBeat.m2504i(72488);
        try {
            getCache().clearCache();
            AppMethodBeat.m2505o(72488);
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
            AppMethodBeat.m2505o(72488);
        }
    }
}
