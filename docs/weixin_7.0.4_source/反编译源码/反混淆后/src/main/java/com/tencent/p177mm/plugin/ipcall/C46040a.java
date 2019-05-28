package com.tencent.p177mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C6491hw;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ipcall.a */
public final class C46040a implements C1202f {
    private static C46040a nuV = null;
    private boolean fpA = false;
    private long nuR = -1;
    private long nuS = -1;
    private long nuT = -1;
    private long nuU = -1;

    /* renamed from: com.tencent.mm.plugin.ipcall.a$1 */
    class C210761 implements Runnable {
        C210761() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21658);
            C4990ab.m7410d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
            C6491hw c6491hw = new C6491hw();
            c6491hw.cCP.scene = 2;
            C4879a.xxA.mo10055m(c6491hw);
            C46040a.this.nuR = System.currentTimeMillis();
            AppMethodBeat.m2505o(21658);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a$2 */
    class C283212 implements Runnable {
        C283212() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21659);
            C46040a.m85627a(C46040a.this);
            AppMethodBeat.m2505o(21659);
        }
    }

    private C46040a() {
    }

    public static C46040a bGG() {
        AppMethodBeat.m2504i(21660);
        if (nuV == null) {
            nuV = new C46040a();
        }
        C46040a c46040a = nuV;
        AppMethodBeat.m2505o(21660);
        return c46040a;
    }

    public final void bGH() {
        AppMethodBeat.m2504i(21661);
        if (!C46041a.apV()) {
            C4990ab.m7410d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
        }
        if (this.fpA) {
            C4990ab.m7410d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
            AppMethodBeat.m2505o(21661);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C9638aw.m17190ZK();
        if (Math.abs(currentTimeMillis - ((Long) C18628c.m29072Ry().get(C5127a.USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG, Long.valueOf(0))).longValue()) >= 86400000) {
            this.fpA = true;
            this.nuR = -1;
            this.nuS = -1;
            this.nuT = -1;
            this.nuU = -1;
            C9638aw.m17182Rg().mo14539a(32, (C1202f) this);
            C7305d.post(new C210761(), "IPCallAddressBookUpdater_updateUsername");
            AppMethodBeat.m2505o(21661);
            return;
        }
        C4990ab.m7410d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
        AppMethodBeat.m2505o(21661);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(21662);
        C4990ab.m7411d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.fpA));
        if (this.fpA) {
            C9638aw.m17182Rg().mo14546b(32, (C1202f) this);
            this.nuS = System.currentTimeMillis();
            C4990ab.m7411d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", Long.valueOf(this.nuS - this.nuR));
            if (i == 0 && i2 == 0) {
                C7305d.post(new C283212(), "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
                AppMethodBeat.m2505o(21662);
                return;
            }
            C4990ab.m7410d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
            this.fpA = false;
            C46040a.bGI();
            AppMethodBeat.m2505o(21662);
            return;
        }
        AppMethodBeat.m2505o(21662);
    }

    private static void bGI() {
        AppMethodBeat.m2504i(21663);
        long currentTimeMillis = System.currentTimeMillis();
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
        AppMethodBeat.m2505o(21663);
    }

    /* renamed from: a */
    static /* synthetic */ void m85627a(C46040a c46040a) {
        AppMethodBeat.m2504i(21664);
        C4990ab.m7410d("MicroMsg.IPCallAddressBookUsernameUpdater", "updateUsernameAfterGetMFriend");
        c46040a.nuT = System.currentTimeMillis();
        ArrayList bHY = C21088i.bHw().bHY();
        if (bHY != null && bHY.size() > 0) {
            C4990ab.m7411d("MicroMsg.IPCallAddressBookUsernameUpdater", "addressitemList.size: %d", Integer.valueOf(bHY.size()));
            long iV = C21088i.bHw().mo36410iV(Thread.currentThread().getId());
            Iterator it = bHY.iterator();
            while (it.hasNext()) {
                C21083c c21083c = (C21083c) it.next();
                String Po = C46041a.m85629Po(c21083c.field_contactId);
                if (c21083c.xDa > 0 && !C5046bo.isNullOrNil(Po)) {
                    C4990ab.m7411d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username for contactId: %s, newUsername: %s, oldUsername: %s", c21083c.field_contactId, Po, c21083c.field_wechatUsername);
                    if ((!C5046bo.isNullOrNil(c21083c.field_wechatUsername) && !c21083c.field_wechatUsername.equals(Po)) || C5046bo.isNullOrNil(c21083c.field_wechatUsername)) {
                        c21083c.field_wechatUsername = Po;
                        C21088i.bHw().mo16757a(c21083c.xDa, (C4925c) c21083c);
                    }
                }
            }
            C21088i.bHw().mo36411iW(iV);
        }
        c46040a.nuU = System.currentTimeMillis();
        C4990ab.m7411d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username use %dms", Long.valueOf(c46040a.nuU - c46040a.nuT));
        c46040a.fpA = false;
        C46040a.bGI();
        AppMethodBeat.m2505o(21664);
    }
}
