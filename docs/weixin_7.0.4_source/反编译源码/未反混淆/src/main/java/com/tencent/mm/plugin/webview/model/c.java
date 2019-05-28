package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {

    public static final class a {
        public String cMn;
        public String csB;
        public String desc;
        public String thumbUrl;
        public String title;
        public String url;

        public final boolean valid() {
            AppMethodBeat.i(6571);
            if (bo.isNullOrNil(this.url)) {
                AppMethodBeat.o(6571);
                return false;
            }
            AppMethodBeat.o(6571);
            return true;
        }
    }

    public static boolean a(cl clVar, a aVar) {
        AppMethodBeat.i(6572);
        if (aVar.valid()) {
            abf abf = new abf();
            abl abl = new abl();
            aar aar = new aar();
            aar.akN(aVar.url);
            aar.akH(aVar.title);
            aar.akI(aVar.desc);
            aar.akQ(aVar.thumbUrl);
            aar.alf(aVar.cMn);
            aar.oX(true);
            aar.oY(true);
            aar.LE(5);
            abu abu = new abu();
            abu.alT(aVar.thumbUrl);
            abf.b(abu);
            abl.alD(r.Yz());
            abl.alE(r.Yz());
            abl.LN(3);
            abl.ml(bo.anU());
            abl.alJ(aVar.csB);
            abl.alK(aVar.url);
            clVar.cvA.title = aar.title;
            clVar.cvA.cvC = abf;
            clVar.cvA.type = 5;
            abf.a(abl);
            abf.wiv.add(aar);
            AppMethodBeat.o(6572);
            return true;
        }
        ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
        clVar.cvA.cvG = R.string.boh;
        AppMethodBeat.o(6572);
        return false;
    }
}
