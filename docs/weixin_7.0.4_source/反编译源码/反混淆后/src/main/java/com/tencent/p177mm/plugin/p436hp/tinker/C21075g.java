package com.tencent.p177mm.plugin.p436hp.tinker;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;

/* renamed from: com.tencent.mm.plugin.hp.tinker.g */
public final class C21075g {
    /* renamed from: el */
    public static void m32384el(Context context) {
        AppMethodBeat.m2504i(90668);
        C21075g.m32379O(context, C26373g.m41964Nu().getInt("TinkerCheckUpdateInterval", 12));
        AppMethodBeat.m2505o(90668);
    }

    /* renamed from: O */
    private static void m32379O(Context context, int i) {
        AppMethodBeat.m2504i(90669);
        if (i < 0) {
            C4990ab.m7416i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
            AppMethodBeat.m2505o(90669);
            return;
        }
        C4990ab.m7417i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", Integer.valueOf(i));
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", i).apply();
        AppMethodBeat.m2505o(90669);
    }

    /* renamed from: az */
    public static boolean m32383az(Context context, String str) {
        AppMethodBeat.m2504i(90666);
        String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
        C4990ab.m7417i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", string, str);
        if (C5047bp.dpL()) {
            AppMethodBeat.m2505o(90666);
            return false;
        } else if (C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(str) || !string.equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(90666);
            return false;
        } else {
            AppMethodBeat.m2505o(90666);
            return true;
        }
    }

    /* renamed from: aA */
    public static void m32381aA(Context context, String str) {
        AppMethodBeat.m2504i(90667);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", str).apply();
        AppMethodBeat.m2505o(90667);
    }

    /* renamed from: em */
    public static int m32385em(Context context) {
        AppMethodBeat.m2504i(90670);
        int i = context.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
        AppMethodBeat.m2505o(90670);
        return i;
    }

    /* renamed from: aB */
    public static void m32382aB(Context context, String str) {
        AppMethodBeat.m2504i(90671);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", str).apply();
        AppMethodBeat.m2505o(90671);
    }

    /* renamed from: P */
    public static void m32380P(Context context, int i) {
        AppMethodBeat.m2504i(90672);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", i).apply();
        AppMethodBeat.m2505o(90672);
    }
}
