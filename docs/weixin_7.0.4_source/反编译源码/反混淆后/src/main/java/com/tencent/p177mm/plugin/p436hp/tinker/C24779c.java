package com.tencent.p177mm.plugin.p436hp.tinker;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b.C12240b;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b.C46027a;
import com.tencent.p177mm.plugin.p436hp.tinker.C43214a.C39253a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.tinker.lib.p1353d.C24433a;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C44553d;
import com.tencent.tinker.lib.util.C41089c;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.hp.tinker.c */
public final class C24779c extends C24433a {

    /* renamed from: com.tencent.mm.plugin.hp.tinker.c$1 */
    class C247801 implements C39253a {
        C247801() {
        }

        public final void bGo() {
            AppMethodBeat.m2504i(90630);
            if (C24779c.this.dSg()) {
                C46028b.bGf();
            }
            AppMethodBeat.m2505o(90630);
        }
    }

    /* renamed from: com.tencent.mm.plugin.hp.tinker.c$2 */
    class C247812 implements C39253a {
        C247812() {
        }

        public final void bGo() {
            AppMethodBeat.m2504i(90631);
            if (C41089c.m71517jc(C24779c.this.context).dSj()) {
                C46028b.bGf();
            }
            AppMethodBeat.m2505o(90631);
        }
    }

    public C24779c(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void mo40770a(Throwable th, int i) {
        AppMethodBeat.m2504i(90632);
        super.mo40770a(th, i);
        C46028b.m85594a(th, i);
        AppMethodBeat.m2505o(90632);
    }

    /* renamed from: b */
    public final void mo40772b(File file, int i) {
        AppMethodBeat.m2504i(90633);
        super.mo40772b(file, i);
        C46028b.m85610xd(i);
        AppMethodBeat.m2505o(90633);
    }

    /* renamed from: a */
    public final void mo40767a(File file, int i, boolean z) {
        AppMethodBeat.m2504i(90634);
        C5952a.m9284i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z));
        if (i == 4) {
            bGp();
        } else {
            dSf();
        }
        if (i == 1) {
            C44553d c44553d = C31097a.m50180iX(this.context).ABJ;
            if (c44553d.ABO != null && "00000000000000000000000000000000".equals(c44553d.ABO)) {
                C5952a.m9283e("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.m9426jr(this.context);
            }
        }
        C46028b.m85609xc(i);
        AppMethodBeat.m2505o(90634);
    }

    /* renamed from: b */
    public final void mo40771b(int i, Throwable th) {
        AppMethodBeat.m2504i(90635);
        C5952a.m9284i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i), th);
        switch (i) {
            case 0:
                C5952a.m9284i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                C5952a.m9283e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                C5952a.m9283e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        bGp();
        C46028b.m85593a(i, th);
        AppMethodBeat.m2505o(90635);
    }

    /* renamed from: c */
    public final void mo40773c(File file, int i) {
        AppMethodBeat.m2504i(90636);
        super.mo40773c(file, i);
        C46028b.m85602t(C4996ah.xzd, i);
        AppMethodBeat.m2505o(90636);
    }

    /* renamed from: a */
    public final void mo40768a(String str, String str2, File file) {
        AppMethodBeat.m2504i(90637);
        super.mo40768a(str, str2, file);
        C46028b.bGi();
        AppMethodBeat.m2505o(90637);
    }

    /* renamed from: a */
    public final void mo40769a(String str, String str2, File file, String str3) {
        AppMethodBeat.m2504i(90638);
        super.mo40769a(str, str2, file, str3);
        C46028b.bGj();
        AppMethodBeat.m2505o(90638);
    }

    /* renamed from: a */
    public final void mo40766a(File file, int i, long j) {
        String absolutePath;
        AppMethodBeat.m2504i(90639);
        super.mo40766a(file, i, j);
        switch (i) {
            case 0:
                C46028b.m85601s(j, C31097a.m50180iX(this.context).rNw);
                break;
        }
        if (C31097a.m50180iX(this.context).rNw) {
            absolutePath = new File(SharePatchFileUtil.m9384ji(this.context), "temp.apk").getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                C5952a.m9285w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
            } else {
                C43214a c43214a = new C43214a(this.context, new C247812());
            }
        } else {
            C5952a.m9285w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        }
        C4990ab.m7411d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", Integer.valueOf(i), Long.valueOf(j));
        if (i == 0) {
            C44553d c44553d = C31097a.m50180iX(this.context).ABJ;
            C4990ab.m7417i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", c44553d.ABO);
            if (!TextUtils.isEmpty(c44553d.ABO)) {
                Context context = this.context;
                context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", c44553d.ABO).apply();
            }
        }
        C31097a iX = C31097a.m50180iX(this.context);
        if (iX.ABJ == null || iX.ABJ.ACb == null) {
            C4990ab.m7416i("Tinker.TinkerPatchLoadReporter", "patchCheck properties is null.");
            AppMethodBeat.m2505o(90639);
            return;
        }
        int i2;
        String str = C5058f.CLIENT_VERSION;
        absolutePath = (String) iX.ABJ.ACb.get("patch.client.ver");
        String str2 = (String) iX.ABJ.ACb.get("NEW_TINKER_ID");
        int i3 = C12240b.SCENE_LOAD.value;
        if (i == 0) {
            i2 = C46027a.SUCCESS.value;
        } else {
            i2 = C46027a.FAILED.value;
        }
        C46028b.m85596e(str, absolutePath, str2, i3, i2);
        AppMethodBeat.m2505o(90639);
    }

    /* renamed from: d */
    public final void mo40774d(File file, int i) {
        AppMethodBeat.m2504i(90640);
        super.mo40774d(file, i);
        if (i == -26 || i == -5) {
            ShareTinkerInternals.m9421jm(this.context);
            C31097a.m50180iX(this.context).tinkerFlags = 0;
        }
        C46028b.m85606wZ(i);
        AppMethodBeat.m2505o(90640);
    }

    private void bGp() {
        AppMethodBeat.m2504i(90641);
        C43214a c43214a = new C43214a(this.context, new C247801());
        AppMethodBeat.m2505o(90641);
    }
}
