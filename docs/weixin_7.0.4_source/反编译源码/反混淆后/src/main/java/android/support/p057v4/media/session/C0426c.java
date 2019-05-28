package android.support.p057v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.media.session.c */
final class C0426c {

    /* renamed from: android.support.v4.media.session.c$a */
    public interface C0427a {
        /* renamed from: c */
        void mo933c(int i, int i2, int i3, int i4, int i5);

        /* renamed from: ea */
        void mo934ea();

        /* renamed from: eb */
        void mo935eb();

        /* renamed from: ec */
        void mo936ec();

        void onQueueChanged(List<?> list);

        void onSessionDestroyed();

        /* renamed from: x */
        void mo939x(Object obj);

        /* renamed from: y */
        void mo940y(Object obj);
    }

    /* renamed from: android.support.v4.media.session.c$b */
    static class C0428b<T extends C0427a> extends Callback {
        /* renamed from: JC */
        protected final T f505JC;

        public C0428b(T t) {
            this.f505JC = t;
        }

        public final void onSessionDestroyed() {
            this.f505JC.onSessionDestroyed();
        }

        public final void onSessionEvent(String str, Bundle bundle) {
            this.f505JC.mo934ea();
        }

        public final void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f505JC.mo939x(playbackState);
        }

        public final void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f505JC.mo940y(mediaMetadata);
        }

        public final void onQueueChanged(List<QueueItem> list) {
            this.f505JC.onQueueChanged(list);
        }

        public final void onQueueTitleChanged(CharSequence charSequence) {
            this.f505JC.mo935eb();
        }

        public final void onExtrasChanged(Bundle bundle) {
            this.f505JC.mo936ec();
        }

        public final void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            int i;
            C0427a c0427a = this.f505JC;
            int playbackType = playbackInfo.getPlaybackType();
            AudioAttributes audioAttributes = playbackInfo.getAudioAttributes();
            if ((audioAttributes.getFlags() & 1) != 1) {
                if ((audioAttributes.getFlags() & 4) != 4) {
                    switch (audioAttributes.getUsage()) {
                        case 1:
                        case 11:
                        case 12:
                        case 14:
                            i = 3;
                            break;
                        case 2:
                            i = 0;
                            break;
                        case 3:
                            i = 8;
                            break;
                        case 4:
                            i = 4;
                            break;
                        case 5:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            i = 5;
                            break;
                        case 6:
                            i = 2;
                            break;
                        case 13:
                            i = 1;
                            break;
                        default:
                            i = 3;
                            break;
                    }
                }
                i = 6;
            } else {
                i = 7;
            }
            c0427a.mo933c(playbackType, i, playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}
