package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
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

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a */
public class C44019a implements C17889a, C17892b, C4986a {
    public static volatile C44019a uVh = null;
    private int cAO;
    public List<C4692a> callbacks = new LinkedList();
    public C17891h mfO = ((C41736i) C1720g.m3528K(C41736i.class)).mo41536BT();
    private boolean mfP = true;
    private boolean mfQ;
    private boolean mfR = false;
    public C35992bf mfS;
    private long mfT = -1;
    public SensorController mfW;
    public String path;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a$a */
    public interface C4692a {
        void ahs(String str);

        void dfX();
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a$1 */
    class C440201 implements Runnable {
        C440201() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27197);
            C44019a.this.mfT = C5046bo.m7588yz();
            AppMethodBeat.m2505o(27197);
        }
    }

    private C44019a() {
        AppMethodBeat.m2504i(27198);
        C9638aw.m17190ZK();
        Boolean bool = (Boolean) C18628c.m29072Ry().get(26, Boolean.FALSE);
        this.mfQ = bool.booleanValue();
        this.mfP = !bool.booleanValue();
        if (this.mfO != null) {
            this.mfO.mo33399a((C17889a) this);
            this.mfO.mo33400a((C17892b) this);
            this.mfO.mo33407bo(this.mfP);
        } else {
            C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (this.mfW == null) {
            this.mfW = new SensorController(C4996ah.getContext());
        }
        if (this.mfS == null) {
            this.mfS = new C35992bf(C4996ah.getContext());
        }
        AppMethodBeat.m2505o(27198);
    }

    public static C44019a dfY() {
        AppMethodBeat.m2504i(27199);
        if (uVh == null) {
            synchronized (C44019a.class) {
                try {
                    if (uVh == null) {
                        uVh = new C44019a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(27199);
                    }
                }
            }
        }
        C44019a c44019a = uVh;
        AppMethodBeat.m2505o(27199);
        return c44019a;
    }

    /* renamed from: a */
    public final void mo69695a(C4692a c4692a) {
        AppMethodBeat.m2504i(27200);
        if (c4692a == null) {
            AppMethodBeat.m2505o(27200);
            return;
        }
        for (C4692a c4692a2 : this.callbacks) {
            if (c4692a == c4692a2) {
                AppMethodBeat.m2505o(27200);
                return;
            }
        }
        this.callbacks.add(c4692a);
        AppMethodBeat.m2505o(27200);
    }

    private void bJs() {
        AppMethodBeat.m2504i(27201);
        if (!(this.mfW == null || this.mfW.aGA)) {
            this.mfW.mo10258a(this);
            if (this.mfS.mo56732aj(new C440201())) {
                this.mfT = 0;
                AppMethodBeat.m2505o(27201);
                return;
            }
            this.mfT = -1;
        }
        AppMethodBeat.m2505o(27201);
    }

    private void buK() {
        AppMethodBeat.m2504i(27202);
        if (this.mfW != null) {
            this.mfW.dps();
        }
        if (this.mfS != null) {
            this.mfS.dpt();
        }
        AppMethodBeat.m2505o(27202);
    }

    public final boolean startPlay(String str, int i) {
        AppMethodBeat.m2504i(27203);
        if (this.mfO == null) {
            C4990ab.m7421w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(27203);
            return false;
        }
        this.mfO.stop();
        bJs();
        this.path = str;
        this.cAO = i;
        if (C5046bo.isNullOrNil(str) || !this.mfO.mo33404a(str, this.mfP, true, i)) {
            AppMethodBeat.m2505o(27203);
            return false;
        }
        C4997aj.amA("keep_app_silent");
        for (C4692a c4692a : this.callbacks) {
            if (c4692a != null) {
                c4692a.ahs(str);
            }
        }
        AppMethodBeat.m2505o(27203);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(27204);
        C4990ab.m7416i("MicroMsg.RecordVoiceHelper", "stop play");
        C4997aj.amB("keep_app_silent");
        if (this.mfO != null) {
            this.mfO.stop();
            for (C4692a c4692a : this.callbacks) {
                if (c4692a != null) {
                    c4692a.dfX();
                }
            }
        }
        buK();
        AppMethodBeat.m2505o(27204);
    }

    public final boolean buH() {
        AppMethodBeat.m2504i(27205);
        if (this.mfO == null) {
            C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
            AppMethodBeat.m2505o(27205);
            return false;
        }
        boolean isPlaying = this.mfO.isPlaying();
        AppMethodBeat.m2505o(27205);
        return isPlaying;
    }

    /* renamed from: Ez */
    public final double mo69694Ez() {
        AppMethodBeat.m2504i(27206);
        if (this.mfO == null) {
            C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
            AppMethodBeat.m2505o(27206);
            return 0.0d;
        }
        double Ez = this.mfO.mo33398Ez();
        AppMethodBeat.m2505o(27206);
        return Ez;
    }

    public final void onError() {
        AppMethodBeat.m2504i(27207);
        C4990ab.m7410d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        AppMethodBeat.m2505o(27207);
    }

    /* renamed from: EA */
    public final void mo17611EA() {
        AppMethodBeat.m2504i(27208);
        C4990ab.m7410d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        AppMethodBeat.m2505o(27208);
    }

    /* renamed from: he */
    public final void mo10257he(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(27209);
        if (C5046bo.isNullOrNil(this.path)) {
            AppMethodBeat.m2505o(27209);
        } else if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.m2505o(27209);
        } else if (z || this.mfT == -1 || C5046bo.m7525az(this.mfT) <= 400) {
            this.mfR = false;
            if (this.mfO != null && this.mfO.mo33397Ex()) {
                AppMethodBeat.m2505o(27209);
            } else if (this.mfQ) {
                if (this.mfO != null) {
                    this.mfO.mo33407bo(false);
                }
                this.mfP = false;
                AppMethodBeat.m2505o(27209);
            } else if (this.mfO == null || this.mfO.isPlaying()) {
                if (this.mfO != null) {
                    this.mfO.mo33407bo(z);
                }
                this.mfP = z;
                if (!z) {
                    startPlay(this.path, this.cAO);
                }
                AppMethodBeat.m2505o(27209);
            } else {
                this.mfO.mo33407bo(true);
                this.mfP = true;
                AppMethodBeat.m2505o(27209);
            }
        } else {
            this.mfR = true;
            AppMethodBeat.m2505o(27209);
        }
    }
}
