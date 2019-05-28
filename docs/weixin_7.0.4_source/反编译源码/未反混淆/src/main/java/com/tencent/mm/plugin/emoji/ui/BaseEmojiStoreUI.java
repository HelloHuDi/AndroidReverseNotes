package com.tencent.mm.plugin.emoji.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.da;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.h;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class BaseEmojiStoreUI extends EmojiBaseActivity implements OnScrollListener, OnItemClickListener, f, com.tencent.mm.plugin.emoji.model.i.a, com.tencent.mm.plugin.emoji.model.i.b, com.tencent.mm.pluginsdk.model.h.a, com.tencent.mm.sdk.e.k.a, c, d, e {
    private static Map<String, Long> kYs;
    protected View Ek;
    private ProgressDialog gqo;
    private boolean hZu;
    com.tencent.mm.plugin.emoji.a.a.a kVA;
    private com.tencent.mm.plugin.emoji.h.c kVI;
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
    private n kYo;
    private int kYp;
    private com.tencent.mm.plugin.emoji.model.f kYq;
    private i kYr;
    private com.tencent.mm.sdk.b.c kYt;
    protected g kYu;
    protected boolean kYv = false;
    private LinkedList<EmotionBanner> kYw = new LinkedList();
    private LinkedList<EmotionBannerSet> kYx = new LinkedList();
    protected ListView mListView;

    class a extends com.tencent.mm.sdk.b.c<da> {
        private a() {
            AppMethodBeat.i(53216);
            this.xxI = da.class.getName().hashCode();
            AppMethodBeat.o(53216);
        }

        /* synthetic */ a(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
            this();
            AppMethodBeat.i(53218);
            this.xxI = da.class.getName().hashCode();
            AppMethodBeat.o(53218);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(53217);
            da daVar = (da) bVar;
            BaseEmojiStoreUI.this.h(daVar.cwf.cwg, daVar.cwf.status, daVar.cwf.progress, daVar.cwf.cwh);
            AppMethodBeat.o(53217);
            return false;
        }
    }

    class b implements OnMenuItemClickListener {
        private b() {
        }

        /* synthetic */ b(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
            this();
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(53219);
            BaseEmojiStoreUI.this.finish();
            AppMethodBeat.o(53219);
            return true;
        }
    }

    public abstract int bkM();

    public abstract int bkN();

    public abstract com.tencent.mm.plugin.emoji.a.a.a bkO();

    public abstract int bkV();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kYr = new i();
        initView();
        this.kYp = getIntent().getIntExtra("preceding_scence", 2);
        if (j.getEmojiStorageMgr().xYo != null) {
            j.getEmojiStorageMgr().xYo.c(this);
        }
        this.kYt = new a(this, (byte) 0);
        com.tencent.mm.sdk.b.a.xxA.c(this.kYt);
        this.kYr.jiq = this;
        this.kYr.kVA = this.kVA;
        this.kYr.kVD = bkM();
        this.kYr.kVG = this;
        boolean blc = blc();
        if (blc) {
            blc = bla();
        }
        z(false, blc);
        if (kYs == null) {
            kYs = new HashMap();
        }
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", Long.valueOf(System.currentTimeMillis()));
        kYs.put(getClass().toString(), Long.valueOf(r0));
        this.kVI = new com.tencent.mm.plugin.emoji.h.c(1005);
    }

    public void onResume() {
        super.onResume();
        com.tencent.mm.kernel.g.RO().eJo.a(411, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a((int) v2helper.EMethodSetNgStrength, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a(413, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a(717, (f) this);
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
        com.tencent.mm.kernel.g.RO().eJo.b(411, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b((int) v2helper.EMethodSetNgStrength, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b(413, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b(717, (f) this);
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
        j.getEmojiStorageMgr().xYo.d(this);
        com.tencent.mm.sdk.b.a.xxA.d(this.kYt);
        com.tencent.mm.kernel.g.RO().eJo.c(this.kYu);
        if (this.kYr != null) {
            i iVar = this.kYr;
            iVar.kVA = null;
            iVar.kVG = null;
            iVar.jiq = null;
        }
    }

    public int getLayoutId() {
        return R.layout.ua;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
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
        ab.i(str2, str3, objArr);
        blb();
        switch (mVar.getType()) {
            case 411:
                if (mVar instanceof n) {
                    n nVar = (n) mVar;
                    if (nVar == null || nVar.mType != bkV()) {
                        str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
                        str3 = "no some scene type. this ui type:%d callbak type:%d";
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(bkV());
                        if (nVar != null) {
                            i3 = nVar.mType;
                        }
                        objArr[1] = Integer.valueOf(i3);
                        ab.i(str2, str3, objArr);
                        return;
                    }
                    this.hZu = false;
                    this.kYd.setVisibility(8);
                    com.tencent.mm.plugin.emoji.model.f fVar = null;
                    try {
                        fVar = n.a(nVar.bkB());
                    } catch (Exception e) {
                        ab.c("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", e.toString());
                    }
                    if (fVar != null) {
                        if (i == 0 || i == 4) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            this.Ek.setVisibility(8);
                            this.kYb = false;
                            this.kYe = nVar.kWS;
                            GetEmotionListResponse bkB;
                            if (i2 == 0) {
                                bkB = nVar.bkB();
                                a(fVar, false, true);
                                b(bkB);
                                this.kYc = 0;
                                return;
                            } else if (i2 == 2) {
                                bkB = nVar.bkB();
                                a(this.kYc, fVar, false, false);
                                bkU();
                                b(bkB);
                                this.kYc = 2;
                                return;
                            } else if (i2 == 3) {
                                a(this.kYc, fVar, false, false);
                                this.kYc = 1;
                                return;
                            } else {
                                this.Ek.setVisibility(0);
                                this.kYb = true;
                                if (bkV() == 7) {
                                    this.kYa.setText(R.string.bc6);
                                    return;
                                } else {
                                    this.kYa.setText(R.string.bat);
                                    return;
                                }
                            }
                        }
                    }
                    if (!this.kYv) {
                        this.Ek.setVisibility(0);
                        this.kYb = true;
                        this.kYa.setText(R.string.bau);
                        return;
                    }
                    return;
                }
                return;
            case 413:
                q qVar = (q) mVar;
                Message message;
                if (i == 0 && i2 == 0) {
                    j.getEmojiStorageMgr().xYo.aqd(qVar.kWz);
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.mController.ylL.getString(R.string.u3);
                    n(message);
                } else {
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.mController.ylL.getString(R.string.b_1);
                    n(message);
                }
                dS(CdnLogic.kMediaTypeBackupFile, 800);
                return;
            case v2helper.EMethodSetNgStrength /*423*/:
                if (mVar instanceof g) {
                    g gVar = (g) mVar;
                    if (i == 0 && i2 == 0) {
                        a(gVar);
                        return;
                    }
                    str2 = gVar.kWz;
                    str3 = gVar.kWB;
                    final String str4 = gVar.kWA;
                    h.a((Context) this, getString(R.string.baj, new Object[]{str4}), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(53213);
                            BaseEmojiStoreUI.this.j(str2, str3, str4, null);
                            BaseEmojiStoreUI.this.bkZ();
                            ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", str2);
                            BaseEmojiStoreUI.this.bX(str2, 0);
                            AppMethodBeat.o(53213);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    bW(gVar.kWz, -1);
                    return;
                }
                return;
            case 717:
                if (i == 0 && i2 == 0) {
                    this.kYe = null;
                    z(false, true);
                    return;
                }
                return;
            default:
                ab.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
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
            com.tencent.mm.plugin.emoji.a.a.f tX = this.kVA.getItem(i);
            if (tX == null) {
                ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
            } else if (tX.kTa == com.tencent.mm.plugin.emoji.a.a.f.a.cellset) {
                EmotionBannerSet emotionBannerSet = tX.kTc;
                if (emotionBannerSet == null) {
                    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
                } else {
                    com.tencent.mm.plugin.emoji.e.m.a(this.mController.ylL, emotionBannerSet, false);
                }
            } else {
                EmotionSummary emotionSummary = tX.kTb;
                if (emotionSummary == null) {
                    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
                    return;
                }
                com.tencent.mm.plugin.emoji.e.m.a(this.mController.ylL, emotionSummary, bkM(), tX.mStatus, tX.EV, getIntent().getStringExtra("to_talker_name"), bkN());
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void bkL() {
        this.kVA = bkO();
        this.kVA.kSQ = this;
    }

    /* Access modifiers changed, original: protected */
    public void JI(String str) {
    }

    /* Access modifiers changed, original: protected */
    public void bkP() {
    }

    /* Access modifiers changed, original: protected */
    public void bkQ() {
        if (bkR()) {
            this.kXZ = (MMPullDownView) findViewById(R.id.bfv);
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
        setBackBtn(new b(this, (byte) 0));
        bkL();
        this.Ek = findViewById(R.id.a5j);
        this.kYa = (TextView) this.Ek.findViewById(R.id.bfn);
        this.kYd = getLayoutInflater().inflate(R.layout.u_, null);
        this.kYd.setVisibility(8);
        if (bkS()) {
            this.kXW = new EmojiStoreVpHeader(this.mController.ylL);
        }
        if (bkT()) {
            this.kXX = LayoutInflater.from(this).inflate(R.layout.v6, null);
            int i = EmojiStoreVpHeader.db(this.mController.ylL)[0];
            this.kXX.setLayoutParams(new LayoutParams(i, ((i * 3) / 8) + 1));
            this.kXY = (StoreBannerEmojiView) this.kXX.findViewById(R.id.bg7);
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
    public final void z(boolean z, boolean z2) {
        this.hZu = true;
        if (z) {
            this.kYd.setVisibility(0);
        }
        aG(this.kYe);
        bkX();
        ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z && !z2) {
            aoW();
        }
    }

    public final boolean bhk() {
        z(true, false);
        ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
        return true;
    }

    public final void l(Message message) {
        switch (message.what) {
            case 2002:
                String str = (String) message.obj;
                if (isFinishing()) {
                    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
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
                c((GetEmotionListResponse) message.obj);
                return;
            default:
                return;
        }
    }

    public void m(Message message) {
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
                        this.kVA.bX(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (this.kVA != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.kVA.bW(string, message.getData().getInt("status"));
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
            ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
            return;
        }
        z(true, false);
        ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    private void bkU() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.kVA.kSP, (com.tencent.mm.pluginsdk.model.h.a) this);
    }

    private void bX(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        n(obtain);
    }

    private void bW(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i);
        obtain.what = 131076;
        n(obtain);
    }

    /* Access modifiers changed, original: protected|final */
    public final g j(String str, String str2, String str3, String str4) {
        this.kYu = new g(str, str2, str3, str4);
        return this.kYu;
    }

    private n aG(byte[] bArr) {
        n nVar;
        int bkV = bkV();
        int aH = aH(bArr);
        int bkW = bkW();
        if (bArr != null) {
            ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", bArr.toString());
            nVar = new n(bkV, bArr, aH);
            if (bkV == 7) {
                nVar.kWU = bkW;
            }
        } else {
            ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
            nVar = new n(bkV, aH);
            if (bkV == 7) {
                nVar.kWU = bkW;
            }
        }
        this.kYo = nVar;
        return nVar;
    }

    public int bkW() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public int aH(byte[] bArr) {
        return this.kYp;
    }

    private void bkX() {
        com.tencent.mm.kernel.g.RO().eJo.a(this.kYo, 0);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkY() {
        com.tencent.mm.kernel.g.RO().eJo.c(this.kYo);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkZ() {
        com.tencent.mm.kernel.g.RO().eJo.a(this.kYu, 0);
    }

    /* Access modifiers changed, original: protected */
    public boolean bla() {
        GetEmotionListResponse ME = j.getEmojiStorageMgr().xYq.ME(bkV());
        com.tencent.mm.plugin.emoji.model.f a = n.a(ME);
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "load cache type: %d, size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bkV());
        objArr[1] = Integer.valueOf(ME == null ? 0 : ME.EmotionCount);
        ab.d(str, str2, objArr);
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
            ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", Integer.valueOf(a.kVq.size()));
            a(a, true, false);
            return z;
        }
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aoW() {
        if (isFinishing()) {
            ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.string.tz);
        this.gqo = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(53214);
                BaseEmojiStoreUI.this.bkY();
                com.tencent.mm.kernel.g.RO().eJo.cancel(413);
                AppMethodBeat.o(53214);
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void blb() {
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(com.tencent.mm.plugin.emoji.model.f fVar, boolean z, boolean z2) {
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
        if (fVar != null && fVar.kVq.size() > 0) {
            this.kYv = true;
            this.Ek.setVisibility(8);
            this.kYb = false;
        }
        a(this.kYc, fVar, z, z2);
        bkU();
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0011  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i, com.tencent.mm.plugin.emoji.model.f fVar, boolean z, boolean z2) {
        boolean z3 = false;
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
        switch (i) {
            case -1:
                this.kYq = fVar;
                break;
            case 1:
                this.kYq = fVar;
                break;
            case 2:
                if (this.kYq == null) {
                    this.kYq = new com.tencent.mm.plugin.emoji.model.f();
                }
                if (fVar != null) {
                    this.kYq.ue(fVar.kVp);
                    this.kYq.br(fVar.kVq);
                    break;
                }
                break;
            default:
                if (this.kYq != null) {
                    this.kYq.bke();
                }
                a(z3, this.kYq, z, z2);
        }
        z3 = true;
        if (this.kYq != null) {
        }
        a(z3, this.kYq, z, z2);
    }

    /* Access modifiers changed, original: protected */
    public void a(boolean z, com.tencent.mm.plugin.emoji.model.f fVar, boolean z2, boolean z3) {
        if (this.kYq != null && z) {
            if (bkS()) {
                if (this.kYq == null || this.kYq.kVr == null || this.kYq.kVr.BannerSummary == null) {
                    ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
                } else {
                    this.kYw = (LinkedList) this.kYq.kVs;
                    this.kYx = (LinkedList) this.kYq.kVt;
                    if (this.kYw != null) {
                        this.kXW.d(this.kYw, this.kYx);
                    } else if (this.kYq.kVr != null) {
                        this.kYw = new LinkedList();
                        this.kYw.add(this.kYq.kVr);
                        this.kXW.d(this.kYw, this.kYx);
                    }
                }
            }
            if (this.kVA != null) {
                this.kVA.b(this.kYq);
            }
        }
    }

    private void b(GetEmotionListResponse getEmotionListResponse) {
        if (this.kYc == -1) {
            Message obtain = Message.obtain();
            obtain.what = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY;
            obtain.obj = getEmotionListResponse;
            o(obtain);
        }
    }

    /* Access modifiers changed, original: protected */
    public void c(GetEmotionListResponse getEmotionListResponse) {
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
            ab.d(str, str2, objArr);
            j.getEmojiStorageMgr().xYq.a(bkV(), getEmotionListResponse);
        }
    }

    public final boolean bhl() {
        return false;
    }

    public final boolean bhm() {
        return false;
    }

    public void a(String str, com.tencent.mm.sdk.e.m mVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group")) {
            blo();
            dS(131074, 50);
        }
    }

    public void h(String str, int i, int i2, String str2) {
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        if (this.kVA != null) {
            com.tencent.mm.plugin.emoji.a.a.c cVar = this.kVA.kSP;
            if (cVar != null) {
                if (i == 6) {
                    bX(str, i2);
                } else {
                    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", Integer.valueOf(i));
                    bW(str, i);
                }
                com.tencent.mm.plugin.emoji.a.a.f IT = cVar.IT(str);
                if (IT != null) {
                    IT.kTe = str2;
                }
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.bjo()) ? "" : aVar.bjo();
        objArr[2] = Integer.valueOf(aVar.bjn());
        ab.i(str, str2, objArr);
        if (aVar.bjn() == 9) {
            String string = getString(R.string.u6);
            if (isFinishing()) {
                ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            } else {
                getString(R.string.tz);
                this.gqo = h.b((Context) this, string, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(53215);
                        com.tencent.mm.kernel.g.RO().eJo.cancel(413);
                        AppMethodBeat.o(53215);
                    }
                });
            }
        }
        this.kYr.a(aVar);
    }

    /* Access modifiers changed, original: protected */
    public boolean blc() {
        return false;
    }

    public final void A(ArrayList<com.tencent.mm.pluginsdk.model.n> arrayList) {
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
        if (this.kVA != null) {
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.kVA.kSP);
            if (this.kZl != null) {
                this.kZl.removeMessages(131074);
                this.kZl.sendEmptyMessage(131074);
            }
        }
    }

    public final void i(String str, String str2, String str3, String str4) {
        j(str, str2, str3, str4);
        bkZ();
    }

    public final void bkf() {
        this.kYe = null;
        this.kYc = -1;
        z(false, false);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ab.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
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
    public void a(g gVar) {
        bX(gVar.kWz, 0);
    }
}
