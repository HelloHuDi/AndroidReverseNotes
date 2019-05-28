package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SessionEventsState {
    private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
    private List<AppEvent> accumulatedEvents = new ArrayList();
    private String anonymousAppDeviceGUID;
    private AttributionIdentifiers attributionIdentifiers;
    private List<AppEvent> inFlightEvents = new ArrayList();
    private int numSkippedEventsDueToFullBuffer;

    public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String str) {
        AppMethodBeat.i(72018);
        this.attributionIdentifiers = attributionIdentifiers;
        this.anonymousAppDeviceGUID = str;
        AppMethodBeat.o(72018);
    }

    public synchronized void addEvent(AppEvent appEvent) {
        AppMethodBeat.i(72019);
        if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= 1000) {
            this.numSkippedEventsDueToFullBuffer++;
            AppMethodBeat.o(72019);
        } else {
            this.accumulatedEvents.add(appEvent);
            AppMethodBeat.o(72019);
        }
    }

    public synchronized int getAccumulatedEventCount() {
        int size;
        AppMethodBeat.i(72020);
        size = this.accumulatedEvents.size();
        AppMethodBeat.o(72020);
        return size;
    }

    public synchronized void clearInFlightAndStats(boolean z) {
        AppMethodBeat.i(72021);
        if (z) {
            this.accumulatedEvents.addAll(this.inFlightEvents);
        }
        this.inFlightEvents.clear();
        this.numSkippedEventsDueToFullBuffer = 0;
        AppMethodBeat.o(72021);
    }

    public int populateRequest(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        AppMethodBeat.i(72022);
        synchronized (this) {
            try {
                int i = this.numSkippedEventsDueToFullBuffer;
                this.inFlightEvents.addAll(this.accumulatedEvents);
                this.accumulatedEvents.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.inFlightEvents) {
                    if (!appEvent.isChecksumValid()) {
                        Utility.logd("Event with invalid checksum: %s", appEvent.toString());
                    } else if (z || !appEvent.getIsImplicit()) {
                        jSONArray.put(appEvent.getJSONObject());
                    }
                }
                if (jSONArray.length() != 0) {
                    populateRequest(graphRequest, context, i, jSONArray, z2);
                    int length = jSONArray.length();
                    AppMethodBeat.o(72022);
                    return length;
                }
            } finally {
                AppMethodBeat.o(72022);
            }
        }
        return 0;
    }

    public synchronized List<AppEvent> getEventsToPersist() {
        List list;
        AppMethodBeat.i(72023);
        list = this.accumulatedEvents;
        this.accumulatedEvents = new ArrayList();
        AppMethodBeat.o(72023);
        return list;
    }

    public synchronized void accumulatePersistedEvents(List<AppEvent> list) {
        AppMethodBeat.i(72024);
        this.accumulatedEvents.addAll(list);
        AppMethodBeat.o(72024);
    }

    private void populateRequest(GraphRequest graphRequest, Context context, int i, JSONArray jSONArray, boolean z) {
        JSONObject jSONObjectForGraphAPICall;
        AppMethodBeat.i(72025);
        try {
            jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z, context);
            if (this.numSkippedEventsDueToFullBuffer > 0) {
                jSONObjectForGraphAPICall.put("num_skipped_events", i);
            }
        } catch (JSONException e) {
            jSONObjectForGraphAPICall = new JSONObject();
        }
        graphRequest.setGraphObject(jSONObjectForGraphAPICall);
        Bundle parameters = graphRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2 != null) {
            parameters.putString("custom_events", jSONArray2);
            graphRequest.setTag(jSONArray2);
        }
        graphRequest.setParameters(parameters);
        AppMethodBeat.o(72025);
    }
}
