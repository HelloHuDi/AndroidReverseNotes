package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26107cx;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5257e;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMTagPanel;
import com.tencent.p177mm.p612ui.base.MMTagPanel.C44799a;
import com.tencent.p177mm.p612ui.contact.LabelContainerView;
import com.tencent.p177mm.p612ui.contact.LabelContainerView.C30632a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.C11603a.C11601a;
import com.tencent.p177mm.plugin.emoji.p726f.C42946h;
import com.tencent.p177mm.plugin.emoji.p726f.C42947i;
import com.tencent.p177mm.plugin.emoji.p947e.C45854l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.protocal.protobuf.C7288xz;
import com.tencent.p177mm.protocal.protobuf.aia;
import com.tencent.p177mm.protocal.protobuf.aic;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI */
public class EmojiStoreV2SingleProductUI extends MMActivity implements OnScrollListener, C1202f {
    private View abB;
    private String edV;
    private int gOW;
    private ProgressDialog gqo;
    private boolean isLoading = false;
    private long kVE;
    private String kWK;
    private String kWM;
    private MMPullDownView ldC;
    private C42947i ldE;
    private int lde = 0;
    private C5257e lfA = new C277807();
    private C5258c lfB = new C277768();
    private int lfa;
    private String lfb;
    private int lfc = -1;
    private String lfd;
    private String lfe;
    private String lff;
    private String lfg;
    private String lfh;
    private int lfi = 0;
    private PreViewListGridView lfj;
    private C11603a lfk;
    private View lfl;
    private TextView lfm;
    private View lfn;
    private boolean lfo = true;
    private aia lfp;
    private byte[] lfq;
    private int lfr = -1;
    private String lfs;
    private LabelContainerView lft;
    private TextView lfu;
    private MMTagPanel lfv;
    private HashMap<String, Integer> lfw = new HashMap();
    private ArrayList<String> lfx;
    private boolean lfy = false;
    private C4884c lfz = new C277796();
    private C7306ak mHandler = new C277741();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$2 */
    class C115942 implements OnMenuItemClickListener {
        C115942() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53745);
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
            EmojiStoreV2SingleProductUI.m44150o(EmojiStoreV2SingleProductUI.this);
            AppMethodBeat.m2505o(53745);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$9 */
    class C115959 implements OnMenuItemClickListener {
        C115959() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53753);
            if (EmojiStoreV2SingleProductUI.this.lft == null || EmojiStoreV2SingleProductUI.this.lft.getVisibility() != 0) {
                EmojiStoreV2SingleProductUI.this.finish();
            } else {
                EmojiStoreV2SingleProductUI.this.lft.setVisibility(8);
                EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, EmojiStoreV2SingleProductUI.this.lfo);
                EmojiStoreV2SingleProductUI.this.setMMTitle((int) C25738R.string.bba);
            }
            AppMethodBeat.m2505o(53753);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$1 */
    class C277741 extends C7306ak {
        C277741() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53744);
            switch (message.what) {
                case 1001:
                    if (EmojiStoreV2SingleProductUI.this.lfn != null) {
                        EmojiStoreV2SingleProductUI.this.lfn.setVisibility(8);
                        AppMethodBeat.m2505o(53744);
                        return;
                    }
                    break;
                case 1002:
                    if (EmojiStoreV2SingleProductUI.this.lfn != null) {
                        EmojiStoreV2SingleProductUI.this.lfn.setVisibility(0);
                    }
                    sendEmptyMessage(1003);
                    AppMethodBeat.m2505o(53744);
                    return;
                case 1004:
                    EmojiStoreV2SingleProductUI.m44137b(EmojiStoreV2SingleProductUI.this);
                    break;
            }
            AppMethodBeat.m2505o(53744);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$8 */
    class C277768 implements C5258c {
        C277768() {
        }

        public final boolean bhm() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$5 */
    class C277775 implements C5279d {
        C277775() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(53748);
            switch (menuItem.getItemId()) {
                case 1000:
                    Context context = EmojiStoreV2SingleProductUI.this.mController.ylL;
                    String r = EmojiStoreV2SingleProductUI.this.lfd;
                    String s = EmojiStoreV2SingleProductUI.this.lff;
                    String t = EmojiStoreV2SingleProductUI.this.lfe;
                    C42952j.bki();
                    C45854l.m84902a(context, r, s, t, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.m44075a(EmojiStoreV2SingleProductUI.this.lfc, EmojiStoreV2SingleProductUI.this.lfd, EmojiStoreV2SingleProductUI.this.lff, EmojiStoreV2SingleProductUI.this.lfe, EmojiStoreV2SingleProductUI.this.lfg, EmojiStoreV2SingleProductUI.this.lfi), 12);
                    C7060h.pYm.mo8381e(13224, Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2SingleProductUI.this.lfc));
                    break;
                case 1001:
                    C45854l.m84904dE(EmojiStoreV2SingleProductUI.this.mController.ylL);
                    EmojiStoreV2SingleProductUI.this.mController.ylL.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
                    C7060h.pYm.mo8381e(13224, Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2SingleProductUI.this.lfc));
                    AppMethodBeat.m2505o(53748);
                    return;
            }
            AppMethodBeat.m2505o(53748);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$4 */
    class C277784 implements C36073c {
        C277784() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(53747);
            c44273l.mo70049a(1001, EmojiStoreV2SingleProductUI.this.getString(C25738R.string.ba1), (int) C1318a.bottomsheet_icon_transmit);
            c44273l.mo70049a(1000, EmojiStoreV2SingleProductUI.this.getString(C25738R.string.ba2), (int) C1318a.bottomsheet_icon_moment);
            AppMethodBeat.m2505o(53747);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$6 */
    class C277796 extends C4884c<C26107cx> {

        /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$6$1 */
        class C277751 implements Runnable {
            C277751() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53749);
                EmojiStoreV2SingleProductUI.this.lfk.notifyDataSetInvalidated();
                AppMethodBeat.m2505o(53749);
            }
        }

        C277796() {
            AppMethodBeat.m2504i(53750);
            this.xxI = C26107cx.class.getName().hashCode();
            AppMethodBeat.m2505o(53750);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53751);
            if (!(EmojiStoreV2SingleProductUI.this.lfk == null || EmojiStoreV2SingleProductUI.this.mHandler == null)) {
                EmojiStoreV2SingleProductUI.this.mHandler.post(new C277751());
            }
            AppMethodBeat.m2505o(53751);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$7 */
    class C277807 implements C5257e {
        C277807() {
        }

        public final boolean bhk() {
            AppMethodBeat.m2504i(53752);
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
            EmojiStoreV2SingleProductUI.m44140e(EmojiStoreV2SingleProductUI.this);
            AppMethodBeat.m2505o(53752);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$10 */
    class C2778110 implements C11601a {
        C2778110() {
        }

        /* renamed from: tY */
        public final void mo23327tY(int i) {
            AppMethodBeat.m2504i(53754);
            if (!(EmojiStoreV2SingleProductUI.this.lfj == null || EmojiStoreV2SingleProductUI.this.lfk == null)) {
                C40588xx uo = EmojiStoreV2SingleProductUI.this.lfk.mo23333uo(i);
                if (uo != null) {
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.this.edV);
                        intent.putExtra("extra_object", uo.toByteArray());
                        intent.putExtra("scene", EmojiStoreV2SingleProductUI.this.gOW);
                        intent.putExtra("searchID", EmojiStoreV2SingleProductUI.this.kVE);
                        intent.putExtra("add_source", 5);
                        intent.putExtra("entrance_scene", 29);
                        intent.setClass(EmojiStoreV2SingleProductUI.this.mController.ylL, EmojiStoreV2SingleProductDialogUI.class);
                        EmojiStoreV2SingleProductUI.this.startActivityForResult(intent, ReaderCallback.HIDDEN_BAR);
                        EmojiStoreV2SingleProductUI.this.overridePendingTransition(C25738R.anim.f8362c4, C25738R.anim.f8367c9);
                        C7060h.pYm.mo8381e(12787, Integer.valueOf(EmojiStoreV2SingleProductUI.this.gOW), Integer.valueOf(0), uo.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.this.kVE), uo.wdC, uo.ProductID, Integer.valueOf(29));
                        AppMethodBeat.m2505o(53754);
                        return;
                    } catch (Exception e) {
                    }
                }
            }
            AppMethodBeat.m2505o(53754);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$12 */
    class C2778212 implements C44799a {
        C2778212() {
        }

        /* renamed from: JR */
        public final void mo23722JR(String str) {
            AppMethodBeat.m2504i(53757);
            if (!(C5046bo.isNullOrNil(EmojiStoreV2SingleProductUI.this.lfs) || C5046bo.isNullOrNil(str) || !str.equals(EmojiStoreV2SingleProductUI.this.lfs))) {
                EmojiStoreV2SingleProductUI.this.lfv.mo71952cd(EmojiStoreV2SingleProductUI.this.lfs, true);
            }
            AppMethodBeat.m2505o(53757);
        }

        /* renamed from: JS */
        public final void mo23723JS(String str) {
            AppMethodBeat.m2504i(53758);
            EmojiStoreV2SingleProductUI.m44134a(EmojiStoreV2SingleProductUI.this, str);
            AppMethodBeat.m2505o(53758);
        }

        /* renamed from: JT */
        public final void mo23724JT(String str) {
        }

        /* renamed from: q */
        public final void mo23728q(boolean z, int i) {
        }

        public final void bmm() {
        }

        /* renamed from: JU */
        public final void mo23725JU(String str) {
        }

        /* renamed from: JV */
        public final void mo23726JV(String str) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$13 */
    class C2778313 implements OnMenuItemClickListener {
        C2778313() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53759);
            if (EmojiStoreV2SingleProductUI.this.lft != null) {
                EmojiStoreV2SingleProductUI.this.lft.setVisibility(0);
                Collection arrayList = new ArrayList();
                arrayList.add(EmojiStoreV2SingleProductUI.this.lfs);
                EmojiStoreV2SingleProductUI.this.lfv.mo71950a(arrayList, EmojiStoreV2SingleProductUI.this.lfx);
                EmojiStoreV2SingleProductUI.this.setMMTitle((int) C25738R.string.bby);
                EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, false);
                C7060h.pYm.mo8374X(12788, "1");
            }
            AppMethodBeat.m2505o(53759);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$11 */
    class C2778411 implements C30632a {
        C2778411() {
        }

        public final void bmk() {
            AppMethodBeat.m2504i(53755);
            if (EmojiStoreV2SingleProductUI.this.lft != null) {
                EmojiStoreV2SingleProductUI.this.lft.clearFocus();
            }
            EmojiStoreV2SingleProductUI.this.lft.requestFocus();
            EmojiStoreV2SingleProductUI.this.lft.setVisibility(8);
            EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, EmojiStoreV2SingleProductUI.this.lfo);
            EmojiStoreV2SingleProductUI.this.setMMTitle((int) C25738R.string.bba);
            AppMethodBeat.m2505o(53755);
        }

        public final void bml() {
            AppMethodBeat.m2504i(53756);
            EmojiStoreV2SingleProductUI.this.aqX();
            AppMethodBeat.m2505o(53756);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI$3 */
    class C277853 implements OnCancelListener {
        C277853() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53746);
            if (EmojiStoreV2SingleProductUI.this.ldE != null) {
                C1720g.m3535RO().eJo.mo14547c(EmojiStoreV2SingleProductUI.this.ldE);
            }
            AppMethodBeat.m2505o(53746);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiStoreV2SingleProductUI() {
        AppMethodBeat.m2504i(53760);
        AppMethodBeat.m2505o(53760);
    }

    /* renamed from: b */
    static /* synthetic */ void m44137b(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.m2504i(53779);
        emojiStoreV2SingleProductUI.m44131Kh();
        AppMethodBeat.m2505o(53779);
    }

    /* renamed from: e */
    static /* synthetic */ void m44140e(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.m2504i(53780);
        emojiStoreV2SingleProductUI.bmi();
        AppMethodBeat.m2505o(53780);
    }

    public final int getLayoutId() {
        return 2130969381;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0183  */
    /* JADX WARNING: Missing block: B:51:0x020d, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r9.kWM) != false) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:53:0x0213, code skipped:
            if (r9.lde == 0) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:55:0x0219, code skipped:
            if (r9.lfa == 0) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:57:0x0223, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r9.kWK) != false) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:59:0x0229, code skipped:
            if (r9.lfc == 0) goto L_0x0111;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(53761);
        super.onCreate(bundle);
        this.lde = getIntent().getIntExtra(OpenSDKTool4Assistant.EXTRA_UIN, 0);
        this.edV = getIntent().getStringExtra("Select_Conv_User");
        this.kVE = getIntent().getLongExtra("searchID", 0);
        this.kWM = getIntent().getStringExtra("id");
        String stringExtra = getIntent().getStringExtra("tag_id");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            try {
                this.lfa = Integer.valueOf(stringExtra).intValue();
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", C5046bo.m7574l(e));
            }
        }
        this.lfb = getIntent().getStringExtra("tag_desc");
        this.kWK = getIntent().getStringExtra("keyword");
        this.lfc = getIntent().getIntExtra("set_id", 0);
        this.lfd = getIntent().getStringExtra("set_title");
        this.lfe = getIntent().getStringExtra("set_iconURL");
        this.lff = getIntent().getStringExtra("set_desc");
        this.lfg = getIntent().getStringExtra("headurl");
        this.lfh = getIntent().getStringExtra("sns_object_data");
        this.lfi = getIntent().getIntExtra("pageType", 0);
        if (!C5046bo.isNullOrNil(this.lfh)) {
            this.lfc = EmojiLogic.m44067Jv(this.lfh);
            this.lfd = EmojiLogic.m44068Jw(this.lfh);
            this.lfe = EmojiLogic.m44070Jy(this.lfh);
            this.lff = EmojiLogic.m44069Jx(this.lfh);
            this.lfg = EmojiLogic.m44071Jz(this.lfh);
            this.lfi = EmojiLogic.m44058JA(this.lfh);
        }
        switch (this.lfi) {
            case 0:
                if (C5046bo.isNullOrNil(this.kWK)) {
                    if (C5046bo.isNullOrNil(this.kWM)) {
                        if (this.lde == 0) {
                            if (this.lfa == 0) {
                                if (this.lfc <= 0) {
                                    this.lfi = 1;
                                    this.gOW = 0;
                                    break;
                                }
                                this.lfi = 6;
                                this.gOW = 4;
                                break;
                            }
                            this.gOW = 3;
                            this.lfi = 4;
                            break;
                        }
                        this.lfi = 3;
                        this.gOW = 1;
                        break;
                    }
                    this.lfi = 2;
                    this.gOW = 1;
                    break;
                }
                this.lfi = 5;
                this.lfo = false;
                this.gOW = 2;
                break;
            case 1:
                this.gOW = 0;
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                this.lfy = true;
                break;
        }
        if (this.lfy) {
            Intent intent = new Intent();
            C42952j.bki();
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            intent.putExtra("showShare", false);
            C25985d.m41467b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            finish();
        }
        initView();
        if (this.lde == 0 && this.lfi == 2) {
            aic aqn = C42952j.getEmojiStorageMgr().xYt.aqn(this.kWM);
            if (aqn == null || aqn.woq == null || aqn.woq.DesignerUin == 0 || C5046bo.isNullOrNil(aqn.woq.Name)) {
                z = true;
                if (z) {
                    m44131Kh();
                } else {
                    this.ldE = new C42947i(this.kWM);
                    C1720g.m3535RO().eJo.mo14541a(this.ldE, 0);
                    m44129JP(getString(C25738R.string.f9260un));
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.FALSE);
                C1720g.m3535RO().eJo.mo14539a(821, (C1202f) this);
                C1720g.m3535RO().eJo.mo14539a((int) C31128d.MIC_PTU_SHISHANG2, (C1202f) this);
                AppMethodBeat.m2505o(53761);
            }
            this.lde = aqn.woq.DesignerUin;
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", Integer.valueOf(this.lde));
        }
        z = false;
        if (z) {
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.FALSE);
        C1720g.m3535RO().eJo.mo14539a(821, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a((int) C31128d.MIC_PTU_SHISHANG2, (C1202f) this);
        AppMethodBeat.m2505o(53761);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53762);
        super.onResume();
        C4879a.xxA.mo10052c(this.lfz);
        AppMethodBeat.m2505o(53762);
    }

    public void onPause() {
        AppMethodBeat.m2504i(53763);
        super.onPause();
        C4879a.xxA.mo10053d(this.lfz);
        AppMethodBeat.m2505o(53763);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53764);
        C1720g.m3535RO().eJo.mo14546b((int) C31128d.MIC_PTU_SHISHANG2, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(821, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(53764);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53765);
        switch (i) {
            case 2002:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(stringExtra)));
                        int i3 = this.lfc;
                        String str = this.lfd;
                        String str2 = this.lff;
                        String str3 = this.lfe;
                        String str4 = this.lfg;
                        int i4 = this.lfi;
                        C42952j.bki();
                        C45854l.m84903a(this, stringExtra, 27, i3, str, str2, str3, str4, i4, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
                        break;
                    }
                }
                break;
            case ReaderCallback.HIDDEN_BAR /*5001*/:
                if (i2 == -1) {
                    C5670b.m8523i(this, this.mController.ylL.getString(C25738R.string.f9223ti));
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(53765);
    }

    public final void initView() {
        AppMethodBeat.m2504i(53766);
        if (this.lfi != 6 || C5046bo.isNullOrNil(this.lfd)) {
            setMMTitle((int) C25738R.string.bba);
        } else {
            setMMTitle(this.lfd);
        }
        setBackBtn(new C115959());
        this.lfk = new C11603a(this.mController.ylL);
        this.lfk.lgn = new C2778110();
        this.lfj = (PreViewListGridView) findViewById(2131820986);
        this.abB = C5616v.m8409hu(this.mController.ylL).inflate(2130969367, null);
        this.lfl = this.abB.findViewById(2131823562);
        this.lfm = (TextView) this.abB.findViewById(2131823563);
        this.lfj.addHeaderView(this.abB);
        this.lfn = C5616v.m8409hu(this.mController.ylL).inflate(2130969354, null);
        this.lfj.addFooterView(this.lfn);
        this.lfn.setVisibility(8);
        this.lfj.setAdapter(this.lfk);
        this.lfj.setOnScrollListener(this);
        this.ldC = (MMPullDownView) findViewById(2131823590);
        this.ldC.setTopViewVisible(false);
        this.ldC.setOnBottomLoadDataListener(this.lfA);
        this.ldC.setAtBottomCallBack(this.lfB);
        this.ldC.setBottomViewVisible(false);
        this.ldC.setIsBottomShowAll(false);
        this.ldC.setIsReturnSuperDispatchWhenCancel(true);
        this.lft = (LabelContainerView) findViewById(2131820901);
        this.lfu = (TextView) this.lft.findViewById(16908310);
        this.lfu.setText(C25738R.string.cl9);
        this.lfv = (MMTagPanel) this.lft.findViewById(2131820902);
        this.lfv.setTagSelectedBG(C25738R.drawable.a2v);
        this.lfv.setTagSelectedTextColorRes(C25738R.color.a61);
        this.lfs = getString(C25738R.string.bc3);
        this.lft.setOnLabelContainerListener(new C2778411());
        this.lfv.setCallBack(new C2778212());
        addIconOptionMenu(1001, C25738R.drawable.aun, new C2778313());
        addIconOptionMenu(1002, C1318a.ofm_send_icon, new C115942());
        showOptionMenu(1001, false);
        showOptionMenu(1002, false);
        AppMethodBeat.m2505o(53766);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(53767);
        if (this.lft == null || this.lft.getVisibility() != 0) {
            super.onBackPressed();
            AppMethodBeat.m2505o(53767);
            return;
        }
        this.lft.setVisibility(8);
        showOptionMenu(1001, this.lfo);
        setMMTitle((int) C25738R.string.bba);
        AppMethodBeat.m2505o(53767);
    }

    /* renamed from: Kh */
    private void m44131Kh() {
        AppMethodBeat.m2504i(53768);
        if (this.lfy) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
            AppMethodBeat.m2505o(53768);
            return;
        }
        this.lfq = null;
        switch (this.lfi) {
            case 1:
                this.lfp = C42952j.getEmojiStorageMgr().xYt.aqo(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                if (this.lfp == null || this.lfp.woo == null || this.lfk == null) {
                    m44129JP(getString(C25738R.string.f9260un));
                } else {
                    m44135a(this.lfp);
                    this.lfk.mo23328bw(this.lfp.woo);
                }
                this.lfo = true;
                C7060h.pYm.mo8381e(12875, Integer.valueOf(0), "");
                break;
            case 2:
            case 3:
                showOptionMenu(1001, false);
                this.lfo = false;
                C7060h.pYm.mo8381e(12875, Integer.valueOf(1), this.kWM);
                break;
            case 4:
                showOptionMenu(1001, false);
                this.lfs = this.lfb;
                m44130JQ(this.lfs);
                this.lfo = false;
                C7060h.pYm.mo8381e(12875, Integer.valueOf(1), "");
                break;
            case 5:
                this.lfs = "";
                m44130JQ(this.kWK);
                this.lfo = false;
                C7060h.pYm.mo8381e(12875, Integer.valueOf(2), "");
                break;
            case 6:
                this.lfs = "";
                showOptionMenu(1001, false);
                showOptionMenu(1002, true);
                C7060h.pYm.mo8381e(12875, Integer.valueOf(3), "");
                break;
        }
        m44136aK(this.lfq);
        AppMethodBeat.m2505o(53768);
    }

    /* renamed from: JP */
    private void m44129JP(String str) {
        AppMethodBeat.m2504i(53769);
        if (isFinishing()) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
            AppMethodBeat.m2505o(53769);
            return;
        }
        getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b((Context) this, str, true, new C277853());
        AppMethodBeat.m2505o(53769);
    }

    private void blb() {
        AppMethodBeat.m2504i(53770);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.m2505o(53770);
    }

    /* renamed from: aK */
    private void m44136aK(byte[] bArr) {
        AppMethodBeat.m2504i(53771);
        this.lfq = null;
        switch (this.lfi) {
            case 1:
                C1720g.m3535RO().eJo.mo14541a(new C42946h(1, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                AppMethodBeat.m2505o(53771);
                return;
            case 2:
            case 3:
                C1720g.m3535RO().eJo.mo14541a(new C42946h(2, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                AppMethodBeat.m2505o(53771);
                return;
            case 4:
                C1720g.m3535RO().eJo.mo14541a(new C42946h(3, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                AppMethodBeat.m2505o(53771);
                return;
            case 5:
                C1720g.m3535RO().eJo.mo14541a(new C42946h(4, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                AppMethodBeat.m2505o(53771);
                return;
            case 6:
                C1720g.m3535RO().eJo.mo14541a(new C42946h(5, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                break;
        }
        AppMethodBeat.m2505o(53771);
    }

    /* renamed from: a */
    private void m44135a(aia aia) {
        boolean z = false;
        AppMethodBeat.m2504i(53772);
        if (aia == null || aia.wop == null || aia.wop.size() <= 0) {
            showOptionMenu(1001, false);
        } else {
            if (this.lfo) {
                z = true;
            }
            showOptionMenu(1001, z);
            if (this.lfv != null) {
                if (this.lfx == null) {
                    this.lfx = new ArrayList();
                } else {
                    this.lfx.clear();
                }
                if (this.lfw == null) {
                    this.lfw = new HashMap();
                }
                this.lfw.clear();
                this.lfx.add(getString(C25738R.string.bc3));
                Iterator it = aia.wop.iterator();
                while (it.hasNext()) {
                    C7288xz c7288xz = (C7288xz) it.next();
                    if (!(c7288xz == null || C5046bo.isNullOrNil(c7288xz.wdJ))) {
                        this.lfx.add(c7288xz.wdJ);
                        this.lfw.put(c7288xz.wdJ, Integer.valueOf(c7288xz.wdI));
                    }
                }
                Collection arrayList = new ArrayList();
                arrayList.add(this.lfs);
                this.lfv.mo71950a(arrayList, this.lfx);
                AppMethodBeat.m2505o(53772);
                return;
            }
        }
        AppMethodBeat.m2505o(53772);
    }

    /* renamed from: JQ */
    private void m44130JQ(String str) {
        AppMethodBeat.m2504i(53773);
        if (!(this.lfl == null || this.lfm == null)) {
            switch (this.lfi) {
                case 4:
                    if (!C5046bo.isNullOrNil(str)) {
                        this.lfm.setText(getString(C25738R.string.bc4, new Object[]{str}));
                        this.lfm.setVisibility(0);
                        this.lfl.setVisibility(0);
                        break;
                    }
                    break;
                case 5:
                    if (!C5046bo.isNullOrNil(str)) {
                        this.lfm.setText(getString(C25738R.string.bbz, new Object[]{str}));
                        this.lfm.setVisibility(0);
                        this.lfl.setVisibility(0);
                        break;
                    }
                    break;
            }
            if (C5046bo.isNullOrNil(str)) {
                this.lfm.setText("");
                this.lfm.setVisibility(8);
                this.lfl.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(53773);
    }

    private void bmi() {
        AppMethodBeat.m2504i(53774);
        if (!this.isLoading) {
            m44136aK(this.lfq);
            this.isLoading = true;
            this.mHandler.sendEmptyMessageDelayed(1002, 200);
        }
        AppMethodBeat.m2505o(53774);
    }

    /* renamed from: R */
    private void m44132R(LinkedList<C40588xx> linkedList) {
        AppMethodBeat.m2504i(53775);
        if (!(this.lfk == null || linkedList == null)) {
            if (this.lfr == -1) {
                this.lfk.mo23328bw(linkedList);
                AppMethodBeat.m2505o(53775);
                return;
            }
            C11603a c11603a = this.lfk;
            if (c11603a.kSg == null) {
                c11603a.kSg = new ArrayList();
            }
            c11603a.kSg.addAll(linkedList);
            c11603a.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(53775);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53777);
        int type = c1207m.getType();
        if (type == 821) {
            blb();
            C42946h c42946h = (C42946h) c1207m;
            aia bkw = c42946h.bkw();
            this.isLoading = false;
            if (this.lfn != null) {
                this.lfn.setVisibility(8);
                this.mHandler.removeMessages(1002);
                this.mHandler.sendEmptyMessageDelayed(1001, 200);
            }
            int i3 = c42946h.gvO;
            if (((i == 0 && i2 == 0) || (i == 4 && (i2 == 2 || i2 == 3))) && ((this.lfq == null || this.lfq.length <= 0) && i3 != 3)) {
                m44135a(bkw);
            }
            if (i == 0 || i == 4) {
                this.lfq = c42946h.kWI;
                if (i2 == 0) {
                    m44132R(bkw.woo);
                    this.lfr = 0;
                    AppMethodBeat.m2505o(53777);
                    return;
                } else if (i2 == 2) {
                    m44132R(bkw.woo);
                    this.lfr = 2;
                    AppMethodBeat.m2505o(53777);
                    return;
                } else if (i2 == 3) {
                    this.lfr = -1;
                    m44132R(bkw.woo);
                    AppMethodBeat.m2505o(53777);
                    return;
                } else {
                    bmj();
                    AppMethodBeat.m2505o(53777);
                    return;
                }
            }
            bmj();
            AppMethodBeat.m2505o(53777);
            return;
        }
        if (type == C31128d.MIC_PTU_SHISHANG2) {
            blb();
            if (i2 == 0 && i == 0) {
                aic bkx = ((C42947i) c1207m).bkx();
                if (!(bkx == null || bkx.woq == null)) {
                    this.lde = bkx.woq.DesignerUin;
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(1004);
                    }
                }
                AppMethodBeat.m2505o(53777);
                return;
            }
            showOptionMenu(1001, false);
            C30379h.m48461b(this.mController.ylL, getString(C25738R.string.b_3), null, true);
            C4990ab.m7412e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
        }
        AppMethodBeat.m2505o(53777);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(53778);
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.lfr == 2 && !this.isLoading) {
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
            bmi();
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        if (!(i == 0 || this.lfj == null)) {
            this.lfj.bmt();
        }
        AppMethodBeat.m2505o(53778);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void bmj() {
        AppMethodBeat.m2504i(53776);
        Toast.makeText(this.mController.ylL, getString(C25738R.string.bd1), 0).show();
        AppMethodBeat.m2505o(53776);
    }

    /* renamed from: a */
    static /* synthetic */ void m44134a(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI, String str) {
        AppMethodBeat.m2504i(53781);
        emojiStoreV2SingleProductUI.setMMTitle((int) C25738R.string.bba);
        emojiStoreV2SingleProductUI.showOptionMenu(1001, emojiStoreV2SingleProductUI.lfo);
        if (emojiStoreV2SingleProductUI.lfw == null || !emojiStoreV2SingleProductUI.lfw.containsKey(str)) {
            emojiStoreV2SingleProductUI.lfq = null;
            emojiStoreV2SingleProductUI.lfr = -1;
            emojiStoreV2SingleProductUI.lfs = emojiStoreV2SingleProductUI.getString(C25738R.string.bc3);
            emojiStoreV2SingleProductUI.lfi = 1;
            emojiStoreV2SingleProductUI.lfa = 0;
            emojiStoreV2SingleProductUI.m44136aK(emojiStoreV2SingleProductUI.lfq);
            emojiStoreV2SingleProductUI.m44130JQ("");
        } else {
            emojiStoreV2SingleProductUI.lfr = -1;
            emojiStoreV2SingleProductUI.lfs = str;
            emojiStoreV2SingleProductUI.lfi = 4;
            emojiStoreV2SingleProductUI.lfa = ((Integer) emojiStoreV2SingleProductUI.lfw.get(emojiStoreV2SingleProductUI.lfs)).intValue();
            emojiStoreV2SingleProductUI.m44136aK(null);
            emojiStoreV2SingleProductUI.m44130JQ(str);
        }
        if (emojiStoreV2SingleProductUI.lft != null) {
            emojiStoreV2SingleProductUI.lft.setVisibility(8);
        }
        AppMethodBeat.m2505o(53781);
    }

    /* renamed from: o */
    static /* synthetic */ void m44150o(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.m2504i(53782);
        C36356d c36356d = new C36356d(emojiStoreV2SingleProductUI.mController.ylL, 1, false);
        c36356d.rBl = new C277784();
        c36356d.rBm = new C277775();
        c36356d.cpD();
        C7060h.pYm.mo8381e(13224, Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2SingleProductUI.lfc));
        AppMethodBeat.m2505o(53782);
    }
}
