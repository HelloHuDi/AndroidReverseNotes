package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class z {
    final ak iGP;
    final Runnable jgA = new Runnable() {
        public final void run() {
            AppMethodBeat.i(123828);
            if (z.this.jgz != null) {
                z.this.jgz.aAL();
            }
            AppMethodBeat.o(123828);
        }
    };
    public b jgz;
    private final EditText tc;

    public z(EditText editText) {
        AppMethodBeat.i(123833);
        this.tc = editText;
        this.iGP = new ak(Looper.getMainLooper());
        AppMethodBeat.o(123833);
    }

    public final Editable c(Editable editable) {
        AppMethodBeat.i(123834);
        editable.setSpan(new SpanWatcher() {
            public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
                AppMethodBeat.i(123829);
                if (aj.bM(obj)) {
                    ab.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", spannable, obj.getClass().getSimpleName());
                }
                AppMethodBeat.o(123829);
            }

            public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
                AppMethodBeat.i(123830);
                if (aj.bM(obj)) {
                    ab.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", spannable, obj.getClass().getSimpleName());
                    z.this.iGP.removeCallbacks(z.this.jgA);
                    z.this.iGP.postDelayed(z.this.jgA, 100);
                }
                AppMethodBeat.o(123830);
            }

            public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
                AppMethodBeat.i(123831);
                if (aj.bM(obj)) {
                    ab.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", spannable, obj.getClass().getSimpleName());
                }
                AppMethodBeat.o(123831);
            }
        }, 0, editable.length(), 18);
        editable.setSpan(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(123832);
                z.this.iGP.removeCallbacks(z.this.jgA);
                AppMethodBeat.o(123832);
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        }, 0, editable.length(), 18);
        AppMethodBeat.o(123834);
        return editable;
    }
}
