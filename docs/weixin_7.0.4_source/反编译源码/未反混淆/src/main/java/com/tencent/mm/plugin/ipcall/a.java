package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements f {
    private static a nuV = null;
    private boolean fpA = false;
    private long nuR = -1;
    private long nuS = -1;
    private long nuT = -1;
    private long nuU = -1;

    private a() {
    }

    public static a bGG() {
        AppMethodBeat.i(21660);
        if (nuV == null) {
            nuV = new a();
        }
        a aVar = nuV;
        AppMethodBeat.o(21660);
        return aVar;
    }

    public final void bGH() {
        AppMethodBeat.i(21661);
        if (!com.tencent.mm.plugin.ipcall.b.a.apV()) {
            ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
        }
        if (this.fpA) {
            ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
            AppMethodBeat.o(21661);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        aw.ZK();
        if (Math.abs(currentTimeMillis - ((Long) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG, Long.valueOf(0))).longValue()) >= 86400000) {
            this.fpA = true;
            this.nuR = -1;
            this.nuS = -1;
            this.nuT = -1;
            this.nuU = -1;
            aw.Rg().a(32, (f) this);
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21658);
                    ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
                    hw hwVar = new hw();
                    hwVar.cCP.scene = 2;
                    com.tencent.mm.sdk.b.a.xxA.m(hwVar);
                    a.this.nuR = System.currentTimeMillis();
                    AppMethodBeat.o(21658);
                }
            }, "IPCallAddressBookUpdater_updateUsername");
            AppMethodBeat.o(21661);
            return;
        }
        ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
        AppMethodBeat.o(21661);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(21662);
        ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.fpA));
        if (this.fpA) {
            aw.Rg().b(32, (f) this);
            this.nuS = System.currentTimeMillis();
            ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", Long.valueOf(this.nuS - this.nuR));
            if (i == 0 && i2 == 0) {
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(21659);
                        a.a(a.this);
                        AppMethodBeat.o(21659);
                    }
                }, "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
                AppMethodBeat.o(21662);
                return;
            }
            ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
            this.fpA = false;
            bGI();
            AppMethodBeat.o(21662);
            return;
        }
        AppMethodBeat.o(21662);
    }

    private static void bGI() {
        AppMethodBeat.i(21663);
        long currentTimeMillis = System.currentTimeMillis();
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(21663);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(21664);
        ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "updateUsernameAfterGetMFriend");
        aVar.nuT = System.currentTimeMillis();
        ArrayList bHY = i.bHw().bHY();
        if (bHY != null && bHY.size() > 0) {
            ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "addressitemList.size: %d", Integer.valueOf(bHY.size()));
            long iV = i.bHw().iV(Thread.currentThread().getId());
            Iterator it = bHY.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.ipcall.a.g.c cVar = (com.tencent.mm.plugin.ipcall.a.g.c) it.next();
                String Po = com.tencent.mm.plugin.ipcall.b.a.Po(cVar.field_contactId);
                if (cVar.xDa > 0 && !bo.isNullOrNil(Po)) {
                    ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username for contactId: %s, newUsername: %s, oldUsername: %s", cVar.field_contactId, Po, cVar.field_wechatUsername);
                    if ((!bo.isNullOrNil(cVar.field_wechatUsername) && !cVar.field_wechatUsername.equals(Po)) || bo.isNullOrNil(cVar.field_wechatUsername)) {
                        cVar.field_wechatUsername = Po;
                        i.bHw().a(cVar.xDa, (com.tencent.mm.sdk.e.c) cVar);
                    }
                }
            }
            i.bHw().iW(iV);
        }
        aVar.nuU = System.currentTimeMillis();
        ab.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username use %dms", Long.valueOf(aVar.nuU - aVar.nuT));
        aVar.fpA = false;
        bGI();
        AppMethodBeat.o(21664);
    }
}
