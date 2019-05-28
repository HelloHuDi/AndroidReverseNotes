package com.tencent.p177mm.plugin.voip.p546ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.widget.C8415j;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.plugin.voip.p1417a.C40025b;
import com.tencent.p177mm.plugin.voip.video.CaptureView;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.voip.ui.VoipBaseFragment */
public abstract class VoipBaseFragment extends Fragment {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] sWo = new int[]{-1, C25738R.string.f6i, C25738R.string.f78, C25738R.string.f77};
    static int sWt = -1;
    protected String edV;
    protected C7306ak iGP;
    protected int mStatus = -1;
    protected boolean sRm;
    protected WeakReference<C46324c> sVY;
    protected long sVZ = -1;
    protected RelativeLayout sWp;
    protected ImageView sWq;
    protected ImageView sWr;
    protected int sWs = 4096;
    protected C40038d sWu;
    protected C40036c sWv = new C40036c();
    private C40035a sWw;
    private C40037b sWx;

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipBaseFragment$a */
    public class C40035a implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(4845);
            C4990ab.m7416i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
            Bitmap a = C41730b.m73490a(VoipBaseFragment.this.edV, false, -1);
            if (a == null || VoipBaseFragment.this.sWp == null) {
                AppMethodBeat.m2505o(4845);
                return;
            }
            int i = 0;
            while (true) {
                if ((VoipBaseFragment.this.sWp.getHeight() == 0 || VoipBaseFragment.this.sWp.getWidth() == 0) && i < 10) {
                    try {
                        Thread.sleep(300);
                        i++;
                    } catch (InterruptedException e) {
                        C4990ab.m7412e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
                        AppMethodBeat.m2505o(4845);
                        return;
                    }
                }
            }
            if (a.getHeight() <= a.getWidth() && a.getHeight() / 5 > 0 && ((int) (((double) a.getHeight()) * 0.6d)) > 0) {
                a = Bitmap.createBitmap(a, a.getWidth() / 5, a.getHeight() / 5, (int) (((double) a.getHeight()) * 0.6d), (int) (((double) a.getHeight()) * 0.6d), null, false);
            }
            a = C5056d.m7615a(a, a.getHeight(), (int) (((float) a.getHeight()) / ((1.0f * ((float) VoipBaseFragment.this.sWp.getHeight())) / ((float) VoipBaseFragment.this.sWp.getWidth()))), true, false);
            if (a == null) {
                C4990ab.m7412e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
                AppMethodBeat.m2505o(4845);
                return;
            }
            try {
                a = C5056d.m7660e(a, 20);
                C4990ab.m7416i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
                VoipBaseFragment.this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(4844);
                        if (VoipBaseFragment.this.sWq != null) {
                            VoipBaseFragment.this.sWq.setBackgroundDrawable(new BitmapDrawable(a));
                            VoipBaseFragment.this.sWq.getBackground().setAlpha(128);
                        }
                        VoipBaseFragment.this.sWw = null;
                        AppMethodBeat.m2505o(4844);
                    }
                });
                AppMethodBeat.m2505o(4845);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.VoipBaseFragment", "fastblur failed: " + e2.getMessage());
                AppMethodBeat.m2505o(4845);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipBaseFragment$c */
    protected static class C40036c {
        C7564ap gyS = new C7564ap(new C224661(), true);
        /* renamed from: sW */
        TextView f16190sW;
        int[] sWC;
        private int sWD;
        int sWE;

        /* renamed from: com.tencent.mm.plugin.voip.ui.VoipBaseFragment$c$1 */
        class C224661 implements C5015a {
            C224661() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(4848);
                int i = C40036c.this.sWC[C40036c.this.sWE % C40036c.this.sWC.length];
                if (C40036c.this.f16190sW != null) {
                    if (-1 == i) {
                        C40036c.this.f16190sW.setText(null);
                    } else {
                        C40036c.this.f16190sW.setText(i);
                    }
                }
                C40036c c40036c = C40036c.this;
                c40036c.sWE++;
                AppMethodBeat.m2505o(4848);
                return true;
            }
        }

        protected C40036c() {
            AppMethodBeat.m2504i(4849);
            AppMethodBeat.m2505o(4849);
        }

        /* renamed from: a */
        public final void mo63349a(TextView textView, int[] iArr) {
            AppMethodBeat.m2504i(4850);
            if (iArr == null || textView == null) {
                C4990ab.m7412e("MicroMsg.DynamicTextWrap", "textList or tv is null");
                AppMethodBeat.m2505o(4850);
                return;
            }
            cLc();
            this.sWE = 0;
            this.sWC = iArr;
            this.f16190sW = textView;
            this.sWD = 500;
            if (this.gyS != null) {
                long j = (long) this.sWD;
                this.gyS.mo16770ae(j, j);
            }
            C4990ab.m7408b("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(textView)), new Object[0]);
            AppMethodBeat.m2505o(4850);
        }

        public final void cLc() {
            AppMethodBeat.m2504i(4851);
            if (this.gyS != null) {
                this.gyS.stopTimer();
            }
            C4990ab.m7408b("MicroMsg.DynamicTextWrap", "stop textview: " + this.f16190sW, new Object[0]);
            this.f16190sW = null;
            AppMethodBeat.m2505o(4851);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipBaseFragment$b */
    public class C40037b implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(4847);
            C4990ab.m7416i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
            final Bitmap LV = C5056d.m7610LV(C25738R.drawable.bk7);
            C4990ab.m7416i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
            VoipBaseFragment.this.iGP.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(4846);
                    if (VoipBaseFragment.this.sWr != null) {
                        VoipBaseFragment.this.sWr.setBackgroundDrawable(new BitmapDrawable(LV));
                        VoipBaseFragment.this.sWr.getBackground().setAlpha(230);
                        VoipBaseFragment.this.sWr.getBackground().setFilterBitmap(true);
                    }
                    VoipBaseFragment.this.sWx = null;
                    AppMethodBeat.m2505o(4846);
                }
            });
            AppMethodBeat.m2505o(4847);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipBaseFragment$d */
    public interface C40038d {
        /* renamed from: S */
        void mo63352S(boolean z, boolean z2);
    }

    /* renamed from: GC */
    public abstract void mo56104GC(int i);

    /* renamed from: a */
    public abstract void mo56105a(CaptureView captureView);

    /* renamed from: a */
    public abstract void mo56106a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void abY(String str);

    /* renamed from: c */
    public abstract void mo56108c(int i, int i2, int[] iArr);

    public abstract void cJD();

    public abstract void cKY();

    public abstract void cKZ();

    /* renamed from: fZ */
    public abstract void mo56114fZ(int i, int i2);

    public abstract OpenGlRender getFilterData();

    /* renamed from: mz */
    public abstract void mo56116mz(boolean z);

    public abstract void setHWDecMode(int i);

    public abstract void setMute(boolean z);

    public abstract void setVoipBeauty(int i);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.edV = arguments.getString("key_username");
        this.sRm = arguments.getBoolean("key_isoutcall");
        if (-1 == this.mStatus) {
            this.mStatus = arguments.getInt("key_status");
        }
        this.iGP = new C7306ak();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Display defaultDisplay;
        if (VERSION.SDK_INT >= 23) {
            defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            mScreenWidth = displayMetrics.widthPixels;
            mScreenHeight = displayMetrics.heightPixels;
        } else if (mScreenWidth == 0) {
            defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            mScreenWidth = defaultDisplay.getWidth();
            mScreenHeight = defaultDisplay.getHeight();
        }
    }

    /* renamed from: fY */
    public void mo56113fY(int i, int i2) {
        C4990ab.m7409c("MicroMsg.VoipBaseFragment", "newState: " + C40025b.m68545GK(i2) + ", action: " + C40025b.m68545GK(i) + ", lastStatus: " + C40025b.m68545GK(sWt), new Object[0]);
        if (!(sWt == this.mStatus || i2 == this.mStatus)) {
            sWt = this.mStatus;
        }
        this.sWs = i;
        this.mStatus = i2;
    }

    /* renamed from: lI */
    public final void mo63347lI(long j) {
        this.sVZ = j;
    }

    public void uninit() {
        C4990ab.m7410d("MicroMsg.VoipBaseFragment", "uninit");
        this.sWv.cLc();
        C40036c c40036c = this.sWv;
        C4990ab.m7410d("MicroMsg.DynamicTextWrap", "uninit");
        c40036c.cLc();
        c40036c.gyS = null;
        if (this.sWw != null) {
            C7305d.xDG.remove(this.sWw);
            this.sWw = null;
        }
        if (this.sWx != null) {
            C7305d.xDG.remove(this.sWx);
            this.sWx = null;
        }
    }

    public void onDetach() {
        if (this.iGP != null) {
            this.iGP.removeCallbacksAndMessages(null);
        }
        this.sWu = null;
        super.onDetach();
    }

    public final void setVoipUIListener(C46324c c46324c) {
        this.sVY = new WeakReference(c46324c);
    }

    /* renamed from: a */
    public final void mo63343a(C40038d c40038d) {
        this.sWu = c40038d;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: j */
    public final void mo63346j(TextView textView) {
        if (textView == null) {
            C4990ab.m7412e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
            return;
        }
        textView.setText(C25738R.string.f77);
        textView.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, C8415j.INVALID_ID), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, C8415j.INVALID_ID));
        textView.setWidth(textView.getMeasuredWidth());
    }

    public void onStop() {
        super.onStop();
    }

    /* Access modifiers changed, original: protected|final */
    public final void cLa() {
        if (this.edV != null && this.sWq.getVisibility() != 0) {
            this.sWq.setVisibility(0);
            this.sWw = new C40035a();
            C7305d.post(this.sWw, "VoipBaseFragment_blurbitmap");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cLb() {
        this.sWr.setVisibility(0);
        this.sWx = new C40037b();
        C7305d.post(this.sWx, "VoipBaseFragment_blurtransparentbitmap");
    }

    /* renamed from: fQ */
    protected static String m68591fQ(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    /* renamed from: ae */
    protected static void m68589ae(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i;
            view.setLayoutParams(layoutParams);
        }
    }
}
