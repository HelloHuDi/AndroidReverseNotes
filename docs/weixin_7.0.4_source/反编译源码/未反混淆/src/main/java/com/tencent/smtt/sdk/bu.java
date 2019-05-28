package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

final class bu extends Thread {
    bu() {
    }

    public final void run() {
        AppMethodBeat.i(64839);
        if (WebView.j == null) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
            AppMethodBeat.o(64839);
            return;
        }
        o a = o.a(true);
        if (o.a) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            AppMethodBeat.o(64839);
            return;
        }
        ai a2 = ai.a(WebView.j);
        int c = a2.c();
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = ".concat(String.valueOf(c)));
        if (c == 2) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            a.a(String.valueOf(a2.b()));
            a.b(true);
            AppMethodBeat.o(64839);
            return;
        }
        int b = a2.b("copy_status");
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = ".concat(String.valueOf(b)));
        if (b == 1) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            a.a(String.valueOf(a2.c("copy_core_ver")));
            a.b(true);
            AppMethodBeat.o(64839);
            return;
        }
        if (!bv.a().b() && (c == 3 || b == 3)) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
            a.a(String.valueOf(o.d()));
            a.b(true);
        }
        AppMethodBeat.o(64839);
    }
}
