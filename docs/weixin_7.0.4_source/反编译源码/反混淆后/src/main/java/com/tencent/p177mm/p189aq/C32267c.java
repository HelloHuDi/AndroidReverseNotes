package com.tencent.p177mm.p189aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p189aq.C6320b.C6322a;
import com.tencent.p177mm.p230g.p231a.C26225qu;
import com.tencent.p177mm.p230g.p231a.C37727hk;
import com.tencent.p177mm.p230g.p711c.C6563at;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p612ui.chatting.p1345j.C23797b;
import com.tencent.p177mm.p712j.p713a.p714a.C6594c;
import com.tencent.p177mm.p712j.p713a.p714a.C6595d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.model.app.C7237j;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.C23377cn;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C35996bb;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.p177mm.storage.C7578w;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.aq.c */
public final class C32267c extends C4884c<C26225qu> implements C6322a, C4931a, C4937b {
    public final C4884c fCr = new C63241();
    private Map<Long, C35996bb> fCs = new HashMap();

    /* renamed from: com.tencent.mm.aq.c$1 */
    class C63241 extends C4884c<C37727hk> {
        C63241() {
            AppMethodBeat.m2504i(16456);
            this.xxI = C37727hk.class.getName().hashCode();
            AppMethodBeat.m2505o(16456);
        }

