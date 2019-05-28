package com.tencent.p177mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel */
public class ControlBoardPanel extends FrameLayout {
    ConsolePanel hoZ;
    C27437a jpU;
    View jpV;
    SettingsPanel jpW;
    View jpX;
    View jpY;
    View jpZ;
    View jqa;
    WindowManager jqb;
    LayoutParams jqc;
    boolean jqd;

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel$2 */
    class C110562 implements OnClickListener {
        C110562() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11159);
            if (ControlBoardPanel.this.jpW.getVisibility() == 0) {
                ControlBoardPanel.this.jpV.setVisibility(8);
                ControlBoardPanel.this.jpW.setVisibility(8);
                ControlBoardPanel.this.jpZ.setSelected(false);
                ControlBoardPanel.m43534a(ControlBoardPanel.this);
                AppMethodBeat.m2505o(11159);
                return;
            }
            ControlBoardPanel.this.jpV.setVisibility(0);
            ControlBoardPanel.this.hoZ.setVisibility(8);
            ControlBoardPanel.this.jpW.setVisibility(0);
            ControlBoardPanel.this.jpX.setVisibility(8);
            ControlBoardPanel.this.jpY.setSelected(false);
            ControlBoardPanel.this.jpZ.setSelected(true);
            ControlBoardPanel.this.jqa.setSelected(false);
            ControlBoardPanel.m43535b(ControlBoardPanel.this);
            AppMethodBeat.m2505o(11159);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel$3 */
    class C110573 implements OnClickListener {
        C110573() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11160);
            if (ControlBoardPanel.this.jpX.getVisibility() == 0) {
                ControlBoardPanel.this.jpV.setVisibility(8);
                ControlBoardPanel.this.jpX.setVisibility(8);
                ControlBoardPanel.this.jqa.setSelected(false);
                ControlBoardPanel.m43534a(ControlBoardPanel.this);
                AppMethodBeat.m2505o(11160);
                return;
            }
            ControlBoardPanel.this.jpV.setVisibility(0);
            ControlBoardPanel.this.hoZ.setVisibility(8);
            ControlBoardPanel.this.jpW.setVisibility(8);
            ControlBoardPanel.this.jpX.setVisibility(0);
            ControlBoardPanel.this.jpY.setSelected(false);
            ControlBoardPanel.this.jpZ.setSelected(false);
            ControlBoardPanel.this.jqa.setSelected(true);
            ControlBoardPanel.m43535b(ControlBoardPanel.this);
            AppMethodBeat.m2505o(11160);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel$1 */
    class C274351 implements OnClickListener {
        C274351() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11158);
            if (ControlBoardPanel.this.hoZ.getVisibility() == 0) {
                ControlBoardPanel.this.jpV.setVisibility(8);
                ControlBoardPanel.this.hoZ.setVisibility(8);
                ControlBoardPanel.this.jpY.setSelected(false);
                ControlBoardPanel.m43534a(ControlBoardPanel.this);
                AppMethodBeat.m2505o(11158);
                return;
            }
            ControlBoardPanel.this.jpV.setVisibility(0);
            ControlBoardPanel.this.hoZ.setVisibility(0);
            ControlBoardPanel.this.jpW.setVisibility(8);
            ControlBoardPanel.this.jpX.setVisibility(8);
            ControlBoardPanel.this.jpY.setSelected(true);
            ControlBoardPanel.this.jpZ.setSelected(false);
            ControlBoardPanel.this.jqa.setSelected(false);
            ControlBoardPanel.m43535b(ControlBoardPanel.this);
            AppMethodBeat.m2505o(11158);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel$4 */
    class C274364 implements OnKeyListener {
        C274364() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(11161);
            C4990ab.m7417i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", Integer.valueOf(i), keyEvent);
            if (i == 4) {
                ControlBoardPanel.this.jpV.setVisibility(8);
                ControlBoardPanel.this.jpX.setVisibility(8);
                ControlBoardPanel.this.jpX.setVisibility(8);
                ControlBoardPanel.this.jqa.setSelected(false);
                ControlBoardPanel.this.jpY.setSelected(false);
                ControlBoardPanel.this.jpZ.setSelected(false);
                ControlBoardPanel.m43534a(ControlBoardPanel.this);
            }
            AppMethodBeat.m2505o(11161);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel$a */
    public interface C27437a {
        /* renamed from: a */
        void mo45213a(ControlBoardPanel controlBoardPanel, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel$5 */
    class C274385 implements OnClickListener {
        C274385() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11162);
            ControlBoardPanel controlBoardPanel = ControlBoardPanel.this;
            if (controlBoardPanel.jqd) {
                controlBoardPanel.jqd = false;
                controlBoardPanel.jqb.removeViewImmediate(controlBoardPanel);
                C33656d.m54963b(controlBoardPanel.hoZ);
                if (controlBoardPanel.jpU != null) {
                    controlBoardPanel.jpU.mo45213a(controlBoardPanel, false);
                }
            }
            AppMethodBeat.m2505o(11162);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel$6 */
    class C274396 implements Runnable {
        C274396() {
        }

        public final void run() {
            AppMethodBeat.m2504i(11163);
            ControlBoardPanel.this.reset();
            AppMethodBeat.m2505o(11163);
        }
    }

    public ControlBoardPanel(Context context) {
        super(context);
        AppMethodBeat.m2504i(11164);
        init();
        AppMethodBeat.m2505o(11164);
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(11165);
        init();
        AppMethodBeat.m2505o(11165);
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(11166);
        init();
        AppMethodBeat.m2505o(11166);
    }

    private void init() {
        AppMethodBeat.m2504i(11167);
        Context context = getContext();
        this.jqb = (WindowManager) context.getSystemService("window");
        LayoutInflater.from(context).inflate(2130969240, this, true);
        this.jpV = findViewById(2131823143);
        this.hoZ = (ConsolePanel) findViewById(2131823144);
        this.jpW = (SettingsPanel) findViewById(2131823145);
        this.jpX = findViewById(2131823146);
        this.jpY = findViewById(2131823140);
        this.jpZ = findViewById(2131823141);
        this.jqa = findViewById(2131823142);
        if (!((C9687e) C1720g.m3528K(C9687e.class)).abz().abF()) {
            this.jqa.setVisibility(8);
        }
        this.jpY.setOnClickListener(new C274351());
        this.jpZ.setOnClickListener(new C110562());
        this.jqa.setOnClickListener(new C110573());
        setOnKeyListener(new C274364());
        this.jpW.setOnCloseDebuggerClickListener(new C274385());
        this.jpW.setOnResetDebuggerRunnable(new C274396());
        AppMethodBeat.m2505o(11167);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(11168);
        C4990ab.m7417i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", Integer.valueOf(i), keyEvent);
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(11168);
        return onKeyUp;
    }

    public final void reset() {
        AppMethodBeat.m2504i(11169);
        C33656d.m54963b(this.hoZ);
        C33656d.m54962a(this.hoZ);
        AppMethodBeat.m2505o(11169);
    }

    /* renamed from: a */
    static /* synthetic */ void m43534a(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.m2504i(11170);
        controlBoardPanel.jqc.width = -2;
        controlBoardPanel.jqc.height = -2;
        controlBoardPanel.jqc.flags = C41234e.CTRL_INDEX;
        controlBoardPanel.jqb.updateViewLayout(controlBoardPanel, controlBoardPanel.jqc);
        AppMethodBeat.m2505o(11170);
    }

    /* renamed from: b */
    static /* synthetic */ void m43535b(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.m2504i(11171);
        controlBoardPanel.jqc.width = -1;
        controlBoardPanel.jqc.height = -1;
        controlBoardPanel.jqc.flags = 544;
        controlBoardPanel.jqb.updateViewLayout(controlBoardPanel, controlBoardPanel.jqc);
        AppMethodBeat.m2505o(11171);
    }
}
