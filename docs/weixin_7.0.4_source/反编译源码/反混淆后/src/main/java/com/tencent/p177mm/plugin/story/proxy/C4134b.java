package com.tencent.p177mm.plugin.story.proxy;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C46878am;
import com.tencent.p177mm.p230g.p232b.p233a.C9502ar;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.story.api.C29268i;
import com.tencent.p177mm.plugin.story.api.C29268i.C29267a;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39867d;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39867d.C39868b;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39867d.C39868b.C13741a;
import com.tencent.p177mm.plugin.story.p529a.C7135b;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C29293i;
import com.tencent.p177mm.plugin.story.p531g.C29293i.C29294a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0010*\u0001\u001d\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020#H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u00100\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0006H\u0016J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020/H\u0002J\b\u0010:\u001a\u00020/H\u0002J\u0012\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010=\u001a\u00020/2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020#H\u0016J\u001a\u0010@\u001a\u00020/2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010B\u001a\u00020/H\u0016J\b\u0010C\u001a\u00020/H\u0002J\b\u0010D\u001a\u00020/H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.proxy.b */
public final class C4134b implements C29268i {
    private static final String TAG = TAG;
    public static final C4138a saS = new C4138a();
    private final Context context;
    private OnClickListener lDG;
    private int pageType = -1;
    private int saA;
    private Drawable saB;
    private Drawable saC;
    private int saD;
    private int saE;
    private int saF;
    private float saG;
    private float saH;
    private float saI;
    private Paint saJ;
    private View saK;
    private final C7135b saL = new C7135b();
    private int saM = -1;
    private WeakReference<Context> saN;
    private final int saO;
    private final C4135b saP = new C4135b(this);
    private C29267a saQ;
    private final OnClickListener saR = new C4136c(this);
    private boolean say;
    private int saz;
    private String userName;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.b$b */
    public static final class C4135b extends C7306ak {
        final /* synthetic */ C4134b saT;

