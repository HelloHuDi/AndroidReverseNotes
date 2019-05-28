package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.LinkedList;

/* renamed from: com.tencent.neattextview.textview.layout.d */
public final class C7378d implements C5783b {
    private static Comparator<Integer> AkA = new C57841();
    private static final TextPaint Akz = new TextPaint(1);
    private C7377c AkB;
    private char[] AkC;
    private int AkD;
    private float AkE;
    private boolean AkF;
    private float AkG = -1.0f;
    private float AkH = 0.0f;
    private float AkI = 0.0f;
    private RectF AkJ = new RectF();
    private RectF AkK = new RectF();
    private LinkedList<Integer> AkL = null;
    private float AkM;
    private float[] Akb;
    private int Akm;
    /* renamed from: Ls */
    public int f2011Ls;
    public int aqm;
    private float mHeight;
    private float mWidth;

    /* renamed from: com.tencent.neattextview.textview.layout.d$1 */
    static class C57841 implements Comparator<Integer> {
        C57841() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(3243);
            int intValue = ((Integer) obj).intValue() - ((Integer) obj2).intValue();
            AppMethodBeat.m2505o(3243);
            return intValue;
        }
    }

    static {
        AppMethodBeat.m2504i(3255);
        AppMethodBeat.m2505o(3255);
    }

    public C7378d(C7377c c7377c, char[] cArr, int i, int i2, float f, float[] fArr, float f2, float f3, float f4, TextPaint textPaint, boolean z, float f5, int i3, int i4, float f6) {
        AppMethodBeat.m2504i(3244);
        this.AkB = c7377c;
        this.AkC = cArr;
        this.aqm = i;
        this.f2011Ls = i2;
        this.AkD = i3;
        this.Akb = fArr;
        this.AkE = f4;
        this.AkH = f5;
        this.AkF = z;
        this.mHeight = f3;
        this.mWidth = f2;
        this.AkI = f6;
        this.Akm = i4;
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f7 = fontMetrics.leading - fontMetrics.top;
        float f8 = fontMetrics.bottom - fontMetrics.leading;
        this.AkM = ((((this.mHeight - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        this.AkJ.set(0.0f, this.AkM - f7, 0.0f + f2, f8 + this.AkM);
        this.AkK.set(0.0f, this.AkM - f7, 0.0f + f6, this.AkJ.top + this.mHeight);
        AppMethodBeat.m2505o(3244);
    }

    /* renamed from: a */
    public final void mo11849a(Canvas canvas, TextPaint textPaint, float f) {
        AppMethodBeat.m2504i(3245);
        float dPl = 0.0f + dPl();
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = ((((this.mHeight - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        int i = this.aqm;
        int i2 = this.f2011Ls;
        int[] iArr = this.AkB.Akv.AkR;
        int[] iArr2 = this.AkB.Akv.AkS;
        LineBackgroundSpan[] lineBackgroundSpanArr = (LineBackgroundSpan[]) this.AkB.Akv.AkQ;
        LinkedList<LineBackgroundSpan> linkedList = new LinkedList();
        int i3 = 0;
        while (i3 < this.AkB.Akv.AkP) {
            if (iArr[i3] < i2 && iArr2[i3] > i) {
                linkedList.add(lineBackgroundSpanArr[i3]);
            }
            i3++;
        }
        for (LineBackgroundSpan drawBackground : linkedList) {
            drawBackground.drawBackground(canvas, textPaint, (int) this.AkJ.left, (int) this.AkJ.right, (int) this.AkJ.top, (int) f2, (int) this.AkJ.bottom, this.AkB.getText(), this.aqm, this.f2011Ls, this.AkD);
        }
        i = this.aqm;
        Object obj = null;
        float f3 = f2;
        float f4 = dPl;
        for (int i4 = this.aqm; i4 < this.f2011Ls; i4++) {
            if (i4 + 1 < this.f2011Ls) {
                if (this.Akb[i4 + 1] != 0.0f) {
                    if (obj == null) {
                        obj = (this.AkF && this.Akb[i4 + 1] == this.AkH) ? 1 : null;
                        if (obj != null) {
                        }
                    }
                }
            }
            Object obj2 = obj;
            int i5 = i4 + 1;
            ImageSpan imageSpan = (ImageSpan) this.AkB.Akp.mo11864hS(i, i5);
            if (imageSpan != null) {
                Akz.set(textPaint);
                imageSpan.draw(canvas, "", i, i5, f4, 0, (int) f3, (int) (this.mHeight + f), Akz);
            } else {
                float f5;
                Object obj3 = null;
                Akz.set(textPaint);
                AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) this.AkB.Akq.mo11864hS(i, i5);
                if (absoluteSizeSpan != null) {
                    obj3 = 1;
                    absoluteSizeSpan.updateDrawState(Akz);
                }
                RelativeSizeSpan relativeSizeSpan = (RelativeSizeSpan) this.AkB.Akr.mo11864hS(i, i5);
                if (relativeSizeSpan != null) {
                    obj3 = 1;
                    relativeSizeSpan.updateDrawState(Akz);
                }
                ForegroundColorSpan foregroundColorSpan = (ForegroundColorSpan) this.AkB.Akt.mo11864hS(i, i5);
                if (foregroundColorSpan != null) {
                    foregroundColorSpan.updateDrawState(Akz);
                }
                ClickableSpan clickableSpan = (ClickableSpan) this.AkB.Aku.mo11864hS(i, i5);
                if (clickableSpan != null) {
                    clickableSpan.updateDrawState(Akz);
                }
                if (obj3 != null) {
                    f5 = ((((this.mHeight - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
                } else {
                    f5 = f3;
                }
                canvas.drawText(this.AkC, i, i5 - i, f4, f5, Akz);
                f3 = f5;
            }
            if (obj2 != null) {
                f4 += this.AkH;
            }
            obj = null;
            f4 += this.Akb[i] + this.AkE;
            i = i5;
        }
        AppMethodBeat.m2505o(3245);
    }

    public final float getHeight() {
        return this.mHeight;
    }

    public final float getWidth() {
        return this.mWidth;
    }

    public final float[] dPg() {
        return this.Akb;
    }

    public final RectF dPi() {
        return this.AkK;
    }

    /* renamed from: hR */
    public final RectF mo15915hR(int i, int i2) {
        AppMethodBeat.m2504i(3246);
        RectF rectF = new RectF();
        if (i >= i2) {
            AppMethodBeat.m2505o(3246);
        } else {
            float dPl = dPl();
            for (int i3 = this.aqm; i3 < i; i3++) {
                dPl += this.Akb[i3] + this.AkE;
            }
            float f = dPl;
            while (i < i2) {
                f += this.Akb[i] + this.AkE;
                i++;
            }
            rectF.set(dPl, this.AkJ.top, f, this.AkJ.bottom);
            AppMethodBeat.m2505o(3246);
        }
        return rectF;
    }

    public final RectF dPh() {
        return this.AkJ;
    }

    public final int getStart() {
        return this.aqm;
    }

    public final int getEnd() {
        return this.f2011Ls;
    }

    public final float dPj() {
        return this.AkE;
    }

    public final boolean dPk() {
        return this.AkF;
    }

    public final float dPl() {
        AppMethodBeat.m2504i(3247);
        float f;
        if (this.AkG != -1.0f) {
            f = this.AkG;
            AppMethodBeat.m2505o(3247);
            return f;
        }
        if ((this.Akm & 7) == 1) {
            int i = this.aqm;
            int i2 = this.aqm;
            float f2 = 0.0f;
            while (i2 < this.f2011Ls) {
                if (i2 + 1 >= this.f2011Ls || this.Akb[i2 + 1] != 0.0f) {
                    f2 += this.Akb[i] + this.AkE;
                    i = i2 + 1;
                }
                i2++;
            }
            f = (this.AkI - f2) / 2.0f;
        } else {
            f = 0.0f;
        }
        float max = Math.max(0.0f, f);
        if (this.AkB.Akp.mo11864hS(this.aqm, this.aqm + 1) == null && this.AkB.dPp().containsKey(Character.valueOf(this.AkC[this.aqm]))) {
            f = max - ((Float) this.AkB.dPp().get(Character.valueOf(this.AkC[this.aqm]))).floatValue();
            this.AkG = f;
            AppMethodBeat.m2505o(3247);
            return f;
        }
        this.AkG = max;
        f = this.AkG;
        AppMethodBeat.m2505o(3247);
        return f;
    }

    public final float dPm() {
        return this.AkM;
    }

    public final float getPrimaryHorizontal(int i) {
        AppMethodBeat.m2504i(3248);
        float dPl = this.AkJ.left + dPl();
        int i2 = this.aqm;
        int i3 = this.aqm;
        Object obj = null;
        while (i3 < this.f2011Ls && i3 < i) {
            if (i3 + 1 < this.f2011Ls) {
                if (this.Akb[i3 + 1] != 0.0f) {
                    if (obj == null) {
                        if (this.AkF && this.Akb[i3 + 1] == this.AkH) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                        }
                    }
                }
                i3++;
            }
            int i4 = i3 + 1;
            if (obj != null) {
                dPl += this.AkH;
            }
            dPl += this.Akb[i2] + this.AkE;
            obj = null;
            i2 = i4;
            i3++;
        }
        AppMethodBeat.m2505o(3248);
        return dPl;
    }

    /* JADX WARNING: Missing block: B:13:0x003f, code skipped:
            if (r1 != null) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: QU */
    public final int mo11848QU(int i) {
        AppMethodBeat.m2504i(3249);
        int i2 = this.aqm;
        float dPl = this.AkJ.left + dPl();
        int i3 = this.aqm;
        int i4 = this.aqm;
        Object obj = null;
        while (i4 < this.f2011Ls) {
            if (i4 + 1 < this.f2011Ls) {
                if (this.Akb[i4 + 1] != 0.0f) {
                    if (obj == null) {
                        if (this.AkF && this.Akb[i4 + 1] == this.AkH) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                }
                i2++;
                i4++;
            }
            int i5 = i4 + 1;
            if (obj != null) {
                dPl += this.AkH;
            }
            float f = dPl + (this.Akb[i3] + this.AkE);
            if (dPl <= ((float) i) && ((float) i) < f) {
                AppMethodBeat.m2505o(3249);
                return i2;
            } else if (dPl > ((float) i)) {
                i2 = this.aqm;
                AppMethodBeat.m2505o(3249);
                return i2;
            } else if (((float) i) <= this.AkJ.right) {
                i2++;
                obj = null;
                i3 = i5;
                dPl = f;
                i4++;
            } else if (this.f2011Ls == this.AkC.length) {
                i2 = this.f2011Ls;
                AppMethodBeat.m2505o(3249);
                return i2;
            } else {
                i2 = this.f2011Ls - 1;
                AppMethodBeat.m2505o(3249);
                return i2;
            }
        }
        i2 = this.f2011Ls;
        AppMethodBeat.m2505o(3249);
        return i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(3250);
        if (obj == null) {
            AppMethodBeat.m2505o(3250);
            return false;
        } else if (obj instanceof C5783b) {
            C5783b c5783b = (C5783b) obj;
            if (c5783b.getStart() == this.aqm && c5783b.getEnd() == this.f2011Ls && c5783b.dPh().equals(this.AkJ) && c5783b.dPk() == this.AkF && c5783b.dPj() == this.AkE && c5783b.dPl() == this.AkG) {
                for (int i = this.aqm; i < this.f2011Ls; i++) {
                    if (this.Akb[i] != c5783b.dPg()[i]) {
                        AppMethodBeat.m2505o(3250);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(3250);
                return true;
            }
            AppMethodBeat.m2505o(3250);
            return false;
        } else {
            AppMethodBeat.m2505o(3250);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(3251);
        int hashCode = ((((this.aqm + this.f2011Ls) + ((int) this.mHeight)) + ((int) this.mWidth)) + ((int) this.AkG)) + this.AkJ.hashCode();
        AppMethodBeat.m2505o(3251);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(3252);
        String str = "MeasuredLine{mStart=" + this.aqm + ", mEnd=" + this.f2011Ls + ", mLetter=" + this.AkE + ", isSmartLetter=" + this.AkF + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.AkG + ", mLineRect=" + this.AkJ + ", mLineRect=" + this.AkK + '}';
        AppMethodBeat.m2505o(3252);
        return str;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        AppMethodBeat.m2504i(3253);
        objectOutputStream.writeInt(this.aqm);
        objectOutputStream.writeInt(this.f2011Ls);
        objectOutputStream.writeObject(this.Akb);
        objectOutputStream.writeFloat(this.AkJ.left);
        objectOutputStream.writeFloat(this.AkJ.top);
        objectOutputStream.writeFloat(this.AkJ.right);
        objectOutputStream.writeFloat(this.AkJ.bottom);
        objectOutputStream.writeBoolean(this.AkF);
        objectOutputStream.writeFloat(this.AkE);
        objectOutputStream.writeFloat(dPl());
        AppMethodBeat.m2505o(3253);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.m2504i(3254);
        this.aqm = objectInputStream.readInt();
        this.f2011Ls = objectInputStream.readInt();
        this.Akb = (float[]) objectInputStream.readObject();
        this.AkJ = new RectF(objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat());
        this.AkF = objectInputStream.readBoolean();
        this.AkE = objectInputStream.readFloat();
        this.AkG = objectInputStream.readFloat();
        AppMethodBeat.m2505o(3254);
    }
}
