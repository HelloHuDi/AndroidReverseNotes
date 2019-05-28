package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;

public final class g {
    public static void el(Context context) {
        AppMethodBeat.i(90668);
        O(context, com.tencent.mm.m.g.Nu().getInt("TinkerCheckUpdateInterval", 12));
        AppMethodBeat.o(90668);
    }

    private static void O(Context context, int i) {
        AppMethodBeat.i(90669);
        if (i < 0) {
            ab.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
            AppMethodBeat.o(90669);
            return;
        }
        ab.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", Integer.valueOf(i));
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", i).apply();
        AppMethodBeat.o(90669);
    }

    public static boolean az(Context context, String str) {
        AppMethodBeat.i(90666);
        String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
        ab.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", string, str);
        if (bp.dpL()) {
            AppMethodBeat.o(90666);
            return false;
        } else if (bo.isNullOrNil(string) || bo.isNullOrNil(str) || !string.equalsIgnoreCase(str)) {
            AppMethodBeat.o(90666);
            return false;
        } else {
            AppMethodBeat.o(90666);
            return true;
        }
    }

    public static void aA(Context context, String str) {
        AppMethodBeat.i(90667);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", str).apply();
        AppMethodBeat.o(90667);
    }

    public static int em(Context context) {
        AppMethodBeat.i(90670);
        int i = context.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
        AppMethodBeat.o(90670);
        return i;
    }

    public static void aB(Context context, String str) {
        AppMethodBeat.i(90671);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", str).apply();
        AppMethodBeat.o(90671);
    }

    public static void P(Context context, int i) {
        AppMethodBeat.i(90672);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", i).apply();
        AppMethodBeat.o(90672);
    }
}
