package com.tencent.p177mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C1438c;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.e */
final class C2590e {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.e$1 */
    static class C25891 extends Factory {
        C25891() {
        }

        public final Editable newEditable(CharSequence charSequence) {
            AppMethodBeat.m2504i(126753);
            C25881 c25881 = new SpannableStringBuilder(charSequence) {
                public final void setSpan(Object obj, int i, int i2, int i3) {
                    AppMethodBeat.m2504i(126752);
                    try {
                        super.setSpan(obj, i, i2, i3);
                        AppMethodBeat.m2505o(126752);
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(126752);
                    }
                }
            };
            AppMethodBeat.m2505o(126753);
            return c25881;
        }
    }

    /* renamed from: a */
    static void m4839a(NumberPicker numberPicker) {
        AppMethodBeat.m2504i(126754);
        if (numberPicker == null) {
            AppMethodBeat.m2505o(126754);
            return;
        }
        try {
            EditText editText = (EditText) new C1438c(numberPicker, "mInputText", null).get();
            if (editText != null) {
                editText.setEditableFactory(new C25891());
            }
            AppMethodBeat.m2505o(126754);
        } catch (Exception e) {
            AppMethodBeat.m2505o(126754);
        }
    }
}
