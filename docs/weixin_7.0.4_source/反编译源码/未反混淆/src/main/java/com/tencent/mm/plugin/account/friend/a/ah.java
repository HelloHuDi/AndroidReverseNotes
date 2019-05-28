package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bwk;
import java.util.LinkedList;

public final class ah extends m implements k {
    private final b ehh;
    private f ehi;

    public ah(int[] iArr) {
        AppMethodBeat.i(108475);
        a aVar = new a();
        aVar.fsJ = new bwj();
        aVar.fsK = new bwk();
        aVar.uri = "/cgi-bin/micromsg-bin/sendinviteemail";
        this.ehh = aVar.acD();
        LinkedList linkedList = new LinkedList();
        for (int valueOf : iArr) {
            linkedList.add(Integer.valueOf(valueOf));
        }
        ((bwj) this.ehh.fsG.fsP).wWY = linkedList;
        ((bwj) this.ehh.fsG.fsP).wWX = linkedList.size();
        AppMethodBeat.o(108475);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108476);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108476);
        return a;
    }

    public final int getType() {
        return 116;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108477);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108477);
    }
}
