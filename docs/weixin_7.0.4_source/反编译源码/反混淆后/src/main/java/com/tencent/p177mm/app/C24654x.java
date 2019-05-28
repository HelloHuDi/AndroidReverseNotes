package com.tencent.p177mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C17915b;
import com.tencent.p177mm.audio.p194a.C32297a;
import com.tencent.p177mm.booter.C41900n;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.modelmulti.C37942k;
import com.tencent.p177mm.modelmulti.C42210a;
import com.tencent.p177mm.modelmulti.C9692e;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C17891h;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p183ai.C41736i;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p189aq.C6320b;
import com.tencent.p177mm.p230g.p231a.C45369ta;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.p612ui.tools.C40889b;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12526d;
import com.tencent.p177mm.pluginsdk.C23244m;
import com.tencent.p177mm.pluginsdk.C44055j;
import com.tencent.p177mm.pluginsdk.C46490h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C46506q;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5135a;

/* renamed from: com.tencent.mm.app.x */
final class C24654x implements C41736i, C46490h, C44055j, C23244m {
    C24654x() {
    }

    /* renamed from: BS */
    public final void mo38844BS() {
        AppMethodBeat.m2504i(15424);
        C18668n.ahW().mo44216lN(7);
        AppMethodBeat.m2505o(15424);
    }

    /* renamed from: gk */
    public final void mo38869gk(int i) {
        AppMethodBeat.m2504i(15425);
        C4990ab.m7411d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", Integer.valueOf(i));
        C18668n.ahW().mo44216lN(i);
        AppMethodBeat.m2505o(15425);
    }

    /* renamed from: BT */
    public final C17891h mo41536BT() {
        AppMethodBeat.m2504i(15426);
        C32297a c32297a = new C32297a(C4996ah.getContext());
        AppMethodBeat.m2505o(15426);
        return c32297a;
    }

    /* renamed from: t */
    public final String mo38873t(String str, int i) {
        AppMethodBeat.m2504i(15427);
        String str2;
        if (C46494g.m87742dX(str, i) != null) {
            str2 = C46494g.m87742dX(str, i).field_packageName;
            AppMethodBeat.m2505o(15427);
            return str2;
        }
        str2 = "";
        AppMethodBeat.m2505o(15427);
        return str2;
    }

    /* renamed from: df */
    public final String mo38864df(String str) {
        AppMethodBeat.m2504i(15428);
        String str2;
        if (C46494g.m87739bT(str, false) != null) {
            str2 = C46494g.m87739bT(str, false).field_packageName;
            AppMethodBeat.m2505o(15428);
            return str2;
        }
        str2 = "";
        AppMethodBeat.m2505o(15428);
        return str2;
    }

    /* renamed from: t */
    public final String mo38872t(Context context, String str) {
        AppMethodBeat.m2504i(15429);
        String t = C46494g.m87756t(context, str);
        AppMethodBeat.m2505o(15429);
        return t;
    }

    /* renamed from: dg */
    public final boolean mo38865dg(String str) {
        AppMethodBeat.m2504i(15430);
        boolean dg = C46494g.m87743dg(str);
        AppMethodBeat.m2505o(15430);
        return dg;
    }

    /* renamed from: u */
    public final boolean mo38874u(Context context, String str) {
        AppMethodBeat.m2504i(15431);
        boolean u = C46494g.m87757u(context, str);
        AppMethodBeat.m2505o(15431);
        return u;
    }

    /* renamed from: f */
    public final String mo38868f(Context context, String str, String str2) {
        AppMethodBeat.m2504i(15432);
        String f = C35799p.m58693f(context, str, str2);
        AppMethodBeat.m2505o(15432);
        return f;
    }

    /* renamed from: B */
    public final String mo38843B(String str, String str2) {
        AppMethodBeat.m2504i(15433);
        String B = C35799p.m58684B(str, str2);
        AppMethodBeat.m2505o(15433);
        return B;
    }

