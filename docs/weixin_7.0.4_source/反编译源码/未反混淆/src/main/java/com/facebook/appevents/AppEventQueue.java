package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

class AppEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String TAG = AppEventQueue.class.getName();
    private static volatile AppEventCollection appEventCollection = new AppEventCollection();
    private static final Runnable flushRunnable = new Runnable() {
        public final void run() {
            AppMethodBeat.i(71884);
            AppEventQueue.scheduledFuture = null;
            if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue.flushAndWait(FlushReason.TIMER);
            }
            AppMethodBeat.o(71884);
        }
    };
    private static ScheduledFuture scheduledFuture;
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    AppEventQueue() {
    }

    static /* synthetic */ void access$400(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        AppMethodBeat.i(71898);
        handleResponse(accessTokenAppIdPair, graphRequest, graphResponse, sessionEventsState, flushStatistics);
        AppMethodBeat.o(71898);
    }

    static {
        AppMethodBeat.i(71899);
        AppMethodBeat.o(71899);
    }

    public static void persistToDisk() {
        AppMethodBeat.i(71890);
        singleThreadExecutor.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(71885);
                AppEventStore.persistEvents(AppEventQueue.appEventCollection);
                AppEventQueue.appEventCollection = new AppEventCollection();
                AppMethodBeat.o(71885);
            }
        });
        AppMethodBeat.o(71890);
    }

    public static void flush(final FlushReason flushReason) {
        AppMethodBeat.i(71891);
        singleThreadExecutor.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(71886);
                AppEventQueue.flushAndWait(flushReason);
                AppMethodBeat.o(71886);
            }
        });
        AppMethodBeat.o(71891);
    }

    public static void add(final AccessTokenAppIdPair accessTokenAppIdPair, final AppEvent appEvent) {
        AppMethodBeat.i(71892);
        singleThreadExecutor.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(71887);
                AppEventQueue.appEventCollection.addEvent(accessTokenAppIdPair, appEvent);
                if (AppEventsLogger.getFlushBehavior() == FlushBehavior.EXPLICIT_ONLY || AppEventQueue.appEventCollection.getEventCount() <= 100) {
                    if (AppEventQueue.scheduledFuture == null) {
                        AppEventQueue.scheduledFuture = AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15, TimeUnit.SECONDS);
                    }
                    AppMethodBeat.o(71887);
                    return;
                }
                AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
                AppMethodBeat.o(71887);
            }
        });
        AppMethodBeat.o(71892);
    }

    public static Set<AccessTokenAppIdPair> getKeySet() {
        AppMethodBeat.i(71893);
        Set keySet = appEventCollection.keySet();
        AppMethodBeat.o(71893);
        return keySet;
    }

    static void flushAndWait(FlushReason flushReason) {
        AppMethodBeat.i(71894);
        appEventCollection.addPersistedEvents(AppEventStore.readAndClearStore());
        try {
            FlushStatistics sendEventsToServer = sendEventsToServer(flushReason, appEventCollection);
            if (sendEventsToServer != null) {
                Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, sendEventsToServer.numEvents);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, sendEventsToServer.result);
                d.S(FacebookSdk.getApplicationContext()).c(intent);
            }
            AppMethodBeat.o(71894);
        } catch (Exception e) {
            AppMethodBeat.o(71894);
        }
    }

    private static FlushStatistics sendEventsToServer(FlushReason flushReason, AppEventCollection appEventCollection) {
        GraphRequest buildRequestForSession;
        AppMethodBeat.i(71895);
        FlushStatistics flushStatistics = new FlushStatistics();
        boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
        ArrayList<GraphRequest> arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
            buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, appEventCollection.get(accessTokenAppIdPair), limitEventAndDataUsage, flushStatistics);
            if (buildRequestForSession != null) {
                arrayList.add(buildRequestForSession);
            }
        }
        if (arrayList.size() > 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.numEvents), flushReason.toString());
            for (GraphRequest buildRequestForSession2 : arrayList) {
                buildRequestForSession2.executeAndWait();
            }
            AppMethodBeat.o(71895);
            return flushStatistics;
        }
        AppMethodBeat.o(71895);
        return null;
    }

    private static GraphRequest buildRequestForSession(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, boolean z, final FlushStatistics flushStatistics) {
        boolean supportsImplicitLogging;
        AppMethodBeat.i(71896);
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(accessTokenAppIdPair.getApplicationId(), false);
        final GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", new Object[]{r0}), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
        String pushNotificationsRegistrationId = AppEventsLogger.getPushNotificationsRegistrationId();
        if (pushNotificationsRegistrationId != null) {
            parameters.putString("device_token", pushNotificationsRegistrationId);
        }
        newPostRequest.setParameters(parameters);
        if (queryAppSettings != null) {
            supportsImplicitLogging = queryAppSettings.supportsImplicitLogging();
        } else {
            supportsImplicitLogging = false;
        }
        int populateRequest = sessionEventsState.populateRequest(newPostRequest, FacebookSdk.getApplicationContext(), supportsImplicitLogging, z);
        if (populateRequest == 0) {
            AppMethodBeat.o(71896);
            return null;
        }
        flushStatistics.numEvents = populateRequest + flushStatistics.numEvents;
        newPostRequest.setCallback(new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(71888);
                AppEventQueue.access$400(accessTokenAppIdPair, newPostRequest, graphResponse, sessionEventsState, flushStatistics);
                AppMethodBeat.o(71888);
            }
        });
        AppMethodBeat.o(71896);
        return newPostRequest;
    }

    private static void handleResponse(final AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, final SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        FlushResult flushResult;
        AppMethodBeat.i(71897);
        FacebookRequestError error = graphResponse.getError();
        String str = "Success";
        FlushResult flushResult2 = FlushResult.SUCCESS;
        if (error == null) {
            flushResult = flushResult2;
        } else if (error.getErrorCode() == -1) {
            str = "Failed: No Connectivity";
            flushResult = FlushResult.NO_CONNECTIVITY;
        } else {
            str = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{graphResponse.toString(), error.toString()});
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            String jSONArray;
            try {
                jSONArray = new JSONArray((String) graphRequest.getTag()).toString(2);
            } catch (JSONException e) {
                jSONArray = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.getGraphObject().toString(), str, jSONArray);
        }
        sessionEventsState.clearInFlightAndStats(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(71889);
                    AppEventStore.persistEvents(accessTokenAppIdPair, sessionEventsState);
                    AppMethodBeat.o(71889);
                }
            });
        }
        if (!(flushResult == FlushResult.SUCCESS || flushStatistics.result == FlushResult.NO_CONNECTIVITY)) {
            flushStatistics.result = flushResult;
        }
        AppMethodBeat.o(71897);
    }
}
