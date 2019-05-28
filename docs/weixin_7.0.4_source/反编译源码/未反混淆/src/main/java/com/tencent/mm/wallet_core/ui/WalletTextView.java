package com.tencent.mm.wallet_core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.widget.j;
import android.text.Selection;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
public class WalletTextView extends TextView {
    private static final String TAG = ("MicroMsg." + new StringBuilder("weiVtxeTtellaW").reverse().toString());
    private Object AhP;
    private int AhQ;
    private String mPrefix;
    private Object xzW;

    static {
        AppMethodBeat.i(49352);
        AppMethodBeat.o(49352);
    }

    public WalletTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WalletTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(49345);
        this.xzW = "";
        this.AhP = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.WalletTextViewAttrs, i, 0);
        this.AhQ = obtainStyledAttributes.getInteger(0, 4);
        this.mPrefix = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        dON();
        AppMethodBeat.o(49345);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        Object obj;
        AppMethodBeat.i(49346);
        this.xzW = charSequence;
        String charSequence2 = charSequence.toString();
        if (charSequence2 == null || charSequence2.length() == 0) {
            obj = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder(7);
            for (int i = 0; i < 7; i++) {
                stringBuilder.append((char) ((int) ((6222620280936476253L >> ((6 - i) * 8)) & 255)));
            }
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            obj = charSequence2.replaceAll(stringBuilder2, stringBuilder.toString());
        }
        this.AhP = obj;
        if (!bo.isNullOrNil(this.mPrefix)) {
            charSequence = this.mPrefix + charSequence;
        }
        if (!(this.AhQ == 4 || bo.ac(charSequence) || !Pattern.compile(".*?[a-zA-Z]+.*?").matcher(charSequence).matches())) {
            ab.i(TAG, "force use std font");
            this.AhQ = 4;
            dON();
        }
        super.setText(charSequence, bufferType);
        AppMethodBeat.o(49346);
    }

    private void dON() {
        AppMethodBeat.i(49347);
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), e.QQ(this.AhQ)));
        AppMethodBeat.o(49347);
    }

    public void setTypeface(int i) {
        AppMethodBeat.i(49348);
        this.AhQ = i;
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), e.QQ(i)));
        AppMethodBeat.o(49348);
    }

    public void setPrefix(String str) {
        this.mPrefix = str;
    }

    @Deprecated
    public CharSequence getText() {
        boolean z;
        AppMethodBeat.i(49349);
        com.tencent.mm.wallet_core.f.a dOl = com.tencent.mm.wallet_core.f.a.dOl();
        if (!b.oTO.cg(this)) {
            z = true;
        } else if (dOl.Ags.containsKey(this)) {
            z = false;
        } else {
            dOl.Ags.put(this, Boolean.TRUE);
            e.pXa.a(715, 0, 1, false);
            if ((com.tencent.mm.wallet_core.f.b.dOo() || h.Ms()) && com.tencent.mm.wallet_core.f.b.dOm()) {
                d.qjp.Ch(j.INVALID_ID);
            }
            z = false;
        }
        CharSequence charSequence;
        if (z) {
            charSequence = (CharSequence) this.xzW;
            AppMethodBeat.o(49349);
            return charSequence;
        }
        ab.printErrStackTrace(TAG, new Throwable(), "check point 0.", new Object[0]);
        if (com.tencent.mm.wallet_core.f.b.dOo() || h.Ms()) {
            charSequence = (CharSequence) (com.tencent.mm.wallet_core.f.b.dOn() ? this.AhP : this.xzW);
            AppMethodBeat.o(49349);
            return charSequence;
        }
        charSequence = (CharSequence) this.xzW;
        AppMethodBeat.o(49349);
        return charSequence;
    }

    public int getSelectionStart() {
        AppMethodBeat.i(49350);
        int selectionStart = Selection.getSelectionStart((CharSequence) this.xzW);
        AppMethodBeat.o(49350);
        return selectionStart;
    }

    public int getSelectionEnd() {
        AppMethodBeat.i(49351);
        int selectionEnd = Selection.getSelectionEnd((CharSequence) this.xzW);
        AppMethodBeat.o(49351);
        return selectionEnd;
    }
}
