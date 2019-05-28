package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShareStoryFeature implements DialogFeature {
    SHARE_STORY_ASSET(NativeProtocol.PROTOCOL_VERSION_20170417);
    
    private int minVersion;

    static {
        AppMethodBeat.m2505o(97310);
    }

    private ShareStoryFeature(int i) {
        this.minVersion = i;
    }

    public final String getAction() {
        return NativeProtocol.ACTION_SHARE_STORY;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
