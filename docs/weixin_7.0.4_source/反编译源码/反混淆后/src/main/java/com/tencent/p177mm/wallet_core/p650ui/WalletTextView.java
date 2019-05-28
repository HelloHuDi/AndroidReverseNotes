package com.tencent.p177mm.wallet_core.p650ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.p057v4.widget.C8415j;
import android.text.Selection;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C44761d;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p1576f.C40939a;
import com.tencent.p177mm.wallet_core.p1576f.C40941b;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.tencent.mm.wallet_core.ui.WalletTextView */
public class WalletTextView extends TextView {
    private static final String TAG = ("MicroMsg." + new StringBuilder("weiVtxeTtellaW").reverse().toString());
    private Object AhP;
    private int AhQ;
    private String mPrefix;
    private Object xzW;

    static {
        AppMethodBeat.m2504i(49352);
        AppMethodBeat.m2505o(49352);
    }

    public WalletTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WalletTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(49345);
        this.xzW = "";
        this.AhP = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.WalletTextViewAttrs, i, 0);
        this.AhQ = obtainStyledAttributes.getInteger(0, 4);
        this.mPrefix = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        dON();
        AppMethodBeat.m2505o(49345);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        Object obj;
        AppMethodBeat.m2504i(49346);
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
        if (!C5046bo.isNullOrNil(this.mPrefix)) {
            charSequence = this.mPrefix + charSequence;
        }
        if (!(this.AhQ == 4 || C5046bo.m7519ac(charSequence) || !Pattern.compile(".*?[a-zA-Z]+.*?").matcher(charSequence).matches())) {
            C4990ab.m7416i(TAG, "force use std font");
            this.AhQ = 4;
            dON();
        }
        super.setText(charSequence, bufferType);
        AppMethodBeat.m2505o(49346);
    }

    private void dON() {
        AppMethodBeat.m2504i(49347);
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), C36391e.m59976QQ(this.AhQ)));
        AppMethodBeat.m2505o(49347);
    }

    public void setTypeface(int i) {
        AppMethodBeat.m2504i(49348);
        this.AhQ = i;
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), C36391e.m59976QQ(i)));
        AppMethodBeat.m2505o(49348);
    }

    public void setPrefix(String str) {
        this.mPrefix = str;
    }

    @Deprecated
    public CharSequence getText() {
        boolean z;
        AppMethodBeat.m2504i(49349);
        C40939a dOl = C40939a.dOl();
        if (!C6998b.oTO.mo8106cg(this)) {
            z = true;
        } else if (dOl.Ags.containsKey(this)) {
            z = false;
        } else {
            dOl.Ags.put(this, Boolean.TRUE);
            C7053e.pXa.mo8378a(715, 0, 1, false);
            if ((C40941b.dOo() || C1448h.m3076Ms()) && C40941b.dOm()) {
                C44761d.qjp.mo8446Ch(C8415j.INVALID_ID);
            }
            z = false;
        }
        CharSequence charSequence;
        if (z) {
            charSequence = (CharSequence) this.xzW;
            AppMethodBeat.m2505o(49349);
            return charSequence;
        }
        C4990ab.printErrStackTrace(TAG, new Throwable(), "check point 0.", new Object[0]);
        if (C40941b.dOo() || C1448h.m3076Ms()) {
            charSequence = (CharSequence) (C40941b.dOn() ? this.AhP : this.xzW);
            AppMethodBeat.m2505o(49349);
            return charSequence;
        }
        charSequence = (CharSequence) this.xzW;
        AppMethodBeat.m2505o(49349);
        return charSequence;
    }

    public int getSelectionStart() {
        AppMethodBeat.m2504i(49350);
        int selectionStart = Selection.getSelectionStart((CharSequence) this.xzW);
        AppMethodBeat.m2505o(49350);
        return selectionStart;
    }

    public int getSelectionEnd() {
        AppMethodBeat.m2504i(49351);
        int selectionEnd = Selection.getSelectionEnd((CharSequence) this.xzW);
        AppMethodBeat.m2505o(49351);
        return selectionEnd;
    }
}
