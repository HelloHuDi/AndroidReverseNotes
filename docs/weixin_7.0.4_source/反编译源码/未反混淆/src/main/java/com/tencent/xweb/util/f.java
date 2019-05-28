package com.tencent.xweb.util;

import android.content.SharedPreferences;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

public final class f {
    public static String AMN = "";
    private static boolean AQh = false;
    static d AQi = d.WV_KIND_NONE;
    static u AQj = null;
    static boolean AQk = false;
    public static String cvF = "";

    public static void g(d dVar) {
        AQi = dVar;
    }

    private static boolean dUK() {
        AppMethodBeat.i(4024);
        if (AQi != d.WV_KIND_CW || WebView.getCurWebType() == AQi) {
            AppMethodBeat.o(4024);
            return false;
        }
        AppMethodBeat.o(4024);
        return true;
    }

    private static boolean dUL() {
        AppMethodBeat.i(4025);
        if (WebView.getCurWebType() != d.WV_KIND_CW || WebView.getCurWebType() == AQi) {
            AppMethodBeat.o(4025);
            return false;
        }
        AppMethodBeat.o(4025);
        return true;
    }

    public static void avn(String str) {
        if (str != null) {
            AMN = str;
        }
    }

    private static void ij(int i, int i2) {
        AppMethodBeat.i(4026);
        if (AQj == null) {
            AppMethodBeat.o(4026);
            return;
        }
        SharedPreferences mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
        String str = "id_" + i + "_key_" + i2;
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (format.equals(mMKVSharedTransportOld.getString(str, ""))) {
            AppMethodBeat.o(4026);
            return;
        }
        AQj.k((long) i, (long) i2, 1);
        mMKVSharedTransportOld.edit().putString(str, format).commit();
        AppMethodBeat.o(4026);
    }

