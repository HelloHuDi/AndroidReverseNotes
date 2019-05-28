package com.tencent.p177mm.plugin.fts.p424ui;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p1551c.C39154b;
import com.tencent.p177mm.plugin.fts.p424ui.p1551c.C45977a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C6925q;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.fts.ui.k */
public final class C34234k {
    /* renamed from: M */
    public static void m56141M(int i, long j) {
        AppMethodBeat.m2504i(61935);
        C4990ab.m7419v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", Integer.valueOf(i), Long.valueOf(j));
        switch (i) {
            case 0:
            case 3:
            case 6:
            case 9:
            case 12:
                IDKey iDKey = new IDKey();
                iDKey.SetID(79);
                iDKey.SetKey(i + 1);
                iDKey.SetValue((long) ((int) j));
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(79);
                iDKey2.SetKey(i + 2);
                iDKey2.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                C7060h.pYm.mo8379b(arrayList, false);
                break;
        }
        AppMethodBeat.m2505o(61935);
    }

    /* renamed from: c */
    public static void m56147c(String str, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(61936);
        C34234k.m56146a(str, z, i, i2, new C39154b());
        AppMethodBeat.m2505o(61936);
    }

    /* renamed from: a */
    public static void m56146a(String str, boolean z, int i, int i2, C39154b c39154b) {
        int i3;
        String format;
        AppMethodBeat.m2504i(61937);
        switch (i2) {
            case -15:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                i3 = 2;
                break;
            case 0:
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (z) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[]{str, Integer.valueOf(3), Integer.valueOf(i3), Integer.valueOf(c39154b.mLt), Integer.valueOf(c39154b.mLw), Integer.valueOf(c39154b.mLD), Integer.valueOf(c39154b.mLA), Integer.valueOf(c39154b.mLB), C3163e.mCM, Integer.valueOf(c39154b.mLv), Integer.valueOf(c39154b.mLx), Integer.valueOf(c39154b.mLG), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(c39154b.mLH)});
        } else if (i > 0) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[]{str, Integer.valueOf(2), Integer.valueOf(i3), Integer.valueOf(c39154b.mLt), Integer.valueOf(c39154b.mLw), Integer.valueOf(c39154b.mLD), Integer.valueOf(c39154b.mLA), Integer.valueOf(c39154b.mLB), C3163e.mCM, Integer.valueOf(c39154b.mLv), Integer.valueOf(c39154b.mLx), Integer.valueOf(c39154b.mLG), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(c39154b.mLH)});
        } else {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[]{str, Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(c39154b.mLt), Integer.valueOf(c39154b.mLw), Integer.valueOf(c39154b.mLD), Integer.valueOf(c39154b.mLA), Integer.valueOf(c39154b.mLB), C3163e.mCM, Integer.valueOf(c39154b.mLv), Integer.valueOf(c39154b.mLx), Integer.valueOf(c39154b.mLG), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(c39154b.mLH)});
        }
        C4990ab.m7417i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", Integer.valueOf(11062), format);
        C7060h.pYm.mo8374X(11062, format);
        AppMethodBeat.m2505o(61937);
    }

    /* renamed from: a */
    public static void m56144a(C39154b c39154b) {
        AppMethodBeat.m2504i(61938);
        if (TextUtils.isEmpty(c39154b.query)) {
            AppMethodBeat.m2505o(61938);
            return;
        }
        C4990ab.m7417i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", Integer.valueOf(16050), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s", new Object[]{c39154b.query, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(c39154b.mLt), Integer.valueOf(c39154b.mLw), Integer.valueOf(c39154b.mLD), Integer.valueOf(c39154b.mLA), Integer.valueOf(c39154b.mLB), C3163e.mCM, Integer.valueOf(c39154b.mLv), Integer.valueOf(c39154b.mLx), Integer.valueOf(c39154b.mLG), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(c39154b.mLH), C3163e.mCM}));
        C7060h.pYm.mo8374X(16050, r0);
        AppMethodBeat.m2505o(61938);
    }

    /* renamed from: a */
    public static void m56143a(C3154a c3154a, C39154b c39154b) {
        int i;
        int i2;
        String str;
        AppMethodBeat.m2504i(61939);
        int i3 = 1;
        int i4 = c3154a.mFm;
        int i5 = c3154a.mFn;
        String str2 = c3154a.mFo;
        long j = c3154a.mFp;
        String aAp = c3154a.aAp();
        int l = C34234k.m56149l(c3154a.mFr, c3154a.mFs, c3154a.bAv());
        if (c3154a.mFl == -8) {
            i = 0;
            switch (c3154a.klY) {
                case 1:
                    i = 3;
                    break;
                case 2:
                    i = 4;
                    break;
                case 3:
                    i = 10;
                    break;
                case 4:
                    i = 5;
                    break;
            }
            i2 = 2;
            aAp = i + "$" + aAp;
        } else {
            switch (c3154a.klY) {
                case 1:
                    i2 = 3;
                    break;
                case 2:
                    i2 = 4;
                    break;
                case 3:
                    i2 = 10;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 16;
                    break;
                case 6:
                    i2 = 11;
                    break;
                case 7:
                    i2 = 12;
                    break;
                case 8:
                    i2 = 13;
                    break;
                case 9:
                    i2 = 14;
                    break;
                case 10:
                    if (!c3154a.mFq) {
                        i2 = 9;
                        break;
                    } else {
                        i2 = 8;
                        break;
                    }
                case 12:
                    if (c3154a.mFl == -5) {
                        i2 = 16;
                        i3 = 2;
                        break;
                    } else if (c3154a.mFl == -3) {
                        i2 = 4;
                        i3 = 2;
                        break;
                    } else if (c3154a.mFl == -4) {
                        i2 = 3;
                        i3 = 2;
                        break;
                    } else if (c3154a.mFl == -1) {
                        i2 = 12;
                        i3 = 2;
                        break;
                    } else if (c3154a.mFl == -2) {
                        i2 = 11;
                        i3 = 2;
                        break;
                    } else if (c3154a.mFl == -15) {
                        i2 = 21;
                        i3 = 2;
                        break;
                    } else if (c3154a.mFl == -6) {
                        i2 = 10;
                        i3 = 2;
                        break;
                    } else if (c3154a.mFl == -13) {
                        i2 = 19;
                        i3 = 2;
                        break;
                    } else if (c3154a.mFl == -7) {
                        i2 = 5;
                        i3 = 2;
                        break;
                    } else {
                        AppMethodBeat.m2505o(61939);
                        return;
                    }
                case 13:
                    i2 = 17;
                    break;
                case 14:
                    i2 = 15;
                    break;
                case 16:
                    C32831d c32831d = new C32831d();
                    str = c3154a.mDz.mDY;
                    if (str != null) {
                        str = str.replaceAll(",", " ");
                    }
                    c32831d.mo53400l("20KeyWordId", str + ",");
                    c32831d.mo53400l("21ViewType", "1,");
                    c32831d.mo53400l("22OpType", "2,");
                    c32831d.mo53400l("23ResultCount", ",");
                    c32831d.mo53400l("24ClickPos", c3154a.mFn + ",");
                    c32831d.mo53400l("25ClickAppUserName", c3154a.info + ",");
                    C4990ab.m7417i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", c32831d.mo53398Fk());
                    C7060h.pYm.mo8381e(13963, c32831d);
                    i2 = 19;
                    break;
                case 17:
                    i2 = 20;
                    break;
                case 19:
                    i2 = 22;
                    break;
                case 20:
                    i2 = 21;
                    break;
                default:
                    AppMethodBeat.m2505o(61939);
                    return;
            }
        }
        str = "";
        if (c3154a instanceof C6925q) {
            C6925q c6925q = (C6925q) c3154a;
            boolean DX = c6925q.ehM.mo16673DX();
            long j2 = c6925q.hpS.timestamp / 1000;
            long j3 = c6925q.hpS.mEB;
            C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c6925q.username);
            i = 0;
            if (aoZ != null) {
                i = aoZ.field_unReadCount;
            } else {
                C4990ab.m7420w("MicroMsg.FTS.FTSReportLogic", "10991 conv null");
            }
            String str3 = ",%s,%s,%s,%s,%s,%s";
            Object[] objArr = new Object[6];
            objArr[0] = Long.valueOf(j2);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Long.valueOf(j3);
            objArr[3] = Integer.valueOf(DX ? 1 : 0);
            objArr[4] = Integer.valueOf(i);
            objArr[5] = Integer.valueOf(0);
            str = String.format(str3, objArr);
        }
        long currentTimeMillis = System.currentTimeMillis() - c39154b.mLr;
        if (currentTimeMillis < 0 || c39154b.mLr == 0) {
            currentTimeMillis = 0;
        }
        Object obj = !c39154b.mLI.equals(c3154a.mDz.mDY) ? 1 : null;
        String str4 = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        Object[] objArr2 = new Object[32];
        objArr2[0] = Integer.valueOf(c3154a.mFa);
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = Integer.valueOf(i4);
        objArr2[3] = Integer.valueOf(i3);
        objArr2[4] = Integer.valueOf(i5);
        objArr2[5] = C5046bo.m7532bc(str2, "");
        objArr2[6] = Long.valueOf(j);
        objArr2[7] = Integer.valueOf(l);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Integer.valueOf(c3154a.aAq());
        objArr2[10] = Integer.valueOf(C34234k.m56150we(c3154a.bAu()));
        objArr2[11] = aAp;
        objArr2[12] = Long.valueOf(currentTimeMillis);
        objArr2[13] = Integer.valueOf(c39154b.mLu);
        objArr2[14] = Integer.valueOf(c39154b.mLv);
        objArr2[15] = Integer.valueOf(c39154b.mLw);
        objArr2[16] = Integer.valueOf(c39154b.mLx);
        objArr2[17] = Integer.valueOf(c39154b.mLy);
        objArr2[18] = Integer.valueOf(c39154b.mLz);
        objArr2[19] = Integer.valueOf(c39154b.mLA);
        objArr2[20] = Integer.valueOf(c39154b.mLC);
        objArr2[21] = Integer.valueOf(c39154b.mLD);
        objArr2[22] = C3163e.mCM;
        objArr2[23] = c3154a.mDz.mDY;
        objArr2[24] = Integer.valueOf(c39154b.mLB);
        objArr2[25] = Integer.valueOf(c39154b.mLE);
        objArr2[26] = Integer.valueOf(c39154b.bBj());
        objArr2[27] = "";
        objArr2[28] = "";
        objArr2[29] = "";
        objArr2[30] = Integer.valueOf(1);
        objArr2[31] = Integer.valueOf(obj != null ? 1 : 0);
        String format = String.format(str4, objArr2);
        if (C5046bo.isNullOrNil(str)) {
            str = format;
        } else {
            str = format + str;
        }
        C4990ab.m7411d("MicroMsg.FTS.FTSReportLogic", "10991 report home page click: %d, %s", Integer.valueOf(10991), str);
        C7060h.pYm.mo8374X(10991, str);
        AppMethodBeat.m2505o(61939);
    }

    /* renamed from: a */
    static void m56145a(String str, int i, int i2, C39154b c39154b, int i3) {
        int i4;
        AppMethodBeat.m2504i(61940);
        int i5 = i + 1;
        long currentTimeMillis = System.currentTimeMillis() - c39154b.mLr;
        if (currentTimeMillis < 0 || c39154b.mLr == 0) {
            currentTimeMillis = 0;
        }
        Object obj = !c39154b.mLI.equals(str) ? 1 : null;
        String str2 = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        Object[] objArr = new Object[32];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(i5);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(0);
        objArr[5] = "";
        objArr[6] = "";
        objArr[7] = Integer.valueOf(0);
        objArr[8] = Integer.valueOf(0);
        objArr[9] = Integer.valueOf(0);
        objArr[10] = Integer.valueOf(0);
        objArr[11] = "";
        objArr[12] = Long.valueOf(currentTimeMillis);
        objArr[13] = Integer.valueOf(c39154b.mLu);
        objArr[14] = Integer.valueOf(c39154b.mLv);
        objArr[15] = Integer.valueOf(c39154b.mLw);
        objArr[16] = Integer.valueOf(c39154b.mLx);
        objArr[17] = Integer.valueOf(c39154b.mLy);
        objArr[18] = Integer.valueOf(c39154b.mLz);
        objArr[19] = Integer.valueOf(c39154b.mLA);
        objArr[20] = Integer.valueOf(c39154b.mLC);
        objArr[21] = Integer.valueOf(c39154b.mLD);
        objArr[22] = C3163e.mCM;
        objArr[23] = str;
        objArr[24] = Integer.valueOf(c39154b.mLB);
        objArr[25] = Integer.valueOf(c39154b.mLE);
        objArr[26] = Integer.valueOf(c39154b.bBj());
        objArr[27] = "";
        objArr[28] = "";
        objArr[29] = "";
        objArr[30] = Integer.valueOf(1);
        if (obj != null) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        objArr[31] = Integer.valueOf(i4);
        C4990ab.m7411d("MicroMsg.FTS.FTSReportLogic", "10991 reportWebSearch click: %d, %s", Integer.valueOf(10991), String.format(str2, objArr));
        C7060h.pYm.mo8374X(10991, r0);
        AppMethodBeat.m2505o(61940);
    }

    /* renamed from: l */
    private static int m56149l(int i, int i2, boolean z) {
        if (z) {
            return 15;
        }
        if (i == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            switch (i2) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 11:
                    return 8;
                case 15:
                    return 16;
                case 16:
                    return 10;
                case 17:
                case 18:
                    return 9;
                default:
                    return 0;
            }
        } else if (i == 131075) {
            switch (i2) {
                case 1:
                case 5:
                    return 12;
                case 2:
                case 6:
                    return 13;
                case 3:
                case 7:
                    return 14;
                case 29:
                case 30:
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                case C2275g.CTRL_INDEX /*37*/:
                case 38:
                    return 11;
                default:
                    return 0;
            }
        } else if (i == 131081) {
            return 19;
        } else {
            if (i == 65536) {
                return 17;
            }
            return 0;
        }
    }

    /* renamed from: we */
    private static int m56150we(int i) {
        switch (i) {
            case 29:
                return 1;
            case 30:
                return 2;
            case 31:
                return 3;
            case 32:
                return 4;
            case 34:
                return 5;
            case 35:
            case 36:
                return 6;
            case C2275g.CTRL_INDEX /*37*/:
                return 16;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static void m56142a(C3154a c3154a, C45977a c45977a) {
        int i;
        String str;
        AppMethodBeat.m2504i(61941);
        int i2 = c3154a.mFm;
        String str2 = c3154a.mFo;
        long j = c3154a.mFp;
        int l = C34234k.m56149l(c3154a.mFr, c3154a.mFs, c3154a.bAv());
        switch (c3154a.klY) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 4;
                break;
            case 3:
                i = 10;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 16;
                break;
            case 6:
                i = 11;
                break;
            case 7:
                i = 12;
                break;
            case 8:
                i = 13;
                break;
            case 9:
                i = 14;
                break;
            case 13:
                i = 17;
                break;
            case 14:
                i = 15;
                break;
            case 16:
                C32831d c32831d = new C32831d();
                str = c3154a.mDz.mDY;
                if (str != null) {
                    str = str.replaceAll(",", " ");
                }
                c32831d.mo53400l("20KeyWordId", str + ",");
                c32831d.mo53400l("21ViewType", "2,");
                c32831d.mo53400l("22OpType", "2,");
                c32831d.mo53400l("23ResultCount", ",");
                c32831d.mo53400l("24ClickPos", c3154a.mFn + ",");
                c32831d.mo53400l("25ClickAppUserName", c3154a.info + ",");
                C4990ab.m7417i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", c32831d.mo53398Fk());
                C7060h.pYm.mo8381e(13963, c32831d);
                i = 19;
                break;
            case 17:
                i = 20;
                break;
            case 20:
                i = 21;
                break;
            default:
                AppMethodBeat.m2505o(61941);
                return;
        }
        str = "";
        if (c3154a instanceof C6925q) {
            C6925q c6925q = (C6925q) c3154a;
            boolean DX = c6925q.ehM.mo16673DX();
            long j2 = c6925q.hpS.timestamp / 1000;
            long j3 = c6925q.hpS.mEB;
            C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c6925q.username);
            int i3 = 0;
            if (aoZ != null) {
                i3 = aoZ.field_unReadCount;
            } else {
                C4990ab.m7420w("MicroMsg.FTS.FTSReportLogic", "11310 conv null");
            }
            String str3 = ",%s,%s,%s,%s,%s,%s";
            Long[] lArr = new Object[6];
            lArr[0] = Long.valueOf(j2);
            lArr[1] = Integer.valueOf(0);
            lArr[2] = Long.valueOf(j3);
            lArr[3] = Integer.valueOf(DX ? 1 : 0);
            lArr[4] = Integer.valueOf(i3);
            lArr[5] = Integer.valueOf(0);
            str = String.format(str3, lArr);
        }
        long currentTimeMillis = System.currentTimeMillis() - c45977a.mLr;
        if (currentTimeMillis < 0 || c45977a.mLr == 0) {
            currentTimeMillis = 0;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(c3154a.mFa), Integer.valueOf(i), Integer.valueOf(i2), C5046bo.m7532bc(str2, ""), Long.valueOf(j), Integer.valueOf(l), Integer.valueOf(c3154a.aAq()), Integer.valueOf(C34234k.m56150we(c3154a.bAu())), c3154a.aAp(), Long.valueOf(currentTimeMillis), Integer.valueOf(c45977a.mLs)});
        if (C5046bo.isNullOrNil(str)) {
            str = format;
        } else {
            str = format + str;
        }
        C4990ab.m7411d("MicroMsg.FTS.FTSReportLogic", "report detail page click 11310: %s", str);
        C7060h.pYm.mo8374X(11310, str);
        AppMethodBeat.m2505o(61941);
    }

    /* renamed from: hA */
    public static final void m56148hA(boolean z) {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(61942);
        String str = "MicroMsg.FTS.FTSReportLogic";
        String str2 = "reportFTSCreateChatroom: %d %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(13970);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7419v(str, str2, objArr);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr2 = new Object[1];
        if (!z) {
            i2 = 0;
        }
        objArr2[0] = Integer.valueOf(i2);
        c7060h.mo8381e(13970, objArr2);
        AppMethodBeat.m2505o(61942);
    }
}
