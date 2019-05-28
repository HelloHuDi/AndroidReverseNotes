package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.plugin.qqmail.p1618a.C43401a;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C21523a;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C28746c;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44094a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.FileExplorerUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage */
public class AttachDownloadPage extends MMActivity {
    private int fUO = 0;
    private long fVz = 0;
    private TextView gnh;
    private TextView iGX;
    private long jrb;
    private Button mlD;
    private Button mlF;
    private View mlI;
    private ProgressBar progressBar;
    private String ptI;
    private String pux;
    private long pvG;
    private MMImageView pvR;
    private ImageView pvS;
    private ImageView pvT;
    private TextView pvU;
    private LinearLayout pvV;
    private String pvW;
    private int pvX;
    private boolean pvY = false;
    private String pvZ;
    private boolean pwa = true;
    private int retryCount = 0;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$7 */
    class C36487 implements OnClickListener {
        C36487() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68137);
            AttachDownloadPage.this.retryCount = 0;
            AttachDownloadPage.m32993f(AttachDownloadPage.this);
            AttachDownloadPage.m32995h(AttachDownloadPage.this);
            AppMethodBeat.m2505o(68137);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$8 */
    class C36498 implements OnClickListener {
        C36498() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68138);
            if (AttachDownloadPage.this.fUO == 3) {
                AttachDownloadPage.m32989b(AttachDownloadPage.this, AttachDownloadPage.m32986a(AttachDownloadPage.this));
                AppMethodBeat.m2505o(68138);
                return;
            }
            AttachDownloadPage.m32995h(AttachDownloadPage.this);
            AttachDownloadPage.this.retryCount = 0;
            AttachDownloadPage.m32993f(AttachDownloadPage.this);
            AppMethodBeat.m2505o(68138);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$1 */
    class C215261 implements OnMenuItemClickListener {
        C215261() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68130);
            AttachDownloadPage.this.finish();
            AppMethodBeat.m2505o(68130);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$2 */
    class C215272 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$2$1 */
        class C215281 implements C30391c {
            C215281() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(68131);
                switch (i) {
                    case 0:
                        AttachDownloadPage.m32987a(AttachDownloadPage.this, AttachDownloadPage.m32986a(AttachDownloadPage.this));
                        break;
                }
                AppMethodBeat.m2505o(68131);
            }
        }

        C215272() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68132);
            C30379h.m48424a(AttachDownloadPage.this, "", new String[]{AttachDownloadPage.this.getString(C25738R.string.dcq)}, "", false, new C215281());
            AppMethodBeat.m2505o(68132);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$4 */
    class C215294 implements OnClickListener {
        C215294() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68134);
            AttachDownloadPage.this.retryCount = 0;
            AttachDownloadPage.m32993f(AttachDownloadPage.this);
            AppMethodBeat.m2505o(68134);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$5 */
    class C215305 implements OnClickListener {
        C215305() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68135);
            AttachDownloadPage.m32994g(AttachDownloadPage.this);
            AppMethodBeat.m2505o(68135);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$6 */
    class C215316 implements OnClickListener {
        C215316() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68136);
            AttachDownloadPage.m32989b(AttachDownloadPage.this, AttachDownloadPage.m32986a(AttachDownloadPage.this));
            AppMethodBeat.m2505o(68136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$9 */
    class C215329 extends C21523a {
        C215329() {
        }

        public final void onProgress(int i) {
            AppMethodBeat.m2504i(68139);
            C4990ab.m7410d("MicroMsg.AttachDownloadPage", "download progress : ".concat(String.valueOf(i)));
            AttachDownloadPage.m32997j(AttachDownloadPage.this);
            AttachDownloadPage.this.fUO = 1;
            AppMethodBeat.m2505o(68139);
        }

        public final void onSuccess(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(68140);
            C5730e.m8633h(AttachDownloadPage.this.pvW, AttachDownloadPage.m33000l(AttachDownloadPage.this) + ".temp", AttachDownloadPage.m33000l(AttachDownloadPage.this));
            AttachDownloadPage.this.fUO = 3;
            Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(C25738R.string.b71) + " : " + AttachDownloadPage.m32986a(AttachDownloadPage.this), 5000).show();
            AttachDownloadPage.m32991d(AttachDownloadPage.this);
            AppMethodBeat.m2505o(68140);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(68141);
            AttachDownloadPage.this.fUO = 4;
            if (AttachDownloadPage.this.retryCount < 5) {
                AttachDownloadPage.this.retryCount = AttachDownloadPage.this.retryCount + 1;
                AttachDownloadPage.m32993f(AttachDownloadPage.this);
                AppMethodBeat.m2505o(68141);
                return;
            }
            AttachDownloadPage.m32991d(AttachDownloadPage.this);
            AppMethodBeat.m2505o(68141);
        }

        public final void onComplete() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage$3 */
    class C215333 implements OnClickListener {
        C215333() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68133);
            AttachDownloadPage.this.fUO = 2;
            C12884ac.ccC().cancel(AttachDownloadPage.this.pvG);
            AttachDownloadPage.this.pvG = 0;
            AttachDownloadPage.m32991d(AttachDownloadPage.this);
            AppMethodBeat.m2505o(68133);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ String m32986a(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.m2504i(68158);
        String jV = attachDownloadPage.m32998jV(false);
        AppMethodBeat.m2505o(68158);
        return jV;
    }

    /* renamed from: d */
    static /* synthetic */ void m32991d(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.m2504i(68160);
        attachDownloadPage.ccK();
        AppMethodBeat.m2505o(68160);
    }

    /* renamed from: f */
    static /* synthetic */ void m32993f(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.m2504i(68161);
        attachDownloadPage.ccM();
        AppMethodBeat.m2505o(68161);
    }

    /* renamed from: h */
    static /* synthetic */ void m32995h(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.m2504i(68164);
        attachDownloadPage.ccJ();
        AppMethodBeat.m2505o(68164);
    }

    /* renamed from: l */
    static /* synthetic */ String m33000l(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.m2504i(68166);
        String ccN = attachDownloadPage.ccN();
        AppMethodBeat.m2505o(68166);
        return ccN;
    }

    public final int getLayoutId() {
        return 2130968783;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68142);
        super.onCreate(bundle);
        this.pvX = getIntent().getIntExtra("is_preview", 0);
        this.pvY = getIntent().getBooleanExtra("is_compress", false);
        this.pvZ = getIntent().getStringExtra("attach_name");
        this.ptI = getIntent().getStringExtra("mail_id");
        this.pux = getIntent().getStringExtra("attach_id");
        this.jrb = getIntent().getLongExtra("total_size", 0);
        C12884ac.ccC();
        this.pvW = C39540v.getDownloadPath();
        setMMTitle(this.pvZ);
        initView();
        AppMethodBeat.m2505o(68142);
    }

    public void onResume() {
        AppMethodBeat.m2504i(68143);
        super.onResume();
        AppMethodBeat.m2505o(68143);
    }

    public void onPause() {
        AppMethodBeat.m2504i(68144);
        super.onPause();
        AppMethodBeat.m2505o(68144);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(68145);
        super.onDestroy();
        C12884ac.ccC().cancel(this.pvG);
        AppMethodBeat.m2505o(68145);
    }

    public final void initView() {
        AppMethodBeat.m2504i(68146);
        this.pvR = (MMImageView) findViewById(2131821523);
        this.mlI = findViewById(2131821524);
        this.progressBar = (ProgressBar) findViewById(2131821525);
        this.pvS = (ImageView) findViewById(2131821526);
        this.pvT = (ImageView) findViewById(2131821527);
        this.pvU = (TextView) findViewById(2131821528);
        this.mlD = (Button) findViewById(2131821529);
        this.mlF = (Button) findViewById(2131821530);
        this.pvV = (LinearLayout) findViewById(2131821531);
        this.gnh = (TextView) findViewById(2131821532);
        this.iGX = (TextView) findViewById(2131821533);
        ccI();
        setBackBtn(new C215261());
        addIconOptionMenu(0, C1318a.ofm_send_icon, new C215272());
        enableOptionMenu(false);
        ccP();
        if (this.fUO == 1) {
            ccJ();
            AppMethodBeat.m2505o(68146);
            return;
        }
        ccK();
        AppMethodBeat.m2505o(68146);
    }

    private void ccI() {
        AppMethodBeat.m2504i(68147);
        if (FileExplorerUI.ajX(this.pvZ)) {
            this.pvR.setBackgroundResource(C1318a.download_image_icon);
            AppMethodBeat.m2505o(68147);
        } else if (FileExplorerUI.ajY(this.pvZ)) {
            this.pvR.setImageResource(C1318a.app_attach_file_icon_video);
            AppMethodBeat.m2505o(68147);
        } else {
            int aiD = C44065o.aiD(C5730e.m8630cv(this.pvZ));
            if (aiD > 0) {
                this.pvR.setImageResource(aiD);
                AppMethodBeat.m2505o(68147);
                return;
            }
            this.pvR.setImageResource(C1318a.app_attach_file_icon_unknow);
            AppMethodBeat.m2505o(68147);
        }
    }

    private void ccJ() {
        AppMethodBeat.m2504i(68148);
        this.mlI.setVisibility(0);
        this.mlD.setVisibility(8);
        this.mlF.setVisibility(8);
        this.pvS.setVisibility(0);
        this.pvT.setVisibility(8);
        this.pvU.setVisibility(8);
        this.gnh.setVisibility(8);
        this.iGX.setVisibility(8);
        this.pvS.setOnClickListener(new C215333());
        this.pvT.setOnClickListener(new C215294());
        AppMethodBeat.m2505o(68148);
    }

    private void ccK() {
        AppMethodBeat.m2504i(68149);
        if (this.pvX == 1) {
            if (FileExplorerUI.ajX(this.pvZ)) {
                if (this.fUO == 3) {
                    ccL();
                    AppMethodBeat.m2505o(68149);
                    return;
                } else if (this.fUO == 0 || this.pwa) {
                    this.retryCount = 0;
                    this.pwa = false;
                    ccM();
                    ccJ();
                    AppMethodBeat.m2505o(68149);
                    return;
                }
            }
            this.mlI.setVisibility(8);
            this.gnh.setVisibility(0);
            this.pvU.setVisibility(8);
            this.mlD.setVisibility(0);
            this.mlF.setVisibility(8);
            this.iGX.setVisibility(0);
            this.mlD.setOnClickListener(new C215305());
            if (this.fUO == 3) {
                this.gnh.setText(C25738R.string.cv3);
                this.iGX.setText(C25738R.string.cv0);
                this.iGX.setOnClickListener(new C215316());
                enableOptionMenu(true);
                AppMethodBeat.m2505o(68149);
                return;
            }
            this.gnh.setText(C25738R.string.cv3);
            if (this.fUO == 2) {
                this.iGX.setText(C25738R.string.cv2);
            } else {
                this.iGX.setText(C25738R.string.cv1);
            }
            this.iGX.setOnClickListener(new C36487());
            AppMethodBeat.m2505o(68149);
            return;
        }
        if (this.pvX == 0) {
            this.mlI.setVisibility(8);
            this.mlD.setVisibility(8);
            this.mlF.setVisibility(0);
            this.pvU.setVisibility(8);
            this.gnh.setVisibility(0);
            this.iGX.setVisibility(8);
            if (this.fUO == 3) {
                this.mlF.setText(C25738R.string.cux);
                enableOptionMenu(true);
            } else if (this.fUO == 2) {
                this.mlF.setText(C25738R.string.cv4);
            } else {
                this.mlF.setText(C25738R.string.cuv);
            }
            this.gnh.setText(C25738R.string.cuw);
            this.mlF.setOnClickListener(new C36498());
        }
        AppMethodBeat.m2505o(68149);
    }

    private void ccL() {
        AppMethodBeat.m2504i(68150);
        Intent intent = new Intent();
        intent.putExtra("key_favorite", true);
        intent.putExtra("key_favorite_source_type", 9);
        intent.putExtra("key_image_path", m32998jV(false));
        C43401a.gkE.mo38914d(this.mController.ylL, intent);
        finish();
        AppMethodBeat.m2505o(68150);
    }

    private void ccM() {
        AppMethodBeat.m2504i(68151);
        ccP();
        if (this.fUO == 4) {
            if (this.retryCount < 5) {
                this.retryCount++;
                ccM();
            } else {
                ccK();
            }
        } else if (this.fUO == 3) {
            C5730e.m8633h(this.pvW, ccN() + ".temp", ccN());
            this.fUO = 3;
            ccK();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mailid", this.ptI);
        hashMap.put("attachid", this.pux);
        hashMap.put("username", "");
        hashMap.put("offset", this.fVz);
        hashMap.put("datalen", this.jrb);
        hashMap.put("default_attach_name", ccN() + ".temp");
        C28746c c28746c = new C28746c();
        c28746c.puP = false;
        c28746c.puQ = false;
        this.pvG = C12884ac.ccC().mo62492a("/cgi-bin/mmdownload", hashMap, c28746c, new C215329());
        AppMethodBeat.m2505o(68151);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(68152);
        super.onActivityResult(i, i2, intent);
        C44094a.m79367a(this, i, i2, intent, true, C25738R.string.b6t, C25738R.string.b6u, 3);
        AppMethodBeat.m2505o(68152);
    }

    private String ccN() {
        String substring;
        AppMethodBeat.m2504i(68153);
        int hashCode = this.pux.hashCode() & CdnLogic.kBizGeneric;
        int lastIndexOf = this.pvZ.lastIndexOf(".");
        String str = "";
        if (lastIndexOf != -1) {
            substring = this.pvZ.substring(0, lastIndexOf);
            str = this.pvZ;
            str = str.substring(lastIndexOf, str.length());
        } else {
            substring = this.pvZ;
        }
        substring = String.format("%s_%d%s", new Object[]{substring, Integer.valueOf(hashCode), str});
        AppMethodBeat.m2505o(68153);
        return substring;
    }

    /* renamed from: jV */
    private String m32998jV(boolean z) {
        AppMethodBeat.m2504i(68154);
        String str = this.pvW + ccN() + (!z ? "" : ".temp");
        AppMethodBeat.m2505o(68154);
        return str;
    }

    private String ccO() {
        AppMethodBeat.m2504i(68155);
        String str = this.pvW + this.pvZ;
        AppMethodBeat.m2505o(68155);
        return str;
    }

    private void ccP() {
        AppMethodBeat.m2504i(68156);
        if (C5730e.m8628ct(m32998jV(true))) {
            this.fVz = C5730e.asZ(m32998jV(true));
            this.fUO = 2;
            AppMethodBeat.m2505o(68156);
        } else if (C5730e.m8628ct(m32998jV(false))) {
            this.fUO = 3;
            AppMethodBeat.m2505o(68156);
        } else if (!C5730e.m8628ct(ccO())) {
            this.fVz = 0;
            this.fUO = 0;
            AppMethodBeat.m2505o(68156);
        } else if (C5730e.asZ(ccO()) == this.jrb) {
            C5730e.m8633h(this.pvW, this.pvZ, ccN());
            this.fUO = 3;
            AppMethodBeat.m2505o(68156);
        } else if (C5730e.asZ(ccO()) > this.jrb) {
            C5730e.deleteFile(ccO());
            this.fVz = 0;
            this.fUO = 4;
            AppMethodBeat.m2505o(68156);
        } else {
            this.fVz = 0;
            this.fUO = 0;
            AppMethodBeat.m2505o(68156);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(68157);
        super.onConfigurationChanged(configuration);
        int i = getResources().getConfiguration().orientation;
        LayoutParams layoutParams = (LayoutParams) this.pvV.getLayoutParams();
        if (i == 2) {
            layoutParams.bottomMargin = C5229aj.fromDPToPix(this.mController.ylL, 60);
        } else if (i == 1) {
            layoutParams.bottomMargin = C5229aj.fromDPToPix(this.mController.ylL, 120);
        }
        this.pvV.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(68157);
    }

    /* renamed from: g */
    static /* synthetic */ void m32994g(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.m2504i(68162);
        if (attachDownloadPage.pvY) {
            Intent intent = new Intent(attachDownloadPage.mController.ylL, CompressPreviewUI.class);
            intent.putExtra("mail_id", attachDownloadPage.ptI);
            intent.putExtra("attach_id", attachDownloadPage.pux);
            intent.putExtra("attach_size", attachDownloadPage.jrb);
            intent.putExtra("attach_name", attachDownloadPage.pvZ);
            attachDownloadPage.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(68162);
            return;
        }
        String[] strArr = new String[]{"mailid=" + attachDownloadPage.ptI, "attachid=" + attachDownloadPage.pux, "texttype=html"};
        Intent intent2 = new Intent();
        intent2.putExtra(ShareConstants.MEDIA_URI, "/cgi-bin/viewdocument");
        intent2.putExtra("params", strArr);
        intent2.putExtra("baseurl", C39540v.ccw());
        intent2.putExtra(C8741b.METHOD, "get");
        intent2.putExtra("singleColumn", FileExplorerUI.ajX(attachDownloadPage.pvZ));
        intent2.putExtra("title", attachDownloadPage.pvZ);
        intent2.setClass(attachDownloadPage, MailWebViewUI.class);
        attachDownloadPage.startActivity(intent2);
        AppMethodBeat.m2505o(68162);
    }

    /* renamed from: b */
    static /* synthetic */ void m32989b(AttachDownloadPage attachDownloadPage, String str) {
        AppMethodBeat.m2504i(68163);
        String cv = C5730e.m8630cv(str);
        if (!(cv == null || cv.length() == 0)) {
            C44094a.m79368a(attachDownloadPage, str, cv, 3);
        }
        AppMethodBeat.m2505o(68163);
    }

    /* renamed from: j */
    static /* synthetic */ void m32997j(AttachDownloadPage attachDownloadPage) {
        AppMethodBeat.m2504i(68165);
        long asZ = C5730e.asZ(attachDownloadPage.m32998jV(true));
        C4990ab.m7410d("MicroMsg.AttachDownloadPage", "cur download size:".concat(String.valueOf(asZ)));
        attachDownloadPage.fVz = asZ;
        attachDownloadPage.progressBar.setProgress((int) ((100 * asZ) / attachDownloadPage.jrb));
        attachDownloadPage.pvU.setText(attachDownloadPage.getString(C25738R.string.cuy, new Object[]{C5046bo.m7565ga(asZ), C5046bo.m7565ga(attachDownloadPage.jrb)}));
        if (attachDownloadPage.fUO != 1 || attachDownloadPage.pvG == 0) {
            attachDownloadPage.pvU.setVisibility(8);
            AppMethodBeat.m2505o(68165);
            return;
        }
        attachDownloadPage.pvU.setVisibility(0);
        AppMethodBeat.m2505o(68165);
    }
}
