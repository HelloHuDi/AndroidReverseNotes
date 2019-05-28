package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class r {
    public static boolean mG(String str) {
        AppMethodBeat.i(59739);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59739);
            return false;
        }
        String Yz = Yz();
        if (Yz == null || Yz.length() <= 0) {
            ab.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
            AppMethodBeat.o(59739);
            return false;
        }
        boolean equals = Yz.equals(str);
        AppMethodBeat.o(59739);
        return equals;
    }

    public static int Yy() {
        AppMethodBeat.i(59740);
        g.RQ();
        Integer num = (Integer) g.RP().Ry().get(9, null);
        if (num == null) {
            AppMethodBeat.o(59740);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(59740);
        return intValue;
    }

    public static String getUserBindEmail() {
        AppMethodBeat.i(59741);
        g.RQ();
        String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(5, null));
        AppMethodBeat.o(59741);
        return nullAsNil;
    }

    public static String Yz() {
        AppMethodBeat.i(59742);
        g.RQ();
        String str = (String) g.RP().Ry().get(2, null);
        AppMethodBeat.o(59742);
        return str;
    }

    public static String YA() {
        AppMethodBeat.i(59743);
        g.RQ();
        String str = (String) g.RP().Ry().get(42, null);
        AppMethodBeat.o(59743);
        return str;
    }

    public static String YB() {
        AppMethodBeat.i(59744);
        g.RQ();
        String str = (String) g.RP().Ry().get(4, null);
        AppMethodBeat.o(59744);
        return str;
    }

    public static String YC() {
        AppMethodBeat.i(59745);
        String YA = YA();
        if (bo.isNullOrNil(YA)) {
            YA = Yz();
            AppMethodBeat.o(59745);
            return YA;
        }
        AppMethodBeat.o(59745);
        return YA;
    }

    public static int YD() {
        AppMethodBeat.i(59746);
        g.RQ();
        Integer num = (Integer) g.RP().Ry().get(7, null);
        if (num == null) {
            AppMethodBeat.o(59746);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(59746);
        return intValue;
    }

    public static long YE() {
        AppMethodBeat.i(59747);
        g.RQ();
        Long l = (Long) g.RP().Ry().get(147457, null);
        if (l == null) {
            AppMethodBeat.o(59747);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(59747);
        return longValue;
    }

    public static int YF() {
        AppMethodBeat.i(59748);
        g.RQ();
        Integer num = (Integer) g.RP().Ry().get(40, null);
        if (num == null) {
            AppMethodBeat.o(59748);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(59748);
        return intValue;
    }

    public static int YG() {
        AppMethodBeat.i(59749);
        g.RQ();
        Integer num = (Integer) g.RP().Ry().get(339975, null);
        if (num == null) {
            AppMethodBeat.o(59749);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(59749);
        return intValue;
    }

    public static boolean ku(int i) {
        return (i & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public static boolean YH() {
        AppMethodBeat.i(59750);
        if ((YF() & 16384) != 0) {
            AppMethodBeat.o(59750);
            return true;
        }
        AppMethodBeat.o(59750);
        return false;
    }

    public static boolean YI() {
        AppMethodBeat.i(59751);
        if ((YF() & 32768) != 0) {
            AppMethodBeat.o(59751);
            return true;
        }
        AppMethodBeat.o(59751);
        return false;
    }

    public static void YJ() {
        AppMethodBeat.i(59752);
        int YF = YF() | 32768;
        g.RQ();
        g.RP().Ry().set(40, Integer.valueOf(YF));
        AppMethodBeat.o(59752);
    }

    public static int YK() {
        AppMethodBeat.i(59753);
        g.RQ();
        Integer num = (Integer) g.RP().Ry().get(34, null);
        if (num == null) {
            AppMethodBeat.o(59753);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(59753);
        return intValue;
    }

    public static boolean YL() {
        boolean z;
        AppMethodBeat.i(59754);
        if ((YD() & 262144) != 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", Boolean.valueOf(z), Integer.valueOf(YD()));
        AppMethodBeat.o(59754);
        return z;
    }

    public static boolean YM() {
        AppMethodBeat.i(59755);
        g.RQ();
        g.RP().Ry().dsb();
        if (YG() == 1) {
            AppMethodBeat.o(59755);
            return true;
        }
        AppMethodBeat.o(59755);
        return false;
    }

    public static boolean YN() {
        AppMethodBeat.i(59756);
        g.RQ();
        g.RP().Ry().dsb();
        if (YG() == 2) {
            AppMethodBeat.o(59756);
            return true;
        }
        AppMethodBeat.o(59756);
        return false;
    }

    public static boolean YO() {
        AppMethodBeat.i(59757);
        g.RQ();
        g.RP().Ry().dsb();
        if (YG() == 4) {
            AppMethodBeat.o(59757);
            return true;
        }
        AppMethodBeat.o(59757);
        return false;
    }

    public static boolean YP() {
        AppMethodBeat.i(59758);
        if ((YK() & 32) == 0) {
            AppMethodBeat.o(59758);
            return true;
        }
        AppMethodBeat.o(59758);
        return false;
    }

    public static boolean YQ() {
        AppMethodBeat.i(59759);
        if ((YD() & 4096) != 0) {
            AppMethodBeat.o(59759);
            return true;
        }
        AppMethodBeat.o(59759);
        return false;
    }

    public static boolean YR() {
        AppMethodBeat.i(59760);
        bq RA = ((j) g.K(j.class)).XU().RA("@t.qq.com");
        if (RA == null || !RA.isEnable()) {
            AppMethodBeat.o(59760);
            return false;
        }
        AppMethodBeat.o(59760);
        return true;
    }

    public static boolean YS() {
        AppMethodBeat.i(59761);
        if ((YK() & 2) == 0) {
            AppMethodBeat.o(59761);
            return true;
        }
        AppMethodBeat.o(59761);
        return false;
    }

    public static boolean YT() {
        AppMethodBeat.i(59762);
        if ((YK() & 16) == 0) {
            AppMethodBeat.o(59762);
            return true;
        }
        AppMethodBeat.o(59762);
        return false;
    }

    public static boolean YU() {
        AppMethodBeat.i(59763);
        if ((YK() & 128) == 0) {
            AppMethodBeat.o(59763);
            return true;
        }
        AppMethodBeat.o(59763);
        return false;
    }

    public static boolean YV() {
        AppMethodBeat.i(59764);
        if ((YK() & SQLiteGlobal.journalSizeLimit) == 0) {
            AppMethodBeat.o(59764);
            return true;
        }
        AppMethodBeat.o(59764);
        return false;
    }

    public static boolean YW() {
        AppMethodBeat.i(59765);
        if ((YK() & 262144) == 0) {
            AppMethodBeat.o(59765);
            return true;
        }
        AppMethodBeat.o(59765);
        return false;
    }

    public static boolean YX() {
        AppMethodBeat.i(59766);
        if ((YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            AppMethodBeat.o(59766);
            return true;
        }
        AppMethodBeat.o(59766);
        return false;
    }

    public static boolean YY() {
        AppMethodBeat.i(59767);
        if ((YK() & 65536) == 0) {
            AppMethodBeat.o(59767);
            return true;
        }
        AppMethodBeat.o(59767);
        return false;
    }

    public static boolean YZ() {
        AppMethodBeat.i(59768);
        if ((YK() & 134217728) == 0) {
            AppMethodBeat.o(59768);
            return true;
        }
        AppMethodBeat.o(59768);
        return false;
    }

    public static boolean Za() {
        AppMethodBeat.i(59769);
        g.RQ();
        String str = (String) g.RP().Ry().get(65825, null);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59769);
            return false;
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            AppMethodBeat.o(59769);
            return false;
        } else {
            try {
                if (bo.c(Long.valueOf(bo.getLong(str, 0))) == 0) {
                    AppMethodBeat.o(59769);
                    return false;
                }
                AppMethodBeat.o(59769);
                return true;
            } catch (Exception e) {
                AppMethodBeat.o(59769);
                return false;
            }
        }
    }

    public static boolean Zb() {
        AppMethodBeat.i(59770);
        if ((YK() & 1) == 0) {
            AppMethodBeat.o(59770);
            return true;
        }
        AppMethodBeat.o(59770);
        return false;
    }

    public static boolean Zc() {
        AppMethodBeat.i(59771);
        if ((YD() & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
            AppMethodBeat.o(59771);
            return true;
        }
        AppMethodBeat.o(59771);
        return false;
    }

    public static ad Zd() {
        AppMethodBeat.i(59772);
        ad aoO = ((j) g.K(j.class)).XM().aoO(Yz());
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            ad adVar = new ad();
            g.RQ();
            String str = (String) g.RP().Ry().get(2, null);
            g.RQ();
            String str2 = (String) g.RP().Ry().get(4, null);
            adVar.setUsername(str);
            adVar.iB(str2);
            ((j) g.K(j.class)).XM().Z(adVar);
            aoO = ((j) g.K(j.class)).XM().aoO(str);
            AppMethodBeat.o(59772);
            return aoO;
        }
        AppMethodBeat.o(59772);
        return aoO;
    }

    public static b r(int i, String str) {
        b jVar;
        AppMethodBeat.i(59773);
        switch (i) {
            case 2:
                jVar = new com.tencent.mm.az.j(str, 1);
                break;
            case 18:
                jVar = new com.tencent.mm.az.j(str, 2);
                break;
            default:
                jVar = null;
                break;
        }
        ((j) g.K(j.class)).XL().c(jVar);
        AppMethodBeat.o(59773);
        return jVar;
    }

    public static boolean Ze() {
        AppMethodBeat.i(59774);
        g.RQ();
        if (new p(bo.h((Integer) g.RP().Ry().get(9, null))).longValue() != 0) {
            AppMethodBeat.o(59774);
            return true;
        }
        AppMethodBeat.o(59774);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean g(String str, String str2, boolean z) {
        AppMethodBeat.i(59775);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
            AppMethodBeat.o(59775);
            return false;
        } else if (str2 == null || str2.length() <= 0 || !(ad.aou(str2) || ad.aow(str2))) {
            Object obj;
            Options options = new Options();
            if (str == null || str.length() == 0) {
                ab.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
            } else {
                double d;
                if (e.asZ(str) < 65536) {
                    obj = 1;
                } else {
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeFile(str, options);
                    d = (double) options.outWidth;
                    double d2 = (double) options.outHeight;
                    if (d < 100.0d && d2 < 100.0d) {
                        ab.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d + ", height = " + d2);
                        obj = 1;
                    }
                }
                if (obj == null) {
                    ab.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
                    AppMethodBeat.o(59775);
                    return true;
                }
                d = (double) options.outWidth;
                double d3 = (double) options.outHeight;
                if (d / d3 >= 2.5d || d3 / d >= 2.5d) {
                    if (e.asZ(str) < 26214400) {
                        ab.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Long.valueOf(e.asZ(str)));
                        AppMethodBeat.o(59775);
                        return true;
                    }
                    ab.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Long.valueOf(e.asZ(str)));
                    AppMethodBeat.o(59775);
                    return false;
                } else if (z) {
                    AppMethodBeat.o(59775);
                    return false;
                } else {
                    AppMethodBeat.o(59775);
                    return true;
                }
            }
            obj = null;
            if (obj == null) {
            }
        } else {
            AppMethodBeat.o(59775);
            return false;
        }
    }

    public static void l(Map<String, String> map) {
        AppMethodBeat.i(59776);
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[]{entry.getKey(), entry.getValue()}));
        }
        g.RQ();
        if (g.RP() != null) {
            g.RQ();
            if (g.RP().Ry() != null) {
                g.RQ();
                g.RP().Ry().set(327682, stringBuilder.toString());
            }
        }
        AppMethodBeat.o(59776);
    }

    public static void m(Map<String, String> map) {
        AppMethodBeat.i(59777);
        map.clear();
        g.RQ();
        if (g.RP() != null) {
            g.RQ();
            if (g.RP().Ry() != null) {
                g.RQ();
                String str = (String) g.RP().Ry().get(327682, null);
                if (str == null) {
                    AppMethodBeat.o(59777);
                    return;
                }
                String[] split = str.split(IOUtils.LINE_SEPARATOR_UNIX);
                if (split.length % 2 != 0) {
                    ab.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(split.length));
                    AppMethodBeat.o(59777);
                    return;
                }
                for (int i = 0; i < split.length; i += 2) {
                    map.put(split[i], split[i + 1]);
                }
                AppMethodBeat.o(59777);
                return;
            }
        }
        ab.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
        AppMethodBeat.o(59777);
    }

    public static Boolean Zf() {
        AppMethodBeat.i(59778);
        Boolean bool;
        if (g.RK()) {
            g.RQ();
            String str = (String) g.RP().Ry().get(6, null);
            g.RQ();
            if (!bo.e((Boolean) g.RP().Ry().get(340241, null)) || bo.isNullOrNil(str)) {
                bool = Boolean.FALSE;
                AppMethodBeat.o(59778);
                return bool;
            }
            String str2 = "86";
            if (str.startsWith("+")) {
                str = av.Ps(str);
            } else {
                str = str2;
            }
            if (str == "86") {
                bool = Boolean.FALSE;
                AppMethodBeat.o(59778);
                return bool;
            }
            bool = Boolean.TRUE;
            AppMethodBeat.o(59778);
            return bool;
        }
        ab.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
        bool = Boolean.FALSE;
        AppMethodBeat.o(59778);
        return bool;
    }

    public static Map<String, String> Zg() {
        AppMethodBeat.i(59779);
        HashMap hashMap = new HashMap();
        hashMap.put("login_weixin_username", Yz());
        g.RQ();
        hashMap.put("login_user_name", (String) g.RP().Ry().get(a.USERINFO_LAST_LOGIN_USERNAME_STRING, null));
        g.RQ();
        hashMap.put("last_avatar_path", (String) g.RP().Ry().get(a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, null));
        g.RQ();
        hashMap.put("last_login_bind_mobile", (String) g.RP().Ry().get(6, null));
        g.RQ();
        hashMap.put("last_login_bind_email", (String) g.RP().Ry().get(5, null));
        g.RQ();
        hashMap.put("last_login_bind_qq", String.valueOf(g.RP().Ry().get(9, null)));
        g.RQ();
        hashMap.put("last_login_use_voice", String.valueOf(g.RP().Ry().get(40, null)));
        AppMethodBeat.o(59779);
        return hashMap;
    }
}
