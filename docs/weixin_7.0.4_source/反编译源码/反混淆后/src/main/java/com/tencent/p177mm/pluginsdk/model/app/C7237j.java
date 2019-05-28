package com.tencent.p177mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C17872c;
import com.tencent.p177mm.p181af.C25746b;
import com.tencent.p177mm.p181af.C32222n;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C18431vn;
import com.tencent.p177mm.p230g.p231a.C26132f;
import com.tencent.p177mm.p230g.p231a.C26262ve;
import com.tencent.p177mm.p230g.p231a.C37696bx;
import com.tencent.p177mm.p230g.p231a.C37770nh;
import com.tencent.p177mm.p230g.p231a.C41963al;
import com.tencent.p177mm.p230g.p231a.C41963al.C37689a;
import com.tencent.p177mm.p230g.p231a.C42030nm;
import com.tencent.p177mm.p230g.p231a.C42057s;
import com.tencent.p177mm.p230g.p231a.C42068ue;
import com.tencent.p177mm.p230g.p231a.C42069uf;
import com.tencent.p177mm.p230g.p231a.C9424nj;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6978k;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.atc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.model.app.j */
public final class C7237j implements C1201e {

    /* renamed from: com.tencent.mm.pluginsdk.model.app.j$a */
    public interface C7238a {
        void dhG();
    }

