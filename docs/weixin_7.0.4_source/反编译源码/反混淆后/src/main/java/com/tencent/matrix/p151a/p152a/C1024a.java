package com.tencent.matrix.p151a.p152a;

import com.tencent.mrs.p656b.C5774a;
import com.tencent.mrs.p656b.C5774a.C5773a;

/* renamed from: com.tencent.matrix.a.a.a */
public final class C1024a {
    public final C5774a bUG;

    /* renamed from: yL */
    public final boolean mo4161yL() {
        return this.bUG.get(C5773a.clicfg_matrix_battery_detect_wake_lock_enable.name(), true);
    }

    /* renamed from: yM */
    public final boolean mo4162yM() {
        return this.bUG.get(C5773a.clicfg_matrix_battery_detect_alarm_enable.name(), true);
    }

    /* renamed from: yN */
    public final boolean mo4163yN() {
        return this.bUG.get(C5773a.clicfg_matrix_battery_record_wake_lock_enable.name(), false);
    }

    /* renamed from: yO */
    public final boolean mo4164yO() {
        return this.bUG.get(C5773a.clicfg_matrix_battery_record_alarm_enable.name(), false);
    }

    public final String toString() {
        return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", new Object[]{Boolean.valueOf(mo4161yL()), Boolean.valueOf(mo4161yL()), Boolean.valueOf(mo4163yN()), Boolean.valueOf(mo4164yO())});
    }
}
