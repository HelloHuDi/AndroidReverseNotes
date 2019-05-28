package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bz;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderMsg extends ExtContentProviderBase {
    private static final UriMatcher lQc;
    private static final String[] lQf = new String[]{"msgId", "fromUserId", "fromUserNickName", "msgType", DownloadInfo.CONTENTTYPE, b.CONTENT, "status", "createTime"};
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
        AppMethodBeat.i(20361);
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
        AppMethodBeat.o(20361);
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
        AppMethodBeat.i(20351);
        ab.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.lQd);
        if (this.lQd) {
            a(uri, this.lQe, this.lPO, this.lPN);
            if (bo.isNullOrNil(this.lPW)) {
                ab.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
                dZ(3, 7);
                MatrixCursor Kn2 = a.Kn(7);
                AppMethodBeat.o(20351);
                return Kn2;
            } else if (bo.isNullOrNil(brL())) {
                ab.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
                dZ(3, 6);
                Kn = a.Kn(6);
                AppMethodBeat.o(20351);
                return Kn;
            } else {
                int brM = brM();
                if (brM != 1) {
                    ab.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(brM)));
                    dZ(2, brM);
                    Kn = a.Kn(brM);
                    AppMethodBeat.o(20351);
                    return Kn;
                }
            }
        }
        this.lQe = getContext();
        a(uri, this.lQe, lQc);
        if (uri == null) {
            vf(3);
            AppMethodBeat.o(20351);
            return null;
        } else if (bo.isNullOrNil(this.lPW) || bo.isNullOrNil(brL())) {
            vf(3);
            AppMethodBeat.o(20351);
            return null;
        } else if (!aVl()) {
            vf(1);
            Kn = this.jDN;
            AppMethodBeat.o(20351);
            return Kn;
        } else if (!dJ(this.lQe)) {
            ab.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
            vf(2);
            AppMethodBeat.o(20351);
            return null;
        }
        String nullAsNil = bo.nullAsNil(uri.getQueryParameter("source"));
        String nullAsNil2 = bo.nullAsNil(uri.getQueryParameter("count"));
        if (!this.lQd) {
            this.lPO = lQc.match(uri);
        }
        switch (this.lPO) {
            case 7:
                Kn = b(strArr2, nullAsNil);
                AppMethodBeat.o(20351);
                return Kn;
            case 8:
                Kn = v(strArr2);
                AppMethodBeat.o(20351);
                return Kn;
            case 9:
                Kn = a(strArr2, nullAsNil, nullAsNil2);
                AppMethodBeat.o(20351);
                return Kn;
            case 10:
                Kn = brN();
                AppMethodBeat.o(20351);
                return Kn;
            case 11:
                Kn = w(strArr2);
                AppMethodBeat.o(20351);
                return Kn;
            case 12:
                Kn = x(strArr2);
                AppMethodBeat.o(20351);
                return Kn;
            case 13:
                Kn = y(strArr2);
                AppMethodBeat.o(20351);
                return Kn;
            case 14:
                Kn = z(strArr2);
                AppMethodBeat.o(20351);
                return Kn;
            default:
                dZ(3, 15);
                AppMethodBeat.o(20351);
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

    private Cursor v(String[] strArr) {
        AppMethodBeat.i(20352);
        ab.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
        if (strArr == null || strArr.length <= 0) {
            ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            vf(3);
            AppMethodBeat.o(20352);
            return null;
        }
        Cursor matrixCursor = new MatrixCursor(lQg);
        try {
            int nR;
            if ("*".equals(strArr[0])) {
                aw.ZK();
                nR = c.XR().nR("");
                matrixCursor.addRow(new Object[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, Integer.valueOf(nR)});
            } else {
                for (String Le : strArr) {
                    long Le2 = com.tencent.mm.plugin.ext.a.a.Le(Le);
                    aw.ZK();
                    ad mQ = c.XM().mQ(Le2);
                    if (mQ != null && ((int) mQ.ewQ) > 0) {
                        aw.ZK();
                        int nR2 = c.XR().nR(" and ( rconversation.username='" + mQ.field_username + "' );");
                        matrixCursor.addRow(new Object[]{Long.valueOf(Le2), Integer.valueOf(nR2)});
                    }
                }
            }
            vf(0);
            AppMethodBeat.o(20352);
            return matrixCursor;
        } catch (Exception e) {
            ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            vf(4);
            AppMethodBeat.o(20352);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Cursor a(String[] strArr, String str, String str2) {
        Exception e;
        AppMethodBeat.i(20353);
        ab.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
        ab.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", str, str2);
        MatrixCursor Kn;
        Cursor Kn2;
        if (strArr == null || strArr.length <= 0) {
            ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            dZ(3, 3701);
            Kn = a.Kn(3701);
            AppMethodBeat.o(20353);
            return Kn;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
            dZ(3, 3702);
            Kn2 = a.Kn(3702);
            AppMethodBeat.o(20353);
            return Kn2;
        } else if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
            dZ(3, 3703);
            Kn2 = a.Kn(3703);
            AppMethodBeat.o(20353);
            return Kn2;
        } else {
            ap aoO;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bz apZ = com.tencent.mm.plugin.ext.b.brB().apZ(strArr[0]);
                    if (apZ == null || bo.isNullOrNil(apZ.field_openId) || bo.isNullOrNil(apZ.field_username)) {
                        ab.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
                        dZ(3, 3704);
                        Kn2 = a.Kn(3704);
                        AppMethodBeat.o(20353);
                        return Kn2;
                    }
                    aw.ZK();
                    aoO = c.XM().aoO(apZ.field_username);
                } catch (Exception e2) {
                    e = e2;
                    Kn = null;
                    ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                    if (Kn != null) {
                        Kn.close();
                    }
                    T(3, 4, 12);
                    Kn2 = a.Kn(12);
                    AppMethodBeat.o(20353);
                    return Kn2;
                }
            }
            long Le = com.tencent.mm.plugin.ext.a.a.Le(strArr[0]);
            aw.ZK();
            aoO = c.XM().mQ(Le);
            if (aoO == null || aoO.field_username == null || aoO.field_username.length() <= 0) {
                ab.e("MicroMsg.ExtControlProviderMsg", "contact is null");
                dZ(3, 3705);
                Kn2 = a.Kn(3705);
                AppMethodBeat.o(20353);
                return Kn2;
            }
            boolean z2;
            Cursor cz;
            String Oj = aoO.Oj();
            if (t.kH(aoO.field_username)) {
                Oj = s.mJ(aoO.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                int i;
                try {
                    i = bo.getInt(str2, 0);
                } catch (Exception e3) {
                    ab.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", str2);
                    i = 0;
                }
                if (i <= 0 || i >= 15) {
                    aw.ZK();
                    cz = c.XO().cz(aoO.field_username, 15);
                } else {
                    aw.ZK();
                    cz = c.XO().cz(aoO.field_username, i);
                }
            } else {
                aw.ZK();
                cz = c.XO().cz(aoO.field_username, 3);
            }
            if (cz == null) {
                ab.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                T(3, 4, 3706);
                Kn2 = a.Kn(3706);
                AppMethodBeat.o(20353);
                return Kn2;
            }
            Kn = new MatrixCursor(lQf);
            try {
                if (cz.getCount() <= 0 || !cz.moveToFirst()) {
                    cz.close();
                    T(2, 0, 1);
                    AppMethodBeat.o(20353);
                    return Kn;
                }
                bi biVar = new bi();
                do {
                    biVar.d(cz);
                    a(Kn, biVar, aoO, z2, Oj, z, strArr[0]);
                } while (cz.moveToNext());
                cz.close();
                T(2, 0, 1);
                AppMethodBeat.o(20353);
                return Kn;
            } catch (Exception e4) {
                e = e4;
                ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (Kn != null) {
                }
                T(3, 4, 12);
                Kn2 = a.Kn(12);
                AppMethodBeat.o(20353);
                return Kn2;
            }
        }
    }

    private Cursor brN() {
        AppMethodBeat.i(20354);
        ab.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
        MatrixCursor matrixCursor = new MatrixCursor(lQh);
        try {
            aw.ZK();
            Cursor bOE = c.XO().bOE();
            if (bOE != null) {
                if (bOE.moveToFirst()) {
                    do {
                        String string = bOE.getString(bOE.getColumnIndex("talker"));
                        aw.ZK();
                        ad aoO = c.XM().aoO(string);
                        if (!t.kH(string)) {
                            int i;
                            if (t.nI(aoO.field_username) || t.nG(aoO.field_username) || ad.Mn(aoO.field_verifyFlag) || t.ny(aoO.field_username) || t.nz(aoO.field_username)) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i == 0) {
                                long j = (long) ((int) aoO.ewQ);
                                matrixCursor.addRow(new Object[]{com.tencent.mm.plugin.ext.a.a.ii(j), Integer.valueOf(bOE.getInt(bOE.getColumnIndex("unReadCount")))});
                            }
                        }
                    } while (bOE.moveToNext());
                }
                bOE.close();
            }
            vf(0);
            AppMethodBeat.o(20354);
            return matrixCursor;
        } catch (Exception e) {
            ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            vf(4);
            AppMethodBeat.o(20354);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Cursor b(String[] strArr, String str) {
        Exception e;
        boolean z = true;
        AppMethodBeat.i(20355);
        ab.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
        if (strArr == null || strArr.length <= 0) {
            ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            vf(3);
            AppMethodBeat.o(20355);
            return null;
        }
        MatrixCursor matrixCursor;
        try {
            long Le = com.tencent.mm.plugin.ext.a.a.Le(strArr[0]);
            aw.ZK();
            bi jf = c.XO().jf(Le);
            aw.ZK();
            ad aoO = c.XM().aoO(jf.field_talker);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                vf(3);
                AppMethodBeat.o(20355);
                return null;
            }
            boolean z2;
            String Oj = aoO.Oj();
            if (t.kH(aoO.field_username)) {
                Oj = s.mJ(aoO.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (str == null || !str.equalsIgnoreCase("openapi")) {
                z = false;
            }
            matrixCursor = new MatrixCursor(lQf);
            try {
                a(matrixCursor, jf, aoO, z2, Oj, z, strArr[0]);
                vf(0);
                AppMethodBeat.o(20355);
                return matrixCursor;
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (matrixCursor != null) {
                }
                vf(4);
                AppMethodBeat.o(20355);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            vf(4);
            AppMethodBeat.o(20355);
            return null;
        }
    }

    private Cursor w(String[] strArr) {
        Cursor cursor = null;
        AppMethodBeat.i(20356);
        ab.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
        if (strArr == null || strArr.length < 2) {
            ab.w("MicroMsg.ExtControlProviderMsg", "wrong args");
            vf(3);
            AppMethodBeat.o(20356);
        } else {
            try {
                final int intValue = Integer.valueOf(strArr[0]).intValue();
                final long Le = com.tencent.mm.plugin.ext.a.a.Le(strArr[1]);
                if (Le <= 0) {
                    vf(3);
                    AppMethodBeat.o(20356);
                } else {
                    final com.tencent.mm.pluginsdk.d.a.b bVar = new com.tencent.mm.pluginsdk.d.a.b();
                    final String[] strArr2 = strArr;
                    bVar.b(4000, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(20348);
                            if (intValue == 1) {
                                com.tencent.mm.plugin.ext.b.bry();
                                ad ig = com.tencent.mm.plugin.ext.b.ig(Le);
                                if (ig == null || ((int) ig.ewQ) <= 0) {
                                    ExtControlProviderMsg.this.vf(3);
                                    bVar.countDown();
                                    AppMethodBeat.o(20348);
                                    return;
                                }
                                fl flVar = new fl();
                                flVar.czk.op = 1;
                                flVar.czk.username = ig.field_username;
                                if (com.tencent.mm.sdk.b.a.xxA.m(flVar)) {
                                    ExtControlProviderMsg.this.lQl = new MatrixCursor(ExtControlProviderMsg.lQi);
                                    if (ig == null || ((int) ig.ewQ) <= 0 || !flVar.czl.cvi) {
                                        ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(2), AppEventsConstants.EVENT_PARAM_VALUE_NO});
                                        ExtControlProviderMsg.this.vf(3);
                                    } else {
                                        ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(1), AppEventsConstants.EVENT_PARAM_VALUE_NO});
                                        ExtControlProviderMsg.this.vf(0);
                                    }
                                    ab.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", Boolean.valueOf(flVar.czl.cvi), flVar.czl.fileName);
                                } else {
                                    ExtControlProviderMsg.this.vf(4);
                                    bVar.countDown();
                                    AppMethodBeat.o(20348);
                                    return;
                                }
                            } else if (intValue == 2) {
                                fl flVar2 = new fl();
                                flVar2.czk.op = 2;
                                if (com.tencent.mm.sdk.b.a.xxA.m(flVar2)) {
                                    String str = flVar2.czl.fileName;
                                    ExtControlProviderMsg.this.lQl = new MatrixCursor(ExtControlProviderMsg.lQi);
                                    fr frVar = new fr();
                                    frVar.czG.fileName = str;
                                    if (com.tencent.mm.sdk.b.a.xxA.m(frVar)) {
                                        ab.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", Long.valueOf(frVar.czH.cvx));
                                        if (frVar.czH.cvx > 0) {
                                            try {
                                                if (!flVar2.czl.cvi) {
                                                    ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(4), com.tencent.mm.plugin.ext.a.a.ii(r2)});
                                                    ExtControlProviderMsg.this.vf(4);
                                                } else if (ah.getContext() == null || !at.isConnected(ah.getContext())) {
                                                    ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(6), com.tencent.mm.plugin.ext.a.a.ii(r2)});
                                                    ExtControlProviderMsg.this.vf(4);
                                                } else {
                                                    ExtControlProviderMsg.this.lQl.addRow(new Object[]{strArr2[1], Integer.valueOf(1), com.tencent.mm.plugin.ext.a.a.ii(r2)});
                                                    ExtControlProviderMsg.this.vf(0);
                                                }
                                            } catch (Exception e) {
                                                ab.w("MicroMsg.ExtControlProviderMsg", e.getMessage());
                                                ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                                                ExtControlProviderMsg.this.vf(4);
                                            }
                                        } else {
                                            ExtControlProviderMsg.this.vf(3);
                                        }
                                    } else {
                                        ExtControlProviderMsg.this.vf(4);
                                        ExtControlProviderMsg.this.lQl.close();
                                        bVar.countDown();
                                        AppMethodBeat.o(20348);
                                        return;
                                    }
                                }
                                ExtControlProviderMsg.this.vf(4);
                                bVar.countDown();
                                AppMethodBeat.o(20348);
                                return;
                            }
                            bVar.countDown();
                            AppMethodBeat.o(20348);
                        }
                    });
                    cursor = this.lQl;
                    AppMethodBeat.o(20356);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (this.lQl != null) {
                    this.lQl.close();
                }
                vf(4);
                AppMethodBeat.o(20356);
            }
        }
        return cursor;
    }

    private Cursor x(String[] strArr) {
        MatrixCursor matrixCursor;
        Exception e;
        AppMethodBeat.i(20357);
        ab.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
        if (strArr == null || strArr.length < 2) {
            ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            vf(3);
            AppMethodBeat.o(20357);
            return null;
        }
        matrixCursor = null;
        try {
            int intValue = Integer.valueOf(strArr[0]).intValue();
            long Le = com.tencent.mm.plugin.ext.a.a.Le(strArr[1]);
            if (Le <= 0) {
                vf(3);
                AppMethodBeat.o(20357);
                return null;
            } else if (intValue == 3) {
                Cursor matrixCursor2 = new MatrixCursor(lQj);
                try {
                    fs fsVar = new fs();
                    fsVar.czI.cvx = Le;
                    com.tencent.mm.sdk.b.a.xxA.m(fsVar);
                    if (fsVar.czJ.fileName == null || fsVar.czJ.fileName.length() <= 0) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        vf(4);
                        AppMethodBeat.o(20357);
                        return matrixCursor2;
                    }
                    fk fkVar = new fk();
                    fkVar.czf.op = 1;
                    fkVar.czf.fileName = fsVar.czJ.fileName;
                    if (com.tencent.mm.sdk.b.a.xxA.m(fkVar)) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(1)});
                        vf(0);
                    } else {
                        ab.e("MicroMsg.ExtControlProviderMsg", "play failed");
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        vf(4);
                    }
                    com.tencent.mm.plugin.ext.b.bry();
                    com.tencent.mm.plugin.ext.b.ih(Le);
                    AppMethodBeat.o(20357);
                    return matrixCursor2;
                } catch (Exception e2) {
                    e = e2;
                    matrixCursor = matrixCursor2;
                }
            } else {
                if (intValue == 4) {
                    fk fkVar2 = new fk();
                    fkVar2.czf.op = 2;
                    if (com.tencent.mm.sdk.b.a.xxA.m(fkVar2)) {
                        ab.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
                        vf(0);
                    } else {
                        ab.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
                        vf(4);
                    }
                }
                AppMethodBeat.o(20357);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
        }
        ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
        if (matrixCursor != null) {
            matrixCursor.close();
        }
        vf(4);
        AppMethodBeat.o(20357);
        return null;
    }

    private Cursor y(String[] strArr) {
        Cursor Kn;
        AppMethodBeat.i(20358);
        ab.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
        if (strArr == null || strArr.length <= 0) {
            ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            dZ(3, 3801);
            MatrixCursor Kn2 = a.Kn(3801);
            AppMethodBeat.o(20358);
            return Kn2;
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i] == null || strArr[i].length() <= 0) {
                    ab.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = ".concat(String.valueOf(i)));
                } else {
                    long Le = com.tencent.mm.plugin.ext.a.a.Le(strArr[i]);
                    com.tencent.mm.plugin.ext.b.bry();
                    com.tencent.mm.plugin.ext.b.ih(Le);
                }
                i++;
            } catch (Exception e) {
                ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                dZ(4, 12);
                Kn = a.Kn(12);
                AppMethodBeat.o(20358);
                return Kn;
            }
        }
        dZ(0, 1);
        Kn = a.Kn(1);
        AppMethodBeat.o(20358);
        return Kn;
    }

    private Cursor z(final String[] strArr) {
        AppMethodBeat.i(20359);
        ab.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
        if (strArr == null || strArr.length <= 0) {
            ab.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            vf(3);
            AppMethodBeat.o(20359);
            return null;
        }
        try {
            long Le = com.tencent.mm.plugin.ext.a.a.Le(strArr[0]);
            if (Le <= 0) {
                vf(3);
                AppMethodBeat.o(20359);
                return null;
            }
            com.tencent.mm.plugin.ext.b.bry();
            final ad ig = com.tencent.mm.plugin.ext.b.ig(Le);
            if (ig == null || ((int) ig.ewQ) <= 0) {
                ab.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
                vf(3);
                AppMethodBeat.o(20359);
                return null;
            }
            this.lQl = new MatrixCursor(lQk);
            final com.tencent.mm.pluginsdk.d.a.b bVar = new com.tencent.mm.pluginsdk.d.a.b();
            bVar.b(15000, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20350);
                    fi fiVar = new fi();
                    fiVar.cza.toUserName = ig.field_username;
                    fiVar.cza.content = strArr[1];
                    fiVar.cza.type = t.nK(ig.field_username);
                    fiVar.cza.flags = 0;
                    if (com.tencent.mm.sdk.b.a.xxA.m(fiVar)) {
                        m mVar = fiVar.czb.czc;
                        try {
                            final String ii = com.tencent.mm.plugin.ext.a.a.ii(fiVar.czb.cvx);
                            aw.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.storage.c.CTRL_INDEX, new f() {
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                    AppMethodBeat.i(20349);
                                    ab.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
                                    if (mVar == null) {
                                        ab.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                                        aw.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.storage.c.CTRL_INDEX, (f) this);
                                        ExtControlProviderMsg.this.vf(4);
                                        bVar.countDown();
                                        AppMethodBeat.o(20349);
                                        return;
                                    }
                                    switch (mVar.getType()) {
                                        case com.tencent.mm.plugin.appbrand.jsapi.storage.c.CTRL_INDEX /*522*/:
                                            if (i != 0 || i2 != 0) {
                                                ab.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + i + ", errCode = " + i2);
                                                ExtControlProviderMsg.this.lQl.addRow(new Object[]{ii, Integer.valueOf(2)});
                                                ExtControlProviderMsg.this.vf(4);
                                                break;
                                            }
                                            ab.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                                            ExtControlProviderMsg.this.lQl.addRow(new Object[]{ii, Integer.valueOf(1)});
                                            break;
                                        default:
                                            ExtControlProviderMsg.this.vf(0);
                                            break;
                                    }
                                    bVar.countDown();
                                    aw.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.storage.c.CTRL_INDEX, (f) this);
                                    AppMethodBeat.o(20349);
                                }
                            });
                            aw.Rg().a(mVar, 0);
                            AppMethodBeat.o(20350);
                            return;
                        } catch (Exception e) {
                            ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                            ExtControlProviderMsg.this.vf(4);
                            bVar.countDown();
                            AppMethodBeat.o(20350);
                            return;
                        }
                    }
                    ExtControlProviderMsg.this.vf(4);
                    bVar.countDown();
                    AppMethodBeat.o(20350);
                }
            });
            Cursor cursor = this.lQl;
            AppMethodBeat.o(20359);
            return cursor;
        } catch (Exception e) {
            ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (this.lQl != null) {
                this.lQl.close();
            }
            vf(4);
            AppMethodBeat.o(20359);
            return null;
        }
    }

    private void a(MatrixCursor matrixCursor, bi biVar, ad adVar, boolean z, String str, boolean z2, String str2) {
        AppMethodBeat.i(20360);
        if (biVar == null) {
            AppMethodBeat.o(20360);
        } else if (bo.isNullOrNil(str2)) {
            ab.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
            AppMethodBeat.o(20360);
        } else if (biVar.getType() == 9999 || biVar.getType() == Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.o(20360);
        } else {
            String str3 = "";
            String str4 = "";
            if (z) {
                int ox = bf.ox(biVar.field_content);
                if (ox != -1 && biVar.field_content.length() > ox) {
                    String trim = biVar.field_content.substring(0, ox).trim();
                    if (trim != null && trim.length() > 0 && biVar.field_content.length() >= ox + 2) {
                        str3 = s.mJ(trim);
                        str4 = biVar.field_content.substring(ox + 2);
                    }
                }
            }
            String str5 = "";
            int V = com.tencent.mm.plugin.ext.b.b.V(biVar);
            if (V == 1) {
                if (z) {
                    str3 = str3 + "!]" + str4;
                } else {
                    str3 = biVar.field_content;
                }
            } else if (V == 2) {
                p mv = com.tencent.mm.modelvoice.m.ama().mv((int) biVar.field_msgId);
                if (mv == null || mv.fileName == null) {
                    str4 = str5;
                } else {
                    str4 = q.getFullPath(mv.fileName);
                    ab.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", str4);
                }
                str3 = str4;
            } else if (!z) {
                if (this.lQe != null) {
                    str3 = this.lQe.getString(R.string.bj9);
                } else {
                    str3 = "";
                }
            }
            if (!z2) {
                str2 = com.tencent.mm.plugin.ext.a.a.ii((long) ((int) adVar.ewQ));
            }
            try {
                if (bo.isNullOrNil(str2)) {
                    ab.w("MicroMsg.ExtControlProviderMsg", "userId is null");
                    AppMethodBeat.o(20360);
                    return;
                }
                int i;
                Object[] objArr = new Object[8];
                objArr[0] = com.tencent.mm.plugin.ext.a.a.ii(biVar.field_msgId);
                objArr[1] = str2;
                objArr[2] = str;
                objArr[3] = Integer.valueOf(biVar.field_isSend == 0 ? 1 : 2);
                objArr[4] = Integer.valueOf(V);
                objArr[5] = str3;
                if (biVar.field_status == 4) {
                    i = 1;
                } else {
                    i = 2;
                }
                objArr[6] = Integer.valueOf(i);
                objArr[7] = Long.valueOf(biVar.field_createTime);
                matrixCursor.addRow(objArr);
                AppMethodBeat.o(20360);
            } catch (Exception e) {
                ab.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                AppMethodBeat.o(20360);
            }
        }
    }
}
