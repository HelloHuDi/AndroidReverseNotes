package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzas implements ChannelListener {
    private final ChannelCallback zzch;

    public zzas(ChannelCallback channelCallback) {
        this.zzch = channelCallback;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(71034);
        if (this == obj) {
            AppMethodBeat.o(71034);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(71034);
            return false;
        } else {
            boolean equals = this.zzch.equals(((zzas) obj).zzch);
            AppMethodBeat.o(71034);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(71035);
        int hashCode = this.zzch.hashCode();
        AppMethodBeat.o(71035);
        return hashCode;
    }

    public final void onChannelClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(71031);
        this.zzch.onChannelClosed(zzao.zzb(channel), i, i2);
        AppMethodBeat.o(71031);
    }

    public final void onChannelOpened(Channel channel) {
        AppMethodBeat.i(71030);
        this.zzch.onChannelOpened(zzao.zzb(channel));
        AppMethodBeat.o(71030);
    }

    public final void onInputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(71032);
        this.zzch.onInputClosed(zzao.zzb(channel), i, i2);
        AppMethodBeat.o(71032);
    }

    public final void onOutputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(71033);
        this.zzch.onOutputClosed(zzao.zzb(channel), i, i2);
        AppMethodBeat.o(71033);
    }
}
