package com.tencent.p177mm.p211cb;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23303d;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.cb.g */
public final class C9212g implements C23303d {
    private static C9212g xGr;
    private int xGq = 300;

    private C9212g() {
    }

    public static C9212g dqQ() {
        AppMethodBeat.m2504i(62691);
        if (xGr == null) {
            xGr = new C9212g();
        }
        C9212g c9212g = xGr;
        AppMethodBeat.m2505o(62691);
        return c9212g;
    }

    /* renamed from: o */
    public final SpannableString mo20623o(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(62692);
        SpannableString spannableString;
        if (charSequence == null || C5046bo.isNullOrNil(charSequence.toString())) {
            spannableString = new SpannableString("");
            AppMethodBeat.m2505o(62692);
            return spannableString;
        }
        spannableString = m16719p(charSequence, i);
        AppMethodBeat.m2505o(62692);
        return spannableString;
    }

    /* renamed from: b */
    public final SpannableString mo20622b(CharSequence charSequence, float f) {
        AppMethodBeat.m2504i(62693);
        SpannableString spannableString;
        if (charSequence == null || C5046bo.isNullOrNil(charSequence.toString())) {
            spannableString = new SpannableString("");
            AppMethodBeat.m2505o(62693);
            return spannableString;
        }
        spannableString = mo20623o(charSequence, (int) f);
        AppMethodBeat.m2505o(62693);
        return spannableString;
    }

    /* renamed from: p */
    private SpannableString m16719p(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(62694);
        SpannableString spannableString;
        if (charSequence == null || C5046bo.isNullOrNil(charSequence.toString())) {
            spannableString = new SpannableString("");
            AppMethodBeat.m2505o(62694);
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
        spannableString = C26005f.dqL().mo43882b(C37626b.dqD().mo60449a(spannableString2, i, pInt), i, pInt.value);
        AppMethodBeat.m2505o(62694);
        return spannableString;
    }

    /* renamed from: H */
    public final boolean mo20621H(CharSequence charSequence) {
        AppMethodBeat.m2504i(62695);
        boolean anV = C26005f.dqL().anV(charSequence.toString());
        AppMethodBeat.m2505o(62695);
        return anV;
    }

    /* renamed from: G */
    public final boolean mo20620G(CharSequence charSequence) {
        AppMethodBeat.m2504i(62696);
        C37626b.dqD();
        boolean anT = C37626b.anT(charSequence.toString());
        AppMethodBeat.m2505o(62696);
        return anT;
    }
}
