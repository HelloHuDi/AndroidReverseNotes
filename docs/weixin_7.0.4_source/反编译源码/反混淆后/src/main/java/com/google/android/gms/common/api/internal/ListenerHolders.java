package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

@KeepForSdk
public class ListenerHolders {
    private final Set<ListenerHolder<?>> zzlm = Collections.newSetFromMap(new WeakHashMap());

    public ListenerHolders() {
        AppMethodBeat.m2504i(60645);
        AppMethodBeat.m2505o(60645);
    }

    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(L l, Looper looper, String str) {
        AppMethodBeat.m2504i(60648);
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        ListenerHolder listenerHolder = new ListenerHolder(looper, l, str);
        AppMethodBeat.m2505o(60648);
        return listenerHolder;
    }

    @KeepForSdk
    public static <L> ListenerKey<L> createListenerKey(L l, String str) {
        AppMethodBeat.m2504i(60649);
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        ListenerKey listenerKey = new ListenerKey(l, str);
        AppMethodBeat.m2505o(60649);
        return listenerKey;
    }

    public final void release() {
        AppMethodBeat.m2504i(60647);
        for (ListenerHolder clear : this.zzlm) {
            clear.clear();
        }
        this.zzlm.clear();
        AppMethodBeat.m2505o(60647);
    }

    public final <L> ListenerHolder<L> zza(L l, Looper looper, String str) {
        AppMethodBeat.m2504i(60646);
        ListenerHolder createListenerHolder = createListenerHolder(l, looper, str);
        this.zzlm.add(createListenerHolder);
        AppMethodBeat.m2505o(60646);
        return createListenerHolder;
    }
}
