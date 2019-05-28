package com.tencent.p177mm.plugin.music.p460b.p996a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.music.b.a.a */
public final class C39423a {
    /* renamed from: r */
    static void m67312r(ArrayList<IDKey> arrayList) {
        AppMethodBeat.m2504i(104813);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idkeyGroupStat:  id:971");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            stringBuilder.append(", key:" + iDKey.GetKey() + " value:" + iDKey.GetValue());
        }
        C45174b.m83206d("MicroMsg.Audio.AudioMixReport", stringBuilder.toString());
        AppMethodBeat.m2505o(104813);
    }
}
