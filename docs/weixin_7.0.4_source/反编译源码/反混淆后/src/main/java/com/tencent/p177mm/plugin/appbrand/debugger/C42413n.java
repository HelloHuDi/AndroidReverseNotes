package com.tencent.p177mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p230g.p231a.C18319m;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.appcache.C10095i;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.debugger.C38177u.C268531;
import com.tencent.p177mm.plugin.appbrand.debugger.C38177u.C381766;
import com.tencent.p177mm.plugin.appbrand.debugger.C38177u.C38180a;
import com.tencent.p177mm.plugin.appbrand.debugger.C42417p.C21234;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.plugin.appbrand.p297h.C2169j;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C19543b;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.anr;
import com.tencent.p177mm.protocal.protobuf.ans;
import com.tencent.p177mm.protocal.protobuf.cqs;
import com.tencent.p177mm.protocal.protobuf.cqu;
import com.tencent.p177mm.protocal.protobuf.cqx;
import com.tencent.p177mm.protocal.protobuf.cqz;
import com.tencent.p177mm.protocal.protobuf.crb;
import com.tencent.p177mm.protocal.protobuf.cre;
import com.tencent.p177mm.protocal.protobuf.crh;
import com.tencent.p177mm.protocal.protobuf.cri;
import com.tencent.p177mm.protocal.protobuf.crk;
import com.tencent.p177mm.protocal.protobuf.crl;
import com.tencent.p177mm.protocal.protobuf.crm;
import com.tencent.p177mm.protocal.protobuf.cro;
import com.tencent.p177mm.protocal.protobuf.crr;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Timer;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.n */
public final class C42413n implements C6747i {
    private Activity gNy;
    C42411l hjR;
    String hjS;
    C10188s hjT;
    C42417p hjU = new C42417p();
    C45126b hjV;
    public C38177u hjW;
    C19543b hjX = new C424122();

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.n$4 */
    class C381754 extends C4884c<C18319m> {
        C381754() {
            AppMethodBeat.m2504i(101837);
            this.xxI = C18319m.class.getName().hashCode();
            AppMethodBeat.m2505o(101837);
        }

