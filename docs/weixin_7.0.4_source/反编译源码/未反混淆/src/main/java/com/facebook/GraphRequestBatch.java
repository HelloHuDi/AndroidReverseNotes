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
    private final String id;
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    public interface Callback {
        void onBatchCompleted(GraphRequestBatch graphRequestBatch);
    }

    public interface OnProgressCallback extends Callback {
        void onBatchProgress(GraphRequestBatch graphRequestBatch, long j, long j2);
    }

    static {
        AppMethodBeat.i(71758);
        AppMethodBeat.o(71758);
    }

    public GraphRequestBatch() {
        AppMethodBeat.i(71735);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
        AppMethodBeat.o(71735);
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        AppMethodBeat.i(71736);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection);
        AppMethodBeat.o(71736);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        AppMethodBeat.i(71737);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = Arrays.asList(graphRequestArr);
        AppMethodBeat.o(71737);
    }

    public GraphRequestBatch(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71738);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(graphRequestBatch);
        this.callbackHandler = graphRequestBatch.callbackHandler;
        this.timeoutInMilliseconds = graphRequestBatch.timeoutInMilliseconds;
        this.callbacks = new ArrayList(graphRequestBatch.callbacks);
        AppMethodBeat.o(71738);
    }

    public int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public void setTimeout(int i) {
        AppMethodBeat.i(71739);
        if (i < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
            AppMethodBeat.o(71739);
            throw illegalArgumentException;
        }
        this.timeoutInMilliseconds = i;
        AppMethodBeat.o(71739);
    }

    public void addCallback(Callback callback) {
        AppMethodBeat.i(71740);
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
        AppMethodBeat.o(71740);
    }

    public void removeCallback(Callback callback) {
        AppMethodBeat.i(71741);
        this.callbacks.remove(callback);
        AppMethodBeat.o(71741);
    }

    public final boolean add(GraphRequest graphRequest) {
        AppMethodBeat.i(71742);
        boolean add = this.requests.add(graphRequest);
        AppMethodBeat.o(71742);
        return add;
    }

    public final void add(int i, GraphRequest graphRequest) {
        AppMethodBeat.i(71743);
        this.requests.add(i, graphRequest);
        AppMethodBeat.o(71743);
    }

    public final void clear() {
        AppMethodBeat.i(71744);
        this.requests.clear();
        AppMethodBeat.o(71744);
    }

    public final GraphRequest get(int i) {
        AppMethodBeat.i(71745);
        GraphRequest graphRequest = (GraphRequest) this.requests.get(i);
        AppMethodBeat.o(71745);
        return graphRequest;
    }

    public final GraphRequest remove(int i) {
        AppMethodBeat.i(71746);
        GraphRequest graphRequest = (GraphRequest) this.requests.remove(i);
        AppMethodBeat.o(71746);
        return graphRequest;
    }

    public final GraphRequest set(int i, GraphRequest graphRequest) {
        AppMethodBeat.i(71747);
        GraphRequest graphRequest2 = (GraphRequest) this.requests.set(i, graphRequest);
        AppMethodBeat.o(71747);
        return graphRequest2;
    }

    public final int size() {
        AppMethodBeat.i(71748);
        int size = this.requests.size();
        AppMethodBeat.o(71748);
        return size;
    }

    /* Access modifiers changed, original: final */
    public final String getId() {
        return this.id;
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
        AppMethodBeat.i(71749);
        List executeAndWaitImpl = executeAndWaitImpl();
        AppMethodBeat.o(71749);
        return executeAndWaitImpl;
    }

    public final GraphRequestAsyncTask executeAsync() {
        AppMethodBeat.i(71750);
        GraphRequestAsyncTask executeAsyncImpl = executeAsyncImpl();
        AppMethodBeat.o(71750);
        return executeAsyncImpl;
    }

    /* Access modifiers changed, original: 0000 */
    public List<GraphResponse> executeAndWaitImpl() {
        AppMethodBeat.i(71751);
        List executeBatchAndWait = GraphRequest.executeBatchAndWait(this);
        AppMethodBeat.o(71751);
        return executeBatchAndWait;
    }

    /* Access modifiers changed, original: 0000 */
    public GraphRequestAsyncTask executeAsyncImpl() {
        AppMethodBeat.i(71752);
        GraphRequestAsyncTask executeBatchAsync = GraphRequest.executeBatchAsync(this);
        AppMethodBeat.o(71752);
        return executeBatchAsync;
    }
}
