package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader.DownloadStats;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Vector;
import javax.net.ssl.SSLException;

public class TXCFLVDownloader extends TXIStreamDownloader {
    private final int CONNECT_TIMEOUT;
    private final int FLV_HEAD_SIZE;
    private final int MAX_FRAME_SIZE;
    private final int MSG_CONNECT;
    private final int MSG_DISCONNECT;
    private final int MSG_QUIT;
    private final int MSG_RECONNECT;
    private final int MSG_RECV_DATA;
    private final int MSG_RESUME;
    private final int MSG_SEEK;
    private final int READ_STREAM_SIZE;
    public final String TAG;
    private HttpURLConnection mConnection;
    private long mContentLength;
    private long mDownloadedSize;
    private long mFLVParser;
    private Handler mFlvHandler;
    private HandlerThread mFlvThread;
    private InputStream mInputStream;
    private byte[] mPacketBytes;
    private String mPlayUrl;
    private boolean mRecvData;
    private DownloadStats mStats;
    private boolean mbFirstAudio;
    private boolean mbFirstVideo;

    private native void nativeCleanData(long j);

    private native long nativeInitFlvHander(String str, int i, boolean z);

    private native int nativeParseData(long j, byte[] bArr, int i);

    private native void nativeUninitFlvhander(long j);

    static /* synthetic */ void access$000(TXCFLVDownloader tXCFLVDownloader) {
        AppMethodBeat.m2504i(67614);
        tXCFLVDownloader.processMsgConnect();
        AppMethodBeat.m2505o(67614);
    }

    static /* synthetic */ void access$100(TXCFLVDownloader tXCFLVDownloader) {
        AppMethodBeat.m2504i(67615);
        tXCFLVDownloader.processMsgRecvData();
        AppMethodBeat.m2505o(67615);
    }

    static /* synthetic */ void access$200(TXCFLVDownloader tXCFLVDownloader) {
        AppMethodBeat.m2504i(67616);
        tXCFLVDownloader.processMsgDisConnect();
        AppMethodBeat.m2505o(67616);
    }

    static /* synthetic */ void access$300(TXCFLVDownloader tXCFLVDownloader) {
        AppMethodBeat.m2504i(67617);
        tXCFLVDownloader.processMsgReconnect();
        AppMethodBeat.m2505o(67617);
    }

    public TXCFLVDownloader(Context context) {
        super(context);
        AppMethodBeat.m2504i(67596);
        this.TAG = "network.TXCFLVDownloader";
        this.FLV_HEAD_SIZE = 9;
        this.MAX_FRAME_SIZE = 1048576;
        this.MSG_CONNECT = 100;
        this.MSG_RECV_DATA = 101;
        this.MSG_DISCONNECT = 102;
        this.MSG_RECONNECT = 103;
        this.MSG_SEEK = 104;
        this.MSG_RESUME = 105;
        this.MSG_QUIT = 106;
        this.CONNECT_TIMEOUT = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.READ_STREAM_SIZE = 1388;
        this.mFlvThread = null;
        this.mFlvHandler = null;
        this.mInputStream = null;
        this.mConnection = null;
        this.mPacketBytes = null;
        this.mRecvData = false;
        this.mContentLength = 0;
        this.mDownloadedSize = 0;
        this.mFLVParser = 0;
        this.mPlayUrl = "";
        this.mbFirstVideo = false;
        this.mbFirstAudio = false;
        this.mStats = null;
        this.mStats = new DownloadStats();
        this.mStats.afterParseAudioBytes = 0;
        this.mStats.dnsTS = 0;
        this.mStats.startTS = TXCTimeUtil.getTimeTick();
        AppMethodBeat.m2505o(67596);
    }

