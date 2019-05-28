package com.tencent.p177mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.p057v4.widget.C8415j;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.picker.C24104e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C19427b;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker */
public class AppBrandOptionsPicker extends NumberPicker implements C19427b<String> {
    /* renamed from: dg */
    private int f2886dg;
    /* renamed from: di */
    private int f2887di;
    private String[] jkM;
    private int jkN;

    public final /* synthetic */ Object aEG() {
        AppMethodBeat.m2504i(126721);
        String aRK = aRK();
        AppMethodBeat.m2505o(126721);
        return aRK;
    }

    @Keep
    public AppBrandOptionsPicker(Context context) {
        super(new ContextThemeWrapper(context, C25738R.style.f11314wg));
        AppMethodBeat.m2504i(126714);
        C24104e.m37070a(this, getResources().getDrawable(C25738R.drawable.f6395cr));
        C24104e.m37072c(this);
        C24104e.m37074e(this);
        C2590e.m4839a(this);
        this.f2886dg = C1338a.fromDPToPix(context, 100);
        this.jkN = C1338a.fromDPToPix(context, 20);
        AppMethodBeat.m2505o(126714);
    }

    public void setOptionsArray(String[] strArr) {
        AppMethodBeat.m2504i(126715);
        if (strArr == null) {
            AppMethodBeat.m2505o(126715);
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
        AppMethodBeat.m2505o(126715);
    }

    public final void setExtraPadding(int i) {
        AppMethodBeat.m2504i(126716);
        this.jkN = Math.max(i, 0);
        AppMethodBeat.m2505o(126716);
    }

    public final void setMinWidth(int i) {
        this.f2886dg = i;
    }

    public final void setMaxWidth(int i) {
        this.f2887di = i;
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        AppMethodBeat.m2504i(126717);
        super.setDisplayedValues(strArr);
        AppMethodBeat.m2505o(126717);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(126718);
        if (MeasureSpec.getMode(i) == C8415j.INVALID_ID || MeasureSpec.getMode(i) == ErrorDialogData.SUPPRESSED) {
            this.f2887di = MeasureSpec.getSize(i);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), i2);
        if (getMeasuredWidth() > this.f2886dg || (this.f2887di > 0 && this.f2886dg > this.f2887di)) {
            int measuredWidth = getMeasuredWidth() + (this.jkN * 2);
            if (this.f2887di > 0 && this.f2887di <= measuredWidth) {
                measuredWidth = this.f2887di;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            AppMethodBeat.m2505o(126718);
            return;
        }
        setMeasuredDimension(this.f2886dg, getMeasuredHeight());
        AppMethodBeat.m2505o(126718);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(126719);
        super.onAttachedToWindow();
        C24104e.m37073d(this);
        AppMethodBeat.m2505o(126719);
    }

    public final String aRK() {
        AppMethodBeat.m2504i(126720);
        String str;
        if (this.jkM == null || this.jkM.length <= 0) {
            str = "";
            AppMethodBeat.m2505o(126720);
            return str;
        }
        str = this.jkM[getValue()];
        AppMethodBeat.m2505o(126720);
        return str;
    }

    public View getView() {
        return this;
    }

    /* renamed from: a */
    public final void mo22726a(C33642d c33642d) {
    }

    public final void aEH() {
    }

    /* renamed from: b */
    public final void mo22731b(C33642d c33642d) {
    }

    public final void aEI() {
    }
}
