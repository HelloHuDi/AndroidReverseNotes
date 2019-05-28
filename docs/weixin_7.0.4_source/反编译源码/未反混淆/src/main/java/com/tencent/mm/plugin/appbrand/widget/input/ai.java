package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.NoCopySpan;
import android.text.Spannable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ai {

    static class a implements NoCopySpan {
        public boolean arP;
        public float avX;
        public float avY;
        public int jgV;
        public int jgW;
        public boolean jgX;
        public boolean jgY;
        @Deprecated
        public boolean jgZ;

        public a(float f, float f2, int i, int i2) {
            this.avX = f;
            this.avY = f2;
            this.jgV = i;
            this.jgW = i2;
        }
    }

    static a[] g(TextView textView) {
        int i = 0;
        AppMethodBeat.i(77441);
        a[] aVarArr = null;
        if (textView != null && (textView.getText() instanceof Spannable)) {
            Spannable spannable = (Spannable) textView.getText();
            aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
            int length = aVarArr.length;
            while (i < length) {
                spannable.removeSpan(aVarArr[i]);
                i++;
            }
        }
        AppMethodBeat.o(77441);
        return aVarArr;
    }
}
