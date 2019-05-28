package com.tencent.mm.plugin.voip.video;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class i {
    public boolean aFV = false;
    private AudioManager euK;
    ak fbD = new ak(Looper.getMainLooper());
    private b gar;
    private Vibrator iVt;
    public Context mContext;
    public MediaPlayer tbg;
    public int tbh = 65536;
    public long tbi;
    public long tbj;
    a tbk;

    class a implements Runnable {
        private long interval;
        private int resId;
        private int streamType;
        private boolean tbq;

        public a(int i, long j, boolean z, int i2) {
            this.resId = i;
            this.interval = j;
            this.tbq = z;
            this.streamType = i2;
        }

        public final void run() {
            AppMethodBeat.i(5100);
            i.this.a(this.resId, this.interval, this.tbq, this.streamType);
            AppMethodBeat.o(5100);
        }
    }

    public i(Context context) {
        AppMethodBeat.i(5101);
        this.mContext = context;
        if (this.mContext != null) {
            this.euK = g.KK().eoY;
            if (this.euK == null) {
                this.euK = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            this.iVt = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        this.gar = new b(ah.getContext());
        AppMethodBeat.o(5101);
    }

    public final void mE(boolean z) {
        int i = 0;
        AppMethodBeat.i(5102);
        ab.i("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b", Boolean.valueOf(z));
        if (!z) {
            if (d.iW(21)) {
                i = 3;
            } else {
                i = 2;
            }
        }
        if (z && q.etd.eqp >= 0) {
            i = q.etd.eqp;
        } else if (!z && q.etd.eqn >= 0) {
            i = q.etd.eqn;
        }
        if (i != this.euK.getMode()) {
            this.euK.setMode(i);
        }
        if (z != this.euK.isSpeakerphoneOn()) {
            this.euK.setSpeakerphoneOn(z);
        }
        AppMethodBeat.o(5102);
    }

    public final void stop() {
        AppMethodBeat.i(5103);
        ab.d("MicroMsg.RingPlayer", "stop, isStarted: %b", Boolean.valueOf(this.aFV));
        cLM();
        if (this.tbg == null || !this.aFV) {
            AppMethodBeat.o(5103);
            return;
        }
        try {
            this.tbg.stop();
            this.tbg.release();
            if (this.tbk != null) {
                this.fbD.removeCallbacks(this.tbk);
            }
            this.aFV = false;
            g.KK().setMode(0);
            AppMethodBeat.o(5103);
        } catch (Exception e) {
            ab.e("MicroMsg.RingPlayer", e.toString());
            AppMethodBeat.o(5103);
        }
    }

    public final boolean DB() {
        return !this.aFV;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(int i, int i2, boolean z) {
        boolean booleanValue;
        Exception e;
        boolean MO;
        AppMethodBeat.i(5104);
        if (i2 == 0) {
            try {
                booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(73217, Boolean.TRUE)).booleanValue();
            } catch (Exception e2) {
                e = e2;
                booleanValue = true;
            }
        } else if (i2 == 1 || i2 == 2) {
            booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(73218, Boolean.TRUE)).booleanValue();
        } else {
            booleanValue = true;
        }
        try {
            boolean MN;
            if (d.iW(26)) {
                MN = com.tencent.mm.m.a.MN();
                MO = com.tencent.mm.m.a.MO();
            } else {
                MN = com.tencent.mm.m.a.MG();
                MO = com.tencent.mm.m.a.MI();
            }
            ab.i("MicroMsg.RingPlayer", "startPlayCustomRing, voipSound: %s, msgSound: %s, msgShake: %s, isCallingParty: %s", Boolean.valueOf(booleanValue), Boolean.valueOf(MN), Boolean.valueOf(MO), Boolean.valueOf(z));
            if (z) {
                MN = true;
            }
            booleanValue = MN;
        } catch (Exception e3) {
            e = e3;
        }
        if (booleanValue && !MO) {
            AppMethodBeat.o(5104);
            return;
        } else if (!this.aFV) {
            AppMethodBeat.o(5104);
            return;
        } else if (booleanValue) {
            try {
                this.tbi = System.currentTimeMillis();
                this.tbg = new k();
                try {
                    int Lc;
                    int i3;
                    this.tbg.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                    this.tbg.setOnCompletionListener(new OnCompletionListener() {
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            AppMethodBeat.i(5092);
                            if (System.currentTimeMillis() - i.this.tbi > 70000) {
                                i.this.tbh = 4;
                            }
                            AppMethodBeat.o(5092);
                        }
                    });
                    this.tbg.setOnErrorListener(new OnErrorListener() {
                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            AppMethodBeat.i(5093);
                            i.this.tbh = 1;
                            ab.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
                            AppMethodBeat.o(5093);
                            return false;
                        }
                    });
                    booleanValue = g.KK().KP();
                    boolean KV = g.KK().KV();
                    ab.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", Boolean.valueOf(booleanValue), Boolean.valueOf(KV));
                    if (booleanValue) {
                        Lc = g.KK().Lc();
                        mE(false);
                        i3 = Lc;
                    } else if (z || KV) {
                        if (q.etd.eqm >= 0) {
                            Lc = q.etd.eqm;
                        } else {
                            Lc = 0;
                        }
                        if (KV || i2 == 1) {
                            mE(false);
                            i3 = Lc;
                        } else {
                            Lc = 3;
                            if (q.etd.eqj >= 0) {
                                Lc = q.etd.eqj;
                            }
                            mE(true);
                            i3 = Lc;
                        }
                    } else {
                        if (g.KK().KP() || q.etd.eqo < 0) {
                            Lc = 2;
                        } else {
                            Lc = q.etd.eqo;
                        }
                        mE(true);
                        i3 = Lc;
                    }
                    this.tbg.setAudioStreamType(i3);
                    if (KV || booleanValue) {
                        int streamMaxVolume = this.euK.getStreamMaxVolume(i3);
                        Lc = this.euK.getStreamVolume(i3);
                        if (Lc > streamMaxVolume / 2) {
                            Lc = streamMaxVolume / 2;
                        }
                        com.tencent.mm.compatible.b.a.b(this.euK, i3, Lc);
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
                    ab.e("MicroMsg.RingPlayer", "startPlayCustomRing failed, " + th.getMessage());
                    this.tbh = 2;
                    try {
                        this.tbg = k.d(this.mContext, RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1));
                        if (this.tbg == null) {
                            AppMethodBeat.o(5104);
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
                        ab.e("ex", e4.getMessage());
                        this.tbh = 2;
                    }
                }
                this.aFV = true;
                AppMethodBeat.o(5104);
                return;
            } catch (Exception e42) {
                ab.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e42.toString());
                AppMethodBeat.o(5104);
                return;
            }
        } else {
            if (MO && !z) {
                cLL();
            }
            AppMethodBeat.o(5104);
            return;
        }
        ab.e("MicroMsg.RingPlayer", "get voip sound failed: " + e42.getMessage());
        MO = true;
        if (booleanValue) {
        }
        if (!this.aFV) {
        }
    }

    public final void a(int i, long j, boolean z, int i2) {
        AppMethodBeat.i(5105);
        this.tbi = System.currentTimeMillis();
        this.tbg = new k();
        try {
            this.tbg.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
            final int i3 = i;
            final long j2 = j;
            final boolean z2 = z;
            final int i4 = i2;
            this.tbg.setOnCompletionListener(new OnCompletionListener() {
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    AppMethodBeat.i(5094);
                    if (System.currentTimeMillis() - i.this.tbi > 70000) {
                        i.this.tbh = 4;
                    }
                    if (i.this.aFV) {
                        i.this.tbk = new a(i3, j2, z2, i4);
                        i.this.fbD.postDelayed(i.this.tbk, j2);
                    }
                    AppMethodBeat.o(5094);
                }
            });
            this.tbg.setOnErrorListener(new OnErrorListener() {
                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    AppMethodBeat.i(5095);
                    i.this.tbh = 1;
                    ab.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
                    AppMethodBeat.o(5095);
                    return false;
                }
            });
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
            AppMethodBeat.o(5105);
        } catch (Exception e) {
            ab.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e.toString());
            AppMethodBeat.o(5105);
        }
    }

    private void cLL() {
        boolean z;
        AppMethodBeat.i(5106);
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(ah.doA(), 0);
        if (d.iW(26)) {
            z = sharedPreferences.getBoolean("settings_voip_scene_shake", true);
        } else {
            z = sharedPreferences.getBoolean("settings_shake", true);
        }
        if (z) {
            int ringerMode = this.euK.getRingerMode();
            ab.i("MicroMsg.RingPlayer", "system ringer mode: %s", Integer.valueOf(ringerMode));
            if (ringerMode == 1 || ringerMode == 2) {
                this.iVt = (Vibrator) this.mContext.getSystemService("vibrator");
                if (this.iVt == null) {
                    AppMethodBeat.o(5106);
                    return;
                }
                this.iVt.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
                AppMethodBeat.o(5106);
                return;
            }
            ab.i("MicroMsg.RingPlayer", "system not open vibrate");
        }
        AppMethodBeat.o(5106);
    }

    private void cLM() {
        AppMethodBeat.i(5107);
        if (this.iVt != null) {
            this.iVt.cancel();
            this.iVt = null;
        }
        AppMethodBeat.o(5107);
    }

    public final void ao(int i, boolean z) {
        AppMethodBeat.i(5108);
        this.tbh = 0;
        q(R.raw.phonering, i, z);
        AppMethodBeat.o(5108);
    }

    public final void r(int i, int i2, boolean z) {
        AppMethodBeat.i(5109);
        if (i != R.raw.playend || g.KK().KP() || g.KK().KV() || !(this.euK.getRingerMode() == 0 || this.euK.getRingerMode() == 1)) {
            this.mContext.getSharedPreferences(ah.doA(), 0).getBoolean("settings_shake", true);
            ab.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.FALSE);
            this.tbj = System.currentTimeMillis();
            k kVar = new k();
            try {
                kVar.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                kVar.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.i(5096);
                        mediaPlayer.release();
                        if (System.currentTimeMillis() - i.this.tbj > 5000) {
                            i.this.tbh = 8;
                        }
                        AppMethodBeat.o(5096);
                    }
                });
                kVar.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        AppMethodBeat.i(5097);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                            i.this.tbh = 5;
                            ab.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2));
                        }
                        AppMethodBeat.o(5097);
                        return false;
                    }
                });
                if (z) {
                    kVar.setAudioStreamType(g.KK().KP() ? g.KK().Lc() : 0);
                }
                if (i == R.raw.playend && (g.KK().KP() || g.KK().KV())) {
                    kVar.setVolume(0.5f, 0.5f);
                }
                kVar.prepare();
                kVar.setLooping(false);
                kVar.start();
                if (System.currentTimeMillis() - this.tbj > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    this.tbh = 7;
                }
                AppMethodBeat.o(5109);
                return;
            } catch (Throwable th) {
                ab.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", th);
                this.tbh = 6;
                AppMethodBeat.o(5109);
                return;
            }
        }
        AppMethodBeat.o(5109);
    }

    public final void Gx(int i) {
        AppMethodBeat.i(5110);
        r(R.raw.playend, i, true);
        AppMethodBeat.o(5110);
    }

    public final int cLN() {
        AppMethodBeat.i(5111);
        ab.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.tbh);
        int i = this.tbh;
        AppMethodBeat.o(5111);
        return i;
    }
}