        C4135b(C4134b c4134b) {
            this.saT = c4134b;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(109724);
            if ((message != null ? message.obj : null) != null && (message.obj instanceof View) && message.what == this.saT.saO) {
                OnClickListener b = this.saT.lDG;
                if (b != null) {
                    Object obj = message.obj;
                    if (obj == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.m2505o(109724);
                        throw c44941v;
                    }
                    b.onClick((View) obj);
                    AppMethodBeat.m2505o(109724);
                    return;
                }
            }
            AppMethodBeat.m2505o(109724);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.b$c */
    public static final class C4136c implements OnClickListener {
        private long qlT;
        final /* synthetic */ C4134b saT;

        C4136c(C4134b c4134b) {
            this.saT = c4134b;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(109725);
            C25052j.m39376p(view, "view");
            long anU = C5046bo.anU();
            this.saT.saP.removeMessages(this.saT.saO);
            this.saT.saP.sendMessageDelayed(this.saT.saP.obtainMessage(this.saT.saO, view), (long) ViewConfiguration.getDoubleTapTimeout());
            C4990ab.m7411d(C4134b.TAG, "onClick lastClick=%s now=%s", Long.valueOf(this.qlT), Long.valueOf(anU));
            if (anU - this.qlT < ((long) ViewConfiguration.getDoubleTapTimeout())) {
                this.saT.saP.removeMessages(this.saT.saO);
                C4134b.m6469d(this.saT);
                AppMethodBeat.m2505o(109725);
                return;
            }
            this.qlT = anU;
            AppMethodBeat.m2505o(109725);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.b$d */
    static final class C4137d implements Runnable {
        final /* synthetic */ C4134b saT;

        C4137d(C4134b c4134b) {
            this.saT = c4134b;
        }

        public final void run() {
            AppMethodBeat.m2504i(109726);
            C4134b.czL();
            AppMethodBeat.m2505o(109726);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.b$a */
    public static final class C4138a {
        private C4138a() {
        }

        public /* synthetic */ C4138a(byte b) {
            this();
        }
    }

    public C4134b(Context context) {
        C25052j.m39376p(context, "context");
        AppMethodBeat.m2504i(109733);
        this.context = context;
        AppMethodBeat.m2505o(109733);
    }

    /* renamed from: aR */
    public final void mo9014aR(View view) {
        AppMethodBeat.m2504i(109727);
        C25052j.m39376p(view, "host");
        this.saK = view;
        this.saz = C1338a.fromDPToPix(this.context, 2);
        this.saA = C1338a.fromDPToPix(this.context, 2);
        this.saI = (float) C1338a.fromDPToPix(this.context, 6);
        view.setOnClickListener(this.saR);
        this.saF = view.getResources().getDimensionPixelSize(C25738R.dimen.f10003n5);
        this.saJ = new Paint();
        Paint paint = this.saJ;
        if (paint != null) {
            paint.setAntiAlias(true);
        }
        paint = this.saJ;
        if (paint != null) {
            paint.setAlpha(0);
        }
        Paint paint2 = this.saJ;
        if (paint2 != null) {
            paint2.setXfermode(new PorterDuffXfermode(Mode.SRC));
        }
        Context context = C4996ah.getContext();
        C25052j.m39375o(context, "MMApplicationContext.getContext()");
        this.saM = context.getResources().getColor(C25738R.color.a2_);
        AppMethodBeat.m2505o(109727);
    }

    /* renamed from: a */
    public final void mo9013a(Canvas canvas, boolean z, int i) {
        AppMethodBeat.m2504i(109728);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        if (C46270n.isShowStoryCheck()) {
            View view = this.saK;
            if (view != null) {
                int width = (view.getWidth() - this.saF) / 2;
                if (view.getWidth() > this.saF) {
                    this.saH = (float) (this.saF + width);
                    this.saG = (float) width;
                }
                if (this.say) {
                    Drawable ls;
                    Paint paint = this.saJ;
                    if (paint != null) {
                        paint.setColor(i);
                    }
                    paint = this.saJ;
                    if (paint != null) {
                        canvas.drawCircle(((float) view.getWidth()) - this.saI, this.saI, this.saI, paint);
                    }
                    C1677a M;
                    if (z) {
                        if (this.saB == null) {
                            M = C1720g.m3530M(C35168e.class);
                            C25052j.m39375o(M, "plugin(IPluginStory::class.java)");
                            ls = ((C35168e) M).getStoryUIFactory().mo69264ls(true);
                            this.saB = ls;
                            C25052j.m39375o(ls, "drawable");
                            this.saE = ls.getBounds().right;
                            this.saD = ls.getBounds().bottom;
                        }
                        ls = this.saB;
                    } else {
                        if (this.saC == null) {
                            M = C1720g.m3530M(C35168e.class);
                            C25052j.m39375o(M, "plugin(IPluginStory::class.java)");
                            ls = ((C35168e) M).getStoryUIFactory().mo69264ls(false);
                            this.saC = ls;
                            C25052j.m39375o(ls, "drawable");
                            this.saE = ls.getBounds().right;
                            this.saD = ls.getBounds().bottom;
                        }
                        ls = this.saC;
                    }
                    canvas.save();
                    canvas.translate((float) ((view.getWidth() - this.saE) - this.saz), (float) this.saA);
                    if (ls != null) {
                        ls.draw(canvas);
                    }
                    canvas.restore();
                }
                AppMethodBeat.m2505o(109728);
                return;
            }
            AppMethodBeat.m2505o(109728);
            return;
        }
        AppMethodBeat.m2505o(109728);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        if (onClickListener != this.saR) {
            this.lDG = onClickListener;
        }
    }

    public final void setShowStoryHint(boolean z) {
        AppMethodBeat.m2504i(109729);
        if (C39732a.m67945Xv(this.userName)) {
            z = false;
        }
        if (this.say != z) {
            this.say = z;
            View view = this.saK;
            if (view != null) {
                view.invalidate();
                AppMethodBeat.m2505o(109729);
                return;
            }
        }
        AppMethodBeat.m2505o(109729);
    }

    /* renamed from: dk */
    public final void mo9016dk(String str, int i) {
        this.userName = str;
        this.pageType = i;
    }

    /* renamed from: IF */
    private final void m6465IF() {
        AppMethodBeat.m2504i(109730);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20744bH(this.say ? 1 : 0);
        c22212h = C22212h.scu;
        C9502ar cAs = C22212h.cAs();
        C29294a c29294a = C29293i.scv;
        cAs.mo20743bG(C29294a.m46511Fb(this.pageType));
        AppMethodBeat.m2505o(109730);
    }

    private void czK() {
        AppMethodBeat.m2504i(109731);
        if (this.saK != null) {
            AnimatorSet animatorSet = this.saL.rQu;
            if (animatorSet == null) {
                C25052j.dWJ();
            }
            animatorSet.cancel();
            C7135b c7135b = this.saL;
            View view = this.saK;
            if (view == null) {
                C25052j.dWJ();
            }
            c7135b.mo8978ec(view);
            C7135b c7135b2 = this.saL;
            animatorSet = c7135b2.rQu;
            if (animatorSet == null) {
                C25052j.dWJ();
            }
            Iterator it = animatorSet.getChildAnimations().iterator();
            while (it.hasNext()) {
                Animator animator = (Animator) it.next();
                if (animator instanceof ValueAnimator) {
                    ((ValueAnimator) animator).setRepeatCount(c7135b2.rQv);
                    ((ValueAnimator) animator).setRepeatMode(c7135b2.rQw);
                }
            }
            animatorSet = c7135b2.rQu;
            if (animatorSet == null) {
                C25052j.dWJ();
            }
            animatorSet.setDuration(c7135b2.mDuration);
            animatorSet = c7135b2.rQu;
            if (animatorSet == null) {
                C25052j.dWJ();
            }
            animatorSet.start();
            C5004al.m7442n(new C4137d(this), 150);
        }
        AppMethodBeat.m2505o(109731);
    }

    public final OnClickListener cwV() {
        return this.saR;
    }

    public final void setOnDoubleClickListener(C29267a c29267a) {
        this.saQ = c29267a;
    }

    public final void setWeakContext(Context context) {
        AppMethodBeat.m2504i(109732);
        C25052j.m39376p(context, "context");
        this.saN = new WeakReference(context);
        AppMethodBeat.m2505o(109732);
    }

    static {
        AppMethodBeat.m2504i(109734);
        AppMethodBeat.m2505o(109734);
    }

    public static final /* synthetic */ void czL() {
        AppMethodBeat.m2504i(109735);
        Object systemService = C4996ah.getContext().getSystemService("vibrator");
        if (systemService instanceof Vibrator) {
            ((Vibrator) systemService).vibrate(10);
        }
        AppMethodBeat.m2505o(109735);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static final /* synthetic */ void m6469d(C4134b c4134b) {
        AppMethodBeat.m2504i(109736);
        if (C39732a.m67945Xv(c4134b.userName)) {
            c4134b.czK();
            AppMethodBeat.m2505o(109736);
            return;
        }
        boolean ed;
        C22212h c22212h = C22212h.scu;
        C22212h.cAA().mo76054bl((long) C5023at.m7472gC(c4134b.context));
        c22212h = C22212h.scu;
        C46878am cAA = C22212h.cAA();
        C29294a c29294a = C29293i.scv;
        cAA.mo76055bm(C29294a.m46511Fb(c4134b.pageType));
        if (c4134b.say) {
            c22212h = C22212h.scu;
            C22212h.cAA().mo76052Fx();
        }
        if (c4134b.saQ != null) {
            C29267a c29267a = c4134b.saQ;
            if (c29267a != null) {
                ed = c29267a.mo47442ed(c4134b.saK);
            }
            ed = false;
        } else {
            if (C39732a.m67944Xu(c4134b.userName)) {
                c4134b.m6465IF();
                WeakReference weakReference = c4134b.saN;
                Context context = weakReference != null ? (Context) weakReference.get() : null;
                if (context != null) {
                    C46270n.m86706aT(context, c4134b.userName);
                } else {
                    C46270n.m86706aT(c4134b.context, c4134b.userName);
                }
                ed = true;
            }
            ed = false;
        }
        if (!ed) {
            Object obj;
            C39867d c39867d = C39867d.rRo;
            if (C39867d.aac(c4134b.userName)) {
                C13741a c13741a = C39868b.rRy;
                if (C25035t.m39327a((Iterable) C39867d.rRo.mo53288Uw(), (Object) (C39868b) C39868b.map.get(Integer.valueOf(c4134b.pageType)))) {
                    obj = 1;
                    if (obj != null) {
                        c4134b.czK();
                    }
                }
            }
            obj = null;
            if (obj != null) {
            }
        }
        if (ed) {
            c22212h = C22212h.scu;
            C22212h.cAA().mo76053Fy();
        }
        c22212h = C22212h.scu;
        C22212h.cAB();
        if (ed) {
            c4134b.m6465IF();
        }
        AppMethodBeat.m2505o(109736);
    }
}
