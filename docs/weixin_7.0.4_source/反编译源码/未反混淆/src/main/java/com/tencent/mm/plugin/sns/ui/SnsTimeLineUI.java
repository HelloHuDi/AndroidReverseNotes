package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.i;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.vending.h.d;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.ActUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@i
public class SnsTimeLineUI extends WxPresenterActivity implements f, ar, com.tencent.mm.plugin.sns.b.h.a, t {
    private static Handler h = new Handler(rzk.getLooper());
    public static final Boolean rza = Boolean.FALSE;
    private static HandlerThread rzk;
    private static final Set<Activity> sUILeaksRoutineEnsuranceRef = new HashSet();
    private long eEO;
    private int ehv;
    private long fAq;
    private String hcl;
    private String igi;
    private ActionBar mActionBar;
    private int mScreenHeight;
    private int mScreenWidth;
    private SnsUIAction mUIAction;
    private com.tencent.matrix.trace.e.b mnM;
    private int oOX;
    private long oes;
    private View plv;
    private com.tencent.mm.ui.statusbar.c.a plx;
    private com.tencent.mm.sdk.b.c qMM;
    private boolean qQu;
    private boolean rhv;
    private boolean rjn;
    protected g rqn;
    private av ryA;
    private at ryB;
    private String ryC;
    private boolean ryD;
    private int ryE;
    private String ryF;
    private String ryG;
    private c ryH;
    private Runnable ryI;
    private com.tencent.mm.sdk.b.c ryJ;
    private com.tencent.mm.sdk.b.c ryK;
    private boolean ryL;
    private com.tencent.mm.sdk.b.c ryM;
    private com.tencent.mm.sdk.b.c ryN;
    private com.tencent.mm.sdk.b.c ryO;
    private com.tencent.mm.sdk.b.c ryP;
    private com.tencent.mm.sdk.b.c ryQ;
    private com.tencent.mm.sdk.b.c ryR;
    private com.tencent.mm.sdk.b.c ryS;
    private com.tencent.mm.sdk.b.c ryT;
    private com.tencent.mm.sdk.b.c ryU;
    private com.tencent.mm.sdk.b.c ryV;
    private com.tencent.mm.sdk.b.c ryW;
    private com.tencent.mm.sdk.b.c ryX;
    private com.tencent.mm.sdk.b.c ryY;
    private com.tencent.mm.sdk.b.c ryZ;
    private final long ryi = 300;
    private long ryj = SystemClock.elapsedRealtime();
    private com.tencent.mm.plugin.sns.k.b ryk = ((com.tencent.mm.plugin.sns.k.b) V(com.tencent.mm.plugin.sns.k.b.class));
    private com.tencent.mm.plugin.sns.k.a ryl;
    private com.tencent.mm.plugin.sns.ui.a.a.b rym;
    private com.tencent.mm.plugin.sns.ui.a.a ryn;
    private LinearLayout ryo;
    private LinearLayout ryp;
    private QFadeImageView ryq;
    private boolean ryr;
    private boolean rys;
    private i ryt;
    private a ryu;
    private TestTimeForSns ryv;
    private int ryw;
    private boolean ryx;
    private String ryy;
    private com.tencent.mm.plugin.sns.i.a ryz;
    private long rzb;
    boolean rzc;
    Runnable rzd;
    Runnable rze;
    private Handler rzf;
    private Runnable rzg;
    private com.tencent.mm.plugin.sns.ui.SnsUIAction.a rzh;
    private com.tencent.mm.vending.app.a.b rzi;
    boolean rzj;
    int rzl;
    private OnMenuItemClickListener rzm;
    private ImageView rzn;
    private View rzo;
    private ax rzp;
    private OnClickListener rzq;
    private boolean rzr;

    class a extends Animation {
        int DELAY_TIME = 600;
        private ListView nDp;
        float rAa = 0.0f;
        float rAb = 0.0f;
        float rAc = 0.0f;
        float rAd = 0.0f;
        private float rzM;
        private float rzN;
        float rzO = -1.0f;
        float rzP;
        private float rzQ = 50.0f;
        private float rzR = 10.0f;
        float rzS = 0.0f;
        private float rzT = 0.0f;
        private float rzU;
        private float rzV;
        boolean rzW;
        int rzX;
        boolean rzY = false;
        int rzZ = 0;

        public a(ListView listView) {
            this.nDp = listView;
        }

