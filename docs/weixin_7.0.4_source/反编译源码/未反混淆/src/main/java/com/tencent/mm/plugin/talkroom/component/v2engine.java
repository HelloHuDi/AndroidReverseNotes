package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;

public class v2engine {
    private static g flC;

    public native int Close();

    public native int GetAudioData(PByteArray pByteArray, int i, PInt pInt, PInt pInt2);

    public native int GetStatis(PByteArray pByteArray, String str);

    public native int IsSilenceFrame();

    public native int Open(b bVar, int i, int i2, int i3, long j, int[] iArr, short[] sArr, int i4);

    public native int Send(byte[] bArr, short s);

    public native int SetCurrentMicId(int i);

    public native int initLive(int i, String str);

    public native int uninitLive();

    public static g ZL() {
        AppMethodBeat.i(25749);
        if (flC == null) {
            flC = new g(ah.getContext());
        }
        g gVar = flC;
        AppMethodBeat.o(25749);
        return gVar;
    }
}
