package com.tencent.tmassistantsdk.downloadservice;

import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class DownloadTask {
    public static final String TAG = "_DownloadTask";
    protected DownloadInfo mDownloadInfo = null;
    HttpClient mHttpClient = null;
    HttpGet mHttpGet = null;
    private boolean mIsRedirect = false;
    protected final byte[] mRecvBuf = new byte[4096];
    private String mRequestUrl;
    TMAssistantFile mSaveFile;
    protected boolean mStopTask = false;
    protected final int mTaskId = GlobalUtil.getMemUUID();
    private String startDownloadNetType = "wifi";

    static /* synthetic */ void access$000(DownloadTask downloadTask) {
        AppMethodBeat.i(75756);
        downloadTask.cancelInWorkThread();
        AppMethodBeat.o(75756);
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        AppMethodBeat.i(75744);
        this.mDownloadInfo = downloadInfo;
        AppMethodBeat.o(75744);
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public void cancel() {
        AppMethodBeat.i(75745);
        TMLog.i(TAG, "DownloadTask::cancel url: " + this.mDownloadInfo.mURL);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            l.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(75743);
                    DownloadTask.access$000(DownloadTask.this);
                    AppMethodBeat.o(75743);
                }
            });
            AppMethodBeat.o(75745);
            return;
        }
        cancelInWorkThread();
        AppMethodBeat.o(75745);
    }

    private void cancelInWorkThread() {
        AppMethodBeat.i(75746);
        this.mStopTask = true;
        if (!(this.mHttpGet == null || this.mHttpGet.isAborted())) {
            this.mHttpGet.abort();
        }
        AppMethodBeat.o(75746);
    }

    public String getDownloadURI() {
        return this.mDownloadInfo.mURL;
    }

    public int getPriority() {
        return this.mDownloadInfo.mPriority;
    }

    public void exec(String str) {
        AppMethodBeat.i(75747);
        this.startDownloadNetType = DownloadHelper.getNetStatus();
        this.mDownloadInfo.mTaskIsRunning = true;
        this.mDownloadInfo.updateStatus(2, false);
        boolean z = false;
        boolean z2 = true;
        while (z2) {
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 0);
            createNewChunkLogInfo.UUID = this.mDownloadInfo.mUUID;
            createNewChunkLogInfo.currentRetryCnt = (byte) this.mDownloadInfo.mRetryCnt;
            createNewChunkLogInfo.requestUrl = getDownloadURI();
            if (this.mStopTask) {
                break;
            }
            StopRequestException stopRequestException;
            boolean z3;
            try {
                Object Ij;
                if (!this.mIsRedirect || this.mRequestUrl == null || this.mRequestUrl.length() == 0) {
                    if (z) {
                        Ij = c.Ij(this.mDownloadInfo.mSecondaryUrl);
                    } else {
                        Ij = c.Ij(this.mDownloadInfo.mRequestURL);
                    }
                    this.mRequestUrl = Ij;
                } else {
                    Ij = this.mRequestUrl;
                }
                TMLog.i(TAG, "is redirect request: " + this.mIsRedirect);
                TMLog.i(TAG, "changeUrl = ".concat(String.valueOf(z)));
                TMLog.i(TAG, "url = ".concat(String.valueOf(Ij)));
                this.mIsRedirect = false;
                this.mHttpClient = HttpClientUtil.createHttpClient();
                HttpClientUtil.setProxy(this.mHttpClient);
                this.mHttpGet = new HttpGet();
                URI uri = new URI(Ij);
                this.mHttpGet.setURI(uri);
                setExtraHeaderParam(this.mHttpGet, this.mDownloadInfo.getHeaderParams());
                setRangeHeader(this.mHttpGet, createNewChunkLogInfo);
                if (uri.getScheme().equals("https")) {
                    SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                    socketFactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                    this.mHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, JsApiPauseDownloadTask.CTRL_INDEX));
                }
                TMLog.i(TAG, "start httpGet " + Thread.currentThread().getName());
                HttpResponse execute = this.mHttpClient.execute(this.mHttpGet);
                if (execute == null) {
                    stopRequestException = new StopRequestException(701, "response is null! " + Thread.currentThread().getName());
                    AppMethodBeat.o(75747);
                    throw stopRequestException;
                }
                handleResponseCode(execute, createNewChunkLogInfo);
                if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z2 = z3;
                }
                z2 = z3;
            } catch (ConnectTimeoutException e) {
                if (this.mStopTask) {
                    z3 = false;
                } else {
                    TMLog.i(TAG, "ConnectTimeoutException " + Thread.currentThread().getName());
                    ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    z3 = shouldRetryConnect();
                    if (!z3) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 601;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z2 = z3;
                }
            } catch (SocketTimeoutException e2) {
                if (this.mStopTask) {
                    z3 = false;
                } else {
                    TMLog.i(TAG, "SocketTimeoutException " + Thread.currentThread().getName());
                    ab.printErrStackTrace(TAG, e2, "", new Object[0]);
                    z3 = shouldRetryConnect();
                    if (!z3) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 602;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z2 = z3;
                }
            } catch (UnknownHostException e3) {
                if (this.mStopTask) {
                    z3 = false;
                } else {
                    TMLog.i(TAG, "UnknownHostException " + Thread.currentThread().getName());
                    ab.printErrStackTrace(TAG, e3, "", new Object[0]);
                    z3 = shouldRetryConnect();
                    if (!z3) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 603;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z2 = z3;
                }
            } catch (InterruptedException e4) {
                if (!this.mStopTask) {
                    TMLog.i(TAG, "InterruptedException " + Thread.currentThread().getName());
                    ab.printErrStackTrace(TAG, e4, "", new Object[0]);
                    this.mDownloadInfo.mDownloadFailedErrCode = 600;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z2 = false;
                }
                z2 = false;
            } catch (SSLHandshakeException e5) {
                if (!this.mStopTask) {
                    TMLog.i(TAG, "SSLHandshakeException " + Thread.currentThread().getName());
                    ab.printErrStackTrace(TAG, e5, "", new Object[0]);
                    this.mDownloadInfo.mDownloadFailedErrCode = Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z2 = false;
                }
                z2 = false;
            } catch (IOException e6) {
                if (this.mStopTask) {
                    z3 = false;
                } else {
                    TMLog.i(TAG, "IOException " + Thread.currentThread().getName());
                    ab.printErrStackTrace(TAG, e6, "", new Object[0]);
                    z3 = shouldRetryConnect();
                    if (!z3) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 606;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z2 = z3;
                }
            } catch (StopRequestException stopRequestException2) {
                if (this.mStopTask) {
                    z3 = z;
                    z2 = false;
                } else {
                    TMLog.i(TAG, "StopRequestException, errCode = " + stopRequestException2.mFinalErrCode + " " + Thread.currentThread().getName());
                    ab.printErrStackTrace(TAG, stopRequestException2, "", new Object[0]);
                    this.mDownloadInfo.mDownloadFailedErrCode = stopRequestException2.mFinalErrCode;
                    if (stopRequestException2.mFinalErrCode == 703 || stopRequestException2.mFinalErrCode == 710 || stopRequestException2.mFinalErrCode == 711) {
                        z3 = z;
                        z2 = false;
                    } else if (704 == stopRequestException2.mFinalErrCode) {
                        this.mDownloadInfo.setTotalSize(0);
                        new TMAssistantFile(this.mDownloadInfo.mTempFileName, this.mDownloadInfo.mFileName).deleteTempFile();
                        z3 = z;
                        z2 = false;
                    } else if (705 != stopRequestException2.mFinalErrCode) {
                        z2 = shouldRetryConnect();
                        z3 = z;
                    } else if (z || !this.mDownloadInfo.hasRetryChance() || TextUtils.isEmpty(this.mDownloadInfo.mSecondaryUrl)) {
                        z3 = z;
                        z2 = false;
                    } else {
                        z3 = true;
                        z2 = true;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z = z3;
                } else {
                    z = z3;
                }
            } catch (Throwable th) {
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                AppMethodBeat.o(75747);
            }
        }
        TMLog.i(TAG, "mStopTask = " + this.mStopTask + " " + Thread.currentThread().getName());
        if (this.mStopTask) {
            this.mDownloadInfo.mDownloadFailedErrCode = 0;
        } else {
            TMLog.i(TAG, "download finished, " + Thread.currentThread().getName() + ",finalstatus: " + this.mDownloadInfo.mStatus + " errCode: " + this.mDownloadInfo.mDownloadFailedErrCode);
            if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                this.mDownloadInfo.updateStatus(4, z);
            } else {
                this.mDownloadInfo.updateStatus(5, z);
            }
        }
        this.mDownloadInfo.mTaskIsRunning = false;
        AppMethodBeat.o(75747);
    }

    private boolean shouldRetryConnect() {
        boolean z = false;
        AppMethodBeat.i(75748);
        if (this.mStopTask) {
            TMLog.i(TAG, "mStopTask = " + this.mStopTask);
            AppMethodBeat.o(75748);
        } else {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            if (!DownloadHelper.isNetworkConncted()) {
                int i = 0;
                while (!DownloadHelper.isNetworkConncted() && i < 5) {
                    i++;
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e2) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                }
            }
            if (!DownloadHelper.isNetworkConncted()) {
                TMLog.i(TAG, "network unconnected");
                AppMethodBeat.o(75748);
            } else if (DownloadHelper.getNetStatus().equalsIgnoreCase("wifi") || DownloadHelper.getNetStatus().equalsIgnoreCase(this.startDownloadNetType)) {
                if (this.mDownloadInfo.hasRetryChance()) {
                    DownloadInfo downloadInfo = this.mDownloadInfo;
                    downloadInfo.mRetryCnt++;
                    this.mDownloadInfo.mRedirectCnt = 0;
                    try {
                        Thread.sleep(5000);
                        z = true;
                    } catch (InterruptedException e3) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                }
                TMLog.i(TAG, "shouldRetryConnect(" + z + "), retryCnt = " + this.mDownloadInfo.mRetryCnt);
                AppMethodBeat.o(75748);
            } else {
                TMLog.i(TAG, "not equal netType, current: " + DownloadHelper.getNetStatus() + ", startNetType: " + this.startDownloadNetType);
                AppMethodBeat.o(75748);
            }
        }
        return z;
    }

    private void onDownloadError(Throwable th) {
        AppMethodBeat.i(75749);
        if (th != null) {
            ab.printErrStackTrace(TAG, th, "", new Object[0]);
        }
        AppMethodBeat.o(75749);
    }

    private void handleResponseCode(HttpResponse httpResponse, DownloadChunkLogInfo downloadChunkLogInfo) {
        AppMethodBeat.i(75750);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        TMLog.i(TAG, "httpResponseCode = " + statusCode + " " + Thread.currentThread().getName());
        downloadChunkLogInfo.readHeaderTime = System.currentTimeMillis();
        downloadChunkLogInfo.responseHttpCode = statusCode;
        if (statusCode == 200 || statusCode == 206) {
            this.mDownloadInfo.mRetryCnt = 0;
        }
        StopRequestException stopRequestException;
        StopRequestException stopRequestException2;
        switch (statusCode) {
            case 200:
                Header[] headers = httpResponse.getHeaders("Content-Type");
                if (headers != null && headers.length > 0) {
                    if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                        this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                    } else {
                        String value = headers[0].getValue();
                        if (TextUtils.isEmpty(value) || !value.startsWith("text")) {
                            renameApkFileName(httpResponse);
                        } else {
                            stopRequestException = new StopRequestException(708, "Return contenttype = text " + Thread.currentThread().getName());
                            AppMethodBeat.o(75750);
                            throw stopRequestException;
                        }
                    }
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                AppMethodBeat.o(75750);
                return;
            case 206:
                if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                    this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                } else {
                    renameApkFileName(httpResponse);
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                AppMethodBeat.o(75750);
                return;
            case 301:
            case 302:
            case 303:
            case 307:
                if (this.mDownloadInfo.mRedirectCnt > 5) {
                    TMLog.i(TAG, "mRedirectCnt = " + this.mDownloadInfo.mRedirectCnt + ",MAX_REDIRESTS = 5");
                    stopRequestException = new StopRequestException(709, "Redirect cnt many times.");
                    AppMethodBeat.o(75750);
                    throw stopRequestException;
                }
                Header firstHeader = httpResponse.getFirstHeader(b.LOCATION);
                if (firstHeader != null) {
                    String value2 = firstHeader.getValue();
                    TMLog.i(TAG, "jumpURL = ".concat(String.valueOf(value2)));
                    if (DownloadHelper.isValidURL(value2)) {
                        this.mRequestUrl = DownloadHelper.correctURL(value2);
                        this.mIsRedirect = true;
                        DownloadInfo downloadInfo = this.mDownloadInfo;
                        downloadInfo.mRedirectCnt++;
                        AppMethodBeat.o(75750);
                        return;
                    }
                    StopRequestException stopRequestException3 = new StopRequestException(700, "Jump url is not valid. httpResponseCode = " + statusCode + " url: " + value2);
                    AppMethodBeat.o(75750);
                    throw stopRequestException3;
                }
                TMLog.e(TAG, "location header is null. httpResponseCode = ".concat(String.valueOf(statusCode)));
                stopRequestException2 = new StopRequestException(702, "location header is null. httpResponseCode = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(75750);
                throw stopRequestException2;
            case 416:
                stopRequestException2 = new StopRequestException(statusCode, "HTTP response code error, code = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(75750);
                throw stopRequestException2;
            case 500:
                stopRequestException2 = new StopRequestException(statusCode, "HTTP response code error, code = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(75750);
                throw stopRequestException2;
            case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                stopRequestException2 = new StopRequestException(statusCode, "HTTP response code error, code = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(75750);
                throw stopRequestException2;
            default:
                stopRequestException2 = new StopRequestException(statusCode, "HTTP response code error, code = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(75750);
                throw stopRequestException2;
        }
    }

    private boolean verifyTotalLen(HttpResponse httpResponse, HttpEntity httpEntity) {
        AppMethodBeat.i(75751);
        long contentLength;
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            contentLength = httpEntity.getContentLength();
            TMLog.i(TAG, "verifyTotalLen,totalLen = " + contentLength + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
            if (contentLength == -1 || (this.mDownloadInfo.mRequestFileSize.longValue() > 0 && contentLength != this.mDownloadInfo.mRequestFileSize.longValue())) {
                AppMethodBeat.o(75751);
                return false;
            }
        } else if (httpResponse.getStatusLine().getStatusCode() == 206) {
            contentLength = ByteRange.getTotalSize(httpResponse.getFirstHeader("content-range").getValue());
            TMLog.i(TAG, "verifyTotalLen,totalLen = " + contentLength + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
            if (contentLength == -1 || (this.mDownloadInfo.mRequestFileSize.longValue() > 0 && contentLength != this.mDownloadInfo.mRequestFileSize.longValue())) {
                AppMethodBeat.o(75751);
                return false;
            }
        }
        AppMethodBeat.o(75751);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x033f  */
    /* JADX WARNING: Missing block: B:70:0x02c2, code skipped:
            if (com.tencent.tmassistantsdk.downloadservice.DownloadHelper.isSpaceEnough(com.tencent.tmassistantsdk.storage.TMAssistantFile.getSavePathRootDir(), r10.mDownloadInfo.getTotalSize()) == false) goto L_0x03a8;
     */
    /* JADX WARNING: Missing block: B:72:0x02c8, code skipped:
            if (com.tencent.tmassistantsdk.storage.TMAssistantFile.isSDCardExistAndCanWrite() == false) goto L_0x0353;
     */
    /* JADX WARNING: Missing block: B:73:0x02ca, code skipped:
            r0 = "write file failed, fileName: " + r10.mDownloadInfo.mFileName + " receivedSize: " + r10.mDownloadInfo.mReceivedBytes + " readedSize: " + r3 + " totalSize: " + r10.mDownloadInfo.getTotalSize();
            com.tencent.tmassistantsdk.util.TMLog.w(TAG, r0);
            r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException(703, r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(75752);
     */
    /* JADX WARNING: Missing block: B:74:0x031c, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:89:?, code skipped:
            r0 = "write file failed, no sdCard! fileName: " + r10.mDownloadInfo.mFileName + " receivedSize: " + r10.mDownloadInfo.mReceivedBytes + " readedSize: " + r3 + " totalSize: " + r10.mDownloadInfo.getTotalSize();
            com.tencent.tmassistantsdk.util.TMLog.w(TAG, r0);
            r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException(711, r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(75752);
     */
    /* JADX WARNING: Missing block: B:90:0x03a5, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:93:0x03a8, code skipped:
            r0 = "write file failed, no enough space! fileName: " + r10.mDownloadInfo.mFileName + " receivedSize: " + r10.mDownloadInfo.mReceivedBytes + " readedSize: " + r3 + " totalSize: " + r10.mDownloadInfo.getTotalSize();
            com.tencent.tmassistantsdk.util.TMLog.w(TAG, r0);
            r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException(710, r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(75752);
     */
    /* JADX WARNING: Missing block: B:94:0x03fa, code skipped:
            throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onReceivedResponseData(HttpResponse httpResponse, DownloadChunkLogInfo downloadChunkLogInfo) {
        Throwable th;
        AppMethodBeat.i(75752);
        HttpEntity entity = httpResponse.getEntity();
        StopRequestException stopRequestException;
        if (verifyTotalLen(httpResponse, entity)) {
            StopRequestException stopRequestException2;
            Header firstHeader;
            if (this.mDownloadInfo.getTotalSize() == 0) {
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    this.mDownloadInfo.setTotalSize(entity.getContentLength());
                    TMLog.i(TAG, "HTTPCode 200, totalBytes:" + this.mDownloadInfo.getTotalSize());
                } else if (httpResponse.getStatusLine().getStatusCode() == 206) {
                    this.mDownloadInfo.setTotalSize(ByteRange.getTotalSize(httpResponse.getFirstHeader("content-range").getValue()));
                    TMLog.i(TAG, "HTTPCode 206, totalBytes:" + this.mDownloadInfo.getTotalSize());
                } else {
                    TMLog.w(TAG, "statusCode=" + httpResponse.getStatusLine().getStatusCode() + " onReceivedResponseData error.");
                }
                TMLog.w(TAG, "first start downloadinfoTotalSize = " + this.mDownloadInfo.getTotalSize());
                firstHeader = httpResponse.getFirstHeader("content-range");
                if (firstHeader != null) {
                    ByteRange parseContentRange = ByteRange.parseContentRange(firstHeader.getValue());
                    downloadChunkLogInfo.responseRangePosition = parseContentRange.getStart();
                    downloadChunkLogInfo.responseRangeLength = (parseContentRange.getEnd() - parseContentRange.getStart()) + 1;
                }
                downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            } else if (httpResponse.getStatusLine().getStatusCode() == 206) {
                try {
                    firstHeader = httpResponse.getFirstHeader("content-range");
                    ByteRange parseContentRange2 = ByteRange.parseContentRange(firstHeader.getValue());
                    long totalSize = ByteRange.getTotalSize(firstHeader.getValue());
                    downloadChunkLogInfo.responseRangePosition = parseContentRange2.getStart();
                    downloadChunkLogInfo.responseRangeLength = (parseContentRange2.getEnd() - parseContentRange2.getStart()) + 1;
                    downloadChunkLogInfo.responseContentLength = totalSize;
                    TMLog.w(TAG, "totalSize = " + totalSize + "  downloadinfoTotalSize = " + this.mDownloadInfo.getTotalSize());
                    TMLog.i(TAG, "mReceivedBytes = " + this.mDownloadInfo.mReceivedBytes);
                    TMLog.i(TAG, "start = " + parseContentRange2.getStart() + ", end = " + parseContentRange2.getEnd());
                    if (parseContentRange2.getStart() != this.mDownloadInfo.mReceivedBytes) {
                        stopRequestException = new StopRequestException(706, "The received size is not equal with ByteRange.");
                        AppMethodBeat.o(75752);
                        throw stopRequestException;
                    } else if (totalSize != this.mDownloadInfo.getTotalSize()) {
                        stopRequestException = new StopRequestException(705, "The total size is not equal with ByteRange.");
                        AppMethodBeat.o(75752);
                        throw stopRequestException;
                    } else {
                        TMLog.d(TAG, "response ByteRange: ".concat(String.valueOf(firstHeader)));
                        if (this.mSaveFile != null) {
                            this.mSaveFile.close();
                            this.mSaveFile = null;
                        }
                    }
                } catch (Throwable th2) {
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                    AppMethodBeat.o(75752);
                }
            }
            if (this.mSaveFile == null) {
                this.mSaveFile = new TMAssistantFile(this.mDownloadInfo.mTempFileName, this.mDownloadInfo.mFileName);
            }
            long j = 0;
            try {
                InputStream content = entity.getContent();
                TMLog.i(TAG, "start write file, fileName: " + this.mDownloadInfo.mFileName);
                long j2 = 0;
                while (true) {
                    try {
                        int read = content.read(this.mRecvBuf);
                        if (read <= 0) {
                            break;
                        } else if (this.mStopTask) {
                            content.close();
                            break;
                        } else {
                            long j3 = this.mDownloadInfo.mReceivedBytes + ((long) read);
                            if (j3 <= this.mDownloadInfo.getTotalSize()) {
                                if (!this.mSaveFile.write(this.mRecvBuf, 0, read, this.mDownloadInfo.mReceivedBytes, j3 == this.mDownloadInfo.getTotalSize())) {
                                    break;
                                }
                                this.mDownloadInfo.updateReceivedSize((long) read);
                                j2 += (long) read;
                            } else {
                                TMLog.w(TAG, "write file size too long.\r\nreadedLen: " + read + "\r\nreceivedSize: " + this.mDownloadInfo.mReceivedBytes + "\r\ntotalSize: " + this.mDownloadInfo.getTotalSize() + "\r\nisTheEndData: false");
                                stopRequestException2 = new StopRequestException(703, "write file size too long.");
                                AppMethodBeat.o(75752);
                                throw stopRequestException2;
                            }
                        }
                    } catch (SocketException e) {
                        th = e;
                        j = j2;
                        try {
                            ab.printErrStackTrace(TAG, th, "", new Object[0]);
                            stopRequestException2 = new StopRequestException(605, th);
                            AppMethodBeat.o(75752);
                            throw stopRequestException2;
                        } catch (Throwable th3) {
                            th = th3;
                            j2 = j;
                            if (this.mSaveFile != null) {
                            }
                            downloadChunkLogInfo.receiveDataSize = j2;
                            AppMethodBeat.o(75752);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (this.mSaveFile != null) {
                            this.mSaveFile.close();
                            this.mSaveFile = null;
                        }
                        downloadChunkLogInfo.receiveDataSize = j2;
                        AppMethodBeat.o(75752);
                        throw th;
                    }
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                downloadChunkLogInfo.receiveDataSize = j2;
                AppMethodBeat.o(75752);
                return;
            } catch (SocketException e2) {
                th = e2;
                ab.printErrStackTrace(TAG, th, "", new Object[0]);
                stopRequestException2 = new StopRequestException(605, th);
                AppMethodBeat.o(75752);
                throw stopRequestException2;
            }
        }
        TMLog.i(TAG, "verifyTotalLen false");
        stopRequestException = new StopRequestException(705, "totalLen is not match the requestSize");
        AppMethodBeat.o(75752);
        throw stopRequestException;
    }

    private void setRangeHeader(HttpGet httpGet, DownloadChunkLogInfo downloadChunkLogInfo) {
        AppMethodBeat.i(75753);
        String netStatus = DownloadHelper.getNetStatus();
        this.mDownloadInfo.mNetType = netStatus;
        if (TextUtils.isEmpty(netStatus) || (!netStatus.contains("wap") && (!netStatus.contains("net") || this.mDownloadInfo.mRetryCnt <= 0))) {
            netStatus = "bytes=" + this.mDownloadInfo.mReceivedBytes + "-";
            httpGet.addHeader("range", netStatus);
            TMLog.d(TAG, "set range header: ".concat(String.valueOf(netStatus)));
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = this.mDownloadInfo.mReceivedBytes;
            downloadChunkLogInfo.requestRanageSize = 0;
            AppMethodBeat.o(75753);
            return;
        }
        try {
            long j;
            int splitSizeInBytes = DownloadSetting.getSplitSizeInBytes(netStatus);
            long j2 = this.mDownloadInfo.mReceivedBytes;
            if (this.mDownloadInfo.getTotalSize() > 0) {
                j = (this.mDownloadInfo.mReceivedBytes + ((long) splitSizeInBytes)) - 1;
                if (j >= this.mDownloadInfo.getTotalSize()) {
                    j = this.mDownloadInfo.getTotalSize() - 1;
                }
            } else {
                j = (long) (splitSizeInBytes - 1);
            }
            netStatus = "bytes=" + j2 + "-" + j;
            httpGet.addHeader("range", netStatus);
            TMLog.d(TAG, "set range header: ".concat(String.valueOf(netStatus)));
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = j2;
            downloadChunkLogInfo.requestRanageSize = (long) splitSizeInBytes;
            AppMethodBeat.o(75753);
        } catch (UnsupportedOperationException e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(75753);
        }
    }

    private void renameApkFileName(HttpResponse httpResponse) {
        AppMethodBeat.i(75754);
        if (httpResponse == null) {
            AppMethodBeat.o(75754);
            return;
        }
        if (this.mDownloadInfo.mContentType.equals("application/vnd.android.package-archive")) {
            CharSequence charSequence = null;
            Header[] headers = httpResponse.getHeaders("Content-Disposition");
            if (headers == null || headers.length <= 0) {
                charSequence = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
            } else {
                String value = headers[0].getValue();
                TMLog.i(TAG, "headerFileName = ".concat(String.valueOf(value)));
                if (TextUtils.isEmpty(value) || !value.contains("filename=\"")) {
                    charSequence = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
                } else {
                    value = value.substring(value.indexOf("filename=\"") + 10);
                    if (!TextUtils.isEmpty(value)) {
                        charSequence = value.substring(0, value.indexOf("\""));
                        TMLog.i(TAG, "header file Name =".concat(String.valueOf(charSequence)));
                    }
                }
            }
            if (!TextUtils.isEmpty(charSequence)) {
                this.mDownloadInfo.mFileName = DownloadHelper.correctFileName(DownloadHelper.decodeFileName(charSequence));
            }
        }
        AppMethodBeat.o(75754);
    }

    private void setExtraHeaderParam(HttpGet httpGet, Map<String, String> map) {
        AppMethodBeat.i(75755);
        if (!(httpGet == null || map == null || map.size() <= 0)) {
            for (Entry entry : map.entrySet()) {
                httpGet.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        AppMethodBeat.o(75755);
    }
}
