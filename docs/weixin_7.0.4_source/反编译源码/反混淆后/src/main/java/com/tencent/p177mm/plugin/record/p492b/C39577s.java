package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C17891h;
import com.tencent.p177mm.p183ai.C17891h.C17889a;
import com.tencent.p177mm.p183ai.C17891h.C17892b;
import com.tencent.p177mm.p183ai.C41736i;
import com.tencent.p177mm.sdk.platformtools.C35992bf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.SensorController;
import com.tencent.p177mm.sdk.platformtools.SensorController.C4986a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.record.b.s */
public final class C39577s implements C17889a, C17892b, C4986a {
    public static SensorController mfW;
    private int cAO;
    public List<C34796a> callbacks = new LinkedList();
    public C17891h mfO = ((C41736i) C1720g.m3528K(C41736i.class)).mo41536BT();
    private boolean mfP = true;
    private boolean mfQ;
    private boolean mfR = false;
    private C35992bf mfS;
    long mfT = -1;
    public String path;

    /* renamed from: com.tencent.mm.plugin.record.b.s$1 */
    class C129871 implements Runnable {
        C129871() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24179);
            C39577s.this.mfT = C5046bo.m7588yz();
            AppMethodBeat.m2505o(24179);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.s$a */
    public interface C34796a {
        /* renamed from: VJ */
        void mo55409VJ(String str);

        void onFinish();
    }

    public C39577s() {
        AppMethodBeat.m2504i(24180);
        C9638aw.m17190ZK();
        Boolean bool = (Boolean) C18628c.m29072Ry().get(26, Boolean.FALSE);
        this.mfQ = bool.booleanValue();
        this.mfP = !bool.booleanValue();
        if (this.mfO != null) {
            this.mfO.mo33399a((C17889a) this);
            this.mfO.mo33400a((C17892b) this);
            if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
                this.mfO.mo33407bo(false);
            } else {
                this.mfO.mo33407bo(this.mfP);
            }
        } else {
            C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (mfW == null) {
            mfW = new SensorController(C4996ah.getContext());
        }
        if (this.mfS == null) {
            this.mfS = new C35992bf(C4996ah.getContext());
        }
        AppMethodBeat.m2505o(24180);
    }

    public final boolean startPlay(String str, int i) {
        AppMethodBeat.m2504i(24181);
        if (this.mfO == null) {
            C4990ab.m7421w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(24181);
            return false;
        }
        this.mfO.stop();
        for (C34796a VJ : this.callbacks) {
            VJ.mo55409VJ(str);
        }
        if (!(mfW == null || mfW.aGA)) {
            mfW.mo10258a(this);
            if (this.mfS.mo56732aj(new C129871())) {
                this.mfT = 0;
            } else {
                this.mfT = -1;
            }
        }
        this.path = str;
        this.cAO = i;
        if (C5046bo.isNullOrNil(str) || !this.mfO.mo33404a(str, this.mfP, true, i)) {
            AppMethodBeat.m2505o(24181);
            return false;
        }
        C4997aj.amA("keep_app_silent");
        AppMethodBeat.m2505o(24181);
        return true;
    }

    public final boolean buH() {
        AppMethodBeat.m2504i(24182);
        if (this.mfO == null) {
            C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
            AppMethodBeat.m2505o(24182);
            return false;
        }
        boolean isPlaying = this.mfO.isPlaying();
        AppMethodBeat.m2505o(24182);
        return isPlaying;
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(24183);
        C4990ab.m7410d("MicroMsg.RecordVoiceHelper", "stop play");
        C4997aj.amB("keep_app_silent");
        if (this.mfO != null) {
            this.mfO.stop();
        }
        buK();
        AppMethodBeat.m2505o(24183);
    }

    public final void onError() {
        AppMethodBeat.m2504i(24184);
        C4990ab.m7410d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        for (C34796a onFinish : this.callbacks) {
            onFinish.onFinish();
        }
        AppMethodBeat.m2505o(24184);
    }

    /* renamed from: EA */
    public final void mo17611EA() {
        AppMethodBeat.m2504i(24185);
        C4990ab.m7410d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        for (C34796a onFinish : this.callbacks) {
            onFinish.onFinish();
        }
        AppMethodBeat.m2505o(24185);
    }

    public final void buK() {
        AppMethodBeat.m2504i(24186);
        if (mfW != null) {
            mfW.dps();
        }
        if (this.mfS != null) {
            this.mfS.dpt();
        }
        AppMethodBeat.m2505o(24186);
    }

    /* renamed from: he */
    public final void mo10257he(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(24187);
        if (C5046bo.isNullOrNil(this.path)) {
            AppMethodBeat.m2505o(24187);
        } else if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.m2505o(24187);
        } else if (z || this.mfT == -1 || C5046bo.m7525az(this.mfT) <= 400) {
            this.mfR = false;
            if (this.mfO != null && this.mfO.mo33397Ex()) {
                AppMethodBeat.m2505o(24187);
            } else if (this.mfQ) {
                if (this.mfO != null) {
                    this.mfO.mo33407bo(false);
                }
                this.mfP = false;
                AppMethodBeat.m2505o(24187);
            } else if (this.mfO == null || this.mfO.isPlaying()) {
                if (this.mfO != null) {
                    this.mfO.mo33407bo(z);
                }
                this.mfP = z;
                if (!z) {
                    startPlay(this.path, this.cAO);
                }
                AppMethodBeat.m2505o(24187);
            } else {
                this.mfO.mo33407bo(true);
                this.mfP = true;
                AppMethodBeat.m2505o(24187);
            }
        } else {
            this.mfR = true;
            AppMethodBeat.m2505o(24187);
        }
    }
}
