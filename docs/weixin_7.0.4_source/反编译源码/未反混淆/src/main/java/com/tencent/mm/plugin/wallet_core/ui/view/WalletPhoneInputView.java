package com.tencent.mm.plugin.wallet_core.ui.view;

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
import com.tencent.mm.R;
import com.tencent.mm.au.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletPhoneInputView extends LinearLayout {
    private int mMode = 0;
    private WalletFormView tNO;
    private WalletFormView tNP;
    private TenpaySecureEditText tNQ;
    private Map<String, a> tNR;
    private String tNS = "";
    private String tNT = "";
    private boolean tNU = true;

    public WalletPhoneInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(47913);
        init(context);
        a(context, attributeSet, -1);
        AppMethodBeat.o(47913);
    }

    public WalletPhoneInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(47914);
        init(context);
        a(context, attributeSet, i);
        AppMethodBeat.o(47914);
    }

    private void init(Context context) {
        AppMethodBeat.i(47915);
        inflate(context, R.layout.b5r, this);
        this.tNO = (WalletFormView) findViewById(R.id.ffy);
        this.tNP = (WalletFormView) findViewById(R.id.ffz);
        this.tNO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47908);
                ab.d("MicroMsg.WalletPhoneInputView", "click area");
                Intent intent = new Intent();
                intent.setClassName(WalletPhoneInputView.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
                ((MMActivity) WalletPhoneInputView.this.getContext()).startActivityForResult(intent, 65521);
                AppMethodBeat.o(47908);
            }
        });
        this.tNQ = (TenpaySecureEditText) this.tNP.findViewById(R.id.ffx);
        this.tNQ.setFixedHeaderText("+");
        if (getContext() instanceof MMActivity) {
            this.tNP.setOnInfoIvClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47909);
                    b.a((MMActivity) WalletPhoneInputView.this.getContext(), R.layout.b5p, R.string.fc3);
                    AppMethodBeat.o(47909);
                }
            });
            this.tNP.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b() {
                public final boolean a(WalletFormView walletFormView) {
                    AppMethodBeat.i(47910);
                    if (WalletPhoneInputView.this.cSA()) {
                        boolean isPhoneNum = walletFormView.isPhoneNum();
                        AppMethodBeat.o(47910);
                        return isPhoneNum;
                    } else if (bo.isNullOrNil(WalletPhoneInputView.this.tNT) || bo.isNullOrNil(WalletPhoneInputView.this.tNS) || bo.isNullOrNil(WalletPhoneInputView.this.tNP.getText())) {
                        AppMethodBeat.o(47910);
                        return false;
                    } else {
                        AppMethodBeat.o(47910);
                        return true;
                    }
                }

                public final boolean c(WalletFormView walletFormView, String str) {
                    return false;
                }

                public final boolean d(WalletFormView walletFormView, String str) {
                    return false;
                }

                public final boolean cev() {
                    return false;
                }

                public final String e(WalletFormView walletFormView, String str) {
                    return null;
                }
            });
        }
        List<a> G = com.tencent.mm.au.b.G(getContext(), getContext().getString(R.string.b3_));
        this.tNR = new HashMap();
        for (a aVar : G) {
            this.tNR.put(aVar.fHD, aVar);
        }
        AppMethodBeat.o(47915);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.i(47916);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.plugin.wxpay.a.a.WalletPhoneInputViewAttrs, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.tNP.setHint(context.getString(resourceId));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId2 != 0) {
            this.tNP.setTitleText(context.getString(resourceId2));
        }
        AppMethodBeat.o(47916);
    }

    public WalletFormView getPhoneNumberEt() {
        return this.tNP;
    }

    public String getCountryCode() {
        AppMethodBeat.i(47917);
        String str;
        if (cSA()) {
            str = "86";
            AppMethodBeat.o(47917);
            return str;
        }
        str = this.tNQ.getText().toString();
        AppMethodBeat.o(47917);
        return str;
    }

    public final boolean e(int i, int i2, Intent intent) {
        AppMethodBeat.i(47918);
        if (i == 65521) {
            if (i2 == 100) {
                String stringExtra = intent.getStringExtra("country_name");
                String stringExtra2 = intent.getStringExtra("couttry_code");
                ab.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", this.tNS, this.tNT);
                if (bo.isNullOrNil(stringExtra) || bo.isNullOrNil(stringExtra2)) {
                    ab.i("MicroMsg.WalletPhoneInputView", "cancel pick");
                    AppMethodBeat.o(47918);
                    return true;
                }
                this.tNS = stringExtra;
                this.tNT = stringExtra2;
                this.tNU = false;
                cSy();
                this.tNQ.clearFocus();
            }
            AppMethodBeat.o(47918);
            return true;
        }
        AppMethodBeat.o(47918);
        return false;
    }

    private void cSy() {
        AppMethodBeat.i(47919);
        this.tNO.setText(this.tNS);
        this.tNQ.setText(this.tNT);
        AppMethodBeat.o(47919);
    }

    private void cSz() {
        AppMethodBeat.i(47920);
        a aVar = (a) this.tNR.get("86");
        this.tNT = aVar.fHD;
        this.tNS = aVar.fHE;
        cSy();
        AppMethodBeat.o(47920);
    }

    public final boolean cSA() {
        return this.mMode == 0;
    }

    public final void cSB() {
        AppMethodBeat.i(47921);
        this.mMode = 0;
        cSz();
        this.tNO.setVisibility(8);
        this.tNQ.setVisibility(8);
        AppMethodBeat.o(47921);
    }

    public final void cSC() {
        AppMethodBeat.i(47922);
        this.mMode = 1;
        cSz();
        this.tNO.setVisibility(0);
        this.tNQ.setVisibility(0);
        this.tNQ.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(47911);
                if (bo.isNullOrNil(editable.toString())) {
                    WalletPhoneInputView.this.tNO.setText("");
                    WalletPhoneInputView.this.tNO.setContentTextColorRes(R.color.w4);
                    WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.w4));
                    AppMethodBeat.o(47911);
                } else if (WalletPhoneInputView.this.tNU) {
                    a aVar = (a) WalletPhoneInputView.this.tNR.get(editable.toString());
                    ab.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", aVar, editable.toString());
                    if (aVar != null) {
                        WalletPhoneInputView.this.tNT = aVar.fHD;
                        WalletPhoneInputView.this.tNS = aVar.fHE;
                        WalletPhoneInputView.this.tNO.setText(aVar.fHE);
                        WalletPhoneInputView.this.tNO.setContentTextColorRes(R.color.w4);
                        WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.w4));
                    } else {
                        WalletPhoneInputView.this.tNT = "";
                        WalletPhoneInputView.this.tNS = "";
                        WalletPhoneInputView.this.tNO.setText(WalletPhoneInputView.this.getContext().getString(R.string.fpu));
                    }
                    WalletPhoneInputView.this.tNP.getInputValidChangeListener().hY(WalletPhoneInputView.this.tNP.asa());
                    AppMethodBeat.o(47911);
                } else {
                    ab.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
                    WalletPhoneInputView.this.tNO.setContentTextColorRes(R.color.w4);
                    WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.w4));
                    WalletPhoneInputView.this.tNU = true;
                    AppMethodBeat.o(47911);
                }
            }
        });
        this.tNQ.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(47912);
                if (!z) {
                    if (((a) WalletPhoneInputView.this.tNR.get(WalletPhoneInputView.this.tNQ.getText().toString())) == null) {
                        WalletPhoneInputView.this.tNO.setContentTextColorRes(R.color.y0);
                        WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.y0));
                        AppMethodBeat.o(47912);
                        return;
                    }
                    WalletPhoneInputView.this.tNO.setContentTextColorRes(R.color.w4);
                    WalletPhoneInputView.this.tNQ.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.w4));
                }
                AppMethodBeat.o(47912);
            }
        });
        AppMethodBeat.o(47922);
    }
}
