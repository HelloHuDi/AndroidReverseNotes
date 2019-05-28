package com.tencent.tinker.lib.b;

import android.content.Context;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.util.b;
import com.tencent.tinker.lib.util.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a implements b {
    protected final Context context;

    public a(Context context) {
        this.context = context;
    }

    public final int auh(String str) {
        int eI = eI(str, SharePatchFileUtil.at(new File(str)));
        if (eI == 0) {
            TinkerPatchService.ce(this.context, str);
        } else {
            com.tencent.tinker.lib.e.a.iX(this.context).ABE.d(new File(str), eI);
        }
        return eI;
    }

    /* Access modifiers changed, original: protected */
    public int eI(String str, String str2) {
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(this.context);
        if (!ShareTinkerInternals.Se(iX.tinkerFlags) || !ShareTinkerInternals.jn(this.context)) {
            return -1;
        }
        if (!SharePatchFileUtil.ap(new File(str))) {
            return -2;
        }
        if (iX.ABI) {
            return -4;
        }
        if (b.iZ(this.context)) {
            return -3;
        }
        if (ShareTinkerInternals.dSq()) {
            return -5;
        }
        iX = com.tencent.tinker.lib.e.a.iX(this.context);
        if (iX.ABK) {
            d dVar = iX.ABJ;
            if (!(dVar == null || dVar.ABR || !str2.equals(dVar.ABO))) {
                return -6;
            }
        }
        if (c.jc(this.context).auk(str2)) {
            return 0;
        }
        return -7;
    }
}
