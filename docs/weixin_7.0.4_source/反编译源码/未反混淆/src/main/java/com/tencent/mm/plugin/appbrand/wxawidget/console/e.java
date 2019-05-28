package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e {
    private static final List<WeakReference<ControlBoardPanel>> jpT = new LinkedList();
    private static final a jpU = new a() {
        public final void a(ControlBoardPanel controlBoardPanel, boolean z) {
            AppMethodBeat.i(11154);
            if (!z) {
                e.a(controlBoardPanel);
            }
            AppMethodBeat.o(11154);
        }
    };

    static {
        AppMethodBeat.i(11157);
        AppMethodBeat.o(11157);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void dr(Context context) {
        ControlBoardPanel controlBoardPanel;
        ControlBoardPanel controlBoardPanel2;
        a aVar;
        AppMethodBeat.i(11155);
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
            aVar = jpU;
            if (!controlBoardPanel2.jqd) {
                controlBoardPanel2.jqd = true;
                Activity activity = (Activity) controlBoardPanel2.getContext();
                controlBoardPanel2.jqc = new LayoutParams(-2, -2, 1003, com.tencent.mm.plugin.appbrand.jsapi.j.e.CTRL_INDEX, -3);
                controlBoardPanel2.jqc.y = com.tencent.mm.compatible.util.a.q(activity);
                controlBoardPanel2.jqc.token = activity.getWindow().getDecorView().getWindowToken();
                controlBoardPanel2.jqc.gravity = 51;
                controlBoardPanel2.jqc.softInputMode = 16;
                controlBoardPanel2.jqb.addView(controlBoardPanel2, controlBoardPanel2.jqc);
                controlBoardPanel2.reset();
                controlBoardPanel2.jpU = aVar;
                if (controlBoardPanel2.jpU != null) {
                    controlBoardPanel2.jpU.a(controlBoardPanel2, true);
                }
            }
            AppMethodBeat.o(11155);
        }
        controlBoardPanel = null;
        if (controlBoardPanel != null) {
        }
        aVar = jpU;
        if (controlBoardPanel2.jqd) {
        }
        AppMethodBeat.o(11155);
    }

    static /* synthetic */ void a(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.i(11156);
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
        AppMethodBeat.o(11156);
    }
}
