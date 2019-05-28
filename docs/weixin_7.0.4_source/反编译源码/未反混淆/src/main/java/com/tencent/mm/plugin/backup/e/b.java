package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

public final class b extends m implements k {
    public com.tencent.mm.ai.b ehh;
    protected f ehi;

    public b(LinkedList<ua> linkedList, String str) {
        AppMethodBeat.i(17315);
        a aVar = new a();
        aVar.fsJ = new gr();
        aVar.fsK = new gt();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
        this.ehh = aVar.acD();
        gr grVar = (gr) this.ehh.fsG.fsP;
        grVar.vIN = linkedList.size();
        grVar.vIO = linkedList;
        grVar.vIQ = r.Yz();
        grVar.vIP = q.getDeviceID(ah.getContext());
        grVar.vIR = str;
        grVar.jBP = 0;
        grVar.Scene = 2;
        AppMethodBeat.o(17315);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(17316);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(17316);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(17317);
        ab.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", ((gt) this.ehh.fsH.fsP).vIU);
            d.ao(r0.vIn.getBuffer().wR);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(17317);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(17317);
    }

    public final int getType() {
        return 704;
    }
}
