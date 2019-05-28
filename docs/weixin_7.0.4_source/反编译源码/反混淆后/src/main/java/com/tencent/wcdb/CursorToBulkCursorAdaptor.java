package com.tencent.wcdb;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements DeathRecipient {
    private static final String TAG = "Cursor";
    private CrossProcessCursor mCursor;
    private CursorWindow mFilledWindow;
    private final Object mLock = new Object();
    private ContentObserverProxy mObserver;
    private final String mProviderName;

    static final class ContentObserverProxy extends ContentObserver {
        protected IContentObserver mRemote;

        public ContentObserverProxy(IContentObserver iContentObserver, DeathRecipient deathRecipient) {
            super(null);
            AppMethodBeat.m2504i(12003);
            this.mRemote = iContentObserver;
            try {
                iContentObserver.asBinder().linkToDeath(deathRecipient, 0);
                AppMethodBeat.m2505o(12003);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(12003);
            }
        }

        public final boolean unlinkToDeath(DeathRecipient deathRecipient) {
            AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_FAILED);
            boolean unlinkToDeath = this.mRemote.asBinder().unlinkToDeath(deathRecipient, 0);
            AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_FAILED);
            return unlinkToDeath;
        }

        public final boolean deliverSelfNotifications() {
            return false;
        }

        public final void onChange(boolean z, Uri uri) {
            AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL);
            try {
                this.mRemote.onChange(z, uri);
                AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL);
            }
        }
    }

    public CursorToBulkCursorAdaptor(Cursor cursor, IContentObserver iContentObserver, String str) {
        AppMethodBeat.m2504i(12006);
        if (cursor instanceof CrossProcessCursor) {
            this.mCursor = (CrossProcessCursor) cursor;
        } else {
            this.mCursor = new CrossProcessCursorWrapper(cursor);
        }
        this.mProviderName = str;
        synchronized (this.mLock) {
            try {
                createAndRegisterObserverProxyLocked(iContentObserver);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12006);
            }
        }
    }

    private void closeFilledWindowLocked() {
        AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_END);
        if (this.mFilledWindow != null) {
            this.mFilledWindow.close();
            this.mFilledWindow = null;
        }
        AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_END);
    }

    private void disposeLocked() {
        AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_INFO_PLAY_BEGIN);
        if (this.mCursor != null) {
            unregisterObserverProxyLocked();
            this.mCursor.close();
            this.mCursor = null;
        }
        closeFilledWindowLocked();
        AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_PLAY_BEGIN);
    }

    private void throwIfCursorIsClosed() {
        AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_INFO_SERVER_REFUSE);
        if (this.mCursor == null) {
            StaleDataException staleDataException = new StaleDataException("Attempted to access a cursor after it has been closed.");
            AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_SERVER_REFUSE);
            throw staleDataException;
        }
        AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_SERVER_REFUSE);
    }

    public final void binderDied() {
        AppMethodBeat.m2504i(12010);
        synchronized (this.mLock) {
            try {
                disposeLocked();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12010);
            }
        }
    }

    public final BulkCursorDescriptor getBulkCursorDescriptor() {
        BulkCursorDescriptor bulkCursorDescriptor;
        AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_CONNECT_FAILED);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                bulkCursorDescriptor = new BulkCursorDescriptor();
                bulkCursorDescriptor.cursor = this;
                bulkCursorDescriptor.columnNames = this.mCursor.getColumnNames();
                bulkCursorDescriptor.wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();
                bulkCursorDescriptor.count = this.mCursor.getCount();
                bulkCursorDescriptor.window = this.mCursor.getWindow();
                if (bulkCursorDescriptor.window != null) {
                    bulkCursorDescriptor.window.acquireReference();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_CONNECT_FAILED);
            }
        }
        return bulkCursorDescriptor;
    }

    public final CursorWindow getWindow(int i) {
        CursorWindow window;
        AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                if (this.mCursor.moveToPosition(i)) {
                    window = this.mCursor.getWindow();
                    if (window != null) {
                        closeFilledWindowLocked();
                    } else {
                        window = this.mFilledWindow;
                        if (window == null) {
                            this.mFilledWindow = new CursorWindow(this.mProviderName);
                            window = this.mFilledWindow;
                        } else if (i < window.getStartPosition() || i >= window.getStartPosition() + window.getNumRows()) {
                            window.clear();
                        }
                        this.mCursor.fillWindow(i, window);
                    }
                    if (window != null) {
                        window.acquireReference();
                    }
                    AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT);
                } else {
                    closeFilledWindowLocked();
                    window = null;
                }
            } finally {
                AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT);
            }
        }
        return window;
    }

    public final void onMove(int i) {
        AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_READ_FAILED);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                this.mCursor.onMove(this.mCursor.getPosition(), i);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_READ_FAILED);
            }
        }
    }

    public final void deactivate() {
        AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_WRITE_FAILED);
        synchronized (this.mLock) {
            try {
                if (this.mCursor != null) {
                    unregisterObserverProxyLocked();
                    this.mCursor.deactivate();
                }
                closeFilledWindowLocked();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_WRITE_FAILED);
            }
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
        synchronized (this.mLock) {
            try {
                disposeLocked();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_NET_RECONNECT);
            }
        }
    }

    public final int requery(IContentObserver iContentObserver) {
        int count;
        Object illegalStateException;
        int i = 12016;
        AppMethodBeat.m2504i(12016);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                closeFilledWindowLocked();
                if (this.mCursor.requery()) {
                    unregisterObserverProxyLocked();
                    createAndRegisterObserverProxyLocked(iContentObserver);
                    count = this.mCursor.getCount();
                    AppMethodBeat.m2505o(12016);
                } else {
                    count = -1;
                }
            } catch (IllegalStateException e) {
                illegalStateException = new IllegalStateException(this.mProviderName + " Requery misuse db, mCursor isClosed:" + this.mCursor.isClosed(), e);
                count = 12016;
                throw illegalStateException;
            } finally {
                AppMethodBeat.m2505o(
/*
Method generation error in method: com.tencent.wcdb.CursorToBulkCursorAdaptor.requery(com.tencent.wcdb.IContentObserver):int, dex: classes7.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004a: INVOKE  (wrap: int
  ?: MERGE  (r5_1 int) = (r5_0 'i' int), (r0_9 'count' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.wcdb.CursorToBulkCursorAdaptor.requery(com.tencent.wcdb.IContentObserver):int, dex: classes7.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r5_1 int) = (r5_0 'i' int), (r0_9 'count' int) in method: com.tencent.wcdb.CursorToBulkCursorAdaptor.requery(com.tencent.wcdb.IContentObserver):int, dex: classes7.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 32 more

*/

    private void createAndRegisterObserverProxyLocked(IContentObserver iContentObserver) {
        AppMethodBeat.m2504i(12017);
        if (this.mObserver != null) {
            IllegalStateException illegalStateException = new IllegalStateException("an observer is already registered");
            AppMethodBeat.m2505o(12017);
            throw illegalStateException;
        }
        this.mObserver = new ContentObserverProxy(iContentObserver, this);
        this.mCursor.registerContentObserver(this.mObserver);
        AppMethodBeat.m2505o(12017);
    }

    private void unregisterObserverProxyLocked() {
        AppMethodBeat.m2504i(12018);
        if (this.mObserver != null) {
            this.mCursor.unregisterContentObserver(this.mObserver);
            this.mObserver.unlinkToDeath(this);
            this.mObserver = null;
        }
        AppMethodBeat.m2505o(12018);
    }

    public final Bundle getExtras() {
        Bundle extras;
        AppMethodBeat.m2504i(12019);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                extras = this.mCursor.getExtras();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12019);
            }
        }
        return extras;
    }

    public final Bundle respond(Bundle bundle) {
        Bundle respond;
        AppMethodBeat.m2504i(12020);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                respond = this.mCursor.respond(bundle);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(12020);
            }
        }
        return respond;
    }
}
