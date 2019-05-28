package com.tencent.mm.compatible.b;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c {

    public enum a {
        PCM,
        AMR,
        SILK,
        SPEEX,
        UNKNOWN;

        static {
            AppMethodBeat.o(92832);
        }
    }

    public static a KI() {
        AppMethodBeat.i(92833);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
        boolean z = q.etd.epO != 1;
        if (!sharedPreferences.contains("settings_voicerecorder_mode")) {
            sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", z).commit();
        }
        ab.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", Integer.valueOf(q.etd.epO), Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("settings_voicerecorder_mode", z)));
        a aVar;
        if (sharedPreferences.getBoolean("settings_voicerecorder_mode", z)) {
            aVar = a.PCM;
            AppMethodBeat.o(92833);
            return aVar;
        }
        aVar = a.AMR;
        AppMethodBeat.o(92833);
        return aVar;
    }
}
