package com.tencent.p177mm.p183ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import oicq.wlogin_sdk.request.C6109b;
import oicq.wlogin_sdk.request.C6109b.C6108a;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.C6117b;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: com.tencent.mm.ai.y */
public final class C1231y {
    private C6109b fuD = null;
    private long fuE = 0;

    /* renamed from: com.tencent.mm.ai.y$a */
    class C1232a extends C6117b {
        /* renamed from: t */
        public final void mo4509t(int i, String str) {
            AppMethodBeat.m2504i(58318);
            OnLog(i, "", str);
            AppMethodBeat.m2505o(58318);
        }

        public final void OnLog(int i, String str, String str2) {
            AppMethodBeat.m2504i(58319);
            if (i == 1) {
                C4990ab.m7417i("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                AppMethodBeat.m2505o(58319);
            } else if (i == 2) {
                C4990ab.m7411d("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                AppMethodBeat.m2505o(58319);
            } else {
                if (i == 0) {
                    C4990ab.m7421w("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
                }
                AppMethodBeat.m2505o(58319);
            }
        }
    }

    public C1231y() {
        AppMethodBeat.m2504i(58320);
        try {
            long anU = C5046bo.anU();
            this.fuD = new C6109b(C4996ah.getContext(), C7243d.vxo);
            C6120util.BWr = 1;
            C6120util.BWs = new C1232a();
            C4990ab.m7411d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", Long.valueOf(C5046bo.m7566gb(anU)));
            AppMethodBeat.m2505o(58320);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WtloginMgr", e, "Failed initializing WtloginMgr.", new Object[0]);
            AppMethodBeat.m2505o(58320);
        }
    }

    /* renamed from: a */
    public final byte[] mo4503a(long j, String str, boolean z) {
        byte[] bArr;
        AppMethodBeat.m2504i(58321);
        String str2 = "MicroMsg.WtloginMgr";
        String str3 = "dkwt isTestWtLogin:%b val:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(C1947ae.giz == 10006);
        objArr[1] = Integer.valueOf(C1947ae.giA);
        C4990ab.m7411d(str2, str3, objArr);
        if (C1947ae.giz == 10006) {
            if (C1947ae.giA == 1) {
                C1947ae.giA = 0;
                bArr = new byte[0];
                AppMethodBeat.m2505o(58321);
                return bArr;
            } else if (C1947ae.giA == 2) {
                bArr = new byte[0];
                AppMethodBeat.m2505o(58321);
                return bArr;
            }
        }
        try {
            boolean z2;
            this.fuE = j;
            bArr = z ? null : this.fuD.mo13514a(j, C6108a.USER_WITH_A1, "");
            str3 = "MicroMsg.WtloginMgr";
            String str4 = "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(8256);
            objArr2[1] = Long.valueOf(j);
            objArr2[2] = Boolean.valueOf(z);
            if (C5046bo.m7540cb(bArr)) {
                z2 = false;
            } else {
                z2 = true;
            }
            objArr2[3] = Boolean.valueOf(z2);
            C4990ab.m7411d(str3, str4, objArr2);
            if (C5046bo.m7540cb(bArr)) {
                bArr = this.fuD.mo13514a(j, C6108a.USER_WITH_MD5, new String(C5046bo.anf(str), "ISO-8859-1"));
                AppMethodBeat.m2505o(58321);
                return bArr;
            }
            AppMethodBeat.m2505o(58321);
            return bArr;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", e.getMessage());
            C4990ab.m7413e("MicroMsg.WtloginMgr", "exception:%s", C5046bo.m7574l(e));
            bArr = new byte[0];
            AppMethodBeat.m2505o(58321);
            return bArr;
        }
    }

    /* renamed from: a */
    public final boolean mo4502a(long j, byte[] bArr) {
        AppMethodBeat.m2504i(58322);
        if (j != this.fuE) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            AppMethodBeat.m2505o(58322);
            return false;
        } else if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
            AppMethodBeat.m2505o(58322);
            return false;
        } else {
            try {
                int i;
                C6109b c6109b = this.fuD;
                if (bArr == null || bArr.length == 0 || c6109b.BUe == null) {
                    i = -1017;
                } else {
                    C6120util.awF("user:" + c6109b.BTY._uin + " ResolveSvrData ...");
                    i = c6109b.BUe.mo13525aa(bArr, bArr.length);
                    if (i == 1) {
                        c6109b.mo13517oe(c6109b.BTY._uin);
                    }
                    C6120util.awF("user:" + c6109b.BTY._uin + " ResolveSvrData ret=" + i);
                }
                C4990ab.m7411d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", Integer.valueOf(bArr.length), Integer.valueOf(i));
                if (i == 0) {
                    AppMethodBeat.m2505o(58322);
                    return true;
                }
                AppMethodBeat.m2505o(58322);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", e.getMessage());
                C4990ab.m7413e("MicroMsg.WtloginMgr", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(58322);
                return false;
            }
        }
    }

    /* renamed from: fs */
    public final byte[] mo4505fs(long j) {
        AppMethodBeat.m2504i(58323);
        byte[] bArr;
        if (j != this.fuE) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            bArr = new byte[0];
            AppMethodBeat.m2505o(58323);
            return bArr;
        }
        try {
            bArr = this.fuD.mo13516od(j);
            AppMethodBeat.m2505o(58323);
            return bArr;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", e.getMessage());
            C4990ab.m7413e("MicroMsg.WtloginMgr", "exception:%s", C5046bo.m7574l(e));
            bArr = new byte[0];
            AppMethodBeat.m2505o(58323);
            return bArr;
        }
    }

