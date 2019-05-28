package com.tencent.mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue {
    public ParcelNotificationQueue eeg;

    public static class ParcelNotificationQueue extends LinkedList<NotificationItem> implements Parcelable {
        public static final Creator<ParcelNotificationQueue> CREATOR = new Creator<ParcelNotificationQueue>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ParcelNotificationQueue[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(15979);
                ParcelNotificationQueue parcelNotificationQueue = new ParcelNotificationQueue();
                int readInt = parcel.readInt();
                for (int i = 0; i < readInt; i++) {
                    parcelNotificationQueue.add((NotificationItem) parcel.readParcelable(NotificationItem.class.getClassLoader()));
                }
                AppMethodBeat.o(15979);
                return parcelNotificationQueue;
            }
        };

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(15980);
            parcel.writeInt(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((NotificationItem) it.next(), 0);
            }
            AppMethodBeat.o(15980);
        }

        static {
            AppMethodBeat.i(15981);
            AppMethodBeat.o(15981);
        }
    }

    private void save() {
        AppMethodBeat.i(138161);
        if (this.eeg == null) {
            AppMethodBeat.o(138161);
            return;
        }
        ab.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", Integer.valueOf(this.eeg.size()));
        if (this.eeg.isEmpty()) {
            a.MA().edit().putString("com.tencent.preference.notification.queue", "").apply();
            if (this.eeg == null) {
                restore();
            }
            ab.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", Integer.valueOf(this.eeg.size()));
            AppMethodBeat.o(138161);
            return;
        }
        AppMethodBeat.o(138161);
    }

    public final synchronized void restore() {
        AppMethodBeat.i(15983);
        ab.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
        if (this.eeg == null) {
            this.eeg = new ParcelNotificationQueue();
        }
        ab.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", Integer.valueOf(this.eeg.size()));
        AppMethodBeat.o(15983);
    }

    public final synchronized boolean d(NotificationItem notificationItem) {
        boolean remove;
        AppMethodBeat.i(15984);
        if (this.eeg == null) {
            restore();
        }
        remove = this.eeg.remove(notificationItem);
        if (remove) {
            save();
        }
        AppMethodBeat.o(15984);
        return remove;
    }

    public final synchronized NotificationItem ip(int i) {
        Object obj;
        AppMethodBeat.i(15985);
        if (this.eeg == null) {
            restore();
        }
        Iterator it = this.eeg.iterator();
        while (it.hasNext()) {
            obj = (NotificationItem) it.next();
            if (obj.id == i) {
                break;
            }
        }
        obj = null;
        if (obj != null && this.eeg.remove(obj)) {
            save();
        }
        AppMethodBeat.o(15985);
        return obj;
    }

    public final synchronized boolean e(NotificationItem notificationItem) {
        boolean add;
        AppMethodBeat.i(15986);
        if (this.eeg == null) {
            restore();
        }
        add = this.eeg.add(notificationItem);
        if (add) {
            save();
        }
        AppMethodBeat.o(15986);
        return add;
    }

    public final int size() {
        AppMethodBeat.i(15987);
        if (this.eeg == null) {
            restore();
        }
        int size = this.eeg.size();
        AppMethodBeat.o(15987);
        return size;
    }
}
