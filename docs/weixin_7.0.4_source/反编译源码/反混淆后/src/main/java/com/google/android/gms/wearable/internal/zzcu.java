package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataClient.GetFdForAssetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

final class zzcu extends GetFdForAssetResponse implements Releasable {
    private final GetFdForAssetResult zzdj;

    zzcu(GetFdForAssetResult getFdForAssetResult) {
        this.zzdj = getFdForAssetResult;
    }

    public final ParcelFileDescriptor getFdForAsset() {
        AppMethodBeat.m2504i(71170);
        ParcelFileDescriptor fd = this.zzdj.getFd();
        AppMethodBeat.m2505o(71170);
        return fd;
    }

    public final InputStream getInputStream() {
        AppMethodBeat.m2504i(71171);
        InputStream inputStream = this.zzdj.getInputStream();
        AppMethodBeat.m2505o(71171);
        return inputStream;
    }

    public final void release() {
        AppMethodBeat.m2504i(71172);
        this.zzdj.release();
        AppMethodBeat.m2505o(71172);
    }
}
