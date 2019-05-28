package com.tencent.p177mm.p1176ag;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ag.b */
public final class C17875b {
    public String appId = "";
    public boolean ckA = true;
    public String ckD = "";
    public String clP = "";
    public int csK = 0;
    public String filePath = "";
    public long fileSize = 0;
    public int fqJ = 0;
    public boolean fqK = false;
    public boolean fqL = false;
    public long fqM = 0;
    public double fqN = 1.0d;
    public long fqO = 0;
    public long fqP = 0;
    public long fqQ = 0;
    public long fqR = 0;
    public long fqS = 0;
    public long fqT = 0;
    public long fqU = 0;
    public C45139e fqV;
    public boolean fqW = false;
    public boolean fqX = false;
    public int fromScene = 0;
    public String processName = "";
    public int startTime = 0;

    /* renamed from: e */
    public final boolean mo33376e(C17875b c17875b) {
        AppMethodBeat.m2504i(137228);
        if (c17875b == null) {
            AppMethodBeat.m2505o(137228);
            return false;
        } else if (this.ckD == null || !this.ckD.equalsIgnoreCase(c17875b.ckD) || this.clP == null || !this.clP.equalsIgnoreCase(c17875b.clP)) {
            AppMethodBeat.m2505o(137228);
            return false;
        } else {
            AppMethodBeat.m2505o(137228);
            return true;
        }
    }

    /* renamed from: f */
    public final void mo33377f(C17875b c17875b) {
        AppMethodBeat.m2504i(137229);
        this.ckD = c17875b.ckD;
        this.clP = c17875b.clP;
        if (!TextUtils.isEmpty(c17875b.filePath)) {
            this.filePath = c17875b.filePath;
        }
        this.startTime = c17875b.startTime;
        this.fqJ = c17875b.fqJ;
        this.fqK = c17875b.fqK;
        this.fqL = c17875b.fqL;
        this.fromScene = c17875b.fromScene;
        this.processName = c17875b.processName;
        this.fqN = c17875b.fqN;
        this.appId = c17875b.appId;
        if (c17875b.fqV != null) {
            this.fqV = c17875b.fqV;
        }
        this.fileSize = c17875b.fileSize;
        AppMethodBeat.m2505o(137229);
    }
}
