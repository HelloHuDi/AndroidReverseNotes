package com.tencent.mm.app.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.de;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public com.tencent.mm.ui.chatting.d.a cgL;
    public b cgM;
    public a cgN;
    private String cgO;
    public Map<String, Boolean> cgP;
    public boolean cgQ = true;

    class b extends c<lq> {
        b() {
            AppMethodBeat.i(15725);
            this.xxI = lq.class.getName().hashCode();
            AppMethodBeat.o(15725);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15726);
            lq lqVar = (lq) bVar;
            if (a.this.cgL != null) {
                if (!a.this.cgL.yTx.isFinishing()) {
                    int i = lqVar.cHu.op;
                    String str = lqVar.cHu.cEN;
                    ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "opcode is %d, brand name is %s", Integer.valueOf(i), str);
                    if (a.this.cgL.getTalkerUserName().equals(str)) {
                        switch (i) {
                            case 1:
                                a aVar = a.this;
                                ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "handleConnectFailedReason, reason : %d, brand name : %s", Integer.valueOf(lqVar.cHu.boZ), str);
                                d qX = f.qX(str);
                                if (a.a(qX)) {
                                    if (qX.cJ(false).aej().fvI == 1) {
                                        aVar.cgL.yTx.setMMSubTitle(null);
                                        break;
                                    }
                                }
                                ab.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
                                break;
                                break;
                            case 2:
                                a.this.d(lqVar.cHu.cxs, str, lqVar.cHu.ceI);
                                break;
                            case 3:
                                if (a.this.cgP != null) {
                                    a.this.cgP.clear();
                                    ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "clear connected device ids successfully.");
                                    break;
                                }
                                break;
                        }
                    }
                    ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "not current brandname");
                } else {
                    ab.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context isFinishing");
                }
            } else {
                ab.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context == null");
            }
            AppMethodBeat.o(15726);
            return false;
        }
    }

    class a extends c<de> {
        a() {
            AppMethodBeat.i(15724);
            this.xxI = de.class.getName().hashCode();
            AppMethodBeat.o(15724);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ((de) bVar).cwp.cgQ = a.this.cgQ;
            return true;
        }
    }

    public a(com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(15727);
        ab.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
        this.cgL = aVar;
        if (this.cgM == null) {
            this.cgM = new b();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.cgM);
        if (this.cgN == null) {
            this.cgN = new a();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.cgN);
        AppMethodBeat.o(15727);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void d(int i, String str, String str2) {
        AppMethodBeat.i(15728);
        ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", Integer.valueOf(i));
        if (this.cgL == null || bo.isNullOrNil(str)) {
            ab.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
            AppMethodBeat.o(15728);
        } else {
            d qX = f.qX(str);
            if (a(qX)) {
                if (this.cgP == null) {
                    this.cgP = new HashMap();
                }
                Map map = this.cgP;
                if (!str.equals(this.cgO)) {
                    this.cgO = str;
                    map.clear();
                }
                if (qX.cJ(false).aej().fvI == 1) {
                    this.cgL.yTx.setMMSubTitle(null);
                    AppMethodBeat.o(15728);
                } else {
                    ab.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", map, str2);
                    switch (i) {
                        case -1:
                            this.cgL.yTx.setMMSubTitle(null);
                            AppMethodBeat.o(15728);
                            break;
                        case 0:
                            if (map.size() == 0) {
                                this.cgL.yTx.setMMSubTitle((int) R.string.bg_);
                                AppMethodBeat.o(15728);
                                break;
                            }
                        case 1:
                            if (map.size() == 0) {
                                this.cgL.yTx.setMMSubTitle((int) R.string.bg9);
                            }
                            AppMethodBeat.o(15728);
                            break;
                        case 2:
                            map.put(str2, Boolean.TRUE);
                            this.cgL.yTx.setMMSubTitle(this.cgL.yTx.getString(R.string.bg8, Integer.valueOf(map.size())));
                            ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", str2);
                            AppMethodBeat.o(15728);
                            break;
                        case 4:
                            if (map.remove(str2) != null) {
                                ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", str2);
                            }
                            this.cgL.yTx.setMMSubTitle(this.cgL.yTx.getString(R.string.bg8, Integer.valueOf(map.size())));
                            AppMethodBeat.o(15728);
                            break;
                    }
                    AppMethodBeat.o(15728);
                }
            } else {
                ab.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
                AppMethodBeat.o(15728);
            }
        }
    }

    public final void a(final int i, d dVar) {
        AppMethodBeat.i(15729);
        if (this.cgL == null) {
            ab.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
            AppMethodBeat.o(15729);
            return;
        }
        if (t.mZ(this.cgL.getTalkerUserName()) && a(dVar)) {
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(15723);
                    if (1 == i) {
                        ed edVar = new ed();
                        edVar.cxE.op = 0;
                        edVar.cxE.userName = a.this.cgL.getTalkerUserName();
                        edVar.cxE.context = a.this.cgL.yTx.getContext();
                        com.tencent.mm.sdk.b.a.xxA.m(edVar);
                        if (a.this.cgL.getTalkerUserName().equals("gh_43f2581f6fd6")) {
                            com.tencent.mm.sdk.b.b sdVar = new sd();
                            sdVar.cOe.action = 1;
                            com.tencent.mm.sdk.b.a.xxA.a(sdVar, com.tencent.mm.sdk.g.d.xDG.cin());
                        }
                    }
                    jo joVar = new jo();
                    joVar.cEM.opType = i;
                    joVar.cEM.cEO = 1;
                    joVar.cEM.cEN = a.this.cgL.getTalkerUserName();
                    com.tencent.mm.sdk.b.a.xxA.m(joVar);
                    AppMethodBeat.o(15723);
                }
            });
        }
        AppMethodBeat.o(15729);
    }

    public static boolean a(d dVar) {
        AppMethodBeat.i(15730);
        if (dVar == null) {
            AppMethodBeat.o(15730);
            return false;
        }
        if (dVar != null) {
            com.tencent.mm.aj.d.b cJ = dVar.cJ(false);
            if (!(cJ == null || cJ.aej() == null || !cJ.aej().aes())) {
                AppMethodBeat.o(15730);
                return true;
            }
        }
        AppMethodBeat.o(15730);
        return false;
    }
}
