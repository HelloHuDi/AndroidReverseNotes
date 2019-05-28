package com.p123qq.p803wx.voice.vad;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.qq.wx.voice.vad.a */
public final class C25592a {
    public static boolean DEBUG = false;
    public static boolean bCE = false;
    public EVadNative bCC = new EVadNative();
    public MMVoipVadNative bCD = new MMVoipVadNative();
    public long handle = 0;

    public C25592a() {
        AppMethodBeat.m2504i(93970);
        AppMethodBeat.m2505o(93970);
    }

    /* renamed from: aU */
    public static void m40603aU(boolean z) {
        AppMethodBeat.m2504i(93971);
        bCE = z;
        if (z) {
            System.loadLibrary("MMVoipVadEmbed");
            if (DEBUG) {
                System.out.println("EVad loadLib MMVoipVadEmbed");
                AppMethodBeat.m2505o(93971);
                return;
            }
        }
        System.loadLibrary("EVadEmbed");
        if (DEBUG) {
            System.out.println("EVad loadLib EVadEmbed");
        }
        AppMethodBeat.m2505o(93971);
    }

    /* renamed from: b */
    public final int mo43300b(short[] sArr, int i) {
        AppMethodBeat.m2504i(93972);
        if (this.handle == 0) {
            AppMethodBeat.m2505o(93972);
            return 1;
        }
        if (DEBUG) {
            System.out.println("EVad AddData handle = " + this.handle);
        }
        int AddData;
        if (bCE) {
            AddData = this.bCD.AddData(this.handle, sArr, i);
            AppMethodBeat.m2505o(93972);
            return AddData;
        }
        AddData = this.bCC.AddData(this.handle, sArr, i);
        AppMethodBeat.m2505o(93972);
        return AddData;
    }

    /* renamed from: vU */
    public final int mo43301vU() {
        AppMethodBeat.m2504i(93973);
        if (this.handle == 0) {
            AppMethodBeat.m2505o(93973);
            return 1;
        }
        if (DEBUG) {
            System.out.println("EVad Release handle = " + this.handle);
        }
        int Release;
        if (bCE) {
            Release = this.bCD.Release(this.handle);
            AppMethodBeat.m2505o(93973);
            return Release;
        }
        Release = this.bCC.Release(this.handle);
        AppMethodBeat.m2505o(93973);
        return Release;
    }
}
