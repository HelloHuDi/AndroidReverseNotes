package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashSet;
import java.util.Set;

public final class u implements com.tencent.mm.plugin.appbrand.widget.d.a {
    private static Integer jfu = null;
    private int jfo = 0;
    private final int[] jfp = new int[2];
    private final Rect jfq = new Rect();
    private boolean jfr = false;
    private View jfs;
    b jft;
    private final Set<c> jfv = new LinkedHashSet();

    public interface c {
        void et(boolean z);

        int getHeight();

        void oD(int i);
    }

    interface a {
        void c(c cVar);
    }

    interface b extends c {
    }

    public u() {
        AppMethodBeat.i(77430);
        AppMethodBeat.o(77430);
    }

    private void getWindowVisibleDisplayFrame(Rect rect) {
        AppMethodBeat.i(77431);
        if (this.jfs != null) {
            this.jfs.getWindowVisibleDisplayFrame(rect);
            this.jfs.getLocationInWindow(this.jfp);
            rect.top = this.jfp[1];
        }
        AppMethodBeat.o(77431);
    }

    private Context getContext() {
        AppMethodBeat.i(77432);
        Context context;
        if (this.jfs == null) {
            context = ah.getContext();
            AppMethodBeat.o(77432);
            return context;
        }
        context = this.jfs.getContext();
        AppMethodBeat.o(77432);
        return context;
    }

    public final void cK(View view) {
        Object obj = 1;
        AppMethodBeat.i(77434);
        this.jfs = view;
        Rect rect = this.jfq;
        getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.jfo == 0) {
            this.jfo = height;
        } else {
            final int frameHeight = getFrameHeight() - height;
            if (frameHeight > 0) {
                Object obj2;
                Context context = getContext();
                if (frameHeight > 0) {
                    if (jfu == null) {
                        jfu = Integer.valueOf(x.gs(context));
                    }
                    if (jfu.intValue() != frameHeight) {
                        jfu = Integer.valueOf(frameHeight);
                        obj2 = 1;
                        a(new a() {
                            public final void c(c cVar) {
                                AppMethodBeat.i(77428);
                                if (cVar.getHeight() != frameHeight) {
                                    cVar.oD(frameHeight);
                                }
                                AppMethodBeat.o(77428);
                            }
                        });
                        if (!(this.jft == null || (obj2 == null && this.jft.getHeight() == frameHeight))) {
                            this.jft.oD(frameHeight);
                        }
                    }
                }
                obj2 = null;
                a(/* anonymous class already generated */);
                this.jft.oD(frameHeight);
            }
        }
        final boolean z = getFrameHeight() > height;
        if (this.jfr == z) {
            obj = null;
        }
        if (obj != null) {
            if (this.jft != null) {
                this.jft.et(z);
            }
            a(new a() {
                public final void c(c cVar) {
                    AppMethodBeat.i(77429);
                    cVar.et(z);
                    AppMethodBeat.o(77429);
                }
            });
        }
        this.jfr = z;
        this.jfo = height;
        this.jfs = null;
        AppMethodBeat.o(77434);
    }

    private void a(a aVar) {
        AppMethodBeat.i(77435);
        for (c c : this.jfv) {
            aVar.c(c);
        }
        AppMethodBeat.o(77435);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(77436);
        if (cVar != null) {
            this.jfv.add(cVar);
        }
        AppMethodBeat.o(77436);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(77437);
        if (cVar != null) {
            this.jfv.remove(cVar);
        }
        AppMethodBeat.o(77437);
    }

    private int getFrameHeight() {
        View view;
        AppMethodBeat.i(77433);
        if (this.jfs == null) {
            view = null;
        } else {
            view = this.jfs.getRootView();
        }
        if (view == null) {
            AppMethodBeat.o(77433);
            return 0;
        }
        int measuredHeight;
        Rect rect = this.jfq;
        getWindowVisibleDisplayFrame(rect);
        if (s.as(this.jfs)) {
            measuredHeight = this.jfs.getMeasuredHeight();
        } else {
            measuredHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        }
        measuredHeight -= rect.top;
        AppMethodBeat.o(77433);
        return measuredHeight;
    }
}
