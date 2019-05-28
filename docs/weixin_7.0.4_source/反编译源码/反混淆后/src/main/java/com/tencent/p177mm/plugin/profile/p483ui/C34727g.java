package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p230g.p231a.C9379ic;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.profile.ui.g */
public final class C34727g extends C43388l implements C4937b {

    /* renamed from: com.tencent.mm.plugin.profile.ui.g$2 */
    class C347292 implements OnClickListener {
        C347292() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23521);
            C34727g.this.mo55336jP(false);
            AppMethodBeat.m2505o(23521);
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23531);
        super.mo10136a(i, c7298n, obj);
        AppMethodBeat.m2505o(23531);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        AppMethodBeat.m2504i(23530);
        boolean a = super.mo7078a(c15541f, c7616ad, z, i);
        AppMethodBeat.m2505o(23530);
        return a;
    }

    public final /* bridge */ /* synthetic */ boolean biV() {
        AppMethodBeat.m2504i(23529);
        boolean biV = super.biV();
        AppMethodBeat.m2505o(23529);
        return biV;
    }

    public final /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(23528);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(23528);
    }

    public C34727g(Context context) {
        super(context, new C21503r(context));
        AppMethodBeat.m2504i(23522);
        C4879a.xxA.mo10055m(new C9379ic());
        AppMethodBeat.m2505o(23522);
    }

    public static void clearData() {
        AppMethodBeat.m2504i(23523);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15254Rh("feedsapp");
        C9638aw.m17190ZK();
        C18628c.m29083XR().aoX("feedsapp");
        AppMethodBeat.m2505o(23523);
    }

    /* Access modifiers changed, original: protected|final */
    public final void clear() {
        AppMethodBeat.m2504i(23524);
        C34727g.clearData();
        AppMethodBeat.m2505o(23524);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: jP */
    public final void mo55336jP(final boolean z) {
        AppMethodBeat.m2504i(23525);
        Context context = this.context;
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        new C7564ap(new C5015a() {
            final /* synthetic */ C46692p ooo = null;

            /* renamed from: BI */
            public final boolean mo4499BI() {
                int i;
                AppMethodBeat.m2504i(23520);
                int YK = C1853r.m3829YK();
                if (z) {
                    i = YK & -32769;
                } else {
                    i = YK | 32768;
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    C34727g.clearData();
                }
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                if (b != null) {
                    b.dismiss();
                }
                AppMethodBeat.m2505o(23520);
                return true;
            }
        }, false).mo16770ae(1500, 1500);
        AppMethodBeat.m2505o(23525);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean caZ() {
        AppMethodBeat.m2504i(23526);
        if ((C1853r.m3829YK() & 32768) == 0) {
            AppMethodBeat.m2505o(23526);
            return true;
        }
        AppMethodBeat.m2505o(23526);
        return false;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23527);
        Intent intent;
        if ("contact_info_plugin_view".equals(str)) {
            intent = new Intent();
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            C25985d.m41467b(this.context, "sns", ".ui.SnsTimeLineUI", intent);
            AppMethodBeat.m2505o(23527);
            return true;
        }
        if ("contact_info_plugin_outsize".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            C25985d.m41467b(this.context, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if ("contact_info_plugin_black".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            C25985d.m41467b(this.context, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("contact_info_plugin_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_h), "", this.context.getString(C25738R.string.f9235tw), this.context.getString(C25738R.string.f9076or), new C347292(), null);
            AppMethodBeat.m2505o(23527);
            return true;
        }
        boolean IO = super.mo7077IO(str);
        AppMethodBeat.m2505o(23527);
        return IO;
    }
}
