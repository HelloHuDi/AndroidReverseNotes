package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

public final class b {
    public static boolean a(cl clVar, bl blVar, int i) {
        AppMethodBeat.i(76755);
        if (clVar == null || blVar == null) {
            ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
            if (clVar != null) {
                clVar.cvA.cvG = R.string.boh;
            }
            AppMethodBeat.o(76755);
            return false;
        }
        String v;
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        abl.alD("newsapp");
        abl.alE(r.Yz());
        abl.alE(r.Yz());
        abl.LN(1);
        abl.ml(blVar.fna);
        abl.alH(blVar.fnf);
        abl.alK(blVar.getUrl());
        abl.alL("newsapp");
        aar.akZ(String.valueOf(blVar.fnf));
        if (i == 0) {
            v = q.v(blVar.aan(), blVar.type, "@T");
        } else {
            v = q.v(blVar.aan(), blVar.type, "@S");
        }
        if (e.ct(v)) {
            aar.akW(v);
        } else {
            aar.oY(true);
            aar.akQ(blVar.aan());
            abu abu = new abu();
            abu.alT(blVar.aan());
            abf.b(abu);
        }
        aar.LE(5);
        aar.akH(blVar.getTitle());
        aar.akI(blVar.getDigest());
        aar.oX(true);
        abf.a(abl);
        abf.wiv.add(aar);
        clVar.cvA.desc = blVar.getTitle();
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 5;
        AppMethodBeat.o(76755);
        return true;
    }
}