        /* renamed from: a */
        private boolean m64613a(C18319m c18319m) {
            AppMethodBeat.m2504i(101838);
            if (c18319m == null || c18319m.csn == null || c18319m.csn.csq == null) {
                AppMethodBeat.m2505o(101838);
            } else {
                crb crb = new crb();
                crb.cso = c18319m.csn.cso;
                crb.csp = c18319m.csn.csp;
                crb.xoK = c18319m.csn.csq.toString();
                crb.timestamp = System.currentTimeMillis();
                C42413n.this.mo67939a(C26852t.m42761a(crb, C42413n.this.hjR, "networkDebugAPI"));
                AppMethodBeat.m2505o(101838);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.n$2 */
    class C424122 implements C19543b {

        /* renamed from: com.tencent.mm.plugin.appbrand.debugger.n$2$1 */
        class C21221 implements Runnable {
            C21221() {
            }

            public final void run() {
                AppMethodBeat.m2504i(101829);
                C42413n.this.connect();
                AppMethodBeat.m2505o(101829);
            }
        }

        C424122() {
        }

        public final void azg() {
            AppMethodBeat.m2504i(101830);
            C4990ab.m7416i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
            C42413n.this.hjR.hjx = System.currentTimeMillis();
            C42413n.this.hjR.hjJ = 0;
            if (!C5046bo.isNullOrNil(C42413n.this.hjR.ayY())) {
                C42413n.m75099a(C42413n.this);
            }
            C42417p c42417p = C42413n.this.hjU;
            c42417p.azo();
            c42417p.mTimer = new Timer();
            c42417p.mTimer.schedule(new C21234(), 100, 1000);
            AppMethodBeat.m2505o(101830);
        }

        /* renamed from: zJ */
        public final void mo34738zJ(String str) {
            AppMethodBeat.m2504i(101831);
            C4990ab.m7417i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", str);
            C42413n.this.hjW.mo60917zQ(str);
            AppMethodBeat.m2505o(101831);
        }

        public final void azh() {
            AppMethodBeat.m2504i(101832);
            C42413n.this.hjR.hjx = System.currentTimeMillis();
            AppMethodBeat.m2505o(101832);
        }

        /* renamed from: l */
        public final void mo34737l(ByteBuffer byteBuffer) {
            AppMethodBeat.m2504i(101833);
            C42413n.this.hjR.hjx = System.currentTimeMillis();
            try {
                cqs cqs = (cqs) new cqs().parseFrom(C45672d.m84374q(byteBuffer));
                if (cqs.wdt == null) {
                    C4990ab.m7420w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
                    AppMethodBeat.m2505o(101833);
                    return;
                }
                byte[] bArr = cqs.wdt.f1226wR;
                C42417p c42417p;
                switch (cqs.f2979Cn) {
                    case 1001:
                        C26852t.m42764a(C42413n.this.hjR, cqs, ((crk) new crk().parseFrom(bArr)).xoW, C42413n.this.hjW, C42413n.this.hjU);
                        C42413n.this.hjR.hjx = System.currentTimeMillis();
                        break;
                    case 1002:
                        cro cro = (cro) new cro().parseFrom(bArr);
                        C42413n c42413n = C42413n.this;
                        if (C26852t.m42764a(c42413n.hjR, cqs, cro.xoW, c42413n.hjW, c42413n.hjU)) {
                            C4990ab.m7416i("MicroMsg.RemoteDebugJsEngine", "onLogin");
                            if (cro.xpg != null) {
                                if (!cro.xpg.xoO) {
                                    C4990ab.m7416i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
                                    c42413n.hjR.setStatus(2);
                                    C1331a crl = new crl();
                                    crl.xoU = c42413n.hjR.hjo;
                                    crl.xoP = c42413n.hjR.hjt.ehq;
                                    crl.username = "";
                                    crl.xpf = c42413n.hjR.hjt.hjM;
                                    c42413n.hjT.mo21583a(C26852t.m42762a(1003, crl));
                                    break;
                                }
                                c42413n.hjR.hjs = cro.xpg;
                                c42413n.onReady();
                                break;
                            }
                            C4990ab.m7412e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
                            break;
                        }
                        break;
                    case 1003:
                        if (C26852t.m42764a(C42413n.this.hjR, cqs, ((crm) new crm().parseFrom(bArr)).xoW, C42413n.this.hjW, C42413n.this.hjU)) {
                            C42413n.m75100b(C42413n.this);
                            break;
                        }
                        break;
                    case 1004:
                        C42417p c42417p2;
                        if (!C42413n.this.hjV.isRunning()) {
                            c42417p2 = C42413n.this.hjU;
                            C4990ab.m7416i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
                            c42417p2.azm();
                            C38177u c38177u = c42417p2.hjW;
                            c38177u.setVisibility(8);
                            if (c38177u.getParent() instanceof ViewGroup) {
                                ((ViewGroup) c38177u.getParent()).removeView(c38177u);
                                c38177u.removeAllViews();
                            }
                            c38177u.hkC = null;
                            break;
                        }
                        c42417p2 = C42413n.this.hjU;
                        C4990ab.m7416i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                        c42417p2.azm();
                        C38177u c38177u2 = c42417p2.hjW;
                        c38177u2.azw();
                        C5004al.m7441d(new C381766());
                        break;
                    case 1005:
                        crr crr = (crr) new crr().parseFrom(bArr);
                        c42417p = C42413n.this.hjU;
                        C4990ab.m7410d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                        if (C26852t.m42764a(c42417p.hjR, cqs, crr.xoW, c42417p.hjW, c42417p)) {
                            c42417p.mo67953u(crr.xoJ);
                            c42417p.hjR.mo67934nH(crr.xpj);
                            c42417p.azn();
                            break;
                        }
                        break;
                    case 1006:
                        crh crh = (crh) new crh().parseFrom(bArr);
                        c42417p = C42413n.this.hjU;
                        if (C26852t.m42764a(c42417p.hjR, cqs, crh.xoW, c42417p.hjW, c42417p)) {
                            C4990ab.m7411d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", Integer.valueOf(crh.xoX), Integer.valueOf(crh.xoY));
                            c42417p.hjR.mo67928cU(crh.xoX, crh.xoY);
                            c42417p.mo67951cW(crh.xoX, crh.xoY);
                        }
                        C26851q.m42758a(cqs, (C19166k) C42413n.this.hjR.hjG.get(cqs.eCq));
                        break;
                    case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                        C42413n.this.hjU.mo67953u(((cqz) new cqz().parseFrom(bArr)).xoJ);
                        break;
                    case 3001:
                        C42413n.this.onReady();
                        break;
                    case 3002:
                        C42413n.this.hjR.setStatus(4);
                        C42413n.this.hjU.quit();
                        break;
                }
                C4990ab.m7417i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", Integer.valueOf(cqs.f2979Cn));
                AppMethodBeat.m2505o(101833);
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", Log.getStackTraceString(th));
                AppMethodBeat.m2505o(101833);
            }
        }

        /* renamed from: K */
        public final void mo34734K(int i, String str) {
            int i2 = 1;
            AppMethodBeat.m2504i(101834);
            C4990ab.m7417i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", Integer.valueOf(i), str);
            C42411l c42411l = C42413n.this.hjR;
            if (c42411l.azc() || ((long) c42411l.hjJ) >= 10) {
                i2 = 0;
            }
            if (i2 != 0) {
                C45673m.aNS().mo10310m(new C21221(), 1000);
                C42411l c42411l2 = C42413n.this.hjR;
                c42411l2.hjJ++;
            }
            C42413n.this.hjU.azo();
            C42413n.this.hjR.hjx = System.currentTimeMillis();
            C42413n.this.hjW.azw();
            C42413n.this.hjR.setStatus(5);
            C42413n.this.hjW.mo60917zQ(str);
            AppMethodBeat.m2505o(101834);
        }

        /* renamed from: zK */
        public final void mo34739zK(String str) {
            AppMethodBeat.m2504i(101835);
            C4990ab.m7417i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", str);
            AppMethodBeat.m2505o(101835);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.n$1 */
    class C424141 implements C38180a {
        C424141() {
        }

        public final void azf() {
            AppMethodBeat.m2504i(101828);
            C42413n.this.destroy();
            C33183g.m54275a(C42413n.this.hjV.getAppId(), C33184d.CLOSE);
            C42413n.this.hjV.mo34954xL().finish();
            AppMethodBeat.m2505o(101828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.n$3 */
    class C424153 implements C5681a<Object, ans> {
        C424153() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(101836);
            ans ans = (ans) obj;
            if (ans == null) {
                C4990ab.m7412e("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, null response");
            } else if (ans.BaseResponse.Ret != 0) {
                C4990ab.m7413e("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, errCode = %d, errMsg = %s, rr.resp = %b", Integer.valueOf(ans.BaseResponse.Ret), ans.BaseResponse.ErrMsg, Boolean.FALSE);
            } else {
                C42413n.this.hjR.mo67937zI(ans.wsq);
                C4990ab.m7417i("MicroMsg.RemoteDebugJsEngine", "loginTicket %s", ans.wsq);
                if (C42413n.this.hjT.isOpen()) {
                    C42413n.m75099a(C42413n.this);
                }
            }
            AppMethodBeat.m2505o(101836);
            return null;
        }
    }

    public C42413n() {
        AppMethodBeat.m2504i(101840);
        C4879a.xxA.mo10051b(new C381754());
        AppMethodBeat.m2505o(101840);
    }

    /* renamed from: a */
    public final void mo67938a(C42411l c42411l) {
        AppMethodBeat.m2504i(101841);
        this.hjR = c42411l;
        this.hjV = this.hjR.hjn;
        this.gNy = (Activity) this.hjV.getContext();
        this.hjW = new C38177u(this.gNy, this.hjR, new C424141());
        C38177u c38177u = this.hjW;
        c38177u.hkC = (ViewGroup) this.hjV.mo34954xL().gNE.getParent();
        for (int i = 0; i < c38177u.hkC.getChildCount(); i++) {
            View childAt = c38177u.hkC.getChildAt(i);
            if (childAt instanceof C38177u) {
                c38177u.hkC.removeView(childAt);
            }
        }
        c38177u.hkC.addView(c38177u);
        c38177u.hkC.bringChildToFront(c38177u);
        c38177u.hkD = (RemoteDebugMoveView) LayoutInflater.from(c38177u.getContext()).inflate(2130968728, null);
        c38177u.hkG = (TextView) c38177u.hkD.findViewById(2131821354);
        c38177u.hkF = (TextView) c38177u.hkD.findViewById(2131821359);
        c38177u.hkH = (TextView) c38177u.hkD.findViewById(2131821360);
        c38177u.hkI = (TextView) c38177u.hkD.findViewById(2131821363);
        c38177u.hkJ = (TextView) c38177u.hkD.findViewById(2131821355);
        c38177u.hkK = (TextView) c38177u.hkD.findViewById(2131821364);
        c38177u.hkL = (TextView) c38177u.hkD.findViewById(2131821361);
        c38177u.hkN = (ImageView) c38177u.hkD.findViewById(2131821353);
        c38177u.hkM = (ImageView) c38177u.hkD.findViewById(2131821358);
        c38177u.hkO = c38177u.hkD.findViewById(2131821356);
        c38177u.show();
        c38177u.hkJ.setOnClickListener(c38177u.mOnClickListener);
        c38177u.hkK.setOnClickListener(c38177u.mOnClickListener);
        c38177u.hkI.setOnClickListener(c38177u.mOnClickListener);
        c38177u.postDelayed(new C268531(), 100);
        connect();
        if (C5046bo.isNullOrNil(this.hjR.ayY())) {
            C4990ab.m7416i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
            ((C42637a) this.hjV.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", new anr(), ans.class).mo15892c(new C424153());
        }
        AppMethodBeat.m2505o(101841);
    }

    public final void addJavascriptInterface(Object obj, String str) {
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(101842);
        if (this.hjR.azb()) {
            AppMethodBeat.m2505o(101842);
        } else if (this.hjR.isReady()) {
            cqx cqx = new cqx();
            cqx.xoI = this.hjR.hjz.incrementAndGet();
            cqx.script = str;
            this.hjU.mo67943a(C26852t.m42761a(cqx, this.hjR, "evaluateJavascript"));
            int i = cqx.xoI;
            C26846b c26846b = new C26846b();
            if (C5046bo.isNullOrNil(this.hjS)) {
                c26846b.ctq = C26851q.m42760zM(str);
            } else {
                c26846b.ctq = this.hjS;
                this.hjS = null;
            }
            c26846b.hjf = System.currentTimeMillis();
            c26846b.size = str.length();
            c26846b.hje = valueCallback;
            this.hjR.hjI.put(Integer.valueOf(i), c26846b);
            AppMethodBeat.m2505o(101842);
        } else {
            this.hjR.hjE.add(new Pair(str, valueCallback));
            this.hjS = null;
            AppMethodBeat.m2505o(101842);
        }
    }

    /* renamed from: a */
    public final void mo14967a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(101843);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(101843);
    }

    /* renamed from: a */
    public final void mo14968a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(101844);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.m2505o(101844);
    }

    public final void setJsExceptionHandler(C33211h c33211h) {
    }

    public final void destroy() {
        AppMethodBeat.m2504i(101845);
        this.hjU.quit();
        this.hjU.azo();
        AppMethodBeat.m2505o(101845);
    }

    /* renamed from: af */
    public final <T extends C2169j> T mo14970af(Class<T> cls) {
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void connect() {
        AppMethodBeat.m2504i(101846);
        if (this.hjT == null) {
            this.hjT = new C10188s((C38414a) this.hjV.mo5937aa(C38414a.class));
            this.hjU.mo67944a(this.hjT, this.hjR, this.hjW);
        }
        if (this.hjR.aze()) {
            this.hjT.mo21582a("ws://localhost:" + this.hjR.hjt.hjP, this.hjX);
            AppMethodBeat.m2505o(101846);
            return;
        }
        this.hjT.mo21582a("wss://wxagame.weixin.qq.com/remote/", this.hjX);
        AppMethodBeat.m2505o(101846);
    }

    /* Access modifiers changed, original: final */
    public final void onReady() {
        AppMethodBeat.m2504i(101847);
        C4990ab.m7416i("MicroMsg.RemoteDebugJsEngine", "onReady");
        this.hjR.setStatus(3);
        C4990ab.m7416i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
        Iterator it = this.hjR.hjE.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
        }
        this.hjR.hjE.clear();
        this.hjU.mo67950cV(this.hjR.ayZ(), BaseClientBuilder.API_PRIORITY_OTHER);
        this.hjW.azw();
        AppMethodBeat.m2505o(101847);
    }

    /* renamed from: a */
    public final void mo67939a(C42416o c42416o) {
        AppMethodBeat.m2504i(101848);
        this.hjU.mo67943a(c42416o);
        AppMethodBeat.m2505o(101848);
    }

    /* renamed from: b */
    static /* synthetic */ void m75100b(C42413n c42413n) {
        AppMethodBeat.m2504i(101850);
        WxaPkgWrappingInfo avm = c42413n.hjV.asG().avm();
        cri cri = new cri();
        cqu cqu = new cqu();
        cri.xpa = cqu;
        if (c42413n.hjV instanceof C26849i) {
            cri.xpb = ((C26849i) c42413n.hjV).ayX();
        }
        cri.xpd = c42413n.hjV.mo34954xL().mo43489xZ().hhd.cvZ;
        cri.xpe = 1;
        String xn = C10095i.m17688xn("WAService.js");
        if (!C5046bo.isNullOrNil(xn)) {
            cri.xpc = C1178g.m2591x(xn.getBytes());
        }
        cqu.xoC = avm.gVu;
        cqu.wbe = C7243d.vxj;
        cqu.xoz = C7243d.DEVICE_NAME;
        cqu.xoB = C5059g.m7672ar(c42413n.gNy, C5058f.xxY);
        cqu.xoA = C7243d.vxm;
        cqu.xoE = c42413n.gNy.getResources().getDisplayMetrics().density;
        cqu.xoD = ((float) c42413n.gNy.getResources().getDisplayMetrics().widthPixels) / cqu.xoE;
        if (!(c42413n.hjV.mo61196ac(C37402a.class) == null || ((C37402a) c42413n.hjV.mo61196ac(C37402a.class)).aJz() == null)) {
            cqu.xoF = ((C37402a) c42413n.hjV.mo61196ac(C37402a.class)).aJz().getUserAgentString();
        }
        cre cre = new cre();
        C42417p.m75115a(cre);
        cri.xoZ = cre;
        c42413n.hjU.mo67943a(C26852t.m42761a(cri, c42413n.hjR, "setupContext"));
        C4990ab.m7411d("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d, %s", cri.xpc, cri.xpd, Integer.valueOf(cqu.xoC), cqu.xoF);
        AppMethodBeat.m2505o(101850);
    }
}
