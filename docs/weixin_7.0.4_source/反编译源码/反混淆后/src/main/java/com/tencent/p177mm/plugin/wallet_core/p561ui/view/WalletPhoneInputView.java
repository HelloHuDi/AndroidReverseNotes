package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.formview.C40950b;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.p1098a.C30889b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView */
public class WalletPhoneInputView extends LinearLayout {
    private int mMode = 0;
    private WalletFormView tNO;
    private WalletFormView tNP;
    private TenpaySecureEditText tNQ;
    private Map<String, C17951a> tNR;
    private String tNS = "";
    private String tNT = "";
    private boolean tNU = true;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView$1 */
    class C44561 implements OnClickListener {
        C44561() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47908);
            C4990ab.m7410d("MicroMsg.WalletPhoneInputView", "click area");
            Intent intent = new Intent();
            intent.setClassName(WalletPhoneInputView.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
            ((MMActivity) WalletPhoneInputView.this.getContext()).startActivityForResult(intent, 65521);
            AppMethodBeat.m2505o(47908);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView$2 */
    class C143252 implements OnClickListener {
        C143252() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47909);
            C40950b.m71011a((MMActivity) WalletPhoneInputView.this.getContext(), 2130971152, C25738R.string.fc3);
            AppMethodBeat.m2505o(47909);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView$3 */
    class C143263 implements C30889b {
        C143263() {
        }

        /* renamed from: a */
        public final boolean mo26604a(WalletFormView walletFormView) {
            AppMethodBeat.m2504i(47910);
            if (WalletPhoneInputView.this.cSA()) {
                boolean isPhoneNum = walletFormView.isPhoneNum();
                AppMethodBeat.m2505o(47910);
                return isPhoneNum;
            } else if (C5046bo.isNullOrNil(WalletPhoneInputView.this.tNT) || C5046bo.isNullOrNil(WalletPhoneInputView.this.tNS) || C5046bo.isNullOrNil(WalletPhoneInputView.this.tNP.getText())) {
                AppMethodBeat.m2505o(47910);
                return false;
            } else {
                AppMethodBeat.m2505o(47910);
                return true;
            }
        }

        /* renamed from: c */
        public final boolean mo26605c(WalletFormView walletFormView, String str) {
            return false;
        }

        /* renamed from: d */
        public final boolean mo26607d(WalletFormView walletFormView, String str) {
            return false;
        }

        public final boolean cev() {
            return false;
        }

        /* renamed from: e */
        public final String mo26608e(WalletFormView walletFormView, String str) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView$5 */
    class C143275 implements OnFocusChangeListener {
        C143275() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(47912);
            if (!z) {
                if (((C17951a) WalletPhoneInputView.this.tNR.get(WalletPhoneInputView.this.tNQ.getText().toString())) == null) {
                    WalletPhoneInputView.this.tNO.setContentTextColorRes(C25738R.color.f12267y0);
                    WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(C25738R.color.f12267y0));
                    AppMethodBeat.m2505o(47912);
                    return;
                }
                WalletPhoneInputView.this.tNO.setContentTextColorRes(C25738R.color.f12212w4);
                WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(C25738R.color.f12212w4));
            }
            AppMethodBeat.m2505o(47912);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView$4 */
    class C143284 implements TextWatcher {
        C143284() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(47911);
            if (C5046bo.isNullOrNil(editable.toString())) {
                WalletPhoneInputView.this.tNO.setText("");
                WalletPhoneInputView.this.tNO.setContentTextColorRes(C25738R.color.f12212w4);
                WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(C25738R.color.f12212w4));
                AppMethodBeat.m2505o(47911);
            } else if (WalletPhoneInputView.this.tNU) {
                C17951a c17951a = (C17951a) WalletPhoneInputView.this.tNR.get(editable.toString());
                C4990ab.m7411d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", c17951a, editable.toString());
                if (c17951a != null) {
                    WalletPhoneInputView.this.tNT = c17951a.fHD;
                    WalletPhoneInputView.this.tNS = c17951a.fHE;
                    WalletPhoneInputView.this.tNO.setText(c17951a.fHE);
                    WalletPhoneInputView.this.tNO.setContentTextColorRes(C25738R.color.f12212w4);
                    WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(C25738R.color.f12212w4));
                } else {
                    WalletPhoneInputView.this.tNT = "";
                    WalletPhoneInputView.this.tNS = "";
                    WalletPhoneInputView.this.tNO.setText(WalletPhoneInputView.this.getContext().getString(C25738R.string.fpu));
                }
                WalletPhoneInputView.this.tNP.getInputValidChangeListener().mo9407hY(WalletPhoneInputView.this.tNP.asa());
                AppMethodBeat.m2505o(47911);
            } else {
                C4990ab.m7416i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
                WalletPhoneInputView.this.tNO.setContentTextColorRes(C25738R.color.f12212w4);
                WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(C25738R.color.f12212w4));
                WalletPhoneInputView.this.tNU = true;
                AppMethodBeat.m2505o(47911);
            }
        }
    }

    public WalletPhoneInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(47913);
        init(context);
        m22496a(context, attributeSet, -1);
        AppMethodBeat.m2505o(47913);
    }

    public WalletPhoneInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(47914);
        init(context);
        m22496a(context, attributeSet, i);
        AppMethodBeat.m2505o(47914);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(47915);
        WalletPhoneInputView.inflate(context, 2130971154, this);
        this.tNO = (WalletFormView) findViewById(2131829014);
        this.tNP = (WalletFormView) findViewById(2131829015);
        this.tNO.setOnClickListener(new C44561());
        this.tNQ = (TenpaySecureEditText) this.tNP.findViewById(2131829013);
        this.tNQ.setFixedHeaderText("+");
        if (getContext() instanceof MMActivity) {
            this.tNP.setOnInfoIvClickListener(new C143252());
            this.tNP.setLogicDelegate(new C143263());
        }
        List<C17951a> G = C17950b.m28209G(getContext(), getContext().getString(C25738R.string.b3_));
        this.tNR = new HashMap();
        for (C17951a c17951a : G) {
            this.tNR.put(c17951a.fHD, c17951a);
        }
        AppMethodBeat.m2505o(47915);
    }

    /* renamed from: a */
    private void m22496a(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.m2504i(47916);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.WalletPhoneInputViewAttrs, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.tNP.setHint(context.getString(resourceId));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId2 != 0) {
            this.tNP.setTitleText(context.getString(resourceId2));
        }
        AppMethodBeat.m2505o(47916);
    }

    public WalletFormView getPhoneNumberEt() {
        return this.tNP;
    }

    public String getCountryCode() {
        AppMethodBeat.m2504i(47917);
        String str;
        if (cSA()) {
            str = "86";
            AppMethodBeat.m2505o(47917);
            return str;
        }
        str = this.tNQ.getText().toString();
        AppMethodBeat.m2505o(47917);
        return str;
    }

    /* renamed from: e */
    public final boolean mo26600e(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(47918);
        if (i == 65521) {
            if (i2 == 100) {
                String stringExtra = intent.getStringExtra("country_name");
                String stringExtra2 = intent.getStringExtra("couttry_code");
                C4990ab.m7417i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", this.tNS, this.tNT);
                if (C5046bo.isNullOrNil(stringExtra) || C5046bo.isNullOrNil(stringExtra2)) {
                    C4990ab.m7416i("MicroMsg.WalletPhoneInputView", "cancel pick");
                    AppMethodBeat.m2505o(47918);
                    return true;
                }
                this.tNS = stringExtra;
                this.tNT = stringExtra2;
                this.tNU = false;
                cSy();
                this.tNQ.clearFocus();
            }
            AppMethodBeat.m2505o(47918);
            return true;
        }
        AppMethodBeat.m2505o(47918);
        return false;
    }

    private void cSy() {
        AppMethodBeat.m2504i(47919);
        this.tNO.setText(this.tNS);
        this.tNQ.setText(this.tNT);
        AppMethodBeat.m2505o(47919);
    }

    private void cSz() {
        AppMethodBeat.m2504i(47920);
        C17951a c17951a = (C17951a) this.tNR.get("86");
        this.tNT = c17951a.fHD;
        this.tNS = c17951a.fHE;
        cSy();
        AppMethodBeat.m2505o(47920);
    }

    public final boolean cSA() {
        return this.mMode == 0;
    }

    public final void cSB() {
        AppMethodBeat.m2504i(47921);
        this.mMode = 0;
        cSz();
        this.tNO.setVisibility(8);
        this.tNQ.setVisibility(8);
        AppMethodBeat.m2505o(47921);
    }

    public final void cSC() {
        AppMethodBeat.m2504i(47922);
        this.mMode = 1;
        cSz();
        this.tNO.setVisibility(0);
        this.tNQ.setVisibility(0);
        this.tNQ.addTextChangedListener(new C143284());
        this.tNQ.setOnFocusChangeListener(new C143275());
        AppMethodBeat.m2505o(47922);
    }
}
