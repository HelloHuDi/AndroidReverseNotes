package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkLibraryLoader.ActivateListener;
import org.xwalk.core.XWalkLibraryLoader.DecompressListener;

public class XWalkInitializer {
    private static final String TAG = "XWalkLib";
    private Context mContext;
    private XWalkInitListener mInitListener;
    private boolean mIsXWalkReady;

    public interface XWalkInitListener {
        void onXWalkInitCancelled();

        void onXWalkInitCompleted();

        void onXWalkInitFailed();

        void onXWalkInitStarted();
    }

    class XWalkLibraryListener implements ActivateListener, DecompressListener {
        private XWalkLibraryListener() {
        }

        public void onDecompressStarted() {
        }

        public void onDecompressCancelled() {
            AppMethodBeat.m2504i(85655);
            XWalkInitializer.this.mInitListener.onXWalkInitCancelled();
            AppMethodBeat.m2505o(85655);
        }

        public void onDecompressCompleted() {
        }

        public void onActivateStarted() {
        }

        public void onActivateFailed() {
            AppMethodBeat.m2504i(85656);
            XWalkInitializer.this.mInitListener.onXWalkInitFailed();
            AppMethodBeat.m2505o(85656);
        }

        public void onActivateCompleted() {
            AppMethodBeat.m2504i(85657);
            XWalkInitializer.this.mIsXWalkReady = true;
            XWalkLibraryLoader.finishInit(XWalkInitializer.this.mContext);
            XWalkInitializer.this.mInitListener.onXWalkInitCompleted();
            AppMethodBeat.m2505o(85657);
        }
    }

    public XWalkInitializer(XWalkInitListener xWalkInitListener, Context context) {
        AppMethodBeat.m2504i(85658);
        this.mInitListener = xWalkInitListener;
        this.mContext = context;
        XWalkLibraryLoader.prepareToInit(this.mContext);
        AppMethodBeat.m2505o(85658);
    }

    public boolean initAsync_remove() {
        AppMethodBeat.m2504i(85659);
        if (this.mIsXWalkReady) {
            AppMethodBeat.m2505o(85659);
            return false;
        } else if (XWalkLibraryLoader.isInitializing() || XWalkLibraryLoader.isDownloading()) {
            Log.m81049i(TAG, "Other initialization or download is proceeding");
            AppMethodBeat.m2505o(85659);
            return false;
        } else {
            Log.m81049i(TAG, "Initialized by XWalkInitializer");
            this.mInitListener.onXWalkInitStarted();
            AppMethodBeat.m2505o(85659);
            return true;
        }
    }

    public static void addXWalkInitializeLog(String str, String str2) {
        AppMethodBeat.m2504i(85660);
        XWalkEnvironment.addXWalkInitializeLog(str, str2);
        AppMethodBeat.m2505o(85660);
    }

    public static void addXWalkInitializeLog(String str) {
        AppMethodBeat.m2504i(85661);
        XWalkEnvironment.addXWalkInitializeLog(str);
        AppMethodBeat.m2505o(85661);
    }

    public static String getXWalkInitializeLog() {
        AppMethodBeat.m2504i(85662);
        SharedPreferences sharedPreferencesForLog = XWalkEnvironment.getSharedPreferencesForLog();
        String str;
        if (sharedPreferencesForLog == null) {
            str = "";
            AppMethodBeat.m2505o(85662);
            return str;
        }
        str = sharedPreferencesForLog.getString("log", "");
        AppMethodBeat.m2505o(85662);
        return str;
    }

    public boolean tryInitSync() {
        AppMethodBeat.m2504i(85663);
        if (XWalkEnvironment.hasAvailableVersion()) {
            if (XWalkCoreWrapper.attachXWalkCore(XWalkEnvironment.getAvailableVersion()) == 1) {
                XWalkCoreWrapper.dockXWalkCore();
                XWalkCoreWrapper.getInstance().initNotifyChannnel();
                RuntimeToSdkChannel.initRuntimeToSdkChannel();
                this.mIsXWalkReady = true;
                XWalkLibraryLoader.finishInit(this.mContext);
                this.mInitListener.onXWalkInitCompleted();
                AppMethodBeat.m2505o(85663);
                return true;
            }
            AppMethodBeat.m2505o(85663);
            return false;
        }
        if (XWalkEnvironment.getAvailableVersion() == -1) {
            addXWalkInitializeLog("no available version ,need download");
        } else {
            addXWalkInitializeLog("sdk not support this apk, need update new");
        }
        AppMethodBeat.m2505o(85663);
        return false;
    }

    public boolean isXWalkReady() {
        return this.mIsXWalkReady;
    }

    public boolean isSharedMode() {
        AppMethodBeat.m2504i(85664);
        if (this.mIsXWalkReady && XWalkLibraryLoader.isSharedLibrary()) {
            AppMethodBeat.m2505o(85664);
            return true;
        }
        AppMethodBeat.m2505o(85664);
        return false;
    }

    public boolean isDownloadMode() {
        AppMethodBeat.m2504i(85665);
        if (this.mIsXWalkReady && XWalkEnvironment.isDownloadMode()) {
            AppMethodBeat.m2505o(85665);
            return true;
        }
        AppMethodBeat.m2505o(85665);
        return false;
    }
}
