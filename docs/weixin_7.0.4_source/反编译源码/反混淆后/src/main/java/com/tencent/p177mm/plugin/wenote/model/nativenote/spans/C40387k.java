package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.support.p057v4.content.C0380b;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C44005b;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.k */
public class C40387k implements LeadingMarginSpan, C14739f<Boolean>, C46458g<Boolean> {
    private int uRU;
    public boolean uRV;
    public boolean uRY = false;
    public boolean uRZ = false;
    public boolean uSa = false;
    public boolean uSb = false;
    private WeakReference<Drawable> uSc;

    public final /* synthetic */ C14739f dfC() {
        AppMethodBeat.m2504i(26951);
        C40387k dfE = dfE();
        AppMethodBeat.m2505o(26951);
        return dfE;
    }

    public C40387k(boolean z, int i, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        AppMethodBeat.m2504i(26947);
        this.uRU = i;
        if (z2 && z4 && !z3) {
            z5 = true;
        }
        this.uRV = z5;
        this.uSb = z;
        this.uRY = z3;
        this.uRZ = z4;
        this.uSa = z2;
        AppMethodBeat.m2505o(26947);
    }

    public int getLeadingMargin(boolean z) {
        return this.uRV ? 0 : this.uRU;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        AppMethodBeat.m2504i(26948);
        Spanned spanned = (Spanned) charSequence;
        if (!this.uRV && spanned.getSpanStart(this) == i6) {
            WeakReference weakReference = this.uSc;
            Drawable drawable = null;
            if (weakReference != null) {
                drawable = (Drawable) weakReference.get();
            }
            if (drawable == null) {
                if (this.uSb) {
                    drawable = C0380b.m649g(C4996ah.getContext(), C25738R.drawable.bdi);
                } else {
                    drawable = C0380b.m649g(C4996ah.getContext(), C25738R.drawable.bdj);
                }
                this.uSc = new WeakReference(drawable);
            }
            if (drawable == null) {
                AppMethodBeat.m2505o(26948);
                return;
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            canvas.save();
            FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.translate(0.0f, (float) (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - (drawable.getBounds().bottom / 2)));
            drawable.draw(canvas);
            canvas.restore();
        }
        AppMethodBeat.m2505o(26948);
    }

    private C40387k dfE() {
        AppMethodBeat.m2504i(26949);
        C40387k c40387k = new C40387k(this.uSb, this.uRU, this.uSa, this.uRY, this.uRZ);
        AppMethodBeat.m2505o(26949);
        return c40387k;
    }

    /* renamed from: a */
    public final void mo63784a(TextView textView, Spannable spannable, MotionEvent motionEvent, C40387k c40387k) {
        AppMethodBeat.m2504i(26950);
        if (motionEvent.getX() > ((float) this.uRU)) {
            C4990ab.m7412e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
            AppMethodBeat.m2505o(26950);
            return;
        }
        boolean z;
        int spanStart = spannable.getSpanStart(c40387k);
        int spanEnd = spannable.getSpanEnd(c40387k);
        String str = "MicroMsg.NoteTodoSpan";
        String str2 = "current mIsTodoCheck: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.uSb ? "true" : "false";
        C4990ab.m7417i(str, str2, objArr);
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
            C44001c Ke = C40380c.dem().mo63750Ke(wXRTEditText.getRecyclerItemPosition());
            if (Ke != null && Ke.getType() == 1) {
                ((C40365i) Ke).content = C44005b.m78993a(spannable);
            }
        }
        AppMethodBeat.m2505o(26950);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }
}
