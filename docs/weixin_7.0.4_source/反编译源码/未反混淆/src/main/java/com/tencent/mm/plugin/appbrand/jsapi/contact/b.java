package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import com.google.android.gms.common.Scopes;
import com.tencent.luggage.g.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 226;
    public static final String NAME = "addPhoneContact";
    private a hIc;

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126264);
        ab.d("MicroMsg.JsApiAddPhoneContact", "addPhoneContact!");
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.JsApiAddPhoneContact", "data is null");
            AppMethodBeat.o(126264);
        } else if (bo.isNullOrNil(jSONObject.optString("firstName"))) {
            cVar.M(i, j("fail:firstName is null", null));
            ab.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
            AppMethodBeat.o(126264);
        } else {
            Context context = cVar.getContext();
            if (context == null || !(context instanceof Activity)) {
                cVar.M(i, j("fail", null));
                ab.e("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
                AppMethodBeat.o(126264);
                return;
            }
            this.hIc = new a();
            this.hIc.hHN = jSONObject.optString("photoFilePath");
            this.hIc.bCu = jSONObject.optString("nickName");
            this.hIc.hHM = new com.tencent.mm.plugin.appbrand.jsapi.contact.a.b(jSONObject.optString("firstName"), jSONObject.optString("middleName"), jSONObject.optString("lastName"));
            this.hIc.hHV = jSONObject.optString("remark");
            this.hIc.hHR = jSONObject.optString("mobilePhoneNumber");
            this.hIc.hHZ = jSONObject.optString("weChatNumber");
            this.hIc.hHQ = e(jSONObject, "address");
            this.hIc.hHW = jSONObject.optString("organization");
            this.hIc.title = jSONObject.optString("title");
            this.hIc.hHX = jSONObject.optString("workFaxNumber");
            this.hIc.hHU = jSONObject.optString("workPhoneNumber");
            this.hIc.hHT = jSONObject.optString("hostNumber");
            this.hIc.dtV = jSONObject.optString(Scopes.EMAIL);
            this.hIc.url = jSONObject.optString("url");
            this.hIc.hHP = e(jSONObject, "workAddress");
            this.hIc.hHY = jSONObject.optString("homeFaxNumber");
            this.hIc.hHS = jSONObject.optString("homePhoneNumber");
            this.hIc.hHO = e(jSONObject, "homeAddress");
            final Activity activity = (Activity) context;
            final String[] strArr = new String[]{activity.getString(R.string.cus), activity.getString(R.string.cur)};
            d dVar = new d(activity, 1, false);
            dVar.rBl = new n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(126260);
                    lVar.e(0, strArr[0]);
                    lVar.e(1, strArr[1]);
                    AppMethodBeat.o(126260);
                }
            };
            final c cVar2 = cVar;
            final c cVar3 = cVar;
            final int i2 = i;
            dVar.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(126263);
                    Intent intent;
                    switch (i) {
                        case 0:
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            b.a(b.this, intent, activity, cVar2);
                            activity.startActivity(intent);
                            e.ax(activity).a(intent, new e.a() {
                                public final void b(int i, Intent intent) {
                                    AppMethodBeat.i(126261);
                                    cVar3.M(i2, b.this.j("ok", null));
                                    AppMethodBeat.o(126261);
                                }
                            });
                            AppMethodBeat.o(126263);
                            return;
                        case 1:
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            b.a(b.this, intent, activity, cVar2);
                            e.ax(activity).a(intent, new e.a() {
                                public final void b(int i, Intent intent) {
                                    AppMethodBeat.i(126262);
                                    cVar3.M(i2, b.this.j("ok", null));
                                    AppMethodBeat.o(126262);
                                }
                            });
                            break;
                    }
                    AppMethodBeat.o(126263);
                }
            };
            dVar.cpD();
            AppMethodBeat.o(126264);
        }
    }

    private static a.a e(JSONObject jSONObject, String str) {
        AppMethodBeat.i(126265);
        a.a aVar = new a.a(jSONObject.optString(str + "Country"), jSONObject.optString(str + "State"), jSONObject.optString(str + "City"), jSONObject.optString(str + "Street"), jSONObject.optString(str + "PostalCode"));
        AppMethodBeat.o(126265);
        return aVar;
    }

    private static void a(ArrayList<ContentValues> arrayList, a.a aVar, int i) {
        AppMethodBeat.i(126266);
        if (aVar != null && aVar.aDu().length() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data1", aVar.aDu());
            contentValues.put("data9", aVar.hIb);
            contentValues.put("data2", Integer.valueOf(i));
            arrayList.add(contentValues);
        }
        AppMethodBeat.o(126266);
    }

    private static void a(ArrayList<ContentValues> arrayList, String str, int i) {
        AppMethodBeat.i(126267);
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data1", str);
        contentValues.put("data2", Integer.valueOf(i));
        arrayList.add(contentValues);
        AppMethodBeat.o(126267);
    }

    static /* synthetic */ void a(b bVar, Intent intent, Activity activity, c cVar) {
        ContentValues contentValues;
        AppMethodBeat.i(126268);
        intent.setFlags(268435456);
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.plugin.appbrand.jsapi.contact.a.b bVar2 = bVar.hIc.hHM;
        StringBuilder stringBuilder = new StringBuilder();
        if (bo.amT(bVar2.firstName) || bo.amT(bVar2.middleName) || bo.amT(bVar2.lastName)) {
            if (bVar2.lastName.trim().length() > 0) {
                stringBuilder.append(bVar2.lastName);
            }
            if (bVar2.middleName.trim().length() > 0) {
                stringBuilder.append(bVar2.middleName);
            }
            if (bVar2.firstName.trim().length() > 0) {
                stringBuilder.append(bVar2.firstName);
            }
        } else {
            if (bVar2.firstName.trim().length() > 0) {
                stringBuilder.append(bVar2.firstName);
            }
            if (bVar2.middleName.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(bVar2.middleName);
            }
            if (bVar2.lastName.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(bVar2.lastName);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        if (bo.isNullOrNil(stringBuilder2)) {
            ab.e("MicroMsg.JsApiAddPhoneContact", "no contact user name");
        } else {
            intent.putExtra("name", stringBuilder2);
        }
        if (!bo.isNullOrNil(bVar.hIc.bCu)) {
            stringBuilder2 = bVar.hIc.bCu;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!bo.isNullOrNil(bVar.hIc.hHV)) {
            stringBuilder2 = bVar.hIc.hHV;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/note");
            contentValues.put("data1", stringBuilder2);
            arrayList.add(contentValues);
        }
        if (!(bo.isNullOrNil(bVar.hIc.hHW) && bo.isNullOrNil(bVar.hIc.title))) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
            if (!bo.isNullOrNil(bVar.hIc.hHW)) {
                contentValues2.put("data1", bVar.hIc.hHW);
            }
            if (!bo.isNullOrNil(bVar.hIc.title)) {
                contentValues2.put("data4", bVar.hIc.title);
            }
            contentValues2.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues2);
        }
        if (!bo.isNullOrNil(bVar.hIc.url)) {
            stringBuilder2 = bVar.hIc.url;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/website");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!bo.isNullOrNil(bVar.hIc.dtV)) {
            intent.putExtra(Scopes.EMAIL, bVar.hIc.dtV);
        }
        if (!bo.isNullOrNil(bVar.hIc.hHR)) {
            a(arrayList, bVar.hIc.hHR, 2);
        }
        if (!bo.isNullOrNil(bVar.hIc.hHS)) {
            a(arrayList, bVar.hIc.hHS, 1);
        }
        if (!bo.isNullOrNil(bVar.hIc.hHU)) {
            a(arrayList, bVar.hIc.hHU, 3);
        }
        if (!bo.isNullOrNil(bVar.hIc.hHT)) {
            a(arrayList, bVar.hIc.hHT, 10);
        }
        if (!bo.isNullOrNil(bVar.hIc.hHY)) {
            a(arrayList, bVar.hIc.hHY, 5);
        }
        if (!bo.isNullOrNil(bVar.hIc.hHX)) {
            a(arrayList, bVar.hIc.hHX, 4);
        }
        a(arrayList, bVar.hIc.hHQ, 3);
        a(arrayList, bVar.hIc.hHP, 2);
        a(arrayList, bVar.hIc.hHO, 1);
        if (!bo.isNullOrNil(bVar.hIc.hHZ)) {
            stringBuilder2 = bVar.hIc.hHZ;
            String string = activity.getString(R.string.ru);
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/im");
            contentValues3.put("data1", stringBuilder2);
            contentValues3.put("data5", Integer.valueOf(-1));
            contentValues3.put("data6", string);
            arrayList.add(contentValues3);
        }
        File yg = cVar.asE().yg(bVar.hIc.hHN);
        if (yg != null && yg.exists()) {
            stringBuilder2 = yg.getAbsolutePath();
            if (!stringBuilder2.startsWith("file://")) {
                stringBuilder2 = "file://".concat(String.valueOf(stringBuilder2));
            }
            Bitmap a = com.tencent.mm.modelappbrand.a.b.abR().a(stringBuilder2, null);
            if (a != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                ContentValues contentValues4 = new ContentValues();
                contentValues4.put("mimetype", "vnd.android.cursor.item/photo");
                contentValues4.put("data15", toByteArray);
                arrayList.add(contentValues4);
                ab.i("MicroMsg.JsApiAddPhoneContact", "bitmap recycle %s", a);
                a.recycle();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.JsApiAddPhoneContact", e, "", new Object[0]);
                }
            }
        }
        intent.putParcelableArrayListExtra("data", arrayList);
        AppMethodBeat.o(126268);
    }
}
