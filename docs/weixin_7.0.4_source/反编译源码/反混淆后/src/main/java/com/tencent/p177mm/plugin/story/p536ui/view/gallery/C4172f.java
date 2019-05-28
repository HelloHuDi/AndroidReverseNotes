package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.HashSet;
import java.util.Iterator;
import p000a.C0220l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u00017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020!J\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0014J\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J\u001e\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u0017J\u000e\u00105\u001a\u00020\u00172\u0006\u0010&\u001a\u00020!J\u000e\u00106\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "onNestedPreFling", "velocityX", "velocityY", "onNestedPreScroll", "scrollX", "scrollY", "consumed", "", "onStopNestedScroll", "removeScrollConsumer", "trackTouchEvent", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.f */
public final class C4172f {
    private static String TAG = "MicroMsg.GalleryScrollHelper";
    public static final C4173a soh = new C4173a();
    private float hke;
    private float hkf;
    private final int nfE;
    final Runnable oBn = new C4174b(this);
    private final int snZ;
    private boolean soa;
    private boolean sob;
    private boolean soc;
    public int sod;
    C31214a<Boolean> soe;
    boolean sof = true;
    private final HashSet<C35248e> sog = new HashSet();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper$Companion;", "", "()V", "ScrollAll", "", "ScrollDown", "ScrollLeft", "ScrollNone", "ScrollRight", "ScrollUp", "TAG", "", "scrollHorizontal", "", "type", "scrollVertical", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.f$a */
    public static final class C4173a {
        private C4173a() {
        }

        public /* synthetic */ C4173a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.f$b */
    static final class C4174b implements Runnable {
        final /* synthetic */ C4172f soi;

        C4174b(C4172f c4172f) {
            this.soi = c4172f;
        }

        public final void run() {
            AppMethodBeat.m2504i(110732);
            C4990ab.m7410d(C4172f.TAG, "MSG_STORY_LONG_PRESS_CHECK");
            if (this.soi.sof) {
                C31214a c31214a = this.soi.soe;
                if (c31214a == null) {
                    AppMethodBeat.m2505o(110732);
                    return;
                } else if (((Boolean) c31214a.invoke()).booleanValue()) {
                    this.soi.soa = true;
                }
            }
            AppMethodBeat.m2505o(110732);
        }
    }

    public C4172f(Context context) {
        C25052j.m39376p(context, "context");
        AppMethodBeat.m2504i(110736);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.snZ = ViewConfiguration.getLongPressTimeout() + 100;
        C25052j.m39375o(viewConfiguration, "config");
        this.nfE = viewConfiguration.getScaledTouchSlop();
        AppMethodBeat.m2505o(110736);
    }

    static {
        AppMethodBeat.m2504i(110737);
        AppMethodBeat.m2505o(110737);
    }

    /* renamed from: a */
    public final void mo9092a(C35248e c35248e) {
        AppMethodBeat.m2504i(110733);
        C25052j.m39376p(c35248e, "consumer");
        this.sog.add(c35248e);
        AppMethodBeat.m2505o(110733);
    }

    /* renamed from: J */
    public final void mo9091J(MotionEvent motionEvent) {
        int i = 1;
        boolean z = false;
        AppMethodBeat.m2504i(110734);
        C25052j.m39376p(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.hke = motionEvent.getX();
                this.hkf = motionEvent.getY();
                this.soa = false;
                this.sob = false;
                this.soc = false;
                this.sod = 0;
                C5004al.m7442n(this.oBn, (long) this.snZ);
                C4990ab.m7410d(TAG, "downX:" + this.hke + "  downY:" + this.hkf);
                AppMethodBeat.m2505o(110734);
                return;
            case 1:
            case 3:
                C5004al.m7439af(this.oBn);
                this.sod = 0;
                this.soc = true;
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.hke;
                float f2 = y - this.hkf;
                if (!this.sob) {
                    if (Math.abs(x - this.hke) > ((float) this.nfE) || Math.abs(y - this.hkf) > ((float) this.nfE)) {
                        z = true;
                    }
                    this.sob = z;
                }
                if (this.sob) {
                    C5004al.m7439af(this.oBn);
                    if (this.sod == 0) {
                        if (Math.abs(f2) > Math.abs(f)) {
                            if (f2 >= 0.0f) {
                                i = 2;
                            }
                        } else if (f < 0.0f) {
                            i = 4;
                        } else {
                            i = 8;
                        }
                        this.sod = i;
                    }
                }
                C4990ab.m7410d(TAG, "scrollType " + this.sod + " move: " + f + ", " + f2);
                AppMethodBeat.m2505o(110734);
                return;
        }
        AppMethodBeat.m2505o(110734);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z = false;
        AppMethodBeat.m2504i(110735);
        C25052j.m39376p(motionEvent, "event");
        C4990ab.m7410d(TAG, "dispatchTouchEvent " + motionEvent.getAction() + ", " + motionEvent.getX() + ' ' + motionEvent.getY());
        int i2 = this.sod;
        Object obj;
        switch (motionEvent.getActionMasked()) {
            case 1:
            case 3:
                i = 15;
                int obj2 = 1;
                break;
            case 2:
                Object obj3;
                if (this.soc) {
                    obj3 = null;
                } else {
                    i2 = 1;
                }
                i = this.sod;
                C4990ab.m7410d(TAG, "scrollType " + this.sod);
                obj2 = obj3;
                break;
            default:
                i = i2;
                obj2 = 1;
                break;
        }
        if (this.soa) {
            z = true;
        }
        if (!(z || obj2 == null)) {
            Iterator it = this.sog.iterator();
            while (it.hasNext()) {
                C35248e c35248e = (C35248e) it.next();
                if (!z) {
                    boolean z2;
                    if (this.sob && (c35248e.cCD() & i) == 0) {
                        z2 = z;
                    } else {
                        z2 = c35248e.mo9099a(motionEvent, this.sob, i) | z;
                    }
                    z = z2;
                }
            }
        }
        AppMethodBeat.m2505o(110735);
        return z;
    }
}
