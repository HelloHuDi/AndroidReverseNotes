package com.tencent.p177mm.p183ai;

import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.network.C1899d;
import com.tencent.p177mm.network.C1915j;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.network.C1930r.C1931a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4816h;
import com.tencent.p177mm.protocal.C4819i;
import com.tencent.p177mm.protocal.C4824j.C4823c.C4822a;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4842v.C4843a;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.protobuf.C7287xu;
import com.tencent.p177mm.protocal.protobuf.bvv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ai.u */
public final class C7476u extends C1931a {
    private C1929q ftU;
    C4816h fug;
    C4819i fuh;
    C7306ak handler;

    public C7476u(C1929q c1929q) {
        this(c1929q, Looper.myLooper() == null ? new C7306ak(Looper.getMainLooper()) : new C7306ak());
        AppMethodBeat.m2504i(58274);
        AppMethodBeat.m2505o(58274);
    }

    public C7476u(C1929q c1929q, C7306ak c7306ak) {
        AppMethodBeat.m2504i(58275);
        this.ftU = c1929q;
        this.fug = new C7475t(c1929q.acF(), c1929q.getType());
        this.fuh = new C7477v(c1929q.mo5618ZS(), c1929q.getType());
        this.handler = c7306ak;
        AppMethodBeat.m2505o(58275);
    }

    public final boolean acG() {
        AppMethodBeat.m2504i(58276);
        boolean acG = this.ftU.acG();
        AppMethodBeat.m2505o(58276);
        return acG;
    }

    public final int acO() {
        AppMethodBeat.m2504i(58277);
        int hashCode = this.ftU.hashCode();
        AppMethodBeat.m2505o(58277);
        return hashCode;
    }

    public final int acC() {
        AppMethodBeat.m2504i(58278);
        int acC = this.ftU.acC();
        AppMethodBeat.m2505o(58278);
        return acC;
    }

    public final C4816h adt() {
        return this.fug;
    }

    public final C4819i adu() {
        return this.fuh;
    }

    public final int getType() {
        AppMethodBeat.m2504i(58279);
        int type = this.ftU.getType();
        AppMethodBeat.m2505o(58279);
        return type;
    }

    public final String getUri() {
        AppMethodBeat.m2504i(58280);
        String uri = this.ftU.getUri();
        AppMethodBeat.m2505o(58280);
        return uri;
    }

    /* renamed from: qw */
    public final void mo5639qw(String str) {
    }

