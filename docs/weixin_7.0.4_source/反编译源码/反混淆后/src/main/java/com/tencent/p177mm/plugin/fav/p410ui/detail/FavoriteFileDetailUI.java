package com.tencent.p177mm.plugin.fav.p410ui.detail;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.p069v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27962am;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h.C27969a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C39038m;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C20676b;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C20677d;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C27971a;
import com.tencent.p177mm.plugin.fav.p407a.C39038m.C27972c;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C6892ab;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C11909i;
import com.tencent.p177mm.plugin.fav.p410ui.C11909i.C119082;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46510q;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aau;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI */
public class FavoriteFileDetailUI extends BaseFavDetailReportUI implements C11855p, C4931a {
    private aar cAv;
    private boolean cHc = true;
    private long cvv;
    private C7306ak fbD;
    private TextView gxi;
    private TextView iqU;
    private int jLX;
    private int jLY;
    private C24088a jMO = null;
    private C14979e klq = null;
    private C5279d lCi = new C3416617();
    private C27966g mgf;
    private C41268k mjD = new C41268k();
    private Button mlD;
    private Button mlE;
    private Button mlF;
    private MMImageView mlG;
    private TextView mlH;
    private View mlI;
    private View mlJ;
    private TextView mlK;
    private ImageView mlL;
    private TextView mlM;
    private boolean mlN = false;
    private boolean mlO = false;
    private String mlP;
    private String mlQ;
    private boolean mlR = false;
    private boolean mlS = false;
    private boolean mlT = false;
    private OnTouchListener mlU = new C207192();
    private OnLongClickListener mlV = new C367693();
    private ProgressBar progressBar;

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$14 */
    class C1189514 implements OnClickListener {
        C1189514() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74336);
            C4990ab.m7417i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(FavoriteFileDetailUI.this.mgf.field_id), Long.valueOf(FavoriteFileDetailUI.this.mgf.field_localId), Integer.valueOf(FavoriteFileDetailUI.this.mgf.field_itemStatus));
            if (C1445f.m3070Mn()) {
                if (FavoriteFileDetailUI.this.mgf.bux() || C5046bo.isNullOrNil(FavoriteFileDetailUI.this.cAv.wfZ)) {
                    C39037b.m66410l(FavoriteFileDetailUI.this.mgf);
                } else if (FavoriteFileDetailUI.this.mlO) {
                    FavoriteFileDetailUI.this.mgf.field_itemStatus = 7;
                    C39037b.m66375b(FavoriteFileDetailUI.this.cAv, 18, -1);
                } else {
                    C39037b.m66360a(FavoriteFileDetailUI.this.mgf, FavoriteFileDetailUI.this.cAv, true);
                }
                FavoriteFileDetailUI.m61021g(FavoriteFileDetailUI.this);
                AppMethodBeat.m2505o(74336);
                return;
            }
            C30379h.m48467g(FavoriteFileDetailUI.this.mController.ylL, C25738R.string.bpt, C25738R.string.bnl);
            AppMethodBeat.m2505o(74336);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$15 */
    class C1189615 implements OnClickListener {
        C1189615() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74337);
            if (FavoriteFileDetailUI.this.mgf.isDownloading()) {
                C39037b.m66384d(FavoriteFileDetailUI.this.cAv);
                FavoriteFileDetailUI.this.mlF.setText(C25738R.string.bpg);
            } else {
                C39037b.m66413n(FavoriteFileDetailUI.this.mgf);
                FavoriteFileDetailUI.this.mlF.setText(C25738R.string.bph);
            }
            FavoriteFileDetailUI.m61024i(FavoriteFileDetailUI.this);
            AppMethodBeat.m2505o(74337);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$2 */
    class C207192 implements OnTouchListener {
        C207192() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74322);
            switch (motionEvent.getAction()) {
                case 0:
                    FavoriteFileDetailUI.this.jLX = (int) motionEvent.getRawX();
                    FavoriteFileDetailUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(74322);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$9 */
    class C207229 implements Runnable {
        C207229() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74331);
            FavoriteFileDetailUI.m61037v(FavoriteFileDetailUI.this);
            AppMethodBeat.m2505o(74331);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$17 */
    class C3416617 implements C5279d {
        C3416617() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            CharSequence string;
            AppMethodBeat.m2504i(74344);
            ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
            if (FavoriteFileDetailUI.this.cAv.title.equals("")) {
                string = FavoriteFileDetailUI.this.getString(C25738R.string.dar);
            } else {
                string = FavoriteFileDetailUI.this.cAv.title;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, string));
            C30379h.m48465bQ(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(C25738R.string.f9083oz));
            AppMethodBeat.m2505o(74344);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$11 */
    class C3676711 implements OnMenuItemClickListener {
        C3676711() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74333);
            C39038m.m66421a(C27971a.LeavelFullScreen, FavoriteFileDetailUI.this.mgf);
            FavoriteFileDetailUI.this.finish();
            AppMethodBeat.m2505o(74333);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$4 */
    class C367684 implements C14981a {

        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$4$1 */
        class C341671 implements Runnable {
            C341671() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74324);
                C30379h.m48467g(FavoriteFileDetailUI.this.mController.ylL, C25738R.string.f1a, C25738R.string.f1j);
                Bitmap a = C45939l.m85275a(FavoriteFileDetailUI.this.cAv, FavoriteFileDetailUI.this.mgf);
                ImageView imageView = (ImageView) FavoriteFileDetailUI.this.findViewById(2131823993);
                if (imageView != null) {
                    imageView.setImageBitmap(a);
                    imageView.setVisibility(0);
                }
                AppMethodBeat.m2505o(74324);
            }
        }

        C367684() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(74325);
            C4990ab.m7410d("MicroMsg.FavoriteFileDetailUI", C1447g.m3074Mp() + " onPrepared");
            FavoriteFileDetailUI.this.klq.setLoop(true);
            FavoriteFileDetailUI.this.klq.start();
            AppMethodBeat.m2505o(74325);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(74326);
            FavoriteFileDetailUI.this.klq.stop();
            if (FavoriteFileDetailUI.this.mlN) {
                AppMethodBeat.m2505o(74326);
                return;
            }
            FavoriteFileDetailUI.this.mlN = true;
            C5004al.m7441d(new C341671());
            AppMethodBeat.m2505o(74326);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$3 */
    class C367693 implements OnLongClickListener {
        C367693() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(74323);
            C4990ab.m7410d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
            if (FavoriteFileDetailUI.this.jMO == null) {
                FavoriteFileDetailUI.this.jMO = new C24088a(FavoriteFileDetailUI.this.mController.ylL);
            }
            FavoriteFileDetailUI.this.jMO.mo39886a(view, FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.lCi, FavoriteFileDetailUI.this.jLX, FavoriteFileDetailUI.this.jLY);
            AppMethodBeat.m2505o(74323);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$6 */
    class C367706 implements Runnable {
        C367706() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74328);
            C39037b.m66414o(FavoriteFileDetailUI.this.mgf);
            AppMethodBeat.m2505o(74328);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$10 */
    class C3677110 implements OnClickListener {
        C3677110() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74332);
            C39038m.m66421a(C27971a.EnterCompleteVideo, FavoriteFileDetailUI.this.mgf);
            aau aau = FavoriteFileDetailUI.this.cAv.wgZ;
            String c = C39037b.m66379c(FavoriteFileDetailUI.this.cAv);
            Intent intent = new Intent();
            intent.putExtra("IsAd", false);
            intent.putExtra("KStremVideoUrl", aau.fiG);
            intent.putExtra("StreamWording", aau.fiJ);
            intent.putExtra("StremWebUrl", aau.fiK);
            intent.putExtra("KBlockFav", true);
            intent.putExtra("KThumUrl", aau.fiL);
            intent.putExtra("KThumbPath", c);
            intent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.this.mgf.field_id);
            intent.putExtra("KMediaVideoTime", aau.wid);
            intent.putExtra("KMediaTitle", FavoriteFileDetailUI.this.cAv.title);
            intent.putExtra("KSta_StremVideoAduxInfo", aau.fiM);
            intent.putExtra("KSta_StremVideoPublishId", aau.fiN);
            intent.putExtra("KSta_SourceType", 1);
            intent.putExtra("KSta_Scene", C20676b.Fav.value);
            intent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.this.mgf.field_fromUser);
            intent.putExtra("KSta_FavID", FavoriteFileDetailUI.this.mgf.field_id);
            intent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.this.cAv.cMn);
            C25985d.m41467b(FavoriteFileDetailUI.this, "sns", ".ui.VideoAdPlayerUI", intent);
            AppMethodBeat.m2505o(74332);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$12 */
    class C3677212 implements OnClickListener {
        C3677212() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74334);
            String b = C39037b.m66370b(FavoriteFileDetailUI.this.cAv);
            if (4 == FavoriteFileDetailUI.m61017c(FavoriteFileDetailUI.this)) {
                FavoriteFileDetailUI.this.mlR = false;
                FavoriteFileDetailUI.m61019e(FavoriteFileDetailUI.this);
                AppMethodBeat.m2505o(74334);
                return;
            }
            FavoriteFileDetailUI.m61013a(FavoriteFileDetailUI.this, b);
            AppMethodBeat.m2505o(74334);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$5 */
    class C367735 implements OnClickListener {
        C367735() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74327);
            FavoriteFileDetailUI.m61034s(FavoriteFileDetailUI.this);
            AppMethodBeat.m2505o(74327);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavoriteFileDetailUI() {
        AppMethodBeat.m2504i(74345);
        AppMethodBeat.m2505o(74345);
    }

    /* renamed from: c */
    static /* synthetic */ int m61017c(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.m2504i(74365);
        int type = favoriteFileDetailUI.getType();
        AppMethodBeat.m2505o(74365);
        return type;
    }

    /* renamed from: e */
    static /* synthetic */ void m61019e(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.m2504i(74366);
        favoriteFileDetailUI.bnS();
        AppMethodBeat.m2505o(74366);
    }

    /* renamed from: g */
    static /* synthetic */ void m61021g(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.m2504i(74368);
        favoriteFileDetailUI.bwi();
        AppMethodBeat.m2505o(74368);
    }

    /* renamed from: i */
    static /* synthetic */ void m61024i(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.m2504i(74369);
        favoriteFileDetailUI.bwj();
        AppMethodBeat.m2505o(74369);
    }

    /* renamed from: v */
    static /* synthetic */ void m61037v(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.m2504i(74373);
        favoriteFileDetailUI.m61023hl(true);
        AppMethodBeat.m2505o(74373);
    }

    public final int getLayoutId() {
        return 2130969536;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void bwg() {
        AppMethodBeat.m2504i(74346);
        this.mlQ = getIntent().getStringExtra("key_detail_data_id");
        Iterator it = this.mgf.field_favProto.wiv.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.mnd.equals(this.mlQ)) {
                this.cAv = aar;
                break;
            }
        }
        if (this.cAv == null) {
            this.cAv = C39037b.m66378c(this.mgf);
        }
        AppMethodBeat.m2505o(74346);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.m2504i(74347);
        super.onCreate(bundle);
        this.fbD = new C7306ak();
        this.cvv = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mlO = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.mlP = getIntent().getStringExtra("fav_note_xml");
        this.mgf = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.cvv);
        if (this.mlO && !C5046bo.isNullOrNil(this.mlP)) {
            this.mgf = C39037b.m66341LF(this.mlP);
        }
        if (this.mgf == null) {
            C4990ab.m7420w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
            finish();
            AppMethodBeat.m2505o(74347);
            return;
        }
        String str;
        mo54744F(this.mgf);
        C39038m.m66423w(this.mgf);
        bwg();
        this.mlD = (Button) findViewById(2131823997);
        this.mlE = (Button) findViewById(2131823998);
        this.mlF = (Button) findViewById(2131822658);
        this.mlG = (MMImageView) findViewById(2131821226);
        this.gxi = (TextView) findViewById(2131821227);
        this.iqU = (TextView) findViewById(2131823800);
        this.mlJ = findViewById(2131821526);
        this.mlI = findViewById(2131821524);
        this.progressBar = (ProgressBar) findViewById(2131821525);
        this.mlH = (TextView) findViewById(2131823996);
        this.mlK = (TextView) findViewById(2131827573);
        this.mlL = (ImageView) findViewById(2131823994);
        this.mlM = (TextView) findViewById(2131823995);
        this.gxi.setOnTouchListener(this.mlU);
        this.gxi.setOnLongClickListener(this.mlV);
        int type = getType();
        if (4 == type) {
            setMMTitle((int) C25738R.string.bs9);
        } else if (15 == type) {
            setMMTitle((int) C25738R.string.bs9);
            findViewById(2131823992).setBackgroundResource(C25738R.color.f11782h4);
            this.gxi.setVisibility(8);
        } else {
            setMMTitle((int) C25738R.string.bp0);
        }
        if (this.cAv.dataType == 4) {
            this.mlG.setImageResource(C1318a.app_attach_file_icon_video);
        } else {
            this.mlG.setImageResource(((C6892ab) C1720g.m3528K(C6892ab.class)).mo15145LU(this.cAv.wgo));
        }
        this.gxi.setText(this.cAv.title);
        aau aau = this.cAv.wgZ;
        if (aau == null) {
            this.mlK.setVisibility(8);
        } else if (C5046bo.isNullOrNil(aau.fiG)) {
            C4990ab.m7416i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
            str = aau.fiJ;
            final String str2 = aau.fiK;
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                this.mlK.setVisibility(8);
            } else {
                this.mlK.setText(str);
                this.mlK.setVisibility(0);
                this.mlK.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(74321);
                        final Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", FavoriteFileDetailUI.this.cAv.cMn);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("useJs", true);
                        new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(74320);
                                C25985d.m41467b(FavoriteFileDetailUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                FavoriteFileDetailUI.this.finish();
                                AppMethodBeat.m2505o(74320);
                            }
                        });
                        AppMethodBeat.m2505o(74321);
                    }
                });
            }
        } else {
            str = getResources().getString(C25738R.string.ej7);
            if (aau.wid / 60 > 0) {
                str = str + getResources().getString(C25738R.string.ej9, new Object[]{Integer.valueOf(aau.wid / 60)});
            }
            if (aau.wid % 60 > 0) {
                str = str + getResources().getString(C25738R.string.ej_, new Object[]{Integer.valueOf(aau.wid % 60)});
            }
            this.mlK.setText(str + getResources().getString(C25738R.string.ej8));
            this.mlK.setVisibility(0);
            this.mlK.setOnClickListener(new C3677110());
        }
        setBackBtn(new C3676711());
        this.mlE.setOnClickListener(new C3677212());
        str = this.cAv.wgg;
        if (!C5046bo.isNullOrNil(str)) {
            this.mlD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(74335);
                    C4990ab.m7411d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", Integer.valueOf(FavoriteFileDetailUI.this.mgf.field_id), Long.valueOf(FavoriteFileDetailUI.this.mgf.field_localId));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", FavoriteFileDetailUI.this.mgf.field_localId);
                    intent.putExtra("geta8key_scene", 14);
                    intent.putExtra("geta8key_scene", 14);
                    C25985d.m41467b(FavoriteFileDetailUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(74335);
                }
            });
        }
        this.mlF.setOnClickListener(new C1189514());
        this.mlJ.setOnClickListener(new C1189615());
        if (this.cHc) {
            boolean z2;
            final boolean booleanExtra = getIntent().getBooleanExtra("key_detail_can_delete", true);
            final int type2 = getType();
            if (type2 == 8) {
                z = this.mgf.but();
            } else if (type2 == 15) {
                z2 = this.mgf.but() && C5046bo.ank(C26373g.m41964Nu().getValue("SIGHTCannotTransmitForFav")) == 0;
                if (z2 || booleanExtra) {
                    addIconOptionMenu(0, C25738R.string.ewm, C25738R.drawable.f6899uu, new OnMenuItemClickListener() {

                        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$16$1 */
                        class C30911 implements C36073c {
                            C30911() {
                            }

                            /* renamed from: a */
                            public final void mo5746a(C44273l c44273l) {
                                AppMethodBeat.m2504i(74338);
                                if (z2) {
                                    FavoriteFileDetailUI.this.mjD;
                                    if (!C41268k.m71868h(FavoriteFileDetailUI.this.cAv) && FavoriteFileDetailUI.this.cAv.whh == 0) {
                                        if (type2 == 8) {
                                            c44273l.mo70068e(0, FavoriteFileDetailUI.this.getString(C25738R.string.bri));
                                        } else if (type2 == 15) {
                                            c44273l.mo70068e(0, FavoriteFileDetailUI.this.getString(C25738R.string.bri));
                                            c44273l.mo70068e(4, FavoriteFileDetailUI.this.getString(C25738R.string.dx0));
                                        } else if (type2 == 4) {
                                            c44273l.mo70068e(0, FavoriteFileDetailUI.this.getString(C25738R.string.bri));
                                            c44273l.mo70068e(4, FavoriteFileDetailUI.this.getString(C25738R.string.dx0));
                                        } else {
                                            c44273l.mo70068e(0, FavoriteFileDetailUI.this.getString(C25738R.string.bri));
                                            if (booleanExtra && FavoriteFileDetailUI.this.mgf.buu()) {
                                                c44273l.mo70068e(1, FavoriteFileDetailUI.this.getString(C25738R.string.bq_));
                                            }
                                        }
                                    }
                                }
                                if (booleanExtra) {
                                    c44273l.mo70068e(3, FavoriteFileDetailUI.this.getString(C25738R.string.bo8));
                                    c44273l.mo70068e(2, FavoriteFileDetailUI.this.mController.ylL.getString(C25738R.string.f9088p4));
                                }
                                AppMethodBeat.m2505o(74338);
                            }
                        }

                        /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$16$2 */
                        class C30922 implements C5279d {

                            /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI$16$2$2 */
                            class C30942 implements DialogInterface.OnClickListener {
                                C30942() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(74341);
                                    final C44275p b = C30379h.m48458b(FavoriteFileDetailUI.this.mController.ylL, FavoriteFileDetailUI.this.getString(C25738R.string.f9089p5), false, null);
                                    C39037b.m66365a(FavoriteFileDetailUI.this.mgf.field_localId, new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(74340);
                                            FavoriteFileDetailUI.this.mlz.mfd = true;
                                            b.dismiss();
                                            C4990ab.m7411d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", Long.valueOf(FavoriteFileDetailUI.this.mgf.field_localId), Integer.valueOf(FavoriteFileDetailUI.this.mgf.field_id));
                                            FavoriteFileDetailUI.this.finish();
                                            AppMethodBeat.m2505o(74340);
                                        }
                                    });
                                    AppMethodBeat.m2505o(74341);
                                }
                            }

                            C30922() {
                            }

                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.m2504i(74342);
                                C27969a c27969a;
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        if (FavoriteFileDetailUI.m61017c(FavoriteFileDetailUI.this) == 8) {
                                            String b = C39037b.m66370b(FavoriteFileDetailUI.this.cAv);
                                            if (!C5730e.m8628ct(b)) {
                                                C4990ab.m7412e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                                                Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(C25738R.string.brg), 1).show();
                                                AppMethodBeat.m2505o(74342);
                                                return;
                                            } else if (new C5728b(b).length() > 10485760) {
                                                C4990ab.m7412e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                                                Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(C25738R.string.brh), 1).show();
                                                AppMethodBeat.m2505o(74342);
                                                return;
                                            }
                                        }
                                        c27969a = FavoriteFileDetailUI.this.mlz;
                                        c27969a.meZ++;
                                        FavoriteFileDetailUI.m61012a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.mgf);
                                        AppMethodBeat.m2505o(74342);
                                        return;
                                    case 1:
                                        c27969a = FavoriteFileDetailUI.this.mlz;
                                        c27969a.mfa++;
                                        final C44275p b2 = C30379h.m48458b(FavoriteFileDetailUI.this.mController.ylL, FavoriteFileDetailUI.this.getString(C25738R.string.bp2), false, null);
                                        AppCompatActivity appCompatActivity = FavoriteFileDetailUI.this.mController.ylL;
                                        C27966g b3 = FavoriteFileDetailUI.this.mgf;
                                        C30931 c30931 = new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.m2504i(74339);
                                                b2.dismiss();
                                                AppMethodBeat.m2505o(74339);
                                            }
                                        };
                                        LinkedList linkedList = new LinkedList();
                                        linkedList.add(Integer.valueOf(b3.field_id));
                                        C1720g.m3540Rg().mo14541a(new C27962am("", linkedList, new C119082(b3, appCompatActivity, c30931)), 0);
                                        AppMethodBeat.m2505o(74342);
                                        return;
                                    case 2:
                                        C30379h.m48440a(FavoriteFileDetailUI.this.mController.ylL, FavoriteFileDetailUI.this.getString(C25738R.string.f9089p5), "", new C30942(), null);
                                        AppMethodBeat.m2505o(74342);
                                        return;
                                    case 3:
                                        c27969a = FavoriteFileDetailUI.this.mlz;
                                        c27969a.mfc++;
                                        Intent intent = new Intent();
                                        intent.putExtra("key_fav_scene", 2);
                                        intent.putExtra("key_fav_item_id", FavoriteFileDetailUI.this.mgf.field_localId);
                                        C39037b.m66371b(FavoriteFileDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                                        AppMethodBeat.m2505o(74342);
                                        return;
                                    case 4:
                                        FavoriteFileDetailUI.m61026k(FavoriteFileDetailUI.this);
                                        break;
                                }
                                AppMethodBeat.m2505o(74342);
                            }
                        }

                        /* JADX WARNING: Missing block: B:5:0x0025, code skipped:
            if (com.tencent.p177mm.plugin.fav.p410ui.detail.FavoriteFileDetailUI.m61010a(r5.mlX).whh == 0) goto L_0x002f;
     */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.m2504i(74343);
                            if (z2) {
                                FavoriteFileDetailUI.this.mjD;
                                if (!C41268k.m71868h(FavoriteFileDetailUI.this.cAv)) {
                                }
                            }
                            if (!booleanExtra) {
                                AppMethodBeat.m2505o(74343);
                                return false;
                            }
                            C36356d c36356d = new C36356d(FavoriteFileDetailUI.this.mController.ylL, 1, false);
                            c36356d.rBl = new C30911();
                            c36356d.rBm = new C30922();
                            c36356d.cpD();
                            AppMethodBeat.m2505o(74343);
                            return true;
                        }
                    });
                }
            } else if (!(this.mgf.buu() || this.mgf.but())) {
                z = false;
            }
            z2 = z;
            addIconOptionMenu(0, C25738R.string.ewm, C25738R.drawable.f6899uu, /* anonymous class already generated */);
        }
        m61023hl(false);
        AppMethodBeat.m2505o(74347);
    }

    private int getType() {
        AppMethodBeat.m2504i(74348);
        if (this.cAv == null) {
            C4990ab.m7420w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
            AppMethodBeat.m2505o(74348);
            return 8;
        } else if (this.cAv.dataType == 0) {
            C4990ab.m7421w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", Integer.valueOf(this.mgf.field_type));
            if (4 == this.mgf.field_type) {
                AppMethodBeat.m2505o(74348);
                return 4;
            } else if (16 == this.mgf.field_type) {
                if (!(this.cAv == null || this.cAv.wgZ == null)) {
                    if (!C5046bo.isNullOrNil(this.cAv.wgZ.fiG)) {
                        AppMethodBeat.m2505o(74348);
                        return 15;
                    } else if (!C5046bo.isNullOrNil(this.cAv.wgZ.fiK)) {
                        AppMethodBeat.m2505o(74348);
                        return 15;
                    }
                }
                AppMethodBeat.m2505o(74348);
                return 4;
            } else {
                AppMethodBeat.m2505o(74348);
                return 8;
            }
        } else if (this.cAv.dataType == 15) {
            if (!(this.cAv == null || this.cAv.wgZ == null)) {
                if (!C5046bo.isNullOrNil(this.cAv.wgZ.fiG)) {
                    AppMethodBeat.m2505o(74348);
                    return 15;
                } else if (!C5046bo.isNullOrNil(this.cAv.wgZ.fiK)) {
                    AppMethodBeat.m2505o(74348);
                    return 15;
                }
            }
            AppMethodBeat.m2505o(74348);
            return 4;
        } else {
            int i = this.cAv.dataType;
            AppMethodBeat.m2505o(74348);
            return i;
        }
    }

    /* renamed from: hl */
    private void m61023hl(boolean z) {
        AppMethodBeat.m2504i(74349);
        boolean f = C39037b.m66393f(this.cAv);
        C4990ab.m7417i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", Integer.valueOf(this.mgf.field_itemStatus), Boolean.valueOf(f), C39037b.m66370b(this.cAv));
        if (this.cAv.whh != 0) {
            bwh();
            AppMethodBeat.m2505o(74349);
        } else if (this.mgf.isDone() || f || !C5046bo.isNullOrNil(this.cAv.wfZ)) {
            if (f) {
                bwl();
                if (getIntent().getBooleanExtra("key_detail_open_way", false)) {
                    abh abh = new abh();
                    abh.cOi = 2;
                    ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(this.mController.ylL, this.mgf, abh);
                    AppMethodBeat.m2505o(74349);
                    return;
                }
            } else if (C5046bo.isNullOrNil(this.cAv.wfZ)) {
                bwh();
                AppMethodBeat.m2505o(74349);
                return;
            } else {
                C4990ab.m7420w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
                bwj();
            }
            AppMethodBeat.m2505o(74349);
        } else {
            if (this.mgf.buy()) {
                if (C5046bo.isNullOrNil(this.cAv.wfZ)) {
                    bwh();
                    if (z) {
                        int type = getType();
                        if (4 == type || 15 == type) {
                            type = C25738R.string.bqx;
                        } else {
                            type = C25738R.string.bqk;
                        }
                        C30379h.m48465bQ(this.mController.ylL, getString(type));
                        AppMethodBeat.m2505o(74349);
                        return;
                    }
                }
                bwj();
                if (z) {
                    C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.b6p));
                    AppMethodBeat.m2505o(74349);
                    return;
                }
            } else if (this.mgf.bux()) {
                bwj();
                if (z) {
                    C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.bnk));
                    AppMethodBeat.m2505o(74349);
                    return;
                }
            } else if (this.mgf.isDownloading() || this.mgf.buw()) {
                bwi();
                AppMethodBeat.m2505o(74349);
                return;
            } else {
                C4990ab.m7420w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                bwj();
            }
            AppMethodBeat.m2505o(74349);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(74350);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(C25738R.string.f9082oy));
        AppMethodBeat.m2505o(74350);
    }

    private void bwh() {
        AppMethodBeat.m2504i(74351);
        this.mlG.setVisibility(8);
        this.gxi.setVisibility(8);
        this.mlF.setVisibility(8);
        this.mlD.setVisibility(8);
        this.mlE.setVisibility(8);
        this.mlI.setVisibility(8);
        this.iqU.setVisibility(8);
        this.mlL.setVisibility(0);
        this.mlM.setVisibility(0);
        if (this.cAv.dataType == 4) {
            this.iqU.setGravity(17);
            this.iqU.setText(C25738R.string.bq0);
            AppMethodBeat.m2505o(74351);
            return;
        }
        this.iqU.setGravity(17);
        this.iqU.setText(C25738R.string.bpz);
        if (this.cAv.whh == 2) {
            this.mlM.setText(C25738R.string.bnu);
            AppMethodBeat.m2505o(74351);
            return;
        }
        this.mlM.setText(C25738R.string.bnv);
        AppMethodBeat.m2505o(74351);
    }

    private void bwi() {
        int progress;
        int i;
        int i2;
        AppMethodBeat.m2504i(74352);
        this.mlF.setVisibility(8);
        this.mlD.setVisibility(8);
        this.mlE.setVisibility(8);
        this.iqU.setVisibility(8);
        this.mlI.setVisibility(0);
        C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(this.cAv.mnd);
        if (LR != null) {
            progress = (int) LR.getProgress();
            i = LR.field_offset;
            i2 = LR.field_totalLen;
        } else {
            i2 = (int) this.cAv.wgu;
            i = 0;
            progress = 0;
        }
        if (this.mgf.buw() && C5046bo.isNullOrNil(this.cAv.wfZ)) {
            m61016b((float) progress, getString(C25738R.string.bs7, new Object[]{C39037b.m66368aC((float) i), C39037b.m66368aC((float) i2)}));
            AppMethodBeat.m2505o(74352);
            return;
        }
        m61016b((float) progress, getString(C25738R.string.bo5, new Object[]{C39037b.m66368aC((float) i), C39037b.m66368aC((float) i2)}));
        AppMethodBeat.m2505o(74352);
    }

    private void bwj() {
        AppMethodBeat.m2504i(74353);
        this.mlI.setVisibility(8);
        this.mlE.setVisibility(8);
        if (C5046bo.isNullOrNil(this.cAv.wgg)) {
            this.mlD.setVisibility(8);
        } else {
            this.mlD.setVisibility(0);
        }
        this.mlF.setVisibility(0);
        C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(this.cAv.mnd);
        if (LR == null || LR.field_offset <= 0) {
            this.mlF.setText(this.mgf.bux() ? C25738R.string.bpi : C25738R.string.bpd);
        } else {
            this.mlF.setText(this.mgf.bux() ? C25738R.string.bph : C25738R.string.bpg);
        }
        this.iqU.setVisibility(8);
        AppMethodBeat.m2505o(74353);
    }

    private boolean bwk() {
        AppMethodBeat.m2504i(74354);
        if (C39037b.m66393f(this.cAv) && C39037b.m66396g(this.cAv)) {
            AppMethodBeat.m2505o(74354);
            return true;
        }
        AppMethodBeat.m2505o(74354);
        return false;
    }

    private void bwl() {
        AppMethodBeat.m2504i(74355);
        if (!(getType() != 15 || this.cAv.wgZ == null || C5046bo.isNullOrNil(this.cAv.wgZ.fiG) || C5046bo.isNullOrNil(this.cAv.wgZ.fiK))) {
            this.mlS = true;
            this.mlG.setVisibility(8);
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            this.mlD.setVisibility(8);
            this.mlE.setVisibility(8);
            this.iqU.setVisibility(8);
            String b = C39037b.m66370b(this.cAv);
            C4990ab.m7410d("MicroMsg.FavoriteFileDetailUI", C1447g.m3074Mp() + " initView: fullpath:" + b);
            ViewGroup viewGroup = (ViewGroup) findViewById(2131823992);
            this.klq = C46510q.m87801fT(this.mController.ylL);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.klq, 0, layoutParams);
            this.klq.setVideoCallback(new C367684());
            C4990ab.m7410d("MicroMsg.FavoriteFileDetailUI", C1447g.m3074Mp() + " initView :" + b);
            if (b != null) {
                this.klq.stop();
                this.klq.setVideoPath(b);
            }
            C4990ab.m7410d("MicroMsg.FavoriteFileDetailUI", C1447g.m3074Mp() + " initView");
            C37494a.aic();
            C7060h.pYm.mo8381e(11444, Integer.valueOf(4));
        }
        if (getType() == 15 || getType() == 4) {
            if (!this.mlS) {
                this.mlI.setVisibility(8);
                this.mlF.setVisibility(8);
                this.mlD.setVisibility(8);
                this.mlE.setVisibility(0);
                this.mlE.setText(C25738R.string.bpf);
                this.iqU.setVisibility(8);
                bnS();
            }
        } else if (bwk()) {
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            this.mlD.setVisibility(0);
            this.mlE.setVisibility(8);
            this.iqU.setVisibility(8);
            this.mlD.setOnClickListener(new C367735());
        } else {
            this.mlI.setVisibility(8);
            this.mlF.setVisibility(8);
            if (C5046bo.isNullOrNil(this.cAv.wgg)) {
                this.mlD.setVisibility(8);
            } else {
                this.mlD.setVisibility(0);
            }
            this.mlE.setVisibility(0);
            this.mlz.meX = true;
            this.iqU.setVisibility(0);
        }
        C1720g.m3539RS().mo10302aa(new C367706());
        AppMethodBeat.m2505o(74355);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74356);
        setResult(0, getIntent().putExtra("key_activity_browse_time", dyi()));
        if (this.klq != null) {
            this.klq.setVideoCallback(null);
            this.klq.stop();
            this.klq.onDetach();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(74356);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74357);
        super.onResume();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10116c(this);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15157a(this);
        if (this.klq != null) {
            this.klq.start();
        }
        AppMethodBeat.m2505o(74357);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74358);
        super.onPause();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo10117d(this);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15159b(this);
        if (this.klq != null) {
            this.klq.stop();
        }
        AppMethodBeat.m2505o(74358);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74359);
        super.onActivityResult(i, i2, intent);
        ((C6892ab) C1720g.m3528K(C6892ab.class)).mo15150b(this, i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(74359);
            return;
        }
        if (i == 1) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C4990ab.m7411d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", Integer.valueOf(getType()));
            Runnable c207207 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74329);
                    b.dismiss();
                    AppMethodBeat.m2505o(74329);
                }
            };
            int type = getType();
            if (C5046bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.m2505o(74359);
                return;
            }
            for (String str2 : C5046bo.m7508P(stringExtra.split(","))) {
                if (type == 4 || type == 15) {
                    int mA;
                    C11909i.m19790a(this.mController.ylL, str2, this.cAv, c207207);
                    boolean kH = C1855t.m3896kH(str2);
                    C27972c c27972c = kH ? C27972c.Chatroom : C27972c.Chat;
                    C27966g c27966g = this.mgf;
                    C20677d c20677d = C20677d.Full;
                    if (kH) {
                        mA = C37921n.m64060mA(str2);
                    } else {
                        mA = 0;
                    }
                    C39038m.m66422a(c27972c, c27966g, c20677d, mA);
                } else {
                    C11909i.m19788a(this.mController.ylL, str2, this.mgf, this.cAv, c207207);
                }
                if (!C5046bo.isNullOrNil(str)) {
                    C12519g.bOk().mo46456F(str2, str, C1855t.m3925nK(str2));
                }
            }
            C5670b.m8523i(this, getString(C25738R.string.bnf));
        }
        AppMethodBeat.m2505o(74359);
    }

    /* renamed from: d */
    public final void mo23673d(C45925c c45925c) {
        AppMethodBeat.m2504i(74360);
        if (c45925c == null || c45925c.field_dataId == null) {
            C4990ab.m7420w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
            AppMethodBeat.m2505o(74360);
            return;
        }
        C4990ab.m7411d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", this.cAv.mnd, c45925c.field_dataId);
        if (!c45925c.field_dataId.equals(this.cAv.mnd)) {
            AppMethodBeat.m2505o(74360);
        } else if (this.mgf.buw() && C5046bo.isNullOrNil(this.cAv.wfZ)) {
            m61016b(c45925c.getProgress(), getString(C25738R.string.bs7, new Object[]{C39037b.m66368aC((float) c45925c.field_offset), C39037b.m66368aC((float) c45925c.field_totalLen)}));
            AppMethodBeat.m2505o(74360);
        } else {
            m61016b(c45925c.getProgress(), getString(C25738R.string.bo5, new Object[]{C39037b.m66368aC((float) c45925c.field_offset), C39037b.m66368aC((float) c45925c.field_totalLen)}));
            if (this.mlO && C5730e.m8628ct(c45925c.field_path)) {
                this.mgf.field_itemStatus = 10;
                mo5248a("", null);
            }
            AppMethodBeat.m2505o(74360);
        }
    }

    /* renamed from: b */
    private void m61016b(final float f, final String str) {
        AppMethodBeat.m2504i(74361);
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74330);
                FavoriteFileDetailUI.this.progressBar.setProgress((int) f);
                FavoriteFileDetailUI.this.mlH.setText(str);
                AppMethodBeat.m2505o(74330);
            }
        });
        AppMethodBeat.m2505o(74361);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(74362);
        C4990ab.m7417i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", str, Long.valueOf(this.mgf.field_localId));
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.mgf.field_localId);
        if (iE != null || this.mlO) {
            if (!this.mlO) {
                this.mgf = iE;
            }
            bwg();
            if (bwm()) {
                AppMethodBeat.m2505o(74362);
                return;
            }
            this.fbD.post(new C207229());
            AppMethodBeat.m2505o(74362);
            return;
        }
        C4990ab.m7420w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
        finish();
        AppMethodBeat.m2505o(74362);
    }

    private void bnS() {
        AppMethodBeat.m2504i(74363);
        if (this.mlR) {
            AppMethodBeat.m2505o(74363);
            return;
        }
        C27969a c27969a = this.mlz;
        c27969a.meY++;
        this.mlR = true;
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", this.cvv);
        intent.putExtra("key_detail_fav_path", C39037b.m66370b(this.cAv));
        intent.putExtra("key_detail_fav_thumb_path", C39037b.m66379c(this.cAv));
        intent.putExtra("key_detail_fav_video_duration", this.cAv.duration);
        intent.putExtra("key_detail_statExtStr", this.cAv.cMn);
        C39037b.m66371b((Context) this, ".ui.detail.FavoriteVideoPlayUI", intent);
        finish();
        AppMethodBeat.m2505o(74363);
    }

    private boolean bwm() {
        AppMethodBeat.m2504i(74364);
        C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(this.cAv.mnd);
        if (LR == null) {
            AppMethodBeat.m2505o(74364);
            return false;
        } else if (LR.field_status == 1) {
            AppMethodBeat.m2505o(74364);
            return true;
        } else if (this.cAv.dataType == 8) {
            AppMethodBeat.m2505o(74364);
            return false;
        } else if (this.mlT) {
            AppMethodBeat.m2505o(74364);
            return false;
        } else {
            if (LR.field_status == 4 && ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(this.cAv.mnd).field_extFlag != 0) {
                C39037b.m66360a(this.mgf, this.cAv, true);
                this.mlT = true;
            }
            C4990ab.m7417i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", Boolean.valueOf(this.mlT));
            boolean z = this.mlT;
            AppMethodBeat.m2505o(74364);
            return z;
        }
    }

    /* renamed from: k */
    static /* synthetic */ void m61026k(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.m2504i(74371);
        String uu = C26494u.m42269uu(C39037b.m66370b(favoriteFileDetailUI.cAv));
        C4990ab.m7417i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", Integer.valueOf(favoriteFileDetailUI.hashCode()), r0, uu);
        if (C5046bo.isNullOrNil(uu)) {
            Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(C25738R.string.f1c), 1).show();
            AppMethodBeat.m2505o(74371);
            return;
        }
        Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(C25738R.string.f1d, new Object[]{uu}), 1).show();
        C14987n.m23300a(uu, favoriteFileDetailUI);
        AppMethodBeat.m2505o(74371);
    }

    /* renamed from: s */
    static /* synthetic */ void m61034s(FavoriteFileDetailUI favoriteFileDetailUI) {
        AppMethodBeat.m2504i(74372);
        if (favoriteFileDetailUI.getType() == 8 && C39037b.m66393f(favoriteFileDetailUI.cAv) && C39037b.m66396g(favoriteFileDetailUI.cAv)) {
            C27969a c27969a = favoriteFileDetailUI.mlz;
            c27969a.meY++;
            C20679y c20679y = (C20679y) C1720g.m3528K(C20679y.class);
            AppCompatActivity appCompatActivity = favoriteFileDetailUI.mController.ylL;
            C27966g c27966g = favoriteFileDetailUI.mgf;
            abh abh = new abh();
            abh.scene = favoriteFileDetailUI.mlz.scene;
            abh.jSW = favoriteFileDetailUI.mlz.jSW;
            abh.index = favoriteFileDetailUI.mlz.index;
            c20679y.mo35978a(appCompatActivity, c27966g, abh);
        }
        AppMethodBeat.m2505o(74372);
    }
}
