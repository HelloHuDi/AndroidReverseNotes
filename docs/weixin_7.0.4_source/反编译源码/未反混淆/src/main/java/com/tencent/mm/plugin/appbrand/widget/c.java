package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c extends FrameLayout {
    public final Set<Runnable> iTV = new HashSet();

    public c(Context context) {
        super(context);
        AppMethodBeat.i(87440);
        setWillNotDraw(false);
        AppMethodBeat.o(87440);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(87441);
        if (willNotDraw()) {
            AppMethodBeat.o(87441);
            return;
        }
        super.dispatchDraw(canvas);
        AppMethodBeat.o(87441);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAnimationEnd() {
        AppMethodBeat.i(87442);
        super.onAnimationEnd();
        for (Runnable run : this.iTV) {
            run.run();
        }
        this.iTV.clear();
        AppMethodBeat.o(87442);
    }
}
