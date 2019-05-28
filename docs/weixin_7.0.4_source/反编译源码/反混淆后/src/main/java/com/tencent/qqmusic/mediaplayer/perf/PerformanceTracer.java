package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PerformanceTracer {
    private IDataSource dataSource;
    private long lastTimeStampNanoSecond = 0;
    private long playStartTimestampNanoSec = 0;
    private final Map<String, SpeedCheck> speedMap = new LinkedHashMap();
    private long totalPcmInByte;
    private long totalTimeCostInNanoSec = 0;

    public interface Visitor {
        void visitSpeedCheck(List<SpeedCheck> list, OverallInfo overallInfo);
    }

    static class OverallInfo {
        final IDataSource dataSource;
        final long timeCostInMs;
        final long totalPcmToBePlayed;

        OverallInfo(IDataSource iDataSource, long j, long j2) {
            this.dataSource = iDataSource;
            this.timeCostInMs = j;
            this.totalPcmToBePlayed = j2;
        }
    }

    static class SpeedCheck {
        /* renamed from: f */
        private static final double f15109f = 1000000.0d;
        private double avg;
        private double max;
        private double min;
        private final String name;
        private long totalBufferLength;
        private long totalTimeNanoSecond;

        /* synthetic */ SpeedCheck(String str, C444451 c444451) {
            this(str);
        }

        static /* synthetic */ void access$000(SpeedCheck speedCheck, int i, long j) {
            AppMethodBeat.m2504i(128404);
            speedCheck.update(i, j);
            AppMethodBeat.m2505o(128404);
        }

        static /* synthetic */ void access$100(SpeedCheck speedCheck) {
            AppMethodBeat.m2504i(128405);
            speedCheck.compute();
            AppMethodBeat.m2505o(128405);
        }

        public String getName() {
            return this.name;
        }

        public double getAvg() {
            return this.avg;
        }

        public double getMax() {
            return this.max;
        }

        public double getMin() {
            return this.min;
        }

        public long getTotalTimeMs() {
            AppMethodBeat.m2504i(128402);
            long round = Math.round(((double) this.totalTimeNanoSecond) / f15109f);
            AppMethodBeat.m2505o(128402);
            return round;
        }

        public long getTotalBufferLength() {
            return this.totalBufferLength;
        }

        private SpeedCheck(String str) {
            this.name = str;
        }

        private void update(int i, long j) {
            this.totalBufferLength += (long) i;
            this.totalTimeNanoSecond += j;
            double d = (((double) i) * f15109f) / ((double) j);
            if (d > this.max || this.max == 0.0d) {
                this.max = d;
            } else if (d < this.min || this.min == 0.0d) {
                this.min = d;
            }
        }

        private void compute() {
            this.avg = (((double) this.totalBufferLength) * f15109f) / ((double) this.totalTimeNanoSecond);
        }

        /* Access modifiers changed, original: 0000 */
        public void reset() {
            this.avg = 0.0d;
            this.max = 0.0d;
            this.min = 0.0d;
            this.totalTimeNanoSecond = 0;
            this.totalBufferLength = 0;
        }

        public String toString() {
            AppMethodBeat.m2504i(128403);
            compute();
            String format = String.format(Locale.getDefault(), "%10s%15.2f%15.2f%15.2f%10d%15d", new Object[]{this.name, Double.valueOf(this.avg), Double.valueOf(this.max), Double.valueOf(this.min), Long.valueOf(this.totalTimeNanoSecond), Long.valueOf(this.totalBufferLength)});
            AppMethodBeat.m2505o(128403);
            return format;
        }
    }

    static class BufferSizeCheck {
        private int lastSize = 0;
        private int maxMismatch = 0;
        private final String name;
        private int sizeMismatchCount = 0;

        public BufferSizeCheck(String str) {
            this.name = str;
        }

        /* Access modifiers changed, original: 0000 */
        public void onStart(int i) {
            this.lastSize = i;
        }

        /* Access modifiers changed, original: 0000 */
        public void onEnd(int i) {
            AppMethodBeat.m2504i(128438);
            if (i != this.lastSize) {
                int i2 = this.lastSize - i;
                if (Math.abs(i2) > this.maxMismatch) {
                    this.maxMismatch = i2;
                }
                this.sizeMismatchCount++;
            }
            AppMethodBeat.m2505o(128438);
        }

        public int getMaxMismatch() {
            return this.maxMismatch;
        }

        public String getName() {
            return this.name;
        }

        public int getSizeMismatchCount() {
            return this.sizeMismatchCount;
        }
    }

    public PerformanceTracer() {
        AppMethodBeat.m2504i(128420);
        AppMethodBeat.m2505o(128420);
    }

    public void init(IDataSource iDataSource) {
        AppMethodBeat.m2504i(128421);
        this.dataSource = iDataSource;
        this.lastTimeStampNanoSecond = 0;
        for (SpeedCheck reset : this.speedMap.values()) {
            reset.reset();
        }
        AppMethodBeat.m2505o(128421);
    }

    public void playStart() {
        this.totalPcmInByte = 0;
    }

    public void playEnd() {
    }

    public void roundStart() {
        AppMethodBeat.m2504i(128422);
        this.playStartTimestampNanoSec = System.nanoTime();
        AppMethodBeat.m2505o(128422);
    }

    public void roundEnd(int i) {
        AppMethodBeat.m2504i(128423);
        this.totalPcmInByte += (long) i;
        this.totalTimeCostInNanoSec += System.nanoTime() - this.playStartTimestampNanoSec;
        AppMethodBeat.m2505o(128423);
    }

    public void start(String str) {
        AppMethodBeat.m2504i(128424);
        getSpeedCheck(str);
        this.lastTimeStampNanoSecond = System.nanoTime();
        AppMethodBeat.m2505o(128424);
    }

    public void end(String str, int i) {
        AppMethodBeat.m2504i(128425);
        SpeedCheck.access$000(getSpeedCheck(str), i, System.nanoTime() - this.lastTimeStampNanoSecond);
        AppMethodBeat.m2505o(128425);
    }

    public void accept(Visitor visitor) {
        AppMethodBeat.m2504i(128426);
        ArrayList<SpeedCheck> arrayList = new ArrayList(this.speedMap.values());
        for (SpeedCheck access$100 : arrayList) {
            SpeedCheck.access$100(access$100);
        }
        visitor.visitSpeedCheck(arrayList, new OverallInfo(this.dataSource, Math.round(((double) this.totalTimeCostInNanoSec) / 1000000.0d), this.totalPcmInByte));
        AppMethodBeat.m2505o(128426);
    }

    private SpeedCheck getSpeedCheck(String str) {
        AppMethodBeat.m2504i(128427);
        SpeedCheck speedCheck = (SpeedCheck) this.speedMap.get(str);
        if (speedCheck != null) {
            AppMethodBeat.m2505o(128427);
            return speedCheck;
        }
        speedCheck = new SpeedCheck(str, null);
        this.speedMap.put(str, speedCheck);
        AppMethodBeat.m2505o(128427);
        return speedCheck;
    }
}
