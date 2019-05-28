package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ad;

public final class b {
    public static String at(String str, String str2) {
        AppMethodBeat.i(77832);
        String str3 = str + "?access_token=" + str2;
        AppMethodBeat.o(77832);
        return str3;
    }

    public static Bitmap pP(String str) {
        AppMethodBeat.i(77833);
        Bitmap a = a(str + "@google", false, -1);
        AppMethodBeat.o(77833);
        return a;
    }

    private static String pQ(String str) {
        AppMethodBeat.i(77834);
        String str2 = "http://graph.facebook.com/" + str + "/picture";
        AppMethodBeat.o(77834);
        return str2;
    }

    public static void pR(String str) {
        AppMethodBeat.i(77835);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77835);
            return;
        }
        String str2 = str + "@fb";
        h qo = o.act().qo(str2);
        if (qo != null && str2.equals(qo.getUsername()) && 3 == qo.dtR) {
            AppMethodBeat.o(77835);
            return;
        }
        if (qo == null) {
            qo = new h();
        }
        qo.username = str2;
        qo.dtR = 3;
        qo.frW = pQ(str);
        qo.frV = pQ(str);
        qo.cB(true);
        qo.bJt = 31;
        o.act().b(qo);
        AppMethodBeat.o(77835);
    }

    public static Bitmap pS(String str) {
        AppMethodBeat.i(77836);
        Bitmap a = a(str + "@fb", false, -1);
        AppMethodBeat.o(77836);
        return a;
    }

    public static long pT(String str) {
        long j = -1;
        AppMethodBeat.i(77837);
        if (ad.aoz(str)) {
            try {
                j = bo.getLong(str.split("@")[0], -1);
                AppMethodBeat.o(77837);
            } catch (Exception e) {
                AppMethodBeat.o(77837);
            }
        } else {
            AppMethodBeat.o(77837);
        }
        return j;
    }

    private static String fq(long j) {
        AppMethodBeat.i(77838);
        String str = new p(j) + "@qqim";
        AppMethodBeat.o(77838);
        return str;
    }

    public static long pU(String str) {
        long j = -1;
        AppMethodBeat.i(77839);
        if (ad.aow(str)) {
            try {
                j = bo.getLong(str.split("@")[0], -1);
                AppMethodBeat.o(77839);
            } catch (Exception e) {
                AppMethodBeat.o(77839);
            }
        } else {
            AppMethodBeat.o(77839);
        }
        return j;
    }

    public static boolean d(long j, int i) {
        AppMethodBeat.i(77840);
        if (i != 3) {
            AppMethodBeat.o(77840);
            return false;
        }
        boolean pV = pV(fq(j));
        AppMethodBeat.o(77840);
        return pV;
    }

    public static boolean pV(String str) {
        AppMethodBeat.i(77841);
        if (str == null) {
            ab.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            AppMethodBeat.o(77841);
            return false;
        } else if (str.endsWith("@qqim")) {
            h hVar = new h();
            hVar.username = str;
            hVar.dtR = 3;
            hVar.bJt = 3;
            boolean b = o.act().b(hVar);
            AppMethodBeat.o(77841);
            return b;
        } else {
            ab.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            AppMethodBeat.o(77841);
            return false;
        }
    }

    public static Bitmap fr(long j) {
        AppMethodBeat.i(77842);
        Bitmap a = a(fq(j), false, -1);
        AppMethodBeat.o(77842);
        return a;
    }

    public static boolean U(String str, int i) {
        AppMethodBeat.i(77843);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77843);
            return false;
        }
        h qo = o.act().qo(str);
        if (qo != null && str.equals(qo.getUsername()) && i == qo.dtR) {
            AppMethodBeat.o(77843);
            return true;
        }
        if (qo == null) {
            qo = new h();
        }
        qo.username = str;
        qo.dtR = i;
        qo.bJt = 3;
        boolean b = o.act().b(qo);
        AppMethodBeat.o(77843);
        return b;
    }

    public static Bitmap pW(String str) {
        AppMethodBeat.i(139131);
        Bitmap a = a(str, false, -1);
        AppMethodBeat.o(139131);
        return a;
    }

    public static Bitmap d(String str, int i, int i2, int i3) {
        AppMethodBeat.i(77845);
        if (bo.isNullOrNil(str) || !g.RN().QY()) {
            AppMethodBeat.o(77845);
            return null;
        }
        o.acd();
        Bitmap j = d.j(str, i, i2);
        if (j == null) {
            final e eVar = new e();
            eVar.a(str, new c() {
                public final int cr(int i, int i2) {
                    AppMethodBeat.i(77831);
                    eVar.ach();
                    ab.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                    AppMethodBeat.o(77831);
                    return 0;
                }
            });
            j = a(str, false, i3);
            AppMethodBeat.o(77845);
            return j;
        }
        if (i3 > 5) {
            j = d.a(j, false, (float) i3);
        }
        AppMethodBeat.o(77845);
        return j;
    }

    public static Bitmap a(String str, boolean z, int i) {
        AppMethodBeat.i(77846);
        Bitmap b;
        if (bo.isNullOrNil(str) || !g.RN().QY()) {
            AppMethodBeat.o(77846);
            return null;
        } else if (g.RP().RB()) {
            if (ad.mR(str)) {
                str = ad.aoC(str);
            }
            b = o.acv().b(str, z, i);
            AppMethodBeat.o(77846);
            return b;
        } else {
            b = o.acd().bU(ah.getContext());
            AppMethodBeat.o(77846);
            return b;
        }
    }

    public static String pX(String str) {
        AppMethodBeat.i(77847);
        String C;
        if (bo.isNullOrNil(str) || !g.RN().QY()) {
            AppMethodBeat.o(77847);
            return null;
        } else if (!g.RP().RB()) {
            AppMethodBeat.o(77847);
            return null;
        } else if (ad.mR(str)) {
            o.acd();
            C = d.C(ad.aoC(str), false);
            AppMethodBeat.o(77847);
            return C;
        } else {
            o.acd();
            C = d.C(str, false);
            AppMethodBeat.o(77847);
            return C;
        }
    }

    public static void pY(String str) {
        AppMethodBeat.i(77848);
        h qo = o.act().qo(str);
        if (qo == null) {
            AppMethodBeat.o(77848);
        } else if (str.equals(qo.getUsername())) {
            qo.frY = 0;
            qo.bJt = 64;
            o.act().b(qo);
            AppMethodBeat.o(77848);
        } else {
            AppMethodBeat.o(77848);
        }
    }

    public static h a(String str, bbv bbv) {
        AppMethodBeat.i(77849);
        h hVar = new h();
        hVar.bJt = -1;
        hVar.username = str;
        hVar.frV = bbv.vXn;
        hVar.frW = bbv.vXm;
        ab.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", hVar.getUsername(), hVar.ack(), hVar.acl());
        hVar.cB(bbv.wGg != 0);
        if (bbv.wGb == 3 || bbv.wGb == 4) {
            hVar.dtR = bbv.wGb;
        } else if (bbv.wGb == 2) {
            hVar.dtR = 3;
            if (!r.Yz().equals(str)) {
                o.acd();
                d.E(str, false);
                o.acd();
                d.E(str, true);
                o.act().b(hVar);
                o.acv().pZ(str);
            }
        }
        AppMethodBeat.o(77849);
        return hVar;
    }
}
