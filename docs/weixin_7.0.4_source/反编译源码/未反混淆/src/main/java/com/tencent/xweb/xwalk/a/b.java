package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.f;
import java.io.File;
import org.xwalk.core.XWalkEnvironment;

public final class b extends c {
    public final String dVM() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO;
    }

    public final String aM(int i, boolean z) {
        AppMethodBeat.i(4176);
        String SE = SE(i);
        if (SE == null || SE.isEmpty()) {
            SE = "";
            AppMethodBeat.o(4176);
            return SE;
        } else if (z) {
            SE = SE + File.separator + "patch";
            AppMethodBeat.o(4176);
            return SE;
        } else {
            SE = SE + File.separator + "xweb_fullscreen_video.js";
            AppMethodBeat.o(4176);
            return SE;
        }
    }

    public final boolean dVN() {
        return true;
    }

    public final boolean dVO() {
        return true;
    }

    public final int a(d dVar) {
        AppMethodBeat.i(4177);
        if (d.gA(dVar.path, dVar.cvZ)) {
            SD(dVar.version);
            AppMethodBeat.o(4177);
            return 0;
        }
        File file = new File(dVar.path);
        if (file.exists()) {
            file.delete();
        }
        f.dVt();
        AppMethodBeat.o(4177);
        return -1;
    }
}
