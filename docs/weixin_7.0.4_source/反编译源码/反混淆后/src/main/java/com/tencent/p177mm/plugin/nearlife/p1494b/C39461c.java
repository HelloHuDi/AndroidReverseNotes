package com.tencent.p177mm.plugin.nearlife.p1494b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.akh;
import com.tencent.p177mm.protocal.protobuf.aki;
import com.tencent.p177mm.protocal.protobuf.axw;
import com.tencent.p177mm.protocal.protobuf.axx;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.nearlife.b.c */
public final class C39461c extends C1207m implements C1918k {
    public static Vector<String> oRg = new Vector();
    public int czE = 0;
    private final C7472b ehh;
    private C1202f ehi;
    public String hlm = "";
    public int nJK;
    public String oRh = "";
    public String oRi = "";
    public List<C39460a> oRj;
    public boolean oRk;

    static {
        AppMethodBeat.m2504i(22934);
        AppMethodBeat.m2505o(22934);
    }

    /* renamed from: Ab */
    public static boolean m67433Ab(int i) {
        AppMethodBeat.m2504i(22927);
        String valueOf = String.valueOf(i);
        if (oRg.contains(valueOf)) {
            AppMethodBeat.m2505o(22927);
            return false;
        }
        oRg.add(valueOf);
        AppMethodBeat.m2505o(22927);
        return true;
    }

    /* renamed from: Ac */
    public static boolean m67434Ac(int i) {
        AppMethodBeat.m2504i(22928);
        oRg.remove(String.valueOf(i));
        AppMethodBeat.m2505o(22928);
        return true;
    }

    public static void clear() {
        AppMethodBeat.m2504i(22929);
        oRg.clear();
        AppMethodBeat.m2505o(22929);
    }

    public C39461c(int i, int i2, float f, float f2, int i3, int i4, String str, String str2, SKBuiltinBuffer_t sKBuiltinBuffer_t, String str3, int i5, boolean z, boolean z2) {
        AppMethodBeat.m2504i(22930);
        this.oRh = str3;
        if (!(i == 0 || i == 1)) {
            C4990ab.m7412e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(i)));
        }
        this.czE = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akh();
        c1196a.fsK = new aki();
        c1196a.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        c1196a.fsI = 603;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        akh akh = (akh) this.ehh.fsG.fsP;
        axx axx = new axx();
        axx.wfI = str2;
        axx.wfJ = i4;
        axx.vRq = f2;
        axx.vRp = f;
        axx.wfH = str;
        axx.wfG = i3;
        akh.wcn = axx;
        akh.wkD = str3;
        akh.Scene = i2;
        akh.wpQ = i5;
        if (sKBuiltinBuffer_t == null) {
            akh.wpP = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        } else {
            akh.wpP = sKBuiltinBuffer_t;
        }
        akh.vIJ = i;
        akh.wpR = z2 ? 1 : 0;
        this.oRk = z;
        C4990ab.m7410d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i3 + " gpsSource:" + i4 + " mac" + str + " cell:" + str2 + " scene: " + i2 + " entryTime: " + i5);
        C4990ab.m7411d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", Boolean.valueOf(z), Integer.valueOf(akh.wpP.getILen()));
        AppMethodBeat.m2505o(22930);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(22931);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(22931);
        return a;
    }

    public final int getType() {
        return 603;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(22932);
        C4990ab.m7410d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aki aki = (aki) ((C7472b) c1929q).fsH.fsP;
        this.hlm = aki.vQg;
        this.nJK = aki.wpZ;
        C4990ab.m7410d("MicroMsg.NetSceneGetLbsLifeList", "resp " + aki.wpW + "searchId " + this.hlm);
        int i4 = (i3 == 0 || i3 == 101) ? 1 : 0;
        if (i2 == 0 || i4 != 0) {
            C4990ab.m7411d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", Integer.valueOf(aki.vQe), Integer.valueOf(aki.wpW), Integer.valueOf(aki.wpU), aki.wpY);
            this.oRi = C5046bo.m7532bc(aki.wpY, "");
            this.oRj = new ArrayList();
            Iterator it = aki.wpX.iterator();
            while (it.hasNext()) {
                this.oRj.add(new C39460a(aki.vQg, (axw) it.next()));
            }
            if (aki.wpW > 0) {
                axw axw = (axw) aki.wpX.get(0);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(" Bid " + axw.oQU);
                stringBuffer.append(" title " + axw.Title);
                stringBuffer.append(" link " + axw.oRb);
                stringBuffer.append(" price " + axw.oQV);
                stringBuffer.append(" rate " + axw.oRa);
                stringBuffer.append(" type " + axw.jCt);
                stringBuffer.append(" desc : ");
                it = axw.oQZ.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(((bts) it.next()).wVI + "-");
                }
                C4990ab.m7411d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", stringBuffer.toString());
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(22932);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(22932);
    }

    public final SKBuiltinBuffer_t bVh() {
        AppMethodBeat.m2504i(22933);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = ((aki) this.ehh.fsH.fsP).wpP;
        if (sKBuiltinBuffer_t == null) {
            sKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
            AppMethodBeat.m2505o(22933);
            return sKBuiltinBuffer_t;
        }
        AppMethodBeat.m2505o(22933);
        return sKBuiltinBuffer_t;
    }

    public final int bVi() {
        return ((aki) this.ehh.fsH.fsP).vQe;
    }
}
