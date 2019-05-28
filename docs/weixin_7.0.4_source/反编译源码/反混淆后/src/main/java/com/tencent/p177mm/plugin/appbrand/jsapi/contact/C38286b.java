package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import com.google.android.gms.common.Scopes;
import com.tencent.luggage.p147g.C8870e;
import com.tencent.luggage.p147g.C8870e.C8872a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C45590a.C19354a;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C45590a.C26955b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.b */
public final class C38286b extends C10296a {
    public static final int CTRL_INDEX = 226;
    public static final String NAME = "addPhoneContact";
    private C45590a hIc;

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126264);
        C4990ab.m7410d("MicroMsg.JsApiAddPhoneContact", "addPhoneContact!");
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiAddPhoneContact", "data is null");
            AppMethodBeat.m2505o(126264);
        } else if (C5046bo.isNullOrNil(jSONObject.optString("firstName"))) {
            c2241c.mo6107M(i, mo73394j("fail:firstName is null", null));
            C4990ab.m7412e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
            AppMethodBeat.m2505o(126264);
        } else {
            Context context = c2241c.getContext();
            if (context == null || !(context instanceof Activity)) {
                c2241c.mo6107M(i, mo73394j("fail", null));
                C4990ab.m7412e("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
                AppMethodBeat.m2505o(126264);
                return;
            }
            this.hIc = new C45590a();
            this.hIc.hHN = jSONObject.optString("photoFilePath");
            this.hIc.bCu = jSONObject.optString("nickName");
            this.hIc.hHM = new C26955b(jSONObject.optString("firstName"), jSONObject.optString("middleName"), jSONObject.optString("lastName"));
            this.hIc.hHV = jSONObject.optString("remark");
            this.hIc.hHR = jSONObject.optString("mobilePhoneNumber");
            this.hIc.hHZ = jSONObject.optString("weChatNumber");
            this.hIc.hHQ = C38286b.m64788e(jSONObject, "address");
            this.hIc.hHW = jSONObject.optString("organization");
            this.hIc.title = jSONObject.optString("title");
            this.hIc.hHX = jSONObject.optString("workFaxNumber");
            this.hIc.hHU = jSONObject.optString("workPhoneNumber");
            this.hIc.hHT = jSONObject.optString("hostNumber");
            this.hIc.dtV = jSONObject.optString(Scopes.EMAIL);
            this.hIc.url = jSONObject.optString("url");
            this.hIc.hHP = C38286b.m64788e(jSONObject, "workAddress");
            this.hIc.hHY = jSONObject.optString("homeFaxNumber");
            this.hIc.hHS = jSONObject.optString("homePhoneNumber");
            this.hIc.hHO = C38286b.m64788e(jSONObject, "homeAddress");
            final Activity activity = (Activity) context;
            final String[] strArr = new String[]{activity.getString(C25738R.string.cus), activity.getString(C25738R.string.cur)};
            C36356d c36356d = new C36356d(activity, 1, false);
            c36356d.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(126260);
                    c44273l.mo70068e(0, strArr[0]);
                    c44273l.mo70068e(1, strArr[1]);
                    AppMethodBeat.m2505o(126260);
                }
            };
            final C2241c c2241c2 = c2241c;
            final C2241c c2241c3 = c2241c;
            final int i2 = i;
            c36356d.rBm = new C5279d() {

                /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.b$2$1 */
                class C67751 implements C8872a {
                    C67751() {
                    }

                    /* renamed from: b */
                    public final void mo15055b(int i, Intent intent) {
                        AppMethodBeat.m2504i(126261);
                        c2241c3.mo6107M(i2, C38286b.this.mo73394j("ok", null));
                        AppMethodBeat.m2505o(126261);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.b$2$2 */
                class C67762 implements C8872a {
                    C67762() {
                    }

                    /* renamed from: b */
                    public final void mo15055b(int i, Intent intent) {
                        AppMethodBeat.m2504i(126262);
                        c2241c3.mo6107M(i2, C38286b.this.mo73394j("ok", null));
                        AppMethodBeat.m2505o(126262);
                    }
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(126263);
                    Intent intent;
                    switch (i) {
                        case 0:
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            C38286b.m64785a(C38286b.this, intent, activity, c2241c2);
                            activity.startActivity(intent);
                            C8870e.m15839ax(activity).mo20068a(intent, new C67751());
                            AppMethodBeat.m2505o(126263);
                            return;
                        case 1:
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            C38286b.m64785a(C38286b.this, intent, activity, c2241c2);
                            C8870e.m15839ax(activity).mo20068a(intent, new C67762());
                            break;
                    }
                    AppMethodBeat.m2505o(126263);
                }
            };
            c36356d.cpD();
            AppMethodBeat.m2505o(126264);
        }
    }

    /* renamed from: e */
    private static C19354a m64788e(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(126265);
        C19354a c19354a = new C19354a(jSONObject.optString(str + "Country"), jSONObject.optString(str + "State"), jSONObject.optString(str + "City"), jSONObject.optString(str + "Street"), jSONObject.optString(str + "PostalCode"));
        AppMethodBeat.m2505o(126265);
        return c19354a;
    }

    /* renamed from: a */
    private static void m64786a(ArrayList<ContentValues> arrayList, C19354a c19354a, int i) {
        AppMethodBeat.m2504i(126266);
        if (c19354a != null && c19354a.aDu().length() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data1", c19354a.aDu());
            contentValues.put("data9", c19354a.hIb);
            contentValues.put("data2", Integer.valueOf(i));
            arrayList.add(contentValues);
        }
        AppMethodBeat.m2505o(126266);
    }

    /* renamed from: a */
    private static void m64787a(ArrayList<ContentValues> arrayList, String str, int i) {
        AppMethodBeat.m2504i(126267);
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data1", str);
        contentValues.put("data2", Integer.valueOf(i));
        arrayList.add(contentValues);
        AppMethodBeat.m2505o(126267);
    }

    /* renamed from: a */
    static /* synthetic */ void m64785a(C38286b c38286b, Intent intent, Activity activity, C2241c c2241c) {
        ContentValues contentValues;
        AppMethodBeat.m2504i(126268);
        intent.setFlags(268435456);
        ArrayList arrayList = new ArrayList();
        C26955b c26955b = c38286b.hIc.hHM;
        StringBuilder stringBuilder = new StringBuilder();
        if (C5046bo.amT(c26955b.firstName) || C5046bo.amT(c26955b.middleName) || C5046bo.amT(c26955b.lastName)) {
            if (c26955b.lastName.trim().length() > 0) {
                stringBuilder.append(c26955b.lastName);
            }
            if (c26955b.middleName.trim().length() > 0) {
                stringBuilder.append(c26955b.middleName);
            }
            if (c26955b.firstName.trim().length() > 0) {
                stringBuilder.append(c26955b.firstName);
            }
        } else {
            if (c26955b.firstName.trim().length() > 0) {
                stringBuilder.append(c26955b.firstName);
            }
            if (c26955b.middleName.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(c26955b.middleName);
            }
            if (c26955b.lastName.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(c26955b.lastName);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        if (C5046bo.isNullOrNil(stringBuilder2)) {
            C4990ab.m7412e("MicroMsg.JsApiAddPhoneContact", "no contact user name");
        } else {
            intent.putExtra("name", stringBuilder2);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.bCu)) {
            stringBuilder2 = c38286b.hIc.bCu;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.hHV)) {
            stringBuilder2 = c38286b.hIc.hHV;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/note");
            contentValues.put("data1", stringBuilder2);
            arrayList.add(contentValues);
        }
        if (!(C5046bo.isNullOrNil(c38286b.hIc.hHW) && C5046bo.isNullOrNil(c38286b.hIc.title))) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
            if (!C5046bo.isNullOrNil(c38286b.hIc.hHW)) {
                contentValues2.put("data1", c38286b.hIc.hHW);
            }
            if (!C5046bo.isNullOrNil(c38286b.hIc.title)) {
                contentValues2.put("data4", c38286b.hIc.title);
            }
            contentValues2.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues2);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.url)) {
            stringBuilder2 = c38286b.hIc.url;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/website");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.dtV)) {
            intent.putExtra(Scopes.EMAIL, c38286b.hIc.dtV);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.hHR)) {
            C38286b.m64787a(arrayList, c38286b.hIc.hHR, 2);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.hHS)) {
            C38286b.m64787a(arrayList, c38286b.hIc.hHS, 1);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.hHU)) {
            C38286b.m64787a(arrayList, c38286b.hIc.hHU, 3);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.hHT)) {
            C38286b.m64787a(arrayList, c38286b.hIc.hHT, 10);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.hHY)) {
            C38286b.m64787a(arrayList, c38286b.hIc.hHY, 5);
        }
        if (!C5046bo.isNullOrNil(c38286b.hIc.hHX)) {
            C38286b.m64787a(arrayList, c38286b.hIc.hHX, 4);
        }
        C38286b.m64786a(arrayList, c38286b.hIc.hHQ, 3);
        C38286b.m64786a(arrayList, c38286b.hIc.hHP, 2);
        C38286b.m64786a(arrayList, c38286b.hIc.hHO, 1);
        if (!C5046bo.isNullOrNil(c38286b.hIc.hHZ)) {
            stringBuilder2 = c38286b.hIc.hHZ;
            String string = activity.getString(C25738R.string.f9176ru);
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/im");
            contentValues3.put("data1", stringBuilder2);
            contentValues3.put("data5", Integer.valueOf(-1));
            contentValues3.put("data6", string);
            arrayList.add(contentValues3);
        }
        File yg = c2241c.asE().mo34314yg(c38286b.hIc.hHN);
        if (yg != null && yg.exists()) {
            stringBuilder2 = yg.getAbsolutePath();
            if (!stringBuilder2.startsWith("file://")) {
                stringBuilder2 = "file://".concat(String.valueOf(stringBuilder2));
            }
            Bitmap a = C37926b.abR().mo60681a(stringBuilder2, null);
            if (a != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                ContentValues contentValues4 = new ContentValues();
                contentValues4.put("mimetype", "vnd.android.cursor.item/photo");
                contentValues4.put("data15", toByteArray);
                arrayList.add(contentValues4);
                C4990ab.m7417i("MicroMsg.JsApiAddPhoneContact", "bitmap recycle %s", a);
                a.recycle();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiAddPhoneContact", e, "", new Object[0]);
                }
            }
        }
        intent.putParcelableArrayListExtra("data", arrayList);
        AppMethodBeat.m2505o(126268);
    }
}
