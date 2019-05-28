package com.tencent.p177mm.plugin.subapp.p537ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C26497b;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C45462h;
import com.tencent.p177mm.protocal.protobuf.coa;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.d */
public final class C35279d {
    /* renamed from: bm */
    public static coa m57950bm(int i, String str) {
        AppMethodBeat.m2504i(25590);
        coa coa = new coa();
        switch (i) {
            case 0:
                coa.vHq = TXRecordCommon.AUDIO_SAMPLERATE_8000;
                coa.vHr = 16;
                coa.vHo = 5;
                coa.vHp = 5;
                break;
            case 1:
                coa.vHq = TXRecordCommon.AUDIO_SAMPLERATE_16000;
                coa.vHr = 16;
                coa.vHo = 4;
                coa.vHp = 4;
                break;
            case 4:
                coa.vHq = TXRecordCommon.AUDIO_SAMPLERATE_16000;
                C26497b uN = C32850q.m53727uN(str);
                if (uN != null && (uN instanceof C45462h)) {
                    int sampleRate = ((C45462h) uN).getSampleRate();
                    if (sampleRate >= TXRecordCommon.AUDIO_SAMPLERATE_8000) {
                        coa.vHq = sampleRate;
                    }
                }
                coa.vHr = 16;
                coa.vHo = 6;
                coa.vHp = 6;
                break;
            default:
                coa.vHq = 0;
                coa.vHr = 0;
                coa.vHo = 0;
                coa.vHp = 0;
                break;
        }
        AppMethodBeat.m2505o(25590);
        return coa;
    }
}
