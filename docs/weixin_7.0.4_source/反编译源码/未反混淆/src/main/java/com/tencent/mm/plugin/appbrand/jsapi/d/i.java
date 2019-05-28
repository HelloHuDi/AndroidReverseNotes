package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.Rect;
import android.widget.EditText;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.j;
import com.tencent.mm.plugin.appbrand.widget.input.j.a;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends a<h> {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    public void a(u uVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(123562);
        final h hVar = new h();
        if (a(hVar, jSONObject, uVar, i)) {
            try {
                final int i2 = jSONObject.getInt("inputId");
                if (hVar.jjp != null && hVar.jjp.intValue() < 0) {
                    hVar.jjp = Integer.valueOf(0);
                }
                if (hVar.jjq != null && hVar.jjq.intValue() < 0) {
                    hVar.jjq = Integer.valueOf(0);
                }
                String optString = jSONObject.optString("data", null);
                if (optString != null) {
                    a.S(i2, optString);
                }
                final u uVar2 = uVar;
                final int i3 = i;
                m.runOnUiThread(new Runnable() {
                    public final void run() {
                        c cVar;
                        boolean z;
                        AppMethodBeat.i(123561);
                        j aQJ = a.jer;
                        u uVar = uVar2;
                        int i = i2;
                        h hVar = hVar;
                        aa a = e.a(uVar, new com.tencent.mm.plugin.appbrand.widget.input.j.AnonymousClass1(i));
                        if (a instanceof c) {
                            cVar = (c) a;
                        } else {
                            cVar = null;
                        }
                        if (cVar != null) {
                            if (hVar.jjo != null) {
                                cVar.EG(hVar.jjo);
                            }
                            cVar.a(hVar);
                            EditText aQl = cVar.aQl();
                            if (aQl != null) {
                                uVar = (u) cVar.jdm.get();
                                if (!(uVar == null || uVar.aJz() == null)) {
                                    g gVar = (g) uVar.aAY();
                                    if (gVar != null) {
                                        Rect aQm = cVar.aQm();
                                        gVar.c(uVar.aJz(), aQl, aQm.width(), aQm.height(), aQm.left, aQm.top);
                                    }
                                }
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            uVar2.M(i3, i.this.j("ok", null));
                            AppMethodBeat.o(123561);
                            return;
                        }
                        a = o.a(uVar2, i2);
                        if (a instanceof com.tencent.mm.plugin.appbrand.widget.input.i) {
                            com.tencent.mm.plugin.appbrand.widget.input.i iVar = (com.tencent.mm.plugin.appbrand.widget.input.i) a;
                            h hVar2 = hVar;
                            if (!(iVar.jdT == null || iVar.jdW == null)) {
                                iVar.jdT.a(hVar2);
                                if (iVar.jdT.jjm || (iVar.jdT.jjq != null && iVar.jdT.jjq.intValue() > 0)) {
                                    iVar.jdW.setWillNotDraw(true);
                                    iVar.aQy();
                                    if (iVar.jdT.jjo != null) {
                                        iVar.jdW.B(bo.nullAsNil(iVar.jdT.jjo));
                                    }
                                    if (aj.g(iVar.jdT.jjH)) {
                                        iVar.aQq();
                                        iVar.aQz();
                                    } else {
                                        iVar.b(iVar.jdW, iVar.jdT);
                                    }
                                    iVar.jdW.setWillNotDraw(false);
                                    iVar.jdW.invalidate();
                                }
                            }
                            uVar2.M(i3, i.this.j("ok", null));
                            AppMethodBeat.o(123561);
                            return;
                        }
                        d.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[]{Integer.valueOf(i2)}));
                        uVar2.M(i3, i.this.j(String.format(Locale.US, "fail found no input with %d", new Object[]{Integer.valueOf(i2)}), null));
                        AppMethodBeat.o(123561);
                    }
                });
                AppMethodBeat.o(123562);
                return;
            } catch (JSONException e) {
                uVar.M(i, j("fail:invalid data", null));
                AppMethodBeat.o(123562);
                return;
            }
        }
        AppMethodBeat.o(123562);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aDx() {
        return true;
    }
}
