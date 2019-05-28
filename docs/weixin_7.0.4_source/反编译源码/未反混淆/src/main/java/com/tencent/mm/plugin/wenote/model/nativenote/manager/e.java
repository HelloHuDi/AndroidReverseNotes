package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e implements Serializable {
    public int Ls;
    public int aqm;

    public e(int i, int i2) {
        AppMethodBeat.i(26766);
        this.aqm = i;
        this.Ls = i2;
        if (this.aqm > this.Ls) {
            int i3 = this.Ls;
            this.Ls = this.aqm;
            this.aqm = i3;
        }
        AppMethodBeat.o(26766);
    }

    public e(EditText editText) {
        this(editText.getSelectionStart(), editText.getSelectionEnd());
        AppMethodBeat.i(26767);
        AppMethodBeat.o(26767);
    }

    public final boolean isEmpty() {
        return this.aqm == this.Ls;
    }

    public final e gH(int i, int i2) {
        AppMethodBeat.i(26768);
        this.aqm = Math.max(0, this.aqm - i);
        this.Ls += i2;
        AppMethodBeat.o(26768);
        return this;
    }

    public String toString() {
        AppMethodBeat.i(26769);
        String str = "[" + this.aqm + ", " + this.Ls + "]";
        AppMethodBeat.o(26769);
        return str;
    }
}
