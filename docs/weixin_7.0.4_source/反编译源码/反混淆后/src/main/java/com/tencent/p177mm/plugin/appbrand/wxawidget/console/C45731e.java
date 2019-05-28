package com.tencent.p177mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1441a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e;
import com.tencent.p177mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.C27437a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.e */
public final class C45731e {
    private static final List<WeakReference<ControlBoardPanel>> jpT = new LinkedList();
    private static final C27437a jpU = new C386291();

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.e$1 */
    static class C386291 implements C27437a {
        C386291() {
        }

        /* renamed from: a */
        public final void mo45213a(ControlBoardPanel controlBoardPanel, boolean z) {
            AppMethodBeat.m2504i(11154);
            if (!z) {
                C45731e.m84497a(controlBoardPanel);
            }
            AppMethodBeat.m2505o(11154);
        }
    }

    static {
        AppMethodBeat.m2504i(11157);
        AppMethodBeat.m2505o(11157);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: dr */
    public static void m84498dr(Context context) {
        ControlBoardPanel controlBoardPanel;
        ControlBoardPanel controlBoardPanel2;
        C27437a c27437a;
        AppMethodBeat.m2504i(11155);
        if (context != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jpT.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) jpT.get(i2);
                if (weakReference != null) {
                    controlBoardPanel = (ControlBoardPanel) weakReference.get();
                    if (controlBoardPanel != null && context == controlBoardPanel.getContext()) {
                        break;
                    }
                }
                i = i2 + 1;
            }
            if (controlBoardPanel != null) {
                controlBoardPanel = new ControlBoardPanel(context);
                jpT.add(new WeakReference(controlBoardPanel));
                controlBoardPanel2 = controlBoardPanel;
            } else {
                controlBoardPanel2 = controlBoardPanel;
            }
            c27437a = jpU;
            if (!controlBoardPanel2.jqd) {
                controlBoardPanel2.jqd = true;
                Activity activity = (Activity) controlBoardPanel2.getContext();
                controlBoardPanel2.jqc = new LayoutParams(-2, -2, 1003, C41234e.CTRL_INDEX, -3);
                controlBoardPanel2.jqc.y = C1441a.m3066q(activity);
                controlBoardPanel2.jqc.token = activity.getWindow().getDecorView().getWindowToken();
                controlBoardPanel2.jqc.gravity = 51;
                controlBoardPanel2.jqc.softInputMode = 16;
                controlBoardPanel2.jqb.addView(controlBoardPanel2, controlBoardPanel2.jqc);
                controlBoardPanel2.reset();
                controlBoardPanel2.jpU = c27437a;
                if (controlBoardPanel2.jpU != null) {
                    controlBoardPanel2.jpU.mo45213a(controlBoardPanel2, true);
                }
            }
            AppMethodBeat.m2505o(11155);
        }
        controlBoardPanel = null;
        if (controlBoardPanel != null) {
        }
        c27437a = jpU;
        if (controlBoardPanel2.jqd) {
        }
        AppMethodBeat.m2505o(11155);
    }

    /* renamed from: a */
    static /* synthetic */ void m84497a(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.m2504i(11156);
        if (controlBoardPanel != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jpT.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) jpT.get(i2);
                if (weakReference != null && controlBoardPanel == weakReference.get()) {
                    jpT.remove(weakReference);
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(11156);
    }
}
