package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.tools.C5584f.C5583a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.p */
public final class C42744p extends C7357c {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.p$b */
    final class C33631b extends C5584f {
        private final int jeY;
        private final C5583a jeZ;

        C33631b(int i, C5583a c5583a) {
            super(i, c5583a);
            this.jeY = i;
            this.jeZ = c5583a;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5 = 0;
            AppMethodBeat.m2504i(123695);
            if (C5584f.m8384a(spanned.subSequence(0, i3).toString() + spanned.subSequence(i4, spanned.length()).toString(), this.jeZ) + C5584f.m8384a(charSequence.subSequence(i, i2).toString(), this.jeZ) > this.jeY) {
                i5 = 1;
            }
            if (i5 != 0) {
                charSequence = charSequence.subSequence(i, Math.max(i, Math.min(this.jeY - (spanned.length() - (i4 - i3)), i2)));
            }
            if (i5 != 0 && C5046bo.m7519ac(charSequence)) {
                EditText editText = C42744p.this.zIy == null ? null : (EditText) C42744p.this.zIy.get();
                final C5581a c5581a = C42744p.this.zIC;
                if (!(editText == null || c5581a == null)) {
                    editText.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(123694);
                            c5581a.mo11316JX();
                            AppMethodBeat.m2505o(123694);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(123695);
            return charSequence;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.p$a */
    public static abstract class C38603a implements C5581a {
        /* renamed from: ki */
        public final void mo11317ki(String str) {
        }

        /* renamed from: JW */
        public final void mo11315JW() {
        }

        /* renamed from: JX */
        public void mo11316JX() {
        }
    }

    private C42744p(WeakReference<EditText> weakReference) {
        super((WeakReference) weakReference);
    }

    /* renamed from: a */
    public static C42744p m75759a(EditText editText) {
        AppMethodBeat.m2504i(123696);
        C42744p c42744p = new C42744p(new WeakReference(editText));
        AppMethodBeat.m2505o(123696);
        return c42744p;
    }

    /* renamed from: a */
    public final C5584f mo15878a(int i, C5583a c5583a) {
        AppMethodBeat.m2504i(123697);
        C33631b c33631b = new C33631b(i, c5583a);
        AppMethodBeat.m2505o(123697);
        return c33631b;
    }
}
