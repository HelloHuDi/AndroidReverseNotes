package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C36391e.C30881a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e.C30882c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.ae */
public final class C43803ae {
    static ArrayList<C29633l> lUV = null;
    private static C43803ae tCu = null;
    C1837a kBx = new C438001();

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.ae$1 */
    class C438001 implements C1837a {
        C438001() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(46917);
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7410d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(a)));
            Map z = C5049br.m7595z(a, "sysmsg");
            int i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            if (!C43803ae.m78510a(C43803ae.this, i, z)) {
                C43803ae.m78513e(i, z);
            }
            AppMethodBeat.m2505o(46917);
        }
    }

    private C43803ae() {
        AppMethodBeat.m2504i(46920);
        AppMethodBeat.m2505o(46920);
    }

    public static C43803ae cPT() {
        AppMethodBeat.m2504i(46921);
        if (tCu == null) {
            tCu = new C43803ae();
        }
        C43803ae c43803ae = tCu;
        AppMethodBeat.m2505o(46921);
        return c43803ae;
    }

    /* renamed from: a */
    public static boolean m78511a(C29633l c29633l) {
        AppMethodBeat.m2504i(46922);
        if (lUV == null) {
            lUV = new ArrayList();
        }
        lUV.add(c29633l);
        AppMethodBeat.m2505o(46922);
        return true;
    }

    /* renamed from: b */
    public static boolean m78512b(C29633l c29633l) {
        AppMethodBeat.m2504i(46923);
        if (lUV == null) {
            C4990ab.m7412e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
            AppMethodBeat.m2505o(46923);
            return false;
        }
        lUV.remove(c29633l);
        AppMethodBeat.m2505o(46923);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m78510a(C43803ae c43803ae, int i, Map map) {
        AppMethodBeat.m2504i(46924);
        if (map == null) {
            C4990ab.m7420w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
            AppMethodBeat.m2505o(46924);
            return true;
        } else if (i < 0) {
            C4990ab.m7420w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
            AppMethodBeat.m2505o(46924);
            return true;
        } else if (i == 12) {
            final int i2 = C5046bo.getInt((String) map.get(".sysmsg.paymsg.avail_balance"), -1);
            final long j = C5046bo.getLong((String) map.get(".sysmsg.paymsg.balance_version"), -1);
            final long j2 = C5046bo.getLong((String) map.get(".sysmsg.paymsg.time_out"), 7200);
            final int i3 = i;
            final Map map2 = map;
            C36391e.m59988a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new C30881a() {
                /* renamed from: ak */
                public final void mo49394ak(Map<String, Object> map) {
                    AppMethodBeat.m2504i(46919);
                    if (map != null) {
                        long a = C5046bo.m7514a((Long) map.get("wallet_balance_version"), -1);
                        long a2 = C5046bo.m7514a((Long) map.get("wallet_balance_last_update_time"), -1);
                        if (a2 < 0 || a < 0 || a2 + j2 > C5046bo.m7588yz() || j >= a) {
                            C36391e.m59987a(new C30882c("wallet_balance_version", Long.valueOf(j)), new C30882c("wallet_balance_last_update_time", Long.valueOf(C5046bo.m7588yz())), new C30882c("wallet_balance", Double.valueOf(((double) i2) / 100.0d)));
                            C43803ae.m78513e(i3, map2);
                            AppMethodBeat.m2505o(46919);
                            return;
                        }
                        C4990ab.m7420w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                    }
                    AppMethodBeat.m2505o(46919);
                }
            });
            AppMethodBeat.m2505o(46924);
            return true;
        } else {
            AppMethodBeat.m2505o(46924);
            return false;
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m78513e(final int i, final Map map) {
        AppMethodBeat.m2504i(46925);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(46918);
                if (C43803ae.lUV != null) {
                    Iterator it = C43803ae.lUV.iterator();
                    while (it.hasNext()) {
                        C29633l c29633l = (C29633l) it.next();
                        if (c29633l != null) {
                            c29633l.mo41704yq(i);
                        }
                    }
                }
                AppMethodBeat.m2505o(46918);
            }
        });
        AppMethodBeat.m2505o(46925);
    }
}
