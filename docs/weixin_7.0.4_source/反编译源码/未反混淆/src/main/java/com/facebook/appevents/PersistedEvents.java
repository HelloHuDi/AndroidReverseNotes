package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class PersistedEvents implements Serializable {
    private static final long serialVersionUID = 20160629001L;
    private HashMap<AccessTokenAppIdPair, List<AppEvent>> events = new HashMap();

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 20160629001L;
        private final HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents;

        /* synthetic */ SerializationProxyV1(HashMap hashMap, AnonymousClass1 anonymousClass1) {
            this(hashMap);
        }

        private SerializationProxyV1(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
            this.proxyEvents = hashMap;
        }

        private Object readResolve() {
            AppMethodBeat.i(72010);
            PersistedEvents persistedEvents = new PersistedEvents(this.proxyEvents);
            AppMethodBeat.o(72010);
            return persistedEvents;
        }
    }

    public PersistedEvents() {
        AppMethodBeat.i(72011);
        AppMethodBeat.o(72011);
    }

    public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
        AppMethodBeat.i(72012);
        this.events.putAll(hashMap);
        AppMethodBeat.o(72012);
    }

    public Set<AccessTokenAppIdPair> keySet() {
        AppMethodBeat.i(72013);
        Set keySet = this.events.keySet();
        AppMethodBeat.o(72013);
        return keySet;
    }

    public List<AppEvent> get(AccessTokenAppIdPair accessTokenAppIdPair) {
        AppMethodBeat.i(72014);
        List list = (List) this.events.get(accessTokenAppIdPair);
        AppMethodBeat.o(72014);
        return list;
    }

    public boolean containsKey(AccessTokenAppIdPair accessTokenAppIdPair) {
        AppMethodBeat.i(72015);
        boolean containsKey = this.events.containsKey(accessTokenAppIdPair);
        AppMethodBeat.o(72015);
        return containsKey;
    }

    public void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
        AppMethodBeat.i(72016);
        if (this.events.containsKey(accessTokenAppIdPair)) {
            ((List) this.events.get(accessTokenAppIdPair)).addAll(list);
            AppMethodBeat.o(72016);
            return;
        }
        this.events.put(accessTokenAppIdPair, list);
        AppMethodBeat.o(72016);
    }

    private Object writeReplace() {
        AppMethodBeat.i(72017);
        SerializationProxyV1 serializationProxyV1 = new SerializationProxyV1(this.events, null);
        AppMethodBeat.o(72017);
        return serializationProxyV1;
    }
}
