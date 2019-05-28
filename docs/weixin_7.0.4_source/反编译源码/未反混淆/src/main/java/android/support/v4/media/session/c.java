package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

final class c {

    public interface a {
        void c(int i, int i2, int i3, int i4, int i5);

        void ea();

        void eb();

        void ec();

        void onQueueChanged(List<?> list);

        void onSessionDestroyed();

        void x(Object obj);

        void y(Object obj);
    }

    static class b<T extends a> extends Callback {
        protected final T JC;

        public b(T t) {
            this.JC = t;
        }

        public final void onSessionDestroyed() {
            this.JC.onSessionDestroyed();
        }

        public final void onSessionEvent(String str, Bundle bundle) {
            this.JC.ea();
        }

        public final void onPlaybackStateChanged(PlaybackState playbackState) {
            this.JC.x(playbackState);
        }

        public final void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.JC.y(mediaMetadata);
        }

        public final void onQueueChanged(List<QueueItem> list) {
            this.JC.onQueueChanged(list);
        }

        public final void onQueueTitleChanged(CharSequence charSequence) {
            this.JC.eb();
        }

        public final void onExtrasChanged(Bundle bundle) {
            this.JC.ec();
        }

        public final void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            int i;
            a aVar = this.JC;
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
            aVar.c(playbackType, i, playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}
