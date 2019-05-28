package android.support.p057v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import java.util.List;

/* renamed from: android.support.v4.media.a */
final class C25355a {

    /* renamed from: android.support.v4.media.a$c */
    interface C8397c {
        /* renamed from: k */
        void mo18348k(List<?> list);
    }

    /* renamed from: android.support.v4.media.a$d */
    static class C25354d<T extends C8397c> extends SubscriptionCallback {
        /* renamed from: In */
        protected final T f5180In;

        public C25354d(T t) {
            this.f5180In = t;
        }

        public void onChildrenLoaded(String str, List<MediaItem> list) {
            this.f5180In.mo18348k(list);
        }

        public void onError(String str) {
        }
    }

    /* renamed from: android.support.v4.media.a$b */
    static class C25356b<T extends C25357a> extends ConnectionCallback {
        /* renamed from: Im */
        protected final T f5181Im;

        public C25356b(T t) {
            this.f5181Im = t;
        }

        public final void onConnected() {
            this.f5181Im.onConnected();
        }

        public final void onConnectionSuspended() {
            this.f5181Im.onConnectionSuspended();
        }

        public final void onConnectionFailed() {
            this.f5181Im.onConnectionFailed();
        }
    }

    /* renamed from: android.support.v4.media.a$a */
    interface C25357a {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }
}
