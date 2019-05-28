package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C42073vg;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.protocal.protobuf.cuk;
import com.tencent.p177mm.protocal.protobuf.cuv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.l */
public final class C14411l extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26409);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11032));
        arrayList.add(Integer.valueOf(11034));
        AppMethodBeat.m2505o(26409);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: HI */
    public final boolean mo9569HI(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        byte[] toByteArray;
        AppMethodBeat.m2504i(26410);
        switch (i) {
            case 11032:
                cuk cuk = new cuk();
                if (C26373g.m41964Nu().getInt("WearPayBlock", 0) == 0) {
                    C46393a.m87276gn(13, 0);
                    C46393a.m87275HH(15);
                    C42073vg c42073vg = new C42073vg();
                    c42073vg.cSe.action = 3;
                    C4879a.xxA.mo10055m(c42073vg);
                    switch (c42073vg.cSf.cSg) {
                        case 1:
                            cuk.xcZ = 0;
                            cuk.xpw = "";
                            cuk.xqL = new C1332b(c42073vg.cSf.cSk);
                            cuk.xqM = new C1332b(c42073vg.cSf.cSl);
                            cuk.xqN = c42073vg.cSf.cSm;
                            cuk.xqO = c42073vg.cSf.cSn;
                            break;
                        case 2:
                            cuk.xcZ = 196611;
                            cuk.xpw = C4996ah.getContext().getString(C25738R.string.fxn);
                            break;
                        case 3:
                            cuk.xcZ = 196609;
                            cuk.xpw = C4996ah.getContext().getString(C25738R.string.fxm);
                            break;
                        case 4:
                            cuk.xcZ = 196610;
                            cuk.xpw = C4996ah.getContext().getString(C25738R.string.fxq);
                            break;
                        case 5:
                            cuk.xcZ = 196612;
                            cuk.xpw = C4996ah.getContext().getString(C25738R.string.fxo);
                            break;
                    }
                }
                cuk.xcZ = 16777215;
                cuk.xpw = C4996ah.getContext().getString(C25738R.string.fxp);
                try {
                    toByteArray = cuk.toByteArray();
                    AppMethodBeat.m2505o(26410);
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
                C25985d.m41448H(C4996ah.getContext(), cuv.xqS, cuv.xqT);
                break;
        }
        toByteArray = new byte[0];
        AppMethodBeat.m2505o(26410);
        return toByteArray;
    }

    /* renamed from: HK */
    public final boolean mo26668HK(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }
}
