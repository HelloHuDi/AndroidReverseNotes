package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C11017h;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C2573g;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33625c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.b */
enum C27407b {
    ;

    /* renamed from: a */
    static <Input extends EditText & C38595ab> void m43487a(Input input, C11017h c11017h) {
        AppMethodBeat.m2504i(123575);
        if (input == null || c11017h == null) {
            AppMethodBeat.m2505o(123575);
            return;
        }
        if (!(c11017h.jjx == null || c11017h.jjx.floatValue() == input.getTextSize())) {
            input.setTextSize(c11017h.jjx.floatValue());
        }
        if (c11017h.jjw != null) {
            input.setTextColor(c11017h.jjw.intValue());
        }
        if (c11017h.jjv == null) {
            input.setBackground(null);
        } else if (!(input.getBackground() != null && (input.getBackground() instanceof ColorDrawable) && ((ColorDrawable) input.getBackground()).getColor() == c11017h.jjv.intValue())) {
            input.setBackground(new ColorDrawable(c11017h.jjv.intValue()));
        }
        if (!C5046bo.isNullOrNil(c11017h.jjz)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c11017h.jjz);
            int length = c11017h.jjz.length();
            spannableStringBuilder.setSpan(new StyleSpan(C33625c.m54896EJ(c11017h.jjA).style), 0, length, 18);
            if (c11017h.jjC != null) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(c11017h.jjC.intValue()), 0, length, 18);
            }
            if (c11017h.jjB != null) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(c11017h.jjB.intValue(), false), 0, length, 18);
            }
            input.setHint(spannableStringBuilder);
        }
        if (c11017h.hdi != null) {
            Typeface create = Typeface.create("sans-serif", C33625c.m54896EJ(c11017h.hdi).style);
            if (create != null) {
                input.setTypeface(create);
            }
        }
        C2573g EK = C2573g.m4818EK(c11017h.hdq);
        C38595ab c38595ab = (C38595ab) input;
        if (c38595ab != null) {
            switch (EK) {
                case LEFT:
                    c38595ab.aRi();
                    break;
                case RIGHT:
                    c38595ab.aRj();
                    break;
                case CENTER:
                    c38595ab.aRk();
                    break;
            }
        }
        input.setVisibility(C45720aj.m84478g(c11017h.jjE) ? 8 : 0);
        ((C38595ab) input).setFixed(C45720aj.m84478g(c11017h.jjI));
        AppMethodBeat.m2505o(123575);
    }

    /* renamed from: a */
    static <Input extends EditText & C38595ab> void m43486a(Input input, int i, int i2) {
        AppMethodBeat.m2504i(123576);
        if (input == null || input.getEditableText() == null) {
            C4990ab.m7421w("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", input);
            AppMethodBeat.m2505o(123576);
            return;
        }
        int selectionStart;
        if (i <= -2) {
            selectionStart = input.getSelectionStart();
        } else if (i == -1 || i > input.getText().length()) {
            selectionStart = input.getText().length();
        } else {
            selectionStart = i;
        }
        int selectionEnd = i2 <= -2 ? input.getSelectionEnd() : (i2 == -1 || i2 > input.getText().length()) ? input.getText().length() : i2;
        if (selectionStart > selectionEnd) {
            selectionStart = selectionEnd;
        }
        Selection.removeSelection(input.getEditableText());
        input.setSelection(selectionStart, selectionEnd);
        AppMethodBeat.m2505o(123576);
    }
}
