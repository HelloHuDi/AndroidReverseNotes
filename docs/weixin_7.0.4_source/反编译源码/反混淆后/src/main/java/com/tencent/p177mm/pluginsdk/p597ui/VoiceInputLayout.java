package com.tencent.p177mm.pluginsdk.p597ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoiceaddr.C42236g;
import com.tencent.p177mm.modelvoiceaddr.C42236g.C32852b;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayout */
public abstract class VoiceInputLayout extends LinearLayout {
    public int currentState = 1;
    private int gaD = C42236g.gbc;
    private final C7564ap gci = new C7564ap(new C358284(), true);
    private C7306ak ilv = new C300981();
    protected boolean mNh = false;
    private int mNi = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private int mNj = Downloads.MIN_WAIT_FOR_NETWORK;
    private C7306ak mNk = new C358253();
    private C35827b vjq = null;
    private C42236g vjr;
    protected C35826a vjs;

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayout$2 */
    class C149062 implements C32852b {
        C149062() {
        }

        public final void ams() {
            AppMethodBeat.m2504i(27580);
            C4990ab.m7411d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", Integer.valueOf(VoiceInputLayout.this.currentState));
            if (VoiceInputLayout.this.gci != null) {
                VoiceInputLayout.this.gci.stopTimer();
            }
            VoiceInputLayout.this.mNk.sendEmptyMessage(0);
            AppMethodBeat.m2505o(27580);
        }

        public final void amw() {
            AppMethodBeat.m2504i(27581);
            C4990ab.m7410d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.this.ilv.removeMessages(0);
            VoiceInputLayout.this.ilv.removeMessages(1);
            VoiceInputLayout.this.vjq.bBF();
            VoiceInputLayout.this.reset(false);
            AppMethodBeat.m2505o(27581);
        }

        /* renamed from: b */
        public final void mo21116b(String[] strArr, List<String> list) {
            AppMethodBeat.m2504i(138173);
            VoiceInputLayout.this.vjq.mo39028c(strArr, list);
            VoiceInputLayout.this.ilv.removeMessages(0);
            VoiceInputLayout.this.ilv.sendEmptyMessageDelayed(0, (long) VoiceInputLayout.this.mNi);
            AppMethodBeat.m2505o(138173);
        }

