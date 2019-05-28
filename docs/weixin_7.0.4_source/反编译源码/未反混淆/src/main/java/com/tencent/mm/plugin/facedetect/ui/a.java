package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.k.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public class a {
    private static b lWK = new b();
    private Button lWA = null;
    private ImageView lWB = null;
    private TextView lWC = null;
    private TextView lWD = null;
    private Button lWE = null;
    private Button lWF = null;
    private TextView lWG = null;
    private Animation lWH = null;
    private Animation lWI = null;
    protected WeakReference<FaceDetectPrepareUI> lWJ = null;
    private RelativeLayout lWz = null;

    public static class b extends CountDownTimer {
        WeakReference<TextView> lWO = null;
        WeakReference<TextView> lWP = null;
        String lWQ = null;
        int lWR = 0;
        int lWS = 0;

        public b() {
            super(Long.MAX_VALUE, 500);
        }

        public final void onTick(long j) {
            AppMethodBeat.i(385);
            if (this.lWO == null || this.lWO.get() == null || this.lWP == null || this.lWP.get() == null) {
                ab.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
                cancel();
            } else {
                TextView textView = (TextView) this.lWP.get();
                ((TextView) this.lWO.get()).setText(this.lWQ.substring(0, this.lWR));
                textView.setText(this.lWQ.substring(this.lWR, this.lWR + (this.lWS % ((this.lWQ.length() - this.lWR) + 1))));
            }
            this.lWS++;
            AppMethodBeat.o(385);
        }

        public final void onFinish() {
        }
    }

    interface a {
    }

    static {
        AppMethodBeat.i(398);
        AppMethodBeat.o(398);
    }

    a(FaceDetectPrepareUI faceDetectPrepareUI) {
        AppMethodBeat.i(386);
        this.lWJ = new WeakReference(faceDetectPrepareUI);
        AppMethodBeat.o(386);
    }

    public void create() {
        AppMethodBeat.i(387);
        synchronized (((FaceDetectPrepareUI) this.lWJ.get())) {
            try {
                if (this.lWJ.get() != null) {
                    this.lWz = (RelativeLayout) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bmx);
                    this.lWA = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.ay8);
                    this.lWB = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bmz);
                    this.lWC = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bn0);
                    this.lWH = AnimationUtils.loadAnimation((Context) this.lWJ.get(), R.anim.n);
                    this.lWI = AnimationUtils.loadAnimation((Context) this.lWJ.get(), R.anim.o);
                    this.lWE = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bn4);
                    this.lWF = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bn2);
                    this.lWD = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bn1);
                    this.lWG = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bn3);
                    this.lWH.setDuration(500);
                    this.lWI.setDuration(500);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(387);
            }
        }
    }

    public void dismiss() {
        AppMethodBeat.i(n.CTRL_INDEX);
        ab.c("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
        lWK.cancel();
        if (this.lWz.getVisibility() == 0) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(383);
                    a.this.lWI.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(382);
                            a.this.lWz.setVisibility(8);
                            AppMethodBeat.o(382);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    a.this.lWz.startAnimation(a.this.lWI);
                    AppMethodBeat.o(383);
                }
            });
        }
        AppMethodBeat.o(n.CTRL_INDEX);
    }

    public void M(Bitmap bitmap) {
        AppMethodBeat.i(t.CTRL_INDEX);
        this.lWz.setBackgroundDrawable(new BitmapDrawable(bitmap));
        AppMethodBeat.o(t.CTRL_INDEX);
    }

    public void resetAll() {
        AppMethodBeat.i(390);
        if (lWK != null) {
            lWK.cancel();
        }
        this.lWE.setVisibility(4);
        this.lWA.setVisibility(4);
        this.lWF.setVisibility(4);
        this.lWD.setVisibility(4);
        this.lWC.setVisibility(4);
        AppMethodBeat.o(390);
    }

    public void a(final c cVar) {
        AppMethodBeat.i(391);
        if (lWK != null) {
            lWK.cancel();
        }
        if (cVar == null) {
            AppMethodBeat.o(391);
            return;
        }
        ab.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", cVar.toString());
        if (cVar.lYz) {
            ab.i("MicroMsg.FaceDetectJumper", " mCancelBtn VISIBLE");
            this.lWE.setVisibility(0);
            this.lWE.setText(cVar.lYI);
            this.lWE.setOnClickListener(cVar.lYP);
        } else {
            this.lWE.setVisibility(4);
        }
        if (cVar.lYw) {
            ab.i("MicroMsg.FaceDetectJumper", " isShowMainButton VISIBLE");
            this.lWA.setVisibility(0);
            this.lWA.setText(cVar.lYG);
            this.lWA.setOnClickListener(cVar.lYM);
        } else {
            this.lWA.setVisibility(4);
        }
        if (cVar.lYA) {
            ab.i("MicroMsg.FaceDetectJumper", " mSubBtn VISIBLE");
            this.lWF.setVisibility(0);
            this.lWF.setText(cVar.lYH);
            this.lWF.setOnClickListener(cVar.lYN);
        } else {
            this.lWF.setVisibility(4);
        }
        if (cVar.lYx) {
            ab.i("MicroMsg.FaceDetectJumper", " isShowStatusWordingTv VISIBLE");
            this.lWC.setVisibility(0);
            if (cVar.lYB) {
                ab.i("MicroMsg.FaceDetectJumper", " isShowOneByOne VISIBLE");
                this.lWD.setVisibility(0);
                int i = cVar.lYD;
                String str = cVar.lYF;
                if (bo.isNullOrNil(str) || i >= str.length() || i < 0) {
                    ab.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
                    this.lWC.setText(str);
                    this.lWD.setText("");
                } else {
                    lWK.cancel();
                    b bVar = lWK;
                    WeakReference weakReference = new WeakReference(this.lWC);
                    WeakReference weakReference2 = new WeakReference(this.lWD);
                    bVar.lWQ = str;
                    bVar.lWR = i;
                    bVar.lWO = weakReference;
                    bVar.lWP = weakReference2;
                    lWK.start();
                }
            } else {
                ab.i("MicroMsg.FaceDetectJumper", " imTweekyTv VISIBLE");
                this.lWD.setVisibility(4);
                this.lWC.setText(cVar.lYF);
            }
        } else {
            ab.i("MicroMsg.FaceDetectJumper", " mStatusWordingTV VISIBLE");
            this.lWC.setVisibility(4);
            this.lWD.setVisibility(4);
        }
        if (cVar.lYy) {
            ab.i("MicroMsg.FaceDetectJumper", " mStatusIv VISIBLE");
            this.lWB.setVisibility(0);
            this.lWB.setImageResource(cVar.lYJ);
        } else {
            this.lWB.setVisibility(4);
        }
        if (cVar.lYC) {
            ab.i("MicroMsg.FaceDetectJumper", " mFeedbackTv VISIBLE");
            this.lWG.setVisibility(0);
            this.lWG.setText(cVar.lYK);
            this.lWG.setOnClickListener(cVar.lYO);
        } else {
            this.lWG.setVisibility(4);
        }
        if (cVar.lYE != null) {
            ab.i("MicroMsg.FaceDetectJumper", "bgBm：：%s ", cVar.lYE);
            this.lWz.setBackgroundDrawable(new BitmapDrawable(cVar.lYE));
        }
        ab.i("MicroMsg.FaceDetectJumper", "show jumper, visible: %s", Integer.valueOf(this.lWz.getVisibility()));
        if (this.lWz.getVisibility() != 0) {
            this.lWz.setVisibility(0);
            this.lWz.startAnimation(this.lWH);
            this.lWH.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(384);
                    ab.i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.o(384);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        AppMethodBeat.o(391);
    }

    public boolean aFF() {
        AppMethodBeat.i(392);
        if (this.lWz.getVisibility() != 8) {
            AppMethodBeat.o(392);
            return true;
        }
        AppMethodBeat.o(392);
        return false;
    }

    public static c bti() {
        AppMethodBeat.i(393);
        c b = b(R.drawable.b3x, null, null, null, null, null);
        AppMethodBeat.o(393);
        return b;
    }

    public static c a(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(394);
        c b = b(i, str, str2, str3, onClickListener, onClickListener2);
        AppMethodBeat.o(394);
        return b;
    }

    public static c b(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.i(b.CTRL_INDEX);
        c c = c(i, str, str2, str3, onClickListener, onClickListener2);
        AppMethodBeat.o(b.CTRL_INDEX);
        return c;
    }

    private static c c(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(396);
        c cVar = new c();
        cVar.lYJ = i;
        cVar.lYF = str;
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        cVar.lYw = z;
        cVar.lYG = str2;
        cVar.lYA = false;
        cVar.lYH = null;
        if (str3 == null) {
            z2 = false;
        }
        cVar.lYz = z2;
        cVar.lYI = str3;
        cVar.lYC = false;
        cVar.lYK = null;
        cVar.lYM = onClickListener;
        cVar.lYN = null;
        cVar.lYP = onClickListener2;
        cVar.lYO = null;
        AppMethodBeat.o(396);
        return cVar;
    }

    public static c a(c cVar, String str, OnClickListener onClickListener) {
        boolean z;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        cVar.lYC = z;
        cVar.lYK = str;
        cVar.lYO = onClickListener;
        return cVar;
    }

    public static c a(Context context, OnClickListener onClickListener) {
        AppMethodBeat.i(397);
        c a = a(R.drawable.b31, context.getString(R.string.bkl), null, context.getString(R.string.or), null, onClickListener);
        a.lYB = true;
        a.lYD = context.getString(R.string.bkl).length() - 3;
        AppMethodBeat.o(397);
        return a;
    }
}
