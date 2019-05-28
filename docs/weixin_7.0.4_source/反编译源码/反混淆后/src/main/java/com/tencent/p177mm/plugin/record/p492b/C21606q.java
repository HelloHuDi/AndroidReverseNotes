package com.tencent.p177mm.plugin.record.p492b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.record.p1016a.C12979h;
import com.tencent.p177mm.plugin.record.p1016a.C16844j;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p1016a.C43427d;
import com.tencent.p177mm.plugin.record.p1016a.C43429f;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.record.b.q */
public final class C21606q implements C1202f, C43427d, C12979h {
    SparseArray<C21613e> pJA = new SparseArray();
    LinkedList<C16844j> pJB = new LinkedList();
    private int pJR = 7;
    boolean pJx = false;

    /* renamed from: com.tencent.mm.plugin.record.b.q$a */
    class C12986a implements Runnable {
        private C16844j pJu;

        public C12986a(C16844j c16844j) {
            this.pJu = c16844j;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0283  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Object obj;
            AppMethodBeat.m2504i(135724);
            Object obj2 = null;
            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", Long.valueOf(this.pJu.field_msgId));
            if (this.pJu == null || this.pJu.field_dataProto == null || this.pJu.field_dataProto.wiv == null) {
                obj = null;
            } else {
                Iterator it = this.pJu.field_dataProto.wiv.iterator();
                obj = null;
                while (it.hasNext()) {
                    String str;
                    String c;
                    Object obj3;
                    C34792i VH;
                    aar aar = (aar) it.next();
                    if (!C5046bo.isNullOrNil(aar.wfZ) || C5730e.m8628ct(aar.wgx)) {
                        str = aar.wgx;
                        c = C43436n.m77558c(aar, this.pJu.field_msgId);
                        C4990ab.m7411d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", aar.wfZ, str, c, Boolean.valueOf(C5730e.m8644y(str, c) > 0));
                        if (C5730e.m8644y(str, c) > 0) {
                            if (C5046bo.isNullOrNil(aar.wgq)) {
                                C4990ab.m7416i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
                                aar.akS(C5730e.atg(c));
                                obj2 = 1;
                            }
                            if (C5046bo.isNullOrNil(aar.wgs)) {
                                C4990ab.m7416i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
                                byte[] e = C5730e.m8632e(c, 0, 256);
                                aar.akT(e == null ? null : C1178g.m2591x(e));
                                obj3 = 1;
                                if (C5730e.asZ(c) != 0) {
                                    aar.mo27431mf(C5730e.asZ(c));
                                }
                                str = C43436n.m77564h(aar.mnd, this.pJu.field_msgId, false);
                                VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(str);
                                if (VH != null) {
                                    C34792i c34792i = new C34792i();
                                    c34792i.field_cdnKey = aar.wgb;
                                    c34792i.field_cdnUrl = aar.wfZ;
                                    c34792i.field_dataId = aar.mnd;
                                    c34792i.field_mediaId = str;
                                    c34792i.field_totalLen = (int) aar.wgu;
                                    c34792i.field_localId = c34792i.field_mediaId.hashCode();
                                    c34792i.field_path = C43436n.m77558c(aar, this.pJu.field_msgId);
                                    c34792i.field_type = 2;
                                    c34792i.field_fileType = C43436n.m77545BH(aar.dataType);
                                    c34792i.field_recordLocalId = this.pJu.field_localId;
                                    c34792i.field_toUser = this.pJu.field_toUser;
                                    c34792i.field_isThumb = false;
                                    boolean b = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37084b(c34792i);
                                    obj = 1;
                                    C4990ab.m7417i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", Integer.valueOf(c34792i.field_localId), Boolean.valueOf(b), Integer.valueOf(c34792i.field_fileType), str);
                                } else if (!(VH.field_status == 2 || VH.field_status == 3 || VH.field_status == 4 || VH.field_status == -1)) {
                                    C4990ab.m7417i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", Integer.valueOf(VH.field_status));
                                    obj = 1;
                                }
                            }
                        }
                        obj3 = obj2;
                        if (C5730e.asZ(c) != 0) {
                        }
                        str = C43436n.m77564h(aar.mnd, this.pJu.field_msgId, false);
                        VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(str);
                        if (VH != null) {
                        }
                    } else {
                        obj3 = obj2;
                    }
                    if (!C5046bo.isNullOrNil(aar.fgE) || C5730e.m8628ct(aar.wgz)) {
                        str = aar.wgz;
                        c = C43436n.m77562f(aar, this.pJu.field_msgId);
                        C4990ab.m7411d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", str, c, Boolean.valueOf(C5730e.m8644y(str, c) > 0));
                        aar.mo27432mg(C5730e.asZ(c));
                        if (C5730e.m8644y(str, c) > 0) {
                            if (C5046bo.isNullOrNil(aar.wgB)) {
                                C4990ab.m7416i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                                aar.akX(C1178g.m2587cz(c));
                                obj3 = 1;
                            }
                            if (C5046bo.isNullOrNil(aar.wgD)) {
                                C4990ab.m7416i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                                aar.akY(C1178g.m2586cA(c));
                                obj3 = 1;
                            }
                        }
                        str = C43436n.m77546LA(aar.mnd);
                        c = C43436n.m77564h(str, this.pJu.field_msgId, false);
                        VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(c);
                        if (VH == null) {
                            VH = new C34792i();
                            VH.field_cdnKey = aar.wfV;
                            VH.field_cdnUrl = aar.fgE;
                            VH.field_dataId = str;
                            VH.field_mediaId = c;
                            VH.field_totalLen = (int) aar.wgF;
                            VH.field_localId = VH.field_mediaId.hashCode();
                            VH.field_path = C43436n.m77562f(aar, this.pJu.field_msgId);
                            VH.field_type = 2;
                            VH.field_fileType = C42129a.MediaType_FULLSIZEIMAGE;
                            VH.field_recordLocalId = this.pJu.field_localId;
                            VH.field_toUser = this.pJu.field_toUser;
                            VH.field_isThumb = true;
                            boolean b2 = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37084b(VH);
                            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(VH.field_localId), Boolean.valueOf(b2));
                            obj = 1;
                            obj2 = obj3;
                        } else if (!(VH.field_status == 2 || VH.field_status == 3 || VH.field_status == 4 || VH.field_status == -1)) {
                            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "hasInsertCdn, thumb cdnInfo status:%s", Integer.valueOf(VH.field_status));
                            obj = 1;
                        }
                    }
                    obj2 = obj3;
                    obj = obj;
                }
            }
            if (obj2 != null) {
                C4990ab.m7417i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.pJu.field_localId), Long.valueOf(this.pJu.field_msgId), Integer.valueOf(this.pJu.field_type));
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo10103c(this.pJu, "localId");
            }
            if (obj == null) {
                C4990ab.m7416i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
                C21606q.this.mo37088a(this.pJu, false);
                C21606q.this.pJx = false;
                C21606q.this.mo25040a(null);
            }
            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNService().run();
            AppMethodBeat.m2505o(135724);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.q$d */
    class C21608d implements Runnable {
        private C16844j pJu;

        public C21608d(C16844j c16844j) {
            this.pJu = c16844j;
        }

        public final void run() {
            AppMethodBeat.m2504i(135738);
            if (this.pJu.field_dataProto == null) {
                C4990ab.m7420w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
                C21606q.this.pJx = false;
                AppMethodBeat.m2505o(135738);
                return;
            }
            Iterator it = this.pJu.field_dataProto.wiv.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                String c;
                String c2;
                C34792i VH;
                boolean b;
                aar aar = (aar) it.next();
                if (!(C5046bo.isNullOrNil(aar.wfZ) && C5046bo.isNullOrNil(aar.whr))) {
                    c = C43436n.m77558c(aar, this.pJu.field_oriMsgId);
                    c2 = C43436n.m77558c(aar, this.pJu.field_msgId);
                    C4990ab.m7411d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", c, c2, Boolean.valueOf(C5730e.m8644y(c, c2) > 0));
                    if (C5730e.m8644y(c, c2) > 0) {
                        if (C5046bo.isNullOrNil(aar.wgq)) {
                            C4990ab.m7416i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
                            aar.akS(C1178g.m2587cz(c2));
                            z2 = true;
                        }
                        if (C5046bo.isNullOrNil(aar.wgs)) {
                            C4990ab.m7416i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
                            aar.akT(C1178g.m2586cA(c2));
                            z2 = true;
                        }
                    }
                    c = C43436n.m77564h(aar.mnd, this.pJu.field_msgId, false);
                    VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(c);
                    if (VH == null) {
                        C34792i c34792i = new C34792i();
                        c34792i.field_cdnKey = aar.wgb;
                        c34792i.field_cdnUrl = aar.wfZ;
                        c34792i.field_dataId = aar.mnd;
                        c34792i.field_mediaId = c;
                        c34792i.field_totalLen = (int) aar.wgu;
                        c34792i.field_localId = c34792i.field_mediaId.hashCode();
                        c34792i.field_path = C43436n.m77558c(aar, this.pJu.field_msgId);
                        c34792i.field_type = 2;
                        c34792i.field_fileType = C43436n.m77545BH(aar.dataType);
                        c34792i.field_recordLocalId = this.pJu.field_localId;
                        c34792i.field_toUser = this.pJu.field_toUser;
                        c34792i.field_isThumb = false;
                        String c3 = C43436n.m77558c(aar, this.pJu.field_msgId);
                        if (C5046bo.isNullOrNil(aar.whr) || C5730e.m8628ct(c3)) {
                            z = true;
                        } else {
                            c34792i.field_status = -1;
                            m33104a(aar, c3, c);
                        }
                        b = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37084b(c34792i);
                        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d", Integer.valueOf(c34792i.field_localId), Boolean.valueOf(b), Integer.valueOf(c34792i.field_recordLocalId));
                    } else {
                        if (VH.field_status == -1) {
                            m33104a(aar, C43436n.m77558c(aar, this.pJu.field_msgId), c);
                        }
                        if (VH.field_status == 0) {
                            z = true;
                        }
                        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", Integer.valueOf(VH.field_status));
                    }
                }
                if (!(C5046bo.isNullOrNil(aar.fgE) && C5046bo.isNullOrNil(aar.fgv))) {
                    b = C5730e.m8644y(C43436n.m77562f(aar, this.pJu.field_oriMsgId), C43436n.m77562f(aar, this.pJu.field_msgId)) > 0;
                    C4990ab.m7411d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", C43436n.m77562f(aar, this.pJu.field_oriMsgId), C43436n.m77562f(aar, this.pJu.field_msgId), Boolean.valueOf(b));
                    c = C43436n.m77546LA(aar.mnd);
                    c2 = C43436n.m77564h(c, this.pJu.field_msgId, false);
                    VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(c2);
                    String f = C43436n.m77562f(aar, this.pJu.field_msgId);
                    if (VH == null) {
                        C34792i c34792i2 = new C34792i();
                        c34792i2.field_cdnKey = aar.wfV;
                        c34792i2.field_cdnUrl = aar.fgE;
                        c34792i2.field_dataId = c;
                        c34792i2.field_mediaId = c2;
                        c34792i2.field_totalLen = (int) aar.wgF;
                        c34792i2.field_localId = c34792i2.field_mediaId.hashCode();
                        c34792i2.field_path = C43436n.m77562f(aar, this.pJu.field_msgId);
                        c34792i2.field_type = 2;
                        c34792i2.field_fileType = C42129a.MediaType_FULLSIZEIMAGE;
                        c34792i2.field_recordLocalId = this.pJu.field_localId;
                        c34792i2.field_toUser = this.pJu.field_toUser;
                        c34792i2.field_isThumb = true;
                        if (C5046bo.isNullOrNil(aar.fgv) || C5730e.m8628ct(f)) {
                            b = true;
                        } else {
                            c34792i2.field_status = -1;
                            m33105b(aar, f, c2);
                            b = z;
                        }
                        boolean b2 = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37084b(c34792i2);
                        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d", Integer.valueOf(c34792i2.field_localId), Boolean.valueOf(b2), Integer.valueOf(c34792i2.field_recordLocalId));
                        z = b;
                    } else {
                        if (VH.field_status == -1) {
                            m33105b(aar, C43436n.m77562f(aar, this.pJu.field_msgId), c2);
                        }
                        if (VH.field_status == 0) {
                            z = true;
                        }
                        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", Integer.valueOf(VH.field_status));
                    }
                }
                z = z;
            }
            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable infochanged:%s, needRun:%s", Boolean.valueOf(z2), Boolean.valueOf(z));
            if (z2) {
                C4990ab.m7417i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.pJu.field_localId), Long.valueOf(this.pJu.field_msgId), Integer.valueOf(this.pJu.field_type));
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo10103c(this.pJu, "localId");
            }
            if (!z) {
                C4990ab.m7416i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
                C21606q.this.mo37088a(this.pJu, false);
                C21606q.this.pJx = false;
                C21606q.this.mo25040a(null);
            }
            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNService().run();
            AppMethodBeat.m2505o(135738);
        }

        /* renamed from: a */
        private void m33104a(final aar aar, final String str, String str2) {
            AppMethodBeat.m2504i(135739);
            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", aar.mnd, str2, str);
            C42130g c42130g = new C42130g();
            c42130g.field_fileType = 19;
            c42130g.field_authKey = aar.fgA;
            c42130g.field_aesKey = aar.who;
            c42130g.egm = aar.whr;
            c42130g.field_fullpath = str;
            c42130g.field_mediaId = str2;
            c42130g.egl = new C1628a() {
                /* renamed from: a */
                public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                    int i2;
                    AppMethodBeat.m2504i(135736);
                    if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", aar.mnd, str, str);
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!(i == 0 && (c9545d == null || c9545d.field_retCode == 0))) {
                        String str2 = "MicroMsg.RecordMsgSendService";
                        String str3 = "[record] downloadTpUrl error id:%s, mediaId:%s, path:%s, err:(%d,%d)";
                        Object[] objArr = new Object[5];
                        objArr[0] = aar.mnd;
                        objArr[1] = str;
                        objArr[2] = str;
                        objArr[3] = Integer.valueOf(i);
                        objArr[4] = Integer.valueOf(c9545d == null ? 0 : c9545d.field_retCode);
                        C4990ab.m7413e(str2, str3, objArr);
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(str);
                        VH.field_status = 0;
                        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37081a(VH);
                        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNService().run();
                    }
                    AppMethodBeat.m2505o(135736);
                    return 0;
                }

                /* renamed from: a */
                public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                /* renamed from: l */
                public final byte[] mo5084l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (!C37461f.afx().mo51222b(c42130g, -1)) {
                C4990ab.m7412e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
            }
            AppMethodBeat.m2505o(135739);
        }

        /* renamed from: b */
        private void m33105b(final aar aar, final String str, String str2) {
            AppMethodBeat.m2504i(135740);
            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", aar.mnd, str2, str);
            C42130g c42130g = new C42130g();
            c42130g.field_fileType = 19;
            c42130g.field_authKey = aar.fgA;
            c42130g.field_aesKey = aar.fgB;
            c42130g.egm = aar.fgv;
            c42130g.field_fullpath = str;
            c42130g.field_mediaId = str2;
            c42130g.egl = new C1628a() {
                /* renamed from: a */
                public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                    int i2;
                    AppMethodBeat.m2504i(135737);
                    if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", aar.mnd, str, str);
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!(i == 0 && (c9545d == null || c9545d.field_retCode == 0))) {
                        String str2 = "MicroMsg.RecordMsgSendService";
                        String str3 = "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)";
                        Object[] objArr = new Object[5];
                        objArr[0] = aar.mnd;
                        objArr[1] = str;
                        objArr[2] = str;
                        objArr[3] = Integer.valueOf(i);
                        objArr[4] = Integer.valueOf(c9545d == null ? 0 : c9545d.field_retCode);
                        C4990ab.m7413e(str2, str3, objArr);
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(str);
                        VH.field_status = 0;
                        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37081a(VH);
                        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNService().run();
                    }
                    AppMethodBeat.m2505o(135737);
                    return 0;
                }

                /* renamed from: a */
                public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                /* renamed from: l */
                public final byte[] mo5084l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (!C37461f.afx().mo51222b(c42130g, -1)) {
                C4990ab.m7412e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
            }
            AppMethodBeat.m2505o(135740);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.q$b */
    class C21611b implements C1202f, C9721a, Runnable {
        private boolean cco = false;
        /* renamed from: i */
        private int f4391i = 0;
        HashMap<Long, Boolean> pJP = new HashMap();
        HashMap<Long, String> pJU = new HashMap();
        private C16844j pJu;

        /* renamed from: a */
        static /* synthetic */ void m33113a(C21611b c21611b, HashMap hashMap, boolean z, C16844j c16844j) {
            AppMethodBeat.m2504i(135734);
            c21611b.m33114a(hashMap, z, c16844j);
            AppMethodBeat.m2505o(135734);
        }

        public C21611b(C16844j c16844j) {
            AppMethodBeat.m2504i(135727);
            this.pJu = c16844j;
            C37961o.all().mo21053a(this, Looper.getMainLooper());
            C1720g.m3535RO().eJo.mo14539a(221, (C1202f) this);
            AppMethodBeat.m2505o(135727);
        }

        public final void run() {
            AppMethodBeat.m2504i(135728);
            this.f4391i = 0;
            this.cco = false;
            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", Long.valueOf(this.pJu.field_msgId));
            Iterator it = this.pJu.field_dataProto.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                final long j = aar.whf;
                if (j > 0) {
                    Object obj;
                    final C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
                    String str = aar.wgx;
                    if (System.currentTimeMillis() - jf.field_createTime <= 259200000 || (!C5046bo.isNullOrNil(str) && C5730e.m8628ct(str))) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", Integer.valueOf(jf.getType()));
                    } else if (aar.dataType == 2) {
                        if (jf.drE()) {
                            int i;
                            final C25822e fI = C32291o.ahl().mo73112fI(jf.field_msgSvrId);
                            if (jf.field_isSend == 1) {
                                int i2;
                                if (fI.agQ()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                i = i2;
                            } else if (fI.agQ()) {
                                if (C5730e.m8628ct(C32291o.ahl().mo73118q(C37478f.m63225a(fI).fDz, "", ""))) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            } else {
                                i = 0;
                            }
                            if (fI.offset < fI.frO || fI.frO == 0) {
                                this.pJP.put(Long.valueOf(j), Boolean.FALSE);
                                this.f4391i = this.pJu.field_dataProto.wiv.indexOf(aar);
                                C32291o.ahm().mo33467a(fI.fDy, jf.field_msgId, i, aar, C25738R.drawable.b0p, new C9017a() {
                                    /* renamed from: a */
                                    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
                                    }

                                    /* renamed from: a */
                                    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
                                        AppMethodBeat.m2504i(135725);
                                        boolean z = i3 == 0 && i4 == 0;
                                        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4));
                                        if (obj instanceof aar) {
                                            aar aar = (aar) obj;
                                            aar.akV(C32291o.ahl().mo73118q(C37478f.m63227c(fI), "", ""));
                                            aar.akW(C32291o.ahl().mo73074I(jf.field_imgPath, true));
                                            Map z2 = C5049br.m7595z(fI.fDK, "msg");
                                            if (z2 != null) {
                                                aar.akL((String) z2.get(".msg.img.$cdnbigimgurl"));
                                                aar.mo27431mf((long) C5046bo.getInt((String) z2.get(".msg.img.$length"), 0));
                                                aar.akM((String) z2.get(".msg.img.$aeskey"));
                                                C21611b.this.pJu.field_dataProto.wiv.set(C21611b.this.f4391i, aar);
                                            } else {
                                                C4990ab.m7417i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", fI.fDK);
                                            }
                                            C21611b.this.pJP.put(Long.valueOf(aar.whf), Boolean.TRUE);
                                        } else {
                                            C21611b.this.pJP.put(Long.valueOf(j), Boolean.TRUE);
                                        }
                                        C21611b.m33113a(C21611b.this, C21611b.this.pJP, C21611b.this.cco, C21611b.this.pJu);
                                        AppMethodBeat.m2505o(135725);
                                    }

                                    /* renamed from: a */
                                    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
                                        AppMethodBeat.m2504i(135726);
                                        C21611b.this.pJP.put(Long.valueOf(j), Boolean.TRUE);
                                        C21611b.m33113a(C21611b.this, C21611b.this.pJP, C21611b.this.cco, C21611b.this.pJu);
                                        AppMethodBeat.m2505o(135726);
                                    }
                                });
                            }
                        } else if (jf.dtA()) {
                            m33115af(jf);
                        }
                    } else if (aar.dataType == 4 || aar.dataType == 15) {
                        C26493s ut = C26494u.m42268ut(jf.field_imgPath);
                        if (!(ut == null || ut.status == 199)) {
                            this.pJP.put(Long.valueOf(j), Boolean.FALSE);
                            if (ut.aly()) {
                                C4990ab.m7416i("MicroMsg.RecordMsgSendService", "start complete online video");
                                C26494u.m42259uA(jf.field_imgPath);
                            } else {
                                C4990ab.m7416i("MicroMsg.RecordMsgSendService", "start complete offline video");
                                C26494u.m42264up(jf.field_imgPath);
                            }
                        }
                    } else if (aar.dataType == 8 && !C5046bo.isNullOrNil(aar.whr)) {
                        m33115af(jf);
                    }
                }
            }
            this.cco = true;
            C21606q.this.pJx = false;
            m33114a(this.pJP, this.cco, this.pJu);
            AppMethodBeat.m2505o(135728);
        }

        /* renamed from: a */
        public final void mo11381a(C9718a c9718a) {
            AppMethodBeat.m2504i(135729);
            C26493s ut = C26494u.m42268ut(c9718a.fileName);
            if (ut != null) {
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) ut.fXe);
                if (ut.alz()) {
                    this.pJP.put(Long.valueOf(jf.field_msgId), Boolean.TRUE);
                    m33114a(this.pJP, this.cco, this.pJu);
                }
                AppMethodBeat.m2505o(135729);
                return;
            }
            m33114a(null, this.cco, this.pJu);
            AppMethodBeat.m2505o(135729);
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(135730);
            if (c1207m instanceof C43432e) {
                C1720g.m3535RO().eJo.mo14546b(221, (C1202f) this);
                if (this.pJU != null) {
                    for (Entry entry : this.pJU.entrySet()) {
                        long longValue = ((Long) entry.getKey()).longValue();
                        String str2 = (String) entry.getValue();
                        if (longValue > 0 && !((Boolean) this.pJP.get(Long.valueOf(longValue))).booleanValue()) {
                            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(longValue);
                            C30065b i3 = C21595a.m33070i(str2, longValue);
                            if (i3 != null) {
                                str2 = i3.field_fileFullPath;
                            } else {
                                str2 = null;
                            }
                            if (str2 != null && str2.length() > 0) {
                                this.pJP.put(Long.valueOf(longValue), Boolean.TRUE);
                                Iterator it = this.pJu.field_dataProto.wiv.iterator();
                                while (it.hasNext()) {
                                    aar aar = (aar) it.next();
                                    if (aar.whf == longValue) {
                                        aar.akV(i3.field_fileFullPath);
                                    }
                                }
                            }
                        }
                    }
                }
                m33114a(this.pJP, this.cco, this.pJu);
                AppMethodBeat.m2505o(135730);
                return;
            }
            m33114a(null, this.cco, this.pJu);
            AppMethodBeat.m2505o(135730);
        }

        /* renamed from: a */
        private void m33114a(HashMap<Long, Boolean> hashMap, boolean z, C16844j c16844j) {
            AppMethodBeat.m2504i(135732);
            if (C21611b.m33118n(hashMap) && z) {
                C37961o.all().mo21052a(this);
                c16844j.field_type = 2;
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo10103c(c16844j, "localId");
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgService().mo25040a(c16844j);
            }
            AppMethodBeat.m2505o(135732);
        }

        /* renamed from: n */
        private static boolean m33118n(HashMap<Long, Boolean> hashMap) {
            AppMethodBeat.m2504i(135733);
            if (hashMap == null) {
                AppMethodBeat.m2505o(135733);
                return true;
            }
            for (Entry value : hashMap.entrySet()) {
                if (!((Boolean) value.getValue()).booleanValue()) {
                    AppMethodBeat.m2505o(135733);
                    return false;
                }
            }
            AppMethodBeat.m2505o(135733);
            return true;
        }

        /* renamed from: af */
        private void m33115af(C7620bi c7620bi) {
            AppMethodBeat.m2504i(135731);
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (me == null) {
                C4990ab.m7413e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", c7620bi.field_content);
                AppMethodBeat.m2505o(135731);
                return;
            }
            if (C5046bo.isNullOrNil(me.csD) && !C5046bo.isNullOrNil(me.fgD)) {
                C4990ab.m7413e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", c7620bi.field_content);
                me.csD = me.fgD.hashCode();
            }
            String str = me.csD;
            if (!C21595a.m33068a(c7620bi, C21595a.m33070i(str, c7620bi.field_msgId))) {
                this.pJP.put(Long.valueOf(c7620bi.field_msgId), Boolean.FALSE);
                this.pJU.put(Long.valueOf(c7620bi.field_msgId), str);
                C21595a.m33069af(c7620bi);
            }
            AppMethodBeat.m2505o(135731);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.q$c */
    class C21612c implements Runnable {
        private C16844j pJu;

        public C21612c(C16844j c16844j) {
            this.pJu = c16844j;
        }

        public final void run() {
            AppMethodBeat.m2504i(135735);
            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", Long.valueOf(this.pJu.field_msgId));
            Iterator it = this.pJu.field_dataProto.wiv.iterator();
            int i = 0;
            while (it.hasNext()) {
                String c;
                aar aar = (aar) it.next();
                C37721gh c37721gh = new C37721gh();
                c37721gh.cAH.type = 2;
                c37721gh.cAH.cAJ = aar;
                C4879a.xxA.mo10055m(c37721gh);
                C4990ab.m7411d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", aar.mnd, Integer.valueOf(aar.dataType));
                if (!C5046bo.isNullOrNil(c37721gh.cAI.path)) {
                    c = C43436n.m77558c(aar, this.pJu.field_msgId);
                    C4990ab.m7411d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", c37721gh.cAI.path, c);
                    if (!c37721gh.cAI.path.equals(c)) {
                        C5730e.m8644y(c37721gh.cAI.path, c);
                    }
                }
                if (!C5046bo.isNullOrNil(c37721gh.cAI.thumbPath)) {
                    c = C43436n.m77562f(aar, this.pJu.field_msgId);
                    C4990ab.m7411d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", c37721gh.cAI.thumbPath, c);
                    if (!c37721gh.cAI.thumbPath.equals(c)) {
                        C5730e.m8644y(c37721gh.cAI.thumbPath, c);
                    }
                }
                if (aar.dataType == 3) {
                    C4990ab.m7420w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
                    aar.akM("");
                    aar.akL("");
                    aar.akK("");
                    aar.akJ("");
                }
                if (!C5046bo.isNullOrNil(aar.wfZ) || !C5046bo.isNullOrNil(aar.fgE)) {
                    i = 1;
                }
            }
            if (i != 0) {
                C1720g.m3535RO().eJo.mo14541a(new C21600f(this.pJu), 0);
                AppMethodBeat.m2505o(135735);
                return;
            }
            C21606q.this.mo37090d(this.pJu.field_msgId, this.pJu.field_localId, C8910b.m16061a(C43436n.m77551a(this.pJu.field_title, this.pJu.field_desc, this.pJu.field_dataProto), null, null));
            C21606q.this.pJx = false;
            C21606q.this.mo25040a(null);
            AppMethodBeat.m2505o(135735);
        }
    }

    /* renamed from: com.tencent.mm.plugin.record.b.q$e */
    static final class C21613e {
        int ghB;
        long pJE;

        private C21613e() {
            AppMethodBeat.m2504i(135741);
            this.pJE = SystemClock.elapsedRealtime();
            this.ghB = 3;
            AppMethodBeat.m2505o(135741);
        }

        /* synthetic */ C21613e(byte b) {
            this();
        }
    }

    public C21606q() {
        AppMethodBeat.m2504i(135742);
        C1720g.m3535RO().eJo.mo14539a(632, (C1202f) this);
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37080a((C43427d) this);
        this.pJR = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_recordmsg_send_waiting_time, 7);
        AppMethodBeat.m2505o(135742);
    }

    /* renamed from: a */
    public final void mo25040a(final C16844j c16844j) {
        AppMethodBeat.m2504i(135743);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:49:0x01d9  */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0181  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.m2504i(135722);
                if (c16844j != null) {
                    if (((C21613e) C21606q.this.pJA.get(c16844j.field_localId)) == null) {
                        C4990ab.m7411d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", Integer.valueOf(c16844j.field_localId), Long.valueOf(c16844j.field_msgId));
                        C21606q.this.pJA.put(c16844j.field_localId, new C21613e());
                    }
                    C21606q.this.mo37089b(c16844j);
                }
                C21606q c21606q = C21606q.this;
                if (c21606q.pJx) {
                    C4990ab.m7416i("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
                    AppMethodBeat.m2505o(135722);
                    return;
                }
                C16844j c16844j;
                C21613e c21613e;
                if (c21606q.pJB.isEmpty()) {
                    C4990ab.m7420w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
                    for (C16844j c16844j2 : ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().ceB()) {
                        if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c16844j2.field_msgId).getType() != 49) {
                            C4990ab.m7421w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", Integer.valueOf(c16844j2.field_localId), Long.valueOf(c16844j2.field_msgId));
                            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo68995BF(c16844j2.field_localId);
                        } else {
                            c21613e = (C21613e) c21606q.pJA.get(c16844j2.field_localId);
                            if (c21613e == null) {
                                c21606q.pJA.put(c16844j2.field_localId, new C21613e());
                            } else if (c21613e.ghB >= 0 || SystemClock.elapsedRealtime() - c21613e.pJE >= 300000) {
                                if (c21613e.ghB < 0) {
                                    c21613e.ghB = 3;
                                }
                            }
                            C4990ab.m7411d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", Integer.valueOf(c16844j2.field_localId), Long.valueOf(c16844j2.field_msgId));
                            c21606q.mo37089b(c16844j2);
                        }
                    }
                }
                if (c21606q.pJB.isEmpty()) {
                    C4990ab.m7420w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
                    c21606q.finish();
                    AppMethodBeat.m2505o(135722);
                    return;
                }
                int i;
                c16844j2 = (C16844j) c21606q.pJB.removeFirst();
                c21613e = (C21613e) c21606q.pJA.get(c16844j2.field_localId);
                if (c21613e == null) {
                    c21613e = new C21613e();
                    c21606q.pJA.put(c16844j2.field_localId, c21613e);
                }
                c21613e.ghB--;
                if (c21613e.ghB < 0) {
                    if (300000 > SystemClock.elapsedRealtime() - c21613e.pJE) {
                        i = 0;
                        if (i == 0) {
                            c21606q.pJx = true;
                            switch (c16844j2.field_type) {
                                case 0:
                                    C7305d.post(new C21608d(c16844j2), "RecordMsgSendService_normalDataCopy");
                                    AppMethodBeat.m2505o(135722);
                                    return;
                                case 1:
                                    C7305d.post(new C21612c(c16844j2), "RecordMsgSendService_favDataCopy");
                                    AppMethodBeat.m2505o(135722);
                                    return;
                                case 2:
                                    C7305d.post(new C12986a(c16844j2), "RecordMsgSendService_chatDataCopy");
                                    AppMethodBeat.m2505o(135722);
                                    return;
                                case 3:
                                    C7305d.post(new C21611b(c16844j2), "RecordMsgSendService_chatDataDownLoad");
                                    AppMethodBeat.m2505o(135722);
                                    return;
                                default:
                                    c21606q.pJx = false;
                                    AppMethodBeat.m2505o(135722);
                                    return;
                            }
                        }
                        c21606q.mo25040a(null);
                        AppMethodBeat.m2505o(135722);
                        return;
                    }
                    c21613e.ghB = 2;
                }
                c21613e.pJE = SystemClock.elapsedRealtime();
                i = 1;
                if (i == 0) {
                }
            }

            public final String toString() {
                AppMethodBeat.m2504i(135723);
                String str = super.toString() + "|run";
                AppMethodBeat.m2505o(135723);
                return str;
            }
        });
        AppMethodBeat.m2505o(135743);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo37089b(C16844j c16844j) {
        AppMethodBeat.m2504i(135744);
        if (!this.pJB.contains(c16844j)) {
            this.pJB.add(c16844j);
        }
        AppMethodBeat.m2505o(135744);
    }

    public final void finish() {
        AppMethodBeat.m2504i(135745);
        this.pJB.clear();
        this.pJA.clear();
        this.pJx = false;
        AppMethodBeat.m2505o(135745);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(135746);
        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m == null) {
            C4990ab.m7420w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
            AppMethodBeat.m2505o(135746);
            return;
        }
        switch (c1207m.getType()) {
            case 632:
                Iterator it;
                aar aar;
                C4990ab.m7417i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                C21600f c21600f = (C21600f) c1207m;
                if (i == 3) {
                    Object obj;
                    it = c21600f.pJu.field_dataProto.wiv.iterator();
                    while (it.hasNext()) {
                        aar = (aar) it.next();
                        if (C5046bo.isNullOrNil(aar.wfZ)) {
                            if (!C5046bo.isNullOrNil(aar.fgE)) {
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            i = 0;
                            i2 = 0;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                    }
                }
                if (i == 0 && i2 == 0) {
                    mo37090d(c21600f.pJu.field_msgId, c21600f.pJu.field_localId, c21600f.pJt);
                    break;
                }
                C4990ab.m7421w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", Long.valueOf(c21600f.pJu.field_msgId), Integer.valueOf(c21600f.pJu.field_localId));
                C4990ab.m7420w("MicroMsg.RecordMsgSendService", "try upload from local");
                it = c21600f.pJu.field_dataProto.wiv.iterator();
                while (it.hasNext()) {
                    String h;
                    aar = (aar) it.next();
                    if (aar.wgu > 0) {
                        h = C43436n.m77564h(aar.mnd, c21600f.pJu.field_msgId, false);
                        if (((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(h) == null) {
                            C34792i c34792i = new C34792i();
                            c34792i.field_cdnKey = aar.wgb;
                            c34792i.field_cdnUrl = aar.wfZ;
                            c34792i.field_dataId = aar.mnd;
                            c34792i.field_mediaId = h;
                            c34792i.field_totalLen = (int) aar.wgu;
                            c34792i.field_localId = c34792i.field_mediaId.hashCode();
                            c34792i.field_path = C43436n.m77558c(aar, c21600f.pJu.field_msgId);
                            c34792i.field_type = 2;
                            c34792i.field_fileType = C43436n.m77545BH(aar.dataType);
                            c34792i.field_recordLocalId = c21600f.pJu.field_localId;
                            c34792i.field_toUser = c21600f.pJu.field_toUser;
                            c34792i.field_isThumb = false;
                            boolean b = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37084b(c34792i);
                            C4990ab.m7411d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(c34792i.field_localId), Boolean.valueOf(b));
                        }
                    }
                    if (aar.wgF > 0) {
                        h = C43436n.m77546LA(aar.mnd);
                        String h2 = C43436n.m77564h(h, c21600f.pJu.field_msgId, false);
                        if (((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(h2) == null) {
                            C34792i c34792i2 = new C34792i();
                            c34792i2.field_cdnKey = aar.wfV;
                            c34792i2.field_cdnUrl = aar.fgE;
                            c34792i2.field_dataId = h;
                            c34792i2.field_mediaId = h2;
                            c34792i2.field_totalLen = (int) aar.wgF;
                            c34792i2.field_localId = c34792i2.field_mediaId.hashCode();
                            c34792i2.field_path = C43436n.m77562f(aar, c21600f.pJu.field_msgId);
                            c34792i2.field_type = 2;
                            c34792i2.field_fileType = C42129a.MediaType_FULLSIZEIMAGE;
                            c34792i2.field_recordLocalId = c21600f.pJu.field_localId;
                            c34792i2.field_toUser = c21600f.pJu.field_toUser;
                            c34792i2.field_isThumb = true;
                            boolean b2 = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37084b(c34792i2);
                            C4990ab.m7411d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(c34792i2.field_localId), Boolean.valueOf(b2));
                        }
                    }
                }
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNService().run();
                AppMethodBeat.m2505o(135746);
                return;
                break;
        }
        this.pJx = false;
        mo25040a(null);
        AppMethodBeat.m2505o(135746);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo37090d(long j, int i, String str) {
        AppMethodBeat.m2504i(135747);
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
        if (jf.field_msgId == j) {
            jf.setContent(str);
            jf.setStatus(1);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j, jf);
        }
        C8909j ma = C34832a.bYK().mo27204ma(j);
        if (ma != null) {
            ma.field_xml = jf.field_content;
            C34832a.bYK().mo10103c(ma, "msgId");
        }
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo68995BF(i);
        this.pJA.remove(i);
        ((C43429f) C1720g.m3528K(C43429f.class)).mo68985jB(j);
        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.m2505o(135747);
    }

    /* renamed from: a */
    public final void mo25051a(int i, C34792i c34792i) {
        AppMethodBeat.m2504i(135748);
        if (1 != i) {
            C4990ab.m7421w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(135748);
        } else if (c34792i == null) {
            C4990ab.m7420w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
            AppMethodBeat.m2505o(135748);
        } else if (2 != c34792i.field_type) {
            C4990ab.m7421w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", c34792i.field_mediaId, Integer.valueOf(c34792i.field_recordLocalId), Integer.valueOf(c34792i.field_status));
            AppMethodBeat.m2505o(135748);
        } else if (c34792i.field_status == 0 || 1 == c34792i.field_status || -1 == c34792i.field_status) {
            C4990ab.m7420w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
            AppMethodBeat.m2505o(135748);
        } else {
            Object obj;
            List<C34792i> BE = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37078BE(c34792i.field_recordLocalId);
            for (C34792i c34792i2 : BE) {
                if (c34792i2.field_status != 0 && 1 != c34792i2.field_status) {
                    if (-1 == c34792i2.field_status) {
                        C4990ab.m7421w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", c34792i2.field_mediaId);
                        obj = null;
                        break;
                    }
                }
                C4990ab.m7421w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", c34792i2.field_mediaId);
                obj = null;
                break;
            }
            int obj2 = 1;
            C4990ab.m7417i("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", Integer.valueOf(BE.size()));
            if (obj2 == null) {
                AppMethodBeat.m2505o(135748);
                return;
            }
            C16844j BG = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo68996BG(c34792i.field_recordLocalId);
            String str = "MicroMsg.RecordMsgSendService";
            String str2 = "finish get record info, id %d result %B";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(c34792i.field_recordLocalId);
            objArr[1] = Boolean.valueOf(BG != null);
            C4990ab.m7417i(str, str2, objArr);
            if (BG != null) {
                LinkedList<aar> linkedList = BG.field_dataProto.wiv;
                for (C34792i c34792i22 : BE) {
                    C4990ab.m7419v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", c34792i22.field_dataId, Boolean.valueOf(c34792i22.field_isThumb));
                    if (!c34792i22.field_isThumb) {
                        for (aar aar : linkedList) {
                            if (c34792i22.field_dataId.equals(aar.mnd)) {
                                C4990ab.m7411d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", aar.wgb, c34792i22.field_cdnKey, aar.wfZ, c34792i22.field_cdnUrl, Long.valueOf(aar.wgu), Integer.valueOf(c34792i22.field_totalLen));
                                aar.akM(c34792i22.field_cdnKey);
                                aar.akL(c34792i22.field_cdnUrl);
                                break;
                            }
                        }
                    }
                    for (aar aar2 : linkedList) {
                        if (c34792i22.field_dataId.equals(C43436n.m77546LA(aar2.mnd))) {
                            C4990ab.m7411d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", aar2.wfV, c34792i22.field_cdnKey, aar2.fgE, c34792i22.field_cdnUrl, Long.valueOf(aar2.wgF), Integer.valueOf(c34792i22.field_totalLen));
                            aar2.akK(c34792i22.field_cdnKey);
                            aar2.akJ(c34792i22.field_cdnUrl);
                            break;
                        }
                    }
                }
                mo37088a(BG, true);
            }
            for (C34792i c34792i222 : BE) {
                ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37082a(c34792i222, "localId");
            }
            this.pJx = false;
            mo25040a(null);
            AppMethodBeat.m2505o(135748);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo37088a(C16844j c16844j, boolean z) {
        AppMethodBeat.m2504i(135749);
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c16844j.field_msgId);
        C4990ab.m7417i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s", Boolean.FALSE, Long.valueOf(jf.field_msgId), Long.valueOf(c16844j.field_msgId), Integer.valueOf(c16844j.field_localId), Boolean.valueOf(z));
        if (jf.field_msgId == c16844j.field_msgId) {
            jf.setContent(C43436n.m77553a(c16844j.field_title, c16844j.field_desc, c16844j.field_dataProto, c16844j.field_favFrom));
            jf.setStatus(1);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c16844j.field_msgId, jf);
        }
        C8909j ma = C34832a.bYK().mo27204ma(c16844j.field_msgId);
        if (ma != null) {
            ma.field_xml = jf.field_content;
            C34832a.bYK().mo10103c(ma, "msgId");
        }
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgStorage().mo68995BF(c16844j.field_localId);
        this.pJA.remove(c16844j.field_localId);
        if (jf.field_createTime + ((long) (((this.pJR * 24) * 3600) * 1000)) < C1839cb.aaE()) {
            C4990ab.m7416i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + jf.field_createTime);
            jf.setStatus(5);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c16844j.field_msgId, jf);
            AppMethodBeat.m2505o(135749);
            return;
        }
        ((C43429f) C1720g.m3528K(C43429f.class)).mo68985jB(c16844j.field_msgId);
        AppMethodBeat.m2505o(135749);
    }
}
