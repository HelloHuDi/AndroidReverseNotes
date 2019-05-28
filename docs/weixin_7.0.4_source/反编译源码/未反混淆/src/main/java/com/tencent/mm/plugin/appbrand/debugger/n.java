package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.sdk.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.j;
import com.tencent.mm.plugin.appbrand.l.k;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.crb;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class n implements i {
    private Activity gNy;
    l hjR;
    String hjS;
    s hjT;
    p hjU = new p();
    b hjV;
    public u hjW;
    k.b hjX = new k.b() {
        public final void azg() {
            AppMethodBeat.i(101830);
            ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
            n.this.hjR.hjx = System.currentTimeMillis();
            n.this.hjR.hjJ = 0;
            if (!bo.isNullOrNil(n.this.hjR.ayY())) {
                n.a(n.this);
            }
            p pVar = n.this.hjU;
            pVar.azo();
            pVar.mTimer = new Timer();
            pVar.mTimer.schedule(new TimerTask() {
                public final void run() {
                    AppMethodBeat.i(101860);
                    if (p.this.hjR.isBusy() && p.this.azl()) {
                        ab.i("MicroMsg.RemoteDebugMsgMrg", "testServer");
                    } else {
                        p.this.azk();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - p.this.hjR.hjx >= 10000) {
                            p pVar = p.this;
                            a crj = new crj();
                            crj.xoU = pVar.hjR.hjo;
                            crj.xoV = pVar.hjR.ayZ();
                            pVar.hjT.a(t.a(1001, crj));
                        }
                        if (p.this.hjR.isReady() && currentTimeMillis - p.this.hjR.hjy >= 30000) {
                            p.this.cV(p.this.hjR.ayZ(), BaseClientBuilder.API_PRIORITY_OTHER);
                        }
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(101922);
                            u.h(u.this);
                            u.j(u.this);
                            AppMethodBeat.o(101922);
                        }
                    });
                    AppMethodBeat.o(101860);
                }
            }, 100, 1000);
            AppMethodBeat.o(101830);
        }

        public final void zJ(String str) {
            AppMethodBeat.i(101831);
            ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", str);
            n.this.hjW.zQ(str);
            AppMethodBeat.o(101831);
        }

        public final void azh() {
            AppMethodBeat.i(101832);
            n.this.hjR.hjx = System.currentTimeMillis();
            AppMethodBeat.o(101832);
        }

        public final void l(ByteBuffer byteBuffer) {
            AppMethodBeat.i(101833);
            n.this.hjR.hjx = System.currentTimeMillis();
            try {
                cqs cqs = (cqs) new cqs().parseFrom(d.q(byteBuffer));
                if (cqs.wdt == null) {
                    ab.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
                    AppMethodBeat.o(101833);
                    return;
                }
                byte[] bArr = cqs.wdt.wR;
                p pVar;
                switch (cqs.Cn) {
                    case 1001:
                        t.a(n.this.hjR, cqs, ((crk) new crk().parseFrom(bArr)).xoW, n.this.hjW, n.this.hjU);
                        n.this.hjR.hjx = System.currentTimeMillis();
                        break;
                    case 1002:
                        cro cro = (cro) new cro().parseFrom(bArr);
                        n nVar = n.this;
                        if (t.a(nVar.hjR, cqs, cro.xoW, nVar.hjW, nVar.hjU)) {
                            ab.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
                            if (cro.xpg != null) {
                                if (!cro.xpg.xoO) {
                                    ab.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
                                    nVar.hjR.setStatus(2);
                                    a crl = new crl();
                                    crl.xoU = nVar.hjR.hjo;
                                    crl.xoP = nVar.hjR.hjt.ehq;
                                    crl.username = "";
                                    crl.xpf = nVar.hjR.hjt.hjM;
                                    nVar.hjT.a(t.a(1003, crl));
                                    break;
                                }
                                nVar.hjR.hjs = cro.xpg;
                                nVar.onReady();
                                break;
                            }
                            ab.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
                            break;
                        }
                        break;
                    case 1003:
                        if (t.a(n.this.hjR, cqs, ((crm) new crm().parseFrom(bArr)).xoW, n.this.hjW, n.this.hjU)) {
                            n.b(n.this);
                            break;
                        }
                        break;
                    case 1004:
                        p pVar2;
                        if (!n.this.hjV.isRunning()) {
                            pVar2 = n.this.hjU;
                            ab.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
                            pVar2.azm();
                            u uVar = pVar2.hjW;
                            uVar.setVisibility(8);
                            if (uVar.getParent() instanceof ViewGroup) {
                                ((ViewGroup) uVar.getParent()).removeView(uVar);
                                uVar.removeAllViews();
                            }
                            uVar.hkC = null;
                            break;
                        }
                        pVar2 = n.this.hjU;
                        ab.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                        pVar2.azm();
                        u uVar2 = pVar2.hjW;
                        uVar2.azw();
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(101921);
                                u.i(u.this);
                                AppMethodBeat.o(101921);
                            }
                        });
                        break;
                    case 1005:
                        crr crr = (crr) new crr().parseFrom(bArr);
                        pVar = n.this.hjU;
                        ab.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                        if (t.a(pVar.hjR, cqs, crr.xoW, pVar.hjW, pVar)) {
                            pVar.u(crr.xoJ);
                            pVar.hjR.nH(crr.xpj);
                            pVar.azn();
                            break;
                        }
                        break;
                    case 1006:
                        crh crh = (crh) new crh().parseFrom(bArr);
                        pVar = n.this.hjU;
                        if (t.a(pVar.hjR, cqs, crh.xoW, pVar.hjW, pVar)) {
                            ab.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", Integer.valueOf(crh.xoX), Integer.valueOf(crh.xoY));
                            pVar.hjR.cU(crh.xoX, crh.xoY);
                            pVar.cW(crh.xoX, crh.xoY);
                        }
                        q.a(cqs, (k) n.this.hjR.hjG.get(cqs.eCq));
                        break;
                    case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                        n.this.hjU.u(((cqz) new cqz().parseFrom(bArr)).xoJ);
                        break;
                    case 3001:
                        n.this.onReady();
                        break;
                    case 3002:
                        n.this.hjR.setStatus(4);
                        n.this.hjU.quit();
                        break;
                }
                ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", Integer.valueOf(cqs.Cn));
                AppMethodBeat.o(101833);
            } catch (Throwable th) {
                ab.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", Log.getStackTraceString(th));
                AppMethodBeat.o(101833);
            }
        }

        public final void K(int i, String str) {
            int i2 = 1;
            AppMethodBeat.i(101834);
            ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", Integer.valueOf(i), str);
            l lVar = n.this.hjR;
            if (lVar.azc() || ((long) lVar.hjJ) >= 10) {
                i2 = 0;
            }
            if (i2 != 0) {
                m.aNS().m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(101829);
                        n.this.connect();
                        AppMethodBeat.o(101829);
                    }
                }, 1000);
                l lVar2 = n.this.hjR;
                lVar2.hjJ++;
            }
            n.this.hjU.azo();
            n.this.hjR.hjx = System.currentTimeMillis();
            n.this.hjW.azw();
            n.this.hjR.setStatus(5);
            n.this.hjW.zQ(str);
            AppMethodBeat.o(101834);
        }

        public final void zK(String str) {
            AppMethodBeat.i(101835);
            ab.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", str);
            AppMethodBeat.o(101835);
        }
    };

    public n() {
        AppMethodBeat.i(101840);
        com.tencent.mm.sdk.b.a.xxA.b(new c<com.tencent.mm.g.a.m>() {
            {
                AppMethodBeat.i(101837);
                this.xxI = com.tencent.mm.g.a.m.class.getName().hashCode();
                AppMethodBeat.o(101837);
            }

            private boolean a(com.tencent.mm.g.a.m mVar) {
                AppMethodBeat.i(101838);
                if (mVar == null || mVar.csn == null || mVar.csn.csq == null) {
                    AppMethodBeat.o(101838);
                } else {
                    crb crb = new crb();
                    crb.cso = mVar.csn.cso;
                    crb.csp = mVar.csn.csp;
                    crb.xoK = mVar.csn.csq.toString();
                    crb.timestamp = System.currentTimeMillis();
                    n.this.a(t.a(crb, n.this.hjR, "networkDebugAPI"));
                    AppMethodBeat.o(101838);
                }
                return true;
            }
        });
        AppMethodBeat.o(101840);
    }

    public final void a(l lVar) {
        AppMethodBeat.i(101841);
        this.hjR = lVar;
        this.hjV = this.hjR.hjn;
        this.gNy = (Activity) this.hjV.getContext();
        this.hjW = new u(this.gNy, this.hjR, new u.a() {
            public final void azf() {
                AppMethodBeat.i(101828);
                n.this.destroy();
                g.a(n.this.hjV.getAppId(), g.d.CLOSE);
                n.this.hjV.xL().finish();
                AppMethodBeat.o(101828);
            }
        });
        u uVar = this.hjW;
        uVar.hkC = (ViewGroup) this.hjV.xL().gNE.getParent();
        for (int i = 0; i < uVar.hkC.getChildCount(); i++) {
            View childAt = uVar.hkC.getChildAt(i);
            if (childAt instanceof u) {
                uVar.hkC.removeView(childAt);
            }
        }
        uVar.hkC.addView(uVar);
        uVar.hkC.bringChildToFront(uVar);
        uVar.hkD = (RemoteDebugMoveView) LayoutInflater.from(uVar.getContext()).inflate(R.layout.de, null);
        uVar.hkG = (TextView) uVar.hkD.findViewById(R.id.v7);
        uVar.hkF = (TextView) uVar.hkD.findViewById(R.id.vb);
        uVar.hkH = (TextView) uVar.hkD.findViewById(R.id.vc);
        uVar.hkI = (TextView) uVar.hkD.findViewById(R.id.vf);
        uVar.hkJ = (TextView) uVar.hkD.findViewById(R.id.v8);
        uVar.hkK = (TextView) uVar.hkD.findViewById(R.id.vg);
        uVar.hkL = (TextView) uVar.hkD.findViewById(R.id.vd);
        uVar.hkN = (ImageView) uVar.hkD.findViewById(R.id.v6);
        uVar.hkM = (ImageView) uVar.hkD.findViewById(R.id.va);
        uVar.hkO = uVar.hkD.findViewById(R.id.v9);
        uVar.show();
        uVar.hkJ.setOnClickListener(uVar.mOnClickListener);
        uVar.hkK.setOnClickListener(uVar.mOnClickListener);
        uVar.hkI.setOnClickListener(uVar.mOnClickListener);
        uVar.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(101916);
                RemoteDebugMoveView a = u.this.hkD;
                int width = u.this.getWidth();
                int height = u.this.getHeight();
                a.setLayoutParams(new LayoutParams(-2, -2));
                a.hkc = width;
                a.hkd = height;
                a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(101851);
                        RemoteDebugMoveView.this.setX((float) (RemoteDebugMoveView.this.hkc - RemoteDebugMoveView.b(RemoteDebugMoveView.this)));
                        RemoteDebugMoveView.this.setY((float) ((int) (com.tencent.mm.bz.a.getDensity(ah.getContext()) * 120.0f)));
                        AppMethodBeat.o(101851);
                    }
                });
                u.this.addView(u.this.hkD);
                AppMethodBeat.o(101916);
            }
        }, 100);
        connect();
        if (bo.isNullOrNil(this.hjR.ayY())) {
            ab.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
            ((com.tencent.mm.plugin.appbrand.networking.a) this.hjV.B(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", new anr(), ans.class).c(new com.tencent.mm.vending.c.a<Object, ans>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(101836);
                    ans ans = (ans) obj;
                    if (ans == null) {
                        ab.e("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, null response");
                    } else if (ans.BaseResponse.Ret != 0) {
                        ab.e("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, errCode = %d, errMsg = %s, rr.resp = %b", Integer.valueOf(ans.BaseResponse.Ret), ans.BaseResponse.ErrMsg, Boolean.FALSE);
                    } else {
                        n.this.hjR.zI(ans.wsq);
                        ab.i("MicroMsg.RemoteDebugJsEngine", "loginTicket %s", ans.wsq);
                        if (n.this.hjT.isOpen()) {
                            n.a(n.this);
                        }
                    }
                    AppMethodBeat.o(101836);
                    return null;
                }
            });
        }
        AppMethodBeat.o(101841);
    }

    public final void addJavascriptInterface(Object obj, String str) {
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(101842);
        if (this.hjR.azb()) {
            AppMethodBeat.o(101842);
        } else if (this.hjR.isReady()) {
            cqx cqx = new cqx();
            cqx.xoI = this.hjR.hjz.incrementAndGet();
            cqx.script = str;
            this.hjU.a(t.a(cqx, this.hjR, "evaluateJavascript"));
            int i = cqx.xoI;
            b bVar = new b();
            if (bo.isNullOrNil(this.hjS)) {
                bVar.ctq = q.zM(str);
            } else {
                bVar.ctq = this.hjS;
                this.hjS = null;
            }
            bVar.hjf = System.currentTimeMillis();
            bVar.size = str.length();
            bVar.hje = valueCallback;
            this.hjR.hjI.put(Integer.valueOf(i), bVar);
            AppMethodBeat.o(101842);
        } else {
            this.hjR.hjE.add(new Pair(str, valueCallback));
            this.hjS = null;
            AppMethodBeat.o(101842);
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(101843);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(101843);
    }

    public final void a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(101844);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.o(101844);
    }

    public final void setJsExceptionHandler(h hVar) {
    }

    public final void destroy() {
        AppMethodBeat.i(101845);
        this.hjU.quit();
        this.hjU.azo();
        AppMethodBeat.o(101845);
    }

    public final <T extends j> T af(Class<T> cls) {
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void connect() {
        AppMethodBeat.i(101846);
        if (this.hjT == null) {
            this.hjT = new s((com.tencent.mm.plugin.appbrand.l.a) this.hjV.aa(com.tencent.mm.plugin.appbrand.l.a.class));
            this.hjU.a(this.hjT, this.hjR, this.hjW);
        }
        if (this.hjR.aze()) {
            this.hjT.a("ws://localhost:" + this.hjR.hjt.hjP, this.hjX);
            AppMethodBeat.o(101846);
            return;
        }
        this.hjT.a("wss://wxagame.weixin.qq.com/remote/", this.hjX);
        AppMethodBeat.o(101846);
    }

    /* Access modifiers changed, original: final */
    public final void onReady() {
        AppMethodBeat.i(101847);
        ab.i("MicroMsg.RemoteDebugJsEngine", "onReady");
        this.hjR.setStatus(3);
        ab.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
        Iterator it = this.hjR.hjE.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
        }
        this.hjR.hjE.clear();
        this.hjU.cV(this.hjR.ayZ(), BaseClientBuilder.API_PRIORITY_OTHER);
        this.hjW.azw();
        AppMethodBeat.o(101847);
    }

    public final void a(o oVar) {
        AppMethodBeat.i(101848);
        this.hjU.a(oVar);
        AppMethodBeat.o(101848);
    }

    static /* synthetic */ void b(n nVar) {
        AppMethodBeat.i(101850);
        WxaPkgWrappingInfo avm = nVar.hjV.asG().avm();
        cri cri = new cri();
        cqu cqu = new cqu();
        cri.xpa = cqu;
        if (nVar.hjV instanceof i) {
            cri.xpb = ((i) nVar.hjV).ayX();
        }
        cri.xpd = nVar.hjV.xL().xZ().hhd.cvZ;
        cri.xpe = 1;
        String xn = com.tencent.mm.plugin.appbrand.appcache.i.xn("WAService.js");
        if (!bo.isNullOrNil(xn)) {
            cri.xpc = com.tencent.mm.a.g.x(xn.getBytes());
        }
        cqu.xoC = avm.gVu;
        cqu.wbe = com.tencent.mm.protocal.d.vxj;
        cqu.xoz = com.tencent.mm.protocal.d.DEVICE_NAME;
        cqu.xoB = com.tencent.mm.sdk.platformtools.g.ar(nVar.gNy, f.xxY);
        cqu.xoA = com.tencent.mm.protocal.d.vxm;
        cqu.xoE = nVar.gNy.getResources().getDisplayMetrics().density;
        cqu.xoD = ((float) nVar.gNy.getResources().getDisplayMetrics().widthPixels) / cqu.xoE;
        if (!(nVar.hjV.ac(com.tencent.luggage.sdk.a.a.a.class) == null || ((com.tencent.luggage.sdk.a.a.a) nVar.hjV.ac(com.tencent.luggage.sdk.a.a.a.class)).aJz() == null)) {
            cqu.xoF = ((com.tencent.luggage.sdk.a.a.a) nVar.hjV.ac(com.tencent.luggage.sdk.a.a.a.class)).aJz().getUserAgentString();
        }
        cre cre = new cre();
        p.a(cre);
        cri.xoZ = cre;
        nVar.hjU.a(t.a(cri, nVar.hjR, "setupContext"));
        ab.d("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d, %s", cri.xpc, cri.xpd, Integer.valueOf(cqu.xoC), cqu.xoF);
        AppMethodBeat.o(101850);
    }
}
