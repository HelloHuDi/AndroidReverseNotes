package com.tencent.matrix.a.a;

public final class a {
    public final com.tencent.mrs.b.a bUG;

    public final boolean yL() {
        return this.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_detect_wake_lock_enable.name(), true);
    }

    public final boolean yM() {
        return this.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_detect_alarm_enable.name(), true);
    }

    public final boolean yN() {
        return this.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_record_wake_lock_enable.name(), false);
    }

    public final boolean yO() {
        return this.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_battery_record_alarm_enable.name(), false);
    }

    public final String toString() {
        return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", new Object[]{Boolean.valueOf(yL()), Boolean.valueOf(yL()), Boolean.valueOf(yN()), Boolean.valueOf(yO())});
    }
}
