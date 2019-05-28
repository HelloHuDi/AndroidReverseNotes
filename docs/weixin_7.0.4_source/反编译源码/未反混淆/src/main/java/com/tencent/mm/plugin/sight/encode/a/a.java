package com.tencent.mm.plugin.sight.encode.a;

import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a {

    public enum a {
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
            AppMethodBeat.o(25033);
        }
    }

    boolean Cw();

    a clA();

    PreviewCallback clB();

    long clz();

    int getDuration();

    String getRecordPath();
}
