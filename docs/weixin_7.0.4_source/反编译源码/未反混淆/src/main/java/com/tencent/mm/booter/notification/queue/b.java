package com.tencent.mm.booter.notification.queue;

import android.support.v4.app.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ugc.TXRecordCommon;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements Iterable<NotificationItem> {
    public NotificationQueue eeh;
    public a eei;
    public int mark;

    static final class a {
        private static final b eej = new b();

        static {
            AppMethodBeat.i(15988);
            AppMethodBeat.o(15988);
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static final b IP() {
        AppMethodBeat.i(15989);
        b IT = a.eej;
        AppMethodBeat.o(15989);
        return IT;
    }

    private b() {
        AppMethodBeat.i(15990);
        this.mark = -1;
        this.eeh = new NotificationQueue();
        this.eei = new a();
        restore();
        AppMethodBeat.o(15990);
    }

    public final void restore() {
        AppMethodBeat.i(15991);
        this.eeh.restore();
        this.eei.restore();
        AppMethodBeat.o(15991);
    }

    public final void iq(int i) {
        AppMethodBeat.i(15992);
        this.eei.bJ(i);
        NotificationItem ip = this.eeh.ip(i);
        if (ip != null) {
            ip.clear();
        }
        AppMethodBeat.o(15992);
    }

    public final NotificationItem IQ() {
        NotificationItem notificationItem;
        AppMethodBeat.i(15993);
        for (int i = 0; i < this.eeh.size(); i++) {
            NotificationQueue notificationQueue = this.eeh;
            if (notificationQueue.eeg == null) {
                notificationQueue.restore();
            }
            notificationItem = (NotificationItem) notificationQueue.eeg.get(i);
            if (notificationItem.edY) {
                if (this.eei.bJ(notificationItem.id)) {
                    ab.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", notificationItem.toString());
                }
                this.eeh.d(notificationItem);
                AppMethodBeat.o(15993);
                return notificationItem;
            }
        }
        notificationItem = null;
        AppMethodBeat.o(15993);
        return notificationItem;
    }

    public final Queue<Integer> IR() {
        AppMethodBeat.i(15994);
        LinkedList linkedList = new LinkedList();
        for (int i = 4097; i < 4102; i++) {
            linkedList.add(Integer.valueOf(i));
        }
        linkedList.addAll(IS());
        AppMethodBeat.o(15994);
        return linkedList;
    }

    private Queue<Integer> IS() {
        AppMethodBeat.i(15995);
        LinkedList linkedList = new LinkedList();
        LinkedList<NotificationItem> linkedList2 = new LinkedList();
        NotificationQueue notificationQueue = this.eeh;
        if (notificationQueue.eeg == null) {
            notificationQueue.restore();
        }
        linkedList2.addAll(notificationQueue.eeg);
        for (NotificationItem notificationItem : linkedList2) {
            if (notificationItem.edY) {
                linkedList.add(Integer.valueOf(notificationItem.id));
                ab.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(notificationItem.id));
            }
        }
        linkedList2.clear();
        LinkedList<com.tencent.mm.booter.notification.queue.a.a> linkedList3 = new LinkedList();
        a aVar = this.eei;
        if (aVar.eed == null) {
            aVar.restore();
        }
        linkedList3.addAll(aVar.eed);
        for (com.tencent.mm.booter.notification.queue.a.a aVar2 : linkedList3) {
            if (aVar2.edY) {
                linkedList.add(Integer.valueOf(aVar2.eee));
                ab.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(aVar2.eee));
            }
        }
        linkedList3.clear();
        AppMethodBeat.o(15995);
        return linkedList;
    }

    public final int getId(String str) {
        AppMethodBeat.i(15996);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(15996);
            return -1;
        }
        Iterator it = this.eei.iterator();
        while (it.hasNext()) {
            com.tencent.mm.booter.notification.queue.a.a aVar = (com.tencent.mm.booter.notification.queue.a.a) it.next();
            if (aVar.userName.equals(str)) {
                int i = aVar.eee;
                AppMethodBeat.o(15996);
                return i;
            }
        }
        AppMethodBeat.o(15996);
        return -1;
    }

    public final void a(y yVar, int i) {
        AppMethodBeat.i(15998);
        yVar.cancel(i);
        iq(i);
        AppMethodBeat.o(15998);
    }

    public final int jP(String str) {
        AppMethodBeat.i(15999);
        int id = getId(str);
        if (id > 0) {
            AppMethodBeat.o(15999);
            return id;
        }
        id = n(str, true);
        AppMethodBeat.o(15999);
        return id;
    }

    public final int n(String str, boolean z) {
        String str2;
        AppMethodBeat.i(TXRecordCommon.AUDIO_SAMPLERATE_16000);
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = "";
        Iterator it = this.eei.iterator();
        while (true) {
            str2 = str3;
            if (!it.hasNext()) {
                break;
            }
            str3 = str2 + ((com.tencent.mm.booter.notification.queue.a.a) it.next()).eee + ",";
        }
        int i = z ? 4097 : 4102;
        while (str2.contains(String.valueOf(i))) {
            i++;
        }
        if (i >= 4102 && z) {
            i = 4097;
        }
        if (!bo.isNullOrNil(str) && z) {
            i = str.hashCode();
        }
        ab.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z));
        AppMethodBeat.o(TXRecordCommon.AUDIO_SAMPLERATE_16000);
        return i;
    }

    public final Iterator<NotificationItem> iterator() {
        AppMethodBeat.i(16001);
        NotificationQueue notificationQueue = this.eeh;
        if (notificationQueue.eeg == null) {
            notificationQueue.restore();
        }
        Iterator it = notificationQueue.eeg.iterator();
        AppMethodBeat.o(16001);
        return it;
    }

    public final void cancel(int i) {
        AppMethodBeat.i(15997);
        a(y.L(ah.getContext()), i);
        AppMethodBeat.o(15997);
    }
}
