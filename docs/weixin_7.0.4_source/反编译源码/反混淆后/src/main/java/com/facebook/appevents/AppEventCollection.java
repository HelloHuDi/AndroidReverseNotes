package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Set;

class AppEventCollection {
    private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap();

    public AppEventCollection() {
        AppMethodBeat.m2504i(71877);
        AppMethodBeat.m2505o(71877);
    }

    public synchronized void addPersistedEvents(PersistedEvents persistedEvents) {
        AppMethodBeat.m2504i(71878);
        if (persistedEvents == null) {
            AppMethodBeat.m2505o(71878);
        } else {
            for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
                SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
                for (AppEvent addEvent : persistedEvents.get(accessTokenAppIdPair)) {
                    sessionEventsState.addEvent(addEvent);
                }
            }
            AppMethodBeat.m2505o(71878);
        }
    }

    public synchronized void addEvent(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        AppMethodBeat.m2504i(71879);
        getSessionEventsState(accessTokenAppIdPair).addEvent(appEvent);
        AppMethodBeat.m2505o(71879);
    }

    public synchronized Set<AccessTokenAppIdPair> keySet() {
        Set keySet;
        AppMethodBeat.m2504i(71880);
        keySet = this.stateMap.keySet();
        AppMethodBeat.m2505o(71880);
        return keySet;
    }

    public synchronized SessionEventsState get(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        AppMethodBeat.m2504i(71881);
        sessionEventsState = (SessionEventsState) this.stateMap.get(accessTokenAppIdPair);
        AppMethodBeat.m2505o(71881);
        return sessionEventsState;
    }

    public synchronized int getEventCount() {
        int i;
        AppMethodBeat.m2504i(71882);
        i = 0;
        for (SessionEventsState accumulatedEventCount : this.stateMap.values()) {
            i = accumulatedEventCount.getAccumulatedEventCount() + i;
        }
        AppMethodBeat.m2505o(71882);
        return i;
    }

    private synchronized SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        Object obj;
        AppMethodBeat.m2504i(71883);
        obj = (SessionEventsState) this.stateMap.get(accessTokenAppIdPair);
        if (obj == null) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            obj = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers(applicationContext), AppEventsLogger.getAnonymousAppDeviceGUID(applicationContext));
        }
        this.stateMap.put(accessTokenAppIdPair, obj);
        AppMethodBeat.m2505o(71883);
        return obj;
    }
}
