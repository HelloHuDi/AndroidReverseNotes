package com.tencent.mm.pluginsdk.ui.tools;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.b;

public final class g {
    public static InputFilter[] vuR = new InputFilter[]{new LengthFilter(50)};

    public static class a implements TextWatcher {
        public b vuS = null;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(105867);
            if (this.vuS != null) {
                this.vuS.aqH();
            }
            AppMethodBeat.o(105867);
        }
    }

    static {
        AppMethodBeat.i(105868);
        AppMethodBeat.o(105868);
    }
}
