package com.tencent.mm.ui.tools;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class s {
    String mText;
    List<b> zIb;
    WeakReference<EditText> zIc;
    ArrayList<String> zId;
    boolean zIe;

    public static class a extends Drawable {
        private static int zAq;
        private Paint eGZ = new Paint(1);
        private String mText;
        private RectF nI;
        private Paint zAp;
        private float zAr;
        private float zAs;
        private float zIf;
        private float zIg;

        public a(Context context, String str, Paint paint) {
            AppMethodBeat.i(107813);
            this.eGZ.setColor(-7829368);
            this.zAp = paint;
            zAq = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 2.0f);
            this.zIf = (float) zAq;
            this.zIg = (float) zAq;
            this.mText = str;
            this.zAr = this.zAp.measureText(this.mText);
            FontMetrics fontMetrics = this.zAp.getFontMetrics();
            this.zAs = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) ((this.zAr + ((float) (zAq * 2))) + ((float) (zAq * 2))), (int) this.zAs);
            ab.i("MicroMsg.TextDrawable", "setText(%s).", str);
            AppMethodBeat.o(107813);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(107814);
            canvas.drawRoundRect(this.nI, this.zIf, this.zIg, this.eGZ);
            Rect bounds = getBounds();
            int i = (int) (((((float) (bounds.right - bounds.left)) - (this.nI.right - this.nI.left)) + ((float) (zAq * 2))) / 2.0f);
            FontMetricsInt fontMetricsInt = this.zAp.getFontMetricsInt();
            canvas.drawText(this.mText, (float) i, (float) ((((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) + bounds.top) - fontMetricsInt.top), this.zAp);
            AppMethodBeat.o(107814);
        }

        public final void setAlpha(int i) {
            AppMethodBeat.i(107815);
            if (i != this.eGZ.getAlpha()) {
                this.eGZ.setAlpha(i);
                invalidateSelf();
            }
            AppMethodBeat.o(107815);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.i(107816);
            this.eGZ.setColorFilter(colorFilter);
            invalidateSelf();
            AppMethodBeat.o(107816);
        }

        public final int getOpacity() {
            AppMethodBeat.i(107817);
            if (this.eGZ.getAlpha() < 255) {
                AppMethodBeat.o(107817);
                return -3;
            }
            AppMethodBeat.o(107817);
            return -1;
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(107818);
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.zAp.getFontMetrics();
            this.nI = new RectF((float) (zAq + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - zAq), (float) i4);
            invalidateSelf();
            AppMethodBeat.o(107818);
        }
    }

    static class b {
        int length;
        int start;
        boolean zIh;

        b(int i, int i2, boolean z) {
            this.start = i;
            this.length = i2;
            this.zIh = z;
        }
    }

    public s(EditText editText) {
        AppMethodBeat.i(107819);
        this.zIc = new WeakReference(editText);
        AppMethodBeat.o(107819);
    }

    /* Access modifiers changed, original: final */
    public final b PK(int i) {
        AppMethodBeat.i(107820);
        if (this.zIb != null) {
            for (b bVar : this.zIb) {
                if (i <= bVar.start + bVar.length && i > bVar.start) {
                    AppMethodBeat.o(107820);
                    return bVar;
                }
            }
        }
        AppMethodBeat.o(107820);
        return null;
    }

    static boolean a(EditText editText, ArrayList<String> arrayList) {
        AppMethodBeat.i(107821);
        String obj = editText.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<b> m = m(obj, arrayList);
        if (m == null || m.size() <= 0) {
            AppMethodBeat.o(107821);
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        Context context = editText.getContext();
        TextPaint paint = editText.getPaint();
        for (b bVar : m) {
            int i = bVar.start;
            int i2 = bVar.length;
            if (i < 0 || i2 <= 0 || i + i2 > obj.length()) {
                ab.i("MicroMsg.WordsChecker", "start : %d, length : %d.", Integer.valueOf(i), Integer.valueOf(i2));
            } else if (bVar.zIh) {
                spannableStringBuilder.append(a(context, obj.substring(i, i + i2), paint));
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
        AppMethodBeat.o(107821);
        return true;
    }

    private static SpannableString a(Context context, String str, Paint paint) {
        AppMethodBeat.i(107822);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ImageSpan(new a(context, str, paint), 0), 0, str.length(), 33);
        AppMethodBeat.o(107822);
        return spannableString;
    }

    static List<b> m(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(107823);
        if (bo.isNullOrNil(str) || arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(107823);
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
                if (!bo.isNullOrNil(str2)) {
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
                    arrayList2.add(new b(i, i3 - i, false));
                }
                arrayList2.add(new b(i3, i2, true));
                i = i3 + i2;
            } else {
                if (i3 > i) {
                    arrayList2.add(new b(i, i3 - i, false));
                }
                AppMethodBeat.o(107823);
                return arrayList2;
            }
        }
        AppMethodBeat.o(107823);
        return arrayList2;
    }
}
