package com.tencent.qqmusic.mediaplayer.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;

public class ReferenceTimer {
    private static final String TAG = "ReferenceTimer";
    private AtomicLong mBaseTime = new AtomicLong();

    public ReferenceTimer() {
        AppMethodBeat.m2504i(128378);
        AppMethodBeat.m2505o(128378);
    }

    public void restart() {
        AppMethodBeat.m2504i(128379);
        this.mBaseTime.set(SystemClock.uptimeMillis());
        AppMethodBeat.m2505o(128379);
    }

    public long getTimeInMs() {
        AppMethodBeat.m2504i(128380);
        long uptimeMillis = SystemClock.uptimeMillis() - this.mBaseTime.get();
        AppMethodBeat.m2505o(128380);
        return uptimeMillis;
    }

    public void refreshTimeInMs(long j) {
        AppMethodBeat.m2504i(128381);
        this.mBaseTime.set(SystemClock.uptimeMillis());
        this.mBaseTime.addAndGet(-j);
        AppMethodBeat.m2505o(128381);
    }
}
