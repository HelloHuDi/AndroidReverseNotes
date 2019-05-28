package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;

public final class al extends m implements k {
    private final b ehh;
    private f ehi;
    public int mgq;
    public f mgr;
    private LinkedList<bcd> mgs;
    private LinkedList<bca> mgt;
    public String mgu;
    private int scene;
    public int type;

    private al(int i, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2, int i2) {
        AppMethodBeat.i(102743);
        this.ehi = null;
        a aVar = new a();
        aVar.fsJ = new bcb();
        aVar.fsK = new bcc();
        aVar.uri = "/cgi-bin/micromsg-bin/modfavitem";
        aVar.fsI = v2helper.EMethodSetAgcRxOn;
        aVar.fsL = 216;
        aVar.fsM = 1000000216;
        this.ehh = aVar.acD();
        this.mgs = linkedList2;
        this.mgt = linkedList;
        this.mgq = i;
        this.type = i2;
        AppMethodBeat.o(102743);
    }

    public al(int i, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
    }

    public al(int i, f fVar) {
        this(i, fVar.field_modItem.mgt, fVar.field_modItem.wie, 1);
        this.mgr = fVar;
    }

    public al(int i, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2, String str) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.mgu = str;
    }

    public al(int i, LinkedList<bca> linkedList, LinkedList<bcd> linkedList2, String str, byte b) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.mgu = str;
        this.scene = 1;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102744);
        if (this.scene == 0 && (this.mgt == null || this.mgt.size() == 0)) {
            AppMethodBeat.o(102744);
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
        if (!bo.isNullOrNil(this.mgu)) {
            bcb.wGH = this.mgu;
        }
        bcb.wGE = this.mgt.size();
        bcb.wGF = this.mgt;
        bcb.vEp = this.mgq;
        bcb.Scene = this.scene;
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102744);
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

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102745);
        ab.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.mgq + ", netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        b.d(((ae) g.M(ae.class)).getFavItemInfoStorage().iF((long) this.mgq));
        AppMethodBeat.o(102745);
    }

    public final int getType() {
        return v2helper.EMethodSetAgcRxOn;
    }
}
