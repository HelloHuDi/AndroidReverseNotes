package com.tencent.p177mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p213cd.C1359e;
import com.tencent.p177mm.plugin.ext.p1398a.C27902a;
import com.tencent.p177mm.plugin.ext.p962b.C11771b;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C46484b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderSearchContact */
public class ExtControlProviderSearchContact extends ExtContentProviderBase {
    private static List<String> elZ = new ArrayList();
    private static final String[] lQC = new String[]{"userId", "nickname", "avatar", C8741b.CONTENT, "msgId", "msgType"};
    private Cursor lQG = null;

    static {
        int i = 0;
        AppMethodBeat.m2504i(20388);
        String[] strArr = C1855t.fkY;
        int length = strArr.length;
        while (i < length) {
            elZ.add(strArr[i]);
            i++;
        }
        elZ.add("officialaccounts");
        elZ.add("helper_entry");
        AppMethodBeat.m2505o(20388);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(20386);
        C4990ab.m7410d("MicroMsg.ExtControlProviderSearchContact", "query()");
        mo61882a(uri, getContext(), 16);
        Cursor cursor;
        if (uri == null) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20386);
            return null;
        } else if (C5046bo.isNullOrNil(this.lPW) || C5046bo.isNullOrNil(brL())) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20386);
            return null;
        } else if (!aVl()) {
            mo61890vf(1);
            cursor = this.jDN;
            AppMethodBeat.m2505o(20386);
            return cursor;
        } else if (!mo61888dJ(getContext())) {
            C4990ab.m7420w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
            mo61890vf(2);
            AppMethodBeat.m2505o(20386);
            return null;
        } else if (strArr2 == null || strArr2.length == 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
            mo61890vf(3);
            AppMethodBeat.m2505o(20386);
            return null;
        } else {
            String trim = strArr2[0].trim();
            if (C5046bo.isNullOrNil(trim)) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
                mo61890vf(3);
                AppMethodBeat.m2505o(20386);
                return null;
            }
            final Cursor a = C9638aw.m17190ZK().fke.mo20975a(trim, "@micromsg.no.verify.biz.qq.com", elZ, false, 1, null);
            if (a == null) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
                mo61890vf(3);
                AppMethodBeat.m2505o(20386);
                return null;
            }
            final C46484b c46484b = new C46484b();
            c46484b.mo74707b(4000, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(20385);
                    ExtControlProviderSearchContact.this.lQG = ExtControlProviderSearchContact.m31844g(a);
                    c46484b.countDown();
                    AppMethodBeat.m2505o(20385);
                }
            });
            if (this.lQG != null) {
                mo61890vf(0);
            } else {
                mo61890vf(4);
            }
            cursor = this.lQG;
            AppMethodBeat.m2505o(20386);
            return cursor;
        }
    }

    /* renamed from: g */
    public static Cursor m31844g(Cursor cursor) {
        AppMethodBeat.m2504i(20387);
        C1359e c1359e = new C1359e(lQC, (byte) 0);
        try {
            if (cursor.moveToFirst()) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    C7616ad c7616ad = new C7616ad();
                    c7616ad.mo8995d(cursor);
                    if (!C1855t.m3896kH(c7616ad.field_username)) {
                        ByteArrayOutputStream byteArrayOutputStream;
                        Bitmap b = C17884o.acv().mo67493b(c7616ad.field_username, true, 0);
                        if (b != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        } else {
                            C4990ab.m7420w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
                            byteArrayOutputStream = null;
                        }
                        C9638aw.m17190ZK();
                        C7620bi[] cC = C18628c.m29080XO().mo15318cC(c7616ad.field_username, 1);
                        byte[] bArr;
                        if (cC == null || cC.length != 1) {
                            C4990ab.m7420w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
                            Object[] objArr = new Object[6];
                            objArr[0] = C27902a.m44382ii((long) ((int) c7616ad.ewQ));
                            objArr[1] = c7616ad.mo16707Oj();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr[2] = bArr;
                            objArr[3] = "";
                            objArr[4] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            objArr[5] = Integer.valueOf(0);
                            c1359e.addRow(objArr);
                        } else {
                            String str;
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = C27902a.m44382ii((long) ((int) c7616ad.ewQ));
                            objArr2[1] = c7616ad.mo16707Oj();
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
                            objArr2[4] = C27902a.m44382ii(cC[0].field_msgId);
                            objArr2[5] = Integer.valueOf(C11771b.m19605V(cC[0]));
                            c1359e.addRow(objArr2);
                        }
                    }
                    if (!cursor.moveToNext() || i2 >= 15) {
                        break;
                    }
                    i = i2;
                }
            }
            cursor.close();
            AppMethodBeat.m2505o(20387);
            return c1359e;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderSearchContact", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            c1359e.close();
            AppMethodBeat.m2505o(20387);
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
