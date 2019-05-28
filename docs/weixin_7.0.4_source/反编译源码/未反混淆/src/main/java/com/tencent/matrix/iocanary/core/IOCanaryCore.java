package com.tencent.matrix.iocanary.core;

import com.tencent.matrix.c.b;
import com.tencent.matrix.c.c.a;
import com.tencent.matrix.d.c;
import java.util.List;

public class IOCanaryCore implements a, OnJniIssuePublishListener {
    static final /* synthetic */ boolean $assertionsDisabled = (!IOCanaryCore.class.desiredAssertionStatus());
    private static final String TAG = "Matrix.IOCanaryCore";
    private com.tencent.matrix.iocanary.b.a mCloseGuardHooker;
    private final com.tencent.matrix.iocanary.a.a mIOConfig;
    private final com.tencent.matrix.iocanary.a mIoCanaryPlugin;
    private boolean mIsStart;

    public IOCanaryCore(com.tencent.matrix.iocanary.a aVar) {
        this.mIOConfig = aVar.mIOConfig;
        this.mIoCanaryPlugin = aVar;
    }

    public void start() {
        initDetectorsAndHookers(this.mIOConfig);
        synchronized (this) {
            this.mIsStart = true;
        }
    }

    public synchronized boolean isStart() {
        return this.mIsStart;
    }

    public void stop() {
        synchronized (this) {
            this.mIsStart = false;
        }
        if (this.mCloseGuardHooker != null) {
            com.tencent.matrix.iocanary.b.a aVar = this.mCloseGuardHooker;
            c.i("Matrix.CloseGuardHooker", "unHook unHookRet=%b", Boolean.valueOf(com.tencent.matrix.iocanary.b.a.zg()));
            aVar.bWk = false;
        }
        IOCanaryJniBridge.uninstall();
    }

    public void onDetectIssue(b bVar) {
        this.mIoCanaryPlugin.onDetectIssue(bVar);
    }

    private void initDetectorsAndHookers(com.tencent.matrix.iocanary.a.a aVar) {
        if ($assertionsDisabled || aVar != null) {
            if (aVar.zb() || aVar.zd() || aVar.zc()) {
                IOCanaryJniBridge.install(aVar, this);
            }
            if (aVar.ze()) {
                this.mCloseGuardHooker = new com.tencent.matrix.iocanary.b.a(this);
                com.tencent.matrix.iocanary.b.a aVar2 = this.mCloseGuardHooker;
                c.i("Matrix.CloseGuardHooker", "hook sIsTryHook=%b", Boolean.valueOf(aVar2.bWk));
                if (!aVar2.bWk) {
                    c.i("Matrix.CloseGuardHooker", "hook hookRet=%b", Boolean.valueOf(aVar2.zf()));
                    aVar2.bWk = true;
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public void onIssuePublish(List<IOIssue> list) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    this.mIoCanaryPlugin.onDetectIssue(com.tencent.matrix.iocanary.c.a.a((IOIssue) list.get(i2)));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
