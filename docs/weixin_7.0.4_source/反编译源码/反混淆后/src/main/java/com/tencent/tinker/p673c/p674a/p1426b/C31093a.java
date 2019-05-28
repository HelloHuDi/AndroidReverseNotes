package com.tencent.tinker.p673c.p674a.p1426b;

import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;
import com.tencent.tinker.p668a.p669a.p670b.C5911d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.tencent.tinker.c.a.b.a */
public final class C31093a {
    public static final byte[] jrm = new byte[]{(byte) 68, (byte) 88, (byte) 68, (byte) 73, (byte) 70, (byte) 70};
    public int AAA;
    public int AAB;
    public int AAD;
    public int AAE;
    public byte[] AAF;
    public final C46943a AAj;
    private short AAk;
    public int AAl;
    private int AAm;
    public int AAn;
    public int AAo;
    public int AAp;
    public int AAq;
    public int AAr;
    public int AAs;
    public int AAt;
    public int AAu;
    public int AAv;
    public int AAw;
    public int AAx;
    public int AAy;
    public int AAz;

    public C31093a(InputStream inputStream) {
        this.AAj = new C46943a(ByteBuffer.wrap(C5911d.m9198y(inputStream)));
        byte[] Rr = this.AAj.mo76206Rr(jrm.length);
        if (C5910c.m9196o(Rr, jrm) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(Rr));
        }
        this.AAk = this.AAj.aEY.getShort();
        if (C5910c.m9192b(this.AAk, (short) 2) != 0) {
            throw new IllegalStateException("bad dex patch file version: " + this.AAk + ", expected: 2");
        }
        this.AAl = this.AAj.aEY.getInt();
        this.AAm = this.AAj.aEY.getInt();
        this.AAn = this.AAj.aEY.getInt();
        this.AAo = this.AAj.aEY.getInt();
        this.AAp = this.AAj.aEY.getInt();
        this.AAq = this.AAj.aEY.getInt();
        this.AAr = this.AAj.aEY.getInt();
        this.AAs = this.AAj.aEY.getInt();
        this.AAt = this.AAj.aEY.getInt();
        this.AAu = this.AAj.aEY.getInt();
        this.AAv = this.AAj.aEY.getInt();
        this.AAw = this.AAj.aEY.getInt();
        this.AAx = this.AAj.aEY.getInt();
        this.AAy = this.AAj.aEY.getInt();
        this.AAz = this.AAj.aEY.getInt();
        this.AAA = this.AAj.aEY.getInt();
        this.AAB = this.AAj.aEY.getInt();
        this.AAD = this.AAj.aEY.getInt();
        this.AAE = this.AAj.aEY.getInt();
        this.AAF = this.AAj.mo76206Rr(20);
        C46943a c46943a = this.AAj;
        c46943a.aEY.position(this.AAm);
    }
}
