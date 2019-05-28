package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@TargetApi(21)
public final class c {
    public static final c aPD = new c(new int[]{2}, 2);
    final int[] aPE;
    private final int aPF;

    static {
        AppMethodBeat.i(94650);
        AppMethodBeat.o(94650);
    }

    public static c ai(Context context) {
        AppMethodBeat.i(94645);
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        c cVar;
        if (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            cVar = aPD;
            AppMethodBeat.o(94645);
            return cVar;
        }
        cVar = new c(registerReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), registerReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
        AppMethodBeat.o(94645);
        return cVar;
    }

    private c(int[] iArr, int i) {
        AppMethodBeat.i(94646);
        if (iArr != null) {
            this.aPE = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.aPE);
        } else {
            this.aPE = new int[0];
        }
        this.aPF = i;
        AppMethodBeat.o(94646);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(94647);
        if (this == obj) {
            AppMethodBeat.o(94647);
            return true;
        } else if (obj instanceof c) {
            c cVar = (c) obj;
            if (Arrays.equals(this.aPE, cVar.aPE) && this.aPF == cVar.aPF) {
                AppMethodBeat.o(94647);
                return true;
            }
            AppMethodBeat.o(94647);
            return false;
        } else {
            AppMethodBeat.o(94647);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(94648);
        int hashCode = this.aPF + (Arrays.hashCode(this.aPE) * 31);
        AppMethodBeat.o(94648);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(94649);
        String str = "AudioCapabilities[maxChannelCount=" + this.aPF + ", supportedEncodings=" + Arrays.toString(this.aPE) + "]";
        AppMethodBeat.o(94649);
        return str;
    }
}
