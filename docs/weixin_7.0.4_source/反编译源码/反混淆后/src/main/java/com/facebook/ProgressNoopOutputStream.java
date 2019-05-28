package com.facebook;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    private int batchMax;
    private final Handler callbackHandler;
    private GraphRequest currentRequest;
    private RequestProgress currentRequestProgress;
    private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    ProgressNoopOutputStream(Handler handler) {
        AppMethodBeat.m2504i(71832);
        this.callbackHandler = handler;
        AppMethodBeat.m2505o(71832);
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        AppMethodBeat.m2504i(71833);
        this.currentRequest = graphRequest;
        this.currentRequestProgress = graphRequest != null ? (RequestProgress) this.progressMap.get(graphRequest) : null;
        AppMethodBeat.m2505o(71833);
    }

    /* Access modifiers changed, original: 0000 */
    public int getMaxProgress() {
        return this.batchMax;
    }

    /* Access modifiers changed, original: 0000 */
    public Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    /* Access modifiers changed, original: 0000 */
    public void addProgress(long j) {
        AppMethodBeat.m2504i(71834);
        if (this.currentRequestProgress == null) {
            this.currentRequestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
            this.progressMap.put(this.currentRequest, this.currentRequestProgress);
        }
        this.currentRequestProgress.addToMax(j);
        this.batchMax = (int) (((long) this.batchMax) + j);
        AppMethodBeat.m2505o(71834);
    }

    public void write(byte[] bArr) {
        AppMethodBeat.m2504i(71835);
        addProgress((long) bArr.length);
        AppMethodBeat.m2505o(71835);
    }

    public void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(71836);
        addProgress((long) i2);
        AppMethodBeat.m2505o(71836);
    }

    public void write(int i) {
        AppMethodBeat.m2504i(71837);
        addProgress(1);
        AppMethodBeat.m2505o(71837);
    }
}
