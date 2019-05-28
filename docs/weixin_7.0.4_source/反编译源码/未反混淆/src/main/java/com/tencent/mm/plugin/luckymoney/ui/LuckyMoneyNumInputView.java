package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView extends LinearLayout implements c {
    private TextWatcher arx = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(42881);
            if (LuckyMoneyNumInputView.this.nSr != null) {
                g a = LuckyMoneyNumInputView.this.nSr;
                LuckyMoneyNumInputView.this.getInputViewId();
                a.bLa();
            }
            AppMethodBeat.o(42881);
        }
    };
    private TextView iDT;
    private int mNum = 1;
    private g nSr;
    private i nSs;
    private TenpaySecureEditText ogB;
    private TextView ogC;
    private int ogD = BaseClientBuilder.API_PRIORITY_OTHER;
    private int ogE = 1;

    public void setHint(String str) {
        AppMethodBeat.i(42882);
        this.ogB.setHint(str);
        AppMethodBeat.o(42882);
    }

    public LuckyMoneyNumInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42883);
        View inflate = LayoutInflater.from(context).inflate(R.layout.aaf, this, true);
        this.iDT = (TextView) inflate.findViewById(R.id.cyl);
        this.ogB = (TenpaySecureEditText) inflate.findViewById(R.id.cwy);
        this.ogC = (TextView) inflate.findViewById(R.id.cym);
        this.ogB.setText(this.mNum);
        this.ogB.addTextChangedListener(this.arx);
        AppMethodBeat.o(42883);
    }

    public void setMaxNum(int i) {
        int i2 = 3;
        AppMethodBeat.i(42884);
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
        AppMethodBeat.o(42884);
    }

    public void setMinNum(int i) {
        this.ogE = i;
    }

    public int getInput() {
        AppMethodBeat.i(42885);
        try {
            int parseInt = Integer.parseInt(this.ogB.getText().toString(), 10);
            AppMethodBeat.o(42885);
            return parseInt;
        } catch (Exception e) {
            AppMethodBeat.o(42885);
            return 0;
        }
    }

    public void setNum(String str) {
        AppMethodBeat.i(42886);
        this.ogB.setText(str);
        this.ogB.setSelection(this.ogB.getText().length());
        this.mNum = bo.getInt(str, 0);
        AppMethodBeat.o(42886);
    }

    public void setOnInputValidChangerListener(g gVar) {
        this.nSr = gVar;
    }

    public final int bKW() {
        AppMethodBeat.i(42887);
        if (bo.isNullOrNil(this.ogB.getText().toString())) {
            AppMethodBeat.o(42887);
            return 0;
        }
        int i = bo.getInt(this.ogB.getText().toString(), -1);
        if (i < 0) {
            AppMethodBeat.o(42887);
            return 3;
        } else if (i > this.ogD && this.ogD > 0) {
            AppMethodBeat.o(42887);
            return 1;
        } else if (i >= this.ogE || this.ogE <= 0) {
            AppMethodBeat.o(42887);
            return 0;
        } else {
            AppMethodBeat.o(42887);
            return 2;
        }
    }

    public final void restore() {
        AppMethodBeat.i(42888);
        this.iDT.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ogB.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ogC.setTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(42888);
    }

    public final void onError() {
        AppMethodBeat.i(42889);
        this.iDT.setTextColor(x.eq(getContext()));
        this.ogB.setTextColor(x.eq(getContext()));
        this.ogC.setTextColor(x.eq(getContext()));
        AppMethodBeat.o(42889);
    }

    public int getInputViewId() {
        AppMethodBeat.i(42890);
        int id = getId();
        AppMethodBeat.o(42890);
        return id;
    }

    private boolean bMA() {
        AppMethodBeat.i(42891);
        if (this.nSs == null || bo.isNullOrNil(this.nSs.nWL)) {
            AppMethodBeat.o(42891);
            return false;
        }
        AppMethodBeat.o(42891);
        return true;
    }

    public final String xH(int i) {
        AppMethodBeat.i(42892);
        a.bKN();
        this.nSs = a.bKO().bLu();
        String string;
        if (i == 1) {
            if (bMA()) {
                string = getContext().getString(R.string.cs5, new Object[]{Integer.valueOf(this.ogD), this.nSs.nWL});
                AppMethodBeat.o(42892);
                return string;
            }
            string = getContext().getString(R.string.cs4, new Object[]{Integer.valueOf(this.ogD)});
            AppMethodBeat.o(42892);
            return string;
        } else if (i != 2) {
            AppMethodBeat.o(42892);
            return null;
        } else if (bMA()) {
            string = getContext().getString(R.string.cs3, new Object[]{Integer.valueOf(this.ogE), this.nSs.nWL});
            AppMethodBeat.o(42892);
            return string;
        } else {
            string = getContext().getString(R.string.cs2, new Object[]{Integer.valueOf(this.ogE)});
            AppMethodBeat.o(42892);
            return string;
        }
    }
}
