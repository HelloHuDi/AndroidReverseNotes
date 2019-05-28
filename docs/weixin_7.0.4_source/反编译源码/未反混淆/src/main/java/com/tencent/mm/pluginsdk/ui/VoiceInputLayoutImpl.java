package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@TargetApi(16)
public class VoiceInputLayoutImpl extends VoiceInputLayout {
    private OnLongClickListener aKe = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(27586);
            ab.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState));
            VoiceInputLayoutImpl.this.mMX = true;
            VoiceInputLayoutImpl.this.vju.djl();
            AppMethodBeat.o(27586);
            return true;
        }
    };
    private View mMU;
    private boolean mMX = false;
    private long mMZ;
    private OnTouchListener mNa = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(27587);
            switch (motionEvent.getAction()) {
                case 0:
                    VoiceInputLayoutImpl.this.mMX = false;
                    VoiceInputLayoutImpl.this.mMZ = bo.yz();
                    ab.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.this.mMZ));
                    VoiceInputLayoutImpl.this.vju.djm();
                    VoiceInputLayoutImpl.this.B(false, false);
                    break;
                case 1:
                    ab.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.this.mMX));
                    if (!VoiceInputLayoutImpl.this.mMX) {
                        VoiceInputLayoutImpl.this.B(false, true);
                        break;
                    }
                    VoiceInputLayoutImpl.this.B(true, false);
                    VoiceInputLayoutImpl.this.mMX = false;
                    VoiceInputLayoutImpl.this.mMZ = 0;
                    break;
            }
            AppMethodBeat.o(27587);
            return false;
        }
    };
    private k vju;

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(27593);
        init(context);
        AppMethodBeat.o(27593);
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27594);
        init(context);
        AppMethodBeat.o(27594);
    }

    private void init(Context context) {
        AppMethodBeat.i(27595);
        this.mMU = inflate(context, R.layout.b1x, this).findViewById(R.id.bzv);
        this.mMU.setLayerType(1, null);
        this.vju = new k(context);
        this.mMU.setBackground(this.vju);
        this.mMU.setEnabled(true);
        this.mMU.setOnTouchListener(this.mNa);
        this.mMU.setOnLongClickListener(this.aKe);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.o(27595);
            return;
        }
        if (!bBL()) {
            bBJ();
        }
        AppMethodBeat.o(27595);
    }

    public final void B(boolean z, boolean z2) {
        AppMethodBeat.i(27596);
        ab.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (z || z2) {
                if (z && !z2) {
                    ay(4, this.mMX);
                    ay(this.currentState, this.mMX);
                    this.vju.bBx();
                    AppMethodBeat.o(27596);
                    return;
                }
            } else if (bBL()) {
                bBO();
                AppMethodBeat.o(27596);
                return;
            } else {
                bBJ();
                AppMethodBeat.o(27596);
                return;
            }
        } else if (this.currentState == 2) {
            if (z2) {
                this.vju.bBx();
                amA();
                if (this.vjs != null) {
                    this.vjs.bBI();
                }
                ay(5, this.mMX);
                AppMethodBeat.o(27596);
                return;
            }
            if (z) {
                ay(4, this.mMX);
            }
            ay(this.currentState, this.mMX);
            bBP();
            AppMethodBeat.o(27596);
            return;
        } else if (!z && !z2) {
            ay(this.currentState, this.mMX);
            amA();
            AppMethodBeat.o(27596);
            return;
        } else if (z && !z2) {
            ay(4, this.mMX);
            ay(this.currentState, this.mMX);
            this.vju.bBx();
        }
        AppMethodBeat.o(27596);
    }

    private void bBJ() {
        AppMethodBeat.i(27597);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27588);
                VoiceInputLayoutImpl.this.vju.djo();
                AppMethodBeat.o(27588);
            }
        });
        bBR();
        AppMethodBeat.o(27597);
    }

    private static boolean bBL() {
        AppMethodBeat.i(27598);
        int acS = aw.Rg().acS();
        if (acS == 4 || acS == 6) {
            AppMethodBeat.o(27598);
            return true;
        }
        AppMethodBeat.o(27598);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bBM() {
        AppMethodBeat.i(27599);
        runOnUiThread(new Runnable() {
            final /* synthetic */ boolean mNc = true;

            public final void run() {
                AppMethodBeat.i(27589);
                VoiceInputLayoutImpl.this.vju.oy(this.mNc);
                AppMethodBeat.o(27589);
            }
        });
        AppMethodBeat.o(27599);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dX(boolean z) {
        AppMethodBeat.i(27600);
        if (!z) {
            ay(17, false);
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27590);
                VoiceInputLayoutImpl.this.vju.djn();
                AppMethodBeat.o(27590);
            }
        });
        AppMethodBeat.o(27600);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onReset() {
        AppMethodBeat.i(27601);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27591);
                VoiceInputLayoutImpl.this.vju.bBx();
                AppMethodBeat.o(27591);
            }
        });
        AppMethodBeat.o(27601);
    }

    /* Access modifiers changed, original: protected|final */
    public final void wj(final int i) {
        AppMethodBeat.i(27602);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(27592);
                VoiceInputLayoutImpl.this.vju.KO(i);
                AppMethodBeat.o(27592);
            }
        });
        AppMethodBeat.o(27602);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(27603);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            al.d(runnable);
            AppMethodBeat.o(27603);
            return;
        }
        runnable.run();
        AppMethodBeat.o(27603);
    }

    private void ay(int i, boolean z) {
        AppMethodBeat.i(27604);
        log_13905 log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (!z) {
            voiceInputBehavior.click = i;
        } else if (this.mNh) {
            voiceInputBehavior.fullScreenVoiceLongClick = i;
            if (!(i == 4 || !this.mMX || this.mMZ == 0)) {
                voiceInputBehavior.fullScreenVoiceLongClickTime = bo.az(this.mMZ);
            }
        } else {
            voiceInputBehavior.longClick = i;
            if (!(i == 4 || !this.mMX || this.mMZ == 0)) {
                voiceInputBehavior.longClickTime = bo.az(this.mMZ);
            }
        }
        log_13905.viOp_ = voiceInputBehavior;
        h.pYm.c(13905, log_13905);
        ab.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        AppMethodBeat.o(27604);
    }
}
