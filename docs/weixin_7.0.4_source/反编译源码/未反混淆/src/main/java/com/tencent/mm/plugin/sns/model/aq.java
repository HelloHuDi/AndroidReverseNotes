package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class aq {
    public static String be(int i, String str) {
        AppMethodBeat.i(36634);
        String a = c.a("snsvideo", (long) i, "sns", str);
        if (bo.isNullOrNil(a)) {
            AppMethodBeat.o(36634);
            return null;
        }
        AppMethodBeat.o(36634);
        return a;
    }

    public static String ug(String str) {
        AppMethodBeat.i(36635);
        if (bo.isNullOrNil(str)) {
            String str2 = "";
            AppMethodBeat.o(36635);
            return str2;
        }
        ab.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", str, "SNS_".concat(String.valueOf(str)));
        AppMethodBeat.o(36635);
        return "SNS_".concat(String.valueOf(str));
    }

    public static String Yf(String str) {
        AppMethodBeat.i(36636);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(36636);
            return str2;
        }
        int indexOf = str.indexOf("SNS_");
        if (indexOf < 0) {
            str2 = "";
            AppMethodBeat.o(36636);
            return str2;
        }
        str2 = "";
        try {
            str2 = str.substring(indexOf + 4);
        } catch (Exception e) {
        }
        AppMethodBeat.o(36636);
        return str2;
    }

    public static String Yg(String str) {
        AppMethodBeat.i(36637);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(36637);
            return null;
        }
        ab.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", an.fZ(af.getAccSnsPath(), str), str);
        AppMethodBeat.o(36637);
        return an.fZ(af.getAccSnsPath(), str);
    }

    public static String D(bau bau) {
        AppMethodBeat.i(36638);
        if (bau == null) {
            AppMethodBeat.o(36638);
            return null;
        }
        ab.i("MicroMsg.SnsVideoLogic", "get sns video path %s", an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau));
        AppMethodBeat.o(36638);
        return an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau);
    }

    public static boolean dd(String str, int i) {
        AppMethodBeat.i(36640);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
            AppMethodBeat.o(36640);
            return false;
        }
        String ug = ug(str);
        s sVar = new s();
        sVar.fileName = ug;
        sVar.createTime = bo.anT();
        sVar.status = 130;
        sVar.egF = i;
        ab.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", ug, Boolean.valueOf(o.all().b(sVar)));
        AppMethodBeat.o(36640);
        return o.all().b(sVar);
    }

    public static boolean gb(String str, String str2) {
        int i;
        boolean b;
        AppMethodBeat.i(36642);
        s Yh = Yh(str);
        if (Yh == null) {
            Yh = new s();
            Yh.fileName = ug(str);
            i = 1;
        } else {
            i = 0;
        }
        Yh.createTime = bo.anT();
        Yh.cMW = str2;
        Yh.status = 199;
        if (i != 0) {
            b = o.all().b(Yh);
        } else {
            Yh.bJt = 33555200;
            b = o.all().c(Yh);
        }
        ab.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", str, str2, Boolean.valueOf(b));
        AppMethodBeat.o(36642);
        return b;
    }

    public static s Yh(String str) {
        AppMethodBeat.i(36643);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(36643);
            return null;
        }
        s ut = u.ut(ug(str));
        AppMethodBeat.o(36643);
        return ut;
    }

    public static String a(String str, bau bau) {
        String str2;
        AppMethodBeat.i(36639);
        if (bau == null) {
            str2 = null;
        } else {
            str2 = an.fZ(af.getAccSnsPath(), bau.Id) + i.p(bau);
            ab.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", str2);
        }
        if (e.ct(str2)) {
            ab.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", str, str2);
            AppMethodBeat.o(36639);
            return str2;
        }
        str2 = D(bau);
        boolean ct = e.ct(str2);
        s Yh = Yh(str);
        if (Yh == null) {
            if (ct) {
                ab.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", str, str2);
                AppMethodBeat.o(36639);
                return str2;
            }
            ab.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", str);
            AppMethodBeat.o(36639);
            return null;
        } else if (ct && Yh.alz()) {
            ab.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", str, str2);
            AppMethodBeat.o(36639);
            return str2;
        } else {
            ab.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", str, Boolean.valueOf(ct), Integer.valueOf(Yh.status));
            AppMethodBeat.o(36639);
            return null;
        }
    }

    public static boolean c(s sVar, int i) {
        AppMethodBeat.i(36641);
        sVar.status = 130;
        sVar.egF = i;
        sVar.bJt = 268435712;
        ab.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", sVar.getFileName(), Boolean.valueOf(o.all().c(sVar)));
        AppMethodBeat.o(36641);
        return o.all().c(sVar);
    }
}
