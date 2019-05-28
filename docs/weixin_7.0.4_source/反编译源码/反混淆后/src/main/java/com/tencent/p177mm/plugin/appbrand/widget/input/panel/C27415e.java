package com.tencent.p177mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.input.C45719ac;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.e */
public interface C27415e extends C45719ac {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.e$a */
    public static class C11032a implements C27415e {
        int jeI;
        boolean mInLayout;
        private View mView;

        public C11032a(Context context) {
            AppMethodBeat.m2504i(123949);
            this.mView = new View(context) {
                /* Access modifiers changed, original: protected|final */
                public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
                    AppMethodBeat.m2504i(123947);
                    C11032a.this.mInLayout = true;
                    super.onLayout(z, i, i2, i3, i4);
                    C11032a.this.mInLayout = false;
                    AppMethodBeat.m2505o(123947);
                }

                /* Access modifiers changed, original: protected|final */
                public final void onMeasure(int i, int i2) {
                    AppMethodBeat.m2504i(123948);
                    if (C11032a.this.jeI > 0) {
                        i2 = MeasureSpec.makeMeasureSpec(C11032a.this.jeI, ErrorDialogData.SUPPRESSED);
                    }
                    super.onMeasure(i, i2);
                    AppMethodBeat.m2505o(123948);
                }
            };
            AppMethodBeat.m2505o(123949);
        }

        public final View getPanelView() {
            return this.mView;
        }

        public final void setOnTextOperationListener(C19904f c19904f) {
        }

        public final void aRD() {
            AppMethodBeat.m2504i(123950);
            this.mView.setVisibility(0);
            AppMethodBeat.m2505o(123950);
        }

        public final void aRE() {
            AppMethodBeat.m2504i(123951);
            this.mView.setVisibility(4);
            AppMethodBeat.m2505o(123951);
        }

        public final void onDestroy() {
        }

        /* renamed from: qD */
        public final boolean mo22694qD(int i) {
            if (i <= 0 || this.jeI == i) {
                return false;
            }
            this.jeI = i;
            return true;
        }

        public final boolean aQZ() {
            AppMethodBeat.m2504i(123952);
            boolean isInLayout;
            if (VERSION.SDK_INT >= 18) {
                isInLayout = this.mView.isInLayout();
                AppMethodBeat.m2505o(123952);
                return isInLayout;
            }
            isInLayout = this.mInLayout;
            AppMethodBeat.m2505o(123952);
            return isInLayout;
        }

        public final boolean aQV() {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.e$b */
    public interface C27416b extends C25681b {
        /* renamed from: cT */
        C27415e mo34799cT(Context context);
    }

    boolean aQZ();

    void aRD();

    void aRE();

    View getPanelView();

    void onDestroy();

    /* renamed from: qD */
    boolean mo22694qD(int i);

    void setOnTextOperationListener(C19904f c19904f);
}
