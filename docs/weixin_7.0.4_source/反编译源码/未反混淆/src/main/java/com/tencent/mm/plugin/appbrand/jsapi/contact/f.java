package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 414;
    public static final String NAME = "searchContacts";
    private List<String[]> hIL;

    public final void a(final c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(126273);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiSearchContacts", "data is null, err");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(126273);
            return;
        }
        ab.i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
        ab.d("MicroMsg.JsApiSearchContacts", "data:%s", jSONObject);
        Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            ab.e("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", cVar.getAppId());
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(126273);
            return;
        }
        boolean z;
        n.b(cVar.getAppId(), new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.i(126272);
                if (i != 48) {
                    AppMethodBeat.o(126272);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    cVar.M(i, f.this.j("fail:system permission denied", null));
                    AppMethodBeat.o(126272);
                } else {
                    f.this.a(cVar, jSONObject, i);
                    AppMethodBeat.o(126272);
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
            String optString = jSONObject.optString("phoneNumber");
            HashMap hashMap;
            if (optString.length() < 8) {
                ab.e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
                hashMap = new HashMap();
                hashMap.put("result", "");
                cVar.M(i, j("ok", hashMap));
                AppMethodBeat.o(126273);
                return;
            }
            if (this.hIL == null) {
                this.hIL = cJ(context);
            }
            if (this.hIL == null) {
                ab.e("MicroMsg.JsApiSearchContacts", "addressList is null, err");
                cVar.M(i, j("fail", null));
                AppMethodBeat.o(126273);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            if (!(this.hIL == null || this.hIL.isEmpty())) {
                for (String[] strArr : this.hIL) {
                    String str = strArr[2];
                    if (str == null) {
                        str = null;
                    } else {
                        str = str.replaceAll("\\D", "");
                        if (str.startsWith("86")) {
                            str = str.substring(2);
                        }
                    }
                    String bc = bo.bc(strArr[1], "");
                    if (!bo.isNullOrNil(str) && cd(optString, str)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("phoneNumber", str);
                            jSONObject2.put("name", bc);
                            jSONArray.put(jSONObject2);
                        } catch (JSONException e) {
                            ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", e, "", new Object[0]);
                        }
                    }
                }
            }
            ab.d("MicroMsg.JsApiSearchContacts", "resultArray:%s", jSONArray.toString());
            hashMap = new HashMap();
            hashMap.put("result", jSONArray.toString());
            cVar.M(i, j("ok", hashMap));
            AppMethodBeat.o(126273);
            return;
        }
        ab.i("MicroMsg.JsApiSearchContacts", "check permission");
        AppMethodBeat.o(126273);
    }

    private static boolean cd(String str, String str2) {
        AppMethodBeat.i(126274);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
            AppMethodBeat.o(126274);
            return false;
        }
        int length = str.length();
        int length2 = str2.length();
        if (length < 8) {
            ab.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", Integer.valueOf(str.length()));
            AppMethodBeat.o(126274);
            return false;
        } else if (length > length2) {
            ab.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", Integer.valueOf(length), Integer.valueOf(length2));
            AppMethodBeat.o(126274);
            return false;
        } else {
            length2 = 0;
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) != str2.charAt(i)) {
                    length2++;
                    if (length2 > 3) {
                        break;
                    }
                }
            }
            if (length2 <= 3) {
                AppMethodBeat.o(126274);
                return true;
            }
            AppMethodBeat.o(126274);
            return false;
        }
    }

    private static List<String[]> cJ(Context context) {
        AppMethodBeat.i(126275);
        LinkedList linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (g.o(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, "sort_key_alt");
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", e, "", new Object[0]);
                ab.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo(), [%s]", e.getMessage());
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
            }
            if (query == null) {
                ab.e("MicroMsg.JsApiSearchContacts", "getMobileInfo: mobile is null");
                AppMethodBeat.o(126275);
                return linkedList;
            }
            try {
                if (query.getCount() <= 0 || !query.moveToFirst()) {
                    query.close();
                    AppMethodBeat.o(126275);
                    return linkedList;
                }
                do {
                    String string = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                    String string2 = query.getString(query.getColumnIndex("contact_id"));
                    String string3 = query.getString(query.getColumnIndex("data1"));
                    String string4 = query.getString(query.getColumnIndex("raw_contact_id"));
                    linkedList.add(new String[]{string2, string, string3, string4});
                } while (query.moveToNext());
                query.close();
                AppMethodBeat.o(126275);
                return linkedList;
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", e2, "", new Object[0]);
                ab.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo()2, [%s]", e2.getMessage());
                query.close();
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.o(126275);
            }
        } else {
            ab.e("MicroMsg.JsApiSearchContacts", "no contact permission");
            AppMethodBeat.o(126275);
            return linkedList;
        }
    }
}
