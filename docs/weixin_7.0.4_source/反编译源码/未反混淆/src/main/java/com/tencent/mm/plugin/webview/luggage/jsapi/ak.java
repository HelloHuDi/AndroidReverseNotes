package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import org.json.JSONException;
import org.json.JSONObject;

public class ak extends bd {
    public final String name() {
        return Scopes.PROFILE;
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        AppMethodBeat.i(6353);
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("username");
            if (optString == null || optString.length() == 0) {
                ab.e("MicroMsg.JsApiProfile", "doProfile fail, username is null");
                aVar.d("fail", null);
                AppMethodBeat.o(6353);
            } else if (bo.isNullOrNil(optString)) {
                l.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(6349);
                        Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                        AppMethodBeat.o(6349);
                    }
                });
                aVar.d("fail", null);
                AppMethodBeat.o(6353);
            } else {
                g.RN();
                if (com.tencent.mm.kernel.a.QX()) {
                    com.tencent.mm.n.a aoO = ((j) g.K(j.class)).XM().aoO(optString);
                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                        aoO = ((j) g.K(j.class)).XM().aoK(optString);
                    }
                    final Intent intent = new Intent();
                    String optString2 = jSONObject.optString("profileReportInfo");
                    if (!bo.isNullOrNil(optString2)) {
                        intent.putExtra("key_add_contact_report_info", optString2);
                    }
                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                        context.getString(R.string.tz);
                        final p b = h.b(context, context.getString(R.string.un), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(6350);
                                ao.a.flu.or(optString);
                                aVar.d("cancel", null);
                                AppMethodBeat.o(6350);
                            }
                        });
                        final Context context2 = context;
                        final bc.a aVar2 = aVar;
                        ao.a.flu.a(optString, "", new b.a() {
                            public final void o(String str, boolean z) {
                                AppMethodBeat.i(6352);
                                if (context2 == null) {
                                    ab.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
                                    aVar2.d("fail", null);
                                    AppMethodBeat.o(6352);
                                    return;
                                }
                                if (b != null) {
                                    b.dismiss();
                                }
                                com.tencent.mm.n.a aoO = ((j) g.K(j.class)).XM().aoO(str);
                                if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                    aoO = ((j) g.K(j.class)).XM().aoK(str);
                                }
                                if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                    z = false;
                                } else {
                                    str = aoO.field_username;
                                }
                                if (z) {
                                    com.tencent.mm.ah.b.U(str, 3);
                                    o.acv().pZ(str);
                                    intent.addFlags(268435456);
                                    intent.putExtra("Contact_User", str);
                                    if (aoO.dsf()) {
                                        com.tencent.mm.plugin.report.service.h.pYm.X(10298, aoO.field_username + ",42");
                                        intent.putExtra("Contact_Scene", 42);
                                    }
                                    com.tencent.mm.plugin.webview.a.a.gkE.c(intent, context2);
                                    aVar2.d(null, null);
                                    AppMethodBeat.o(6352);
                                    return;
                                }
                                l.q(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(6351);
                                        Toast.makeText(ah.getContext(), context2.getString(R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                                        AppMethodBeat.o(6351);
                                    }
                                });
                                aVar2.d("fail", null);
                                AppMethodBeat.o(6352);
                            }
                        });
                        AppMethodBeat.o(6353);
                        return;
                    }
                    intent.addFlags(268435456);
                    intent.putExtra("Contact_User", aoO.field_username);
                    if (aoO.dsf()) {
                        intent.putExtra("Contact_Scene", 42);
                    }
                    if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                        qh qhVar = new qh();
                        qhVar.cMw.intent = intent;
                        qhVar.cMw.username = aoO.field_username;
                        com.tencent.mm.sdk.b.a.xxA.m(qhVar);
                    }
                    com.tencent.mm.plugin.webview.a.a.gkE.c(intent, context);
                    aVar.d(null, null);
                    AppMethodBeat.o(6353);
                    return;
                }
                ab.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
                aVar.d("fail", null);
                AppMethodBeat.o(6353);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiProfile", "parase json fail");
            aVar.d("fail", null);
            AppMethodBeat.o(6353);
        }
    }
}
