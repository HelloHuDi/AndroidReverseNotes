package com.tencent.p177mm.plugin.appbrand.game.p295e.p296a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.game.widget.input.C42449a;
import com.tencent.p177mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.f */
public final class C2162f extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 463;
    private static final String NAME = "updateKeyboard";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130215);
        final C38492q c38492q = (C38492q) c2241c;
        final String optString = jSONObject.optString("value");
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(130214);
                if (c38492q.isRunning()) {
                    C44709u currentPageView = c38492q.getCurrentPageView();
                    if (currentPageView != null) {
                        C42449a ck = C42449a.m75189ck(currentPageView.getContentView());
                        if (ck != null) {
                            WAGamePanelInputEditText attachedEditText = ck.getAttachedEditText();
                            int maxLength = attachedEditText.getMaxLength();
                            C4990ab.m7419v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", Integer.valueOf(maxLength));
                            if (C5046bo.isNullOrNil(optString)) {
                                attachedEditText.setText("");
                            } else {
                                if (maxLength > 0) {
                                    attachedEditText.setText(optString.length() > maxLength ? optString.substring(0, maxLength) : optString);
                                } else {
                                    attachedEditText.setText(optString);
                                }
                                attachedEditText.setSelection(attachedEditText.getText().length());
                            }
                            c38492q.mo6107M(i, C2162f.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(130214);
                            return;
                        }
                        c38492q.mo6107M(i, C2162f.this.mo73394j("fail", null));
                        AppMethodBeat.m2505o(130214);
                        return;
                    }
                }
                AppMethodBeat.m2505o(130214);
            }
        });
        AppMethodBeat.m2505o(130215);
    }
}
