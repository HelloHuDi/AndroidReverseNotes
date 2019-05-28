package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.OrientationEventListener;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;
import java.lang.ref.WeakReference;

@l(dWo = {1, 1, 13}, dWp = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0011\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0019R(\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R(\u0010\u0013\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "", "ctx", "Landroid/content/Context;", "video", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "context", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "currentDisplayRotation", "", "orientationChangeListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1;", "videoView", "getVideoView", "setVideoView", "checkContext", "", "enable", "", "release", "Companion", "plugin-brandservice_release"})
public final class b {
    public static final a jYs = new a();
    private int fbY;
    WeakReference<Context> hxY;
    WeakReference<MPVideoView> jYq;
    public b jYr;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-brandservice_release"})
    public static final class b extends OrientationEventListener {
        final /* synthetic */ b jYt;

        b(Context context, int i) {
            this.jYt = context;
            super(i, 3);
        }

        public final void onOrientationChanged(int i) {
            AppMethodBeat.i(15312);
            if (!b.a(this.jYt) || this.jYt.jYq.get() == null) {
                AppMethodBeat.o(15312);
                return;
            }
            int i2;
            if (80 <= i && 100 >= i) {
                i2 = -90;
            } else if (d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW <= i && d.MIC_PTU_TRANS_XINXIAN >= i) {
                i2 = 90;
            } else if (ErrorCode.NEEDDOWNLOAD_TRUE <= i && FacebookRequestErrorClassification.EC_INVALID_TOKEN >= i) {
                i2 = 180;
            } else if (i < 10 || i > 350) {
                i2 = 0;
            } else {
                AppMethodBeat.o(15312);
                return;
            }
            if (this.jYt.fbY == i2) {
                AppMethodBeat.o(15312);
                return;
            }
            ab.v("MicroMsg.BizVideoOrientationHelper", "last rotation :" + this.jYt.fbY + " ,current rotation:" + i2);
            this.jYt.fbY = i2;
            Object obj = this.jYt.jYq.get();
            v vVar;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
                AppMethodBeat.o(15312);
                throw vVar;
            } else if (bo.isNullOrNil(((MPVideoView) obj).getVideoPath())) {
                AppMethodBeat.o(15312);
            } else {
                obj = this.jYt.jYq.get();
                MPVideoView mPVideoView;
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
                    AppMethodBeat.o(15312);
                    throw vVar;
                } else if (!((MPVideoView) obj).aFb()) {
                    if (i2 == 90 || i2 == -90) {
                        mPVideoView = (MPVideoView) this.jYt.jYq.get();
                        if (mPVideoView != null) {
                            mPVideoView.setFullScreenDirection(i2);
                        }
                        mPVideoView = (MPVideoView) this.jYt.jYq.get();
                        if (mPVideoView != null) {
                            mPVideoView.j(true, i2);
                            AppMethodBeat.o(15312);
                            return;
                        }
                    }
                    AppMethodBeat.o(15312);
                } else if (i2 == 0) {
                    mPVideoView = (MPVideoView) this.jYt.jYq.get();
                    if (mPVideoView != null) {
                        mPVideoView.j(false, 0);
                        AppMethodBeat.o(15312);
                        return;
                    }
                    AppMethodBeat.o(15312);
                } else if (i2 == 90) {
                    mPVideoView = (MPVideoView) this.jYt.jYq.get();
                    if (mPVideoView != null) {
                        mPVideoView.setFullScreenDirection(90);
                    }
                    obj = this.jYt.hxY.get();
                    if (obj == null) {
                        vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(15312);
                        throw vVar;
                    }
                    ((MMActivity) obj).setRequestedOrientation(0);
                    AppMethodBeat.o(15312);
                } else {
                    if (i2 == -90) {
                        mPVideoView = (MPVideoView) this.jYt.jYq.get();
                        if (mPVideoView != null) {
                            mPVideoView.setFullScreenDirection(-90);
                        }
                        obj = this.jYt.hxY.get();
                        if (obj == null) {
                            vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                            AppMethodBeat.o(15312);
                            throw vVar;
                        }
                        ((MMActivity) obj).setRequestedOrientation(8);
                    }
                    AppMethodBeat.o(15312);
                }
            }
        }
    }

    static {
        AppMethodBeat.i(15316);
        AppMethodBeat.o(15316);
    }

    public b(Context context, MPVideoView mPVideoView) {
        j.p(context, "ctx");
        j.p(mPVideoView, "video");
        AppMethodBeat.i(15315);
        this.hxY = new WeakReference(context);
        this.jYq = new WeakReference(mPVideoView);
        Context context2 = (Context) this.hxY.get();
        this.jYr = new b(this, context2 != null ? context2.getApplicationContext() : null);
        AppMethodBeat.o(15315);
    }

    public static final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(15317);
        boolean Wz = bVar.Wz();
        AppMethodBeat.o(15317);
        return Wz;
    }

    public final void fB(boolean z) {
        AppMethodBeat.i(15313);
        ab.i("MicroMsg.BizVideoOrientationHelper", "enable :".concat(String.valueOf(z)));
        if (!Wz()) {
            AppMethodBeat.o(15313);
        } else if (z) {
            this.jYr.enable();
            AppMethodBeat.o(15313);
        } else {
            this.jYr.disable();
            Object obj = this.hxY.get();
            if (obj == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(15313);
                throw vVar;
            }
            ((MMActivity) obj).setRequestedOrientation(1);
            this.fbY = 0;
            AppMethodBeat.o(15313);
        }
    }

    private final boolean Wz() {
        AppMethodBeat.i(15314);
        if (this.hxY.get() == null) {
            AppMethodBeat.o(15314);
            return false;
        }
        AppMethodBeat.o(15314);
        return true;
    }
}
