package com.tencent.p177mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C26931e;
import com.tencent.p177mm.plugin.appbrand.widget.p916h.C10981a;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.d */
public class C42702d extends TextView implements C26931e {
    private C10981a iTW;
    private boolean ikj;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.d$1 */
    class C109441 extends Factory {
        C109441() {
        }

        public final Spannable newSpannable(CharSequence charSequence) {
            AppMethodBeat.m2504i(126657);
            Spannable newSpannable = super.newSpannable(charSequence);
            if (!(C42702d.this.iTW == null || TextUtils.isEmpty(newSpannable))) {
                newSpannable.setSpan(C42702d.this.iTW, 0, newSpannable.length(), 18);
            }
            AppMethodBeat.m2505o(126657);
            return newSpannable;
        }
    }

    public C42702d(Context context) {
        super(context);
        AppMethodBeat.m2504i(126658);
        super.setIncludeFontPadding(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setSpannableFactory(new C109441());
        AppMethodBeat.m2505o(126658);
    }

    public void setLineHeight(int i) {
        AppMethodBeat.m2504i(126659);
        if (this.iTW == null) {
            this.iTW = new C10981a((float) i);
        }
        if (this.iTW.mo22605ax((float) i)) {
            invalidate();
            AppMethodBeat.m2505o(126659);
            return;
        }
        AppMethodBeat.m2505o(126659);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.m2504i(126660);
        if (bufferType == BufferType.NORMAL) {
            bufferType = BufferType.SPANNABLE;
        }
        super.setText(charSequence, bufferType);
        AppMethodBeat.m2505o(126660);
    }

    public void setInterceptEvent(boolean z) {
        this.ikj = z;
    }

    public final boolean aCH() {
        return this.ikj;
    }
}
