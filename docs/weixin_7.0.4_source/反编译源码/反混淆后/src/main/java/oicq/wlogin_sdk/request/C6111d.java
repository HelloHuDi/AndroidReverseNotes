package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VError;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.p702a.C6106a;
import oicq.wlogin_sdk.p702a.C7399ab;
import oicq.wlogin_sdk.p702a.C7400ac;
import oicq.wlogin_sdk.p702a.C7401ad;
import oicq.wlogin_sdk.p702a.C7403af;
import oicq.wlogin_sdk.p702a.C7405ah;
import oicq.wlogin_sdk.p702a.C7406ai;
import oicq.wlogin_sdk.p702a.C7408ak;
import oicq.wlogin_sdk.p702a.C7409al;
import oicq.wlogin_sdk.p702a.C7410am;
import oicq.wlogin_sdk.p702a.C7413ap;
import oicq.wlogin_sdk.p702a.C7416d;
import oicq.wlogin_sdk.p702a.C7417e;
import oicq.wlogin_sdk.p702a.C7418f;
import oicq.wlogin_sdk.p702a.C7419g;
import oicq.wlogin_sdk.p702a.C7420h;
import oicq.wlogin_sdk.p702a.C7422j;
import oicq.wlogin_sdk.p702a.C7424l;
import oicq.wlogin_sdk.p702a.C7425m;
import oicq.wlogin_sdk.p702a.C7426n;
import oicq.wlogin_sdk.p702a.C7427o;
import oicq.wlogin_sdk.p702a.C7428p;
import oicq.wlogin_sdk.p702a.C7429q;
import oicq.wlogin_sdk.p702a.C7431s;
import oicq.wlogin_sdk.p702a.C7432t;
import oicq.wlogin_sdk.p702a.C7433u;
import oicq.wlogin_sdk.p702a.C7434v;
import oicq.wlogin_sdk.p702a.C7435w;
import oicq.wlogin_sdk.p702a.C7436x;
import oicq.wlogin_sdk.p702a.C7438z;
import oicq.wlogin_sdk.tools.C6119d;
import oicq.wlogin_sdk.tools.C6120util;
import oicq.wlogin_sdk.tools.ErrMsg;

/* renamed from: oicq.wlogin_sdk.request.d */
public class C6111d {
    protected static int BUv = 0;
    protected int BUA = 0;
    byte BUB;
    protected C6112i BUC;
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

    public C6111d() {
        AppMethodBeat.m2504i(96427);
        AppMethodBeat.m2505o(96427);
    }

    /* renamed from: a */
    public final void mo13524a(int i, int i2, long j, int i3, int i4, int i5, int i6, byte[] bArr) {
        AppMethodBeat.m2504i(96428);
        int length = bArr.length;
        int i7 = BUv + 1;
        BUv = i7;
        this.BUo = 0;
        C6120util.m9653M(this.BUt, this.BUo, 2);
        this.BUo++;
        C6120util.m9654N(this.BUt, this.BUo, (this.BUp + 2) + length);
        this.BUo += 2;
        C6120util.m9654N(this.BUt, this.BUo, i);
        this.BUo += 2;
        C6120util.m9654N(this.BUt, this.BUo, i2);
        this.BUo += 2;
        C6120util.m9654N(this.BUt, this.BUo, i7);
        this.BUo += 2;
        C6120util.m9655O(this.BUt, this.BUo, (int) j);
        this.BUo += 4;
        C6120util.m9653M(this.BUt, this.BUo, 3);
        this.BUo++;
        C6120util.m9653M(this.BUt, this.BUo, 0);
        this.BUo++;
        C6120util.m9653M(this.BUt, this.BUo, i3);
        this.BUo++;
        C6120util.m9655O(this.BUt, this.BUo, i4);
        this.BUo += 4;
        C6120util.m9655O(this.BUt, this.BUo, i5);
        this.BUo += 4;
        C6120util.m9655O(this.BUt, this.BUo, i6);
        this.BUo += 4;
        if ((this.BUo + length) + 1 > this.BUn) {
            this.BUn = ((this.BUo + length) + 1) + 128;
            byte[] bArr2 = new byte[this.BUn];
            System.arraycopy(this.BUt, 0, bArr2, 0, this.BUo);
            this.BUt = bArr2;
        }
        System.arraycopy(bArr, 0, this.BUt, this.BUo, length);
        this.BUo = length + this.BUo;
        C6120util.m9653M(this.BUt, this.BUo, 3);
        this.BUo++;
        AppMethodBeat.m2505o(96428);
    }

