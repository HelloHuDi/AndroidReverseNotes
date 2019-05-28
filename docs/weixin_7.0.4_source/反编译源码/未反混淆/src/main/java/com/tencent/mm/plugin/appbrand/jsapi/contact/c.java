package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.luggage.g.e;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(126271);
        final Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            ab.e("MicroMsg.JsApiChooseContact", "getPageContext failed, appid is %s", cVar.getAppId());
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(126271);
            return;
        }
        boolean z;
        n.b(cVar.getAppId(), new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.i(126270);
                if (i != 48) {
                    AppMethodBeat.o(126270);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    cVar.M(i, c.this.j("permission_denied", null));
                    AppMethodBeat.o(126270);
                } else {
                    c.this.a(cVar, jSONObject, i);
                    AppMethodBeat.o(126270);
                }
            }
        });
        Context context2 = cVar.getContext();
        if (context2 == null || !(context2 instanceof Activity)) {
            cVar.M(i, j("fail", null));
            z = false;
        } else {
            z = g.a((Activity) context2, "android.permission.READ_CONTACTS", 48, "", "");
            if (z) {
                n.Dr(cVar.getAppId());
            }
        }
        if (z) {
            e.ax(context).a(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), new e.a() {
                /* JADX WARNING: Removed duplicated region for block: B:58:0x0204  */
                /* JADX WARNING: Removed duplicated region for block: B:54:0x01d9  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void b(int i, Intent intent) {
                    AppMethodBeat.i(126269);
                    if (i == 0 || i == 1) {
                        cVar.M(i, c.this.j("cancel", null));
                        AppMethodBeat.o(126269);
                        return;
                    }
                    if (i == -1) {
                        Uri data = intent.getData();
                        if (data == null) {
                            ab.e("MicroMsg.JsApiChooseContact", "onActivityResult, uri == null");
                            cVar.M(i, c.this.j("fail", null));
                            AppMethodBeat.o(126269);
                            return;
                        } else if (g.o(context, "android.permission.READ_CONTACTS")) {
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
                                        ab.i("MicroMsg.JsApiChooseContact", "onActivityResult, queried cursor = %s", query);
                                        if (query2 == null) {
                                            cVar.M(i, c.this.j("fail", null));
                                            AppMethodBeat.o(126269);
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
                                                ab.d("MicroMsg.JsApiChooseContact", "onActivityResult, username : ".concat(String.valueOf(string)));
                                                if (string2 != null) {
                                                    ab.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : ".concat(String.valueOf(string2)));
                                                    if (string2 == null) {
                                                        string2 = null;
                                                    } else {
                                                        string2 = string2.replaceAll("\\D", "");
                                                        if (string2.startsWith("86")) {
                                                            string2 = string2.substring(2);
                                                        }
                                                    }
                                                    ab.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : ".concat(String.valueOf(string2)));
                                                    if (!(PhoneNumberUtils.isGlobalPhoneNumber(string2) && string2.length() == 11)) {
                                                        string2 = str;
                                                    }
                                                    ab.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneResult : ".concat(String.valueOf(string2)));
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
                                        if (bo.isNullOrNil(str)) {
                                            HashMap hashMap = new HashMap(1);
                                            hashMap.put("phoneNumber", str);
                                            str = "displayName";
                                            if (obj2 == null) {
                                                obj2 = "";
                                            }
                                            hashMap.put(str, obj2);
                                            cVar.M(i, c.this.j("ok", hashMap));
                                            AppMethodBeat.o(126269);
                                            return;
                                        }
                                        cVar.M(i, c.this.j("fail", null));
                                        Toast.makeText(context, R.string.m6, 0).show();
                                    }
                                }
                                obj2 = null;
                                str = null;
                                query.close();
                                if (bo.isNullOrNil(str)) {
                                }
                            } catch (SecurityException e2) {
                                ab.e("MicroMsg.JsApiChooseContact", "onActivityResult, permission denied: %s", e2.toString());
                                new Builder(context).setMessage(ah.getResources().getString(R.string.my)).setTitle("").setCancelable(true).show();
                                cVar.M(i, c.this.j("fail:system permission denied", null));
                                AppMethodBeat.o(126269);
                                return;
                            }
                        } else {
                            ab.e("MicroMsg.JsApiChooseContact", "onActivityResult, no contact permission");
                            cVar.M(i, c.this.j("fail:system permission denied", null));
                            AppMethodBeat.o(126269);
                            return;
                        }
                    }
                    AppMethodBeat.o(126269);
                }
            });
            AppMethodBeat.o(126271);
            return;
        }
        ab.i("MicroMsg.JsApiChooseContact", "check permission");
        AppMethodBeat.o(126271);
    }
}
