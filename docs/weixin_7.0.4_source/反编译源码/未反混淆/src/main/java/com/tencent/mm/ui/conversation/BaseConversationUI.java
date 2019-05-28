package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.y;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h;

public class BaseConversationUI extends MMFragmentActivity {
    private static final String LAST_RESTORE_TALKER = "last_restore_talker";
    static final String TAG = "MicroMsg.BaseConversationUI";
    private OnLayoutChangedLinearLayout chattingFragmentView;
    private ChattingUIFragment chattingFragmet;
    private int chattingID = -1;
    private IChattingUIProxy chattingUIProxy;
    private TestTimeForChatting chattingView;
    private long chattinguiResumeTime = 0;
    public BaseConversationFmUI conversationFm;
    private boolean isAnimating;
    private String lastRestoreTalker;
    private a launcherUIStatus = a.ACTIVITY_CREATE;
    private ActionBar mActionBar;
    private com.tencent.mm.ui.a mActionBarHelper;
    public boolean mChattingClosed = true;
    private Animation mChattingInAnim;
    private Animation mChattingOutAnim;
    private boolean mNeedChattingAnim = false;
    private Bitmap mPrepareBitmap;
    private com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a() {
        long start = 0;

        public final void dyX() {
            AppMethodBeat.i(34054);
            if (BaseConversationUI.this.mChattingInAnim == null) {
                BaseConversationUI.this.mChattingInAnim = AnimationUtils.loadAnimation(BaseConversationUI.this, com.tencent.mm.ui.MMFragmentActivity.a.ync);
                BaseConversationUI.this.mChattingInAnim.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        AppMethodBeat.i(34051);
                        ab.i(BaseConversationUI.TAG, "klem onAnimationStart onDrawed->onAnimationStart:%sms", Long.valueOf(System.currentTimeMillis() - AnonymousClass6.this.start));
                        BaseConversationUI.this.isAnimating = true;
                        BaseConversationUI.access$900(BaseConversationUI.this);
                        BaseConversationUI.this.onSettle(false, 0);
                        AppMethodBeat.o(34051);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(34052);
                        BaseConversationUI.this.isAnimating = false;
                        ab.i(BaseConversationUI.TAG, "klem animationEnd");
                        BaseConversationUI.access$1000(BaseConversationUI.this);
                        AppMethodBeat.o(34052);
                    }
                });
            }
            if (BaseConversationUI.this.mNeedChattingAnim) {
                BaseConversationUI.this.chattingView.setOndispatchDraw(new com.tencent.mm.ui.tools.TestTimeForChatting.a() {
                    public final void dyY() {
                        AppMethodBeat.i(34053);
                        ab.i(BaseConversationUI.TAG, "[onDrawed]");
                        AnonymousClass6.this.start = System.currentTimeMillis();
                        if (BaseConversationUI.this.chattingFragmet == null) {
                            ab.e(BaseConversationUI.TAG, "chattingFragmet is null!");
                            AppMethodBeat.o(34053);
                            return;
                        }
                        if (BaseConversationUI.this.chattingFragmet.getSwipeBackLayout() != null) {
                            BaseConversationUI.this.chattingFragmet.getSwipeBackLayout().startAnimation(BaseConversationUI.this.mChattingInAnim);
                        } else {
                            BaseConversationUI.this.chattingFragmet.getView().startAnimation(BaseConversationUI.this.mChattingInAnim);
                        }
                        BaseConversationUI.this.chattingView.setOndispatchDraw(null);
                        AppMethodBeat.o(34053);
                    }
                });
                BaseConversationUI.this.mNeedChattingAnim = false;
            } else {
                BaseConversationUI.access$900(BaseConversationUI.this);
                BaseConversationUI.access$1000(BaseConversationUI.this);
            }
            BaseConversationUI.this.chattingFragmentView.yAx = null;
            ab.i(BaseConversationUI.TAG, "klem CHATTING ONLAYOUT ");
            AppMethodBeat.o(34054);
        }
    };
    Bundle pendingBundle;
    String pendingUser;
    private b selectImageJob = new b(this, (byte) 0);
    Runnable startChattingRunnable = new Runnable() {
        public final void run() {
            AppMethodBeat.i(34058);
            if (!BaseConversationUI.this.mChattingClosed) {
                ab.e(BaseConversationUI.TAG, "start chatting but last chatting does't be close!");
                BaseConversationUI.this.closeChatting(false);
            }
            if (BaseConversationUI.this.isFinishing() || BaseConversationUI.this.isPaused() || !BaseConversationUI.this.mChattingClosed) {
                ab.w(BaseConversationUI.TAG, "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", Boolean.valueOf(BaseConversationUI.this.isPaused()), Boolean.valueOf(BaseConversationUI.this.mChattingClosed));
                AppMethodBeat.o(34058);
                return;
            }
            boolean z;
            BaseConversationUI.this.mChattingClosed = false;
            String str = BaseConversationUI.TAG;
            String str2 = "ashutest::startChatting, ishow:%b";
            Object[] objArr = new Object[1];
            if (BaseConversationUI.this.chattingView == null) {
                z = false;
            } else {
                z = BaseConversationUI.this.chattingView.isShown();
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            Intent putExtra = new Intent().putExtra("Chat_User", BaseConversationUI.this.pendingUser);
            if (BaseConversationUI.this.pendingBundle != null) {
                putExtra.putExtras(BaseConversationUI.this.pendingBundle);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            BaseConversationUI.access$300(BaseConversationUI.this, putExtra, false);
            BaseConversationUI.this.chattingFragmentView.setOnChattingLayoutChangedListener(BaseConversationUI.this.onChattingLayoutChangedListener);
            BaseConversationUI.this.chattingView.setTranslationX((BaseConversationUI.this.getWindow().getDecorView().getWidth() == 0 ? (float) BaseConversationUI.this.getResources().getDisplayMetrics().widthPixels : (float) BaseConversationUI.this.getWindow().getDecorView().getWidth()) - 0.1f);
            BaseConversationUI.this.chattingView.setVisibility(0);
            BaseConversationUI.this.pauseMainFragment();
            if (BaseConversationUI.this.chattingFragmet.isSupportNavigationSwipeBack()) {
                h.a(BaseConversationUI.this);
            }
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34057);
                    com.tencent.mm.modelstat.d.b(4, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                    com.tencent.mm.modelstat.d.b(3, "ChattingUI" + BaseConversationUI.this.chattingFragmet.getIdentityString(), BaseConversationUI.this.chattingFragmet.hashCode());
                    AppMethodBeat.o(34057);
                }
            }, "directReport_startChattingRunnable");
            BaseConversationUI.this.chattinguiResumeTime = bo.anT();
            AppMethodBeat.o(34058);
        }

        public final String toString() {
            AppMethodBeat.i(34059);
            String str = super.toString() + "|startChattingRunnable";
            AppMethodBeat.o(34059);
            return str;
        }
    };
    private String title;

    public static class BaseConversationFmUI extends MMFragment {
        private a fmStatus = a.ACTIVITY_CREATE;
        public BaseConversationUI ui;

        public int getLayoutId() {
            return 0;
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.i(34066);
            this.fmStatus = a.ACTIVITY_CREATE;
            this.ui = (BaseConversationUI) thisActivity();
            View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            setHasOptionsMenu(true);
            AppMethodBeat.o(34066);
            return inflate;
        }

        public void setMMTitle(String str) {
            AppMethodBeat.i(34067);
            if (this.ui != null) {
                this.ui.setTitle(str);
            }
            AppMethodBeat.o(34067);
        }

        public void finish() {
            AppMethodBeat.i(34068);
            thisActivity().finish();
            AppMethodBeat.o(34068);
        }

        public void onResume() {
            AppMethodBeat.i(34069);
            super.onResume();
            this.fmStatus = a.ACTIVITY_RESUME;
            AppMethodBeat.o(34069);
        }

        public void onPause() {
            AppMethodBeat.i(34070);
            super.onPause();
            this.fmStatus = a.ACTIVITY_PAUSE;
            AppMethodBeat.o(34070);
        }

        public void onDestroy() {
            AppMethodBeat.i(34071);
            if (this.fmStatus != a.ACTIVITY_PAUSE) {
                ab.w(BaseConversationUI.TAG, "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
                onPause();
            }
            super.onDestroy();
            AppMethodBeat.o(34071);
        }

        public String getUserName() {
            return null;
        }
    }

    enum a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE;

        static {
            AppMethodBeat.o(34065);
        }
    }

    class b implements Runnable {
        int bFZ;
        Intent cEd;
        int requestCode;
        int ypy;

        private b() {
            this.ypy = 0;
        }

        /* synthetic */ b(BaseConversationUI baseConversationUI, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(34074);
            if (aw.RK()) {
                ab.i(BaseConversationUI.TAG, "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.ypy));
                BaseConversationUI.this.startChatting(BaseConversationUI.this.lastRestoreTalker);
                al.d(new Runnable() {
                    public final void run() {
                        boolean z = true;
                        AppMethodBeat.i(34072);
                        String str = BaseConversationUI.TAG;
                        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                        Object[] objArr = new Object[1];
                        if (BaseConversationUI.this.chattingFragmet != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        ab.d(str, str2, objArr);
                        if (BaseConversationUI.this.chattingFragmet != null) {
                            ab.d(BaseConversationUI.TAG, "on select image ActivityResult. do post activity result");
                            BaseConversationUI.this.chattingFragmet.onActivityResult(b.this.requestCode & CdnLogic.kBizGeneric, b.this.bFZ, b.this.cEd);
                        }
                        AppMethodBeat.o(34072);
                    }

                    public final String toString() {
                        AppMethodBeat.i(34073);
                        String str = super.toString() + "|PostSelectImageJob_onActivityResult";
                        AppMethodBeat.o(34073);
                        return str;
                    }
                });
                AppMethodBeat.o(34074);
            } else if (this.ypy >= 3) {
                ab.w(BaseConversationUI.TAG, "on post select image job, match max retry count");
                AppMethodBeat.o(34074);
            } else {
                ab.w(BaseConversationUI.TAG, "on post select image job, acc not ready, cur retry count %d", Integer.valueOf(this.ypy));
                this.ypy++;
                al.n(this, 300);
                AppMethodBeat.o(34074);
            }
        }

        public final String toString() {
            AppMethodBeat.i(34075);
            String str = super.toString() + "|PostSelectImageJob";
            AppMethodBeat.o(34075);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BaseConversationUI() {
        AppMethodBeat.i(34076);
        AppMethodBeat.o(34076);
    }

    static /* synthetic */ String access$000(BaseConversationUI baseConversationUI) {
        AppMethodBeat.i(34109);
        String identityString = baseConversationUI.getIdentityString();
        AppMethodBeat.o(34109);
        return identityString;
    }

    static /* synthetic */ void access$1000(BaseConversationUI baseConversationUI) {
        AppMethodBeat.i(34113);
        baseConversationUI.doJobOnChattingAnimEnd();
        AppMethodBeat.o(34113);
    }

    static /* synthetic */ void access$1300(BaseConversationUI baseConversationUI, FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        AppMethodBeat.i(34114);
        baseConversationUI.updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView, i, rect, viewGroup);
        AppMethodBeat.o(34114);
    }

    static /* synthetic */ void access$300(BaseConversationUI baseConversationUI, Intent intent, boolean z) {
        AppMethodBeat.i(34110);
        baseConversationUI.prepareChattingFragment(intent, z);
        AppMethodBeat.o(34110);
    }

    static /* synthetic */ void access$600(BaseConversationUI baseConversationUI) {
        AppMethodBeat.i(34111);
        baseConversationUI.tryResetChattingSwipeStatus();
        AppMethodBeat.o(34111);
    }

    static /* synthetic */ void access$900(BaseConversationUI baseConversationUI) {
        AppMethodBeat.i(34112);
        baseConversationUI.doJobOnChattingAnimStart();
        AppMethodBeat.o(34112);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34077);
        getWindow().setFormat(-2);
        f.ah(this);
        super.onCreate(bundle);
        if (!b.dIo()) {
            getWindow().setCallback(new c(getWindow().getCallback(), this));
        }
        this.mActionBar = getSupportActionBar();
        initNavigationSwipeBack();
        AppMethodBeat.o(34077);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(34078);
        super.onNewIntent(intent);
        ab.i(TAG, "onNewIntent");
        setIntent(intent);
        AppMethodBeat.o(34078);
    }

    public void onResume() {
        AppMethodBeat.i(34079);
        super.onResume();
        h.b(this);
        onSwipe(1.0f);
        this.launcherUIStatus = a.ACTIVITY_RESUME;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34045);
                com.tencent.mm.modelstat.d.b(3, z ? "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this) : BaseConversationUI.this.getLocalClassName(), z ? BaseConversationUI.this.chattingFragmet.hashCode() : BaseConversationUI.this.hashCode());
                AppMethodBeat.o(34045);
            }
        }, "directReport_onResume");
        if (!z) {
            this.chattinguiResumeTime = bo.anT();
        }
        if (com.tencent.mm.compatible.util.d.iW(19) && com.tencent.mm.compatible.i.b.Ml()) {
            if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                this.chattingFragmet.getSwipeBackLayout().setEnableGesture(true);
            }
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(34047);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (BaseConversationUI.this.chattingView == null) {
                        String Yz;
                        if (BaseConversationUI.this.conversationFm == null || bo.isNullOrNil(BaseConversationUI.this.conversationFm.getUserName())) {
                            Yz = r.Yz();
                        } else {
                            Yz = BaseConversationUI.this.conversationFm.getUserName();
                        }
                        BaseConversationUI.access$300(BaseConversationUI.this, new Intent().putExtra("Chat_User", Yz), true);
                        BaseConversationUI.this.chattingView.setVisibility(8);
                        BaseConversationUI.this.resumeMainFragment();
                    }
                    ab.d(BaseConversationUI.TAG, "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(34047);
                    return false;
                }
            });
        }
        initActionBar();
        this.mActionBar.show();
        AppMethodBeat.o(34079);
    }

    public void onPause() {
        AppMethodBeat.i(34080);
        ab.i(TAG, "on pause");
        super.onPause();
        if (!isFinishing()) {
            h.a(this);
        }
        this.launcherUIStatus = a.ACTIVITY_PAUSE;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34048);
                com.tencent.mm.modelstat.d.b(4, z ? "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this) : BaseConversationUI.this.getLocalClassName(), z ? BaseConversationUI.this.chattingFragmet.hashCode() : BaseConversationUI.this.hashCode());
                if (z) {
                    com.tencent.mm.modelstat.d.h("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, ah.anT());
                }
                AppMethodBeat.o(34048);
            }
        }, "directReport_onPause");
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(34080);
    }

    public void onDestroy() {
        AppMethodBeat.i(34081);
        super.onDestroy();
        if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
            ab.i(TAG, "bitmap recycle %s", this.mPrepareBitmap.toString());
            this.mPrepareBitmap.recycle();
        }
        this.chattingFragmet = null;
        this.chattingFragmentView = null;
        this.chattingView = null;
        this.conversationFm = null;
        this.mActionBarHelper = null;
        this.mChattingInAnim = null;
        this.mChattingOutAnim = null;
        AppMethodBeat.o(34081);
    }

    public void onSwipe(float f) {
        AppMethodBeat.i(34082);
        ab.v(TAG, "ashutest::on swipe %f, duration %d, status %s", Float.valueOf(f), Long.valueOf(320), this.launcherUIStatus);
        if (!com.tencent.mm.compatible.util.d.iW(19) || !com.tencent.mm.compatible.i.b.Ml()) {
            AppMethodBeat.o(34082);
        } else if (this.chattingFragmet == null) {
            ab.e(TAG, "chattingFragmet is null!");
            AppMethodBeat.o(34082);
        } else {
            ImageView imageView;
            if (f == 0.0f && !this.mChattingClosed) {
                imageView = (ImageView) getWindow().getDecorView().findViewById(R.id.c4);
                if (imageView != null) {
                    ViewGroup viewGroup = (ViewGroup) imageView.getTag();
                    if (viewGroup != null) {
                        ab.i(TAG, "[onSwipe] prepareView GONE");
                        viewGroup.setVisibility(0);
                        imageView.setVisibility(8);
                        imageView.setImageDrawable(null);
                    }
                }
                if (this.mChattingInAnim != null) {
                    this.mChattingInAnim.cancel();
                }
            } else if (f == 1.0f && !this.mChattingClosed && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                getWindow().setBackgroundDrawableResource(R.color.y9);
                imageView = (ImageView) getWindow().getDecorView().findViewById(R.id.c4);
                if (!(imageView == null || imageView.getVisibility() != 0 || imageView.getTag() == null)) {
                    ((View) imageView.getTag()).setVisibility(0);
                    ab.i(TAG, "[onSwipe] prepareView GONE");
                    imageView.setVisibility(8);
                }
            }
            if (a.ACTIVITY_RESUME == this.launcherUIStatus || Float.compare(1.0f, f) <= 0) {
                View findViewById = findViewById(R.id.bp);
                imageView = (ImageView) findViewById(R.id.c4);
                if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null || this.mChattingClosed || f == 1.0f || f == 0.0f)) {
                    imageView.setVisibility(0);
                    ab.i(TAG, "[onSwipe] !1 && !0 prepareView VISIBLE");
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                resetViewTranX(findViewById, imageView, f);
                AppMethodBeat.o(34082);
                return;
            }
            ab.i(TAG, "[onSwipe] return! consumedSuperCall:%s", Float.valueOf(f));
            AppMethodBeat.o(34082);
        }
    }

    private void resetViewTranX(View view, ImageView imageView, float f) {
        AppMethodBeat.i(34083);
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.h.s(view, 0.0f);
            com.tencent.mm.ui.tools.h.s(imageView, 0.0f);
            AppMethodBeat.o(34083);
        } else if (imageView == null || imageView.getDrawable() == null) {
            com.tencent.mm.ui.tools.h.s(view, (((float) (view.getWidth() / 4)) * (1.0f - f)) * -1.0f);
            AppMethodBeat.o(34083);
        } else {
            com.tencent.mm.ui.tools.h.s(imageView, (((float) (imageView.getWidth() / 4)) * (1.0f - f)) * -1.0f);
            AppMethodBeat.o(34083);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(34084);
        super.onActivityResult(i, i2, intent);
        if (this.conversationFm != null) {
            this.conversationFm.onActivityResult(i, i2, intent);
        }
        if (i2 != -1) {
            AppMethodBeat.o(34084);
            return;
        }
        if (i == 2001 && this.chattingFragmet != null) {
            this.chattingFragmet.onActivityResult(i, i2, intent);
        }
        if (acceptRequestCode(i) && this.chattingFragmet == null) {
            ab.i(TAG, "on select image ActivityResult. the chattingUI maybe kill in the background.");
            al.af(this.selectImageJob);
            this.selectImageJob.ypy = 0;
            this.selectImageJob.requestCode = i;
            this.selectImageJob.bFZ = i2;
            this.selectImageJob.cEd = intent;
            al.d(this.selectImageJob);
            AppMethodBeat.o(34084);
            return;
        }
        AppMethodBeat.o(34084);
    }

    private void doJobOnChattingAnimStart() {
        AppMethodBeat.i(34085);
        this.chattingView.setTranslationX(0.0f);
        this.chattingView.dJY();
        AppMethodBeat.o(34085);
    }

    private void doJobOnChattingAnimEnd() {
        AppMethodBeat.i(34086);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34049);
                aw.RS().doM();
                al.Ma(0);
                BaseConversationUI.this.onSwipe(1.0f);
                if (!(BaseConversationUI.this.chattingView == null || BaseConversationUI.this.chattingFragmet == null)) {
                    BaseConversationUI.this.chattingView.dJZ();
                }
                BaseConversationUI.this.chattingUIProxy.onEnterEnd();
                BaseConversationUI.access$600(BaseConversationUI.this);
                AppMethodBeat.o(34049);
            }

            public final String toString() {
                AppMethodBeat.i(34050);
                String str = super.toString() + "|chattingView_onAnimationEnd";
                AppMethodBeat.o(34050);
                return str;
            }
        }, 60);
        AppMethodBeat.o(34086);
    }

    public void startChatting(String str) {
        AppMethodBeat.i(34088);
        startChatting(str, null, false);
        AppMethodBeat.o(34088);
    }

    public void startChatting(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(34089);
        String str2 = TAG;
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        ab.i(str2, str3, objArr);
        this.pendingBundle = bundle;
        this.pendingUser = str;
        this.mNeedChattingAnim = z;
        aw.RS().doK();
        al.Ma(-8);
        al.af(this.startChattingRunnable);
        al.d(this.startChattingRunnable);
        AppMethodBeat.o(34089);
    }

    @TargetApi(19)
    private void prepareChattingFragment(Intent intent, boolean z) {
        boolean z2;
        AppMethodBeat.i(34090);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.chattingFragmet == null) {
            this.chattingFragmet = getChattingUIFragment();
            this.chattingUIProxy = new y(this, this.chattingFragmet);
            z2 = true;
        } else {
            z2 = false;
        }
        createChattingView();
        if (intent != null) {
            this.chattingFragmet.getArguments().putAll(w.aM(intent));
        }
        if (z2) {
            this.chattingUIProxy.onInit(this.chattingID, z);
            this.chattingFragmentView = (OnLayoutChangedLinearLayout) this.chattingFragmet.getView().findViewById(R.id.zd);
        } else {
            this.chattingUIProxy.onEnterBegin();
        }
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        ab.i(TAG, "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent);
        AppMethodBeat.o(34090);
    }

    private void createChattingView() {
        AppMethodBeat.i(34091);
        int[] iArr;
        View childAt;
        if (this.chattingView != null) {
            if (this.chattingFragmet.isSupportCustomActionBar()) {
                iArr = new int[2];
                this.chattingView.getLocationInWindow(iArr);
                if (iArr[1] == 0) {
                    ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
                    int i = 0;
                    while (i < viewGroup.getChildCount()) {
                        childAt = ((ViewGroup) getWindow().getDecorView()).getChildAt(i);
                        if (childAt instanceof FitSystemWindowLayoutView) {
                            getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                            FitSystemWindowLayoutView fitSystemWindowLayoutView = (FitSystemWindowLayoutView) childAt;
                            fitSystemWindowLayoutView.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView.getCacheInsetsTop(), 0, 0));
                            ab.i(TAG, "rootLayout2 fitSystemWindows, top %s", Integer.valueOf(iArr[1]));
                            viewGroup = (ViewGroup) viewGroup.findViewById(R.id.bp);
                            ImageView imageView = (ImageView) fitSystemWindowLayoutView.findViewById(R.id.c4);
                            imageView.setTag(viewGroup);
                            LayoutParams layoutParams = viewGroup.getLayoutParams();
                            if (layoutParams == null || (layoutParams instanceof FrameLayout.LayoutParams)) {
                                imageView.setLayoutParams(layoutParams);
                            } else {
                                ab.w(TAG, "FIX LayoutParams");
                                imageView.setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
                            }
                            Bitmap magicDrawingCache = getMagicDrawingCache(viewGroup);
                            if (magicDrawingCache != null) {
                                imageView.setImageBitmap(magicDrawingCache);
                                viewGroup.setVisibility(8);
                                imageView.setVisibility(0);
                                ab.i(TAG, "[prepareChattingFragment] prepareView VISIBLE");
                            } else {
                                imageView.setImageBitmap(null);
                            }
                        } else {
                            ab.e(TAG, "on position %d, rootLayout not found!", Integer.valueOf(i));
                            i++;
                        }
                    }
                }
                ab.i(TAG, "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
            }
            AppMethodBeat.o(34091);
        } else if (this.chattingFragmet.isSupportCustomActionBar()) {
            ViewGroup viewGroup2;
            iArr = new int[2];
            getSupportActionBar().getCustomView().getLocationInWindow(iArr);
            TestTimeForChatting testTimeForChatting = new TestTimeForChatting(this);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            testTimeForChatting.setId(R.id.ab);
            this.chattingID = testTimeForChatting.getId();
            testTimeForChatting.setOrientation(1);
            testTimeForChatting.setLayoutParams(layoutParams2);
            final FitSystemWindowLayoutView fitSystemWindowLayoutView2 = new FitSystemWindowLayoutView(this);
            fitSystemWindowLayoutView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            childAt = findRootContainer();
            if (childAt == null) {
                childAt = ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
            }
            if (childAt instanceof SwipeBackLayout) {
                viewGroup2 = (ViewGroup) ((ViewGroup) childAt).getChildAt(0);
            } else {
                viewGroup2 = (ViewGroup) childAt;
            }
            ImageView imageView2 = new ImageView(this);
            imageView2.setId(R.id.c4);
            imageView2.setLayoutParams(layoutParams2);
            imageView2.setVisibility(8);
            ((ViewGroup) getWindow().getDecorView()).removeView(childAt);
            childAt.setId(R.id.bp);
            fitSystemWindowLayoutView2.addView(childAt);
            fitSystemWindowLayoutView2.addView(imageView2);
            fitSystemWindowLayoutView2.addView(testTimeForChatting);
            ((ViewGroup) getWindow().getDecorView()).addView(fitSystemWindowLayoutView2);
            getWindow().getDecorView().requestFitSystemWindows();
            int i2 = iArr[1];
            if (i2 > 0) {
                updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView2, i2, new Rect(0, i2, 0, 0), viewGroup2);
            } else {
                getSupportActionBar().getCustomView().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34056);
                        BaseConversationUI.this.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                        int i = iArr[1];
                        if (i > 0) {
                            BaseConversationUI.access$1300(BaseConversationUI.this, fitSystemWindowLayoutView2, i, new Rect(0, i, 0, 0), viewGroup2);
                            AppMethodBeat.o(34056);
                            return;
                        }
                        if (com.tencent.mm.compatible.util.d.iW(20)) {
                            fitSystemWindowLayoutView2.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                                @TargetApi(20)
                                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                    AppMethodBeat.i(34055);
                                    if (windowInsets == null) {
                                        AppMethodBeat.o(34055);
                                    } else {
                                        ab.i(BaseConversationUI.TAG, "OnApplyWindowInsetsListener %s", windowInsets);
                                        windowInsets.consumeSystemWindowInsets();
                                        BaseConversationUI.access$1300(BaseConversationUI.this, fitSystemWindowLayoutView2, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup2);
                                        AppMethodBeat.o(34055);
                                    }
                                    return windowInsets;
                                }
                            });
                        }
                        AppMethodBeat.o(34056);
                    }
                });
            }
            this.chattingView = (TestTimeForChatting) findViewById(this.chattingID);
            ab.i(TAG, "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(iArr[1]));
            AppMethodBeat.o(34091);
        } else {
            this.chattingView = (TestTimeForChatting) findViewById(R.id.a9f);
            this.chattingID = this.chattingView.getId();
            AppMethodBeat.o(34091);
        }
    }

    public Bitmap getMagicDrawingCache(View view) {
        int measuredWidth;
        int measuredHeight;
        AppMethodBeat.i(34092);
        long currentTimeMillis = System.currentTimeMillis();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0) {
            measuredWidth = view.getMeasuredWidth();
        } else {
            measuredWidth = width;
        }
        if (height <= 0) {
            measuredHeight = view.getMeasuredHeight();
        } else {
            measuredHeight = height;
        }
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            ab.e(TAG, "viewWidth:%s viewHeight:%s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            AppMethodBeat.o(34092);
            return null;
        }
        if (this.chattingFragmet != null) {
            ab.i(TAG, "getBottom:%s keyboardState:%s", Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState()));
        }
        if (this.chattingFragmet != null && this.chattingFragmet.getView().getBottom() > 0 && (this.chattingFragmet.keyboardState() == 1 || this.chattingFragmet.getView().getBottom() < (getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
            ab.e(TAG, "hardKeyboardHidden:%s", Integer.valueOf(this.chattingFragmet.keyboardState()));
            AppMethodBeat.o(34092);
            return null;
        } else if (this.chattingFragmet == null || this.chattingFragmet.keyboardState() != 1) {
            if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != measuredWidth || this.mPrepareBitmap.getHeight() != measuredHeight) {
                if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
                    ab.i(TAG, "bitmap recycle %s", this.mPrepareBitmap.toString());
                    this.mPrepareBitmap.recycle();
                }
                try {
                    this.mPrepareBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_4444);
                } catch (OutOfMemoryError e) {
                    ab.e(TAG, "[getMagicDrawingCache] e:%s", e);
                    AppMethodBeat.o(34092);
                    return null;
                }
            }
            this.mPrepareBitmap.eraseColor(0);
            Canvas canvas = new Canvas(this.mPrepareBitmap);
            width = (int) getResources().getDimension(R.dimen.a5);
            int dimension = (int) getResources().getDimension(R.dimen.fh);
            Paint paint = new Paint();
            paint.setColor(-1);
            canvas.drawRect(0.0f, (float) width, (float) measuredWidth, (float) (measuredHeight - dimension), paint);
            view.draw(canvas);
            ab.i(TAG, "[getMagicDrawingCache] cost%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Bitmap bitmap = this.mPrepareBitmap;
            AppMethodBeat.o(34092);
            return bitmap;
        } else {
            ab.e(TAG, "hardKeyboardHidden:%s", Integer.valueOf(this.chattingFragmet.keyboardState()));
            AppMethodBeat.o(34092);
            return null;
        }
    }

    private void updateRootViewSystemWindowsInsets(FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        int i2;
        AppMethodBeat.i(34093);
        int bottom = getWindow().getDecorView().getBottom();
        int bottom2 = getSupportActionBar().getCustomView().getBottom();
        if (this.conversationFm == null || this.conversationFm.getView() == null) {
            i2 = 0;
        } else {
            i2 = bottom - ((i + bottom2) + this.conversationFm.getView().getBottom());
        }
        ab.i(TAG, "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", Integer.valueOf(bottom), Integer.valueOf(i), Integer.valueOf(bottom2), Integer.valueOf(i2));
        fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
        fitSystemWindowLayoutView.fitSystemWindows(rect);
        AppMethodBeat.o(34093);
    }

    private ViewGroup findRootContainer() {
        AppMethodBeat.i(34094);
        ViewParent parent = this.mActionBar.getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent viewParent2 = (ViewGroup) getWindow().getDecorView();
        while (parent != viewParent2 && parent != null) {
            viewParent = parent;
            parent = parent.getParent();
        }
        ViewGroup viewGroup = (ViewGroup) viewParent;
        AppMethodBeat.o(34094);
        return viewGroup;
    }

    public void pauseMainFragment() {
        AppMethodBeat.i(34095);
        if (!(this.conversationFm == null || this.conversationFm.isSupportNavigationSwipeBack())) {
            this.conversationFm.showOptionMenu(false);
        }
        AppMethodBeat.o(34095);
    }

    public void resumeMainFragment() {
        AppMethodBeat.i(34096);
        if (this.conversationFm != null) {
            this.conversationFm.onResume();
            if (!this.conversationFm.isSupportNavigationSwipeBack()) {
                this.conversationFm.showOptionMenu(true);
            }
        }
        AppMethodBeat.o(34096);
    }

    public void closeChatting(boolean z) {
        AppMethodBeat.i(34097);
        String str = TAG;
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        ab.i(str, str2, objArr);
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            h.b(this);
        }
        if (this.chattingView == null || this.chattingView.getVisibility() == 8 || this.chattingFragmet == null) {
            AppMethodBeat.o(34097);
            return;
        }
        ab.i(TAG, "[closeChatting] needAnim:%s", Boolean.valueOf(z));
        this.chattingView.setVisibility(8);
        this.mChattingClosed = true;
        if (z && this.mChattingOutAnim == null) {
            this.mChattingOutAnim = AnimationUtils.loadAnimation(this, com.tencent.mm.ui.MMFragmentActivity.a.ynf);
            this.mChattingOutAnim.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(34060);
                    aw.RS().doK();
                    al.Ma(-8);
                    ab.i(BaseConversationUI.TAG, "klem pop out onAnimationStart");
                    BaseConversationUI.this.onSettle(true, 0);
                    AppMethodBeat.o(34060);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(34061);
                    aw.RS().doM();
                    al.Ma(0);
                    BaseConversationUI.access$600(BaseConversationUI.this);
                    ab.i(BaseConversationUI.TAG, "klem pop out onAnimationEnd");
                    AppMethodBeat.o(34061);
                }
            });
        }
        if (this.chattingFragmet.isSupportCustomActionBar()) {
            ImageView imageView = (ImageView) getWindow().getDecorView().findViewById(R.id.c4);
            if (imageView != null && imageView.getVisibility() == 0) {
                imageView.setVisibility(8);
                ab.i(TAG, "[closeChatting] prepareView GONE");
                if (imageView.getTag() != null) {
                    ((View) imageView.getTag()).setVisibility(0);
                }
            }
        }
        if (z) {
            this.chattingUIProxy.onExitBegin();
            this.chattingUIProxy.onExitEnd();
            this.chattingView.startAnimation(this.mChattingOutAnim);
        } else {
            this.chattingUIProxy.onExitBegin();
            this.chattingUIProxy.onExitEnd();
            this.chattingView.setVisibility(8);
            onSwipe(1.0f);
            tryResetChattingSwipeStatus();
        }
        if (!this.chattingFragmet.isSupportCustomActionBar()) {
            initActionBar();
        }
        supportInvalidateOptionsMenu();
        resumeMainFragment();
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34062);
                if (BaseConversationUI.this.chattingFragmet == null) {
                    AppMethodBeat.o(34062);
                    return;
                }
                com.tencent.mm.modelstat.d.b(4, "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattingFragmet.hashCode());
                com.tencent.mm.modelstat.d.h("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, ah.anT());
                com.tencent.mm.modelstat.d.b(3, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                AppMethodBeat.o(34062);
            }
        }, "directReport_closeChatting");
        AppMethodBeat.o(34097);
    }

    private void initActionBar() {
        AppMethodBeat.i(34098);
        if (this.chattingFragmet == null || !this.chattingFragmet.cgL.caA) {
            ab.w(TAG, "[initActionBar] isChattingForeground False!");
            View inflate = v.hu(this).inflate(R.layout.a_, null);
            this.mActionBarHelper = new com.tencent.mm.ui.a(inflate);
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.fc();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.fb();
            this.mActionBar.fd();
            this.mActionBar.setCustomView(inflate);
            updateTitle();
            this.mActionBarHelper.b(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34046);
                    if (BaseConversationUI.this.isAnimating) {
                        AppMethodBeat.o(34046);
                        return;
                    }
                    al.af(BaseConversationUI.this.startChattingRunnable);
                    BaseConversationUI.this.finish();
                    AppMethodBeat.o(34046);
                }
            });
            if (this.mActionBar.getCustomView() != null) {
                this.mActionBar.getCustomView().findViewById(R.id.kn);
                ((TextView) this.mActionBar.getCustomView().findViewById(R.id.ko)).setTextColor(getResources().getColor(R.color.h7));
            }
            AppMethodBeat.o(34098);
            return;
        }
        ab.w(TAG, "[initActionBar] isChattingForeground True!");
        AppMethodBeat.o(34098);
    }

    public void updateTitle() {
        AppMethodBeat.i(34099);
        if (this.mActionBarHelper != null) {
            this.mActionBarHelper.setTitle(s.mJ(this.title));
        }
        AppMethodBeat.o(34099);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(34100);
        this.title = str;
        if (this.mActionBarHelper != null) {
            updateTitle();
        }
        AppMethodBeat.o(34100);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        AppMethodBeat.i(34101);
        if (this.chattingFragmet == null || this.chattingFragmet.dBO() == null || !this.chattingFragmet.isSupportCustomActionBar()) {
            AppMethodBeat.o(34101);
            return null;
        } else if (com.tencent.mm.compatible.util.d.iX(22)) {
            AppMethodBeat.o(34101);
            return null;
        } else {
            ActionMode startActionMode = this.chattingFragmet.dBO().startActionMode(callback);
            if (startActionMode == null) {
                AppMethodBeat.o(34101);
                return null;
            }
            AppMethodBeat.o(34101);
            return startActionMode;
        }
    }

    private boolean acceptRequestCode(int i) {
        AppMethodBeat.i(34102);
        ab.w(TAG, "check request code %d", Integer.valueOf(CdnLogic.kBizGeneric & i));
        switch (CdnLogic.kBizGeneric & i) {
            case 217:
            case 218:
                AppMethodBeat.o(34102);
                return true;
            default:
                AppMethodBeat.o(34102);
                return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(34103);
        super.onRestoreInstanceState(bundle);
        this.lastRestoreTalker = bundle.getString(LAST_RESTORE_TALKER);
        ab.d(TAG, "onRestoreInstantceState:%s", this.lastRestoreTalker);
        AppMethodBeat.o(34103);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(34104);
        if (!(this.chattingFragmet == null || bo.isNullOrNil(this.chattingFragmet.cgL.getTalkerUserName()))) {
            ab.d(TAG, "onSaveInstanceState:%s", this.chattingFragmet.cgL.getTalkerUserName());
            bundle.putString(LAST_RESTORE_TALKER, this.chattingFragmet.cgL.getTalkerUserName());
        }
        AppMethodBeat.o(34104);
    }

    public void onSettle(boolean z, int i) {
        long j = 160;
        AppMethodBeat.i(34105);
        ab.v(TAG, "ashutest: on settle %B, speed %d, resumeStatus %s", Boolean.valueOf(z), Integer.valueOf(i), this.launcherUIStatus);
        if (com.tencent.mm.compatible.util.d.iW(19) && com.tencent.mm.compatible.i.b.Ml()) {
            View findViewById = findViewById(R.id.bp);
            if (findViewById == null) {
                ab.e(TAG, "[onSettle] null == container");
                AppMethodBeat.o(34105);
                return;
            }
            ImageView imageView = (ImageView) findViewById(R.id.c4);
            if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
                imageView.setVisibility(0);
                ab.i(TAG, "[onSettle] prepareView VISIBLE");
                findViewById.setVisibility(8);
            }
            if (imageView == null || imageView.getVisibility() != 0) {
                if (z) {
                    if (i <= 0) {
                        j = 290;
                    }
                    com.tencent.mm.ui.tools.h.a(findViewById, j, 0.0f, null);
                    AppMethodBeat.o(34105);
                    return;
                }
                if (i <= 0) {
                    j = 290;
                }
                com.tencent.mm.ui.tools.h.a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), null);
                AppMethodBeat.o(34105);
                return;
            } else if (z) {
                if (i <= 0) {
                    j = 290;
                }
                com.tencent.mm.ui.tools.h.a(imageView, j, 0.0f, null);
                AppMethodBeat.o(34105);
                return;
            } else {
                if (i <= 0) {
                    j = 290;
                }
                com.tencent.mm.ui.tools.h.a(imageView, j, (float) ((imageView.getWidth() * -1) / 4), null);
                AppMethodBeat.o(34105);
                return;
            }
        }
        AppMethodBeat.o(34105);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(34106);
        ab.d(TAG, "chatting ui dispatch key event %s", keyEvent);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            al.af(this.startChattingRunnable);
        }
        if (this.isAnimating) {
            AppMethodBeat.o(34106);
            return true;
        } else if (this.chattingFragmet == null || !this.chattingFragmet.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(34106);
            return dispatchKeyEvent;
        } else {
            AppMethodBeat.o(34106);
            return true;
        }
    }

    /* Access modifiers changed, original: protected */
    public ChattingUIFragment getChattingUIFragment() {
        AppMethodBeat.i(34107);
        ChattingUIFragment chattingUIFragment = new ChattingUIFragment();
        AppMethodBeat.o(34107);
        return chattingUIFragment;
    }

    private String getIdentityString() {
        AppMethodBeat.i(34108);
        String identityString;
        if (this.chattingFragmet != null) {
            identityString = this.chattingFragmet.getIdentityString();
            AppMethodBeat.o(34108);
            return identityString;
        }
        identityString = "";
        AppMethodBeat.o(34108);
        return identityString;
    }

    private void tryResetChattingSwipeStatus() {
        boolean z = true;
        AppMethodBeat.i(34087);
        if (com.tencent.mm.compatible.util.d.iW(19) && com.tencent.mm.compatible.i.b.Ml()) {
            String str = TAG;
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.chattingFragmet != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            if (this.chattingFragmet != null) {
                this.chattingFragmet.getSwipeBackLayout().zOp = false;
            }
            AppMethodBeat.o(34087);
            return;
        }
        AppMethodBeat.o(34087);
    }
}
