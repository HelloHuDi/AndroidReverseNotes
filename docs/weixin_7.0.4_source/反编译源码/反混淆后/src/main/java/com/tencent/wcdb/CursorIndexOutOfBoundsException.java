package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int i, int i2) {
        super("Index " + i + " requested, with a size of " + i2);
        AppMethodBeat.m2504i(11989);
        AppMethodBeat.m2505o(11989);
    }

    public CursorIndexOutOfBoundsException(String str) {
        super(str);
    }
}
