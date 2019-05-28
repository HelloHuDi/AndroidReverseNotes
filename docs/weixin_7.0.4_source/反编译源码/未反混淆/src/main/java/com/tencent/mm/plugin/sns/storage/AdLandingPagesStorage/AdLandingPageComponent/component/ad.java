package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.content.d;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.net.URI;
import java.net.URISyntaxException;

public final class ad {
    private static Typeface rcc = null;

    public static Bitmap getBitmap(String str) {
        AppMethodBeat.i(37359);
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str2 + "/" + ("adId" + "_image_" + ag.ck(str));
        if (e.ct(str3)) {
            Bitmap i = b.i(str3, 1.0f);
            AppMethodBeat.o(37359);
            return i;
        }
        AppMethodBeat.o(37359);
        return null;
    }

    public static int aY(float f) {
        int i = (int) f;
        if (((double) (f - ((float) i))) > 0.001d) {
            return i + 1;
        }
        return i;
    }

    public static int[] eP(Context context) {
        int i;
        int i2;
        AppMethodBeat.i(37360);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            i = point.x;
            i2 = point.y;
        } else {
            i = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
        }
        int[] iArr = new int[]{i, i2};
        AppMethodBeat.o(37360);
        return iArr;
    }

    public static void ac(Activity activity) {
        AppMethodBeat.i(37361);
        ab.i("LandingPageUtil", "setFullScreen");
        int i = 514;
        if (ae.hD(activity)) {
            ab.i("LandingPageUtil", "has cut out");
        } else {
            i = 1542;
        }
        if (VERSION.SDK_INT >= 19) {
            i |= 4096;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(i);
        AppMethodBeat.o(37361);
    }

    public static void eQ(Context context) {
        AppMethodBeat.i(37362);
        d.S(context).c(new Intent("com.tencent.mm.adlanding.set_uioption"));
        AppMethodBeat.o(37362);
    }

    public static String m(String str, String... strArr) {
        AppMethodBeat.i(37363);
        try {
            URI uri = new URI(str);
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : strArr) {
                stringBuilder.append(append).append("&");
            }
            if (stringBuilder.length() > 1) {
                String stringBuilder2;
                StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                String query = uri.getQuery();
                if (query == null) {
                    stringBuilder2 = deleteCharAt.toString();
                } else {
                    stringBuilder2 = query + "&" + deleteCharAt.toString();
                }
                str = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
                AppMethodBeat.o(37363);
                return str;
            }
        } catch (URISyntaxException e) {
            ab.printErrStackTrace("LandingPageUtil", e, "", new Object[0]);
        }
        AppMethodBeat.o(37363);
        return str;
    }

    public static Typeface eR(Context context) {
        AppMethodBeat.i(37364);
        if (rcc == null) {
            rcc = Typeface.createFromAsset(context.getAssets(), "fonts/WeChatNum.ttf");
        }
        Typeface typeface = rcc;
        AppMethodBeat.o(37364);
        return typeface;
    }

    public static boolean YK(String str) {
        AppMethodBeat.i(37365);
        if (str == null || str.length() < 102400) {
            AppMethodBeat.o(37365);
            return false;
        }
        AppMethodBeat.o(37365);
        return true;
    }

    public static String YL(String str) {
        AppMethodBeat.i(37366);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(37366);
            return str2;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.loader.j.b.eSk.replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            str2 = j.w(new com.tencent.mm.vfs.b(bVar, System.currentTimeMillis()).dMD());
            if (e.b(str2, bytes, bytes.length) == 0) {
                AppMethodBeat.o(37366);
                return str2;
            }
        } catch (Exception e) {
            ab.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
        }
        str2 = "";
        AppMethodBeat.o(37366);
        return str2;
    }

    public static String YM(String str) {
        AppMethodBeat.i(37367);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(37367);
            return str2;
        }
        try {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (bVar.exists()) {
                str2 = e.cy(str);
                bVar.delete();
                AppMethodBeat.o(37367);
                return str2;
            }
            str2 = "";
            AppMethodBeat.o(37367);
            return str2;
        } catch (Exception e) {
            ab.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
            str2 = "";
            AppMethodBeat.o(37367);
            return str2;
        }
    }
}
