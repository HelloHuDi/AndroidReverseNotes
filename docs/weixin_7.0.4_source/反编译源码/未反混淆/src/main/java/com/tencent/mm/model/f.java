package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.m.c;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bi;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xwalk.core.XWalkEnvironment;

public final class f implements n {
    private long fky = -1;
    public a fkz;

    public interface a {
        void dn(String str);
    }

    private static void Ys() {
        AppMethodBeat.i(16266);
        List kC = g.Nu().kC("^JDEntranceConfigName$");
        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "jd config name %s", kC);
        if (kC.isEmpty()) {
            h.pYm.k(931, 6, 1);
        } else if (bo.isNullOrNil((String) kC.get(0))) {
            h.pYm.k(931, 9, 1);
        }
        kC = g.Nu().kC("^JDEntranceConfigIconUrl$");
        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "jd icon url %s", kC);
        if (kC.isEmpty()) {
            h.pYm.k(931, 7, 1);
        } else if (bo.isNullOrNil((String) kC.get(0))) {
            h.pYm.k(931, 10, 1);
        }
        kC = g.Nu().kC("^JDEntranceConfigJumpUrl$");
        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "jd jump url %s", kC);
        if (kC.isEmpty()) {
            h.pYm.k(931, 8, 1);
            AppMethodBeat.o(16266);
            return;
        }
        if (bo.isNullOrNil((String) kC.get(0))) {
            h.pYm.k(931, 11, 1);
        }
        AppMethodBeat.o(16266);
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x0678  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0693  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x06f8  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0834  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x09cf  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0b6a  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0d7b  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x108d  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x1187  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x11b8  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x127a  */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x1352  */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x13ca  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x1441  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x1461  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x148c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b a(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
        e bg;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        ak aoZ;
        long j;
        bi biVar;
        int i2;
        b bVar;
        AppMethodBeat.i(16267);
        cm cmVar = aVar.eAB;
        String a = aa.a(cmVar.vED);
        b bVar2 = null;
        if (str != null) {
            if (str.equals("addcontact")) {
                cmVar.vED = aa.vy((String) map.get(".sysmsg.addcontact.content"));
                cmVar.nao = 1;
                bg = d.bg(Integer.valueOf(1));
                bVar2 = bg == null ? null : bg.b(aVar);
            }
        }
        if (str != null) {
            if (str.equals("dynacfg")) {
                g.Nu().a(a, map, false);
                g.Nv();
                if (c.Ng() == 2) {
                    h.pYm.X(10879, "");
                }
                ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(bo.getInt(g.Nu().getValue("MuteRoomDisable"), 0)));
                if (com.tencent.mm.sdk.platformtools.aa.doo()) {
                    Ys();
                }
            }
        }
        if (str != null) {
            if (str.equals("dynacfg_split")) {
                g.Nu().a(a, map, true);
                if (com.tencent.mm.sdk.platformtools.aa.doo()) {
                    Ys();
                }
            }
        }
        if (str != null) {
            if (str.equals("banner")) {
                str2 = (String) map.get(".sysmsg.mainframebanner.$type");
                str3 = (String) map.get(".sysmsg.mainframebanner.showtype");
                str4 = (String) map.get(".sysmsg.mainframebanner.data");
                if (str2 != null && str2.length() > 0) {
                    try {
                        be.ZV().a(new bd(Integer.valueOf(str2).intValue(), Integer.valueOf(str3).intValue(), str4));
                    } catch (Exception e) {
                        ab.e("MicroMsg.BigBallSysCmdMsgConsumer", e.toString());
                    }
                }
                str3 = (String) map.get(".sysmsg.friendrecommand.touser");
                if (!(((String) map.get(".sysmsg.friendrecommand.fromuser")) == null || str3 == null)) {
                    try {
                        aw.ZK().Yk().a(str3, true, null);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.BigBallSysCmdMsgConsumer", e2.toString());
                    }
                }
                str2 = (String) map.get(".sysmsg.banner.securitybanner.chatname");
                str3 = (String) map.get(".sysmsg.banner.securitybanner.wording");
                str4 = (String) map.get(".sysmsg.banner.securitybanner.linkname");
                str5 = (String) map.get(".sysmsg.banner.securitybanner.linksrc");
                str6 = (String) map.get(".sysmsg.banner.securitybanner.showtype");
                if (!(bo.isNullOrNil(str2) || bo.isNullOrNil(str6))) {
                    try {
                        boolean z;
                        if (str6.equals("1")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aw.ZK().Yl().a(str2, z, new String[]{str3, str4, str5});
                    } catch (Exception e22) {
                        ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + e22.toString());
                    }
                }
                aw.ZK().Ym().n(map);
            }
        }
        if (!bo.isNullOrNil(str)) {
            if (str.equals("midinfo")) {
                str2 = (String) map.get(".sysmsg.midinfo.json_buffer");
                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", (String) map.get(".sysmsg.midinfo.time_interval"), str2, a);
                i = bo.getInt(str3, 0);
                if (((long) i) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC && ((long) i) < 864000) {
                    aw.ZK();
                    c.Ry().set(331777, Long.valueOf(bo.anT() + ((long) i)));
                }
                if (!bo.isNullOrNil(str2)) {
                    com.tencent.mm.plugin.report.b.d.VY(str2);
                }
            }
        }
        if (str != null) {
            if (str.equals("revokemsg")) {
                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                str2 = (String) map.get(".sysmsg.revokemsg.session");
                str4 = (String) map.get(".sysmsg.revokemsg.replacemsg");
                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", (String) map.get(".sysmsg.revokemsg.newmsgid"), str4);
                long j2 = 0;
                try {
                    j2 = bo.getLong((String) map.get(".sysmsg.revokemsg.newmsgid"), 0);
                    aw.ZK();
                    bi Q = c.XO().Q(str2, j2);
                    final bi ar = bi.ar(Q);
                    if ((Q.dqI & 4) != 4) {
                        Q.setContent(str4);
                        Q.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                        bf.a(Q, aVar);
                        aw.ZK();
                        c.XO().a(Q.field_msgId, Q);
                    }
                    aw.ZK();
                    aoZ = c.XR().aoZ(Q.field_talker);
                    if (aoZ != null && aoZ.field_unReadCount > 0) {
                        aw.ZK();
                        if (aoZ.field_unReadCount >= c.XO().Y(Q)) {
                            aoZ.hM(aoZ.field_unReadCount - 1);
                            aw.ZK();
                            c.XR().a(aoZ, aoZ.field_username);
                        }
                    }
                    if (aVar != null && aVar.fsU) {
                        bb bbVar = new bb();
                        bbVar.field_originSvrId = j2;
                        if (Q.field_msgId == 0) {
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", Long.valueOf(j2));
                            bbVar.field_content = a;
                            bbVar.field_createTime = (long) cmVar.pcX;
                            bbVar.field_flag = bf.d(aVar);
                            bbVar.field_fromUserName = aa.a(cmVar.vEB);
                            bbVar.field_toUserName = aa.a(cmVar.vEC);
                            bbVar.field_newMsgId = cmVar.ptF;
                            com.tencent.mm.modelmulti.n.ahX();
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", Boolean.valueOf(com.tencent.mm.modelmulti.n.ahV().b(bbVar)), Long.valueOf(bbVar.xDa));
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", Long.valueOf(j2));
                        com.tencent.mm.modelmulti.n.ahX();
                        com.tencent.mm.modelmulti.n.ahV().a(bbVar, true, new String[0]);
                        aw.ZK();
                        c.XO().jj(j2);
                        if (!(aoZ == null || aVar.eAB == null || aoZ.field_lastSeq != ((long) aVar.eAB.vEI))) {
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", Long.valueOf(aoZ.field_lastSeq), Long.valueOf(aoZ.field_firstUnDeliverSeq));
                            aw.ZK();
                            bi Rc = c.XO().Rc(aoZ.field_username);
                            if (Rc != null) {
                                aoZ.eF(Rc.field_msgSeq);
                                aw.ZK();
                                int a2 = c.XR().a(aoZ, aoZ.field_username);
                                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", Long.valueOf(Rc.field_msgSvrId), Long.valueOf(Rc.field_msgSeq), Long.valueOf(aoZ.field_lastSeq), Long.valueOf(aoZ.field_firstUnDeliverSeq), Integer.valueOf(a2));
                            }
                        }
                    }
                    if (Q.field_msgId == 0 && (aVar == null || !aVar.fsU)) {
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", Long.valueOf(j2));
                        aw.ZK();
                        c.XO().jj(j2);
                    }
                    pe peVar = new pe();
                    peVar.cLt.cvx = Q.field_msgId;
                    peVar.cLt.cLu = str4;
                    peVar.cLt.cKd = Q;
                    peVar.cLt.cLv = ar;
                    peVar.cLt.cLw = j2;
                    com.tencent.mm.sdk.b.a.xxA.m(peVar);
                    if (ar != null) {
                        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(16265);
                                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", Long.valueOf(ar.field_msgId), Integer.valueOf(ar.getType()));
                                switch (ar.getType()) {
                                    case 3:
                                    case 34:
                                    case 43:
                                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                                    case 62:
                                    case 268435505:
                                        bf.m(ar);
                                        break;
                                }
                                AppMethodBeat.o(16265);
                            }
                        });
                    }
                } catch (Exception e222) {
                    j = j2;
                    ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e222, "[oneliang][revokeMsg] msgId:%d,error:%s", Long.valueOf(j), e222.toString());
                }
                AppMethodBeat.o(16267);
                return null;
            }
        }
        if (str != null) {
            if (str.equals("clouddelmsg")) {
                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                str2 = (String) map.get(".sysmsg.clouddelmsg.delcommand");
                str3 = (String) map.get(".sysmsg.clouddelmsg.msgid");
                str4 = (String) map.get(".sysmsg.clouddelmsg.fromuser");
                int indexOf = a.indexOf("<msg>");
                int indexOf2 = a.indexOf("</msg>");
                if (indexOf == -1 || indexOf2 == -1) {
                    str5 = "";
                } else {
                    str5 = be.aS(br.z(a.substring(indexOf, indexOf2 + 6), "msg"));
                }
                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", str2, str3, str4, str5);
                try {
                    aw.ZK();
                    LinkedList fd = c.XO().fd(str4, str3);
                    if (fd == null || fd.size() <= 0) {
                        ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                        AppMethodBeat.o(16267);
                        return null;
                    }
                    Iterator it = fd.iterator();
                    while (it.hasNext()) {
                        biVar = (bi) it.next();
                        if (biVar == null) {
                            ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                        } else if (biVar.field_msgSvrId < 0) {
                            ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId));
                        } else {
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId));
                            i2 = bo.getInt(str2, 0);
                            if (i2 == 1) {
                                aw.ZK();
                                c.XO().aa(biVar.field_talker, biVar.field_msgSvrId);
                            } else if (i2 == 2 && biVar.drC()) {
                                biVar.setContent(str5);
                                bf.a(biVar, aVar);
                                aw.ZK();
                                c.XO().b(biVar.field_msgSvrId, biVar);
                                aw.ZK();
                                ak aoZ2 = c.XR().aoZ(biVar.field_talker);
                                if (aoZ2 != null && aoZ2.field_unReadCount > 0) {
                                    aw.ZK();
                                    if (aoZ2.field_unReadCount >= c.XO().Y(biVar)) {
                                        aoZ2.hM(aoZ2.field_unReadCount - 1);
                                        aw.ZK();
                                        c.XR().a(aoZ2, aoZ2.field_username);
                                    }
                                }
                            }
                            pe peVar2 = new pe();
                            peVar2.cLt.cvx = biVar.field_msgId;
                            peVar2.cLt.cLu = str5;
                            peVar2.cLt.cKd = biVar;
                            com.tencent.mm.sdk.b.a.xxA.m(peVar2);
                        }
                    }
                    AppMethodBeat.o(16267);
                    return null;
                } catch (Exception e2222) {
                    ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e2222, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", str3, e2222.toString());
                }
            }
        }
        if (str != null) {
            if (str.equals("updatepackage")) {
                String str7;
                String str8;
                int i3;
                int i4;
                Object[] objArr;
                int i5;
                bg = d.bg(Integer.valueOf(-1879048175));
                if (bg == null) {
                    bVar = null;
                } else {
                    bVar = bg.b(aVar);
                }
                if (str != null) {
                    if (str.equals("deletepackage")) {
                        bg = d.bg(Integer.valueOf(-1879048174));
                        if (bg == null) {
                            bVar = null;
                        } else {
                            bVar = bg.b(aVar);
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("delchatroommember")) {
                        str3 = aa.a(cmVar.vEB);
                        aw.ZK();
                        biVar = c.XO().Q(str3, cmVar.ptF);
                        Object obj = null;
                        if (biVar.field_msgId > 0) {
                            obj = 1;
                        }
                        biVar.eI(cmVar.ptF);
                        if (!(aVar != null && aVar.fsU && aVar.fsW)) {
                            biVar.eJ(bf.q(str3, (long) cmVar.pcX));
                        }
                        biVar.setType(10002);
                        biVar.setContent(a);
                        biVar.hO(0);
                        biVar.ju(str3);
                        biVar.ix(cmVar.vEG);
                        bf.a(biVar, aVar);
                        if (obj == null) {
                            bf.l(biVar);
                        } else {
                            aw.ZK();
                            c.XO().b(cmVar.ptF, biVar);
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("WakenPush") && this.fky != cmVar.ptF) {
                        this.fky = cmVar.ptF;
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                        cg cgVar = new cg(map);
                        str7 = (String) cgVar.fjf.get(".sysmsg.WakenPush.PushContent");
                        str3 = (String) cgVar.fjf.get(".sysmsg.WakenPush.Jump");
                        str2 = (String) cgVar.fjf.get(".sysmsg.WakenPush.ExpiredTime");
                        str8 = (String) cgVar.fjf.get(".sysmsg.WakenPush.Username");
                        ab.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", str7, str3, str2);
                        str2 = g.Nu().getValue("WakenPushDeepLinkBitSet");
                        ab.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", str2);
                        if (bo.isNullOrNil(str2)) {
                            j = 0;
                        } else {
                            j = bo.getLong(str2, 0);
                        }
                        Bitmap a3 = com.tencent.mm.ah.b.a(str8, false, -1);
                        an notification = aw.getNotification();
                        if (bo.isNullOrNil(str3)) {
                            ab.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                            str4 = "com.tencent.mm.ui.LauncherUI";
                        } else if ((4 & j) == 4 && str3.startsWith("weixin://dl/moments")) {
                            str4 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                        } else if ((j & 262144) == 262144 && str3.startsWith("weixin://dl/recommendation")) {
                            str4 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                        } else {
                            ab.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", str3);
                            str4 = "com.tencent.mm.ui.LauncherUI";
                        }
                        Intent intent = new Intent();
                        intent.setClassName(ah.getContext(), str4);
                        intent.setFlags(536870912);
                        intent.putExtra("LauncherUI.Show.Update.DialogMsg", (String) cgVar.fjf.get(".sysmsg.WakenPush.PushContent"));
                        if (!str3.equals("weixin://dl/update_newest_version")) {
                            intent.putExtra("LauncherUI.Show.Update.Url", (String) cgVar.fjf.get(".sysmsg.WakenPush.Jump"));
                        }
                        h.pYm.a(405, 32, 1, true);
                        Notification a4 = notification.a(PendingIntent.getActivity(ah.getContext(), UUID.randomUUID().hashCode(), intent, 134217728), ah.getContext().getString(R.string.ru), str7, str7, a3, str8);
                        a4.flags |= 16;
                        aw.getNotification().a(a4, false);
                        h.pYm.a(405, 31, 1, true);
                        bVar = null;
                    }
                }
                if (str != null) {
                    if (str.equals("DisasterNotice")) {
                        str2 = (String) map.get(".sysmsg.NoticeId");
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", str2, (String) map.get(".sysmsg.Content"));
                        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.h.Mu());
                        str5 = sharedPreferences.getString("disaster_noticeid_list_key", "");
                        if (!str5.contains(str2)) {
                            String[] split = str5.split(";");
                            if (split == null || split.length <= 10) {
                                str4 = str5;
                            } else {
                                str4 = "";
                                for (String str62 : split) {
                                    String[] split2 = str62.split(",");
                                    try {
                                        if (bo.fp(bo.getLong(split2[0], 0)) < 1296000) {
                                            str4 = str4 + split2[0] + "," + split2[1] + ";";
                                        }
                                    } catch (Exception e3) {
                                        ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", e3);
                                    }
                                }
                            }
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", str5, str4 + bo.anT() + "," + str2 + ";");
                            sharedPreferences.edit().putString("disaster_noticeid_list_key", str4).commit();
                        }
                        new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(16263);
                                if (f.this.fkz != null) {
                                    f.this.fkz.dn(str2);
                                }
                                AppMethodBeat.o(16263);
                            }
                        });
                        cmVar.vED = aa.vy(str3);
                        cmVar.nao = 1;
                        bg = d.bg(Integer.valueOf(1));
                        if (bg == null) {
                            bVar = null;
                        } else {
                            bVar = bg.b(aVar);
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("EmotionKv")) {
                        str2 = (String) map.get(".sysmsg.EmotionKv.K");
                        a = (String) map.get(".sysmsg.EmotionKv.I");
                        if (str2 == null) {
                            str3 = "";
                        } else {
                            str3 = str2;
                        }
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", Integer.valueOf(str3.length()), str3, a);
                        byte[] bytes = z.dmv().vyO.getBytes();
                        byte[] bytes2 = z.dmv().vyP.getBytes();
                        byte[] bArr = null;
                        try {
                            bArr = aw.Rg().ftA.adg().adc();
                        } catch (Exception e22222) {
                            ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", bo.l(e22222));
                        }
                        if (bo.cb(bArr)) {
                            ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        byte[] dmi = com.tencent.mm.protocal.f.dmi();
                        if (bo.cb(dmi)) {
                            ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        PByteArray pByteArray = new PByteArray();
                        if (bo.isNullOrNil(str3) || bo.cb(bytes2) || bo.cb(bytes) || bo.cb(bArr) || bo.cb(dmi)) {
                            String str9 = "MicroMsg.BigBallSysCmdMsgConsumer";
                            str7 = "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d";
                            Object[] objArr2 = new Object[5];
                            if (str3 == null) {
                                i4 = -1;
                            } else {
                                i4 = str3.length();
                            }
                            objArr2[0] = Integer.valueOf(i4);
                            objArr2[1] = Integer.valueOf(bytes2 == null ? -1 : bytes2.length);
                            objArr2[2] = Integer.valueOf(bytes == null ? -1 : bytes.length);
                            objArr2[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            objArr2[4] = Integer.valueOf(dmi == null ? -1 : dmi.length);
                            ab.w(str9, str7, objArr2);
                        } else {
                            aw.ZK();
                            MMProtocalJni.genClientCheckKVRes(c.QF(), str3, bytes, bytes2, bArr, dmi, pByteArray);
                        }
                        byte[] bArr2 = pByteArray.value;
                        axf axf = new axf();
                        if (pByteArray.value != null) {
                            axf.pXM = new String(pByteArray.value);
                        } else {
                            axf.pXM = "";
                        }
                        str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str5 = "summercck emotionkv res len:%d val len:%d, content[%s]";
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                        objArr[1] = Integer.valueOf(axf.pXM.length());
                        objArr[2] = com.tencent.mm.a.g.x(axf.pXM.getBytes());
                        ab.i(str4, str5, objArr);
                        axf.wBn = a;
                        aw.ZK();
                        c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(59, axf));
                        AppMethodBeat.o(16267);
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("globalalert")) {
                        str2 = (String) map.get(".sysmsg.uuid");
                        i3 = bo.getInt((String) map.get(".sysmsg.id"), -1);
                        int i6 = bo.getInt((String) map.get(".sysmsg.important"), -1);
                        if (bo.isNullOrNil(str2) || i3 < 0 || i6 < 0) {
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", str2, Integer.valueOf(i3), Integer.valueOf(i6));
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        str3 = (String) map.get(".sysmsg.title");
                        str4 = (String) map.get(".sysmsg.msg");
                        if (bo.isNullOrNil(str3) && bo.isNullOrNil(str4)) {
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", str3, str4);
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        str5 = (String) map.get(".sysmsg.btnlist.btn.$title");
                        int i7 = bo.getInt((String) map.get(".sysmsg.btnlist.btn.$id"), -1);
                        i5 = bo.getInt((String) map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                        str62 = (String) map.get(".sysmsg.btnlist.btn");
                        if (bo.isNullOrNil(str5) || i7 < 0 || i5 < 0) {
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        String str10 = (String) map.get(".sysmsg.btnlist.btn1.$title");
                        int i8 = bo.getInt((String) map.get(".sysmsg.btnlist.btn1.$id"), -1);
                        int i9 = bo.getInt((String) map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                        String str11 = (String) map.get(".sysmsg.btnlist.btn1");
                        boolean z2 = true;
                        if (bo.isNullOrNil(str10) || i8 < 0 || i9 < 0) {
                            z2 = false;
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                        }
                        com.tencent.mm.sdk.b.b ijVar = new ij();
                        com.tencent.mm.protocal.b.a.b bVar3 = new com.tencent.mm.protocal.b.a.b();
                        ijVar.cDv.cDw = bVar3;
                        bVar3.id = i3;
                        bVar3.title = str3;
                        bVar3.bzH = str4;
                        bVar3.vzI = new LinkedList();
                        com.tencent.mm.protocal.b.a.a aVar2 = new com.tencent.mm.protocal.b.a.a();
                        aVar2.id = i7;
                        aVar2.actionType = i5;
                        aVar2.vzG = str5;
                        aVar2.vzH = str62;
                        bVar3.vzI.add(aVar2);
                        if (z2) {
                            com.tencent.mm.protocal.b.a.a aVar3 = new com.tencent.mm.protocal.b.a.a();
                            aVar3.id = i8;
                            aVar3.actionType = i9;
                            aVar3.vzG = str10;
                            aVar3.vzH = str11;
                            bVar3.vzI.add(aVar3);
                        }
                        boolean m = com.tencent.mm.sdk.b.a.xxA.m(ijVar);
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", str2, Integer.valueOf(i3), Integer.valueOf(i6), str3, str4, Boolean.valueOf(z2), Boolean.valueOf(m));
                        AppMethodBeat.o(16267);
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("yybsigcheck")) {
                        h.pYm.a(322, 14, 1, false);
                        long currentTimeMillis = System.currentTimeMillis();
                        str2 = (String) map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", str2, (String) map.get(".sysmsg.yybsigcheck.yybsig.wording"), (String) map.get(".sysmsg.yybsigcheck.yybsig.url"));
                        h hVar = h.pYm;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(4014);
                        objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                        hVar.e(11098, objArr3);
                        if (bo.isNullOrNil(str2)) {
                            ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                            h.pYm.a(322, 15, 1, false);
                            h hVar2 = h.pYm;
                            Object[] objArr4 = new Object[2];
                            objArr4[0] = Integer.valueOf(4015);
                            objArr4[1] = String.format("%s|%s", new Object[]{str7, str8});
                            hVar2.e(11098, objArr4);
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        String[] split3 = str2.split(";");
                        str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str5 = "summertoken newxml infoStrs len is %d";
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(split3 == null ? -1 : split3.length);
                        ab.d(str4, str5, objArr);
                        if (split3 == null || split3.length == 0) {
                            h.pYm.a(322, 16, 1, false);
                            h.pYm.e(11098, Integer.valueOf(4016), str2);
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        ArrayList arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            i5 = i;
                            if (i5 >= split3.length) {
                                break;
                            }
                            String str12 = split3[i5];
                            if (bo.isNullOrNil(str12)) {
                                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", Integer.valueOf(i5));
                            } else {
                                String[] split4 = str12.split(",");
                                str5 = "MicroMsg.BigBallSysCmdMsgConsumer";
                                str62 = "summertoken newxml fields len is %d";
                                Object[] objArr5 = new Object[1];
                                objArr5[0] = Integer.valueOf(split4 == null ? -1 : split4.length);
                                ab.d(str5, str62, objArr5);
                                if (split4 == null || split4.length != 3) {
                                    ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", Integer.valueOf(i5));
                                } else {
                                    try {
                                        arrayList.add(new ai.c(split4[0], Integer.valueOf(split4[1]).intValue(), split4[2]));
                                    } catch (Exception e4) {
                                        ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", Integer.valueOf(i5), e4.getMessage());
                                        h.pYm.a(322, 17, 1, false);
                                        h.pYm.e(11098, Integer.valueOf(4017), str12);
                                    }
                                }
                            }
                            i = i5 + 1;
                        }
                        if (arrayList.size() == 0) {
                            ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                            h.pYm.a(322, 18, 1, false);
                            hVar = h.pYm;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4018);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            hVar.e(11098, objArr3);
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", Integer.valueOf(arrayList.size()), Boolean.valueOf(bo.getInt(g.Nu().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0), Boolean.valueOf(ai.a(ah.getContext(), arrayList, bo.getInt(g.Nu().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (ai.a(ah.getContext(), arrayList, bo.getInt(g.Nu().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)) {
                            aw.ZI().setInt(46, 0);
                            h.pYm.a(322, 19, 1, true);
                            hVar = h.pYm;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4019);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            hVar.e(11098, objArr3);
                        } else {
                            aw.ZI().setInt(46, 4);
                            ja jaVar = new ja();
                            jaVar.cEg.cEh = str7;
                            jaVar.cEg.url = str8;
                            com.tencent.mm.sdk.b.a.xxA.m(jaVar);
                            h.pYm.a(322, 20, 1, true);
                            hVar = h.pYm;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4020);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            hVar.e(11098, objArr3);
                        }
                        AppMethodBeat.o(16267);
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("qy_status_notify")) {
                        str2 = (String) map.get(".sysmsg.chat_id");
                        map.get(".sysmsg.last_create_time");
                        str3 = (String) map.get(".sysmsg.brand_username");
                        j = com.tencent.mm.aj.a.e.ry(str2);
                        if (j == -1) {
                            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", str2);
                            AppMethodBeat.o(16267);
                            return null;
                        }
                        i4 = com.tencent.mm.aj.z.aeU().fv(j).field_newUnReadCount;
                        com.tencent.mm.aj.z.aeU().fx(j);
                        com.tencent.mm.aj.a.c aK = com.tencent.mm.aj.z.aeT().aK(j);
                        aw.ZK();
                        aoZ = c.XR().aoZ(str3);
                        if (aoZ == null) {
                            ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", str3);
                            AppMethodBeat.o(16267);
                            return null;
                        } else if (aK.lc(1)) {
                            if (aoZ.field_unReadMuteCount <= i4) {
                                aoZ.hS(0);
                                aw.ZK();
                                c.XR().a(aoZ, str3);
                                aw.getNotification().cancelNotification(str3);
                            } else {
                                aoZ.hS(aoZ.field_unReadMuteCount - i4);
                                aw.ZK();
                                c.XR().a(aoZ, str3);
                            }
                            AppMethodBeat.o(16267);
                            return null;
                        } else {
                            if (aoZ.field_unReadCount <= i4) {
                                aw.ZK();
                                c.XR().apb(str3);
                                aw.getNotification().cancelNotification(str3);
                            } else {
                                aoZ.hR(0);
                                aoZ.hU(0);
                                aoZ.hM(aoZ.field_unReadCount - i4);
                                aw.ZK();
                                c.XR().a(aoZ, str3);
                            }
                            AppMethodBeat.o(16267);
                            return null;
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("qy_chat_update")) {
                        com.tencent.mm.aj.a.e.p((String) map.get(".sysmsg.brand_username"), (String) map.get(".sysmsg.chat_id"), (String) map.get(".sysmsg.ver"));
                    }
                }
                if (str != null) {
                    if (str.equals("bindmobiletip")) {
                        i = bo.getInt((String) map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                        str4 = bo.nullAsNil((String) map.get(".sysmsg.bindmobiletip.deviceid"));
                        Object nullAsNil = bo.nullAsNil((String) map.get(".sysmsg.bindmobiletip.wording"));
                        str2 = new String(Base64.decode(str4.getBytes(), 0));
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", Integer.valueOf(i), str2, new String(com.tencent.mm.bt.b.bI(q.LM().getBytes()).Lv(16).wR), nullAsNil);
                        if (bo.isNullOrNil(str2) || str2.equals(r4)) {
                            aw.ZK();
                            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.TRUE);
                            aw.ZK();
                            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(i == 1));
                            aw.ZK();
                            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, nullAsNil);
                        }
                        AppMethodBeat.o(16267);
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckConsistency")) {
                        bfl bfl = new bfl();
                        bfl.fMd = (String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                        bfl.wJn = bo.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                        bfl.wJo = bo.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                        bfl.vPb = bo.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                        bfl.wJp = f(bfl.fMd, (long) bfl.wJn, (long) bfl.wJo);
                        bfl.FileSize = (int) mm(bfl.fMd);
                        bfl.wJq = com.tencent.mm.plugin.normsg.a.b.oTO.bVI() ? 1 : 0;
                        bfl.vZF = y.Me();
                        bfl.wJr = h(bfl.fMd, Integer.valueOf(bfl.wJn), Integer.valueOf(bfl.wJo), Integer.valueOf(bfl.vPb), bfl.wJp, Integer.valueOf(bfl.FileSize), Integer.valueOf(bfl.wJq), Integer.valueOf(bfl.vZF));
                        aw.ZK();
                        c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(61, bfl));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckHook")) {
                        bfn bfn = new bfn();
                        bfn.vPb = bo.getInt((String) map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                        bfn.wJt = com.tencent.mm.plugin.normsg.a.b.oTO.jE(false);
                        bfn.wJq = com.tencent.mm.plugin.normsg.a.b.oTO.bVI() ? 1 : 0;
                        bfn.vZF = y.Me();
                        bfn.wJr = h(Integer.valueOf(bfn.vPb), bfn.wJt, Integer.valueOf(bfn.wJq), Integer.valueOf(bfn.vZF));
                        aw.ZK();
                        c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(62, bfn));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckGetAppList")) {
                        bfm bfm = new bfm();
                        bfm.vPb = bo.getInt((String) map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                        bfm.wJs = com.tencent.mm.plugin.normsg.a.b.oTO.bVQ();
                        bfm.wJq = com.tencent.mm.plugin.normsg.a.b.oTO.bVI() ? 1 : 0;
                        bfm.vZF = y.Me();
                        bfm.wJr = h(Integer.valueOf(bfm.vPb), bfm.wJs, Integer.valueOf(bfm.wJq), Integer.valueOf(bfm.vZF));
                        aw.ZK();
                        c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(63, bfm));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckGetExtInfo")) {
                        final Map<String, String> map2 = map;
                        com.tencent.mm.sdk.g.d.g(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(16264);
                                int i = bo.getInt((String) map2.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                                if (bo.getInt((String) map2.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0) {
                                    com.tencent.mm.plugin.secinforeport.a.d.qjp.ff(i, 0);
                                    AppMethodBeat.o(16264);
                                    return;
                                }
                                com.tencent.mm.plugin.secinforeport.a.d.qjp.ff(i, 15);
                                AppMethodBeat.o(16264);
                            }
                        }, "syscmd_rpt_cc");
                    }
                }
                if (!bo.isNullOrNil(str)) {
                    if (str.equals("functionmsg")) {
                        ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                        ((com.tencent.mm.api.q) com.tencent.mm.kernel.g.M(com.tencent.mm.api.q.class)).getReceiver().a(cmVar, map);
                    }
                }
                if (!bo.isNullOrNil(str)) {
                    if (str.equals("paymsg")) {
                        ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", Integer.valueOf(bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Long.valueOf(cmVar.ptF), (String) map.get(".sysmsg.paymsg.fromusername"), (String) map.get(".sysmsg.paymsg.tousername"), (String) map.get(".sysmsg.paymsg.paymsgid"), (String) map.get(".sysmsg.paymsg.appmsgcontent"));
                        try {
                            str2 = URLDecoder.decode((String) map.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                            if (!bo.isNullOrNil(str2)) {
                                ni niVar = new ni();
                                niVar.cJE.type = i2;
                                niVar.cJE.content = str2;
                                niVar.cJE.cEV = str3;
                                niVar.cJE.toUser = str4;
                                niVar.cJE.cJF = str5;
                                com.tencent.mm.sdk.b.a.xxA.m(niVar);
                            }
                        } catch (Exception e222222) {
                            ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e222222, "", new Object[0]);
                            ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", e222222.getMessage());
                        }
                    }
                }
                AppMethodBeat.o(16267);
                return bVar;
            }
        }
        bVar = bVar2;
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (str != null) {
        }
        if (bo.isNullOrNil(str)) {
        }
        if (bo.isNullOrNil(str)) {
        }
        AppMethodBeat.o(16267);
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d A:{SYNTHETIC, Splitter:B:46:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a2 A:{SYNTHETIC, Splitter:B:49:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c A:{SYNTHETIC, Splitter:B:37:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091 A:{SYNTHETIC, Splitter:B:40:0x0091} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d A:{SYNTHETIC, Splitter:B:46:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a2 A:{SYNTHETIC, Splitter:B:49:0x00a2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String f(String str, long j, long j2) {
        InputStream inputStream;
        Throwable e;
        String str2;
        AppMethodBeat.i(16268);
        ZipFile zipFile;
        try {
            if (str.startsWith("@")) {
                zipFile = new ZipFile(ah.getContext().getApplicationInfo().sourceDir);
                try {
                    inputStream = zipFile.getInputStream(zipFile.getEntry(str.substring(1)));
                } catch (Exception e2) {
                    e = e2;
                    inputStream = null;
                } catch (Throwable th) {
                    e = th;
                    inputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.o(16268);
                    throw e;
                }
            }
            inputStream = com.tencent.mm.vfs.e.openRead(str);
            zipFile = null;
            while (j > 0) {
                try {
                    j -= inputStream.skip(j);
                } catch (Exception e5) {
                    e = e5;
                    try {
                        ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                        str2 = "";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e7) {
                            }
                        }
                        AppMethodBeat.o(16268);
                        return str2;
                    } catch (Throwable th2) {
                        e = th2;
                        if (inputStream != null) {
                        }
                        if (zipFile != null) {
                        }
                        AppMethodBeat.o(16268);
                        throw e;
                    }
                }
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[2048];
            while (j2 > 0) {
                int read = inputStream.read(bArr, 0, (int) Math.min(2048, j2));
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
                j2 -= (long) read;
            }
            str2 = bo.cd(instance.digest());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e9) {
                }
            }
            AppMethodBeat.o(16268);
        } catch (Exception e10) {
            e = e10;
            zipFile = null;
            inputStream = null;
            ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            str2 = "";
            if (inputStream != null) {
            }
            if (zipFile != null) {
            }
            AppMethodBeat.o(16268);
            return str2;
        } catch (Throwable th3) {
            e = th3;
            zipFile = null;
            inputStream = null;
            if (inputStream != null) {
            }
            if (zipFile != null) {
            }
            AppMethodBeat.o(16268);
            throw e;
        }
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A:{SYNTHETIC, Splitter:B:28:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long mm(String str) {
        Throwable e;
        Throwable th;
        long j = -1;
        AppMethodBeat.i(16269);
        if (str.startsWith("@")) {
            ZipFile zipFile;
            try {
                zipFile = new ZipFile(ah.getContext().getApplicationInfo().sourceDir);
                try {
                    ZipEntry entry = zipFile.getEntry(str.substring(1));
                    if (entry == null) {
                        try {
                            zipFile.close();
                        } catch (IOException e2) {
                        }
                        AppMethodBeat.o(16269);
                        return j;
                    }
                    j = entry.getSize();
                    try {
                        zipFile.close();
                    } catch (IOException e3) {
                    }
                    AppMethodBeat.o(16269);
                    return j;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (IOException e5) {
                e = e5;
                zipFile = null;
                try {
                    ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                        }
                    }
                    AppMethodBeat.o(16269);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                    }
                    AppMethodBeat.o(16269);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile = null;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e7) {
                    }
                }
                AppMethodBeat.o(16269);
                throw th;
            }
        }
        j = com.tencent.mm.vfs.e.asZ(str);
        AppMethodBeat.o(16269);
        return j;
    }

    private static String h(Object... objArr) {
        AppMethodBeat.i(16270);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String str;
        try {
            for (Object obj : objArr) {
                int i;
                if (obj instanceof String) {
                    byteArrayOutputStream.write(((String) obj).getBytes());
                } else if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    for (i = 0; i < 4; i++) {
                        byteArrayOutputStream.write(intValue & 255);
                        intValue >>= 8;
                    }
                } else if (obj instanceof Long) {
                    long longValue = ((Long) obj).longValue();
                    for (i = 0; i < 8; i++) {
                        byteArrayOutputStream.write((int) (255 & longValue));
                        longValue >>= 8;
                    }
                } else if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    byteArrayOutputStream.write(i);
                } else {
                    ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", obj);
                    str = "";
                    AppMethodBeat.o(16270);
                    return str;
                }
            }
            str = bo.cd(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
            AppMethodBeat.o(16270);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            str = "";
            AppMethodBeat.o(16270);
            return str;
        }
    }
}
