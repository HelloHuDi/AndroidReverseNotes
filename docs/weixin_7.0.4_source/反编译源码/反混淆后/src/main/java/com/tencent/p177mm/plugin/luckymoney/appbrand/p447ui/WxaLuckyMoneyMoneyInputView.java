package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C43249h.C12408a;
import com.tencent.p177mm.plugin.luckymoney.model.C21200i;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C12472g;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C39342c;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView */
public class WxaLuckyMoneyMoneyInputView extends LinearLayout implements C39342c {
    private TextWatcher arx = new C211881();
    private TextView iDT;
    private TenpaySecureEditText nSo;
    private TextView nSp;
    private View nSq;
    private C12472g nSr;
    private C21200i nSs;
    private double nSt;
    private double nSu;
    public C12408a nSv;

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView$1 */
    class C211881 implements TextWatcher {
        C211881() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(42003);
            if (WxaLuckyMoneyMoneyInputView.this.nSr != null) {
                C12472g a = WxaLuckyMoneyMoneyInputView.this.nSr;
                WxaLuckyMoneyMoneyInputView.this.getInputViewId();
                a.bLa();
            }
            AppMethodBeat.m2505o(42003);
        }
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(42004);
        this.nSo.setHint(str);
        AppMethodBeat.m2505o(42004);
    }

    public WxaLuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(42005);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        View inflate = LayoutInflater.from(context).inflate(2130971244, this, true);
        this.nSo = (TenpaySecureEditText) inflate.findViewById(2131825536);
        this.nSo.addTextChangedListener(this.arx);
        this.iDT = (TextView) inflate.findViewById(2131825535);
        this.nSq = inflate.findViewById(2131825534);
        this.nSp = (TextView) inflate.findViewById(2131825537);
        AppMethodBeat.m2505o(42005);
    }

    public void setType(C12408a c12408a) {
        this.nSv = c12408a;
    }

    public double getInput() {
        AppMethodBeat.m2504i(42006);
        double d = C5046bo.getDouble(this.nSo.getText().toString(), 0.0d);
        AppMethodBeat.m2505o(42006);
        return d;
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(42007);
        this.iDT.setText(str);
        AppMethodBeat.m2505o(42007);
    }

    public void setShowGroupIcon(boolean z) {
        AppMethodBeat.m2504i(42008);
        if (z) {
            this.nSq.setVisibility(0);
            AppMethodBeat.m2505o(42008);
            return;
        }
        this.nSq.setVisibility(8);
        AppMethodBeat.m2505o(42008);
    }

    public void setOnInputValidChangerListener(C12472g c12472g) {
        this.nSr = c12472g;
    }

    public void setMaxLen(int i) {
        AppMethodBeat.m2504i(42009);
        this.nSo.setFilters(new InputFilter[]{new LengthFilter(i)});
        AppMethodBeat.m2505o(42009);
    }

    public void setAmount(String str) {
        AppMethodBeat.m2504i(42010);
        this.nSo.setText(str);
        AppMethodBeat.m2505o(42010);
    }

    public void setMaxAmount(double d) {
        this.nSt = d;
    }

    public void setMinAmount(double d) {
        this.nSu = d;
    }

    public final int bKW() {
        AppMethodBeat.m2504i(42011);
        if (C5046bo.isNullOrNil(this.nSo.getText().toString())) {
            AppMethodBeat.m2505o(42011);
            return 0;
        }
        double d = C5046bo.getDouble(this.nSo.getText().toString(), -1.0d);
        if (d < 0.0d) {
            AppMethodBeat.m2505o(42011);
            return 3;
        } else if (d > this.nSt && this.nSt > 0.0d) {
            AppMethodBeat.m2505o(42011);
            return 1;
        } else if (d >= this.nSu || d <= 0.0d) {
            AppMethodBeat.m2505o(42011);
            return 0;
        } else {
            AppMethodBeat.m2505o(42011);
            return 2;
        }
    }

    public final void restore() {
        AppMethodBeat.m2504i(42012);
        this.iDT.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nSo.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nSp.setTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.m2505o(42012);
    }

    public final void onError() {
        AppMethodBeat.m2504i(42013);
        this.iDT.setTextColor(C46063x.m85817eq(getContext()));
        this.nSo.setTextColor(C46063x.m85817eq(getContext()));
        this.nSp.setTextColor(C46063x.m85817eq(getContext()));
        AppMethodBeat.m2505o(42013);
    }

    public int getInputViewId() {
        AppMethodBeat.m2504i(42014);
        int id = getId();
        AppMethodBeat.m2505o(42014);
        return id;
    }

    /* renamed from: xH */
    public final String mo36557xH(int i) {
        AppMethodBeat.m2504i(42015);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        String string;
        if (i == 1) {
            if (this.nSv == C12408a.RANDOM_LUCK) {
                string = getContext().getString(C25738R.string.ctn, new Object[]{Math.round(this.nSt), C5046bo.m7532bc(this.nSs.nRU, "")});
                AppMethodBeat.m2505o(42015);
                return string;
            }
            string = getContext().getString(C25738R.string.cpz, new Object[]{Math.round(this.nSt), C5046bo.m7532bc(this.nSs.nRU, "")});
            AppMethodBeat.m2505o(42015);
            return string;
        } else if (i == 2) {
            string = getContext().getString(C25738R.string.cq1, new Object[]{C36391e.m59971F(this.nSu), C5046bo.m7532bc(this.nSs.nRU, "")});
            AppMethodBeat.m2505o(42015);
            return string;
        } else {
            AppMethodBeat.m2505o(42015);
            return null;
        }
    }
}
