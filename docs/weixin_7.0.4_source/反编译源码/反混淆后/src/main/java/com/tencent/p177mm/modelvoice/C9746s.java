package com.tencent.p177mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.compatible.util.C45293b.C32474a;
import com.tencent.p177mm.modelvoice.C26498d.C18718a;
import com.tencent.p177mm.modelvoice.C26498d.C26499b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5031ax;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.modelvoice.s */
public final class C9746s implements C26498d {
    boolean fZC;
    C18718a fZI;
    C26499b fZJ;
    String fileName;
    MediaPlayer gaq;
    C45293b gar;
    int status;

    /* renamed from: com.tencent.mm.modelvoice.s$1 */
    class C97471 implements OnCompletionListener {
        C97471() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(55839);
            C4990ab.m7410d("MicroMsg.VoicePlayer", "OnCompletionListener");
            if (C9746s.this.gar != null && C9746s.this.fZC) {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
                C9746s.this.gar.mo73178Mm();
            }
            if (C9746s.this.fZI != null) {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
                C9746s.this.fZI.mo33981EA();
            }
            try {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "OnCompletionListener release");
                C9746s.this.gaq.release();
                C9746s.this.status = 0;
                AppMethodBeat.m2505o(55839);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.VoicePlayer", "setCompletion File[" + C9746s.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                AppMethodBeat.m2505o(55839);
            }
        }
    }

    /* renamed from: com.tencent.mm.modelvoice.s$2 */
    class C97482 implements OnErrorListener {
        C97482() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(55840);
            C4990ab.m7410d("MicroMsg.VoicePlayer", "OnErrorListener");
            if (C9746s.this.gar != null && C9746s.this.fZC) {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
                C9746s.this.gar.mo73178Mm();
            }
            if (C9746s.this.fZJ != null) {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "OnErrorListener onError");
                C9746s.this.fZJ.onError();
            }
            try {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "OnErrorListener release");
                C9746s.this.gaq.release();
                C9746s.this.status = -1;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.VoicePlayer", "setErrorListener File[" + C9746s.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
            }
            AppMethodBeat.m2505o(55840);
            return false;
        }
    }

    public final int getStatus() {
        return this.status;
    }

    public C9746s() {
        AppMethodBeat.m2504i(55841);
        this.fileName = "";
        this.fZI = null;
        this.fZJ = null;
        this.status = 0;
        this.fZC = true;
        this.gaq = new C45289k();
        amh();
        ami();
        C4990ab.m7410d("MicroMsg.VoicePlayer", "VoicePlayer");
        AppMethodBeat.m2505o(55841);
    }

    public C9746s(Context context) {
        this();
        AppMethodBeat.m2504i(55842);
        this.gar = new C45293b(context);
        C4990ab.m7410d("MicroMsg.VoicePlayer", "VoicePlayer context");
        AppMethodBeat.m2505o(55842);
    }

    /* renamed from: a */
    public final void mo21076a(C18718a c18718a) {
        this.fZI = c18718a;
    }

    /* renamed from: a */
    public final void mo21077a(C26499b c26499b) {
        this.fZJ = c26499b;
    }

    private void amh() {
        AppMethodBeat.m2504i(55843);
        this.gaq.setOnCompletionListener(new C97471());
        AppMethodBeat.m2505o(55843);
    }

    private void ami() {
        AppMethodBeat.m2504i(55844);
        this.gaq.setOnErrorListener(new C97482());
        AppMethodBeat.m2505o(55844);
    }

    /* renamed from: bo */
    public final void mo21082bo(boolean z) {
        AppMethodBeat.m2504i(55845);
        C4990ab.m7410d("MicroMsg.VoicePlayer", "setSpeakerOn=".concat(String.valueOf(z)));
        if (this.gaq == null) {
            AppMethodBeat.m2505o(55845);
        } else if (C5031ax.m7487Ex()) {
            C4990ab.m7418v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
            AppMethodBeat.m2505o(55845);
        } else {
            int currentPosition = this.gaq.getCurrentPosition();
            mo21072EH();
            this.gaq = new C45289k();
            amh();
            ami();
            m17386d(this.fileName, z, currentPosition);
            AppMethodBeat.m2505o(55845);
        }
    }

    /* renamed from: S */
    public final boolean mo21075S(String str, boolean z) {
        AppMethodBeat.m2504i(55846);
        boolean d = m17386d(str, z, 0);
        AppMethodBeat.m2505o(55846);
        return d;
    }

    /* renamed from: c */
    public final boolean mo21083c(String str, boolean z, int i) {
        AppMethodBeat.m2504i(55847);
        boolean d = m17386d(str, z, i);
        AppMethodBeat.m2505o(55847);
        return d;
    }

    /* renamed from: d */
    private boolean m17386d(String str, boolean z, int i) {
        AppMethodBeat.m2504i(55848);
        if (this.status != 0) {
            C4990ab.m7412e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
            AppMethodBeat.m2505o(55848);
            return false;
        }
        C4990ab.m7417i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", Boolean.valueOf(z), Integer.valueOf(i));
        this.fileName = str;
        try {
            m17387f(z, i);
        } catch (Exception e) {
            try {
                m17387f(true, i);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
                C4990ab.m7413e("MicroMsg.VoicePlayer", "exception:%s", C5046bo.m7574l(e));
                this.status = -1;
                AppMethodBeat.m2505o(55848);
                return false;
            }
        }
        this.status = 1;
        AppMethodBeat.m2505o(55848);
        return true;
    }

    /* JADX WARNING: Missing block: B:9:0x0048, code skipped:
            if (com.tencent.p177mm.compatible.p221e.C1427q.etd.epN == 1) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    private void m17387f(boolean z, int i) {
        int i2 = 3;
        AppMethodBeat.m2504i(55849);
        if (C5730e.m8628ct(this.fileName)) {
            try {
                C4990ab.m7411d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(z ? 3 : 0));
                if (C1427q.etd.epG) {
                    C1427q.etd.dump();
                }
                i2 = r1;
                if (this.gar != null && this.fZC) {
                    C4990ab.m7410d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
                    this.gar.requestFocus();
                }
                this.gaq.setAudioStreamType(i2);
                this.gaq.setDataSource(this.fileName);
                this.gaq.prepare();
                if (i > 0) {
                    this.gaq.seekTo(i);
                }
                this.gaq.start();
                AppMethodBeat.m2505o(55849);
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + e.getMessage());
                C4990ab.m7413e("MicroMsg.VoicePlayer", "exception:%s", C5046bo.m7574l(e));
                if (this.gar != null && this.fZC) {
                    this.gar.mo73178Mm();
                }
                AppMethodBeat.m2505o(55849);
                return;
            }
        }
        AppMethodBeat.m2505o(55849);
    }

    /* renamed from: bn */
    public final boolean mo21081bn(boolean z) {
        AppMethodBeat.m2504i(55850);
        if (this.status != 1) {
            C4990ab.m7412e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
            AppMethodBeat.m2505o(55850);
            return false;
        }
        try {
            C4990ab.m7410d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
            this.gaq.pause();
            if (this.gar != null && z && this.fZC) {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
                this.gar.mo73178Mm();
            }
            this.status = 2;
            AppMethodBeat.m2505o(55850);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.VoicePlayer", "pause File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
            this.status = -1;
            return false;
        } finally {
            if (this.gar != null && z && this.fZC) {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
                this.gar.mo73178Mm();
            }
            AppMethodBeat.m2505o(55850);
        }
    }

    /* renamed from: Ew */
    public final boolean mo21073Ew() {
        AppMethodBeat.m2504i(55851);
        if (this.status != 2) {
            C4990ab.m7412e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
            AppMethodBeat.m2505o(55851);
            return false;
        }
        try {
            C4990ab.m7410d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
            this.gaq.start();
            if (this.gar != null && this.fZC) {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
                this.gar.requestFocus();
            }
            this.status = 1;
            AppMethodBeat.m2505o(55851);
            return true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.VoicePlayer", "resume File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
            this.status = -1;
            return false;
        } finally {
            if (this.gar != null && this.fZC) {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
                this.gar.requestFocus();
            }
            AppMethodBeat.m2505o(55851);
        }
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    /* renamed from: EH */
    public final boolean mo21072EH() {
        AppMethodBeat.m2504i(55852);
        if (this.status == 1 || this.status == 2) {
            try {
                C4990ab.m7410d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
                this.gaq.stop();
                this.gaq.release();
                if (this.gar != null && this.fZC) {
                    C4990ab.m7410d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
                    this.gar.mo73178Mm();
                }
                this.status = 0;
                AppMethodBeat.m2505o(55852);
                return true;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.VoicePlayer", "stop File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                this.status = -1;
                return false;
            } finally {
                if (this.gar != null && this.fZC) {
                    C4990ab.m7410d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
                    this.gar.mo73178Mm();
                }
                AppMethodBeat.m2505o(55852);
            }
        } else {
            C4990ab.m7412e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
            AppMethodBeat.m2505o(55852);
            return false;
        }
    }

    /* renamed from: Ez */
    public final double mo21074Ez() {
        AppMethodBeat.m2504i(55853);
        if (this.status == 1 || this.status == 2) {
            try {
                int currentPosition = this.gaq.getCurrentPosition();
                int duration = this.gaq.getDuration();
                if (duration == 0) {
                    C4990ab.m7412e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
                    AppMethodBeat.m2505o(55853);
                    return 0.0d;
                }
                double d = ((double) currentPosition) / ((double) duration);
                AppMethodBeat.m2505o(55853);
                return d;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                mo21072EH();
                AppMethodBeat.m2505o(55853);
                return 0.0d;
            }
        }
        AppMethodBeat.m2505o(55853);
        return 0.0d;
    }

    /* renamed from: b */
    public final void mo21080b(C32474a c32474a) {
        AppMethodBeat.m2504i(55854);
        if (!(this.gar == null || c32474a == null)) {
            this.gar.mo73179a(c32474a);
        }
        AppMethodBeat.m2505o(55854);
    }

    public final void alP() {
        this.fZC = false;
    }
}
