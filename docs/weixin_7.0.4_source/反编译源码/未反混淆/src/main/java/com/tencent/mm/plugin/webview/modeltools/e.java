package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    String uoF = null;
    private a uoG;
    private c uoH = new c<ps>() {
        {
            AppMethodBeat.i(6932);
            this.xxI = ps.class.getName().hashCode();
            AppMethodBeat.o(6932);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6933);
            ps psVar = (ps) bVar;
            if ((psVar instanceof ps) && psVar.cLW.bJt == 1) {
                e.a(e.this, e.this.uoF);
                e.a(e.this);
            }
            AppMethodBeat.o(6933);
            return false;
        }
    };
    private c uoI = new c<po>() {
        {
            AppMethodBeat.i(6934);
            this.xxI = po.class.getName().hashCode();
            AppMethodBeat.o(6934);
        }

        private boolean a(po poVar) {
            AppMethodBeat.i(6935);
            if ((poVar instanceof po) && "bank".equals(e.this.uoF)) {
                if (poVar.cLL.action == 0) {
                    e.a(e.this, e.this.uoF);
                } else if (poVar.cLL.action == 1) {
                    if (bo.isNullOrNil(poVar.cLL.cardNum)) {
                        e.b(e.this, e.this.uoF);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bankcard_number", poVar.cLL.cardNum);
                            e.a(e.this, e.this.uoF, jSONObject, null);
                        } catch (JSONException e) {
                            ab.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", e);
                            e.b(e.this, e.this.uoF);
                        }
                    }
                }
                e.a(e.this);
            }
            AppMethodBeat.o(6935);
            return false;
        }
    };
    private c uoJ = new c<pp>() {
        {
            AppMethodBeat.i(6937);
            this.xxI = pp.class.getName().hashCode();
            AppMethodBeat.o(6937);
        }

        private boolean a(pp ppVar) {
            AppMethodBeat.i(6938);
            if ((ppVar instanceof pp) && e.this.uoF.equalsIgnoreCase(ppVar.cLM.cardType)) {
                if (ppVar.cLM.cLN == 0) {
                    e.b(e.this, e.this.uoF);
                } else if (ppVar.cLM.cLN == 2) {
                    e.a(e.this, e.this.uoF);
                } else {
                    try {
                        if (bo.isNullOrNil(ppVar.cLM.cLO)) {
                            e.a(e.this, e.this.uoF, null, ppVar.cLM.cLP);
                        } else {
                            e.a(e.this, e.this.uoF, new JSONObject(ppVar.cLM.cLO), ppVar.cLM.cLP);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", e.getMessage());
                        e.b(e.this, e.this.uoF);
                    }
                }
                e.a(e.this);
            }
            AppMethodBeat.o(6938);
            return false;
        }
    };

    public interface a {
        void BD(String str);

        void a(String str, JSONObject jSONObject, Bitmap bitmap);

        void aeT(String str);
    }

    public e() {
        AppMethodBeat.i(6940);
        AppMethodBeat.o(6940);
    }

    public final boolean a(String str, Context context, a aVar) {
        AppMethodBeat.i(6941);
        Intent intent;
        if ("bank".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 7);
            intent.putExtra("scan_bankcard_with_confirm_ui", true);
            intent.addFlags(268435456);
            d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.uoG = aVar;
            this.uoF = "bank";
            com.tencent.mm.sdk.b.a.xxA.c(this.uoH);
            com.tencent.mm.sdk.b.a.xxA.c(this.uoI);
            AppMethodBeat.o(6941);
            return true;
        } else if ("identity_pay_auth".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 11);
            d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.uoG = aVar;
            this.uoF = "identity";
            com.tencent.mm.sdk.b.a.xxA.c(this.uoH);
            com.tencent.mm.sdk.b.a.xxA.c(this.uoJ);
            AppMethodBeat.o(6941);
            return true;
        } else {
            AppMethodBeat.o(6941);
            return false;
        }
    }

    static /* synthetic */ void a(e eVar, String str) {
        AppMethodBeat.i(6942);
        if (eVar.uoG != null) {
            eVar.uoG.aeT(str);
        }
        AppMethodBeat.o(6942);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(6943);
        eVar.uoG = null;
        com.tencent.mm.sdk.b.a.xxA.d(eVar.uoH);
        com.tencent.mm.sdk.b.a.xxA.d(eVar.uoI);
        com.tencent.mm.sdk.b.a.xxA.d(eVar.uoJ);
        AppMethodBeat.o(6943);
    }

    static /* synthetic */ void b(e eVar, String str) {
        AppMethodBeat.i(6944);
        if (eVar.uoG != null) {
            eVar.uoG.BD(str);
        }
        AppMethodBeat.o(6944);
    }

    static /* synthetic */ void a(e eVar, String str, JSONObject jSONObject, Bitmap bitmap) {
        AppMethodBeat.i(6945);
        if (eVar.uoG != null) {
            eVar.uoG.a(str, jSONObject, bitmap);
        }
        AppMethodBeat.o(6945);
    }
}
