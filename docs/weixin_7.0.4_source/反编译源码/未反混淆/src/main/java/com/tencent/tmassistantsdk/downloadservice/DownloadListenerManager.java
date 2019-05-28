package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadListenerManager {
    protected static DownloadListenerManager mDownloadListenerManager = null;
    protected final ArrayList<IDownloadManagerListener> mListeners = new ArrayList();

    public static DownloadListenerManager getInstance() {
        AppMethodBeat.i(75728);
        if (mDownloadListenerManager == null) {
            mDownloadListenerManager = new DownloadListenerManager();
        }
        DownloadListenerManager downloadListenerManager = mDownloadListenerManager;
        AppMethodBeat.o(75728);
        return downloadListenerManager;
    }

    protected DownloadListenerManager() {
        AppMethodBeat.i(75729);
        AppMethodBeat.o(75729);
    }

    public synchronized void Add(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.i(75730);
        if (!this.mListeners.contains(iDownloadManagerListener)) {
            this.mListeners.add(iDownloadManagerListener);
        }
        AppMethodBeat.o(75730);
    }

    public synchronized void Remove(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.i(75731);
        this.mListeners.remove(iDownloadManagerListener);
        AppMethodBeat.o(75731);
    }

    public synchronized void OnDownloadStateChanged(String str, int i, int i2, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(75732);
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((IDownloadManagerListener) it.next()).OnDownloadStateChanged(str, i, i2, str2, z, z2);
        }
        AppMethodBeat.o(75732);
    }

    public synchronized void OnDownloadProgressChanged(String str, long j, long j2) {
        AppMethodBeat.i(75733);
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((IDownloadManagerListener) it.next()).OnDownloadProgressChanged(str, j, j2);
        }
        AppMethodBeat.o(75733);
    }
}
