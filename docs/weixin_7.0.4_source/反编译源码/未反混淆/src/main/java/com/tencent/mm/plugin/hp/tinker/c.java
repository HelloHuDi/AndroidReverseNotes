package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tinker.lib.d.a;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class c extends a {
    public c(Context context) {
        super(context);
    }

    public final void a(Throwable th, int i) {
        AppMethodBeat.i(90632);
        super.a(th, i);
        b.a(th, i);
        AppMethodBeat.o(90632);
    }

    public final void b(File file, int i) {
        AppMethodBeat.i(90633);
        super.b(file, i);
        b.xd(i);
        AppMethodBeat.o(90633);
    }

    public final void a(File file, int i, boolean z) {
        AppMethodBeat.i(90634);
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z));
        if (i == 4) {
            bGp();
        } else {
            dSf();
        }
        if (i == 1) {
            d dVar = com.tencent.tinker.lib.e.a.iX(this.context).ABJ;
            if (dVar.ABO != null && "00000000000000000000000000000000".equals(dVar.ABO)) {
                com.tencent.tinker.lib.util.a.e("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.jr(this.context);
            }
        }
        b.xc(i);
        AppMethodBeat.o(90634);
    }

    public final void b(int i, Throwable th) {
        AppMethodBeat.i(90635);
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i), th);
        switch (i) {
            case 0:
                com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                com.tencent.tinker.lib.util.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                com.tencent.tinker.lib.util.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        bGp();
        b.a(i, th);
        AppMethodBeat.o(90635);
    }

    public final void c(File file, int i) {
        AppMethodBeat.i(90636);
        super.c(file, i);
        b.t(ah.xzd, i);
        AppMethodBeat.o(90636);
    }

    public final void a(String str, String str2, File file) {
        AppMethodBeat.i(90637);
        super.a(str, str2, file);
        b.bGi();
        AppMethodBeat.o(90637);
    }

    public final void a(String str, String str2, File file, String str3) {
        AppMethodBeat.i(90638);
        super.a(str, str2, file, str3);
        b.bGj();
        AppMethodBeat.o(90638);
    }

    public final void a(File file, int i, long j) {
        String absolutePath;
        AppMethodBeat.i(90639);
        super.a(file, i, j);
        switch (i) {
            case 0:
                b.s(j, com.tencent.tinker.lib.e.a.iX(this.context).rNw);
                break;
        }
        if (com.tencent.tinker.lib.e.a.iX(this.context).rNw) {
            absolutePath = new File(SharePatchFileUtil.ji(this.context), "temp.apk").getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                com.tencent.tinker.lib.util.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
            } else {
                a aVar = new a(this.context, new a.a() {
                    public final void bGo() {
                        AppMethodBeat.i(90631);
                        if (com.tencent.tinker.lib.util.c.jc(c.this.context).dSj()) {
                            b.bGf();
                        }
                        AppMethodBeat.o(90631);
                    }
                });
            }
        } else {
            com.tencent.tinker.lib.util.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        }
        ab.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", Integer.valueOf(i), Long.valueOf(j));
        if (i == 0) {
            d dVar = com.tencent.tinker.lib.e.a.iX(this.context).ABJ;
            ab.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", dVar.ABO);
            if (!TextUtils.isEmpty(dVar.ABO)) {
                Context context = this.context;
                context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", dVar.ABO).apply();
            }
        }
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(this.context);
        if (iX.ABJ == null || iX.ABJ.ACb == null) {
            ab.i("Tinker.TinkerPatchLoadReporter", "patchCheck properties is null.");
            AppMethodBeat.o(90639);
            return;
        }
        int i2;
        String str = f.CLIENT_VERSION;
        absolutePath = (String) iX.ABJ.ACb.get("patch.client.ver");
        String str2 = (String) iX.ABJ.ACb.get("NEW_TINKER_ID");
        int i3 = b.b.SCENE_LOAD.value;
        if (i == 0) {
            i2 = b.a.SUCCESS.value;
        } else {
            i2 = b.a.FAILED.value;
        }
        b.e(str, absolutePath, str2, i3, i2);
        AppMethodBeat.o(90639);
    }

    public final void d(File file, int i) {
        AppMethodBeat.i(90640);
        super.d(file, i);
        if (i == -26 || i == -5) {
            ShareTinkerInternals.jm(this.context);
            com.tencent.tinker.lib.e.a.iX(this.context).tinkerFlags = 0;
        }
        b.wZ(i);
        AppMethodBeat.o(90640);
    }

    private void bGp() {
        AppMethodBeat.i(90641);
        a aVar = new a(this.context, new a.a() {
            public final void bGo() {
                AppMethodBeat.i(90630);
                if (c.this.dSg()) {
                    b.bGf();
                }
                AppMethodBeat.o(90630);
            }
        });
        AppMethodBeat.o(90641);
    }
}
