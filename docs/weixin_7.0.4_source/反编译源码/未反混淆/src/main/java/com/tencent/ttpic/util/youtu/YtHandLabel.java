package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YtHandLabel {
    private static final int LOST_TIME_INTERVAL = 300;
    private static final String TAG = YtHandLabel.class.getSimpleName();
    public long lostStartTimestamp;
    public String name = "";
    public int value = -1;

    static {
        AppMethodBeat.i(84417);
        AppMethodBeat.o(84417);
    }

    public boolean isConsiderLost() {
        AppMethodBeat.i(84416);
        if (System.currentTimeMillis() - this.lostStartTimestamp > 300) {
            AppMethodBeat.o(84416);
            return true;
        }
        AppMethodBeat.o(84416);
        return false;
    }

    public void reset() {
        this.value = -1;
        this.name = "";
    }
}
