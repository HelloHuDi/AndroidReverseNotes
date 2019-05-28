package com.tencent.p177mm.plugin.emoji.p384ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18232da;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5257e;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42951i;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C11558a;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C27740b;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p381a.C45843a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f.C11547a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33945b;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C45842c;
import com.tencent.p177mm.plugin.emoji.p383h.C33952c;
import com.tencent.p177mm.plugin.emoji.p726f.C20375n;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.p726f.C42949q;
import com.tencent.p177mm.plugin.emoji.p947e.C11553m;
import com.tencent.p177mm.pluginsdk.model.C23249h.C14889a;
import com.tencent.p177mm.pluginsdk.model.C44064n;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.StoreBannerEmojiView;
import com.tencent.p177mm.protocal.protobuf.EmotionBanner;
import com.tencent.p177mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI */
public abstract class BaseEmojiStoreUI extends EmojiBaseActivity implements OnScrollListener, OnItemClickListener, C1202f, C11558a, C27740b, C14889a, C4931a, C5258c, C5260d, C5257e {
    private static Map<String, Long> kYs;
    /* renamed from: Ek */
    protected View f3573Ek;
    private ProgressDialog gqo;
    private boolean hZu;
    C33944a kVA;
    private C33952c kVI;
    protected EmojiStoreVpHeader kXW;
    protected View kXX;
    protected StoreBannerEmojiView kXY;
    protected MMPullDownView kXZ;
    protected TextView kYa;
    protected boolean kYb = false;
    int kYc = -1;
    private View kYd;
    byte[] kYe;
    private final int kYf = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY;
    private final int kYg = CdnLogic.kMediaTypeBackupFile;
    private final int kYh = 2002;
    protected final int kYi = 131074;
    private final int kYj = 131075;
    private final int kYk = 131076;
    private final String kYl = "product_id";
    private final String kYm = "progress";
    private final String kYn = "status";
    private C20375n kYo;
    private int kYp;
    private C20383f kYq;
    private C42951i kYr;
    private C4884c kYt;
    protected C42945g kYu;
    protected boolean kYv = false;
    private LinkedList<EmotionBanner> kYw = new LinkedList();
    private LinkedList<EmotionBannerSet> kYx = new LinkedList();
    protected ListView mListView;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI$a */
    class C6838a extends C4884c<C18232da> {
        private C6838a() {
            AppMethodBeat.m2504i(53216);
            this.xxI = C18232da.class.getName().hashCode();
            AppMethodBeat.m2505o(53216);
        }

        /* synthetic */ C6838a(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
            this();
            AppMethodBeat.m2504i(53218);
            this.xxI = C18232da.class.getName().hashCode();
            AppMethodBeat.m2505o(53218);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53217);
            C18232da c18232da = (C18232da) c4883b;
            BaseEmojiStoreUI.this.mo30729h(c18232da.cwf.cwg, c18232da.cwf.status, c18232da.cwf.progress, c18232da.cwf.cwh);
            AppMethodBeat.m2505o(53217);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI$b */
    class C11564b implements OnMenuItemClickListener {
        private C11564b() {
        }

        /* synthetic */ C11564b(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
            this();
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53219);
            BaseEmojiStoreUI.this.finish();
            AppMethodBeat.m2505o(53219);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI$4 */
    class C167364 implements OnCancelListener {
        C167364() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53215);
            C1720g.m3535RO().eJo.cancel(413);
            AppMethodBeat.m2505o(53215);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI$2 */
    class C167372 implements OnClickListener {
        C167372() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI$3 */
    class C167383 implements OnCancelListener {
        C167383() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53214);
            BaseEmojiStoreUI.this.bkY();
            C1720g.m3535RO().eJo.cancel(413);
            AppMethodBeat.m2505o(53214);
        }
    }

    public abstract int bkM();

    public abstract int bkN();

    public abstract C33944a bkO();

    public abstract int bkV();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kYr = new C42951i();
        initView();
        this.kYp = getIntent().getIntExtra("preceding_scence", 2);
        if (C42952j.getEmojiStorageMgr().xYo != null) {
            C42952j.getEmojiStorageMgr().xYo.mo10116c(this);
        }
        this.kYt = new C6838a(this, (byte) 0);
        C4879a.xxA.mo10052c(this.kYt);
        this.kYr.jiq = this;
        this.kYr.kVA = this.kVA;
        this.kYr.kVD = bkM();
        this.kYr.kVG = this;
        boolean blc = blc();
        if (blc) {
            blc = bla();
        }
        mo30736z(false, blc);
        if (kYs == null) {
            kYs = new HashMap();
        }
        C4990ab.m7411d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", Long.valueOf(System.currentTimeMillis()));
        kYs.put(getClass().toString(), Long.valueOf(r0));
        this.kVI = new C33952c(1005);
    }

