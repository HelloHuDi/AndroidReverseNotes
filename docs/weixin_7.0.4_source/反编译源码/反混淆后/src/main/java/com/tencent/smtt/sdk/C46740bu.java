package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.bu */
final class C46740bu extends Thread {
    C46740bu() {
    }

    public final void run() {
        AppMethodBeat.m2504i(64839);
        if (WebView.f13868j == null) {
            TbsLog.m80430d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
            AppMethodBeat.m2505o(64839);
            return;
        }
        C5818o a = C5818o.m8863a(true);
        if (C5818o.f1419a) {
            TbsLog.m80430d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            AppMethodBeat.m2505o(64839);
            return;
        }
        C36432ai a2 = C36432ai.m60088a(WebView.f13868j);
        int c = a2.mo57547c();
        TbsLog.m80430d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = ".concat(String.valueOf(c)));
        if (c == 2) {
            TbsLog.m80430d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            a.mo12197a(String.valueOf(a2.mo57543b()));
            a.mo12199b(true);
            AppMethodBeat.m2505o(64839);
            return;
        }
        int b = a2.mo57544b("copy_status");
        TbsLog.m80430d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = ".concat(String.valueOf(b)));
        if (b == 1) {
            TbsLog.m80430d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            a.mo12197a(String.valueOf(a2.mo57548c("copy_core_ver")));
            a.mo12199b(true);
            AppMethodBeat.m2505o(64839);
            return;
        }
        if (!C40978bv.m71073a().mo64921b() && (c == 3 || b == 3)) {
            TbsLog.m80430d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
            a.mo12197a(String.valueOf(C5818o.m8866d()));
            a.mo12199b(true);
        }
        AppMethodBeat.m2505o(64839);
    }
}
