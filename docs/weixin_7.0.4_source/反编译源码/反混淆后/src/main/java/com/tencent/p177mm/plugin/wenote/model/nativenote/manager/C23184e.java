package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.e */
public class C23184e implements Serializable {
    /* renamed from: Ls */
    public int f4406Ls;
    public int aqm;

    public C23184e(int i, int i2) {
        AppMethodBeat.m2504i(26766);
        this.aqm = i;
        this.f4406Ls = i2;
        if (this.aqm > this.f4406Ls) {
            int i3 = this.f4406Ls;
            this.f4406Ls = this.aqm;
            this.aqm = i3;
        }
        AppMethodBeat.m2505o(26766);
    }

    public C23184e(EditText editText) {
        this(editText.getSelectionStart(), editText.getSelectionEnd());
        AppMethodBeat.m2504i(26767);
        AppMethodBeat.m2505o(26767);
    }

    public final boolean isEmpty() {
        return this.aqm == this.f4406Ls;
    }

    /* renamed from: gH */
    public final C23184e mo38805gH(int i, int i2) {
        AppMethodBeat.m2504i(26768);
        this.aqm = Math.max(0, this.aqm - i);
        this.f4406Ls += i2;
        AppMethodBeat.m2505o(26768);
        return this;
    }

    public String toString() {
        AppMethodBeat.m2504i(26769);
        String str = "[" + this.aqm + ", " + this.f4406Ls + "]";
        AppMethodBeat.m2505o(26769);
        return str;
    }
}
