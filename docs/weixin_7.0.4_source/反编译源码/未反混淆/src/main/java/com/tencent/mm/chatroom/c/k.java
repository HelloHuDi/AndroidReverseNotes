package com.tencent.mm.chatroom.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.LinkedList;
import java.util.List;

public final class k extends m implements com.tencent.mm.network.k {
    private final String chatroomName;
    private final b ehh;
    private f ehi = null;
    private int ehu = 0;
    private int ehv;

    public k(String str, int i) {
        int i2;
        AppMethodBeat.i(103933);
        a aVar = new a();
        aVar.fsJ = new ahg();
        aVar.fsK = new ahh();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
        aVar.fsI = 551;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.chatroomName = str;
        int drT = ((c) g.K(c.class)).XV().ob(str).drT();
        ((ahg) this.ehh.fsG.fsP).wnM = str;
        ahg ahg = (ahg) this.ehh.fsG.fsP;
        if (drT < i) {
            i2 = i;
        } else {
            i2 = drT;
        }
        ahg.vKd = i2;
        ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", str, Integer.valueOf(i), Integer.valueOf(drT), bo.dpG());
        AppMethodBeat.o(103933);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103934);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103934);
        return a;
    }

    public final int getType() {
        return 551;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103935);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            ahh ahh = (ahh) this.ehh.fsH.fsP;
            u ob = ((c) g.K(c.class)).XV().ob(this.chatroomName);
            long drT = (long) ob.drT();
            long j = 4294967295L & ((long) ahh.jBs);
            String str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str3 = "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(ahh.jBs);
            objArr[1] = Integer.valueOf(ahh.wnN == null ? 0 : ahh.wnN.ehB);
            objArr[2] = Long.valueOf(drT);
            ab.i(str2, str3, objArr);
            if (drT >= j) {
                ab.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", Long.valueOf(drT), Long.valueOf(j));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(103935);
                return;
            }
            int i4;
            final LinkedList linkedList;
            ob.Mk(ahh.jBs);
            if (ahh.wnN == null) {
                List list = null;
            } else {
                Object list2 = ahh.wnN.vXi;
            }
            String str4 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            str2 = "summerChatRoom memInfoList size[%d]";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(list2 == null ? -1 : list2.size());
            ab.i(str4, str2, objArr2);
            ob.v(r.Yz(), list2);
            ((c) g.K(c.class)).XV().a(ob);
            bd XM = ((j) g.K(j.class)).XM();
            i act = o.act();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", Integer.valueOf(list2 == null ? -1 : list2.size()));
            if (((long) (list2 == null ? -1 : list2.size())) > WXHardCoderJNI.hcUpdateChatroomMemberCount) {
                i4 = 0;
            } else {
                int doL;
                boolean z = WXHardCoderJNI.hcUpdateChatroomEnable;
                int i5 = WXHardCoderJNI.hcUpdateChatroomDelay;
                int i6 = WXHardCoderJNI.hcUpdateChatroomCPU;
                int i7 = WXHardCoderJNI.hcUpdateChatroomIO;
                if (WXHardCoderJNI.hcUpdateChatroomThr) {
                    doL = g.RS().doL();
                } else {
                    doL = 0;
                }
                i4 = WXHardCoderJNI.startPerformance(z, i5, i6, i7, doL, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
            }
            this.ehv = i4;
            for (qf qfVar : list2) {
                if (!(bo.isNullOrNil(qfVar.vXn) || bo.isNullOrNil(qfVar.jBB))) {
                    h qo = act.qo(qfVar.jBB);
                    if (qo == null) {
                        qo = new h();
                        qo.username = qfVar.jBB;
                    } else {
                        qo.acl().equals(qfVar.vXn);
                    }
                    qo.frW = qfVar.vXm;
                    qo.frV = qfVar.vXn;
                    qo.dtR = 3;
                    qo.cB(!bo.isNullOrNil(qfVar.vXm));
                    linkedList3.add(qo);
                }
                ad aoO = XM.aoO(qfVar.jBB);
                if (aoO == null) {
                    ab.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
                } else if (aoO.NZ()) {
                    aoO.iB(qfVar.jCH);
                    linkedList2.add(new Pair(qfVar.jBB, aoO));
                }
            }
            ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList2.size()));
            if (!linkedList3.isEmpty()) {
                this.ehu |= 1;
                linkedList = linkedList3;
                final i iVar = act;
                new ap(g.RS().oAl.getLooper(), new ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(103931);
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(size));
                        if (size == 0) {
                            k.a(k.this, 1);
                            ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
                            AppMethodBeat.o(103931);
                            return false;
                        } else if (linkedList.isEmpty()) {
                            k.a(k.this, 1);
                            ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            AppMethodBeat.o(103931);
                            return false;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                            for (int i = 0; i < size; i++) {
                                h hVar = (h) linkedList.poll();
                                if (hVar == null) {
                                    break;
                                }
                                iVar.b(hVar);
                            }
                            g.RP().eJN.mB(iV);
                            ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            if (linkedList.isEmpty()) {
                                k.a(k.this, 1);
                                ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                                AppMethodBeat.o(103931);
                                return false;
                            }
                            AppMethodBeat.o(103931);
                            return true;
                        }
                    }
                }, true).ae(100, 100);
            }
            if (!linkedList2.isEmpty()) {
                this.ehu |= 2;
                linkedList = linkedList2;
                final bd bdVar = XM;
                new ap(g.RS().oAl.getLooper(), new ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(103932);
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(size));
                        if (size == 0) {
                            k.a(k.this, 2);
                            ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
                            AppMethodBeat.o(103932);
                            return false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                        for (int i = 0; i < size; i++) {
                            Pair pair = (Pair) linkedList.poll();
                            bdVar.b((String) pair.first, (ad) pair.second);
                        }
                        g.RP().eJN.mB(iV);
                        ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (linkedList.isEmpty()) {
                            k.a(k.this, 2);
                            ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
                            AppMethodBeat.o(103932);
                            return false;
                        }
                        AppMethodBeat.o(103932);
                        return true;
                    }
                }, true).ae(100, 100);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(103935);
            return;
        }
        ab.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103935);
    }
}
