package com.tencent.p177mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18367ps;
import com.tencent.p177mm.p230g.p231a.C32617po;
import com.tencent.p177mm.p230g.p231a.C6535pp;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.e */
public final class C29828e {
    String uoF = null;
    private C29829a uoG;
    private C4884c uoH = new C298301();
    private C4884c uoI = new C145382();
    private C4884c uoJ = new C298273();

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.e$2 */
    class C145382 extends C4884c<C32617po> {
        C145382() {
            AppMethodBeat.m2504i(6934);
            this.xxI = C32617po.class.getName().hashCode();
            AppMethodBeat.m2505o(6934);
        }

        /* renamed from: a */
        private boolean m22737a(C32617po c32617po) {
            AppMethodBeat.m2504i(6935);
            if ((c32617po instanceof C32617po) && "bank".equals(C29828e.this.uoF)) {
                if (c32617po.cLL.action == 0) {
                    C29828e.m47291a(C29828e.this, C29828e.this.uoF);
                } else if (c32617po.cLL.action == 1) {
                    if (C5046bo.isNullOrNil(c32617po.cLL.cardNum)) {
                        C29828e.m47293b(C29828e.this, C29828e.this.uoF);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bankcard_number", c32617po.cLL.cardNum);
                            C29828e.m47292a(C29828e.this, C29828e.this.uoF, jSONObject, null);
                        } catch (JSONException e) {
                            C4990ab.m7413e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", e);
                            C29828e.m47293b(C29828e.this, C29828e.this.uoF);
                        }
                    }
                }
                C29828e.m47290a(C29828e.this);
            }
            AppMethodBeat.m2505o(6935);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.e$3 */
    class C298273 extends C4884c<C6535pp> {
        C298273() {
            AppMethodBeat.m2504i(6937);
            this.xxI = C6535pp.class.getName().hashCode();
            AppMethodBeat.m2505o(6937);
        }

        /* renamed from: a */
        private boolean m47288a(C6535pp c6535pp) {
            AppMethodBeat.m2504i(6938);
            if ((c6535pp instanceof C6535pp) && C29828e.this.uoF.equalsIgnoreCase(c6535pp.cLM.cardType)) {
                if (c6535pp.cLM.cLN == 0) {
                    C29828e.m47293b(C29828e.this, C29828e.this.uoF);
                } else if (c6535pp.cLM.cLN == 2) {
                    C29828e.m47291a(C29828e.this, C29828e.this.uoF);
                } else {
                    try {
                        if (C5046bo.isNullOrNil(c6535pp.cLM.cLO)) {
                            C29828e.m47292a(C29828e.this, C29828e.this.uoF, null, c6535pp.cLM.cLP);
                        } else {
                            C29828e.m47292a(C29828e.this, C29828e.this.uoF, new JSONObject(c6535pp.cLM.cLO), c6535pp.cLM.cLP);
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", e.getMessage());
                        C29828e.m47293b(C29828e.this, C29828e.this.uoF);
                    }
                }
                C29828e.m47290a(C29828e.this);
            }
            AppMethodBeat.m2505o(6938);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.e$a */
    public interface C29829a {
        /* renamed from: BD */
        void mo38693BD(String str);

        /* renamed from: a */
        void mo38694a(String str, JSONObject jSONObject, Bitmap bitmap);

        void aeT(String str);
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.e$1 */
    class C298301 extends C4884c<C18367ps> {
        C298301() {
            AppMethodBeat.m2504i(6932);
            this.xxI = C18367ps.class.getName().hashCode();
            AppMethodBeat.m2505o(6932);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6933);
            C18367ps c18367ps = (C18367ps) c4883b;
            if ((c18367ps instanceof C18367ps) && c18367ps.cLW.bJt == 1) {
                C29828e.m47291a(C29828e.this, C29828e.this.uoF);
                C29828e.m47290a(C29828e.this);
            }
            AppMethodBeat.m2505o(6933);
            return false;
        }
    }

    public C29828e() {
        AppMethodBeat.m2504i(6940);
        AppMethodBeat.m2505o(6940);
    }

    /* renamed from: a */
    public final boolean mo48055a(String str, Context context, C29829a c29829a) {
        AppMethodBeat.m2504i(6941);
        Intent intent;
        if ("bank".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 7);
            intent.putExtra("scan_bankcard_with_confirm_ui", true);
            intent.addFlags(268435456);
            C25985d.m41467b(context, "scanner", ".ui.BaseScanUI", intent);
            this.uoG = c29829a;
            this.uoF = "bank";
            C4879a.xxA.mo10052c(this.uoH);
            C4879a.xxA.mo10052c(this.uoI);
            AppMethodBeat.m2505o(6941);
            return true;
        } else if ("identity_pay_auth".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 11);
            C25985d.m41467b(context, "scanner", ".ui.BaseScanUI", intent);
            this.uoG = c29829a;
            this.uoF = "identity";
            C4879a.xxA.mo10052c(this.uoH);
            C4879a.xxA.mo10052c(this.uoJ);
            AppMethodBeat.m2505o(6941);
            return true;
        } else {
            AppMethodBeat.m2505o(6941);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m47291a(C29828e c29828e, String str) {
        AppMethodBeat.m2504i(6942);
        if (c29828e.uoG != null) {
            c29828e.uoG.aeT(str);
        }
        AppMethodBeat.m2505o(6942);
    }

    /* renamed from: a */
    static /* synthetic */ void m47290a(C29828e c29828e) {
        AppMethodBeat.m2504i(6943);
        c29828e.uoG = null;
        C4879a.xxA.mo10053d(c29828e.uoH);
        C4879a.xxA.mo10053d(c29828e.uoI);
        C4879a.xxA.mo10053d(c29828e.uoJ);
        AppMethodBeat.m2505o(6943);
    }

    /* renamed from: b */
    static /* synthetic */ void m47293b(C29828e c29828e, String str) {
        AppMethodBeat.m2504i(6944);
        if (c29828e.uoG != null) {
            c29828e.uoG.mo38693BD(str);
        }
        AppMethodBeat.m2505o(6944);
    }

    /* renamed from: a */
    static /* synthetic */ void m47292a(C29828e c29828e, String str, JSONObject jSONObject, Bitmap bitmap) {
        AppMethodBeat.m2504i(6945);
        if (c29828e.uoG != null) {
            c29828e.uoG.mo38694a(str, jSONObject, bitmap);
        }
        AppMethodBeat.m2505o(6945);
    }
}
