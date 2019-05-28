package com.tencent.p177mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.b */
public enum C38444b {
    AUTO(0),
    MIC(1),
    CAMCORDER(5),
    VOICE_RECOGNITION(6),
    VOICE_COMMUNICATION(7),
    UNPROCESSED(9);
    
    public int ilf;

    static {
        AppMethodBeat.m2505o(117483);
    }

    private C38444b(int i) {
        this.ilf = i;
    }

    /* renamed from: a */
    public static C38444b m65041a(String str, C38444b c38444b) {
        AppMethodBeat.m2504i(117482);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(117482);
            return c38444b;
        }
        C38444b valueOf = C38444b.valueOf(str);
        if (valueOf != null) {
            AppMethodBeat.m2505o(117482);
            return valueOf;
        }
        AppMethodBeat.m2505o(117482);
        return c38444b;
    }
}
