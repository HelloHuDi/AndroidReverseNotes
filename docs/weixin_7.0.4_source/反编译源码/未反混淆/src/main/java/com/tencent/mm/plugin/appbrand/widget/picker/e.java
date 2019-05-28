package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;

final class e {
    static void a(NumberPicker numberPicker) {
        AppMethodBeat.i(126754);
        if (numberPicker == null) {
            AppMethodBeat.o(126754);
            return;
        }
        try {
            EditText editText = (EditText) new c(numberPicker, "mInputText", null).get();
            if (editText != null) {
                editText.setEditableFactory(new Factory() {
                    public final Editable newEditable(CharSequence charSequence) {
                        AppMethodBeat.i(126753);
                        AnonymousClass1 anonymousClass1 = new SpannableStringBuilder(charSequence) {
                            public final void setSpan(Object obj, int i, int i2, int i3) {
                                AppMethodBeat.i(126752);
                                try {
                                    super.setSpan(obj, i, i2, i3);
                                    AppMethodBeat.o(126752);
                                } catch (Exception e) {
                                    AppMethodBeat.o(126752);
                                }
                            }
                        };
                        AppMethodBeat.o(126753);
                        return anonymousClass1;
                    }
                });
            }
            AppMethodBeat.o(126754);
        } catch (Exception e) {
            AppMethodBeat.o(126754);
        }
    }
}
