package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p238a.p240b.C1661e;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.p499b.C34829d;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C7251ar;
import com.tencent.p177mm.protocal.protobuf.C7259fv;
import com.tencent.p177mm.protocal.protobuf.bdv;
import com.tencent.p177mm.protocal.protobuf.cjj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;

/* renamed from: com.tencent.mm.model.aa */
public final class C32773aa {
    /* JADX WARNING: Removed duplicated region for block: B:36:0x030a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m53535a(cjj cjj, boolean z) {
        AppMethodBeat.m2504i(123394);
        int i = cjj.xic;
        String str = "MicroMsg.HandleAuthResponse";
        String str2 = "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(cjj.xid == null ? -1 : cjj.xid.vHU);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = cjj.xid;
        objArr[3] = cjj.xie;
        objArr[4] = cjj.xif;
        objArr[5] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        int i2 = 0;
        if ((i & 1) == 0 || cjj.xid == null) {
            C4990ab.m7420w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
        } else {
            i2 = cjj.xid.luF;
        }
        C1720g.m3537RQ();
        C1720g.m3544jR(i2);
        C1661e.m3356Sq();
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        Ry.set(256, Boolean.FALSE);
        if ((i & 1) != 0) {
            if (cjj.xid.vHU > 0) {
                Ry.set(C5127a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf((long) cjj.xid.vHU));
                Ry.set(C5127a.USERINFO_UPDATE_UPDATE_TIME_LONG, Long.valueOf(C5046bo.anT()));
                Ry.set(C5127a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf((long) C7243d.vxo));
                C4990ab.m7417i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", Integer.valueOf(cjj.xid.vHU), Boolean.valueOf(z));
                if (z) {
                    long j;
                    C7053e c7053e = C7053e.pXa;
                    if (cjj.xid.vHU == 2) {
                        j = 19;
                    } else {
                        j = 41;
                    }
                    c7053e.mo8378a(148, j, 1, true);
                } else {
                    C7053e.pXa.mo8378a(148, cjj.xid.vHU == 2 ? 10 : 11, 1, true);
                }
            } else {
                Ry.set(C5127a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf((long) cjj.xid.vHU));
                Ry.set(C5127a.USERINFO_UPDATE_UPDATE_TIME_LONG, Long.valueOf(C5046bo.anT()));
                Ry.set(C5127a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf(0));
            }
        }
        if ((i & 2) != 0) {
            C7251ar c7251ar = cjj.xie;
            C4990ab.m7417i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", C1183p.getString(c7251ar.vCf), Integer.valueOf(c7251ar.jBT), c7251ar.jBB, c7251ar.jCH, c7251ar.vCg, c7251ar.vCh, c7251ar.guS, Integer.valueOf(c7251ar.vCi), Integer.valueOf(c7251ar.vCj), c7251ar.vCk, Integer.valueOf(c7251ar.vCl), c7251ar.vCm, c7251ar.vCm, Integer.valueOf(c7251ar.vCo), c7251ar.vCp);
            if (!z) {
                Ry.set(52, Integer.valueOf(c7251ar.vCj));
            }
            Ry.set(9, Integer.valueOf(c7251ar.vCf));
            Ry.set(7, Integer.valueOf(c7251ar.jBT));
            Ry.set(2, c7251ar.jBB);
            Ry.set(4, c7251ar.jCH);
            Ry.set(5, c7251ar.vCg);
            Ry.set(6, c7251ar.vCh);
            Ry.set(42, c7251ar.guS);
            Ry.set(34, Integer.valueOf(c7251ar.vCi));
            C1720g.m3536RP().mo5240Rz().apV(c7251ar.vCk);
            Ry.set(64, Integer.valueOf(c7251ar.vCl));
            Ry.set(21, c7251ar.vCm);
            Ry.set(22, c7251ar.vCm);
            Ry.set(17, Integer.valueOf(c7251ar.vCo));
            C6665av.fly.mo14897ak("login_weixin_username", c7251ar.jBB);
            C6665av.fly.mo14897ak("last_login_nick_name", c7251ar.jCH);
            C6665av.fly.mo14898c(c7251ar.vCh, c7251ar.vCf, c7251ar.vCg);
        } else {
            C4990ab.m7420w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
        }
        boolean z2 = false;
        if ((i & 1) != 0) {
            boolean a;
            C7259fv c7259fv = cjj.xid;
            Object obj = c7259fv.vHO;
            String cd = C5046bo.m7543cd(C1946aa.m4150a(c7259fv.vHP));
            C4990ab.m7417i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", c7259fv.vHS, Integer.valueOf(c7259fv.vHT), Integer.valueOf(c7259fv.vHU), Integer.valueOf(c7259fv.vHV), C5046bo.anv(obj), C5046bo.anv(cd), c7259fv.vCp);
            int i3 = c7259fv.vHI;
            C1183p c1183p = new C1183p(C5046bo.m7567h((Integer) Ry.get(9, Integer.valueOf(0))));
            str = "MicroMsg.HandleAuthResponse";
            str2 = "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = c1183p;
            if (c7259fv.vHJ == null) {
                i2 = -1;
            } else {
                i2 = c7259fv.vHJ.getILen();
            }
            objArr[2] = Integer.valueOf(i2);
            C4990ab.m7417i(str, str2, objArr);
            if (i3 != 0) {
                Object cd2;
                if (i3 == 1) {
                    C7053e.pXa.mo8378a(148, 20, 1, false);
                    a = C1720g.m3534RN().mo5158QR().mo4502a(c1183p.longValue(), C1946aa.m4150a(c7259fv.vHJ));
                    C4990ab.m7417i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", Integer.valueOf(r3.length));
                    cd2 = C5046bo.m7543cd(C1720g.m3534RN().mo5158QR().mo4506ft(c1183p.longValue()));
                    Ry.set(-1535680990, obj);
                    Ry.set(46, (Object) cd);
                    Ry.set(72, cd2);
                    Ry.set(29, c7259fv.vCp);
                } else if (i3 == 2) {
                    C7053e.pXa.mo8378a(148, 21, 1, false);
                    C1720g.m3534RN().mo5158QR().mo4507fu(c1183p.longValue());
                    Object cd3 = C5046bo.m7543cd(C1720g.m3534RN().mo5158QR().mo4506ft(c1183p.longValue()));
                    Ry.set(-1535680990, obj);
                    Ry.set(46, (Object) cd);
                    Ry.set(72, cd3);
                    Ry.set(29, c7259fv.vCp);
                    a = false;
                } else {
                    C4990ab.m7417i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", Integer.valueOf(i3));
                }
                C4990ab.m7417i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", Integer.valueOf(i3));
                if (c7259fv.vHK != null) {
                    cd2 = C5046bo.m7543cd(C1946aa.m4150a(c7259fv.vHK.vMb));
                    if (cd2 != null && cd2.length() > 0) {
                        Ry.set(47, cd2);
                        C1720g.m3536RP().eJH.set(18, cd2);
                    }
                    C4990ab.m7417i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", C5046bo.anv(cd2));
                }
                z2 = a;
            }
            a = false;
            C4990ab.m7417i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", Integer.valueOf(i3));
            if (c7259fv.vHK != null) {
            }
            z2 = a;
        } else {
            C4990ab.m7420w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
            C7053e.pXa.mo8378a(148, 22, 1, false);
        }
        if ((i & 4) != 0) {
            C7053e.pXa.mo8378a(148, 23, 1, false);
            bdv bdv = cjj.xif;
            C7484ax.m12918a(false, bdv.vLL, bdv.vLM, bdv.vLK);
        } else {
            C4990ab.m7420w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
        }
        if (z) {
            int i4 = 4;
            String Yz = C1853r.m3846Yz();
            if (z2) {
                i4 = 1;
                Yz = C1853r.m3845Yy();
            }
            C4990ab.m7417i("MicroMsg.HandleAuthResponse", "loginType %s", Integer.valueOf(i4));
            C34829d.m57192u(1, i4, Yz);
        }
        Ry.set(3, (Object) "");
        Ry.set(19, (Object) "");
        Ry.dsb();
        C1720g.m3536RP().eJH.setInt(46, 0);
        C1810a.m3718XG();
        AppMethodBeat.m2505o(123394);
    }
}
