package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
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
    private a mCurrentThread;
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
    private Vector<e> mVecPlayUrls;

    class a extends Thread {
        private long b = 0;
        private String c;
        private boolean d;

        a(String str, boolean z) {
            super("RTMPDownLoad");
            this.c = str;
            this.d = z;
        }

        public void run() {
            AppMethodBeat.i(67530);
            synchronized (this) {
                try {
                    this.b = TXCRTMPDownloader.access$000(TXCRTMPDownloader.this, TXCRTMPDownloader.this.mOriginUrl, this.c, this.d, TXCRTMPDownloader.this.mEnableMessage);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(67530);
                }
            }
            TXCRTMPDownloader.access$100(TXCRTMPDownloader.this, this.b);
            synchronized (this) {
                try {
                    TXCRTMPDownloader.access$200(TXCRTMPDownloader.this, this.b);
                    this.b = 0;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(67530);
                    }
                }
            }
        }

        public void a() {
            AppMethodBeat.i(67531);
            synchronized (this) {
                try {
                    if (this.b != 0) {
                        TXCRTMPDownloader.access$300(TXCRTMPDownloader.this, this.b);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(67531);
                }
            }
        }

        public DownloadStats b() {
            AppMethodBeat.i(67532);
            DownloadStats downloadStats = null;
            synchronized (this) {
                try {
                    if (this.b != 0) {
                        downloadStats = TXCRTMPDownloader.access$400(TXCRTMPDownloader.this, this.b);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(67532);
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
        AppMethodBeat.i(67470);
        long nativeInitRtmpHandler = tXCRTMPDownloader.nativeInitRtmpHandler(str, str2, z, z2);
        AppMethodBeat.o(67470);
        return nativeInitRtmpHandler;
    }

    static /* synthetic */ void access$100(TXCRTMPDownloader tXCRTMPDownloader, long j) {
        AppMethodBeat.i(67471);
        tXCRTMPDownloader.nativeStart(j);
        AppMethodBeat.o(67471);
    }

    static /* synthetic */ void access$200(TXCRTMPDownloader tXCRTMPDownloader, long j) {
        AppMethodBeat.i(67472);
        tXCRTMPDownloader.nativeUninitRtmpHandler(j);
        AppMethodBeat.o(67472);
    }

    static /* synthetic */ void access$300(TXCRTMPDownloader tXCRTMPDownloader, long j) {
        AppMethodBeat.i(67473);
        tXCRTMPDownloader.nativeStop(j);
        AppMethodBeat.o(67473);
    }

    static /* synthetic */ DownloadStats access$400(TXCRTMPDownloader tXCRTMPDownloader, long j) {
        AppMethodBeat.i(67474);
        DownloadStats nativeGetStats = tXCRTMPDownloader.nativeGetStats(j);
        AppMethodBeat.o(67474);
        return nativeGetStats;
    }

    static /* synthetic */ void access$500(TXCRTMPDownloader tXCRTMPDownloader, boolean z) {
        AppMethodBeat.i(67475);
        tXCRTMPDownloader.internalReconnect(z);
        AppMethodBeat.o(67475);
    }

    static /* synthetic */ void access$600(TXCRTMPDownloader tXCRTMPDownloader) {
        AppMethodBeat.i(67476);
        tXCRTMPDownloader.startInternal();
        AppMethodBeat.o(67476);
    }

    public TXCRTMPDownloader(Context context) {
        super(context);
        AppMethodBeat.i(67460);
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
        AppMethodBeat.o(67460);
    }

    private void startInternal() {
        AppMethodBeat.i(67461);
        if (this.mQuicChannel) {
            this.mConnectCountQuic++;
        } else {
            this.mConnectCountTcp++;
        }
        synchronized (this.mRTMPThreadLock) {
            try {
                this.mCurrentThread = new a(this.mPlayUrl, this.mQuicChannel);
                this.mCurrentThread.start();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67461);
            }
        }
    }

    private void postReconnectMsg() {
        AppMethodBeat.i(67462);
        Message message = new Message();
        message.what = 101;
        if (this.mHandler != null) {
            this.mHandler.sendMessageDelayed(message, (long) (this.connectRetryInterval * 1000));
        }
        AppMethodBeat.o(67462);
    }

    private void reconnect(final boolean z) {
        AppMethodBeat.i(67463);
        synchronized (this.mRTMPThreadLock) {
            try {
                if (this.mCurrentThread != null) {
                    this.mCurrentThread.a();
                    this.mCurrentThread = null;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(67463);
                }
            }
        }
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67618);
                    TXCRTMPDownloader.access$500(TXCRTMPDownloader.this, z);
                    AppMethodBeat.o(67618);
                }
            }, (long) (this.connectRetryInterval * 1000));
        }
        AppMethodBeat.o(67463);
    }

    private void internalReconnect(boolean z) {
        AppMethodBeat.i(67464);
        if (!this.mIsRunning) {
            AppMethodBeat.o(67464);
        } else if (!this.mIsPlayRtmpAccStream || this.mLastNetworkType == b.c(this.mApplicationContext)) {
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
                    e eVar = (e) this.mVecPlayUrls.get(0);
                    this.mVecPlayUrls.remove(0);
                    this.mPlayUrl = eVar.a;
                    this.mQuicChannel = eVar.b;
                }
            }
            if (z2 && this.mHasTcpPlayUrl) {
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
                startInternal();
                AppMethodBeat.o(67464);
            } else if (this.connectRetryTimes < this.connectRetryLimit) {
                this.connectRetryTimes++;
                TXCLog.d("network.TXCRTMPDownloader", "reconnect retry count:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
                startInternal();
                AppMethodBeat.o(67464);
            } else {
                TXCLog.e("network.TXCRTMPDownloader", "reconnect all times retried, send failed event ");
                sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT);
                AppMethodBeat.o(67464);
            }
        } else {
            this.mLastNetworkType = b.c(this.mApplicationContext);
            if (this.mRestartListener != null) {
                this.mRestartListener.onRestartDownloader();
            }
            AppMethodBeat.o(67464);
        }
    }

    public void sendNotifyEvent(int i, String str) {
        AppMethodBeat.i(67465);
        if (str.isEmpty()) {
            sendNotifyEvent(i);
            AppMethodBeat.o(67465);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.o(67465);
    }

    public void sendNotifyEvent(int i) {
        boolean z = true;
        AppMethodBeat.i(67466);
        if (i == 0 || i == 1) {
            if (i != 1) {
                z = false;
            }
            reconnect(z);
            AppMethodBeat.o(67466);
            return;
        }
        super.sendNotifyEvent(i);
        AppMethodBeat.o(67466);
    }

    public void startDownload(Vector<e> vector, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(67467);
        if (this.mIsRunning) {
            AppMethodBeat.o(67467);
        } else if (vector == null || vector.isEmpty()) {
            AppMethodBeat.o(67467);
        } else {
            this.mEnableMessage = z3;
            this.mIsPlayRtmpAccStream = z;
            this.mEnableNearestIP = z2;
            this.mVecPlayUrls = vector;
            this.mHasTcpPlayUrl = false;
            for (int i = 0; i < this.mVecPlayUrls.size(); i++) {
                if (!((e) this.mVecPlayUrls.elementAt(i)).b) {
                    this.mHasTcpPlayUrl = true;
                    break;
                }
            }
            e eVar = (e) this.mVecPlayUrls.get(0);
            this.mVecPlayUrls.remove(0);
            this.mPlayUrl = eVar.a;
            this.mQuicChannel = eVar.b;
            this.mIsRunning = true;
            TXCLog.d("network.TXCRTMPDownloader", "start pull with url:" + this.mPlayUrl + " quic:" + (this.mQuicChannel ? "yes" : "no"));
            this.mConnectCountQuic = 0;
            this.mConnectCountTcp = 0;
            this.connectRetryTimes = 0;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("RTMP_PULL");
                this.mThread.start();
            }
            this.mHandler = new Handler(this.mThread.getLooper()) {
                public void handleMessage(Message message) {
                    AppMethodBeat.i(67594);
                    if (message.what == 101) {
                        TXCRTMPDownloader.access$600(TXCRTMPDownloader.this);
                    }
                    AppMethodBeat.o(67594);
                }
            };
            startInternal();
            AppMethodBeat.o(67467);
        }
    }

    public void stopDownload() {
        AppMethodBeat.i(67468);
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mVecPlayUrls.removeAllElements();
            this.mVecPlayUrls = null;
            this.mIsPlayRtmpAccStream = false;
            this.mEnableNearestIP = false;
            TXCLog.d("network.TXCRTMPDownloader", "stop pull");
            synchronized (this.mRTMPThreadLock) {
                try {
                    if (this.mCurrentThread != null) {
                        this.mCurrentThread.a();
                        this.mCurrentThread = null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(67468);
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
            AppMethodBeat.o(67468);
            return;
        }
        AppMethodBeat.o(67468);
    }

    public DownloadStats getDownloadStats() {
        DownloadStats b;
        AppMethodBeat.i(67469);
        synchronized (this.mRTMPThreadLock) {
            try {
                if (this.mCurrentThread != null) {
                    b = this.mCurrentThread.b();
                } else {
                    b = null;
                    AppMethodBeat.o(67469);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67469);
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
