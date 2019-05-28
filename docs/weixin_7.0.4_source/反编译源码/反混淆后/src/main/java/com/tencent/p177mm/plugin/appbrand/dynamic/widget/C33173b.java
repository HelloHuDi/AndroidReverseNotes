package com.tencent.p177mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p230g.p232b.p233a.C9513cr;
import com.tencent.p177mm.plugin.appbrand.canvas.p1601c.C42400a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.p177mm.plugin.appbrand.dynamic.p284b.C2126b;
import com.tencent.p177mm.plugin.appbrand.widget.p1540g.C38593a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.b */
public final class C33173b {
    private static volatile boolean eIC = false;
    private static volatile int hpA = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.b$1 */
    static class C331721 implements Runnable {
        C331721() {
        }

        public final void run() {
            AppMethodBeat.m2504i(11088);
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100284");
            if (ll == null) {
                C4990ab.m7416i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
                AppMethodBeat.m2505o(11088);
            } else if (ll.isValid()) {
                try {
                    C33173b.m54253nR(C5046bo.getInt((String) ll.dru().get("mode"), 0));
                    C4990ab.m7417i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", Integer.valueOf(C33173b.hpA));
                    AppMethodBeat.m2505o(11088);
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", Log.getStackTraceString(e));
                    AppMethodBeat.m2505o(11088);
                }
            } else {
                C33173b.m54253nR(0);
                AppMethodBeat.m2505o(11088);
            }
        }
    }

    public static void initialize() {
        AppMethodBeat.m2504i(11119);
        C26006a.post(new C331721());
        AppMethodBeat.m2505o(11119);
    }

    /* renamed from: nR */
    public static void m54253nR(int i) {
        hpA = i;
        eIC = true;
    }

    public static int aAl() {
        return hpA;
    }

