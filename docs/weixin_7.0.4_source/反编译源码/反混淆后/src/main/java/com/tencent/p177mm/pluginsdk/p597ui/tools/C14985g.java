package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5621b;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.g */
public final class C14985g {
    public static InputFilter[] vuR = new InputFilter[]{new LengthFilter(50)};

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.g$a */
    public static class C14984a implements TextWatcher {
        public C5621b vuS = null;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(105867);
            if (this.vuS != null) {
                this.vuS.aqH();
            }
            AppMethodBeat.m2505o(105867);
        }
    }

    static {
        AppMethodBeat.m2504i(105868);
        AppMethodBeat.m2505o(105868);
    }
}
