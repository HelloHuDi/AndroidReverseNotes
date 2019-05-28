package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.base.EllipsizeTextView */
public class EllipsizeTextView extends TextView {
    private String ysq;
    private int ysr;
    private int yss;
    private C30360a yst;
    private CharSequence ysu;
    private long ysv = -1;

    /* renamed from: com.tencent.mm.ui.base.EllipsizeTextView$a */
    public interface C30360a {
        /* renamed from: a */
        CharSequence mo44312a(TextView textView, CharSequence charSequence, String str, int i, int i2);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public final void mo48669a(CharSequence charSequence, String str, int i, int i2) {
        AppMethodBeat.m2504i(106264);
        this.ysq = str;
        this.ysr = i;
        this.yss = i2;
        this.ysu = charSequence;
        setText(this.ysu + "  " + str);
        AppMethodBeat.m2505o(106264);
    }

    public void setLayoutCallback(C30360a c30360a) {
        this.yst = c30360a;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106265);
        super.onLayout(z, i, i2, i3, i4);
        if (!(getMeasuredWidth() <= 0 || C5046bo.isNullOrNil(this.ysq) || this.yst == null || getText() == null || getText().length() <= 0)) {
            CharSequence a = this.yst.mo44312a(this, this.ysu, this.ysq, this.ysr, this.yss);
            this.ysq = null;
            setText(a, BufferType.SPANNABLE);
            requestLayout();
        }
        AppMethodBeat.m2505o(106265);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.m2504i(106266);
        super.setText(charSequence, bufferType);
        AppMethodBeat.m2505o(106266);
    }
}
