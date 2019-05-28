package com.tencent.p177mm.plugin.fts.p424ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoiceaddr.C18725b;
import com.tencent.p177mm.modelvoiceaddr.C42236g;
import com.tencent.p177mm.modelvoiceaddr.C42236g.C32852b;
import com.tencent.p177mm.modelvoiceaddr.SceneVoiceInputAddrProxy;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout */
public abstract class VoiceInputLayout extends LinearLayout {
    protected int currentState = 1;
    public final C7564ap gci = new C7564ap(new C281544(), true);
    public C7306ak ilv = new C208991();
    protected C28155a mMQ;
    protected C28156b mNf = null;
    private C18725b mNg;
    protected boolean mNh = false;
    private int mNi = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private int mNj = Downloads.MIN_WAIT_FOR_NETWORK;
    public C7306ak mNk = new C209003();

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout$1 */
    class C208991 extends C7306ak {
        C208991() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(62207);
            if (message.what != 0) {
                if (message.what == 1) {
                    C4990ab.m7421w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", Integer.valueOf(VoiceInputLayout.this.currentState));
                } else {
                    AppMethodBeat.m2505o(62207);
                    return;
                }
            }
            C4990ab.m7411d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", Integer.valueOf(VoiceInputLayout.this.currentState));
            if (VoiceInputLayout.this.currentState != 3) {
                AppMethodBeat.m2505o(62207);
                return;
            }
            VoiceInputLayout.this.ilv.removeMessages(0);
            VoiceInputLayout.this.ilv.removeMessages(1);
            if (VoiceInputLayout.this.mNg != null) {
                VoiceInputLayout.this.mNg.cancel(true);
            }
            VoiceInputLayout.this.reset(true);
            AppMethodBeat.m2505o(62207);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout$3 */
    class C209003 extends C7306ak {
        C209003() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(62212);
            switch (message.what) {
                case 0:
                    VoiceInputLayout.this.bBQ();
                    AppMethodBeat.m2505o(62212);
                    return;
                case 1:
                    Bundle data = message.getData();
                    VoiceInputLayout.this.mo46053V(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                    break;
            }
            AppMethodBeat.m2505o(62212);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout$2 */
    class C281532 implements C32852b {
        C281532() {
        }

        public final void ams() {
            AppMethodBeat.m2504i(62208);
            C4990ab.m7411d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", Integer.valueOf(VoiceInputLayout.this.currentState));
            if (VoiceInputLayout.this.gci != null) {
                VoiceInputLayout.this.gci.stopTimer();
            }
            VoiceInputLayout.this.mNk.sendEmptyMessage(0);
            AppMethodBeat.m2505o(62208);
        }

        public final void amw() {
            AppMethodBeat.m2504i(62209);
            C4990ab.m7410d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.this.ilv.removeMessages(0);
            VoiceInputLayout.this.ilv.removeMessages(1);
            VoiceInputLayout.this.mNf.bBF();
            VoiceInputLayout.this.reset(false);
            AppMethodBeat.m2505o(62209);
        }

        /* renamed from: b */
        public final void mo21116b(String[] strArr, List<String> list) {
            AppMethodBeat.m2504i(138303);
            VoiceInputLayout.this.mNf.mo36217c(strArr, list);
            VoiceInputLayout.this.ilv.removeMessages(0);
            VoiceInputLayout.this.ilv.sendEmptyMessageDelayed(0, (long) VoiceInputLayout.this.mNi);
            AppMethodBeat.m2505o(138303);
        }

        /* renamed from: c */
        public final void mo21117c(int i, int i2, int i3, long j) {
            AppMethodBeat.m2504i(62211);
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
            AppMethodBeat.m2505o(62211);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout$4 */
    class C281544 implements C5015a {
        C281544() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(62213);
            if (VoiceInputLayout.this.mNg == null) {
                AppMethodBeat.m2505o(62213);
            } else {
                int maxAmplitudeRate = VoiceInputLayout.this.mNg.getMaxAmplitudeRate();
                if (VoiceInputLayout.this.currentState == 2) {
                    VoiceInputLayout.this.mo46067wj(maxAmplitudeRate);
                }
                AppMethodBeat.m2505o(62213);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout$a */
    public interface C28155a {
        void bBI();
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout$b */
    public interface C28156b {
        void bBC();

        void bBD();

        void bBE();

        void bBF();

        void bBz();

        /* renamed from: c */
        void mo36217c(String[] strArr, List<String> list);

        /* renamed from: wi */
        void mo36218wi(int i);
    }

    public abstract void bBM();

    public abstract void bBN();

    public abstract void onReset();

    /* renamed from: wj */
    public abstract void mo46067wj(int i);

    public void setLongClickLisnter(C28155a c28155a) {
        this.mMQ = c28155a;
    }

    public void setVoiceDetectListener(C28156b c28156b) {
        this.mNf = c28156b;
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
                if (this.mNf != null) {
                    this.mNf.bBz();
                }
                this.gci.mo16770ae(50, 50);
                bBM();
                if (C4996ah.bqo()) {
                    this.mNg = new C42236g();
                } else {
                    this.mNg = SceneVoiceInputAddrProxy.getInstance();
                }
                this.mNg.init(C42236g.gbc, 8, new C281532());
                this.mNg.start();
            }
        } else if (getContext() instanceof Activity) {
            C35805b.m58709b((Activity) getContext(), "android.permission.RECORD_AUDIO", 80);
        }
    }

    public final void amA() {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1) {
            this.currentState = 1;
            if (this.mNf != null) {
                this.mNf.bBD();
            }
            if (this.mNg != null) {
                this.mNg.cancel(true);
            }
            onReset();
        }
    }

    public final void bBP() {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1 && this.currentState == 2) {
            this.currentState = 3;
            if (this.mNf != null) {
                this.mNf.bBC();
            }
            if (this.gci != null) {
                this.gci.stopTimer();
            }
            this.ilv.removeMessages(0);
            this.ilv.sendEmptyMessageDelayed(0, (long) this.mNi);
            this.ilv.sendEmptyMessageDelayed(1, (long) this.mNj);
            bBN();
            if (this.mNg != null) {
                this.mNg.stop(true);
            }
        }
    }

    public final void bBQ() {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", Integer.valueOf(this.currentState));
        if (this.currentState == 2) {
            this.currentState = 3;
            this.ilv.removeMessages(0);
            this.ilv.sendEmptyMessageDelayed(0, (long) this.mNi);
            this.ilv.sendEmptyMessageDelayed(1, (long) this.mNj);
            bBN();
        }
    }

    public final void bBR() {
        mo46053V(12, -1, -1);
    }

    /* renamed from: V */
    public final void mo46053V(int i, int i2, int i3) {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.currentState = 1;
        onReset();
        if (this.mNf != null) {
            this.mNf.mo36218wi(i);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        C4990ab.m7411d("MicroMsg.VoiceInputLayout", "reset currentState %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1) {
            this.currentState = 1;
            onReset();
            if (z && this.mNf != null) {
                this.mNf.bBE();
            }
        }
    }

    public int getCurrentState() {
        return this.currentState;
    }
}
