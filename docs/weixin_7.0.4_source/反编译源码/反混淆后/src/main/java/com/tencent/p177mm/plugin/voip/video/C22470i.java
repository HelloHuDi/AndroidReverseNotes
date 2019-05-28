package com.tencent.p177mm.plugin.voip.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Looper;
import android.os.Vibrator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p219b.C1397a;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.voip.video.i */
public final class C22470i {
    public boolean aFV = false;
    private AudioManager euK;
    C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private C45293b gar;
    private Vibrator iVt;
    public Context mContext;
    public MediaPlayer tbg;
    public int tbh = 65536;
    public long tbi;
    public long tbj;
    C14090a tbk;

    /* renamed from: com.tencent.mm.plugin.voip.video.i$8 */
    public class C43038 implements OnErrorListener {
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(5099);
            if (mediaPlayer != null) {
                mediaPlayer.release();
                C22470i.this.tbh = 5;
                C4990ab.m7421w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2));
            }
            AppMethodBeat.m2505o(5099);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.i$6 */
    class C140896 implements OnErrorListener {
        C140896() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(5097);
            if (mediaPlayer != null) {
                mediaPlayer.release();
                C22470i.this.tbh = 5;
                C4990ab.m7421w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2));
            }
            AppMethodBeat.m2505o(5097);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.i$a */
    class C14090a implements Runnable {
        private long interval;
        private int resId;
        private int streamType;
        private boolean tbq;

        public C14090a(int i, long j, boolean z, int i2) {
            this.resId = i;
            this.interval = j;
            this.tbq = z;
            this.streamType = i2;
        }

        public final void run() {
            AppMethodBeat.m2504i(5100);
            C22470i.this.mo38021a(this.resId, this.interval, this.tbq, this.streamType);
            AppMethodBeat.m2505o(5100);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.i$7 */
    public class C224717 implements OnCompletionListener {
        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(5098);
            mediaPlayer.release();
            if (System.currentTimeMillis() - C22470i.this.tbj > 5000) {
                C22470i.this.tbh = 8;
                C1407g.m2946KK().setMode(0);
            }
            AppMethodBeat.m2505o(5098);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.i$1 */
    class C224721 implements OnCompletionListener {
        C224721() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(5092);
            if (System.currentTimeMillis() - C22470i.this.tbi > 70000) {
                C22470i.this.tbh = 4;
            }
            AppMethodBeat.m2505o(5092);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.i$2 */
    class C224732 implements OnErrorListener {
        C224732() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(5093);
            C22470i.this.tbh = 1;
            C4990ab.m7420w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
            AppMethodBeat.m2505o(5093);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.i$4 */
    class C224744 implements OnErrorListener {
        C224744() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(5095);
            C22470i.this.tbh = 1;
            C4990ab.m7420w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
            AppMethodBeat.m2505o(5095);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.i$5 */
    class C224765 implements OnCompletionListener {
        C224765() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(5096);
            mediaPlayer.release();
            if (System.currentTimeMillis() - C22470i.this.tbj > 5000) {
                C22470i.this.tbh = 8;
            }
            AppMethodBeat.m2505o(5096);
        }
    }

    public C22470i(Context context) {
        AppMethodBeat.m2504i(5101);
        this.mContext = context;
        if (this.mContext != null) {
            this.euK = C1407g.m2946KK().eoY;
            if (this.euK == null) {
                this.euK = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            this.iVt = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        this.gar = new C45293b(C4996ah.getContext());
        AppMethodBeat.m2505o(5101);
    }

    /* renamed from: mE */
    public final void mo38024mE(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(5102);
        C4990ab.m7417i("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b", Boolean.valueOf(z));
        if (!z) {
            if (C1443d.m3068iW(21)) {
                i = 3;
            } else {
                i = 2;
            }
        }
        if (z && C1427q.etd.eqp >= 0) {
            i = C1427q.etd.eqp;
        } else if (!z && C1427q.etd.eqn >= 0) {
            i = C1427q.etd.eqn;
        }
        if (i != this.euK.getMode()) {
            this.euK.setMode(i);
        }
        if (z != this.euK.isSpeakerphoneOn()) {
            this.euK.setSpeakerphoneOn(z);
        }
        AppMethodBeat.m2505o(5102);
    }

    public final void stop() {
        AppMethodBeat.m2504i(5103);
        C4990ab.m7411d("MicroMsg.RingPlayer", "stop, isStarted: %b", Boolean.valueOf(this.aFV));
        cLM();
        if (this.tbg == null || !this.aFV) {
            AppMethodBeat.m2505o(5103);
            return;
        }
        try {
            this.tbg.stop();
            this.tbg.release();
            if (this.tbk != null) {
                this.fbD.removeCallbacks(this.tbk);
            }
            this.aFV = false;
            C1407g.m2946KK().setMode(0);
            AppMethodBeat.m2505o(5103);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.RingPlayer", e.toString());
            AppMethodBeat.m2505o(5103);
        }
    }

    /* renamed from: DB */
    public final boolean mo38019DB() {
        return !this.aFV;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: q */
    public final void mo38025q(int i, int i2, boolean z) {
        boolean booleanValue;
        Exception e;
        boolean MO;
        AppMethodBeat.m2504i(5104);
        if (i2 == 0) {
            try {
                booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73217, Boolean.TRUE)).booleanValue();
            } catch (Exception e2) {
                e = e2;
                booleanValue = true;
            }
        } else if (i2 == 1 || i2 == 2) {
            booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73218, Boolean.TRUE)).booleanValue();
        } else {
            booleanValue = true;
        }
        try {
            boolean MN;
            if (C1443d.m3068iW(26)) {
                MN = C37885a.m63961MN();
                MO = C37885a.m63962MO();
            } else {
                MN = C37885a.m63954MG();
                MO = C37885a.m63956MI();
            }
            C4990ab.m7417i("MicroMsg.RingPlayer", "startPlayCustomRing, voipSound: %s, msgSound: %s, msgShake: %s, isCallingParty: %s", Boolean.valueOf(booleanValue), Boolean.valueOf(MN), Boolean.valueOf(MO), Boolean.valueOf(z));
            if (z) {
                MN = true;
            }
            booleanValue = MN;
        } catch (Exception e3) {
            e = e3;
        }
        if (booleanValue && !MO) {
            AppMethodBeat.m2505o(5104);
            return;
        } else if (!this.aFV) {
            AppMethodBeat.m2505o(5104);
            return;
        } else if (booleanValue) {
            try {
                this.tbi = System.currentTimeMillis();
                this.tbg = new C45289k();
                try {
                    int Lc;
                    int i3;
                    this.tbg.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                    this.tbg.setOnCompletionListener(new C224721());
                    this.tbg.setOnErrorListener(new C224732());
                    booleanValue = C1407g.m2946KK().mo4819KP();
                    boolean KV = C1407g.m2946KK().mo4822KV();
                    C4990ab.m7411d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", Boolean.valueOf(booleanValue), Boolean.valueOf(KV));
                    if (booleanValue) {
                        Lc = C1407g.m2946KK().mo4827Lc();
                        mo38024mE(false);
                        i3 = Lc;
                    } else if (z || KV) {
                        if (C1427q.etd.eqm >= 0) {
                            Lc = C1427q.etd.eqm;
                        } else {
                            Lc = 0;
                        }
                        if (KV || i2 == 1) {
                            mo38024mE(false);
                            i3 = Lc;
                        } else {
                            Lc = 3;
                            if (C1427q.etd.eqj >= 0) {
                                Lc = C1427q.etd.eqj;
                            }
                            mo38024mE(true);
                            i3 = Lc;
                        }
                    } else {
                        if (C1407g.m2946KK().mo4819KP() || C1427q.etd.eqo < 0) {
                            Lc = 2;
                        } else {
                            Lc = C1427q.etd.eqo;
                        }
                        mo38024mE(true);
                        i3 = Lc;
                    }
                    this.tbg.setAudioStreamType(i3);
                    if (KV || booleanValue) {
                        int streamMaxVolume = this.euK.getStreamMaxVolume(i3);
                        Lc = this.euK.getStreamVolume(i3);
                        if (Lc > streamMaxVolume / 2) {
                            Lc = streamMaxVolume / 2;
                        }
                        C1397a.m2944b(this.euK, i3, Lc);
                    } else if (z) {
                        this.tbg.setVolume(0.6f, 0.6f);
                    } else if (MO) {
                        cLL();
                    }
                    this.tbg.setLooping(true);
                    this.tbg.prepare();
                    this.tbg.start();
                    if (System.currentTimeMillis() - this.tbi > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                        this.tbh = 3;
                    }
                } catch (Throwable th) {
                    C4990ab.m7412e("MicroMsg.RingPlayer", "startPlayCustomRing failed, " + th.getMessage());
                    this.tbh = 2;
                    try {
                        this.tbg = C45289k.m83508d(this.mContext, RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1));
                        if (this.tbg == null) {
                            AppMethodBeat.m2505o(5104);
                            return;
                        }
                        this.tbg.stop();
                        this.tbg.prepare();
                        this.tbg.setLooping(true);
                        if (z) {
                            this.tbg.setVolume(0.6f, 0.6f);
                        } else if (MO) {
                            cLL();
                        }
                        this.tbg.start();
                        this.tbh = 0;
                    } catch (Exception e4) {
                        C4990ab.m7412e("ex", e4.getMessage());
                        this.tbh = 2;
                    }
                }
                this.aFV = true;
                AppMethodBeat.m2505o(5104);
                return;
            } catch (Exception e42) {
                C4990ab.m7412e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e42.toString());
                AppMethodBeat.m2505o(5104);
                return;
            }
        } else {
            if (MO && !z) {
                cLL();
            }
            AppMethodBeat.m2505o(5104);
            return;
        }
        C4990ab.m7412e("MicroMsg.RingPlayer", "get voip sound failed: " + e42.getMessage());
        MO = true;
        if (booleanValue) {
        }
        if (!this.aFV) {
        }
    }

    /* renamed from: a */
    public final void mo38021a(int i, long j, boolean z, int i2) {
        AppMethodBeat.m2504i(5105);
        this.tbi = System.currentTimeMillis();
        this.tbg = new C45289k();
        try {
            this.tbg.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
            final int i3 = i;
            final long j2 = j;
            final boolean z2 = z;
            final int i4 = i2;
            this.tbg.setOnCompletionListener(new OnCompletionListener() {
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    AppMethodBeat.m2504i(5094);
                    if (System.currentTimeMillis() - C22470i.this.tbi > 70000) {
                        C22470i.this.tbh = 4;
                    }
                    if (C22470i.this.aFV) {
                        C22470i.this.tbk = new C14090a(i3, j2, z2, i4);
                        C22470i.this.fbD.postDelayed(C22470i.this.tbk, j2);
                    }
                    AppMethodBeat.m2505o(5094);
                }
            });
            this.tbg.setOnErrorListener(new C224744());
            this.tbg.setAudioStreamType(i2);
            if (z) {
                this.tbg.setVolume(0.6f, 0.6f);
            } else {
                cLL();
            }
            this.tbg.setLooping(false);
            this.tbg.prepare();
            this.tbg.start();
            if (System.currentTimeMillis() - this.tbi > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                this.tbh = 3;
            }
            AppMethodBeat.m2505o(5105);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e.toString());
            AppMethodBeat.m2505o(5105);
        }
    }

    private void cLL() {
        boolean z;
        AppMethodBeat.m2504i(5106);
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(C4996ah.doA(), 0);
        if (C1443d.m3068iW(26)) {
            z = sharedPreferences.getBoolean("settings_voip_scene_shake", true);
        } else {
            z = sharedPreferences.getBoolean("settings_shake", true);
        }
        if (z) {
            int ringerMode = this.euK.getRingerMode();
            C4990ab.m7417i("MicroMsg.RingPlayer", "system ringer mode: %s", Integer.valueOf(ringerMode));
            if (ringerMode == 1 || ringerMode == 2) {
                this.iVt = (Vibrator) this.mContext.getSystemService("vibrator");
                if (this.iVt == null) {
                    AppMethodBeat.m2505o(5106);
                    return;
                }
                this.iVt.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
                AppMethodBeat.m2505o(5106);
                return;
            }
            C4990ab.m7416i("MicroMsg.RingPlayer", "system not open vibrate");
        }
        AppMethodBeat.m2505o(5106);
    }

    private void cLM() {
        AppMethodBeat.m2504i(5107);
        if (this.iVt != null) {
            this.iVt.cancel();
            this.iVt = null;
        }
        AppMethodBeat.m2505o(5107);
    }

    /* renamed from: ao */
    public final void mo38022ao(int i, boolean z) {
        AppMethodBeat.m2504i(5108);
        this.tbh = 0;
        mo38025q(C1318a.phonering, i, z);
        AppMethodBeat.m2505o(5108);
    }

    /* renamed from: r */
    public final void mo38026r(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(5109);
        if (i != C1318a.playend || C1407g.m2946KK().mo4819KP() || C1407g.m2946KK().mo4822KV() || !(this.euK.getRingerMode() == 0 || this.euK.getRingerMode() == 1)) {
            this.mContext.getSharedPreferences(C4996ah.doA(), 0).getBoolean("settings_shake", true);
            C4990ab.m7417i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.FALSE);
            this.tbj = System.currentTimeMillis();
            C45289k c45289k = new C45289k();
            try {
                c45289k.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                c45289k.setOnCompletionListener(new C224765());
                c45289k.setOnErrorListener(new C140896());
                if (z) {
                    c45289k.setAudioStreamType(C1407g.m2946KK().mo4819KP() ? C1407g.m2946KK().mo4827Lc() : 0);
                }
                if (i == C1318a.playend && (C1407g.m2946KK().mo4819KP() || C1407g.m2946KK().mo4822KV())) {
                    c45289k.setVolume(0.5f, 0.5f);
                }
                c45289k.prepare();
                c45289k.setLooping(false);
                c45289k.start();
                if (System.currentTimeMillis() - this.tbj > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    this.tbh = 7;
                }
                AppMethodBeat.m2505o(5109);
                return;
            } catch (Throwable th) {
                C4990ab.m7421w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", th);
                this.tbh = 6;
                AppMethodBeat.m2505o(5109);
                return;
            }
        }
        AppMethodBeat.m2505o(5109);
    }

    /* renamed from: Gx */
    public final void mo38020Gx(int i) {
        AppMethodBeat.m2504i(5110);
        mo38026r(C1318a.playend, i, true);
        AppMethodBeat.m2505o(5110);
    }

    public final int cLN() {
        AppMethodBeat.m2504i(5111);
        C4990ab.m7410d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.tbh);
        int i = this.tbh;
        AppMethodBeat.m2505o(5111);
        return i;
    }
}
