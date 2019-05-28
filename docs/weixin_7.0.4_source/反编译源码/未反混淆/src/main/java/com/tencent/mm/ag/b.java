package com.tencent.mm.ag;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
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
    public e fqV;
    public boolean fqW = false;
    public boolean fqX = false;
    public int fromScene = 0;
    public String processName = "";
    public int startTime = 0;

    public final boolean e(b bVar) {
        AppMethodBeat.i(137228);
        if (bVar == null) {
            AppMethodBeat.o(137228);
            return false;
        } else if (this.ckD == null || !this.ckD.equalsIgnoreCase(bVar.ckD) || this.clP == null || !this.clP.equalsIgnoreCase(bVar.clP)) {
            AppMethodBeat.o(137228);
            return false;
        } else {
            AppMethodBeat.o(137228);
            return true;
        }
    }

    public final void f(b bVar) {
        AppMethodBeat.i(137229);
        this.ckD = bVar.ckD;
        this.clP = bVar.clP;
        if (!TextUtils.isEmpty(bVar.filePath)) {
            this.filePath = bVar.filePath;
        }
        this.startTime = bVar.startTime;
        this.fqJ = bVar.fqJ;
        this.fqK = bVar.fqK;
        this.fqL = bVar.fqL;
        this.fromScene = bVar.fromScene;
        this.processName = bVar.processName;
        this.fqN = bVar.fqN;
        this.appId = bVar.appId;
        if (bVar.fqV != null) {
            this.fqV = bVar.fqV;
        }
        this.fileSize = bVar.fileSize;
        AppMethodBeat.o(137229);
    }
}
