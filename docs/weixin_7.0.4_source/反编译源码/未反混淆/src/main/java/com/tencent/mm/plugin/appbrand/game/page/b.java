package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.al;

public final class b extends FrameLayout implements al {

    static final class a implements OnTouchListener {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public b(Context context) {
        super(context);
    }

    public final ViewGroup getContainer() {
        return this;
    }

    public final void setupWebViewTouchInterceptor(aj ajVar) {
    }

    public final void a(ah ahVar) {
    }

    public final void nT(int i) {
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(130217);
        super.onViewAdded(view);
        if ((view instanceof CoverViewContainer) && !view.hasOnClickListeners()) {
            view.setOnTouchListener(new a());
        }
        AppMethodBeat.o(130217);
    }

    public final void c(boolean z, int i, int i2, int i3, int i4) {
    }
}
