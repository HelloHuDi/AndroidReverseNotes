package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public enum LikeDialogFeature implements DialogFeature {
    LIKE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140701);
    
    private int minVersion;

    static {
        AppMethodBeat.o(97121);
    }

    private LikeDialogFeature(int i) {
        this.minVersion = i;
    }

    public final String getAction() {
        return NativeProtocol.ACTION_LIKE_DIALOG;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
