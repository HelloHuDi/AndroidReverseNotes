package com.tencent.p177mm.plugin.emoji.p727g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.sync.p948a.C38887b;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.emoji.g.a */
public final class C6837a implements C1837a {
    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        int i = 0;
        AppMethodBeat.m2504i(53156);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm.nao == 10002) {
            String a = C1946aa.m4148a(c7254cm.vED);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
                AppMethodBeat.m2505o(53156);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                String str = (String) z.get(".sysmsg.$type");
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7420w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
                    AppMethodBeat.m2505o(53156);
                    return;
                }
                String cd = C5046bo.m7543cd(C1332b.m2847bI(C1427q.m3028LM().getBytes()).mo4675Lv(16).f1226wR);
                int ank;
                ArrayList arrayList;
                Iterator it;
                C40588xx c40588xx;
                ArrayList JF;
                if (str.equalsIgnoreCase("EmojiBackup")) {
                    ank = C5046bo.ank((String) z.get(".sysmsg.EmojiBackup.OpCode"));
                    str = (String) z.get(".sysmsg.EmojiBackup.DeviceID");
                    C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", cd, str);
                    if (C5046bo.isNullOrNil(str) || !str.equalsIgnoreCase(cd)) {
                        ArrayList JE = C20376b.m31541JE(a);
                        if (ank == 1) {
                            if (JE == null || JE.size() <= 0) {
                                C4990ab.m7416i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                AppMethodBeat.m2505o(53156);
                                return;
                            }
                            C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", Integer.valueOf(JE.size()));
                            C6837a.m11293c(0, JE);
                            AppMethodBeat.m2505o(53156);
                            return;
                        } else if (ank != 2) {
                            if (ank == 3) {
                                C4990ab.m7416i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                            }
                            AppMethodBeat.m2505o(53156);
                            return;
                        } else if (JE == null || JE.size() <= 0) {
                            C4990ab.m7416i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            AppMethodBeat.m2505o(53156);
                            return;
                        } else {
                            arrayList = new ArrayList();
                            if (JE != null && JE.size() > 0) {
                                it = JE.iterator();
                                while (it.hasNext()) {
                                    c40588xx = (C40588xx) it.next();
                                    if (c40588xx != null) {
                                        arrayList.add(c40588xx.Md5);
                                    }
                                }
                            }
                            C42952j.getEmojiStorageMgr().xYn.mo48579eJ(arrayList);
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                            AppMethodBeat.m2505o(53156);
                            return;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    AppMethodBeat.m2505o(53156);
                    return;
                } else if (str.equalsIgnoreCase("EmotionBackup")) {
                    ank = Integer.valueOf((String) z.get(".sysmsg.EmotionBackup.OpCode")).intValue();
                    str = (String) z.get(".sysmsg.EmotionBackup.DeviceID");
                    if (C5046bo.isNullOrNil(str) || !str.equalsIgnoreCase(cd)) {
                        JF = C20376b.m31542JF(a);
                        if (JF == null || JF.size() <= 0) {
                            C4990ab.m7416i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            AppMethodBeat.m2505o(53156);
                            return;
                        } else if (ank == 1) {
                            C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", Integer.valueOf(JF.size()));
                            ArrayList arrayList2 = new ArrayList();
                            int size = JF.size();
                            while (i < size) {
                                arrayList2.add(new C38887b((String) JF.get(i)));
                                i++;
                            }
                            C42952j.bkj().mo61755z(arrayList2);
                            C42952j.bkj().kXj.bkG();
                            AppMethodBeat.m2505o(53156);
                            return;
                        } else {
                            if (ank == 2) {
                                C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", Integer.valueOf(JF.size()));
                                C42952j.getEmojiStorageMgr().xYo.mo74766aj(JF);
                            }
                            AppMethodBeat.m2505o(53156);
                            return;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    AppMethodBeat.m2505o(53156);
                    return;
                } else if (str.equalsIgnoreCase("SelfieEmojiBackup")) {
                    str = (String) z.get(".sysmsg.SelfieEmojiBackup.DeviceID");
                    C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture client devicesID:%s server devicesID:%s", cd, str);
                    if (C5046bo.isNullOrNil(str) || !str.equalsIgnoreCase(cd)) {
                        int ank2 = C5046bo.ank((String) z.get(".sysmsg.SelfieEmojiBackup.OpCode"));
                        JF = C20376b.m31541JE(a);
                        if (JF == null || JF.size() <= 0) {
                            C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: empty list opCode %s", Integer.valueOf(ank2));
                            AppMethodBeat.m2505o(53156);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: opCode %s, size %s", Integer.valueOf(ank2), Integer.valueOf(JF.size()));
                        if (ank2 == 1) {
                            C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: add capture %s", Integer.valueOf(JF.size()));
                            C6837a.m11293c(1, JF);
                            AppMethodBeat.m2505o(53156);
                            return;
                        } else if (ank2 == 2) {
                            C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: delete capture %s", Integer.valueOf(JF.size()));
                            arrayList = new ArrayList();
                            it = JF.iterator();
                            while (it.hasNext()) {
                                c40588xx = (C40588xx) it.next();
                                if (c40588xx != null) {
                                    arrayList.add(c40588xx.Md5);
                                }
                            }
                            C42952j.getEmojiStorageMgr().xYn.mo48580eK(arrayList);
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                            AppMethodBeat.m2505o(53156);
                            return;
                        } else {
                            if (ank2 == 3) {
                                C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", Integer.valueOf(JF.size()));
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                            }
                            AppMethodBeat.m2505o(53156);
                            return;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    AppMethodBeat.m2505o(53156);
                    return;
                } else {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
                }
            }
            AppMethodBeat.m2505o(53156);
            return;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(c7254cm.nao));
        AppMethodBeat.m2505o(53156);
    }

    /* renamed from: c */
    private static void m11293c(int i, ArrayList<C40588xx> arrayList) {
        AppMethodBeat.m2504i(53157);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C40588xx c40588xx = (C40588xx) it.next();
            EmojiInfo aqi = C23505at.dsZ().xYn.aqi(c40588xx.Md5);
            if (aqi == null) {
                aqi = new EmojiInfo();
                C2933b.m5222a(c40588xx, aqi);
                if (i == 1) {
                    aqi.field_groupId = "capture";
                } else {
                    aqi.field_catalog = EmojiInfo.yaB;
                }
                C23505at.dsZ().xYn.mo48554F(aqi);
            } else {
                if (i == 1) {
                    aqi.field_groupId = "capture";
                } else {
                    aqi.field_catalog = EmojiInfo.yaB;
                }
                C23505at.dsZ().xYn.mo48555G(aqi);
            }
        }
        AppMethodBeat.m2505o(53157);
    }
}
