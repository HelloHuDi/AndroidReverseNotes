package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.g.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class TXCStreamDownloader extends com.tencent.liteav.basic.module.a implements com.tencent.liteav.basic.d.a, com.tencent.liteav.network.TXIStreamDownloader.a, com.tencent.liteav.network.d.a, f {
    public static final String TAG = "TXCStreamDownloader";
    public static final int TXE_DOWNLOAD_ERROR_ALLADDRESS_FAILED = 12031;
    public static final int TXE_DOWNLOAD_ERROR_CONNECT_FAILED = 12011;
    public static final int TXE_DOWNLOAD_ERROR_DISCONNECT = 12012;
    public static final int TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL = 12030;
    public static final int TXE_DOWNLOAD_ERROR_NET_RECONNECT = 12015;
    public static final int TXE_DOWNLOAD_ERROR_READ_FAILED = 12013;
    public static final int TXE_DOWNLOAD_ERROR_WRITE_FAILED = 12014;
    public static final int TXE_DOWNLOAD_INFO_CONNECT_END = 12007;
    public static final int TXE_DOWNLOAD_INFO_CONNECT_FAILED = 12004;
    public static final int TXE_DOWNLOAD_INFO_CONNECT_SUCCESS = 12001;
    public static final int TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL = 12005;
    public static final int TXE_DOWNLOAD_INFO_PLAY_BEGIN = 12008;
    public static final int TXE_DOWNLOAD_INFO_SERVER_REFUSE = 12009;
    private g mAccUrlFetcher;
    private Context mApplicationContext;
    private int mChannelType = 0;
    private long mCurrentNalTs = 0;
    private int mDownloadFormat = 1;
    private TXIStreamDownloader mDownloader = null;
    private boolean mDownloaderRunning = false;
    private boolean mEnableMessage = false;
    private boolean mEnableNearestIP = false;
    private Handler mHandler = null;
    protected Map<String, String> mHeaders;
    private DownloadStats mLastDownloadStats = null;
    private long mLastIFramelTs = 0;
    private long mLastTimeStamp = 0;
    private f mListener = null;
    private byte[] mListenerLock = new byte[0];
    private com.tencent.liteav.basic.d.a mNotifyListener = null;
    private String mOriginPlayUrl = "";
    private boolean mRecvFirstNal = false;
    private Runnable mReportNetStatusRunnalbe = new Runnable() {
        public void run() {
            AppMethodBeat.i(67583);
            TXCStreamDownloader.access$1100(TXCStreamDownloader.this);
            AppMethodBeat.o(67583);
        }
    };
    private d mStreamSwitcher = null;
    private long mSwitchStartTime = 0;

    public static class DownloadStats {
        public long afterParseAudioBytes;
        public long afterParseVideoBytes;
        public long beforeParseAudioBytes;
        public long beforeParseVideoBytes;
        public long connTS;
        public long dnsTS;
        public long firstAudioTS;
        public long firstVideoTS;
        public String serverIP;
        public long startTS;
    }

    public static class a {
        public String a;
        public String b;
        public String c;
        public int d;
        public String e;
        public boolean f;
    }

    static /* synthetic */ void access$1000(TXCStreamDownloader tXCStreamDownloader, String str, boolean z) {
        AppMethodBeat.i(67562);
        tXCStreamDownloader.playStreamWithRawUrl(str, z);
        AppMethodBeat.o(67562);
    }

    static /* synthetic */ void access$1100(TXCStreamDownloader tXCStreamDownloader) {
        AppMethodBeat.i(67563);
        tXCStreamDownloader.reportNetStatus();
        AppMethodBeat.o(67563);
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        int i2 = 3002;
        AppMethodBeat.i(67546);
        synchronized (this.mListenerLock) {
            try {
                if (this.mNotifyListener != null) {
                    Bundle bundle2 = new Bundle();
                    switch (i) {
                        case TXE_DOWNLOAD_INFO_CONNECT_SUCCESS /*12001*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "已连接服务器");
                            i2 = 2001;
                            break;
                        case TXE_DOWNLOAD_INFO_CONNECT_FAILED /*12004*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "连接服务器失败");
                            break;
                        case TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL /*12005*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "RTMP服务器握手失败");
                            i2 = 3003;
                            break;
                        case TXE_DOWNLOAD_INFO_CONNECT_END /*12007*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "连接结束");
                            i2 = i;
                            break;
                        case TXE_DOWNLOAD_INFO_PLAY_BEGIN /*12008*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "开始拉流");
                            i2 = 2002;
                            break;
                        case TXE_DOWNLOAD_INFO_SERVER_REFUSE /*12009*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "服务器拒绝连接请求");
                            i2 = TXLiveConstants.PLAY_WARNING_RECONNECT;
                            break;
                        case TXE_DOWNLOAD_ERROR_CONNECT_FAILED /*12011*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "连接服务器失败");
                            break;
                        case TXE_DOWNLOAD_ERROR_DISCONNECT /*12012*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "经多次自动重连失败，放弃连接");
                            i2 = TXLiveConstants.PLAY_ERR_NET_DISCONNECT;
                            break;
                        case TXE_DOWNLOAD_ERROR_READ_FAILED /*12013*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "读数据错误，网络连接断开");
                            i2 = 3005;
                            break;
                        case TXE_DOWNLOAD_ERROR_WRITE_FAILED /*12014*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "写数据错误，网络连接断开");
                            i2 = 3005;
                            break;
                        case TXE_DOWNLOAD_ERROR_NET_RECONNECT /*12015*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "启动网络重连");
                            i2 = TXLiveConstants.PLAY_WARNING_RECONNECT;
                            break;
                        case TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL /*12030*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "获取加速拉流地址失败");
                            i2 = TXLiveConstants.PLAY_ERR_GET_RTMP_ACC_URL_FAIL;
                            break;
                        case TXE_DOWNLOAD_ERROR_ALLADDRESS_FAILED /*12031*/:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "所有拉流地址尝试失败,可以放弃治疗");
                            i2 = TXLiveConstants.PLAY_ERR_NET_DISCONNECT;
                            break;
                        default:
                            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "UNKNOWN event = ".concat(String.valueOf(i)));
                            i2 = i;
                            break;
                    }
                    String str = "";
                    if (bundle != null) {
                        str = bundle.getString(TXLiveConstants.EVT_DESCRIPTION, "");
                    }
                    if (!(str == null || str.isEmpty())) {
                        bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, str);
                    }
                    bundle2.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                    this.mNotifyListener.onNotifyEvent(i2, bundle2);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(67546);
            }
        }
        if (i == TXE_DOWNLOAD_INFO_CONNECT_SUCCESS) {
            reportNetStatusInternal();
        }
        AppMethodBeat.o(67546);
    }

    private void tryResetRetryCount() {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryTimes = 0;
        }
    }

    public void onPullAudio(com.tencent.liteav.basic.g.a aVar) {
        AppMethodBeat.i(67547);
        tryResetRetryCount();
        synchronized (this.mListenerLock) {
            try {
                if (this.mListener != null) {
                    this.mListener.onPullAudio(aVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67547);
            }
        }
    }

    public void onPullNAL(b bVar) {
        AppMethodBeat.i(67548);
        tryResetRetryCount();
        if (!this.mRecvFirstNal) {
            reportNetStatusInternal();
            this.mRecvFirstNal = true;
        }
        synchronized (this.mListenerLock) {
            try {
                this.mCurrentNalTs = bVar.g;
                if (bVar.b == 0) {
                    this.mLastIFramelTs = bVar.g;
                }
                if (this.mListener != null) {
                    this.mListener.onPullNAL(bVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67548);
            }
        }
    }

    public void onRestartDownloader() {
        AppMethodBeat.i(67549);
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67545);
                    TXCStreamDownloader.this.stop();
                    TXCStreamDownloader.this.start(TXCStreamDownloader.this.mOriginPlayUrl, TXCStreamDownloader.this.mEnableNearestIP, TXCStreamDownloader.this.mChannelType, TXCStreamDownloader.this.mEnableMessage);
                    AppMethodBeat.o(67545);
                }
            });
        }
        AppMethodBeat.o(67549);
    }

    public void setListener(f fVar) {
        synchronized (this.mListenerLock) {
            this.mListener = fVar;
        }
    }

    public void setNotifyListener(com.tencent.liteav.basic.d.a aVar) {
        synchronized (this.mListenerLock) {
            this.mNotifyListener = aVar;
        }
    }

    public void onSwitchFinish(TXIStreamDownloader tXIStreamDownloader, boolean z) {
        AppMethodBeat.i(67550);
        synchronized (this.mListenerLock) {
            try {
                int currentTimeMillis = (int) (System.currentTimeMillis() - this.mSwitchStartTime);
                this.mSwitchStartTime = 0;
                Bundle bundle = new Bundle();
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                if (z) {
                    this.mDownloader = tXIStreamDownloader;
                    this.mDownloader.setListener(this);
                    this.mDownloader.setNotifyListener(this);
                    this.mDownloader.setRestartListener(this);
                    bundle.putInt("EVT_ID", 2015);
                    bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "切换分辨率成功");
                    if (this.mNotifyListener != null) {
                        this.mNotifyListener.onNotifyEvent(2015, bundle);
                    }
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.by, currentTimeMillis, "");
                } else {
                    bundle.putInt("EVT_ID", 2015);
                    bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "切换分辨率失败");
                    if (this.mNotifyListener != null) {
                        this.mNotifyListener.onNotifyEvent(2015, bundle);
                    }
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bz);
                }
                this.mStreamSwitcher = null;
            } finally {
                AppMethodBeat.o(67550);
            }
        }
    }

    static {
        AppMethodBeat.i(67564);
        com.tencent.liteav.basic.util.b.e();
        AppMethodBeat.o(67564);
    }

    public TXCStreamDownloader(Context context, int i) {
        AppMethodBeat.i(67551);
        if (i == 0) {
            this.mDownloader = new TXCFLVDownloader(context);
        } else if (i == 1 || i == 4) {
            this.mDownloader = new TXCRTMPDownloader(context);
        }
        if (this.mDownloader != null) {
            this.mDownloader.setListener(this);
            this.mDownloader.setNotifyListener(this);
            this.mDownloader.setRestartListener(this);
        }
        this.mDownloadFormat = i;
        this.mAccUrlFetcher = new g(context);
        this.mApplicationContext = context;
        if (this.mApplicationContext != null) {
            this.mHandler = new Handler(this.mApplicationContext.getMainLooper());
        }
        AppMethodBeat.o(67551);
    }

    public void setRetryTimes(int i) {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryLimit = i;
        }
    }

    public void setRetryInterval(int i) {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryInterval = i;
        }
    }

    public int start(final String str, boolean z, int i, final boolean z2) {
        boolean z3 = true;
        AppMethodBeat.i(67552);
        this.mDownloaderRunning = true;
        this.mRecvFirstNal = false;
        this.mOriginPlayUrl = str;
        this.mEnableNearestIP = z;
        this.mChannelType = i;
        this.mEnableMessage = z2;
        setStatusValue(7116, Long.valueOf(0));
        setStatusValue(7117, Long.valueOf(0));
        setStatusValue(7118, Long.valueOf(0));
        Vector vector;
        if (str.startsWith("room")) {
            setStatusValue(7116, Long.valueOf(1));
            setStatusValue(7112, Long.valueOf(2));
            if (this.mDownloader != null) {
                vector = new Vector();
                vector.add(new e(str, true));
                this.mDownloader.setOriginUrl(str);
                this.mDownloader.startDownload(vector, false, false, z2);
            }
            if (this.mHandler != null) {
                this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            }
            AppMethodBeat.o(67552);
        } else if (z && this.mDownloadFormat == 4) {
            int a = this.mAccUrlFetcher.a(str, i, new com.tencent.liteav.network.g.a() {
                public void a(int i, String str, Vector<e> vector) {
                    AppMethodBeat.i(67533);
                    if (i != 0 || vector == null || vector.isEmpty()) {
                        TXCStreamDownloader.this.onNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL, null);
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.ay, i, str);
                        TXCLog.e(TXCStreamDownloader.TAG, "getAccelerateStreamPlayUrl failed, play stream with raw url");
                        if (TXCStreamDownloader.this.mDownloaderRunning) {
                            TXCStreamDownloader.access$1000(TXCStreamDownloader.this, str, z2);
                            if (TXCStreamDownloader.this.mHandler != null) {
                                TXCStreamDownloader.this.mHandler.postDelayed(TXCStreamDownloader.this.mReportNetStatusRunnalbe, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                            }
                        }
                        AppMethodBeat.o(67533);
                    } else if (TXCStreamDownloader.this.mDownloaderRunning) {
                        if (TXCStreamDownloader.this.mDownloader != null) {
                            int i2;
                            int i3 = 0;
                            Iterator it = vector.iterator();
                            while (true) {
                                i2 = i3;
                                if (!it.hasNext()) {
                                    break;
                                }
                                e eVar = (e) it.next();
                                if (eVar != null && eVar.b && eVar.a != null && eVar.a.length() > 0) {
                                    i2++;
                                }
                                i3 = i2;
                            }
                            TXCStreamDownloader.this.setStatusValue(7116, Long.valueOf((long) i2));
                            TXCStreamDownloader.this.setStatusValue(7112, Long.valueOf(2));
                            TXCStreamDownloader.this.mDownloader.setOriginUrl(str);
                            TXCStreamDownloader.this.mDownloader.startDownload(vector, true, true, z2);
                        }
                        if (TXCStreamDownloader.this.mHandler != null) {
                            TXCStreamDownloader.this.mHandler.postDelayed(TXCStreamDownloader.this.mReportNetStatusRunnalbe, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                        }
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.ay, i, TXCStreamDownloader.this.mAccUrlFetcher.b());
                        AppMethodBeat.o(67533);
                    } else {
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.ay, -4, "livePlayer have been stopped");
                        AppMethodBeat.o(67533);
                    }
                }
            });
            if (a != 0) {
                if (a == -1) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.ay, a, "invalid playUrl");
                } else if (a == -2) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.ay, a, "invalid streamID");
                } else if (a == -3) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.ay, a, "invalid signature");
                }
                TXCLog.e(TAG, "getAccelerateStreamPlayUrl failed, result = " + a + ", play stream with raw url");
                onNotifyEvent(TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL, null);
                playStreamWithRawUrl(str, z2);
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                }
            }
            AppMethodBeat.o(67552);
        } else {
            if (this.mDownloader != null) {
                setStatusValue(7112, Long.valueOf(1));
                vector = new Vector();
                vector.add(new e(str, false));
                this.mDownloader.setOriginUrl(str);
                TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
                if (this.mDownloadFormat != 4) {
                    z3 = false;
                }
                tXIStreamDownloader.startDownload(vector, z3, z, z2);
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                }
            }
            AppMethodBeat.o(67552);
        }
        return 0;
    }

    private void playStreamWithRawUrl(String str, boolean z) {
        AppMethodBeat.i(67553);
        if (this.mDownloader != null) {
            if (str != null && ((str.startsWith("http://") || str.startsWith("https://")) && str.contains(".flv"))) {
                int i = this.mDownloader.connectRetryLimit;
                int i2 = this.mDownloader.connectRetryInterval;
                this.mDownloader = null;
                this.mDownloader = new TXCFLVDownloader(this.mApplicationContext);
                this.mDownloader.setListener(this);
                this.mDownloader.setNotifyListener(this);
                this.mDownloader.setRestartListener(this);
                this.mDownloader.connectRetryLimit = i;
                this.mDownloader.connectRetryInterval = i2;
                this.mDownloader.setHeaders(this.mHeaders);
            }
            setStatusValue(7112, Long.valueOf(1));
            Vector vector = new Vector();
            vector.add(new e(str, false));
            this.mDownloader.setOriginUrl(str);
            this.mDownloader.startDownload(vector, false, false, z);
        }
        AppMethodBeat.o(67553);
    }

    public void stop() {
        AppMethodBeat.i(67554);
        this.mDownloaderRunning = false;
        this.mRecvFirstNal = false;
        if (this.mDownloader != null) {
            this.mDownloader.stopDownload();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mReportNetStatusRunnalbe);
        }
        synchronized (this.mListenerLock) {
            try {
                if (this.mStreamSwitcher != null) {
                    this.mStreamSwitcher.a(null);
                    this.mStreamSwitcher.a();
                    this.mStreamSwitcher = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67554);
            }
        }
    }

    public boolean switchStream(String str) {
        AppMethodBeat.i(67555);
        synchronized (this.mListenerLock) {
            try {
                if (this.mStreamSwitcher != null) {
                    TXCLog.w(TAG, "stream_switch stream is changing ignore this change");
                } else {
                    TXCFLVDownloader tXCFLVDownloader = new TXCFLVDownloader(this.mApplicationContext);
                    tXCFLVDownloader.connectRetryLimit = this.mDownloader.connectRetryLimit;
                    tXCFLVDownloader.connectRetryInterval = this.mDownloader.connectRetryInterval;
                    tXCFLVDownloader.setHeaders(this.mHeaders);
                    this.mStreamSwitcher = new d(this);
                    this.mStreamSwitcher.a((f) this);
                    this.mStreamSwitcher.a(this.mDownloader, tXCFLVDownloader, this.mCurrentNalTs, this.mLastIFramelTs, str);
                    this.mSwitchStartTime = System.currentTimeMillis();
                    AppMethodBeat.o(67555);
                    return true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67555);
            }
        }
        return false;
    }

    private DownloadStats getDownloadStats() {
        AppMethodBeat.i(67556);
        if (this.mDownloader != null) {
            DownloadStats downloadStats = this.mDownloader.getDownloadStats();
            AppMethodBeat.o(67556);
            return downloadStats;
        }
        AppMethodBeat.o(67556);
        return null;
    }

    private a getRealTimeStreamInfo() {
        AppMethodBeat.i(67557);
        a aVar = new a();
        if (this.mAccUrlFetcher != null) {
            aVar.b = this.mAccUrlFetcher.a();
            aVar.c = this.mAccUrlFetcher.b();
            aVar.d = this.mAccUrlFetcher.c();
            aVar.e = this.mAccUrlFetcher.d();
        }
        if (this.mDownloader != null) {
            aVar.a = this.mDownloader.getCurrentStreamUrl();
            aVar.f = this.mDownloader.isQuicChannel();
        }
        AppMethodBeat.o(67557);
        return aVar;
    }

    private void reportNetStatus() {
        AppMethodBeat.i(67558);
        reportNetStatusInternal();
        this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(67558);
    }

    private void reportNetStatusInternal() {
        AppMethodBeat.i(67559);
        long timeTick = TXCTimeUtil.getTimeTick();
        long j = timeTick - this.mLastTimeStamp;
        DownloadStats downloadStats = getDownloadStats();
        a realTimeStreamInfo = getRealTimeStreamInfo();
        if (downloadStats != null) {
            long longValue;
            long j2;
            if (this.mLastDownloadStats != null) {
                long longValue2 = getSpeed(this.mLastDownloadStats.afterParseVideoBytes, downloadStats.afterParseVideoBytes, j).longValue();
                longValue = getSpeed(this.mLastDownloadStats.afterParseAudioBytes, downloadStats.afterParseAudioBytes, j).longValue();
                j2 = longValue2;
            } else {
                longValue = 0;
                j2 = 0;
            }
            setStatusValue(7101, Long.valueOf(j2));
            setStatusValue(7102, Long.valueOf(longValue));
            setStatusValue(7103, Long.valueOf(downloadStats.firstVideoTS));
            setStatusValue(7104, Long.valueOf(downloadStats.firstAudioTS));
            if (realTimeStreamInfo != null) {
                setStatusValue(7105, Long.valueOf((long) realTimeStreamInfo.d));
                setStatusValue(7106, realTimeStreamInfo.e);
                setStatusValue(7111, Long.valueOf(realTimeStreamInfo.f ? 2 : 1));
                setStatusValue(7113, realTimeStreamInfo.a);
                setStatusValue(7114, realTimeStreamInfo.b);
                setStatusValue(7115, realTimeStreamInfo.c);
            }
            setStatusValue(7107, Long.valueOf(downloadStats.startTS));
            setStatusValue(7108, Long.valueOf(downloadStats.dnsTS));
            setStatusValue(7109, Long.valueOf(downloadStats.connTS));
            setStatusValue(7110, String.valueOf(downloadStats.serverIP));
        }
        if (this.mDownloader != null) {
            int connectCountQuic = this.mDownloader.getConnectCountQuic();
            int connectCountTcp = this.mDownloader.getConnectCountTcp();
            setStatusValue(7117, Long.valueOf((long) (connectCountQuic + 1)));
            setStatusValue(7118, Long.valueOf((long) (connectCountTcp + 1)));
            setStatusValue(7119, this.mDownloader.getRealStreamUrl());
        }
        this.mLastTimeStamp = timeTick;
        this.mLastDownloadStats = downloadStats;
        AppMethodBeat.o(67559);
    }

    private Long getSpeed(long j, long j2, long j3) {
        long j4 = 0;
        AppMethodBeat.i(67560);
        if (j <= j2) {
            j2 -= j;
        }
        if (j3 > 0) {
            j4 = ((8 * j2) * 1000) / (1024 * j3);
        }
        Long valueOf = Long.valueOf(j4);
        AppMethodBeat.o(67560);
        return valueOf;
    }

    public void setHeaders(Map<String, String> map) {
        AppMethodBeat.i(67561);
        this.mHeaders = map;
        if (this.mDownloader != null) {
            this.mDownloader.setHeaders(this.mHeaders);
        }
        AppMethodBeat.o(67561);
    }
}
