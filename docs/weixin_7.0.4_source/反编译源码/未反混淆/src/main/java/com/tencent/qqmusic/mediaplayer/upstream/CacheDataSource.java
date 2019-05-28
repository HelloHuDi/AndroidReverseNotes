package com.tencent.qqmusic.mediaplayer.upstream;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.perf.Collectable;
import com.tencent.qqmusic.mediaplayer.perf.ErrorUploadCollector;
import com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class CacheDataSource implements Collectable, IDataSource {
    private static final int CHUNK_LOAD_BUFFER_SIZE = 8192;
    private static final int DISCONTINUITY_THRESHOLD = 8192;
    static final long NO_RESET_PENDING = Long.MIN_VALUE;
    private static final int PROFILE_ending = 10;
    private static final int PROFILE_isCached = 8;
    private static final int PROFILE_lock = 5;
    private static final int PROFILE_onBufferEnd = 7;
    private static final int PROFILE_onBufferStarted = 4;
    private static final int PROFILE_onBytesTransferred = 9;
    private static final int PROFILE_onBytesTransferring = 3;
    private static final int PROFILE_onReadContinuity = 1;
    private static final int PROFILE_onReadDiscontinuity = 2;
    private static final int PROFILE_readAt = 6;
    private static final int PROFILE_total = 0;
    private static final int READ_WAIT_TIMEOUT = 30000;
    private static final String TAG = "CacheDataSource";
    private static final String[] profiles = new String[]{"total", "onReadContinuity", "onReadDiscontinuity", "onBytesTransferring", "onBufferStarted", "lock", "readAt", "onBufferEnd", "isCached", "onBytesTransferred", "ending"};
    private final IDataSource cacheSource;
    private final DataRangeTracker cachedDataTracker;
    private long[] costs;
    private long currentLoadStartPosition;
    private Chunk currentLoadingChunk;
    private Listener listener;
    private boolean loadFinished;
    private final Loader loader;
    private long nextContinuousPosition;
    private boolean opened;
    protected long pendingRestartPositionByte;
    protected long pendingStartPositionByte;
    private TimerTask pendingTask;
    private Timer restartHandler;

    public interface Listener extends TransferListener {
        void onBufferEnded();

        void onBufferStarted(long j);

        long onStreamingError(IOException iOException);

        void onStreamingFinished();

        void onUpStreamTransfer(long j, long j2);
    }

    public static class Factory {
        public static CacheDataSource createFromLoader(File file, com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory factory) {
            AppMethodBeat.i(104540);
            CacheDataSource cacheDataSource = new CacheDataSource(new FileDataSource(file.getAbsolutePath()), factory);
            AppMethodBeat.o(104540);
            return cacheDataSource;
        }

        public static CacheDataSource createFromUriLoader(UriLoader uriLoader) {
            AppMethodBeat.i(104541);
            try {
                final File createTempFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
                ensureFile(createTempFile);
                CacheDataSource cacheDataSource = new CacheDataSource(new FileDataSource(createTempFile.getAbsolutePath()) {
                    public final void close() {
                        AppMethodBeat.i(104582);
                        try {
                            super.close();
                        } catch (IOException e) {
                        }
                        if (!createTempFile.delete()) {
                            Logger.w(CacheDataSource.TAG, "failed to delete buffer file: " + createTempFile);
                        }
                        AppMethodBeat.o(104582);
                    }
                }, createDefaultLoaderFactory(createTempFile, uriLoader));
                AppMethodBeat.o(104541);
                return cacheDataSource;
            } catch (IOException e) {
                DataSourceException dataSourceException = new DataSourceException(-8, "failed to ensure buffer file!", e);
                AppMethodBeat.o(104541);
                throw dataSourceException;
            }
        }

        public static CacheDataSource createFromUriLoader(File file, UriLoader uriLoader) {
            AppMethodBeat.i(104542);
            CacheDataSource cacheDataSource = new CacheDataSource(new FileDataSource(file.getAbsolutePath()), createDefaultLoaderFactory(file, uriLoader));
            AppMethodBeat.o(104542);
            return cacheDataSource;
        }

        public static CacheDataSource createFromUri(File file, Uri uri) {
            AppMethodBeat.i(104543);
            CacheDataSource createFromUriLoader = createFromUriLoader(file, new DummyUriLoader(uri));
            AppMethodBeat.o(104543);
            return createFromUriLoader;
        }

        private static void ensureFile(File file) {
            AppMethodBeat.i(104544);
            file.delete();
            if (file.createNewFile()) {
                AppMethodBeat.o(104544);
                return;
            }
            IOException iOException = new IOException("failed to create file!");
            AppMethodBeat.o(104544);
            throw iOException;
        }

        private static com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory createDefaultLoaderFactory(final File file, final UriLoader uriLoader) {
            AppMethodBeat.i(104545);
            AnonymousClass2 anonymousClass2 = new com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory() {
                public final Loader createLoader(com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener listener) {
                    AppMethodBeat.i(104591);
                    AnonymousClass1 anonymousClass1 = new DefaultLoader(Looper.getMainLooper(), uriLoader, listener) {
                        /* Access modifiers changed, original: protected */
                        public IDataSource createUpStream(StreamingRequest streamingRequest) {
                            AppMethodBeat.i(104515);
                            HttpDataSource httpDataSource = new HttpDataSource(streamingRequest.uri, streamingRequest.headers, new DefaultMediaHTTPService());
                            AppMethodBeat.o(104515);
                            return httpDataSource;
                        }

                        /* Access modifiers changed, original: protected */
                        public IDataSink createCacheSink(StreamingRequest streamingRequest) {
                            AppMethodBeat.i(104516);
                            FileDataSink fileDataSink = new FileDataSink(file.getAbsolutePath());
                            AppMethodBeat.o(104516);
                            return fileDataSink;
                        }
                    };
                    AppMethodBeat.o(104591);
                    return anonymousClass1;
                }
            };
            AppMethodBeat.o(104545);
            return anonymousClass2;
        }
    }

    class LoaderListener implements com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener {
        private long loadedPosition;

        private LoaderListener() {
            this.loadedPosition = CacheDataSource.NO_RESET_PENDING;
        }

        /* synthetic */ LoaderListener(CacheDataSource cacheDataSource, AnonymousClass1 anonymousClass1) {
            this();
        }

        public synchronized void onLoadCancelled(boolean z) {
            AppMethodBeat.i(104517);
            Logger.i(CacheDataSource.TAG, "[onLoadCancelled] enter. terminated: ".concat(String.valueOf(z)));
            if (!z) {
                try {
                    if (!CacheDataSource.access$200(CacheDataSource.this)) {
                        CacheDataSource.this.cachedDataTracker.abandonLock();
                    }
                    AppMethodBeat.o(104517);
                } catch (IllegalStateException e) {
                    onLoadError(new IOException("failed to start load after cancelling", e));
                }
            }
            CacheDataSource.this.cachedDataTracker.abandonLock();
            AppMethodBeat.o(104517);
        }

        public void onLoadCompleted() {
            AppMethodBeat.i(104518);
            CacheDataSource.this.currentLoadStartPosition = CacheDataSource.NO_RESET_PENDING;
            CacheDataSource.this.currentLoadingChunk = null;
            CacheDataSource.this.loadFinished = true;
            CacheDataSource.this.cachedDataTracker.abandonLock();
            if (CacheDataSource.this.listener != null) {
                CacheDataSource.this.listener.onStreamingFinished();
            }
            AppMethodBeat.o(104518);
        }

        public void onLoadProgress(long j, long j2) {
            AppMethodBeat.i(104519);
            this.loadedPosition = j2;
            CacheDataSource.this.cachedDataTracker.addRange(j, j2);
            if (CacheDataSource.this.listener != null) {
                CacheDataSource.this.listener.onUpStreamTransfer(j2, CacheDataSource.this.loader.getUpstreamSize());
            }
            AppMethodBeat.o(104519);
        }

        public void onLoadError(IOException iOException) {
            long j;
            AppMethodBeat.i(104520);
            Logger.e(CacheDataSource.TAG, "[onLoadError] enter.", (Throwable) iOException);
            if (this.loadedPosition == CacheDataSource.NO_RESET_PENDING) {
                j = 0;
            } else {
                j = this.loadedPosition;
            }
            CacheDataSource.this.pendingRestartPositionByte = this.loadedPosition;
            if (CacheDataSource.this.listener != null) {
                long onStreamingError = CacheDataSource.this.listener.onStreamingError(iOException);
                if (onStreamingError >= 0) {
                    CacheDataSource.access$900(CacheDataSource.this, j, onStreamingError);
                    CacheDataSource.this.pendingRestartPositionByte = CacheDataSource.NO_RESET_PENDING;
                    AppMethodBeat.o(104520);
                    return;
                }
                CacheDataSource.this.currentLoadStartPosition = CacheDataSource.NO_RESET_PENDING;
                CacheDataSource.this.currentLoadingChunk = null;
                CacheDataSource.this.cachedDataTracker.abandonLock();
                AppMethodBeat.o(104520);
                return;
            }
            CacheDataSource.this.currentLoadStartPosition = CacheDataSource.NO_RESET_PENDING;
            CacheDataSource.this.currentLoadingChunk = null;
            CacheDataSource.this.cachedDataTracker.abandonLock();
            AppMethodBeat.o(104520);
        }
    }

    static /* synthetic */ void access$100(CacheDataSource cacheDataSource, long j) {
        AppMethodBeat.i(104537);
        cacheDataSource.restartLoading(j);
        AppMethodBeat.o(104537);
    }

    static /* synthetic */ boolean access$200(CacheDataSource cacheDataSource) {
        AppMethodBeat.i(104538);
        boolean startLoadingIfNeeded = cacheDataSource.startLoadingIfNeeded();
        AppMethodBeat.o(104538);
        return startLoadingIfNeeded;
    }

    static /* synthetic */ void access$900(CacheDataSource cacheDataSource, long j, long j2) {
        AppMethodBeat.i(104539);
        cacheDataSource.scheduleRestart(j, j2);
        AppMethodBeat.o(104539);
    }

    public CacheDataSource(final IDataSource iDataSource, IDataSource iDataSource2, final IDataSink iDataSink, final Looper looper) {
        this(iDataSource2, new com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory() {
            public Loader createLoader(com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener listener) {
                AppMethodBeat.i(104565);
                AnonymousClass1 anonymousClass1 = new DefaultLoader(looper, new DummyUriLoader(null), listener) {
                    /* Access modifiers changed, original: protected */
                    public IDataSource createUpStream(StreamingRequest streamingRequest) {
                        return iDataSource;
                    }

                    /* Access modifiers changed, original: protected */
                    public IDataSink createCacheSink(StreamingRequest streamingRequest) {
                        return iDataSink;
                    }
                };
                AppMethodBeat.o(104565);
                return anonymousClass1;
            }
        });
        AppMethodBeat.i(104521);
        AppMethodBeat.o(104521);
    }

    public CacheDataSource(IDataSource iDataSource, com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory factory) {
        AppMethodBeat.i(104522);
        this.currentLoadStartPosition = NO_RESET_PENDING;
        this.costs = new long[profiles.length];
        this.cacheSource = iDataSource;
        this.cachedDataTracker = new DataRangeTracker();
        this.opened = false;
        this.loadFinished = false;
        this.loader = factory.createLoader(new LoaderListener(this, null));
        AppMethodBeat.o(104522);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public boolean isCacheFileComplete() {
        AppMethodBeat.i(104523);
        long continuousEnd = this.cachedDataTracker.getContinuousEnd();
        if (continuousEnd == -1 || continuousEnd != this.loader.getUpstreamSize() - 1) {
            AppMethodBeat.o(104523);
            return false;
        }
        AppMethodBeat.o(104523);
        return true;
    }

    public Loader getLoader() {
        return this.loader;
    }

    public boolean wait(int i, long j) {
        AppMethodBeat.i(104524);
        boolean lock = this.cachedDataTracker.lock(0, i, j);
        AppMethodBeat.o(104524);
        return lock;
    }

    public void open() {
        AppMethodBeat.i(104525);
        Logger.i(TAG, "[open] enter.");
        if (this.opened) {
            AppMethodBeat.o(104525);
            return;
        }
        this.nextContinuousPosition = 0;
        this.pendingRestartPositionByte = NO_RESET_PENDING;
        this.cacheSource.open();
        this.loader.prepare();
        startLoadingIfNeeded();
        if (this.listener != null) {
            this.listener.onTransferStart();
        }
        this.opened = true;
        Logger.i(TAG, "[open] exit");
        AppMethodBeat.o(104525);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ce A:{Catch:{ InterruptedException -> 0x0130, Throwable -> 0x0035, all -> 0x004e }} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:2:0x000d, B:6:0x0036, B:39:0x0110] */
    /* JADX WARNING: Missing block: B:5:0x0035, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:?, code skipped:
            com.tencent.qqmusic.mediaplayer.util.Logger.e(TAG, "[readAt] error occurred: ".concat(java.lang.String.valueOf(r10)), r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(104526);
     */
    /* JADX WARNING: Missing block: B:10:0x004f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(104526);
     */
    /* JADX WARNING: Missing block: B:46:0x0130, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:47:0x0131, code skipped:
            r1 = new java.io.IOException("interrupted!", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(104526);
     */
    /* JADX WARNING: Missing block: B:48:0x013f, code skipped:
            throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readAt(long j, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(104526);
        int i3 = -1;
        if (j < 0) {
            Logger.e(TAG, "[readAt] invalid position: ".concat(String.valueOf(j)));
            IOException iOException = new IOException("invalid position: ".concat(String.valueOf(j)));
            AppMethodBeat.o(104526);
            throw iOException;
        }
        int i4;
        Object obj;
        this.cachedDataTracker.setFileTotalSize(getSize());
        boolean isCached = isCached(j, i2);
        if (j == this.nextContinuousPosition) {
            onReadContinuity(j);
        } else {
            Logger.i(TAG, "[readAt] onReadDiscontinuity. expected: " + this.nextContinuousPosition + ", actual: " + j);
            onReadDiscontinuity(j, isCached);
        }
        if (this.listener != null) {
            this.listener.onBytesTransferring(j, (long) i2);
        }
        if (isCached) {
            i3 = this.cacheSource.readAt(j, bArr, 0, i2);
        }
        if (i3 >= 0) {
            i4 = i3;
        } else if (this.loader.isLoading()) {
            if (this.listener != null) {
                this.listener.onBufferStarted(j);
            }
            this.cachedDataTracker.lock(j, i2, getBufferTimeout(j, i2));
            if (this.listener != null) {
                this.listener.onBufferEnded();
            }
            i4 = this.cacheSource.readAt(j, bArr, 0, i2);
        } else {
            i3 = this.cacheSource.readAt(j, bArr, 0, i2);
            Logger.e(TAG, "[readAt] load not started: " + j + ", size: " + i2 + ", read: " + i3);
            i4 = i3;
        }
        if (i4 > 0) {
            this.nextContinuousPosition = ((long) i4) + j;
        } else {
            if (i4 < 0) {
                obj = 1;
            } else if (i2 != 0) {
                obj = 1;
            }
            if (this.listener != null) {
                if (obj != null) {
                    this.listener.onBytesTransferError(j, (long) i2, (long) i4);
                } else {
                    this.listener.onBytesTransferred(j, (long) i4);
                }
            }
            AppMethodBeat.o(104526);
            return i4;
        }
        obj = null;
        if (this.listener != null) {
        }
        AppMethodBeat.o(104526);
        return i4;
    }

    public long getSize() {
        AppMethodBeat.i(104527);
        long upstreamSize = this.loader.getUpstreamSize();
        AppMethodBeat.o(104527);
        return upstreamSize;
    }

    public AudioType getAudioType() {
        AppMethodBeat.i(104528);
        AudioType audioFormat = FormatDetector.getAudioFormat((IDataSource) this, false);
        AppMethodBeat.o(104528);
        return audioFormat;
    }

    public void close() {
        AppMethodBeat.i(104529);
        Logger.i(TAG, "[close] enter.");
        if (this.opened) {
            this.cachedDataTracker.abandonLock();
            try {
                this.loader.shutdown();
            } catch (InterruptedException e) {
            }
            this.cacheSource.close();
            if (this.listener != null) {
                this.listener.onTransferEnd();
            }
            reportProfiling();
            this.opened = false;
            Logger.i(TAG, "[close] exit");
            AppMethodBeat.o(104529);
            return;
        }
        AppMethodBeat.o(104529);
    }

    private void reportProfiling() {
    }

    public synchronized boolean continueLoadIfNeeded() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(104530);
            if (!this.opened) {
                Logger.w(TAG, "[continueLoadIfNeeded] not opened!");
                AppMethodBeat.o(104530);
            } else if (this.pendingRestartPositionByte == NO_RESET_PENDING) {
                AppMethodBeat.o(104530);
            } else if (this.loadFinished) {
                AppMethodBeat.o(104530);
            } else {
                long j = this.pendingRestartPositionByte;
                this.pendingRestartPositionByte = NO_RESET_PENDING;
                scheduleRestart(j, 0);
                Logger.i(TAG, "[continueLoadIfNeeded] schedule restart from: ".concat(String.valueOf(j)));
                z = true;
                AppMethodBeat.o(104530);
            }
        }
        return z;
    }

    /* Access modifiers changed, original: protected */
    public long getBufferTimeout(long j, int i) {
        return 30000;
    }

    private void onReadDiscontinuity(long j, boolean z) {
        AppMethodBeat.i(104531);
        if (j == this.currentLoadStartPosition) {
            Logger.i(TAG, "[onReadDiscontinuity] same same position as current load. skip.");
            AppMethodBeat.o(104531);
            return;
        }
        long j2 = j - this.currentLoadStartPosition;
        if (j2 < 0 || j2 >= 8192) {
            long max;
            synchronized (this.cachedDataTracker) {
                try {
                    max = Math.max(j, this.cachedDataTracker.findStart(j));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(104531);
                }
            }
            if (this.currentLoadStartPosition == max) {
                Logger.i(TAG, "[onReadDiscontinuity] loadStartPosition is the same as current load. skip.");
                return;
            }
            j2 = max - this.currentLoadStartPosition;
            if (j2 >= 0 && j2 < 8192) {
                Logger.i(TAG, "[onReadDiscontinuity] loadStartPosition diff is too small(" + j2 + "). skip.");
                AppMethodBeat.o(104531);
                return;
            } else if (max == getSize()) {
                Logger.i(TAG, "[onReadDiscontinuity] no need to load from end. skip.");
                AppMethodBeat.o(104531);
                return;
            } else {
                Chunk chunk = this.currentLoadingChunk;
                if (z && chunk != null && chunk.contains(max)) {
                    Logger.i(TAG, String.format("[onReadDiscontinuity] position is cached and loadStartPosition(%d) is under loading(%s). skip.", new Object[]{Long.valueOf(max), chunk}));
                    AppMethodBeat.o(104531);
                    return;
                }
                restartLoading(max);
                AppMethodBeat.o(104531);
                return;
            }
        }
        Logger.i(TAG, "[onReadDiscontinuity] position diff is too small(" + j2 + "). skip.");
        AppMethodBeat.o(104531);
    }

    private void onReadContinuity(long j) {
    }

    private synchronized boolean startLoadingIfNeeded() {
        boolean z;
        AppMethodBeat.i(104532);
        if (this.loadFinished) {
            z = false;
            AppMethodBeat.o(104532);
        } else {
            Chunk chunk;
            long j = this.pendingStartPositionByte;
            this.pendingStartPositionByte = NO_RESET_PENDING;
            if (this.opened) {
                if (j == NO_RESET_PENDING) {
                    IllegalStateException illegalStateException = new IllegalStateException("pendingStartPositionByte must be set!");
                    AppMethodBeat.o(104532);
                    throw illegalStateException;
                }
                Logger.i(TAG, "[startLoadingIfNeeded] restart a pending load: ".concat(String.valueOf(j)));
                chunk = new Chunk(Utility.DEFAULT_STREAM_BUFFER_SIZE, j, -1);
            } else if (j == NO_RESET_PENDING) {
                Logger.i(TAG, "[startLoadingIfNeeded] start a fresh load");
                chunk = new Chunk(Utility.DEFAULT_STREAM_BUFFER_SIZE, 0, -1);
            } else {
                Logger.i(TAG, "[startLoadingIfNeeded] start a pending load: ".concat(String.valueOf(j)));
                chunk = new Chunk(Utility.DEFAULT_STREAM_BUFFER_SIZE, j, -1);
            }
            this.currentLoadingChunk = chunk;
            this.currentLoadStartPosition = chunk.start;
            this.cachedDataTracker.unblock();
            this.loader.startLoading(chunk);
            z = true;
            AppMethodBeat.o(104532);
        }
        return z;
    }

    private synchronized void restartLoading(long j) {
        AppMethodBeat.i(104533);
        Logger.i(TAG, "[restartLoading] from: ".concat(String.valueOf(j)));
        this.pendingStartPositionByte = j;
        this.loadFinished = false;
        if (this.loader.isLoading()) {
            this.cachedDataTracker.block();
            this.loader.cancelLoading();
            AppMethodBeat.o(104533);
        } else {
            clearState();
            startLoadingIfNeeded();
            AppMethodBeat.o(104533);
        }
    }

    private boolean isCached(long j, int i) {
        AppMethodBeat.i(104534);
        long upstreamSize = this.loader.getUpstreamSize();
        if (upstreamSize > 0 && ((long) i) + j > upstreamSize - 1) {
            i = (int) ((upstreamSize - j) - 1);
            if (i < 0) {
                j += (long) i;
                i = 0;
            }
        }
        boolean isCached = this.cachedDataTracker.isCached(j, i);
        AppMethodBeat.o(104534);
        return isCached;
    }

    private void clearState() {
        this.loadFinished = false;
    }

    @SuppressLint({"DefaultLocale"})
    private synchronized void scheduleRestart(final long j, long j2) {
        AppMethodBeat.i(104535);
        Logger.i(TAG, String.format("[scheduleRestart] position: %d, delay: %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        if (this.restartHandler == null) {
            this.restartHandler = new Timer("CacheDataSource.Restart");
        }
        if (this.pendingTask != null) {
            this.pendingTask.cancel();
            this.restartHandler.purge();
        }
        this.pendingTask = new TimerTask() {
            public void run() {
                AppMethodBeat.i(104581);
                Logger.i(CacheDataSource.TAG, "[scheduleRestart] restart loading from position: " + j);
                CacheDataSource.access$100(CacheDataSource.this, j);
                AppMethodBeat.o(104581);
            }
        };
        this.restartHandler.schedule(this.pendingTask, j2);
        AppMethodBeat.o(104535);
    }

    public void accept(PlayerInfoCollector playerInfoCollector) {
        int i;
        int i2 = 1;
        AppMethodBeat.i(104536);
        long j = 0;
        for (i = 1; i < profiles.length; i++) {
            j += this.costs[i];
        }
        double length = ((double) (this.costs[0] - j)) / ((double) this.costs.length);
        long[] jArr = new long[this.costs.length];
        System.arraycopy(this.costs, 0, jArr, 0, this.costs.length);
        for (i = 1; i < jArr.length; i++) {
            jArr[i] = Math.max(jArr[i] - ((long) length), 0);
        }
        while (i2 < profiles.length) {
            playerInfoCollector.putLong("CacheDataSource." + profiles[i2], jArr[i2] / 1000000);
            i2++;
        }
        AppMethodBeat.o(104536);
    }

    public void accept(ErrorUploadCollector errorUploadCollector) {
    }
}
