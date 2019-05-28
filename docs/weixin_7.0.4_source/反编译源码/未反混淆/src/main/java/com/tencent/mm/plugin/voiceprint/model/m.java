package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.File;

public final class m {
    public static String by(String str, boolean z) {
        AppMethodBeat.i(26113);
        String str2 = ac.eSj;
        ab.i("MicroMsg.VoicePrintLogic", "dbCachePath ".concat(String.valueOf(str2)));
        str2 = str2.endsWith(File.separator) ? str2 + str : str2 + File.separator + str;
        ab.i("MicroMsg.VoicePrintLogic", "genpath ".concat(String.valueOf(str2)));
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(26113);
            return null;
        } else if (z) {
            AppMethodBeat.o(26113);
            return str2;
        } else if (new File(str2).exists()) {
            AppMethodBeat.o(26113);
            return str2;
        } else {
            AppMethodBeat.o(26113);
            return str2;
        }
    }
}
