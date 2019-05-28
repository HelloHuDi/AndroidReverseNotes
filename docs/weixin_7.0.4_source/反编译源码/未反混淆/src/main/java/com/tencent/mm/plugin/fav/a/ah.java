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
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah extends m implements k {
    private static AtomicInteger mgd = new AtomicInteger(0);
    private final b ehh;
    private f ehi = null;
    private LinkedList<Integer> mfZ;
    private int mga = 0;
    private boolean mgb = false;
    private boolean mgc = false;

    static {
        AppMethodBeat.i(102730);
        AppMethodBeat.o(102730);
    }

    public ah(LinkedList<Integer> linkedList) {
        AppMethodBeat.i(102723);
        a aVar = new a();
        aVar.fsJ = new ig();
        aVar.fsK = new ih();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
        aVar.fsI = 402;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.mfZ = linkedList;
        mgd.incrementAndGet();
        AppMethodBeat.o(102723);
    }

    public static void bvd() {
        AppMethodBeat.i(102724);
        mgd.set(0);
        AppMethodBeat.o(102724);
    }

    public static void bve() {
        AppMethodBeat.i(102725);
        mgd.decrementAndGet();
        AppMethodBeat.o(102725);
    }

    public static int bvf() {
        AppMethodBeat.i(102726);
        int i = mgd.get();
        AppMethodBeat.o(102726);
        return i;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102727);
        ab.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", Integer.valueOf(mgd.get()));
        if (this.mfZ == null || this.mfZ.isEmpty() || this.mga >= this.mfZ.size()) {
            ab.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", Integer.valueOf(this.mga));
            AppMethodBeat.o(102727);
            return -1;
        }
        ab.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", Integer.valueOf(this.mfZ.size()), Integer.valueOf(this.mga), this.mfZ);
        if (bo.h((Integer) g.RP().Ry().get(8217, null)) == 0) {
            ab.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
            AppMethodBeat.o(102727);
            return -1;
        }
        ig igVar = (ig) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.mfZ.subList(this.mga, Math.min(this.mga + 15, this.mfZ.size())));
        igVar.vKh = linkedList;
        igVar.jBv = linkedList.size();
        this.mga += 15;
        ab.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", Integer.valueOf(linkedList.size()), linkedList);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102727);
        return a;
    }

    private boolean bvc() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(102728);
        if (bo.h((Integer) g.RP().Ry().get(8217, null)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mfZ == null || this.mga >= this.mfZ.size()) {
            z2 = false;
        } else {
            z2 = true;
        }
        ab.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z || !z2) {
            AppMethodBeat.o(102728);
            return false;
        }
        AppMethodBeat.o(102728);
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102729);
        ab.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mga), Integer.valueOf(this.mfZ.size()), str);
        if (i2 == 0 && i3 == 0) {
            ih ihVar = (ih) ((b) qVar).fsH.fsP;
            int i4 = ihVar.jBv;
            int size = ihVar.vKB.size();
            if (i4 != size) {
                String str2 = "MicroMsg.NetSceneBatchgetFav";
                String str3 = "klem onGYNet resp list size:%d, return count %d, request count %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(i4);
                objArr[2] = Integer.valueOf(this.mga > this.mfZ.size() ? this.mfZ.size() % 15 : 15);
                ab.e(str2, str3, objArr);
                if (bvc()) {
                    a(this.ftf, this.ehi);
                    AppMethodBeat.o(102729);
                    return;
                }
                mgd.decrementAndGet();
                this.ehi.onSceneEnd(i2, -1, str, this);
                AppMethodBeat.o(102729);
                return;
            }
            for (int i5 = 0; i5 < size; i5++) {
                aba aba = (aba) ihVar.vKB.get(i5);
                ab.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", Integer.valueOf(aba.vEp), Integer.valueOf(aba.jBT));
                if (aba.jBT == 0) {
                    g iF = ((ae) g.M(ae.class)).getFavItemInfoStorage().iF((long) aba.vEp);
                    if (iF == null) {
                        ab.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", Integer.valueOf(aba.vEp));
                    } else {
                        iF.field_xml = aba.vEv;
                        iF.LH(aba.vEv);
                        iF.field_flag = aba.vEq;
                        iF.field_localSeq = aba.vEs;
                        iF.field_updateTime = (((long) aba.vEr) * 1000) + ((long) i5);
                        ab.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", iF.field_xml);
                        int size2 = iF.field_favProto.wiv.size();
                        if (size2 == 0) {
                            ab.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", Integer.valueOf(iF.field_id));
                        } else {
                            LinkedList linkedList = iF.field_favProto.wiv;
                            for (int i6 = size2 - 1; i6 >= 0; i6--) {
                                aar aar = (aar) linkedList.get(i6);
                                if (!bo.isNullOrNil(aar.wgq)) {
                                    ab.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new com.tencent.mm.vfs.b(b.b(aar)).getName());
                                    if (new com.tencent.mm.vfs.b(b.b(aar)).exists()) {
                                        if (aar.wgP != 0) {
                                            ab.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", aar.wgq);
                                            this.mgc = true;
                                            b.a(aar, iF, 0, false);
                                        }
                                        ab.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", Integer.valueOf(iF.field_id), Integer.valueOf(i6));
                                    } else if (bo.isNullOrNil(aar.wgb) || bo.isNullOrNil(aar.wfZ)) {
                                        ab.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", Integer.valueOf(iF.field_id));
                                    } else {
                                        ab.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", Integer.valueOf(iF.field_id), Integer.valueOf(i6));
                                        b.a(aar, iF, 1, false);
                                        this.mgb = true;
                                    }
                                }
                                if (!bo.isNullOrNil(aar.wgB)) {
                                    if (new com.tencent.mm.vfs.b(b.c(aar)).exists()) {
                                        ab.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", Integer.valueOf(iF.field_id), Integer.valueOf(i6));
                                    } else if (bo.isNullOrNil(aar.wfV) || bo.isNullOrNil(aar.fgE)) {
                                        ab.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", Integer.valueOf(iF.field_id));
                                    } else {
                                        ab.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", Integer.valueOf(iF.field_id), Integer.valueOf(i6));
                                        b.a(aar, iF, 1);
                                        this.mgb = true;
                                    }
                                }
                            }
                        }
                        ab.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", Boolean.valueOf(this.mgc), Boolean.valueOf(this.mgb));
                        if (this.mgc) {
                            iF.field_itemStatus = 15;
                            ((ae) g.M(ae.class)).getFavItemInfoStorage().a(iF, "localId");
                            ((ae) g.M(ae.class)).getFavCdnService().run();
                        } else if (this.mgb) {
                            iF.field_itemStatus = 10;
                            ((ae) g.M(ae.class)).getFavItemInfoStorage().a(iF, "localId");
                        } else {
                            iF.field_itemStatus = 10;
                            ((ae) g.M(ae.class)).getFavItemInfoStorage().a(iF, "localId");
                        }
                        b.j(iF);
                        iF.LI("MicroMsg.NetSceneBatchgetFav");
                    }
                }
                if ((aba.vEq & 1) != 0) {
                    ab.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", Integer.valueOf(aba.vEp));
                    b.i(((ae) g.M(ae.class)).getFavItemInfoStorage().iF((long) aba.vEp));
                }
            }
            ((ae) g.M(ae.class)).getFavCdnService().run();
            if (bvc()) {
                a(this.ftf, this.ehi);
                AppMethodBeat.o(102729);
                return;
            }
            mgd.decrementAndGet();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102729);
        } else if (bvc()) {
            a(this.ftf, this.ehi);
            AppMethodBeat.o(102729);
        } else {
            mgd.decrementAndGet();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102729);
        }
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 10;
    }

    public final int getType() {
        return 402;
    }
}
