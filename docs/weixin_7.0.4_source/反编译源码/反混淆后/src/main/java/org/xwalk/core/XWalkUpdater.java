package org.xwalk.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C41131b;
import com.tencent.xweb.util.C6037d;
import com.tencent.xweb.xwalk.p687b.C41136c.C31155a;
import dalvik.system.DexClassLoader;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.xwalk.core.XWalkLibraryLoader.DownloadInfo;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;

public class XWalkUpdater {
    private static final String ANDROID_MARKET_DETAILS = "market://details?id=";
    public static final int ERROR_DOPATCH_FAILED = -3;
    public static final int ERROR_DOPATCH_MD5_FAILED = -4;
    public static final int ERROR_DOWNLOAD_FAILED = -1;
    public static final int ERROR_DOWNLOAD_MD5_FAILED = -2;
    public static final int ERROR_EXTRACT_RESOURCE_FAILED = -5;
    public static final int ERROR_EXTRACT_RESOURCE_FAILED_FOR_RETRY = -12;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_SET_VERNUM = -101;
    public static final int ERROR_SHARED_MODE_EXCEED_MAX_COUNT = -7;
    public static final int ERROR_SHARED_MODE_FORCE_DOWNLOAD = -6;
    public static final int ERROR_SHARED_MODE_NO_CONTENT_RESOLVER = -8;
    public static final int ERROR_SHARED_MODE_NO_PROVIDER = -9;
    public static final int ERROR_SHARED_MODE_OTHER = -11;
    public static final int ERROR_SHARED_MODE_TRY_AGAIN = -10;
    private static final String GOOGLE_PLAY_PACKAGE = "com.android.vending";
    private static final int RES_EXTRACTOR_MAXTIMES = 1;
    private static final String TAG = "XWalkLib";
    public static final int UPDATE_BIZ_TYPE_RUNTIME_PACKAGE = 1;
    public static final int UPDATE_BIZ_TYPE_RUNTIME_PATCH = 2;
    private static int mCurrentTimeForRetryRes = 0;
    private XWalkBackgroundUpdateListener mBackgroundUpdateListener;
    private Runnable mCancelCommand;
    private Context mContext;
    private XWalkDialogManager mDialogManager;
    private Runnable mDownloadCommand;
    private XWalkUpdateListener mUpdateListener;

    public interface XWalkUpdateListener {
        void onXWalkUpdateCancelled();
    }

    class BackgroundListener implements DownloadListener {
        private UpdateConfig mConfig;

        /* renamed from: org.xwalk.core.XWalkUpdater$BackgroundListener$1 */
        class C164791 extends AsyncTask<Void, Void, Integer> {
            C164791() {
            }

            /* Access modifiers changed, original: protected|varargs */
            public Integer doInBackground(Void... voidArr) {
                AppMethodBeat.m2504i(85896);
                Integer onHandleFile = XWalkUpdater.onHandleFile(BackgroundListener.this.mConfig);
                AppMethodBeat.m2505o(85896);
                return onHandleFile;
            }

            /* Access modifiers changed, original: protected */
            public void onPostExecute(Integer num) {
                AppMethodBeat.m2504i(85897);
                if (num.intValue() != 0) {
                    XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(num.intValue());
                    AppMethodBeat.m2505o(85897);
                    return;
                }
                XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateCompleted();
                AppMethodBeat.m2505o(85897);
            }
        }

        public BackgroundListener(UpdateConfig updateConfig) {
            this.mConfig = updateConfig;
        }

        public void onDownloadStarted(int i) {
            AppMethodBeat.m2504i(85900);
            Log.m81045d(XWalkUpdater.TAG, "DownloadTask started, type:" + i + " config:" + this.mConfig.getLogSelf());
            if (this.mConfig.isPatchUpdate) {
                C24532f.aHn();
            } else {
                C24532f.dVb();
            }
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateStarted();
            AppMethodBeat.m2505o(85900);
        }

        public void onDownloadUpdated(int i) {
            AppMethodBeat.m2504i(85901);
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateProgress(i);
            AppMethodBeat.m2505o(85901);
        }

        public void onDownloadCancelled() {
            AppMethodBeat.m2504i(85902);
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateCancelled();
            AppMethodBeat.m2505o(85902);
        }

        public void onDownloadFailed(DownloadInfo downloadInfo) {
            AppMethodBeat.m2504i(85903);
            XWalkInitializer.addXWalkInitializeLog(XWalkUpdater.TAG, "download apk failed");
            if (this.mConfig.isPatchUpdate) {
                C24532f.dVg();
            } else {
                C24532f.dVc();
            }
            reportKV(downloadInfo);
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(-1);
            AppMethodBeat.m2505o(85903);
        }

        public void onDownloadCompleted(DownloadInfo downloadInfo) {
            AppMethodBeat.m2504i(85904);
            XWalkInitializer.addXWalkInitializeLog(XWalkUpdater.TAG, "download apk completed, apkver = " + this.mConfig.apkVer);
            if (this.mConfig.isPatchUpdate) {
                C24532f.m38187nO(System.currentTimeMillis() - downloadInfo.mStartTimestamp);
            } else {
                C24532f.m38185nM(System.currentTimeMillis() - downloadInfo.mStartTimestamp);
            }
            reportKV(downloadInfo);
            new C164791().execute(new Void[0]);
            AppMethodBeat.m2505o(85904);
        }

        private void reportKV(DownloadInfo downloadInfo) {
            int i = 1;
            AppMethodBeat.m2504i(85905);
            int i2 = this.mConfig.isPatchUpdate ? 2 : 1;
            int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion();
            int i3 = this.mConfig.apkVer;
            long currentTimeMillis = System.currentTimeMillis() - downloadInfo.mStartTimestamp;
            if (!downloadInfo.mIsDownloadResume) {
                i = 0;
            }
            C24532f.m38172bX(15124, i2 + "," + installedNewstVersion + "," + i3 + ",190301," + downloadInfo.mErrorCode + "," + downloadInfo.mNetWorkType + "," + downloadInfo.mRetryTimes + "," + currentTimeMillis + "," + downloadInfo.mFileTotalSize + "," + downloadInfo.mDownloadType + "," + i);
            AppMethodBeat.m2505o(85905);
        }
    }

