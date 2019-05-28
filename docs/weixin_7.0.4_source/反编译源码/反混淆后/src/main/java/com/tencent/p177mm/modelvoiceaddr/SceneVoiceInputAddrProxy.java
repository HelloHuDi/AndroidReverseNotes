package com.tencent.p177mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoiceaddr.C42236g.C32852b;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.List;

/* renamed from: com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy */
public class SceneVoiceInputAddrProxy extends C31577a implements C18725b {
    private static SceneVoiceInputAddrProxy gbn;
    private C46607d ext;
    private C18725b gbo;
    private C32852b gbp;

    /* renamed from: com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy$1 */
    class C97491 implements Runnable {
        C97491() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116722);
            C4990ab.m7416i("SceneVoiceInputAddrProxy", "remote service connected");
            AppMethodBeat.m2505o(116722);
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy$2 */
    class C97502 implements C32852b {
        C97502() {
        }

        /* renamed from: b */
        public final void mo21116b(String[] strArr, List<String> list) {
            AppMethodBeat.m2504i(138329);
            SceneVoiceInputAddrProxy.this.CLIENT_CALL("onResCli", strArr, list);
            AppMethodBeat.m2505o(138329);
        }

        /* renamed from: c */
        public final void mo21117c(int i, int i2, int i3, long j) {
            AppMethodBeat.m2504i(116724);
            SceneVoiceInputAddrProxy.this.CLIENT_CALL("onErrorCli", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j));
            AppMethodBeat.m2505o(116724);
        }

        public final void ams() {
            AppMethodBeat.m2504i(116725);
            SceneVoiceInputAddrProxy.this.CLIENT_CALL("onRecordFinCli", new Object[0]);
            AppMethodBeat.m2505o(116725);
        }