    /* renamed from: a */
    public final void mo5628a(C1915j c1915j, final int i, final int i2, final String str) {
        AppMethodBeat.m2504i(58281);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(58271);
                C4990ab.m7411d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", Integer.valueOf(C7476u.this.ftU.getType()), C5046bo.dpG());
                C4825f c4825f = (C4825f) C7476u.this.ftU.acF();
                C4826g c4826g = (C4826g) C7476u.this.ftU.mo5618ZS();
                if (c4826g == null) {
                    C4990ab.m7414f("MicroMsg.RemoteReqResp", "null auth.resp");
                    AppMethodBeat.m2505o(58271);
                    return;
                }
                C4822a.vxR.mo9984a(c4825f, c4826g, i, i2, str);
                AppMethodBeat.m2505o(58271);
            }
        });
        AppMethodBeat.m2505o(58281);
    }

    /* renamed from: a */
    public final void mo5627a(final C1915j c1915j, final int i, final int i2) {
        AppMethodBeat.m2504i(58282);
        this.handler.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0170  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x009a  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x0174  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00a5  */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x0196  */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x0123  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                int i;
                C7053e c7053e;
                long j;
                C1929q cn;
                AppMethodBeat.m2504i(58272);
                int i2 = C7484ax.m12915ZQ().getInt("key_auth_update_version", 0);
                int i3 = i2 <= 637665332 ? C4815f.vxx ? 252 : 701 : C4815f.vxx ? 763 : 702;
                if (i2 == 0) {
                    if (C5046bo.isNullOrNil(C4996ah.getContext().getSharedPreferences("ticket_prefs", C1448h.m3078Mu()).getString("_auth_ticket", ""))) {
                        i3 = C4815f.vxx ? 763 : 702;
                        C4990ab.m7416i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
                        C7053e.pXa.mo8378a(148, 50, 1, true);
                        i = i3;
                        C4990ab.m7417i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(C7243d.vxo), Integer.valueOf(637665332), Integer.valueOf(i));
                        if (i != 252 || i == 701) {
                            C7053e.pXa.mo8378a(148, 48, 1, true);
                            C7053e.pXa.mo8378a(148, C4815f.vxx ? 115 : 116, 1, true);
                            c7053e = C7053e.pXa;
                            if (C4815f.vxy) {
                                j = 118;
                            } else {
                                j = 117;
                            }
                            c7053e.mo8378a(148, j, 1, true);
                        } else {
                            C7053e.pXa.mo8378a(148, C4815f.vxx ? 111 : 112, 1, true);
                            C7053e.pXa.mo8378a(148, C4815f.vxy ? 113 : 114, 1, true);
                        }
                        if ((C7476u.this.ftU.getType() != 702 || C7476u.this.ftU.getType() == 701 || C7476u.this.ftU.getType() == 763 || C7476u.this.ftU.getType() == 252) && ((C4826g) C7476u.this.ftU.mo5618ZS()).eCX == 2) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        C4990ab.m7417i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(C7476u.this.ftU.getType()), Integer.valueOf(i), Integer.valueOf(i3));
                        cn = C4822a.vxR.mo9985cn(i, i3);
                        c1915j.mo5602a(cn != null ? null : new C7476u(cn, C7476u.this.handler), i, i2, "");
                        AppMethodBeat.m2505o(58272);
                    }
                    C7053e.pXa.mo8378a(148, 49, 1, true);
                    C4990ab.m7417i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", C5046bo.anv(r9.getString("_auth_ticket", "")));
                }
                i = i3;
                C4990ab.m7417i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(C7243d.vxo), Integer.valueOf(637665332), Integer.valueOf(i));
                if (i != 252) {
                }
                C7053e.pXa.mo8378a(148, 48, 1, true);
                if (C4815f.vxx) {
                }
                C7053e.pXa.mo8378a(148, C4815f.vxx ? 115 : 116, 1, true);
                c7053e = C7053e.pXa;
                if (C4815f.vxy) {
                }
                c7053e.mo8378a(148, j, 1, true);
                if (C7476u.this.ftU.getType() != 702) {
                }
                i3 = 1;
                C4990ab.m7417i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(C7476u.this.ftU.getType()), Integer.valueOf(i), Integer.valueOf(i3));
                cn = C4822a.vxR.mo9985cn(i, i3);
                if (cn != null) {
                }
                try {
                    c1915j.mo5602a(cn != null ? null : new C7476u(cn, C7476u.this.handler), i, i2, "");
                    AppMethodBeat.m2505o(58272);
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.RemoteReqResp", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(58272);
                }
            }
        });
        AppMethodBeat.m2505o(58282);
    }

    /* renamed from: a */
    public final void mo5626a(C1899d c1899d, final C1915j c1915j, final int i, final int i2) {
        AppMethodBeat.m2504i(58283);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(58273);
                try {
                    c1915j.mo5602a(new C7476u(new C7473l(), C7476u.this.handler), i, i2, "");
                    AppMethodBeat.m2505o(58273);
                } catch (RemoteException e) {
                    C4990ab.m7413e("MicroMsg.RemoteReqResp", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(58273);
                }
            }
        });
        AppMethodBeat.m2505o(58283);
    }

    public final int adv() {
        AppMethodBeat.m2504i(58284);
        int i = -1;
        C4990ab.m7411d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", Integer.valueOf(getType()));
        switch (getType()) {
            case 126:
                C1929q c1929q = this.ftU;
                C4843a c4843a = (C4843a) c1929q.acF();
                C4844b c4844b = (C4844b) c1929q.mo5618ZS();
                C4990ab.m7417i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", Integer.valueOf(126), C5046bo.dpG());
                if (c4844b.eCX != 0) {
                    C4990ab.m7411d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(c4844b.eCX));
                } else {
                    bvv bvv = c4844b.vyJ.wIp;
                    if (bvv != null) {
                        byte[] bArr;
                        int i2 = bvv.vHV;
                        C7287xu c7287xu = bvv.vHF;
                        byte[] a = C1946aa.m4150a(bvv.vHY);
                        byte[] a2 = C1946aa.m4150a(bvv.vHZ);
                        byte[] a3 = C1946aa.m4150a(bvv.vHG);
                        String str = "MicroMsg.MMReqRespReg2";
                        String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]";
                        Object[] objArr = new Object[6];
                        objArr[0] = Integer.valueOf(c7287xu.vIn.getILen());
                        objArr[1] = Integer.valueOf(c7287xu.wdx);
                        objArr[2] = Integer.valueOf(a3 == null ? -1 : a3.length);
                        objArr[3] = C5046bo.anv(C5046bo.m7539ca(a3));
                        objArr[4] = C5046bo.anv(C5046bo.m7539ca(a));
                        objArr[5] = C5046bo.anv(C5046bo.m7539ca(a2));
                        C4990ab.m7411d(str, str2, objArr);
                        byte[] a4 = C1946aa.m4150a(c7287xu.vIn);
                        byte[] bArr2 = c4843a.vxU;
                        byte[] bArr3 = null;
                        if (C5046bo.m7540cb(a4)) {
                            C4990ab.m7420w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
                        } else {
                            String str3 = "MicroMsg.MMReqRespReg2";
                            String str4 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(a4.length);
                            objArr2[1] = C5046bo.anv(C5046bo.m7539ca(a4));
                            objArr2[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                            objArr2[3] = C5046bo.anv(C5046bo.m7539ca(bArr2));
                            C4990ab.m7411d(str3, str4, objArr2);
                            PByteArray pByteArray = new PByteArray();
                            int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(c7287xu.wdx, a4, bArr2, pByteArray, 0);
                            bArr3 = pByteArray.value;
                            str = "MicroMsg.MMReqRespReg2";
                            str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                            if (bArr3 == null) {
                                i = -1;
                            } else {
                                i = bArr3.length;
                            }
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = C5046bo.anv(C5046bo.m7539ca(bArr3));
                            C4990ab.m7417i(str, str2, objArr);
                        }
                        if (bArr3 != null) {
                            bArr = bArr3;
                        } else {
                            bArr = new byte[0];
                        }
                        c4844b.vxW = bArr;
                        if ((i2 & 4) != 0) {
                            C4990ab.m7410d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
                            if (C5046bo.m7540cb(bArr3)) {
                                C4990ab.m7410d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
                                c4844b.mo10005b(new byte[0], a, a2);
                                c4844b.eCX = 2;
                            } else {
                                bArr3 = MMProtocalJni.aesDecrypt(a3, bArr3);
                                String str5 = "MicroMsg.MMReqRespReg2";
                                String str6 = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                                Object[] objArr3 = new Object[4];
                                objArr3[0] = Integer.valueOf(a3 == null ? -1 : a3.length);
                                objArr3[1] = C5046bo.m7539ca(a3);
                                objArr3[2] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                                objArr3[3] = C5046bo.anv(C5046bo.m7539ca(bArr3));
                                C4990ab.m7411d(str5, str6, objArr3);
                                if (C5046bo.m7540cb(bArr3)) {
                                    C4990ab.m7410d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
                                    c4844b.mo10005b(new byte[0], a, a2);
                                    c4844b.eCX = 2;
                                } else {
                                    C4990ab.m7411d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", C5046bo.anv(C5046bo.m7539ca(bArr3)));
                                    c4844b.mo10005b(bArr3, a, a2);
                                    c4844b.eCX = 1;
                                }
                            }
                        } else {
                            C4990ab.m7410d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
                            c4844b.mo10005b(a3, a, a2);
                            c4844b.eCX = 1;
                        }
                    } else {
                        C4990ab.m7410d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
                        c4844b.mo10005b(new byte[0], new byte[0], new byte[0]);
                        c4844b.eCX = 2;
                    }
                }
                i = c4844b.eCX;
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                i = C7484ax.m12916a(this.ftU);
                break;
        }
        AppMethodBeat.m2505o(58284);
        return i;
    }

    public final int acB() {
        AppMethodBeat.m2504i(58285);
        int acB = this.ftU.acB();
        AppMethodBeat.m2505o(58285);
        return acB;
    }

    public final boolean acH() {
        AppMethodBeat.m2504i(58286);
        boolean acH = this.ftU.acH();
        AppMethodBeat.m2505o(58286);
        return acH;
    }
}
