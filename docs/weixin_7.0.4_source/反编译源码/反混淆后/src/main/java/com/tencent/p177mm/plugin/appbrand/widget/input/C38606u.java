package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.support.p057v4.view.C0477s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.p1234d.C19811a;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.u */
public final class C38606u implements C19811a {
    private static Integer jfu = null;
    private int jfo = 0;
    private final int[] jfp = new int[2];
    private final Rect jfq = new Rect();
    private boolean jfr = false;
    private View jfs;
    C33633b jft;
    private final Set<C11042c> jfv = new LinkedHashSet();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.u$c */
    public interface C11042c {
        /* renamed from: et */
        void mo6332et(boolean z);

        int getHeight();

        /* renamed from: oD */
        void mo6334oD(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.u$a */
    interface C33632a {
        /* renamed from: c */
        void mo6560c(C11042c c11042c);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.u$b */
    interface C33633b extends C11042c {
    }

    public C38606u() {
        AppMethodBeat.m2504i(77430);
        AppMethodBeat.m2505o(77430);
    }

    private void getWindowVisibleDisplayFrame(Rect rect) {
        AppMethodBeat.m2504i(77431);
        if (this.jfs != null) {
            this.jfs.getWindowVisibleDisplayFrame(rect);
            this.jfs.getLocationInWindow(this.jfp);
            rect.top = this.jfp[1];
        }
        AppMethodBeat.m2505o(77431);
    }

    private Context getContext() {
        AppMethodBeat.m2504i(77432);
        Context context;
        if (this.jfs == null) {
            context = C4996ah.getContext();
            AppMethodBeat.m2505o(77432);
            return context;
        }
        context = this.jfs.getContext();
        AppMethodBeat.m2505o(77432);
        return context;
    }

    /* renamed from: cK */
    public final void mo35031cK(View view) {
        Object obj = 1;
        AppMethodBeat.m2504i(77434);
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
                        jfu = Integer.valueOf(C40619x.m70073gs(context));
                    }
                    if (jfu.intValue() != frameHeight) {
                        jfu = Integer.valueOf(frameHeight);
                        obj2 = 1;
                        m65427a(new C33632a() {
                            /* renamed from: c */
                            public final void mo6560c(C11042c c11042c) {
                                AppMethodBeat.m2504i(77428);
                                if (c11042c.getHeight() != frameHeight) {
                                    c11042c.mo6334oD(frameHeight);
                                }
                                AppMethodBeat.m2505o(77428);
                            }
                        });
                        if (!(this.jft == null || (obj2 == null && this.jft.getHeight() == frameHeight))) {
                            this.jft.mo6334oD(frameHeight);
                        }
                    }
                }
                obj2 = null;
                m65427a(/* anonymous class already generated */);
                this.jft.mo6334oD(frameHeight);
            }
        }
        final boolean z = getFrameHeight() > height;
        if (this.jfr == z) {
            obj = null;
        }
        if (obj != null) {
            if (this.jft != null) {
                this.jft.mo6332et(z);
            }
            m65427a(new C33632a() {
                /* renamed from: c */
                public final void mo6560c(C11042c c11042c) {
                    AppMethodBeat.m2504i(77429);
                    c11042c.mo6332et(z);
                    AppMethodBeat.m2505o(77429);
                }
            });
        }
        this.jfr = z;
        this.jfo = height;
        this.jfs = null;
        AppMethodBeat.m2505o(77434);
    }

    /* renamed from: a */
    private void m65427a(C33632a c33632a) {
        AppMethodBeat.m2504i(77435);
        for (C11042c c : this.jfv) {
            c33632a.mo6560c(c);
        }
        AppMethodBeat.m2505o(77435);
    }

    /* renamed from: a */
    public final void mo61402a(C11042c c11042c) {
        AppMethodBeat.m2504i(77436);
        if (c11042c != null) {
            this.jfv.add(c11042c);
        }
        AppMethodBeat.m2505o(77436);
    }

    /* renamed from: b */
    public final void mo61403b(C11042c c11042c) {
        AppMethodBeat.m2504i(77437);
        if (c11042c != null) {
            this.jfv.remove(c11042c);
        }
        AppMethodBeat.m2505o(77437);
    }

    private int getFrameHeight() {
        View view;
        AppMethodBeat.m2504i(77433);
        if (this.jfs == null) {
            view = null;
        } else {
            view = this.jfs.getRootView();
        }
        if (view == null) {
            AppMethodBeat.m2505o(77433);
            return 0;
        }
        int measuredHeight;
        Rect rect = this.jfq;
        getWindowVisibleDisplayFrame(rect);
        if (C0477s.m927as(this.jfs)) {
            measuredHeight = this.jfs.getMeasuredHeight();
        } else {
            measuredHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        }
        measuredHeight -= rect.top;
        AppMethodBeat.m2505o(77433);
        return measuredHeight;
    }
}
