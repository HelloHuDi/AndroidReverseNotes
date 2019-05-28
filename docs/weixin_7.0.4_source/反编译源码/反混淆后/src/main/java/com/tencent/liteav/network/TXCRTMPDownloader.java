package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader.DownloadStats;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

public class TXCRTMPDownloader extends TXIStreamDownloader {
    private final int MSG_EVENT;
    private final int MSG_RECONNECT;
    private final String TAG;
    private int mConnectCountQuic;
    private int mConnectCountTcp;
    private C8821a mCurrentThread;
    private boolean mEnableNearestIP;
    private Handler mHandler;
    private boolean mHasTcpPlayUrl;
    private boolean mIsPlayRtmpAccStream;
    private int mLastNetworkType;
    private String mPlayUrl;
    private boolean mQuicChannel;
    private Object mRTMPThreadLock;
    private String mServerIp;
    private HandlerThread mThread;
    private Vector<C17794e> mVecPlayUrls;

    /* renamed from: com.tencent.liteav.network.TXCRTMPDownloader$a */
    class C8821a extends Thread {
        /* renamed from: b */
        private long f2708b = 0;
        /* renamed from: c */
        private String f2709c;
        /* renamed from: d */
        private boolean f2710d;

        C8821a(String str, boolean z) {
            super("RTMPDownLoad");
            this.f2709c = str;
            this.f2710d = z;
        }

        public void run() {
            AppMethodBeat.m2504i(67530);
            synchronized (this) {
                try {
                    this.f2708b = TXCRTMPDownloader.access$000(TXCRTMPDownloader.this, TXCRTMPDownloader.this.mOriginUrl, this.f2709c, this.f2710d, TXCRTMPDownloader.this.mEnableMessage);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67530);
                }
            }
            TXCRTMPDownloader.access$100(TXCRTMPDownloader.this, this.f2708b);
            synchronized (this) {
                try {
                    TXCRTMPDownloader.access$200(TXCRTMPDownloader.this, this.f2708b);
                    this.f2708b = 0;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(67530);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo19933a() {
            AppMethodBeat.m2504i(67531);
            synchronized (this) {
                try {
                    if (this.f2708b != 0) {
                        TXCRTMPDownloader.access$300(TXCRTMPDownloader.this, this.f2708b);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67531);
                }
            }
        }

        /* renamed from: b */
        public DownloadStats mo19934b() {
            AppMethodBeat.m2504i(67532);
            DownloadStats downloadStats = null;
            synchronized (this) {
                try {
                    if (this.f2708b != 0) {
                        downloadStats = TXCRTMPDownloader.access$400(TXCRTMPDownloader.this, this.f2708b);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67532);
                }
            }
            return downloadStats;
        }
    }

    private native DownloadStats nativeGetStats(long j);

    private native long nativeInitRtmpHandler(String str, String str2, boolean z, boolean z2);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    private native void nativeUninitRtmpHandler(long j);

    static /* synthetic */ long access$000(TXCRTMPDownloader tXCRTMPDownloader, String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(67470);
        long nativeInitRtmpHandler = tXCRTMPDownloader.nativeInitRtmpHandler(str, str2, z, z2);
        AppMethodBeat.m2505o(67470);
        return nativeInitRtmpHandler;
    }

    static /* synthetic */ void access$100(TXCRTMPDownloader tXCRTMPDownloader, long j) {
        AppMethodBeat.m2504i(67471);
        tXCRTMPDownloader.nativeStart(j);
        AppMethodBeat.m2505o(67471);
    }

    static /* synthetic */ void access$200(TXCRTMPDownloader tXCRTMPDownloader, long j) {
        AppMethodBeat.m2504i(67472);
        tXCRTMPDownloader.nativeUninitRtmpHandler(j);
        AppMethodBeat.m2505o(67472);
    }

    static /* synthetic */ void access$300(TXCRTMPDownloader tXCRTMPDownloader, long j) {
        AppMethodBeat.m2504i(67473);
        tXCRTMPDownloader.nativeStop(j);
        AppMethodBeat.m2505o(67473);
    }

    static /* synthetic */ DownloadStats access$400(TXCRTMPDownloader tXCRTMPDownloader, long j) {
        AppMethodBeat.m2504i(67474);
        DownloadStats nativeGetStats = tXCRTMPDownloader.nativeGetStats(j);
        AppMethodBeat.m2505o(67474);
        return nativeGetStats;
    }

    static /* synthetic */ void access$500(TXCRTMPDownloader tXCRTMPDownloader, boolean z) {
        AppMethodBeat.m2504i(67475);
        tXCRTMPDownloader.internalReconnect(z);
        AppMethodBeat.m2505o(67475);
    }

    static /* synthetic */ void access$600(TXCRTMPDownloader tXCRTMPDownloader) {
        AppMethodBeat.m2504i(67476);
        tXCRTMPDownloader.startInternal();
        AppMethodBeat.m2505o(67476);
    }

    public TXCRTMPDownloader(Context context) {
        super(context);
        AppMethodBeat.m2504i(67460);
        this.TAG = "network.TXCRTMPDownloader";
        this.MSG_RECONNECT = 101;
        this.MSG_EVENT = 102;
        this.mPlayUrl = "";
        this.mQuicChannel = false;
        this.mServerIp = "";
        this.mCurrentThread = null;
        this.mRTMPThreadLock = null;
        this.mThread = null;
        this.mHandler = null;
        this.mIsPlayRtmpAccStream = false;
        this.mEnableNearestIP = false;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mLastNetworkType = 255;
        this.mRTMPThreadLock = new Object();
        AppMethodBeat.m2505o(67460);
    }

    private void startInternal() {
        AppMethodBeat.m2504i(67461);
        if (this.mQuicChannel) {
            this.mConnectCountQuic++;
        } else {
            this.mConnectCountTcp++;
        }
        synchronized (this.mRTMPThreadLock) {
            try {
                this.mCurrentThread = new C8821a(this.mPlayUrl, this.mQuicChannel);
                this.mCurrentThread.start();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67461);
            }
        }
    }

