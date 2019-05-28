package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.ugc.TXRecordCommon;

public final class d {
    public static coa bm(int i, String str) {
        AppMethodBeat.i(25590);
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
                b uN = q.uN(str);
                if (uN != null && (uN instanceof h)) {
                    int sampleRate = ((h) uN).getSampleRate();
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
        AppMethodBeat.o(25590);
        return coa;
    }
}
