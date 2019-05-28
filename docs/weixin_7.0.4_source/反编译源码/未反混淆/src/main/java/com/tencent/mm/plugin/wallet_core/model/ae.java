package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class ae {
    static ArrayList<l> lUV = null;
    private static ae tCu = null;
    a kBx = new a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(46917);
            String a = aa.a(aVar.eAB.vED);
            ab.d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(a)));
            Map z = br.z(a, "sysmsg");
            int i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            if (!ae.a(ae.this, i, z)) {
                ae.e(i, z);
            }
            AppMethodBeat.o(46917);
        }
    };

    private ae() {
        AppMethodBeat.i(46920);
        AppMethodBeat.o(46920);
    }

    public static ae cPT() {
        AppMethodBeat.i(46921);
        if (tCu == null) {
            tCu = new ae();
        }
        ae aeVar = tCu;
        AppMethodBeat.o(46921);
        return aeVar;
    }

    public static boolean a(l lVar) {
        AppMethodBeat.i(46922);
        if (lUV == null) {
            lUV = new ArrayList();
        }
        lUV.add(lVar);
        AppMethodBeat.o(46922);
        return true;
    }

    public static boolean b(l lVar) {
        AppMethodBeat.i(46923);
        if (lUV == null) {
            ab.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
            AppMethodBeat.o(46923);
            return false;
        }
        lUV.remove(lVar);
        AppMethodBeat.o(46923);
        return true;
    }

    static /* synthetic */ boolean a(ae aeVar, int i, Map map) {
        AppMethodBeat.i(46924);
        if (map == null) {
            ab.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
            AppMethodBeat.o(46924);
            return true;
        } else if (i < 0) {
            ab.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
            AppMethodBeat.o(46924);
            return true;
        } else if (i == 12) {
            final int i2 = bo.getInt((String) map.get(".sysmsg.paymsg.avail_balance"), -1);
            final long j = bo.getLong((String) map.get(".sysmsg.paymsg.balance_version"), -1);
            final long j2 = bo.getLong((String) map.get(".sysmsg.paymsg.time_out"), 7200);
            final int i3 = i;
            final Map map2 = map;
            com.tencent.mm.wallet_core.ui.e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new com.tencent.mm.wallet_core.ui.e.a() {
                public final void ak(Map<String, Object> map) {
                    AppMethodBeat.i(46919);
                    if (map != null) {
                        long a = bo.a((Long) map.get("wallet_balance_version"), -1);
                        long a2 = bo.a((Long) map.get("wallet_balance_last_update_time"), -1);
                        if (a2 < 0 || a < 0 || a2 + j2 > bo.yz() || j >= a) {
                            com.tencent.mm.wallet_core.ui.e.a(new c("wallet_balance_version", Long.valueOf(j)), new c("wallet_balance_last_update_time", Long.valueOf(bo.yz())), new c("wallet_balance", Double.valueOf(((double) i2) / 100.0d)));
                            ae.e(i3, map2);
                            AppMethodBeat.o(46919);
                            return;
                        }
                        ab.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                    }
                    AppMethodBeat.o(46919);
                }
            });
            AppMethodBeat.o(46924);
            return true;
        } else {
            AppMethodBeat.o(46924);
            return false;
        }
    }

    static /* synthetic */ void e(final int i, final Map map) {
        AppMethodBeat.i(46925);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(46918);
                if (ae.lUV != null) {
                    Iterator it = ae.lUV.iterator();
                    while (it.hasNext()) {
                        l lVar = (l) it.next();
                        if (lVar != null) {
                            lVar.yq(i);
                        }
                    }
                }
                AppMethodBeat.o(46918);
            }
        });
        AppMethodBeat.o(46925);
    }
}
