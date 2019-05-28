package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VError;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d {
    protected static int BUv = 0;
    protected int BUA = 0;
    byte BUB;
    protected i BUC;
    int BUn = 4096;
    int BUo = 0;
    int BUp = 27;
    int BUq = 0;
    public int BUr = 15;
    protected int BUs = 0;
    protected byte[] BUt = new byte[this.BUn];
    protected int BUu = 8001;
    protected int BUw = 0;
    protected int BUx = 0;
    protected int BUy = 0;
    protected int BUz = 0;

    public d() {
        AppMethodBeat.i(96427);
        AppMethodBeat.o(96427);
    }

    public final void a(int i, int i2, long j, int i3, int i4, int i5, int i6, byte[] bArr) {
        AppMethodBeat.i(96428);
        int length = bArr.length;
        int i7 = BUv + 1;
        BUv = i7;
        this.BUo = 0;
        util.M(this.BUt, this.BUo, 2);
        this.BUo++;
        util.N(this.BUt, this.BUo, (this.BUp + 2) + length);
        this.BUo += 2;
        util.N(this.BUt, this.BUo, i);
        this.BUo += 2;
        util.N(this.BUt, this.BUo, i2);
        this.BUo += 2;
        util.N(this.BUt, this.BUo, i7);
        this.BUo += 2;
        util.O(this.BUt, this.BUo, (int) j);
        this.BUo += 4;
        util.M(this.BUt, this.BUo, 3);
        this.BUo++;
        util.M(this.BUt, this.BUo, 0);
        this.BUo++;
        util.M(this.BUt, this.BUo, i3);
        this.BUo++;
        util.O(this.BUt, this.BUo, i4);
        this.BUo += 4;
        util.O(this.BUt, this.BUo, i5);
        this.BUo += 4;
        util.O(this.BUt, this.BUo, i6);
        this.BUo += 4;
        if ((this.BUo + length) + 1 > this.BUn) {
            this.BUn = ((this.BUo + length) + 1) + 128;
            byte[] bArr2 = new byte[this.BUn];
            System.arraycopy(this.BUt, 0, bArr2, 0, this.BUo);
            this.BUt = bArr2;
        }
        System.arraycopy(bArr, 0, this.BUt, this.BUo, length);
        this.BUo = length + this.BUo;
        util.M(this.BUt, this.BUo, 3);
        this.BUo++;
        AppMethodBeat.o(96428);
    }

    public final int aa(byte[] bArr, int i) {
        int i2 = 0;
        AppMethodBeat.i(96429);
        if (i <= this.BUr + 2) {
            AppMethodBeat.o(96429);
            return -1009;
        }
        this.BUs = (i - this.BUr) - 2;
        if (i > this.BUn) {
            this.BUn = i + 128;
            this.BUt = new byte[this.BUn];
        }
        this.BUo = i;
        System.arraycopy(bArr, 0, this.BUt, 0, i);
        int i3 = this.BUr + 1;
        byte[] decrypt = oicq.wlogin_sdk.tools.d.decrypt(this.BUt, i3, this.BUs, this.BUC.BUG);
        if (decrypt == null) {
            i2 = VError.ERROR_FACE_MODEL_INIT;
        } else {
            this.BUs = decrypt.length;
            if ((decrypt.length + this.BUr) + 2 > this.BUn) {
                this.BUn = (decrypt.length + this.BUr) + 2;
                byte[] bArr2 = new byte[this.BUn];
                System.arraycopy(this.BUt, 0, bArr2, 0, this.BUo);
                this.BUt = bArr2;
            }
            this.BUo = 0;
            System.arraycopy(decrypt, 0, this.BUt, i3, decrypt.length);
            this.BUo = (decrypt.length + (this.BUr + 2)) + this.BUo;
        }
        if (i2 < 0) {
            AppMethodBeat.o(96429);
            return VError.ERROR_FACE_MODEL_INIT;
        }
        int I = I(this.BUt, this.BUr + 1, this.BUs);
        AppMethodBeat.o(96429);
        return I;
    }

    public final byte[] emC() {
        AppMethodBeat.i(96430);
        byte[] bArr = new byte[this.BUo];
        System.arraycopy(this.BUt, 0, bArr, 0, this.BUo);
        AppMethodBeat.o(96430);
        return bArr;
    }

    /* Access modifiers changed, original: final */
    public final byte[] G(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(96431);
        byte[] bArr2 = new byte[(bArr.length + 4)];
        util.N(bArr2, 0, i);
        util.N(bArr2, 2, i2);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        bArr2 = oicq.wlogin_sdk.tools.d.a(bArr2, bArr2.length, this.BUC.BUG);
        byte[] bArr3 = new byte[(bArr2.length + this.BUC.BUG.length)];
        System.arraycopy(this.BUC.BUG, 0, bArr3, 0, this.BUC.BUG.length);
        System.arraycopy(bArr2, 0, bArr3, this.BUC.BUG.length, bArr2.length);
        AppMethodBeat.o(96431);
        return bArr3;
    }

    public final int ab(byte[] bArr, int i) {
        this.BUB = bArr[i];
        return bArr[i] & 255;
    }

    public final void H(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(96432);
        ai aiVar = new ai();
        if (aiVar.L(bArr, i, i2) >= 0) {
            ErrMsg errMsg = this.BUC.BVc;
            byte[] bArr2 = new byte[aiVar.BVQ];
            System.arraycopy(aiVar.BUt, aiVar.BVi + 6, bArr2, 0, aiVar.BVQ);
            errMsg.title = new String(bArr2);
            errMsg = this.BUC.BVc;
            bArr2 = new byte[aiVar.BVR];
            System.arraycopy(aiVar.BUt, (aiVar.BVi + 8) + aiVar.BVQ, bArr2, 0, aiVar.BVR);
            errMsg.message = new String(bArr2);
            errMsg = this.BUC.BVc;
            bArr2 = new byte[aiVar.BVS];
            System.arraycopy(aiVar.BUt, ((aiVar.BVi + 12) + aiVar.BVQ) + aiVar.BVR, bArr2, 0, aiVar.BVS);
            errMsg.BVZ = new String(bArr2);
            AppMethodBeat.o(96432);
            return;
        }
        this.BUC.BVc.emK();
        AppMethodBeat.o(96432);
    }

    public final void emD() {
        AppMethodBeat.i(96433);
        this.BUC.BVc.emK();
        AppMethodBeat.o(96433);
    }

    public final byte[] cD(byte[] bArr) {
        AppMethodBeat.i(96434);
        if (bArr == null) {
            AppMethodBeat.o(96434);
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length + this.BUC.BUE.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.BUC.BUE, 0, bArr2, bArr.length, this.BUC.BUE.length);
        AppMethodBeat.o(96434);
        return bArr2;
    }

    public final byte[] cE(byte[] bArr) {
        AppMethodBeat.i(96435);
        if (bArr == null || bArr.length < 16) {
            AppMethodBeat.o(96435);
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        int length = bArr2.length - 16;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        this.BUC.BUE = new byte[16];
        System.arraycopy(bArr2, length, this.BUC.BUE, 0, 16);
        AppMethodBeat.o(96435);
        return bArr3;
    }

    public int I(byte[] bArr, int i, int i2) {
        int i3;
        AppMethodBeat.i(96436);
        f fVar = new f();
        g gVar = new g();
        s sVar = new s();
        if (this.BUz == 2064 && this.BUA == 9) {
            i3 = 0;
        } else if (this.BUz == 2064 && this.BUA == 10) {
            i3 = 1;
        } else if (this.BUz == 2064 && this.BUA == 2) {
            i3 = 2;
        } else if (this.BUz == 2064 && this.BUA == 13) {
            i3 = 4;
        } else {
            AppMethodBeat.o(96436);
            return -1012;
        }
        if (i2 < 5) {
            AppMethodBeat.o(96436);
            return -1009;
        }
        int ab = ab(bArr, i + 2);
        emD();
        int i4 = i + 5;
        switch (ab) {
            case 0:
                if (i3 != 1) {
                    ab = sVar.b(bArr, i4, (this.BUo - i4) - 1, this.BUC.BUE);
                } else if (this.BUC.BUF == null) {
                    AppMethodBeat.o(96436);
                    return -1006;
                } else {
                    ab = sVar.b(bArr, i4, (this.BUo - i4) - 1, this.BUC.BUF);
                }
                if (ab >= 0) {
                    long j = 4294967295L;
                    a oVar = new o();
                    a pVar = new p();
                    a lVar = new l();
                    a qVar = new q();
                    e eVar = new e();
                    a tVar = new t();
                    oicq.wlogin_sdk.a.d dVar = new oicq.wlogin_sdk.a.d();
                    m mVar = new m();
                    u uVar = new u();
                    a wVar = new w();
                    a xVar = new x();
                    a jVar = new j();
                    a hVar = new h();
                    a nVar = new n();
                    a zVar = new z();
                    a vVar = new v();
                    a adVar = new ad();
                    a abVar = new ab();
                    a afVar = new af();
                    a apVar = new ap();
                    a akVar = new ak();
                    a alVar = new al();
                    a amVar = new am();
                    byte[] bArr2 = null;
                    byte[] bArr3 = null;
                    byte[] bArr4 = null;
                    byte[] bArr5 = null;
                    byte[] bArr6 = null;
                    byte[] bArr7 = null;
                    byte[] bArr8 = null;
                    byte[] bArr9 = null;
                    a acVar = new ac();
                    byte[] emF = sVar.emF();
                    int length = emF.length;
                    oVar.L(emF, 2, length);
                    pVar.L(emF, 2, length);
                    lVar.L(emF, 2, length);
                    qVar.L(emF, 2, length);
                    ab = tVar.L(emF, 2, length);
                    if (ab >= 0) {
                        byte[] emC;
                        long ag;
                        long j2;
                        long j3;
                        if (eVar.L(emF, 2, length) >= 0) {
                            bArr7 = eVar.emF();
                        }
                        if (jVar.L(emF, 2, length) >= 0) {
                            util.a(this.BUC._context, jVar.emF());
                        }
                        if (dVar.L(emF, 2, length) >= 0) {
                            bArr2 = dVar.emF();
                        }
                        if (mVar.L(emF, 2, length) >= 0) {
                            bArr3 = mVar.emF();
                        }
                        if (uVar.L(emF, 2, length) >= 0) {
                            bArr4 = uVar.emF();
                        }
                        if (wVar.L(emF, 2, length) >= 0) {
                            bArr5 = wVar.emF();
                        }
                        if (xVar.L(emF, 2, length) >= 0) {
                            bArr6 = xVar.emF();
                        }
                        if (zVar.L(emF, 2, length) >= 0) {
                            bArr8 = new byte[zVar.BVH];
                            System.arraycopy(zVar.BUt, zVar.BVi + 2, bArr8, 0, bArr8.length);
                            bArr9 = new byte[zVar.BVI];
                            System.arraycopy(zVar.BUt, ((zVar.BVi + 2) + zVar.BVH) + 2, bArr9, 0, bArr9.length);
                        }
                        if (alVar.L(emF, 2, length) >= 0) {
                            Object obj;
                            h hVar2 = new h();
                            n nVar2 = new n();
                            am amVar2 = new am();
                            ah ahVar = new ah();
                            byte[] emF2 = alVar.emF();
                            int length2 = emF2.length;
                            if (hVar2.L(emF2, 2, length2) < 0) {
                                obj = null;
                            } else if (nVar2.L(emF2, 2, length2) < 0) {
                                obj = null;
                            } else if (amVar2.L(emF2, 2, length2) < 0) {
                                obj = null;
                            } else {
                                emF2 = hVar2.emC();
                                emC = nVar2.emC();
                                byte[] emC2 = amVar2.emC();
                                byte[] cK = ahVar.cK(this.BUC.BUN);
                                Object obj2 = new byte[((((emF2.length + 3) + emC.length) + emC2.length) + cK.length)];
                                obj2[0] = (byte) 64;
                                util.N(obj2, 1, 4);
                                System.arraycopy(emF2, 0, obj2, 3, emF2.length);
                                int length3 = emF2.length + 3;
                                System.arraycopy(emC, 0, obj2, length3, emC.length);
                                i3 = emC.length + length3;
                                System.arraycopy(emC2, 0, obj2, i3, emC2.length);
                                System.arraycopy(cK, 0, obj2, i3 + emC2.length, cK.length);
                                obj = obj2;
                            }
                            if (obj == null || obj.length <= 0) {
                                this.BUC.BVf = new byte[0];
                            } else {
                                this.BUC.BVf = (byte[]) obj.clone();
                                util.jh("fast data:", util.cO(obj));
                            }
                        }
                        byte[][] bArr10 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{7, 0});
                        if (acVar.L(emF, 2, length) >= 0) {
                            bArr10[0] = acVar.emF();
                        }
                        ab = nVar.L(emF, 2, length);
                        if (hVar.L(emF, 2, length) >= 0 && ab >= 0) {
                            this.BUC.BUE = nVar.emF();
                            this.BUC.BVd = cD(hVar.emF());
                            bArr10[1] = (byte[]) this.BUC.BVd.clone();
                        }
                        if (abVar.L(emF, 2, length) >= 0) {
                            emC = new byte[abVar.BVK];
                            System.arraycopy(abVar.BUt, abVar.BVi + 2, emC, 0, emC.length);
                            bArr10[2] = emC;
                        }
                        if (afVar.L(emF, 2, length) >= 0) {
                            bArr10[3] = afVar.emF();
                        }
                        if (apVar.L(emF, 2, length) >= 0) {
                            bArr10[4] = apVar.emF();
                        }
                        if (akVar.L(emF, 2, length) >= 0) {
                            bArr10[5] = akVar.emF();
                        }
                        if (amVar.L(emF, 2, length) >= 0) {
                            bArr10[6] = amVar.emF();
                        }
                        if (vVar.L(emF, 2, length) >= 0) {
                            if (this.BUC.BUL == -1) {
                                ag = (long) util.ag(vVar.BUt, vVar.BVi);
                            } else {
                                ag = this.BUC.BUL;
                            }
                            j = 4294967295L & ((long) util.ag(vVar.BUt, vVar.BVi + 4));
                            j2 = ag;
                        } else {
                            j2 = 3600;
                        }
                        if (adVar.L(emF, 2, length) < 0 || adVar.emJ() == 0) {
                            ag = 2160000;
                        } else {
                            ag = (long) adVar.emJ();
                        }
                        if (ag < j2) {
                            j3 = j2;
                        } else {
                            j3 = ag;
                        }
                        i iVar = this.BUC;
                        long j4 = this.BUC._uin;
                        long j5 = this.BUC.BUJ;
                        long emE = i.emE();
                        j2 += i.emE();
                        j3 += i.emE();
                        Object obj3 = new byte[2];
                        System.arraycopy(tVar.BUt, tVar.BVi, obj3, 0, 2);
                        Object obj4 = new byte[1];
                        System.arraycopy(tVar.BUt, tVar.BVi + 2, obj4, 0, 1);
                        Object obj5 = new byte[1];
                        System.arraycopy(tVar.BUt, (tVar.BVi + 2) + 1, obj5, 0, 1);
                        Object obj6 = new byte[tVar.BVF];
                        System.arraycopy(tVar.BUt, (((tVar.BVi + 2) + 1) + 1) + 1, obj6, 0, tVar.BVF);
                        iVar.a(j4, j5, j, emE, j2, j3, obj3, obj4, obj5, obj6, lVar.emF(), oVar.emF(), qVar.emF(), pVar.emF(), bArr7, bArr3, bArr2, bArr4, bArr5, bArr6, bArr8, bArr9, bArr10);
                        ab = 0;
                    }
                    if (ab >= 0) {
                        ab = 0;
                        break;
                    }
                    util.awF("parse 119 failed, ret=".concat(String.valueOf(ab)));
                    break;
                }
                util.awF("119 can not decrypt, ret=".concat(String.valueOf(ab)));
                break;
                break;
            case 1:
                H(bArr, i4, (this.BUo - i4) - 1);
                break;
            case 2:
                i3 = fVar.L(bArr, i4, (this.BUo - i4) - 1);
                if (i3 >= 0) {
                    this.BUC.BUH = fVar;
                    i3 = gVar.L(bArr, i4, (this.BUo - i4) - 1);
                    if (i3 >= 0) {
                        this.BUC.BUI = gVar;
                        break;
                    }
                }
                ab = i3;
                break;
            default:
                H(bArr, i4, (this.BUo - i4) - 1);
                break;
        }
        AppMethodBeat.o(96436);
        return ab;
    }
}
