package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.g */
public final class C29916g {
    private static final HashMap<String, WeakReference<Bitmap>> usl = new HashMap();

    /* renamed from: a */
    public static void m47392a(C46434d c46434d, int i, Object... objArr) {
        AppMethodBeat.m2504i(7480);
        ArrayList arrayList = new ArrayList();
        if (objArr == null || objArr.length == 0) {
            AppMethodBeat.m2505o(7480);
            return;
        }
        try {
            for (Object valueOf : objArr) {
                arrayList.add(String.valueOf(valueOf));
            }
            c46434d.mo15583k(i, arrayList);
            AppMethodBeat.m2505o(7480);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + e.getMessage());
            AppMethodBeat.m2505o(7480);
        }
    }

    /* renamed from: a */
    public static void m47391a(C46434d c46434d, int i, List<String> list) {
        AppMethodBeat.m2504i(7481);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(7481);
            return;
        }
        try {
            c46434d.mo15583k(i, list);
            AppMethodBeat.m2505o(7481);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + e.getMessage());
            AppMethodBeat.m2505o(7481);
        }
    }

    static {
        AppMethodBeat.m2504i(7489);
        AppMethodBeat.m2505o(7489);
    }

    public static Bitmap afx(String str) {
        AppMethodBeat.m2504i(7482);
        WeakReference weakReference = (WeakReference) usl.get(str);
        Bitmap decodeFile;
        if (weakReference == null || weakReference.get() == null || ((Bitmap) weakReference.get()).isRecycled()) {
            if (C5730e.m8628ct(str)) {
                decodeFile = C5056d.decodeFile(str, null);
            } else {
                decodeFile = null;
            }
            if (decodeFile != null) {
                usl.put(str, new WeakReference(decodeFile));
            } else {
                try {
                    decodeFile = C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
                    usl.put(str, new WeakReference(decodeFile));
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(7482);
            return decodeFile;
        }
        decodeFile = (Bitmap) weakReference.get();
        AppMethodBeat.m2505o(7482);
        return decodeFile;
    }

    public static long afy(String str) {
        AppMethodBeat.m2504i(7483);
        long z = C29916g.m47395z(str, -1);
        AppMethodBeat.m2505o(7483);
        return z;
    }

    /* renamed from: bx */
    public static int m47394bx(String str, int i) {
        AppMethodBeat.m2504i(7484);
        int z = (int) C29916g.m47395z(str, (long) i);
        AppMethodBeat.m2505o(7484);
        return z;
    }

    /* renamed from: z */
    private static long m47395z(String str, long j) {
        AppMethodBeat.m2504i(7485);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(7485);
            return j;
        }
        if (str.startsWith("#") && str.length() == 4) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.insert(2, str.charAt(1));
            stringBuilder.insert(4, str.charAt(2));
            stringBuilder.insert(6, str.charAt(3));
            str = stringBuilder.toString();
        }
        try {
            j = 4294967295L & ((long) Color.parseColor(str));
            AppMethodBeat.m2505o(7485);
            return j;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebView.RemoteUtil", "Failed to parse color: %s", str);
            AppMethodBeat.m2505o(7485);
            return j;
        }
    }

    public static Bitmap afz(String str) {
        AppMethodBeat.m2504i(7486);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(7486);
            return null;
        }
        WeakReference weakReference = (WeakReference) usl.get(str);
        Bitmap createScaledBitmap;
        if (weakReference == null || weakReference.get() == null || ((Bitmap) weakReference.get()).isRecycled()) {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null) {
                AppMethodBeat.m2505o(7486);
                return null;
            }
            Bitmap decodeByteArray;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int min = Math.min(options.outWidth, options.outHeight);
            options.inJustDecodeBounds = false;
            if (min > 96) {
                options.inSampleSize = Math.max((int) ((((float) min) * 1.0f) / 96.0f), 1);
                decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                if (decodeByteArray == null) {
                    AppMethodBeat.m2505o(7486);
                    return null;
                }
                i = decodeByteArray.getWidth();
                i2 = decodeByteArray.getHeight();
                min = Math.min(i, i2);
            } else {
                decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                if (decodeByteArray == null) {
                    AppMethodBeat.m2505o(7486);
                    return null;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, Math.max((i / 2) - (min / 2), 0), Math.max((i2 / 2) - (min / 2), 0), min, min);
            if (createBitmap != decodeByteArray) {
                decodeByteArray.recycle();
            }
            createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, 96, 96, false);
            if (createBitmap != createScaledBitmap) {
                C4990ab.m7417i("MicroMsg.WebView.RemoteUtil", "bitmap recycle %s", createBitmap.toString());
                createBitmap.recycle();
            }
            if (!(createScaledBitmap == null || createScaledBitmap.isRecycled())) {
                usl.put(str, new WeakReference(createScaledBitmap));
            }
            AppMethodBeat.m2505o(7486);
            return createScaledBitmap;
        }
        createScaledBitmap = (Bitmap) weakReference.get();
        AppMethodBeat.m2505o(7486);
        return createScaledBitmap;
    }

    /* renamed from: Jj */
    public static int m47390Jj(int i) {
        AppMethodBeat.m2504i(7487);
        int Jj = C5222ae.m7932Jj(i);
        AppMethodBeat.m2505o(7487);
        return Jj;
    }

    /* renamed from: a */
    public static boolean m47393a(Bundle bundle, String str, String str2, C40281e c40281e, Runnable runnable) {
        AppMethodBeat.m2504i(7488);
        if (c40281e == null) {
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.m2505o(7488);
            return true;
        }
        Bundle bundle2 = new Bundle(3);
        bundle2.putBundle("open_ui_with_webview_ui_extras", bundle);
        bundle2.putString("open_ui_with_webview_ui_plugin_name", str);
        bundle2.putString("open_ui_with_webview_ui_plugin_entry", str2);
        try {
            c40281e.mo6226g(101, bundle2);
            AppMethodBeat.m2505o(7488);
            return true;
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", str, str2);
            AppMethodBeat.m2505o(7488);
            return false;
        } catch (Exception e2) {
            if (runnable != null) {
                runnable.run();
            }
            C4990ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e2, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", str, str2);
            AppMethodBeat.m2505o(7488);
            return false;
        }
    }
}
