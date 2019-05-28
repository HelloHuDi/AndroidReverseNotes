package com.tencent.tinker.c.a;

import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.a.a.i;
import com.tencent.tinker.c.a.a.a.j;
import com.tencent.tinker.c.a.a.a.l;
import com.tencent.tinker.c.a.a.a.m;
import com.tencent.tinker.c.a.a.a.o;
import com.tencent.tinker.c.a.c.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class a {
    private i<com.tencent.tinker.a.a.a> AzA;
    private i<k> AzB;
    private i<d> AzC;
    private final com.tencent.tinker.a.a.i Azk;
    private final com.tencent.tinker.a.a.i Azl;
    private final com.tencent.tinker.c.a.b.a Azm;
    private final c Azn;
    private i<s> Azo;
    private i<Integer> Azp;
    private i<r> Azq;
    private i<n> Azr;
    private i<p> Azs;
    private i<f> Azt;
    private i<u> Azu;
    private i<com.tencent.tinker.a.a.c> Azv;
    private i<b> Azw;
    private i<e> Azx;
    private i<g> Azy;
    private i<h> Azz;

    public a(InputStream inputStream, InputStream inputStream2) {
        this(new com.tencent.tinker.a.a.i(inputStream), new com.tencent.tinker.c.a.b.a(inputStream2));
    }

    private a(com.tencent.tinker.a.a.i iVar, com.tencent.tinker.c.a.b.a aVar) {
        this.Azk = iVar;
        this.Azm = aVar;
        this.Azl = new com.tencent.tinker.a.a.i(aVar.AAl);
        this.Azn = new c();
    }

    public final void b(OutputStream outputStream) {
        int i = 0;
        byte[] rs = this.Azk.rs(false);
        if (rs == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.Azm == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            if (com.tencent.tinker.a.a.b.c.o(rs, this.Azm.AAF) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(rs), Arrays.toString(this.Azm.AAF)}));
            }
            int i2;
            t tVar = this.Azl.AxY;
            tVar.Ays.off = 0;
            tVar.Ays.size = 1;
            tVar.Ayz.size = 1;
            tVar.Ayt.off = this.Azm.AAn;
            tVar.Ayu.off = this.Azm.AAo;
            tVar.AyA.off = this.Azm.AAu;
            tVar.Ayv.off = this.Azm.AAp;
            tVar.Ayw.off = this.Azm.AAq;
            tVar.Ayx.off = this.Azm.AAr;
            tVar.Ayy.off = this.Azm.AAs;
            tVar.Ayz.off = this.Azm.AAt;
            tVar.AyF.off = this.Azm.AAz;
            tVar.AyH.off = this.Azm.AAB;
            tVar.AyC.off = this.Azm.AAw;
            tVar.AyB.off = this.Azm.AAv;
            tVar.AyJ.off = this.Azm.AAE;
            tVar.AyI.off = this.Azm.AAD;
            tVar.AyG.off = this.Azm.AAA;
            tVar.AyE.off = this.Azm.AAy;
            tVar.AyD.off = this.Azm.AAx;
            tVar.fileSize = this.Azm.AAl;
            Arrays.sort(tVar.AyK);
            tVar.dRV();
            this.Azo = new com.tencent.tinker.c.a.a.a.n(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azp = new o(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azq = new l(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azr = new j(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azs = new com.tencent.tinker.c.a.a.a.k(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azt = new com.tencent.tinker.c.a.a.a.f(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azu = new com.tencent.tinker.c.a.a.a.p(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azv = new com.tencent.tinker.c.a.a.a.b(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azw = new com.tencent.tinker.c.a.a.a.c(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azx = new com.tencent.tinker.c.a.a.a.e(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azy = new com.tencent.tinker.c.a.a.a.g(this.Azm, this.Azk, this.Azl, this.Azn);
            this.Azz = new com.tencent.tinker.c.a.a.a.h(this.Azm, this.Azk, this.Azl, this.Azn);
            this.AzA = new com.tencent.tinker.c.a.a.a.a(this.Azm, this.Azk, this.Azl, this.Azn);
            this.AzB = new m(this.Azm, this.Azk, this.Azl, this.Azn);
            this.AzC = new com.tencent.tinker.c.a.a.a.d(this.Azm, this.Azk, this.Azl, this.Azn);
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
            com.tencent.tinker.a.a.i.e Rm = this.Azl.Rm(tVar.Ays.off);
            Rm.write(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
            Rm.writeInt(tVar.gai);
            Rm.write(tVar.nTL);
            Rm.writeInt(tVar.fileSize);
            Rm.writeInt(112);
            Rm.writeInt(305419896);
            Rm.writeInt(tVar.AyL);
            Rm.writeInt(tVar.AyM);
            Rm.writeInt(tVar.Ayz.off);
            Rm.writeInt(tVar.Ayt.size);
            Rm.writeInt(tVar.Ayt.exists() ? tVar.Ayt.off : 0);
            Rm.writeInt(tVar.Ayu.size);
            if (tVar.Ayu.exists()) {
                i2 = tVar.Ayu.off;
            } else {
                i2 = 0;
            }
            Rm.writeInt(i2);
            Rm.writeInt(tVar.Ayv.size);
            if (tVar.Ayv.exists()) {
                i2 = tVar.Ayv.off;
            } else {
                i2 = 0;
            }
            Rm.writeInt(i2);
            Rm.writeInt(tVar.Ayw.size);
            if (tVar.Ayw.exists()) {
                i2 = tVar.Ayw.off;
            } else {
                i2 = 0;
            }
            Rm.writeInt(i2);
            Rm.writeInt(tVar.Ayx.size);
            if (tVar.Ayx.exists()) {
                i2 = tVar.Ayx.off;
            } else {
                i2 = 0;
            }
            Rm.writeInt(i2);
            Rm.writeInt(tVar.Ayy.size);
            if (tVar.Ayy.exists()) {
                i = tVar.Ayy.off;
            }
            Rm.writeInt(i);
            Rm.writeInt(tVar.lgV);
            Rm.writeInt(tVar.AyN);
            tVar.b(this.Azl.Rm(tVar.Ayz.off));
            this.Azl.dRw();
            outputStream.write(this.Azl.aEY.array());
            outputStream.flush();
        }
    }
}
