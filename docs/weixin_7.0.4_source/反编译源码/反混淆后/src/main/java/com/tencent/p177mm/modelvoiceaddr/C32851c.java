package com.tencent.p177mm.modelvoiceaddr;

import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvoiceaddr.C42237h.C32853a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.coe;
import com.tencent.p177mm.protocal.protobuf.cog;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.modelvoiceaddr.c */
public final class C32851c extends C18723a implements C1918k {
    private int eCL = 120;
    private C1202f ehi;
    private int fQx = 0;
    private boolean fZa = false;
    private String filename = null;
    private boolean gaA = false;
    private int gaB = 0;
    private bts gaC = null;
    private int gaD;
    private String[] gaE = new String[0];
    private int gaF = 3960;
    private C7306ak gaG = new C7306ak(C1720g.m3539RS().oAl.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(116673);
            if (message.what != 291) {
                AppMethodBeat.m2505o(116673);
                return;
            }
            if (C32851c.this.amo()) {
                C1720g.m3540Rg().mo14541a(C32851c.this, 0);
            }
            AppMethodBeat.m2505o(116673);
        }
    };
    C42237h gay;
    private boolean gaz = false;
    private int retCode = 0;
    private int scene = 0;

    public final int amm() {
        return this.retCode;
    }

    public final void amj() {
        this.fZa = true;
    }

    public final String[] amk() {
        return this.gaE;
    }

    public final long aml() {
        return 0;
    }

    public final List<String> amn() {
        AppMethodBeat.m2504i(138328);
        C42237h c42237h = this.gay;
        ArrayList arrayList = new ArrayList();
        c42237h.gbt.readLock().lock();
        for (C32853a c32853a : c42237h.gbs.values()) {
            if (c32853a.gbw) {
                arrayList.add(c32853a.gbv);
            }
        }
        c42237h.gbt.readLock().unlock();
        AppMethodBeat.m2505o(138328);
        return arrayList;
    }

    public C32851c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(116675);
        this.filename = str;
        this.gay = new C42237h(str2);
        this.gaC = new bts().alV(str3);
        this.gaD = i;
        this.scene = i2;
        C4990ab.m7417i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(116675);
    }

    public final boolean amo() {
        AppMethodBeat.m2504i(116676);
        C4990ab.m7410d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
        this.gaG.removeMessages(291);
        if ((this.gay.amy() && this.fZa) || this.gaz) {
            C4990ab.m7416i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
            AppMethodBeat.m2505o(116676);
            return false;
        }
        C32853a mx = this.gay.mo67766mx(this.fQx);
        if (mx != null) {
            long min = Math.min(C5730e.asZ(this.filename), (long) mx.gby);
            C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", Long.valueOf(r4), Integer.valueOf(mx.gby), Long.valueOf(min));
            if (min <= 0) {
                C4990ab.m7413e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", this.filename);
                this.retCode = C1447g.getLine() + 40000;
                this.gaB = 0;
                amp();
                if (this.ehi != null) {
                    this.ehi.onSceneEnd(3, -1, "ReadFileLengthError", null);
                }
                AppMethodBeat.m2505o(116676);
                return false;
            }
            this.gaB = (int) (min - ((long) this.fQx));
            if (this.gaB < 0) {
                C4990ab.m7417i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", Integer.valueOf(this.gaB));
                this.retCode = C1447g.getLine() + 40000;
                this.gaG.sendEmptyMessageDelayed(291, (long) (this.eCL * 2));
                AppMethodBeat.m2505o(116676);
                return false;
            }
            C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", Integer.valueOf(this.gaB), Integer.valueOf(mx.gbz), Integer.valueOf(this.eCL));
            if (this.gaB >= 500 || mx.gbz <= 5) {
                this.gaG.sendEmptyMessageDelayed(291, (long) this.eCL);
            } else {
                C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", Integer.valueOf(this.gaB));
                this.gaG.sendEmptyMessageDelayed(291, (long) (this.eCL * 2));
            }
            AppMethodBeat.m2505o(116676);
            return true;
        }
        this.gaG.sendEmptyMessageDelayed(291, (long) (this.eCL * 2));
        AppMethodBeat.m2505o(116676);
        return true;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(116677);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new coe();
        c1196a.fsK = new cog();
        c1196a.uri = "/cgi-bin/micromsg-bin/voicetrans";
        c1196a.fsI = C31128d.MIC_PTU_AUTOLEVEL;
        c1196a.fsL = 381;
        c1196a.fsM = 1000000381;
        C7472b acD = c1196a.acD();
        acD.acF().vyg = false;
        coe coe = (coe) acD.fsG.fsP;
        C32853a mx = this.gay.mo67766mx(this.fQx);
        coe.Scene = this.scene;
        int a;
        if (mx == null) {
            coe.ptz = new SKBuiltinBuffer_t();
            coe.vOq = this.fQx;
            coe.xiM = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            coe.fJT = 1;
            coe.xiO = 2;
            coe.vPb = 0;
            coe.xlF = this.gay.amx();
            coe.xlE = coe.xlF == null ? 0 : coe.xlF.size();
            coe.wUI = this.gaC;
            coe.xlG = this.gaD;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            Iterator it = coe.xlF.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((bts) it.next()).wVI).append(", ");
            }
            stringBuilder.append("]");
            C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", stringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
            a = mo4457a(c1902e, acD, this);
            AppMethodBeat.m2505o(116677);
            return a;
        }
        int i;
        mx.gbw = true;
        if (this.gaA) {
            mx.gbx = true;
            coe.ptz = new SKBuiltinBuffer_t();
            C4990ab.m7416i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
        } else {
            if (this.gaB > this.gaF) {
                this.gaB = this.gaF;
                mx.gbx = false;
            } else if (this.gaB <= this.gaF && (mx.gby != BaseClientBuilder.API_PRIORITY_OTHER || this.fZa)) {
                mx.gbx = true;
            }
            coe.ptz = new SKBuiltinBuffer_t().setBuffer(C5730e.m8632e(this.filename, this.fQx, this.gaB));
        }
        coe.vOq = this.fQx;
        coe.xiM = mx.gbv;
        if (mx.gbx) {
            i = 1;
        } else {
            i = 0;
        }
        coe.fJT = i;
        coe.xiO = 2;
        i = mx.gbz + 1;
        mx.gbz = i;
        coe.vPb = i;
        coe.xlF = this.gay.amx();
        coe.xlE = coe.xlF == null ? 0 : coe.xlF.size();
        coe.wUI = this.gaC;
        coe.xlG = this.gaD;
        C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", C1447g.m3075Mq(), this.filename, Integer.valueOf(mx.gby), Integer.valueOf(this.fQx), Integer.valueOf(this.gaB), Integer.valueOf(coe.ptz.getILen()), Boolean.valueOf(mx.gbx), Integer.valueOf(coe.vPb), coe.xlF, coe.wUI, Integer.valueOf(coe.Scene));
        this.fQx = coe.ptz.getILen() + this.fQx;
        C4990ab.m7417i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", mx.gbv, Integer.valueOf(this.fQx));
        if (mx.gbz == 1) {
            C4990ab.m7417i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", Long.valueOf(System.currentTimeMillis()));
        }
        C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", Long.valueOf(System.currentTimeMillis()));
        a = mo4457a(c1902e, acD, this);
        AppMethodBeat.m2505o(116677);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 2000;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
        AppMethodBeat.m2504i(116678);
        C4990ab.m7421w("MicroMsg.NetSceneNewVoiceInput", C1447g.m3075Mq() + " setSecurityCheckError e: %s", c1205a);
        if (c1205a == C1205a.EReachMaxLimit) {
            amp();
            this.ehi.onSceneEnd(3, -1, "SecurityCheckError", this);
        }
        AppMethodBeat.m2505o(116678);
    }

    public final boolean acK() {
        return true;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(116679);
        C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", C1447g.m3075Mq(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 3 && i3 == -1) {
            C4990ab.m7417i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", C5046bo.dpG(), Long.valueOf(Thread.currentThread().getId()));
        }
        coe coe = (coe) ((C7472b) c1929q).fsG.fsP;
        cog cog = (cog) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", coe.xiM, Integer.valueOf(coe.vPb), Long.valueOf(System.currentTimeMillis()));
            this.gay.mo67761am(cog.xlJ);
            if (this.gay.amy() && this.fZa) {
                C4990ab.m7410d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
                amq();
            }
            this.gaE = new String[]{this.gay.getResult()};
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.gaF = cog.xlK <= 0 ? this.gaF : cog.xlK;
            this.eCL = cog.wRe < 0 ? 120 : cog.wRe;
            C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", Integer.valueOf(this.gaF), Integer.valueOf(this.eCL));
            AppMethodBeat.m2505o(116679);
            return;
        }
        C4990ab.m7417i("MicroMsg.NetSceneNewVoiceInput", C1447g.m3075Mq() + " onGYNetEnd file: %s errType:%s errCode:%s", this.filename, Integer.valueOf(i2), Integer.valueOf(i3));
        amp();
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(116679);
    }

    public final void amp() {
        AppMethodBeat.m2504i(116680);
        C4990ab.m7410d("MicroMsg.NetSceneNewVoiceInput", C1447g.m3075Mq());
        if (this.gaA) {
            AppMethodBeat.m2505o(116680);
            return;
        }
        this.gaA = true;
        amq();
        C1720g.m3540Rg().mo14554kX(hashCode());
        final C32853a mx = this.gay.mo67766mx(this.fQx);
        if (mx != null) {
            this.gaB = 0;
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(116672);
                    C4990ab.m7417i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", mx.gbv, Integer.valueOf(mx.gby), Integer.valueOf(C32851c.this.hashCode()));
                    C1720g.m3540Rg().mo14541a(C32851c.this, 0);
                    AppMethodBeat.m2505o(116672);
                }
            });
        }
        AppMethodBeat.m2505o(116680);
    }

    private void amq() {
        AppMethodBeat.m2504i(116681);
        C4990ab.m7410d("MicroMsg.NetSceneNewVoiceInput", C1447g.m3075Mq());
        if (this.gaG != null) {
            this.gaG.removeMessages(291);
        }
        this.gaz = true;
        AppMethodBeat.m2505o(116681);
    }

    public final int getType() {
        return C31128d.MIC_PTU_AUTOLEVEL;
    }

    /* renamed from: mw */
    public final void mo53423mw(int i) {
        AppMethodBeat.m2504i(116682);
        C4990ab.m7411d("MicroMsg.NetSceneNewVoiceInput", "%s %s", C1447g.m3075Mq(), Integer.valueOf(i));
        if (i < 0) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.m2505o(116682);
            throw illegalStateException;
        }
        this.gay.mo67765mw(i);
        AppMethodBeat.m2505o(116682);
    }
}
