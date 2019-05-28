package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class q implements f, com.tencent.mm.plugin.record.a.d, h {
    SparseArray<e> pJA = new SparseArray();
    LinkedList<j> pJB = new LinkedList();
    private int pJR = 7;
    boolean pJx = false;

    class a implements Runnable {
        private j pJu;

        public a(j jVar) {
            this.pJu = jVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0283  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Object obj;
            AppMethodBeat.i(135724);
            Object obj2 = null;
            ab.i("MicroMsg.RecordMsgSendService", "dojob ChatDataCopyRunnable, info id:%s", Long.valueOf(this.pJu.field_msgId));
            if (this.pJu == null || this.pJu.field_dataProto == null || this.pJu.field_dataProto.wiv == null) {
                obj = null;
            } else {
                Iterator it = this.pJu.field_dataProto.wiv.iterator();
                obj = null;
                while (it.hasNext()) {
                    String str;
                    String c;
                    Object obj3;
                    i VH;
                    aar aar = (aar) it.next();
                    if (!bo.isNullOrNil(aar.wfZ) || com.tencent.mm.vfs.e.ct(aar.wgx)) {
                        str = aar.wgx;
                        c = n.c(aar, this.pJu.field_msgId);
                        ab.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", aar.wfZ, str, c, Boolean.valueOf(com.tencent.mm.vfs.e.y(str, c) > 0));
                        if (com.tencent.mm.vfs.e.y(str, c) > 0) {
                            if (bo.isNullOrNil(aar.wgq)) {
                                ab.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
                                aar.akS(com.tencent.mm.vfs.e.atg(c));
                                obj2 = 1;
                            }
                            if (bo.isNullOrNil(aar.wgs)) {
                                ab.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
                                byte[] e = com.tencent.mm.vfs.e.e(c, 0, 256);
                                aar.akT(e == null ? null : g.x(e));
                                obj3 = 1;
                                if (com.tencent.mm.vfs.e.asZ(c) != 0) {
                                    aar.mf(com.tencent.mm.vfs.e.asZ(c));
                                }
                                str = n.h(aar.mnd, this.pJu.field_msgId, false);
                                VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(str);
                                if (VH != null) {
                                    i iVar = new i();
                                    iVar.field_cdnKey = aar.wgb;
                                    iVar.field_cdnUrl = aar.wfZ;
                                    iVar.field_dataId = aar.mnd;
                                    iVar.field_mediaId = str;
                                    iVar.field_totalLen = (int) aar.wgu;
                                    iVar.field_localId = iVar.field_mediaId.hashCode();
                                    iVar.field_path = n.c(aar, this.pJu.field_msgId);
                                    iVar.field_type = 2;
                                    iVar.field_fileType = n.BH(aar.dataType);
                                    iVar.field_recordLocalId = this.pJu.field_localId;
                                    iVar.field_toUser = this.pJu.field_toUser;
                                    iVar.field_isThumb = false;
                                    boolean b = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar);
                                    obj = 1;
                                    ab.i("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", Integer.valueOf(iVar.field_localId), Boolean.valueOf(b), Integer.valueOf(iVar.field_fileType), str);
                                } else if (!(VH.field_status == 2 || VH.field_status == 3 || VH.field_status == 4 || VH.field_status == -1)) {
                                    ab.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, cdnInfo status:%s", Integer.valueOf(VH.field_status));
                                    obj = 1;
                                }
                            }
                        }
                        obj3 = obj2;
                        if (com.tencent.mm.vfs.e.asZ(c) != 0) {
                        }
                        str = n.h(aar.mnd, this.pJu.field_msgId, false);
                        VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(str);
                        if (VH != null) {
                        }
                    } else {
                        obj3 = obj2;
                    }
                    if (!bo.isNullOrNil(aar.fgE) || com.tencent.mm.vfs.e.ct(aar.wgz)) {
                        str = aar.wgz;
                        c = n.f(aar, this.pJu.field_msgId);
                        ab.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", str, c, Boolean.valueOf(com.tencent.mm.vfs.e.y(str, c) > 0));
                        aar.mg(com.tencent.mm.vfs.e.asZ(c));
                        if (com.tencent.mm.vfs.e.y(str, c) > 0) {
                            if (bo.isNullOrNil(aar.wgB)) {
                                ab.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                                aar.akX(g.cz(c));
                                obj3 = 1;
                            }
                            if (bo.isNullOrNil(aar.wgD)) {
                                ab.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                                aar.akY(g.cA(c));
                                obj3 = 1;
                            }
                        }
                        str = n.LA(aar.mnd);
                        c = n.h(str, this.pJu.field_msgId, false);
                        VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(c);
                        if (VH == null) {
                            VH = new i();
                            VH.field_cdnKey = aar.wfV;
                            VH.field_cdnUrl = aar.fgE;
                            VH.field_dataId = str;
                            VH.field_mediaId = c;
                            VH.field_totalLen = (int) aar.wgF;
                            VH.field_localId = VH.field_mediaId.hashCode();
                            VH.field_path = n.f(aar, this.pJu.field_msgId);
                            VH.field_type = 2;
                            VH.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
                            VH.field_recordLocalId = this.pJu.field_localId;
                            VH.field_toUser = this.pJu.field_toUser;
                            VH.field_isThumb = true;
                            boolean b2 = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(VH);
                            ab.i("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(VH.field_localId), Boolean.valueOf(b2));
                            obj = 1;
                            obj2 = obj3;
                        } else if (!(VH.field_status == 2 || VH.field_status == 3 || VH.field_status == 4 || VH.field_status == -1)) {
                            ab.i("MicroMsg.RecordMsgSendService", "hasInsertCdn, thumb cdnInfo status:%s", Integer.valueOf(VH.field_status));
                            obj = 1;
                        }
                    }
                    obj2 = obj3;
                    obj = obj;
                }
            }
            if (obj2 != null) {
                ab.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.pJu.field_localId), Long.valueOf(this.pJu.field_msgId), Integer.valueOf(this.pJu.field_type));
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().c(this.pJu, "localId");
            }
            if (obj == null) {
                ab.i("MicroMsg.RecordMsgSendService", "doSendContinue without cdn task");
                q.this.a(this.pJu, false);
                q.this.pJx = false;
                q.this.a(null);
            }
            ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
            AppMethodBeat.o(135724);
        }
    }

    class d implements Runnable {
        private j pJu;

        public d(j jVar) {
            this.pJu = jVar;
        }

        public final void run() {
            AppMethodBeat.i(135738);
            if (this.pJu.field_dataProto == null) {
                ab.w("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable info.field_dataProto null");
                q.this.pJx = false;
                AppMethodBeat.o(135738);
                return;
            }
            Iterator it = this.pJu.field_dataProto.wiv.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                String c;
                String c2;
                i VH;
                boolean b;
                aar aar = (aar) it.next();
                if (!(bo.isNullOrNil(aar.wfZ) && bo.isNullOrNil(aar.whr))) {
                    c = n.c(aar, this.pJu.field_oriMsgId);
                    c2 = n.c(aar, this.pJu.field_msgId);
                    ab.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", c, c2, Boolean.valueOf(com.tencent.mm.vfs.e.y(c, c2) > 0));
                    if (com.tencent.mm.vfs.e.y(c, c2) > 0) {
                        if (bo.isNullOrNil(aar.wgq)) {
                            ab.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
                            aar.akS(g.cz(c2));
                            z2 = true;
                        }
                        if (bo.isNullOrNil(aar.wgs)) {
                            ab.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
                            aar.akT(g.cA(c2));
                            z2 = true;
                        }
                    }
                    c = n.h(aar.mnd, this.pJu.field_msgId, false);
                    VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(c);
                    if (VH == null) {
                        i iVar = new i();
                        iVar.field_cdnKey = aar.wgb;
                        iVar.field_cdnUrl = aar.wfZ;
                        iVar.field_dataId = aar.mnd;
                        iVar.field_mediaId = c;
                        iVar.field_totalLen = (int) aar.wgu;
                        iVar.field_localId = iVar.field_mediaId.hashCode();
                        iVar.field_path = n.c(aar, this.pJu.field_msgId);
                        iVar.field_type = 2;
                        iVar.field_fileType = n.BH(aar.dataType);
                        iVar.field_recordLocalId = this.pJu.field_localId;
                        iVar.field_toUser = this.pJu.field_toUser;
                        iVar.field_isThumb = false;
                        String c3 = n.c(aar, this.pJu.field_msgId);
                        if (bo.isNullOrNil(aar.whr) || com.tencent.mm.vfs.e.ct(c3)) {
                            z = true;
                        } else {
                            iVar.field_status = -1;
                            a(aar, c3, c);
                        }
                        b = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar);
                        ab.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d", Integer.valueOf(iVar.field_localId), Boolean.valueOf(b), Integer.valueOf(iVar.field_recordLocalId));
                    } else {
                        if (VH.field_status == -1) {
                            a(aar, n.c(aar, this.pJu.field_msgId), c);
                        }
                        if (VH.field_status == 0) {
                            z = true;
                        }
                        ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", Integer.valueOf(VH.field_status));
                    }
                }
                if (!(bo.isNullOrNil(aar.fgE) && bo.isNullOrNil(aar.fgv))) {
                    b = com.tencent.mm.vfs.e.y(n.f(aar, this.pJu.field_oriMsgId), n.f(aar, this.pJu.field_msgId)) > 0;
                    ab.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", n.f(aar, this.pJu.field_oriMsgId), n.f(aar, this.pJu.field_msgId), Boolean.valueOf(b));
                    c = n.LA(aar.mnd);
                    c2 = n.h(c, this.pJu.field_msgId, false);
                    VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(c2);
                    String f = n.f(aar, this.pJu.field_msgId);
                    if (VH == null) {
                        i iVar2 = new i();
                        iVar2.field_cdnKey = aar.wfV;
                        iVar2.field_cdnUrl = aar.fgE;
                        iVar2.field_dataId = c;
                        iVar2.field_mediaId = c2;
                        iVar2.field_totalLen = (int) aar.wgF;
                        iVar2.field_localId = iVar2.field_mediaId.hashCode();
                        iVar2.field_path = n.f(aar, this.pJu.field_msgId);
                        iVar2.field_type = 2;
                        iVar2.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
                        iVar2.field_recordLocalId = this.pJu.field_localId;
                        iVar2.field_toUser = this.pJu.field_toUser;
                        iVar2.field_isThumb = true;
                        if (bo.isNullOrNil(aar.fgv) || com.tencent.mm.vfs.e.ct(f)) {
                            b = true;
                        } else {
                            iVar2.field_status = -1;
                            b(aar, f, c2);
                            b = z;
                        }
                        boolean b2 = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar2);
                        ab.i("MicroMsg.RecordMsgSendService", "[record] insert localId[%d] result[%B], recordLocalId:%d", Integer.valueOf(iVar2.field_localId), Boolean.valueOf(b2), Integer.valueOf(iVar2.field_recordLocalId));
                        z = b;
                    } else {
                        if (VH.field_status == -1) {
                            b(aar, n.f(aar, this.pJu.field_msgId), c2);
                        }
                        if (VH.field_status == 0) {
                            z = true;
                        }
                        ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable cdnInfo.field_status:%s", Integer.valueOf(VH.field_status));
                    }
                }
                z = z;
            }
            ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable infochanged:%s, needRun:%s", Boolean.valueOf(z2), Boolean.valueOf(z));
            if (z2) {
                ab.i("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.pJu.field_localId), Long.valueOf(this.pJu.field_msgId), Integer.valueOf(this.pJu.field_type));
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().c(this.pJu, "localId");
            }
            if (!z) {
                ab.i("MicroMsg.RecordMsgSendService", "NormalDataCopyRunnable doSendContinue");
                q.this.a(this.pJu, false);
                q.this.pJx = false;
                q.this.a(null);
            }
            ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
            AppMethodBeat.o(135738);
        }

        private void a(final aar aar, final String str, String str2) {
            AppMethodBeat.i(135739);
            ab.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl id:%s, mediaId:%s, path:%s", aar.mnd, str2, str);
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.field_fileType = 19;
            gVar.field_authKey = aar.fgA;
            gVar.field_aesKey = aar.who;
            gVar.egm = aar.whr;
            gVar.field_fullpath = str;
            gVar.field_mediaId = str2;
            gVar.egl = new com.tencent.mm.i.g.a() {
                public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    int i2;
                    AppMethodBeat.i(135736);
                    if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                        ab.i("MicroMsg.RecordMsgSendService", "[record] downloadTpUrl done id:%s, mediaId:%s, path:%s", aar.mnd, str, str);
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!(i == 0 && (dVar == null || dVar.field_retCode == 0))) {
                        String str2 = "MicroMsg.RecordMsgSendService";
                        String str3 = "[record] downloadTpUrl error id:%s, mediaId:%s, path:%s, err:(%d,%d)";
                        Object[] objArr = new Object[5];
                        objArr[0] = aar.mnd;
                        objArr[1] = str;
                        objArr[2] = str;
                        objArr[3] = Integer.valueOf(i);
                        objArr[4] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                        ab.e(str2, str3, objArr);
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        i VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(str);
                        VH.field_status = 0;
                        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(VH);
                        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                    }
                    AppMethodBeat.o(135736);
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (!com.tencent.mm.al.f.afx().b(gVar, -1)) {
                ab.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
            }
            AppMethodBeat.o(135739);
        }

        private void b(final aar aar, final String str, String str2) {
            AppMethodBeat.i(135740);
            ab.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl id:%s, mediaId:%s, thumbPath:%s", aar.mnd, str2, str);
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.field_fileType = 19;
            gVar.field_authKey = aar.fgA;
            gVar.field_aesKey = aar.fgB;
            gVar.egm = aar.fgv;
            gVar.field_fullpath = str;
            gVar.field_mediaId = str2;
            gVar.egl = new com.tencent.mm.i.g.a() {
                public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    int i2;
                    AppMethodBeat.i(135737);
                    if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                        ab.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", aar.mnd, str, str);
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!(i == 0 && (dVar == null || dVar.field_retCode == 0))) {
                        String str2 = "MicroMsg.RecordMsgSendService";
                        String str3 = "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)";
                        Object[] objArr = new Object[5];
                        objArr[0] = aar.mnd;
                        objArr[1] = str;
                        objArr[2] = str;
                        objArr[3] = Integer.valueOf(i);
                        objArr[4] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                        ab.e(str2, str3, objArr);
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        i VH = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(str);
                        VH.field_status = 0;
                        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(VH);
                        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                    }
                    AppMethodBeat.o(135737);
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (!com.tencent.mm.al.f.afx().b(gVar, -1)) {
                ab.e("MicroMsg.RecordMsgSendService", "recv openim record, add task failed");
            }
            AppMethodBeat.o(135740);
        }
    }

    class b implements f, com.tencent.mm.modelvideo.t.a, Runnable {
        private boolean cco = false;
        private int i = 0;
        HashMap<Long, Boolean> pJP = new HashMap();
        HashMap<Long, String> pJU = new HashMap();
        private j pJu;

        static /* synthetic */ void a(b bVar, HashMap hashMap, boolean z, j jVar) {
            AppMethodBeat.i(135734);
            bVar.a(hashMap, z, jVar);
            AppMethodBeat.o(135734);
        }

        public b(j jVar) {
            AppMethodBeat.i(135727);
            this.pJu = jVar;
            o.all().a(this, Looper.getMainLooper());
            com.tencent.mm.kernel.g.RO().eJo.a(221, (f) this);
            AppMethodBeat.o(135727);
        }

        public final void run() {
            AppMethodBeat.i(135728);
            this.i = 0;
            this.cco = false;
            ab.i("MicroMsg.RecordMsgSendService", "dojob ChatDataDownloadRunnable, info id:%s", Long.valueOf(this.pJu.field_msgId));
            Iterator it = this.pJu.field_dataProto.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                final long j = aar.whf;
                if (j > 0) {
                    Object obj;
                    final bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(j);
                    String str = aar.wgx;
                    if (System.currentTimeMillis() - jf.field_createTime <= 259200000 || (!bo.isNullOrNil(str) && com.tencent.mm.vfs.e.ct(str))) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        ab.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", Integer.valueOf(jf.getType()));
                    } else if (aar.dataType == 2) {
                        if (jf.drE()) {
                            int i;
                            final com.tencent.mm.at.e fI = com.tencent.mm.at.o.ahl().fI(jf.field_msgSvrId);
                            if (jf.field_isSend == 1) {
                                int i2;
                                if (fI.agQ()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                i = i2;
                            } else if (fI.agQ()) {
                                if (com.tencent.mm.vfs.e.ct(com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.a(fI).fDz, "", ""))) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            } else {
                                i = 0;
                            }
                            if (fI.offset < fI.frO || fI.frO == 0) {
                                this.pJP.put(Long.valueOf(j), Boolean.FALSE);
                                this.i = this.pJu.field_dataProto.wiv.indexOf(aar);
                                com.tencent.mm.at.o.ahm().a(fI.fDy, jf.field_msgId, i, aar, R.drawable.b0p, new com.tencent.mm.at.d.a() {
                                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
                                    }

                                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
                                        AppMethodBeat.i(135725);
                                        boolean z = i3 == 0 && i4 == 0;
                                        ab.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4));
                                        if (obj instanceof aar) {
                                            aar aar = (aar) obj;
                                            aar.akV(com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.c(fI), "", ""));
                                            aar.akW(com.tencent.mm.at.o.ahl().I(jf.field_imgPath, true));
                                            Map z2 = br.z(fI.fDK, "msg");
                                            if (z2 != null) {
                                                aar.akL((String) z2.get(".msg.img.$cdnbigimgurl"));
                                                aar.mf((long) bo.getInt((String) z2.get(".msg.img.$length"), 0));
                                                aar.akM((String) z2.get(".msg.img.$aeskey"));
                                                b.this.pJu.field_dataProto.wiv.set(b.this.i, aar);
                                            } else {
                                                ab.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", fI.fDK);
                                            }
                                            b.this.pJP.put(Long.valueOf(aar.whf), Boolean.TRUE);
                                        } else {
                                            b.this.pJP.put(Long.valueOf(j), Boolean.TRUE);
                                        }
                                        b.a(b.this, b.this.pJP, b.this.cco, b.this.pJu);
                                        AppMethodBeat.o(135725);
                                    }

                                    public final void a(long j, long j2, int i, int i2, Object obj) {
                                        AppMethodBeat.i(135726);
                                        b.this.pJP.put(Long.valueOf(j), Boolean.TRUE);
                                        b.a(b.this, b.this.pJP, b.this.cco, b.this.pJu);
                                        AppMethodBeat.o(135726);
                                    }
                                });
                            }
                        } else if (jf.dtA()) {
                            af(jf);
                        }
                    } else if (aar.dataType == 4 || aar.dataType == 15) {
                        s ut = u.ut(jf.field_imgPath);
                        if (!(ut == null || ut.status == 199)) {
                            this.pJP.put(Long.valueOf(j), Boolean.FALSE);
                            if (ut.aly()) {
                                ab.i("MicroMsg.RecordMsgSendService", "start complete online video");
                                u.uA(jf.field_imgPath);
                            } else {
                                ab.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                                u.up(jf.field_imgPath);
                            }
                        }
                    } else if (aar.dataType == 8 && !bo.isNullOrNil(aar.whr)) {
                        af(jf);
                    }
                }
            }
            this.cco = true;
            q.this.pJx = false;
            a(this.pJP, this.cco, this.pJu);
            AppMethodBeat.o(135728);
        }

        public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
            AppMethodBeat.i(135729);
            s ut = u.ut(aVar.fileName);
            if (ut != null) {
                bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf((long) ut.fXe);
                if (ut.alz()) {
                    this.pJP.put(Long.valueOf(jf.field_msgId), Boolean.TRUE);
                    a(this.pJP, this.cco, this.pJu);
                }
                AppMethodBeat.o(135729);
                return;
            }
            a(null, this.cco, this.pJu);
            AppMethodBeat.o(135729);
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(135730);
            if (mVar instanceof e) {
                com.tencent.mm.kernel.g.RO().eJo.b(221, (f) this);
                if (this.pJU != null) {
                    for (Entry entry : this.pJU.entrySet()) {
                        long longValue = ((Long) entry.getKey()).longValue();
                        String str2 = (String) entry.getValue();
                        if (longValue > 0 && !((Boolean) this.pJP.get(Long.valueOf(longValue))).booleanValue()) {
                            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(longValue);
                            com.tencent.mm.pluginsdk.model.app.b i3 = a.i(str2, longValue);
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
                a(this.pJP, this.cco, this.pJu);
                AppMethodBeat.o(135730);
                return;
            }
            a(null, this.cco, this.pJu);
            AppMethodBeat.o(135730);
        }

        private void a(HashMap<Long, Boolean> hashMap, boolean z, j jVar) {
            AppMethodBeat.i(135732);
            if (n(hashMap) && z) {
                o.all().a(this);
                jVar.field_type = 2;
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().c(jVar, "localId");
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(jVar);
            }
            AppMethodBeat.o(135732);
        }

        private static boolean n(HashMap<Long, Boolean> hashMap) {
            AppMethodBeat.i(135733);
            if (hashMap == null) {
                AppMethodBeat.o(135733);
                return true;
            }
            for (Entry value : hashMap.entrySet()) {
                if (!((Boolean) value.getValue()).booleanValue()) {
                    AppMethodBeat.o(135733);
                    return false;
                }
            }
            AppMethodBeat.o(135733);
            return true;
        }

        private void af(bi biVar) {
            AppMethodBeat.i(135731);
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(biVar.field_content);
            if (me == null) {
                ab.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", biVar.field_content);
                AppMethodBeat.o(135731);
                return;
            }
            if (bo.isNullOrNil(me.csD) && !bo.isNullOrNil(me.fgD)) {
                ab.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", biVar.field_content);
                me.csD = me.fgD.hashCode();
            }
            String str = me.csD;
            if (!a.a(biVar, a.i(str, biVar.field_msgId))) {
                this.pJP.put(Long.valueOf(biVar.field_msgId), Boolean.FALSE);
                this.pJU.put(Long.valueOf(biVar.field_msgId), str);
                a.af(biVar);
            }
            AppMethodBeat.o(135731);
        }
    }

    class c implements Runnable {
        private j pJu;

        public c(j jVar) {
            this.pJu = jVar;
        }

        public final void run() {
            AppMethodBeat.i(135735);
            ab.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", Long.valueOf(this.pJu.field_msgId));
            Iterator it = this.pJu.field_dataProto.wiv.iterator();
            int i = 0;
            while (it.hasNext()) {
                String c;
                aar aar = (aar) it.next();
                gh ghVar = new gh();
                ghVar.cAH.type = 2;
                ghVar.cAH.cAJ = aar;
                com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                ab.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", aar.mnd, Integer.valueOf(aar.dataType));
                if (!bo.isNullOrNil(ghVar.cAI.path)) {
                    c = n.c(aar, this.pJu.field_msgId);
                    ab.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", ghVar.cAI.path, c);
                    if (!ghVar.cAI.path.equals(c)) {
                        com.tencent.mm.vfs.e.y(ghVar.cAI.path, c);
                    }
                }
                if (!bo.isNullOrNil(ghVar.cAI.thumbPath)) {
                    c = n.f(aar, this.pJu.field_msgId);
                    ab.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", ghVar.cAI.thumbPath, c);
                    if (!ghVar.cAI.thumbPath.equals(c)) {
                        com.tencent.mm.vfs.e.y(ghVar.cAI.thumbPath, c);
                    }
                }
                if (aar.dataType == 3) {
                    ab.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
                    aar.akM("");
                    aar.akL("");
                    aar.akK("");
                    aar.akJ("");
                }
                if (!bo.isNullOrNil(aar.wfZ) || !bo.isNullOrNil(aar.fgE)) {
                    i = 1;
                }
            }
            if (i != 0) {
                com.tencent.mm.kernel.g.RO().eJo.a(new f(this.pJu), 0);
                AppMethodBeat.o(135735);
                return;
            }
            q.this.d(this.pJu.field_msgId, this.pJu.field_localId, com.tencent.mm.af.j.b.a(n.a(this.pJu.field_title, this.pJu.field_desc, this.pJu.field_dataProto), null, null));
            q.this.pJx = false;
            q.this.a(null);
            AppMethodBeat.o(135735);
        }
    }

    static final class e {
        int ghB;
        long pJE;

        private e() {
            AppMethodBeat.i(135741);
            this.pJE = SystemClock.elapsedRealtime();
            this.ghB = 3;
            AppMethodBeat.o(135741);
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    public q() {
        AppMethodBeat.i(135742);
        com.tencent.mm.kernel.g.RO().eJo.a(632, (f) this);
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.d) this);
        this.pJR = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_recordmsg_send_waiting_time, 7);
        AppMethodBeat.o(135742);
    }

    public final void a(final j jVar) {
        AppMethodBeat.i(135743);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:49:0x01d9  */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0181  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(135722);
                if (jVar != null) {
                    if (((e) q.this.pJA.get(jVar.field_localId)) == null) {
                        ab.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", Integer.valueOf(jVar.field_localId), Long.valueOf(jVar.field_msgId));
                        q.this.pJA.put(jVar.field_localId, new e());
                    }
                    q.this.b(jVar);
                }
                q qVar = q.this;
                if (qVar.pJx) {
                    ab.i("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
                    AppMethodBeat.o(135722);
                    return;
                }
                j jVar;
                e eVar;
                if (qVar.pJB.isEmpty()) {
                    ab.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
                    for (j jVar2 : ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().ceB()) {
                        if (((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(jVar2.field_msgId).getType() != 49) {
                            ab.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", Integer.valueOf(jVar2.field_localId), Long.valueOf(jVar2.field_msgId));
                            ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().BF(jVar2.field_localId);
                        } else {
                            eVar = (e) qVar.pJA.get(jVar2.field_localId);
                            if (eVar == null) {
                                qVar.pJA.put(jVar2.field_localId, new e());
                            } else if (eVar.ghB >= 0 || SystemClock.elapsedRealtime() - eVar.pJE >= 300000) {
                                if (eVar.ghB < 0) {
                                    eVar.ghB = 3;
                                }
                            }
                            ab.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", Integer.valueOf(jVar2.field_localId), Long.valueOf(jVar2.field_msgId));
                            qVar.b(jVar2);
                        }
                    }
                }
                if (qVar.pJB.isEmpty()) {
                    ab.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
                    qVar.finish();
                    AppMethodBeat.o(135722);
                    return;
                }
                int i;
                jVar2 = (j) qVar.pJB.removeFirst();
                eVar = (e) qVar.pJA.get(jVar2.field_localId);
                if (eVar == null) {
                    eVar = new e();
                    qVar.pJA.put(jVar2.field_localId, eVar);
                }
                eVar.ghB--;
                if (eVar.ghB < 0) {
                    if (300000 > SystemClock.elapsedRealtime() - eVar.pJE) {
                        i = 0;
                        if (i == 0) {
                            qVar.pJx = true;
                            switch (jVar2.field_type) {
                                case 0:
                                    com.tencent.mm.sdk.g.d.post(new d(jVar2), "RecordMsgSendService_normalDataCopy");
                                    AppMethodBeat.o(135722);
                                    return;
                                case 1:
                                    com.tencent.mm.sdk.g.d.post(new c(jVar2), "RecordMsgSendService_favDataCopy");
                                    AppMethodBeat.o(135722);
                                    return;
                                case 2:
                                    com.tencent.mm.sdk.g.d.post(new a(jVar2), "RecordMsgSendService_chatDataCopy");
                                    AppMethodBeat.o(135722);
                                    return;
                                case 3:
                                    com.tencent.mm.sdk.g.d.post(new b(jVar2), "RecordMsgSendService_chatDataDownLoad");
                                    AppMethodBeat.o(135722);
                                    return;
                                default:
                                    qVar.pJx = false;
                                    AppMethodBeat.o(135722);
                                    return;
                            }
                        }
                        qVar.a(null);
                        AppMethodBeat.o(135722);
                        return;
                    }
                    eVar.ghB = 2;
                }
                eVar.pJE = SystemClock.elapsedRealtime();
                i = 1;
                if (i == 0) {
                }
            }

            public final String toString() {
                AppMethodBeat.i(135723);
                String str = super.toString() + "|run";
                AppMethodBeat.o(135723);
                return str;
            }
        });
        AppMethodBeat.o(135743);
    }

    /* Access modifiers changed, original: final */
    public final void b(j jVar) {
        AppMethodBeat.i(135744);
        if (!this.pJB.contains(jVar)) {
            this.pJB.add(jVar);
        }
        AppMethodBeat.o(135744);
    }

    public final void finish() {
        AppMethodBeat.i(135745);
        this.pJB.clear();
        this.pJA.clear();
        this.pJx = false;
        AppMethodBeat.o(135745);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(135746);
        ab.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar == null) {
            ab.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
            AppMethodBeat.o(135746);
            return;
        }
        switch (mVar.getType()) {
            case 632:
                Iterator it;
                aar aar;
                ab.i("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                f fVar = (f) mVar;
                if (i == 3) {
                    Object obj;
                    it = fVar.pJu.field_dataProto.wiv.iterator();
                    while (it.hasNext()) {
                        aar = (aar) it.next();
                        if (bo.isNullOrNil(aar.wfZ)) {
                            if (!bo.isNullOrNil(aar.fgE)) {
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
                    d(fVar.pJu.field_msgId, fVar.pJu.field_localId, fVar.pJt);
                    break;
                }
                ab.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", Long.valueOf(fVar.pJu.field_msgId), Integer.valueOf(fVar.pJu.field_localId));
                ab.w("MicroMsg.RecordMsgSendService", "try upload from local");
                it = fVar.pJu.field_dataProto.wiv.iterator();
                while (it.hasNext()) {
                    String h;
                    aar = (aar) it.next();
                    if (aar.wgu > 0) {
                        h = n.h(aar.mnd, fVar.pJu.field_msgId, false);
                        if (((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(h) == null) {
                            i iVar = new i();
                            iVar.field_cdnKey = aar.wgb;
                            iVar.field_cdnUrl = aar.wfZ;
                            iVar.field_dataId = aar.mnd;
                            iVar.field_mediaId = h;
                            iVar.field_totalLen = (int) aar.wgu;
                            iVar.field_localId = iVar.field_mediaId.hashCode();
                            iVar.field_path = n.c(aar, fVar.pJu.field_msgId);
                            iVar.field_type = 2;
                            iVar.field_fileType = n.BH(aar.dataType);
                            iVar.field_recordLocalId = fVar.pJu.field_localId;
                            iVar.field_toUser = fVar.pJu.field_toUser;
                            iVar.field_isThumb = false;
                            boolean b = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar);
                            ab.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(iVar.field_localId), Boolean.valueOf(b));
                        }
                    }
                    if (aar.wgF > 0) {
                        h = n.LA(aar.mnd);
                        String h2 = n.h(h, fVar.pJu.field_msgId, false);
                        if (((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(h2) == null) {
                            i iVar2 = new i();
                            iVar2.field_cdnKey = aar.wfV;
                            iVar2.field_cdnUrl = aar.fgE;
                            iVar2.field_dataId = h;
                            iVar2.field_mediaId = h2;
                            iVar2.field_totalLen = (int) aar.wgF;
                            iVar2.field_localId = iVar2.field_mediaId.hashCode();
                            iVar2.field_path = n.f(aar, fVar.pJu.field_msgId);
                            iVar2.field_type = 2;
                            iVar2.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
                            iVar2.field_recordLocalId = fVar.pJu.field_localId;
                            iVar2.field_toUser = fVar.pJu.field_toUser;
                            iVar2.field_isThumb = true;
                            boolean b2 = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(iVar2);
                            ab.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(iVar2.field_localId), Boolean.valueOf(b2));
                        }
                    }
                }
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
                AppMethodBeat.o(135746);
                return;
                break;
        }
        this.pJx = false;
        a(null);
        AppMethodBeat.o(135746);
    }

    /* Access modifiers changed, original: final */
    public final void d(long j, int i, String str) {
        AppMethodBeat.i(135747);
        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(j);
        if (jf.field_msgId == j) {
            jf.setContent(str);
            jf.setStatus(1);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(j, jf);
        }
        com.tencent.mm.af.j ma = com.tencent.mm.plugin.s.a.bYK().ma(j);
        if (ma != null) {
            ma.field_xml = jf.field_content;
            com.tencent.mm.plugin.s.a.bYK().c(ma, "msgId");
        }
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().BF(i);
        this.pJA.remove(i);
        ((com.tencent.mm.plugin.record.a.f) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.record.a.f.class)).jB(j);
        ab.i("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.o(135747);
    }

    public final void a(int i, i iVar) {
        AppMethodBeat.i(135748);
        if (1 != i) {
            ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", Integer.valueOf(i));
            AppMethodBeat.o(135748);
        } else if (iVar == null) {
            ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
            AppMethodBeat.o(135748);
        } else if (2 != iVar.field_type) {
            ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload , mediaid:%s, recordLocalId:%d, status:%d", iVar.field_mediaId, Integer.valueOf(iVar.field_recordLocalId), Integer.valueOf(iVar.field_status));
            AppMethodBeat.o(135748);
        } else if (iVar.field_status == 0 || 1 == iVar.field_status || -1 == iVar.field_status) {
            ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
            AppMethodBeat.o(135748);
        } else {
            Object obj;
            List<i> BE = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().BE(iVar.field_recordLocalId);
            for (i iVar2 : BE) {
                if (iVar2.field_status != 0 && 1 != iVar2.field_status) {
                    if (-1 == iVar2.field_status) {
                        ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", iVar2.field_mediaId);
                        obj = null;
                        break;
                    }
                }
                ab.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", iVar2.field_mediaId);
                obj = null;
                break;
            }
            int obj2 = 1;
            ab.i("MicroMsg.RecordMsgSendService", "on cdn storage changed cdnInfoList.size:%d,", Integer.valueOf(BE.size()));
            if (obj2 == null) {
                AppMethodBeat.o(135748);
                return;
            }
            j BG = ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().BG(iVar.field_recordLocalId);
            String str = "MicroMsg.RecordMsgSendService";
            String str2 = "finish get record info, id %d result %B";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(iVar.field_recordLocalId);
            objArr[1] = Boolean.valueOf(BG != null);
            ab.i(str, str2, objArr);
            if (BG != null) {
                LinkedList<aar> linkedList = BG.field_dataProto.wiv;
                for (i iVar22 : BE) {
                    ab.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", iVar22.field_dataId, Boolean.valueOf(iVar22.field_isThumb));
                    if (!iVar22.field_isThumb) {
                        for (aar aar : linkedList) {
                            if (iVar22.field_dataId.equals(aar.mnd)) {
                                ab.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", aar.wgb, iVar22.field_cdnKey, aar.wfZ, iVar22.field_cdnUrl, Long.valueOf(aar.wgu), Integer.valueOf(iVar22.field_totalLen));
                                aar.akM(iVar22.field_cdnKey);
                                aar.akL(iVar22.field_cdnUrl);
                                break;
                            }
                        }
                    }
                    for (aar aar2 : linkedList) {
                        if (iVar22.field_dataId.equals(n.LA(aar2.mnd))) {
                            ab.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", aar2.wfV, iVar22.field_cdnKey, aar2.fgE, iVar22.field_cdnUrl, Long.valueOf(aar2.wgF), Integer.valueOf(iVar22.field_totalLen));
                            aar2.akK(iVar22.field_cdnKey);
                            aar2.akJ(iVar22.field_cdnUrl);
                            break;
                        }
                    }
                }
                a(BG, true);
            }
            for (i iVar222 : BE) {
                ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(iVar222, "localId");
            }
            this.pJx = false;
            a(null);
            AppMethodBeat.o(135748);
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(j jVar, boolean z) {
        AppMethodBeat.i(135749);
        bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(jVar.field_msgId);
        ab.i("MicroMsg.RecordMsgSendService", "[record] update msg content, msg null ? %B, msgId %d recordInfoId %d, recordInfo.localId:%d, afterCdnUpload %s", Boolean.FALSE, Long.valueOf(jf.field_msgId), Long.valueOf(jVar.field_msgId), Integer.valueOf(jVar.field_localId), Boolean.valueOf(z));
        if (jf.field_msgId == jVar.field_msgId) {
            jf.setContent(n.a(jVar.field_title, jVar.field_desc, jVar.field_dataProto, jVar.field_favFrom));
            jf.setStatus(1);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(jVar.field_msgId, jf);
        }
        com.tencent.mm.af.j ma = com.tencent.mm.plugin.s.a.bYK().ma(jVar.field_msgId);
        if (ma != null) {
            ma.field_xml = jf.field_content;
            com.tencent.mm.plugin.s.a.bYK().c(ma, "msgId");
        }
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().BF(jVar.field_localId);
        this.pJA.remove(jVar.field_localId);
        if (jf.field_createTime + ((long) (((this.pJR * 24) * 3600) * 1000)) < cb.aaE()) {
            ab.i("MicroMsg.RecordMsgSendService", "doSendContinue, out of wait time, " + jf.field_createTime);
            jf.setStatus(5);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(jVar.field_msgId, jf);
            AppMethodBeat.o(135749);
            return;
        }
        ((com.tencent.mm.plugin.record.a.f) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.record.a.f.class)).jB(jVar.field_msgId);
        AppMethodBeat.o(135749);
    }
}
