package com.tencent.p177mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C25783q;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C18172y;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C18295ij;
import com.tencent.p177mm.p230g.p231a.C26206ni;
import com.tencent.p177mm.p230g.p231a.C32575ja;
import com.tencent.p177mm.p230g.p231a.C37781pe;
import com.tencent.p177mm.p249m.C1763c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.platformtools.C18756ai;
import com.tencent.p177mm.platformtools.C18756ai.C18757c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.p499b.C34829d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C44761d;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4851z;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.p1338b.p1339a.C23368a;
import com.tencent.p177mm.protocal.p1338b.p1339a.C46515b;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.axf;
import com.tencent.p177mm.protocal.protobuf.bfl;
import com.tencent.p177mm.protocal.protobuf.bfm;
import com.tencent.p177mm.protocal.protobuf.bfn;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C35996bb;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.model.f */
public final class C42195f implements C3472n {
    private long fky = -1;
    public C26425a fkz;

    /* renamed from: com.tencent.mm.model.f$a */
    public interface C26425a {
        /* renamed from: dn */
        void mo20416dn(String str);
    }

    /* renamed from: Ys */
    private static void m74433Ys() {
        AppMethodBeat.m2504i(16266);
        List kC = C26373g.m41964Nu().mo5309kC("^JDEntranceConfigName$");
        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "jd config name %s", kC);
        if (kC.isEmpty()) {
            C7060h.pYm.mo15419k(931, 6, 1);
        } else if (C5046bo.isNullOrNil((String) kC.get(0))) {
            C7060h.pYm.mo15419k(931, 9, 1);
        }
        kC = C26373g.m41964Nu().mo5309kC("^JDEntranceConfigIconUrl$");
        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "jd icon url %s", kC);
        if (kC.isEmpty()) {
            C7060h.pYm.mo15419k(931, 7, 1);
        } else if (C5046bo.isNullOrNil((String) kC.get(0))) {
            C7060h.pYm.mo15419k(931, 10, 1);
        }
        kC = C26373g.m41964Nu().mo5309kC("^JDEntranceConfigJumpUrl$");
        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "jd jump url %s", kC);
        if (kC.isEmpty()) {
            C7060h.pYm.mo15419k(931, 8, 1);
            AppMethodBeat.m2505o(16266);
            return;
        }
        if (C5046bo.isNullOrNil((String) kC.get(0))) {
            C7060h.pYm.mo15419k(931, 11, 1);
        }
        AppMethodBeat.m2505o(16266);
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
    /* renamed from: a */
    public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
        C1201e bg;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        C7617ak aoZ;
        long j;
        C7620bi c7620bi;
        int i2;
        C1198b c1198b;
        AppMethodBeat.m2504i(16267);
        C7254cm c7254cm = c1197a.eAB;
        String a = C1946aa.m4148a(c7254cm.vED);
        C1198b c1198b2 = null;
        if (str != null) {
            if (str.equals("addcontact")) {
                c7254cm.vED = C1946aa.m4154vy((String) map.get(".sysmsg.addcontact.content"));
                c7254cm.nao = 1;
                bg = C1200d.m2638bg(Integer.valueOf(1));
                c1198b2 = bg == null ? null : bg.mo4453b(c1197a);
            }
        }
        if (str != null) {
            if (str.equals("dynacfg")) {
                C26373g.m41964Nu().mo5306a(a, map, false);
                C26373g.m41965Nv();
                if (C1763c.m3627Ng() == 2) {
                    C7060h.pYm.mo8374X(10879, "");
                }
                C4990ab.m7410d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(C5046bo.getInt(C26373g.m41964Nu().getValue("MuteRoomDisable"), 0)));
                if (C4988aa.doo()) {
                    C42195f.m74433Ys();
                }
            }
        }
        if (str != null) {
            if (str.equals("dynacfg_split")) {
                C26373g.m41964Nu().mo5306a(a, map, true);
                if (C4988aa.doo()) {
                    C42195f.m74433Ys();
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
                        C32776be.m53537ZV().mo53321a(new C37903bd(Integer.valueOf(str2).intValue(), Integer.valueOf(str3).intValue(), str4));
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.BigBallSysCmdMsgConsumer", e.toString());
                    }
                }
                str3 = (String) map.get(".sysmsg.friendrecommand.touser");
                if (!(((String) map.get(".sysmsg.friendrecommand.fromuser")) == null || str3 == null)) {
                    try {
                        C9638aw.m17190ZK().mo33885Yk().mo60657a(str3, true, null);
                    } catch (Exception e2) {
                        C4990ab.m7412e("MicroMsg.BigBallSysCmdMsgConsumer", e2.toString());
                    }
                }
                str2 = (String) map.get(".sysmsg.banner.securitybanner.chatname");
                str3 = (String) map.get(".sysmsg.banner.securitybanner.wording");
                str4 = (String) map.get(".sysmsg.banner.securitybanner.linkname");
                str5 = (String) map.get(".sysmsg.banner.securitybanner.linksrc");
                str6 = (String) map.get(".sysmsg.banner.securitybanner.showtype");
                if (!(C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str6))) {
                    try {
                        boolean z;
                        if (str6.equals("1")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C9638aw.m17190ZK().mo33886Yl().mo60657a(str2, z, new String[]{str3, str4, str5});
                    } catch (Exception e22) {
                        C4990ab.m7412e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + e22.toString());
                    }
                }
                C9638aw.m17190ZK().mo33887Ym().mo73241n(map);
            }
        }
        if (!C5046bo.isNullOrNil(str)) {
            if (str.equals("midinfo")) {
                str2 = (String) map.get(".sysmsg.midinfo.json_buffer");
                C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", (String) map.get(".sysmsg.midinfo.time_interval"), str2, a);
                i = C5046bo.getInt(str3, 0);
                if (((long) i) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC && ((long) i) < 864000) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(331777, Long.valueOf(C5046bo.anT() + ((long) i)));
                }
                if (!C5046bo.isNullOrNil(str2)) {
                    C34829d.m57191VY(str2);
                }
            }
        }
        if (str != null) {
            if (str.equals("revokemsg")) {
                C4990ab.m7416i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                str2 = (String) map.get(".sysmsg.revokemsg.session");
                str4 = (String) map.get(".sysmsg.revokemsg.replacemsg");
                C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", (String) map.get(".sysmsg.revokemsg.newmsgid"), str4);
                long j2 = 0;
                try {
                    j2 = C5046bo.getLong((String) map.get(".sysmsg.revokemsg.newmsgid"), 0);
                    C9638aw.m17190ZK();
                    C7620bi Q = C18628c.m29080XO().mo15241Q(str2, j2);
                    final C7620bi ar = C7620bi.m13569ar(Q);
                    if ((Q.dqI & 4) != 4) {
                        Q.setContent(str4);
                        Q.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                        C1829bf.m3743a(Q, c1197a);
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15284a(Q.field_msgId, Q);
                    }
                    C9638aw.m17190ZK();
                    aoZ = C18628c.m29083XR().aoZ(Q.field_talker);
                    if (aoZ != null && aoZ.field_unReadCount > 0) {
                        C9638aw.m17190ZK();
                        if (aoZ.field_unReadCount >= C18628c.m29080XO().mo15279Y(Q)) {
                            aoZ.mo14748hM(aoZ.field_unReadCount - 1);
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().mo15767a(aoZ, aoZ.field_username);
                        }
                    }
                    if (c1197a != null && c1197a.fsU) {
                        C35996bb c35996bb = new C35996bb();
                        c35996bb.field_originSvrId = j2;
                        if (Q.field_msgId == 0) {
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", Long.valueOf(j2));
                            c35996bb.field_content = a;
                            c35996bb.field_createTime = (long) c7254cm.pcX;
                            c35996bb.field_flag = C1829bf.m3747d(c1197a);
                            c35996bb.field_fromUserName = C1946aa.m4148a(c7254cm.vEB);
                            c35996bb.field_toUserName = C1946aa.m4148a(c7254cm.vEC);
                            c35996bb.field_newMsgId = c7254cm.ptF;
                            C18668n.ahX();
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", Boolean.valueOf(C18668n.ahV().mo10101b(c35996bb)), Long.valueOf(c35996bb.xDa));
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", Long.valueOf(j2));
                        C18668n.ahX();
                        C18668n.ahV().mo10100a(c35996bb, true, new String[0]);
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15344jj(j2);
                        if (!(aoZ == null || c1197a.eAB == null || aoZ.field_lastSeq != ((long) c1197a.eAB.vEI))) {
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", Long.valueOf(aoZ.field_lastSeq), Long.valueOf(aoZ.field_firstUnDeliverSeq));
                            C9638aw.m17190ZK();
                            C7620bi Rc = C18628c.m29080XO().mo15249Rc(aoZ.field_username);
                            if (Rc != null) {
                                aoZ.mo14744eF(Rc.field_msgSeq);
                                C9638aw.m17190ZK();
                                int a2 = C18628c.m29083XR().mo15767a(aoZ, aoZ.field_username);
                                C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", Long.valueOf(Rc.field_msgSvrId), Long.valueOf(Rc.field_msgSeq), Long.valueOf(aoZ.field_lastSeq), Long.valueOf(aoZ.field_firstUnDeliverSeq), Integer.valueOf(a2));
                            }
                        }
                    }
                    if (Q.field_msgId == 0 && (c1197a == null || !c1197a.fsU)) {
                        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", Long.valueOf(j2));
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15344jj(j2);
                    }
                    C37781pe c37781pe = new C37781pe();
                    c37781pe.cLt.cvx = Q.field_msgId;
                    c37781pe.cLt.cLu = str4;
                    c37781pe.cLt.cKd = Q;
                    c37781pe.cLt.cLv = ar;
                    c37781pe.cLt.cLw = j2;
                    C4879a.xxA.mo10055m(c37781pe);
                    if (ar != null) {
                        C1720g.m3539RS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(16265);
                                C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", Long.valueOf(ar.field_msgId), Integer.valueOf(ar.getType()));
                                switch (ar.getType()) {
                                    case 3:
                                    case 34:
                                    case 43:
                                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                                    case 62:
                                    case 268435505:
                                        C1829bf.m3753m(ar);
                                        break;
                                }
                                AppMethodBeat.m2505o(16265);
                            }
                        });
                    }
                } catch (Exception e222) {
                    j = j2;
                    C4990ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e222, "[oneliang][revokeMsg] msgId:%d,error:%s", Long.valueOf(j), e222.toString());
                }
                AppMethodBeat.m2505o(16267);
                return null;
            }
        }
        if (str != null) {
            if (str.equals("clouddelmsg")) {
                C4990ab.m7416i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                str2 = (String) map.get(".sysmsg.clouddelmsg.delcommand");
                str3 = (String) map.get(".sysmsg.clouddelmsg.msgid");
                str4 = (String) map.get(".sysmsg.clouddelmsg.fromuser");
                int indexOf = a.indexOf("<msg>");
                int indexOf2 = a.indexOf("</msg>");
                if (indexOf == -1 || indexOf2 == -1) {
                    str5 = "";
                } else {
                    str5 = C5035be.m7492aS(C5049br.m7595z(a.substring(indexOf, indexOf2 + 6), "msg"));
                }
                C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", str2, str3, str4, str5);
                try {
                    C9638aw.m17190ZK();
                    LinkedList fd = C18628c.m29080XO().mo15334fd(str4, str3);
                    if (fd == null || fd.size() <= 0) {
                        C4990ab.m7412e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                        AppMethodBeat.m2505o(16267);
                        return null;
                    }
                    Iterator it = fd.iterator();
                    while (it.hasNext()) {
                        c7620bi = (C7620bi) it.next();
                        if (c7620bi == null) {
                            C4990ab.m7412e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                        } else if (c7620bi.field_msgSvrId < 0) {
                            C4990ab.m7413e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId));
                        } else {
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId));
                            i2 = C5046bo.getInt(str2, 0);
                            if (i2 == 1) {
                                C9638aw.m17190ZK();
                                C18628c.m29080XO().mo15291aa(c7620bi.field_talker, c7620bi.field_msgSvrId);
                            } else if (i2 == 2 && c7620bi.drC()) {
                                c7620bi.setContent(str5);
                                C1829bf.m3743a(c7620bi, c1197a);
                                C9638aw.m17190ZK();
                                C18628c.m29080XO().mo15302b(c7620bi.field_msgSvrId, c7620bi);
                                C9638aw.m17190ZK();
                                C7617ak aoZ2 = C18628c.m29083XR().aoZ(c7620bi.field_talker);
                                if (aoZ2 != null && aoZ2.field_unReadCount > 0) {
                                    C9638aw.m17190ZK();
                                    if (aoZ2.field_unReadCount >= C18628c.m29080XO().mo15279Y(c7620bi)) {
                                        aoZ2.mo14748hM(aoZ2.field_unReadCount - 1);
                                        C9638aw.m17190ZK();
                                        C18628c.m29083XR().mo15767a(aoZ2, aoZ2.field_username);
                                    }
                                }
                            }
                            C37781pe c37781pe2 = new C37781pe();
                            c37781pe2.cLt.cvx = c7620bi.field_msgId;
                            c37781pe2.cLt.cLu = str5;
                            c37781pe2.cLt.cKd = c7620bi;
                            C4879a.xxA.mo10055m(c37781pe2);
                        }
                    }
                    AppMethodBeat.m2505o(16267);
                    return null;
                } catch (Exception e2222) {
                    C4990ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e2222, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", str3, e2222.toString());
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
                bg = C1200d.m2638bg(Integer.valueOf(-1879048175));
                if (bg == null) {
                    c1198b = null;
                } else {
                    c1198b = bg.mo4453b(c1197a);
                }
                if (str != null) {
                    if (str.equals("deletepackage")) {
                        bg = C1200d.m2638bg(Integer.valueOf(-1879048174));
                        if (bg == null) {
                            c1198b = null;
                        } else {
                            c1198b = bg.mo4453b(c1197a);
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("delchatroommember")) {
                        str3 = C1946aa.m4148a(c7254cm.vEB);
                        C9638aw.m17190ZK();
                        c7620bi = C18628c.m29080XO().mo15241Q(str3, c7254cm.ptF);
                        Object obj = null;
                        if (c7620bi.field_msgId > 0) {
                            obj = 1;
                        }
                        c7620bi.mo14774eI(c7254cm.ptF);
                        if (!(c1197a != null && c1197a.fsU && c1197a.fsW)) {
                            c7620bi.mo14775eJ(C1829bf.m3764q(str3, (long) c7254cm.pcX));
                        }
                        c7620bi.setType(10002);
                        c7620bi.setContent(a);
                        c7620bi.mo14781hO(0);
                        c7620bi.mo14794ju(str3);
                        c7620bi.mo14791ix(c7254cm.vEG);
                        C1829bf.m3743a(c7620bi, c1197a);
                        if (obj == null) {
                            C1829bf.m3752l(c7620bi);
                        } else {
                            C9638aw.m17190ZK();
                            C18628c.m29080XO().mo15302b(c7254cm.ptF, c7620bi);
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("WakenPush") && this.fky != c7254cm.ptF) {
                        this.fky = c7254cm.ptF;
                        C4990ab.m7416i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                        C37916cg c37916cg = new C37916cg(map);
                        str7 = (String) c37916cg.fjf.get(".sysmsg.WakenPush.PushContent");
                        str3 = (String) c37916cg.fjf.get(".sysmsg.WakenPush.Jump");
                        str2 = (String) c37916cg.fjf.get(".sysmsg.WakenPush.ExpiredTime");
                        str8 = (String) c37916cg.fjf.get(".sysmsg.WakenPush.Username");
                        C4990ab.m7411d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", str7, str3, str2);
                        str2 = C26373g.m41964Nu().getValue("WakenPushDeepLinkBitSet");
                        C4990ab.m7411d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", str2);
                        if (C5046bo.isNullOrNil(str2)) {
                            j = 0;
                        } else {
                            j = C5046bo.getLong(str2, 0);
                        }
                        Bitmap a3 = C41730b.m73490a(str8, false, -1);
                        C24672an notification = C9638aw.getNotification();
                        if (C5046bo.isNullOrNil(str3)) {
                            C4990ab.m7412e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                            str4 = "com.tencent.mm.ui.LauncherUI";
                        } else if ((4 & j) == 4 && str3.startsWith("weixin://dl/moments")) {
                            str4 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                        } else if ((j & 262144) == 262144 && str3.startsWith("weixin://dl/recommendation")) {
                            str4 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                        } else {
                            C4990ab.m7413e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", str3);
                            str4 = "com.tencent.mm.ui.LauncherUI";
                        }
                        Intent intent = new Intent();
                        intent.setClassName(C4996ah.getContext(), str4);
                        intent.setFlags(536870912);
                        intent.putExtra("LauncherUI.Show.Update.DialogMsg", (String) c37916cg.fjf.get(".sysmsg.WakenPush.PushContent"));
                        if (!str3.equals("weixin://dl/update_newest_version")) {
                            intent.putExtra("LauncherUI.Show.Update.Url", (String) c37916cg.fjf.get(".sysmsg.WakenPush.Jump"));
                        }
                        C7060h.pYm.mo8378a(405, 32, 1, true);
                        Notification a4 = notification.mo41573a(PendingIntent.getActivity(C4996ah.getContext(), UUID.randomUUID().hashCode(), intent, 134217728), C4996ah.getContext().getString(C25738R.string.f9176ru), str7, str7, a3, str8);
                        a4.flags |= 16;
                        C9638aw.getNotification().mo41570a(a4, false);
                        C7060h.pYm.mo8378a(405, 31, 1, true);
                        c1198b = null;
                    }
                }
                if (str != null) {
                    if (str.equals("DisasterNotice")) {
                        str2 = (String) map.get(".sysmsg.NoticeId");
                        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", str2, (String) map.get(".sysmsg.Content"));
                        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("disaster_pref", C1448h.m3078Mu());
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
                                        if (C5046bo.m7549fp(C5046bo.getLong(split2[0], 0)) < 1296000) {
                                            str4 = str4 + split2[0] + "," + split2[1] + ";";
                                        }
                                    } catch (Exception e3) {
                                        C4990ab.m7413e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", e3);
                                    }
                                }
                            }
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", str5, str4 + C5046bo.anT() + "," + str2 + ";");
                            sharedPreferences.edit().putString("disaster_noticeid_list_key", str4).commit();
                        }
                        new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(16263);
                                if (C42195f.this.fkz != null) {
                                    C42195f.this.fkz.mo20416dn(str2);
                                }
                                AppMethodBeat.m2505o(16263);
                            }
                        });
                        c7254cm.vED = C1946aa.m4154vy(str3);
                        c7254cm.nao = 1;
                        bg = C1200d.m2638bg(Integer.valueOf(1));
                        if (bg == null) {
                            c1198b = null;
                        } else {
                            c1198b = bg.mo4453b(c1197a);
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
                        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", Integer.valueOf(str3.length()), str3, a);
                        byte[] bytes = C4851z.dmv().vyO.getBytes();
                        byte[] bytes2 = C4851z.dmv().vyP.getBytes();
                        byte[] bArr = null;
                        try {
                            bArr = C9638aw.m17182Rg().ftA.adg().adc();
                        } catch (Exception e22222) {
                            C4990ab.m7413e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", C5046bo.m7574l(e22222));
                        }
                        if (C5046bo.m7540cb(bArr)) {
                            C4990ab.m7412e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        byte[] dmi = C4815f.dmi();
                        if (C5046bo.m7540cb(dmi)) {
                            C4990ab.m7412e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        PByteArray pByteArray = new PByteArray();
                        if (C5046bo.isNullOrNil(str3) || C5046bo.m7540cb(bytes2) || C5046bo.m7540cb(bytes) || C5046bo.m7540cb(bArr) || C5046bo.m7540cb(dmi)) {
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
                            C4990ab.m7421w(str9, str7, objArr2);
                        } else {
                            C9638aw.m17190ZK();
                            MMProtocalJni.genClientCheckKVRes(C18628c.m29064QF(), str3, bytes, bytes2, bArr, dmi, pByteArray);
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
                        objArr[2] = C1178g.m2591x(axf.pXM.getBytes());
                        C4990ab.m7417i(str4, str5, objArr);
                        axf.wBn = a;
                        C9638aw.m17190ZK();
                        C18628c.m29077XL().mo7920c(new C3465a(59, axf));
                        AppMethodBeat.m2505o(16267);
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("globalalert")) {
                        str2 = (String) map.get(".sysmsg.uuid");
                        i3 = C5046bo.getInt((String) map.get(".sysmsg.id"), -1);
                        int i6 = C5046bo.getInt((String) map.get(".sysmsg.important"), -1);
                        if (C5046bo.isNullOrNil(str2) || i3 < 0 || i6 < 0) {
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", str2, Integer.valueOf(i3), Integer.valueOf(i6));
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        str3 = (String) map.get(".sysmsg.title");
                        str4 = (String) map.get(".sysmsg.msg");
                        if (C5046bo.isNullOrNil(str3) && C5046bo.isNullOrNil(str4)) {
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", str3, str4);
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        str5 = (String) map.get(".sysmsg.btnlist.btn.$title");
                        int i7 = C5046bo.getInt((String) map.get(".sysmsg.btnlist.btn.$id"), -1);
                        i5 = C5046bo.getInt((String) map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                        str62 = (String) map.get(".sysmsg.btnlist.btn");
                        if (C5046bo.isNullOrNil(str5) || i7 < 0 || i5 < 0) {
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        String str10 = (String) map.get(".sysmsg.btnlist.btn1.$title");
                        int i8 = C5046bo.getInt((String) map.get(".sysmsg.btnlist.btn1.$id"), -1);
                        int i9 = C5046bo.getInt((String) map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                        String str11 = (String) map.get(".sysmsg.btnlist.btn1");
                        boolean z2 = true;
                        if (C5046bo.isNullOrNil(str10) || i8 < 0 || i9 < 0) {
                            z2 = false;
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                        }
                        C4883b c18295ij = new C18295ij();
                        C46515b c46515b = new C46515b();
                        c18295ij.cDv.cDw = c46515b;
                        c46515b.f17912id = i3;
                        c46515b.title = str3;
                        c46515b.bzH = str4;
                        c46515b.vzI = new LinkedList();
                        C23368a c23368a = new C23368a();
                        c23368a.f4411id = i7;
                        c23368a.actionType = i5;
                        c23368a.vzG = str5;
                        c23368a.vzH = str62;
                        c46515b.vzI.add(c23368a);
                        if (z2) {
                            C23368a c23368a2 = new C23368a();
                            c23368a2.f4411id = i8;
                            c23368a2.actionType = i9;
                            c23368a2.vzG = str10;
                            c23368a2.vzH = str11;
                            c46515b.vzI.add(c23368a2);
                        }
                        boolean m = C4879a.xxA.mo10055m(c18295ij);
                        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", str2, Integer.valueOf(i3), Integer.valueOf(i6), str3, str4, Boolean.valueOf(z2), Boolean.valueOf(m));
                        AppMethodBeat.m2505o(16267);
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("yybsigcheck")) {
                        C7060h.pYm.mo8378a(322, 14, 1, false);
                        long currentTimeMillis = System.currentTimeMillis();
                        str2 = (String) map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", str2, (String) map.get(".sysmsg.yybsigcheck.yybsig.wording"), (String) map.get(".sysmsg.yybsigcheck.yybsig.url"));
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(4014);
                        objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                        c7060h.mo8381e(11098, objArr3);
                        if (C5046bo.isNullOrNil(str2)) {
                            C4990ab.m7420w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                            C7060h.pYm.mo8378a(322, 15, 1, false);
                            C7060h c7060h2 = C7060h.pYm;
                            Object[] objArr4 = new Object[2];
                            objArr4[0] = Integer.valueOf(4015);
                            objArr4[1] = String.format("%s|%s", new Object[]{str7, str8});
                            c7060h2.mo8381e(11098, objArr4);
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        String[] split3 = str2.split(";");
                        str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str5 = "summertoken newxml infoStrs len is %d";
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(split3 == null ? -1 : split3.length);
                        C4990ab.m7411d(str4, str5, objArr);
                        if (split3 == null || split3.length == 0) {
                            C7060h.pYm.mo8378a(322, 16, 1, false);
                            C7060h.pYm.mo8381e(11098, Integer.valueOf(4016), str2);
                            AppMethodBeat.m2505o(16267);
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
                            if (C5046bo.isNullOrNil(str12)) {
                                C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", Integer.valueOf(i5));
                            } else {
                                String[] split4 = str12.split(",");
                                str5 = "MicroMsg.BigBallSysCmdMsgConsumer";
                                str62 = "summertoken newxml fields len is %d";
                                Object[] objArr5 = new Object[1];
                                objArr5[0] = Integer.valueOf(split4 == null ? -1 : split4.length);
                                C4990ab.m7411d(str5, str62, objArr5);
                                if (split4 == null || split4.length != 3) {
                                    C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", Integer.valueOf(i5));
                                } else {
                                    try {
                                        arrayList.add(new C18757c(split4[0], Integer.valueOf(split4[1]).intValue(), split4[2]));
                                    } catch (Exception e4) {
                                        C4990ab.m7421w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", Integer.valueOf(i5), e4.getMessage());
                                        C7060h.pYm.mo8378a(322, 17, 1, false);
                                        C7060h.pYm.mo8381e(11098, Integer.valueOf(4017), str12);
                                    }
                                }
                            }
                            i = i5 + 1;
                        }
                        if (arrayList.size() == 0) {
                            C4990ab.m7420w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                            C7060h.pYm.mo8378a(322, 18, 1, false);
                            c7060h = C7060h.pYm;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4018);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            c7060h.mo8381e(11098, objArr3);
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", Integer.valueOf(arrayList.size()), Boolean.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0), Boolean.valueOf(C18756ai.m29307a(C4996ah.getContext(), arrayList, C5046bo.getInt(C26373g.m41964Nu().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (C18756ai.m29307a(C4996ah.getContext(), arrayList, C5046bo.getInt(C26373g.m41964Nu().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)) {
                            C9638aw.m17188ZI().setInt(46, 0);
                            C7060h.pYm.mo8378a(322, 19, 1, true);
                            c7060h = C7060h.pYm;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4019);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            c7060h.mo8381e(11098, objArr3);
                        } else {
                            C9638aw.m17188ZI().setInt(46, 4);
                            C32575ja c32575ja = new C32575ja();
                            c32575ja.cEg.cEh = str7;
                            c32575ja.cEg.url = str8;
                            C4879a.xxA.mo10055m(c32575ja);
                            C7060h.pYm.mo8378a(322, 20, 1, true);
                            c7060h = C7060h.pYm;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4020);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            c7060h.mo8381e(11098, objArr3);
                        }
                        AppMethodBeat.m2505o(16267);
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("qy_status_notify")) {
                        str2 = (String) map.get(".sysmsg.chat_id");
                        map.get(".sysmsg.last_create_time");
                        str3 = (String) map.get(".sysmsg.brand_username");
                        j = C25754e.m40911ry(str2);
                        if (j == -1) {
                            C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", str2);
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                        i4 = C41747z.aeU().mo60340fv(j).field_newUnReadCount;
                        C41747z.aeU().mo60342fx(j);
                        C45142c aK = C41747z.aeT().mo60349aK(j);
                        C9638aw.m17190ZK();
                        aoZ = C18628c.m29083XR().aoZ(str3);
                        if (aoZ == null) {
                            C4990ab.m7421w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", str3);
                            AppMethodBeat.m2505o(16267);
                            return null;
                        } else if (aK.mo73052lc(1)) {
                            if (aoZ.field_unReadMuteCount <= i4) {
                                aoZ.mo14754hS(0);
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15767a(aoZ, str3);
                                C9638aw.getNotification().cancelNotification(str3);
                            } else {
                                aoZ.mo14754hS(aoZ.field_unReadMuteCount - i4);
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15767a(aoZ, str3);
                            }
                            AppMethodBeat.m2505o(16267);
                            return null;
                        } else {
                            if (aoZ.field_unReadCount <= i4) {
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().apb(str3);
                                C9638aw.getNotification().cancelNotification(str3);
                            } else {
                                aoZ.mo14753hR(0);
                                aoZ.mo14756hU(0);
                                aoZ.mo14748hM(aoZ.field_unReadCount - i4);
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15767a(aoZ, str3);
                            }
                            AppMethodBeat.m2505o(16267);
                            return null;
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("qy_chat_update")) {
                        C25754e.m40903p((String) map.get(".sysmsg.brand_username"), (String) map.get(".sysmsg.chat_id"), (String) map.get(".sysmsg.ver"));
                    }
                }
                if (str != null) {
                    if (str.equals("bindmobiletip")) {
                        i = C5046bo.getInt((String) map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                        str4 = C5046bo.nullAsNil((String) map.get(".sysmsg.bindmobiletip.deviceid"));
                        Object nullAsNil = C5046bo.nullAsNil((String) map.get(".sysmsg.bindmobiletip.wording"));
                        str2 = new String(Base64.decode(str4.getBytes(), 0));
                        C4990ab.m7417i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", Integer.valueOf(i), str2, new String(C1332b.m2847bI(C1427q.m3028LM().getBytes()).mo4675Lv(16).f1226wR), nullAsNil);
                        if (C5046bo.isNullOrNil(str2) || str2.equals(r4)) {
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.TRUE);
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(i == 1));
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, nullAsNil);
                        }
                        AppMethodBeat.m2505o(16267);
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckConsistency")) {
                        bfl bfl = new bfl();
                        bfl.fMd = (String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                        bfl.wJn = C5046bo.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                        bfl.wJo = C5046bo.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                        bfl.vPb = C5046bo.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                        bfl.wJp = C42195f.m74434f(bfl.fMd, (long) bfl.wJn, (long) bfl.wJo);
                        bfl.FileSize = (int) C42195f.m74436mm(bfl.fMd);
                        bfl.wJq = C6998b.oTO.bVI() ? 1 : 0;
                        bfl.vZF = C18172y.m28611Me();
                        bfl.wJr = C42195f.m74435h(bfl.fMd, Integer.valueOf(bfl.wJn), Integer.valueOf(bfl.wJo), Integer.valueOf(bfl.vPb), bfl.wJp, Integer.valueOf(bfl.FileSize), Integer.valueOf(bfl.wJq), Integer.valueOf(bfl.vZF));
                        C9638aw.m17190ZK();
                        C18628c.m29077XL().mo7920c(new C3465a(61, bfl));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckHook")) {
                        bfn bfn = new bfn();
                        bfn.vPb = C5046bo.getInt((String) map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                        bfn.wJt = C6998b.oTO.mo8108jE(false);
                        bfn.wJq = C6998b.oTO.bVI() ? 1 : 0;
                        bfn.vZF = C18172y.m28611Me();
                        bfn.wJr = C42195f.m74435h(Integer.valueOf(bfn.vPb), bfn.wJt, Integer.valueOf(bfn.wJq), Integer.valueOf(bfn.vZF));
                        C9638aw.m17190ZK();
                        C18628c.m29077XL().mo7920c(new C3465a(62, bfn));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckGetAppList")) {
                        bfm bfm = new bfm();
                        bfm.vPb = C5046bo.getInt((String) map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                        bfm.wJs = C6998b.oTO.bVQ();
                        bfm.wJq = C6998b.oTO.bVI() ? 1 : 0;
                        bfm.vZF = C18172y.m28611Me();
                        bfm.wJr = C42195f.m74435h(Integer.valueOf(bfm.vPb), bfm.wJs, Integer.valueOf(bfm.wJq), Integer.valueOf(bfm.vZF));
                        C9638aw.m17190ZK();
                        C18628c.m29077XL().mo7920c(new C3465a(63, bfm));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckGetExtInfo")) {
                        final Map<String, String> map2 = map;
                        C7305d.m12299g(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(16264);
                                int i = C5046bo.getInt((String) map2.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                                if (C5046bo.getInt((String) map2.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0) {
                                    C44761d.qjp.mo8448ff(i, 0);
                                    AppMethodBeat.m2505o(16264);
                                    return;
                                }
                                C44761d.qjp.mo8448ff(i, 15);
                                AppMethodBeat.m2505o(16264);
                            }
                        }, "syscmd_rpt_cc");
                    }
                }
                if (!C5046bo.isNullOrNil(str)) {
                    if (str.equals("functionmsg")) {
                        C4990ab.m7410d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                        ((C25783q) C1720g.m3530M(C25783q.class)).getReceiver().mo39200a(c7254cm, map);
                    }
                }
                if (!C5046bo.isNullOrNil(str)) {
                    if (str.equals("paymsg")) {
                        C4990ab.m7411d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", Integer.valueOf(C5046bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Long.valueOf(c7254cm.ptF), (String) map.get(".sysmsg.paymsg.fromusername"), (String) map.get(".sysmsg.paymsg.tousername"), (String) map.get(".sysmsg.paymsg.paymsgid"), (String) map.get(".sysmsg.paymsg.appmsgcontent"));
                        try {
                            str2 = URLDecoder.decode((String) map.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                            if (!C5046bo.isNullOrNil(str2)) {
                                C26206ni c26206ni = new C26206ni();
                                c26206ni.cJE.type = i2;
                                c26206ni.cJE.content = str2;
                                c26206ni.cJE.cEV = str3;
                                c26206ni.cJE.toUser = str4;
                                c26206ni.cJE.cJF = str5;
                                C4879a.xxA.mo10055m(c26206ni);
                            }
                        } catch (Exception e222222) {
                            C4990ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e222222, "", new Object[0]);
                            C4990ab.m7411d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", e222222.getMessage());
                        }
                    }
                }
                AppMethodBeat.m2505o(16267);
                return c1198b;
            }
        }
        c1198b = c1198b2;
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
        if (C5046bo.isNullOrNil(str)) {
        }
        if (C5046bo.isNullOrNil(str)) {
        }
        AppMethodBeat.m2505o(16267);
        return c1198b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d A:{SYNTHETIC, Splitter:B:46:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a2 A:{SYNTHETIC, Splitter:B:49:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c A:{SYNTHETIC, Splitter:B:37:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091 A:{SYNTHETIC, Splitter:B:40:0x0091} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d A:{SYNTHETIC, Splitter:B:46:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a2 A:{SYNTHETIC, Splitter:B:49:0x00a2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    private static String m74434f(String str, long j, long j2) {
        InputStream inputStream;
        Throwable e;
        String str2;
        AppMethodBeat.m2504i(16268);
        ZipFile zipFile;
        try {
            if (str.startsWith("@")) {
                zipFile = new ZipFile(C4996ah.getContext().getApplicationInfo().sourceDir);
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
                    AppMethodBeat.m2505o(16268);
                    throw e;
                }
            }
            inputStream = C5730e.openRead(str);
            zipFile = null;
            while (j > 0) {
                try {
                    j -= inputStream.skip(j);
                } catch (Exception e5) {
                    e = e5;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
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
                        AppMethodBeat.m2505o(16268);
                        return str2;
                    } catch (Throwable th2) {
                        e = th2;
                        if (inputStream != null) {
                        }
                        if (zipFile != null) {
                        }
                        AppMethodBeat.m2505o(16268);
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
            str2 = C5046bo.m7543cd(instance.digest());
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
            AppMethodBeat.m2505o(16268);
        } catch (Exception e10) {
            e = e10;
            zipFile = null;
            inputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            str2 = "";
            if (inputStream != null) {
            }
            if (zipFile != null) {
            }
            AppMethodBeat.m2505o(16268);
            return str2;
        } catch (Throwable th3) {
            e = th3;
            zipFile = null;
            inputStream = null;
            if (inputStream != null) {
            }
            if (zipFile != null) {
            }
            AppMethodBeat.m2505o(16268);
            throw e;
        }
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A:{SYNTHETIC, Splitter:B:28:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: mm */
    private static long m74436mm(String str) {
        Throwable e;
        Throwable th;
        long j = -1;
        AppMethodBeat.m2504i(16269);
        if (str.startsWith("@")) {
            ZipFile zipFile;
            try {
                zipFile = new ZipFile(C4996ah.getContext().getApplicationInfo().sourceDir);
                try {
                    ZipEntry entry = zipFile.getEntry(str.substring(1));
                    if (entry == null) {
                        try {
                            zipFile.close();
                        } catch (IOException e2) {
                        }
                        AppMethodBeat.m2505o(16269);
                        return j;
                    }
                    j = entry.getSize();
                    try {
                        zipFile.close();
                    } catch (IOException e3) {
                    }
                    AppMethodBeat.m2505o(16269);
                    return j;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (IOException e5) {
                e = e5;
                zipFile = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                        }
                    }
                    AppMethodBeat.m2505o(16269);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                    }
                    AppMethodBeat.m2505o(16269);
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
                AppMethodBeat.m2505o(16269);
                throw th;
            }
        }
        j = C5730e.asZ(str);
        AppMethodBeat.m2505o(16269);
        return j;
    }

    /* renamed from: h */
    private static String m74435h(Object... objArr) {
        AppMethodBeat.m2504i(16270);
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
                    C4990ab.m7413e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", obj);
                    str = "";
                    AppMethodBeat.m2505o(16270);
                    return str;
                }
            }
            str = C5046bo.m7543cd(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
            AppMethodBeat.m2505o(16270);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            str = "";
            AppMethodBeat.m2505o(16270);
            return str;
        }
    }
}
