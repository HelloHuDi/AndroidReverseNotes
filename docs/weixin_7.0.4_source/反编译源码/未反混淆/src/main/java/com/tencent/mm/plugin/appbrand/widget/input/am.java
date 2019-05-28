package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am implements OnGlobalLayoutListener {
    private final View jhl;
    private final a jhm;
    private boolean jhn;
    private int lastHeight;
    private int lastWidth;

    public interface a {
        void aQk();
    }

    public static void a(View view, a aVar) {
        AppMethodBeat.i(67826);
        am amVar = new am(view, aVar);
        amVar.jhl.getViewTreeObserver().addOnGlobalLayoutListener(amVar);
        AppMethodBeat.o(67826);
    }

    private am(View view, a aVar) {
        this.jhl = view;
        this.jhm = aVar;
    }

    public final void onGlobalLayout() {
        AppMethodBeat.i(67827);
        if (this.jhn) {
            if (!(this.jhl.getWidth() == this.lastWidth && this.jhl.getHeight() == this.lastHeight)) {
                this.jhm.aQk();
                this.lastWidth = this.jhl.getWidth();
                this.lastHeight = this.jhl.getHeight();
            }
            AppMethodBeat.o(67827);
            return;
        }
        this.jhn = true;
        this.lastWidth = this.jhl.getWidth();
        this.lastHeight = this.jhl.getHeight();
        AppMethodBeat.o(67827);
    }
}
