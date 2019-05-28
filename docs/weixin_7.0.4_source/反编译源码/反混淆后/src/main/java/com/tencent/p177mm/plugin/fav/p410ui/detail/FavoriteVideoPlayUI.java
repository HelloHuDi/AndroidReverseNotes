package com.tencent.p177mm.plugin.fav.p410ui.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p410ui.C11909i.C119125;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavVideoView;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI */
public class FavoriteVideoPlayUI extends MMActivity {
    private boolean cHc = true;
    private String ePJ;
    private int eWK;
    private Bundle jWy;
    private boolean jYD = false;
    private C30759e jYE;
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private OnClickListener mjE = new C390661();
    private OnLongClickListener mlV = new C430762();
    private boolean mmD = true;
    private String mmV;
    private RelativeLayout mmW;
    private ImageView mmX;
    private FavVideoView mmY;
    private LinearLayout mmZ;
    private boolean mna = true;
    private int mnb;
    private boolean mnc = false;
    private String mnd = "";
    private String thumbPath;

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI$5 */
    class C280205 implements C24051b {

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI$5$1 */
        class C119041 implements Runnable {
            C119041() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74464);
                FavoriteVideoPlayUI.this.finish();
                FavoriteVideoPlayUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(74464);
            }
        }

        C280205() {
        }

        public final void onAnimationStart() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(74465);
            new C7306ak().post(new C119041());
            AppMethodBeat.m2505o(74465);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI$1 */
    class C390661 implements OnClickListener {
        C390661() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74457);
            FavoriteVideoPlayUI.this.bcW();
            AppMethodBeat.m2505o(74457);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI$4 */
    class C390674 implements OnPreDrawListener {

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI$4$1 */
        class C247571 implements C24051b {
            C247571() {
            }

            public final void onAnimationStart() {
                AppMethodBeat.m2504i(74462);
                if (FavoriteVideoPlayUI.this.mmY != null) {
                    FavoriteVideoPlayUI.this.mmY.onResume();
                }
                AppMethodBeat.m2505o(74462);
            }

            public final void onAnimationEnd() {
            }
        }

        C390674() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(74463);
            FavoriteVideoPlayUI.this.mmY.getViewTreeObserver().removeOnPreDrawListener(this);
            FavoriteVideoPlayUI.this.jYE.mo49166a(FavoriteVideoPlayUI.this.mmY, FavoriteVideoPlayUI.this.mmX, new C247571());
            AppMethodBeat.m2505o(74463);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI$2 */
    class C430762 implements OnLongClickListener {

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI$2$1 */
        class C430741 implements C36073c {
            C430741() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(74458);
                if (FavoriteVideoPlayUI.this.mna) {
                    if (C5730e.m8628ct(FavoriteVideoPlayUI.this.thumbPath)) {
                        c44273l.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(C25738R.string.bri));
                    }
                    c44273l.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(C25738R.string.dx0));
                }
                AppMethodBeat.m2505o(74458);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI$2$2 */
        class C430772 implements C5279d {
            C430772() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(74459);
                switch (menuItem.getItemId()) {
                    case 1:
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        intent.putExtra("mutil_select_is_ret", true);
                        if (C5730e.m8628ct(FavoriteVideoPlayUI.this.thumbPath)) {
                            intent.putExtra("image_path", FavoriteVideoPlayUI.this.thumbPath);
                        } else {
                            intent.putExtra("image_path", FavoriteVideoPlayUI.this.ePJ);
                        }
                        intent.putExtra("Retr_Msg_Type", 1);
                        C25985d.m41466b(FavoriteVideoPlayUI.this.mController.ylL, ".ui.transmit.SelectConversationUI", intent, 1);
                        if (FavoriteVideoPlayUI.this.mnb == 0) {
                            C27968h.m44531j(FavoriteVideoPlayUI.this.getIntent().getLongExtra("key_detail_info_id", 0), 1, 0);
                            AppMethodBeat.m2505o(74459);
                            return;
                        }
                        break;
                    case 2:
                        FavoriteVideoPlayUI.m76562f(FavoriteVideoPlayUI.this.ePJ, FavoriteVideoPlayUI.this);
                        break;
                }
                AppMethodBeat.m2505o(74459);
            }
        }

        C430762() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(74460);
            view.getTag();
            C46696j c46696j = new C46696j(FavoriteVideoPlayUI.this.mController.ylL);
            c46696j.rBl = new C430741();
            c46696j.rBm = new C430772();
            c46696j.cuu();
            AppMethodBeat.m2505o(74460);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavoriteVideoPlayUI() {
        AppMethodBeat.m2504i(74466);
        AppMethodBeat.m2505o(74466);
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(74467);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (C1443d.m3068iW(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.jWy = bundle;
        getWindow().addFlags(128);
        this.mna = getIntent().getBooleanExtra("key_detail_data_valid", true);
        this.ePJ = getIntent().getStringExtra("key_detail_fav_path");
        this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
        this.eWK = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
        this.mmV = getIntent().getStringExtra("key_detail_statExtStr");
        this.mnb = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.mnc = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
        this.mnd = getIntent().getStringExtra("key_detail_data_id");
        if (!C5730e.m8628ct(this.thumbPath)) {
            Bitmap LY = C45932c.m85253LY(this.ePJ);
            if (LY != null) {
                try {
                    C4990ab.m7416i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
                    C5056d.m7625a(LY, 60, CompressFormat.JPEG, this.thumbPath, true);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", e, "", new Object[0]);
                }
            }
        }
        String str2 = "MicroMsg.FavoriteVideoPlayUI";
        String str3 = "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.mna);
        objArr[1] = C5046bo.isNullOrNil(this.thumbPath) ? "" : this.thumbPath;
        if (C5046bo.isNullOrNil(this.ePJ)) {
            str = "";
        } else {
            str = this.ePJ;
        }
        objArr[2] = str;
        C4990ab.m7417i(str2, str3, objArr);
        this.mmW = (RelativeLayout) findViewById(2131822132);
        this.mmY = (FavVideoView) findViewById(2131821402);
        ImageView imageView = (ImageView) findViewById(2131822133);
        this.mmX = (ImageView) findViewById(2131822079);
        this.mmZ = (LinearLayout) findViewById(2131823884);
        if (!(this.mna || this.mmZ == null)) {
            this.mmZ.setVisibility(0);
        }
        if (this.mmX != null) {
            this.mmX.setLayerType(2, null);
        }
        if (C5046bo.isNullOrNil(this.ePJ)) {
            m76564g(imageView);
        } else if (C5730e.m8628ct(this.ePJ)) {
            this.mmY.setVideoData(this.ePJ);
            C4990ab.m7416i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
        } else {
            m76564g(imageView);
        }
        this.mmY.setOnClickListener(this.mjE);
        if (this.cHc) {
            this.mmY.setOnLongClickListener(this.mlV);
        }
        this.jYE = new C30759e(null);
        AppMethodBeat.m2505o(74467);
    }

    public final int getLayoutId() {
        return 2130969533;
    }

    /* renamed from: g */
    private void m76564g(ImageView imageView) {
        AppMethodBeat.m2504i(74468);
        this.mmY.mo73797a(this.ePJ, this.mnc, this.mnd);
        if (imageView != null) {
            if (C5730e.m8628ct(this.thumbPath)) {
                imageView.setImageBitmap(C4977b.m7374i(this.thumbPath, 1.0f));
            } else {
                imageView.setImageResource(C25738R.drawable.b0z);
            }
        }
        C4990ab.m7416i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
        AppMethodBeat.m2505o(74468);
    }

    /* renamed from: f */
    public static void m76562f(String str, Context context) {
        AppMethodBeat.m2504i(74469);
        String uu = C26494u.m42269uu(str);
        C4990ab.m7417i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", str, uu);
        if (C5046bo.isNullOrNil(uu)) {
            Toast.makeText(context, context.getString(C25738R.string.f1c), 1).show();
            AppMethodBeat.m2505o(74469);
            return;
        }
        Toast.makeText(context, context.getString(C25738R.string.f1d, new Object[]{uu}), 1).show();
        C14987n.m23300a(uu, context);
        AppMethodBeat.m2505o(74469);
    }

    public void onStart() {
        AppMethodBeat.m2504i(74470);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT >= 12) {
                this.kkq = getIntent().getIntExtra("img_gallery_top", 0);
                this.kkr = getIntent().getIntExtra("img_gallery_left", 0);
                this.kks = getIntent().getIntExtra("img_gallery_width", 0);
                this.kkt = getIntent().getIntExtra("img_gallery_height", 0);
                this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.mmY.getViewTreeObserver().addOnPreDrawListener(new C390674());
                }
            }
        }
        super.onStart();
        AppMethodBeat.m2505o(74470);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74471);
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        C4990ab.m7417i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", Boolean.valueOf(this.mmD));
        if (!this.mmD) {
            this.mmY.onResume();
        }
        this.mmD = false;
        super.onResume();
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(74471);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74472);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        FavVideoView favVideoView = this.mmY;
        C4990ab.m7416i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
        if (favVideoView.klq.isPlaying()) {
            C4990ab.m7416i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
            favVideoView.klq.pause();
        }
        super.onPause();
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(74472);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74473);
        setResult(0, getIntent().putExtra("key_activity_browse_time", dyi()));
        this.mmY.onDestroy();
        getWindow().clearFlags(128);
        super.onDestroy();
        AppMethodBeat.m2505o(74473);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(74474);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(74474);
        return dispatchKeyEvent;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74475);
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C430753 c430753 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74461);
                    b.dismiss();
                    AppMethodBeat.m2505o(74461);
                }
            };
            if (C5046bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.m2505o(74475);
                return;
            }
            for (String stringExtra2 : C5046bo.m7508P(stringExtra2.split(","))) {
                AppCompatActivity appCompatActivity = this.mController.ylL;
                String str2 = this.ePJ;
                String str3 = this.thumbPath;
                int i3 = this.eWK;
                String str4 = this.mmV;
                if (appCompatActivity == null) {
                    C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                } else if (C5046bo.isNullOrNil(stringExtra2)) {
                    C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                } else {
                    C5728b c5728b = new C5728b(str2);
                    if (!C5046bo.isNullOrNil(str2) || c5728b.exists()) {
                        C1720g.m3539RS().mo10302aa(new C119125(appCompatActivity, stringExtra2, str2, str3, i3, str4, c430753));
                    } else {
                        C4990ab.m7420w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
                    }
                }
                if (!C5046bo.isNullOrNil(str)) {
                    C12519g.bOk().mo46456F(stringExtra2, str, C1855t.m3925nK(stringExtra2));
                }
            }
            C5670b.m8523i(this, getString(C25738R.string.bnf));
            AppMethodBeat.m2505o(74475);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(74475);
    }

    public final void bcW() {
        AppMethodBeat.m2504i(74476);
        this.mmZ.setVisibility(8);
        int width = this.mmW.getWidth();
        int height = this.mmW.getHeight();
        if (!(this.kks == 0 || this.kkt == 0)) {
            height = (int) ((((float) width) / ((float) this.kks)) * ((float) this.kkt));
        }
        this.jYE.mo49168hw(width, height);
        this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
        this.jYE.mo49167a(this.mmY, this.mmX, new C280205(), null);
        AppMethodBeat.m2505o(74476);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(74477);
        bcW();
        AppMethodBeat.m2505o(74477);
    }
}
