package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ac;

public interface e extends ac {

    public static class a implements e {
        int jeI;
        boolean mInLayout;
        private View mView;

        public a(Context context) {
            AppMethodBeat.i(123949);
            this.mView = new View(context) {
                /* Access modifiers changed, original: protected|final */
                public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
                    AppMethodBeat.i(123947);
                    a.this.mInLayout = true;
                    super.onLayout(z, i, i2, i3, i4);
                    a.this.mInLayout = false;
                    AppMethodBeat.o(123947);
                }

                /* Access modifiers changed, original: protected|final */
                public final void onMeasure(int i, int i2) {
                    AppMethodBeat.i(123948);
                    if (a.this.jeI > 0) {
                        i2 = MeasureSpec.makeMeasureSpec(a.this.jeI, ErrorDialogData.SUPPRESSED);
                    }
                    super.onMeasure(i, i2);
                    AppMethodBeat.o(123948);
                }
            };
            AppMethodBeat.o(123949);
        }

        public final View getPanelView() {
            return this.mView;
        }

        public final void setOnTextOperationListener(f fVar) {
        }

        public final void aRD() {
            AppMethodBeat.i(123950);
            this.mView.setVisibility(0);
            AppMethodBeat.o(123950);
        }

        public final void aRE() {
            AppMethodBeat.i(123951);
            this.mView.setVisibility(4);
            AppMethodBeat.o(123951);
        }

        public final void onDestroy() {
        }

        public final boolean qD(int i) {
            if (i <= 0 || this.jeI == i) {
                return false;
            }
            this.jeI = i;
            return true;
        }

        public final boolean aQZ() {
            AppMethodBeat.i(123952);
            boolean isInLayout;
            if (VERSION.SDK_INT >= 18) {
                isInLayout = this.mView.isInLayout();
                AppMethodBeat.o(123952);
                return isInLayout;
            }
            isInLayout = this.mInLayout;
            AppMethodBeat.o(123952);
            return isInLayout;
        }

        public final boolean aQV() {
            return true;
        }
    }

    public interface b extends com.tencent.luggage.a.b {
        e cT(Context context);
    }

    boolean aQZ();

    void aRD();

    void aRE();

    View getPanelView();

    void onDestroy();

    boolean qD(int i);

    void setOnTextOperationListener(f fVar);
}
