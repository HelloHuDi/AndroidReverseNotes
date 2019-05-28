package com.tencent.p177mm.booter.notification.queue;

import android.support.p057v4.app.C17432y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.notification.NotificationItem;
import com.tencent.p177mm.booter.notification.queue.C18106a.C18107a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ugc.TXRecordCommon;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.booter.notification.queue.b */
public final class C9203b implements Iterable<NotificationItem> {
    public NotificationQueue eeh;
    public C18106a eei;
    public int mark;

    /* renamed from: com.tencent.mm.booter.notification.queue.b$a */
    static final class C9202a {
        private static final C9203b eej = new C9203b();

        static {
            AppMethodBeat.m2504i(15988);
            AppMethodBeat.m2505o(15988);
        }
    }

    /* synthetic */ C9203b(byte b) {
        this();
    }

    /* renamed from: IP */
    public static final C9203b m16707IP() {
        AppMethodBeat.m2504i(15989);
        C9203b IT = C9202a.eej;
        AppMethodBeat.m2505o(15989);
        return IT;
    }

    private C9203b() {
        AppMethodBeat.m2504i(15990);
        this.mark = -1;
        this.eeh = new NotificationQueue();
        this.eei = new C18106a();
        restore();
        AppMethodBeat.m2505o(15990);
    }

    public final void restore() {
        AppMethodBeat.m2504i(15991);
        this.eeh.restore();
        this.eei.restore();
        AppMethodBeat.m2505o(15991);
    }

    /* renamed from: iq */
    public final void mo20613iq(int i) {
        AppMethodBeat.m2504i(15992);
        this.eei.mo33542bJ(i);
        NotificationItem ip = this.eeh.mo20603ip(i);
        if (ip != null) {
            ip.clear();
        }
        AppMethodBeat.m2505o(15992);
    }

    /* renamed from: IQ */
    public final NotificationItem mo20608IQ() {
        NotificationItem notificationItem;
        AppMethodBeat.m2504i(15993);
        for (int i = 0; i < this.eeh.size(); i++) {
            NotificationQueue notificationQueue = this.eeh;
            if (notificationQueue.eeg == null) {
                notificationQueue.restore();
            }
            notificationItem = (NotificationItem) notificationQueue.eeg.get(i);
            if (notificationItem.edY) {
                if (this.eei.mo33542bJ(notificationItem.f1225id)) {
                    C4990ab.m7411d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", notificationItem.toString());
                }
                this.eeh.mo20601d(notificationItem);
                AppMethodBeat.m2505o(15993);
                return notificationItem;
            }
        }
        notificationItem = null;
        AppMethodBeat.m2505o(15993);
        return notificationItem;
    }

    /* renamed from: IR */
    public final Queue<Integer> mo20609IR() {
        AppMethodBeat.m2504i(15994);
        LinkedList linkedList = new LinkedList();
        for (int i = 4097; i < 4102; i++) {
            linkedList.add(Integer.valueOf(i));
        }
        linkedList.addAll(m16708IS());
        AppMethodBeat.m2505o(15994);
        return linkedList;
    }

    /* renamed from: IS */
    private Queue<Integer> m16708IS() {
        AppMethodBeat.m2504i(15995);
        LinkedList linkedList = new LinkedList();
        LinkedList<NotificationItem> linkedList2 = new LinkedList();
        NotificationQueue notificationQueue = this.eeh;
        if (notificationQueue.eeg == null) {
            notificationQueue.restore();
        }
        linkedList2.addAll(notificationQueue.eeg);
        for (NotificationItem notificationItem : linkedList2) {
            if (notificationItem.edY) {
                linkedList.add(Integer.valueOf(notificationItem.f1225id));
                C4990ab.m7411d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(notificationItem.f1225id));
            }
        }
        linkedList2.clear();
        LinkedList<C18107a> linkedList3 = new LinkedList();
        C18106a c18106a = this.eei;
        if (c18106a.eed == null) {
            c18106a.restore();
        }
        linkedList3.addAll(c18106a.eed);
        for (C18107a c18107a : linkedList3) {
            if (c18107a.edY) {
                linkedList.add(Integer.valueOf(c18107a.eee));
                C4990ab.m7411d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(c18107a.eee));
            }
        }
        linkedList3.clear();
        AppMethodBeat.m2505o(15995);
        return linkedList;
    }

    public final int getId(String str) {
        AppMethodBeat.m2504i(15996);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(15996);
            return -1;
        }
        Iterator it = this.eei.iterator();
        while (it.hasNext()) {
            C18107a c18107a = (C18107a) it.next();
            if (c18107a.userName.equals(str)) {
                int i = c18107a.eee;
                AppMethodBeat.m2505o(15996);
                return i;
            }
        }
        AppMethodBeat.m2505o(15996);
        return -1;
    }

    /* renamed from: a */
    public final void mo20610a(C17432y c17432y, int i) {
        AppMethodBeat.m2504i(15998);
        c17432y.cancel(i);
        mo20613iq(i);
        AppMethodBeat.m2505o(15998);
    }

    /* renamed from: jP */
    public final int mo20615jP(String str) {
        AppMethodBeat.m2504i(15999);
        int id = getId(str);
        if (id > 0) {
            AppMethodBeat.m2505o(15999);
            return id;
        }
        id = mo20616n(str, true);
        AppMethodBeat.m2505o(15999);
        return id;
    }

    /* renamed from: n */
    public final int mo20616n(String str, boolean z) {
        String str2;
        AppMethodBeat.m2504i(TXRecordCommon.AUDIO_SAMPLERATE_16000);
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = "";
        Iterator it = this.eei.iterator();
        while (true) {
            str2 = str3;
            if (!it.hasNext()) {
                break;
            }
            str3 = str2 + ((C18107a) it.next()).eee + ",";
        }
        int i = z ? 4097 : 4102;
        while (str2.contains(String.valueOf(i))) {
            i++;
        }
        if (i >= 4102 && z) {
            i = 4097;
        }
        if (!C5046bo.isNullOrNil(str) && z) {
            i = str.hashCode();
        }
        C4990ab.m7411d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z));
        AppMethodBeat.m2505o(TXRecordCommon.AUDIO_SAMPLERATE_16000);
        return i;
    }

    public final Iterator<NotificationItem> iterator() {
        AppMethodBeat.m2504i(16001);
        NotificationQueue notificationQueue = this.eeh;
        if (notificationQueue.eeg == null) {
            notificationQueue.restore();
        }
        Iterator it = notificationQueue.eeg.iterator();
        AppMethodBeat.m2505o(16001);
        return it;
    }

    public final void cancel(int i) {
        AppMethodBeat.m2504i(15997);
        mo20610a(C17432y.m27074L(C4996ah.getContext()), i);
        AppMethodBeat.m2505o(15997);
    }
}
