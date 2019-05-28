package com.tencent.p177mm.compatible.p219b;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.compatible.b.c */
public final class C18168c {

    /* renamed from: com.tencent.mm.compatible.b.c$a */
    public enum C18169a {
        PCM,
        AMR,
        SILK,
        SPEEX,
        UNKNOWN;

        static {
            AppMethodBeat.m2505o(92832);
        }
    }

    /* renamed from: KI */
    public static C18169a m28610KI() {
        AppMethodBeat.m2504i(92833);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
        boolean z = C1427q.etd.epO != 1;
        if (!sharedPreferences.contains("settings_voicerecorder_mode")) {
            sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", z).commit();
        }
        C4990ab.m7417i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", Integer.valueOf(C1427q.etd.epO), Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("settings_voicerecorder_mode", z)));
        C18169a c18169a;
        if (sharedPreferences.getBoolean("settings_voicerecorder_mode", z)) {
            c18169a = C18169a.PCM;
            AppMethodBeat.m2505o(92833);
            return c18169a;
        }
        c18169a = C18169a.AMR;
        AppMethodBeat.m2505o(92833);
        return c18169a;
    }
}
