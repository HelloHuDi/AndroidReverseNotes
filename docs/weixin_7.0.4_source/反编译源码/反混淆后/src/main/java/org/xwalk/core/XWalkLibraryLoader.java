package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1634b.C44575c;
import com.tencent.xweb.p1634b.C44831d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class XWalkLibraryLoader {
    private static final String DEFAULT_DOWNLOAD_FILE_NAME = "xwalk_download.tmp";
    private static final int DOWNLOAD_TYPE_CDN = 2;
    private static final int DOWNLOAD_TYPE_HTTP = 1;
    private static final String DOWNLOAD_WITHOUT_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
    private static final int ERROR_CODE_DOWNLOADER_TIMEOUT = -100;
    private static final int ERROR_CODE_EXCEPTION = -101;
    private static final int ERROR_CODE_FAILED = -1;
    private static final int ERROR_CODE_SUCCESS = 0;
    private static final int ERROR_TYPE_DOWNLOADER = 1;
    private static final int ERROR_TYPE_NONE = 0;
    private static final int ERROR_TYPE_USER = 2;
    private static final String TAG = "XWalkLib";
    private static AsyncTask<Void, Integer, Integer> sActiveTask;

    public interface ActivateListener {
        void onActivateCompleted();

        void onActivateFailed();

        void onActivateStarted();
    }

    public static class WXFileDownloaderTask extends AsyncTask<Void, Integer, Integer> implements C44575c {
        private static final int DOWNLOAD_FAILED = -1;
        private static final int DOWNLOAD_SUCCESS = 0;
        private static final int UPDATE_INTERVAL_MS = 500;
        private final Object lockObj = new Object();
        private DownloadInfo mDownloadInfo;
        private DownloadListener mListener;
        private long mProgressUpdateTime = 0;
        private C44831d mWXFileDownloaderBridge = null;
        private boolean mWaitTimeout = false;

        public boolean isValid() {
            AppMethodBeat.m2504i(85681);
            if (this.mWXFileDownloaderBridge == null) {
                AppMethodBeat.m2505o(85681);
                return false;
            }
            boolean isValid = C44831d.isValid();
            AppMethodBeat.m2505o(85681);
            return isValid;
        }

        public WXFileDownloaderTask(boolean z, DownloadListener downloadListener, String str, String str2, int i) {
            AppMethodBeat.m2504i(85682);
            this.mListener = downloadListener;
            this.mDownloadInfo = new DownloadInfo();
            this.mDownloadInfo.mErrorType = 0;
            this.mDownloadInfo.mErrorCode = 0;
            this.mDownloadInfo.mDownloadType = 2;
            this.mDownloadInfo.mUrl = str;
            this.mDownloadInfo.mSavePath = str2;
            this.mDownloadInfo.mIsRuntime = z;
            this.mDownloadInfo.mBizType = i;
            this.mWXFileDownloaderBridge = new C44831d();
            this.mWXFileDownloaderBridge.ANq = this;
            AppMethodBeat.m2505o(85682);
        }

        /* Access modifiers changed, original: protected */
        public void onPreExecute() {
            AppMethodBeat.m2504i(85683);
            if (this.mDownloadInfo.mIsRuntime) {
                XWalkLibraryLoader.sActiveTask = this;
                Log.m81049i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
            } else {
                Log.m81049i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
            }
            this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
            this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
            Context applicationContext = XWalkEnvironment.getApplicationContext();
            this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(applicationContext);
            AppMethodBeat.m2505o(85683);
        }

        /* Access modifiers changed, original: protected|varargs */
        public Integer doInBackground(Void... voidArr) {
            AppMethodBeat.m2504i(85684);
            Integer valueOf;
            if (this.mWXFileDownloaderBridge == null || !C44831d.isValid()) {
                this.mDownloadInfo.mErrorType = 2;
                this.mDownloadInfo.mErrorCode = -1;
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.m2505o(85684);
                return valueOf;
            }
            int a;
            C44831d c44831d = this.mWXFileDownloaderBridge;
            String str = this.mDownloadInfo.mUrl;
            String str2 = this.mDownloadInfo.mSavePath;
            if (C44831d.ANp != null) {
                a = C44831d.ANp.mo71373a(str, str2, c44831d);
            } else {
                a = -1;
            }
            if (a != 0) {
                this.mDownloadInfo.mErrorType = 1;
                this.mDownloadInfo.mErrorCode = -1;
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.m2505o(85684);
                return valueOf;
            }
            synchronized (this.lockObj) {
                try {
                    this.mWaitTimeout = true;
                    this.lockObj.wait(300000);
                } catch (InterruptedException e) {
                    this.mWaitTimeout = false;
                    this.mDownloadInfo.mErrorType = 2;
                    this.mDownloadInfo.mErrorCode = -101;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(85684);
                }
                if (this.mDownloadInfo.mErrorType == 0 && this.mDownloadInfo.mErrorCode == 0) {
                    valueOf = Integer.valueOf(0);
                    AppMethodBeat.m2505o(85684);
                    return valueOf;
                }
                Log.m81046e(XWalkLibraryLoader.TAG, "download errortype:" + this.mDownloadInfo.mErrorType + ", errorcode:" + this.mDownloadInfo.mErrorCode + ", waitTimeout:" + this.mWaitTimeout);
                if (this.mWaitTimeout) {
                    this.mDownloadInfo.mErrorType = 1;
                    this.mDownloadInfo.mErrorCode = -100;
                }
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.m2505o(85684);
                return valueOf;
            }
        }

        /* Access modifiers changed, original: protected|varargs */
        public void onProgressUpdate(Integer... numArr) {
            int i = 0;
            AppMethodBeat.m2504i(85685);
            Log.m81045d(XWalkLibraryLoader.TAG, "WXFileDownloaderTask updated: " + numArr[0] + "/" + numArr[1]);
            if (numArr[1].intValue() > 0) {
                i = (int) ((((double) numArr[0].intValue()) * 100.0d) / ((double) numArr[1].intValue()));
            }
            this.mListener.onDownloadUpdated(i);
            AppMethodBeat.m2505o(85685);
        }

        /* Access modifiers changed, original: protected */
        public void onCancelled(Integer num) {
            AppMethodBeat.m2504i(85686);
            if (this.mDownloadInfo.mIsRuntime) {
                XWalkLibraryLoader.sActiveTask = null;
                Log.m81049i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
            } else {
                Log.m81049i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask other onCancelled: " + this.mDownloadInfo.mSavePath);
            }
            this.mListener.onDownloadCancelled();
            AppMethodBeat.m2505o(85686);
        }

        /* Access modifiers changed, original: protected */
        public void onPostExecute(Integer num) {
            AppMethodBeat.m2504i(85687);
            if (this.mDownloadInfo.mIsRuntime) {
                XWalkLibraryLoader.sActiveTask = null;
                Log.m81049i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask runtime onPostExecute result " + num + " " + this.mDownloadInfo.mSavePath);
            } else {
                Log.m81049i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask other onPostExecute result " + num + " " + this.mDownloadInfo.mSavePath);
            }
            if (num.intValue() == 0) {
                this.mListener.onDownloadCompleted(this.mDownloadInfo);
                AppMethodBeat.m2505o(85687);
                return;
            }
            this.mListener.onDownloadFailed(this.mDownloadInfo);
            AppMethodBeat.m2505o(85687);
        }

        public void onProgressChange(String str, long j, long j2) {
            AppMethodBeat.m2504i(85688);
            Log.m81045d(XWalkLibraryLoader.TAG, "url:" + str + ", cur_size:" + j + ", total_size:" + j2);
            if (this.mDownloadInfo.mFileTotalSize != j2) {
                this.mDownloadInfo.mFileTotalSize = j2;
            }
            publishProgress(new Integer[]{Integer.valueOf((int) j), Integer.valueOf((int) j2)});
            AppMethodBeat.m2505o(85688);
        }

        public void onTaskSucc(String str, String str2, boolean z) {
            AppMethodBeat.m2504i(85689);
            synchronized (this.lockObj) {
                try {
                    this.mDownloadInfo.mIsDownloadResume = z;
                    this.mWaitTimeout = false;
                    this.lockObj.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(85689);
                }
            }
        }

        public void onTaskFail(String str, int i, boolean z) {
            AppMethodBeat.m2504i(85690);
            synchronized (this.lockObj) {
                try {
                    this.mDownloadInfo.mErrorType = 1;
                    this.mDownloadInfo.mErrorCode = i;
                    this.mDownloadInfo.mIsDownloadResume = z;
                    this.mWaitTimeout = false;
                    this.lockObj.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(85690);
                }
            }
        }
    }

    public static class DownloadInfo {
        public int mBizType = 0;
        public int mDownloadType = 1;
        public int mErrorCode = 0;
        public int mErrorType = 0;
        public long mFileTotalSize = 0;
        public boolean mIsDownloadResume = false;
        public boolean mIsRuntime = false;
        public int mNetWorkType = 0;
        public int mRetryTimes = 0;
        public String mSavePath = "";
        public long mStartTimestamp = 0;
        public String mUrl = "";
    }

    public interface DownloadListener {
        void onDownloadCancelled();

        void onDownloadCompleted(DownloadInfo downloadInfo);

        void onDownloadFailed(DownloadInfo downloadInfo);

        void onDownloadStarted(int i);

        void onDownloadUpdated(int i);
    }

    public static class HttpDownloadTask extends AsyncTask<Void, Integer, Integer> {
        private static final int DOWNLOAD_FAILED = -1;
        private static final int DOWNLOAD_SUCCESS = 0;
        private static final int UPDATE_INTERVAL_MS = 500;
        private static final String XWALK_DOWNLOAD_DIR = "xwalk_download";
        private DownloadInfo mDownloadInfo = new DownloadInfo();
        private File mDownloadedFile;
        private DownloadListener mListener;
        private long mProgressUpdateTime;

        public HttpDownloadTask(boolean z, DownloadListener downloadListener, String str, String str2) {
            AppMethodBeat.m2504i(85671);
            this.mListener = downloadListener;
            this.mDownloadInfo.mUrl = str;
            this.mDownloadInfo.mSavePath = str2;
            this.mDownloadInfo.mIsRuntime = z;
            AppMethodBeat.m2505o(85671);
        }

        /* Access modifiers changed, original: protected */
        public void onPreExecute() {
            AppMethodBeat.m2504i(85672);
            if (this.mDownloadInfo.mIsRuntime) {
                XWalkLibraryLoader.sActiveTask = this;
                Log.m81049i(XWalkLibraryLoader.TAG, "HttpDownloadTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
            } else {
                Log.m81049i(XWalkLibraryLoader.TAG, "HttpDownloadTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
            }
            this.mDownloadedFile = new File(this.mDownloadInfo.mSavePath);
            this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
            this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
            Context applicationContext = XWalkEnvironment.getApplicationContext();
            this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(applicationContext);
            AppMethodBeat.m2505o(85672);
        }

        /* Access modifiers changed, original: protected|varargs */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x01d4 A:{SYNTHETIC, Splitter:B:68:0x01d4} */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01d9 A:{Catch:{ IOException -> 0x0243 }} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01de  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01de  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x021a A:{SYNTHETIC, Splitter:B:87:0x021a} */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x021f A:{Catch:{ IOException -> 0x022e }} */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0224  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0245 A:{PHI: r3 , Splitter:B:1:0x000b, ExcHandler: Exception (e java.lang.Exception)} */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x021a A:{SYNTHETIC, Splitter:B:87:0x021a} */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x021f A:{Catch:{ IOException -> 0x022e }} */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0224  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x01d4 A:{SYNTHETIC, Splitter:B:68:0x01d4} */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01d9 A:{Catch:{ IOException -> 0x0243 }} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01de  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x021a A:{SYNTHETIC, Splitter:B:87:0x021a} */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x021f A:{Catch:{ IOException -> 0x022e }} */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0224  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x0224  */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:76:?, code skipped:
            r5.flush();
     */
        /* JADX WARNING: Missing block: B:78:?, code skipped:
            r5.close();
     */
        /* JADX WARNING: Missing block: B:79:0x01ef, code skipped:
            if (r6 == null) goto L_0x01f4;
     */
        /* JADX WARNING: Missing block: B:80:0x01f1, code skipped:
            r6.close();
     */
        /* JADX WARNING: Missing block: B:84:0x0214, code skipped:
            r2 = move-exception;
     */
        /* JADX WARNING: Missing block: B:85:0x0215, code skipped:
            r7 = r2;
            r8 = null;
            r6 = null;
     */
        /* JADX WARNING: Missing block: B:106:0x0246, code skipped:
            r6 = null;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Integer doInBackground(Void... voidArr) {
            InputStream inputStream;
            Integer valueOf;
            Throwable th;
            HttpURLConnection httpURLConnection;
            AppMethodBeat.m2504i(85673);
            OutputStream outputStream = null;
            HttpURLConnection httpURLConnection2 = null;
            try {
                URL url = new URL(this.mDownloadInfo.mUrl);
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(30000);
                    httpURLConnection3.setReadTimeout(30000);
                    httpURLConnection3.connect();
                    Integer valueOf2;
                    if (httpURLConnection3.getResponseCode() == 200 || httpURLConnection3.getResponseCode() == 206) {
                        long length;
                        int contentLength;
                        long j;
                        OutputStream fileOutputStream;
                        int contentLength2 = httpURLConnection3.getContentLength();
                        if (this.mDownloadedFile.exists()) {
                            length = this.mDownloadedFile.length();
                            if (((long) contentLength2) == length) {
                                Log.m81049i(XWalkLibraryLoader.TAG, "royle:same size in server success");
                                valueOf2 = Integer.valueOf(0);
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                AppMethodBeat.m2505o(85673);
                                return valueOf2;
                            }
                            if (length > 0) {
                                this.mDownloadInfo.mIsDownloadResume = true;
                                Log.m81049i(XWalkLibraryLoader.TAG, "royle:http download IsDownloadResume");
                            }
                            httpURLConnection3.disconnect();
                            httpURLConnection3 = (HttpURLConnection) url.openConnection();
                            httpURLConnection3.setConnectTimeout(30000);
                            httpURLConnection3.setReadTimeout(30000);
                            httpURLConnection3.setRequestProperty("Range", "bytes=" + length + "-");
                            Log.m81049i(XWalkLibraryLoader.TAG, "royle:download range begin:".concat(String.valueOf(length)));
                            httpURLConnection3.connect();
                            if (httpURLConnection3.getResponseCode() == 200 || httpURLConnection3.getResponseCode() == 206) {
                                contentLength = httpURLConnection3.getContentLength();
                                j = length;
                                httpURLConnection2 = httpURLConnection3;
                            } else {
                                Log.m81046e(XWalkLibraryLoader.TAG, "Server returned HTTP " + httpURLConnection3.getResponseCode() + " " + httpURLConnection3.getResponseMessage());
                                valueOf2 = Integer.valueOf(-1);
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                AppMethodBeat.m2505o(85673);
                                return valueOf2;
                            }
                        }
                        contentLength = contentLength2;
                        j = 0;
                        httpURLConnection2 = httpURLConnection3;
                        inputStream = httpURLConnection2.getInputStream();
                        try {
                            fileOutputStream = new FileOutputStream(this.mDownloadedFile, true);
                        } catch (Exception e) {
                            try {
                                valueOf = Integer.valueOf(-1);
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection2 != null) {
                                }
                                AppMethodBeat.m2505o(85673);
                                return valueOf;
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection = httpURLConnection2;
                            }
                        }
                        try {
                            byte[] bArr = new byte[4096];
                            length = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else if (isCancelled()) {
                                    valueOf = Integer.valueOf(-1);
                                    try {
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (IOException e2) {
                                    }
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    AppMethodBeat.m2505o(85673);
                                    return valueOf;
                                } else {
                                    length += (long) read;
                                    fileOutputStream.write(bArr, 0, read);
                                    long uptimeMillis = SystemClock.uptimeMillis();
                                    if (uptimeMillis - this.mProgressUpdateTime > 500) {
                                        this.mProgressUpdateTime = uptimeMillis;
                                        publishProgress(new Integer[]{Integer.valueOf((int) (length + j)), Integer.valueOf((int) (((long) contentLength) + j))});
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            outputStream = fileOutputStream;
                            valueOf = Integer.valueOf(-1);
                            if (outputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection2 != null) {
                            }
                            AppMethodBeat.m2505o(85673);
                            return valueOf;
                        } catch (Throwable th22) {
                            th = th22;
                            httpURLConnection = httpURLConnection2;
                            outputStream = fileOutputStream;
                            if (outputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            AppMethodBeat.m2505o(85673);
                            throw th;
                        }
                    }
                    Log.m81046e(XWalkLibraryLoader.TAG, "Server returned HTTP " + httpURLConnection3.getResponseCode() + " " + httpURLConnection3.getResponseMessage());
                    valueOf2 = Integer.valueOf(-1);
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    AppMethodBeat.m2505o(85673);
                    return valueOf2;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    this.mDownloadInfo.mFileTotalSize = this.mDownloadedFile.length();
                    valueOf = Integer.valueOf(0);
                    AppMethodBeat.m2505o(85673);
                    return valueOf;
                } catch (Exception e4) {
                    httpURLConnection2 = httpURLConnection3;
                    inputStream = null;
                    valueOf = Integer.valueOf(-1);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            if (httpURLConnection2 != null) {
                            }
                            AppMethodBeat.m2505o(85673);
                            return valueOf;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(85673);
                    return valueOf;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection3;
                    inputStream = null;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                            if (httpURLConnection != null) {
                            }
                            AppMethodBeat.m2505o(85673);
                            throw th;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(85673);
                    throw th;
                }
            } catch (Exception e7) {
            } catch (Throwable th222) {
                th = th222;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
                if (outputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(85673);
                throw th;
            }
        }

        /* Access modifiers changed, original: protected|varargs */
        public void onProgressUpdate(Integer... numArr) {
            int i = 0;
            AppMethodBeat.m2504i(85674);
            Log.m81045d(XWalkLibraryLoader.TAG, "HttpDownloadTask updated: " + numArr[0] + "/" + numArr[1]);
            if (numArr[1].intValue() > 0) {
                i = (int) ((((double) numArr[0].intValue()) * 100.0d) / ((double) numArr[1].intValue()));
            }
            this.mListener.onDownloadUpdated(i);
            AppMethodBeat.m2505o(85674);
        }

        /* Access modifiers changed, original: protected */
        public void onCancelled(Integer num) {
            AppMethodBeat.m2504i(85675);
            if (this.mDownloadInfo.mIsRuntime) {
                XWalkLibraryLoader.sActiveTask = null;
                Log.m81049i(XWalkLibraryLoader.TAG, "HttpDownloadTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
            } else {
                Log.m81049i(XWalkLibraryLoader.TAG, "HttpDownloadTask other onCancelled: " + this.mDownloadInfo.mSavePath);
            }
            this.mListener.onDownloadCancelled();
            AppMethodBeat.m2505o(85675);
        }

        /* Access modifiers changed, original: protected */
        public void onPostExecute(Integer num) {
            AppMethodBeat.m2504i(85676);
            if (this.mDownloadInfo.mIsRuntime) {
                XWalkLibraryLoader.sActiveTask = null;
                Log.m81049i(XWalkLibraryLoader.TAG, "HttpDownloadTask runtime onPostExecute result " + num + " " + this.mDownloadInfo.mSavePath);
            } else {
                Log.m81049i(XWalkLibraryLoader.TAG, "HttpDownloadTask other onPostExecute result " + num + " " + this.mDownloadInfo.mSavePath);
            }
            if (num.intValue() == 0) {
                this.mDownloadInfo.mErrorCode = 0;
                this.mListener.onDownloadCompleted(this.mDownloadInfo);
                AppMethodBeat.m2505o(85676);
                return;
            }
            this.mDownloadInfo.mErrorCode = -1;
            this.mListener.onDownloadFailed(this.mDownloadInfo);
            AppMethodBeat.m2505o(85676);
        }
    }

    public interface DecompressListener {
        void onDecompressCancelled();

        void onDecompressCompleted();

        void onDecompressStarted();
    }

    public static boolean isInitializing() {
        return false;
    }

    public static boolean isDownloading() {
        return sActiveTask != null && (sActiveTask instanceof HttpDownloadTask);
    }

    public static boolean isSharedLibrary() {
        AppMethodBeat.m2504i(85695);
        boolean isSharedMode = XWalkCoreWrapper.getInstance().isSharedMode();
        AppMethodBeat.m2505o(85695);
        return isSharedMode;
    }

    public static boolean isLibraryReady() {
        AppMethodBeat.m2504i(85696);
        if (XWalkCoreWrapper.getInstance() != null) {
            AppMethodBeat.m2505o(85696);
            return true;
        }
        AppMethodBeat.m2505o(85696);
        return false;
    }

    public static int getLibraryStatus() {
        AppMethodBeat.m2504i(85697);
        int coreStatus = XWalkCoreWrapper.getCoreStatus();
        AppMethodBeat.m2505o(85697);
        return coreStatus;
    }

    public static void prepareToInit(Context context) {
        AppMethodBeat.m2504i(85698);
        XWalkEnvironment.init(context);
        XWalkCoreWrapper.handlePreInit(context.getClass().getName());
        AppMethodBeat.m2505o(85698);
    }

    public static void finishInit(Context context) {
        AppMethodBeat.m2504i(85699);
        XWalkCoreWrapper.handlePostInit(context.getClass().getName());
        AppMethodBeat.m2505o(85699);
    }

    public static void startHttpDownload(DownloadListener downloadListener, Context context, UpdateConfig updateConfig) {
        AppMethodBeat.m2504i(85700);
        WXFileDownloaderTask wXFileDownloaderTask = new WXFileDownloaderTask(true, downloadListener, updateConfig.downUrl, updateConfig.getDownloadPath(), updateConfig.getUpdateBizType());
        if (updateConfig.bUseCdn && wXFileDownloaderTask.isValid()) {
            Log.m81049i(TAG, "use wx file downloader");
            wXFileDownloaderTask.execute(new Void[0]);
            AppMethodBeat.m2505o(85700);
            return;
        }
        Log.m81049i(TAG, "use default file downloader");
        new HttpDownloadTask(true, downloadListener, updateConfig.downUrl, updateConfig.getDownloadPath()).execute(new Void[0]);
        AppMethodBeat.m2505o(85700);
    }

    public static boolean cancelHttpDownload() {
        AppMethodBeat.m2504i(85701);
        if (sActiveTask != null && (sActiveTask instanceof HttpDownloadTask) && sActiveTask.cancel(true)) {
            AppMethodBeat.m2505o(85701);
            return true;
        }
        AppMethodBeat.m2505o(85701);
        return false;
    }
}
