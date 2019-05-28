package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aj;

public class OptionPicker extends NumberPicker {
    private int dg;
    private int di;
    private String[] jkM;
    private int jkN;
    private Context mContext;

    public OptionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112857);
        this.mContext = context;
        init();
        AppMethodBeat.o(112857);
    }

    public OptionPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112858);
        this.mContext = context;
        init();
        AppMethodBeat.o(112858);
    }

    private void init() {
        AppMethodBeat.i(112859);
        this.dg = aj.fromDPToPix(this.mContext, 120);
        this.jkN = aj.fromDPToPix(this.mContext, 20);
        e.a(this, getResources().getDrawable(R.drawable.wx));
        setDescendantFocusability(393216);
        AppMethodBeat.o(112859);
    }

    public void setOptionsArray(String[] strArr) {
        AppMethodBeat.i(112860);
        if (strArr == null) {
            AppMethodBeat.o(112860);
            return;
        }
        this.jkM = strArr;
        setDisplayedValues(null);
        setMinValue(0);
        setMaxValue(Math.max(strArr.length - 1, 0));
        setWrapSelectorWheel(false);
        if (strArr.length <= 0) {
            strArr = null;
        }
        super.setDisplayedValues(strArr);
        AppMethodBeat.o(112860);
    }

    public final String aRK() {
        AppMethodBeat.i(112861);
        String str;
        if (this.jkM == null || this.jkM.length <= 0) {
            str = "";
            AppMethodBeat.o(112861);
            return str;
        }
        str = this.jkM[getValue()];
        AppMethodBeat.o(112861);
        return str;
    }

    public final void setExtraPadding(int i) {
        AppMethodBeat.i(112862);
        this.jkN = Math.max(i, 0);
        AppMethodBeat.o(112862);
    }

    public final void setMinWidth(int i) {
        this.dg = i;
    }

    public final void setMaxWidth(int i) {
        this.di = i;
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        AppMethodBeat.i(112863);
        super.setDisplayedValues(strArr);
        AppMethodBeat.o(112863);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(112864);
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
            AppMethodBeat.o(112864);
            return;
        }
        setMeasuredDimension(this.dg, getMeasuredHeight());
        AppMethodBeat.o(112864);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(112865);
        super.onAttachedToWindow();
        AppMethodBeat.o(112865);
    }
}
