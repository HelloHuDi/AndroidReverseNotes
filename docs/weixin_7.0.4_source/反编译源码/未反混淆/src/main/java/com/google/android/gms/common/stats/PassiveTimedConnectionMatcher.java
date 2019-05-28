package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.f.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PassiveTimedConnectionMatcher {
    private final long zzym;
    private final int zzyn;
    private final m<String, Long> zzyo;

    public PassiveTimedConnectionMatcher() {
        AppMethodBeat.i(89961);
        this.zzym = 60000;
        this.zzyn = 10;
        this.zzyo = new m(10);
        AppMethodBeat.o(89961);
    }

    public PassiveTimedConnectionMatcher(int i, long j) {
        AppMethodBeat.i(89962);
        this.zzym = j;
        this.zzyn = i;
        this.zzyo = new m();
        AppMethodBeat.o(89962);
    }

    public Long get(String str) {
        Long l;
        AppMethodBeat.i(89963);
        synchronized (this) {
            try {
                l = (Long) this.zzyo.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(89963);
            }
        }
        return l;
    }

    public Long put(String str) {
        Long l;
        AppMethodBeat.i(89964);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzym;
        synchronized (this) {
            long j2 = j;
            while (this.zzyo.size() >= this.zzyn) {
                try {
                    for (int size = this.zzyo.size() - 1; size >= 0; size--) {
                        if (elapsedRealtime - ((Long) this.zzyo.valueAt(size)).longValue() > j2) {
                            this.zzyo.removeAt(size);
                        }
                    }
                    j = j2 / 2;
                    new StringBuilder(94).append("The max capacity ").append(this.zzyn).append(" is not enough. Current durationThreshold is: ").append(j);
                    j2 = j;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(89964);
                }
            }
            l = (Long) this.zzyo.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean remove(String str) {
        boolean z;
        AppMethodBeat.i(89965);
        synchronized (this) {
            try {
                z = this.zzyo.remove(str) != null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(89965);
            }
        }
        return z;
    }

    public boolean removeByPrefix(String str) {
        boolean z;
        AppMethodBeat.i(89966);
        synchronized (this) {
            int i = 0;
            z = false;
            while (i < size()) {
                try {
                    boolean z2;
                    String str2 = (String) this.zzyo.keyAt(i);
                    if (str2 == null || !str2.startsWith(str)) {
                        z2 = z;
                    } else {
                        this.zzyo.remove(str2);
                        z2 = true;
                    }
                    i++;
                    z = z2;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(89966);
                }
            }
        }
        return z;
    }

    public int size() {
        int size;
        AppMethodBeat.i(89967);
        synchronized (this) {
            try {
                size = this.zzyo.size();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(89967);
            }
        }
        return size;
    }
}
