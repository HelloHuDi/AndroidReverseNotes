package com.tencent.p177mm.plugin.backup.bakoldlogic.p917b;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.btt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.i */
public final class C11111i {

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.i$a */
    public static class C11112a {
        int cyQ;
        EmojiInfo exP;
        String filePath;
        C40522gu jvB;
        LinkedList<C19993u> jvC;
        boolean jvD = true;
        String jvE;
        boolean jvF;
        C19993u jvy;

        public C11112a(String str, C40522gu c40522gu, LinkedList<C19993u> linkedList, int i, boolean z, C19993u c19993u) {
            this.filePath = str;
            this.jvB = c40522gu;
            this.jvC = linkedList;
            this.cyQ = i;
            this.jvD = false;
            this.jvF = z;
            this.jvy = c19993u;
        }

        public C11112a(String str, C40522gu c40522gu, LinkedList<C19993u> linkedList, int i, String str2) {
            this.filePath = str;
            this.jvB = c40522gu;
            this.jvC = linkedList;
            this.cyQ = i;
            this.jvD = false;
            this.jvE = str2;
            this.jvF = false;
            this.jvy = null;
        }

        public C11112a(String str, C40522gu c40522gu, LinkedList<C19993u> linkedList, EmojiInfo emojiInfo) {
            this.filePath = str;
            this.jvB = c40522gu;
            this.jvC = linkedList;
            this.cyQ = 5;
            this.jvD = false;
            this.jvF = false;
            this.jvy = null;
            this.exP = emojiInfo;
        }
    }

    /* renamed from: a */
    public static int m18825a(C11112a c11112a) {
        AppMethodBeat.m2504i(17801);
        if (c11112a.jvB == null) {
            C4990ab.m7413e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", "backupItemInfo.backupitem");
            AppMethodBeat.m2505o(17801);
            return 0;
        }
        int cs = C1173e.m2560cs(c11112a.filePath);
        if (cs <= 0) {
            C4990ab.m7412e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + c11112a.filePath);
            AppMethodBeat.m2505o(17801);
            return 0;
        } else if (c11112a.jvD) {
            AppMethodBeat.m2505o(17801);
            return cs;
        } else if (cs < Utility.DEFAULT_STREAM_BUFFER_SIZE && c11112a.jvB.vJd.getILen() == 0) {
            byte[] f;
            if (c11112a.cyQ != 5) {
                f = C1173e.m2571f(c11112a.filePath, 0, -1);
            } else if (c11112a.exP == null) {
                C4990ab.m7412e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
                f = null;
            } else {
                f = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(c11112a.exP);
            }
            SKBuiltinBuffer_t buffer = new SKBuiltinBuffer_t().setBuffer(f);
            c11112a.jvB.vJe = cs;
            c11112a.jvB.vJf = c11112a.cyQ;
            c11112a.jvB.vJd = buffer;
            AppMethodBeat.m2505o(17801);
            return cs;
        } else if (c11112a.jvC == null) {
            C4990ab.m7412e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
            AppMethodBeat.m2505o(17801);
            return 0;
        } else {
            String str = c11112a.jvB.vEB.toString() + "_" + c11112a.jvB.vEC.toString() + "_" + c11112a.jvB.ptF + "_backup_" + (c11112a.jvE == null ? "" : c11112a.jvE);
            C4990ab.m7411d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", str, c11112a.filePath);
            c11112a.jvB.vJb.add(new bts().alV(str));
            c11112a.jvB.vJc.add(new btt().mo64053LQ(c11112a.cyQ));
            c11112a.jvB.vJa = c11112a.jvB.vJb.size();
            if (c11112a.jvy == null) {
                c11112a.jvy = new C19993u();
            }
            c11112a.jvy.jCr = c11112a.jvB.ptF;
            c11112a.jvy.cHr = str;
            c11112a.jvy.path = c11112a.filePath;
            c11112a.jvy.type = c11112a.cyQ;
            if (!c11112a.jvF) {
                c11112a.jvC.add(c11112a.jvy);
            }
            AppMethodBeat.m2505o(17801);
            return 0;
        }
    }
}
