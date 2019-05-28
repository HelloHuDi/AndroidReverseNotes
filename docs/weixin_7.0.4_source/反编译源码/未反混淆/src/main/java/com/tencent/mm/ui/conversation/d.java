package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.js;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.af;
import java.util.HashMap;
import java.util.Map.Entry;

public final class d {
    Activity activity;
    ListView zqz;
    HashMap<String, Integer> zra = new HashMap();
    int zrb = -1;
    int zrc = -1;
    h zrd;
    c zre = new c<nx>() {
        {
            AppMethodBeat.i(34174);
            this.xxI = nx.class.getName().hashCode();
            AppMethodBeat.o(34174);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(34175);
            if (d.this.zrd != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34173);
                        ab.d("MicroMsg.ConvUnreadHelper", "refresh main ui unread count.");
                        d.this.zrd.notifyDataSetChanged();
                        d.this.dIp();
                        AppMethodBeat.o(34173);
                    }
                });
            }
            AppMethodBeat.o(34175);
            return true;
        }
    };
    c zrf = new c<bd>() {
        {
            AppMethodBeat.i(34176);
            this.xxI = bd.class.getName().hashCode();
            AppMethodBeat.o(34176);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(34177);
            if (((bd) bVar).cuo.cup != d.this.zrc) {
                ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck wrong should be %d, but is %d", Integer.valueOf(((bd) bVar).cuo.cup), Integer.valueOf(d.this.zrc));
                d.this.zrc = -1;
            }
            AppMethodBeat.o(34177);
            return true;
        }
    };
    c zrg = new c<js>() {
        private final long INTERVAL;
        long zrj;
        int zrk;

        {
            AppMethodBeat.i(34179);
            this.INTERVAL = 3000;
            this.zrj = 0;
            this.zrk = -1;
            this.xxI = js.class.getName().hashCode();
            AppMethodBeat.o(34179);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(34180);
            if (d.this.activity == null) {
                AppMethodBeat.o(34180);
            } else {
                ab.d("MicroMsg.ConvUnreadHelper", "trigger double tab");
                d.this.zqz.postDelayed(new Runnable() {
                    public final void run() {
                        int firstVisiblePosition;
                        int i;
                        int i2;
                        AppMethodBeat.i(34178);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - AnonymousClass3.this.zrj >= 3000 || AnonymousClass3.this.zrk < 0) {
                            firstVisiblePosition = (d.this.zqz.getFirstVisiblePosition() - d.this.zqz.getHeaderViewsCount()) + 1;
                            if (firstVisiblePosition < 0) {
                                i = 0;
                            } else {
                                i = firstVisiblePosition;
                            }
                        } else {
                            i = AnonymousClass3.this.zrk;
                        }
                        h hVar = d.this.zrd;
                        if (d.this.zrc > 0) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        int count = hVar.getCount();
                        if (count > 0) {
                            for (int abs = Math.abs((i + 1) % count); abs != i; abs = (abs + 1) % count) {
                                ak akVar = (ak) hVar.getItem(abs);
                                if (akVar != null && (akVar.field_unReadCount > 0 || akVar.field_unReadMuteCount > 0)) {
                                    if (i2 == 0) {
                                        i2 = abs;
                                        break;
                                    } else if (h.a(akVar, hVar.i(akVar)) == 2) {
                                        i2 = abs;
                                        break;
                                    }
                                }
                            }
                        }
                        i2 = -1;
                        if (i2 < 0) {
                            BackwardSupportUtil.c.c(d.this.zqz, d.this.zqz.getHeaderViewsCount());
                        } else {
                            BackwardSupportUtil.c.c(d.this.zqz, d.this.zqz.getHeaderViewsCount() + i2);
                        }
                        AnonymousClass3.this.zrj = currentTimeMillis;
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (i2 < 0) {
                            firstVisiblePosition = 0;
                        } else {
                            firstVisiblePosition = i2;
                        }
                        anonymousClass3.zrk = firstVisiblePosition;
                        ab.d("MicroMsg.ConvUnreadHelper", "headerCount %d, scroll from %d to %d", Integer.valueOf(d.this.zqz.getHeaderViewsCount()), Integer.valueOf(i), Integer.valueOf(i2));
                        AppMethodBeat.o(34178);
                    }
                }, 100);
                AppMethodBeat.o(34180);
            }
            return false;
        }
    };

    public d() {
        AppMethodBeat.i(34181);
        AppMethodBeat.o(34181);
    }

    public final void ax(Activity activity) {
        AppMethodBeat.i(34182);
        this.zrc = ((LauncherUI) activity).yjJ.getMainTabUI().dyF();
        AppMethodBeat.o(34182);
    }

    public final void dIp() {
        AppMethodBeat.i(34183);
        if (this.activity == null) {
            AppMethodBeat.o(34183);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LauncherUI launcherUI = (LauncherUI) this.activity;
        ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", Integer.valueOf(this.zrb));
        switch (this.zrb) {
            case 1:
                AppMethodBeat.o(34183);
                return;
            case 2:
                int i = 0;
                for (Entry entry : this.zra.entrySet()) {
                    int i2;
                    String str = (String) entry.getKey();
                    int intValue = ((Integer) entry.getValue()).intValue();
                    ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", str, Integer.valueOf(intValue));
                    ak arU = arU(str);
                    if (arU == null || af.dzi().contains(str)) {
                        ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", str, Integer.valueOf(0 - intValue));
                        i2 = intValue;
                    } else {
                        ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", str, Integer.valueOf((arU.field_unReadCount - intValue) + 0));
                        i2 = intValue;
                    }
                    if (i2 != 0 && this.zrd.arV(str)) {
                        ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", str);
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(str);
                        if (aoO != null) {
                            if (t.kH(str)) {
                                if (aoO.dua == 0) {
                                }
                            } else if (aoO.DX()) {
                            }
                        }
                    }
                    ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", str, Integer.valueOf(i2), Integer.valueOf(i + i2));
                    i = intValue;
                }
                this.zrc += i;
                MainTabUI mainTabUI = launcherUI.yjJ.getMainTabUI();
                mainTabUI.ynE.No(this.zrc);
                ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", Integer.valueOf(this.zrc), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(34183);
                return;
            default:
                this.zrc = launcherUI.yjJ.getMainTabUI().dyF();
                ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", Integer.valueOf(this.zrc), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(34183);
                return;
        }
    }

    /* Access modifiers changed, original: final */
    public final ak arU(String str) {
        AppMethodBeat.i(34184);
        if (this.zrd != null) {
            ak akVar = (ak) this.zrd.cL(str);
            AppMethodBeat.o(34184);
            return akVar;
        }
        AppMethodBeat.o(34184);
        return null;
    }
}
