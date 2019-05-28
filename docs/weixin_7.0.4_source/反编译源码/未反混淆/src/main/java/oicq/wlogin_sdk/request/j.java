package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.i;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j extends d {
    public j(i iVar) {
        this.BUz = 2064;
        this.BUA = 9;
        this.BUC = iVar;
    }

    public final byte[] a(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, byte[] bArr4) {
        Object cH;
        Object cG;
        AppMethodBeat.i(96441);
        int i3 = this.BUC.BUM;
        this.BUC._uin = j;
        util.jh("IMEI", util.cO(this.BUC.BUN));
        byte[] bArr5 = this.BUC.BUE;
        byte[] bArr6 = this.BUC.BUN;
        byte[] emF = this.BUC.BUH.emF();
        byte[] bArr7 = this.BUC.BUR;
        an anVar = new an();
        b bVar = new b();
        h hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object aj = anVar.aj(i3, j);
        Object g = bVar.g(j, bArr);
        Object a = hVar.a(i3, j, bArr2, bArr, bArr3, bArr5, this.BUC.BUZ, this.BUC.BUN);
        this.BUC.BVd = super.cD(hVar.emF());
        Object Vk = cVar.Vk(i3);
        Object emI = iVar.emI();
        Object iB = rVar.iB(i, i2);
        Object cK = ahVar.cK(this.BUC.BUN);
        int i4 = 7;
        Object obj = new byte[0];
        byte[] bArr8 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr4.length > 0) {
            i4 = 8;
            cH = jVar.cH(bArr4);
        } else {
            cH = obj;
        }
        if (bArr6.length > 0) {
            bArr6 = kVar.cI(bArr6);
        } else {
            bArr6 = bArr8;
        }
        bArr8 = agVar.a(bArr6, yVar.a(util.emL(), util.emM(), this.BUC.BUQ, this.BUC.BUP, new byte[0], this.BUC.BUS), aaVar.a(this.BUC.BUY, this.BUC.BUZ, this.BUC.BVa, this.BUC.BUW, this.BUC.BUN), ajVar.p(this.BUC.BUU, this.BUC.BUV), this.BUC.BUE);
        i4++;
        byte[] cJ = aeVar.cJ(bArr7);
        int i5 = i4 + 1;
        if (emF.length > 0) {
            cG = fVar.cG(emF);
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
        a(this.BUu, this.BUz, j2, this.BUw, this.BUx, i6, this.BUy, super.G(bArr9, this.BUA, i5));
        byte[] emC = super.emC();
        AppMethodBeat.o(96441);
        return emC;
    }

    public final byte[] a(long j, byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3) {
        AppMethodBeat.i(96442);
        int i3 = this.BUC.BUM;
        this.BUC._uin = j;
        byte[] cE = super.cE(bArr2);
        if (cE == null) {
            AppMethodBeat.o(96442);
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
        an anVar = new an();
        b bVar = new b();
        h hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object aj = anVar.aj(i3, j);
        Object g = bVar.g(j, bArr);
        this.BUC.BVd = super.cD(cE);
        int length = cE.length;
        if (hVar.BVi + length > hVar.BUn) {
            hVar.BUn = (hVar.BVi + length) + 128;
            bArr4 = new byte[hVar.BUn];
            System.arraycopy(hVar.BUt, 0, bArr4, 0, hVar.BVi);
            hVar.BUt = bArr4;
        }
        hVar.BUo = hVar.BVi + length;
        System.arraycopy(cE, 0, hVar.BUt, hVar.BVi, length);
        hVar.BVj = length;
        util.N(hVar.BUt, 0, hVar.BUz);
        util.N(hVar.BUt, 2, hVar.BVj);
        Object emC = hVar.emC();
        util.jh("req2 a1:", util.cO(emC));
        Object Vk = cVar.Vk(i3);
        Object emI = iVar.emI();
        Object iB = rVar.iB(i, i2);
        Object cK = ahVar.cK(this.BUC.BUN);
        Object obj = new byte[0];
        bArr4 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr3.length > 0) {
            cH = jVar.cH(bArr3);
            i4 = 8;
        } else {
            cH = obj;
            i4 = 7;
        }
        if (bArr5.length > 0) {
            cI = kVar.cI(bArr5);
        } else {
            cI = bArr4;
        }
        byte[] a = agVar.a(cI, yVar.a(util.emL(), util.emM(), this.BUC.BUQ, this.BUC.BUP, new byte[0], this.BUC.BUS), aaVar.a(this.BUC.BUY, this.BUC.BUZ, this.BUC.BVa, this.BUC.BUW, this.BUC.BUN), ajVar.p(this.BUC.BUU, this.BUC.BUV), this.BUC.BUE);
        int i5 = i4 + 1;
        bArr4 = aeVar.cJ(bArr6);
        int i6 = i5 + 1;
        if (emF.length > 0) {
            cG = fVar.cG(emF);
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
        cI = super.G(bArr5, this.BUA, i6);
        a(this.BUu, this.BUz, j, this.BUw, this.BUx, i3, this.BUy, cI);
        byte[] emC2 = super.emC();
        AppMethodBeat.o(96442);
        return emC2;
    }
}
