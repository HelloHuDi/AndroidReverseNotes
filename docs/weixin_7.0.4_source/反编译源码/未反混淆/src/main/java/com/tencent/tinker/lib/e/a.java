package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a {
    private static a ABA;
    public static boolean ABB = false;
    public final File ABC;
    final b ABD;
    public final c ABE;
    public final d ABF;
    public final File ABG;
    public final File ABH;
    public final boolean ABI;
    public d ABJ;
    public boolean ABK;
    public final Context context;
    public final boolean rNw;
    public int tinkerFlags;
    final boolean tinkerLoadVerifyFlag;

    public static class a {
        private File ABC;
        public b ABD;
        public c ABE;
        public d ABF;
        private File ABG;
        private File ABH;
        private final boolean ABL;
        private final boolean ABM;
        public Boolean ABN;
        private final Context context;
        public int status = -1;

        public a(Context context) {
            if (context == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.context = context;
            this.ABL = ShareTinkerInternals.jp(context);
            this.ABM = com.tencent.tinker.lib.util.b.jb(context);
            this.ABC = SharePatchFileUtil.jh(context);
            if (this.ABC == null) {
                com.tencent.tinker.lib.util.a.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
                return;
            }
            this.ABG = SharePatchFileUtil.auo(this.ABC.getAbsolutePath());
            this.ABH = SharePatchFileUtil.aup(this.ABC.getAbsolutePath());
            com.tencent.tinker.lib.util.a.w("Tinker.Tinker", "tinker patch directory: %s", this.ABC);
        }

        public final a dSh() {
            if (this.status == -1) {
                this.status = 7;
            }
            if (this.ABE == null) {
                this.ABE = new com.tencent.tinker.lib.d.a(this.context);
            }
            if (this.ABF == null) {
                this.ABF = new com.tencent.tinker.lib.d.b(this.context);
            }
            if (this.ABD == null) {
                this.ABD = new com.tencent.tinker.lib.b.a(this.context);
            }
            if (this.ABN == null) {
                this.ABN = Boolean.FALSE;
            }
            return new a(this.context, this.status, this.ABE, this.ABF, this.ABD, this.ABC, this.ABG, this.ABH, this.ABL, this.ABM, this.ABN.booleanValue(), (byte) 0);
        }
    }

    /* synthetic */ a(Context context, int i, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3, byte b) {
        this(context, i, cVar, dVar, bVar, file, file2, file3, z, z2, z3);
    }

    private a(Context context, int i, c cVar, d dVar, b bVar, File file, File file2, File file3, boolean z, boolean z2, boolean z3) {
        this.ABK = false;
        this.context = context;
        this.ABD = bVar;
        this.ABE = cVar;
        this.ABF = dVar;
        this.tinkerFlags = i;
        this.ABC = file;
        this.ABG = file2;
        this.ABH = file3;
        this.rNw = z;
        this.tinkerLoadVerifyFlag = z3;
        this.ABI = z2;
    }

    public static a iX(Context context) {
        if (ABB) {
            synchronized (a.class) {
                if (ABA == null) {
                    ABA = new a(context).dSh();
                }
            }
            return ABA;
        }
        throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }

    public static void a(a aVar) {
        if (ABA != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        ABA = aVar;
    }

    public final void bGr() {
        if (this.ABC != null) {
            File auo = SharePatchFileUtil.auo(this.ABC.getAbsolutePath());
            if (auo.exists()) {
                File aup = SharePatchFileUtil.aup(this.ABC.getAbsolutePath());
                SharePatchInfo l = SharePatchInfo.l(auo, aup);
                if (l != null) {
                    l.AET = true;
                    SharePatchInfo.a(auo, l, aup);
                    return;
                }
                return;
            }
            com.tencent.tinker.lib.util.a.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        }
    }

    private void auj(String str) {
        if (this.ABC != null && str != null) {
            SharePatchFileUtil.cu(this.ABC.getAbsolutePath() + "/" + str);
        }
    }

    public final void ak(File file) {
        if (this.ABC != null && file != null && file.exists()) {
            auj(SharePatchFileUtil.auq(SharePatchFileUtil.at(file)));
        }
    }
}
