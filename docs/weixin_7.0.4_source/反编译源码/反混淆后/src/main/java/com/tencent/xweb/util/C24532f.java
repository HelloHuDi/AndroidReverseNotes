package com.tencent.xweb.util;

import android.content.SharedPreferences;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24699w;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.xweb.C24531u;
import com.tencent.xweb.C41128i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.util.f */
public final class C24532f {
    public static String AMN = "";
    private static boolean AQh = false;
    static C44570d AQi = C44570d.WV_KIND_NONE;
    static C24531u AQj = null;
    static boolean AQk = false;
    public static String cvF = "";

    /* renamed from: g */
    public static void m38174g(C44570d c44570d) {
        AQi = c44570d;
    }

    private static boolean dUK() {
        AppMethodBeat.m2504i(4024);
        if (AQi != C44570d.WV_KIND_CW || WebView.getCurWebType() == AQi) {
            AppMethodBeat.m2505o(4024);
            return false;
        }
        AppMethodBeat.m2505o(4024);
        return true;
    }

    private static boolean dUL() {
        AppMethodBeat.m2504i(4025);
        if (WebView.getCurWebType() != C44570d.WV_KIND_CW || WebView.getCurWebType() == AQi) {
            AppMethodBeat.m2505o(4025);
            return false;
        }
        AppMethodBeat.m2505o(4025);
        return true;
    }

    public static void avn(String str) {
        if (str != null) {
            AMN = str;
        }
    }

    /* renamed from: ij */
    private static void m38177ij(int i, int i2) {
        AppMethodBeat.m2504i(4026);
        if (AQj == null) {
            AppMethodBeat.m2505o(4026);
            return;
        }
        SharedPreferences mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
        String str = "id_" + i + "_key_" + i2;
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (format.equals(mMKVSharedTransportOld.getString(str, ""))) {
            AppMethodBeat.m2505o(4026);
            return;
        }
        AQj.mo4776k((long) i, (long) i2, 1);
        mMKVSharedTransportOld.edit().putString(str, format).commit();
        AppMethodBeat.m2505o(4026);
    }

