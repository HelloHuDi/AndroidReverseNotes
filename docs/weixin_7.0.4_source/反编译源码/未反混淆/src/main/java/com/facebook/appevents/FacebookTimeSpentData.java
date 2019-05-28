package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Locale;

class FacebookTimeSpentData implements Serializable {
    private static final long APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS = 300000;
    private static final long FIRST_TIME_LOAD_RESUME_TIME = -1;
    private static final long[] INACTIVE_SECONDS_QUANTA = new long[]{APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    private static final long NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION = 60000;
    private static final String TAG = FacebookTimeSpentData.class.getCanonicalName();
    private static final long serialVersionUID = 1;
    private String firstOpenSourceApplication;
    private int interruptionCount;
    private boolean isAppActive;
    private boolean isWarmLaunch;
    private long lastActivateEventLoggedTime;
    private long lastResumeTime;
    private long lastSuspendTime;
    private long millisecondsSpentInSession;

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 6;
        private final int interruptionCount;
        private final long lastResumeTime;
        private final long lastSuspendTime;
        private final long millisecondsSpentInSession;

        SerializationProxyV1(long j, long j2, long j3, int i) {
            this.lastResumeTime = j;
            this.lastSuspendTime = j2;
            this.millisecondsSpentInSession = j3;
            this.interruptionCount = i;
        }

        private Object readResolve() {
            AppMethodBeat.i(71988);
            FacebookTimeSpentData facebookTimeSpentData = new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, null);
            AppMethodBeat.o(71988);
            return facebookTimeSpentData;
        }
    }

    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 6;
        private final String firstOpenSourceApplication;
        private final int interruptionCount;
        private final long lastResumeTime;
        private final long lastSuspendTime;
        private final long millisecondsSpentInSession;

        SerializationProxyV2(long j, long j2, long j3, int i, String str) {
            this.lastResumeTime = j;
            this.lastSuspendTime = j2;
            this.millisecondsSpentInSession = j3;
            this.interruptionCount = i;
            this.firstOpenSourceApplication = str;
        }

        private Object readResolve() {
            AppMethodBeat.i(71989);
            FacebookTimeSpentData facebookTimeSpentData = new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
            AppMethodBeat.o(71989);
            return facebookTimeSpentData;
        }
    }

    static {
        AppMethodBeat.i(71997);
        AppMethodBeat.o(71997);
    }

    private FacebookTimeSpentData(long j, long j2, long j3, int i) {
        AppMethodBeat.i(71990);
        resetSession();
        this.lastResumeTime = j;
        this.lastSuspendTime = j2;
        this.millisecondsSpentInSession = j3;
        this.interruptionCount = i;
        AppMethodBeat.o(71990);
    }

    FacebookTimeSpentData() {
        AppMethodBeat.i(71991);
        resetSession();
        AppMethodBeat.o(71991);
    }

    private FacebookTimeSpentData(long j, long j2, long j3, int i, String str) {
        AppMethodBeat.i(71992);
        resetSession();
        this.lastResumeTime = j;
        this.lastSuspendTime = j2;
        this.millisecondsSpentInSession = j3;
        this.interruptionCount = i;
        this.firstOpenSourceApplication = str;
        AppMethodBeat.o(71992);
    }

    private Object writeReplace() {
        AppMethodBeat.i(71993);
        SerializationProxyV2 serializationProxyV2 = new SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
        AppMethodBeat.o(71993);
        return serializationProxyV2;
    }

    /* Access modifiers changed, original: 0000 */
    public void onSuspend(AppEventsLogger appEventsLogger, long j) {
        long j2 = 0;
        AppMethodBeat.i(71994);
        if (this.isAppActive) {
            long j3 = j - this.lastResumeTime;
            if (j3 < 0) {
                Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
            } else {
                j2 = j3;
            }
            this.millisecondsSpentInSession = j2 + this.millisecondsSpentInSession;
            this.lastSuspendTime = j;
            this.isAppActive = false;
            AppMethodBeat.o(71994);
            return;
        }
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
        AppMethodBeat.o(71994);
    }

    /* Access modifiers changed, original: 0000 */
    public void onResume(AppEventsLogger appEventsLogger, long j, String str) {
        long j2 = 0;
        AppMethodBeat.i(71995);
        if (isColdLaunch() || j - this.lastActivateEventLoggedTime > APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS) {
            Bundle bundle = new Bundle();
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str);
            appEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
            this.lastActivateEventLoggedTime = j;
            if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                appEventsLogger.flush();
            }
        }
        if (this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
            AppMethodBeat.o(71995);
            return;
        }
        long j3 = wasSuspendedEver() ? j - this.lastSuspendTime : 0;
        if (j3 < 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
        } else {
            j2 = j3;
        }
        if (j2 > NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION) {
            logAppDeactivatedEvent(appEventsLogger, j2);
        } else if (j2 > 1000) {
            this.interruptionCount++;
        }
        if (this.interruptionCount == 0) {
            this.firstOpenSourceApplication = str;
        }
        this.lastResumeTime = j;
        this.isAppActive = true;
        AppMethodBeat.o(71995);
    }

    private void logAppDeactivatedEvent(AppEventsLogger appEventsLogger, long j) {
        AppMethodBeat.i(71996);
        Bundle bundle = new Bundle();
        bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, this.interruptionCount);
        bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, String.format(Locale.ROOT, "session_quanta_%d", new Object[]{Integer.valueOf(getQuantaIndex(j))}));
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, this.firstOpenSourceApplication);
        appEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, (double) (this.millisecondsSpentInSession / 1000), bundle);
        resetSession();
        AppMethodBeat.o(71996);
    }

    private static int getQuantaIndex(long j) {
        int i = 0;
        while (i < INACTIVE_SECONDS_QUANTA.length && INACTIVE_SECONDS_QUANTA[i] < j) {
            i++;
        }
        return i;
    }

    private void resetSession() {
        this.isAppActive = false;
        this.lastResumeTime = -1;
        this.lastSuspendTime = -1;
        this.interruptionCount = 0;
        this.millisecondsSpentInSession = 0;
    }

    private boolean wasSuspendedEver() {
        return this.lastSuspendTime != -1;
    }

    private boolean isColdLaunch() {
        boolean z = !this.isWarmLaunch;
        this.isWarmLaunch = true;
        return z;
    }
}
