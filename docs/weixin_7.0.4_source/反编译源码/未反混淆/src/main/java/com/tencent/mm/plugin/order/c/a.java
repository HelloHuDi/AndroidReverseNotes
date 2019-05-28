package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends ClickableSpan {
    private int eHE = -1;
    private int mColor = -1;
    private Context mContext = null;
    public a peT = null;

    public interface a {
        void onClick(View view);
    }

    public a(Context context) {
        AppMethodBeat.i(43927);
        this.mContext = context;
        this.mColor = this.mContext.getResources().getColor(R.color.um);
        this.eHE = -1;
        AppMethodBeat.o(43927);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(43928);
        if (this.peT != null) {
            this.peT.onClick(view);
        }
        AppMethodBeat.o(43928);
    }

    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(43929);
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(this.mColor);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.eHE;
        AppMethodBeat.o(43929);
    }
}
