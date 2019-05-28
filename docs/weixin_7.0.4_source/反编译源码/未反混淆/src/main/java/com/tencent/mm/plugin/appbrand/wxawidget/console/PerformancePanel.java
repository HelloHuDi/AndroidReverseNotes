package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.ttpic.baseutils.IOUtils;

public class PerformancePanel extends FrameLayout {
    MMSwitchBtn hpg;
    MMSwitchBtn hph;
    MMSwitchBtn hpi;

    static class a implements com.tencent.mm.ipcinvoker.a<IPCVoid, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(11179);
            com.tencent.mm.plugin.appbrand.collector.c.clear();
            AppMethodBeat.o(11179);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.a<IPCBoolean, IPCVoid> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(11180);
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.yK("jsapi_draw_canvas");
                AppMethodBeat.o(11180);
                return;
            }
            com.tencent.mm.plugin.appbrand.collector.c.yL("jsapi_draw_canvas");
            AppMethodBeat.o(11180);
        }
    }

    static class c implements com.tencent.mm.ipcinvoker.a<IPCBoolean, IPCVoid> {
        private c() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(11181);
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.yK("widget_launch");
                AppMethodBeat.o(11181);
                return;
            }
            com.tencent.mm.plugin.appbrand.collector.c.yL("widget_launch");
            AppMethodBeat.o(11181);
        }
    }

    static class e implements i<IPCString, IPCString> {
        private e() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(11183);
            IPCString iPCString = new IPCString(com.tencent.mm.plugin.appbrand.collector.c.yJ(((IPCString) obj).value).toString());
            AppMethodBeat.o(11183);
            return iPCString;
        }
    }

    static class d implements com.tencent.mm.ipcinvoker.a<IPCBoolean, IPCVoid> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(11182);
            com.tencent.mm.plugin.appbrand.collector.c.dG(((IPCBoolean) obj).value);
            AppMethodBeat.o(11182);
        }
    }

    public PerformancePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(11184);
        init();
        AppMethodBeat.o(11184);
    }

    public PerformancePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(11185);
        init();
        AppMethodBeat.o(11185);
    }

    private void init() {
        AppMethodBeat.i(11186);
        LayoutInflater.from(getContext()).inflate(R.layout.akd, this, true);
        final TextView textView = (TextView) findViewById(R.id.dmn);
        final View findViewById = findViewById(R.id.dmm);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11173);
                String stringBuilder = com.tencent.mm.plugin.appbrand.collector.c.yJ("jsapi_draw_canvas").toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder != null && stringBuilder.length() > 0) {
                    stringBuilder2.append("data size :").append(com.tencent.mm.plugin.appbrand.collector.c.bF("jsapi_draw_canvas", "__invoke_jsapi_data_size")).append(IOUtils.LINE_SEPARATOR_UNIX).append(stringBuilder);
                }
                IPCString iPCString = (IPCString) f.a("com.tencent.mm:support", new IPCString("widget_launch"), e.class);
                if (iPCString != null) {
                    stringBuilder2.append("\n\n").append(iPCString);
                }
                if (com.tencent.mm.plugin.appbrand.collector.f.ayu()) {
                    stringBuilder2.append("\n\n").append(com.tencent.mm.plugin.appbrand.collector.f.ayv());
                }
                textView.setText(stringBuilder2.toString());
                AppMethodBeat.o(11173);
            }
        });
        findViewById(R.id.kz).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11174);
                f.a("com.tencent.mm:support", null, a.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.clear();
                com.tencent.mm.plugin.appbrand.collector.f.reset();
                textView.setText(com.tencent.mm.plugin.appbrand.collector.c.yJ("jsapi_draw_canvas").toString());
                AppMethodBeat.o(11174);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.dmi);
        boolean ayt = com.tencent.mm.plugin.appbrand.collector.c.ayt();
        mMSwitchBtn.setCheck(ayt);
        mMSwitchBtn.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(11175);
                f.a("com.tencent.mm:support", new IPCBoolean(z), d.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.dG(z);
                findViewById.setEnabled(z);
                PerformancePanel.this.hpg.setEnabled(z);
                PerformancePanel.this.hph.setEnabled(z);
                PerformancePanel.this.hpi.setEnabled(z);
                AppMethodBeat.o(11175);
            }
        });
        findViewById.setEnabled(ayt);
        this.hpg = (MMSwitchBtn) findViewById(R.id.dmj);
        this.hpg.setEnabled(ayt);
        this.hpg.setCheck(com.tencent.mm.plugin.appbrand.collector.c.yM("jsapi_draw_canvas"));
        this.hpg.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(11176);
                f.a("com.tencent.mm:support", new IPCBoolean(z), b.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.yK("jsapi_draw_canvas");
                    AppMethodBeat.o(11176);
                    return;
                }
                com.tencent.mm.plugin.appbrand.collector.c.yL("jsapi_draw_canvas");
                AppMethodBeat.o(11176);
            }
        });
        this.hph = (MMSwitchBtn) findViewById(R.id.dmk);
        this.hph.setEnabled(ayt);
        this.hph.setCheck(com.tencent.mm.plugin.appbrand.collector.c.yM("widget_launch"));
        this.hph.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(11177);
                f.a("com.tencent.mm:support", new IPCBoolean(z), c.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.yK("widget_launch");
                    AppMethodBeat.o(11177);
                    return;
                }
                com.tencent.mm.plugin.appbrand.collector.c.yL("widget_launch");
                AppMethodBeat.o(11177);
            }
        });
        this.hpi = (MMSwitchBtn) findViewById(R.id.dml);
        this.hpi.setEnabled(ayt);
        this.hpi.setCheck(com.tencent.mm.plugin.appbrand.collector.f.ayu());
        this.hpi.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(11178);
                com.tencent.mm.plugin.appbrand.collector.f.dH(z);
                AppMethodBeat.o(11178);
            }
        });
        AppMethodBeat.o(11186);
    }
}
