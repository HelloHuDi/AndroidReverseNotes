package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C12472g;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C39342c;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView */
public class WxaLuckyMoneyTextInputView extends LinearLayout implements C39342c {
    private TextView iDT;
    private C12472g nSr;
    private MMEditText nTP;

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView$1 */
    class C211941 implements OnFocusChangeListener {
        C211941() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(42135);
            if (WxaLuckyMoneyTextInputView.this.nSr != null) {
                C12472g a = WxaLuckyMoneyTextInputView.this.nSr;
                WxaLuckyMoneyTextInputView.this.getInputViewId();
                a.bLa();
            }
            AppMethodBeat.m2505o(42135);
        }
    }

    public WxaLuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(42136);
        View inflate = LayoutInflater.from(context).inflate(2130971247, this, true);
        this.nTP = (MMEditText) inflate.findViewById(2131825665);
        this.iDT = (TextView) inflate.findViewById(2131825664);
        this.nTP.setOnFocusChangeListener(new C211941());
        C7357c hz = C7357c.m12555d(this.nTP).mo15880hz(0, 24);
        hz.mo15879a(null);
        AppMethodBeat.m2505o(42136);
    }

    public void setOnInputValidChangerListener(C12472g c12472g) {
        this.nSr = c12472g;
    }

    public String getInput() {
        AppMethodBeat.m2504i(42137);
        String obj = this.nTP.getText().toString();
        AppMethodBeat.m2505o(42137);
        return obj;
    }

    public void setHintText(String str) {
        AppMethodBeat.m2504i(42138);
        this.nTP.setHint(str);
        AppMethodBeat.m2505o(42138);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(42139);
        this.iDT.setText(str);
        AppMethodBeat.m2505o(42139);
    }

    public final int bKW() {
        return 0;
    }

    public final void restore() {
    }

    public final void onError() {
    }

    public int getInputViewId() {
        AppMethodBeat.m2504i(42140);
        int id = getId();
        AppMethodBeat.m2505o(42140);
        return id;
    }

    /* renamed from: xH */
    public final String mo36557xH(int i) {
        return null;
    }
}
