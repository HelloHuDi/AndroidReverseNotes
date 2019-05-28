package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum CameraEffectFeature implements DialogFeature {
    SHARE_CAMERA_EFFECT(NativeProtocol.PROTOCOL_VERSION_20170417);
    
    private int minVersion;

    static {
        AppMethodBeat.o(96943);
    }

    private CameraEffectFeature(int i) {
        this.minVersion = i;
    }

    public final String getAction() {
        return NativeProtocol.ACTION_CAMERA_EFFECT;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
