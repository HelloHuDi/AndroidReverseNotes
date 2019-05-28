package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphRequestBatch.OnProgressCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Map;

class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    private long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    private long maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap;
    private final GraphRequestBatch requests;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        super(outputStream);
        AppMethodBeat.m2504i(71839);
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j;
        AppMethodBeat.m2505o(71839);
    }

    private void addProgress(long j) {
        AppMethodBeat.m2504i(71840);
        if (this.currentRequestProgress != null) {
            this.currentRequestProgress.addProgress(j);
        }
        this.batchProgress += j;
        if (this.batchProgress >= this.lastReportedProgress + this.threshold || this.batchProgress >= this.maxProgress) {
            reportBatchProgress();
        }
        AppMethodBeat.m2505o(71840);
    }

    private void reportBatchProgress() {
        AppMethodBeat.m2504i(71841);
        if (this.batchProgress > this.lastReportedProgress) {
            for (Callback callback : this.requests.getCallbacks()) {
                if (callback instanceof OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    final OnProgressCallback onProgressCallback = (OnProgressCallback) callback;
                    if (callbackHandler == null) {
                        onProgressCallback.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    } else {
                        callbackHandler.post(new Runnable() {
                            public void run() {
                                AppMethodBeat.m2504i(71838);
                                onProgressCallback.onBatchProgress(ProgressOutputStream.this.requests, ProgressOutputStream.this.batchProgress, ProgressOutputStream.this.maxProgress);
                                AppMethodBeat.m2505o(71838);
                            }
                        });
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
        AppMethodBeat.m2505o(71841);
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        AppMethodBeat.m2504i(71842);
        this.currentRequestProgress = graphRequest != null ? (RequestProgress) this.progressMap.get(graphRequest) : null;
        AppMethodBeat.m2505o(71842);
    }

    /* Access modifiers changed, original: 0000 */
    public long getBatchProgress() {
        return this.batchProgress;
    }

    /* Access modifiers changed, original: 0000 */
    public long getMaxProgress() {
        return this.maxProgress;
    }

    public void write(byte[] bArr) {
        AppMethodBeat.m2504i(71843);
        this.out.write(bArr);
        addProgress((long) bArr.length);
        AppMethodBeat.m2505o(71843);
    }

    public void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(71844);
        this.out.write(bArr, i, i2);
        addProgress((long) i2);
        AppMethodBeat.m2505o(71844);
    }

    public void write(int i) {
        AppMethodBeat.m2504i(71845);
        this.out.write(i);
        addProgress(1);
        AppMethodBeat.m2505o(71845);
    }

    public void close() {
        AppMethodBeat.m2504i(71846);
        super.close();
        for (RequestProgress reportProgress : this.progressMap.values()) {
            reportProgress.reportProgress();
        }
        reportBatchProgress();
        AppMethodBeat.m2505o(71846);
    }
}