    public void onResume() {
        super.onResume();
        C1720g.m3535RO().eJo.mo14539a(411, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(413, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(717, (C1202f) this);
        if (bkS() && this.kXW != null) {
            this.kXW.blS();
        }
        Boolean bool = Boolean.FALSE;
        this.kYr.kVB = false;
        if (this.kVA != null && this.kVA.kSP != null) {
            this.kVA.kSP.bjD();
            this.kVA.refreshView();
        }
    }

    public void onPause() {
        super.onPause();
        C1720g.m3535RO().eJo.mo14546b(411, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(413, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(717, (C1202f) this);
        bkY();
        if (bkS() && this.kXW != null) {
            this.kXW.blT();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.kVA != null) {
            this.kVA.clear();
            this.kVA = null;
        }
        if (bkS() && this.kXW != null) {
            this.kXW.clear();
        }
        C42952j.getEmojiStorageMgr().xYo.mo10117d(this);
        C4879a.xxA.mo10053d(this.kYt);
        C1720g.m3535RO().eJo.mo14547c(this.kYu);
        if (this.kYr != null) {
            C42951i c42951i = this.kYr;
            c42951i.kVA = null;
            c42951i.kVG = null;
            c42951i.jiq = null;
        }
    }

    public int getLayoutId() {
        return 2130969355;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = -1;
        String str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str3 = "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        C4990ab.m7417i(str2, str3, objArr);
        blb();
        switch (c1207m.getType()) {
            case 411:
                if (c1207m instanceof C20375n) {
                    C20375n c20375n = (C20375n) c1207m;
                    if (c20375n == null || c20375n.mType != bkV()) {
                        str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
                        str3 = "no some scene type. this ui type:%d callbak type:%d";
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(bkV());
                        if (c20375n != null) {
                            i3 = c20375n.mType;
                        }
                        objArr[1] = Integer.valueOf(i3);
                        C4990ab.m7417i(str2, str3, objArr);
                        return;
                    }
                    this.hZu = false;
                    this.kYd.setVisibility(8);
                    C20383f c20383f = null;
                    try {
                        c20383f = C20375n.m31536a(c20375n.bkB());
                    } catch (Exception e) {
                        C4990ab.m7409c("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", e.toString());
                    }
                    if (c20383f != null) {
                        if (i == 0 || i == 4) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            this.f3573Ek.setVisibility(8);
                            this.kYb = false;
                            this.kYe = c20375n.kWS;
                            GetEmotionListResponse bkB;
                            if (i2 == 0) {
                                bkB = c20375n.bkB();
                                mo30706a(c20383f, false, true);
                                m25769b(bkB);
                                this.kYc = 0;
                                return;
                            } else if (i2 == 2) {
                                bkB = c20375n.bkB();
                                m25766a(this.kYc, c20383f, false, false);
                                bkU();
                                m25769b(bkB);
                                this.kYc = 2;
                                return;
                            } else if (i2 == 3) {
                                m25766a(this.kYc, c20383f, false, false);
                                this.kYc = 1;
                                return;
                            } else {
                                this.f3573Ek.setVisibility(0);
                                this.kYb = true;
                                if (bkV() == 7) {
                                    this.kYa.setText(C25738R.string.bc6);
                                    return;
                                } else {
                                    this.kYa.setText(C25738R.string.bat);
                                    return;
                                }
                            }
                        }
                    }
                    if (!this.kYv) {
                        this.f3573Ek.setVisibility(0);
                        this.kYb = true;
                        this.kYa.setText(C25738R.string.bau);
                        return;
                    }
                    return;
                }
                return;
            case 413:
                C42949q c42949q = (C42949q) c1207m;
                Message message;
                if (i == 0 && i2 == 0) {
                    C42952j.getEmojiStorageMgr().xYo.aqd(c42949q.kWz);
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.mController.ylL.getString(C25738R.string.f9242u3);
                    mo45579n(message);
                } else {
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.mController.ylL.getString(C25738R.string.b_1);
                    mo45579n(message);
                }
                mo45578dS(CdnLogic.kMediaTypeBackupFile, 800);
                return;
            case v2helper.EMethodSetNgStrength /*423*/:
                if (c1207m instanceof C42945g) {
                    C42945g c42945g = (C42945g) c1207m;
                    if (i == 0 && i2 == 0) {
                        mo30705a(c42945g);
                        return;
                    }
                    str2 = c42945g.kWz;
                    str3 = c42945g.kWB;
                    final String str4 = c42945g.kWA;
                    C30379h.m48440a((Context) this, getString(C25738R.string.baj, new Object[]{str4}), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(53213);
                            BaseEmojiStoreUI.this.mo30730j(str2, str3, str4, null);
                            BaseEmojiStoreUI.this.bkZ();
                            C4990ab.m7417i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", str2);
                            BaseEmojiStoreUI.this.m25771bX(str2, 0);
                            AppMethodBeat.m2505o(53213);
                        }
                    }, new C167372());
                    m25770bW(c42945g.kWz, -1);
                    return;
                }
                return;
            case 717:
                if (i == 0 && i2 == 0) {
                    this.kYe = null;
                    mo30736z(false, true);
                    return;
                }
                return;
            default:
                C4990ab.m7412e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (bkS() || bkT()) {
            if (i != 0) {
                i--;
            } else {
                return;
            }
        }
        if (i >= 0 && i < this.kVA.getCount()) {
            C11546f tX = this.kVA.getItem(i);
            if (tX == null) {
                C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
            } else if (tX.kTa == C11547a.cellset) {
                EmotionBannerSet emotionBannerSet = tX.kTc;
                if (emotionBannerSet == null) {
                    C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
                } else {
                    C11553m.m19374a(this.mController.ylL, emotionBannerSet, false);
                }
            } else {
                EmotionSummary emotionSummary = tX.kTb;
                if (emotionSummary == null) {
                    C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
                    return;
                }
                C11553m.m19375a(this.mController.ylL, emotionSummary, bkM(), tX.mStatus, tX.f2905EV, getIntent().getStringExtra("to_talker_name"), bkN());
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void bkL() {
        this.kVA = bkO();
        this.kVA.kSQ = this;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: JI */
    public void mo30704JI(String str) {
    }

    /* Access modifiers changed, original: protected */
    public void bkP() {
    }

    /* Access modifiers changed, original: protected */
    public void bkQ() {
        if (bkR()) {
            this.kXZ = (MMPullDownView) findViewById(2131823536);
            if (this.kXZ != null) {
                this.kXZ.setTopViewVisible(false);
                this.kXZ.setAtTopCallBack(this);
                this.kXZ.setOnBottomLoadDataListener(this);
                this.kXZ.setAtBottomCallBack(this);
                this.kXZ.setBottomViewVisible(false);
                this.kXZ.setIsBottomShowAll(false);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean bkR() {
        return true;
    }

    public void initView() {
        setBackBtn(new C11564b(this, (byte) 0));
        bkL();
        this.f3573Ek = findViewById(2131821749);
        this.kYa = (TextView) this.f3573Ek.findViewById(2131823528);
        this.kYd = getLayoutInflater().inflate(2130969354, null);
        this.kYd.setVisibility(8);
        if (bkS()) {
            this.kXW = new EmojiStoreVpHeader(this.mController.ylL);
        }
        if (bkT()) {
            this.kXX = LayoutInflater.from(this).inflate(2130969387, null);
            int i = EmojiStoreVpHeader.m44112db(this.mController.ylL)[0];
            this.kXX.setLayoutParams(new LayoutParams(i, ((i * 3) / 8) + 1));
            this.kXY = (StoreBannerEmojiView) this.kXX.findViewById(2131823548);
        }
        this.mListView = (ListView) findViewById(16908298);
        this.mListView.setOnItemClickListener(this);
        if (bkS()) {
            this.mListView.addHeaderView(this.kXW);
        } else if (bkT()) {
            this.mListView.addHeaderView(this.kXX);
        }
        if (bld()) {
            this.mListView.addFooterView(this.kYd);
        }
        bkP();
        this.mListView.setAdapter(this.kVA);
        this.mListView.setOnScrollListener(this);
        this.kVA.kSO = this.mListView;
        bkQ();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: z */
    public final void mo30736z(boolean z, boolean z2) {
        this.hZu = true;
        if (z) {
            this.kYd.setVisibility(0);
        }
        m25768aG(this.kYe);
        bkX();
        C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z && !z2) {
            aoW();
        }
    }

    public final boolean bhk() {
        mo30736z(true, false);
        C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
        return true;
    }

    /* renamed from: l */
    public final void mo30731l(Message message) {
        switch (message.what) {
            case 2002:
                String str = (String) message.obj;
                if (isFinishing()) {
                    C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
                    return;
                } else if (this.gqo != null) {
                    this.gqo.setMessage(str);
                    return;
                } else {
                    return;
                }
            case CdnLogic.kMediaTypeBackupFile /*20001*/:
                blb();
                return;
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY /*65537*/:
                mo30728c((GetEmotionListResponse) message.obj);
                return;
            default:
                return;
        }
    }

    /* renamed from: m */
    public void mo30732m(Message message) {
        String string;
        switch (message.what) {
            case 131074:
                if (this.kVA != null) {
                    this.kVA.notifyDataSetChanged();
                    ble();
                    return;
                }
                return;
            case 131075:
                if (this.kVA != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.kVA.mo54492bX(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (this.kVA != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.kVA.mo54491bW(string, message.getData().getInt("status"));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean bkS() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean bkT() {
        return false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.kYc == 0 || this.hZu) {
            C4990ab.m7410d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
            return;
        }
        mo30736z(true, false);
        C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    private void bkU() {
        C33945b.m55558a(this.kVA.kSP, (C14889a) this);
    }

    /* renamed from: bX */
    private void m25771bX(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        mo45579n(obtain);
    }

    /* renamed from: bW */
    private void m25770bW(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i);
        obtain.what = 131076;
        mo45579n(obtain);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: j */
    public final C42945g mo30730j(String str, String str2, String str3, String str4) {
        this.kYu = new C42945g(str, str2, str3, str4);
        return this.kYu;
    }

    /* renamed from: aG */
    private C20375n m25768aG(byte[] bArr) {
        C20375n c20375n;
        int bkV = bkV();
        int aH = mo30708aH(bArr);
        int bkW = bkW();
        if (bArr != null) {
            C4990ab.m7417i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", bArr.toString());
            c20375n = new C20375n(bkV, bArr, aH);
            if (bkV == 7) {
                c20375n.kWU = bkW;
            }
        } else {
            C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
            c20375n = new C20375n(bkV, aH);
            if (bkV == 7) {
                c20375n.kWU = bkW;
            }
        }
        this.kYo = c20375n;
        return c20375n;
    }

    public int bkW() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: aH */
    public int mo30708aH(byte[] bArr) {
        return this.kYp;
    }

    private void bkX() {
        C1720g.m3535RO().eJo.mo14541a(this.kYo, 0);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkY() {
        C1720g.m3535RO().eJo.mo14547c(this.kYo);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkZ() {
        C1720g.m3535RO().eJo.mo14541a(this.kYu, 0);
    }

    /* Access modifiers changed, original: protected */
    public boolean bla() {
        GetEmotionListResponse ME = C42952j.getEmojiStorageMgr().xYq.mo64085ME(bkV());
        C20383f a = C20375n.m31536a(ME);
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "load cache type: %d, size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bkV());
        objArr[1] = Integer.valueOf(ME == null ? 0 : ME.EmotionCount);
        C4990ab.m7411d(str, str2, objArr);
        if (a == null) {
            return false;
        }
        boolean z;
        if (a.kVq.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            C4990ab.m7411d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", Integer.valueOf(a.kVq.size()));
            mo30706a(a, true, false);
            return z;
        }
        C4990ab.m7410d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aoW() {
        if (isFinishing()) {
            C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C167383());
    }

    /* Access modifiers changed, original: protected|final */
    public final void blb() {
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo30706a(C20383f c20383f, boolean z, boolean z2) {
        C4990ab.m7410d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
        if (c20383f != null && c20383f.kVq.size() > 0) {
            this.kYv = true;
            this.f3573Ek.setVisibility(8);
            this.kYb = false;
        }
        m25766a(this.kYc, c20383f, z, z2);
        bkU();
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0011  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m25766a(int i, C20383f c20383f, boolean z, boolean z2) {
        boolean z3 = false;
        C4990ab.m7410d("MicroMsg.emoji.BaseEmojiStoreUI", "");
        switch (i) {
            case -1:
                this.kYq = c20383f;
                break;
            case 1:
                this.kYq = c20383f;
                break;
            case 2:
                if (this.kYq == null) {
                    this.kYq = new C20383f();
                }
                if (c20383f != null) {
                    this.kYq.mo35681ue(c20383f.kVp);
                    this.kYq.mo35680br(c20383f.kVq);
                    break;
                }
                break;
            default:
                if (this.kYq != null) {
                    this.kYq.bke();
                }
                mo30707a(z3, this.kYq, z, z2);
        }
        z3 = true;
        if (this.kYq != null) {
        }
        mo30707a(z3, this.kYq, z, z2);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo30707a(boolean z, C20383f c20383f, boolean z2, boolean z3) {
        if (this.kYq != null && z) {
            if (bkS()) {
                if (this.kYq == null || this.kYq.kVr == null || this.kYq.kVr.BannerSummary == null) {
                    C4990ab.m7410d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
                } else {
                    this.kYw = (LinkedList) this.kYq.kVs;
                    this.kYx = (LinkedList) this.kYq.kVt;
                    if (this.kYw != null) {
                        this.kXW.mo45597d(this.kYw, this.kYx);
                    } else if (this.kYq.kVr != null) {
                        this.kYw = new LinkedList();
                        this.kYw.add(this.kYq.kVr);
                        this.kXW.mo45597d(this.kYw, this.kYx);
                    }
                }
            }
            if (this.kVA != null) {
                this.kVA.mo54490b(this.kYq);
            }
        }
    }

    /* renamed from: b */
    private void m25769b(GetEmotionListResponse getEmotionListResponse) {
        if (this.kYc == -1) {
            Message obtain = Message.obtain();
            obtain.what = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY;
            obtain.obj = getEmotionListResponse;
            mo45580o(obtain);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public void mo30728c(GetEmotionListResponse getEmotionListResponse) {
        int i = 0;
        if (getEmotionListResponse != null) {
            String str = "MicroMsg.emoji.BaseEmojiStoreUI";
            String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(getEmotionListResponse == null ? 0 : getEmotionListResponse.EmotionCount);
            if (!(getEmotionListResponse == null || getEmotionListResponse.ReqBuf == null)) {
                i = getEmotionListResponse.ReqBuf.computeSize();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(bkV());
            C4990ab.m7411d(str, str2, objArr);
            C42952j.getEmojiStorageMgr().xYq.mo64086a(bkV(), getEmotionListResponse);
        }
    }

    public final boolean bhl() {
        return false;
    }

    public final boolean bhm() {
        return false;
    }

    /* renamed from: a */
    public void mo5248a(String str, C4935m c4935m) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group")) {
            blo();
            mo45578dS(131074, 50);
        }
    }

    /* renamed from: h */
    public void mo30729h(String str, int i, int i2, String str2) {
        C4990ab.m7411d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        if (this.kVA != null) {
            C45842c c45842c = this.kVA.kSP;
            if (c45842c != null) {
                if (i == 6) {
                    m25771bX(str, i2);
                } else {
                    C4990ab.m7417i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", Integer.valueOf(i));
                    m25770bW(str, i);
                }
                C11546f IT = c45842c.mo73635IT(str);
                if (IT != null) {
                    IT.kTe = str2;
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo23265a(C45843a c45843a) {
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = c45843a.getProductId();
        objArr[1] = TextUtils.isEmpty(c45843a.bjo()) ? "" : c45843a.bjo();
        objArr[2] = Integer.valueOf(c45843a.bjn());
        C4990ab.m7417i(str, str2, objArr);
        if (c45843a.bjn() == 9) {
            String string = getString(C25738R.string.f9245u6);
            if (isFinishing()) {
                C4990ab.m7416i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            } else {
                getString(C25738R.string.f9238tz);
                this.gqo = C30379h.m48458b((Context) this, string, true, new C167364());
            }
        }
        this.kYr.mo68470a(c45843a);
    }

    /* Access modifiers changed, original: protected */
    public boolean blc() {
        return false;
    }

    /* renamed from: A */
    public final void mo24138A(ArrayList<C44064n> arrayList) {
        C4990ab.m7410d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
        if (this.kVA != null) {
            C33945b.m55559a((ArrayList) arrayList, this.kVA.kSP);
            if (this.kZl != null) {
                this.kZl.removeMessages(131074);
                this.kZl.sendEmptyMessage(131074);
            }
        }
    }

    /* renamed from: i */
    public final void mo23318i(String str, String str2, String str3, String str4) {
        mo30730j(str, str2, str3, str4);
        bkZ();
    }

    public final void bkf() {
        this.kYe = null;
        this.kYc = -1;
        mo30736z(false, false);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C4990ab.m7410d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        this.kYr.onActivityResult(i, i2, intent);
    }

    /* Access modifiers changed, original: protected */
    public boolean bld() {
        return true;
    }

    public void ble() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo30705a(C42945g c42945g) {
        m25771bX(c42945g.kWz, 0);
    }
}
