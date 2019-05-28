package com.tencent.p177mm.model;

import android.graphics.BitmapFactory.Options;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p201az.C6334j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.model.r */
public final class C1853r {
    /* renamed from: mG */
    public static boolean m3858mG(String str) {
        AppMethodBeat.m2504i(59739);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59739);
            return false;
        }
        String Yz = C1853r.m3846Yz();
        if (Yz == null || Yz.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
            AppMethodBeat.m2505o(59739);
            return false;
        }
        boolean equals = Yz.equals(str);
        AppMethodBeat.m2505o(59739);
        return equals;
    }

    /* renamed from: Yy */
    public static int m3845Yy() {
        AppMethodBeat.m2504i(59740);
        C1720g.m3537RQ();
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(9, null);
        if (num == null) {
            AppMethodBeat.m2505o(59740);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(59740);
        return intValue;
    }

    public static String getUserBindEmail() {
        AppMethodBeat.m2504i(59741);
        C1720g.m3537RQ();
        String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(5, null));
        AppMethodBeat.m2505o(59741);
        return nullAsNil;
    }

    /* renamed from: Yz */
    public static String m3846Yz() {
        AppMethodBeat.m2504i(59742);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
        AppMethodBeat.m2505o(59742);
        return str;
    }

    /* renamed from: YA */
    public static String m3819YA() {
        AppMethodBeat.m2504i(59743);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(42, null);
        AppMethodBeat.m2505o(59743);
        return str;
    }

    /* renamed from: YB */
    public static String m3820YB() {
        AppMethodBeat.m2504i(59744);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(4, null);
        AppMethodBeat.m2505o(59744);
        return str;
    }

    /* renamed from: YC */
    public static String m3821YC() {
        AppMethodBeat.m2504i(59745);
        String YA = C1853r.m3819YA();
        if (C5046bo.isNullOrNil(YA)) {
            YA = C1853r.m3846Yz();
            AppMethodBeat.m2505o(59745);
            return YA;
        }
        AppMethodBeat.m2505o(59745);
        return YA;
    }

    /* renamed from: YD */
    public static int m3822YD() {
        AppMethodBeat.m2504i(59746);
        C1720g.m3537RQ();
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(7, null);
        if (num == null) {
            AppMethodBeat.m2505o(59746);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(59746);
        return intValue;
    }

    /* renamed from: YE */
    public static long m3823YE() {
        AppMethodBeat.m2504i(59747);
        C1720g.m3537RQ();
        Long l = (Long) C1720g.m3536RP().mo5239Ry().get(147457, null);
        if (l == null) {
            AppMethodBeat.m2505o(59747);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.m2505o(59747);
        return longValue;
    }

    /* renamed from: YF */
    public static int m3824YF() {
        AppMethodBeat.m2504i(59748);
        C1720g.m3537RQ();
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(40, null);
        if (num == null) {
            AppMethodBeat.m2505o(59748);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(59748);
        return intValue;
    }

    /* renamed from: YG */
    public static int m3825YG() {
        AppMethodBeat.m2504i(59749);
        C1720g.m3537RQ();
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(339975, null);
        if (num == null) {
            AppMethodBeat.m2505o(59749);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(59749);
        return intValue;
    }

    /* renamed from: ku */
    public static boolean m3855ku(int i) {
        return (i & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    /* renamed from: YH */
    public static boolean m3826YH() {
        AppMethodBeat.m2504i(59750);
        if ((C1853r.m3824YF() & 16384) != 0) {
            AppMethodBeat.m2505o(59750);
            return true;
        }
        AppMethodBeat.m2505o(59750);
        return false;
    }

    /* renamed from: YI */
    public static boolean m3827YI() {
        AppMethodBeat.m2504i(59751);
        if ((C1853r.m3824YF() & 32768) != 0) {
            AppMethodBeat.m2505o(59751);
            return true;
        }
        AppMethodBeat.m2505o(59751);
        return false;
    }

    /* renamed from: YJ */
    public static void m3828YJ() {
        AppMethodBeat.m2504i(59752);
        int YF = C1853r.m3824YF() | 32768;
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(YF));
        AppMethodBeat.m2505o(59752);
    }

    /* renamed from: YK */
    public static int m3829YK() {
        AppMethodBeat.m2504i(59753);
        C1720g.m3537RQ();
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(34, null);
        if (num == null) {
            AppMethodBeat.m2505o(59753);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(59753);
        return intValue;
    }

    /* renamed from: YL */
    public static boolean m3830YL() {
        boolean z;
        AppMethodBeat.m2504i(59754);
        if ((C1853r.m3822YD() & 262144) != 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", Boolean.valueOf(z), Integer.valueOf(C1853r.m3822YD()));
        AppMethodBeat.m2505o(59754);
        return z;
    }

    /* renamed from: YM */
    public static boolean m3831YM() {
        AppMethodBeat.m2504i(59755);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        if (C1853r.m3825YG() == 1) {
            AppMethodBeat.m2505o(59755);
            return true;
        }
        AppMethodBeat.m2505o(59755);
        return false;
    }

    /* renamed from: YN */
    public static boolean m3832YN() {
        AppMethodBeat.m2504i(59756);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        if (C1853r.m3825YG() == 2) {
            AppMethodBeat.m2505o(59756);
            return true;
        }
        AppMethodBeat.m2505o(59756);
        return false;
    }

    /* renamed from: YO */
    public static boolean m3833YO() {
        AppMethodBeat.m2504i(59757);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        if (C1853r.m3825YG() == 4) {
            AppMethodBeat.m2505o(59757);
            return true;
        }
        AppMethodBeat.m2505o(59757);
        return false;
    }

    /* renamed from: YP */
    public static boolean m3834YP() {
        AppMethodBeat.m2504i(59758);
        if ((C1853r.m3829YK() & 32) == 0) {
            AppMethodBeat.m2505o(59758);
            return true;
        }
        AppMethodBeat.m2505o(59758);
        return false;
    }

    /* renamed from: YQ */
    public static boolean m3835YQ() {
        AppMethodBeat.m2504i(59759);
        if ((C1853r.m3822YD() & 4096) != 0) {
            AppMethodBeat.m2505o(59759);
            return true;
        }
        AppMethodBeat.m2505o(59759);
        return false;
    }

    /* renamed from: YR */
    public static boolean m3836YR() {
        AppMethodBeat.m2504i(59760);
        C5140bq RA = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com");
        if (RA == null || !RA.isEnable()) {
            AppMethodBeat.m2505o(59760);
            return false;
        }
        AppMethodBeat.m2505o(59760);
        return true;
    }

    /* renamed from: YS */
    public static boolean m3837YS() {
        AppMethodBeat.m2504i(59761);
        if ((C1853r.m3829YK() & 2) == 0) {
            AppMethodBeat.m2505o(59761);
            return true;
        }
        AppMethodBeat.m2505o(59761);
        return false;
    }

    /* renamed from: YT */
    public static boolean m3838YT() {
        AppMethodBeat.m2504i(59762);
        if ((C1853r.m3829YK() & 16) == 0) {
            AppMethodBeat.m2505o(59762);
            return true;
        }
        AppMethodBeat.m2505o(59762);
        return false;
    }

    /* renamed from: YU */
    public static boolean m3839YU() {
        AppMethodBeat.m2504i(59763);
        if ((C1853r.m3829YK() & 128) == 0) {
            AppMethodBeat.m2505o(59763);
            return true;
        }
        AppMethodBeat.m2505o(59763);
        return false;
    }

    /* renamed from: YV */
    public static boolean m3840YV() {
        AppMethodBeat.m2504i(59764);
        if ((C1853r.m3829YK() & SQLiteGlobal.journalSizeLimit) == 0) {
            AppMethodBeat.m2505o(59764);
            return true;
        }
        AppMethodBeat.m2505o(59764);
        return false;
    }

    /* renamed from: YW */
    public static boolean m3841YW() {
        AppMethodBeat.m2504i(59765);
        if ((C1853r.m3829YK() & 262144) == 0) {
            AppMethodBeat.m2505o(59765);
            return true;
        }
        AppMethodBeat.m2505o(59765);
        return false;
    }

    /* renamed from: YX */
    public static boolean m3842YX() {
        AppMethodBeat.m2504i(59766);
        if ((C1853r.m3829YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            AppMethodBeat.m2505o(59766);
            return true;
        }
        AppMethodBeat.m2505o(59766);
        return false;
    }

    /* renamed from: YY */
    public static boolean m3843YY() {
        AppMethodBeat.m2504i(59767);
        if ((C1853r.m3829YK() & 65536) == 0) {
            AppMethodBeat.m2505o(59767);
            return true;
        }
        AppMethodBeat.m2505o(59767);
        return false;
    }

    /* renamed from: YZ */
    public static boolean m3844YZ() {
        AppMethodBeat.m2504i(59768);
        if ((C1853r.m3829YK() & 134217728) == 0) {
            AppMethodBeat.m2505o(59768);
            return true;
        }
        AppMethodBeat.m2505o(59768);
        return false;
    }

    /* renamed from: Za */
    public static boolean m3847Za() {
        AppMethodBeat.m2504i(59769);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(65825, null);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59769);
            return false;
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            AppMethodBeat.m2505o(59769);
            return false;
        } else {
            try {
                if (C5046bo.m7534c(Long.valueOf(C5046bo.getLong(str, 0))) == 0) {
                    AppMethodBeat.m2505o(59769);
                    return false;
                }
                AppMethodBeat.m2505o(59769);
                return true;
            } catch (Exception e) {
                AppMethodBeat.m2505o(59769);
                return false;
            }
        }
    }

    /* renamed from: Zb */
    public static boolean m3848Zb() {
        AppMethodBeat.m2504i(59770);
        if ((C1853r.m3829YK() & 1) == 0) {
            AppMethodBeat.m2505o(59770);
            return true;
        }
        AppMethodBeat.m2505o(59770);
        return false;
    }

    /* renamed from: Zc */
    public static boolean m3849Zc() {
        AppMethodBeat.m2504i(59771);
        if ((C1853r.m3822YD() & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
            AppMethodBeat.m2505o(59771);
            return true;
        }
        AppMethodBeat.m2505o(59771);
        return false;
    }

    /* renamed from: Zd */
    public static C7616ad m3850Zd() {
        AppMethodBeat.m2504i(59772);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(C1853r.m3846Yz());
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            C7616ad c7616ad = new C7616ad();
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
            C1720g.m3537RQ();
            String str2 = (String) C1720g.m3536RP().mo5239Ry().get(4, null);
            c7616ad.setUsername(str);
            c7616ad.mo14703iB(str2);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15702Z(c7616ad);
            aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            AppMethodBeat.m2505o(59772);
            return aoO;
        }
        AppMethodBeat.m2505o(59772);
        return aoO;
    }

    /* renamed from: r */
    public static C3463b m3859r(int i, String str) {
        C3463b c6334j;
        AppMethodBeat.m2504i(59773);
        switch (i) {
            case 2:
                c6334j = new C6334j(str, 1);
                break;
            case 18:
                c6334j = new C6334j(str, 2);
                break;
            default:
                c6334j = null;
                break;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(c6334j);
        AppMethodBeat.m2505o(59773);
        return c6334j;
    }

    /* renamed from: Ze */
    public static boolean m3851Ze() {
        AppMethodBeat.m2504i(59774);
        C1720g.m3537RQ();
        if (new C1183p(C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(9, null))).longValue() != 0) {
            AppMethodBeat.m2505o(59774);
            return true;
        }
        AppMethodBeat.m2505o(59774);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public static boolean m3854g(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(59775);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
            AppMethodBeat.m2505o(59775);
            return false;
        } else if (str2 == null || str2.length() <= 0 || !(C7616ad.aou(str2) || C7616ad.aow(str2))) {
            Object obj;
            Options options = new Options();
            if (str == null || str.length() == 0) {
                C4990ab.m7412e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
            } else {
                double d;
                if (C5730e.asZ(str) < 65536) {
                    obj = 1;
                } else {
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeFile(str, options);
                    d = (double) options.outWidth;
                    double d2 = (double) options.outHeight;
                    if (d < 100.0d && d2 < 100.0d) {
                        C4990ab.m7416i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d + ", height = " + d2);
                        obj = 1;
                    }
                }
                if (obj == null) {
                    C4990ab.m7416i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
                    AppMethodBeat.m2505o(59775);
                    return true;
                }
                d = (double) options.outWidth;
                double d3 = (double) options.outHeight;
                if (d / d3 >= 2.5d || d3 / d >= 2.5d) {
                    if (C5730e.asZ(str) < 26214400) {
                        C4990ab.m7417i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Long.valueOf(C5730e.asZ(str)));
                        AppMethodBeat.m2505o(59775);
                        return true;
                    }
                    C4990ab.m7417i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Long.valueOf(C5730e.asZ(str)));
                    AppMethodBeat.m2505o(59775);
                    return false;
                } else if (z) {
                    AppMethodBeat.m2505o(59775);
                    return false;
                } else {
                    AppMethodBeat.m2505o(59775);
                    return true;
                }
            }
            obj = null;
            if (obj == null) {
            }
        } else {
            AppMethodBeat.m2505o(59775);
            return false;
        }
    }

    /* renamed from: l */
    public static void m3856l(Map<String, String> map) {
        AppMethodBeat.m2504i(59776);
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[]{entry.getKey(), entry.getValue()}));
        }
        C1720g.m3537RQ();
        if (C1720g.m3536RP() != null) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().mo5239Ry() != null) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(327682, stringBuilder.toString());
            }
        }
        AppMethodBeat.m2505o(59776);
    }

    /* renamed from: m */
    public static void m3857m(Map<String, String> map) {
        AppMethodBeat.m2504i(59777);
        map.clear();
        C1720g.m3537RQ();
        if (C1720g.m3536RP() != null) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().mo5239Ry() != null) {
                C1720g.m3537RQ();
                String str = (String) C1720g.m3536RP().mo5239Ry().get(327682, null);
                if (str == null) {
                    AppMethodBeat.m2505o(59777);
                    return;
                }
                String[] split = str.split(IOUtils.LINE_SEPARATOR_UNIX);
                if (split.length % 2 != 0) {
                    C4990ab.m7412e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(split.length));
                    AppMethodBeat.m2505o(59777);
                    return;
                }
                for (int i = 0; i < split.length; i += 2) {
                    map.put(split[i], split[i + 1]);
                }
                AppMethodBeat.m2505o(59777);
                return;
            }
        }
        C4990ab.m7410d("MicroMsg.ConfigStorageLogic", "acc stg is null");
        AppMethodBeat.m2505o(59777);
    }

    /* renamed from: Zf */
    public static Boolean m3852Zf() {
        AppMethodBeat.m2504i(59778);
        Boolean bool;
        if (C1720g.m3531RK()) {
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
            C1720g.m3537RQ();
            if (!C5046bo.m7546e((Boolean) C1720g.m3536RP().mo5239Ry().get(340241, null)) || C5046bo.isNullOrNil(str)) {
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(59778);
                return bool;
            }
            String str2 = "86";
            if (str.startsWith("+")) {
                str = C5025av.m7481Ps(str);
            } else {
                str = str2;
            }
            if (str == "86") {
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(59778);
                return bool;
            }
            bool = Boolean.TRUE;
            AppMethodBeat.m2505o(59778);
            return bool;
        }
        C4990ab.m7412e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
        bool = Boolean.FALSE;
        AppMethodBeat.m2505o(59778);
        return bool;
    }

    /* renamed from: Zg */
    public static Map<String, String> m3853Zg() {
        AppMethodBeat.m2504i(59779);
        HashMap hashMap = new HashMap();
        hashMap.put("login_weixin_username", C1853r.m3846Yz());
        C1720g.m3537RQ();
        hashMap.put("login_user_name", (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_LOGIN_USERNAME_STRING, null));
        C1720g.m3537RQ();
        hashMap.put("last_avatar_path", (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, null));
        C1720g.m3537RQ();
        hashMap.put("last_login_bind_mobile", (String) C1720g.m3536RP().mo5239Ry().get(6, null));
        C1720g.m3537RQ();
        hashMap.put("last_login_bind_email", (String) C1720g.m3536RP().mo5239Ry().get(5, null));
        C1720g.m3537RQ();
        hashMap.put("last_login_bind_qq", String.valueOf(C1720g.m3536RP().mo5239Ry().get(9, null)));
        C1720g.m3537RQ();
        hashMap.put("last_login_use_voice", String.valueOf(C1720g.m3536RP().mo5239Ry().get(40, null)));
        AppMethodBeat.m2505o(59779);
        return hashMap;
    }
}
