package com.tencent.p177mm.p612ui.conversation;

import android.app.Activity;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C37775nx;
import com.tencent.p177mm.p230g.p231a.C45336js;
import com.tencent.p177mm.p230g.p231a.C9299bd;
import com.tencent.p177mm.p612ui.C36036af;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MainTabUI;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.ui.conversation.d */
public final class C36274d {
    Activity activity;
    ListView zqz;
    HashMap<String, Integer> zra = new HashMap();
    int zrb = -1;
    int zrc = -1;
    C23987h zrd;
    C4884c zre = new C362751();
    C4884c zrf = new C362762();
    C4884c zrg = new C362723();

    /* renamed from: com.tencent.mm.ui.conversation.d$3 */
    class C362723 extends C4884c<C45336js> {
        private final long INTERVAL;
        long zrj;
        int zrk;

        /* renamed from: com.tencent.mm.ui.conversation.d$3$1 */
        class C362731 implements Runnable {
            C362731() {
            }

            public final void run() {
                int firstVisiblePosition;
                int i;
                int i2;
                AppMethodBeat.m2504i(34178);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - C362723.this.zrj >= 3000 || C362723.this.zrk < 0) {
                    firstVisiblePosition = (C36274d.this.zqz.getFirstVisiblePosition() - C36274d.this.zqz.getHeaderViewsCount()) + 1;
                    if (firstVisiblePosition < 0) {
                        i = 0;
                    } else {
                        i = firstVisiblePosition;
                    }
                } else {
                    i = C362723.this.zrk;
                }
                C23987h c23987h = C36274d.this.zrd;
                if (C36274d.this.zrc > 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                int count = c23987h.getCount();
                if (count > 0) {
                    for (int abs = Math.abs((i + 1) % count); abs != i; abs = (abs + 1) % count) {
                        C7617ak c7617ak = (C7617ak) c23987h.getItem(abs);
                        if (c7617ak != null && (c7617ak.field_unReadCount > 0 || c7617ak.field_unReadMuteCount > 0)) {
                            if (i2 == 0) {
                                i2 = abs;
                                break;
                            } else if (C23987h.m36961a(c7617ak, c23987h.mo39794i(c7617ak)) == 2) {
                                i2 = abs;
                                break;
                            }
                        }
                    }
                }
                i2 = -1;
                if (i2 < 0) {
                    C4978c.m7377c(C36274d.this.zqz, C36274d.this.zqz.getHeaderViewsCount());
                } else {
                    C4978c.m7377c(C36274d.this.zqz, C36274d.this.zqz.getHeaderViewsCount() + i2);
                }
                C362723.this.zrj = currentTimeMillis;
                C362723 c362723 = C362723.this;
                if (i2 < 0) {
                    firstVisiblePosition = 0;
                } else {
                    firstVisiblePosition = i2;
                }
                c362723.zrk = firstVisiblePosition;
                C4990ab.m7411d("MicroMsg.ConvUnreadHelper", "headerCount %d, scroll from %d to %d", Integer.valueOf(C36274d.this.zqz.getHeaderViewsCount()), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(34178);
            }
        }

        C362723() {
            AppMethodBeat.m2504i(34179);
            this.INTERVAL = 3000;
            this.zrj = 0;
            this.zrk = -1;
            this.xxI = C45336js.class.getName().hashCode();
            AppMethodBeat.m2505o(34179);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34180);
            if (C36274d.this.activity == null) {
                AppMethodBeat.m2505o(34180);
            } else {
                C4990ab.m7410d("MicroMsg.ConvUnreadHelper", "trigger double tab");
                C36274d.this.zqz.postDelayed(new C362731(), 100);
                AppMethodBeat.m2505o(34180);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.d$1 */
    class C362751 extends C4884c<C37775nx> {

        /* renamed from: com.tencent.mm.ui.conversation.d$1$1 */
        class C158661 implements Runnable {
            C158661() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34173);
                C4990ab.m7410d("MicroMsg.ConvUnreadHelper", "refresh main ui unread count.");
                C36274d.this.zrd.notifyDataSetChanged();
                C36274d.this.dIp();
                AppMethodBeat.m2505o(34173);
            }
        }

        C362751() {
            AppMethodBeat.m2504i(34174);
            this.xxI = C37775nx.class.getName().hashCode();
            AppMethodBeat.m2505o(34174);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34175);
            if (C36274d.this.zrd != null) {
                C5004al.m7441d(new C158661());
            }
            AppMethodBeat.m2505o(34175);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.d$2 */
    class C362762 extends C4884c<C9299bd> {
        C362762() {
            AppMethodBeat.m2504i(34176);
            this.xxI = C9299bd.class.getName().hashCode();
            AppMethodBeat.m2505o(34176);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34177);
            if (((C9299bd) c4883b).cuo.cup != C36274d.this.zrc) {
                C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck wrong should be %d, but is %d", Integer.valueOf(((C9299bd) c4883b).cuo.cup), Integer.valueOf(C36274d.this.zrc));
                C36274d.this.zrc = -1;
            }
            AppMethodBeat.m2505o(34177);
            return true;
        }
    }

    public C36274d() {
        AppMethodBeat.m2504i(34181);
        AppMethodBeat.m2505o(34181);
    }

    /* renamed from: ax */
    public final void mo57140ax(Activity activity) {
        AppMethodBeat.m2504i(34182);
        this.zrc = ((LauncherUI) activity).yjJ.getMainTabUI().dyF();
        AppMethodBeat.m2505o(34182);
    }

    public final void dIp() {
        AppMethodBeat.m2504i(34183);
        if (this.activity == null) {
            AppMethodBeat.m2505o(34183);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LauncherUI launcherUI = (LauncherUI) this.activity;
        C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", Integer.valueOf(this.zrb));
        switch (this.zrb) {
            case 1:
                AppMethodBeat.m2505o(34183);
                return;
            case 2:
                int i = 0;
                for (Entry entry : this.zra.entrySet()) {
                    int i2;
                    String str = (String) entry.getKey();
                    int intValue = ((Integer) entry.getValue()).intValue();
                    C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", str, Integer.valueOf(intValue));
                    C7617ak arU = arU(str);
                    if (arU == null || C36036af.dzi().contains(str)) {
                        C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", str, Integer.valueOf(0 - intValue));
                        i2 = intValue;
                    } else {
                        C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", str, Integer.valueOf((arU.field_unReadCount - intValue) + 0));
                        i2 = intValue;
                    }
                    if (i2 != 0 && this.zrd.arV(str)) {
                        C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", str);
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(str);
                        if (aoO != null) {
                            if (C1855t.m3896kH(str)) {
                                if (aoO.dua == 0) {
                                }
                            } else if (aoO.mo16673DX()) {
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", str, Integer.valueOf(i2), Integer.valueOf(i + i2));
                    i = intValue;
                }
                this.zrc += i;
                MainTabUI mainTabUI = launcherUI.yjJ.getMainTabUI();
                mainTabUI.ynE.mo70264No(this.zrc);
                C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", Integer.valueOf(this.zrc), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(34183);
                return;
            default:
                this.zrc = launcherUI.yjJ.getMainTabUI().dyF();
                C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", Integer.valueOf(this.zrc), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(34183);
                return;
        }
    }

    /* Access modifiers changed, original: final */
    public final C7617ak arU(String str) {
        AppMethodBeat.m2504i(34184);
        if (this.zrd != null) {
            C7617ak c7617ak = (C7617ak) this.zrd.mo64393cL(str);
            AppMethodBeat.m2505o(34184);
            return c7617ak;
        }
        AppMethodBeat.m2505o(34184);
        return null;
    }
}
