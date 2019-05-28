package com.tencent.p177mm.p612ui.widget.picker;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5229aj;

/* renamed from: com.tencent.mm.ui.widget.picker.OptionPicker */
public class OptionPicker extends NumberPicker {
    /* renamed from: dg */
    private int f2998dg;
    /* renamed from: di */
    private int f2999di;
    private String[] jkM;
    private int jkN;
    private Context mContext;

    public OptionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112857);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(112857);
    }

    public OptionPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112858);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(112858);
    }

    private void init() {
        AppMethodBeat.m2504i(112859);
        this.f2998dg = C5229aj.fromDPToPix(this.mContext, 120);
        this.jkN = C5229aj.fromDPToPix(this.mContext, 20);
        C24104e.m37070a(this, getResources().getDrawable(C25738R.drawable.f6961wx));
        setDescendantFocusability(393216);
        AppMethodBeat.m2505o(112859);
    }

    public void setOptionsArray(String[] strArr) {
        AppMethodBeat.m2504i(112860);
        if (strArr == null) {
            AppMethodBeat.m2505o(112860);
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
        AppMethodBeat.m2505o(112860);
    }

    public final String aRK() {
        AppMethodBeat.m2504i(112861);
        String str;
        if (this.jkM == null || this.jkM.length <= 0) {
            str = "";
            AppMethodBeat.m2505o(112861);
            return str;
        }
        str = this.jkM[getValue()];
        AppMethodBeat.m2505o(112861);
        return str;
    }

    public final void setExtraPadding(int i) {
        AppMethodBeat.m2504i(112862);
        this.jkN = Math.max(i, 0);
        AppMethodBeat.m2505o(112862);
    }

    public final void setMinWidth(int i) {
        this.f2998dg = i;
    }

    public final void setMaxWidth(int i) {
        this.f2999di = i;
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        AppMethodBeat.m2504i(112863);
        super.setDisplayedValues(strArr);
        AppMethodBeat.m2505o(112863);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(112864);
        if (MeasureSpec.getMode(i) == C8415j.INVALID_ID || MeasureSpec.getMode(i) == ErrorDialogData.SUPPRESSED) {
            this.f2999di = MeasureSpec.getSize(i);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), i2);
        if (getMeasuredWidth() > this.f2998dg || (this.f2999di > 0 && this.f2998dg > this.f2999di)) {
            int measuredWidth = getMeasuredWidth() + (this.jkN * 2);
            if (this.f2999di > 0 && this.f2999di <= measuredWidth) {
                measuredWidth = this.f2999di;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            AppMethodBeat.m2505o(112864);
            return;
        }
        setMeasuredDimension(this.f2998dg, getMeasuredHeight());
        AppMethodBeat.m2505o(112864);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(112865);
        super.onAttachedToWindow();
        AppMethodBeat.m2505o(112865);
    }
}
