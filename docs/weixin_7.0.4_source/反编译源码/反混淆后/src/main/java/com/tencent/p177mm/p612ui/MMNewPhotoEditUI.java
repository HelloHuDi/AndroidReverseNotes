package com.tencent.p177mm.p612ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C1241c;
import com.tencent.p177mm.api.C25784s;
import com.tencent.p177mm.api.C25784s.C25785a.C17916a;
import com.tencent.p177mm.api.C25784s.C8957c;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.api.C32249g;
import com.tencent.p177mm.api.C37464n;
import com.tencent.p177mm.api.C8956r;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.ArrayList;

@C5271a(19)
/* renamed from: com.tencent.mm.ui.MMNewPhotoEditUI */
public class MMNewPhotoEditUI extends MMActivity implements C32249g {
    private C44275p ejZ = null;
    private int emC;
    private C25784s oDy;
    private Dialog ttv;
    private String ynr;
    private long yns;
    private String ynt;
    private String ynu;
    private boolean ynv;
    private boolean ynw;
    private final C46607d ynx = new C46607d(this);
    private PhotoEditProxy yny;

    /* renamed from: com.tencent.mm.ui.MMNewPhotoEditUI$2 */
    class C154702 implements C8956r {
        C154702() {
        }

        /* renamed from: a */
        public final void mo4525a(C32247e c32247e) {
            AppMethodBeat.m2504i(11920);
            C4990ab.m7417i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", c32247e.name());
            AppMethodBeat.m2505o(11920);
        }

        /* renamed from: a */
        public final void mo4526a(C32247e c32247e, int i) {
            AppMethodBeat.m2504i(11921);
            C4990ab.m7417i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", c32247e.name(), Integer.valueOf(i));
            AppMethodBeat.m2505o(11921);
        }

