package com.tencent.p177mm.plugin.order.p1008c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.order.c.a */
public final class C12784a extends ClickableSpan {
    private int eHE = -1;
    private int mColor = -1;
    private Context mContext = null;
    public C12783a peT = null;

    /* renamed from: com.tencent.mm.plugin.order.c.a$a */
    public interface C12783a {
        void onClick(View view);
    }

    public C12784a(Context context) {
        AppMethodBeat.m2504i(43927);
        this.mContext = context;
        this.mColor = this.mContext.getResources().getColor(C25738R.color.f12166um);
        this.eHE = -1;
        AppMethodBeat.m2505o(43927);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(43928);
        if (this.peT != null) {
            this.peT.onClick(view);
        }
        AppMethodBeat.m2505o(43928);
    }

    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.m2504i(43929);
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(this.mColor);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.eHE;
        AppMethodBeat.m2505o(43929);
    }
}