        /* renamed from: a */
        private static boolean m10405a(C37727hk c37727hk) {
            AppMethodBeat.m2504i(16457);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                C6973b bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
                long j;
                if (bOm.mo15216QL(c37727hk.cCg.username)) {
                    String str = c37727hk.cCg.username;
                    C7620bi Rc = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15249Rc(str);
                    long j2 = c37727hk.cCg.cCh;
                    long j3 = c37727hk.cCg.cCi;
                    C7578w QN = bOm.mo15218QN(str);
                    long j4 = QN.field_lastLocalSeq;
                    C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(QN.field_lastLocalCreateTime), Long.valueOf(QN.field_lastPushSeq), Long.valueOf(QN.field_lastPushCreateTime));
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
                        C4990ab.m7421w(str2, str3, objArr);
                    } else {
                        long j5 = Rc.field_msgSeq;
                        if (j5 > j4) {
                            QN.field_lastLocalSeq = j5;
                            QN.field_lastLocalCreateTime = Rc.field_createTime;
                            C6594c c6594c = new C6594c();
                            c6594c.eoC = 1 + j4;
                            c6594c.eoE = r16 + 1;
                            c6594c.eoD = j5 - 1;
                            c6594c.eoF = r20 - 1;
                            if (QN.field_seqBlockInfo == null) {
                                QN.field_seqBlockInfo = new C6595d();
                            }
                            QN.field_seqBlockInfo.eoG.addLast(c6594c);
                            long b = bOm.mo15223b(QN);
                            C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", Long.valueOf(b));
                        }
                        if (r18 < j2) {
                            boolean I = bOm.mo15205I(str, j2);
                            boolean K = bOm.mo15207K(str, j3);
                            C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", Boolean.valueOf(I), Boolean.valueOf(K), Long.valueOf(Rc.field_msgSeq), Long.valueOf(j4));
                        }
                    }
                    C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(16457);
                    return true;
                }
                C7578w c7578w = new C7578w();
                c7578w.field_username = c37727hk.cCg.username;
                if (c37727hk.cCg.cCh <= c37727hk.cCg.cCj) {
                    j = c37727hk.cCg.cCj;
                } else {
                    j = c37727hk.cCg.cCh;
                }
                c7578w.field_lastPushSeq = j;
                c7578w.field_lastLocalSeq = c37727hk.cCg.cCj;
                c7578w.field_lastPushCreateTime = c37727hk.cCg.cCi;
                c7578w.field_lastLocalCreateTime = c37727hk.cCg.cCk;
                j = bOm.mo15221a(c7578w, true);
                C23797b c23797b = C23797b.yZH;
                C23797b.dGX();
                C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", Long.valueOf(j), c37727hk.cCg.username, Long.valueOf(c37727hk.cCg.cCh), Long.valueOf(c37727hk.cCg.cCi), Long.valueOf(c37727hk.cCg.cCj), Long.valueOf(c37727hk.cCg.cCk));
                C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(16457);
                return true;
            } catch (Throwable th) {
                C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(16457);
            }
        }
    }

    /* renamed from: com.tencent.mm.aq.c$a */
    static class C32268a implements Runnable {
        C26225qu fCu;

        /* synthetic */ C32268a(C26225qu c26225qu, byte b) {
            this(c26225qu);
        }

        private C32268a(C26225qu c26225qu) {
            this.fCu = c26225qu;
        }

        public final void run() {
            AppMethodBeat.m2504i(16459);
            long currentTimeMillis = System.currentTimeMillis();
            if (C1720g.m3531RK()) {
                byte[] bArr = this.fCu.cMZ.data;
                if (bArr != null) {
                    String formatTime;
                    long j;
                    String str;
                    Object obj;
                    C7617ak c7617ak;
                    int i;
                    C23377cn c23377cn = new C23377cn();
                    try {
                        c23377cn.parseFrom(bArr);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", e, "", new Object[0]);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String a = C1946aa.m4148a(c23377cn.vEJ);
                    int i2 = c23377cn.vEI;
                    long j2 = 1000 * ((long) c23377cn.pcX);
                    C6973b bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
                    if (bOm.mo15216QL(a)) {
                        boolean I = bOm.mo15205I(a, (long) i2);
                        boolean K = bOm.mo15207K(a, j2);
                        C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run#update] chatRoomId:%s updatePushSeqRet[%s]:%s updatePushCreateTimeRet[%s]:%s", a, Integer.valueOf(i2), Boolean.valueOf(I), Long.valueOf(j2), Boolean.valueOf(K));
                    } else {
                        C6575cy c6575cy;
                        C6575cy Rc = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15249Rc(a);
                        if (Rc == null || Rc.field_msgId != 0) {
                            c6575cy = Rc;
                        } else {
                            C4990ab.m7420w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] has not any ReceivedMsg!");
                            c6575cy = null;
                        }
                        if (c6575cy != null) {
                            formatTime = C14835h.formatTime("yyyy-MM-dd HH:mm:ss", c6575cy.field_createTime / 1000);
                            C4990ab.m7421w("MicroMsg.GetChatroomMsgReceiver", "[lastFaultMsgInfo] lastFaultMsgInfo:%s timeFormat:%s", C5046bo.anv(c6575cy.field_content), formatTime);
                        }
                        C7578w c7578w = new C7578w();
                        c7578w.field_username = a;
                        c7578w.field_lastPushSeq = (long) i2;
                        if (c6575cy != null) {
                            j = c6575cy.field_msgSeq;
                        } else {
                            j = (long) (i2 - 1);
                        }
                        c7578w.field_lastLocalSeq = j;
                        c7578w.field_lastPushCreateTime = j2;
                        if (c6575cy != null) {
                            j = c6575cy.field_createTime;
                        } else {
                            j = j2 - 1;
                        }
                        c7578w.field_lastLocalCreateTime = j;
                        j = bOm.mo15220a(c7578w);
                        str = "MicroMsg.GetChatroomMsgReceiver";
                        String str2 = "[UpdateMsgSeqStorageTask$run#insert] ret:%s,chatRoomId:%s updatePushSeq:%s updatePushCreateTime:%s field_lastLocalSeq:%s field_lastLocalCreateTime:%s";
                        Object[] objArr = new Object[6];
                        objArr[0] = Long.valueOf(j);
                        objArr[1] = a;
                        objArr[2] = Integer.valueOf(i2);
                        objArr[3] = Long.valueOf(j2);
                        if (c6575cy != null) {
                            j = c6575cy.field_msgSeq;
                        } else {
                            j = (long) (i2 - 1);
                        }
                        objArr[4] = Long.valueOf(j);
                        if (c6575cy != null) {
                            j = c6575cy.field_createTime;
                        } else {
                            j = j2 - 1;
                        }
                        objArr[5] = Long.valueOf(j);
                        C4990ab.m7417i(str, str2, objArr);
                        C23797b c23797b = C23797b.yZH;
                        C23797b.dGX();
                    }
                    C4990ab.m7410d("MicroMsg.GetChatroomMsgReceiver", "[updateChatroomMsgSeq] cost:" + (System.currentTimeMillis() - currentTimeMillis2));
                    j2 = System.currentTimeMillis();
                    str = C1946aa.m4148a(c23377cn.vEJ);
                    int i3 = c23377cn.vEI;
                    j = c23377cn.ptF;
                    int i4 = c23377cn.pcX;
                    int i5 = c23377cn.vEM;
                    int i6 = c23377cn.nao;
                    int i7 = c23377cn.vEK;
                    String a2 = C1946aa.m4148a(c23377cn.vEL);
                    C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", str, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i7), C5046bo.anv(a2));
                    C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(str);
                    if (aoZ == null) {
                        C6563at c7617ak2 = new C7617ak(str);
                        c7617ak2.mo14742eD(((long) i4) * 1000);
                        c7617ak2.mo14744eF((long) i3);
                        c7617ak2.mo14748hM(1);
                        c7617ak2.mo14755hT(1);
                        C6320b.agG();
                        C6320b.m10398rX(str);
                        j = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7907QP(str);
                        C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", Long.valueOf(j), Integer.valueOf(i3));
                        if (j <= 0) {
                            j = (long) i3;
                        }
                        c7617ak2.mo14745eG(j);
                        obj = 1;
                        c7617ak = c7617ak2;
                    } else {
                        i2 = (int) aoZ.field_lastSeq;
                        if (i3 > i2) {
                            aoZ.mo14744eF((long) i3);
                            i = aoZ.field_UnDeliverCount;
                            aoZ.mo14755hT(i7);
                            aoZ.mo14742eD(((long) i4) * 1000);
                            if (i7 > aoZ.field_unReadCount) {
                                aoZ.mo14748hM(i7);
                            } else {
                                aoZ.mo14748hM((i7 - i) + aoZ.field_unReadCount);
                            }
                            C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv  msgSeq[%d], firstSeq[%d], lastseq[%d]", Integer.valueOf(i3), Long.valueOf(aoZ.field_firstUnDeliverSeq), Integer.valueOf(i2));
                            if (aoZ.field_firstUnDeliverSeq > 0) {
                                C7620bi R = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15246R(str, (long) i2);
                                if (R.field_msgId > 0) {
                                    aoZ.mo14745eG(R.field_msgSeq);
                                }
                                obj = null;
                                c7617ak = aoZ;
                            } else {
                                currentTimeMillis2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7907QP(str);
                                if (currentTimeMillis2 > 0) {
                                    aoZ.mo14745eG(currentTimeMillis2);
                                    obj = null;
                                    c7617ak = aoZ;
                                } else {
                                    currentTimeMillis2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15267Ru(str);
                                    C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv lastMsgSeq[%s]", Long.valueOf(currentTimeMillis2));
                                    if (currentTimeMillis2 > 0) {
                                        aoZ.mo14745eG(currentTimeMillis2);
                                    }
                                    obj = null;
                                    c7617ak = aoZ;
                                }
                            }
                        } else {
                            if (i3 == i2 && i7 == 0 && aoZ.field_unReadCount > 0) {
                                aoZ.mo14748hM(0);
                            }
                            obj = null;
                            c7617ak = aoZ;
                        }
                    }
                    if (i5 > 0) {
                        c7617ak.mo14753hR(c7617ak.field_atCount + i5);
                    }
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo14781hO(0);
                    c7620bi.mo14794ju(str);
                    c7620bi.setType(i6);
                    c7620bi.setContent(a2);
                    if (i6 == 49) {
                        C8910b me = C8910b.m16064me(C7237j.m12094hE(str, a2));
                        c7620bi.setType(C4733l.m7100d(me));
                        c7620bi.setContent(c7620bi.drC() ? me.content : a2);
                    } else if (i6 == 10002) {
                        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension();
                        if (c7620bi.getType() == 10002 && !C5046bo.isNullOrNil(a2)) {
                            if (C5046bo.isNullOrNil(a2)) {
                                C4990ab.m7412e("MicroMsg.SysCmdMsgExtension", "null msg content");
                            } else {
                                Map map;
                                String str3;
                                if (a2.startsWith("~SEMI_XML~")) {
                                    Map amR = C5035be.amR(a2);
                                    if (amR == null) {
                                        C4990ab.m7413e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                                    } else {
                                        map = amR;
                                        str3 = "brand_service";
                                    }
                                } else {
                                    i = a2.indexOf("<sysmsg");
                                    if (i == -1) {
                                        C4990ab.m7412e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                                    } else {
                                        Map z = C5049br.m7595z(a2.substring(i), "sysmsg");
                                        if (z == null) {
                                            C4990ab.m7413e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                                        } else {
                                            map = z;
                                            str3 = (String) z.get(".sysmsg.$type");
                                        }
                                    }
                                }
                                if (str3 != null && str3.equals("revokemsg")) {
                                    C4990ab.m7416i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                    map.get(".sysmsg.revokemsg.session");
                                    formatTime = (String) map.get(".sysmsg.revokemsg.newmsgid");
                                    C4990ab.m7417i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", formatTime, (String) map.get(".sysmsg.revokemsg.replacemsg"));
                                    c7620bi.setContent(a2);
                                    c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                                }
                            }
                        }
                    }
                    c7617ak.mo14750hO(0);
                    c7617ak.setContent(c7620bi.field_content);
                    c7617ak.mo14757jg(Integer.toString(c7620bi.getType()));
                    C5133b Cb = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15765Cb();
                    if (Cb != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Cb.mo10533a(c7620bi, pString, pString2, pInt, false);
                        c7617ak.mo14758jh(pString.value);
                        c7617ak.mo14759ji(pString2.value);
                        c7617ak.mo14751hP(pInt.value);
                        if (c7620bi.getType() == 49) {
                            formatTime = (String) C5049br.m7595z(c7617ak.field_content, "msg").get(".msg.appmsg.title");
                            String nullAsNil = C5046bo.nullAsNil(c7617ak.field_digest);
                            if (C5046bo.isNullOrNil(formatTime)) {
                                formatTime = "";
                            } else {
                                formatTime = " " + C5046bo.nullAsNil(formatTime);
                            }
                            c7617ak.mo14758jh(nullAsNil.concat(formatTime));
                        }
                    } else {
                        c7617ak.mo14758jh(c7617ak.field_content);
                    }
                    if (obj != null) {
                        j = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(c7617ak);
                        C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", str, Long.valueOf(j), Long.valueOf(c7617ak.field_firstUnDeliverSeq), Long.valueOf(c7617ak.field_lastSeq), Integer.valueOf(c7617ak.field_UnDeliverCount));
                    } else {
                        c7617ak.mo14752hQ(c7617ak.field_attrflag & -1048577);
                        j = (long) ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15768a(c7617ak, str, true);
                        C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr updateConv update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", str, Long.valueOf(j), Long.valueOf(c7617ak.field_firstUnDeliverSeq), Long.valueOf(c7617ak.field_lastSeq), Integer.valueOf(c7617ak.field_UnDeliverCount));
                    }
                    C4990ab.m7410d("MicroMsg.GetChatroomMsgReceiver", "[updateConv] cost:" + (System.currentTimeMillis() - j2));
                } else {
                    C4990ab.m7412e("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] data is null");
                }
            } else {
                C4990ab.m7420w("MicroMsg.GetChatroomMsgReceiver", "[UpdateMsgSeqStorageTask$run] accHasReady no!");
            }
            C4990ab.m7410d("MicroMsg.GetChatroomMsgReceiver", "[HandlePushTask$run] cost:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(16459);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(16466);
        C1720g.m3539RS().mo10302aa(new C32268a((C26225qu) c4883b, (byte) 0));
        AppMethodBeat.m2505o(16466);
        return true;
    }

    public C32267c() {
        AppMethodBeat.m2504i(16460);
        C4879a.xxA.mo10052c(this.fCr);
        C6320b.agG().fCk = this;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10119a(this, C1720g.m3539RS().oAl.getLooper());
        C18668n.ahX();
        C18668n.ahV().mo10114a(this, C9638aw.m17180RS().oAl.getLooper());
        this.xxI = C26225qu.class.getName().hashCode();
        AppMethodBeat.m2505o(16460);
    }

    /* renamed from: a */
    public final void mo14567a(String str, boolean z, LinkedList<C7620bi> linkedList, C6594c c6594c, boolean z2) {
        AppMethodBeat.m2504i(16461);
        long j;
        C6973b bOm;
        if (linkedList.size() <= 0 || z2) {
            C4990ab.m7420w("MicroMsg.GetChatroomMsgReceiver", "[onFetched] fetchList.size() == 0! removeBlock! isBlockAll:".concat(String.valueOf(z2)));
            long j2 = c6594c.eoC;
            j = c6594c.eoD;
            C4990ab.m7416i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j + " chatroomId:" + str);
            bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
            C7578w QN = bOm.mo15218QN(str);
            if (QN.field_seqBlockInfo != null) {
                LinkedList linkedList2 = new LinkedList();
                Iterator it = QN.field_seqBlockInfo.eoG.iterator();
                while (it.hasNext()) {
                    C6594c c6594c2 = (C6594c) it.next();
                    if (c6594c2.eoC == j2 && c6594c2.eoD == j) {
                        linkedList2.add(c6594c2);
                        break;
                    }
                }
                QN.field_seqBlockInfo.eoG.removeAll(linkedList2);
                C4990ab.m7416i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j + " chatroomId:" + str + " ret:" + bOm.mo15223b(QN) + " remove list:" + linkedList2.size());
                if (linkedList2.size() > 0) {
                    C23797b c23797b = C23797b.yZH;
                    C23797b.dGZ();
                }
            }
            QN.field_lastLocalSeq = QN.field_lastPushSeq;
            QN.field_lastLocalCreateTime = QN.field_lastPushCreateTime;
            C4990ab.m7416i("MicroMsg.GetChatroomMsgReceiver", "[removeBlock] firstMsgSeq:" + j2 + " lastMsgSeq:" + j + " chatroomId:" + str + " ret:" + bOm.mo15223b(QN) + " lastPushSeq:" + QN.field_lastPushSeq + " field_lastPushCreateTime:" + QN.field_lastPushCreateTime);
            AppMethodBeat.m2505o(16461);
            return;
        }
        C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] insert msg count[%s] isFetchUp:%s", Integer.valueOf(linkedList.size()), Boolean.valueOf(z));
        bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
        List a = C32267c.m52687a(str, (LinkedList) linkedList);
        C6595d QK = bOm.mo15215QK(str);
        QK.eoG.clear();
        QK.eoG.addAll(a);
        boolean a2 = bOm.mo15222a(str, QK);
        j = ((C7620bi) linkedList.getLast()).field_msgSeq;
        long j3 = ((C7620bi) linkedList.getLast()).field_createTime;
        long QH = bOm.mo15212QH(str);
        long QJ = bOm.mo15214QJ(str);
        C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "[onFetched] blockList size:%s ret:%s GetSeq:[last %s:old %s] GetLocalCreateTime:[last %s:old %s]", Integer.valueOf(QK.eoG.size()), Boolean.valueOf(a2), Long.valueOf(j), Long.valueOf(QH), Long.valueOf(j3), Long.valueOf(QJ));
        if (QH < j) {
            bOm.mo15208L(str, j);
            bOm.mo15206J(str, j3);
        } else {
            C4990ab.m7421w("MicroMsg.GetChatroomMsgReceiver", "oldGetSeq>=lastGetSeq [%s:%s]", Long.valueOf(QH), Long.valueOf(j));
        }
        C32267c.m52688e(new HashMap(this.fCs), str);
        AppMethodBeat.m2505o(16461);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(16462);
        if (c7298n == ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR() && (obj instanceof String) && 5 == i) {
            C6973b bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
            String str = (String) obj;
            if (bOm.mo15216QL(str)) {
                C7578w QN = bOm.mo15218QN(str);
                if (QN.field_seqBlockInfo != null) {
                    QN.field_seqBlockInfo.eoG.clear();
                }
                QN.field_lastLocalSeq = QN.field_lastPushSeq;
                QN.field_lastLocalCreateTime = QN.field_lastPushCreateTime;
                C4990ab.m7416i("MicroMsg.GetChatroomMsgReceiver", "[onNotifyChange] username:" + str + " ret:" + bOm.mo15223b(QN) + " chatroomMsgSeq:" + QN.toString());
            }
        }
        AppMethodBeat.m2505o(16462);
    }

    /* renamed from: a */
    private static List<C6594c> m52687a(String str, LinkedList<C7620bi> linkedList) {
        AppMethodBeat.m2504i(16463);
        C6973b bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
        C6595d QK = bOm.mo15215QK(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nchatroomId:").append(str);
        long j = ((C7620bi) linkedList.getFirst()).field_msgSeq;
        long j2 = ((C7620bi) linkedList.getLast()).field_msgSeq;
        long j3 = ((C7620bi) linkedList.getFirst()).field_createTime;
        long j4 = ((C7620bi) linkedList.getLast()).field_createTime;
        stringBuilder.append("\ngetFirst:").append(j);
        stringBuilder.append(" getLast:").append(j2);
        stringBuilder.append(" getFirstCreateTime:").append(j3);
        stringBuilder.append(" getLastCreateTime:").append(j4);
        stringBuilder.append("\nblock ");
        C6594c c6594c = new C6594c();
        c6594c.eoC = bOm.mo15212QH(str) + 1;
        c6594c.eoE = bOm.mo15214QJ(str) + 1;
        c6594c.eoD = bOm.mo15211QG(str);
        c6594c.eoF = bOm.mo15213QI(str);
        if (c6594c.eoD - c6594c.eoC >= 0) {
            QK.eoG.add(c6594c);
        } else {
            C4990ab.m7421w("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] lastSeq[%s]<firstSeq[%s]", Long.valueOf(c6594c.eoD), Long.valueOf(c6594c.eoC));
        }
        LinkedList<C6594c> linkedList2 = new LinkedList();
        Iterator it = QK.eoG.iterator();
        while (it.hasNext()) {
            C6594c c6594c2;
            c6594c = (C6594c) it.next();
            Object obj = null;
            long j5 = c6594c.eoC;
            long j6 = c6594c.eoD;
            long j7 = c6594c.eoE;
            long j8 = c6594c.eoF;
            stringBuilder.append("[").append(j5).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(j6).append("][").append(j7).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(j8).append("] | ");
            if (j5 <= j && j <= j6) {
                c6594c2 = new C6594c();
                c6594c2.eoC = c6594c.eoC;
                c6594c2.eoD = j - 1;
                c6594c2.eoE = j7;
                c6594c2.eoF = j3 - 1;
                if (c6594c2.eoD - c6594c2.eoC >= 0) {
                    linkedList2.add(c6594c2);
                    obj = 1;
                }
            }
            if (j5 <= j2 && j2 <= j6) {
                c6594c2 = new C6594c();
                c6594c2.eoC = 1 + j2;
                c6594c2.eoD = j6;
                c6594c2.eoE = 1 + j4;
                c6594c2.eoF = j8;
                if (c6594c2.eoD - c6594c2.eoC >= 0) {
                    linkedList2.add(c6594c2);
                    obj = 1;
                }
            }
            if (obj == null && (j > j6 || j2 < j5)) {
                linkedList2.add(c6594c);
                C4990ab.m7416i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] add raw block!");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (C6594c c6594c3 : linkedList2) {
            stringBuilder2.append("[").append(c6594c3.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c6594c3.eoD).append("][").append(c6594c3.eoE).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c6594c3.eoF).append("] | ");
        }
        C4990ab.m7416i("MicroMsg.GetChatroomMsgReceiver", "[createBlocks] " + stringBuilder.toString() + "\nnew blockList:" + stringBuilder2.toString());
        AppMethodBeat.m2505o(16463);
        return linkedList2;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(16464);
        if (!C42252ah.isNullOrNil(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                C35996bb c35996bb = new C35996bb();
                c35996bb.field_originSvrId = longValue;
                C18668n.ahX();
                if (C18668n.ahV().mo10102b(c35996bb, new String[0])) {
                    this.fCs.put(Long.valueOf(longValue), c35996bb);
                    C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange put info systemRowid[%d], svrId[%d]", Long.valueOf(c35996bb.xDa), Long.valueOf(longValue));
                    AppMethodBeat.m2505o(16464);
                    return;
                }
                this.fCs.remove(Long.valueOf(longValue));
                C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg onNotifyChange remove info svrId[%d]", Long.valueOf(longValue));
                AppMethodBeat.m2505o(16464);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.GetChatroomMsgReceiver", e, "summerbadcr dealSysCmdMsg onNotifyChange:", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(16464);
    }

    /* renamed from: e */
    private static void m52688e(Map<Long, C35996bb> map, String str) {
        AppMethodBeat.m2504i(16465);
        if (map.size() == 0 || C42252ah.isNullOrNil(str)) {
            AppMethodBeat.m2505o(16465);
            return;
        }
        Iterator it = map.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                C35996bb c35996bb = (C35996bb) it.next();
                if (c35996bb != null && str.equals(c35996bb.field_fromUserName)) {
                    C9638aw.m17190ZK();
                    if (C18628c.m29080XO().mo15241Q(str, c35996bb.field_originSvrId).field_msgId != 0) {
                        C4990ab.m7417i("MicroMsg.GetChatroomMsgReceiver", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", Long.valueOf(C18628c.m29080XO().mo15241Q(str, c35996bb.field_originSvrId).field_msgId), Long.valueOf(C18628c.m29080XO().mo15241Q(str, c35996bb.field_originSvrId).field_msgSvrId));
                        C7254cm c7254cm = new C7254cm();
                        c7254cm.ptF = c35996bb.field_newMsgId;
                        c7254cm.vEB = C1946aa.m4154vy(c35996bb.field_fromUserName);
                        c7254cm.vEC = C1946aa.m4154vy(c35996bb.field_toUserName);
                        c7254cm.pcX = (int) c35996bb.field_createTime;
                        c7254cm.vED = C1946aa.m4154vy(c35996bb.field_content);
                        c7254cm.vEG = c35996bb.field_msgSource;
                        c7254cm.vEI = c35996bb.field_msgSeq;
                        int i = c35996bb.field_flag;
                        c7254cm.nao = 10002;
                        C9638aw.getSysCmdMsgExtension().mo4453b(new C1197a(c7254cm, (i & 2) != 0, (i & 1) != 0, (i & 4) != 0));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(16465);
    }
}
