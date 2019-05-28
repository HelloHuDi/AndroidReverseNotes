package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.e */
public final class C11643e {
    /* renamed from: a */
    public static void m19456a(final Context context, final ImageView imageView, final String str) {
        AppMethodBeat.m2504i(19441);
        Assert.assertTrue(imageView != null);
        if (C5004al.isMainThread()) {
            C11643e.m19458b(imageView, str, C25738R.color.f11911le);
            AppMethodBeat.m2505o(19441);
            return;
        }
        C5004al.m7441d(new Runnable() {
            final /* synthetic */ int lvt = C25738R.color.f11911le;

            public final void run() {
                AppMethodBeat.m2504i(19439);
                C11643e.m19458b(imageView, str, this.lvt);
                AppMethodBeat.m2505o(19439);
            }
        });
        AppMethodBeat.m2505o(19441);
    }

    /* renamed from: b */
    static void m19458b(ImageView imageView, String str, int i) {
        AppMethodBeat.m2504i(19442);
        if (C5046bo.isNullOrNil(str) || "#".equals(str)) {
            C4990ab.m7410d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
            imageView.setImageResource(i);
            AppMethodBeat.m2505o(19442);
            return;
        }
        C4990ab.m7411d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", str);
        C45891ad.boZ().mo43766a(str, imageView, C45891ad.m85023Kk(str));
        AppMethodBeat.m2505o(19442);
    }

    /* renamed from: e */
    public static void m19459e(final MMActivity mMActivity) {
        AppMethodBeat.m2504i(19443);
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(mMActivity.getString(C25738R.string.bfb));
        linkedList2.add(Integer.valueOf(0));
        C30379h.m48420a((Context) mMActivity, "", linkedList, linkedList2, null, true, new C30382d() {
            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(19440);
                switch (i2) {
                    case 0:
                        Context context = mMActivity;
                        Intent intent = new Intent();
                        intent.putExtra("query_source_type", 9);
                        intent.putExtra("query_media_type", 1);
                        intent.putExtra("max_select_count", 1);
                        C25985d.m41468b(context, "gallery", ".ui.AlbumPreviewUI", intent, 1001);
                        break;
                }
                AppMethodBeat.m2505o(19440);
            }
        });
        AppMethodBeat.m2505o(19443);
    }

    /* renamed from: a */
    public static boolean m19457a(MMActivity mMActivity, int i, int i2, Intent intent, String str) {
        AppMethodBeat.m2504i(19444);
        if (i == 1001 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                String str2 = (String) stringArrayListExtra.get(0);
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_OutputPath", C6457e.euZ + "temp.cover");
                intent2.putExtra("CropImage_ImgPath", str2);
                C25985d.m41466b((Context) mMActivity, ".ui.tools.CropImageNewUI", intent2, 1002);
                AppMethodBeat.m2505o(19444);
                return true;
            }
        } else if (i == 1002 && i2 == -1) {
            String Km = C38935d.m66101Km(C6457e.euZ + "temp.cover");
            C34022c bpg = C45891ad.bpg();
            bpg.appName = str;
            long currentTimeMillis = System.currentTimeMillis();
            bpg.lvp = C37458c.m63162a("uploadexdeivce", currentTimeMillis, C1853r.m3850Zd().field_username, String.valueOf(currentTimeMillis));
            String str3 = bpg.lvp;
            C42130g c42130g = new C42130g();
            c42130g.egl = bpg;
            c42130g.field_mediaId = str3;
            c42130g.field_fullpath = Km;
            c42130g.field_thumbpath = "";
            c42130g.field_fileType = C42129a.efN;
            c42130g.field_talker = "";
            c42130g.field_priority = C42129a.efB;
            c42130g.field_needStorage = true;
            c42130g.field_isStreamMedia = false;
            c42130g.field_appType = 200;
            c42130g.field_bzScene = 2;
            if (!C37461f.afx().mo51225e(c42130g)) {
                C4990ab.m7413e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", str3);
            }
            AppMethodBeat.m2505o(19444);
            return true;
        }
        AppMethodBeat.m2505o(19444);
        return false;
    }
}
