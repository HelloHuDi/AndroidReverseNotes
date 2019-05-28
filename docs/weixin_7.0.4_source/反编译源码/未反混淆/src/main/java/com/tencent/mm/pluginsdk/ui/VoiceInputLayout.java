package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

public abstract class VoiceInputLayout extends LinearLayout {
    public int currentState = 1;
    private int gaD = g.gbc;
    private final ap gci = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(27585);
            if (VoiceInputLayout.this.vjr == null) {
                AppMethodBeat.o(27585);
            } else {
                int maxAmplitudeRate = VoiceInputLayout.this.vjr.getMaxAmplitudeRate();
                if (VoiceInputLayout.this.currentState == 2) {
                    VoiceInputLayout.this.wj(maxAmplitudeRate);
                }
                AppMethodBeat.o(27585);
            }
            return true;
        }
    }, true);
    private ak ilv = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(27579);
            if (message.what != 0) {
                if (message.what == 1) {
                    ab.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", Integer.valueOf(VoiceInputLayout.this.currentState));
                } else {
                    AppMethodBeat.o(27579);
                    return;
                }
            }
            ab.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", Integer.valueOf(VoiceInputLayout.this.currentState));
            if (VoiceInputLayout.this.currentState != 3) {
                AppMethodBeat.o(27579);
                return;
            }
            VoiceInputLayout.this.ilv.removeMessages(0);
            VoiceInputLayout.this.ilv.removeMessages(1);
            if (VoiceInputLayout.this.vjr != null) {
                VoiceInputLayout.this.vjr.cancel(true);
            }
            VoiceInputLayout.this.reset(true);
            AppMethodBeat.o(27579);
        }
    };
    protected boolean mNh = false;
    private int mNi = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private int mNj = Downloads.MIN_WAIT_FOR_NETWORK;
    private ak mNk = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(27584);
            switch (message.what) {
                case 0:
                    VoiceInputLayout.this.bBQ();
                    AppMethodBeat.o(27584);
                    return;
                case 1:
                    Bundle data = message.getData();
                    VoiceInputLayout.this.V(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                    break;
            }
            AppMethodBeat.o(27584);
        }
    };
    private b vjq = null;
    private g vjr;
    protected a vjs;

    public interface a {
        void bBI();
    }

    public interface b {
        void at(int i, int i2, int i3);

        void bBC();

        void bBD();

        void bBE();

        void bBF();

        void bBz();

        void c(String[] strArr, List<String> list);
    }

    public abstract void bBM();

    public abstract void dX(boolean z);

    public abstract void onReset();

    public abstract void wj(int i);

    public void setLongClickLisnter(a aVar) {
        this.vjs = aVar;
    }

    public void setVoiceDetectListener(b bVar) {
        this.vjq = bVar;
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
        if (com.tencent.mm.r.a.bJ(getContext()) || com.tencent.mm.r.a.bH(getContext())) {
            ab.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
            onReset();
            return;
        }
        ab.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.o(getContext(), "android.permission.RECORD_AUDIO")));
        if (com.tencent.mm.pluginsdk.permission.b.o(getContext(), "android.permission.RECORD_AUDIO")) {
            ab.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", Integer.valueOf(this.currentState));
            if (this.currentState == 1) {
                this.currentState = 2;
                if (this.vjq != null) {
                    this.vjq.bBz();
                }
                this.gci.ae(50, 50);
                bBM();
                this.vjr = new g(this.gaD, 0, new com.tencent.mm.modelvoiceaddr.g.b() {
                    public final void ams() {
                        AppMethodBeat.i(27580);
                        ab.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", Integer.valueOf(VoiceInputLayout.this.currentState));
                        if (VoiceInputLayout.this.gci != null) {
                            VoiceInputLayout.this.gci.stopTimer();
                        }
                        VoiceInputLayout.this.mNk.sendEmptyMessage(0);
                        AppMethodBeat.o(27580);
                    }

                    public final void amw() {
                        AppMethodBeat.i(27581);
                        ab.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
                        VoiceInputLayout.this.ilv.removeMessages(0);
                        VoiceInputLayout.this.ilv.removeMessages(1);
                        VoiceInputLayout.this.vjq.bBF();
                        VoiceInputLayout.this.reset(false);
                        AppMethodBeat.o(27581);
                    }

                    public final void b(String[] strArr, List<String> list) {
                        AppMethodBeat.i(138173);
                        VoiceInputLayout.this.vjq.c(strArr, list);
                        VoiceInputLayout.this.ilv.removeMessages(0);
                        VoiceInputLayout.this.ilv.sendEmptyMessageDelayed(0, (long) VoiceInputLayout.this.mNi);
                        AppMethodBeat.o(138173);
                    }

                    public final void c(int i, int i2, int i3, long j) {
                        AppMethodBeat.i(27583);
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
                        AppMethodBeat.o(27583);
                    }
                });
                this.vjr.start();
            }
        } else if (getContext() instanceof Activity) {
            com.tencent.mm.pluginsdk.permission.b.b((Activity) getContext(), "android.permission.RECORD_AUDIO", 80);
        }
    }

    public final void amA() {
        ab.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", Integer.valueOf(this.currentState));
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
        ab.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", Integer.valueOf(this.currentState));
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
            dX(true);
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
        ab.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", Integer.valueOf(this.currentState));
        if (this.currentState == 2) {
            this.currentState = 3;
            this.ilv.removeMessages(0);
            this.ilv.sendEmptyMessageDelayed(0, (long) this.mNi);
            this.ilv.sendEmptyMessageDelayed(1, (long) this.mNj);
            dX(false);
        }
    }

    public final void bBR() {
        V(12, -1, -1);
    }

    public final void V(int i, int i2, int i3) {
        ab.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.currentState = 1;
        onReset();
        if (this.vjq != null) {
            this.vjq.at(i, i2, i3);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        ab.d("MicroMsg.VoiceInputLayout", "reset currentState %s", Integer.valueOf(this.currentState));
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
