package com.tencent.p177mm.plugin.downloader.p943h;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.downloader.h.b */
public final class C11509b {
    /* renamed from: a */
    public static void m19313a(long j, float f, int i) {
        AppMethodBeat.m2504i(2528);
        C4990ab.m7410d("MicroMsg.FileDownloadSP", "speed = ".concat(String.valueOf(f)));
        String str = Math.round(100.0f * f) + "_" + i;
        C4990ab.m7410d("MicroMsg.FileDownloadSP", "speedStr = ".concat(String.valueOf(str)));
        C11509b.m19314l(j, str);
        AppMethodBeat.m2505o(2528);
    }

    /* renamed from: l */
    private static void m19314l(long j, String str) {
        AppMethodBeat.m2504i(2529);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("download_pref", 0);
        if (sharedPreferences == null) {
            AppMethodBeat.m2505o(2529);
            return;
        }
        Object obj;
        String string = sharedPreferences.getString(String.valueOf(j), "");
        if (C5046bo.isNullOrNil(string)) {
            obj = "1_" + str + "|";
        } else {
            String[] split = string.split("\\|");
            obj = string + (C5046bo.getInt(split[split.length - 1].split("_")[0], 0) + 1) + "_" + str + "|";
        }
        C4990ab.m7410d("MicroMsg.FileDownloadSP", "saveDownloadSpeed, speedStr = ".concat(String.valueOf(obj)));
        sharedPreferences.edit().putString(String.valueOf(j), obj).apply();
        AppMethodBeat.m2505o(2529);
    }
}
