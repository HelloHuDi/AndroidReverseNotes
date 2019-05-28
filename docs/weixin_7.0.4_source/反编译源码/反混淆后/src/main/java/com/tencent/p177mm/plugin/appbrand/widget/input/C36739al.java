package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d;
import com.tencent.p177mm.plugin.appbrand.page.C27220ah;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;
import com.tencent.p177mm.plugin.appbrand.page.C33467al;
import com.tencent.p177mm.plugin.appbrand.page.C33467al.C31329a;
import com.tencent.p177mm.plugin.appbrand.page.C33481y;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.p177mm.plugin.appbrand.widget.base.C19810a;
import com.tencent.p177mm.plugin.appbrand.widget.base.C33591e;
import com.tencent.p177mm.plugin.appbrand.widget.base.C33591e.C33592a;
import com.tencent.p177mm.plugin.appbrand.widget.base.C45712b;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.al */
public final class C36739al implements C33467al {
    private final C44709u hTn;
    private final C44719g jhh;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.al$a */
    public static final class C31565a implements C31329a {
        /* renamed from: q */
        public final C33467al mo51293q(C44709u c44709u) {
            AppMethodBeat.m2504i(123859);
            C36739al c36739al = new C36739al(c44709u);
            AppMethodBeat.m2505o(123859);
            return c36739al;
        }
    }

    C36739al(C44709u c44709u) {
        AppMethodBeat.m2504i(123860);
        this.hTn = c44709u;
        this.jhh = new C44719g(c44709u);
        AppMethodBeat.m2505o(123860);
    }

    public final void setupWebViewTouchInterceptor(C27221aj c27221aj) {
        AppMethodBeat.m2504i(123861);
        ViewGroup viewGroup = (ViewGroup) c27221aj.getContentView();
        final C44719g c44719g = this.jhh;
        final C33615ah c33615ah = new C33615ah(c44719g);
        viewGroup.setOnTouchListener(new OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                AppMethodBeat.m2504i(123858);
                if (motionEvent.getAction() != 0) {
                    C38377d.m64948a(c44719g, motionEvent);
                }
                C33615ah c33615ah = c33615ah;
                if (motionEvent == null) {
                    z = false;
                } else {
                    C33481y c33481y;
                    C33591e c33591e = c33615ah.jgO.jdB;
                    if (c33591e.eAl.onFilterTouchEventForSecurity(motionEvent)) {
                        Iterator c45712b;
                        if (motionEvent.getActionMasked() == 0) {
                            c45712b = new C45712b(c33591e.eAl);
                        } else {
                            c45712b = c33591e.iVk.iterator();
                        }
                        c33591e.iVl = motionEvent.getActionMasked() == 0 ? new C33592a(motionEvent.getDownTime(), motionEvent.getEventTime(), (byte) 0) : null;
                        z = false;
                        while (c45712b.hasNext()) {
                            boolean dispatchTransformedTouchEvent;
                            View view2 = (View) c45712b.next();
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = c33591e.eAl.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(actionIndex) : -1;
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            if (motionEvent.getActionMasked() != 0) {
                                dispatchTransformedTouchEvent = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(c33591e.eAl, motionEvent, false, view2, pointerId) | z;
                            } else if (AppBrandViewMotionCompat.m43427cC(view2) && AppBrandViewMotionCompat.m43425a(c33591e.eAl, x, y, view2)) {
                                if (AppBrandViewMotionCompat.m43426cB(view2)) {
                                    if (AppBrandViewMotionCompat.dispatchTransformedTouchEvent(c33591e.eAl, motionEvent, false, view2, pointerId)) {
                                        c33591e.iVk.addLast(view2);
                                        dispatchTransformedTouchEvent = z | 1;
                                    } else {
                                        dispatchTransformedTouchEvent = z;
                                    }
                                    z = dispatchTransformedTouchEvent;
                                } else {
                                    dispatchTransformedTouchEvent = z;
                                }
                            }
                            z = dispatchTransformedTouchEvent;
                        }
                        switch (motionEvent.getActionMasked()) {
                            case 1:
                            case 3:
                                c33591e.iVk.clear();
                                break;
                        }
                    }
                    z = false;
                    C19810a.m30644a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | ".concat(String.valueOf(z)), motionEvent);
                    if (2 == motionEvent.getActionMasked()) {
                        if (z && !c33615ah.jgP) {
                            c33481y = (C33481y) c33615ah.jgT.mo45136cR(c33615ah.jgO);
                            if (c33481y != null) {
                                boolean z2;
                                if (c33481y.itL) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                c33615ah.jgQ = z2;
                                c33481y.setPullDownEnabled(false);
                                c33481y.requestDisallowInterceptTouchEvent(true);
                                c33615ah.jgP = true;
                            }
                        }
                        if (z) {
                            c33615ah.jgR = true;
                        } else if (c33615ah.jgR) {
                            c33615ah.jgR = false;
                        }
                    }
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                            break;
                        case 1:
                        case 3:
                            if (c33615ah.jgP) {
                                c33481y = (C33481y) c33615ah.jgT.mo45136cR(c33615ah.jgO);
                                if (c33481y != null) {
                                    c33481y.setPullDownEnabled(c33615ah.jgQ);
                                }
                                c33615ah.jgP = false;
                                break;
                            }
                            break;
                    }
                    z = false;
                }
                if (z) {
                    AppMethodBeat.m2505o(123858);
                    return true;
                }
                AppMethodBeat.m2505o(123858);
                return false;
            }
        });
        AppMethodBeat.m2505o(123861);
    }

    /* renamed from: a */
    public final void mo21649a(C27220ah c27220ah) {
        AppMethodBeat.m2504i(123862);
        if (c27220ah == C27220ah.MODAL || c27220ah == C27220ah.ACTION_SHEET) {
            C42743o.m75756v(this.hTn);
        }
        AppMethodBeat.m2505o(123862);
    }

    /* renamed from: nT */
    public final void mo21652nT(int i) {
        AppMethodBeat.m2504i(123863);
        this.jhh.setTranslationY((float) i);
        AppMethodBeat.m2505o(123863);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(123864);
        this.jhh.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.m2505o(123864);
    }

    public final ViewGroup getContainer() {
        return this.jhh;
    }

    /* renamed from: c */
    public final void mo21650c(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(123865);
        this.jhh.mo21650c(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(123865);
    }
}
