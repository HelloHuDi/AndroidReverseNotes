package com.tencent.p177mm.app.plugin.p825a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p230g.p231a.C18247ed;
import com.tencent.p177mm.p230g.p231a.C26174jo;
import com.tencent.p177mm.p230g.p231a.C32596lq;
import com.tencent.p177mm.p230g.p231a.C41974de;
import com.tencent.p177mm.p230g.p231a.C6546sd;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.app.plugin.a.a */
public final class C25808a {
    public C46650a cgL;
    public C9006b cgM;
    public C25809a cgN;
    private String cgO;
    public Map<String, Boolean> cgP;
    public boolean cgQ = true;

    /* renamed from: com.tencent.mm.app.plugin.a.a$b */
    class C9006b extends C4884c<C32596lq> {
        C9006b() {
            AppMethodBeat.m2504i(15725);
            this.xxI = C32596lq.class.getName().hashCode();
            AppMethodBeat.m2505o(15725);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15726);
            C32596lq c32596lq = (C32596lq) c4883b;
            if (C25808a.this.cgL != null) {
                if (!C25808a.this.cgL.yTx.isFinishing()) {
                    int i = c32596lq.cHu.f15019op;
                    String str = c32596lq.cHu.cEN;
                    C4990ab.m7417i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "opcode is %d, brand name is %s", Integer.valueOf(i), str);
                    if (C25808a.this.cgL.getTalkerUserName().equals(str)) {
                        switch (i) {
                            case 1:
                                C25808a c25808a = C25808a.this;
                                C4990ab.m7417i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "handleConnectFailedReason, reason : %d, brand name : %s", Integer.valueOf(c32596lq.cHu.boZ), str);
                                C16527d qX = C17903f.m28104qX(str);
                                if (C25808a.m41064a(qX)) {
                                    if (qX.mo30481cJ(false).aej().fvI == 1) {
                                        c25808a.cgL.yTx.setMMSubTitle(null);
                                        break;
                                    }
                                }
                                C4990ab.m7421w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
                                break;
                                break;
                            case 2:
                                C25808a.this.mo43759d(c32596lq.cHu.cxs, str, c32596lq.cHu.ceI);
                                break;
                            case 3:
                                if (C25808a.this.cgP != null) {
                                    C25808a.this.cgP.clear();
                                    C4990ab.m7416i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "clear connected device ids successfully.");
                                    break;
                                }
                                break;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "not current brandname");
                } else {
                    C4990ab.m7412e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context isFinishing");
                }
            } else {
                C4990ab.m7412e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context == null");
            }
            AppMethodBeat.m2505o(15726);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.a.a$a */
    class C25809a extends C4884c<C41974de> {
        C25809a() {
            AppMethodBeat.m2504i(15724);
            this.xxI = C41974de.class.getName().hashCode();
            AppMethodBeat.m2505o(15724);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            ((C41974de) c4883b).cwp.cgQ = C25808a.this.cgQ;
            return true;
        }
    }

    public C25808a(C46650a c46650a) {
        AppMethodBeat.m2504i(15727);
        C4990ab.m7410d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
        this.cgL = c46650a;
        if (this.cgM == null) {
            this.cgM = new C9006b();
        }
        C4879a.xxA.mo10052c(this.cgM);
        if (this.cgN == null) {
            this.cgN = new C25809a();
        }
        C4879a.xxA.mo10052c(this.cgN);
        AppMethodBeat.m2505o(15727);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public final synchronized void mo43759d(int i, String str, String str2) {
        AppMethodBeat.m2504i(15728);
        C4990ab.m7417i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", Integer.valueOf(i));
        if (this.cgL == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
            AppMethodBeat.m2505o(15728);
        } else {
            C16527d qX = C17903f.m28104qX(str);
            if (C25808a.m41064a(qX)) {
                if (this.cgP == null) {
                    this.cgP = new HashMap();
                }
                Map map = this.cgP;
                if (!str.equals(this.cgO)) {
                    this.cgO = str;
                    map.clear();
                }
                if (qX.mo30481cJ(false).aej().fvI == 1) {
                    this.cgL.yTx.setMMSubTitle(null);
                    AppMethodBeat.m2505o(15728);
                } else {
                    C4990ab.m7411d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", map, str2);
                    switch (i) {
                        case -1:
                            this.cgL.yTx.setMMSubTitle(null);
                            AppMethodBeat.m2505o(15728);
                            break;
                        case 0:
                            if (map.size() == 0) {
                                this.cgL.yTx.setMMSubTitle((int) C25738R.string.bg_);
                                AppMethodBeat.m2505o(15728);
                                break;
                            }
                        case 1:
                            if (map.size() == 0) {
                                this.cgL.yTx.setMMSubTitle((int) C25738R.string.bg9);
                            }
                            AppMethodBeat.m2505o(15728);
                            break;
                        case 2:
                            map.put(str2, Boolean.TRUE);
                            this.cgL.yTx.setMMSubTitle(this.cgL.yTx.getString(C25738R.string.bg8, Integer.valueOf(map.size())));
                            C4990ab.m7417i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", str2);
                            AppMethodBeat.m2505o(15728);
                            break;
                        case 4:
                            if (map.remove(str2) != null) {
                                C4990ab.m7417i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", str2);
                            }
                            this.cgL.yTx.setMMSubTitle(this.cgL.yTx.getString(C25738R.string.bg8, Integer.valueOf(map.size())));
                            AppMethodBeat.m2505o(15728);
                            break;
                    }
                    AppMethodBeat.m2505o(15728);
                }
            } else {
                C4990ab.m7421w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
                AppMethodBeat.m2505o(15728);
            }
        }
    }

    /* renamed from: a */
    public final void mo43758a(final int i, C16527d c16527d) {
        AppMethodBeat.m2504i(15729);
        if (this.cgL == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
            AppMethodBeat.m2505o(15729);
            return;
        }
        if (C1855t.m3913mZ(this.cgL.getTalkerUserName()) && C25808a.m41064a(c16527d)) {
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(15723);
                    if (1 == i) {
                        C18247ed c18247ed = new C18247ed();
                        c18247ed.cxE.f4320op = 0;
                        c18247ed.cxE.userName = C25808a.this.cgL.getTalkerUserName();
                        c18247ed.cxE.context = C25808a.this.cgL.yTx.getContext();
                        C4879a.xxA.mo10055m(c18247ed);
                        if (C25808a.this.cgL.getTalkerUserName().equals("gh_43f2581f6fd6")) {
                            C4883b c6546sd = new C6546sd();
                            c6546sd.cOe.action = 1;
                            C4879a.xxA.mo10049a(c6546sd, C7305d.xDG.cin());
                        }
                    }
                    C26174jo c26174jo = new C26174jo();
                    c26174jo.cEM.opType = i;
                    c26174jo.cEM.cEO = 1;
                    c26174jo.cEM.cEN = C25808a.this.cgL.getTalkerUserName();
                    C4879a.xxA.mo10055m(c26174jo);
                    AppMethodBeat.m2505o(15723);
                }
            });
        }
        AppMethodBeat.m2505o(15729);
    }

    /* renamed from: a */
    public static boolean m41064a(C16527d c16527d) {
        AppMethodBeat.m2504i(15730);
        if (c16527d == null) {
            AppMethodBeat.m2505o(15730);
            return false;
        }
        if (c16527d != null) {
            C16529b cJ = c16527d.mo30481cJ(false);
            if (!(cJ == null || cJ.aej() == null || !cJ.aej().aes())) {
                AppMethodBeat.m2505o(15730);
                return true;
            }
        }
        AppMethodBeat.m2505o(15730);
        return false;
    }
}
