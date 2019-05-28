package com.tencent.p177mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26139fr;
import com.tencent.p177mm.p230g.p231a.C32557fk;
import com.tencent.p177mm.p230g.p231a.C37712fl;
import com.tencent.p177mm.p230g.p231a.C41995fs;
import com.tencent.p177mm.p230g.p231a.C9336fi;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.plugin.ext.C6875b;
import com.tencent.p177mm.plugin.ext.p1398a.C27902a;
import com.tencent.p177mm.plugin.ext.p962b.C11771b;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C40420a;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C46484b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23512bz;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg */
public class ExtControlProviderMsg extends ExtContentProviderBase {
    private static final UriMatcher lQc;
    private static final String[] lQf = new String[]{"msgId", "fromUserId", "fromUserNickName", "msgType", DownloadInfo.CONTENTTYPE, C8741b.CONTENT, "status", "createTime"};
    private static final String[] lQg = new String[]{"userId", "unReadCount"};
    private static final String[] lQh = new String[]{"userId", "unReadCount"};
    private static final String[] lQi = new String[]{"userId", "retCode", "msgId"};
    private static final String[] lQj = new String[]{"msgId", "retCode"};
    private static final String[] lQk = new String[]{"msgId", "retCode"};
    private String[] lPN;
    private int lPO;
    private boolean lQd;
    private Context lQe;
    private MatrixCursor lQl;

    static {
        AppMethodBeat.m2504i(20361);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
        lQc.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
        lQc.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
        lQc.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
        lQc.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
        lQc.addURI("com.tencent.mm.plugin.ext.message", JsApiStartPlayVoice.NAME, 12);
        lQc.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
        lQc.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
        AppMethodBeat.m2505o(20361);
    }

    public ExtControlProviderMsg() {
        this.lQl = null;
        this.lQd = false;
        this.lPN = null;
        this.lPO = -1;
    }

