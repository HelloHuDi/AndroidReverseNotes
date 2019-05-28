package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.storage.ad */
public final class C7616ad extends C7486a implements Cloneable {
    public CharSequence xHQ;
    public String xXc = null;

    public C7616ad(String str) {
        super(str);
    }

    public static boolean aou(String str) {
        AppMethodBeat.m2504i(60107);
        if (str != null) {
            boolean endsWith = str.endsWith("@t.qq.com");
            AppMethodBeat.m2505o(60107);
            return endsWith;
        }
        AppMethodBeat.m2505o(60107);
        return false;
    }

    public static boolean aov(String str) {
        AppMethodBeat.m2504i(60108);
        if (str != null) {
            boolean endsWith = str.endsWith("@qr");
            AppMethodBeat.m2505o(60108);
            return endsWith;
        }
        AppMethodBeat.m2505o(60108);
        return false;
    }

    public static boolean aow(String str) {
        AppMethodBeat.m2504i(60109);
        if (str != null) {
            boolean endsWith = str.endsWith("@qqim");
            AppMethodBeat.m2505o(60109);
            return endsWith;
        }
        AppMethodBeat.m2505o(60109);
        return false;
    }

    public static boolean aox(String str) {
        AppMethodBeat.m2504i(60110);
        if (str != null) {
            boolean endsWith = str.endsWith("@openim");
            AppMethodBeat.m2505o(60110);
            return endsWith;
        }
        AppMethodBeat.m2505o(60110);
        return false;
    }

    public static boolean aoy(String str) {
        AppMethodBeat.m2504i(60111);
        if (str != null) {
            boolean endsWith = str.endsWith("@im.chatroom");
            AppMethodBeat.m2505o(60111);
            return endsWith;
        }
        AppMethodBeat.m2505o(60111);
        return false;
    }

    public static boolean aoz(String str) {
        AppMethodBeat.m2504i(60112);
        if (str != null) {
            boolean endsWith = str.endsWith("@fb");
            AppMethodBeat.m2505o(60112);
            return endsWith;
        }
        AppMethodBeat.m2505o(60112);
        return false;
    }

    /* renamed from: mR */
    public static boolean m13548mR(String str) {
        AppMethodBeat.m2504i(60113);
        if (str == null) {
            AppMethodBeat.m2505o(60113);
            return false;
        } else if (str.contains("@bottle:") || str.endsWith("@bottle")) {
            AppMethodBeat.m2505o(60113);
            return true;
        } else {
            AppMethodBeat.m2505o(60113);
            return false;
        }
    }

    /* renamed from: Mn */
    public static boolean m13547Mn(int i) {
        return (i & 8) > 0;
    }

    /* renamed from: mg */
    public static boolean m13549mg(String str) {
        AppMethodBeat.m2504i(60114);
        if (str != null) {
            boolean endsWith = str.endsWith("@app");
            AppMethodBeat.m2505o(60114);
            return endsWith;
        }
        AppMethodBeat.m2505o(60114);
        return false;
    }

    public static boolean aoA(String str) {
        AppMethodBeat.m2504i(60115);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
            AppMethodBeat.m2505o(60115);
            return false;
        } else if (C7616ad.aox(str)) {
            AppMethodBeat.m2505o(60115);
            return true;
        } else {
            String O = ((C7234a) C1720g.m3528K(C7234a.class)).mo15609Nv().mo5301O("HideWechatID", "idprefix");
            if (O != null) {
                String[] split = O.split(";");
                int i = 0;
                while (i < split.length) {
                    if (split[i] == null || !str.startsWith(split[i])) {
                        i++;
                    } else {
                        AppMethodBeat.m2505o(60115);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(60115);
            return false;
        }
    }

    public static boolean aoB(String str) {
        AppMethodBeat.m2504i(60116);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(60116);
            return true;
        }
        String[] split = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;".split(";");
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str2 = split[i];
            if (C5046bo.isNullOrNil(str2) || !str.startsWith(str2)) {
                i++;
            } else {
                AppMethodBeat.m2505o(60116);
                return true;
            }
        }
        AppMethodBeat.m2505o(60116);
        return false;
    }

