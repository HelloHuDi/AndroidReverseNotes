package com.google.b.c.a;

import com.google.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;

public class k {
    static final k[] bzT;
    private static k[] bzU;
    private final int bAa;
    private final int bAb;
    final int bAc;
    private final boolean bzV;
    final int bzW;
    final int bzX;
    public final int bzY;
    public final int bzZ;

    static {
        AppMethodBeat.i(57312);
        k[] kVarArr = new k[]{new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, ErrorCode.NEEDDOWNLOAD_FALSE_4, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, d.MIC_PTU_TRANS_XINXIAN, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, az.CTRL_INDEX, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, ErrorCode.NEEDDOWNLOAD_FALSE_4, 68), new k(false, 816, 336, 24, 24, 16, n.CTRL_INDEX, 56), new k(false, 1050, 408, 18, 18, 36, ErrorCode.NEEDDOWNLOAD_FALSE_5, 68), new k(false, 1304, m.CTRL_INDEX, 20, 20, 36, ErrorCode.STARTDOWNLOAD_4, 62), new d()};
        bzT = kVarArr;
        bzU = kVarArr;
        AppMethodBeat.o(57312);
    }

    private k(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    k(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bzV = z;
        this.bzW = i;
        this.bzX = i2;
        this.bzY = i3;
        this.bzZ = i4;
        this.bAa = i5;
        this.bAb = i6;
        this.bAc = i7;
    }

    public static k a(int i, l lVar, b bVar, b bVar2) {
        AppMethodBeat.i(57304);
        for (k kVar : bzU) {
            if (!(lVar == l.FORCE_SQUARE && kVar.bzV) && ((lVar != l.FORCE_RECTANGLE || kVar.bzV) && ((bVar == null || (kVar.vG() >= bVar.width && kVar.vH() >= bVar.height)) && ((bVar2 == null || (kVar.vG() <= bVar2.width && kVar.vH() <= bVar2.height)) && i <= kVar.bzW)))) {
                AppMethodBeat.o(57304);
                return kVar;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
        AppMethodBeat.o(57304);
        throw illegalArgumentException;
    }

    private int vC() {
        AppMethodBeat.i(57305);
        switch (this.bAa) {
            case 1:
                AppMethodBeat.o(57305);
                return 1;
            case 2:
            case 4:
                AppMethodBeat.o(57305);
                return 2;
            case 16:
                AppMethodBeat.o(57305);
                return 4;
            case 36:
                AppMethodBeat.o(57305);
                return 6;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Cannot handle this number of data regions");
                AppMethodBeat.o(57305);
                throw illegalStateException;
        }
    }

    private int vD() {
        AppMethodBeat.i(57306);
        switch (this.bAa) {
            case 1:
            case 2:
                AppMethodBeat.o(57306);
                return 1;
            case 4:
                AppMethodBeat.o(57306);
                return 2;
            case 16:
                AppMethodBeat.o(57306);
                return 4;
            case 36:
                AppMethodBeat.o(57306);
                return 6;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Cannot handle this number of data regions");
                AppMethodBeat.o(57306);
                throw illegalStateException;
        }
    }

    public final int vE() {
        AppMethodBeat.i(57307);
        int vC = vC() * this.bzY;
        AppMethodBeat.o(57307);
        return vC;
    }

    public final int vF() {
        AppMethodBeat.i(57308);
        int vD = vD() * this.bzZ;
        AppMethodBeat.o(57308);
        return vD;
    }

    public final int vG() {
        AppMethodBeat.i(57309);
        int vE = vE() + (vC() << 1);
        AppMethodBeat.o(57309);
        return vE;
    }

    public final int vH() {
        AppMethodBeat.i(57310);
        int vF = vF() + (vD() << 1);
        AppMethodBeat.o(57310);
        return vF;
    }

    public int vv() {
        return this.bzW / this.bAb;
    }

    public int fE(int i) {
        return this.bAb;
    }

    public final String toString() {
        AppMethodBeat.i(57311);
        String str = (this.bzV ? "Rectangular Symbol:" : "Square Symbol:") + " data region " + this.bzY + 'x' + this.bzZ + ", symbol size " + vG() + 'x' + vH() + ", symbol data size " + vE() + 'x' + vF() + ", codewords " + this.bzW + '+' + this.bzX;
        AppMethodBeat.o(57311);
        return str;
    }
}
