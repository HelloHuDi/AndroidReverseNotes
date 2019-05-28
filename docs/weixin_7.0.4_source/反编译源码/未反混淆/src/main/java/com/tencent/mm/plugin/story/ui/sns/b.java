package com.tencent.mm.plugin.story.ui.sns;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.i;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.ui.view.gallery.e;
import com.tencent.mm.plugin.story.ui.view.gallery.f;
import com.tencent.mm.plugin.story.ui.view.gallery.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.ttpic.util.ActUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\"\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class b extends i {
    private static final String TAG = TAG;
    public static final a shk = new a();
    private Context mContext;
    private f shf;
    private final b shg = new b(this);
    private boolean shh;
    private boolean shi;
    private boolean shj;
    private View targetView;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    public static final class b implements com.tencent.mm.plugin.story.ui.view.gallery.l.b {
        final /* synthetic */ b shl;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ b shm;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.story.ui.sns.b$b$a$1 */
            static final class AnonymousClass1 implements Runnable {
                final /* synthetic */ a shn;

                AnonymousClass1(a aVar) {
                    this.shn = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(110235);
                    if (this.shn.shm.shl.isShowing()) {
                        this.shn.shm.shl.cancel();
                    }
                    AppMethodBeat.o(110235);
                }
            }

            a(b bVar) {
                this.shm = bVar;
            }

            public final void run() {
                AppMethodBeat.i(110236);
                new ak().post(new AnonymousClass1(this));
                AppMethodBeat.o(110236);
            }
        }

        b(b bVar) {
            this.shl = bVar;
        }

        public final void bc(float f) {
        }

        public final void cCg() {
            long j = 0;
            AppMethodBeat.i(110237);
            View a = this.shl.targetView;
            if (a != null) {
                a.setEnabled(false);
                long height = (long) (((((float) a.getHeight()) - a.getTranslationY()) / ((float) a.getHeight())) * 300.0f);
                if (height >= 0) {
                    j = height;
                }
                a.animate().translationY((float) a.getHeight()).setDuration(j).withEndAction(new a(this)).start();
                AppMethodBeat.o(110237);
                return;
            }
            AppMethodBeat.o(110237);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ b shl;

        c(b bVar) {
            this.shl = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110238);
            if (this.shl.isShowing()) {
                this.shl.cancel();
            }
            AppMethodBeat.o(110238);
        }
    }

    public b(Context context) {
        j.p(context, "mContext");
        super(context, R.style.h4);
        AppMethodBeat.i(110244);
        this.mContext = context;
        fA();
        Context context2 = getContext();
        j.o(context2, "context");
        this.shf = new f(context2);
        AppMethodBeat.o(110244);
    }

    static {
        AppMethodBeat.i(110245);
        AppMethodBeat.o(110245);
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(110239);
        Resources resources = this.mContext.getResources();
        j.o(resources, "mContext.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(110239);
            return true;
        }
        AppMethodBeat.o(110239);
        return false;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(110240);
        super.onCreate(bundle);
        getWindow().setDimAmount(0.0f);
        AppMethodBeat.o(110240);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(110242);
        j.p(motionEvent, "ev");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.shj = false;
                break;
            case 1:
            case 3:
                break;
        }
        this.shi = false;
        this.shf.J(motionEvent);
        int i = this.shf.sod;
        if (!(i == 1 || i == 2)) {
            if (!this.shi && !this.shh) {
                z = this.shf.dispatchTouchEvent(motionEvent);
            } else if (!this.shj) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                j.o(obtain, "cancelEvent");
                obtain.setAction(3);
                this.shf.dispatchTouchEvent(obtain);
                obtain.recycle();
                this.shj = true;
            }
        }
        if (this.shi || z) {
            if (!this.shj) {
                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                j.o(obtain2, "cancelEvent");
                obtain2.setAction(3);
                super.dispatchTouchEvent(obtain2);
                obtain2.recycle();
                this.shj = true;
            }
            AppMethodBeat.o(110242);
            return true;
        }
        z = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(110242);
        return z;
    }

    public final void cancel() {
        AppMethodBeat.i(110243);
        if (this.targetView instanceof a) {
            View view = this.targetView;
            if (view == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
                AppMethodBeat.o(110243);
                throw vVar;
            }
            ((a) view).finish();
        }
        super.cancel();
        AppMethodBeat.o(110243);
    }

    public final void setContentView(View view) {
        AppMethodBeat.i(110241);
        j.p(view, "view");
        Window window = getWindow();
        if (isLandscape()) {
            if (window == null) {
                j.dWJ();
            }
            window.setGravity(5);
            window.setWindowAnimations(R.style.qp);
        } else {
            if (window == null) {
                j.dWJ();
            }
            window.setGravity(80);
            window.setWindowAnimations(R.style.fc);
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
        view.findViewById(R.id.b9h).setOnClickListener(new c(this));
        super.setContentView(view);
        this.targetView = view;
        this.shf.a((e) new h(view, this.shg));
        window = getWindow();
        if (window == null) {
            j.dWJ();
        }
        window.setLayout(-1, -1);
        if (getWindow() != null) {
            if (VERSION.SDK_INT >= 21) {
                window = getWindow();
                j.o(window, "window");
                View decorView = window.getDecorView();
                j.o(decorView, "window.decorView");
                decorView.setSystemUiVisibility(ActUtil.HEIGHT);
                getWindow().addFlags(android.support.v4.widget.j.INVALID_ID);
                window = getWindow();
                j.o(window, "window");
                window.setStatusBarColor(0);
            } else {
                getWindow().addFlags(67108864);
            }
            getWindow().setFlags(134217728, 134217728);
        }
        AppMethodBeat.o(110241);
    }
}
