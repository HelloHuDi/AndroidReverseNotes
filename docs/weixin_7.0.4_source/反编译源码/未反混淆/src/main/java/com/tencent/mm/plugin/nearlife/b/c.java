package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class c extends m implements k {
    public static Vector<String> oRg = new Vector();
    public int czE = 0;
    private final b ehh;
    private f ehi;
    public String hlm = "";
    public int nJK;
    public String oRh = "";
    public String oRi = "";
    public List<a> oRj;
    public boolean oRk;

    static {
        AppMethodBeat.i(22934);
        AppMethodBeat.o(22934);
    }

    public static boolean Ab(int i) {
        AppMethodBeat.i(22927);
        String valueOf = String.valueOf(i);
        if (oRg.contains(valueOf)) {
            AppMethodBeat.o(22927);
            return false;
        }
        oRg.add(valueOf);
        AppMethodBeat.o(22927);
        return true;
    }

    public static boolean Ac(int i) {
        AppMethodBeat.i(22928);
        oRg.remove(String.valueOf(i));
        AppMethodBeat.o(22928);
        return true;
    }

    public static void clear() {
        AppMethodBeat.i(22929);
        oRg.clear();
        AppMethodBeat.o(22929);
    }

    public c(int i, int i2, float f, float f2, int i3, int i4, String str, String str2, SKBuiltinBuffer_t sKBuiltinBuffer_t, String str3, int i5, boolean z, boolean z2) {
        AppMethodBeat.i(22930);
        this.oRh = str3;
        if (!(i == 0 || i == 1)) {
            ab.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(i)));
        }
        this.czE = i;
        a aVar = new a();
        aVar.fsJ = new akh();
        aVar.fsK = new aki();
        aVar.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        aVar.fsI = 603;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
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
        ab.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i3 + " gpsSource:" + i4 + " mac" + str + " cell:" + str2 + " scene: " + i2 + " entryTime: " + i5);
        ab.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", Boolean.valueOf(z), Integer.valueOf(akh.wpP.getILen()));
        AppMethodBeat.o(22930);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(22931);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(22931);
        return a;
    }

    public final int getType() {
        return 603;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(22932);
        ab.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aki aki = (aki) ((b) qVar).fsH.fsP;
        this.hlm = aki.vQg;
        this.nJK = aki.wpZ;
        ab.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + aki.wpW + "searchId " + this.hlm);
        int i4 = (i3 == 0 || i3 == 101) ? 1 : 0;
        if (i2 == 0 || i4 != 0) {
            ab.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", Integer.valueOf(aki.vQe), Integer.valueOf(aki.wpW), Integer.valueOf(aki.wpU), aki.wpY);
            this.oRi = bo.bc(aki.wpY, "");
            this.oRj = new ArrayList();
            Iterator it = aki.wpX.iterator();
            while (it.hasNext()) {
                this.oRj.add(new a(aki.vQg, (axw) it.next()));
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
                ab.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", stringBuffer.toString());
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(22932);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(22932);
    }

    public final SKBuiltinBuffer_t bVh() {
        AppMethodBeat.i(22933);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = ((aki) this.ehh.fsH.fsP).wpP;
        if (sKBuiltinBuffer_t == null) {
            sKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
            AppMethodBeat.o(22933);
            return sKBuiltinBuffer_t;
        }
        AppMethodBeat.o(22933);
        return sKBuiltinBuffer_t;
    }

    public final int bVi() {
        return ((aki) this.ehh.fsH.fsP).vQe;
    }
}
