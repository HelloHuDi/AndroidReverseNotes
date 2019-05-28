package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class zzgu extends zzgm<GetConnectedNodesResult> {
    public zzgu(ResultHolder<GetConnectedNodesResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzea zzea) {
        AppMethodBeat.m2504i(71384);
        ArrayList arrayList = new ArrayList();
        if (zzea.zzdx != null) {
            arrayList.addAll(zzea.zzdx);
        }
        zza(new zzfj(zzgd.zzb(zzea.statusCode), arrayList));
        AppMethodBeat.m2505o(71384);
    }
}
