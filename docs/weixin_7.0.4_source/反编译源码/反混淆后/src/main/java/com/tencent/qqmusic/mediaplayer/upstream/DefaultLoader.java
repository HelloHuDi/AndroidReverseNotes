package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.lang.Thread.State;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class DefaultLoader extends Thread implements Loader {
    private static final int MSG_LOAD_CANCELLED = 5;
    private static final int MSG_LOAD_COMPLETED = 3;
    private static final int MSG_LOAD_ERROR = 4;
    private static final int MSG_LOAD_PROGRESS = 2;
    private static final int MSG_LOAD_STARTED = 1;
    private static final int SIZE_UNSET = -1;
    private static final String TAG = "DefaultLoader";
    private final Chunk END_OF_QUEUE = new Chunk(0, 0, 0);
    private IDataSink cacheSink;
    private volatile boolean cancelled = false;
    private final BlockingQueue<Chunk> chunks;
    private final Handler eventHandler;
    private volatile boolean isLoading = false;
    private volatile boolean shutdown;
    private IDataSource upstream;
    private long upstreamSize = -1;
    private final UriLoader uriLoader;

    /* renamed from: com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader$2 */
    class C242482 implements Callback {
        C242482() {
        }

        public void onSucceed(StreamingRequest streamingRequest) {
            AppMethodBeat.m2504i(104546);
            Logger.m71025i(DefaultLoader.TAG, "[startLoading] uriLoader.startLoading onSucceed");
            IDataSource createUpStream = DefaultLoader.this.createUpStream(streamingRequest);
            try {
                createUpStream.open();
                DefaultLoader.this.upstreamSize = createUpStream.getSize();
            } catch (IOException e) {
                DefaultLoader.this.eventHandler.obtainMessage(4, e).sendToTarget();
            }
            IDataSink createCacheSink = DefaultLoader.this.createCacheSink(streamingRequest);
            try {
                createCacheSink.open();
            } catch (IOException e2) {
                DefaultLoader.this.eventHandler.obtainMessage(4, e2).sendToTarget();
            }
            DefaultLoader.this.cacheSink = createCacheSink;
            DefaultLoader.this.upstream = createUpStream;
            DefaultLoader.this.start();
            AppMethodBeat.m2505o(104546);
        }

        public void onFailed(Throwable th) {
            AppMethodBeat.m2504i(104547);
            DefaultLoader.this.eventHandler.obtainMessage(4, new IOException("failed to load uri", th)).sendToTarget();
            AppMethodBeat.m2505o(104547);
        }

        public void onCancelled() {
            AppMethodBeat.m2504i(104548);
            DefaultLoader.this.eventHandler.obtainMessage(5).sendToTarget();
            AppMethodBeat.m2505o(104548);
        }
    }

    public abstract IDataSink createCacheSink(StreamingRequest streamingRequest);

    public abstract IDataSource createUpStream(StreamingRequest streamingRequest);

    protected DefaultLoader(Looper looper, UriLoader uriLoader, final Listener listener) {
        this.uriLoader = uriLoader;
        this.eventHandler = new Handler(looper, new Handler.Callback() {
            public boolean handleMessage(Message message) {
                AppMethodBeat.m2504i(104562);
                if (listener == null) {
                    AppMethodBeat.m2505o(104562);
                    return false;
                }
                switch (message.what) {
                    case 2:
                        listener.onLoadProgress((long) message.arg1, (long) message.arg2);
                        AppMethodBeat.m2505o(104562);
                        return true;
                    default:
                        DefaultLoader.this.isLoading = false;
                        Logger.m71025i(DefaultLoader.TAG, "[handleMessage] loading = false");
                        switch (message.what) {
                            case 3:
                                listener.onLoadCompleted();
                                AppMethodBeat.m2505o(104562);
                                return true;
                            case 4:
                                listener.onLoadError((IOException) message.obj);
                                AppMethodBeat.m2505o(104562);
                                return true;
                            case 5:
                                listener.onLoadCancelled(DefaultLoader.this.shutdown);
                                AppMethodBeat.m2505o(104562);
                                return true;
                            default:
                                AppMethodBeat.m2505o(104562);
                                return false;
                        }
                }
            }
        });
        this.chunks = new LinkedBlockingQueue(1);
    }

    public void run() {
        while (!this.shutdown) {
            try {
                Chunk chunk = (Chunk) this.chunks.take();
                if (this.END_OF_QUEUE == chunk) {
                    Logger.m71025i(TAG, "[run] end of queue!");
                    return;
                }
                try {
                    if (loadChunk(chunk)) {
                        this.eventHandler.obtainMessage(3).sendToTarget();
                    } else {
                        this.eventHandler.obtainMessage(5).sendToTarget();
                    }
                } catch (IOException e) {
                    Logger.m71022e(TAG, "[run] got error!", e);
                    this.eventHandler.obtainMessage(4, e).sendToTarget();
                }
            } catch (InterruptedException e2) {
                Logger.m71027w(TAG, "[run] interrupted when taking chunk");
                return;
            }
        }
    }

    public void prepare() {
        if (this.upstream != null) {
            this.upstream.close();
        }
        if (this.cacheSink != null) {
            this.cacheSink.close();
        }
    }

    public boolean isLoading() {
        if (this.uriLoader.isLoading()) {
            return true;
        }
        return this.isLoading;
    }

    public void cancelLoading() {
        Logger.m71025i(TAG, "[cancelLoading] cancel");
        this.uriLoader.cancelLoading();
        this.cancelled = true;
    }

    public void startLoading(Chunk chunk) {
        Logger.m71025i(TAG, "[startLoading] chunk: ".concat(String.valueOf(chunk)));
        this.chunks.clear();
        if (this.chunks.offer(chunk)) {
            this.isLoading = true;
            Logger.m71025i(TAG, "[handleMessage] loading = true");
            this.cancelled = false;
            if (getState() == State.NEW) {
                this.uriLoader.startLoading(0, TimeUnit.MILLISECONDS, new C242482());
                return;
            }
            return;
        }
        throw new IllegalStateException("exceeds maximum of queue!");
    }

    public void shutdown() {
        this.shutdown = true;
        this.chunks.offer(this.END_OF_QUEUE);
        join();
        try {
            if (this.upstream != null) {
                this.upstream.close();
            }
        } catch (IOException e) {
            Logger.m71027w(TAG, "[shutdown] failed to close upstream");
        }
        try {
            if (this.cacheSink != null) {
                this.cacheSink.close();
            }
        } catch (IOException e2) {
            Logger.m71027w(TAG, "[shutdown] failed to close cacheSink");
        }
    }

    public long getUpstreamSize() {
        return this.upstreamSize;
    }

    private boolean loadChunk(Chunk chunk) {
        if (this.upstream == null || this.cacheSink == null) {
            throw new IllegalStateException("loader must be prepared first!");
        }
        long j;
        Object obj;
        long j2 = chunk.start;
        long j3 = chunk.size;
        Logger.m71020d(TAG, "[loadChunk] enter. startPosition: " + j2 + ", chunkSize: " + j3);
        byte[] bArr = new byte[chunk.bufferSize];
        Object obj2 = j3 == -1 ? 1 : null;
        int length = obj2 != null ? bArr.length : (int) Math.min((long) bArr.length, j3);
        long j4 = 0;
        Object obj3 = null;
        while (true) {
            j = j4;
            obj = obj3;
            long j5 = j2 + j;
            try {
                int readAt = this.upstream.readAt(j5, bArr, 0, length);
                if (readAt == -1) {
                    Logger.m71025i(TAG, "[loadChunk] read EOF.");
                    break;
                } else if (readAt == 0) {
                    Logger.m71020d(TAG, "[loadChunk] read none.");
                    break;
                } else if (readAt < 0) {
                    throw new IOException(new SourceReadException("read error: ".concat(String.valueOf(readAt)), ""));
                } else {
                    try {
                        j5 = (((long) this.cacheSink.write(j5, bArr, 0, readAt)) + j5) - 1;
                        j4 = ((long) readAt) + j;
                        this.eventHandler.removeMessages(2);
                        this.eventHandler.obtainMessage(2, (int) j2, (int) j5).sendToTarget();
                        obj3 = (this.cancelled || this.shutdown) ? 1 : null;
                        if (obj3 != null || (obj2 == null && j4 >= j3)) {
                            j = j4;
                            obj = obj3;
                        }
                    } catch (IOException e) {
                        throw new IOException(new SinkWriteException(e));
                    }
                }
            } catch (IOException e2) {
                throw new IOException(new SourceReadException(e2, ""));
            }
        }
        j = j4;
        obj = obj3;
        Logger.m71020d(TAG, "[loadChunk] exit. startPosition: " + j2 + ", loadedBytes: " + j + ", this.cancelled: " + this.cancelled + ", shutdown: " + this.shutdown);
        if (obj == null) {
            return true;
        }
        return false;
    }
}
