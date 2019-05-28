package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.a;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;

public final class b {
    private static volatile boolean eIC = false;
    private static volatile int hpA = 0;

    public static void initialize() {
        AppMethodBeat.i(11119);
        a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11088);
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eGM;
                c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100284");
                if (ll == null) {
                    ab.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
                    AppMethodBeat.o(11088);
                } else if (ll.isValid()) {
                    try {
                        b.nR(bo.getInt((String) ll.dru().get("mode"), 0));
                        ab.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", Integer.valueOf(b.hpA));
                        AppMethodBeat.o(11088);
                    } catch (Exception e) {
                        ab.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", Log.getStackTraceString(e));
                        AppMethodBeat.o(11088);
                    }
                } else {
                    b.nR(0);
                    AppMethodBeat.o(11088);
                }
            }
        });
        AppMethodBeat.o(11119);
    }

    public static void nR(int i) {
        hpA = i;
        eIC = true;
    }

    public static int aAl() {
        return hpA;
    }

    public static View bS(Context context) {
        AppMethodBeat.i(11120);
        if (!eIC) {
            initialize();
        }
        ab.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", Integer.valueOf(hpA));
        final View mTextureView;
        switch (hpA) {
            case 1:
                mTextureView = new MTextureView(context);
                mTextureView.getDrawContext().hcK = com.tencent.mm.plugin.appbrand.dynamic.b.b.azO();
                mTextureView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    public final void gk(long j) {
                        AppMethodBeat.i(11089);
                        com.tencent.mm.plugin.appbrand.widget.g.a.A(682, j);
                        AppMethodBeat.o(11089);
                    }

                    public final void gl(long j) {
                        AppMethodBeat.i(11090);
                        com.tencent.mm.plugin.appbrand.widget.g.a.B(683, j);
                        AppMethodBeat.o(11090);
                    }

                    public final void b(long j, long j2, int i) {
                        AppMethodBeat.i(11091);
                        com.tencent.mm.plugin.appbrand.widget.g.a.c(1, j, j2, i);
                        AppMethodBeat.o(11091);
                    }

                    public final void aj(float f) {
                        AppMethodBeat.i(11092);
                        b.b((long) f, 2, mTextureView.getTraceId());
                        AppMethodBeat.o(11092);
                    }

                    public final void ak(float f) {
                        AppMethodBeat.i(11093);
                        b.b((long) f, 3, mTextureView.getTraceId());
                        AppMethodBeat.o(11093);
                    }

                    public final void ays() {
                        AppMethodBeat.i(11094);
                        u.pp(mTextureView.getTraceId());
                        AppMethodBeat.o(11094);
                    }
                });
                AppMethodBeat.o(11120);
                return mTextureView;
            case 2:
                mTextureView = new MSurfaceView(context);
                mTextureView.getDrawContext().hcK = com.tencent.mm.plugin.appbrand.dynamic.b.b.azO();
                mTextureView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    public final void gk(long j) {
                        AppMethodBeat.i(11095);
                        com.tencent.mm.plugin.appbrand.widget.g.a.A(667, j);
                        AppMethodBeat.o(11095);
                    }

                    public final void gl(long j) {
                        AppMethodBeat.i(11096);
                        com.tencent.mm.plugin.appbrand.widget.g.a.B(668, j);
                        AppMethodBeat.o(11096);
                    }

                    public final void b(long j, long j2, int i) {
                        AppMethodBeat.i(11097);
                        com.tencent.mm.plugin.appbrand.widget.g.a.c(2, j, j2, i);
                        AppMethodBeat.o(11097);
                    }

                    public final void aj(float f) {
                        AppMethodBeat.i(11098);
                        b.b((long) f, 2, mTextureView.getTraceId());
                        AppMethodBeat.o(11098);
                    }

                    public final void ak(float f) {
                        AppMethodBeat.i(11099);
                        b.b((long) f, 3, mTextureView.getTraceId());
                        AppMethodBeat.o(11099);
                    }

                    public final void ays() {
                        AppMethodBeat.i(11100);
                        if (TextUtils.isEmpty(mTextureView.getTraceId())) {
                            u.i("MicroMsg.WidgetDrawableViewFactory", "traceId is null return", new Object[0]);
                            AppMethodBeat.o(11100);
                            return;
                        }
                        u.pp(mTextureView.getTraceId());
                        AppMethodBeat.o(11100);
                    }
                });
                AppMethodBeat.o(11120);
                return mTextureView;
            case 3:
                mTextureView = new MCanvasView(context);
                mTextureView.getDrawContext().hcK = com.tencent.mm.plugin.appbrand.dynamic.b.b.azO();
                mTextureView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    public final void gk(long j) {
                        AppMethodBeat.i(11101);
                        com.tencent.mm.plugin.appbrand.widget.g.a.A(685, j);
                        AppMethodBeat.o(11101);
                    }

                    public final void gl(long j) {
                        AppMethodBeat.i(11102);
                        com.tencent.mm.plugin.appbrand.widget.g.a.B(684, j);
                        AppMethodBeat.o(11102);
                    }

                    public final void b(long j, long j2, int i) {
                        AppMethodBeat.i(11103);
                        com.tencent.mm.plugin.appbrand.widget.g.a.c(3, j, j2, i);
                        AppMethodBeat.o(11103);
                    }

                    public final void aj(float f) {
                        AppMethodBeat.i(11104);
                        b.b((long) f, 2, mTextureView.getTraceId());
                        AppMethodBeat.o(11104);
                    }

                    public final void ak(float f) {
                        AppMethodBeat.i(11105);
                        b.b((long) f, 3, mTextureView.getTraceId());
                        AppMethodBeat.o(11105);
                    }

                    public final void ays() {
                        AppMethodBeat.i(11106);
                        u.pp(mTextureView.getTraceId());
                        AppMethodBeat.o(11106);
                    }
                });
                AppMethodBeat.o(11120);
                return mTextureView;
            case 4:
                mTextureView = new MDrawableView(context);
                mTextureView.getDrawContext().hcK = com.tencent.mm.plugin.appbrand.dynamic.b.b.azO();
                mTextureView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    public final void gk(long j) {
                        AppMethodBeat.i(11107);
                        com.tencent.mm.plugin.appbrand.widget.g.a.A(667, j);
                        AppMethodBeat.o(11107);
                    }

                    public final void gl(long j) {
                        AppMethodBeat.i(11108);
                        com.tencent.mm.plugin.appbrand.widget.g.a.B(668, j);
                        AppMethodBeat.o(11108);
                    }

                    public final void b(long j, long j2, int i) {
                        AppMethodBeat.i(11109);
                        com.tencent.mm.plugin.appbrand.widget.g.a.c(4, j, j2, i);
                        AppMethodBeat.o(11109);
                    }

                    public final void aj(float f) {
                        AppMethodBeat.i(11110);
                        b.b((long) f, 2, mTextureView.getTraceId());
                        AppMethodBeat.o(11110);
                    }

                    public final void ak(float f) {
                        AppMethodBeat.i(11111);
                        b.b((long) f, 3, mTextureView.getTraceId());
                        AppMethodBeat.o(11111);
                    }

                    public final void ays() {
                        AppMethodBeat.i(11112);
                        u.pp(mTextureView.getTraceId());
                        AppMethodBeat.o(11112);
                    }
                });
                AppMethodBeat.o(11120);
                return mTextureView;
            default:
                final MHardwareAccelerateDrawableView mHardwareAccelerateDrawableView = new MHardwareAccelerateDrawableView(context);
                mHardwareAccelerateDrawableView.getDrawContext().hcK = com.tencent.mm.plugin.appbrand.dynamic.b.b.azO();
                mHardwareAccelerateDrawableView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    public final void gk(long j) {
                        AppMethodBeat.i(11113);
                        com.tencent.mm.plugin.appbrand.widget.g.a.A(667, j);
                        AppMethodBeat.o(11113);
                    }

                    public final void gl(long j) {
                        AppMethodBeat.i(11114);
                        com.tencent.mm.plugin.appbrand.widget.g.a.B(668, j);
                        AppMethodBeat.o(11114);
                    }

                    public final void b(long j, long j2, int i) {
                        AppMethodBeat.i(11115);
                        com.tencent.mm.plugin.appbrand.widget.g.a.c(0, j, j2, i);
                        AppMethodBeat.o(11115);
                    }

                    public final void aj(float f) {
                        AppMethodBeat.i(11116);
                        b.b((long) f, 2, mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.o(11116);
                    }

                    public final void ak(float f) {
                        AppMethodBeat.i(11117);
                        b.b((long) f, 3, mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.o(11117);
                    }

                    public final void ays() {
                        AppMethodBeat.i(11118);
                        u.pp(mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.o(11118);
                    }
                });
                AppMethodBeat.o(11120);
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

    static /* synthetic */ void b(long j, int i, String str) {
        AppMethodBeat.i(11121);
        cr crVar = new cr();
        crVar.cTl = (long) i;
        crVar.dhm = j;
        crVar.dhw = (long) u.pt(str);
        crVar.hD(u.pr(str)).ajK();
        AppMethodBeat.o(11121);
    }
}
