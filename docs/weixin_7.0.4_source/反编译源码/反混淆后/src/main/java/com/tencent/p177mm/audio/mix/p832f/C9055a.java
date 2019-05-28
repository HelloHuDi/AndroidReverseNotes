package com.tencent.p177mm.audio.mix.p832f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.audio.mix.f.a */
public final class C9055a {
    /* renamed from: E */
    public static boolean m16424E(int i, int i2, int i3) {
        AppMethodBeat.m2504i(137135);
        if (!C9055a.m16425gA(i)) {
            AppMethodBeat.m2505o(137135);
            return false;
        } else if (!C9055a.m16426gB(i2)) {
            AppMethodBeat.m2505o(137135);
            return false;
        } else if (C9055a.m16427gC(i3)) {
            AppMethodBeat.m2505o(137135);
            return true;
        } else {
            AppMethodBeat.m2505o(137135);
            return false;
        }
    }

    /* renamed from: gA */
    private static boolean m16425gA(int i) {
        AppMethodBeat.m2504i(137136);
        if (i <= 0) {
            C45174b.m83208e("MicroMsg.Mix.AudioMixConfig", "sampleRate is illegal! %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(137136);
            return false;
        } else if (i == TXRecordCommon.AUDIO_SAMPLERATE_44100) {
            AppMethodBeat.m2505o(137136);
            return true;
        } else {
            AppMethodBeat.m2505o(137136);
            return false;
        }
    }

    /* renamed from: gB */
    private static boolean m16426gB(int i) {
        AppMethodBeat.m2504i(137137);
        if (i <= 0) {
            C45174b.m83208e("MicroMsg.Mix.AudioMixConfig", "channels is illegal, %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(137137);
            return false;
        } else if (i == 2) {
            AppMethodBeat.m2505o(137137);
            return true;
        } else {
            AppMethodBeat.m2505o(137137);
            return false;
        }
    }

    /* renamed from: gC */
    private static boolean m16427gC(int i) {
        AppMethodBeat.m2504i(137138);
        if (i <= 0) {
            C45174b.m83208e("MicroMsg.Mix.AudioMixConfig", "encode is illegal, %d", Integer.valueOf(i));
        }
        if (i == 2) {
            AppMethodBeat.m2505o(137138);
            return true;
        }
        AppMethodBeat.m2505o(137138);
        return false;
    }
}
