package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.j;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;

public abstract class VoipBaseFragment extends Fragment {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] sWo = new int[]{-1, R.string.f6i, R.string.f78, R.string.f77};
    static int sWt = -1;
    protected String edV;
    protected ak iGP;
    protected int mStatus = -1;
    protected boolean sRm;
    protected WeakReference<c> sVY;
    protected long sVZ = -1;
    protected RelativeLayout sWp;
    protected ImageView sWq;
    protected ImageView sWr;
    protected int sWs = 4096;
    protected d sWu;
    protected c sWv = new c();
    private a sWw;
    private b sWx;

    public class a implements Runnable {
        public final void run() {
            AppMethodBeat.i(4845);
            ab.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
            Bitmap a = com.tencent.mm.ah.b.a(VoipBaseFragment.this.edV, false, -1);
            if (a == null || VoipBaseFragment.this.sWp == null) {
                AppMethodBeat.o(4845);
                return;
            }
            int i = 0;
            while (true) {
                if ((VoipBaseFragment.this.sWp.getHeight() == 0 || VoipBaseFragment.this.sWp.getWidth() == 0) && i < 10) {
                    try {
                        Thread.sleep(300);
                        i++;
                    } catch (InterruptedException e) {
                        ab.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
                        AppMethodBeat.o(4845);
                        return;
                    }
                }
            }
            if (a.getHeight() <= a.getWidth() && a.getHeight() / 5 > 0 && ((int) (((double) a.getHeight()) * 0.6d)) > 0) {
                a = Bitmap.createBitmap(a, a.getWidth() / 5, a.getHeight() / 5, (int) (((double) a.getHeight()) * 0.6d), (int) (((double) a.getHeight()) * 0.6d), null, false);
            }
            a = com.tencent.mm.sdk.platformtools.d.a(a, a.getHeight(), (int) (((float) a.getHeight()) / ((1.0f * ((float) VoipBaseFragment.this.sWp.getHeight())) / ((float) VoipBaseFragment.this.sWp.getWidth()))), true, false);
            if (a == null) {
                ab.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
                AppMethodBeat.o(4845);
                return;
            }
            try {
                a = com.tencent.mm.sdk.platformtools.d.e(a, 20);
                ab.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
                VoipBaseFragment.this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4844);
                        if (VoipBaseFragment.this.sWq != null) {
                            VoipBaseFragment.this.sWq.setBackgroundDrawable(new BitmapDrawable(a));
                            VoipBaseFragment.this.sWq.getBackground().setAlpha(128);
                        }
                        VoipBaseFragment.this.sWw = null;
                        AppMethodBeat.o(4844);
                    }
                });
                AppMethodBeat.o(4845);
            } catch (Exception e2) {
                ab.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + e2.getMessage());
                AppMethodBeat.o(4845);
            }
        }
    }

    protected static class c {
        ap gyS = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(4848);
                int i = c.this.sWC[c.this.sWE % c.this.sWC.length];
                if (c.this.sW != null) {
                    if (-1 == i) {
                        c.this.sW.setText(null);
                    } else {
                        c.this.sW.setText(i);
                    }
                }
                c cVar = c.this;
                cVar.sWE++;
                AppMethodBeat.o(4848);
                return true;
            }
        }, true);
        TextView sW;
        int[] sWC;
        private int sWD;
        int sWE;

        protected c() {
            AppMethodBeat.i(4849);
            AppMethodBeat.o(4849);
        }

        public final void a(TextView textView, int[] iArr) {
            AppMethodBeat.i(4850);
            if (iArr == null || textView == null) {
                ab.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
                AppMethodBeat.o(4850);
                return;
            }
            cLc();
            this.sWE = 0;
            this.sWC = iArr;
            this.sW = textView;
            this.sWD = 500;
            if (this.gyS != null) {
                long j = (long) this.sWD;
                this.gyS.ae(j, j);
            }
            ab.b("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(textView)), new Object[0]);
            AppMethodBeat.o(4850);
        }

        public final void cLc() {
            AppMethodBeat.i(4851);
            if (this.gyS != null) {
                this.gyS.stopTimer();
            }
            ab.b("MicroMsg.DynamicTextWrap", "stop textview: " + this.sW, new Object[0]);
            this.sW = null;
            AppMethodBeat.o(4851);
        }
    }

    public class b implements Runnable {
        public final void run() {
            AppMethodBeat.i(4847);
            ab.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
            final Bitmap LV = com.tencent.mm.sdk.platformtools.d.LV(R.drawable.bk7);
            ab.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
            VoipBaseFragment.this.iGP.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4846);
                    if (VoipBaseFragment.this.sWr != null) {
                        VoipBaseFragment.this.sWr.setBackgroundDrawable(new BitmapDrawable(LV));
                        VoipBaseFragment.this.sWr.getBackground().setAlpha(230);
                        VoipBaseFragment.this.sWr.getBackground().setFilterBitmap(true);
                    }
                    VoipBaseFragment.this.sWx = null;
                    AppMethodBeat.o(4846);
                }
            });
            AppMethodBeat.o(4847);
        }
    }

    public interface d {
        void S(boolean z, boolean z2);
    }

    public abstract void GC(int i);

    public abstract void a(CaptureView captureView);

    public abstract void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void abY(String str);

    public abstract void c(int i, int i2, int[] iArr);

    public abstract void cJD();

    public abstract void cKY();

    public abstract void cKZ();

    public abstract void fZ(int i, int i2);

    public abstract OpenGlRender getFilterData();

    public abstract void mz(boolean z);

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
        this.iGP = new ak();
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

    public void fY(int i, int i2) {
        ab.c("MicroMsg.VoipBaseFragment", "newState: " + com.tencent.mm.plugin.voip.a.b.GK(i2) + ", action: " + com.tencent.mm.plugin.voip.a.b.GK(i) + ", lastStatus: " + com.tencent.mm.plugin.voip.a.b.GK(sWt), new Object[0]);
        if (!(sWt == this.mStatus || i2 == this.mStatus)) {
            sWt = this.mStatus;
        }
        this.sWs = i;
        this.mStatus = i2;
    }

    public final void lI(long j) {
        this.sVZ = j;
    }

    public void uninit() {
        ab.d("MicroMsg.VoipBaseFragment", "uninit");
        this.sWv.cLc();
        c cVar = this.sWv;
        ab.d("MicroMsg.DynamicTextWrap", "uninit");
        cVar.cLc();
        cVar.gyS = null;
        if (this.sWw != null) {
            com.tencent.mm.sdk.g.d.xDG.remove(this.sWw);
            this.sWw = null;
        }
        if (this.sWx != null) {
            com.tencent.mm.sdk.g.d.xDG.remove(this.sWx);
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

    public final void setVoipUIListener(c cVar) {
        this.sVY = new WeakReference(cVar);
    }

    public final void a(d dVar) {
        this.sWu = dVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void j(TextView textView) {
        if (textView == null) {
            ab.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
            return;
        }
        textView.setText(R.string.f77);
        textView.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, j.INVALID_ID), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, j.INVALID_ID));
        textView.setWidth(textView.getMeasuredWidth());
    }

    public void onStop() {
        super.onStop();
    }

    /* Access modifiers changed, original: protected|final */
    public final void cLa() {
        if (this.edV != null && this.sWq.getVisibility() != 0) {
            this.sWq.setVisibility(0);
            this.sWw = new a();
            com.tencent.mm.sdk.g.d.post(this.sWw, "VoipBaseFragment_blurbitmap");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cLb() {
        this.sWr.setVisibility(0);
        this.sWx = new b();
        com.tencent.mm.sdk.g.d.post(this.sWx, "VoipBaseFragment_blurtransparentbitmap");
    }

    protected static String fQ(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    protected static void ae(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i;
            view.setLayoutParams(layoutParams);
        }
    }
}
