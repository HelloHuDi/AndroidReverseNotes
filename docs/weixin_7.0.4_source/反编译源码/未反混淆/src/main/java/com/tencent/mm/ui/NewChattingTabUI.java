package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.i.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.h;

public class NewChattingTabUI implements a {
    MMFragmentActivity iWA;
    boolean isAnimating = false;
    boolean mChattingClosed = true;
    private Animation mChattingInAnim;
    private Animation mChattingOutAnim;
    private IChattingUIProxy mChattingUIProxy;
    private boolean mNeedChattingAnim;
    Bitmap mPrepareBitmap;
    Runnable mStartChattingRunnable = new Runnable() {
        public final void run() {
            AppMethodBeat.i(29797);
            if (!NewChattingTabUI.this.mChattingClosed) {
                ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "start chatting but last chatting does't be close!");
                NewChattingTabUI.this.pW(false);
            }
            if (NewChattingTabUI.this.iWA.isFinishing() || NewChattingTabUI.this.iWA.isPaused() || !NewChattingTabUI.this.mChattingClosed) {
                ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s", Boolean.valueOf(NewChattingTabUI.this.iWA.isPaused()), Boolean.valueOf(NewChattingTabUI.this.mChattingClosed));
                NewChattingTabUI.this.ypq = true;
                AppMethodBeat.o(29797);
                return;
            }
            boolean z;
            NewChattingTabUI.this.mChattingClosed = false;
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "ashutest::startChatting, ishow:%b";
            Object[] objArr = new Object[1];
            if (NewChattingTabUI.this.ypg == null) {
                z = false;
            } else {
                z = NewChattingTabUI.this.ypg.isShown();
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            Intent putExtra = new Intent().putExtra("Chat_User", NewChattingTabUI.this.ypl);
            if (NewChattingTabUI.this.ypm != null) {
                putExtra.putExtras(NewChattingTabUI.this.ypm);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            NewChattingTabUI.a(NewChattingTabUI.this, putExtra, false);
            NewChattingTabUI.this.ypj.setOnChattingLayoutChangedListener(NewChattingTabUI.this.onChattingLayoutChangedListener);
            NewChattingTabUI.this.ypg.setVisibility(0);
            NewChattingTabUI.this.ypg.setTranslationX((NewChattingTabUI.this.iWA.getWindow().getDecorView().getWidth() == 0 ? (float) NewChattingTabUI.this.iWA.getResources().getDisplayMetrics().widthPixels : (float) NewChattingTabUI.this.iWA.getWindow().getDecorView().getWidth()) - 0.1f);
            NewChattingTabUI.this.ypf = ah.anT();
            NewChattingTabUI.q(NewChattingTabUI.this);
            if (NewChattingTabUI.r(NewChattingTabUI.this)) {
                h.a(NewChattingTabUI.this.iWA);
            }
            AppMethodBeat.o(29797);
        }

        public final String toString() {
            AppMethodBeat.i(29798);
            String str = super.toString() + "|startChattingRunnable";
            AppMethodBeat.o(29798);
            return str;
        }
    };
    private com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a() {
        long start = 0;

        public final void dyX() {
            AppMethodBeat.i(29802);
            if (NewChattingTabUI.this.mChattingInAnim == null) {
                NewChattingTabUI.this.mChattingInAnim = AnimationUtils.loadAnimation(NewChattingTabUI.this.iWA, com.tencent.mm.ui.MMFragmentActivity.a.ync);
                NewChattingTabUI.this.mChattingInAnim.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        AppMethodBeat.i(29799);
                        NewChattingTabUI.t(NewChattingTabUI.this);
                        NewChattingTabUI.this.G(false, 0);
                        AppMethodBeat.o(29799);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(29800);
                        NewChattingTabUI.u(NewChattingTabUI.this);
                        AppMethodBeat.o(29800);
                    }
                });
            }
            if (NewChattingTabUI.this.mNeedChattingAnim) {
                NewChattingTabUI.this.ypg.setOndispatchDraw(new com.tencent.mm.ui.tools.TestTimeForChatting.a() {
                    public final void dyY() {
                        AppMethodBeat.i(29801);
                        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
                        AnonymousClass6.this.start = System.currentTimeMillis();
                        if (NewChattingTabUI.this.ypn.getSwipeBackLayout() != null) {
                            NewChattingTabUI.this.ypn.getSwipeBackLayout().setNeedChangeWindowBackground(false);
                            NewChattingTabUI.this.ypn.getSwipeBackLayout().startAnimation(NewChattingTabUI.this.mChattingInAnim);
                        } else {
                            NewChattingTabUI.this.ypn.getView().startAnimation(NewChattingTabUI.this.mChattingInAnim);
                        }
                        NewChattingTabUI.this.ypg.setOndispatchDraw(null);
                        AppMethodBeat.o(29801);
                    }
                });
                NewChattingTabUI.this.mNeedChattingAnim = false;
            } else {
                NewChattingTabUI.t(NewChattingTabUI.this);
                NewChattingTabUI.u(NewChattingTabUI.this);
            }
            NewChattingTabUI.this.ypj.yAx = null;
            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
            AppMethodBeat.o(29802);
        }
    };
    private b ype;
    long ypf = 0;
    private TestTimeForChatting ypg;
    private int yph;
    IdleHandler ypi;
    private OnLayoutChangedLinearLayout ypj;
    String ypk;
    private String ypl;
    private Bundle ypm;
    BaseChattingUIFragment ypn;
    private long ypo;
    a ypp = new a(this, (byte) 0);
    boolean ypq = false;

    class a implements Runnable {
        int bFZ;
        Intent cEd;
        int requestCode;
        int ypy;

        private a() {
            this.ypy = 0;
        }

        /* synthetic */ a(NewChattingTabUI newChattingTabUI, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(29809);
            if (aw.RK() && NewChattingTabUI.this.iWA != null) {
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.ypy));
                NewChattingTabUI.this.startChatting(NewChattingTabUI.this.ypk, null, false);
                al.d(new Runnable() {
                    public final void run() {
                        boolean z = true;
                        AppMethodBeat.i(29807);
                        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                        Object[] objArr = new Object[1];
                        if (NewChattingTabUI.this.ypn != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        ab.d(str, str2, objArr);
                        if (NewChattingTabUI.this.ypn != null) {
                            ab.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
                            NewChattingTabUI.this.ypn.onActivityResult(a.this.requestCode & CdnLogic.kBizGeneric, a.this.bFZ, a.this.cEd);
                        }
                        AppMethodBeat.o(29807);
                    }

                    public final String toString() {
                        AppMethodBeat.i(29808);
                        String str = super.toString() + "|PostSelectImageJob_onActivityResult";
                        AppMethodBeat.o(29808);
                        return str;
                    }
                });
                AppMethodBeat.o(29809);
            } else if (this.ypy >= 3) {
                ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
                AppMethodBeat.o(29809);
            } else {
                String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                String str2 = "on post select image job, acc not ready or view init(%B), cur retry count %d";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(NewChattingTabUI.this.iWA != null);
                objArr[1] = Integer.valueOf(this.ypy);
                ab.w(str, str2, objArr);
                this.ypy++;
                al.n(this, 300);
                AppMethodBeat.o(29809);
            }
        }

        public final String toString() {
            AppMethodBeat.i(29810);
            String str = super.toString() + "|PostSelectImageJob";
            AppMethodBeat.o(29810);
            return str;
        }
    }

    static /* synthetic */ void q(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(29825);
        newChattingTabUI.kT(3);
        AppMethodBeat.o(29825);
    }

    static /* synthetic */ boolean r(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(29826);
        boolean cXe = newChattingTabUI.cXe();
        AppMethodBeat.o(29826);
        return cXe;
    }

    static /* synthetic */ void x(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(29829);
        newChattingTabUI.tryResetChattingSwipeStatus();
        AppMethodBeat.o(29829);
    }

    public NewChattingTabUI(b bVar) {
        AppMethodBeat.i(29811);
        this.ype = bVar;
        AppMethodBeat.o(29811);
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(29812);
        this.ypo = System.currentTimeMillis();
        String str2 = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str3 = "try startChatting, ishow:%b userName:%s needAnim:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.ypg == null ? false : this.ypg.isShown());
        objArr[1] = str;
        objArr[2] = Boolean.valueOf(z);
        ab.i(str2, str3, objArr);
        if (!(this.ypn == null || this.ypn.getView() == null)) {
            this.ypn.getView().setImportantForAccessibility(1);
        }
        aw.getNotification().bv(false);
        this.ypq = false;
        this.ypm = bundle;
        this.ypl = str;
        this.mNeedChattingAnim = z;
        aw.RS().doK();
        al.Ma(-8);
        al.af(this.mStartChattingRunnable);
        al.d(this.mStartChattingRunnable);
        AppMethodBeat.o(29812);
    }

    static boolean acceptRequestCode(int i) {
        AppMethodBeat.i(29813);
        ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", Integer.valueOf(CdnLogic.kBizGeneric & i));
        switch (CdnLogic.kBizGeneric & i) {
            case 217:
            case 218:
            case 226:
                AppMethodBeat.o(29813);
                return true;
            default:
                AppMethodBeat.o(29813);
                return false;
        }
    }

    public final boolean dxM() {
        if (this.ypn == null) {
            return false;
        }
        return this.ypn.cgL.caA;
    }

    /* Access modifiers changed, original: final */
    public final void kT(final int i) {
        AppMethodBeat.i(29816);
        if (this.ypn == null) {
            AppMethodBeat.o(29816);
            return;
        }
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29796);
                com.tencent.mm.modelstat.d.b(i, "ChattingUI" + NewChattingTabUI.h(NewChattingTabUI.this), hashCode());
                if (i == 4) {
                    com.tencent.mm.modelstat.d.h("ChattingUI" + NewChattingTabUI.h(NewChattingTabUI.this), NewChattingTabUI.this.ypf, ah.anT());
                }
                AppMethodBeat.o(29796);
            }
        }, "MicroMsg.LauncherUI.NewChattingTabUI|report");
        AppMethodBeat.o(29816);
    }

    private Bitmap getMagicDrawingCache(View view) {
        AppMethodBeat.i(29817);
        long currentTimeMillis = System.currentTimeMillis();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0) {
            width = view.getMeasuredWidth();
        }
        if (height <= 0) {
            height = view.getMeasuredHeight();
        }
        if (width <= 0 || height <= 0) {
            ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", Integer.valueOf(width), Integer.valueOf(height));
            AppMethodBeat.o(29817);
            return null;
        } else if (this.ypn.getView() == null) {
            AppMethodBeat.o(29817);
            return null;
        } else {
            if (this.ypn != null) {
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", Integer.valueOf(this.ypn.getView().getBottom()), Integer.valueOf(this.ypn.keyboardState()));
            }
            if (this.ypn == null || this.ypn.getView().getBottom() <= 0 || (this.ypn.keyboardState() != 1 && this.ypn.getView().getBottom() >= (this.iWA.getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
                if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != width || this.mPrepareBitmap.getHeight() != height) {
                    if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
                        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", this.mPrepareBitmap.toString());
                        this.mPrepareBitmap.recycle();
                    }
                    try {
                        this.mPrepareBitmap = com.tencent.mm.sdk.platformtools.d.createBitmap(width, height, Config.ARGB_4444);
                        if (this.mPrepareBitmap == null) {
                            AppMethodBeat.o(29817);
                            return null;
                        }
                    } catch (OutOfMemoryError e) {
                        ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", e);
                        AppMethodBeat.o(29817);
                        return null;
                    }
                }
                view.draw(new Canvas(this.mPrepareBitmap));
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                Bitmap bitmap = this.mPrepareBitmap;
                AppMethodBeat.o(29817);
                return bitmap;
            }
            ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", Integer.valueOf(this.ypn.keyboardState()));
            this.iWA.getWindow().setBackgroundDrawableResource(R.color.y9);
            AppMethodBeat.o(29817);
            return null;
        }
    }

    public final boolean pW(boolean z) {
        AppMethodBeat.i(29818);
        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.ypg == null ? false : this.ypg.isShown());
        ab.i(str, str2, objArr);
        if (!(this.ypn == null || this.ypn.getView() == null)) {
            this.ypn.getView().setImportantForAccessibility(4);
        }
        if (this.ypg == null || this.ypg.getVisibility() == 8 || this.ypn == null || this.iWA == null) {
            AppMethodBeat.o(29818);
            return false;
        }
        if (this.ypn != null && this.ypn.isSupportNavigationSwipeBack()) {
            h.b(this.iWA);
        }
        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", Boolean.valueOf(z));
        kT(4);
        this.mChattingClosed = true;
        if (z && this.mChattingOutAnim == null) {
            this.mChattingOutAnim = AnimationUtils.loadAnimation(this.iWA, com.tencent.mm.ui.MMFragmentActivity.a.ynf);
            this.mChattingOutAnim.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(29803);
                    NewChattingTabUI.this.isAnimating = true;
                    aw.RS().doK();
                    al.Ma(-8);
                    NewChattingTabUI.this.G(true, 0);
                    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
                    AppMethodBeat.o(29803);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(29804);
                    NewChattingTabUI.this.isAnimating = false;
                    NewChattingTabUI.this.ypg.setVisibility(8);
                    aw.RS().doM();
                    al.Ma(0);
                    NewChattingTabUI.x(NewChattingTabUI.this);
                    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
                    AppMethodBeat.o(29804);
                }
            });
        }
        y.d(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
        if (this.ypn.isSupportCustomActionBar()) {
            ImageView imageView = (ImageView) this.iWA.getWindow().getDecorView().findViewById(R.id.c4);
            if (imageView != null && imageView.getVisibility() == 0) {
                imageView.setVisibility(8);
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
            }
        }
        Ns(0);
        if (z) {
            this.mChattingUIProxy.onExitBegin();
            this.mChattingUIProxy.onExitEnd();
            this.ypg.startAnimation(this.mChattingOutAnim);
        } else {
            this.mChattingUIProxy.onExitBegin();
            this.mChattingUIProxy.onExitEnd();
            this.ypg.setVisibility(8);
            this.iWA.onSwipe(1.0f);
            tryResetChattingSwipeStatus();
        }
        AppMethodBeat.o(29818);
        return true;
    }

    private void tryResetChattingSwipeStatus() {
        boolean z = true;
        AppMethodBeat.i(29819);
        if (cXe()) {
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.ypn != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            if (this.ypn != null) {
                this.ypn.getSwipeBackLayout().zOp = false;
            }
            AppMethodBeat.o(29819);
            return;
        }
        AppMethodBeat.o(29819);
    }

    public final boolean G(boolean z, int i) {
        AppMethodBeat.i(29820);
        ab.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(this.ype.dxp()));
        if (cXe()) {
            if (z) {
                this.ype.dxs();
            }
            if (this.ype.dxp()) {
                View findViewById = this.iWA.findViewById(R.id.bp);
                if (findViewById == null) {
                    ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
                    AppMethodBeat.o(29820);
                    return true;
                }
                ImageView imageView = (ImageView) this.iWA.findViewById(R.id.c4);
                if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
                    imageView.setVisibility(0);
                    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
                    findViewById.setVisibility(8);
                }
                if (imageView == null || imageView.getVisibility() != 0) {
                    int width = findViewById.getWidth() == 0 ? this.iWA.getResources().getDisplayMetrics().widthPixels : findViewById.getWidth();
                    if (z) {
                        com.tencent.mm.ui.tools.h.a(findViewById, 224, 0.0f, null);
                    } else {
                        com.tencent.mm.ui.tools.h.a(findViewById, 256, ((float) (width * -1)) / 3.5f, null);
                    }
                } else {
                    int width2 = imageView.getWidth() == 0 ? this.iWA.getResources().getDisplayMetrics().widthPixels : imageView.getWidth();
                    if (z) {
                        com.tencent.mm.ui.tools.h.a(imageView, 224, 0.0f, null);
                    } else {
                        com.tencent.mm.ui.tools.h.a(imageView, 256, ((float) (width2 * -1)) / 3.5f, null);
                    }
                }
                AppMethodBeat.o(29820);
                return true;
            }
            AppMethodBeat.o(29820);
            return false;
        }
        AppMethodBeat.o(29820);
        return true;
    }

    public final boolean bo(float f) {
        AppMethodBeat.i(29821);
        ab.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", Float.valueOf(f), Long.valueOf(320), Boolean.valueOf(this.ype.dxp()));
        if (cXe()) {
            ImageView imageView;
            boolean z;
            if (f == 0.0f && !this.mChattingClosed) {
                Ns(0);
                imageView = (ImageView) this.iWA.getWindow().getDecorView().findViewById(R.id.c4);
                if (imageView != null) {
                    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                if (this.mChattingInAnim != null) {
                    this.mChattingInAnim.cancel();
                }
            } else if (!(f != 1.0f || this.mChattingClosed || this.ypn.dBM())) {
                this.iWA.getWindow().setBackgroundDrawableResource(R.color.y9);
                imageView = (ImageView) this.iWA.getWindow().getDecorView().findViewById(R.id.c4);
                if (!(imageView == null || imageView.getVisibility() != 0 || imageView.getTag() == null)) {
                    ((View) imageView.getTag()).setVisibility(0);
                    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
                    imageView.setVisibility(8);
                }
                if (this.ypn.getContentView() == null || this.ypn.getContentView().getX() > 0.0f) {
                    Ns(0);
                } else {
                    Ns(8);
                }
            }
            if (this.ype.dxp()) {
                z = true;
            } else if (Float.compare(1.0f, f) > 0) {
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", Boolean.FALSE);
                AppMethodBeat.o(29821);
                return false;
            } else {
                z = false;
            }
            View findViewById = this.iWA.findViewById(R.id.bp);
            imageView = (ImageView) this.iWA.findViewById(R.id.c4);
            if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null || this.mChattingClosed || f == 1.0f || f == 0.0f)) {
                imageView.setVisibility(0);
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
                Ns(8);
            }
            if (Float.compare(1.0f, f) <= 0) {
                com.tencent.mm.ui.tools.h.s(findViewById, 0.0f);
                com.tencent.mm.ui.tools.h.s(imageView, 0.0f);
            } else if (imageView == null || imageView.getDrawable() == null) {
                com.tencent.mm.ui.tools.h.s(findViewById, ((((float) findViewById.getWidth()) / 2.5f) * (1.0f - f)) * -1.0f);
            } else {
                com.tencent.mm.ui.tools.h.s(imageView, ((((float) imageView.getWidth()) / 2.5f) * (1.0f - f)) * -1.0f);
            }
            AppMethodBeat.o(29821);
            return z;
        }
        AppMethodBeat.o(29821);
        return true;
    }

    private void Ns(int i) {
        AppMethodBeat.i(29822);
        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] visible:%s", Integer.valueOf(i));
        if (this.iWA == null) {
            ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] getActivity is null");
            AppMethodBeat.o(29822);
            return;
        }
        View findViewById = this.iWA.findViewById(R.id.bp);
        if (!(findViewById == null || findViewById.getVisibility() == i)) {
            findViewById.setVisibility(i);
        }
        AppMethodBeat.o(29822);
    }

    private ViewGroup dyW() {
        AppMethodBeat.i(29814);
        ViewParent parent = this.iWA.getSupportActionBar().getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent decorView = this.iWA.getWindow().getDecorView();
        while (parent != decorView && parent != null) {
            viewParent = parent;
            parent = parent.getParent();
        }
        ViewGroup viewGroup = (ViewGroup) viewParent;
        AppMethodBeat.o(29814);
        return viewGroup;
    }

    /* Access modifiers changed, original: final */
    public final boolean cXe() {
        AppMethodBeat.i(29815);
        if (com.tencent.mm.compatible.util.d.iW(19) && b.Ml() && !com.tencent.mm.compatible.f.b.bD(this.iWA)) {
            AppMethodBeat.o(29815);
            return true;
        }
        AppMethodBeat.o(29815);
        return false;
    }

    static /* synthetic */ void a(NewChattingTabUI newChattingTabUI, Intent intent, boolean z) {
        boolean z2;
        AppMethodBeat.i(29823);
        long currentTimeMillis = System.currentTimeMillis();
        if (newChattingTabUI.ypn == null) {
            newChattingTabUI.ypn = new ChattingUIFragment();
            newChattingTabUI.mChattingUIProxy = new com.tencent.mm.ui.chatting.y(newChattingTabUI.iWA, newChattingTabUI.ypn);
            z2 = true;
        } else {
            z2 = false;
        }
        final int[] iArr;
        View dyW;
        final ViewGroup viewGroup;
        int statusBarHeight;
        if (newChattingTabUI.ypg == null) {
            if (newChattingTabUI.ypn.isSupportCustomActionBar()) {
                iArr = new int[2];
                newChattingTabUI.iWA.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                TestTimeForChatting testTimeForChatting = new TestTimeForChatting(newChattingTabUI.iWA);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                testTimeForChatting.setId(R.id.ab);
                newChattingTabUI.yph = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                final FitSystemWindowLayoutView fitSystemWindowLayoutView = new FitSystemWindowLayoutView(newChattingTabUI.iWA);
                fitSystemWindowLayoutView.setLayoutParams(new LayoutParams(-1, -1));
                dyW = newChattingTabUI.dyW();
                if (dyW == null) {
                    ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "abRoot == null! try get child(0)");
                    dyW = ((ViewGroup) newChattingTabUI.iWA.getWindow().getDecorView()).getChildAt(0);
                }
                ImageView imageView = new ImageView(newChattingTabUI.iWA);
                imageView.setId(R.id.c4);
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(8);
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[createChattingView] prepareView GONE");
                viewGroup = (ViewGroup) dyW;
                ((ViewGroup) newChattingTabUI.iWA.getWindow().getDecorView()).removeView(dyW);
                dyW.setId(R.id.bp);
                fitSystemWindowLayoutView.addView(dyW);
                fitSystemWindowLayoutView.addView(imageView);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) newChattingTabUI.iWA.getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                newChattingTabUI.iWA.getWindow().getDecorView().requestFitSystemWindows();
                statusBarHeight = ak.getStatusBarHeight(newChattingTabUI.iWA);
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::fitSystemWindows. statusBarHeight:%d", Integer.valueOf(statusBarHeight));
                if (statusBarHeight > 0) {
                    newChattingTabUI.ype.a(fitSystemWindowLayoutView, new Rect(0, statusBarHeight, 0, 0), viewGroup);
                } else {
                    newChattingTabUI.iWA.getSupportActionBar().getCustomView().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29795);
                            NewChattingTabUI.this.iWA.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                            int statusBarHeight = ak.getStatusBarHeight(NewChattingTabUI.this.iWA);
                            if (statusBarHeight > 0) {
                                NewChattingTabUI.this.ype.a(fitSystemWindowLayoutView, new Rect(0, statusBarHeight, 0, 0), viewGroup);
                                AppMethodBeat.o(29795);
                                return;
                            }
                            if (com.tencent.mm.compatible.util.d.iW(20)) {
                                fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                                    @TargetApi(20)
                                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                        AppMethodBeat.i(29794);
                                        if (windowInsets == null) {
                                            AppMethodBeat.o(29794);
                                        } else {
                                            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "OnApplyWindowInsetsListener %s", windowInsets);
                                            windowInsets.consumeSystemWindowInsets();
                                            b e = NewChattingTabUI.this.ype;
                                            FitSystemWindowLayoutView fitSystemWindowLayoutView = fitSystemWindowLayoutView;
                                            windowInsets.getSystemWindowInsetTop();
                                            e.a(fitSystemWindowLayoutView, new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                            AppMethodBeat.o(29794);
                                        }
                                        return windowInsets;
                                    }
                                });
                            }
                            AppMethodBeat.o(29795);
                        }
                    });
                }
                newChattingTabUI.ypg = (TestTimeForChatting) newChattingTabUI.iWA.findViewById(newChattingTabUI.yph);
                ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(statusBarHeight));
            } else {
                ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "[createChattingView] is not SupportCustomActionBar %s", Boolean.valueOf(b.Ml()));
                newChattingTabUI.ypg = (TestTimeForChatting) newChattingTabUI.iWA.findViewById(R.id.a9f);
                newChattingTabUI.yph = newChattingTabUI.ypg.getId();
            }
        } else if (newChattingTabUI.ypn.isSupportCustomActionBar()) {
            iArr = new int[2];
            newChattingTabUI.ypg.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                viewGroup = (ViewGroup) newChattingTabUI.iWA.getWindow().getDecorView();
                statusBarHeight = 0;
                while (true) {
                    int i = statusBarHeight;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    dyW = ((ViewGroup) newChattingTabUI.iWA.getWindow().getDecorView()).getChildAt(i);
                    if (dyW instanceof FitSystemWindowLayoutView) {
                        newChattingTabUI.iWA.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                        FitSystemWindowLayoutView fitSystemWindowLayoutView2 = (FitSystemWindowLayoutView) dyW;
                        ViewGroup viewGroup2 = (ViewGroup) newChattingTabUI.iWA.findViewById(R.id.bp);
                        i = viewGroup2.getPaddingTop();
                        int statusBarHeight2 = ak.getStatusBarHeight(newChattingTabUI.iWA);
                        Rect rect = new Rect();
                        Window window = newChattingTabUI.iWA.getWindow();
                        window.getDecorView().getWindowVisibleDisplayFrame(rect);
                        int height = window.getDecorView().getHeight();
                        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "rootLayout2 fitSystemWindows detect: ActionBar's CustomView location[1]:%d, paddingTop:%d getStatusBarHeight():%d, heightFromSysR:%d, rectangle.top:%d, rectangle.height:%d, DecorHeight:%d, cacheInsetsTop:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(ae.hA(newChattingTabUI.iWA)), Integer.valueOf(statusBarHeight2), Integer.valueOf(rect.top), Integer.valueOf(rect.height()), Integer.valueOf(height), Integer.valueOf(fitSystemWindowLayoutView2.getCacheInsetsTop()));
                        fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.getCacheInsetsTop(), 0, 0));
                        ImageView imageView2 = (ImageView) fitSystemWindowLayoutView2.findViewById(R.id.c4);
                        imageView2.setTag(viewGroup2);
                        ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                        if (layoutParams2 == null || (layoutParams2 instanceof LayoutParams)) {
                            imageView2.setLayoutParams(layoutParams2);
                        } else {
                            ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "FIX LayoutParams:%s %s", layoutParams2.toString(), viewGroup2);
                            imageView2.setLayoutParams(new LayoutParams(layoutParams2));
                        }
                        Bitmap magicDrawingCache = newChattingTabUI.getMagicDrawingCache(viewGroup2);
                        if (magicDrawingCache != null) {
                            imageView2.setImageBitmap(magicDrawingCache);
                            viewGroup2.setVisibility(8);
                            imageView2.setVisibility(0);
                            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView VISIBLE");
                        } else {
                            viewGroup2.setVisibility(0);
                            imageView2.setVisibility(8);
                            imageView2.setImageDrawable(null);
                            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView GONE");
                        }
                    } else {
                        boolean z3;
                        ImageView imageView3 = (ImageView) dyW.findViewById(R.id.c4);
                        if (imageView3 != null) {
                            imageView3.setImageDrawable(null);
                        }
                        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                        String str2 = "on position %d, rootLayout not found! prepareView is null?%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(i);
                        if (imageView3 == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        objArr[1] = Boolean.valueOf(z3);
                        ab.e(str, str2, objArr);
                        statusBarHeight = i + 1;
                    }
                }
            }
            ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
        }
        if (intent != null) {
            newChattingTabUI.ypn.getArguments().putAll(w.aM(intent));
        }
        if (z2) {
            newChattingTabUI.mChattingUIProxy.onInit(newChattingTabUI.yph, z);
            newChattingTabUI.ypj = (OnLayoutChangedLinearLayout) newChattingTabUI.ypn.getView().findViewById(R.id.zd);
        } else {
            newChattingTabUI.mChattingUIProxy.onEnterBegin();
        }
        if (newChattingTabUI.ypn.isSupportNavigationSwipeBack()) {
            newChattingTabUI.ypn.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent);
        AppMethodBeat.o(29823);
    }

    static /* synthetic */ String h(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(29824);
        String identityString;
        if (newChattingTabUI.ypn != null) {
            identityString = newChattingTabUI.ypn.getIdentityString();
            AppMethodBeat.o(29824);
            return identityString;
        }
        identityString = "";
        AppMethodBeat.o(29824);
        return identityString;
    }

    static /* synthetic */ void t(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(29827);
        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimStart] cost:%sms", Long.valueOf(System.currentTimeMillis() - newChattingTabUI.ypo));
        newChattingTabUI.isAnimating = true;
        if (newChattingTabUI.ypg != null) {
            newChattingTabUI.ypg.setTranslationX(0.0f);
            newChattingTabUI.ypg.dJY();
        }
        AppMethodBeat.o(29827);
    }

    static /* synthetic */ void u(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(29828);
        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimEnd]");
        aw.getNotification().bv(false);
        newChattingTabUI.isAnimating = false;
        if (newChattingTabUI.ypg != null) {
            newChattingTabUI.ypg.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29805);
                    long currentTimeMillis = System.currentTimeMillis();
                    aw.RS().doM();
                    al.Ma(0);
                    NewChattingTabUI.this.iWA.onSwipe(1.0f);
                    if (NewChattingTabUI.this.ypg != null) {
                        NewChattingTabUI.this.ypg.dJZ();
                    }
                    NewChattingTabUI.this.mChattingUIProxy.onEnterEnd();
                    NewChattingTabUI.x(NewChattingTabUI.this);
                    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "doJobOnChattingAnimEnd cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(29805);
                }

                public final String toString() {
                    AppMethodBeat.i(29806);
                    String str = super.toString() + "|chattingView_onAnimationEnd";
                    AppMethodBeat.o(29806);
                    return str;
                }
            }, 60);
        }
        AppMethodBeat.o(29828);
    }
}
