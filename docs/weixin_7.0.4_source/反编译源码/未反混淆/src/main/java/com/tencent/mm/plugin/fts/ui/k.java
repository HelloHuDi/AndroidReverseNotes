package com.tencent.mm.plugin.fts.ui;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import java.util.ArrayList;

public final class k {
    public static void M(int i, long j) {
        AppMethodBeat.i(61935);
        ab.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", Integer.valueOf(i), Long.valueOf(j));
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
                h.pYm.b(arrayList, false);
                break;
        }
        AppMethodBeat.o(61935);
    }

    public static void c(String str, boolean z, int i, int i2) {
        AppMethodBeat.i(61936);
        a(str, z, i, i2, new b());
        AppMethodBeat.o(61936);
    }

    public static void a(String str, boolean z, int i, int i2, b bVar) {
        int i3;
        String format;
        AppMethodBeat.i(61937);
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
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[]{str, Integer.valueOf(3), Integer.valueOf(i3), Integer.valueOf(bVar.mLt), Integer.valueOf(bVar.mLw), Integer.valueOf(bVar.mLD), Integer.valueOf(bVar.mLA), Integer.valueOf(bVar.mLB), e.mCM, Integer.valueOf(bVar.mLv), Integer.valueOf(bVar.mLx), Integer.valueOf(bVar.mLG), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(bVar.mLH)});
        } else if (i > 0) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[]{str, Integer.valueOf(2), Integer.valueOf(i3), Integer.valueOf(bVar.mLt), Integer.valueOf(bVar.mLw), Integer.valueOf(bVar.mLD), Integer.valueOf(bVar.mLA), Integer.valueOf(bVar.mLB), e.mCM, Integer.valueOf(bVar.mLv), Integer.valueOf(bVar.mLx), Integer.valueOf(bVar.mLG), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(bVar.mLH)});
        } else {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s", new Object[]{str, Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(bVar.mLt), Integer.valueOf(bVar.mLw), Integer.valueOf(bVar.mLD), Integer.valueOf(bVar.mLA), Integer.valueOf(bVar.mLB), e.mCM, Integer.valueOf(bVar.mLv), Integer.valueOf(bVar.mLx), Integer.valueOf(bVar.mLG), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(bVar.mLH)});
        }
        ab.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", Integer.valueOf(11062), format);
        h.pYm.X(11062, format);
        AppMethodBeat.o(61937);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(61938);
        if (TextUtils.isEmpty(bVar.query)) {
            AppMethodBeat.o(61938);
            return;
        }
        ab.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", Integer.valueOf(16050), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s", new Object[]{bVar.query, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(bVar.mLt), Integer.valueOf(bVar.mLw), Integer.valueOf(bVar.mLD), Integer.valueOf(bVar.mLA), Integer.valueOf(bVar.mLB), e.mCM, Integer.valueOf(bVar.mLv), Integer.valueOf(bVar.mLx), Integer.valueOf(bVar.mLG), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(bVar.mLH), e.mCM}));
        h.pYm.X(16050, r0);
        AppMethodBeat.o(61938);
    }

    public static void a(a aVar, b bVar) {
        int i;
        int i2;
        String str;
        AppMethodBeat.i(61939);
        int i3 = 1;
        int i4 = aVar.mFm;
        int i5 = aVar.mFn;
        String str2 = aVar.mFo;
        long j = aVar.mFp;
        String aAp = aVar.aAp();
        int l = l(aVar.mFr, aVar.mFs, aVar.bAv());
        if (aVar.mFl == -8) {
            i = 0;
            switch (aVar.klY) {
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
            switch (aVar.klY) {
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
                    if (!aVar.mFq) {
                        i2 = 9;
                        break;
                    } else {
                        i2 = 8;
                        break;
                    }
                case 12:
                    if (aVar.mFl == -5) {
                        i2 = 16;
                        i3 = 2;
                        break;
                    } else if (aVar.mFl == -3) {
                        i2 = 4;
                        i3 = 2;
                        break;
                    } else if (aVar.mFl == -4) {
                        i2 = 3;
                        i3 = 2;
                        break;
                    } else if (aVar.mFl == -1) {
                        i2 = 12;
                        i3 = 2;
                        break;
                    } else if (aVar.mFl == -2) {
                        i2 = 11;
                        i3 = 2;
                        break;
                    } else if (aVar.mFl == -15) {
                        i2 = 21;
                        i3 = 2;
                        break;
                    } else if (aVar.mFl == -6) {
                        i2 = 10;
                        i3 = 2;
                        break;
                    } else if (aVar.mFl == -13) {
                        i2 = 19;
                        i3 = 2;
                        break;
                    } else if (aVar.mFl == -7) {
                        i2 = 5;
                        i3 = 2;
                        break;
                    } else {
                        AppMethodBeat.o(61939);
                        return;
                    }
                case 13:
                    i2 = 17;
                    break;
                case 14:
                    i2 = 15;
                    break;
                case 16:
                    d dVar = new d();
                    str = aVar.mDz.mDY;
                    if (str != null) {
                        str = str.replaceAll(",", " ");
                    }
                    dVar.l("20KeyWordId", str + ",");
                    dVar.l("21ViewType", "1,");
                    dVar.l("22OpType", "2,");
                    dVar.l("23ResultCount", ",");
                    dVar.l("24ClickPos", aVar.mFn + ",");
                    dVar.l("25ClickAppUserName", aVar.info + ",");
                    ab.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", dVar.Fk());
                    h.pYm.e(13963, dVar);
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
                    AppMethodBeat.o(61939);
                    return;
            }
        }
        str = "";
        if (aVar instanceof q) {
            q qVar = (q) aVar;
            boolean DX = qVar.ehM.DX();
            long j2 = qVar.hpS.timestamp / 1000;
            long j3 = qVar.hpS.mEB;
            ak aoZ = ((j) g.K(j.class)).XR().aoZ(qVar.username);
            i = 0;
            if (aoZ != null) {
                i = aoZ.field_unReadCount;
            } else {
                ab.w("MicroMsg.FTS.FTSReportLogic", "10991 conv null");
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
        long currentTimeMillis = System.currentTimeMillis() - bVar.mLr;
        if (currentTimeMillis < 0 || bVar.mLr == 0) {
            currentTimeMillis = 0;
        }
        Object obj = !bVar.mLI.equals(aVar.mDz.mDY) ? 1 : null;
        String str4 = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        Object[] objArr2 = new Object[32];
        objArr2[0] = Integer.valueOf(aVar.mFa);
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = Integer.valueOf(i4);
        objArr2[3] = Integer.valueOf(i3);
        objArr2[4] = Integer.valueOf(i5);
        objArr2[5] = bo.bc(str2, "");
        objArr2[6] = Long.valueOf(j);
        objArr2[7] = Integer.valueOf(l);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Integer.valueOf(aVar.aAq());
        objArr2[10] = Integer.valueOf(we(aVar.bAu()));
        objArr2[11] = aAp;
        objArr2[12] = Long.valueOf(currentTimeMillis);
        objArr2[13] = Integer.valueOf(bVar.mLu);
        objArr2[14] = Integer.valueOf(bVar.mLv);
        objArr2[15] = Integer.valueOf(bVar.mLw);
        objArr2[16] = Integer.valueOf(bVar.mLx);
        objArr2[17] = Integer.valueOf(bVar.mLy);
        objArr2[18] = Integer.valueOf(bVar.mLz);
        objArr2[19] = Integer.valueOf(bVar.mLA);
        objArr2[20] = Integer.valueOf(bVar.mLC);
        objArr2[21] = Integer.valueOf(bVar.mLD);
        objArr2[22] = e.mCM;
        objArr2[23] = aVar.mDz.mDY;
        objArr2[24] = Integer.valueOf(bVar.mLB);
        objArr2[25] = Integer.valueOf(bVar.mLE);
        objArr2[26] = Integer.valueOf(bVar.bBj());
        objArr2[27] = "";
        objArr2[28] = "";
        objArr2[29] = "";
        objArr2[30] = Integer.valueOf(1);
        objArr2[31] = Integer.valueOf(obj != null ? 1 : 0);
        String format = String.format(str4, objArr2);
        if (bo.isNullOrNil(str)) {
            str = format;
        } else {
            str = format + str;
        }
        ab.d("MicroMsg.FTS.FTSReportLogic", "10991 report home page click: %d, %s", Integer.valueOf(10991), str);
        h.pYm.X(10991, str);
        AppMethodBeat.o(61939);
    }

    static void a(String str, int i, int i2, b bVar, int i3) {
        int i4;
        AppMethodBeat.i(61940);
        int i5 = i + 1;
        long currentTimeMillis = System.currentTimeMillis() - bVar.mLr;
        if (currentTimeMillis < 0 || bVar.mLr == 0) {
            currentTimeMillis = 0;
        }
        Object obj = !bVar.mLI.equals(str) ? 1 : null;
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
        objArr[13] = Integer.valueOf(bVar.mLu);
        objArr[14] = Integer.valueOf(bVar.mLv);
        objArr[15] = Integer.valueOf(bVar.mLw);
        objArr[16] = Integer.valueOf(bVar.mLx);
        objArr[17] = Integer.valueOf(bVar.mLy);
        objArr[18] = Integer.valueOf(bVar.mLz);
        objArr[19] = Integer.valueOf(bVar.mLA);
        objArr[20] = Integer.valueOf(bVar.mLC);
        objArr[21] = Integer.valueOf(bVar.mLD);
        objArr[22] = e.mCM;
        objArr[23] = str;
        objArr[24] = Integer.valueOf(bVar.mLB);
        objArr[25] = Integer.valueOf(bVar.mLE);
        objArr[26] = Integer.valueOf(bVar.bBj());
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
        ab.d("MicroMsg.FTS.FTSReportLogic", "10991 reportWebSearch click: %d, %s", Integer.valueOf(10991), String.format(str2, objArr));
        h.pYm.X(10991, r0);
        AppMethodBeat.o(61940);
    }

    private static int l(int i, int i2, boolean z) {
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
                case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
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

    private static int we(int i) {
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
            case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                return 16;
            default:
                return 0;
        }
    }

    public static void a(a aVar, com.tencent.mm.plugin.fts.ui.c.a aVar2) {
        int i;
        String str;
        AppMethodBeat.i(61941);
        int i2 = aVar.mFm;
        String str2 = aVar.mFo;
        long j = aVar.mFp;
        int l = l(aVar.mFr, aVar.mFs, aVar.bAv());
        switch (aVar.klY) {
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
                d dVar = new d();
                str = aVar.mDz.mDY;
                if (str != null) {
                    str = str.replaceAll(",", " ");
                }
                dVar.l("20KeyWordId", str + ",");
                dVar.l("21ViewType", "2,");
                dVar.l("22OpType", "2,");
                dVar.l("23ResultCount", ",");
                dVar.l("24ClickPos", aVar.mFn + ",");
                dVar.l("25ClickAppUserName", aVar.info + ",");
                ab.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", dVar.Fk());
                h.pYm.e(13963, dVar);
                i = 19;
                break;
            case 17:
                i = 20;
                break;
            case 20:
                i = 21;
                break;
            default:
                AppMethodBeat.o(61941);
                return;
        }
        str = "";
        if (aVar instanceof q) {
            q qVar = (q) aVar;
            boolean DX = qVar.ehM.DX();
            long j2 = qVar.hpS.timestamp / 1000;
            long j3 = qVar.hpS.mEB;
            ak aoZ = ((j) g.K(j.class)).XR().aoZ(qVar.username);
            int i3 = 0;
            if (aoZ != null) {
                i3 = aoZ.field_unReadCount;
            } else {
                ab.w("MicroMsg.FTS.FTSReportLogic", "11310 conv null");
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
        long currentTimeMillis = System.currentTimeMillis() - aVar2.mLr;
        if (currentTimeMillis < 0 || aVar2.mLr == 0) {
            currentTimeMillis = 0;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(aVar.mFa), Integer.valueOf(i), Integer.valueOf(i2), bo.bc(str2, ""), Long.valueOf(j), Integer.valueOf(l), Integer.valueOf(aVar.aAq()), Integer.valueOf(we(aVar.bAu())), aVar.aAp(), Long.valueOf(currentTimeMillis), Integer.valueOf(aVar2.mLs)});
        if (bo.isNullOrNil(str)) {
            str = format;
        } else {
            str = format + str;
        }
        ab.d("MicroMsg.FTS.FTSReportLogic", "report detail page click 11310: %s", str);
        h.pYm.X(11310, str);
        AppMethodBeat.o(61941);
    }

    public static final void hA(boolean z) {
        int i;
        int i2 = 1;
        AppMethodBeat.i(61942);
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
        ab.v(str, str2, objArr);
        h hVar = h.pYm;
        Object[] objArr2 = new Object[1];
        if (!z) {
            i2 = 0;
        }
        objArr2[0] = Integer.valueOf(i2);
        hVar.e(13970, objArr2);
        AppMethodBeat.o(61942);
    }
}
