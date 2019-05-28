package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.p057v4.app.C6184a.C0315a;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.luggage.p147g.C8870e;
import com.tencent.luggage.p147g.C8870e.C8872a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.c */
public final class C33279c extends C10296a {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(126271);
        final Context context = c2241c.getContext();
        if (context == null || !(context instanceof Activity)) {
            C4990ab.m7413e("MicroMsg.JsApiChooseContact", "getPageContext failed, appid is %s", c2241c.getAppId());
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(126271);
            return;
        }
        boolean z;
        C19663n.m30463b(c2241c.getAppId(), new C0315a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.m2504i(126270);
                if (i != 48) {
                    AppMethodBeat.m2505o(126270);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    c2241c.mo6107M(i, C33279c.this.mo73394j("permission_denied", null));
                    AppMethodBeat.m2505o(126270);
                } else {
                    C33279c.this.mo5994a(c2241c, jSONObject, i);
                    AppMethodBeat.m2505o(126270);
                }
            }
        });
        Context context2 = c2241c.getContext();
        if (context2 == null || !(context2 instanceof Activity)) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            z = false;
        } else {
            z = C0991g.m2252a((Activity) context2, "android.permission.READ_CONTACTS", 48, "", "");
            if (z) {
                C19663n.m30460Dr(c2241c.getAppId());
            }
        }
        if (z) {
            C8870e.m15839ax(context).mo20068a(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), new C8872a() {
                /* JADX WARNING: Removed duplicated region for block: B:58:0x0204  */
                /* JADX WARNING: Removed duplicated region for block: B:54:0x01d9  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                /* renamed from: b */
                public final void mo15055b(int i, Intent intent) {
                    AppMethodBeat.m2504i(126269);
                    if (i == 0 || i == 1) {
                        c2241c.mo6107M(i, C33279c.this.mo73394j("cancel", null));
                        AppMethodBeat.m2505o(126269);
                        return;
                    }
                    if (i == -1) {
                        Uri data = intent.getData();
                        if (data == null) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseContact", "onActivityResult, uri == null");
                            c2241c.mo6107M(i, C33279c.this.mo73394j("fail", null));
                            AppMethodBeat.m2505o(126269);
                            return;
                        } else if (C0991g.m2253o(context, "android.permission.READ_CONTACTS")) {
                            try {
                                String str;
                                Object obj;
                                Cursor query = context.getContentResolver().query(data, null, null, null, null);
                                if (query != null && query.getCount() > 0) {
                                    query.moveToFirst();
                                    int columnIndex = query.getColumnIndex("has_phone_number");
                                    if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                        String string = query.getString(query.getColumnIndex("_id"));
                                        Cursor query2 = context.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = ".concat(String.valueOf(string)), null, null);
                                        C4990ab.m7417i("MicroMsg.JsApiChooseContact", "onActivityResult, queried cursor = %s", query);
                                        if (query2 == null) {
                                            c2241c.mo6107M(i, C33279c.this.mo73394j("fail", null));
                                            AppMethodBeat.m2505o(126269);
                                            return;
                                        }
                                        if (query2.moveToFirst()) {
                                            string = null;
                                            str = null;
                                            while (!query2.isAfterLast()) {
                                                columnIndex = query2.getColumnIndex("data1");
                                                int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                                String string2 = query2.getString(columnIndex);
                                                string = query2.getString(columnIndex2);
                                                C4990ab.m7410d("MicroMsg.JsApiChooseContact", "onActivityResult, username : ".concat(String.valueOf(string)));
                                                if (string2 != null) {
                                                    C4990ab.m7410d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : ".concat(String.valueOf(string2)));
                                                    if (string2 == null) {
                                                        string2 = null;
                                                    } else {
                                                        string2 = string2.replaceAll("\\D", "");
                                                        if (string2.startsWith("86")) {
                                                            string2 = string2.substring(2);
                                                        }
                                                    }
                                                    C4990ab.m7410d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : ".concat(String.valueOf(string2)));
                                                    if (!(PhoneNumberUtils.isGlobalPhoneNumber(string2) && string2.length() == 11)) {
                                                        string2 = str;
                                                    }
                                                    C4990ab.m7410d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneResult : ".concat(String.valueOf(string2)));
                                                } else {
                                                    string2 = str;
                                                }
                                                query2.moveToNext();
                                                str = string2;
                                            }
                                            obj = string;
                                        } else {
                                            Map obj2 = null;
                                            str = null;
                                        }
                                        try {
                                            query2.close();
                                        } catch (Exception e) {
                                        }
                                        if (!(query == null || query.isClosed())) {
                                            query.close();
                                        }
                                        if (C5046bo.isNullOrNil(str)) {
                                            HashMap hashMap = new HashMap(1);
                                            hashMap.put("phoneNumber", str);
                                            str = "displayName";
                                            if (obj2 == null) {
                                                obj2 = "";
                                            }
                                            hashMap.put(str, obj2);
                                            c2241c.mo6107M(i, C33279c.this.mo73394j("ok", hashMap));
                                            AppMethodBeat.m2505o(126269);
                                            return;
                                        }
                                        c2241c.mo6107M(i, C33279c.this.mo73394j("fail", null));
                                        Toast.makeText(context, C25738R.string.f9004m6, 0).show();
                                    }
                                }
                                obj2 = null;
                                str = null;
                                query.close();
                                if (C5046bo.isNullOrNil(str)) {
                                }
                            } catch (SecurityException e2) {
                                C4990ab.m7413e("MicroMsg.JsApiChooseContact", "onActivityResult, permission denied: %s", e2.toString());
                                new Builder(context).setMessage(C4996ah.getResources().getString(C25738R.string.f9028my)).setTitle("").setCancelable(true).show();
                                c2241c.mo6107M(i, C33279c.this.mo73394j("fail:system permission denied", null));
                                AppMethodBeat.m2505o(126269);
                                return;
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.JsApiChooseContact", "onActivityResult, no contact permission");
                            c2241c.mo6107M(i, C33279c.this.mo73394j("fail:system permission denied", null));
                            AppMethodBeat.m2505o(126269);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(126269);
                }
            });
            AppMethodBeat.m2505o(126271);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiChooseContact", "check permission");
        AppMethodBeat.m2505o(126271);
    }
}
