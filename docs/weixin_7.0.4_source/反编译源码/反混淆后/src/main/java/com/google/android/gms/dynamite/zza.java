package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza implements IVersions {
    zza() {
    }

    public final int getLocalVersion(Context context, String str) {
        AppMethodBeat.m2504i(90449);
        int localVersion = DynamiteModule.getLocalVersion(context, str);
        AppMethodBeat.m2505o(90449);
        return localVersion;
    }

    public final int getRemoteVersion(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(90448);
        int remoteVersion = DynamiteModule.getRemoteVersion(context, str, z);
        AppMethodBeat.m2505o(90448);
        return remoteVersion;
    }
}
