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
import com.tencent.neattextview.textview.p657a.C5779a;
import com.tencent.neattextview.textview.p658b.C5781b;
import com.tencent.neattextview.textview.p658b.C7375a;
import com.tencent.neattextview.textview.p658b.C7376c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.neattextview.textview.layout.c */
public abstract class C7377c implements C5782a {
    private static final char[] AjX = new char[]{8230};
    private static final String AjY = new String(AjX);
    protected String AjZ;
    protected char[] Aka;
    protected float[] Akb;
    protected float[] Akc;
    protected float[] Akd = new float[C5779a.AjT.length];
    protected float[] Ake = new float[C5779a.AjU.length];
    protected HashMap<Character, Float> Akf = new HashMap(C5779a.AjT.length);
    public ArrayList<C5783b> Akg = new ArrayList();
    private LinkedList<C5781b> Akh = new LinkedList();
    private float Aki;
    private float Akj;
    private float Akk;
    private float Akl;
    private int Akm;
    private TextPaint Akn = new TextPaint();
    private float[] Ako;
    C5785e<ImageSpan> Akp = new C5785e(ImageSpan.class);
    C5785e<AbsoluteSizeSpan> Akq = new C5785e(AbsoluteSizeSpan.class);
    C5785e<RelativeSizeSpan> Akr = new C5785e(RelativeSizeSpan.class);
    private C5785e<BackgroundColorSpan> Aks = new C5785e(BackgroundColorSpan.class);
    C5785e<ForegroundColorSpan> Akt = new C5785e(ForegroundColorSpan.class);
    C5785e<ClickableSpan> Aku = new C5785e(ClickableSpan.class);
    C5785e<LineBackgroundSpan> Akv = new C5785e(LineBackgroundSpan.class);
    private float Akw = 0.0f;
    private LinkedList<C7376c> Akx;
    protected boolean[] Aky;
    private int btF = 0;
    protected CharSequence mText;
    /* renamed from: oz */
    protected TextPaint f2010oz;
    private float uSe;

    /* renamed from: a */
    public abstract void mo15905a(TextPaint textPaint, float f, int i, boolean z);

