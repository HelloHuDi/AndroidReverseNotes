package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

public class SceneVoiceInputAddrProxy extends a implements b {
    private static SceneVoiceInputAddrProxy gbn;
    private d ext;
    private b gbo;
    private b gbp;

    public static void create(d dVar) {
        AppMethodBeat.i(116727);
        gbn = new SceneVoiceInputAddrProxy(dVar);
        AppMethodBeat.o(116727);
    }

    public static SceneVoiceInputAddrProxy getInstance() {
        AppMethodBeat.i(116728);
        if (gbn == null) {
            create(new d(ah.getContext()));
        }
        SceneVoiceInputAddrProxy sceneVoiceInputAddrProxy = gbn;
        AppMethodBeat.o(116728);
        return sceneVoiceInputAddrProxy;
    }

    public SceneVoiceInputAddrProxy(d dVar) {
        super(dVar);
        AppMethodBeat.i(116729);
        if (dVar == null) {
            AppMethodBeat.o(116729);
            return;
        }
        this.ext = dVar;
        dVar.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(116722);
                ab.i("SceneVoiceInputAddrProxy", "remote service connected");
                AppMethodBeat.o(116722);
            }
        });
        AppMethodBeat.o(116729);
    }

    public boolean isConnected() {
        AppMethodBeat.i(116730);
        if (this.ext == null) {
            AppMethodBeat.o(116730);
            return false;
        }
        boolean isConnected = this.ext.isConnected();
        AppMethodBeat.o(116730);
        return isConnected;
    }

    public void connect(Runnable runnable) {
        AppMethodBeat.i(116731);
        if (this.ext == null) {
            AppMethodBeat.o(116731);
            return;
        }
        this.ext.connect(runnable);
        AppMethodBeat.o(116731);
    }

    @e
    public void cancel(boolean z) {
        AppMethodBeat.i(116732);
        REMOTE_CALL("cancelMM", Boolean.valueOf(z));
        AppMethodBeat.o(116732);
    }

    @f
    public void cancelMM(boolean z) {
        AppMethodBeat.i(116733);
        if (getInstance().gbo != null) {
            getInstance().gbo.cancel(z);
        }
        AppMethodBeat.o(116733);
    }

    @e
    public void stop(boolean z) {
        AppMethodBeat.i(116734);
        REMOTE_CALL("stopMM", Boolean.valueOf(z));
        AppMethodBeat.o(116734);
    }

    @f
    public void stopMM(boolean z) {
        AppMethodBeat.i(116735);
        if (getInstance().gbo != null) {
            getInstance().gbo.stop(z);
        }
        AppMethodBeat.o(116735);
    }

    @e
    public void start() {
        AppMethodBeat.i(116736);
        REMOTE_CALL("startMM", new Object[0]);
        AppMethodBeat.o(116736);
    }

    @f
    public void startMM() {
        AppMethodBeat.i(116737);
        if (getInstance().gbo != null) {
            getInstance().gbo.start();
        }
        AppMethodBeat.o(116737);
    }

    @e
    public int getMaxAmplitudeRate() {
        AppMethodBeat.i(116738);
        Integer num = (Integer) REMOTE_CALL("getMaxAmplitudeRateMM", new Object[0]);
        if (num == null) {
            AppMethodBeat.o(116738);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(116738);
        return intValue;
    }

    public void init(int i, int i2, b bVar) {
        AppMethodBeat.i(116739);
        getInstance().gbp = bVar;
        REMOTE_CALL("initMM", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(116739);
    }

    @f
    public void initMM(int i, int i2) {
        AppMethodBeat.i(116740);
        getInstance().gbo = new g(i, i2, new b() {
            public final void b(String[] strArr, List<String> list) {
                AppMethodBeat.i(138329);
                SceneVoiceInputAddrProxy.this.CLIENT_CALL("onResCli", strArr, list);
                AppMethodBeat.o(138329);
            }

            public final void c(int i, int i2, int i3, long j) {
                AppMethodBeat.i(116724);
                SceneVoiceInputAddrProxy.this.CLIENT_CALL("onErrorCli", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j));
                AppMethodBeat.o(116724);
            }

            public final void ams() {
                AppMethodBeat.i(116725);
                SceneVoiceInputAddrProxy.this.CLIENT_CALL("onRecordFinCli", new Object[0]);
                AppMethodBeat.o(116725);
            }

            public final void amw() {
                AppMethodBeat.i(116726);
                SceneVoiceInputAddrProxy.this.CLIENT_CALL("onRecognizeFinishCli", new Object[0]);
                AppMethodBeat.o(116726);
            }
        });
        AppMethodBeat.o(116740);
    }

    @f
    public int getMaxAmplitudeRateMM() {
        AppMethodBeat.i(116741);
        if (getInstance().gbo != null) {
            int maxAmplitudeRate = getInstance().gbo.getMaxAmplitudeRate();
            AppMethodBeat.o(116741);
            return maxAmplitudeRate;
        }
        AppMethodBeat.o(116741);
        return 0;
    }

    @e
    public void onResCli(String[] strArr, List<String> list) {
        AppMethodBeat.i(138330);
        if (getInstance().gbp != null) {
            getInstance().gbp.b(strArr, list);
        }
        AppMethodBeat.o(138330);
    }

    @e
    public void onErrorCli(int i, int i2, int i3, long j) {
        AppMethodBeat.i(116743);
        if (getInstance().gbp != null) {
            getInstance().gbp.c(i, i2, i3, j);
        }
        AppMethodBeat.o(116743);
    }

    @e
    public void onRecordFinCli() {
        AppMethodBeat.i(116744);
        if (getInstance().gbp != null) {
            getInstance().gbp.ams();
        }
        AppMethodBeat.o(116744);
    }

    @e
    public void onRecognizeFinishCli() {
        AppMethodBeat.i(116745);
        if (getInstance().gbp != null) {
            getInstance().gbp.amw();
        }
        AppMethodBeat.o(116745);
    }
}
