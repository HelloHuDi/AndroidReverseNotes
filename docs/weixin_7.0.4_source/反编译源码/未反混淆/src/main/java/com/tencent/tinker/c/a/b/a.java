package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a {
    public static final byte[] jrm = new byte[]{(byte) 68, (byte) 88, (byte) 68, (byte) 73, (byte) 70, (byte) 70};
    public int AAA;
    public int AAB;
    public int AAD;
    public int AAE;
    public byte[] AAF;
    public final com.tencent.tinker.a.a.a.a AAj;
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

    public a(InputStream inputStream) {
        this.AAj = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.y(inputStream)));
        byte[] Rr = this.AAj.Rr(jrm.length);
        if (c.o(Rr, jrm) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(Rr));
        }
        this.AAk = this.AAj.aEY.getShort();
        if (c.b(this.AAk, (short) 2) != 0) {
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
        this.AAF = this.AAj.Rr(20);
        com.tencent.tinker.a.a.a.a aVar = this.AAj;
        aVar.aEY.position(this.AAm);
    }
}
