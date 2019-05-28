package com.google.android.exoplayer2.p099a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@TargetApi(21)
/* renamed from: com.google.android.exoplayer2.a.c */
public final class C8639c {
    public static final C8639c aPD = new C8639c(new int[]{2}, 2);
    final int[] aPE;
    private final int aPF;

    static {
        AppMethodBeat.m2504i(94650);
        AppMethodBeat.m2505o(94650);
    }

    /* renamed from: ai */
    public static C8639c m15297ai(Context context) {
        AppMethodBeat.m2504i(94645);
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        C8639c c8639c;
        if (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            c8639c = aPD;
            AppMethodBeat.m2505o(94645);
            return c8639c;
        }
        c8639c = new C8639c(registerReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), registerReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
        AppMethodBeat.m2505o(94645);
        return c8639c;
    }

    private C8639c(int[] iArr, int i) {
        AppMethodBeat.m2504i(94646);
        if (iArr != null) {
            this.aPE = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.aPE);
        } else {
            this.aPE = new int[0];
        }
        this.aPF = i;
        AppMethodBeat.m2505o(94646);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(94647);
        if (this == obj) {
            AppMethodBeat.m2505o(94647);
            return true;
        } else if (obj instanceof C8639c) {
            C8639c c8639c = (C8639c) obj;
            if (Arrays.equals(this.aPE, c8639c.aPE) && this.aPF == c8639c.aPF) {
                AppMethodBeat.m2505o(94647);
                return true;
            }
            AppMethodBeat.m2505o(94647);
            return false;
        } else {
            AppMethodBeat.m2505o(94647);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(94648);
        int hashCode = this.aPF + (Arrays.hashCode(this.aPE) * 31);
        AppMethodBeat.m2505o(94648);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(94649);
        String str = "AudioCapabilities[maxChannelCount=" + this.aPF + ", supportedEncodings=" + Arrays.toString(this.aPE) + "]";
        AppMethodBeat.m2505o(94649);
        return str;
    }
}
