package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.Timer;
import java.util.TimerTask;

public abstract class TimerWorker {
    private static final String TAG = "CloudFaceCountDownTimer";
    private boolean mCancelled = false;
    private final long mCountdownInterval;
    private final long mMillisInFuture;
    private long mStopTimeInFuture;
    private Timer mTimer;

    /* renamed from: com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker$1 */
    class C445961 extends TimerTask {
        C445961() {
        }

        public void run() {
            AppMethodBeat.m2504i(123201);
            TimerWorker.this.continueTimerJudge();
            AppMethodBeat.m2505o(123201);
        }
    }

    public abstract void onFinish();

    public abstract void onTick(long j);

    protected TimerWorker(long j, long j2) {
        YTLogger.m50246i(TAG, "[TimerWorker.TimerWorker] mCountDownTimer");
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    public final synchronized void cancel() {
        this.mCancelled = true;
        if (this.mTimer != null) {
            this.mTimer = null;
        }
    }

    public final synchronized TimerWorker start() {
        TimerWorker timerWorker;
        this.mCancelled = false;
        if (this.mMillisInFuture <= 0) {
            onFinish();
            timerWorker = this;
        } else {
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
            this.mTimer = new Timer();
            this.mTimer.schedule(new C445961(), 0, this.mCountdownInterval);
            timerWorker = this;
        }
        return timerWorker;
    }

    private void continueTimerJudge() {
        if (!this.mCancelled) {
            long elapsedRealtime = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                this.mTimer.cancel();
                onFinish();
            } else if (elapsedRealtime >= this.mCountdownInterval) {
                SystemClock.elapsedRealtime();
                onTick(elapsedRealtime);
                SystemClock.elapsedRealtime();
            }
        }
    }
}
