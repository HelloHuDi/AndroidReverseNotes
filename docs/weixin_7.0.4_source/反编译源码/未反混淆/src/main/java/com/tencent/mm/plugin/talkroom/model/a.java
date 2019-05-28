package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ugc.TXRecordCommon;

public final class a {
    private static int cpuFlag0;
    public static final int sxv;

    static {
        AppMethodBeat.i(25754);
        int Lw = m.Lw();
        cpuFlag0 = Lw;
        sxv = (Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? TXRecordCommon.AUDIO_SAMPLERATE_16000 : TXRecordCommon.AUDIO_SAMPLERATE_8000;
        AppMethodBeat.o(25754);
    }
}
