package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.h;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class i {
    private static final long[] vdB = new long[]{0, 259200000, 604800000};

    public static int g(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(28912);
        int b = h.b(com.tencent.mm.pluginsdk.f.i.en(context), str, str2, str3);
        AppMethodBeat.o(28912);
        return b;
    }

    public static void ap(Context context, int i) {
        AppMethodBeat.i(28913);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", false);
        intent.putExtra("intent_extra_opcode", i);
        context.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.o(28913);
    }

    public static void aq(Context context, int i) {
        AppMethodBeat.i(28914);
        d(context, i, 0);
        AppMethodBeat.o(28914);
    }

    public static void d(Context context, int i, int i2) {
        AppMethodBeat.i(28915);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", true);
        intent.putExtra("intent_extra_opcode", i);
        if (i == 2) {
            intent.putExtra("intent_extra_install_dialog_times", i2);
        }
        context.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.o(28915);
    }

    public static String dhU() {
        AppMethodBeat.i(28916);
        String string = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getString("update_downloaded_pack_md5_key", null);
        AppMethodBeat.o(28916);
        return string;
    }

    public static String dns() {
        AppMethodBeat.i(28917);
        String string = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getString("update_downloaded_pack_sig_key", null);
        AppMethodBeat.o(28917);
        return string;
    }

    public static String dnt() {
        AppMethodBeat.i(28918);
        String string = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getString("update_downloaded_pack_desc_key", null);
        AppMethodBeat.o(28918);
        return string;
    }

    public static int dnu() {
        AppMethodBeat.i(28919);
        int i = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getInt("update_downloaded_pack_download_mode", 0);
        AppMethodBeat.o(28919);
        return i;
    }

    public static void a(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        AppMethodBeat.i(28920);
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().putString("update_downloaded_pack_md5_key", str).putString("update_downloaded_pack_sig_key", str2).putString("update_downloaded_pack_desc_key", str3).putInt("update_downloaded_pack_size_key", i).putInt("update_downloaded_pack_download_mode", i2).putInt("update_downloaded_pack_update_type", i3).putString("update_download_not_auto_download_range", str4).commit();
        ab.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", str, Integer.valueOf(i), str4);
        AppMethodBeat.o(28920);
    }

    public static int dnv() {
        AppMethodBeat.i(28921);
        ab.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", Integer.valueOf(MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getInt("update_downloaded_cancel_times", 0)));
        AppMethodBeat.o(28921);
        return MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getInt("update_downloaded_cancel_times", 0);
    }

    public static void dnw() {
        int i = 0;
        AppMethodBeat.i(28922);
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu());
        int i2 = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        ab.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", Integer.valueOf(i2));
        if (i2 >= vdB.length - 1) {
            String dhU = dhU();
            StringBuffer stringBuffer = null;
            if (!bo.isNullOrNil(dhU)) {
                String[] dnx = dnx();
                stringBuffer = new StringBuffer();
                stringBuffer.append(dhU);
                if (dnx != null) {
                    int length = dnx.length;
                    while (i < length) {
                        String str = dnx[i];
                        if (!bo.isNullOrNil(str)) {
                            stringBuffer.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            stringBuffer.append(str);
                        }
                        i++;
                    }
                }
            }
            sharedPreferences.edit().clear().commit();
            if (stringBuffer != null) {
                sharedPreferences.edit().putString("update_downloaded_ignored_pack", stringBuffer.toString()).commit();
            }
            AppMethodBeat.o(28922);
            return;
        }
        sharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", i2 + 1).commit();
        AppMethodBeat.o(28922);
    }

    public static boolean amc(String str) {
        AppMethodBeat.i(28923);
        String[] dnx = dnx();
        if (dnx != null) {
            for (String equals : dnx) {
                if (equals.equals(str)) {
                    AppMethodBeat.o(28923);
                    return true;
                }
            }
        }
        AppMethodBeat.o(28923);
        return false;
    }

    private static String[] dnx() {
        AppMethodBeat.i(28924);
        String string = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getString("update_downloaded_ignored_pack", null);
        if (bo.isNullOrNil(string)) {
            AppMethodBeat.o(28924);
            return null;
        }
        String[] split = string.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.o(28924);
        return split;
    }

    public static void dny() {
        AppMethodBeat.i(28925);
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
        ab.i("MicroMsg.UpdateUtil", "putDowningInSilence");
        AppMethodBeat.o(28925);
    }

    public static void dnz() {
        AppMethodBeat.i(28926);
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().putBoolean("update_download_start_one_immediate", true).commit();
        ab.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
        AppMethodBeat.o(28926);
    }

    public static void dnA() {
        AppMethodBeat.i(28927);
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().remove("update_downloading_in_silence").commit();
        ab.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
        AppMethodBeat.o(28927);
    }

    public static void dnB() {
        AppMethodBeat.i(28928);
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().clear().commit();
        ab.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
        AppMethodBeat.o(28928);
    }

    public static long y(String str, long j, long j2) {
        AppMethodBeat.i(28929);
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.h.Mu());
        long j3 = sharedPreferences.getLong(str, 0);
        ab.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", str, Long.valueOf(j), Long.valueOf(j2));
        ab.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", str, Long.valueOf(j3));
        j3 += j + j2;
        sharedPreferences.edit().putLong(str, j3).commit();
        AppMethodBeat.o(28929);
        return j3;
    }

    public static long amd(String str) {
        AppMethodBeat.i(28930);
        ab.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", str, Long.valueOf(MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.h.Mu()).getLong(str, 0)));
        AppMethodBeat.o(28930);
        return MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.h.Mu()).getLong(str, 0);
    }
}
