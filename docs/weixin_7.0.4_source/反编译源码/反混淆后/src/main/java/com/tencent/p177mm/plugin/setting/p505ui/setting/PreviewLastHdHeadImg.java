package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.ActUtil;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg */
public class PreviewLastHdHeadImg extends MMActivity implements OnClickListener {
    private ImageView cAw;
    private String imgPath;
    private Bitmap qlr;
    private TextView qls;
    private String username;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg$2 */
    class C348552 implements OnMenuItemClickListener {
        C348552() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127008);
            PreviewLastHdHeadImg.this.finish();
            AppMethodBeat.m2505o(127008);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg$1 */
    class C396581 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg$1$1 */
        class C217471 implements C36073c {
            C217471() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(127005);
                if (PreviewLastHdHeadImg.this.qlr != null) {
                    c44273l.mo70072hi(0, C25738R.string.c9n);
                }
                AppMethodBeat.m2505o(127005);
            }
        }

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg$1$2 */
        class C289352 implements C5279d {
            C289352() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(127006);
                PreviewLastHdHeadImg.m86357b(PreviewLastHdHeadImg.this);
                AppMethodBeat.m2505o(127006);
            }
        }

        C396581() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127007);
            C36356d c36356d = new C36356d(PreviewLastHdHeadImg.this, 1, false);
            c36356d.rBl = new C217471();
            c36356d.rBm = new C289352();
            c36356d.cpD();
            AppMethodBeat.m2505o(127007);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969800;
    }

    public final void initView() {
        AppMethodBeat.m2504i(127010);
        setMMTitle((int) C25738R.string.e7u);
        mo17446xE(getResources().getColor(C25738R.color.a3p));
        mo17372Nb(getResources().getColor(C25738R.color.f11625j));
        this.username = C1853r.m3846Yz();
        this.imgPath = getIntent().getStringExtra("last_avatar_path");
        this.cAw = (ImageView) findViewById(2131824668);
        this.qlr = C5056d.aml(this.imgPath);
        this.qls = (TextView) findViewById(2131824669);
        this.cAw.setImageBitmap(this.qlr);
        this.qls.setOnClickListener(this);
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C396581());
        setBackBtn(new C348552());
        AppMethodBeat.m2505o(127010);
    }

    /* renamed from: e */
    private static boolean m86358e(Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(127011);
        if (!(str == null || str.equals(""))) {
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, str, true);
                AppMethodBeat.m2505o(127011);
                return true;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.PreviewLastHdHeadImg", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.PreviewLastHdHeadImg", "saveBitmapToImage failed:" + e.toString());
            }
        }
        AppMethodBeat.m2505o(127011);
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(127012);
        String stringExtra = getIntent().getStringExtra("CropImage_OutputPath");
        if (stringExtra == null || !PreviewLastHdHeadImg.m86358e(this.qlr, stringExtra)) {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(127012);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_OutputPath", stringExtra);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(127012);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127009);
        this.ylm = true;
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        initView();
        AppMethodBeat.m2505o(127009);
    }

    /* renamed from: b */
    static /* synthetic */ void m86357b(PreviewLastHdHeadImg previewLastHdHeadImg) {
        AppMethodBeat.m2504i(127013);
        if (C5730e.m8628ct(previewLastHdHeadImg.imgPath)) {
            String str = C6457e.euR + "hdImg_" + C1178g.m2591x(previewLastHdHeadImg.username.getBytes()) + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            C5730e.deleteFile(str);
            C5730e.m8644y(previewLastHdHeadImg.imgPath, str);
            C40612a.m70043a(str, previewLastHdHeadImg.mController.ylL);
            Toast.makeText(previewLastHdHeadImg.mController.ylL, previewLastHdHeadImg.mController.ylL.getString(C25738R.string.c9o, new Object[]{C6457e.euR}), 1).show();
            AppMethodBeat.m2505o(127013);
            return;
        }
        Toast.makeText(previewLastHdHeadImg.mController.ylL, previewLastHdHeadImg.mController.ylL.getString(C25738R.string.e5x), 1).show();
        AppMethodBeat.m2505o(127013);
    }
}
