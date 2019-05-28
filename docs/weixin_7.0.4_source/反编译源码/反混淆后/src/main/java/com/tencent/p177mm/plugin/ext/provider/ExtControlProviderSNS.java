package com.tencent.p177mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p213cd.C1359e;
import com.tencent.p177mm.p230g.p231a.C26136fo;
import com.tencent.p177mm.p230g.p231a.C32555ff;
import com.tencent.p177mm.p230g.p231a.C6477fg;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.ext.p1398a.C27902a;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C46484b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS */
public final class ExtControlProviderSNS extends ExtContentProviderBase {
    private static boolean eBB = false;
    private static C7564ap lQA = new C7564ap(new C117811(), false);
    private static final String[] lQC = new String[]{"feedId", "desc", "url", "nickname", "avatar", Param.TIMESTAMP, "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight"};
    private static final UriMatcher lQc;
    private boolean czq = false;
    private boolean czr = false;
    private int czs = 0;
    private String lQD = "";

    /* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS$1 */
    static class C117811 implements C5015a {
        C117811() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(20377);
            ExtControlProviderSNS.eBB = false;
            AppMethodBeat.m2505o(20377);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(20384);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
        AppMethodBeat.m2505o(20384);
    }

    /* renamed from: dJ */
    private static void m71865dJ(boolean z) {
        AppMethodBeat.m2504i(20380);
        if (z) {
            eBB = true;
            lQA.mo16770ae(15000, 15000);
            AppMethodBeat.m2505o(20380);
            return;
        }
        lQA.mo16770ae(0, 0);
        AppMethodBeat.m2505o(20380);
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(20381);
        C4990ab.m7416i("MicroMsg.ExtControlProviderSNS", "query() ".concat(String.valueOf(uri)));
        mo61884a(uri, getContext(), lQc);
        if (uri == null) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20381);
            return null;
        } else if (C5046bo.isNullOrNil(this.lPW) || C5046bo.isNullOrNil(brL())) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20381);
            return null;
        } else if (eBB) {
            C4990ab.m7420w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
            mo61890vf(5);
            AppMethodBeat.m2505o(20381);
            return null;
        } else {
            ExtControlProviderSNS.m71865dJ(true);
            Cursor cursor;
            if (!aVl()) {
                ExtControlProviderSNS.m71865dJ(false);
                mo61890vf(1);
                cursor = this.jDN;
                AppMethodBeat.m2505o(20381);
                return cursor;
            } else if (!mo61888dJ(getContext())) {
                C4990ab.m7420w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
                ExtControlProviderSNS.m71865dJ(false);
                mo61890vf(2);
                AppMethodBeat.m2505o(20381);
                return null;
            } else if (strArr2 == null || strArr2.length == 0) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderSNS", "invaild selections");
                ExtControlProviderSNS.m71865dJ(false);
                mo61890vf(3);
                AppMethodBeat.m2505o(20381);
                return null;
            } else {
                String str3 = strArr2[0];
                if (C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7412e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
                    ExtControlProviderSNS.m71865dJ(false);
                    mo61890vf(3);
                    AppMethodBeat.m2505o(20381);
                    return null;
                }
                try {
                    long j;
                    if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3.trim())) {
                        j = 0;
                    } else {
                        j = C27902a.m44381Le(str3.trim());
                    }
                    switch (lQc.match(uri)) {
                        case 17:
                            cursor = m71866ij(j);
                            break;
                        default:
                            cursor = null;
                            break;
                    }
                    if (cursor != null) {
                        mo61890vf(0);
                    } else {
                        mo61890vf(4);
                    }
                    ExtControlProviderSNS.m71865dJ(false);
                    AppMethodBeat.m2505o(20381);
                    return cursor;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                    ExtControlProviderSNS.m71865dJ(false);
                    mo61890vf(4);
                    AppMethodBeat.m2505o(20381);
                    return null;
                }
            }
        }
    }

    /* renamed from: ij */
    private Cursor m71866ij(long j) {
        int i = 1;
        AppMethodBeat.m2504i(20382);
        C4990ab.m7416i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = ".concat(String.valueOf(j)));
        try {
            C7486a aoM;
            C4990ab.m7417i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", Long.valueOf(j));
            if (j == 0) {
                C9638aw.m17190ZK();
                aoM = C18628c.m29078XM().aoM(C1853r.m3846Yz());
            } else {
                C9638aw.m17190ZK();
                aoM = C18628c.m29078XM().mo15763mQ(j);
            }
            if (aoM == null || ((int) aoM.ewQ) <= 0) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderSNS", "ct == null");
                i = 0;
            } else {
                this.czq = C7486a.m12942jh(aoM.field_type);
                this.czr = C1853r.m3858mG(aoM.field_username);
                C4990ab.m7411d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", aoM.field_username, Boolean.valueOf(this.czq), Boolean.valueOf(this.czr));
                final C46484b c46484b = new C46484b();
                c46484b.mo74707b(10000, new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS$2$1 */
                    class C117831 implements C1835a {
                        C117831() {
                        }

                        /* renamed from: a */
                        public final void mo4918a(C1902e c1902e) {
                            AppMethodBeat.m2504i(20378);
                            c46484b.countDown();
                            AppMethodBeat.m2505o(20378);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(20379);
                        C26136fo c26136fo = new C26136fo();
                        c26136fo.czp.type = 1;
                        c26136fo.czp.username = aoM.field_username;
                        c26136fo.czp.czq = ExtControlProviderSNS.this.czq;
                        c26136fo.czp.czr = ExtControlProviderSNS.this.czr;
                        c26136fo.czp.czs = ExtControlProviderSNS.this.czs;
                        c26136fo.czp.czt = new C117831();
                        C4879a.xxA.mo10055m(c26136fo);
                        AppMethodBeat.m2505o(20379);
                    }
                });
            }
            if (i == 0) {
                C4990ab.m7420w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
                AppMethodBeat.m2505o(20382);
                return null;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderSNS", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
        }
        Cursor brQ = brQ();
        AppMethodBeat.m2505o(20382);
        return brQ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195 A:{Catch:{ Exception -> 0x01d8 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Cursor brQ() {
        AppMethodBeat.m2504i(20383);
        C4990ab.m7416i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
        C1359e c1359e = new C1359e(lQC, (byte) 0);
        C32555ff c32555ff = new C32555ff();
        c32555ff.cyG.cyI = this.lQD;
        if (C4879a.xxA.mo10055m(c32555ff)) {
            Cursor cursor = c32555ff.cyH.cyz;
            if (cursor != null) {
                try {
                    int count = cursor.getCount();
                    C4990ab.m7416i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = ".concat(String.valueOf(count)));
                    if (count <= 0 || !cursor.moveToFirst()) {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + c1359e.getCount());
                        cursor.close();
                    } else {
                        do {
                            if (cursor != null) {
                                C6477fg c6477fg = new C6477fg();
                                c6477fg.cyJ.cyL = cursor;
                                if (C4879a.xxA.mo10055m(c6477fg)) {
                                    C9638aw.m17190ZK();
                                    C7616ad aoM = C18628c.m29078XM().aoM(c6477fg.cyK.cyM);
                                    if (aoM != null && ((int) aoM.ewQ) > 0) {
                                        int i;
                                        Object obj;
                                        Object[] objArr;
                                        String str = "";
                                        String str2 = "";
                                        switch (c6477fg.cyK.cyQ) {
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
                                        if (!(c6477fg.cyK.cyS == null || c6477fg.cyK.cyS.size() <= 0 || getContext() == null)) {
                                            C4990ab.m7411d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", Integer.valueOf(c6477fg.cyK.cyS.size()));
                                            if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                obj = (String) c6477fg.cyK.cyS.get(0);
                                                if (!(c6477fg.cyK.cyT == null || c6477fg.cyK.cyT.size() <= 0 || getContext() == null)) {
                                                    C4990ab.m7411d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(c6477fg.cyK.cyT.size()), Integer.valueOf(c6477fg.cyK.cyU), Integer.valueOf(c6477fg.cyK.cyV));
                                                    if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                        str2 = (String) c6477fg.cyK.cyT.get(0);
                                                    }
                                                }
                                                str = C41730b.m73505pX(c6477fg.cyK.cyM);
                                                objArr = new Object[11];
                                                objArr[0] = C27902a.m44382ii((long) c6477fg.cyK.cyN);
                                                objArr[1] = c6477fg.cyK.cyO;
                                                objArr[2] = obj;
                                                objArr[3] = aoM.mo16707Oj();
                                                if (str == null) {
                                                    str = "";
                                                }
                                                objArr[4] = str;
                                                objArr[5] = Long.valueOf(c6477fg.cyK.cyP);
                                                objArr[6] = Integer.valueOf(c6477fg.cyK.cyR);
                                                objArr[7] = Integer.valueOf(i);
                                                objArr[8] = str2;
                                                objArr[9] = Integer.valueOf(c6477fg.cyK.cyU);
                                                objArr[10] = Integer.valueOf(c6477fg.cyK.cyV);
                                                c1359e.addRow(objArr);
                                            }
                                        }
                                        String obj2 = str;
                                        C4990ab.m7411d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(c6477fg.cyK.cyT.size()), Integer.valueOf(c6477fg.cyK.cyU), Integer.valueOf(c6477fg.cyK.cyV));
                                        str2 = (String) c6477fg.cyK.cyT.get(0);
                                        str = C41730b.m73505pX(c6477fg.cyK.cyM);
                                        try {
                                            objArr = new Object[11];
                                            objArr[0] = C27902a.m44382ii((long) c6477fg.cyK.cyN);
                                            objArr[1] = c6477fg.cyK.cyO;
                                            objArr[2] = obj2;
                                            objArr[3] = aoM.mo16707Oj();
                                            if (str == null) {
                                            }
                                            objArr[4] = str;
                                            objArr[5] = Long.valueOf(c6477fg.cyK.cyP);
                                            objArr[6] = Integer.valueOf(c6477fg.cyK.cyR);
                                            objArr[7] = Integer.valueOf(i);
                                            objArr[8] = str2;
                                            objArr[9] = Integer.valueOf(c6477fg.cyK.cyU);
                                            objArr[10] = Integer.valueOf(c6477fg.cyK.cyV);
                                            c1359e.addRow(objArr);
                                        } catch (Exception e) {
                                            C4990ab.m7412e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                                            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    C4990ab.m7420w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
                                }
                            }
                        } while (cursor.moveToNext());
                        C4990ab.m7416i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + c1359e.getCount());
                        cursor.close();
                    }
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e2, "", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    c1359e.close();
                    AppMethodBeat.m2505o(20383);
                    return null;
                }
            }
            AppMethodBeat.m2505o(20383);
            return c1359e;
        }
        c1359e.close();
        AppMethodBeat.m2505o(20383);
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
