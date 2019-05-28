package com.tencent.p177mm.sdk.platformtools;

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

/* renamed from: com.tencent.mm.sdk.platformtools.bc */
public final class C30292bc {
    private static final String[] aEl = new String[]{"_display_name", "_data", "date_added"};
    private static final String xBk = Media.EXTERNAL_CONTENT_URI.toString();
    private static ContentObserver xBl;
    private static WeakReference<C23502a> xBm;

    /* renamed from: com.tencent.mm.sdk.platformtools.bc$a */
    public interface C23502a {
        void aNW();
    }

    /* renamed from: am */
    public static Bitmap m48193am(Activity activity) {
        AppMethodBeat.m2504i(52248);
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
            C4990ab.printErrStackTrace("MicroMsg.ScreenShotUtil", e, "", new Object[0]);
        }
        decorView.destroyDrawingCache();
        AppMethodBeat.m2505o(52248);
        return drawingCache;
    }

    static {
        AppMethodBeat.m2504i(52250);
        AppMethodBeat.m2505o(52250);
    }

    /* renamed from: a */
    public static void m48192a(final Context context, C23502a c23502a) {
        AppMethodBeat.m2504i(52249);
        C4990ab.m7417i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", context, c23502a, C5046bo.dpG());
        if (context == null) {
            AppMethodBeat.m2505o(52249);
        } else if (c23502a == null) {
            if (xBl != null) {
                context.getContentResolver().unregisterContentObserver(xBl);
                xBl = null;
            }
            if (xBm != null) {
                xBm.clear();
                xBm = null;
            }
            AppMethodBeat.m2505o(52249);
        } else {
            xBm = new WeakReference(c23502a);
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
                        AppMethodBeat.m2504i(52247);
                        C4990ab.m7410d("MicroMsg.ScreenShotUtil", "summerscreenshot onChange: " + z + ", uri:" + uri.toString());
                        if (C30292bc.xBm == null || C30292bc.xBm.get() == null) {
                            C4990ab.m7417i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", C30292bc.xBm);
                            context.getContentResolver().unregisterContentObserver(this);
                            C30292bc.xBl = null;
                            if (C30292bc.xBm != null) {
                                C30292bc.xBm.clear();
                                C30292bc.xBm = null;
                            }
                        } else if (uri.toString().matches(C30292bc.xBk) || uri.toString().contains(C30292bc.xBk)) {
                            String string;
                            Cursor query;
                            long j;
                            try {
                                query = context.getContentResolver().query(uri, C30292bc.aEl, null, null, "date_added DESC limit 1");
                                if (query != null) {
                                    try {
                                        if (query.moveToFirst()) {
                                            string = query.getString(query.getColumnIndex("_data"));
                                            j = query.getLong(query.getColumnIndex("date_added"));
                                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                                            C4990ab.m7410d("MicroMsg.ScreenShotUtil", "summerscreenshot path: " + string + ", dateAdded: " + j + ", currentTime: " + currentTimeMillis);
                                            if (Math.abs(currentTimeMillis - j) <= 10 && currentTimeMillis - this.xBn > 1 && !C5046bo.isNullOrNil(string) && (string.toLowerCase().contains("screenshot") || string.contains("截屏") || string.contains("截图"))) {
                                                try {
                                                    this.xBn = currentTimeMillis;
                                                    if (query != null) {
                                                        query.close();
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    try {
                                                        C4990ab.m7420w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + e.getMessage());
                                                        if (query != null) {
                                                            query.close();
                                                        }
                                                        if (!C5046bo.isNullOrNil(string)) {
                                                        }
                                                        super.onChange(z, uri);
                                                        AppMethodBeat.m2505o(52247);
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (query != null) {
                                                        }
                                                        AppMethodBeat.m2505o(52247);
                                                        throw th;
                                                    }
                                                }
                                                if (C5046bo.isNullOrNil(string)) {
                                                    C4990ab.m7416i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + j);
                                                    if (C30292bc.xBm == null || C30292bc.xBm.get() == null) {
                                                        context.getContentResolver().unregisterContentObserver(this);
                                                        C30292bc.xBl = null;
                                                        if (C30292bc.xBm != null) {
                                                            C30292bc.xBm.clear();
                                                            C30292bc.xBm = null;
                                                        }
                                                        C4990ab.m7416i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                                                    } else {
                                                        ((C23502a) C30292bc.xBm.get()).aNW();
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        j = 0;
                                        string = null;
                                        C4990ab.m7420w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + e.getMessage());
                                        if (query != null) {
                                        }
                                        if (C5046bo.isNullOrNil(string)) {
                                        }
                                        super.onChange(z, uri);
                                        AppMethodBeat.m2505o(52247);
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
                                AppMethodBeat.m2505o(52247);
                                throw th;
                            }
                            if (C5046bo.isNullOrNil(string)) {
                            }
                        }
                        super.onChange(z, uri);
                        AppMethodBeat.m2505o(52247);
                    }
                };
                context.getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, xBl);
            }
            AppMethodBeat.m2505o(52249);
        }
    }
}
