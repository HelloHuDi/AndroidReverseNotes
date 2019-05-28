package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.cd.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact extends ExtContentProviderBase {
    private static List<String> elZ = new ArrayList();
    private static final String[] lQC = new String[]{"userId", "nickname", "avatar", b.CONTENT, "msgId", "msgType"};
    private Cursor lQG = null;

    static {
        int i = 0;
        AppMethodBeat.i(20388);
        String[] strArr = t.fkY;
        int length = strArr.length;
        while (i < length) {
            elZ.add(strArr[i]);
            i++;
        }
        elZ.add("officialaccounts");
        elZ.add("helper_entry");
        AppMethodBeat.o(20388);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(20386);
        ab.d("MicroMsg.ExtControlProviderSearchContact", "query()");
        a(uri, getContext(), 16);
        Cursor cursor;
        if (uri == null) {
            vf(3);
            AppMethodBeat.o(20386);
            return null;
        } else if (bo.isNullOrNil(this.lPW) || bo.isNullOrNil(brL())) {
            vf(3);
            AppMethodBeat.o(20386);
            return null;
        } else if (!aVl()) {
            vf(1);
            cursor = this.jDN;
            AppMethodBeat.o(20386);
            return cursor;
        } else if (!dJ(getContext())) {
            ab.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
            vf(2);
            AppMethodBeat.o(20386);
            return null;
        } else if (strArr2 == null || strArr2.length == 0) {
            ab.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
            vf(3);
            AppMethodBeat.o(20386);
            return null;
        } else {
            String trim = strArr2[0].trim();
            if (bo.isNullOrNil(trim)) {
                ab.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
                vf(3);
                AppMethodBeat.o(20386);
                return null;
            }
            final Cursor a = aw.ZK().fke.a(trim, "@micromsg.no.verify.biz.qq.com", elZ, false, 1, null);
            if (a == null) {
                ab.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
                vf(3);
                AppMethodBeat.o(20386);
                return null;
            }
            final com.tencent.mm.pluginsdk.d.a.b bVar = new com.tencent.mm.pluginsdk.d.a.b();
            bVar.b(4000, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20385);
                    ExtControlProviderSearchContact.this.lQG = ExtControlProviderSearchContact.g(a);
                    bVar.countDown();
                    AppMethodBeat.o(20385);
                }
            });
            if (this.lQG != null) {
                vf(0);
            } else {
                vf(4);
            }
            cursor = this.lQG;
            AppMethodBeat.o(20386);
            return cursor;
        }
    }

    public static Cursor g(Cursor cursor) {
        AppMethodBeat.i(20387);
        e eVar = new e(lQC, (byte) 0);
        try {
            if (cursor.moveToFirst()) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    ad adVar = new ad();
                    adVar.d(cursor);
                    if (!t.kH(adVar.field_username)) {
                        ByteArrayOutputStream byteArrayOutputStream;
                        Bitmap b = o.acv().b(adVar.field_username, true, 0);
                        if (b != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        } else {
                            ab.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
                            byteArrayOutputStream = null;
                        }
                        aw.ZK();
                        bi[] cC = c.XO().cC(adVar.field_username, 1);
                        byte[] bArr;
                        if (cC == null || cC.length != 1) {
                            ab.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
                            Object[] objArr = new Object[6];
                            objArr[0] = a.ii((long) ((int) adVar.ewQ));
                            objArr[1] = adVar.Oj();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr[2] = bArr;
                            objArr[3] = "";
                            objArr[4] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            objArr[5] = Integer.valueOf(0);
                            eVar.addRow(objArr);
                        } else {
                            String str;
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = a.ii((long) ((int) adVar.ewQ));
                            objArr2[1] = adVar.Oj();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr2[2] = bArr;
                            if (cC[0].getType() == 1) {
                                str = cC[0].field_content;
                            } else {
                                str = "";
                            }
                            objArr2[3] = str;
                            objArr2[4] = a.ii(cC[0].field_msgId);
                            objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.ext.b.b.V(cC[0]));
                            eVar.addRow(objArr2);
                        }
                    }
                    if (!cursor.moveToNext() || i2 >= 15) {
                        break;
                    }
                    i = i2;
                }
            }
            cursor.close();
            AppMethodBeat.o(20387);
            return eVar;
        } catch (Exception e) {
            ab.e("MicroMsg.ExtControlProviderSearchContact", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            eVar.close();
            AppMethodBeat.o(20387);
            return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
