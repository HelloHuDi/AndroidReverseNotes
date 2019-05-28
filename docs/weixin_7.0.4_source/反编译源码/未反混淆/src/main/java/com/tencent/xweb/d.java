package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static final String[] ALV = new String[]{"ppt", "pptx", "xls", "xlsx", "doc", "docx"};

    public enum a {
        NONE,
        XWEB,
        X5;

        static {
            AppMethodBeat.o(3807);
        }
    }
}