    /* renamed from: aa */
    public final int mo13525aa(byte[] bArr, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(96429);
        if (i <= this.BUr + 2) {
            AppMethodBeat.m2505o(96429);
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
        byte[] decrypt = C6119d.decrypt(this.BUt, i3, this.BUs, this.BUC.BUG);
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
            AppMethodBeat.m2505o(96429);
            return VError.ERROR_FACE_MODEL_INIT;
        }
        int I = mo13523I(this.BUt, this.BUr + 1, this.BUs);
        AppMethodBeat.m2505o(96429);
        return I;
    }

    public final byte[] emC() {
        AppMethodBeat.m2504i(96430);
        byte[] bArr = new byte[this.BUo];
        System.arraycopy(this.BUt, 0, bArr, 0, this.BUo);
        AppMethodBeat.m2505o(96430);
        return bArr;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: G */
    public final byte[] mo13521G(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(96431);
        byte[] bArr2 = new byte[(bArr.length + 4)];
        C6120util.m9654N(bArr2, 0, i);
        C6120util.m9654N(bArr2, 2, i2);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        bArr2 = C6119d.m9652a(bArr2, bArr2.length, this.BUC.BUG);
        byte[] bArr3 = new byte[(bArr2.length + this.BUC.BUG.length)];
        System.arraycopy(this.BUC.BUG, 0, bArr3, 0, this.BUC.BUG.length);
        System.arraycopy(bArr2, 0, bArr3, this.BUC.BUG.length, bArr2.length);
        AppMethodBeat.m2505o(96431);
        return bArr3;
    }

    /* renamed from: ab */
    public final int mo13526ab(byte[] bArr, int i) {
        this.BUB = bArr[i];
        return bArr[i] & 255;
    }

    /* renamed from: H */
    public final void mo13522H(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(96432);
        C7406ai c7406ai = new C7406ai();
        if (c7406ai.mo13501L(bArr, i, i2) >= 0) {
            ErrMsg errMsg = this.BUC.BVc;
            byte[] bArr2 = new byte[c7406ai.BVQ];
            System.arraycopy(c7406ai.BUt, c7406ai.BVi + 6, bArr2, 0, c7406ai.BVQ);
            errMsg.title = new String(bArr2);
            errMsg = this.BUC.BVc;
            bArr2 = new byte[c7406ai.BVR];
            System.arraycopy(c7406ai.BUt, (c7406ai.BVi + 8) + c7406ai.BVQ, bArr2, 0, c7406ai.BVR);
            errMsg.message = new String(bArr2);
            errMsg = this.BUC.BVc;
            bArr2 = new byte[c7406ai.BVS];
            System.arraycopy(c7406ai.BUt, ((c7406ai.BVi + 12) + c7406ai.BVQ) + c7406ai.BVR, bArr2, 0, c7406ai.BVS);
            errMsg.BVZ = new String(bArr2);
            AppMethodBeat.m2505o(96432);
            return;
        }
        this.BUC.BVc.emK();
        AppMethodBeat.m2505o(96432);
    }

    public final void emD() {
        AppMethodBeat.m2504i(96433);
        this.BUC.BVc.emK();
        AppMethodBeat.m2505o(96433);
    }

    /* renamed from: cD */
    public final byte[] mo13527cD(byte[] bArr) {
        AppMethodBeat.m2504i(96434);
        if (bArr == null) {
            AppMethodBeat.m2505o(96434);
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length + this.BUC.BUE.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.BUC.BUE, 0, bArr2, bArr.length, this.BUC.BUE.length);
        AppMethodBeat.m2505o(96434);
        return bArr2;
    }

    /* renamed from: cE */
    public final byte[] mo13528cE(byte[] bArr) {
        AppMethodBeat.m2504i(96435);
        if (bArr == null || bArr.length < 16) {
            AppMethodBeat.m2505o(96435);
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        int length = bArr2.length - 16;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        this.BUC.BUE = new byte[16];
        System.arraycopy(bArr2, length, this.BUC.BUE, 0, 16);
        AppMethodBeat.m2505o(96435);
        return bArr3;
    }

    /* renamed from: I */
    public int mo13523I(byte[] bArr, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(96436);
        C7418f c7418f = new C7418f();
        C7419g c7419g = new C7419g();
        C7431s c7431s = new C7431s();
        if (this.BUz == 2064 && this.BUA == 9) {
            i3 = 0;
        } else if (this.BUz == 2064 && this.BUA == 10) {
            i3 = 1;
        } else if (this.BUz == 2064 && this.BUA == 2) {
            i3 = 2;
        } else if (this.BUz == 2064 && this.BUA == 13) {
            i3 = 4;
        } else {
            AppMethodBeat.m2505o(96436);
            return -1012;
        }
        if (i2 < 5) {
            AppMethodBeat.m2505o(96436);
            return -1009;
        }
        int ab = mo13526ab(bArr, i + 2);
        emD();
        int i4 = i + 5;
        switch (ab) {
            case 0:
                if (i3 != 1) {
                    ab = c7431s.mo13504b(bArr, i4, (this.BUo - i4) - 1, this.BUC.BUE);
                } else if (this.BUC.BUF == null) {
                    AppMethodBeat.m2505o(96436);
                    return -1006;
                } else {
                    ab = c7431s.mo13504b(bArr, i4, (this.BUo - i4) - 1, this.BUC.BUF);
                }
                if (ab >= 0) {
                    long j = 4294967295L;
                    C6106a c7427o = new C7427o();
                    C6106a c7428p = new C7428p();
                    C6106a c7424l = new C7424l();
                    C6106a c7429q = new C7429q();
                    C7417e c7417e = new C7417e();
                    C6106a c7432t = new C7432t();
                    C7416d c7416d = new C7416d();
                    C7425m c7425m = new C7425m();
                    C7433u c7433u = new C7433u();
                    C6106a c7435w = new C7435w();
                    C6106a c7436x = new C7436x();
                    C6106a c7422j = new C7422j();
                    C6106a c7420h = new C7420h();
                    C6106a c7426n = new C7426n();
                    C6106a c7438z = new C7438z();
                    C6106a c7434v = new C7434v();
                    C6106a c7401ad = new C7401ad();
                    C6106a c7399ab = new C7399ab();
                    C6106a c7403af = new C7403af();
                    C6106a c7413ap = new C7413ap();
                    C6106a c7408ak = new C7408ak();
                    C6106a c7409al = new C7409al();
                    C6106a c7410am = new C7410am();
                    byte[] bArr2 = null;
                    byte[] bArr3 = null;
                    byte[] bArr4 = null;
                    byte[] bArr5 = null;
                    byte[] bArr6 = null;
                    byte[] bArr7 = null;
                    byte[] bArr8 = null;
                    byte[] bArr9 = null;
                    C6106a c7400ac = new C7400ac();
                    byte[] emF = c7431s.emF();
                    int length = emF.length;
                    c7427o.mo13501L(emF, 2, length);
                    c7428p.mo13501L(emF, 2, length);
                    c7424l.mo13501L(emF, 2, length);
                    c7429q.mo13501L(emF, 2, length);
                    ab = c7432t.mo13501L(emF, 2, length);
                    if (ab >= 0) {
                        byte[] emC;
                        long ag;
                        long j2;
                        long j3;
                        if (c7417e.mo13501L(emF, 2, length) >= 0) {
                            bArr7 = c7417e.emF();
                        }
                        if (c7422j.mo13501L(emF, 2, length) >= 0) {
                            C6120util.m9656a(this.BUC._context, c7422j.emF());
                        }
                        if (c7416d.mo13501L(emF, 2, length) >= 0) {
                            bArr2 = c7416d.emF();
                        }
                        if (c7425m.mo13501L(emF, 2, length) >= 0) {
                            bArr3 = c7425m.emF();
                        }
                        if (c7433u.mo13501L(emF, 2, length) >= 0) {
                            bArr4 = c7433u.emF();
                        }
                        if (c7435w.mo13501L(emF, 2, length) >= 0) {
                            bArr5 = c7435w.emF();
                        }
                        if (c7436x.mo13501L(emF, 2, length) >= 0) {
                            bArr6 = c7436x.emF();
                        }
                        if (c7438z.mo13501L(emF, 2, length) >= 0) {
                            bArr8 = new byte[c7438z.BVH];
                            System.arraycopy(c7438z.BUt, c7438z.BVi + 2, bArr8, 0, bArr8.length);
                            bArr9 = new byte[c7438z.BVI];
                            System.arraycopy(c7438z.BUt, ((c7438z.BVi + 2) + c7438z.BVH) + 2, bArr9, 0, bArr9.length);
                        }
                        if (c7409al.mo13501L(emF, 2, length) >= 0) {
                            Object obj;
                            C7420h c7420h2 = new C7420h();
                            C7426n c7426n2 = new C7426n();
                            C7410am c7410am2 = new C7410am();
                            C7405ah c7405ah = new C7405ah();
                            byte[] emF2 = c7409al.emF();
                            int length2 = emF2.length;
                            if (c7420h2.mo13501L(emF2, 2, length2) < 0) {
                                obj = null;
                            } else if (c7426n2.mo13501L(emF2, 2, length2) < 0) {
                                obj = null;
                            } else if (c7410am2.mo13501L(emF2, 2, length2) < 0) {
                                obj = null;
                            } else {
                                emF2 = c7420h2.emC();
                                emC = c7426n2.emC();
                                byte[] emC2 = c7410am2.emC();
                                byte[] cK = c7405ah.mo16219cK(this.BUC.BUN);
                                Object obj2 = new byte[((((emF2.length + 3) + emC.length) + emC2.length) + cK.length)];
                                obj2[0] = (byte) 64;
                                C6120util.m9654N(obj2, 1, 4);
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
                                C6120util.m9681jh("fast data:", C6120util.m9664cO(obj));
                            }
                        }
                        byte[][] bArr10 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{7, 0});
                        if (c7400ac.mo13501L(emF, 2, length) >= 0) {
                            bArr10[0] = c7400ac.emF();
                        }
                        ab = c7426n.mo13501L(emF, 2, length);
                        if (c7420h.mo13501L(emF, 2, length) >= 0 && ab >= 0) {
                            this.BUC.BUE = c7426n.emF();
                            this.BUC.BVd = mo13527cD(c7420h.emF());
                            bArr10[1] = (byte[]) this.BUC.BVd.clone();
                        }
                        if (c7399ab.mo13501L(emF, 2, length) >= 0) {
                            emC = new byte[c7399ab.BVK];
                            System.arraycopy(c7399ab.BUt, c7399ab.BVi + 2, emC, 0, emC.length);
                            bArr10[2] = emC;
                        }
                        if (c7403af.mo13501L(emF, 2, length) >= 0) {
                            bArr10[3] = c7403af.emF();
                        }
                        if (c7413ap.mo13501L(emF, 2, length) >= 0) {
                            bArr10[4] = c7413ap.emF();
                        }
                        if (c7408ak.mo13501L(emF, 2, length) >= 0) {
                            bArr10[5] = c7408ak.emF();
                        }
                        if (c7410am.mo13501L(emF, 2, length) >= 0) {
                            bArr10[6] = c7410am.emF();
                        }
                        if (c7434v.mo13501L(emF, 2, length) >= 0) {
                            if (this.BUC.BUL == -1) {
                                ag = (long) C6120util.m9660ag(c7434v.BUt, c7434v.BVi);
                            } else {
                                ag = this.BUC.BUL;
                            }
                            j = 4294967295L & ((long) C6120util.m9660ag(c7434v.BUt, c7434v.BVi + 4));
                            j2 = ag;
                        } else {
                            j2 = 3600;
                        }
                        if (c7401ad.mo13501L(emF, 2, length) < 0 || c7401ad.emJ() == 0) {
                            ag = 2160000;
                        } else {
                            ag = (long) c7401ad.emJ();
                        }
                        if (ag < j2) {
                            j3 = j2;
                        } else {
                            j3 = ag;
                        }
                        C6112i c6112i = this.BUC;
                        long j4 = this.BUC._uin;
                        long j5 = this.BUC.BUJ;
                        long emE = C6112i.emE();
                        j2 += C6112i.emE();
                        j3 += C6112i.emE();
                        Object obj3 = new byte[2];
                        System.arraycopy(c7432t.BUt, c7432t.BVi, obj3, 0, 2);
                        Object obj4 = new byte[1];
                        System.arraycopy(c7432t.BUt, c7432t.BVi + 2, obj4, 0, 1);
                        Object obj5 = new byte[1];
                        System.arraycopy(c7432t.BUt, (c7432t.BVi + 2) + 1, obj5, 0, 1);
                        Object obj6 = new byte[c7432t.BVF];
                        System.arraycopy(c7432t.BUt, (((c7432t.BVi + 2) + 1) + 1) + 1, obj6, 0, c7432t.BVF);
                        c6112i.mo13531a(j4, j5, j, emE, j2, j3, obj3, obj4, obj5, obj6, c7424l.emF(), c7427o.emF(), c7429q.emF(), c7428p.emF(), bArr7, bArr3, bArr2, bArr4, bArr5, bArr6, bArr8, bArr9, bArr10);
                        ab = 0;
                    }
                    if (ab >= 0) {
                        ab = 0;
                        break;
                    }
                    C6120util.awF("parse 119 failed, ret=".concat(String.valueOf(ab)));
                    break;
                }
                C6120util.awF("119 can not decrypt, ret=".concat(String.valueOf(ab)));
                break;
                break;
            case 1:
                mo13522H(bArr, i4, (this.BUo - i4) - 1);
                break;
            case 2:
                i3 = c7418f.mo13501L(bArr, i4, (this.BUo - i4) - 1);
                if (i3 >= 0) {
                    this.BUC.BUH = c7418f;
                    i3 = c7419g.mo13501L(bArr, i4, (this.BUo - i4) - 1);
                    if (i3 >= 0) {
                        this.BUC.BUI = c7419g;
                        break;
                    }
                }
                ab = i3;
                break;
            default:
                mo13522H(bArr, i4, (this.BUo - i4) - 1);
                break;
        }
        AppMethodBeat.m2505o(96436);
        return ab;
    }
}