    public static String aoC(String str) {
        AppMethodBeat.m2504i(60117);
        if (C7616ad.m13548mR(str)) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split == null || split.length <= 0) {
                AppMethodBeat.m2505o(60117);
                return str;
            }
            str = split[0];
            AppMethodBeat.m2505o(60117);
            return str;
        } else if (str == null || !str.contains("@")) {
            str = str + "@bottle";
            AppMethodBeat.m2505o(60117);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(60117);
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
        AppMethodBeat.m2504i(60118);
        if (((long) (((int) C5046bo.anT()) - this.duj)) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            AppMethodBeat.m2505o(60118);
            return true;
        }
        AppMethodBeat.m2505o(60118);
        return false;
    }

    /* renamed from: q */
    public static String m13550q(Cursor cursor) {
        AppMethodBeat.m2504i(60119);
        String string = cursor.getString(cursor.getColumnIndex("username"));
        AppMethodBeat.m2505o(60119);
        return string;
    }

    /* renamed from: iW */
    public final void mo14724iW(String str) {
        AppMethodBeat.m2504i(60120);
        super.mo14724iW(str);
        dsk();
        AppMethodBeat.m2505o(60120);
    }

    @Deprecated
    /* renamed from: iR */
    public final void mo14719iR(String str) {
        AppMethodBeat.m2504i(60124);
        super.mo14719iR(str);
        AppMethodBeat.m2505o(60124);
    }

    @Deprecated
    /* renamed from: iS */
    public final void mo14720iS(String str) {
        AppMethodBeat.m2504i(60125);
        super.mo14720iS(str);
        AppMethodBeat.m2505o(60125);
    }

    public final String getProvince() {
        AppMethodBeat.m2504i(60126);
        String province = super.getProvince();
        AppMethodBeat.m2505o(60126);
        return province;
    }

    public final String getCity() {
        AppMethodBeat.m2504i(60127);
        String city = super.getCity();
        AppMethodBeat.m2505o(60127);
        return city;
    }

    public final C7616ad dsl() {
        C7616ad c7616ad;
        AppMethodBeat.m2504i(60129);
        try {
            c7616ad = (C7616ad) super.clone();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Contact", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.Contact", "clone Contact error. e: " + e.toString());
            c7616ad = null;
        }
        AppMethodBeat.m2505o(60129);
        return c7616ad;
    }

    public final boolean dsf() {
        return (this.field_verifyFlag & 8) > 0;
    }

    public final String getCountryCode() {
        AppMethodBeat.m2504i(60121);
        String str = this.dui;
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(60121);
            return str;
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            str = "";
            AppMethodBeat.m2505o(60121);
            return str;
        }
        str = C5046bo.nullAsNil(split[0]);
        AppMethodBeat.m2505o(60121);
        return str;
    }

    public final String dsj() {
        AppMethodBeat.m2504i(60122);
        String str = this.dui;
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(60122);
            return str;
        }
        String[] split = str.split("_");
        if (split == null || split.length < 2) {
            str = "";
            AppMethodBeat.m2505o(60122);
            return str;
        }
        str = C5046bo.nullAsNil(split[1]);
        AppMethodBeat.m2505o(60122);
        return str;
    }

    public final String getCityCode() {
        AppMethodBeat.m2504i(60123);
        String str = this.dui;
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(60123);
            return str;
        }
        String[] split = str.split("_");
        if (split == null || split.length < 3) {
            str = "";
            AppMethodBeat.m2505o(60123);
            return str;
        }
        str = C5046bo.nullAsNil(split[2]);
        AppMethodBeat.m2505o(60123);
        return str;
    }

    public final void dsk() {
        AppMethodBeat.m2504i(60128);
        String str = this.dui;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(60128);
            return;
        }
        String[] split = str.split("_");
        if (split.length > 0) {
            if (split.length > 2) {
                if (RegionCodeDecoder.apQ(split[0])) {
                    RegionCodeDecoder.duj();
                    super.mo14719iR(RegionCodeDecoder.m7798id(split[0], split[1]));
                } else {
                    RegionCodeDecoder.duj();
                    super.mo14719iR(RegionCodeDecoder.apR(split[0]));
                }
                RegionCodeDecoder.duj();
                super.mo14720iS(RegionCodeDecoder.m7797aD(split[0], split[1], split[2]));
                AppMethodBeat.m2505o(60128);
                return;
            } else if (split.length == 2) {
                RegionCodeDecoder.duj();
                super.mo14719iR(RegionCodeDecoder.apR(split[0]));
                RegionCodeDecoder.duj();
                super.mo14720iS(RegionCodeDecoder.m7798id(split[0], split[1]));
                AppMethodBeat.m2505o(60128);
                return;
            } else {
                RegionCodeDecoder.duj();
                super.mo14719iR(RegionCodeDecoder.apR(split[0]));
                super.mo14720iS("");
            }
        }
        AppMethodBeat.m2505o(60128);
    }
}
