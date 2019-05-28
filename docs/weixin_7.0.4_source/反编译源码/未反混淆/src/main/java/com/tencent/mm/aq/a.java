package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.w;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.List;

public class a {
    private static a fCi;

    /* renamed from: com.tencent.mm.aq.a$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String eiH;

        public AnonymousClass1(String str) {
            this.eiH = str;
        }

        public final void run() {
            AppMethodBeat.i(16441);
            a.rW(this.eiH);
            AppMethodBeat.o(16441);
        }
    }

    public static a agF() {
        AppMethodBeat.i(16442);
        if (fCi == null) {
            synchronized (a.class) {
                try {
                    if (fCi == null) {
                        fCi = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(16442);
                    }
                }
            }
        }
        a aVar = fCi;
        AppMethodBeat.o(16442);
        return aVar;
    }

    static /* synthetic */ void rW(String str) {
        AppMethodBeat.i(16443);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] username is null!");
            AppMethodBeat.o(16443);
            return;
        }
        long aaD = cb.aaD();
        long j = aaD - 259200000;
        ab.i("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] serverTime:" + aaD + " beforeTime:" + j + " beforeTime format:" + h.formatTime("yyyy-MM-dd HH:mm:ss", j / 1000) + "username:" + str);
        b bOm = ((j) g.K(j.class)).bOm();
        w QN = bOm.QN(str);
        if (QN.field_seqBlockInfo != null) {
            c cVar;
            List<c> mO = QN.mO(j);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("clear:");
            for (c cVar2 : mO) {
                stringBuilder.append("[" + cVar2.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cVar2.eoD + "] time:").append(h.formatTime("yyyy-MM-dd HH:mm:ss", cVar2.eoF / 1000)).append(" | ");
                QN.field_seqBlockInfo.eoG.remove(cVar2);
            }
            stringBuilder.append("\nafter:");
            Iterator it = QN.field_seqBlockInfo.eoG.iterator();
            while (it.hasNext()) {
                cVar2 = (c) it.next();
                stringBuilder.append("[" + cVar2.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cVar2.eoD + "] time:").append(h.formatTime("yyyy-MM-dd HH:mm:ss", cVar2.eoF / 1000)).append(" | ");
            }
            if (mO.size() > 0) {
                ab.i("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] ret:" + bOm.b(QN) + " result:" + stringBuilder.toString());
            }
            com.tencent.mm.ui.chatting.j.b bVar = com.tencent.mm.ui.chatting.j.b.yZH;
            com.tencent.mm.ui.chatting.j.b.ax(str, mO.size(), QN.field_seqBlockInfo.eoG.size());
        }
        AppMethodBeat.o(16443);
    }
}
