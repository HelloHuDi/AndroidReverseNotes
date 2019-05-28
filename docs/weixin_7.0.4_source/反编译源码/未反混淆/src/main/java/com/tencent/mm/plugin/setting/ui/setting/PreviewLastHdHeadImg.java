package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.ActUtil;

public class PreviewLastHdHeadImg extends MMActivity implements OnClickListener {
    private ImageView cAw;
    private String imgPath;
    private Bitmap qlr;
    private TextView qls;
    private String username;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.a6_;
    }

    public final void initView() {
        AppMethodBeat.i(127010);
        setMMTitle((int) R.string.e7u);
        xE(getResources().getColor(R.color.a3p));
        Nb(getResources().getColor(R.color.j));
        this.username = r.Yz();
        this.imgPath = getIntent().getStringExtra("last_avatar_path");
        this.cAw = (ImageView) findViewById(R.id.c_g);
        this.qlr = d.aml(this.imgPath);
        this.qls = (TextView) findViewById(R.id.c_h);
        this.cAw.setImageBitmap(this.qlr);
        this.qls.setOnClickListener(this);
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127007);
                com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(PreviewLastHdHeadImg.this, 1, false);
                dVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(127005);
                        if (PreviewLastHdHeadImg.this.qlr != null) {
                            lVar.hi(0, R.string.c9n);
                        }
                        AppMethodBeat.o(127005);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(127006);
                        PreviewLastHdHeadImg.b(PreviewLastHdHeadImg.this);
                        AppMethodBeat.o(127006);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(127007);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127008);
                PreviewLastHdHeadImg.this.finish();
                AppMethodBeat.o(127008);
                return true;
            }
        });
        AppMethodBeat.o(127010);
    }

    private static boolean e(Bitmap bitmap, String str) {
        AppMethodBeat.i(127011);
        if (!(str == null || str.equals(""))) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, str, true);
                AppMethodBeat.o(127011);
                return true;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.PreviewLastHdHeadImg", e, "", new Object[0]);
                ab.e("MicroMsg.PreviewLastHdHeadImg", "saveBitmapToImage failed:" + e.toString());
            }
        }
        AppMethodBeat.o(127011);
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.i(127012);
        String stringExtra = getIntent().getStringExtra("CropImage_OutputPath");
        if (stringExtra == null || !e(this.qlr, stringExtra)) {
            setResult(0);
            finish();
            AppMethodBeat.o(127012);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_OutputPath", stringExtra);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(127012);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127009);
        this.ylm = true;
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        initView();
        AppMethodBeat.o(127009);
    }

    static /* synthetic */ void b(PreviewLastHdHeadImg previewLastHdHeadImg) {
        AppMethodBeat.i(127013);
        if (e.ct(previewLastHdHeadImg.imgPath)) {
            String str = com.tencent.mm.compatible.util.e.euR + "hdImg_" + g.x(previewLastHdHeadImg.username.getBytes()) + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            e.deleteFile(str);
            e.y(previewLastHdHeadImg.imgPath, str);
            a.a(str, previewLastHdHeadImg.mController.ylL);
            Toast.makeText(previewLastHdHeadImg.mController.ylL, previewLastHdHeadImg.mController.ylL.getString(R.string.c9o, new Object[]{com.tencent.mm.compatible.util.e.euR}), 1).show();
            AppMethodBeat.o(127013);
            return;
        }
        Toast.makeText(previewLastHdHeadImg.mController.ylL, previewLastHdHeadImg.mController.ylL.getString(R.string.e5x), 1).show();
        AppMethodBeat.o(127013);
    }
}
