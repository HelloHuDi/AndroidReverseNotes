package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.c.at;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c extends com.tencent.mm.sdk.b.c<qu> implements com.tencent.mm.aq.b.a, com.tencent.mm.sdk.e.k.a, b {
    public final com.tencent.mm.sdk.b.c fCr = new com.tencent.mm.sdk.b.c<hk>() {
        {
            AppMethodBeat.i(16456);
            this.xxI = hk.class.getName().hashCode();
            AppMethodBeat.o(16456);
        }

        private static boolean a(hk hkVar) {
            AppMethodBeat.i(16457);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.tencent.mm.plugin.messenger.foundation.a.a.b bOm = ((j) g.K(j.class)).bOm();
                long j;
                if (bOm.QL(hkVar.cCg.username)) {
                    String str = hkVar.cCg.username;
                    bi Rc = ((j) g.K(j.class)).bOr().Rc(str);
                    long j2 = hkVar.cCg.cCh;
                    long j3 = hkVar.cCg.cCi;
                    w QN = bOm.QN(str);
                    long j4 = QN.field_lastLocalSeq;
                    ab.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(QN.field_lastLocalCreateTime), Long.valueOf(QN.field_lastPushSeq), Long.valueOf(QN.field_lastPushCreateTime));
                    if (Rc == null || Rc.field_msgId == 0) {
                        String str2 = "MicroMsg.GetChatroomMsgReceiver";
                        String str3 = "lastMsgInfo is null? %s lastMsgInfo id:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(Rc == null);
                        if (Rc == null) {
                            j = -1;
                        } else {
                            j = Rc.field_msgId;
                        }
                        objArr[1] = Long.valueOf(j);
                        ab.w(str2, str3, objArr);
                    } else {
                        long j5 = Rc.field_msgSeq;
                        if (j5 > j4) {
                            QN.field_lastLocalSeq = j5;
                            QN.field_lastLocalCreateTime = Rc.field_createTime;
                            com.tencent.mm.j.a.a.c cVar = new com.tencent.mm.j.a.a.c();
                            cVar.eoC = 1 + j4;
                            cVar.eoE = r16 + 1;
                            cVar.eoD = j5 - 1;
                            cVar.eoF = r20 - 1;
                            if (QN.field_seqBlockInfo == null) {
                                QN.field_seqBlockInfo = new d();
                            }
                            QN.field_seqBlockInfo.eoG.addLast(cVar);
                            long b = bOm.b(QN);
                            ab.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", Long.valueOf(b));
                        }
                        if (r18 < j2) {
                            boolean I = bOm.I(str, j2);
                            boolean K = bOm.K(str, j3);
                            ab.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", Boolean.valueOf(I), Boolean.valueOf(K), Long.valueOf(Rc.field_msgSeq), Long.valueOf(j4));
                        }
                    }
                    ab.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(16457);
                    return true;
                }
                w wVar = new w();
                wVar.field_username = hkVar.cCg.username;
                if (hkVar.cCg.cCh <= hkVar.cCg.cCj) {
                    j = hkVar.cCg.cCj;
                } else {
                    j = hkVar.cCg.cCh;
                }
                wVar.field_lastPushSeq = j;
                wVar.field_lastLocalSeq = hkVar.cCg.cCj;
                wVar.field_lastPushCreateTime = hkVar.cCg.cCi;
                wVar.field_lastLocalCreateTime = hkVar.cCg.cCk;
                j = bOm.a(wVar, true);
                com.tencent.mm.ui.chatting.j.b bVar = com.tencent.mm.ui.chatting.j.b.yZH;
                com.tencent.mm.ui.chatting.j.b.dGX();
                ab.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", Long.valueOf(j), hkVar.cCg.username, Long.valueOf(hkVar.cCg.cCh), Long.valueOf(hkVar.cCg.cCi), Long.valueOf(hkVar.cCg.cCj), Long.valueOf(hkVar.cCg.cCk));
                ab.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(16457);
                return true;
            } catch (Throwable th) {
                ab.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(16457);
            }
        }
    };
    private Map<Long, bb> fCs = new HashMap();

    static class a implements Runnable {
        qu fCu;

        /* synthetic */ a(qu quVar, byte b) {
            this(quVar);
        }

        private a(qu quVar) {
            this.fCu = quVar;
        }

        public final void run() {
            AppMethodBeat.i(16459);
            long currentTimeMillis = System.currentTimeMillis();
            if (g.RK()) {
                byte[] bArr = this.fCu.cMZ.data;
                if (bArr != null) {
                    String formatTime;
                    long j;
                    String str;
                    Object obj;
                    ak akVar;
                    int i;
                    cn cnVar = new cn();
                    try {
                        cnVar.parseFrom(bArr);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", e, "", new Object[0]);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String a = aa.a(cnVar.vEJ);
                    int i2 = cnVar.vEI;
                    long j2 = 1000 * ((long) cnVar.pcX);
                    com.tencent.mm.plugin.messenger.foundation.a.a.b bOm = ((j) g.K(j.class)).bOm();
                    if (bOm.QL(a)) {
                        boolean I = bOm.I(a, (long) i2);
                        boolean K = bOm.K(a, j2);
                        ab.i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", a, Integer.valueOf(i2), Boolean.valueOf(I), Long.valueOf(j2), Boolean.valueOf(K));
                    } else {
                        cy cyVar;
                        cy Rc = ((j) g.K(j.class)).bOr().Rc(a);
                        if (Rc == null || Rc.field_msgId != 0) {
                            cyVar = Rc;
                        } else {
                            ab.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
                            cyVar = null;
                        }
                        if (cyVar != null) {
                            formatTime = h.formatTime("yyyy-MM-dd HH:mm:ss", cyVar.field_createTime / 1000);
                            ab.w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", bo.anv(cyVar.field_content), formatTime);
                        }
                        w wVar = new w();
                        wVar.field_username = a;
                        wVar.field_lastPushSeq = (long) i2;
                        if (cyVar != null) {
                            j = cyVar.field_msgSeq;
                        } else {
                            j = (long) (i2 - 1);
                        }
                        wVar.field_lastLocalSeq = j;
                        wVar.field_lastPushCreateTime = j2;
                        if (cyVar != null) {
                            j = cyVar.field_createTime;
                        } else {
                            j = j2 - 1;
                        }
                        wVar.field_lastLocalCreateTime = j;
                        j = bOm.a(wVar);
                        str = "MicroMsg.GetChatroomMsgReceiver";
                        String str2 = "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s";
                        Object[] objArr = new Object[6];
                        objArr[0] = Long.valueOf(j);
                        objArr[1] = a;
                        objArr[2] = Integer.valueOf(i2);
                        objArr[3] = Long.valueOf(j2);
                        if (cyVar != null) {
                            j = cyVar.field_msgSeq;
                        } else {
                            j = (long) (i2 - 1);
                        }
                        objArr[4] = Long.valueOf(j);
                        if (cyVar != null) {
                            j = cyVar.field_createTime;
                        } else {
                            j = j2 - 1;
                        }
                        objArr[5] = Long.valueOf(j);
                        ab.i(str, str2, objArr);
                        com.tencent.mm.ui.chatting.j.b bVar = com.tencent.mm.ui.chatting.j.b.yZH;
                        com.tencent.mm.ui.chatting.j.b.dGX();
                    }
                    ab.d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - currentTimeMillis2));
                    j2 = System.currentTimeMillis();
                    str = aa.a(cnVar.vEJ);
                    int i3 = cnVar.vEI;
                    j = cnVar.ptF;
                    int i4 = cnVar.pcX;
                    int i5 = cnVar.vEM;
                    int i6 = cnVar.nao;
                    int i7 = cnVar.vEK;
                    String a2 = aa.a(cnVar.vEL);
                    ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", str, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i7), bo.anv(a2));
                    ak aoZ = ((j) g.K(j.class)).XR().aoZ(str);
                    if (aoZ == null) {
                        at akVar2 = new ak(str);
                        akVar2.eD(((long) i4) * 1000);
                        akVar2.eF((long) i3);
                        akVar2.hM(1);
                        akVar2.hT(1);
                        b.agG();
                        b.rX(str);
                        j = ((j) g.K(j.class)).Yo().QP(str);
                        ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", Long.valueOf(j), Integer.valueOf(i3));
                        if (j <= 0) {
                            j = (long) i3;
                        }
                        akVar2.eG(j);
                        obj = 1;
                        akVar = akVar2;
                    } else {
                        i2 = (int) aoZ.field_lastSeq;
                        if (i3 > i2) {
                            aoZ.eF((long) i3);
                            i = aoZ.field_UnDeliverCount;
                            aoZ.hT(i7);
                            aoZ.eD(((long) i4) * 1000);
                            if (i7 > aoZ.field_unReadCount) {
                                aoZ.hM(i7);
                            } else {
                                aoZ.hM((i7 - i) + aoZ.field_unReadCount);
                            }
                            ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", Integer.valueOf(i3), Long.valueOf(aoZ.field_firstUnDeliverSeq), Integer.valueOf(i2));
                            if (aoZ.field_firstUnDeliverSeq > 0) {
                                bi R = ((j) g.K(j.class)).bOr().R(str, (long) i2);
                                if (R.field_msgId > 0) {
                                    aoZ.eG(R.field_msgSeq);
                                }
                                obj = null;
                                akVar = aoZ;
                            } else {
                                currentTimeMillis2 = ((j) g.K(j.class)).Yo().QP(str);
                                if (currentTimeMillis2 > 0) {
                                    aoZ.eG(currentTimeMillis2);
                                    obj = null;
                                    akVar = aoZ;
                                } else {
                                    currentTimeMillis2 = ((j) g.K(j.class)).bOr().Ru(str);
                                    ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", Long.valueOf(currentTimeMillis2));
                                    if (currentTimeMillis2 > 0) {
                                        aoZ.eG(currentTimeMillis2);
                                    }
                                    obj = null;
                                    akVar = aoZ;
                                }
                            }
                        } else {
                            if (i3 == i2 && i7 == 0 && aoZ.field_unReadCount > 0) {
                                aoZ.hM(0);
                            }
                            obj = null;
                            akVar = aoZ;
                        }
                    }
                    if (i5 > 0) {
                        akVar.hR(akVar.field_atCount + i5);
                    }
                    bi biVar = new bi();
                    biVar.hO(0);
                    biVar.ju(str);
                    biVar.setType(i6);
                    biVar.setContent(a2);
                    if (i6 == 49) {
                        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(com.tencent.mm.pluginsdk.model.app.j.hE(str, a2));
                        biVar.setType(l.d(me));
                        biVar.setContent(biVar.drC() ? me.content : a2);
                    } else if (i6 == 10002) {
                        ((p) g.M(p.class)).getSysCmdMsgExtension();
                        if (biVar.getType() == 10002 && !bo.isNullOrNil(a2)) {
                            if (bo.isNullOrNil(a2)) {
                                ab.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                            } else {
                                Map map;
                                String str3;
                                if (a2.startsWith("~SEMI_XML~")) {
                                    Map amR = be.amR(a2);
                                    if (amR == null) {
                                        ab.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                                    } else {
                                        map = amR;
                                        str3 = "brand_service";
                                    }
                                } else {
                                    i = a2.indexOf("<sysmsg");
                                    if (i == -1) {
                                        ab.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                                    } else {
                                        Map z = br.z(a2.substring(i), "sysmsg");
                                        if (z == null) {
                                            ab.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                                        } else {
                                            map = z;
                                            str3 = (String) z.get(".sysmsg.$type");
                                        }
                                    }
                                }
                                if (str3 != null && str3.equals("revokemsg")) {
                                    ab.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                    map.get(".sysmsg.revokemsg.session");
                                    formatTime = (String) map.get(".sysmsg.revokemsg.newmsgid");
                                    ab.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", formatTime, (String) map.get(".sysmsg.revokemsg.replacemsg"));
                                    biVar.setContent(a2);
                                    biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                                }
                            }
                        }
                    }
                    akVar.hO(0);
                    akVar.setContent(biVar.field_content);
                    akVar.jg(Integer.toString(biVar.getType()));
                    com.tencent.mm.storage.be.b Cb = ((j) g.K(j.class)).XR().Cb();
                    if (Cb != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Cb.a(biVar, pString, pString2, pInt, false);
                        akVar.jh(pString.value);
                        akVar.ji(pString2.value);
                        akVar.hP(pInt.value);
                        if (biVar.getType() == 49) {
                            formatTime = (String) br.z(akVar.field_content, "msg").get(".msg.appmsg.title");
                            String nullAsNil = bo.nullAsNil(akVar.field_digest);
                            if (bo.isNullOrNil(formatTime)) {
                                formatTime = "";
                            } else {
                                formatTime = " " + bo.nullAsNil(formatTime);
                            }
                            akVar.jh(nullAsNil.concat(formatTime));
                        }
                    } else {
                        akVar.jh(akVar.field_content);
                    }
                    if (obj != null) {
                        j = ((j) g.K(j.class)).XR().d(akVar);
                        ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", str, Long.valueOf(j), Long.valueOf(akVar.field_firstUnDeliverSeq), Long.valueOf(akVar.field_lastSeq), Integer.valueOf(akVar.field_UnDeliverCount));
                    } else {
                        akVar.hQ(akVar.field_attrflag & -1048577);
                        j = (long) ((j) g.K(j.class)).XR().a(akVar, str, true);
                        ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", str, Long.valueOf(j), Long.valueOf(akVar.field_firstUnDeliverSeq), Long.valueOf(akVar.field_lastSeq), Integer.valueOf(akVar.field_UnDeliverCount));
                    }
                    ab.d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - j2));
                } else {
                    ab.e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
                }
            } else {
                ab.w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
            }
            ab.d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(16459);
        }
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(16466);
        g.RS().aa(new a((qu) bVar, (byte) 0));
        AppMethodBeat.o(16466);
        return true;
    }

    public c() {
        AppMethodBeat.i(16460);
        com.tencent.mm.sdk.b.a.xxA.c(this.fCr);
        b.agG().fCk = this;
        ((j) g.K(j.class)).XR().a(this, g.RS().oAl.getLooper());
        n.ahX();
        n.ahV().a(this, aw.RS().oAl.getLooper());
        this.xxI = qu.class.getName().hashCode();
        AppMethodBeat.o(16460);
    }

    public final void a(String str, boolean z, LinkedList<bi> linkedList, com.tencent.mm.j.a.a.c cVar, boolean z2) {
        AppMethodBeat.i(16461);
        long j;
        com.tencent.mm.plugin.messenger.foundation.a.a.b bOm;
        if (linkedList.size() <= 0 || z2) {
            ab.w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(z2)));
            long j2 = cVar.eoC;
            j = cVar.eoD;
            ab.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j + " chatroomId:" + str);
            bOm = ((j) g.K(j.class)).bOm();
            w QN = bOm.QN(str);
            if (QN.field_seqBlockInfo != null) {
                LinkedList linkedList2 = new LinkedList();
                Iterator it = QN.field_seqBlockInfo.eoG.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.j.a.a.c cVar2 = (com.tencent.mm.j.a.a.c) it.next();
                    if (cVar2.eoC == j2 && cVar2.eoD == j) {
                        linkedList2.add(cVar2);
                        break;
                    }
                }
                QN.field_seqBlockInfo.eoG.removeAll(linkedList2);
                ab.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j + " chatroomId:" + str + " ret:" + bOm.b(QN) + " remove list:" + linkedList2.size());
                if (linkedList2.size() > 0) {
                    com.tencent.mm.ui.chatting.j.b bVar = com.tencent.mm.ui.chatting.j.b.yZH;
                    com.tencent.mm.ui.chatting.j.b.dGZ();
                }
            }
            QN.field_lastLocalSeq = QN.field_lastPushSeq;
            QN.field_lastLocalCreateTime = QN.field_lastPushCreateTime;
            ab.i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j + " chatroomId:" + str + " ret:" + bOm.b(QN) + " lastPushSeq:" + QN.field_lastPushSeq + " field_lastPushCreateTime:" + QN.field_lastPushCreateTime);
            AppMethodBeat.o(16461);
            return;
        }
        ab.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", Integer.valueOf(linkedList.size()), Boolean.valueOf(z));
        bOm = ((j) g.K(j.class)).bOm();
        List a = a(str, (LinkedList) linkedList);
        d QK = bOm.QK(str);
        QK.eoG.clear();
        QK.eoG.addAll(a);
        boolean a2 = bOm.a(str, QK);
        j = ((bi) linkedList.getLast()).field_msgSeq;
        long j3 = ((bi) linkedList.getLast()).field_createTime;
        long QH = bOm.QH(str);
        long QJ = bOm.QJ(str);
        ab.i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", Integer.valueOf(QK.eoG.size()), Boolean.valueOf(a2), Long.valueOf(j), Long.valueOf(QH), Long.valueOf(j3), Long.valueOf(QJ));
        if (QH < j) {
            bOm.L(str, j);
            bOm.J(str, j3);
        } else {
            ab.w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", Long.valueOf(QH), Long.valueOf(j));
        }
        e(new HashMap(this.fCs), str);
        AppMethodBeat.o(16461);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(16462);
        if (nVar == ((j) g.K(j.class)).XR() && (obj instanceof String) && 5 == i) {
            com.tencent.mm.plugin.messenger.foundation.a.a.b bOm = ((j) g.K(j.class)).bOm();
            String str = (String) obj;
            if (bOm.QL(str)) {
                w QN = bOm.QN(str);
                if (QN.field_seqBlockInfo != null) {
                    QN.field_seqBlockInfo.eoG.clear();
                }
                QN.field_lastLocalSeq = QN.field_lastPushSeq;
                QN.field_lastLocalCreateTime = QN.field_lastPushCreateTime;
                ab.i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + str + " ret:" + bOm.b(QN) + " chatroomMsgSeq:" + QN.toString());
            }
        }
        AppMethodBeat.o(16462);
    }

    private static List<com.tencent.mm.j.a.a.c> a(String str, LinkedList<bi> linkedList) {
        AppMethodBeat.i(16463);
        com.tencent.mm.plugin.messenger.foundation.a.a.b bOm = ((j) g.K(j.class)).bOm();
        d QK = bOm.QK(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nchatroomId:").append(str);
        long j = ((bi) linkedList.getFirst()).field_msgSeq;
        long j2 = ((bi) linkedList.getLast()).field_msgSeq;
        long j3 = ((bi) linkedList.getFirst()).field_createTime;
        long j4 = ((bi) linkedList.getLast()).field_createTime;
        stringBuilder.append("\ngetFirst:").append(j);
        stringBuilder.append(" getLast:").append(j2);
        stringBuilder.append(" getFirstCreateTime:").append(j3);
        stringBuilder.append(" getLastCreateTime:").append(j4);
        stringBuilder.append("\nblock ");
        com.tencent.mm.j.a.a.c cVar = new com.tencent.mm.j.a.a.c();
        cVar.eoC = bOm.QH(str) + 1;
        cVar.eoE = bOm.QJ(str) + 1;
        cVar.eoD = bOm.QG(str);
        cVar.eoF = bOm.QI(str);
        if (cVar.eoD - cVar.eoC >= 0) {
            QK.eoG.add(cVar);
        } else {
            ab.w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", Long.valueOf(cVar.eoD), Long.valueOf(cVar.eoC));
        }
        LinkedList<com.tencent.mm.j.a.a.c> linkedList2 = new LinkedList();
        Iterator it = QK.eoG.iterator();
        while (it.hasNext()) {
            com.tencent.mm.j.a.a.c cVar2;
            cVar = (com.tencent.mm.j.a.a.c) it.next();
            Object obj = null;
            long j5 = cVar.eoC;
            long j6 = cVar.eoD;
            long j7 = cVar.eoE;
            long j8 = cVar.eoF;
            stringBuilder.append("[").append(j5).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(j6).append("][").append(j7).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(j8).append("] | ");
            if (j5 <= j && j <= j6) {
                cVar2 = new com.tencent.mm.j.a.a.c();
                cVar2.eoC = cVar.eoC;
                cVar2.eoD = j - 1;
                cVar2.eoE = j7;
                cVar2.eoF = j3 - 1;
                if (cVar2.eoD - cVar2.eoC >= 0) {
                    linkedList2.add(cVar2);
                    obj = 1;
                }
            }
            if (j5 <= j2 && j2 <= j6) {
                cVar2 = new com.tencent.mm.j.a.a.c();
                cVar2.eoC = 1 + j2;
                cVar2.eoD = j6;
                cVar2.eoE = 1 + j4;
                cVar2.eoF = j8;
                if (cVar2.eoD - cVar2.eoC >= 0) {
                    linkedList2.add(cVar2);
                    obj = 1;
                }
            }
            if (obj == null && (j > j6 || j2 < j5)) {
                linkedList2.add(cVar);
                ab.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (com.tencent.mm.j.a.a.c cVar3 : linkedList2) {
            stringBuilder2.append("[").append(cVar3.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cVar3.eoD).append("][").append(cVar3.eoE).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cVar3.eoF).append("] | ");
        }
        ab.i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + stringBuilder.toString() + "\nnew blockList:" + stringBuilder2.toString());
        AppMethodBeat.o(16463);
        return linkedList2;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(16464);
        if (!ah.isNullOrNil(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                bb bbVar = new bb();
                bbVar.field_originSvrId = longValue;
                n.ahX();
                if (n.ahV().b(bbVar, new String[0])) {
                    this.fCs.put(Long.valueOf(longValue), bbVar);
                    ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", Long.valueOf(bbVar.xDa), Long.valueOf(longValue));
                    AppMethodBeat.o(16464);
                    return;
                }
                this.fCs.remove(Long.valueOf(longValue));
                ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", Long.valueOf(longValue));
                AppMethodBeat.o(16464);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", e, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
            }
        }
        AppMethodBeat.o(16464);
    }

    private static void e(Map<Long, bb> map, String str) {
        AppMethodBeat.i(16465);
        if (map.size() == 0 || ah.isNullOrNil(str)) {
            AppMethodBeat.o(16465);
            return;
        }
        Iterator it = map.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                bb bbVar = (bb) it.next();
                if (bbVar != null && str.equals(bbVar.field_fromUserName)) {
                    aw.ZK();
                    if (com.tencent.mm.model.c.XO().Q(str, bbVar.field_originSvrId).field_msgId != 0) {
                        ab.i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", Long.valueOf(com.tencent.mm.model.c.XO().Q(str, bbVar.field_originSvrId).field_msgId), Long.valueOf(com.tencent.mm.model.c.XO().Q(str, bbVar.field_originSvrId).field_msgSvrId));
                        cm cmVar = new cm();
                        cmVar.ptF = bbVar.field_newMsgId;
                        cmVar.vEB = aa.vy(bbVar.field_fromUserName);
                        cmVar.vEC = aa.vy(bbVar.field_toUserName);
                        cmVar.pcX = (int) bbVar.field_createTime;
                        cmVar.vED = aa.vy(bbVar.field_content);
                        cmVar.vEG = bbVar.field_msgSource;
                        cmVar.vEI = bbVar.field_msgSeq;
                        int i = bbVar.field_flag;
                        cmVar.nao = 10002;
                        aw.getSysCmdMsgExtension().b(new com.tencent.mm.ai.e.a(cmVar, (i & 2) != 0, (i & 1) != 0, (i & 4) != 0));
                    }
                }
            }
        }
        AppMethodBeat.o(16465);
    }
}
