package com.tencent.p177mm.pluginsdk.p597ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.p177mm.plugin.report.kvdata.log_13905;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@TargetApi(16)
/* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl */
public class VoiceInputLayoutImpl extends VoiceInputLayout {
    private OnLongClickListener aKe = new C358291();
    private View mMU;
    private boolean mMX = false;
    private long mMZ;
    private OnTouchListener mNa = new C358302();
    private C35876k vju;

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl$6 */
    class C149076 implements Runnable {
        C149076() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27591);
            VoiceInputLayoutImpl.this.vju.bBx();
            AppMethodBeat.m2505o(27591);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl$5 */
    class C300995 implements Runnable {
        C300995() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27590);
            VoiceInputLayoutImpl.this.vju.djn();
            AppMethodBeat.m2505o(27590);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl$1 */
    class C358291 implements OnLongClickListener {
        C358291() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(27586);
            C4990ab.m7411d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState));
            VoiceInputLayoutImpl.this.mMX = true;
            VoiceInputLayoutImpl.this.vju.djl();
            AppMethodBeat.m2505o(27586);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl$2 */
    class C358302 implements OnTouchListener {
        C358302() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(27587);
            switch (motionEvent.getAction()) {
                case 0:
                    VoiceInputLayoutImpl.this.mMX = false;
                    VoiceInputLayoutImpl.this.mMZ = C5046bo.m7588yz();
                    C4990ab.m7411d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.this.mMZ));
                    VoiceInputLayoutImpl.this.vju.djm();
                    VoiceInputLayoutImpl.this.mo69777B(false, false);
                    break;
                case 1:
                    C4990ab.m7411d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.this.mMX));
                    if (!VoiceInputLayoutImpl.this.mMX) {
                        VoiceInputLayoutImpl.this.mo69777B(false, true);
                        break;
                    }
                    VoiceInputLayoutImpl.this.mo69777B(true, false);
                    VoiceInputLayoutImpl.this.mMX = false;
                    VoiceInputLayoutImpl.this.mMZ = 0;
                    break;
            }
            AppMethodBeat.m2505o(27587);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl$4 */
    class C404584 implements Runnable {
        final /* synthetic */ boolean mNc = true;

        C404584() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27589);
            VoiceInputLayoutImpl.this.vju.mo56678oy(this.mNc);
            AppMethodBeat.m2505o(27589);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl$3 */
    class C440763 implements Runnable {
        C440763() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27588);
            VoiceInputLayoutImpl.this.vju.djo();
            AppMethodBeat.m2505o(27588);
        }
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(27593);
        init(context);
        AppMethodBeat.m2505o(27593);
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27594);
        init(context);
        AppMethodBeat.m2505o(27594);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(27595);
        this.mMU = VoiceInputLayoutImpl.inflate(context, 2130971010, this).findViewById(2131824276);
        this.mMU.setLayerType(1, null);
        this.vju = new C35876k(context);
        this.mMU.setBackground(this.vju);
        this.mMU.setEnabled(true);
        this.mMU.setOnTouchListener(this.mNa);
        this.mMU.setOnLongClickListener(this.aKe);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.m2505o(27595);
            return;
        }
        if (!VoiceInputLayoutImpl.bBL()) {
            bBJ();
        }
        AppMethodBeat.m2505o(27595);
    }

    /* renamed from: B */
    public final void mo69777B(boolean z, boolean z2) {
        AppMethodBeat.m2504i(27596);
        C4990ab.m7411d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (z || z2) {
                if (z && !z2) {
                    m79251ay(4, this.mMX);
                    m79251ay(this.currentState, this.mMX);
                    this.vju.bBx();
                    AppMethodBeat.m2505o(27596);
                    return;
                }
            } else if (VoiceInputLayoutImpl.bBL()) {
                bBO();
                AppMethodBeat.m2505o(27596);
                return;
            } else {
                bBJ();
                AppMethodBeat.m2505o(27596);
                return;
            }
        } else if (this.currentState == 2) {
            if (z2) {
                this.vju.bBx();
                amA();
                if (this.vjs != null) {
                    this.vjs.bBI();
                }
                m79251ay(5, this.mMX);
                AppMethodBeat.m2505o(27596);
                return;
            }
            if (z) {
                m79251ay(4, this.mMX);
            }
            m79251ay(this.currentState, this.mMX);
            bBP();
            AppMethodBeat.m2505o(27596);
            return;
        } else if (!z && !z2) {
            m79251ay(this.currentState, this.mMX);
            amA();
            AppMethodBeat.m2505o(27596);
            return;
        } else if (z && !z2) {
            m79251ay(4, this.mMX);
            m79251ay(this.currentState, this.mMX);
            this.vju.bBx();
        }
        AppMethodBeat.m2505o(27596);
    }

    private void bBJ() {
        AppMethodBeat.m2504i(27597);
        VoiceInputLayoutImpl.runOnUiThread(new C440763());
        bBR();
        AppMethodBeat.m2505o(27597);
    }

    private static boolean bBL() {
        AppMethodBeat.m2504i(27598);
        int acS = C9638aw.m17182Rg().acS();
        if (acS == 4 || acS == 6) {
            AppMethodBeat.m2505o(27598);
            return true;
        }
        AppMethodBeat.m2505o(27598);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bBM() {
        AppMethodBeat.m2504i(27599);
        VoiceInputLayoutImpl.runOnUiThread(new C404584());
        AppMethodBeat.m2505o(27599);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dX */
    public final void mo39097dX(boolean z) {
        AppMethodBeat.m2504i(27600);
        if (!z) {
            m79251ay(17, false);
        }
        VoiceInputLayoutImpl.runOnUiThread(new C300995());
        AppMethodBeat.m2505o(27600);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onReset() {
        AppMethodBeat.m2504i(27601);
        VoiceInputLayoutImpl.runOnUiThread(new C149076());
        AppMethodBeat.m2505o(27601);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: wj */
    public final void mo39099wj(final int i) {
        AppMethodBeat.m2504i(27602);
        VoiceInputLayoutImpl.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(27592);
                VoiceInputLayoutImpl.this.vju.mo56668KO(i);
                AppMethodBeat.m2505o(27592);
            }
        });
        AppMethodBeat.m2505o(27602);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(27603);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            C5004al.m7441d(runnable);
            AppMethodBeat.m2505o(27603);
            return;
        }
        runnable.run();
        AppMethodBeat.m2505o(27603);
    }

    /* renamed from: ay */
    private void m79251ay(int i, boolean z) {
        AppMethodBeat.m2504i(27604);
        log_13905 log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (!z) {
            voiceInputBehavior.click = i;
        } else if (this.mNh) {
            voiceInputBehavior.fullScreenVoiceLongClick = i;
            if (!(i == 4 || !this.mMX || this.mMZ == 0)) {
                voiceInputBehavior.fullScreenVoiceLongClickTime = C5046bo.m7525az(this.mMZ);
            }
        } else {
            voiceInputBehavior.longClick = i;
            if (!(i == 4 || !this.mMX || this.mMZ == 0)) {
                voiceInputBehavior.longClickTime = C5046bo.m7525az(this.mMZ);
            }
        }
        log_13905.viOp_ = voiceInputBehavior;
        C7060h.pYm.mo15417c(13905, log_13905);
        C4990ab.m7417i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        AppMethodBeat.m2505o(27604);
    }
}
