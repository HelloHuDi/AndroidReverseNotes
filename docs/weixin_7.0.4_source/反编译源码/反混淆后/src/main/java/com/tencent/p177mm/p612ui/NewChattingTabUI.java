package com.tencent.p177mm.p612ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.p223i.C1436b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p612ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.p177mm.p612ui.LauncherUI.C36032b;
import com.tencent.p177mm.p612ui.LauncherUI.C36034a;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C5288y;
import com.tencent.p177mm.p612ui.base.OnLayoutChangedLinearLayout;
import com.tencent.p177mm.p612ui.base.OnLayoutChangedLinearLayout.C23623a;
import com.tencent.p177mm.p612ui.chatting.BaseChattingUIFragment;
import com.tencent.p177mm.p612ui.chatting.C36230y;
import com.tencent.p177mm.p612ui.chatting.ChattingUIFragment;
import com.tencent.p177mm.p612ui.tools.C5587h;
import com.tencent.p177mm.p612ui.tools.TestTimeForChatting;
import com.tencent.p177mm.p612ui.tools.TestTimeForChatting.C5579a;
import com.tencent.p177mm.p612ui.widget.C5666h;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5068w;

/* renamed from: com.tencent.mm.ui.NewChattingTabUI */
public class NewChattingTabUI implements C36034a {
    MMFragmentActivity iWA;
    boolean isAnimating = false;
    boolean mChattingClosed = true;
    private Animation mChattingInAnim;
    private Animation mChattingOutAnim;
    private IChattingUIProxy mChattingUIProxy;
    private boolean mNeedChattingAnim;
    Bitmap mPrepareBitmap;
    Runnable mStartChattingRunnable = new C235625();
    private C23623a onChattingLayoutChangedListener = new C442486();
    private C36032b ype;
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
    C44252a ypp = new C44252a(this, (byte) 0);
    boolean ypq = false;

    /* renamed from: com.tencent.mm.ui.NewChattingTabUI$1 */
    class C235571 implements IdleHandler {
        C235571() {
        }

