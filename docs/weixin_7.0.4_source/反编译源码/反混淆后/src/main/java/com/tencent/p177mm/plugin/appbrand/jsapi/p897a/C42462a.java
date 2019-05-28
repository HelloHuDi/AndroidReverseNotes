package com.tencent.p177mm.plugin.appbrand.jsapi.p897a;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.a */
public final class C42462a extends ClickableSpan {
    private String hCv;
    private int hCw = C4996ah.getContext().getResources().getColor(C25738R.color.f12069r8);

    public C42462a(String str) {
        AppMethodBeat.m2504i(130896);
        this.hCv = str;
        AppMethodBeat.m2505o(130896);
    }

    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.m2504i(130897);
        super.updateDrawState(textPaint);
        textPaint.setColor(this.hCw);
        textPaint.setUnderlineText(false);
        AppMethodBeat.m2505o(130897);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(130898);
        if (C5046bo.isNullOrNil(this.hCv)) {
            C4990ab.m7412e("MicroMsg.ExposeSpan", "exposeUrl is null, return");
            AppMethodBeat.m2505o(130898);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.hCv);
        intent.putExtra("forceHideShare", true);
        C25985d.m41467b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        C4990ab.m7411d("MicroMsg.ExposeSpan", "expose click, exposeUrl:%s", this.hCv);
        AppMethodBeat.m2505o(130898);
    }
}
