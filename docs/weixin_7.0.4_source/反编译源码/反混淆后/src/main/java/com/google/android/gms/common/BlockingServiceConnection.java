package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingServiceConnection implements ServiceConnection {
    private boolean zzaj = false;
    private final BlockingQueue<IBinder> zzak = new LinkedBlockingQueue();

    public BlockingServiceConnection() {
        AppMethodBeat.m2504i(89338);
        AppMethodBeat.m2505o(89338);
    }

    public IBinder getService() {
        AppMethodBeat.m2504i(89341);
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (this.zzaj) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot call get on this connection more than once");
            AppMethodBeat.m2505o(89341);
            throw illegalStateException;
        }
        this.zzaj = true;
        IBinder iBinder = (IBinder) this.zzak.take();
        AppMethodBeat.m2505o(89341);
        return iBinder;
    }

    public IBinder getServiceWithTimeout(long j, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(89340);
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.zzaj) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot call get on this connection more than once");
            AppMethodBeat.m2505o(89340);
            throw illegalStateException;
        }
        this.zzaj = true;
        IBinder iBinder = (IBinder) this.zzak.poll(j, timeUnit);
        if (iBinder == null) {
            TimeoutException timeoutException = new TimeoutException("Timed out waiting for the service connection");
            AppMethodBeat.m2505o(89340);
            throw timeoutException;
        }
        AppMethodBeat.m2505o(89340);
        return iBinder;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.m2504i(89339);
        this.zzak.add(iBinder);
        AppMethodBeat.m2505o(89339);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
