package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AccessTokenSource {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true);
    
    private final boolean canExtendToken;

    static {
        AppMethodBeat.o(71571);
    }

    private AccessTokenSource(boolean z) {
        this.canExtendToken = z;
    }

    /* Access modifiers changed, original: final */
    public final boolean canExtendToken() {
        return this.canExtendToken;
    }
}
