package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.bt.b;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class l extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26409);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11032));
        arrayList.add(Integer.valueOf(11034));
        AppMethodBeat.o(26409);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean HI(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        byte[] toByteArray;
        AppMethodBeat.i(26410);
        switch (i) {
            case 11032:
                cuk cuk = new cuk();
                if (g.Nu().getInt("WearPayBlock", 0) == 0) {
                    a.gn(13, 0);
                    a.HH(15);
                    vg vgVar = new vg();
                    vgVar.cSe.action = 3;
                    com.tencent.mm.sdk.b.a.xxA.m(vgVar);
                    switch (vgVar.cSf.cSg) {
                        case 1:
                            cuk.xcZ = 0;
                            cuk.xpw = "";
                            cuk.xqL = new b(vgVar.cSf.cSk);
                            cuk.xqM = new b(vgVar.cSf.cSl);
                            cuk.xqN = vgVar.cSf.cSm;
                            cuk.xqO = vgVar.cSf.cSn;
                            break;
                        case 2:
                            cuk.xcZ = 196611;
                            cuk.xpw = ah.getContext().getString(R.string.fxn);
                            break;
                        case 3:
                            cuk.xcZ = 196609;
                            cuk.xpw = ah.getContext().getString(R.string.fxm);
                            break;
                        case 4:
                            cuk.xcZ = 196610;
                            cuk.xpw = ah.getContext().getString(R.string.fxq);
                            break;
                        case 5:
                            cuk.xcZ = 196612;
                            cuk.xpw = ah.getContext().getString(R.string.fxo);
                            break;
                    }
                }
                cuk.xcZ = 16777215;
                cuk.xpw = ah.getContext().getString(R.string.fxp);
                try {
                    toByteArray = cuk.toByteArray();
                    AppMethodBeat.o(26410);
                    return toByteArray;
                } catch (IOException e) {
                    break;
                }
            case 11034:
                cuv cuv = new cuv();
                try {
                    cuv.parseFrom(bArr);
                } catch (IOException e2) {
                }
                d.H(ah.getContext(), cuv.xqS, cuv.xqT);
                break;
        }
        toByteArray = new byte[0];
        AppMethodBeat.o(26410);
        return toByteArray;
    }

    public final boolean HK(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }
}
