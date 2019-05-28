package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.SelectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc implements VersionPolicy {
    zzc() {
    }

    public final SelectionResult selectModule(Context context, String str, IVersions iVersions) {
        AppMethodBeat.m2504i(90451);
        SelectionResult selectionResult = new SelectionResult();
        selectionResult.localVersion = iVersions.getLocalVersion(context, str);
        if (selectionResult.localVersion != 0) {
            selectionResult.selection = -1;
        } else {
            selectionResult.remoteVersion = iVersions.getRemoteVersion(context, str, true);
            if (selectionResult.remoteVersion != 0) {
                selectionResult.selection = 1;
            }
        }
        AppMethodBeat.m2505o(90451);
        return selectionResult;
    }
}
