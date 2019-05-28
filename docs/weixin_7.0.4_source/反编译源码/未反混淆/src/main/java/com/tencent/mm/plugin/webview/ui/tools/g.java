package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.vfs.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class g {
    private static final HashMap<String, WeakReference<Bitmap>> usl = new HashMap();

    public static void a(d dVar, int i, Object... objArr) {
        AppMethodBeat.i(7480);
        ArrayList arrayList = new ArrayList();
        if (objArr == null || objArr.length == 0) {
            AppMethodBeat.o(7480);
            return;
        }
        try {
            for (Object valueOf : objArr) {
                arrayList.add(String.valueOf(valueOf));
            }
            dVar.k(i, arrayList);
            AppMethodBeat.o(7480);
        } catch (Exception e) {
            ab.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + e.getMessage());
            AppMethodBeat.o(7480);
        }
    }

    public static void a(d dVar, int i, List<String> list) {
        AppMethodBeat.i(7481);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(7481);
            return;
        }
        try {
            dVar.k(i, list);
            AppMethodBeat.o(7481);
        } catch (Exception e) {
            ab.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + e.getMessage());
            AppMethodBeat.o(7481);
        }
    }

    static {
        AppMethodBeat.i(7489);
        AppMethodBeat.o(7489);
    }

    public static Bitmap afx(String str) {
        AppMethodBeat.i(7482);
        WeakReference weakReference = (WeakReference) usl.get(str);
        Bitmap decodeFile;
        if (weakReference == null || weakReference.get() == null || ((Bitmap) weakReference.get()).isRecycled()) {
            if (e.ct(str)) {
                decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
            } else {
                decodeFile = null;
            }
            if (decodeFile != null) {
                usl.put(str, new WeakReference(decodeFile));
            } else {
                try {
                    decodeFile = b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
                    usl.put(str, new WeakReference(decodeFile));
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(7482);
            return decodeFile;
        }
        decodeFile = (Bitmap) weakReference.get();
        AppMethodBeat.o(7482);
        return decodeFile;
    }

    public static long afy(String str) {
        AppMethodBeat.i(7483);
        long z = z(str, -1);
        AppMethodBeat.o(7483);
        return z;
    }

    public static int bx(String str, int i) {
        AppMethodBeat.i(7484);
        int z = (int) z(str, (long) i);
        AppMethodBeat.o(7484);
        return z;
    }

    private static long z(String str, long j) {
        AppMethodBeat.i(7485);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(7485);
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
            AppMethodBeat.o(7485);
            return j;
        } catch (Exception e) {
            ab.e("MicroMsg.WebView.RemoteUtil", "Failed to parse color: %s", str);
            AppMethodBeat.o(7485);
            return j;
        }
    }

    public static Bitmap afz(String str) {
        AppMethodBeat.i(7486);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(7486);
            return null;
        }
        WeakReference weakReference = (WeakReference) usl.get(str);
        Bitmap createScaledBitmap;
        if (weakReference == null || weakReference.get() == null || ((Bitmap) weakReference.get()).isRecycled()) {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null) {
                AppMethodBeat.o(7486);
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
                    AppMethodBeat.o(7486);
                    return null;
                }
                i = decodeByteArray.getWidth();
                i2 = decodeByteArray.getHeight();
                min = Math.min(i, i2);
            } else {
                decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                if (decodeByteArray == null) {
                    AppMethodBeat.o(7486);
                    return null;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, Math.max((i / 2) - (min / 2), 0), Math.max((i2 / 2) - (min / 2), 0), min, min);
            if (createBitmap != decodeByteArray) {
                decodeByteArray.recycle();
            }
            createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, 96, 96, false);
            if (createBitmap != createScaledBitmap) {
                ab.i("MicroMsg.WebView.RemoteUtil", "bitmap recycle %s", createBitmap.toString());
                createBitmap.recycle();
            }
            if (!(createScaledBitmap == null || createScaledBitmap.isRecycled())) {
                usl.put(str, new WeakReference(createScaledBitmap));
            }
            AppMethodBeat.o(7486);
            return createScaledBitmap;
        }
        createScaledBitmap = (Bitmap) weakReference.get();
        AppMethodBeat.o(7486);
        return createScaledBitmap;
    }

    public static int Jj(int i) {
        AppMethodBeat.i(7487);
        int Jj = ae.Jj(i);
        AppMethodBeat.o(7487);
        return Jj;
    }

    public static boolean a(Bundle bundle, String str, String str2, com.tencent.mm.plugin.webview.stub.e eVar, Runnable runnable) {
        AppMethodBeat.i(7488);
        if (eVar == null) {
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.o(7488);
            return true;
        }
        Bundle bundle2 = new Bundle(3);
        bundle2.putBundle("open_ui_with_webview_ui_extras", bundle);
        bundle2.putString("open_ui_with_webview_ui_plugin_name", str);
        bundle2.putString("open_ui_with_webview_ui_plugin_entry", str2);
        try {
            eVar.g(101, bundle2);
            AppMethodBeat.o(7488);
            return true;
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", str, str2);
            AppMethodBeat.o(7488);
            return false;
        } catch (Exception e2) {
            if (runnable != null) {
                runnable.run();
            }
            ab.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e2, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", str, str2);
            AppMethodBeat.o(7488);
            return false;
        }
    }
}
