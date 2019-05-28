package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.j */
public class C46373j extends ClickableSpan {
    private int eHE = -1;
    public int mColor = -1;
    private Context mContext = null;
    public C29672a tHw = null;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.j$a */
    public interface C29672a {
        void onClick(View view);
    }

    public C46373j(Context context) {
        AppMethodBeat.m2504i(47362);
        this.mContext = context;
        this.mColor = this.mContext.getResources().getColor(C25738R.color.a4m);
        this.eHE = this.mContext.getResources().getColor(C25738R.color.a3p);
        AppMethodBeat.m2505o(47362);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(47363);
        if (this.tHw != null) {
            this.tHw.onClick(view);
        }
        AppMethodBeat.m2505o(47363);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.m2504i(47364);
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(this.mColor);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.eHE;
        AppMethodBeat.m2505o(47364);
    }
}
