package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.text.NoCopySpan;
import android.text.Spannable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ai */
final class C33618ai {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ai$a */
    static class C33619a implements NoCopySpan {
        public boolean arP;
        public float avX;
        public float avY;
        public int jgV;
        public int jgW;
        public boolean jgX;
        public boolean jgY;
        @Deprecated
        public boolean jgZ;

        public C33619a(float f, float f2, int i, int i2) {
            this.avX = f;
            this.avY = f2;
            this.jgV = i;
            this.jgW = i2;
        }
    }

    /* renamed from: g */
    static C33619a[] m54893g(TextView textView) {
        int i = 0;
        AppMethodBeat.m2504i(77441);
        C33619a[] c33619aArr = null;
        if (textView != null && (textView.getText() instanceof Spannable)) {
            Spannable spannable = (Spannable) textView.getText();
            c33619aArr = (C33619a[]) spannable.getSpans(0, spannable.length(), C33619a.class);
            int length = c33619aArr.length;
            while (i < length) {
                spannable.removeSpan(c33619aArr[i]);
                i++;
            }
        }
        AppMethodBeat.m2505o(77441);
        return c33619aArr;
    }
}
