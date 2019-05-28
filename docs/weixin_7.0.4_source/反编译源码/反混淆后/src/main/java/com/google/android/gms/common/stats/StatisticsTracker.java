package com.google.android.gms.common.stats;

public interface StatisticsTracker {
    void registerEvent(ConnectionEvent connectionEvent);

    void registerEvent(WakeLockEvent wakeLockEvent);
}
