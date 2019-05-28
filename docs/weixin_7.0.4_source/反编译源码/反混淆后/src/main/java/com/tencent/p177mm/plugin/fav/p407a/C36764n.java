package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.kernel.C1720g;
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

/* renamed from: com.tencent.mm.plugin.fav.a.n */
public final class C36764n implements C17889a, C17892b, C4986a {
    static SensorController mfW;
    private int cAO;
    private List<C27973a> callbacks = new LinkedList();
    public C17891h mfO = ((C41736i) C1720g.m3528K(C41736i.class)).mo41536BT();
    private boolean mfP = true;
    private boolean mfQ;
    private boolean mfR = false;
    C35992bf mfS;
    long mfT = -1;
    boolean mfU;
    private int mfV;
    public String path;

    /* renamed from: com.tencent.mm.plugin.fav.a.n$a */
    public interface C27973a {
        /* renamed from: bI */
        void mo6771bI(String str, int i);

        void onFinish();

        void onPause();
    }

    /* renamed from: com.tencent.mm.plugin.fav.a.n$1 */
    class C341271 implements Runnable {
        C341271() {
        }

        public final void run() {
            AppMethodBeat.m2504i(102700);
            C36764n.this.mfT = C5046bo.m7588yz();
            AppMethodBeat.m2505o(102700);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.a.n$2 */
    class C341282 implements Runnable {
        C341282() {
        }

        public final void run() {
            AppMethodBeat.m2504i(102701);
            C36764n.this.mfT = C5046bo.m7588yz();
            AppMethodBeat.m2505o(102701);
        }
    }

    public C36764n() {
        AppMethodBeat.m2504i(102702);
        Boolean bool = (Boolean) C1720g.m3536RP().mo5239Ry().get(26, Boolean.FALSE);
        this.mfQ = bool.booleanValue();
        this.mfP = !bool.booleanValue();
        if (this.mfO != null) {
            this.mfO.mo33399a((C17889a) this);
            this.mfO.mo33400a((C17892b) this);
            this.mfO.mo33407bo(this.mfP);
        } else {
            C4990ab.m7420w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
        }
        if (mfW == null) {
            mfW = new SensorController(C4996ah.getContext());
        }
        if (this.mfS == null) {
            this.mfS = new C35992bf(C4996ah.getContext());
        }
        AppMethodBeat.m2505o(102702);
    }

    /* renamed from: a */
    public final void mo58605a(C27973a c27973a) {
        AppMethodBeat.m2504i(102703);
        for (C27973a c27973a2 : this.callbacks) {
            if (c27973a == c27973a2) {
                AppMethodBeat.m2505o(102703);
                return;
            }
        }
        this.callbacks.add(c27973a);
        AppMethodBeat.m2505o(102703);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(102704);
        pause();
        buK();
        mfW = null;
        this.callbacks.clear();
        AppMethodBeat.m2505o(102704);
    }

    public final void pause() {
        AppMethodBeat.m2504i(102705);
        if (this.mfO == null) {
            C4990ab.m7420w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
            AppMethodBeat.m2505o(102705);
            return;
        }
        if (this.mfO.isPlaying()) {
            buJ();
        }
        for (C27973a onPause : this.callbacks) {
            onPause.onPause();
        }
        AppMethodBeat.m2505o(102705);
    }

    public final boolean startPlay(String str, int i) {
        AppMethodBeat.m2504i(102706);
        if (this.mfO == null) {
            C4990ab.m7421w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(102706);
            return false;
        }
        this.mfO.stop();
        for (C27973a bI : this.callbacks) {
            bI.mo6771bI(str, 0);
        }
        if (!(mfW == null || mfW.aGA)) {
            mfW.mo10258a(this);
            if (this.mfS.mo56732aj(new C341271())) {
                this.mfT = 0;
            } else {
                this.mfT = -1;
            }
        }
        this.path = str;
        this.cAO = i;
        if (C5046bo.isNullOrNil(str) || !this.mfO.mo33404a(str, this.mfP, true, i)) {
            AppMethodBeat.m2505o(102706);
            return false;
        }
        C4997aj.amA("keep_app_silent");
        AppMethodBeat.m2505o(102706);
        return true;
    }

    /* renamed from: T */
    public final boolean mo58604T(String str, int i, int i2) {
        AppMethodBeat.m2504i(102707);
        if (this.mfO == null) {
            C4990ab.m7421w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(102707);
            return false;
        }
        this.mfO.stop();
        for (C27973a bI : this.callbacks) {
            bI.mo6771bI(str, i2);
        }
        if (!(mfW == null || mfW.aGA)) {
            mfW.mo10258a(this);
            if (this.mfS.mo56732aj(new C341282())) {
                this.mfT = 0;
            } else {
                this.mfT = -1;
            }
        }
        this.path = str;
        this.cAO = i;
        if (C5046bo.isNullOrNil(str) || !this.mfO.mo33403a(str, this.mfP, i, i2)) {
            AppMethodBeat.m2505o(102707);
            return false;
        }
        C4997aj.amA("keep_app_silent");
        C1407g.m2946KK().mo4834f(this.mfP, false, false);
        AppMethodBeat.m2505o(102707);
        return true;
    }

    public final boolean buH() {
        AppMethodBeat.m2504i(102708);
        if (this.mfO == null) {
            C4990ab.m7420w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
            AppMethodBeat.m2505o(102708);
            return false;
        }
        boolean isPlaying = this.mfO.isPlaying();
        AppMethodBeat.m2505o(102708);
        return isPlaying;
    }

    public final boolean buI() {
        AppMethodBeat.m2504i(102709);
        C4990ab.m7416i("MicroMsg.FavVoiceLogic", "resume play");
        C4997aj.amA("keep_app_silent");
        if (this.mfO == null) {
            C4990ab.m7420w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
            AppMethodBeat.m2505o(102709);
            return false;
        }
        boolean Ew = this.mfO.mo33396Ew();
        AppMethodBeat.m2505o(102709);
        return Ew;
    }

    public final boolean buJ() {
        AppMethodBeat.m2504i(102710);
        C4990ab.m7416i("MicroMsg.FavVoiceLogic", "pause play");
        C4997aj.amB("keep_app_silent");
        if (this.mfO == null) {
            C4990ab.m7420w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
            AppMethodBeat.m2505o(102710);
            return false;
        }
        boolean pause = this.mfO.pause();
        AppMethodBeat.m2505o(102710);
        return pause;
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(102711);
        C4990ab.m7410d("MicroMsg.FavVoiceLogic", "stop play");
        C4997aj.amB("keep_app_silent");
        if (this.mfO != null) {
            this.mfO.stop();
        }
        buK();
        AppMethodBeat.m2505o(102711);
    }

    public final void onError() {
        AppMethodBeat.m2504i(102712);
        C4990ab.m7410d("MicroMsg.FavVoiceLogic", "on error, do stop play");
        stopPlay();
        for (C27973a onFinish : this.callbacks) {
            onFinish.onFinish();
        }
        AppMethodBeat.m2505o(102712);
    }

    /* renamed from: EA */
    public final void mo17611EA() {
        AppMethodBeat.m2504i(102713);
        C4990ab.m7410d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
        stopPlay();
        for (C27973a onFinish : this.callbacks) {
            onFinish.onFinish();
        }
        AppMethodBeat.m2505o(102713);
    }

    private void buK() {
        AppMethodBeat.m2504i(102714);
        if (mfW != null) {
            mfW.dps();
        }
        if (this.mfS != null) {
            this.mfS.dpt();
        }
        AppMethodBeat.m2505o(102714);
    }

    /* renamed from: he */
    public final void mo10257he(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(102715);
        if (C5046bo.isNullOrNil(this.path)) {
            AppMethodBeat.m2505o(102715);
        } else if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.m2505o(102715);
        } else if (z || this.mfT == -1 || C5046bo.m7525az(this.mfT) <= 400) {
            this.mfR = false;
            if (this.mfO != null && this.mfO.mo33397Ex()) {
                AppMethodBeat.m2505o(102715);
            } else if (this.mfQ) {
                if (this.mfO != null) {
                    this.mfO.mo33407bo(false);
                }
                C1407g.m2946KK().mo4834f(false, false, false);
                this.mfP = false;
                AppMethodBeat.m2505o(102715);
            } else if (this.mfO != null && !this.mfO.isPlaying() && !this.mfU) {
                this.mfO.mo33407bo(true);
                this.mfP = true;
                AppMethodBeat.m2505o(102715);
            } else if (C1407g.m2946KK().mo4819KP()) {
                C4990ab.m7410d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
                AppMethodBeat.m2505o(102715);
            } else {
                if (this.mfO != null) {
                    this.mfO.mo33407bo(z);
                }
                this.mfP = z;
                if (!this.mfU || z) {
                    if (!z) {
                        startPlay(this.path, this.cAO);
                    }
                    AppMethodBeat.m2505o(102715);
                    return;
                }
                mo58604T(this.path, this.cAO, this.mfV);
                AppMethodBeat.m2505o(102715);
            }
        } else {
            this.mfR = true;
            AppMethodBeat.m2505o(102715);
        }
    }
}
