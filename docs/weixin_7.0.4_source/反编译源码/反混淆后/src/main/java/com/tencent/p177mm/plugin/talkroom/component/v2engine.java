package com.tencent.p177mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.talkroom.component.v2engine */
public class v2engine {
    private static C1407g flC;

    public native int Close();

    public native int GetAudioData(PByteArray pByteArray, int i, PInt pInt, PInt pInt2);

    public native int GetStatis(PByteArray pByteArray, String str);

    public native int IsSilenceFrame();

    public native int Open(C46295b c46295b, int i, int i2, int i3, long j, int[] iArr, short[] sArr, int i4);

    public native int Send(byte[] bArr, short s);

    public native int SetCurrentMicId(int i);

    public native int initLive(int i, String str);

    public native int uninitLive();

    /* renamed from: ZL */
    public static C1407g m46685ZL() {
        AppMethodBeat.m2504i(25749);
        if (flC == null) {
            flC = new C1407g(C4996ah.getContext());
        }
        C1407g c1407g = flC;
        AppMethodBeat.m2505o(25749);
        return c1407g;
    }
}
