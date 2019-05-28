package com.tencent.p177mm.plugin.wallet_payu.security_question.p574ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.tools.CustomFitTextView;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionView */
public class WalletPayUSecurityQuestionView extends LinearLayout {
    private Context mContext;
    private TextView tUW;
    private CustomFitTextView tUX;
    private String tUY;

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        CharSequence charSequence;
        super(context, attributeSet);
        AppMethodBeat.m2504i(48594);
        this.mContext = context;
        String str = "";
        String str2 = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, C23227a.EditHintView, -1, 0);
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
        View inflate = LayoutInflater.from(this.mContext).inflate(2130970359, this, true);
        this.tUW = (TextView) inflate.findViewById(2131821051);
        this.tUX = (CustomFitTextView) inflate.findViewById(2131823383);
        this.tUW.setText(charSequence2);
        CustomFitTextView customFitTextView = this.tUX;
        customFitTextView.mo70245a(str2, customFitTextView.maxLines, customFitTextView.zBN, customFitTextView.zBL, customFitTextView.getResources().getColor(C25738R.color.f12092s0));
        if (z) {
            this.tUX.setEnabled(false);
            this.tUX.setTextColor(getResources().getColor(C25738R.color.a8k));
            this.tUX.setFocusable(false);
            this.tUX.setClickable(false);
            this.tUX.setBackgroundResource(C25738R.drawable.a8g);
            setBackgroundResource(C25738R.drawable.f6623k5);
            AppMethodBeat.m2505o(48594);
            return;
        }
        this.tUX.setEnabled(false);
        this.tUX.setFocusable(false);
        this.tUX.setClickable(false);
        this.tUX.setBackgroundResource(C25738R.drawable.a8g);
        setBackgroundResource(C25738R.drawable.a_q);
        AppMethodBeat.m2505o(48594);
    }

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setQuestionText(String str) {
        AppMethodBeat.m2504i(48595);
        this.tUY = str;
        KeyListener keyListener = this.tUX.getKeyListener();
        this.tUX.setInputType(1);
        this.tUX.setKeyListener(null);
        setValStr(str);
        this.tUX.setKeyListener(keyListener);
        AppMethodBeat.m2505o(48595);
    }

    public String getCurrentQuestion() {
        return this.tUY;
    }

    public void setValStr(String str) {
        AppMethodBeat.m2504i(48596);
        CustomFitTextView customFitTextView = this.tUX;
        customFitTextView.mo70245a(str, 3, false, -1, customFitTextView.getCurrentTextColor());
        AppMethodBeat.m2505o(48596);
    }

    public final boolean asa() {
        AppMethodBeat.m2504i(48597);
        if (C5046bo.isNullOrNil(this.tUY)) {
            AppMethodBeat.m2505o(48597);
            return false;
        }
        AppMethodBeat.m2505o(48597);
        return true;
    }
}
