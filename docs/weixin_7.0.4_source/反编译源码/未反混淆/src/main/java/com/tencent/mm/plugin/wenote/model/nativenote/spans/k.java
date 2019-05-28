package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

public class k implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    private int uRU;
    public boolean uRV;
    public boolean uRY = false;
    public boolean uRZ = false;
    public boolean uSa = false;
    public boolean uSb = false;
    private WeakReference<Drawable> uSc;

    public final /* synthetic */ f dfC() {
        AppMethodBeat.i(26951);
        k dfE = dfE();
        AppMethodBeat.o(26951);
        return dfE;
    }

    public k(boolean z, int i, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        AppMethodBeat.i(26947);
        this.uRU = i;
        if (z2 && z4 && !z3) {
            z5 = true;
        }
        this.uRV = z5;
        this.uSb = z;
        this.uRY = z3;
        this.uRZ = z4;
        this.uSa = z2;
        AppMethodBeat.o(26947);
    }

    public int getLeadingMargin(boolean z) {
        return this.uRV ? 0 : this.uRU;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        AppMethodBeat.i(26948);
        Spanned spanned = (Spanned) charSequence;
        if (!this.uRV && spanned.getSpanStart(this) == i6) {
            WeakReference weakReference = this.uSc;
            Drawable drawable = null;
            if (weakReference != null) {
                drawable = (Drawable) weakReference.get();
            }
            if (drawable == null) {
                if (this.uSb) {
                    drawable = b.g(ah.getContext(), R.drawable.bdi);
                } else {
                    drawable = b.g(ah.getContext(), R.drawable.bdj);
                }
                this.uSc = new WeakReference(drawable);
            }
            if (drawable == null) {
                AppMethodBeat.o(26948);
                return;
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            canvas.save();
            FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.translate(0.0f, (float) (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - (drawable.getBounds().bottom / 2)));
            drawable.draw(canvas);
            canvas.restore();
        }
        AppMethodBeat.o(26948);
    }

    private k dfE() {
        AppMethodBeat.i(26949);
        k kVar = new k(this.uSb, this.uRU, this.uSa, this.uRY, this.uRZ);
        AppMethodBeat.o(26949);
        return kVar;
    }

    public final void a(TextView textView, Spannable spannable, MotionEvent motionEvent, k kVar) {
        AppMethodBeat.i(26950);
        if (motionEvent.getX() > ((float) this.uRU)) {
            ab.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
            AppMethodBeat.o(26950);
            return;
        }
        boolean z;
        int spanStart = spannable.getSpanStart(kVar);
        int spanEnd = spannable.getSpanEnd(kVar);
        String str = "MicroMsg.NoteTodoSpan";
        String str2 = "current mIsTodoCheck: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.uSb ? "true" : "false";
        ab.i(str, str2, objArr);
        spannable.removeSpan(this);
        if (this.uSb) {
            z = false;
        } else {
            z = true;
        }
        this.uSb = z;
        spannable.setSpan(dfE(), spanStart, spanEnd, 33);
        WXRTEditText wXRTEditText = (WXRTEditText) textView;
        if (wXRTEditText.getEditTextType() == 0) {
            c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(wXRTEditText.getRecyclerItemPosition());
            if (Ke != null && Ke.getType() == 1) {
                ((i) Ke).content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannable);
            }
        }
        AppMethodBeat.o(26950);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }
}
