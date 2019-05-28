package com.tencent.tinker.lib.p1577b;

import android.content.Context;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C44553d;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.util.C31098b;
import com.tencent.tinker.lib.util.C41089c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* renamed from: com.tencent.tinker.lib.b.a */
public class C46816a implements C41087b {
    protected final Context context;

    public C46816a(Context context) {
        this.context = context;
    }

    public final int auh(String str) {
        int eI = mo65729eI(str, SharePatchFileUtil.m9374at(new File(str)));
        if (eI == 0) {
            TinkerPatchService.m80934ce(this.context, str);
        } else {
            C31097a.m50180iX(this.context).ABE.mo40774d(new File(str), eI);
        }
        return eI;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: eI */
    public int mo65729eI(String str, String str2) {
        C31097a iX = C31097a.m50180iX(this.context);
        if (!ShareTinkerInternals.m9413Se(iX.tinkerFlags) || !ShareTinkerInternals.m9422jn(this.context)) {
            return -1;
        }
        if (!SharePatchFileUtil.m9370ap(new File(str))) {
            return -2;
        }
        if (iX.ABI) {
            return -4;
        }
        if (C31098b.m50187iZ(this.context)) {
            return -3;
        }
        if (ShareTinkerInternals.dSq()) {
            return -5;
        }
        iX = C31097a.m50180iX(this.context);
        if (iX.ABK) {
            C44553d c44553d = iX.ABJ;
            if (!(c44553d == null || c44553d.ABR || !str2.equals(c44553d.ABO))) {
                return -6;
            }
        }
        if (C41089c.m71517jc(this.context).auk(str2)) {
            return 0;
        }
        return -7;
    }
}
