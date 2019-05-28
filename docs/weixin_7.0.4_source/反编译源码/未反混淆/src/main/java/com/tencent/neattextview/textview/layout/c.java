package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.neattextview.textview.a.a;
import com.tencent.neattextview.textview.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c implements a {
    private static final char[] AjX = new char[]{8230};
    private static final String AjY = new String(AjX);
    protected String AjZ;
    protected char[] Aka;
    protected float[] Akb;
    protected float[] Akc;
    protected float[] Akd = new float[a.AjT.length];
    protected float[] Ake = new float[a.AjU.length];
    protected HashMap<Character, Float> Akf = new HashMap(a.AjT.length);
    public ArrayList<b> Akg = new ArrayList();
    private LinkedList<b> Akh = new LinkedList();
    private float Aki;
    private float Akj;
    private float Akk;
    private float Akl;
    private int Akm;
    private TextPaint Akn = new TextPaint();
    private float[] Ako;
    e<ImageSpan> Akp = new e(ImageSpan.class);
    e<AbsoluteSizeSpan> Akq = new e(AbsoluteSizeSpan.class);
    e<RelativeSizeSpan> Akr = new e(RelativeSizeSpan.class);
    private e<BackgroundColorSpan> Aks = new e(BackgroundColorSpan.class);
    e<ForegroundColorSpan> Akt = new e(ForegroundColorSpan.class);
    e<ClickableSpan> Aku = new e(ClickableSpan.class);
    e<LineBackgroundSpan> Akv = new e(LineBackgroundSpan.class);
    private float Akw = 0.0f;
    private LinkedList<com.tencent.neattextview.textview.b.c> Akx;
    protected boolean[] Aky;
    private int btF = 0;
    protected CharSequence mText;
    protected TextPaint oz;
    private float uSe;

    public abstract void a(TextPaint textPaint, float f, int i, boolean z);

    public c(CharSequence charSequence, float[] fArr) {
        this.mText = charSequence;
        this.AjZ = charSequence.toString();
        this.Aka = this.AjZ.toCharArray();
        if (fArr != null) {
            this.Akb = new float[fArr.length];
            System.arraycopy(fArr, 0, this.Akb, 0, fArr.length);
        }
    }

    public final String dPn() {
        return this.AjZ;
    }

    public final void a(TextPaint textPaint, float f, float f2, float f3, float f4, float f5, int i, TruncateAt truncateAt, float f6, boolean z, int i2) {
        this.oz = new TextPaint(textPaint);
        this.Aki = f2;
        this.uSe = f;
        this.Akj = f3;
        this.Akk = f4;
        this.btF = i;
        this.Akl = f5;
        this.Ako = null;
        this.Akm = i2;
        int length = this.mText.length();
        if (this.Akb == null) {
            this.Akb = new float[length];
            textPaint.getTextWidths(this.AjZ, this.Akb);
        }
        this.Aky = new boolean[length];
        a(this.mText, textPaint, this.Aky);
        d(textPaint);
        a(textPaint, f, i, z);
        a(truncateAt, f6, textPaint);
    }

    public final void a(Canvas canvas, float f, float f2) {
        canvas.save();
        canvas.translate(f, f2);
        float f3 = 0.0f;
        Iterator it = this.Akh.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(canvas, this.oz, this.Akg);
        }
        it = this.Akg.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            bVar.a(canvas, this.oz, f3);
            f3 = bVar.getHeight() + f3;
        }
        canvas.restore();
    }

    public final float[] dPg() {
        return this.Akb;
    }

    public final CharSequence getText() {
        return this.mText;
    }

    public int dPe() {
        return this.Akg.size();
    }

    private void a(CharSequence charSequence, TextPaint textPaint, boolean[] zArr) {
        int length;
        int i;
        int i2;
        int i3;
        float[] fArr;
        int i4 = 0;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            length = charSequence.length();
            this.Akp.a(spanned, length);
            this.Akq.a(spanned, length);
            this.Akr.a(spanned, length);
            this.Akt.a(spanned, length);
            this.Aks.a(spanned, length);
            this.Aku.a(spanned, length);
            this.Akv.a(spanned, length);
        }
        this.Akn.set(textPaint);
        for (length = 0; length < this.Akq.AkP; length++) {
            ((AbsoluteSizeSpan[]) this.Akq.AkQ)[length].updateMeasureState(this.Akn);
            i = this.Akq.AkR[length];
            i2 = this.Akq.AkS[length];
            i3 = i2 - i;
            fArr = new float[i3];
            this.Akn.getTextWidths(charSequence, i, i2, fArr);
            System.arraycopy(fArr, 0, this.Akb, i, i3);
            if (this.Akc == null) {
                this.Akc = new float[charSequence.length()];
            }
            this.Akc[i] = this.Akn.getTextSize();
        }
        for (length = 0; length < this.Akr.AkP; length++) {
            ((RelativeSizeSpan[]) this.Akr.AkQ)[length].updateMeasureState(this.Akn);
            i = this.Akr.AkR[length];
            i2 = this.Akr.AkS[length];
            i3 = i2 - i;
            fArr = new float[i3];
            this.Akn.getTextWidths(charSequence, i, i2, fArr);
            System.arraycopy(fArr, 0, this.Akb, i, i3);
            if (this.Akc == null) {
                this.Akc = new float[charSequence.length()];
            }
            this.Akc[i] = this.Akn.getTextSize();
        }
        for (length = 0; length < this.Akp.AkP; length++) {
            ImageSpan imageSpan = ((ImageSpan[]) this.Akp.AkQ)[length];
            i2 = this.Akp.AkR[length];
            i3 = this.Akp.AkS[length] - i2;
            Drawable drawable = imageSpan.getDrawable();
            Rect rect = new Rect();
            if (drawable != null) {
                rect.set(drawable.getBounds());
            }
            this.Akb[i2] = (float) rect.width();
            zArr[i2] = true;
            i = i2 + 1;
            while (i < i2 + i3 && i < this.Akb.length) {
                this.Akb[i] = 0.0f;
                zArr[i] = true;
                i++;
            }
            if (this.Akc == null) {
                this.Akc = new float[charSequence.length()];
            }
            this.Akc[i2] = (float) rect.height();
        }
        for (length = 0; length < this.Aks.AkP; length++) {
            CharacterStyle characterStyle = ((BackgroundColorSpan[]) this.Aks.AkQ)[length];
            this.Akh.add(new com.tencent.neattextview.textview.b.a(this.Aks.AkR[length], this.Aks.AkS[length], characterStyle));
        }
        while (i4 < this.Aku.AkP) {
            ClickableSpan clickableSpan = ((ClickableSpan[]) this.Aku.AkQ)[i4];
            this.Akh.add(new com.tencent.neattextview.textview.b.c(this.Aku.AkR[i4], this.Aku.AkS[i4], clickableSpan));
            i4++;
        }
    }

    public final float[] dPo() {
        float f = 0.0f;
        if (this.Ako == null) {
            float f2;
            Iterator it = this.Akg.iterator();
            float f3 = 0.0f;
            while (true) {
                f2 = f;
                if (!it.hasNext()) {
                    break;
                }
                b bVar = (b) it.next();
                if (f3 < bVar.getWidth()) {
                    f3 = bVar.getWidth();
                }
                f = bVar.getHeight() + f2;
            }
            this.Ako = new float[]{f3, f2};
        }
        return this.Ako;
    }

    public final TextPaint getTextPaint() {
        return this.oz;
    }

    public final int hQ(int i, int i2) {
        int i3 = (int) (((float) i) - this.Akj);
        int i4 = (int) (((float) i2) - this.Akk);
        Iterator it = this.Akg.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.dPi().contains((float) i3, (float) i4)) {
                return bVar.QU(i3);
            }
        }
        return this.Aka.length;
    }

    private void d(Paint paint) {
        this.Akf.clear();
        Rect rect = new Rect();
        int i = 0;
        for (char c : a.AjT) {
            float measureText = paint.measureText(String.valueOf(c));
            paint.getTextBounds(String.valueOf(c), 0, 1, rect);
            this.Akd[i] = measureText - ((float) rect.right);
            i++;
        }
        int i2 = 0;
        for (char valueOf : a.AjU) {
            paint.getTextBounds(String.valueOf(valueOf), 0, 1, rect);
            float f = rect.left > 0 ? (float) rect.left : 0.0f;
            this.Ake[i2] = f;
            this.Akf.put(Character.valueOf(a.AjU[i2]), Float.valueOf(f));
            i2++;
        }
    }

    public final HashMap<Character, Float> dPp() {
        return this.Akf;
    }

    public final List<com.tencent.neattextview.textview.b.c> dPf() {
        if (this.Akx == null) {
            this.Akx = new LinkedList();
            Iterator it = this.Akh.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.getClass() == com.tencent.neattextview.textview.b.c.class) {
                    this.Akx.add((com.tencent.neattextview.textview.b.c) bVar);
                }
            }
        }
        return this.Akx;
    }

    private void a(TruncateAt truncateAt, float f, TextPaint textPaint) {
        if (truncateAt != null && truncateAt != TruncateAt.MARQUEE) {
            int i;
            if (this.mText == null || this.Akg.size() <= 0 || this.mText.length() <= ((b) this.Akg.get(this.Akg.size() - 1)).getEnd()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                int start;
                float measureText = (textPaint.measureText(AjY) + (textPaint.getTextSize() / 6.0f)) + f;
                if (this.btF == 1 && truncateAt == TruncateAt.MIDDLE) {
                    b bVar = (b) this.Akg.get(0);
                    start = bVar.getStart();
                    float f2 = 0.0f;
                    while (start < bVar.getEnd()) {
                        f2 += this.Akb[start];
                        if (f2 >= this.uSe / 2.0f) {
                            break;
                        }
                        start++;
                    }
                    start = 0;
                } else if (truncateAt == TruncateAt.END) {
                    start = ((b) this.Akg.get(this.Akg.size() - 1)).getEnd() - 1;
                } else {
                    start = 0;
                }
                float f3 = 0.0f;
                while (start > 0) {
                    f3 += this.Akb[start];
                    if (f3 >= measureText) {
                        break;
                    }
                    this.Akb[start] = 0.0f;
                    this.Aka[start] = 0;
                    start--;
                }
                if (start >= 0) {
                    this.Akb[start] = measureText;
                    this.Aka[start] = AjX[0];
                }
            }
        }
    }

    public final int getLineBaseline(int i) {
        b bVar;
        int size = this.Akg.size();
        if (size > i) {
            bVar = (b) this.Akg.get(i);
        } else if (size <= 0) {
            return 0;
        } else {
            bVar = (b) this.Akg.get(size - 1);
        }
        return (int) bVar.dPm();
    }

    public final int getLineTop(int i) {
        b bVar;
        int size = this.Akg.size();
        if (size > i) {
            bVar = (b) this.Akg.get(i);
        } else if (size <= 0) {
            return 0;
        } else {
            bVar = (b) this.Akg.get(size - 1);
        }
        return (int) bVar.dPh().top;
    }

    public final int getLineBottom(int i) {
        b bVar;
        int size = this.Akg.size();
        if (size > i) {
            bVar = (b) this.Akg.get(i);
        } else if (size <= 0) {
            return 0;
        } else {
            bVar = (b) this.Akg.get(size - 1);
        }
        return (int) bVar.dPh().bottom;
    }

    public final int getLineForOffset(int i) {
        int i2 = 0;
        Iterator it = this.Akg.iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3 - 1;
            }
            b bVar = (b) it.next();
            if (bVar.getStart() <= i && i < bVar.getEnd()) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public final float getPrimaryHorizontal(int i) {
        int lineForOffset = getLineForOffset(i);
        if (lineForOffset < 0) {
            return 0.0f;
        }
        return ((b) this.Akg.get(lineForOffset)).getPrimaryHorizontal(i);
    }

    public final int getOffsetForHorizontal(int i, float f) {
        float f2 = f - this.Akj;
        if (this.Akg.size() > i) {
            return ((b) this.Akg.get(i)).QU((int) f2);
        }
        return 0;
    }

    public final float getLineWidth(int i) {
        if (this.Akg.size() > i) {
            return ((b) this.Akg.get(i)).dPh().width();
        }
        return 0.0f;
    }

    public final int getLineStart(int i) {
        if (this.Akg.size() > i) {
            return ((b) this.Akg.get(i)).getStart();
        }
        return this.Aka.length;
    }

    public final int getLineForVertical(int i) {
        int i2 = (int) (((float) i) - this.Akk);
        Iterator it = this.Akg.iterator();
        float f = 0.0f;
        int i3 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (f == 0.0f) {
                f = bVar.dPi().top;
            }
            RectF dPi = bVar.dPi();
            if (dPi.contains(dPi.centerX(), (float) i2)) {
                return i3;
            }
            i3++;
        }
        return ((float) i2) <= f ? 0 : i3 - 1;
    }

    public final float getLineRight(int i) {
        if (this.Akg.size() > i) {
            return ((b) this.Akg.get(i)).dPh().right;
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(char[] cArr, int i, int i2, float f, float[] fArr, int i3, float f2, boolean z, float f3, float f4) {
        FontMetrics fontMetrics = this.oz.getFontMetrics();
        float f5 = fontMetrics.bottom - fontMetrics.top;
        if (this.Akc != null) {
            for (int i4 = i; i4 < i2; i4++) {
                if (f5 < this.Akc[i4]) {
                    f5 = this.Akc[i4];
                }
            }
        }
        float f6 = f5 + this.Akl;
        d dVar = new d(this, cArr, i, i2, this.Akw, fArr, f, f6, f2, this.oz, z, f3, i3, this.Akm, f4);
        this.Akw += f6;
        this.Akg.add(dVar);
    }

    public final void an(CharSequence charSequence) {
        a(charSequence, this.oz, this.Aky);
    }
}
