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

        /* synthetic */ SerializationProxyV1(HashMap hashMap, C254801 c254801) {
            this(hashMap);
        }

        private SerializationProxyV1(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
            this.proxyEvents = hashMap;
        }

        private Object readResolve() {
            AppMethodBeat.m2504i(72010);
            PersistedEvents persistedEvents = new PersistedEvents(this.proxyEvents);
            AppMethodBeat.m2505o(72010);
            return persistedEvents;
        }
    }

    public PersistedEvents() {
        AppMethodBeat.m2504i(72011);
        AppMethodBeat.m2505o(72011);
    }

    public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
        AppMethodBeat.m2504i(72012);
        this.events.putAll(hashMap);
        AppMethodBeat.m2505o(72012);
    }

    public Set<AccessTokenAppIdPair> keySet() {
        AppMethodBeat.m2504i(72013);
        Set keySet = this.events.keySet();
        AppMethodBeat.m2505o(72013);
        return keySet;
    }

    public List<AppEvent> get(AccessTokenAppIdPair accessTokenAppIdPair) {
        AppMethodBeat.m2504i(72014);
        List list = (List) this.events.get(accessTokenAppIdPair);
        AppMethodBeat.m2505o(72014);
        return list;
    }

    public boolean containsKey(AccessTokenAppIdPair accessTokenAppIdPair) {
        AppMethodBeat.m2504i(72015);
        boolean containsKey = this.events.containsKey(accessTokenAppIdPair);
        AppMethodBeat.m2505o(72015);
        return containsKey;
    }

    public void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
        AppMethodBeat.m2504i(72016);
        if (this.events.containsKey(accessTokenAppIdPair)) {
            ((List) this.events.get(accessTokenAppIdPair)).addAll(list);
            AppMethodBeat.m2505o(72016);
            return;
        }
        this.events.put(accessTokenAppIdPair, list);
        AppMethodBeat.m2505o(72016);
    }

    private Object writeReplace() {
        AppMethodBeat.m2504i(72017);
        SerializationProxyV1 serializationProxyV1 = new SerializationProxyV1(this.events, null);
        AppMethodBeat.m2505o(72017);
        return serializationProxyV1;
    }
}
