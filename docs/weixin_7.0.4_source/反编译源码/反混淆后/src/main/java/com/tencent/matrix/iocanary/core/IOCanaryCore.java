package com.tencent.matrix.iocanary.core;

import com.tencent.matrix.iocanary.C7463a;
import com.tencent.matrix.iocanary.p158a.C1075a;
import com.tencent.matrix.iocanary.p159b.C1076a;
import com.tencent.matrix.iocanary.p160c.C1080a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p156c.C1064c.C1063a;
import com.tencent.matrix.p157d.C1070c;
import java.util.List;

public class IOCanaryCore implements C1063a, OnJniIssuePublishListener {
    static final /* synthetic */ boolean $assertionsDisabled = (!IOCanaryCore.class.desiredAssertionStatus());
    private static final String TAG = "Matrix.IOCanaryCore";
    private C1076a mCloseGuardHooker;
    private final C1075a mIOConfig;
    private final C7463a mIoCanaryPlugin;
    private boolean mIsStart;

    public IOCanaryCore(C7463a c7463a) {
        this.mIOConfig = c7463a.mIOConfig;
        this.mIoCanaryPlugin = c7463a;
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
            C1076a c1076a = this.mCloseGuardHooker;
            C1070c.m2368i("Matrix.CloseGuardHooker", "unHook unHookRet=%b", Boolean.valueOf(C1076a.m2384zg()));
            c1076a.bWk = false;
        }
        IOCanaryJniBridge.uninstall();
    }

    public void onDetectIssue(C1062b c1062b) {
        this.mIoCanaryPlugin.onDetectIssue(c1062b);
    }

    private void initDetectorsAndHookers(C1075a c1075a) {
        if ($assertionsDisabled || c1075a != null) {
            if (c1075a.mo4212zb() || c1075a.mo4214zd() || c1075a.mo4213zc()) {
                IOCanaryJniBridge.install(c1075a, this);
            }
            if (c1075a.mo4215ze()) {
                this.mCloseGuardHooker = new C1076a(this);
                C1076a c1076a = this.mCloseGuardHooker;
                C1070c.m2368i("Matrix.CloseGuardHooker", "hook sIsTryHook=%b", Boolean.valueOf(c1076a.bWk));
                if (!c1076a.bWk) {
                    C1070c.m2368i("Matrix.CloseGuardHooker", "hook hookRet=%b", Boolean.valueOf(c1076a.mo4216zf()));
                    c1076a.bWk = true;
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
                    this.mIoCanaryPlugin.onDetectIssue(C1080a.m2386a((IOIssue) list.get(i2)));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
