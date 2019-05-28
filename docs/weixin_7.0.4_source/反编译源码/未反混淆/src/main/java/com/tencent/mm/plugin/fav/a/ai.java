package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xwalk.core.XWalkUpdater;

public final class ai extends m implements k {
    private final b ehh;
    private f ehi = null;
    private int mge = 0;
    public g mgf;
    private boolean mgg = true;
    private boolean mgh = false;
    HashMap<aar, Boolean> mgi = new HashMap();

    public ai(g gVar) {
        AppMethodBeat.i(102731);
        a aVar = new a();
        aVar.fsJ = new qp();
        aVar.fsK = new qq();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcdn";
        aVar.fsI = 404;
        aVar.fsL = 197;
        aVar.fsM = 1000000197;
        this.ehh = aVar.acD();
        this.mgf = gVar;
        Iterator it = gVar.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            this.mgi.put((aar) it.next(), Boolean.FALSE);
        }
        AppMethodBeat.o(102731);
    }

    public final int a(e eVar, f fVar) {
        int i;
        AppMethodBeat.i(102732);
        this.ehi = fVar;
        int i2 = 0;
        Iterator it = this.mgi.keySet().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            if (((Boolean) this.mgi.get((aar) it.next())).booleanValue()) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
        }
        if (i == 0) {
            ab.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
            this.mge = -100;
            AppMethodBeat.o(102732);
            return -100;
        }
        int i3;
        int i4 = 0;
        qp qpVar = (qp) this.ehh.fsG.fsP;
        qpVar.jBw.clear();
        LinkedList linkedList = this.mgf.field_favProto.wiv;
        int i5 = 0;
        while (true) {
            i3 = i5;
            int i6 = i4;
            if (i3 >= linkedList.size()) {
                i4 = i6;
                break;
            }
            aar aar = (aar) linkedList.get(i3);
            if (!((Boolean) this.mgi.get(aar)).booleanValue()) {
                if (!aar.wgL) {
                    qo qoVar = new qo();
                    qoVar.vXE = (int) aar.wgu;
                    qoVar.vXC = aar.wgq;
                    qoVar.vXD = aar.wgs;
                    qoVar.vXB = String.valueOf(i3);
                    qoVar.vXG = aar.wgH;
                    qoVar.vXF = this.mgf.field_sourceType;
                    qoVar.vXH = 0;
                    qpVar.jBw.add(qoVar);
                    i6++;
                    ab.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", qoVar.vXB, qoVar.vXG, Integer.valueOf(qoVar.vXF), Integer.valueOf(qoVar.vXE), qoVar.vXC, qoVar.vXD);
                }
                if (aar.wgN) {
                    i4 = i6;
                } else {
                    qo qoVar2 = new qo();
                    qoVar2.vXE = (int) aar.wgF;
                    qoVar2.vXC = aar.wgB;
                    qoVar2.vXD = aar.wgD;
                    qoVar2.vXG = aar.wgH;
                    qoVar2.vXF = this.mgf.field_sourceType;
                    qoVar2.vXB = i3 + "t";
                    qoVar2.vXH = 1;
                    qpVar.jBw.add(qoVar2);
                    i4 = i6 + 1;
                    ab.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", qoVar2.vXB, qoVar2.vXG, Integer.valueOf(qoVar2.vXF), Integer.valueOf(qoVar2.vXE), qoVar2.vXC, qoVar2.vXD);
                }
                if (i4 >= 19) {
                    break;
                }
            } else {
                i4 = i6;
            }
            i5 = i3 + 1;
        }
        ab.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3 + 1));
        qpVar.jBv = i4;
        if (i4 == 0) {
            ab.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
            this.mge = XWalkUpdater.ERROR_SET_VERNUM;
            AppMethodBeat.o(102732);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        i2 = a(eVar, this.ehh, this);
        AppMethodBeat.o(102732);
        return i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102733);
        ab.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mge), str);
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 3 && this.mge == -100) {
                ab.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
                ((ae) g.M(ae.class)).getFavItemInfoStorage().J(9, this.mgf.field_localId);
                ((ae) g.M(ae.class)).getSendService().run();
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(102733);
                return;
            } else if (i2 == 3 && this.mge == XWalkUpdater.ERROR_SET_VERNUM) {
                i3 = 0;
            } else {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(102733);
                return;
            }
        }
        if (this.mge != XWalkUpdater.ERROR_SET_VERNUM && i2 == 0 && i3 == 0) {
            int i4;
            LinkedList linkedList = ((qq) ((b) qVar).fsH.fsP).jBw;
            LinkedList linkedList2 = this.mgf.field_favProto.wiv;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= linkedList.size()) {
                    break;
                }
                aaq aaq = (aaq) linkedList.get(i6);
                String str2 = aaq.vXB;
                if (!bo.isNullOrNil(str2)) {
                    aar aar;
                    ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", Integer.valueOf(aaq.jBT), str2);
                    if (aaq.jBT == 1) {
                        if (str2.endsWith("t")) {
                            aar = (aar) linkedList2.get(bo.getInt(str2.substring(0, str2.length() - 1), 0));
                            ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", aaq.wfP, aaq.vRw, aaq.vXB, aaq.vXC, Integer.valueOf(aaq.vXE), aaq.vXD);
                            aar.akK(aaq.vRw);
                            aar.akJ(aaq.wfP);
                            if (aaq.vXE > 0) {
                                aar.mg((long) aaq.vXE);
                                if (!(bo.isNullOrNil(aaq.vXC) || aaq.vXC.equals(aar.wgB))) {
                                    ab.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", aaq.vXC, aar.wgB);
                                    aar.akX(aaq.vXC);
                                }
                                if (!(bo.isNullOrNil(aaq.vXD) || aaq.vXD.equals(aar.wgD))) {
                                    ab.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", aaq.vXD, aar.wgD);
                                    aar.akY(aaq.vXD);
                                }
                            }
                        } else {
                            aar = (aar) linkedList2.get(bo.getInt(str2, 0));
                            ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", aaq.wfP, aaq.vRw, aaq.vXB, aaq.vXC, Integer.valueOf(aaq.vXE), aaq.vXD);
                            aar.akM(aaq.vRw);
                            aar.akL(aaq.wfP);
                            if (!bo.isNullOrNil(aaq.wfQ)) {
                                aar.ala(aaq.wfQ);
                            }
                            if (bo.isNullOrNil(aar.wgq)) {
                                ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
                                aar.akS(aaq.vXC);
                                aar.mf((long) aaq.vXE);
                                aar.akT(aaq.vXD);
                                b.a(aar, this.mgf, 1, false);
                            }
                            if (!(bo.isNullOrNil(aaq.vXC) || aaq.vXC.equals(aar.wgq))) {
                                ab.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", aaq.vXC, aar.wgq);
                                aar.akS(aaq.vXC);
                            }
                            if (!(bo.isNullOrNil(aaq.vXD) || aaq.vXD.equals(aar.wgs))) {
                                ab.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", aaq.vXD, aar.wgs);
                                aar.akT(aaq.vXD);
                            }
                            if (aaq.vXE > 0 && ((long) aaq.vXE) != aar.wgu) {
                                ab.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", Integer.valueOf(aaq.vXE), Long.valueOf(aar.wgu));
                                aar.mf((long) aaq.vXE);
                            }
                        }
                    }
                    if (str2.endsWith("t")) {
                        this.mgi.put((aar) linkedList2.get(bo.getInt(str2.substring(0, str2.length() - 1), 0)), Boolean.TRUE);
                    } else {
                        this.mgi.put((aar) linkedList2.get(bo.getInt(str2, 0)), Boolean.TRUE);
                    }
                    if (!(aaq.jBT == 1 || aaq.jBT == 2)) {
                        if (str2.endsWith("t")) {
                            aar = (aar) linkedList2.get(bo.getInt(str2.substring(0, str2.length() - 1), 0));
                            if (bo.isNullOrNil(aar.wgB)) {
                                ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", aar.wgB);
                            } else {
                                this.mgg = false;
                                if (bo.isNullOrNil(aar.wgb)) {
                                    com.tencent.mm.al.f.afy();
                                    aar.akM(com.tencent.mm.al.a.afp());
                                    ab.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", r10);
                                }
                                ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", aar.wgq, aar.wgb);
                                b.a(aar, this.mgf, 0);
                            }
                        } else {
                            aar = (aar) linkedList2.get(bo.getInt(str2, 0));
                            if (bo.isNullOrNil(aar.wgq)) {
                                ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", aar.wgq);
                            } else {
                                this.mgg = false;
                                if (bo.isNullOrNil(aar.wgb)) {
                                    com.tencent.mm.al.f.afy();
                                    aar.akM(com.tencent.mm.al.a.afp());
                                    ab.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", r10);
                                }
                                ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", aar.wgq, aar.wgb);
                                b.a(aar, this.mgf, 0, false);
                            }
                        }
                    }
                    if (aaq.jBT == 2) {
                        this.mgh = true;
                        if (str2.endsWith("t")) {
                            ab.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
                        } else {
                            ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", Integer.valueOf(aaq.wfR), aaq.wfP, aaq.vRw);
                            aar = (aar) linkedList2.get(bo.getInt(str2, 0));
                            aar.LF(aaq.wfR);
                            aar.akM(aaq.vRw);
                            aar.akL(aaq.wfP);
                            if (!bo.isNullOrNil(aaq.wfQ)) {
                                aar.ala(aaq.wfQ);
                            }
                            if (!(bo.isNullOrNil(aaq.vXC) || aaq.vXC.equals(aar.wgq))) {
                                ab.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", aaq.vXC, aar.wgq);
                                aar.akS(aaq.vXC);
                            }
                            if (!(bo.isNullOrNil(aaq.vXD) || aaq.vXD.equals(aar.wgs))) {
                                ab.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", aaq.vXD, aar.wgs);
                                aar.akT(aaq.vXD);
                            }
                            if (aaq.vXE > 0 && ((long) aaq.vXE) != aar.wgu) {
                                ab.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", Integer.valueOf(aaq.vXE), Long.valueOf(aar.wgu));
                                aar.mf((long) aaq.vXE);
                            }
                        }
                    }
                }
                i5 = i6 + 1;
            }
            i5 = 0;
            Iterator it = this.mgi.keySet().iterator();
            while (true) {
                i4 = i5;
                if (!it.hasNext()) {
                    break;
                }
                if (((Boolean) this.mgi.get((aar) it.next())).booleanValue()) {
                    i5 = i4;
                } else {
                    i5 = i4 + 1;
                }
            }
            ab.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
            if (i4 > 0) {
                ab.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
                i5 = a(this.ftf, this.ehi);
                if (!(i5 == -100 || i5 == XWalkUpdater.ERROR_SET_VERNUM)) {
                    AppMethodBeat.o(102733);
                    return;
                }
            }
        }
        if (this.mgh) {
            ab.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
            this.mgf.field_itemStatus = 12;
            ((ae) g.M(ae.class)).getFavItemInfoStorage().a(this.mgf, "localId");
            ((ae) g.M(ae.class)).getSendService().run();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102733);
            return;
        }
        if (this.mgg) {
            ab.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
            if (this.mgf.field_id > 0) {
                this.mgf.field_itemStatus = 17;
                ((ae) g.M(ae.class)).getFavItemInfoStorage().a(this.mgf, "localId");
                ((ae) g.M(ae.class)).getModService().run();
            } else {
                if (this.mgf.field_type == 18) {
                    this.mgf.field_favProto.LM(1);
                }
                this.mgf.field_itemStatus = 9;
                ((ae) g.M(ae.class)).getFavItemInfoStorage().a(this.mgf, "localId");
                ((ae) g.M(ae.class)).getSendService().run();
            }
        } else {
            if (this.mgf.field_id > 0) {
                this.mgf.field_itemStatus = 15;
            } else {
                if (this.mgf.field_type == 18) {
                    this.mgf.field_favProto.LM(1);
                }
                this.mgf.field_itemStatus = 4;
            }
            ((ae) g.M(ae.class)).getFavItemInfoStorage().a(this.mgf, "localId");
            ((ae) g.M(ae.class)).getFavCdnService().run();
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(102733);
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 10;
    }

    public final int getType() {
        return 404;
    }
}
