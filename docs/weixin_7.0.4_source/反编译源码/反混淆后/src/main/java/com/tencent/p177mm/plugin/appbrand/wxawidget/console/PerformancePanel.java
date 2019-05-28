package com.tencent.p177mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.plugin.appbrand.collector.C2107c;
import com.tencent.p177mm.plugin.appbrand.collector.C33128f;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel */
public class PerformancePanel extends FrameLayout {
    MMSwitchBtn hpg;
    MMSwitchBtn hph;
    MMSwitchBtn hpi;

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel$5 */
    class C25955 implements C30795a {
        C25955() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(11177);
            C9549f.m17012a("com.tencent.mm:support", new IPCBoolean(z), C33654c.class, null);
            if (z) {
                C2107c.m4321yK("widget_launch");
                AppMethodBeat.m2505o(11177);
                return;
            }
            C2107c.m4322yL("widget_launch");
            AppMethodBeat.m2505o(11177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel$a */
    static class C2596a implements C37866a<IPCVoid, IPCVoid> {
        private C2596a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(11179);
            C2107c.clear();
            AppMethodBeat.m2505o(11179);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel$6 */
    class C110586 implements C30795a {
        C110586() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(11178);
            C33128f.m54149dH(z);
            AppMethodBeat.m2505o(11178);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel$4 */
    class C313364 implements C30795a {
        C313364() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(11176);
            C9549f.m17012a("com.tencent.mm:support", new IPCBoolean(z), C33653b.class, null);
            if (z) {
                C2107c.m4321yK("jsapi_draw_canvas");
                AppMethodBeat.m2505o(11176);
                return;
            }
            C2107c.m4322yL("jsapi_draw_canvas");
            AppMethodBeat.m2505o(11176);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel$b */
    static class C33653b implements C37866a<IPCBoolean, IPCVoid> {
        private C33653b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(11180);
            if (((IPCBoolean) obj).value) {
                C2107c.m4321yK("jsapi_draw_canvas");
                AppMethodBeat.m2505o(11180);
                return;
            }
            C2107c.m4322yL("jsapi_draw_canvas");
            AppMethodBeat.m2505o(11180);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel$c */
    static class C33654c implements C37866a<IPCBoolean, IPCVoid> {
        private C33654c() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(11181);
            if (((IPCBoolean) obj).value) {
                C2107c.m4321yK("widget_launch");
                AppMethodBeat.m2505o(11181);
                return;
            }
            C2107c.m4322yL("widget_launch");
            AppMethodBeat.m2505o(11181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel$e */
    static class C33655e implements C45413i<IPCString, IPCString> {
        private C33655e() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(11183);
            IPCString iPCString = new IPCString(C2107c.m4320yJ(((IPCString) obj).value).toString());
            AppMethodBeat.m2505o(11183);
            return iPCString;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel$d */
    static class C45730d implements C37866a<IPCBoolean, IPCVoid> {
        private C45730d() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(11182);
            C2107c.m4316dG(((IPCBoolean) obj).value);
            AppMethodBeat.m2505o(11182);
        }
    }

    public PerformancePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(11184);
        init();
        AppMethodBeat.m2505o(11184);
    }

    public PerformancePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(11185);
        init();
        AppMethodBeat.m2505o(11185);
    }

    private void init() {
        AppMethodBeat.m2504i(11186);
        LayoutInflater.from(getContext()).inflate(2130970360, this, true);
        final TextView textView = (TextView) findViewById(2131826524);
        final View findViewById = findViewById(2131826523);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(11173);
                String stringBuilder = C2107c.m4320yJ("jsapi_draw_canvas").toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder != null && stringBuilder.length() > 0) {
                    stringBuilder2.append("data size :").append(C2107c.m4314bF("jsapi_draw_canvas", "__invoke_jsapi_data_size")).append(IOUtils.LINE_SEPARATOR_UNIX).append(stringBuilder);
                }
                IPCString iPCString = (IPCString) C9549f.m17010a("com.tencent.mm:support", new IPCString("widget_launch"), C33655e.class);
                if (iPCString != null) {
                    stringBuilder2.append("\n\n").append(iPCString);
                }
                if (C33128f.ayu()) {
                    stringBuilder2.append("\n\n").append(C33128f.ayv());
                }
                textView.setText(stringBuilder2.toString());
                AppMethodBeat.m2505o(11173);
            }
        });
        findViewById(2131820976).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(11174);
                C9549f.m17012a("com.tencent.mm:support", null, C2596a.class, null);
                C2107c.clear();
                C33128f.reset();
                textView.setText(C2107c.m4320yJ("jsapi_draw_canvas").toString());
                AppMethodBeat.m2505o(11174);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(2131826519);
        boolean ayt = C2107c.ayt();
        mMSwitchBtn.setCheck(ayt);
        mMSwitchBtn.setSwitchListener(new C30795a() {
            /* renamed from: di */
            public final void mo6646di(boolean z) {
                AppMethodBeat.m2504i(11175);
                C9549f.m17012a("com.tencent.mm:support", new IPCBoolean(z), C45730d.class, null);
                C2107c.m4316dG(z);
                findViewById.setEnabled(z);
                PerformancePanel.this.hpg.setEnabled(z);
                PerformancePanel.this.hph.setEnabled(z);
                PerformancePanel.this.hpi.setEnabled(z);
                AppMethodBeat.m2505o(11175);
            }
        });
        findViewById.setEnabled(ayt);
        this.hpg = (MMSwitchBtn) findViewById(2131826520);
        this.hpg.setEnabled(ayt);
        this.hpg.setCheck(C2107c.m4323yM("jsapi_draw_canvas"));
        this.hpg.setSwitchListener(new C313364());
        this.hph = (MMSwitchBtn) findViewById(2131826521);
        this.hph.setEnabled(ayt);
        this.hph.setCheck(C2107c.m4323yM("widget_launch"));
        this.hph.setSwitchListener(new C25955());
        this.hpi = (MMSwitchBtn) findViewById(2131826522);
        this.hpi.setEnabled(ayt);
        this.hpi.setCheck(C33128f.ayu());
        this.hpi.setSwitchListener(new C110586());
        AppMethodBeat.m2505o(11186);
    }
}
