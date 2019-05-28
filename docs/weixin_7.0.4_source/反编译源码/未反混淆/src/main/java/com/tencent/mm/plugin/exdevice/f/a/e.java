package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.c;
import com.tencent.mm.al.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class e {
    public static void a(final Context context, final ImageView imageView, final String str) {
        AppMethodBeat.i(19441);
        Assert.assertTrue(imageView != null);
        if (al.isMainThread()) {
            b(imageView, str, R.color.le);
            AppMethodBeat.o(19441);
            return;
        }
        al.d(new Runnable() {
            final /* synthetic */ int lvt = R.color.le;

            public final void run() {
                AppMethodBeat.i(19439);
                e.b(imageView, str, this.lvt);
                AppMethodBeat.o(19439);
            }
        });
        AppMethodBeat.o(19441);
    }

    static void b(ImageView imageView, String str, int i) {
        AppMethodBeat.i(19442);
        if (bo.isNullOrNil(str) || "#".equals(str)) {
            ab.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
            imageView.setImageResource(i);
            AppMethodBeat.o(19442);
            return;
        }
        ab.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", str);
        ad.boZ().a(str, imageView, ad.Kk(str));
        AppMethodBeat.o(19442);
    }

    public static void e(final MMActivity mMActivity) {
        AppMethodBeat.i(19443);
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(mMActivity.getString(R.string.bfb));
        linkedList2.add(Integer.valueOf(0));
        h.a((Context) mMActivity, "", linkedList, linkedList2, null, true, new d() {
            public final void bV(int i, int i2) {
                AppMethodBeat.i(19440);
                switch (i2) {
                    case 0:
                        Context context = mMActivity;
                        Intent intent = new Intent();
                        intent.putExtra("query_source_type", 9);
                        intent.putExtra("query_media_type", 1);
                        intent.putExtra("max_select_count", 1);
                        com.tencent.mm.bp.d.b(context, "gallery", ".ui.AlbumPreviewUI", intent, 1001);
                        break;
                }
                AppMethodBeat.o(19440);
            }
        });
        AppMethodBeat.o(19443);
    }

    public static boolean a(MMActivity mMActivity, int i, int i2, Intent intent, String str) {
        AppMethodBeat.i(19444);
        if (i == 1001 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                String str2 = (String) stringArrayListExtra.get(0);
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.euZ + "temp.cover");
                intent2.putExtra("CropImage_ImgPath", str2);
                com.tencent.mm.bp.d.b((Context) mMActivity, ".ui.tools.CropImageNewUI", intent2, 1002);
                AppMethodBeat.o(19444);
                return true;
            }
        } else if (i == 1002 && i2 == -1) {
            String Km = d.Km(com.tencent.mm.compatible.util.e.euZ + "temp.cover");
            c bpg = ad.bpg();
            bpg.appName = str;
            long currentTimeMillis = System.currentTimeMillis();
            bpg.lvp = c.a("uploadexdeivce", currentTimeMillis, r.Zd().field_username, String.valueOf(currentTimeMillis));
            String str3 = bpg.lvp;
            g gVar = new g();
            gVar.egl = bpg;
            gVar.field_mediaId = str3;
            gVar.field_fullpath = Km;
            gVar.field_thumbpath = "";
            gVar.field_fileType = a.efN;
            gVar.field_talker = "";
            gVar.field_priority = a.efB;
            gVar.field_needStorage = true;
            gVar.field_isStreamMedia = false;
            gVar.field_appType = 200;
            gVar.field_bzScene = 2;
            if (!f.afx().e(gVar)) {
                ab.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", str3);
            }
            AppMethodBeat.o(19444);
            return true;
        }
        AppMethodBeat.o(19444);
        return false;
    }
}
