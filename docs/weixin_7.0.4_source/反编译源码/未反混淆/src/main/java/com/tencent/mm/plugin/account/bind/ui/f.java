package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;

public final class f implements com.tencent.mm.ai.f {
    Context context;
    private View gub = null;
    p guc = null;
    c gud = null;
    SecurityImage gue = null;
    String guf = "";
    private byte[] gug = null;
    private String guh = "";
    private String gui;
    private a guj;

    class b extends com.tencent.mm.ui.applet.SecurityImage.b {
        b() {
        }

        public final void apw() {
            AppMethodBeat.i(13756);
            f.this.Xy();
            g.Rg().a(new aa(5, f.this.guf, f.this.gue.getSecImgSid(), f.this.gue.getSecImgCode(), f.this.gue.getSecImgEncryptKey(), true, 1), 0);
            AppMethodBeat.o(13756);
        }
    }

    public interface a {
        void apu();

        boolean cL(int i, int i2);
    }

    public f(Context context, a aVar) {
        this.context = context;
        this.guj = aVar;
    }

    public final void Xy() {
        AppMethodBeat.i(13757);
        g.Rg().a(384, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(13757);
    }

    public final void onDetach() {
        AppMethodBeat.i(13758);
        g.Rg().b(384, (com.tencent.mm.ai.f) this);
        if (this.guj != null) {
            this.guj.apu();
        }
        AppMethodBeat.o(13758);
    }

    public final void apv() {
        AppMethodBeat.i(13759);
        this.gub = View.inflate(this.context, R.layout.ara, null);
        final EditText editText = (EditText) this.gub.findViewById(R.id.e90);
        editText.setHint(R.string.a8u);
        this.gud = h.a(this.context, this.context.getString(R.string.a8p), this.gub, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(13750);
                f.this.gud = null;
                f fVar = f.this;
                String trim = editText.getText().toString().trim();
                fVar.Xy();
                fVar.guf = trim;
                Context context = fVar.context;
                fVar.context.getString(R.string.tz);
                fVar.guc = h.b(context, fVar.context.getString(R.string.e3p), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(13752);
                        f.this.onDetach();
                        AppMethodBeat.o(13752);
                    }
                });
                g.Rg().a(new aa(5, fVar.guf, "", "", "", false, 1), 0);
                AppMethodBeat.o(13750);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(13751);
                f.this.gud = null;
                f.this.onDetach();
                AppMethodBeat.o(13751);
            }
        });
        AppMethodBeat.o(13759);
    }

    @TargetApi(17)
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(13760);
        onDetach();
        if (mVar == null || mVar.getType() != 384) {
            AppMethodBeat.o(13760);
            return;
        }
        byte[] a;
        if (this.guc != null) {
            this.guc.dismiss();
            this.guc = null;
        }
        this.guh = com.tencent.mm.platformtools.aa.a(((cna) ((aa) mVar).ehh.fsH.fsP).wtZ);
        aa aaVar = (aa) mVar;
        if (((cna) aaVar.ehh.fsH.fsP).vHJ == null || ((cna) aaVar.ehh.fsH.fsP).vHJ.getILen() <= 0) {
            a = com.tencent.mm.platformtools.aa.a(((cna) aaVar.ehh.fsH.fsP).vEF);
        } else {
            a = g.RN().QR().fs(aaVar.fPN);
        }
        this.gug = a;
        if (this.guj == null || !this.guj.cL(i, i2)) {
            if (this.context instanceof Activity) {
                Activity activity = (Activity) this.context;
                if (activity.isFinishing() || (VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
                    AppMethodBeat.o(13760);
                    return;
                }
            }
            com.tencent.mm.h.a jY;
            if (i == 4) {
                switch (i2) {
                    case -311:
                    case -310:
                    case -6:
                        if (g.RK()) {
                            if (this.gue == null) {
                                this.gue = com.tencent.mm.ui.applet.SecurityImage.a.a(this.context, 0, this.gug, this.guh, this.gui, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(13755);
                                        final m aaVar = new aa(5, f.this.guf, f.this.gue.getSecImgSid(), f.this.gue.getSecImgCode(), f.this.gue.getSecImgEncryptKey(), true, 1);
                                        f.this.Xy();
                                        g.Rg().a(aaVar, 0);
                                        f fVar = f.this;
                                        Context context = f.this.context;
                                        f.this.context.getString(R.string.tz);
                                        fVar.guc = h.b(context, f.this.context.getString(R.string.cou), true, new OnCancelListener() {
                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(13754);
                                                f.this.onDetach();
                                                g.Rg().c(aaVar);
                                                AppMethodBeat.o(13754);
                                            }
                                        });
                                        AppMethodBeat.o(13755);
                                    }
                                }, null, new OnDismissListener() {
                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        f.this.gue = null;
                                    }
                                }, new b());
                                AppMethodBeat.o(13760);
                                return;
                            }
                            this.gue.b(0, this.gug, this.guh, this.gui);
                        }
                        AppMethodBeat.o(13760);
                        return;
                    case -72:
                        this.gud = h.g(this.context, R.string.an5, R.string.tz);
                        AppMethodBeat.o(13760);
                        return;
                    case -34:
                        this.gud = h.b(this.context, this.context.getString(R.string.a8m), this.context.getString(R.string.tz), true);
                        AppMethodBeat.o(13760);
                        return;
                    case -3:
                        this.gud = h.a(this.context, this.context.getString(R.string.a8t), this.context.getString(R.string.tz), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(13753);
                                f.this.gud = null;
                                f.this.onDetach();
                                f.this.apv();
                                AppMethodBeat.o(13753);
                            }
                        }, null);
                        AppMethodBeat.o(13760);
                        return;
                    default:
                        jY = com.tencent.mm.h.a.jY(str);
                        if (jY != null) {
                            jY.a(this.context, null, null);
                            AppMethodBeat.o(13760);
                            return;
                        }
                        AppMethodBeat.o(13760);
                        return;
                }
            }
            jY = com.tencent.mm.h.a.jY(str);
            if (jY != null) {
                jY.a(this.context, null, null);
                AppMethodBeat.o(13760);
                return;
            }
            AppMethodBeat.o(13760);
            return;
        }
        AppMethodBeat.o(13760);
    }
}
