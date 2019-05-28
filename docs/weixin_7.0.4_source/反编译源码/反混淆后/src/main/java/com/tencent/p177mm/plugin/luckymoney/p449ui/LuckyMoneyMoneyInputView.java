package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.luckymoney.model.C21200i;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView */
public class LuckyMoneyMoneyInputView extends LinearLayout implements C39342c {
    private TextWatcher arx = new C412931();
    private TextView iDT;
    public int mType;
    private ImageView nSO;
    private TenpaySecureEditText nSo;
    private TextView nSp;
    private C12472g nSr;
    private C21200i nSs;
    private double nSt;
    private double nSu;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView$1 */
    class C412931 implements TextWatcher {
        C412931() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(42739);
            if (LuckyMoneyMoneyInputView.this.nSr != null) {
                C12472g a = LuckyMoneyMoneyInputView.this.nSr;
                LuckyMoneyMoneyInputView.this.getInputViewId();
                a.bLa();
            }
            AppMethodBeat.m2505o(42739);
        }
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(42740);
        this.nSo.setHint(str);
        AppMethodBeat.m2505o(42740);
    }

    public LuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(42741);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        View inflate = LayoutInflater.from(context).inflate(2130969984, this, true);
        this.nSo = (TenpaySecureEditText) inflate.findViewById(2131825536);
        this.nSo.setTypeface(C36391e.m59989aA(context, 3));
        this.nSo.addTextChangedListener(this.arx);
        this.iDT = (TextView) inflate.findViewById(2131825535);
        this.nSO = (ImageView) inflate.findViewById(2131825534);
        this.nSp = (TextView) inflate.findViewById(2131825537);
        AppMethodBeat.m2505o(42741);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public double getInput() {
        AppMethodBeat.m2504i(42742);
        double d = C5046bo.getDouble(this.nSo.getText().toString(), 0.0d);
        AppMethodBeat.m2505o(42742);
        return d;
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(42743);
        this.iDT.setText(str);
        AppMethodBeat.m2505o(42743);
    }

    public void setShowGroupIcon(boolean z) {
        AppMethodBeat.m2504i(42744);
        if (z) {
            this.nSO.setVisibility(0);
            AppMethodBeat.m2505o(42744);
            return;
        }
        this.nSO.setVisibility(8);
        AppMethodBeat.m2505o(42744);
    }

    public void setGroupIconIv(int i) {
        AppMethodBeat.m2504i(42745);
        this.nSO.setImageResource(i);
        AppMethodBeat.m2505o(42745);
    }

    public void setOnInputValidChangerListener(C12472g c12472g) {
        this.nSr = c12472g;
    }

    public void setMaxLen(int i) {
        AppMethodBeat.m2504i(42746);
        this.nSo.setFilters(new InputFilter[]{new LengthFilter(i)});
        AppMethodBeat.m2505o(42746);
    }

    public void setAmount(String str) {
        AppMethodBeat.m2504i(42747);
        this.nSo.setText(str);
        AppMethodBeat.m2505o(42747);
    }

    public void setMaxAmount(double d) {
        this.nSt = d;
    }

    public void setMinAmount(double d) {
        this.nSu = d;
    }

    public final int bKW() {
        AppMethodBeat.m2504i(42748);
        if (C5046bo.isNullOrNil(this.nSo.getText().toString())) {
            AppMethodBeat.m2505o(42748);
            return 0;
        }
        double d = C5046bo.getDouble(this.nSo.getText().toString(), -1.0d);
        if (d < 0.0d) {
            AppMethodBeat.m2505o(42748);
            return 3;
        } else if (d > this.nSt && this.nSt > 0.0d) {
            AppMethodBeat.m2505o(42748);
            return 1;
        } else if (d >= this.nSu || d <= 0.0d) {
            AppMethodBeat.m2505o(42748);
            return 0;
        } else {
            AppMethodBeat.m2505o(42748);
            return 2;
        }
    }

    public final void restore() {
        AppMethodBeat.m2504i(42749);
        this.iDT.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nSo.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nSp.setTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.m2505o(42749);
    }

    public final void onError() {
        AppMethodBeat.m2504i(42750);
        this.iDT.setTextColor(C46063x.m85817eq(getContext()));
        this.nSo.setTextColor(C46063x.m85817eq(getContext()));
        this.nSp.setTextColor(C46063x.m85817eq(getContext()));
        AppMethodBeat.m2505o(42750);
    }

    public int getInputViewId() {
        AppMethodBeat.m2504i(42751);
        int id = getId();
        AppMethodBeat.m2505o(42751);
        return id;
    }

    private boolean bMA() {
        AppMethodBeat.m2504i(42752);
        if (this.nSs == null || C5046bo.isNullOrNil(this.nSs.nWL)) {
            AppMethodBeat.m2505o(42752);
            return false;
        }
        AppMethodBeat.m2505o(42752);
        return true;
    }

    /* renamed from: xH */
    public final String mo36557xH(int i) {
        AppMethodBeat.m2504i(42753);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        String string;
        if (i == 1) {
            if (this.mType == 1) {
                string = getContext().getString(C25738R.string.ctn, new Object[]{Math.round(this.nSt), C5046bo.m7532bc(this.nSs.nRU, "")});
                AppMethodBeat.m2505o(42753);
                return string;
            } else if (bMA()) {
                string = getContext().getString(C25738R.string.cq0, new Object[]{this.nSs.nWL, Math.round(this.nSt), C5046bo.m7532bc(this.nSs.nRU, "")});
                AppMethodBeat.m2505o(42753);
                return string;
            } else {
                string = getContext().getString(C25738R.string.cpz, new Object[]{Math.round(this.nSt), C5046bo.m7532bc(this.nSs.nRU, "")});
                AppMethodBeat.m2505o(42753);
                return string;
            }
        } else if (i != 2) {
            AppMethodBeat.m2505o(42753);
            return null;
        } else if (bMA()) {
            string = getContext().getString(C25738R.string.cq2, new Object[]{this.nSs.nWL, C36391e.m59971F(this.nSu), C5046bo.m7532bc(this.nSs.nRU, "")});
            AppMethodBeat.m2505o(42753);
            return string;
        } else {
            string = getContext().getString(C25738R.string.cq1, new Object[]{C36391e.m59971F(this.nSu), C5046bo.m7532bc(this.nSs.nRU, "")});
            AppMethodBeat.m2505o(42753);
            return string;
        }
    }
}