        /* renamed from: bd */
        public final void mo4527bd(boolean z) {
            AppMethodBeat.m2504i(11922);
            if (z) {
                MMNewPhotoEditUI.this.showVKB();
                AppMethodBeat.m2505o(11922);
                return;
            }
            MMNewPhotoEditUI.this.hideVKB(MMNewPhotoEditUI.this.mController.contentView);
            AppMethodBeat.m2505o(11922);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMNewPhotoEditUI$1 */
    class C154711 implements Runnable {
        C154711() {
        }

        public final void run() {
            AppMethodBeat.m2504i(11919);
            C4990ab.m7416i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
            MMNewPhotoEditUI.m23772a(MMNewPhotoEditUI.this);
            MMNewPhotoEditUI.this.initView();
            AppMethodBeat.m2505o(11919);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMNewPhotoEditUI$3 */
    class C154723 implements C36073c {
        C154723() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(11923);
            c44273l.mo70068e(0, MMNewPhotoEditUI.this.getString(C25738R.string.dr8));
            c44273l.mo70068e(1, MMNewPhotoEditUI.this.getString(C25738R.string.dcq));
            c44273l.mo70068e(2, MMNewPhotoEditUI.this.getString(C25738R.string.dwx));
            AppMethodBeat.m2505o(11923);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMNewPhotoEditUI$4 */
    class C154734 implements C5279d {
        C154734() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(11924);
            MMNewPhotoEditUI.m23773a(MMNewPhotoEditUI.this, i);
            AppMethodBeat.m2505o(11924);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MMNewPhotoEditUI() {
        AppMethodBeat.m2504i(11927);
        AppMethodBeat.m2505o(11927);
    }

    /* renamed from: b */
    static /* synthetic */ void m23774b(MMNewPhotoEditUI mMNewPhotoEditUI) {
        AppMethodBeat.m2504i(11939);
        mMNewPhotoEditUI.m23783fE(false);
        AppMethodBeat.m2505o(11939);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return 2130970304;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(11928);
        super.onCreate(bundle);
        this.mController.dyl();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            getWindow().addFlags(67108864);
        }
        this.yny = new PhotoEditProxy(this.ynx);
        this.ynx.connect(new C154711());
        AppMethodBeat.m2505o(11928);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        boolean z;
        AppMethodBeat.m2504i(11929);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131821019);
        this.oDy = C25784s.ccQ.mo33296Ae();
        C25784s c25784s = this.oDy;
        C17916a c17916a = new C17916a();
        if (this.emC == 291 || this.emC == 293) {
            z = false;
        } else {
            z = true;
        }
        c17916a.ccS = z;
        c17916a.ccU = true;
        c17916a.ccR = C8957c.PHOTO;
        c17916a.path = this.ynr;
        c25784s.mo33293a(c17916a.mo33430AB());
        C1241c aQ = this.oDy.mo33294aQ(this.mController.ylL);
        aQ.setActionBarCallback(this);
        frameLayout.addView(aQ, new LayoutParams(-1, -1));
        aQ.setSelectedFeatureListener(new C154702());
        AppMethodBeat.m2505o(11929);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(11930);
        super.onDestroy();
        this.oDy.onDestroy();
        this.ynx.release();
        AppMethodBeat.m2505o(11930);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(11931);
        if (!this.oDy.mo33289Ab()) {
            if (this.emC == 290 || this.emC == 291) {
                C7060h.pYm.mo8381e(13859, Integer.valueOf(1), Integer.valueOf(2));
            } else if (this.emC == 4 || this.emC == 293) {
                C7060h.pYm.mo8381e(13859, Integer.valueOf(2), Integer.valueOf(2));
            } else {
                C7060h.pYm.mo8381e(13859, Integer.valueOf(0), Integer.valueOf(2));
            }
            finish();
        }
        AppMethodBeat.m2505o(11931);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(11932);
        if (this.emC == 290 || this.emC == 291) {
            C7060h.pYm.mo8381e(13859, Integer.valueOf(1), Integer.valueOf(1));
        } else if (this.emC == 4 || this.emC == 293) {
            C7060h.pYm.mo8381e(13859, Integer.valueOf(2), Integer.valueOf(1));
        } else {
            C7060h.pYm.mo8381e(13859, Integer.valueOf(0), Integer.valueOf(1));
        }
        if (this.emC == 291 || this.emC == 293) {
            C46696j c46696j = new C46696j(this.mController.ylL);
            c46696j.rBl = new C154723();
            c46696j.rBm = new C154734();
            C30379h.m48455a(this.mController.ylL, c46696j.cuu());
            AppMethodBeat.m2505o(11932);
            return;
        }
        m23770Nh(-1);
        AppMethodBeat.m2505o(11932);
    }

    public final void onExit() {
        AppMethodBeat.m2504i(11933);
        onBackPressed();
        AppMethodBeat.m2505o(11933);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(11934);
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            C4990ab.m7411d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", intent.getStringExtra("Select_Conv_User"), this.ynu);
            this.ttv = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.g8l), false, null);
            this.yny.sendImage(intent.getStringExtra("custom_send_text"), this.ynu, this.yny.getSelfUsername(), r0);
            this.ttv.dismiss();
            if (this.ynv) {
                C40612a.m70043a(this.ynu, this);
            } else {
                C5730e.deleteFile(this.ynu);
            }
            finish();
            AppMethodBeat.m2505o(11934);
            return;
        }
        if (intent == null && !C5046bo.isNullOrNil(this.ynu) && this.emC == 291) {
            C5730e.deleteFile(this.ynu);
        }
        AppMethodBeat.m2505o(11934);
    }

