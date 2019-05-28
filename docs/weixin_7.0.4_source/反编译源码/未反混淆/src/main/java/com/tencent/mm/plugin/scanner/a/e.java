package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.bef;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.view.d;
import java.util.List;

public final class e extends m implements k {
    public float angle;
    public int ctE;
    public b ehh;
    private f ehi;
    public List<cit> pZB;
    public long pZC;

    public e(int i, int i2, String str, String str2) {
        this(i, i2, str, str2, (byte) 0);
    }

    private e(int i, int i2, String str, String str2, byte b) {
        AppMethodBeat.i(80837);
        a aVar = new a();
        bee bee = new bee();
        bee.vOs = i;
        bee.wHN = i2;
        bee.wHS = str;
        bee.wHT = str2;
        bee.Scene = 0;
        aVar.fsJ = bee;
        aVar.fsK = new bef();
        aVar.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
        aVar.fsI = d.MIC_PTU_WU;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.ctE = i;
        AppMethodBeat.o(80837);
    }

    public final int getType() {
        return d.MIC_PTU_WU;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(80838);
        this.ehi = fVar;
        this.pZC = System.currentTimeMillis();
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(80838);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(80839);
        this.angle = ((bef) ((b) qVar).fsH.fsP).wHU;
        this.pZB = ((bef) ((b) qVar).fsH.fsP).wpm;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(80839);
    }

    public final String cgF() {
        return ((bef) this.ehh.fsH.fsP).pZF;
    }
}
