package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.a */
public abstract class C40429a {
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

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.a$a */
    public static abstract class C14855a<T extends C40429a> {
        protected String cvZ;
        protected long fRS;
        protected int networkType;
        protected int priority;
        protected final String url;
        protected String vdC;
        protected int vdM;

        public C14855a(String str) {
            this.url = str;
        }

        public final C14855a<T> aja(String str) {
            this.vdC = str;
            return this;
        }

        /* renamed from: KG */
        public final C14855a<T> mo27166KG(int i) {
            this.networkType = i;
            return this;
        }

        /* renamed from: md */
        public final C14855a<T> mo27171md(long j) {
            this.fRS = j;
            return this;
        }

        /* renamed from: KH */
        public final C14855a<T> mo27167KH(int i) {
            this.vdM = i;
            return this;
        }

        public final C14855a<T> ajb(String str) {
            this.cvZ = str;
            return this;
        }

        /* renamed from: KI */
        public final C14855a<T> mo27168KI(int i) {
            this.priority = i;
            return this;
        }
    }

    protected C40429a(String str, String str2, String str3, int i, int i2, String str4, long j, String str5, String str6, String str7, int i3) {
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

    public C44049s dih() {
        C44049s c44049s = new C44049s();
        c44049s.field_url = this.url;
        c44049s.field_urlKey = this.vdC;
        c44049s.field_fileVersion = this.veW;
        c44049s.field_networkType = this.networkType;
        c44049s.field_maxRetryTimes = this.vdM;
        c44049s.field_retryTimes = this.fLW;
        c44049s.field_filePath = this.filePath;
        c44049s.field_status = this.status;
        c44049s.field_expireTime = this.fRS;
        c44049s.field_groupId1 = this.veX;
        c44049s.field_groupId2 = this.veY;
        c44049s.field_md5 = this.cvZ;
        c44049s.field_priority = this.priority;
        return c44049s;
    }

    /* Access modifiers changed, original: protected */
    public int aiW(String str) {
        return 0;
    }

    public String toString() {
        return "BaseResDownloadRequest | urlKey='" + this.vdC + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.fRS + ", fileVersion=" + this.veW + ", maxRetryTimes=" + this.vdM + ", md5='" + this.cvZ + '\'' + ", groupId1='" + this.veX + '\'' + ", groupId2='" + this.veY + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.fLW + ", status=" + this.status + ", priority=" + this.priority;
    }
}
