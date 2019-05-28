package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.ac;

public final class x extends m implements k {
    private String cCU;
    private String cCW;
    public final b ehh;
    private f ehi;
    private int ftx;

    public x(String str, int i, String str2, String str3, String str4, String str5) {
        this(str, i, str2, 0, str3);
        AppMethodBeat.i(108428);
        this.cCU = str4;
        this.cCW = str5;
        jo joVar = (jo) this.ehh.fsG.fsP;
        joVar.vLx = str4;
        joVar.vLy = str5;
        AppMethodBeat.o(108428);
    }

    public x(String str, int i, String str2, int i2, String str3) {
        AppMethodBeat.i(108429);
        this.ehi = null;
        this.ftx = 2;
        this.cCU = null;
        this.cCW = null;
        a aVar = new a();
        aVar.fsJ = new jo();
        aVar.fsK = new jp();
        aVar.uri = "/cgi-bin/micromsg-bin/bindopmobile";
        aVar.fsI = 132;
        aVar.fsL = 45;
        aVar.fsM = 1000000045;
        this.ehh = aVar.acD();
        jo joVar = (jo) this.ehh.fsG.fsP;
        joVar.vIJ = i;
        joVar.vLu = i2;
        joVar.vLv = str3;
        if (bo.isNullOrNil(this.cCU) && bo.isNullOrNil(this.cCW)) {
            joVar.vLx = g.xyg ? ah.getContext().getString(R.string.dw2) : ah.getContext().getString(R.string.dw1);
            joVar.vLy = d.DEVICE_NAME;
        }
        if (str != null && str.length() > 0 && (i == 1 || i == 4 || i == 18)) {
            com.tencent.mm.kernel.g.RP().Ry().set(4097, (Object) str);
        } else if (i == 2 || i == 19) {
            str = (String) com.tencent.mm.kernel.g.RP().Ry().get(4097, null);
        } else if (i == 3) {
            str = (String) com.tencent.mm.kernel.g.RP().Ry().get(6, null);
        }
        ab.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        joVar.vLs = str;
        joVar.vLt = str2;
        joVar.luQ = aa.dor();
        AppMethodBeat.o(108429);
    }

    public final int Ah() {
        return ((jo) this.ehh.fsG.fsP).vIJ;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108430);
        this.ehi = fVar;
        jo joVar = (jo) this.ehh.fsG.fsP;
        if (joVar.vLs == null || joVar.vLs.length() <= 0) {
            ab.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + joVar.vLs);
            AppMethodBeat.o(108430);
            return -1;
        } else if ((joVar.vIJ == 2 || joVar.vIJ == 19) && (joVar.vLt == null || joVar.vLt.length() <= 0)) {
            ab.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + joVar.vLs);
            AppMethodBeat.o(108430);
            return -1;
        } else {
            int a = a(eVar, this.ehh, this);
            AppMethodBeat.o(108430);
            return a;
        }
    }

    public final int getType() {
        return 132;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108431);
        jo joVar = (jo) this.ehh.fsG.fsP;
        jp jpVar = (jp) this.ehh.fsH.fsP;
        if (jpVar != null) {
            int i4 = jpVar.vHW;
            ab.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", Integer.valueOf(i4));
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().eJH.set(47, Integer.valueOf(i4));
            e eVar = com.tencent.mm.kernel.g.RO().eJo.ftA;
            if (eVar != null) {
                eVar.cI((i4 & 1) == 0);
            }
        } else {
            ab.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", jpVar);
        }
        if (i2 == 0 && i3 == 0) {
            if (jpVar != null) {
                ab.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " sms:" + jpVar.vLH + "safedevice status = " + jpVar.vCl);
            }
            if (joVar.vIJ == 2 || joVar.vIJ == 4 || joVar.vIJ == 11 || joVar.vIJ == 19) {
                com.tencent.mm.kernel.g.RP().Ry().set(4097, (Object) "");
                String str2 = (String) com.tencent.mm.kernel.g.RP().Ry().get(6, (Object) "");
                com.tencent.mm.kernel.g.RP().Ry().set(6, joVar.vLs);
                if (!bo.isNullOrNil(str2)) {
                    if (com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_LAST_LOGIN_USERNAME_STRING, (Object) "").equals(str2)) {
                        com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_LAST_LOGIN_USERNAME_STRING, r.Yz());
                    }
                    for (String str3 : bx.fnB.aat()) {
                        if (str2.equals(bx.fnB.getString(str3, "login_user_name"))) {
                            bx.fnB.n(str3, "login_user_name", str3);
                        }
                    }
                }
                if (bo.isNullOrNil(this.cCU) || bo.isNullOrNil(this.cCW)) {
                    l.apP();
                }
                if (joVar.vIJ == 19) {
                    com.tencent.mm.kernel.g.RP().Ry().set(12322, null);
                }
                ab.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
            } else if (joVar.vIJ == 3) {
                com.tencent.mm.kernel.g.RP().Ry().set(4097, (Object) "");
                com.tencent.mm.kernel.g.RP().Ry().set(6, (Object) "");
                com.tencent.mm.kernel.g.RP().Ry().set(12322, null);
                com.tencent.mm.kernel.g.RP().Ry().set(64, Integer.valueOf(jpVar.vCl));
                tt ttVar = new tt();
                ttVar.cPS.cPT = false;
                ttVar.cPS.cPU = true;
                com.tencent.mm.sdk.b.a.xxA.m(ttVar);
                l.apY();
                l.apZ();
                ab.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(108431);
            return;
        }
        ab.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 4 && i3 == -240) {
            ab.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.ftx));
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(108431);
                return;
            }
            a(this.ftf, this.ehi);
            AppMethodBeat.o(108431);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108431);
    }

    public final String agg() {
        return ((jp) this.ehh.fsH.fsP).cxb;
    }
}
