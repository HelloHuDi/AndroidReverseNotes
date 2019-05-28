package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.g;
import com.tencent.mm.ui.widget.MMEditText;

public class WxaLuckyMoneyTextInputView extends LinearLayout implements c {
    private TextView iDT;
    private g nSr;
    private MMEditText nTP;

    public WxaLuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42136);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b8_, this, true);
        this.nTP = (MMEditText) inflate.findViewById(R.id.d0f);
        this.iDT = (TextView) inflate.findViewById(R.id.d0e);
        this.nTP.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(42135);
                if (WxaLuckyMoneyTextInputView.this.nSr != null) {
                    g a = WxaLuckyMoneyTextInputView.this.nSr;
                    WxaLuckyMoneyTextInputView.this.getInputViewId();
                    a.bLa();
                }
                AppMethodBeat.o(42135);
            }
        });
        com.tencent.mm.ui.tools.b.c hz = com.tencent.mm.ui.tools.b.c.d(this.nTP).hz(0, 24);
        hz.a(null);
        AppMethodBeat.o(42136);
    }

    public void setOnInputValidChangerListener(g gVar) {
        this.nSr = gVar;
    }

    public String getInput() {
        AppMethodBeat.i(42137);
        String obj = this.nTP.getText().toString();
        AppMethodBeat.o(42137);
        return obj;
    }

    public void setHintText(String str) {
        AppMethodBeat.i(42138);
        this.nTP.setHint(str);
        AppMethodBeat.o(42138);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(42139);
        this.iDT.setText(str);
        AppMethodBeat.o(42139);
    }

    public final int bKW() {
        return 0;
    }

    public final void restore() {
    }

    public final void onError() {
    }

    public int getInputViewId() {
        AppMethodBeat.i(42140);
        int id = getId();
        AppMethodBeat.o(42140);
        return id;
    }

    public final String xH(int i) {
        return null;
    }
}
