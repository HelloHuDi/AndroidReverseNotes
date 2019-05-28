package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18232da;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5257e;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42951i;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C11558a;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C27740b;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p381a.C11548f;
import com.tencent.p177mm.plugin.emoji.p381a.C45843a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C45842c;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiStoreDetailUI;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.C11603a.C11601a;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.p726f.C42947i;
import com.tencent.p177mm.plugin.emoji.p726f.C42948p;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.emoji.p947e.C45854l;
import com.tencent.p177mm.plugin.emoji.p947e.C45854l.C203702;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.BannerEmojiView;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.protocal.protobuf.aic;
import com.tencent.p177mm.protocal.protobuf.aml;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.view.C31128d;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI */
public class EmojiStoreV2DesignerUI extends MMActivity implements OnScrollListener, OnItemClickListener, C1202f, C11558a, C27740b, C5258c, C5257e {
    private View abB;
    private int gOW;
    private boolean hZu;
    private long kVE;
    private String kVF;
    private String kVJ;
    private String kWM;
    C11548f kYB;
    private int kYc = -1;
    private byte[] kYe;
    protected final int kYi = 131074;
    private final int kYj = 131075;
    private final int kYk = 131076;
    private final String kYl = "product_id";
    private final String kYm = "progress";
    private final String kYn = "status";
    private C20383f kYq;
    private C42951i kYr;
    private C4884c kYt = new C204121();
    private C42945g kYu;
    TextView ldA;
    View ldB;
    private MMPullDownView ldC;
    private aml ldD;
    private C42947i ldE;
    private C44275p ldF;
    private C9636a ldG = new C204148();
    private final int ldH = 10001;
    private final int ldI = 10002;
    private final int ldJ = 10003;
    private C42948p ldK;
    private int lde;
    private String ldf;
    private String ldg;
    private C7616ad ldh;
    private View ldi;
    private BannerEmojiView ldj;
    private TextView ldk;
    private TextView ldl;
    private View ldm;
    private View ldn;
    private TextView ldo;
    private ImageView ldp;
    private TextView ldq;
    private TextView ldr;
    View lds;
    private List<C40588xx> ldt = new ArrayList();
    private View ldu;
    PreViewListGridView ldv;
    private C11603a ldw;
    View ldx;
    View ldy;
    View ldz;
    private C7306ak mHandler = new C277689();
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$12 */
    class C1159112 implements OnClickListener {
        C1159112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53590);
            EmojiStoreV2DesignerUI.m84928i(EmojiStoreV2DesignerUI.this);
            AppMethodBeat.m2505o(53590);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$10 */
    class C2041110 implements OnClickListener {
        C2041110() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53588);
            EmojiStoreV2DesignerUI.m84923e(EmojiStoreV2DesignerUI.this);
            AppMethodBeat.m2505o(53588);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$1 */
    class C204121 extends C4884c<C18232da> {
        C204121() {
            AppMethodBeat.m2504i(53579);
            this.xxI = C18232da.class.getName().hashCode();
            AppMethodBeat.m2505o(53579);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53580);
            C18232da c18232da = (C18232da) c4883b;
            EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = EmojiStoreV2DesignerUI.this;
            String str = c18232da.cwf.cwg;
            int i = c18232da.cwf.status;
            int i2 = c18232da.cwf.progress;
            C4990ab.m7411d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), c18232da.cwf.cwh);
            if (i == 6) {
                emojiStoreV2DesignerUI.mo73673bX(str, i2);
            } else {
                C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "product status:%d", Integer.valueOf(i));
                emojiStoreV2DesignerUI.mo73672bW(str, i);
            }
            if (emojiStoreV2DesignerUI.kYB != null) {
                C45842c c45842c = emojiStoreV2DesignerUI.kYB.kSP;
                if (c45842c != null) {
                    C11546f IT = c45842c.mo73635IT(str);
                    if (IT != null) {
                        IT.kTe = r4;
                    }
                }
            }
            AppMethodBeat.m2505o(53580);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$8 */
    class C204148 implements C9636a {
        C204148() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(53586);
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", str, Boolean.valueOf(z));
            if (z) {
                EmojiStoreV2DesignerUI.this.ldh = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                EmojiStoreV2DesignerUI.m84914a(EmojiStoreV2DesignerUI.this);
            }
            AppMethodBeat.m2505o(53586);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$11 */
    class C2776611 implements C11601a {
        C2776611() {
        }

        /* renamed from: tY */
        public final void mo23327tY(int i) {
            AppMethodBeat.m2504i(53589);
            if (!(EmojiStoreV2DesignerUI.this.ldv == null || EmojiStoreV2DesignerUI.this.ldw == null)) {
                C40588xx uo = EmojiStoreV2DesignerUI.this.ldw.mo23333uo(i);
                if (uo != null) {
                    C7060h.pYm.mo8381e(12787, Integer.valueOf(1), Integer.valueOf(0), uo.Md5, Long.valueOf(EmojiStoreV2DesignerUI.this.kVE), uo.wdC, uo.ProductID, Integer.valueOf(6));
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("extra_object", uo.toByteArray());
                        intent.putExtra("add_source", 5);
                        intent.putExtra("entrance_scene", 6);
                        intent.setClass(EmojiStoreV2DesignerUI.this.mController.ylL, EmojiStoreV2SingleProductDialogUI.class);
                        EmojiStoreV2DesignerUI.this.startActivityForResult(intent, 2004);
                        EmojiStoreV2DesignerUI.this.overridePendingTransition(C25738R.anim.f8362c4, C25738R.anim.f8367c9);
                        AppMethodBeat.m2505o(53589);
                        return;
                    } catch (Exception e) {
                    }
                }
            }
            AppMethodBeat.m2505o(53589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$9 */
    class C277689 extends C7306ak {
        C277689() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53587);
            String string;
            switch (message.what) {
                case 10001:
                    EmojiStoreV2DesignerUI.this.mo73675gv(false);
                    AppMethodBeat.m2505o(53587);
                    return;
                case 10002:
                    EmojiStoreV2DesignerUI.m84921c(EmojiStoreV2DesignerUI.this);
                    AppMethodBeat.m2505o(53587);
                    return;
                case 10003:
                    EmojiStoreV2DesignerUI.m84918b(EmojiStoreV2DesignerUI.this);
                    AppMethodBeat.m2505o(53587);
                    return;
                case 131075:
                    if (EmojiStoreV2DesignerUI.this.kYB == null || message.getData() == null) {
                        AppMethodBeat.m2505o(53587);
                        return;
                    }
                    string = message.getData().getString("product_id");
                    if (string == null) {
                        AppMethodBeat.m2505o(53587);
                        return;
                    }
                    EmojiStoreV2DesignerUI.this.kYB.mo54492bX(string, message.getData().getInt("progress"));
                    AppMethodBeat.m2505o(53587);
                    return;
                case 131076:
                    if (EmojiStoreV2DesignerUI.this.kYB != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            EmojiStoreV2DesignerUI.this.kYB.mo54491bW(string, message.getData().getInt("status"));
                            break;
                        }
                        AppMethodBeat.m2505o(53587);
                        return;
                    }
                    AppMethodBeat.m2505o(53587);
                    return;
            }
            AppMethodBeat.m2505o(53587);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$14 */
    class C4295614 implements OnMenuItemClickListener {
        C4295614() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53592);
            C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
            EmojiStoreV2DesignerUI.m84929j(EmojiStoreV2DesignerUI.this);
            AppMethodBeat.m2505o(53592);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$15 */
    class C4295715 implements C1282i {
        C4295715() {
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(53593);
            if (EmojiStoreV2DesignerUI.this.mHandler != null) {
                EmojiStoreV2DesignerUI.this.mHandler.sendEmptyMessage(10001);
            }
            AppMethodBeat.m2505o(53593);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$4 */
    class C429584 implements DialogInterface.OnClickListener {
        C429584() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$5 */
    class C429595 implements C36073c {
        C429595() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(53583);
            c44273l.mo70049a(1001, EmojiStoreV2DesignerUI.this.getString(C25738R.string.ba1), (int) C1318a.bottomsheet_icon_transmit);
            c44273l.mo70049a(1000, EmojiStoreV2DesignerUI.this.getString(C25738R.string.ba2), (int) C1318a.bottomsheet_icon_moment);
            AppMethodBeat.m2505o(53583);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$6 */
    class C429606 implements C5279d {
        C429606() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(53584);
            switch (menuItem.getItemId()) {
                case 1000:
                    if (EmojiStoreV2DesignerUI.this.ldD != null) {
                        C45854l.m84902a(EmojiStoreV2DesignerUI.this.mController.ylL, EmojiStoreV2DesignerUI.this.ldD.Name + EmojiStoreV2DesignerUI.this.getString(C25738R.string.bag), EmojiStoreV2DesignerUI.this.ldD.Desc, EmojiStoreV2DesignerUI.this.ldD.HeadUrl, EmojiStoreV2DesignerUI.this.ldg, EmojiLogic.m44082r(EmojiStoreV2DesignerUI.this.lde, EmojiStoreV2DesignerUI.this.kVJ, EmojiStoreV2DesignerUI.this.ldg), 10);
                        C7060h.pYm.mo8381e(13224, Integer.valueOf(3), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2DesignerUI.this.lde));
                        break;
                    }
                    break;
                case 1001:
                    C45854l.m84904dE(EmojiStoreV2DesignerUI.this.mController.ylL);
                    EmojiStoreV2DesignerUI.this.mController.ylL.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
                    C7060h.pYm.mo8381e(13224, Integer.valueOf(3), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2DesignerUI.this.lde));
                    AppMethodBeat.m2505o(53584);
                    return;
            }
            AppMethodBeat.m2505o(53584);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$7 */
    class C429617 implements OnCancelListener {
        C429617() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53585);
            if (EmojiStoreV2DesignerUI.this.ldE != null) {
                C1720g.m3535RO().eJo.mo14547c(EmojiStoreV2DesignerUI.this.ldE);
            }
            AppMethodBeat.m2505o(53585);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI$13 */
    class C4586213 implements OnMenuItemClickListener {
        C4586213() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53591);
            EmojiStoreV2DesignerUI.this.finish();
            AppMethodBeat.m2505o(53591);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiStoreV2DesignerUI() {
        AppMethodBeat.m2504i(53594);
        AppMethodBeat.m2505o(53594);
    }

    /* renamed from: b */
    static /* synthetic */ void m84918b(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.m2504i(53620);
        emojiStoreV2DesignerUI.m84912Kh();
        AppMethodBeat.m2505o(53620);
    }

    public final int getLayoutId() {
        return 2130969362;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.m2504i(53595);
        super.onCreate(bundle);
        this.kWM = getIntent().getStringExtra("id");
        this.lde = getIntent().getIntExtra(OpenSDKTool4Assistant.EXTRA_UIN, 0);
        this.kVJ = getIntent().getStringExtra("name");
        this.ldf = getIntent().getStringExtra("headurl");
        this.ldg = getIntent().getStringExtra("rediret_url");
        this.gOW = getIntent().getIntExtra("extra_scence", 0);
        this.kVE = getIntent().getLongExtra("searchID", 0);
        this.kVF = C5046bo.m7532bc(getIntent().getStringExtra("docID"), "");
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lde = EmojiLogic.m44063Jm(stringExtra);
            this.kVJ = EmojiLogic.m44064Jn(stringExtra);
            this.ldg = EmojiLogic.m44066Ju(stringExtra);
        }
        initView();
        if (!C5046bo.isNullOrNil(this.kWM)) {
            aic aqn = C42952j.getEmojiStorageMgr().xYt.aqn(this.kWM);
            if (aqn == null || aqn.woq == null || aqn.woq.DesignerUin == 0 || C5046bo.isNullOrNil(aqn.woq.Name)) {
                i = 1;
                if (i != 0) {
                    m84912Kh();
                } else {
                    this.ldE = new C42947i(this.kWM);
                    C1720g.m3535RO().eJo.mo14541a(this.ldE, 0);
                    getString(C25738R.string.f9238tz);
                    this.ldF = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C429617());
                }
                C1720g.m3535RO().eJo.mo14539a((int) C31128d.MIC_PTU_SHISHANG2, (C1202f) this);
                C1720g.m3535RO().eJo.mo14539a(720, (C1202f) this);
                C4879a.xxA.mo10052c(this.kYt);
                C7060h.pYm.mo8381e(12067, Integer.valueOf(1), "", "", "", "");
                C7060h.pYm.mo8381e(12740, Integer.valueOf(2), C1183p.getString(this.lde), "", "", Integer.valueOf(this.gOW), Integer.valueOf(6));
                AppMethodBeat.m2505o(53595);
            }
            this.lde = aqn.woq.DesignerUin;
            this.kVJ = aqn.woq.Name;
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", Integer.valueOf(this.lde), this.kVJ);
        }
        i = 0;
        if (i != 0) {
        }
        C1720g.m3535RO().eJo.mo14539a((int) C31128d.MIC_PTU_SHISHANG2, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(720, (C1202f) this);
        C4879a.xxA.mo10052c(this.kYt);
        C7060h.pYm.mo8381e(12067, Integer.valueOf(1), "", "", "", "");
        C7060h.pYm.mo8381e(12740, Integer.valueOf(2), C1183p.getString(this.lde), "", "", Integer.valueOf(this.gOW), Integer.valueOf(6));
        AppMethodBeat.m2505o(53595);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53596);
        super.onResume();
        C1720g.m3535RO().eJo.mo14539a((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        AppMethodBeat.m2505o(53596);
    }

    public void onPause() {
        AppMethodBeat.m2504i(53597);
        super.onPause();
        C1720g.m3535RO().eJo.mo14546b((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        AppMethodBeat.m2505o(53597);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53598);
        super.onDestroy();
        if (this.ldK != null) {
            C1720g.m3535RO().eJo.mo14547c(this.ldK);
        }
        C1720g.m3535RO().eJo.mo14546b((int) C31128d.MIC_PTU_SHISHANG2, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(720, (C1202f) this);
        C4879a.xxA.mo10053d(this.kYt);
        if (this.mHandler != null) {
            this.mHandler.removeMessages(10002);
            this.mHandler.removeMessages(10001);
            this.mHandler = null;
        }
        AppMethodBeat.m2505o(53598);
    }

    public final void initView() {
        AppMethodBeat.m2504i(53599);
        if (!C5046bo.isNullOrNil(this.kVJ)) {
            setMMTitle(this.kVJ);
        }
        this.abB = C5616v.m8409hu(this.mController.ylL).inflate(2130969358, null);
        this.ldi = this.abB.findViewById(2131823542);
        this.ldj = (BannerEmojiView) this.ldi.findViewById(2131823548);
        this.ldk = (TextView) this.abB.findViewById(2131823543);
        this.ldl = (TextView) this.abB.findViewById(2131823544);
        this.ldm = this.abB.findViewById(2131823545);
        this.ldn = this.abB.findViewById(2131823537);
        this.ldo = (TextView) this.abB.findViewById(2131823539);
        this.ldp = (ImageView) this.abB.findViewById(2131823538);
        this.ldq = (TextView) this.abB.findViewById(2131823540);
        this.ldr = (TextView) this.abB.findViewById(2131823547);
        this.lds = this.abB.findViewById(2131823550);
        this.ldu = this.abB.findViewById(2131823555);
        this.ldu.setOnClickListener(new C2041110());
        this.ldv = (PreViewListGridView) this.abB.findViewById(2131823553);
        this.ldw = new C11603a(this.mController.ylL);
        this.ldw.lgn = new C2776611();
        this.ldv.setAdapter(this.ldw);
        this.ldx = this.abB.findViewById(2131823551);
        this.ldy = this.abB.findViewById(2131823552);
        this.ldz = this.abB.findViewById(2131823555);
        this.ldA = (TextView) this.abB.findViewById(2131823556);
        this.ldB = this.abB.findViewById(2131823554);
        this.ldC = (MMPullDownView) findViewById(2131823536);
        this.ldC.setOnBottomLoadDataListener(this);
        this.ldC.setAtBottomCallBack(this);
        this.ldC.setBottomViewVisible(false);
        this.ldC.setIsBottomShowAll(false);
        this.mListView = (ListView) findViewById(16908298);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnScrollListener(this);
        this.ldn.setOnClickListener(new C1159112());
        setBackBtn(new C4586213());
        addIconOptionMenu(0, C1318a.ofm_send_icon, new C4295614());
        AppMethodBeat.m2505o(53599);
    }

    /* renamed from: Kh */
    private void m84912Kh() {
        AppMethodBeat.m2504i(53600);
        setMMTitle(this.kVJ);
        this.kYB = new C11548f(this.mController.ylL);
        this.mListView.addHeaderView(this.abB);
        this.mListView.setAdapter(this.kYB);
        this.kYB.kSQ = this;
        this.kYB.kSm = C26072e.m41615OJ();
        this.kYB.kSn = false;
        this.ldk.setText(this.kVJ);
        this.ldD = C42952j.getEmojiStorageMgr().xYq.aqs(String.valueOf(this.lde));
        this.kYr = new C42951i();
        this.kYr.jiq = this;
        this.kYr.kVA = this.kYB;
        this.kYr.kVD = 6;
        this.kYr.kVG = this;
        this.kYr.kVJ = this.kVJ;
        this.kYr.kVE = this.kVE;
        this.kYr.kVF = this.kVF;
        if (this.ldD != null) {
            m84920c(C42948p.m76275a(this.ldD));
            m84919bv(this.ldD.vKl);
        }
        updateData();
        m84916aJ(this.kYe);
        AppMethodBeat.m2505o(53600);
    }

    private void updateData() {
        AppMethodBeat.m2504i(53601);
        if (this.ldD == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
            AppMethodBeat.m2505o(53601);
            return;
        }
        mo73675gv(true);
        if (C5046bo.isNullOrNil(this.ldD.vKE)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
            this.ldm.setVisibility(8);
            this.ldn.setVisibility(8);
        } else {
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", this.ldD.vKE);
            this.ldh = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ldD.vKE);
        }
        if ((this.ldh == null || ((int) this.ldh.ewQ) == 0) && C26417a.flu != null) {
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", this.ldD.vKE);
            C26417a.flu.mo20966a(this.ldD.vKE, "", this.ldG);
        }
        this.ldq.setText(C25738R.string.bcf);
        if (C5046bo.isNullOrNil(this.ldD.Desc)) {
            this.ldl.setVisibility(8);
        } else {
            this.ldl.setText(this.ldD.Desc);
            this.ldl.setVisibility(0);
        }
        bme();
        if (this.kYq == null || this.kYq.kVq == null || this.kYq.kVq.isEmpty()) {
            this.ldr.setVisibility(8);
            AppMethodBeat.m2505o(53601);
            return;
        }
        this.ldr.setVisibility(0);
        AppMethodBeat.m2505o(53601);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: gv */
    public final void mo73675gv(boolean z) {
        AppMethodBeat.m2504i(53602);
        if (this.ldD == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
            AppMethodBeat.m2505o(53602);
            return;
        }
        if (!(this.ldj == null || C5046bo.isNullOrNil(this.ldD.wrl))) {
            String str = this.ldD.wrl;
            C1338a.getDensity(this);
            EmojiInfo r = EmojiLogic.m44081r("Designer", 8, str);
            if (r != null) {
                this.ldj.setImageFilePath(r.dve());
            } else if (z) {
                C32291o.ahp().mo43768a(this.ldD.wrl, null, C20364g.m31463j("Designer", this.ldD.wrl, "Designer", "BANNER"), new C4295715());
                AppMethodBeat.m2505o(53602);
                return;
            } else {
                C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
                AppMethodBeat.m2505o(53602);
                return;
            }
        }
        AppMethodBeat.m2505o(53602);
    }

    private void bme() {
        AppMethodBeat.m2504i(53603);
        if (this.ldh == null || ((int) this.ldh.ewQ) == 0) {
            this.ldn.setVisibility(8);
            this.ldm.setVisibility(8);
            AppMethodBeat.m2505o(53603);
            return;
        }
        this.ldn.setVisibility(0);
        this.ldm.setVisibility(0);
        if (C5046bo.isNullOrNil(this.ldh.mo16706Oi())) {
            this.ldo.setText(this.ldh.field_username);
        } else {
            this.ldo.setText(this.ldh.mo16706Oi());
        }
        C40460b.m69437r(this.ldp, this.ldh.field_username);
        this.ldq.setEnabled(true);
        AppMethodBeat.m2505o(53603);
    }

    /* renamed from: aJ */
    private void m84916aJ(byte[] bArr) {
        AppMethodBeat.m2504i(53604);
        this.hZu = true;
        this.ldK = new C42948p(this.lde, bArr);
        C1720g.m3535RO().eJo.mo14541a(this.ldK, 0);
        AppMethodBeat.m2505o(53604);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53605);
        switch (c1207m.getType()) {
            case C31128d.MIC_PTU_SHISHANG2 /*239*/:
                if (this.ldF != null && this.ldF.isShowing()) {
                    this.ldF.dismiss();
                }
                if (i2 == 0 && i == 0) {
                    aic bkx = ((C42947i) c1207m).bkx();
                    if (!(bkx == null || bkx.woq == null)) {
                        this.lde = bkx.woq.DesignerUin;
                        this.kVJ = bkx.woq.Name;
                        this.ldf = bkx.woq.HeadUrl;
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(10003);
                        }
                    }
                    AppMethodBeat.m2505o(53605);
                    return;
                }
                showOptionMenu(0, false);
                C30379h.m48461b(this.mController.ylL, getString(C25738R.string.b_3), null, true);
                C4990ab.m7412e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
                AppMethodBeat.m2505o(53605);
                return;
            case v2helper.EMethodSetNgStrength /*423*/:
                if (c1207m instanceof C42945g) {
                    C42945g c42945g = (C42945g) c1207m;
                    if (i == 0 && i2 == 0) {
                        mo73673bX(c42945g.kWz, 0);
                        AppMethodBeat.m2505o(53605);
                        return;
                    }
                    final String str2 = c42945g.kWz;
                    final String str3 = c42945g.kWB;
                    final String str4 = c42945g.kWA;
                    C30379h.m48440a((Context) this, getString(C25738R.string.baj, new Object[]{str4}), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(53582);
                            EmojiStoreV2DesignerUI.this.mo73671M(str2, str3, str4);
                            EmojiStoreV2DesignerUI.this.bkZ();
                            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", str2);
                            EmojiStoreV2DesignerUI.m84915a(EmojiStoreV2DesignerUI.this, str2);
                            AppMethodBeat.m2505o(53582);
                        }
                    }, new C429584());
                    mo73672bW(c42945g.kWz, -1);
                    AppMethodBeat.m2505o(53605);
                    return;
                }
                break;
            case 720:
                this.hZu = false;
                if (i == 0 || i == 4) {
                    C42948p c42948p = (C42948p) c1207m;
                    C20383f a = C42948p.m76275a(c42948p.bkE());
                    if (i2 == 0) {
                        this.ldD = c42948p.bkE();
                        m84920c(a);
                    } else if (i2 == 2) {
                        this.ldD = c42948p.bkE();
                        m84917b(this.kYc, a);
                        this.kYc = 2;
                    } else if (i2 == 3) {
                        this.ldD = c42948p.bkE();
                        m84917b(this.kYc, a);
                        this.kYc = 1;
                        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", Integer.valueOf(i2));
                    }
                    if (this.kYe == null && this.ldD != null) {
                        C42952j.getEmojiStorageMgr().xYq.mo64088a(String.valueOf(this.lde), c42948p.bkE());
                        this.ldt = this.ldD.vKl;
                        m84919bv(this.ldt);
                    }
                    this.kYe = c42948p.kWS;
                    AppMethodBeat.m2505o(53605);
                    return;
                }
                C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
                AppMethodBeat.m2505o(53605);
                return;
            default:
                C4990ab.m7412e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
                break;
        }
        AppMethodBeat.m2505o(53605);
    }

    /* renamed from: bv */
    private void m84919bv(final List<C40588xx> list) {
        int i = 1;
        AppMethodBeat.m2504i(53606);
        String value = C26373g.m41964Nu().getValue("ShowDesignerEmoji");
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", value);
        if (C5046bo.isNullOrNil(value) || C5046bo.ank(value) != 1) {
            i = 0;
        }
        if (list == null || list.size() <= 0 || i == 0) {
            this.lds.setVisibility(8);
            AppMethodBeat.m2505o(53606);
            return;
        }
        this.lds.setVisibility(0);
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                public final void run() {
                    int i;
                    int i2 = 8;
                    AppMethodBeat.m2504i(53581);
                    EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = EmojiStoreV2DesignerUI.this;
                    if (list.size() > 3) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (emojiStoreV2DesignerUI.ldv != null) {
                        emojiStoreV2DesignerUI.ldv.setVisibility(0);
                    }
                    if (emojiStoreV2DesignerUI.ldy != null) {
                        emojiStoreV2DesignerUI.ldy.setVisibility(0);
                    }
                    if (emojiStoreV2DesignerUI.ldx != null) {
                        emojiStoreV2DesignerUI.ldx.setVisibility(0);
                    }
                    if (emojiStoreV2DesignerUI.ldz != null) {
                        emojiStoreV2DesignerUI.ldz.setVisibility(i != 0 ? 0 : 8);
                    }
                    if (emojiStoreV2DesignerUI.ldA != null) {
                        emojiStoreV2DesignerUI.ldA.setText(C25738R.string.bb_);
                    }
                    if (emojiStoreV2DesignerUI.ldB != null) {
                        View view = emojiStoreV2DesignerUI.ldB;
                        if (i != 0) {
                            i2 = 0;
                        }
                        view.setVisibility(i2);
                    }
                    if (emojiStoreV2DesignerUI.lds != null) {
                        emojiStoreV2DesignerUI.lds.setPadding(0, 0, 0, 0);
                    }
                    AppMethodBeat.m2505o(53581);
                }
            });
        }
        this.ldw.mo23328bw(list);
        AppMethodBeat.m2505o(53606);
    }

    /* renamed from: c */
    private void m84920c(C20383f c20383f) {
        AppMethodBeat.m2504i(53607);
        m84917b(this.kYc, c20383f);
        this.kYc = 0;
        AppMethodBeat.m2505o(53607);
    }

    /* renamed from: b */
    private void m84917b(int i, C20383f c20383f) {
        boolean z = true;
        AppMethodBeat.m2504i(53608);
        switch (i) {
            case -1:
                this.kYq = c20383f;
                break;
            case 0:
                this.kYq = c20383f;
                break;
            case 1:
                this.kYq = c20383f;
                break;
            case 2:
                if (this.kYq == null) {
                    this.kYq = new C20383f();
                }
                this.kYq.mo35681ue(c20383f.kVp);
                this.kYq.mo35680br(c20383f.kVq);
                break;
            default:
                z = false;
                break;
        }
        m84926gw(z);
        AppMethodBeat.m2505o(53608);
    }

    /* renamed from: gw */
    private void m84926gw(boolean z) {
        AppMethodBeat.m2504i(53609);
        if (this.kYq != null && z) {
            if (this.kYB != null) {
                this.kYB.mo54490b(this.kYq);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(10002);
            }
        }
        AppMethodBeat.m2505o(53609);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(53610);
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            if (this.kYc == 0 || this.hZu) {
                C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
                AppMethodBeat.m2505o(53610);
                return;
            }
            m84916aJ(this.kYe);
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        AppMethodBeat.m2505o(53610);
    }

    public final boolean bhk() {
        return true;
    }

    public final boolean bhm() {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(53611);
        if (this.kYB != null) {
            C11546f tX = this.kYB.getItem(i - this.mListView.getHeaderViewsCount());
            if (tX != null) {
                Intent intent = new Intent();
                intent.setClass(this, EmojiStoreDetailUI.class);
                EmotionSummary emotionSummary = tX.kTb;
                if (emotionSummary == null) {
                    intent = null;
                } else {
                    intent.putExtra("extra_id", emotionSummary.ProductID);
                    intent.putExtra("extra_name", emotionSummary.PackName);
                    intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
                    intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
                    intent.putExtra("extra_description", emotionSummary.PackDesc);
                    intent.putExtra("extra_price", emotionSummary.PackPrice);
                    intent.putExtra("extra_type", emotionSummary.PackType);
                    intent.putExtra("extra_flag", emotionSummary.PackFlag);
                    intent.putExtra("preceding_scence", 106);
                    intent.putExtra("download_entrance_scene", 6);
                    intent.putExtra("call_by", 1);
                    intent.putExtra("check_clickflag", false);
                    intent.putExtra("extra_status", tX.mStatus);
                    intent.putExtra("extra_progress", tX.f2905EV);
                    intent.putExtra("searchID", this.kVE);
                    String stringExtra = getIntent().getStringExtra("to_talker_name");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        intent.putExtra("to_talker_name", stringExtra);
                    }
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        }
        AppMethodBeat.m2505o(53611);
    }

    /* renamed from: a */
    public final void mo23265a(C45843a c45843a) {
        AppMethodBeat.m2504i(53612);
        String str = "MicroMsg.emoji.EmojiStoreV2DesignerUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = c45843a.getProductId();
        objArr[1] = TextUtils.isEmpty(c45843a.bjo()) ? "" : c45843a.bjo();
        objArr[2] = Integer.valueOf(c45843a.bjn());
        C4990ab.m7417i(str, str2, objArr);
        c45843a.bjn();
        this.kYr.mo68470a(c45843a);
        AppMethodBeat.m2505o(53612);
    }

    /* renamed from: i */
    public final void mo23318i(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(53613);
        mo73671M(str, str2, str3);
        bkZ();
        AppMethodBeat.m2505o(53613);
    }

    public final void bkf() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: M */
    public final C42945g mo73671M(String str, String str2, String str3) {
        AppMethodBeat.m2504i(53614);
        this.kYu = new C42945g(str, str2, str3);
        C42945g c42945g = this.kYu;
        AppMethodBeat.m2505o(53614);
        return c42945g;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkZ() {
        AppMethodBeat.m2504i(53615);
        C1720g.m3535RO().eJo.mo14541a(this.kYu, 0);
        AppMethodBeat.m2505o(53615);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bX */
    public final void mo73673bX(String str, int i) {
        AppMethodBeat.m2504i(53616);
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
        AppMethodBeat.m2505o(53616);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bW */
    public final void mo73672bW(String str, int i) {
        AppMethodBeat.m2504i(53617);
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i);
        obtain.what = 131076;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
        AppMethodBeat.m2505o(53617);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53618);
        this.kYr.onActivityResult(i, i2, intent);
        if (i == 2002) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                if (C5046bo.isNullOrNil(stringExtra) || this.ldD == null) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
                } else {
                    C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(stringExtra)));
                    String str = this.kVJ;
                    String str2 = this.ldD.Desc;
                    int i3 = this.lde;
                    String str3 = this.ldg;
                    String str4 = this.kVJ;
                    String str5 = this.ldD.HeadUrl;
                    C40437i c40437i = (C40437i) C1720g.m3528K(C40437i.class);
                    c40437i.mo56646a((Context) this, stringExtra, getResources().getString(C25738R.string.f9090p6) + str, getString(C25738R.string.f9221tf), getString(C25738R.string.atc), str5, (C30111a) new C203702(stringExtra, str4, str2, i3, str3, str, str5, this));
                }
            }
        } else if (i == 2004 && i2 == -1) {
            C5670b.m8523i(this, this.mController.ylL.getString(C25738R.string.f9223ti));
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(53618);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: e */
    static /* synthetic */ void m84923e(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.m2504i(53622);
        if (emojiStoreV2DesignerUI.lde != 0) {
            Intent intent = new Intent();
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, emojiStoreV2DesignerUI.lde);
            intent.setClass(emojiStoreV2DesignerUI.mController.ylL, EmojiStoreV2SingleProductUI.class);
            emojiStoreV2DesignerUI.startActivity(intent);
        }
        AppMethodBeat.m2505o(53622);
    }

    /* renamed from: i */
    static /* synthetic */ void m84928i(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.m2504i(53623);
        if (!(emojiStoreV2DesignerUI.ldD == null || C5046bo.isNullOrNil(emojiStoreV2DesignerUI.ldD.vKE))) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", emojiStoreV2DesignerUI.ldD.vKE);
            C25985d.m41467b(emojiStoreV2DesignerUI.mController.ylL, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            C7060h.pYm.mo8381e(12067, Integer.valueOf(3), "", "", "", "");
        }
        AppMethodBeat.m2505o(53623);
    }

    /* renamed from: j */
    static /* synthetic */ void m84929j(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.m2504i(53624);
        C36356d c36356d = new C36356d(emojiStoreV2DesignerUI.mController.ylL, 1, false);
        c36356d.rBl = new C429595();
        c36356d.rBm = new C429606();
        c36356d.cpD();
        C7060h.pYm.mo8381e(13224, Integer.valueOf(3), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2DesignerUI.lde));
        AppMethodBeat.m2505o(53624);
    }
}
