package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class ListenerHolder<L> {
    private final zza zzlh;
    private volatile L zzli;
    private final ListenerKey<L> zzlj;

    @KeepForSdk
    public static final class ListenerKey<L> {
        private final L zzli;
        private final String zzll;

        @KeepForSdk
        ListenerKey(L l, String str) {
            this.zzli = l;
            this.zzll = str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(60639);
            if (this == obj) {
                AppMethodBeat.o(60639);
                return true;
            } else if (obj instanceof ListenerKey) {
                ListenerKey listenerKey = (ListenerKey) obj;
                if (this.zzli == listenerKey.zzli && this.zzll.equals(listenerKey.zzll)) {
                    AppMethodBeat.o(60639);
                    return true;
                }
                AppMethodBeat.o(60639);
                return false;
            } else {
                AppMethodBeat.o(60639);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(60640);
            int identityHashCode = (System.identityHashCode(this.zzli) * 31) + this.zzll.hashCode();
            AppMethodBeat.o(60640);
            return identityHashCode;
        }
    }

    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(L l);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(60641);
            if (message.what != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            ListenerHolder.this.notifyListenerInternal((Notifier) message.obj);
            AppMethodBeat.o(60641);
        }
    }

    @KeepForSdk
    ListenerHolder(Looper looper, L l, String str) {
        AppMethodBeat.i(60642);
        this.zzlh = new zza(looper);
        this.zzli = Preconditions.checkNotNull(l, "Listener must not be null");
        this.zzlj = new ListenerKey(l, Preconditions.checkNotEmpty(str));
        AppMethodBeat.o(60642);
    }

    @KeepForSdk
    public final void clear() {
        this.zzli = null;
    }

    @KeepForSdk
    public final ListenerKey<L> getListenerKey() {
        return this.zzlj;
    }

    @KeepForSdk
    public final boolean hasListener() {
        return this.zzli != null;
    }

    @KeepForSdk
    public final void notifyListener(Notifier<? super L> notifier) {
        AppMethodBeat.i(60643);
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zzlh.sendMessage(this.zzlh.obtainMessage(1, notifier));
        AppMethodBeat.o(60643);
    }

    /* Access modifiers changed, original: final */
    @KeepForSdk
    public final void notifyListenerInternal(Notifier<? super L> notifier) {
        AppMethodBeat.i(60644);
        Object obj = this.zzli;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            AppMethodBeat.o(60644);
            return;
        }
        try {
            notifier.notifyListener(obj);
            AppMethodBeat.o(60644);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            AppMethodBeat.o(60644);
            throw e;
        }
    }
}
