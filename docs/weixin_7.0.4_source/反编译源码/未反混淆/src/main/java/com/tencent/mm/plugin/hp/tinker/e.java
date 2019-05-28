package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class e extends b {
    public e(Context context) {
        super(context);
    }

    public final void ad(Intent intent) {
        AppMethodBeat.i(90650);
        super.ad(intent);
        com.tencent.mm.plugin.hp.b.b.ac(intent);
        AppMethodBeat.o(90650);
    }

    public final void a(File file, List<File> list, Throwable th) {
        AppMethodBeat.i(90651);
        super.a(file, (List) list, th);
        com.tencent.mm.plugin.hp.b.b.i(th);
        AppMethodBeat.o(90651);
    }

    public final void a(File file, Throwable th) {
        AppMethodBeat.i(90652);
        super.a(file, th);
        com.tencent.mm.plugin.hp.b.b.h(th);
        AppMethodBeat.o(90652);
    }

    public final void a(File file, String str, String str2) {
        AppMethodBeat.i(90653);
        super.a(file, str, str2);
        com.tencent.mm.plugin.hp.b.b.bGg();
        AppMethodBeat.o(90653);
    }

    public final void e(File file, int i) {
        AppMethodBeat.i(90654);
        super.e(file, i);
        com.tencent.mm.plugin.hp.b.b.xa(i);
        AppMethodBeat.o(90654);
    }

    public final void a(File file, boolean z, long j) {
        AppMethodBeat.i(90655);
        super.a(file, z, j);
        ab.i("Tinker.TinkerPatchReporter", "onPatchResult start");
        com.tencent.mm.plugin.hp.b.b.r(j, z);
        ab.dou();
        AppMethodBeat.o(90655);
    }

    public final void a(File file, File file2, String str, int i) {
        AppMethodBeat.i(90656);
        super.a(file, file2, str, i);
        com.tencent.mm.plugin.hp.b.b.xb(i);
        AppMethodBeat.o(90656);
    }

    public final void a(File file, SharePatchInfo sharePatchInfo, String str) {
        AppMethodBeat.i(90657);
        super.a(file, sharePatchInfo, str);
        com.tencent.mm.plugin.hp.b.b.bGh();
        AppMethodBeat.o(90657);
    }
}
