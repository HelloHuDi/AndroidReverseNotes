package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import java.lang.ref.WeakReference;

public final class p extends c {

    final class b extends f {
        private final int jeY;
        private final com.tencent.mm.ui.tools.f.a jeZ;

        b(int i, com.tencent.mm.ui.tools.f.a aVar) {
            super(i, aVar);
            this.jeY = i;
            this.jeZ = aVar;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5 = 0;
            AppMethodBeat.i(123695);
            if (f.a(spanned.subSequence(0, i3).toString() + spanned.subSequence(i4, spanned.length()).toString(), this.jeZ) + f.a(charSequence.subSequence(i, i2).toString(), this.jeZ) > this.jeY) {
                i5 = 1;
            }
            if (i5 != 0) {
                charSequence = charSequence.subSequence(i, Math.max(i, Math.min(this.jeY - (spanned.length() - (i4 - i3)), i2)));
            }
            if (i5 != 0 && bo.ac(charSequence)) {
                EditText editText = p.this.zIy == null ? null : (EditText) p.this.zIy.get();
                final com.tencent.mm.ui.tools.b.c.a aVar = p.this.zIC;
                if (!(editText == null || aVar == null)) {
                    editText.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(123694);
                            aVar.JX();
                            AppMethodBeat.o(123694);
                        }
                    });
                }
            }
            AppMethodBeat.o(123695);
            return charSequence;
        }
    }

    public static abstract class a implements com.tencent.mm.ui.tools.b.c.a {
        public final void ki(String str) {
        }

        public final void JW() {
        }

        public void JX() {
        }
    }

    private p(WeakReference<EditText> weakReference) {
        super((WeakReference) weakReference);
    }

    public static p a(EditText editText) {
        AppMethodBeat.i(123696);
        p pVar = new p(new WeakReference(editText));
        AppMethodBeat.o(123696);
        return pVar;
    }

    public final f a(int i, com.tencent.mm.ui.tools.f.a aVar) {
        AppMethodBeat.i(123697);
        b bVar = new b(i, aVar);
        AppMethodBeat.o(123697);
        return bVar;
    }
}
