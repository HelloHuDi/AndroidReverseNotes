package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.IOException;
import java.nio.charset.Charset;

public final class f {
    Context context;
    boolean eeq;
    MediaPlayer eer;
    @SuppressLint({"HandlerLeak"})
    ak ees;
    private ak eet;

    static class a {
        private static final f eey = new f();

        static {
            AppMethodBeat.i(16032);
            AppMethodBeat.o(16032);
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$4 */
    class AnonymousClass4 implements OnErrorListener {
        final /* synthetic */ AudioManager eex;

        AnonymousClass4(AudioManager audioManager) {
            this.eex = audioManager;
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.i(16027);
            ab.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", f.this.eer);
            this.eex.setMode(0);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (f.this.eer != null) {
                f.this.eer.release();
            }
            AppMethodBeat.o(16027);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$3 */
    class AnonymousClass3 implements OnCompletionListener {
        final /* synthetic */ AudioManager eex;

        AnonymousClass3(AudioManager audioManager) {
            this.eex = audioManager;
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(16026);
            ab.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", f.this.eer);
            this.eex.setMode(0);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (f.this.eer != null) {
                f.this.eer.release();
            }
            AppMethodBeat.o(16026);
        }
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        String str = null;
        AppMethodBeat.i(16033);
        this.eeq = false;
        this.eer = null;
        this.ees = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(16024);
                ab.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", Boolean.valueOf(f.this.eeq));
                try {
                    if (f.this.eer != null) {
                        if (f.this.eer.isPlaying()) {
                            f.this.eer.stop();
                        }
                        f.this.eer.release();
                        f.this.eeq = false;
                        ab.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", Boolean.valueOf(f.this.eeq));
                    }
                    AppMethodBeat.o(16024);
                } catch (IllegalStateException e) {
                    ab.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", Boolean.valueOf(f.this.eeq));
                    if (f.this.eer != null) {
                        f.this.eer.release();
                    }
                    AppMethodBeat.o(16024);
                }
            }
        };
        this.context = ah.getContext();
        String str2 = ac.eSj + "deviceconfig.cfg";
        ab.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", str2, Boolean.valueOf(e.ct(str2)));
        if (e.ct(str2)) {
            byte[] f = e.f(str2, 0, -1);
            if (!bo.cb(f)) {
                str2 = new String(f, Charset.defaultCharset());
                if (!bo.isNullOrNil(str2)) {
                    str = str2;
                }
            }
        }
        q.ku(str);
        AppMethodBeat.o(16033);
    }

    public final synchronized void jT(final String str) {
        AppMethodBeat.i(16034);
        if (this.eet == null) {
            ab.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
            HandlerThread ek = d.ek("playSoundThread", 0);
            ek.start();
            this.eet = new ak(ek.getLooper());
        }
        this.eet.post(new Runnable() {
            final /* synthetic */ boolean eew = false;

            public final void run() {
                AppMethodBeat.i(16025);
                f fVar = f.this;
                String str = str;
                boolean z = this.eew;
                if (fVar.context == null) {
                    fVar.context = ah.getContext();
                }
                if (fVar.context == null) {
                    ab.w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
                    AppMethodBeat.o(16025);
                    return;
                }
                try {
                    AudioManager audioManager = (AudioManager) fVar.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    if (audioManager.getStreamVolume(5) == 0) {
                        AppMethodBeat.o(16025);
                        return;
                    }
                    Uri defaultUri;
                    fVar.ees.removeMessages(305419896);
                    fVar.ees.sendEmptyMessageDelayed(305419896, 8000);
                    ab.i("MicroMsg.Notification.Tool.Sound", "doPlaySound playerIsInit: %s", Boolean.valueOf(fVar.eeq));
                    if (fVar.eeq) {
                        try {
                            if (fVar.eer != null) {
                                if (fVar.eer.isPlaying()) {
                                    fVar.eer.stop();
                                }
                                fVar.eer.release();
                                ab.i("MicroMsg.Notification.Tool.Sound", "try to release player before playSound playerIsInit: %s", Boolean.valueOf(fVar.eeq));
                            }
                        } catch (IllegalStateException e) {
                            ab.w("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error");
                            if (fVar.eer != null) {
                                fVar.eer.release();
                            }
                        }
                        fVar.eeq = false;
                    }
                    fVar.eer = new k();
                    ab.i("MicroMsg.Notification.Tool.Sound", "doPlaySound player: %s", fVar.eer);
                    MediaPlayer mediaPlayer = fVar.eer;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (bo.isNullOrNil(str)) {
                        defaultUri = RingtoneManager.getDefaultUri(2);
                    } else if (z) {
                        AssetFileDescriptor openFd = fVar.context.getAssets().openFd(str);
                        mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                        defaultUri = null;
                    } else {
                        defaultUri = Uri.parse(str);
                    }
                    if (defaultUri != null) {
                        try {
                            mediaPlayer.setDataSource(fVar.context, defaultUri);
                        } catch (IOException e2) {
                            if (bo.isNullOrNil(str)) {
                                ab.i("MicroMsg.Notification.Tool.Sound", "setPlayerDataSource IOException soundUri:%s, isAsset:%s", str, Boolean.valueOf(z));
                            } else {
                                mediaPlayer.setDataSource(fVar.context, RingtoneManager.getDefaultUri(2));
                            }
                        }
                    }
                    ab.i("MicroMsg.Notification.Tool.Sound", "summeranrt setPlayerDataSource tid[%d] [%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (audioManager.isWiredHeadsetOn()) {
                        g.KR();
                        ab.d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", Integer.valueOf(0));
                        float streamVolume = (float) audioManager.getStreamVolume(0);
                        float streamMaxVolume = (float) audioManager.getStreamMaxVolume(0);
                        float streamVolume2 = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
                        ab.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s, maxVolume: %s, toneScale: %s", Float.valueOf(streamVolume), Float.valueOf(streamMaxVolume), Float.valueOf(streamVolume / streamMaxVolume));
                        ab.d("MicroMsg.Notification.Tool.Sound", "headset on, toneMUSICVolume: %s, maxMUSICVolume: %s, toneMusicScale: %s", Float.valueOf(r3), Float.valueOf(r5), Float.valueOf(streamVolume2));
                        if (streamVolume / streamMaxVolume > streamVolume2) {
                            streamVolume = streamMaxVolume * streamVolume2;
                            ab.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s", Float.valueOf(streamVolume));
                        }
                        audioManager.setSpeakerphoneOn(false);
                        ab.i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", Integer.valueOf(q.etn.esG));
                        if (q.etn.esG == 1) {
                            ab.i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                            if (audioManager.getMode() == 0) {
                                audioManager.setMode(3);
                            }
                            fVar.eer.setOnCompletionListener(new AnonymousClass3(audioManager));
                            fVar.eer.setOnErrorListener(new AnonymousClass4(audioManager));
                        } else {
                            fVar.eer.setOnCompletionListener(new OnCompletionListener() {
                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    AppMethodBeat.i(16028);
                                    ab.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", f.this.eer);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (f.this.eer != null) {
                                        f.this.eer.release();
                                    }
                                    AppMethodBeat.o(16028);
                                }
                            });
                            fVar.eer.setOnErrorListener(new OnErrorListener() {
                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    AppMethodBeat.i(16029);
                                    ab.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", f.this.eer);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (f.this.eer != null) {
                                        f.this.eer.release();
                                    }
                                    AppMethodBeat.o(16029);
                                    return false;
                                }
                            });
                        }
                        fVar.eer.setAudioStreamType(0);
                        fVar.eer.setLooping(true);
                        fVar.eer.prepare();
                        fVar.eer.setVolume(streamVolume / streamMaxVolume, streamVolume / streamMaxVolume);
                        fVar.eer.setLooping(false);
                        fVar.eer.start();
                        fVar.eeq = true;
                        AppMethodBeat.o(16025);
                        return;
                    }
                    boolean z2;
                    ab.d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", Integer.valueOf(audioManager.getStreamVolume(5)), str);
                    fVar.eer.setOnCompletionListener(new OnCompletionListener() {
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            AppMethodBeat.i(16030);
                            ab.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", f.this.eer);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (f.this.eer != null) {
                                f.this.eer.release();
                                ab.i("MicroMsg.Notification.Tool.Sound", "play sound real finish, player: %s,playerIsInit:%s", f.this.eer, Boolean.valueOf(f.this.eeq));
                            }
                            AppMethodBeat.o(16030);
                        }
                    });
                    fVar.eer.setOnErrorListener(new OnErrorListener() {
                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            AppMethodBeat.i(16031);
                            ab.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", f.this.eer);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (f.this.eer != null) {
                                f.this.eer.release();
                                ab.i("MicroMsg.Notification.Tool.Sound", "play sound real error, player: %s,playerIsInit:%s", f.this.eer, Boolean.valueOf(f.this.eeq));
                            }
                            AppMethodBeat.o(16031);
                            return false;
                        }
                    });
                    fVar.eer.setAudioStreamType(5);
                    fVar.eer.setLooping(true);
                    fVar.eer.prepare();
                    fVar.eer.setLooping(false);
                    fVar.eer.start();
                    fVar.eeq = true;
                    String str2 = "MicroMsg.Notification.Tool.Sound";
                    String str3 = "doPlaySound start finish playerIsInit:%s, myLooper[%b] mainLooper[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(fVar.eeq);
                    if (Looper.myLooper() != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[1] = Boolean.valueOf(z2);
                    if (Looper.getMainLooper() != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr[2] = Boolean.valueOf(z2);
                    ab.i(str2, str3, objArr);
                    AppMethodBeat.o(16025);
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e3, "PlaySound Exception:", new Object[0]);
                    try {
                        if (fVar.eer != null) {
                            fVar.eer.release();
                        }
                        AppMethodBeat.o(16025);
                    } catch (Exception e32) {
                        ab.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e32, "try to release player in Exception:", new Object[0]);
                        AppMethodBeat.o(16025);
                    }
                }
            }
        });
        AppMethodBeat.o(16034);
    }
}
