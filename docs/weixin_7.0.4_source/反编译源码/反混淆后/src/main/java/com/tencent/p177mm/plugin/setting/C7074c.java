package com.tencent.p177mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.p057v4.app.C17432y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5503j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.bko;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.setting.c */
public final class C7074c implements C1816at {
    private C4937b qju = new C70751();
    private C1837a qjv = new C70772();
    private C3473o qjw = new C70793();
    private C1837a qjx = new C70784();
    private C3473o qjy = new C70805();

    /* renamed from: com.tencent.mm.plugin.setting.c$1 */
    class C70751 implements C4937b {
        C70751() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(126825);
            if (i == 2) {
                final String str = (String) obj;
                C7616ad aoI = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoI(str);
                if (!(aoI == null || C7486a.m12942jh(aoI.field_type) || !aoI.mo16694NY() || aoI.mo16695NZ())) {
                    C1720g.m3539RS().mo10310m(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(126824);
                            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                            if (!(aoO == null || C7486a.m12942jh(aoO.field_type) || !aoO.mo16694NY() || aoO.mo16695NZ())) {
                                C7620bi c7620bi = new C7620bi();
                                c7620bi.mo14781hO(0);
                                c7620bi.mo14794ju(str);
                                c7620bi.setStatus(6);
                                c7620bi.setContent(C4996ah.getContext().getString(C25738R.string.e7o));
                                c7620bi.mo14775eJ(C1829bf.m3764q(str, System.currentTimeMillis() / 1000));
                                c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
                                C4990ab.m7417i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", str);
                            }
                            AppMethodBeat.m2505o(126824);
                        }
                    }, 5000);
                }
            }
            AppMethodBeat.m2505o(126825);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.c$2 */
    class C70772 implements C1837a {
        C70772() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(126826);
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
                AppMethodBeat.m2505o(126826);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z == null) {
                AppMethodBeat.m2505o(126826);
                return;
            }
            String bc = C5046bo.m7532bc((String) z.get(".sysmsg.RedPoints.redPoint.path"), "");
            int ank = C5046bo.ank(C5046bo.m7532bc((String) z.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
            C5046bo.ank(C5046bo.m7532bc((String) z.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
            if (C5046bo.isNullOrNil(bc)) {
                AppMethodBeat.m2505o(126826);
            } else if (!bc.equals("my_setting_privaty_recentOption")) {
                if (bc.equals("my_setting_plugin_switch")) {
                    String bc2 = C5046bo.m7532bc((String) z.get(".sysmsg.RedPoints.redPoint.ext"), "");
                    if (C5046bo.isNullOrNil(bc2)) {
                        AppMethodBeat.m2505o(126826);
                        return;
                    } else if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(0))).intValue() >= ank) {
                        AppMethodBeat.m2505o(126826);
                        return;
                    } else {
                        Object concat;
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(ank));
                        a = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, (Object) "");
                        if (C5046bo.isNullOrNil(a)) {
                            a = bc2;
                        } else {
                            concat = bc2.concat(",").concat(a);
                        }
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, concat);
                        C16112c.m24429PK().mo28557y(262158, true);
                    }
                }
                AppMethodBeat.m2505o(126826);
            } else if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(0))).intValue() >= ank) {
                AppMethodBeat.m2505o(126826);
            } else {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(ank));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(ank));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(ank));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(ank));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(ank));
                C16112c.m24429PK().mo28557y(266260, true);
                AppMethodBeat.m2505o(126826);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.c$4 */
    class C70784 implements C1837a {
        C70784() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(126828);
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
                AppMethodBeat.m2505o(126828);
                return;
            }
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z == null) {
                AppMethodBeat.m2505o(126828);
                return;
            }
            int i = C5046bo.getInt((String) z.get(".sysmsg.crowdtest.$clientversion"), 0);
            if (i <= C7243d.vxo) {
                AppMethodBeat.m2505o(126828);
                return;
            }
            long j = 0;
            try {
                j = new SimpleDateFormat("yyyy-MM-dd").parse((String) z.get(".sysmsg.crowdtest.apply.$expire")).getTime();
            } catch (Exception e) {
            }
            if (j < System.currentTimeMillis()) {
                C7074c.ciq();
                AppMethodBeat.m2505o(126828);
                return;
            }
            Object obj = (String) z.get(".sysmsg.crowdtest.apply.link");
            Object obj2 = (String) z.get(".sysmsg.crowdtest.feedback.link");
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CROWDTEST_CLIENT_VERSION_INT, Integer.valueOf(i));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(j));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CROWDTEST_APPLY_LINK_STRING, obj);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, obj2);
            int i2 = C5046bo.getInt((String) z.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
            C16112c.m24429PK().mo28557y(262157, i2 > 0);
            if (i2 < 3) {
                C16112c.m24429PK().mo28553bZ(262157, 266261);
            }
            if (i2 < 2) {
                C16112c.m24429PK().mo28553bZ(262157, 266262);
            }
            AppMethodBeat.m2505o(126828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.c$3 */
    class C70793 implements C3473o {
        C70793() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(126827);
            if (map != null) {
                String str2 = (String) map.get(".sysmsg.showtrustedfriends.wording");
                if (!C5046bo.isNullOrNil(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra(C5503j.ygc, str2);
                    C25985d.m41467b(C4996ah.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", intent);
                }
            }
            AppMethodBeat.m2505o(126827);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.c$5 */
    class C70805 implements C3473o {
        C70805() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(126829);
            if (map != null) {
                String str2 = (String) map.get(".sysmsg.security");
                if (!C5046bo.isNullOrNil(str2)) {
                    try {
                        int i = C5046bo.getInt(str2, 0);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC, Integer.valueOf(i));
                        if (i != 0) {
                            C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, true);
                            AppMethodBeat.m2505o(126829);
                            return;
                        }
                        C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, false);
                        AppMethodBeat.m2505o(126829);
                        return;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreSetting", e, "device protect security value is not number!", new Object[0]);
                    }
                }
            }
            AppMethodBeat.m2505o(126829);
        }
    }

    public C7074c() {
        AppMethodBeat.m2504i(126830);
        C4990ab.m7416i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(126830);
    }

    @SuppressLint({"UseSparseArrays"})
    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
        AppMethodBeat.m2504i(126831);
        C4990ab.m7416i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(126831);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(126832);
        C4990ab.m7416i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("redpointinfo", this.qjv, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("crowdtest", this.qjx, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("showtrustedfriends", this.qjw);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("DeviceProtectRedSpot", this.qjy);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CROWDTEST_CLIENT_VERSION_INT, Integer.valueOf(C7243d.vxo))).intValue();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(0))).longValue();
        if (intValue <= C7243d.vxo || longValue < System.currentTimeMillis()) {
            C7074c.ciq();
        }
        if (z) {
            C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf((C1853r.m3829YK() & -1048577) & -4194305));
            bko bko = new bko();
            bko.vCi = 1048576;
            bko.wNJ = 0;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(39, bko));
            bko = new bko();
            bko.vCi = 4194304;
            bko.wNJ = 0;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(39, bko));
            C4990ab.m7416i("MicroMsg.SubCoreSetting", "set void default open");
            if (!C17432y.m27074L(C4996ah.getContext()).areNotificationsEnabled()) {
                C4990ab.m7420w("MicroMsg.SubCoreSetting", "sys notification disable！");
                C7060h.pYm.mo8378a(500, 18, 1, false);
            }
            C4990ab.m7417i("MicroMsg.SubCoreSetting", "is update from %s", Integer.valueOf(C1720g.m3534RN().eIR.eKf));
            Set<String> aat = C37914bx.fnB.aat();
            if (aat.size() == 2) {
                String[] strArr = new String[2];
                intValue = 0;
                for (String string : aat) {
                    int i = intValue + 1;
                    strArr[intValue] = C37914bx.fnB.getString(string, "login_user_name");
                    intValue = i;
                }
                if (!C5046bo.m7510Q(strArr[0], strArr[1]) && strArr[0].equals(strArr[1])) {
                    C4990ab.m7420w("MicroMsg.SubCoreSetting", "old dirty data!!!");
                    C37914bx.fnB.mo60669oK(strArr[0]);
                    C37914bx.fnB.mo60669oK(strArr[1]);
                }
            }
        }
        if (C26373g.m41964Nu().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1 && (C1853r.m3822YD() & 32) == 0) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this.qju);
        }
        AppMethodBeat.m2505o(126832);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(126833);
        C4990ab.m7416i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
        AppMethodBeat.m2505o(126833);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(126834);
        C4990ab.m7416i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("redpointinfo", this.qjv, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("crowdtest", this.qjx, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("showtrustedfriends", this.qjw);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("DeviceProtectRedSpot", this.qjy);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this.qju);
        AppMethodBeat.m2505o(126834);
    }

    static void ciq() {
        AppMethodBeat.m2504i(126835);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(0));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CROWDTEST_APPLY_LINK_STRING, (Object) "");
        C16112c.m24429PK().mo28557y(262157, false);
        AppMethodBeat.m2505o(126835);
    }
}
