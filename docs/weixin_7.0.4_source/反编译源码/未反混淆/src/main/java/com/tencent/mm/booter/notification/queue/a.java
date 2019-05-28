package com.tencent.mm.booter.notification.queue;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements Serializable, Iterable<a> {
    LinkedList<a> eed;

    public static class a implements Serializable {
        public long cvx = -1;
        public int edE;
        public boolean edY = false;
        public int eee;
        public int eef = 0;
        public String userName = "";

        public a(int i, long j, String str, int i2, boolean z, int i3) {
            AppMethodBeat.i(15969);
            a(i, j, str, i2, z, i3);
            AppMethodBeat.o(15969);
        }

        public a(int i, boolean z) {
            this.eee = i;
            this.edY = z;
        }

        public final String toString() {
            AppMethodBeat.i(15970);
            String str = this.userName + " id:" + this.cvx + " unReadCount:" + this.edE + "　notificationId:" + this.eee;
            AppMethodBeat.o(15970);
            return str;
        }

        public final void a(int i, long j, String str, int i2, boolean z, int i3) {
            this.eee = i;
            this.cvx = j;
            this.userName = str;
            this.edE = i2;
            this.edY = z;
            this.eef = i3;
        }
    }

    public final String toString() {
        AppMethodBeat.i(15971);
        String str = "";
        Iterator it = this.eed.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + ((a) it.next()).toString() + ";  ";
            } else {
                AppMethodBeat.o(15971);
                return str2;
            }
        }
    }

    public final synchronized void restore() {
        AppMethodBeat.i(15972);
        try {
            this.eed = (LinkedList) c.jQ(com.tencent.mm.m.a.MA().getString("com.tencent.preference.notification.key.queue", ""));
            if (this.eed == null) {
                this.eed = new LinkedList();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
            if (this.eed == null) {
                this.eed = new LinkedList();
            }
        } catch (Throwable th) {
            if (this.eed == null) {
                this.eed = new LinkedList();
            }
            AppMethodBeat.o(15972);
        }
        ab.i("MicroMsg.NotificationAppMsgQueue", "restore size:%d, %s", Integer.valueOf(this.eed.size()), toString());
        AppMethodBeat.o(15972);
    }

    private synchronized void save() {
        AppMethodBeat.i(15973);
        if (this.eed == null) {
            AppMethodBeat.o(15973);
        } else {
            ab.d("MicroMsg.NotificationAppMsgQueue", "save: size: %d", Integer.valueOf(this.eed.size()));
            if (this.eed.isEmpty()) {
                com.tencent.mm.m.a.MA().edit().putString("com.tencent.preference.notification.key.queue", "").apply();
                ab.i("MicroMsg.NotificationAppMsgQueue", "reset size:%d, %s", Integer.valueOf(this.eed.size()), toString());
                AppMethodBeat.o(15973);
            } else {
                try {
                    com.tencent.mm.m.a.MA().edit().putString("com.tencent.preference.notification.key.queue", c.a(new LinkedList(this.eed))).apply();
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
                }
                ab.i("MicroMsg.NotificationAppMsgQueue", "save size:%d, %s", Integer.valueOf(this.eed.size()), toString());
                AppMethodBeat.o(15973);
            }
        }
    }

    public final synchronized void c(NotificationItem notificationItem) {
        Object obj = 1;
        synchronized (this) {
            AppMethodBeat.i(15974);
            if (this.eed == null) {
                restore();
            }
            bJ(notificationItem.id);
            if (!notificationItem.edY || ah.isNullOrNil(notificationItem.edV)) {
                this.eed.add(new a(notificationItem.id, notificationItem.edY));
                ab.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
            } else {
                Iterator it = this.eed.iterator();
                while (it.hasNext()) {
                    Object obj2;
                    a aVar = (a) it.next();
                    if (aVar.userName.equals(notificationItem.edV)) {
                        aVar.a(notificationItem.id, notificationItem.edW, notificationItem.edV, notificationItem.edX, notificationItem.edY, notificationItem.edZ);
                        obj2 = null;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                }
                if (obj != null) {
                    this.eed.add(new a(notificationItem.id, notificationItem.edW, notificationItem.edV, notificationItem.edX, notificationItem.edY, notificationItem.edZ));
                    ab.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                }
            }
            save();
            AppMethodBeat.o(15974);
        }
    }

    public final synchronized List<Integer> io(int i) {
        ArrayList arrayList;
        AppMethodBeat.i(15975);
        if (this.eed == null) {
            restore();
        }
        arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!((aVar.eef & i) == 0 || arrayList.contains(Integer.valueOf(aVar.eee)))) {
                arrayList.add(Integer.valueOf(aVar.eee));
            }
        }
        AppMethodBeat.o(15975);
        return arrayList;
    }

    public final synchronized boolean bJ(int i) {
        boolean z;
        AppMethodBeat.i(15976);
        if (i == -1) {
            AppMethodBeat.o(15976);
            z = false;
        } else {
            if (this.eed == null) {
                restore();
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.eed.iterator();
            Object obj = null;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.eee != i) {
                    linkedList.add(aVar);
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.eed = linkedList;
                save();
                AppMethodBeat.o(15976);
                z = true;
            } else {
                AppMethodBeat.o(15976);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean remove(String str) {
        boolean z;
        AppMethodBeat.i(15977);
        ab.i("MicroMsg.NotificationAppMsgQueue", "remove username: %s", str);
        if (ah.isNullOrNil(str)) {
            AppMethodBeat.o(15977);
            z = false;
        } else {
            if (this.eed == null) {
                restore();
            }
            Iterator it = this.eed.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (str.equals(aVar.userName)) {
                    this.eed.remove(aVar);
                    save();
                    AppMethodBeat.o(15977);
                    z = true;
                    break;
                }
            }
            AppMethodBeat.o(15977);
            z = false;
        }
        return z;
    }

    public final Iterator<a> iterator() {
        AppMethodBeat.i(15978);
        if (this.eed == null) {
            restore();
        }
        Iterator it = this.eed.iterator();
        AppMethodBeat.o(15978);
        return it;
    }
}
