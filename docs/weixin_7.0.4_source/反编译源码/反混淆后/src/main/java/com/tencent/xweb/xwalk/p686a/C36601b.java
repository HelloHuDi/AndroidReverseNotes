package com.tencent.xweb.xwalk.p686a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C6037d;
import java.io.File;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.xwalk.a.b */
public final class C36601b extends C24550c {
    public final String dVM() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO;
    }

    /* renamed from: aM */
    public final String mo13331aM(int i, boolean z) {
        AppMethodBeat.m2504i(4176);
        String SE = mo41308SE(i);
        if (SE == null || SE.isEmpty()) {
            SE = "";
            AppMethodBeat.m2505o(4176);
            return SE;
        } else if (z) {
            SE = SE + File.separator + "patch";
            AppMethodBeat.m2505o(4176);
            return SE;
        } else {
            SE = SE + File.separator + "xweb_fullscreen_video.js";
            AppMethodBeat.m2505o(4176);
            return SE;
        }
    }

    public final boolean dVN() {
        return true;
    }

    public final boolean dVO() {
        return true;
    }

    /* renamed from: a */
    public final int mo13330a(C6051d c6051d) {
        AppMethodBeat.m2504i(4177);
        if (C6037d.m9502gA(c6051d.path, c6051d.cvZ)) {
            mo41307SD(c6051d.version);
            AppMethodBeat.m2505o(4177);
            return 0;
        }
        File file = new File(c6051d.path);
        if (file.exists()) {
            file.delete();
        }
        C24532f.dVt();
        AppMethodBeat.m2505o(4177);
        return -1;
    }
}