    public C7377c(CharSequence charSequence, float[] fArr) {
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

    /* renamed from: a */
    public final void mo15904a(TextPaint textPaint, float f, float f2, float f3, float f4, float f5, int i, TruncateAt truncateAt, float f6, boolean z, int i2) {
        this.f2010oz = new TextPaint(textPaint);
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
        m12593a(this.mText, textPaint, this.Aky);
        m12594d(textPaint);
        mo15905a(textPaint, f, i, z);
        m12592a(truncateAt, f6, textPaint);
    }

    /* renamed from: a */
    public final void mo15903a(Canvas canvas, float f, float f2) {
        canvas.save();
        canvas.translate(f, f2);
        float f3 = 0.0f;
        Iterator it = this.Akh.iterator();
        while (it.hasNext()) {
            ((C5781b) it.next()).mo11829a(canvas, this.f2010oz, this.Akg);
        }
        it = this.Akg.iterator();
        while (it.hasNext()) {
            C5783b c5783b = (C5783b) it.next();
            c5783b.mo11849a(canvas, this.f2010oz, f3);
            f3 = c5783b.getHeight() + f3;
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

    /* renamed from: a */
    private void m12593a(CharSequence charSequence, TextPaint textPaint, boolean[] zArr) {
        int length;
        int i;
        int i2;
        int i3;
        float[] fArr;
        int i4 = 0;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            length = charSequence.length();
            this.Akp.mo11863a(spanned, length);
            this.Akq.mo11863a(spanned, length);
            this.Akr.mo11863a(spanned, length);
            this.Akt.mo11863a(spanned, length);
            this.Aks.mo11863a(spanned, length);
            this.Aku.mo11863a(spanned, length);
            this.Akv.mo11863a(spanned, length);
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
            this.Akh.add(new C7375a(this.Aks.AkR[length], this.Aks.AkS[length], characterStyle));
        }
        while (i4 < this.Aku.AkP) {
            ClickableSpan clickableSpan = ((ClickableSpan[]) this.Aku.AkQ)[i4];
            this.Akh.add(new C7376c(this.Aku.AkR[i4], this.Aku.AkS[i4], clickableSpan));
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
                C5783b c5783b = (C5783b) it.next();
                if (f3 < c5783b.getWidth()) {
                    f3 = c5783b.getWidth();
                }
                f = c5783b.getHeight() + f2;
            }
            this.Ako = new float[]{f3, f2};
        }
        return this.Ako;
    }

    public final TextPaint getTextPaint() {
        return this.f2010oz;
    }

    /* renamed from: hQ */
    public final int mo11847hQ(int i, int i2) {
        int i3 = (int) (((float) i) - this.Akj);
        int i4 = (int) (((float) i2) - this.Akk);
        Iterator it = this.Akg.iterator();
        while (it.hasNext()) {
            C5783b c5783b = (C5783b) it.next();
            if (c5783b.dPi().contains((float) i3, (float) i4)) {
                return c5783b.mo11848QU(i3);
            }
        }
        return this.Aka.length;
    }

    /* renamed from: d */
    private void m12594d(Paint paint) {
        this.Akf.clear();
        Rect rect = new Rect();
        int i = 0;
        for (char c : C5779a.AjT) {
            float measureText = paint.measureText(String.valueOf(c));
            paint.getTextBounds(String.valueOf(c), 0, 1, rect);
            this.Akd[i] = measureText - ((float) rect.right);
            i++;
        }
        int i2 = 0;
        for (char valueOf : C5779a.AjU) {
            paint.getTextBounds(String.valueOf(valueOf), 0, 1, rect);
            float f = rect.left > 0 ? (float) rect.left : 0.0f;
            this.Ake[i2] = f;
            this.Akf.put(Character.valueOf(C5779a.AjU[i2]), Float.valueOf(f));
            i2++;
        }
    }

    public final HashMap<Character, Float> dPp() {
        return this.Akf;
    }

    public final List<C7376c> dPf() {
        if (this.Akx == null) {
            this.Akx = new LinkedList();
            Iterator it = this.Akh.iterator();
            while (it.hasNext()) {
                C5781b c5781b = (C5781b) it.next();
                if (c5781b.getClass() == C7376c.class) {
                    this.Akx.add((C7376c) c5781b);
                }
            }
        }
        return this.Akx;
    }

    /* renamed from: a */
    private void m12592a(TruncateAt truncateAt, float f, TextPaint textPaint) {
        if (truncateAt != null && truncateAt != TruncateAt.MARQUEE) {
            int i;
            if (this.mText == null || this.Akg.size() <= 0 || this.mText.length() <= ((C5783b) this.Akg.get(this.Akg.size() - 1)).getEnd()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                int start;
                float measureText = (textPaint.measureText(AjY) + (textPaint.getTextSize() / 6.0f)) + f;
                if (this.btF == 1 && truncateAt == TruncateAt.MIDDLE) {
                    C5783b c5783b = (C5783b) this.Akg.get(0);
                    start = c5783b.getStart();
                    float f2 = 0.0f;
                    while (start < c5783b.getEnd()) {
                        f2 += this.Akb[start];
                        if (f2 >= this.uSe / 2.0f) {
                            break;
                        }
                        start++;
                    }
                    start = 0;
                } else if (truncateAt == TruncateAt.END) {
                    start = ((C5783b) this.Akg.get(this.Akg.size() - 1)).getEnd() - 1;
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
        C5783b c5783b;
        int size = this.Akg.size();
        if (size > i) {
            c5783b = (C5783b) this.Akg.get(i);
        } else if (size <= 0) {
            return 0;
        } else {
            c5783b = (C5783b) this.Akg.get(size - 1);
        }
        return (int) c5783b.dPm();
    }

    public final int getLineTop(int i) {
        C5783b c5783b;
        int size = this.Akg.size();
        if (size > i) {
            c5783b = (C5783b) this.Akg.get(i);
        } else if (size <= 0) {
            return 0;
        } else {
            c5783b = (C5783b) this.Akg.get(size - 1);
        }
        return (int) c5783b.dPh().top;
    }

    public final int getLineBottom(int i) {
        C5783b c5783b;
        int size = this.Akg.size();
        if (size > i) {
            c5783b = (C5783b) this.Akg.get(i);
        } else if (size <= 0) {
            return 0;
        } else {
            c5783b = (C5783b) this.Akg.get(size - 1);
        }
        return (int) c5783b.dPh().bottom;
    }

    public final int getLineForOffset(int i) {
        int i2 = 0;
        Iterator it = this.Akg.iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3 - 1;
            }
            C5783b c5783b = (C5783b) it.next();
            if (c5783b.getStart() <= i && i < c5783b.getEnd()) {
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
        return ((C5783b) this.Akg.get(lineForOffset)).getPrimaryHorizontal(i);
    }

    public final int getOffsetForHorizontal(int i, float f) {
        float f2 = f - this.Akj;
        if (this.Akg.size() > i) {
            return ((C5783b) this.Akg.get(i)).mo11848QU((int) f2);
        }
        return 0;
    }

    public final float getLineWidth(int i) {
        if (this.Akg.size() > i) {
            return ((C5783b) this.Akg.get(i)).dPh().width();
        }
        return 0.0f;
    }

    public final int getLineStart(int i) {
        if (this.Akg.size() > i) {
            return ((C5783b) this.Akg.get(i)).getStart();
        }
        return this.Aka.length;
    }

    public final int getLineForVertical(int i) {
        int i2 = (int) (((float) i) - this.Akk);
        Iterator it = this.Akg.iterator();
        float f = 0.0f;
        int i3 = 0;
        while (it.hasNext()) {
            C5783b c5783b = (C5783b) it.next();
            if (f == 0.0f) {
                f = c5783b.dPi().top;
            }
            RectF dPi = c5783b.dPi();
            if (dPi.contains(dPi.centerX(), (float) i2)) {
                return i3;
            }
            i3++;
        }
        return ((float) i2) <= f ? 0 : i3 - 1;
    }

    public final float getLineRight(int i) {
        if (this.Akg.size() > i) {
            return ((C5783b) this.Akg.get(i)).dPh().right;
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo15906a(char[] cArr, int i, int i2, float f, float[] fArr, int i3, float f2, boolean z, float f3, float f4) {
        FontMetrics fontMetrics = this.f2010oz.getFontMetrics();
        float f5 = fontMetrics.bottom - fontMetrics.top;
        if (this.Akc != null) {
            for (int i4 = i; i4 < i2; i4++) {
                if (f5 < this.Akc[i4]) {
                    f5 = this.Akc[i4];
                }
            }
        }
        float f6 = f5 + this.Akl;
        C7378d c7378d = new C7378d(this, cArr, i, i2, this.Akw, fArr, f, f6, f2, this.f2010oz, z, f3, i3, this.Akm, f4);
        this.Akw += f6;
        this.Akg.add(c7378d);
    }

    /* renamed from: an */
    public final void mo15907an(CharSequence charSequence) {
        m12593a(charSequence, this.f2010oz, this.Aky);
    }
}
