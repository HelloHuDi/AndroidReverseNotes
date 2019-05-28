package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class bc {
    private static final String[] aEl = new String[]{"_display_name", "_data", "date_added"};
    private static final String xBk = Media.EXTERNAL_CONTENT_URI.toString();
    private static ContentObserver xBl;
    private static WeakReference<a> xBm;

    public interface a {
        void aNW();
    }

    public static Bitmap am(Activity activity) {
        AppMethodBeat.i(52248);
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        try {
            drawingCache = Bitmap.createBitmap(drawingCache, 0, i, activity.getWindowManager().getDefaultDisplay().getWidth(), activity.getWindowManager().getDefaultDisplay().getHeight() - i);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ScreenShotUtil", e, "", new Object[0]);
        }
        decorView.destroyDrawingCache();
        AppMethodBeat.o(52248);
        return drawingCache;
    }

    static {
        AppMethodBeat.i(52250);
        AppMethodBeat.o(52250);
    }

    public static void a(final Context context, a aVar) {
        AppMethodBeat.i(52249);
        ab.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", context, aVar, bo.dpG());
        if (context == null) {
            AppMethodBeat.o(52249);
        } else if (aVar == null) {
            if (xBl != null) {
                context.getContentResolver().unregisterContentObserver(xBl);
                xBl = null;
            }
            if (xBm != null) {
                xBm.clear();
                xBm = null;
            }
            AppMethodBeat.o(52249);
        } else {
            xBm = new WeakReference(aVar);
            if (xBl == null) {
                xBl = new ContentObserver(new Handler(Looper.myLooper())) {
                    private long xBn;

                    /* JADX WARNING: Removed duplicated region for block: B:35:0x0145  */
                    /* JADX WARNING: Removed duplicated region for block: B:38:0x014e  */
                    /* JADX WARNING: Removed duplicated region for block: B:38:0x014e  */
                    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ae  */
                    /* JADX WARNING: Removed duplicated region for block: B:38:0x014e  */
                    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b6  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void onChange(boolean z, Uri uri) {
                        Exception e;
                        Throwable th;
                        AppMethodBeat.i(52247);
                        ab.d("MicroMsg.ScreenShotUtil", "summerscreenshot onChange: " + z + ", uri:" + uri.toString());
                        if (bc.xBm == null || bc.xBm.get() == null) {
                            ab.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", bc.xBm);
                            context.getContentResolver().unregisterContentObserver(this);
                            bc.xBl = null;
                            if (bc.xBm != null) {
                                bc.xBm.clear();
                                bc.xBm = null;
                            }
                        } else if (uri.toString().matches(bc.xBk) || uri.toString().contains(bc.xBk)) {
                            String string;
                            Cursor query;
                            long j;
                            try {
                                query = context.getContentResolver().query(uri, bc.aEl, null, null, "date_added DESC limit 1");
                                if (query != null) {
                                    try {
                                        if (query.moveToFirst()) {
                                            string = query.getString(query.getColumnIndex("_data"));
                                            j = query.getLong(query.getColumnIndex("date_added"));
                                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                                            ab.d("MicroMsg.ScreenShotUtil", "summerscreenshot path: " + string + ", dateAdded: " + j + ", currentTime: " + currentTimeMillis);
                                            if (Math.abs(currentTimeMillis - j) <= 10 && currentTimeMillis - this.xBn > 1 && !bo.isNullOrNil(string) && (string.toLowerCase().contains("screenshot") || string.contains("截屏") || string.contains("截图"))) {
                                                try {
                                                    this.xBn = currentTimeMillis;
                                                    if (query != null) {
                                                        query.close();
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    try {
                                                        ab.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + e.getMessage());
                                                        if (query != null) {
                                                            query.close();
                                                        }
                                                        if (!bo.isNullOrNil(string)) {
                                                        }
                                                        super.onChange(z, uri);
                                                        AppMethodBeat.o(52247);
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (query != null) {
                                                        }
                                                        AppMethodBeat.o(52247);
                                                        throw th;
                                                    }
                                                }
                                                if (bo.isNullOrNil(string)) {
                                                    ab.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + j);
                                                    if (bc.xBm == null || bc.xBm.get() == null) {
                                                        context.getContentResolver().unregisterContentObserver(this);
                                                        bc.xBl = null;
                                                        if (bc.xBm != null) {
                                                            bc.xBm.clear();
                                                            bc.xBm = null;
                                                        }
                                                        ab.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                                                    } else {
                                                        ((a) bc.xBm.get()).aNW();
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        j = 0;
                                        string = null;
                                        ab.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + e.getMessage());
                                        if (query != null) {
                                        }
                                        if (bo.isNullOrNil(string)) {
                                        }
                                        super.onChange(z, uri);
                                        AppMethodBeat.o(52247);
                                    }
                                }
                                j = 0;
                                string = null;
                                if (query != null) {
                                }
                            } catch (Exception e4) {
                                e = e4;
                                query = null;
                                j = 0;
                                string = null;
                            } catch (Throwable th3) {
                                th = th3;
                                query = null;
                                if (query != null) {
                                    query.close();
                                }
                                AppMethodBeat.o(52247);
                                throw th;
                            }
                            if (bo.isNullOrNil(string)) {
                            }
                        }
                        super.onChange(z, uri);
                        AppMethodBeat.o(52247);
                    }
                };
                context.getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, xBl);
            }
            AppMethodBeat.o(52249);
        }
    }
}
