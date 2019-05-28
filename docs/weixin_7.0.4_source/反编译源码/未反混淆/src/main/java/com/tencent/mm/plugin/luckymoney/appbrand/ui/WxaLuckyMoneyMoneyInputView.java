package com.tencent.mm.plugin.luckymoney.appbrand.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView extends LinearLayout implements c {
    private TextWatcher arx = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(42003);
            if (WxaLuckyMoneyMoneyInputView.this.nSr != null) {
                g a = WxaLuckyMoneyMoneyInputView.this.nSr;
                WxaLuckyMoneyMoneyInputView.this.getInputViewId();
                a.bLa();
            }
            AppMethodBeat.o(42003);
        }
    };
    private TextView iDT;
    private TenpaySecureEditText nSo;
    private TextView nSp;
    private View nSq;
    private g nSr;
    private i nSs;
    private double nSt;
    private double nSu;
    public a nSv;

    public void setHint(String str) {
        AppMethodBeat.i(42004);
        this.nSo.setHint(str);
        AppMethodBeat.o(42004);
    }

    public WxaLuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42005);
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        this.nSs = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
        View inflate = LayoutInflater.from(context).inflate(R.layout.b87, this, true);
        this.nSo = (TenpaySecureEditText) inflate.findViewById(R.id.cwy);
        this.nSo.addTextChangedListener(this.arx);
        this.iDT = (TextView) inflate.findViewById(R.id.cwx);
        this.nSq = inflate.findViewById(R.id.cww);
        this.nSp = (TextView) inflate.findViewById(R.id.cwz);
        AppMethodBeat.o(42005);
    }

    public void setType(a aVar) {
        this.nSv = aVar;
    }

    public double getInput() {
        AppMethodBeat.i(42006);
        double d = bo.getDouble(this.nSo.getText().toString(), 0.0d);
        AppMethodBeat.o(42006);
        return d;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(42007);
        this.iDT.setText(str);
        AppMethodBeat.o(42007);
    }

    public void setShowGroupIcon(boolean z) {
        AppMethodBeat.i(42008);
        if (z) {
            this.nSq.setVisibility(0);
            AppMethodBeat.o(42008);
            return;
        }
        this.nSq.setVisibility(8);
        AppMethodBeat.o(42008);
    }

    public void setOnInputValidChangerListener(g gVar) {
        this.nSr = gVar;
    }

    public void setMaxLen(int i) {
        AppMethodBeat.i(42009);
        this.nSo.setFilters(new InputFilter[]{new LengthFilter(i)});
        AppMethodBeat.o(42009);
    }

    public void setAmount(String str) {
        AppMethodBeat.i(42010);
        this.nSo.setText(str);
        AppMethodBeat.o(42010);
    }

    public void setMaxAmount(double d) {
        this.nSt = d;
    }

    public void setMinAmount(double d) {
        this.nSu = d;
    }

    public final int bKW() {
        AppMethodBeat.i(42011);
        if (bo.isNullOrNil(this.nSo.getText().toString())) {
            AppMethodBeat.o(42011);
            return 0;
        }
        double d = bo.getDouble(this.nSo.getText().toString(), -1.0d);
        if (d < 0.0d) {
            AppMethodBeat.o(42011);
            return 3;
        } else if (d > this.nSt && this.nSt > 0.0d) {
            AppMethodBeat.o(42011);
            return 1;
        } else if (d >= this.nSu || d <= 0.0d) {
            AppMethodBeat.o(42011);
            return 0;
        } else {
            AppMethodBeat.o(42011);
            return 2;
        }
    }

    public final void restore() {
        AppMethodBeat.i(42012);
        this.iDT.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nSo.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nSp.setTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(42012);
    }

    public final void onError() {
        AppMethodBeat.i(42013);
        this.iDT.setTextColor(x.eq(getContext()));
        this.nSo.setTextColor(x.eq(getContext()));
        this.nSp.setTextColor(x.eq(getContext()));
        AppMethodBeat.o(42013);
    }

    public int getInputViewId() {
        AppMethodBeat.i(42014);
        int id = getId();
        AppMethodBeat.o(42014);
        return id;
    }

    public final String xH(int i) {
        AppMethodBeat.i(42015);
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        this.nSs = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
        String string;
        if (i == 1) {
            if (this.nSv == a.RANDOM_LUCK) {
                string = getContext().getString(R.string.ctn, new Object[]{Math.round(this.nSt), bo.bc(this.nSs.nRU, "")});
                AppMethodBeat.o(42015);
                return string;
            }
            string = getContext().getString(R.string.cpz, new Object[]{Math.round(this.nSt), bo.bc(this.nSs.nRU, "")});
            AppMethodBeat.o(42015);
            return string;
        } else if (i == 2) {
            string = getContext().getString(R.string.cq1, new Object[]{e.F(this.nSu), bo.bc(this.nSs.nRU, "")});
            AppMethodBeat.o(42015);
            return string;
        } else {
            AppMethodBeat.o(42015);
            return null;
        }
    }
}
