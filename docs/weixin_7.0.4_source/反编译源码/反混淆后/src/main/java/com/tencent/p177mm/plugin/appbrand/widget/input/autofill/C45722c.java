package com.tencent.p177mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.support.p057v4.widget.C8415j;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C33627k.C33628a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.C2564a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.c */
public final class C45722c {
    final C38595ab jhB;
    final C33621e jhC;
    public final C33628a jhO = new C457211();
    public C44709u jhP;
    int jhQ = C8415j.INVALID_ID;
    boolean jhR = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.c$2 */
    class C385982 extends DataSetObserver {
        C385982() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(123899);
            if (C45722c.this.jhC.amH.isShowing()) {
                C45722c.this.mo73520qM(1);
                AppMethodBeat.m2505o(123899);
                return;
            }
            AppMethodBeat.m2505o(123899);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.c$1 */
    class C457211 implements C33628a {
        C457211() {
        }

        public final void aQL() {
            AppMethodBeat.m2504i(123897);
            C45722c.this.jhQ = C8415j.INVALID_ID;
            C45722c.this.mo73520qM(3);
            AppMethodBeat.m2505o(123897);
        }

        public final void aQM() {
            AppMethodBeat.m2504i(123898);
            C45722c.this.jhQ = C8415j.INVALID_ID;
            C45722c.this.mo73520qM(3);
            AppMethodBeat.m2505o(123898);
        }
    }

    C45722c(C38595ab c38595ab, C33621e c33621e) {
        AppMethodBeat.m2504i(123901);
        this.jhB = c38595ab;
        this.jhC = c33621e;
        AppMethodBeat.m2505o(123901);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qM */
    public final void mo73520qM(final int i) {
        AppMethodBeat.m2504i(123902);
        final C2564a c2564a = this.jhC.jhV;
        if (c2564a == null) {
            AppMethodBeat.m2505o(123902);
        } else if (this.jhC.amH.isShowing()) {
            if (1 == i && this.jhR) {
                this.jhQ = C8415j.INVALID_ID;
                this.jhR = false;
            }
            c2564a.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    AppMethodBeat.m2504i(123900);
                    c2564a.getViewTreeObserver().removeOnPreDrawListener(this);
                    C45722c c45722c = C45722c.this;
                    if (c45722c.jhC.amH.isShowing() && c45722c.jhC.jhV != null && c45722c.jhC.jhV.getAdapter() != null && c45722c.jhC.jhV.getAdapter().getCount() > 0) {
                        View inputPanel = c45722c.jhB.getInputPanel();
                        if (inputPanel != null) {
                            int fromDPToPix = C1338a.fromDPToPix(c45722c.jhB.getContext(), 8);
                            int height = c45722c.jhC.jhV.getChildAt(0).getHeight();
                            int count = c45722c.jhC.jhV.getAdapter().getCount() * height;
                            int i = count + (fromDPToPix * 2);
                            int i2 = (height * 3) + (fromDPToPix * 2);
                            if (i > i2) {
                                count = i2 - (fromDPToPix * 2);
                            } else {
                                i2 = i;
                            }
                            c45722c.jhC.aml = i2;
                            int[] iArr = new int[2];
                            c45722c.jhB.getView().getLocationInWindow(iArr);
                            int height2 = c45722c.jhB.getView().getHeight() + iArr[1];
                            inputPanel.getLocationInWindow(iArr);
                            i = iArr[1];
                            i2 = height;
                            C45722c c45722c2 = c45722c;
                            while (true) {
                                if ((c45722c2.jhQ == C8415j.INVALID_ID || c45722c2.jhQ >= 0 - fromDPToPix) && i - height2 >= count + fromDPToPix) {
                                    c45722c2.jhC.amx = c45722c2.jhB.getView();
                                    c45722c2.jhC.aml = (fromDPToPix * 2) + count;
                                    c45722c2.jhC.setVerticalOffset(0 - fromDPToPix);
                                    break;
                                } else if (height2 - c45722c2.jhB.getView().getHeight() >= count) {
                                    c45722c2.jhC.amx = c45722c2.jhB.getView();
                                    c45722c2.jhC.aml = (fromDPToPix * 2) + count;
                                    c45722c2.jhC.setVerticalOffset((-(count + fromDPToPix)) - c45722c2.jhB.getView().getHeight());
                                    break;
                                } else if (count <= i2) {
                                    c45722c2.jhC.aml = i2;
                                    c45722c2.jhC.amx = c45722c2.jhB.getView();
                                    if (c45722c2.jhQ < 0 - fromDPToPix) {
                                        c45722c2.jhC.setVerticalOffset((-(count + fromDPToPix)) - c45722c2.jhB.getView().getHeight());
                                    } else {
                                        c45722c2.jhC.setVerticalOffset(0 - fromDPToPix);
                                    }
                                } else {
                                    count -= i2;
                                }
                            }
                            c45722c.jhC.show();
                            C33621e c33621e = c45722c.jhC;
                            if (c33621e.amp) {
                                i2 = c33621e.amn;
                            } else {
                                i2 = 0;
                            }
                            c45722c.jhQ = i2;
                        }
                    }
                    AppMethodBeat.m2505o(123900);
                    return true;
                }
            });
            AppMethodBeat.m2505o(123902);
        } else {
            AppMethodBeat.m2505o(123902);
        }
    }
}
