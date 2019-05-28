package com.tencent.mm.plugin.record.b;

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

public final class s implements com.tencent.mm.ai.h.a, b, com.tencent.mm.sdk.platformtools.SensorController.a {
    public static SensorController mfW;
    private int cAO;
    public List<a> callbacks = new LinkedList();
    public h mfO = ((i) g.K(i.class)).BT();
    private boolean mfP = true;
    private boolean mfQ;
    private boolean mfR = false;
    private bf mfS;
    long mfT = -1;
    public String path;

    public interface a {
        void VJ(String str);

        void onFinish();
    }

    public s() {
        AppMethodBeat.i(24180);
        aw.ZK();
        Boolean bool = (Boolean) c.Ry().get(26, Boolean.FALSE);
        this.mfQ = bool.booleanValue();
        this.mfP = !bool.booleanValue();
        if (this.mfO != null) {
            this.mfO.a((com.tencent.mm.ai.h.a) this);
            this.mfO.a((b) this);
            if (com.tencent.mm.compatible.b.g.KK().KV() || com.tencent.mm.compatible.b.g.KK().KP()) {
                this.mfO.bo(false);
            } else {
                this.mfO.bo(this.mfP);
            }
        } else {
            ab.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (mfW == null) {
            mfW = new SensorController(ah.getContext());
        }
        if (this.mfS == null) {
            this.mfS = new bf(ah.getContext());
        }
        AppMethodBeat.o(24180);
    }

    public final boolean startPlay(String str, int i) {
        AppMethodBeat.i(24181);
        if (this.mfO == null) {
            ab.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            AppMethodBeat.o(24181);
            return false;
        }
        this.mfO.stop();
        for (a VJ : this.callbacks) {
            VJ.VJ(str);
        }
        if (!(mfW == null || mfW.aGA)) {
            mfW.a(this);
            if (this.mfS.aj(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24179);
                    s.this.mfT = bo.yz();
                    AppMethodBeat.o(24179);
                }
            })) {
                this.mfT = 0;
            } else {
                this.mfT = -1;
            }
        }
        this.path = str;
        this.cAO = i;
        if (bo.isNullOrNil(str) || !this.mfO.a(str, this.mfP, true, i)) {
            AppMethodBeat.o(24181);
            return false;
        }
        aj.amA("keep_app_silent");
        AppMethodBeat.o(24181);
        return true;
    }

    public final boolean buH() {
        AppMethodBeat.i(24182);
        if (this.mfO == null) {
            ab.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
            AppMethodBeat.o(24182);
            return false;
        }
        boolean isPlaying = this.mfO.isPlaying();
        AppMethodBeat.o(24182);
        return isPlaying;
    }

    public final void stopPlay() {
        AppMethodBeat.i(24183);
        ab.d("MicroMsg.RecordVoiceHelper", "stop play");
        aj.amB("keep_app_silent");
        if (this.mfO != null) {
            this.mfO.stop();
        }
        buK();
        AppMethodBeat.o(24183);
    }

    public final void onError() {
        AppMethodBeat.i(24184);
        ab.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        for (a onFinish : this.callbacks) {
            onFinish.onFinish();
        }
        AppMethodBeat.o(24184);
    }

    public final void EA() {
        AppMethodBeat.i(24185);
        ab.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        for (a onFinish : this.callbacks) {
            onFinish.onFinish();
        }
        AppMethodBeat.o(24185);
    }

    public final void buK() {
        AppMethodBeat.i(24186);
        if (mfW != null) {
            mfW.dps();
        }
        if (this.mfS != null) {
            this.mfS.dpt();
        }
        AppMethodBeat.o(24186);
    }

    public final void he(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(24187);
        if (bo.isNullOrNil(this.path)) {
            AppMethodBeat.o(24187);
        } else if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.o(24187);
        } else if (z || this.mfT == -1 || bo.az(this.mfT) <= 400) {
            this.mfR = false;
            if (this.mfO != null && this.mfO.Ex()) {
                AppMethodBeat.o(24187);
            } else if (this.mfQ) {
                if (this.mfO != null) {
                    this.mfO.bo(false);
                }
                this.mfP = false;
                AppMethodBeat.o(24187);
            } else if (this.mfO == null || this.mfO.isPlaying()) {
                if (this.mfO != null) {
                    this.mfO.bo(z);
                }
                this.mfP = z;
                if (!z) {
                    startPlay(this.path, this.cAO);
                }
                AppMethodBeat.o(24187);
            } else {
                this.mfO.bo(true);
                this.mfP = true;
                AppMethodBeat.o(24187);
            }
        } else {
            this.mfR = true;
            AppMethodBeat.o(24187);
        }
    }
}
