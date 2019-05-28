package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadListenerManager {
    protected static DownloadListenerManager mDownloadListenerManager = null;
    protected final ArrayList<IDownloadManagerListener> mListeners = new ArrayList();

    public static DownloadListenerManager getInstance() {
        AppMethodBeat.m2504i(75728);
        if (mDownloadListenerManager == null) {
            mDownloadListenerManager = new DownloadListenerManager();
        }
        DownloadListenerManager downloadListenerManager = mDownloadListenerManager;
        AppMethodBeat.m2505o(75728);
        return downloadListenerManager;
    }

    protected DownloadListenerManager() {
        AppMethodBeat.m2504i(75729);
        AppMethodBeat.m2505o(75729);
    }

    public synchronized void Add(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.m2504i(75730);
        if (!this.mListeners.contains(iDownloadManagerListener)) {
            this.mListeners.add(iDownloadManagerListener);
        }
        AppMethodBeat.m2505o(75730);
    }

    public synchronized void Remove(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.m2504i(75731);
        this.mListeners.remove(iDownloadManagerListener);
        AppMethodBeat.m2505o(75731);
    }

    public synchronized void OnDownloadStateChanged(String str, int i, int i2, String str2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75732);
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((IDownloadManagerListener) it.next()).OnDownloadStateChanged(str, i, i2, str2, z, z2);
        }
        AppMethodBeat.m2505o(75732);
    }

    public synchronized void OnDownloadProgressChanged(String str, long j, long j2) {
        AppMethodBeat.m2504i(75733);
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((IDownloadManagerListener) it.next()).OnDownloadProgressChanged(str, j, j2);
        }
        AppMethodBeat.m2505o(75733);
    }
}
