package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b implements l {
    public final int a(String str, gu guVar, bi biVar) {
        AppMethodBeat.i(17450);
        biVar.setContent(guVar.vED.wVI);
        String str2 = guVar.vEB.wVI;
        String str3 = guVar.vEC.wVI;
        if (!((String) d.aUr().aUs().Ry().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = guVar.vED.wVI;
        Map z = br.z(str2, "msg");
        as dK = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().dK(str2, str3);
        if (dK == null) {
            ab.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
            AppMethodBeat.o(17450);
            return -1;
        }
        EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(dK.cvZ);
        if (Jd == null) {
            ab.w("MicroMsg.BackupItemEmoji", "EmojiInfo is null");
            Jd = new EmojiInfo();
            as.a(dK, Jd);
            Jd.field_catalog = EmojiInfo.yau;
            d.aUr().aUs().aUp().E(Jd);
        }
        if (z.get(".msg.emoji.$androidmd5") == null) {
            str3 = a.Fg(dK.cvZ);
            if (!bo.isNullOrNil(str3)) {
                dK.cvZ = str3;
                ab.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", str3);
            }
        }
        String str4 = dK.cwg;
        biVar.setType(47);
        biVar.jv(dK.cvZ);
        str3 = dK.fWW;
        boolean z2 = (Jd.xy() || Jd.isGif()) ? false : true;
        biVar.setContent(ap.a(str3, 0, z2, dK.cvZ, false, ""));
        if (!Jd.duP()) {
            String Yb = d.aUr().aUs().Yb();
            if (TextUtils.isEmpty(str4)) {
                com.tencent.mm.plugin.backup.b.g.b(guVar, 4, Yb + dK.cvZ + "_thumb");
                com.tencent.mm.plugin.backup.b.g.b(guVar, 5, Yb + dK.cvZ);
            } else {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(Yb + str4);
                if (!bVar.exists()) {
                    bVar.mkdirs();
                }
                com.tencent.mm.plugin.backup.b.g.b(guVar, 4, Yb + str4 + "/" + dK.cvZ + "_cover");
                com.tencent.mm.plugin.backup.b.g.b(guVar, 5, Yb + str4 + "/" + dK.cvZ);
            }
        }
        ab.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.l(biVar))));
        AppMethodBeat.o(17450);
        return 0;
    }

    public final int a(gu guVar, boolean z, bi biVar, String str, LinkedList<u> linkedList, HashMap<Long, h.a> hashMap, boolean z2, long j) {
        int i;
        AppMethodBeat.i(17449);
        if (bo.isNullOrNil(biVar.field_content)) {
            i = 0;
        } else {
            i = biVar.field_content.getBytes().length;
        }
        String trim = ap.aps(biVar.field_content).xXL.trim();
        if (!com.tencent.mm.plugin.backup.b.g.Fd(trim)) {
            trim = biVar.field_content;
            if (!com.tencent.mm.plugin.backup.b.g.Fd(trim)) {
                trim = a.a(biVar, guVar);
                if (biVar.field_isSend != 1 && c.kH(biVar.field_talker)) {
                    trim = biVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !com.tencent.mm.plugin.backup.b.g.Fd(trim)) {
            ab.d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(trim)));
            AppMethodBeat.o(17449);
            return -1;
        }
        bts bts = new bts();
        bts.alV(bo.bc(trim, ""));
        guVar.vED = bts;
        EmojiInfo aqi = d.aUr().aUs().aUp().aqi(biVar.field_imgPath);
        if (aqi == null || !aqi.duS()) {
            if (aqi != null) {
                String str2;
                if (TextUtils.isEmpty(aqi.field_groupId)) {
                    str2 = d.aUr().aUs().Yb() + aqi.Aq() + "_thumb";
                    if (e.asZ(str2) < 0) {
                        ab.e("MicroMsg.BackupItemEmoji", "thumbPath error");
                        AppMethodBeat.o(17449);
                        return -1;
                    }
                    i = i.a(new i.a(str2, guVar, (LinkedList) linkedList, 4, z, "_thumb", z2)) + i;
                } else {
                    str2 = d.aUr().aUs().Yb() + aqi.field_groupId + "/" + aqi.Aq() + "_cover";
                    if (e.asZ(str2) < 0) {
                        ab.e("MicroMsg.BackupItemEmoji", "thumbPath error");
                        AppMethodBeat.o(17449);
                        return -1;
                    }
                    i = i.a(new i.a(str2, guVar, (LinkedList) linkedList, 4, z, "_thumb", z2)) + i;
                }
                if (TextUtils.isEmpty(aqi.field_groupId) && aqi.duP()) {
                    i += i.a(new i.a(d.aUr().aUs().Yb() + aqi.Aq(), guVar, (LinkedList) linkedList, 5, z, z2, null));
                } else if (aqi.duR()) {
                    i += i.a(new i.a(d.aUr().aUs().Yb() + aqi.field_groupId + "/" + aqi.Aq(), guVar, (LinkedList) linkedList, 5, z, z2, null));
                }
            }
            AppMethodBeat.o(17449);
            return i;
        }
        AppMethodBeat.o(17449);
        return i;
    }
}
