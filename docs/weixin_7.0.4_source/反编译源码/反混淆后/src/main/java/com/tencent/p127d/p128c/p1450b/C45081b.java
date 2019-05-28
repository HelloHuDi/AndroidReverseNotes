package com.tencent.p127d.p128c.p1450b;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.d.c.b.b */
public final class C45081b extends JceStruct {
    static byte[] AsI;
    static byte[] AsJ;
    static ArrayList<Integer> AsK = new ArrayList();
    static ArrayList<byte[]> AsL = new ArrayList();
    public int AsA = 0;
    public int AsB = 0;
    public ArrayList<Integer> AsC = null;
    public int AsD = 0;
    public boolean AsE = false;
    public int AsF = 0;
    public int AsG = 0;
    public ArrayList<byte[]> AsH = null;
    public int Asp = 0;
    public byte[] Asq = null;
    public String Asr = "";
    public byte[] Ass = null;
    public long Ast = 0;
    public String Asu = "";
    public int Asv = 0;
    public String Asw = "";
    public int Asx = 0;
    public String Asy = "";
    public int Asz = 0;

    public final JceStruct newInit() {
        AppMethodBeat.m2504i(114491);
        C45081b c45081b = new C45081b();
        AppMethodBeat.m2505o(114491);
        return c45081b;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114492);
        jceOutputStream.write(this.Asp, 0);
        if (this.Asq != null) {
            jceOutputStream.write(this.Asq, 1);
        }
        if (this.Asr != null) {
            jceOutputStream.write(this.Asr, 2);
        }
        if (this.Ass != null) {
            jceOutputStream.write(this.Ass, 3);
        }
        if (this.Ast != 0) {
            jceOutputStream.write(this.Ast, 4);
        }
        if (this.Asu != null) {
            jceOutputStream.write(this.Asu, 5);
        }
        if (this.Asv != 0) {
            jceOutputStream.write(this.Asv, 6);
        }
        if (this.Asw != null) {
            jceOutputStream.write(this.Asw, 7);
        }
        if (this.Asx != 0) {
            jceOutputStream.write(this.Asx, 8);
        }
        if (this.Asy != null) {
            jceOutputStream.write(this.Asy, 9);
        }
        jceOutputStream.write(this.Asz, 10);
        if (this.AsA != 0) {
            jceOutputStream.write(this.AsA, 11);
        }
        if (this.AsB != 0) {
            jceOutputStream.write(this.AsB, 12);
        }
        if (this.AsC != null) {
            jceOutputStream.write(this.AsC, 13);
        }
        if (this.AsD != 0) {
            jceOutputStream.write(this.AsD, 14);
        }
        jceOutputStream.write(this.AsE, 15);
        if (this.AsF != 0) {
            jceOutputStream.write(this.AsF, 16);
        }
        jceOutputStream.write(this.AsG, 17);
        if (this.AsH != null) {
            jceOutputStream.write(this.AsH, 18);
        }
        AppMethodBeat.m2505o(114492);
    }

    static {
        AppMethodBeat.m2504i(114494);
        byte[] bArr = new byte[1];
        AsI = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        AsJ = bArr;
        bArr[0] = (byte) 0;
        AsK.add(Integer.valueOf(0));
        bArr = new byte[1];
        bArr[0] = (byte) 0;
        AsL.add(bArr);
        AppMethodBeat.m2505o(114494);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114493);
        this.Asp = jceInputStream.read(this.Asp, 0, true);
        this.Asq = jceInputStream.read(AsI, 1, false);
        this.Asr = jceInputStream.readString(2, false);
        this.Ass = jceInputStream.read(AsJ, 3, false);
        this.Ast = jceInputStream.read(this.Ast, 4, false);
        this.Asu = jceInputStream.readString(5, false);
        this.Asv = jceInputStream.read(this.Asv, 6, false);
        this.Asw = jceInputStream.readString(7, false);
        this.Asx = jceInputStream.read(this.Asx, 8, false);
        this.Asy = jceInputStream.readString(9, false);
        this.Asz = jceInputStream.read(this.Asz, 10, false);
        this.AsA = jceInputStream.read(this.AsA, 11, false);
        this.AsB = jceInputStream.read(this.AsB, 12, false);
        this.AsC = (ArrayList) jceInputStream.read(AsK, 13, false);
        this.AsD = jceInputStream.read(this.AsD, 14, false);
        this.AsE = jceInputStream.read(this.AsE, 15, false);
        this.AsF = jceInputStream.read(this.AsF, 16, false);
        this.AsG = jceInputStream.read(this.AsG, 17, false);
        this.AsH = (ArrayList) jceInputStream.read(AsL, 18, false);
        AppMethodBeat.m2505o(114493);
    }
}
