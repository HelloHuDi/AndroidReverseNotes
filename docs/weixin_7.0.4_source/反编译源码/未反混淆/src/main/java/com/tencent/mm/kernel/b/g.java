package com.tencent.mm.kernel.b;

import android.app.Application;

public abstract class g {
    public Application cc;
    public String eHT;
    public com.tencent.mm.kernel.a.a eJE;
    private Boolean eMo;
    public a eMp = new a();

    public static class a {
        public long eMq;
        public long eMr;
        public long eMs;
        public long eMt;
        public long eMu;
        public long eMv;
        public long eMw;
        public long eMx;
        public long eMy;
    }

    public abstract String getPackageName();

    public g(String str, Application application) {
        this.eHT = str;
        this.eJE = new com.tencent.mm.kernel.a.a();
        this.cc = application;
    }

    public final a SF() {
        return this.eMp;
    }

    public String toString() {
        return this.eHT != null ? this.eHT : super.toString();
    }

    public final boolean SG() {
        if (this.eMo == null) {
            this.eMo = Boolean.valueOf(lQ(""));
        }
        return this.eMo.booleanValue();
    }

    public final boolean lQ(String str) {
        return this.eHT != null && this.eHT.equals(getPackageName() + str);
    }
}
