package com.tencent.p177mm.plugin.ipcall.p438a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18229ba;
import com.tencent.p177mm.p230g.p231a.C18299iq;
import com.tencent.p177mm.p230g.p231a.C32574ir;
import com.tencent.p177mm.p230g.p231a.C45365sg;
import com.tencent.p177mm.p230g.p231a.C6552to;
import com.tencent.p177mm.p230g.p231a.C9298bc;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.ipcall.C28336c;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43218a.C28323a;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C34367b;
import com.tencent.p177mm.plugin.ipcall.p438a.p440c.C12250b;
import com.tencent.p177mm.plugin.ipcall.p438a.p440c.C3304a;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34373g;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C12254j;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21084d;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C28333l;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C39262h;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C43224a;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C46038g;
import com.tencent.p177mm.plugin.ipcall.p442ui.IPCallDialUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.video.C22470i;
import com.tencent.p177mm.plugin.voip.video.C43738d;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.ipcall.a.i */
public final class C21088i implements C1816at {
    private static C21088i nvT = null;
    private static HashMap<Integer, C1366d> nwm;
    private C39263g nvU = new C39263g();
    private C3304a nvV = new C3304a();
    private C12250b nvW = new C12250b();
    private C34367b nvX = new C34367b();
    private C46037f nvY = new C46037f();
    private C28336c nvZ = new C28336c();
    private C21084d nwa;
    private C28333l nwb;
    private C12254j nwc;
    private C39262h nwd;
    private C22470i nwe;
    private C43738d nwf;
    private Context nwg;
    private long nwh;
    private C4884c nwi = new C210901();
    private C4884c nwj = new C210924();
    private C4884c nwk = new C210935();
    private C4884c nwl = new C210946();
    private C1837a nwn = new C2109511();
    private C1837a nwo = new C210862();
    private C1837a nwp = new C210913();

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$10 */
    static class C695310 implements C1366d {
        C695310() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39262h.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$7 */
    static class C122577 implements C1366d {
        C122577() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C21084d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$2 */
    class C210862 implements C1837a {
        C210862() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(21765);
            C4990ab.m7416i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
            C7254cm c7254cm = c1197a.eAB;
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
                AppMethodBeat.m2505o(21765);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
                AppMethodBeat.m2505o(21765);
                return;
            }
            int i;
            C39262h bHz = C21088i.bHz();
            long j = (long) c7254cm.ptD;
            if (z != null) {
                C46038g c46038g = new C46038g();
                c46038g.field_svrId = j;
                c46038g.field_title = (String) z.get(".sysmsg.WeChatOutMsg.Title");
                if (c46038g.field_title == null) {
                    c46038g.field_title = "";
                }
                c46038g.field_content = (String) z.get(".sysmsg.WeChatOutMsg.Content");
                if (c46038g.field_content == null) {
                    c46038g.field_content = "";
                }
                int i2 = C5046bo.getInt((String) z.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
                c46038g.field_msgType = i2;
                c46038g.field_pushTime = C5046bo.getLong((String) z.get(".sysmsg.WeChatOutMsg.PushTime"), 0);
                c46038g.field_descUrl = (String) z.get(".sysmsg.WeChatOutMsg.DescUrl");
                if (c46038g.field_descUrl == null) {
                    c46038g.field_descUrl = "";
                }
                C4990ab.m7417i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", c46038g.field_svrId, c46038g.field_title, c46038g.field_content, c46038g.field_msgType, c46038g.field_pushTime, c46038g.field_descUrl);
                bHz.mo10101b((C4925c) c46038g);
                i = i2;
            } else {
                i = -1;
            }
            if (i != -1) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(i));
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
            C7060h.pYm.mo8381e(13254, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1));
            AppMethodBeat.m2505o(21765);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$9 */
    static class C210879 implements C1366d {
        C210879() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C12254j.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$8 */
    static class C210898 implements C1366d {
        C210898() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C28333l.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$1 */
    class C210901 extends C4884c<C9298bc> {
        C210901() {
            AppMethodBeat.m2504i(21763);
            this.xxI = C9298bc.class.getName().hashCode();
            AppMethodBeat.m2505o(21763);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(21764);
            C4990ab.m7410d("MicroMsg.SubCoreIPCall", "change language");
            C46041a.bIO();
            AppMethodBeat.m2505o(21764);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$3 */
    class C210913 implements C1837a {
        C210913() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(21766);
            C4990ab.m7416i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
                AppMethodBeat.m2505o(21766);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
                AppMethodBeat.m2505o(21766);
                return;
            }
            if (z.containsKey(".sysmsg.WCONotify.NotifyGetBalance")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.WCONotify.NotifyGetBalance"), 0)));
                if (C5046bo.getInt((String) z.get(".sysmsg.WCONotify.NotifyGetBalance"), 0) > 0) {
                    C9638aw.m17182Rg().mo14541a(new C34373g(2), 0);
                }
            }
            AppMethodBeat.m2505o(21766);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$4 */
    class C210924 extends C4884c<C18229ba> {
        C210924() {
            AppMethodBeat.m2504i(21767);
            this.xxI = C18229ba.class.getName().hashCode();
            AppMethodBeat.m2505o(21767);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(21768);
            C18229ba c18229ba = (C18229ba) c4883b;
            if (c18229ba instanceof C18229ba) {
                c18229ba.cuj.aFV = C21088i.bHu().bHk();
            }
            AppMethodBeat.m2505o(21768);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$5 */
    class C210935 extends C4884c<C45365sg> {
        C210935() {
            AppMethodBeat.m2504i(21769);
            this.xxI = C45365sg.class.getName().hashCode();
            AppMethodBeat.m2505o(21769);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(21770);
            C45365sg c45365sg = (C45365sg) c4883b;
            if (c45365sg instanceof C45365sg) {
                Intent intent = new Intent(C4996ah.getContext(), IPCallDialUI.class);
                intent.setFlags(268435456);
                intent.putExtra("IPCallTalkUI_contactId", c45365sg.cOy.cOz);
                intent.putExtra("IPCallTalkUI_countryCode", c45365sg.cOy.cOA);
                intent.putExtra("IPCallTalkUI_nickname", c45365sg.cOy.bCu);
                intent.putExtra("IPCallTalkUI_phoneNumber", c45365sg.cOy.cMQ);
                C4996ah.getContext().startActivity(intent);
            }
            AppMethodBeat.m2505o(21770);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$6 */
    class C210946 extends C4884c<C18299iq> {
        C210946() {
            AppMethodBeat.m2504i(21771);
            this.xxI = C18299iq.class.getName().hashCode();
            AppMethodBeat.m2505o(21771);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(21772);
            C18299iq c18299iq = (C18299iq) c4883b;
            if (c18299iq instanceof C18299iq) {
                if (c18299iq.cDO.cDR && C21088i.this.nwh == c18299iq.cDO.cDQ && C21088i.this.nwg != null) {
                    C21088i.this.nwg = null;
                    C21088i.this.nwh = 0;
                }
                if (!c18299iq.cDO.cDR) {
                    if (c18299iq.cDO.cDQ == 0) {
                        C21088i.this.nwg = null;
                        C21088i.this.nwh = 0;
                    } else {
                        C21088i.this.nwg = c18299iq.cDO.cDP;
                        C21088i.this.nwh = c18299iq.cDO.cDQ;
                    }
                }
            }
            AppMethodBeat.m2505o(21772);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.i$11 */
    class C2109511 implements C1837a {
        C2109511() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(21773);
            C4990ab.m7416i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
                AppMethodBeat.m2505o(21773);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
                AppMethodBeat.m2505o(21773);
                return;
            }
            int i;
            int i2;
            Object substring;
            if (z.containsKey(".sysmsg.WeChatOut.AccountRedDotType")) {
                i = C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(i));
                i2 = i;
            } else {
                i2 = -1;
            }
            if (z.containsKey(".sysmsg.WeChatOut.AcctRD")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.AcctRD"), 0)));
                if (C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.AcctRD"), 0) != 0) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
                    C7060h.pYm.mo8381e(13254, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                }
            }
            if (z.containsKey(".sysmsg.WeChatOut.TabRD")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.TabRD"), 0)));
                if (C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.TabRD"), 0) != 0) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.TRUE);
                    C7060h.pYm.mo8381e(13254, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE);
                }
            }
            if (z.containsKey(".sysmsg.WeChatOut.RechargeRD")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.RechargeRD"), 0)));
                if (C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.RechargeRD"), 0) != 0) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
                    C7060h.pYm.mo8381e(13254, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                }
            }
            if (z.containsKey(".sysmsg.WeChatOut.RechargeWording")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", (String) z.get(".sysmsg.WeChatOut.RechargeWording"));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_RECHARGE_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.PackagePurchaseWording")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", (String) z.get(".sysmsg.WeChatOut.PackagePurchaseWording"));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.AccountWording")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", (String) z.get(".sysmsg.WeChatOut.AccountWording"));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.RechargeWordingVersion")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0)));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT, Integer.valueOf(i));
            }
            if (z.containsKey(".sysmsg.WeChatOut.TabWording")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", (String) z.get(".sysmsg.WeChatOut.TabWording"));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWording")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", (String) z.get(".sysmsg.WeChatOut.AccountActivityWording"));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0)));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, Integer.valueOf(i));
            }
            if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0)));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT, Integer.valueOf(i));
            }
            if (z.containsKey(".sysmsg.WeChatOut.TabRedDotType")) {
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", Integer.valueOf(C5046bo.getInt((String) z.get(".sysmsg.WeChatOut.TabRedDotType"), 0)));
                C7060h.pYm.mo8381e(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_TYPE_INT, Integer.valueOf(i));
            }
            i = a.indexOf("<ActivityInfo>");
            i2 = a.indexOf("</ActivityInfo>");
            if (i > 0 && i2 > 0 && i2 > i) {
                substring = a.substring(i, i2 + 15);
                C4990ab.m7417i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", substring);
                C43224a OO = C43224a.m76873OO(substring);
                if (OO != null && C5046bo.isNullOrNil(OO.Title) && C5046bo.isNullOrNil(OO.Desc)) {
                    C4990ab.m7416i("MicroMsg.SubCoreIPCall", "clear activity");
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_ACTIVITY_STRING, (Object) "");
                } else if (OO != null) {
                    if (!C5046bo.isNullOrNil(OO.ImgUrl)) {
                        C32291o.ahk().mo33458a(OO.ImgUrl, null);
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.TRUE);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_ACTIVITY_STRING, substring);
                }
            }
            C4879a.xxA.mo10055m(new C32574ir());
            C4879a.xxA.mo10055m(new C6552to());
            AppMethodBeat.m2505o(21773);
        }
    }

    static {
        AppMethodBeat.m2504i(21790);
        HashMap hashMap = new HashMap();
        nwm = hashMap;
        hashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new C122577());
        nwm.put(Integer.valueOf("IPCallRecord".hashCode()), new C210898());
        nwm.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new C210879());
        nwm.put(Integer.valueOf("IPCallMsg".hashCode()), new C695310());
        AppMethodBeat.m2505o(21790);
    }

    public C21088i() {
        AppMethodBeat.m2504i(21774);
        AppMethodBeat.m2505o(21774);
    }

    public static C21088i bHp() {
        AppMethodBeat.m2504i(21775);
        if (nvT == null) {
            nvT = new C21088i();
            C9638aw.m17184ZE().mo73244a("plugin.ipcall", nvT);
        }
        C21088i c21088i = nvT;
        AppMethodBeat.m2505o(21775);
        return c21088i;
    }

    public static C39263g bHq() {
        AppMethodBeat.m2504i(21776);
        C39263g c39263g = C21088i.bHp().nvU;
        AppMethodBeat.m2505o(21776);
        return c39263g;
    }

    public static C3304a bHr() {
        AppMethodBeat.m2504i(21777);
        C3304a c3304a = C21088i.bHp().nvV;
        AppMethodBeat.m2505o(21777);
        return c3304a;
    }

    public static C12250b bHs() {
        AppMethodBeat.m2504i(21778);
        C12250b c12250b = C21088i.bHp().nvW;
        AppMethodBeat.m2505o(21778);
        return c12250b;
    }

    public static C34367b bHt() {
        AppMethodBeat.m2504i(21779);
        C34367b c34367b = C21088i.bHp().nvX;
        AppMethodBeat.m2505o(21779);
        return c34367b;
    }

    public static C46037f bHu() {
        AppMethodBeat.m2504i(21780);
        C46037f c46037f = C21088i.bHp().nvY;
        AppMethodBeat.m2505o(21780);
        return c46037f;
    }

    public static C28336c bHv() {
        AppMethodBeat.m2504i(21781);
        C28336c c28336c = C21088i.bHp().nvZ;
        AppMethodBeat.m2505o(21781);
        return c28336c;
    }

    public static C21084d bHw() {
        AppMethodBeat.m2504i(21782);
        C1720g.m3534RN().mo5159QU();
        if (C21088i.bHp().nwa == null) {
            C21088i bHp = C21088i.bHp();
            C9638aw.m17190ZK();
            bHp.nwa = new C21084d(C18628c.m29069Ru());
        }
        C21084d c21084d = C21088i.bHp().nwa;
        AppMethodBeat.m2505o(21782);
        return c21084d;
    }

    public static C28333l bHx() {
        AppMethodBeat.m2504i(21783);
        C1720g.m3534RN().mo5159QU();
        if (C21088i.bHp().nwb == null) {
            C21088i bHp = C21088i.bHp();
            C9638aw.m17190ZK();
            bHp.nwb = new C28333l(C18628c.m29069Ru());
        }
        C28333l c28333l = C21088i.bHp().nwb;
        AppMethodBeat.m2505o(21783);
        return c28333l;
    }

    public static C12254j bHy() {
        AppMethodBeat.m2504i(21784);
        C1720g.m3534RN().mo5159QU();
        if (C21088i.bHp().nwc == null) {
            C21088i bHp = C21088i.bHp();
            C9638aw.m17190ZK();
            bHp.nwc = new C12254j(C18628c.m29069Ru());
        }
        C12254j c12254j = C21088i.bHp().nwc;
        AppMethodBeat.m2505o(21784);
        return c12254j;
    }

    public static C39262h bHz() {
        AppMethodBeat.m2504i(21785);
        C1720g.m3534RN().mo5159QU();
        if (C21088i.bHp().nwd == null) {
            C21088i bHp = C21088i.bHp();
            C9638aw.m17190ZK();
            bHp.nwd = new C39262h(C18628c.m29069Ru());
        }
        C39262h c39262h = C21088i.bHp().nwd;
        AppMethodBeat.m2505o(21785);
        return c39262h;
    }

    public static C22470i bHA() {
        AppMethodBeat.m2504i(21786);
        if (C21088i.bHp().nwe == null) {
            C21088i.bHp().nwe = new C22470i(C4996ah.getContext());
        }
        C22470i c22470i = C21088i.bHp().nwe;
        AppMethodBeat.m2505o(21786);
        return c22470i;
    }

    public static C43738d bHB() {
        AppMethodBeat.m2504i(21787);
        if (C21088i.bHp().nwf == null) {
            C21088i.bHp().nwf = new C43738d(C4996ah.getContext());
        }
        C43738d c43738d = C21088i.bHp().nwf;
        AppMethodBeat.m2505o(21787);
        return c43738d;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return nwm;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(21788);
        C39263g c39263g = this.nvU;
        c39263g.nvF.init();
        c39263g.nvG.init();
        c39263g.nvH.init();
        c39263g.nvI.init();
        c39263g.nvJ.init();
        c39263g.nvK.init();
        c39263g.nvL.init();
        c39263g.nvM.init();
        c39263g.nvF.mo68721a((C28323a) c39263g);
        c39263g.nvH.mo68721a((C28323a) c39263g);
        c39263g.nvI.mo68721a((C28323a) c39263g);
        c39263g.nvK.mo68721a((C28323a) c39263g);
        c39263g.nvM.mo68721a((C28323a) c39263g);
        c39263g.nvG.nws = c39263g;
        c39263g.nvJ.nws = c39263g;
        C9638aw.m17198a(c39263g.nvQ);
        C12247b.init();
        C4879a.xxA.mo10052c(C43220d.bHg().nvt);
        C4879a.xxA.mo10052c(C43221e.bHj().gyU);
        C9638aw.getSysCmdMsgExtension().mo14900a("WeChatOut", this.nwn, true);
        C9638aw.getSysCmdMsgExtension().mo14900a("WeChatOutMsg", this.nwo, true);
        C9638aw.getSysCmdMsgExtension().mo14900a("WCONotify", this.nwp, true);
        C4879a.xxA.mo10052c(this.nwi);
        C4879a.xxA.mo10052c(this.nwj);
        C4879a.xxA.mo10052c(this.nwk);
        C4879a.xxA.mo10052c(this.nwl);
        AppMethodBeat.m2505o(21788);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(21789);
        if (this.nvY.bHk()) {
            this.nvZ.mo46266eo(0, 0);
        }
        C39263g c39263g = this.nvU;
        c39263g.nvF.destroy();
        c39263g.nvG.destroy();
        c39263g.nvH.destroy();
        c39263g.nvI.destroy();
        c39263g.nvJ.destroy();
        c39263g.nvL.destroy();
        C9638aw.m17200b(c39263g.nvQ);
        C12247b.release();
        C1202f bHg = C43220d.bHg();
        C9638aw.m17182Rg().mo14546b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, bHg);
        C9638aw.m17182Rg().mo14546b(160, bHg);
        C4879a.xxA.mo10053d(bHg.nvt);
        C4879a.xxA.mo10053d(C43221e.bHj().gyU);
        C9638aw.getSysCmdMsgExtension().mo14903b("WeChatOut", this.nwn, true);
        C9638aw.getSysCmdMsgExtension().mo14903b("WeChatOutMsg", this.nwo, true);
        C9638aw.getSysCmdMsgExtension().mo14903b("WCONotify", this.nwp, true);
        C4879a.xxA.mo10053d(this.nwi);
        C4879a.xxA.mo10053d(this.nwj);
        C4879a.xxA.mo10053d(this.nwk);
        C4879a.xxA.mo10053d(this.nwl);
        AppMethodBeat.m2505o(21789);
    }
}
