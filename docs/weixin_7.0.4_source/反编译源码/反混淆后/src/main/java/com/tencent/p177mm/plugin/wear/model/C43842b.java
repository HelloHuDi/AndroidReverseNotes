package com.tencent.p177mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C42076vi;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.wear.model.p1321d.C35553a;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.plugin.wear.model.p576f.C40186d;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.protocal.protobuf.ctv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.wear.model.b */
public final class C43842b implements C1202f {
    C4937b mFC = new C401813();
    boolean tXD;
    C4884c tXE = new C227281();
    C7564ap tXF = new C7564ap(Looper.getMainLooper(), new C438434(), true);

    /* renamed from: com.tencent.mm.plugin.wear.model.b$1 */
    class C227281 extends C4884c<C42076vi> {
        C227281() {
            AppMethodBeat.m2504i(26273);
            this.xxI = C42076vi.class.getName().hashCode();
            AppMethodBeat.m2505o(26273);
        }

        /* JADX WARNING: Missing block: B:7:0x0038, code skipped:
            if (r11.cSq.cxT != false) goto L_0x003a;
     */
        /* JADX WARNING: Missing block: B:10:0x0067, code skipped:
            if (r10.tXG.tXD != false) goto L_0x003a;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26274);
            C42076vi c42076vi = (C42076vi) c4883b;
            if (c42076vi instanceof C42076vi) {
                switch (c42076vi.cSq.cuy) {
                    case 2:
                        C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "receive register response, deviceId=%s | isSuccess=%b", c42076vi.cSq.ceI, Boolean.valueOf(c42076vi.cSq.cxT));
                        break;
                    case 5:
                        C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "receive send response, deviceId=%s | isSuccess=%b", c42076vi.cSq.ceI, Boolean.valueOf(c42076vi.cSq.cxT));
                        break;
                    case 6:
                        ctv ctv = C43841a.cUn().tXt.tXK.tYz;
                        if (ctv != null && ctv.xqs.equals(c42076vi.cSq.ceI)) {
                            C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "request step count deviceId=%s", c42076vi.cSq.ceI);
                            C43842b c43842b = C43842b.this;
                            boolean adq = C43842b.adq(c42076vi.cSq.ceI);
                            boolean cUo = C43842b.cUo();
                            if (!adq || !c43842b.tXD || !cUo) {
                                C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "isRegister=%b | isFocus=%b | isAuth=%b", Boolean.valueOf(adq), Boolean.valueOf(cUo), Boolean.valueOf(c43842b.tXD));
                                break;
                            }
                            C43841a.cUn().tXz.mo69532a(new C297222());
                            break;
                        }
                        C4990ab.m7416i("MicroMsg.Wear.WearBizLogic", "request is null or request.LocalNodeId is not same!");
                        break;
                        break;
                    case 8:
                        C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "receive auth response, deviceId=%s | isSuccess=%b", c42076vi.cSq.ceI, Boolean.valueOf(c42076vi.cSq.cxT));
                        C43842b.this.tXD = c42076vi.cSq.cxT;
                        break;
                    case 9:
                        C43842b.this.connect();
                        break;
                }
            }
            AppMethodBeat.m2505o(26274);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.b$2 */
    class C297222 extends C40186d {
        C297222() {
        }

        public final String getName() {
            return "StepCountRequest";
        }

