package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class j extends ClickableSpan {
    private int eHE = -1;
    public int mColor = -1;
    private Context mContext = null;
    public a tHw = null;

    public interface a {
        void onClick(View view);
    }

    public j(Context context) {
        AppMethodBeat.i(47362);
        this.mContext = context;
        this.mColor = this.mContext.getResources().getColor(R.color.a4m);
        this.eHE = this.mContext.getResources().getColor(R.color.a3p);
        AppMethodBeat.o(47362);
    }

    public void onClick(View view) {
        AppMethodBeat.i(47363);
        if (this.tHw != null) {
            this.tHw.onClick(view);
        }
        AppMethodBeat.o(47363);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(47364);
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(this.mColor);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.eHE;
        AppMethodBeat.o(47364);
    }
}
