package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.h.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c extends a implements k {
    private int eCL = 120;
    private f ehi;
    private int fQx = 0;
    private boolean fZa = false;
    private String filename = null;
    private boolean gaA = false;
    private int gaB = 0;
    private bts gaC = null;
    private int gaD;
    private String[] gaE = new String[0];
    private int gaF = 3960;
    private ak gaG = new ak(g.RS().oAl.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(116673);
            if (message.what != 291) {
                AppMethodBeat.o(116673);
                return;
            }
            if (c.this.amo()) {
                g.Rg().a(c.this, 0);
            }
            AppMethodBeat.o(116673);
        }
    };
    h gay;
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
        AppMethodBeat.i(138328);
        h hVar = this.gay;
        ArrayList arrayList = new ArrayList();
        hVar.gbt.readLock().lock();
        for (a aVar : hVar.gbs.values()) {
            if (aVar.gbw) {
                arrayList.add(aVar.gbv);
            }
        }
        hVar.gbt.readLock().unlock();
        AppMethodBeat.o(138328);
        return arrayList;
    }

    public c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(116675);
        this.filename = str;
        this.gay = new h(str2);
        this.gaC = new bts().alV(str3);
        this.gaD = i;
        this.scene = i2;
        ab.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(116675);
    }

    public final boolean amo() {
        AppMethodBeat.i(116676);
        ab.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
        this.gaG.removeMessages(291);
        if ((this.gay.amy() && this.fZa) || this.gaz) {
            ab.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
            AppMethodBeat.o(116676);
            return false;
        }
        a mx = this.gay.mx(this.fQx);
        if (mx != null) {
            long min = Math.min(e.asZ(this.filename), (long) mx.gby);
            ab.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", Long.valueOf(r4), Integer.valueOf(mx.gby), Long.valueOf(min));
            if (min <= 0) {
                ab.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", this.filename);
                this.retCode = com.tencent.mm.compatible.util.g.getLine() + 40000;
                this.gaB = 0;
                amp();
                if (this.ehi != null) {
                    this.ehi.onSceneEnd(3, -1, "ReadFileLengthError", null);
                }
                AppMethodBeat.o(116676);
                return false;
            }
            this.gaB = (int) (min - ((long) this.fQx));
            if (this.gaB < 0) {
                ab.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", Integer.valueOf(this.gaB));
                this.retCode = com.tencent.mm.compatible.util.g.getLine() + 40000;
                this.gaG.sendEmptyMessageDelayed(291, (long) (this.eCL * 2));
                AppMethodBeat.o(116676);
                return false;
            }
            ab.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", Integer.valueOf(this.gaB), Integer.valueOf(mx.gbz), Integer.valueOf(this.eCL));
            if (this.gaB >= 500 || mx.gbz <= 5) {
                this.gaG.sendEmptyMessageDelayed(291, (long) this.eCL);
            } else {
                ab.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", Integer.valueOf(this.gaB));
                this.gaG.sendEmptyMessageDelayed(291, (long) (this.eCL * 2));
            }
            AppMethodBeat.o(116676);
            return true;
        }
        this.gaG.sendEmptyMessageDelayed(291, (long) (this.eCL * 2));
        AppMethodBeat.o(116676);
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(116677);
        this.ehi = fVar;
        b.a aVar = new b.a();
        aVar.fsJ = new coe();
        aVar.fsK = new cog();
        aVar.uri = "/cgi-bin/micromsg-bin/voicetrans";
        aVar.fsI = d.MIC_PTU_AUTOLEVEL;
        aVar.fsL = 381;
        aVar.fsM = 1000000381;
        b acD = aVar.acD();
        acD.acF().vyg = false;
        coe coe = (coe) acD.fsG.fsP;
        a mx = this.gay.mx(this.fQx);
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
            ab.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", stringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
            a = a(eVar, acD, this);
            AppMethodBeat.o(116677);
            return a;
        }
        int i;
        mx.gbw = true;
        if (this.gaA) {
            mx.gbx = true;
            coe.ptz = new SKBuiltinBuffer_t();
            ab.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
        } else {
            if (this.gaB > this.gaF) {
                this.gaB = this.gaF;
                mx.gbx = false;
            } else if (this.gaB <= this.gaF && (mx.gby != BaseClientBuilder.API_PRIORITY_OTHER || this.fZa)) {
                mx.gbx = true;
            }
            coe.ptz = new SKBuiltinBuffer_t().setBuffer(e.e(this.filename, this.fQx, this.gaB));
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
        ab.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", com.tencent.mm.compatible.util.g.Mq(), this.filename, Integer.valueOf(mx.gby), Integer.valueOf(this.fQx), Integer.valueOf(this.gaB), Integer.valueOf(coe.ptz.getILen()), Boolean.valueOf(mx.gbx), Integer.valueOf(coe.vPb), coe.xlF, coe.wUI, Integer.valueOf(coe.Scene));
        this.fQx = coe.ptz.getILen() + this.fQx;
        ab.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", mx.gbv, Integer.valueOf(this.fQx));
        if (mx.gbz == 1) {
            ab.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", Long.valueOf(System.currentTimeMillis()));
        }
        ab.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", Long.valueOf(System.currentTimeMillis()));
        a = a(eVar, acD, this);
        AppMethodBeat.o(116677);
        return a;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 2000;
    }

    public final void a(m.a aVar) {
        AppMethodBeat.i(116678);
        ab.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Mq() + " setSecurityCheckError e: %s", aVar);
        if (aVar == m.a.EReachMaxLimit) {
            amp();
            this.ehi.onSceneEnd(3, -1, "SecurityCheckError", this);
        }
        AppMethodBeat.o(116678);
    }

    public final boolean acK() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(116679);
        ab.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", com.tencent.mm.compatible.util.g.Mq(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 3 && i3 == -1) {
            ab.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", bo.dpG(), Long.valueOf(Thread.currentThread().getId()));
        }
        coe coe = (coe) ((b) qVar).fsG.fsP;
        cog cog = (cog) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", coe.xiM, Integer.valueOf(coe.vPb), Long.valueOf(System.currentTimeMillis()));
            this.gay.am(cog.xlJ);
            if (this.gay.amy() && this.fZa) {
                ab.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
                amq();
            }
            this.gaE = new String[]{this.gay.getResult()};
            this.ehi.onSceneEnd(i2, i3, str, this);
            this.gaF = cog.xlK <= 0 ? this.gaF : cog.xlK;
            this.eCL = cog.wRe < 0 ? 120 : cog.wRe;
            ab.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", Integer.valueOf(this.gaF), Integer.valueOf(this.eCL));
            AppMethodBeat.o(116679);
            return;
        }
        ab.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Mq() + " onGYNetEnd file: %s errType:%s errCode:%s", this.filename, Integer.valueOf(i2), Integer.valueOf(i3));
        amp();
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(116679);
    }

    public final void amp() {
        AppMethodBeat.i(116680);
        ab.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Mq());
        if (this.gaA) {
            AppMethodBeat.o(116680);
            return;
        }
        this.gaA = true;
        amq();
        g.Rg().kX(hashCode());
        final a mx = this.gay.mx(this.fQx);
        if (mx != null) {
            this.gaB = 0;
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(116672);
                    ab.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", mx.gbv, Integer.valueOf(mx.gby), Integer.valueOf(c.this.hashCode()));
                    g.Rg().a(c.this, 0);
                    AppMethodBeat.o(116672);
                }
            });
        }
        AppMethodBeat.o(116680);
    }

    private void amq() {
        AppMethodBeat.i(116681);
        ab.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Mq());
        if (this.gaG != null) {
            this.gaG.removeMessages(291);
        }
        this.gaz = true;
        AppMethodBeat.o(116681);
    }

    public final int getType() {
        return d.MIC_PTU_AUTOLEVEL;
    }

    public final void mw(int i) {
        AppMethodBeat.i(116682);
        ab.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", com.tencent.mm.compatible.util.g.Mq(), Integer.valueOf(i));
        if (i < 0) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(116682);
            throw illegalStateException;
        }
        this.gay.mw(i);
        AppMethodBeat.o(116682);
    }
}
