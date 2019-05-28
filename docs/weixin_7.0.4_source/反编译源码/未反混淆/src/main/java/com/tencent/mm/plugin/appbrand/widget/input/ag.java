package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.f;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Locale;

final class ag<Input extends EditText & ab> {
    final String TAG;
    final Input jgG;
    final float jgH;
    f jgI;
    MotionEvent jgJ;
    boolean jgK = false;
    final Runnable jgL = new Runnable() {
        public final void run() {
            AppMethodBeat.i(123835);
            ag.this.jgK = true;
            ab.v(ag.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
            ag.this.jgG.postDelayed(ag.this.jgM, (long) ViewConfiguration.getLongPressTimeout());
            AppMethodBeat.o(123835);
        }
    };
    final Runnable jgM = new Runnable() {
        public final void run() {
            AppMethodBeat.i(123836);
            if (ag.this.jgK) {
                f co = d.co(ag.this.jgG);
                if (ag.this.jgI == null || Math.abs(ag.this.jgI.x - co.x) > 1.0f || Math.abs(ag.this.jgI.y - co.y) > 1.0f) {
                    ab.v(ag.this.TAG, "check long press timeout, but view has moved.");
                    AppMethodBeat.o(123836);
                    return;
                } else if (ag.this.jgJ == null) {
                    AppMethodBeat.o(123836);
                    return;
                } else {
                    ag.this.jgK = false;
                    ag.this.jgG.removeCallbacks(ag.this.jgL);
                    AppMethodBeat.o(123836);
                    return;
                }
            }
            AppMethodBeat.o(123836);
        }
    };

    ag(Input input) {
        AppMethodBeat.i(123837);
        this.jgG = input;
        this.TAG = "MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[]{input.toString()});
        this.jgH = (float) ViewConfiguration.get(input.getContext()).getScaledTouchSlop();
        AppMethodBeat.o(123837);
    }

    /* Access modifiers changed, original: final */
    public final void aRq() {
        AppMethodBeat.i(123838);
        this.jgK = false;
        this.jgG.removeCallbacks(this.jgL);
        this.jgG.removeCallbacks(this.jgM);
        this.jgI = null;
        if (this.jgJ != null) {
            this.jgJ.recycle();
            this.jgJ = null;
        }
        AppMethodBeat.o(123838);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        AppMethodBeat.i(123839);
        float x = motionEvent.getX(motionEvent.getActionIndex());
        float y = motionEvent.getY(motionEvent.getActionIndex());
        ab.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", Float.valueOf(this.jgH), Float.valueOf(x), Float.valueOf(motionEvent2.getX(motionEvent2.getActionIndex())), Float.valueOf(y), Float.valueOf(motionEvent2.getY(motionEvent2.getActionIndex())), a.D(motionEvent), a.D(motionEvent2));
        if (Math.abs(motionEvent2.getY(motionEvent2.getActionIndex()) - y) > this.jgH || Math.abs(r4 - x) > this.jgH) {
            AppMethodBeat.o(123839);
            return false;
        }
        AppMethodBeat.o(123839);
        return true;
    }
}
