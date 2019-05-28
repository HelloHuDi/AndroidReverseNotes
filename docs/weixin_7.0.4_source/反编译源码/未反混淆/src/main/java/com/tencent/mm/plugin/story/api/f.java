package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface f {

    public enum a {
        TimeLine_Des,
        TimeLine_Comment,
        TimeLine_Like;

        static {
            AppMethodBeat.o(56479);
        }
    }

    boolean a(a aVar);

    boolean cwU();
}
