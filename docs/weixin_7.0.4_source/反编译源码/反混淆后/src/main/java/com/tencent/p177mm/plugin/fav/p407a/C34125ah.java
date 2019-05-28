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
import com.tencent.p177mm.protocal.protobuf.C15347ih;
import com.tencent.p177mm.protocal.protobuf.C7541ig;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aba;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.fav.a.ah */
public final class C34125ah extends C1207m implements C1918k {
    private static AtomicInteger mgd = new AtomicInteger(0);
    private final C7472b ehh;
    private C1202f ehi = null;
    private LinkedList<Integer> mfZ;
    private int mga = 0;
    private boolean mgb = false;
    private boolean mgc = false;

    static {
        AppMethodBeat.m2504i(102730);
        AppMethodBeat.m2505o(102730);
    }

    public C34125ah(LinkedList<Integer> linkedList) {
        AppMethodBeat.m2504i(102723);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7541ig();
        c1196a.fsK = new C15347ih();
        c1196a.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
        c1196a.fsI = 402;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.mfZ = linkedList;
        mgd.incrementAndGet();
        AppMethodBeat.m2505o(102723);
    }

    public static void bvd() {
        AppMethodBeat.m2504i(102724);
        mgd.set(0);
        AppMethodBeat.m2505o(102724);
    }

    public static void bve() {
        AppMethodBeat.m2504i(102725);
        mgd.decrementAndGet();
        AppMethodBeat.m2505o(102725);
    }

