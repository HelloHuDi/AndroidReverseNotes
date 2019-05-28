package com.tencent.p177mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.page.C27220ah;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;
import com.tencent.p177mm.plugin.appbrand.page.C33467al;

/* renamed from: com.tencent.mm.plugin.appbrand.game.page.b */
public final class C10241b extends FrameLayout implements C33467al {

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.b$a */
    static final class C10242a implements OnTouchListener {
        private C10242a() {
        }

        /* synthetic */ C10242a(byte b) {
            this();
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public C10241b(Context context) {
        super(context);
    }

    public final ViewGroup getContainer() {
        return this;
    }

    public final void setupWebViewTouchInterceptor(C27221aj c27221aj) {
    }

    /* renamed from: a */
    public final void mo21649a(C27220ah c27220ah) {
    }

    /* renamed from: nT */
    public final void mo21652nT(int i) {
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.m2504i(130217);
        super.onViewAdded(view);
        if ((view instanceof CoverViewContainer) && !view.hasOnClickListeners()) {
            view.setOnTouchListener(new C10242a());
        }
        AppMethodBeat.m2505o(130217);
    }

    /* renamed from: c */
    public final void mo21650c(boolean z, int i, int i2, int i3, int i4) {
    }
}
