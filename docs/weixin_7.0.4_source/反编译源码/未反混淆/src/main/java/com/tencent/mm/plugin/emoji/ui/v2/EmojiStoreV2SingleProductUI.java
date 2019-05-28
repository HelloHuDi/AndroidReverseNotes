package com.tencent.mm.plugin.emoji.ui.v2;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.v;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreV2SingleProductUI extends MMActivity implements OnScrollListener, f {
    private View abB;
    private String edV;
    private int gOW;
    private ProgressDialog gqo;
    private boolean isLoading = false;
    private long kVE;
    private String kWK;
    private String kWM;
    private MMPullDownView ldC;
    private i ldE;
    private int lde = 0;
    private e lfA = new e() {
        public final boolean bhk() {
            AppMethodBeat.i(53752);
            ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
            EmojiStoreV2SingleProductUI.e(EmojiStoreV2SingleProductUI.this);
            AppMethodBeat.o(53752);
            return true;
        }
    };
    private c lfB = new c() {
        public final boolean bhm() {
            return false;
        }
    };
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
    private a lfk;
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
    private com.tencent.mm.sdk.b.c lfz = new com.tencent.mm.sdk.b.c<cx>() {
        {
            AppMethodBeat.i(53750);
            this.xxI = cx.class.getName().hashCode();
            AppMethodBeat.o(53750);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(53751);
            if (!(EmojiStoreV2SingleProductUI.this.lfk == null || EmojiStoreV2SingleProductUI.this.mHandler == null)) {
                EmojiStoreV2SingleProductUI.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(53749);
                        EmojiStoreV2SingleProductUI.this.lfk.notifyDataSetInvalidated();
                        AppMethodBeat.o(53749);
                    }
                });
            }
            AppMethodBeat.o(53751);
            return false;
        }
    };
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53744);
            switch (message.what) {
                case 1001:
                    if (EmojiStoreV2SingleProductUI.this.lfn != null) {
                        EmojiStoreV2SingleProductUI.this.lfn.setVisibility(8);
                        AppMethodBeat.o(53744);
                        return;
                    }
                    break;
                case 1002:
                    if (EmojiStoreV2SingleProductUI.this.lfn != null) {
                        EmojiStoreV2SingleProductUI.this.lfn.setVisibility(0);
                    }
                    sendEmptyMessage(1003);
                    AppMethodBeat.o(53744);
                    return;
                case 1004:
                    EmojiStoreV2SingleProductUI.b(EmojiStoreV2SingleProductUI.this);
                    break;
            }
            AppMethodBeat.o(53744);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2SingleProductUI() {
        AppMethodBeat.i(53760);
        AppMethodBeat.o(53760);
    }

    static /* synthetic */ void b(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.i(53779);
        emojiStoreV2SingleProductUI.Kh();
        AppMethodBeat.o(53779);
    }

    static /* synthetic */ void e(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.i(53780);
        emojiStoreV2SingleProductUI.bmi();
        AppMethodBeat.o(53780);
    }

    public final int getLayoutId() {
        return R.layout.v0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0183  */
    /* JADX WARNING: Missing block: B:51:0x020d, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r9.kWM) != false) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:53:0x0213, code skipped:
            if (r9.lde == 0) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:55:0x0219, code skipped:
            if (r9.lfa == 0) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:57:0x0223, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r9.kWK) != false) goto L_0x0111;
     */
    /* JADX WARNING: Missing block: B:59:0x0229, code skipped:
            if (r9.lfc == 0) goto L_0x0111;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(53761);
        super.onCreate(bundle);
        this.lde = getIntent().getIntExtra(OpenSDKTool4Assistant.EXTRA_UIN, 0);
        this.edV = getIntent().getStringExtra("Select_Conv_User");
        this.kVE = getIntent().getLongExtra("searchID", 0);
        this.kWM = getIntent().getStringExtra("id");
        String stringExtra = getIntent().getStringExtra("tag_id");
        if (!bo.isNullOrNil(stringExtra)) {
            try {
                this.lfa = Integer.valueOf(stringExtra).intValue();
            } catch (Exception e) {
                ab.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", bo.l(e));
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
        if (!bo.isNullOrNil(this.lfh)) {
            this.lfc = EmojiLogic.Jv(this.lfh);
            this.lfd = EmojiLogic.Jw(this.lfh);
            this.lfe = EmojiLogic.Jy(this.lfh);
            this.lff = EmojiLogic.Jx(this.lfh);
            this.lfg = EmojiLogic.Jz(this.lfh);
            this.lfi = EmojiLogic.JA(this.lfh);
        }
        switch (this.lfi) {
            case 0:
                if (bo.isNullOrNil(this.kWK)) {
                    if (bo.isNullOrNil(this.kWM)) {
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
            j.bki();
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            intent.putExtra("showShare", false);
            d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            finish();
        }
        initView();
        if (this.lde == 0 && this.lfi == 2) {
            aic aqn = j.getEmojiStorageMgr().xYt.aqn(this.kWM);
            if (aqn == null || aqn.woq == null || aqn.woq.DesignerUin == 0 || bo.isNullOrNil(aqn.woq.Name)) {
                z = true;
                if (z) {
                    Kh();
                } else {
                    this.ldE = new i(this.kWM);
                    g.RO().eJo.a(this.ldE, 0);
                    JP(getString(R.string.un));
                }
                g.RP().Ry().set(a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.FALSE);
                g.RO().eJo.a(821, (f) this);
                g.RO().eJo.a((int) com.tencent.view.d.MIC_PTU_SHISHANG2, (f) this);
                AppMethodBeat.o(53761);
            }
            this.lde = aqn.woq.DesignerUin;
            ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", Integer.valueOf(this.lde));
        }
        z = false;
        if (z) {
        }
        g.RP().Ry().set(a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.FALSE);
        g.RO().eJo.a(821, (f) this);
        g.RO().eJo.a((int) com.tencent.view.d.MIC_PTU_SHISHANG2, (f) this);
        AppMethodBeat.o(53761);
    }

    public void onResume() {
        AppMethodBeat.i(53762);
        super.onResume();
        com.tencent.mm.sdk.b.a.xxA.c(this.lfz);
        AppMethodBeat.o(53762);
    }

    public void onPause() {
        AppMethodBeat.i(53763);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.lfz);
        AppMethodBeat.o(53763);
    }

    public void onDestroy() {
        AppMethodBeat.i(53764);
        g.RO().eJo.b((int) com.tencent.view.d.MIC_PTU_SHISHANG2, (f) this);
        g.RO().eJo.b(821, (f) this);
        super.onDestroy();
        AppMethodBeat.o(53764);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53765);
        switch (i) {
            case 2002:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bo.isNullOrNil(stringExtra)) {
                        ab.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "..".concat(String.valueOf(stringExtra)));
                        int i3 = this.lfc;
                        String str = this.lfd;
                        String str2 = this.lff;
                        String str3 = this.lfe;
                        String str4 = this.lfg;
                        int i4 = this.lfi;
                        j.bki();
                        l.a(this, stringExtra, 27, i3, str, str2, str3, str4, i4, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
                        break;
                    }
                }
                break;
            case ReaderCallback.HIDDEN_BAR /*5001*/:
                if (i2 == -1) {
                    com.tencent.mm.ui.widget.snackbar.b.i(this, this.mController.ylL.getString(R.string.ti));
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(53765);
    }

    public final void initView() {
        AppMethodBeat.i(53766);
        if (this.lfi != 6 || bo.isNullOrNil(this.lfd)) {
            setMMTitle((int) R.string.bba);
        } else {
            setMMTitle(this.lfd);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53753);
                if (EmojiStoreV2SingleProductUI.this.lft == null || EmojiStoreV2SingleProductUI.this.lft.getVisibility() != 0) {
                    EmojiStoreV2SingleProductUI.this.finish();
                } else {
                    EmojiStoreV2SingleProductUI.this.lft.setVisibility(8);
                    EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, EmojiStoreV2SingleProductUI.this.lfo);
                    EmojiStoreV2SingleProductUI.this.setMMTitle((int) R.string.bba);
                }
                AppMethodBeat.o(53753);
                return false;
            }
        });
        this.lfk = new a(this.mController.ylL);
        this.lfk.lgn = new a() {
            public final void tY(int i) {
                AppMethodBeat.i(53754);
                if (!(EmojiStoreV2SingleProductUI.this.lfj == null || EmojiStoreV2SingleProductUI.this.lfk == null)) {
                    xx uo = EmojiStoreV2SingleProductUI.this.lfk.uo(i);
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
                            EmojiStoreV2SingleProductUI.this.overridePendingTransition(R.anim.c4, R.anim.c9);
                            h.pYm.e(12787, Integer.valueOf(EmojiStoreV2SingleProductUI.this.gOW), Integer.valueOf(0), uo.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.this.kVE), uo.wdC, uo.ProductID, Integer.valueOf(29));
                            AppMethodBeat.o(53754);
                            return;
                        } catch (Exception e) {
                        }
                    }
                }
                AppMethodBeat.o(53754);
            }
        };
        this.lfj = (PreViewListGridView) findViewById(R.id.l9);
        this.abB = v.hu(this.mController.ylL).inflate(R.layout.um, null);
        this.lfl = this.abB.findViewById(R.id.bgk);
        this.lfm = (TextView) this.abB.findViewById(R.id.bgl);
        this.lfj.addHeaderView(this.abB);
        this.lfn = v.hu(this.mController.ylL).inflate(R.layout.u_, null);
        this.lfj.addFooterView(this.lfn);
        this.lfn.setVisibility(8);
        this.lfj.setAdapter(this.lfk);
        this.lfj.setOnScrollListener(this);
        this.ldC = (MMPullDownView) findViewById(R.id.bhb);
        this.ldC.setTopViewVisible(false);
        this.ldC.setOnBottomLoadDataListener(this.lfA);
        this.ldC.setAtBottomCallBack(this.lfB);
        this.ldC.setBottomViewVisible(false);
        this.ldC.setIsBottomShowAll(false);
        this.ldC.setIsReturnSuperDispatchWhenCancel(true);
        this.lft = (LabelContainerView) findViewById(R.id.iy);
        this.lfu = (TextView) this.lft.findViewById(16908310);
        this.lfu.setText(R.string.cl9);
        this.lfv = (MMTagPanel) this.lft.findViewById(R.id.iz);
        this.lfv.setTagSelectedBG(R.drawable.a2v);
        this.lfv.setTagSelectedTextColorRes(R.color.a61);
        this.lfs = getString(R.string.bc3);
        this.lft.setOnLabelContainerListener(new LabelContainerView.a() {
            public final void bmk() {
                AppMethodBeat.i(53755);
                if (EmojiStoreV2SingleProductUI.this.lft != null) {
                    EmojiStoreV2SingleProductUI.this.lft.clearFocus();
                }
                EmojiStoreV2SingleProductUI.this.lft.requestFocus();
                EmojiStoreV2SingleProductUI.this.lft.setVisibility(8);
                EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, EmojiStoreV2SingleProductUI.this.lfo);
                EmojiStoreV2SingleProductUI.this.setMMTitle((int) R.string.bba);
                AppMethodBeat.o(53755);
            }

            public final void bml() {
                AppMethodBeat.i(53756);
                EmojiStoreV2SingleProductUI.this.aqX();
                AppMethodBeat.o(53756);
            }
        });
        this.lfv.setCallBack(new MMTagPanel.a() {
            public final void JR(String str) {
                AppMethodBeat.i(53757);
                if (!(bo.isNullOrNil(EmojiStoreV2SingleProductUI.this.lfs) || bo.isNullOrNil(str) || !str.equals(EmojiStoreV2SingleProductUI.this.lfs))) {
                    EmojiStoreV2SingleProductUI.this.lfv.cd(EmojiStoreV2SingleProductUI.this.lfs, true);
                }
                AppMethodBeat.o(53757);
            }

            public final void JS(String str) {
                AppMethodBeat.i(53758);
                EmojiStoreV2SingleProductUI.a(EmojiStoreV2SingleProductUI.this, str);
                AppMethodBeat.o(53758);
            }

            public final void JT(String str) {
            }

            public final void q(boolean z, int i) {
            }

            public final void bmm() {
            }

            public final void JU(String str) {
            }

            public final void JV(String str) {
            }
        });
        addIconOptionMenu(1001, R.drawable.aun, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53759);
                if (EmojiStoreV2SingleProductUI.this.lft != null) {
                    EmojiStoreV2SingleProductUI.this.lft.setVisibility(0);
                    Collection arrayList = new ArrayList();
                    arrayList.add(EmojiStoreV2SingleProductUI.this.lfs);
                    EmojiStoreV2SingleProductUI.this.lfv.a(arrayList, EmojiStoreV2SingleProductUI.this.lfx);
                    EmojiStoreV2SingleProductUI.this.setMMTitle((int) R.string.bby);
                    EmojiStoreV2SingleProductUI.this.showOptionMenu(1001, false);
                    h.pYm.X(12788, "1");
                }
                AppMethodBeat.o(53759);
                return false;
            }
        });
        addIconOptionMenu(1002, R.raw.ofm_send_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53745);
                ab.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
                EmojiStoreV2SingleProductUI.o(EmojiStoreV2SingleProductUI.this);
                AppMethodBeat.o(53745);
                return true;
            }
        });
        showOptionMenu(1001, false);
        showOptionMenu(1002, false);
        AppMethodBeat.o(53766);
    }

    public void onBackPressed() {
        AppMethodBeat.i(53767);
        if (this.lft == null || this.lft.getVisibility() != 0) {
            super.onBackPressed();
            AppMethodBeat.o(53767);
            return;
        }
        this.lft.setVisibility(8);
        showOptionMenu(1001, this.lfo);
        setMMTitle((int) R.string.bba);
        AppMethodBeat.o(53767);
    }

    private void Kh() {
        AppMethodBeat.i(53768);
        if (this.lfy) {
            ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
            AppMethodBeat.o(53768);
            return;
        }
        this.lfq = null;
        switch (this.lfi) {
            case 1:
                this.lfp = j.getEmojiStorageMgr().xYt.aqo(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                if (this.lfp == null || this.lfp.woo == null || this.lfk == null) {
                    JP(getString(R.string.un));
                } else {
                    a(this.lfp);
                    this.lfk.bw(this.lfp.woo);
                }
                this.lfo = true;
                h.pYm.e(12875, Integer.valueOf(0), "");
                break;
            case 2:
            case 3:
                showOptionMenu(1001, false);
                this.lfo = false;
                h.pYm.e(12875, Integer.valueOf(1), this.kWM);
                break;
            case 4:
                showOptionMenu(1001, false);
                this.lfs = this.lfb;
                JQ(this.lfs);
                this.lfo = false;
                h.pYm.e(12875, Integer.valueOf(1), "");
                break;
            case 5:
                this.lfs = "";
                JQ(this.kWK);
                this.lfo = false;
                h.pYm.e(12875, Integer.valueOf(2), "");
                break;
            case 6:
                this.lfs = "";
                showOptionMenu(1001, false);
                showOptionMenu(1002, true);
                h.pYm.e(12875, Integer.valueOf(3), "");
                break;
        }
        aK(this.lfq);
        AppMethodBeat.o(53768);
    }

    private void JP(String str) {
        AppMethodBeat.i(53769);
        if (isFinishing()) {
            ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
            AppMethodBeat.o(53769);
            return;
        }
        getString(R.string.tz);
        this.gqo = com.tencent.mm.ui.base.h.b((Context) this, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(53746);
                if (EmojiStoreV2SingleProductUI.this.ldE != null) {
                    g.RO().eJo.c(EmojiStoreV2SingleProductUI.this.ldE);
                }
                AppMethodBeat.o(53746);
            }
        });
        AppMethodBeat.o(53769);
    }

    private void blb() {
        AppMethodBeat.i(53770);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.o(53770);
    }

    private void aK(byte[] bArr) {
        AppMethodBeat.i(53771);
        this.lfq = null;
        switch (this.lfi) {
            case 1:
                g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.h(1, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                AppMethodBeat.o(53771);
                return;
            case 2:
            case 3:
                g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.h(2, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                AppMethodBeat.o(53771);
                return;
            case 4:
                g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.h(3, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                AppMethodBeat.o(53771);
                return;
            case 5:
                g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.h(4, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                AppMethodBeat.o(53771);
                return;
            case 6:
                g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.h(5, this.lde, this.lfa, this.kWK, this.lfc, bArr), 0);
                break;
        }
        AppMethodBeat.o(53771);
    }

    private void a(aia aia) {
        boolean z = false;
        AppMethodBeat.i(53772);
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
                this.lfx.add(getString(R.string.bc3));
                Iterator it = aia.wop.iterator();
                while (it.hasNext()) {
                    xz xzVar = (xz) it.next();
                    if (!(xzVar == null || bo.isNullOrNil(xzVar.wdJ))) {
                        this.lfx.add(xzVar.wdJ);
                        this.lfw.put(xzVar.wdJ, Integer.valueOf(xzVar.wdI));
                    }
                }
                Collection arrayList = new ArrayList();
                arrayList.add(this.lfs);
                this.lfv.a(arrayList, this.lfx);
                AppMethodBeat.o(53772);
                return;
            }
        }
        AppMethodBeat.o(53772);
    }

    private void JQ(String str) {
        AppMethodBeat.i(53773);
        if (!(this.lfl == null || this.lfm == null)) {
            switch (this.lfi) {
                case 4:
                    if (!bo.isNullOrNil(str)) {
                        this.lfm.setText(getString(R.string.bc4, new Object[]{str}));
                        this.lfm.setVisibility(0);
                        this.lfl.setVisibility(0);
                        break;
                    }
                    break;
                case 5:
                    if (!bo.isNullOrNil(str)) {
                        this.lfm.setText(getString(R.string.bbz, new Object[]{str}));
                        this.lfm.setVisibility(0);
                        this.lfl.setVisibility(0);
                        break;
                    }
                    break;
            }
            if (bo.isNullOrNil(str)) {
                this.lfm.setText("");
                this.lfm.setVisibility(8);
                this.lfl.setVisibility(8);
            }
        }
        AppMethodBeat.o(53773);
    }

    private void bmi() {
        AppMethodBeat.i(53774);
        if (!this.isLoading) {
            aK(this.lfq);
            this.isLoading = true;
            this.mHandler.sendEmptyMessageDelayed(1002, 200);
        }
        AppMethodBeat.o(53774);
    }

    private void R(LinkedList<xx> linkedList) {
        AppMethodBeat.i(53775);
        if (!(this.lfk == null || linkedList == null)) {
            if (this.lfr == -1) {
                this.lfk.bw(linkedList);
                AppMethodBeat.o(53775);
                return;
            }
            a aVar = this.lfk;
            if (aVar.kSg == null) {
                aVar.kSg = new ArrayList();
            }
            aVar.kSg.addAll(linkedList);
            aVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(53775);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53777);
        int type = mVar.getType();
        if (type == 821) {
            blb();
            com.tencent.mm.plugin.emoji.f.h hVar = (com.tencent.mm.plugin.emoji.f.h) mVar;
            aia bkw = hVar.bkw();
            this.isLoading = false;
            if (this.lfn != null) {
                this.lfn.setVisibility(8);
                this.mHandler.removeMessages(1002);
                this.mHandler.sendEmptyMessageDelayed(1001, 200);
            }
            int i3 = hVar.gvO;
            if (((i == 0 && i2 == 0) || (i == 4 && (i2 == 2 || i2 == 3))) && ((this.lfq == null || this.lfq.length <= 0) && i3 != 3)) {
                a(bkw);
            }
            if (i == 0 || i == 4) {
                this.lfq = hVar.kWI;
                if (i2 == 0) {
                    R(bkw.woo);
                    this.lfr = 0;
                    AppMethodBeat.o(53777);
                    return;
                } else if (i2 == 2) {
                    R(bkw.woo);
                    this.lfr = 2;
                    AppMethodBeat.o(53777);
                    return;
                } else if (i2 == 3) {
                    this.lfr = -1;
                    R(bkw.woo);
                    AppMethodBeat.o(53777);
                    return;
                } else {
                    bmj();
                    AppMethodBeat.o(53777);
                    return;
                }
            }
            bmj();
            AppMethodBeat.o(53777);
            return;
        }
        if (type == com.tencent.view.d.MIC_PTU_SHISHANG2) {
            blb();
            if (i2 == 0 && i == 0) {
                aic bkx = ((i) mVar).bkx();
                if (!(bkx == null || bkx.woq == null)) {
                    this.lde = bkx.woq.DesignerUin;
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(1004);
                    }
                }
                AppMethodBeat.o(53777);
                return;
            }
            showOptionMenu(1001, false);
            com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.b_3), null, true);
            ab.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
        }
        AppMethodBeat.o(53777);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(53778);
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.lfr == 2 && !this.isLoading) {
            ab.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
            bmi();
            ab.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        if (!(i == 0 || this.lfj == null)) {
            this.lfj.bmt();
        }
        AppMethodBeat.o(53778);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void bmj() {
        AppMethodBeat.i(53776);
        Toast.makeText(this.mController.ylL, getString(R.string.bd1), 0).show();
        AppMethodBeat.o(53776);
    }

    static /* synthetic */ void a(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI, String str) {
        AppMethodBeat.i(53781);
        emojiStoreV2SingleProductUI.setMMTitle((int) R.string.bba);
        emojiStoreV2SingleProductUI.showOptionMenu(1001, emojiStoreV2SingleProductUI.lfo);
        if (emojiStoreV2SingleProductUI.lfw == null || !emojiStoreV2SingleProductUI.lfw.containsKey(str)) {
            emojiStoreV2SingleProductUI.lfq = null;
            emojiStoreV2SingleProductUI.lfr = -1;
            emojiStoreV2SingleProductUI.lfs = emojiStoreV2SingleProductUI.getString(R.string.bc3);
            emojiStoreV2SingleProductUI.lfi = 1;
            emojiStoreV2SingleProductUI.lfa = 0;
            emojiStoreV2SingleProductUI.aK(emojiStoreV2SingleProductUI.lfq);
            emojiStoreV2SingleProductUI.JQ("");
        } else {
            emojiStoreV2SingleProductUI.lfr = -1;
            emojiStoreV2SingleProductUI.lfs = str;
            emojiStoreV2SingleProductUI.lfi = 4;
            emojiStoreV2SingleProductUI.lfa = ((Integer) emojiStoreV2SingleProductUI.lfw.get(emojiStoreV2SingleProductUI.lfs)).intValue();
            emojiStoreV2SingleProductUI.aK(null);
            emojiStoreV2SingleProductUI.JQ(str);
        }
        if (emojiStoreV2SingleProductUI.lft != null) {
            emojiStoreV2SingleProductUI.lft.setVisibility(8);
        }
        AppMethodBeat.o(53781);
    }

    static /* synthetic */ void o(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        AppMethodBeat.i(53782);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(emojiStoreV2SingleProductUI.mController.ylL, 1, false);
        dVar.rBl = new n.c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(53747);
                lVar.a(1001, EmojiStoreV2SingleProductUI.this.getString(R.string.ba1), (int) R.raw.bottomsheet_icon_transmit);
                lVar.a(1000, EmojiStoreV2SingleProductUI.this.getString(R.string.ba2), (int) R.raw.bottomsheet_icon_moment);
                AppMethodBeat.o(53747);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(53748);
                switch (menuItem.getItemId()) {
                    case 1000:
                        Context context = EmojiStoreV2SingleProductUI.this.mController.ylL;
                        String r = EmojiStoreV2SingleProductUI.this.lfd;
                        String s = EmojiStoreV2SingleProductUI.this.lff;
                        String t = EmojiStoreV2SingleProductUI.this.lfe;
                        j.bki();
                        l.a(context, r, s, t, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreV2SingleProductUI.this.lfc, EmojiStoreV2SingleProductUI.this.lfd, EmojiStoreV2SingleProductUI.this.lff, EmojiStoreV2SingleProductUI.this.lfe, EmojiStoreV2SingleProductUI.this.lfg, EmojiStoreV2SingleProductUI.this.lfi), 12);
                        h.pYm.e(13224, Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2SingleProductUI.this.lfc));
                        break;
                    case 1001:
                        l.dE(EmojiStoreV2SingleProductUI.this.mController.ylL);
                        EmojiStoreV2SingleProductUI.this.mController.ylL.overridePendingTransition(R.anim.cg, R.anim.b6);
                        h.pYm.e(13224, Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2SingleProductUI.this.lfc));
                        AppMethodBeat.o(53748);
                        return;
                }
                AppMethodBeat.o(53748);
            }
        };
        dVar.cpD();
        h.pYm.e(13224, Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2SingleProductUI.lfc));
        AppMethodBeat.o(53782);
    }
}