    public static int bvf() {
        AppMethodBeat.m2504i(102726);
        int i = mgd.get();
        AppMethodBeat.m2505o(102726);
        return i;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102727);
        C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", Integer.valueOf(mgd.get()));
        if (this.mfZ == null || this.mfZ.isEmpty() || this.mga >= this.mfZ.size()) {
            C4990ab.m7413e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", Integer.valueOf(this.mga));
            AppMethodBeat.m2505o(102727);
            return -1;
        }
        C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", Integer.valueOf(this.mfZ.size()), Integer.valueOf(this.mga), this.mfZ);
        if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(8217, null)) == 0) {
            C4990ab.m7420w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
            AppMethodBeat.m2505o(102727);
            return -1;
        }
        C7541ig c7541ig = (C7541ig) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.mfZ.subList(this.mga, Math.min(this.mga + 15, this.mfZ.size())));
        c7541ig.vKh = linkedList;
        c7541ig.jBv = linkedList.size();
        this.mga += 15;
        C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", Integer.valueOf(linkedList.size()), linkedList);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102727);
        return a;
    }

    private boolean bvc() {
        boolean z;
        boolean z2;
        AppMethodBeat.m2504i(102728);
        if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(8217, null)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mfZ == null || this.mga >= this.mfZ.size()) {
            z2 = false;
        } else {
            z2 = true;
        }
        C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z || !z2) {
            AppMethodBeat.m2505o(102728);
            return false;
        }
        AppMethodBeat.m2505o(102728);
        return true;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102729);
        C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mga), Integer.valueOf(this.mfZ.size()), str);
        if (i2 == 0 && i3 == 0) {
            C15347ih c15347ih = (C15347ih) ((C7472b) c1929q).fsH.fsP;
            int i4 = c15347ih.jBv;
            int size = c15347ih.vKB.size();
            if (i4 != size) {
                String str2 = "MicroMsg.NetSceneBatchgetFav";
                String str3 = "klem onGYNet resp list size:%d, return count %d, request count %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(i4);
                objArr[2] = Integer.valueOf(this.mga > this.mfZ.size() ? this.mfZ.size() % 15 : 15);
                C4990ab.m7413e(str2, str3, objArr);
                if (bvc()) {
                    mo4456a(this.ftf, this.ehi);
                    AppMethodBeat.m2505o(102729);
                    return;
                }
                mgd.decrementAndGet();
                this.ehi.onSceneEnd(i2, -1, str, this);
                AppMethodBeat.m2505o(102729);
                return;
            }
            for (int i5 = 0; i5 < size; i5++) {
                aba aba = (aba) c15347ih.vKB.get(i5);
                C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", Integer.valueOf(aba.vEp), Integer.valueOf(aba.jBT));
                if (aba.jBT == 0) {
                    C27966g iF = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) aba.vEp);
                    if (iF == null) {
                        C4990ab.m7413e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", Integer.valueOf(aba.vEp));
                    } else {
                        iF.field_xml = aba.vEv;
                        iF.mo45881LH(aba.vEv);
                        iF.field_flag = aba.vEq;
                        iF.field_localSeq = aba.vEs;
                        iF.field_updateTime = (((long) aba.vEr) * 1000) + ((long) i5);
                        C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", iF.field_xml);
                        int size2 = iF.field_favProto.wiv.size();
                        if (size2 == 0) {
                            C4990ab.m7419v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", Integer.valueOf(iF.field_id));
                        } else {
                            LinkedList linkedList = iF.field_favProto.wiv;
                            for (int i6 = size2 - 1; i6 >= 0; i6--) {
                                aar aar = (aar) linkedList.get(i6);
                                if (!C5046bo.isNullOrNil(aar.wgq)) {
                                    C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new C5728b(C39037b.m66370b(aar)).getName());
                                    if (new C5728b(C39037b.m66370b(aar)).exists()) {
                                        if (aar.wgP != 0) {
                                            C4990ab.m7419v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", aar.wgq);
                                            this.mgc = true;
                                            C39037b.m66364a(aar, iF, 0, false);
                                        }
                                        C4990ab.m7411d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", Integer.valueOf(iF.field_id), Integer.valueOf(i6));
                                    } else if (C5046bo.isNullOrNil(aar.wgb) || C5046bo.isNullOrNil(aar.wfZ)) {
                                        C4990ab.m7413e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", Integer.valueOf(iF.field_id));
                                    } else {
                                        C4990ab.m7411d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", Integer.valueOf(iF.field_id), Integer.valueOf(i6));
                                        C39037b.m66364a(aar, iF, 1, false);
                                        this.mgb = true;
                                    }
                                }
                                if (!C5046bo.isNullOrNil(aar.wgB)) {
                                    if (new C5728b(C39037b.m66379c(aar)).exists()) {
                                        C4990ab.m7411d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", Integer.valueOf(iF.field_id), Integer.valueOf(i6));
                                    } else if (C5046bo.isNullOrNil(aar.wfV) || C5046bo.isNullOrNil(aar.fgE)) {
                                        C4990ab.m7421w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", Integer.valueOf(iF.field_id));
                                    } else {
                                        C4990ab.m7411d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", Integer.valueOf(iF.field_id), Integer.valueOf(i6));
                                        C39037b.m66363a(aar, iF, 1);
                                        this.mgb = true;
                                    }
                                }
                            }
                        }
                        C4990ab.m7417i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", Boolean.valueOf(this.mgc), Boolean.valueOf(this.mgb));
                        if (this.mgc) {
                            iF.field_itemStatus = 15;
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iF, "localId");
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
                        } else if (this.mgb) {
                            iF.field_itemStatus = 10;
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iF, "localId");
                        } else {
                            iF.field_itemStatus = 10;
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iF, "localId");
                        }
                        C39037b.m66408j(iF);
                        iF.mo45882LI("MicroMsg.NetSceneBatchgetFav");
                    }
                }
                if ((aba.vEq & 1) != 0) {
                    C4990ab.m7411d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", Integer.valueOf(aba.vEp));
                    C39037b.m66398i(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) aba.vEp));
                }
            }
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnService().run();
            if (bvc()) {
                mo4456a(this.ftf, this.ehi);
                AppMethodBeat.m2505o(102729);
                return;
            }
            mgd.decrementAndGet();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102729);
        } else if (bvc()) {
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(102729);
        } else {
            mgd.decrementAndGet();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102729);
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 10;
    }

    public final int getType() {
        return 402;
    }
}