    /* renamed from: d */
    public final byte[] mo4504d(long j, String str) {
        AppMethodBeat.m2504i(58324);
        byte[] bArr;
        if (j != this.fuE) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            bArr = new byte[0];
            AppMethodBeat.m2505o(58324);
            return bArr;
        }
        if (C5046bo.isNullOrNil(str)) {
            bArr = "****".getBytes();
        } else {
            bArr = str.getBytes();
        }
        try {
            bArr = this.fuD.mo13515f(j, bArr);
            AppMethodBeat.m2505o(58324);
            return bArr;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", e.getMessage());
            C4990ab.m7413e("MicroMsg.WtloginMgr", "exception:%s", C5046bo.m7574l(e));
            bArr = new byte[0];
            AppMethodBeat.m2505o(58324);
            return bArr;
        }
    }

    /* renamed from: ft */
    public final byte[] mo4506ft(long j) {
        AppMethodBeat.m2504i(58325);
        byte[] bArr;
        if (j != this.fuE) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            bArr = new byte[0];
            AppMethodBeat.m2505o(58325);
            return bArr;
        }
        try {
            WUserSigInfo wUserSigInfo;
            WloginSigInfo og = this.fuD.BTY.mo13533og(j);
            if (og == null) {
                wUserSigInfo = null;
            } else {
                wUserSigInfo = new WUserSigInfo();
                wUserSigInfo.get_clone(og);
            }
            if (wUserSigInfo == null) {
                bArr = new byte[0];
                AppMethodBeat.m2505o(58325);
                return bArr;
            }
            bArr = wUserSigInfo._A2;
            AppMethodBeat.m2505o(58325);
            return bArr;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", e.getMessage());
            C4990ab.m7413e("MicroMsg.WtloginMgr", "exception:%s", C5046bo.m7574l(e));
            bArr = new byte[0];
            AppMethodBeat.m2505o(58325);
            return bArr;
        }
    }

    /* renamed from: fu */
    public final void mo4507fu(long j) {
        AppMethodBeat.m2504i(58326);
        if (j != this.fuE) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.fuE), Long.valueOf(j));
            AppMethodBeat.m2505o(58326);
            return;
        }
        try {
            this.fuD.mo13517oe(j);
            AppMethodBeat.m2505o(58326);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", e.getMessage());
            C4990ab.m7413e("MicroMsg.WtloginMgr", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58326);
        }
    }
}
