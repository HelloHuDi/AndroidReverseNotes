package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.tools.s */
public final class C5608s {
    String mText;
    List<C5607b> zIb;
    WeakReference<EditText> zIc;
    ArrayList<String> zId;
    boolean zIe;

    /* renamed from: com.tencent.mm.ui.tools.s$a */
    public static class C5606a extends Drawable {
        private static int zAq;
        private Paint eGZ = new Paint(1);
        private String mText;
        /* renamed from: nI */
        private RectF f1330nI;
        private Paint zAp;
        private float zAr;
        private float zAs;
        private float zIf;
        private float zIg;

        public C5606a(Context context, String str, Paint paint) {
            AppMethodBeat.m2504i(107813);
            this.eGZ.setColor(-7829368);
            this.zAp = paint;
            zAq = C4977b.m7371b(context, 2.0f);
            this.zIf = (float) zAq;
            this.zIg = (float) zAq;
            this.mText = str;
            this.zAr = this.zAp.measureText(this.mText);
            FontMetrics fontMetrics = this.zAp.getFontMetrics();
            this.zAs = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) ((this.zAr + ((float) (zAq * 2))) + ((float) (zAq * 2))), (int) this.zAs);
            C4990ab.m7417i("MicroMsg.TextDrawable", "setText(%s).", str);
            AppMethodBeat.m2505o(107813);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.m2504i(107814);
            canvas.drawRoundRect(this.f1330nI, this.zIf, this.zIg, this.eGZ);
            Rect bounds = getBounds();
            int i = (int) (((((float) (bounds.right - bounds.left)) - (this.f1330nI.right - this.f1330nI.left)) + ((float) (zAq * 2))) / 2.0f);
            FontMetricsInt fontMetricsInt = this.zAp.getFontMetricsInt();
            canvas.drawText(this.mText, (float) i, (float) ((((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) + bounds.top) - fontMetricsInt.top), this.zAp);
            AppMethodBeat.m2505o(107814);
        }

        public final void setAlpha(int i) {
            AppMethodBeat.m2504i(107815);
            if (i != this.eGZ.getAlpha()) {
                this.eGZ.setAlpha(i);
                invalidateSelf();
            }
            AppMethodBeat.m2505o(107815);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.m2504i(107816);
            this.eGZ.setColorFilter(colorFilter);
            invalidateSelf();
            AppMethodBeat.m2505o(107816);
        }

        public final int getOpacity() {
            AppMethodBeat.m2504i(107817);
            if (this.eGZ.getAlpha() < 255) {
                AppMethodBeat.m2505o(107817);
                return -3;
            }
            AppMethodBeat.m2505o(107817);
            return -1;
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(107818);
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.zAp.getFontMetrics();
            this.f1330nI = new RectF((float) (zAq + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - zAq), (float) i4);
            invalidateSelf();
            AppMethodBeat.m2505o(107818);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.s$b */
    static class C5607b {
        int length;
        int start;
        boolean zIh;

        C5607b(int i, int i2, boolean z) {
            this.start = i;
            this.length = i2;
            this.zIh = z;
        }
    }

    public C5608s(EditText editText) {
        AppMethodBeat.m2504i(107819);
        this.zIc = new WeakReference(editText);
        AppMethodBeat.m2505o(107819);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: PK */
    public final C5607b mo11379PK(int i) {
        AppMethodBeat.m2504i(107820);
        if (this.zIb != null) {
            for (C5607b c5607b : this.zIb) {
                if (i <= c5607b.start + c5607b.length && i > c5607b.start) {
                    AppMethodBeat.m2505o(107820);
                    return c5607b;
                }
            }
        }
        AppMethodBeat.m2505o(107820);
        return null;
    }

    /* renamed from: a */
    static boolean m8403a(EditText editText, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(107821);
        String obj = editText.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<C5607b> m = C5608s.m8404m(obj, arrayList);
        if (m == null || m.size() <= 0) {
            AppMethodBeat.m2505o(107821);
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        Context context = editText.getContext();
        TextPaint paint = editText.getPaint();
        for (C5607b c5607b : m) {
            int i = c5607b.start;
            int i2 = c5607b.length;
            if (i < 0 || i2 <= 0 || i + i2 > obj.length()) {
                C4990ab.m7417i("MicroMsg.WordsChecker", "start : %d, length : %d.", Integer.valueOf(i), Integer.valueOf(i2));
            } else if (c5607b.zIh) {
                spannableStringBuilder.append(C5608s.m8402a(context, obj.substring(i, i + i2), paint));
            } else {
                spannableStringBuilder.append(obj.substring(i, i + i2));
            }
        }
        if (spannableStringBuilder.length() > 0) {
            editText.setText(spannableStringBuilder);
            editText.setTextKeepState(spannableStringBuilder);
            if (selectionStart == selectionEnd && selectionStart >= 0) {
                editText.setSelection(selectionStart);
            }
        }
        AppMethodBeat.m2505o(107821);
        return true;
    }

    /* renamed from: a */
    private static SpannableString m8402a(Context context, String str, Paint paint) {
        AppMethodBeat.m2504i(107822);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ImageSpan(new C5606a(context, str, paint), 0), 0, str.length(), 33);
        AppMethodBeat.m2505o(107822);
        return spannableString;
    }

    /* renamed from: m */
    static List<C5607b> m8404m(String str, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(107823);
        if (C5046bo.isNullOrNil(str) || arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.m2505o(107823);
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i <= length) {
            Iterator it = arrayList.iterator();
            int i2 = 0;
            int i3 = length;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!C5046bo.isNullOrNil(str2)) {
                    int i4;
                    int indexOf = str.indexOf(str2, i);
                    if (indexOf < 0 || (indexOf >= i3 && (indexOf != i3 || str2.length() <= i2))) {
                        i4 = i2;
                    } else {
                        i4 = str2.length();
                        i3 = indexOf;
                    }
                    i2 = i4;
                }
            }
            if (i3 < length) {
                if (i3 > i) {
                    arrayList2.add(new C5607b(i, i3 - i, false));
                }
                arrayList2.add(new C5607b(i3, i2, true));
                i = i3 + i2;
            } else {
                if (i3 > i) {
                    arrayList2.add(new C5607b(i, i3 - i, false));
                }
                AppMethodBeat.m2505o(107823);
                return arrayList2;
            }
        }
        AppMethodBeat.m2505o(107823);
        return arrayList2;
    }
}
