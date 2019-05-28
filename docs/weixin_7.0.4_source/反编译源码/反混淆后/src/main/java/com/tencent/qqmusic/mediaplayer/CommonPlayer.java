package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.HttpDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.upstream.TracerDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;

public class CommonPlayer extends BaseMediaPlayer {
    private static final int INIT_STATE_CHECK_TIME = 5000;
    private static final String TAG = "CommonPlayer";
    private PlayerCallback callback;
    private int currentState;
    private Looper eventLooper;
    private CorePlayer mAudioPlayer;
    private int mBufferPercentage;
    private final ListPlayerListenerCallback mCallback;
    private long mDuration;
    private final boolean mPreferMediaCodecDecode;
    private OpenedResources openedResources;

    /* renamed from: com.tencent.qqmusic.mediaplayer.CommonPlayer$1 */
    class C242461 implements PlayerCallback {
        C242461() {
        }

        public void playThreadStart(CorePlayer corePlayer) {
        }

        public void playerPrepared(CorePlayer corePlayer) {
            AppMethodBeat.m2504i(104800);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.m71025i(CommonPlayer.TAG, "playerPrepared() callback prepared");
                CommonPlayer.this.TransferStateTo(2);
                CommonPlayer.this.mCallback.onPrepared(CommonPlayer.this);
                AppMethodBeat.m2505o(104800);
                return;
            }
            Logger.m71025i(CommonPlayer.TAG, "different playerPrepared");
            AppMethodBeat.m2505o(104800);
        }

