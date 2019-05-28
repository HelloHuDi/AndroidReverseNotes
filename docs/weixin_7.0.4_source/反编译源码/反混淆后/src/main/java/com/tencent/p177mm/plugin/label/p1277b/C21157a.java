package com.tencent.p177mm.plugin.label.p1277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42558b;
import com.tencent.p177mm.plugin.label.C21160e;
import com.tencent.p177mm.protocal.protobuf.C15323cd;
import com.tencent.p177mm.protocal.protobuf.C30172cc;
import com.tencent.p177mm.protocal.protobuf.axj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46619af;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.label.b.a */
public final class C21157a extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private LinkedList<axj> nHw = new LinkedList();

    public C21157a(String str) {
        AppMethodBeat.m2504i(22520);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30172cc();
        c1196a.fsK = new C15323cd();
        c1196a.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        c1196a.fsI = C42558b.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        if (!C5046bo.isNullOrNil(str)) {
            axj axj = new axj();
            axj.wBq = str;
            this.nHw.add(axj);
        }
        AppMethodBeat.m2505o(22520);
    }

    public C21157a(List<String> list) {
        AppMethodBeat.m2504i(22521);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30172cc();
        c1196a.fsK = new C15323cd();
        c1196a.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        c1196a.fsI = C42558b.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                axj axj = new axj();
                axj.wBq = (String) list.get(i);
                this.nHw.add(axj);
            }
        }
        AppMethodBeat.m2505o(22521);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(22522);
        C4990ab.m7410d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
        this.ehi = c1202f;
        C30172cc c30172cc = (C30172cc) this.ehh.fsG.fsP;
        if (this.nHw == null || this.nHw.size() <= 0) {
            C4990ab.m7412e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
            c1202f.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
            AppMethodBeat.m2505o(22522);
            return 0;
        }
        c30172cc.vEm = this.nHw;
        c30172cc.vEl = this.nHw.size();
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(22522);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(22523);
        C4990ab.m7411d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        C15323cd bJb = bJb();
        if (bJb != null) {
            LinkedList linkedList = bJb.vEm;
            ArrayList arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i4 = 0; i4 < size; i4++) {
                axj axj = (axj) linkedList.get(i4);
                C46619af c46619af = new C46619af();
                c46619af.field_labelID = axj.wBr;
                c46619af.field_labelName = axj.wBq;
                c46619af.field_labelPYFull = C9790g.m17432vo(axj.wBq);
                c46619af.field_labelPYShort = C9790g.m17433vp(axj.wBq);
                c46619af.field_isTemporary = false;
                arrayList.add(c46619af);
            }
            C21160e.bIZ().mo64079eq(arrayList);
            C21160e.bIZ().mo64080er(arrayList);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(22523);
    }

    public final int getType() {
        return C42558b.CTRL_INDEX;
    }

    public final C15323cd bJb() {
        return (C15323cd) this.ehh.fsH.fsP;
    }
}
