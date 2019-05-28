package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import java.util.HashMap;
import java.util.Iterator;

public final class f {
    int ctE;
    int jOd;
    int jOe;
    HashMap<String, a> jOf = new HashMap();

    static class a extends ks {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.f$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ long jOi;
        final /* synthetic */ int jOj;

        AnonymousClass3(long j, int i) {
            this.jOi = j;
            this.jOj = i;
        }

        public final void run() {
            int i;
            int i2;
            AppMethodBeat.i(14172);
            r aeX = z.aeX();
            Cursor a = aeX.fni.a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= ".concat(String.valueOf(this.jOi & -4294967296L)), null, 0);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
            int mG = z.aeX().mG(this.jOi);
            r aeX2 = z.aeX();
            Cursor a2 = aeX2.fni.a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (this.jOi & -4294967296L) + " and placeTop = 1 ", null, 0);
            if (a2.moveToFirst()) {
                i2 = a2.getInt(0);
            } else {
                i2 = 0;
            }
            a2.close();
            int baS = z.aeY().baS();
            h.pYm.e(11404, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(mG), Integer.valueOf(i2), Integer.valueOf(baS), Integer.valueOf(f.this.ctE), Integer.valueOf(f.this.ctE), Integer.valueOf(this.jOj));
            ab.i("MicroMsg.BizTimeLineReport", "reportEnterBiz %d|%d|%d|%d|%d|%d|%d", Integer.valueOf(i), Integer.valueOf(mG), Integer.valueOf(i2), Integer.valueOf(baS), Integer.valueOf(f.this.ctE), Integer.valueOf(f.this.ctE), Integer.valueOf(this.jOj));
            AppMethodBeat.o(14172);
        }
    }

    public f(int i) {
        AppMethodBeat.i(14174);
        this.ctE = i;
        AppMethodBeat.o(14174);
    }

    public final void c(q qVar, int i) {
        AppMethodBeat.i(14175);
        final int i2 = qVar.field_status;
        final int i3 = qVar.field_isRead;
        final q qVar2 = qVar;
        final int i4 = i;
        b.a("BrandServiceWorkerThread", new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:72:0x01f4  */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x01d6 A:{Catch:{ UnsupportedOperationException -> 0x018f, Exception -> 0x01ae }} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(14170);
                f fVar = f.this;
                q qVar = qVar2;
                int i = i4;
                int i2 = i2;
                int i3 = i3;
                if (qVar != null) {
                    int size;
                    a aVar;
                    int i4;
                    if (qVar.drC()) {
                        if (qVar.drC()) {
                            o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(qVar.field_msgId, qVar.field_content);
                            if (b == null || bo.ek(b.fjr)) {
                                AppMethodBeat.o(14170);
                                return;
                            }
                            try {
                                int i5;
                                size = b.fjr.size();
                                if (size <= 2 || qVar.field_isExpand) {
                                    i5 = size;
                                } else {
                                    i5 = 2;
                                }
                                int i6 = 0;
                                while (i6 < i5) {
                                    p pVar = (p) b.fjr.get(i6);
                                    if (pVar != null) {
                                        aVar = (a) fVar.jOf.get(qVar.field_msgId + "_" + i6);
                                        if (aVar == null) {
                                            a aVar2 = new a();
                                            fVar.jOf.put(qVar.field_msgId + "_" + i6, aVar2);
                                            aVar2.vNN = qVar.field_talker;
                                            aVar2.vNP = 1;
                                            aVar2.vNX = (int) (System.currentTimeMillis() / 1000);
                                            aVar2.pos = i;
                                            aVar2.vNR = 0;
                                            aVar2.vNT = 0;
                                            aVar2.vNU = 0;
                                            aVar2.vNW = 0;
                                            aVar2.vNr = 0;
                                            aVar2.vNW = 0;
                                            aVar2.vNY = (int) (qVar.field_createTime / 1000);
                                            i4 = i2 != 4 ? 0 : System.currentTimeMillis() - qVar.field_createTime <= 86400000 ? 1 : 2;
                                            aVar2.vOa = i4;
                                            aVar2.vOb = pVar.type;
                                            aVar2.vOc = "1_" + f.a(qVar, pVar.url) + ";";
                                            aVar2.vOe = i6;
                                            aVar2.vOf = qVar.field_isExpand ? 1 : 0;
                                            aVar2.vOh = i3;
                                            i4 = (i6 == 0 && qVar.xHT) ? 1 : 0;
                                            aVar2.vOj = i4;
                                            aVar2.vOk = qVar.xHU ? 1 : 0;
                                            f.a(aVar2, qVar.field_talker);
                                            if (!bo.isNullOrNil(pVar.url)) {
                                                Uri parse = Uri.parse(pVar.url);
                                                i4 = bo.getInt(parse.getQueryParameter("idx"), 0);
                                                long j = bo.getLong(parse.getQueryParameter("mid"), 0);
                                                aVar2.vNO.add(Integer.valueOf(i4));
                                                aVar2.cuQ = j;
                                                aVar2.vOd = j;
                                            }
                                            if (qVar.field_isExpand) {
                                                aVar2.vNQ = 2;
                                            } else if (b.fjr.size() > 2) {
                                                aVar2.vNQ = 1;
                                            } else {
                                                aVar2.vNQ = 0;
                                            }
                                        } else {
                                            if (i6 == 0) {
                                                if (qVar.xHT) {
                                                    size = 1;
                                                    aVar.vOj = size;
                                                    aVar.vOk = qVar.xHU ? 1 : 0;
                                                    aVar.vNP++;
                                                    aVar.pos = i;
                                                    aVar.vNX = (int) (System.currentTimeMillis() / 1000);
                                                    f.a(aVar, qVar.field_talker);
                                                }
                                            }
                                            size = 0;
                                            aVar.vOj = size;
                                            if (qVar.xHU) {
                                            }
                                            aVar.vOk = qVar.xHU ? 1 : 0;
                                            aVar.vNP++;
                                            aVar.pos = i;
                                            aVar.vNX = (int) (System.currentTimeMillis() / 1000);
                                            f.a(aVar, qVar.field_talker);
                                        }
                                    }
                                    i6++;
                                }
                                AppMethodBeat.o(14170);
                                return;
                            } catch (UnsupportedOperationException e) {
                                ab.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", e.getMessage());
                                AppMethodBeat.o(14170);
                                return;
                            } catch (Exception e2) {
                                ab.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", e2.getMessage());
                            }
                        }
                        AppMethodBeat.o(14170);
                        return;
                    }
                    a aVar3 = (a) fVar.jOf.get(qVar.field_msgId);
                    if (aVar3 == null) {
                        aVar = new a();
                        fVar.jOf.put(qVar.field_msgId, aVar);
                        aVar.vNN = qVar.field_talker;
                        aVar.cuQ = 0;
                        aVar.vNP = 1;
                        aVar.vNX = (int) (System.currentTimeMillis() / 1000);
                        aVar.pos = i;
                        aVar.vNR = 0;
                        aVar.vNT = 0;
                        aVar.vNU = 0;
                        aVar.vNW = 0;
                        aVar.vNr = 0;
                        aVar.vNW = 0;
                        aVar.vNY = (int) (qVar.field_createTime / 1000);
                        size = i2 != 4 ? 0 : System.currentTimeMillis() - qVar.field_createTime <= 86400000 ? 1 : 2;
                        aVar.vOa = size;
                        if (qVar.isText()) {
                            size = 1;
                        } else if (qVar.drE()) {
                            size = 2;
                        } else if (qVar.drD()) {
                            size = 3;
                        } else {
                            size = -1;
                        }
                        aVar.vOb = size;
                        f.a(aVar, qVar.field_talker);
                        aVar.vOh = i3;
                        aVar.vOj = qVar.xHT ? 1 : 0;
                        if (qVar.xHU) {
                            size = 1;
                        } else {
                            size = 0;
                        }
                        aVar.vOk = size;
                        AppMethodBeat.o(14170);
                        return;
                    }
                    aVar3.vNP++;
                    aVar3.pos = i;
                    aVar3.vNX = (int) (System.currentTimeMillis() / 1000);
                    f.a(aVar3, qVar.field_talker);
                    aVar3.vOj = qVar.xHT ? 1 : 0;
                    if (qVar.xHU) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    aVar3.vOk = i4;
                }
                AppMethodBeat.o(14170);
            }
        }, 0);
        AppMethodBeat.o(14175);
    }

    static int a(q qVar, String str) {
        AppMethodBeat.i(14176);
        if (qVar.field_appMsgStatInfoProto == null || bo.isNullOrNil(str) || bo.ek(qVar.field_appMsgStatInfoProto.vGJ)) {
            AppMethodBeat.o(14176);
            return 0;
        }
        int i;
        Iterator it = qVar.field_appMsgStatInfoProto.vGJ.iterator();
        while (it.hasNext()) {
            eu euVar = (eu) it.next();
            if (bo.isEqual(euVar.url, str)) {
                i = euVar.vGI;
                break;
            }
        }
        i = 0;
        AppMethodBeat.o(14176);
        return i;
    }

    static void a(a aVar, String str) {
        AppMethodBeat.i(14177);
        if (((j) g.K(j.class)).XM().aoO(str).Oe()) {
            aVar.vNV = 1;
            aVar.vNZ = 1;
            AppMethodBeat.o(14177);
            return;
        }
        aVar.vNV = 0;
        aVar.vNZ = 0;
        AppMethodBeat.o(14177);
    }

    public final void a(q qVar, boolean z) {
        AppMethodBeat.i(14178);
        a aVar = (a) this.jOf.get(Long.valueOf(qVar.field_msgId));
        if (aVar == null) {
            AppMethodBeat.o(14178);
            return;
        }
        aVar.vNr = z ? 1 : 2;
        AppMethodBeat.o(14178);
    }

    public final void d(q qVar, int i) {
        AppMethodBeat.i(14179);
        a(qVar, 0, i, -1);
        AppMethodBeat.o(14179);
    }

    public final void a(q qVar, int i, int i2, int i3) {
        AppMethodBeat.i(14180);
        final q qVar2 = qVar;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                int i;
                long j = 0;
                AppMethodBeat.i(14173);
                if (qVar2.drC()) {
                    try {
                        int i2;
                        o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(qVar2.field_msgId, qVar2.field_content);
                        if (!(b == null || bo.ek(b.fjr))) {
                            p pVar = (p) b.fjr.get(i4);
                            if (!bo.isNullOrNil(pVar.url)) {
                                Uri parse = Uri.parse(pVar.url);
                                j = bo.getLong(parse.getQueryParameter("mid"), 0);
                                i2 = bo.getInt(parse.getQueryParameter("idx"), 0);
                                i = i2;
                                f.this.a(qVar2.field_talker, j, i, i5, i6);
                                AppMethodBeat.o(14173);
                            }
                        }
                        i2 = 0;
                        i = i2;
                    } catch (UnsupportedOperationException e) {
                        ab.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", e.getMessage());
                        i = 0;
                    } catch (Exception e2) {
                        ab.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", e2.getMessage());
                    }
                    f.this.a(qVar2.field_talker, j, i, i5, i6);
                    AppMethodBeat.o(14173);
                }
                i = 0;
                f.this.a(qVar2.field_talker, j, i, i5, i6);
                AppMethodBeat.o(14173);
            }
        }, 0);
        AppMethodBeat.o(14180);
    }

    public final void si(int i) {
        AppMethodBeat.i(14181);
        a("", 0, 0, i, -1);
        AppMethodBeat.o(14181);
    }

    public final void a(String str, long j, int i, int i2, int i3) {
        AppMethodBeat.i(14182);
        if (i3 <= 0) {
            i3 = (int) (System.currentTimeMillis() / 1000);
        }
        h.pYm.e(15721, str, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.ctE), Integer.valueOf(i));
        AppMethodBeat.o(14182);
    }
}
