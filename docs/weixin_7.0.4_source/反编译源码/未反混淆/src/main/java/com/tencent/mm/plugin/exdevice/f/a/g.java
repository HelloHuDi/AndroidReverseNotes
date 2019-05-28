package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g extends a<cj, ck> {
    List<String> jzq;
    private final WeakReference<b<g>> lqU;
    public ArrayList<ach> lvv;

    public final /* synthetic */ void g(com.tencent.mm.bt.a aVar) {
        AppMethodBeat.i(19447);
        cj cjVar = (cj) aVar;
        for (String add : this.jzq) {
            cjVar.fLd.add(add);
        }
        AppMethodBeat.o(19447);
    }

    public g(List<String> list, b<g> bVar) {
        AppMethodBeat.i(19445);
        this.jzq = list;
        this.lqU = new WeakReference(bVar);
        AppMethodBeat.o(19445);
    }

    public final int getType() {
        return 1777;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19446);
        ab.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ck ckVar = (ck) aTS();
            this.lvv = new ArrayList();
            if (ckVar.vEx != null) {
                Iterator it = ckVar.vEx.iterator();
                while (it.hasNext()) {
                    ab.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", Integer.valueOf(r1.index), Integer.valueOf(r1.hzv), ((ach) it.next()).username);
                    this.lvv.add(r1);
                }
                ab.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", this.lvv.toString(), Integer.valueOf(ckVar.vEx.size()));
            }
            ad.boY().a(this.lvv, "hardcode_rank_id", "hardcode_app_name");
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lqU.get();
        if (bVar != null) {
            bVar.a(i2, i3, str, this);
        }
        AppMethodBeat.o(19446);
    }

    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/addfollow";
    }

    public final /* synthetic */ com.tencent.mm.bt.a boo() {
        AppMethodBeat.i(19448);
        ck ckVar = new ck();
        AppMethodBeat.o(19448);
        return ckVar;
    }

    public final /* synthetic */ com.tencent.mm.bt.a bon() {
        AppMethodBeat.i(19449);
        cj cjVar = new cj();
        AppMethodBeat.o(19449);
        return cjVar;
    }
}
