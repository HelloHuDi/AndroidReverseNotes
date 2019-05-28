package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.C32147a;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class TXCStreamUploader extends C32147a implements C37370b {
    public static final int RTMPSENDSTRATEGY_LIVE = 1;
    public static final int RTMPSENDSTRATEGY_REALTIME_QUIC = 3;
    public static final int RTMPSENDSTRATEGY_REALTIME_TCP = 2;
    static final String TAG = "TXCStreamUploader";
    public static final int TXE_UPLOAD_ERROR_ALLADDRESS_FAILED = 11011;
    public static final int TXE_UPLOAD_ERROR_INVALID_ADDRESS = 11019;
    public static final int TXE_UPLOAD_ERROR_NET_DISCONNECT = 11012;
    public static final int TXE_UPLOAD_ERROR_NET_RECONNECT = 11016;
    public static final int TXE_UPLOAD_ERROR_NO_DATA = 11013;
    public static final int TXE_UPLOAD_ERROR_NO_NETWORK = 11015;
    public static final int TXE_UPLOAD_ERROR_READ_FAILED = 11017;
    public static final int TXE_UPLOAD_ERROR_WRITE_FAILED = 11018;
    public static final int TXE_UPLOAD_INFO_CONNECT_FAILED = 11006;
    public static final int TXE_UPLOAD_INFO_CONNECT_SUCCESS = 11001;
    public static final int TXE_UPLOAD_INFO_HANDSHAKE_FAIL = 11005;
    public static final int TXE_UPLOAD_INFO_NET_BUSY = 11003;
    public static final int TXE_UPLOAD_INFO_PUBLISH_START = 11008;
    public static final int TXE_UPLOAD_INFO_PUSH_BEGIN = 11002;
    public static final int TXE_UPLOAD_INFO_ROOM_IN = 11021;
    public static final int TXE_UPLOAD_INFO_ROOM_NEED_REENTER = 11024;
    public static final int TXE_UPLOAD_INFO_ROOM_OUT = 11022;
    public static final int TXE_UPLOAD_INFO_ROOM_USERLIST = 11023;
    public static final int TXE_UPLOAD_INFO_SERVER_REFUSE = 11007;
    public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
    public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
    public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
    public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
    public static final int TXE_UPLOAD_PROTOCOL_RTMP = 0;
    private final int MSG_EVENT = 102;
    private final int MSG_RECONNECT = 101;
    private final int MSG_REPORT_STATUS = 103;
    private final int MSG_RTMPPROXY_HEARTBEAT = 104;
    private boolean mAudioMuted = false;
    private int mChannelType = 0;
    private int mConnectCountQuic = 0;
    private int mConnectCountTcp = 0;
    private long mConnectSuccessTimeStamps = 0;
    private Context mContext = null;
    private int mCurrentRecordIdx = 0;
    private boolean mEnableNearestIP = true;
    private long mGoodPushTime = 30000;
    private Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    private C45112c mIntelligentRoute = null;
    private ArrayList<C41695a> mIpList = null;
    private boolean mIsPushing = false;
    private int mLastNetworkType = 255;
    private long mLastTimeStamp = 0;
    private UploadStats mLastUploadStats = null;
    private WeakReference<C0946a> mNotifyListener = null;
    private C32171h mParam = null;
    private long mPushStartTS = 0;
    private boolean mQuicChannel = false;
    private int mRetryCount = 0;
    private long mRtmpMsgRecvThreadInstance = 0;
    private Object mRtmpMsgRecvThreadLock = new Object();
    private boolean mRtmpProxyEnable = false;
    private int mRtmpProxyIPIndex = 0;
    private Vector<String> mRtmpProxyIPList = new Vector();
    private long mRtmpProxyInstance = 0;
    private Object mRtmpProxyLock = new Object();
    private C0965a mRtmpProxyParam = new C0965a();
    private String mRtmpUrl = "";
    private Thread mThread = null;
    private Object mThreadLock = null;
    private C41698j mUploadQualityReport = null;
    private long mUploaderInstance = 0;
    private Vector<C25649b> mVecPendingNAL = new Vector();

    public class UploadStats {
        public long audioCacheLen;
        public long audioDropCount;
        public long channelType;
        public long connTS;
        public long connectTimeCost;
        public String connectionID;
        public String connectionStats;
        public long dnsTS;
        public long dnsparseTimeCost;
        public long handshakeTimeCost;
        public long inAudioBytes;
        public long inVideoBytes;
        public long outAudioBytes;
        public long outVideoBytes;
        public String serverIP;
        public long startTS;
        public long videoCacheLen;
        public long videoDropCount;
    }

    /* renamed from: com.tencent.liteav.network.TXCStreamUploader$a */
    public class C0965a {
        /* renamed from: a */
        public long f1122a;
        /* renamed from: b */
        public long f1123b;
        /* renamed from: c */
        public String f1124c;
        /* renamed from: d */
        public long f1125d;
        /* renamed from: e */
        public String f1126e;
        /* renamed from: f */
        public long f1127f;
        /* renamed from: g */
        public long f1128g;
        /* renamed from: h */
        public String f1129h;
        /* renamed from: i */
        public boolean f1130i;
        /* renamed from: j */
        public String f1131j;

        /* renamed from: a */
        public void mo3876a() {
            this.f1122a = 0;
            this.f1123b = 0;
            this.f1124c = "";
            this.f1125d = 0;
            this.f1126e = "";
            this.f1127f = 0;
            this.f1128g = 0;
            this.f1130i = false;
            this.f1131j = "";
        }
    }

    public class RtmpProxyUserInfo {
        public String account = "";
        public String playUrl = "";
    }

    /* renamed from: com.tencent.liteav.network.TXCStreamUploader$b */
    class C0968b {
        /* renamed from: a */
        public String f1136a = "";
        /* renamed from: b */
        public boolean f1137b = false;

        public C0968b(String str, boolean z) {
            this.f1136a = str;
            this.f1137b = z;
        }
    }

    private native void nativeCacheJNIParams();

    private native void nativeEnableDrop(long j, boolean z);

    private native UploadStats nativeGetStats(long j);

    private native long nativeInitRtmpMsgRecvThreadInstance(long j, long j2);

    private native long nativeInitRtmpProxyInstance(long j, long j2, String str, long j3, String str2, long j4, long j5, String str3, boolean z, String str4);

    private native long nativeInitUploader(String str, String str2, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, int i8);

    private native void nativeOnThreadRun(long j);

    private native void nativePushAAC(long j, byte[] bArr, long j2);

    private native void nativePushNAL(long j, byte[] bArr, int i, long j2, long j3, long j4);

    private native void nativeReleaseJNIParams();

    private native void nativeRtmpMsgRecvThreadStart(long j);

    private native void nativeRtmpMsgRecvThreadStop(long j);

    private native void nativeRtmpProxyEnterRoom(long j);

    private native void nativeRtmpProxyLeaveRoom(long j);

    private native void nativeRtmpProxySendHeartBeat(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11);

    private native void nativeSendRtmpProxyMsg(long j, byte[] bArr);

    private native void nativeSetSendStrategy(long j, int i, boolean z);

    private native void nativeSetVideoDropParams(long j, boolean z, int i, int i2);

    private native void nativeStopPush(long j);

    private native void nativeUninitRtmpMsgRecvThreadInstance(long j);

    private native void nativeUninitRtmpProxyInstance(long j);

    private native void nativeUninitUploader(long j);

    static /* synthetic */ void access$000(TXCStreamUploader tXCStreamUploader, String str, boolean z, int i) {
        AppMethodBeat.m2504i(67514);
        tXCStreamUploader.startPushTask(str, z, i);
        AppMethodBeat.m2505o(67514);
    }

    static /* synthetic */ void access$100(TXCStreamUploader tXCStreamUploader) {
        AppMethodBeat.m2504i(67515);
        tXCStreamUploader.reportNetStatus();
        AppMethodBeat.m2505o(67515);
    }

    static /* synthetic */ long access$1400(TXCStreamUploader tXCStreamUploader, String str, String str2, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, int i8) {
        AppMethodBeat.m2504i(67518);
        long nativeInitUploader = tXCStreamUploader.nativeInitUploader(str, str2, z, i, i2, i3, i4, i5, i6, i7, z2, i8);
        AppMethodBeat.m2505o(67518);
        return nativeInitUploader;
    }

    static /* synthetic */ void access$1500(TXCStreamUploader tXCStreamUploader, long j, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(67519);
        tXCStreamUploader.nativeSetVideoDropParams(j, z, i, i2);
        AppMethodBeat.m2505o(67519);
    }

    static /* synthetic */ void access$1800(TXCStreamUploader tXCStreamUploader, long j, byte[] bArr, int i, long j2, long j3, long j4) {
        AppMethodBeat.m2504i(67520);
        tXCStreamUploader.nativePushNAL(j, bArr, i, j2, j3, j4);
        AppMethodBeat.m2505o(67520);
    }

    static /* synthetic */ void access$200(TXCStreamUploader tXCStreamUploader) {
        AppMethodBeat.m2504i(67516);
        tXCStreamUploader.rtmpProxySendHeartBeat();
        AppMethodBeat.m2505o(67516);
    }

    static /* synthetic */ long access$2200(TXCStreamUploader tXCStreamUploader, long j, long j2, String str, long j3, String str2, long j4, long j5, String str3, boolean z, String str4) {
        AppMethodBeat.m2504i(67521);
        long nativeInitRtmpProxyInstance = tXCStreamUploader.nativeInitRtmpProxyInstance(j, j2, str, j3, str2, j4, j5, str3, z, str4);
        AppMethodBeat.m2505o(67521);
        return nativeInitRtmpProxyInstance;
    }

    static /* synthetic */ long access$2500(TXCStreamUploader tXCStreamUploader, long j, long j2) {
        AppMethodBeat.m2504i(67522);
        long nativeInitRtmpMsgRecvThreadInstance = tXCStreamUploader.nativeInitRtmpMsgRecvThreadInstance(j, j2);
        AppMethodBeat.m2505o(67522);
        return nativeInitRtmpMsgRecvThreadInstance;
    }

    static /* synthetic */ void access$2600(TXCStreamUploader tXCStreamUploader, long j) {
        AppMethodBeat.m2504i(67523);
        tXCStreamUploader.nativeOnThreadRun(j);
        AppMethodBeat.m2505o(67523);
    }

    static /* synthetic */ void access$2700(TXCStreamUploader tXCStreamUploader, long j) {
        AppMethodBeat.m2504i(67524);
        tXCStreamUploader.nativeRtmpMsgRecvThreadStop(j);
        AppMethodBeat.m2505o(67524);
    }

    static /* synthetic */ void access$2800(TXCStreamUploader tXCStreamUploader, long j) {
        AppMethodBeat.m2504i(67525);
        tXCStreamUploader.nativeUninitRtmpMsgRecvThreadInstance(j);
        AppMethodBeat.m2505o(67525);
    }

    static /* synthetic */ void access$2900(TXCStreamUploader tXCStreamUploader, long j) {
        AppMethodBeat.m2504i(67526);
        tXCStreamUploader.nativeUninitRtmpProxyInstance(j);
        AppMethodBeat.m2505o(67526);
    }

    static /* synthetic */ void access$3000(TXCStreamUploader tXCStreamUploader, long j) {
        AppMethodBeat.m2504i(67527);
        tXCStreamUploader.nativeUninitUploader(j);
        AppMethodBeat.m2505o(67527);
    }

    static /* synthetic */ void access$3100(TXCStreamUploader tXCStreamUploader, boolean z) {
        AppMethodBeat.m2504i(67528);
        tXCStreamUploader.internalReconnect(z);
        AppMethodBeat.m2505o(67528);
    }

    static /* synthetic */ String access$800(TXCStreamUploader tXCStreamUploader, String str) {
        AppMethodBeat.m2504i(67517);
        String addressFromUrl = tXCStreamUploader.getAddressFromUrl(str);
        AppMethodBeat.m2505o(67517);
        return addressFromUrl;
    }

    static {
        AppMethodBeat.m2504i(67529);
        C17778b.m27756e();
        AppMethodBeat.m2505o(67529);
    }

    public void setNotifyListener(C0946a c0946a) {
        AppMethodBeat.m2504i(67480);
        this.mNotifyListener = new WeakReference(c0946a);
        AppMethodBeat.m2505o(67480);
    }

    public TXCStreamUploader(Context context, C32171h c32171h) {
        AppMethodBeat.m2504i(67481);
        this.mContext = context;
        if (c32171h == null) {
            c32171h = new C32171h();
            c32171h.f14921a = 0;
            c32171h.f14927g = 3;
            c32171h.f14926f = 3;
            c32171h.f14928h = 40;
            c32171h.f14929i = 1000;
            c32171h.f14930j = true;
        }
        this.mParam = c32171h;
        this.mThreadLock = new Object();
        this.mIntelligentRoute = new C45112c();
        this.mIntelligentRoute.f17800a = this;
        this.mUploaderInstance = 0;
        this.mRetryCount = 0;
        this.mCurrentRecordIdx = 0;
        this.mIpList = null;
        this.mIsPushing = false;
        this.mThread = null;
        this.mRtmpUrl = null;
        this.mLastNetworkType = 255;
        this.mHandlerThread = null;
        this.mUploadQualityReport = new C41698j(context);
        C17801i.m27844a().mo32953a(context);
        AppMethodBeat.m2505o(67481);
    }

    public void setRetryInterval(int i) {
        if (this.mParam != null) {
            this.mParam.f14927g = i;
        }
    }

    public void setAudioInfo(int i, int i2) {
        if (this.mParam != null) {
            this.mParam.f14924d = i2;
            this.mParam.f14925e = i;
        }
    }

    public void setRetryTimes(int i) {
        if (this.mParam != null) {
            this.mParam.f14926f = i;
        }
    }

    public void setMode(int i) {
        if (this.mParam != null) {
            this.mParam.f14921a = i;
        }
    }

    private void postReconnectMsg(String str, boolean z, int i) {
        AppMethodBeat.m2504i(67482);
        Message message = new Message();
        message.what = 101;
        message.obj = str;
        message.arg1 = z ? 2 : 1;
        if (this.mHandler != null) {
            this.mHandler.sendMessageDelayed(message, (long) i);
        }
        AppMethodBeat.m2505o(67482);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFetchDone(int i, ArrayList<C41695a> arrayList) {
        AppMethodBeat.m2504i(67483);
        if (this.mIsPushing) {
            int size;
            C0968b rtmpRealConnectInfo;
            if (arrayList != null) {
                TXCLog.m15676e(TAG, "onFetchDone: code = " + i + " ip count = " + arrayList.size());
                if (i == 0) {
                    this.mIpList = arrayList;
                    size = arrayList.size();
                    this.mCurrentRecordIdx = 0;
                    if (size > 0) {
                        String str = "";
                        Iterator it = this.mIpList.iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            String str2;
                            C41695a c41695a = (C41695a) it.next();
                            if (c41695a != null && c41695a.f17065c && c41695a.f17063a != null && c41695a.f17063a.length() > 0) {
                                i2++;
                            }
                            if (c41695a != null) {
                                str2 = str + " " + getConfusionIP(c41695a.f17063a) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c41695a.f17064b;
                            } else {
                                str2 = str;
                            }
                            str = str2;
                        }
                        setStatusValue(7016, Long.valueOf((long) i2));
                        setStatusValue(7019, "{" + str + " }");
                    }
                    rtmpRealConnectInfo = getRtmpRealConnectInfo();
                    postReconnectMsg(rtmpRealConnectInfo.f1136a, rtmpRealConnectInfo.f1137b, 0);
                    AppMethodBeat.m2505o(67483);
                    return;
                }
            }
            size = 0;
            if (size > 0) {
            }
            rtmpRealConnectInfo = getRtmpRealConnectInfo();
            postReconnectMsg(rtmpRealConnectInfo.f1136a, rtmpRealConnectInfo.f1137b, 0);
            AppMethodBeat.m2505o(67483);
            return;
        }
        AppMethodBeat.m2505o(67483);
    }

    public String getConfusionIP(String str) {
        AppMethodBeat.m2504i(67484);
        if (str != null) {
            int indexOf = str.indexOf(".");
            if (indexOf != -1) {
                String substring = str.substring(indexOf + 1);
                int indexOf2 = substring.indexOf(".");
                if (indexOf2 != -1) {
                    str = "A.B.".concat(String.valueOf(substring.substring(indexOf2 + 1)));
                    AppMethodBeat.m2505o(67484);
                    return str;
                }
            }
        }
        AppMethodBeat.m2505o(67484);
        return str;
    }

    public int init() {
        return 0;
    }

    public String start(String str, boolean z, int i) {
        AppMethodBeat.m2504i(67485);
        String str2;
        if (this.mIsPushing) {
            str2 = this.mRtmpUrl;
            AppMethodBeat.m2505o(67485);
            return str2;
        }
        this.mIsPushing = true;
        this.mConnectSuccessTimeStamps = 0;
        this.mRetryCount = 0;
        this.mRtmpUrl = str;
        this.mChannelType = i;
        this.mPushStartTS = 0;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mRtmpProxyEnable = false;
        this.mRtmpProxyParam.mo3876a();
        this.mRtmpProxyIPList.clear();
        this.mRtmpProxyIPIndex = 0;
        this.mRtmpProxyInstance = 0;
        this.mRtmpMsgRecvThreadInstance = 0;
        setStatusValue(7016, Long.valueOf(0));
        setStatusValue(7017, Long.valueOf(0));
        setStatusValue(7018, Long.valueOf(0));
        this.mUploadQualityReport.mo67339a();
        TXCLog.m15675d(TAG, "start push with url:" + this.mRtmpUrl + " enable nearest ip:" + (z ? "yes" : "no") + "channel type:" + i);
        if (C17778b.m27752c(this.mContext) == 255) {
            sendNotifyEvent(TXE_UPLOAD_ERROR_NO_NETWORK);
            str2 = this.mRtmpUrl;
            AppMethodBeat.m2505o(67485);
            return str2;
        }
        this.mEnableNearestIP = z;
        if (this.mHandlerThread == null) {
            this.mHandlerThread = new HandlerThread("RTMP_PUSH");
            this.mHandlerThread.start();
        }
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                AppMethodBeat.m2504i(67477);
                switch (message.what) {
                    case 101:
                        boolean z;
                        TXCStreamUploader tXCStreamUploader = TXCStreamUploader.this;
                        String str = (String) message.obj;
                        if (message.arg1 == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        TXCStreamUploader.access$000(tXCStreamUploader, str, z, 0);
                        AppMethodBeat.m2505o(67477);
                        return;
                    case 103:
                        TXCStreamUploader.access$100(TXCStreamUploader.this);
                        AppMethodBeat.m2505o(67477);
                        return;
                    case 104:
                        TXCStreamUploader.access$200(TXCStreamUploader.this);
                        if (TXCStreamUploader.this.mHandler != null) {
                            TXCStreamUploader.this.mHandler.sendEmptyMessageDelayed(104, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(67477);
            }
        };
        parseProxyInfo(str);
        if (this.mRtmpProxyEnable) {
            this.mLastNetworkType = C17778b.m27752c(this.mContext);
            nativeCacheJNIParams();
        } else if (this.mEnableNearestIP && this.mLastNetworkType != C17778b.m27752c(this.mContext)) {
            TXCLog.m15675d(TAG, "fetching nearest ip list");
            this.mLastNetworkType = C17778b.m27752c(this.mContext);
            this.mIntelligentRoute.mo72897a(str, i);
            this.mHandler.sendEmptyMessageDelayed(103, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            str2 = this.mRtmpUrl;
            AppMethodBeat.m2505o(67485);
            return str2;
        }
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        this.mHandler.sendEmptyMessageDelayed(103, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        str2 = this.mRtmpUrl;
        AppMethodBeat.m2505o(67485);
        return str2;
    }

    public void stop() {
        AppMethodBeat.m2504i(67486);
        if (this.mIsPushing) {
            this.mIsPushing = false;
            TXCLog.m15675d(TAG, "stop push");
            if (this.mRtmpProxyEnable) {
                synchronized (this.mRtmpProxyLock) {
                    try {
                        nativeRtmpProxyLeaveRoom(this.mRtmpProxyInstance);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(67486);
                        }
                    }
                }
            }
            synchronized (this.mThreadLock) {
                try {
                    nativeStopPush(this.mUploaderInstance);
                    this.mPushStartTS = 0;
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(67486);
                    }
                }
            }
            if (this.mHandlerThread != null) {
                this.mHandlerThread.getLooper().quit();
                this.mHandlerThread = null;
            }
            if (this.mHandler != null) {
                this.mHandler = null;
            }
            if (this.mRtmpProxyEnable) {
                nativeReleaseJNIParams();
            }
            this.mUploadQualityReport.mo67347c();
            this.mUploadQualityReport.mo67339a();
            AppMethodBeat.m2505o(67486);
            return;
        }
        AppMethodBeat.m2505o(67486);
    }

    private void tryResetRetryCount() {
        AppMethodBeat.m2504i(67487);
        if (this.mConnectSuccessTimeStamps != 0 && TXCTimeUtil.getTimeTick() - this.mConnectSuccessTimeStamps > ((long) ((this.mParam.f14926f * (this.mParam.f14927g + 13)) * 1000))) {
            this.mRetryCount = 0;
            this.mConnectSuccessTimeStamps = 0;
            TXCLog.m15675d(TAG, "reset retry count");
        }
        AppMethodBeat.m2505o(67487);
    }

    public void pushAAC(byte[] bArr, long j) {
        AppMethodBeat.m2504i(67488);
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            try {
                if (this.mPushStartTS == 0) {
                    this.mPushStartTS = j - 3600000;
                }
                if (!(this.mAudioMuted && this.mRtmpProxyEnable)) {
                    nativePushAAC(this.mUploaderInstance, bArr, j - this.mPushStartTS);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67488);
            }
        }
    }

    public void pushNAL(C25649b c25649b) {
        AppMethodBeat.m2504i(67489);
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            try {
                if (this.mUploaderInstance != 0) {
                    if (this.mPushStartTS == 0) {
                        this.mPushStartTS = c25649b.f5258h - 3600000;
                    }
                    if (!(c25649b == null || c25649b.f5251a == null || c25649b.f5251a.length <= 0)) {
                        nativePushNAL(this.mUploaderInstance, c25649b.f5251a, c25649b.f5252b, c25649b.f5255e, c25649b.f5257g - this.mPushStartTS, c25649b.f5258h - this.mPushStartTS);
                    }
                } else {
                    if (c25649b.f5252b == 0) {
                        this.mVecPendingNAL.removeAllElements();
                    }
                    this.mVecPendingNAL.add(c25649b);
                }
            } finally {
                AppMethodBeat.m2505o(67489);
            }
        }
    }

    public void setAudioMute(boolean z) {
        AppMethodBeat.m2504i(67490);
        synchronized (this.mThreadLock) {
            try {
                this.mAudioMuted = z;
                if (this.mRtmpProxyEnable && this.mUploaderInstance != 0) {
                    int i = this.mParam.f14933m ? this.mQuicChannel ? 3 : 2 : 1;
                    nativeSetSendStrategy(this.mUploaderInstance, i, false);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67490);
            }
        }
    }

    public void setDropEanble(boolean z) {
        AppMethodBeat.m2504i(67491);
        TXCLog.m15675d(TAG, "drop enable " + (z ? "yes" : "no"));
        synchronized (this.mThreadLock) {
            try {
                nativeEnableDrop(this.mUploaderInstance, z);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67491);
            }
        }
    }

    public void setVideoDropParams(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(67492);
        TXCLog.m15675d(TAG, "drop params wait i frame:" + (z ? "yes" : "no") + " max video count:" + i + " max video cache time: " + i2 + " ms");
        synchronized (this.mThreadLock) {
            try {
                this.mParam.f14930j = z;
                this.mParam.f14928h = i;
                this.mParam.f14929i = i2;
                if (this.mUploaderInstance != 0) {
                    nativeSetVideoDropParams(this.mUploaderInstance, this.mParam.f14930j, this.mParam.f14928h, this.mParam.f14929i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67492);
            }
        }
    }

    public void setSendStrategy(boolean z, boolean z2) {
        AppMethodBeat.m2504i(67493);
        this.mParam.f14933m = z;
        this.mParam.f14934n = z2;
        this.mUploadQualityReport.mo67343a(z);
        int i = z ? this.mQuicChannel ? 3 : 2 : 1;
        if (!this.mRtmpProxyEnable && (this.mIpList == null || this.mIpList.size() == 0)) {
            i = 1;
        }
        synchronized (this.mThreadLock) {
            try {
                if (this.mUploaderInstance != 0) {
                    nativeSetSendStrategy(this.mUploaderInstance, i, z2);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67493);
            }
        }
        setStatusValue(7020, Long.valueOf((long) i));
    }

    public UploadStats getUploadStats() {
        UploadStats nativeGetStats;
        AppMethodBeat.m2504i(67494);
        synchronized (this.mThreadLock) {
            try {
                nativeGetStats = nativeGetStats(this.mUploaderInstance);
                if (nativeGetStats != null) {
                    nativeGetStats.channelType = this.mQuicChannel ? 2 : 1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67494);
            }
        }
        return nativeGetStats;
    }

    private void startPushTask(final String str, final boolean z, int i) {
        AppMethodBeat.m2504i(67495);
        TXCLog.m15675d(TAG, "start push task");
        if (this.mQuicChannel != z && this.mQuicChannel) {
            TXCDRApi.reportEvent40003(this.mRtmpUrl, C8795a.f2487M, 0, "switch video push channel from quic to tcp", "limits:" + this.mParam.f14926f + " current:" + this.mRetryCount);
        }
        int i2;
        if (z) {
            i2 = this.mConnectCountQuic + 1;
            this.mConnectCountQuic = i2;
            setStatusValue(7017, Long.valueOf((long) i2));
        } else {
            i2 = this.mConnectCountTcp + 1;
            this.mConnectCountTcp = i2;
            setStatusValue(7018, Long.valueOf((long) i2));
        }
        this.mThread = new Thread("RTMPUpload") {
            public void run() {
                AppMethodBeat.m2504i(67543);
                while (TXCStreamUploader.this.mUploaderInstance != 0) {
                    try {
                        C09642.sleep(100, 0);
                    } catch (InterruptedException e) {
                    }
                }
                TXCStreamUploader.this.mUploadQualityReport.mo67345b();
                TXCStreamUploader.this.mUploadQualityReport.mo67343a(TXCStreamUploader.this.mParam.f14933m);
                TXCStreamUploader.this.mUploadQualityReport.mo67342a(TXCStreamUploader.this.mRtmpUrl);
                TXCStreamUploader.this.mUploadQualityReport.mo67344a(z, TXCStreamUploader.access$800(TXCStreamUploader.this, str));
                synchronized (TXCStreamUploader.this.mThreadLock) {
                    try {
                        TXCStreamUploader.this.mQuicChannel = z;
                        int i = TXCStreamUploader.this.mParam.f14933m ? TXCStreamUploader.this.mQuicChannel ? 3 : 2 : 1;
                        if (TXCStreamUploader.this.mRtmpProxyEnable) {
                            if (TXCStreamUploader.this.mAudioMuted) {
                                TXCStreamUploader.this.mParam.f14934n = false;
                            }
                        } else if (TXCStreamUploader.this.mIpList == null || TXCStreamUploader.this.mIpList.size() == 0) {
                            i = 1;
                        }
                        TXCStreamUploader.this.setStatusValue(7020, Long.valueOf((long) i));
                        TXCStreamUploader.this.mUploaderInstance = TXCStreamUploader.access$1400(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpUrl, str, z, TXCStreamUploader.this.mParam.f14925e, TXCStreamUploader.this.mParam.f14924d, TXCStreamUploader.this.mParam.f14921a, TXCStreamUploader.this.mParam.f14923c, TXCStreamUploader.this.mParam.f14928h, 16, i, TXCStreamUploader.this.mParam.f14934n, TXCStreamUploader.this.mParam.f14935o);
                        if (TXCStreamUploader.this.mUploaderInstance != 0) {
                            TXCStreamUploader.access$1500(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance, TXCStreamUploader.this.mParam.f14930j, TXCStreamUploader.this.mParam.f14928h, TXCStreamUploader.this.mParam.f14929i);
                            Object obj = null;
                            Iterator it = TXCStreamUploader.this.mVecPendingNAL.iterator();
                            while (it.hasNext()) {
                                Object obj2;
                                C25649b c25649b = (C25649b) it.next();
                                if (obj == null && c25649b.f5252b == 0) {
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                if (obj2 != null) {
                                    if (TXCStreamUploader.this.mPushStartTS == 0) {
                                        TXCStreamUploader.this.mPushStartTS = c25649b.f5258h - 3600000;
                                    }
                                    TXCStreamUploader.access$1800(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance, c25649b.f5251a, c25649b.f5252b, c25649b.f5255e, c25649b.f5257g - TXCStreamUploader.this.mPushStartTS, c25649b.f5258h - TXCStreamUploader.this.mPushStartTS);
                                }
                                obj = obj2;
                            }
                            TXCStreamUploader.this.mVecPendingNAL.removeAllElements();
                        }
                    } finally {
                        AppMethodBeat.m2505o(67543);
                    }
                }
                if (TXCStreamUploader.this.mRtmpProxyEnable) {
                    synchronized (TXCStreamUploader.this.mRtmpProxyLock) {
                        try {
                            TXCStreamUploader.this.mRtmpProxyInstance = TXCStreamUploader.access$2200(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyParam.f1122a, TXCStreamUploader.this.mRtmpProxyParam.f1123b, TXCStreamUploader.this.mRtmpProxyParam.f1124c, TXCStreamUploader.this.mRtmpProxyParam.f1125d, TXCStreamUploader.this.mRtmpProxyParam.f1126e, TXCStreamUploader.this.mRtmpProxyParam.f1127f, TXCStreamUploader.this.mRtmpProxyParam.f1128g, TXCStreamUploader.this.mRtmpProxyParam.f1129h, TXCStreamUploader.this.mRtmpProxyParam.f1130i, TXCStreamUploader.this.mRtmpProxyParam.f1131j);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(67543);
                            }
                        }
                    }
                    synchronized (TXCStreamUploader.this.mRtmpMsgRecvThreadLock) {
                        try {
                            TXCStreamUploader.this.mRtmpMsgRecvThreadInstance = TXCStreamUploader.access$2500(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyInstance, TXCStreamUploader.this.mUploaderInstance);
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.m2505o(67543);
                            }
                        }
                    }
                }
                TXCStreamUploader.access$2600(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance);
                if (TXCStreamUploader.this.mRtmpProxyEnable) {
                    synchronized (TXCStreamUploader.this.mRtmpMsgRecvThreadLock) {
                        try {
                            TXCStreamUploader.access$2700(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpMsgRecvThreadInstance);
                            TXCStreamUploader.access$2800(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpMsgRecvThreadInstance);
                            TXCStreamUploader.this.mRtmpMsgRecvThreadInstance = 0;
                        } catch (Throwable th3) {
                            while (true) {
                                AppMethodBeat.m2505o(67543);
                            }
                        }
                    }
                    synchronized (TXCStreamUploader.this.mRtmpProxyLock) {
                        try {
                            TXCStreamUploader.access$2900(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyInstance);
                            TXCStreamUploader.this.mRtmpProxyInstance = 0;
                        } catch (Throwable th4) {
                            while (true) {
                                AppMethodBeat.m2505o(67543);
                            }
                        }
                    }
                }
                synchronized (TXCStreamUploader.this.mThreadLock) {
                    try {
                        TXCStreamUploader.access$3000(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance);
                        TXCStreamUploader.this.mUploaderInstance = 0;
                    } catch (Throwable th5) {
                        while (true) {
                            AppMethodBeat.m2505o(67543);
                        }
                    }
                }
            }
        };
        this.mThread.start();
        AppMethodBeat.m2505o(67495);
    }

    private void stopPushTask() {
        AppMethodBeat.m2504i(67496);
        TXCLog.m15675d(TAG, "stop push task");
        synchronized (this.mThreadLock) {
            try {
                this.mVecPendingNAL.removeAllElements();
                nativeStopPush(this.mUploaderInstance);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67496);
            }
        }
    }

    private C0968b getRtmpRealConnectInfo() {
        int i = 1;
        AppMethodBeat.m2504i(67497);
        C0968b c0968b;
        if (!this.mEnableNearestIP) {
            c0968b = new C0968b(this.mRtmpUrl, false);
            AppMethodBeat.m2505o(67497);
            return c0968b;
        } else if (this.mIpList == null) {
            c0968b = new C0968b(this.mRtmpUrl, false);
            AppMethodBeat.m2505o(67497);
            return c0968b;
        } else if (this.mCurrentRecordIdx >= this.mIpList.size() || this.mCurrentRecordIdx < 0) {
            c0968b = new C0968b(this.mRtmpUrl, false);
            AppMethodBeat.m2505o(67497);
            return c0968b;
        } else {
            C41695a c41695a = (C41695a) this.mIpList.get(this.mCurrentRecordIdx);
            String[] split = this.mRtmpUrl.split("://");
            if (split.length < 2) {
                c0968b = new C0968b(this.mRtmpUrl, false);
                AppMethodBeat.m2505o(67497);
                return c0968b;
            }
            String[] split2 = split[1].split("/");
            split2[0] = c41695a.f17063a + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c41695a.f17064b;
            StringBuilder stringBuilder = new StringBuilder(split2[0]);
            while (i < split2.length) {
                stringBuilder.append("/");
                stringBuilder.append(split2[i]);
                i++;
            }
            C0968b c0968b2 = new C0968b(split[0] + "://" + stringBuilder.toString(), c41695a.f17065c);
            AppMethodBeat.m2505o(67497);
            return c0968b2;
        }
    }

    private boolean nextRecordIdx(boolean z) {
        AppMethodBeat.m2504i(67498);
        if (this.mIpList == null || this.mIpList.size() == 0) {
            AppMethodBeat.m2505o(67498);
            return false;
        }
        if (z) {
            C41695a c41695a = (C41695a) this.mIpList.get(this.mCurrentRecordIdx);
            c41695a.f17067e++;
        }
        if (this.mCurrentRecordIdx + 1 < this.mIpList.size()) {
            this.mCurrentRecordIdx++;
            AppMethodBeat.m2505o(67498);
            return true;
        }
        AppMethodBeat.m2505o(67498);
        return false;
    }

    private String getAddressFromUrl(String str) {
        String substring;
        AppMethodBeat.m2504i(67499);
        if (str != null) {
            int indexOf = str.indexOf("://");
            if (indexOf != -1) {
                substring = str.substring(indexOf + 3);
                int indexOf2 = substring.indexOf("/");
                if (indexOf2 != -1) {
                    substring = substring.substring(0, indexOf2);
                    AppMethodBeat.m2505o(67499);
                    return substring;
                }
            }
        }
        substring = "";
        AppMethodBeat.m2505o(67499);
        return substring;
    }

    private void reconnect(final boolean z) {
        AppMethodBeat.m2504i(67500);
        stopPushTask();
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(67534);
                    TXCStreamUploader.access$3100(TXCStreamUploader.this, z);
                    AppMethodBeat.m2505o(67534);
                }
            }, (long) (this.mParam.f14927g * 1000));
        }
        AppMethodBeat.m2505o(67500);
    }

    private void internalReconnect(boolean z) {
        AppMethodBeat.m2504i(67501);
        if (!this.mIsPushing) {
            AppMethodBeat.m2505o(67501);
        } else if (!this.mRtmpProxyEnable) {
            this.mUploadQualityReport.mo67347c();
            if (!this.mEnableNearestIP || this.mLastNetworkType == C17778b.m27752c(this.mContext)) {
                if (!this.mEnableNearestIP) {
                    z = false;
                }
                if (this.mQuicChannel) {
                    z = true;
                }
                if (z && !nextRecordIdx(true)) {
                    TXCLog.m15676e(TAG, "reconnect: try all addresses failed");
                    TXCDRApi.reportEvent40003(this.mRtmpUrl, C8795a.f2479E, 0, "connect upload server failed", "try all addresses failed");
                }
                C0968b rtmpRealConnectInfo = getRtmpRealConnectInfo();
                String addressFromUrl = getAddressFromUrl(rtmpRealConnectInfo.f1136a);
                TXCLog.m15676e(TAG, "reconnect change ip: " + addressFromUrl + " enableNearestIP: " + this.mEnableNearestIP + " last channel type: " + (this.mQuicChannel ? "Q Channel" : "TCP"));
                if (this.mQuicChannel) {
                    TXCLog.m15676e(TAG, "reconnect last channel type is Q Channel，ignore retry limit");
                    TXCDRApi.reportEvent40003(this.mRtmpUrl, C8795a.f2480F, 0, "reconnect upload server:".concat(String.valueOf(addressFromUrl)), "last channel type is Q Channel");
                    startPushTask(rtmpRealConnectInfo.f1136a, rtmpRealConnectInfo.f1137b, 0);
                    sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
                    AppMethodBeat.m2505o(67501);
                    return;
                }
                TXCLog.m15676e(TAG, "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f14926f);
                if (this.mRetryCount < this.mParam.f14926f) {
                    this.mRetryCount++;
                    TXCDRApi.reportEvent40003(this.mRtmpUrl, C8795a.f2480F, 0, "reconnect upload server:".concat(String.valueOf(addressFromUrl)), "retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f14926f);
                    startPushTask(rtmpRealConnectInfo.f1136a, rtmpRealConnectInfo.f1137b, 0);
                    sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
                    AppMethodBeat.m2505o(67501);
                    return;
                }
                TXCLog.m15676e(TAG, "reconnect: try all times failed");
                TXCDRApi.reportEvent40003(this.mRtmpUrl, C8795a.f2479E, 0, "connect upload server failed", "try all times failed");
                sendNotifyEvent(TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
                AppMethodBeat.m2505o(67501);
                return;
            }
            TXCLog.m15676e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + C17778b.m27752c(this.mContext));
            this.mLastNetworkType = C17778b.m27752c(this.mContext);
            this.mIntelligentRoute.mo72897a(this.mRtmpUrl, this.mChannelType);
            this.mRetryCount = 0;
            AppMethodBeat.m2505o(67501);
        } else if (this.mLastNetworkType != C17778b.m27752c(this.mContext)) {
            TXCLog.m15676e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + C17778b.m27752c(this.mContext));
            this.mLastNetworkType = C17778b.m27752c(this.mContext);
            this.mRetryCount = 0;
            sendNotifyEvent(TXE_UPLOAD_INFO_ROOM_NEED_REENTER, String.format("网络类型发生变化，需要重新进房", new Object[0]));
            AppMethodBeat.m2505o(67501);
        } else if (this.mRetryCount < this.mParam.f14926f) {
            this.mRetryCount++;
            TXCDRApi.reportEvent40003(this.mRtmpUrl, C8795a.f2480F, 0, "reconnect rtmp-proxy server", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f14926f);
            sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
            startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            AppMethodBeat.m2505o(67501);
        } else if (getNextRtmpProxyIP()) {
            this.mRetryCount = 0;
            TXCDRApi.reportEvent40003(this.mRtmpUrl, C8795a.f2480F, 0, "reconnect rtmp-proxy server", "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f14926f);
            sendNotifyEvent(TXE_UPLOAD_ERROR_NET_RECONNECT);
            startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            AppMethodBeat.m2505o(67501);
        } else {
            TXCDRApi.reportEvent40003(this.mRtmpUrl, C8795a.f2479E, 0, "connect rtmp-proxy server failed", "try all addresses");
            sendNotifyEvent(TXE_UPLOAD_ERROR_ALLADDRESS_FAILED);
            AppMethodBeat.m2505o(67501);
        }
    }

    private void sendNotifyEvent(int i, String str) {
        AppMethodBeat.m2504i(67502);
        if (str == null || str.isEmpty()) {
            sendNotifyEvent(i);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            switch (i) {
                case TXE_UPLOAD_INFO_CONNECT_FAILED /*11006*/:
                    i = 3002;
                    break;
                case TXE_UPLOAD_ERROR_READ_FAILED /*11017*/:
                    i = 3005;
                    break;
                case TXE_UPLOAD_ERROR_WRITE_FAILED /*11018*/:
                    i = 3005;
                    break;
                case TXE_UPLOAD_ERROR_INVALID_ADDRESS /*11019*/:
                    i = TXLiveConstants.PUSH_ERR_INVALID_ADDRESS;
                    break;
                case TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
                    i = 1018;
                    break;
                case TXE_UPLOAD_INFO_ROOM_OUT /*11022*/:
                    i = 1019;
                    break;
                case TXE_UPLOAD_INFO_ROOM_USERLIST /*11023*/:
                    i = 1020;
                    break;
                case TXE_UPLOAD_INFO_ROOM_NEED_REENTER /*11024*/:
                    i = TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER;
                    break;
            }
            C17778b.m27742a(this.mNotifyListener, i, bundle);
        }
        if (i == TXE_UPLOAD_INFO_PUSH_BEGIN) {
            UploadStats uploadStats = getUploadStats();
            if (uploadStats != null) {
                this.mUploadQualityReport.mo67341a(uploadStats.dnsparseTimeCost, uploadStats.connectTimeCost, uploadStats.handshakeTimeCost);
            }
            AppMethodBeat.m2505o(67502);
            return;
        }
        if (i == TXE_UPLOAD_INFO_NET_BUSY) {
            this.mUploadQualityReport.mo67348d();
        }
        AppMethodBeat.m2505o(67502);
    }

    private void sendNotifyEvent(int i) {
        AppMethodBeat.m2504i(67503);
        if (i == 0) {
            reconnect(false);
            AppMethodBeat.m2505o(67503);
        } else if (i == 1) {
            reconnect(true);
            AppMethodBeat.m2505o(67503);
        } else {
            if (i == TXE_UPLOAD_INFO_CONNECT_SUCCESS) {
                this.mConnectSuccessTimeStamps = TXCTimeUtil.getTimeTick();
            }
            if (this.mNotifyListener != null) {
                Bundle bundle = new Bundle();
                switch (i) {
                    case TXE_UPLOAD_INFO_CONNECT_SUCCESS /*11001*/:
                        i = 1001;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "已经连接rtmp服务器");
                        break;
                    case TXE_UPLOAD_INFO_PUSH_BEGIN /*11002*/:
                        i = 1002;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "rtmp开始推流");
                        break;
                    case TXE_UPLOAD_INFO_NET_BUSY /*11003*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "上行带宽不足，数据发送不及时");
                        i = 1101;
                        break;
                    case TXE_UPLOAD_INFO_HANDSHAKE_FAIL /*11005*/:
                        i = 3003;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "RTMP服务器握手失败");
                        break;
                    case TXE_UPLOAD_INFO_CONNECT_FAILED /*11006*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "连接服务器失败");
                        i = 3002;
                        break;
                    case TXE_UPLOAD_INFO_SERVER_REFUSE /*11007*/:
                        i = 3004;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "服务器拒绝连接请求，可能是该推流地址已经被占用或过期，或者防盗链错误");
                        break;
                    case TXE_UPLOAD_INFO_PUBLISH_START /*11008*/:
                        if (this.mRtmpProxyEnable) {
                            synchronized (this.mRtmpMsgRecvThreadLock) {
                                try {
                                    nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
                                } catch (Throwable th) {
                                    while (true) {
                                        AppMethodBeat.m2505o(67503);
                                        break;
                                    }
                                }
                            }
                            synchronized (this.mRtmpProxyLock) {
                                try {
                                    nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
                                } catch (Throwable th2) {
                                    while (true) {
                                        AppMethodBeat.m2505o(67503);
                                        break;
                                    }
                                }
                            }
                            if (this.mHandler != null) {
                                this.mHandler.sendEmptyMessageDelayed(104, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                            }
                        }
                        AppMethodBeat.m2505o(67503);
                        return;
                    case TXE_UPLOAD_ERROR_ALLADDRESS_FAILED /*11011*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "所有IP都已经尝试失败,可以放弃治疗");
                        i = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                        break;
                    case TXE_UPLOAD_ERROR_NET_DISCONNECT /*11012*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "经连续多次重连失败，放弃重连");
                        i = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                        break;
                    case TXE_UPLOAD_ERROR_NO_DATA /*11013*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "超过30s没有数据发送，主动断开连接");
                        i = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                        break;
                    case TXE_UPLOAD_ERROR_NO_NETWORK /*11015*/:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "没有网络，请检测WiFi或移动数据是否开启");
                        i = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                        break;
                    case TXE_UPLOAD_ERROR_NET_RECONNECT /*11016*/:
                        i = 1102;
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "启动网络重连");
                        break;
                    default:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "UNKNOWN");
                        break;
                }
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                C17778b.m27742a(this.mNotifyListener, i, bundle);
            }
            AppMethodBeat.m2505o(67503);
        }
    }

    private void reportNetStatus() {
        AppMethodBeat.m2504i(67504);
        long timeTick = TXCTimeUtil.getTimeTick();
        long j = timeTick - this.mLastTimeStamp;
        UploadStats uploadStats = getUploadStats();
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        if (uploadStats != null) {
            if (this.mLastUploadStats != null) {
                long longValue = getSpeed(this.mLastUploadStats.inVideoBytes, uploadStats.inVideoBytes, j).longValue();
                long longValue2 = getSpeed(this.mLastUploadStats.inAudioBytes, uploadStats.inAudioBytes, j).longValue();
                long longValue3 = getSpeed(this.mLastUploadStats.outVideoBytes, uploadStats.outVideoBytes, j).longValue();
                j4 = getSpeed(this.mLastUploadStats.outAudioBytes, uploadStats.outAudioBytes, j).longValue();
                j3 = longValue3;
                j2 = longValue2;
                j = longValue;
            } else {
                j = 0;
            }
            setStatusValue(7001, Long.valueOf(j));
            setStatusValue(7002, Long.valueOf(j2));
            setStatusValue(7003, Long.valueOf(j3));
            setStatusValue(7004, Long.valueOf(j4));
            setStatusValue(7005, Long.valueOf(uploadStats.videoCacheLen));
            setStatusValue(7006, Long.valueOf(uploadStats.audioCacheLen));
            setStatusValue(7007, Long.valueOf(uploadStats.videoDropCount));
            setStatusValue(7008, Long.valueOf(uploadStats.audioDropCount));
            setStatusValue(7009, Long.valueOf(uploadStats.startTS));
            setStatusValue(7010, Long.valueOf(uploadStats.dnsTS));
            setStatusValue(7011, Long.valueOf(uploadStats.connTS));
            setStatusValue(7012, String.valueOf(uploadStats.serverIP));
            setStatusValue(7013, Long.valueOf(this.mQuicChannel ? 2 : 1));
            setStatusValue(7014, uploadStats.connectionID);
            setStatusValue(7015, uploadStats.connectionStats);
            this.mUploadQualityReport.mo67340a(uploadStats.videoDropCount, uploadStats.audioDropCount);
            this.mUploadQualityReport.mo67346b(uploadStats.videoCacheLen, uploadStats.audioCacheLen);
        }
        this.mLastTimeStamp = timeTick;
        this.mLastUploadStats = uploadStats;
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(103, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(67504);
    }

    private Long getSpeed(long j, long j2, long j3) {
        long j4 = 0;
        AppMethodBeat.m2504i(67505);
        if (j <= j2) {
            j2 -= j;
        }
        if (j3 > 0) {
            j4 = ((8 * j2) * 1000) / (1024 * j3);
        }
        Long valueOf = Long.valueOf(j4);
        AppMethodBeat.m2505o(67505);
        return valueOf;
    }

    private boolean isQCloudStreamUrl(String str) {
        AppMethodBeat.m2504i(67506);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(67506);
            return false;
        }
        String str2 = "://";
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            str2 = str.substring(str2.length() + indexOf);
            if (str2 != null && str2.startsWith("cloud.tencent.com")) {
                AppMethodBeat.m2505o(67506);
                return true;
            }
        }
        AppMethodBeat.m2505o(67506);
        return false;
    }

    private void parseProxyInfo(String str) {
        AppMethodBeat.m2504i(67507);
        if (str == null || str.length() == 0 || !str.startsWith("room")) {
            AppMethodBeat.m2505o(67507);
            return;
        }
        this.mRtmpProxyParam.f1130i = isQCloudStreamUrl(str);
        HashMap paramsFromUrl = getParamsFromUrl(str);
        if (paramsFromUrl == null) {
            AppMethodBeat.m2505o(67507);
            return;
        }
        if (paramsFromUrl.containsKey("sdkappid")) {
            this.mRtmpProxyParam.f1122a = Long.valueOf((String) paramsFromUrl.get("sdkappid")).longValue();
        }
        if (paramsFromUrl.containsKey("roomid") && paramsFromUrl.containsKey("userid") && paramsFromUrl.containsKey("roomsig")) {
            String str2;
            this.mRtmpProxyParam.f1125d = Long.valueOf((String) paramsFromUrl.get("roomid")).longValue();
            this.mRtmpProxyParam.f1124c = (String) paramsFromUrl.get("userid");
            if (paramsFromUrl.containsKey("bizbuf")) {
                try {
                    str2 = (String) paramsFromUrl.get("bizbuf");
                    this.mRtmpProxyParam.f1131j = URLDecoder.decode(str2, "UTF-8");
                } catch (Exception e) {
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode((String) paramsFromUrl.get("roomsig"), "UTF-8"));
                this.mRtmpProxyParam.f1123b = 0;
                if (jSONObject.has("Key")) {
                    this.mRtmpProxyParam.f1126e = jSONObject.optString("Key");
                    JSONObject optJSONObject = jSONObject.optJSONObject("RtmpProxy");
                    if (optJSONObject == null || (optJSONObject.has("Ip") && optJSONObject.has("Port") && optJSONObject.has("Type"))) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("AccessList");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                if (jSONObject2 != null && jSONObject2.has("Ip") && jSONObject2.has("Port") && jSONObject2.has("Type")) {
                                    String optString = jSONObject2.optString("Ip");
                                    long optLong = jSONObject2.optLong("Port");
                                    if (jSONObject2.optLong("Type") == 2) {
                                        this.mRtmpProxyIPList.add(optString + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + optLong);
                                    }
                                }
                            }
                        }
                        if (!this.mRtmpProxyParam.f1130i) {
                            this.mRtmpUrl = str;
                            this.mQuicChannel = false;
                        } else if (optJSONObject == null) {
                            AppMethodBeat.m2505o(67507);
                            return;
                        } else {
                            str2 = str.substring(0, str.indexOf("?"));
                            this.mRtmpUrl = str2 + "/webrtc/" + (this.mRtmpProxyParam.f1122a + "_" + this.mRtmpProxyParam.f1125d + "_" + this.mRtmpProxyParam.f1124c) + "?real_rtmp_ip=" + optJSONObject.optString("Ip") + "&real_rtmp_port=" + optJSONObject.optLong("Port") + "&tinyid=" + this.mRtmpProxyParam.f1123b + "&srctinyid=0";
                            getNextRtmpProxyIP();
                        }
                        this.mRtmpProxyEnable = true;
                        AppMethodBeat.m2505o(67507);
                        return;
                    }
                    AppMethodBeat.m2505o(67507);
                    return;
                }
                AppMethodBeat.m2505o(67507);
                return;
            } catch (Exception e2) {
                AppMethodBeat.m2505o(67507);
                return;
            }
        }
        AppMethodBeat.m2505o(67507);
    }

    private HashMap getParamsFromUrl(String str) {
        AppMethodBeat.m2504i(67508);
        HashMap hashMap = new HashMap();
        String[] split = str.split("[?]");
        if (split == null || split.length < 2 || split[1] == null || split[1].length() == 0) {
            AppMethodBeat.m2505o(67508);
        } else {
            for (String str2 : split[1].split("[&]")) {
                if (str2.indexOf("=") != -1) {
                    String[] split2 = str2.split("[=]");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            AppMethodBeat.m2505o(67508);
        }
        return hashMap;
    }

    private boolean getNextRtmpProxyIP() {
        AppMethodBeat.m2504i(67509);
        this.mRtmpProxyParam.f1127f = 234;
        this.mRtmpProxyParam.f1128g = 80;
        if (this.mRtmpProxyIPList == null || this.mRtmpProxyIPList.size() <= 0) {
            AppMethodBeat.m2505o(67509);
            return false;
        } else if (this.mRtmpProxyIPIndex >= this.mRtmpProxyIPList.size()) {
            this.mRtmpProxyIPIndex = 0;
            AppMethodBeat.m2505o(67509);
            return false;
        } else {
            String[] split = this.mRtmpUrl.split("://");
            if (split.length < 2) {
                AppMethodBeat.m2505o(67509);
                return false;
            }
            String substring = split[1].substring(split[1].indexOf("/"));
            String str = (String) this.mRtmpProxyIPList.get(this.mRtmpProxyIPIndex);
            this.mRtmpProxyParam.f1129h = str;
            this.mRtmpUrl = "room://" + str + substring;
            this.mQuicChannel = true;
            this.mRtmpProxyIPIndex++;
            AppMethodBeat.m2505o(67509);
            return true;
        }
    }

    private void rtmpProxySendHeartBeat() {
        AppMethodBeat.m2504i(67510);
        int[] a = C17778b.m27747a();
        long j = (long) (a[0] / 10);
        long j2 = (long) (a[1] / 10);
        long d = (long) TXCStatus.m40656d(getID(), 7004);
        long d2 = (long) TXCStatus.m40656d(getID(), 7003);
        long d3 = (long) TXCStatus.m40656d(getID(), 1001);
        long d4 = (long) TXCStatus.m40656d(getID(), WearableStatusCodes.DUPLICATE_LISTENER);
        long d5 = (long) TXCStatus.m40656d(getID(), 7006);
        long d6 = (long) TXCStatus.m40656d(getID(), 7005);
        long d7 = (long) TXCStatus.m40656d(getID(), 7008);
        long d8 = (long) TXCStatus.m40656d(getID(), 7007);
        synchronized (this.mRtmpProxyLock) {
            try {
                nativeRtmpProxySendHeartBeat(this.mRtmpProxyInstance, j, j2, d, d2, d3, d4, d5, d6, d7, d8);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67510);
            }
        }
    }

    private void onSendRtmpProxyMsg(byte[] bArr) {
        AppMethodBeat.m2504i(67511);
        synchronized (this.mThreadLock) {
            try {
                if (this.mUploaderInstance != 0) {
                    nativeSendRtmpProxyMsg(this.mUploaderInstance, bArr);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67511);
            }
        }
    }

    private void onRtmpProxyUserListPushed(RtmpProxyUserInfo[] rtmpProxyUserInfoArr) {
        AppMethodBeat.m2504i(67512);
        if (rtmpProxyUserInfoArr == null) {
            AppMethodBeat.m2505o(67512);
        } else if (!this.mIsPushing) {
            AppMethodBeat.m2505o(67512);
        } else if (!this.mRtmpProxyEnable || this.mRtmpProxyParam == null) {
            AppMethodBeat.m2505o(67512);
        } else {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < rtmpProxyUserInfoArr.length; i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userid", rtmpProxyUserInfoArr[i].account);
                    jSONObject.put("playurl", rtmpProxyUserInfoArr[i].playUrl);
                    jSONArray.put(i, jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("userlist", jSONArray);
                sendNotifyEvent(TXE_UPLOAD_INFO_ROOM_USERLIST, jSONObject2.toString());
                AppMethodBeat.m2505o(67512);
            } catch (Exception e) {
                AppMethodBeat.m2505o(67512);
            }
        }
    }

    private void onRtmpProxyRoomEvent(int i, int i2) {
        AppMethodBeat.m2504i(67513);
        if (i == 1) {
            sendNotifyEvent(TXE_UPLOAD_INFO_ROOM_IN, String.format("已在房间中，[%d]", new Object[]{Integer.valueOf(i2)}));
            AppMethodBeat.m2505o(67513);
            return;
        }
        if (i == 2) {
            sendNotifyEvent(TXE_UPLOAD_INFO_ROOM_OUT, String.format("不在房间中，[%d]", new Object[]{Integer.valueOf(i2)}));
        }
        AppMethodBeat.m2505o(67513);
    }
}
