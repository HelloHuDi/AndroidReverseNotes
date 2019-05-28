package com.tencent.p177mm.plugin.account.bind.p271ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C9703aa;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15494b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.cna;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.f */
public final class C26580f implements C1202f {
    Context context;
    private View gub = null;
    C44275p guc = null;
    C5653c gud = null;
    SecurityImage gue = null;
    String guf = "";
    private byte[] gug = null;
    private String guh = "";
    private String gui;
    private C26579a guj;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.f$4 */
    class C98734 implements OnClickListener {
        C98734() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13753);
            C26580f.this.gud = null;
            C26580f.this.onDetach();
            C26580f.this.apv();
            AppMethodBeat.m2505o(13753);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.f$6 */
    class C98746 implements OnDismissListener {
        C98746() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            C26580f.this.gue = null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.f$b */
    class C18816b extends C15494b {
        C18816b() {
        }

        public final void apw() {
            AppMethodBeat.m2504i(13756);
            C26580f.this.mo44356Xy();
            C1720g.m3540Rg().mo14541a(new C9703aa(5, C26580f.this.guf, C26580f.this.gue.getSecImgSid(), C26580f.this.gue.getSecImgCode(), C26580f.this.gue.getSecImgEncryptKey(), true, 1), 0);
            AppMethodBeat.m2505o(13756);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.f$3 */
    class C265763 implements OnCancelListener {
        C265763() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13752);
            C26580f.this.onDetach();
            AppMethodBeat.m2505o(13752);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.f$5 */
    class C265775 implements OnClickListener {
        C265775() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13755);
            final C1207m c9703aa = new C9703aa(5, C26580f.this.guf, C26580f.this.gue.getSecImgSid(), C26580f.this.gue.getSecImgCode(), C26580f.this.gue.getSecImgEncryptKey(), true, 1);
            C26580f.this.mo44356Xy();
            C1720g.m3540Rg().mo14541a(c9703aa, 0);
            C26580f c26580f = C26580f.this;
            Context context = C26580f.this.context;
            C26580f.this.context.getString(C25738R.string.f9238tz);
            c26580f.guc = C30379h.m48458b(context, C26580f.this.context.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(13754);
                    C26580f.this.onDetach();
                    C1720g.m3540Rg().mo14547c(c9703aa);
                    AppMethodBeat.m2505o(13754);
                }
            });
            AppMethodBeat.m2505o(13755);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.f$a */
    public interface C26579a {
        void apu();

        /* renamed from: cL */
        boolean mo34066cL(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.f$2 */
    class C265812 implements OnClickListener {
        C265812() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13751);
            C26580f.this.gud = null;
            C26580f.this.onDetach();
            AppMethodBeat.m2505o(13751);
        }
    }

    public C26580f(Context context, C26579a c26579a) {
        this.context = context;
        this.guj = c26579a;
    }

    /* renamed from: Xy */
    public final void mo44356Xy() {
        AppMethodBeat.m2504i(13757);
        C1720g.m3540Rg().mo14539a(384, (C1202f) this);
        AppMethodBeat.m2505o(13757);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(13758);
        C1720g.m3540Rg().mo14546b(384, (C1202f) this);
        if (this.guj != null) {
            this.guj.apu();
        }
        AppMethodBeat.m2505o(13758);
    }

    public final void apv() {
        AppMethodBeat.m2504i(13759);
        this.gub = View.inflate(this.context, 2130970616, null);
        final EditText editText = (EditText) this.gub.findViewById(2131827351);
        editText.setHint(C25738R.string.a8u);
        this.gud = C30379h.m48436a(this.context, this.context.getString(C25738R.string.a8p), this.gub, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13750);
                C26580f.this.gud = null;
                C26580f c26580f = C26580f.this;
                String trim = editText.getText().toString().trim();
                c26580f.mo44356Xy();
                c26580f.guf = trim;
                Context context = c26580f.context;
                c26580f.context.getString(C25738R.string.f9238tz);
                c26580f.guc = C30379h.m48458b(context, c26580f.context.getString(C25738R.string.e3p), true, new C265763());
                C1720g.m3540Rg().mo14541a(new C9703aa(5, c26580f.guf, "", "", "", false, 1), 0);
                AppMethodBeat.m2505o(13750);
            }
        }, new C265812());
        AppMethodBeat.m2505o(13759);
    }

    @TargetApi(17)
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13760);
        onDetach();
        if (c1207m == null || c1207m.getType() != 384) {
            AppMethodBeat.m2505o(13760);
            return;
        }
        byte[] a;
        if (this.guc != null) {
            this.guc.dismiss();
            this.guc = null;
        }
        this.guh = C1946aa.m4148a(((cna) ((C9703aa) c1207m).ehh.fsH.fsP).wtZ);
        C9703aa c9703aa = (C9703aa) c1207m;
        if (((cna) c9703aa.ehh.fsH.fsP).vHJ == null || ((cna) c9703aa.ehh.fsH.fsP).vHJ.getILen() <= 0) {
            a = C1946aa.m4150a(((cna) c9703aa.ehh.fsH.fsP).vEF);
        } else {
            a = C1720g.m3534RN().mo5158QR().mo4505fs(c9703aa.fPN);
        }
        this.gug = a;
        if (this.guj == null || !this.guj.mo34066cL(i, i2)) {
            if (this.context instanceof Activity) {
                Activity activity = (Activity) this.context;
                if (activity.isFinishing() || (VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
                    AppMethodBeat.m2505o(13760);
                    return;
                }
            }
            C42124a jY;
            if (i == 4) {
                switch (i2) {
                    case -311:
                    case -310:
                    case -6:
                        if (C1720g.m3531RK()) {
                            if (this.gue == null) {
                                this.gue = C15492a.m23811a(this.context, 0, this.gug, this.guh, this.gui, new C265775(), null, new C98746(), new C18816b());
                                AppMethodBeat.m2505o(13760);
                                return;
                            }
                            this.gue.mo27573b(0, this.gug, this.guh, this.gui);
                        }
                        AppMethodBeat.m2505o(13760);
                        return;
                    case -72:
                        this.gud = C30379h.m48467g(this.context, C25738R.string.an5, C25738R.string.f9238tz);
                        AppMethodBeat.m2505o(13760);
                        return;
                    case -34:
                        this.gud = C30379h.m48461b(this.context, this.context.getString(C25738R.string.a8m), this.context.getString(C25738R.string.f9238tz), true);
                        AppMethodBeat.m2505o(13760);
                        return;
                    case -3:
                        this.gud = C30379h.m48440a(this.context, this.context.getString(C25738R.string.a8t), this.context.getString(C25738R.string.f9238tz), new C98734(), null);
                        AppMethodBeat.m2505o(13760);
                        return;
                    default:
                        jY = C42124a.m74268jY(str);
                        if (jY != null) {
                            jY.mo67668a(this.context, null, null);
                            AppMethodBeat.m2505o(13760);
                            return;
                        }
                        AppMethodBeat.m2505o(13760);
                        return;
                }
            }
            jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(this.context, null, null);
                AppMethodBeat.m2505o(13760);
                return;
            }
            AppMethodBeat.m2505o(13760);
            return;
        }
        AppMethodBeat.m2505o(13760);
    }
}
