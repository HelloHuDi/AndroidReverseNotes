package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m extends PasswordTransformationMethod {

    static final class a implements CharSequence {
        private CharSequence jeG;

        a(CharSequence charSequence) {
            this.jeG = charSequence;
        }

        public final int length() {
            AppMethodBeat.i(77425);
            int length = this.jeG.length();
            AppMethodBeat.o(77425);
            return length;
        }

        public final char charAt(int i) {
            return 9679;
        }

        public final CharSequence subSequence(int i, int i2) {
            AppMethodBeat.i(77426);
            CharSequence subSequence = this.jeG.subSequence(i, i2);
            AppMethodBeat.o(77426);
            return subSequence;
        }
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        AppMethodBeat.i(77427);
        a aVar = new a(charSequence);
        AppMethodBeat.o(77427);
        return aVar;
    }
}
