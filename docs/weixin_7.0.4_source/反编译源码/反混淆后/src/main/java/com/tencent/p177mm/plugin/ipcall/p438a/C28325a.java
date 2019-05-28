package com.tencent.p177mm.plugin.ipcall.p438a;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21082b;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21084d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ipcall.a.a */
public final class C28325a {
    private static C28325a nvl = null;
    private long endTime = -1;
    C7306ak handler = new C7306ak(Looper.getMainLooper()) {
        /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(21705);
            long currentTimeMillis = System.currentTimeMillis();
            C21084d bHw = C21088i.bHw();
            ArrayList<C21083c> arrayList = (ArrayList) message.obj;
            if (arrayList != null && arrayList.size() > 0) {
                long iV = bHw.mo36410iV(Thread.currentThread().getId());
                C4990ab.m7416i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
                Cursor a = bHw.bSd.mo10105a("IPCallAddressItem", new String[]{"contactId"}, null, null, null, null, null, 2);
                HashMap hashMap = new HashMap();
                if (a == null || !a.moveToFirst()) {
                    if (a != null) {
                        a.close();
                    }
                    C4990ab.m7416i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (C21083c c21083c : arrayList) {
                        if (!hashMap.containsKey(c21083c.field_contactId)) {
                            bHw.mo10101b((C4925c) c21083c);
                        }
                    }
                    bHw.mo36411iW(iV);
                } else {
                    do {
                        String string = a.getString(0);
                        if (!hashMap.containsKey(string)) {
                            hashMap.put(string, Boolean.TRUE);
                        }
                    } while (a.moveToNext());
                    if (a != null) {
                    }
                    C4990ab.m7416i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (C21083c c21083c2 : arrayList) {
                    }
                    bHw.mo36411iW(iV);
                }
            }
            C4990ab.m7411d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            C28325a.this.endTime = System.currentTimeMillis();
            C4990ab.m7411d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", Long.valueOf(C28325a.this.endTime - C28325a.this.startTime));
            C28325a.this.isLoading = false;
            C28325a.this.endTime = -1;
            C28325a.this.startTime = -1;
            Iterator it = C28325a.this.nvk.iterator();
            while (it.hasNext()) {
                C28322a c28322a = (C28322a) it.next();
                if (c28322a != null) {
                    c28322a.aLj();
                }
            }
            C28325a.this.nvk.clear();
            AppMethodBeat.m2505o(21705);
        }
    };
    private boolean isLoading = false;
    public ArrayList<C28322a> nvk = new ArrayList();
    private long startTime = -1;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.a$a */
    public interface C28322a {
        void aLj();
    }

    private C28325a() {
        AppMethodBeat.m2504i(21706);
        AppMethodBeat.m2505o(21706);
    }

    public static C28325a bHb() {
        AppMethodBeat.m2504i(21707);
        if (nvl == null) {
            nvl = new C28325a();
        }
        C28325a c28325a = nvl;
        AppMethodBeat.m2505o(21707);
        return c28325a;
    }

    /* renamed from: a */
    public final void mo46238a(C28322a c28322a, boolean z) {
        AppMethodBeat.m2504i(21708);
        if (c28322a != null) {
            this.nvk.add(c28322a);
        }
        if (this.isLoading) {
            C4990ab.m7410d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
            AppMethodBeat.m2505o(21708);
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (C21082b.bHW().size() == 0 || !z) {
            C4990ab.m7410d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
            long currentTimeMillis = System.currentTimeMillis();
            C21082b c21082b = new C21082b();
            ArrayList bHV = C21082b.bHV();
            C4990ab.m7411d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.obj = bHV;
            this.handler.sendMessage(obtainMessage);
            this.isLoading = true;
            AppMethodBeat.m2505o(21708);
            return;
        }
        AppMethodBeat.m2505o(21708);
    }
}
