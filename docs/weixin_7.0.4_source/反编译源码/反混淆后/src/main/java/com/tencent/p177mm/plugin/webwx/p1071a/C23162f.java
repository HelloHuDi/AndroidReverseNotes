package com.tencent.p177mm.plugin.webwx.p1071a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.modelsimple.C6685l;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C8926i;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p230g.p231a.C9470sk;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.webwx.C4660a;
import com.tencent.p177mm.plugin.webwx.p582ui.WebWXLogoutUI;
import com.tencent.p177mm.plugin.webwx.p582ui.WebWXPopupUnlockUI;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.cdl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webwx.a.f */
public final class C23162f implements C1201e, C9017a {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(26506);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm != null && c7254cm.nao == 51) {
            C4990ab.m7411d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", Integer.valueOf(c7254cm.nao), Integer.valueOf(51));
            String a = C1946aa.m4148a(c7254cm.vEC);
            if (!C5046bo.isNullOrNil(a)) {
                String trim = C1946aa.m4148a(c7254cm.vED).trim();
                Map z = C5049br.m7595z(trim, "msg");
                if (z != null) {
                    int i = C5046bo.getInt((String) z.get(".msg.op.$id"), 0);
                    C4990ab.m7411d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", Integer.valueOf(i));
                    int size;
                    String trim2;
                    C9470sk c9470sk;
                    if (i == 1 || i == 2 || i == 5) {
                        C4990ab.m7416i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(a)));
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15244QY(a);
                        C4660a.gkE.cancelNotification(a);
                        if (C1855t.m3935nd(a)) {
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(143618, Integer.valueOf(0));
                            C41789d.akP().dtc();
                        } else {
                            C4990ab.m7416i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().apb(a);
                            if (C1855t.m3896kH(a)) {
                                C9638aw.m17190ZK();
                                C7617ak aoZ = C18628c.m29083XR().aoZ(a);
                                if (aoZ != null && aoZ.field_unReadCount > 0 && aoZ.field_UnDeliverCount > 0) {
                                    C4990ab.m7417i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", a, Integer.valueOf(aoZ.field_UnDeliverCount), Integer.valueOf(aoZ.field_unReadCount));
                                    C4660a.gkF.mo38867dl(a);
                                    aoZ.mo14748hM(0);
                                    C9638aw.m17190ZK();
                                    C18628c.m29083XR().mo15767a(aoZ, a);
                                }
                            }
                        }
                    } else if (i == 3) {
                        C4990ab.m7417i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", Integer.valueOf(i));
                        long currentTimeMillis = System.currentTimeMillis();
                        C9638aw.m17190ZK();
                        List dsO = C18628c.m29083XR().dsO();
                        StringBuilder stringBuilder = new StringBuilder();
                        int i2 = 0;
                        while (i2 < dsO.size()) {
                            stringBuilder.append(i2 > 0 ? "," : "");
                            stringBuilder.append((String) dsO.get(i2));
                            i2++;
                        }
                        C4990ab.m7417i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", Integer.valueOf(dsO.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        List<String> P = C32798u.m53579P(C1855t.fkP, 0);
                        a = "MicroMsg.StatusNotifyMsgExtension";
                        trim = "summerstatus unreadUsernames[%s] take[%d]ms";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(P == null ? -1 : P.size());
                        objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                        C4990ab.m7417i(a, trim, objArr);
                        size = P == null ? 0 : P.size();
                        LinkedList linkedList = null;
                        if (size > 0) {
                            LinkedList linkedList2 = new LinkedList();
                            C7310be XR = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR();
                            for (String trim22 : P) {
                                cdl cdl = new cdl();
                                cdl.jBB = trim22;
                                cdl.xdh = (int) XR.aoZ(trim22).field_conversationTime;
                                linkedList2.add(cdl);
                            }
                            linkedList = linkedList2;
                        }
                        C9638aw.m17182Rg().mo14541a(new C37951y(stringBuilder.toString(), 4, size, linkedList), 0);
                    } else if (i == 6) {
                        C4990ab.m7419v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                    } else if (i == 7) {
                        C4990ab.m7419v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        r3 = new Object[2];
                        C9638aw.m17190ZK();
                        r3[0] = Integer.valueOf(C18628c.m29075XJ());
                        r3[1] = Integer.valueOf(C6685l.aji());
                        C4990ab.m7411d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", r3);
                        a = C5046bo.nullAsNil((String) z.get(".msg.op.name")).trim();
                        trim22 = C5046bo.nullAsNil((String) z.get(".msg.op.arg")).trim();
                        if ("WeixinStatus".equals(a)) {
                            C9638aw.m17190ZK();
                            if (C18628c.m29075XJ() == C6685l.aji() && C6685l.fOX != null && C6685l.fOX.trim().length() > 0) {
                                Intent intent = new Intent(C4996ah.getContext(), WebWXLogoutUI.class);
                                intent.setFlags(603979776);
                                intent.addFlags(268435456);
                                intent.putExtra("intent.key.online_version", C6685l.aji());
                                C4996ah.getContext().startActivity(intent);
                            }
                        } else if ("MomentsUnreadMsgStatus".equals(a)) {
                            c9470sk = new C9470sk();
                            c9470sk.cOH.czE = 7;
                            c9470sk.cOH.cOI = a;
                            c9470sk.cOH.cOJ = (long) C5046bo.getInt(trim22, 0);
                            C4990ab.m7417i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", Integer.valueOf(c9470sk.cOH.czE), c9470sk.cOH.cOI, Long.valueOf(c9470sk.cOH.cOJ));
                            C4879a.xxA.mo10055m(c9470sk);
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            C41747z.afe();
                            C8926i.m16085h(i, a, trim22);
                        }
                    } else if (i == 8) {
                        C4990ab.m7419v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        a = C5046bo.nullAsNil((String) z.get(".msg.op.name")).trim();
                        trim22 = C5046bo.nullAsNil((String) z.get(".msg.op.arg")).trim();
                        if ("EnterpriseChatStatus".equals(a)) {
                            C41747z.afe();
                            C8926i.m16085h(i, a, trim22);
                        } else {
                            C9470sk c9470sk2 = new C9470sk();
                            c9470sk2.cOH.czE = 8;
                            C4879a.xxA.mo10055m(c9470sk2);
                        }
                    } else if (i == 9) {
                        C4990ab.m7419v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        a = C5046bo.nullAsNil((String) z.get(".msg.op.name")).trim();
                        trim22 = C5046bo.nullAsNil((String) z.get(".msg.op.arg")).trim();
                        if ("MomentsTimelineStatus".equals(a)) {
                            String[] split = trim22.split(",");
                            if (split.length == 2) {
                                c9470sk = new C9470sk();
                                c9470sk.cOH.czE = 9;
                                c9470sk.cOH.cOI = a;
                                c9470sk.cOH.cOJ = (long) C5046bo.getInt(split[1], 0);
                                c9470sk.cOH.cOK = split[0];
                                C4879a.xxA.mo10055m(c9470sk);
                            }
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            C41747z.afe();
                            C8926i.m16085h(i, a, trim22);
                        }
                    } else if (i == 11) {
                        a = C5046bo.nullAsNil((String) z.get(".msg.op.name")).trim();
                        trim22 = C5046bo.nullAsNil((String) z.get(".msg.op.arg")).trim();
                        if (!"DownloadFile".equals(a)) {
                            C4990ab.m7416i("MicroMsg.StatusNotifyMsgExtension", "[MultiTerminalSyncMgr]not DownloadFile, ignore");
                        }
                        z = C5049br.m7595z(trim22, "downloadList");
                        if (z != null) {
                            int i3 = 0;
                            while (true) {
                                a = ".downloadList.downloadItem" + (i3 == 0 ? "" : Integer.valueOf(i3));
                                size = i3 + 1;
                                trim22 = a + ".username";
                                a = a + ".msgsvrid";
                                trim22 = (String) z.get(trim22);
                                if (!C5046bo.isNullOrNil(trim22)) {
                                    long j = C5046bo.getLong((String) z.get(a), -1);
                                    if (j == -1) {
                                        break;
                                    }
                                    C9638aw.m17190ZK();
                                    C7620bi Q = C18628c.m29080XO().mo15241Q(trim22, j);
                                    if (Q.field_msgSvrId == 0) {
                                        C4990ab.m7417i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(j));
                                        i3 = size;
                                    } else {
                                        C23163g.ddf().ddh().mo74667lU(Q.field_msgId);
                                        i3 = size;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } else if (i == 12) {
                        C4990ab.m7411d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(trim)), Integer.valueOf(i));
                        try {
                            if (z.get(".msg.op.arg") != null) {
                                trim22 = new JSONObject((String) z.get(".msg.op.arg")).get("deviceName").toString();
                                if (C6685l.ajh()) {
                                    Intent intent2 = new Intent(C4996ah.getContext(), WebWXPopupUnlockUI.class);
                                    intent2.setFlags(872415232);
                                    intent2.putExtra("deviceName", trim22);
                                    C4996ah.getContext().startActivity(intent2);
                                }
                            } else {
                                C4990ab.m7410d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
                            }
                        } catch (JSONException e) {
                            C4990ab.m7412e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + e.getMessage());
                        }
                    } else {
                        C4990ab.m7413e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", Integer.valueOf(i));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(26506);
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }

    /* renamed from: a */
    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
    }

    /* renamed from: a */
    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26507);
        C4990ab.m7417i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", Long.valueOf(j), Long.valueOf(j2));
        AppMethodBeat.m2505o(26507);
    }

    /* renamed from: a */
    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
    }
}
