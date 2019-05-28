package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p926b.C20026g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C15337eu;
import com.tencent.p177mm.protocal.protobuf.C44138ks;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40635r;
import com.tencent.p177mm.storage.C46627q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.f */
public final class C20055f {
    int ctE;
    int jOd;
    int jOe;
    HashMap<String, C11243a> jOf = new HashMap();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.f$a */
    static class C11243a extends C44138ks {
        private C11243a() {
        }

        /* synthetic */ C11243a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.f$3 */
    class C200563 implements Runnable {
        final /* synthetic */ long jOi;
        final /* synthetic */ int jOj;

        C200563(long j, int i) {
            this.jOi = j;
            this.jOj = i;
        }

        public final void run() {
            int i;
            int i2;
            AppMethodBeat.m2504i(14172);
            C40635r aeX = C41747z.aeX();
            Cursor a = aeX.fni.mo10104a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= ".concat(String.valueOf(this.jOi & -4294967296L)), null, 0);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
            int mG = C41747z.aeX().mo64117mG(this.jOi);
            C40635r aeX2 = C41747z.aeX();
            Cursor a2 = aeX2.fni.mo10104a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (this.jOi & -4294967296L) + " and placeTop = 1 ", null, 0);
            if (a2.moveToFirst()) {
                i2 = a2.getInt(0);
            } else {
                i2 = 0;
            }
            a2.close();
            int baS = C41747z.aeY().baS();
            C7060h.pYm.mo8381e(11404, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(mG), Integer.valueOf(i2), Integer.valueOf(baS), Integer.valueOf(C20055f.this.ctE), Integer.valueOf(C20055f.this.ctE), Integer.valueOf(this.jOj));
            C4990ab.m7417i("MicroMsg.BizTimeLineReport", "reportEnterBiz %d|%d|%d|%d|%d|%d|%d", Integer.valueOf(i), Integer.valueOf(mG), Integer.valueOf(i2), Integer.valueOf(baS), Integer.valueOf(C20055f.this.ctE), Integer.valueOf(C20055f.this.ctE), Integer.valueOf(this.jOj));
            AppMethodBeat.m2505o(14172);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.f$2 */
    class C200582 implements Runnable {
        C200582() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14171);
            LinkedList linkedList = new LinkedList();
            for (Entry value : C20055f.this.jOf.entrySet()) {
                linkedList.add((C11243a) value.getValue());
            }
            C1720g.m3535RO().eJo.mo14541a(new C20026g(linkedList, C20055f.this.jOd, C20055f.this.jOe, C20055f.this.ctE), 0);
            AppMethodBeat.m2505o(14171);
        }
    }

    public C20055f(int i) {
        AppMethodBeat.m2504i(14174);
        this.ctE = i;
        AppMethodBeat.m2505o(14174);
    }

