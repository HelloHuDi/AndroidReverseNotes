package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    int gOW;
    public String gUx;
    String hxK;
    public boolean hyG;
    boolean hzG;
    String kMZ;
    String kNa;
    int kNb;
    public boolean kNc;
    public boolean kNd;
    boolean kNe;
    private boolean kNf;
    public boolean kNg;
    public boolean kNh;
    boolean kNi;
    boolean kNj;
    private boolean kNk;
    public String mAppId;
    String mFileName;
    long mFileSize;
    String mPackageName;

    public static final class a {
        public e kNl = new e();

        public a() {
            AppMethodBeat.i(2441);
            AppMethodBeat.o(2441);
        }

        public final void It(String str) {
            this.kNl.gUx = str;
        }

        public final void Iu(String str) {
            this.kNl.kMZ = str;
        }

        public final void hA(long j) {
            this.kNl.mFileSize = j;
        }

        public final void Iv(String str) {
            this.kNl.mFileName = str;
        }

        public final void Iw(String str) {
            this.kNl.kNa = str;
        }

        public final void setAppId(String str) {
            this.kNl.mAppId = str;
        }

        public final void tN(int i) {
            this.kNl.kNb = i;
        }

        public final void ga(boolean z) {
            this.kNl.kNc = z;
        }

        public final void gb(boolean z) {
            this.kNl.hzG = z;
        }

        public final void cY(String str) {
            this.kNl.mPackageName = str;
        }

        public final void bir() {
            this.kNl.kNe = true;
        }

        public final void setScene(int i) {
            this.kNl.gOW = i;
        }

        public final void gc(boolean z) {
            this.kNl.hyG = z;
        }

        public final void Ix(String str) {
            this.kNl.hxK = str;
        }

        public final void bis() {
            this.kNl.kNj = true;
        }
    }

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        this.gUx = "";
        this.kMZ = "";
        this.mFileSize = 0;
        this.mFileName = "";
        this.kNa = "";
        this.kNb = 1;
        this.mAppId = "";
        this.mPackageName = "";
        this.kNc = false;
        this.hzG = true;
        this.kNd = false;
        this.kNe = false;
        this.gOW = 0;
        this.kNf = false;
        this.kNg = false;
        this.hyG = false;
        this.kNh = false;
        this.kNi = false;
        this.kNj = false;
        this.kNk = false;
    }
}
