package com.tencent.p177mm.booter.notification.queue;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.notification.NotificationItem;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.booter.notification.queue.a */
public final class C18106a implements Serializable, Iterable<C18107a> {
    LinkedList<C18107a> eed;

    /* renamed from: com.tencent.mm.booter.notification.queue.a$a */
    public static class C18107a implements Serializable {
        public long cvx = -1;
        public int edE;
        public boolean edY = false;
        public int eee;
        public int eef = 0;
        public String userName = "";

        public C18107a(int i, long j, String str, int i2, boolean z, int i3) {
            AppMethodBeat.m2504i(15969);
            mo33549a(i, j, str, i2, z, i3);
            AppMethodBeat.m2505o(15969);
        }

        public C18107a(int i, boolean z) {
            this.eee = i;
            this.edY = z;
        }

        public final String toString() {
            AppMethodBeat.m2504i(15970);
            String str = this.userName + " id:" + this.cvx + " unReadCount:" + this.edE + "　notificationId:" + this.eee;
            AppMethodBeat.m2505o(15970);
            return str;
        }

        /* renamed from: a */
        public final void mo33549a(int i, long j, String str, int i2, boolean z, int i3) {
            this.eee = i;
            this.cvx = j;
            this.userName = str;
            this.edE = i2;
            this.edY = z;
            this.eef = i3;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(15971);
        String str = "";
        Iterator it = this.eed.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + ((C18107a) it.next()).toString() + ";  ";
            } else {
                AppMethodBeat.m2505o(15971);
                return str2;
            }
        }
    }

    public final synchronized void restore() {
        AppMethodBeat.m2504i(15972);
        try {
            this.eed = (LinkedList) C25980c.m41444jQ(C37885a.m63948MA().getString("com.tencent.preference.notification.key.queue", ""));
            if (this.eed == null) {
                this.eed = new LinkedList();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
            if (this.eed == null) {
                this.eed = new LinkedList();
            }
        } catch (Throwable th) {
            if (this.eed == null) {
                this.eed = new LinkedList();
            }
            AppMethodBeat.m2505o(15972);
        }
        C4990ab.m7417i("MicroMsg.NotificationAppMsgQueue", "restore size:%d, %s", Integer.valueOf(this.eed.size()), toString());
        AppMethodBeat.m2505o(15972);
    }

    private synchronized void save() {
        AppMethodBeat.m2504i(15973);
        if (this.eed == null) {
            AppMethodBeat.m2505o(15973);
        } else {
            C4990ab.m7411d("MicroMsg.NotificationAppMsgQueue", "save: size: %d", Integer.valueOf(this.eed.size()));
            if (this.eed.isEmpty()) {
                C37885a.m63948MA().edit().putString("com.tencent.preference.notification.key.queue", "").apply();
                C4990ab.m7417i("MicroMsg.NotificationAppMsgQueue", "reset size:%d, %s", Integer.valueOf(this.eed.size()), toString());
                AppMethodBeat.m2505o(15973);
            } else {
                try {
                    C37885a.m63948MA().edit().putString("com.tencent.preference.notification.key.queue", C25980c.m41443a(new LinkedList(this.eed))).apply();
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
                }
                C4990ab.m7417i("MicroMsg.NotificationAppMsgQueue", "save size:%d, %s", Integer.valueOf(this.eed.size()), toString());
                AppMethodBeat.m2505o(15973);
            }
        }
    }

    /* renamed from: c */
    public final synchronized void mo33543c(NotificationItem notificationItem) {
        Object obj = 1;
        synchronized (this) {
            AppMethodBeat.m2504i(15974);
            if (this.eed == null) {
                restore();
            }
            mo33542bJ(notificationItem.f1225id);
            if (!notificationItem.edY || C42252ah.isNullOrNil(notificationItem.edV)) {
                this.eed.add(new C18107a(notificationItem.f1225id, notificationItem.edY));
                C4990ab.m7411d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
            } else {
                Iterator it = this.eed.iterator();
                while (it.hasNext()) {
                    Object obj2;
                    C18107a c18107a = (C18107a) it.next();
                    if (c18107a.userName.equals(notificationItem.edV)) {
                        c18107a.mo33549a(notificationItem.f1225id, notificationItem.edW, notificationItem.edV, notificationItem.edX, notificationItem.edY, notificationItem.edZ);
                        obj2 = null;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                }
                if (obj != null) {
                    this.eed.add(new C18107a(notificationItem.f1225id, notificationItem.edW, notificationItem.edV, notificationItem.edX, notificationItem.edY, notificationItem.edZ));
                    C4990ab.m7411d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                }
            }
            save();
            AppMethodBeat.m2505o(15974);
        }
    }

    /* renamed from: io */
    public final synchronized List<Integer> mo33544io(int i) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(15975);
        if (this.eed == null) {
            restore();
        }
        arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            C18107a c18107a = (C18107a) it.next();
            if (!((c18107a.eef & i) == 0 || arrayList.contains(Integer.valueOf(c18107a.eee)))) {
                arrayList.add(Integer.valueOf(c18107a.eee));
            }
        }
        AppMethodBeat.m2505o(15975);
        return arrayList;
    }

    /* renamed from: bJ */
    public final synchronized boolean mo33542bJ(int i) {
        boolean z;
        AppMethodBeat.m2504i(15976);
        if (i == -1) {
            AppMethodBeat.m2505o(15976);
            z = false;
        } else {
            if (this.eed == null) {
                restore();
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.eed.iterator();
            Object obj = null;
            while (it.hasNext()) {
                C18107a c18107a = (C18107a) it.next();
                if (c18107a.eee != i) {
                    linkedList.add(c18107a);
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.eed = linkedList;
                save();
                AppMethodBeat.m2505o(15976);
                z = true;
            } else {
                AppMethodBeat.m2505o(15976);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean remove(String str) {
        boolean z;
        AppMethodBeat.m2504i(15977);
        C4990ab.m7417i("MicroMsg.NotificationAppMsgQueue", "remove username: %s", str);
        if (C42252ah.isNullOrNil(str)) {
            AppMethodBeat.m2505o(15977);
            z = false;
        } else {
            if (this.eed == null) {
                restore();
            }
            Iterator it = this.eed.iterator();
            while (it.hasNext()) {
                C18107a c18107a = (C18107a) it.next();
                if (str.equals(c18107a.userName)) {
                    this.eed.remove(c18107a);
                    save();
                    AppMethodBeat.m2505o(15977);
                    z = true;
                    break;
                }
            }
            AppMethodBeat.m2505o(15977);
            z = false;
        }
        return z;
    }

    public final Iterator<C18107a> iterator() {
        AppMethodBeat.m2504i(15978);
        if (this.eed == null) {
            restore();
        }
        Iterator it = this.eed.iterator();
        AppMethodBeat.m2505o(15978);
        return it;
    }
}
