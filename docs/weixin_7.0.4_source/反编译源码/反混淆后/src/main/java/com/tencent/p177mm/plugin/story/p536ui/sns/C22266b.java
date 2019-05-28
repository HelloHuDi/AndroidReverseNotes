package com.tencent.p177mm.plugin.story.p536ui.sns;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.app.C6218i;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C35248e;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C35251l.C13884b;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C4172f;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C4181h;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.util.ActUtil;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\"\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.sns.b */
public final class C22266b extends C6218i {
    private static final String TAG = TAG;
    public static final C22269a shk = new C22269a();
    private Context mContext;
    private C4172f shf;
    private final C22267b shg = new C22267b(this);
    private boolean shh;
    private boolean shi;
    private boolean shj;
    private View targetView;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.b$b */
    public static final class C22267b implements C13884b {
        final /* synthetic */ C22266b shl;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.b$b$a */
        static final class C22268a implements Runnable {
            final /* synthetic */ C22267b shm;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.story.ui.sns.b$b$a$1 */
            static final class C138431 implements Runnable {
                final /* synthetic */ C22268a shn;

                C138431(C22268a c22268a) {
                    this.shn = c22268a;
                }

                public final void run() {
                    AppMethodBeat.m2504i(110235);
                    if (this.shn.shm.shl.isShowing()) {
                        this.shn.shm.shl.cancel();
                    }
                    AppMethodBeat.m2505o(110235);
                }
            }

            C22268a(C22267b c22267b) {
                this.shm = c22267b;
            }

            public final void run() {
                AppMethodBeat.m2504i(110236);
                new C7306ak().post(new C138431(this));
                AppMethodBeat.m2505o(110236);
            }
        }

        C22267b(C22266b c22266b) {
            this.shl = c22266b;
        }

        /* renamed from: bc */
        public final void mo26102bc(float f) {
        }

        public final void cCg() {
            long j = 0;
            AppMethodBeat.m2504i(110237);
            View a = this.shl.targetView;
            if (a != null) {
                a.setEnabled(false);
                long height = (long) (((((float) a.getHeight()) - a.getTranslationY()) / ((float) a.getHeight())) * 300.0f);
                if (height >= 0) {
                    j = height;
                }
                a.animate().translationY((float) a.getHeight()).setDuration(j).withEndAction(new C22268a(this)).start();
                AppMethodBeat.m2505o(110237);
                return;
            }
            AppMethodBeat.m2505o(110237);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.b$a */
    public static final class C22269a {
        private C22269a() {
        }

        public /* synthetic */ C22269a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.b$c */
    static final class C22270c implements OnClickListener {
        final /* synthetic */ C22266b shl;

        C22270c(C22266b c22266b) {
            this.shl = c22266b;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110238);
            if (this.shl.isShowing()) {
                this.shl.cancel();
            }
            AppMethodBeat.m2505o(110238);
        }
    }

    public C22266b(Context context) {
        C25052j.m39376p(context, "mContext");
        super(context, C25738R.style.f10872h4);
        AppMethodBeat.m2504i(110244);
        this.mContext = context;
        mo14042fA();
        Context context2 = getContext();
        C25052j.m39375o(context2, "context");
        this.shf = new C4172f(context2);
        AppMethodBeat.m2505o(110244);
    }

    static {
        AppMethodBeat.m2504i(110245);
        AppMethodBeat.m2505o(110245);
    }

    private final boolean isLandscape() {
        AppMethodBeat.m2504i(110239);
        Resources resources = this.mContext.getResources();
        C25052j.m39375o(resources, "mContext.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.m2505o(110239);
            return true;
        }
        AppMethodBeat.m2505o(110239);
        return false;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(110240);
        super.onCreate(bundle);
        getWindow().setDimAmount(0.0f);
        AppMethodBeat.m2505o(110240);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(110242);
        C25052j.m39376p(motionEvent, "ev");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.shj = false;
                break;
            case 1:
            case 3:
                break;
        }
        this.shi = false;
        this.shf.mo9091J(motionEvent);
        int i = this.shf.sod;
        if (!(i == 1 || i == 2)) {
            if (!this.shi && !this.shh) {
                z = this.shf.dispatchTouchEvent(motionEvent);
            } else if (!this.shj) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                C25052j.m39375o(obtain, "cancelEvent");
                obtain.setAction(3);
                this.shf.dispatchTouchEvent(obtain);
                obtain.recycle();
                this.shj = true;
            }
        }
        if (this.shi || z) {
            if (!this.shj) {
                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                C25052j.m39375o(obtain2, "cancelEvent");
                obtain2.setAction(3);
                super.dispatchTouchEvent(obtain2);
                obtain2.recycle();
                this.shj = true;
            }
            AppMethodBeat.m2505o(110242);
            return true;
        }
        z = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(110242);
        return z;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(110243);
        if (this.targetView instanceof C43650a) {
            View view = this.targetView;
            if (view == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
                AppMethodBeat.m2505o(110243);
                throw c44941v;
            }
            ((C43650a) view).finish();
        }
        super.cancel();
        AppMethodBeat.m2505o(110243);
    }

    public final void setContentView(View view) {
        AppMethodBeat.m2504i(110241);
        C25052j.m39376p(view, "view");
        Window window = getWindow();
        if (isLandscape()) {
            if (window == null) {
                C25052j.dWJ();
            }
            window.setGravity(5);
            window.setWindowAnimations(C25738R.style.f11154qp);
        } else {
            if (window == null) {
                C25052j.dWJ();
            }
            window.setGravity(80);
            window.setWindowAnimations(C25738R.style.f10822fc);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = window.getAttributes();
        if (isLandscape()) {
            attributes.width = -2;
            attributes.height = -1;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        view.findViewById(2131823263).setOnClickListener(new C22270c(this));
        super.setContentView(view);
        this.targetView = view;
        this.shf.mo9092a((C35248e) new C4181h(view, this.shg));
        window = getWindow();
        if (window == null) {
            C25052j.dWJ();
        }
        window.setLayout(-1, -1);
        if (getWindow() != null) {
            if (VERSION.SDK_INT >= 21) {
                window = getWindow();
                C25052j.m39375o(window, "window");
                View decorView = window.getDecorView();
                C25052j.m39375o(decorView, "window.decorView");
                decorView.setSystemUiVisibility(ActUtil.HEIGHT);
                getWindow().addFlags(C8415j.INVALID_ID);
                window = getWindow();
                C25052j.m39375o(window, "window");
                window.setStatusBarColor(0);
            } else {
                getWindow().addFlags(67108864);
            }
            getWindow().setFlags(134217728, 134217728);
        }
        AppMethodBeat.m2505o(110241);
    }
}
