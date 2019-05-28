package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.am */
public final class C2560am implements OnGlobalLayoutListener {
    private final View jhl;
    private final C2561a jhm;
    private boolean jhn;
    private int lastHeight;
    private int lastWidth;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.am$a */
    public interface C2561a {
        void aQk();
    }

    /* renamed from: a */
    public static void m4804a(View view, C2561a c2561a) {
        AppMethodBeat.m2504i(67826);
        C2560am c2560am = new C2560am(view, c2561a);
        c2560am.jhl.getViewTreeObserver().addOnGlobalLayoutListener(c2560am);
        AppMethodBeat.m2505o(67826);
    }

    private C2560am(View view, C2561a c2561a) {
        this.jhl = view;
        this.jhm = c2561a;
    }

    public final void onGlobalLayout() {
        AppMethodBeat.m2504i(67827);
        if (this.jhn) {
            if (!(this.jhl.getWidth() == this.lastWidth && this.jhl.getHeight() == this.lastHeight)) {
                this.jhm.aQk();
                this.lastWidth = this.jhl.getWidth();
                this.lastHeight = this.jhl.getHeight();
            }
            AppMethodBeat.m2505o(67827);
            return;
        }
        this.jhn = true;
        this.lastWidth = this.jhl.getWidth();
        this.lastHeight = this.jhl.getHeight();
        AppMethodBeat.m2505o(67827);
    }
}