        @TargetApi(17)
        public final boolean queueIdle() {
            boolean z = true;
            AppMethodBeat.m2504i(29792);
            try {
                if (NewChattingTabUI.this.iWA.isFinishing() || NewChattingTabUI.this.iWA.isDestroyed()) {
                    String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                    String str2 = "prepare chattingUI but activity finished isDestroyed[%b]";
                    Object[] objArr = new Object[1];
                    if (!(NewChattingTabUI.this.iWA.isDestroyed() || NewChattingTabUI.this.iWA.isFinishing())) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    C4990ab.m7417i(str, str2, objArr);
                    AppMethodBeat.m2505o(29792);
                    return false;
                }
                C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic start");
                long currentTimeMillis = System.currentTimeMillis();
                if (NewChattingTabUI.this.ypg == null) {
                    NewChattingTabUI.m89651a(NewChattingTabUI.this, new Intent().putExtra("Chat_User", ""), true);
                    NewChattingTabUI.this.ypg.setVisibility(8);
                    NewChattingTabUI.this.ype.dxr();
                    C5288y.m8058d(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
                }
                C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(29792);
                return false;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.LauncherUI.NewChattingTabUI", e, "", new Object[0]);
                new Handler().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(29791);
                        RuntimeException runtimeException = new RuntimeException(e);
                        AppMethodBeat.m2505o(29791);
                        throw runtimeException;
                    }
                });
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.NewChattingTabUI$2 */
    class C235582 implements Runnable {
        C235582() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29793);
            Looper.myQueue().addIdleHandler(NewChattingTabUI.this.ypi);
            AppMethodBeat.m2505o(29793);
        }
    }

    /* renamed from: com.tencent.mm.ui.NewChattingTabUI$5 */
    class C235625 implements Runnable {
        C235625() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29797);
            if (!NewChattingTabUI.this.mChattingClosed) {
                C4990ab.m7412e("MicroMsg.LauncherUI.NewChattingTabUI", "start chatting but last chatting does't be close!");
                NewChattingTabUI.this.mo76180pW(false);
            }
            if (NewChattingTabUI.this.iWA.isFinishing() || NewChattingTabUI.this.iWA.isPaused() || !NewChattingTabUI.this.mChattingClosed) {
                C4990ab.m7421w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s", Boolean.valueOf(NewChattingTabUI.this.iWA.isPaused()), Boolean.valueOf(NewChattingTabUI.this.mChattingClosed));
                NewChattingTabUI.this.ypq = true;
                AppMethodBeat.m2505o(29797);
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
            C4990ab.m7417i(str, str2, objArr);
            Intent putExtra = new Intent().putExtra("Chat_User", NewChattingTabUI.this.ypl);
            if (NewChattingTabUI.this.ypm != null) {
                putExtra.putExtras(NewChattingTabUI.this.ypm);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            NewChattingTabUI.m89651a(NewChattingTabUI.this, putExtra, false);
            NewChattingTabUI.this.ypj.setOnChattingLayoutChangedListener(NewChattingTabUI.this.onChattingLayoutChangedListener);
            NewChattingTabUI.this.ypg.setVisibility(0);
            NewChattingTabUI.this.ypg.setTranslationX((NewChattingTabUI.this.iWA.getWindow().getDecorView().getWidth() == 0 ? (float) NewChattingTabUI.this.iWA.getResources().getDisplayMetrics().widthPixels : (float) NewChattingTabUI.this.iWA.getWindow().getDecorView().getWidth()) - 0.1f);
            NewChattingTabUI.this.ypf = C42252ah.anT();
            NewChattingTabUI.m89668q(NewChattingTabUI.this);
            if (NewChattingTabUI.m89669r(NewChattingTabUI.this)) {
                C5666h.m8512a(NewChattingTabUI.this.iWA);
            }
            AppMethodBeat.m2505o(29797);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29798);
            String str = super.toString() + "|startChattingRunnable";
            AppMethodBeat.m2505o(29798);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.NewChattingTabUI$6 */
    class C442486 implements C23623a {
        long start = 0;

        /* renamed from: com.tencent.mm.ui.NewChattingTabUI$6$1 */
        class C154771 implements AnimationListener {
            C154771() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(29799);
                NewChattingTabUI.m89671t(NewChattingTabUI.this);
                NewChattingTabUI.this.mo76176G(false, 0);
                AppMethodBeat.m2505o(29799);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(29800);
                NewChattingTabUI.m89672u(NewChattingTabUI.this);
                AppMethodBeat.m2505o(29800);
            }
        }

        /* renamed from: com.tencent.mm.ui.NewChattingTabUI$6$2 */
        class C303502 implements C5579a {
            C303502() {
            }

            public final void dyY() {
                AppMethodBeat.m2504i(29801);
                C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
                C442486.this.start = System.currentTimeMillis();
                if (NewChattingTabUI.this.ypn.getSwipeBackLayout() != null) {
                    NewChattingTabUI.this.ypn.getSwipeBackLayout().setNeedChangeWindowBackground(false);
                    NewChattingTabUI.this.ypn.getSwipeBackLayout().startAnimation(NewChattingTabUI.this.mChattingInAnim);
                } else {
                    NewChattingTabUI.this.ypn.getView().startAnimation(NewChattingTabUI.this.mChattingInAnim);
                }
                NewChattingTabUI.this.ypg.setOndispatchDraw(null);
                AppMethodBeat.m2505o(29801);
            }
        }

        C442486() {
        }

        public final void dyX() {
            AppMethodBeat.m2504i(29802);
            if (NewChattingTabUI.this.mChattingInAnim == null) {
                NewChattingTabUI.this.mChattingInAnim = AnimationUtils.loadAnimation(NewChattingTabUI.this.iWA, C5206a.ync);
                NewChattingTabUI.this.mChattingInAnim.setAnimationListener(new C154771());
            }
            if (NewChattingTabUI.this.mNeedChattingAnim) {
                NewChattingTabUI.this.ypg.setOndispatchDraw(new C303502());
                NewChattingTabUI.this.mNeedChattingAnim = false;
            } else {
                NewChattingTabUI.m89671t(NewChattingTabUI.this);
                NewChattingTabUI.m89672u(NewChattingTabUI.this);
            }
            NewChattingTabUI.this.ypj.yAx = null;
            C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
            AppMethodBeat.m2505o(29802);
        }
    }

    /* renamed from: com.tencent.mm.ui.NewChattingTabUI$7 */
    class C442497 implements AnimationListener {
        C442497() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(29803);
            NewChattingTabUI.this.isAnimating = true;
            C9638aw.m17180RS().doK();
            C5004al.m7436Ma(-8);
            NewChattingTabUI.this.mo76176G(true, 0);
            C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
            AppMethodBeat.m2505o(29803);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(29804);
            NewChattingTabUI.this.isAnimating = false;
            NewChattingTabUI.this.ypg.setVisibility(8);
            C9638aw.m17180RS().doM();
            C5004al.m7436Ma(0);
            NewChattingTabUI.m89675x(NewChattingTabUI.this);
            C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
            AppMethodBeat.m2505o(29804);
        }
    }

    /* renamed from: com.tencent.mm.ui.NewChattingTabUI$8 */
    class C442508 implements Runnable {
        C442508() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29805);
            long currentTimeMillis = System.currentTimeMillis();
            C9638aw.m17180RS().doM();
            C5004al.m7436Ma(0);
            NewChattingTabUI.this.iWA.onSwipe(1.0f);
            if (NewChattingTabUI.this.ypg != null) {
                NewChattingTabUI.this.ypg.dJZ();
            }
            NewChattingTabUI.this.mChattingUIProxy.onEnterEnd();
            NewChattingTabUI.m89675x(NewChattingTabUI.this);
            C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "doJobOnChattingAnimEnd cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(29805);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29806);
            String str = super.toString() + "|chattingView_onAnimationEnd";
            AppMethodBeat.m2505o(29806);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.NewChattingTabUI$a */
    class C44252a implements Runnable {
        int bFZ;
        Intent cEd;
        int requestCode;
        int ypy;

        /* renamed from: com.tencent.mm.ui.NewChattingTabUI$a$1 */
        class C442511 implements Runnable {
            C442511() {
            }

            public final void run() {
                boolean z = true;
                AppMethodBeat.m2504i(29807);
                String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                Object[] objArr = new Object[1];
                if (NewChattingTabUI.this.ypn != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7411d(str, str2, objArr);
                if (NewChattingTabUI.this.ypn != null) {
                    C4990ab.m7410d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
                    NewChattingTabUI.this.ypn.onActivityResult(C44252a.this.requestCode & CdnLogic.kBizGeneric, C44252a.this.bFZ, C44252a.this.cEd);
                }
                AppMethodBeat.m2505o(29807);
            }

            public final String toString() {
                AppMethodBeat.m2504i(29808);
                String str = super.toString() + "|PostSelectImageJob_onActivityResult";
                AppMethodBeat.m2505o(29808);
                return str;
            }
        }

        private C44252a() {
            this.ypy = 0;
        }

        /* synthetic */ C44252a(NewChattingTabUI newChattingTabUI, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(29809);
            if (C9638aw.m17179RK() && NewChattingTabUI.this.iWA != null) {
                C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.ypy));
                NewChattingTabUI.this.startChatting(NewChattingTabUI.this.ypk, null, false);
                C5004al.m7441d(new C442511());
                AppMethodBeat.m2505o(29809);
            } else if (this.ypy >= 3) {
                C4990ab.m7420w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
                AppMethodBeat.m2505o(29809);
            } else {
                String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                String str2 = "on post select image job, acc not ready or view init(%B), cur retry count %d";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(NewChattingTabUI.this.iWA != null);
                objArr[1] = Integer.valueOf(this.ypy);
                C4990ab.m7421w(str, str2, objArr);
                this.ypy++;
                C5004al.m7442n(this, 300);
                AppMethodBeat.m2505o(29809);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(29810);
            String str = super.toString() + "|PostSelectImageJob";
            AppMethodBeat.m2505o(29810);
            return str;
        }
    }

    /* renamed from: q */
    static /* synthetic */ void m89668q(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.m2504i(29825);
        newChattingTabUI.mo76179kT(3);
        AppMethodBeat.m2505o(29825);
    }

    /* renamed from: r */
    static /* synthetic */ boolean m89669r(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.m2504i(29826);
        boolean cXe = newChattingTabUI.cXe();
        AppMethodBeat.m2505o(29826);
        return cXe;
    }

    /* renamed from: x */
    static /* synthetic */ void m89675x(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.m2504i(29829);
        newChattingTabUI.tryResetChattingSwipeStatus();
        AppMethodBeat.m2505o(29829);
    }

    public NewChattingTabUI(C36032b c36032b) {
        AppMethodBeat.m2504i(29811);
        this.ype = c36032b;
        AppMethodBeat.m2505o(29811);
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(29812);
        this.ypo = System.currentTimeMillis();
        String str2 = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str3 = "try startChatting, ishow:%b userName:%s needAnim:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.ypg == null ? false : this.ypg.isShown());
        objArr[1] = str;
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str2, str3, objArr);
        if (!(this.ypn == null || this.ypn.getView() == null)) {
            this.ypn.getView().setImportantForAccessibility(1);
        }
        C9638aw.getNotification().mo41575bv(false);
        this.ypq = false;
        this.ypm = bundle;
        this.ypl = str;
        this.mNeedChattingAnim = z;
        C9638aw.m17180RS().doK();
        C5004al.m7436Ma(-8);
        C5004al.m7439af(this.mStartChattingRunnable);
        C5004al.m7441d(this.mStartChattingRunnable);
        AppMethodBeat.m2505o(29812);
    }

    static boolean acceptRequestCode(int i) {
        AppMethodBeat.m2504i(29813);
        C4990ab.m7421w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", Integer.valueOf(CdnLogic.kBizGeneric & i));
        switch (CdnLogic.kBizGeneric & i) {
            case 217:
            case 218:
            case 226:
                AppMethodBeat.m2505o(29813);
                return true;
            default:
                AppMethodBeat.m2505o(29813);
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
    /* renamed from: kT */
    public final void mo76179kT(final int i) {
        AppMethodBeat.m2504i(29816);
        if (this.ypn == null) {
            AppMethodBeat.m2505o(29816);
            return;
        }
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(29796);
                C26483d.m42196b(i, "ChattingUI" + NewChattingTabUI.m89659h(NewChattingTabUI.this), hashCode());
                if (i == 4) {
                    C26483d.m42198h("ChattingUI" + NewChattingTabUI.m89659h(NewChattingTabUI.this), NewChattingTabUI.this.ypf, C42252ah.anT());
                }
                AppMethodBeat.m2505o(29796);
            }
        }, "MicroMsg.LauncherUI.NewChattingTabUI|report");
        AppMethodBeat.m2505o(29816);
    }

    private Bitmap getMagicDrawingCache(View view) {
        AppMethodBeat.m2504i(29817);
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
            C4990ab.m7413e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", Integer.valueOf(width), Integer.valueOf(height));
            AppMethodBeat.m2505o(29817);
            return null;
        } else if (this.ypn.getView() == null) {
            AppMethodBeat.m2505o(29817);
            return null;
        } else {
            if (this.ypn != null) {
                C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", Integer.valueOf(this.ypn.getView().getBottom()), Integer.valueOf(this.ypn.keyboardState()));
            }
            if (this.ypn == null || this.ypn.getView().getBottom() <= 0 || (this.ypn.keyboardState() != 1 && this.ypn.getView().getBottom() >= (this.iWA.getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
                if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != width || this.mPrepareBitmap.getHeight() != height) {
                    if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
                        C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", this.mPrepareBitmap.toString());
                        this.mPrepareBitmap.recycle();
                    }
                    try {
                        this.mPrepareBitmap = C5056d.createBitmap(width, height, Config.ARGB_4444);
                        if (this.mPrepareBitmap == null) {
                            AppMethodBeat.m2505o(29817);
                            return null;
                        }
                    } catch (OutOfMemoryError e) {
                        C4990ab.m7413e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", e);
                        AppMethodBeat.m2505o(29817);
                        return null;
                    }
                }
                view.draw(new Canvas(this.mPrepareBitmap));
                C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                Bitmap bitmap = this.mPrepareBitmap;
                AppMethodBeat.m2505o(29817);
                return bitmap;
            }
            C4990ab.m7413e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", Integer.valueOf(this.ypn.keyboardState()));
            this.iWA.getWindow().setBackgroundDrawableResource(C25738R.color.f12273y9);
            AppMethodBeat.m2505o(29817);
            return null;
        }
    }

    /* renamed from: pW */
    public final boolean mo76180pW(boolean z) {
        AppMethodBeat.m2504i(29818);
        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.ypg == null ? false : this.ypg.isShown());
        C4990ab.m7417i(str, str2, objArr);
        if (!(this.ypn == null || this.ypn.getView() == null)) {
            this.ypn.getView().setImportantForAccessibility(4);
        }
        if (this.ypg == null || this.ypg.getVisibility() == 8 || this.ypn == null || this.iWA == null) {
            AppMethodBeat.m2505o(29818);
            return false;
        }
        if (this.ypn != null && this.ypn.isSupportNavigationSwipeBack()) {
            C5666h.m8513b(this.iWA);
        }
        C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", Boolean.valueOf(z));
        mo76179kT(4);
        this.mChattingClosed = true;
        if (z && this.mChattingOutAnim == null) {
            this.mChattingOutAnim = AnimationUtils.loadAnimation(this.iWA, C5206a.ynf);
            this.mChattingOutAnim.setAnimationListener(new C442497());
        }
        C5288y.m8058d(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
        if (this.ypn.isSupportCustomActionBar()) {
            ImageView imageView = (ImageView) this.iWA.getWindow().getDecorView().findViewById(2131820648);
            if (imageView != null && imageView.getVisibility() == 0) {
                imageView.setVisibility(8);
                C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
            }
        }
        m89647Ns(0);
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
        AppMethodBeat.m2505o(29818);
        return true;
    }

    private void tryResetChattingSwipeStatus() {
        boolean z = true;
        AppMethodBeat.m2504i(29819);
        if (cXe()) {
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.ypn != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            if (this.ypn != null) {
                this.ypn.getSwipeBackLayout().zOp = false;
            }
            AppMethodBeat.m2505o(29819);
            return;
        }
        AppMethodBeat.m2505o(29819);
    }

    /* renamed from: G */
    public final boolean mo76176G(boolean z, int i) {
        AppMethodBeat.m2504i(29820);
        C4990ab.m7419v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(this.ype.dxp()));
        if (cXe()) {
            if (z) {
                this.ype.dxs();
            }
            if (this.ype.dxp()) {
                View findViewById = this.iWA.findViewById(2131820633);
                if (findViewById == null) {
                    C4990ab.m7412e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
                    AppMethodBeat.m2505o(29820);
                    return true;
                }
                ImageView imageView = (ImageView) this.iWA.findViewById(2131820648);
                if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
                    imageView.setVisibility(0);
                    C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
                    findViewById.setVisibility(8);
                }
                if (imageView == null || imageView.getVisibility() != 0) {
                    int width = findViewById.getWidth() == 0 ? this.iWA.getResources().getDisplayMetrics().widthPixels : findViewById.getWidth();
                    if (z) {
                        C5587h.m8387a(findViewById, 224, 0.0f, null);
                    } else {
                        C5587h.m8387a(findViewById, 256, ((float) (width * -1)) / 3.5f, null);
                    }
                } else {
                    int width2 = imageView.getWidth() == 0 ? this.iWA.getResources().getDisplayMetrics().widthPixels : imageView.getWidth();
                    if (z) {
                        C5587h.m8387a(imageView, 224, 0.0f, null);
                    } else {
                        C5587h.m8387a(imageView, 256, ((float) (width2 * -1)) / 3.5f, null);
                    }
                }
                AppMethodBeat.m2505o(29820);
                return true;
            }
            AppMethodBeat.m2505o(29820);
            return false;
        }
        AppMethodBeat.m2505o(29820);
        return true;
    }

    /* renamed from: bo */
    public final boolean mo76177bo(float f) {
        AppMethodBeat.m2504i(29821);
        C4990ab.m7419v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", Float.valueOf(f), Long.valueOf(320), Boolean.valueOf(this.ype.dxp()));
        if (cXe()) {
            ImageView imageView;
            boolean z;
            if (f == 0.0f && !this.mChattingClosed) {
                m89647Ns(0);
                imageView = (ImageView) this.iWA.getWindow().getDecorView().findViewById(2131820648);
                if (imageView != null) {
                    C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                if (this.mChattingInAnim != null) {
                    this.mChattingInAnim.cancel();
                }
            } else if (!(f != 1.0f || this.mChattingClosed || this.ypn.dBM())) {
                this.iWA.getWindow().setBackgroundDrawableResource(C25738R.color.f12273y9);
                imageView = (ImageView) this.iWA.getWindow().getDecorView().findViewById(2131820648);
                if (!(imageView == null || imageView.getVisibility() != 0 || imageView.getTag() == null)) {
                    ((View) imageView.getTag()).setVisibility(0);
                    C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
                    imageView.setVisibility(8);
                }
                if (this.ypn.getContentView() == null || this.ypn.getContentView().getX() > 0.0f) {
                    m89647Ns(0);
                } else {
                    m89647Ns(8);
                }
            }
            if (this.ype.dxp()) {
                z = true;
            } else if (Float.compare(1.0f, f) > 0) {
                C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", Boolean.FALSE);
                AppMethodBeat.m2505o(29821);
                return false;
            } else {
                z = false;
            }
            View findViewById = this.iWA.findViewById(2131820633);
            imageView = (ImageView) this.iWA.findViewById(2131820648);
            if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null || this.mChattingClosed || f == 1.0f || f == 0.0f)) {
                imageView.setVisibility(0);
                C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
                m89647Ns(8);
            }
            if (Float.compare(1.0f, f) <= 0) {
                C5587h.m8390s(findViewById, 0.0f);
                C5587h.m8390s(imageView, 0.0f);
            } else if (imageView == null || imageView.getDrawable() == null) {
                C5587h.m8390s(findViewById, ((((float) findViewById.getWidth()) / 2.5f) * (1.0f - f)) * -1.0f);
            } else {
                C5587h.m8390s(imageView, ((((float) imageView.getWidth()) / 2.5f) * (1.0f - f)) * -1.0f);
            }
            AppMethodBeat.m2505o(29821);
            return z;
        }
        AppMethodBeat.m2505o(29821);
        return true;
    }

    /* renamed from: Ns */
    private void m89647Ns(int i) {
        AppMethodBeat.m2504i(29822);
        C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] visible:%s", Integer.valueOf(i));
        if (this.iWA == null) {
            C4990ab.m7412e("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] getActivity is null");
            AppMethodBeat.m2505o(29822);
            return;
        }
        View findViewById = this.iWA.findViewById(2131820633);
        if (!(findViewById == null || findViewById.getVisibility() == i)) {
            findViewById.setVisibility(i);
        }
        AppMethodBeat.m2505o(29822);
    }

    private ViewGroup dyW() {
        AppMethodBeat.m2504i(29814);
        ViewParent parent = this.iWA.getSupportActionBar().getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent decorView = this.iWA.getWindow().getDecorView();
        while (parent != decorView && parent != null) {
            viewParent = parent;
            parent = parent.getParent();
        }
        ViewGroup viewGroup = (ViewGroup) viewParent;
        AppMethodBeat.m2505o(29814);
        return viewGroup;
    }

    /* Access modifiers changed, original: final */
    public final boolean cXe() {
        AppMethodBeat.m2504i(29815);
        if (C1443d.m3068iW(19) && C1436b.m3061Ml() && !C37657b.m63682bD(this.iWA)) {
            AppMethodBeat.m2505o(29815);
            return true;
        }
        AppMethodBeat.m2505o(29815);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m89651a(NewChattingTabUI newChattingTabUI, Intent intent, boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(29823);
        long currentTimeMillis = System.currentTimeMillis();
        if (newChattingTabUI.ypn == null) {
            newChattingTabUI.ypn = new ChattingUIFragment();
            newChattingTabUI.mChattingUIProxy = new C36230y(newChattingTabUI.iWA, newChattingTabUI.ypn);
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
                testTimeForChatting.setId(2131820582);
                newChattingTabUI.yph = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                final FitSystemWindowLayoutView fitSystemWindowLayoutView = new FitSystemWindowLayoutView(newChattingTabUI.iWA);
                fitSystemWindowLayoutView.setLayoutParams(new LayoutParams(-1, -1));
                dyW = newChattingTabUI.dyW();
                if (dyW == null) {
                    C4990ab.m7420w("MicroMsg.LauncherUI.NewChattingTabUI", "abRoot == null! try get child(0)");
                    dyW = ((ViewGroup) newChattingTabUI.iWA.getWindow().getDecorView()).getChildAt(0);
                }
                ImageView imageView = new ImageView(newChattingTabUI.iWA);
                imageView.setId(2131820648);
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(8);
                C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[createChattingView] prepareView GONE");
                viewGroup = (ViewGroup) dyW;
                ((ViewGroup) newChattingTabUI.iWA.getWindow().getDecorView()).removeView(dyW);
                dyW.setId(2131820633);
                fitSystemWindowLayoutView.addView(dyW);
                fitSystemWindowLayoutView.addView(imageView);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) newChattingTabUI.iWA.getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                newChattingTabUI.iWA.getWindow().getDecorView().requestFitSystemWindows();
                statusBarHeight = C5230ak.getStatusBarHeight(newChattingTabUI.iWA);
                C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::fitSystemWindows. statusBarHeight:%d", Integer.valueOf(statusBarHeight));
                if (statusBarHeight > 0) {
                    newChattingTabUI.ype.mo56794a(fitSystemWindowLayoutView, new Rect(0, statusBarHeight, 0, 0), viewGroup);
                } else {
                    newChattingTabUI.iWA.getSupportActionBar().getCustomView().post(new Runnable() {

                        /* renamed from: com.tencent.mm.ui.NewChattingTabUI$3$1 */
                        class C235601 implements OnApplyWindowInsetsListener {
                            C235601() {
                            }

                            @TargetApi(20)
                            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                AppMethodBeat.m2504i(29794);
                                if (windowInsets == null) {
                                    AppMethodBeat.m2505o(29794);
                                } else {
                                    C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "OnApplyWindowInsetsListener %s", windowInsets);
                                    windowInsets.consumeSystemWindowInsets();
                                    C36032b e = NewChattingTabUI.this.ype;
                                    FitSystemWindowLayoutView fitSystemWindowLayoutView = fitSystemWindowLayoutView;
                                    windowInsets.getSystemWindowInsetTop();
                                    e.mo56794a(fitSystemWindowLayoutView, new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                    AppMethodBeat.m2505o(29794);
                                }
                                return windowInsets;
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(29795);
                            NewChattingTabUI.this.iWA.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                            int statusBarHeight = C5230ak.getStatusBarHeight(NewChattingTabUI.this.iWA);
                            if (statusBarHeight > 0) {
                                NewChattingTabUI.this.ype.mo56794a(fitSystemWindowLayoutView, new Rect(0, statusBarHeight, 0, 0), viewGroup);
                                AppMethodBeat.m2505o(29795);
                                return;
                            }
                            if (C1443d.m3068iW(20)) {
                                fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new C235601());
                            }
                            AppMethodBeat.m2505o(29795);
                        }
                    });
                }
                newChattingTabUI.ypg = (TestTimeForChatting) newChattingTabUI.iWA.findViewById(newChattingTabUI.yph);
                C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(statusBarHeight));
            } else {
                C4990ab.m7421w("MicroMsg.LauncherUI.NewChattingTabUI", "[createChattingView] is not SupportCustomActionBar %s", Boolean.valueOf(C1436b.m3061Ml()));
                newChattingTabUI.ypg = (TestTimeForChatting) newChattingTabUI.iWA.findViewById(2131821893);
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
                        ViewGroup viewGroup2 = (ViewGroup) newChattingTabUI.iWA.findViewById(2131820633);
                        i = viewGroup2.getPaddingTop();
                        int statusBarHeight2 = C5230ak.getStatusBarHeight(newChattingTabUI.iWA);
                        Rect rect = new Rect();
                        Window window = newChattingTabUI.iWA.getWindow();
                        window.getDecorView().getWindowVisibleDisplayFrame(rect);
                        int height = window.getDecorView().getHeight();
                        C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "rootLayout2 fitSystemWindows detect: ActionBar's CustomView location[1]:%d, paddingTop:%d getStatusBarHeight():%d, heightFromSysR:%d, rectangle.top:%d, rectangle.height:%d, DecorHeight:%d, cacheInsetsTop:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(C5222ae.m7947hA(newChattingTabUI.iWA)), Integer.valueOf(statusBarHeight2), Integer.valueOf(rect.top), Integer.valueOf(rect.height()), Integer.valueOf(height), Integer.valueOf(fitSystemWindowLayoutView2.getCacheInsetsTop()));
                        fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.getCacheInsetsTop(), 0, 0));
                        ImageView imageView2 = (ImageView) fitSystemWindowLayoutView2.findViewById(2131820648);
                        imageView2.setTag(viewGroup2);
                        ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                        if (layoutParams2 == null || (layoutParams2 instanceof LayoutParams)) {
                            imageView2.setLayoutParams(layoutParams2);
                        } else {
                            C4990ab.m7421w("MicroMsg.LauncherUI.NewChattingTabUI", "FIX LayoutParams:%s %s", layoutParams2.toString(), viewGroup2);
                            imageView2.setLayoutParams(new LayoutParams(layoutParams2));
                        }
                        Bitmap magicDrawingCache = newChattingTabUI.getMagicDrawingCache(viewGroup2);
                        if (magicDrawingCache != null) {
                            imageView2.setImageBitmap(magicDrawingCache);
                            viewGroup2.setVisibility(8);
                            imageView2.setVisibility(0);
                            C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView VISIBLE");
                        } else {
                            viewGroup2.setVisibility(0);
                            imageView2.setVisibility(8);
                            imageView2.setImageDrawable(null);
                            C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView GONE");
                        }
                    } else {
                        boolean z3;
                        ImageView imageView3 = (ImageView) dyW.findViewById(2131820648);
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
                        C4990ab.m7413e(str, str2, objArr);
                        statusBarHeight = i + 1;
                    }
                }
            }
            C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
        }
        if (intent != null) {
            newChattingTabUI.ypn.getArguments().putAll(C5068w.m7684aM(intent));
        }
        if (z2) {
            newChattingTabUI.mChattingUIProxy.onInit(newChattingTabUI.yph, z);
            newChattingTabUI.ypj = (OnLayoutChangedLinearLayout) newChattingTabUI.ypn.getView().findViewById(2131821521);
        } else {
            newChattingTabUI.mChattingUIProxy.onEnterBegin();
        }
        if (newChattingTabUI.ypn.isSupportNavigationSwipeBack()) {
            newChattingTabUI.ypn.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent);
        AppMethodBeat.m2505o(29823);
    }

    /* renamed from: h */
    static /* synthetic */ String m89659h(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.m2504i(29824);
        String identityString;
        if (newChattingTabUI.ypn != null) {
            identityString = newChattingTabUI.ypn.getIdentityString();
            AppMethodBeat.m2505o(29824);
            return identityString;
        }
        identityString = "";
        AppMethodBeat.m2505o(29824);
        return identityString;
    }

    /* renamed from: t */
    static /* synthetic */ void m89671t(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.m2504i(29827);
        C4990ab.m7417i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimStart] cost:%sms", Long.valueOf(System.currentTimeMillis() - newChattingTabUI.ypo));
        newChattingTabUI.isAnimating = true;
        if (newChattingTabUI.ypg != null) {
            newChattingTabUI.ypg.setTranslationX(0.0f);
            newChattingTabUI.ypg.dJY();
        }
        AppMethodBeat.m2505o(29827);
    }

    /* renamed from: u */
    static /* synthetic */ void m89672u(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.m2504i(29828);
        C4990ab.m7416i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimEnd]");
        C9638aw.getNotification().mo41575bv(false);
        newChattingTabUI.isAnimating = false;
        if (newChattingTabUI.ypg != null) {
            newChattingTabUI.ypg.postDelayed(new C442508(), 60);
        }
        AppMethodBeat.m2505o(29828);
    }
}
