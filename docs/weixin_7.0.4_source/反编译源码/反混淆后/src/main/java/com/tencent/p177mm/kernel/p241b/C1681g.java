package com.tencent.p177mm.kernel.p241b;

import android.app.Application;
import com.tencent.p177mm.kernel.p238a.C1651a;

/* renamed from: com.tencent.mm.kernel.b.g */
public abstract class C1681g {
    /* renamed from: cc */
    public Application f1233cc;
    public String eHT;
    public C1651a eJE;
    private Boolean eMo;
    public C1680a eMp = new C1680a();

    /* renamed from: com.tencent.mm.kernel.b.g$a */
    public static class C1680a {
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

    public C1681g(String str, Application application) {
        this.eHT = str;
        this.eJE = new C1651a();
        this.f1233cc = application;
    }

    /* renamed from: SF */
    public final C1680a mo5180SF() {
        return this.eMp;
    }

    public String toString() {
        return this.eHT != null ? this.eHT : super.toString();
    }

    /* renamed from: SG */
    public final boolean mo5181SG() {
        if (this.eMo == null) {
            this.eMo = Boolean.valueOf(mo5183lQ(""));
        }
        return this.eMo.booleanValue();
    }

    /* renamed from: lQ */
    public final boolean mo5183lQ(String str) {
        return this.eHT != null && this.eHT.equals(getPackageName() + str);
    }
}
