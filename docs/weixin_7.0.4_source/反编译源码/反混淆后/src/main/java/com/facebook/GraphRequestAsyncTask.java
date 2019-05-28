package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;

public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<GraphResponse>> {
    private static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
    private final HttpURLConnection connection;
    private Exception exception;
    private final GraphRequestBatch requests;

    static {
        AppMethodBeat.m2504i(71734);
        AppMethodBeat.m2505o(71734);
    }

    public GraphRequestAsyncTask(GraphRequest... graphRequestArr) {
        this(null, new GraphRequestBatch(graphRequestArr));
        AppMethodBeat.m2504i(71724);
        AppMethodBeat.m2505o(71724);
    }

    public GraphRequestAsyncTask(Collection<GraphRequest> collection) {
        this(null, new GraphRequestBatch((Collection) collection));
        AppMethodBeat.m2504i(71725);
        AppMethodBeat.m2505o(71725);
    }

    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this(null, graphRequestBatch);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequest... graphRequestArr) {
        this(httpURLConnection, new GraphRequestBatch(graphRequestArr));
        AppMethodBeat.m2504i(71726);
        AppMethodBeat.m2505o(71726);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        this(httpURLConnection, new GraphRequestBatch((Collection) collection));
        AppMethodBeat.m2504i(71727);
        AppMethodBeat.m2505o(71727);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        this.requests = graphRequestBatch;
        this.connection = httpURLConnection;
    }

    /* Access modifiers changed, original: protected|final */
    public final Exception getException() {
        return this.exception;
    }

    /* Access modifiers changed, original: protected|final */
    public final GraphRequestBatch getRequests() {
        return this.requests;
    }

    public String toString() {
        AppMethodBeat.m2504i(71728);
        String str = "{RequestAsyncTask:  connection: " + this.connection + ", requests: " + this.requests + "}";
        AppMethodBeat.m2505o(71728);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void onPreExecute() {
        AppMethodBeat.m2504i(71729);
        super.onPreExecute();
        if (FacebookSdk.isDebugEnabled()) {
            Utility.logd(TAG, String.format("execute async task: %s", new Object[]{this}));
        }
        if (this.requests.getCallbackHandler() == null) {
            Handler handler;
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.requests.setCallbackHandler(handler);
        }
        AppMethodBeat.m2505o(71729);
    }

    /* Access modifiers changed, original: protected */
    public void onPostExecute(List<GraphResponse> list) {
        AppMethodBeat.m2504i(71730);
        super.onPostExecute(list);
        if (this.exception != null) {
            Utility.logd(TAG, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.exception.getMessage()}));
        }
        AppMethodBeat.m2505o(71730);
    }

    /* Access modifiers changed, original: protected|varargs */
    public List<GraphResponse> doInBackground(Void... voidArr) {
        AppMethodBeat.m2504i(71731);
        try {
            if (this.connection == null) {
                List executeAndWait = this.requests.executeAndWait();
                AppMethodBeat.m2505o(71731);
                return executeAndWait;
            }
            List<GraphResponse> executeConnectionAndWait = GraphRequest.executeConnectionAndWait(this.connection, this.requests);
            AppMethodBeat.m2505o(71731);
            return executeConnectionAndWait;
        } catch (Exception e) {
            this.exception = e;
            AppMethodBeat.m2505o(71731);
            return null;
        }
    }
}
