package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.p057v4.app.C6184a.C0315a;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.f */
public final class C2259f extends C10296a {
    public static final int CTRL_INDEX = 414;
    public static final String NAME = "searchContacts";
    private List<String[]> hIL;

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(126273);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiSearchContacts", "data is null, err");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(126273);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
        C4990ab.m7411d("MicroMsg.JsApiSearchContacts", "data:%s", jSONObject);
        Context context = c2241c.getContext();
        if (context == null || !(context instanceof Activity)) {
            C4990ab.m7413e("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", c2241c.getAppId());
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(126273);
            return;
        }
        boolean z;
        C19663n.m30463b(c2241c.getAppId(), new C0315a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                AppMethodBeat.m2504i(126272);
                if (i != 48) {
                    AppMethodBeat.m2505o(126272);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    c2241c.mo6107M(i, C2259f.this.mo73394j("fail:system permission denied", null));
                    AppMethodBeat.m2505o(126272);
                } else {
                    C2259f.this.mo5994a(c2241c, jSONObject, i);
                    AppMethodBeat.m2505o(126272);
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
            String optString = jSONObject.optString("phoneNumber");
            HashMap hashMap;
            if (optString.length() < 8) {
                C4990ab.m7412e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
                hashMap = new HashMap();
                hashMap.put("result", "");
                c2241c.mo6107M(i, mo73394j("ok", hashMap));
                AppMethodBeat.m2505o(126273);
                return;
            }
            if (this.hIL == null) {
                this.hIL = C2259f.m4484cJ(context);
            }
            if (this.hIL == null) {
                C4990ab.m7412e("MicroMsg.JsApiSearchContacts", "addressList is null, err");
                c2241c.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(126273);
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
                    String bc = C5046bo.m7532bc(strArr[1], "");
                    if (!C5046bo.isNullOrNil(str) && C2259f.m4485cd(optString, str)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("phoneNumber", str);
                            jSONObject2.put("name", bc);
                            jSONArray.put(jSONObject2);
                        } catch (JSONException e) {
                            C4990ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", e, "", new Object[0]);
                        }
                    }
                }
            }
            C4990ab.m7411d("MicroMsg.JsApiSearchContacts", "resultArray:%s", jSONArray.toString());
            hashMap = new HashMap();
            hashMap.put("result", jSONArray.toString());
            c2241c.mo6107M(i, mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(126273);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiSearchContacts", "check permission");
        AppMethodBeat.m2505o(126273);
    }

    /* renamed from: cd */
    private static boolean m4485cd(String str, String str2) {
        AppMethodBeat.m2504i(126274);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
            AppMethodBeat.m2505o(126274);
            return false;
        }
        int length = str.length();
        int length2 = str2.length();
        if (length < 8) {
            C4990ab.m7411d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", Integer.valueOf(str.length()));
            AppMethodBeat.m2505o(126274);
            return false;
        } else if (length > length2) {
            C4990ab.m7411d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", Integer.valueOf(length), Integer.valueOf(length2));
            AppMethodBeat.m2505o(126274);
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
                AppMethodBeat.m2505o(126274);
                return true;
            }
            AppMethodBeat.m2505o(126274);
            return false;
        }
    }

    /* renamed from: cJ */
    private static List<String[]> m4484cJ(Context context) {
        AppMethodBeat.m2504i(126275);
        LinkedList linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (C0991g.m2253o(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, "sort_key_alt");
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo(), [%s]", e.getMessage());
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
            }
            if (query == null) {
                C4990ab.m7412e("MicroMsg.JsApiSearchContacts", "getMobileInfo: mobile is null");
                AppMethodBeat.m2505o(126275);
                return linkedList;
            }
            try {
                if (query.getCount() <= 0 || !query.moveToFirst()) {
                    query.close();
                    AppMethodBeat.m2505o(126275);
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
                AppMethodBeat.m2505o(126275);
                return linkedList;
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", e2, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo()2, [%s]", e2.getMessage());
                query.close();
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.m2505o(126275);
            }
        } else {
            C4990ab.m7412e("MicroMsg.JsApiSearchContacts", "no contact permission");
            AppMethodBeat.m2505o(126275);
            return linkedList;
        }
    }
}
