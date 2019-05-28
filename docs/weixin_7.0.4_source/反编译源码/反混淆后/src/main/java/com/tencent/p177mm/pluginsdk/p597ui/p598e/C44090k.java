package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.k */
public final class C44090k implements GetChars, Spannable, CharSequence {
    private SpannableString vrZ;

    public C44090k() {
        AppMethodBeat.m2504i(79850);
        this.vrZ = null;
        this.vrZ = new SpannableString("");
        AppMethodBeat.m2505o(79850);
    }

    public C44090k(CharSequence charSequence) {
        AppMethodBeat.m2504i(79851);
        this.vrZ = null;
        this.vrZ = new SpannableString(charSequence);
        AppMethodBeat.m2505o(79851);
    }

    public C44090k(String str) {
        AppMethodBeat.m2504i(79852);
        this.vrZ = null;
        this.vrZ = new SpannableString(str);
        AppMethodBeat.m2505o(79852);
    }

    public C44090k(SpannableString spannableString) {
        this.vrZ = null;
        this.vrZ = spannableString;
    }

    /* renamed from: a */
    public final void mo69792a(Object obj, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(79853);
        m79309a(obj, i, charSequence.length() + i, 33);
        AppMethodBeat.m2505o(79853);
    }

    /* renamed from: a */
    public final void mo69791a(Object obj, CharSequence charSequence) {
        AppMethodBeat.m2504i(139138);
        mo69792a(obj, charSequence, 0);
        AppMethodBeat.m2505o(139138);
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        AppMethodBeat.m2504i(79855);
        m79309a(obj, i, i2, i3);
        AppMethodBeat.m2505o(79855);
    }

    /* renamed from: a */
    private void m79309a(Object obj, int i, int i2, int i3) {
        AppMethodBeat.m2504i(79856);
        if (i >= 0 && i2 <= this.vrZ.length()) {
            this.vrZ.setSpan(obj, i, i2, i3);
        }
        AppMethodBeat.m2505o(79856);
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        AppMethodBeat.m2504i(79857);
        Object[] spans = this.vrZ.getSpans(i, i2, cls);
        AppMethodBeat.m2505o(79857);
        return spans;
    }

    public final int getSpanStart(Object obj) {
        AppMethodBeat.m2504i(79858);
        int spanStart = this.vrZ.getSpanStart(obj);
        AppMethodBeat.m2505o(79858);
        return spanStart;
    }

    public final int getSpanEnd(Object obj) {
        AppMethodBeat.m2504i(79859);
        int spanEnd = this.vrZ.getSpanEnd(obj);
        AppMethodBeat.m2505o(79859);
        return spanEnd;
    }

    public final int getSpanFlags(Object obj) {
        AppMethodBeat.m2504i(79860);
        int spanFlags = this.vrZ.getSpanFlags(obj);
        AppMethodBeat.m2505o(79860);
        return spanFlags;
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        AppMethodBeat.m2504i(79861);
        int nextSpanTransition = this.vrZ.nextSpanTransition(i, i2, cls);
        AppMethodBeat.m2505o(79861);
        return nextSpanTransition;
    }

    public final int length() {
        AppMethodBeat.m2504i(79862);
        int length = this.vrZ.length();
        AppMethodBeat.m2505o(79862);
        return length;
    }

    public final char charAt(int i) {
        AppMethodBeat.m2504i(79863);
        char charAt = this.vrZ.charAt(i);
        AppMethodBeat.m2505o(79863);
        return charAt;
    }

    public final CharSequence subSequence(int i, int i2) {
        AppMethodBeat.m2504i(79864);
        CharSequence subSequence = this.vrZ.subSequence(i, i2);
        AppMethodBeat.m2505o(79864);
        return subSequence;
    }

    public final void removeSpan(Object obj) {
        AppMethodBeat.m2504i(79865);
        this.vrZ.removeSpan(obj);
        AppMethodBeat.m2505o(79865);
    }

    public final void getChars(int i, int i2, char[] cArr, int i3) {
        AppMethodBeat.m2504i(79866);
        this.vrZ.getChars(i, i2, cArr, i3);
        AppMethodBeat.m2505o(79866);
    }

    public final String toString() {
        AppMethodBeat.m2504i(79867);
        String spannableString = this.vrZ.toString();
        AppMethodBeat.m2505o(79867);
        return spannableString;
    }
}