    private void processMsgConnect() {
        AppMethodBeat.m2504i(67597);
        try {
            connect();
            if (this.mFLVParser == 0) {
                this.mFLVParser = nativeInitFlvHander(this.mPlayUrl, 0, this.mEnableMessage);
            }
            if (this.mFlvHandler != null) {
                this.mFlvHandler.sendEmptyMessage(101);
            }
            AppMethodBeat.m2505o(67597);
        } catch (SocketTimeoutException e) {
            TXCLog.m15676e("network.TXCFLVDownloader", "socket timeout, reconnect");
            postReconnectMsg();
            AppMethodBeat.m2505o(67597);
        } catch (FileNotFoundException e2) {
            TXCLog.m15676e("network.TXCFLVDownloader", "file not found, reconnect");
            postReconnectMsg();
            AppMethodBeat.m2505o(67597);
        } catch (Exception e3) {
            TXCLog.m15676e("network.TXCFLVDownloader", "exception, reconnect");
            postReconnectMsg();
            AppMethodBeat.m2505o(67597);
        } catch (Error e4) {
            TXCLog.m15676e("network.TXCFLVDownloader", "error, reconnect");
            postReconnectMsg();
            AppMethodBeat.m2505o(67597);
        }
    }

    private void processMsgRecvData() {
        int i = 0;
        AppMethodBeat.m2504i(67598);
        if (this.mInputStream != null) {
            try {
                int read = this.mInputStream.read(this.mPacketBytes, 0, 1388);
                if (read > 0) {
                    this.mDownloadedSize += (long) read;
                    if (!this.mRecvData) {
                        TXCLog.m15679w("network.TXCFLVDownloader", "flv play receive first data");
                        this.mRecvData = true;
                    }
                    if (this.mFLVParser != 0) {
                        DownloadStats downloadStats = this.mStats;
                        downloadStats.beforeParseVideoBytes += (long) read;
                        i = nativeParseData(this.mFLVParser, this.mPacketBytes, read);
                    }
                    if (i > 1048576) {
                        TXCLog.m15676e("network.TXCFLVDownloader", "flv play parse frame: " + i + " > 1048576,sart reconnect");
                        postReconnectMsg();
                        AppMethodBeat.m2505o(67598);
                        return;
                    }
                } else if (read < 0) {
                    TXCLog.m15679w("network.TXCFLVDownloader", "http read: " + read + " < 0, start reconnect");
                    postReconnectMsg();
                    AppMethodBeat.m2505o(67598);
                    return;
                }
                if (this.mFlvHandler != null) {
                    this.mFlvHandler.sendEmptyMessage(101);
                }
                AppMethodBeat.m2505o(67598);
                return;
            } catch (SocketTimeoutException e) {
                TXCLog.m15679w("network.TXCFLVDownloader", "socket timeout start reconnect");
                postReconnectMsg();
                AppMethodBeat.m2505o(67598);
                return;
            } catch (SocketException e2) {
                TXCLog.m15679w("network.TXCFLVDownloader", "socket exception start reconnect");
                postReconnectMsg();
                AppMethodBeat.m2505o(67598);
                return;
            } catch (SSLException e3) {
                TXCLog.m15679w("network.TXCFLVDownloader", "ssl exception start reconnect");
                postReconnectMsg();
                AppMethodBeat.m2505o(67598);
                return;
            } catch (EOFException e4) {
                TXCLog.m15679w("network.TXCFLVDownloader", "eof exception start reconnect");
                postReconnectMsg();
                AppMethodBeat.m2505o(67598);
                return;
            } catch (Exception e5) {
                TXCLog.m15676e("network.TXCFLVDownloader", "exception");
                this.mInputStream = null;
                this.mConnection = null;
                AppMethodBeat.m2505o(67598);
                return;
            } catch (Error e6) {
                TXCLog.m15676e("network.TXCFLVDownloader", "error");
                this.mInputStream = null;
                this.mConnection = null;
            }
        }
        AppMethodBeat.m2505o(67598);
    }

    private void processMsgDisConnect() {
        AppMethodBeat.m2504i(67599);
        try {
            disconnect();
        } catch (Exception e) {
        }
        if (this.mFLVParser != 0) {
            nativeUninitFlvhander(this.mFLVParser);
            this.mFLVParser = 0;
        }
        AppMethodBeat.m2505o(67599);
    }