    public static void h(d dVar) {
        AppMethodBeat.i(4027);
        if (AQj == null) {
            AppMethodBeat.o(4027);
            return;
        }
        String str;
        Object obj;
        if ((dVar == d.WV_KIND_CW ? 1 : 0) != 0) {
            str = "REPORT_APK_VER_TIME";
        } else {
            str = "REPORT_APK_VER_TIME_".concat(String.valueOf(dVar));
        }
        String str2 = "REPORT_XWEB_APK_VER";
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String string = XWalkEnvironment.getSharedPreferences().getString(str, "");
        if (string == null) {
            obj = "";
        } else {
            String obj2 = string;
        }
        if (dVar == d.WV_KIND_CW) {
            int i = XWalkEnvironment.getSharedPreferences().getInt(str2, 0);
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion <= 0) {
                AppMethodBeat.o(4027);
                return;
            } else if (!(availableVersion == i && format.equals(obj2))) {
                AQj.k(577, (long) ((availableVersion % 50) + 100), 1);
                XWalkEnvironment.getSharedPreferences().edit().putInt(str2, availableVersion).commit();
            }
        }
        if (format.equals(obj2)) {
            AppMethodBeat.o(4027);
            return;
        }
        int i2;
        if (dVar == d.WV_KIND_CW) {
            if (XWalkEnvironment.getAvailableVersion() <= 0) {
                AppMethodBeat.o(4027);
                return;
            }
            i2 = 99;
        } else if (dVar == d.WV_KIND_SYS) {
            i2 = 97;
        } else if (dVar == d.WV_KIND_X5) {
            i2 = 98;
        } else {
            AppMethodBeat.o(4027);
            return;
        }
        AQj.k(577, (long) i2, 1);
        XWalkEnvironment.getSharedPreferences().edit().putString(str, format).commit();
        AppMethodBeat.o(4027);
    }

    public static void a(u uVar) {
        AQj = uVar;
    }

    public static void bX(int i, String str) {
        AppMethodBeat.i(4028);
        if (AQj != null) {
            AQj.X(i, str);
        }
        AppMethodBeat.o(4028);
    }

    public static void nI(long j) {
        AppMethodBeat.i(4029);
        if (AQj != null) {
            AQj.k(577, j, 1);
        }
        AppMethodBeat.o(4029);
    }

    public static void n(long j, long j2, long j3) {
        AppMethodBeat.i(4030);
        if (AQj != null) {
            AQj.k(j, j2, j3);
        }
        AppMethodBeat.o(4030);
    }

    public static void avo(String str) {
        int i = 73;
        AppMethodBeat.i(4031);
        if (AQj != null) {
            AQj.k(577, 0, 1);
            if (AMN.equals("toolsmp") && str != null && avq(str) == 2) {
                AQj.k(903, 101, 1);
            }
            if (AMN.equals("toolsmp")) {
                if (WebView.getCurWebType() == d.WV_KIND_CW) {
                    AQj.k(903, 105, 1);
                } else if (WebView.getCurWebType() == d.WV_KIND_X5) {
                    AQj.k(903, 104, 1);
                }
            } else if (AMN.equals("tools") && str != null && avq(str) == 1) {
                AQj.k(903, 103, 1);
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
                    ij(w.CTRL_INDEX, i + ordinal);
                }
            }
        }
        AppMethodBeat.o(4031);
    }

    private static int dUM() {
        AppMethodBeat.i(4032);
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
        AppMethodBeat.o(4032);
        return i;
    }

    public static synchronized void avp(String str) {
        synchronized (f.class) {
            AppMethodBeat.i(4033);
            if (AQj == null) {
                AppMethodBeat.o(4033);
            } else {
                int dUM;
                int ordinal;
                if (!AQk) {
                    if ("toolsmp".equals(AMN)) {
                        if (dUK()) {
                            ij(i.SCENE_BIZ_SCROLL, 106);
                        } else if (dUL()) {
                            ij(i.SCENE_BIZ_SCROLL, 108);
                        }
                    }
                    dUM = dUM();
                    ordinal = WebView.getCurWebType().ordinal() - 1;
                    if (dUM >= 30 && ordinal >= 0) {
                        AQk = true;
                        ij(i.SCENE_BIZ_SCROLL, (dUM + 3) + ordinal);
                    }
                }
                if (str != null && "https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(str.trim())) {
                    AQj.k(903, 102, 1);
                }
                dUM = dUM();
                ordinal = WebView.getCurWebType().ordinal() - 1;
                if (dUM >= 30 && ordinal >= 0) {
                    AQj.k(903, (long) ((dUM + 0) + ordinal), 1);
                }
                if ("toolsmp".equals(AMN)) {
                    if (dUK()) {
                        AQj.k(903, 107, 1);
                        AppMethodBeat.o(4033);
                    } else if (dUL()) {
                        AQj.k(903, 109, 1);
                    }
                }
                AppMethodBeat.o(4033);
            }
        }
    }

    public static void dUN() {
        AppMethodBeat.i(4034);
        if (AQj != null) {
            AQj.k(577, 1, 1);
        }
        AppMethodBeat.o(4034);
    }

    public static void nJ(long j) {
        AppMethodBeat.i(4035);
        if (AQj != null && j > 0 && j < 300000) {
            AQj.aG(2, 3, (int) j);
        }
        AppMethodBeat.o(4035);
    }

    public static void dUO() {
        AppMethodBeat.i(4036);
        if (AQj != null) {
            AQj.k(577, 46, 1);
        }
        AppMethodBeat.o(4036);
    }

    public static void dUP() {
        AppMethodBeat.i(4037);
        if (AQj != null) {
            AQj.k(577, 47, 1);
        }
        AppMethodBeat.o(4037);
    }

    public static void nK(long j) {
        AppMethodBeat.i(4038);
        if (AQj != null && j > 0 && j < 300000) {
            AQj.aG(48, 49, (int) j);
        }
        AppMethodBeat.o(4038);
    }

    public static void dUQ() {
        AppMethodBeat.i(4039);
        if (AQj != null) {
            AQj.k(577, 42, 1);
        }
        AppMethodBeat.o(4039);
    }

    public static void dUR() {
        AppMethodBeat.i(4040);
        if (AQj != null) {
            AQj.k(577, 43, 1);
        }
        AppMethodBeat.o(4040);
    }

    public static void nL(long j) {
        AppMethodBeat.i(4041);
        if (AQj != null && j > 0 && j < 300000) {
            AQj.aG(44, 45, (int) j);
        }
        AppMethodBeat.o(4041);
    }

    public static void eV(String str, int i) {
        AppMethodBeat.i(4042);
        if (AQj != null) {
            avo(str);
            cvF = UUID.randomUUID().toString().replace("-", "");
            AQj.k(577, 4, 1);
            AQj.a(XWalkEnvironment.getAvailableVersion(), avq(str), cvF, com.tencent.xweb.i.dTU() == null ? 100 : com.tencent.xweb.i.dTU().ordinal(), 0, 0, 0, i);
        }
        AppMethodBeat.o(4042);
    }

    public static void b(String str, int i, long j, int i2) {
        AppMethodBeat.i(4043);
        if (AQj != null) {
            dUN();
            AQj.k(577, 5, 1);
            AQj.X(15003, "");
            AQj.a(XWalkEnvironment.getAvailableVersion(), avq(str), cvF, com.tencent.xweb.i.dTU() == null ? 100 : com.tencent.xweb.i.dTU().ordinal(), 1, i, (int) j, i2);
        }
        AppMethodBeat.o(4043);
    }

    public static void q(String str, long j, int i) {
        AppMethodBeat.i(4044);
        nJ(j);
        if (AQj != null && j > 0 && j < 300000) {
            AQj.aG(6, 7, (int) j);
            AQj.a(XWalkEnvironment.getAvailableVersion(), avq(str), cvF, com.tencent.xweb.i.dTU() == null ? 100 : com.tencent.xweb.i.dTU().ordinal(), 1, 0, (int) j, i);
        }
        AppMethodBeat.o(4044);
    }

    public static int avq(String str) {
        AppMethodBeat.i(4045);
        if (str.startsWith("https://servicewechat.com/")) {
            AppMethodBeat.o(4045);
            return 0;
        } else if (str.startsWith("http://mp.weixin.qq.com/") || str.startsWith("https://mp.weixin.qq.com/") || str.startsWith("https://servicewechat.com/preload/") || str.startsWith("http://mp.weixinbridge.com/")) {
            AppMethodBeat.o(4045);
            return 1;
        } else {
            AppMethodBeat.o(4045);
            return 2;
        }
    }

    public static void dUS() {
        AppMethodBeat.i(4046);
        if (AQj != null) {
            AQj.k(577, 52, 1);
        }
        AppMethodBeat.o(4046);
    }

    public static void dUT() {
        AppMethodBeat.i(4047);
        if (AQj != null) {
            AQj.k(577, 53, 1);
        }
        AppMethodBeat.o(4047);
    }

    public static void dUU() {
        AppMethodBeat.i(4048);
        if (AQj != null) {
            AQj.k(577, 54, 1);
        }
        AppMethodBeat.o(4048);
    }

    public static void dUV() {
        AppMethodBeat.i(4049);
        if (AQj != null) {
            AQj.k(577, 55, 1);
        }
        AppMethodBeat.o(4049);
    }

    public static void dUW() {
        AppMethodBeat.i(4050);
        if (AQj != null) {
            AQj.k(577, 56, 1);
        }
        AppMethodBeat.o(4050);
    }

    public static void dUX() {
        AppMethodBeat.i(4051);
        if (AQj != null) {
            AQj.k(577, 57, 1);
        }
        AppMethodBeat.o(4051);
    }

    public static void dUY() {
        AppMethodBeat.i(4052);
        if (AQj != null) {
            AQj.k(577, 58, 1);
        }
        AppMethodBeat.o(4052);
    }

    public static void dUZ() {
        AppMethodBeat.i(4053);
        if (AQj != null) {
            AQj.k(577, 59, 1);
        }
        AppMethodBeat.o(4053);
    }

    public static void aK(int i, boolean z) {
        AppMethodBeat.i(4054);
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
                AQj.k(577, (long) i2, 1);
            }
        }
        AppMethodBeat.o(4054);
    }

    public static void aL(int i, boolean z) {
        AppMethodBeat.i(4055);
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
                AQj.k(577, (long) i2, 1);
            }
        }
        AppMethodBeat.o(4055);
    }

    public static void dVa() {
        AppMethodBeat.i(4056);
        if (AQj != null) {
            AQj.k(577, 167, 1);
        }
        AppMethodBeat.o(4056);
    }

    public static void dVb() {
        AppMethodBeat.i(4057);
        if (AQj != null) {
            AQj.k(577, 9, 1);
        }
        AppMethodBeat.o(4057);
    }

    public static void nM(long j) {
        AppMethodBeat.i(4058);
        if (AQj != null && AQj != null && j > 0 && j < 600000) {
            AQj.aG(11, 12, (int) j);
        }
        AppMethodBeat.o(4058);
    }

    public static void dVc() {
        AppMethodBeat.i(4059);
        if (AQj != null) {
            AQj.k(577, 10, 1);
        }
        AppMethodBeat.o(4059);
    }

    public static void dVd() {
        AppMethodBeat.i(4060);
        if (AQj != null) {
            AQj.k(577, 60, 1);
        }
        AppMethodBeat.o(4060);
    }

    public static void i(d dVar) {
        AppMethodBeat.i(4061);
        if (AQj == null) {
            AppMethodBeat.o(4061);
            return;
        }
        if (dVar == d.WV_KIND_CW) {
            AQj.k(577, 61, 1);
            ij(w.CTRL_INDEX, 62);
        }
        AppMethodBeat.o(4061);
    }

    public static void dVe() {
        AppMethodBeat.i(4062);
        if (AQj != null) {
            AQj.k(577, 20, 1);
        }
        AppMethodBeat.o(4062);
    }

    public static void nN(long j) {
        AppMethodBeat.i(4063);
        if (AQj != null && AQj != null && j > 0 && j < 600000) {
            AQj.aG(22, 23, (int) j);
        }
        AppMethodBeat.o(4063);
    }

    public static void dVf() {
        AppMethodBeat.i(4064);
        if (AQj != null) {
            AQj.k(577, 21, 1);
        }
        AppMethodBeat.o(4064);
    }

    public static void aHn() {
        AppMethodBeat.i(4065);
        if (AQj != null) {
            AQj.k(577, 25, 1);
        }
        AppMethodBeat.o(4065);
    }

    public static void nO(long j) {
        AppMethodBeat.i(4066);
        if (AQj != null && AQj != null && j > 0 && j < 600000) {
            AQj.aG(27, 28, (int) j);
        }
        AppMethodBeat.o(4066);
    }

    public static void dVg() {
        AppMethodBeat.i(4067);
        if (AQj != null) {
            AQj.k(577, 26, 1);
        }
        AppMethodBeat.o(4067);
    }

    public static void dVh() {
        AppMethodBeat.i(4068);
        if (AQj != null) {
            AQj.k(577, 14, 1);
        }
        AppMethodBeat.o(4068);
    }

    public static void dVi() {
        AppMethodBeat.i(4069);
        if (AQj != null) {
            AQj.k(577, 15, 1);
        }
        AppMethodBeat.o(4069);
    }

    public static void nP(long j) {
        AppMethodBeat.i(4070);
        if (AQj != null && AQj != null && j > 0 && j < 120000) {
            AQj.aG(16, 17, (int) j);
        }
        AppMethodBeat.o(4070);
    }

    public static void dVj() {
        AppMethodBeat.i(4071);
        if (AQj == null) {
            AppMethodBeat.o(4071);
            return;
        }
        AQj.k(577, 83, 1);
        AppMethodBeat.o(4071);
    }

    public static void j(d dVar) {
        AppMethodBeat.i(4072);
        if (AQj == null) {
            AppMethodBeat.o(4072);
            return;
        }
        int i;
        switch (dVar) {
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
                AppMethodBeat.o(4072);
                return;
        }
        AQj.k(577, (long) i, 1);
        AppMethodBeat.o(4072);
    }

    public static void dVk() {
        AppMethodBeat.i(4073);
        if (AQj == null) {
            AppMethodBeat.o(4073);
            return;
        }
        AQj.k(577, 87, 1);
        AppMethodBeat.o(4073);
    }

    public static void k(d dVar) {
        AppMethodBeat.i(4074);
        if (AQj == null) {
            AppMethodBeat.o(4074);
            return;
        }
        int i;
        switch (dVar) {
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
                AppMethodBeat.o(4074);
                return;
        }
        AQj.k(577, (long) i, 1);
        AppMethodBeat.o(4074);
    }

    public static void dVl() {
        AppMethodBeat.i(4075);
        if (AQj != null) {
            AQj.k(577, 180, 1);
        }
        AppMethodBeat.o(4075);
    }

    public static void dVm() {
        AppMethodBeat.i(4076);
        if (AQj != null) {
            AQj.k(577, 181, 1);
        }
        AppMethodBeat.o(4076);
    }

    public static void dVn() {
        AppMethodBeat.i(4077);
        if (AQj != null) {
            AQj.k(577, 182, 1);
        }
        AppMethodBeat.o(4077);
    }

    public static void dVo() {
        AppMethodBeat.i(4078);
        if (AQj != null) {
            AQj.k(577, 183, 1);
        }
        AppMethodBeat.o(4078);
    }

    public static void dVp() {
        AppMethodBeat.i(4079);
        if (AQj != null) {
            AQj.k(577, 184, 1);
        }
        AppMethodBeat.o(4079);
    }

    public static void dVq() {
        AppMethodBeat.i(4080);
        if (AQj != null) {
            AQj.k(577, 185, 1);
        }
        AppMethodBeat.o(4080);
    }

    public static void dVr() {
        AppMethodBeat.i(4081);
        if (AQj != null) {
            AQj.k(577, 186, 1);
        }
        AppMethodBeat.o(4081);
    }

    public static void dVs() {
        AppMethodBeat.i(4082);
        if (AQj != null) {
            AQj.k(577, 187, 1);
        }
        AppMethodBeat.o(4082);
    }

    public static void dVt() {
        AppMethodBeat.i(4083);
        if (AQj != null) {
            AQj.k(577, 188, 1);
        }
        AppMethodBeat.o(4083);
    }

    public static void dVu() {
        AppMethodBeat.i(4084);
        if (AQj != null) {
            AQj.k(577, 189, 1);
        }
        AppMethodBeat.o(4084);
    }

    public static void dVv() {
        AppMethodBeat.i(4085);
        if (AQj != null) {
            AQj.k(577, 190, 1);
        }
        AppMethodBeat.o(4085);
    }

    public static void dVw() {
        AppMethodBeat.i(4086);
        if (AQj == null) {
            AppMethodBeat.o(4086);
            return;
        }
        AQj.k(577, 88, 1);
        AppMethodBeat.o(4086);
    }

    public static boolean Sw(int i) {
        return i == 15625 || i == 15626;
    }

    public static boolean hasInit() {
        return AQj != null;
    }

    public static void Sx(int i) {
        AppMethodBeat.i(4087);
        if ("toolsmp".equals(AMN)) {
            int i2;
            if (WebView.getCurWebType() == d.WV_KIND_CW) {
                i2 = 200;
            } else if (WebView.getCurWebType() == d.WV_KIND_X5) {
                i2 = 220;
            } else {
                AppMethodBeat.o(4087);
                return;
            }
            if (i < 0) {
                i = 3;
            } else if (i > 9) {
                i = 4;
            }
            n(903, (long) (i2 + i), 1);
            AppMethodBeat.o(4087);
            return;
        }
        AppMethodBeat.o(4087);
    }

    public static void rB(boolean z) {
        AppMethodBeat.i(4088);
        if ("toolsmp".equals(AMN)) {
            int i;
            int i2;
            if (z) {
                i = 0;
            } else {
                i = 1;
            }
            if (WebView.getCurWebType() == d.WV_KIND_CW) {
                i2 = 180;
            } else if (WebView.getCurWebType() == d.WV_KIND_X5) {
                i2 = FacebookRequestErrorClassification.EC_INVALID_TOKEN;
            } else {
                AppMethodBeat.o(4088);
                return;
            }
            n(903, (long) (i + i2), 1);
            AppMethodBeat.o(4088);
            return;
        }
        AppMethodBeat.o(4088);
    }

    public static void dVx() {
        AppMethodBeat.i(138352);
        n(938, 89, 1);
        AppMethodBeat.o(138352);
    }

    public static void dVy() {
        AppMethodBeat.i(138353);
        n(938, 90, 1);
        AppMethodBeat.o(138353);
    }

    public static void dVz() {
        AppMethodBeat.i(138354);
        n(938, 91, 1);
        AppMethodBeat.o(138354);
    }
}
