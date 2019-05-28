package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.tools.i */
public final class C44381i implements OnGestureListener {
    /* renamed from: LL */
    private final int f17259LL;
    /* renamed from: LM */
    private final int f17260LM;
    public final GestureDetector aJM = new GestureDetector(this.context, this);
    private final Context context;
    private final float zFA;
    public C5588a zFy;
    private final float zFz;

    /* renamed from: com.tencent.mm.ui.tools.i$a */
    public interface C5588a {
    }

    public C44381i(Context context) {
        AppMethodBeat.m2504i(107656);
        this.context = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f17259LL = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f17260LM = viewConfiguration.getScaledMaximumFlingVelocity();
        this.zFz = (float) C4977b.m7371b(context, 70.0f);
        this.zFA = (float) C4977b.m7371b(context, 50.0f);
        AppMethodBeat.m2505o(107656);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.m2504i(107657);
        if (this.zFy == null) {
            AppMethodBeat.m2505o(107657);
            return true;
        }
        C4990ab.m7419v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent2.getY()), Float.valueOf(f), Float.valueOf(f2));
        float abs = Math.abs(motionEvent2.getY() - motionEvent.getY());
        float abs2 = Math.abs(motionEvent2.getX() - motionEvent.getX());
        if (abs < this.zFA && f > 800.0f && abs2 > this.zFz) {
            AppMethodBeat.m2505o(107657);
            return true;
        } else if (abs < this.zFA && f < -800.0f && abs2 < (-this.zFz)) {
            AppMethodBeat.m2505o(107657);
            return true;
        } else if (abs2 < this.zFA && f2 > 800.0f) {
            AppMethodBeat.m2505o(107657);
            return true;
        } else if (abs2 >= this.zFA || f2 >= -800.0f) {
            AppMethodBeat.m2505o(107657);
            return false;
        } else {
            AppMethodBeat.m2505o(107657);
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
