package com.tencent.p177mm.plugin.emoji.p384ui.fts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C26107cx;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.model.C20378d.C11556a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiSendDialogUI;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiStoreDetailUI;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2DesignerUI;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p947e.C20362f;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI */
public class FTSEmojiDetailPageUI extends MMActivity implements C1202f {
    private String cAo;
    private String cHg;
    private int cvp;
    private String cwg;
    private String designerName;
    private EmojiInfo exP;
    private int fjE;
    private C46696j icA;
    private ProgressBar juA;
    private String kVF;
    private C11556a kVx = new C1157810();
    private String lcA;
    private String lcB;
    private String lcC;
    private String lcD;
    private String lcE;
    private String lcF;
    private String lcG;
    private C4884c lcH = new C115849();
    private C1282i lcI = new C1157411();
    private C5279d lcJ = new C115803();
    private MMAnimateView lcs;
    private Button lct;
    private Button lcu;
    private TextView lcv;
    private ImageView lcw;
    private View lcx;
    private boolean lcy;
    private boolean lcz;
    private int scene;
    private int type;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$11 */
    class C1157411 implements C1282i {

        /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$11$1 */
        class C115751 implements Runnable {
            C115751() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53548);
                FTSEmojiDetailPageUI.m19397e(FTSEmojiDetailPageUI.this);
                AppMethodBeat.m2505o(53548);
            }
        }

        C1157411() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(53549);
            C4990ab.m7417i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", str);
            if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(FTSEmojiDetailPageUI.this.exP.field_encrypturl)) {
                C5728b c5728b = new C5728b(objArr[0].toString());
                if (c5728b.exists()) {
                    FTSEmojiDetailPageUI.this.exP.field_md5 = C5730e.atg(C5736j.m8649w(c5728b.mUri));
                    FTSEmojiDetailPageUI.this.cHg = EmojiLogic.m44073L(C2933b.m5221Yb(), "", FTSEmojiDetailPageUI.this.exP.field_md5);
                    C5730e.m8644y(C5736j.m8649w(c5728b.dMD()), FTSEmojiDetailPageUI.this.cHg);
                    C5004al.m7441d(new C115751());
                }
            }
            AppMethodBeat.m2505o(53549);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$2 */
    class C115762 implements OnCancelListener {
        C115762() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53536);
            FTSEmojiDetailPageUI.this.icA = null;
            AppMethodBeat.m2505o(53536);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$4 */
    class C115774 implements Runnable {
        C115774() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53538);
            EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(FTSEmojiDetailPageUI.this.exP.mo20410Aq());
            if (aqi != null) {
                FTSEmojiDetailPageUI.this.exP = aqi;
            }
            if (C20362f.bjK().mo35594m(FTSEmojiDetailPageUI.this.exP)) {
                String str = FTSEmojiDetailPageUI.this.exP.dve() + "_decode";
                if (C5730e.m8628ct(str)) {
                    C5730e.deleteFile(str);
                }
                C5730e.atc(str);
                byte[] l = C20362f.bjK().mo35593l(FTSEmojiDetailPageUI.this.exP);
                C5730e.m8624b(str, l, l.length);
                C14987n.m23321j(str, FTSEmojiDetailPageUI.this);
                C5730e.deleteFile(str);
                AppMethodBeat.m2505o(53538);
                return;
            }
            if (C5730e.m8628ct(FTSEmojiDetailPageUI.this.cHg)) {
                C14987n.m23321j(FTSEmojiDetailPageUI.this.cHg, FTSEmojiDetailPageUI.this);
            }
            AppMethodBeat.m2505o(53538);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$10 */
    class C1157810 implements C11556a {

        /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$10$1 */
        class C115791 implements Runnable {
            C115791() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53546);
                FTSEmojiDetailPageUI.m19397e(FTSEmojiDetailPageUI.this);
                AppMethodBeat.m2505o(53546);
            }
        }

        C1157810() {
        }

        /* renamed from: a */
        public final void mo23264a(boolean z, EmojiInfo emojiInfo) {
            AppMethodBeat.m2504i(53547);
            if (emojiInfo == null || !z || FTSEmojiDetailPageUI.this.exP == null || !FTSEmojiDetailPageUI.this.exP.mo20410Aq().equals(emojiInfo.mo20410Aq())) {
                C4990ab.m7416i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
                AppMethodBeat.m2505o(53547);
                return;
            }
            C4990ab.m7417i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", FTSEmojiDetailPageUI.this.exP.mo20410Aq());
            C5004al.m7441d(new C115791());
            AppMethodBeat.m2505o(53547);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$3 */
    class C115803 implements C5279d {
        C115803() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(53537);
            switch (menuItem.getItemId()) {
                case 1:
                    FTSEmojiDetailPageUI.m19402i(FTSEmojiDetailPageUI.this);
                    break;
                case 2:
                    FTSEmojiDetailPageUI.m19401h(FTSEmojiDetailPageUI.this);
                    AppMethodBeat.m2505o(53537);
                    return;
            }
            AppMethodBeat.m2505o(53537);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$5 */
    class C115815 implements OnClickListener {
        C115815() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53539);
            FTSEmojiDetailPageUI.m19393a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.this.exP.mo20410Aq(), FTSEmojiDetailPageUI.this.exP.field_designerID, FTSEmojiDetailPageUI.this.exP.field_thumbUrl, FTSEmojiDetailPageUI.this.exP.field_activityid);
            AppMethodBeat.m2505o(53539);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$6 */
    class C115826 implements OnClickListener {
        C115826() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53540);
            FTSEmojiDetailPageUI.m19394b(FTSEmojiDetailPageUI.this);
            AppMethodBeat.m2505o(53540);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$8 */
    class C115838 implements OnMenuItemClickListener {
        C115838() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53542);
            FTSEmojiDetailPageUI.m19396d(FTSEmojiDetailPageUI.this);
            AppMethodBeat.m2505o(53542);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$9 */
    class C115849 extends C4884c<C26107cx> {

        /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$9$1 */
        class C29481 implements Runnable {
            C29481() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53543);
                FTSEmojiDetailPageUI.m19397e(FTSEmojiDetailPageUI.this);
                AppMethodBeat.m2505o(53543);
            }
        }

        C115849() {
            AppMethodBeat.m2504i(53544);
            this.xxI = C26107cx.class.getName().hashCode();
            AppMethodBeat.m2505o(53544);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53545);
            C26107cx c26107cx = (C26107cx) c4883b;
            if (FTSEmojiDetailPageUI.this.exP != null && c26107cx.cvY.cvZ.equals(FTSEmojiDetailPageUI.this.exP.mo20410Aq())) {
                C4990ab.m7417i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiDownloadListener callback %s", FTSEmojiDetailPageUI.this.exP.mo20410Aq());
                C5004al.m7441d(new C29481());
            }
            AppMethodBeat.m2505o(53545);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$1 */
    class C115861 implements OnMenuItemClickListener {
        C115861() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53535);
            FTSEmojiDetailPageUI.this.finish();
            AppMethodBeat.m2505o(53535);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI$7 */
    class C115877 implements OnClickListener {
        C115877() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53541);
            FTSEmojiDetailPageUI.m19395c(FTSEmojiDetailPageUI.this);
            AppMethodBeat.m2505o(53541);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FTSEmojiDetailPageUI() {
        AppMethodBeat.m2504i(53551);
        AppMethodBeat.m2505o(53551);
    }

    /* renamed from: e */
    static /* synthetic */ void m19397e(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.m2504i(53564);
        fTSEmojiDetailPageUI.m19400gs(false);
        AppMethodBeat.m2505o(53564);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53552);
        super.onCreate(bundle);
        this.lct = (Button) findViewById(2131824225);
        this.lcu = (Button) findViewById(2131824224);
        this.lcs = (MMAnimateView) findViewById(2131824223);
        this.juA = (ProgressBar) findViewById(2131821605);
        this.lcv = (TextView) findViewById(2131824226);
        this.lcw = (ImageView) findViewById(2131824227);
        this.lcx = findViewById(2131823622);
        setBackBtn(new C115861());
        this.lct.setOnClickListener(new C115815());
        this.lcu.setOnClickListener(new C115826());
        this.lcx.setOnClickListener(new C115877());
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C115838());
        this.type = getIntent().getIntExtra("extra_type", 0);
        this.scene = getIntent().getIntExtra("extra_scence", 0);
        this.exP = new EmojiInfo();
        this.exP.field_designerID = getIntent().getStringExtra("id");
        this.exP.field_name = getIntent().getStringExtra("extra_emoji_name");
        this.exP.field_aeskey = getIntent().getStringExtra("extra_aeskey");
        this.exP.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
        this.exP.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
        this.exP.field_md5 = getIntent().getStringExtra("extra_md5");
        this.exP.field_groupId = getIntent().getStringExtra("extra_product_id");
        this.cwg = this.exP.field_groupId;
        this.lcC = getIntent().getStringExtra("extra_product_name");
        this.lcB = getIntent().getStringExtra("productUrl");
        this.lcD = getIntent().getStringExtra("extra_article_url");
        this.lcE = getIntent().getStringExtra("extra_article_name");
        this.cAo = this.exP.field_designerID;
        this.designerName = getIntent().getStringExtra("name");
        this.lcF = getIntent().getStringExtra("headurl");
        this.lcG = getIntent().getStringExtra("weapp_user_name");
        this.fjE = getIntent().getIntExtra("weapp_version", 0);
        this.cvp = getIntent().getIntExtra("source_type", 0);
        this.lcA = getIntent().getStringExtra("searchID");
        this.kVF = getIntent().getStringExtra("docID");
        this.lcy = getIntent().getBooleanExtra("disableAddSticker", false);
        this.lcz = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
        String stringExtra = getIntent().getStringExtra("activityId");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.exP.field_activityid = stringExtra;
        }
        C4879a.xxA.mo10052c(this.lcH);
        C42952j.bkh().kVj = this.kVx;
        C14423an.m22637F(this.scene, this.lcA, this.kVF);
        m19400gs(true);
        C4990ab.m7417i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", this.cHg);
        C14423an.m22637F(this.scene, this.lcA, this.kVF);
        AppMethodBeat.m2505o(53552);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53553);
        super.onResume();
        m19400gs(false);
        AppMethodBeat.m2505o(53553);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53554);
        if (i == 1001 && i2 == -1) {
            C5670b.m8523i(this, this.mController.ylL.getString(C25738R.string.f9223ti));
        }
        AppMethodBeat.m2505o(53554);
    }

    /* renamed from: gs */
    private void m19400gs(boolean z) {
        AppMethodBeat.m2504i(53555);
        if (z) {
            setMMTitle(this.exP.getName());
        }
        switch (this.type) {
            case 2:
                C32291o.ahp().mo43765a(this.lcB, this.lcw);
                this.lcv.setText(this.lcC);
                this.cHg = this.exP.dve();
                break;
            case 3:
                C32291o.ahp().mo43765a(this.lcF, this.lcw);
                this.lcv.setText(this.designerName);
                this.cHg = this.exP.dve();
                break;
            case 4:
                this.lcw.setVisibility(8);
                if (!C5046bo.isNullOrNil(this.lcE)) {
                    this.lcv.setText(this.lcE);
                    break;
                } else {
                    this.lcv.setText(C25738R.string.e0g);
                    break;
                }
        }
        if (C5730e.m8628ct(this.cHg)) {
            this.juA.setVisibility(8);
            this.lcs.setVisibility(0);
            EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(this.exP.mo20410Aq());
            if (aqi == null || (aqi.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                C4990ab.m7416i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
                this.lcs.setImageFilePath(this.cHg);
            } else {
                C4990ab.m7416i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
                this.lcs.mo46177f(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(aqi), "");
            }
            blW();
            blV();
        } else if (z) {
            if (this.type == 4) {
                C5728b c5728b = new C5728b(getCacheDir(), C1178g.m2591x(this.exP.field_encrypturl.getBytes()));
                if (c5728b.exists()) {
                    this.exP.field_md5 = C5730e.atg(C5736j.m8649w(c5728b.mUri));
                    String L = EmojiLogic.m44073L(C2933b.m5221Yb(), "", this.exP.field_md5);
                    if (!C5730e.m8628ct(L)) {
                        C5730e.m8644y(C5736j.m8649w(c5728b.dMD()), L);
                    }
                    this.cHg = L;
                    m19400gs(false);
                } else {
                    C17927a c17927a = new C17927a();
                    c17927a.ePH = true;
                    c17927a.ePJ = C5736j.m8649w(c5728b.dMD());
                    c17927a.eQd = new Object[]{C5736j.m8649w(c5728b.dMD())};
                    C42952j.bjW().mo43768a(this.exP.field_encrypturl, null, c17927a.ahG(), this.lcI);
                }
            } else {
                this.lcs.setVisibility(8);
                this.juA.setVisibility(0);
                this.lct.setText(C25738R.string.ba8);
                this.lcu.setText(C25738R.string.dr8);
                this.lct.setEnabled(false);
                this.lcu.setEnabled(false);
                C42952j.bkh().mo35676s(this.exP);
            }
        }
        if (this.lcy) {
            this.lct.setVisibility(8);
        }
        AppMethodBeat.m2505o(53555);
    }

    private void blV() {
        AppMethodBeat.m2504i(53556);
        this.lcu.setEnabled(true);
        AppMethodBeat.m2505o(53556);
    }

    private void blW() {
        AppMethodBeat.m2504i(53557);
        EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(this.exP.mo20410Aq());
        if (aqi == null) {
            aqi = this.exP;
        }
        if (aqi.field_catalog == EmojiGroupInfo.yat) {
            this.lct.setEnabled(false);
            this.lct.setText(C25738R.string.f8817fv);
            AppMethodBeat.m2505o(53557);
            return;
        }
        this.lct.setText(C25738R.string.ba8);
        if (C5730e.m8628ct(this.cHg)) {
            this.lct.setEnabled(true);
            AppMethodBeat.m2505o(53557);
            return;
        }
        this.lct.setEnabled(false);
        AppMethodBeat.m2505o(53557);
    }

    private boolean blX() {
        AppMethodBeat.m2504i(53558);
        if (C5046bo.isNullOrNil(this.lcG) || this.cvp != 1) {
            AppMethodBeat.m2505o(53558);
            return false;
        }
        AppMethodBeat.m2505o(53558);
        return true;
    }

    public final int getLayoutId() {
        return 2130969620;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53559);
        C4879a.xxA.mo10053d(this.lcH);
        C42952j.bkh().kVj = null;
        super.onDestroy();
        AppMethodBeat.m2505o(53559);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
    }

    /* renamed from: a */
    static /* synthetic */ void m19393a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(53560);
        C14423an.m22650b(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.lcA, fTSEmojiDetailPageUI.kVF, 1, 0);
        EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(str);
        String L = EmojiLogic.m44073L(C2933b.m5221Yb(), "", str);
        if (aqi == null && C5730e.m8628ct(L)) {
            int i = C5063r.amo(L) ? EmojiInfo.zYS : EmojiInfo.zYR;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.yau;
            emojiInfo.field_type = i;
            emojiInfo.field_size = (int) C5730e.asZ(L);
            emojiInfo.field_temp = 1;
            emojiInfo.field_designerID = str2;
            emojiInfo.field_thumbUrl = str3;
            emojiInfo.field_activityid = str4;
            C42952j.getEmojiStorageMgr().xYn.mo48553E(emojiInfo);
            aqi = emojiInfo;
        }
        if (aqi != null) {
            boolean a = C42952j.bki().mo35621a(fTSEmojiDetailPageUI, aqi, 18, C1853r.m3846Yz());
            C4990ab.m7417i("MicroMsg.FTS.FTSEmojiDetailPageUI", "doAddAction %b", Boolean.valueOf(a));
        }
        AppMethodBeat.m2505o(53560);
    }

    /* renamed from: b */
    static /* synthetic */ void m19394b(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.m2504i(53561);
        C14423an.m22650b(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.lcA, fTSEmojiDetailPageUI.kVF, 2, 0);
        Intent intent = new Intent(fTSEmojiDetailPageUI, EmojiSendDialogUI.class);
        intent.putExtra("emoji_info", fTSEmojiDetailPageUI.exP);
        fTSEmojiDetailPageUI.startActivityForResult(intent, 1001);
        AppMethodBeat.m2505o(53561);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    static /* synthetic */ void m19395c(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        int i;
        AppMethodBeat.m2504i(53562);
        int i2 = fTSEmojiDetailPageUI.scene;
        String str = fTSEmojiDetailPageUI.lcA;
        String str2 = fTSEmojiDetailPageUI.kVF;
        switch (fTSEmojiDetailPageUI.type) {
            case 2:
                if (!C5046bo.isNullOrNil(fTSEmojiDetailPageUI.cwg)) {
                    i = 1;
                    break;
                }
            case 3:
                if (!C5046bo.isNullOrNil(fTSEmojiDetailPageUI.cAo)) {
                    i = 2;
                    break;
                }
            case 4:
                if (!C5046bo.isNullOrNil(fTSEmojiDetailPageUI.lcD)) {
                    i = 3;
                    break;
                }
            default:
                i = 0;
                break;
        }
        if (fTSEmojiDetailPageUI.blX()) {
            i = 4;
        }
        C14423an.m22650b(i2, str, str2, 3, i);
        if (fTSEmojiDetailPageUI.blX()) {
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 8);
            bundle.putString("stat_search_id", fTSEmojiDetailPageUI.lcA);
            String str3 = fTSEmojiDetailPageUI.lcA + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + fTSEmojiDetailPageUI.kVF + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + String.valueOf(fTSEmojiDetailPageUI.scene) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + String.valueOf(fTSEmojiDetailPageUI.type);
            Intent intent = new Intent();
            intent.putExtra("key_username", fTSEmojiDetailPageUI.lcG);
            intent.putExtra("key_can_swipe_back", true);
            intent.putExtra("key_from_scene", 6);
            intent.putExtra("key_scene_note", str3);
            intent.putExtra("_stat_obj", bundle);
            C25985d.m41467b(fTSEmojiDetailPageUI.mController.ylL, "appbrand", ".ui.AppBrandProfileUI", intent);
            AppMethodBeat.m2505o(53562);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("preceding_scence", fTSEmojiDetailPageUI.getIntent().getIntExtra("preceding_scence", 0));
        intent2.putExtra("download_entrance_scene", 27);
        intent2.putExtra("searchID", C5046bo.getLong(fTSEmojiDetailPageUI.lcA, 0));
        intent2.putExtra("docID", fTSEmojiDetailPageUI.kVF);
        switch (fTSEmojiDetailPageUI.type) {
            case 2:
                intent2.setClass(fTSEmojiDetailPageUI, EmojiStoreDetailUI.class);
                intent2.setFlags(268435456);
                intent2.putExtra("extra_scence", fTSEmojiDetailPageUI.scene);
                intent2.putExtra("extra_type", fTSEmojiDetailPageUI.type);
                intent2.putExtra("extra_id", fTSEmojiDetailPageUI.cwg);
                break;
            case 3:
                intent2.setClass(fTSEmojiDetailPageUI, EmojiStoreV2DesignerUI.class);
                intent2.putExtra("extra_scence", 27);
                intent2.putExtra("id", fTSEmojiDetailPageUI.cAo);
                intent2.putExtra("name", fTSEmojiDetailPageUI.designerName);
                intent2.putExtra("headurl", fTSEmojiDetailPageUI.lcF);
                break;
            case 4:
                if (!C5046bo.isNullOrNil(fTSEmojiDetailPageUI.lcD)) {
                    intent2.putExtra("rawUrl", fTSEmojiDetailPageUI.lcD);
                    C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                }
                AppMethodBeat.m2505o(53562);
                return;
            default:
                AppMethodBeat.m2505o(53562);
                return;
        }
        fTSEmojiDetailPageUI.startActivity(intent2);
        AppMethodBeat.m2505o(53562);
    }

    /* renamed from: d */
    static /* synthetic */ void m19396d(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.m2504i(53563);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (fTSEmojiDetailPageUI.lcz) {
            arrayList.add(Integer.valueOf(1));
            arrayList2.add(fTSEmojiDetailPageUI.getString(C25738R.string.dwz));
        }
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(fTSEmojiDetailPageUI.getString(C25738R.string.bac));
        if (fTSEmojiDetailPageUI.icA == null) {
            fTSEmojiDetailPageUI.icA = new C46696j(fTSEmojiDetailPageUI.mController.ylL);
        }
        fTSEmojiDetailPageUI.icA.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(53550);
                c44273l.setHeaderTitle((CharSequence) "");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        c44273l.mo70068e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(53550);
                        return;
                    }
                }
            }
        };
        fTSEmojiDetailPageUI.icA.rBm = fTSEmojiDetailPageUI.lcJ;
        fTSEmojiDetailPageUI.icA.mo75012e(new C115762());
        C30379h.m48455a(fTSEmojiDetailPageUI.mController.ylL, fTSEmojiDetailPageUI.icA.cuu());
        AppMethodBeat.m2505o(53563);
    }

    /* renamed from: h */
    static /* synthetic */ void m19401h(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.m2504i(53565);
        C4990ab.m7410d("MicroMsg.FTS.FTSEmojiDetailPageUI", "ApplicationLanguage" + C4988aa.dor());
        String str = fTSEmojiDetailPageUI.getString(C25738R.string.c1d) + C4988aa.dor();
        Intent intent = new Intent();
        intent.putExtra("title", fTSEmojiDetailPageUI.getString(C25738R.string.bac));
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        C25985d.m41467b((Context) fTSEmojiDetailPageUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(53565);
    }

    /* renamed from: i */
    static /* synthetic */ void m19402i(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.m2504i(53566);
        C1720g.m3539RS().mo10302aa(new C115774());
        AppMethodBeat.m2505o(53566);
    }
}
