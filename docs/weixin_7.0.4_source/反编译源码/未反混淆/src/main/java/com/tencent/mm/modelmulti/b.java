package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public final class b extends m implements k {
    protected static int fHJ = 7;
    private String aIm;
    private com.tencent.mm.compatible.util.g.a eOm;
    private f ehi;
    private int errCode;
    private int errType;
    private int fHK;
    private StringBuilder fHL;
    private long fHM;
    private boolean fHN;
    private ap frk;

    public static class a implements q {
        private final com.tencent.mm.protocal.t.a fHQ;
        private final com.tencent.mm.protocal.t.b fHR;
        private final boolean fHS;
        int uin;

        public a() {
            AppMethodBeat.i(58349);
            this.fHQ = new com.tencent.mm.protocal.t.a();
            this.fHR = new com.tencent.mm.protocal.t.b();
            this.fHS = false;
            AppMethodBeat.o(58349);
        }

        public a(com.tencent.mm.protocal.t.b bVar) {
            AppMethodBeat.i(58350);
            this.fHQ = new com.tencent.mm.protocal.t.a();
            this.fHR = bVar;
            this.fHS = true;
            AppMethodBeat.o(58350);
        }

        public final e ZS() {
            return this.fHR;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }

        public final d acF() {
            AppMethodBeat.i(58351);
            this.fHQ.vye = com.tencent.mm.compatible.e.q.LM();
            this.fHQ.vyd = com.tencent.mm.protocal.d.eSg;
            this.fHQ.vyc = com.tencent.mm.protocal.d.vxo;
            this.fHQ.hB(this.uin);
            com.tencent.mm.protocal.t.a aVar = this.fHQ;
            AppMethodBeat.o(58351);
            return aVar;
        }

        public final boolean acG() {
            return false;
        }

        public final int acC() {
            return 0;
        }

        public final int acB() {
            return 0;
        }

        public final boolean acH() {
            return true;
        }
    }

    public b() {
        AppMethodBeat.i(58352);
        this.errType = 0;
        this.errCode = 0;
        this.aIm = "";
        this.fHK = 0;
        this.fHL = new StringBuilder();
        this.fHM = -1;
        this.fHN = false;
        ab.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", Integer.valueOf(hashCode()), bo.dpG());
        this.eOm = new com.tencent.mm.compatible.util.g.a();
        this.fHL.append("stack:" + bo.dpG() + " time:" + bo.anT());
        AppMethodBeat.o(58352);
    }

    public b(final com.tencent.mm.protocal.t.b bVar, int i, long j) {
        this();
        AppMethodBeat.i(58353);
        this.fHK = i;
        this.fHM = j;
        ab.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
        this.frk = new ap(aa.anr(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(58347);
                b.this.fHN = true;
                int i = 0;
                b.this.a(-1, 0, i, "", new a(bVar), null);
                AppMethodBeat.o(58347);
                return false;
            }
        }, false);
        AppMethodBeat.o(58353);
    }

    public final String getInfo() {
        AppMethodBeat.i(58354);
        String stringBuilder = this.fHL.toString();
        AppMethodBeat.o(58354);
        return stringBuilder;
    }

    public final int acn() {
        return 500;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        return com.tencent.mm.ai.m.b.EOk;
    }

    public final boolean acJ() {
        AppMethodBeat.i(58355);
        boolean acJ = super.acJ();
        AppMethodBeat.o(58355);
        return acJ;
    }

    public final int getType() {
        return 138;
    }

    public final void cancel() {
        AppMethodBeat.i(58356);
        super.cancel();
        AppMethodBeat.o(58356);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        boolean z = false;
        AppMethodBeat.i(58357);
        this.ehi = fVar;
        this.fHL.append(" lastd:" + this.ftg + " dotime:" + bo.anT() + " net:" + at.getNetType(ah.getContext()));
        String str = "MicroMsg.NetPushSync";
        String str2 = "doScene[%d] selector:%d pusher:%b ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(fHJ);
        if (this.frk != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.frk != null) {
            c(eVar);
            this.frk.ae(0, 0);
            this.frk = null;
            AppMethodBeat.o(58357);
            return -1;
        }
        a aVar = new a();
        aVar.uin = aa.ano().gcU.QF();
        bej bej = ((com.tencent.mm.protocal.t.a) aVar.acF()).vyG;
        bej.vTN = fHJ;
        bej.vTO = com.tencent.mm.platformtools.aa.ad(bo.anf(ah.getContext().getSharedPreferences("notify_sync_pref", h.Mu()).getString("notify_sync_key_keybuf", "")));
        bej.Scene = 1;
        bej.wIw = new tc();
        bej.vIk = com.tencent.mm.protocal.d.eSg;
        int a = a(eVar, aVar, this);
        AppMethodBeat.o(58357);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x04f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(58358);
        String str2;
        String str3;
        if (qVar == null || qVar.getType() != 138) {
            str2 = "MicroMsg.NetPushSync";
            str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(qVar == null ? -2 : qVar.getType());
            ab.e(str2, str3, objArr);
            AppMethodBeat.o(58358);
            return;
        }
        Object obj;
        this.fHL.append(" endtime:" + bo.anT());
        ab.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.fHN), Long.valueOf(this.eOm.Mr()), this.fHL);
        if (i2 == 4 && i3 == -2006) {
            i2 = 0;
            i3 = 0;
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 == 0 && i3 == 0) {
            String str4;
            String str5;
            byte[] anf;
            int size;
            int i4;
            com.tencent.mm.protocal.t.b bVar = (com.tencent.mm.protocal.t.b) qVar.ZS();
            if (obj == null) {
                byte[] a = com.tencent.mm.platformtools.aa.a(((com.tencent.mm.protocal.t.a) qVar.acF()).vyG.vTO);
                str4 = "MicroMsg.NetPushSync";
                str5 = "dkpush req Key : %d[%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(a == null ? -1 : a.length);
                objArr2[1] = bo.ca(a);
                ab.d(str4, str5, objArr2);
                if (bo.cb(a)) {
                    anf = bo.anf(ah.getContext().getSharedPreferences("notify_sync_pref", h.Mu()).getString("notify_sync_key_keybuf", ""));
                    ab.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", Integer.valueOf(anf.length), bo.ca(anf));
                } else {
                    anf = a;
                }
                a = com.tencent.mm.platformtools.aa.a(bVar.vyH.vTO);
                anf = com.tencent.mm.protocal.aa.j(anf, a);
                if (anf == null || anf.length <= 0) {
                    ab.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
                    anf = a;
                }
                bVar.vyH.vTO = com.tencent.mm.platformtools.aa.ad(anf);
                size = (bVar.vyH.vTR == null || bVar.vyH.vTR.jBw == null) ? 0 : bVar.vyH.vTR.jBw.size();
                ab.i("MicroMsg.NetPushSync", "newMsgSize:%d", Integer.valueOf(size));
                str4 = "MicroMsg.NetPushSync";
                str5 = "newMsgSize:%d, mergeKey: %d[%s]";
                objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(size);
                objArr2[1] = Integer.valueOf(anf == null ? -1 : anf.length);
                objArr2[2] = bo.ca(anf);
                ab.d(str4, str5, objArr2);
            }
            Iterator it = bVar.vyH.vTR.jBw.iterator();
            Object obj2 = null;
            while (it.hasNext()) {
                tb tbVar = (tb) it.next();
                if (tbVar.wat == 5) {
                    anf = com.tencent.mm.platformtools.aa.a(tbVar.wau);
                    try {
                        cm cmVar = new cm();
                        cmVar.parseFrom(anf);
                        str3 = "MicroMsg.NetPushSync";
                        str4 = "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d";
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = Integer.valueOf(cmVar.nao);
                        objArr3[1] = cmVar.vEB.wVI;
                        objArr3[2] = Long.valueOf(cmVar.ptF);
                        if (cmVar.vEH == null) {
                            i4 = 0;
                        } else {
                            i4 = cmVar.vEH.length();
                        }
                        objArr3[3] = Integer.valueOf(i4);
                        objArr3[4] = Integer.valueOf(cmVar.vED.wVI == null ? 0 : cmVar.vED.wVI.length());
                        ab.i(str3, str4, objArr3);
                        i4 = cmVar.nao;
                        str3 = cmVar.vEB.wVI;
                        str4 = cmVar.vED.wVI;
                        if (i4 == 50) {
                            ab.i("MicroMsg.NetPushSync", "hit voip");
                            obj = 1;
                        } else {
                            if (bo.isNullOrNil(str4) || bo.isNullOrNil(str3)) {
                                ab.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
                            } else if (i4 == 9998 && str3.equalsIgnoreCase("weixin")) {
                                ab.i("MicroMsg.NetPushSync", "hit ipxx");
                                obj = 1;
                            } else if (i4 == 10002 && str4.contains("revokemsg")) {
                                ab.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                obj = 1;
                            }
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = 1;
                        } else {
                            long j = cmVar.ptF;
                            str5 = cmVar.vEB.wVI;
                            str2 = cmVar.vEH;
                            int i5 = cmVar.nao;
                            if (bo.isNullOrNil(str2)) {
                                ab.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
                            } else {
                                PString pString = new PString();
                                PString pString2 = new PString();
                                str2 = bo.anj(str2);
                                int indexOf = str2.indexOf("<pushcontent");
                                if (indexOf > 0) {
                                    str2 = str2.substring(indexOf);
                                }
                                Map z = br.z(str2, "pushcontent");
                                if (z == null) {
                                    ab.e("MicroMsg.NetPushSync", "inval xml");
                                } else {
                                    pString.value = (String) z.get(".pushcontent.$content");
                                    pString2.value = (String) z.get(".pushcontent.$nickname");
                                }
                                PluginZero pluginZero = (PluginZero) g.M(PluginZero.class);
                                if (pluginZero.yaf != null) {
                                    pluginZero.yaf.a(j, str5, pString2.value, pString.value, (com.tencent.mm.compatible.util.e.eSi + com.tencent.mm.a.g.x(("mm" + aa.ano().gcU.QF()).getBytes())) + "/avatar/", i5);
                                }
                            }
                            if (cmVar.nao == 10002) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                ab.i("MicroMsg.NetPushSync", "need remove pushContent");
                                cmVar.vEH = null;
                                tbVar.wau = com.tencent.mm.platformtools.aa.ad(cmVar.toByteArray());
                            }
                        }
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.NetPushSync", e, "", new Object[0]);
                    }
                }
            }
            try {
                anf = bVar.vyH.toByteArray();
                size = aa.ano().gcU.QF();
                str4 = com.tencent.mm.booter.g.ij(size);
                int jH = com.tencent.mm.booter.g.jH(str4) + 1;
                String str6 = str4 + "/syncResp.bin" + jH;
                byte[] d = l.d(anf, com.tencent.mm.a.g.x((com.tencent.mm.compatible.e.q.LK() + size).getBytes()).getBytes());
                ab.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", Integer.valueOf(jH), Integer.valueOf(anf.length), Integer.valueOf(d.length), str6, com.tencent.mm.booter.g.J(anf), com.tencent.mm.booter.g.J(d), com.tencent.mm.booter.g.J(str3.getBytes()));
                if (bo.cb(d)) {
                    ab.e("MicroMsg.NotifySyncMgr", "encry failed");
                } else {
                    i4 = com.tencent.mm.a.e.b(str6, d, d.length);
                    boolean ct = com.tencent.mm.a.e.ct(str6);
                    if (i4 == 0 && ct) {
                        anf = String.valueOf(jH).getBytes();
                        com.tencent.mm.a.e.b(str4 + "/syncResp.ini", anf, anf.length);
                    } else {
                        ab.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", Integer.valueOf(i4), Boolean.valueOf(ct));
                    }
                }
            } catch (IOException e2) {
                ab.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", e2);
                ab.printErrStackTrace("MicroMsg.NetPushSync", e2, "", new Object[0]);
            }
            ab.d("MicroMsg.NetPushSync", "onRespHandled sync");
            ah.getContext().getSharedPreferences("notify_sync_pref", h.Mu()).edit().putString("notify_sync_key_keybuf", bo.cd(com.tencent.mm.platformtools.aa.a(bVar.vyH.vTO))).commit();
            ab.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", Integer.valueOf(this.fHK));
            if (obj2 == null) {
                obj = ((bVar.vyH.vQe & fHJ) == 0 || super.acJ()) ? null : 1;
                ab.i("MicroMsg.NetPushSync", "continue flag=" + bVar.vyH.vQe + ", selector=" + fHJ + ", limit reach=" + super.acJ());
                if (obj != null) {
                    a(this.ftf, this.ehi);
                    if (obj2 != null) {
                        CoreService.Ie();
                    }
                    AppMethodBeat.o(58358);
                    return;
                }
            }
            if ((this.fHK & 1) > 0) {
                ab.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
                new f(this.fHM, com.tencent.mm.platformtools.aa.a(bVar.vyH.vTO), aa.ano().gcU.QF()).a(aa.ano(), new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(58348);
                        ab.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        mVar.ftk = true;
                        AppMethodBeat.o(58348);
                    }
                });
            }
            this.ehi.onSceneEnd(this.errType, this.errCode, this.aIm, this);
            if (obj2 != null) {
            }
            AppMethodBeat.o(58358);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(58358);
    }
}
