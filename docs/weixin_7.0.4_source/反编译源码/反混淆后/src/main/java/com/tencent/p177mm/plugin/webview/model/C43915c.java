package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.model.c */
public final class C43915c {

    /* renamed from: com.tencent.mm.plugin.webview.model.c$a */
    public static final class C43916a {
        public String cMn;
        public String csB;
        public String desc;
        public String thumbUrl;
        public String title;
        public String url;

        public final boolean valid() {
            AppMethodBeat.m2504i(6571);
            if (C5046bo.isNullOrNil(this.url)) {
                AppMethodBeat.m2505o(6571);
                return false;
            }
            AppMethodBeat.m2505o(6571);
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m78771a(C45316cl c45316cl, C43916a c43916a) {
        AppMethodBeat.m2504i(6572);
        if (c43916a.valid()) {
            abf abf = new abf();
            abl abl = new abl();
            aar aar = new aar();
            aar.akN(c43916a.url);
            aar.akH(c43916a.title);
            aar.akI(c43916a.desc);
            aar.akQ(c43916a.thumbUrl);
            aar.alf(c43916a.cMn);
            aar.mo27434oX(true);
            aar.mo27435oY(true);
            aar.mo27394LE(5);
            abu abu = new abu();
            abu.alT(c43916a.thumbUrl);
            abf.mo74746b(abu);
            abl.alD(C1853r.m3846Yz());
            abl.alE(C1853r.m3846Yz());
            abl.mo39126LN(3);
            abl.mo39136ml(C5046bo.anU());
            abl.alJ(c43916a.csB);
            abl.alK(c43916a.url);
            c45316cl.cvA.title = aar.title;
            c45316cl.cvA.cvC = abf;
            c45316cl.cvA.type = 5;
            abf.mo74737a(abl);
            abf.wiv.add(aar);
            AppMethodBeat.m2505o(6572);
            return true;
        }
        C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
        c45316cl.cvA.cvG = C25738R.string.boh;
        AppMethodBeat.m2505o(6572);
        return false;
    }
}
