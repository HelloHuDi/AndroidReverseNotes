package com.tencent.p177mm.plugin.nearby.p1001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.axv;
import com.tencent.p177mm.protocal.protobuf.axz;
import com.tencent.p177mm.protocal.protobuf.aya;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.nearby.a.c */
public final class C46109c extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C46109c(int i, float f, float f2, int i2, int i3, String str, String str2) {
        AppMethodBeat.m2504i(55363);
        if (!(i == 1 || i == 2 || i == 3 || i == 4)) {
            C4990ab.m7412e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(i)));
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new axz();
        c1196a.fsK = new aya();
        c1196a.uri = "/cgi-bin/micromsg-bin/lbsfind";
        c1196a.fsI = 148;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        axz axz = (axz) this.ehh.fsG.fsP;
        axz.OpCode = i;
        axz.vRp = f;
        axz.vRq = f2;
        axz.wfG = i2;
        axz.wfH = str;
        axz.wfI = str2;
        axz.wfJ = i3;
        axz.vIl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.bVS());
        C4990ab.m7410d("MicroMsg.NetSceneLbsP", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i2 + " gpsSource:" + i3 + " mac" + str + " cell:" + str2 + " ccdLen:" + axz.vIl.getILen());
        C18698o.m29222a(2001, f, f2, i2);
        AppMethodBeat.m2505o(55363);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(55364);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(55364);
        return a;
    }

    public final int getType() {
        return 148;
    }

    /* renamed from: Ah */
    public final int mo74036Ah() {
        return ((axz) this.ehh.fsG.fsP).OpCode;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(55365);
        C4990ab.m7410d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aya aya = (aya) ((C7472b) c1929q).fsH.fsP;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= aya.woe.size()) {
                break;
            }
            C17880h c17880h = new C17880h();
            c17880h.username = ((axv) aya.woe.get(i5)).jBB;
            c17880h.dtR = ((axv) aya.woe.get(i5)).vEE;
            c17880h.frW = ((axv) aya.woe.get(i5)).vXm;
            c17880h.frV = ((axv) aya.woe.get(i5)).vXn;
            c17880h.mo33385cB(true);
            arrayList.add(c17880h);
            i4 = i5 + 1;
        }
        C17884o.act().mo33390aa(arrayList);
        if (mo74036Ah() == 1 || mo74036Ah() == 3 || mo74036Ah() == 4) {
            if (i2 == 0 || i3 != -2001) {
                C1720g.m3536RP().mo5239Ry().set(8210, Long.valueOf(System.currentTimeMillis() + ((long) (aya.wCg * 1000))));
            } else {
                C1720g.m3536RP().mo5239Ry().set(8210, Long.valueOf(0));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(55365);
                return;
            }
        } else if (mo74036Ah() == 2) {
            C1720g.m3536RP().mo5239Ry().set(8210, Long.valueOf(0));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(55365);
    }

    public final boolean bUX() {
        return ((aya) this.ehh.fsH.fsP).wCh == 1;
    }

    public final int bUY() {
        return ((aya) this.ehh.fsH.fsP).wCi;
    }

    public final List<axv> bUZ() {
        AppMethodBeat.m2504i(55366);
        LinkedList<axv> linkedList = ((aya) this.ehh.fsH.fsP).woe;
        if (linkedList != null) {
            C1720g.m3534RN().mo5159QU();
            for (axv axv : linkedList) {
                C20118a.ask().mo35364Yn().mo56747ia(axv.jBB, axv.wlF);
            }
        }
        AppMethodBeat.m2505o(55366);
        return linkedList;
    }
}
