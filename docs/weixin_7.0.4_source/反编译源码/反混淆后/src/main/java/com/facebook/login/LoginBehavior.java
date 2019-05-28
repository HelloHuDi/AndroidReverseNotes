package com.facebook.login;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
    NATIVE_ONLY(true, true, false, false, false, true),
    KATANA_ONLY(false, true, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false),
    DIALOG_ONLY(false, true, true, false, true, true),
    DEVICE_AUTH(false, false, false, true, false, false);
    
    private final boolean allowsCustomTabAuth;
    private final boolean allowsDeviceAuth;
    private final boolean allowsFacebookLiteAuth;
    private final boolean allowsGetTokenAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    static {
        AppMethodBeat.m2505o(96788);
    }

    private LoginBehavior(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.allowsGetTokenAuth = z;
        this.allowsKatanaAuth = z2;
        this.allowsWebViewAuth = z3;
        this.allowsDeviceAuth = z4;
        this.allowsCustomTabAuth = z5;
        this.allowsFacebookLiteAuth = z6;
    }

    /* Access modifiers changed, original: final */
    public final boolean allowsGetTokenAuth() {
        return this.allowsGetTokenAuth;
    }

    /* Access modifiers changed, original: final */
    public final boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    /* Access modifiers changed, original: final */
    public final boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }

    /* Access modifiers changed, original: final */
    public final boolean allowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }

    /* Access modifiers changed, original: final */
    public final boolean allowsCustomTabAuth() {
        return this.allowsCustomTabAuth;
    }

    /* Access modifiers changed, original: final */
    public final boolean allowsFacebookLiteAuth() {
        return this.allowsFacebookLiteAuth;
    }
}
