package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.widget.h.a;

@SuppressLint({"AppCompatCustomView"})
public class d extends TextView implements e {
    private a iTW;
    private boolean ikj;

    public d(Context context) {
        super(context);
        AppMethodBeat.i(126658);
        super.setIncludeFontPadding(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setSpannableFactory(new Factory() {
            public final Spannable newSpannable(CharSequence charSequence) {
                AppMethodBeat.i(126657);
                Spannable newSpannable = super.newSpannable(charSequence);
                if (!(d.this.iTW == null || TextUtils.isEmpty(newSpannable))) {
                    newSpannable.setSpan(d.this.iTW, 0, newSpannable.length(), 18);
                }
                AppMethodBeat.o(126657);
                return newSpannable;
            }
        });
        AppMethodBeat.o(126658);
    }

    public void setLineHeight(int i) {
        AppMethodBeat.i(126659);
        if (this.iTW == null) {
            this.iTW = new a((float) i);
        }
        if (this.iTW.ax((float) i)) {
            invalidate();
            AppMethodBeat.o(126659);
            return;
        }
        AppMethodBeat.o(126659);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.i(126660);
        if (bufferType == BufferType.NORMAL) {
            bufferType = BufferType.SPANNABLE;
        }
        super.setText(charSequence, bufferType);
        AppMethodBeat.o(126660);
    }

    public void setInterceptEvent(boolean z) {
        this.ikj = z;
    }

    public final boolean aCH() {
        return this.ikj;
    }
}
