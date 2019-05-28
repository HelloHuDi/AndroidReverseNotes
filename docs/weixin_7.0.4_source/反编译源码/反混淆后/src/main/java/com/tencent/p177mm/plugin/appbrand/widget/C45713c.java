package com.tencent.p177mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.c */
public final class C45713c extends FrameLayout {
    public final Set<Runnable> iTV = new HashSet();

    public C45713c(Context context) {
        super(context);
        AppMethodBeat.m2504i(87440);
        setWillNotDraw(false);
        AppMethodBeat.m2505o(87440);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(87441);
        if (willNotDraw()) {
            AppMethodBeat.m2505o(87441);
            return;
        }
        super.dispatchDraw(canvas);
        AppMethodBeat.m2505o(87441);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAnimationEnd() {
        AppMethodBeat.m2504i(87442);
        super.onAnimationEnd();
        for (Runnable run : this.iTV) {
            run.run();
        }
        this.iTV.clear();
        AppMethodBeat.m2505o(87442);
    }
}
