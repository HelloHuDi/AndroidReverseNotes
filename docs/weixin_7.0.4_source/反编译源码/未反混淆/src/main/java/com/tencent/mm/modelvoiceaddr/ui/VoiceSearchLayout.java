package com.tencent.mm.modelvoiceaddr.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class VoiceSearchLayout extends LinearLayout {
    private static final int[] gcc = new int[]{R.drawable.aro, R.drawable.arp, R.drawable.arq, R.drawable.arr, R.drawable.ar5, R.drawable.ar6, R.drawable.ar7, R.drawable.ar8, R.drawable.ar9, R.drawable.ar_, R.drawable.ara, R.drawable.arb, R.drawable.arc, R.drawable.ard};
    private static final int[] gcd = new int[]{R.drawable.aro, R.drawable.aro, R.drawable.aro, R.drawable.arp, R.drawable.arq, R.drawable.arp, R.drawable.aro, R.drawable.arr, R.drawable.aro, R.drawable.aro};
    private static final int[] gce = new int[]{R.drawable.are, R.drawable.arn, R.drawable.arn, R.drawable.arn, R.drawable.are};
    boolean cFy = false;
    private int from = 0;
    private View gbS = null;
    a gbT = null;
    private Button gbU;
    boolean gbV = false;
    int gbW = 0;
    private b gbX;
    private View gbY;
    private AnimationDrawable gbZ;
    f gca;
    private boolean gcb = false;
    private int gcf = 0;
    private int gcg = 0;
    int gch = 0;
    final ap gci = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(116764);
            if (VoiceSearchLayout.this.gca == null) {
                AppMethodBeat.o(116764);
            } else if (VoiceSearchLayout.this.gch < VoiceSearchLayout.gce.length) {
                VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.gce[VoiceSearchLayout.this.gch = VoiceSearchLayout.this.gch + 1]);
                AppMethodBeat.o(116764);
            } else {
                f a = VoiceSearchLayout.this.gca;
                ab.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + a.gaS);
                int i = a.gaS;
                a.gaS = 0;
                if (i > f.cri) {
                    f.cri = i;
                }
                ab.d("getMaxAmplitude", " map: " + i + " max:" + f.cri + " per:" + ((i * 100) / f.cri));
                int i2 = (i * 100) / f.cri;
                ab.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i2)));
                i = VoiceSearchLayout.this.from;
                if (VoiceSearchLayout.this.from == VoiceSearchLayout.this.gcf) {
                    if (i2 <= 10) {
                        VoiceSearchLayout.f(VoiceSearchLayout.this);
                        if (VoiceSearchLayout.this.gcg >= VoiceSearchLayout.gcd.length) {
                            VoiceSearchLayout.this.gcg = 0;
                        }
                        VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.gcd[VoiceSearchLayout.this.gcg]);
                        AppMethodBeat.o(116764);
                    } else {
                        i2 /= 5;
                        if (i2 >= VoiceSearchLayout.gcc.length) {
                            i2 = VoiceSearchLayout.gcc.length - 1;
                        }
                        ab.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i2)));
                        VoiceSearchLayout.this.gcf = i2;
                    }
                } else if (VoiceSearchLayout.this.from > VoiceSearchLayout.this.gcf) {
                    VoiceSearchLayout.i(VoiceSearchLayout.this);
                } else {
                    VoiceSearchLayout.j(VoiceSearchLayout.this);
                }
                VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.gcc[i]);
                AppMethodBeat.o(116764);
            }
            return true;
        }
    }, true);

    public interface b {
        void dd(boolean z);
    }

    public interface a {
        void a(boolean z, String[] strArr, long j);

        void amE();

        void amF();
    }

    static /* synthetic */ void a(VoiceSearchLayout voiceSearchLayout, int i) {
        AppMethodBeat.i(116782);
        voiceSearchLayout.setAmpImage(i);
        AppMethodBeat.o(116782);
    }

    static /* synthetic */ int f(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.gcg + 1;
        voiceSearchLayout.gcg = i;
        return i;
    }

    static /* synthetic */ int i(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.from - 1;
        voiceSearchLayout.from = i;
        return i;
    }

    static /* synthetic */ int j(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.from + 1;
        voiceSearchLayout.from = i;
        return i;
    }

    static /* synthetic */ void l(VoiceSearchLayout voiceSearchLayout) {
        AppMethodBeat.i(116784);
        voiceSearchLayout.dc(false);
        AppMethodBeat.o(116784);
    }

    public void setOnVisibleChangeListener(b bVar) {
        this.gbX = bVar;
    }

    public void setOnSearchListener(a aVar) {
        this.gbT = aVar;
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(116769);
        init(context);
        AppMethodBeat.o(116769);
    }

    public VoiceSearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(116770);
        init(context);
        AppMethodBeat.o(116770);
    }

    public VoiceSearchLayout(Context context) {
        super(context);
        AppMethodBeat.i(116771);
        init(context);
        AppMethodBeat.o(116771);
    }

    private void init(Context context) {
        AppMethodBeat.i(116772);
        this.gbS = inflate(context, R.layout.b28, this);
        this.gbU = (Button) this.gbS.findViewById(R.id.bzv);
        this.gbY = this.gbS.findViewById(R.id.f2a);
        setSearchStartBtnView(false);
        reset();
        AppMethodBeat.o(116772);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(116773);
        if (!this.gbV) {
            ab.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.cFy);
            if (this.cFy) {
                amA();
                this.cFy = false;
            }
        }
        AppMethodBeat.o(116773);
        return true;
    }

    public final void amA() {
        AppMethodBeat.i(116774);
        ab.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.cFy);
        if (this.cFy) {
            this.cFy = false;
            if (this.gbT != null) {
                this.gbT.amF();
            }
        }
        reset();
        if (getVisibility() == 0) {
            setVisibility(8);
            if (this.gbX != null) {
                this.gbX.dd(false);
            }
        }
        KY();
        if (this.gca != null) {
            this.gca.cancel();
        }
        if (this.gci != null) {
            this.gci.stopTimer();
        }
        AppMethodBeat.o(116774);
    }

    public final void reset() {
        AppMethodBeat.i(116775);
        setSearchStartBtnView(false);
        this.cFy = false;
        this.gbV = false;
        this.gbU.setBackgroundResource(R.drawable.ar4);
        AppMethodBeat.o(116775);
    }

    private void setSearchStartBtnView(boolean z) {
        AppMethodBeat.i(116776);
        if (z) {
            this.gbU.setBackgroundResource(R.drawable.a4u);
            this.gbZ = (AnimationDrawable) this.gbU.getBackground();
            if (this.gbZ != null) {
                this.gbZ.start();
                AppMethodBeat.o(116776);
                return;
            }
        }
        this.gbU.setBackgroundResource(R.drawable.ar4);
        AppMethodBeat.o(116776);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(116777);
        if (!(super.getVisibility() == i || this.gcb)) {
            Animation loadAnimation;
            if (i == 8) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.b6);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.b5);
            }
            startAnimation(loadAnimation);
            super.setVisibility(i);
            if (this.gbX != null) {
                this.gbX.dd(i == 0);
            }
        }
        AppMethodBeat.o(116777);
    }

    public void setTopMargin(int i) {
        AppMethodBeat.i(116778);
        LayoutParams layoutParams = (LayoutParams) this.gbY.getLayoutParams();
        layoutParams.topMargin = i;
        this.gbY.setLayoutParams(layoutParams);
        AppMethodBeat.o(116778);
    }

    private void setAmpImage(int i) {
        AppMethodBeat.i(116779);
        if (this.gbU != null) {
            this.gbU.setBackgroundResource(i);
        }
        AppMethodBeat.o(116779);
    }

    /* Access modifiers changed, original: final */
    public final void dc(boolean z) {
        AppMethodBeat.i(116780);
        if (z) {
            ab.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
            g.KK().KX();
        } else {
            KY();
        }
        k kVar = new k();
        if (z) {
            try {
                kVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131231777"));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                kVar.release();
                AppMethodBeat.o(116780);
                return;
            }
        }
        kVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131231735"));
        kVar.setAudioStreamType(5);
        kVar.setOnCompletionListener(new OnCompletionListener() {
            final /* synthetic */ a gck = null;

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(116765);
                mediaPlayer.release();
                AppMethodBeat.o(116765);
            }
        });
        kVar.setOnErrorListener(new OnErrorListener() {
            final /* synthetic */ a gck = null;

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        });
        kVar.prepare();
        kVar.setLooping(false);
        kVar.start();
        AppMethodBeat.o(116780);
    }

    private static void KY() {
        AppMethodBeat.i(116781);
        ab.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
        g.KK().KY();
        AppMethodBeat.o(116781);
    }

    static /* synthetic */ void k(VoiceSearchLayout voiceSearchLayout) {
        AppMethodBeat.i(116783);
        voiceSearchLayout.gbV = true;
        voiceSearchLayout.setSearchStartBtnView(true);
        AppMethodBeat.o(116783);
    }
}