    /* renamed from: c */
    public final void mo35303c(C46627q c46627q, int i) {
        AppMethodBeat.m2504i(14175);
        final int i2 = c46627q.field_status;
        final int i3 = c46627q.field_isRead;
        final C46627q c46627q2 = c46627q;
        final int i4 = i;
        C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:72:0x01f4  */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x01d6 A:{Catch:{ UnsupportedOperationException -> 0x018f, Exception -> 0x01ae }} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.m2504i(14170);
                C20055f c20055f = C20055f.this;
                C46627q c46627q = c46627q2;
                int i = i4;
                int i2 = i2;
                int i3 = i3;
                if (c46627q != null) {
                    int size;
                    C11243a c11243a;
                    int i4;
                    if (c46627q.drC()) {
                        if (c46627q.drC()) {
                            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c46627q.field_msgId, c46627q.field_content);
                            if (b == null || C5046bo.m7548ek(b.fjr)) {
                                AppMethodBeat.m2505o(14170);
                                return;
                            }
                            try {
                                int i5;
                                size = b.fjr.size();
                                if (size <= 2 || c46627q.field_isExpand) {
                                    i5 = size;
                                } else {
                                    i5 = 2;
                                }
                                int i6 = 0;
                                while (i6 < i5) {
                                    C32224p c32224p = (C32224p) b.fjr.get(i6);
                                    if (c32224p != null) {
                                        c11243a = (C11243a) c20055f.jOf.get(c46627q.field_msgId + "_" + i6);
                                        if (c11243a == null) {
                                            C11243a c11243a2 = new C11243a();
                                            c20055f.jOf.put(c46627q.field_msgId + "_" + i6, c11243a2);
                                            c11243a2.vNN = c46627q.field_talker;
                                            c11243a2.vNP = 1;
                                            c11243a2.vNX = (int) (System.currentTimeMillis() / 1000);
                                            c11243a2.pos = i;
                                            c11243a2.vNR = 0;
                                            c11243a2.vNT = 0;
                                            c11243a2.vNU = 0;
                                            c11243a2.vNW = 0;
                                            c11243a2.vNr = 0;
                                            c11243a2.vNW = 0;
                                            c11243a2.vNY = (int) (c46627q.field_createTime / 1000);
                                            i4 = i2 != 4 ? 0 : System.currentTimeMillis() - c46627q.field_createTime <= 86400000 ? 1 : 2;
                                            c11243a2.vOa = i4;
                                            c11243a2.vOb = c32224p.type;
                                            c11243a2.vOc = "1_" + C20055f.m30996a(c46627q, c32224p.url) + ";";
                                            c11243a2.vOe = i6;
                                            c11243a2.vOf = c46627q.field_isExpand ? 1 : 0;
                                            c11243a2.vOh = i3;
                                            i4 = (i6 == 0 && c46627q.xHT) ? 1 : 0;
                                            c11243a2.vOj = i4;
                                            c11243a2.vOk = c46627q.xHU ? 1 : 0;
                                            C20055f.m30997a(c11243a2, c46627q.field_talker);
                                            if (!C5046bo.isNullOrNil(c32224p.url)) {
                                                Uri parse = Uri.parse(c32224p.url);
                                                i4 = C5046bo.getInt(parse.getQueryParameter("idx"), 0);
                                                long j = C5046bo.getLong(parse.getQueryParameter("mid"), 0);
                                                c11243a2.vNO.add(Integer.valueOf(i4));
                                                c11243a2.cuQ = j;
                                                c11243a2.vOd = j;
                                            }
                                            if (c46627q.field_isExpand) {
                                                c11243a2.vNQ = 2;
                                            } else if (b.fjr.size() > 2) {
                                                c11243a2.vNQ = 1;
                                            } else {
                                                c11243a2.vNQ = 0;
                                            }
                                        } else {
                                            if (i6 == 0) {
                                                if (c46627q.xHT) {
                                                    size = 1;
                                                    c11243a.vOj = size;
                                                    c11243a.vOk = c46627q.xHU ? 1 : 0;
                                                    c11243a.vNP++;
                                                    c11243a.pos = i;
                                                    c11243a.vNX = (int) (System.currentTimeMillis() / 1000);
                                                    C20055f.m30997a(c11243a, c46627q.field_talker);
                                                }
                                            }
                                            size = 0;
                                            c11243a.vOj = size;
                                            if (c46627q.xHU) {
                                            }
                                            c11243a.vOk = c46627q.xHU ? 1 : 0;
                                            c11243a.vNP++;
                                            c11243a.pos = i;
                                            c11243a.vNX = (int) (System.currentTimeMillis() / 1000);
                                            C20055f.m30997a(c11243a, c46627q.field_talker);
                                        }
                                    }
                                    i6++;
                                }
                                AppMethodBeat.m2505o(14170);
                                return;
                            } catch (UnsupportedOperationException e) {
                                C4990ab.m7421w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", e.getMessage());
                                AppMethodBeat.m2505o(14170);
                                return;
                            } catch (Exception e2) {
                                C4990ab.m7421w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", e2.getMessage());
                            }
                        }
                        AppMethodBeat.m2505o(14170);
                        return;
                    }
                    C11243a c11243a3 = (C11243a) c20055f.jOf.get(c46627q.field_msgId);
                    if (c11243a3 == null) {
                        c11243a = new C11243a();
                        c20055f.jOf.put(c46627q.field_msgId, c11243a);
                        c11243a.vNN = c46627q.field_talker;
                        c11243a.cuQ = 0;
                        c11243a.vNP = 1;
                        c11243a.vNX = (int) (System.currentTimeMillis() / 1000);
                        c11243a.pos = i;
                        c11243a.vNR = 0;
                        c11243a.vNT = 0;
                        c11243a.vNU = 0;
                        c11243a.vNW = 0;
                        c11243a.vNr = 0;
                        c11243a.vNW = 0;
                        c11243a.vNY = (int) (c46627q.field_createTime / 1000);
                        size = i2 != 4 ? 0 : System.currentTimeMillis() - c46627q.field_createTime <= 86400000 ? 1 : 2;
                        c11243a.vOa = size;
                        if (c46627q.isText()) {
                            size = 1;
                        } else if (c46627q.drE()) {
                            size = 2;
                        } else if (c46627q.drD()) {
                            size = 3;
                        } else {
                            size = -1;
                        }
                        c11243a.vOb = size;
                        C20055f.m30997a(c11243a, c46627q.field_talker);
                        c11243a.vOh = i3;
                        c11243a.vOj = c46627q.xHT ? 1 : 0;
                        if (c46627q.xHU) {
                            size = 1;
                        } else {
                            size = 0;
                        }
                        c11243a.vOk = size;
                        AppMethodBeat.m2505o(14170);
                        return;
                    }
                    c11243a3.vNP++;
                    c11243a3.pos = i;
                    c11243a3.vNX = (int) (System.currentTimeMillis() / 1000);
                    C20055f.m30997a(c11243a3, c46627q.field_talker);
                    c11243a3.vOj = c46627q.xHT ? 1 : 0;
                    if (c46627q.xHU) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    c11243a3.vOk = i4;
                }
                AppMethodBeat.m2505o(14170);
            }
        }, 0);
        AppMethodBeat.m2505o(14175);
    }

    /* renamed from: a */
    static int m30996a(C46627q c46627q, String str) {
        AppMethodBeat.m2504i(14176);
        if (c46627q.field_appMsgStatInfoProto == null || C5046bo.isNullOrNil(str) || C5046bo.m7548ek(c46627q.field_appMsgStatInfoProto.vGJ)) {
            AppMethodBeat.m2505o(14176);
            return 0;
        }
        int i;
        Iterator it = c46627q.field_appMsgStatInfoProto.vGJ.iterator();
        while (it.hasNext()) {
            C15337eu c15337eu = (C15337eu) it.next();
            if (C5046bo.isEqual(c15337eu.url, str)) {
                i = c15337eu.vGI;
                break;
            }
        }
        i = 0;
        AppMethodBeat.m2505o(14176);
        return i;
    }

    /* renamed from: a */
    static void m30997a(C11243a c11243a, String str) {
        AppMethodBeat.m2504i(14177);
        if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str).mo16702Oe()) {
            c11243a.vNV = 1;
            c11243a.vNZ = 1;
            AppMethodBeat.m2505o(14177);
            return;
        }
        c11243a.vNV = 0;
        c11243a.vNZ = 0;
        AppMethodBeat.m2505o(14177);
    }

    /* renamed from: a */
    public final void mo35301a(C46627q c46627q, boolean z) {
        AppMethodBeat.m2504i(14178);
        C11243a c11243a = (C11243a) this.jOf.get(Long.valueOf(c46627q.field_msgId));
        if (c11243a == null) {
            AppMethodBeat.m2505o(14178);
            return;
        }
        c11243a.vNr = z ? 1 : 2;
        AppMethodBeat.m2505o(14178);
    }

    /* renamed from: d */
    public final void mo35304d(C46627q c46627q, int i) {
        AppMethodBeat.m2504i(14179);
        mo35300a(c46627q, 0, i, -1);
        AppMethodBeat.m2505o(14179);
    }

    /* renamed from: a */
    public final void mo35300a(C46627q c46627q, int i, int i2, int i3) {
        AppMethodBeat.m2504i(14180);
        final C46627q c46627q2 = c46627q;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                int i;
                long j = 0;
                AppMethodBeat.m2504i(14173);
                if (c46627q2.drC()) {
                    try {
                        int i2;
                        C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c46627q2.field_msgId, c46627q2.field_content);
                        if (!(b == null || C5046bo.m7548ek(b.fjr))) {
                            C32224p c32224p = (C32224p) b.fjr.get(i4);
                            if (!C5046bo.isNullOrNil(c32224p.url)) {
                                Uri parse = Uri.parse(c32224p.url);
                                j = C5046bo.getLong(parse.getQueryParameter("mid"), 0);
                                i2 = C5046bo.getInt(parse.getQueryParameter("idx"), 0);
                                i = i2;
                                C20055f.this.mo35302a(c46627q2.field_talker, j, i, i5, i6);
                                AppMethodBeat.m2505o(14173);
                            }
                        }
                        i2 = 0;
                        i = i2;
                    } catch (UnsupportedOperationException e) {
                        C4990ab.m7421w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", e.getMessage());
                        i = 0;
                    } catch (Exception e2) {
                        C4990ab.m7421w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", e2.getMessage());
                    }
                    C20055f.this.mo35302a(c46627q2.field_talker, j, i, i5, i6);
                    AppMethodBeat.m2505o(14173);
                }
                i = 0;
                C20055f.this.mo35302a(c46627q2.field_talker, j, i, i5, i6);
                AppMethodBeat.m2505o(14173);
            }
        }, 0);
        AppMethodBeat.m2505o(14180);
    }

    /* renamed from: si */
    public final void mo35305si(int i) {
        AppMethodBeat.m2504i(14181);
        mo35302a("", 0, 0, i, -1);
        AppMethodBeat.m2505o(14181);
    }

    /* renamed from: a */
    public final void mo35302a(String str, long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(14182);
        if (i3 <= 0) {
            i3 = (int) (System.currentTimeMillis() / 1000);
        }
        C7060h.pYm.mo8381e(15721, str, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.ctE), Integer.valueOf(i));
        AppMethodBeat.m2505o(14182);
    }
}
