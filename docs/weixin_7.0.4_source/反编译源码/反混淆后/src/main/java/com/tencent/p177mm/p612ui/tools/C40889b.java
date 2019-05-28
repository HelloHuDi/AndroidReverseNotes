package com.tencent.p177mm.p612ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.plugin.p825a.C25808a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C32237a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.p201az.C37498c;
import com.tencent.p177mm.p230g.p231a.C26131ex;
import com.tencent.p177mm.p230g.p231a.C32514ah;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C40631p;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.ui.tools.b */
public final class C40889b {
    private static boolean isDeleteCancel = false;
    private static C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.ui.tools.b$2 */
    static class C159472 implements OnCancelListener {
        C159472() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(34786);
            C40889b.isDeleteCancel = true;
            AppMethodBeat.m2505o(34786);
        }
    }

    /* renamed from: a */
    public static void m70857a(C16527d c16527d, Activity activity, C7616ad c7616ad, int i) {
        AppMethodBeat.m2504i(34789);
        C40889b.m70859a(c16527d, activity, c7616ad, false, null, i);
        AppMethodBeat.m2505o(34789);
    }

    /* renamed from: a */
    public static void m70859a(C16527d c16527d, Activity activity, C7616ad c7616ad, boolean z, Runnable runnable, int i) {
        AppMethodBeat.m2504i(34790);
        if (c16527d == null || activity == null || c7616ad == null) {
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "bizInfo null : %s, context null : %s, ct null : %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(c16527d == null);
            objArr[1] = Boolean.valueOf(activity == null);
            objArr[2] = Boolean.valueOf(c7616ad == null);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(34790);
            return;
        }
        String string;
        if (c16527d.adQ()) {
            string = activity.getString(C25738R.string.ab_);
        } else {
            string = activity.getString(C25738R.string.aba, new Object[]{c7616ad.mo16707Oj()});
        }
        final C16527d c16527d2 = c16527d;
        final Activity activity2 = activity;
        final C7616ad c7616ad2 = c7616ad;
        final boolean z2 = z;
        final int i2 = i;
        final Runnable runnable2 = runnable;
        C30379h.m48444a((Context) activity, string, "", activity.getString(C25738R.string.azm), activity.getString(C25738R.string.azl), (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34785);
                C40889b.m70858a(c16527d2, activity2, c7616ad2, z2, i2);
                if (runnable2 != null) {
                    runnable2.run();
                }
                AppMethodBeat.m2505o(34785);
            }
        }, null, (int) C25738R.color.f12266xy);
        AppMethodBeat.m2505o(34790);
    }

    /* renamed from: c */
    public static void m70860c(C16527d c16527d, Activity activity, C7616ad c7616ad) {
        AppMethodBeat.m2504i(34791);
        C40889b.m70858a(c16527d, activity, c7616ad, false, 0);
        AppMethodBeat.m2505o(34791);
    }

    /* renamed from: a */
    public static void m70858a(final C16527d c16527d, Activity activity, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = true;
        AppMethodBeat.m2504i(34792);
        String str;
        if (c16527d == null || activity == null || c7616ad == null) {
            boolean z3;
            str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "error args, %b, %b, %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(c16527d == null);
            if (activity == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[1] = Boolean.valueOf(z3);
            if (c7616ad != null) {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(34792);
            return;
        }
        str = c7616ad.field_username;
        c7616ad.mo16677NC();
        C9638aw.m17190ZK();
        C18628c.m29077XL().mo7920c(new C37498c(str, i));
        if (C1855t.m3910mW(str)) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoU(str);
            C9638aw.m17190ZK();
            C18628c.m29087XV().mo14891og(str);
        } else {
            isDeleteCancel = false;
            activity.getString(C25738R.string.f9238tz);
            tipDialog = C30379h.m48458b((Context) activity, activity.getString(C25738R.string.f9260un), true, new C159472());
            C1827a c159483 = new C1827a() {
                /* renamed from: JU */
                public final boolean mo5405JU() {
                    AppMethodBeat.m2504i(34787);
                    boolean access$000 = C40889b.isDeleteCancel;
                    AppMethodBeat.m2505o(34787);
                    return access$000;
                }

                /* renamed from: JV */
                public final void mo5406JV() {
                    AppMethodBeat.m2504i(34788);
                    if (c16527d.adN()) {
                        C1720g.m3528K(C8939o.class);
                        C40631p.aok(str);
                        C32514ah c32514ah = new C32514ah();
                        c32514ah.ctf.userName = str;
                        C4879a.xxA.mo10055m(c32514ah);
                    }
                    C41747z.aeR().delete(str);
                    if (C40889b.tipDialog != null) {
                        C40889b.tipDialog.dismiss();
                        C40889b.tipDialog = null;
                    }
                    AppMethodBeat.m2505o(34788);
                }
            };
            C41747z.afd();
            C32237a.m52585qz(str);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(str, c7616ad);
            if (c16527d.adP()) {
                C17903f.m28112rf(c16527d.field_username);
            } else {
                C1829bf.m3741a(str, c159483);
                C9638aw.m17190ZK();
                C18628c.m29083XR().aoX(str);
            }
            if (activity != null && z) {
                activity.setResult(-1, activity.getIntent().putExtra("_delete_ok_", true));
            }
        }
        if (C25808a.m41064a(c16527d)) {
            C26131ex c26131ex = new C26131ex();
            c26131ex.cyr.cwz = str;
            C4879a.xxA.mo10055m(c26131ex);
        }
        C41747z.aeQ().mo67512ri(str);
        C41747z.aeX().mo64098QS(str);
        C41747z.aeY().mo39188QS(str);
        if (z) {
            int intExtra = activity.getIntent().getIntExtra("Kdel_from", -1);
            Intent intent;
            if (intExtra == 0) {
                intent = new Intent(activity, LauncherUI.class);
                intent.addFlags(67108864);
                activity.startActivity(intent);
            } else if (intExtra == 2) {
                intent = new Intent();
                intent.addFlags(67108864);
                C25985d.m41467b((Context) activity, "brandservice", ".ui.BrandServiceIndexUI", intent);
            }
            activity.finish();
        }
        AppMethodBeat.m2505o(34792);
    }
}
