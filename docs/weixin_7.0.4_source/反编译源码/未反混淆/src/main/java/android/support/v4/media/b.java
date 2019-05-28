package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import java.util.List;

final class b {

    interface a extends c {
        void l(List<?> list);
    }

    static class b<T extends a> extends d<T> {
        b(T t) {
            super(t);
        }

        public final void onChildrenLoaded(String str, List<MediaItem> list, Bundle bundle) {
            ((a) this.In).l(list);
        }

        public final void onError(String str, Bundle bundle) {
        }
    }
}