        public final void bb(float f) {
            AppMethodBeat.i(39542);
            if (this.nDp != null) {
                if (this.nDp.getFirstVisiblePosition() != 0) {
                    SnsTimeLineUI.b(SnsTimeLineUI.this, 8);
                } else if (SnsTimeLineUI.this.mUIAction.qQt.getTop() >= SnsTimeLineUI.this.ryu.rzX) {
                    SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
                }
            }
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", Float.valueOf(f), Float.valueOf(this.rzP), Float.valueOf(this.rzO));
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.o(39542);
                return;
            }
            SnsTimeLineUI.this.ryq.clearAnimation();
            init();
            if (f <= (-this.rzQ)) {
                f = -this.rzQ;
            }
            if (f >= this.rzQ) {
                f = this.rzQ;
            }
            if (f < 0.0f) {
                this.rzS -= f * 2.0f;
            } else {
                this.rzS -= f / 2.0f;
            }
            float f2 = this.rzS;
            if (f2 < this.rzP) {
                f2 = this.rzP;
                this.rzS = this.rzP;
            }
            if (f2 > this.rzO) {
                f2 = this.rzO;
                this.rzS = this.rzO;
            }
            float f3 = f2;
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", Float.valueOf(f), Float.valueOf(this.rzP), Float.valueOf(this.rzO), Float.valueOf(this.rzS), Float.valueOf(f3), Float.valueOf(this.rzQ));
            }
            if (f3 == this.rzO) {
                f2 = f * 2.0f;
            } else {
                f2 = 5.0f * f;
            }
            SnsTimeLineUI.this.ryq.setScaleType(com.tencent.mm.ui.widget.QImageView.a.MATRIX);
            SnsTimeLineUI.this.ryq.getImageMatrix().postRotate(f2, this.rzM, this.rzN);
            SnsTimeLineUI.this.ryq.setImageResource(R.raw.friendactivity_refresh);
            LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
            layoutParams.y = (int) f3;
            SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
            SnsTimeLineUI.this.ryq.invalidate();
            AppMethodBeat.o(39542);
        }

        public final void cur() {
            AppMethodBeat.i(39543);
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.d("MicroMsg.RefreshAnim", "animtest playLoading");
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.o(39543);
                return;
            }
            init();
            this.rzS = this.rzO + 20.0f;
            LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
            layoutParams.y = (int) this.rzO;
            SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
            cut();
            AppMethodBeat.o(39543);
        }

        public final void cus() {
            AppMethodBeat.i(39544);
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", Integer.valueOf(SnsTimeLineUI.this.ryq.getVisibility()), Float.valueOf(this.rzS), Float.valueOf(this.rzO));
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.o(39544);
                return;
            }
            init();
            if (this.rzS < this.rzO - this.rzR) {
                AppMethodBeat.o(39544);
                return;
            }
            SnsTimeLineUI.this.ryq.clearAnimation();
            kK((long) (this.DELAY_TIME + 100));
            SnsTimeLineUI.this.ryq.startAnimation(this);
            this.rzW = false;
            AppMethodBeat.o(39544);
        }

        /* Access modifiers changed, original: final */
        public final void kK(long j) {
            AppMethodBeat.i(39545);
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", Long.valueOf(j), bo.dpG().toString());
            }
            setDuration(j);
            AppMethodBeat.o(39545);
        }

        public final void cut() {
            AppMethodBeat.i(39546);
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.o(39546);
                return;
            }
            init();
            SnsTimeLineUI.this.ryq.clearAnimation();
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", Float.valueOf(this.rzS), Float.valueOf(this.rzO), bo.dpG().toString());
            }
            SnsTimeLineUI.this.ryq.startAnimation(this);
            if (this.rzS >= this.rzO - this.rzR) {
                kK(20000);
                this.rzW = false;
                AppMethodBeat.o(39546);
                return;
            }
            kK((long) (this.DELAY_TIME + 100));
            this.rzW = true;
            AppMethodBeat.o(39546);
        }

        /* Access modifiers changed, original: final */
        public final void init() {
            AppMethodBeat.i(39547);
            if (this.rzO == -1.0f || ((double) this.rzN) < 0.1d) {
                this.rzO = (float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(SnsTimeLineUI.this, 70.0f);
                this.rzQ = (float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(SnsTimeLineUI.this, 16.0f);
                this.rzM = (float) (SnsTimeLineUI.this.ryq.getWidth() / 2);
                this.rzN = (float) (SnsTimeLineUI.this.ryq.getHeight() / 2);
                this.rzT = (float) ((-SnsTimeLineUI.this.ryq.getHeight()) * 2);
                if (this.rzT == 0.0f) {
                    this.rzT = (float) (-com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(SnsTimeLineUI.this, 40.0f));
                }
                this.rzP = this.rzT;
                if (SnsTimeLineUI.rza.booleanValue()) {
                    ab.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", Float.valueOf(this.rzP), Float.valueOf(this.rzO), Float.valueOf(this.rzT), Float.valueOf(this.rzQ));
                }
                this.rzS = this.rzP;
                if (!this.rzY) {
                    if (SnsTimeLineUI.rza.booleanValue()) {
                        ab.i("MicroMsg.RefreshAnim", "initState");
                    }
                    this.rzZ = ((LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams()).y;
                    this.rAa = this.rzO;
                    this.rAb = this.rzS;
                }
                this.rzY = true;
            }
            AppMethodBeat.o(39547);
        }

        /* Access modifiers changed, original: protected|final */
        public final void applyTransformation(float f, Transformation transformation) {
            AppMethodBeat.i(39548);
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", Integer.valueOf(SnsTimeLineUI.this.ryq.getVisibility()), Float.valueOf(f), Boolean.valueOf(this.rzW));
            }
            if (SnsTimeLineUI.this.ryq.getVisibility() != 0) {
                AppMethodBeat.o(39548);
                return;
            }
            float duration = (f - this.rzU) * ((float) getDuration());
            if (duration < 2.0f) {
                if (SnsTimeLineUI.rza.booleanValue()) {
                    ab.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", Float.valueOf(duration));
                }
                AppMethodBeat.o(39548);
                return;
            }
            this.rzU = f;
            SnsTimeLineUI.this.ryq.setImageResource(R.raw.friendactivity_refresh);
            SnsTimeLineUI.this.ryq.setScaleType(com.tencent.mm.ui.widget.QImageView.a.MATRIX);
            if (((float) getDuration()) * f >= ((float) (getDuration() - ((long) this.DELAY_TIME))) || this.rzW) {
                LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
                if (((float) layoutParams.y) <= this.rzT) {
                    AppMethodBeat.o(39548);
                    return;
                }
                if (this.rAc == 0.0f) {
                    this.rAc = (-this.rzT) + ((float) layoutParams.y);
                    this.rAd = (float) layoutParams.y;
                    this.rzV = f;
                }
                float f2 = this.rAd - (this.rAc * ((f - this.rzV) / (1.0f - this.rzV)));
                if (SnsTimeLineUI.rza.booleanValue()) {
                    ab.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(r1), Float.valueOf(r2), Float.valueOf(this.rzV * ((float) getDuration())));
                }
                if (((float) layoutParams.y) > f2) {
                    layoutParams.y = (int) f2;
                }
                this.rzS = (float) layoutParams.y;
                SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
            } else {
                if (SnsTimeLineUI.rza.booleanValue()) {
                    ab.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + (duration / 2.5f));
                }
                SnsTimeLineUI.this.ryq.getImageMatrix().postRotate(duration / 2.5f, this.rzM, this.rzN);
            }
            SnsTimeLineUI.this.ryq.invalidate();
            AppMethodBeat.o(39548);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(39549);
            super.initialize(i, i2, i3, i4);
            if (SnsTimeLineUI.rza.booleanValue()) {
                ab.i("MicroMsg.RefreshAnim", "anim initialize %s", bo.dpG().toString());
            }
            this.rzU = 0.0f;
            this.rzV = 0.0f;
            this.rAc = 0.0f;
            this.rAd = 0.0f;
            AppMethodBeat.o(39549);
        }
    }

    class b {
        public int rAe;
        public int type;

        private b() {
            this.type = 0;
        }

        /* synthetic */ b(SnsTimeLineUI snsTimeLineUI, byte b) {
            this();
        }
    }

    class c {
        public boolean active;
        public String rAf;
        public long rAg;
        public int rAh;
        public int rAi;
        public long rAj;
        public long rAk;
        public int rAl;
        public long rAm;
        public int rAn;
        public long rAo;
        public int scene;

        private c() {
            this.active = true;
            this.rAf = "";
        }

        /* synthetic */ c(SnsTimeLineUI snsTimeLineUI, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.scene = 0;
            this.rAg = 0;
            this.rAh = -1;
            this.rAi = 0;
            this.rAj = 0;
            this.rAk = 0;
            this.rAl = 0;
            this.rAm = 0;
            this.rAn = 0;
            this.rAo = 0;
        }

        public final void Ei(int i) {
            AppMethodBeat.i(39550);
            if (this.active) {
                this.rAi = i;
                this.rAj = bo.anU();
                AppMethodBeat.o(39550);
                return;
            }
            AppMethodBeat.o(39550);
        }

        public final void Ej(int i) {
            AppMethodBeat.i(39551);
            if (this.active) {
                reset();
                this.scene = 2;
                this.rAk = bo.anU();
                this.rAl = i;
                AppMethodBeat.o(39551);
                return;
            }
            AppMethodBeat.o(39551);
        }

        public final void Ek(int i) {
            AppMethodBeat.i(39552);
            if (this.active) {
                reset();
                this.scene = 3;
                this.rAm = bo.anU();
                this.rAo = 0;
                this.rAn = i;
                AppMethodBeat.o(39552);
                return;
            }
            AppMethodBeat.o(39552);
        }

        public final String toString() {
            AppMethodBeat.i(39553);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.rAf).append(",").append(this.scene).append(",").append(this.rAg).append(",").append(this.rAh).append(",").append(this.rAi).append(",").append(this.rAj).append(",").append(this.rAk).append(",").append(this.rAl).append(",").append(this.rAm).append(",").append(this.rAn).append(",").append(this.rAo);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(39553);
            return stringBuilder2;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTimeLineUI() {
        AppMethodBeat.i(39554);
        this.ryl = this.ryk != null ? this.ryk.cvE() : null;
        this.rym = new com.tencent.mm.plugin.sns.ui.a.a.b();
        this.ryr = false;
        this.rys = false;
        this.rhv = false;
        this.ryw = 0;
        this.ryx = false;
        this.ryy = "";
        this.ryz = new com.tencent.mm.plugin.sns.i.a();
        this.rqn = new g(1);
        this.ryA = new av();
        this.ryB = new at();
        this.ryG = "";
        this.ryH = new c(this, (byte) 0);
        this.ryI = new Runnable() {
            public final void run() {
                AppMethodBeat.i(39442);
                com.tencent.mm.plugin.sns.ui.a.a a = SnsTimeLineUI.this.ryn;
                if (a != null) {
                    a.rEB.ctK();
                    a.rEB.notifyVendingDataChange();
                }
                AppMethodBeat.o(39442);
            }
        };
        this.ryJ = new com.tencent.mm.sdk.b.c<tw>() {
            {
                AppMethodBeat.i(39462);
                this.xxI = tw.class.getName().hashCode();
                AppMethodBeat.o(39462);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39463);
                SnsTimeLineUI.this.SK().aG(com.tencent.mm.plugin.sns.k.c.b.class);
                AppMethodBeat.o(39463);
                return false;
            }
        };
        this.ryK = new com.tencent.mm.sdk.b.c<ru>() {
            {
                AppMethodBeat.i(39488);
                this.xxI = ru.class.getName().hashCode();
                AppMethodBeat.o(39488);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39489);
                ru ruVar = (ru) bVar;
                if (SnsTimeLineUI.this.mController.ylL == null || SnsTimeLineUI.this.mController.ylL.isFinishing()) {
                    AppMethodBeat.o(39489);
                } else {
                    if (!ruVar.cNM.cNN) {
                        com.tencent.mm.vending.g.f.dMn().d(new com.tencent.mm.vending.c.a<Void, Void>() {
                            public final /* synthetic */ Object call(Object obj) {
                                AppMethodBeat.i(39487);
                                Void voidR = (Void) obj;
                                com.tencent.mm.plugin.sns.ui.a.a a = SnsTimeLineUI.this.ryn;
                                if (a != null) {
                                    a.rEB.PA();
                                    a.rEB.notifyVendingDataChange();
                                }
                                AppMethodBeat.o(39487);
                                return voidR;
                            }
                        });
                    }
                    AppMethodBeat.o(39489);
                }
                return false;
            }
        };
        this.ryL = false;
        this.qQu = false;
        this.ryM = new com.tencent.mm.sdk.b.c<lb>() {
            {
                AppMethodBeat.i(39505);
                this.xxI = lb.class.getName().hashCode();
                AppMethodBeat.o(39505);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39506);
                lb lbVar = (lb) bVar;
                ab.d("MicroMsg.SnsTimeLineUI", "notifyTimelineFpListener callback");
                if (lbVar instanceof lb) {
                    SnsTimeLineUI.b(SnsTimeLineUI.this);
                    SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
                }
                AppMethodBeat.o(39506);
                return false;
            }
        };
        this.ryN = new com.tencent.mm.sdk.b.c<lc>() {
            {
                AppMethodBeat.i(39519);
                this.xxI = lc.class.getName().hashCode();
                AppMethodBeat.o(39519);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39520);
                SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
                AppMethodBeat.o(39520);
                return false;
            }
        };
        this.ryO = new com.tencent.mm.sdk.b.c<ks>() {
            {
                AppMethodBeat.i(39531);
                this.xxI = ks.class.getName().hashCode();
                AppMethodBeat.o(39531);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39532);
                SnsTimeLineUI.this.ryL = true;
                AppMethodBeat.o(39532);
                return false;
            }
        };
        this.ryP = new com.tencent.mm.sdk.b.c<kw>() {
            {
                AppMethodBeat.i(39536);
                this.xxI = kw.class.getName().hashCode();
                AppMethodBeat.o(39536);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39537);
                kw kwVar = (kw) bVar;
                SnsTimeLineUI.this.qQu = true;
                SnsTimeLineUI.this.ryz.qQu = SnsTimeLineUI.this.qQu;
                SnsTimeLineUI.a(SnsTimeLineUI.this, kwVar.cGO.position);
                AppMethodBeat.o(39537);
                return false;
            }
        };
        this.ryQ = new com.tencent.mm.sdk.b.c<sa>() {
            {
                AppMethodBeat.i(39538);
                this.xxI = sa.class.getName().hashCode();
                AppMethodBeat.o(39538);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39539);
                if (SnsTimeLineUI.this.ryt != null) {
                    com.tencent.mm.plugin.sns.i.b bVar2 = SnsTimeLineUI.this.ryt.rhn.qMn;
                    bVar2.qQV++;
                    SnsTimeLineUI.this.ryt.rhn.qMn.kO(false);
                }
                AppMethodBeat.o(39539);
                return false;
            }
        };
        this.ryR = new com.tencent.mm.sdk.b.c<ra>() {
            {
                AppMethodBeat.i(39540);
                this.xxI = ra.class.getName().hashCode();
                AppMethodBeat.o(39540);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39541);
                ra raVar = (ra) bVar;
                if (SnsTimeLineUI.this.ryt != null) {
                    com.tencent.mm.plugin.sns.i.b bVar2 = SnsTimeLineUI.this.ryt.rhn.qMn;
                    String str = raVar.cNe.cNf;
                    bVar2.qSm.add(raVar.cNe.cFc);
                    bVar2.qSu.add(str);
                    bVar2.qQW = bVar2.qSu.size();
                }
                AppMethodBeat.o(39541);
                return false;
            }
        };
        this.ryS = new com.tencent.mm.sdk.b.c<ro>() {
            {
                AppMethodBeat.i(39443);
                this.xxI = ro.class.getName().hashCode();
                AppMethodBeat.o(39443);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39444);
                ro roVar = (ro) bVar;
                if (SnsTimeLineUI.this.ryt != null) {
                    com.tencent.mm.plugin.sns.i.b bVar2;
                    if (roVar.cNw.cNx) {
                        bVar2 = SnsTimeLineUI.this.ryt.rhn.qMn;
                        bVar2.qSw.add(roVar.cNw.username);
                        bVar2.qQY = bVar2.qSw.size();
                    } else {
                        bVar2 = SnsTimeLineUI.this.ryt.rhn.qMn;
                        bVar2.qSx.add(roVar.cNw.username);
                        bVar2.qQZ = bVar2.qSx.size();
                    }
                }
                AppMethodBeat.o(39444);
                return false;
            }
        };
        this.ryT = new com.tencent.mm.sdk.b.c<rm>() {
            {
                AppMethodBeat.i(39445);
                this.xxI = rm.class.getName().hashCode();
                AppMethodBeat.o(39445);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39446);
                SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
                AppMethodBeat.o(39446);
                return false;
            }
        };
        this.ryU = new com.tencent.mm.sdk.b.c<gs>() {
            {
                AppMethodBeat.i(39447);
                this.xxI = gs.class.getName().hashCode();
                AppMethodBeat.o(39447);
            }

            public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39448);
                gs gsVar = (gs) bVar;
                SnsTimeLineUI.a(SnsTimeLineUI.this, gsVar.cBr.cBu, gsVar.cBr.cBt, gsVar);
                AppMethodBeat.o(39448);
                return false;
            }
        };
        this.qMM = new com.tencent.mm.sdk.b.c<e>() {
            {
                AppMethodBeat.i(39449);
                this.xxI = e.class.getName().hashCode();
                AppMethodBeat.o(39449);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                boolean z = true;
                AppMethodBeat.i(39450);
                e eVar = (e) bVar;
                if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                    com.tencent.mm.plugin.sns.i.b bVar2 = SnsTimeLineUI.this.ryt.rhn.qMn;
                    boolean z2 = eVar.crS.active;
                    String str = eVar.crS.className;
                    if (str.toLowerCase().indexOf("sns") < 0 && str.toLowerCase().indexOf("sightuploadui") < 0 && !str.contains("WebViewUI")) {
                        z = false;
                    }
                    if (!z) {
                        ab.d("MicroMsg.SnsBrowseInfoHelper", "handleActivityStatusChanged, not sns scene, className" + str + ",_active=" + z2);
                    } else if (!z2) {
                        bVar2.qRA = System.currentTimeMillis();
                    } else if (bVar2.qRA > 0) {
                        bVar2.qRz += System.currentTimeMillis() - bVar2.qRA;
                        bVar2.qRA = 0;
                    }
                }
                AppMethodBeat.o(39450);
                return false;
            }
        };
        this.ryV = new com.tencent.mm.sdk.b.c<qx>() {
            {
                AppMethodBeat.i(39451);
                this.xxI = qx.class.getName().hashCode();
                AppMethodBeat.o(39451);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39452);
                if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                    SnsTimeLineUI.this.ryt.rhn.qMn.kX(true);
                }
                AppMethodBeat.o(39452);
                return false;
            }
        };
        this.ryW = new com.tencent.mm.sdk.b.c<rb>() {
            {
                AppMethodBeat.i(39453);
                this.xxI = rb.class.getName().hashCode();
                AppMethodBeat.o(39453);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39454);
                rb rbVar = (rb) bVar;
                if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                    SnsTimeLineUI.this.ryt.rhn.qMn.gg(rbVar.cNg.cwT, rbVar.cNg.cFc);
                }
                AppMethodBeat.o(39454);
                return false;
            }
        };
        this.ryX = new com.tencent.mm.sdk.b.c<rf>() {
            {
                AppMethodBeat.i(39455);
                this.xxI = rf.class.getName().hashCode();
                AppMethodBeat.o(39455);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39456);
                rf rfVar = (rf) bVar;
                if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                    com.tencent.mm.plugin.sns.i.b bVar2 = SnsTimeLineUI.this.ryt.rhn.qMn;
                    bVar2.qSs.add(rfVar.cNk.cFc);
                }
                AppMethodBeat.o(39456);
                return false;
            }
        };
        this.ryY = new com.tencent.mm.sdk.b.c<rg>() {
            {
                AppMethodBeat.i(39457);
                this.xxI = rg.class.getName().hashCode();
                AppMethodBeat.o(39457);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39458);
                rg rgVar = (rg) bVar;
                if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                    com.tencent.mm.plugin.sns.i.b bVar2 = SnsTimeLineUI.this.ryt.rhn.qMn;
                    bVar2.qSr.add(rgVar.cNl.cFc);
                }
                AppMethodBeat.o(39458);
                return false;
            }
        };
        this.ryZ = new com.tencent.mm.sdk.b.c<rh>() {
            {
                AppMethodBeat.i(39459);
                this.xxI = rh.class.getName().hashCode();
                AppMethodBeat.o(39459);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39460);
                rh rhVar = (rh) bVar;
                if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                    com.tencent.mm.plugin.sns.i.b bVar2 = SnsTimeLineUI.this.ryt.rhn.qMn;
                    bVar2.qSo.add(rhVar.cNm.cFc);
                }
                AppMethodBeat.o(39460);
                return false;
            }
        };
        this.rzb = 0;
        this.rzc = false;
        this.oOX = 0;
        this.rzd = new Runnable() {
            public final void run() {
                AppMethodBeat.i(39469);
                if (SnsTimeLineUI.this.ryn == null) {
                    AppMethodBeat.o(39469);
                    return;
                }
                if (SnsTimeLineUI.this.rzc) {
                    af.cnC().pause();
                }
                AppMethodBeat.o(39469);
            }
        };
        this.rze = new Runnable() {
            public final void run() {
                AppMethodBeat.i(39470);
                if (SnsTimeLineUI.this.ryn == null) {
                    AppMethodBeat.o(39470);
                    return;
                }
                if (!SnsTimeLineUI.this.rzc) {
                    ab.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", Integer.valueOf(SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition() - SnsTimeLineUI.this.mUIAction.nDp.getHeaderViewsCount()));
                    af.cnC().start();
                    SnsTimeLineUI.this.ryn.rEA.cub();
                }
                AppMethodBeat.o(39470);
            }
        };
        this.rzf = ((com.tencent.mm.vending.h.b) d.zYq.zYv).a;
        this.rzg = new Runnable() {
            public final void run() {
                AppMethodBeat.i(39471);
                q qVar = SnsTimeLineUI.this.mController;
                if (qVar.mContext != null) {
                    qVar.ap(qVar.ylL);
                }
                SnsTimeLineUI.t(SnsTimeLineUI.this);
                SnsTimeLineUI.u(SnsTimeLineUI.this);
                SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(R.string.eq0));
                SnsTimeLineUI.this.rzb = 0;
                SnsTimeLineUI.this.oOX = SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition();
                AppMethodBeat.o(39471);
            }
        };
        this.rzh = new com.tencent.mm.plugin.sns.ui.SnsUIAction.a() {
            private int rzB = 0;
            private int rzC = 0;

            public final void cuh() {
                AppMethodBeat.i(39473);
                com.tencent.mm.plugin.sns.ui.a.a.b o = SnsTimeLineUI.this.rym;
                SnsTimeLineUI.this.rzh;
                o.e(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, false, SnsTimeLineUI.this.ryE);
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(3));
                ab.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
                if (SnsTimeLineUI.this.rzf == null) {
                    ab.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
                    AppMethodBeat.o(39473);
                    return;
                }
                if (SnsTimeLineUI.this.ryt != null) {
                    SnsTimeLineUI.this.rzf.removeCallbacks(SnsTimeLineUI.this.ryI);
                    SnsTimeLineUI.this.rzf.postDelayed(SnsTimeLineUI.this.ryI, 3000);
                }
                AppMethodBeat.o(39473);
            }

            public final ListView getSnsListView() {
                AppMethodBeat.i(39474);
                if (SnsTimeLineUI.this.ryt.nDp == null) {
                    SnsTimeLineUI.this.ryt.nDp = (ListView) SnsTimeLineUI.this.findViewById(R.id.eii);
                }
                ListView listView = SnsTimeLineUI.this.ryt.nDp;
                AppMethodBeat.o(39474);
                return listView;
            }

            public final View cui() {
                AppMethodBeat.i(39475);
                if (SnsTimeLineUI.this.ryt.qOM == null) {
                    SnsTimeLineUI.this.ryt.qOM = (FrameLayout) SnsTimeLineUI.this.findViewById(R.id.avv);
                }
                FrameLayout frameLayout = SnsTimeLineUI.this.ryt.qOM;
                AppMethodBeat.o(39475);
                return frameLayout;
            }

            public final View getMaskView() {
                AppMethodBeat.i(39476);
                View findViewById = SnsTimeLineUI.this.findViewById(R.id.el6);
                AppMethodBeat.o(39476);
                return findViewById;
            }

            public final MMPullDownView cuj() {
                AppMethodBeat.i(39477);
                MMPullDownView mMPullDownView = (MMPullDownView) SnsTimeLineUI.this.findViewById(R.id.avx);
                AppMethodBeat.o(39477);
                return mMPullDownView;
            }

            public final int getType() {
                if (SnsTimeLineUI.this.rzl == 1) {
                    return 2;
                }
                return 1;
            }

            public final void b(int i, List<Integer> list, List<Integer> list2) {
                int i2 = 1;
                AppMethodBeat.i(39478);
                if (i > 0) {
                    n DK = af.cnF().DK(i);
                    if (DK != null) {
                        if (DK.field_pravited > 0) {
                            Toast.makeText(SnsTimeLineUI.this, R.string.el5, 1).show();
                        }
                        if (DK.field_pravited == 1) {
                            i2 = 0;
                        }
                    }
                }
                if (i2 != 0) {
                    com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(SnsTimeLineUI.this.mUIAction.nDp);
                }
                if (SnsTimeLineUI.this.ryn != null) {
                    SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
                }
                AppMethodBeat.o(39478);
            }

            public final boolean cuk() {
                AppMethodBeat.i(39479);
                boolean z = SnsTimeLineUI.this.rhv;
                AppMethodBeat.o(39479);
                return z;
            }

            public final void cul() {
                AppMethodBeat.i(39480);
                ab.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
                SnsTimeLineUI.this.crO();
                if (SnsTimeLineUI.this.ryq != null) {
                    ab.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
                    SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
                }
                com.tencent.mm.plugin.sns.ui.a.a.b o = SnsTimeLineUI.this.rym;
                SnsTimeLineUI.this.rzh;
                o.d(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, SnsTimeLineUI.this.rjn, SnsTimeLineUI.this.ryE);
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(2));
                AppMethodBeat.o(39480);
            }

            public final void cum() {
                AppMethodBeat.i(39481);
                SnsTimeLineUI.this.crO();
                AppMethodBeat.o(39481);
            }

            public final void Eh(int i) {
                AppMethodBeat.i(39482);
                int firstVisiblePosition = SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition();
                int lastVisiblePosition = SnsTimeLineUI.this.mUIAction.nDp.getLastVisiblePosition();
                if (firstVisiblePosition == this.rzB && lastVisiblePosition == this.rzC) {
                    AppMethodBeat.o(39482);
                    return;
                }
                this.rzB = firstVisiblePosition;
                this.rzC = lastVisiblePosition;
                ab.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition), Integer.valueOf(i));
                if (i == 2) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.this.ehv);
                    SnsTimeLineUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSScrollEnable, WXHardCoderJNI.hcSNSScrollDelay, WXHardCoderJNI.hcSNSScrollCPU, WXHardCoderJNI.hcSNSScrollIO, WXHardCoderJNI.hcSNSScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI");
                    ab.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsTimeLineUI.this.ehv));
                }
                if (i == 0 && SnsTimeLineUI.this.ryn != null) {
                    com.tencent.mm.plugin.sns.ui.a.a a = SnsTimeLineUI.this.ryn;
                    if (lastVisiblePosition >= firstVisiblePosition) {
                        LinkedList linkedList = new LinkedList();
                        for (int i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                            n DP = a.DP(i2);
                            if (DP != null) {
                                TimeLineObject cqu = DP.cqu();
                                if (cqu != null && cqu.xfI.wbJ == 3) {
                                    firstVisiblePosition = -1;
                                    if (cqu.xfI.wbN != null) {
                                        firstVisiblePosition = cqu.xfI.wbN.vGc;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(cqu.Id);
                                    arrayList.add(bo.bc(cqu.xfI.Url, ""));
                                    arrayList.add(String.valueOf(firstVisiblePosition));
                                    linkedList.add(arrayList);
                                }
                            }
                        }
                        ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).i(linkedList, 2);
                    }
                }
                if (SnsTimeLineUI.this.ryn != null) {
                    final com.tencent.mm.plugin.sns.i.a.a a2 = SnsTimeLineUI.this.ryz.a(SnsTimeLineUI.this.ryn.rEA);
                    com.tencent.mm.vending.g.f.dMn().d(new com.tencent.mm.vending.c.a<Void, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(39472);
                            Void voidR = (Void) obj;
                            if (a2 != null) {
                                com.tencent.mm.plugin.sns.i.a.a aVar = a2;
                                com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(501);
                                lY.timeStamp = aVar.qQv;
                                lY.mb(aVar.mScreenWidth).mb(aVar.mScreenHeight);
                                lY.mb(aVar.qQx);
                                lY.mb(0);
                                lY.mb(aVar.qQw);
                                lY.mb(aVar.aaF);
                                lY.ajK();
                                if (aVar.qQy != null) {
                                    for (com.tencent.mm.plugin.sns.i.a.b bVar : aVar.qQy) {
                                        com.tencent.mm.modelsns.b lY2 = com.tencent.mm.modelsns.b.lY(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                                        lY2.timeStamp = aVar.qQv;
                                        lY2.tx(bVar.qQD).mb(bVar.qQB).cS(bVar.qQC).mb(bVar.qQA).mb(bVar.qQz).mb(bVar.aKu).mb(bVar.aKv);
                                        lY2.ajK();
                                        ab.v("MicroMsg.CaptureSnsHelper", "rootview top left %s %s viewWidth: %s viewHeight: %s", Integer.valueOf(bVar.qQz), Integer.valueOf(bVar.qQA), Integer.valueOf(bVar.aKu), Integer.valueOf(bVar.aKv));
                                        ab.v("MicroMsg.CaptureSnsHelper", "like %s %s likeheight: %s likewidth: %s", Integer.valueOf(bVar.qQG), Integer.valueOf(bVar.qQH), Integer.valueOf(bVar.qQJ), Integer.valueOf(bVar.qQI));
                                        ab.v("MicroMsg.CaptureSnsHelper", "comment %s %s commentheight: %s commentwidth: %s", Integer.valueOf(bVar.qQK), Integer.valueOf(bVar.qQL), Integer.valueOf(bVar.qQN), Integer.valueOf(bVar.qQM));
                                        if (bVar.qQF != 0) {
                                            lY2 = com.tencent.mm.modelsns.b.lY(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
                                            lY2.timeStamp = aVar.qQv;
                                            lY2.tx(bVar.qQD).mb(bVar.qQB).cS(bVar.qQC).mb(bVar.qQF).mb(bVar.qQH).mb(bVar.qQG).mb(bVar.qQI).mb(bVar.qQJ);
                                            lY2.ajK();
                                        }
                                        if (bVar.qQE != 0) {
                                            lY2 = com.tencent.mm.modelsns.b.lY(504);
                                            lY2.timeStamp = aVar.qQv;
                                            lY2.tx(bVar.qQD).mb(bVar.qQB).cS(bVar.qQC).mb(bVar.qQE).mb(bVar.qQL).mb(bVar.qQK).mb(bVar.qQM).mb(bVar.qQN);
                                            lY2.ajK();
                                        }
                                    }
                                }
                                lY = com.tencent.mm.modelsns.b.lY(506);
                                lY.timeStamp = aVar.qQv;
                                lY.ajK();
                            }
                            AppMethodBeat.o(39472);
                            return voidR;
                        }
                    });
                }
                AppMethodBeat.o(39482);
            }

            public final void ad(int i, boolean z) {
                AppMethodBeat.i(39483);
                if (SnsTimeLineUI.this.ryn != null) {
                    SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
                }
                if (!z) {
                    SnsTimeLineUI.this.SK().aG(com.tencent.mm.plugin.sns.k.c.b.class);
                }
                AppMethodBeat.o(39483);
            }

            public final void ln(boolean z) {
                AppMethodBeat.i(39484);
                SnsTimeLineUI snsTimeLineUI = SnsTimeLineUI.this;
                snsTimeLineUI.rzc = z;
                ak bCo = af.bCo();
                com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
                com.tencent.mm.plugin.sns.model.b cnA = af.cnA();
                if (z) {
                    if (cnC.qHJ || cnA.qHJ) {
                        bCo.removeCallbacks(snsTimeLineUI.rzd);
                        bCo.removeCallbacks(snsTimeLineUI.rze);
                        bCo.postDelayed(snsTimeLineUI.rzd, 0);
                        AppMethodBeat.o(39484);
                        return;
                    }
                } else if (!(cnC.qHJ && cnA.qHJ)) {
                    bCo.removeCallbacks(snsTimeLineUI.rzd);
                    bCo.removeCallbacks(snsTimeLineUI.rze);
                    bCo.postDelayed(snsTimeLineUI.rze, 0);
                }
                AppMethodBeat.o(39484);
            }

            public final void fA(int i, int i2) {
            }
        };
        this.rzi = new com.tencent.mm.vending.app.a.b<com.tencent.mm.plugin.sns.k.c.b>() {
            public final /* synthetic */ void bj(Object obj) {
                AppMethodBeat.i(39485);
                com.tencent.mm.plugin.sns.k.c.b bVar = (com.tencent.mm.plugin.sns.k.c.b) obj;
                if (bVar != null) {
                    if (bVar.rNt > 0 || ((bVar.rNu != null && bVar.rNu.size() > 0) || (SnsTimeLineUI.this.mUIAction.qQt != null && SnsTimeLineUI.this.mUIAction.qQt.ctj()))) {
                        SnsTimeLineUI.this.ryo.setVisibility(0);
                    } else {
                        SnsTimeLineUI.this.ryo.setVisibility(8);
                    }
                    if (bVar.rNt <= 0 || SnsTimeLineUI.this.rzl != 0) {
                        SnsTimeLineUI.this.ryo.findViewById(R.id.ejj).setVisibility(8);
                    } else {
                        SnsTimeLineUI.a(SnsTimeLineUI.this, bVar);
                        SnsTimeLineUI.this.ryo.findViewById(R.id.ejj).setVisibility(0);
                    }
                    if (bVar.rNu == null || bVar.rNu.size() <= 0) {
                        SnsTimeLineUI.this.ryp.setVisibility(8);
                    } else {
                        SnsTimeLineUI.this.ryp.setVisibility(0);
                        SnsTimeLineUI.this.ryp.removeAllViews();
                        for (Long longValue : bVar.rNu) {
                            SnsTimeLineUI.a(SnsTimeLineUI.this, longValue.longValue());
                        }
                    }
                    if (SnsTimeLineUI.this.ryn != null && SnsTimeLineUI.this.ryv.hasDrawed()) {
                        SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
                        ab.i("MicroMsg.SnsTimeLineUI", "has not show view, pass");
                    }
                }
                AppMethodBeat.o(39485);
            }
        };
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.rzj = true;
        this.oes = 0;
        this.eEO = 0;
        this.fAq = 0;
        this.mnM = new com.tencent.matrix.trace.e.b() {
            public final void a(String str, long j, int i) {
                AppMethodBeat.i(39497);
                super.a(str, j, i);
                if (i > 0 && !bo.isNullOrNil(str) && str.endsWith(SnsTimeLineUI.this.getClass().getSimpleName())) {
                    SnsTimeLineUI.this.eEO = SnsTimeLineUI.this.eEO + ((long) i);
                }
                AppMethodBeat.o(39497);
            }
        };
        this.rzl = 0;
        this.rzm = new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39517);
                SnsTimeLineUI.this.aqX();
                SnsTimeLineUI.this.finish();
                AppMethodBeat.o(39517);
                return false;
            }
        };
        this.rzp = null;
        this.rzq = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39526);
                if (SystemClock.elapsedRealtime() - SnsTimeLineUI.this.ryj < 300) {
                    SnsTimeLineUI.K(SnsTimeLineUI.this);
                }
                SnsTimeLineUI.this.ryj = SystemClock.elapsedRealtime();
                af.bCo().removeCallbacks(SnsTimeLineUI.this.rzg);
                SnsTimeLineUI.this.rzg.run();
                AppMethodBeat.o(39526);
            }
        };
        this.rzr = false;
        AppMethodBeat.o(39554);
    }

    static /* synthetic */ void M(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(39598);
        snsTimeLineUI.cug();
        AppMethodBeat.o(39598);
    }

    static /* synthetic */ void t(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(39590);
        snsTimeLineUI.cuf();
        AppMethodBeat.o(39590);
    }

    static /* synthetic */ void u(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(39591);
        snsTimeLineUI.cue();
        AppMethodBeat.o(39591);
    }

    public final void a(boolean z, boolean z2, final String str, boolean z3, boolean z4, int i, long j, String str2) {
        AppMethodBeat.i(39555);
        this.rzf.removeCallbacks(this.ryI);
        final boolean z5 = z2;
        final int i2 = i;
        final String str3 = str2;
        final boolean z6 = z;
        com.tencent.mm.vending.g.f.dMn().d(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(39464);
                Void voidR = (Void) obj;
                com.tencent.mm.plugin.sns.ui.a.a a = SnsTimeLineUI.this.ryn;
                if (a != null) {
                    a.rEB.ZK(str);
                    a.rEB.PA();
                    a.rEB.notifyVendingDataChange();
                }
                AppMethodBeat.o(39464);
                return voidR;
            }
        }).f(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(39461);
                Void voidR = (Void) obj;
                if (SnsTimeLineUI.this.ryu != null) {
                    SnsTimeLineUI.this.rys = false;
                    SnsTimeLineUI.this.ryu.cus();
                }
                SnsTimeLineUI.this.mUIAction.koC = z5;
                if (z5) {
                    SnsTimeLineUI.this.mUIAction.lc(false);
                    if (SnsTimeLineUI.this.rzl == 1) {
                        SnsTimeLineUI.this.mUIAction.bf(i2, str3);
                    }
                } else if (z6) {
                    com.tencent.mm.plugin.sns.ui.a.a.b o = SnsTimeLineUI.this.rym;
                    SnsTimeLineUI.this.rzh;
                    o.e(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, SnsTimeLineUI.this.rjn, 0);
                }
                AppMethodBeat.o(39461);
                return voidR;
            }
        });
        AppMethodBeat.o(39555);
    }

    public final void a(boolean z, final String str, boolean z2, boolean z3, int i, long j, String str2) {
        AppMethodBeat.i(39556);
        this.rzf.removeCallbacks(this.ryI);
        final boolean z4 = z;
        final boolean z5 = z3;
        final int i2 = i;
        final String str3 = str2;
        final long j2 = j;
        final boolean z6 = z2;
        com.tencent.mm.vending.g.f.dMn().d(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(39467);
                Void voidR = (Void) obj;
                com.tencent.mm.plugin.sns.ui.a.a a = SnsTimeLineUI.this.ryn;
                if (a != null) {
                    a.rEB.ZK(str);
                    a.rEB.ctK();
                    a.rEB.notifyVendingDataChange();
                }
                AppMethodBeat.o(39467);
                return voidR;
            }
        }).f(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(39466);
                Void a = a((Void) obj);
                AppMethodBeat.o(39466);
                return a;
            }

            private Void a(Void voidR) {
                AppMethodBeat.i(39465);
                if (SnsTimeLineUI.this.ryu != null) {
                    SnsTimeLineUI.this.rys = false;
                    SnsTimeLineUI.this.ryu.cus();
                }
                SnsTimeLineUI.this.mUIAction.koC = z4;
                if (SnsTimeLineUI.this.rzl == 0) {
                    ab.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", Boolean.valueOf(z4));
                    if (z4) {
                        SnsTimeLineUI.this.mUIAction.lc(false);
                    }
                    AppMethodBeat.o(39465);
                } else {
                    if (!z5 || SnsTimeLineUI.this.ryC.equals(SnsTimeLineUI.this.igi)) {
                        if (SnsTimeLineUI.this.ryC.equals(SnsTimeLineUI.this.igi) && j2 != 0) {
                            com.tencent.mm.kernel.g.RQ();
                            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_RECENT_LIMITED_ID_LONG_SYNC, Long.valueOf(j2));
                        }
                        if (z4) {
                            SnsTimeLineUI.this.mUIAction.lc(z6);
                        }
                    } else {
                        SnsTimeLineUI.this.mUIAction.koC = true;
                        SnsTimeLineUI.this.mUIAction.bf(i2, str3);
                    }
                    AppMethodBeat.o(39465);
                }
                return voidR;
            }
        });
        AppMethodBeat.o(39556);
    }

    public final void xE(int i) {
        AppMethodBeat.i(39557);
        super.xE(i);
        if (VERSION.SDK_INT >= 21 && this.plv != null) {
            this.plv.setBackgroundColor(getWindow().getStatusBarColor());
            com.tencent.mm.ui.statusbar.d.a(getWindow());
        }
        AppMethodBeat.o(39557);
    }

    static {
        AppMethodBeat.i(39602);
        HandlerThread handlerThread = new HandlerThread("sns");
        rzk = handlerThread;
        handlerThread.start();
        AppMethodBeat.o(39602);
    }

    private void Eg(int i) {
        AppMethodBeat.i(39558);
        if (rza.booleanValue()) {
            boolean z;
            String str = "MicroMsg.SnsTimeLineUI";
            String str2 = "setRefreshAnimVisible %s %s";
            Object[] objArr = new Object[2];
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = bo.dpG().toString();
            ab.i(str, str2, objArr);
        }
        this.ryq.setVisibility(i);
        AppMethodBeat.o(39558);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        AppMethodBeat.i(39559);
        ab.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", keyEvent.toString());
        int i2 = this.mController.ymc;
        i iVar = this.ryt;
        if (keyEvent.getKeyCode() == 4 && iVar.rhq.getVisibility() == 0) {
            iVar.rhq.setVisibility(8);
            i = 1;
        }
        if (i == 0 || i2 != 2) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(39559);
            return dispatchKeyEvent;
        }
        AppMethodBeat.o(39559);
        return true;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39560);
        if (this.mController != null) {
            this.mController.aC(2, true);
        }
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        com.tencent.mm.pluginsdk.f.m(this);
        this.ylm = true;
        super.onCreate(bundle);
        if (com.tencent.mm.kernel.g.RN().QY()) {
            com.tencent.mm.plugin.sns.k.a cvE;
            com.tencent.mm.plugin.sns.k.c.a aVar;
            this.plv = findViewById(R.id.k0);
            if (this.plv != null && com.tencent.mm.ui.statusbar.c.zzP) {
                com.tencent.mm.ui.statusbar.c az = com.tencent.mm.ui.statusbar.c.az(this);
                AnonymousClass16 anonymousClass16 = new com.tencent.mm.ui.statusbar.c.a() {
                    public final void pO(int i) {
                        AppMethodBeat.i(39468);
                        SnsTimeLineUI.this.plv.setPadding(0, i, 0, 0);
                        AppMethodBeat.o(39468);
                    }
                };
                this.plx = anonymousClass16;
                az.a(anonymousClass16);
                getWindow().getDecorView().requestApplyInsets();
                com.tencent.mm.ui.statusbar.d.a(getWindow());
            }
            getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
            com.tencent.mm.ui.b.c(this, false);
            xE(this.mController.ylL.getResources().getColor(R.color.a3p));
            dyb();
            this.rzl = getIntent().getIntExtra("sns_adapter_type", 0);
            this.rys = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
            this.mActionBar = getSupportActionBar();
            int en = com.tencent.mm.model.c.c.abj().en("Sns_Private_Recent_Setting_Guide", 0);
            ab.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(en)));
            if (en == 1) {
                com.tencent.mm.kernel.g.RQ();
                if (!com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, false)) {
                    Intent intent = getIntent();
                    intent.setClass(this.mController.ylL, SnsSettingIntroduceUI.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_INTRODUCE_SETTING_DISPLAY_BOOLEAN_SYNC, Boolean.TRUE);
                }
            }
            com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39486);
                    com.tencent.mm.cf.b.dvU();
                    AppMethodBeat.o(39486);
                }
            });
            this.ryl.a(com.tencent.mm.plugin.sns.k.c.b.class, this.rzi);
            com.tencent.mm.plugin.sns.ui.a.a.b bVar = this.rym;
            en = this.rzl;
            Intent intent2 = getIntent();
            com.tencent.mm.plugin.sns.k.b bVar2 = this.ryk;
            bVar.rzl = en;
            bVar.hasInit = true;
            if (en == 0) {
                com.tencent.mm.plugin.sns.ui.a.a.a aVar2 = bVar.rEQ;
                aVar2.ryk = bVar2;
                if (bVar2 != null) {
                    cvE = bVar2.cvE();
                } else {
                    cvE = null;
                }
                aVar2.ryl = cvE;
                bVar.rEQ.ryl.a(this);
            } else {
                bVar.rER = new com.tencent.mm.plugin.sns.k.c.a();
                bVar.rER.igi = intent2.getStringExtra("sns_userName");
                bVar.rER.ryC = r.Yz();
                com.tencent.mm.plugin.sns.k.c.a aVar3 = bVar.rER;
                com.tencent.mm.kernel.g.RQ();
                aVar3.ryD = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoJ(bVar.rER.igi);
                bVar.rER.rjn = r.Yz().equals(bVar.rER.igi);
                bVar.rER.ryE = intent2.getIntExtra("sns_source", 0);
                bVar.rER.gHT = bo.bc(intent2.getStringExtra("sns_nickName"), "");
                bVar.rER.mSignature = bo.bc(intent2.getStringExtra("sns_signature"), "");
            }
            com.tencent.mm.plugin.sns.ui.a.a.b bVar3 = this.rym;
            if (bVar3.rzl == 0) {
                aVar = (com.tencent.mm.plugin.sns.k.c.a) bVar3.rEQ.ryl.x(com.tencent.mm.plugin.sns.k.c.a.class);
            } else {
                aVar = bVar3.rER;
            }
            this.igi = aVar.igi;
            this.ryC = aVar.ryC;
            this.ryD = aVar.ryD;
            this.rjn = aVar.rjn;
            this.ryE = aVar.ryE;
            String str = aVar.gHT;
            String str2 = aVar.mSignature;
            this.hcl = com.tencent.mm.ui.e.aqC("123");
            this.ryF = String.valueOf(System.currentTimeMillis());
            this.mUIAction = new SnsUIAction(this);
            this.mUIAction.setSessionId(this.hcl);
            this.mUIAction.qSf = this.ryF;
            this.mUIAction.rBP = this.rzh;
            this.mUIAction.rBQ = this.mActionBar.getCustomView();
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().il(2);
            com.tencent.mm.plugin.sns.ui.widget.e.cvB().rMP = 0;
            com.tencent.mm.plugin.sns.ui.widget.c.cvy().rMP = 0;
            com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.fQs;
            com.tencent.mm.modelsns.c.ajL();
            this.ryt = new i(this, getIntent().getBooleanExtra("is_sns_notify_open", true) ? 1 : 0, bo.bc(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.ryF);
            this.rhv = getIntent().getBooleanExtra("sns_resume_state", true);
            if (af.cnn()) {
                this.rhv = false;
            } else if (this.rhv) {
                this.rhv = af.cnM().csu();
            }
            this.ryr = this.rhv;
            this.mUIAction.a(this.ryC, this.igi, str, str2, this.ryD, this.rjn, this.ryE);
            this.mUIAction.onCreate();
            com.tencent.mm.plugin.sns.g.c cnw = af.cnw();
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mm.storage.c cVar2 : com.tencent.mm.model.c.c.abi().aof("10001").values()) {
                com.tencent.mm.plugin.sns.g.d dVar = new com.tencent.mm.plugin.sns.g.d();
                if (cVar2 == null) {
                    ab.i("MicroMsg.SnsABTestStrategy", "abtest is null");
                } else if (cVar2.isValid()) {
                    Map dru = cVar2.dru();
                    if (dru != null) {
                        Object obj;
                        ab.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + cVar2.field_expId + " " + cVar2.field_layerId + " " + cVar2.field_startTime + " " + cVar2.field_endTime);
                        dVar.h(cVar2.field_layerId, cVar2.field_expId, dru);
                        if (!dVar.cwB || dVar.qPP == null || dVar.qPP.size() <= 0) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null) {
                            arrayList.add(dVar);
                        }
                    }
                } else {
                    ab.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
                }
            }
            cnw.qPp = arrayList;
            cnw.qPs.clear();
            cnw.qPt.clear();
            cnw.qPv.clear();
            cnw.qJD = null;
            if (!(cnw.qPp == null || cnw.qPp.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.RQ();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.kernel.g.RP().cachePath).append("ws_1100004").toString();
                ab.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(stringBuilder2)));
                byte[] e = com.tencent.mm.vfs.e.e(stringBuilder2, 0, -1);
                if (e != null) {
                    try {
                        cnw.qJD = (com.tencent.mm.plugin.sns.h.c) new com.tencent.mm.plugin.sns.h.c().parseFrom(e);
                        ab.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                        if (cnw.qJD == null) {
                            ab.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
                        } else {
                            ab.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + cnw.qJD.qQf.size());
                        }
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.SnSABTestMgr", e2, "", new Object[0]);
                        com.tencent.mm.vfs.e.deleteFile(stringBuilder2);
                    }
                }
            }
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(213, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(682, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(218, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(211, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(683, (f) this);
            initView();
            com.tencent.mm.plugin.sns.g.c cnw2 = af.cnw();
            ListView listView = this.mUIAction.nDp;
            au auVar = this.ryn.rEA;
            cnw2.qPq = listView;
            cnw2.qPr = auVar;
            f cnw3 = af.cnw();
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(291, cnw3);
            this.ryt.mmO = (ClipboardManager) ah.getContext().getSystemService("clipboard");
            if (af.cnn()) {
                this.rhv = false;
            } else if (this.rhv) {
                this.rhv = af.cnM().csu();
            }
            cvE = this.ryl;
            cvE.rEB = this.ryn.rEB;
            cvE.zWY.keep(cvE.rEB);
            if (this.rhv && this.rzl == 0) {
                this.rys = false;
                en = af.cnM().position;
                this.ryn.rEB.ZL(af.cnM().lQD);
                this.ryn.rEB.ZK(af.cnM().rmL);
                this.ryn.rEB.cuQ();
                this.ryn.sg();
                if (en >= this.ryn.getCount()) {
                    en = this.ryn.getCount() - 1;
                    ab.e("MicroMsg.SnsTimeLineUI", "error position %s", Integer.valueOf(this.ryn.getCount()));
                }
                this.mUIAction.nDp.setAdapter(this.ryn);
                ab.d("MicroMsg.SnsTimeLineUI", "resume position %s", Integer.valueOf(af.cnM().rmM));
                this.mUIAction.nDp.setSelectionFromTop(en, af.cnM().rmM);
                Eg(4);
            } else {
                this.mUIAction.nDp.setAdapter(this.ryn);
                Eg(0);
                this.ryn.sg();
            }
            int count = this.ryn.getCount();
            en = this.mUIAction.nDp.getFirstVisiblePosition();
            if (en < count) {
                this.ryy = com.tencent.mm.plugin.sns.data.i.j(this.ryn.DP(en));
            }
            com.tencent.mm.kernel.g.RQ();
            this.ryw = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(327776, Integer.valueOf(0))).intValue();
            this.ryt.rhx = new bd(this, this.ryn.rEA, this.ryt.qOM);
            this.ryt.rhz = new com.tencent.mm.plugin.sns.g.b(this, this.ryn.rEA.qOL, this.ryt.qOM);
            this.ryt.rhy = new b(this, this.ryn.rEA.qOL, this.ryt.qOM, this.ryt.rhz);
            if (this.ryB != null) {
                this.ryB.a(this.ryt.rhz);
            }
            if (count > 0) {
                n DP = this.ryn.DP(0);
                if (!(this.ryt.rhn == null || this.ryt.rhn.qMn == null)) {
                    this.ryt.rhn.qMn.qQP = DP.field_snsId;
                }
                com.tencent.mm.plugin.sns.i.e eVar = com.tencent.mm.plugin.sns.i.e.qTd;
                if (eVar.eFs != 0) {
                    if (eVar.qTe.isEmpty()) {
                        eVar.ecO.setLong(2, bo.anT());
                        eVar.qTf.clear();
                    }
                    ab.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", Integer.valueOf(eVar.qTe.size()));
                }
            }
            h.pYm.X(13312, "1," + bo.anU());
            com.tencent.mm.sdk.b.a.xxA.c(this.ryJ);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false)) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39492);
                        com.tencent.mm.ui.base.h.d(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(R.string.d9p), "", SnsTimeLineUI.this.getString(R.string.d9q), SnsTimeLineUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(39490);
                                com.tencent.mm.sdk.b.a.xxA.m(new ou());
                                AppMethodBeat.o(39490);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(39491);
                                com.tencent.mm.sdk.b.a.xxA.m(new li());
                                AppMethodBeat.o(39491);
                            }
                        });
                        AppMethodBeat.o(39492);
                    }
                }, 500);
                getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.g.RQ();
            if (com.tencent.mm.kernel.g.RN().QY()) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().Ry().set(589825, Boolean.FALSE);
            }
            this.ryt.rhm = this.rqn;
            this.rqn.a(this.mUIAction.qDc, this.mActionBar.getCustomView(), this);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryO);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryP);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryQ);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryR);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryS);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryU);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryT);
            com.tencent.mm.sdk.b.a.xxA.c(this.qMM);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryV);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryW);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryY);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryX);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryZ);
            com.tencent.mm.plugin.sns.abtest.c.cmb();
            com.tencent.mm.plugin.sns.abtest.a.c((Context) this, this.ryt.qOM);
            if (this.ryz != null) {
                com.tencent.mm.plugin.sns.i.a aVar4 = this.ryz;
                listView = this.mUIAction.nDp;
                SnsHeader snsHeader = this.mUIAction.qQt;
                aVar4.gKd = listView;
                aVar4.qQt = snsHeader;
            }
            if (!(this.ryt == null || this.ryt.rhn == null)) {
                com.tencent.mm.plugin.sns.i.b bVar4 = this.ryt.rhn.qMn;
                ab.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
                bVar4.qQO = true;
                bVar4.qSM = System.currentTimeMillis();
            }
            boolean booleanExtra = getIntent().getBooleanExtra("enter_by_red", false);
            if (!(this.ryt == null || this.ryt.rhn == null)) {
                com.tencent.mm.plugin.sns.i.b bVar5 = this.ryt.rhn.qMn;
                if (booleanExtra) {
                    en = 1;
                } else {
                    en = 0;
                }
                bVar5.qRb = en;
            }
            af.cnC().qIc.clear();
            if (!(this.mUIAction == null || this.mUIAction.qQt == null)) {
                this.mUIAction.qQt.setStoryAction(new com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a() {
                    public final void cun() {
                        AppMethodBeat.i(39493);
                        a h = SnsTimeLineUI.this.ryu;
                        if (SnsTimeLineUI.this.ryq.getVisibility() == 0) {
                            h.init();
                            SnsTimeLineUI.this.ryq.clearAnimation();
                            SnsTimeLineUI.this.ryq.startAnimation(h);
                            h.kK((long) (h.DELAY_TIME + 100));
                            h.rzW = false;
                        }
                        AppMethodBeat.o(39493);
                    }
                });
            }
            com.tencent.mm.sdk.b.a.xxA.c(this.ryK);
            AppMethodBeat.o(39560);
            return;
        }
        finish();
        AppMethodBeat.o(39560);
    }

    private void cue() {
        AppMethodBeat.i(39561);
        if (this.rzl != 1) {
            addIconOptionMenu(0, R.string.eio, R.raw.icons_filled_camera, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(39495);
                    SnsTimeLineUI.E(SnsTimeLineUI.this);
                    AppMethodBeat.o(39495);
                    return true;
                }
            }, new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(39496);
                    if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                        SnsTimeLineUI.this.ryt.rhn.qMn.kO(true);
                    }
                    com.tencent.mm.kernel.g.RQ();
                    boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(7490, Boolean.TRUE)).booleanValue();
                    com.tencent.mm.kernel.g.RQ();
                    String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, null);
                    if (!bo.isNullOrNil(str)) {
                        byte[] atV = com.tencent.d.f.e.atV(str);
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(atV, 0, atV.length);
                        obtain.setDataPosition(0);
                        try {
                            SnsTimeLineUI.this.startActivityForResult((Intent) Intent.CREATOR.createFromParcel(obtain), 9);
                            AppMethodBeat.o(39496);
                        } catch (Exception e) {
                            com.tencent.mm.kernel.g.RQ();
                            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) "");
                        }
                        return true;
                    }
                    if (booleanValue) {
                        SnsTimeLineUI.this.startActivity(new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class));
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().Ry().set(7490, Boolean.FALSE);
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
                        intent.putExtra("KSnsPostManu", true);
                        intent.putExtra("KTouchCameraTime", bo.anT());
                        intent.putExtra("sns_comment_type", 1);
                        intent.putExtra("Ksnsupload_type", 9);
                        com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(705);
                        lY.mc(lY.fQh).ty(System.currentTimeMillis()).mc(lY.fQi).mc(1);
                        lY = com.tencent.mm.plugin.sns.i.g.qTp.b(lY);
                        lY.ajK();
                        lY.b(intent, "intent_key_StatisticsOplog");
                        SnsTimeLineUI.this.startActivityForResult(intent, 9);
                    }
                    AppMethodBeat.o(39496);
                    return true;
                }
            });
            AppMethodBeat.o(39561);
        } else if (this.rjn) {
            b(getString(R.string.emv), (int) R.raw.actionbar_list_icon, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(39494);
                    Intent intent = new Intent();
                    intent.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
                    intent.putExtra("sns_msg_force_show_all", true);
                    SnsTimeLineUI.this.startActivityForResult(intent, 8);
                    AppMethodBeat.o(39494);
                    return true;
                }
            });
            AppMethodBeat.o(39561);
        } else {
            enableOptionMenu(false);
            AppMethodBeat.o(39561);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(39562);
        super.onConfigurationChanged(configuration);
        ab.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
        com.tencent.mm.sdk.b.a.xxA.m(new bz());
        com.tencent.mm.plugin.sns.ui.widget.e.cvB().rMP = 0;
        com.tencent.mm.plugin.sns.ui.widget.c.cvy().rMP = 0;
        com.tencent.mm.kiss.widget.textview.c.eNj.SN();
        this.ryn.rEA.ctW();
        this.ryn.rEB.resolvedClear();
        AppMethodBeat.o(39562);
    }

    public void onDestroy() {
        int i;
        long j;
        int i2;
        int i3;
        String str;
        AppMethodBeat.i(39563);
        this.ryx = true;
        ab.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
        com.tencent.mm.sdk.b.a.xxA.d(this.ryO);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryP);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryQ);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryR);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryS);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryU);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryT);
        com.tencent.mm.sdk.b.a.xxA.d(this.qMM);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryV);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryW);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryX);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryY);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryZ);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryK);
        com.tencent.mm.plugin.sns.ui.e.a.cvo();
        if (!(this.ryt == null || this.ryt.rhn == null)) {
            com.tencent.mm.plugin.sns.i.b bVar = this.ryt.rhn.qMn;
            if (this.ryL) {
                i = 1;
            } else {
                i = 0;
            }
            bVar.qRc = i;
        }
        com.tencent.mm.plugin.sns.i.e eVar = com.tencent.mm.plugin.sns.i.e.qTd;
        if (eVar.eFs != 0) {
            ab.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", Integer.valueOf(eVar.qTe.size()), Integer.valueOf(eVar.qTf.size()));
            j = eVar.ecO.getLong(2, 0);
            if (eVar.qTe.isEmpty() || (eVar.qTe.size() <= eVar.qTj && bo.fp(j) <= ((long) eVar.qTk))) {
                eVar.ecO.set(3, eVar.qTe);
                eVar.ecO.set(4, eVar.qTf);
                eVar.ecO.set(5, eVar.qTg);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                i2 = 0;
                i3 = 0;
                for (String str2 : eVar.qTe.keySet()) {
                    str = (String) eVar.qTf.get(str2);
                    if (bo.isNullOrNil(str)) {
                        str = "";
                    } else {
                        i3 = 1;
                    }
                    stringBuffer.append(str2 + "#" + eVar.qTe.get(str2) + "#" + str + "#" + (eVar.qTg.contains(str2) ? 1 : 0) + "|");
                    i2++;
                }
                stringBuffer.append("," + j + "," + bo.anT() + ",1," + i3 + "," + i2 + ",1");
                ab.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", Integer.valueOf(13226), stringBuffer);
                h.pYm.X(13226, stringBuffer.toString());
                eVar.ecO.set(3, null);
                eVar.ecO.set(4, null);
                eVar.qTe.clear();
                eVar.qTf.clear();
                eVar.qTg.clear();
                eVar.ecO.setLong(2, bo.anT());
            }
            eVar.coG();
        }
        com.tencent.mm.kernel.g.RQ();
        String str22 = (String) com.tencent.mm.kernel.g.RP().Ry().get(68377, null);
        i3 = this.ryn.getCount();
        str = "";
        n nVar = null;
        if (i3 > 0) {
            nVar = this.ryn.DP(i3 - 1);
            str = com.tencent.mm.plugin.sns.data.i.j(nVar);
        }
        if (!(this.ryt == null || this.ryt.rhn == null)) {
            com.tencent.mm.plugin.sns.i.b bVar2 = this.ryt.rhn.qMn;
            if (nVar == null) {
                i2 = -1;
            } else {
                i2 = nVar.field_createTime;
            }
            ab.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
            long currentTimeMillis = System.currentTimeMillis() - bVar2.qSM;
            bVar2.qQQ += currentTimeMillis;
            ab.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + currentTimeMillis + " BrowseTime: " + bVar2.qQQ + "BackgroundTime: " + bVar2.qRz);
            com.tencent.mm.sdk.g.b.a cns = af.cns();
            if (cns != null) {
                cns.execute(new com.tencent.mm.plugin.sns.i.b.AnonymousClass2(i2));
            }
            bVar2.qQO = false;
        }
        com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(704);
        if (lY.ajG()) {
            lY.cS(this.ryL);
            lY.cS(!bo.isNullOrNil(str22));
            lY.tx(this.ryy);
            lY.tx(str);
            lY.tx(str);
            lY.mb(this.mUIAction.rBO);
            lY.tx("");
            com.tencent.mm.modelsns.b.ajJ();
            lY.ajK();
        }
        AdListView adListView = (AdListView) this.mUIAction.getSnsListView();
        this.ryB.qNf.clear();
        af.cnw().clean();
        af.cns().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35754);
                i.d(i.this);
                AppMethodBeat.o(35754);
            }
        });
        adListView.rfN.clear();
        adListView.rfN = null;
        adListView.rfO.cmU();
        adListView.rfO = null;
        u.cmZ();
        if (!af.cnn()) {
            this.rzf.removeCallbacks(this.ryI);
        }
        com.tencent.mm.kernel.g.RQ();
        if (com.tencent.mm.kernel.g.RN().QY()) {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(213, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(682, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(218, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(211, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(683, (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(327776, Integer.valueOf(this.ryw));
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(589825, Boolean.FALSE);
        }
        if (this.ryt != null) {
            i iVar = this.ryt;
            iVar.rhA.removeListener();
            if (iVar.rhq != null) {
                iVar.rhq.bMO();
            }
            com.tencent.mm.sdk.b.a.xxA.d(iVar.rhC);
            com.tencent.mm.sdk.b.a.xxA.d(iVar.rhD);
        }
        af.bCo().removeCallbacks(this.rzg);
        if (this.ryn != null) {
            i2 = this.mUIAction.nDp.getFirstVisiblePosition();
            int i4 = 0;
            for (i = 0; i < this.mUIAction.nDp.getCount(); i++) {
                View childAt = this.mUIAction.nDp.getChildAt(i);
                if (childAt != null && this.mUIAction.nDp.getPositionForView(childAt) == i2) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    ab.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", Integer.valueOf(r4), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                    i4 = iArr[1];
                }
            }
            i = getResources().getDimensionPixelSize(R.dimen.a9h);
            if (!(af.cnn() || this.ryl.cnv() == null || this.rzl != 0)) {
                ai cnM = af.cnM();
                String cuO = this.ryn.rEB.cuO();
                String cuP = this.ryn.rEB.cuP();
                j = this.ryl.cnv().qMB;
                int i5 = i4 - i;
                cnM.rmK = bo.yz();
                cnM.lQD = cuO;
                cnM.rmL = cuP;
                cnM.qMB = j;
                cnM.position = i2;
                cnM.rmM = i5;
                ab.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", Long.valueOf(cnM.rmK), cuO, cuP, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(cnM.rmM));
            }
            ab.d("MicroMsg.SnsTimeLineUI", "top h %d", Integer.valueOf(i4 - i));
            com.tencent.mm.sdk.b.a.xxA.d(this.ryn.rEA.hAA);
            if (af.cnn()) {
                ab.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
            } else {
                af.cnC();
            }
            au auVar = this.ryn.rEA;
            if (auVar.rqd != null) {
                auVar.rqd.activity = null;
            }
            com.tencent.mm.sdk.b.a.xxA.d(this.ryn.rEA.hAA);
            this.ryn.rEA.ctZ();
        }
        aw.clean();
        com.tencent.mm.sdk.b.a.xxA.d(this.ryJ);
        com.tencent.mm.kernel.g.RQ();
        if (com.tencent.mm.kernel.g.RN().QY()) {
            af.cnC().qIc.clear();
        }
        com.tencent.mm.plugin.sns.ui.a.a aVar = this.ryn;
        aVar.rEB.removeVendingDataChangedCallback(aVar.rED);
        aVar.rED = null;
        this.ryn = null;
        this.ryt = null;
        com.tencent.mm.plugin.sns.ui.a.a.cuM();
        com.tencent.mm.plugin.sns.abtest.c.cmc();
        f cnw = af.cnw();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(291, cnw);
        com.tencent.mm.plugin.sns.abtest.a.clean();
        this.mUIAction.onDestroy();
        super.onDestroy();
        com.tencent.mm.kiss.widget.textview.c.eNj.SN();
        com.tencent.mm.plugin.sns.ui.a.a.b bVar3 = this.rym;
        bVar3.rER = null;
        bVar3.hasInit = false;
        com.tencent.mm.plugin.sns.model.b cnA = af.cnA();
        if (!cnA.qHN.isEmpty()) {
            cnA.qHN.clear();
        }
        cnA = af.cnA();
        if (!cnA.qHO.isEmpty()) {
            cnA.qHO.clear();
        }
        AppMethodBeat.o(39563);
    }

    public void onResume() {
        int count;
        AppMethodBeat.i(39564);
        this.fAq = bo.anT();
        if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
            com.tencent.matrix.trace.f.c cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
            if (cVar != null) {
                cVar.a(this.mnM);
            }
        }
        if (com.tencent.mm.sdk.a.b.dnO() && com.tencent.mm.sdk.a.b.dnM()) {
            sUILeaksRoutineEnsuranceRef.add(this);
        }
        this.mUIAction.onResume();
        super.onResume();
        this.oes = bo.anT();
        if (this.rzj) {
            this.rzj = false;
            count = this.ryn.getCount();
            if (getIntent().getBooleanExtra("is_from_find_more", false)) {
                com.tencent.mm.modelsns.b c = com.tencent.mm.modelsns.b.c(getIntent(), "enter_log");
                if (c != null) {
                    if (count > 0) {
                        n DP = this.ryn.DP(0);
                        c.tx(DP == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : com.tencent.mm.plugin.sns.data.i.jV(DP.field_snsId));
                        c.tx(DP == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : DP.field_createTime);
                        c.tx(String.valueOf(count));
                    } else {
                        c.tx("");
                        c.tx("");
                        c.tx(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    c.ajK();
                }
            }
        }
        if (this.mScreenWidth == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            com.tencent.mm.plugin.sns.i.a aVar = this.ryz;
            count = this.mScreenWidth;
            int i = this.mScreenHeight;
            aVar.mScreenWidth = count;
            aVar.mScreenHeight = i;
        }
        if (af.cnn()) {
            finish();
        }
        af.cnC().qIe = this.ryn.rEA;
        SK().aG(com.tencent.mm.plugin.sns.k.c.b.class);
        u.a((ar) this);
        if (this.rys) {
            this.ryq.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39498);
                    ab.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.this.rys);
                    if (SnsTimeLineUI.this.rys) {
                        SnsTimeLineUI.this.rys = false;
                        SnsTimeLineUI.this.ryu.cur();
                    }
                    AppMethodBeat.o(39498);
                }
            });
        } else {
            a aVar2 = this.ryu;
            if (SnsTimeLineUI.this.ryq.getVisibility() == 0) {
                aVar2.init();
                LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
                layoutParams.y = (int) aVar2.rzP;
                SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
                SnsTimeLineUI.this.ryq.invalidate();
            }
        }
        tn tnVar = new tn();
        tnVar.cPI.cPJ = this.mUIAction.nDp.getFirstVisiblePosition();
        tnVar.cPI.cPK = this.mUIAction.nDp.getLastVisiblePosition();
        tnVar.cPI.cPL = this.mUIAction.nDp.getHeaderViewsCount();
        tnVar.cPI.type = 0;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        if (!(this.ryt == null || this.ryt.rhm == null)) {
            this.ryt.rhm.onResume();
        }
        if (this.ryn != null) {
            au auVar = this.ryn.rEA;
            com.tencent.mm.sdk.b.a.xxA.c(auVar.rqz);
            com.tencent.mm.sdk.b.a.xxA.c(auVar.rqy);
            com.tencent.mm.sdk.b.a.xxA.c(auVar.rqA);
        }
        if (!(this.ryt == null || this.ryt.rhn == null)) {
            this.ryt.rhn.qMn.kK(true);
            this.ryt.rhn.qMn.kL(false);
            this.ryt.rhn.qMn.kM(false);
            this.ryt.rhn.qMn.kN(false);
            this.ryt.rhn.qMn.kX(false);
            com.tencent.mm.plugin.sns.i.b bVar = this.ryt.rhn.qMn;
            bVar.kV(false);
            bVar.kW(false);
            bVar.kP(false);
            bVar.kU(false);
            bVar.kS(false);
            bVar.kU(false);
            bVar.kY(false);
            bVar.kT(false);
            bVar.kU(false);
            bVar.kQ(false);
            bVar.kR(false);
        }
        com.tencent.mm.plugin.sns.model.g cnC = af.cnC();
        cnC.qIf = 0;
        cnC.qIg = 0;
        com.tencent.mm.sdk.b.a.xxA.c(this.ryN);
        com.tencent.mm.sdk.b.a.xxA.c(this.ryM);
        AppMethodBeat.o(39564);
    }

    public void onStart() {
        AppMethodBeat.i(39565);
        super.onStart();
        AppMethodBeat.o(39565);
    }

    public void onStop() {
        AppMethodBeat.i(39566);
        super.onStop();
        AppMethodBeat.o(39566);
    }

    public void onPause() {
        AppMethodBeat.i(39567);
        this.ryq.clearAnimation();
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.ehv);
        this.ehv = 0;
        u.b((ar) this);
        af.cnC().qIe = null;
        tn tnVar = new tn();
        tnVar.cPI.type = 1;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        if (this.ryn != null) {
            au auVar = this.ryn.rEA;
            com.tencent.mm.sdk.b.a.xxA.d(auVar.rqz);
            com.tencent.mm.sdk.b.a.xxA.d(auVar.rqy);
            com.tencent.mm.sdk.b.a.xxA.d(auVar.rqA);
        }
        if (!(this.ryt == null || this.ryt.rhm == null)) {
            this.ryt.rhm.onPause();
        }
        if (!(this.ryt == null || this.ryt.rhn == null)) {
            this.ryt.rhn.qMn.kK(false);
        }
        com.tencent.mm.modelstat.d.h("SnsTimeLineUI", this.oes, bo.anT());
        this.mUIAction.onPause();
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.ryN);
        com.tencent.mm.sdk.b.a.xxA.d(this.ryM);
        if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
            com.tencent.matrix.trace.f.c cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
            if (cVar != null) {
                cVar.b(this.mnM);
            }
        }
        this.fAq = bo.anT() > this.fAq ? bo.anT() - this.fAq : 1;
        WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.eEO, this.fAq);
        this.eEO = 0;
        this.fAq = 0;
        AppMethodBeat.o(39567);
    }

    public final int getLayoutId() {
        return R.layout.awx;
    }

    public final void initView() {
        AppMethodBeat.i(39568);
        this.mUIAction.qQt.setDrawingCacheEnabled(false);
        this.ryt.qOM = (FrameLayout) findViewById(R.id.avv);
        int i = af.cnM().position;
        AdListView adListView = (AdListView) this.mUIAction.getSnsListView();
        adListView.rfN = this.rqn;
        adListView.setTimelineStat(this.ryA);
        adListView.setTimelineEvent(this.ryB);
        this.ryB.a(af.cnw());
        ab.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.rhv, Integer.valueOf(i));
        this.ryq = (QFadeImageView) findViewById(R.id.enj);
        this.ryq.setImageResource(R.raw.friendactivity_refresh);
        this.ryu = new a(this.mUIAction.getSnsListView());
        this.ryu.setInterpolator(new LinearInterpolator());
        this.ryu.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(39499);
                ab.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
                AppMethodBeat.o(39499);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(39500);
                ab.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
                AppMethodBeat.o(39500);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(39501);
                ab.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
                AppMethodBeat.o(39501);
            }
        });
        com.tencent.mm.plugin.sns.ui.a.b.b bVar = null;
        if (this.rzl == 1) {
            this.rys = true;
            bVar = new com.tencent.mm.plugin.sns.ui.a.b.d(this.igi, this.rjn);
        }
        this.ryn = new com.tencent.mm.plugin.sns.ui.a.a(this, this.mUIAction.getSnsListView(), this.ryt.rhA, this.ryt, this.ryC, bVar);
        this.ryt.rhA.rKo = new com.tencent.mm.plugin.sns.ui.au.a() {
            public final boolean cud() {
                AppMethodBeat.i(39502);
                SnsTimeLineUI.this.SK().aG(com.tencent.mm.plugin.sns.k.c.b.class);
                AppMethodBeat.o(39502);
                return false;
            }
        };
        this.ryt.qPr = this.ryn.rEA;
        this.ryn.rEB.zXa = new com.tencent.mm.vending.a.b.a() {
            public final void cuo() {
                AppMethodBeat.i(39503);
                com.tencent.mm.plugin.report.service.g.BN(14);
                AppMethodBeat.o(39503);
            }

            public final void cup() {
                AppMethodBeat.i(39504);
                com.tencent.mm.plugin.report.service.g.BO(14);
                AppMethodBeat.o(39504);
            }
        };
        this.ryv = (TestTimeForSns) this.ryt.qOM;
        this.ryv.setListener(new com.tencent.mm.plugin.sns.ui.TestTimeForSns.a() {
            public final void bCv() {
                AppMethodBeat.i(39508);
                ab.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
                SnsTimeLineUI.this.ryv.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39507);
                        if (SnsTimeLineUI.this.ryn == null || SnsTimeLineUI.this.ryv == null) {
                            ab.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
                            AppMethodBeat.o(39507);
                            return;
                        }
                        SnsTimeLineUI.this.ryv.setListener(null);
                        SnsTimeLineUI.this.rhv = SnsTimeLineUI.this.ryr;
                        if (SnsTimeLineUI.this.ryx) {
                            ab.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
                            AppMethodBeat.o(39507);
                            return;
                        }
                        if (SnsTimeLineUI.this.rhv) {
                            af.cnv().B(af.cnM().qMB, -1);
                        }
                        if (!SnsTimeLineUI.this.rhv) {
                            ab.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
                            com.tencent.mm.plugin.sns.ui.a.a.b o = SnsTimeLineUI.this.rym;
                            SnsTimeLineUI.this.rzh;
                            o.d(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, SnsTimeLineUI.this.rjn, SnsTimeLineUI.this.ryE);
                            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(1));
                        }
                        SnsTimeLineUI.this.rhv = false;
                        if (SnsTimeLineUI.this.rqn != null) {
                            SnsTimeLineUI.this.rqn.kH(false);
                        }
                        AppMethodBeat.o(39507);
                    }
                });
                AppMethodBeat.o(39508);
            }
        });
        this.mUIAction.nDp.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(39509);
                if (motionEvent.getAction() == 1) {
                    SnsTimeLineUI.this.crO();
                    if (SnsTimeLineUI.this.mUIAction.nDp != null && SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition() == 0) {
                        ab.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
                    }
                    SnsTimeLineUI.this.ryu.cut();
                }
                if (motionEvent.getAction() == 0) {
                    if (SnsTimeLineUI.this.mUIAction.nDp != null) {
                        SnsTimeLineUI.this.mUIAction.nDp.getFirstVisiblePosition();
                    }
                    SnsTimeLineUI.this.ryt.crD();
                    SnsTimeLineUI.this.ryt.rhr.cuL();
                }
                AppMethodBeat.o(39509);
                return false;
            }
        });
        this.mUIAction.nDp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39510);
                if (SnsTimeLineUI.this.ryt == null) {
                    AppMethodBeat.o(39510);
                    return;
                }
                SnsTimeLineUI.this.ryt.rhr.rpW = SnsTimeLineUI.this.mUIAction.nDp.getBottom();
                SnsTimeLineUI.this.ryt.rhr.rDO = SnsTimeLineUI.this.mUIAction.ooW.getTop();
                SnsTimeLineUI.this.ryu.rzX = SnsTimeLineUI.this.mUIAction.qQt.getTop();
                AppMethodBeat.o(39510);
            }
        });
        this.mUIAction.ooW.setOnSrcollDistance(new MMPullDownView.f() {
            public final void ba(float f) {
                AppMethodBeat.i(39511);
                SnsTimeLineUI.J(SnsTimeLineUI.this);
                if (SnsTimeLineUI.rza.booleanValue()) {
                    ab.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", Integer.valueOf(SnsTimeLineUI.this.mUIAction.qQt.getTop()), Integer.valueOf(SnsTimeLineUI.this.ryu.rzX), Float.valueOf(f));
                }
                if (SnsTimeLineUI.this.mUIAction.qQt.getTop() >= SnsTimeLineUI.this.ryu.rzX || f > 0.0f) {
                    SnsTimeLineUI.this.ryu.bb(f);
                }
                SnsTimeLineUI.this.ryt.crD();
                SnsTimeLineUI.this.crO();
                SnsTimeLineUI.this.ryt.rhr.cuL();
                AppMethodBeat.o(39511);
            }

            public final void cuq() {
                AppMethodBeat.i(39512);
                SnsTimeLineUI.this.ryu.cut();
                AppMethodBeat.o(39512);
            }
        });
        this.ryt.rhq = (SnsCommentFooter) findViewById(R.id.avz);
        this.ryt.rhq.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39513);
                com.tencent.mm.compatible.util.j.r(SnsTimeLineUI.this);
                AppMethodBeat.o(39513);
            }
        });
        this.ryt.rhr = new be(this.mUIAction.nDp, this.ryt.rhq);
        this.ryo = (LinearLayout) this.mUIAction.qQt.findViewById(R.id.ejg);
        this.ryo.findViewById(R.id.ejj).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39514);
                if (!(SnsTimeLineUI.this.ryt == null || SnsTimeLineUI.this.ryt.rhn == null)) {
                    SnsTimeLineUI.this.ryt.rhn.qMn.kN(true);
                }
                com.tencent.mm.plugin.sns.k.c.b bVar = (com.tencent.mm.plugin.sns.k.c.b) SnsTimeLineUI.this.SK().x(com.tencent.mm.plugin.sns.k.c.b.class);
                com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(725);
                lY.mb(bVar.rNt);
                lY.ajK();
                Intent intent = new Intent();
                intent.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
                SnsTimeLineUI.this.startActivityForResult(intent, 13);
                AppMethodBeat.o(39514);
            }
        });
        this.ryp = (LinearLayout) this.mUIAction.qQt.findViewById(R.id.eji);
        this.ryt.rhs = new an(this);
        cue();
        cuf();
        if (this.rzl == 0) {
            setMMTitle((int) R.string.eq0);
            AppMethodBeat.o(39568);
            return;
        }
        if (this.rjn) {
            setMMTitle((int) R.string.enj);
        } else {
            CharSequence Oj;
            ab.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", this.igi, this.mUIAction.title);
            ad aoO = af.cnt().aoO(this.igi);
            if (aoO != null) {
                ab.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
                Oj = aoO.Oj();
            } else {
                ab.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is null, title:%s", this.mUIAction.title);
                Oj = this.mUIAction.title;
            }
            setMMTitle(com.tencent.mm.plugin.sns.data.i.K(Oj));
        }
        Eg(8);
        AppMethodBeat.o(39568);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(39569);
        super.onKeyboardStateChanged();
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39515);
                SnsTimeLineUI.this.crO();
                AppMethodBeat.o(39515);
            }
        });
        if (this.mController.ymc == 2) {
            if (!(this.ryt == null || this.ryt.rhq == null || this.ryt.rhq.cte())) {
                ab.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
                AppMethodBeat.o(39569);
                return;
            }
        } else if (this.mController.ymc == 1 && this.ryt != null) {
            i iVar = this.ryt;
            if (iVar.rho) {
                iVar.rho = false;
                iVar.rhr.cuK();
            }
        }
        AppMethodBeat.o(39569);
    }

    public boolean supportNavigationSwipeBack() {
        AppMethodBeat.i(39570);
        boolean supportNavigationSwipeBack = super.supportNavigationSwipeBack();
        AppMethodBeat.o(39570);
        return supportNavigationSwipeBack;
    }

    private void cuf() {
        AppMethodBeat.i(39571);
        b(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39518);
                SnsTimeLineUI.K(SnsTimeLineUI.this);
                AppMethodBeat.o(39518);
            }
        }, new Runnable() {
            public final void run() {
            }
        });
        setBackBtn(this.rzm, R.raw.actionbar_icon_dark_back);
        AppMethodBeat.o(39571);
    }

    private void cug() {
        AppMethodBeat.i(39572);
        if (com.tencent.mm.r.a.bH(this)) {
            AppMethodBeat.o(39572);
            return;
        }
        ab.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "")), bo.dpG(), this);
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "")) {
            ab.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bo.dpG(), this);
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                ab.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", bo.anU() + "_" + bo.Mb(5));
                h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(2), r0, Long.valueOf(bo.anT()));
                com.tencent.mm.pluginsdk.ui.tools.n.c(this.mController.ylL, new Intent(), r0);
                AppMethodBeat.o(39572);
                return;
            }
            AppMethodBeat.o(39572);
            return;
        }
        AppMethodBeat.o(39572);
    }

    public final boolean dM(View view) {
        AppMethodBeat.i(39573);
        this.ryt.rhy.cox();
        bd bdVar = this.ryt.rhx;
        if (view.getTag() instanceof BaseViewHolder) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            String str = baseViewHolder.cwT;
            if (bdVar.rDJ != null) {
                if (bdVar.rDJ.getTag() instanceof a) {
                    a aVar = (a) bdVar.rDJ.getTag();
                    if (aVar.qPg.equals(str)) {
                        bdVar.dP(aVar.qCZ);
                        AppMethodBeat.o(39573);
                        return true;
                    }
                    bdVar.crO();
                }
                bdVar.rDJ = null;
            }
            bdVar.rDJ = new SnsCommentShowAbLayout(bdVar.mContext);
            com.tencent.mm.sdk.platformtools.n.ci(bdVar.rDJ);
            bdVar.rDJ.setId(R.id.ee);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            bdVar.qOM.addView(bdVar.rDJ);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(bdVar.mContext, 192.0f);
            int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(bdVar.mContext, 76.0f);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(bdVar.mContext, 20.0f);
            int b3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(bdVar.mContext, 12.0f);
            int b4 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(bdVar.mContext, 40.0f);
            View inflate = v.hu(bdVar.mContext).inflate(R.layout.auy, null);
            Rect rect = new Rect();
            int[] iArr = new int[2];
            com.tencent.mm.pluginsdk.f.fD(bdVar.mContext);
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(bdVar.mContext, 6);
            view.getLocationInWindow(iArr);
            bdVar.qDY = ae.hA(bdVar.mContext);
            ab.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + fromDPToPix + " height_hardcode:" + b2 + " statusBarHeight: " + bdVar.qDY);
            LayoutParams layoutParams2 = new LayoutParams(-2, -2, (iArr[0] - b) + b3, (iArr[1] - fromDPToPix) - ((b4 / 2) - (view.getMeasuredHeight() / 2)));
            bdVar.rDJ.setTag(new a(str, inflate));
            bdVar.rDJ.addView(inflate, layoutParams2);
            if (baseViewHolder.klY == 10) {
                inflate.findViewById(R.id.mc).setBackgroundResource(R.drawable.bme);
            }
            inflate.setVisibility(8);
            new ak().post(new com.tencent.mm.plugin.sns.ui.bd.AnonymousClass1(view, inflate));
            AppMethodBeat.o(39573);
            return true;
        }
        ab.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
        AppMethodBeat.o(39573);
        return false;
    }

    public final boolean crO() {
        AppMethodBeat.i(39574);
        if (this.ryt == null || this.ryt.rhx == null) {
            AppMethodBeat.o(39574);
            return false;
        }
        if (!(this.ryt == null || this.ryt.rhy == null)) {
            this.ryt.rhy.cox();
        }
        com.tencent.mm.plugin.sns.abtest.a.clW();
        boolean crO = this.ryt.rhx.crO();
        AppMethodBeat.o(39574);
        return crO;
    }

    public final void Zx() {
        AppMethodBeat.i(39575);
        SK().aG(com.tencent.mm.plugin.sns.k.c.b.class);
        AppMethodBeat.o(39575);
    }

    public final void Zy() {
    }

    public final void Zz() {
        AppMethodBeat.i(39576);
        if (this.rzr) {
            AppMethodBeat.o(39576);
            return;
        }
        ab.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
        this.rzr = true;
        af.bCo().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39528);
                if (SnsTimeLineUI.this.ryn != null) {
                    SnsTimeLineUI.this.ryn.rEB.notifyVendingDataChange();
                }
                SnsTimeLineUI.this.rzr = false;
                AppMethodBeat.o(39528);
            }
        }, 1000);
        AppMethodBeat.o(39576);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(39577);
        ab.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + mVar.getType());
        if (mVar.getType() == 218) {
            com.tencent.mm.plugin.sns.model.r rVar = (com.tencent.mm.plugin.sns.model.r) mVar;
            if ((rVar.type == 1 || rVar.type == 6 || rVar.type == 4) && this.ryt.rhB != null) {
                this.ryt.rhB.dismiss();
            }
            if (rVar.type == 11) {
                if (this.mUIAction.tipDialog != null) {
                    this.mUIAction.tipDialog.dismiss();
                }
                if (this.rzn != null) {
                    this.rzn.setImageResource(R.raw.icons_outlined_camera);
                }
            }
        }
        if (this.ryn != null) {
            this.ryn.rEB.notifyVendingDataChange();
        }
        if (mVar.getType() == 211) {
            y yVar = (y) mVar;
            com.tencent.mm.modelsns.b lY;
            if (yVar.qIW) {
                lY = com.tencent.mm.modelsns.b.lY(727);
                lY.mb(this.ryn.getCount()).mb(yVar.afg);
                lY.ajK();
            } else {
                lY = com.tencent.mm.modelsns.b.lY(728);
                lY.mb(this.ryn.getCount()).mb(yVar.afg).mb(0);
                lY.ajK();
            }
            if (this.ryu != null) {
                this.rys = false;
                this.ryu.cus();
            }
        }
        AppMethodBeat.o(39577);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(39578);
        ab.d("MicroMsg.SnsTimeLineUI", "finalize");
        super.finalize();
        AppMethodBeat.o(39578);
    }

    public final void ZA() {
        AppMethodBeat.i(39579);
        SK().aG(com.tencent.mm.plugin.sns.k.c.b.class);
        AppMethodBeat.o(39579);
    }

    public void onBackPressed() {
        AppMethodBeat.i(39580);
        finish();
        AppMethodBeat.o(39580);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39581);
        ab.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 15) {
            if (!(this.ryt == null || this.ryt.rhA == null || this.ryt.rhA.rJH == null)) {
                this.ryt.rhA.rJH.onActivityResult(i, i2, intent);
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39533);
                        SnsTimeLineUI.this.aqX();
                        AppMethodBeat.o(39533);
                    }
                }, 300);
            }
            AppMethodBeat.o(39581);
        } else if (i == 16) {
            ab.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
            AppMethodBeat.o(39581);
        } else {
            if (i == 2333 && intent != null) {
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!bo.isNullOrNil(stringExtra)) {
                    String[] split = stringExtra.split(",");
                    if (split.length > 0) {
                        this.ryt.rhq.crP.showVKB();
                        stringExtra = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(split[0]);
                        if (!bo.isNullOrNil(stringExtra)) {
                            this.ryt.rhq.ctg();
                            this.ryt.rhq.setText("@" + stringExtra + " ");
                            this.ryt.rhq.setCommentAtPrefix("@" + stringExtra + " ");
                            this.ryt.rhq.setCommentInfo(new cat());
                            this.ryt.rhq.getCommentInfo().vHl = split[0];
                            this.ryt.rhq.setCommentFlag(8);
                        }
                    }
                }
            }
            super.onActivityResult(i, i2, intent);
            this.mUIAction.onActivityResult(i, i2, intent);
            if (i == 11) {
                this.rym.d(this.igi, this.ryD, this.rjn, this.ryE);
                AppMethodBeat.o(39581);
                return;
            }
            AppMethodBeat.o(39581);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(39582);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(39582);
            return;
        }
        ab.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 18:
                if (iArr[0] != 0) {
                    int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a((Context) this, getString(i2), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(39534);
                                dialogInterface.dismiss();
                                SnsTimeLineUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                AppMethodBeat.o(39534);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(39535);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(39535);
                            }
                        });
                        break;
                    }
                }
                cug();
                AppMethodBeat.o(39582);
                return;
                break;
        }
        AppMethodBeat.o(39582);
    }

    public void onDrag() {
        AppMethodBeat.i(39583);
        super.onDrag();
        AppMethodBeat.o(39583);
    }

    public final void lm(boolean z) {
        AppMethodBeat.i(39584);
        if (this.ryn != null) {
            ab.i("MicroMsg.SnsTimeLineUI", "set play animation %s", Boolean.valueOf(z));
            com.tencent.mm.plugin.sns.ui.a.a aVar = this.ryn;
            aVar.rEC = z;
            if (!z) {
                aVar.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(39584);
    }

    private static void a(c cVar) {
        AppMethodBeat.i(39585);
        if (cVar.active) {
            ab.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", cVar.toString());
            h.pYm.X(15827, cVar.toString());
        }
        AppMethodBeat.o(39585);
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i, int i2, gs gsVar) {
        AppMethodBeat.i(39588);
        int firstVisiblePosition = snsTimeLineUI.ryt.nDp.getFirstVisiblePosition();
        int headerViewsCount = snsTimeLineUI.ryt.nDp.getHeaderViewsCount();
        n DP = snsTimeLineUI.ryt.qPr.DP(i2);
        if (DP != null) {
            TimeLineObject cqu = DP.cqu();
            if (cqu.xfI.wbJ == 1 && cqu.xfI.wbK.size() == 4 && i > 1) {
                i++;
            }
        } else {
            ab.e("MicroMsg.SnsTimeLineUI", "snsInfo is null");
        }
        View childAt = snsTimeLineUI.ryt.nDp.getChildAt((i2 - firstVisiblePosition) + headerViewsCount);
        if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof BaseViewHolder))) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) childAt.getTag();
            childAt = baseViewHolder.rHT != null ? baseViewHolder.rHT.DT(i) : baseViewHolder.rIn != null ? baseViewHolder.rHF : null;
            if (childAt != null) {
                int[] iArr = new int[2];
                childAt.getLocationInWindow(iArr);
                gsVar.cBs.ctT = iArr[0];
                gsVar.cBs.ctU = iArr[1];
                gsVar.cBs.ctV = childAt.getWidth();
                gsVar.cBs.ctW = childAt.getHeight();
            }
        }
        AppMethodBeat.o(39588);
    }

    static /* synthetic */ void E(SnsTimeLineUI snsTimeLineUI) {
        com.tencent.mm.ui.base.m mVar;
        AppMethodBeat.i(39594);
        com.tencent.mm.kernel.g.RQ();
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, null);
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.kernel.g.RQ();
            String str2 = (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, (Object) "");
            new com.tencent.mm.g.b.a.ah().Fs().fk(str2).ajK();
            byte[] atV = com.tencent.d.f.e.atV(str);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(atV, 0, atV.length);
            obtain.setDataPosition(0);
            try {
                Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                intent.addFlags(268435456);
                intent.setClass(snsTimeLineUI, SnsUploadUI.class);
                intent.putExtra("KSessionID", str2);
                snsTimeLineUI.startActivity(intent);
                AppMethodBeat.o(39594);
                return;
            } catch (Exception e) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) "");
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_LAST_SESSIONID_STRING, (Object) "");
            }
        }
        if (snsTimeLineUI.rzo != null) {
            snsTimeLineUI.rzo.setVisibility(8);
        }
        if (!(snsTimeLineUI.ryt == null || snsTimeLineUI.ryt.rhn == null)) {
            snsTimeLineUI.ryt.rhn.qMn.kO(true);
        }
        final com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(705);
        lY.mc(lY.fQh).ty(System.currentTimeMillis()).mc(lY.fQi).mc(1);
        final ArrayList arrayList = new ArrayList();
        if (!com.tencent.mm.platformtools.ae.gjt) {
            mVar = new com.tencent.mm.ui.base.m(snsTimeLineUI, 3, 0);
            mVar.setTitle(snsTimeLineUI.getString(R.string.q4));
            arrayList.add(mVar);
        }
        mVar = new com.tencent.mm.ui.base.m(snsTimeLineUI, 1, 0);
        mVar.setTitle(snsTimeLineUI.getString(R.string.qa));
        arrayList.add(mVar);
        if (am.coc()) {
            snsTimeLineUI.ryH.active = true;
            mVar = new com.tencent.mm.ui.base.m(snsTimeLineUI, 4, 0);
            mVar.setTitle(snsTimeLineUI.getString(R.string.qo));
            arrayList.add(mVar);
        } else {
            snsTimeLineUI.ryH.active = false;
        }
        snsTimeLineUI.rzp = new ax(snsTimeLineUI);
        snsTimeLineUI.rzp.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(39521);
                for (com.tencent.mm.ui.base.m i : arrayList) {
                    lVar.i(i);
                }
                AppMethodBeat.o(39521);
            }
        };
        snsTimeLineUI.rzp.c(3, snsTimeLineUI.mController.ylL.getString(R.string.q9));
        snsTimeLineUI.rzp.c(4, snsTimeLineUI.mController.ylL.getString(R.string.qp));
        snsTimeLineUI.rzp.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(39522);
                switch (menuItem.getItemId()) {
                    case 1:
                        h.pYm.e(13822, Integer.valueOf(2), Integer.valueOf(2));
                        com.tencent.mm.plugin.sns.i.g.qTp.b(lY);
                        lY.ajK();
                        SnsTimeLineUI.this.mUIAction.rCd = lY;
                        SnsTimeLineUI.this.mUIAction.Em(1);
                        SnsTimeLineUI.this.ryH.Ei(2);
                        SnsTimeLineUI.b(SnsTimeLineUI.this.ryH);
                        AppMethodBeat.o(39522);
                        return;
                    case 3:
                        SnsTimeLineUI.this.ryH.Ei(1);
                        SnsTimeLineUI.b(SnsTimeLineUI.this.ryH);
                        SnsTimeLineUI.M(SnsTimeLineUI.this);
                        AppMethodBeat.o(39522);
                        return;
                    case 4:
                        SnsTimeLineUI.this.ryH.Ei(3);
                        SnsTimeLineUI.b(SnsTimeLineUI.this.ryH);
                        SnsTimeLineUI.N(SnsTimeLineUI.this);
                        break;
                }
                AppMethodBeat.o(39522);
            }
        };
        ax axVar = snsTimeLineUI.rzp;
        axVar.rBk.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(39523);
                SnsTimeLineUI.this.ryH.Ei(10);
                SnsTimeLineUI.b(SnsTimeLineUI.this.ryH);
                AppMethodBeat.o(39523);
            }
        });
        snsTimeLineUI.rzp.cuu();
        c cVar = snsTimeLineUI.ryH;
        if (cVar.active) {
            cVar.reset();
            cVar.rAf = bo.anU() + "_" + bo.Mb(5);
            cVar.scene = 1;
            cVar.rAg = bo.anU();
            com.tencent.mm.kernel.g.RQ();
            cVar.rAh = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(0))).intValue();
        }
        AppMethodBeat.o(39594);
    }

    static /* synthetic */ void J(SnsTimeLineUI snsTimeLineUI) {
        int i = 1;
        AppMethodBeat.i(39595);
        if (snsTimeLineUI.ryw <= 3) {
            int firstVisiblePosition = snsTimeLineUI.mUIAction.nDp.getFirstVisiblePosition();
            if (System.currentTimeMillis() - snsTimeLineUI.rzb > 1000 || firstVisiblePosition > snsTimeLineUI.oOX) {
                snsTimeLineUI.rzb = 0;
                snsTimeLineUI.oOX = snsTimeLineUI.mUIAction.nDp.getFirstVisiblePosition();
            }
            snsTimeLineUI.rzb = System.currentTimeMillis();
            if (snsTimeLineUI.oOX - firstVisiblePosition >= 10 && firstVisiblePosition > 10) {
                ab.i("MicroMsg.SnsTimeLineUI", "showTopTip %d", Integer.valueOf(snsTimeLineUI.ryw));
                if (snsTimeLineUI.ryw <= 3) {
                    q qVar = snsTimeLineUI.mController;
                    if (qVar.mActionBar == null || qVar.mActionBar.getCustomView() == null || qVar.mActionBar.getCustomView().findViewById(R.id.l8) == null) {
                        i = 0;
                    }
                    if (i == 0) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snsTimeLineUI.mController.ylL, R.anim.cd);
                        String string = snsTimeLineUI.getString(R.string.ejy);
                        q qVar2 = snsTimeLineUI.mController;
                        if (qVar2.mActionBar != null) {
                            qVar2.mActionBar.setCustomView(q.ylZ);
                            TextView textView = (TextView) qVar2.mActionBar.getCustomView().findViewById(R.id.l8);
                            if (textView != null) {
                                textView.clearAnimation();
                                if (loadAnimation != null) {
                                    textView.startAnimation(loadAnimation);
                                }
                                if (!bo.isNullOrNil(string)) {
                                    textView.setText(string);
                                }
                            }
                        }
                        snsTimeLineUI.mController.removeAllOptionMenu();
                        snsTimeLineUI.removeOptionMenu(16908332);
                        snsTimeLineUI.setTitleBarDoubleClickListener(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(39516);
                                SnsTimeLineUI.K(SnsTimeLineUI.this);
                                AppMethodBeat.o(39516);
                            }
                        });
                        snsTimeLineUI.ryw++;
                        af.bCo().removeCallbacks(snsTimeLineUI.rzg);
                        af.bCo().postDelayed(snsTimeLineUI.rzg, 4000);
                    }
                }
            }
        }
        AppMethodBeat.o(39595);
    }

    static /* synthetic */ void K(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(39596);
        ab.i("MicroMsg.SnsTimeLineUI", "double click， first visible：%s", Integer.valueOf(snsTimeLineUI.mUIAction.nDp.getFirstVisiblePosition()));
        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(snsTimeLineUI.mUIAction.nDp);
        snsTimeLineUI.Eg(0);
        if (snsTimeLineUI.mUIAction.nDp.getFirstVisiblePosition() != 0) {
            snsTimeLineUI.rzg.run();
        }
        snsTimeLineUI.ryt.crD();
        snsTimeLineUI.crO();
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39527);
                SnsTimeLineUI.this.mUIAction.nDp.setSelection(0);
                a h = SnsTimeLineUI.this.ryu;
                if (h.rzY) {
                    if (SnsTimeLineUI.rza.booleanValue()) {
                        ab.i("MicroMsg.SnsTimeLineUI", "force init %s %s %s", Boolean.valueOf(h.rzY), Float.valueOf(h.rAb), Integer.valueOf(h.rzZ));
                    }
                    LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.this.ryq.getLayoutParams();
                    layoutParams.y = h.rzZ;
                    SnsTimeLineUI.this.ryq.setLayoutParams(layoutParams);
                    h.rzO = h.rAa;
                    h.rzS = h.rAb;
                }
                SnsTimeLineUI.this.ryu.cur();
                com.tencent.mm.plugin.sns.ui.a.a.b o = SnsTimeLineUI.this.rym;
                SnsTimeLineUI.this.rzh;
                o.d(SnsTimeLineUI.this.igi, SnsTimeLineUI.this.ryD, SnsTimeLineUI.this.rjn, SnsTimeLineUI.this.ryE);
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(2));
                AppMethodBeat.o(39527);
            }
        }, 300);
        AppMethodBeat.o(39596);
    }

    static /* synthetic */ void N(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(39599);
        final b bVar = new b(snsTimeLineUI, (byte) 0);
        if (am.eO(snsTimeLineUI)) {
            bVar.rAe = R.string.qn;
            bVar.type = 2;
            snsTimeLineUI.ryH.Ej(1);
        } else {
            bVar.rAe = R.string.qm;
            bVar.type = 0;
            snsTimeLineUI.ryH.Ej(2);
        }
        a(snsTimeLineUI.ryH);
        com.tencent.mm.ui.base.h.a((Context) snsTimeLineUI, bVar.rAe, (int) R.string.tz, (int) R.string.s6, (int) R.string.or, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(39524);
                SnsTimeLineUI.this.ryH.Ek(1);
                SnsTimeLineUI.b(SnsTimeLineUI.this.ryH);
                switch (bVar.type) {
                    case 0:
                        SnsTimeLineUI.P(SnsTimeLineUI.this);
                        break;
                    case 2:
                        SnsTimeLineUI.O(SnsTimeLineUI.this);
                        AppMethodBeat.o(39524);
                        return;
                }
                AppMethodBeat.o(39524);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(39525);
                if (SnsTimeLineUI.this.ryH.scene != 3) {
                    if (i == 0) {
                        SnsTimeLineUI.this.ryH.Ek(3);
                    } else {
                        SnsTimeLineUI.this.ryH.Ek(2);
                    }
                    SnsTimeLineUI.b(SnsTimeLineUI.this.ryH);
                }
                AppMethodBeat.o(39525);
            }
        });
        AppMethodBeat.o(39599);
    }

    static /* synthetic */ void O(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(39600);
        if (!com.tencent.mm.r.a.bH(snsTimeLineUI)) {
            ab.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", bo.anU() + "_" + bo.Mb(5));
            h.pYm.e(13822, Integer.valueOf(1), Integer.valueOf(2), r0, Long.valueOf(bo.anT()));
            com.tencent.mm.pluginsdk.ui.tools.n.f(snsTimeLineUI.mController.ylL, new Intent(), r0);
        }
        AppMethodBeat.o(39600);
    }

    static /* synthetic */ void P(SnsTimeLineUI snsTimeLineUI) {
        AppMethodBeat.i(39601);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://mobile.qzone.qq.com/l?g=4991");
        com.tencent.mm.bp.d.b((Context) snsTimeLineUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(39601);
    }
}
