package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bee;
import com.tencent.p177mm.protocal.protobuf.bef;
import com.tencent.p177mm.protocal.protobuf.cit;
import com.tencent.view.C31128d;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.scanner.a.e */
public final class C21679e extends C1207m implements C1918k {
    public float angle;
    public int ctE;
    public C7472b ehh;
    private C1202f ehi;
    public List<cit> pZB;
    public long pZC;

    public C21679e(int i, int i2, String str, String str2) {
        this(i, i2, str, str2, (byte) 0);
    }

    private C21679e(int i, int i2, String str, String str2, byte b) {
        AppMethodBeat.m2504i(80837);
        C1196a c1196a = new C1196a();
        bee bee = new bee();
        bee.vOs = i;
        bee.wHN = i2;
        bee.wHS = str;
        bee.wHT = str2;
        bee.Scene = 0;
        c1196a.fsJ = bee;
        c1196a.fsK = new bef();
        c1196a.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
        c1196a.fsI = C31128d.MIC_PTU_WU;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.ctE = i;
        AppMethodBeat.m2505o(80837);
    }

    public final int getType() {
        return C31128d.MIC_PTU_WU;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(80838);
        this.ehi = c1202f;
        this.pZC = System.currentTimeMillis();
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(80838);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(80839);
        this.angle = ((bef) ((C7472b) c1929q).fsH.fsP).wHU;
        this.pZB = ((bef) ((C7472b) c1929q).fsH.fsP).wpm;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(80839);
    }

    public final String cgF() {
        return ((bef) this.ehh.fsH.fsP).pZF;
    }
}
