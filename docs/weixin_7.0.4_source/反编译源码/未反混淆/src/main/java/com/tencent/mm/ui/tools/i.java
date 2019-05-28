package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class i implements OnGestureListener {
    private final int LL;
    private final int LM;
    public final GestureDetector aJM = new GestureDetector(this.context, this);
    private final Context context;
    private final float zFA;
    public a zFy;
    private final float zFz;

    public interface a {
    }

    public i(Context context) {
        AppMethodBeat.i(107656);
        this.context = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.LL = viewConfiguration.getScaledMinimumFlingVelocity();
        this.LM = viewConfiguration.getScaledMaximumFlingVelocity();
        this.zFz = (float) b.b(context, 70.0f);
        this.zFA = (float) b.b(context, 50.0f);
        AppMethodBeat.o(107656);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(107657);
        if (this.zFy == null) {
            AppMethodBeat.o(107657);
            return true;
        }
        ab.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent2.getY()), Float.valueOf(f), Float.valueOf(f2));
        float abs = Math.abs(motionEvent2.getY() - motionEvent.getY());
        float abs2 = Math.abs(motionEvent2.getX() - motionEvent.getX());
        if (abs < this.zFA && f > 800.0f && abs2 > this.zFz) {
            AppMethodBeat.o(107657);
            return true;
        } else if (abs < this.zFA && f < -800.0f && abs2 < (-this.zFz)) {
            AppMethodBeat.o(107657);
            return true;
        } else if (abs2 < this.zFA && f2 > 800.0f) {
            AppMethodBeat.o(107657);
            return true;
        } else if (abs2 >= this.zFA || f2 >= -800.0f) {
            AppMethodBeat.o(107657);
            return false;
        } else {
            AppMethodBeat.o(107657);
            return true;
        }
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }
}