    private void processMsgReconnect() {
        AppMethodBeat.m2504i(67600);
        reconnect();
        AppMethodBeat.m2505o(67600);
    }

    private void startInternal() {
        AppMethodBeat.m2504i(67601);
        if (this.mFlvThread == null) {
            this.mFlvThread = new HandlerThread("FlvThread");
            this.mFlvThread.start();
        }
        if (this.mFlvHandler == null) {
            this.mFlvHandler = new Handler(this.mFlvThread.getLooper()) {
                public void handleMessage(Message message) {
                    AppMethodBeat.m2504i(67478);
                    switch (message.what) {
                        case 100:
                            TXCFLVDownloader.access$000(TXCFLVDownloader.this);
                            AppMethodBeat.m2505o(67478);
                            return;
                        case 101:
                            TXCFLVDownloader.access$100(TXCFLVDownloader.this);
                            AppMethodBeat.m2505o(67478);
                            return;
                        case 102:
                            TXCFLVDownloader.access$200(TXCFLVDownloader.this);
                            AppMethodBeat.m2505o(67478);
                            return;
                        case 103:
                            TXCFLVDownloader.access$300(TXCFLVDownloader.this);
                            AppMethodBeat.m2505o(67478);
                            return;
                        case 106:
                            try {
                                Looper.myLooper().quit();
                                AppMethodBeat.m2505o(67478);
                                return;
                            } catch (Exception e) {
                                break;
                            }
                    }
                    AppMethodBeat.m2505o(67478);
                }
            };
        }
        postConnectMsg();
        AppMethodBeat.m2505o(67601);
    }