    /* renamed from: a */
    public final void mo38855a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        AppMethodBeat.m2504i(15434);
        C43155a bDb = C20928a.bDb();
        if (bDb != null) {
            bDb.mo36273a(context, str, str2, str3, i, i2, i3, str4, str5, "");
        }
        AppMethodBeat.m2505o(15434);
    }

    /* renamed from: a */
    public final void mo38858a(String str, String str2, String str3, long j) {
        AppMethodBeat.m2504i(15435);
        C43155a bDb = C20928a.bDb();
        if (bDb != null) {
            bDb.mo36276a(str, str2, 2, 4, str3, j, "");
        }
        AppMethodBeat.m2505o(15435);
    }

    /* renamed from: BU */
    public final void mo38845BU() {
        AppMethodBeat.m2504i(15436);
        C45369ta c45369ta = new C45369ta();
        c45369ta.cPk.cPm = true;
        C4879a.xxA.mo10055m(c45369ta);
        AppMethodBeat.m2505o(15436);
    }

    /* renamed from: bj */
    public final C1207m mo38863bj(boolean z) {
        AppMethodBeat.m2504i(15437);
        if (z) {
            C41787r.aix().mo20546lT(4);
        }
        C1207m c45181k = new C45181k(4);
        C9638aw.m17182Rg().mo14541a(c45181k, 0);
        AppMethodBeat.m2505o(15437);
        return c45181k;
    }

    /* renamed from: dk */
    public final boolean mo38866dk(String str) {
        AppMethodBeat.m2504i(15438);
        boolean dk = C46494g.m87744dk(str);
        AppMethodBeat.m2505o(15438);
        return dk;
    }

    /* renamed from: a */
    public final boolean mo38859a(Context context, int i, int i2, String str) {
        AppMethodBeat.m2504i(15439);
        boolean a = C30784a.m49123a(context, i, i2, str, 4);
        AppMethodBeat.m2505o(15439);
        return a;
    }

    /* renamed from: b */
    public final boolean mo38861b(Context context, int i, int i2, String str) {
        AppMethodBeat.m2504i(15440);
        boolean a = C30784a.m49123a(context, i, i2, str, 7);
        AppMethodBeat.m2505o(15440);
        return a;
    }

    /* renamed from: BV */
    public final void mo38846BV() {
        AppMethodBeat.m2504i(15441);
        MMAppMgr.m7891BV();
        AppMethodBeat.m2505o(15441);
    }

    /* renamed from: o */
    public final boolean mo38870o(Activity activity) {
        AppMethodBeat.m2504i(15442);
        if (C1445f.m3070Mn()) {
            C14987n.m23322k(activity, 2);
            AppMethodBeat.m2505o(15442);
            return true;
        }
        C23639t.m36492hO(activity);
        AppMethodBeat.m2505o(15442);
        return false;
    }

    /* renamed from: bc */
    public final void mo38862bc(Context context) {
        AppMethodBeat.m2504i(15443);
        MMAppMgr.m7912hs(context);
        AppMethodBeat.m2505o(15443);
    }

    /* renamed from: p */
    public final void mo38871p(Activity activity) {
        AppMethodBeat.m2504i(15444);
        MMAppMgr.m7902ar(activity);
        AppMethodBeat.m2505o(15444);
    }

    /* renamed from: a */
    public final Bitmap mo38851a(Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(15445);
        if (i2 != -1) {
            AppMethodBeat.m2505o(15445);
            return null;
        }
        String h;
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.m2505o(15445);
                    return null;
                }
                Intent intent2 = new Intent();
                intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_OutputPath", C6457e.euY + "temp.avatar");
                intent2.putExtra("CropImage_ImgPath", null);
                C36338a.m59822a(activity, intent, intent2, C6457e.euY, 4);
                AppMethodBeat.m2505o(15445);
                return null;
            case 3:
                h = C14987n.m23320h(activity.getApplicationContext(), intent, C6457e.euY);
                if (h == null) {
                    AppMethodBeat.m2505o(15445);
                    return null;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", C6457e.euY + "temp.avatar");
                intent3.putExtra("CropImage_ImgPath", h);
                activity.startActivityForResult(intent3, 4);
                AppMethodBeat.m2505o(15445);
                return null;
            case 4:
                if (intent == null) {
                    AppMethodBeat.m2505o(15445);
                    return null;
                }
                h = intent.getStringExtra("CropImage_OutputPath");
                if (h == null) {
                    C4990ab.m7412e("MicroMsg.WorkerModelCallback", "crop picture failed");
                    break;
                }
                C4990ab.m7413e("MicroMsg.WorkerModelCallback", "crop picture path %s ", h);
                Bitmap aml = C5056d.aml(h);
                AppMethodBeat.m2505o(15445);
                return aml;
        }
        AppMethodBeat.m2505o(15445);
        return null;
    }

    /* renamed from: BW */
    public final Intent mo38847BW() {
        AppMethodBeat.m2504i(15446);
        Intent intent = new Intent(C4996ah.getContext(), LauncherUI.class);
        intent.putExtra("nofification_type", "talkroom_notification");
        intent.addFlags(67108864);
        AppMethodBeat.m2505o(15446);
        return intent;
    }

    /* renamed from: a */
    public final C1207m mo38852a(C32231g c32231g) {
        AppMethodBeat.m2504i(15447);
        if (C37942k.ahT()) {
            C9692e c9692e = new C9692e(c32231g);
            AppMethodBeat.m2505o(15447);
            return c9692e;
        }
        C18668n.ahW().mo44216lN(4);
        AppMethodBeat.m2505o(15447);
        return null;
    }

    /* renamed from: a */
    public final boolean mo38860a(C7616ad c7616ad) {
        AppMethodBeat.m2504i(15448);
        boolean a = C42210a.m74470a(c7616ad);
        AppMethodBeat.m2505o(15448);
        return a;
    }

    /* renamed from: a */
    public final void mo41539a(C16527d c16527d, Activity activity, C7616ad c7616ad, boolean z, Runnable runnable) {
        AppMethodBeat.m2504i(15449);
        C40889b.m70859a(c16527d, activity, c7616ad, z, runnable, 0);
        AppMethodBeat.m2505o(15449);
    }

    /* renamed from: a */
    public final void mo41538a(C16527d c16527d, Activity activity, C7616ad c7616ad) {
        AppMethodBeat.m2504i(15450);
        C40889b.m70860c(c16527d, activity, c7616ad);
        AppMethodBeat.m2505o(15450);
    }

    /* renamed from: BX */
    public final boolean mo38848BX() {
        AppMethodBeat.m2504i(15451);
        boolean BX = C46506q.m87789BX();
        AppMethodBeat.m2505o(15451);
        return BX;
    }

    /* renamed from: BY */
    public final void mo38849BY() {
        AppMethodBeat.m2504i(15453);
        C41900n.m74000BY();
        AppMethodBeat.m2505o(15453);
    }

    /* renamed from: a */
    public final void mo38854a(Context context, C5135a c5135a, Bundle bundle) {
        AppMethodBeat.m2504i(15454);
        C36249e.m59676a(context, c5135a, true, true, bundle);
        AppMethodBeat.m2505o(15454);
    }

    /* renamed from: a */
    public final void mo38853a(Context context, C7616ad c7616ad, C5135a c5135a, Bundle bundle, String str) {
        AppMethodBeat.m2504i(15455);
        C36249e.m59674a(context, c7616ad, c5135a, true, true, bundle, str);
        AppMethodBeat.m2505o(15455);
    }

    /* renamed from: a */
    public final void mo38856a(Intent intent, String str) {
        AppMethodBeat.m2504i(15456);
        C36249e.m59677a(intent, str);
        AppMethodBeat.m2505o(15456);
    }

    /* renamed from: dl */
    public final void mo38867dl(String str) {
        AppMethodBeat.m2504i(15457);
        C6320b.agG();
        C6320b.m10398rX(str);
        AppMethodBeat.m2505o(15457);
    }

    /* renamed from: a */
    public final void mo38857a(bbv bbv, String str) {
        AppMethodBeat.m2504i(15458);
        ((C12526d) C1720g.m3528K(C12526d.class)).mo24449a(bbv, str);
        AppMethodBeat.m2505o(15458);
    }

    /* renamed from: BZ */
    public final boolean mo38850BZ() {
        AppMethodBeat.m2504i(15459);
        boolean ahT = C37942k.ahT();
        AppMethodBeat.m2505o(15459);
        return ahT;
    }

    /* renamed from: a */
    public final void mo41537a(Intent intent, buv buv, int i) {
        AppMethodBeat.m2504i(15452);
        C17915b.m28130a(intent, buv, i);
        AppMethodBeat.m2505o(15452);
    }
}
