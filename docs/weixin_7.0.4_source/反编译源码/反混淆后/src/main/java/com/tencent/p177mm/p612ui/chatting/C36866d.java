package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p194a.C32297a;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26411af;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C18717c;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p183ai.C17891h;
import com.tencent.p177mm.p183ai.C17891h.C17889a;
import com.tencent.p177mm.p183ai.C17891h.C17890c;
import com.tencent.p177mm.p183ai.C17891h.C17892b;
import com.tencent.p177mm.p183ai.C17891h.C17893d;
import com.tencent.p177mm.p230g.p231a.C37781pe;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.C44809as;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.subapp.p1039c.C22335h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C35992bf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.sdk.platformtools.SensorController;
import com.tencent.p177mm.sdk.platformtools.SensorController.C4986a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.chatting.d */
public final class C36866d implements C17889a, C17892b, C17890c, C17893d, C1406a, C26411af, C18717c, C4986a {
    private static SensorController mfW;
    public C46650a cgL;
    public Context context;
    private int coq;
    private boolean cos = false;
    boolean isRecording = false;
    public C17891h mfO;
    public boolean mfP;
    private boolean mfR = false;
    private C35992bf mfS;
    long mfT = -1;
    private List<C7620bi> yGN;
    public long yGO = -1;
    private C46633o yGP;
    C44809as yGQ;
    public C46633o yGR;
    public boolean yGS;
    public boolean yGT = true;
    public boolean yGU = false;
    private long yGV = 0;
    private long yGW = 0;
    public boolean yGX = false;
    private boolean yGY = false;
    public C4884c yGZ = new C368671();
    private C7306ak yHa = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(30406);
            super.handleMessage(message);
            try {
                boolean z;
                C4990ab.m7416i("MicroMsg.AutoPlay", "reset speaker");
                C36866d.m61343a(C36866d.this);
                C36866d c36866d = C36866d.this;
                if (C36866d.this.yGQ.mfQ) {
                    z = false;
                } else {
                    z = true;
                }
                c36866d.mfP = z;
                AppMethodBeat.m2505o(30406);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
                AppMethodBeat.m2505o(30406);
            }
        }
    };
    private C7306ak yHb = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(30407);
            super.handleMessage(message);
            try {
                C4990ab.m7416i("MicroMsg.AutoPlay", "startPlayHandler start Play");
                C36866d.this.dBz();
                AppMethodBeat.m2505o(30407);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
                AppMethodBeat.m2505o(30407);
            }
        }
    };

    /* renamed from: com.tencent.mm.ui.chatting.d$5 */
    class C156315 implements Runnable {
        C156315() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30409);
            C36866d.this.cgL.aWv();
            AppMethodBeat.m2505o(30409);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.d$4 */
    class C304954 implements Runnable {
        C304954() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30408);
            C36866d.this.mfT = C5046bo.m7588yz();
            AppMethodBeat.m2505o(30408);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.d$1 */
    class C368671 extends C4884c<C37781pe> {

        /* renamed from: com.tencent.mm.ui.chatting.d$1$1 */
        class C304941 implements Runnable {
            C304941() {
            }

            public final void run() {
                AppMethodBeat.m2504i(30403);
                C36866d.this.dBB();
                C36866d.this.dBw();
                AppMethodBeat.m2505o(30403);
            }
        }

        C368671() {
            AppMethodBeat.m2504i(30404);
            this.xxI = C37781pe.class.getName().hashCode();
            AppMethodBeat.m2505o(30404);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(30405);
            long j = ((C37781pe) c4883b).cLt.cvx;
            C4990ab.m7411d("MicroMsg.AutoPlay", "playingVoiceId: %s", C36866d.this.yGO);
            C4990ab.m7411d("MicroMsg.AutoPlay", "msg id is: %s", r12.cLt.cvx);
            if (C36866d.this.yGO == j) {
                C5004al.m7441d(new C304941());
            }
            AppMethodBeat.m2505o(30405);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m61343a(C36866d c36866d) {
        AppMethodBeat.m2504i(30439);
        c36866d.setScreenEnable(true);
        AppMethodBeat.m2505o(30439);
    }

    public C36866d(C46650a c46650a, C44809as c44809as, String str) {
        AppMethodBeat.m2504i(30411);
        this.context = c46650a.yTx.getContext();
        this.cgL = c46650a;
        this.yGQ = c44809as;
        if (mfW == null) {
            mfW = new SensorController(this.context.getApplicationContext());
        }
        if (this.mfS == null) {
            this.mfS = new C35992bf(this.context.getApplicationContext());
        }
        aqZ(str);
        C4879a.xxA.mo10052c(this.yGZ);
        C9638aw.m17176Cc().mo4650a(this);
        AppMethodBeat.m2505o(30411);
    }

    public final void aqZ(String str) {
        AppMethodBeat.m2504i(30412);
        C4990ab.m7417i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", Boolean.valueOf(this.yGU));
        if (this.yGU || this.context == null) {
            AppMethodBeat.m2505o(30412);
            return;
        }
        this.yGN = new LinkedList();
        this.isRecording = false;
        this.yGO = -1;
        this.mfP = false;
        this.mfT = -1;
        this.yGS = false;
        this.coq = 0;
        if (C1855t.m3953nv(str)) {
            this.coq = 1;
            this.mfO = new C32297a(this.context, 1);
            AppMethodBeat.m2505o(30412);
            return;
        }
        this.coq = 0;
        this.mfO = new C32297a(this.context, 0);
        AppMethodBeat.m2505o(30412);
    }

    public final void dBw() {
        AppMethodBeat.m2504i(30413);
        if (1 == C4990ab.getLogLevel()) {
            C4990ab.m7411d("MicroMsg.AutoPlay", "clear play list, stack: %s", C5046bo.dpG());
        }
        if (this.yGP != null) {
            this.yGP.dismiss();
        }
        this.yGN.clear();
        AppMethodBeat.m2505o(30413);
    }

    /* renamed from: Od */
    public final void mo58723Od(int i) {
        AppMethodBeat.m2504i(30414);
        while (this.context != null) {
            if (this.cgL == null) {
                C4990ab.m7412e("MicroMsg.AutoPlay", "add next failed: null mChattingContext");
                AppMethodBeat.m2505o(30414);
                return;
            }
            int count = ((C15612h) this.cgL.mo74857aF(C15612h.class)).getCount();
            C4990ab.m7410d("MicroMsg.AutoPlay", "position : " + i + "adapter getCount = " + count);
            if (i < 0 || i >= count) {
                AppMethodBeat.m2505o(30414);
                return;
            }
            C7620bi Ou = ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27798Ou(i);
            if (Ou == null) {
                AppMethodBeat.m2505o(30414);
                return;
            }
            if (Ou.drD() && Ou.field_isSend == 0 && !C32850q.m53704K(Ou) && !C32850q.m53705L(Ou)) {
                mo58726au(Ou);
            }
            i++;
        }
        C4990ab.m7412e("MicroMsg.AutoPlay", "context is null");
        AppMethodBeat.m2505o(30414);
    }

    /* renamed from: au */
    public final void mo58726au(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30415);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(30415);
            return;
        }
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            int size = this.yGN.size();
            for (int i = 0; i < size; i++) {
                if (((C7620bi) this.yGN.get(i)).field_msgId == c7620bi.field_msgId) {
                    AppMethodBeat.m2505o(30415);
                    return;
                }
            }
            if (this.yGS || this.yGN.size() == 0) {
                this.yGN.add(c7620bi);
            }
            C4990ab.m7410d("MicroMsg.AutoPlay", "add voice msg :" + this.yGN.size());
            AppMethodBeat.m2505o(30415);
            return;
        }
        if (this.yGN.size() > 0) {
            this.yGN.clear();
            C23639t.m36492hO(this.context);
        }
        AppMethodBeat.m2505o(30415);
    }

    /* renamed from: a */
    public final void mo58724a(int i, C7620bi c7620bi) {
        AppMethodBeat.m2504i(30416);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(30416);
            return;
        }
        dBw();
        C9638aw.m17190ZK();
        Boolean bool = (Boolean) C18628c.m29072Ry().get(4115, null);
        if (bool == null || !bool.booleanValue()) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(4115, Boolean.TRUE);
            dBC();
            this.yGR = C23639t.m36486a(this.cgL.yTx.getActivity(), this.context.getString(C25738R.string.an2), 4000);
        }
        if (this.mfO.isPlaying() && c7620bi.field_msgId == this.yGO) {
            dBB();
            AppMethodBeat.m2505o(30416);
            return;
        }
        mo58726au(c7620bi);
        if (c7620bi.field_isSend == 0 && !C32850q.m53704K(c7620bi)) {
            mo58723Od(i + 1);
        }
        mo58735qn(true);
        AppMethodBeat.m2505o(30416);
    }

    /* renamed from: b */
    public final void mo58727b(int i, C7620bi c7620bi) {
        AppMethodBeat.m2504i(30417);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(30417);
            return;
        }
        dBw();
        C9638aw.m17190ZK();
        Boolean bool = (Boolean) C18628c.m29072Ry().get(4115, null);
        if (bool == null || !bool.booleanValue()) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(4115, Boolean.TRUE);
            dBC();
            this.yGR = C23639t.m36486a(this.cgL.yTx.getActivity(), this.context.getString(C25738R.string.an2), 4000);
        }
        if (this.mfO.isPlaying() && c7620bi.field_msgId == this.yGO) {
            dBB();
            AppMethodBeat.m2505o(30417);
            return;
        }
        mo58726au(c7620bi);
        if (c7620bi.field_isSend == 0 && !C32850q.m53704K(c7620bi)) {
            mo58723Od(i + 1);
        }
        mo58735qn(true);
        AppMethodBeat.m2505o(30417);
    }

    /* renamed from: J */
    public final void mo33980J(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30418);
        if (this.yGT && this.yGN.isEmpty()) {
            AppMethodBeat.m2505o(30418);
        } else if (c7620bi == null || !c7620bi.drD() || c7620bi.field_isSend == 1) {
            AppMethodBeat.m2505o(30418);
        } else if (c7620bi.field_talker == null || !c7620bi.field_talker.equals(this.cgL.getTalkerUserName())) {
            AppMethodBeat.m2505o(30418);
        } else if (!C9638aw.m17182Rg().foreground || !this.cgL.caA) {
            AppMethodBeat.m2505o(30418);
        } else if (C32850q.m53705L(c7620bi)) {
            C4990ab.m7412e("MicroMsg.AutoPlay", "should not in this route");
            AppMethodBeat.m2505o(30418);
        } else {
            mo58726au(c7620bi);
            if (!(this.isRecording || this.mfO.isPlaying() || !C5046bo.m7544cv(this.context))) {
                mo58735qn(true);
            }
            AppMethodBeat.m2505o(30418);
        }
    }

    public final void dBx() {
        AppMethodBeat.m2504i(30419);
        this.isRecording = false;
        mo58735qn(true);
        AppMethodBeat.m2505o(30419);
    }

    private void dBy() {
        AppMethodBeat.m2504i(30420);
        int size = this.yGN.size();
        int i = 0;
        int i2 = -1;
        while (i < size) {
            int i3;
            if (((C7620bi) this.yGN.get(i)).field_msgId == this.yGO) {
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
        C4990ab.m7410d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.yGN.size());
        AppMethodBeat.m2505o(30420);
    }

    /* renamed from: qn */
    public final void mo58735qn(boolean z) {
        AppMethodBeat.m2504i(30421);
        C4990ab.m7417i("MicroMsg.AutoPlay", "play next: size: %s needAudioFocus: %s", Integer.valueOf(this.yGN.size()), Boolean.valueOf(z));
        if (this.yGN.size() <= 0) {
            this.yHa.sendEmptyMessageDelayed(0, 1000);
            AppMethodBeat.m2505o(30421);
            return;
        }
        if (!C1407g.m2946KK().mo4822KV()) {
            C1407g.m2946KK();
            if (C1407g.m2950KS()) {
                C1407g.m2946KK().mo4828a((C1406a) this);
                int KM = C1407g.m2946KK().mo4817KM();
                this.cos = true;
                if (!(KM == -1 || KM == 0)) {
                    C4990ab.m7416i("MicroMsg.AutoPlay", "play next: ret = ".concat(String.valueOf(KM)));
                    this.yHb.sendEmptyMessageDelayed(0, 1000);
                    AppMethodBeat.m2505o(30421);
                    return;
                }
            }
        }
        if (this.mfO != null) {
            this.mfO.mo33406bm(z);
            this.mfO.mo33405bl(z);
        }
        dBz();
        AppMethodBeat.m2505o(30421);
    }

    public final void dBz() {
        AppMethodBeat.m2504i(30422);
        try {
            C4990ab.m7410d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.yGN.size());
            if (this.yGN.size() <= 0) {
                this.yHa.sendEmptyMessageDelayed(0, 1000);
                AppMethodBeat.m2505o(30422);
                return;
            }
            long j = ((C7620bi) this.yGN.get(0)).field_createTime;
            int size = this.yGN.size();
            int i = 1;
            int i2 = 0;
            while (i < size) {
                long j2;
                if (j > ((C7620bi) this.yGN.get(i)).field_createTime) {
                    j2 = ((C7620bi) this.yGN.get(i)).field_createTime;
                    i2 = i;
                } else {
                    j2 = j;
                }
                i++;
                j = j2;
            }
            C7620bi c7620bi = (C7620bi) this.yGN.get(i2);
            if (c7620bi != null) {
                boolean z = c7620bi != null && (c7620bi.drD() || c7620bi.dtB() || c7620bi.dtC() || c7620bi.dtD());
                Assert.assertTrue(z);
                C4990ab.m7417i("MicroMsg.AutoPlay", "start play msg: %d", Long.valueOf(c7620bi.field_msgId));
                if (!mfW.aGA) {
                    mfW.mo10258a(this);
                    if (this.mfS.mo56732aj(new C304954())) {
                        this.mfT = 0;
                    } else {
                        this.mfT = -1;
                    }
                }
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable() || C5046bo.isNullOrNil(c7620bi.field_imgPath)) {
                    C9638aw.m17190ZK();
                    if (C18628c.isSDCardAvailable() && this.yGQ.mfQ) {
                        if (this.yGP != null) {
                            this.yGP.dismiss();
                        }
                        C4990ab.m7417i("MicroMsg.AutoPlay", "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b", Boolean.valueOf(C1407g.m2946KK().mo4822KV()), Boolean.valueOf(C1407g.m2946KK().mo4819KP()));
                        if (C1407g.m2946KK().mo4822KV() || !r2) {
                            this.yGP = C23639t.m36485a(this.cgL.yTx.getActivity(), (int) C1318a.tipsbar_receiver_icon, this.context.getString(C25738R.string.aj4));
                        } else {
                            this.yGP = C23639t.m36485a(this.cgL.yTx.getActivity(), (int) C1318a.tipsbar_bluetooth_icon, this.context.getString(C25738R.string.aj3));
                        }
                    }
                    C4997aj.amA("keep_app_silent");
                    C32850q.m53706M(c7620bi);
                    this.mfO.stop(true);
                    this.yGQ.acquireWakeLock();
                    if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
                        C4990ab.m7417i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(C1407g.m2946KK().mo4822KV()), Boolean.valueOf(C1407g.m2946KK().mo4819KP()));
                        this.mfP = false;
                    }
                    String str = c7620bi.field_imgPath;
                    String by;
                    if (this.coq == 1) {
                        by = C22335h.m34031by(str, false);
                    } else {
                        by = C32850q.getFullPath(str);
                    }
                    C4990ab.m7416i("MicroMsg.AutoPlay", "startplay");
                    boolean uU = C32850q.m53734uU(c7620bi.field_imgPath);
                    if (!uU) {
                        C7060h.pYm.mo8378a(111, 175, 1, false);
                    }
                    if (uU && this.mfO.mo33404a(by, this.mfP, true, -1)) {
                        this.mfO.mo33408bp(this.yGN.size() > 1);
                        this.mfO.mo33399a((C17889a) this);
                        this.mfO.mo33400a((C17892b) this);
                        this.mfO.mo33401a((C17890c) this);
                        this.mfO.mo33402a((C17893d) this);
                        this.yGO = c7620bi.field_msgId;
                        this.yGW = new C42230n(c7620bi.field_content).time;
                        this.yGV = System.currentTimeMillis();
                    } else {
                        this.yGO = -1;
                        if (this.cos) {
                            C1407g.m2946KK().mo4818KN();
                            this.cos = false;
                        }
                        C1407g.m2946KK().mo4829b((C1406a) this);
                        dBw();
                        Toast.makeText(this.context, this.context.getString(C25738R.string.ank), 0).show();
                    }
                    aWv();
                    this.yGU = false;
                } else {
                    this.yGN.clear();
                    C23639t.m36492hO(this.context);
                    AppMethodBeat.m2505o(30422);
                    return;
                }
            }
            AppMethodBeat.m2505o(30422);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
            AppMethodBeat.m2505o(30422);
        }
    }

    public final void dBA() {
        AppMethodBeat.m2504i(30423);
        if (this.mfO != null && this.mfO.isPlaying()) {
            C4990ab.m7417i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", Boolean.valueOf(this.mfP), Boolean.valueOf(this.mfO.isPlaying()));
            this.mfO.mo33407bo(this.mfP);
        }
        AppMethodBeat.m2505o(30423);
    }

    public final void release() {
        AppMethodBeat.m2504i(30424);
        C4990ab.m7416i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
        if (this.mfS != null) {
            this.mfS.dpt();
        }
        AppMethodBeat.m2505o(30424);
    }

    public final void dBB() {
        AppMethodBeat.m2504i(30425);
        C4990ab.m7416i("MicroMsg.AutoPlay", "stop play");
        C4997aj.amB("keep_app_silent");
        this.mfO.mo33406bm(true);
        this.mfO.stop();
        AppMethodBeat.m2505o(30425);
    }

    private void aWv() {
        AppMethodBeat.m2504i(30426);
        C5004al.m7441d(new C156315());
        AppMethodBeat.m2505o(30426);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(30427);
        boolean isPlaying = this.mfO.isPlaying();
        AppMethodBeat.m2505o(30427);
        return isPlaying;
    }

    /* renamed from: EA */
    public final void mo17611EA() {
        AppMethodBeat.m2504i(30428);
        C4990ab.m7419v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", Boolean.valueOf(this.mfP), Long.valueOf(this.yGO), Long.valueOf(this.yGW));
        C7060h.pYm.mo8381e(15160, Long.valueOf(this.yGO), Long.valueOf(this.yGW), Long.valueOf(this.yGW), Integer.valueOf(0));
        if (this.context != null) {
            C4990ab.m7416i("MicroMsg.AutoPlay", "stop play complete");
            C4997aj.amB("keep_app_silent");
            this.yGQ.releaseWakeLock();
            dBy();
            if (this.yGN.isEmpty() && this.cos) {
                C1407g.m2946KK().mo4818KN();
                this.cos = false;
            }
            C1407g.m2946KK().mo4829b((C1406a) this);
            if (this.yGN.isEmpty()) {
                mfW.dps();
                this.mfS.dpt();
            }
            aWv();
            this.yGO = -1;
            dBC();
            this.yGQ.releaseWakeLock();
            mo58735qn(false);
        }
        AppMethodBeat.m2505o(30428);
    }

    public final void onError() {
        AppMethodBeat.m2504i(30429);
        C4990ab.m7412e("MicroMsg.AutoPlay", "voice play error");
        dBB();
        mo58735qn(true);
        AppMethodBeat.m2505o(30429);
    }

    /* renamed from: cC */
    public final void mo33394cC(boolean z) {
        AppMethodBeat.m2504i(30430);
        C4990ab.m7421w("MicroMsg.AutoPlay", "voice play pause. %b", Boolean.valueOf(z));
        onStop();
        AppMethodBeat.m2505o(30430);
    }

    public final void onStop() {
        int i = 2;
        AppMethodBeat.m2504i(30431);
        C4990ab.m7421w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", Long.valueOf(this.yGO), Long.valueOf(this.yGW), Long.valueOf(C5046bo.m7566gb(this.yGV)), Boolean.valueOf(this.yGY), Boolean.valueOf(this.yGX), C5046bo.dpG());
        if (this.yGO > 0) {
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(this.yGO);
            objArr[1] = Long.valueOf(this.yGW);
            objArr[2] = Long.valueOf(C5046bo.m7566gb(this.yGV));
            if (this.yGY) {
                i = 3;
            } else if (this.yGX) {
                i = 1;
            }
            objArr[3] = Integer.valueOf(i);
            c7060h.mo8381e(15160, objArr);
        }
        this.yGY = false;
        this.yGX = false;
        this.yGQ.releaseWakeLock();
        dBy();
        if (this.cos) {
            C1407g.m2946KK().mo4818KN();
            this.cos = false;
        }
        C1407g.m2946KK().mo4829b((C1406a) this);
        if (this.yGN.isEmpty()) {
            mfW.dps();
            this.mfS.dpt();
        }
        aWv();
        this.yGO = -1;
        dBC();
        this.yGU = false;
        setScreenEnable(true);
        AppMethodBeat.m2505o(30431);
    }

    /* renamed from: he */
    public final void mo10257he(final boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(30432);
        C4990ab.m7416i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + z + "  hasSkip:" + this.mfR + " tick:" + C5046bo.m7525az(this.mfT) + "  lt:" + this.mfT);
        if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.m2505o(30432);
        } else if (this.context == null) {
            mfW.dps();
            AppMethodBeat.m2505o(30432);
        } else {
            C4990ab.m7417i("MicroMsg.AutoPlay", "isScreenOn: %s", Boolean.valueOf(isScreenEnable()));
            if (z || this.mfT == -1 || C5046bo.m7525az(this.mfT) <= 400) {
                this.mfR = false;
                if (this.mfO.mo33397Ex()) {
                    AppMethodBeat.m2505o(30432);
                    return;
                } else if (C9638aw.m17191ZL().mo4819KP()) {
                    dBC();
                    C4990ab.m7410d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
                    AppMethodBeat.m2505o(30432);
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
                    AppMethodBeat.m2505o(30432);
                    return;
                } else {
                    if (this.yGO != -1) {
                        if (isScreenEnable() == z) {
                            AppMethodBeat.m2505o(30432);
                            return;
                        }
                        setScreenEnable(z);
                        this.yGU = z;
                        new C7564ap(new C5015a() {
                            /* renamed from: BI */
                            public final boolean mo4499BI() {
                                AppMethodBeat.m2504i(30410);
                                if (z) {
                                    C4990ab.m7416i("MicroMsg.AutoPlay", "speaker true");
                                    C36866d.this.dBC();
                                    if (C36866d.this.context != null) {
                                        C36866d.this.yGR = C23639t.m36486a(C36866d.this.cgL.yTx.getActivity(), C36866d.this.context.getString(C25738R.string.byi), (long) FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                                    }
                                    C36866d.this.mfP = true;
                                    C36866d.this.dBA();
                                } else {
                                    C4990ab.m7416i("MicroMsg.AutoPlay", "speaker off");
                                    C36866d.this.mfP = false;
                                    C36866d c36866d = C36866d.this;
                                    if (c36866d.mfO.isPlaying()) {
                                        C4990ab.m7410d("MicroMsg.AutoPlay", "deal sensor event, play next");
                                        c36866d.mfO.mo33406bm(false);
                                        c36866d.mo58735qn(false);
                                    }
                                }
                                AppMethodBeat.m2505o(30410);
                                return false;
                            }
                        }, false).mo16770ae(50, 50);
                    }
                    C4990ab.m7417i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", Boolean.valueOf(this.yGU));
                    AppMethodBeat.m2505o(30432);
                    return;
                }
            }
            this.mfR = true;
            AppMethodBeat.m2505o(30432);
        }
    }

    private void setScreenEnable(boolean z) {
        AppMethodBeat.m2504i(30433);
        if (this.cgL != null) {
            this.cgL.yTx.getController().setScreenEnable(z);
        }
        AppMethodBeat.m2505o(30433);
    }

    private boolean isScreenEnable() {
        AppMethodBeat.m2504i(30434);
        if (this.cgL != null) {
            boolean z = this.cgL.yTx.getController().ylz;
            AppMethodBeat.m2505o(30434);
            return z;
        }
        AppMethodBeat.m2505o(30434);
        return false;
    }

    public final void dBC() {
        AppMethodBeat.m2504i(30435);
        if (this.yGR != null) {
            this.yGR.dismiss();
        }
        AppMethodBeat.m2505o(30435);
    }

    /* renamed from: Zs */
    public final void mo44182Zs() {
        AppMethodBeat.m2504i(30436);
        C4990ab.m7416i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
        this.yGY = false;
        AppMethodBeat.m2505o(30436);
    }

    /* renamed from: Zt */
    public final void mo44183Zt() {
        AppMethodBeat.m2504i(30437);
        C4990ab.m7416i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
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
            AppMethodBeat.m2505o(30437);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AutoPlay", e, "reset sensor error: %s", e.getMessage());
            AppMethodBeat.m2505o(30437);
        }
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(30438);
        C4990ab.m7417i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.cos));
        switch (i) {
            case 1:
                if (this.yHb.hasMessages(0)) {
                    this.yHb.removeMessages(0);
                    this.yHb.sendEmptyMessage(0);
                    AppMethodBeat.m2505o(30438);
                    return;
                }
                break;
            case 2:
            case 4:
                if (this.yHb.hasMessages(0)) {
                    this.yHb.removeMessages(0);
                }
                if (this.cos) {
                    C1407g.m2946KK().mo4818KN();
                    this.cos = false;
                    AppMethodBeat.m2505o(30438);
                    return;
                }
                break;
            case 5:
                C1407g.m2946KK().mo4817KM();
                break;
        }
        AppMethodBeat.m2505o(30438);
    }
}
