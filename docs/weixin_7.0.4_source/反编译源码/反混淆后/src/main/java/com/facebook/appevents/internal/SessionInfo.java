package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

class SessionInfo {
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
    private Long diskRestoreTime;
    private int interruptionCount;
    private UUID sessionId;
    private Long sessionLastEventTime;
    private Long sessionStartTime;
    private SourceApplicationInfo sourceApplicationInfo;

    public SessionInfo(Long l, Long l2) {
        this(l, l2, UUID.randomUUID());
        AppMethodBeat.m2504i(72214);
        AppMethodBeat.m2505o(72214);
    }

    public SessionInfo(Long l, Long l2, UUID uuid) {
        this.sessionStartTime = l;
        this.sessionLastEventTime = l2;
        this.sessionId = uuid;
    }

    public static SessionInfo getStoredSessionInfo() {
        AppMethodBeat.m2504i(72215);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        long j = defaultSharedPreferences.getLong(LAST_SESSION_INFO_START_KEY, 0);
        long j2 = defaultSharedPreferences.getLong(LAST_SESSION_INFO_END_KEY, 0);
        String string = defaultSharedPreferences.getString(SESSION_ID_KEY, null);
        if (j == 0 || j2 == 0 || string == null) {
            AppMethodBeat.m2505o(72215);
            return null;
        }
        SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j), Long.valueOf(j2));
        sessionInfo.interruptionCount = defaultSharedPreferences.getInt(INTERRUPTION_COUNT_KEY, 0);
        sessionInfo.sourceApplicationInfo = SourceApplicationInfo.getStoredSourceApplicatioInfo();
        sessionInfo.diskRestoreTime = Long.valueOf(System.currentTimeMillis());
        sessionInfo.sessionId = UUID.fromString(string);
        AppMethodBeat.m2505o(72215);
        return sessionInfo;
    }

    public static void clearSavedSessionFromDisk() {
        AppMethodBeat.m2504i(72216);
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove(LAST_SESSION_INFO_START_KEY);
        edit.remove(LAST_SESSION_INFO_END_KEY);
        edit.remove(INTERRUPTION_COUNT_KEY);
        edit.remove(SESSION_ID_KEY);
        edit.apply();
        SourceApplicationInfo.clearSavedSourceApplicationInfoFromDisk();
        AppMethodBeat.m2505o(72216);
    }

    public Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public void setSessionLastEventTime(Long l) {
        this.sessionLastEventTime = l;
    }

    public int getInterruptionCount() {
        return this.interruptionCount;
    }

    public void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public long getDiskRestoreTime() {
        AppMethodBeat.m2504i(72217);
        if (this.diskRestoreTime == null) {
            AppMethodBeat.m2505o(72217);
            return 0;
        }
        long longValue = this.diskRestoreTime.longValue();
        AppMethodBeat.m2505o(72217);
        return longValue;
    }

    public UUID getSessionId() {
        return this.sessionId;
    }

    public long getSessionLength() {
        AppMethodBeat.m2504i(72218);
        if (this.sessionStartTime == null || this.sessionLastEventTime == null) {
            AppMethodBeat.m2505o(72218);
            return 0;
        }
        long longValue = this.sessionLastEventTime.longValue() - this.sessionStartTime.longValue();
        AppMethodBeat.m2505o(72218);
        return longValue;
    }

    public SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public void setSourceApplicationInfo(SourceApplicationInfo sourceApplicationInfo) {
        this.sourceApplicationInfo = sourceApplicationInfo;
    }

    public void writeSessionToDisk() {
        AppMethodBeat.m2504i(72219);
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putLong(LAST_SESSION_INFO_START_KEY, this.sessionStartTime.longValue());
        edit.putLong(LAST_SESSION_INFO_END_KEY, this.sessionLastEventTime.longValue());
        edit.putInt(INTERRUPTION_COUNT_KEY, this.interruptionCount);
        edit.putString(SESSION_ID_KEY, this.sessionId.toString());
        edit.apply();
        if (this.sourceApplicationInfo != null) {
            this.sourceApplicationInfo.writeSourceApplicationInfoToDisk();
        }
        AppMethodBeat.m2505o(72219);
    }
}
