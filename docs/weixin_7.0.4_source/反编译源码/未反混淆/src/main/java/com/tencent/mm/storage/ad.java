package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class ad extends a implements Cloneable {
    public CharSequence xHQ;
    public String xXc = null;

    public ad(String str) {
        super(str);
    }

    public static boolean aou(String str) {
        AppMethodBeat.i(60107);
        if (str != null) {
            boolean endsWith = str.endsWith("@t.qq.com");
            AppMethodBeat.o(60107);
            return endsWith;
        }
        AppMethodBeat.o(60107);
        return false;
    }

    public static boolean aov(String str) {
        AppMethodBeat.i(60108);
        if (str != null) {
            boolean endsWith = str.endsWith("@qr");
            AppMethodBeat.o(60108);
            return endsWith;
        }
        AppMethodBeat.o(60108);
        return false;
    }

    public static boolean aow(String str) {
        AppMethodBeat.i(60109);
        if (str != null) {
            boolean endsWith = str.endsWith("@qqim");
            AppMethodBeat.o(60109);
            return endsWith;
        }
        AppMethodBeat.o(60109);
        return false;
    }

    public static boolean aox(String str) {
        AppMethodBeat.i(60110);
        if (str != null) {
            boolean endsWith = str.endsWith("@openim");
            AppMethodBeat.o(60110);
            return endsWith;
        }
        AppMethodBeat.o(60110);
        return false;
    }

    public static boolean aoy(String str) {
        AppMethodBeat.i(60111);
        if (str != null) {
            boolean endsWith = str.endsWith("@im.chatroom");
            AppMethodBeat.o(60111);
            return endsWith;
        }
        AppMethodBeat.o(60111);
        return false;
    }

    public static boolean aoz(String str) {
        AppMethodBeat.i(60112);
        if (str != null) {
            boolean endsWith = str.endsWith("@fb");
            AppMethodBeat.o(60112);
            return endsWith;
        }
        AppMethodBeat.o(60112);
        return false;
    }

    public static boolean mR(String str) {
        AppMethodBeat.i(60113);
        if (str == null) {
            AppMethodBeat.o(60113);
            return false;
        } else if (str.contains("@bottle:") || str.endsWith("@bottle")) {
            AppMethodBeat.o(60113);
            return true;
        } else {
            AppMethodBeat.o(60113);
            return false;
        }
    }

    public static boolean Mn(int i) {
        return (i & 8) > 0;
    }

    public static boolean mg(String str) {
        AppMethodBeat.i(60114);
        if (str != null) {
            boolean endsWith = str.endsWith("@app");
            AppMethodBeat.o(60114);
            return endsWith;
        }
        AppMethodBeat.o(60114);
        return false;
    }

    public static boolean aoA(String str) {
        AppMethodBeat.i(60115);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
            AppMethodBeat.o(60115);
            return false;
        } else if (aox(str)) {
            AppMethodBeat.o(60115);
            return true;
        } else {
            String O = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nv().O("HideWechatID", "idprefix");
            if (O != null) {
                String[] split = O.split(";");
                int i = 0;
                while (i < split.length) {
                    if (split[i] == null || !str.startsWith(split[i])) {
                        i++;
                    } else {
                        AppMethodBeat.o(60115);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(60115);
            return false;
        }
    }

    public static boolean aoB(String str) {
        AppMethodBeat.i(60116);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(60116);
            return true;
        }
        String[] split = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";");
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str2 = split[i];
            if (bo.isNullOrNil(str2) || !str.startsWith(str2)) {
                i++;
            } else {
                AppMethodBeat.o(60116);
                return true;
            }
        }
        AppMethodBeat.o(60116);
        return false;
    }

    public static String aoC(String str) {
        AppMethodBeat.i(60117);
        if (mR(str)) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split == null || split.length <= 0) {
                AppMethodBeat.o(60117);
                return str;
            }
            str = split[0];
            AppMethodBeat.o(60117);
            return str;
        } else if (str == null || !str.contains("@")) {
            str = str + "@bottle";
            AppMethodBeat.o(60117);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(60117);
            return str;
        }
    }

    public static int dsg() {
        return 16;
    }

    public static int dsh() {
        return 8;
    }

    public final boolean dsi() {
        AppMethodBeat.i(60118);
        if (((long) (((int) bo.anT()) - this.duj)) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            AppMethodBeat.o(60118);
            return true;
        }
        AppMethodBeat.o(60118);
        return false;
    }

    public static String q(Cursor cursor) {
        AppMethodBeat.i(60119);
        String string = cursor.getString(cursor.getColumnIndex("username"));
        AppMethodBeat.o(60119);
        return string;
    }

    public final void iW(String str) {
        AppMethodBeat.i(60120);
        super.iW(str);
        dsk();
        AppMethodBeat.o(60120);
    }

    @Deprecated
    public final void iR(String str) {
        AppMethodBeat.i(60124);
        super.iR(str);
        AppMethodBeat.o(60124);
    }

    @Deprecated
    public final void iS(String str) {
        AppMethodBeat.i(60125);
        super.iS(str);
        AppMethodBeat.o(60125);
    }

    public final String getProvince() {
        AppMethodBeat.i(60126);
        String province = super.getProvince();
        AppMethodBeat.o(60126);
        return province;
    }

    public final String getCity() {
        AppMethodBeat.i(60127);
        String city = super.getCity();
        AppMethodBeat.o(60127);
        return city;
    }

    public final ad dsl() {
        ad adVar;
        AppMethodBeat.i(60129);
        try {
            adVar = (ad) super.clone();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Contact", e, "", new Object[0]);
            ab.e("MicroMsg.Contact", "clone Contact error. e: " + e.toString());
            adVar = null;
        }
        AppMethodBeat.o(60129);
        return adVar;
    }

    public final boolean dsf() {
        return (this.field_verifyFlag & 8) > 0;
    }

    public final String getCountryCode() {
        AppMethodBeat.i(60121);
        String str = this.dui;
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(60121);
            return str;
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            str = "";
            AppMethodBeat.o(60121);
            return str;
        }
        str = bo.nullAsNil(split[0]);
        AppMethodBeat.o(60121);
        return str;
    }

    public final String dsj() {
        AppMethodBeat.i(60122);
        String str = this.dui;
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(60122);
            return str;
        }
        String[] split = str.split("_");
        if (split == null || split.length < 2) {
            str = "";
            AppMethodBeat.o(60122);
            return str;
        }
        str = bo.nullAsNil(split[1]);
        AppMethodBeat.o(60122);
        return str;
    }

    public final String getCityCode() {
        AppMethodBeat.i(60123);
        String str = this.dui;
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(60123);
            return str;
        }
        String[] split = str.split("_");
        if (split == null || split.length < 3) {
            str = "";
            AppMethodBeat.o(60123);
            return str;
        }
        str = bo.nullAsNil(split[2]);
        AppMethodBeat.o(60123);
        return str;
    }

    public final void dsk() {
        AppMethodBeat.i(60128);
        String str = this.dui;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(60128);
            return;
        }
        String[] split = str.split("_");
        if (split.length > 0) {
            if (split.length > 2) {
                if (RegionCodeDecoder.apQ(split[0])) {
                    RegionCodeDecoder.duj();
                    super.iR(RegionCodeDecoder.id(split[0], split[1]));
                } else {
                    RegionCodeDecoder.duj();
                    super.iR(RegionCodeDecoder.apR(split[0]));
                }
                RegionCodeDecoder.duj();
                super.iS(RegionCodeDecoder.aD(split[0], split[1], split[2]));
                AppMethodBeat.o(60128);
                return;
            } else if (split.length == 2) {
                RegionCodeDecoder.duj();
                super.iR(RegionCodeDecoder.apR(split[0]));
                RegionCodeDecoder.duj();
                super.iS(RegionCodeDecoder.id(split[0], split[1]));
                AppMethodBeat.o(60128);
                return;
            } else {
                RegionCodeDecoder.duj();
                super.iR(RegionCodeDecoder.apR(split[0]));
                super.iS("");
            }
        }
        AppMethodBeat.o(60128);
    }
}