    private void postReconnectMsg() {
        AppMethodBeat.m2504i(67462);
        Message message = new Message();
        message.what = 101;
        if (this.mHandler != null) {
            this.mHandler.sendMessageDelayed(message, (long) (this.connectRetryInterval * 1000));
        }
        AppMethodBeat.m2505o(67462);
    }

    private void reconnect(final boolean z) {
        AppMethodBeat.m2504i(67463);
        synchronized (this.mRTMPThreadLock) {
            try {
                if (this.mCurrentThread != null) {
                    this.mCurrentThread.mo19933a();
                    this.mCurrentThread = null;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(67463);
                }
            }
        }
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(67618);
                    TXCRTMPDownloader.access$500(TXCRTMPDownloader.this, z);
                    AppMethodBeat.m2505o(67618);
                }
            }, (long) (this.connectRetryInterval * 1000));
        }
        AppMethodBeat.m2505o(67463);
    }

    private void internalReconnect(boolean z) {
        AppMethodBeat.m2504i(67464);
        if (!this.mIsRunning) {
            AppMethodBeat.m2505o(67464);
        } else if (!this.mIsPlayRtmpAccStream || this.mLastNetworkType == C17778b.m27752c(this.mApplicationContext)) {
            boolean z2 = this.mQuicChannel;
            if (this.mIsPlayRtmpAccStream) {
                int i;
                if (this.mEnableNearestIP) {
                    boolean i2 = z;
                } else {
                    i2 = 0;
                }
                if (z2) {
                    i2 = 1;
                }
                if (!(i2 == 0 || this.mVecPlayUrls == null || this.mVecPlayUrls.isEmpty())) {
                    C17794e c17794e = (C17794e) this.mVecPlayUrls.get(0);
                    this.mVecPlayUrls.remove(0);
                    this.mPlayUrl = c17794e.f4226a;
                    this.mQuicChannel = c17794e.f4227b;
                }
            }
            if (z2 && this.mHasTcpPlayUrl) {
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
                startInternal();
                AppMethodBeat.m2505o(67464);
            } else if (this.connectRetryTimes < this.connectRetryLimit) {
                this.connectRetryTimes++;
                TXCLog.m15675d("network.TXCRTMPDownloader", "reconnect retry count:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
                startInternal();
                AppMethodBeat.m2505o(67464);
            } else {
                TXCLog.m15676e("network.TXCRTMPDownloader", "reconnect all times retried, send failed event ");
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT);
                AppMethodBeat.m2505o(67464);
            }
        } else {
            this.mLastNetworkType = C17778b.m27752c(this.mApplicationContext);
            if (this.mRestartListener != null) {
                this.mRestartListener.onRestartDownloader();
            }
            AppMethodBeat.m2505o(67464);
        }
    }

    public void sendNotifyEvent(int i, String str) {
        AppMethodBeat.m2504i(67465);
        if (str.isEmpty()) {
            sendNotifyEvent(i);
            AppMethodBeat.m2505o(67465);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.m2505o(67465);
    }

    public void sendNotifyEvent(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(67466);
        if (i == 0 || i == 1) {
            if (i != 1) {
                z = false;
            }
            reconnect(z);
            AppMethodBeat.m2505o(67466);
            return;
        }
        super.sendNotifyEvent(i);
        AppMethodBeat.m2505o(67466);
    }

    public void startDownload(Vector<C17794e> vector, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(67467);
        if (this.mIsRunning) {
            AppMethodBeat.m2505o(67467);
        } else if (vector == null || vector.isEmpty()) {
            AppMethodBeat.m2505o(67467);
        } else {
            this.mEnableMessage = z3;
            this.mIsPlayRtmpAccStream = z;
            this.mEnableNearestIP = z2;
            this.mVecPlayUrls = vector;
            this.mHasTcpPlayUrl = false;
            for (int i = 0; i < this.mVecPlayUrls.size(); i++) {
                if (!((C17794e) this.mVecPlayUrls.elementAt(i)).f4227b) {
                    this.mHasTcpPlayUrl = true;
                    break;
                }
            }
            C17794e c17794e = (C17794e) this.mVecPlayUrls.get(0);
            this.mVecPlayUrls.remove(0);
            this.mPlayUrl = c17794e.f4226a;
            this.mQuicChannel = c17794e.f4227b;
            this.mIsRunning = true;
            TXCLog.m15675d("network.TXCRTMPDownloader", "start pull with url:" + this.mPlayUrl + " quic:" + (this.mQuicChannel ? "yes" : "no"));
            this.mConnectCountQuic = 0;
            this.mConnectCountTcp = 0;
            this.connectRetryTimes = 0;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("RTMP_PULL");
                this.mThread.start();
            }
            this.mHandler = new Handler(this.mThread.getLooper()) {
                public void handleMessage(Message message) {
                    AppMethodBeat.m2504i(67594);
                    if (message.what == 101) {
                        TXCRTMPDownloader.access$600(TXCRTMPDownloader.this);
                    }
                    AppMethodBeat.m2505o(67594);
                }
            };
            startInternal();
            AppMethodBeat.m2505o(67467);
        }
    }

    public void stopDownload() {
        AppMethodBeat.m2504i(67468);
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mVecPlayUrls.removeAllElements();
            this.mVecPlayUrls = null;
            this.mIsPlayRtmpAccStream = false;
            this.mEnableNearestIP = false;
            TXCLog.m15675d("network.TXCRTMPDownloader", "stop pull");
            synchronized (this.mRTMPThreadLock) {
                try {
                    if (this.mCurrentThread != null) {
                        this.mCurrentThread.mo19933a();
                        this.mCurrentThread = null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(67468);
                    }
                }
            }
            if (this.mThread != null) {
                this.mThread.quit();
                this.mThread = null;
            }
            if (this.mHandler != null) {
                this.mHandler = null;
            }
            AppMethodBeat.m2505o(67468);
            return;
        }
        AppMethodBeat.m2505o(67468);
    }

    public DownloadStats getDownloadStats() {
        DownloadStats b;
        AppMethodBeat.m2504i(67469);
        synchronized (this.mRTMPThreadLock) {
            try {
                if (this.mCurrentThread != null) {
                    b = this.mCurrentThread.mo19934b();
                } else {
                    b = null;
                    AppMethodBeat.m2505o(67469);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67469);
            }
        }
        return b;
    }

    public String getCurrentStreamUrl() {
        return this.mPlayUrl;
    }

    public boolean isQuicChannel() {
        return this.mQuicChannel;
    }

    public int getConnectCountQuic() {
        return this.mConnectCountQuic;
    }

    public int getConnectCountTcp() {
        return this.mConnectCountTcp;
    }
}
