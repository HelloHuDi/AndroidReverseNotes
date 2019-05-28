package com.tencent.p177mm.plugin.emoji.p1252c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C32521bh;
import com.tencent.p177mm.plugin.emoji.p947e.C45852j;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;

/* renamed from: com.tencent.mm.plugin.emoji.c.c */
public final class C27732c extends C4884c<C32521bh> {
    public C27732c() {
        AppMethodBeat.m2504i(52815);
        this.xxI = C32521bh.class.getName().hashCode();
        AppMethodBeat.m2505o(52815);
    }

    /* renamed from: a */
    private static boolean m44049a(C32521bh c32521bh) {
        AppMethodBeat.m2504i(52816);
        if (c32521bh.cuB.cut == 37) {
            if (c32521bh.cuB.cuu == 5 && c32521bh.cuB.cuy == 2) {
                C45852j bkb = C45852j.bkb();
                C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
                try {
                    C5730e.deleteFile(C1720g.m3536RP().cachePath + "eggingfo.ini");
                    C5730e.m8618N(C5736j.m8649w(new C5728b(C45852j.getDataEmojiPath(), C45852j.kUd).mUri), true);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                }
                bkb.kUu = null;
            }
            if (c32521bh.cuB.cuy == 0) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", Integer.valueOf(c32521bh.cuB.cut), Integer.valueOf(c32521bh.cuB.cuu));
            }
        }
        AppMethodBeat.m2505o(52816);
        return false;
    }
}
