package com.tencent.p177mm.chatroom.p710c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17881i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7281qf;
import com.tencent.p177mm.protocal.protobuf.ahg;
import com.tencent.p177mm.protocal.protobuf.ahh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.c.k */
public final class C6402k extends C1207m implements C1918k {
    private final String chatroomName;
    private final C7472b ehh;
    private C1202f ehi = null;
    private int ehu = 0;
    private int ehv;

    public C6402k(String str, int i) {
        int i2;
        AppMethodBeat.m2504i(103933);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ahg();
        c1196a.fsK = new ahh();
        c1196a.uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
        c1196a.fsI = 551;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.chatroomName = str;
        int drT = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(str).drT();
        ((ahg) this.ehh.fsG.fsP).wnM = str;
        ahg ahg = (ahg) this.ehh.fsG.fsP;
        if (drT < i) {
            i2 = i;
        } else {
            i2 = drT;
        }
        ahg.vKd = i2;
        C4990ab.m7417i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", str, Integer.valueOf(i), Integer.valueOf(drT), C5046bo.dpG());
        AppMethodBeat.m2505o(103933);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103934);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103934);
        return a;
    }

    public final int getType() {
        return 551;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103935);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7417i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            ahh ahh = (ahh) this.ehh.fsH.fsP;
            C7577u ob = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(this.chatroomName);
            long drT = (long) ob.drT();
            long j = 4294967295L & ((long) ahh.jBs);
            String str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str3 = "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(ahh.jBs);
            objArr[1] = Integer.valueOf(ahh.wnN == null ? 0 : ahh.wnN.ehB);
            objArr[2] = Long.valueOf(drT);
            C4990ab.m7417i(str2, str3, objArr);
            if (drT >= j) {
                C4990ab.m7413e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", Long.valueOf(drT), Long.valueOf(j));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(103935);
                return;
            }
            int i4;
            final LinkedList linkedList;
            ob.mo16787Mk(ahh.jBs);
            if (ahh.wnN == null) {
                List list = null;
            } else {
                Object list2 = ahh.wnN.vXi;
            }
            String str4 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            str2 = "summerChatRoom memInfoList size[%d]";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(list2 == null ? -1 : list2.size());
            C4990ab.m7417i(str4, str2, objArr2);
            ob.mo16809v(C1853r.m3846Yz(), list2);
            ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10099a(ob);
            C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
            C17881i act = C17884o.act();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            C4990ab.m7417i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", Integer.valueOf(list2 == null ? -1 : list2.size()));
            if (((long) (list2 == null ? -1 : list2.size())) > WXHardCoderJNI.hcUpdateChatroomMemberCount) {
                i4 = 0;
            } else {
                int doL;
                boolean z = WXHardCoderJNI.hcUpdateChatroomEnable;
                int i5 = WXHardCoderJNI.hcUpdateChatroomDelay;
                int i6 = WXHardCoderJNI.hcUpdateChatroomCPU;
                int i7 = WXHardCoderJNI.hcUpdateChatroomIO;
                if (WXHardCoderJNI.hcUpdateChatroomThr) {
                    doL = C1720g.m3539RS().doL();
                } else {
                    doL = 0;
                }
                i4 = WXHardCoderJNI.startPerformance(z, i5, i6, i7, doL, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
            }
            this.ehv = i4;
            for (C7281qf c7281qf : list2) {
                if (!(C5046bo.isNullOrNil(c7281qf.vXn) || C5046bo.isNullOrNil(c7281qf.jBB))) {
                    C17880h qo = act.mo33392qo(c7281qf.jBB);
                    if (qo == null) {
                        qo = new C17880h();
                        qo.username = c7281qf.jBB;
                    } else {
                        qo.acl().equals(c7281qf.vXn);
                    }
                    qo.frW = c7281qf.vXm;
                    qo.frV = c7281qf.vXn;
                    qo.dtR = 3;
                    qo.mo33385cB(!C5046bo.isNullOrNil(c7281qf.vXm));
                    linkedList3.add(qo);
                }
                C7616ad aoO = XM.aoO(c7281qf.jBB);
                if (aoO == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
                } else if (aoO.mo16695NZ()) {
                    aoO.mo14703iB(c7281qf.jCH);
                    linkedList2.add(new Pair(c7281qf.jBB, aoO));
                }
            }
            C4990ab.m7411d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList2.size()));
            if (!linkedList3.isEmpty()) {
                this.ehu |= 1;
                linkedList = linkedList3;
                final C17881i c17881i = act;
                new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C5015a() {
                    /* renamed from: BI */
                    public final boolean mo4499BI() {
                        AppMethodBeat.m2504i(103931);
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        C4990ab.m7411d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(size));
                        if (size == 0) {
                            C6402k.m10561a(C6402k.this, 1);
                            C4990ab.m7416i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
                            AppMethodBeat.m2505o(103931);
                            return false;
                        } else if (linkedList.isEmpty()) {
                            C6402k.m10561a(C6402k.this, 1);
                            C4990ab.m7416i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            AppMethodBeat.m2505o(103931);
                            return false;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                            for (int i = 0; i < size; i++) {
                                C17880h c17880h = (C17880h) linkedList.poll();
                                if (c17880h == null) {
                                    break;
                                }
                                c17881i.mo33391b(c17880h);
                            }
                            C1720g.m3536RP().eJN.mo15640mB(iV);
                            C4990ab.m7411d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            if (linkedList.isEmpty()) {
                                C6402k.m10561a(C6402k.this, 1);
                                C4990ab.m7416i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                                AppMethodBeat.m2505o(103931);
                                return false;
                            }
                            AppMethodBeat.m2505o(103931);
                            return true;
                        }
                    }
                }, true).mo16770ae(100, 100);
            }
            if (!linkedList2.isEmpty()) {
                this.ehu |= 2;
                linkedList = linkedList2;
                final C7309bd c7309bd = XM;
                new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C5015a() {
                    /* renamed from: BI */
                    public final boolean mo4499BI() {
                        AppMethodBeat.m2504i(103932);
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        C4990ab.m7411d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(size));
                        if (size == 0) {
                            C6402k.m10561a(C6402k.this, 2);
                            C4990ab.m7416i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
                            AppMethodBeat.m2505o(103932);
                            return false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                        for (int i = 0; i < size; i++) {
                            Pair pair = (Pair) linkedList.poll();
                            c7309bd.mo15724b((String) pair.first, (C7616ad) pair.second);
                        }
                        C1720g.m3536RP().eJN.mo15640mB(iV);
                        C4990ab.m7411d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (linkedList.isEmpty()) {
                            C6402k.m10561a(C6402k.this, 2);
                            C4990ab.m7416i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
                            AppMethodBeat.m2505o(103932);
                            return false;
                        }
                        AppMethodBeat.m2505o(103932);
                        return true;
                    }
                }, true).mo16770ae(100, 100);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(103935);
            return;
        }
        C4990ab.m7413e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103935);
    }
}
