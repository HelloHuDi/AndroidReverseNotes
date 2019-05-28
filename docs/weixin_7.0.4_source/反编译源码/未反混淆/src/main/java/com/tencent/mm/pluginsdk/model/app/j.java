package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.af.n;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.g.a.f;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class j implements e {

    public interface a {
        void dhG();
    }

    public static String hE(String str, String str2) {
        AppMethodBeat.i(27315);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(27315);
            return null;
        }
        if (t.kH(str)) {
            int ox = bf.ox(str2);
            if (ox != -1) {
                str2 = (str2 + " ").substring(ox + 2).trim();
            }
        }
        String anj = bo.anj(str2);
        AppMethodBeat.o(27315);
        return anj;
    }

    public final b b(com.tencent.mm.ai.e.a aVar) {
        Object obj;
        AppMethodBeat.i(27316);
        ab.d("MicroMsg.AppMessageExtension", "process add app message");
        cm cmVar = aVar.eAB;
        String a = aa.a(cmVar.vEB);
        String a2 = aa.a(cmVar.vEC);
        if (bo.isNullOrNil(a) || bo.isNullOrNil(a2)) {
            ab.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
            obj = null;
        } else {
            obj = hE(a, aa.a(cmVar.vED));
        }
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(obj);
        if (me == null) {
            ab.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
            AppMethodBeat.o(27316);
            return null;
        } else if (me.fif) {
            aw.ZK();
            c.Ry().set(352273, obj);
            aw.ZK();
            c.Ry().set(352274, Long.valueOf(System.currentTimeMillis()));
            new a(obj).dhv();
            AppMethodBeat.o(27316);
            return null;
        } else {
            f aiJ = am.bYJ().aiJ(me.appId);
            String str = "MicroMsg.AppMessageExtension";
            String str2 = "check version appid:%s, msgVer:%d, appVer:%s";
            Object[] objArr = new Object[3];
            objArr[0] = me.appId;
            objArr[1] = Integer.valueOf(me.axy);
            objArr[2] = aiJ == null ? BuildConfig.COMMAND : Integer.valueOf(aiJ.field_appVersion);
            ab.i(str, str2, objArr);
            if (aiJ == null || aiJ.field_appVersion < me.axy) {
                am.bYI().aiH(me.appId);
            }
            b a3 = a(aVar, aa.a(cmVar.vED), me);
            if (a3.csG == null) {
                AppMethodBeat.o(27316);
                return null;
            }
            bi biVar = a3.csG;
            if (biVar.drC()) {
                if (!bo.isNullOrNil(me.fjc)) {
                    vn vnVar = new vn();
                    vnVar.cSA.cHz = me.fjc;
                    com.tencent.mm.sdk.b.a.xxA.m(vnVar);
                }
                AppMethodBeat.o(27316);
                return a3;
            } else if (biVar.getType() == 301989937) {
                AppMethodBeat.o(27316);
                return a3;
            } else {
                if (biVar.getType() == -1879048190) {
                    uf ufVar = new uf();
                    ufVar.cQp.cHz = obj;
                    ufVar.cQp.description = me.description;
                    ufVar.cQp.csG = biVar;
                    com.tencent.mm.sdk.b.a.xxA.m(ufVar);
                }
                if (biVar.getType() == 49 && !bo.isNullOrNil(me.canvasPageXml)) {
                    f fVar = new f();
                    fVar.crT.crU = me.canvasPageXml;
                    com.tencent.mm.sdk.b.a.xxA.m(fVar);
                }
                com.tencent.mm.af.j jVar = new com.tencent.mm.af.j();
                me.a(jVar);
                jVar.field_msgId = biVar.field_msgId;
                if (am.dhN().ma(biVar.field_msgId) == null && am.dhN().b((com.tencent.mm.sdk.e.c) jVar)) {
                    if (me.type == 40) {
                        b lZ = am.aUq().lZ(biVar.field_msgId);
                        n mj = n.mj(obj);
                        if (lZ == null) {
                            l.a(null, biVar.field_msgId, 0, null, null, mj.fjt, me.type, 0);
                        }
                        aw.Rg().a(new com.tencent.mm.plugin.record.b.e(biVar.field_msgId, biVar.field_msgSvrId, null), 0);
                    }
                    AppMethodBeat.o(27316);
                    return a3;
                }
                AppMethodBeat.o(27316);
                return null;
            }
        }
    }

    static String a(byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.i(27317);
        String a = o.ahl().a(bArr, z, CompressFormat.PNG, z2);
        AppMethodBeat.o(27317);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:173:0x06a9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0752  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0340  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b a(com.tencent.mm.ai.e.a aVar, String str, com.tencent.mm.af.j.b bVar) {
        boolean z;
        com.tencent.mm.at.a.a ahp;
        String str2;
        com.tencent.mm.at.a.a.c.a aVar2;
        int i;
        bi biVar;
        b bVar2;
        Map z2;
        nh nhVar;
        nm nmVar;
        Map map;
        long aaE;
        bx bxVar;
        int i2;
        String nullAsNil;
        String nullAsNil2;
        AppMethodBeat.i(27318);
        cm cmVar = aVar.eAB;
        aw.ZK();
        h XO = c.XO();
        aw.ZK();
        k XU = c.XU();
        String Yz = r.Yz();
        String a = aa.a(cmVar.vEB);
        String a2 = aa.a(cmVar.vEC);
        Object obj = (XU.has(a) || Yz.equals(a)) ? 1 : null;
        bf.b oE = bf.oE(cmVar.vEG);
        String str3 = null;
        if (oE != null) {
            str3 = oE.fmp;
        }
        String str4 = t.nE(str3) ? "notifymessage" : obj != null ? a2 : a;
        bi Q = XO.Q(str4, cmVar.ptF);
        ab.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId));
        if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < bf.q(str4, (long) cmVar.pcX)) {
            ab.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId));
            bf.fm(Q.field_msgId);
            Q.setMsgId(0);
        }
        if (Q.field_msgId == 0) {
            Q = new bi();
            Q.eI(cmVar.ptF);
            Q.eJ(bf.q(str4, (long) cmVar.pcX));
        }
        if (bVar.fgl != null) {
            Q.jB(bVar.fgl.dJE);
            ab.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", Q.dJE);
        }
        Q.setType(l.d(bVar));
        Q.setContent(Q.drC() ? bVar.content : str);
        if (Q.drC()) {
            Q.jz(bVar.dJv);
        }
        if (cmVar.vEE == 2 && Q.field_msgId == 0) {
            Object obj2;
            switch (Q.getType()) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    obj2 = 1;
                    break;
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 == null) {
                z = bVar.type == 2;
                byte[] a3 = aa.a(cmVar.vEF);
                if (ae.giF) {
                    ab.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a3 = null;
                }
                if (!bo.cb(a3)) {
                    if (bVar.type == 33 || bVar.type == 36 || bVar.type == 46 || bVar.type == 44) {
                        str3 = o.ahl().a(a3, CompressFormat.PNG);
                    } else {
                        str3 = a(a3, z, Q.dty());
                    }
                    if (bo.isNullOrNil(str3)) {
                        ab.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", Q.field_content);
                    }
                    if (!bo.isNullOrNil(str3)) {
                        Q.jv(str3);
                        ab.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(str3)));
                    }
                } else if (!bo.isNullOrNil(bVar.fgE) && !bo.isNullOrNil(bVar.fgK)) {
                    a(Q.field_msgSvrId, Q, str4, bVar.fgK, bVar.fgE, bVar.fgF, z, bVar, "", false);
                } else if (!bo.isNullOrNil(bVar.thumburl)) {
                    ab.d("MicroMsg.AppMessageExtension", "get cdn image " + bVar.thumburl);
                    str3 = g.x((bo.anU()).getBytes());
                    Yz = o.ahl().getFullPath(str3);
                    o.ahl();
                    str3 = com.tencent.mm.at.g.si(str3);
                    ahp = o.ahp();
                    str2 = bVar.thumburl;
                    aVar2 = new com.tencent.mm.at.a.a.c.a();
                    aVar2.ePJ = Yz;
                    aVar2.ePH = true;
                    ahp.a(str2, null, aVar2.ahG());
                    Q.jv(str3);
                    ab.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(Yz)));
                } else if (!bo.isNullOrNil(bVar.fgv)) {
                    a(Q.field_msgSvrId, Q, str4, bVar.fgB, bVar.fgv, bVar.fgw, z, bVar, bVar.fgA, true);
                    ab.d("MicroMsg.AppMessageExtension", "get cdn image " + bVar.fgv);
                }
                if (obj == null) {
                    Q.hO(1);
                    Q.ju(str4);
                    i = cmVar.jBT;
                    biVar = Q;
                } else {
                    Q.hO(0);
                    Q.ju(str4);
                    if (cmVar.jBT > 3) {
                        i = cmVar.jBT;
                        biVar = Q;
                    } else {
                        i = 3;
                        biVar = Q;
                    }
                }
                biVar.setStatus(i);
                if (bVar.type == 2001) {
                    if (bVar.showType == 1) {
                        if (TextUtils.isEmpty(bVar.fic) || TextUtils.isEmpty(bVar.fid) || bVar.fie <= 0) {
                            ab.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
                        } else {
                            ab.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                            al alVar = new al();
                            alVar.ctv = new com.tencent.mm.g.a.al.a();
                            alVar.ctv.cty = bVar.fid;
                            alVar.ctv.ctw = bVar.fic;
                            alVar.ctv.ctz = bVar.fie;
                            com.tencent.mm.sdk.b.a.xxA.m(alVar);
                        }
                    }
                    try {
                        if (!bo.ek(bVar.fio)) {
                            for (String str32 : bVar.fio) {
                                String[] split = str32.split(",");
                                if (split != null && split.length > 0) {
                                    str32 = split[0];
                                    if (!bo.isNullOrNil(str32) && str32.equals(r.Yz())) {
                                        Q.hY(Q.field_flag | 8);
                                        ab.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                                        x(true, Q.field_talker);
                                    }
                                }
                            }
                        } else if (!"1001".equals(bVar.fhY)) {
                            ve veVar = new ve();
                            veVar.cSb.cJh = str;
                            com.tencent.mm.sdk.b.a.xxA.m(veVar);
                            x(false, Q.field_talker);
                            if ("1002".equals(bVar.fhY)) {
                                com.tencent.mm.af.c cVar = (com.tencent.mm.af.c) bVar.X(com.tencent.mm.af.c.class);
                                atc atc = new atc();
                                atc.wwX = cVar.ffX;
                                atc.wxa = cVar.ffY;
                                atc.wwW = cVar.ffV;
                                atc.wwZ = cVar.ffW;
                                if (obj != null) {
                                    atc.wwV = cVar.ffR;
                                    atc.wwY = cVar.ffS;
                                } else {
                                    atc.wwV = cVar.ffT;
                                    atc.wwY = cVar.ffU;
                                }
                                ((com.tencent.mm.plugin.luckymoney.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.luckymoney.a.a.class)).a(atc);
                            }
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", e.getMessage());
                    }
                    ab.i("MicroMsg.AppMessageExtension", "paymsgid: %s", bVar.fib);
                }
                Q.ix(cmVar.vEG);
                if (oE != null) {
                    Q.jA(oE.fmu);
                    Q.jy(oE.fmt);
                }
                bf.a(Q, aVar);
                if (Q.field_msgId != 0) {
                    Q.setMsgId(bf.l(Q));
                    s sVar = new s();
                    sVar.csF.csG = Q;
                    sVar.csF.csH = bVar;
                    com.tencent.mm.sdk.b.a.xxA.m(sVar);
                    bVar2 = new b(Q, true);
                } else {
                    XO.b(cmVar.ptF, Q);
                    bVar2 = new b(Q, false);
                }
                if (Q.getType() == 301989937 && t.nC(Q.field_talker)) {
                    Q.setMsgId(0);
                }
                if (Q.dtu() && "notifymessage".equals(Q.field_talker)) {
                    z2 = br.z(Q.field_content, "msg");
                    if (z2 != null) {
                        String nullAsNil3 = bo.nullAsNil((String) z2.get(".msg.fromusername"));
                        if (ad.mg(nullAsNil3)) {
                            ((d) com.tencent.mm.kernel.g.K(d.class)).b(nullAsNil3, null);
                            ab.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", nullAsNil3);
                        }
                    }
                }
                if (Q.getType() == 536870961) {
                    com.tencent.mm.af.b bVar3 = (com.tencent.mm.af.b) bVar.X(com.tencent.mm.af.b.class);
                    nj njVar = new nj();
                    njVar.cJG.cJD = Q.field_msgId;
                    njVar.cJG.cJH = bVar3.cJF;
                    njVar.cJG.cJh = str;
                    if (Q.field_isSend == 1) {
                        ab.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", a, a2);
                        njVar.cJG.username = Q.field_talker;
                    }
                    com.tencent.mm.sdk.b.a.xxA.m(njVar);
                    if (njVar.cJG.cJh != null) {
                        Q.setContent(njVar.cJG.cJh);
                        XO.a(Q.field_msgId, Q);
                    }
                }
                if (!bo.isNullOrNil(bVar.fih) && Q.getType() == 436207665) {
                    nhVar = new nh();
                    nhVar.cJC.cJD = Q.field_msgId;
                    nhVar.cJC.cJh = str;
                    com.tencent.mm.sdk.b.a.xxA.m(nhVar);
                }
                if (bVar.type == 2000 && !bo.isNullOrNil(bVar.fhy)) {
                    nmVar = new nm();
                    nmVar.cJL.cEa = bVar.fhy;
                    nmVar.cJL.cvx = Q.field_msgId;
                    nmVar.cJL.cJM = bVar;
                    com.tencent.mm.sdk.b.a.xxA.m(nmVar);
                    x(false, Q.field_talker);
                }
                map = bVar.fjf;
                str2 = bo.bc((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
                if ((str2.equals("wx_f2f") || str2.equals("wx_md")) && bVar2.fsZ) {
                    aaE = cb.aaE() - Q.field_createTime;
                    ab.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str2, Long.valueOf(Q.field_createTime), Long.valueOf(cb.aaE()));
                    bxVar = new bx();
                    i2 = bo.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
                    nullAsNil = bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
                    nullAsNil2 = bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
                    str32 = bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.voice_content"));
                    if (!(i2 <= 0 || bo.isNullOrNil(nullAsNil) || bo.isNullOrNil(nullAsNil2))) {
                        bxVar.cuX.cuY = i2;
                        bxVar.cuX.cuZ = nullAsNil;
                        bxVar.cuX.cva = nullAsNil2;
                        bxVar.cuX.cvb = str2;
                        bxVar.cuX.cvc = aaE;
                        bxVar.cuX.cvd = 0;
                        bxVar.cuX.cve = str32;
                        com.tencent.mm.sdk.b.a.xxA.m(bxVar);
                    }
                }
                AppMethodBeat.o(27318);
                return bVar2;
            }
        }
        if (!bo.isNullOrNil(bVar.thumburl)) {
            ab.d("MicroMsg.AppMessageExtension", "get cdn image " + bVar.thumburl);
            str32 = g.x((bo.anU()).getBytes());
            if (bVar.type == 2001) {
                str32 = g.x((bVar.thumburl).getBytes());
            }
            Yz = o.ahl().getFullPath(str32);
            o.ahl();
            str32 = com.tencent.mm.at.g.si(str32);
            ahp = o.ahp();
            str2 = bVar.thumburl;
            aVar2 = new com.tencent.mm.at.a.a.c.a();
            aVar2.ePJ = Yz;
            aVar2.ePH = true;
            ahp.a(str2, null, aVar2.ahG());
            Q.jv(str32);
            ab.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(Yz)));
        } else if (!bo.isNullOrNil(bVar.fgv)) {
            if (bVar.type == 2) {
                z = true;
            } else {
                z = false;
            }
            a(Q.field_msgSvrId, Q, str4, bVar.fgB, bVar.fgv, bVar.fgw, z, bVar, bVar.fgA, true);
            ab.d("MicroMsg.AppMessageExtension", "get cdn image " + bVar.fgv);
        }
        if (obj == null) {
        }
        biVar.setStatus(i);
        if (bVar.type == 2001) {
        }
        Q.ix(cmVar.vEG);
        if (oE != null) {
        }
        bf.a(Q, aVar);
        if (Q.field_msgId != 0) {
        }
        Q.setMsgId(0);
        z2 = br.z(Q.field_content, "msg");
        if (z2 != null) {
        }
        if (Q.getType() == 536870961) {
        }
        nhVar = new nh();
        nhVar.cJC.cJD = Q.field_msgId;
        nhVar.cJC.cJh = str;
        com.tencent.mm.sdk.b.a.xxA.m(nhVar);
        nmVar = new nm();
        nmVar.cJL.cEa = bVar.fhy;
        nmVar.cJL.cvx = Q.field_msgId;
        nmVar.cJL.cJM = bVar;
        com.tencent.mm.sdk.b.a.xxA.m(nmVar);
        x(false, Q.field_talker);
        map = bVar.fjf;
        str2 = bo.bc((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        aaE = cb.aaE() - Q.field_createTime;
        ab.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str2, Long.valueOf(Q.field_createTime), Long.valueOf(cb.aaE()));
        bxVar = new bx();
        i2 = bo.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        nullAsNil = bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        nullAsNil2 = bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        str32 = bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.voice_content"));
        bxVar.cuX.cuY = i2;
        bxVar.cuX.cuZ = nullAsNil;
        bxVar.cuX.cva = nullAsNil2;
        bxVar.cuX.cvb = str2;
        bxVar.cuX.cvc = aaE;
        bxVar.cuX.cvd = 0;
        bxVar.cuX.cve = str32;
        com.tencent.mm.sdk.b.a.xxA.m(bxVar);
        AppMethodBeat.o(27318);
        return bVar2;
    }

    private static void x(boolean z, String str) {
        AppMethodBeat.i(27319);
        if (!bo.isNullOrNil(str)) {
            ab.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", Boolean.valueOf(z), str);
            aw.ZK();
            ak aoZ = c.XR().aoZ(str);
            if (aoZ != null) {
                if (z) {
                    aoZ.jj(16777216);
                } else {
                    aoZ.jk(16777216);
                }
                aw.ZK();
                c.XR().a(aoZ, str);
            }
        }
        AppMethodBeat.o(27319);
    }

    public final void a(e.c cVar) {
        AppMethodBeat.i(27320);
        bi biVar = cVar.cKd;
        if (biVar == null) {
            ab.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
            AppMethodBeat.o(27320);
            return;
        }
        ab.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + biVar.field_imgPath);
        ue ueVar = new ue();
        ueVar.cQo.path = biVar.field_imgPath;
        com.tencent.mm.sdk.b.a.xxA.m(ueVar);
        String str = biVar.field_content;
        if (str != null) {
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
            if (me != null && me.type == 6) {
                com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.euQ + me.title);
                com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.euQ + me.title + "_tmp");
            }
        }
        AppMethodBeat.o(27320);
    }

    private boolean a(long j, bi biVar, String str, String str2, String str3, int i, boolean z, com.tencent.mm.af.j.b bVar, String str4, boolean z2) {
        AppMethodBeat.i(27321);
        ab.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", Long.valueOf(biVar.field_msgSvrId), str2, Integer.valueOf(i), str3, str, Boolean.valueOf(z));
        final long anU = bo.anU();
        final int i2 = bVar != null ? bVar.type : 0;
        final String q = o.ahl().q(bo.anU(), "", "");
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.field_mediaId = com.tencent.mm.al.c.a("downappthumb", biVar.field_createTime, str, String.valueOf(j));
        gVar.field_fullpath = q;
        if (z2) {
            gVar.field_fileType = 19;
            gVar.egm = str3;
        } else {
            gVar.field_fileId = str3;
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        }
        gVar.field_totalLen = i;
        gVar.field_aesKey = str2;
        gVar.field_priority = com.tencent.mm.i.a.efD;
        gVar.field_authKey = str4;
        gVar.field_chattype = t.kH(str) ? 1 : 0;
        ab.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", Integer.valueOf(gVar.field_chattype), str);
        final long j2 = j;
        final String str5 = str3;
        final int i3 = i;
        final String str6 = str;
        final boolean z3 = z;
        gVar.egl = new com.tencent.mm.i.g.a() {
            public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(27312);
                if (i != 0) {
                    ab.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", Long.valueOf(j2), Integer.valueOf(i), str5);
                    new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(anU), Long.valueOf(bo.anU()), Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(i3), "")).ajK();
                    AppMethodBeat.o(27312);
                    return i;
                } else if (dVar == null) {
                    AppMethodBeat.o(27312);
                    return 0;
                } else {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", Long.valueOf(j2), Integer.valueOf(dVar.field_retCode), str5);
                    } else {
                        aw.ZK();
                        bi Q = c.XO().Q(str6, j2);
                        if (Q.field_msgSvrId != j2) {
                            ab.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", Long.valueOf(j2));
                            AppMethodBeat.o(27312);
                            return 0;
                        }
                        String a;
                        long j;
                        ab.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", Long.valueOf(j2), Integer.valueOf(Q.getType()));
                        byte[] e = com.tencent.mm.vfs.e.e(q, 0, -1);
                        if (i2 == 33 || i2 == 36 || i2 == 46 || i2 == 44) {
                            a = o.ahl().a(e, CompressFormat.JPEG);
                        } else {
                            a = j.a(e, z3, Q.dty());
                        }
                        if (!bo.isNullOrNil(a)) {
                            Q.jv(a);
                            aw.ZK();
                            c.XO().b(Q.field_msgSvrId, Q);
                        }
                        ab.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", Long.valueOf(j2), str6, str5, a);
                        com.tencent.mm.plugin.report.service.h.pYm.a(198, 16, (long) i3, false);
                        com.tencent.mm.plugin.report.service.h.pYm.a(198, 17, 1, false);
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        if (t.kH(str6)) {
                            j = 19;
                        } else {
                            j = 18;
                        }
                        hVar.a(198, j, 1, false);
                    }
                    Object[] objArr = new Object[16];
                    objArr[0] = Integer.valueOf(dVar == null ? -1 : dVar.field_retCode);
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(anU);
                    objArr[3] = Long.valueOf(bo.anU());
                    objArr[4] = Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext()));
                    objArr[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
                    objArr[6] = Integer.valueOf(i3);
                    objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    objArr[15] = dVar == null ? "" : dVar.efY;
                    new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
                    if (!(dVar == null || dVar.field_retCode == 0)) {
                        objArr = new Object[16];
                        objArr[0] = Integer.valueOf(dVar == null ? -1 : dVar.field_retCode);
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = Long.valueOf(anU);
                        objArr[3] = Long.valueOf(bo.anU());
                        objArr[4] = Integer.valueOf(com.tencent.mm.al.c.bW(ah.getContext()));
                        objArr[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
                        objArr[6] = Integer.valueOf(i3);
                        objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        objArr[15] = dVar == null ? "" : dVar.efY;
                        new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
                    }
                    o.ahl().doNotify();
                    AppMethodBeat.o(27312);
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return null;
            }
        };
        com.tencent.mm.al.f.afx().b(gVar, -1);
        AppMethodBeat.o(27321);
        return true;
    }

    public final boolean a(final a aVar, String str, long j, String str2, final String str3, int i, String str4) {
        AppMethodBeat.i(27322);
        String q = o.ahl().q("Note_".concat(String.valueOf(str)), "", "");
        if (com.tencent.mm.vfs.e.ct(q)) {
            AppMethodBeat.o(27322);
            return false;
        }
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.field_mediaId = com.tencent.mm.al.c.a("downappthumb", j, str4, String.valueOf(str));
        gVar.field_fullpath = q;
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
        gVar.field_totalLen = i;
        gVar.field_aesKey = str2;
        gVar.field_fileId = str3;
        gVar.field_priority = com.tencent.mm.i.a.efD;
        gVar.field_chattype = t.kH(str4) ? 1 : 0;
        ab.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", Integer.valueOf(gVar.field_chattype), str4);
        gVar.egl = new com.tencent.mm.i.g.a() {
            WeakReference<a> vcg = new WeakReference(aVar);

            public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(27314);
                ab.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", str, str3);
                if (i != 0) {
                    ab.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", Integer.valueOf(i), str3);
                    AppMethodBeat.o(27314);
                    return i;
                } else if (dVar == null) {
                    AppMethodBeat.o(27314);
                    return 0;
                } else {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", Integer.valueOf(dVar.field_retCode), str3);
                    } else {
                        ab.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", str3);
                    }
                    o.ahl().doNotify();
                    a aVar = (a) this.vcg.get();
                    if (aVar != null) {
                        aVar.dhG();
                    }
                    AppMethodBeat.o(27314);
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return null;
            }
        };
        com.tencent.mm.al.f.afx().b(gVar, -1);
        AppMethodBeat.o(27322);
        return true;
    }
}
