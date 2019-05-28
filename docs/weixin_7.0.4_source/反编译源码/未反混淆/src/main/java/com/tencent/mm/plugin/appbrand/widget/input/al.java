package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.b;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import java.util.Iterator;

public final class al implements com.tencent.mm.plugin.appbrand.page.al {
    private final u hTn;
    private final g jhh;

    public static final class a implements com.tencent.mm.plugin.appbrand.page.al.a {
        public final com.tencent.mm.plugin.appbrand.page.al q(u uVar) {
            AppMethodBeat.i(123859);
            al alVar = new al(uVar);
            AppMethodBeat.o(123859);
            return alVar;
        }
    }

    al(u uVar) {
        AppMethodBeat.i(123860);
        this.hTn = uVar;
        this.jhh = new g(uVar);
        AppMethodBeat.o(123860);
    }

    public final void setupWebViewTouchInterceptor(aj ajVar) {
        AppMethodBeat.i(123861);
        ViewGroup viewGroup = (ViewGroup) ajVar.getContentView();
        final g gVar = this.jhh;
        final ah ahVar = new ah(gVar);
        viewGroup.setOnTouchListener(new OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                AppMethodBeat.i(123858);
                if (motionEvent.getAction() != 0) {
                    d.a(gVar, motionEvent);
                }
                ah ahVar = ahVar;
                if (motionEvent == null) {
                    z = false;
                } else {
                    y yVar;
                    e eVar = ahVar.jgO.jdB;
                    if (eVar.eAl.onFilterTouchEventForSecurity(motionEvent)) {
                        Iterator bVar;
                        if (motionEvent.getActionMasked() == 0) {
                            bVar = new b(eVar.eAl);
                        } else {
                            bVar = eVar.iVk.iterator();
                        }
                        eVar.iVl = motionEvent.getActionMasked() == 0 ? new com.tencent.mm.plugin.appbrand.widget.base.e.a(motionEvent.getDownTime(), motionEvent.getEventTime(), (byte) 0) : null;
                        z = false;
                        while (bVar.hasNext()) {
                            boolean dispatchTransformedTouchEvent;
                            View view2 = (View) bVar.next();
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = eVar.eAl.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(actionIndex) : -1;
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            if (motionEvent.getActionMasked() != 0) {
                                dispatchTransformedTouchEvent = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(eVar.eAl, motionEvent, false, view2, pointerId) | z;
                            } else if (AppBrandViewMotionCompat.cC(view2) && AppBrandViewMotionCompat.a(eVar.eAl, x, y, view2)) {
                                if (AppBrandViewMotionCompat.cB(view2)) {
                                    if (AppBrandViewMotionCompat.dispatchTransformedTouchEvent(eVar.eAl, motionEvent, false, view2, pointerId)) {
                                        eVar.iVk.addLast(view2);
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
                                eVar.iVk.clear();
                                break;
                        }
                    }
                    z = false;
                    com.tencent.mm.plugin.appbrand.widget.base.a.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | ".concat(String.valueOf(z)), motionEvent);
                    if (2 == motionEvent.getActionMasked()) {
                        if (z && !ahVar.jgP) {
                            yVar = (y) ahVar.jgT.cR(ahVar.jgO);
                            if (yVar != null) {
                                boolean z2;
                                if (yVar.itL) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                ahVar.jgQ = z2;
                                yVar.setPullDownEnabled(false);
                                yVar.requestDisallowInterceptTouchEvent(true);
                                ahVar.jgP = true;
                            }
                        }
                        if (z) {
                            ahVar.jgR = true;
                        } else if (ahVar.jgR) {
                            ahVar.jgR = false;
                        }
                    }
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                            break;
                        case 1:
                        case 3:
                            if (ahVar.jgP) {
                                yVar = (y) ahVar.jgT.cR(ahVar.jgO);
                                if (yVar != null) {
                                    yVar.setPullDownEnabled(ahVar.jgQ);
                                }
                                ahVar.jgP = false;
                                break;
                            }
                            break;
                    }
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(123858);
                    return true;
                }
                AppMethodBeat.o(123858);
                return false;
            }
        });
        AppMethodBeat.o(123861);
    }

    public final void a(ah ahVar) {
        AppMethodBeat.i(123862);
        if (ahVar == ah.MODAL || ahVar == ah.ACTION_SHEET) {
            o.v(this.hTn);
        }
        AppMethodBeat.o(123862);
    }

    public final void nT(int i) {
        AppMethodBeat.i(123863);
        this.jhh.setTranslationY((float) i);
        AppMethodBeat.o(123863);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.i(123864);
        this.jhh.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.o(123864);
    }

    public final ViewGroup getContainer() {
        return this.jhh;
    }

    public final void c(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(123865);
        this.jhh.c(z, i, i2, i3, i4);
        AppMethodBeat.o(123865);
    }
}
