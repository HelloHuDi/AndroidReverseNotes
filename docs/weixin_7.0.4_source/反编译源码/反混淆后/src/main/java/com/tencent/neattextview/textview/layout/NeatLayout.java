package com.tencent.neattextview.textview.layout;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.p657a.C5779a;

public class NeatLayout extends C7377c {
    private int AkN = 0;

    private native int nComputeBreak(String str, float[] fArr, float f, float f2, int[] iArr, float[] fArr2, float f3, boolean[] zArr, char[] cArr, float[] fArr3, char[] cArr2, float[] fArr4, boolean[] zArr2);

    static {
        AppMethodBeat.m2504i(3257);
        System.loadLibrary("linebreak");
        AppMethodBeat.m2505o(3257);
    }

    public NeatLayout(CharSequence charSequence, float[] fArr) {
        super(charSequence, fArr);
    }

    /* renamed from: a */
    public final void mo15905a(TextPaint textPaint, float f, int i, boolean z) {
        AppMethodBeat.m2504i(3256);
        float textSize = textPaint.getTextSize() / 2.0f;
        float textSize2 = z ? textPaint.getTextSize() / 6.0f : 0.0f;
        int length = this.AjZ.length();
        int[] iArr = new int[length];
        float[] fArr = new float[length];
        boolean[] zArr = new boolean[length];
        int nComputeBreak = nComputeBreak(this.AjZ, this.Akb, 0.0f, f + textSize, iArr, fArr, textSize2, zArr, C5779a.AjU, this.Ake, C5779a.AjT, this.Akd, this.Aky);
        this.AkN = nComputeBreak;
        float f2 = 0.0f;
        int i2 = 0;
        while (i2 < nComputeBreak && i2 < i) {
            float f3 = fArr[i2];
            if (f2 >= f3) {
                f3 = f2;
            }
            i2++;
            f2 = f3;
        }
        f2 = Math.min(f2, f);
        int i3 = 0;
        int i4 = 0;
        while (i4 < nComputeBreak && i4 < i) {
            float f4;
            int i5 = iArr[i4];
            boolean z2 = zArr[i4];
            length = i5 - i3;
            float f5 = 0.0f;
            float f6 = f - fArr[i4];
            Object obj = Math.abs(f6) <= textSize ? 1 : null;
            if (obj != null) {
                if (i5 - 1 >= 0 && this.Aka[i5 - 1] == 10) {
                    length--;
                }
                i2 = i3;
                while (i2 < i5) {
                    if (this.Aka[i2] != 10 && this.Akb[i2] == 0.0f) {
                        length--;
                    }
                    i2++;
                }
                f5 = f6 / ((float) (Math.max(2, length) - 1));
            }
            float f7 = obj != null ? f : fArr[i4];
            char[] cArr = this.Aka;
            float[] fArr2 = this.Akb;
            int size = this.Akg.size();
            if (obj != null) {
                f4 = f;
            } else {
                f4 = f2;
            }
            mo15906a(cArr, i3, i5, f7, fArr2, size, f5, z2, textSize2, f4);
            i4++;
            i3 = i5;
        }
        AppMethodBeat.m2505o(3256);
    }

    public final int dPe() {
        return this.AkN;
    }
}
