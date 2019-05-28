package com.jg;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum EType {
    ALL,
    ACTIVITYCHECK,
    PROVIDERCHECK,
    RECEIVERCHECK,
    SERVICESCHECK,
    PERMISSIONCHECK,
    INTENTCHECK,
    SECURERANDOMCHECK,
    JSEXECUTECHECK,
    HTTPSCHECK;

    static {
        AppMethodBeat.o(35503);
    }
}
