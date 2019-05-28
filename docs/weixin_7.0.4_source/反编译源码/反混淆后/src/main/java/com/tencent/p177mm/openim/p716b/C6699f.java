package com.tencent.p177mm.openim.p716b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.room.p266a.C18742b.C1938c;
import com.tencent.p177mm.openim.room.p266a.C18743c;
import com.tencent.p177mm.openim.room.p266a.C42249a.C67011;
import com.tencent.p177mm.openim.room.p266a.C42249a.C97762;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17881i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.alg;
import com.tencent.p177mm.protocal.protobuf.alh;
import com.tencent.p177mm.protocal.protobuf.bgb;
import com.tencent.p177mm.protocal.protobuf.bge;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.openim.b.f */
public final class C6699f extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private final String geY;
    private final int version;

    public C6699f(String str, int i) {
        AppMethodBeat.m2504i(78849);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new alg();
        c1196a.fsK = new alh();
        c1196a.uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
        this.ehh = c1196a.acD();
        this.geY = str;
        this.version = i;
        alg alg = (alg) this.ehh.fsG.fsP;
        alg.gfa = str;
        alg.wqH = i;
        C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", str, Integer.valueOf(i));
        AppMethodBeat.m2505o(78849);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78850);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY, Integer.valueOf(this.version));
        if (i3 == 0) {
            alh alh = (alh) ((C7472b) c1929q).fsH.fsP;
            C7577u ob = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(this.geY);
            long j = 4294967295L & ((long) alh.wqI);
            C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", Integer.valueOf(alh.wqI), Integer.valueOf(this.version));
            if (((long) this.version) < j) {
                ob.mo16787Mk(alh.wqI);
                List list = alh.wqJ == null ? null : alh.wqJ.vEN;
                String str2 = "MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail";
                String str3 = "updateMemberDetail memInfoList size[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(list == null ? -1 : list.size());
                C4990ab.m7417i(str2, str3, objArr);
                ob.mo16809v(C1853r.m3846Yz(), C1938c.m4138ao(list));
                ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10099a(ob);
                bgb bgb = alh.wqJ;
                C18743c c18743c = new C18743c();
                if (bgb != null) {
                    LinkedList<bge> linkedList = bgb.vEN;
                    C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
                    C17881i act = C17884o.act();
                    LinkedList linkedList2 = new LinkedList();
                    LinkedList linkedList3 = new LinkedList();
                    int size = linkedList == null ? -1 : linkedList.size();
                    C4990ab.m7417i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", Integer.valueOf(size));
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
                                doL = C1720g.m3539RS().doL();
                            } else {
                                doL = 0;
                            }
                            size = WXHardCoderJNI.startPerformance(z, i4, i5, i6, doL, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
                        }
                        c18743c.ehv = size;
                        for (bge bge : linkedList) {
                            if (!(bgb.wKf != 0 || C5046bo.isNullOrNil(bge.userName) || C5046bo.isNullOrNil(bge.wck))) {
                                C17880h qo = act.mo33392qo(bge.userName);
                                if (qo == null) {
                                    qo = new C17880h();
                                    qo.username = bge.userName;
                                }
                                qo.frW = bge.wcj;
                                qo.frV = bge.wck;
                                qo.dtR = 3;
                                qo.mo33385cB(!C5046bo.isNullOrNil(bge.wcj));
                                linkedList3.add(qo);
                            }
                            C7616ad aoO = XM.aoO(bge.userName);
                            if (aoO == null) {
                                C4990ab.m7412e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
                            } else {
                                if (aoO.mo16695NZ()) {
                                    aoO.mo14703iB(bge.bCu);
                                    linkedList2.add(new Pair(bge.userName, aoO));
                                }
                                if (!C5046bo.isNullOrNil(bge.appId)) {
                                    aoO.mo14712iK(bge.appId);
                                }
                                if (!C5046bo.isNullOrNil(bge.wKh)) {
                                    aoO.mo14711iJ(bge.wKh);
                                }
                                XM.mo15701Y(aoO);
                                if (!C5046bo.isNullOrNil(bge.appId)) {
                                    ((C32873b) C1720g.m3528K(C32873b.class)).mo44309u(bge.appId, C4988aa.m7403gw(C4996ah.getContext()), bge.wKh);
                                }
                            }
                        }
                        C4990ab.m7411d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList2.size()));
                        if (!linkedList3.isEmpty()) {
                            c18743c.mo34002mG(1);
                            new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C67011(linkedList3, c18743c, act), true).mo16770ae(100, 100);
                        }
                        if (!linkedList2.isEmpty()) {
                            c18743c.mo34002mG(2);
                            new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C97762(linkedList2, c18743c, XM), true).mo16770ae(100, 100);
                        }
                    }
                }
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(78850);
    }

    public final int getType() {
        return 942;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78851);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78851);
        return a;
    }
}
