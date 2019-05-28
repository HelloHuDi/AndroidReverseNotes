package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class EllipsizeTextView extends TextView {
    private String ysq;
    private int ysr;
    private int yss;
    private a yst;
    private CharSequence ysu;
    private long ysv = -1;

    public interface a {
        CharSequence a(TextView textView, CharSequence charSequence, String str, int i, int i2);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(CharSequence charSequence, String str, int i, int i2) {
        AppMethodBeat.i(106264);
        this.ysq = str;
        this.ysr = i;
        this.yss = i2;
        this.ysu = charSequence;
        setText(this.ysu + "  " + str);
        AppMethodBeat.o(106264);
    }

    public void setLayoutCallback(a aVar) {
        this.yst = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106265);
        super.onLayout(z, i, i2, i3, i4);
        if (!(getMeasuredWidth() <= 0 || bo.isNullOrNil(this.ysq) || this.yst == null || getText() == null || getText().length() <= 0)) {
            CharSequence a = this.yst.a(this, this.ysu, this.ysq, this.ysr, this.yss);
            this.ysq = null;
            setText(a, BufferType.SPANNABLE);
            requestLayout();
        }
        AppMethodBeat.o(106265);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.i(106266);
        super.setText(charSequence, bufferType);
        AppMethodBeat.o(106266);
    }
}
