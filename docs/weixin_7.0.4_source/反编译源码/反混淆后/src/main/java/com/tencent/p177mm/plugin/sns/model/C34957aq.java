package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.model.aq */
public final class C34957aq {
    /* renamed from: be */
    public static String m57416be(int i, String str) {
        AppMethodBeat.m2504i(36634);
        String a = C37458c.m63162a("snsvideo", (long) i, "sns", str);
        if (C5046bo.isNullOrNil(a)) {
            AppMethodBeat.m2505o(36634);
            return null;
        }
        AppMethodBeat.m2505o(36634);
        return a;
    }

    /* renamed from: ug */
    public static String m57420ug(String str) {
        AppMethodBeat.m2504i(36635);
        if (C5046bo.isNullOrNil(str)) {
            String str2 = "";
            AppMethodBeat.m2505o(36635);
            return str2;
        }
        C4990ab.m7411d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", str, "SNS_".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(36635);
        return "SNS_".concat(String.valueOf(str));
    }

    /* renamed from: Yf */
    public static String m57412Yf(String str) {
        AppMethodBeat.m2504i(36636);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(36636);
            return str2;
        }
        int indexOf = str.indexOf("SNS_");
        if (indexOf < 0) {
            str2 = "";
            AppMethodBeat.m2505o(36636);
            return str2;
        }
        str2 = "";
        try {
            str2 = str.substring(indexOf + 4);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(36636);
        return str2;
    }

    /* renamed from: Yg */
    public static String m57413Yg(String str) {
        AppMethodBeat.m2504i(36637);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(36637);
            return null;
        }
        C4990ab.m7417i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", C3892an.m6198fZ(C13373af.getAccSnsPath(), str), str);
        AppMethodBeat.m2505o(36637);
        return C3892an.m6198fZ(C13373af.getAccSnsPath(), str);
    }

    /* renamed from: D */
    public static String m57411D(bau bau) {
        AppMethodBeat.m2504i(36638);
        if (bau == null) {
            AppMethodBeat.m2505o(36638);
            return null;
        }
        C4990ab.m7417i("MicroMsg.SnsVideoLogic", "get sns video path %s", C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau));
        AppMethodBeat.m2505o(36638);
        return C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau);
    }

    /* renamed from: dd */
    public static boolean m57418dd(String str, int i) {
        AppMethodBeat.m2504i(36640);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
            AppMethodBeat.m2505o(36640);
            return false;
        }
        String ug = C34957aq.m57420ug(str);
        C26493s c26493s = new C26493s();
        c26493s.fileName = ug;
        c26493s.createTime = C5046bo.anT();
        c26493s.status = 130;
        c26493s.egF = i;
        C4990ab.m7417i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", ug, Boolean.valueOf(C37961o.all().mo21059b(c26493s)));
        AppMethodBeat.m2505o(36640);
        return C37961o.all().mo21059b(c26493s);
    }

    /* renamed from: gb */
    public static boolean m57419gb(String str, String str2) {
        int i;
        boolean b;
        AppMethodBeat.m2504i(36642);
        C26493s Yh = C34957aq.m57414Yh(str);
        if (Yh == null) {
            Yh = new C26493s();
            Yh.fileName = C34957aq.m57420ug(str);
            i = 1;
        } else {
            i = 0;
        }
        Yh.createTime = C5046bo.anT();
        Yh.cMW = str2;
        Yh.status = 199;
        if (i != 0) {
            b = C37961o.all().mo21059b(Yh);
        } else {
            Yh.bJt = 33555200;
            b = C37961o.all().mo21060c(Yh);
        }
        C4990ab.m7417i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", str, str2, Boolean.valueOf(b));
        AppMethodBeat.m2505o(36642);
        return b;
    }

    /* renamed from: Yh */
    public static C26493s m57414Yh(String str) {
        AppMethodBeat.m2504i(36643);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(36643);
            return null;
        }
        C26493s ut = C26494u.m42268ut(C34957aq.m57420ug(str));
        AppMethodBeat.m2505o(36643);
        return ut;
    }

    /* renamed from: a */
    public static String m57415a(String str, bau bau) {
        String str2;
        AppMethodBeat.m2504i(36639);
        if (bau == null) {
            str2 = null;
        } else {
            str2 = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46126p(bau);
            C4990ab.m7417i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", str2);
        }
        if (C5730e.m8628ct(str2)) {
            C4990ab.m7417i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", str, str2);
            AppMethodBeat.m2505o(36639);
            return str2;
        }
        str2 = C34957aq.m57411D(bau);
        boolean ct = C5730e.m8628ct(str2);
        C26493s Yh = C34957aq.m57414Yh(str);
        if (Yh == null) {
            if (ct) {
                C4990ab.m7417i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", str, str2);
                AppMethodBeat.m2505o(36639);
                return str2;
            }
            C4990ab.m7417i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", str);
            AppMethodBeat.m2505o(36639);
            return null;
        } else if (ct && Yh.alz()) {
            C4990ab.m7417i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", str, str2);
            AppMethodBeat.m2505o(36639);
            return str2;
        } else {
            C4990ab.m7417i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", str, Boolean.valueOf(ct), Integer.valueOf(Yh.status));
            AppMethodBeat.m2505o(36639);
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m57417c(C26493s c26493s, int i) {
        AppMethodBeat.m2504i(36641);
        c26493s.status = 130;
        c26493s.egF = i;
        c26493s.bJt = 268435712;
        C4990ab.m7417i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", c26493s.getFileName(), Boolean.valueOf(C37961o.all().mo21060c(c26493s)));
        AppMethodBeat.m2505o(36641);
        return C37961o.all().mo21060c(c26493s);
    }
}
