package com.tencent.mm.pluginsdk.ui.websearch;

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
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl extends VoiceInputLayout {
    private OnLongClickListener aKe = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(28221);
            ab.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState));
            WebSearchVoiceInputLayoutImpl.this.mMX = true;
            WebSearchVoiceInputLayoutImpl.this.vju.djl();
            AppMethodBeat.o(28221);
            return true;
        }
    };
    private View mMU;
    private boolean mMX = false;
    private long mMZ;
    private OnTouchListener mNa = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(28222);
            switch (motionEvent.getAction()) {
                case 0:
                    WebSearchVoiceInputLayoutImpl.this.mMX = false;
                    WebSearchVoiceInputLayoutImpl.this.mMZ = bo.yz();
                    ab.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState), Long.valueOf(WebSearchVoiceInputLayoutImpl.this.mMZ));
                    WebSearchVoiceInputLayoutImpl.this.vju.djm();
                    WebSearchVoiceInputLayoutImpl.this.B(false, false);
                    break;
                case 1:
                    ab.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.this.mMX));
                    if (!WebSearchVoiceInputLayoutImpl.this.mMX) {
                        WebSearchVoiceInputLayoutImpl.this.B(false, true);
                        break;
                    }
                    WebSearchVoiceInputLayoutImpl.this.B(true, false);
                    WebSearchVoiceInputLayoutImpl.this.mMX = false;
                    WebSearchVoiceInputLayoutImpl.this.mMZ = 0;
                    break;
            }
            AppMethodBeat.o(28222);
            return false;
        }
    };
    private k vju;

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(28228);
        init(context);
        AppMethodBeat.o(28228);
    }

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(28229);
        init(context);
        AppMethodBeat.o(28229);
    }

    private void init(Context context) {
        AppMethodBeat.i(28230);
        this.mMU = inflate(context, R.layout.b1x, this).findViewById(R.id.bzv);
        this.mMU.setLayerType(1, null);
        this.vju = new k(context);
        this.mMU.setBackground(this.vju);
        this.mMU.setEnabled(true);
        this.mMU.setOnTouchListener(this.mNa);
        this.mMU.setOnLongClickListener(this.aKe);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.o(28230);
            return;
        }
        if (!bBL()) {
            bBJ();
        }
        AppMethodBeat.o(28230);
    }

    public final void B(boolean z, boolean z2) {
        AppMethodBeat.i(28231);
        ab.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (z || z2) {
                if (z && !z2) {
                    this.vju.bBx();
                    AppMethodBeat.o(28231);
                    return;
                }
            } else if (bBL()) {
                bBO();
                AppMethodBeat.o(28231);
                return;
            } else {
                bBJ();
                AppMethodBeat.o(28231);
                return;
            }
        } else if (this.currentState == 2) {
            if (z2) {
                this.vju.bBx();
                amA();
                if (this.vjs != null) {
                    this.vjs.bBI();
                    AppMethodBeat.o(28231);
                    return;
                }
            }
            bBP();
            AppMethodBeat.o(28231);
            return;
        } else if (!z && !z2) {
            amA();
            AppMethodBeat.o(28231);
            return;
        } else if (z && !z2) {
            this.vju.bBx();
        }
        AppMethodBeat.o(28231);
    }

    private void bBJ() {
        AppMethodBeat.i(28232);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28223);
                WebSearchVoiceInputLayoutImpl.this.vju.djo();
                AppMethodBeat.o(28223);
            }
        });
        bBR();
        AppMethodBeat.o(28232);
    }

    private static boolean bBL() {
        AppMethodBeat.i(28233);
        int acS = aw.Rg().acS();
        if (acS == 4 || acS == 6) {
            AppMethodBeat.o(28233);
            return true;
        }
        AppMethodBeat.o(28233);
        return false;
    }

    public final void bBM() {
        AppMethodBeat.i(28234);
        runOnUiThread(new Runnable() {
            final /* synthetic */ boolean mNc = true;

            public final void run() {
                AppMethodBeat.i(28224);
                WebSearchVoiceInputLayoutImpl.this.vju.oy(this.mNc);
                AppMethodBeat.o(28224);
            }
        });
        AppMethodBeat.o(28234);
    }

    public final void dX(boolean z) {
        AppMethodBeat.i(28235);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28225);
                WebSearchVoiceInputLayoutImpl.this.vju.djn();
                AppMethodBeat.o(28225);
            }
        });
        AppMethodBeat.o(28235);
    }

    public final void onReset() {
        AppMethodBeat.i(28236);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28226);
                WebSearchVoiceInputLayoutImpl.this.vju.bBx();
                AppMethodBeat.o(28226);
            }
        });
        AppMethodBeat.o(28236);
    }

    public final void wj(final int i) {
        AppMethodBeat.i(28237);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28227);
                WebSearchVoiceInputLayoutImpl.this.vju.KO(i);
                AppMethodBeat.o(28227);
            }
        });
        AppMethodBeat.o(28237);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(28238);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            al.d(runnable);
            AppMethodBeat.o(28238);
            return;
        }
        runnable.run();
        AppMethodBeat.o(28238);
    }
}
