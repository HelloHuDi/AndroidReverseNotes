package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.a */
public final class C35745a extends SpannableString {
    private int akU;
    private Object[] uOU;
    private int[] uOV;

    public C35745a(CharSequence charSequence) {
        super(charSequence.toString());
        AppMethodBeat.m2504i(26708);
        m58599n(charSequence, charSequence.length());
        AppMethodBeat.m2505o(26708);
    }

    /* renamed from: n */
    private void m58599n(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(26709);
        this.uOU = new Object[20];
        this.uOV = new int[60];
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            for (Object obj : spanned.getSpans(0, i, Object.class)) {
                if ((obj instanceof CharacterStyle) || (obj instanceof ParagraphStyle)) {
                    int spanStart = spanned.getSpanStart(obj);
                    int spanEnd = spanned.getSpanEnd(obj);
                    int spanFlags = spanned.getSpanFlags(obj);
                    if (spanStart < 0) {
                        spanStart = 0;
                    }
                    if (spanEnd > i) {
                        spanEnd = i;
                    }
                    setSpan(obj, spanStart + 0, spanEnd + 0, spanFlags);
                }
            }
        }
        AppMethodBeat.m2505o(26709);
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        AppMethodBeat.m2504i(26710);
        if (this.akU + 1 >= this.uOU.length) {
            int i4 = this.akU + 10;
            Object[] objArr = new Object[i4];
            int[] iArr = new int[(i4 * 3)];
            System.arraycopy(this.uOU, 0, objArr, 0, this.akU);
            System.arraycopy(this.uOV, 0, iArr, 0, this.akU * 3);
            this.uOU = objArr;
            this.uOV = iArr;
        }
        this.uOU[this.akU] = obj;
        this.uOV[(this.akU * 3) + 0] = i;
        this.uOV[(this.akU * 3) + 1] = i2;
        this.uOV[(this.akU * 3) + 2] = i3;
        this.akU++;
        AppMethodBeat.m2505o(26710);
    }

    public final void removeSpan(Object obj) {
        AppMethodBeat.m2504i(26711);
        int i = this.akU;
        Object[] objArr = this.uOU;
        int[] iArr = this.uOV;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (objArr[i2] == obj) {
                i -= i2 + 1;
                System.arraycopy(objArr, i2 + 1, objArr, i2, i);
                System.arraycopy(iArr, (i2 + 1) * 3, iArr, i2 * 3, i * 3);
                this.akU--;
                AppMethodBeat.m2505o(26711);
                return;
            }
        }
        AppMethodBeat.m2505o(26711);
    }

    public final int getSpanStart(Object obj) {
        int i = this.akU;
        Object[] objArr = this.uOU;
        int[] iArr = this.uOV;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 0];
            }
        }
        return -1;
    }

    public final int getSpanEnd(Object obj) {
        int i = this.akU;
        Object[] objArr = this.uOU;
        int[] iArr = this.uOV;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 1];
            }
        }
        return -1;
    }

    public final int getSpanFlags(Object obj) {
        int i = this.akU;
        Object[] objArr = this.uOU;
        int[] iArr = this.uOV;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 2];
            }
        }
        return 0;
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        AppMethodBeat.m2504i(26712);
        int i3 = 0;
        int i4 = this.akU;
        Object[] objArr = this.uOU;
        int[] iArr = this.uOV;
        Object obj = null;
        Object obj2 = null;
        int i5 = 0;
        while (i5 < i4) {
            if (cls == null || cls.isInstance(objArr[i5])) {
                int i6 = iArr[(i5 * 3) + 0];
                int i7 = iArr[(i5 * 3) + 1];
                if (i6 <= i2 && i7 >= i && (i6 == i7 || i == i2 || !(i6 == i2 || i7 == i))) {
                    if (i3 == 0) {
                        obj2 = objArr[i5];
                        i3++;
                    } else {
                        if (i3 == 1) {
                            obj = (Object[]) Array.newInstance(cls, (i4 - i5) + 1);
                            obj[0] = obj2;
                        }
                        i7 = 16711680 & iArr[(i5 * 3) + 2];
                        if (i7 != 0) {
                            i6 = 0;
                            while (i6 < i3 && i7 <= (getSpanFlags(obj[i6]) & 16711680)) {
                                i6++;
                            }
                            System.arraycopy(obj, i6, obj, i6 + 1, i3 - i6);
                            obj[i6] = objArr[i5];
                            i3++;
                        } else {
                            i6 = i3 + 1;
                            obj[i3] = objArr[i5];
                            i3 = i6;
                        }
                    }
                }
            }
            i5++;
        }
        Object[] objArr2;
        if (i3 == 0) {
            objArr2 = (Object[]) Array.newInstance(cls, 0);
            AppMethodBeat.m2505o(26712);
            return objArr2;
        } else if (i3 == 1) {
            objArr2 = (Object[]) Array.newInstance(cls, 1);
            objArr2[0] = obj2;
            objArr2 = objArr2;
            AppMethodBeat.m2505o(26712);
            return objArr2;
        } else if (i3 == obj.length) {
            objArr2 = (Object[]) obj;
            AppMethodBeat.m2505o(26712);
            return objArr2;
        } else {
            Object[] objArr3 = (Object[]) Array.newInstance(cls, i3);
            System.arraycopy(obj, 0, objArr3, 0, i3);
            T[] tArr = objArr3;
            AppMethodBeat.m2505o(26712);
            return tArr;
        }
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        AppMethodBeat.m2504i(26713);
        int i3 = this.akU;
        Object[] objArr = this.uOU;
        int[] iArr = this.uOV;
        if (cls == null) {
            cls = Object.class;
        }
        int i4 = 0;
        int i5 = i2;
        while (i4 < i3) {
            int i6 = iArr[(i4 * 3) + 0];
            int i7 = iArr[(i4 * 3) + 1];
            if (i6 <= i || i6 >= i5 || !cls.isInstance(objArr[i4])) {
                i6 = i5;
            }
            if (i7 <= i || i7 >= i6 || !cls.isInstance(objArr[i4])) {
                i7 = i6;
            }
            i4++;
            i5 = i7;
        }
        AppMethodBeat.m2505o(26713);
        return i5;
    }
}
