package com.tencent.d.e.a.a;

import android.hardware.SensorEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j {
    public final int AtV;
    public final long timestamp;
    public final float[] values;

    public j(SensorEvent sensorEvent, long j) {
        AppMethodBeat.i(114573);
        this.AtV = sensorEvent.sensor.getType();
        this.timestamp = j;
        this.values = Arrays.copyOf(sensorEvent.values, sensorEvent.values.length);
        AppMethodBeat.o(114573);
    }
}
