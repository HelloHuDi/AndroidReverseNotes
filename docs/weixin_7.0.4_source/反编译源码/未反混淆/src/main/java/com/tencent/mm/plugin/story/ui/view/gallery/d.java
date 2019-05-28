package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "()V", "currScrollType", "", "downX", "", "downY", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getGalleryView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "setGalleryView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;)V", "totalScrollY", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "showExitHint", "", "Companion", "plugin-story_release"})
public final class d extends e {
    private static final String TAG = TAG;
    public static final a snS = new a();
    private float hke;
    private float hkf;
    private int rCb;
    l seu;
    private int snR;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(110725);
        AppMethodBeat.o(110725);
    }

    public final boolean a(MotionEvent motionEvent, boolean z, int i) {
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(110724);
        j.p(motionEvent, "event");
        l lVar;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.hke = motionEvent.getX();
                this.hkf = motionEvent.getY();
                break;
            case 1:
                if (this.rCb > 0 && this.snR == 1) {
                    lVar = this.seu;
                    if (lVar != null) {
                        ViewPropertyAnimator animate = lVar.animate();
                        if (animate != null) {
                            animate = animate.translationY(0.0f);
                            if (animate != null) {
                                animate.start();
                            }
                        }
                    }
                    this.snR = 0;
                    Context context = ah.getContext();
                    Object systemService = context.getSystemService("vibrator");
                    if (!(systemService instanceof Vibrator)) {
                        systemService = null;
                    }
                    Vibrator vibrator = (Vibrator) systemService;
                    if (vibrator != null) {
                        vibrator.vibrate(10);
                    }
                    h.bN(context, context.getString(R.string.esj));
                }
                this.rCb = 0;
                break;
            case 2:
                if (z) {
                    this.snR = i;
                    if (i != 1) {
                        z2 = false;
                    }
                    float y = motionEvent.getY() - this.hkf;
                    if (y > 0.0f) {
                        z3 = z2;
                        break;
                    }
                    l lVar2 = this.seu;
                    if (lVar2 == null) {
                        z3 = z2;
                        break;
                    }
                    this.rCb = -((int) y);
                    lVar2.animate().cancel();
                    lVar2.setTranslationY(y / 2.0f);
                    z3 = z2;
                    break;
                }
                break;
            case 3:
                ab.i(TAG, "LogStory: touch cancel");
                this.snR = 0;
                lVar = this.seu;
                if (lVar != null) {
                    lVar.setTranslationY(0.0f);
                }
                this.rCb = 0;
                break;
        }
        AppMethodBeat.o(110724);
        return z3;
    }

    public final int cCD() {
        return 1;
    }
}
