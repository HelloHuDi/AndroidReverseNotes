package com.tencent.p177mm.plugin.ipcall.p438a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C26167it;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21082b;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C28332k;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ipcall.a.b */
public final class C12247b {
    private static C4884c nvn = new C122481();

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b$1 */
    static class C122481 extends C4884c<C26167it> {

        /* renamed from: com.tencent.mm.plugin.ipcall.a.b$1$1 */
        class C122491 implements Runnable {
            C122491() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21709);
                C12247b.access$000();
                AppMethodBeat.m2505o(21709);
            }
        }

        C122481() {
            AppMethodBeat.m2504i(21710);
            this.xxI = C26167it.class.getName().hashCode();
            AppMethodBeat.m2505o(21710);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(21711);
            if (((C26167it) c4883b) instanceof C26167it) {
                C7305d.post(new C122491(), "IPCall_SyncAddressBook");
            }
            AppMethodBeat.m2505o(21711);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(21715);
        AppMethodBeat.m2505o(21715);
    }

    public static void init() {
        AppMethodBeat.m2504i(21712);
        C4879a.xxA.mo10052c(nvn);
        AppMethodBeat.m2505o(21712);
    }

    public static void release() {
        AppMethodBeat.m2504i(21713);
        C4879a.xxA.mo10053d(nvn);
        AppMethodBeat.m2505o(21713);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(21714);
        try {
            if (C9638aw.m17179RK()) {
                C4990ab.m7410d("MicroMsg.IPCallAddressUpdater", "start updateAddressStorage");
                long currentTimeMillis = System.currentTimeMillis();
                C21082b c21082b = new C21082b();
                ArrayList bHY = C21088i.bHw().bHY();
                if (bHY != null && bHY.size() > 0) {
                    HashMap bHX = C21082b.bHX();
                    if (bHX == null || bHX.size() < 0) {
                        AppMethodBeat.m2505o(21714);
                        return;
                    }
                    C21083c c21083c;
                    long iV = C21088i.bHw().mo36410iV(Thread.currentThread().getId());
                    C4990ab.m7410d("MicroMsg.IPCallAddressUpdater", "start delete not exist address");
                    C4990ab.m7411d("MicroMsg.IPCallAddressUpdater", "oldItemList.size: %d", Integer.valueOf(bHY.size()));
                    Iterator it = bHY.iterator();
                    while (it.hasNext()) {
                        c21083c = (C21083c) it.next();
                        if (!bHX.containsKey(c21083c.field_contactId)) {
                            long j = c21083c.xDa;
                            C21088i.bHw().delete(j);
                            C4990ab.m7411d("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord, id: %d", Long.valueOf(j));
                            Cursor iX = C21088i.bHx().mo46246iX(j);
                            if (iX != null) {
                                try {
                                    if (iX.moveToFirst()) {
                                        while (!iX.isAfterLast()) {
                                            C28332k c28332k = new C28332k();
                                            c28332k.mo8995d(iX);
                                            c28332k.field_addressId = -1;
                                            c28332k.field_phoneType = -1;
                                            C21088i.bHx().mo46245a(c28332k);
                                            iX.moveToNext();
                                        }
                                    }
                                } catch (Exception e) {
                                    C4990ab.m7413e("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord error: %s", e.getMessage());
                                    if (iX != null) {
                                        iX.close();
                                    }
                                } catch (Throwable th) {
                                    if (iX != null) {
                                        iX.close();
                                    }
                                    AppMethodBeat.m2505o(21714);
                                }
                            }
                            if (iX != null) {
                                iX.close();
                            }
                        }
                    }
                    C4990ab.m7410d("MicroMsg.IPCallAddressUpdater", "start update or insert address");
                    for (C21083c c21083c2 : bHX.values()) {
                        C21083c OQ = C21088i.bHw().mo36404OQ(c21083c2.field_contactId);
                        if (OQ == null || OQ.xDa == -1) {
                            C21088i.bHw().mo10101b((C4925c) c21083c2);
                        } else {
                            Object obj;
                            if (c21083c2 != null && C21083c.m32390eJ(OQ.field_contactId, c21083c2.field_contactId) && C21083c.m32390eJ(OQ.field_systemAddressBookUsername, c21083c2.field_systemAddressBookUsername) && C21083c.m32390eJ(OQ.field_wechatUsername, c21083c2.field_wechatUsername)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                C21088i.bHw().mo16757a(OQ.xDa, (C4925c) c21083c2);
                            }
                        }
                    }
                    C21088i.bHw().mo36411iW(iV);
                    C4990ab.m7411d("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                AppMethodBeat.m2505o(21714);
                return;
            }
            C4990ab.m7412e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, acc not ready");
            AppMethodBeat.m2505o(21714);
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage error:" + e2.getMessage());
            AppMethodBeat.m2505o(21714);
        }
    }
}
