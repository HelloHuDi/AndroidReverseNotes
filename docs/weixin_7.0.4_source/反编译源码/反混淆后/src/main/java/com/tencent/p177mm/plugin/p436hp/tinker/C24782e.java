package com.tencent.p177mm.plugin.p436hp.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tinker.lib.p1353d.C24434b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.hp.tinker.e */
public final class C24782e extends C24434b {
    public C24782e(Context context) {
        super(context);
    }

    /* renamed from: ad */
    public final void mo40783ad(Intent intent) {
        AppMethodBeat.m2504i(90650);
        super.mo40783ad(intent);
        C46028b.m85595ac(intent);
        AppMethodBeat.m2505o(90650);
    }

    /* renamed from: a */
    public final void mo40781a(File file, List<File> list, Throwable th) {
        AppMethodBeat.m2504i(90651);
        super.mo40781a(file, (List) list, th);
        C46028b.m85598i(th);
        AppMethodBeat.m2505o(90651);
    }

    /* renamed from: a */
    public final void mo40780a(File file, Throwable th) {
        AppMethodBeat.m2504i(90652);
        super.mo40780a(file, th);
        C46028b.m85597h(th);
        AppMethodBeat.m2505o(90652);
    }

    /* renamed from: a */
    public final void mo40779a(File file, String str, String str2) {
        AppMethodBeat.m2504i(90653);
        super.mo40779a(file, str, str2);
        C46028b.bGg();
        AppMethodBeat.m2505o(90653);
    }

    /* renamed from: e */
    public final void mo40784e(File file, int i) {
        AppMethodBeat.m2504i(90654);
        super.mo40784e(file, i);
        C46028b.m85607xa(i);
        AppMethodBeat.m2505o(90654);
    }

    /* renamed from: a */
    public final void mo40782a(File file, boolean z, long j) {
        AppMethodBeat.m2504i(90655);
        super.mo40782a(file, z, j);
        C4990ab.m7416i("Tinker.TinkerPatchReporter", "onPatchResult start");
        C46028b.m85600r(j, z);
        C4990ab.dou();
        AppMethodBeat.m2505o(90655);
    }

    /* renamed from: a */
    public final void mo40778a(File file, File file2, String str, int i) {
        AppMethodBeat.m2504i(90656);
        super.mo40778a(file, file2, str, i);
        C46028b.m85608xb(i);
        AppMethodBeat.m2505o(90656);
    }

    /* renamed from: a */
    public final void mo40777a(File file, SharePatchInfo sharePatchInfo, String str) {
        AppMethodBeat.m2504i(90657);
        super.mo40777a(file, sharePatchInfo, str);
        C46028b.bGh();
        AppMethodBeat.m2505o(90657);
    }
}
