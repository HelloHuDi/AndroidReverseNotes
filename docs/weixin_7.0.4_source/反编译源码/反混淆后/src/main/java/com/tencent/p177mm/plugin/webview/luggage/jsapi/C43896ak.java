package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ak */
public class C43896ak extends C46419bd {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ak$1 */
    class C438941 implements Runnable {
        C438941() {
        }

        public final void run() {
            AppMethodBeat.m2504i(6349);
            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
            AppMethodBeat.m2505o(6349);
        }
    }

    public final String name() {
        return Scopes.PROFILE;
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6353);
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("username");
            if (optString == null || optString.length() == 0) {
                C4990ab.m7412e("MicroMsg.JsApiProfile", "doProfile fail, username is null");
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6353);
            } else if (C5046bo.isNullOrNil(optString)) {
                C18514l.m28819q(new C438941());
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6353);
            } else {
                C1720g.m3534RN();
                if (C1668a.m3395QX()) {
                    C7486a aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(optString);
                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                        aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoK(optString);
                    }
                    final Intent intent = new Intent();
                    String optString2 = jSONObject.optString("profileReportInfo");
                    if (!C5046bo.isNullOrNil(optString2)) {
                        intent.putExtra("key_add_contact_report_info", optString2);
                    }
                    if (aoO == null || ((int) aoO.ewQ) <= 0) {
                        context.getString(C25738R.string.f9238tz);
                        final C44275p b = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(6350);
                                C26417a.flu.mo20969or(optString);
                                c22841a.mo26722d("cancel", null);
                                AppMethodBeat.m2505o(6350);
                            }
                        });
                        final Context context2 = context;
                        final C22841a c22841a2 = c22841a;
                        C26417a.flu.mo20966a(optString, "", new C9636a() {

                            /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ak$3$1 */
                            class C144901 implements Runnable {
                                C144901() {
                                }

                                public final void run() {
                                    AppMethodBeat.m2504i(6351);
                                    Toast.makeText(C4996ah.getContext(), context2.getString(C25738R.string.bym, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                                    AppMethodBeat.m2505o(6351);
                                }
                            }

                            /* renamed from: o */
                            public final void mo6218o(String str, boolean z) {
                                AppMethodBeat.m2504i(6352);
                                if (context2 == null) {
                                    C4990ab.m7420w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
                                    c22841a2.mo26722d("fail", null);
                                    AppMethodBeat.m2505o(6352);
                                    return;
                                }
                                if (b != null) {
                                    b.dismiss();
                                }
                                C7486a aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                                if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                    aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoK(str);
                                }
                                if (aoO == null || ((int) aoO.ewQ) <= 0) {
                                    z = false;
                                } else {
                                    str = aoO.field_username;
                                }
                                if (z) {
                                    C41730b.m73489U(str, 3);
                                    C17884o.acv().mo67495pZ(str);
                                    intent.addFlags(268435456);
                                    intent.putExtra("Contact_User", str);
                                    if (aoO.dsf()) {
                                        C7060h.pYm.mo8374X(10298, aoO.field_username + ",42");
                                        intent.putExtra("Contact_Scene", 42);
                                    }
                                    C40211a.gkE.mo38912c(intent, context2);
                                    c22841a2.mo26722d(null, null);
                                    AppMethodBeat.m2505o(6352);
                                    return;
                                }
                                C18514l.m28819q(new C144901());
                                c22841a2.mo26722d("fail", null);
                                AppMethodBeat.m2505o(6352);
                            }
                        });
                        AppMethodBeat.m2505o(6353);
                        return;
                    }
                    intent.addFlags(268435456);
                    intent.putExtra("Contact_User", aoO.field_username);
                    if (aoO.dsf()) {
                        intent.putExtra("Contact_Scene", 42);
                    }
                    if (C7486a.m12942jh(aoO.field_type)) {
                        C42041qh c42041qh = new C42041qh();
                        c42041qh.cMw.intent = intent;
                        c42041qh.cMw.username = aoO.field_username;
                        C4879a.xxA.mo10055m(c42041qh);
                    }
                    C40211a.gkE.mo38912c(intent, context);
                    c22841a.mo26722d(null, null);
                    AppMethodBeat.m2505o(6353);
                    return;
                }
                C4990ab.m7412e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6353);
            }
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiProfile", "parase json fail");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6353);
        }
    }
}
