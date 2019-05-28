package com.tencent.p177mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p612ui.widget.picker.C40908b;
import com.tencent.p177mm.p612ui.widget.picker.C40908b.C40907a;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.C33173b;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel */
public class SettingsPanel extends FrameLayout {
    private Button jqg;
    private Button jqh;
    private OnClickListener jqi;
    private Runnable jqj;

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel$1 */
    class C110591 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel$1$1 */
        class C25971 implements Runnable {
            C25971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(11187);
                Toast.makeText(SettingsPanel.this.getContext(), C25738R.string.g3m, 1).show();
                if (SettingsPanel.this.jqj != null) {
                    SettingsPanel.this.jqj.run();
                }
                AppMethodBeat.m2505o(11187);
            }
        }

        C110591() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11188);
            ((C9687e) C1720g.m3528K(C9687e.class)).aby().restart();
            C26006a.m41507r(new C25971(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(11188);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel$2 */
    class C110602 implements C30795a {
        C110602() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(11189);
            ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33914cA(z);
            AppMethodBeat.m2505o(11189);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel$3 */
    class C110613 implements OnClickListener {
        C110613() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11191);
            ArrayList arrayList = new ArrayList();
            arrayList.add("MHADrawableView");
            arrayList.add("MTextureView");
            arrayList.add("MSurfaceView");
            arrayList.add("MCanvasView");
            arrayList.add("MDrawableView");
            final C40908b c40908b = new C40908b(SettingsPanel.this.getContext(), arrayList);
            c40908b.mo64522Qq(((Integer) SettingsPanel.this.jqg.getTag()).intValue());
            c40908b.zSq = new C40907a() {
                /* renamed from: d */
                public final void mo7219d(boolean z, Object obj) {
                    AppMethodBeat.m2504i(11190);
                    c40908b.hide();
                    if (z) {
                        SettingsPanel.this.jqg.setText((CharSequence) obj);
                    }
                    SettingsPanel.m18782a(SettingsPanel.this, c40908b.dLl());
                    AppMethodBeat.m2505o(11190);
                }
            };
            c40908b.mo64521Qp(C1338a.fromDPToPix(SettingsPanel.this.getContext(), C31128d.MIC_PTU_YOUJIALI));
            c40908b.show();
            AppMethodBeat.m2505o(11191);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel$4 */
    class C110634 implements OnClickListener {
        C110634() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11193);
            ArrayList arrayList = new ArrayList();
            arrayList.add("Normal");
            arrayList.add("Minimal-json");
            final C40908b c40908b = new C40908b(SettingsPanel.this.getContext(), arrayList);
            c40908b.mo64522Qq(((Integer) SettingsPanel.this.jqh.getTag()).intValue());
            c40908b.zSq = new C40907a() {
                /* renamed from: d */
                public final void mo7219d(boolean z, Object obj) {
                    AppMethodBeat.m2504i(11192);
                    c40908b.hide();
                    if (z) {
                        SettingsPanel.this.jqh.setText((CharSequence) obj);
                    }
                    SettingsPanel.m18784b(SettingsPanel.this, c40908b.dLl());
                    AppMethodBeat.m2505o(11192);
                }
            };
            c40908b.mo64521Qp(C1338a.fromDPToPix(SettingsPanel.this.getContext(), C31128d.MIC_PTU_YOUJIALI));
            c40908b.show();
            AppMethodBeat.m2505o(11193);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel$5 */
    class C110655 implements OnClickListener {
        C110655() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(11194);
            if (SettingsPanel.this.jqi != null) {
                SettingsPanel.this.jqi.onClick(view);
            }
            AppMethodBeat.m2505o(11194);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel$a */
    static class C11066a implements C37866a<IPCInteger, IPCVoid> {
        private C11066a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(11195);
            C41725h.m73456jM(((IPCInteger) obj).value);
            AppMethodBeat.m2505o(11195);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m18782a(SettingsPanel settingsPanel, int i) {
        AppMethodBeat.m2504i(11201);
        settingsPanel.m18787rf(i);
        AppMethodBeat.m2505o(11201);
    }

    /* renamed from: b */
    static /* synthetic */ void m18784b(SettingsPanel settingsPanel, int i) {
        AppMethodBeat.m2504i(11202);
        settingsPanel.m18788rg(i);
        AppMethodBeat.m2505o(11202);
    }

    public SettingsPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(11196);
        init();
        AppMethodBeat.m2505o(11196);
    }

    public SettingsPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(11197);
        init();
        AppMethodBeat.m2505o(11197);
    }

    private void init() {
        AppMethodBeat.m2504i(11198);
        LayoutInflater.from(getContext()).inflate(2130970639, this, true);
        findViewById(2131827404).setOnClickListener(new C110591());
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(2131827407);
        mMSwitchBtn.setCheck(((C9687e) C1720g.m3528K(C9687e.class)).abz().abE());
        mMSwitchBtn.setSwitchListener(new C110602());
        this.jqg = (Button) findViewById(2131827411);
        m18787rf(C33173b.aAl());
        this.jqg.setOnClickListener(new C110613());
        this.jqh = (Button) findViewById(2131827409);
        m18788rg(C41725h.m73453QE());
        this.jqh.setOnClickListener(new C110634());
        findViewById(2131827412).setOnClickListener(new C110655());
        if (((C9687e) C1720g.m3528K(C9687e.class)).abz().abF()) {
            findViewById(2131827406).setVisibility(0);
            findViewById(2131827410).setVisibility(0);
            findViewById(2131827408).setVisibility(0);
        }
        AppMethodBeat.m2505o(11198);
    }

    public void setOnCloseDebuggerClickListener(OnClickListener onClickListener) {
        this.jqi = onClickListener;
    }

    public void setOnResetDebuggerRunnable(Runnable runnable) {
        this.jqj = runnable;
    }

    /* renamed from: rf */
    private void m18787rf(int i) {
        AppMethodBeat.m2504i(11199);
        this.jqg.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                this.jqg.setText("MTextureView");
                C33173b.m54253nR(1);
                AppMethodBeat.m2505o(11199);
                return;
            case 2:
                this.jqg.setText("MSurfaceView");
                C33173b.m54253nR(2);
                AppMethodBeat.m2505o(11199);
                return;
            case 3:
                this.jqg.setText("MCanvasView");
                C33173b.m54253nR(3);
                AppMethodBeat.m2505o(11199);
                return;
            case 4:
                this.jqg.setText("MDrawableView");
                C33173b.m54253nR(4);
                AppMethodBeat.m2505o(11199);
                return;
            default:
                this.jqg.setText("MHADrawableView");
                C33173b.m54253nR(0);
                AppMethodBeat.m2505o(11199);
                return;
        }
    }

    /* renamed from: rg */
    private void m18788rg(int i) {
        CharSequence charSequence;
        int i2;
        AppMethodBeat.m2504i(11200);
        this.jqh.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                charSequence = "Minimal-json";
                i2 = 1;
                break;
            default:
                charSequence = "Normal";
                i2 = 0;
                break;
        }
        this.jqh.setText(charSequence);
        C41725h.m73456jM(i2);
        C9549f.m17012a("com.tencent.mm:support", new IPCInteger(i2), C11066a.class, null);
        AppMethodBeat.m2505o(11200);
    }
}
