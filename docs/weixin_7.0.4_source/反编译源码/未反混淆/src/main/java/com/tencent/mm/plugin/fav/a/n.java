package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class n implements com.tencent.mm.ai.h.a, b, com.tencent.mm.sdk.platformtools.SensorController.a {
    static SensorController mfW;
    private int cAO;
    private List<a> callbacks = new LinkedList();
    public h mfO = ((i) g.K(i.class)).BT();
    private boolean mfP = true;
    private boolean mfQ;
    private boolean mfR = false;
    bf mfS;
    long mfT = -1;
    boolean mfU;
    private int mfV;
    public String path;

    public interface a {
        void bI(String str, int i);

        void onFinish();

        void onPause();
    }

    public n() {
        AppMethodBeat.i(102702);
        Boolean bool = (Boolean) g.RP().Ry().get(26, Boolean.FALSE);
        this.mfQ = bool.booleanValue();
        this.mfP = !bool.booleanValue();
        if (this.mfO != null) {
            this.mfO.a((com.tencent.mm.ai.h.a) this);
            this.mfO.a((b) this);
            this.mfO.bo(this.mfP);
        } else {
            ab.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
        }
        if (mfW == null) {
            mfW = new SensorController(ah.getContext());
        }
        if (this.mfS == null) {
            this.mfS = new bf(ah.getContext());
        }
        AppMethodBeat.o(102702);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(102703);
        for (a aVar2 : this.callbacks) {
            if (aVar == aVar2) {
                AppMethodBeat.o(102703);
                return;
            }
        }
        this.callbacks.add(aVar);
        AppMethodBeat.o(102703);
    }

    public final void destroy() {
        AppMethodBeat.i(102704);
        pause();
        buK();
        mfW = null;
        this.callbacks.clear();
        AppMethodBeat.o(102704);
    }

    public final void pause() {
        AppMethodBeat.i(102705);
        if (this.mfO == null) {
            ab.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
            AppMethodBeat.o(102705);
            return;
        }
        if (this.mfO.isPlaying()) {
            buJ();
        }
        for (a onPause : this.callbacks) {
            onPause.onPause();
        }
        AppMethodBeat.o(102705);
    }

    public final boolean startPlay(String str, int i) {
        AppMethodBeat.i(102706);
        if (this.mfO == null) {
            ab.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            AppMethodBeat.o(102706);
            return false;
        }
        this.mfO.stop();
        for (a bI : this.callbacks) {
            bI.bI(str, 0);
        }
        if (!(mfW == null || mfW.aGA)) {
            mfW.a(this);
            if (this.mfS.aj(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102700);
                    n.this.mfT = bo.yz();
                    AppMethodBeat.o(102700);
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
            AppMethodBeat.o(102706);
            return false;
        }
        aj.amA("keep_app_silent");
        AppMethodBeat.o(102706);
        return true;
    }

    public final boolean T(String str, int i, int i2) {
        AppMethodBeat.i(102707);
        if (this.mfO == null) {
            ab.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            AppMethodBeat.o(102707);
            return false;
        }
        this.mfO.stop();
        for (a bI : this.callbacks) {
            bI.bI(str, i2);
        }
        if (!(mfW == null || mfW.aGA)) {
            mfW.a(this);
            if (this.mfS.aj(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102701);
                    n.this.mfT = bo.yz();
                    AppMethodBeat.o(102701);
                }
            })) {
                this.mfT = 0;
            } else {
                this.mfT = -1;
            }
        }
        this.path = str;
        this.cAO = i;
        if (bo.isNullOrNil(str) || !this.mfO.a(str, this.mfP, i, i2)) {
            AppMethodBeat.o(102707);
            return false;
        }
        aj.amA("keep_app_silent");
        com.tencent.mm.compatible.b.g.KK().f(this.mfP, false, false);
        AppMethodBeat.o(102707);
        return true;
    }

    public final boolean buH() {
        AppMethodBeat.i(102708);
        if (this.mfO == null) {
            ab.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
            AppMethodBeat.o(102708);
            return false;
        }
        boolean isPlaying = this.mfO.isPlaying();
        AppMethodBeat.o(102708);
        return isPlaying;
    }

    public final boolean buI() {
        AppMethodBeat.i(102709);
        ab.i("MicroMsg.FavVoiceLogic", "resume play");
        aj.amA("keep_app_silent");
        if (this.mfO == null) {
            ab.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
            AppMethodBeat.o(102709);
            return false;
        }
        boolean Ew = this.mfO.Ew();
        AppMethodBeat.o(102709);
        return Ew;
    }

    public final boolean buJ() {
        AppMethodBeat.i(102710);
        ab.i("MicroMsg.FavVoiceLogic", "pause play");
        aj.amB("keep_app_silent");
        if (this.mfO == null) {
            ab.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
            AppMethodBeat.o(102710);
            return false;
        }
        boolean pause = this.mfO.pause();
        AppMethodBeat.o(102710);
        return pause;
    }

    public final void stopPlay() {
        AppMethodBeat.i(102711);
        ab.d("MicroMsg.FavVoiceLogic", "stop play");
        aj.amB("keep_app_silent");
        if (this.mfO != null) {
            this.mfO.stop();
        }
        buK();
        AppMethodBeat.o(102711);
    }

    public final void onError() {
        AppMethodBeat.i(102712);
        ab.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
        stopPlay();
        for (a onFinish : this.callbacks) {
            onFinish.onFinish();
        }
        AppMethodBeat.o(102712);
    }

    public final void EA() {
        AppMethodBeat.i(102713);
        ab.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
        stopPlay();
        for (a onFinish : this.callbacks) {
            onFinish.onFinish();
        }
        AppMethodBeat.o(102713);
    }

    private void buK() {
        AppMethodBeat.i(102714);
        if (mfW != null) {
            mfW.dps();
        }
        if (this.mfS != null) {
            this.mfS.dpt();
        }
        AppMethodBeat.o(102714);
    }

    public final void he(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(102715);
        if (bo.isNullOrNil(this.path)) {
            AppMethodBeat.o(102715);
        } else if (this.mfR) {
            if (z) {
                z2 = false;
            }
            this.mfR = z2;
            AppMethodBeat.o(102715);
        } else if (z || this.mfT == -1 || bo.az(this.mfT) <= 400) {
            this.mfR = false;
            if (this.mfO != null && this.mfO.Ex()) {
                AppMethodBeat.o(102715);
            } else if (this.mfQ) {
                if (this.mfO != null) {
                    this.mfO.bo(false);
                }
                com.tencent.mm.compatible.b.g.KK().f(false, false, false);
                this.mfP = false;
                AppMethodBeat.o(102715);
            } else if (this.mfO != null && !this.mfO.isPlaying() && !this.mfU) {
                this.mfO.bo(true);
                this.mfP = true;
                AppMethodBeat.o(102715);
            } else if (com.tencent.mm.compatible.b.g.KK().KP()) {
                ab.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
                AppMethodBeat.o(102715);
            } else {
                if (this.mfO != null) {
                    this.mfO.bo(z);
                }
                this.mfP = z;
                if (!this.mfU || z) {
                    if (!z) {
                        startPlay(this.path, this.cAO);
                    }
                    AppMethodBeat.o(102715);
                    return;
                }
                T(this.path, this.cAO, this.mfV);
                AppMethodBeat.o(102715);
            }
        } else {
            this.mfR = true;
            AppMethodBeat.o(102715);
        }
    }
}
