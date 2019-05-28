package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class d {
    public static final int oIc = a.fromDPToPix(ah.getContext(), 8);
    public static final int oIi = a.fromDPToPix(ah.getContext(), 96);
    public static final int oIj = a.fromDPToPix(ah.getContext(), 76);
    public Intent intent;
    public e sYX;
    private Point sYY;
    private a sYZ;
    private ap sZa;

    static {
        AppMethodBeat.i(4979);
        AppMethodBeat.o(4979);
    }

    public final void a(final Intent intent, final a aVar) {
        AppMethodBeat.i(4973);
        if (aVar == null) {
            ab.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
            AppMethodBeat.o(4973);
            return;
        }
        this.intent = intent;
        this.sYZ = aVar;
        if (b.bF(ah.getContext())) {
            as(intent);
            AppMethodBeat.o(4973);
            return;
        }
        ab.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
        Context context = ah.getContext();
        RequestFloatWindowPermissionDialog.a(context, context.getString(R.string.f5n), new RequestFloatWindowPermissionDialog.a() {
            public final void a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.i(4969);
                requestFloatWindowPermissionDialog.finish();
                if (aVar.bGV()) {
                    d.a(d.this, intent);
                }
                AppMethodBeat.o(4969);
            }

            public final void b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.i(4970);
                requestFloatWindowPermissionDialog.finish();
                AppMethodBeat.o(4970);
            }
        });
        AppMethodBeat.o(4973);
    }

    private void as(final Intent intent) {
        AppMethodBeat.i(4974);
        ab.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
        if (this.sYX != null) {
            dismiss();
        }
        if (this.sYX == null) {
            this.sYX = new e(ah.getContext());
        }
        if (this.sZa != null) {
            this.sZa.stopTimer();
        }
        this.sYX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(4972);
                intent.addFlags(268435456);
                ah.getContext().startActivity(intent);
                view.setOnClickListener(null);
                d.this.sZa = new ap(new ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(4971);
                        ab.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
                        d.this.dismiss();
                        if (d.this.sZa != null) {
                            d.this.sZa.stopTimer();
                        }
                        AppMethodBeat.o(4971);
                        return true;
                    }
                }, false);
                d.this.sZa.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                AppMethodBeat.o(4972);
            }
        });
        WindowManager windowManager = (WindowManager) ah.getContext().getSystemService("window");
        LayoutParams layoutParams = new LayoutParams();
        if (com.tencent.mm.compatible.util.d.iW(26)) {
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
            int i = g.RP().Ry().getInt(327947, 0);
            int i2 = oIc;
            layoutParams.x = (a.gd(ah.getContext()) - layoutParams.width) - i2;
            layoutParams.y = i + i2;
        } else {
            layoutParams.x = this.sYY.x;
            layoutParams.y = this.sYY.y;
        }
        try {
            windowManager.addView(this.sYX, layoutParams);
        } catch (Exception e) {
            ab.e("MicroMsg.VoipVoiceMiniManager", "add failed", e);
        }
        this.sYZ.a(intent, this.sYX);
        AppMethodBeat.o(4974);
    }

    public final void Dq(int i) {
        AppMethodBeat.i(4975);
        if (this.sYX != null) {
            this.sYX.aca(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
        }
        AppMethodBeat.o(4975);
    }

    public final void abZ(String str) {
        AppMethodBeat.i(4976);
        if (this.sYX != null) {
            this.sYX.abZ(str);
        }
        AppMethodBeat.o(4976);
    }

    public final void dismiss() {
        AppMethodBeat.i(4977);
        ab.i("MicroMsg.VoipVoiceMiniManager", "dismiss now..");
        WindowManager windowManager = (WindowManager) ah.getContext().getSystemService("window");
        try {
            if (this.sYX != null) {
                LayoutParams layoutParams = (LayoutParams) this.sYX.getLayoutParams();
                this.sYY = new Point(layoutParams.x, layoutParams.y);
                windowManager.removeView(this.sYX);
                this.sYX.setOnClickListener(null);
                this.sYX = null;
            }
            AppMethodBeat.o(4977);
        } catch (Exception e) {
            ab.e("MicroMsg.VoipVoiceMiniManager", "remove failed", e);
            AppMethodBeat.o(4977);
        }
    }
}
