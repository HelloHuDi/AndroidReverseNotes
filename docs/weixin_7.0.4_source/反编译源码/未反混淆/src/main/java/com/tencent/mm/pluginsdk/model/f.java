package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.bo;

public final class f implements ad {
    public final boolean a(cl clVar, Intent intent) {
        AppMethodBeat.i(27273);
        boolean a = e.a(clVar, intent);
        AppMethodBeat.o(27273);
        return a;
    }

    public final boolean a(cl clVar, int i, String str) {
        AppMethodBeat.i(27274);
        boolean a = e.a(clVar, i, str);
        AppMethodBeat.o(27274);
        return a;
    }

    public final boolean a(cl clVar, long j) {
        AppMethodBeat.i(27275);
        boolean a = e.a(clVar, j);
        AppMethodBeat.o(27275);
        return a;
    }

    public final boolean a(cl clVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        AppMethodBeat.i(27272);
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        aar.LE(5);
        aar.akW(str7);
        aar.akN(str3);
        aar.LD(i);
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
        aar.a(aau);
        abl.alD(str8);
        abl.alE(r.Yz());
        abl.LN(0);
        abl.ml(bo.anU());
        abf.a(abl);
        abf.wiv.add(aar);
        clVar.cvA.title = aar.title;
        clVar.cvA.desc = aar.title;
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 4;
        AppMethodBeat.o(27272);
        return true;
    }

    public final boolean a(cl clVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(27276);
        String format = String.format("%s#%s", new Object[]{str, ""});
        abf abf = new abf();
        abl abl = new abl();
        abl.alD(str2);
        abl.LN(2);
        abl.ml(System.currentTimeMillis());
        abl.alI(String.valueOf(str));
        abl.alF(format);
        aar aar = new aar();
        aar.akZ(format);
        aar.oY(true);
        aar.LE(5);
        aar.akH(str3);
        aar.akI(str4);
        aar.alg(str5);
        aar.oX(true);
        abf.wiv.add(aar);
        abu abu = new abu();
        abu.alT(str6);
        abu.alS(str7);
        abf.b(abu);
        abf.a(abl);
        clVar.cvA.cvC = abf;
        clVar.cvA.desc = str3;
        clVar.cvA.type = 5;
        AppMethodBeat.o(27276);
        return true;
    }
}
