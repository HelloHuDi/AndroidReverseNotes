package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e;
import com.tencent.mm.bp.d;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class c implements at {
    private b qju = new b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(126825);
            if (i == 2) {
                final String str = (String) obj;
                ad aoI = ((j) g.K(j.class)).XM().aoI(str);
                if (!(aoI == null || a.jh(aoI.field_type) || !aoI.NY() || aoI.NZ())) {
                    g.RS().m(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(126824);
                            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                            if (!(aoO == null || a.jh(aoO.field_type) || !aoO.NY() || aoO.NZ())) {
                                bi biVar = new bi();
                                biVar.hO(0);
                                biVar.ju(str);
                                biVar.setStatus(6);
                                biVar.setContent(ah.getContext().getString(R.string.e7o));
                                biVar.eJ(bf.q(str, System.currentTimeMillis() / 1000));
                                biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                                ((j) g.K(j.class)).bOr().Z(biVar);
                                ab.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", str);
                            }
                            AppMethodBeat.o(126824);
                        }
                    }, 5000);
                }
            }
            AppMethodBeat.o(126825);
        }
    };
    private bz.a qjv = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(126826);
            String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
                AppMethodBeat.o(126826);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z == null) {
                AppMethodBeat.o(126826);
                return;
            }
            String bc = bo.bc((String) z.get(".sysmsg.RedPoints.redPoint.path"), "");
            int ank = bo.ank(bo.bc((String) z.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
            bo.ank(bo.bc((String) z.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
            if (bo.isNullOrNil(bc)) {
                AppMethodBeat.o(126826);
            } else if (!bc.equals("my_setting_privaty_recentOption")) {
                if (bc.equals("my_setting_plugin_switch")) {
                    String bc2 = bo.bc((String) z.get(".sysmsg.RedPoints.redPoint.ext"), "");
                    if (bo.isNullOrNil(bc2)) {
                        AppMethodBeat.o(126826);
                        return;
                    } else if (((Integer) g.RP().Ry().get(ac.a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(0))).intValue() >= ank) {
                        AppMethodBeat.o(126826);
                        return;
                    } else {
                        Object concat;
                        g.RP().Ry().set(ac.a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(ank));
                        a = (String) g.RP().Ry().get(ac.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, (Object) "");
                        if (bo.isNullOrNil(a)) {
                            a = bc2;
                        } else {
                            concat = bc2.concat(",").concat(a);
                        }
                        g.RP().Ry().set(ac.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, concat);
                        com.tencent.mm.x.c.PK().y(262158, true);
                    }
                }
                AppMethodBeat.o(126826);
            } else if (((Integer) g.RP().Ry().get(ac.a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(0))).intValue() >= ank) {
                AppMethodBeat.o(126826);
            } else {
                g.RP().Ry().set(ac.a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(ank));
                g.RP().Ry().set(ac.a.USERINFO_MY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(ank));
                g.RP().Ry().set(ac.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(ank));
                g.RP().Ry().set(ac.a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(ank));
                g.RP().Ry().set(ac.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(ank));
                com.tencent.mm.x.c.PK().y(266260, true);
                AppMethodBeat.o(126826);
            }
        }
    };
    private o qjw = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, e.a aVar) {
            AppMethodBeat.i(126827);
            if (map != null) {
                String str2 = (String) map.get(".sysmsg.showtrustedfriends.wording");
                if (!bo.isNullOrNil(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra(com.tencent.mm.ui.e.j.ygc, str2);
                    d.b(ah.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", intent);
                }
            }
            AppMethodBeat.o(126827);
        }
    };
    private bz.a qjx = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(126828);
            String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
                AppMethodBeat.o(126828);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z == null) {
                AppMethodBeat.o(126828);
                return;
            }
            int i = bo.getInt((String) z.get(".sysmsg.crowdtest.$clientversion"), 0);
            if (i <= com.tencent.mm.protocal.d.vxo) {
                AppMethodBeat.o(126828);
                return;
            }
            long j = 0;
            try {
                j = new SimpleDateFormat("yyyy-MM-dd").parse((String) z.get(".sysmsg.crowdtest.apply.$expire")).getTime();
            } catch (Exception e) {
            }
            if (j < System.currentTimeMillis()) {
                c.ciq();
                AppMethodBeat.o(126828);
                return;
            }
            Object obj = (String) z.get(".sysmsg.crowdtest.apply.link");
            Object obj2 = (String) z.get(".sysmsg.crowdtest.feedback.link");
            g.RP().Ry().set(ac.a.USERINFO_CROWDTEST_CLIENT_VERSION_INT, Integer.valueOf(i));
            g.RP().Ry().set(ac.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(j));
            g.RP().Ry().set(ac.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, obj);
            g.RP().Ry().set(ac.a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, obj2);
            int i2 = bo.getInt((String) z.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
            com.tencent.mm.x.c.PK().y(262157, i2 > 0);
            if (i2 < 3) {
                com.tencent.mm.x.c.PK().bZ(262157, 266261);
            }
            if (i2 < 2) {
                com.tencent.mm.x.c.PK().bZ(262157, 266262);
            }
            AppMethodBeat.o(126828);
        }
    };
    private o qjy = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, e.a aVar) {
            AppMethodBeat.i(126829);
            if (map != null) {
                String str2 = (String) map.get(".sysmsg.security");
                if (!bo.isNullOrNil(str2)) {
                    try {
                        int i = bo.getInt(str2, 0);
                        g.RP().Ry().set(ac.a.USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC, Integer.valueOf(i));
                        if (i != 0) {
                            com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, true);
                            AppMethodBeat.o(126829);
                            return;
                        }
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, false);
                        AppMethodBeat.o(126829);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SubCoreSetting", e, "device protect security value is not number!", new Object[0]);
                    }
                }
            }
            AppMethodBeat.o(126829);
        }
    };

    public c() {
        AppMethodBeat.i(126830);
        ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
        AppMethodBeat.o(126830);
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
        AppMethodBeat.i(126831);
        ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
        AppMethodBeat.o(126831);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(126832);
        ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("redpointinfo", this.qjv, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("crowdtest", this.qjx, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.qjw);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.qjy);
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_CROWDTEST_CLIENT_VERSION_INT, Integer.valueOf(com.tencent.mm.protocal.d.vxo))).intValue();
        long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(0))).longValue();
        if (intValue <= com.tencent.mm.protocal.d.vxo || longValue < System.currentTimeMillis()) {
            ciq();
        }
        if (z) {
            g.RP().Ry().set(34, Integer.valueOf((r.YK() & -1048577) & -4194305));
            bko bko = new bko();
            bko.vCi = 1048576;
            bko.wNJ = 0;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(39, bko));
            bko = new bko();
            bko.vCi = 4194304;
            bko.wNJ = 0;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(39, bko));
            ab.i("MicroMsg.SubCoreSetting", "set void default open");
            if (!y.L(ah.getContext()).areNotificationsEnabled()) {
                ab.w("MicroMsg.SubCoreSetting", "sys notification disable！");
                com.tencent.mm.plugin.report.service.h.pYm.a(500, 18, 1, false);
            }
            ab.i("MicroMsg.SubCoreSetting", "is update from %s", Integer.valueOf(g.RN().eIR.eKf));
            Set<String> aat = bx.fnB.aat();
            if (aat.size() == 2) {
                String[] strArr = new String[2];
                intValue = 0;
                for (String string : aat) {
                    int i = intValue + 1;
                    strArr[intValue] = bx.fnB.getString(string, "login_user_name");
                    intValue = i;
                }
                if (!bo.Q(strArr[0], strArr[1]) && strArr[0].equals(strArr[1])) {
                    ab.w("MicroMsg.SubCoreSetting", "old dirty data!!!");
                    bx.fnB.oK(strArr[0]);
                    bx.fnB.oK(strArr[1]);
                }
            }
        }
        if (com.tencent.mm.m.g.Nu().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1 && (r.YD() & 32) == 0) {
            ((j) g.K(j.class)).XM().a(this.qju);
        }
        AppMethodBeat.o(126832);
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(126833);
        ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
        AppMethodBeat.o(126833);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(126834);
        ab.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("redpointinfo", this.qjv, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("crowdtest", this.qjx, true);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.qjw);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.qjy);
        ((j) g.K(j.class)).XM().b(this.qju);
        AppMethodBeat.o(126834);
    }

    static void ciq() {
        AppMethodBeat.i(126835);
        g.RP().Ry().set(ac.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(0));
        g.RP().Ry().set(ac.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, (Object) "");
        com.tencent.mm.x.c.PK().y(262157, false);
        AppMethodBeat.o(126835);
    }
}
