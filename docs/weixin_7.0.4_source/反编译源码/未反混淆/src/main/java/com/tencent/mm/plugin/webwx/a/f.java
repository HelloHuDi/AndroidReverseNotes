package com.tencent.mm.plugin.webwx.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.i;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.d.a;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements e, a {
    public final b b(e.a aVar) {
        AppMethodBeat.i(26506);
        cm cmVar = aVar.eAB;
        if (cmVar != null && cmVar.nao == 51) {
            ab.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", Integer.valueOf(cmVar.nao), Integer.valueOf(51));
            String a = aa.a(cmVar.vEC);
            if (!bo.isNullOrNil(a)) {
                String trim = aa.a(cmVar.vED).trim();
                Map z = br.z(trim, "msg");
                if (z != null) {
                    int i = bo.getInt((String) z.get(".msg.op.$id"), 0);
                    ab.d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", Integer.valueOf(i));
                    int size;
                    String trim2;
                    sk skVar;
                    if (i == 1 || i == 2 || i == 5) {
                        ab.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = ".concat(String.valueOf(a)));
                        aw.ZK();
                        c.XO().QY(a);
                        com.tencent.mm.plugin.webwx.a.gkE.cancelNotification(a);
                        if (t.nd(a)) {
                            aw.ZK();
                            c.Ry().set(143618, Integer.valueOf(0));
                            d.akP().dtc();
                        } else {
                            ab.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
                            aw.ZK();
                            c.XR().apb(a);
                            if (t.kH(a)) {
                                aw.ZK();
                                ak aoZ = c.XR().aoZ(a);
                                if (aoZ != null && aoZ.field_unReadCount > 0 && aoZ.field_UnDeliverCount > 0) {
                                    ab.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", a, Integer.valueOf(aoZ.field_UnDeliverCount), Integer.valueOf(aoZ.field_unReadCount));
                                    com.tencent.mm.plugin.webwx.a.gkF.dl(a);
                                    aoZ.hM(0);
                                    aw.ZK();
                                    c.XR().a(aoZ, a);
                                }
                            }
                        }
                    } else if (i == 3) {
                        ab.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus op[%s]", Integer.valueOf(i));
                        long currentTimeMillis = System.currentTimeMillis();
                        aw.ZK();
                        List dsO = c.XR().dsO();
                        StringBuilder stringBuilder = new StringBuilder();
                        int i2 = 0;
                        while (i2 < dsO.size()) {
                            stringBuilder.append(i2 > 0 ? "," : "");
                            stringBuilder.append((String) dsO.get(i2));
                            i2++;
                        }
                        ab.i("MicroMsg.StatusNotifyMsgExtension", "summerstatus userNames[%s] take[%d]ms", Integer.valueOf(dsO.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        List<String> P = u.P(t.fkP, 0);
                        a = "MicroMsg.StatusNotifyMsgExtension";
                        trim = "summerstatus unreadUsernames[%s] take[%d]ms";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(P == null ? -1 : P.size());
                        objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                        ab.i(a, trim, objArr);
                        size = P == null ? 0 : P.size();
                        LinkedList linkedList = null;
                        if (size > 0) {
                            LinkedList linkedList2 = new LinkedList();
                            be XR = ((j) g.K(j.class)).XR();
                            for (String trim22 : P) {
                                cdl cdl = new cdl();
                                cdl.jBB = trim22;
                                cdl.xdh = (int) XR.aoZ(trim22).field_conversationTime;
                                linkedList2.add(cdl);
                            }
                            linkedList = linkedList2;
                        }
                        aw.Rg().a(new y(stringBuilder.toString(), 4, size, linkedList), 0);
                    } else if (i == 6) {
                        ab.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                    } else if (i == 7) {
                        ab.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        r3 = new Object[2];
                        aw.ZK();
                        r3[0] = Integer.valueOf(c.XJ());
                        r3[1] = Integer.valueOf(l.aji());
                        ab.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", r3);
                        a = bo.nullAsNil((String) z.get(".msg.op.name")).trim();
                        trim22 = bo.nullAsNil((String) z.get(".msg.op.arg")).trim();
                        if ("WeixinStatus".equals(a)) {
                            aw.ZK();
                            if (c.XJ() == l.aji() && l.fOX != null && l.fOX.trim().length() > 0) {
                                Intent intent = new Intent(ah.getContext(), WebWXLogoutUI.class);
                                intent.setFlags(603979776);
                                intent.addFlags(268435456);
                                intent.putExtra("intent.key.online_version", l.aji());
                                ah.getContext().startActivity(intent);
                            }
                        } else if ("MomentsUnreadMsgStatus".equals(a)) {
                            skVar = new sk();
                            skVar.cOH.czE = 7;
                            skVar.cOH.cOI = a;
                            skVar.cOH.cOJ = (long) bo.getInt(trim22, 0);
                            ab.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", Integer.valueOf(skVar.cOH.czE), skVar.cOH.cOI, Long.valueOf(skVar.cOH.cOJ));
                            com.tencent.mm.sdk.b.a.xxA.m(skVar);
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            z.afe();
                            i.h(i, a, trim22);
                        }
                    } else if (i == 8) {
                        ab.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        a = bo.nullAsNil((String) z.get(".msg.op.name")).trim();
                        trim22 = bo.nullAsNil((String) z.get(".msg.op.arg")).trim();
                        if ("EnterpriseChatStatus".equals(a)) {
                            z.afe();
                            i.h(i, a, trim22);
                        } else {
                            sk skVar2 = new sk();
                            skVar2.cOH.czE = 8;
                            com.tencent.mm.sdk.b.a.xxA.m(skVar2);
                        }
                    } else if (i == 9) {
                        ab.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        a = bo.nullAsNil((String) z.get(".msg.op.name")).trim();
                        trim22 = bo.nullAsNil((String) z.get(".msg.op.arg")).trim();
                        if ("MomentsTimelineStatus".equals(a)) {
                            String[] split = trim22.split(",");
                            if (split.length == 2) {
                                skVar = new sk();
                                skVar.cOH.czE = 9;
                                skVar.cOH.cOI = a;
                                skVar.cOH.cOJ = (long) bo.getInt(split[1], 0);
                                skVar.cOH.cOK = split[0];
                                com.tencent.mm.sdk.b.a.xxA.m(skVar);
                            }
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            z.afe();
                            i.h(i, a, trim22);
                        }
                    } else if (i == 11) {
                        a = bo.nullAsNil((String) z.get(".msg.op.name")).trim();
                        trim22 = bo.nullAsNil((String) z.get(".msg.op.arg")).trim();
                        if (!"DownloadFile".equals(a)) {
                            ab.i("MicroMsg.StatusNotifyMsgExtension", "[MultiTerminalSyncMgr]not DownloadFile, ignore");
                        }
                        z = br.z(trim22, "downloadList");
                        if (z != null) {
                            int i3 = 0;
                            while (true) {
                                a = ".downloadList.downloadItem" + (i3 == 0 ? "" : Integer.valueOf(i3));
                                size = i3 + 1;
                                trim22 = a + ".username";
                                a = a + ".msgsvrid";
                                trim22 = (String) z.get(trim22);
                                if (!bo.isNullOrNil(trim22)) {
                                    long j = bo.getLong((String) z.get(a), -1);
                                    if (j == -1) {
                                        break;
                                    }
                                    aw.ZK();
                                    bi Q = c.XO().Q(trim22, j);
                                    if (Q.field_msgSvrId == 0) {
                                        ab.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(j));
                                        i3 = size;
                                    } else {
                                        g.ddf().ddh().lU(Q.field_msgId);
                                        i3 = size;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } else if (i == 12) {
                        ab.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock ".concat(String.valueOf(trim)), Integer.valueOf(i));
                        try {
                            if (z.get(".msg.op.arg") != null) {
                                trim22 = new JSONObject((String) z.get(".msg.op.arg")).get("deviceName").toString();
                                if (l.ajh()) {
                                    Intent intent2 = new Intent(ah.getContext(), WebWXPopupUnlockUI.class);
                                    intent2.setFlags(872415232);
                                    intent2.putExtra("deviceName", trim22);
                                    ah.getContext().startActivity(intent2);
                                }
                            } else {
                                ab.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
                            }
                        } catch (JSONException e) {
                            ab.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + e.getMessage());
                        }
                    } else {
                        ab.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", Integer.valueOf(i));
                    }
                }
            }
        }
        AppMethodBeat.o(26506);
        return null;
    }

    public final void a(e.c cVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
        AppMethodBeat.i(26507);
        ab.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", Long.valueOf(j), Long.valueOf(j2));
        AppMethodBeat.o(26507);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }
}