    private void reconnect() {
        AppMethodBeat.m2504i(67602);
        processMsgDisConnect();
        if (this.connectRetryTimes < this.connectRetryLimit) {
            this.connectRetryTimes++;
            TXCLog.m15675d("network.TXCFLVDownloader", "reconnect retry time:" + this.connectRetryTimes + ", limit:" + this.connectRetryLimit);
            processMsgConnect();
            sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
            AppMethodBeat.m2505o(67602);
            return;
        }
        TXCLog.m15676e("network.TXCFLVDownloader", "reconnect all times retried, send failed event ");
        sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT);
        AppMethodBeat.m2505o(67602);
    }

    private void postReconnectMsg() {
        AppMethodBeat.m2504i(67603);
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendEmptyMessageDelayed(103, (long) (this.connectRetryInterval * 1000));
        }
        AppMethodBeat.m2505o(67603);
    }

    private void postDisconnectMsg() {
        AppMethodBeat.m2504i(67604);
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendEmptyMessage(102);
        }
        AppMethodBeat.m2505o(67604);
    }

    private void postConnectMsg() {
        AppMethodBeat.m2504i(67605);
        this.mInputStream = null;
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        Message message = new Message();
        message.what = 100;
        message.arg1 = 0;
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendMessage(message);
        }
        AppMethodBeat.m2505o(67605);
    }

    private void connect() {
        AppMethodBeat.m2504i(67606);
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        this.mConnection = (HttpURLConnection) new URL(this.mPlayUrl).openConnection();
        this.mStats.dnsTS = TXCTimeUtil.getTimeTick();
        this.mConnection.setConnectTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        this.mConnection.setReadTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        this.mConnection.setRequestProperty("Accept-Encoding", "identity");
        this.mConnection.setInstanceFollowRedirects(true);
        if (this.mHeaders != null) {
            for (Entry entry : this.mHeaders.entrySet()) {
                this.mConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.mConnection.connect();
        this.mInputStream = this.mConnection.getInputStream();
        this.mPacketBytes = new byte[1388];
        this.mRecvData = false;
        this.mContentLength = (long) this.mConnection.getContentLength();
        this.mDownloadedSize = 0;
        this.mStats.serverIP = InetAddress.getByName(this.mConnection.getURL().getHost()).getHostAddress();
        this.mStats.connTS = TXCTimeUtil.getTimeTick();
        sendNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
        AppMethodBeat.m2505o(67606);
    }

    public String getRealStreamUrl() {
        AppMethodBeat.m2504i(67607);
        if (this.mConnection != null) {
            String url = this.mConnection.getURL().toString();
            AppMethodBeat.m2505o(67607);
            return url;
        }
        AppMethodBeat.m2505o(67607);
        return null;
    }

    private void disconnect() {
        AppMethodBeat.m2504i(67608);
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        if (this.mInputStream != null) {
            this.mInputStream.close();
            this.mInputStream = null;
        }
        AppMethodBeat.m2505o(67608);
    }

    public DownloadStats getDownloadStats() {
        AppMethodBeat.m2504i(67609);
        DownloadStats downloadStats = new DownloadStats();
        downloadStats.afterParseAudioBytes = this.mStats.afterParseAudioBytes;
        downloadStats.afterParseVideoBytes = this.mStats.afterParseVideoBytes;
        downloadStats.beforeParseVideoBytes = this.mStats.beforeParseVideoBytes;
        downloadStats.beforeParseAudioBytes = this.mStats.beforeParseAudioBytes;
        downloadStats.startTS = this.mStats.startTS;
        downloadStats.dnsTS = this.mStats.dnsTS;
        downloadStats.connTS = this.mStats.connTS;
        downloadStats.firstAudioTS = this.mStats.firstAudioTS;
        downloadStats.firstVideoTS = this.mStats.firstVideoTS;
        downloadStats.serverIP = this.mStats.serverIP;
        AppMethodBeat.m2505o(67609);
        return downloadStats;
    }

    public void startDownload(Vector<C17794e> vector, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(67610);
        if (this.mIsRunning) {
            AppMethodBeat.m2505o(67610);
        } else if (vector == null || vector.isEmpty()) {
            AppMethodBeat.m2505o(67610);
        } else {
            this.mEnableMessage = z3;
            this.mIsRunning = true;
            this.mPlayUrl = ((C17794e) vector.get(0)).f4226a;
            TXCLog.m15675d("network.TXCFLVDownloader", "start pull with url " + this.mPlayUrl);
            startInternal();
            AppMethodBeat.m2505o(67610);
        }
    }

    public void stopDownload() {
        AppMethodBeat.m2504i(67611);
        if (this.mIsRunning) {
            this.mIsRunning = false;
            TXCLog.m15675d("network.TXCFLVDownloader", "stop pull");
            try {
                if (this.mFlvHandler != null) {
                    this.mFlvHandler.removeCallbacksAndMessages(null);
                    this.mFlvHandler.sendEmptyMessage(102);
                    this.mFlvHandler.sendEmptyMessage(106);
                    this.mFlvHandler = null;
                }
                AppMethodBeat.m2505o(67611);
                return;
            } catch (Exception e) {
                AppMethodBeat.m2505o(67611);
                return;
            }
        }
        AppMethodBeat.m2505o(67611);
    }

    public void onRecvVideoData(byte[] bArr, int i, long j, long j2, int i2) {
        AppMethodBeat.m2504i(67612);
        if (!this.mbFirstVideo) {
            this.mbFirstVideo = true;
            this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
            TXCLog.m15675d("network.TXCFLVDownloader", "receive first video with ts " + this.mStats.firstVideoTS);
        }
        DownloadStats downloadStats = this.mStats;
        downloadStats.afterParseVideoBytes += (long) bArr.length;
        super.onRecvVideoData(bArr, i, j, j2, i2);
        AppMethodBeat.m2505o(67612);
    }

    public void onRecvAudioData(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(67613);
        if (!this.mbFirstAudio) {
            this.mbFirstAudio = true;
            this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
            TXCLog.m15675d("network.TXCFLVDownloader", "receive first audio with ts " + this.mStats.firstAudioTS);
        }
        DownloadStats downloadStats = this.mStats;
        downloadStats.afterParseAudioBytes += (long) bArr.length;
        super.onRecvAudioData(bArr, i, i2, i3);
        AppMethodBeat.m2505o(67613);
    }
}
