package com.tencent.mm.plugin.story.proxy;

import a.a.t;
import a.f.b.j;
import a.l;
import a.v;
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
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.am;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0010*\u0001\u001d\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020#H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u00100\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0006H\u0016J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020/H\u0002J\b\u0010:\u001a\u00020/H\u0002J\u0012\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010=\u001a\u00020/2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020#H\u0016J\u001a\u0010@\u001a\u00020/2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010B\u001a\u00020/H\u0016J\b\u0010C\u001a\u00020/H\u0002J\b\u0010D\u001a\u00020/H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", "init", "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", "listener", "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b implements i {
    private static final String TAG = TAG;
    public static final a saS = new a();
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
    private final com.tencent.mm.plugin.story.a.b saL = new com.tencent.mm.plugin.story.a.b();
    private int saM = -1;
    private WeakReference<Context> saN;
    private final int saO;
    private final b saP = new b(this);
    private com.tencent.mm.plugin.story.api.i.a saQ;
    private final OnClickListener saR = new c(this);
    private boolean say;
    private int saz;
    private String userName;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    public static final class b extends ak {
        final /* synthetic */ b saT;

        b(b bVar) {
            this.saT = bVar;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(109724);
            if ((message != null ? message.obj : null) != null && (message.obj instanceof View) && message.what == this.saT.saO) {
                OnClickListener b = this.saT.lDG;
                if (b != null) {
                    Object obj = message.obj;
                    if (obj == null) {
                        v vVar = new v("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(109724);
                        throw vVar;
                    }
                    b.onClick((View) obj);
                    AppMethodBeat.o(109724);
                    return;
                }
            }
            AppMethodBeat.o(109724);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
    public static final class c implements OnClickListener {
        private long qlT;
        final /* synthetic */ b saT;

        c(b bVar) {
            this.saT = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(109725);
            j.p(view, "view");
            long anU = bo.anU();
            this.saT.saP.removeMessages(this.saT.saO);
            this.saT.saP.sendMessageDelayed(this.saT.saP.obtainMessage(this.saT.saO, view), (long) ViewConfiguration.getDoubleTapTimeout());
            ab.d(b.TAG, "onClick lastClick=%s now=%s", Long.valueOf(this.qlT), Long.valueOf(anU));
            if (anU - this.qlT < ((long) ViewConfiguration.getDoubleTapTimeout())) {
                this.saT.saP.removeMessages(this.saT.saO);
                b.d(this.saT);
                AppMethodBeat.o(109725);
                return;
            }
            this.qlT = anU;
            AppMethodBeat.o(109725);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ b saT;

        d(b bVar) {
            this.saT = bVar;
        }

        public final void run() {
            AppMethodBeat.i(109726);
            b.czL();
            AppMethodBeat.o(109726);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public b(Context context) {
        j.p(context, "context");
        AppMethodBeat.i(109733);
        this.context = context;
        AppMethodBeat.o(109733);
    }

    public final void aR(View view) {
        AppMethodBeat.i(109727);
        j.p(view, "host");
        this.saK = view;
        this.saz = com.tencent.mm.bz.a.fromDPToPix(this.context, 2);
        this.saA = com.tencent.mm.bz.a.fromDPToPix(this.context, 2);
        this.saI = (float) com.tencent.mm.bz.a.fromDPToPix(this.context, 6);
        view.setOnClickListener(this.saR);
        this.saF = view.getResources().getDimensionPixelSize(R.dimen.n5);
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
        Context context = ah.getContext();
        j.o(context, "MMApplicationContext.getContext()");
        this.saM = context.getResources().getColor(R.color.a2_);
        AppMethodBeat.o(109727);
    }

    public final void a(Canvas canvas, boolean z, int i) {
        AppMethodBeat.i(109728);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        if (n.isShowStoryCheck()) {
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
                    com.tencent.mm.kernel.b.a M;
                    if (z) {
                        if (this.saB == null) {
                            M = g.M(e.class);
                            j.o(M, "plugin(IPluginStory::class.java)");
                            ls = ((e) M).getStoryUIFactory().ls(true);
                            this.saB = ls;
                            j.o(ls, "drawable");
                            this.saE = ls.getBounds().right;
                            this.saD = ls.getBounds().bottom;
                        }
                        ls = this.saB;
                    } else {
                        if (this.saC == null) {
                            M = g.M(e.class);
                            j.o(M, "plugin(IPluginStory::class.java)");
                            ls = ((e) M).getStoryUIFactory().ls(false);
                            this.saC = ls;
                            j.o(ls, "drawable");
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
                AppMethodBeat.o(109728);
                return;
            }
            AppMethodBeat.o(109728);
            return;
        }
        AppMethodBeat.o(109728);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        if (onClickListener != this.saR) {
            this.lDG = onClickListener;
        }
    }

    public final void setShowStoryHint(boolean z) {
        AppMethodBeat.i(109729);
        if (com.tencent.mm.plugin.sns.e.a.Xv(this.userName)) {
            z = false;
        }
        if (this.say != z) {
            this.say = z;
            View view = this.saK;
            if (view != null) {
                view.invalidate();
                AppMethodBeat.o(109729);
                return;
            }
        }
        AppMethodBeat.o(109729);
    }

    public final void dk(String str, int i) {
        this.userName = str;
        this.pageType = i;
    }

    private final void IF() {
        AppMethodBeat.i(109730);
        h hVar = h.scu;
        h.cAs().bH(this.say ? 1 : 0);
        hVar = h.scu;
        ar cAs = h.cAs();
        com.tencent.mm.plugin.story.g.i.a aVar = com.tencent.mm.plugin.story.g.i.scv;
        cAs.bG(com.tencent.mm.plugin.story.g.i.a.Fb(this.pageType));
        AppMethodBeat.o(109730);
    }

    private void czK() {
        AppMethodBeat.i(109731);
        if (this.saK != null) {
            AnimatorSet animatorSet = this.saL.rQu;
            if (animatorSet == null) {
                j.dWJ();
            }
            animatorSet.cancel();
            com.tencent.mm.plugin.story.a.b bVar = this.saL;
            View view = this.saK;
            if (view == null) {
                j.dWJ();
            }
            bVar.ec(view);
            com.tencent.mm.plugin.story.a.b bVar2 = this.saL;
            animatorSet = bVar2.rQu;
            if (animatorSet == null) {
                j.dWJ();
            }
            Iterator it = animatorSet.getChildAnimations().iterator();
            while (it.hasNext()) {
                Animator animator = (Animator) it.next();
                if (animator instanceof ValueAnimator) {
                    ((ValueAnimator) animator).setRepeatCount(bVar2.rQv);
                    ((ValueAnimator) animator).setRepeatMode(bVar2.rQw);
                }
            }
            animatorSet = bVar2.rQu;
            if (animatorSet == null) {
                j.dWJ();
            }
            animatorSet.setDuration(bVar2.mDuration);
            animatorSet = bVar2.rQu;
            if (animatorSet == null) {
                j.dWJ();
            }
            animatorSet.start();
            al.n(new d(this), 150);
        }
        AppMethodBeat.o(109731);
    }

    public final OnClickListener cwV() {
        return this.saR;
    }

    public final void setOnDoubleClickListener(com.tencent.mm.plugin.story.api.i.a aVar) {
        this.saQ = aVar;
    }

    public final void setWeakContext(Context context) {
        AppMethodBeat.i(109732);
        j.p(context, "context");
        this.saN = new WeakReference(context);
        AppMethodBeat.o(109732);
    }

    static {
        AppMethodBeat.i(109734);
        AppMethodBeat.o(109734);
    }

    public static final /* synthetic */ void czL() {
        AppMethodBeat.i(109735);
        Object systemService = ah.getContext().getSystemService("vibrator");
        if (systemService instanceof Vibrator) {
            ((Vibrator) systemService).vibrate(10);
        }
        AppMethodBeat.o(109735);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(109736);
        if (com.tencent.mm.plugin.sns.e.a.Xv(bVar.userName)) {
            bVar.czK();
            AppMethodBeat.o(109736);
            return;
        }
        boolean ed;
        h hVar = h.scu;
        h.cAA().bl((long) at.gC(bVar.context));
        hVar = h.scu;
        am cAA = h.cAA();
        com.tencent.mm.plugin.story.g.i.a aVar = com.tencent.mm.plugin.story.g.i.scv;
        cAA.bm(com.tencent.mm.plugin.story.g.i.a.Fb(bVar.pageType));
        if (bVar.say) {
            hVar = h.scu;
            h.cAA().Fx();
        }
        if (bVar.saQ != null) {
            com.tencent.mm.plugin.story.api.i.a aVar2 = bVar.saQ;
            if (aVar2 != null) {
                ed = aVar2.ed(bVar.saK);
            }
            ed = false;
        } else {
            if (com.tencent.mm.plugin.sns.e.a.Xu(bVar.userName)) {
                bVar.IF();
                WeakReference weakReference = bVar.saN;
                Context context = weakReference != null ? (Context) weakReference.get() : null;
                if (context != null) {
                    n.aT(context, bVar.userName);
                } else {
                    n.aT(bVar.context, bVar.userName);
                }
                ed = true;
            }
            ed = false;
        }
        if (!ed) {
            Object obj;
            com.tencent.mm.plugin.story.c.a.d dVar = com.tencent.mm.plugin.story.c.a.d.rRo;
            if (com.tencent.mm.plugin.story.c.a.d.aac(bVar.userName)) {
                com.tencent.mm.plugin.story.c.a.d.b.a aVar3 = com.tencent.mm.plugin.story.c.a.d.b.rRy;
                if (t.a((Iterable) com.tencent.mm.plugin.story.c.a.d.rRo.Uw(), (Object) (com.tencent.mm.plugin.story.c.a.d.b) com.tencent.mm.plugin.story.c.a.d.b.map.get(Integer.valueOf(bVar.pageType)))) {
                    obj = 1;
                    if (obj != null) {
                        bVar.czK();
                    }
                }
            }
            obj = null;
            if (obj != null) {
            }
        }
        if (ed) {
            hVar = h.scu;
            h.cAA().Fy();
        }
        hVar = h.scu;
        h.cAB();
        if (ed) {
            bVar.IF();
        }
        AppMethodBeat.o(109736);
    }
}
