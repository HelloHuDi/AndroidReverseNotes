package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.v4.widget.j;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;
import com.tencent.mm.ui.widget.picker.e;

public class AppBrandOptionsPicker extends NumberPicker implements b<String> {
    private int dg;
    private int di;
    private String[] jkM;
    private int jkN;

    public final /* synthetic */ Object aEG() {
        AppMethodBeat.i(126721);
        String aRK = aRK();
        AppMethodBeat.o(126721);
        return aRK;
    }

    @Keep
    public AppBrandOptionsPicker(Context context) {
        super(new ContextThemeWrapper(context, R.style.wg));
        AppMethodBeat.i(126714);
        e.a(this, getResources().getDrawable(R.drawable.cr));
        e.c(this);
        e.e(this);
        e.a(this);
        this.dg = a.fromDPToPix(context, 100);
        this.jkN = a.fromDPToPix(context, 20);
        AppMethodBeat.o(126714);
    }

    public void setOptionsArray(String[] strArr) {
        AppMethodBeat.i(126715);
        if (strArr == null) {
            AppMethodBeat.o(126715);
            return;
        }
        this.jkM = strArr;
        setDisplayedValues(null);
        setMinValue(0);
        setMaxValue(Math.max(strArr.length - 1, 0));
        if (strArr.length <= 0) {
            strArr = null;
        }
        super.setDisplayedValues(strArr);
        AppMethodBeat.o(126715);
    }

    public final void setExtraPadding(int i) {
        AppMethodBeat.i(126716);
        this.jkN = Math.max(i, 0);
        AppMethodBeat.o(126716);
    }

    public final void setMinWidth(int i) {
        this.dg = i;
    }

    public final void setMaxWidth(int i) {
        this.di = i;
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        AppMethodBeat.i(126717);
        super.setDisplayedValues(strArr);
        AppMethodBeat.o(126717);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(126718);
        if (MeasureSpec.getMode(i) == j.INVALID_ID || MeasureSpec.getMode(i) == ErrorDialogData.SUPPRESSED) {
            this.di = MeasureSpec.getSize(i);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), i2);
        if (getMeasuredWidth() > this.dg || (this.di > 0 && this.dg > this.di)) {
            int measuredWidth = getMeasuredWidth() + (this.jkN * 2);
            if (this.di > 0 && this.di <= measuredWidth) {
                measuredWidth = this.di;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            AppMethodBeat.o(126718);
            return;
        }
        setMeasuredDimension(this.dg, getMeasuredHeight());
        AppMethodBeat.o(126718);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(126719);
        super.onAttachedToWindow();
        e.d(this);
        AppMethodBeat.o(126719);
    }

    public final String aRK() {
        AppMethodBeat.i(126720);
        String str;
        if (this.jkM == null || this.jkM.length <= 0) {
            str = "";
            AppMethodBeat.o(126720);
            return str;
        }
        str = this.jkM[getValue()];
        AppMethodBeat.o(126720);
        return str;
    }

    public View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void aEH() {
    }

    public final void b(d dVar) {
    }

    public final void aEI() {
    }
}
