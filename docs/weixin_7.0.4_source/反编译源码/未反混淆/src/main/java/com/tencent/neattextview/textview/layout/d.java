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

public final class d implements b {
    private static Comparator<Integer> AkA = new Comparator<Integer>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(3243);
            int intValue = ((Integer) obj).intValue() - ((Integer) obj2).intValue();
            AppMethodBeat.o(3243);
            return intValue;
        }
    };
    private static final TextPaint Akz = new TextPaint(1);
    private c AkB;
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
    public int Ls;
    public int aqm;
    private float mHeight;
    private float mWidth;

    static {
        AppMethodBeat.i(3255);
        AppMethodBeat.o(3255);
    }

    public d(c cVar, char[] cArr, int i, int i2, float f, float[] fArr, float f2, float f3, float f4, TextPaint textPaint, boolean z, float f5, int i3, int i4, float f6) {
        AppMethodBeat.i(3244);
        this.AkB = cVar;
        this.AkC = cArr;
        this.aqm = i;
        this.Ls = i2;
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
        AppMethodBeat.o(3244);
    }

    public final void a(Canvas canvas, TextPaint textPaint, float f) {
        AppMethodBeat.i(3245);
        float dPl = 0.0f + dPl();
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = ((((this.mHeight - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        int i = this.aqm;
        int i2 = this.Ls;
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
            drawBackground.drawBackground(canvas, textPaint, (int) this.AkJ.left, (int) this.AkJ.right, (int) this.AkJ.top, (int) f2, (int) this.AkJ.bottom, this.AkB.getText(), this.aqm, this.Ls, this.AkD);
        }
        i = this.aqm;
        Object obj = null;
        float f3 = f2;
        float f4 = dPl;
        for (int i4 = this.aqm; i4 < this.Ls; i4++) {
            if (i4 + 1 < this.Ls) {
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
            ImageSpan imageSpan = (ImageSpan) this.AkB.Akp.hS(i, i5);
            if (imageSpan != null) {
                Akz.set(textPaint);
                imageSpan.draw(canvas, "", i, i5, f4, 0, (int) f3, (int) (this.mHeight + f), Akz);
            } else {
                float f5;
                Object obj3 = null;
                Akz.set(textPaint);
                AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) this.AkB.Akq.hS(i, i5);
                if (absoluteSizeSpan != null) {
                    obj3 = 1;
                    absoluteSizeSpan.updateDrawState(Akz);
                }
                RelativeSizeSpan relativeSizeSpan = (RelativeSizeSpan) this.AkB.Akr.hS(i, i5);
                if (relativeSizeSpan != null) {
                    obj3 = 1;
                    relativeSizeSpan.updateDrawState(Akz);
                }
                ForegroundColorSpan foregroundColorSpan = (ForegroundColorSpan) this.AkB.Akt.hS(i, i5);
                if (foregroundColorSpan != null) {
                    foregroundColorSpan.updateDrawState(Akz);
                }
                ClickableSpan clickableSpan = (ClickableSpan) this.AkB.Aku.hS(i, i5);
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
        AppMethodBeat.o(3245);
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

    public final RectF hR(int i, int i2) {
        AppMethodBeat.i(3246);
        RectF rectF = new RectF();
        if (i >= i2) {
            AppMethodBeat.o(3246);
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
            AppMethodBeat.o(3246);
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
        return this.Ls;
    }

    public final float dPj() {
        return this.AkE;
    }

    public final boolean dPk() {
        return this.AkF;
    }

    public final float dPl() {
        AppMethodBeat.i(3247);
        float f;
        if (this.AkG != -1.0f) {
            f = this.AkG;
            AppMethodBeat.o(3247);
            return f;
        }
        if ((this.Akm & 7) == 1) {
            int i = this.aqm;
            int i2 = this.aqm;
            float f2 = 0.0f;
            while (i2 < this.Ls) {
                if (i2 + 1 >= this.Ls || this.Akb[i2 + 1] != 0.0f) {
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
        if (this.AkB.Akp.hS(this.aqm, this.aqm + 1) == null && this.AkB.dPp().containsKey(Character.valueOf(this.AkC[this.aqm]))) {
            f = max - ((Float) this.AkB.dPp().get(Character.valueOf(this.AkC[this.aqm]))).floatValue();
            this.AkG = f;
            AppMethodBeat.o(3247);
            return f;
        }
        this.AkG = max;
        f = this.AkG;
        AppMethodBeat.o(3247);
        return f;
    }

    public final float dPm() {
        return this.AkM;
    }

    public final float getPrimaryHorizontal(int i) {
        AppMethodBeat.i(3248);
        float dPl = this.AkJ.left + dPl();
        int i2 = this.aqm;
        int i3 = this.aqm;
        Object obj = null;
        while (i3 < this.Ls && i3 < i) {
            if (i3 + 1 < this.Ls) {
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
        AppMethodBeat.o(3248);
        return dPl;
    }

    /* JADX WARNING: Missing block: B:13:0x003f, code skipped:
            if (r1 != null) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int QU(int i) {
        AppMethodBeat.i(3249);
        int i2 = this.aqm;
        float dPl = this.AkJ.left + dPl();
        int i3 = this.aqm;
        int i4 = this.aqm;
        Object obj = null;
        while (i4 < this.Ls) {
            if (i4 + 1 < this.Ls) {
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
                AppMethodBeat.o(3249);
                return i2;
            } else if (dPl > ((float) i)) {
                i2 = this.aqm;
                AppMethodBeat.o(3249);
                return i2;
            } else if (((float) i) <= this.AkJ.right) {
                i2++;
                obj = null;
                i3 = i5;
                dPl = f;
                i4++;
            } else if (this.Ls == this.AkC.length) {
                i2 = this.Ls;
                AppMethodBeat.o(3249);
                return i2;
            } else {
                i2 = this.Ls - 1;
                AppMethodBeat.o(3249);
                return i2;
            }
        }
        i2 = this.Ls;
        AppMethodBeat.o(3249);
        return i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(3250);
        if (obj == null) {
            AppMethodBeat.o(3250);
            return false;
        } else if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.getStart() == this.aqm && bVar.getEnd() == this.Ls && bVar.dPh().equals(this.AkJ) && bVar.dPk() == this.AkF && bVar.dPj() == this.AkE && bVar.dPl() == this.AkG) {
                for (int i = this.aqm; i < this.Ls; i++) {
                    if (this.Akb[i] != bVar.dPg()[i]) {
                        AppMethodBeat.o(3250);
                        return false;
                    }
                }
                AppMethodBeat.o(3250);
                return true;
            }
            AppMethodBeat.o(3250);
            return false;
        } else {
            AppMethodBeat.o(3250);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(3251);
        int hashCode = ((((this.aqm + this.Ls) + ((int) this.mHeight)) + ((int) this.mWidth)) + ((int) this.AkG)) + this.AkJ.hashCode();
        AppMethodBeat.o(3251);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(3252);
        String str = "MeasuredLine{mStart=" + this.aqm + ", mEnd=" + this.Ls + ", mLetter=" + this.AkE + ", isSmartLetter=" + this.AkF + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + ", mLeftOffset=" + this.AkG + ", mLineRect=" + this.AkJ + ", mLineRect=" + this.AkK + '}';
        AppMethodBeat.o(3252);
        return str;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        AppMethodBeat.i(3253);
        objectOutputStream.writeInt(this.aqm);
        objectOutputStream.writeInt(this.Ls);
        objectOutputStream.writeObject(this.Akb);
        objectOutputStream.writeFloat(this.AkJ.left);
        objectOutputStream.writeFloat(this.AkJ.top);
        objectOutputStream.writeFloat(this.AkJ.right);
        objectOutputStream.writeFloat(this.AkJ.bottom);
        objectOutputStream.writeBoolean(this.AkF);
        objectOutputStream.writeFloat(this.AkE);
        objectOutputStream.writeFloat(dPl());
        AppMethodBeat.o(3253);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.i(3254);
        this.aqm = objectInputStream.readInt();
        this.Ls = objectInputStream.readInt();
        this.Akb = (float[]) objectInputStream.readObject();
        this.AkJ = new RectF(objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat());
        this.AkF = objectInputStream.readBoolean();
        this.AkE = objectInputStream.readFloat();
        this.AkG = objectInputStream.readFloat();
        AppMethodBeat.o(3254);
    }
}
