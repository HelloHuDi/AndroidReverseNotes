package com.tencent.p177mm.plugin.voip.video.p1045a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;

/* renamed from: com.tencent.mm.plugin.voip.video.a.c */
public class C22469c {
    public static boolean loadLibSuccessed = false;

    static {
        AppMethodBeat.m2504i(5135);
        C22469c.checkLibraryInit();
        AppMethodBeat.m2505o(5135);
    }

    public static void checkLibraryInit() {
        AppMethodBeat.m2504i(5134);
        System.currentTimeMillis();
        if (!loadLibSuccessed) {
            try {
                C1449k.m3079a("image_filter_common", C22469c.class.getClassLoader());
                C1449k.m3079a("image_filter_gpu", C22469c.class.getClassLoader());
                C1449k.m3079a("format_convert", C22469c.class.getClassLoader());
                C1449k.m3079a("YTCommon", C22469c.class.getClassLoader());
                loadLibSuccessed = true;
                AppMethodBeat.m2505o(5134);
                return;
            } catch (UnsatisfiedLinkError e) {
                loadLibSuccessed = false;
                AppMethodBeat.m2505o(5134);
                return;
            } catch (RuntimeException e2) {
                loadLibSuccessed = false;
                AppMethodBeat.m2505o(5134);
                return;
            } catch (Exception e3) {
                loadLibSuccessed = false;
            }
        }
        AppMethodBeat.m2505o(5134);
    }
}
