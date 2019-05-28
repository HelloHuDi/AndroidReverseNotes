package com.tencent.map.lib;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MapLanguage {
    LAN_CHINESE,
    LAN_ENGLISH;

    static {
        AppMethodBeat.o(97840);
    }
}
