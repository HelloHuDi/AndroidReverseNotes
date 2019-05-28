package com.tencent.mm.wallet_core.keyboard;

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
import com.tencent.mm.R;

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

    public WcPayKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49015);
        init();
        AppMethodBeat.o(49015);
    }

    public WcPayKeyboard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(49016);
        init();
        AppMethodBeat.o(49016);
    }

    private void init() {
        AppMethodBeat.i(49017);
        LayoutInflater.from(getContext()).inflate(R.layout.b6x, this, true);
        this.Afd = (TextView) findViewById(R.id.fje);
        this.AeU = (TextView) findViewById(R.id.fj4);
        this.AeV = (TextView) findViewById(R.id.fj5);
        this.AeW = (TextView) findViewById(R.id.fj6);
        this.AeX = (TextView) findViewById(R.id.fj8);
        this.AeY = (TextView) findViewById(R.id.fj9);
        this.AeZ = (TextView) findViewById(R.id.fj_);
        this.Afa = (TextView) findViewById(R.id.fjb);
        this.Afb = (TextView) findViewById(R.id.fjc);
        this.Afc = (TextView) findViewById(R.id.fjd);
        this.Afe = (TextView) findViewById(R.id.fjf);
        this.Afg = findViewById(R.id.fj7);
        this.Aff = (TextView) findViewById(R.id.fja);
        this.kGq = (TextView) findViewById(R.id.fj3);
        AnonymousClass1 anonymousClass1 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(49014);
                if (WcPayKeyboard.this.mInputEditText == null) {
                    AppMethodBeat.o(49014);
                    return;
                }
                int i = view.getId() == R.id.fje ? 7 : view.getId() == R.id.fj4 ? 8 : view.getId() == R.id.fj5 ? 9 : view.getId() == R.id.fj6 ? 10 : view.getId() == R.id.fj8 ? 11 : view.getId() == R.id.fj9 ? 12 : view.getId() == R.id.fj_ ? 13 : view.getId() == R.id.fjb ? 14 : view.getId() == R.id.fjc ? 15 : view.getId() == R.id.fjd ? 16 : view.getId() == R.id.fj7 ? 67 : view.getId() == R.id.fjf ? 56 : view.getId() == R.id.fja ? 66 : 0;
                WcPayKeyboard.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i));
                WcPayKeyboard.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i));
                AppMethodBeat.o(49014);
            }
        };
        this.Afd.setOnClickListener(anonymousClass1);
        this.AeU.setOnClickListener(anonymousClass1);
        this.AeV.setOnClickListener(anonymousClass1);
        this.AeW.setOnClickListener(anonymousClass1);
        this.AeX.setOnClickListener(anonymousClass1);
        this.AeY.setOnClickListener(anonymousClass1);
        this.AeZ.setOnClickListener(anonymousClass1);
        this.Afa.setOnClickListener(anonymousClass1);
        this.Afb.setOnClickListener(anonymousClass1);
        this.Afc.setOnClickListener(anonymousClass1);
        this.Afg.setOnClickListener(anonymousClass1);
        this.Afe.setOnClickListener(anonymousClass1);
        this.Aff.setOnClickListener(anonymousClass1);
        AppMethodBeat.o(49017);
    }

    public void setInputEditText(EditText editText) {
        if (editText != null) {
            this.mInputEditText = editText;
        }
    }

    public void setActionText(String str) {
        AppMethodBeat.i(49018);
        this.Aff.setText(str);
        AppMethodBeat.o(49018);
    }

    public void setTipText(String str) {
        AppMethodBeat.i(49019);
        this.kGq.setText(str);
        if (this.kGq.getVisibility() != 0) {
            this.kGq.setVisibility(0);
        }
        AppMethodBeat.o(49019);
    }
}