        /* renamed from: c */
        public final void mo21117c(int i, int i2, int i3, long j) {
            AppMethodBeat.m2504i(27583);
            VoiceInputLayout.this.ilv.removeMessages(0);
            VoiceInputLayout.this.ilv.removeMessages(1);
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putInt("localCode", i);
            bundle.putInt("errType", i2);
            bundle.putInt("errCode", i3);
            message.setData(bundle);
            message.what = 1;
            VoiceInputLayout.this.mNk.sendMessage(message);
            AppMethodBeat.m2505o(27583);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayout$1 */
    class C300981 extends C7306ak {
        C300981() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27579);
            if (message.what != 0) {
                if (message.what == 1) {
                    C4990ab.m7421w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", Integer.valueOf(VoiceInputLayout.this.currentState));
                } else {
                    AppMethodBeat.m2505o(27579);
                    return;
                }
            }
            C4990ab.m7411d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", Integer.valueOf(VoiceInputLayout.this.currentState));
            if (VoiceInputLayout.this.currentState != 3) {
                AppMethodBeat.m2505o(27579);
                return;
            }
            VoiceInputLayout.this.ilv.removeMessages(0);
            VoiceInputLayout.this.ilv.removeMessages(1);
            if (VoiceInputLayout.this.vjr != null) {
                VoiceInputLayout.this.vjr.cancel(true);
            }
            VoiceInputLayout.this.reset(true);
            AppMethodBeat.m2505o(27579);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayout$3 */
    class C358253 extends C7306ak {
        C358253() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27584);
            switch (message.what) {
                case 0:
                    VoiceInputLayout.this.bBQ();
                    AppMethodBeat.m2505o(27584);
                    return;
                case 1:
                    Bundle data = message.getData();
                    VoiceInputLayout.this.mo56611V(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                    break;
            }
            AppMethodBeat.m2505o(27584);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayout$a */
    public interface C35826a {
        void bBI();
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayout$b */
    public interface C35827b {
        /* renamed from: at */
        void mo39022at(int i, int i2, int i3);

        void bBC();

        void bBD();

        void bBE();

        void bBF();

        void bBz();

        /* renamed from: c */
        void mo39028c(String[] strArr, List<String> list);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayout$4 */
    class C358284 implements C5015a {
        C358284() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(27585);
            if (VoiceInputLayout.this.vjr == null) {
                AppMethodBeat.m2505o(27585);
            } else {
                int maxAmplitudeRate = VoiceInputLayout.this.vjr.getMaxAmplitudeRate();
                if (VoiceInputLayout.this.currentState == 2) {
                    VoiceInputLayout.this.mo39099wj(maxAmplitudeRate);
                }
                AppMethodBeat.m2505o(27585);
            }
            return true;
        }
    }

    public abstract void bBM();

    /* renamed from: dX */
    public abstract void mo39097dX(boolean z);

    public abstract void onReset();

    /* renamed from: wj */
    public abstract void mo39099wj(int i);

    public void setLongClickLisnter(C35826a c35826a) {
        this.vjs = c35826a;
    }

    public void setVoiceDetectListener(C35827b c35827b) {
        this.vjq = c35827b;
    }

    public void setFromFullScreen(boolean z) {
        this.mNh = z;
    }

    @TargetApi(11)
    public VoiceInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VoiceInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void bBO() {
        if (C35973a.m59179bJ(getContext()) || C35973a.m59177bH(getContext())) {
            C4990ab.m7410d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
            onReset();
            return;
        }
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", Boolean.valueOf(C35805b.m58714o(getContext(), "android.permission.RECORD_AUDIO")));
        if (C35805b.m58714o(getContext(), "android.permission.RECORD_AUDIO")) {
            C4990ab.m7411d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", Integer.valueOf(this.currentState));
            if (this.currentState == 1) {
                this.currentState = 2;
                if (this.vjq != null) {
                    this.vjq.bBz();
                }
                this.gci.mo16770ae(50, 50);
                bBM();
                this.vjr = new C42236g(this.gaD, 0, new C149062());
                this.vjr.start();
            }
        } else if (getContext() instanceof Activity) {
            C35805b.m58709b((Activity) getContext(), "android.permission.RECORD_AUDIO", 80);
        }
    }

    public final void amA() {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1) {
            this.currentState = 1;
            if (this.vjq != null) {
                this.vjq.bBD();
            }
            if (this.vjr != null) {
                this.vjr.cancel(true);
            }
            onReset();
        }
    }

    public final void bBP() {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1 && this.currentState == 2) {
            this.currentState = 3;
            if (this.vjq != null) {
                this.vjq.bBC();
            }
            if (this.gci != null) {
                this.gci.stopTimer();
            }
            this.ilv.removeMessages(0);
            this.ilv.sendEmptyMessageDelayed(0, (long) this.mNi);
            this.ilv.sendEmptyMessageDelayed(1, (long) this.mNj);
            mo39097dX(true);
            if (this.vjr != null) {
                this.vjr.stop(true);
            }
        }
    }

    public final void djt() {
        if (this.ilv != null) {
            this.ilv.removeCallbacksAndMessages(null);
        }
        if (this.mNk != null) {
            this.mNk.removeCallbacksAndMessages(null);
        }
        if (this.gci != null) {
            this.gci.stopTimer();
        }
    }

    public final void bBQ() {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", Integer.valueOf(this.currentState));
        if (this.currentState == 2) {
            this.currentState = 3;
            this.ilv.removeMessages(0);
            this.ilv.sendEmptyMessageDelayed(0, (long) this.mNi);
            this.ilv.sendEmptyMessageDelayed(1, (long) this.mNj);
            mo39097dX(false);
        }
    }

    public final void bBR() {
        mo56611V(12, -1, -1);
    }

    /* renamed from: V */
    public final void mo56611V(int i, int i2, int i3) {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.currentState = 1;
        onReset();
        if (this.vjq != null) {
            this.vjq.mo39022at(i, i2, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "reset currentState %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1) {
            this.currentState = 1;
            onReset();
            if (z && this.vjq != null) {
                this.vjq.bBE();
            }
        }
    }

    public int getCurrentState() {
        return this.currentState;
    }

    public void setLangType(int i) {
        this.gaD = i;
    }
}
