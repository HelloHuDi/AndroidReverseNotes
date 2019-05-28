package com.tencent.p177mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C18352nz;
import com.tencent.p177mm.plugin.extaccessories.C45908b.C43018a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories$RegistSpenBuddyEventListener$1 */
class SubCoreExtAccessories$RegistSpenBuddyEventListener$1 implements ImageWritingListener {
    final /* synthetic */ C18352nz lRG;
    final /* synthetic */ C43018a lRH;

    SubCoreExtAccessories$RegistSpenBuddyEventListener$1(C43018a c43018a, C18352nz c18352nz) {
        this.lRH = c43018a;
        this.lRG = c18352nz;
    }

    public void onImageReceived(Bitmap bitmap) {
        AppMethodBeat.m2504i(20464);
        C4990ab.m7416i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
        if (bitmap == null) {
            C4990ab.m7412e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
            this.lRG.cKo.cKp.ajv(null);
            AppMethodBeat.m2505o(20464);
        } else if (C1445f.m3070Mn()) {
            String str;
            C9638aw.m17184ZE();
            C45908b c45908b = (C45908b) C45439bw.m83697oJ("plugin.extaccessories");
            if (c45908b == null) {
                C4990ab.m7420w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
                c45908b = new C45908b();
                C9638aw.m17184ZE().mo73244a("plugin.extaccessories", c45908b);
            }
            String str2 = System.currentTimeMillis();
            if (!C9638aw.m17179RK() || C5046bo.isNullOrNil(str2)) {
                str = "";
            } else {
                str = c45908b.eJM + "image/spen/spen_" + str2;
            }
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
                this.lRG.cKo.cKp.ajv(null);
                AppMethodBeat.m2505o(20464);
                return;
            }
            try {
                if (bitmap.getWidth() > 1000 || bitmap.getHeight() > 1000) {
                    C4990ab.m7411d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
                    if (!(bitmap == createScaledBitmap || createScaledBitmap == null)) {
                        C4990ab.m7417i("MicroMsg.extaccessories.SubCoreExtAccessories", "bitmap recycle %s", bitmap.toString());
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                C5056d.m7625a(bitmap, 55, CompressFormat.JPEG, str, true);
                C4990ab.m7411d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", str);
                this.lRG.cKo.cKp.ajv(str);
                AppMethodBeat.m2505o(20464);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", e, "", new Object[0]);
                this.lRG.cKo.cKp.ajv(null);
                AppMethodBeat.m2505o(20464);
            }
        } else {
            C4990ab.m7412e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
            this.lRG.cKo.cKp.ajv(null);
            AppMethodBeat.m2505o(20464);
        }
    }
}
