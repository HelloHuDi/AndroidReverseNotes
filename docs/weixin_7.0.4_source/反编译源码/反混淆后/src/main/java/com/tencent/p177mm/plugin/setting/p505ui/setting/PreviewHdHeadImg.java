package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C37439m;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p182ah.C41733e;
import com.tencent.p177mm.p182ah.C41733e.C25750c;
import com.tencent.p177mm.p230g.p231a.C45369ta;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.pluginsdk.p597ui.GetHdHeadImageGalleryView;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.ActUtil;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg */
public class PreviewHdHeadImg extends MMActivity {
    private final int qli = 1;
    private final int qlj = 2;
    private final int qlk = 3;
    private GetHdHeadImageGalleryView qll;
    private C41733e qlm;
    private String qln;
    private String username;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg$1 */
    class C131991 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg$1$1 */
        class C132001 implements C36073c {
            C132001() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(126987);
                c44273l.mo70072hi(1, C25738R.string.e5y);
                Bitmap a = C41730b.m73490a(PreviewHdHeadImg.this.username, true, -1);
                C17884o.acd();
                if (C5730e.m8628ct(C41732d.m73515D(C1853r.m3846Yz() + ".last", true))) {
                    c44273l.mo70072hi(3, C25738R.string.ea8);
                }
                if (a != null) {
                    c44273l.mo70072hi(2, C25738R.string.c9n);
                }
                AppMethodBeat.m2505o(126987);
            }
        }

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg$1$2 */
        class C132012 implements C5279d {
            C132012() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(126988);
                switch (menuItem.getItemId()) {
                    case 1:
                        C24679a.gkF.mo38870o(PreviewHdHeadImg.this);
                        AppMethodBeat.m2505o(126988);
                        return;
                    case 2:
                        PreviewHdHeadImg.m77733b(PreviewHdHeadImg.this);
                        AppMethodBeat.m2505o(126988);
                        return;
                    case 3:
                        Intent intent = new Intent();
                        intent.setClass(PreviewHdHeadImg.this.mController.ylL, PreviewLastHdHeadImg.class);
                        C17884o.acd();
                        intent.putExtra("CropImage_OutputPath", C41732d.m73515D(C1853r.m3846Yz() + ".crop", true));
                        C17884o.acd();
                        intent.putExtra("last_avatar_path", C41732d.m73515D(C1853r.m3846Yz() + ".last", true));
                        PreviewHdHeadImg.this.startActivityForResult(intent, 4);
                        break;
                }
                AppMethodBeat.m2505o(126988);
            }
        }

        C131991() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126989);
            C36356d c36356d = new C36356d(PreviewHdHeadImg.this, 1, false);
            c36356d.rBl = new C132001();
            c36356d.rBm = new C132012();
            c36356d.cpD();
            AppMethodBeat.m2505o(126989);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg$2 */
    class C132022 implements OnMenuItemClickListener {
        C132022() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126990);
            PreviewHdHeadImg.this.finish();
            AppMethodBeat.m2505o(126990);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg$5 */
    class C396575 implements Runnable {
        C396575() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126993);
            C45369ta c45369ta = new C45369ta();
            c45369ta.cPk.cPm = true;
            C4879a.xxA.mo10055m(c45369ta);
            AppMethodBeat.m2505o(126993);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg$4 */
    class C435074 implements Runnable {
        C435074() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126992);
            C45369ta c45369ta = new C45369ta();
            c45369ta.cPk.cPm = true;
            C4879a.xxA.mo10055m(c45369ta);
            AppMethodBeat.m2505o(126992);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m77732a(PreviewHdHeadImg previewHdHeadImg, Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(127003);
        previewHdHeadImg.m77735d(bitmap, str);
        AppMethodBeat.m2505o(127003);
    }

    /* renamed from: d */
    static /* synthetic */ void m77736d(PreviewHdHeadImg previewHdHeadImg) {
        AppMethodBeat.m2504i(127004);
        previewHdHeadImg.civ();
        AppMethodBeat.m2505o(127004);
    }

    public final int getLayoutId() {
        return 2130969799;
    }

    public final void initView() {
        AppMethodBeat.m2504i(126996);
        setMMTitle((int) C25738R.string.e5w);
        mo17446xE(getResources().getColor(C25738R.color.a3p));
        mo17372Nb(getResources().getColor(C25738R.color.f11625j));
        this.username = C1853r.m3846Yz();
        this.qll = (GetHdHeadImageGalleryView) findViewById(2131822081);
        this.qll.setUsername(this.username);
        civ();
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C131991());
        setBackBtn(new C132022());
        AppMethodBeat.m2505o(126996);
    }

    private void civ() {
        AppMethodBeat.m2504i(126997);
        if (C1720g.m3536RP().isSDCardAvailable()) {
            final Bitmap ciw = ciw();
            if (ciw == null || ciw.isRecycled()) {
                C4990ab.m7417i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
            } else {
                C4990ab.m7417i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", this.username);
                this.qll.setThumbImage(ciw);
            }
            C17884o.acd();
            Bitmap qg = C41732d.m73526qg(this.username);
            if (qg == null || qg.isRecycled()) {
                this.qlm = new C41733e();
                this.qlm.mo67507a(this.username, new C25750c() {
                    /* renamed from: cr */
                    public final int mo4442cr(int i, int i2) {
                        AppMethodBeat.m2504i(126991);
                        PreviewHdHeadImg.this.qlm.ach();
                        C4990ab.m7417i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C17884o.acd();
                            Bitmap qg = C41732d.m73526qg(PreviewHdHeadImg.this.username);
                            if (qg != null) {
                                PreviewHdHeadImg previewHdHeadImg = PreviewHdHeadImg.this;
                                C17884o.acd();
                                PreviewHdHeadImg.m77732a(previewHdHeadImg, qg, C41732d.m73514C(PreviewHdHeadImg.this.username, true));
                            } else {
                                PreviewHdHeadImg.m77732a(PreviewHdHeadImg.this, ciw, null);
                            }
                            AppMethodBeat.m2505o(126991);
                        } else {
                            PreviewHdHeadImg.m77732a(PreviewHdHeadImg.this, ciw, null);
                            AppMethodBeat.m2505o(126991);
                        }
                        return 0;
                    }
                });
                AppMethodBeat.m2505o(126997);
                return;
            }
            C4990ab.m7417i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", this.username);
            C17884o.acd();
            m77735d(qg, C41732d.m73514C(this.username, true));
            AppMethodBeat.m2505o(126997);
            return;
        }
        C23639t.m36492hO(this.mController.ylL);
        m77735d(C17884o.acd().mo67501bU(this.mController.ylL), null);
        AppMethodBeat.m2505o(126997);
    }

    private Bitmap ciw() {
        AppMethodBeat.m2504i(126998);
        Bitmap a = C41730b.m73490a(this.username, true, -1);
        if (a == null) {
            a = BitmapFactory.decodeResource(getResources(), C25738R.drawable.ad2);
        }
        AppMethodBeat.m2505o(126998);
        return a;
    }

    /* renamed from: d */
    private void m77735d(Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(126999);
        if (bitmap == null) {
            AppMethodBeat.m2505o(126999);
            return;
        }
        try {
            Bitmap createBitmap;
            if (bitmap.getWidth() < 480) {
                float width = 480.0f / ((float) bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                createBitmap = bitmap;
            }
            C4990ab.m7411d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
            this.qll.setHdHeadImage(createBitmap);
            this.qll.setHdHeadImagePath(str);
            this.qln = str;
            AppMethodBeat.m2505o(126999);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
            AppMethodBeat.m2505o(126999);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127000);
        C4990ab.m7417i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            if (i == 2 || i == 4) {
                new C7306ak(Looper.getMainLooper()).post(new C435074());
            }
            AppMethodBeat.m2505o(127000);
            return;
        }
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.m2505o(127000);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                C17884o.acd();
                intent2.putExtra("CropImage_OutputPath", C41732d.m73514C(C1853r.m3846Yz() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", null);
                C24824b.gkE.mo38891a((Activity) this, intent, intent2, C43217c.m76863XW(), 4, null);
                AppMethodBeat.m2505o(127000);
                return;
            case 4:
                new C7306ak(Looper.getMainLooper()).post(new C396575());
                if (intent == null) {
                    AppMethodBeat.m2505o(127000);
                    return;
                }
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                final Bitmap aml = C5056d.aml(this.qln);
                if (stringExtra == null) {
                    C4990ab.m7412e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
                    AppMethodBeat.m2505o(127000);
                    return;
                }
                m77735d(C5056d.aml(stringExtra), null);
                new C37439m(this.mController.ylL, stringExtra).mo60330w(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(126994);
                        C4990ab.m7411d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", Boolean.valueOf(C1720g.m3531RK()), C1853r.m3846Yz());
                        if (C1720g.m3531RK()) {
                            if (aml != null) {
                                C17884o.acd();
                                PreviewHdHeadImg.m77737e(aml, C41732d.m73515D(C1853r.m3846Yz() + ".last", true));
                            }
                            C6665av.fly.mo14899ou(C41730b.m73505pX(C1853r.m3846Yz()));
                        }
                        PreviewHdHeadImg.m77736d(PreviewHdHeadImg.this);
                        AppMethodBeat.m2505o(126994);
                    }
                });
                AppMethodBeat.m2505o(127000);
                return;
            default:
                AppMethodBeat.m2505o(127000);
                return;
        }
    }

    /* renamed from: e */
    public static boolean m77737e(Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(127001);
        if (!(str == null || str.equals(""))) {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, str, true);
                AppMethodBeat.m2505o(127001);
                return true;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.PreviewHdHeadImg", "saveBitmapToImage failed:" + e.toString());
            }
        }
        AppMethodBeat.m2505o(127001);
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126995);
        this.ylm = true;
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        initView();
        AppMethodBeat.m2505o(126995);
    }

    /* renamed from: b */
    static /* synthetic */ void m77733b(PreviewHdHeadImg previewHdHeadImg) {
        AppMethodBeat.m2504i(127002);
        if (C5730e.m8628ct(previewHdHeadImg.qln)) {
            String str = C6457e.euR + "hdImg_" + C1178g.m2591x(previewHdHeadImg.username.getBytes()) + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            C5730e.deleteFile(str);
            C5730e.m8644y(previewHdHeadImg.qln, str);
            C40612a.m70043a(str, previewHdHeadImg.mController.ylL);
            Toast.makeText(previewHdHeadImg.mController.ylL, previewHdHeadImg.mController.ylL.getString(C25738R.string.c9o, new Object[]{C6457e.euR}), 1).show();
            AppMethodBeat.m2505o(127002);
            return;
        }
        Toast.makeText(previewHdHeadImg.mController.ylL, previewHdHeadImg.mController.ylL.getString(C25738R.string.e5x), 1).show();
        AppMethodBeat.m2505o(127002);
    }
}
