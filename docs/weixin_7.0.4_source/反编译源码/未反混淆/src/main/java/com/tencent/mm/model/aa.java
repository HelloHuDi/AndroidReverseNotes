package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a.b.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class aa {
    /* JADX WARNING: Removed duplicated region for block: B:36:0x030a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(cjj cjj, boolean z) {
        AppMethodBeat.i(123394);
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
        ab.i(str, str2, objArr);
        int i2 = 0;
        if ((i & 1) == 0 || cjj.xid == null) {
            ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
        } else {
            i2 = cjj.xid.luF;
        }
        g.RQ();
        g.jR(i2);
        e.Sq();
        z Ry = g.RP().Ry();
        Ry.set(256, Boolean.FALSE);
        if ((i & 1) != 0) {
            if (cjj.xid.vHU > 0) {
                Ry.set(a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf((long) cjj.xid.vHU));
                Ry.set(a.USERINFO_UPDATE_UPDATE_TIME_LONG, Long.valueOf(bo.anT()));
                Ry.set(a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf((long) d.vxo));
                ab.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", Integer.valueOf(cjj.xid.vHU), Boolean.valueOf(z));
                if (z) {
                    long j;
                    com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.pXa;
                    if (cjj.xid.vHU == 2) {
                        j = 19;
                    } else {
                        j = 41;
                    }
                    eVar.a(148, j, 1, true);
                } else {
                    com.tencent.mm.plugin.report.e.pXa.a(148, cjj.xid.vHU == 2 ? 10 : 11, 1, true);
                }
            } else {
                Ry.set(a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf((long) cjj.xid.vHU));
                Ry.set(a.USERINFO_UPDATE_UPDATE_TIME_LONG, Long.valueOf(bo.anT()));
                Ry.set(a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf(0));
            }
        }
        if ((i & 2) != 0) {
            ar arVar = cjj.xie;
            ab.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", p.getString(arVar.vCf), Integer.valueOf(arVar.jBT), arVar.jBB, arVar.jCH, arVar.vCg, arVar.vCh, arVar.guS, Integer.valueOf(arVar.vCi), Integer.valueOf(arVar.vCj), arVar.vCk, Integer.valueOf(arVar.vCl), arVar.vCm, arVar.vCm, Integer.valueOf(arVar.vCo), arVar.vCp);
            if (!z) {
                Ry.set(52, Integer.valueOf(arVar.vCj));
            }
            Ry.set(9, Integer.valueOf(arVar.vCf));
            Ry.set(7, Integer.valueOf(arVar.jBT));
            Ry.set(2, arVar.jBB);
            Ry.set(4, arVar.jCH);
            Ry.set(5, arVar.vCg);
            Ry.set(6, arVar.vCh);
            Ry.set(42, arVar.guS);
            Ry.set(34, Integer.valueOf(arVar.vCi));
            g.RP().Rz().apV(arVar.vCk);
            Ry.set(64, Integer.valueOf(arVar.vCl));
            Ry.set(21, arVar.vCm);
            Ry.set(22, arVar.vCm);
            Ry.set(17, Integer.valueOf(arVar.vCo));
            av.fly.ak("login_weixin_username", arVar.jBB);
            av.fly.ak("last_login_nick_name", arVar.jCH);
            av.fly.c(arVar.vCh, arVar.vCf, arVar.vCg);
        } else {
            ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
        }
        boolean z2 = false;
        if ((i & 1) != 0) {
            boolean a;
            fv fvVar = cjj.xid;
            Object obj = fvVar.vHO;
            String cd = bo.cd(com.tencent.mm.platformtools.aa.a(fvVar.vHP));
            ab.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", fvVar.vHS, Integer.valueOf(fvVar.vHT), Integer.valueOf(fvVar.vHU), Integer.valueOf(fvVar.vHV), bo.anv(obj), bo.anv(cd), fvVar.vCp);
            int i3 = fvVar.vHI;
            p pVar = new p(bo.h((Integer) Ry.get(9, Integer.valueOf(0))));
            str = "MicroMsg.HandleAuthResponse";
            str2 = "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = pVar;
            if (fvVar.vHJ == null) {
                i2 = -1;
            } else {
                i2 = fvVar.vHJ.getILen();
            }
            objArr[2] = Integer.valueOf(i2);
            ab.i(str, str2, objArr);
            if (i3 != 0) {
                Object cd2;
                if (i3 == 1) {
                    com.tencent.mm.plugin.report.e.pXa.a(148, 20, 1, false);
                    a = g.RN().QR().a(pVar.longValue(), com.tencent.mm.platformtools.aa.a(fvVar.vHJ));
                    ab.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", Integer.valueOf(r3.length));
                    cd2 = bo.cd(g.RN().QR().ft(pVar.longValue()));
                    Ry.set(-1535680990, obj);
                    Ry.set(46, (Object) cd);
                    Ry.set(72, cd2);
                    Ry.set(29, fvVar.vCp);
                } else if (i3 == 2) {
                    com.tencent.mm.plugin.report.e.pXa.a(148, 21, 1, false);
                    g.RN().QR().fu(pVar.longValue());
                    Object cd3 = bo.cd(g.RN().QR().ft(pVar.longValue()));
                    Ry.set(-1535680990, obj);
                    Ry.set(46, (Object) cd);
                    Ry.set(72, cd3);
                    Ry.set(29, fvVar.vCp);
                    a = false;
                } else {
                    ab.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", Integer.valueOf(i3));
                }
                ab.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", Integer.valueOf(i3));
                if (fvVar.vHK != null) {
                    cd2 = bo.cd(com.tencent.mm.platformtools.aa.a(fvVar.vHK.vMb));
                    if (cd2 != null && cd2.length() > 0) {
                        Ry.set(47, cd2);
                        g.RP().eJH.set(18, cd2);
                    }
                    ab.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", bo.anv(cd2));
                }
                z2 = a;
            }
            a = false;
            ab.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", Integer.valueOf(i3));
            if (fvVar.vHK != null) {
            }
            z2 = a;
        } else {
            ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
            com.tencent.mm.plugin.report.e.pXa.a(148, 22, 1, false);
        }
        if ((i & 4) != 0) {
            com.tencent.mm.plugin.report.e.pXa.a(148, 23, 1, false);
            bdv bdv = cjj.xif;
            ax.a(false, bdv.vLL, bdv.vLM, bdv.vLK);
        } else {
            ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
        }
        if (z) {
            int i4 = 4;
            String Yz = r.Yz();
            if (z2) {
                i4 = 1;
                Yz = r.Yy();
            }
            ab.i("MicroMsg.HandleAuthResponse", "loginType %s", Integer.valueOf(i4));
            com.tencent.mm.plugin.report.b.d.u(1, i4, Yz);
        }
        Ry.set(3, (Object) "");
        Ry.set(19, (Object) "");
        Ry.dsb();
        g.RP().eJH.setInt(46, 0);
        a.XG();
        AppMethodBeat.o(123394);
    }
}
