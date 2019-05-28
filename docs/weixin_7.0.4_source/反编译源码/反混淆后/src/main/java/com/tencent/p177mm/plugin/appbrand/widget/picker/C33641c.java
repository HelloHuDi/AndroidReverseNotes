package com.tencent.p177mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C19427b;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.c */
public class C33641c extends YANumberPicker implements C19427b<String> {
    private String[] jkM;
    private int jkO;

    public C33641c(Context context) {
        super(context);
        AppMethodBeat.m2504i(126722);
        setDividerHeight(C1338a.fromDPToPix(context, 2));
        setDividerColor(Color.parseColor("#1AAD19"));
        setItemPaddingVertical(C1338a.fromDPToPix(context, 8));
        setNormalTextColor(Color.parseColor("#A5A5A5"));
        setSelectedTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.m2505o(126722);
    }

    public final void setOptionsArray(String[] strArr) {
        AppMethodBeat.m2504i(126723);
        if (strArr == null || strArr.length <= 0) {
            setEnabled(false);
            setVisibility(4);
            AppMethodBeat.m2505o(126723);
            return;
        }
        setEnabled(true);
        setVisibility(0);
        this.jkM = strArr;
        int minValue = getMinValue();
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > (getMaxValue() - minValue) + 1) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            AppMethodBeat.m2505o(126723);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
        AppMethodBeat.m2505o(126723);
    }

    public final void setForceWidth(int i) {
        this.jkO = i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(126724);
        if (this.jkO > 0) {
            i = MeasureSpec.makeMeasureSpec(this.jkO, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(126724);
    }

    public final View getView() {
        return this;
    }

    /* renamed from: a */
    public final void mo22726a(C33642d c33642d) {
    }

    public final void aEH() {
        AppMethodBeat.m2504i(126725);
        aRX();
        AppMethodBeat.m2505o(126725);
    }

    /* renamed from: b */
    public final void mo22731b(C33642d c33642d) {
    }

    public final void aEI() {
    }

    public final /* synthetic */ Object aEG() {
        AppMethodBeat.m2504i(126726);
        if (this.jkM == null || this.jkM.length <= 0) {
            String str = "";
            AppMethodBeat.m2505o(126726);
            return str;
        }
        Object obj = this.jkM[getValue()];
        AppMethodBeat.m2505o(126726);
        return obj;
    }
}
