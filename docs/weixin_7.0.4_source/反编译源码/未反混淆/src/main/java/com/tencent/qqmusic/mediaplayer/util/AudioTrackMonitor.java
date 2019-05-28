package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class AudioTrackMonitor {
    private static final boolean ENABLE = false;
    private static final String TAG = "AudioTrackMonitor";
    private WeakReference<AudioTrack> mAudioTrackRef = null;
    private StringBuilder mBuilder = new StringBuilder(100);
    private long mLastPosition = 0;
    private long mLastTime = System.nanoTime();
    private int mLooperTime = 200;
    private Thread mMonitorThread = new Thread("Monitor-AudioTrack") {
        public void run() {
            AppMethodBeat.i(128390);
            super.run();
            while (!AudioTrackMonitor.this.mStop) {
                try {
                    Thread.currentThread();
                    Thread.sleep((long) AudioTrackMonitor.this.mLooperTime);
                } catch (Throwable th) {
                    Logger.e(AudioTrackMonitor.TAG, th);
                }
                try {
                    if (AudioTrackMonitor.this.mAudioTrackRef == null || AudioTrackMonitor.this.mAudioTrackRef.get() == null) {
                        AppMethodBeat.o(128390);
                        return;
                    }
                    AudioTrack audioTrack = (AudioTrack) AudioTrackMonitor.this.mAudioTrackRef.get();
                    if (audioTrack != null) {
                        int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                        long access$300 = ((long) playbackHeadPosition) - AudioTrackMonitor.this.mLastPosition;
                        AudioTrackMonitor.this.mLastPosition = (long) playbackHeadPosition;
                        long nanoTime = System.nanoTime() - AudioTrackMonitor.this.mLastTime;
                        AudioTrackMonitor.this.mLastTime = System.nanoTime();
                        AudioTrackMonitor.this.mBuilder.append("play-speedTime-").append(nanoTime).append(",play-speedPosition-").append(access$300);
                        AudioTrackMonitor.this.mBuilder.append(",playstate-").append(audioTrack.getPlayState());
                        Logger.e(AudioTrackMonitor.TAG, AudioTrackMonitor.this.mBuilder.toString());
                        AudioTrackMonitor.this.mBuilder.delete(0, AudioTrackMonitor.this.mBuilder.length());
                    }
                } catch (Throwable th2) {
                    Logger.e(AudioTrackMonitor.TAG, th2);
                }
            }
            AppMethodBeat.o(128390);
        }
    };
    private boolean mStop = false;

    public AudioTrackMonitor(AudioTrack audioTrack) {
        AppMethodBeat.i(128387);
        this.mAudioTrackRef = new WeakReference(audioTrack);
        AppMethodBeat.o(128387);
    }

    public void start() {
    }

    public void stop() {
    }
}
