package com.tencent.p177mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.plugin.talkroom.model.a */
public final class C43682a {
    private static int cpuFlag0;
    public static final int sxv;

    static {
        AppMethodBeat.m2504i(25754);
        int Lw = C45290m.m83509Lw();
        cpuFlag0 = Lw;
        sxv = (Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? TXRecordCommon.AUDIO_SAMPLERATE_16000 : TXRecordCommon.AUDIO_SAMPLERATE_8000;
        AppMethodBeat.m2505o(25754);
    }
}
