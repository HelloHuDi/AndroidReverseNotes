package com.facebook;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphRequestBatch extends AbstractList<GraphRequest> {
    private static AtomicInteger idGenerator = new AtomicInteger();
    private String batchApplicationId;
    private Handler callbackHandler;
    private List<Callback> callbacks;
    /* renamed from: id */
    private final String f16872id;
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    public interface Callback {
        void onBatchCompleted(GraphRequestBatch graphRequestBatch);
    }

    public interface OnProgressCallback extends Callback {
        void onBatchProgress(GraphRequestBatch graphRequestBatch, long j, long j2);
    }

    static {
        AppMethodBeat.m2504i(71758);
        AppMethodBeat.m2505o(71758);
    }

    public GraphRequestBatch() {
        AppMethodBeat.m2504i(71735);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.f16872id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
        AppMethodBeat.m2505o(71735);
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        AppMethodBeat.m2504i(71736);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.f16872id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection);
        AppMethodBeat.m2505o(71736);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        AppMethodBeat.m2504i(71737);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.f16872id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = Arrays.asList(graphRequestArr);
        AppMethodBeat.m2505o(71737);
    }

    public GraphRequestBatch(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.m2504i(71738);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.f16872id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(graphRequestBatch);
        this.callbackHandler = graphRequestBatch.callbackHandler;
        this.timeoutInMilliseconds = graphRequestBatch.timeoutInMilliseconds;
        this.callbacks = new ArrayList(graphRequestBatch.callbacks);
        AppMethodBeat.m2505o(71738);
    }

    public int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public void setTimeout(int i) {
        AppMethodBeat.m2504i(71739);
        if (i < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
            AppMethodBeat.m2505o(71739);
            throw illegalArgumentException;
        }
        this.timeoutInMilliseconds = i;
        AppMethodBeat.m2505o(71739);
    }

    public void addCallback(Callback callback) {
        AppMethodBeat.m2504i(71740);
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
        AppMethodBeat.m2505o(71740);
    }

    public void removeCallback(Callback callback) {
        AppMethodBeat.m2504i(71741);
        this.callbacks.remove(callback);
        AppMethodBeat.m2505o(71741);
    }

    public final boolean add(GraphRequest graphRequest) {
        AppMethodBeat.m2504i(71742);
        boolean add = this.requests.add(graphRequest);
        AppMethodBeat.m2505o(71742);
        return add;
    }

    public final void add(int i, GraphRequest graphRequest) {
        AppMethodBeat.m2504i(71743);
        this.requests.add(i, graphRequest);
        AppMethodBeat.m2505o(71743);
    }

    public final void clear() {
        AppMethodBeat.m2504i(71744);
        this.requests.clear();
        AppMethodBeat.m2505o(71744);
    }

    public final GraphRequest get(int i) {
        AppMethodBeat.m2504i(71745);
        GraphRequest graphRequest = (GraphRequest) this.requests.get(i);
        AppMethodBeat.m2505o(71745);
        return graphRequest;
    }

    public final GraphRequest remove(int i) {
        AppMethodBeat.m2504i(71746);
        GraphRequest graphRequest = (GraphRequest) this.requests.remove(i);
        AppMethodBeat.m2505o(71746);
        return graphRequest;
    }

    public final GraphRequest set(int i, GraphRequest graphRequest) {
        AppMethodBeat.m2504i(71747);
        GraphRequest graphRequest2 = (GraphRequest) this.requests.set(i, graphRequest);
        AppMethodBeat.m2505o(71747);
        return graphRequest2;
    }

    public final int size() {
        AppMethodBeat.m2504i(71748);
        int size = this.requests.size();
        AppMethodBeat.m2505o(71748);
        return size;
    }

    /* Access modifiers changed, original: final */
    public final String getId() {
        return this.f16872id;
    }

    /* Access modifiers changed, original: final */
    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    /* Access modifiers changed, original: final */
    public final void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }

    /* Access modifiers changed, original: final */
    public final List<GraphRequest> getRequests() {
        return this.requests;
    }

    /* Access modifiers changed, original: final */
    public final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    public final void setBatchApplicationId(String str) {
        this.batchApplicationId = str;
    }

    public final List<GraphResponse> executeAndWait() {
        AppMethodBeat.m2504i(71749);
        List executeAndWaitImpl = executeAndWaitImpl();
        AppMethodBeat.m2505o(71749);
        return executeAndWaitImpl;
    }

    public final GraphRequestAsyncTask executeAsync() {
        AppMethodBeat.m2504i(71750);
        GraphRequestAsyncTask executeAsyncImpl = executeAsyncImpl();
        AppMethodBeat.m2505o(71750);
        return executeAsyncImpl;
    }

    /* Access modifiers changed, original: 0000 */
    public List<GraphResponse> executeAndWaitImpl() {
        AppMethodBeat.m2504i(71751);
        List executeBatchAndWait = GraphRequest.executeBatchAndWait(this);
        AppMethodBeat.m2505o(71751);
        return executeBatchAndWait;
    }

    /* Access modifiers changed, original: 0000 */
    public GraphRequestAsyncTask executeAsyncImpl() {
        AppMethodBeat.m2504i(71752);
        GraphRequestAsyncTask executeBatchAsync = GraphRequest.executeBatchAsync(this);
        AppMethodBeat.m2505o(71752);
        return executeBatchAsync;
    }
}
