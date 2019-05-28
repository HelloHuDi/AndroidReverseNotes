package com.tencent.p177mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aau;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.model.f */
public final class C46497f implements C6893ad {
    /* renamed from: a */
    public final boolean mo15154a(C45316cl c45316cl, Intent intent) {
        AppMethodBeat.m2504i(27273);
        boolean a = C40443e.m69370a(c45316cl, intent);
        AppMethodBeat.m2505o(27273);
        return a;
    }

    /* renamed from: a */
    public final boolean mo15151a(C45316cl c45316cl, int i, String str) {
        AppMethodBeat.m2504i(27274);
        boolean a = C40443e.m69368a(c45316cl, i, str);
        AppMethodBeat.m2505o(27274);
        return a;
    }

    /* renamed from: a */
    public final boolean mo15153a(C45316cl c45316cl, long j) {
        AppMethodBeat.m2504i(27275);
        boolean a = C40443e.m69369a(c45316cl, j);
        AppMethodBeat.m2505o(27275);
        return a;
    }

    /* renamed from: a */
    public final boolean mo15152a(C45316cl c45316cl, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        AppMethodBeat.m2504i(27272);
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        aar.mo27394LE(5);
        aar.akW(str7);
        aar.akN(str3);
        aar.mo27393LD(i);
        aar.akH(str);
        aar.akI(str2);
        aar.alf(str11);
        aau aau = new aau();
        aau.fiI = str;
        aau.wid = i;
        aau.fiG = str3;
        aau.fiK = str5;
        aau.fiJ = str4;
        aau.fiL = str6;
        aau.fiM = str9;
        aau.fiN = str10;
        aar.mo27399a(aau);
        abl.alD(str8);
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(0);
        abl.mo39136ml(C5046bo.anU());
        abf.mo74737a(abl);
        abf.wiv.add(aar);
        c45316cl.cvA.title = aar.title;
        c45316cl.cvA.desc = aar.title;
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 4;
        AppMethodBeat.m2505o(27272);
        return true;
    }

    /* renamed from: a */
    public final boolean mo15155a(C45316cl c45316cl, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(27276);
        String format = String.format("%s#%s", new Object[]{str, ""});
        abf abf = new abf();
        abl abl = new abl();
        abl.alD(str2);
        abl.mo39126LN(2);
        abl.mo39136ml(System.currentTimeMillis());
        abl.alI(String.valueOf(str));
        abl.alF(format);
        aar aar = new aar();
        aar.akZ(format);
        aar.mo27435oY(true);
        aar.mo27394LE(5);
        aar.akH(str3);
        aar.akI(str4);
        aar.alg(str5);
        aar.mo27434oX(true);
        abf.wiv.add(aar);
        abu abu = new abu();
        abu.alT(str6);
        abu.alS(str7);
        abf.mo74746b(abu);
        abf.mo74737a(abl);
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.desc = str3;
        c45316cl.cvA.type = 5;
        AppMethodBeat.m2505o(27276);
        return true;
    }
}
