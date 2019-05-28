package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38376f;
import com.tencent.p177mm.plugin.appbrand.widget.base.C19810a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ag */
final class C11011ag<Input extends EditText & C38595ab> {
    final String TAG;
    final Input jgG;
    final float jgH;
    C38376f jgI;
    MotionEvent jgJ;
    boolean jgK = false;
    final Runnable jgL = new C110131();
    final Runnable jgM = new C110122();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ag$2 */
    class C110122 implements Runnable {
        C110122() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123836);
            if (C11011ag.this.jgK) {
                C38376f co = C38377d.m64950co(C11011ag.this.jgG);
                if (C11011ag.this.jgI == null || Math.abs(C11011ag.this.jgI.f16152x - co.f16152x) > 1.0f || Math.abs(C11011ag.this.jgI.f16153y - co.f16153y) > 1.0f) {
                    C4990ab.m7418v(C11011ag.this.TAG, "check long press timeout, but view has moved.");
                    AppMethodBeat.m2505o(123836);
                    return;
                } else if (C11011ag.this.jgJ == null) {
                    AppMethodBeat.m2505o(123836);
                    return;
                } else {
                    C11011ag.this.jgK = false;
                    C11011ag.this.jgG.removeCallbacks(C11011ag.this.jgL);
                    AppMethodBeat.m2505o(123836);
                    return;
                }
            }
            AppMethodBeat.m2505o(123836);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ag$1 */
    class C110131 implements Runnable {
        C110131() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123835);
            C11011ag.this.jgK = true;
            C4990ab.m7418v(C11011ag.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
            C11011ag.this.jgG.postDelayed(C11011ag.this.jgM, (long) ViewConfiguration.getLongPressTimeout());
            AppMethodBeat.m2505o(123835);
        }
    }

    C11011ag(Input input) {
        AppMethodBeat.m2504i(123837);
        this.jgG = input;
        this.TAG = "MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[]{input.toString()});
        this.jgH = (float) ViewConfiguration.get(input.getContext()).getScaledTouchSlop();
        AppMethodBeat.m2505o(123837);
    }

    /* Access modifiers changed, original: final */
    public final void aRq() {
        AppMethodBeat.m2504i(123838);
        this.jgK = false;
        this.jgG.removeCallbacks(this.jgL);
        this.jgG.removeCallbacks(this.jgM);
        this.jgI = null;
        if (this.jgJ != null) {
            this.jgJ.recycle();
            this.jgJ = null;
        }
        AppMethodBeat.m2505o(123838);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo22668a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        AppMethodBeat.m2504i(123839);
        float x = motionEvent.getX(motionEvent.getActionIndex());
        float y = motionEvent.getY(motionEvent.getActionIndex());
        C4990ab.m7419v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", Float.valueOf(this.jgH), Float.valueOf(x), Float.valueOf(motionEvent2.getX(motionEvent2.getActionIndex())), Float.valueOf(y), Float.valueOf(motionEvent2.getY(motionEvent2.getActionIndex())), C19810a.m30643D(motionEvent), C19810a.m30643D(motionEvent2));
        if (Math.abs(motionEvent2.getY(motionEvent2.getActionIndex()) - y) > this.jgH || Math.abs(r4 - x) > this.jgH) {
            AppMethodBeat.m2505o(123839);
            return false;
        }
        AppMethodBeat.m2505o(123839);
        return true;
    }
}
