package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.p702a.C7398aa;
import oicq.wlogin_sdk.p702a.C7402ae;
import oicq.wlogin_sdk.p702a.C7404ag;
import oicq.wlogin_sdk.p702a.C7405ah;
import oicq.wlogin_sdk.p702a.C7407aj;
import oicq.wlogin_sdk.p702a.C7411an;
import oicq.wlogin_sdk.p702a.C7414b;
import oicq.wlogin_sdk.p702a.C7415c;
import oicq.wlogin_sdk.p702a.C7418f;
import oicq.wlogin_sdk.p702a.C7420h;
import oicq.wlogin_sdk.p702a.C7421i;
import oicq.wlogin_sdk.p702a.C7422j;
import oicq.wlogin_sdk.p702a.C7423k;
import oicq.wlogin_sdk.p702a.C7430r;
import oicq.wlogin_sdk.p702a.C7437y;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.request.j */
public final class C7443j extends C6111d {
    public C7443j(C6112i c6112i) {
        this.BUz = 2064;
        this.BUA = 9;
        this.BUC = c6112i;
    }

    /* renamed from: a */
    public final byte[] mo16234a(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, byte[] bArr4) {
        Object cH;
        Object cG;
        AppMethodBeat.m2504i(96441);
        int i3 = this.BUC.BUM;
        this.BUC._uin = j;
        C6120util.m9681jh("IMEI", C6120util.m9664cO(this.BUC.BUN));
        byte[] bArr5 = this.BUC.BUE;
        byte[] bArr6 = this.BUC.BUN;
        byte[] emF = this.BUC.BUH.emF();
        byte[] bArr7 = this.BUC.BUR;
        C7411an c7411an = new C7411an();
        C7414b c7414b = new C7414b();
        C7420h c7420h = new C7420h();
        C7430r c7430r = new C7430r();
        C7415c c7415c = new C7415c();
        C7421i c7421i = new C7421i();
        C7422j c7422j = new C7422j();
        C7423k c7423k = new C7423k();
        C7418f c7418f = new C7418f();
        C7437y c7437y = new C7437y();
        C7398aa c7398aa = new C7398aa();
        C7402ae c7402ae = new C7402ae();
        C7404ag c7404ag = new C7404ag();
        C7405ah c7405ah = new C7405ah();
        C7407aj c7407aj = new C7407aj();
        Object aj = c7411an.mo16221aj(i3, j);
        Object g = c7414b.mo16223g(j, bArr);
        Object a = c7420h.mo16226a(i3, j, bArr2, bArr, bArr3, bArr5, this.BUC.BUZ, this.BUC.BUN);
        this.BUC.BVd = super.mo13527cD(c7420h.emF());
        Object Vk = c7415c.mo16224Vk(i3);
        Object emI = c7421i.emI();
        Object iB = c7430r.mo16230iB(i, i2);
        Object cK = c7405ah.mo16219cK(this.BUC.BUN);
        int i4 = 7;
        Object obj = new byte[0];
        byte[] bArr8 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr4.length > 0) {
            i4 = 8;
            cH = c7422j.mo16228cH(bArr4);
        } else {
            cH = obj;
        }
        if (bArr6.length > 0) {
            bArr6 = c7423k.mo16229cI(bArr6);
        } else {
            bArr6 = bArr8;
        }
        bArr8 = c7404ag.mo16218a(bArr6, c7437y.mo16231a(C6120util.emL(), C6120util.emM(), this.BUC.BUQ, this.BUC.BUP, new byte[0], this.BUC.BUS), c7398aa.mo16215a(this.BUC.BUY, this.BUC.BUZ, this.BUC.BVa, this.BUC.BUW, this.BUC.BUN), c7407aj.mo16220p(this.BUC.BUU, this.BUC.BUV), this.BUC.BUE);
        i4++;
        byte[] cJ = c7402ae.mo16217cJ(bArr7);
        int i5 = i4 + 1;
        if (emF.length > 0) {
            cG = c7418f.mo16225cG(emF);
            i5++;
        } else {
            cG = obj2;
        }
        byte[] bArr9 = new byte[(((((((((((aj.length + g.length) + a.length) + iB.length) + Vk.length) + emI.length) + cH.length) + bArr8.length) + cG.length) + cJ.length) + 0) + cK.length)];
        System.arraycopy(aj, 0, bArr9, 0, aj.length);
        int length = aj.length + 0;
        System.arraycopy(g, 0, bArr9, length, g.length);
        length += g.length;
        System.arraycopy(a, 0, bArr9, length, a.length);
        length += a.length;
        System.arraycopy(iB, 0, bArr9, length, iB.length);
        length += iB.length;
        System.arraycopy(Vk, 0, bArr9, length, Vk.length);
        length += Vk.length;
        System.arraycopy(emI, 0, bArr9, length, emI.length);
        length += emI.length;
        System.arraycopy(cH, 0, bArr9, length, cH.length);
        length += cH.length;
        System.arraycopy(bArr8, 0, bArr9, length, bArr8.length);
        int length2 = bArr8.length + length;
        System.arraycopy(cJ, 0, bArr9, length2, cJ.length);
        length2 += cJ.length;
        System.arraycopy(obj3, 0, bArr9, length2, 0);
        length2 += 0;
        System.arraycopy(cG, 0, bArr9, length2, cG.length);
        System.arraycopy(cK, 0, bArr9, cG.length + length2, cK.length);
        long j2 = j;
        int i6 = i3;
        mo13524a(this.BUu, this.BUz, j2, this.BUw, this.BUx, i6, this.BUy, super.mo13521G(bArr9, this.BUA, i5));
        byte[] emC = super.emC();
        AppMethodBeat.m2505o(96441);
        return emC;
    }

    /* renamed from: a */
    public final byte[] mo16233a(long j, byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3) {
        AppMethodBeat.m2504i(96442);
        int i3 = this.BUC.BUM;
        this.BUC._uin = j;
        byte[] cE = super.mo13528cE(bArr2);
        if (cE == null) {
            AppMethodBeat.m2505o(96442);
            return null;
        }
        byte[] bArr4;
        Object cH;
        int i4;
        byte[] cI;
        Object cG;
        byte[] bArr5 = this.BUC.BUN;
        byte[] emF = this.BUC.BUH.emF();
        byte[] bArr6 = this.BUC.BUR;
        C7411an c7411an = new C7411an();
        C7414b c7414b = new C7414b();
        C7420h c7420h = new C7420h();
        C7430r c7430r = new C7430r();
        C7415c c7415c = new C7415c();
        C7421i c7421i = new C7421i();
        C7422j c7422j = new C7422j();
        C7423k c7423k = new C7423k();
        C7418f c7418f = new C7418f();
        C7437y c7437y = new C7437y();
        C7398aa c7398aa = new C7398aa();
        C7402ae c7402ae = new C7402ae();
        C7404ag c7404ag = new C7404ag();
        C7405ah c7405ah = new C7405ah();
        C7407aj c7407aj = new C7407aj();
        Object aj = c7411an.mo16221aj(i3, j);
        Object g = c7414b.mo16223g(j, bArr);
        this.BUC.BVd = super.mo13527cD(cE);
        int length = cE.length;
        if (c7420h.BVi + length > c7420h.BUn) {
            c7420h.BUn = (c7420h.BVi + length) + 128;
            bArr4 = new byte[c7420h.BUn];
            System.arraycopy(c7420h.BUt, 0, bArr4, 0, c7420h.BVi);
            c7420h.BUt = bArr4;
        }
        c7420h.BUo = c7420h.BVi + length;
        System.arraycopy(cE, 0, c7420h.BUt, c7420h.BVi, length);
        c7420h.BVj = length;
        C6120util.m9654N(c7420h.BUt, 0, c7420h.BUz);
        C6120util.m9654N(c7420h.BUt, 2, c7420h.BVj);
        Object emC = c7420h.emC();
        C6120util.m9681jh("req2 a1:", C6120util.m9664cO(emC));
        Object Vk = c7415c.mo16224Vk(i3);
        Object emI = c7421i.emI();
        Object iB = c7430r.mo16230iB(i, i2);
        Object cK = c7405ah.mo16219cK(this.BUC.BUN);
        Object obj = new byte[0];
        bArr4 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr3.length > 0) {
            cH = c7422j.mo16228cH(bArr3);
            i4 = 8;
        } else {
            cH = obj;
            i4 = 7;
        }
        if (bArr5.length > 0) {
            cI = c7423k.mo16229cI(bArr5);
        } else {
            cI = bArr4;
        }
        byte[] a = c7404ag.mo16218a(cI, c7437y.mo16231a(C6120util.emL(), C6120util.emM(), this.BUC.BUQ, this.BUC.BUP, new byte[0], this.BUC.BUS), c7398aa.mo16215a(this.BUC.BUY, this.BUC.BUZ, this.BUC.BVa, this.BUC.BUW, this.BUC.BUN), c7407aj.mo16220p(this.BUC.BUU, this.BUC.BUV), this.BUC.BUE);
        int i5 = i4 + 1;
        bArr4 = c7402ae.mo16217cJ(bArr6);
        int i6 = i5 + 1;
        if (emF.length > 0) {
            cG = c7418f.mo16225cG(emF);
            i6++;
        } else {
            cG = obj2;
        }
        bArr5 = new byte[(((((((((((aj.length + g.length) + emC.length) + iB.length) + Vk.length) + emI.length) + cH.length) + a.length) + cG.length) + bArr4.length) + 0) + cK.length)];
        System.arraycopy(aj, 0, bArr5, 0, aj.length);
        int length2 = aj.length + 0;
        System.arraycopy(g, 0, bArr5, length2, g.length);
        length2 += g.length;
        System.arraycopy(emC, 0, bArr5, length2, emC.length);
        length2 += emC.length;
        System.arraycopy(iB, 0, bArr5, length2, iB.length);
        length2 += iB.length;
        System.arraycopy(Vk, 0, bArr5, length2, Vk.length);
        length2 += Vk.length;
        System.arraycopy(emI, 0, bArr5, length2, emI.length);
        length2 += emI.length;
        System.arraycopy(cH, 0, bArr5, length2, cH.length);
        length2 += cH.length;
        System.arraycopy(a, 0, bArr5, length2, a.length);
        length = a.length + length2;
        System.arraycopy(bArr4, 0, bArr5, length, bArr4.length);
        length += bArr4.length;
        System.arraycopy(obj3, 0, bArr5, length, 0);
        length += 0;
        System.arraycopy(cG, 0, bArr5, length, cG.length);
        System.arraycopy(cK, 0, bArr5, cG.length + length, cK.length);
        cI = super.mo13521G(bArr5, this.BUA, i6);
        mo13524a(this.BUu, this.BUz, j, this.BUw, this.BUx, i3, this.BUy, cI);
        byte[] emC2 = super.emC();
        AppMethodBeat.m2505o(96442);
        return emC2;
    }
}
