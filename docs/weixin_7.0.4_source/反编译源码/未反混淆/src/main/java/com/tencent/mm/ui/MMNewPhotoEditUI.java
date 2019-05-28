package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.j;
import java.io.IOException;
import java.util.ArrayList;

@a(19)
public class MMNewPhotoEditUI extends MMActivity implements g {
    private p ejZ = null;
    private int emC;
    private s oDy;
    private Dialog ttv;
    private String ynr;
    private long yns;
    private String ynt;
    private String ynu;
    private boolean ynv;
    private boolean ynw;
    private final d ynx = new d(this);
    private PhotoEditProxy yny;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMNewPhotoEditUI() {
        AppMethodBeat.i(11927);
        AppMethodBeat.o(11927);
    }

    static /* synthetic */ void b(MMNewPhotoEditUI mMNewPhotoEditUI) {
        AppMethodBeat.i(11939);
        mMNewPhotoEditUI.fE(false);
        AppMethodBeat.o(11939);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return R.layout.aiw;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(11928);
        super.onCreate(bundle);
        this.mController.dyl();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            getWindow().addFlags(67108864);
        }
        this.yny = new PhotoEditProxy(this.ynx);
        this.ynx.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11919);
                ab.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
                MMNewPhotoEditUI.a(MMNewPhotoEditUI.this);
                MMNewPhotoEditUI.this.initView();
                AppMethodBeat.o(11919);
            }
        });
        AppMethodBeat.o(11928);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        boolean z;
        AppMethodBeat.i(11929);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.m5);
        this.oDy = s.ccQ.Ae();
        s sVar = this.oDy;
        s.a.a aVar = new s.a.a();
        if (this.emC == 291 || this.emC == 293) {
            z = false;
        } else {
            z = true;
        }
        aVar.ccS = z;
        aVar.ccU = true;
        aVar.ccR = c.PHOTO;
        aVar.path = this.ynr;
        sVar.a(aVar.AB());
        com.tencent.mm.api.c aQ = this.oDy.aQ(this.mController.ylL);
        aQ.setActionBarCallback(this);
        frameLayout.addView(aQ, new LayoutParams(-1, -1));
        aQ.setSelectedFeatureListener(new r() {
            public final void a(e eVar) {
                AppMethodBeat.i(11920);
                ab.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", eVar.name());
                AppMethodBeat.o(11920);
            }

            public final void a(e eVar, int i) {
                AppMethodBeat.i(11921);
                ab.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", eVar.name(), Integer.valueOf(i));
                AppMethodBeat.o(11921);
            }

            public final void bd(boolean z) {
                AppMethodBeat.i(11922);
                if (z) {
                    MMNewPhotoEditUI.this.showVKB();
                    AppMethodBeat.o(11922);
                    return;
                }
                MMNewPhotoEditUI.this.hideVKB(MMNewPhotoEditUI.this.mController.contentView);
                AppMethodBeat.o(11922);
            }
        });
        AppMethodBeat.o(11929);
    }

    public void onDestroy() {
        AppMethodBeat.i(11930);
        super.onDestroy();
        this.oDy.onDestroy();
        this.ynx.release();
        AppMethodBeat.o(11930);
    }

    public void onBackPressed() {
        AppMethodBeat.i(11931);
        if (!this.oDy.Ab()) {
            if (this.emC == 290 || this.emC == 291) {
                h.pYm.e(13859, Integer.valueOf(1), Integer.valueOf(2));
            } else if (this.emC == 4 || this.emC == 293) {
                h.pYm.e(13859, Integer.valueOf(2), Integer.valueOf(2));
            } else {
                h.pYm.e(13859, Integer.valueOf(0), Integer.valueOf(2));
            }
            finish();
        }
        AppMethodBeat.o(11931);
    }

    public final void onFinish() {
        AppMethodBeat.i(11932);
        if (this.emC == 290 || this.emC == 291) {
            h.pYm.e(13859, Integer.valueOf(1), Integer.valueOf(1));
        } else if (this.emC == 4 || this.emC == 293) {
            h.pYm.e(13859, Integer.valueOf(2), Integer.valueOf(1));
        } else {
            h.pYm.e(13859, Integer.valueOf(0), Integer.valueOf(1));
        }
        if (this.emC == 291 || this.emC == 293) {
            j jVar = new j(this.mController.ylL);
            jVar.rBl = new n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(11923);
                    lVar.e(0, MMNewPhotoEditUI.this.getString(R.string.dr8));
                    lVar.e(1, MMNewPhotoEditUI.this.getString(R.string.dcq));
                    lVar.e(2, MMNewPhotoEditUI.this.getString(R.string.dwx));
                    AppMethodBeat.o(11923);
                }
            };
            jVar.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(11924);
                    MMNewPhotoEditUI.a(MMNewPhotoEditUI.this, i);
                    AppMethodBeat.o(11924);
                }
            };
            com.tencent.mm.ui.base.h.a(this.mController.ylL, jVar.cuu());
            AppMethodBeat.o(11932);
            return;
        }
        Nh(-1);
        AppMethodBeat.o(11932);
    }

    public final void onExit() {
        AppMethodBeat.i(11933);
        onBackPressed();
        AppMethodBeat.o(11933);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(11934);
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            ab.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", intent.getStringExtra("Select_Conv_User"), this.ynu);
            this.ttv = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.g8l), false, null);
            this.yny.sendImage(intent.getStringExtra("custom_send_text"), this.ynu, this.yny.getSelfUsername(), r0);
            this.ttv.dismiss();
            if (this.ynv) {
                com.tencent.mm.sdk.f.a.a(this.ynu, this);
            } else {
                com.tencent.mm.vfs.e.deleteFile(this.ynu);
            }
            finish();
            AppMethodBeat.o(11934);
            return;
        }
        if (intent == null && !bo.isNullOrNil(this.ynu) && this.emC == 291) {
            com.tencent.mm.vfs.e.deleteFile(this.ynu);
        }
        AppMethodBeat.o(11934);
    }

    private void Nh(final int i) {
        AppMethodBeat.i(11935);
        fE(true);
        this.oDy.a(new com.tencent.mm.api.n() {
            public final void onError(Exception exception) {
                AppMethodBeat.i(11925);
                MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
                ab.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", exception);
                Toast.makeText(ah.getContext(), MMNewPhotoEditUI.this.getResources().getString(R.string.g79), 1).show();
                MMNewPhotoEditUI.this.setResult(0);
                MMNewPhotoEditUI.this.finish();
                AppMethodBeat.o(11925);
            }

            public final void b(Bitmap bitmap, boolean z) {
                AppMethodBeat.i(11926);
                ab.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                try {
                    String RL = com.tencent.mm.sdk.f.a.RL("jpg");
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, RL, true);
                    ab.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", RL);
                    MMNewPhotoEditUI.this.yny.recordImage(MMNewPhotoEditUI.this.ynr, RL, MMNewPhotoEditUI.this.yns, MMNewPhotoEditUI.this.oDy.Ac().Az(), MMNewPhotoEditUI.this.oDy.Ac().AA());
                    if (MMNewPhotoEditUI.this.ynv || i == 2) {
                        com.tencent.mm.sdk.f.a.a(RL, MMNewPhotoEditUI.this);
                    }
                    if (!(i == 0 || bitmap.isRecycled())) {
                        ab.i("MicroMsg.MMNewPhotoEditUI", "bitmap recycle %s", bitmap.toString());
                        bitmap.recycle();
                    }
                    MMNewPhotoEditUI.this.ynu = RL;
                    if (MMNewPhotoEditUI.this.emC != 291 && MMNewPhotoEditUI.this.emC != 293) {
                        MMNewPhotoEditUI.d(MMNewPhotoEditUI.this, RL);
                    } else if (i == 0) {
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, RL);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 1);
                        AppMethodBeat.o(11926);
                        return;
                    } else if (i == 1) {
                        MMNewPhotoEditUI.c(MMNewPhotoEditUI.this, RL);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 2);
                        Toast.makeText(ah.getContext(), MMNewPhotoEditUI.this.getString(R.string.g7f), 1).show();
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.this.finish();
                        AppMethodBeat.o(11926);
                        return;
                    } else if (i == 2) {
                        Toast.makeText(ah.getContext(), MMNewPhotoEditUI.this.getString(R.string.g7b, new Object[]{com.tencent.mm.compatible.util.e.euR}), 1).show();
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 3);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.this.finish();
                        AppMethodBeat.o(11926);
                        return;
                    }
                    AppMethodBeat.o(11926);
                } catch (IOException e) {
                    onError(e);
                    AppMethodBeat.o(11926);
                }
            }
        });
        AppMethodBeat.o(11935);
    }

    private void fE(boolean z) {
        AppMethodBeat.i(11936);
        ab.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.ejZ = p.b(this, getString(R.string.g8m), true, null);
            AppMethodBeat.o(11936);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.o(11936);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(MMNewPhotoEditUI mMNewPhotoEditUI) {
        AppMethodBeat.i(11937);
        Intent intent = mMNewPhotoEditUI.getIntent();
        mMNewPhotoEditUI.ynr = intent.getStringExtra("raw_photo_path");
        mMNewPhotoEditUI.yns = intent.getLongExtra("raw_photo_img_id", -1);
        mMNewPhotoEditUI.ynt = intent.getStringExtra("after_photo_edit");
        mMNewPhotoEditUI.emC = intent.getIntExtra("from_scene", 0);
        mMNewPhotoEditUI.ynw = intent.getBooleanExtra("from_scene_small_preview", false);
        mMNewPhotoEditUI.ynv = mMNewPhotoEditUI.yny.isAutoSave();
        AppMethodBeat.o(11937);
    }

    static /* synthetic */ void c(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        AppMethodBeat.i(11942);
        mMNewPhotoEditUI.yny.doFav(str);
        AppMethodBeat.o(11942);
    }

    static /* synthetic */ void d(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        Object obj;
        AppMethodBeat.i(11943);
        ab.i("MicroMsg.MMNewPhotoEditUI", "[gotoImagePreviewUI] :%s", str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList stringArrayListExtra = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_image_list");
        ArrayList stringArrayListExtra2 = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_select_image_list");
        int i = 0;
        while (stringArrayListExtra != null && i < stringArrayListExtra.size()) {
            obj = (String) stringArrayListExtra.get(i);
            if (obj.equalsIgnoreCase(bo.nullAsNil(mMNewPhotoEditUI.ynr)) || obj.equalsIgnoreCase(bo.nullAsNil(mMNewPhotoEditUI.ynt))) {
                obj = str;
            }
            arrayList.add(obj);
            i++;
        }
        i = 0;
        while (stringArrayListExtra2 != null && i < stringArrayListExtra2.size()) {
            obj = (String) stringArrayListExtra2.get(i);
            if (obj.equalsIgnoreCase(bo.nullAsNil(mMNewPhotoEditUI.ynr)) || obj.equalsIgnoreCase(bo.nullAsNil(mMNewPhotoEditUI.ynt))) {
                obj = str;
            }
            arrayList2.add(obj);
            i++;
        }
        String str2 = null;
        if (!mMNewPhotoEditUI.ynv) {
            str2 = mMNewPhotoEditUI.yny.getFullPath("photoEdited_" + System.currentTimeMillis());
            com.tencent.mm.vfs.e.y(str, str2);
        }
        com.tencent.mm.vfs.e.deleteFile(mMNewPhotoEditUI.ynt);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("max_select_count", mMNewPhotoEditUI.getIntent().getIntExtra("max_select_count", 9));
        intent.putExtra("isPreviewPhoto", true);
        intent.putExtra("raw_photo_path", mMNewPhotoEditUI.ynr);
        intent.putExtra("raw_photo_img_id", mMNewPhotoEditUI.yns);
        intent.putExtra("after_photo_edit", str);
        intent.putExtra("tmp_photo_edit", str2);
        Bundle bundle = new Bundle();
        bundle.putString("raw_photo_path", mMNewPhotoEditUI.ynr);
        bundle.putString("after_photo_edit", str);
        bundle.putInt("report_info_emotion_count", mMNewPhotoEditUI.oDy.Ac().As());
        bundle.putInt("report_info_text_count", mMNewPhotoEditUI.oDy.Ac().Ar());
        bundle.putInt("report_info_mosaic_count", mMNewPhotoEditUI.oDy.Ac().At());
        bundle.putInt("report_info_doodle_count", mMNewPhotoEditUI.oDy.Ac().Au());
        bundle.putBoolean("report_info_iscrop", mMNewPhotoEditUI.oDy.Ac().isCropped());
        bundle.putInt("report_info_undo_count", mMNewPhotoEditUI.oDy.Ac().Av());
        bundle.putBoolean("report_info_is_rotation", mMNewPhotoEditUI.oDy.Ac().Aw());
        intent.putExtra("report_info", bundle);
        str2 = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (!bo.isNullOrNil(str2)) {
            intent.putExtra("GalleryUI_FromUser", str2);
        }
        if (!bo.isNullOrNil(stringExtra)) {
            intent.putExtra("GalleryUI_ToUser", stringExtra);
        }
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putStringArrayListExtra("preview_select_image_list", arrayList2);
        mMNewPhotoEditUI.setResult(-1, intent);
        mMNewPhotoEditUI.fE(false);
        mMNewPhotoEditUI.finish();
        AppMethodBeat.o(11943);
    }
}
