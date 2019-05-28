package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.protocal.protobuf.C40563qo;
import com.tencent.p177mm.protocal.protobuf.C40564qq;
import com.tencent.p177mm.protocal.protobuf.C46577qp;
import com.tencent.p177mm.protocal.protobuf.aaq;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.plugin.fav.a.ai */
public final class C45924ai extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;
    private int mge = 0;
    public C27966g mgf;
    private boolean mgg = true;
    private boolean mgh = false;
    HashMap<aar, Boolean> mgi = new HashMap();

    public C45924ai(C27966g c27966g) {
        AppMethodBeat.m2504i(102731);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46577qp();
        c1196a.fsK = new C40564qq();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkcdn";
        c1196a.fsI = 404;
        c1196a.fsL = 197;
        c1196a.fsM = 1000000197;
        this.ehh = c1196a.acD();
        this.mgf = c27966g;
        Iterator it = c27966g.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            this.mgi.put((aar) it.next(), Boolean.FALSE);
        }
        AppMethodBeat.m2505o(102731);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i;
        AppMethodBeat.m2504i(102732);
        this.ehi = c1202f;
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
            C4990ab.m7412e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
            this.mge = -100;
            AppMethodBeat.m2505o(102732);
            return -100;
        }
        int i3;
        int i4 = 0;
        C46577qp c46577qp = (C46577qp) this.ehh.fsG.fsP;
        c46577qp.jBw.clear();
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
                    C40563qo c40563qo = new C40563qo();
                    c40563qo.vXE = (int) aar.wgu;
                    c40563qo.vXC = aar.wgq;
                    c40563qo.vXD = aar.wgs;
                    c40563qo.vXB = String.valueOf(i3);
                    c40563qo.vXG = aar.wgH;
                    c40563qo.vXF = this.mgf.field_sourceType;
                    c40563qo.vXH = 0;
                    c46577qp.jBw.add(c40563qo);
                    i6++;
                    C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", c40563qo.vXB, c40563qo.vXG, Integer.valueOf(c40563qo.vXF), Integer.valueOf(c40563qo.vXE), c40563qo.vXC, c40563qo.vXD);
                }
                if (aar.wgN) {
                    i4 = i6;
                } else {
                    C40563qo c40563qo2 = new C40563qo();
                    c40563qo2.vXE = (int) aar.wgF;
                    c40563qo2.vXC = aar.wgB;
                    c40563qo2.vXD = aar.wgD;
                    c40563qo2.vXG = aar.wgH;
                    c40563qo2.vXF = this.mgf.field_sourceType;
                    c40563qo2.vXB = i3 + "t";
                    c40563qo2.vXH = 1;
                    c46577qp.jBw.add(c40563qo2);
                    i4 = i6 + 1;
                    C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", c40563qo2.vXB, c40563qo2.vXG, Integer.valueOf(c40563qo2.vXF), Integer.valueOf(c40563qo2.vXE), c40563qo2.vXC, c40563qo2.vXD);
                }
                if (i4 >= 19) {
                    break;
                }
            } else {
                i4 = i6;
            }
            i5 = i3 + 1;
        }
        C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3 + 1));
        c46577qp.jBv = i4;
        if (i4 == 0) {
            C4990ab.m7420w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
            this.mge = XWalkUpdater.ERROR_SET_VERNUM;
            AppMethodBeat.m2505o(102732);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        i2 = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102732);
        return i2;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102733);
        C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mge), str);
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 3 && this.mge == -100) {
                C4990ab.m7410d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(9, this.mgf.field_localId);
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(102733);
                return;
            } else if (i2 == 3 && this.mge == XWalkUpdater.ERROR_SET_VERNUM) {
                i3 = 0;
            } else {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(102733);
                return;
            }
        }
        if (this.mge != XWalkUpdater.ERROR_SET_VERNUM && i2 == 0 && i3 == 0) {
            int i4;
            LinkedList linkedList = ((C40564qq) ((C7472b) c1929q).fsH.fsP).jBw;
            LinkedList linkedList2 = this.mgf.field_favProto.wiv;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= linkedList.size()) {
                    break;
                }
                aaq aaq = (aaq) linkedList.get(i6);
                String str2 = aaq.vXB;
                if (!C5046bo.isNullOrNil(str2)) {
                    aar aar;
                    C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", Integer.valueOf(aaq.jBT), str2);
                    if (aaq.jBT == 1) {
                        if (str2.endsWith("t")) {
                            aar = (aar) linkedList2.get(C5046bo.getInt(str2.substring(0, str2.length() - 1), 0));
                            C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", aaq.wfP, aaq.vRw, aaq.vXB, aaq.vXC, Integer.valueOf(aaq.vXE), aaq.vXD);
                            aar.akK(aaq.vRw);
                            aar.akJ(aaq.wfP);
                            if (aaq.vXE > 0) {
                                aar.mo27432mg((long) aaq.vXE);
                                if (!(C5046bo.isNullOrNil(aaq.vXC) || aaq.vXC.equals(aar.wgB))) {
                                    C4990ab.m7421w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", aaq.vXC, aar.wgB);
                                    aar.akX(aaq.vXC);
                                }
                                if (!(C5046bo.isNullOrNil(aaq.vXD) || aaq.vXD.equals(aar.wgD))) {
                                    C4990ab.m7421w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", aaq.vXD, aar.wgD);
                                    aar.akY(aaq.vXD);
                                }
                            }
                        } else {
                            aar = (aar) linkedList2.get(C5046bo.getInt(str2, 0));
                            C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", aaq.wfP, aaq.vRw, aaq.vXB, aaq.vXC, Integer.valueOf(aaq.vXE), aaq.vXD);
                            aar.akM(aaq.vRw);
                            aar.akL(aaq.wfP);
                            if (!C5046bo.isNullOrNil(aaq.wfQ)) {
                                aar.ala(aaq.wfQ);
                            }
                            if (C5046bo.isNullOrNil(aar.wgq)) {
                                C4990ab.m7416i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
                                aar.akS(aaq.vXC);
                                aar.mo27431mf((long) aaq.vXE);
                                aar.akT(aaq.vXD);
                                C39037b.m66364a(aar, this.mgf, 1, false);
                            }
                            if (!(C5046bo.isNullOrNil(aaq.vXC) || aaq.vXC.equals(aar.wgq))) {
                                C4990ab.m7421w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", aaq.vXC, aar.wgq);
                                aar.akS(aaq.vXC);
                            }
                            if (!(C5046bo.isNullOrNil(aaq.vXD) || aaq.vXD.equals(aar.wgs))) {
                                C4990ab.m7421w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", aaq.vXD, aar.wgs);
                                aar.akT(aaq.vXD);
                            }
                            if (aaq.vXE > 0 && ((long) aaq.vXE) != aar.wgu) {
                                C4990ab.m7421w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", Integer.valueOf(aaq.vXE), Long.valueOf(aar.wgu));
                                aar.mo27431mf((long) aaq.vXE);
                            }
                        }
                    }
                    if (str2.endsWith("t")) {
                        this.mgi.put((aar) linkedList2.get(C5046bo.getInt(str2.substring(0, str2.length() - 1), 0)), Boolean.TRUE);
                    } else {
                        this.mgi.put((aar) linkedList2.get(C5046bo.getInt(str2, 0)), Boolean.TRUE);
                    }
                    if (!(aaq.jBT == 1 || aaq.jBT == 2)) {
                        if (str2.endsWith("t")) {
                            aar = (aar) linkedList2.get(C5046bo.getInt(str2.substring(0, str2.length() - 1), 0));
                            if (C5046bo.isNullOrNil(aar.wgB)) {
                                C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", aar.wgB);
                            } else {
                                this.mgg = false;
                                if (C5046bo.isNullOrNil(aar.wgb)) {
                                    C37461f.afy();
                                    aar.akM(C8941a.afp());
                                    C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", r10);
                                }
                                C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", aar.wgq, aar.wgb);
                                C39037b.m66363a(aar, this.mgf, 0);
                            }
                        } else {
                            aar = (aar) linkedList2.get(C5046bo.getInt(str2, 0));
                            if (C5046bo.isNullOrNil(aar.wgq)) {
                                C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", aar.wgq);
                            } else {
                                this.mgg = false;
                                if (C5046bo.isNullOrNil(aar.wgb)) {
                                    C37461f.afy();
                                    aar.akM(C8941a.afp());
                                    C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", r10);
                                }
                                C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", aar.wgq, aar.wgb);
                                C39037b.m66364a(aar, this.mgf, 0, false);
                            }
                        }
                    }
                    if (aaq.jBT == 2) {
                        this.mgh = true;
                        if (str2.endsWith("t")) {
                            C4990ab.m7412e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
                        } else {
                            C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", Integer.valueOf(aaq.wfR), aaq.wfP, aaq.vRw);
                            aar = (aar) linkedList2.get(C5046bo.getInt(str2, 0));
                            aar.mo27395LF(aaq.wfR);
                            aar.akM(aaq.vRw);
                            aar.akL(aaq.wfP);
                            if (!C5046bo.isNullOrNil(aaq.wfQ)) {
                                aar.ala(aaq.wfQ);
                            }
                            if (!(C5046bo.isNullOrNil(aaq.vXC) || aaq.vXC.equals(aar.wgq))) {
                                C4990ab.m7421w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", aaq.vXC, aar.wgq);
                                aar.akS(aaq.vXC);
                            }
                            if (!(C5046bo.isNullOrNil(aaq.vXD) || aaq.vXD.equals(aar.wgs))) {
                                C4990ab.m7421w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", aaq.vXD, aar.wgs);
                                aar.akT(aaq.vXD);
                            }
                            if (aaq.vXE > 0 && ((long) aaq.vXE) != aar.wgu) {
                                C4990ab.m7421w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", Integer.valueOf(aaq.vXE), Long.valueOf(aar.wgu));
                                aar.mo27431mf((long) aaq.vXE);
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
            C4990ab.m7417i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
            if (i4 > 0) {
                C4990ab.m7420w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
                i5 = mo4456a(this.ftf, this.ehi);
                if (!(i5 == -100 || i5 == XWalkUpdater.ERROR_SET_VERNUM)) {
                    AppMethodBeat.m2505o(102733);
                    return;
                }
            }
        }
        if (this.mgh) {
            C4990ab.m7416i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
            this.mgf.field_itemStatus = 12;
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(this.mgf, "localId");
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102733);
            return;
        }
        if (this.mgg) {
            C4990ab.m7416i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
            if (this.mgf.field_id > 0) {
                this.mgf.field_itemStatus = 17;
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(this.mgf, "localId");
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getModService().run();
            } else {
                if (this.mgf.field_type == 18) {
                    this.mgf.field_favProto.mo74735LM(1);
                }
                this.mgf.field_itemStatus = 9;
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(this.mgf, "localId");
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
            }
        } else {
            if (this.mgf.field_id > 0) {
                this.mgf.field_itemStatus = 15;
            } else {
                if (this.mgf.field_type == 18) {
                    this.mgf.field_favProto.mo74735LM(1);
                }
                this.mgf.field_itemStatus = 4;
            }
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(this.mgf, "localId");
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(102733);
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 10;
    }

    public final int getType() {
        return 404;
    }
}
