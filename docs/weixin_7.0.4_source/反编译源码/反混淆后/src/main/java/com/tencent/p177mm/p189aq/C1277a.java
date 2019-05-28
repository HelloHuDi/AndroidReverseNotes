package com.tencent.p177mm.p189aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p612ui.chatting.p1345j.C23797b;
import com.tencent.p177mm.p712j.p713a.p714a.C6594c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7578w;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.aq.a */
public class C1277a {
    private static C1277a fCi;

    /* renamed from: com.tencent.mm.aq.a$1 */
    public class C12781 implements Runnable {
        final /* synthetic */ String eiH;

        public C12781(String str) {
            this.eiH = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(16441);
            C1277a.m2749rW(this.eiH);
            AppMethodBeat.m2505o(16441);
        }
    }

    public static C1277a agF() {
        AppMethodBeat.m2504i(16442);
        if (fCi == null) {
            synchronized (C1277a.class) {
                try {
                    if (fCi == null) {
                        fCi = new C1277a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(16442);
                    }
                }
            }
        }
        C1277a c1277a = fCi;
        AppMethodBeat.m2505o(16442);
        return c1277a;
    }

    /* renamed from: rW */
    static /* synthetic */ void m2749rW(String str) {
        AppMethodBeat.m2504i(16443);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] username is null!");
            AppMethodBeat.m2505o(16443);
            return;
        }
        long aaD = C1839cb.aaD();
        long j = aaD - 259200000;
        C4990ab.m7416i("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] serverTime:" + aaD + " beforeTime:" + j + " beforeTime format:" + C14835h.formatTime("yyyy-MM-dd HH:mm:ss", j / 1000) + "username:" + str);
        C6973b bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
        C7578w QN = bOm.mo15218QN(str);
        if (QN.field_seqBlockInfo != null) {
            C6594c c6594c;
            List<C6594c> mO = QN.mo16810mO(j);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("clear:");
            for (C6594c c6594c2 : mO) {
                stringBuilder.append("[" + c6594c2.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c6594c2.eoD + "] time:").append(C14835h.formatTime("yyyy-MM-dd HH:mm:ss", c6594c2.eoF / 1000)).append(" | ");
                QN.field_seqBlockInfo.eoG.remove(c6594c2);
            }
            stringBuilder.append("\nafter:");
            Iterator it = QN.field_seqBlockInfo.eoG.iterator();
            while (it.hasNext()) {
                c6594c2 = (C6594c) it.next();
                stringBuilder.append("[" + c6594c2.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c6594c2.eoD + "] time:").append(C14835h.formatTime("yyyy-MM-dd HH:mm:ss", c6594c2.eoF / 1000)).append(" | ");
            }
            if (mO.size() > 0) {
                C4990ab.m7416i("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] ret:" + bOm.mo15223b(QN) + " result:" + stringBuilder.toString());
            }
            C23797b c23797b = C23797b.yZH;
            C23797b.m36635ax(str, mO.size(), QN.field_seqBlockInfo.eoG.size());
        }
        AppMethodBeat.m2505o(16443);
    }
}
