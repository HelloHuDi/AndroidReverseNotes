package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.m */
public final class C22449m {
    /* renamed from: by */
    public static String m34137by(String str, boolean z) {
        AppMethodBeat.m2504i(26113);
        String str2 = C5128ac.eSj;
        C4990ab.m7416i("MicroMsg.VoicePrintLogic", "dbCachePath ".concat(String.valueOf(str2)));
        str2 = str2.endsWith(File.separator) ? str2 + str : str2 + File.separator + str;
        C4990ab.m7416i("MicroMsg.VoicePrintLogic", "genpath ".concat(String.valueOf(str2)));
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(26113);
            return null;
        } else if (z) {
            AppMethodBeat.m2505o(26113);
            return str2;
        } else if (new File(str2).exists()) {
            AppMethodBeat.m2505o(26113);
            return str2;
        } else {
            AppMethodBeat.m2505o(26113);
            return str2;
        }
    }
}
