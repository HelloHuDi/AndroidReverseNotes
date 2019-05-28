package com.tencent.mm.openim.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.room.a.a.AnonymousClass1;
import com.tencent.mm.openim.room.a.a.AnonymousClass2;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.alg;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.LinkedList;
import java.util.List;

public final class f extends m implements k {
    private final b ehh;
    private com.tencent.mm.ai.f ehi;
    private final String geY;
    private final int version;

    public f(String str, int i) {
        AppMethodBeat.i(78849);
        a aVar = new a();
        aVar.fsJ = new alg();
        aVar.fsK = new alh();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
        this.ehh = aVar.acD();
        this.geY = str;
        this.version = i;
        alg alg = (alg) this.ehh.fsG.fsP;
        alg.gfa = str;
        alg.wqH = i;
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", str, Integer.valueOf(i));
        AppMethodBeat.o(78849);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78850);
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY, Integer.valueOf(this.version));
        if (i3 == 0) {
            alh alh = (alh) ((b) qVar).fsH.fsP;
            u ob = ((c) g.K(c.class)).XV().ob(this.geY);
            long j = 4294967295L & ((long) alh.wqI);
            ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", Integer.valueOf(alh.wqI), Integer.valueOf(this.version));
            if (((long) this.version) < j) {
                ob.Mk(alh.wqI);
                List list = alh.wqJ == null ? null : alh.wqJ.vEN;
                String str2 = "MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail";
                String str3 = "updateMemberDetail memInfoList size[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
                ab.i(str2, str3, objArr);
                ob.v(r.Yz(), com.tencent.mm.openim.room.a.b.c.ao(list));
                ((c) g.K(c.class)).XV().a(ob);
                bgb bgb = alh.wqJ;
                com.tencent.mm.openim.room.a.c cVar = new com.tencent.mm.openim.room.a.c();
                if (bgb != null) {
                    LinkedList<bge> linkedList = bgb.vEN;
                    bd XM = ((j) g.K(j.class)).XM();
                    i act = o.act();
                    LinkedList linkedList2 = new LinkedList();
                    LinkedList linkedList3 = new LinkedList();
                    int size = linkedList == null ? -1 : linkedList.size();
                    ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", Integer.valueOf(size));
                    if (size >= 0) {
                        if (((long) size) > WXHardCoderJNI.hcUpdateChatroomMemberCount) {
                            size = 0;
                        } else {
                            int doL;
                            boolean z = WXHardCoderJNI.hcUpdateChatroomEnable;
                            int i4 = WXHardCoderJNI.hcUpdateChatroomDelay;
                            int i5 = WXHardCoderJNI.hcUpdateChatroomCPU;
                            int i6 = WXHardCoderJNI.hcUpdateChatroomIO;
                            if (WXHardCoderJNI.hcUpdateChatroomThr) {
                                doL = g.RS().doL();
                            } else {
                                doL = 0;
                            }
                            size = WXHardCoderJNI.startPerformance(z, i4, i5, i6, doL, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
                        }
                        cVar.ehv = size;
                        for (bge bge : linkedList) {
                            if (!(bgb.wKf != 0 || bo.isNullOrNil(bge.userName) || bo.isNullOrNil(bge.wck))) {
                                h qo = act.qo(bge.userName);
                                if (qo == null) {
                                    qo = new h();
                                    qo.username = bge.userName;
                                }
                                qo.frW = bge.wcj;
                                qo.frV = bge.wck;
                                qo.dtR = 3;
                                qo.cB(!bo.isNullOrNil(bge.wcj));
                                linkedList3.add(qo);
                            }
                            ad aoO = XM.aoO(bge.userName);
                            if (aoO == null) {
                                ab.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
                            } else {
                                if (aoO.NZ()) {
                                    aoO.iB(bge.bCu);
                                    linkedList2.add(new Pair(bge.userName, aoO));
                                }
                                if (!bo.isNullOrNil(bge.appId)) {
                                    aoO.iK(bge.appId);
                                }
                                if (!bo.isNullOrNil(bge.wKh)) {
                                    aoO.iJ(bge.wKh);
                                }
                                XM.Y(aoO);
                                if (!bo.isNullOrNil(bge.appId)) {
                                    ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).u(bge.appId, aa.gw(ah.getContext()), bge.wKh);
                                }
                            }
                        }
                        ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList2.size()));
                        if (!linkedList3.isEmpty()) {
                            cVar.mG(1);
                            new ap(g.RS().oAl.getLooper(), new AnonymousClass1(linkedList3, cVar, act), true).ae(100, 100);
                        }
                        if (!linkedList2.isEmpty()) {
                            cVar.mG(2);
                            new ap(g.RS().oAl.getLooper(), new AnonymousClass2(linkedList2, cVar, XM), true).ae(100, 100);
                        }
                    }
                }
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78850);
    }

    public final int getType() {
        return 942;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(78851);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78851);
        return a;
    }
}
