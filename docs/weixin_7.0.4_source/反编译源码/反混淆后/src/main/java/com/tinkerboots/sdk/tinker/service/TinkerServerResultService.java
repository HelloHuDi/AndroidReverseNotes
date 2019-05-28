package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.service.C46819a;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.util.C31098b;
import com.tencent.tinker.lib.util.C5952a;
import com.tinkerboots.sdk.p1355b.C44601d.C24574a;
import com.tinkerboots.sdk.p1355b.C44601d.C24576b;
import com.tinkerboots.sdk.tinker.p1429a.C31175a;
import java.io.File;

public class TinkerServerResultService extends DefaultTinkerResultService {
    private static boolean AUd = false;
    private static C31175a AUe = null;

    /* renamed from: com.tinkerboots.sdk.tinker.service.TinkerServerResultService$1 */
    class C446031 implements C24574a {
        C446031() {
        }

        public final void awE() {
            AppMethodBeat.m2504i(65549);
            TinkerServerResultService.restartProcess();
            AppMethodBeat.m2505o(65549);
        }
    }

    /* renamed from: a */
    public final void mo33931a(C46819a c46819a) {
        AppMethodBeat.m2504i(65550);
        if (c46819a == null) {
            C5952a.m9283e("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
            AppMethodBeat.m2505o(65550);
            return;
        }
        C5952a.m9284i("Tinker.TinkerServerResultService", "receive result: %s", c46819a.toString());
        C31098b.m50186iY(getApplicationContext());
        if (c46819a.cxT) {
            C5952a.m9284i("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
            DefaultTinkerResultService.m50182aj(new File(c46819a.ABv));
            if (!mo50552b(c46819a)) {
                C5952a.m9284i("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
                AppMethodBeat.m2505o(65550);
                return;
            } else if (AUd) {
                C5952a.m9284i("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
                C24576b c24576b = new C24576b(getApplicationContext(), new C446031());
                AppMethodBeat.m2505o(65550);
                return;
            }
        }
        C5952a.m9284i("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
        AppMethodBeat.m2505o(65550);
    }

    static void restartProcess() {
        AppMethodBeat.m2504i(65551);
        C5952a.m9284i("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
        Process.killProcess(Process.myPid());
        AppMethodBeat.m2505o(65551);
    }
}
