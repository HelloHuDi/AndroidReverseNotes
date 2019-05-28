package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a implements com.tencent.mm.model.bz.a {
    public final void a(com.tencent.mm.ai.e.a aVar) {
        int i = 0;
        AppMethodBeat.i(53156);
        cm cmVar = aVar.eAB;
        if (cmVar.nao == 10002) {
            String a = aa.a(cmVar.vED);
            if (bo.isNullOrNil(a)) {
                ab.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(53156);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                String str = (String) z.get(".sysmsg.$type");
                if (bo.isNullOrNil(str)) {
                    ab.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
                    AppMethodBeat.o(53156);
                    return;
                }
                String cd = bo.cd(b.bI(q.LM().getBytes()).Lv(16).wR);
                int ank;
                ArrayList arrayList;
                Iterator it;
                xx xxVar;
                ArrayList JF;
                if (str.equalsIgnoreCase("EmojiBackup")) {
                    ank = bo.ank((String) z.get(".sysmsg.EmojiBackup.OpCode"));
                    str = (String) z.get(".sysmsg.EmojiBackup.DeviceID");
                    ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", cd, str);
                    if (bo.isNullOrNil(str) || !str.equalsIgnoreCase(cd)) {
                        ArrayList JE = b.JE(a);
                        if (ank == 1) {
                            if (JE == null || JE.size() <= 0) {
                                ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                AppMethodBeat.o(53156);
                                return;
                            }
                            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", Integer.valueOf(JE.size()));
                            c(0, JE);
                            AppMethodBeat.o(53156);
                            return;
                        } else if (ank != 2) {
                            if (ank == 3) {
                                ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
                                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                            }
                            AppMethodBeat.o(53156);
                            return;
                        } else if (JE == null || JE.size() <= 0) {
                            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            AppMethodBeat.o(53156);
                            return;
                        } else {
                            arrayList = new ArrayList();
                            if (JE != null && JE.size() > 0) {
                                it = JE.iterator();
                                while (it.hasNext()) {
                                    xxVar = (xx) it.next();
                                    if (xxVar != null) {
                                        arrayList.add(xxVar.Md5);
                                    }
                                }
                            }
                            j.getEmojiStorageMgr().xYn.eJ(arrayList);
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                            AppMethodBeat.o(53156);
                            return;
                        }
                    }
                    ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    AppMethodBeat.o(53156);
                    return;
                } else if (str.equalsIgnoreCase("EmotionBackup")) {
                    ank = Integer.valueOf((String) z.get(".sysmsg.EmotionBackup.OpCode")).intValue();
                    str = (String) z.get(".sysmsg.EmotionBackup.DeviceID");
                    if (bo.isNullOrNil(str) || !str.equalsIgnoreCase(cd)) {
                        JF = b.JF(a);
                        if (JF == null || JF.size() <= 0) {
                            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            AppMethodBeat.o(53156);
                            return;
                        } else if (ank == 1) {
                            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", Integer.valueOf(JF.size()));
                            ArrayList arrayList2 = new ArrayList();
                            int size = JF.size();
                            while (i < size) {
                                arrayList2.add(new com.tencent.mm.plugin.emoji.sync.a.b((String) JF.get(i)));
                                i++;
                            }
                            j.bkj().z(arrayList2);
                            j.bkj().kXj.bkG();
                            AppMethodBeat.o(53156);
                            return;
                        } else {
                            if (ank == 2) {
                                ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", Integer.valueOf(JF.size()));
                                j.getEmojiStorageMgr().xYo.aj(JF);
                            }
                            AppMethodBeat.o(53156);
                            return;
                        }
                    }
                    ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    AppMethodBeat.o(53156);
                    return;
                } else if (str.equalsIgnoreCase("SelfieEmojiBackup")) {
                    str = (String) z.get(".sysmsg.SelfieEmojiBackup.DeviceID");
                    ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture client devicesID:%s server devicesID:%s", cd, str);
                    if (bo.isNullOrNil(str) || !str.equalsIgnoreCase(cd)) {
                        int ank2 = bo.ank((String) z.get(".sysmsg.SelfieEmojiBackup.OpCode"));
                        JF = b.JE(a);
                        if (JF == null || JF.size() <= 0) {
                            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: empty list opCode %s", Integer.valueOf(ank2));
                            AppMethodBeat.o(53156);
                            return;
                        }
                        ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: opCode %s, size %s", Integer.valueOf(ank2), Integer.valueOf(JF.size()));
                        if (ank2 == 1) {
                            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: add capture %s", Integer.valueOf(JF.size()));
                            c(1, JF);
                            AppMethodBeat.o(53156);
                            return;
                        } else if (ank2 == 2) {
                            ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: delete capture %s", Integer.valueOf(JF.size()));
                            arrayList = new ArrayList();
                            it = JF.iterator();
                            while (it.hasNext()) {
                                xxVar = (xx) it.next();
                                if (xxVar != null) {
                                    arrayList.add(xxVar.Md5);
                                }
                            }
                            j.getEmojiStorageMgr().xYn.eK(arrayList);
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                            AppMethodBeat.o(53156);
                            return;
                        } else {
                            if (ank2 == 3) {
                                ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", Integer.valueOf(JF.size()));
                                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                            }
                            AppMethodBeat.o(53156);
                            return;
                        }
                    }
                    ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    AppMethodBeat.o(53156);
                    return;
                } else {
                    ab.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
                }
            }
            AppMethodBeat.o(53156);
            return;
        }
        ab.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(cmVar.nao));
        AppMethodBeat.o(53156);
    }

    private static void c(int i, ArrayList<xx> arrayList) {
        AppMethodBeat.i(53157);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            xx xxVar = (xx) it.next();
            EmojiInfo aqi = at.dsZ().xYn.aqi(xxVar.Md5);
            if (aqi == null) {
                aqi = new EmojiInfo();
                com.tencent.mm.plugin.emoji.h.b.a(xxVar, aqi);
                if (i == 1) {
                    aqi.field_groupId = "capture";
                } else {
                    aqi.field_catalog = EmojiInfo.yaB;
                }
                at.dsZ().xYn.F(aqi);
            } else {
                if (i == 1) {
                    aqi.field_groupId = "capture";
                } else {
                    aqi.field_catalog = EmojiInfo.yaB;
                }
                at.dsZ().xYn.G(aqi);
            }
        }
        AppMethodBeat.o(53157);
    }
}
