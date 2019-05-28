package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.List;

public final class w extends m implements k {
    private final b ehh;
    private f ehi;
    private byte[] fIi;
    private int kec = 0;

    public w(int i) {
        AppMethodBeat.i(87882);
        ab.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", Integer.valueOf(1));
        a aVar = new a();
        aVar.fsJ = new og();
        aVar.fsK = new oh();
        aVar.uri = "/cgi-bin/micromsg-bin/cardsync";
        aVar.fsI = JsApiSetLabInfo.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        axu axu = new axu();
        axu.kfA = (String) g.RP().Ry().get(ac.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null);
        axu.latitude = (double) am.bbc().ecs;
        axu.longitude = (double) am.bbc().ect;
        og ogVar = (og) this.ehh.fsG.fsP;
        ogVar.vTN = 1;
        ogVar.vTP = axu;
        ogVar.vTQ = i;
        this.kec = i;
        AppMethodBeat.o(87882);
    }

    public final int getType() {
        return JsApiSetLabInfo.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87883);
        this.ehi = fVar;
        og ogVar = (og) this.ehh.fsG.fsP;
        this.fIi = bo.anf(bo.nullAsNil((String) g.RP().Ry().get(282880, null)));
        if (this.fIi == null || this.fIi.length == 0) {
            ab.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
        }
        ogVar.vTO = aa.ad(this.fIi);
        String str = "MicroMsg.NetSceneCardSync";
        String str2 = "doScene, keyBuf.length = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.fIi == null ? 0 : this.fIi.length);
        ab.i(str, str2, objArr);
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87883);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87884);
        ab.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            oh ohVar = (oh) this.ehh.fsH.fsP;
            if (ohVar.vTS == 1) {
                ab.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
            }
            this.fIi = aa.a(ohVar.vTO, new byte[0]);
            List<tb> list = ohVar.vTR == null ? null : ohVar.vTR.jBw;
            String str2 = "MicroMsg.NetSceneCardSync";
            String str3 = "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(this.fIi == null ? 0 : this.fIi.length);
            objArr[2] = Integer.valueOf(ohVar.vQe);
            ab.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                ab.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
                com.tencent.mm.plugin.card.b.b baV = am.baV();
                ab.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", Boolean.TRUE);
                synchronized (baV.eMl) {
                    try {
                        baV.kaA.addAll(baV.kaB);
                        baV.kaB.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(87884);
                        }
                    }
                }
                baV.bai();
            } else {
                int i4 = 0;
                for (tb a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                ab.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", Integer.valueOf(i4));
                am.baV().bai();
            }
            g.RP().Ry().set(282880, bo.cd(this.fIi));
            if (ohVar.vQe > 0) {
                ab.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", Integer.valueOf(ohVar.vQe));
                if (a(this.ftf, this.ehi) <= 0) {
                    ab.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", Integer.valueOf(a(this.ftf, this.ehi)));
                    this.ehi.onSceneEnd(3, -1, str, this);
                }
                AppMethodBeat.o(87884);
                return;
            }
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(87884);
            return;
        }
        ab.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87884);
    }

    private static boolean a(tb tbVar) {
        AppMethodBeat.i(87885);
        if (tbVar == null) {
            ab.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
            AppMethodBeat.o(87885);
            return false;
        }
        byte[] a = aa.a(tbVar.wau);
        if (a == null || a.length == 0) {
            ab.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
            AppMethodBeat.o(87885);
            return false;
        }
        ab.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", Integer.valueOf(a.length), Integer.valueOf(tbVar.wat));
        try {
            switch (tbVar.wat) {
                case 1:
                    ok okVar = (ok) new ok().parseFrom(a);
                    ab.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", Integer.valueOf(okVar.jBT));
                    switch (okVar.jBT) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            am.baV().a(okVar);
                            break;
                        case 6:
                            break;
                        default:
                            ab.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", Integer.valueOf(okVar.vUM));
                            AppMethodBeat.o(87885);
                            return false;
                    }
                    AppMethodBeat.o(87885);
                    return true;
                default:
                    ab.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", Integer.valueOf(tbVar.wat));
                    AppMethodBeat.o(87885);
                    return false;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", e.getMessage());
            AppMethodBeat.o(87885);
            return false;
        }
        ab.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", e.getMessage());
        AppMethodBeat.o(87885);
        return false;
    }
}
