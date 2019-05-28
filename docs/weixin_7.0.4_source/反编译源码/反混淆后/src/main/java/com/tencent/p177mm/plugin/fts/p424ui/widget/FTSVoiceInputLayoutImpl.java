package com.tencent.p177mm.plugin.fts.p424ui.widget;

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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.plugin.fts.p424ui.widget.VoiceInputLayout.C28156b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl */
public class FTSVoiceInputLayoutImpl extends VoiceInputLayout {
    private OnLongClickListener aKe = new C313682();
    private View mMU;
    private TextView mMV;
    private C43139b mMW;
    private boolean mMX = false;
    private boolean mMY = false;
    private long mMZ;
    private OnTouchListener mNa = new C313693();

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl$5 */
    class C208965 implements Runnable {
        final /* synthetic */ boolean mNc = true;

        C208965() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62185);
            C43139b b = FTSVoiceInputLayoutImpl.this.mMW;
            C4990ab.m7411d("MicroMsg.FTSVoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", Integer.valueOf(0), Boolean.valueOf(this.mNc));
            if (!this.mNc) {
                b.currentState = 3;
            }
            b.mMC = C43139b.m76698wh(0);
            b.invalidateSelf();
            b.mME = 0;
            AppMethodBeat.m2505o(62185);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl$6 */
    class C208976 implements Runnable {
        C208976() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62186);
            C4990ab.m7411d("MicroMsg.FTSVoiceInputDrawable", "recognizingState %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.mMW.currentState));
            r0.currentState = 4;
            AppMethodBeat.m2505o(62186);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl$7 */
    class C208987 implements Runnable {
        C208987() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62187);
            FTSVoiceInputLayoutImpl.m50695g(FTSVoiceInputLayoutImpl.this);
            FTSVoiceInputLayoutImpl.this.mMW.bBx();
            AppMethodBeat.m2505o(62187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl$a */
    public interface C28152a extends C28156b {
        void bBA();

        void bBB();
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl$4 */
    class C313664 implements Runnable {
        C313664() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62184);
            C43139b b = FTSVoiceInputLayoutImpl.this.mMW;
            C4990ab.m7411d("MicroMsg.FTSVoiceInputDrawable", "disableState %s", Integer.valueOf(b.currentState));
            b.currentState = 5;
            b.invalidateSelf();
            AppMethodBeat.m2505o(62184);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl$1 */
    class C313671 implements Runnable {
        C313671() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62181);
            FTSVoiceInputLayoutImpl.this.mMV.setVisibility(0);
            AppMethodBeat.m2505o(62181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl$2 */
    class C313682 implements OnLongClickListener {
        C313682() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(62182);
            C4990ab.m7411d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState));
            FTSVoiceInputLayoutImpl.this.mMX = true;
            C43139b b = FTSVoiceInputLayoutImpl.this.mMW;
            C4990ab.m7411d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", Integer.valueOf(b.currentState));
            b.currentState = 7;
            b.invalidateSelf();
            AppMethodBeat.m2505o(62182);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl$3 */
    class C313693 implements OnTouchListener {
        C313693() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(62183);
            switch (motionEvent.getAction()) {
                case 0:
                    if (!C5023at.isConnected(FTSVoiceInputLayoutImpl.this.getContext())) {
                        FTSVoiceInputLayoutImpl.this.mMY = true;
                        FTSVoiceInputLayoutImpl.this.mNf.mo36218wi(12);
                        break;
                    }
                    FTSVoiceInputLayoutImpl.this.mMY = false;
                    FTSVoiceInputLayoutImpl.this.mMX = false;
                    FTSVoiceInputLayoutImpl.this.mMZ = C5046bo.m7588yz();
                    ((C28152a) FTSVoiceInputLayoutImpl.this.mNf).bBB();
                    C4990ab.m7411d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.this.mMZ));
                    C43139b b = FTSVoiceInputLayoutImpl.this.mMW;
                    C4990ab.m7411d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", Integer.valueOf(b.currentState));
                    b.currentState = 6;
                    b.invalidateSelf();
                    FTSVoiceInputLayoutImpl.this.mo51309B(false, false);
                    FTSVoiceInputLayoutImpl.m50692d(FTSVoiceInputLayoutImpl.this);
                    break;
                case 1:
                    if (!FTSVoiceInputLayoutImpl.this.mMY) {
                        C4990ab.m7411d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(FTSVoiceInputLayoutImpl.this.mMX));
                        if (FTSVoiceInputLayoutImpl.this.mMX) {
                            FTSVoiceInputLayoutImpl.this.mo51309B(true, false);
                            FTSVoiceInputLayoutImpl.this.mMX = false;
                            FTSVoiceInputLayoutImpl.this.mMZ = 0;
                        } else {
                            FTSVoiceInputLayoutImpl.this.mo51309B(false, true);
                        }
                        FTSVoiceInputLayoutImpl.m50695g(FTSVoiceInputLayoutImpl.this);
                        ((C28152a) FTSVoiceInputLayoutImpl.this.mNf).bBA();
                        break;
                    }
                    FTSVoiceInputLayoutImpl.this.mMY = false;
                    break;
            }
            AppMethodBeat.m2505o(62183);
            return false;
        }
    }

    public FTSVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62189);
        init(context);
        AppMethodBeat.m2505o(62189);
    }

    public FTSVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(62190);
        init(context);
        AppMethodBeat.m2505o(62190);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(62191);
        View inflate = FTSVoiceInputLayoutImpl.inflate(context, 2130969640, this);
        this.mMU = inflate.findViewById(2131824276);
        this.mMU.setLayerType(1, null);
        this.mMW = new C43139b(context);
        this.mMU.setBackground(this.mMW);
        this.mMU.setEnabled(true);
        this.mMU.setOnTouchListener(this.mNa);
        this.mMU.setOnLongClickListener(this.aKe);
        this.mMV = (TextView) inflate.findViewById(2131824277);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.m2505o(62191);
            return;
        }
        if (!FTSVoiceInputLayoutImpl.bBL()) {
            bBJ();
        }
        AppMethodBeat.m2505o(62191);
    }

    public void setFTSVoiceDetectListener(C28152a c28152a) {
        AppMethodBeat.m2504i(62192);
        super.setVoiceDetectListener(c28152a);
        AppMethodBeat.m2505o(62192);
    }

    /* renamed from: B */
    public final void mo51309B(boolean z, boolean z2) {
        AppMethodBeat.m2504i(62193);
        C4990ab.m7411d("MicroMsg.FTSVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (!z && !z2) {
                bBO();
                AppMethodBeat.m2505o(62193);
                return;
            } else if (z && !z2) {
                this.mMW.bBx();
                AppMethodBeat.m2505o(62193);
                return;
            }
        } else if (this.currentState == 2) {
            if (z2) {
                this.mMW.bBx();
                amA();
                if (this.mMQ != null) {
                    this.mMQ.bBI();
                    AppMethodBeat.m2505o(62193);
                    return;
                }
            }
            bBP();
            AppMethodBeat.m2505o(62193);
            return;
        } else if (!z && !z2) {
            amA();
            AppMethodBeat.m2505o(62193);
            return;
        } else if (z && !z2) {
            this.mMW.bBx();
        }
        AppMethodBeat.m2505o(62193);
    }

    private void bBJ() {
        AppMethodBeat.m2504i(62194);
        FTSVoiceInputLayoutImpl.runOnUiThread(new C313664());
        bBR();
        AppMethodBeat.m2505o(62194);
    }

    private static boolean bBK() {
        AppMethodBeat.m2504i(62195);
        int acS = C1720g.m3540Rg().acS();
        if (acS == 4 || acS == 6) {
            AppMethodBeat.m2505o(62195);
            return true;
        }
        AppMethodBeat.m2505o(62195);
        return false;
    }

    private static boolean bBL() {
        AppMethodBeat.m2504i(62196);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            boolean bBK = FTSVoiceInputLayoutImpl.bBK();
            AppMethodBeat.m2505o(62196);
            return bBK;
        }
        Object obj;
        if (C5023at.isConnected(C4996ah.getContext())) {
            obj = 6;
        } else {
            obj = null;
        }
        if (obj == 6) {
            AppMethodBeat.m2505o(62196);
            return true;
        }
        AppMethodBeat.m2505o(62196);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bBM() {
        AppMethodBeat.m2504i(62197);
        FTSVoiceInputLayoutImpl.runOnUiThread(new C208965());
        AppMethodBeat.m2505o(62197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bBN() {
        AppMethodBeat.m2504i(62198);
        FTSVoiceInputLayoutImpl.runOnUiThread(new C208976());
        AppMethodBeat.m2505o(62198);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onReset() {
        AppMethodBeat.m2504i(62199);
        FTSVoiceInputLayoutImpl.runOnUiThread(new C208987());
        AppMethodBeat.m2505o(62199);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: wj */
    public final void mo46067wj(final int i) {
        AppMethodBeat.m2504i(62200);
        FTSVoiceInputLayoutImpl.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(62188);
                C43139b b = FTSVoiceInputLayoutImpl.this.mMW;
                int i = i;
                C4990ab.m7411d("MicroMsg.FTSVoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", Integer.valueOf(i));
                b.mMC = C43139b.m76698wh(i);
                b.invalidateSelf();
                b.mME = i;
                AppMethodBeat.m2505o(62188);
            }
        });
        AppMethodBeat.m2505o(62200);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(62201);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            C5004al.m7441d(runnable);
            AppMethodBeat.m2505o(62201);
            return;
        }
        runnable.run();
        AppMethodBeat.m2505o(62201);
    }

    /* renamed from: d */
    static /* synthetic */ void m50692d(FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl) {
        AppMethodBeat.m2504i(62202);
        fTSVoiceInputLayoutImpl.mMV.setVisibility(8);
        AppMethodBeat.m2505o(62202);
    }

    /* renamed from: g */
    static /* synthetic */ void m50695g(FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl) {
        AppMethodBeat.m2504i(62203);
        C5004al.m7442n(new C313671(), 100);
        AppMethodBeat.m2505o(62203);
    }
}
