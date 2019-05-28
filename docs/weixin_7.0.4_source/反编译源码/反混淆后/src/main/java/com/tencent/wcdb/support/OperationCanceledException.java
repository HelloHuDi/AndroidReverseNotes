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
        AppMethodBeat.m2504i(12735);
        AppMethodBeat.m2505o(12735);
    }
}
