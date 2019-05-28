package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.input.p762c.C45723b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.z */
public final class C2583z {
    final C7306ak iGP;
    final Runnable jgA = new C25841();
    public C45723b jgz;
    /* renamed from: tc */
    private final EditText f1260tc;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.z$1 */
    class C25841 implements Runnable {
        C25841() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123828);
            if (C2583z.this.jgz != null) {
                C2583z.this.jgz.aAL();
            }
            AppMethodBeat.m2505o(123828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.z$3 */
    class C25853 implements TextWatcher {
        C25853() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(123832);
            C2583z.this.iGP.removeCallbacks(C2583z.this.jgA);
            AppMethodBeat.m2505o(123832);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.z$2 */
    class C25862 implements SpanWatcher {
        C25862() {
        }

        public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            AppMethodBeat.m2504i(123829);
            if (C45720aj.m84474bM(obj)) {
                C4990ab.m7411d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", spannable, obj.getClass().getSimpleName());
            }
            AppMethodBeat.m2505o(123829);
        }

        public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            AppMethodBeat.m2504i(123830);
            if (C45720aj.m84474bM(obj)) {
                C4990ab.m7411d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", spannable, obj.getClass().getSimpleName());
                C2583z.this.iGP.removeCallbacks(C2583z.this.jgA);
                C2583z.this.iGP.postDelayed(C2583z.this.jgA, 100);
            }
            AppMethodBeat.m2505o(123830);
        }

        public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(123831);
            if (C45720aj.m84474bM(obj)) {
                C4990ab.m7411d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", spannable, obj.getClass().getSimpleName());
            }
            AppMethodBeat.m2505o(123831);
        }
    }

    public C2583z(EditText editText) {
        AppMethodBeat.m2504i(123833);
        this.f1260tc = editText;
        this.iGP = new C7306ak(Looper.getMainLooper());
        AppMethodBeat.m2505o(123833);
    }

    /* renamed from: c */
    public final Editable mo6631c(Editable editable) {
        AppMethodBeat.m2504i(123834);
        editable.setSpan(new C25862(), 0, editable.length(), 18);
        editable.setSpan(new C25853(), 0, editable.length(), 18);
        AppMethodBeat.m2505o(123834);
        return editable;
    }
}
