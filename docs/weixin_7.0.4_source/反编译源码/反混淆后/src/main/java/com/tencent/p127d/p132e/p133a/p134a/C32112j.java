package com.tencent.p127d.p132e.p133a.p134a;

import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.d.e.a.a.j */
public final class C32112j {
    public final int AtV;
    public final long timestamp;
    public final float[] values;

    public C32112j(SensorEvent sensorEvent, long j) {
        AppMethodBeat.m2504i(114573);
        this.AtV = sensorEvent.sensor.getType();
        this.timestamp = j;
        this.values = Arrays.copyOf(sensorEvent.values, sensorEvent.values.length);
        AppMethodBeat.m2505o(114573);
    }
}