        public final void execute() {
            AppMethodBeat.m2504i(26275);
            C43841a.cUn();
            C40185r.m68920b(20008, null, false);
            AppMethodBeat.m2505o(26275);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.b$3 */
    class C401813 implements C4937b {
        C401813() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(26276);
            if (obj == null || !(obj instanceof String)) {
                C4990ab.m7411d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
                AppMethodBeat.m2505o(26276);
                return;
            }
            String str = (String) obj;
            if (str != null && str.equals("gh_43f2581f6fd6")) {
                if (!C43842b.cUo() && C43842b.this.tXD) {
                    C43842b.this.tXD = false;
                    AppMethodBeat.m2505o(26276);
                    return;
                } else if (C43842b.cUo() && !C43842b.this.tXD) {
                    C43842b.this.connect();
                }
            }
            AppMethodBeat.m2505o(26276);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.b$a */
    class C41328a extends C40186d {
        private C41328a() {
        }

        /* synthetic */ C41328a(C43842b c43842b, byte b) {
            this();
        }

        public final void execute() {
            AppMethodBeat.m2504i(26278);
            C9638aw.m17182Rg().mo14539a(30, C43842b.this);
            LinkedList linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            C9638aw.m17182Rg().mo14541a(new C46498m(1, linkedList, linkedList2, "", ""), 0);
            AppMethodBeat.m2505o(26278);
        }

        public final String getName() {
            return "AddContactTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.b$4 */
    class C438434 implements C5015a {
        C438434() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26277);
            C43842b.m78623a(C43841a.cUn().tXt.tXK.tYz);
            AppMethodBeat.m2505o(26277);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.b$b */
    class C43844b extends C40186d {
        private ctv tXH;

        public C43844b(ctv ctv) {
            this.tXH = ctv;
        }

        public final void execute() {
            AppMethodBeat.m2504i(26279);
            C9638aw.m17182Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA, C43842b.this);
            C9638aw.m17182Rg().mo14541a(new C35553a(this.tXH.xqs, "gh_43f2581f6fd6"), 0);
            AppMethodBeat.m2505o(26279);
        }

        public final String getName() {
            return "RegisterDeviceTask";
        }
    }

    public C43842b() {
        AppMethodBeat.m2504i(26280);
        C4879a.xxA.mo10052c(this.tXE);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.mFC);
        AppMethodBeat.m2505o(26280);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26282);
        String str2;
        if (c1207m instanceof C35553a) {
            C9638aw.m17182Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA, (C1202f) this);
            if (i == 0 && i2 == 0) {
                C35553a c35553a = (C35553a) c1207m;
                String str3 = c35553a.ceI;
                str2 = c35553a.cws;
                C42076vi c42076vi = new C42076vi();
                c42076vi.cSq.cuy = 1;
                c42076vi.cSq.ceI = str3;
                c42076vi.cSq.cws = str2;
                C4879a.xxA.mo10055m(c42076vi);
                AppMethodBeat.m2505o(26282);
                return;
            }
            C4990ab.m7413e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(26282);
            return;
        }
        if (c1207m instanceof C46498m) {
            C9638aw.m17182Rg().mo14546b(30, (C1202f) this);
            if (i == 0 && i2 == 0) {
                str2 = ((C46498m) c1207m).dhl();
                C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", str2);
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO("gh_43f2581f6fd6");
                if (aoO == null || C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7412e("MicroMsg.Wear.WearBizLogic", "respUsername == " + str2 + ", contact = " + aoO);
                } else {
                    C16527d c16527d = null;
                    if (C1855t.m3911mX(aoO.field_username)) {
                        String nullAsNil = C5046bo.nullAsNil(aoO.field_username);
                        c16527d = C17903f.m28104qX(nullAsNil);
                        if (c16527d != null) {
                            c16527d.field_username = str2;
                        }
                        C41747z.aeR().delete(nullAsNil);
                        aoO.mo14709iH(nullAsNil);
                    }
                    aoO.setUsername(str2);
                    if (((int) aoO.ewQ) == 0) {
                        C9638aw.m17190ZK();
                        C18628c.m29078XM().mo15708aa(aoO);
                    }
                    if (((int) aoO.ewQ) <= 0) {
                        C4990ab.m7412e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
                    } else {
                        C1855t.m3960q(aoO);
                        C9638aw.m17190ZK();
                        C7616ad aoO2 = C18628c.m29078XM().aoO(aoO.field_username);
                        if (c16527d != null) {
                            C41747z.aeR().mo43724d(c16527d);
                        } else {
                            c16527d = C17903f.m28104qX(aoO2.field_username);
                            if (c16527d == null || c16527d.adJ()) {
                                C4990ab.m7410d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
                                C26417a.flu.mo20967ai(aoO2.field_username, "");
                                C41730b.m73506pY(aoO2.field_username);
                            } else if (aoO2.dsi()) {
                                C4990ab.m7411d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", Integer.valueOf(aoO2.duj));
                                C26417a.flu.mo20967ai(aoO2.field_username, "");
                                C41730b.m73506pY(aoO2.field_username);
                            }
                        }
                    }
                }
                C41747z.aeR().mo43726e(C41747z.aeR().mo43729qP(aoO.field_username));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(327825, Boolean.TRUE);
                connect();
            } else {
                C4990ab.m7413e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !C5046bo.isNullOrNil(str)) {
                    Toast.makeText(C4996ah.getContext(), str, 1).show();
                    AppMethodBeat.m2505o(26282);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(26282);
    }

    static boolean adq(String str) {
        AppMethodBeat.m2504i(26283);
        C42076vi c42076vi = new C42076vi();
        c42076vi.cSq.cuy = 3;
        c42076vi.cSq.ceI = str;
        c42076vi.cSq.cws = "gh_43f2581f6fd6";
        C4879a.xxA.mo10055m(c42076vi);
        C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", Boolean.valueOf(c42076vi.cSq.cxT));
        boolean z = c42076vi.cSq.cxT;
        AppMethodBeat.m2505o(26283);
        return z;
    }

    static boolean cUo() {
        AppMethodBeat.m2504i(26284);
        C9638aw.m17190ZK();
        boolean jh = C7486a.m12942jh(C18628c.m29078XM().aoO("gh_43f2581f6fd6").field_type);
        AppMethodBeat.m2505o(26284);
        return jh;
    }

    /* renamed from: a */
    public static void m78623a(ctv ctv) {
        AppMethodBeat.m2504i(26285);
        if (ctv != null) {
            C42076vi c42076vi = new C42076vi();
            c42076vi.cSq.cuy = 6;
            c42076vi.cSq.ceI = ctv.xqs;
            C4879a.xxA.mo10055m(c42076vi);
            AppMethodBeat.m2505o(26285);
            return;
        }
        C4990ab.m7416i("MicroMsg.Wear.WearBizLogic", "request is null");
        AppMethodBeat.m2505o(26285);
    }

    public final void connect() {
        AppMethodBeat.m2504i(26281);
        ctv ctv = C43841a.cUn().tXt.tXK.tYz;
        if (ctv == null) {
            C4990ab.m7412e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
            AppMethodBeat.m2505o(26281);
        } else if (!C43842b.cUo()) {
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", Boolean.valueOf(((Boolean) C18628c.m29072Ry().get(327825, Boolean.FALSE)).booleanValue()));
            if (!((Boolean) C18628c.m29072Ry().get(327825, Boolean.FALSE)).booleanValue()) {
                if (C5046bo.m7558gT(C4996ah.getContext())) {
                    C4990ab.m7416i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
                    AppMethodBeat.m2505o(26281);
                    return;
                }
                C43841a.cUn().tXz.mo69532a(new C41328a(this, (byte) 0));
                C43841a.cUn().tXz.mo69532a(new C43844b(ctv));
            }
            AppMethodBeat.m2505o(26281);
        } else if (!C43842b.adq(ctv.xqs)) {
            C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "start to register device %s", ctv.xqs);
            C43841a.cUn().tXz.mo69532a(new C43844b(ctv));
            AppMethodBeat.m2505o(26281);
        } else if (this.tXD) {
            if (this.tXF.doT()) {
                C4990ab.m7416i("MicroMsg.Wear.WearBizLogic", "start step count timer");
                this.tXF.mo16770ae(3600000, 3600000);
            } else {
                C4990ab.m7416i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
                this.tXF.stopTimer();
                this.tXF.mo16770ae(3600000, 3600000);
            }
            C43842b.m78623a(ctv);
            AppMethodBeat.m2505o(26281);
        } else {
            C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", ctv.xqs);
            String str = ctv.xqs;
            String str2 = "gh_43f2581f6fd6";
            if (!this.tXD && C43842b.adq(str)) {
                C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", str, str2);
                C42076vi c42076vi = new C42076vi();
                c42076vi.cSq.cuy = 7;
                c42076vi.cSq.ceI = str;
                c42076vi.cSq.cws = str2;
                C4879a.xxA.mo10055m(c42076vi);
            }
            AppMethodBeat.m2505o(26281);
        }
    }
}
