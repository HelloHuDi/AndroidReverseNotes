package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u00017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020!J\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0014J\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J\u001e\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u0017J\u000e\u00105\u001a\u00020\u00172\u0006\u0010&\u001a\u00020!J\u000e\u00106\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downX", "", "downY", "isLongPressed", "", "isTouchEnd", "isTouchMoved", "longClickEnable", "getLongClickEnable", "()Z", "setLongClickEnable", "(Z)V", "longPressRunnable", "Ljava/lang/Runnable;", "longPressedTimeout", "", "onClick", "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "scrollConsumers", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "Lkotlin/collections/HashSet;", "scrollType", "touchSlop", "addScrollConsumer", "consumer", "cancelLongPress", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getScrollType", "onNestedPreFling", "velocityX", "velocityY", "onNestedPreScroll", "scrollX", "scrollY", "consumed", "", "onStopNestedScroll", "removeScrollConsumer", "trackTouchEvent", "Companion", "plugin-story_release"})
public final class f {
    private static String TAG = "MicroMsg.GalleryScrollHelper";
    public static final a soh = new a();
    private float hke;
    private float hkf;
    private final int nfE;
    final Runnable oBn = new b(this);
    private final int snZ;
    private boolean soa;
    private boolean sob;
    private boolean soc;
    public int sod;
    a.f.a.a<Boolean> soe;
    boolean sof = true;
    private final HashSet<e> sog = new HashSet();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper$Companion;", "", "()V", "ScrollAll", "", "ScrollDown", "ScrollLeft", "ScrollNone", "ScrollRight", "ScrollUp", "TAG", "", "scrollHorizontal", "", "type", "scrollVertical", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ f soi;

        b(f fVar) {
            this.soi = fVar;
        }

        public final void run() {
            AppMethodBeat.i(110732);
            ab.d(f.TAG, "MSG_STORY_LONG_PRESS_CHECK");
            if (this.soi.sof) {
                a.f.a.a aVar = this.soi.soe;
                if (aVar == null) {
                    AppMethodBeat.o(110732);
                    return;
                } else if (((Boolean) aVar.invoke()).booleanValue()) {
                    this.soi.soa = true;
                }
            }
            AppMethodBeat.o(110732);
        }
    }

    public f(Context context) {
        j.p(context, "context");
        AppMethodBeat.i(110736);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.snZ = ViewConfiguration.getLongPressTimeout() + 100;
        j.o(viewConfiguration, "config");
        this.nfE = viewConfiguration.getScaledTouchSlop();
        AppMethodBeat.o(110736);
    }

    static {
        AppMethodBeat.i(110737);
        AppMethodBeat.o(110737);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(110733);
        j.p(eVar, "consumer");
        this.sog.add(eVar);
        AppMethodBeat.o(110733);
    }

    public final void J(MotionEvent motionEvent) {
        int i = 1;
        boolean z = false;
        AppMethodBeat.i(110734);
        j.p(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.hke = motionEvent.getX();
                this.hkf = motionEvent.getY();
                this.soa = false;
                this.sob = false;
                this.soc = false;
                this.sod = 0;
                al.n(this.oBn, (long) this.snZ);
                ab.d(TAG, "downX:" + this.hke + "  downY:" + this.hkf);
                AppMethodBeat.o(110734);
                return;
            case 1:
            case 3:
                al.af(this.oBn);
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
                    al.af(this.oBn);
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
                ab.d(TAG, "scrollType " + this.sod + " move: " + f + ", " + f2);
                AppMethodBeat.o(110734);
                return;
        }
        AppMethodBeat.o(110734);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z = false;
        AppMethodBeat.i(110735);
        j.p(motionEvent, "event");
        ab.d(TAG, "dispatchTouchEvent " + motionEvent.getAction() + ", " + motionEvent.getX() + ' ' + motionEvent.getY());
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
                ab.d(TAG, "scrollType " + this.sod);
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
                e eVar = (e) it.next();
                if (!z) {
                    boolean z2;
                    if (this.sob && (eVar.cCD() & i) == 0) {
                        z2 = z;
                    } else {
                        z2 = eVar.a(motionEvent, this.sob, i) | z;
                    }
                    z = z2;
                }
            }
        }
        AppMethodBeat.o(110735);
        return z;
    }
}
