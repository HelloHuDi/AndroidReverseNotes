package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.utils.TbsLog;

public final class e extends m implements k {
    int cIb = 0;
    private b ehh;
    private f ehi;
    private boolean lSi = false;
    private sk pXq = null;
    private a pXr = new a();

    public e(byte[] bArr, int i) {
        AppMethodBeat.i(72675);
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("data must not be null");
            AppMethodBeat.o(72675);
            throw nullPointerException;
        }
        this.cIb = i;
        g.RN();
        this.lSi = a.QX();
        if (i == 1) {
            try {
                i iVar = new i();
                iVar.parseFrom(bArr);
                this.pXq = SmcProtoBufUtil.toMMReportKvReq(iVar);
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.RQ();
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(72673);
                        SmcLogic.OnReportResp(3, -1, null, e.this.cIb);
                        AppMethodBeat.o(72673);
                    }
                });
            }
        } else if (i == 2) {
            try {
                com.tencent.mm.protocal.a.a.g gVar = new com.tencent.mm.protocal.a.a.g();
                gVar.parseFrom(bArr);
                this.pXq = SmcProtoBufUtil.toMMReportIdkeyReq(gVar);
            } catch (Exception e2) {
                ab.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.RQ();
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(72674);
                        SmcLogic.OnReportResp(3, -1, null, e.this.cIb);
                        AppMethodBeat.o(72674);
                    }
                });
            }
        }
        if (this.pXq != null) {
            this.pXq.vZL = new atd();
            this.pXq.vZL.wxc = a.BM(this.cIb);
            AppMethodBeat.o(72675);
            return;
        }
        ab.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", bo.dpG());
        AppMethodBeat.o(72675);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(72676);
        if (g.RO().eJo == null || g.RO().eJo.ftA == null) {
            ab.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(72676);
        } else if (i2 != 0) {
            ab.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnReportResp(i2, i3, null, this.cIb);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(72676);
        } else {
            ab.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.cIb);
            sl slVar = (sl) this.ehh.fsH.fsP;
            this.pXr.a(slVar.vZV, this.cIb);
            try {
                if (this.cIb == 1) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(slVar).toByteArray(), this.cIb);
                } else if (this.cIb == 2) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(slVar).toByteArray(), this.cIb);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bo.l(e));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(72676);
        }
    }

    public final int getType() {
        return !this.lSi ? 1 == this.cIb ? TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR : 987 : 1 == this.cIb ? TbsLog.TBSLOG_CODE_SDK_SELF_MODE : 986;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(72677);
        this.ehi = fVar;
        if (this.pXq == null) {
            ab.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
            AppMethodBeat.o(72677);
            return -2;
        }
        if (!this.lSi) {
            this.pXq.vZK = com.tencent.mm.bt.b.bI(bo.dpz());
        }
        b.a aVar = new b.a();
        aVar.fsN = false;
        aVar.fsJ = this.pXq;
        aVar.fsK = new sl();
        String str = 1 == this.cIb ? "/cgi-bin/micromsg-bin/newreportkvcomm" : "/cgi-bin/micromsg-bin/newreportidkey";
        String str2 = 1 == this.cIb ? "/cgi-bin/micromsg-bin/newreportkvcommrsa" : "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        if (!this.lSi) {
            str = str2;
        }
        aVar.uri = str;
        aVar.fsI = getType();
        this.ehh = aVar.acD();
        if (!this.lSi) {
            this.ehh.a(z.dmw());
            this.ehh.cQh = 1;
        }
        int a = a(eVar, this.ehh, this);
        if (a < 0) {
            ab.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                SmcLogic.OnReportResp(3, -1, null, this.cIb);
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bo.l(e));
            }
        }
        AppMethodBeat.o(72677);
        return a;
    }
}
