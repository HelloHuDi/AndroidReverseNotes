package com.tencent.p177mm.booter.notification.p841a;

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
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.tencent.mm.booter.notification.a.f */
public final class C9192f {
    Context context;
    boolean eeq;
    MediaPlayer eer;
    @SuppressLint({"HandlerLeak"})
    C7306ak ees;
    private C7306ak eet;

    /* renamed from: com.tencent.mm.booter.notification.a.f$6 */
    class C91936 implements OnErrorListener {
        C91936() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(16029);
            C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", C9192f.this.eer);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (C9192f.this.eer != null) {
                C9192f.this.eer.release();
            }
            AppMethodBeat.m2505o(16029);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$7 */
    class C91947 implements OnCompletionListener {
        C91947() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(16030);
            C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", C9192f.this.eer);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (C9192f.this.eer != null) {
                C9192f.this.eer.release();
                C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "play sound real finish, player: %s,playerIsInit:%s", C9192f.this.eer, Boolean.valueOf(C9192f.this.eeq));
            }
            AppMethodBeat.m2505o(16030);
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$8 */
    class C91958 implements OnErrorListener {
        C91958() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(16031);
            C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", C9192f.this.eer);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (C9192f.this.eer != null) {
                C9192f.this.eer.release();
                C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "play sound real error, player: %s,playerIsInit:%s", C9192f.this.eer, Boolean.valueOf(C9192f.this.eeq));
            }
            AppMethodBeat.m2505o(16031);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$a */
    static class C9196a {
        private static final C9192f eey = new C9192f();

        static {
            AppMethodBeat.m2504i(16032);
            AppMethodBeat.m2505o(16032);
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$5 */
    class C91975 implements OnCompletionListener {
        C91975() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(16028);
            C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", C9192f.this.eer);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (C9192f.this.eer != null) {
                C9192f.this.eer.release();
            }
            AppMethodBeat.m2505o(16028);
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$4 */
    class C92004 implements OnErrorListener {
        final /* synthetic */ AudioManager eex;

        C92004(AudioManager audioManager) {
            this.eex = audioManager;
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(16027);
            C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", C9192f.this.eer);
            this.eex.setMode(0);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (C9192f.this.eer != null) {
                C9192f.this.eer.release();
            }
            AppMethodBeat.m2505o(16027);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$3 */
    class C92013 implements OnCompletionListener {
        final /* synthetic */ AudioManager eex;

        C92013(AudioManager audioManager) {
            this.eex = audioManager;
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(16026);
            C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", C9192f.this.eer);
            this.eex.setMode(0);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (C9192f.this.eer != null) {
                C9192f.this.eer.release();
            }
            AppMethodBeat.m2505o(16026);
        }
    }

    /* synthetic */ C9192f(byte b) {
        this();
    }

    private C9192f() {
        String str = null;
        AppMethodBeat.m2504i(16033);
        this.eeq = false;
        this.eer = null;
        this.ees = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(16024);
                C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", Boolean.valueOf(C9192f.this.eeq));
                try {
                    if (C9192f.this.eer != null) {
                        if (C9192f.this.eer.isPlaying()) {
                            C9192f.this.eer.stop();
                        }
                        C9192f.this.eer.release();
                        C9192f.this.eeq = false;
                        C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", Boolean.valueOf(C9192f.this.eeq));
                    }
                    AppMethodBeat.m2505o(16024);
                } catch (IllegalStateException e) {
                    C4990ab.m7421w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", Boolean.valueOf(C9192f.this.eeq));
                    if (C9192f.this.eer != null) {
                        C9192f.this.eer.release();
                    }
                    AppMethodBeat.m2505o(16024);
                }
            }
        };
        this.context = C4996ah.getContext();
        String str2 = C5128ac.eSj + "deviceconfig.cfg";
        C4990ab.m7417i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", str2, Boolean.valueOf(C1173e.m2561ct(str2)));
        if (C1173e.m2561ct(str2)) {
            byte[] f = C1173e.m2571f(str2, 0, -1);
            if (!C5046bo.m7540cb(f)) {
                str2 = new String(f, Charset.defaultCharset());
                if (!C5046bo.isNullOrNil(str2)) {
                    str = str2;
                }
            }
        }
        C1427q.m3050ku(str);
        AppMethodBeat.m2505o(16033);
    }

    /* renamed from: jT */
    public final synchronized void mo20593jT(final String str) {
        AppMethodBeat.m2504i(16034);
        if (this.eet == null) {
            C4990ab.m7416i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
            HandlerThread ek = C7305d.m12297ek("playSoundThread", 0);
            ek.start();
            this.eet = new C7306ak(ek.getLooper());
        }
        this.eet.post(new Runnable() {
            final /* synthetic */ boolean eew = false;

            public final void run() {
                AppMethodBeat.m2504i(16025);
                C9192f c9192f = C9192f.this;
                String str = str;
                boolean z = this.eew;
                if (c9192f.context == null) {
                    c9192f.context = C4996ah.getContext();
                }
                if (c9192f.context == null) {
                    C4990ab.m7420w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
                    AppMethodBeat.m2505o(16025);
                    return;
                }
                try {
                    AudioManager audioManager = (AudioManager) c9192f.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    if (audioManager.getStreamVolume(5) == 0) {
                        AppMethodBeat.m2505o(16025);
                        return;
                    }
                    Uri defaultUri;
                    c9192f.ees.removeMessages(305419896);
                    c9192f.ees.sendEmptyMessageDelayed(305419896, 8000);
                    C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "doPlaySound playerIsInit: %s", Boolean.valueOf(c9192f.eeq));
                    if (c9192f.eeq) {
                        try {
                            if (c9192f.eer != null) {
                                if (c9192f.eer.isPlaying()) {
                                    c9192f.eer.stop();
                                }
                                c9192f.eer.release();
                                C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "try to release player before playSound playerIsInit: %s", Boolean.valueOf(c9192f.eeq));
                            }
                        } catch (IllegalStateException e) {
                            C4990ab.m7420w("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error");
                            if (c9192f.eer != null) {
                                c9192f.eer.release();
                            }
                        }
                        c9192f.eeq = false;
                    }
                    c9192f.eer = new C45289k();
                    C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "doPlaySound player: %s", c9192f.eer);
                    MediaPlayer mediaPlayer = c9192f.eer;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (C5046bo.isNullOrNil(str)) {
                        defaultUri = RingtoneManager.getDefaultUri(2);
                    } else if (z) {
                        AssetFileDescriptor openFd = c9192f.context.getAssets().openFd(str);
                        mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                        defaultUri = null;
                    } else {
                        defaultUri = Uri.parse(str);
                    }
                    if (defaultUri != null) {
                        try {
                            mediaPlayer.setDataSource(c9192f.context, defaultUri);
                        } catch (IOException e2) {
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "setPlayerDataSource IOException soundUri:%s, isAsset:%s", str, Boolean.valueOf(z));
                            } else {
                                mediaPlayer.setDataSource(c9192f.context, RingtoneManager.getDefaultUri(2));
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "summeranrt setPlayerDataSource tid[%d] [%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (audioManager.isWiredHeadsetOn()) {
                        C1407g.m2949KR();
                        C4990ab.m7411d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", Integer.valueOf(0));
                        float streamVolume = (float) audioManager.getStreamVolume(0);
                        float streamMaxVolume = (float) audioManager.getStreamMaxVolume(0);
                        float streamVolume2 = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
                        C4990ab.m7411d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s, maxVolume: %s, toneScale: %s", Float.valueOf(streamVolume), Float.valueOf(streamMaxVolume), Float.valueOf(streamVolume / streamMaxVolume));
                        C4990ab.m7411d("MicroMsg.Notification.Tool.Sound", "headset on, toneMUSICVolume: %s, maxMUSICVolume: %s, toneMusicScale: %s", Float.valueOf(r3), Float.valueOf(r5), Float.valueOf(streamVolume2));
                        if (streamVolume / streamMaxVolume > streamVolume2) {
                            streamVolume = streamMaxVolume * streamVolume2;
                            C4990ab.m7411d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s", Float.valueOf(streamVolume));
                        }
                        audioManager.setSpeakerphoneOn(false);
                        C4990ab.m7417i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", Integer.valueOf(C1427q.etn.esG));
                        if (C1427q.etn.esG == 1) {
                            C4990ab.m7416i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                            if (audioManager.getMode() == 0) {
                                audioManager.setMode(3);
                            }
                            c9192f.eer.setOnCompletionListener(new C92013(audioManager));
                            c9192f.eer.setOnErrorListener(new C92004(audioManager));
                        } else {
                            c9192f.eer.setOnCompletionListener(new C91975());
                            c9192f.eer.setOnErrorListener(new C91936());
                        }
                        c9192f.eer.setAudioStreamType(0);
                        c9192f.eer.setLooping(true);
                        c9192f.eer.prepare();
                        c9192f.eer.setVolume(streamVolume / streamMaxVolume, streamVolume / streamMaxVolume);
                        c9192f.eer.setLooping(false);
                        c9192f.eer.start();
                        c9192f.eeq = true;
                        AppMethodBeat.m2505o(16025);
                        return;
                    }
                    boolean z2;
                    C4990ab.m7411d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", Integer.valueOf(audioManager.getStreamVolume(5)), str);
                    c9192f.eer.setOnCompletionListener(new C91947());
                    c9192f.eer.setOnErrorListener(new C91958());
                    c9192f.eer.setAudioStreamType(5);
                    c9192f.eer.setLooping(true);
                    c9192f.eer.prepare();
                    c9192f.eer.setLooping(false);
                    c9192f.eer.start();
                    c9192f.eeq = true;
                    String str2 = "MicroMsg.Notification.Tool.Sound";
                    String str3 = "doPlaySound start finish playerIsInit:%s, myLooper[%b] mainLooper[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(c9192f.eeq);
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
                    C4990ab.m7417i(str2, str3, objArr);
                    AppMethodBeat.m2505o(16025);
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e3, "PlaySound Exception:", new Object[0]);
                    try {
                        if (c9192f.eer != null) {
                            c9192f.eer.release();
                        }
                        AppMethodBeat.m2505o(16025);
                    } catch (Exception e32) {
                        C4990ab.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e32, "try to release player in Exception:", new Object[0]);
                        AppMethodBeat.m2505o(16025);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(16034);
    }
}
