package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OpenGraphActionDialogFeature implements DialogFeature {
    OG_ACTION_DIALOG(NativeProtocol.PROTOCOL_VERSION_20130618);
    
    private int minVersion;

    static {
        AppMethodBeat.o(97161);
    }

    private OpenGraphActionDialogFeature(int i) {
        this.minVersion = i;
    }

    public final String getAction() {
        return NativeProtocol.ACTION_OGACTIONPUBLISH_DIALOG;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
