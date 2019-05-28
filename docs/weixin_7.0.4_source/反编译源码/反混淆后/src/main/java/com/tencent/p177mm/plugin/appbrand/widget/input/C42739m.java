package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.m */
public final class C42739m extends PasswordTransformationMethod {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.m$a */
    static final class C11024a implements CharSequence {
        private CharSequence jeG;

        C11024a(CharSequence charSequence) {
            this.jeG = charSequence;
        }

        public final int length() {
            AppMethodBeat.m2504i(77425);
            int length = this.jeG.length();
            AppMethodBeat.m2505o(77425);
            return length;
        }

        public final char charAt(int i) {
            return 9679;
        }

        public final CharSequence subSequence(int i, int i2) {
            AppMethodBeat.m2504i(77426);
            CharSequence subSequence = this.jeG.subSequence(i, i2);
            AppMethodBeat.m2505o(77426);
            return subSequence;
        }
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        AppMethodBeat.m2504i(77427);
        C11024a c11024a = new C11024a(charSequence);
        AppMethodBeat.m2505o(77427);
        return c11024a;
    }
}
