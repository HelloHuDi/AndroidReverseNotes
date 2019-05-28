package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.g.b;
import com.tencent.liteav.network.TXCStreamDownloader.DownloadStats;
import java.util.Map;
import java.util.Vector;

public abstract class TXIStreamDownloader {
    public int connectRetryInterval = 3;
    public int connectRetryLimit = 3;
    public int connectRetryTimes = 0;
    protected Context mApplicationContext = null;
    protected boolean mEnableMessage = false;
    protected Map<String, String> mHeaders;
    protected boolean mIsRunning = false;
    protected f mListener = null;
    protected com.tencent.liteav.basic.d.a mNotifyListener = null;
    protected String mOriginUrl = "";
    protected a mRestartListener = null;

    public interface a {
        void onRestartDownloader();
    }

    public abstract void startDownload(Vector<e> vector, boolean z, boolean z2, boolean z3);

    public abstract void stopDownload();

    public TXIStreamDownloader(Context context) {
        this.mApplicationContext = context;
    }

    public void setListener(f fVar) {
        this.mListener = fVar;
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setNotifyListener(com.tencent.liteav.basic.d.a aVar) {
        this.mNotifyListener = aVar;
    }

    public void setRestartListener(a aVar) {
        this.mRestartListener = aVar;
    }

    public void sendNotifyEvent(int i) {
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i, null);
        }
    }

    public void onRecvVideoData(byte[] bArr, int i, long j, long j2, int i2) {
        if (this.mListener != null) {
            b bVar = new b();
            bVar.a = bArr;
            bVar.b = i;
            bVar.h = j;
            bVar.g = j2;
            bVar.i = i2;
            this.mListener.onPullNAL(bVar);
        }
    }

    public void onRecvAudioData(byte[] bArr, int i, int i2, int i3) {
        if (this.mListener != null) {
            com.tencent.liteav.basic.g.a aVar = new com.tencent.liteav.basic.g.a();
            aVar.f = bArr;
            aVar.e = (long) i;
            if (i2 == 10) {
                if (i3 == 1) {
                    aVar.d = com.tencent.liteav.basic.a.a.k;
                } else {
                    aVar.d = com.tencent.liteav.basic.a.a.l;
                }
                if (aVar.d == com.tencent.liteav.basic.a.a.k) {
                    aVar.c = com.tencent.liteav.basic.a.a.h;
                }
            }
            if (i2 == 2) {
                aVar.d = com.tencent.liteav.basic.a.a.m;
            }
            this.mListener.onPullAudio(aVar);
        }
    }

    public DownloadStats getDownloadStats() {
        return null;
    }

    public void setOriginUrl(String str) {
        this.mOriginUrl = str;
    }

    public String getCurrentStreamUrl() {
        return null;
    }

    public String getRealStreamUrl() {
        return null;
    }

    public boolean isQuicChannel() {
        return false;
    }

    public int getConnectCountQuic() {
        return 0;
    }

    public int getConnectCountTcp() {
        return 0;
    }
}
