package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;
import com.tencent.smtt.sdk.WebView;

public class c extends YANumberPicker implements b<String> {
    private String[] jkM;
    private int jkO;

    public c(Context context) {
        super(context);
        AppMethodBeat.i(126722);
        setDividerHeight(a.fromDPToPix(context, 2));
        setDividerColor(Color.parseColor("#1AAD19"));
        setItemPaddingVertical(a.fromDPToPix(context, 8));
        setNormalTextColor(Color.parseColor("#A5A5A5"));
        setSelectedTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(126722);
    }

    public final void setOptionsArray(String[] strArr) {
        AppMethodBeat.i(126723);
        if (strArr == null || strArr.length <= 0) {
            setEnabled(false);
            setVisibility(4);
            AppMethodBeat.o(126723);
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
            AppMethodBeat.o(126723);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
        AppMethodBeat.o(126723);
    }

    public final void setForceWidth(int i) {
        this.jkO = i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(126724);
        if (this.jkO > 0) {
            i = MeasureSpec.makeMeasureSpec(this.jkO, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(126724);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void aEH() {
        AppMethodBeat.i(126725);
        aRX();
        AppMethodBeat.o(126725);
    }

    public final void b(d dVar) {
    }

    public final void aEI() {
    }

    public final /* synthetic */ Object aEG() {
        AppMethodBeat.i(126726);
        if (this.jkM == null || this.jkM.length <= 0) {
            String str = "";
            AppMethodBeat.o(126726);
            return str;
        }
        Object obj = this.jkM[getValue()];
        AppMethodBeat.o(126726);
        return obj;
    }
}
