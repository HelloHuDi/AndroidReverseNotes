package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.p057v4.content.C37116d;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.net.URI;
import java.net.URISyntaxException;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad */
public final class C29064ad {
    private static Typeface rcc = null;

    public static Bitmap getBitmap(String str) {
        AppMethodBeat.m2504i(37359);
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str2 + "/" + ("adId" + "_image_" + C4995ag.m7428ck(str));
        if (C5730e.m8628ct(str3)) {
            Bitmap i = C4977b.m7374i(str3, 1.0f);
            AppMethodBeat.m2505o(37359);
            return i;
        }
        AppMethodBeat.m2505o(37359);
        return null;
    }

    /* renamed from: aY */
    public static int m46204aY(float f) {
        int i = (int) f;
        if (((double) (f - ((float) i))) > 0.001d) {
            return i + 1;
        }
        return i;
    }

    /* renamed from: eP */
    public static int[] m46206eP(Context context) {
        int i;
        int i2;
        AppMethodBeat.m2504i(37360);
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
        AppMethodBeat.m2505o(37360);
        return iArr;
    }

    /* renamed from: ac */
    public static void m46205ac(Activity activity) {
        AppMethodBeat.m2504i(37361);
        C4990ab.m7416i("LandingPageUtil", "setFullScreen");
        int i = 514;
        if (C5222ae.m7950hD(activity)) {
            C4990ab.m7416i("LandingPageUtil", "has cut out");
        } else {
            i = 1542;
        }
        if (VERSION.SDK_INT >= 19) {
            i |= 4096;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(i);
        AppMethodBeat.m2505o(37361);
    }

    /* renamed from: eQ */
    public static void m46207eQ(Context context) {
        AppMethodBeat.m2504i(37362);
        C37116d.m62125S(context).mo59172c(new Intent("com.tencent.mm.adlanding.set_uioption"));
        AppMethodBeat.m2505o(37362);
    }

    /* renamed from: m */
    public static String m46209m(String str, String... strArr) {
        AppMethodBeat.m2504i(37363);
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
                AppMethodBeat.m2505o(37363);
                return str;
            }
        } catch (URISyntaxException e) {
            C4990ab.printErrStackTrace("LandingPageUtil", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(37363);
        return str;
    }

    /* renamed from: eR */
    public static Typeface m46208eR(Context context) {
        AppMethodBeat.m2504i(37364);
        if (rcc == null) {
            rcc = Typeface.createFromAsset(context.getAssets(), "fonts/WeChatNum.ttf");
        }
        Typeface typeface = rcc;
        AppMethodBeat.m2505o(37364);
        return typeface;
    }

    /* renamed from: YK */
    public static boolean m46201YK(String str) {
        AppMethodBeat.m2504i(37365);
        if (str == null || str.length() < 102400) {
            AppMethodBeat.m2505o(37365);
            return false;
        }
        AppMethodBeat.m2505o(37365);
        return true;
    }

    /* renamed from: YL */
    public static String m46202YL(String str) {
        AppMethodBeat.m2504i(37366);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(37366);
            return str2;
        }
        C5728b c5728b = new C5728b(C1761b.eSk.replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            str2 = C5736j.m8649w(new C5728b(c5728b, System.currentTimeMillis()).dMD());
            if (C5730e.m8624b(str2, bytes, bytes.length) == 0) {
                AppMethodBeat.m2505o(37366);
                return str2;
            }
        } catch (Exception e) {
            C4990ab.m7412e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
        }
        str2 = "";
        AppMethodBeat.m2505o(37366);
        return str2;
    }

    /* renamed from: YM */
    public static String m46203YM(String str) {
        AppMethodBeat.m2504i(37367);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(37367);
            return str2;
        }
        try {
            C5728b c5728b = new C5728b(str);
            if (c5728b.exists()) {
                str2 = C5730e.m8631cy(str);
                c5728b.delete();
                AppMethodBeat.m2505o(37367);
                return str2;
            }
            str2 = "";
            AppMethodBeat.m2505o(37367);
            return str2;
        } catch (Exception e) {
            C4990ab.m7412e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
            str2 = "";
            AppMethodBeat.m2505o(37367);
            return str2;
        }
    }
}
