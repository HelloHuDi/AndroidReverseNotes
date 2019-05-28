package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;

public class PlayerUtil {
    private static AudioManager sManager;

    /* renamed from: com.tencent.ttpic.util.PlayerUtil$5 */
    static class C163665 implements OnErrorListener {
        C163665() {
        }

        public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
            AppMethodBeat.m2504i(50275);
            PlayerUtil.destroyRecorder((Recorder) mediaRecorder);
            AppMethodBeat.m2505o(50275);
        }
    }

    public static class Player extends MediaPlayer {
        private boolean isPlaying;

        public boolean isPlaying() {
            return this.isPlaying;
        }

        public void start() {
            AppMethodBeat.m2504i(50276);
            if (this.isPlaying) {
                AppMethodBeat.m2505o(50276);
                return;
            }
            try {
                super.start();
                this.isPlaying = true;
                AppMethodBeat.m2505o(50276);
            } catch (Exception e) {
                AppMethodBeat.m2505o(50276);
            }
        }

        public void pause() {
            AppMethodBeat.m2504i(50277);
            if (this.isPlaying) {
                try {
                    super.pause();
                    this.isPlaying = false;
                    AppMethodBeat.m2505o(50277);
                    return;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(50277);
                    return;
                }
            }
            AppMethodBeat.m2505o(50277);
        }

        public void stop() {
            AppMethodBeat.m2504i(50278);
            try {
                super.stop();
                this.isPlaying = false;
                AppMethodBeat.m2505o(50278);
            } catch (Exception e) {
                AppMethodBeat.m2505o(50278);
            }
        }

        public void reset() {
            AppMethodBeat.m2504i(50279);
            try {
                super.reset();
                this.isPlaying = false;
                AppMethodBeat.m2505o(50279);
            } catch (Exception e) {
                AppMethodBeat.m2505o(50279);
            }
        }

        public void release() {
            AppMethodBeat.m2504i(50280);
            try {
                super.release();
                this.isPlaying = false;
                AppMethodBeat.m2505o(50280);
            } catch (Exception e) {
                AppMethodBeat.m2505o(50280);
            }
        }
    }

    /* renamed from: com.tencent.ttpic.util.PlayerUtil$3 */
    static class C244973 implements OnSeekCompleteListener {
        C244973() {
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(50273);
            ((Player) mediaPlayer).start();
            AppMethodBeat.m2505o(50273);
        }
    }

    /* renamed from: com.tencent.ttpic.util.PlayerUtil$4 */
    static class C311234 implements OnSeekCompleteListener {
        C311234() {
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(50274);
            ((Player) mediaPlayer).start();
            AppMethodBeat.m2505o(50274);
        }
    }

    public static class Recorder extends MediaRecorder {
        private boolean isRecording;

        public void start() {
            AppMethodBeat.m2504i(50281);
            if (this.isRecording) {
                AppMethodBeat.m2505o(50281);
                return;
            }
            try {
                super.start();
                this.isRecording = true;
                AppMethodBeat.m2505o(50281);
            } catch (Exception e) {
                AppMethodBeat.m2505o(50281);
            }
        }

        public void stop() {
            AppMethodBeat.m2504i(50282);
            if (this.isRecording) {
                try {
                    super.stop();
                    this.isRecording = false;
                    AppMethodBeat.m2505o(50282);
                    return;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(50282);
                    return;
                }
            }
            AppMethodBeat.m2505o(50282);
        }

        public void reset() {
            AppMethodBeat.m2504i(50283);
            if (this.isRecording) {
                try {
                    super.reset();
                    this.isRecording = false;
                    AppMethodBeat.m2505o(50283);
                    return;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(50283);
                    return;
                }
            }
            AppMethodBeat.m2505o(50283);
        }

        public void release() {
            AppMethodBeat.m2504i(50284);
            try {
                super.release();
                this.isRecording = false;
                AppMethodBeat.m2505o(50284);
            } catch (Exception e) {
                AppMethodBeat.m2505o(50284);
            }
        }

        public boolean isRecording() {
            return this.isRecording;
        }
    }

    /* renamed from: com.tencent.ttpic.util.PlayerUtil$1 */
    static class C365651 implements OnCompletionListener {
        C365651() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(50271);
            ((Player) mediaPlayer).isPlaying = false;
            AppMethodBeat.m2505o(50271);
        }
    }

    /* renamed from: com.tencent.ttpic.util.PlayerUtil$2 */
    static class C365662 implements MediaPlayer.OnErrorListener {
        C365662() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(50272);
            PlayerUtil.destroyPlayer((Player) mediaPlayer);
            AppMethodBeat.m2505o(50272);
            return true;
        }
    }

    public static Player createPlayer(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(50285);
        Player createPlayerFromAssets;
        if (str.startsWith("assets://")) {
            createPlayerFromAssets = createPlayerFromAssets(context, FileUtils.getRealPath(str), z);
            AppMethodBeat.m2505o(50285);
            return createPlayerFromAssets;
        }
        createPlayerFromAssets = createPlayerFromUri(context, str, z);
        AppMethodBeat.m2505o(50285);
        return createPlayerFromAssets;
    }

    public static Player createPlayerFromUri(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(50286);
        Player player;
        try {
            player = new Player();
            try {
                player.setDataSource(context, Uri.parse(str));
                preparePlayer(player, z);
                AppMethodBeat.m2505o(50286);
                return player;
            } catch (IOException e) {
                destroyPlayer(player);
                AppMethodBeat.m2505o(50286);
                return null;
            }
        } catch (IOException e2) {
            player = null;
            destroyPlayer(player);
            AppMethodBeat.m2505o(50286);
            return null;
        }
    }

    public static Player createPlayerFromAssets(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(50287);
        Player player;
        try {
            player = new Player();
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(str);
                player.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                preparePlayer(player, z);
                AppMethodBeat.m2505o(50287);
                return player;
            } catch (IOException e) {
                destroyPlayer(player);
                AppMethodBeat.m2505o(50287);
                return null;
            }
        } catch (IOException e2) {
            player = null;
            destroyPlayer(player);
            AppMethodBeat.m2505o(50287);
            return null;
        }
    }

    private static void preparePlayer(Player player, boolean z) {
        AppMethodBeat.m2504i(50288);
        player.setAudioStreamType(3);
        player.setLooping(z);
        player.setOnCompletionListener(new C365651());
        player.setOnErrorListener(new C365662());
        player.prepare();
        AppMethodBeat.m2505o(50288);
    }

    public static void startPlayer(Player player, boolean z) {
        AppMethodBeat.m2504i(50289);
        if (player != null) {
            if (z) {
                player.setOnSeekCompleteListener(new C244973());
                player.seekTo(0);
                AppMethodBeat.m2505o(50289);
                return;
            }
            player.start();
        }
        AppMethodBeat.m2505o(50289);
    }

    public static void seekPlayer(Player player, int i) {
        AppMethodBeat.m2504i(50290);
        if (player != null) {
            player.setOnSeekCompleteListener(new C311234());
            player.seekTo(i);
        }
        AppMethodBeat.m2505o(50290);
    }

    public static void stopPlayer(Player player) {
        AppMethodBeat.m2504i(50291);
        if (player != null) {
            player.pause();
        }
        AppMethodBeat.m2505o(50291);
    }

    public static void destroyPlayer(Player player) {
        AppMethodBeat.m2504i(50292);
        if (player != null) {
            player.stop();
            player.reset();
            player.release();
        }
        AppMethodBeat.m2505o(50292);
    }

    public static void setMute(Context context, boolean z) {
        AppMethodBeat.m2504i(50293);
        getAudioManager(context).setStreamMute(3, z);
        AppMethodBeat.m2505o(50293);
    }

    public static Recorder createRecorder(String str) {
        Recorder recorder;
        AppMethodBeat.m2504i(50294);
        try {
            recorder = new Recorder();
            try {
                recorder.setOutputFile(str);
                recorder.setAudioSource(1);
                recorder.setAudioChannels(1);
                recorder.setAudioSamplingRate(TXRecordCommon.AUDIO_SAMPLERATE_44100);
                recorder.setAudioEncodingBitRate(96000);
                recorder.setOutputFormat(2);
                recorder.setAudioEncoder(3);
                recorder.setOnErrorListener(new C163665());
                recorder.prepare();
            } catch (Exception e) {
                destroyRecorder(recorder);
                recorder = null;
                AppMethodBeat.m2505o(50294);
                return recorder;
            }
        } catch (Exception e2) {
            recorder = null;
            destroyRecorder(recorder);
            recorder = null;
            AppMethodBeat.m2505o(50294);
            return recorder;
        }
        AppMethodBeat.m2505o(50294);
        return recorder;
    }

    private boolean isSupportedAudioSamplingRate(int i) {
        AppMethodBeat.m2504i(50295);
        if (AudioRecord.getMinBufferSize(i, 16, 2) > 0) {
            AppMethodBeat.m2505o(50295);
            return true;
        }
        AppMethodBeat.m2505o(50295);
        return false;
    }

    public static void startRecorder(Recorder recorder) {
        AppMethodBeat.m2504i(50296);
        if (recorder != null) {
            recorder.start();
        }
        AppMethodBeat.m2505o(50296);
    }

    public static void destroyRecorder(Recorder recorder) {
        AppMethodBeat.m2504i(50297);
        if (recorder != null) {
            recorder.stop();
            recorder.reset();
            recorder.release();
        }
        AppMethodBeat.m2505o(50297);
    }

    public static void setVolume(Context context, int i) {
        AppMethodBeat.m2504i(50298);
        getAudioManager(context).setStreamVolume(3, Math.min(Math.max(i, 0), getMaxVolume(context)), 8);
        AppMethodBeat.m2505o(50298);
    }

    public static int getVolume(Context context) {
        AppMethodBeat.m2504i(50299);
        int streamVolume = getAudioManager(context).getStreamVolume(3);
        AppMethodBeat.m2505o(50299);
        return streamVolume;
    }

    public static int getMaxVolume(Context context) {
        AppMethodBeat.m2504i(50300);
        int streamMaxVolume = getAudioManager(context).getStreamMaxVolume(3);
        AppMethodBeat.m2505o(50300);
        return streamMaxVolume;
    }

    public static boolean isSilentMode(Context context) {
        AppMethodBeat.m2504i(50301);
        switch (getAudioManager(context).getRingerMode()) {
            case 0:
                AppMethodBeat.m2505o(50301);
                return true;
            case 1:
                AppMethodBeat.m2505o(50301);
                return true;
            case 2:
                AppMethodBeat.m2505o(50301);
                return false;
            default:
                AppMethodBeat.m2505o(50301);
                return false;
        }
    }

    private static AudioManager getAudioManager(Context context) {
        AppMethodBeat.m2504i(50302);
        if (sManager == null) {
            sManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        AudioManager audioManager = sManager;
        AppMethodBeat.m2505o(50302);
        return audioManager;
    }
}
