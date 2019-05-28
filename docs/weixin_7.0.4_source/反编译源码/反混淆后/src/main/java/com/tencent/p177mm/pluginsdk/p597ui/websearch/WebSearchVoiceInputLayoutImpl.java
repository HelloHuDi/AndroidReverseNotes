package com.tencent.p177mm.pluginsdk.p597ui.websearch;

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
import com.tencent.p177mm.pluginsdk.p597ui.C35876k;
import com.tencent.p177mm.pluginsdk.p597ui.VoiceInputLayout;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@TargetApi(16)
/* renamed from: com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl */
public class WebSearchVoiceInputLayoutImpl extends VoiceInputLayout {
    private OnLongClickListener aKe = new C233531();
    private View mMU;
    private boolean mMX = false;
    private long mMZ;
    private OnTouchListener mNa = new C233522();
    private C35876k vju;

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl$5 */
    class C149895 implements Runnable {
        C149895() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28225);
            WebSearchVoiceInputLayoutImpl.this.vju.djn();
            AppMethodBeat.m2505o(28225);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl$3 */
    class C233503 implements Runnable {
        C233503() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28223);
            WebSearchVoiceInputLayoutImpl.this.vju.djo();
            AppMethodBeat.m2505o(28223);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl$4 */
    class C233514 implements Runnable {
        final /* synthetic */ boolean mNc = true;

        C233514() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28224);
            WebSearchVoiceInputLayoutImpl.this.vju.mo56678oy(this.mNc);
            AppMethodBeat.m2505o(28224);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl$2 */
    class C233522 implements OnTouchListener {
        C233522() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(28222);
            switch (motionEvent.getAction()) {
                case 0:
                    WebSearchVoiceInputLayoutImpl.this.mMX = false;
                    WebSearchVoiceInputLayoutImpl.this.mMZ = C5046bo.m7588yz();
                    C4990ab.m7411d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState), Long.valueOf(WebSearchVoiceInputLayoutImpl.this.mMZ));
                    WebSearchVoiceInputLayoutImpl.this.vju.djm();
                    WebSearchVoiceInputLayoutImpl.this.mo39095B(false, false);
                    break;
                case 1:
                    C4990ab.m7411d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.this.mMX));
                    if (!WebSearchVoiceInputLayoutImpl.this.mMX) {
                        WebSearchVoiceInputLayoutImpl.this.mo39095B(false, true);
                        break;
                    }
                    WebSearchVoiceInputLayoutImpl.this.mo39095B(true, false);
                    WebSearchVoiceInputLayoutImpl.this.mMX = false;
                    WebSearchVoiceInputLayoutImpl.this.mMZ = 0;
                    break;
            }
            AppMethodBeat.m2505o(28222);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl$1 */
    class C233531 implements OnLongClickListener {
        C233531() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(28221);
            C4990ab.m7411d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState));
            WebSearchVoiceInputLayoutImpl.this.mMX = true;
            WebSearchVoiceInputLayoutImpl.this.vju.djl();
            AppMethodBeat.m2505o(28221);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl$6 */
    class C233546 implements Runnable {
        C233546() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28226);
            WebSearchVoiceInputLayoutImpl.this.vju.bBx();
            AppMethodBeat.m2505o(28226);
        }
    }

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(28228);
        init(context);
        AppMethodBeat.m2505o(28228);
    }

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(28229);
        init(context);
        AppMethodBeat.m2505o(28229);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(28230);
        this.mMU = WebSearchVoiceInputLayoutImpl.inflate(context, 2130971010, this).findViewById(2131824276);
        this.mMU.setLayerType(1, null);
        this.vju = new C35876k(context);
        this.mMU.setBackground(this.vju);
        this.mMU.setEnabled(true);
        this.mMU.setOnTouchListener(this.mNa);
        this.mMU.setOnLongClickListener(this.aKe);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.m2505o(28230);
            return;
        }
        if (!WebSearchVoiceInputLayoutImpl.bBL()) {
            bBJ();
        }
        AppMethodBeat.m2505o(28230);
    }

    /* renamed from: B */
    public final void mo39095B(boolean z, boolean z2) {
        AppMethodBeat.m2504i(28231);
        C4990ab.m7411d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (z || z2) {
                if (z && !z2) {
                    this.vju.bBx();
                    AppMethodBeat.m2505o(28231);
                    return;
                }
            } else if (WebSearchVoiceInputLayoutImpl.bBL()) {
                bBO();
                AppMethodBeat.m2505o(28231);
                return;
            } else {
                bBJ();
                AppMethodBeat.m2505o(28231);
                return;
            }
        } else if (this.currentState == 2) {
            if (z2) {
                this.vju.bBx();
                amA();
                if (this.vjs != null) {
                    this.vjs.bBI();
                    AppMethodBeat.m2505o(28231);
                    return;
                }
            }
            bBP();
            AppMethodBeat.m2505o(28231);
            return;
        } else if (!z && !z2) {
            amA();
            AppMethodBeat.m2505o(28231);
            return;
        } else if (z && !z2) {
            this.vju.bBx();
        }
        AppMethodBeat.m2505o(28231);
    }

    private void bBJ() {
        AppMethodBeat.m2504i(28232);
        WebSearchVoiceInputLayoutImpl.runOnUiThread(new C233503());
        bBR();
        AppMethodBeat.m2505o(28232);
    }

    private static boolean bBL() {
        AppMethodBeat.m2504i(28233);
        int acS = C9638aw.m17182Rg().acS();
        if (acS == 4 || acS == 6) {
            AppMethodBeat.m2505o(28233);
            return true;
        }
        AppMethodBeat.m2505o(28233);
        return false;
    }

    public final void bBM() {
        AppMethodBeat.m2504i(28234);
        WebSearchVoiceInputLayoutImpl.runOnUiThread(new C233514());
        AppMethodBeat.m2505o(28234);
    }

    /* renamed from: dX */
    public final void mo39097dX(boolean z) {
        AppMethodBeat.m2504i(28235);
        WebSearchVoiceInputLayoutImpl.runOnUiThread(new C149895());
        AppMethodBeat.m2505o(28235);
    }

    public final void onReset() {
        AppMethodBeat.m2504i(28236);
        WebSearchVoiceInputLayoutImpl.runOnUiThread(new C233546());
        AppMethodBeat.m2505o(28236);
    }

    /* renamed from: wj */
    public final void mo39099wj(final int i) {
        AppMethodBeat.m2504i(28237);
        WebSearchVoiceInputLayoutImpl.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(28227);
                WebSearchVoiceInputLayoutImpl.this.vju.mo56668KO(i);
                AppMethodBeat.m2505o(28227);
            }
        });
        AppMethodBeat.m2505o(28237);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(28238);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            C5004al.m7441d(runnable);
            AppMethodBeat.m2505o(28238);
            return;
        }
        runnable.run();
        AppMethodBeat.m2505o(28238);
    }
}
