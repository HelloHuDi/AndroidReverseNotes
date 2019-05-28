package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class h extends a<vq, vr> {
    private final WeakReference<b<h>> lqU;
    String username;

    public final /* bridge */ /* synthetic */ void g(com.tencent.mm.bt.a aVar) {
        ((vq) aVar).wcF = this.username;
    }

    public h(String str, b<h> bVar) {
        AppMethodBeat.i(19450);
        this.username = str;
        this.lqU = new WeakReference(bVar);
        AppMethodBeat.o(19450);
    }

    public final int getType() {
        return 1792;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19451);
        ab.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        super.a(i, i2, i3, str, qVar, bArr);
        if (i2 == 0 && i3 == 0) {
            ad.boY().Kq(this.username);
        }
        b bVar = (b) this.lqU.get();
        if (bVar != null) {
            bVar.a(i2, i3, str, this);
        }
        AppMethodBeat.o(19451);
    }

    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/delfollow";
    }

    public final /* synthetic */ com.tencent.mm.bt.a boo() {
        AppMethodBeat.i(19452);
        vr vrVar = new vr();
        AppMethodBeat.o(19452);
        return vrVar;
    }

    public final /* synthetic */ com.tencent.mm.bt.a bon() {
        AppMethodBeat.i(19453);
        vq vqVar = new vq();
        AppMethodBeat.o(19453);
        return vqVar;
    }
}
