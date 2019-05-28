package com.tencent.mm.cb;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bo;

public final class g implements d {
    private static g xGr;
    private int xGq = 300;

    private g() {
    }

    public static g dqQ() {
        AppMethodBeat.i(62691);
        if (xGr == null) {
            xGr = new g();
        }
        g gVar = xGr;
        AppMethodBeat.o(62691);
        return gVar;
    }

    public final SpannableString o(CharSequence charSequence, int i) {
        AppMethodBeat.i(62692);
        SpannableString spannableString;
        if (charSequence == null || bo.isNullOrNil(charSequence.toString())) {
            spannableString = new SpannableString("");
            AppMethodBeat.o(62692);
            return spannableString;
        }
        spannableString = p(charSequence, i);
        AppMethodBeat.o(62692);
        return spannableString;
    }

    public final SpannableString b(CharSequence charSequence, float f) {
        AppMethodBeat.i(62693);
        SpannableString spannableString;
        if (charSequence == null || bo.isNullOrNil(charSequence.toString())) {
            spannableString = new SpannableString("");
            AppMethodBeat.o(62693);
            return spannableString;
        }
        spannableString = o(charSequence, (int) f);
        AppMethodBeat.o(62693);
        return spannableString;
    }

    private SpannableString p(CharSequence charSequence, int i) {
        AppMethodBeat.i(62694);
        SpannableString spannableString;
        if (charSequence == null || bo.isNullOrNil(charSequence.toString())) {
            spannableString = new SpannableString("");
            AppMethodBeat.o(62694);
            return spannableString;
        }
        SpannableString spannableString2;
        if (charSequence instanceof SpannableString) {
            spannableString2 = (SpannableString) charSequence;
        } else {
            spannableString2 = new SpannableString(charSequence);
        }
        PInt pInt = new PInt();
        pInt.value = this.xGq;
        spannableString = f.dqL().b(b.dqD().a(spannableString2, i, pInt), i, pInt.value);
        AppMethodBeat.o(62694);
        return spannableString;
    }

    public final boolean H(CharSequence charSequence) {
        AppMethodBeat.i(62695);
        boolean anV = f.dqL().anV(charSequence.toString());
        AppMethodBeat.o(62695);
        return anV;
    }

    public final boolean G(CharSequence charSequence) {
        AppMethodBeat.i(62696);
        b.dqD();
        boolean anT = b.anT(charSequence.toString());
        AppMethodBeat.o(62696);
        return anT;
    }
}
