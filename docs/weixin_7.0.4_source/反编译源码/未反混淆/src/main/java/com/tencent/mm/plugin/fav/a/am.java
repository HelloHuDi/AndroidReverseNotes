package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;
import java.util.LinkedList;
import java.util.List;

public final class am extends m implements k {
    private final b ehh;
    private f ehi = null;
    private List<Integer> mgv;
    private a mgw = null;
    private SparseArray<String> mgx = new SparseArray();
    private int scene;
    private String toUser;

    public interface a {
        void d(SparseArray<String> sparseArray);
    }

    public am(String str, List<Integer> list, a aVar) {
        AppMethodBeat.i(102746);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new bzg();
        aVar2.fsK = new bzh();
        aVar2.uri = "/cgi-bin/micromsg-bin/sharefav";
        aVar2.fsI = 608;
        aVar2.fsL = d.MIC_PTU_ZIPAI_FAIRYTALE;
        aVar2.fsM = 1000000246;
        this.ehh = aVar2.acD();
        this.toUser = str;
        this.scene = 2;
        this.mgv = list;
        this.mgw = aVar;
        AppMethodBeat.o(102746);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102747);
        ab.d("MicroMsg.NetSceneShareFavItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.mgx.clear();
        if (i2 == 0 && i3 == 0) {
            bzh bzh = (bzh) ((b) qVar).fsH.fsP;
            if (bzh.wtm != this.mgv.size()) {
                ab.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", Integer.valueOf(this.mgv.size()), Integer.valueOf(bzh.wtm));
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= bzh.vKr.size() || i5 >= this.mgv.size()) {
                    break;
                }
                ab.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", this.mgv.get(i5), bzh.vKr.get(i5));
                this.mgx.put(((Integer) this.mgv.get(i5)).intValue(), ((bts) bzh.vKr.get(i5)).wVI);
                i4 = i5 + 1;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (this.mgw != null) {
            this.mgw.d(this.mgx);
        }
        AppMethodBeat.o(102747);
    }

    public final int getType() {
        return 608;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102748);
        bzg bzg = (bzg) this.ehh.fsG.fsP;
        bzg.wYk = this.toUser;
        bzg.Scene = this.scene;
        bzg.vKh = new LinkedList(this.mgv);
        bzg.jBv = bzg.vKh.size();
        ab.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", bzg.wYk, Integer.valueOf(bzg.Scene), bzg.vKh, Integer.valueOf(bzg.jBv));
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102748);
        return a;
    }
}