    /* renamed from: Nh */
    private void m23770Nh(final int i) {
        AppMethodBeat.m2504i(11935);
        m23783fE(true);
        this.oDy.mo33292a(new C37464n() {
            public final void onError(Exception exception) {
                AppMethodBeat.m2504i(11925);
                MMNewPhotoEditUI.m23774b(MMNewPhotoEditUI.this);
                C4990ab.m7413e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", exception);
                Toast.makeText(C4996ah.getContext(), MMNewPhotoEditUI.this.getResources().getString(C25738R.string.g79), 1).show();
                MMNewPhotoEditUI.this.setResult(0);
                MMNewPhotoEditUI.this.finish();
                AppMethodBeat.m2505o(11925);
            }

            /* renamed from: b */
            public final void mo7985b(Bitmap bitmap, boolean z) {
                AppMethodBeat.m2504i(11926);
                C4990ab.m7417i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                try {
                    String RL = C40612a.m70042RL("jpg");
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, RL, true);
                    C4990ab.m7417i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", RL);
                    MMNewPhotoEditUI.this.yny.recordImage(MMNewPhotoEditUI.this.ynr, RL, MMNewPhotoEditUI.this.yns, MMNewPhotoEditUI.this.oDy.mo33290Ac().mo60383Az(), MMNewPhotoEditUI.this.oDy.mo33290Ac().mo60374AA());
                    if (MMNewPhotoEditUI.this.ynv || i == 2) {
                        C40612a.m70043a(RL, MMNewPhotoEditUI.this);
                    }
                    if (!(i == 0 || bitmap.isRecycled())) {
                        C4990ab.m7417i("MicroMsg.MMNewPhotoEditUI", "bitmap recycle %s", bitmap.toString());
                        bitmap.recycle();
                    }
                    MMNewPhotoEditUI.this.ynu = RL;
                    if (MMNewPhotoEditUI.this.emC != 291 && MMNewPhotoEditUI.this.emC != 293) {
                        MMNewPhotoEditUI.m23780d(MMNewPhotoEditUI.this, RL);
                    } else if (i == 0) {
                        MMNewPhotoEditUI.m23776b(MMNewPhotoEditUI.this, RL);
                        MMNewPhotoEditUI.m23774b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.m23775b(MMNewPhotoEditUI.this, 1);
                        AppMethodBeat.m2505o(11926);
                        return;
                    } else if (i == 1) {
                        MMNewPhotoEditUI.m23778c(MMNewPhotoEditUI.this, RL);
                        MMNewPhotoEditUI.m23775b(MMNewPhotoEditUI.this, 2);
                        Toast.makeText(C4996ah.getContext(), MMNewPhotoEditUI.this.getString(C25738R.string.g7f), 1).show();
                        MMNewPhotoEditUI.m23774b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.this.finish();
                        AppMethodBeat.m2505o(11926);
                        return;
                    } else if (i == 2) {
                        Toast.makeText(C4996ah.getContext(), MMNewPhotoEditUI.this.getString(C25738R.string.g7b, new Object[]{C6457e.euR}), 1).show();
                        MMNewPhotoEditUI.m23775b(MMNewPhotoEditUI.this, 3);
                        MMNewPhotoEditUI.m23774b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.this.finish();
                        AppMethodBeat.m2505o(11926);
                        return;
                    }
                    AppMethodBeat.m2505o(11926);
                } catch (IOException e) {
                    onError(e);
                    AppMethodBeat.m2505o(11926);
                }
            }
        });
        AppMethodBeat.m2505o(11935);
    }

