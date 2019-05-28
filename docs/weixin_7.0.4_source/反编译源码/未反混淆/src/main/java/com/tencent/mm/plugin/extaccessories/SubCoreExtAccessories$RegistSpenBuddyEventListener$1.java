package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.extaccessories.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1 implements ImageWritingListener {
    final /* synthetic */ nz lRG;
    final /* synthetic */ a lRH;

    SubCoreExtAccessories$RegistSpenBuddyEventListener$1(a aVar, nz nzVar) {
        this.lRH = aVar;
        this.lRG = nzVar;
    }

    public void onImageReceived(Bitmap bitmap) {
        AppMethodBeat.i(20464);
        ab.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
        if (bitmap == null) {
            ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
            this.lRG.cKo.cKp.ajv(null);
            AppMethodBeat.o(20464);
        } else if (f.Mn()) {
            String str;
            aw.ZE();
            b bVar = (b) bw.oJ("plugin.extaccessories");
            if (bVar == null) {
                ab.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
                bVar = new b();
                aw.ZE().a("plugin.extaccessories", bVar);
            }
            String str2 = System.currentTimeMillis();
            if (!aw.RK() || bo.isNullOrNil(str2)) {
                str = "";
            } else {
                str = bVar.eJM + "image/spen/spen_" + str2;
            }
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
                this.lRG.cKo.cKp.ajv(null);
                AppMethodBeat.o(20464);
                return;
            }
            try {
                if (bitmap.getWidth() > 1000 || bitmap.getHeight() > 1000) {
                    ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
                    if (!(bitmap == createScaledBitmap || createScaledBitmap == null)) {
                        ab.i("MicroMsg.extaccessories.SubCoreExtAccessories", "bitmap recycle %s", bitmap.toString());
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                d.a(bitmap, 55, CompressFormat.JPEG, str, true);
                ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", str);
                this.lRG.cKo.cKp.ajv(str);
                AppMethodBeat.o(20464);
            } catch (Exception e) {
                ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", e, "", new Object[0]);
                this.lRG.cKo.cKp.ajv(null);
                AppMethodBeat.o(20464);
            }
        } else {
            ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
            this.lRG.cKo.cKp.ajv(null);
            AppMethodBeat.o(20464);
        }
    }
}
