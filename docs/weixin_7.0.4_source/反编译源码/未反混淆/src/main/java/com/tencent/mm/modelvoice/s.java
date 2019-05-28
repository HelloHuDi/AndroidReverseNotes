package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class s implements d {
    boolean fZC;
    a fZI;
    b fZJ;
    String fileName;
    MediaPlayer gaq;
    com.tencent.mm.compatible.util.b gar;
    int status;

    public final int getStatus() {
        return this.status;
    }

    public s() {
        AppMethodBeat.i(55841);
        this.fileName = "";
        this.fZI = null;
        this.fZJ = null;
        this.status = 0;
        this.fZC = true;
        this.gaq = new k();
        amh();
        ami();
        ab.d("MicroMsg.VoicePlayer", "VoicePlayer");
        AppMethodBeat.o(55841);
    }

    public s(Context context) {
        this();
        AppMethodBeat.i(55842);
        this.gar = new com.tencent.mm.compatible.util.b(context);
        ab.d("MicroMsg.VoicePlayer", "VoicePlayer context");
        AppMethodBeat.o(55842);
    }

    public final void a(a aVar) {
        this.fZI = aVar;
    }

    public final void a(b bVar) {
        this.fZJ = bVar;
    }

    private void amh() {
        AppMethodBeat.i(55843);
        this.gaq.setOnCompletionListener(new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(55839);
                ab.d("MicroMsg.VoicePlayer", "OnCompletionListener");
                if (s.this.gar != null && s.this.fZC) {
                    ab.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
                    s.this.gar.Mm();
                }
                if (s.this.fZI != null) {
                    ab.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
                    s.this.fZI.EA();
                }
                try {
                    ab.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
                    s.this.gaq.release();
                    s.this.status = 0;
                    AppMethodBeat.o(55839);
                } catch (Exception e) {
                    ab.e("MicroMsg.VoicePlayer", "setCompletion File[" + s.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                    AppMethodBeat.o(55839);
                }
            }
        });
        AppMethodBeat.o(55843);
    }

    private void ami() {
        AppMethodBeat.i(55844);
        this.gaq.setOnErrorListener(new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(55840);
                ab.d("MicroMsg.VoicePlayer", "OnErrorListener");
                if (s.this.gar != null && s.this.fZC) {
                    ab.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
                    s.this.gar.Mm();
                }
                if (s.this.fZJ != null) {
                    ab.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
                    s.this.fZJ.onError();
                }
                try {
                    ab.d("MicroMsg.VoicePlayer", "OnErrorListener release");
                    s.this.gaq.release();
                    s.this.status = -1;
                } catch (Exception e) {
                    ab.e("MicroMsg.VoicePlayer", "setErrorListener File[" + s.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                }
                AppMethodBeat.o(55840);
                return false;
            }
        });
        AppMethodBeat.o(55844);
    }

    public final void bo(boolean z) {
        AppMethodBeat.i(55845);
        ab.d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(z)));
        if (this.gaq == null) {
            AppMethodBeat.o(55845);
        } else if (ax.Ex()) {
            ab.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
            AppMethodBeat.o(55845);
        } else {
            int currentPosition = this.gaq.getCurrentPosition();
            EH();
            this.gaq = new k();
            amh();
            ami();
            d(this.fileName, z, currentPosition);
            AppMethodBeat.o(55845);
        }
    }

    public final boolean S(String str, boolean z) {
        AppMethodBeat.i(55846);
        boolean d = d(str, z, 0);
        AppMethodBeat.o(55846);
        return d;
    }

    public final boolean c(String str, boolean z, int i) {
        AppMethodBeat.i(55847);
        boolean d = d(str, z, i);
        AppMethodBeat.o(55847);
        return d;
    }

    private boolean d(String str, boolean z, int i) {
        AppMethodBeat.i(55848);
        if (this.status != 0) {
            ab.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
            AppMethodBeat.o(55848);
            return false;
        }
        ab.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", Boolean.valueOf(z), Integer.valueOf(i));
        this.fileName = str;
        try {
            f(z, i);
        } catch (Exception e) {
            try {
                f(true, i);
            } catch (Exception e2) {
                ab.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
                ab.e("MicroMsg.VoicePlayer", "exception:%s", bo.l(e));
                this.status = -1;
                AppMethodBeat.o(55848);
                return false;
            }
        }
        this.status = 1;
        AppMethodBeat.o(55848);
        return true;
    }

    /* JADX WARNING: Missing block: B:9:0x0048, code skipped:
            if (com.tencent.mm.compatible.e.q.etd.epN == 1) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(boolean z, int i) {
        int i2 = 3;
        AppMethodBeat.i(55849);
        if (e.ct(this.fileName)) {
            try {
                ab.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(z ? 3 : 0));
                if (q.etd.epG) {
                    q.etd.dump();
                }
                i2 = r1;
                if (this.gar != null && this.fZC) {
                    ab.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
                    this.gar.requestFocus();
                }
                this.gaq.setAudioStreamType(i2);
                this.gaq.setDataSource(this.fileName);
                this.gaq.prepare();
                if (i > 0) {
                    this.gaq.seekTo(i);
                }
                this.gaq.start();
                AppMethodBeat.o(55849);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + e.getMessage());
                ab.e("MicroMsg.VoicePlayer", "exception:%s", bo.l(e));
                if (this.gar != null && this.fZC) {
                    this.gar.Mm();
                }
                AppMethodBeat.o(55849);
                return;
            }
        }
        AppMethodBeat.o(55849);
    }

    public final boolean bn(boolean z) {
        AppMethodBeat.i(55850);
        if (this.status != 1) {
            ab.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
            AppMethodBeat.o(55850);
            return false;
        }
        try {
            ab.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
            this.gaq.pause();
            if (this.gar != null && z && this.fZC) {
                ab.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
                this.gar.Mm();
            }
            this.status = 2;
            AppMethodBeat.o(55850);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
            this.status = -1;
            return false;
        } finally {
            if (this.gar != null && z && this.fZC) {
                ab.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
                this.gar.Mm();
            }
            AppMethodBeat.o(55850);
        }
    }

    public final boolean Ew() {
        AppMethodBeat.i(55851);
        if (this.status != 2) {
            ab.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
            AppMethodBeat.o(55851);
            return false;
        }
        try {
            ab.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
            this.gaq.start();
            if (this.gar != null && this.fZC) {
                ab.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
                this.gar.requestFocus();
            }
            this.status = 1;
            AppMethodBeat.o(55851);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
            this.status = -1;
            return false;
        } finally {
            if (this.gar != null && this.fZC) {
                ab.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
                this.gar.requestFocus();
            }
            AppMethodBeat.o(55851);
        }
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final boolean EH() {
        AppMethodBeat.i(55852);
        if (this.status == 1 || this.status == 2) {
            try {
                ab.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
                this.gaq.stop();
                this.gaq.release();
                if (this.gar != null && this.fZC) {
                    ab.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
                    this.gar.Mm();
                }
                this.status = 0;
                AppMethodBeat.o(55852);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                this.status = -1;
                return false;
            } finally {
                if (this.gar != null && this.fZC) {
                    ab.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
                    this.gar.Mm();
                }
                AppMethodBeat.o(55852);
            }
        } else {
            ab.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
            AppMethodBeat.o(55852);
            return false;
        }
    }

    public final double Ez() {
        AppMethodBeat.i(55853);
        if (this.status == 1 || this.status == 2) {
            try {
                int currentPosition = this.gaq.getCurrentPosition();
                int duration = this.gaq.getDuration();
                if (duration == 0) {
                    ab.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
                    AppMethodBeat.o(55853);
                    return 0.0d;
                }
                double d = ((double) currentPosition) / ((double) duration);
                AppMethodBeat.o(55853);
                return d;
            } catch (Exception e) {
                ab.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                EH();
                AppMethodBeat.o(55853);
                return 0.0d;
            }
        }
        AppMethodBeat.o(55853);
        return 0.0d;
    }

    public final void b(com.tencent.mm.compatible.util.b.a aVar) {
        AppMethodBeat.i(55854);
        if (!(this.gar == null || aVar == null)) {
            this.gar.a(aVar);
        }
        AppMethodBeat.o(55854);
    }

    public final void alP() {
        this.fZC = false;
    }
}
