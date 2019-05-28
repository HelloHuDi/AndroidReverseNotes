package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends ClickableSpan {
    private String hCv;
    private int hCw = ah.getContext().getResources().getColor(R.color.r8);

    public a(String str) {
        AppMethodBeat.i(130896);
        this.hCv = str;
        AppMethodBeat.o(130896);
    }

    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(130897);
        super.updateDrawState(textPaint);
        textPaint.setColor(this.hCw);
        textPaint.setUnderlineText(false);
        AppMethodBeat.o(130897);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(130898);
        if (bo.isNullOrNil(this.hCv)) {
            ab.e("MicroMsg.ExposeSpan", "exposeUrl is null, return");
            AppMethodBeat.o(130898);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.hCv);
        intent.putExtra("forceHideShare", true);
        d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        ab.d("MicroMsg.ExposeSpan", "expose click, exposeUrl:%s", this.hCv);
        AppMethodBeat.o(130898);
    }
}
