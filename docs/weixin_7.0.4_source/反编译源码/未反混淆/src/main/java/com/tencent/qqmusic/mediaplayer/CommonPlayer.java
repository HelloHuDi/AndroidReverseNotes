package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
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

    class BufferListener implements Listener {
        private BufferListener() {
        }

        /* synthetic */ BufferListener(CommonPlayer commonPlayer, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onBufferStarted(long j) {
            AppMethodBeat.i(104689);
            Logger.i(CommonPlayer.TAG, CommonPlayer.access$700(CommonPlayer.this, "buffer started."));
            AppMethodBeat.o(104689);
        }

        public void onBufferEnded() {
            AppMethodBeat.i(104690);
            Logger.i(CommonPlayer.TAG, CommonPlayer.access$700(CommonPlayer.this, "buffer ended."));
            AppMethodBeat.o(104690);
        }

        public void onUpStreamTransfer(long j, long j2) {
            AppMethodBeat.i(104691);
            if (CommonPlayer.this.getPlayerState() == 2 || CommonPlayer.this.getPlayerState() == 4) {
                int round = (int) Math.round((((double) j) / ((double) j2)) * 100.0d);
                if (round == CommonPlayer.this.mBufferPercentage) {
                    AppMethodBeat.o(104691);
                    return;
                }
                CommonPlayer.this.mBufferPercentage = round;
                CommonPlayer.this.mCallback.onBufferingUpdate(CommonPlayer.this, CommonPlayer.this.mBufferPercentage);
                AppMethodBeat.o(104691);
                return;
            }
            AppMethodBeat.o(104691);
        }

        public long onStreamingError(IOException iOException) {
            AppMethodBeat.i(104692);
            Logger.e(CommonPlayer.TAG, CommonPlayer.access$700(CommonPlayer.this, "streaming error!"), (Throwable) iOException);
            AppMethodBeat.o(104692);
            return -1;
        }

        public void onStreamingFinished() {
            AppMethodBeat.i(104693);
            Logger.i(CommonPlayer.TAG, CommonPlayer.access$700(CommonPlayer.this, "streaming finished"));
            AppMethodBeat.o(104693);
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

        /* synthetic */ OpenedResources(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* Access modifiers changed, original: 0000 */
        public void release() {
            AppMethodBeat.i(104483);
            if (!(this.bufferFile == null || this.bufferFile.delete())) {
                Logger.w(CommonPlayer.TAG, "[release] failed to delete buffer file: " + this.bufferFile);
            }
            if (this.dataSource != null) {
                this.dataSource.setListener(null);
            }
            AppMethodBeat.o(104483);
        }
    }

    static /* synthetic */ void access$200(CommonPlayer commonPlayer, int i, int i2, int i3) {
        AppMethodBeat.i(104636);
        commonPlayer.onError(i, i2, i3);
        AppMethodBeat.o(104636);
    }

    static /* synthetic */ String access$700(CommonPlayer commonPlayer, String str) {
        AppMethodBeat.i(104637);
        String auxiliary = commonPlayer.auxiliary(str);
        AppMethodBeat.o(104637);
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
        AppMethodBeat.i(104596);
        this.mCallback = new ListPlayerListenerCallback();
        this.mAudioPlayer = null;
        this.currentState = 0;
        this.callback = new PlayerCallback() {
            public void playThreadStart(CorePlayer corePlayer) {
            }

            public void playerPrepared(CorePlayer corePlayer) {
                AppMethodBeat.i(104800);
                if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                    Logger.i(CommonPlayer.TAG, "playerPrepared() callback prepared");
                    CommonPlayer.this.TransferStateTo(2);
                    CommonPlayer.this.mCallback.onPrepared(CommonPlayer.this);
                    AppMethodBeat.o(104800);
                    return;
                }
                Logger.i(CommonPlayer.TAG, "different playerPrepared");
                AppMethodBeat.o(104800);
            }

            public void playerStopped(CorePlayer corePlayer) {
                AppMethodBeat.i(104801);
                if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                    Logger.i(CommonPlayer.TAG, "playerStopped() callback stopped");
                    AppMethodBeat.o(104801);
                    return;
                }
                Logger.i(CommonPlayer.TAG, "different playerStopped");
                AppMethodBeat.o(104801);
            }

            public void playerStarted(CorePlayer corePlayer) {
                AppMethodBeat.i(104802);
                if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                    Logger.i(CommonPlayer.TAG, "playerStarted() callback started");
                    CommonPlayer.this.mCallback.onStarted(CommonPlayer.this);
                    AppMethodBeat.o(104802);
                    return;
                }
                Logger.i(CommonPlayer.TAG, "different playerStarted");
                AppMethodBeat.o(104802);
            }

            public void playerSeekCompletion(CorePlayer corePlayer, int i) {
                AppMethodBeat.i(104803);
                if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                    Logger.i(CommonPlayer.TAG, "playerSeekCompletion() callback seek completion");
                    CommonPlayer.this.mCallback.onSeekComplete(CommonPlayer.this, i);
                    AppMethodBeat.o(104803);
                    return;
                }
                Logger.i(CommonPlayer.TAG, "different playerSeekCompletion");
                AppMethodBeat.o(104803);
            }

            public void playerPaused(CorePlayer corePlayer) {
                AppMethodBeat.i(104804);
                if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                    Logger.i(CommonPlayer.TAG, "playerPaused() callback paused");
                    AppMethodBeat.o(104804);
                    return;
                }
                Logger.i(CommonPlayer.TAG, "different playerPaused");
                AppMethodBeat.o(104804);
            }

            public void playerException(CorePlayer corePlayer, int i, int i2, int i3) {
                AppMethodBeat.i(104805);
                if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                    Logger.e(CommonPlayer.TAG, "playerException() callback exception what = " + i + ",extra = " + i2 + " mAudioPlayer:" + CommonPlayer.this.mAudioPlayer);
                    if (CommonPlayer.this.mAudioPlayer != null) {
                        Logger.e(CommonPlayer.TAG, "handleMessage state = ".concat(String.valueOf(CommonPlayer.this.mAudioPlayer.getPlayerState())));
                        Logger.e(CommonPlayer.TAG, "handleMessage isInit = " + CommonPlayer.this.mAudioPlayer.isInit() + ",isStartDecode = " + CommonPlayer.this.mAudioPlayer.hasDecodeData() + ",decodeSuccess = " + CommonPlayer.this.mAudioPlayer.hasDecodeDataSuccess());
                    }
                    CommonPlayer.access$200(CommonPlayer.this, i, i2, i3);
                    AppMethodBeat.o(104805);
                    return;
                }
                Logger.i(CommonPlayer.TAG, "different playerException");
                AppMethodBeat.o(104805);
            }

            public void playerEnded(CorePlayer corePlayer) {
                AppMethodBeat.i(104806);
                if (CommonPlayer.this.mAudioPlayer == corePlayer) {
                    Logger.i(CommonPlayer.TAG, "playerEnded() callback ended");
                    CommonPlayer.this.TransferStateTo(7);
                    CommonPlayer.this.mCallback.onCompletion(CommonPlayer.this);
                    AppMethodBeat.o(104806);
                    return;
                }
                Logger.i(CommonPlayer.TAG, "different playerEnded");
                AppMethodBeat.o(104806);
            }
        };
        if (playerListenerCallback != null) {
            this.mCallback.add(playerListenerCallback);
        }
        this.eventLooper = looper;
        if (VERSION.SDK_INT >= 23 && z) {
            z2 = true;
        }
        this.mPreferMediaCodecDecode = z2;
        reset();
        AppMethodBeat.o(104596);
    }

    public int getDuration() {
        long j = 0;
        AppMethodBeat.i(104597);
        int i;
        if (this.mAudioPlayer != null) {
            this.mDuration = this.mAudioPlayer.getDuration();
            i = (int) this.mDuration;
            AppMethodBeat.o(104597);
            return i;
        }
        Logger.e(TAG, "getDuration() mAudioPlayer is null!");
        if (this.mDuration > 0) {
            j = this.mDuration;
        }
        i = (int) j;
        AppMethodBeat.o(104597);
        return i;
    }

    public int getPlayerState() {
        return this.currentState;
    }

    public boolean isPlaying() {
        AppMethodBeat.i(104598);
        if (this.mAudioPlayer == null) {
            Logger.e(TAG, "isPlaying() mAudioPlayer is null!");
            AppMethodBeat.o(104598);
            return false;
        } else if (this.mAudioPlayer.getPlayerState() == 4) {
            AppMethodBeat.o(104598);
            return true;
        } else {
            AppMethodBeat.o(104598);
            return false;
        }
    }

    public void pause() {
        AppMethodBeat.i(104599);
        TransferStateTo(5);
        Logger.i(TAG, auxiliary("[pause]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.pause();
        } else {
            Logger.e(TAG, "pause() mAudioPlayer is null!");
        }
        notifyPauseSong();
        AppMethodBeat.o(104599);
    }

    public void prepare() {
        AppMethodBeat.i(104600);
        TransferStateTo(3);
        Logger.i(TAG, auxiliary("[prepare]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.prepare();
            AppMethodBeat.o(104600);
            return;
        }
        Logger.e(TAG, "prepare() null mAudioPlayer!");
        AppMethodBeat.o(104600);
    }

    public void prepareAsync() {
        AppMethodBeat.i(104601);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support prepareAsync");
        AppMethodBeat.o(104601);
        throw unSupportMethodException;
    }

    public void release() {
        AppMethodBeat.i(104602);
        TransferStateTo(8);
        Logger.i(TAG, auxiliary("[release]"));
        resetInternal();
        this.mCallback.clear();
        AppMethodBeat.o(104602);
    }

    public void reset() {
        AppMethodBeat.i(104603);
        TransferStateTo(0);
        Logger.i(TAG, auxiliary("[reset]"));
        resetInternal();
        AppMethodBeat.o(104603);
    }

    public void seekTo(int i) {
        AppMethodBeat.i(104604);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.seek(i);
            AppMethodBeat.o(104604);
            return;
        }
        Logger.e(TAG, "seekTo() mAudioPlayer is null!");
        AppMethodBeat.o(104604);
    }

    public void setDataSource(String str) {
        AppMethodBeat.i(104605);
        if (str == null) {
            Logger.e(TAG, "setDataSource() ERROR:the path is null!");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("the path is null!");
            AppMethodBeat.o(104605);
            throw illegalArgumentException;
        }
        TransferStateTo(1);
        Logger.i(TAG, "setDataSource, path: ".concat(String.valueOf(str)));
        this.mBufferPercentage = 100;
        setDataSourceInternal(new FileDataSource(str));
        AppMethodBeat.o(104605);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(104606);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support setDataSource by FileDescriptor");
        AppMethodBeat.o(104606);
        throw unSupportMethodException;
    }

    public void setVolume(float f, float f2) {
        AppMethodBeat.i(104607);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setVolume(f, f2);
        }
        AppMethodBeat.o(104607);
    }

    public void start() {
        AppMethodBeat.i(104608);
        TransferStateTo(4);
        Logger.i(TAG, auxiliary("[start]"));
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.play();
        } else {
            Logger.e(TAG, "start() mAudioPlayer is null!");
        }
        notifyStartPlaySong();
        AppMethodBeat.o(104608);
    }

    public void stop() {
        AppMethodBeat.i(104609);
        try {
            TransferStateTo(6);
            Logger.i(TAG, auxiliary("[stop]"));
            if (this.mAudioPlayer != null) {
                this.mAudioPlayer.stop();
                AppMethodBeat.o(104609);
                return;
            }
            Logger.e(TAG, "stop() mAudioPlayer is null!");
            AppMethodBeat.o(104609);
        } catch (Exception e) {
            Logger.e(TAG, e);
            AppMethodBeat.o(104609);
        }
    }

    public void setPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.i(104610);
        this.mCallback.clear();
        this.mCallback.add(playerListenerCallback);
        AppMethodBeat.o(104610);
    }

    public void addPlayerListenerCallback(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.i(104611);
        this.mCallback.add(playerListenerCallback);
        AppMethodBeat.o(104611);
    }

    public long getCurrentPosition() {
        AppMethodBeat.i(104612);
        if (this.mAudioPlayer != null) {
            long curPosition = this.mAudioPlayer.getCurPosition();
            AppMethodBeat.o(104612);
            return curPosition;
        }
        Logger.e(TAG, "getCurrentPosition() mAudioPlayer is null!");
        AppMethodBeat.o(104612);
        return 0;
    }

    public void flush() {
        AppMethodBeat.i(104613);
        if (this.mAudioPlayer == null) {
            Logger.e(TAG, "[getCurrentFrame] mAudioPlayer is null!");
            AppMethodBeat.o(104613);
            return;
        }
        this.mAudioPlayer.flush();
        AppMethodBeat.o(104613);
    }

    public long getDecodePosition() {
        AppMethodBeat.i(104614);
        if (this.mAudioPlayer != null) {
            long curPositionByDecoder = this.mAudioPlayer.getCurPositionByDecoder();
            AppMethodBeat.o(104614);
            return curPositionByDecoder;
        }
        Logger.e(TAG, "getDecodePosition() ERROR : mAudioPlayer is null!");
        AppMethodBeat.o(104614);
        return 0;
    }

    public void setDataSource(Context context, Uri uri) {
        AppMethodBeat.i(104615);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            setDataSource(uri.toString());
            AppMethodBeat.o(104615);
        } else if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
            setDataSource(new DefaultMediaHTTPService(), uri);
            AppMethodBeat.o(104615);
        } else {
            if (!scheme.equalsIgnoreCase(b.CONTENT)) {
                scheme.equalsIgnoreCase("file");
            }
            AppMethodBeat.o(104615);
        }
    }

    public void setDataSource(IMediaHTTPService iMediaHTTPService, Uri uri) {
        AppMethodBeat.i(104616);
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
                AppMethodBeat.o(104616);
                return;
            }
            onError(90, 103, 0);
            AppMethodBeat.o(104616);
        } catch (IOException e) {
            onError(90, 103, 0);
            AppMethodBeat.o(104616);
        }
    }

    public void setDataSource(IDataSourceFactory iDataSourceFactory) {
        AppMethodBeat.i(104617);
        if (iDataSourceFactory == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataSourceFactory is null!");
            AppMethodBeat.o(104617);
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
        AppMethodBeat.o(104617);
    }

    public void setDataSource(TrackInfo trackInfo) {
        AppMethodBeat.i(104618);
        TransferStateTo(1);
        Logger.i(TAG, "setDataSource, trackInfo.getUri: " + trackInfo.getUri());
        Logger.i(TAG, "setDataSource, trackInfo.range: " + trackInfo.getRange().toString());
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
        AppMethodBeat.o(104618);
    }

    public void setDataSource(Context context, final UriLoader uriLoader) {
        AppMethodBeat.i(104619);
        setDataSource(new IDataSourceFactory() {
            public IDataSource createDataSource() {
                AppMethodBeat.i(104712);
                CacheDataSource createFromUriLoader = Factory.createFromUriLoader(uriLoader);
                AppMethodBeat.o(104712);
                return createFromUriLoader;
            }

            public INativeDataSource createNativeDataSource() {
                return null;
            }
        });
        AppMethodBeat.o(104619);
    }

    public void setAudioStreamType(int i) {
        AppMethodBeat.i(104620);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setAudioStreamType(i);
        }
        AppMethodBeat.o(104620);
    }

    public void setWakeMode(Context context, int i) {
        AppMethodBeat.i(104621);
        UnSupportMethodException unSupportMethodException = new UnSupportMethodException("Soft decode player cannot support setWakeMode");
        AppMethodBeat.o(104621);
        throw unSupportMethodException;
    }

    public long getCurrentPositionFromFile() {
        return 0;
    }

    public AudioInformation getCurrentAudioInformation() {
        AppMethodBeat.i(104622);
        if (this.mAudioPlayer != null) {
            AudioInformation currentAudioInformation = this.mAudioPlayer.getCurrentAudioInformation();
            AppMethodBeat.o(104622);
            return currentAudioInformation;
        }
        AppMethodBeat.o(104622);
        return null;
    }

    public int getSessionId() {
        AppMethodBeat.i(104623);
        if (this.mAudioPlayer != null) {
            int sessionId = this.mAudioPlayer.getSessionId();
            AppMethodBeat.o(104623);
            return sessionId;
        }
        AppMethodBeat.o(104623);
        return 0;
    }

    public boolean isSoftDecoder() {
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void setPlayerMode(int i) {
        AppMethodBeat.i(104624);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.setPlayerMode(i);
        }
        AppMethodBeat.o(104624);
    }

    /* Access modifiers changed, original: 0000 */
    public int getPlayerMode() {
        AppMethodBeat.i(104625);
        if (this.mAudioPlayer != null) {
            int playerMode = this.mAudioPlayer.getPlayerMode();
            AppMethodBeat.o(104625);
            return playerMode;
        }
        AppMethodBeat.o(104625);
        return 0;
    }

    public void addAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.i(104626);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.addAudioListener(iAudioListener);
        }
        AppMethodBeat.o(104626);
    }

    public void removeAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.i(104627);
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer.removeAudioListener(iAudioListener);
        }
        AppMethodBeat.o(104627);
    }

    public SeekTable createSeekTable() {
        AppMethodBeat.i(104628);
        CorePlayer corePlayer = this.mAudioPlayer;
        if (corePlayer == null) {
            IllegalStateException illegalStateException = new IllegalStateException("not initialized!");
            AppMethodBeat.o(104628);
            throw illegalStateException;
        }
        SeekTable createSeekTable = corePlayer.createSeekTable();
        AppMethodBeat.o(104628);
        return createSeekTable;
    }

    /* Access modifiers changed, original: protected */
    public void TransferStateTo(int i) {
        AppMethodBeat.i(104629);
        Logger.i("StateRunner", this.currentState + " -> " + i);
        this.currentState = i;
        if (this.mCallback != null) {
            this.mCallback.onStateChanged(this, i);
        }
        AppMethodBeat.o(104629);
    }

    private Looper insureEventLooper() {
        AppMethodBeat.i(104630);
        if (this.eventLooper == null) {
            HandlerThread handlerThread = new HandlerThread("CommonPlayer_EventHandler_" + hashCode());
            handlerThread.start();
            this.eventLooper = handlerThread.getLooper();
        }
        Looper looper = this.eventLooper;
        AppMethodBeat.o(104630);
        return looper;
    }

    private void onError(int i, int i2) {
        AppMethodBeat.i(104631);
        onError(i, i2, 0);
        AppMethodBeat.o(104631);
    }

    private void onError(int i, int i2, int i3) {
        AppMethodBeat.i(104632);
        TransferStateTo(9);
        Logger.e(TAG, "onError prefer MediaCodec " + this.mPreferMediaCodecDecode);
        this.mCallback.onError(this, i, i2, i3);
        AppMethodBeat.o(104632);
    }

    private void resetInternal() {
        AppMethodBeat.i(104633);
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
        AppMethodBeat.o(104633);
    }

    private String auxiliary(String str) {
        AppMethodBeat.i(104634);
        CorePlayer corePlayer = this.mAudioPlayer;
        String str2 = this.mPreferMediaCodecDecode ? "[MediaCodec]" : "";
        if (corePlayer == null) {
            str2 = BuildConfig.COMMAND;
            AppMethodBeat.o(104634);
            return str2;
        }
        str2 = "[" + corePlayer + "]" + str2 + str;
        AppMethodBeat.o(104634);
        return str2;
    }

    public int getBufferedPercentage() {
        return this.mBufferPercentage;
    }

    private void setDataSourceInternal(IDataSource iDataSource) {
        AppMethodBeat.i(104635);
        TransferStateTo(1);
        this.mAudioPlayer = new CorePlayer(new TracerDataSource(iDataSource), null, this.callback, insureEventLooper(), this.mPreferMediaCodecDecode ? new MediaCodecDecoder() : new NativeDecoder());
        this.mAudioPlayer.setThreadName(iDataSource.toString());
        AppMethodBeat.o(104635);
    }
}
