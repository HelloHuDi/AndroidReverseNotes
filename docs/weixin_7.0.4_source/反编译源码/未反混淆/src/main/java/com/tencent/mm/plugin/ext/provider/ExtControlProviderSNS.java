package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderSNS extends ExtContentProviderBase {
    private static boolean eBB = false;
    private static ap lQA = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(20377);
            ExtControlProviderSNS.eBB = false;
            AppMethodBeat.o(20377);
            return false;
        }
    }, false);
    private static final String[] lQC = new String[]{"feedId", "desc", "url", "nickname", "avatar", Param.TIMESTAMP, "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight"};
    private static final UriMatcher lQc;
    private boolean czq = false;
    private boolean czr = false;
    private int czs = 0;
    private String lQD = "";

    static {
        AppMethodBeat.i(20384);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
        AppMethodBeat.o(20384);
    }

    private static void dJ(boolean z) {
        AppMethodBeat.i(20380);
        if (z) {
            eBB = true;
            lQA.ae(15000, 15000);
            AppMethodBeat.o(20380);
            return;
        }
        lQA.ae(0, 0);
        AppMethodBeat.o(20380);
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(20381);
        ab.i("MicroMsg.ExtControlProviderSNS", "query() ".concat(String.valueOf(uri)));
        a(uri, getContext(), lQc);
        if (uri == null) {
            vf(3);
            AppMethodBeat.o(20381);
            return null;
        } else if (bo.isNullOrNil(this.lPW) || bo.isNullOrNil(brL())) {
            vf(3);
            AppMethodBeat.o(20381);
            return null;
        } else if (eBB) {
            ab.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
            vf(5);
            AppMethodBeat.o(20381);
            return null;
        } else {
            dJ(true);
            Cursor cursor;
            if (!aVl()) {
                dJ(false);
                vf(1);
                cursor = this.jDN;
                AppMethodBeat.o(20381);
                return cursor;
            } else if (!dJ(getContext())) {
                ab.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
                dJ(false);
                vf(2);
                AppMethodBeat.o(20381);
                return null;
            } else if (strArr2 == null || strArr2.length == 0) {
                ab.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
                dJ(false);
                vf(3);
                AppMethodBeat.o(20381);
                return null;
            } else {
                String str3 = strArr2[0];
                if (bo.isNullOrNil(str3)) {
                    ab.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
                    dJ(false);
                    vf(3);
                    AppMethodBeat.o(20381);
                    return null;
                }
                try {
                    long j;
                    if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3.trim())) {
                        j = 0;
                    } else {
                        j = com.tencent.mm.plugin.ext.a.a.Le(str3.trim());
                    }
                    switch (lQc.match(uri)) {
                        case 17:
                            cursor = ij(j);
                            break;
                        default:
                            cursor = null;
                            break;
                    }
                    if (cursor != null) {
                        vf(0);
                    } else {
                        vf(4);
                    }
                    dJ(false);
                    AppMethodBeat.o(20381);
                    return cursor;
                } catch (Exception e) {
                    ab.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                    dJ(false);
                    vf(4);
                    AppMethodBeat.o(20381);
                    return null;
                }
            }
        }
    }

    private Cursor ij(long j) {
        int i = 1;
        AppMethodBeat.i(20382);
        ab.i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = ".concat(String.valueOf(j)));
        try {
            com.tencent.mm.n.a aoM;
            ab.i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", Long.valueOf(j));
            if (j == 0) {
                aw.ZK();
                aoM = c.XM().aoM(r.Yz());
            } else {
                aw.ZK();
                aoM = c.XM().mQ(j);
            }
            if (aoM == null || ((int) aoM.ewQ) <= 0) {
                ab.e("MicroMsg.ExtControlProviderSNS", "ct == null");
                i = 0;
            } else {
                this.czq = com.tencent.mm.n.a.jh(aoM.field_type);
                this.czr = r.mG(aoM.field_username);
                ab.d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", aoM.field_username, Boolean.valueOf(this.czq), Boolean.valueOf(this.czr));
                final b bVar = new b();
                bVar.b(10000, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20379);
                        fo foVar = new fo();
                        foVar.czp.type = 1;
                        foVar.czp.username = aoM.field_username;
                        foVar.czp.czq = ExtControlProviderSNS.this.czq;
                        foVar.czp.czr = ExtControlProviderSNS.this.czr;
                        foVar.czp.czs = ExtControlProviderSNS.this.czs;
                        foVar.czp.czt = new bk.a() {
                            public final void a(e eVar) {
                                AppMethodBeat.i(20378);
                                bVar.countDown();
                                AppMethodBeat.o(20378);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xxA.m(foVar);
                        AppMethodBeat.o(20379);
                    }
                });
            }
            if (i == 0) {
                ab.w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
                AppMethodBeat.o(20382);
                return null;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
        }
        Cursor brQ = brQ();
        AppMethodBeat.o(20382);
        return brQ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195 A:{Catch:{ Exception -> 0x01d8 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Cursor brQ() {
        AppMethodBeat.i(20383);
        ab.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
        com.tencent.mm.cd.e eVar = new com.tencent.mm.cd.e(lQC, (byte) 0);
        ff ffVar = new ff();
        ffVar.cyG.cyI = this.lQD;
        if (com.tencent.mm.sdk.b.a.xxA.m(ffVar)) {
            Cursor cursor = ffVar.cyH.cyz;
            if (cursor != null) {
                try {
                    int count = cursor.getCount();
                    ab.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = ".concat(String.valueOf(count)));
                    if (count <= 0 || !cursor.moveToFirst()) {
                        ab.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + eVar.getCount());
                        cursor.close();
                    } else {
                        do {
                            if (cursor != null) {
                                fg fgVar = new fg();
                                fgVar.cyJ.cyL = cursor;
                                if (com.tencent.mm.sdk.b.a.xxA.m(fgVar)) {
                                    aw.ZK();
                                    ad aoM = c.XM().aoM(fgVar.cyK.cyM);
                                    if (aoM != null && ((int) aoM.ewQ) > 0) {
                                        int i;
                                        Object obj;
                                        Object[] objArr;
                                        String str = "";
                                        String str2 = "";
                                        switch (fgVar.cyK.cyQ) {
                                            case 1:
                                            case 7:
                                            case 8:
                                                i = 2;
                                                break;
                                            case 2:
                                                i = 1;
                                                break;
                                            case 3:
                                                i = 6;
                                                break;
                                            case 4:
                                                i = 3;
                                                break;
                                            case 5:
                                                i = 4;
                                                break;
                                            default:
                                                i = 5;
                                                break;
                                        }
                                        if (!(fgVar.cyK.cyS == null || fgVar.cyK.cyS.size() <= 0 || getContext() == null)) {
                                            ab.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", Integer.valueOf(fgVar.cyK.cyS.size()));
                                            if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                obj = (String) fgVar.cyK.cyS.get(0);
                                                if (!(fgVar.cyK.cyT == null || fgVar.cyK.cyT.size() <= 0 || getContext() == null)) {
                                                    ab.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(fgVar.cyK.cyT.size()), Integer.valueOf(fgVar.cyK.cyU), Integer.valueOf(fgVar.cyK.cyV));
                                                    if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                        str2 = (String) fgVar.cyK.cyT.get(0);
                                                    }
                                                }
                                                str = com.tencent.mm.ah.b.pX(fgVar.cyK.cyM);
                                                objArr = new Object[11];
                                                objArr[0] = com.tencent.mm.plugin.ext.a.a.ii((long) fgVar.cyK.cyN);
                                                objArr[1] = fgVar.cyK.cyO;
                                                objArr[2] = obj;
                                                objArr[3] = aoM.Oj();
                                                if (str == null) {
                                                    str = "";
                                                }
                                                objArr[4] = str;
                                                objArr[5] = Long.valueOf(fgVar.cyK.cyP);
                                                objArr[6] = Integer.valueOf(fgVar.cyK.cyR);
                                                objArr[7] = Integer.valueOf(i);
                                                objArr[8] = str2;
                                                objArr[9] = Integer.valueOf(fgVar.cyK.cyU);
                                                objArr[10] = Integer.valueOf(fgVar.cyK.cyV);
                                                eVar.addRow(objArr);
                                            }
                                        }
                                        String obj2 = str;
                                        ab.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(fgVar.cyK.cyT.size()), Integer.valueOf(fgVar.cyK.cyU), Integer.valueOf(fgVar.cyK.cyV));
                                        str2 = (String) fgVar.cyK.cyT.get(0);
                                        str = com.tencent.mm.ah.b.pX(fgVar.cyK.cyM);
                                        try {
                                            objArr = new Object[11];
                                            objArr[0] = com.tencent.mm.plugin.ext.a.a.ii((long) fgVar.cyK.cyN);
                                            objArr[1] = fgVar.cyK.cyO;
                                            objArr[2] = obj2;
                                            objArr[3] = aoM.Oj();
                                            if (str == null) {
                                            }
                                            objArr[4] = str;
                                            objArr[5] = Long.valueOf(fgVar.cyK.cyP);
                                            objArr[6] = Integer.valueOf(fgVar.cyK.cyR);
                                            objArr[7] = Integer.valueOf(i);
                                            objArr[8] = str2;
                                            objArr[9] = Integer.valueOf(fgVar.cyK.cyU);
                                            objArr[10] = Integer.valueOf(fgVar.cyK.cyV);
                                            eVar.addRow(objArr);
                                        } catch (Exception e) {
                                            ab.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                                            ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    ab.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
                                }
                            }
                        } while (cursor.moveToNext());
                        ab.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + eVar.getCount());
                        cursor.close();
                    }
                } catch (Exception e2) {
                    ab.e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
                    ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e2, "", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    eVar.close();
                    AppMethodBeat.o(20383);
                    return null;
                }
            }
            AppMethodBeat.o(20383);
            return eVar;
        }
        eVar.close();
        AppMethodBeat.o(20383);
        return null;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
