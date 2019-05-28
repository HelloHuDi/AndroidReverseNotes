package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class i {

    public static class a {
        int cyQ;
        EmojiInfo exP;
        String filePath;
        gu jvB;
        LinkedList<u> jvC;
        boolean jvD = true;
        String jvE;
        boolean jvF;
        u jvy;

        public a(String str, gu guVar, LinkedList<u> linkedList, int i, boolean z, u uVar) {
            this.filePath = str;
            this.jvB = guVar;
            this.jvC = linkedList;
            this.cyQ = i;
            this.jvD = false;
            this.jvF = z;
            this.jvy = uVar;
        }

        public a(String str, gu guVar, LinkedList<u> linkedList, int i, String str2) {
            this.filePath = str;
            this.jvB = guVar;
            this.jvC = linkedList;
            this.cyQ = i;
            this.jvD = false;
            this.jvE = str2;
            this.jvF = false;
            this.jvy = null;
        }

        public a(String str, gu guVar, LinkedList<u> linkedList, EmojiInfo emojiInfo) {
            this.filePath = str;
            this.jvB = guVar;
            this.jvC = linkedList;
            this.cyQ = 5;
            this.jvD = false;
            this.jvF = false;
            this.jvy = null;
            this.exP = emojiInfo;
        }
    }

    public static int a(a aVar) {
        AppMethodBeat.i(17801);
        if (aVar.jvB == null) {
            ab.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", "backupItemInfo.backupitem");
            AppMethodBeat.o(17801);
            return 0;
        }
        int cs = e.cs(aVar.filePath);
        if (cs <= 0) {
            ab.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + aVar.filePath);
            AppMethodBeat.o(17801);
            return 0;
        } else if (aVar.jvD) {
            AppMethodBeat.o(17801);
            return cs;
        } else if (cs < Utility.DEFAULT_STREAM_BUFFER_SIZE && aVar.jvB.vJd.getILen() == 0) {
            byte[] f;
            if (aVar.cyQ != 5) {
                f = e.f(aVar.filePath, 0, -1);
            } else if (aVar.exP == null) {
                ab.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
                f = null;
            } else {
                f = ((d) g.M(d.class)).getEmojiMgr().l(aVar.exP);
            }
            SKBuiltinBuffer_t buffer = new SKBuiltinBuffer_t().setBuffer(f);
            aVar.jvB.vJe = cs;
            aVar.jvB.vJf = aVar.cyQ;
            aVar.jvB.vJd = buffer;
            AppMethodBeat.o(17801);
            return cs;
        } else if (aVar.jvC == null) {
            ab.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
            AppMethodBeat.o(17801);
            return 0;
        } else {
            String str = aVar.jvB.vEB.toString() + "_" + aVar.jvB.vEC.toString() + "_" + aVar.jvB.ptF + "_backup_" + (aVar.jvE == null ? "" : aVar.jvE);
            ab.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", str, aVar.filePath);
            aVar.jvB.vJb.add(new bts().alV(str));
            aVar.jvB.vJc.add(new btt().LQ(aVar.cyQ));
            aVar.jvB.vJa = aVar.jvB.vJb.size();
            if (aVar.jvy == null) {
                aVar.jvy = new u();
            }
            aVar.jvy.jCr = aVar.jvB.ptF;
            aVar.jvy.cHr = str;
            aVar.jvy.path = aVar.filePath;
            aVar.jvy.type = aVar.cyQ;
            if (!aVar.jvF) {
                aVar.jvC.add(aVar.jvy);
            }
            AppMethodBeat.o(17801);
            return 0;
        }
    }
}
