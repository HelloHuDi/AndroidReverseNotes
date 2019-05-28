package com.tencent.mm.plugin.downloader.h;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    public static void a(long j, float f, int i) {
        AppMethodBeat.i(2528);
        ab.d("MicroMsg.FileDownloadSP", "speed = ".concat(String.valueOf(f)));
        String str = Math.round(100.0f * f) + "_" + i;
        ab.d("MicroMsg.FileDownloadSP", "speedStr = ".concat(String.valueOf(str)));
        l(j, str);
        AppMethodBeat.o(2528);
    }

    private static void l(long j, String str) {
        AppMethodBeat.i(2529);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("download_pref", 0);
        if (sharedPreferences == null) {
            AppMethodBeat.o(2529);
            return;
        }
        Object obj;
        String string = sharedPreferences.getString(String.valueOf(j), "");
        if (bo.isNullOrNil(string)) {
            obj = "1_" + str + "|";
        } else {
            String[] split = string.split("\\|");
            obj = string + (bo.getInt(split[split.length - 1].split("_")[0], 0) + 1) + "_" + str + "|";
        }
        ab.d("MicroMsg.FileDownloadSP", "saveDownloadSpeed, speedStr = ".concat(String.valueOf(obj)));
        sharedPreferences.edit().putString(String.valueOf(j), obj).apply();
        AppMethodBeat.o(2529);
    }
}
