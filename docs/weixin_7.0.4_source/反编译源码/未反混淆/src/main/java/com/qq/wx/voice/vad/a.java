package com.qq.wx.voice.vad;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static boolean DEBUG = false;
    public static boolean bCE = false;
    public EVadNative bCC = new EVadNative();
    public MMVoipVadNative bCD = new MMVoipVadNative();
    public long handle = 0;

    public a() {
        AppMethodBeat.i(93970);
        AppMethodBeat.o(93970);
    }

    public static void aU(boolean z) {
        AppMethodBeat.i(93971);
        bCE = z;
        if (z) {
            System.loadLibrary("MMVoipVadEmbed");
            if (DEBUG) {
                System.out.println("EVad loadLib MMVoipVadEmbed");
                AppMethodBeat.o(93971);
                return;
            }
        }
        System.loadLibrary("EVadEmbed");
        if (DEBUG) {
            System.out.println("EVad loadLib EVadEmbed");
        }
        AppMethodBeat.o(93971);
    }

    public final int b(short[] sArr, int i) {
        AppMethodBeat.i(93972);
        if (this.handle == 0) {
            AppMethodBeat.o(93972);
            return 1;
        }
        if (DEBUG) {
            System.out.println("EVad AddData handle = " + this.handle);
        }
        int AddData;
        if (bCE) {
            AddData = this.bCD.AddData(this.handle, sArr, i);
            AppMethodBeat.o(93972);
            return AddData;
        }
        AddData = this.bCC.AddData(this.handle, sArr, i);
        AppMethodBeat.o(93972);
        return AddData;
    }

    public final int vU() {
        AppMethodBeat.i(93973);
        if (this.handle == 0) {
            AppMethodBeat.o(93973);
            return 1;
        }
        if (DEBUG) {
            System.out.println("EVad Release handle = " + this.handle);
        }
        int Release;
        if (bCE) {
            Release = this.bCD.Release(this.handle);
            AppMethodBeat.o(93973);
            return Release;
        }
        Release = this.bCC.Release(this.handle);
        AppMethodBeat.o(93973);
        return Release;
    }
}
