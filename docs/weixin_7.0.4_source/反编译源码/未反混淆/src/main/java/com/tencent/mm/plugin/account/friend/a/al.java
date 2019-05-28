package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class al extends m implements k {
    private int cAd;
    private f ehi;
    public final List<String> gwp;
    public final List<String> gwq;
    private final String gwr = ((String) g.RP().Ry().get(6, null));
    private int gws = 0;
    private int gwt = 0;

    public al(List<String> list, List<String> list2) {
        AppMethodBeat.i(108487);
        this.gwp = list;
        this.gwq = list2;
        this.cAd = 1;
        AppMethodBeat.o(108487);
    }

    public final int a(e eVar, f fVar) {
        int i = 0;
        AppMethodBeat.i(108488);
        this.ehi = fVar;
        if ((this.gwp == null || this.gwp.size() == 0) && (this.gwq == null || this.gwq.size() == 0)) {
            ab.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
            AppMethodBeat.o(108488);
            return -1;
        }
        a aVar = new a();
        aVar.fsJ = new cle();
        aVar.fsK = new clf();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        cle cle = (cle) acD.fsG.fsP;
        cle.vLs = this.gwr;
        cle.jBB = r.Yz();
        cle.vIJ = this.cAd;
        int i2 = 200;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        while (i2 > 0) {
            if (this.gwp != null && this.gws < this.gwp.size()) {
                if (this.gwp.get(this.gws) != null) {
                    bbl bbl = new bbl();
                    bbl.v = (String) this.gwp.get(this.gws);
                    linkedList.add(bbl);
                }
                this.gws++;
                i2--;
            }
            if (this.gwq != null && this.gwt < this.gwq.size()) {
                if (this.gwq.get(this.gwt) != null) {
                    azc azc = new azc();
                    azc.v = (String) this.gwq.get(this.gwt);
                    linkedList2.add(azc);
                }
                this.gwt++;
                i2--;
            }
            if ((this.gwq == null || this.gwt >= this.gwq.size()) && (this.gwp == null || this.gws >= this.gwp.size())) {
                break;
            }
        }
        cle.wCo = linkedList;
        cle.xiQ = linkedList.size();
        cle.xiS = linkedList2;
        cle.xiR = linkedList2.size();
        String str = "MicroMsg.NetSceneUploadMContact";
        StringBuilder append = new StringBuilder("doscene in:[").append(this.gwq == null ? 0 : this.gwq.size()).append(",");
        if (this.gwp != null) {
            i = this.gwp.size();
        }
        ab.v(str, append.append(i).append("] index:[").append(this.gwt).append(",").append(this.gws).append("] req:[").append(cle.xiS.size()).append(",").append(cle.wCo.size()).append("]").toString());
        int a = a(eVar, acD, this);
        AppMethodBeat.o(108488);
        return a;
    }

    public final boolean acI() {
        return true;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(108489);
        cle cle = (cle) ((b) qVar).fsG.fsP;
        int size = cle.xiS.size() + cle.wCo.size();
        m.b bVar;
        if (size == 0 || size > 200) {
            ab.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
            bVar = m.b.EFailed;
            AppMethodBeat.o(108489);
            return bVar;
        } else if (cle.vLs == null || cle.vLs.length() <= 0) {
            ab.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
            bVar = m.b.EFailed;
            AppMethodBeat.o(108489);
            return bVar;
        } else if (cle.jBB == null || cle.jBB.length() <= 0) {
            ab.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
            bVar = m.b.EFailed;
            AppMethodBeat.o(108489);
            return bVar;
        } else {
            bVar = m.b.EOk;
            AppMethodBeat.o(108489);
            return bVar;
        }
    }

    public final int acn() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108490);
        ab.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            cle cle = (cle) ((b) qVar).fsG.fsP;
            l.at(av(cle.xiS));
            l.at(aw(cle.wCo));
            if ((this.gwq == null || this.gwt >= this.gwq.size()) && (this.gwp == null || this.gws >= this.gwp.size())) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(108490);
                return;
            }
            if (a(this.ftf, this.ehi) < 0) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.o(108490);
            return;
        }
        ab.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108490);
    }

    private static List<String> av(List<azc> list) {
        AppMethodBeat.i(108491);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            ab.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
            AppMethodBeat.o(108491);
            return arrayList;
        }
        for (azc azc : list) {
            arrayList.add(azc.v);
        }
        AppMethodBeat.o(108491);
        return arrayList;
    }

    private static List<String> aw(List<bbl> list) {
        AppMethodBeat.i(108492);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            ab.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
            AppMethodBeat.o(108492);
            return arrayList;
        }
        for (bbl bbl : list) {
            arrayList.add(com.tencent.mm.a.g.x(com.tencent.mm.pluginsdk.a.ws(bbl.v).getBytes()));
        }
        AppMethodBeat.o(108492);
        return arrayList;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX;
    }
}
