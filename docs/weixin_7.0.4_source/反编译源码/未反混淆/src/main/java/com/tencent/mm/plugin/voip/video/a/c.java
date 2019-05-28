package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

public class c {
    public static boolean loadLibSuccessed = false;

    static {
        AppMethodBeat.i(5135);
        checkLibraryInit();
        AppMethodBeat.o(5135);
    }

    public static void checkLibraryInit() {
        AppMethodBeat.i(5134);
        System.currentTimeMillis();
        if (!loadLibSuccessed) {
            try {
                k.a("image_filter_common", c.class.getClassLoader());
                k.a("image_filter_gpu", c.class.getClassLoader());
                k.a("format_convert", c.class.getClassLoader());
                k.a("YTCommon", c.class.getClassLoader());
                loadLibSuccessed = true;
                AppMethodBeat.o(5134);
                return;
            } catch (UnsatisfiedLinkError e) {
                loadLibSuccessed = false;
                AppMethodBeat.o(5134);
                return;
            } catch (RuntimeException e2) {
                loadLibSuccessed = false;
                AppMethodBeat.o(5134);
                return;
            } catch (Exception e3) {
                loadLibSuccessed = false;
            }
        }
        AppMethodBeat.o(5134);
    }
}
