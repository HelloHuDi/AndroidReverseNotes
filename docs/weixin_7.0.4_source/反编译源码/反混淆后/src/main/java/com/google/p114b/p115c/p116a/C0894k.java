package com.google.p114b.p115c.p116a;

import com.google.p114b.C45062b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19486m;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;

/* renamed from: com.google.b.c.a.k */
public class C0894k {
    static final C0894k[] bzT;
    private static C0894k[] bzU;
    private final int bAa;
    private final int bAb;
    final int bAc;
    private final boolean bzV;
    final int bzW;
    final int bzX;
    public final int bzY;
    public final int bzZ;

    static {
        AppMethodBeat.m2504i(57312);
        C0894k[] c0894kArr = new C0894k[]{new C0894k(false, 3, 5, 8, 8, 1), new C0894k(false, 5, 7, 10, 10, 1), new C0894k(true, 5, 7, 16, 6, 1), new C0894k(false, 8, 10, 12, 12, 1), new C0894k(true, 10, 11, 14, 6, 2), new C0894k(false, 12, 12, 14, 14, 1), new C0894k(true, 16, 14, 24, 10, 1), new C0894k(false, 18, 14, 16, 16, 1), new C0894k(false, 22, 18, 18, 18, 1), new C0894k(true, 22, 18, 16, 10, 2), new C0894k(false, 30, 20, 20, 20, 1), new C0894k(true, 32, 24, 16, 14, 2), new C0894k(false, 36, 24, 22, 22, 1), new C0894k(false, 44, 28, 24, 24, 1), new C0894k(true, 49, 28, 22, 14, 2), new C0894k(false, 62, 36, 14, 14, 4), new C0894k(false, 86, 42, 16, 16, 4), new C0894k(false, 114, 48, 18, 18, 4), new C0894k(false, 144, 56, 20, 20, 4), new C0894k(false, ErrorCode.NEEDDOWNLOAD_FALSE_4, 68, 22, 22, 4), new C0894k(false, 204, 84, 24, 24, 4, 102, 42), new C0894k(false, C31128d.MIC_PTU_TRANS_XINXIAN, 112, 14, 14, 16, 140, 56), new C0894k(false, 368, 144, 16, 16, 16, 92, 36), new C0894k(false, 456, C33250az.CTRL_INDEX, 18, 18, 16, 114, 48), new C0894k(false, 576, 224, 20, 20, 16, 144, 56), new C0894k(false, 696, 272, 22, 22, 16, ErrorCode.NEEDDOWNLOAD_FALSE_4, 68), new C0894k(false, 816, 336, 24, 24, 16, C19395n.CTRL_INDEX, 56), new C0894k(false, 1050, 408, 18, 18, 36, ErrorCode.NEEDDOWNLOAD_FALSE_5, 68), new C0894k(false, 1304, C19486m.CTRL_INDEX, 20, 20, 36, ErrorCode.STARTDOWNLOAD_4, 62), new C8729d()};
        bzT = c0894kArr;
        bzU = c0894kArr;
        AppMethodBeat.m2505o(57312);
    }

    private C0894k(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    C0894k(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bzV = z;
        this.bzW = i;
        this.bzX = i2;
        this.bzY = i3;
        this.bzZ = i4;
        this.bAa = i5;
        this.bAb = i6;
        this.bAc = i7;
    }

    /* renamed from: a */
    public static C0894k m2021a(int i, C0895l c0895l, C45062b c45062b, C45062b c45062b2) {
        AppMethodBeat.m2504i(57304);
        for (C0894k c0894k : bzU) {
            if (!(c0895l == C0895l.FORCE_SQUARE && c0894k.bzV) && ((c0895l != C0895l.FORCE_RECTANGLE || c0894k.bzV) && ((c45062b == null || (c0894k.mo3680vG() >= c45062b.width && c0894k.mo3681vH() >= c45062b.height)) && ((c45062b2 == null || (c0894k.mo3680vG() <= c45062b2.width && c0894k.mo3681vH() <= c45062b2.height)) && i <= c0894k.bzW)))) {
                AppMethodBeat.m2505o(57304);
                return c0894k;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(57304);
        throw illegalArgumentException;
    }

    /* renamed from: vC */
    private int m2022vC() {
        AppMethodBeat.m2504i(57305);
        switch (this.bAa) {
            case 1:
                AppMethodBeat.m2505o(57305);
                return 1;
            case 2:
            case 4:
                AppMethodBeat.m2505o(57305);
                return 2;
            case 16:
                AppMethodBeat.m2505o(57305);
                return 4;
            case 36:
                AppMethodBeat.m2505o(57305);
                return 6;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Cannot handle this number of data regions");
                AppMethodBeat.m2505o(57305);
                throw illegalStateException;
        }
    }

    /* renamed from: vD */
    private int m2023vD() {
        AppMethodBeat.m2504i(57306);
        switch (this.bAa) {
            case 1:
            case 2:
                AppMethodBeat.m2505o(57306);
                return 1;
            case 4:
                AppMethodBeat.m2505o(57306);
                return 2;
            case 16:
                AppMethodBeat.m2505o(57306);
                return 4;
            case 36:
                AppMethodBeat.m2505o(57306);
                return 6;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Cannot handle this number of data regions");
                AppMethodBeat.m2505o(57306);
                throw illegalStateException;
        }
    }

    /* renamed from: vE */
    public final int mo3678vE() {
        AppMethodBeat.m2504i(57307);
        int vC = m2022vC() * this.bzY;
        AppMethodBeat.m2505o(57307);
        return vC;
    }

    /* renamed from: vF */
    public final int mo3679vF() {
        AppMethodBeat.m2504i(57308);
        int vD = m2023vD() * this.bzZ;
        AppMethodBeat.m2505o(57308);
        return vD;
    }

    /* renamed from: vG */
    public final int mo3680vG() {
        AppMethodBeat.m2504i(57309);
        int vE = mo3678vE() + (m2022vC() << 1);
        AppMethodBeat.m2505o(57309);
        return vE;
    }

    /* renamed from: vH */
    public final int mo3681vH() {
        AppMethodBeat.m2504i(57310);
        int vF = mo3679vF() + (m2023vD() << 1);
        AppMethodBeat.m2505o(57310);
        return vF;
    }

    /* renamed from: vv */
    public int mo3682vv() {
        return this.bzW / this.bAb;
    }

    /* renamed from: fE */
    public int mo3676fE(int i) {
        return this.bAb;
    }

    public final String toString() {
        AppMethodBeat.m2504i(57311);
        String str = (this.bzV ? "Rectangular Symbol:" : "Square Symbol:") + " data region " + this.bzY + 'x' + this.bzZ + ", symbol size " + mo3680vG() + 'x' + mo3681vH() + ", symbol data size " + mo3678vE() + 'x' + mo3679vF() + ", codewords " + this.bzW + '+' + this.bzX;
        AppMethodBeat.m2505o(57311);
        return str;
    }
}
