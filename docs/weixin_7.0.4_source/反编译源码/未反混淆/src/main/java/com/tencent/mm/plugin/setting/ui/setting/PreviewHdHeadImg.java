package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.ActUtil;

public class PreviewHdHeadImg extends MMActivity {
    private final int qli = 1;
    private final int qlj = 2;
    private final int qlk = 3;
    private GetHdHeadImageGalleryView qll;
    private e qlm;
    private String qln;
    private String username;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(PreviewHdHeadImg previewHdHeadImg, Bitmap bitmap, String str) {
        AppMethodBeat.i(127003);
        previewHdHeadImg.d(bitmap, str);
        AppMethodBeat.o(127003);
    }

    static /* synthetic */ void d(PreviewHdHeadImg previewHdHeadImg) {
        AppMethodBeat.i(127004);
        previewHdHeadImg.civ();
        AppMethodBeat.o(127004);
    }

    public final int getLayoutId() {
        return R.layout.a69;
    }

    public final void initView() {
        AppMethodBeat.i(126996);
        setMMTitle((int) R.string.e5w);
        xE(getResources().getColor(R.color.a3p));
        Nb(getResources().getColor(R.color.j));
        this.username = r.Yz();
        this.qll = (GetHdHeadImageGalleryView) findViewById(R.id.adi);
        this.qll.setUsername(this.username);
        civ();
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126989);
                d dVar = new d(PreviewHdHeadImg.this, 1, false);
                dVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(126987);
                        lVar.hi(1, R.string.e5y);
                        Bitmap a = b.a(PreviewHdHeadImg.this.username, true, -1);
                        o.acd();
                        if (com.tencent.mm.vfs.e.ct(com.tencent.mm.ah.d.D(r.Yz() + ".last", true))) {
                            lVar.hi(3, R.string.ea8);
                        }
                        if (a != null) {
                            lVar.hi(2, R.string.c9n);
                        }
                        AppMethodBeat.o(126987);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(126988);
                        switch (menuItem.getItemId()) {
                            case 1:
                                a.gkF.o(PreviewHdHeadImg.this);
                                AppMethodBeat.o(126988);
                                return;
                            case 2:
                                PreviewHdHeadImg.b(PreviewHdHeadImg.this);
                                AppMethodBeat.o(126988);
                                return;
                            case 3:
                                Intent intent = new Intent();
                                intent.setClass(PreviewHdHeadImg.this.mController.ylL, PreviewLastHdHeadImg.class);
                                o.acd();
                                intent.putExtra("CropImage_OutputPath", com.tencent.mm.ah.d.D(r.Yz() + ".crop", true));
                                o.acd();
                                intent.putExtra("last_avatar_path", com.tencent.mm.ah.d.D(r.Yz() + ".last", true));
                                PreviewHdHeadImg.this.startActivityForResult(intent, 4);
                                break;
                        }
                        AppMethodBeat.o(126988);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(126989);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126990);
                PreviewHdHeadImg.this.finish();
                AppMethodBeat.o(126990);
                return true;
            }
        });
        AppMethodBeat.o(126996);
    }

    private void civ() {
        AppMethodBeat.i(126997);
        if (g.RP().isSDCardAvailable()) {
            final Bitmap ciw = ciw();
            if (ciw == null || ciw.isRecycled()) {
                ab.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
            } else {
                ab.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", this.username);
                this.qll.setThumbImage(ciw);
            }
            o.acd();
            Bitmap qg = com.tencent.mm.ah.d.qg(this.username);
            if (qg == null || qg.isRecycled()) {
                this.qlm = new e();
                this.qlm.a(this.username, new e.c() {
                    public final int cr(int i, int i2) {
                        AppMethodBeat.i(126991);
                        PreviewHdHeadImg.this.qlm.ach();
                        ab.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            o.acd();
                            Bitmap qg = com.tencent.mm.ah.d.qg(PreviewHdHeadImg.this.username);
                            if (qg != null) {
                                PreviewHdHeadImg previewHdHeadImg = PreviewHdHeadImg.this;
                                o.acd();
                                PreviewHdHeadImg.a(previewHdHeadImg, qg, com.tencent.mm.ah.d.C(PreviewHdHeadImg.this.username, true));
                            } else {
                                PreviewHdHeadImg.a(PreviewHdHeadImg.this, ciw, null);
                            }
                            AppMethodBeat.o(126991);
                        } else {
                            PreviewHdHeadImg.a(PreviewHdHeadImg.this, ciw, null);
                            AppMethodBeat.o(126991);
                        }
                        return 0;
                    }
                });
                AppMethodBeat.o(126997);
                return;
            }
            ab.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", this.username);
            o.acd();
            d(qg, com.tencent.mm.ah.d.C(this.username, true));
            AppMethodBeat.o(126997);
            return;
        }
        t.hO(this.mController.ylL);
        d(o.acd().bU(this.mController.ylL), null);
        AppMethodBeat.o(126997);
    }

    private Bitmap ciw() {
        AppMethodBeat.i(126998);
        Bitmap a = b.a(this.username, true, -1);
        if (a == null) {
            a = BitmapFactory.decodeResource(getResources(), R.drawable.ad2);
        }
        AppMethodBeat.o(126998);
        return a;
    }

    private void d(Bitmap bitmap, String str) {
        AppMethodBeat.i(126999);
        if (bitmap == null) {
            AppMethodBeat.o(126999);
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
            ab.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
            this.qll.setHdHeadImage(createBitmap);
            this.qll.setHdHeadImagePath(str);
            this.qln = str;
            AppMethodBeat.o(126999);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
            AppMethodBeat.o(126999);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127000);
        ab.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            if (i == 2 || i == 4) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(126992);
                        ta taVar = new ta();
                        taVar.cPk.cPm = true;
                        com.tencent.mm.sdk.b.a.xxA.m(taVar);
                        AppMethodBeat.o(126992);
                    }
                });
            }
            AppMethodBeat.o(127000);
            return;
        }
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(127000);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                o.acd();
                intent2.putExtra("CropImage_OutputPath", com.tencent.mm.ah.d.C(r.Yz() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", null);
                com.tencent.mm.plugin.setting.b.gkE.a((Activity) this, intent, intent2, com.tencent.mm.plugin.i.c.XW(), 4, null);
                AppMethodBeat.o(127000);
                return;
            case 4:
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(126993);
                        ta taVar = new ta();
                        taVar.cPk.cPm = true;
                        com.tencent.mm.sdk.b.a.xxA.m(taVar);
                        AppMethodBeat.o(126993);
                    }
                });
                if (intent == null) {
                    AppMethodBeat.o(127000);
                    return;
                }
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                final Bitmap aml = com.tencent.mm.sdk.platformtools.d.aml(this.qln);
                if (stringExtra == null) {
                    ab.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
                    AppMethodBeat.o(127000);
                    return;
                }
                d(com.tencent.mm.sdk.platformtools.d.aml(stringExtra), null);
                new m(this.mController.ylL, stringExtra).w(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(126994);
                        ab.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", Boolean.valueOf(g.RK()), r.Yz());
                        if (g.RK()) {
                            if (aml != null) {
                                o.acd();
                                PreviewHdHeadImg.e(aml, com.tencent.mm.ah.d.D(r.Yz() + ".last", true));
                            }
                            av.fly.ou(b.pX(r.Yz()));
                        }
                        PreviewHdHeadImg.d(PreviewHdHeadImg.this);
                        AppMethodBeat.o(126994);
                    }
                });
                AppMethodBeat.o(127000);
                return;
            default:
                AppMethodBeat.o(127000);
                return;
        }
    }

    public static boolean e(Bitmap bitmap, String str) {
        AppMethodBeat.i(127001);
        if (!(str == null || str.equals(""))) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, str, true);
                AppMethodBeat.o(127001);
                return true;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
                ab.e("MicroMsg.PreviewHdHeadImg", "saveBitmapToImage failed:" + e.toString());
            }
        }
        AppMethodBeat.o(127001);
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126995);
        this.ylm = true;
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        initView();
        AppMethodBeat.o(126995);
    }

    static /* synthetic */ void b(PreviewHdHeadImg previewHdHeadImg) {
        AppMethodBeat.i(127002);
        if (com.tencent.mm.vfs.e.ct(previewHdHeadImg.qln)) {
            String str = com.tencent.mm.compatible.util.e.euR + "hdImg_" + com.tencent.mm.a.g.x(previewHdHeadImg.username.getBytes()) + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            com.tencent.mm.vfs.e.deleteFile(str);
            com.tencent.mm.vfs.e.y(previewHdHeadImg.qln, str);
            com.tencent.mm.sdk.f.a.a(str, previewHdHeadImg.mController.ylL);
            Toast.makeText(previewHdHeadImg.mController.ylL, previewHdHeadImg.mController.ylL.getString(R.string.c9o, new Object[]{com.tencent.mm.compatible.util.e.euR}), 1).show();
            AppMethodBeat.o(127002);
            return;
        }
        Toast.makeText(previewHdHeadImg.mController.ylL, previewHdHeadImg.mController.ylL.getString(R.string.e5x), 1).show();
        AppMethodBeat.o(127002);
    }
}
