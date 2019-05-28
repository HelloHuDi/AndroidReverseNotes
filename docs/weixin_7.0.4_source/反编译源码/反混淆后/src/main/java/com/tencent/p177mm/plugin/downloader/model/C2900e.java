package com.tencent.p177mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.downloader.model.e */
public final class C2900e {
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

    /* renamed from: com.tencent.mm.plugin.downloader.model.e$a */
    public static final class C2901a {
        public C2900e kNl = new C2900e();

        public C2901a() {
            AppMethodBeat.m2504i(2441);
            AppMethodBeat.m2505o(2441);
        }

        /* renamed from: It */
        public final void mo7055It(String str) {
            this.kNl.gUx = str;
        }

        /* renamed from: Iu */
        public final void mo7056Iu(String str) {
            this.kNl.kMZ = str;
        }

        /* renamed from: hA */
        public final void mo7066hA(long j) {
            this.kNl.mFileSize = j;
        }

        /* renamed from: Iv */
        public final void mo7057Iv(String str) {
            this.kNl.mFileName = str;
        }

        /* renamed from: Iw */
        public final void mo7058Iw(String str) {
            this.kNl.kNa = str;
        }

        public final void setAppId(String str) {
            this.kNl.mAppId = str;
        }

        /* renamed from: tN */
        public final void mo7069tN(int i) {
            this.kNl.kNb = i;
        }

        /* renamed from: ga */
        public final void mo7063ga(boolean z) {
            this.kNl.kNc = z;
        }

        /* renamed from: gb */
        public final void mo7064gb(boolean z) {
            this.kNl.hzG = z;
        }

        /* renamed from: cY */
        public final void mo7062cY(String str) {
            this.kNl.mPackageName = str;
        }

        public final void bir() {
            this.kNl.kNe = true;
        }

        public final void setScene(int i) {
            this.kNl.gOW = i;
        }

        /* renamed from: gc */
        public final void mo7065gc(boolean z) {
            this.kNl.hyG = z;
        }

        /* renamed from: Ix */
        public final void mo7059Ix(String str) {
            this.kNl.hxK = str;
        }

        public final void bis() {
            this.kNl.kNj = true;
        }
    }

    /* synthetic */ C2900e(byte b) {
        this();
    }

    private C2900e() {
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
