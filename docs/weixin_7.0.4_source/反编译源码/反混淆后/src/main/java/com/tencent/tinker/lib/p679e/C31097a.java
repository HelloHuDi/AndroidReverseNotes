package com.tencent.tinker.lib.p679e;

import android.content.Context;
import com.tencent.tinker.lib.p1353d.C24433a;
import com.tencent.tinker.lib.p1353d.C24434b;
import com.tencent.tinker.lib.p1353d.C36551c;
import com.tencent.tinker.lib.p1353d.C41088d;
import com.tencent.tinker.lib.p1577b.C41087b;
import com.tencent.tinker.lib.p1577b.C46816a;
import com.tencent.tinker.lib.util.C31098b;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* renamed from: com.tencent.tinker.lib.e.a */
public class C31097a {
    private static C31097a ABA;
    public static boolean ABB = false;
    public final File ABC;
    final C41087b ABD;
    public final C36551c ABE;
    public final C41088d ABF;
    public final File ABG;
    public final File ABH;
    public final boolean ABI;
    public C44553d ABJ;
    public boolean ABK;
    public final Context context;
    public final boolean rNw;
    public int tinkerFlags;
    final boolean tinkerLoadVerifyFlag;

    /* renamed from: com.tencent.tinker.lib.e.a$a */
    public static class C31096a {
        private File ABC;
        public C41087b ABD;
        public C36551c ABE;
        public C41088d ABF;
        private File ABG;
        private File ABH;
        private final boolean ABL;
        private final boolean ABM;
        public Boolean ABN;
        private final Context context;
        public int status = -1;

        public C31096a(Context context) {
            if (context == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.context = context;
            this.ABL = ShareTinkerInternals.m9424jp(context);
            this.ABM = C31098b.m50189jb(context);
            this.ABC = SharePatchFileUtil.m9383jh(context);
            if (this.ABC == null) {
                C5952a.m9283e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
                return;
            }
            this.ABG = SharePatchFileUtil.auo(this.ABC.getAbsolutePath());
            this.ABH = SharePatchFileUtil.aup(this.ABC.getAbsolutePath());
            C5952a.m9285w("Tinker.Tinker", "tinker patch directory: %s", this.ABC);
        }

        public final C31097a dSh() {
            if (this.status == -1) {
                this.status = 7;
            }
            if (this.ABE == null) {
                this.ABE = new C24433a(this.context);
            }
            if (this.ABF == null) {
                this.ABF = new C24434b(this.context);
            }
            if (this.ABD == null) {
                this.ABD = new C46816a(this.context);
            }
            if (this.ABN == null) {
                this.ABN = Boolean.FALSE;
            }
            return new C31097a(this.context, this.status, this.ABE, this.ABF, this.ABD, this.ABC, this.ABG, this.ABH, this.ABL, this.ABM, this.ABN.booleanValue(), (byte) 0);
        }
    }

    /* synthetic */ C31097a(Context context, int i, C36551c c36551c, C41088d c41088d, C41087b c41087b, File file, File file2, File file3, boolean z, boolean z2, boolean z3, byte b) {
        this(context, i, c36551c, c41088d, c41087b, file, file2, file3, z, z2, z3);
    }

    private C31097a(Context context, int i, C36551c c36551c, C41088d c41088d, C41087b c41087b, File file, File file2, File file3, boolean z, boolean z2, boolean z3) {
        this.ABK = false;
        this.context = context;
        this.ABD = c41087b;
        this.ABE = c36551c;
        this.ABF = c41088d;
        this.tinkerFlags = i;
        this.ABC = file;
        this.ABG = file2;
        this.ABH = file3;
        this.rNw = z;
        this.tinkerLoadVerifyFlag = z3;
        this.ABI = z2;
    }

    /* renamed from: iX */
    public static C31097a m50180iX(Context context) {
        if (ABB) {
            synchronized (C31097a.class) {
                if (ABA == null) {
                    ABA = new C31096a(context).dSh();
                }
            }
            return ABA;
        }
        throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }

    /* renamed from: a */
    public static void m50179a(C31097a c31097a) {
        if (ABA != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        ABA = c31097a;
    }

    public final void bGr() {
        if (this.ABC != null) {
            File auo = SharePatchFileUtil.auo(this.ABC.getAbsolutePath());
            if (auo.exists()) {
                File aup = SharePatchFileUtil.aup(this.ABC.getAbsolutePath());
                SharePatchInfo l = SharePatchInfo.m9392l(auo, aup);
                if (l != null) {
                    l.AET = true;
                    SharePatchInfo.m9390a(auo, l, aup);
                    return;
                }
                return;
            }
            C5952a.m9285w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        }
    }

    private void auj(String str) {
        if (this.ABC != null && str != null) {
            SharePatchFileUtil.m9378cu(this.ABC.getAbsolutePath() + "/" + str);
        }
    }

    /* renamed from: ak */
    public final void mo50550ak(File file) {
        if (this.ABC != null && file != null && file.exists()) {
            auj(SharePatchFileUtil.auq(SharePatchFileUtil.m9374at(file)));
        }
    }
}
