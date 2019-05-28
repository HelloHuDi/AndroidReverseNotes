package com.tencent.p177mm.p612ui.conversation;

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
import android.support.p069v7.app.ActionBar;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p223i.C1436b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p612ui.C15481a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.p177mm.p612ui.IChattingUIProxy;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.OnLayoutChangedLinearLayout;
import com.tencent.p177mm.p612ui.base.OnLayoutChangedLinearLayout.C23623a;
import com.tencent.p177mm.p612ui.chatting.C36230y;
import com.tencent.p177mm.p612ui.chatting.ChattingUIFragment;
import com.tencent.p177mm.p612ui.p614b.C15500c;
import com.tencent.p177mm.p612ui.tools.C5587h;
import com.tencent.p177mm.p612ui.tools.TestTimeForChatting;
import com.tencent.p177mm.p612ui.tools.TestTimeForChatting.C5579a;
import com.tencent.p177mm.p612ui.widget.C5666h;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;

/* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI */
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
    private C15845a launcherUIStatus = C15845a.ACTIVITY_CREATE;
    private ActionBar mActionBar;
    private C15481a mActionBarHelper;
    public boolean mChattingClosed = true;
    private Animation mChattingInAnim;
    private Animation mChattingOutAnim;
    private boolean mNeedChattingAnim = false;
    private Bitmap mPrepareBitmap;
    private C23623a onChattingLayoutChangedListener = new C158376();
    Bundle pendingBundle;
    String pendingUser;
    private C15846b selectImageJob = new C15846b(this, (byte) 0);
    Runnable startChattingRunnable = new C158438();
    private String title;

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$2 */
    class C54652 implements OnClickListener {
        C54652() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34046);
            if (BaseConversationUI.this.isAnimating) {
                AppMethodBeat.m2505o(34046);
                return;
            }
            C5004al.m7439af(BaseConversationUI.this.startChattingRunnable);
            BaseConversationUI.this.finish();
            AppMethodBeat.m2505o(34046);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$3 */
    class C158343 implements IdleHandler {
        C158343() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(34047);
            long currentTimeMillis = System.currentTimeMillis();
            if (BaseConversationUI.this.chattingView == null) {
                String Yz;
                if (BaseConversationUI.this.conversationFm == null || C5046bo.isNullOrNil(BaseConversationUI.this.conversationFm.getUserName())) {
                    Yz = C1853r.m3846Yz();
                } else {
                    Yz = BaseConversationUI.this.conversationFm.getUserName();
                }
                BaseConversationUI.access$300(BaseConversationUI.this, new Intent().putExtra("Chat_User", Yz), true);
                BaseConversationUI.this.chattingView.setVisibility(8);
                BaseConversationUI.this.resumeMainFragment();
            }
            C4990ab.m7411d(BaseConversationUI.TAG, "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(34047);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$9 */
    class C158359 implements AnimationListener {
        C158359() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(34060);
            C9638aw.m17180RS().doK();
            C5004al.m7436Ma(-8);
            C4990ab.m7416i(BaseConversationUI.TAG, "klem pop out onAnimationStart");
            BaseConversationUI.this.onSettle(true, 0);
            AppMethodBeat.m2505o(34060);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(34061);
            C9638aw.m17180RS().doM();
            C5004al.m7436Ma(0);
            BaseConversationUI.access$600(BaseConversationUI.this);
            C4990ab.m7416i(BaseConversationUI.TAG, "klem pop out onAnimationEnd");
            AppMethodBeat.m2505o(34061);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$BaseConversationFmUI */
    public static class BaseConversationFmUI extends MMFragment {
        private C15845a fmStatus = C15845a.ACTIVITY_CREATE;
        /* renamed from: ui */
        public BaseConversationUI f2991ui;

        public int getLayoutId() {
            return 0;
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.m2504i(34066);
            this.fmStatus = C15845a.ACTIVITY_CREATE;
            this.f2991ui = (BaseConversationUI) thisActivity();
            View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            setHasOptionsMenu(true);
            AppMethodBeat.m2505o(34066);
            return inflate;
        }

        public void setMMTitle(String str) {
            AppMethodBeat.m2504i(34067);
            if (this.f2991ui != null) {
                this.f2991ui.setTitle(str);
            }
            AppMethodBeat.m2505o(34067);
        }

        public void finish() {
            AppMethodBeat.m2504i(34068);
            thisActivity().finish();
            AppMethodBeat.m2505o(34068);
        }

        public void onResume() {
            AppMethodBeat.m2504i(34069);
            super.onResume();
            this.fmStatus = C15845a.ACTIVITY_RESUME;
            AppMethodBeat.m2505o(34069);
        }

        public void onPause() {
            AppMethodBeat.m2504i(34070);
            super.onPause();
            this.fmStatus = C15845a.ACTIVITY_PAUSE;
            AppMethodBeat.m2505o(34070);
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(34071);
            if (this.fmStatus != C15845a.ACTIVITY_PAUSE) {
                C4990ab.m7420w(BaseConversationUI.TAG, "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
                onPause();
            }
            super.onDestroy();
            AppMethodBeat.m2505o(34071);
        }

        public String getUserName() {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$5 */
    class C158365 implements Runnable {
        C158365() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34049);
            C9638aw.m17180RS().doM();
            C5004al.m7436Ma(0);
            BaseConversationUI.this.onSwipe(1.0f);
            if (!(BaseConversationUI.this.chattingView == null || BaseConversationUI.this.chattingFragmet == null)) {
                BaseConversationUI.this.chattingView.dJZ();
            }
            BaseConversationUI.this.chattingUIProxy.onEnterEnd();
            BaseConversationUI.access$600(BaseConversationUI.this);
            AppMethodBeat.m2505o(34049);
        }

        public final String toString() {
            AppMethodBeat.m2504i(34050);
            String str = super.toString() + "|chattingView_onAnimationEnd";
            AppMethodBeat.m2505o(34050);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$6 */
    class C158376 implements C23623a {
        long start = 0;

        /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$6$1 */
        class C158381 implements AnimationListener {
            C158381() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(34051);
                C4990ab.m7417i(BaseConversationUI.TAG, "klem onAnimationStart onDrawed->onAnimationStart:%sms", Long.valueOf(System.currentTimeMillis() - C158376.this.start));
                BaseConversationUI.this.isAnimating = true;
                BaseConversationUI.access$900(BaseConversationUI.this);
                BaseConversationUI.this.onSettle(false, 0);
                AppMethodBeat.m2505o(34051);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(34052);
                BaseConversationUI.this.isAnimating = false;
                C4990ab.m7416i(BaseConversationUI.TAG, "klem animationEnd");
                BaseConversationUI.access$1000(BaseConversationUI.this);
                AppMethodBeat.m2505o(34052);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$6$2 */
        class C158392 implements C5579a {
            C158392() {
            }

            public final void dyY() {
                AppMethodBeat.m2504i(34053);
                C4990ab.m7416i(BaseConversationUI.TAG, "[onDrawed]");
                C158376.this.start = System.currentTimeMillis();
                if (BaseConversationUI.this.chattingFragmet == null) {
                    C4990ab.m7412e(BaseConversationUI.TAG, "chattingFragmet is null!");
                    AppMethodBeat.m2505o(34053);
                    return;
                }
                if (BaseConversationUI.this.chattingFragmet.getSwipeBackLayout() != null) {
                    BaseConversationUI.this.chattingFragmet.getSwipeBackLayout().startAnimation(BaseConversationUI.this.mChattingInAnim);
                } else {
                    BaseConversationUI.this.chattingFragmet.getView().startAnimation(BaseConversationUI.this.mChattingInAnim);
                }
                BaseConversationUI.this.chattingView.setOndispatchDraw(null);
                AppMethodBeat.m2505o(34053);
            }
        }

        C158376() {
        }

        public final void dyX() {
            AppMethodBeat.m2504i(34054);
            if (BaseConversationUI.this.mChattingInAnim == null) {
                BaseConversationUI.this.mChattingInAnim = AnimationUtils.loadAnimation(BaseConversationUI.this, C5206a.ync);
                BaseConversationUI.this.mChattingInAnim.setAnimationListener(new C158381());
            }
            if (BaseConversationUI.this.mNeedChattingAnim) {
                BaseConversationUI.this.chattingView.setOndispatchDraw(new C158392());
                BaseConversationUI.this.mNeedChattingAnim = false;
            } else {
                BaseConversationUI.access$900(BaseConversationUI.this);
                BaseConversationUI.access$1000(BaseConversationUI.this);
            }
            BaseConversationUI.this.chattingFragmentView.yAx = null;
            C4990ab.m7416i(BaseConversationUI.TAG, "klem CHATTING ONLAYOUT ");
            AppMethodBeat.m2505o(34054);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$10 */
    class C1584010 implements Runnable {
        C1584010() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34062);
            if (BaseConversationUI.this.chattingFragmet == null) {
                AppMethodBeat.m2505o(34062);
                return;
            }
            C26483d.m42196b(4, "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattingFragmet.hashCode());
            C26483d.m42198h("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, C42252ah.anT());
            C26483d.m42196b(3, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
            AppMethodBeat.m2505o(34062);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$8 */
    class C158438 implements Runnable {

        /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$8$1 */
        class C158441 implements Runnable {
            C158441() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34057);
                C26483d.m42196b(4, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                C26483d.m42196b(3, "ChattingUI" + BaseConversationUI.this.chattingFragmet.getIdentityString(), BaseConversationUI.this.chattingFragmet.hashCode());
                AppMethodBeat.m2505o(34057);
            }
        }

        C158438() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34058);
            if (!BaseConversationUI.this.mChattingClosed) {
                C4990ab.m7412e(BaseConversationUI.TAG, "start chatting but last chatting does't be close!");
                BaseConversationUI.this.closeChatting(false);
            }
            if (BaseConversationUI.this.isFinishing() || BaseConversationUI.this.isPaused() || !BaseConversationUI.this.mChattingClosed) {
                C4990ab.m7421w(BaseConversationUI.TAG, "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", Boolean.valueOf(BaseConversationUI.this.isPaused()), Boolean.valueOf(BaseConversationUI.this.mChattingClosed));
                AppMethodBeat.m2505o(34058);
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
            C4990ab.m7417i(str, str2, objArr);
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
                C5666h.m8512a(BaseConversationUI.this);
            }
            C7305d.post(new C158441(), "directReport_startChattingRunnable");
            BaseConversationUI.this.chattinguiResumeTime = C5046bo.anT();
            AppMethodBeat.m2505o(34058);
        }

        public final String toString() {
            AppMethodBeat.m2504i(34059);
            String str = super.toString() + "|startChattingRunnable";
            AppMethodBeat.m2505o(34059);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$a */
    enum C15845a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE;

        static {
            AppMethodBeat.m2505o(34065);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$b */
    class C15846b implements Runnable {
        int bFZ;
        Intent cEd;
        int requestCode;
        int ypy;

        /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$b$1 */
        class C158331 implements Runnable {
            C158331() {
            }

            public final void run() {
                boolean z = true;
                AppMethodBeat.m2504i(34072);
                String str = BaseConversationUI.TAG;
                String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                Object[] objArr = new Object[1];
                if (BaseConversationUI.this.chattingFragmet != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7411d(str, str2, objArr);
                if (BaseConversationUI.this.chattingFragmet != null) {
                    C4990ab.m7410d(BaseConversationUI.TAG, "on select image ActivityResult. do post activity result");
                    BaseConversationUI.this.chattingFragmet.onActivityResult(C15846b.this.requestCode & CdnLogic.kBizGeneric, C15846b.this.bFZ, C15846b.this.cEd);
                }
                AppMethodBeat.m2505o(34072);
            }

            public final String toString() {
                AppMethodBeat.m2504i(34073);
                String str = super.toString() + "|PostSelectImageJob_onActivityResult";
                AppMethodBeat.m2505o(34073);
                return str;
            }
        }

        private C15846b() {
            this.ypy = 0;
        }

        /* synthetic */ C15846b(BaseConversationUI baseConversationUI, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(34074);
            if (C9638aw.m17179RK()) {
                C4990ab.m7417i(BaseConversationUI.TAG, "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.ypy));
                BaseConversationUI.this.startChatting(BaseConversationUI.this.lastRestoreTalker);
                C5004al.m7441d(new C158331());
                AppMethodBeat.m2505o(34074);
            } else if (this.ypy >= 3) {
                C4990ab.m7420w(BaseConversationUI.TAG, "on post select image job, match max retry count");
                AppMethodBeat.m2505o(34074);
            } else {
                C4990ab.m7421w(BaseConversationUI.TAG, "on post select image job, acc not ready, cur retry count %d", Integer.valueOf(this.ypy));
                this.ypy++;
                C5004al.m7442n(this, 300);
                AppMethodBeat.m2505o(34074);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(34075);
            String str = super.toString() + "|PostSelectImageJob";
            AppMethodBeat.m2505o(34075);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BaseConversationUI() {
        AppMethodBeat.m2504i(34076);
        AppMethodBeat.m2505o(34076);
    }

    static /* synthetic */ String access$000(BaseConversationUI baseConversationUI) {
        AppMethodBeat.m2504i(34109);
        String identityString = baseConversationUI.getIdentityString();
        AppMethodBeat.m2505o(34109);
        return identityString;
    }

    static /* synthetic */ void access$1000(BaseConversationUI baseConversationUI) {
        AppMethodBeat.m2504i(34113);
        baseConversationUI.doJobOnChattingAnimEnd();
        AppMethodBeat.m2505o(34113);
    }

    static /* synthetic */ void access$1300(BaseConversationUI baseConversationUI, FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(34114);
        baseConversationUI.updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView, i, rect, viewGroup);
        AppMethodBeat.m2505o(34114);
    }

    static /* synthetic */ void access$300(BaseConversationUI baseConversationUI, Intent intent, boolean z) {
        AppMethodBeat.m2504i(34110);
        baseConversationUI.prepareChattingFragment(intent, z);
        AppMethodBeat.m2505o(34110);
    }

    static /* synthetic */ void access$600(BaseConversationUI baseConversationUI) {
        AppMethodBeat.m2504i(34111);
        baseConversationUI.tryResetChattingSwipeStatus();
        AppMethodBeat.m2505o(34111);
    }

    static /* synthetic */ void access$900(BaseConversationUI baseConversationUI) {
        AppMethodBeat.m2504i(34112);
        baseConversationUI.doJobOnChattingAnimStart();
        AppMethodBeat.m2505o(34112);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34077);
        getWindow().setFormat(-2);
        C30036f.m47540ah(this);
        super.onCreate(bundle);
        if (!C5481b.dIo()) {
            getWindow().setCallback(new C15500c(getWindow().getCallback(), this));
        }
        this.mActionBar = getSupportActionBar();
        initNavigationSwipeBack();
        AppMethodBeat.m2505o(34077);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(34078);
        super.onNewIntent(intent);
        C4990ab.m7416i(TAG, "onNewIntent");
        setIntent(intent);
        AppMethodBeat.m2505o(34078);
    }

    public void onResume() {
        AppMethodBeat.m2504i(34079);
        super.onResume();
        C5666h.m8513b(this);
        onSwipe(1.0f);
        this.launcherUIStatus = C15845a.ACTIVITY_RESUME;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(34045);
                C26483d.m42196b(3, z ? "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this) : BaseConversationUI.this.getLocalClassName(), z ? BaseConversationUI.this.chattingFragmet.hashCode() : BaseConversationUI.this.hashCode());
                AppMethodBeat.m2505o(34045);
            }
        }, "directReport_onResume");
        if (!z) {
            this.chattinguiResumeTime = C5046bo.anT();
        }
        if (C1443d.m3068iW(19) && C1436b.m3061Ml()) {
            if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                this.chattingFragmet.getSwipeBackLayout().setEnableGesture(true);
            }
            Looper.myQueue().addIdleHandler(new C158343());
        }
        initActionBar();
        this.mActionBar.show();
        AppMethodBeat.m2505o(34079);
    }

    public void onPause() {
        AppMethodBeat.m2504i(34080);
        C4990ab.m7416i(TAG, "on pause");
        super.onPause();
        if (!isFinishing()) {
            C5666h.m8512a(this);
        }
        this.launcherUIStatus = C15845a.ACTIVITY_PAUSE;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(34048);
                C26483d.m42196b(4, z ? "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this) : BaseConversationUI.this.getLocalClassName(), z ? BaseConversationUI.this.chattingFragmet.hashCode() : BaseConversationUI.this.hashCode());
                if (z) {
                    C26483d.m42198h("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, C42252ah.anT());
                }
                AppMethodBeat.m2505o(34048);
            }
        }, "directReport_onPause");
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.m2505o(34080);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34081);
        super.onDestroy();
        if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
            C4990ab.m7417i(TAG, "bitmap recycle %s", this.mPrepareBitmap.toString());
            this.mPrepareBitmap.recycle();
        }
        this.chattingFragmet = null;
        this.chattingFragmentView = null;
        this.chattingView = null;
        this.conversationFm = null;
        this.mActionBarHelper = null;
        this.mChattingInAnim = null;
        this.mChattingOutAnim = null;
        AppMethodBeat.m2505o(34081);
    }

    public void onSwipe(float f) {
        AppMethodBeat.m2504i(34082);
        C4990ab.m7419v(TAG, "ashutest::on swipe %f, duration %d, status %s", Float.valueOf(f), Long.valueOf(320), this.launcherUIStatus);
        if (!C1443d.m3068iW(19) || !C1436b.m3061Ml()) {
            AppMethodBeat.m2505o(34082);
        } else if (this.chattingFragmet == null) {
            C4990ab.m7412e(TAG, "chattingFragmet is null!");
            AppMethodBeat.m2505o(34082);
        } else {
            ImageView imageView;
            if (f == 0.0f && !this.mChattingClosed) {
                imageView = (ImageView) getWindow().getDecorView().findViewById(2131820648);
                if (imageView != null) {
                    ViewGroup viewGroup = (ViewGroup) imageView.getTag();
                    if (viewGroup != null) {
                        C4990ab.m7416i(TAG, "[onSwipe] prepareView GONE");
                        viewGroup.setVisibility(0);
                        imageView.setVisibility(8);
                        imageView.setImageDrawable(null);
                    }
                }
                if (this.mChattingInAnim != null) {
                    this.mChattingInAnim.cancel();
                }
            } else if (f == 1.0f && !this.mChattingClosed && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                getWindow().setBackgroundDrawableResource(C25738R.color.f12273y9);
                imageView = (ImageView) getWindow().getDecorView().findViewById(2131820648);
                if (!(imageView == null || imageView.getVisibility() != 0 || imageView.getTag() == null)) {
                    ((View) imageView.getTag()).setVisibility(0);
                    C4990ab.m7416i(TAG, "[onSwipe] prepareView GONE");
                    imageView.setVisibility(8);
                }
            }
            if (C15845a.ACTIVITY_RESUME == this.launcherUIStatus || Float.compare(1.0f, f) <= 0) {
                View findViewById = findViewById(2131820633);
                imageView = (ImageView) findViewById(2131820648);
                if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null || this.mChattingClosed || f == 1.0f || f == 0.0f)) {
                    imageView.setVisibility(0);
                    C4990ab.m7416i(TAG, "[onSwipe] !1 && !0 prepareView VISIBLE");
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                resetViewTranX(findViewById, imageView, f);
                AppMethodBeat.m2505o(34082);
                return;
            }
            C4990ab.m7417i(TAG, "[onSwipe] return! consumedSuperCall:%s", Float.valueOf(f));
            AppMethodBeat.m2505o(34082);
        }
    }

    private void resetViewTranX(View view, ImageView imageView, float f) {
        AppMethodBeat.m2504i(34083);
        if (Float.compare(1.0f, f) <= 0) {
            C5587h.m8390s(view, 0.0f);
            C5587h.m8390s(imageView, 0.0f);
            AppMethodBeat.m2505o(34083);
        } else if (imageView == null || imageView.getDrawable() == null) {
            C5587h.m8390s(view, (((float) (view.getWidth() / 4)) * (1.0f - f)) * -1.0f);
            AppMethodBeat.m2505o(34083);
        } else {
            C5587h.m8390s(imageView, (((float) (imageView.getWidth() / 4)) * (1.0f - f)) * -1.0f);
            AppMethodBeat.m2505o(34083);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(34084);
        super.onActivityResult(i, i2, intent);
        if (this.conversationFm != null) {
            this.conversationFm.onActivityResult(i, i2, intent);
        }
        if (i2 != -1) {
            AppMethodBeat.m2505o(34084);
            return;
        }
        if (i == 2001 && this.chattingFragmet != null) {
            this.chattingFragmet.onActivityResult(i, i2, intent);
        }
        if (acceptRequestCode(i) && this.chattingFragmet == null) {
            C4990ab.m7416i(TAG, "on select image ActivityResult. the chattingUI maybe kill in the background.");
            C5004al.m7439af(this.selectImageJob);
            this.selectImageJob.ypy = 0;
            this.selectImageJob.requestCode = i;
            this.selectImageJob.bFZ = i2;
            this.selectImageJob.cEd = intent;
            C5004al.m7441d(this.selectImageJob);
            AppMethodBeat.m2505o(34084);
            return;
        }
        AppMethodBeat.m2505o(34084);
    }

    private void doJobOnChattingAnimStart() {
        AppMethodBeat.m2504i(34085);
        this.chattingView.setTranslationX(0.0f);
        this.chattingView.dJY();
        AppMethodBeat.m2505o(34085);
    }

    private void doJobOnChattingAnimEnd() {
        AppMethodBeat.m2504i(34086);
        C5004al.m7442n(new C158365(), 60);
        AppMethodBeat.m2505o(34086);
    }

    public void startChatting(String str) {
        AppMethodBeat.m2504i(34088);
        startChatting(str, null, false);
        AppMethodBeat.m2505o(34088);
    }

    public void startChatting(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(34089);
        String str2 = TAG;
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        C4990ab.m7417i(str2, str3, objArr);
        this.pendingBundle = bundle;
        this.pendingUser = str;
        this.mNeedChattingAnim = z;
        C9638aw.m17180RS().doK();
        C5004al.m7436Ma(-8);
        C5004al.m7439af(this.startChattingRunnable);
        C5004al.m7441d(this.startChattingRunnable);
        AppMethodBeat.m2505o(34089);
    }

    @TargetApi(19)
    private void prepareChattingFragment(Intent intent, boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(34090);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.chattingFragmet == null) {
            this.chattingFragmet = getChattingUIFragment();
            this.chattingUIProxy = new C36230y(this, this.chattingFragmet);
            z2 = true;
        } else {
            z2 = false;
        }
        createChattingView();
        if (intent != null) {
            this.chattingFragmet.getArguments().putAll(C5068w.m7684aM(intent));
        }
        if (z2) {
            this.chattingUIProxy.onInit(this.chattingID, z);
            this.chattingFragmentView = (OnLayoutChangedLinearLayout) this.chattingFragmet.getView().findViewById(2131821521);
        } else {
            this.chattingUIProxy.onEnterBegin();
        }
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        C4990ab.m7417i(TAG, "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent);
        AppMethodBeat.m2505o(34090);
    }

    private void createChattingView() {
        AppMethodBeat.m2504i(34091);
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
                            C4990ab.m7417i(TAG, "rootLayout2 fitSystemWindows, top %s", Integer.valueOf(iArr[1]));
                            viewGroup = (ViewGroup) viewGroup.findViewById(2131820633);
                            ImageView imageView = (ImageView) fitSystemWindowLayoutView.findViewById(2131820648);
                            imageView.setTag(viewGroup);
                            LayoutParams layoutParams = viewGroup.getLayoutParams();
                            if (layoutParams == null || (layoutParams instanceof FrameLayout.LayoutParams)) {
                                imageView.setLayoutParams(layoutParams);
                            } else {
                                C4990ab.m7420w(TAG, "FIX LayoutParams");
                                imageView.setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
                            }
                            Bitmap magicDrawingCache = getMagicDrawingCache(viewGroup);
                            if (magicDrawingCache != null) {
                                imageView.setImageBitmap(magicDrawingCache);
                                viewGroup.setVisibility(8);
                                imageView.setVisibility(0);
                                C4990ab.m7416i(TAG, "[prepareChattingFragment] prepareView VISIBLE");
                            } else {
                                imageView.setImageBitmap(null);
                            }
                        } else {
                            C4990ab.m7413e(TAG, "on position %d, rootLayout not found!", Integer.valueOf(i));
                            i++;
                        }
                    }
                }
                C4990ab.m7417i(TAG, "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
            }
            AppMethodBeat.m2505o(34091);
        } else if (this.chattingFragmet.isSupportCustomActionBar()) {
            ViewGroup viewGroup2;
            iArr = new int[2];
            getSupportActionBar().getCustomView().getLocationInWindow(iArr);
            TestTimeForChatting testTimeForChatting = new TestTimeForChatting(this);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            testTimeForChatting.setId(2131820582);
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
            imageView2.setId(2131820648);
            imageView2.setLayoutParams(layoutParams2);
            imageView2.setVisibility(8);
            ((ViewGroup) getWindow().getDecorView()).removeView(childAt);
            childAt.setId(2131820633);
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

                    /* renamed from: com.tencent.mm.ui.conversation.BaseConversationUI$7$1 */
                    class C158421 implements OnApplyWindowInsetsListener {
                        C158421() {
                        }

                        @TargetApi(20)
                        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            AppMethodBeat.m2504i(34055);
                            if (windowInsets == null) {
                                AppMethodBeat.m2505o(34055);
                            } else {
                                C4990ab.m7417i(BaseConversationUI.TAG, "OnApplyWindowInsetsListener %s", windowInsets);
                                windowInsets.consumeSystemWindowInsets();
                                BaseConversationUI.access$1300(BaseConversationUI.this, fitSystemWindowLayoutView2, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup2);
                                AppMethodBeat.m2505o(34055);
                            }
                            return windowInsets;
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(34056);
                        BaseConversationUI.this.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                        int i = iArr[1];
                        if (i > 0) {
                            BaseConversationUI.access$1300(BaseConversationUI.this, fitSystemWindowLayoutView2, i, new Rect(0, i, 0, 0), viewGroup2);
                            AppMethodBeat.m2505o(34056);
                            return;
                        }
                        if (C1443d.m3068iW(20)) {
                            fitSystemWindowLayoutView2.setOnApplyWindowInsetsListener(new C158421());
                        }
                        AppMethodBeat.m2505o(34056);
                    }
                });
            }
            this.chattingView = (TestTimeForChatting) findViewById(this.chattingID);
            C4990ab.m7417i(TAG, "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(iArr[1]));
            AppMethodBeat.m2505o(34091);
        } else {
            this.chattingView = (TestTimeForChatting) findViewById(2131821893);
            this.chattingID = this.chattingView.getId();
            AppMethodBeat.m2505o(34091);
        }
    }

    public Bitmap getMagicDrawingCache(View view) {
        int measuredWidth;
        int measuredHeight;
        AppMethodBeat.m2504i(34092);
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
            C4990ab.m7413e(TAG, "viewWidth:%s viewHeight:%s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            AppMethodBeat.m2505o(34092);
            return null;
        }
        if (this.chattingFragmet != null) {
            C4990ab.m7417i(TAG, "getBottom:%s keyboardState:%s", Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState()));
        }
        if (this.chattingFragmet != null && this.chattingFragmet.getView().getBottom() > 0 && (this.chattingFragmet.keyboardState() == 1 || this.chattingFragmet.getView().getBottom() < (getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
            C4990ab.m7413e(TAG, "hardKeyboardHidden:%s", Integer.valueOf(this.chattingFragmet.keyboardState()));
            AppMethodBeat.m2505o(34092);
            return null;
        } else if (this.chattingFragmet == null || this.chattingFragmet.keyboardState() != 1) {
            if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != measuredWidth || this.mPrepareBitmap.getHeight() != measuredHeight) {
                if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
                    C4990ab.m7417i(TAG, "bitmap recycle %s", this.mPrepareBitmap.toString());
                    this.mPrepareBitmap.recycle();
                }
                try {
                    this.mPrepareBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_4444);
                } catch (OutOfMemoryError e) {
                    C4990ab.m7413e(TAG, "[getMagicDrawingCache] e:%s", e);
                    AppMethodBeat.m2505o(34092);
                    return null;
                }
            }
            this.mPrepareBitmap.eraseColor(0);
            Canvas canvas = new Canvas(this.mPrepareBitmap);
            width = (int) getResources().getDimension(C25738R.dimen.f9647a5);
            int dimension = (int) getResources().getDimension(C25738R.dimen.f9782fh);
            Paint paint = new Paint();
            paint.setColor(-1);
            canvas.drawRect(0.0f, (float) width, (float) measuredWidth, (float) (measuredHeight - dimension), paint);
            view.draw(canvas);
            C4990ab.m7417i(TAG, "[getMagicDrawingCache] cost%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Bitmap bitmap = this.mPrepareBitmap;
            AppMethodBeat.m2505o(34092);
            return bitmap;
        } else {
            C4990ab.m7413e(TAG, "hardKeyboardHidden:%s", Integer.valueOf(this.chattingFragmet.keyboardState()));
            AppMethodBeat.m2505o(34092);
            return null;
        }
    }

    private void updateRootViewSystemWindowsInsets(FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        int i2;
        AppMethodBeat.m2504i(34093);
        int bottom = getWindow().getDecorView().getBottom();
        int bottom2 = getSupportActionBar().getCustomView().getBottom();
        if (this.conversationFm == null || this.conversationFm.getView() == null) {
            i2 = 0;
        } else {
            i2 = bottom - ((i + bottom2) + this.conversationFm.getView().getBottom());
        }
        C4990ab.m7417i(TAG, "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", Integer.valueOf(bottom), Integer.valueOf(i), Integer.valueOf(bottom2), Integer.valueOf(i2));
        fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
        fitSystemWindowLayoutView.fitSystemWindows(rect);
        AppMethodBeat.m2505o(34093);
    }

    private ViewGroup findRootContainer() {
        AppMethodBeat.m2504i(34094);
        ViewParent parent = this.mActionBar.getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent viewParent2 = (ViewGroup) getWindow().getDecorView();
        while (parent != viewParent2 && parent != null) {
            viewParent = parent;
            parent = parent.getParent();
        }
        ViewGroup viewGroup = (ViewGroup) viewParent;
        AppMethodBeat.m2505o(34094);
        return viewGroup;
    }

    public void pauseMainFragment() {
        AppMethodBeat.m2504i(34095);
        if (!(this.conversationFm == null || this.conversationFm.isSupportNavigationSwipeBack())) {
            this.conversationFm.showOptionMenu(false);
        }
        AppMethodBeat.m2505o(34095);
    }

    public void resumeMainFragment() {
        AppMethodBeat.m2504i(34096);
        if (this.conversationFm != null) {
            this.conversationFm.onResume();
            if (!this.conversationFm.isSupportNavigationSwipeBack()) {
                this.conversationFm.showOptionMenu(true);
            }
        }
        AppMethodBeat.m2505o(34096);
    }

    public void closeChatting(boolean z) {
        AppMethodBeat.m2504i(34097);
        String str = TAG;
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        C4990ab.m7417i(str, str2, objArr);
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            C5666h.m8513b(this);
        }
        if (this.chattingView == null || this.chattingView.getVisibility() == 8 || this.chattingFragmet == null) {
            AppMethodBeat.m2505o(34097);
            return;
        }
        C4990ab.m7417i(TAG, "[closeChatting] needAnim:%s", Boolean.valueOf(z));
        this.chattingView.setVisibility(8);
        this.mChattingClosed = true;
        if (z && this.mChattingOutAnim == null) {
            this.mChattingOutAnim = AnimationUtils.loadAnimation(this, C5206a.ynf);
            this.mChattingOutAnim.setAnimationListener(new C158359());
        }
        if (this.chattingFragmet.isSupportCustomActionBar()) {
            ImageView imageView = (ImageView) getWindow().getDecorView().findViewById(2131820648);
            if (imageView != null && imageView.getVisibility() == 0) {
                imageView.setVisibility(8);
                C4990ab.m7416i(TAG, "[closeChatting] prepareView GONE");
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
        C7305d.post(new C1584010(), "directReport_closeChatting");
        AppMethodBeat.m2505o(34097);
    }

    private void initActionBar() {
        AppMethodBeat.m2504i(34098);
        if (this.chattingFragmet == null || !this.chattingFragmet.cgL.caA) {
            C4990ab.m7420w(TAG, "[initActionBar] isChattingForeground False!");
            View inflate = C5616v.m8409hu(this).inflate(2130968612, null);
            this.mActionBarHelper = new C15481a(inflate);
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.mo1339fc();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.mo1338fb();
            this.mActionBar.mo1340fd();
            this.mActionBar.setCustomView(inflate);
            updateTitle();
            this.mActionBarHelper.mo27555b(new C54652());
            if (this.mActionBar.getCustomView() != null) {
                this.mActionBar.getCustomView().findViewById(2131820964);
                ((TextView) this.mActionBar.getCustomView().findViewById(2131820965)).setTextColor(getResources().getColor(C25738R.color.f11785h7));
            }
            AppMethodBeat.m2505o(34098);
            return;
        }
        C4990ab.m7420w(TAG, "[initActionBar] isChattingForeground True!");
        AppMethodBeat.m2505o(34098);
    }

    public void updateTitle() {
        AppMethodBeat.m2504i(34099);
        if (this.mActionBarHelper != null) {
            this.mActionBarHelper.setTitle(C1854s.m3866mJ(this.title));
        }
        AppMethodBeat.m2505o(34099);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(34100);
        this.title = str;
        if (this.mActionBarHelper != null) {
            updateTitle();
        }
        AppMethodBeat.m2505o(34100);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        AppMethodBeat.m2504i(34101);
        if (this.chattingFragmet == null || this.chattingFragmet.dBO() == null || !this.chattingFragmet.isSupportCustomActionBar()) {
            AppMethodBeat.m2505o(34101);
            return null;
        } else if (C1443d.m3069iX(22)) {
            AppMethodBeat.m2505o(34101);
            return null;
        } else {
            ActionMode startActionMode = this.chattingFragmet.dBO().startActionMode(callback);
            if (startActionMode == null) {
                AppMethodBeat.m2505o(34101);
                return null;
            }
            AppMethodBeat.m2505o(34101);
            return startActionMode;
        }
    }

    private boolean acceptRequestCode(int i) {
        AppMethodBeat.m2504i(34102);
        C4990ab.m7421w(TAG, "check request code %d", Integer.valueOf(CdnLogic.kBizGeneric & i));
        switch (CdnLogic.kBizGeneric & i) {
            case 217:
            case 218:
                AppMethodBeat.m2505o(34102);
                return true;
            default:
                AppMethodBeat.m2505o(34102);
                return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(34103);
        super.onRestoreInstanceState(bundle);
        this.lastRestoreTalker = bundle.getString(LAST_RESTORE_TALKER);
        C4990ab.m7411d(TAG, "onRestoreInstantceState:%s", this.lastRestoreTalker);
        AppMethodBeat.m2505o(34103);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(34104);
        if (!(this.chattingFragmet == null || C5046bo.isNullOrNil(this.chattingFragmet.cgL.getTalkerUserName()))) {
            C4990ab.m7411d(TAG, "onSaveInstanceState:%s", this.chattingFragmet.cgL.getTalkerUserName());
            bundle.putString(LAST_RESTORE_TALKER, this.chattingFragmet.cgL.getTalkerUserName());
        }
        AppMethodBeat.m2505o(34104);
    }

    public void onSettle(boolean z, int i) {
        long j = 160;
        AppMethodBeat.m2504i(34105);
        C4990ab.m7419v(TAG, "ashutest: on settle %B, speed %d, resumeStatus %s", Boolean.valueOf(z), Integer.valueOf(i), this.launcherUIStatus);
        if (C1443d.m3068iW(19) && C1436b.m3061Ml()) {
            View findViewById = findViewById(2131820633);
            if (findViewById == null) {
                C4990ab.m7412e(TAG, "[onSettle] null == container");
                AppMethodBeat.m2505o(34105);
                return;
            }
            ImageView imageView = (ImageView) findViewById(2131820648);
            if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
                imageView.setVisibility(0);
                C4990ab.m7416i(TAG, "[onSettle] prepareView VISIBLE");
                findViewById.setVisibility(8);
            }
            if (imageView == null || imageView.getVisibility() != 0) {
                if (z) {
                    if (i <= 0) {
                        j = 290;
                    }
                    C5587h.m8387a(findViewById, j, 0.0f, null);
                    AppMethodBeat.m2505o(34105);
                    return;
                }
                if (i <= 0) {
                    j = 290;
                }
                C5587h.m8387a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), null);
                AppMethodBeat.m2505o(34105);
                return;
            } else if (z) {
                if (i <= 0) {
                    j = 290;
                }
                C5587h.m8387a(imageView, j, 0.0f, null);
                AppMethodBeat.m2505o(34105);
                return;
            } else {
                if (i <= 0) {
                    j = 290;
                }
                C5587h.m8387a(imageView, j, (float) ((imageView.getWidth() * -1) / 4), null);
                AppMethodBeat.m2505o(34105);
                return;
            }
        }
        AppMethodBeat.m2505o(34105);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(34106);
        C4990ab.m7411d(TAG, "chatting ui dispatch key event %s", keyEvent);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C5004al.m7439af(this.startChattingRunnable);
        }
        if (this.isAnimating) {
            AppMethodBeat.m2505o(34106);
            return true;
        } else if (this.chattingFragmet == null || !this.chattingFragmet.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.m2505o(34106);
            return dispatchKeyEvent;
        } else {
            AppMethodBeat.m2505o(34106);
            return true;
        }
    }

    /* Access modifiers changed, original: protected */
    public ChattingUIFragment getChattingUIFragment() {
        AppMethodBeat.m2504i(34107);
        ChattingUIFragment chattingUIFragment = new ChattingUIFragment();
        AppMethodBeat.m2505o(34107);
        return chattingUIFragment;
    }

    private String getIdentityString() {
        AppMethodBeat.m2504i(34108);
        String identityString;
        if (this.chattingFragmet != null) {
            identityString = this.chattingFragmet.getIdentityString();
            AppMethodBeat.m2505o(34108);
            return identityString;
        }
        identityString = "";
        AppMethodBeat.m2505o(34108);
        return identityString;
    }

    private void tryResetChattingSwipeStatus() {
        boolean z = true;
        AppMethodBeat.m2504i(34087);
        if (C1443d.m3068iW(19) && C1436b.m3061Ml()) {
            String str = TAG;
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.chattingFragmet != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            if (this.chattingFragmet != null) {
                this.chattingFragmet.getSwipeBackLayout().zOp = false;
            }
            AppMethodBeat.m2505o(34087);
            return;
        }
        AppMethodBeat.m2505o(34087);
    }
}
