package com.tencent.matrix.resource.p169e;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.resource.analyzer.model.C1097a;
import com.tencent.matrix.resource.p167d.p168a.C1115a;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.matrix.resource.e.c */
public final class C1123c {
    private final C1125d bXU;
    final Context mContext;
    private final Handler mMainHandler;

    /* renamed from: com.tencent.matrix.resource.e.c$a */
    public interface C1122a {
        /* renamed from: a */
        void mo4340a(C1097a c1097a);
    }

    public C1123c(Context context, C1125d c1125d) {
        this(context, c1125d, new Handler(Looper.getMainLooper()));
    }

    private C1123c(Context context, C1125d c1125d, Handler handler) {
        this.mContext = context;
        this.bXU = c1125d;
        this.mMainHandler = handler;
    }

    /* renamed from: zs */
    public final File mo4344zs() {
        File file;
        File zt = this.bXU.mo4346zt();
        if (zt == null) {
            file = null;
        } else {
            UUID randomUUID = UUID.randomUUID();
            file = new File(zt, "dump_" + Long.toHexString(randomUUID.getMostSignificantBits()) + Long.toHexString(randomUUID.getLeastSignificantBits()) + ".hprof");
        }
        if (file == null) {
            C1070c.m2370w("Matrix.AndroidHeapDumper", "hprof file is null.", new Object[0]);
            return null;
        }
        zt = file.getParentFile();
        if (zt == null) {
            C1070c.m2370w("Matrix.AndroidHeapDumper", "hprof file path: %s does not indicate a full path.", file.getAbsolutePath());
            return null;
        } else if (zt.canWrite()) {
            final C1115a c1115a = new C1115a();
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    final Toast toast = new Toast(C1123c.this.mContext);
                    toast.setDuration(1);
                    toast.setGravity(16, 0, 0);
                    toast.setView(LayoutInflater.from(C1123c.this.mContext).inflate(2130970523, null));
                    toast.show();
                    Looper.myQueue().addIdleHandler(new IdleHandler() {
                        public final boolean queueIdle() {
                            C1115a c1115a = c1115a;
                            c1115a.bXP.set(toast);
                            c1115a.bXQ.countDown();
                            return false;
                        }
                    });
                }
            });
            if (c1115a.mo4329a(TimeUnit.SECONDS)) {
                try {
                    Debug.dumpHprofData(file.getAbsolutePath());
                    if (c1115a.bXQ.getCount() > 0) {
                        throw new IllegalStateException("Call wait() and check its result");
                    }
                    final Toast toast = (Toast) c1115a.bXP.get();
                    this.mMainHandler.post(new Runnable() {
                        public final void run() {
                            toast.cancel();
                        }
                    });
                    return file;
                } catch (IOException e) {
                    C1070c.printErrStackTrace("Matrix.AndroidHeapDumper", e, "failed to dump heap into file: %s.", file.getAbsolutePath());
                    return null;
                }
            }
            C1070c.m2370w("Matrix.AndroidHeapDumper", "give up dumping heap, waiting for toast too long.", new Object[0]);
            return null;
        } else {
            C1070c.m2370w("Matrix.AndroidHeapDumper", "hprof file path: %s cannot be written.", file.getAbsolutePath());
            return null;
        }
    }
}
