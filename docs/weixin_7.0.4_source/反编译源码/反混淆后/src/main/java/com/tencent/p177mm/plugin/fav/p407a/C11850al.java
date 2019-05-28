package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bca;
import com.tencent.p177mm.protocal.protobuf.bcb;
import com.tencent.p177mm.protocal.protobuf.bcc;
import com.tencent.p177mm.protocal.protobuf.bcd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.a.al */
public final class C11850al extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public int mgq;
    public C43057f mgr;
    private LinkedList<bcd> mgs;
    private LinkedList<bca> mgt;
    public String mgu;
    private int scene;
    public int type;

    private C11850al(int i, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2, int i2) {
        AppMethodBeat.m2504i(102743);
        this.ehi = null;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bcb();
        c1196a.fsK = new bcc();
        c1196a.uri = "/cgi-bin/micromsg-bin/modfavitem";
        c1196a.fsI = v2helper.EMethodSetAgcRxOn;
        c1196a.fsL = 216;
        c1196a.fsM = 1000000216;
        this.ehh = c1196a.acD();
        this.mgs = linkedList2;
        this.mgt = linkedList;
        this.mgq = i;
        this.type = i2;
        AppMethodBeat.m2505o(102743);
    }

    public C11850al(int i, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
    }

    public C11850al(int i, C43057f c43057f) {
        this(i, c43057f.field_modItem.mgt, c43057f.field_modItem.wie, 1);
        this.mgr = c43057f;
    }

    public C11850al(int i, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2, String str) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.mgu = str;
    }

    public C11850al(int i, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2, String str, byte b) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.mgu = str;
        this.scene = 1;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102744);
        if (this.scene == 0 && (this.mgt == null || this.mgt.size() == 0)) {
            AppMethodBeat.m2505o(102744);
            return -1;
        }
        bcb bcb = (bcb) this.ehh.fsG.fsP;
        bcb.wGE = this.mgt.size();
        if (this.mgs != null) {
            bcb.wGG = this.mgs.size();
            bcb.vKB = this.mgs;
        } else {
            bcb.wGG = 0;
            bcb.vKB = new LinkedList();
        }
        if (!C5046bo.isNullOrNil(this.mgu)) {
            bcb.wGH = this.mgu;
        }
        bcb.wGE = this.mgt.size();
        bcb.wGF = this.mgt;
        bcb.vEp = this.mgq;
        bcb.Scene = this.scene;
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102744);
        return a;
    }

    public final long bvg() {
        if (this.mgr == null) {
            return -1;
        }
        return this.mgr.field_localId;
    }

    public final int bvh() {
        if (this.mgr == null) {
            return -1;
        }
        return this.mgr.field_type;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102745);
        C4990ab.m7410d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.mgq + ", netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        C39037b.m66383d(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) this.mgq));
        AppMethodBeat.m2505o(102745);
    }

    public final int getType() {
        return v2helper.EMethodSetAgcRxOn;
    }
}
