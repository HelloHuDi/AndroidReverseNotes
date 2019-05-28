package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public static int zn(int i) {
        AppMethodBeat.i(104814);
        ab.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:".concat(String.valueOf(i)));
        switch (i) {
            case 702:
                AppMethodBeat.o(104814);
                return 98;
            case 703:
                AppMethodBeat.o(104814);
                return 99;
            case 704:
                AppMethodBeat.o(104814);
                return 100;
            case 705:
                AppMethodBeat.o(104814);
                return 101;
            case 706:
                AppMethodBeat.o(104814);
                return 102;
            case 707:
                AppMethodBeat.o(104814);
                return 103;
            case 708:
                AppMethodBeat.o(104814);
                return 104;
            case 709:
                AppMethodBeat.o(104814);
                return 105;
            case 710:
                AppMethodBeat.o(104814);
                return 106;
            case 711:
                AppMethodBeat.o(104814);
                return 107;
            case 712:
                AppMethodBeat.o(104814);
                return 108;
            case 713:
                AppMethodBeat.o(104814);
                return d.MIC_AVROUND_BLUR;
            case 714:
                AppMethodBeat.o(104814);
                return 120;
            case 715:
                AppMethodBeat.o(104814);
                return 109;
            default:
                AppMethodBeat.o(104814);
                return 115;
        }
    }

    static void r(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(104815);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idkeyGroupStat:  id:688");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            stringBuilder.append(", key:" + iDKey.GetKey() + " value:" + iDKey.GetValue());
        }
        com.tencent.mm.audio.mix.h.b.d("MicroMsg.Audio.AudioPlayIdKeyReport", stringBuilder.toString());
        AppMethodBeat.o(104815);
    }
}
