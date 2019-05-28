package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k extends a<aqr, aqs> {
    private final WeakReference<b<k>> lqU;
    public List<String> lvZ;
    public List<String> lwa;
    public List<String> lwb;

    public final /* bridge */ /* synthetic */ void g(com.tencent.mm.bt.a aVar) {
    }

    public k(b<k> bVar) {
        AppMethodBeat.i(19462);
        this.lqU = new WeakReference(bVar);
        AppMethodBeat.o(19462);
    }

    public final int getType() {
        return 1758;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19463);
        ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aqs aqs = (aqs) aTS();
            this.lwb = new ArrayList();
            Iterator it = aqs.wuF.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                aw.ZK();
                if (c.XM().aoJ(str2)) {
                    this.lwb.add(str2);
                }
            }
            this.lvZ = new ArrayList();
            this.lwa = new ArrayList();
            if (aqs.wuG != null) {
                Iterator it2 = aqs.wuG.iterator();
                while (it2.hasNext()) {
                    acj acj = (acj) it2.next();
                    if (acj.wke) {
                        this.lwa.add(acj.username);
                    }
                    aw.ZK();
                    if (c.XM().aoJ(acj.username)) {
                        this.lvZ.add(acj.username);
                    }
                }
            }
            ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", Integer.valueOf(this.lwa.size()), this.lwa.toString());
            ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", Integer.valueOf(this.lvZ.size()), this.lvZ);
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lqU.get();
        if (bVar != null) {
            ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
            bVar.a(i2, i3, str, this);
            AppMethodBeat.o(19463);
            return;
        }
        ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
        AppMethodBeat.o(19463);
    }

    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
    }

    public final /* synthetic */ com.tencent.mm.bt.a boo() {
        AppMethodBeat.i(19464);
        aqs aqs = new aqs();
        AppMethodBeat.o(19464);
        return aqs;
    }

    public final /* synthetic */ com.tencent.mm.bt.a bon() {
        AppMethodBeat.i(19465);
        aqr aqr = new aqr();
        AppMethodBeat.o(19465);
        return aqr;
    }
}
