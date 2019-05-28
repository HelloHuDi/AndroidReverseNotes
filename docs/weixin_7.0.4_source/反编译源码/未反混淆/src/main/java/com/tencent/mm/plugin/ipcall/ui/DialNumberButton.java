package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bo;

public class DialNumberButton extends RelativeLayout {
    private TextView nzH;
    private TextView nzI;
    private boolean nzJ = false;

    public DialNumberButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(21953);
        LayoutInflater.from(getContext()).inflate(R.layout.sf, this);
        this.nzH = (TextView) findViewById(R.id.b_0);
        this.nzI = (TextView) findViewById(R.id.b_1);
        if (d.iW(16)) {
            this.nzH.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nzI.setTypeface(Typeface.create("sans-serif-normal", 0));
        }
        setClipChildren(false);
        setClipToPadding(false);
        AppMethodBeat.o(21953);
    }

    public final void setNumberTextSize$255e752(float f) {
        AppMethodBeat.i(21954);
        this.nzH.setTextSize(0, f);
        AppMethodBeat.o(21954);
    }

    public String getNumberText() {
        AppMethodBeat.i(21955);
        String charSequence = this.nzH.getText().toString();
        AppMethodBeat.o(21955);
        return charSequence;
    }

    public String getOtherText() {
        AppMethodBeat.i(21956);
        String charSequence = this.nzI.getText().toString();
        AppMethodBeat.o(21956);
        return charSequence;
    }

    public final void eK(String str, String str2) {
        AppMethodBeat.i(21957);
        if (!bo.isNullOrNil(str) && str.length() == 1) {
            this.nzH.setText(str);
        }
        if (!bo.isNullOrNil(str2) || "1".equals(str)) {
            this.nzI.setText(str2);
            this.nzI.setVisibility(0);
            AppMethodBeat.o(21957);
            return;
        }
        this.nzI.setVisibility(8);
        AppMethodBeat.o(21957);
    }

    public void setInTalkUIMode(boolean z) {
        AppMethodBeat.i(21958);
        this.nzJ = z;
        if (this.nzJ) {
            if ("#".equals(this.nzH.getText()) || "*".equals(this.nzH.getText())) {
                this.nzH.setTextColor(getContext().getResources().getColor(R.color.m1));
            } else {
                this.nzH.setTextColor(getContext().getResources().getColor(R.color.m3));
            }
            this.nzI.setTextColor(getContext().getResources().getColor(R.color.m1));
            setBackgroundDrawable(getResources().getDrawable(R.drawable.la));
            AppMethodBeat.o(21958);
            return;
        }
        if ("#".equals(this.nzH.getText()) || "*".equals(this.nzH.getText())) {
            this.nzH.setTextColor(getContext().getResources().getColor(R.color.m1));
        } else {
            this.nzH.setTextColor(getContext().getResources().getColor(R.color.m2));
        }
        this.nzI.setTextColor(getContext().getResources().getColor(R.color.m1));
        setBackgroundDrawable(getResources().getDrawable(R.drawable.lb));
        AppMethodBeat.o(21958);
    }
}
