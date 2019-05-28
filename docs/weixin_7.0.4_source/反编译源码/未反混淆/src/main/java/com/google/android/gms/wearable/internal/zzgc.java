package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgc implements ChannelListener {
    private final String zzce;
    private final ChannelListener zzeq;

    zzgc(String str, ChannelListener channelListener) {
        AppMethodBeat.i(71354);
        this.zzce = (String) Preconditions.checkNotNull(str);
        this.zzeq = (ChannelListener) Preconditions.checkNotNull(channelListener);
        AppMethodBeat.o(71354);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(71359);
        if (this == obj) {
            AppMethodBeat.o(71359);
            return true;
        } else if (obj instanceof zzgc) {
            zzgc zzgc = (zzgc) obj;
            if (this.zzeq.equals(zzgc.zzeq) && this.zzce.equals(zzgc.zzce)) {
                AppMethodBeat.o(71359);
                return true;
            }
            AppMethodBeat.o(71359);
            return false;
        } else {
            AppMethodBeat.o(71359);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(71360);
        int hashCode = (this.zzce.hashCode() * 31) + this.zzeq.hashCode();
        AppMethodBeat.o(71360);
        return hashCode;
    }

    public final void onChannelClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(71356);
        this.zzeq.onChannelClosed(channel, i, i2);
        AppMethodBeat.o(71356);
    }

    public final void onChannelOpened(Channel channel) {
        AppMethodBeat.i(71355);
        this.zzeq.onChannelOpened(channel);
        AppMethodBeat.o(71355);
    }

    public final void onInputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(71357);
        this.zzeq.onInputClosed(channel, i, i2);
        AppMethodBeat.o(71357);
    }

    public final void onOutputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(71358);
        this.zzeq.onOutputClosed(channel, i, i2);
        AppMethodBeat.o(71358);
    }
}