        public void playerStopped(CorePlayer corePlayer) {
            AppMethodBeat.m2504i(104801);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.m71025i(CommonPlayer.TAG, "playerStopped() callback stopped");
                AppMethodBeat.m2505o(104801);
                return;
            }
            Logger.m71025i(CommonPlayer.TAG, "different playerStopped");
            AppMethodBeat.m2505o(104801);
        }

        public void playerStarted(CorePlayer corePlayer) {
            AppMethodBeat.m2504i(104802);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.m71025i(CommonPlayer.TAG, "playerStarted() callback started");
                CommonPlayer.this.mCallback.onStarted(CommonPlayer.this);
                AppMethodBeat.m2505o(104802);
                return;
            }
            Logger.m71025i(CommonPlayer.TAG, "different playerStarted");
            AppMethodBeat.m2505o(104802);
        }

        public void playerSeekCompletion(CorePlayer corePlayer, int i) {
            AppMethodBeat.m2504i(104803);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.m71025i(CommonPlayer.TAG, "playerSeekCompletion() callback seek completion");
                CommonPlayer.this.mCallback.onSeekComplete(CommonPlayer.this, i);
                AppMethodBeat.m2505o(104803);
                return;
            }
            Logger.m71025i(CommonPlayer.TAG, "different playerSeekCompletion");
            AppMethodBeat.m2505o(104803);
        }

        public void playerPaused(CorePlayer corePlayer) {
            AppMethodBeat.m2504i(104804);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.m71025i(CommonPlayer.TAG, "playerPaused() callback paused");
                AppMethodBeat.m2505o(104804);
                return;
            }
            Logger.m71025i(CommonPlayer.TAG, "different playerPaused");
            AppMethodBeat.m2505o(104804);
        }

        public void playerException(CorePlayer corePlayer, int i, int i2, int i3) {
            AppMethodBeat.m2504i(104805);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.m71021e(CommonPlayer.TAG, "playerException() callback exception what = " + i + ",extra = " + i2 + " mAudioPlayer:" + CommonPlayer.this.mAudioPlayer);
                if (CommonPlayer.this.mAudioPlayer != null) {
                    Logger.m71021e(CommonPlayer.TAG, "handleMessage state = ".concat(String.valueOf(CommonPlayer.this.mAudioPlayer.getPlayerState())));
                    Logger.m71021e(CommonPlayer.TAG, "handleMessage isInit = " + CommonPlayer.this.mAudioPlayer.isInit() + ",isStartDecode = " + CommonPlayer.this.mAudioPlayer.hasDecodeData() + ",decodeSuccess = " + CommonPlayer.this.mAudioPlayer.hasDecodeDataSuccess());
                }
                CommonPlayer.access$200(CommonPlayer.this, i, i2, i3);
                AppMethodBeat.m2505o(104805);
                return;
            }
            Logger.m71025i(CommonPlayer.TAG, "different playerException");
            AppMethodBeat.m2505o(104805);
        }

        public void playerEnded(CorePlayer corePlayer) {
            AppMethodBeat.m2504i(104806);
            if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                Logger.m71025i(CommonPlayer.TAG, "playerEnded() callback ended");
                CommonPlayer.this.TransferStateTo(7);
                CommonPlayer.this.mCallback.onCompletion(CommonPlayer.this);
                AppMethodBeat.m2505o(104806);
                return;
            }
            Logger.m71025i(CommonPlayer.TAG, "different playerEnded");
            AppMethodBeat.m2505o(104806);
        }
    }

    class BufferListener implements Listener {
        private BufferListener() {
        }

        /* synthetic */ BufferListener(CommonPlayer commonPlayer, C242461 c242461) {
            this();
        }

        public void onBufferStarted(long j) {
            AppMethodBeat.m2504i(104689);
            Logger.m71025i(CommonPlayer.TAG, CommonPlayer.access$700(CommonPlayer.this, "buffer started."));
            AppMethodBeat.m2505o(104689);
        }

        public void onBufferEnded() {
            AppMethodBeat.m2504i(104690);
            Logger.m71025i(CommonPlayer.TAG, CommonPlayer.access$700(CommonPlayer.this, "buffer ended."));
            AppMethodBeat.m2505o(104690);
        }

        public void onUpStreamTransfer(long j, long j2) {
            AppMethodBeat.m2504i(104691);
            if (CommonPlayer.this.getPlayerState() == 2 || CommonPlayer.this.getPlayerState() == 4) {
                int round = (int) Math.round((((double) j) / ((double) j2)) * 100.0d);
                if (round == CommonPlayer.this.mBufferPercentage) {
                    AppMethodBeat.m2505o(104691);
                    return;
                }
                CommonPlayer.this.mBufferPercentage = round;
                CommonPlayer.this.mCallback.onBufferingUpdate(CommonPlayer.this, CommonPlayer.this.mBufferPercentage);
                AppMethodBeat.m2505o(104691);
                return;
            }
            AppMethodBeat.m2505o(104691);
        }

        public long onStreamingError(IOException iOException) {
            AppMethodBeat.m2504i(104692);
            Logger.m71022e(CommonPlayer.TAG, CommonPlayer.access$700(CommonPlayer.this, "streaming error!"), (Throwable) iOException);
            AppMethodBeat.m2505o(104692);
            return -1;
        }

        public void onStreamingFinished() {
            AppMethodBeat.m2504i(104693);
            Logger.m71025i(CommonPlayer.TAG, CommonPlayer.access$700(CommonPlayer.this, "streaming finished"));
            AppMethodBeat.m2505o(104693);
        }

        public void onTransferStart() {
        }

        public void onBytesTransferring(long j, long j2) {
        }

        public void onBytesTransferred(long j, long j2) {
        }

        public void onBytesTransferError(long j, long j2, long j3) {
        }

        public void onTransferEnd() {
        }
    }

    static class OpenedResources {
        private File bufferFile;
        private CacheDataSource dataSource;

        private OpenedResources() {
        }

        /* synthetic */ OpenedResources(C242461 c242461) {
            this();
        }

        /* Access modifiers changed, original: 0000 */
        public void release() {
            AppMethodBeat.m2504i(104483);
            if (!(this.bufferFile == null || this.bufferFile.delete())) {
                Logger.m71027w(CommonPlayer.TAG, "[release] failed to delete buffer file: " + this.bufferFile);
            }
            if (this.dataSource != null) {
                this.dataSource.setListener(null);
            }
            AppMethodBeat.m2505o(104483);
        }
    }

    static /* synthetic */ void access$200(CommonPlayer commonPlayer, int i, int i2, int i3) {
        AppMethodBeat.m2504i(104636);
        commonPlayer.onError(i, i2, i3);
        AppMethodBeat.m2505o(104636);
    }

    static /* synthetic */ String access$700(CommonPlayer commonPlayer, String str) {
        AppMethodBeat.m2504i(104637);
        String auxiliary = commonPlayer.auxiliary(str);
        AppMethodBeat.m2505o(104637);
        return auxiliary;
    }

    public CommonPlayer() {
        this(null, null, false);
    }

    public CommonPlayer(PlayerListenerCallback playerListenerCallback) {
        this(playerListenerCallback, null, false);
    }

    public CommonPlayer(PlayerListenerCallback playerListenerCallback, Looper looper, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(104596);
        this.mCallback = new ListPlayerListenerCallback();
        this.mAudioPlayer = null;
        this.currentState = 0;
        this.callback = new C242461();
        if (playerListenerCallback != null) {
            this.mCallback.add(playerListenerCallback);
        }
        this.eventLooper = looper;
        if (VERSION.SDK_INT >= 23 && z) {
            z2 = true;
        }
        this.mPreferMediaCodecDecode = z2;
        reset();
        AppMethodBeat.m2505o(104596);
    }

    public int getDuration() {
        long j = 0;
        AppMethodBeat.m2504i(104597);
        int i;
        if (this.mAudioPlayer != null) {
            this.mDuration = this.mAudioPlayer.getDuration();
            i = (int) this.mDuration;
            AppMethodBeat.m2505o(104597);
            return i;
        }
        Logger.m71021e(TAG, "getDuration() mAudioPlayer is null!");
        if (this.mDuration > 0) {
            j = this.mDuration;
        }
        i = (int) j;
        AppMethodBeat.m2505o(104597);
        return i;
    }

    public int getPlayerState() {
        return this.currentState;
    }

    public boolean isPlaying() {
        AppMethodBeat.m2504i(104598);
        if (this.mAudioPlayer == null) {
            Logger.m71021e(TAG, "isPlaying() mAudioPlayer is null!");
            AppMethodBeat.m2505o(104598);
            return false;
        } else if (this.mAudioPlayer.getPlayerState() == 4) {
            AppMethodBeat.m2505o(104598);
            return true;
        } else {
            AppMethodBeat.m2505o(104598);
            return false;
        }
    }

    public void pause() {
        AppMethodBeat.m2504i(104599);
        TransferStateTo(5);
        Logger.m71025i(TAG, auxiliary("[pause]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.pause();
        } else {
            Logger.m71021e(TAG, "pause() mAudioPlayer is null!");
        }
        notifyPauseSong();
        AppMethodBeat.m2505o(104599);
    }

    public void prepare() {
        AppMethodBeat.m2504i(104600);
        TransferStateTo(3);
        Logger.m71025i(TAG, auxiliary("[prepare]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.prepare();
            AppMethodBeat.m2505o(104600);
            return;
        }
        Logger.m71021e(TAG, "prepare() null mAudioPlayer!");
        AppMethodBeat.m2505o(104600);
    }

    public void prepareAsync() {
        AppMethodBeat.m2504i(104601);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support prepareAsync");
        AppMethodBeat.m2505o(104601);
        throw unSupportMethodException;
    }

    public void release() {
        AppMethodBeat.m2504i(104602);
        TransferStateTo(8);
        Logger.m71025i(TAG, auxiliary("[release]"));
        resetInternal();
        this.mCallback.clear();
        AppMethodBeat.m2505o(104602);
    }

    public void reset() {
        AppMethodBeat.m2504i(104603);
        TransferStateTo(0);
        Logger.m71025i(TAG, auxiliary("[reset]"));
        resetInternal();
        AppMethodBeat.m2505o(104603);
    }

    public void seekTo(int i) {
        AppMethodBeat.m2504i(104604);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.seek(i);
            AppMethodBeat.m2505o(104604);
            return;
        }
        Logger.m71021e(TAG, "seekTo() mAudioPlayer is null!");
        AppMethodBeat.m2505o(104604);
    }

    public void setDataSource(String str) {
        AppMethodBeat.m2504i(104605);
        if (str == null) {
            Logger.m71021e(TAG, "setDataSource() ERROR:the path is null!");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("the path is null!");
            AppMethodBeat.m2505o(104605);
            throw illegalArgumentException;
        }
        TransferStateTo(1);
        Logger.m71025i(TAG, "setDataSource, path: ".concat(String.valueOf(str)));
        this.mBufferPercentage = 100;
        setDataSourceInternal(new FileDataSource(str));
        AppMethodBeat.m2505o(104605);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.m2504i(104606);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
        AppMethodBeat.m2505o(104606);
        throw unSupportMethodException;
    }

    public void setVolume(float f, float f2) {
        AppMethodBeat.m2504i(104607);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setVolume(f, f2);
        }
        AppMethodBeat.m2505o(104607);
    }

    public void start() {
        AppMethodBeat.m2504i(104608);
        TransferStateTo(4);
        Logger.m71025i(TAG, auxiliary("[start]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.play();
        } else {
            Logger.m71021e(TAG, "start() mAudioPlayer is null!");
        }
        notifyStartPlaySong();
        AppMethodBeat.m2505o(104608);
    }

    public void stop() {
        AppMethodBeat.m2504i(104609);
        try {
            TransferStateTo(6);
            Logger.m71025i(TAG, auxiliary("[stop]"));
            if (this.mAudioPlayer != null) {
                this.mAudioPlayer.stop();
                AppMethodBeat.m2505o(104609);
                return;
            }
            Logger.m71021e(TAG, "stop() mAudioPlayer is null!");
            AppMethodBeat.m2505o(104609);
        } catch (Exception e) {
            Logger.m71024e(TAG, e);
            AppMethodBeat.m2505o(104609);
        }
    }

    public void setPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.m2504i(104610);
        this.mCallback.clear();
        this.mCallback.add(playerListenerCallback);
        AppMethodBeat.m2505o(104610);
    }

    public void addPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.m2504i(104611);
        this.mCallback.add(playerListenerCallback);
        AppMethodBeat.m2505o(104611);
    }

    public long getCurrentPosition() {
        AppMethodBeat.m2504i(104612);
        if (this.mAudioPlayer != null) {
            long curPosition = this.mAudioPlayer.getCurPosition();
            AppMethodBeat.m2505o(104612);
            return curPosition;
        }
        Logger.m71021e(TAG, "getCurrentPosition() mAudioPlayer is null!");
        AppMethodBeat.m2505o(104612);
        return 0;
    }

    public void flush() {
        AppMethodBeat.m2504i(104613);
        if (this.mAudioPlayer == null) {
            Logger.m71021e(TAG, "[getCurrentFrame] mAudioPlayer is null!");
            AppMethodBeat.m2505o(104613);
            return;
        }
        this.mAudioPlayer.flush();
        AppMethodBeat.m2505o(104613);
    }

    public long getDecodePosition() {
        AppMethodBeat.m2504i(104614);
        if (this.mAudioPlayer != null) {
            long curPositionByDecoder = this.mAudioPlayer.getCurPositionByDecoder();
            AppMethodBeat.m2505o(104614);
            return curPositionByDecoder;
        }
        Logger.m71021e(TAG, "getDecodePosition() ERROR : mAudioPlayer is null!");
        AppMethodBeat.m2505o(104614);
        return 0;
    }

    public void setDataSource(Context context, Uri uri) {
        AppMethodBeat.m2504i(104615);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            setDataSource(uri.toString());
            AppMethodBeat.m2505o(104615);
        } else if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
            setDataSource(new DefaultMediaHTTPService(), uri);
            AppMethodBeat.m2505o(104615);
        } else {
            if (!scheme.equalsIgnoreCase(C8741b.CONTENT)) {
                scheme.equalsIgnoreCase("file");
            }
            AppMethodBeat.m2505o(104615);
        }
    }

    public void setDataSource(IMediaHTTPService iMediaHTTPService, Uri uri) {
        AppMethodBeat.m2504i(104616);
        try {
            File createTempFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
            createTempFile.delete();
            if (createTempFile.createNewFile()) {
                String absolutePath = createTempFile.getAbsolutePath();
                CacheDataSource cacheDataSource = new CacheDataSource(new HttpDataSource(uri, null, iMediaHTTPService), new FileDataSource(absolutePath), new FileDataSink(absolutePath), insureEventLooper());
                this.openedResources = new OpenedResources();
                this.openedResources.bufferFile = createTempFile;
                this.openedResources.dataSource = cacheDataSource;
                cacheDataSource.setListener(new BufferListener(this, null));
                setDataSourceInternal(cacheDataSource);
                AppMethodBeat.m2505o(104616);
                return;
            }
            onError(90, 103, 0);
            AppMethodBeat.m2505o(104616);
        } catch (IOException e) {
            onError(90, 103, 0);
            AppMethodBeat.m2505o(104616);
        }
    }

    public void setDataSource(IDataSourceFactory iDataSourceFactory) {
        AppMethodBeat.m2504i(104617);
        if (iDataSourceFactory == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataSourceFactory is null!");
            AppMethodBeat.m2505o(104617);
            throw illegalArgumentException;
        }
        TransferStateTo(1);
        if (this.mPreferMediaCodecDecode) {
            this.mAudioPlayer = new CorePlayer(iDataSourceFactory.createDataSource(), null, this.callback, insureEventLooper(), new MediaCodecDecoder());
        } else {
            INativeDataSource createNativeDataSource = iDataSourceFactory.createNativeDataSource();
            if (createNativeDataSource != null) {
                this.mAudioPlayer = new CorePlayer(null, createNativeDataSource, this.callback, insureEventLooper(), new NativeDecoder());
            } else {
                this.mAudioPlayer = new CorePlayer(iDataSourceFactory.createDataSource(), null, this.callback, insureEventLooper(), new NativeDecoder());
            }
        }
        this.mAudioPlayer.setThreadName(iDataSourceFactory.toString());
        AppMethodBeat.m2505o(104617);
    }

    public void setDataSource(TrackInfo trackInfo) {
        AppMethodBeat.m2504i(104618);
        TransferStateTo(1);
        Logger.m71025i(TAG, "setDataSource, trackInfo.getUri: " + trackInfo.getUri());
        Logger.m71025i(TAG, "setDataSource, trackInfo.range: " + trackInfo.getRange().toString());
        this.mBufferPercentage = 100;
        PlayerListenerCallback trackDataSource = new TrackDataSource(trackInfo);
        List toCollection = this.mCallback.toCollection();
        this.mCallback.clear();
        this.mCallback.add(trackDataSource);
        this.mCallback.addAll(toCollection);
        TransferStateTo(1);
        this.mAudioPlayer = new TrackCorePlayer(new TracerDataSource(trackDataSource), this.callback, insureEventLooper());
        trackDataSource.setTrackStateCallback((TrackCorePlayer) this.mAudioPlayer);
        this.mAudioPlayer.setThreadName(trackDataSource.toString());
        AppMethodBeat.m2505o(104618);
    }

    public void setDataSource(Context context, final UriLoader uriLoader) {
        AppMethodBeat.m2504i(104619);
        setDataSource(new IDataSourceFactory() {
            public IDataSource createDataSource() {
                AppMethodBeat.m2504i(104712);
                CacheDataSource createFromUriLoader = Factory.createFromUriLoader(uriLoader);
                AppMethodBeat.m2505o(104712);
                return createFromUriLoader;
            }

            public INativeDataSource createNativeDataSource() {
                return null;
            }
        });
        AppMethodBeat.m2505o(104619);
    }

    public void setAudioStreamType(int i) {
        AppMethodBeat.m2504i(104620);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setAudioStreamType(i);
        }
        AppMethodBeat.m2505o(104620);
    }

    public void setWakeMode(Context context, int i) {
        AppMethodBeat.m2504i(104621);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support setWakeMode");
        AppMethodBeat.m2505o(104621);
        throw unSupportMethodException;
    }

    public long getCurrentPositionFromFile() {
        return 0;
    }

    public AudioInformation getCurrentAudioInformation() {
        AppMethodBeat.m2504i(104622);
        if (this.mAudioPlayer != null) {
            AudioInformation currentAudioInformation = this.mAudioPlayer.getCurrentAudioInformation();
            AppMethodBeat.m2505o(104622);
            return currentAudioInformation;
        }
        AppMethodBeat.m2505o(104622);
        return null;
    }

    public int getSessionId() {
        AppMethodBeat.m2504i(104623);
        if (this.mAudioPlayer != null) {
            int sessionId = this.mAudioPlayer.getSessionId();
            AppMethodBeat.m2505o(104623);
            return sessionId;
        }
        AppMethodBeat.m2505o(104623);
        return 0;
    }

    public boolean isSoftDecoder() {
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void setPlayerMode(int i) {
        AppMethodBeat.m2504i(104624);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setPlayerMode(i);
        }
        AppMethodBeat.m2505o(104624);
    }

    /* Access modifiers changed, original: 0000 */
    public int getPlayerMode() {
        AppMethodBeat.m2504i(104625);
        if (this.mAudioPlayer != null) {
            int playerMode = this.mAudioPlayer.getPlayerMode();
            AppMethodBeat.m2505o(104625);
            return playerMode;
        }
        AppMethodBeat.m2505o(104625);
        return 0;
    }

    public void addAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.m2504i(104626);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.addAudioListener(iAudioListener);
        }
        AppMethodBeat.m2505o(104626);
    }

    public void removeAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.m2504i(104627);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.removeAudioListener(iAudioListener);
        }
        AppMethodBeat.m2505o(104627);
    }

    public SeekTable createSeekTable() {
        AppMethodBeat.m2504i(104628);
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer == null) {
            IllegalStateException illegalStateException = new IllegalStateException("not initialized!");
            AppMethodBeat.m2505o(104628);
            throw illegalStateException;
        }
        SeekTable createSeekTable = corePlayer.createSeekTable();
        AppMethodBeat.m2505o(104628);
        return createSeekTable;
    }

    /* Access modifiers changed, original: protected */
    public void TransferStateTo(int i) {
        AppMethodBeat.m2504i(104629);
        Logger.m71025i("StateRunner", this.currentState + " -> " + i);
        this.currentState = i;
        if (this.mCallback != null) {
            this.mCallback.onStateChanged(this, i);
        }
        AppMethodBeat.m2505o(104629);
    }

    private Looper insureEventLooper() {
        AppMethodBeat.m2504i(104630);
        if (this.eventLooper == null) {
            HandlerThread handlerThread = new HandlerThread("CommonPlayer_EventHandler_" + hashCode());
            handlerThread.start();
            this.eventLooper = handlerThread.getLooper();
        }
        Looper looper = this.eventLooper;
        AppMethodBeat.m2505o(104630);
        return looper;
    }

    private void onError(int i, int i2) {
        AppMethodBeat.m2504i(104631);
        onError(i, i2, 0);
        AppMethodBeat.m2505o(104631);
    }

    private void onError(int i, int i2, int i3) {
        AppMethodBeat.m2504i(104632);
        TransferStateTo(9);
        Logger.m71021e(TAG, "onError prefer MediaCodec " + this.mPreferMediaCodecDecode);
        this.mCallback.onError(this, i, i2, i3);
        AppMethodBeat.m2505o(104632);
    }

    private void resetInternal() {
        AppMethodBeat.m2504i(104633);
        if (this.openedResources != null) {
            this.openedResources.release();
        }
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.release();
            this.mAudioPlayer = null;
        }
        if (!(this.eventLooper == null || this.eventLooper == Looper.getMainLooper())) {
            if (VERSION.SDK_INT >= 18) {
                this.eventLooper.quitSafely();
            } else {
                this.eventLooper.quit();
            }
            this.eventLooper = null;
        }
        this.mDuration = 0;
        this.mBufferPercentage = 0;
        AppMethodBeat.m2505o(104633);
    }

    private String auxiliary(String str) {
        AppMethodBeat.m2504i(104634);
        CorePlayer corePlayer = this.mAudioPlayer;
        String str2 = this.mPreferMediaCodecDecode ? "[MediaCodec]" : "";
        if (corePlayer == null) {
            str2 = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(104634);
            return str2;
        }
        str2 = "[" + corePlayer + "]" + str2 + str;
        AppMethodBeat.m2505o(104634);
        return str2;
    }

    public int getBufferedPercentage() {
        return this.mBufferPercentage;
    }

    private void setDataSourceInternal(IDataSource iDataSource) {
        AppMethodBeat.m2504i(104635);
        TransferStateTo(1);
        this.mAudioPlayer = new CorePlayer(new TracerDataSource(iDataSource), null, this.callback, insureEventLooper(), this.mPreferMediaCodecDecode ? new MediaCodecDecoder() : new NativeDecoder());
        this.mAudioPlayer.setThreadName(iDataSource.toString());
        AppMethodBeat.m2505o(104635);
    }
}
