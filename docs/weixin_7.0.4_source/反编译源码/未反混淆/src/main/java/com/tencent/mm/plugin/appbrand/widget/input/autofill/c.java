package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.support.v4.widget.j;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.k.a;

public final class c {
    final ab jhB;
    final e jhC;
    public final a jhO = new a() {
        public final void aQL() {
            AppMethodBeat.i(123897);
            c.this.jhQ = j.INVALID_ID;
            c.this.qM(3);
            AppMethodBeat.o(123897);
        }

        public final void aQM() {
            AppMethodBeat.i(123898);
            c.this.jhQ = j.INVALID_ID;
            c.this.qM(3);
            AppMethodBeat.o(123898);
        }
    };
    public u jhP;
    int jhQ = j.INVALID_ID;
    boolean jhR = false;

    c(ab abVar, e eVar) {
        AppMethodBeat.i(123901);
        this.jhB = abVar;
        this.jhC = eVar;
        AppMethodBeat.o(123901);
    }

    /* Access modifiers changed, original: final */
    public final void qM(final int i) {
        AppMethodBeat.i(123902);
        final a aVar = this.jhC.jhV;
        if (aVar == null) {
            AppMethodBeat.o(123902);
        } else if (this.jhC.amH.isShowing()) {
            if (1 == i && this.jhR) {
                this.jhQ = j.INVALID_ID;
                this.jhR = false;
            }
            aVar.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    AppMethodBeat.i(123900);
                    aVar.getViewTreeObserver().removeOnPreDrawListener(this);
                    c cVar = c.this;
                    if (cVar.jhC.amH.isShowing() && cVar.jhC.jhV != null && cVar.jhC.jhV.getAdapter() != null && cVar.jhC.jhV.getAdapter().getCount() > 0) {
                        View inputPanel = cVar.jhB.getInputPanel();
                        if (inputPanel != null) {
                            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(cVar.jhB.getContext(), 8);
                            int height = cVar.jhC.jhV.getChildAt(0).getHeight();
                            int count = cVar.jhC.jhV.getAdapter().getCount() * height;
                            int i = count + (fromDPToPix * 2);
                            int i2 = (height * 3) + (fromDPToPix * 2);
                            if (i > i2) {
                                count = i2 - (fromDPToPix * 2);
                            } else {
                                i2 = i;
                            }
                            cVar.jhC.aml = i2;
                            int[] iArr = new int[2];
                            cVar.jhB.getView().getLocationInWindow(iArr);
                            int height2 = cVar.jhB.getView().getHeight() + iArr[1];
                            inputPanel.getLocationInWindow(iArr);
                            i = iArr[1];
                            i2 = height;
                            c cVar2 = cVar;
                            while (true) {
                                if ((cVar2.jhQ == j.INVALID_ID || cVar2.jhQ >= 0 - fromDPToPix) && i - height2 >= count + fromDPToPix) {
                                    cVar2.jhC.amx = cVar2.jhB.getView();
                                    cVar2.jhC.aml = (fromDPToPix * 2) + count;
                                    cVar2.jhC.setVerticalOffset(0 - fromDPToPix);
                                    break;
                                } else if (height2 - cVar2.jhB.getView().getHeight() >= count) {
                                    cVar2.jhC.amx = cVar2.jhB.getView();
                                    cVar2.jhC.aml = (fromDPToPix * 2) + count;
                                    cVar2.jhC.setVerticalOffset((-(count + fromDPToPix)) - cVar2.jhB.getView().getHeight());
                                    break;
                                } else if (count <= i2) {
                                    cVar2.jhC.aml = i2;
                                    cVar2.jhC.amx = cVar2.jhB.getView();
                                    if (cVar2.jhQ < 0 - fromDPToPix) {
                                        cVar2.jhC.setVerticalOffset((-(count + fromDPToPix)) - cVar2.jhB.getView().getHeight());
                                    } else {
                                        cVar2.jhC.setVerticalOffset(0 - fromDPToPix);
                                    }
                                } else {
                                    count -= i2;
                                }
                            }
                            cVar.jhC.show();
                            e eVar = cVar.jhC;
                            if (eVar.amp) {
                                i2 = eVar.amn;
                            } else {
                                i2 = 0;
                            }
                            cVar.jhQ = i2;
                        }
                    }
                    AppMethodBeat.o(123900);
                    return true;
                }
            });
            AppMethodBeat.o(123902);
        } else {
            AppMethodBeat.o(123902);
        }
    }
}
