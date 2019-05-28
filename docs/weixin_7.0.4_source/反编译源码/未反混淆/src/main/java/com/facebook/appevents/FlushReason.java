package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

enum FlushReason {
    EXPLICIT,
    TIMER,
    SESSION_CHANGE,
    PERSISTED_EVENTS,
    EVENT_THRESHOLD,
    EAGER_FLUSHING_EVENT;

    static {
        AppMethodBeat.o(72006);
    }
}
