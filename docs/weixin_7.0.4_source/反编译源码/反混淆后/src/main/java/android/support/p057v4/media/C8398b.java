package android.support.p057v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.support.p057v4.media.C25355a.C25354d;
import android.support.p057v4.media.C25355a.C8397c;
import java.util.List;

/* renamed from: android.support.v4.media.b */
final class C8398b {

    /* renamed from: android.support.v4.media.b$a */
    interface C0420a extends C8397c {
        /* renamed from: l */
        void mo861l(List<?> list);
    }

    /* renamed from: android.support.v4.media.b$b */
    static class C8399b<T extends C0420a> extends C25354d<T> {
        C8399b(T t) {
            super(t);
        }

        public final void onChildrenLoaded(String str, List<MediaItem> list, Bundle bundle) {
            ((C0420a) this.f5180In).mo861l(list);
        }

        public final void onError(String str, Bundle bundle) {
        }
    }
}
