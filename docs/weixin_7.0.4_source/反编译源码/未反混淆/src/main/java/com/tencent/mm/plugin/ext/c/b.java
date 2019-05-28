package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {

    public enum b {
        BLACK,
        WHITE,
        NONE;

        static {
            AppMethodBeat.o(20394);
        }
    }

    enum a {
        PREFIX,
        SUBDOMAIN,
        DOMAIN;

        static {
            AppMethodBeat.o(20391);
        }
    }
}
