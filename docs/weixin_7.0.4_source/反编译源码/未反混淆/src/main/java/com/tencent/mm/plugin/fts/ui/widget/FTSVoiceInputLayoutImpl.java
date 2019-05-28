package com.tencent.mm.plugin.fts.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

@TargetApi(16)
public class FTSVoiceInputLayoutImpl extends VoiceInputLayout {
    private OnLongClickListener aKe = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(62182);
            ab.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState));
            FTSVoiceInputLayoutImpl.this.mMX = true;
            b b = FTSVoiceInputLayoutImpl.this.mMW;
            ab.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", Integer.valueOf(b.currentState));
            b.currentState = 7;
            b.invalidateSelf();
            AppMethodBeat.o(62182);
            return true;
        }
    };
    private View mMU;
    private TextView mMV;
    private b mMW;
    private boolean mMX = false;
    private boolean mMY = false;
    private long mMZ;
    private OnTouchListener mNa = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(62183);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!at.isConnected(FTSVoiceInputLayoutImpl.this.getContext())) {
                        FTSVoiceInputLayoutImpl.this.mMY = true;
                        FTSVoiceInputLayoutImpl.this.mNf.wi(12);
                        break;
                    }
                    FTSVoiceInputLayoutImpl.this.mMY = false;
                    FTSVoiceInputLayoutImpl.this.mMX = false;
                    FTSVoiceInputLayoutImpl.this.mMZ = bo.yz();
                    ((a) FTSVoiceInputLayoutImpl.this.mNf).bBB();
                    ab.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.this.mMZ));
                    b b = FTSVoiceInputLayoutImpl.this.mMW;
                    ab.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", Integer.valueOf(b.currentState));
                    b.currentState = 6;
                    b.invalidateSelf();
                    FTSVoiceInputLayoutImpl.this.B(false, false);
                    FTSVoiceInputLayoutImpl.d(FTSVoiceInputLayoutImpl.this);
                    break;
                case 1:
                    if (!FTSVoiceInputLayoutImpl.this.mMY) {
                        ab.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(FTSVoiceInputLayoutImpl.this.mMX));
                        if (FTSVoiceInputLayoutImpl.this.mMX) {
                            FTSVoiceInputLayoutImpl.this.B(true, false);
                            FTSVoiceInputLayoutImpl.this.mMX = false;
                            FTSVoiceInputLayoutImpl.this.mMZ = 0;
                        } else {
                            FTSVoiceInputLayoutImpl.this.B(false, true);
                        }
                        FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
                        ((a) FTSVoiceInputLayoutImpl.this.mNf).bBA();
                        break;
                    }
                    FTSVoiceInputLayoutImpl.this.mMY = false;
                    break;
            }
            AppMethodBeat.o(62183);
            return false;
        }
    };

    public interface a extends b {
        void bBA();

        void bBB();
    }

    public FTSVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(62189);
        init(context);
        AppMethodBeat.o(62189);
    }

    public FTSVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62190);
        init(context);
        AppMethodBeat.o(62190);
    }

    private void init(Context context) {
        AppMethodBeat.i(62191);
        View inflate = inflate(context, R.layout.a1y, this);
        this.mMU = inflate.findViewById(R.id.bzv);
        this.mMU.setLayerType(1, null);
        this.mMW = new b(context);
        this.mMU.setBackground(this.mMW);
        this.mMU.setEnabled(true);
        this.mMU.setOnTouchListener(this.mNa);
        this.mMU.setOnLongClickListener(this.aKe);
        this.mMV = (TextView) inflate.findViewById(R.id.bzw);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.o(62191);
            return;
        }
        if (!bBL()) {
            bBJ();
        }
        AppMethodBeat.o(62191);
    }

    public void setFTSVoiceDetectListener(a aVar) {
        AppMethodBeat.i(62192);
        super.setVoiceDetectListener(aVar);
        AppMethodBeat.o(62192);
    }

    public final void B(boolean z, boolean z2) {
        AppMethodBeat.i(62193);
        ab.d("MicroMsg.FTSVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (!z && !z2) {
                bBO();
                AppMethodBeat.o(62193);
                return;
            } else if (z && !z2) {
                this.mMW.bBx();
                AppMethodBeat.o(62193);
                return;
            }
        } else if (this.currentState == 2) {
            if (z2) {
                this.mMW.bBx();
                amA();
                if (this.mMQ != null) {
                    this.mMQ.bBI();
                    AppMethodBeat.o(62193);
                    return;
                }
            }
            bBP();
            AppMethodBeat.o(62193);
            return;
        } else if (!z && !z2) {
            amA();
            AppMethodBeat.o(62193);
            return;
        } else if (z && !z2) {
            this.mMW.bBx();
        }
        AppMethodBeat.o(62193);
    }

    private void bBJ() {
        AppMethodBeat.i(62194);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(62184);
                b b = FTSVoiceInputLayoutImpl.this.mMW;
                ab.d("MicroMsg.FTSVoiceInputDrawable", "disableState %s", Integer.valueOf(b.currentState));
                b.currentState = 5;
                b.invalidateSelf();
                AppMethodBeat.o(62184);
            }
        });
        bBR();
        AppMethodBeat.o(62194);
    }

    private static boolean bBK() {
        AppMethodBeat.i(62195);
        int acS = g.Rg().acS();
        if (acS == 4 || acS == 6) {
            AppMethodBeat.o(62195);
            return true;
        }
        AppMethodBeat.o(62195);
        return false;
    }

    private static boolean bBL() {
        AppMethodBeat.i(62196);
        if (((h) g.RM().Rn()).SG()) {
            boolean bBK = bBK();
            AppMethodBeat.o(62196);
            return bBK;
        }
        Object obj;
        if (at.isConnected(ah.getContext())) {
            obj = 6;
        } else {
            obj = null;
        }
        if (obj == 6) {
            AppMethodBeat.o(62196);
            return true;
        }
        AppMethodBeat.o(62196);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bBM() {
        AppMethodBeat.i(62197);
        runOnUiThread(new Runnable() {
            final /* synthetic */ boolean mNc = true;

            public final void run() {
                AppMethodBeat.i(62185);
                b b = FTSVoiceInputLayoutImpl.this.mMW;
                ab.d("MicroMsg.FTSVoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", Integer.valueOf(0), Boolean.valueOf(this.mNc));
                if (!this.mNc) {
                    b.currentState = 3;
                }
                b.mMC = b.wh(0);
                b.invalidateSelf();
                b.mME = 0;
                AppMethodBeat.o(62185);
            }
        });
        AppMethodBeat.o(62197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bBN() {
        AppMethodBeat.i(62198);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(62186);
                ab.d("MicroMsg.FTSVoiceInputDrawable", "recognizingState %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.mMW.currentState));
                r0.currentState = 4;
                AppMethodBeat.o(62186);
            }
        });
        AppMethodBeat.o(62198);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onReset() {
        AppMethodBeat.i(62199);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(62187);
                FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
                FTSVoiceInputLayoutImpl.this.mMW.bBx();
                AppMethodBeat.o(62187);
            }
        });
        AppMethodBeat.o(62199);
    }

    /* Access modifiers changed, original: protected|final */
    public final void wj(final int i) {
        AppMethodBeat.i(62200);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(62188);
                b b = FTSVoiceInputLayoutImpl.this.mMW;
                int i = i;
                ab.d("MicroMsg.FTSVoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", Integer.valueOf(i));
                b.mMC = b.wh(i);
                b.invalidateSelf();
                b.mME = i;
                AppMethodBeat.o(62188);
            }
        });
        AppMethodBeat.o(62200);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(62201);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            al.d(runnable);
            AppMethodBeat.o(62201);
            return;
        }
        runnable.run();
        AppMethodBeat.o(62201);
    }

    static /* synthetic */ void d(FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl) {
        AppMethodBeat.i(62202);
        fTSVoiceInputLayoutImpl.mMV.setVisibility(8);
        AppMethodBeat.o(62202);
    }

    static /* synthetic */ void g(FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl) {
        AppMethodBeat.i(62203);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(62181);
                FTSVoiceInputLayoutImpl.this.mMV.setVisibility(0);
                AppMethodBeat.o(62181);
            }
        }, 100);
        AppMethodBeat.o(62203);
    }
}
