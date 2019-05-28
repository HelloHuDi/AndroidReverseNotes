package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.h.c;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.model.af;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.c.as;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d implements a, b, c, com.tencent.mm.ai.h.d, g.a, af, com.tencent.mm.modelvoice.c, SensorController.a {
    private static SensorController mfW;
    public com.tencent.mm.ui.chatting.d.a cgL;
    public Context context;
    private int coq;
    private boolean cos = false;
    boolean isRecording = false;
    public h mfO;
    public boolean mfP;
    private boolean mfR = false;
    private bf mfS;
    long mfT = -1;
    private List<bi> yGN;
    public long yGO = -1;
    private o yGP;
    as yGQ;
    public o yGR;
    public boolean yGS;
    public boolean yGT = true;
    public boolean yGU = false;
    private long yGV = 0;
    private long yGW = 0;
    public boolean yGX = false;
    private boolean yGY = false;
    public com.tencent.mm.sdk.b.c yGZ = new com.tencent.mm.sdk.b.c<pe>() {
        {
            AppMethodBeat.i(30404);
            this.xxI = pe.class.getName().hashCode();
            AppMethodBeat.o(30404);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(30405);
            long j = ((pe) bVar).cLt.cvx;
            ab.d("MicroMsg.AutoPlay", "playingVoiceId: %s", d.this.yGO);
            ab.d("MicroMsg.AutoPlay", "msg id is: %s", r12.cLt.cvx);
            if (d.this.yGO == j) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(30403);
                        d.this.dBB();
                        d.this.dBw();
                        AppMethodBeat.o(30403);
                    }
                });
            }
            AppMethodBeat.o(30405);
            return false;
        }
    };
    private ak yHa = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30406);
            super.handleMessage(message);
            try {
                boolean z;
                ab.i("MicroMsg.AutoPlay", "reset speaker");
                d.a(d.this);
                d dVar = d.this;
                if (d.this.yGQ.mfQ) {
                    z = false;
                } else {
                    z = true;
                }
                dVar.mfP = z;
                AppMethodBeat.o(30406);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
                AppMethodBeat.o(30406);
            }
        }
    };
    private ak yHb = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30407);
            super.handleMessage(message);
            try {
                ab.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
                d.this.dBz();
                AppMethodBeat.o(30407);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
                AppMethodBeat.o(30407);
            }
        }
    };

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(30439);
        dVar.setScreenEnable(true);
        AppMethodBeat.o(30439);
    }

    public d(com.tencent.mm.ui.chatting.d.a aVar, as asVar, String str) {
        AppMethodBeat.i(30411);
        this.context = aVar.yTx.getContext();
        this.cgL = aVar;
        this.yGQ = asVar;
        if (mfW == null) {
            mfW = new SensorController(this.context.getApplicationContext());
        }
        if (this.mfS == null) {
            this.mfS = new bf(this.context.getApplicationContext());
        }
        aqZ(str);
        com.tencent.mm.sdk.b.a.xxA.c(this.yGZ);
        aw.Cc().a(this);
        AppMethodBeat.o(30411);
    }

    public final void aqZ(String str) {
        AppMethodBeat.i(30412);
        ab.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", Boolean.valueOf(this.yGU));
        if (this.yGU || this.context == null) {
            AppMethodBeat.o(30412);
            return;
        }
        this.yGN = new LinkedList();
        this.isRecording = false;
        this.yGO = -1;
        this.mfP = false;
        this.mfT = -1;
        this.yGS = false;
        this.coq = 0;
        if (t.nv(str)) {
            this.coq = 1;
            this.mfO = new com.tencent.mm.audio.a.a(this.context, 1);
            AppMethodBeat.o(30412);
            return;
        }
        this.coq = 0;
        this.mfO = new com.tencent.mm.audio.a.a(this.context, 0);
        AppMethodBeat.o(30412);
    }

    public final void dBw() {
        AppMethodBeat.i(30413);
        if (1 == ab.getLogLevel()) {
            ab.d("MicroMsg.AutoPlay", "clear play list, stack: %s", bo.dpG());
        }
        if (this.yGP != null) {
            this.yGP.dismiss();
        }
        this.yGN.clear();
        AppMethodBeat.o(30413);
    }

    public final void Od(int i) {
        AppMethodBeat.i(30414);
        while (this.context != null) {
            if (this.cgL == null) {
                ab.e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
                AppMethodBeat.o(30414);
                return;
            }
            int count = ((com.tencent.mm.ui.chatting.c.b.h) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).getCount();
            ab.d("MicroMsg.AutoPlay", "position : " + i + "adapter getCount = " + count);
            if (i < 0 || i >= count) {
                AppMethodBeat.o(30414);
                return;
            }
            bi Ou = ((com.tencent.mm.ui.chatting.c.b.h) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).Ou(i);
            if (Ou == null) {
                AppMethodBeat.o(30414);
                return;
            }
            if (Ou.drD() && Ou.field_isSend == 0 && !q.K(Ou) && !q.L(Ou)) {
                au(Ou);
            }
            i++;
        }
        ab.e("MicroMsg.AutoPlay", "context is null");
        AppMethodBeat.o(30414);
    }

    public final void au(bi biVar) {
        AppMethodBeat.i(30415);
        if (biVar == null) {
            AppMethodBeat.o(30415);
            return;
        }
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            int size = this.yGN.size();
            for (int i = 0; i < size; i++) {
                if (((bi) this.yGN.get(i)).field_msgId == biVar.field_msgId) {
                    AppMethodBeat.o(30415);
                    return;
                }
            }
            if (this.yGS || this.yGN.size() == 0) {
                this.yGN.add(biVar);
            }
            ab.d("MicroMsg.AutoPlay", "add voice msg :" + this.yGN.size());
            AppMethodBeat.o(30415);
            return;
        }
        if (this.yGN.size() > 0) {
            this.yGN.clear();
            com.tencent.mm.ui.base.t.hO(this.context);
        }
        AppMethodBeat.o(30415);
    }

    public final void a(int i, bi biVar) {
        AppMethodBeat.i(30416);
        if (biVar == null) {
            AppMethodBeat.o(30416);
            return;
        }
        dBw();
        aw.ZK();
        Boolean bool = (Boolean) com.tencent.mm.model.c.Ry().get(4115, null);
        if (bool == null || !bool.booleanValue()) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(4115, Boolean.TRUE);
            dBC();
            this.yGR = com.tencent.mm.ui.base.t.a(this.cgL.yTx.getActivity(), this.context.getString(R.string.an2), 4000);
        }
        if (this.mfO.isPlaying() && biVar.field_msgId == this.yGO) {
            dBB();
            AppMethodBeat.o(30416);
            return;
        }
        au(biVar);
        if (biVar.field_isSend == 0 && !q.K(biVar)) {
            Od(i + 1);
        }
        qn(true);
        AppMethodBeat.o(30416);
    }

    public final void b(int i, bi biVar) {
        AppMethodBeat.i(30417);
        if (biVar == null) {
            AppMethodBeat.o(30417);
            return;
        }
        dBw();
        aw.ZK();
        Boolean bool = (Boolean) com.tencent.mm.model.c.Ry().get(4115, null);
        if (bool == null || !bool.booleanValue()) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(4115, Boolean.TRUE);
            dBC();
            this.yGR = com.tencent.mm.ui.base.t.a(this.cgL.yTx.getActivity(), this.context.getString(R.string.an2), 4000);
        }
        if (this.mfO.isPlaying() && biVar.field_msgId == this.yGO) {
            dBB();
            AppMethodBeat.o(30417);
            return;
        }
        au(biVar);
        if (biVar.field_isSend == 0 && !q.K(biVar)) {
            Od(i + 1);
        }
        qn(true);
        AppMethodBeat.o(30417);
    }

    public final void J(bi biVar) {
        AppMethodBeat.i(30418);
        if (this.yGT && this.yGN.isEmpty()) {
            AppMethodBeat.o(30418);
        } else if (biVar == null || !biVar.drD() || biVar.field_isSend == 1) {
            AppMethodBeat.o(30418);
        } else if (biVar.field_talker == null || !biVar.field_talker.equals(this.cgL.getTalkerUserName())) {
            AppMethodBeat.o(30418);
        } else if (!aw.Rg().foreground || !this.cgL.caA) {
            AppMethodBeat.o(30418);
        } else if (q.L(biVar)) {
            ab.e("MicroMsg.AutoPlay", "should not in this route");
            AppMethodBeat.o(30418);
        } else {
            au(biVar);
            if (!(this.isRecording || this.mfO.isPlaying() || !bo.cv(this.context))) {
                qn(true);
            }
            AppMethodBeat.o(30418);
        }
    }

    public final void dBx() {
        AppMethodBeat.i(30419);
        this.isRecording = false;
        qn(true);
        AppMethodBeat.o(30419);
    }

    private void dBy() {
        AppMethodBeat.i(30420);
        int size = this.yGN.size();
        int i = 0;
        int i2 = -1;
        while (i < size) {
            int i3;
            if (((bi) this.yGN.get(i)).field_msgId == this.yGO) {
                i3 = i;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 != -1) {
            this.yGN.remove(i2);
        }
        ab.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.yGN.size());
        AppMethodBeat.o(30420);
    }

    public final void qn(boolean z) {
        AppMethodBeat.i(30421);
        ab.i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", Integer.valueOf(this.yGN.size()), Boolean.valueOf(z));
        if (this.yGN.size() <= 0) {
            this.yHa.sendEmptyMessageDelayed(0, 1000);
            AppMethodBeat.o(30421);
            return;
        }
        if (!g.KK().KV()) {
            g.KK();
            if (g.KS()) {
                g.KK().a((g.a) this);
                int KM = g.KK().KM();
                this.cos = true;
                if (!(KM == -1 || KM == 0)) {
                    ab.i("MicroMsg.AutoPlay", "play next: ret = ".concat(String.valueOf(KM)));
                    this.yHb.sendEmptyMessageDelayed(0, 1000);
                    AppMethodBeat.o(30421);
                    return;
                }
            }
        }
        if (this.mfO != null) {
            this.mfO.bm(z);
            this.mfO.bl(z);
        }
        dBz();
        AppMethodBeat.o(30421);
    }

    public final void dBz() {
        AppMethodBeat.i(30422);
        try {
            ab.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.yGN.size());
            if (this.yGN.size() <= 0) {
                this.yHa.sendEmptyMessageDelayed(0, 1000);
                AppMethodBeat.o(30422);
                return;
            }
            long j = ((bi) this.yGN.get(0)).field_createTime;
            int size = this.yGN.size();
            int i = 1;
            int i2 = 0;
            while (i < size) {
                long j2;
                if (j > ((bi) this.yGN.get(i)).field_createTime) {
                    j2 = ((bi) this.yGN.get(i)).field_createTime;
                    i2 = i;
                } else {
                    j2 = j;
                }
                i++;
                j = j2;
            }
            bi biVar = (bi) this.yGN.get(i2);
            if (biVar != null) {
                boolean z = biVar != null && (biVar.drD() || biVar.dtB() || biVar.dtC() || biVar.dtD());
                Assert.assertTrue(z);
                ab.i("MicroMsg.AutoPlay", "start play msg: %d", Long.valueOf(biVar.field_msgId));
                if (!mfW.aGA) {
                    mfW.a(this);
                    if (this.mfS.aj(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(30408);
                            d.this.mfT = bo.yz();
                            AppMethodBeat.o(30408);
                        }
                    })) {
                        this.mfT = 0;
                    } else {
                        this.mfT = -1;
                    }
                }
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable() || bo.isNullOrNil(biVar.field_imgPath)) {
                    aw.ZK();
                    if (com.tencent.mm.model.c.isSDCardAvailable() && this.yGQ.mfQ) {
                        if (this.yGP != null) {
                            this.yGP.dismiss();
                        }
                        ab.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b", Boolean.valueOf(g.KK().KV()), Boolean.valueOf(g.KK().KP()));
                        if (g.KK().KV() || !r2) {
                            this.yGP = com.tencent.mm.ui.base.t.a(this.cgL.yTx.getActivity(), (int) R.raw.tipsbar_receiver_icon, this.context.getString(R.string.aj4));
                        } else {
                            this.yGP = com.tencent.mm.ui.base.t.a(this.cgL.yTx.getActivity(), (int) R.raw.tipsbar_bluetooth_icon, this.context.getString(R.string.aj3));
                        }
                    }
                    aj.amA("keep_app_silent");
                    q.M(biVar);
                    this.mfO.stop(true);
                    this.yGQ.acquireWakeLock();
                    if (g.KK().KV() || g.KK().KP()) {
                        ab.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(g.KK().KV()), Boolean.valueOf(g.KK().KP()));
                        this.mfP = false;
                    }
                    String str = biVar.field_imgPath;
                    String by;
                    if (this.coq == 1) {
                        by = com.tencent.mm.plugin.subapp.c.h.by(str, false);
                    } else {
                        by = q.getFullPath(str);
                    }
                    ab.i("MicroMsg.AutoPlay", "startplay");
                    boolean uU = q.uU(biVar.field_imgPath);
                    if (!uU) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(111, 175, 1, false);
                    }
                    if (uU && this.mfO.a(by, this.mfP, true, -1)) {
                        this.mfO.bp(this.yGN.size() > 1);
                        this.mfO.a((a) this);
                        this.mfO.a((b) this);
                        this.mfO.a((c) this);
                        this.mfO.a((com.tencent.mm.ai.h.d) this);
                        this.yGO = biVar.field_msgId;
                        this.yGW = new n(biVar.field_content).time;
                        this.yGV = System.currentTimeMillis();
                    } else {
                        this.yGO = -1;
                        if (this.cos) {
                            g.KK().KN();
                            this.cos = false;
                        }
                        g.KK().b((g.a) this);
                        dBw();
                        Toast.makeText(this.context, this.context.getString(R.string.ank), 0).show();
                    }
                    aWv();
                    this.yGU = false;
                } else {
                    this.yGN.clear();
                    com.tencent.mm.ui.base.t.hO(this.context);
                    AppMethodBeat.o(30422);
                    return;
                }
            }
            AppMethodBeat.o(30422);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
            AppMethodBeat.o(30422);
        }
    }

    public final void dBA() {
        AppMethodBeat.i(30423);
        if (this.mfO != null && this.mfO.isPlaying()) {
            ab.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", Boolean.valueOf(this.mfP), Boolean.valueOf(this.mfO.isPlaying()));
            this.mfO.bo(this.mfP);
        }
        AppMethodBeat.o(30423);
    }

    public final void release() {
        AppMethodBeat.i(30424);
        ab.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
        if (this.mfS != null) {
            this.mfS.dpt();
        }
        AppMethodBeat.o(30424);
    }

    public final void dBB() {
        AppMethodBeat.i(30425);
        ab.i("MicroMsg.AutoPlay", "stop play");
        aj.amB("keep_app_silent");
        this.mfO.bm(true);
        this.mfO.stop();
        AppMethodBeat.o(30425);
    }

    private void aWv() {
        AppMethodBeat.i(30426);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30409);
                d.this.cgL.aWv();
                AppMethodBeat.o(30409);
            }
        });
        AppMethodBeat.o(30426);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(30427);
        boolean isPlaying = this.mfO.isPlaying();
        AppMethodBeat.o(30427);
        return isPlaying;
    }

    public final void EA() {
        AppMethodBeat.i(30428);
        ab.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", Boolean.valueOf(this.mfP), Long.valueOf(this.yGO), Long.valueOf(this.yGW));
        com.tencent.mm.plugin.report.service.h.pYm.e(15160, Long.valueOf(this.yGO), Long.valueOf(this.yGW), Long.valueOf(this.yGW), Integer.valueOf(0));
        if (this.context != null) {
            ab.i("MicroMsg.AutoPlay", "stop play complete");
            aj.amB("keep_app_silent");
            this.yGQ.releaseWakeLock();
            dBy();
            if (this.yGN.isEmpty() && this.cos) {
                g.KK().KN();
                this.cos = false;
            }
            g.KK().b((g.a) this);
            if (this.yGN.isEmpty()) {
                mfW.dps();
                this.mfS.dpt();
            }
            aWv();
            this.yGO = -1;
            dBC();
            this.yGQ.releaseWakeLock();
            qn(false);
        }
        AppMethodBeat.o(30428);
    }

    public final void onError() {
        AppMethodBeat.i(30429);
        ab.e("MicroMsg.AutoPlay", "voice play error");
        dBB();
        qn(true);
        AppMethodBeat.o(30429);
    }

    public final void cC(boolean z) {
        AppMethodBeat.i(30430);
        ab.w("MicroMsg.AutoPlay", "voice play pause. %b", Boolean.valueOf(z));
        onStop();
        AppMethodBeat.o(30430);
    }

    public final void onStop() {
        int i = 2;
        AppMethodBeat.i(30431);
        ab.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", Long.valueOf(this.yGO), Long.valueOf(this.yGW), Long.valueOf(bo.gb(this.yGV)), Boolean.valueOf(this.yGY), Boolean.valueOf(this.yGX), bo.dpG());
        if (this.yGO > 0) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(this.yGO);
            objArr[1] = Long.valueOf(this.yGW);
            objArr[2] = Long.valueOf(bo.gb(this.yGV));
            if (this.yGY) {
                i = 3;
            } else if (this.yGX) {
                i = 1;
            }
            objArr[3] = Integer.valueOf(i);
            hVar.e(15160, objArr);
        }
        this.yGY = false;
        this.yGX = false;
        this.yGQ.releaseWakeLock();
        dBy();
        if (this.cos) {
            g.KK().KN();
            this.cos = false;
        }
        g.KK().b((g.a) this);
        if (this.yGN.isEmpty()) {
            mfW.dps();
            this.mfS.dpt();
        }
        aWv();
        this.yGO = -1;
        dBC();
        this.yGU = false;
        setScreenEnable(true);
        AppMethodBeat.o(30431);
    }

    public final void he(final boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(30432);
        ab.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + z + "  hasSkip:" + this.mfR + " tick:" + bo.az(this.mfT) + "  lt:" + this.mfT);
        if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.o(30432);
        } else if (this.context == null) {
            mfW.dps();
            AppMethodBeat.o(30432);
        } else {
            ab.i("MicroMsg.AutoPlay", "isScreenOn: %s", Boolean.valueOf(isScreenEnable()));
            if (z || this.mfT == -1 || bo.az(this.mfT) <= 400) {
                this.mfR = false;
                if (this.mfO.Ex()) {
                    AppMethodBeat.o(30432);
                    return;
                } else if (aw.ZL().KP()) {
                    dBC();
                    ab.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
                    AppMethodBeat.o(30432);
                    return;
                } else if (this.yGQ.mfQ) {
                    this.mfP = false;
                    if (this.yGO != -1) {
                        setScreenEnable(z);
                        this.yGU = z;
                    } else {
                        setScreenEnable(true);
                        this.yGU = true;
                    }
                    dBA();
                    AppMethodBeat.o(30432);
                    return;
                } else {
                    if (this.yGO != -1) {
                        if (isScreenEnable() == z) {
                            AppMethodBeat.o(30432);
                            return;
                        }
                        setScreenEnable(z);
                        this.yGU = z;
                        new ap(new ap.a() {
                            public final boolean BI() {
                                AppMethodBeat.i(30410);
                                if (z) {
                                    ab.i("MicroMsg.AutoPlay", "speaker true");
                                    d.this.dBC();
                                    if (d.this.context != null) {
                                        d.this.yGR = com.tencent.mm.ui.base.t.a(d.this.cgL.yTx.getActivity(), d.this.context.getString(R.string.byi), (long) FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                                    }
                                    d.this.mfP = true;
                                    d.this.dBA();
                                } else {
                                    ab.i("MicroMsg.AutoPlay", "speaker off");
                                    d.this.mfP = false;
                                    d dVar = d.this;
                                    if (dVar.mfO.isPlaying()) {
                                        ab.d("MicroMsg.AutoPlay", "deal sensor event, play next");
                                        dVar.mfO.bm(false);
                                        dVar.qn(false);
                                    }
                                }
                                AppMethodBeat.o(30410);
                                return false;
                            }
                        }, false).ae(50, 50);
                    }
                    ab.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", Boolean.valueOf(this.yGU));
                    AppMethodBeat.o(30432);
                    return;
                }
            }
            this.mfR = true;
            AppMethodBeat.o(30432);
        }
    }

    private void setScreenEnable(boolean z) {
        AppMethodBeat.i(30433);
        if (this.cgL != null) {
            this.cgL.yTx.getController().setScreenEnable(z);
        }
        AppMethodBeat.o(30433);
    }

    private boolean isScreenEnable() {
        AppMethodBeat.i(30434);
        if (this.cgL != null) {
            boolean z = this.cgL.yTx.getController().ylz;
            AppMethodBeat.o(30434);
            return z;
        }
        AppMethodBeat.o(30434);
        return false;
    }

    public final void dBC() {
        AppMethodBeat.i(30435);
        if (this.yGR != null) {
            this.yGR.dismiss();
        }
        AppMethodBeat.o(30435);
    }

    public final void Zs() {
        AppMethodBeat.i(30436);
        ab.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
        this.yGY = false;
        AppMethodBeat.o(30436);
    }

    public final void Zt() {
        AppMethodBeat.i(30437);
        ab.i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
        this.yGY = true;
        dBB();
        dBw();
        try {
            if (mfW != null) {
                mfW.dps();
            }
            if (this.mfS != null) {
                this.mfS.dpt();
            }
            AppMethodBeat.o(30437);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AutoPlay", e, "reset sensor error: %s", e.getMessage());
            AppMethodBeat.o(30437);
        }
    }

    public final void gE(int i) {
        AppMethodBeat.i(30438);
        ab.i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.cos));
        switch (i) {
            case 1:
                if (this.yHb.hasMessages(0)) {
                    this.yHb.removeMessages(0);
                    this.yHb.sendEmptyMessage(0);
                    AppMethodBeat.o(30438);
                    return;
                }
                break;
            case 2:
            case 4:
                if (this.yHb.hasMessages(0)) {
                    this.yHb.removeMessages(0);
                }
                if (this.cos) {
                    g.KK().KN();
                    this.cos = false;
                    AppMethodBeat.o(30438);
                    return;
                }
                break;
            case 5:
                g.KK().KM();
                break;
        }
        AppMethodBeat.o(30438);
    }
}
