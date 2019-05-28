package com.tencent.p177mm.plugin.luckymoney.p449ui;

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
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.luckymoney.model.C21200i;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView */
public class LuckyMoneyNumInputView extends LinearLayout implements C39342c {
    private TextWatcher arx = new C344881();
    private TextView iDT;
    private int mNum = 1;
    private C12472g nSr;
    private C21200i nSs;
    private TenpaySecureEditText ogB;
    private TextView ogC;
    private int ogD = BaseClientBuilder.API_PRIORITY_OTHER;
    private int ogE = 1;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView$1 */
    class C344881 implements TextWatcher {
        C344881() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(42881);
            if (LuckyMoneyNumInputView.this.nSr != null) {
                C12472g a = LuckyMoneyNumInputView.this.nSr;
                LuckyMoneyNumInputView.this.getInputViewId();
                a.bLa();
            }
            AppMethodBeat.m2505o(42881);
        }
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(42882);
        this.ogB.setHint(str);
        AppMethodBeat.m2505o(42882);
    }

    public LuckyMoneyNumInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(42883);
        View inflate = LayoutInflater.from(context).inflate(2130969991, this, true);
        this.iDT = (TextView) inflate.findViewById(2131825597);
        this.ogB = (TenpaySecureEditText) inflate.findViewById(2131825536);
        this.ogC = (TextView) inflate.findViewById(2131825598);
        this.ogB.setText(this.mNum);
        this.ogB.addTextChangedListener(this.arx);
        AppMethodBeat.m2505o(42883);
    }

    public void setMaxNum(int i) {
        int i2 = 3;
        AppMethodBeat.m2504i(42884);
        this.ogD = i;
        int i3 = 0;
        while (i > 0) {
            i3++;
            i /= 10;
        }
        if (i3 > 3) {
            i2 = i3;
        }
        this.ogB.setFilters(new InputFilter[]{new LengthFilter(i2)});
        AppMethodBeat.m2505o(42884);
    }

    public void setMinNum(int i) {
        this.ogE = i;
    }

    public int getInput() {
        AppMethodBeat.m2504i(42885);
        try {
            int parseInt = Integer.parseInt(this.ogB.getText().toString(), 10);
            AppMethodBeat.m2505o(42885);
            return parseInt;
        } catch (Exception e) {
            AppMethodBeat.m2505o(42885);
            return 0;
        }
    }

    public void setNum(String str) {
        AppMethodBeat.m2504i(42886);
        this.ogB.setText(str);
        this.ogB.setSelection(this.ogB.getText().length());
        this.mNum = C5046bo.getInt(str, 0);
        AppMethodBeat.m2505o(42886);
    }

    public void setOnInputValidChangerListener(C12472g c12472g) {
        this.nSr = c12472g;
    }

    public final int bKW() {
        AppMethodBeat.m2504i(42887);
        if (C5046bo.isNullOrNil(this.ogB.getText().toString())) {
            AppMethodBeat.m2505o(42887);
            return 0;
        }
        int i = C5046bo.getInt(this.ogB.getText().toString(), -1);
        if (i < 0) {
            AppMethodBeat.m2505o(42887);
            return 3;
        } else if (i > this.ogD && this.ogD > 0) {
            AppMethodBeat.m2505o(42887);
            return 1;
        } else if (i >= this.ogE || this.ogE <= 0) {
            AppMethodBeat.m2505o(42887);
            return 0;
        } else {
            AppMethodBeat.m2505o(42887);
            return 2;
        }
    }

    public final void restore() {
        AppMethodBeat.m2504i(42888);
        this.iDT.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ogB.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ogC.setTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.m2505o(42888);
    }

    public final void onError() {
        AppMethodBeat.m2504i(42889);
        this.iDT.setTextColor(C46063x.m85817eq(getContext()));
        this.ogB.setTextColor(C46063x.m85817eq(getContext()));
        this.ogC.setTextColor(C46063x.m85817eq(getContext()));
        AppMethodBeat.m2505o(42889);
    }

    public int getInputViewId() {
        AppMethodBeat.m2504i(42890);
        int id = getId();
        AppMethodBeat.m2505o(42890);
        return id;
    }

    private boolean bMA() {
        AppMethodBeat.m2504i(42891);
        if (this.nSs == null || C5046bo.isNullOrNil(this.nSs.nWL)) {
            AppMethodBeat.m2505o(42891);
            return false;
        }
        AppMethodBeat.m2505o(42891);
        return true;
    }

    /* renamed from: xH */
    public final String mo36557xH(int i) {
        AppMethodBeat.m2504i(42892);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        String string;
        if (i == 1) {
            if (bMA()) {
                string = getContext().getString(C25738R.string.cs5, new Object[]{Integer.valueOf(this.ogD), this.nSs.nWL});
                AppMethodBeat.m2505o(42892);
                return string;
            }
            string = getContext().getString(C25738R.string.cs4, new Object[]{Integer.valueOf(this.ogD)});
            AppMethodBeat.m2505o(42892);
            return string;
        } else if (i != 2) {
            AppMethodBeat.m2505o(42892);
            return null;
        } else if (bMA()) {
            string = getContext().getString(C25738R.string.cs3, new Object[]{Integer.valueOf(this.ogE), this.nSs.nWL});
            AppMethodBeat.m2505o(42892);
            return string;
        } else {
            string = getContext().getString(C25738R.string.cs2, new Object[]{Integer.valueOf(this.ogE)});
            AppMethodBeat.m2505o(42892);
            return string;
        }
    }
}
