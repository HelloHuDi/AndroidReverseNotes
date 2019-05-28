package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.ui.MMActivity;

public interface b {
    void a(ProcessResult processResult);

    MMActivity aBQ();

    boolean aBR();

    void b(ProcessResult processResult);

    void runOnUiThread(Runnable runnable);
}
