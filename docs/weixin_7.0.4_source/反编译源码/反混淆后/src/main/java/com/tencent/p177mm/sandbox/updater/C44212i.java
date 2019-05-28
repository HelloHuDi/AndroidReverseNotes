package com.tencent.p177mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p209c.C25999h;
import com.tencent.p177mm.pluginsdk.p1079f.C30035i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.sandbox.updater.i */
public final class C44212i {
    private static final long[] vdB = new long[]{0, 259200000, 604800000};

    /* renamed from: g */
    public static int m79790g(Context context, String str, String str2, String str3) {
        AppMethodBeat.m2504i(28912);
        int b = C25999h.m41491b(C30035i.m47537en(context), str, str2, str3);
        AppMethodBeat.m2505o(28912);
        return b;
    }

    /* renamed from: ap */
    public static void m79787ap(Context context, int i) {
        AppMethodBeat.m2504i(28913);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", false);
        intent.putExtra("intent_extra_opcode", i);
        context.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.m2505o(28913);
    }

    /* renamed from: aq */
    public static void m79788aq(Context context, int i) {
        AppMethodBeat.m2504i(28914);
        C44212i.m79789d(context, i, 0);
        AppMethodBeat.m2505o(28914);
    }

    /* renamed from: d */
    public static void m79789d(Context context, int i, int i2) {
        AppMethodBeat.m2504i(28915);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", true);
        intent.putExtra("intent_extra_opcode", i);
        if (i == 2) {
            intent.putExtra("intent_extra_install_dialog_times", i2);
        }
        context.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
        AppMethodBeat.m2505o(28915);
    }

    public static String dhU() {
        AppMethodBeat.m2504i(28916);
        String string = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).getString("update_downloaded_pack_md5_key", null);
        AppMethodBeat.m2505o(28916);
        return string;
    }

    public static String dns() {
        AppMethodBeat.m2504i(28917);
        String string = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).getString("update_downloaded_pack_sig_key", null);
        AppMethodBeat.m2505o(28917);
        return string;
    }

    public static String dnt() {
        AppMethodBeat.m2504i(28918);
        String string = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).getString("update_downloaded_pack_desc_key", null);
        AppMethodBeat.m2505o(28918);
        return string;
    }

    public static int dnu() {
        AppMethodBeat.m2504i(28919);
        int i = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).getInt("update_downloaded_pack_download_mode", 0);
        AppMethodBeat.m2505o(28919);
        return i;
    }

    /* renamed from: a */
    public static void m79786a(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        AppMethodBeat.m2504i(28920);
        MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).edit().putString("update_downloaded_pack_md5_key", str).putString("update_downloaded_pack_sig_key", str2).putString("update_downloaded_pack_desc_key", str3).putInt("update_downloaded_pack_size_key", i).putInt("update_downloaded_pack_download_mode", i2).putInt("update_downloaded_pack_update_type", i3).putString("update_download_not_auto_download_range", str4).commit();
        C4990ab.m7417i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", str, Integer.valueOf(i), str4);
        AppMethodBeat.m2505o(28920);
    }

    public static int dnv() {
        AppMethodBeat.m2504i(28921);
        C4990ab.m7417i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", Integer.valueOf(MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).getInt("update_downloaded_cancel_times", 0)));
        AppMethodBeat.m2505o(28921);
        return MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).getInt("update_downloaded_cancel_times", 0);
    }

    public static void dnw() {
        int i = 0;
        AppMethodBeat.m2504i(28922);
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu());
        int i2 = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        C4990ab.m7417i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", Integer.valueOf(i2));
        if (i2 >= vdB.length - 1) {
            String dhU = C44212i.dhU();
            StringBuffer stringBuffer = null;
            if (!C5046bo.isNullOrNil(dhU)) {
                String[] dnx = C44212i.dnx();
                stringBuffer = new StringBuffer();
                stringBuffer.append(dhU);
                if (dnx != null) {
                    int length = dnx.length;
                    while (i < length) {
                        String str = dnx[i];
                        if (!C5046bo.isNullOrNil(str)) {
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
            AppMethodBeat.m2505o(28922);
            return;
        }
        sharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", i2 + 1).commit();
        AppMethodBeat.m2505o(28922);
    }

    public static boolean amc(String str) {
        AppMethodBeat.m2504i(28923);
        String[] dnx = C44212i.dnx();
        if (dnx != null) {
            for (String equals : dnx) {
                if (equals.equals(str)) {
                    AppMethodBeat.m2505o(28923);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(28923);
        return false;
    }

    private static String[] dnx() {
        AppMethodBeat.m2504i(28924);
        String string = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).getString("update_downloaded_ignored_pack", null);
        if (C5046bo.isNullOrNil(string)) {
            AppMethodBeat.m2505o(28924);
            return null;
        }
        String[] split = string.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.m2505o(28924);
        return split;
    }

    public static void dny() {
        AppMethodBeat.m2504i(28925);
        MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
        C4990ab.m7416i("MicroMsg.UpdateUtil", "putDowningInSilence");
        AppMethodBeat.m2505o(28925);
    }

    public static void dnz() {
        AppMethodBeat.m2504i(28926);
        MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).edit().putBoolean("update_download_start_one_immediate", true).commit();
        C4990ab.m7416i("MicroMsg.UpdateUtil", "putOneDownloadTask");
        AppMethodBeat.m2505o(28926);
    }

    public static void dnA() {
        AppMethodBeat.m2504i(28927);
        MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).edit().remove("update_downloading_in_silence").commit();
        C4990ab.m7416i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
        AppMethodBeat.m2505o(28927);
    }

    public static void dnB() {
        AppMethodBeat.m2504i(28928);
        MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_config_prefs", C1448h.m3078Mu()).edit().clear().commit();
        C4990ab.m7416i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
        AppMethodBeat.m2505o(28928);
    }

    /* renamed from: y */
    public static long m79791y(String str, long j, long j2) {
        AppMethodBeat.m2504i(28929);
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_flowstat_prefs", C1448h.m3078Mu());
        long j3 = sharedPreferences.getLong(str, 0);
        C4990ab.m7417i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", str, Long.valueOf(j), Long.valueOf(j2));
        C4990ab.m7417i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", str, Long.valueOf(j3));
        j3 += j + j2;
        sharedPreferences.edit().putLong(str, j3).commit();
        AppMethodBeat.m2505o(28929);
        return j3;
    }

    public static long amd(String str) {
        AppMethodBeat.m2504i(28930);
        C4990ab.m7417i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", str, Long.valueOf(MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_flowstat_prefs", C1448h.m3078Mu()).getLong(str, 0)));
        AppMethodBeat.m2505o(28930);
        return MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "update_flowstat_prefs", C1448h.m3078Mu()).getLong(str, 0);
    }
}
