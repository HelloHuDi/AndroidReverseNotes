package com.tencent.mm.plugin.emoji.ui.v2;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.da;
import com.tencent.mm.model.ao;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.i.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.v;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.view.d;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;

public class EmojiStoreV2DesignerUI extends MMActivity implements OnScrollListener, OnItemClickListener, f, a, b, c, e {
    private View abB;
    private int gOW;
    private boolean hZu;
    private long kVE;
    private String kVF;
    private String kVJ;
    private String kWM;
    com.tencent.mm.plugin.emoji.a.f kYB;
    private int kYc = -1;
    private byte[] kYe;
    protected final int kYi = 131074;
    private final int kYj = 131075;
    private final int kYk = 131076;
    private final String kYl = "product_id";
    private final String kYm = "progress";
    private final String kYn = "status";
    private com.tencent.mm.plugin.emoji.model.f kYq;
    private i kYr;
    private com.tencent.mm.sdk.b.c kYt = new com.tencent.mm.sdk.b.c<da>() {
        {
            AppMethodBeat.i(53579);
            this.xxI = da.class.getName().hashCode();
            AppMethodBeat.o(53579);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(53580);
            da daVar = (da) bVar;
            EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = EmojiStoreV2DesignerUI.this;
            String str = daVar.cwf.cwg;
            int i = daVar.cwf.status;
            int i2 = daVar.cwf.progress;
            ab.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), daVar.cwf.cwh);
            if (i == 6) {
                emojiStoreV2DesignerUI.bX(str, i2);
            } else {
                ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "product status:%d", Integer.valueOf(i));
                emojiStoreV2DesignerUI.bW(str, i);
            }
            if (emojiStoreV2DesignerUI.kYB != null) {
                com.tencent.mm.plugin.emoji.a.a.c cVar = emojiStoreV2DesignerUI.kYB.kSP;
                if (cVar != null) {
                    com.tencent.mm.plugin.emoji.a.a.f IT = cVar.IT(str);
                    if (IT != null) {
                        IT.kTe = r4;
                    }
                }
            }
            AppMethodBeat.o(53580);
            return false;
        }
    };
    private g kYu;
    TextView ldA;
    View ldB;
    private MMPullDownView ldC;
    private aml ldD;
    private com.tencent.mm.plugin.emoji.f.i ldE;
    private p ldF;
    private ao.b.a ldG = new ao.b.a() {
        public final void o(String str, boolean z) {
            AppMethodBeat.i(53586);
            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", str, Boolean.valueOf(z));
            if (z) {
                EmojiStoreV2DesignerUI.this.ldh = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str);
                EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this);
            }
            AppMethodBeat.o(53586);
        }
    };
    private final int ldH = 10001;
    private final int ldI = 10002;
    private final int ldJ = 10003;
    private com.tencent.mm.plugin.emoji.f.p ldK;
    private int lde;
    private String ldf;
    private String ldg;
    private ad ldh;
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
    private List<xx> ldt = new ArrayList();
    private View ldu;
    PreViewListGridView ldv;
    private a ldw;
    View ldx;
    View ldy;
    View ldz;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53587);
            String string;
            switch (message.what) {
                case 10001:
                    EmojiStoreV2DesignerUI.this.gv(false);
                    AppMethodBeat.o(53587);
                    return;
                case 10002:
                    EmojiStoreV2DesignerUI.c(EmojiStoreV2DesignerUI.this);
                    AppMethodBeat.o(53587);
                    return;
                case 10003:
                    EmojiStoreV2DesignerUI.b(EmojiStoreV2DesignerUI.this);
                    AppMethodBeat.o(53587);
                    return;
                case 131075:
                    if (EmojiStoreV2DesignerUI.this.kYB == null || message.getData() == null) {
                        AppMethodBeat.o(53587);
                        return;
                    }
                    string = message.getData().getString("product_id");
                    if (string == null) {
                        AppMethodBeat.o(53587);
                        return;
                    }
                    EmojiStoreV2DesignerUI.this.kYB.bX(string, message.getData().getInt("progress"));
                    AppMethodBeat.o(53587);
                    return;
                case 131076:
                    if (EmojiStoreV2DesignerUI.this.kYB != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            EmojiStoreV2DesignerUI.this.kYB.bW(string, message.getData().getInt("status"));
                            break;
                        }
                        AppMethodBeat.o(53587);
                        return;
                    }
                    AppMethodBeat.o(53587);
                    return;
            }
            AppMethodBeat.o(53587);
        }
    };
    private ListView mListView;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2DesignerUI() {
        AppMethodBeat.i(53594);
        AppMethodBeat.o(53594);
    }

    static /* synthetic */ void b(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.i(53620);
        emojiStoreV2DesignerUI.Kh();
        AppMethodBeat.o(53620);
    }

    public final int getLayoutId() {
        return R.layout.uh;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.i(53595);
        super.onCreate(bundle);
        this.kWM = getIntent().getStringExtra("id");
        this.lde = getIntent().getIntExtra(OpenSDKTool4Assistant.EXTRA_UIN, 0);
        this.kVJ = getIntent().getStringExtra("name");
        this.ldf = getIntent().getStringExtra("headurl");
        this.ldg = getIntent().getStringExtra("rediret_url");
        this.gOW = getIntent().getIntExtra("extra_scence", 0);
        this.kVE = getIntent().getLongExtra("searchID", 0);
        this.kVF = bo.bc(getIntent().getStringExtra("docID"), "");
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lde = EmojiLogic.Jm(stringExtra);
            this.kVJ = EmojiLogic.Jn(stringExtra);
            this.ldg = EmojiLogic.Ju(stringExtra);
        }
        initView();
        if (!bo.isNullOrNil(this.kWM)) {
            aic aqn = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYt.aqn(this.kWM);
            if (aqn == null || aqn.woq == null || aqn.woq.DesignerUin == 0 || bo.isNullOrNil(aqn.woq.Name)) {
                i = 1;
                if (i != 0) {
                    Kh();
                } else {
                    this.ldE = new com.tencent.mm.plugin.emoji.f.i(this.kWM);
                    com.tencent.mm.kernel.g.RO().eJo.a(this.ldE, 0);
                    getString(R.string.tz);
                    this.ldF = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(53585);
                            if (EmojiStoreV2DesignerUI.this.ldE != null) {
                                com.tencent.mm.kernel.g.RO().eJo.c(EmojiStoreV2DesignerUI.this.ldE);
                            }
                            AppMethodBeat.o(53585);
                        }
                    });
                }
                com.tencent.mm.kernel.g.RO().eJo.a((int) d.MIC_PTU_SHISHANG2, (f) this);
                com.tencent.mm.kernel.g.RO().eJo.a(720, (f) this);
                com.tencent.mm.sdk.b.a.xxA.c(this.kYt);
                com.tencent.mm.plugin.report.service.h.pYm.e(12067, Integer.valueOf(1), "", "", "", "");
                com.tencent.mm.plugin.report.service.h.pYm.e(12740, Integer.valueOf(2), com.tencent.mm.a.p.getString(this.lde), "", "", Integer.valueOf(this.gOW), Integer.valueOf(6));
                AppMethodBeat.o(53595);
            }
            this.lde = aqn.woq.DesignerUin;
            this.kVJ = aqn.woq.Name;
            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", Integer.valueOf(this.lde), this.kVJ);
        }
        i = 0;
        if (i != 0) {
        }
        com.tencent.mm.kernel.g.RO().eJo.a((int) d.MIC_PTU_SHISHANG2, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a(720, (f) this);
        com.tencent.mm.sdk.b.a.xxA.c(this.kYt);
        com.tencent.mm.plugin.report.service.h.pYm.e(12067, Integer.valueOf(1), "", "", "", "");
        com.tencent.mm.plugin.report.service.h.pYm.e(12740, Integer.valueOf(2), com.tencent.mm.a.p.getString(this.lde), "", "", Integer.valueOf(this.gOW), Integer.valueOf(6));
        AppMethodBeat.o(53595);
    }

    public void onResume() {
        AppMethodBeat.i(53596);
        super.onResume();
        com.tencent.mm.kernel.g.RO().eJo.a((int) v2helper.EMethodSetNgStrength, (f) this);
        AppMethodBeat.o(53596);
    }

    public void onPause() {
        AppMethodBeat.i(53597);
        super.onPause();
        com.tencent.mm.kernel.g.RO().eJo.b((int) v2helper.EMethodSetNgStrength, (f) this);
        AppMethodBeat.o(53597);
    }

    public void onDestroy() {
        AppMethodBeat.i(53598);
        super.onDestroy();
        if (this.ldK != null) {
            com.tencent.mm.kernel.g.RO().eJo.c(this.ldK);
        }
        com.tencent.mm.kernel.g.RO().eJo.b((int) d.MIC_PTU_SHISHANG2, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b(720, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.kYt);
        if (this.mHandler != null) {
            this.mHandler.removeMessages(10002);
            this.mHandler.removeMessages(10001);
            this.mHandler = null;
        }
        AppMethodBeat.o(53598);
    }

    public final void initView() {
        AppMethodBeat.i(53599);
        if (!bo.isNullOrNil(this.kVJ)) {
            setMMTitle(this.kVJ);
        }
        this.abB = v.hu(this.mController.ylL).inflate(R.layout.ud, null);
        this.ldi = this.abB.findViewById(R.id.bg1);
        this.ldj = (BannerEmojiView) this.ldi.findViewById(R.id.bg7);
        this.ldk = (TextView) this.abB.findViewById(R.id.bg2);
        this.ldl = (TextView) this.abB.findViewById(R.id.bg3);
        this.ldm = this.abB.findViewById(R.id.bg4);
        this.ldn = this.abB.findViewById(R.id.bfw);
        this.ldo = (TextView) this.abB.findViewById(R.id.bfy);
        this.ldp = (ImageView) this.abB.findViewById(R.id.bfx);
        this.ldq = (TextView) this.abB.findViewById(R.id.bfz);
        this.ldr = (TextView) this.abB.findViewById(R.id.bg6);
        this.lds = this.abB.findViewById(R.id.bg9);
        this.ldu = this.abB.findViewById(R.id.bgd);
        this.ldu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(53588);
                EmojiStoreV2DesignerUI.e(EmojiStoreV2DesignerUI.this);
                AppMethodBeat.o(53588);
            }
        });
        this.ldv = (PreViewListGridView) this.abB.findViewById(R.id.bgb);
        this.ldw = new a(this.mController.ylL);
        this.ldw.lgn = new a() {
            public final void tY(int i) {
                AppMethodBeat.i(53589);
                if (!(EmojiStoreV2DesignerUI.this.ldv == null || EmojiStoreV2DesignerUI.this.ldw == null)) {
                    xx uo = EmojiStoreV2DesignerUI.this.ldw.uo(i);
                    if (uo != null) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(12787, Integer.valueOf(1), Integer.valueOf(0), uo.Md5, Long.valueOf(EmojiStoreV2DesignerUI.this.kVE), uo.wdC, uo.ProductID, Integer.valueOf(6));
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("extra_object", uo.toByteArray());
                            intent.putExtra("add_source", 5);
                            intent.putExtra("entrance_scene", 6);
                            intent.setClass(EmojiStoreV2DesignerUI.this.mController.ylL, EmojiStoreV2SingleProductDialogUI.class);
                            EmojiStoreV2DesignerUI.this.startActivityForResult(intent, 2004);
                            EmojiStoreV2DesignerUI.this.overridePendingTransition(R.anim.c4, R.anim.c9);
                            AppMethodBeat.o(53589);
                            return;
                        } catch (Exception e) {
                        }
                    }
                }
                AppMethodBeat.o(53589);
            }
        };
        this.ldv.setAdapter(this.ldw);
        this.ldx = this.abB.findViewById(R.id.bg_);
        this.ldy = this.abB.findViewById(R.id.bga);
        this.ldz = this.abB.findViewById(R.id.bgd);
        this.ldA = (TextView) this.abB.findViewById(R.id.bge);
        this.ldB = this.abB.findViewById(R.id.bgc);
        this.ldC = (MMPullDownView) findViewById(R.id.bfv);
        this.ldC.setOnBottomLoadDataListener(this);
        this.ldC.setAtBottomCallBack(this);
        this.ldC.setBottomViewVisible(false);
        this.ldC.setIsBottomShowAll(false);
        this.mListView = (ListView) findViewById(16908298);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnScrollListener(this);
        this.ldn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(53590);
                EmojiStoreV2DesignerUI.i(EmojiStoreV2DesignerUI.this);
                AppMethodBeat.o(53590);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53591);
                EmojiStoreV2DesignerUI.this.finish();
                AppMethodBeat.o(53591);
                return false;
            }
        });
        addIconOptionMenu(0, R.raw.ofm_send_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53592);
                ab.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
                EmojiStoreV2DesignerUI.j(EmojiStoreV2DesignerUI.this);
                AppMethodBeat.o(53592);
                return true;
            }
        });
        AppMethodBeat.o(53599);
    }

    private void Kh() {
        AppMethodBeat.i(53600);
        setMMTitle(this.kVJ);
        this.kYB = new com.tencent.mm.plugin.emoji.a.f(this.mController.ylL);
        this.mListView.addHeaderView(this.abB);
        this.mListView.setAdapter(this.kYB);
        this.kYB.kSQ = this;
        this.kYB.kSm = com.tencent.mm.emoji.a.e.OJ();
        this.kYB.kSn = false;
        this.ldk.setText(this.kVJ);
        this.ldD = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYq.aqs(String.valueOf(this.lde));
        this.kYr = new i();
        this.kYr.jiq = this;
        this.kYr.kVA = this.kYB;
        this.kYr.kVD = 6;
        this.kYr.kVG = this;
        this.kYr.kVJ = this.kVJ;
        this.kYr.kVE = this.kVE;
        this.kYr.kVF = this.kVF;
        if (this.ldD != null) {
            c(com.tencent.mm.plugin.emoji.f.p.a(this.ldD));
            bv(this.ldD.vKl);
        }
        updateData();
        aJ(this.kYe);
        AppMethodBeat.o(53600);
    }

    private void updateData() {
        AppMethodBeat.i(53601);
        if (this.ldD == null) {
            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
            AppMethodBeat.o(53601);
            return;
        }
        gv(true);
        if (bo.isNullOrNil(this.ldD.vKE)) {
            ab.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
            this.ldm.setVisibility(8);
            this.ldn.setVisibility(8);
        } else {
            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", this.ldD.vKE);
            this.ldh = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(this.ldD.vKE);
        }
        if ((this.ldh == null || ((int) this.ldh.ewQ) == 0) && ao.a.flu != null) {
            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", this.ldD.vKE);
            ao.a.flu.a(this.ldD.vKE, "", this.ldG);
        }
        this.ldq.setText(R.string.bcf);
        if (bo.isNullOrNil(this.ldD.Desc)) {
            this.ldl.setVisibility(8);
        } else {
            this.ldl.setText(this.ldD.Desc);
            this.ldl.setVisibility(0);
        }
        bme();
        if (this.kYq == null || this.kYq.kVq == null || this.kYq.kVq.isEmpty()) {
            this.ldr.setVisibility(8);
            AppMethodBeat.o(53601);
            return;
        }
        this.ldr.setVisibility(0);
        AppMethodBeat.o(53601);
    }

    /* Access modifiers changed, original: protected|final */
    public final void gv(boolean z) {
        AppMethodBeat.i(53602);
        if (this.ldD == null) {
            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
            AppMethodBeat.o(53602);
            return;
        }
        if (!(this.ldj == null || bo.isNullOrNil(this.ldD.wrl))) {
            String str = this.ldD.wrl;
            com.tencent.mm.bz.a.getDensity(this);
            EmojiInfo r = EmojiLogic.r("Designer", 8, str);
            if (r != null) {
                this.ldj.setImageFilePath(r.dve());
            } else if (z) {
                o.ahp().a(this.ldD.wrl, null, com.tencent.mm.plugin.emoji.e.g.j("Designer", this.ldD.wrl, "Designer", "BANNER"), new com.tencent.mm.at.a.c.i() {
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(53593);
                        if (EmojiStoreV2DesignerUI.this.mHandler != null) {
                            EmojiStoreV2DesignerUI.this.mHandler.sendEmptyMessage(10001);
                        }
                        AppMethodBeat.o(53593);
                    }
                });
                AppMethodBeat.o(53602);
                return;
            } else {
                ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
                AppMethodBeat.o(53602);
                return;
            }
        }
        AppMethodBeat.o(53602);
    }

    private void bme() {
        AppMethodBeat.i(53603);
        if (this.ldh == null || ((int) this.ldh.ewQ) == 0) {
            this.ldn.setVisibility(8);
            this.ldm.setVisibility(8);
            AppMethodBeat.o(53603);
            return;
        }
        this.ldn.setVisibility(0);
        this.ldm.setVisibility(0);
        if (bo.isNullOrNil(this.ldh.Oi())) {
            this.ldo.setText(this.ldh.field_username);
        } else {
            this.ldo.setText(this.ldh.Oi());
        }
        com.tencent.mm.pluginsdk.ui.a.b.r(this.ldp, this.ldh.field_username);
        this.ldq.setEnabled(true);
        AppMethodBeat.o(53603);
    }

    private void aJ(byte[] bArr) {
        AppMethodBeat.i(53604);
        this.hZu = true;
        this.ldK = new com.tencent.mm.plugin.emoji.f.p(this.lde, bArr);
        com.tencent.mm.kernel.g.RO().eJo.a(this.ldK, 0);
        AppMethodBeat.o(53604);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53605);
        switch (mVar.getType()) {
            case d.MIC_PTU_SHISHANG2 /*239*/:
                if (this.ldF != null && this.ldF.isShowing()) {
                    this.ldF.dismiss();
                }
                if (i2 == 0 && i == 0) {
                    aic bkx = ((com.tencent.mm.plugin.emoji.f.i) mVar).bkx();
                    if (!(bkx == null || bkx.woq == null)) {
                        this.lde = bkx.woq.DesignerUin;
                        this.kVJ = bkx.woq.Name;
                        this.ldf = bkx.woq.HeadUrl;
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(10003);
                        }
                    }
                    AppMethodBeat.o(53605);
                    return;
                }
                showOptionMenu(0, false);
                h.b(this.mController.ylL, getString(R.string.b_3), null, true);
                ab.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
                AppMethodBeat.o(53605);
                return;
            case v2helper.EMethodSetNgStrength /*423*/:
                if (mVar instanceof g) {
                    g gVar = (g) mVar;
                    if (i == 0 && i2 == 0) {
                        bX(gVar.kWz, 0);
                        AppMethodBeat.o(53605);
                        return;
                    }
                    final String str2 = gVar.kWz;
                    final String str3 = gVar.kWB;
                    final String str4 = gVar.kWA;
                    h.a((Context) this, getString(R.string.baj, new Object[]{str4}), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(53582);
                            EmojiStoreV2DesignerUI.this.M(str2, str3, str4);
                            EmojiStoreV2DesignerUI.this.bkZ();
                            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", str2);
                            EmojiStoreV2DesignerUI.a(EmojiStoreV2DesignerUI.this, str2);
                            AppMethodBeat.o(53582);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    bW(gVar.kWz, -1);
                    AppMethodBeat.o(53605);
                    return;
                }
                break;
            case 720:
                this.hZu = false;
                if (i == 0 || i == 4) {
                    com.tencent.mm.plugin.emoji.f.p pVar = (com.tencent.mm.plugin.emoji.f.p) mVar;
                    com.tencent.mm.plugin.emoji.model.f a = com.tencent.mm.plugin.emoji.f.p.a(pVar.bkE());
                    if (i2 == 0) {
                        this.ldD = pVar.bkE();
                        c(a);
                    } else if (i2 == 2) {
                        this.ldD = pVar.bkE();
                        b(this.kYc, a);
                        this.kYc = 2;
                    } else if (i2 == 3) {
                        this.ldD = pVar.bkE();
                        b(this.kYc, a);
                        this.kYc = 1;
                        ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", Integer.valueOf(i2));
                    }
                    if (this.kYe == null && this.ldD != null) {
                        com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYq.a(String.valueOf(this.lde), pVar.bkE());
                        this.ldt = this.ldD.vKl;
                        bv(this.ldt);
                    }
                    this.kYe = pVar.kWS;
                    AppMethodBeat.o(53605);
                    return;
                }
                ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
                AppMethodBeat.o(53605);
                return;
            default:
                ab.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
                break;
        }
        AppMethodBeat.o(53605);
    }

    private void bv(final List<xx> list) {
        int i = 1;
        AppMethodBeat.i(53606);
        String value = com.tencent.mm.m.g.Nu().getValue("ShowDesignerEmoji");
        ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", value);
        if (bo.isNullOrNil(value) || bo.ank(value) != 1) {
            i = 0;
        }
        if (list == null || list.size() <= 0 || i == 0) {
            this.lds.setVisibility(8);
            AppMethodBeat.o(53606);
            return;
        }
        this.lds.setVisibility(0);
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                public final void run() {
                    int i;
                    int i2 = 8;
                    AppMethodBeat.i(53581);
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
                        emojiStoreV2DesignerUI.ldA.setText(R.string.bb_);
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
                    AppMethodBeat.o(53581);
                }
            });
        }
        this.ldw.bw(list);
        AppMethodBeat.o(53606);
    }

    private void c(com.tencent.mm.plugin.emoji.model.f fVar) {
        AppMethodBeat.i(53607);
        b(this.kYc, fVar);
        this.kYc = 0;
        AppMethodBeat.o(53607);
    }

    private void b(int i, com.tencent.mm.plugin.emoji.model.f fVar) {
        boolean z = true;
        AppMethodBeat.i(53608);
        switch (i) {
            case -1:
                this.kYq = fVar;
                break;
            case 0:
                this.kYq = fVar;
                break;
            case 1:
                this.kYq = fVar;
                break;
            case 2:
                if (this.kYq == null) {
                    this.kYq = new com.tencent.mm.plugin.emoji.model.f();
                }
                this.kYq.ue(fVar.kVp);
                this.kYq.br(fVar.kVq);
                break;
            default:
                z = false;
                break;
        }
        gw(z);
        AppMethodBeat.o(53608);
    }

    private void gw(boolean z) {
        AppMethodBeat.i(53609);
        if (this.kYq != null && z) {
            if (this.kYB != null) {
                this.kYB.b(this.kYq);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(10002);
            }
        }
        AppMethodBeat.o(53609);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(53610);
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            if (this.kYc == 0 || this.hZu) {
                ab.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
                AppMethodBeat.o(53610);
                return;
            }
            aJ(this.kYe);
            ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        AppMethodBeat.o(53610);
    }

    public final boolean bhk() {
        return true;
    }

    public final boolean bhm() {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(53611);
        if (this.kYB != null) {
            com.tencent.mm.plugin.emoji.a.a.f tX = this.kYB.getItem(i - this.mListView.getHeaderViewsCount());
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
                    intent.putExtra("extra_progress", tX.EV);
                    intent.putExtra("searchID", this.kVE);
                    String stringExtra = getIntent().getStringExtra("to_talker_name");
                    if (!bo.isNullOrNil(stringExtra)) {
                        intent.putExtra("to_talker_name", stringExtra);
                    }
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        }
        AppMethodBeat.o(53611);
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        AppMethodBeat.i(53612);
        String str = "MicroMsg.emoji.EmojiStoreV2DesignerUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.bjo()) ? "" : aVar.bjo();
        objArr[2] = Integer.valueOf(aVar.bjn());
        ab.i(str, str2, objArr);
        aVar.bjn();
        this.kYr.a(aVar);
        AppMethodBeat.o(53612);
    }

    public final void i(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(53613);
        M(str, str2, str3);
        bkZ();
        AppMethodBeat.o(53613);
    }

    public final void bkf() {
    }

    /* Access modifiers changed, original: protected|final */
    public final g M(String str, String str2, String str3) {
        AppMethodBeat.i(53614);
        this.kYu = new g(str, str2, str3);
        g gVar = this.kYu;
        AppMethodBeat.o(53614);
        return gVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bkZ() {
        AppMethodBeat.i(53615);
        com.tencent.mm.kernel.g.RO().eJo.a(this.kYu, 0);
        AppMethodBeat.o(53615);
    }

    /* Access modifiers changed, original: final */
    public final void bX(String str, int i) {
        AppMethodBeat.i(53616);
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
        AppMethodBeat.o(53616);
    }

    /* Access modifiers changed, original: final */
    public final void bW(String str, int i) {
        AppMethodBeat.i(53617);
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i);
        obtain.what = 131076;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
        AppMethodBeat.o(53617);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53618);
        this.kYr.onActivityResult(i, i2, intent);
        if (i == 2002) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                if (bo.isNullOrNil(stringExtra) || this.ldD == null) {
                    ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
                } else {
                    ab.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "..".concat(String.valueOf(stringExtra)));
                    String str = this.kVJ;
                    String str2 = this.ldD.Desc;
                    int i3 = this.lde;
                    String str3 = this.ldg;
                    String str4 = this.kVJ;
                    String str5 = this.ldD.HeadUrl;
                    com.tencent.mm.pluginsdk.i iVar = (com.tencent.mm.pluginsdk.i) com.tencent.mm.kernel.g.K(com.tencent.mm.pluginsdk.i.class);
                    iVar.a((Context) this, stringExtra, getResources().getString(R.string.p6) + str, getString(R.string.tf), getString(R.string.atc), str5, (q.a) new com.tencent.mm.plugin.emoji.e.l.AnonymousClass2(stringExtra, str4, str2, i3, str3, str, str5, this));
                }
            }
        } else if (i == 2004 && i2 == -1) {
            com.tencent.mm.ui.widget.snackbar.b.i(this, this.mController.ylL.getString(R.string.ti));
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(53618);
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void e(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.i(53622);
        if (emojiStoreV2DesignerUI.lde != 0) {
            Intent intent = new Intent();
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, emojiStoreV2DesignerUI.lde);
            intent.setClass(emojiStoreV2DesignerUI.mController.ylL, EmojiStoreV2SingleProductUI.class);
            emojiStoreV2DesignerUI.startActivity(intent);
        }
        AppMethodBeat.o(53622);
    }

    static /* synthetic */ void i(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.i(53623);
        if (!(emojiStoreV2DesignerUI.ldD == null || bo.isNullOrNil(emojiStoreV2DesignerUI.ldD.vKE))) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", emojiStoreV2DesignerUI.ldD.vKE);
            com.tencent.mm.bp.d.b(emojiStoreV2DesignerUI.mController.ylL, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            com.tencent.mm.plugin.report.service.h.pYm.e(12067, Integer.valueOf(3), "", "", "", "");
        }
        AppMethodBeat.o(53623);
    }

    static /* synthetic */ void j(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        AppMethodBeat.i(53624);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(emojiStoreV2DesignerUI.mController.ylL, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(53583);
                lVar.a(1001, EmojiStoreV2DesignerUI.this.getString(R.string.ba1), (int) R.raw.bottomsheet_icon_transmit);
                lVar.a(1000, EmojiStoreV2DesignerUI.this.getString(R.string.ba2), (int) R.raw.bottomsheet_icon_moment);
                AppMethodBeat.o(53583);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(53584);
                switch (menuItem.getItemId()) {
                    case 1000:
                        if (EmojiStoreV2DesignerUI.this.ldD != null) {
                            com.tencent.mm.plugin.emoji.e.l.a(EmojiStoreV2DesignerUI.this.mController.ylL, EmojiStoreV2DesignerUI.this.ldD.Name + EmojiStoreV2DesignerUI.this.getString(R.string.bag), EmojiStoreV2DesignerUI.this.ldD.Desc, EmojiStoreV2DesignerUI.this.ldD.HeadUrl, EmojiStoreV2DesignerUI.this.ldg, EmojiLogic.r(EmojiStoreV2DesignerUI.this.lde, EmojiStoreV2DesignerUI.this.kVJ, EmojiStoreV2DesignerUI.this.ldg), 10);
                            com.tencent.mm.plugin.report.service.h.pYm.e(13224, Integer.valueOf(3), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2DesignerUI.this.lde));
                            break;
                        }
                        break;
                    case 1001:
                        com.tencent.mm.plugin.emoji.e.l.dE(EmojiStoreV2DesignerUI.this.mController.ylL);
                        EmojiStoreV2DesignerUI.this.mController.ylL.overridePendingTransition(R.anim.cg, R.anim.b6);
                        com.tencent.mm.plugin.report.service.h.pYm.e(13224, Integer.valueOf(3), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2DesignerUI.this.lde));
                        AppMethodBeat.o(53584);
                        return;
                }
                AppMethodBeat.o(53584);
            }
        };
        dVar.cpD();
        com.tencent.mm.plugin.report.service.h.pYm.e(13224, Integer.valueOf(3), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2DesignerUI.lde));
        AppMethodBeat.o(53624);
    }
}
