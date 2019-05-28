package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class y {
    private b fuD = null;
    private long fuE = 0;

    class a extends oicq.wlogin_sdk.tools.b {
        public final void t(int i, String str) {
            AppMethodBeat.i(58318);
            OnLog(i, "", str);
            AppMethodBeat.o(58318);
        }

        public final void OnLog(int i, String str, String str2) {
            AppMethodBeat.i(58319);
            if (i == 1) {
                ab.i("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                AppMethodBeat.o(58319);
            } else if (i == 2) {
                ab.d("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                AppMethodBeat.o(58319);
            } else {
                if (i == 0) {
                    ab.w("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                }
                AppMethodBeat.o(58319);
            }
        }
    }

    public y() {
        AppMethodBeat.i(58320);
        try {
            long anU = bo.anU();
            this.fuD = new b(ah.getContext(), d.vxo);
            util.BWr = 1;
            util.BWs = new a();
            ab.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", Long.valueOf(bo.gb(anU)));
            AppMethodBeat.o(58320);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WtloginMgr", e, "Failed initializing WtloginMgr.", new Object[0]);
            AppMethodBeat.o(58320);
        }
    }

    public final byte[] a(long j, String str, boolean z) {
        byte[] bArr;
        AppMethodBeat.i(58321);
        String str2 = "MicroMsg.WtloginMgr";
        String str3 = "dkwt isTestWtLogin:%b val:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(ae.giz == 10006);
        objArr[1] = Integer.valueOf(ae.giA);
        ab.d(str2, str3, objArr);
        if (ae.giz == 10006) {
            if (ae.giA == 1) {
                ae.giA = 0;
                bArr = new byte[0];
                AppMethodBeat.o(58321);
                return bArr;
            } else if (ae.giA == 2) {
                bArr = new byte[0];
                AppMethodBeat.o(58321);
                return bArr;
            }
        }
        try {
            boolean z2;
            this.fuE = j;
            bArr = z ? null : this.fuD.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_A1, "");
            str3 = "MicroMsg.WtloginMgr";
            String str4 = "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(8256);
            objArr2[1] = Long.valueOf(j);
            objArr2[2] = Boolean.valueOf(z);
            if (bo.cb(bArr)) {
                z2 = false;
            } else {
                z2 = true;
            }
            objArr2[3] = Boolean.valueOf(z2);
            ab.d(str3, str4, objArr2);
            if (bo.cb(bArr)) {
                bArr = this.fuD.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_MD5, new String(bo.anf(str), "ISO-8859-1"));
                AppMethodBeat.o(58321);
                return bArr;
            }
            AppMethodBeat.o(58321);
            return bArr;
        } catch (Exception e) {
            ab.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", e.getMessage());
            ab.e("MicroMsg.WtloginMgr", "exception:%s", bo.l(e));
            bArr = new byte[0];
            AppMethodBeat.o(58321);
            return bArr;
        }
    }

    public final boolean a(long j, byte[] bArr) {
        AppMethodBeat.i(58322);
        if (j != this.fuE) {
            ab.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            AppMethodBeat.o(58322);
            return false;
        } else if (bo.cb(bArr)) {
            ab.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
            AppMethodBeat.o(58322);
            return false;
        } else {
            try {
                int i;
                b bVar = this.fuD;
                if (bArr == null || bArr.length == 0 || bVar.BUe == null) {
                    i = -1017;
                } else {
                    util.awF("user:" + bVar.BTY._uin + " ResolveSvrData ...");
                    i = bVar.BUe.aa(bArr, bArr.length);
                    if (i == 1) {
                        bVar.oe(bVar.BTY._uin);
                    }
                    util.awF("user:" + bVar.BTY._uin + " ResolveSvrData ret=" + i);
                }
                ab.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", Integer.valueOf(bArr.length), Integer.valueOf(i));
                if (i == 0) {
                    AppMethodBeat.o(58322);
                    return true;
                }
                AppMethodBeat.o(58322);
                return false;
            } catch (Exception e) {
                ab.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", e.getMessage());
                ab.e("MicroMsg.WtloginMgr", "exception:%s", bo.l(e));
                AppMethodBeat.o(58322);
                return false;
            }
        }
    }

    public final byte[] fs(long j) {
        AppMethodBeat.i(58323);
        byte[] bArr;
        if (j != this.fuE) {
            ab.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            bArr = new byte[0];
            AppMethodBeat.o(58323);
            return bArr;
        }
        try {
            bArr = this.fuD.od(j);
            AppMethodBeat.o(58323);
            return bArr;
        } catch (Exception e) {
            ab.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", e.getMessage());
            ab.e("MicroMsg.WtloginMgr", "exception:%s", bo.l(e));
            bArr = new byte[0];
            AppMethodBeat.o(58323);
            return bArr;
        }
    }

    public final byte[] d(long j, String str) {
        AppMethodBeat.i(58324);
        byte[] bArr;
        if (j != this.fuE) {
            ab.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            bArr = new byte[0];
            AppMethodBeat.o(58324);
            return bArr;
        }
        if (bo.isNullOrNil(str)) {
            bArr = "****".getBytes();
        } else {
            bArr = str.getBytes();
        }
        try {
            bArr = this.fuD.f(j, bArr);
            AppMethodBeat.o(58324);
            return bArr;
        } catch (Exception e) {
            ab.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", e.getMessage());
            ab.e("MicroMsg.WtloginMgr", "exception:%s", bo.l(e));
            bArr = new byte[0];
            AppMethodBeat.o(58324);
            return bArr;
        }
    }

    public final byte[] ft(long j) {
        AppMethodBeat.i(58325);
        byte[] bArr;
        if (j != this.fuE) {
            ab.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            bArr = new byte[0];
            AppMethodBeat.o(58325);
            return bArr;
        }
        try {
            WUserSigInfo wUserSigInfo;
            WloginSigInfo og = this.fuD.BTY.og(j);
            if (og == null) {
                wUserSigInfo = null;
            } else {
                wUserSigInfo = new WUserSigInfo();
                wUserSigInfo.get_clone(og);
            }
            if (wUserSigInfo == null) {
                bArr = new byte[0];
                AppMethodBeat.o(58325);
                return bArr;
            }
            bArr = wUserSigInfo._A2;
            AppMethodBeat.o(58325);
            return bArr;
        } catch (Exception e) {
            ab.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", e.getMessage());
            ab.e("MicroMsg.WtloginMgr", "exception:%s", bo.l(e));
            bArr = new byte[0];
            AppMethodBeat.o(58325);
            return bArr;
        }
    }

    public final void fu(long j) {
        AppMethodBeat.i(58326);
        if (j != this.fuE) {
            ab.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            AppMethodBeat.o(58326);
            return;
        }
        try {
            this.fuD.oe(j);
            AppMethodBeat.o(58326);
        } catch (Exception e) {
            ab.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", e.getMessage());
            ab.e("MicroMsg.WtloginMgr", "exception:%s", bo.l(e));
            AppMethodBeat.o(58326);
        }
    }
}
