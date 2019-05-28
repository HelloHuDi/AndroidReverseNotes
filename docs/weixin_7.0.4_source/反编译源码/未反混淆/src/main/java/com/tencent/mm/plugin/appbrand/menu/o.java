package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o {
    CopyPath,
    BackToHome,
    ShareAppMsg,
    ShareToTimeLine,
    EnableDebug,
    ShowPkgInfo,
    EnablePerformancePanel,
    OpenGamePreload,
    Exit,
    StickInWeChat,
    SendToDesktop,
    ModfiyCollection,
    AboutUs,
    AppId,
    DebugRestart,
    DumpPerformanceTrace,
    SendRed,
    ReceiveRed;

    static {
        AppMethodBeat.o(102142);
    }
}
