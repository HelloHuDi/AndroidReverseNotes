package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        if (str == null) {
            str = "The operation has been canceled.";
        }
        super(str);
        AppMethodBeat.i(12735);
        AppMethodBeat.o(12735);
    }
}
