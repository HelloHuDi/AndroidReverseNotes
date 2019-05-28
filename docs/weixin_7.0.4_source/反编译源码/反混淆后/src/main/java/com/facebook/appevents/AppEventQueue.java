package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.content.C37116d;
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
    private static final Runnable flushRunnable = new C175821();
    private static ScheduledFuture scheduledFuture;
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: com.facebook.appevents.AppEventQueue$1 */
    static class C175821 implements Runnable {
        C175821() {
        }

        public final void run() {
            AppMethodBeat.m2504i(71884);
            AppEventQueue.scheduledFuture = null;
            if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue.flushAndWait(FlushReason.TIMER);
            }
            AppMethodBeat.m2505o(71884);
        }
    }

    /* renamed from: com.facebook.appevents.AppEventQueue$2 */
    static class C175832 implements Runnable {
        C175832() {
        }

        public final void run() {
            AppMethodBeat.m2504i(71885);
            AppEventStore.persistEvents(AppEventQueue.appEventCollection);
            AppEventQueue.appEventCollection = new AppEventCollection();
            AppMethodBeat.m2505o(71885);
        }
    }

    AppEventQueue() {
    }

    static /* synthetic */ void access$400(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        AppMethodBeat.m2504i(71898);
        handleResponse(accessTokenAppIdPair, graphRequest, graphResponse, sessionEventsState, flushStatistics);
        AppMethodBeat.m2505o(71898);
    }

    static {
        AppMethodBeat.m2504i(71899);
        AppMethodBeat.m2505o(71899);
    }

    public static void persistToDisk() {
        AppMethodBeat.m2504i(71890);
        singleThreadExecutor.execute(new C175832());
        AppMethodBeat.m2505o(71890);
    }

    public static void flush(final FlushReason flushReason) {
        AppMethodBeat.m2504i(71891);
        singleThreadExecutor.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(71886);
                AppEventQueue.flushAndWait(flushReason);
                AppMethodBeat.m2505o(71886);
            }
        });
        AppMethodBeat.m2505o(71891);
    }

    public static void add(final AccessTokenAppIdPair accessTokenAppIdPair, final AppEvent appEvent) {
        AppMethodBeat.m2504i(71892);
        singleThreadExecutor.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(71887);
                AppEventQueue.appEventCollection.addEvent(accessTokenAppIdPair, appEvent);
                if (AppEventsLogger.getFlushBehavior() == FlushBehavior.EXPLICIT_ONLY || AppEventQueue.appEventCollection.getEventCount() <= 100) {
                    if (AppEventQueue.scheduledFuture == null) {
                        AppEventQueue.scheduledFuture = AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15, TimeUnit.SECONDS);
                    }
                    AppMethodBeat.m2505o(71887);
                    return;
                }
                AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
                AppMethodBeat.m2505o(71887);
            }
        });
        AppMethodBeat.m2505o(71892);
    }

    public static Set<AccessTokenAppIdPair> getKeySet() {
        AppMethodBeat.m2504i(71893);
        Set keySet = appEventCollection.keySet();
        AppMethodBeat.m2505o(71893);
        return keySet;
    }

    static void flushAndWait(FlushReason flushReason) {
        AppMethodBeat.m2504i(71894);
        appEventCollection.addPersistedEvents(AppEventStore.readAndClearStore());
        try {
            FlushStatistics sendEventsToServer = sendEventsToServer(flushReason, appEventCollection);
            if (sendEventsToServer != null) {
                Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, sendEventsToServer.numEvents);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, sendEventsToServer.result);
                C37116d.m62125S(FacebookSdk.getApplicationContext()).mo59172c(intent);
            }
            AppMethodBeat.m2505o(71894);
        } catch (Exception e) {
            AppMethodBeat.m2505o(71894);
        }
    }

    private static FlushStatistics sendEventsToServer(FlushReason flushReason, AppEventCollection appEventCollection) {
        GraphRequest buildRequestForSession;
        AppMethodBeat.m2504i(71895);
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
            AppMethodBeat.m2505o(71895);
            return flushStatistics;
        }
        AppMethodBeat.m2505o(71895);
        return null;
    }

    private static GraphRequest buildRequestForSession(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, boolean z, final FlushStatistics flushStatistics) {
        boolean supportsImplicitLogging;
        AppMethodBeat.m2504i(71896);
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
            AppMethodBeat.m2505o(71896);
            return null;
        }
        flushStatistics.numEvents = populateRequest + flushStatistics.numEvents;
        newPostRequest.setCallback(new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.m2504i(71888);
                AppEventQueue.access$400(accessTokenAppIdPair, newPostRequest, graphResponse, sessionEventsState, flushStatistics);
                AppMethodBeat.m2505o(71888);
            }
        });
        AppMethodBeat.m2505o(71896);
        return newPostRequest;
    }

    private static void handleResponse(final AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, final SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        FlushResult flushResult;
        AppMethodBeat.m2504i(71897);
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
                    AppMethodBeat.m2504i(71889);
                    AppEventStore.persistEvents(accessTokenAppIdPair, sessionEventsState);
                    AppMethodBeat.m2505o(71889);
                }
            });
        }
        if (!(flushResult == FlushResult.SUCCESS || flushStatistics.result == FlushResult.NO_CONNECTIVITY)) {
            flushStatistics.result = flushResult;
        }
        AppMethodBeat.m2505o(71897);
    }
}
