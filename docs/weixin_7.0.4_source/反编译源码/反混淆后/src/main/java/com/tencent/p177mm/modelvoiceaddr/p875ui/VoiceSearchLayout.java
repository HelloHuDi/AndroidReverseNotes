package com.tencent.p177mm.modelvoiceaddr.p875ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.modelvoiceaddr.C42235f;
import com.tencent.p177mm.modelvoiceaddr.C42235f.C42234b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout */
public class VoiceSearchLayout extends LinearLayout {
    private static final int[] gcc = new int[]{C25738R.drawable.aro, C25738R.drawable.arp, C25738R.drawable.arq, C25738R.drawable.arr, C25738R.drawable.ar5, C25738R.drawable.ar6, C25738R.drawable.ar7, C25738R.drawable.ar8, C25738R.drawable.ar9, C25738R.drawable.ar_, C25738R.drawable.ara, C25738R.drawable.arb, C25738R.drawable.arc, C25738R.drawable.ard};
    private static final int[] gcd = new int[]{C25738R.drawable.aro, C25738R.drawable.aro, C25738R.drawable.aro, C25738R.drawable.arp, C25738R.drawable.arq, C25738R.drawable.arp, C25738R.drawable.aro, C25738R.drawable.arr, C25738R.drawable.aro, C25738R.drawable.aro};
    private static final int[] gce = new int[]{C25738R.drawable.are, C25738R.drawable.arn, C25738R.drawable.arn, C25738R.drawable.arn, C25738R.drawable.are};
    boolean cFy = false;
    private int from = 0;
    private View gbS = null;
    C37969a gbT = null;
    private Button gbU;
    boolean gbV = false;
    int gbW = 0;
    private C32854b gbX;
    private View gbY;
    private AnimationDrawable gbZ;
    C42235f gca;
    private boolean gcb = false;
    private int gcf = 0;
    private int gcg = 0;
    int gch = 0;
    final C7564ap gci = new C7564ap(new C97541(), true);

