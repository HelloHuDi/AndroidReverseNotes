package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import java.util.List;

final class a {

    interface c {
        void k(List<?> list);
    }

    static class d<T extends c> extends SubscriptionCallback {
        protected final T In;

        public d(T t) {
            this.In = t;
        }

        public void onChildrenLoaded(String str, List<MediaItem> list) {
            this.In.k(list);
        }

        public void onError(String str) {
        }
    }

    static class b<T extends a> extends ConnectionCallback {
        protected final T Im;

        public b(T t) {
            this.Im = t;
        }

        public final void onConnected() {
            this.Im.onConnected();
        }

        public final void onConnectionSuspended() {
            this.Im.onConnectionSuspended();
        }

        public final void onConnectionFailed() {
            this.Im.onConnectionFailed();
        }
    }

    interface a {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }
}
