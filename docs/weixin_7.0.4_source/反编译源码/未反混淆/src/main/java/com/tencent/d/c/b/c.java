package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends JceStruct {
    static byte[] AsV;
    static byte[] AsW;
    public int AsM = 0;
    public int AsN = 0;
    public int AsO = 0;
    public byte[] AsP = null;
    public int AsQ = 0;
    public long AsR = 0;
    public byte[] AsS = null;
    public int AsT = 0;
    public int AsU = 0;
    public int Ase = 0;
    public int fzY = 0;
    public int requestType = 0;

    public final JceStruct newInit() {
        AppMethodBeat.i(114495);
        c cVar = new c();
        AppMethodBeat.o(114495);
        return cVar;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114496);
        if (this.AsM != 0) {
            jceOutputStream.write(this.AsM, 0);
        }
        jceOutputStream.write(this.Ase, 1);
        jceOutputStream.write(this.requestType, 2);
        if (this.AsN != 0) {
            jceOutputStream.write(this.AsN, 3);
        }
        if (this.AsO != 0) {
            jceOutputStream.write(this.AsO, 4);
        }
        if (this.AsP != null) {
            jceOutputStream.write(this.AsP, 5);
        }
        if (this.AsQ != 0) {
            jceOutputStream.write(this.AsQ, 6);
        }
        if (this.fzY != 0) {
            jceOutputStream.write(this.fzY, 7);
        }
        if (this.AsR != 0) {
            jceOutputStream.write(this.AsR, 8);
        }
        if (this.AsS != null) {
            jceOutputStream.write(this.AsS, 9);
        }
        if (this.AsT != 0) {
            jceOutputStream.write(this.AsT, 10);
        }
        if (this.AsU != 0) {
            jceOutputStream.write(this.AsU, 11);
        }
        AppMethodBeat.o(114496);
    }

    static {
        byte[] bArr = new byte[1];
        AsV = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        AsW = bArr;
        bArr[0] = (byte) 0;
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114497);
        this.AsM = jceInputStream.read(this.AsM, 0, false);
        this.Ase = jceInputStream.read(this.Ase, 1, false);
        this.requestType = jceInputStream.read(this.requestType, 2, false);
        this.AsN = jceInputStream.read(this.AsN, 3, false);
        this.AsO = jceInputStream.read(this.AsO, 4, false);
        this.AsP = jceInputStream.read(AsV, 5, false);
        this.AsQ = jceInputStream.read(this.AsQ, 6, false);
        this.fzY = jceInputStream.read(this.fzY, 7, false);
        this.AsR = jceInputStream.read(this.AsR, 8, false);
        this.AsS = jceInputStream.read(AsW, 9, false);
        this.AsT = jceInputStream.read(this.AsT, 10, false);
        this.AsU = jceInputStream.read(this.AsU, 11, false);
        AppMethodBeat.o(114497);
    }
}
