package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class f extends a<q> {
    private static final int CTRL_INDEX = 463;
    private static final String NAME = "updateKeyboard";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130215);
        final q qVar = (q) cVar;
        final String optString = jSONObject.optString("value");
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130214);
                if (qVar.isRunning()) {
                    u currentPageView = qVar.getCurrentPageView();
                    if (currentPageView != null) {
                        com.tencent.mm.plugin.appbrand.game.widget.input.a ck = com.tencent.mm.plugin.appbrand.game.widget.input.a.ck(currentPageView.getContentView());
                        if (ck != null) {
                            WAGamePanelInputEditText attachedEditText = ck.getAttachedEditText();
                            int maxLength = attachedEditText.getMaxLength();
                            ab.v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", Integer.valueOf(maxLength));
                            if (bo.isNullOrNil(optString)) {
                                attachedEditText.setText("");
                            } else {
                                if (maxLength > 0) {
                                    attachedEditText.setText(optString.length() > maxLength ? optString.substring(0, maxLength) : optString);
                                } else {
                                    attachedEditText.setText(optString);
                                }
                                attachedEditText.setSelection(attachedEditText.getText().length());
                            }
                            qVar.M(i, f.this.j("ok", null));
                            AppMethodBeat.o(130214);
                            return;
                        }
                        qVar.M(i, f.this.j("fail", null));
                        AppMethodBeat.o(130214);
                        return;
                    }
                }
                AppMethodBeat.o(130214);
            }
        });
        AppMethodBeat.o(130215);
    }
}
