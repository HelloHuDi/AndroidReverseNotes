package com.tencent.p177mm.plugin.sight.encode.p1022a;

import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sight.encode.a.a */
public interface C34922a {

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.a$a */
    public enum C21852a {
        WaitStart,
        Start,
        PrepareStop,
        WaitStop,
        Stop,
        WaitSend,
        Sent,
        Error,
        Initialized,
        Pause;

        static {
            AppMethodBeat.m2505o(25033);
        }
    }

    /* renamed from: Cw */
    boolean mo55517Cw();

    C21852a clA();

    PreviewCallback clB();

    long clz();

    int getDuration();

    String getRecordPath();
}
