package com.tencent.tinker.p673c.p674a;

import com.tencent.tinker.p668a.p669a.C16311d;
import com.tencent.tinker.p668a.p669a.C16312f;
import com.tencent.tinker.p668a.p669a.C16313g;
import com.tencent.tinker.p668a.p669a.C16317p;
import com.tencent.tinker.p668a.p669a.C31088u;
import com.tencent.tinker.p668a.p669a.C36542h;
import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t;
import com.tencent.tinker.p668a.p669a.C41358b;
import com.tencent.tinker.p668a.p669a.C41359r;
import com.tencent.tinker.p668a.p669a.C44545k;
import com.tencent.tinker.p668a.p669a.C44546s;
import com.tencent.tinker.p668a.p669a.C46808a;
import com.tencent.tinker.p668a.p669a.C46810c;
import com.tencent.tinker.p668a.p669a.C5914e;
import com.tencent.tinker.p668a.p669a.C5916n;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C16321m;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C16322o;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C24429d;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C24430e;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C24431f;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C31090g;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C31091n;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C31092p;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C41084a;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C41085h;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C41086j;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C44550b;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C44551c;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C44552l;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C46815i;
import com.tencent.tinker.p673c.p674a.p1110a.p1111a.C46944k;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* renamed from: com.tencent.tinker.c.a.a */
public final class C5918a {
    private C46815i<C46808a> AzA;
    private C46815i<C44545k> AzB;
    private C46815i<C16311d> AzC;
    private final C36543i Azk;
    private final C36543i Azl;
    private final C31093a Azm;
    private final C7392c Azn;
    private C46815i<C44546s> Azo;
    private C46815i<Integer> Azp;
    private C46815i<C41359r> Azq;
    private C46815i<C5916n> Azr;
    private C46815i<C16317p> Azs;
    private C46815i<C16312f> Azt;
    private C46815i<C31088u> Azu;
    private C46815i<C46810c> Azv;
    private C46815i<C41358b> Azw;
    private C46815i<C5914e> Azx;
    private C46815i<C16313g> Azy;
    private C46815i<C36542h> Azz;

    public C5918a(InputStream inputStream, InputStream inputStream2) {
        this(new C36543i(inputStream), new C31093a(inputStream2));
    }

    private C5918a(C36543i c36543i, C31093a c31093a) {
        this.Azk = c36543i;
        this.Azm = c31093a;
        this.Azl = new C36543i(c31093a.AAl);
        this.Azn = new C7392c();
    }

    /* renamed from: b */
    public final void mo12570b(OutputStream outputStream) {
        int i = 0;
        byte[] rs = this.Azk.mo57800rs(false);
        if (rs == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.Azm == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            if (C5910c.m9196o(rs, this.Azm.AAF) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(rs), Arrays.toString(this.Azm.AAF)}));
            }
            int i2;
            C41083t c41083t = this.Azl.AxY;
            c41083t.Ays.off = 0;
            c41083t.Ays.size = 1;
            c41083t.Ayz.size = 1;
            c41083t.Ayt.off = this.Azm.AAn;
            c41083t.Ayu.off = this.Azm.AAo;
            c41083t.AyA.off = this.Azm.AAu;
            c41083t.Ayv.off = this.Azm.AAp;
            c41083t.Ayw.off = this.Azm.AAq;
            c41083t.Ayx.off = this.Azm.AAr;
            c41083t.Ayy.off = this.Azm.AAs;
            c41083t.Ayz.off = this.Azm.AAt;
            c41083t.AyF.off = this.Azm.AAz;
            c41083t.AyH.off = this.Azm.AAB;
            c41083t.AyC.off = this.Azm.AAw;
            c41083t.AyB.off = this.Azm.AAv;
            c41083t.AyJ.off = this.Azm.AAE;
            c41083t.AyI.off = this.Azm.AAD;
            c41083t.AyG.off = this.Azm.AAA;
            c41083t.AyE.off = this.Azm.AAy;
            c41083t.AyD.off = this.Azm.AAx;
            c41083t.fileSize = this.Azm.AAl;
            Arrays.sort(c41083t.AyK);
            c41083t.dRV();
            this.Azo = new C31091n(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azp = new C16322o(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azq = new C44552l(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azr = new C41086j(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azs = new C46944k(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azt = new C24431f(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azu = new C31092p(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azv = new C44550b(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azw = new C44551c(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azx = new C24430e(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azy = new C31090g(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azz = new C41085h(this.Azm, this.Azk, this.Azl, this.Azn);
            this.AzA = new C41084a(this.Azm, this.Azk, this.Azl, this.Azn);
            this.AzB = new C16321m(this.Azm, this.Azk, this.Azl, this.Azn);
            this.AzC = new C24429d(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azo.execute();
            this.Azp.execute();
            this.Azu.execute();
            this.Azq.execute();
            this.Azr.execute();
            this.Azs.execute();
            this.AzA.execute();
            this.Azw.execute();
            this.Azv.execute();
            this.AzC.execute();
            this.Azz.execute();
            this.Azy.execute();
            this.Azx.execute();
            this.AzB.execute();
            this.Azt.execute();
            C36544e Rm = this.Azl.mo57796Rm(c41083t.Ays.off);
            Rm.write(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
            Rm.writeInt(c41083t.gai);
            Rm.write(c41083t.nTL);
            Rm.writeInt(c41083t.fileSize);
            Rm.writeInt(112);
            Rm.writeInt(305419896);
            Rm.writeInt(c41083t.AyL);
            Rm.writeInt(c41083t.AyM);
            Rm.writeInt(c41083t.Ayz.off);
            Rm.writeInt(c41083t.Ayt.size);
            Rm.writeInt(c41083t.Ayt.exists() ? c41083t.Ayt.off : 0);
            Rm.writeInt(c41083t.Ayu.size);
            if (c41083t.Ayu.exists()) {
                i2 = c41083t.Ayu.off;
            } else {
                i2 = 0;
            }
            Rm.writeInt(i2);
            Rm.writeInt(c41083t.Ayv.size);
            if (c41083t.Ayv.exists()) {
                i2 = c41083t.Ayv.off;
            } else {
                i2 = 0;
            }
            Rm.writeInt(i2);
            Rm.writeInt(c41083t.Ayw.size);
            if (c41083t.Ayw.exists()) {
                i2 = c41083t.Ayw.off;
            } else {
                i2 = 0;
            }
            Rm.writeInt(i2);
            Rm.writeInt(c41083t.Ayx.size);
            if (c41083t.Ayx.exists()) {
                i2 = c41083t.Ayx.off;
            } else {
                i2 = 0;
            }
            Rm.writeInt(i2);
            Rm.writeInt(c41083t.Ayy.size);
            if (c41083t.Ayy.exists()) {
                i = c41083t.Ayy.off;
            }
            Rm.writeInt(i);
            Rm.writeInt(c41083t.lgV);
            Rm.writeInt(c41083t.AyN);
            c41083t.mo65176b(this.Azl.mo57796Rm(c41083t.Ayz.off));
            this.Azl.dRw();
            outputStream.write(this.Azl.aEY.array());
            outputStream.flush();
        }
    }
}
