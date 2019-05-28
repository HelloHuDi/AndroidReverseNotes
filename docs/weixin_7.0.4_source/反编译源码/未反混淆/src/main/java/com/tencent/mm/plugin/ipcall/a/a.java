package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a {
    private static a nvl = null;
    private long endTime = -1;
    ak handler = new ak(Looper.getMainLooper()) {
        /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(Message message) {
            AppMethodBeat.i(21705);
            long currentTimeMillis = System.currentTimeMillis();
            d bHw = i.bHw();
            ArrayList<c> arrayList = (ArrayList) message.obj;
            if (arrayList != null && arrayList.size() > 0) {
                long iV = bHw.iV(Thread.currentThread().getId());
                ab.i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
                Cursor a = bHw.bSd.a("IPCallAddressItem", new String[]{"contactId"}, null, null, null, null, null, 2);
                HashMap hashMap = new HashMap();
                if (a == null || !a.moveToFirst()) {
                    if (a != null) {
                        a.close();
                    }
                    ab.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (c cVar : arrayList) {
                        if (!hashMap.containsKey(cVar.field_contactId)) {
                            bHw.b((com.tencent.mm.sdk.e.c) cVar);
                        }
                    }
                    bHw.iW(iV);
                } else {
                    do {
                        String string = a.getString(0);
                        if (!hashMap.containsKey(string)) {
                            hashMap.put(string, Boolean.TRUE);
                        }
                    } while (a.moveToNext());
                    if (a != null) {
                    }
                    ab.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (c cVar2 : arrayList) {
                    }
                    bHw.iW(iV);
                }
            }
            ab.d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            a.this.endTime = System.currentTimeMillis();
            ab.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", Long.valueOf(a.this.endTime - a.this.startTime));
            a.this.isLoading = false;
            a.this.endTime = -1;
            a.this.startTime = -1;
            Iterator it = a.this.nvk.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.aLj();
                }
            }
            a.this.nvk.clear();
            AppMethodBeat.o(21705);
        }
    };
    private boolean isLoading = false;
    public ArrayList<a> nvk = new ArrayList();
    private long startTime = -1;

    public interface a {
        void aLj();
    }

    private a() {
        AppMethodBeat.i(21706);
        AppMethodBeat.o(21706);
    }

    public static a bHb() {
        AppMethodBeat.i(21707);
        if (nvl == null) {
            nvl = new a();
        }
        a aVar = nvl;
        AppMethodBeat.o(21707);
        return aVar;
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(21708);
        if (aVar != null) {
            this.nvk.add(aVar);
        }
        if (this.isLoading) {
            ab.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
            AppMethodBeat.o(21708);
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (b.bHW().size() == 0 || !z) {
            ab.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b();
            ArrayList bHV = b.bHV();
            ab.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.obj = bHV;
            this.handler.sendMessage(obtainMessage);
            this.isLoading = true;
            AppMethodBeat.o(21708);
            return;
        }
        AppMethodBeat.o(21708);
    }
}
