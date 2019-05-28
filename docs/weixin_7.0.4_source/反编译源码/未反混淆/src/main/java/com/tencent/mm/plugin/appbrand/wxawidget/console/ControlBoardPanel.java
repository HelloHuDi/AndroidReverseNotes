package com.tencent.mm.plugin.appbrand.wxawidget.console;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.sdk.platformtools.ab;

public class ControlBoardPanel extends FrameLayout {
    ConsolePanel hoZ;
    a jpU;
    View jpV;
    SettingsPanel jpW;
    View jpX;
    View jpY;
    View jpZ;
    View jqa;
    WindowManager jqb;
    LayoutParams jqc;
    boolean jqd;

    public interface a {
        void a(ControlBoardPanel controlBoardPanel, boolean z);
    }

    public ControlBoardPanel(Context context) {
        super(context);
        AppMethodBeat.i(11164);
        init();
        AppMethodBeat.o(11164);
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(11165);
        init();
        AppMethodBeat.o(11165);
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(11166);
        init();
        AppMethodBeat.o(11166);
    }

    private void init() {
        AppMethodBeat.i(11167);
        Context context = getContext();
        this.jqb = (WindowManager) context.getSystemService("window");
        LayoutInflater.from(context).inflate(R.layout.r7, this, true);
        this.jpV = findViewById(R.id.b69);
        this.hoZ = (ConsolePanel) findViewById(R.id.b6_);
        this.jpW = (SettingsPanel) findViewById(R.id.b6a);
        this.jpX = findViewById(R.id.b6b);
        this.jpY = findViewById(R.id.b66);
        this.jpZ = findViewById(R.id.b67);
        this.jqa = findViewById(R.id.b68);
        if (!((e) g.K(e.class)).abz().abF()) {
            this.jqa.setVisibility(8);
        }
        this.jpY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11158);
                if (ControlBoardPanel.this.hoZ.getVisibility() == 0) {
                    ControlBoardPanel.this.jpV.setVisibility(8);
                    ControlBoardPanel.this.hoZ.setVisibility(8);
                    ControlBoardPanel.this.jpY.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                    AppMethodBeat.o(11158);
                    return;
                }
                ControlBoardPanel.this.jpV.setVisibility(0);
                ControlBoardPanel.this.hoZ.setVisibility(0);
                ControlBoardPanel.this.jpW.setVisibility(8);
                ControlBoardPanel.this.jpX.setVisibility(8);
                ControlBoardPanel.this.jpY.setSelected(true);
                ControlBoardPanel.this.jpZ.setSelected(false);
                ControlBoardPanel.this.jqa.setSelected(false);
                ControlBoardPanel.b(ControlBoardPanel.this);
                AppMethodBeat.o(11158);
            }
        });
        this.jpZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11159);
                if (ControlBoardPanel.this.jpW.getVisibility() == 0) {
                    ControlBoardPanel.this.jpV.setVisibility(8);
                    ControlBoardPanel.this.jpW.setVisibility(8);
                    ControlBoardPanel.this.jpZ.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                    AppMethodBeat.o(11159);
                    return;
                }
                ControlBoardPanel.this.jpV.setVisibility(0);
                ControlBoardPanel.this.hoZ.setVisibility(8);
                ControlBoardPanel.this.jpW.setVisibility(0);
                ControlBoardPanel.this.jpX.setVisibility(8);
                ControlBoardPanel.this.jpY.setSelected(false);
                ControlBoardPanel.this.jpZ.setSelected(true);
                ControlBoardPanel.this.jqa.setSelected(false);
                ControlBoardPanel.b(ControlBoardPanel.this);
                AppMethodBeat.o(11159);
            }
        });
        this.jqa.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11160);
                if (ControlBoardPanel.this.jpX.getVisibility() == 0) {
                    ControlBoardPanel.this.jpV.setVisibility(8);
                    ControlBoardPanel.this.jpX.setVisibility(8);
                    ControlBoardPanel.this.jqa.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                    AppMethodBeat.o(11160);
                    return;
                }
                ControlBoardPanel.this.jpV.setVisibility(0);
                ControlBoardPanel.this.hoZ.setVisibility(8);
                ControlBoardPanel.this.jpW.setVisibility(8);
                ControlBoardPanel.this.jpX.setVisibility(0);
                ControlBoardPanel.this.jpY.setSelected(false);
                ControlBoardPanel.this.jpZ.setSelected(false);
                ControlBoardPanel.this.jqa.setSelected(true);
                ControlBoardPanel.b(ControlBoardPanel.this);
                AppMethodBeat.o(11160);
            }
        });
        setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(11161);
                ab.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", Integer.valueOf(i), keyEvent);
                if (i == 4) {
                    ControlBoardPanel.this.jpV.setVisibility(8);
                    ControlBoardPanel.this.jpX.setVisibility(8);
                    ControlBoardPanel.this.jpX.setVisibility(8);
                    ControlBoardPanel.this.jqa.setSelected(false);
                    ControlBoardPanel.this.jpY.setSelected(false);
                    ControlBoardPanel.this.jpZ.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                }
                AppMethodBeat.o(11161);
                return false;
            }
        });
        this.jpW.setOnCloseDebuggerClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11162);
                ControlBoardPanel controlBoardPanel = ControlBoardPanel.this;
                if (controlBoardPanel.jqd) {
                    controlBoardPanel.jqd = false;
                    controlBoardPanel.jqb.removeViewImmediate(controlBoardPanel);
                    d.b(controlBoardPanel.hoZ);
                    if (controlBoardPanel.jpU != null) {
                        controlBoardPanel.jpU.a(controlBoardPanel, false);
                    }
                }
                AppMethodBeat.o(11162);
            }
        });
        this.jpW.setOnResetDebuggerRunnable(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11163);
                ControlBoardPanel.this.reset();
                AppMethodBeat.o(11163);
            }
        });
        AppMethodBeat.o(11167);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(11168);
        ab.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", Integer.valueOf(i), keyEvent);
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(11168);
        return onKeyUp;
    }

    public final void reset() {
        AppMethodBeat.i(11169);
        d.b(this.hoZ);
        d.a(this.hoZ);
        AppMethodBeat.o(11169);
    }

    static /* synthetic */ void a(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.i(11170);
        controlBoardPanel.jqc.width = -2;
        controlBoardPanel.jqc.height = -2;
        controlBoardPanel.jqc.flags = com.tencent.mm.plugin.appbrand.jsapi.j.e.CTRL_INDEX;
        controlBoardPanel.jqb.updateViewLayout(controlBoardPanel, controlBoardPanel.jqc);
        AppMethodBeat.o(11170);
    }

    static /* synthetic */ void b(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.i(11171);
        controlBoardPanel.jqc.width = -1;
        controlBoardPanel.jqc.height = -1;
        controlBoardPanel.jqc.flags = 544;
        controlBoardPanel.jqb.updateViewLayout(controlBoardPanel, controlBoardPanel.jqc);
        AppMethodBeat.o(11171);
    }
}
