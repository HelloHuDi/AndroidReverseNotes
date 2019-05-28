package com.tencent.mm.pluginsdk.ui.e;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k implements GetChars, Spannable, CharSequence {
    private SpannableString vrZ;

    public k() {
        AppMethodBeat.i(79850);
        this.vrZ = null;
        this.vrZ = new SpannableString("");
        AppMethodBeat.o(79850);
    }

    public k(CharSequence charSequence) {
        AppMethodBeat.i(79851);
        this.vrZ = null;
        this.vrZ = new SpannableString(charSequence);
        AppMethodBeat.o(79851);
    }

    public k(String str) {
        AppMethodBeat.i(79852);
        this.vrZ = null;
        this.vrZ = new SpannableString(str);
        AppMethodBeat.o(79852);
    }

    public k(SpannableString spannableString) {
        this.vrZ = null;
        this.vrZ = spannableString;
    }

    public final void a(Object obj, CharSequence charSequence, int i) {
        AppMethodBeat.i(79853);
        a(obj, i, charSequence.length() + i, 33);
        AppMethodBeat.o(79853);
    }

    public final void a(Object obj, CharSequence charSequence) {
        AppMethodBeat.i(139138);
        a(obj, charSequence, 0);
        AppMethodBeat.o(139138);
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        AppMethodBeat.i(79855);
        a(obj, i, i2, i3);
        AppMethodBeat.o(79855);
    }

    private void a(Object obj, int i, int i2, int i3) {
        AppMethodBeat.i(79856);
        if (i >= 0 && i2 <= this.vrZ.length()) {
            this.vrZ.setSpan(obj, i, i2, i3);
        }
        AppMethodBeat.o(79856);
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        AppMethodBeat.i(79857);
        Object[] spans = this.vrZ.getSpans(i, i2, cls);
        AppMethodBeat.o(79857);
        return spans;
    }

    public final int getSpanStart(Object obj) {
        AppMethodBeat.i(79858);
        int spanStart = this.vrZ.getSpanStart(obj);
        AppMethodBeat.o(79858);
        return spanStart;
    }

    public final int getSpanEnd(Object obj) {
        AppMethodBeat.i(79859);
        int spanEnd = this.vrZ.getSpanEnd(obj);
        AppMethodBeat.o(79859);
        return spanEnd;
    }

    public final int getSpanFlags(Object obj) {
        AppMethodBeat.i(79860);
        int spanFlags = this.vrZ.getSpanFlags(obj);
        AppMethodBeat.o(79860);
        return spanFlags;
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        AppMethodBeat.i(79861);
        int nextSpanTransition = this.vrZ.nextSpanTransition(i, i2, cls);
        AppMethodBeat.o(79861);
        return nextSpanTransition;
    }

    public final int length() {
        AppMethodBeat.i(79862);
        int length = this.vrZ.length();
        AppMethodBeat.o(79862);
        return length;
    }

    public final char charAt(int i) {
        AppMethodBeat.i(79863);
        char charAt = this.vrZ.charAt(i);
        AppMethodBeat.o(79863);
        return charAt;
    }

    public final CharSequence subSequence(int i, int i2) {
        AppMethodBeat.i(79864);
        CharSequence subSequence = this.vrZ.subSequence(i, i2);
        AppMethodBeat.o(79864);
        return subSequence;
    }

    public final void removeSpan(Object obj) {
        AppMethodBeat.i(79865);
        this.vrZ.removeSpan(obj);
        AppMethodBeat.o(79865);
    }

    public final void getChars(int i, int i2, char[] cArr, int i3) {
        AppMethodBeat.i(79866);
        this.vrZ.getChars(i, i2, cArr, i3);
        AppMethodBeat.o(79866);
    }

    public final String toString() {
        AppMethodBeat.i(79867);
        String spannableString = this.vrZ.toString();
        AppMethodBeat.o(79867);
        return spannableString;
    }
}
