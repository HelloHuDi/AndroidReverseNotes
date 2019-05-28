package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public class a implements com.tencent.mm.ai.h.a, b, com.tencent.mm.sdk.platformtools.SensorController.a {
    public static volatile a uVh = null;
    private int cAO;
    public List<a> callbacks = new LinkedList();
    public h mfO = ((i) g.K(i.class)).BT();
    private boolean mfP = true;
    private boolean mfQ;
    private boolean mfR = false;
    public bf mfS;
    private long mfT = -1;
    public SensorController mfW;
    public String path;

    public interface a {
        void ahs(String str);

        void dfX();
    }

    private a() {
        AppMethodBeat.i(27198);
        aw.ZK();
        Boolean bool = (Boolean) c.Ry().get(26, Boolean.FALSE);
        this.mfQ = bool.booleanValue();
        this.mfP = !bool.booleanValue();
        if (this.mfO != null) {
            this.mfO.a((com.tencent.mm.ai.h.a) this);
            this.mfO.a((b) this);
            this.mfO.bo(this.mfP);
        } else {
            ab.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (this.mfW == null) {
            this.mfW = new SensorController(ah.getContext());
        }
        if (this.mfS == null) {
            this.mfS = new bf(ah.getContext());
        }
        AppMethodBeat.o(27198);
    }

    public static a dfY() {
        AppMethodBeat.i(27199);
        if (uVh == null) {
            synchronized (a.class) {
                try {
                    if (uVh == null) {
                        uVh = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(27199);
                    }
                }
            }
        }
        a aVar = uVh;
        AppMethodBeat.o(27199);
        return aVar;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(27200);
        if (aVar == null) {
            AppMethodBeat.o(27200);
            return;
        }
        for (a aVar2 : this.callbacks) {
            if (aVar == aVar2) {
                AppMethodBeat.o(27200);
                return;
            }
        }
        this.callbacks.add(aVar);
        AppMethodBeat.o(27200);
    }

    private void bJs() {
        AppMethodBeat.i(27201);
        if (!(this.mfW == null || this.mfW.aGA)) {
            this.mfW.a(this);
            if (this.mfS.aj(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27197);
                    a.this.mfT = bo.yz();
                    AppMethodBeat.o(27197);
                }
            })) {
                this.mfT = 0;
                AppMethodBeat.o(27201);
                return;
            }
            this.mfT = -1;
        }
        AppMethodBeat.o(27201);
    }

    private void buK() {
        AppMethodBeat.i(27202);
        if (this.mfW != null) {
            this.mfW.dps();
        }
        if (this.mfS != null) {
            this.mfS.dpt();
        }
        AppMethodBeat.o(27202);
    }

    public final boolean startPlay(String str, int i) {
        AppMethodBeat.i(27203);
        if (this.mfO == null) {
            ab.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            AppMethodBeat.o(27203);
            return false;
        }
        this.mfO.stop();
        bJs();
        this.path = str;
        this.cAO = i;
        if (bo.isNullOrNil(str) || !this.mfO.a(str, this.mfP, true, i)) {
            AppMethodBeat.o(27203);
            return false;
        }
        aj.amA("keep_app_silent");
        for (a aVar : this.callbacks) {
            if (aVar != null) {
                aVar.ahs(str);
            }
        }
        AppMethodBeat.o(27203);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.i(27204);
        ab.i("MicroMsg.RecordVoiceHelper", "stop play");
        aj.amB("keep_app_silent");
        if (this.mfO != null) {
            this.mfO.stop();
            for (a aVar : this.callbacks) {
                if (aVar != null) {
                    aVar.dfX();
                }
            }
        }
        buK();
        AppMethodBeat.o(27204);
    }

    public final boolean buH() {
        AppMethodBeat.i(27205);
        if (this.mfO == null) {
            ab.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
            AppMethodBeat.o(27205);
            return false;
        }
        boolean isPlaying = this.mfO.isPlaying();
        AppMethodBeat.o(27205);
        return isPlaying;
    }

    public final double Ez() {
        AppMethodBeat.i(27206);
        if (this.mfO == null) {
            ab.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
            AppMethodBeat.o(27206);
            return 0.0d;
        }
        double Ez = this.mfO.Ez();
        AppMethodBeat.o(27206);
        return Ez;
    }

    public final void onError() {
        AppMethodBeat.i(27207);
        ab.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        AppMethodBeat.o(27207);
    }

    public final void EA() {
        AppMethodBeat.i(27208);
        ab.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        AppMethodBeat.o(27208);
    }

    public final void he(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(27209);
        if (bo.isNullOrNil(this.path)) {
            AppMethodBeat.o(27209);
        } else if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.o(27209);
        } else if (z || this.mfT == -1 || bo.az(this.mfT) <= 400) {
            this.mfR = false;
            if (this.mfO != null && this.mfO.Ex()) {
                AppMethodBeat.o(27209);
            } else if (this.mfQ) {
                if (this.mfO != null) {
                    this.mfO.bo(false);
                }
                this.mfP = false;
                AppMethodBeat.o(27209);
            } else if (this.mfO == null || this.mfO.isPlaying()) {
                if (this.mfO != null) {
                    this.mfO.bo(z);
                }
                this.mfP = z;
                if (!z) {
                    startPlay(this.path, this.cAO);
                }
                AppMethodBeat.o(27209);
            } else {
                this.mfO.bo(true);
                this.mfP = true;
                AppMethodBeat.o(27209);
            }
        } else {
            this.mfR = true;
            AppMethodBeat.o(27209);
        }
    }
}
