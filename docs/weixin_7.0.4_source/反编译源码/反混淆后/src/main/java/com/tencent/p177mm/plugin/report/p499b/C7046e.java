package com.tencent.p177mm.plugin.report.p499b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.p1084a.p1085a.C30163i;
import com.tencent.p177mm.protocal.p1084a.p1085a.C44096g;
import com.tencent.p177mm.protocal.protobuf.C30224sk;
import com.tencent.p177mm.protocal.protobuf.C40569sl;
import com.tencent.p177mm.protocal.protobuf.atd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.mm.plugin.report.b.e */
public final class C7046e extends C1207m implements C1918k {
    int cIb = 0;
    private C7472b ehh;
    private C1202f ehi;
    private boolean lSi = false;
    private C30224sk pXq = null;
    private C3732a pXr = new C3732a();

    /* renamed from: com.tencent.mm.plugin.report.b.e$1 */
    class C70471 implements Runnable {
        C70471() {
        }

        public final void run() {
            AppMethodBeat.m2504i(72673);
            SmcLogic.OnReportResp(3, -1, null, C7046e.this.cIb);
            AppMethodBeat.m2505o(72673);
        }
    }

    /* renamed from: com.tencent.mm.plugin.report.b.e$2 */
    class C70482 implements Runnable {
        C70482() {
        }

        public final void run() {
            AppMethodBeat.m2504i(72674);
            SmcLogic.OnReportResp(3, -1, null, C7046e.this.cIb);
            AppMethodBeat.m2505o(72674);
        }
    }

    public C7046e(byte[] bArr, int i) {
        AppMethodBeat.m2504i(72675);
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("data must not be null");
            AppMethodBeat.m2505o(72675);
            throw nullPointerException;
        }
        this.cIb = i;
        C1720g.m3534RN();
        this.lSi = C1668a.m3395QX();
        if (i == 1) {
            try {
                C30163i c30163i = new C30163i();
                c30163i.parseFrom(bArr);
                this.pXq = SmcProtoBufUtil.toMMReportKvReq(c30163i);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.NetSceneCliReportKV", "parse data error");
                C1720g.m3537RQ();
                C1720g.m3539RS().mo10302aa(new C70471());
            }
        } else if (i == 2) {
            try {
                C44096g c44096g = new C44096g();
                c44096g.parseFrom(bArr);
                this.pXq = SmcProtoBufUtil.toMMReportIdkeyReq(c44096g);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.NetSceneCliReportKV", "parse data error");
                C1720g.m3537RQ();
                C1720g.m3539RS().mo10302aa(new C70482());
            }
        }
        if (this.pXq != null) {
            this.pXq.vZL = new atd();
            this.pXq.vZL.wxc = C3732a.m6037BM(this.cIb);
            AppMethodBeat.m2505o(72675);
            return;
        }
        C4990ab.m7417i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", C5046bo.dpG());
        AppMethodBeat.m2505o(72675);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(72676);
        if (C1720g.m3535RO().eJo == null || C1720g.m3535RO().eJo.ftA == null) {
            C4990ab.m7414f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(72676);
        } else if (i2 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnReportResp(i2, i3, null, this.cIb);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(72676);
        } else {
            C4990ab.m7410d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.cIb);
            C40569sl c40569sl = (C40569sl) this.ehh.fsH.fsP;
            this.pXr.mo8372a(c40569sl.vZV, this.cIb);
            try {
                if (this.cIb == 1) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(c40569sl).toByteArray(), this.cIb);
                } else if (this.cIb == 2) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(c40569sl).toByteArray(), this.cIb);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), C5046bo.m7574l(e));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(72676);
        }
    }

    public final int getType() {
        return !this.lSi ? 1 == this.cIb ? TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR : 987 : 1 == this.cIb ? TbsLog.TBSLOG_CODE_SDK_SELF_MODE : 986;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(72677);
        this.ehi = c1202f;
        if (this.pXq == null) {
            C4990ab.m7412e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
            AppMethodBeat.m2505o(72677);
            return -2;
        }
        if (!this.lSi) {
            this.pXq.vZK = C1332b.m2847bI(C5046bo.dpz());
        }
        C1196a c1196a = new C1196a();
        c1196a.fsN = false;
        c1196a.fsJ = this.pXq;
        c1196a.fsK = new C40569sl();
        String str = 1 == this.cIb ? "/cgi-bin/micromsg-bin/newreportkvcomm" : "/cgi-bin/micromsg-bin/newreportidkey";
        String str2 = 1 == this.cIb ? "/cgi-bin/micromsg-bin/newreportkvcommrsa" : "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        if (!this.lSi) {
            str = str2;
        }
        c1196a.uri = str;
        c1196a.fsI = getType();
        this.ehh = c1196a.acD();
        if (!this.lSi) {
            this.ehh.mo16652a(C4851z.dmw());
            this.ehh.cQh = 1;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        if (a < 0) {
            C4990ab.m7417i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                SmcLogic.OnReportResp(3, -1, null, this.cIb);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), C5046bo.m7574l(e));
            }
        }
        AppMethodBeat.m2505o(72677);
        return a;
    }
}
