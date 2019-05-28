package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.it;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    private static c nvn = new c<it>() {
        {
            AppMethodBeat.i(21710);
            this.xxI = it.class.getName().hashCode();
            AppMethodBeat.o(21710);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(21711);
            if (((it) bVar) instanceof it) {
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(21709);
                        b.access$000();
                        AppMethodBeat.o(21709);
                    }
                }, "IPCall_SyncAddressBook");
            }
            AppMethodBeat.o(21711);
            return false;
        }
    };

    static {
        AppMethodBeat.i(21715);
        AppMethodBeat.o(21715);
    }

    public static void init() {
        AppMethodBeat.i(21712);
        a.xxA.c(nvn);
        AppMethodBeat.o(21712);
    }

    public static void release() {
        AppMethodBeat.i(21713);
        a.xxA.d(nvn);
        AppMethodBeat.o(21713);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(21714);
        try {
            if (aw.RK()) {
                ab.d("MicroMsg.IPCallAddressUpdater", "start updateAddressStorage");
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.ipcall.a.g.b bVar = new com.tencent.mm.plugin.ipcall.a.g.b();
                ArrayList bHY = i.bHw().bHY();
                if (bHY != null && bHY.size() > 0) {
                    HashMap bHX = com.tencent.mm.plugin.ipcall.a.g.b.bHX();
                    if (bHX == null || bHX.size() < 0) {
                        AppMethodBeat.o(21714);
                        return;
                    }
                    com.tencent.mm.plugin.ipcall.a.g.c cVar;
                    long iV = i.bHw().iV(Thread.currentThread().getId());
                    ab.d("MicroMsg.IPCallAddressUpdater", "start delete not exist address");
                    ab.d("MicroMsg.IPCallAddressUpdater", "oldItemList.size: %d", Integer.valueOf(bHY.size()));
                    Iterator it = bHY.iterator();
                    while (it.hasNext()) {
                        cVar = (com.tencent.mm.plugin.ipcall.a.g.c) it.next();
                        if (!bHX.containsKey(cVar.field_contactId)) {
                            long j = cVar.xDa;
                            i.bHw().delete(j);
                            ab.d("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord, id: %d", Long.valueOf(j));
                            Cursor iX = i.bHx().iX(j);
                            if (iX != null) {
                                try {
                                    if (iX.moveToFirst()) {
                                        while (!iX.isAfterLast()) {
                                            k kVar = new k();
                                            kVar.d(iX);
                                            kVar.field_addressId = -1;
                                            kVar.field_phoneType = -1;
                                            i.bHx().a(kVar);
                                            iX.moveToNext();
                                        }
                                    }
                                } catch (Exception e) {
                                    ab.e("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord error: %s", e.getMessage());
                                    if (iX != null) {
                                        iX.close();
                                    }
                                } catch (Throwable th) {
                                    if (iX != null) {
                                        iX.close();
                                    }
                                    AppMethodBeat.o(21714);
                                }
                            }
                            if (iX != null) {
                                iX.close();
                            }
                        }
                    }
                    ab.d("MicroMsg.IPCallAddressUpdater", "start update or insert address");
                    for (com.tencent.mm.plugin.ipcall.a.g.c cVar2 : bHX.values()) {
                        com.tencent.mm.plugin.ipcall.a.g.c OQ = i.bHw().OQ(cVar2.field_contactId);
                        if (OQ == null || OQ.xDa == -1) {
                            i.bHw().b((com.tencent.mm.sdk.e.c) cVar2);
                        } else {
                            Object obj;
                            if (cVar2 != null && com.tencent.mm.plugin.ipcall.a.g.c.eJ(OQ.field_contactId, cVar2.field_contactId) && com.tencent.mm.plugin.ipcall.a.g.c.eJ(OQ.field_systemAddressBookUsername, cVar2.field_systemAddressBookUsername) && com.tencent.mm.plugin.ipcall.a.g.c.eJ(OQ.field_wechatUsername, cVar2.field_wechatUsername)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                i.bHw().a(OQ.xDa, (com.tencent.mm.sdk.e.c) cVar2);
                            }
                        }
                    }
                    i.bHw().iW(iV);
                    ab.d("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                AppMethodBeat.o(21714);
                return;
            }
            ab.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, acc not ready");
            AppMethodBeat.o(21714);
        } catch (Exception e2) {
            ab.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage error:" + e2.getMessage());
            AppMethodBeat.o(21714);
        }
    }
}
