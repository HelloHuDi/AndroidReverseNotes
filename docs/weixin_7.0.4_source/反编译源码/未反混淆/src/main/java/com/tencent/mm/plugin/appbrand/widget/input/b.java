package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.d.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.g;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

enum b {
    ;

    static <Input extends EditText & ab> void a(Input input, h hVar) {
        AppMethodBeat.i(123575);
        if (input == null || hVar == null) {
            AppMethodBeat.o(123575);
            return;
        }
        if (!(hVar.jjx == null || hVar.jjx.floatValue() == input.getTextSize())) {
            input.setTextSize(hVar.jjx.floatValue());
        }
        if (hVar.jjw != null) {
            input.setTextColor(hVar.jjw.intValue());
        }
        if (hVar.jjv == null) {
            input.setBackground(null);
        } else if (!(input.getBackground() != null && (input.getBackground() instanceof ColorDrawable) && ((ColorDrawable) input.getBackground()).getColor() == hVar.jjv.intValue())) {
            input.setBackground(new ColorDrawable(hVar.jjv.intValue()));
        }
        if (!bo.isNullOrNil(hVar.jjz)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(hVar.jjz);
            int length = hVar.jjz.length();
            spannableStringBuilder.setSpan(new StyleSpan(c.EJ(hVar.jjA).style), 0, length, 18);
            if (hVar.jjC != null) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(hVar.jjC.intValue()), 0, length, 18);
            }
            if (hVar.jjB != null) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(hVar.jjB.intValue(), false), 0, length, 18);
            }
            input.setHint(spannableStringBuilder);
        }
        if (hVar.hdi != null) {
            Typeface create = Typeface.create("sans-serif", c.EJ(hVar.hdi).style);
            if (create != null) {
                input.setTypeface(create);
            }
        }
        g EK = g.EK(hVar.hdq);
        ab abVar = (ab) input;
        if (abVar != null) {
            switch (EK) {
                case LEFT:
                    abVar.aRi();
                    break;
                case RIGHT:
                    abVar.aRj();
                    break;
                case CENTER:
                    abVar.aRk();
                    break;
            }
        }
        input.setVisibility(aj.g(hVar.jjE) ? 8 : 0);
        ((ab) input).setFixed(aj.g(hVar.jjI));
        AppMethodBeat.o(123575);
    }

    static <Input extends EditText & ab> void a(Input input, int i, int i2) {
        AppMethodBeat.i(123576);
        if (input == null || input.getEditableText() == null) {
            ab.w("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", input);
            AppMethodBeat.o(123576);
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
        AppMethodBeat.o(123576);
    }
}