    /* renamed from: hE */
    public static String m12094hE(String str, String str2) {
        AppMethodBeat.m2504i(27315);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(27315);
            return null;
        }
        if (C1855t.m3896kH(str)) {
            int ox = C1829bf.m3761ox(str2);
            if (ox != -1) {
                str2 = (str2 + " ").substring(ox + 2).trim();
            }
        }
        String anj = C5046bo.anj(str2);
        AppMethodBeat.m2505o(27315);
        return anj;
    }

    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        Object obj;
        AppMethodBeat.m2504i(27316);
        C4990ab.m7410d("MicroMsg.AppMessageExtension", "process add app message");
        C7254cm c7254cm = c1197a.eAB;
        String a = C1946aa.m4148a(c7254cm.vEB);
        String a2 = C1946aa.m4148a(c7254cm.vEC);
        if (C5046bo.isNullOrNil(a) || C5046bo.isNullOrNil(a2)) {
            C4990ab.m7412e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
            obj = null;
        } else {
            obj = C7237j.m12094hE(a, C1946aa.m4148a(c7254cm.vED));
        }
        C8910b me = C8910b.m16064me(obj);
        if (me == null) {
            C4990ab.m7412e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
            AppMethodBeat.m2505o(27316);
            return null;
        } else if (me.fif) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(352273, obj);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(352274, Long.valueOf(System.currentTimeMillis()));
            new C44057a(obj).dhv();
            AppMethodBeat.m2505o(27316);
            return null;
        } else {
            C40439f aiJ = C14877am.bYJ().aiJ(me.appId);
            String str = "MicroMsg.AppMessageExtension";
            String str2 = "check version appid:%s, msgVer:%d, appVer:%s";
            Object[] objArr = new Object[3];
            objArr[0] = me.appId;
            objArr[1] = Integer.valueOf(me.axy);
            objArr[2] = aiJ == null ? BuildConfig.COMMAND : Integer.valueOf(aiJ.field_appVersion);
            C4990ab.m7417i(str, str2, objArr);
            if (aiJ == null || aiJ.field_appVersion < me.axy) {
                C14877am.bYI().aiH(me.appId);
            }
            C1198b a3 = m12091a(c1197a, C1946aa.m4148a(c7254cm.vED), me);
            if (a3.csG == null) {
                AppMethodBeat.m2505o(27316);
                return null;
            }
            C7620bi c7620bi = a3.csG;
            if (c7620bi.drC()) {
                if (!C5046bo.isNullOrNil(me.fjc)) {
                    C18431vn c18431vn = new C18431vn();
                    c18431vn.cSA.cHz = me.fjc;
                    C4879a.xxA.mo10055m(c18431vn);
                }
                AppMethodBeat.m2505o(27316);
                return a3;
            } else if (c7620bi.getType() == 301989937) {
                AppMethodBeat.m2505o(27316);
                return a3;
            } else {
                if (c7620bi.getType() == -1879048190) {
                    C42069uf c42069uf = new C42069uf();
                    c42069uf.cQp.cHz = obj;
                    c42069uf.cQp.description = me.description;
                    c42069uf.cQp.csG = c7620bi;
                    C4879a.xxA.mo10055m(c42069uf);
                }
                if (c7620bi.getType() == 49 && !C5046bo.isNullOrNil(me.canvasPageXml)) {
                    C26132f c26132f = new C26132f();
                    c26132f.crT.crU = me.canvasPageXml;
                    C4879a.xxA.mo10055m(c26132f);
                }
                C8909j c8909j = new C8909j();
                me.mo20335a(c8909j);
                c8909j.field_msgId = c7620bi.field_msgId;
                if (C14877am.dhN().mo27204ma(c7620bi.field_msgId) == null && C14877am.dhN().mo10101b((C4925c) c8909j)) {
                    if (me.type == 40) {
                        C30065b lZ = C14877am.aUq().mo48329lZ(c7620bi.field_msgId);
                        C32222n mj = C32222n.m52572mj(obj);
                        if (lZ == null) {
                            C4733l.m7094a(null, c7620bi.field_msgId, 0, null, null, mj.fjt, me.type, 0);
                        }
                        C9638aw.m17182Rg().mo14541a(new C43432e(c7620bi.field_msgId, c7620bi.field_msgSvrId, null), 0);
                    }
                    AppMethodBeat.m2505o(27316);
                    return a3;
                }
                AppMethodBeat.m2505o(27316);
                return null;
            }
        }
    }

    /* renamed from: a */
    static String m12092a(byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.m2504i(27317);
        String a = C32291o.ahl().mo73095a(bArr, z, CompressFormat.PNG, z2);
        AppMethodBeat.m2505o(27317);
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
    /* renamed from: a */
    private C1198b m12091a(C1197a c1197a, String str, C8910b c8910b) {
        boolean z;
        C25815a ahp;
        String str2;
        C17927a c17927a;
        int i;
        C7620bi c7620bi;
        C1198b c1198b;
        Map z2;
        C37770nh c37770nh;
        C42030nm c42030nm;
        Map map;
        long aaE;
        C37696bx c37696bx;
        int i2;
        String nullAsNil;
        String nullAsNil2;
        AppMethodBeat.m2504i(27318);
        C7254cm c7254cm = c1197a.eAB;
        C9638aw.m17190ZK();
        C6977h XO = C18628c.m29080XO();
        C9638aw.m17190ZK();
        C6978k XU = C18628c.m29086XU();
        String Yz = C1853r.m3846Yz();
        String a = C1946aa.m4148a(c7254cm.vEB);
        String a2 = C1946aa.m4148a(c7254cm.vEC);
        Object obj = (XU.has(a) || Yz.equals(a)) ? 1 : null;
        C1828b oE = C1829bf.m3758oE(c7254cm.vEG);
        String str3 = null;
        if (oE != null) {
            str3 = oE.fmp;
        }
        String str4 = C1855t.m3919nE(str3) ? "notifymessage" : obj != null ? a2 : a;
        C7620bi Q = XO.mo15241Q(str4, c7254cm.ptF);
        C4990ab.m7417i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId));
        if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < C1829bf.m3764q(str4, (long) c7254cm.pcX)) {
            C4990ab.m7421w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId));
            C1829bf.m3748fm(Q.field_msgId);
            Q.setMsgId(0);
        }
        if (Q.field_msgId == 0) {
            Q = new C7620bi();
            Q.mo14774eI(c7254cm.ptF);
            Q.mo14775eJ(C1829bf.m3764q(str4, (long) c7254cm.pcX));
        }
        if (c8910b.fgl != null) {
            Q.mo14793jB(c8910b.fgl.dJE);
            C4990ab.m7417i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", Q.dJE);
        }
        Q.setType(C4733l.m7100d(c8910b));
        Q.setContent(Q.drC() ? c8910b.content : str);
        if (Q.drC()) {
            Q.mo14799jz(c8910b.dJv);
        }
        if (c7254cm.vEE == 2 && Q.field_msgId == 0) {
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
                z = c8910b.type == 2;
                byte[] a3 = C1946aa.m4150a(c7254cm.vEF);
                if (C1947ae.giF) {
                    C4990ab.m7420w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a3 = null;
                }
                if (!C5046bo.m7540cb(a3)) {
                    if (c8910b.type == 33 || c8910b.type == 36 || c8910b.type == 46 || c8910b.type == 44) {
                        str3 = C32291o.ahl().mo73091a(a3, CompressFormat.PNG);
                    } else {
                        str3 = C7237j.m12092a(a3, z, Q.dty());
                    }
                    if (C5046bo.isNullOrNil(str3)) {
                        C4990ab.m7421w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", Q.field_content);
                    }
                    if (!C5046bo.isNullOrNil(str3)) {
                        Q.mo14795jv(str3);
                        C4990ab.m7410d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(str3)));
                    }
                } else if (!C5046bo.isNullOrNil(c8910b.fgE) && !C5046bo.isNullOrNil(c8910b.fgK)) {
                    m12093a(Q.field_msgSvrId, Q, str4, c8910b.fgK, c8910b.fgE, c8910b.fgF, z, c8910b, "", false);
                } else if (!C5046bo.isNullOrNil(c8910b.thumburl)) {
                    C4990ab.m7410d("MicroMsg.AppMessageExtension", "get cdn image " + c8910b.thumburl);
                    str3 = C1178g.m2591x((C5046bo.anU()).getBytes());
                    Yz = C32291o.ahl().getFullPath(str3);
                    C32291o.ahl();
                    str3 = C45160g.m83082si(str3);
                    ahp = C32291o.ahp();
                    str2 = c8910b.thumburl;
                    c17927a = new C17927a();
                    c17927a.ePJ = Yz;
                    c17927a.ePH = true;
                    ahp.mo43766a(str2, null, c17927a.ahG());
                    Q.mo14795jv(str3);
                    C4990ab.m7410d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(Yz)));
                } else if (!C5046bo.isNullOrNil(c8910b.fgv)) {
                    m12093a(Q.field_msgSvrId, Q, str4, c8910b.fgB, c8910b.fgv, c8910b.fgw, z, c8910b, c8910b.fgA, true);
                    C4990ab.m7410d("MicroMsg.AppMessageExtension", "get cdn image " + c8910b.fgv);
                }
                if (obj == null) {
                    Q.mo14781hO(1);
                    Q.mo14794ju(str4);
                    i = c7254cm.jBT;
                    c7620bi = Q;
                } else {
                    Q.mo14781hO(0);
                    Q.mo14794ju(str4);
                    if (c7254cm.jBT > 3) {
                        i = c7254cm.jBT;
                        c7620bi = Q;
                    } else {
                        i = 3;
                        c7620bi = Q;
                    }
                }
                c7620bi.setStatus(i);
                if (c8910b.type == 2001) {
                    if (c8910b.showType == 1) {
                        if (TextUtils.isEmpty(c8910b.fic) || TextUtils.isEmpty(c8910b.fid) || c8910b.fie <= 0) {
                            C4990ab.m7412e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
                        } else {
                            C4990ab.m7416i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                            C41963al c41963al = new C41963al();
                            c41963al.ctv = new C37689a();
                            c41963al.ctv.cty = c8910b.fid;
                            c41963al.ctv.ctw = c8910b.fic;
                            c41963al.ctv.ctz = c8910b.fie;
                            C4879a.xxA.mo10055m(c41963al);
                        }
                    }
                    try {
                        if (!C5046bo.m7548ek(c8910b.fio)) {
                            for (String str32 : c8910b.fio) {
                                String[] split = str32.split(",");
                                if (split != null && split.length > 0) {
                                    str32 = split[0];
                                    if (!C5046bo.isNullOrNil(str32) && str32.equals(C1853r.m3846Yz())) {
                                        Q.mo14783hY(Q.field_flag | 8);
                                        C4990ab.m7416i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                                        C7237j.m12095x(true, Q.field_talker);
                                    }
                                }
                            }
                        } else if (!"1001".equals(c8910b.fhY)) {
                            C26262ve c26262ve = new C26262ve();
                            c26262ve.cSb.cJh = str;
                            C4879a.xxA.mo10055m(c26262ve);
                            C7237j.m12095x(false, Q.field_talker);
                            if ("1002".equals(c8910b.fhY)) {
                                C17872c c17872c = (C17872c) c8910b.mo20333X(C17872c.class);
                                atc atc = new atc();
                                atc.wwX = c17872c.ffX;
                                atc.wxa = c17872c.ffY;
                                atc.wwW = c17872c.ffV;
                                atc.wwZ = c17872c.ffW;
                                if (obj != null) {
                                    atc.wwV = c17872c.ffR;
                                    atc.wwY = c17872c.ffS;
                                } else {
                                    atc.wwV = c17872c.ffT;
                                    atc.wwY = c17872c.ffU;
                                }
                                ((C12405a) C1720g.m3528K(C12405a.class)).mo24256a(atc);
                            }
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", e.getMessage());
                    }
                    C4990ab.m7417i("MicroMsg.AppMessageExtension", "paymsgid: %s", c8910b.fib);
                }
                Q.mo14791ix(c7254cm.vEG);
                if (oE != null) {
                    Q.mo14792jA(oE.fmu);
                    Q.mo14798jy(oE.fmt);
                }
                C1829bf.m3743a(Q, c1197a);
                if (Q.field_msgId != 0) {
                    Q.setMsgId(C1829bf.m3752l(Q));
                    C42057s c42057s = new C42057s();
                    c42057s.csF.csG = Q;
                    c42057s.csF.csH = c8910b;
                    C4879a.xxA.mo10055m(c42057s);
                    c1198b = new C1198b(Q, true);
                } else {
                    XO.mo15302b(c7254cm.ptF, Q);
                    c1198b = new C1198b(Q, false);
                }
                if (Q.getType() == 301989937 && C1855t.m3917nC(Q.field_talker)) {
                    Q.setMsgId(0);
                }
                if (Q.dtu() && "notifymessage".equals(Q.field_talker)) {
                    z2 = C5049br.m7595z(Q.field_content, "msg");
                    if (z2 != null) {
                        String nullAsNil3 = C5046bo.nullAsNil((String) z2.get(".msg.fromusername"));
                        if (C7616ad.m13549mg(nullAsNil3)) {
                            ((C42686d) C1720g.m3528K(C42686d.class)).mo44617b(nullAsNil3, null);
                            C4990ab.m7411d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", nullAsNil3);
                        }
                    }
                }
                if (Q.getType() == 536870961) {
                    C25746b c25746b = (C25746b) c8910b.mo20333X(C25746b.class);
                    C9424nj c9424nj = new C9424nj();
                    c9424nj.cJG.cJD = Q.field_msgId;
                    c9424nj.cJG.cJH = c25746b.cJF;
                    c9424nj.cJG.cJh = str;
                    if (Q.field_isSend == 1) {
                        C4990ab.m7411d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", a, a2);
                        c9424nj.cJG.username = Q.field_talker;
                    }
                    C4879a.xxA.mo10055m(c9424nj);
                    if (c9424nj.cJG.cJh != null) {
                        Q.setContent(c9424nj.cJG.cJh);
                        XO.mo15284a(Q.field_msgId, Q);
                    }
                }
                if (!C5046bo.isNullOrNil(c8910b.fih) && Q.getType() == 436207665) {
                    c37770nh = new C37770nh();
                    c37770nh.cJC.cJD = Q.field_msgId;
                    c37770nh.cJC.cJh = str;
                    C4879a.xxA.mo10055m(c37770nh);
                }
                if (c8910b.type == 2000 && !C5046bo.isNullOrNil(c8910b.fhy)) {
                    c42030nm = new C42030nm();
                    c42030nm.cJL.cEa = c8910b.fhy;
                    c42030nm.cJL.cvx = Q.field_msgId;
                    c42030nm.cJL.cJM = c8910b;
                    C4879a.xxA.mo10055m(c42030nm);
                    C7237j.m12095x(false, Q.field_talker);
                }
                map = c8910b.fjf;
                str2 = C5046bo.m7532bc((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
                if ((str2.equals("wx_f2f") || str2.equals("wx_md")) && c1198b.fsZ) {
                    aaE = C1839cb.aaE() - Q.field_createTime;
                    C4990ab.m7417i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str2, Long.valueOf(Q.field_createTime), Long.valueOf(C1839cb.aaE()));
                    c37696bx = new C37696bx();
                    i2 = C5046bo.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
                    nullAsNil = C5046bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
                    nullAsNil2 = C5046bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
                    str32 = C5046bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.voice_content"));
                    if (!(i2 <= 0 || C5046bo.isNullOrNil(nullAsNil) || C5046bo.isNullOrNil(nullAsNil2))) {
                        c37696bx.cuX.cuY = i2;
                        c37696bx.cuX.cuZ = nullAsNil;
                        c37696bx.cuX.cva = nullAsNil2;
                        c37696bx.cuX.cvb = str2;
                        c37696bx.cuX.cvc = aaE;
                        c37696bx.cuX.cvd = 0;
                        c37696bx.cuX.cve = str32;
                        C4879a.xxA.mo10055m(c37696bx);
                    }
                }
                AppMethodBeat.m2505o(27318);
                return c1198b;
            }
        }
        if (!C5046bo.isNullOrNil(c8910b.thumburl)) {
            C4990ab.m7410d("MicroMsg.AppMessageExtension", "get cdn image " + c8910b.thumburl);
            str32 = C1178g.m2591x((C5046bo.anU()).getBytes());
            if (c8910b.type == 2001) {
                str32 = C1178g.m2591x((c8910b.thumburl).getBytes());
            }
            Yz = C32291o.ahl().getFullPath(str32);
            C32291o.ahl();
            str32 = C45160g.m83082si(str32);
            ahp = C32291o.ahp();
            str2 = c8910b.thumburl;
            c17927a = new C17927a();
            c17927a.ePJ = Yz;
            c17927a.ePH = true;
            ahp.mo43766a(str2, null, c17927a.ahG());
            Q.mo14795jv(str32);
            C4990ab.m7410d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(Yz)));
        } else if (!C5046bo.isNullOrNil(c8910b.fgv)) {
            if (c8910b.type == 2) {
                z = true;
            } else {
                z = false;
            }
            m12093a(Q.field_msgSvrId, Q, str4, c8910b.fgB, c8910b.fgv, c8910b.fgw, z, c8910b, c8910b.fgA, true);
            C4990ab.m7410d("MicroMsg.AppMessageExtension", "get cdn image " + c8910b.fgv);
        }
        if (obj == null) {
        }
        c7620bi.setStatus(i);
        if (c8910b.type == 2001) {
        }
        Q.mo14791ix(c7254cm.vEG);
        if (oE != null) {
        }
        C1829bf.m3743a(Q, c1197a);
        if (Q.field_msgId != 0) {
        }
        Q.setMsgId(0);
        z2 = C5049br.m7595z(Q.field_content, "msg");
        if (z2 != null) {
        }
        if (Q.getType() == 536870961) {
        }
        c37770nh = new C37770nh();
        c37770nh.cJC.cJD = Q.field_msgId;
        c37770nh.cJC.cJh = str;
        C4879a.xxA.mo10055m(c37770nh);
        c42030nm = new C42030nm();
        c42030nm.cJL.cEa = c8910b.fhy;
        c42030nm.cJL.cvx = Q.field_msgId;
        c42030nm.cJL.cJM = c8910b;
        C4879a.xxA.mo10055m(c42030nm);
        C7237j.m12095x(false, Q.field_talker);
        map = c8910b.fjf;
        str2 = C5046bo.m7532bc((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        aaE = C1839cb.aaE() - Q.field_createTime;
        C4990ab.m7417i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str2, Long.valueOf(Q.field_createTime), Long.valueOf(C1839cb.aaE()));
        c37696bx = new C37696bx();
        i2 = C5046bo.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        nullAsNil = C5046bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        nullAsNil2 = C5046bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        str32 = C5046bo.nullAsNil((String) map.get(".msg.appmsg.ext_pay_info.voice_content"));
        c37696bx.cuX.cuY = i2;
        c37696bx.cuX.cuZ = nullAsNil;
        c37696bx.cuX.cva = nullAsNil2;
        c37696bx.cuX.cvb = str2;
        c37696bx.cuX.cvc = aaE;
        c37696bx.cuX.cvd = 0;
        c37696bx.cuX.cve = str32;
        C4879a.xxA.mo10055m(c37696bx);
        AppMethodBeat.m2505o(27318);
        return c1198b;
    }

    /* renamed from: x */
    private static void m12095x(boolean z, String str) {
        AppMethodBeat.m2504i(27319);
        if (!C5046bo.isNullOrNil(str)) {
            C4990ab.m7417i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", Boolean.valueOf(z), str);
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(str);
            if (aoZ != null) {
                if (z) {
                    aoZ.mo16712jj(16777216);
                } else {
                    aoZ.mo16713jk(16777216);
                }
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo15767a(aoZ, str);
            }
        }
        AppMethodBeat.m2505o(27319);
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
        AppMethodBeat.m2504i(27320);
        C7620bi c7620bi = c1199c.cKd;
        if (c7620bi == null) {
            C4990ab.m7412e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
            AppMethodBeat.m2505o(27320);
            return;
        }
        C4990ab.m7410d("MicroMsg.AppMessageExtension", "onPreDelMessage " + c7620bi.field_imgPath);
        C42068ue c42068ue = new C42068ue();
        c42068ue.cQo.path = c7620bi.field_imgPath;
        C4879a.xxA.mo10055m(c42068ue);
        String str = c7620bi.field_content;
        if (str != null) {
            C8910b me = C8910b.m16064me(str);
            if (me != null && me.type == 6) {
                C5730e.deleteFile(C6457e.euQ + me.title);
                C5730e.deleteFile(C6457e.euQ + me.title + "_tmp");
            }
        }
        AppMethodBeat.m2505o(27320);
    }

    /* renamed from: a */
    private boolean m12093a(long j, C7620bi c7620bi, String str, String str2, String str3, int i, boolean z, C8910b c8910b, String str4, boolean z2) {
        AppMethodBeat.m2504i(27321);
        C4990ab.m7417i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", Long.valueOf(c7620bi.field_msgSvrId), str2, Integer.valueOf(i), str3, str, Boolean.valueOf(z));
        final long anU = C5046bo.anU();
        final int i2 = c8910b != null ? c8910b.type : 0;
        final String q = C32291o.ahl().mo73118q(C5046bo.anU(), "", "");
        C42130g c42130g = new C42130g();
        c42130g.field_mediaId = C37458c.m63162a("downappthumb", c7620bi.field_createTime, str, String.valueOf(j));
        c42130g.field_fullpath = q;
        if (z2) {
            c42130g.field_fileType = 19;
            c42130g.egm = str3;
        } else {
            c42130g.field_fileId = str3;
            c42130g.field_fileType = C42129a.MediaType_THUMBIMAGE;
        }
        c42130g.field_totalLen = i;
        c42130g.field_aesKey = str2;
        c42130g.field_priority = C42129a.efD;
        c42130g.field_authKey = str4;
        c42130g.field_chattype = C1855t.m3896kH(str) ? 1 : 0;
        C4990ab.m7411d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", Integer.valueOf(c42130g.field_chattype), str);
        final long j2 = j;
        final String str5 = str3;
        final int i3 = i;
        final String str6 = str;
        final boolean z3 = z;
        c42130g.egl = new C1628a() {
            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                AppMethodBeat.m2504i(27312);
                if (i != 0) {
                    C4990ab.m7413e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", Long.valueOf(j2), Integer.valueOf(i), str5);
                    new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(anU), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_THUMBIMAGE), Integer.valueOf(i3), "")).ajK();
                    AppMethodBeat.m2505o(27312);
                    return i;
                } else if (c9545d == null) {
                    AppMethodBeat.m2505o(27312);
                    return 0;
                } else {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", Long.valueOf(j2), Integer.valueOf(c9545d.field_retCode), str5);
                    } else {
                        C9638aw.m17190ZK();
                        C7620bi Q = C18628c.m29080XO().mo15241Q(str6, j2);
                        if (Q.field_msgSvrId != j2) {
                            C4990ab.m7413e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", Long.valueOf(j2));
                            AppMethodBeat.m2505o(27312);
                            return 0;
                        }
                        String a;
                        long j;
                        C4990ab.m7417i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", Long.valueOf(j2), Integer.valueOf(Q.getType()));
                        byte[] e = C5730e.m8632e(q, 0, -1);
                        if (i2 == 33 || i2 == 36 || i2 == 46 || i2 == 44) {
                            a = C32291o.ahl().mo73091a(e, CompressFormat.JPEG);
                        } else {
                            a = C7237j.m12092a(e, z3, Q.dty());
                        }
                        if (!C5046bo.isNullOrNil(a)) {
                            Q.mo14795jv(a);
                            C9638aw.m17190ZK();
                            C18628c.m29080XO().mo15302b(Q.field_msgSvrId, Q);
                        }
                        C4990ab.m7417i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", Long.valueOf(j2), str6, str5, a);
                        C7060h.pYm.mo8378a(198, 16, (long) i3, false);
                        C7060h.pYm.mo8378a(198, 17, 1, false);
                        C7060h c7060h = C7060h.pYm;
                        if (C1855t.m3896kH(str6)) {
                            j = 19;
                        } else {
                            j = 18;
                        }
                        c7060h.mo8378a(198, j, 1, false);
                    }
                    Object[] objArr = new Object[16];
                    objArr[0] = Integer.valueOf(c9545d == null ? -1 : c9545d.field_retCode);
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(anU);
                    objArr[3] = Long.valueOf(C5046bo.anU());
                    objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                    objArr[5] = Integer.valueOf(C42129a.MediaType_THUMBIMAGE);
                    objArr[6] = Integer.valueOf(i3);
                    objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    objArr[15] = c9545d == null ? "" : c9545d.efY;
                    new C9514f(C46180a.m86311r(objArr)).ajK();
                    if (!(c9545d == null || c9545d.field_retCode == 0)) {
                        objArr = new Object[16];
                        objArr[0] = Integer.valueOf(c9545d == null ? -1 : c9545d.field_retCode);
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = Long.valueOf(anU);
                        objArr[3] = Long.valueOf(C5046bo.anU());
                        objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                        objArr[5] = Integer.valueOf(C42129a.MediaType_THUMBIMAGE);
                        objArr[6] = Integer.valueOf(i3);
                        objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        objArr[15] = c9545d == null ? "" : c9545d.efY;
                        new C42099d(C46180a.m86311r(objArr)).ajK();
                    }
                    C32291o.ahl().doNotify();
                    AppMethodBeat.m2505o(27312);
                    return 0;
                }
            }

            /* renamed from: a */
            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            /* renamed from: l */
            public final byte[] mo5084l(String str, byte[] bArr) {
                return null;
            }
        };
        C37461f.afx().mo51222b(c42130g, -1);
        AppMethodBeat.m2505o(27321);
        return true;
    }

    /* renamed from: a */
    public final boolean mo15610a(final C7238a c7238a, String str, long j, String str2, final String str3, int i, String str4) {
        AppMethodBeat.m2504i(27322);
        String q = C32291o.ahl().mo73118q("Note_".concat(String.valueOf(str)), "", "");
        if (C5730e.m8628ct(q)) {
            AppMethodBeat.m2505o(27322);
            return false;
        }
        C42130g c42130g = new C42130g();
        c42130g.field_mediaId = C37458c.m63162a("downappthumb", j, str4, String.valueOf(str));
        c42130g.field_fullpath = q;
        c42130g.field_fileType = C42129a.MediaType_FULLSIZEIMAGE;
        c42130g.field_totalLen = i;
        c42130g.field_aesKey = str2;
        c42130g.field_fileId = str3;
        c42130g.field_priority = C42129a.efD;
        c42130g.field_chattype = C1855t.m3896kH(str4) ? 1 : 0;
        C4990ab.m7411d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", Integer.valueOf(c42130g.field_chattype), str4);
        c42130g.egl = new C1628a() {
            WeakReference<C7238a> vcg = new WeakReference(c7238a);

            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                AppMethodBeat.m2504i(27314);
                C4990ab.m7417i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", str, str3);
                if (i != 0) {
                    C4990ab.m7413e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", Integer.valueOf(i), str3);
                    AppMethodBeat.m2505o(27314);
                    return i;
                } else if (c9545d == null) {
                    AppMethodBeat.m2505o(27314);
                    return 0;
                } else {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", Integer.valueOf(c9545d.field_retCode), str3);
                    } else {
                        C4990ab.m7417i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", str3);
                    }
                    C32291o.ahl().doNotify();
                    C7238a c7238a = (C7238a) this.vcg.get();
                    if (c7238a != null) {
                        c7238a.dhG();
                    }
                    AppMethodBeat.m2505o(27314);
                    return 0;
                }
            }

            /* renamed from: a */
            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            /* renamed from: l */
            public final byte[] mo5084l(String str, byte[] bArr) {
                return null;
            }
        };
        C37461f.afx().mo51222b(c42130g, -1);
        AppMethodBeat.m2505o(27322);
        return true;
    }
}