    /* renamed from: bS */
    public static View m54252bS(Context context) {
        AppMethodBeat.m2504i(11120);
        if (!eIC) {
            C33173b.initialize();
        }
        C4990ab.m7411d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", Integer.valueOf(hpA));
        final View mTextureView;
        switch (hpA) {
            case 1:
                mTextureView = new MTextureView(context);
                mTextureView.getDrawContext().hcK = C2126b.azO();
                mTextureView.setDrawActionReportable(new C42400a() {
                    /* renamed from: gk */
                    public final void mo34435gk(long j) {
                        AppMethodBeat.m2504i(11089);
                        C38593a.m65398A(682, j);
                        AppMethodBeat.m2505o(11089);
                    }

                    /* renamed from: gl */
                    public final void mo34436gl(long j) {
                        AppMethodBeat.m2504i(11090);
                        C38593a.m65399B(683, j);
                        AppMethodBeat.m2505o(11090);
                    }

                    /* renamed from: b */
                    public final void mo34434b(long j, long j2, int i) {
                        AppMethodBeat.m2504i(11091);
                        C38593a.m65400c(1, j, j2, i);
                        AppMethodBeat.m2505o(11091);
                    }

                    /* renamed from: aj */
                    public final void mo34431aj(float f) {
                        AppMethodBeat.m2504i(11092);
                        C33173b.m54251b((long) f, 2, mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11092);
                    }

                    /* renamed from: ak */
                    public final void mo34432ak(float f) {
                        AppMethodBeat.m2504i(11093);
                        C33173b.m54251b((long) f, 3, mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11093);
                    }

                    public final void ays() {
                        AppMethodBeat.m2504i(11094);
                        C18652u.m29152pp(mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11094);
                    }
                });
                AppMethodBeat.m2505o(11120);
                return mTextureView;
            case 2:
                mTextureView = new MSurfaceView(context);
                mTextureView.getDrawContext().hcK = C2126b.azO();
                mTextureView.setDrawActionReportable(new C42400a() {
                    /* renamed from: gk */
                    public final void mo34435gk(long j) {
                        AppMethodBeat.m2504i(11095);
                        C38593a.m65398A(667, j);
                        AppMethodBeat.m2505o(11095);
                    }

                    /* renamed from: gl */
                    public final void mo34436gl(long j) {
                        AppMethodBeat.m2504i(11096);
                        C38593a.m65399B(668, j);
                        AppMethodBeat.m2505o(11096);
                    }

                    /* renamed from: b */
                    public final void mo34434b(long j, long j2, int i) {
                        AppMethodBeat.m2504i(11097);
                        C38593a.m65400c(2, j, j2, i);
                        AppMethodBeat.m2505o(11097);
                    }

                    /* renamed from: aj */
                    public final void mo34431aj(float f) {
                        AppMethodBeat.m2504i(11098);
                        C33173b.m54251b((long) f, 2, mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11098);
                    }

                    /* renamed from: ak */
                    public final void mo34432ak(float f) {
                        AppMethodBeat.m2504i(11099);
                        C33173b.m54251b((long) f, 3, mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11099);
                    }

                    public final void ays() {
                        AppMethodBeat.m2504i(11100);
                        if (TextUtils.isEmpty(mTextureView.getTraceId())) {
                            C18652u.m29151i("MicroMsg.WidgetDrawableViewFactory", "traceId is null return", new Object[0]);
                            AppMethodBeat.m2505o(11100);
                            return;
                        }
                        C18652u.m29152pp(mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11100);
                    }
                });
                AppMethodBeat.m2505o(11120);
                return mTextureView;
            case 3:
                mTextureView = new MCanvasView(context);
                mTextureView.getDrawContext().hcK = C2126b.azO();
                mTextureView.setDrawActionReportable(new C42400a() {
                    /* renamed from: gk */
                    public final void mo34435gk(long j) {
                        AppMethodBeat.m2504i(11101);
                        C38593a.m65398A(685, j);
                        AppMethodBeat.m2505o(11101);
                    }

                    /* renamed from: gl */
                    public final void mo34436gl(long j) {
                        AppMethodBeat.m2504i(11102);
                        C38593a.m65399B(684, j);
                        AppMethodBeat.m2505o(11102);
                    }

                    /* renamed from: b */
                    public final void mo34434b(long j, long j2, int i) {
                        AppMethodBeat.m2504i(11103);
                        C38593a.m65400c(3, j, j2, i);
                        AppMethodBeat.m2505o(11103);
                    }

                    /* renamed from: aj */
                    public final void mo34431aj(float f) {
                        AppMethodBeat.m2504i(11104);
                        C33173b.m54251b((long) f, 2, mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11104);
                    }

                    /* renamed from: ak */
                    public final void mo34432ak(float f) {
                        AppMethodBeat.m2504i(11105);
                        C33173b.m54251b((long) f, 3, mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11105);
                    }

                    public final void ays() {
                        AppMethodBeat.m2504i(11106);
                        C18652u.m29152pp(mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11106);
                    }
                });
                AppMethodBeat.m2505o(11120);
                return mTextureView;
            case 4:
                mTextureView = new MDrawableView(context);
                mTextureView.getDrawContext().hcK = C2126b.azO();
                mTextureView.setDrawActionReportable(new C42400a() {
                    /* renamed from: gk */
                    public final void mo34435gk(long j) {
                        AppMethodBeat.m2504i(11107);
                        C38593a.m65398A(667, j);
                        AppMethodBeat.m2505o(11107);
                    }

                    /* renamed from: gl */
                    public final void mo34436gl(long j) {
                        AppMethodBeat.m2504i(11108);
                        C38593a.m65399B(668, j);
                        AppMethodBeat.m2505o(11108);
                    }

                    /* renamed from: b */
                    public final void mo34434b(long j, long j2, int i) {
                        AppMethodBeat.m2504i(11109);
                        C38593a.m65400c(4, j, j2, i);
                        AppMethodBeat.m2505o(11109);
                    }

                    /* renamed from: aj */
                    public final void mo34431aj(float f) {
                        AppMethodBeat.m2504i(11110);
                        C33173b.m54251b((long) f, 2, mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11110);
                    }

                    /* renamed from: ak */
                    public final void mo34432ak(float f) {
                        AppMethodBeat.m2504i(11111);
                        C33173b.m54251b((long) f, 3, mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11111);
                    }

                    public final void ays() {
                        AppMethodBeat.m2504i(11112);
                        C18652u.m29152pp(mTextureView.getTraceId());
                        AppMethodBeat.m2505o(11112);
                    }
                });
                AppMethodBeat.m2505o(11120);
                return mTextureView;
            default:
                final MHardwareAccelerateDrawableView mHardwareAccelerateDrawableView = new MHardwareAccelerateDrawableView(context);
                mHardwareAccelerateDrawableView.getDrawContext().hcK = C2126b.azO();
                mHardwareAccelerateDrawableView.setDrawActionReportable(new C42400a() {
                    /* renamed from: gk */
                    public final void mo34435gk(long j) {
                        AppMethodBeat.m2504i(11113);
                        C38593a.m65398A(667, j);
                        AppMethodBeat.m2505o(11113);
                    }

                    /* renamed from: gl */
                    public final void mo34436gl(long j) {
                        AppMethodBeat.m2504i(11114);
                        C38593a.m65399B(668, j);
                        AppMethodBeat.m2505o(11114);
                    }

                    /* renamed from: b */
                    public final void mo34434b(long j, long j2, int i) {
                        AppMethodBeat.m2504i(11115);
                        C38593a.m65400c(0, j, j2, i);
                        AppMethodBeat.m2505o(11115);
                    }

                    /* renamed from: aj */
                    public final void mo34431aj(float f) {
                        AppMethodBeat.m2504i(11116);
                        C33173b.m54251b((long) f, 2, mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.m2505o(11116);
                    }

                    /* renamed from: ak */
                    public final void mo34432ak(float f) {
                        AppMethodBeat.m2504i(11117);
                        C33173b.m54251b((long) f, 3, mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.m2505o(11117);
                    }

                    public final void ays() {
                        AppMethodBeat.m2504i(11118);
                        C18652u.m29152pp(mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.m2505o(11118);
                    }
                });
                AppMethodBeat.m2505o(11120);
                return mHardwareAccelerateDrawableView;
        }
    }

    public static String aAm() {
        switch (hpA) {
            case 1:
                return "MTextureView";
            case 2:
                return "MSurfaceView";
            case 3:
                return "MCanvasView";
            case 4:
                return "MDrawableView";
            default:
                return "MHADrawableView";
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m54251b(long j, int i, String str) {
        AppMethodBeat.m2504i(11121);
        C9513cr c9513cr = new C9513cr();
        c9513cr.cTl = (long) i;
        c9513cr.dhm = j;
        c9513cr.dhw = (long) C18652u.m29155pt(str);
        c9513cr.mo20801hD(C18652u.m29154pr(str)).ajK();
        AppMethodBeat.m2505o(11121);
    }
}
