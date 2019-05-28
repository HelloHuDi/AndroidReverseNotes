package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.protocal.protobuf.azc;
import com.tencent.p177mm.protocal.protobuf.bbl;
import com.tencent.p177mm.protocal.protobuf.cle;
import com.tencent.p177mm.protocal.protobuf.clf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.a.al */
public final class C9877al extends C1207m implements C1918k {
    private int cAd;
    private C1202f ehi;
    public final List<String> gwp;
    public final List<String> gwq;
    private final String gwr = ((String) C1720g.m3536RP().mo5239Ry().get(6, null));
    private int gws = 0;
    private int gwt = 0;

    public C9877al(List<String> list, List<String> list2) {
        AppMethodBeat.m2504i(108487);
        this.gwp = list;
        this.gwq = list2;
        this.cAd = 1;
        AppMethodBeat.m2505o(108487);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i = 0;
        AppMethodBeat.m2504i(108488);
        this.ehi = c1202f;
        if ((this.gwp == null || this.gwp.size() == 0) && (this.gwq == null || this.gwq.size() == 0)) {
            C4990ab.m7416i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
            AppMethodBeat.m2505o(108488);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cle();
        c1196a.fsK = new clf();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
        c1196a.fsI = C19394e.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        cle cle = (cle) acD.fsG.fsP;
        cle.vLs = this.gwr;
        cle.jBB = C1853r.m3846Yz();
        cle.vIJ = this.cAd;
        int i2 = 200;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        while (i2 > 0) {
            if (this.gwp != null && this.gws < this.gwp.size()) {
                if (this.gwp.get(this.gws) != null) {
                    bbl bbl = new bbl();
                    bbl.f2977v = (String) this.gwp.get(this.gws);
                    linkedList.add(bbl);
                }
                this.gws++;
                i2--;
            }
            if (this.gwq != null && this.gwt < this.gwq.size()) {
                if (this.gwq.get(this.gwt) != null) {
                    azc azc = new azc();
                    azc.f4412v = (String) this.gwq.get(this.gwt);
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
        C4990ab.m7418v(str, append.append(i).append("] index:[").append(this.gwt).append(",").append(this.gws).append("] req:[").append(cle.xiS.size()).append(",").append(cle.wCo.size()).append("]").toString());
        int a = mo4457a(c1902e, acD, this);
        AppMethodBeat.m2505o(108488);
        return a;
    }

    public final boolean acI() {
        return true;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(108489);
        cle cle = (cle) ((C7472b) c1929q).fsG.fsP;
        int size = cle.xiS.size() + cle.wCo.size();
        C1206b c1206b;
        if (size == 0 || size > 200) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(108489);
            return c1206b;
        } else if (cle.vLs == null || cle.vLs.length() <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(108489);
            return c1206b;
        } else if (cle.jBB == null || cle.jBB.length() <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(108489);
            return c1206b;
        } else {
            c1206b = C1206b.EOk;
            AppMethodBeat.m2505o(108489);
            return c1206b;
        }
    }

    public final int acn() {
        return 10;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108490);
        C4990ab.m7416i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            cle cle = (cle) ((C7472b) c1929q).fsG.fsP;
            C38033l.m64347at(C9877al.m17512av(cle.xiS));
            C38033l.m64347at(C9877al.m17513aw(cle.wCo));
            if ((this.gwq == null || this.gwt >= this.gwq.size()) && (this.gwp == null || this.gws >= this.gwp.size())) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(108490);
                return;
            }
            if (mo4456a(this.ftf, this.ehi) < 0) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.m2505o(108490);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108490);
    }

    /* renamed from: av */
    private static List<String> m17512av(List<azc> list) {
        AppMethodBeat.m2504i(108491);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
            AppMethodBeat.m2505o(108491);
            return arrayList;
        }
        for (azc azc : list) {
            arrayList.add(azc.f4412v);
        }
        AppMethodBeat.m2505o(108491);
        return arrayList;
    }

    /* renamed from: aw */
    private static List<String> m17513aw(List<bbl> list) {
        AppMethodBeat.m2504i(108492);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
            AppMethodBeat.m2505o(108492);
            return arrayList;
        }
        for (bbl bbl : list) {
            arrayList.add(C1178g.m2591x(C46482a.m87698ws(bbl.f2977v).getBytes()));
        }
        AppMethodBeat.m2505o(108492);
        return arrayList;
    }

    public final int getType() {
        return C19394e.CTRL_INDEX;
    }
}