    public ExtControlProviderMsg(String[] strArr, int i, Context context) {
        this.lQl = null;
        this.lQd = false;
        this.lPN = null;
        this.lPO = -1;
        this.lQd = true;
        this.lPN = strArr;
        this.lPO = i;
        this.lQe = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor Kn;
        AppMethodBeat.m2504i(20351);
        C4990ab.m7416i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.lQd);
        if (this.lQd) {
            mo61883a(uri, this.lQe, this.lPO, this.lPN);
            if (C5046bo.isNullOrNil(this.lPW)) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "AppID == null");
                mo61889dZ(3, 7);
                MatrixCursor Kn2 = C40420a.m69330Kn(7);
                AppMethodBeat.m2505o(20351);
                return Kn2;
            } else if (C5046bo.isNullOrNil(brL())) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
                mo61889dZ(3, 6);
                Kn = C40420a.m69330Kn(6);
                AppMethodBeat.m2505o(20351);
                return Kn;
            } else {
                int brM = brM();
                if (brM != 1) {
                    C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(brM)));
                    mo61889dZ(2, brM);
                    Kn = C40420a.m69330Kn(brM);
                    AppMethodBeat.m2505o(20351);
                    return Kn;
                }
            }
        }
        this.lQe = getContext();
        mo61884a(uri, this.lQe, lQc);
        if (uri == null) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20351);
            return null;
        } else if (C5046bo.isNullOrNil(this.lPW) || C5046bo.isNullOrNil(brL())) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20351);
            return null;
        } else if (!aVl()) {
            mo61890vf(1);
            Kn = this.jDN;
            AppMethodBeat.m2505o(20351);
            return Kn;
        } else if (!mo61888dJ(this.lQe)) {
            C4990ab.m7420w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
            mo61890vf(2);
            AppMethodBeat.m2505o(20351);
            return null;
        }
        String nullAsNil = C5046bo.nullAsNil(uri.getQueryParameter("source"));
        String nullAsNil2 = C5046bo.nullAsNil(uri.getQueryParameter("count"));
        if (!this.lQd) {
            this.lPO = lQc.match(uri);
        }
        switch (this.lPO) {
            case 7:
                Kn = m76400b(strArr2, nullAsNil);
                AppMethodBeat.m2505o(20351);
                return Kn;
            case 8:
                Kn = m76401v(strArr2);
                AppMethodBeat.m2505o(20351);
                return Kn;
            case 9:
                Kn = m76396a(strArr2, nullAsNil, nullAsNil2);
                AppMethodBeat.m2505o(20351);
                return Kn;
            case 10:
                Kn = brN();
                AppMethodBeat.m2505o(20351);
                return Kn;
            case 11:
                Kn = m76402w(strArr2);
                AppMethodBeat.m2505o(20351);
                return Kn;
            case 12:
                Kn = m76403x(strArr2);
                AppMethodBeat.m2505o(20351);
                return Kn;
            case 13:
                Kn = m76404y(strArr2);
                AppMethodBeat.m2505o(20351);
                return Kn;
            case 14:
                Kn = m76405z(strArr2);
                AppMethodBeat.m2505o(20351);
                return Kn;
            default:
                mo61889dZ(3, 15);
                AppMethodBeat.m2505o(20351);
                return null;
        }
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

    /* renamed from: v */
    private Cursor m76401v(String[] strArr) {
        AppMethodBeat.m2504i(20352);
        C4990ab.m7410d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20352);
            return null;
        }
        Cursor matrixCursor = new MatrixCursor(lQg);
        try {
            int nR;
            if ("*".equals(strArr[0])) {
                C9638aw.m17190ZK();
                nR = C18628c.m29083XR().mo15824nR("");
                matrixCursor.addRow(new Object[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, Integer.valueOf(nR)});
            } else {
                for (String Le : strArr) {
                    long Le2 = C27902a.m44381Le(Le);
                    C9638aw.m17190ZK();
                    C7616ad mQ = C18628c.m29078XM().mo15763mQ(Le2);
                    if (mQ != null && ((int) mQ.ewQ) > 0) {
                        C9638aw.m17190ZK();
                        int nR2 = C18628c.m29083XR().mo15824nR(" and ( rconversation.username='" + mQ.field_username + "' );");
                        matrixCursor.addRow(new Object[]{Long.valueOf(Le2), Integer.valueOf(nR2)});
                    }
                }
            }
            mo61890vf(0);
            AppMethodBeat.m2505o(20352);
            return matrixCursor;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            mo61890vf(4);
            AppMethodBeat.m2505o(20352);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private Cursor m76396a(String[] strArr, String str, String str2) {
        Exception e;
        AppMethodBeat.m2504i(20353);
        C4990ab.m7416i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
        C4990ab.m7411d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", str, str2);
        MatrixCursor Kn;
        Cursor Kn2;
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "wrong args");
            mo61889dZ(3, 3701);
            Kn = C40420a.m69330Kn(3701);
            AppMethodBeat.m2505o(20353);
            return Kn;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "callSource == null");
            mo61889dZ(3, 3702);
            Kn2 = C40420a.m69330Kn(3702);
            AppMethodBeat.m2505o(20353);
            return Kn2;
        } else if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "countStr == null");
            mo61889dZ(3, 3703);
            Kn2 = C40420a.m69330Kn(3703);
            AppMethodBeat.m2505o(20353);
            return Kn2;
        } else {
            C6562ap aoO;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    C23512bz apZ = C6875b.brB().apZ(strArr[0]);
                    if (apZ == null || C5046bo.isNullOrNil(apZ.field_openId) || C5046bo.isNullOrNil(apZ.field_username)) {
                        C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
                        mo61889dZ(3, 3704);
                        Kn2 = C40420a.m69330Kn(3704);
                        AppMethodBeat.m2505o(20353);
                        return Kn2;
                    }
                    C9638aw.m17190ZK();
                    aoO = C18628c.m29078XM().aoO(apZ.field_username);
                } catch (Exception e2) {
                    e = e2;
                    Kn = null;
                    C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                    if (Kn != null) {
                        Kn.close();
                    }
                    mo61881T(3, 4, 12);
                    Kn2 = C40420a.m69330Kn(12);
                    AppMethodBeat.m2505o(20353);
                    return Kn2;
                }
            }
            long Le = C27902a.m44381Le(strArr[0]);
            C9638aw.m17190ZK();
            aoO = C18628c.m29078XM().mo15763mQ(Le);
            if (aoO == null || aoO.field_username == null || aoO.field_username.length() <= 0) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "contact is null");
                mo61889dZ(3, 3705);
                Kn2 = C40420a.m69330Kn(3705);
                AppMethodBeat.m2505o(20353);
                return Kn2;
            }
            boolean z2;
            Cursor cz;
            String Oj = aoO.mo16707Oj();
            if (C1855t.m3896kH(aoO.field_username)) {
                Oj = C1854s.m3866mJ(aoO.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                int i;
                try {
                    i = C5046bo.getInt(str2, 0);
                } catch (Exception e3) {
                    C4990ab.m7413e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", str2);
                    i = 0;
                }
                if (i <= 0 || i >= 15) {
                    C9638aw.m17190ZK();
                    cz = C18628c.m29080XO().mo15327cz(aoO.field_username, 15);
                } else {
                    C9638aw.m17190ZK();
                    cz = C18628c.m29080XO().mo15327cz(aoO.field_username, i);
                }
            } else {
                C9638aw.m17190ZK();
                cz = C18628c.m29080XO().mo15327cz(aoO.field_username, 3);
            }
            if (cz == null) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                mo61881T(3, 4, 3706);
                Kn2 = C40420a.m69330Kn(3706);
                AppMethodBeat.m2505o(20353);
                return Kn2;
            }
            Kn = new MatrixCursor(lQf);
            try {
                if (cz.getCount() <= 0 || !cz.moveToFirst()) {
                    cz.close();
                    mo61881T(2, 0, 1);
                    AppMethodBeat.m2505o(20353);
                    return Kn;
                }
                C7620bi c7620bi = new C7620bi();
                do {
                    c7620bi.mo8995d(cz);
                    m76399a(Kn, c7620bi, aoO, z2, Oj, z, strArr[0]);
                } while (cz.moveToNext());
                cz.close();
                mo61881T(2, 0, 1);
                AppMethodBeat.m2505o(20353);
                return Kn;
            } catch (Exception e4) {
                e = e4;
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (Kn != null) {
                }
                mo61881T(3, 4, 12);
                Kn2 = C40420a.m69330Kn(12);
                AppMethodBeat.m2505o(20353);
                return Kn2;
            }
        }
    }

    private Cursor brN() {
        AppMethodBeat.m2504i(20354);
        C4990ab.m7410d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
        MatrixCursor matrixCursor = new MatrixCursor(lQh);
        try {
            C9638aw.m17190ZK();
            Cursor bOE = C18628c.m29080XO().bOE();
            if (bOE != null) {
                if (bOE.moveToFirst()) {
                    do {
                        String string = bOE.getString(bOE.getColumnIndex("talker"));
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(string);
                        if (!C1855t.m3896kH(string)) {
                            int i;
                            if (C1855t.m3923nI(aoO.field_username) || C1855t.m3921nG(aoO.field_username) || C7616ad.m13547Mn(aoO.field_verifyFlag) || C1855t.m3956ny(aoO.field_username) || C1855t.m3957nz(aoO.field_username)) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i == 0) {
                                long j = (long) ((int) aoO.ewQ);
                                matrixCursor.addRow(new Object[]{C27902a.m44382ii(j), Integer.valueOf(bOE.getInt(bOE.getColumnIndex("unReadCount")))});
                            }
                        }
                    } while (bOE.moveToNext());
                }
                bOE.close();
            }
            mo61890vf(0);
            AppMethodBeat.m2505o(20354);
            return matrixCursor;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            mo61890vf(4);
            AppMethodBeat.m2505o(20354);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private Cursor m76400b(String[] strArr, String str) {
        Exception e;
        boolean z = true;
        AppMethodBeat.m2504i(20355);
        C4990ab.m7410d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20355);
            return null;
        }
        MatrixCursor matrixCursor;
        try {
            long Le = C27902a.m44381Le(strArr[0]);
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf(Le);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(jf.field_talker);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                mo61890vf(3);
                AppMethodBeat.m2505o(20355);
                return null;
            }
            boolean z2;
            String Oj = aoO.mo16707Oj();
            if (C1855t.m3896kH(aoO.field_username)) {
                Oj = C1854s.m3866mJ(aoO.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (str == null || !str.equalsIgnoreCase("openapi")) {
                z = false;
            }
            matrixCursor = new MatrixCursor(lQf);
            try {
                m76399a(matrixCursor, jf, aoO, z2, Oj, z, strArr[0]);
                mo61890vf(0);
                AppMethodBeat.m2505o(20355);
                return matrixCursor;
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (matrixCursor != null) {
                }
                mo61890vf(4);
                AppMethodBeat.m2505o(20355);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            mo61890vf(4);
            AppMethodBeat.m2505o(20355);
            return null;
        }
    }

    /* renamed from: w */
    private Cursor m76402w(String[] strArr) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(20356);
        C4990ab.m7410d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
        if (strArr == null || strArr.length < 2) {
            C4990ab.m7420w("MicroMsg.ExtControlProviderMsg", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20356);
        } else {
            try {
                final int intValue = Integer.valueOf(strArr[0]).intValue();
                final long Le = C27902a.m44381Le(strArr[1]);
                if (Le <= 0) {
                    mo61890vf(3);
                    AppMethodBeat.m2505o(20356);
                } else {
                    final C46484b c46484b = new C46484b();
                    final String[] strArr2 = strArr;
                    c46484b.mo74707b(4000, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(20348);
                            if (intValue == 1) {
                                C6875b.bry();
                                C7616ad ig = C6875b.m11368ig(Le);
                                if (ig == null || ((int) ig.ewQ) <= 0) {
                                    ExtControlProviderMsg.this.mo61890vf(3);
                                    c46484b.countDown();
                                    AppMethodBeat.m2505o(20348);
                                    return;
                                }
                                C37712fl c37712fl = new C37712fl();
                                c37712fl.czk.f2861op = 1;
                                c37712fl.czk.username = ig.field_username;
                                if (C4879a.xxA.mo10055m(c37712fl)) {
                                    ExtControlProviderMsg.this.lQl = new MatrixCursor(ExtControlProviderMsg.lQi);
                                    if (ig == null || ((int) ig.ewQ) <= 0 || !c37712fl.czl.cvi) {
                                        ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(2), AppEventsConstants.EVENT_PARAM_VALUE_NO});
                                        ExtControlProviderMsg.this.mo61890vf(3);
                                    } else {
                                        ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(1), AppEventsConstants.EVENT_PARAM_VALUE_NO});
                                        ExtControlProviderMsg.this.mo61890vf(0);
                                    }
                                    C4990ab.m7411d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", Boolean.valueOf(c37712fl.czl.cvi), c37712fl.czl.fileName);
                                } else {
                                    ExtControlProviderMsg.this.mo61890vf(4);
                                    c46484b.countDown();
                                    AppMethodBeat.m2505o(20348);
                                    return;
                                }
                            } else if (intValue == 2) {
                                C37712fl c37712fl2 = new C37712fl();
                                c37712fl2.czk.f2861op = 2;
                                if (C4879a.xxA.mo10055m(c37712fl2)) {
                                    String str = c37712fl2.czl.fileName;
                                    ExtControlProviderMsg.this.lQl = new MatrixCursor(ExtControlProviderMsg.lQi);
                                    C26139fr c26139fr = new C26139fr();
                                    c26139fr.czG.fileName = str;
                                    if (C4879a.xxA.mo10055m(c26139fr)) {
                                        C4990ab.m7411d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", Long.valueOf(c26139fr.czH.cvx));
                                        if (c26139fr.czH.cvx > 0) {
                                            try {
                                                if (!c37712fl2.czl.cvi) {
                                                    ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(4), C27902a.m44382ii(r2)});
                                                    ExtControlProviderMsg.this.mo61890vf(4);
                                                } else if (C4996ah.getContext() == null || !C5023at.isConnected(C4996ah.getContext())) {
                                                    ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(6), C27902a.m44382ii(r2)});
                                                    ExtControlProviderMsg.this.mo61890vf(4);
                                                } else {
                                                    ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(1), C27902a.m44382ii(r2)});
                                                    ExtControlProviderMsg.this.mo61890vf(0);
                                                }
                                            } catch (Exception e) {
                                                C4990ab.m7420w("MicroMsg.ExtControlProviderMsg", e.getMessage());
                                                C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                                                ExtControlProviderMsg.this.mo61890vf(4);
                                            }
                                        } else {
                                            ExtControlProviderMsg.this.mo61890vf(3);
                                        }
                                    } else {
                                        ExtControlProviderMsg.this.mo61890vf(4);
                                        ExtControlProviderMsg.this.lQl.close();
                                        c46484b.countDown();
                                        AppMethodBeat.m2505o(20348);
                                        return;
                                    }
                                }
                                ExtControlProviderMsg.this.mo61890vf(4);
                                c46484b.countDown();
                                AppMethodBeat.m2505o(20348);
                                return;
                            }
                            c46484b.countDown();
                            AppMethodBeat.m2505o(20348);
                        }
                    });
                    cursor = this.lQl;
                    AppMethodBeat.m2505o(20356);
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (this.lQl != null) {
                    this.lQl.close();
                }
                mo61890vf(4);
                AppMethodBeat.m2505o(20356);
            }
        }
        return cursor;
    }

    /* renamed from: x */
    private Cursor m76403x(String[] strArr) {
        MatrixCursor matrixCursor;
        Exception e;
        AppMethodBeat.m2504i(20357);
        C4990ab.m7410d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
        if (strArr == null || strArr.length < 2) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20357);
            return null;
        }
        matrixCursor = null;
        try {
            int intValue = Integer.valueOf(strArr[0]).intValue();
            long Le = C27902a.m44381Le(strArr[1]);
            if (Le <= 0) {
                mo61890vf(3);
                AppMethodBeat.m2505o(20357);
                return null;
            } else if (intValue == 3) {
                Cursor matrixCursor2 = new MatrixCursor(lQj);
                try {
                    C41995fs c41995fs = new C41995fs();
                    c41995fs.czI.cvx = Le;
                    C4879a.xxA.mo10055m(c41995fs);
                    if (c41995fs.czJ.fileName == null || c41995fs.czJ.fileName.length() <= 0) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        mo61890vf(4);
                        AppMethodBeat.m2505o(20357);
                        return matrixCursor2;
                    }
                    C32557fk c32557fk = new C32557fk();
                    c32557fk.czf.f1230op = 1;
                    c32557fk.czf.fileName = c41995fs.czJ.fileName;
                    if (C4879a.xxA.mo10055m(c32557fk)) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(1)});
                        mo61890vf(0);
                    } else {
                        C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "play failed");
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        mo61890vf(4);
                    }
                    C6875b.bry();
                    C6875b.m11369ih(Le);
                    AppMethodBeat.m2505o(20357);
                    return matrixCursor2;
                } catch (Exception e2) {
                    e = e2;
                    matrixCursor = matrixCursor2;
                }
            } else {
                if (intValue == 4) {
                    C32557fk c32557fk2 = new C32557fk();
                    c32557fk2.czf.f1230op = 2;
                    if (C4879a.xxA.mo10055m(c32557fk2)) {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderMsg", "stop last playing");
                        mo61890vf(0);
                    } else {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
                        mo61890vf(4);
                    }
                }
                AppMethodBeat.m2505o(20357);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
        }
        C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
        C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
        if (matrixCursor != null) {
            matrixCursor.close();
        }
        mo61890vf(4);
        AppMethodBeat.m2505o(20357);
        return null;
    }

    /* renamed from: y */
    private Cursor m76404y(String[] strArr) {
        Cursor Kn;
        AppMethodBeat.m2504i(20358);
        C4990ab.m7416i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "wrong args");
            mo61889dZ(3, 3801);
            MatrixCursor Kn2 = C40420a.m69330Kn(3801);
            AppMethodBeat.m2505o(20358);
            return Kn2;
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i] == null || strArr[i].length() <= 0) {
                    C4990ab.m7420w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = ".concat(String.valueOf(i)));
                } else {
                    long Le = C27902a.m44381Le(strArr[i]);
                    C6875b.bry();
                    C6875b.m11369ih(Le);
                }
                i++;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                mo61889dZ(4, 12);
                Kn = C40420a.m69330Kn(12);
                AppMethodBeat.m2505o(20358);
                return Kn;
            }
        }
        mo61889dZ(0, 1);
        Kn = C40420a.m69330Kn(1);
        AppMethodBeat.m2505o(20358);
        return Kn;
    }

    /* renamed from: z */
    private Cursor m76405z(final String[] strArr) {
        AppMethodBeat.m2504i(20359);
        C4990ab.m7410d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20359);
            return null;
        }
        try {
            long Le = C27902a.m44381Le(strArr[0]);
            if (Le <= 0) {
                mo61890vf(3);
                AppMethodBeat.m2505o(20359);
                return null;
            }
            C6875b.bry();
            final C7616ad ig = C6875b.m11368ig(Le);
            if (ig == null || ((int) ig.ewQ) <= 0) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
                mo61890vf(3);
                AppMethodBeat.m2505o(20359);
                return null;
            }
            this.lQl = new MatrixCursor(lQk);
            final C46484b c46484b = new C46484b();
            c46484b.mo74707b(15000, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(20350);
                    C9336fi c9336fi = new C9336fi();
                    c9336fi.cza.toUserName = ig.field_username;
                    c9336fi.cza.content = strArr[1];
                    c9336fi.cza.type = C1855t.m3925nK(ig.field_username);
                    c9336fi.cza.flags = 0;
                    if (C4879a.xxA.mo10055m(c9336fi)) {
                        C1207m c1207m = c9336fi.czb.czc;
                        try {
                            final String ii = C27902a.m44382ii(c9336fi.czb.cvx);
                            C9638aw.m17182Rg().mo14539a((int) C19482c.CTRL_INDEX, new C1202f() {
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                    AppMethodBeat.m2504i(20349);
                                    C4990ab.m7411d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
                                    if (c1207m == null) {
                                        C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "scene == null");
                                        C9638aw.m17182Rg().mo14546b((int) C19482c.CTRL_INDEX, (C1202f) this);
                                        ExtControlProviderMsg.this.mo61890vf(4);
                                        c46484b.countDown();
                                        AppMethodBeat.m2505o(20349);
                                        return;
                                    }
                                    switch (c1207m.getType()) {
                                        case C19482c.CTRL_INDEX /*522*/:
                                            if (i != 0 || i2 != 0) {
                                                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + i + ", errCode = " + i2);
                                                ExtControlProviderMsg.this.lQl.addRow(new Object[]{ii, Integer.valueOf(2)});
                                                ExtControlProviderMsg.this.mo61890vf(4);
                                                break;
                                            }
                                            C4990ab.m7410d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                                            ExtControlProviderMsg.this.lQl.addRow(new Object[]{ii, Integer.valueOf(1)});
                                            break;
                                        default:
                                            ExtControlProviderMsg.this.mo61890vf(0);
                                            break;
                                    }
                                    c46484b.countDown();
                                    C9638aw.m17182Rg().mo14546b((int) C19482c.CTRL_INDEX, (C1202f) this);
                                    AppMethodBeat.m2505o(20349);
                                }
                            });
                            C9638aw.m17182Rg().mo14541a(c1207m, 0);
                            AppMethodBeat.m2505o(20350);
                            return;
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                            ExtControlProviderMsg.this.mo61890vf(4);
                            c46484b.countDown();
                            AppMethodBeat.m2505o(20350);
                            return;
                        }
                    }
                    ExtControlProviderMsg.this.mo61890vf(4);
                    c46484b.countDown();
                    AppMethodBeat.m2505o(20350);
                }
            });
            Cursor cursor = this.lQl;
            AppMethodBeat.m2505o(20359);
            return cursor;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (this.lQl != null) {
                this.lQl.close();
            }
            mo61890vf(4);
            AppMethodBeat.m2505o(20359);
            return null;
        }
    }

    /* renamed from: a */
    private void m76399a(MatrixCursor matrixCursor, C7620bi c7620bi, C7616ad c7616ad, boolean z, String str, boolean z2, String str2) {
        AppMethodBeat.m2504i(20360);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(20360);
        } else if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7410d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
            AppMethodBeat.m2505o(20360);
        } else if (c7620bi.getType() == 9999 || c7620bi.getType() == Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.m2505o(20360);
        } else {
            String str3 = "";
            String str4 = "";
            if (z) {
                int ox = C1829bf.m3761ox(c7620bi.field_content);
                if (ox != -1 && c7620bi.field_content.length() > ox) {
                    String trim = c7620bi.field_content.substring(0, ox).trim();
                    if (trim != null && trim.length() > 0 && c7620bi.field_content.length() >= ox + 2) {
                        str3 = C1854s.m3866mJ(trim);
                        str4 = c7620bi.field_content.substring(ox + 2);
                    }
                }
            }
            String str5 = "";
            int V = C11771b.m19605V(c7620bi);
            if (V == 1) {
                if (z) {
                    str3 = str3 + "!]" + str4;
                } else {
                    str3 = c7620bi.field_content;
                }
            } else if (V == 2) {
                C32849p mv = C26500m.ama().mo33985mv((int) c7620bi.field_msgId);
                if (mv == null || mv.fileName == null) {
                    str4 = str5;
                } else {
                    str4 = C32850q.getFullPath(mv.fileName);
                    C4990ab.m7411d("MicroMsg.ExtControlProviderMsg", "voice file = %s", str4);
                }
                str3 = str4;
            } else if (!z) {
                if (this.lQe != null) {
                    str3 = this.lQe.getString(C25738R.string.bj9);
                } else {
                    str3 = "";
                }
            }
            if (!z2) {
                str2 = C27902a.m44382ii((long) ((int) c7616ad.ewQ));
            }
            try {
                if (C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7420w("MicroMsg.ExtControlProviderMsg", "userId is null");
                    AppMethodBeat.m2505o(20360);
                    return;
                }
                int i;
                Object[] objArr = new Object[8];
                objArr[0] = C27902a.m44382ii(c7620bi.field_msgId);
                objArr[1] = str2;
                objArr[2] = str;
                objArr[3] = Integer.valueOf(c7620bi.field_isSend == 0 ? 1 : 2);
                objArr[4] = Integer.valueOf(V);
                objArr[5] = str3;
                if (c7620bi.field_status == 4) {
                    i = 1;
                } else {
                    i = 2;
                }
                objArr[6] = Integer.valueOf(i);
                objArr[7] = Long.valueOf(c7620bi.field_createTime);
                matrixCursor.addRow(objArr);
                AppMethodBeat.m2505o(20360);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                AppMethodBeat.m2505o(20360);
            }
        }
    }
}
