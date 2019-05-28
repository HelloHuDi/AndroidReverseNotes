package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView extends LinearLayout {
    private Context mContext;
    private TextView tUW;
    private CustomFitTextView tUX;
    private String tUY;

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        CharSequence charSequence;
        super(context, attributeSet);
        AppMethodBeat.i(48594);
        this.mContext = context;
        String str = "";
        String str2 = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.EditHintView, -1, 0);
            int resourceId = obtainStyledAttributes.getResourceId(7, 0);
            if (resourceId != 0) {
                str = this.mContext.getString(resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(6, 0);
            if (resourceId != 0) {
                str2 = this.mContext.getString(resourceId);
            }
            boolean z2 = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
            z = z2;
            charSequence = str;
        } else {
            z = false;
            Object charSequence2 = str;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.akc, this, true);
        this.tUW = (TextView) inflate.findViewById(R.id.n0);
        this.tUX = (CustomFitTextView) inflate.findViewById(R.id.bbq);
        this.tUW.setText(charSequence2);
        CustomFitTextView customFitTextView = this.tUX;
        customFitTextView.a(str2, customFitTextView.maxLines, customFitTextView.zBN, customFitTextView.zBL, customFitTextView.getResources().getColor(R.color.s0));
        if (z) {
            this.tUX.setEnabled(false);
            this.tUX.setTextColor(getResources().getColor(R.color.a8k));
            this.tUX.setFocusable(false);
            this.tUX.setClickable(false);
            this.tUX.setBackgroundResource(R.drawable.a8g);
            setBackgroundResource(R.drawable.k5);
            AppMethodBeat.o(48594);
            return;
        }
        this.tUX.setEnabled(false);
        this.tUX.setFocusable(false);
        this.tUX.setClickable(false);
        this.tUX.setBackgroundResource(R.drawable.a8g);
        setBackgroundResource(R.drawable.a_q);
        AppMethodBeat.o(48594);
    }

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setQuestionText(String str) {
        AppMethodBeat.i(48595);
        this.tUY = str;
        KeyListener keyListener = this.tUX.getKeyListener();
        this.tUX.setInputType(1);
        this.tUX.setKeyListener(null);
        setValStr(str);
        this.tUX.setKeyListener(keyListener);
        AppMethodBeat.o(48595);
    }

    public String getCurrentQuestion() {
        return this.tUY;
    }

    public void setValStr(String str) {
        AppMethodBeat.i(48596);
        CustomFitTextView customFitTextView = this.tUX;
        customFitTextView.a(str, 3, false, -1, customFitTextView.getCurrentTextColor());
        AppMethodBeat.o(48596);
    }

    public final boolean asa() {
        AppMethodBeat.i(48597);
        if (bo.isNullOrNil(this.tUY)) {
            AppMethodBeat.o(48597);
            return false;
        }
        AppMethodBeat.o(48597);
        return true;
    }
}
