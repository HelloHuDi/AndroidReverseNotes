package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.liteav.basic.p811g.C25649b;
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
    protected C25665f mListener = null;
    protected C0946a mNotifyListener = null;
    protected String mOriginUrl = "";
    protected C0969a mRestartListener = null;

    /* renamed from: com.tencent.liteav.network.TXIStreamDownloader$a */
    public interface C0969a {
        void onRestartDownloader();
    }

    public abstract void startDownload(Vector<C17794e> vector, boolean z, boolean z2, boolean z3);

    public abstract void stopDownload();

    public TXIStreamDownloader(Context context) {
        this.mApplicationContext = context;
    }

    public void setListener(C25665f c25665f) {
        this.mListener = c25665f;
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setNotifyListener(C0946a c0946a) {
        this.mNotifyListener = c0946a;
    }

    public void setRestartListener(C0969a c0969a) {
        this.mRestartListener = c0969a;
    }

    public void sendNotifyEvent(int i) {
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i, null);
        }
    }

    public void onRecvVideoData(byte[] bArr, int i, long j, long j2, int i2) {
        if (this.mListener != null) {
            C25649b c25649b = new C25649b();
            c25649b.f5251a = bArr;
            c25649b.f5252b = i;
            c25649b.f5258h = j;
            c25649b.f5257g = j2;
            c25649b.f5259i = i2;
            this.mListener.onPullNAL(c25649b);
        }
    }

    public void onRecvAudioData(byte[] bArr, int i, int i2, int i3) {
        if (this.mListener != null) {
            C25648a c25648a = new C25648a();
            c25648a.f5250f = bArr;
            c25648a.f5249e = (long) i;
            if (i2 == 10) {
                if (i3 == 1) {
                    c25648a.f5248d = C41678a.f16929k;
                } else {
                    c25648a.f5248d = C41678a.f16930l;
                }
                if (c25648a.f5248d == C41678a.f16929k) {
                    c25648a.f5247c = C41678a.f16926h;
                }
            }
            if (i2 == 2) {
                c25648a.f5248d = C41678a.f16931m;
            }
            this.mListener.onPullAudio(c25648a);
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
