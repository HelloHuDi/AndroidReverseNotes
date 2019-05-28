package com.tencent.mm.ai;

import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.j;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.protocal.v;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class u extends a {
    private q ftU;
    h fug;
    i fuh;
    ak handler;

    public u(q qVar) {
        this(qVar, Looper.myLooper() == null ? new ak(Looper.getMainLooper()) : new ak());
        AppMethodBeat.i(58274);
        AppMethodBeat.o(58274);
    }

    public u(q qVar, ak akVar) {
        AppMethodBeat.i(58275);
        this.ftU = qVar;
        this.fug = new t(qVar.acF(), qVar.getType());
        this.fuh = new v(qVar.ZS(), qVar.getType());
        this.handler = akVar;
        AppMethodBeat.o(58275);
    }

    public final boolean acG() {
        AppMethodBeat.i(58276);
        boolean acG = this.ftU.acG();
        AppMethodBeat.o(58276);
        return acG;
    }

    public final int acO() {
        AppMethodBeat.i(58277);
        int hashCode = this.ftU.hashCode();
        AppMethodBeat.o(58277);
        return hashCode;
    }

    public final int acC() {
        AppMethodBeat.i(58278);
        int acC = this.ftU.acC();
        AppMethodBeat.o(58278);
        return acC;
    }

    public final h adt() {
        return this.fug;
    }

    public final i adu() {
        return this.fuh;
    }

    public final int getType() {
        AppMethodBeat.i(58279);
        int type = this.ftU.getType();
        AppMethodBeat.o(58279);
        return type;
    }

    public final String getUri() {
        AppMethodBeat.i(58280);
        String uri = this.ftU.getUri();
        AppMethodBeat.o(58280);
        return uri;
    }

    public final void qw(String str) {
    }

    public final void a(j jVar, final int i, final int i2, final String str) {
        AppMethodBeat.i(58281);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(58271);
                ab.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", Integer.valueOf(u.this.ftU.getType()), bo.dpG());
                f fVar = (f) u.this.ftU.acF();
                g gVar = (g) u.this.ftU.ZS();
                if (gVar == null) {
                    ab.f("MicroMsg.RemoteReqResp", "null auth.resp");
                    AppMethodBeat.o(58271);
                    return;
                }
                c.a.vxR.a(fVar, gVar, i, i2, str);
                AppMethodBeat.o(58271);
            }
        });
        AppMethodBeat.o(58281);
    }

    public final void a(final j jVar, final int i, final int i2) {
        AppMethodBeat.i(58282);
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
                e eVar;
                long j;
                q cn;
                AppMethodBeat.i(58272);
                int i2 = ax.ZQ().getInt("key_auth_update_version", 0);
                int i3 = i2 <= 637665332 ? com.tencent.mm.protocal.f.vxx ? 252 : 701 : com.tencent.mm.protocal.f.vxx ? 763 : 702;
                if (i2 == 0) {
                    if (bo.isNullOrNil(ah.getContext().getSharedPreferences("ticket_prefs", com.tencent.mm.compatible.util.h.Mu()).getString("_auth_ticket", ""))) {
                        i3 = com.tencent.mm.protocal.f.vxx ? 763 : 702;
                        ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
                        e.pXa.a(148, 50, 1, true);
                        i = i3;
                        ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(d.vxo), Integer.valueOf(637665332), Integer.valueOf(i));
                        if (i != 252 || i == 701) {
                            e.pXa.a(148, 48, 1, true);
                            e.pXa.a(148, com.tencent.mm.protocal.f.vxx ? 115 : 116, 1, true);
                            eVar = e.pXa;
                            if (com.tencent.mm.protocal.f.vxy) {
                                j = 118;
                            } else {
                                j = 117;
                            }
                            eVar.a(148, j, 1, true);
                        } else {
                            e.pXa.a(148, com.tencent.mm.protocal.f.vxx ? 111 : 112, 1, true);
                            e.pXa.a(148, com.tencent.mm.protocal.f.vxy ? 113 : 114, 1, true);
                        }
                        if ((u.this.ftU.getType() != 702 || u.this.ftU.getType() == 701 || u.this.ftU.getType() == 763 || u.this.ftU.getType() == 252) && ((g) u.this.ftU.ZS()).eCX == 2) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(u.this.ftU.getType()), Integer.valueOf(i), Integer.valueOf(i3));
                        cn = c.a.vxR.cn(i, i3);
                        jVar.a(cn != null ? null : new u(cn, u.this.handler), i, i2, "");
                        AppMethodBeat.o(58272);
                    }
                    e.pXa.a(148, 49, 1, true);
                    ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", bo.anv(r9.getString("_auth_ticket", "")));
                }
                i = i3;
                ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(d.vxo), Integer.valueOf(637665332), Integer.valueOf(i));
                if (i != 252) {
                }
                e.pXa.a(148, 48, 1, true);
                if (com.tencent.mm.protocal.f.vxx) {
                }
                e.pXa.a(148, com.tencent.mm.protocal.f.vxx ? 115 : 116, 1, true);
                eVar = e.pXa;
                if (com.tencent.mm.protocal.f.vxy) {
                }
                eVar.a(148, j, 1, true);
                if (u.this.ftU.getType() != 702) {
                }
                i3 = 1;
                ab.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(u.this.ftU.getType()), Integer.valueOf(i), Integer.valueOf(i3));
                cn = c.a.vxR.cn(i, i3);
                if (cn != null) {
                }
                try {
                    jVar.a(cn != null ? null : new u(cn, u.this.handler), i, i2, "");
                    AppMethodBeat.o(58272);
                } catch (RemoteException e) {
                    ab.e("MicroMsg.RemoteReqResp", "exception:%s", bo.l(e));
                    AppMethodBeat.o(58272);
                }
            }
        });
        AppMethodBeat.o(58282);
    }

    public final void a(com.tencent.mm.network.d dVar, final j jVar, final int i, final int i2) {
        AppMethodBeat.i(58283);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(58273);
                try {
                    jVar.a(new u(new l(), u.this.handler), i, i2, "");
                    AppMethodBeat.o(58273);
                } catch (RemoteException e) {
                    ab.e("MicroMsg.RemoteReqResp", "exception:%s", bo.l(e));
                    AppMethodBeat.o(58273);
                }
            }
        });
        AppMethodBeat.o(58283);
    }

    public final int adv() {
        AppMethodBeat.i(58284);
        int i = -1;
        ab.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", Integer.valueOf(getType()));
        switch (getType()) {
            case 126:
                q qVar = this.ftU;
                v.a aVar = (v.a) qVar.acF();
                b bVar = (b) qVar.ZS();
                ab.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", Integer.valueOf(126), bo.dpG());
                if (bVar.eCX != 0) {
                    ab.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(bVar.eCX));
                } else {
                    bvv bvv = bVar.vyJ.wIp;
                    if (bvv != null) {
                        byte[] bArr;
                        int i2 = bvv.vHV;
                        xu xuVar = bvv.vHF;
                        byte[] a = aa.a(bvv.vHY);
                        byte[] a2 = aa.a(bvv.vHZ);
                        byte[] a3 = aa.a(bvv.vHG);
                        String str = "MicroMsg.MMReqRespReg2";
                        String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]";
                        Object[] objArr = new Object[6];
                        objArr[0] = Integer.valueOf(xuVar.vIn.getILen());
                        objArr[1] = Integer.valueOf(xuVar.wdx);
                        objArr[2] = Integer.valueOf(a3 == null ? -1 : a3.length);
                        objArr[3] = bo.anv(bo.ca(a3));
                        objArr[4] = bo.anv(bo.ca(a));
                        objArr[5] = bo.anv(bo.ca(a2));
                        ab.d(str, str2, objArr);
                        byte[] a4 = aa.a(xuVar.vIn);
                        byte[] bArr2 = aVar.vxU;
                        byte[] bArr3 = null;
                        if (bo.cb(a4)) {
                            ab.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
                        } else {
                            String str3 = "MicroMsg.MMReqRespReg2";
                            String str4 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(a4.length);
                            objArr2[1] = bo.anv(bo.ca(a4));
                            objArr2[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                            objArr2[3] = bo.anv(bo.ca(bArr2));
                            ab.d(str3, str4, objArr2);
                            PByteArray pByteArray = new PByteArray();
                            int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(xuVar.wdx, a4, bArr2, pByteArray, 0);
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
                            objArr[2] = bo.anv(bo.ca(bArr3));
                            ab.i(str, str2, objArr);
                        }
                        if (bArr3 != null) {
                            bArr = bArr3;
                        } else {
                            bArr = new byte[0];
                        }
                        bVar.vxW = bArr;
                        if ((i2 & 4) != 0) {
                            ab.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
                            if (bo.cb(bArr3)) {
                                ab.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
                                bVar.b(new byte[0], a, a2);
                                bVar.eCX = 2;
                            } else {
                                bArr3 = MMProtocalJni.aesDecrypt(a3, bArr3);
                                String str5 = "MicroMsg.MMReqRespReg2";
                                String str6 = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                                Object[] objArr3 = new Object[4];
                                objArr3[0] = Integer.valueOf(a3 == null ? -1 : a3.length);
                                objArr3[1] = bo.ca(a3);
                                objArr3[2] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                                objArr3[3] = bo.anv(bo.ca(bArr3));
                                ab.d(str5, str6, objArr3);
                                if (bo.cb(bArr3)) {
                                    ab.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
                                    bVar.b(new byte[0], a, a2);
                                    bVar.eCX = 2;
                                } else {
                                    ab.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", bo.anv(bo.ca(bArr3)));
                                    bVar.b(bArr3, a, a2);
                                    bVar.eCX = 1;
                                }
                            }
                        } else {
                            ab.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
                            bVar.b(a3, a, a2);
                            bVar.eCX = 1;
                        }
                    } else {
                        ab.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
                        bVar.b(new byte[0], new byte[0], new byte[0]);
                        bVar.eCX = 2;
                    }
                }
                i = bVar.eCX;
                break;
            case 252:
            case 701:
            case 702:
            case 763:
                i = ax.a(this.ftU);
                break;
        }
        AppMethodBeat.o(58284);
        return i;
    }

    public final int acB() {
        AppMethodBeat.i(58285);
        int acB = this.ftU.acB();
        AppMethodBeat.o(58285);
        return acB;
    }

    public final boolean acH() {
        AppMethodBeat.i(58286);
        boolean acH = this.ftU.acH();
        AppMethodBeat.o(58286);
        return acH;
    }
}
