package com.tencent.p177mm.plugin.music.p460b.p996a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.music.b.a.b */
public final class C46092b {
    /* renamed from: zn */
    public static int m85963zn(int i) {
        AppMethodBeat.m2504i(104814);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:".concat(String.valueOf(i)));
        switch (i) {
            case 702:
                AppMethodBeat.m2505o(104814);
                return 98;
            case 703:
                AppMethodBeat.m2505o(104814);
                return 99;
            case 704:
                AppMethodBeat.m2505o(104814);
                return 100;
            case 705:
                AppMethodBeat.m2505o(104814);
                return 101;
            case 706:
                AppMethodBeat.m2505o(104814);
                return 102;
            case 707:
                AppMethodBeat.m2505o(104814);
                return 103;
            case 708:
                AppMethodBeat.m2505o(104814);
                return 104;
            case 709:
                AppMethodBeat.m2505o(104814);
                return 105;
            case 710:
                AppMethodBeat.m2505o(104814);
                return 106;
            case 711:
                AppMethodBeat.m2505o(104814);
                return 107;
            case 712:
                AppMethodBeat.m2505o(104814);
                return 108;
            case 713:
                AppMethodBeat.m2505o(104814);
                return C31128d.MIC_AVROUND_BLUR;
            case 714:
                AppMethodBeat.m2505o(104814);
                return 120;
            case 715:
                AppMethodBeat.m2505o(104814);
                return 109;
            default:
                AppMethodBeat.m2505o(104814);
                return 115;
        }
    }

    /* renamed from: r */
    static void m85962r(ArrayList<IDKey> arrayList) {
        AppMethodBeat.m2504i(104815);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idkeyGroupStat:  id:688");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            stringBuilder.append(", key:" + iDKey.GetKey() + " value:" + iDKey.GetValue());
        }
        C45174b.m83206d("MicroMsg.Audio.AudioPlayIdKeyReport", stringBuilder.toString());
        AppMethodBeat.m2505o(104815);
    }
}
