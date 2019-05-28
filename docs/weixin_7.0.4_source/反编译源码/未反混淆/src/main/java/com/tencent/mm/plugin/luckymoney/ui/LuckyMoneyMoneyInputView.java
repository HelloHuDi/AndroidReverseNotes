package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView extends LinearLayout implements c {
    private TextWatcher arx = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(42739);
            if (LuckyMoneyMoneyInputView.this.nSr != null) {
                g a = LuckyMoneyMoneyInputView.this.nSr;
                LuckyMoneyMoneyInputView.this.getInputViewId();
                a.bLa();
            }
            AppMethodBeat.o(42739);
        }
    };
    private TextView iDT;
    public int mType;
    private ImageView nSO;
    private TenpaySecureEditText nSo;
    private TextView nSp;
    private g nSr;
    private i nSs;
    private double nSt;
    private double nSu;

    public void setHint(String str) {
        AppMethodBeat.i(42740);
        this.nSo.setHint(str);
        AppMethodBeat.o(42740);
    }

    public LuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42741);
        a.bKN();
        this.nSs = a.bKO().bLu();
        View inflate = LayoutInflater.from(context).inflate(R.layout.aa9, this, true);
        this.nSo = (TenpaySecureEditText) inflate.findViewById(R.id.cwy);
        this.nSo.setTypeface(e.aA(context, 3));
        this.nSo.addTextChangedListener(this.arx);
        this.iDT = (TextView) inflate.findViewById(R.id.cwx);
        this.nSO = (ImageView) inflate.findViewById(R.id.cww);
        this.nSp = (TextView) inflate.findViewById(R.id.cwz);
        AppMethodBeat.o(42741);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public double getInput() {
        AppMethodBeat.i(42742);
        double d = bo.getDouble(this.nSo.getText().toString(), 0.0d);
        AppMethodBeat.o(42742);
        return d;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(42743);
        this.iDT.setText(str);
        AppMethodBeat.o(42743);
    }

    public void setShowGroupIcon(boolean z) {
        AppMethodBeat.i(42744);
        if (z) {
            this.nSO.setVisibility(0);
            AppMethodBeat.o(42744);
            return;
        }
        this.nSO.setVisibility(8);
        AppMethodBeat.o(42744);
    }

    public void setGroupIconIv(int i) {
        AppMethodBeat.i(42745);
        this.nSO.setImageResource(i);
        AppMethodBeat.o(42745);
    }

    public void setOnInputValidChangerListener(g gVar) {
        this.nSr = gVar;
    }

    public void setMaxLen(int i) {
        AppMethodBeat.i(42746);
        this.nSo.setFilters(new InputFilter[]{new LengthFilter(i)});
        AppMethodBeat.o(42746);
    }

    public void setAmount(String str) {
        AppMethodBeat.i(42747);
        this.nSo.setText(str);
        AppMethodBeat.o(42747);
    }

    public void setMaxAmount(double d) {
        this.nSt = d;
    }

    public void setMinAmount(double d) {
        this.nSu = d;
    }

    public final int bKW() {
        AppMethodBeat.i(42748);
        if (bo.isNullOrNil(this.nSo.getText().toString())) {
            AppMethodBeat.o(42748);
            return 0;
        }
        double d = bo.getDouble(this.nSo.getText().toString(), -1.0d);
        if (d < 0.0d) {
            AppMethodBeat.o(42748);
            return 3;
        } else if (d > this.nSt && this.nSt > 0.0d) {
            AppMethodBeat.o(42748);
            return 1;
        } else if (d >= this.nSu || d <= 0.0d) {
            AppMethodBeat.o(42748);
            return 0;
        } else {
            AppMethodBeat.o(42748);
            return 2;
        }
    }

    public final void restore() {
        AppMethodBeat.i(42749);
        this.iDT.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nSo.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nSp.setTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(42749);
    }

    public final void onError() {
        AppMethodBeat.i(42750);
        this.iDT.setTextColor(x.eq(getContext()));
        this.nSo.setTextColor(x.eq(getContext()));
        this.nSp.setTextColor(x.eq(getContext()));
        AppMethodBeat.o(42750);
    }

    public int getInputViewId() {
        AppMethodBeat.i(42751);
        int id = getId();
        AppMethodBeat.o(42751);
        return id;
    }

    private boolean bMA() {
        AppMethodBeat.i(42752);
        if (this.nSs == null || bo.isNullOrNil(this.nSs.nWL)) {
            AppMethodBeat.o(42752);
            return false;
        }
        AppMethodBeat.o(42752);
        return true;
    }

    public final String xH(int i) {
        AppMethodBeat.i(42753);
        a.bKN();
        this.nSs = a.bKO().bLu();
        String string;
        if (i == 1) {
            if (this.mType == 1) {
                string = getContext().getString(R.string.ctn, new Object[]{Math.round(this.nSt), bo.bc(this.nSs.nRU, "")});
                AppMethodBeat.o(42753);
                return string;
            } else if (bMA()) {
                string = getContext().getString(R.string.cq0, new Object[]{this.nSs.nWL, Math.round(this.nSt), bo.bc(this.nSs.nRU, "")});
                AppMethodBeat.o(42753);
                return string;
            } else {
                string = getContext().getString(R.string.cpz, new Object[]{Math.round(this.nSt), bo.bc(this.nSs.nRU, "")});
                AppMethodBeat.o(42753);
                return string;
            }
        } else if (i != 2) {
            AppMethodBeat.o(42753);
            return null;
        } else if (bMA()) {
            string = getContext().getString(R.string.cq2, new Object[]{this.nSs.nWL, e.F(this.nSu), bo.bc(this.nSs.nRU, "")});
            AppMethodBeat.o(42753);
            return string;
        } else {
            string = getContext().getString(R.string.cq1, new Object[]{e.F(this.nSu), bo.bc(this.nSs.nRU, "")});
            AppMethodBeat.o(42753);
            return string;
        }
    }
}