    /* renamed from: h */
    public static void m38175h(C44570d c44570d) {
        AppMethodBeat.m2504i(4027);
        if (AQj == null) {
            AppMethodBeat.m2505o(4027);
            return;
        }
        String str;
        Object obj;
        if ((c44570d == C44570d.WV_KIND_CW ? 1 : 0) != 0) {
            str = "REPORT_APK_VER_TIME";
        } else {
            str = "REPORT_APK_VER_TIME_".concat(String.valueOf(c44570d));
        }
        String str2 = "REPORT_XWEB_APK_VER";
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String string = XWalkEnvironment.getSharedPreferences().getString(str, "");
        if (string == null) {
            obj = "";
        } else {
            String obj2 = string;
        }
        if (c44570d == C44570d.WV_KIND_CW) {
            int i = XWalkEnvironment.getSharedPreferences().getInt(str2, 0);
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion <= 0) {
                AppMethodBeat.m2505o(4027);
                return;
            } else if (!(availableVersion == i && format.equals(obj2))) {
                AQj.mo4776k(577, (long) ((availableVersion % 50) + 100), 1);
                XWalkEnvironment.getSharedPreferences().edit().putInt(str2, availableVersion).commit();
            }
        }
        if (format.equals(obj2)) {
            AppMethodBeat.m2505o(4027);
            return;
        }
        int i2;
        if (c44570d == C44570d.WV_KIND_CW) {
            if (XWalkEnvironment.getAvailableVersion() <= 0) {
                AppMethodBeat.m2505o(4027);
                return;
            }
            i2 = 99;
        } else if (c44570d == C44570d.WV_KIND_SYS) {
            i2 = 97;
        } else if (c44570d == C44570d.WV_KIND_X5) {
            i2 = 98;
        } else {
            AppMethodBeat.m2505o(4027);
            return;
        }
        AQj.mo4776k(577, (long) i2, 1);
        XWalkEnvironment.getSharedPreferences().edit().putString(str, format).commit();
        AppMethodBeat.m2505o(4027);
    }

    /* renamed from: a */
    public static void m38168a(C24531u c24531u) {
        AQj = c24531u;
    }

    /* renamed from: bX */
    public static void m38172bX(int i, String str) {
        AppMethodBeat.m2504i(4028);
        if (AQj != null) {
            AQj.mo4773X(i, str);
        }
        AppMethodBeat.m2505o(4028);
    }

    /* renamed from: nI */
    public static void m38181nI(long j) {
        AppMethodBeat.m2504i(4029);
        if (AQj != null) {
            AQj.mo4776k(577, j, 1);
        }
        AppMethodBeat.m2505o(4029);
    }

    /* renamed from: n */
    public static void m38180n(long j, long j2, long j3) {
        AppMethodBeat.m2504i(4030);
        if (AQj != null) {
            AQj.mo4776k(j, j2, j3);
        }
        AppMethodBeat.m2505o(4030);
    }

    public static void avo(String str) {
        int i = 73;
        AppMethodBeat.m2504i(4031);
        if (AQj != null) {
            AQj.mo4776k(577, 0, 1);
            if (AMN.equals("toolsmp") && str != null && C24532f.avq(str) == 2) {
                AQj.mo4776k(903, 101, 1);
            }
            if (AMN.equals("toolsmp")) {
                if (WebView.getCurWebType() == C44570d.WV_KIND_CW) {
                    AQj.mo4776k(903, 105, 1);
                } else if (WebView.getCurWebType() == C44570d.WV_KIND_X5) {
                    AQj.mo4776k(903, 104, 1);
                }
            } else if (AMN.equals("tools") && str != null && C24532f.avq(str) == 1) {
                AQj.mo4776k(903, 103, 1);
            }
            if (!AQh) {
                if (AMN.equals("tools")) {
                    i = 70;
                } else if (!(AMN.equals("appbrand") || AMN.equals("support"))) {
                    i = -1;
                }
                int ordinal = WebView.getCurWebType().ordinal() - 1;
                if (i >= 70 && ordinal >= 0) {
                    AQh = true;
                    C24532f.m38177ij(C24699w.CTRL_INDEX, i + ordinal);
                }
            }
        }
        AppMethodBeat.m2505o(4031);
    }

    private static int dUM() {
        AppMethodBeat.m2504i(4032);
        int i = -1;
        if (AMN.equals("mm")) {
            i = 30;
        } else if (AMN.equals("tools")) {
            i = 36;
        } else if (AMN.equals("toolsmp")) {
            i = 42;
        } else if (AMN.equals("appbrand")) {
            i = 48;
        } else if (AMN.equals("support")) {
            i = 54;
        }
        AppMethodBeat.m2505o(4032);
        return i;
    }

    public static synchronized void avp(String str) {
        synchronized (C24532f.class) {
            AppMethodBeat.m2504i(4033);
            if (AQj == null) {
                AppMethodBeat.m2505o(4033);
            } else {
                int dUM;
                int ordinal;
                if (!AQk) {
                    if ("toolsmp".equals(AMN)) {
                        if (C24532f.dUK()) {
                            C24532f.m38177ij(C1625i.SCENE_BIZ_SCROLL, 106);
                        } else if (C24532f.dUL()) {
                            C24532f.m38177ij(C1625i.SCENE_BIZ_SCROLL, 108);
                        }
                    }
                    dUM = C24532f.dUM();
                    ordinal = WebView.getCurWebType().ordinal() - 1;
                    if (dUM >= 30 && ordinal >= 0) {
                        AQk = true;
                        C24532f.m38177ij(C1625i.SCENE_BIZ_SCROLL, (dUM + 3) + ordinal);
                    }
                }
                if (str != null && "https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(str.trim())) {
                    AQj.mo4776k(903, 102, 1);
                }
                dUM = C24532f.dUM();
                ordinal = WebView.getCurWebType().ordinal() - 1;
                if (dUM >= 30 && ordinal >= 0) {
                    AQj.mo4776k(903, (long) ((dUM + 0) + ordinal), 1);
                }
                if ("toolsmp".equals(AMN)) {
                    if (C24532f.dUK()) {
                        AQj.mo4776k(903, 107, 1);
                        AppMethodBeat.m2505o(4033);
                    } else if (C24532f.dUL()) {
                        AQj.mo4776k(903, 109, 1);
                    }
                }
                AppMethodBeat.m2505o(4033);
            }
        }
    }

    public static void dUN() {
        AppMethodBeat.m2504i(4034);
        if (AQj != null) {
            AQj.mo4776k(577, 1, 1);
        }
        AppMethodBeat.m2505o(4034);
    }

    /* renamed from: nJ */
    public static void m38182nJ(long j) {
        AppMethodBeat.m2504i(4035);
        if (AQj != null && j > 0 && j < 300000) {
            AQj.mo4775aG(2, 3, (int) j);
        }
        AppMethodBeat.m2505o(4035);
    }

    public static void dUO() {
        AppMethodBeat.m2504i(4036);
        if (AQj != null) {
            AQj.mo4776k(577, 46, 1);
        }
        AppMethodBeat.m2505o(4036);
    }

    public static void dUP() {
        AppMethodBeat.m2504i(4037);
        if (AQj != null) {
            AQj.mo4776k(577, 47, 1);
        }
        AppMethodBeat.m2505o(4037);
    }

    /* renamed from: nK */
    public static void m38183nK(long j) {
        AppMethodBeat.m2504i(4038);
        if (AQj != null && j > 0 && j < 300000) {
            AQj.mo4775aG(48, 49, (int) j);
        }
        AppMethodBeat.m2505o(4038);
    }

    public static void dUQ() {
        AppMethodBeat.m2504i(4039);
        if (AQj != null) {
            AQj.mo4776k(577, 42, 1);
        }
        AppMethodBeat.m2505o(4039);
    }

    public static void dUR() {
        AppMethodBeat.m2504i(4040);
        if (AQj != null) {
            AQj.mo4776k(577, 43, 1);
        }
        AppMethodBeat.m2505o(4040);
    }

    /* renamed from: nL */
    public static void m38184nL(long j) {
        AppMethodBeat.m2504i(4041);
        if (AQj != null && j > 0 && j < 300000) {
            AQj.mo4775aG(44, 45, (int) j);
        }
        AppMethodBeat.m2505o(4041);
    }

    /* renamed from: eV */
    public static void m38173eV(String str, int i) {
        AppMethodBeat.m2504i(4042);
        if (AQj != null) {
            C24532f.avo(str);
            cvF = UUID.randomUUID().toString().replace("-", "");
            AQj.mo4776k(577, 4, 1);
            AQj.mo4774a(XWalkEnvironment.getAvailableVersion(), C24532f.avq(str), cvF, C41128i.dTU() == null ? 100 : C41128i.dTU().ordinal(), 0, 0, 0, i);
        }
        AppMethodBeat.m2505o(4042);
    }

    /* renamed from: b */
    public static void m38171b(String str, int i, long j, int i2) {
        AppMethodBeat.m2504i(4043);
        if (AQj != null) {
            C24532f.dUN();
            AQj.mo4776k(577, 5, 1);
            AQj.mo4773X(15003, "");
            AQj.mo4774a(XWalkEnvironment.getAvailableVersion(), C24532f.avq(str), cvF, C41128i.dTU() == null ? 100 : C41128i.dTU().ordinal(), 1, i, (int) j, i2);
        }
        AppMethodBeat.m2505o(4043);
    }

    /* renamed from: q */
    public static void m38189q(String str, long j, int i) {
        AppMethodBeat.m2504i(4044);
        C24532f.m38182nJ(j);
        if (AQj != null && j > 0 && j < 300000) {
            AQj.mo4775aG(6, 7, (int) j);
            AQj.mo4774a(XWalkEnvironment.getAvailableVersion(), C24532f.avq(str), cvF, C41128i.dTU() == null ? 100 : C41128i.dTU().ordinal(), 1, 0, (int) j, i);
        }
        AppMethodBeat.m2505o(4044);
    }

    public static int avq(String str) {
        AppMethodBeat.m2504i(4045);
        if (str.startsWith("https://servicewechat.com/")) {
            AppMethodBeat.m2505o(4045);
            return 0;
        } else if (str.startsWith("http://mp.weixin.qq.com/") || str.startsWith("https://mp.weixin.qq.com/") || str.startsWith("https://servicewechat.com/preload/") || str.startsWith("http://mp.weixinbridge.com/")) {
            AppMethodBeat.m2505o(4045);
            return 1;
        } else {
            AppMethodBeat.m2505o(4045);
            return 2;
        }
    }

    public static void dUS() {
        AppMethodBeat.m2504i(4046);
        if (AQj != null) {
            AQj.mo4776k(577, 52, 1);
        }
        AppMethodBeat.m2505o(4046);
    }

    public static void dUT() {
        AppMethodBeat.m2504i(4047);
        if (AQj != null) {
            AQj.mo4776k(577, 53, 1);
        }
        AppMethodBeat.m2505o(4047);
    }

    public static void dUU() {
        AppMethodBeat.m2504i(4048);
        if (AQj != null) {
            AQj.mo4776k(577, 54, 1);
        }
        AppMethodBeat.m2505o(4048);
    }

    public static void dUV() {
        AppMethodBeat.m2504i(4049);
        if (AQj != null) {
            AQj.mo4776k(577, 55, 1);
        }
        AppMethodBeat.m2505o(4049);
    }

    public static void dUW() {
        AppMethodBeat.m2504i(4050);
        if (AQj != null) {
            AQj.mo4776k(577, 56, 1);
        }
        AppMethodBeat.m2505o(4050);
    }

    public static void dUX() {
        AppMethodBeat.m2504i(4051);
        if (AQj != null) {
            AQj.mo4776k(577, 57, 1);
        }
        AppMethodBeat.m2505o(4051);
    }

    public static void dUY() {
        AppMethodBeat.m2504i(4052);
        if (AQj != null) {
            AQj.mo4776k(577, 58, 1);
        }
        AppMethodBeat.m2505o(4052);
    }

    public static void dUZ() {
        AppMethodBeat.m2504i(4053);
        if (AQj != null) {
            AQj.mo4776k(577, 59, 1);
        }
        AppMethodBeat.m2505o(4053);
    }

    /* renamed from: aK */
    public static void m38169aK(int i, boolean z) {
        AppMethodBeat.m2504i(4054);
        if (AQj != null) {
            int i2 = 0;
            switch (i) {
                case 0:
                    if (!z) {
                        i2 = JsApiGetBackgroundAudioState.CTRL_INDEX;
                        break;
                    } else {
                        i2 = ErrorCode.STARTDOWNLOAD_4;
                        break;
                    }
                case 1:
                    if (!z) {
                        i2 = 160;
                        break;
                    } else {
                        i2 = ErrorCode.STARTDOWNLOAD_5;
                        break;
                    }
                case 2:
                    if (!z) {
                        i2 = 161;
                        break;
                    } else {
                        i2 = ErrorCode.STARTDOWNLOAD_6;
                        break;
                    }
                case 3:
                    if (!z) {
                        i2 = ErrorCode.STARTDOWNLOAD_3;
                        break;
                    } else {
                        i2 = 166;
                        break;
                    }
            }
            if (i2 > 0) {
                AQj.mo4776k(577, (long) i2, 1);
            }
        }
        AppMethodBeat.m2505o(4054);
    }

    /* renamed from: aL */
    public static void m38170aL(int i, boolean z) {
        AppMethodBeat.m2504i(4055);
        if (AQj != null) {
            int i2 = 0;
            switch (i) {
                case 0:
                    if (!z) {
                        i2 = 151;
                        break;
                    } else {
                        i2 = 155;
                        break;
                    }
                case 1:
                    if (!z) {
                        i2 = 152;
                        break;
                    } else {
                        i2 = 156;
                        break;
                    }
                case 2:
                    if (!z) {
                        i2 = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
                        break;
                    } else {
                        i2 = 157;
                        break;
                    }
                case 3:
                    if (!z) {
                        i2 = JsApiMakeVoIPCall.CTRL_INDEX;
                        break;
                    } else {
                        i2 = 158;
                        break;
                    }
            }
            if (i2 > 0) {
                AQj.mo4776k(577, (long) i2, 1);
            }
        }
        AppMethodBeat.m2505o(4055);
    }

    public static void dVa() {
        AppMethodBeat.m2504i(4056);
        if (AQj != null) {
            AQj.mo4776k(577, 167, 1);
        }
        AppMethodBeat.m2505o(4056);
    }

    public static void dVb() {
        AppMethodBeat.m2504i(4057);
        if (AQj != null) {
            AQj.mo4776k(577, 9, 1);
        }
        AppMethodBeat.m2505o(4057);
    }

    /* renamed from: nM */
    public static void m38185nM(long j) {
        AppMethodBeat.m2504i(4058);
        if (AQj != null && AQj != null && j > 0 && j < 600000) {
            AQj.mo4775aG(11, 12, (int) j);
        }
        AppMethodBeat.m2505o(4058);
    }

    public static void dVc() {
        AppMethodBeat.m2504i(4059);
        if (AQj != null) {
            AQj.mo4776k(577, 10, 1);
        }
        AppMethodBeat.m2505o(4059);
    }

    public static void dVd() {
        AppMethodBeat.m2504i(4060);
        if (AQj != null) {
            AQj.mo4776k(577, 60, 1);
        }
        AppMethodBeat.m2505o(4060);
    }

    /* renamed from: i */
    public static void m38176i(C44570d c44570d) {
        AppMethodBeat.m2504i(4061);
        if (AQj == null) {
            AppMethodBeat.m2505o(4061);
            return;
        }
        if (c44570d == C44570d.WV_KIND_CW) {
            AQj.mo4776k(577, 61, 1);
            C24532f.m38177ij(C24699w.CTRL_INDEX, 62);
        }
        AppMethodBeat.m2505o(4061);
    }

    public static void dVe() {
        AppMethodBeat.m2504i(4062);
        if (AQj != null) {
            AQj.mo4776k(577, 20, 1);
        }
        AppMethodBeat.m2505o(4062);
    }

    /* renamed from: nN */
    public static void m38186nN(long j) {
        AppMethodBeat.m2504i(4063);
        if (AQj != null && AQj != null && j > 0 && j < 600000) {
            AQj.mo4775aG(22, 23, (int) j);
        }
        AppMethodBeat.m2505o(4063);
    }

    public static void dVf() {
        AppMethodBeat.m2504i(4064);
        if (AQj != null) {
            AQj.mo4776k(577, 21, 1);
        }
        AppMethodBeat.m2505o(4064);
    }

    public static void aHn() {
        AppMethodBeat.m2504i(4065);
        if (AQj != null) {
            AQj.mo4776k(577, 25, 1);
        }
        AppMethodBeat.m2505o(4065);
    }

    /* renamed from: nO */
    public static void m38187nO(long j) {
        AppMethodBeat.m2504i(4066);
        if (AQj != null && AQj != null && j > 0 && j < 600000) {
            AQj.mo4775aG(27, 28, (int) j);
        }
        AppMethodBeat.m2505o(4066);
    }

    public static void dVg() {
        AppMethodBeat.m2504i(4067);
        if (AQj != null) {
            AQj.mo4776k(577, 26, 1);
        }
        AppMethodBeat.m2505o(4067);
    }

    public static void dVh() {
        AppMethodBeat.m2504i(4068);
        if (AQj != null) {
            AQj.mo4776k(577, 14, 1);
        }
        AppMethodBeat.m2505o(4068);
    }

    public static void dVi() {
        AppMethodBeat.m2504i(4069);
        if (AQj != null) {
            AQj.mo4776k(577, 15, 1);
        }
        AppMethodBeat.m2505o(4069);
    }

    /* renamed from: nP */
    public static void m38188nP(long j) {
        AppMethodBeat.m2504i(4070);
        if (AQj != null && AQj != null && j > 0 && j < 120000) {
            AQj.mo4775aG(16, 17, (int) j);
        }
        AppMethodBeat.m2505o(4070);
    }

    public static void dVj() {
        AppMethodBeat.m2504i(4071);
        if (AQj == null) {
            AppMethodBeat.m2505o(4071);
            return;
        }
        AQj.mo4776k(577, 83, 1);
        AppMethodBeat.m2505o(4071);
    }

    /* renamed from: j */
    public static void m38178j(C44570d c44570d) {
        AppMethodBeat.m2504i(4072);
        if (AQj == null) {
            AppMethodBeat.m2505o(4072);
            return;
        }
        int i;
        switch (c44570d) {
            case WV_KIND_CW:
                i = 82;
                break;
            case WV_KIND_X5:
                i = 81;
                break;
            case WV_KIND_SYS:
                i = 80;
                break;
            default:
                AppMethodBeat.m2505o(4072);
                return;
        }
        AQj.mo4776k(577, (long) i, 1);
        AppMethodBeat.m2505o(4072);
    }

    public static void dVk() {
        AppMethodBeat.m2504i(4073);
        if (AQj == null) {
            AppMethodBeat.m2505o(4073);
            return;
        }
        AQj.mo4776k(577, 87, 1);
        AppMethodBeat.m2505o(4073);
    }

    /* renamed from: k */
    public static void m38179k(C44570d c44570d) {
        AppMethodBeat.m2504i(4074);
        if (AQj == null) {
            AppMethodBeat.m2505o(4074);
            return;
        }
        int i;
        switch (c44570d) {
            case WV_KIND_CW:
                i = 86;
                break;
            case WV_KIND_X5:
                i = 85;
                break;
            case WV_KIND_SYS:
                i = 84;
                break;
            default:
                AppMethodBeat.m2505o(4074);
                return;
        }
        AQj.mo4776k(577, (long) i, 1);
        AppMethodBeat.m2505o(4074);
    }

    public static void dVl() {
        AppMethodBeat.m2504i(4075);
        if (AQj != null) {
            AQj.mo4776k(577, 180, 1);
        }
        AppMethodBeat.m2505o(4075);
    }

    public static void dVm() {
        AppMethodBeat.m2504i(4076);
        if (AQj != null) {
            AQj.mo4776k(577, 181, 1);
        }
        AppMethodBeat.m2505o(4076);
    }

    public static void dVn() {
        AppMethodBeat.m2504i(4077);
        if (AQj != null) {
            AQj.mo4776k(577, 182, 1);
        }
        AppMethodBeat.m2505o(4077);
    }

    public static void dVo() {
        AppMethodBeat.m2504i(4078);
        if (AQj != null) {
            AQj.mo4776k(577, 183, 1);
        }
        AppMethodBeat.m2505o(4078);
    }

    public static void dVp() {
        AppMethodBeat.m2504i(4079);
        if (AQj != null) {
            AQj.mo4776k(577, 184, 1);
        }
        AppMethodBeat.m2505o(4079);
    }

    public static void dVq() {
        AppMethodBeat.m2504i(4080);
        if (AQj != null) {
            AQj.mo4776k(577, 185, 1);
        }
        AppMethodBeat.m2505o(4080);
    }

    public static void dVr() {
        AppMethodBeat.m2504i(4081);
        if (AQj != null) {
            AQj.mo4776k(577, 186, 1);
        }
        AppMethodBeat.m2505o(4081);
    }

    public static void dVs() {
        AppMethodBeat.m2504i(4082);
        if (AQj != null) {
            AQj.mo4776k(577, 187, 1);
        }
        AppMethodBeat.m2505o(4082);
    }

    public static void dVt() {
        AppMethodBeat.m2504i(4083);
        if (AQj != null) {
            AQj.mo4776k(577, 188, 1);
        }
        AppMethodBeat.m2505o(4083);
    }

    public static void dVu() {
        AppMethodBeat.m2504i(4084);
        if (AQj != null) {
            AQj.mo4776k(577, 189, 1);
        }
        AppMethodBeat.m2505o(4084);
    }

    public static void dVv() {
        AppMethodBeat.m2504i(4085);
        if (AQj != null) {
            AQj.mo4776k(577, 190, 1);
        }
        AppMethodBeat.m2505o(4085);
    }

    public static void dVw() {
        AppMethodBeat.m2504i(4086);
        if (AQj == null) {
            AppMethodBeat.m2505o(4086);
            return;
        }
        AQj.mo4776k(577, 88, 1);
        AppMethodBeat.m2505o(4086);
    }

    /* renamed from: Sw */
    public static boolean m38166Sw(int i) {
        return i == 15625 || i == 15626;
    }

    public static boolean hasInit() {
        return AQj != null;
    }

    /* renamed from: Sx */
    public static void m38167Sx(int i) {
        AppMethodBeat.m2504i(4087);
        if ("toolsmp".equals(AMN)) {
            int i2;
            if (WebView.getCurWebType() == C44570d.WV_KIND_CW) {
                i2 = 200;
            } else if (WebView.getCurWebType() == C44570d.WV_KIND_X5) {
                i2 = 220;
            } else {
                AppMethodBeat.m2505o(4087);
                return;
            }
            if (i < 0) {
                i = 3;
            } else if (i > 9) {
                i = 4;
            }
            C24532f.m38180n(903, (long) (i2 + i), 1);
            AppMethodBeat.m2505o(4087);
            return;
        }
        AppMethodBeat.m2505o(4087);
    }

    /* renamed from: rB */
    public static void m38190rB(boolean z) {
        AppMethodBeat.m2504i(4088);
        if ("toolsmp".equals(AMN)) {
            int i;
            int i2;
            if (z) {
                i = 0;
            } else {
                i = 1;
            }
            if (WebView.getCurWebType() == C44570d.WV_KIND_CW) {
                i2 = 180;
            } else if (WebView.getCurWebType() == C44570d.WV_KIND_X5) {
                i2 = FacebookRequestErrorClassification.EC_INVALID_TOKEN;
            } else {
                AppMethodBeat.m2505o(4088);
                return;
            }
            C24532f.m38180n(903, (long) (i + i2), 1);
            AppMethodBeat.m2505o(4088);
            return;
        }
        AppMethodBeat.m2505o(4088);
    }

    public static void dVx() {
        AppMethodBeat.m2504i(138352);
        C24532f.m38180n(938, 89, 1);
        AppMethodBeat.m2505o(138352);
    }

    public static void dVy() {
        AppMethodBeat.m2504i(138353);
        C24532f.m38180n(938, 90, 1);
        AppMethodBeat.m2505o(138353);
    }

    public static void dVz() {
        AppMethodBeat.m2504i(138354);
        C24532f.m38180n(938, 91, 1);
        AppMethodBeat.m2505o(138354);
    }
}