        public final void amw() {
            AppMethodBeat.m2504i(116726);
            SceneVoiceInputAddrProxy.this.CLIENT_CALL("onRecognizeFinishCli", new Object[0]);
            AppMethodBeat.m2505o(116726);
        }
    }

    public static void create(C46607d c46607d) {
        AppMethodBeat.m2504i(116727);
        gbn = new SceneVoiceInputAddrProxy(c46607d);
        AppMethodBeat.m2505o(116727);
    }

    public static SceneVoiceInputAddrProxy getInstance() {
        AppMethodBeat.m2504i(116728);
        if (gbn == null) {
            SceneVoiceInputAddrProxy.create(new C46607d(C4996ah.getContext()));
        }
        SceneVoiceInputAddrProxy sceneVoiceInputAddrProxy = gbn;
        AppMethodBeat.m2505o(116728);
        return sceneVoiceInputAddrProxy;
    }

    public SceneVoiceInputAddrProxy(C46607d c46607d) {
        super(c46607d);
        AppMethodBeat.m2504i(116729);
        if (c46607d == null) {
            AppMethodBeat.m2505o(116729);
            return;
        }
        this.ext = c46607d;
        c46607d.connect(new C97491());
        AppMethodBeat.m2505o(116729);
    }

    public boolean isConnected() {
        AppMethodBeat.m2504i(116730);
        if (this.ext == null) {
            AppMethodBeat.m2505o(116730);
            return false;
        }
        boolean isConnected = this.ext.isConnected();
        AppMethodBeat.m2505o(116730);
        return isConnected;
    }

    public void connect(Runnable runnable) {
        AppMethodBeat.m2504i(116731);
        if (this.ext == null) {
            AppMethodBeat.m2505o(116731);
            return;
        }
        this.ext.connect(runnable);
        AppMethodBeat.m2505o(116731);
    }

    @C40602e
    public void cancel(boolean z) {
        AppMethodBeat.m2504i(116732);
        REMOTE_CALL("cancelMM", Boolean.valueOf(z));
        AppMethodBeat.m2505o(116732);
    }

    @C46608f
    public void cancelMM(boolean z) {
        AppMethodBeat.m2504i(116733);
        if (SceneVoiceInputAddrProxy.getInstance().gbo != null) {
            SceneVoiceInputAddrProxy.getInstance().gbo.cancel(z);
        }
        AppMethodBeat.m2505o(116733);
    }

    @C40602e
    public void stop(boolean z) {
        AppMethodBeat.m2504i(116734);
        REMOTE_CALL("stopMM", Boolean.valueOf(z));
        AppMethodBeat.m2505o(116734);
    }

    @C46608f
    public void stopMM(boolean z) {
        AppMethodBeat.m2504i(116735);
        if (SceneVoiceInputAddrProxy.getInstance().gbo != null) {
            SceneVoiceInputAddrProxy.getInstance().gbo.stop(z);
        }
        AppMethodBeat.m2505o(116735);
    }

    @C40602e
    public void start() {
        AppMethodBeat.m2504i(116736);
        REMOTE_CALL("startMM", new Object[0]);
        AppMethodBeat.m2505o(116736);
    }

    @C46608f
    public void startMM() {
        AppMethodBeat.m2504i(116737);
        if (SceneVoiceInputAddrProxy.getInstance().gbo != null) {
            SceneVoiceInputAddrProxy.getInstance().gbo.start();
        }
        AppMethodBeat.m2505o(116737);
    }

    @C40602e
    public int getMaxAmplitudeRate() {
        AppMethodBeat.m2504i(116738);
        Integer num = (Integer) REMOTE_CALL("getMaxAmplitudeRateMM", new Object[0]);
        if (num == null) {
            AppMethodBeat.m2505o(116738);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(116738);
        return intValue;
    }

    public void init(int i, int i2, C32852b c32852b) {
        AppMethodBeat.m2504i(116739);
        SceneVoiceInputAddrProxy.getInstance().gbp = c32852b;
        REMOTE_CALL("initMM", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(116739);
    }

    @C46608f
    public void initMM(int i, int i2) {
        AppMethodBeat.m2504i(116740);
        SceneVoiceInputAddrProxy.getInstance().gbo = new C42236g(i, i2, new C97502());
        AppMethodBeat.m2505o(116740);
    }

    @C46608f
    public int getMaxAmplitudeRateMM() {
        AppMethodBeat.m2504i(116741);
        if (SceneVoiceInputAddrProxy.getInstance().gbo != null) {
            int maxAmplitudeRate = SceneVoiceInputAddrProxy.getInstance().gbo.getMaxAmplitudeRate();
            AppMethodBeat.m2505o(116741);
            return maxAmplitudeRate;
        }
        AppMethodBeat.m2505o(116741);
        return 0;
    }

    @C40602e
    public void onResCli(String[] strArr, List<String> list) {
        AppMethodBeat.m2504i(138330);
        if (SceneVoiceInputAddrProxy.getInstance().gbp != null) {
            SceneVoiceInputAddrProxy.getInstance().gbp.mo21116b(strArr, list);
        }
        AppMethodBeat.m2505o(138330);
    }

    @C40602e
    public void onErrorCli(int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(116743);
        if (SceneVoiceInputAddrProxy.getInstance().gbp != null) {
            SceneVoiceInputAddrProxy.getInstance().gbp.mo21117c(i, i2, i3, j);
        }
        AppMethodBeat.m2505o(116743);
    }

    @C40602e
    public void onRecordFinCli() {
        AppMethodBeat.m2504i(116744);
        if (SceneVoiceInputAddrProxy.getInstance().gbp != null) {
            SceneVoiceInputAddrProxy.getInstance().gbp.ams();
        }
        AppMethodBeat.m2505o(116744);
    }

    @C40602e
    public void onRecognizeFinishCli() {
        AppMethodBeat.m2504i(116745);
        if (SceneVoiceInputAddrProxy.getInstance().gbp != null) {
            SceneVoiceInputAddrProxy.getInstance().gbp.amw();
        }
        AppMethodBeat.m2505o(116745);
    }
}