    public static class ErrorInfo {
        public int copyFailedCount = 0;
        public int errorCode = -11;
        public int extractFailedCount = 0;
        public int extractRetryFailedCount = 0;
        public int md5FailedCount = 0;
        public int noMatchedVersionCount = 0;
        public int readFileListFailedCount = 0;
        public int setVersionFailedCount = 0;
        public int targetVer = -1;
    }

    public static class FileListMD5Checker {
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0107 A:{SYNTHETIC, Splitter:B:61:0x0107} */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x010c A:{SYNTHETIC, Splitter:B:64:0x010c} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0111 A:{SYNTHETIC, Splitter:B:67:0x0111} */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0140 A:{SYNTHETIC, Splitter:B:79:0x0140} */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0145 A:{SYNTHETIC, Splitter:B:82:0x0145} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x014a A:{SYNTHETIC, Splitter:B:85:0x014a} */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0107 A:{SYNTHETIC, Splitter:B:61:0x0107} */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x010c A:{SYNTHETIC, Splitter:B:64:0x010c} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0111 A:{SYNTHETIC, Splitter:B:67:0x0111} */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0140 A:{SYNTHETIC, Splitter:B:79:0x0140} */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0145 A:{SYNTHETIC, Splitter:B:82:0x0145} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x014a A:{SYNTHETIC, Splitter:B:85:0x014a} */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0140 A:{SYNTHETIC, Splitter:B:79:0x0140} */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0145 A:{SYNTHETIC, Splitter:B:82:0x0145} */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x014a A:{SYNTHETIC, Splitter:B:85:0x014a} */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0107 A:{SYNTHETIC, Splitter:B:61:0x0107} */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x010c A:{SYNTHETIC, Splitter:B:64:0x010c} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0111 A:{SYNTHETIC, Splitter:B:67:0x0111} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean checkFileListMd5(int i, File file) {
            Exception e;
            Throwable th;
            AppMethodBeat.m2504i(85906);
            if (file == null) {
                AppMethodBeat.m2505o(85906);
                return false;
            }
            FileInputStream fileInputStream;
            InputStreamReader inputStreamReader;
            BufferedReader bufferedReader;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close inputStream failed");
                                    }
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e3) {
                                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close inputreader failed");
                                    }
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e4) {
                                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close buffreader failed");
                                    }
                                    AppMethodBeat.m2505o(85906);
                                    return true;
                                } else if (!(readLine == null || readLine.isEmpty())) {
                                    String[] split = readLine.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                    if (!(split == null || split.length != 2 || split[0] == null || split[0].isEmpty() || split[1] == null || split[1].isEmpty() || checkFileMd5(i, split[0], split[1]))) {
                                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 error name:" + split[0] + ",md5:" + split[1]);
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e5) {
                                            Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close inputStream failed");
                                        }
                                        try {
                                            inputStreamReader.close();
                                        } catch (Exception e6) {
                                            Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close inputreader failed");
                                        }
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e7) {
                                            Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close buffreader failed");
                                        }
                                        AppMethodBeat.m2505o(85906);
                                        return false;
                                    }
                                }
                            } catch (Exception e8) {
                                e = e8;
                                try {
                                    Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 error:" + e.getMessage());
                                    if (fileInputStream != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    AppMethodBeat.m2505o(85906);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (fileInputStream != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    AppMethodBeat.m2505o(85906);
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        bufferedReader = null;
                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 error:" + e.getMessage());
                        if (fileInputStream != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.m2505o(85906);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        if (fileInputStream != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.m2505o(85906);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    bufferedReader = null;
                    inputStreamReader = null;
                    Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 error:" + e.getMessage());
                    if (fileInputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(85906);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    inputStreamReader = null;
                    if (fileInputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(85906);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                bufferedReader = null;
                inputStreamReader = null;
                fileInputStream = null;
                Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 error:" + e.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e12) {
                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close inputStream failed");
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception e13) {
                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close inputreader failed");
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e14) {
                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close buffreader failed");
                    }
                }
                AppMethodBeat.m2505o(85906);
                return false;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                inputStreamReader = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e15) {
                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close inputStream failed");
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception e16) {
                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close inputreader failed");
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e17) {
                        Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 close buffreader failed");
                    }
                }
                AppMethodBeat.m2505o(85906);
                throw th;
            }
        }

        public static boolean checkFileListMd5(int i, String str) {
            AppMethodBeat.m2504i(85907);
            try {
                boolean checkFileListMd5 = checkFileListMd5(i, new File(str));
                AppMethodBeat.m2505o(85907);
                return checkFileListMd5;
            } catch (Exception e) {
                Log.m81046e(XWalkUpdater.TAG, "checkFileListMd5 error:" + e.getMessage());
                AppMethodBeat.m2505o(85907);
                return false;
            }
        }

        private static boolean checkFileMd5(int i, String str, String str2) {
            String downloadApkPath;
            AppMethodBeat.m2504i(85908);
            if (XWalkEnvironment.XWALK_CORE_APK_NAME.equals(str)) {
                downloadApkPath = XWalkEnvironment.getDownloadApkPath(i);
            } else {
                downloadApkPath = XWalkEnvironment.getExtractedCoreFile(i, str);
            }
            if (C6037d.m9502gA(downloadApkPath, str2)) {
                Log.m81049i(XWalkUpdater.TAG, "checkFileMd5 successful path:".concat(String.valueOf(downloadApkPath)));
                AppMethodBeat.m2505o(85908);
                return true;
            }
            Log.m81046e(XWalkUpdater.TAG, "checkFileMd5 error path:".concat(String.valueOf(downloadApkPath)));
            AppMethodBeat.m2505o(85908);
            return false;
        }
    }

    public static class UpdateConfig {
        public int apkVer = -1;
        public boolean bTryUseSharedCore;
        public boolean bUseCdn;
        public String downUrl;
        public String downloadFileMd5;
        public boolean isMatchMd5 = false;
        public boolean isPatchUpdate;
        public String patchEndFileMd5;
        public String versionDetail;

        public UpdateConfig(String str, boolean z, int i) {
            AppMethodBeat.m2504i(85911);
            this.isPatchUpdate = z;
            this.downUrl = str;
            this.apkVer = i;
            if (checkValid()) {
                AppMethodBeat.m2505o(85911);
                return;
            }
            RuntimeException runtimeException = new RuntimeException("royle:UpdateConfig is not valid");
            AppMethodBeat.m2505o(85911);
            throw runtimeException;
        }

        public UpdateConfig(String str, boolean z, String str2, String str3, int i) {
            AppMethodBeat.m2504i(85912);
            this.downloadFileMd5 = str;
            this.isPatchUpdate = z;
            this.patchEndFileMd5 = str2;
            this.downUrl = str3;
            this.apkVer = i;
            if (checkValid()) {
                AppMethodBeat.m2505o(85912);
                return;
            }
            RuntimeException runtimeException = new RuntimeException("royle:UpdateConfig is not valid");
            AppMethodBeat.m2505o(85912);
            throw runtimeException;
        }

        public String getDownloadPath() {
            AppMethodBeat.m2504i(85913);
            String downloadPatchPath;
            if (!checkValid()) {
                RuntimeException runtimeException = new RuntimeException("royle:UpdateConfig is not valid");
                AppMethodBeat.m2505o(85913);
                throw runtimeException;
            } else if (this.isPatchUpdate) {
                downloadPatchPath = XWalkEnvironment.getDownloadPatchPath(this.apkVer);
                AppMethodBeat.m2505o(85913);
                return downloadPatchPath;
            } else {
                downloadPatchPath = XWalkEnvironment.getDownloadZipDir(this.apkVer);
                AppMethodBeat.m2505o(85913);
                return downloadPatchPath;
            }
        }

        public int getUpdateBizType() {
            if (this.isPatchUpdate) {
                return 2;
            }
            return 1;
        }

        public boolean checkValid() {
            AppMethodBeat.m2504i(85914);
            if (this.isMatchMd5 && (this.downloadFileMd5 == null || this.downloadFileMd5.isEmpty())) {
                AppMethodBeat.m2505o(85914);
                return false;
            } else if (this.downUrl == null || this.downUrl.isEmpty()) {
                AppMethodBeat.m2505o(85914);
                return false;
            } else if (this.apkVer == -1) {
                AppMethodBeat.m2505o(85914);
                return false;
            } else if (this.isMatchMd5 && this.isPatchUpdate && (this.patchEndFileMd5 == null || this.patchEndFileMd5.isEmpty())) {
                AppMethodBeat.m2505o(85914);
                return false;
            } else {
                AppMethodBeat.m2505o(85914);
                return true;
            }
        }

        public String getLogSelf() {
            AppMethodBeat.m2504i(85915);
            String str;
            if (checkValid()) {
                str = "UpdateConfig isMatchMd5:" + this.isMatchMd5 + " downloadFileMd5:" + this.downloadFileMd5 + ",isPatchUpdate:" + this.isPatchUpdate + ",downUrl:" + this.downUrl + ",apkVer:" + this.apkVer + ",useCDN:" + this.bUseCdn + ",downloadPath:" + getDownloadPath() + ".";
                AppMethodBeat.m2505o(85915);
                return str;
            }
            str = "UpdateConfig is not valid";
            AppMethodBeat.m2505o(85915);
            return str;
        }
    }

    public static class PatchFileConfigParser {
        private static final String ADD_FLAG = "ADD:";
        private static final int ADD_TYPE = 1;
        private static final int APK_FILE_TYPE = 1;
        private static final String DEL_FLAG = "DEL:";
        private static final int DEL_TYPE = 3;
        private static final int EXTRACTED_FILE_TYPE = 2;
        private static final String MOD_FLAG = "MOD:";
        private static final int MOD_TYPE = 2;
        private static final String PATCH_SUFFIX = ".patch";

        public static ArrayList<PatchFileConfig> getPatchFileConfigList(int i) {
            Closeable inputStreamReader;
            Exception e;
            Closeable closeable;
            Throwable th;
            AppMethodBeat.m2504i(85910);
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(XWalkEnvironment.getPatchConfig(i)));
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    closeable = null;
                    inputStreamReader = null;
                    try {
                        Log.m81046e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                        C41131b.tryClose(fileInputStream);
                        C41131b.tryClose(inputStreamReader);
                        C41131b.tryClose(closeable);
                        AppMethodBeat.m2505o(85910);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        C41131b.tryClose(fileInputStream);
                        C41131b.tryClose(inputStreamReader);
                        C41131b.tryClose(closeable);
                        AppMethodBeat.m2505o(85910);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    inputStreamReader = null;
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(inputStreamReader);
                    C41131b.tryClose(closeable);
                    AppMethodBeat.m2505o(85910);
                    throw th;
                }
                try {
                    closeable = new BufferedReader(inputStreamReader);
                } catch (Exception e3) {
                    e = e3;
                    closeable = null;
                    Log.m81046e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(inputStreamReader);
                    C41131b.tryClose(closeable);
                    AppMethodBeat.m2505o(85910);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    closeable = null;
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(inputStreamReader);
                    C41131b.tryClose(closeable);
                    AppMethodBeat.m2505o(85910);
                    throw th;
                }
                try {
                    ArrayList<PatchFileConfig> arrayList = new ArrayList();
                    while (true) {
                        String readLine = closeable.readLine();
                        if (readLine == null) {
                            C41131b.tryClose(fileInputStream);
                            C41131b.tryClose(inputStreamReader);
                            C41131b.tryClose(closeable);
                            AppMethodBeat.m2505o(85910);
                            return arrayList;
                        } else if (!(readLine == null || readLine.isEmpty())) {
                            int i2;
                            if (readLine.startsWith(ADD_FLAG)) {
                                readLine = readLine.substring(4);
                                i2 = 1;
                            } else if (readLine.startsWith(MOD_FLAG)) {
                                readLine = readLine.substring(4);
                                i2 = 2;
                            } else if (readLine.startsWith(DEL_FLAG)) {
                                readLine = readLine.substring(4);
                                i2 = 3;
                            } else {
                                i2 = 0;
                            }
                            for (String str : readLine.split(",")) {
                                if (!(str == null || str.isEmpty())) {
                                    PatchFileConfig patchFileConfig = new PatchFileConfig();
                                    patchFileConfig.originalFileName = str;
                                    patchFileConfig.type = i2;
                                    if (i2 == 2) {
                                        patchFileConfig.patchFileName = patchFileConfig.originalFileName + PATCH_SUFFIX;
                                    }
                                    if (i2 == 2 && patchFileConfig.originalFileName.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                                        patchFileConfig.originalFileType = 1;
                                    } else {
                                        patchFileConfig.originalFileType = 2;
                                    }
                                    Log.m81045d(XWalkUpdater.TAG, "getPatchFileConfigList config:" + patchFileConfig.toString());
                                    arrayList.add(patchFileConfig);
                                }
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.m81046e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                    C41131b.tryClose(fileInputStream);
                    C41131b.tryClose(inputStreamReader);
                    C41131b.tryClose(closeable);
                    AppMethodBeat.m2505o(85910);
                    return null;
                }
            } catch (Exception e5) {
                e = e5;
                closeable = null;
                inputStreamReader = null;
                fileInputStream = null;
                Log.m81046e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                C41131b.tryClose(fileInputStream);
                C41131b.tryClose(inputStreamReader);
                C41131b.tryClose(closeable);
                AppMethodBeat.m2505o(85910);
                return null;
            } catch (Throwable th5) {
                th = th5;
                closeable = null;
                inputStreamReader = null;
                fileInputStream = null;
                C41131b.tryClose(fileInputStream);
                C41131b.tryClose(inputStreamReader);
                C41131b.tryClose(closeable);
                AppMethodBeat.m2505o(85910);
                throw th;
            }
        }
    }

    public static class PatchFileConfig {
        public String originalFileName;
        public int originalFileType;
        public String patchEndFileMd5;
        public String patchFileName;
        public int type;

        public boolean isTypeAdd() {
            return this.type == 1;
        }

        public boolean isTypeModify() {
            return this.type == 2;
        }

        public boolean isTypeRemove() {
            return this.type == 3;
        }

        public boolean isOriginalFileTypeApk() {
            return this.originalFileType == 1;
        }

        public boolean isExtractedFile() {
            return this.originalFileType == 2;
        }

        public String toString() {
            AppMethodBeat.m2504i(85909);
            String str = "PatchFileConfig type:" + this.type + ",originalFileType:" + this.originalFileType + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName + ",patchEndFileMd5:" + this.patchEndFileMd5;
            AppMethodBeat.m2505o(85909);
            return str;
        }
    }

    public interface XWalkBackgroundUpdateListener {
        void onXWalkUpdateCancelled();

        void onXWalkUpdateCompleted();

        void onXWalkUpdateFailed(int i);

        void onXWalkUpdateProgress(int i);

        void onXWalkUpdateStarted();
    }

    public XWalkUpdater(XWalkUpdateListener xWalkUpdateListener, Context context) {
        AppMethodBeat.m2504i(85916);
        this.mUpdateListener = xWalkUpdateListener;
        this.mContext = context;
        this.mDialogManager = new XWalkDialogManager(context);
        AppMethodBeat.m2505o(85916);
    }

    public XWalkUpdater(XWalkUpdateListener xWalkUpdateListener, Context context, XWalkDialogManager xWalkDialogManager) {
        this.mUpdateListener = xWalkUpdateListener;
        this.mContext = context;
        this.mDialogManager = xWalkDialogManager;
    }

    public XWalkUpdater(XWalkBackgroundUpdateListener xWalkBackgroundUpdateListener, Context context) {
        this.mBackgroundUpdateListener = xWalkBackgroundUpdateListener;
        this.mContext = context;
    }

    public boolean updateXWalkRuntime(UpdateConfig updateConfig) {
        AppMethodBeat.m2504i(85917);
        if (XWalkLibraryLoader.isDownloading()) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "Other initialization or download is proceeding");
            AppMethodBeat.m2505o(85917);
            return false;
        } else if (this.mBackgroundUpdateListener == null) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "Update listener is null");
            AppMethodBeat.m2505o(85917);
            return false;
        } else if (updateConfig == null || !updateConfig.checkValid()) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "royle:XWalkUpdater updateXWalkRuntime updateConfig is not valid");
            C24532f.dVd();
            AppMethodBeat.m2505o(85917);
            return false;
        } else {
            XWalkInitializer.addXWalkInitializeLog(TAG, "start download apk");
            XWalkLibraryLoader.startHttpDownload(new BackgroundListener(updateConfig), this.mContext, updateConfig);
            AppMethodBeat.m2505o(85917);
            return true;
        }
    }

    public synchronized ErrorInfo updateRuntimeFromProvider(C31155a c31155a) {
        ErrorInfo errorInfo;
        AppMethodBeat.m2504i(85918);
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider target ver " + c31155a.ATn);
        ErrorInfo errorInfo2 = new ErrorInfo();
        errorInfo2.targetVer = c31155a.ATn;
        if (!c31155a.bTryUseSharedCore) {
            XWalkInitializer.addXWalkInitializeLog("updateFromProvider force download");
            errorInfo2.errorCode = -6;
            AppMethodBeat.m2505o(85918);
            errorInfo = errorInfo2;
        } else if (c31155a.ATy >= 2) {
            XWalkInitializer.addXWalkInitializeLog("updateFromProvider exceed max count");
            errorInfo2.errorCode = -7;
            AppMethodBeat.m2505o(85918);
            errorInfo = errorInfo2;
        } else {
            ContentResolver contentResolver = XWalkEnvironment.getContentResolver();
            if (contentResolver == null) {
                XWalkInitializer.addXWalkInitializeLog("updateFromProvider content resolver null");
                errorInfo2.errorCode = -8;
                AppMethodBeat.m2505o(85918);
                errorInfo = errorInfo2;
            } else {
                UpdateConfig dWe = c31155a.dWe();
                Object obj = null;
                for (String str : XWalkEnvironment.XWALK_CORE_PROVIDER_LIST) {
                    if (isProviderExist(contentResolver, str)) {
                        obj = 1;
                        XWalkInitializer.addXWalkInitializeLog("updateFromProvider find ".concat(String.valueOf(str)));
                        Map tryGetFileList = tryGetFileList(contentResolver, str, dWe.apkVer);
                        if (tryGetFileList == null) {
                            XWalkInitializer.addXWalkInitializeLog("updateFromProvider read fileList failed");
                            errorInfo2.readFileListFailedCount++;
                        } else if (tryGetFileList.size() == 0) {
                            XWalkInitializer.addXWalkInitializeLog("updateFromProvider no matched version");
                            errorInfo2.noMatchedVersionCount++;
                        } else if (tryCopyVersion(contentResolver, str, dWe.apkVer, tryGetFileList, errorInfo2)) {
                            int intValue = extractResource(dWe).intValue();
                            if (intValue == 0) {
                                errorInfo2.errorCode = 0;
                                AppMethodBeat.m2505o(85918);
                                errorInfo = errorInfo2;
                                break;
                            } else if (intValue == -5) {
                                errorInfo2.extractFailedCount++;
                            } else if (intValue == -12) {
                                errorInfo2.extractRetryFailedCount++;
                            } else if (intValue == ERROR_SET_VERNUM) {
                                errorInfo2.setVersionFailedCount++;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (obj == null) {
                    XWalkInitializer.addXWalkInitializeLog("updateFromProvider no provider");
                    errorInfo2.errorCode = -9;
                    AppMethodBeat.m2505o(85918);
                    errorInfo = errorInfo2;
                } else {
                    if (!XWalkEnvironment.hasAvailableVersion() || c31155a.ATy + 1 >= 2) {
                        XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, do not try again");
                        errorInfo2.errorCode = -11;
                    } else {
                        XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, can try again");
                        errorInfo2.errorCode = -10;
                    }
                    AppMethodBeat.m2505o(85918);
                    errorInfo = errorInfo2;
                }
            }
        }
        return errorInfo;
    }

    private static boolean isProviderExist(ContentResolver contentResolver, String str) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(85919);
        if (contentResolver == null || str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(85919);
            return z2;
        }
        try {
            C41131b.m71559a(contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.m89065b(str, XWalkEnvironment.getPackageName(), 1, 0, ""), ""));
        } catch (Exception e) {
            C41131b.m71559a(null);
            z = z2;
        } catch (Throwable th) {
            C41131b.m71559a(null);
            AppMethodBeat.m2505o(85919);
        }
        AppMethodBeat.m2505o(85919);
        return z;
    }

    private static Map<String, String> tryGetFileList(ContentResolver contentResolver, String str, int i) {
        Exception e;
        Closeable closeable;
        Closeable closeable2;
        Throwable th;
        AppMethodBeat.m2504i(85920);
        Map<String, String> hashMap = new HashMap();
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.m89065b(str, XWalkEnvironment.getPackageName(), 2, i, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME), "");
            if (openAssetFileDescriptor == null) {
                try {
                    XWalkInitializer.addXWalkInitializeLog("tryGetFileList no file list");
                    C41131b.tryClose(null);
                    C41131b.tryClose(null);
                    C41131b.m71559a(openAssetFileDescriptor);
                    AppMethodBeat.m2505o(85920);
                    return hashMap;
                } catch (Exception e2) {
                    e = e2;
                    closeable = null;
                    closeable2 = null;
                    try {
                        XWalkInitializer.addXWalkInitializeLog("tryGetFileList error: " + e.getMessage());
                        C41131b.tryClose(closeable);
                        C41131b.tryClose(closeable2);
                        C41131b.m71559a(openAssetFileDescriptor);
                        AppMethodBeat.m2505o(85920);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        C41131b.tryClose(closeable);
                        C41131b.tryClose(closeable2);
                        C41131b.m71559a(openAssetFileDescriptor);
                        AppMethodBeat.m2505o(85920);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    closeable2 = null;
                    C41131b.tryClose(closeable);
                    C41131b.tryClose(closeable2);
                    C41131b.m71559a(openAssetFileDescriptor);
                    AppMethodBeat.m2505o(85920);
                    throw th;
                }
            }
            File file = new File(XWalkEnvironment.getExtractedCoreFile(i, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME));
            if (file.exists()) {
                file.delete();
            }
            closeable = new PrintWriter(file);
            try {
                closeable2 = new BufferedReader(new InputStreamReader(openAssetFileDescriptor.createInputStream()));
                while (true) {
                    try {
                        String readLine = closeable2.readLine();
                        if (readLine != null) {
                            closeable.println(readLine);
                            if (!readLine.isEmpty()) {
                                String[] split = readLine.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                if (!(split.length != 2 || split[0] == null || split[0].isEmpty() || split[1] == null || split[1].isEmpty())) {
                                    hashMap.put(split[0], split[1]);
                                }
                            }
                        } else {
                            closeable.flush();
                            C41131b.tryClose(closeable);
                            C41131b.tryClose(closeable2);
                            C41131b.m71559a(openAssetFileDescriptor);
                            AppMethodBeat.m2505o(85920);
                            return hashMap;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        XWalkInitializer.addXWalkInitializeLog("tryGetFileList error: " + e.getMessage());
                        C41131b.tryClose(closeable);
                        C41131b.tryClose(closeable2);
                        C41131b.m71559a(openAssetFileDescriptor);
                        AppMethodBeat.m2505o(85920);
                        return null;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                closeable2 = null;
                XWalkInitializer.addXWalkInitializeLog("tryGetFileList error: " + e.getMessage());
                C41131b.tryClose(closeable);
                C41131b.tryClose(closeable2);
                C41131b.m71559a(openAssetFileDescriptor);
                AppMethodBeat.m2505o(85920);
                return null;
            } catch (Throwable th4) {
                th = th4;
                closeable2 = null;
                C41131b.tryClose(closeable);
                C41131b.tryClose(closeable2);
                C41131b.m71559a(openAssetFileDescriptor);
                AppMethodBeat.m2505o(85920);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            closeable = null;
            closeable2 = null;
            openAssetFileDescriptor = null;
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            closeable2 = null;
            openAssetFileDescriptor = null;
            C41131b.tryClose(closeable);
            C41131b.tryClose(closeable2);
            C41131b.m71559a(openAssetFileDescriptor);
            AppMethodBeat.m2505o(85920);
            throw th;
        }
    }

    private static boolean tryCopyVersion(ContentResolver contentResolver, String str, int i, Map<String, String> map, ErrorInfo errorInfo) {
        AppMethodBeat.m2504i(85921);
        try {
            for (Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.m89065b(str, XWalkEnvironment.getPackageName(), 2, i, str2), "");
                if (openAssetFileDescriptor == null) {
                    errorInfo.copyFailedCount++;
                    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion no file ".concat(String.valueOf(str2)));
                    AppMethodBeat.m2505o(85921);
                    return false;
                }
                File file;
                if (XWalkEnvironment.XWALK_CORE_APK_NAME.equals(str2)) {
                    file = new File(XWalkEnvironment.getDownloadApkPath(i));
                } else {
                    file = new File(XWalkEnvironment.getExtractedCoreFile(i, str2));
                }
                if (!C41131b.m71560a(openAssetFileDescriptor, file)) {
                    errorInfo.copyFailedCount++;
                    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error");
                    AppMethodBeat.m2505o(85921);
                    return false;
                } else if (!C6037d.m9502gA(file.getAbsolutePath(), str3)) {
                    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion md5 error ".concat(String.valueOf(str2)));
                    errorInfo.md5FailedCount++;
                    if (file.exists()) {
                        file.delete();
                    }
                    AppMethodBeat.m2505o(85921);
                    return false;
                }
            }
            AppMethodBeat.m2505o(85921);
            return true;
        } catch (Exception e) {
            XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error:" + e.getMessage());
            errorInfo.copyFailedCount++;
            AppMethodBeat.m2505o(85921);
            return false;
        }
    }

    public static void updateLocalXWalkRuntime() {
        AppMethodBeat.m2504i(85922);
        onHandleFile(new UpdateConfig(XWalkEnvironment.LOCAL_TEST_ZIP_NAME, false, 100000));
        AppMethodBeat.m2505o(85922);
    }

    public void cancelXWalkRuntimeDownload() {
        AppMethodBeat.m2504i(85923);
        if (XWalkLibraryLoader.isDownloading()) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "canceled download apk");
            XWalkLibraryLoader.cancelHttpDownload();
        }
        AppMethodBeat.m2505o(85923);
    }

    public boolean dismissDialog() {
        AppMethodBeat.m2504i(85924);
        if (this.mDialogManager == null || !this.mDialogManager.isShowingDialog()) {
            AppMethodBeat.m2505o(85924);
            return false;
        }
        this.mDialogManager.dismissDialog();
        AppMethodBeat.m2505o(85924);
        return true;
    }

    public boolean cancelBackgroundDownload() {
        AppMethodBeat.m2504i(85925);
        boolean cancelHttpDownload = XWalkLibraryLoader.cancelHttpDownload();
        AppMethodBeat.m2505o(85925);
        return cancelHttpDownload;
    }

    public static Integer onHandleFile(UpdateConfig updateConfig) {
        AppMethodBeat.m2504i(85926);
        String downloadPath = updateConfig.getDownloadPath();
        Log.m81045d(TAG, "Download mode extract dir: ".concat(String.valueOf(XWalkEnvironment.getExtractedCoreDir(updateConfig.apkVer))));
        Integer valueOf;
        if (!updateConfig.isMatchMd5 || C6037d.m9502gA(downloadPath, updateConfig.downloadFileMd5)) {
            if (updateConfig.isPatchUpdate) {
                if (!onDoPatch(downloadPath, XWalkEnvironment.getInstalledNewstVersion(), updateConfig.apkVer)) {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode ,but patch error");
                    valueOf = Integer.valueOf(-3);
                    AppMethodBeat.m2505o(85926);
                    return valueOf;
                } else if (!updateConfig.isMatchMd5 || FileListMD5Checker.checkFileListMd5(updateConfig.apkVer, XWalkEnvironment.getPatchFileListConfig(updateConfig.apkVer))) {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "do patch sucsess");
                } else {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode, but md5 not match");
                    C24532f.m38181nI(36);
                    valueOf = Integer.valueOf(-4);
                    AppMethodBeat.m2505o(85926);
                    return valueOf;
                }
            } else if (!XWalkDecompressor.decompressDownloadFullZip(downloadPath, updateConfig.apkVer)) {
                C24532f.m38181nI(32);
                valueOf = Integer.valueOf(-5);
                AppMethodBeat.m2505o(85926);
                return valueOf;
            } else if (updateConfig.isMatchMd5 && !FileListMD5Checker.checkFileListMd5(updateConfig.apkVer, XWalkEnvironment.getDownloadZipFileListConfig(updateConfig.apkVer))) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode, but md5 not match");
                C24532f.m38181nI(33);
                valueOf = Integer.valueOf(-4);
                AppMethodBeat.m2505o(85926);
                return valueOf;
            }
            valueOf = extractResource(updateConfig);
            AppMethodBeat.m2505o(85926);
            return valueOf;
        }
        XWalkInitializer.addXWalkInitializeLog(TAG, "downloaded apk md5 check failed");
        valueOf = Integer.valueOf(-2);
        AppMethodBeat.m2505o(85926);
        return valueOf;
    }

    private static Integer extractResource(UpdateConfig updateConfig) {
        AppMethodBeat.m2504i(85927);
        while (true) {
            String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(updateConfig.apkVer);
            Integer valueOf;
            if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(updateConfig.apkVer), extractedCoreDir)) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "extract faield");
                valueOf = Integer.valueOf(-5);
                AppMethodBeat.m2505o(85927);
                return valueOf;
            } else if (checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(updateConfig.apkVer), extractedCoreDir, updateConfig.apkVer)) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "checkExtractResFileLengtgAndMd5 success!!!!");
                if (!generateOptDex(updateConfig.apkVer)) {
                    C24532f.m38181nI(251);
                    if ("true".equalsIgnoreCase(C44572a.m80959iG("update_need_check_dex", "tools"))) {
                        valueOf = Integer.valueOf(ERROR_SET_VERNUM);
                        AppMethodBeat.m2505o(85927);
                        return valueOf;
                    }
                }
                boolean availableVersion = XWalkEnvironment.setAvailableVersion(updateConfig.apkVer, updateConfig.versionDetail);
                XWalkInitializer.addXWalkInitializeLog(TAG, "do update sucsess");
                if (availableVersion) {
                    valueOf = Integer.valueOf(0);
                    AppMethodBeat.m2505o(85927);
                    return valueOf;
                }
                XWalkInitializer.addXWalkInitializeLog(TAG, "set version failed");
                valueOf = Integer.valueOf(ERROR_SET_VERNUM);
                AppMethodBeat.m2505o(85927);
                return valueOf;
            } else if (mCurrentTimeForRetryRes <= 0) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "checkExtractResFileLengtgAndMd5 failed retry extractResource");
                mCurrentTimeForRetryRes++;
            } else {
                XWalkInitializer.addXWalkInitializeLog(TAG, "checkResourceLengthAndMd5 failed can not retry!!!!!!!!!! mCurrentTimeForRetryRes = " + mCurrentTimeForRetryRes);
                valueOf = Integer.valueOf(-12);
                AppMethodBeat.m2505o(85927);
                return valueOf;
            }
        }
    }

    private static boolean generateOptDex(int i) {
        AppMethodBeat.m2504i(85928);
        try {
            DexClassLoader dexClassLoader = new DexClassLoader(XWalkEnvironment.getClassDexFilePath(i), XWalkEnvironment.getOptimizedDexDir(i), XWalkEnvironment.getExtractedCoreDir(i), ClassLoader.getSystemClassLoader());
            AppMethodBeat.m2505o(85928);
            return true;
        } catch (Exception e) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "dex output error");
            AppMethodBeat.m2505o(85928);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0182 A:{SYNTHETIC, Splitter:B:78:0x0182} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0187 A:{SYNTHETIC, Splitter:B:81:0x0187} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x018c A:{SYNTHETIC, Splitter:B:84:0x018c} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bc A:{SYNTHETIC, Splitter:B:96:0x01bc} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01c1 A:{SYNTHETIC, Splitter:B:99:0x01c1} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01c6 A:{SYNTHETIC, Splitter:B:102:0x01c6} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0182 A:{SYNTHETIC, Splitter:B:78:0x0182} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0187 A:{SYNTHETIC, Splitter:B:81:0x0187} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x018c A:{SYNTHETIC, Splitter:B:84:0x018c} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0182 A:{SYNTHETIC, Splitter:B:78:0x0182} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0187 A:{SYNTHETIC, Splitter:B:81:0x0187} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x018c A:{SYNTHETIC, Splitter:B:84:0x018c} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bc A:{SYNTHETIC, Splitter:B:96:0x01bc} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01c1 A:{SYNTHETIC, Splitter:B:99:0x01c1} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01c6 A:{SYNTHETIC, Splitter:B:102:0x01c6} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bc A:{SYNTHETIC, Splitter:B:96:0x01bc} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01c1 A:{SYNTHETIC, Splitter:B:99:0x01c1} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01c6 A:{SYNTHETIC, Splitter:B:102:0x01c6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkExtractResFileLengtgAndMd5(String str, String str2, int i) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(85929);
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        try {
            File file = new File(str);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close inputStream failed");
                                    }
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e3) {
                                        Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close inputreader failed");
                                    }
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e4) {
                                        Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close buffreader failed");
                                    }
                                    AppMethodBeat.m2505o(85929);
                                    return true;
                                } else if (!(readLine == null || readLine.isEmpty())) {
                                    String[] split = readLine.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                                    if (!(split == null || split.length != 2 || split[0] == null || split[0].isEmpty() || split[1] == null || split[1].isEmpty())) {
                                        File file2 = new File(str2, split[0]);
                                        String v = C6037d.m9504v(file2);
                                        if (!v.equalsIgnoreCase(split[1])) {
                                            XWalkInitializer.addXWalkInitializeLog(TAG, "Exception unpacking required pak resources: " + split[0] + " expected md5 = " + split[1] + " outputmd5 = %s" + v);
                                            file2.delete();
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e5) {
                                                Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close inputStream failed");
                                            }
                                            try {
                                                inputStreamReader.close();
                                            } catch (Exception e6) {
                                                Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close inputreader failed");
                                            }
                                            try {
                                                bufferedReader.close();
                                            } catch (Exception e7) {
                                                Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close buffreader failed");
                                            }
                                            AppMethodBeat.m2505o(85929);
                                            return false;
                                        }
                                    }
                                }
                            } catch (Exception e8) {
                                e = e8;
                                try {
                                    Log.m81046e(TAG, "checkFileListMd5 error:" + e.getMessage());
                                    if (fileInputStream != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    AppMethodBeat.m2505o(85929);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (fileInputStream != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    AppMethodBeat.m2505o(85929);
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        bufferedReader = null;
                        Log.m81046e(TAG, "checkFileListMd5 error:" + e.getMessage());
                        if (fileInputStream != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.m2505o(85929);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        if (fileInputStream != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.m2505o(85929);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    bufferedReader = null;
                    inputStreamReader = null;
                    Log.m81046e(TAG, "checkFileListMd5 error:" + e.getMessage());
                    if (fileInputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(85929);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    inputStreamReader = null;
                    if (fileInputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(85929);
                    throw th;
                }
            }
            boolean z = XWalkEnvironment.isTestVersion(i) || i < 362;
            if (z) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "resConfigPath not exist ,maybe old runtime".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(85929);
                return true;
            }
            C24532f.m38181nI(79);
            XWalkInitializer.addXWalkInitializeLog(TAG, "resConfigPath not exist ".concat(String.valueOf(str)));
            if ("true".equalsIgnoreCase(C44572a.m80959iG("dis_res_config_file_check", "tools"))) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "dis_res_config_file_check ");
                AppMethodBeat.m2505o(85929);
                return true;
            }
            AppMethodBeat.m2505o(85929);
            return false;
        } catch (Exception e11) {
            e = e11;
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
            Log.m81046e(TAG, "checkFileListMd5 error:" + e.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e12) {
                    Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close inputStream failed");
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e13) {
                    Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close inputreader failed");
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e14) {
                    Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close buffreader failed");
                }
            }
            AppMethodBeat.m2505o(85929);
            return false;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e15) {
                    Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close inputStream failed");
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e16) {
                    Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close inputreader failed");
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e17) {
                    Log.m81046e(TAG, "checkExtractResFileLengtgAndMd5 close buffreader failed");
                }
            }
            AppMethodBeat.m2505o(85929);
            throw th;
        }
    }

    public static boolean onDoPatch(String str, int i, int i2) {
        AppMethodBeat.m2504i(85930);
        Log.m81049i(TAG, "onDoPatch:" + str + ",currentVersion:" + i + ",newVersion:" + i2);
        if (!new File(str).exists()) {
            Log.m81046e(TAG, "onDoPatch no patch zip file");
            AppMethodBeat.m2505o(85930);
            return false;
        } else if (XWalkDecompressor.decompressDownloadPatchZip(str, XWalkEnvironment.getPatchZipTempDecompressPath(i2))) {
            ArrayList patchFileConfigList = PatchFileConfigParser.getPatchFileConfigList(i2);
            if (patchFileConfigList == null) {
                Log.m81046e(TAG, "onDoPatch patchFileConfigList = null");
                C24532f.m38181nI(38);
                AppMethodBeat.m2505o(85930);
                return false;
            } else if (C41131b.m71562iI(XWalkEnvironment.getExtractedCoreDir(i), XWalkEnvironment.getExtractedCoreDir(i2))) {
                PatchFileConfig patchFileConfig;
                Log.m81049i(TAG, "onDoPatch copy all extraced file finished");
                ArrayList arrayList = new ArrayList();
                Iterator it = patchFileConfigList.iterator();
                while (it.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it.next();
                    if (patchFileConfig.isTypeAdd()) {
                        arrayList.add(patchFileConfig);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it2.next();
                    if (C41131b.copyFile(XWalkEnvironment.getPatchZipTempDecompressFilePath(i2, patchFileConfig.originalFileName), XWalkEnvironment.getExtractedCoreFile(i2, patchFileConfig.originalFileName))) {
                        Log.m81049i(TAG, "onDoPatch add file:".concat(String.valueOf(patchFileConfig)));
                    } else {
                        Log.m81046e(TAG, "onDoPatch add file error:".concat(String.valueOf(patchFileConfig)));
                        C24532f.m38181nI(40);
                        AppMethodBeat.m2505o(85930);
                        return false;
                    }
                }
                Log.m81049i(TAG, "onDoPatch add file finished");
                arrayList = new ArrayList();
                it = patchFileConfigList.iterator();
                while (it.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it.next();
                    if (patchFileConfig.isTypeRemove()) {
                        arrayList.add(patchFileConfig);
                    }
                }
                it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it2.next();
                    if (C41131b.deleteFile(XWalkEnvironment.getExtractedCoreFile(i2, patchFileConfig.originalFileName))) {
                        Log.m81049i(TAG, "onDoPatch delete file:".concat(String.valueOf(patchFileConfig)));
                    } else {
                        Log.m81046e(TAG, "onDoPatch delete file error:".concat(String.valueOf(patchFileConfig)));
                        C24532f.m38181nI(41);
                    }
                }
                Log.m81049i(TAG, "onDoPatch remove file finished");
                arrayList = new ArrayList();
                Iterator it3 = patchFileConfigList.iterator();
                while (it3.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it3.next();
                    if (patchFileConfig.isTypeModify()) {
                        arrayList.add(patchFileConfig);
                    }
                }
                it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it3.next();
                    if (patchFileConfig.isExtractedFile()) {
                        if (BSpatch.m25217aH(XWalkEnvironment.getExtractedCoreFile(i2, patchFileConfig.originalFileName), XWalkEnvironment.getPatchZipTempDecompressFilePath(i2, patchFileConfig.patchFileName), XWalkEnvironment.getExtractedCoreFile(i2, patchFileConfig.originalFileName)) < 0) {
                            Log.m81046e(TAG, "onDoPatch patch error file:".concat(String.valueOf(patchFileConfig)));
                            AppMethodBeat.m2505o(85930);
                            return false;
                        }
                        Log.m81049i(TAG, "onDoPatch patch file finished");
                    }
                }
                Log.m81049i(TAG, "onDoPatch patch file finished");
                it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it3.next();
                    if (patchFileConfig.isOriginalFileTypeApk()) {
                        if (BSpatch.m25217aH(XWalkEnvironment.getDownloadApkPath(i), XWalkEnvironment.getPatchZipTempDecompressFilePath(i2, patchFileConfig.patchFileName), XWalkEnvironment.getDownloadApkPath(i2)) < 0) {
                            Log.m81046e(TAG, "onDoPatch apk patch error file:".concat(String.valueOf(patchFileConfig)));
                            AppMethodBeat.m2505o(85930);
                            return false;
                        }
                        Log.m81049i(TAG, "onDoPatch apk patch finished");
                        AppMethodBeat.m2505o(85930);
                        return true;
                    }
                }
                Log.m81049i(TAG, "onDoPatch apk patch finished");
                AppMethodBeat.m2505o(85930);
                return true;
            } else {
                Log.m81046e(TAG, "onDoPatch copy all extraced file error");
                C24532f.m38181nI(39);
                AppMethodBeat.m2505o(85930);
                return false;
            }
        } else {
            Log.m81046e(TAG, "onDoPatch decompress zip error");
            C24532f.m38181nI(37);
            AppMethodBeat.m2505o(85930);
            return false;
        }
    }

    private boolean verifyDownloadedXWalkRuntime(String str) {
        AppMethodBeat.m2504i(85931);
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null) {
            Log.m81046e(TAG, "The downloaded XWalkRuntimeLib.apk is invalid!");
            AppMethodBeat.m2505o(85931);
            return false;
        }
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
            if (packageArchiveInfo.signatures == null || packageInfo.signatures == null) {
                Log.m81046e(TAG, "No signature in package info");
                AppMethodBeat.m2505o(85931);
                return false;
            } else if (packageArchiveInfo.signatures.length != packageInfo.signatures.length) {
                Log.m81046e(TAG, "signatures length not equal");
                AppMethodBeat.m2505o(85931);
                return false;
            } else {
                int i = 0;
                while (i < packageArchiveInfo.signatures.length) {
                    Log.m81045d(TAG, "Checking signature ".concat(String.valueOf(i)));
                    if (packageInfo.signatures[i].equals(packageArchiveInfo.signatures[i])) {
                        i++;
                    } else {
                        Log.m81046e(TAG, "signatures do not match");
                        AppMethodBeat.m2505o(85931);
                        return false;
                    }
                }
                Log.m81045d(TAG, "Signature check passed");
                AppMethodBeat.m2505o(85931);
                return true;
            }
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(85931);
            return false;
        }
    }
}
