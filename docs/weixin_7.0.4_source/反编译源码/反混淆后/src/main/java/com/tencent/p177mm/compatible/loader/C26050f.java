package com.tencent.p177mm.compatible.loader;

import android.app.Application;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.compatible.loader.f */
public final class C26050f {

    /* renamed from: com.tencent.mm.compatible.loader.f$1 */
    public class C260511 extends C5039bj<String> {
        public C260511() {
            super(FaceGestureDetGLThread.BRIGHTNESS_DURATION, null, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.m2504i(93037);
            String Mh = C260511.m41594Mh();
            AppMethodBeat.m2505o(93037);
            return Mh;
        }

        /* renamed from: Mh */
        private static String m41594Mh() {
            AppMethodBeat.m2504i(93036);
            while (true) {
                String aw = C5046bo.m7524aw(C4996ah.getContext(), Process.myPid());
                if (aw == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        C4990ab.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
                    }
                } else {
                    AppMethodBeat.m2505o(93036);
                    return aw;
                }
            }
        }
    }

    /* renamed from: c */
    public static C1439e m41593c(Application application, String str) {
        AppMethodBeat.m2504i(93038);
        try {
            C1439e c1439e = (C1439e) C4996ah.getContext().getClassLoader().loadClass(C4996ah.doz() + str).newInstance();
            c1439e.mo4894b(application);
            AppMethodBeat.m2505o(93038);
            return c1439e;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
            AppMethodBeat.m2505o(93038);
            return null;
        }
    }
}
