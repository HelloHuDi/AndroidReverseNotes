package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.util.b;
import com.tinkerboots.sdk.b.d;
import com.tinkerboots.sdk.tinker.a.a;
import java.io.File;

public class TinkerServerResultService extends DefaultTinkerResultService {
    private static boolean AUd = false;
    private static a AUe = null;

    public final void a(com.tencent.tinker.lib.service.a aVar) {
        AppMethodBeat.i(65550);
        if (aVar == null) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
            AppMethodBeat.o(65550);
            return;
        }
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerServerResultService", "receive result: %s", aVar.toString());
        b.iY(getApplicationContext());
        if (aVar.cxT) {
            com.tencent.tinker.lib.util.a.i("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
            DefaultTinkerResultService.aj(new File(aVar.ABv));
            if (!b(aVar)) {
                com.tencent.tinker.lib.util.a.i("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
                AppMethodBeat.o(65550);
                return;
            } else if (AUd) {
                com.tencent.tinker.lib.util.a.i("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
                d.b bVar = new d.b(getApplicationContext(), new d.a() {
                    public final void awE() {
                        AppMethodBeat.i(65549);
                        TinkerServerResultService.restartProcess();
                        AppMethodBeat.o(65549);
                    }
                });
                AppMethodBeat.o(65550);
                return;
            }
        }
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
        AppMethodBeat.o(65550);
    }

    static void restartProcess() {
        AppMethodBeat.i(65551);
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(65551);
    }
}
