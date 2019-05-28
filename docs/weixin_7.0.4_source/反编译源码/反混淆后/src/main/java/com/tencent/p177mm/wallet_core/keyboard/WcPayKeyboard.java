package com.tencent.p177mm.wallet_core.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.wallet_core.keyboard.WcPayKeyboard */
public class WcPayKeyboard extends LinearLayout {
    private TextView AeU;
    private TextView AeV;
    private TextView AeW;
    private TextView AeX;
    private TextView AeY;
    private TextView AeZ;
    private TextView Afa;
    private TextView Afb;
    private TextView Afc;
    private TextView Afd;
    private TextView Afe;
    public TextView Aff;
    private View Afg;
    private TextView kGq;
    private EditText mInputEditText;

    /* renamed from: com.tencent.mm.wallet_core.keyboard.WcPayKeyboard$1 */
    class C308731 implements OnClickListener {
        C308731() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49014);
            if (WcPayKeyboard.this.mInputEditText == null) {
                AppMethodBeat.m2505o(49014);
                return;
            }
            int i = view.getId() == 2131829142 ? 7 : view.getId() == 2131829131 ? 8 : view.getId() == 2131829132 ? 9 : view.getId() == 2131829133 ? 10 : view.getId() == 2131829135 ? 11 : view.getId() == 2131829136 ? 12 : view.getId() == 2131829137 ? 13 : view.getId() == 2131829139 ? 14 : view.getId() == 2131829140 ? 15 : view.getId() == 2131829141 ? 16 : view.getId() == 2131829134 ? 67 : view.getId() == 2131829143 ? 56 : view.getId() == 2131829138 ? 66 : 0;
            WcPayKeyboard.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i));
            WcPayKeyboard.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i));
            AppMethodBeat.m2505o(49014);
        }
    }

    public WcPayKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(49015);
        init();
        AppMethodBeat.m2505o(49015);
    }

    public WcPayKeyboard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(49016);
        init();
        AppMethodBeat.m2505o(49016);
    }

    private void init() {
        AppMethodBeat.m2504i(49017);
        LayoutInflater.from(getContext()).inflate(2130971197, this, true);
        this.Afd = (TextView) findViewById(2131829142);
        this.AeU = (TextView) findViewById(2131829131);
        this.AeV = (TextView) findViewById(2131829132);
        this.AeW = (TextView) findViewById(2131829133);
        this.AeX = (TextView) findViewById(2131829135);
        this.AeY = (TextView) findViewById(2131829136);
        this.AeZ = (TextView) findViewById(2131829137);
        this.Afa = (TextView) findViewById(2131829139);
        this.Afb = (TextView) findViewById(2131829140);
        this.Afc = (TextView) findViewById(2131829141);
        this.Afe = (TextView) findViewById(2131829143);
        this.Afg = findViewById(2131829134);
        this.Aff = (TextView) findViewById(2131829138);
        this.kGq = (TextView) findViewById(2131829130);
        C308731 c308731 = new C308731();
        this.Afd.setOnClickListener(c308731);
        this.AeU.setOnClickListener(c308731);
        this.AeV.setOnClickListener(c308731);
        this.AeW.setOnClickListener(c308731);
        this.AeX.setOnClickListener(c308731);
        this.AeY.setOnClickListener(c308731);
        this.AeZ.setOnClickListener(c308731);
        this.Afa.setOnClickListener(c308731);
        this.Afb.setOnClickListener(c308731);
        this.Afc.setOnClickListener(c308731);
        this.Afg.setOnClickListener(c308731);
        this.Afe.setOnClickListener(c308731);
        this.Aff.setOnClickListener(c308731);
        AppMethodBeat.m2505o(49017);
    }

    public void setInputEditText(EditText editText) {
        if (editText != null) {
            this.mInputEditText = editText;
        }
    }

    public void setActionText(String str) {
        AppMethodBeat.m2504i(49018);
        this.Aff.setText(str);
        AppMethodBeat.m2505o(49018);
    }

    public void setTipText(String str) {
        AppMethodBeat.m2504i(49019);
        this.kGq.setText(str);
        if (this.kGq.getVisibility() != 0) {
            this.kGq.setVisibility(0);
        }
        AppMethodBeat.m2505o(49019);
    }
}