    /* renamed from: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$1 */
    class C97541 implements C5015a {
        C97541() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(116764);
            if (VoiceSearchLayout.this.gca == null) {
                AppMethodBeat.m2505o(116764);
            } else if (VoiceSearchLayout.this.gch < VoiceSearchLayout.gce.length) {
                VoiceSearchLayout.m74569a(VoiceSearchLayout.this, VoiceSearchLayout.gce[VoiceSearchLayout.this.gch = VoiceSearchLayout.this.gch + 1]);
                AppMethodBeat.m2505o(116764);
            } else {
                C42235f a = VoiceSearchLayout.this.gca;
                C4990ab.m7410d("MicroMsg.SceneVoiceAddr", "cAmplitude " + a.gaS);
                int i = a.gaS;
                a.gaS = 0;
                if (i > C42235f.cri) {
                    C42235f.cri = i;
                }
                C4990ab.m7410d("getMaxAmplitude", " map: " + i + " max:" + C42235f.cri + " per:" + ((i * 100) / C42235f.cri));
                int i2 = (i * 100) / C42235f.cri;
                C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i2)));
                i = VoiceSearchLayout.this.from;
                if (VoiceSearchLayout.this.from == VoiceSearchLayout.this.gcf) {
                    if (i2 <= 10) {
                        VoiceSearchLayout.m74575f(VoiceSearchLayout.this);
                        if (VoiceSearchLayout.this.gcg >= VoiceSearchLayout.gcd.length) {
                            VoiceSearchLayout.this.gcg = 0;
                        }
                        VoiceSearchLayout.m74569a(VoiceSearchLayout.this, VoiceSearchLayout.gcd[VoiceSearchLayout.this.gcg]);
                        AppMethodBeat.m2505o(116764);
                    } else {
                        i2 /= 5;
                        if (i2 >= VoiceSearchLayout.gcc.length) {
                            i2 = VoiceSearchLayout.gcc.length - 1;
                        }
                        C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i2)));
                        VoiceSearchLayout.this.gcf = i2;
                    }
                } else if (VoiceSearchLayout.this.from > VoiceSearchLayout.this.gcf) {
                    VoiceSearchLayout.m74578i(VoiceSearchLayout.this);
                } else {
                    VoiceSearchLayout.m74579j(VoiceSearchLayout.this);
                }
                VoiceSearchLayout.m74569a(VoiceSearchLayout.this, VoiceSearchLayout.gcc[i]);
                AppMethodBeat.m2505o(116764);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$3 */
    class C97553 implements OnErrorListener {
        final /* synthetic */ C42238a gck = null;

        C97553() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$2 */
    class C265062 implements OnCompletionListener {
        final /* synthetic */ C42238a gck = null;

        C265062() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(116765);
            mediaPlayer.release();
            AppMethodBeat.m2505o(116765);
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$4 */
    class C265074 implements C42234b {
        C265074() {
        }

        public final void ams() {
            AppMethodBeat.m2504i(116766);
            VoiceSearchLayout.m74580k(VoiceSearchLayout.this);
            VoiceSearchLayout.m74581l(VoiceSearchLayout.this);
            if (VoiceSearchLayout.this.gci != null) {
                VoiceSearchLayout.this.gci.stopTimer();
            }
            AppMethodBeat.m2505o(116766);
        }

        /* renamed from: a */
        public final void mo44291a(String[] strArr, long j) {
            AppMethodBeat.m2504i(116767);
            try {
                C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
                if (strArr != null) {
                    C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + strArr.length + " " + strArr.toString());
                    for (Object valueOf : strArr) {
                        C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "search username  :".concat(String.valueOf(valueOf)));
                    }
                }
                VoiceSearchLayout.this.reset();
                VoiceSearchLayout.this.gbT.mo53424a(true, strArr, j);
                AppMethodBeat.m2505o(116767);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                AppMethodBeat.m2505o(116767);
            }
        }

        public final void amr() {
            AppMethodBeat.m2504i(116768);
            VoiceSearchLayout.this.reset();
            VoiceSearchLayout.this.gbT.mo53424a(false, null, -1);
            AppMethodBeat.m2505o(116768);
        }
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$b */
    public interface C32854b {
        /* renamed from: dd */
        void mo28001dd(boolean z);
    }

    /* renamed from: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$a */
    public interface C37969a {
        /* renamed from: a */
        void mo53424a(boolean z, String[] strArr, long j);

        void amE();

        void amF();
    }

    /* renamed from: a */
    static /* synthetic */ void m74569a(VoiceSearchLayout voiceSearchLayout, int i) {
        AppMethodBeat.m2504i(116782);
        voiceSearchLayout.setAmpImage(i);
        AppMethodBeat.m2505o(116782);
    }

    /* renamed from: f */
    static /* synthetic */ int m74575f(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.gcg + 1;
        voiceSearchLayout.gcg = i;
        return i;
    }

    /* renamed from: i */
    static /* synthetic */ int m74578i(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.from - 1;
        voiceSearchLayout.from = i;
        return i;
    }

    /* renamed from: j */
    static /* synthetic */ int m74579j(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.from + 1;
        voiceSearchLayout.from = i;
        return i;
    }

    /* renamed from: l */
    static /* synthetic */ void m74581l(VoiceSearchLayout voiceSearchLayout) {
        AppMethodBeat.m2504i(116784);
        voiceSearchLayout.mo67768dc(false);
        AppMethodBeat.m2505o(116784);
    }

    public void setOnVisibleChangeListener(C32854b c32854b) {
        this.gbX = c32854b;
    }

    public void setOnSearchListener(C37969a c37969a) {
        this.gbT = c37969a;
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(116769);
        init(context);
        AppMethodBeat.m2505o(116769);
    }

    public VoiceSearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(116770);
        init(context);
        AppMethodBeat.m2505o(116770);
    }

    public VoiceSearchLayout(Context context) {
        super(context);
        AppMethodBeat.m2504i(116771);
        init(context);
        AppMethodBeat.m2505o(116771);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(116772);
        this.gbS = VoiceSearchLayout.inflate(context, 2130971022, this);
        this.gbU = (Button) this.gbS.findViewById(2131824276);
        this.gbY = this.gbS.findViewById(2131828472);
        setSearchStartBtnView(false);
        reset();
        AppMethodBeat.m2505o(116772);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116773);
        if (!this.gbV) {
            C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "checkStop " + this.cFy);
            if (this.cFy) {
                amA();
                this.cFy = false;
            }
        }
        AppMethodBeat.m2505o(116773);
        return true;
    }

    public final void amA() {
        AppMethodBeat.m2504i(116774);
        C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "doCancel " + this.cFy);
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
                this.gbX.mo28001dd(false);
            }
        }
        VoiceSearchLayout.m74567KY();
        if (this.gca != null) {
            this.gca.cancel();
        }
        if (this.gci != null) {
            this.gci.stopTimer();
        }
        AppMethodBeat.m2505o(116774);
    }

    public final void reset() {
        AppMethodBeat.m2504i(116775);
        setSearchStartBtnView(false);
        this.cFy = false;
        this.gbV = false;
        this.gbU.setBackgroundResource(C25738R.drawable.ar4);
        AppMethodBeat.m2505o(116775);
    }

    private void setSearchStartBtnView(boolean z) {
        AppMethodBeat.m2504i(116776);
        if (z) {
            this.gbU.setBackgroundResource(C25738R.drawable.a4u);
            this.gbZ = (AnimationDrawable) this.gbU.getBackground();
            if (this.gbZ != null) {
                this.gbZ.start();
                AppMethodBeat.m2505o(116776);
                return;
            }
        }
        this.gbU.setBackgroundResource(C25738R.drawable.ar4);
        AppMethodBeat.m2505o(116776);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(116777);
        if (!(super.getVisibility() == i || this.gcb)) {
            Animation loadAnimation;
            if (i == 8) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8333b6);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8332b5);
            }
            startAnimation(loadAnimation);
            super.setVisibility(i);
            if (this.gbX != null) {
                this.gbX.mo28001dd(i == 0);
            }
        }
        AppMethodBeat.m2505o(116777);
    }

    public void setTopMargin(int i) {
        AppMethodBeat.m2504i(116778);
        LayoutParams layoutParams = (LayoutParams) this.gbY.getLayoutParams();
        layoutParams.topMargin = i;
        this.gbY.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(116778);
    }

    private void setAmpImage(int i) {
        AppMethodBeat.m2504i(116779);
        if (this.gbU != null) {
            this.gbU.setBackgroundResource(i);
        }
        AppMethodBeat.m2505o(116779);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dc */
    public final void mo67768dc(boolean z) {
        AppMethodBeat.m2504i(116780);
        if (z) {
            C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "pauseMusic");
            C1407g.m2946KK().mo4823KX();
        } else {
            VoiceSearchLayout.m74567KY();
        }
        C45289k c45289k = new C45289k();
        if (z) {
            try {
                c45289k.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131231777"));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                c45289k.release();
                AppMethodBeat.m2505o(116780);
                return;
            }
        }
        c45289k.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131231735"));
        c45289k.setAudioStreamType(5);
        c45289k.setOnCompletionListener(new C265062());
        c45289k.setOnErrorListener(new C97553());
        c45289k.prepare();
        c45289k.setLooping(false);
        c45289k.start();
        AppMethodBeat.m2505o(116780);
    }

    /* renamed from: KY */
    private static void m74567KY() {
        AppMethodBeat.m2504i(116781);
        C4990ab.m7410d("MicroMsg.VoiceSearchLayout", "resumeMusic");
        C1407g.m2946KK().mo4824KY();
        AppMethodBeat.m2505o(116781);
    }

    /* renamed from: k */
    static /* synthetic */ void m74580k(VoiceSearchLayout voiceSearchLayout) {
        AppMethodBeat.m2504i(116783);
        voiceSearchLayout.gbV = true;
        voiceSearchLayout.setSearchStartBtnView(true);
        AppMethodBeat.m2505o(116783);
    }
}
