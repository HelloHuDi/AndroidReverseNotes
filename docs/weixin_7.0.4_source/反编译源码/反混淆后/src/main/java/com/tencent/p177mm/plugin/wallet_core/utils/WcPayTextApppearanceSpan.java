package com.tencent.p177mm.plugin.wallet_core.utils;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan */
public class WcPayTextApppearanceSpan extends TextAppearanceSpan {
    Typeface tPl;

    public WcPayTextApppearanceSpan(int i, ColorStateList colorStateList) {
        super(null, 0, i, colorStateList, null);
    }

    public void updateMeasureState(TextPaint textPaint) {
        AppMethodBeat.m2504i(48015);
        super.updateMeasureState(textPaint);
        if (this.tPl != null) {
            textPaint.setTypeface(this.tPl);
        }
        AppMethodBeat.m2505o(48015);
    }
}
