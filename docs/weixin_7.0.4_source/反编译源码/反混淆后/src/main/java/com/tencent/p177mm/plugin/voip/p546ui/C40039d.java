package com.tencent.p177mm.plugin.voip.p546ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.p177mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.C30091a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.voip.ui.d */
public final class C40039d {
    public static final int oIc = C1338a.fromDPToPix(C4996ah.getContext(), 8);
    public static final int oIi = C1338a.fromDPToPix(C4996ah.getContext(), 96);
    public static final int oIj = C1338a.fromDPToPix(C4996ah.getContext(), 76);
    public Intent intent;
    public C46928e sYX;
    private Point sYY;
    private C14084a sYZ;
    private C7564ap sZa;

    static {
        AppMethodBeat.m2504i(4979);
        AppMethodBeat.m2505o(4979);
    }

    /* renamed from: a */
    public final void mo63354a(final Intent intent, final C14084a c14084a) {
        AppMethodBeat.m2504i(4973);
        if (c14084a == null) {
            C4990ab.m7412e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
            AppMethodBeat.m2505o(4973);
            return;
        }
        this.intent = intent;
        this.sYZ = c14084a;
        if (C37657b.m63684bF(C4996ah.getContext())) {
            m68607as(intent);
            AppMethodBeat.m2505o(4973);
            return;
        }
        C4990ab.m7412e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
        Context context = C4996ah.getContext();
        RequestFloatWindowPermissionDialog.m58702a(context, context.getString(C25738R.string.f5n), new C30091a() {
            /* renamed from: a */
            public final void mo38035a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.m2504i(4969);
                requestFloatWindowPermissionDialog.finish();
                if (c14084a.bGV()) {
                    C40039d.m68606a(C40039d.this, intent);
                }
                AppMethodBeat.m2505o(4969);
            }

            /* renamed from: b */
            public final void mo38036b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.m2504i(4970);
                requestFloatWindowPermissionDialog.finish();
                AppMethodBeat.m2505o(4970);
            }
        });
        AppMethodBeat.m2505o(4973);
    }

    /* renamed from: as */
    private void m68607as(final Intent intent) {
        AppMethodBeat.m2504i(4974);
        C4990ab.m7416i("MicroMsg.VoipVoiceMiniManager", "mini now..");
        if (this.sYX != null) {
            dismiss();
        }
        if (this.sYX == null) {
            this.sYX = new C46928e(C4996ah.getContext());
        }
        if (this.sZa != null) {
            this.sZa.stopTimer();
        }
        this.sYX.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.voip.ui.d$2$1 */
            class C140861 implements C5015a {
                C140861() {
                }

                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(4971);
                    C4990ab.m7416i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
                    C40039d.this.dismiss();
                    if (C40039d.this.sZa != null) {
                        C40039d.this.sZa.stopTimer();
                    }
                    AppMethodBeat.m2505o(4971);
                    return true;
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(4972);
                intent.addFlags(268435456);
                C4996ah.getContext().startActivity(intent);
                view.setOnClickListener(null);
                C40039d.this.sZa = new C7564ap(new C140861(), false);
                C40039d.this.sZa.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                AppMethodBeat.m2505o(4972);
            }
        });
        WindowManager windowManager = (WindowManager) C4996ah.getContext().getSystemService("window");
        LayoutParams layoutParams = new LayoutParams();
        if (C1443d.m3068iW(26)) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = oIj;
        layoutParams.height = oIi;
        if (this.sYY == null) {
            int i = C1720g.m3536RP().mo5239Ry().getInt(327947, 0);
            int i2 = oIc;
            layoutParams.x = (C1338a.m2868gd(C4996ah.getContext()) - layoutParams.width) - i2;
            layoutParams.y = i + i2;
        } else {
            layoutParams.x = this.sYY.x;
            layoutParams.y = this.sYY.y;
        }
        try {
            windowManager.addView(this.sYX, layoutParams);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.VoipVoiceMiniManager", "add failed", e);
        }
        this.sYZ.mo24609a(intent, this.sYX);
        AppMethodBeat.m2505o(4974);
    }

    /* renamed from: Dq */
    public final void mo63353Dq(int i) {
        AppMethodBeat.m2504i(4975);
        if (this.sYX != null) {
            this.sYX.aca(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
        }
        AppMethodBeat.m2505o(4975);
    }

    public final void abZ(String str) {
        AppMethodBeat.m2504i(4976);
        if (this.sYX != null) {
            this.sYX.abZ(str);
        }
        AppMethodBeat.m2505o(4976);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(4977);
        C4990ab.m7416i("MicroMsg.VoipVoiceMiniManager", "dismiss now..");
        WindowManager windowManager = (WindowManager) C4996ah.getContext().getSystemService("window");
        try {
            if (this.sYX != null) {
                LayoutParams layoutParams = (LayoutParams) this.sYX.getLayoutParams();
                this.sYY = new Point(layoutParams.x, layoutParams.y);
                windowManager.removeView(this.sYX);
                this.sYX.setOnClickListener(null);
                this.sYX = null;
            }
            AppMethodBeat.m2505o(4977);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.VoipVoiceMiniManager", "remove failed", e);
            AppMethodBeat.m2505o(4977);
        }
    }
}
