package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.SelectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg implements VersionPolicy {
    zzg() {
    }

    public final SelectionResult selectModule(Context context, String str, IVersions iVersions) {
        AppMethodBeat.i(90455);
        SelectionResult selectionResult = new SelectionResult();
        selectionResult.localVersion = iVersions.getLocalVersion(context, str);
        if (selectionResult.localVersion != 0) {
            selectionResult.remoteVersion = iVersions.getRemoteVersion(context, str, false);
        } else {
            selectionResult.remoteVersion = iVersions.getRemoteVersion(context, str, true);
        }
        if (selectionResult.localVersion == 0 && selectionResult.remoteVersion == 0) {
            selectionResult.selection = 0;
        } else if (selectionResult.remoteVersion >= selectionResult.localVersion) {
            selectionResult.selection = 1;
        } else {
            selectionResult.selection = -1;
        }
        AppMethodBeat.o(90455);
        return selectionResult;
    }
}
