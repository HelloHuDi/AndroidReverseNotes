package com.tencent.p177mm.plugin.readerapp.p1015c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C32779bl;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.readerapp.c.b */
public final class C21568b {
    /* renamed from: a */
    public static boolean m33021a(C45316cl c45316cl, C32779bl c32779bl, int i) {
        AppMethodBeat.m2504i(76755);
        if (c45316cl == null || c32779bl == null) {
            C4990ab.m7420w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
            if (c45316cl != null) {
                c45316cl.cvA.cvG = C25738R.string.boh;
            }
            AppMethodBeat.m2505o(76755);
            return false;
        }
        String v;
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        abl.alD("newsapp");
        abl.alE(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(1);
        abl.mo39136ml(c32779bl.fna);
        abl.alH(c32779bl.fnf);
        abl.alK(c32779bl.getUrl());
        abl.alL("newsapp");
        aar.akZ(String.valueOf(c32779bl.fnf));
        if (i == 0) {
            v = C30080q.m47642v(c32779bl.aan(), c32779bl.type, "@T");
        } else {
            v = C30080q.m47642v(c32779bl.aan(), c32779bl.type, "@S");
        }
        if (C5730e.m8628ct(v)) {
            aar.akW(v);
        } else {
            aar.mo27435oY(true);
            aar.akQ(c32779bl.aan());
            abu abu = new abu();
            abu.alT(c32779bl.aan());
            abf.mo74746b(abu);
        }
        aar.mo27394LE(5);
        aar.akH(c32779bl.getTitle());
        aar.akI(c32779bl.getDigest());
        aar.mo27434oX(true);
        abf.mo74737a(abl);
        abf.wiv.add(aar);
        c45316cl.cvA.desc = c32779bl.getTitle();
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 5;
        AppMethodBeat.m2505o(76755);
        return true;
    }
}
