package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static void r(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(104813);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idkeyGroupStat:  id:971");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            stringBuilder.append(", key:" + iDKey.GetKey() + " value:" + iDKey.GetValue());
        }
        b.d("MicroMsg.Audio.AudioMixReport", stringBuilder.toString());
        AppMethodBeat.o(104813);
    }
}
