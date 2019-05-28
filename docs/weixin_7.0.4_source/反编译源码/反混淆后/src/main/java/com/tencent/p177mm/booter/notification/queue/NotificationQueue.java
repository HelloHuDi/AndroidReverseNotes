package com.tencent.p177mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.notification.NotificationItem;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.booter.notification.queue.NotificationQueue */
public final class NotificationQueue {
    public ParcelNotificationQueue eeg;

    /* renamed from: com.tencent.mm.booter.notification.queue.NotificationQueue$ParcelNotificationQueue */
    public static class ParcelNotificationQueue extends LinkedList<NotificationItem> implements Parcelable {
        public static final Creator<ParcelNotificationQueue> CREATOR = new C13281();

        /* renamed from: com.tencent.mm.booter.notification.queue.NotificationQueue$ParcelNotificationQueue$1 */
        static class C13281 implements Creator<ParcelNotificationQueue> {
            C13281() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ParcelNotificationQueue[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(15979);
                ParcelNotificationQueue parcelNotificationQueue = new ParcelNotificationQueue();
                int readInt = parcel.readInt();
                for (int i = 0; i < readInt; i++) {
                    parcelNotificationQueue.add((NotificationItem) parcel.readParcelable(NotificationItem.class.getClassLoader()));
                }
                AppMethodBeat.m2505o(15979);
                return parcelNotificationQueue;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(15980);
            parcel.writeInt(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((NotificationItem) it.next(), 0);
            }
            AppMethodBeat.m2505o(15980);
        }

        static {
            AppMethodBeat.m2504i(15981);
            AppMethodBeat.m2505o(15981);
        }
    }

    private void save() {
        AppMethodBeat.m2504i(138161);
        if (this.eeg == null) {
            AppMethodBeat.m2505o(138161);
            return;
        }
        C4990ab.m7411d("MicroMsg.NotificationCustomQueue", "jacks save: %d", Integer.valueOf(this.eeg.size()));
        if (this.eeg.isEmpty()) {
            C37885a.m63948MA().edit().putString("com.tencent.preference.notification.queue", "").apply();
            if (this.eeg == null) {
                restore();
            }
            C4990ab.m7411d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", Integer.valueOf(this.eeg.size()));
            AppMethodBeat.m2505o(138161);
            return;
        }
        AppMethodBeat.m2505o(138161);
    }

    public final synchronized void restore() {
        AppMethodBeat.m2504i(15983);
        C4990ab.m7410d("MicroMsg.NotificationCustomQueue", "jacks _restore");
        if (this.eeg == null) {
            this.eeg = new ParcelNotificationQueue();
        }
        C4990ab.m7411d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", Integer.valueOf(this.eeg.size()));
        AppMethodBeat.m2505o(15983);
    }

    /* renamed from: d */
    public final synchronized boolean mo20601d(NotificationItem notificationItem) {
        boolean remove;
        AppMethodBeat.m2504i(15984);
        if (this.eeg == null) {
            restore();
        }
        remove = this.eeg.remove(notificationItem);
        if (remove) {
            save();
        }
        AppMethodBeat.m2505o(15984);
        return remove;
    }

    /* renamed from: ip */
    public final synchronized NotificationItem mo20603ip(int i) {
        Object obj;
        AppMethodBeat.m2504i(15985);
        if (this.eeg == null) {
            restore();
        }
        Iterator it = this.eeg.iterator();
        while (it.hasNext()) {
            obj = (NotificationItem) it.next();
            if (obj.f1225id == i) {
                break;
            }
        }
        obj = null;
        if (obj != null && this.eeg.remove(obj)) {
            save();
        }
        AppMethodBeat.m2505o(15985);
        return obj;
    }

    /* renamed from: e */
    public final synchronized boolean mo20602e(NotificationItem notificationItem) {
        boolean add;
        AppMethodBeat.m2504i(15986);
        if (this.eeg == null) {
            restore();
        }
        add = this.eeg.add(notificationItem);
        if (add) {
            save();
        }
        AppMethodBeat.m2505o(15986);
        return add;
    }

    public final int size() {
        AppMethodBeat.m2504i(15987);
        if (this.eeg == null) {
            restore();
        }
        int size = this.eeg.size();
        AppMethodBeat.m2505o(15987);
        return size;
    }
}