    /* renamed from: fE */
    private void m23783fE(boolean z) {
        AppMethodBeat.m2504i(11936);
        C4990ab.m7417i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.ejZ = C44275p.m79966b(this, getString(C25738R.string.g8m), true, null);
            AppMethodBeat.m2505o(11936);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.m2505o(11936);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: a */
    static /* synthetic */ void m23772a(MMNewPhotoEditUI mMNewPhotoEditUI) {
        AppMethodBeat.m2504i(11937);
        Intent intent = mMNewPhotoEditUI.getIntent();
        mMNewPhotoEditUI.ynr = intent.getStringExtra("raw_photo_path");
        mMNewPhotoEditUI.yns = intent.getLongExtra("raw_photo_img_id", -1);
        mMNewPhotoEditUI.ynt = intent.getStringExtra("after_photo_edit");
        mMNewPhotoEditUI.emC = intent.getIntExtra("from_scene", 0);
        mMNewPhotoEditUI.ynw = intent.getBooleanExtra("from_scene_small_preview", false);
        mMNewPhotoEditUI.ynv = mMNewPhotoEditUI.yny.isAutoSave();
        AppMethodBeat.m2505o(11937);
    }

    /* renamed from: c */
    static /* synthetic */ void m23778c(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        AppMethodBeat.m2504i(11942);
        mMNewPhotoEditUI.yny.doFav(str);
        AppMethodBeat.m2505o(11942);
    }

    /* renamed from: d */
    static /* synthetic */ void m23780d(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        Object obj;
        AppMethodBeat.m2504i(11943);
        C4990ab.m7417i("MicroMsg.MMNewPhotoEditUI", "[gotoImagePreviewUI] :%s", str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList stringArrayListExtra = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_image_list");
        ArrayList stringArrayListExtra2 = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_select_image_list");
        int i = 0;
        while (stringArrayListExtra != null && i < stringArrayListExtra.size()) {
            obj = (String) stringArrayListExtra.get(i);
            if (obj.equalsIgnoreCase(C5046bo.nullAsNil(mMNewPhotoEditUI.ynr)) || obj.equalsIgnoreCase(C5046bo.nullAsNil(mMNewPhotoEditUI.ynt))) {
                obj = str;
            }
            arrayList.add(obj);
            i++;
        }
        i = 0;
        while (stringArrayListExtra2 != null && i < stringArrayListExtra2.size()) {
            obj = (String) stringArrayListExtra2.get(i);
            if (obj.equalsIgnoreCase(C5046bo.nullAsNil(mMNewPhotoEditUI.ynr)) || obj.equalsIgnoreCase(C5046bo.nullAsNil(mMNewPhotoEditUI.ynt))) {
                obj = str;
            }
            arrayList2.add(obj);
            i++;
        }
        String str2 = null;
        if (!mMNewPhotoEditUI.ynv) {
            str2 = mMNewPhotoEditUI.yny.getFullPath("photoEdited_" + System.currentTimeMillis());
            C5730e.m8644y(str, str2);
        }
        C5730e.deleteFile(mMNewPhotoEditUI.ynt);
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
        bundle.putInt("report_info_emotion_count", mMNewPhotoEditUI.oDy.mo33290Ac().mo60376As());
        bundle.putInt("report_info_text_count", mMNewPhotoEditUI.oDy.mo33290Ac().mo60375Ar());
        bundle.putInt("report_info_mosaic_count", mMNewPhotoEditUI.oDy.mo33290Ac().mo60377At());
        bundle.putInt("report_info_doodle_count", mMNewPhotoEditUI.oDy.mo33290Ac().mo60378Au());
        bundle.putBoolean("report_info_iscrop", mMNewPhotoEditUI.oDy.mo33290Ac().isCropped());
        bundle.putInt("report_info_undo_count", mMNewPhotoEditUI.oDy.mo33290Ac().mo60379Av());
        bundle.putBoolean("report_info_is_rotation", mMNewPhotoEditUI.oDy.mo33290Ac().mo60380Aw());
        intent.putExtra("report_info", bundle);
        str2 = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (!C5046bo.isNullOrNil(str2)) {
            intent.putExtra("GalleryUI_FromUser", str2);
        }
        if (!C5046bo.isNullOrNil(stringExtra)) {
            intent.putExtra("GalleryUI_ToUser", stringExtra);
        }
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putStringArrayListExtra("preview_select_image_list", arrayList2);
        mMNewPhotoEditUI.setResult(-1, intent);
        mMNewPhotoEditUI.m23783fE(false);
        mMNewPhotoEditUI.finish();
        AppMethodBeat.m2505o(11943);
    }
}
