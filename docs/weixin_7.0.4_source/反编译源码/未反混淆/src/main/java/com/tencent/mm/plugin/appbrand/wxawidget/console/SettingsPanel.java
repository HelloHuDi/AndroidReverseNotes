package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aa.h;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.d;
import java.util.ArrayList;

public class SettingsPanel extends FrameLayout {
    private Button jqg;
    private Button jqh;
    private OnClickListener jqi;
    private Runnable jqj;

    static class a implements com.tencent.mm.ipcinvoker.a<IPCInteger, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(11195);
            h.jM(((IPCInteger) obj).value);
            AppMethodBeat.o(11195);
        }
    }

    static /* synthetic */ void a(SettingsPanel settingsPanel, int i) {
        AppMethodBeat.i(11201);
        settingsPanel.rf(i);
        AppMethodBeat.o(11201);
    }

    static /* synthetic */ void b(SettingsPanel settingsPanel, int i) {
        AppMethodBeat.i(11202);
        settingsPanel.rg(i);
        AppMethodBeat.o(11202);
    }

    public SettingsPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(11196);
        init();
        AppMethodBeat.o(11196);
    }

    public SettingsPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(11197);
        init();
        AppMethodBeat.o(11197);
    }

    private void init() {
        AppMethodBeat.i(11198);
        LayoutInflater.from(getContext()).inflate(R.layout.arx, this, true);
        findViewById(R.id.e_f).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11188);
                ((e) g.K(e.class)).aby().restart();
                com.tencent.mm.ce.a.r(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(11187);
                        Toast.makeText(SettingsPanel.this.getContext(), R.string.g3m, 1).show();
                        if (SettingsPanel.this.jqj != null) {
                            SettingsPanel.this.jqj.run();
                        }
                        AppMethodBeat.o(11187);
                    }
                }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                AppMethodBeat.o(11188);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.e_i);
        mMSwitchBtn.setCheck(((e) g.K(e.class)).abz().abE());
        mMSwitchBtn.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(11189);
                ((e) g.K(e.class)).abz().cA(z);
                AppMethodBeat.o(11189);
            }
        });
        this.jqg = (Button) findViewById(R.id.e_m);
        rf(b.aAl());
        this.jqg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11191);
                ArrayList arrayList = new ArrayList();
                arrayList.add("MHADrawableView");
                arrayList.add("MTextureView");
                arrayList.add("MSurfaceView");
                arrayList.add("MCanvasView");
                arrayList.add("MDrawableView");
                final com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(SettingsPanel.this.getContext(), arrayList);
                bVar.Qq(((Integer) SettingsPanel.this.jqg.getTag()).intValue());
                bVar.zSq = new com.tencent.mm.ui.widget.picker.b.a() {
                    public final void d(boolean z, Object obj) {
                        AppMethodBeat.i(11190);
                        bVar.hide();
                        if (z) {
                            SettingsPanel.this.jqg.setText((CharSequence) obj);
                        }
                        SettingsPanel.a(SettingsPanel.this, bVar.dLl());
                        AppMethodBeat.o(11190);
                    }
                };
                bVar.Qp(com.tencent.mm.bz.a.fromDPToPix(SettingsPanel.this.getContext(), d.MIC_PTU_YOUJIALI));
                bVar.show();
                AppMethodBeat.o(11191);
            }
        });
        this.jqh = (Button) findViewById(R.id.e_k);
        rg(h.QE());
        this.jqh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11193);
                ArrayList arrayList = new ArrayList();
                arrayList.add("Normal");
                arrayList.add("Minimal-json");
                final com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(SettingsPanel.this.getContext(), arrayList);
                bVar.Qq(((Integer) SettingsPanel.this.jqh.getTag()).intValue());
                bVar.zSq = new com.tencent.mm.ui.widget.picker.b.a() {
                    public final void d(boolean z, Object obj) {
                        AppMethodBeat.i(11192);
                        bVar.hide();
                        if (z) {
                            SettingsPanel.this.jqh.setText((CharSequence) obj);
                        }
                        SettingsPanel.b(SettingsPanel.this, bVar.dLl());
                        AppMethodBeat.o(11192);
                    }
                };
                bVar.Qp(com.tencent.mm.bz.a.fromDPToPix(SettingsPanel.this.getContext(), d.MIC_PTU_YOUJIALI));
                bVar.show();
                AppMethodBeat.o(11193);
            }
        });
        findViewById(R.id.e_n).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(11194);
                if (SettingsPanel.this.jqi != null) {
                    SettingsPanel.this.jqi.onClick(view);
                }
                AppMethodBeat.o(11194);
            }
        });
        if (((e) g.K(e.class)).abz().abF()) {
            findViewById(R.id.e_h).setVisibility(0);
            findViewById(R.id.e_l).setVisibility(0);
            findViewById(R.id.e_j).setVisibility(0);
        }
        AppMethodBeat.o(11198);
    }

    public void setOnCloseDebuggerClickListener(OnClickListener onClickListener) {
        this.jqi = onClickListener;
    }

    public void setOnResetDebuggerRunnable(Runnable runnable) {
        this.jqj = runnable;
    }

    private void rf(int i) {
        AppMethodBeat.i(11199);
        this.jqg.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                this.jqg.setText("MTextureView");
                b.nR(1);
                AppMethodBeat.o(11199);
                return;
            case 2:
                this.jqg.setText("MSurfaceView");
                b.nR(2);
                AppMethodBeat.o(11199);
                return;
            case 3:
                this.jqg.setText("MCanvasView");
                b.nR(3);
                AppMethodBeat.o(11199);
                return;
            case 4:
                this.jqg.setText("MDrawableView");
                b.nR(4);
                AppMethodBeat.o(11199);
                return;
            default:
                this.jqg.setText("MHADrawableView");
                b.nR(0);
                AppMethodBeat.o(11199);
                return;
        }
    }

    private void rg(int i) {
        CharSequence charSequence;
        int i2;
        AppMethodBeat.i(11200);
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
        h.jM(i2);
        f.a("com.tencent.mm:support", new IPCInteger(i2), a.class, null);
        AppMethodBeat.o(11200);
    }
}
