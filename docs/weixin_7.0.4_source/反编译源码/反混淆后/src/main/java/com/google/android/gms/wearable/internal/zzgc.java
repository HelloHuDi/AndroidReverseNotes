package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgc implements ChannelListener {
    private final String zzce;
    private final ChannelListener zzeq;

    zzgc(String str, ChannelListener channelListener) {
        AppMethodBeat.m2504i(71354);
        this.zzce = (String) Preconditions.checkNotNull(str);
        this.zzeq = (ChannelListener) Preconditions.checkNotNull(channelListener);
        AppMethodBeat.m2505o(71354);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(71359);
        if (this == obj) {
            AppMethodBeat.m2505o(71359);
            return true;
        } else if (obj instanceof zzgc) {
            zzgc zzgc = (zzgc) obj;
            if (this.zzeq.equals(zzgc.zzeq) && this.zzce.equals(zzgc.zzce)) {
                AppMethodBeat.m2505o(71359);
                return true;
            }
            AppMethodBeat.m2505o(71359);
            return false;
        } else {
            AppMethodBeat.m2505o(71359);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(71360);
        int hashCode = (this.zzce.hashCode() * 31) + this.zzeq.hashCode();
        AppMethodBeat.m2505o(71360);
        return hashCode;
    }

    public final void onChannelClosed(Channel channel, int i, int i2) {
        AppMethodBeat.m2504i(71356);
        this.zzeq.onChannelClosed(channel, i, i2);
        AppMethodBeat.m2505o(71356);
    }

    public final void onChannelOpened(Channel channel) {
        AppMethodBeat.m2504i(71355);
        this.zzeq.onChannelOpened(channel);
        AppMethodBeat.m2505o(71355);
    }

    public final void onInputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.m2504i(71357);
        this.zzeq.onInputClosed(channel, i, i2);
        AppMethodBeat.m2505o(71357);
    }

    public final void onOutputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.m2504i(71358);
        this.zzeq.onOutputClosed(channel, i, i2);
        AppMethodBeat.m2505o(71358);
    }
}
