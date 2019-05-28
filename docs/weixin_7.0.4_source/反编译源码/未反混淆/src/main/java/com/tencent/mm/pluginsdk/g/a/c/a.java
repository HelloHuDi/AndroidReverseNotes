package com.tencent.mm.pluginsdk.g.a.c;

public abstract class a {
    public final String cvZ;
    private volatile int fLW;
    private final long fRS;
    private final String filePath;
    public final int networkType;
    public final int priority;
    protected volatile int status = 0;
    public final String url;
    public final String vdC;
    public final int vdM;
    public final String veW;
    private final String veX;
    private final String veY;

    public static abstract class a<T extends a> {
        protected String cvZ;
        protected long fRS;
        protected int networkType;
        protected int priority;
        protected final String url;
        protected String vdC;
        protected int vdM;

        public a(String str) {
            this.url = str;
        }

        public final a<T> aja(String str) {
            this.vdC = str;
            return this;
        }

        public final a<T> KG(int i) {
            this.networkType = i;
            return this;
        }

        public final a<T> md(long j) {
            this.fRS = j;
            return this;
        }

        public final a<T> KH(int i) {
            this.vdM = i;
            return this;
        }

        public final a<T> ajb(String str) {
            this.cvZ = str;
            return this;
        }

        public final a<T> KI(int i) {
            this.priority = i;
            return this;
        }
    }

    protected a(String str, String str2, String str3, int i, int i2, String str4, long j, String str5, String str6, String str7, int i3) {
        this.url = str;
        this.vdC = str2;
        this.veW = str3;
        this.networkType = i;
        this.vdM = i2;
        this.fLW = this.vdM;
        this.filePath = str4;
        this.fRS = j;
        this.veX = str6;
        this.veY = str7;
        this.cvZ = str5;
        this.priority = i3;
    }

    public s dih() {
        s sVar = new s();
        sVar.field_url = this.url;
        sVar.field_urlKey = this.vdC;
        sVar.field_fileVersion = this.veW;
        sVar.field_networkType = this.networkType;
        sVar.field_maxRetryTimes = this.vdM;
        sVar.field_retryTimes = this.fLW;
        sVar.field_filePath = this.filePath;
        sVar.field_status = this.status;
        sVar.field_expireTime = this.fRS;
        sVar.field_groupId1 = this.veX;
        sVar.field_groupId2 = this.veY;
        sVar.field_md5 = this.cvZ;
        sVar.field_priority = this.priority;
        return sVar;
    }

    /* Access modifiers changed, original: protected */
    public int aiW(String str) {
        return 0;
    }

    public String toString() {
        return "BaseResDownloadRequest | urlKey='" + this.vdC + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.fRS + ", fileVersion=" + this.veW + ", maxRetryTimes=" + this.vdM + ", md5='" + this.cvZ + '\'' + ", groupId1='" + this.veX + '\'' + ", groupId2='" + this.veY + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.fLW + ", status=" + this.status + ", priority=" + this.priority;
    }
}
