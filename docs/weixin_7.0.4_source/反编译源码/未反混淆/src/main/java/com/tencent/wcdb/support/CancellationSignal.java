package com.tencent.wcdb.support;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.ICancellationSignal.Stub;

public final class CancellationSignal {
    private boolean mCancelInProgress;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;
    private ICancellationSignal mRemote;

    public interface OnCancelListener {
        void onCancel();
    }

    static final class Transport extends Stub {
        final CancellationSignal mCancellationSignal;

        private Transport() {
            AppMethodBeat.i(12689);
            this.mCancellationSignal = new CancellationSignal();
            AppMethodBeat.o(12689);
        }

        public final void cancel() {
            AppMethodBeat.i(12690);
            this.mCancellationSignal.cancel();
            AppMethodBeat.o(12690);
        }
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    public final void throwIfCanceled() {
        AppMethodBeat.i(12691);
        if (isCanceled()) {
            OperationCanceledException operationCanceledException = new OperationCanceledException();
            AppMethodBeat.o(12691);
            throw operationCanceledException;
        }
        AppMethodBeat.o(12691);
    }

    /* JADX WARNING: Missing block: B:10:0x001a, code skipped:
            if (r0 == null) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:?, code skipped:
            r0.onCancel();
     */
    /* JADX WARNING: Missing block: B:13:0x001f, code skipped:
            if (r1 == null) goto L_0x0024;
     */
    /* JADX WARNING: Missing block: B:15:?, code skipped:
            r1.cancel();
     */
    /* JADX WARNING: Missing block: B:30:0x003d, code skipped:
            monitor-enter(r3);
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            r3.mCancelInProgress = false;
            notifyAll();
     */
    /* JADX WARNING: Missing block: B:37:0x004b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12692);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancel() {
        AppMethodBeat.i(12692);
        synchronized (this) {
            try {
                if (this.mIsCanceled) {
                } else {
                    this.mIsCanceled = true;
                    this.mCancelInProgress = true;
                    OnCancelListener onCancelListener = this.mOnCancelListener;
                    ICancellationSignal iCancellationSignal = this.mRemote;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12692);
            }
        }
        return;
        synchronized (this) {
            try {
                this.mCancelInProgress = false;
                notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12692);
            }
        }
    }

    /* JADX WARNING: Missing block: B:11:0x001b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12693);
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        AppMethodBeat.i(12693);
        synchronized (this) {
            try {
                waitForCancelFinishedLocked();
                if (this.mOnCancelListener == onCancelListener) {
                } else {
                    this.mOnCancelListener = onCancelListener;
                    if (!this.mIsCanceled || onCancelListener == null) {
                    } else {
                        onCancelListener.onCancel();
                        AppMethodBeat.o(12693);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12693);
            }
        }
    }

    /* JADX WARNING: Missing block: B:11:0x001b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12694);
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRemote(ICancellationSignal iCancellationSignal) {
        AppMethodBeat.i(12694);
        synchronized (this) {
            try {
                waitForCancelFinishedLocked();
                if (this.mRemote == iCancellationSignal) {
                } else {
                    this.mRemote = iCancellationSignal;
                    if (!this.mIsCanceled || iCancellationSignal == null) {
                    } else {
                        try {
                            iCancellationSignal.cancel();
                            AppMethodBeat.o(12694);
                        } catch (RemoteException e) {
                            AppMethodBeat.o(12694);
                        }
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(12694);
            }
        }
    }

    private void waitForCancelFinishedLocked() {
        AppMethodBeat.i(12695);
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        AppMethodBeat.o(12695);
    }

    public static ICancellationSignal createTransport() {
        AppMethodBeat.i(12696);
        Transport transport = new Transport();
        AppMethodBeat.o(12696);
        return transport;
    }

    public static CancellationSignal fromTransport(ICancellationSignal iCancellationSignal) {
        if (iCancellationSignal instanceof Transport) {
            return ((Transport) iCancellationSignal).mCancellationSignal;
        }
        return null;
    }
}
