package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.OnProgressCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    RequestProgress(Handler handler, GraphRequest graphRequest) {
        AppMethodBeat.i(71848);
        this.request = graphRequest;
        this.callbackHandler = handler;
        AppMethodBeat.o(71848);
    }

    /* Access modifiers changed, original: 0000 */
    public long getProgress() {
        return this.progress;
    }

    /* Access modifiers changed, original: 0000 */
    public long getMaxProgress() {
        return this.maxProgress;
    }

    /* Access modifiers changed, original: 0000 */
    public void addProgress(long j) {
        AppMethodBeat.i(71849);
        this.progress += j;
        if (this.progress >= this.lastReportedProgress + this.threshold || this.progress >= this.maxProgress) {
            reportProgress();
        }
        AppMethodBeat.o(71849);
    }

    /* Access modifiers changed, original: 0000 */
    public void addToMax(long j) {
        this.maxProgress += j;
    }

    /* Access modifiers changed, original: 0000 */
    public void reportProgress() {
        AppMethodBeat.i(71850);
        if (this.progress > this.lastReportedProgress) {
            Callback callback = this.request.getCallback();
            if (this.maxProgress > 0 && (callback instanceof OnProgressCallback)) {
                final long j = this.progress;
                final long j2 = this.maxProgress;
                final OnProgressCallback onProgressCallback = (OnProgressCallback) callback;
                if (this.callbackHandler == null) {
                    onProgressCallback.onProgress(j, j2);
                } else {
                    this.callbackHandler.post(new Runnable() {
                        public void run() {
                            AppMethodBeat.i(71847);
                            onProgressCallback.onProgress(j, j2);
                            AppMethodBeat.o(71847);
                        }
                    });
                }
                this.lastReportedProgress = this.progress;
            }
        }
        AppMethodBeat.o(71850);
    }
}
