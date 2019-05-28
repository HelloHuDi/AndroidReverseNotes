package com.tencent.ttpic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoPrefsUtil {
    public static final String PREFS_KEY_DOWNGRADE_LEVEL = "prefs_key_downgrade_level";
    public static final String PREFS_KEY_ENCODE_WIDTH = "prefs_key_encode_width";
    public static final String PREFS_KEY_IS_MATERIAL_MUTE = "prefs_key_is_material_mute";
    public static final String PREFS_KEY_SEGMENT_ON_CPU = "prefs_key_segment_on_cpu";
    public static final String PREFS_KEY_STORAGE = "pref_key_storage";
    public static final String PREFS_KEY_USE_HARDWARE_DECODER = "prefs_key_use_hardware_decoder";
    public static final String PREFS_KEY_WATERMARK_COUNTDOWN = "prefs_key_watermark_countdown";
    public static final String PREFS_KEY_WATERMARK_SINCE = "prefs_key_watermark_since";
    public static final String PREF_KEY_WATERMARK = "pref_key_watermark";
    private static SharedPreferences mPrefs;

    public static void init(Context context) {
        AppMethodBeat.m2504i(84212);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        AppMethodBeat.m2505o(84212);
    }

    public static SharedPreferences getDefaultPrefs() {
        return mPrefs;
    }

    public static boolean getMaterialMute() {
        AppMethodBeat.m2504i(84213);
        boolean z = getDefaultPrefs().getBoolean(PREFS_KEY_IS_MATERIAL_MUTE, false);
        AppMethodBeat.m2505o(84213);
        return z;
    }

    public static void setMaterialMute(boolean z) {
        AppMethodBeat.m2504i(84214);
        getDefaultPrefs().edit().putBoolean(PREFS_KEY_IS_MATERIAL_MUTE, z).apply();
        AppMethodBeat.m2505o(84214);
    }

    public static int getDowngradeLevel() {
        AppMethodBeat.m2504i(84215);
        int i = getDefaultPrefs().getInt(PREFS_KEY_DOWNGRADE_LEVEL, -1);
        AppMethodBeat.m2505o(84215);
        return i;
    }

    public static void setDowngradeLevel(int i) {
        AppMethodBeat.m2504i(84216);
        getDefaultPrefs().edit().putInt(PREFS_KEY_DOWNGRADE_LEVEL, i).apply();
        AppMethodBeat.m2505o(84216);
    }

    public static void setUseHardWareDecoder(boolean z) {
        AppMethodBeat.m2504i(84217);
        getDefaultPrefs().edit().putBoolean(PREFS_KEY_USE_HARDWARE_DECODER, z).apply();
        AppMethodBeat.m2505o(84217);
    }

    public static boolean getUseHardwareDecoder() {
        AppMethodBeat.m2504i(84218);
        boolean z = getDefaultPrefs().getBoolean(PREFS_KEY_USE_HARDWARE_DECODER, true);
        AppMethodBeat.m2505o(84218);
        return z;
    }

    public static int getNormalEncodeWidth() {
        AppMethodBeat.m2504i(84219);
        int i = getDefaultPrefs().getInt(PREFS_KEY_ENCODE_WIDTH, 720);
        AppMethodBeat.m2505o(84219);
        return i;
    }

    public static void setNormalEncodeWidth(int i) {
        AppMethodBeat.m2504i(84220);
        getDefaultPrefs().edit().putInt(PREFS_KEY_ENCODE_WIDTH, i).apply();
        AppMethodBeat.m2505o(84220);
    }
}
