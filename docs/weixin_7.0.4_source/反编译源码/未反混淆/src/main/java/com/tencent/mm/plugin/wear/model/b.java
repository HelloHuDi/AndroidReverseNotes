package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

public final class b implements f {
    com.tencent.mm.sdk.e.n.b mFC = new com.tencent.mm.sdk.e.n.b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(26276);
            if (obj == null || !(obj instanceof String)) {
                ab.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
                AppMethodBeat.o(26276);
                return;
            }
            String str = (String) obj;
            if (str != null && str.equals("gh_43f2581f6fd6")) {
                if (!b.cUo() && b.this.tXD) {
                    b.this.tXD = false;
                    AppMethodBeat.o(26276);
                    return;
                } else if (b.cUo() && !b.this.tXD) {
                    b.this.connect();
                }
            }
            AppMethodBeat.o(26276);
        }
    };
    boolean tXD;
    c tXE = new c<vi>() {
        {
            AppMethodBeat.i(26273);
            this.xxI = vi.class.getName().hashCode();
            AppMethodBeat.o(26273);
        }

        /* JADX WARNING: Missing block: B:7:0x0038, code skipped:
            if (r11.cSq.cxT != false) goto L_0x003a;
     */
        /* JADX WARNING: Missing block: B:10:0x0067, code skipped:
            if (r10.tXG.tXD != false) goto L_0x003a;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(26274);
            vi viVar = (vi) bVar;
            if (viVar instanceof vi) {
                switch (viVar.cSq.cuy) {
                    case 2:
                        ab.i("MicroMsg.Wear.WearBizLogic", "receive register response, deviceId=%s | isSuccess=%b", viVar.cSq.ceI, Boolean.valueOf(viVar.cSq.cxT));
                        break;
                    case 5:
                        ab.i("MicroMsg.Wear.WearBizLogic", "receive send response, deviceId=%s | isSuccess=%b", viVar.cSq.ceI, Boolean.valueOf(viVar.cSq.cxT));
                        break;
                    case 6:
                        ctv ctv = a.cUn().tXt.tXK.tYz;
                        if (ctv != null && ctv.xqs.equals(viVar.cSq.ceI)) {
                            ab.i("MicroMsg.Wear.WearBizLogic", "request step count deviceId=%s", viVar.cSq.ceI);
                            b bVar2 = b.this;
                            boolean adq = b.adq(viVar.cSq.ceI);
                            boolean cUo = b.cUo();
                            if (!adq || !bVar2.tXD || !cUo) {
                                ab.i("MicroMsg.Wear.WearBizLogic", "isRegister=%b | isFocus=%b | isAuth=%b", Boolean.valueOf(adq), Boolean.valueOf(cUo), Boolean.valueOf(bVar2.tXD));
                                break;
                            }
                            a.cUn().tXz.a(new d() {
                                public final String getName() {
                                    return "StepCountRequest";
                                }

                                public final void execute() {
                                    AppMethodBeat.i(26275);
                                    a.cUn();
                                    r.b(20008, null, false);
                                    AppMethodBeat.o(26275);
                                }
                            });
                            break;
                        }
                        ab.i("MicroMsg.Wear.WearBizLogic", "request is null or request.LocalNodeId is not same!");
                        break;
                        break;
                    case 8:
                        ab.i("MicroMsg.Wear.WearBizLogic", "receive auth response, deviceId=%s | isSuccess=%b", viVar.cSq.ceI, Boolean.valueOf(viVar.cSq.cxT));
                        b.this.tXD = viVar.cSq.cxT;
                        break;
                    case 9:
                        b.this.connect();
                        break;
                }
            }
            AppMethodBeat.o(26274);
            return false;
        }
    };
    ap tXF = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(26277);
            b.a(a.cUn().tXt.tXK.tYz);
            AppMethodBeat.o(26277);
            return true;
        }
    }, true);

    class a extends d {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void execute() {
            AppMethodBeat.i(26278);
            aw.Rg().a(30, b.this);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            aw.Rg().a(new m(1, linkedList, linkedList2, "", ""), 0);
            AppMethodBeat.o(26278);
        }

        public final String getName() {
            return "AddContactTask";
        }
    }

    class b extends d {
        private ctv tXH;

        public b(ctv ctv) {
            this.tXH = ctv;
        }

        public final void execute() {
            AppMethodBeat.i(26279);
            aw.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA, b.this);
            aw.Rg().a(new com.tencent.mm.plugin.wear.model.d.a(this.tXH.xqs, "gh_43f2581f6fd6"), 0);
            AppMethodBeat.o(26279);
        }

        public final String getName() {
            return "RegisterDeviceTask";
        }
    }

    public b() {
        AppMethodBeat.i(26280);
        com.tencent.mm.sdk.b.a.xxA.c(this.tXE);
        aw.ZK();
        com.tencent.mm.model.c.XM().a(this.mFC);
        AppMethodBeat.o(26280);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(26282);
        String str2;
        if (mVar instanceof com.tencent.mm.plugin.wear.model.d.a) {
            aw.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA, (f) this);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wear.model.d.a aVar = (com.tencent.mm.plugin.wear.model.d.a) mVar;
                String str3 = aVar.ceI;
                str2 = aVar.cws;
                vi viVar = new vi();
                viVar.cSq.cuy = 1;
                viVar.cSq.ceI = str3;
                viVar.cSq.cws = str2;
                com.tencent.mm.sdk.b.a.xxA.m(viVar);
                AppMethodBeat.o(26282);
                return;
            }
            ab.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.o(26282);
            return;
        }
        if (mVar instanceof m) {
            aw.Rg().b(30, (f) this);
            if (i == 0 && i2 == 0) {
                str2 = ((m) mVar).dhl();
                ab.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", str2);
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO("gh_43f2581f6fd6");
                if (aoO == null || bo.isNullOrNil(str2)) {
                    ab.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + str2 + ", contact = " + aoO);
                } else {
                    com.tencent.mm.aj.d dVar = null;
                    if (t.mX(aoO.field_username)) {
                        String nullAsNil = bo.nullAsNil(aoO.field_username);
                        dVar = com.tencent.mm.aj.f.qX(nullAsNil);
                        if (dVar != null) {
                            dVar.field_username = str2;
                        }
                        z.aeR().delete(nullAsNil);
                        aoO.iH(nullAsNil);
                    }
                    aoO.setUsername(str2);
                    if (((int) aoO.ewQ) == 0) {
                        aw.ZK();
                        com.tencent.mm.model.c.XM().aa(aoO);
                    }
                    if (((int) aoO.ewQ) <= 0) {
                        ab.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
                    } else {
                        t.q(aoO);
                        aw.ZK();
                        ad aoO2 = com.tencent.mm.model.c.XM().aoO(aoO.field_username);
                        if (dVar != null) {
                            z.aeR().d(dVar);
                        } else {
                            dVar = com.tencent.mm.aj.f.qX(aoO2.field_username);
                            if (dVar == null || dVar.adJ()) {
                                ab.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
                                com.tencent.mm.model.ao.a.flu.ai(aoO2.field_username, "");
                                com.tencent.mm.ah.b.pY(aoO2.field_username);
                            } else if (aoO2.dsi()) {
                                ab.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", Integer.valueOf(aoO2.duj));
                                com.tencent.mm.model.ao.a.flu.ai(aoO2.field_username, "");
                                com.tencent.mm.ah.b.pY(aoO2.field_username);
                            }
                        }
                    }
                }
                z.aeR().e(z.aeR().qP(aoO.field_username));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(327825, Boolean.TRUE);
                connect();
            } else {
                ab.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                    Toast.makeText(ah.getContext(), str, 1).show();
                    AppMethodBeat.o(26282);
                    return;
                }
            }
        }
        AppMethodBeat.o(26282);
    }

    static boolean adq(String str) {
        AppMethodBeat.i(26283);
        vi viVar = new vi();
        viVar.cSq.cuy = 3;
        viVar.cSq.ceI = str;
        viVar.cSq.cws = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.b.a.xxA.m(viVar);
        ab.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", Boolean.valueOf(viVar.cSq.cxT));
        boolean z = viVar.cSq.cxT;
        AppMethodBeat.o(26283);
        return z;
    }

    static boolean cUo() {
        AppMethodBeat.i(26284);
        aw.ZK();
        boolean jh = com.tencent.mm.n.a.jh(com.tencent.mm.model.c.XM().aoO("gh_43f2581f6fd6").field_type);
        AppMethodBeat.o(26284);
        return jh;
    }

    public static void a(ctv ctv) {
        AppMethodBeat.i(26285);
        if (ctv != null) {
            vi viVar = new vi();
            viVar.cSq.cuy = 6;
            viVar.cSq.ceI = ctv.xqs;
            com.tencent.mm.sdk.b.a.xxA.m(viVar);
            AppMethodBeat.o(26285);
            return;
        }
        ab.i("MicroMsg.Wear.WearBizLogic", "request is null");
        AppMethodBeat.o(26285);
    }

    public final void connect() {
        AppMethodBeat.i(26281);
        ctv ctv = a.cUn().tXt.tXK.tYz;
        if (ctv == null) {
            ab.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
            AppMethodBeat.o(26281);
        } else if (!cUo()) {
            aw.ZK();
            ab.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", Boolean.valueOf(((Boolean) com.tencent.mm.model.c.Ry().get(327825, Boolean.FALSE)).booleanValue()));
            if (!((Boolean) com.tencent.mm.model.c.Ry().get(327825, Boolean.FALSE)).booleanValue()) {
                if (bo.gT(ah.getContext())) {
                    ab.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
                    AppMethodBeat.o(26281);
                    return;
                }
                a.cUn().tXz.a(new a(this, (byte) 0));
                a.cUn().tXz.a(new b(ctv));
            }
            AppMethodBeat.o(26281);
        } else if (!adq(ctv.xqs)) {
            ab.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", ctv.xqs);
            a.cUn().tXz.a(new b(ctv));
            AppMethodBeat.o(26281);
        } else if (this.tXD) {
            if (this.tXF.doT()) {
                ab.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
                this.tXF.ae(3600000, 3600000);
            } else {
                ab.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
                this.tXF.stopTimer();
                this.tXF.ae(3600000, 3600000);
            }
            a(ctv);
            AppMethodBeat.o(26281);
        } else {
            ab.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", ctv.xqs);
            String str = ctv.xqs;
            String str2 = "gh_43f2581f6fd6";
            if (!this.tXD && adq(str)) {
                ab.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", str, str2);
                vi viVar = new vi();
                viVar.cSq.cuy = 7;
                viVar.cSq.ceI = str;
                viVar.cSq.cws = str2;
                com.tencent.mm.sdk.b.a.xxA.m(viVar);
            }
            AppMethodBeat.o(26281);
        }
    }
}
