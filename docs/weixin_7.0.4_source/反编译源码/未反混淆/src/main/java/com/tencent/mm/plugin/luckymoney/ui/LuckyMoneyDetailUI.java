package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.b.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.soter.core.biometric.FaceManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@a(1)
public class LuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private int Lp = 0;
    private View abB;
    private String emo;
    private Dialog gII;
    private boolean hZu = false;
    private TextView kEq;
    private TextView kGq;
    private d.a kVj = new d.a() {
        public final void a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.i(42672);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(42671);
                    if (!(emojiInfo == null || LuckyMoneyDetailUI.this.kZa == null || !LuckyMoneyDetailUI.this.kZa.Aq().equals(emojiInfo.Aq()))) {
                        if (z) {
                            ab.i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
                            LuckyMoneyDetailUI.this.kZa = j.getEmojiStorageMgr().xYn.aqi(LuckyMoneyDetailUI.this.kZa.Aq());
                            LuckyMoneyDetailUI.this.odJ.setVisibility(8);
                            LuckyMoneyDetailUI.this.odH.setVisibility(0);
                            LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.this.kZa);
                            AppMethodBeat.o(42671);
                            return;
                        }
                        ab.i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
                        LuckyMoneyDetailUI.this.odJ.setVisibility(8);
                        LuckyMoneyDetailUI.this.odI.setVisibility(0);
                    }
                    AppMethodBeat.o(42671);
                }
            });
            AppMethodBeat.o(42672);
        }
    };
    private String kWO;
    private EmojiInfo kZa;
    private View kZq;
    private ImageView lBT;
    private TextView nSD;
    private ListView nSL;
    private ImageView nSM;
    private TextView nSN;
    private ImageView nSO;
    private View nSP;
    private View nSQ;
    OnScrollListener nSS = new OnScrollListener() {
        private boolean nST = false;
        private boolean nSU;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(42645);
            if (absListView.getCount() == 0) {
                AppMethodBeat.o(42645);
                return;
            }
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (!LuckyMoneyDetailUI.this.ocz.bLA()) {
                            LuckyMoneyDetailUI.this.hZu = false;
                        }
                        if (LuckyMoneyDetailUI.this.ocG && !LuckyMoneyDetailUI.this.hZu) {
                            LuckyMoneyDetailUI.d(LuckyMoneyDetailUI.this);
                        }
                    }
                    this.nST = false;
                    AppMethodBeat.o(42645);
                    return;
                case 1:
                    this.nST = true;
                    break;
            }
            AppMethodBeat.o(42645);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            AppMethodBeat.i(42646);
            if (i3 == 0 || !this.nST) {
                AppMethodBeat.o(42646);
                return;
            }
            if (i <= 0) {
                int top;
                View childAt = absListView.getChildAt(i);
                if (childAt != null) {
                    top = 0 - childAt.getTop();
                } else {
                    top = 0;
                }
                if (top <= 100) {
                    z = false;
                }
            }
            if (this.nSU != z) {
                if (z) {
                    LuckyMoneyDetailUI.this.getResources().getDrawable(R.drawable.b8e);
                }
                this.nSU = z;
            }
            AppMethodBeat.o(42646);
        }
    };
    private List<w> nSx = new LinkedList();
    private SoundPool nTR;
    private b nVt = new b() {
        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            AppMethodBeat.i(42659);
            com.tencent.mm.plugin.luckymoney.particles.a.b aVar;
            switch (random.nextInt(8)) {
                case 0:
                    if (LuckyMoneyDetailUI.this.oem == null) {
                        LuckyMoneyDetailUI.this.oem = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.b9_);
                    }
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyDetailUI.this.oem);
                    AppMethodBeat.o(42659);
                    return aVar;
                case 1:
                    if (LuckyMoneyDetailUI.this.oen == null) {
                        LuckyMoneyDetailUI.this.oen = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.b9a);
                    }
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyDetailUI.this.oen);
                    AppMethodBeat.o(42659);
                    return aVar;
                case 2:
                    if (LuckyMoneyDetailUI.this.oeo == null) {
                        LuckyMoneyDetailUI.this.oeo = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.b9b);
                    }
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyDetailUI.this.oeo);
                    AppMethodBeat.o(42659);
                    return aVar;
                case 3:
                    if (LuckyMoneyDetailUI.this.oeh == null) {
                        LuckyMoneyDetailUI.this.oeh = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.b95);
                    }
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyDetailUI.this.oeh);
                    AppMethodBeat.o(42659);
                    return aVar;
                case 4:
                    if (LuckyMoneyDetailUI.this.oei == null) {
                        LuckyMoneyDetailUI.this.oei = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.b96);
                    }
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyDetailUI.this.oei);
                    AppMethodBeat.o(42659);
                    return aVar;
                case 5:
                    if (LuckyMoneyDetailUI.this.oej == null) {
                        LuckyMoneyDetailUI.this.oej = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.b97);
                    }
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyDetailUI.this.oej);
                    AppMethodBeat.o(42659);
                    return aVar;
                case 6:
                    if (LuckyMoneyDetailUI.this.oek == null) {
                        LuckyMoneyDetailUI.this.oek = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.b98);
                    }
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyDetailUI.this.oek);
                    AppMethodBeat.o(42659);
                    return aVar;
                case 7:
                    if (LuckyMoneyDetailUI.this.oel == null) {
                        LuckyMoneyDetailUI.this.oel = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.b99);
                    }
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyDetailUI.this.oel);
                    AppMethodBeat.o(42659);
                    return aVar;
                default:
                    AppMethodBeat.o(42659);
                    return null;
            }
        }
    };
    private int nXi = -1;
    private TextView nsq;
    private LuckyMoneyWishFooter ocC;
    private View ocE;
    private boolean ocG = true;
    private int ocH;
    private String ocI;
    private String ocJ;
    private String ocK;
    private String ocL;
    private Map<String, Integer> ocN = new HashMap();
    private i ocO;
    private String ocP = "";
    private boolean ocQ = false;
    private TextView odA;
    private TextView odB;
    private ViewGroup odC;
    private RelativeLayout odD;
    private int[] odE;
    private ViewGroup odF;
    private RelativeLayout odG;
    private BaseEmojiView odH;
    private TextView odI;
    private LinearLayout odJ;
    private MMAnimateView odK;
    private LinearLayout odL;
    private LinearLayout odM;
    private RelativeLayout odN;
    private LinearLayout odO;
    private BaseEmojiView odP;
    private RelativeLayout odQ;
    private ImageView odR;
    private a odS;
    private View odT;
    private ImageView odU;
    private FrameLayout odV;
    private boolean odW = false;
    private int odX;
    private ChatFooterPanel odY;
    private EmojiInfo odZ;
    private CdnImageView odq;
    private ImageView odr;
    private View ods;
    private ImageView odt;
    private TextView odu;
    private ViewGroup odv;
    private ViewGroup odw;
    private View odx;
    private View ody;
    private View odz;
    private ViewGroup oea;
    public LuckyMoneyEmojiSwitch oeb;
    private aa oec;
    private y oed;
    private z oee;
    private int oef = 0;
    private boolean oeg = false;
    private Bitmap oeh;
    private Bitmap oei;
    private Bitmap oej;
    private Bitmap oek;
    private Bitmap oel;
    private Bitmap oem;
    private Bitmap oen;
    private Bitmap oeo;
    private boolean oep = false;
    private int oeq;
    private View oer;
    private long oes = 0;
    private OnClickListener oet = new OnClickListener() {
        public final void onClick(final View view) {
            AppMethodBeat.i(42662);
            LuckyMoneyDetailUI.this.oed = new y();
            if (bo.gW(view.getId(), R.id.cvb)) {
                LuckyMoneyDetailUI.this.oed.cVT = 1;
                LuckyMoneyDetailUI.this.oed.ajK();
            }
            if (bo.gW(LuckyMoneyDetailUI.this.oeb.nXs, 0) && bo.C(view.getTag(), "nodelete")) {
                LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(42662);
                return;
            }
            com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(LuckyMoneyDetailUI.this.mController.ylL, 1, false);
            dVar.rBl = new c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(42660);
                    CharSequence string = LuckyMoneyDetailUI.this.getString(R.string.csz);
                    if (bo.gW(LuckyMoneyDetailUI.this.oeb.nXs, 0)) {
                        string = LuckyMoneyDetailUI.this.getString(R.string.cql);
                    } else {
                        lVar.hi(1, R.string.cry);
                    }
                    lVar.e(2, string);
                    if (!bo.C(view.getTag(), "nodelete")) {
                        lVar.a(3, LuckyMoneyDetailUI.this.getResources().getColor(R.color.ub), LuckyMoneyDetailUI.this.mController.ylL.getString(R.string.cqf));
                    }
                    AppMethodBeat.o(42660);
                }
            };
            dVar.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(42661);
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
                    switch (menuItem.getItemId()) {
                        case 1:
                            com.tencent.mm.plugin.emojicapture.api.c.h(LuckyMoneyDetailUI.this, null, 5);
                            LuckyMoneyDetailUI.this.oed = new y();
                            LuckyMoneyDetailUI.this.oed.cVT = 4;
                            LuckyMoneyDetailUI.this.oed.ajK();
                            LuckyMoneyDetailUI.this.oef = 1;
                            AppMethodBeat.o(42661);
                            return;
                        case 2:
                            LuckyMoneyDetailUI.C(LuckyMoneyDetailUI.this);
                            AppMethodBeat.o(42661);
                            return;
                        case 3:
                            LuckyMoneyDetailUI.this.kZa = null;
                            LuckyMoneyDetailUI.this.oed = new y();
                            LuckyMoneyDetailUI.this.oed.cVT = 8;
                            LuckyMoneyDetailUI.this.oed.ajK();
                            LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 1);
                            break;
                    }
                    AppMethodBeat.o(42661);
                }
            };
            LuckyMoneyDetailUI.this.oed.cVT = 2;
            LuckyMoneyDetailUI.this.oed.ajK();
            dVar.cpD();
            AppMethodBeat.o(42662);
        }
    };
    private int oeu = 3;
    private f oev = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(42664);
            if (bo.gW(mVar.getType(), 697) && (mVar instanceof e)) {
                e eVar = (e) mVar;
                if (i == 0 && i2 == 0) {
                    hv bku = eVar.bku();
                    if (bku != null && bku.vKl != null && bku.vKl.size() > 0 && bo.isEqual(((xx) bku.vKl.get(0)).Md5, LuckyMoneyDetailUI.this.kZa.Aq())) {
                        LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, false);
                    }
                }
            }
            AppMethodBeat.o(42664);
        }
    };
    private int oew = 0;
    private int oex = 0;
    private final int oey = 750;
    private final int oez = 240;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyDetailUI() {
        AppMethodBeat.i(42683);
        AppMethodBeat.o(42683);
    }

    static /* synthetic */ void B(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(42714);
        luckyMoneyDetailUI.bMv();
        AppMethodBeat.o(42714);
    }

    static /* synthetic */ void E(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(42717);
        super.finish();
        AppMethodBeat.o(42717);
    }

    static /* synthetic */ void r(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(42709);
        luckyMoneyDetailUI.bMt();
        AppMethodBeat.o(42709);
    }

    static /* synthetic */ int ya(int i) {
        AppMethodBeat.i(42708);
        int xW = xW(i);
        AppMethodBeat.o(42708);
        return xW;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42684);
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.a69);
        overridePendingTransition(getIntent().getBooleanExtra("key_anim_slide", false) ? R.anim.df : R.anim.c4, 0);
        xE(getResources().getColor(R.color.u9));
        dyb();
        initView();
        this.oeg = getIntent().getBooleanExtra("key_lucky_money_can_received", false);
        this.emo = getIntent().getStringExtra("key_username");
        this.ocI = getIntent().getStringExtra("key_sendid");
        this.ocK = getIntent().getStringExtra("key_native_url");
        this.ocH = getIntent().getIntExtra("key_jump_from", 2);
        this.ocP = getIntent().getStringExtra("key_process_content");
        ab.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + bo.nullAsNil(this.ocI) + ", nativeurl=" + bo.nullAsNil(this.ocK) + ", jumpFrom=" + this.ocH);
        if (bo.isNullOrNil(this.ocI) && !bo.isNullOrNil(this.ocK)) {
            try {
                this.ocI = Uri.parse(this.ocK).getQueryParameter("sendid");
            } catch (Exception e) {
            }
        }
        try {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
            this.kWO = getIntent().getStringExtra("key_detail_emoji_md5");
            this.odX = getIntent().getIntExtra("key_detail_emoji_type", 0);
            if (!bo.isNullOrNil(this.kWO)) {
                this.oec = new aa();
                this.oec.cVT = 10;
                this.oec.ajK();
            }
            this.oeb = (LuckyMoneyEmojiSwitch) getIntent().getParcelableExtra("key_emoji_switch");
            if (this.oeb == null) {
                this.oeb = new LuckyMoneyEmojiSwitch();
            }
            if (byteArrayExtra != null) {
                k kVar = (k) new k().parseFrom(byteArrayExtra);
                if (kVar != null) {
                    a(kVar);
                } else {
                    finish();
                }
            }
        } catch (Exception e2) {
            ab.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + e2.getLocalizedMessage());
            finish();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            k.a(this, a.NOTSET);
        }
        addTextOptionMenu(0, getString(R.string.cqc), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42677);
                h.pYm.e(11701, Integer.valueOf(LuckyMoneyDetailUI.ya(LuckyMoneyDetailUI.this.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                Intent intent = new Intent();
                intent.setClass(LuckyMoneyDetailUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                intent.putExtra("key_type", 2);
                LuckyMoneyDetailUI.this.startActivity(intent);
                AppMethodBeat.o(42677);
                return true;
            }
        });
        Nc(getResources().getColor(R.color.tx));
        AppMethodBeat.o(42684);
    }

    public boolean enableActivityAnimation() {
        return false;
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        AppMethodBeat.i(42685);
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        TextView textView = (TextView) findViewById(R.id.kh);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.tt));
        }
        AppMethodBeat.o(42685);
        return onCreatePanelMenu;
    }

    public void onResume() {
        AppMethodBeat.i(42686);
        super.onResume();
        this.oes = bo.anT();
        AppMethodBeat.o(42686);
    }

    public void onPause() {
        AppMethodBeat.i(42687);
        super.onPause();
        com.tencent.mm.modelstat.d.h("LuckyMoneyDetailUI", this.oes, bo.anT());
        AppMethodBeat.o(42687);
    }

    public final void initView() {
        AppMethodBeat.i(42688);
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42678);
                LuckyMoneyDetailUI.this.finish();
                AppMethodBeat.o(42678);
                return true;
            }
        });
        this.nSL = (ListView) findViewById(R.id.cvt);
        this.ocO = new i(this.mController.ylL);
        this.abB = LayoutInflater.from(this).inflate(R.layout.aa0, null);
        this.nSL.addHeaderView(this.abB);
        this.nSL.setAdapter(this.ocO);
        this.abB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42679);
                LuckyMoneyDetailUI.r(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(42679);
            }
        });
        this.nSL.setOnScrollListener(this.nSS);
        this.nSL.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(42680);
                LuckyMoneyDetailUI.r(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(42680);
            }
        });
        this.kZq = LayoutInflater.from(this).inflate(R.layout.a_y, null);
        this.nSM = (ImageView) this.abB.findViewById(R.id.cue);
        this.nSN = (TextView) this.abB.findViewById(R.id.cug);
        this.nSO = (ImageView) this.abB.findViewById(R.id.cuh);
        this.nsq = (TextView) this.abB.findViewById(R.id.cui);
        this.odG = (RelativeLayout) findViewById(R.id.cv5);
        this.odH = (BaseEmojiView) findViewById(R.id.cv6);
        this.odI = (TextView) findViewById(R.id.cv7);
        this.odJ = (LinearLayout) findViewById(R.id.cv8);
        this.odK = (MMAnimateView) findViewById(R.id.cv9);
        this.nSP = this.abB.findViewById(R.id.cuj);
        this.nSD = (TextView) this.abB.findViewById(R.id.cuk);
        this.nSQ = this.abB.findViewById(R.id.cum);
        this.kGq = (TextView) this.abB.findViewById(R.id.cuo);
        this.odq = (CdnImageView) this.abB.findViewById(R.id.cun);
        this.kEq = (TextView) this.abB.findViewById(R.id.cv0);
        this.odr = (ImageView) this.abB.findViewById(R.id.cud);
        this.ocE = this.abB.findViewById(R.id.cur);
        this.ods = this.abB.findViewById(R.id.cup);
        this.odt = (ImageView) this.abB.findViewById(R.id.cuq);
        this.odL = (LinearLayout) findViewById(R.id.cva);
        this.odM = (LinearLayout) findViewById(R.id.cvb);
        this.odN = (RelativeLayout) findViewById(R.id.cve);
        this.odO = (LinearLayout) findViewById(R.id.cvj);
        this.odP = (BaseEmojiView) findViewById(R.id.cvf);
        this.odQ = (RelativeLayout) findViewById(R.id.cvi);
        this.odR = (ImageView) findViewById(R.id.cvh);
        this.odu = (TextView) this.abB.findViewById(R.id.cv2);
        this.odv = (ViewGroup) this.abB.findViewById(R.id.cvo);
        this.odw = (ViewGroup) this.abB.findViewById(R.id.cvk);
        this.odx = findViewById(R.id.cvm);
        this.ody = findViewById(R.id.cvl);
        this.odz = findViewById(R.id.cvn);
        this.odD = (RelativeLayout) this.abB.findViewById(R.id.cup);
        this.lBT = (ImageView) this.abB.findViewById(R.id.cuq);
        this.ocC = (LuckyMoneyWishFooter) findViewById(R.id.cvu);
        this.oer = findViewById(R.id.cvq);
        this.odF = (ViewGroup) findViewById(R.id.cvv);
        this.odU = (ImageView) findViewById(R.id.cvg);
        this.odV = (FrameLayout) findViewById(R.id.cvp);
        this.odI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42681);
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, true);
                AppMethodBeat.o(42681);
            }
        });
        this.odS = new a(this);
        this.odT = getLayoutInflater().inflate(R.layout.aa3, null);
        this.odS.setContentView(this.odT, new LayoutParams(-1, -1));
        this.odT.findViewById(R.id.cvw).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42682);
                LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(42682);
            }
        });
        this.odS.obT = new a() {
            public final void bMl() {
                AppMethodBeat.i(42647);
                LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(42647);
            }
        };
        this.oea = (ViewGroup) this.odT.findViewById(R.id.cvy);
        this.odY = com.tencent.mm.pluginsdk.ui.chat.e.vom.dF(this.mController.ylL);
        com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.odY);
        this.odq.setUseSdcardCache(true);
        this.ocC.a(new MMEditText.a() {
            public final void bMu() {
                AppMethodBeat.i(42648);
                if (LuckyMoneyDetailUI.this.ocC.getVisibility() == 0) {
                    LuckyMoneyDetailUI.this.ocC.setVisibility(8);
                    AppMethodBeat.o(42648);
                    return;
                }
                LuckyMoneyDetailUI.this.mController.ylL.finish();
                AppMethodBeat.o(42648);
            }
        });
        this.ocC.setOnWishSendImp(new LuckyMoneyWishFooter.b() {
            public final void Qm(String str) {
                AppMethodBeat.i(42649);
                if (!(bo.isNullOrNil(str) || bo.isNullOrNil(LuckyMoneyDetailUI.this.ocJ))) {
                    LuckyMoneyDetailUI.this.b(new am(LuckyMoneyDetailUI.this.ocI, str, LuckyMoneyDetailUI.this.ocJ, "v1.0"), false);
                    LuckyMoneyDetailUI.r(LuckyMoneyDetailUI.this);
                }
                AppMethodBeat.o(42649);
            }
        });
        this.ocC.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(42650);
                com.tencent.mm.compatible.util.j.r(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(42650);
            }
        });
        this.ocC.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            public final void sD(int i) {
                AppMethodBeat.i(42651);
                if (i == -2) {
                    if (LuckyMoneyDetailUI.this.ocC.oil) {
                        LuckyMoneyDetailUI.this.ocC.setModeClick(false);
                        AppMethodBeat.o(42651);
                        return;
                    }
                    LuckyMoneyDetailUI.this.ocC.setVisibility(8);
                }
                AppMethodBeat.o(42651);
            }
        });
        this.ocO.ohU = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42652);
                LuckyMoneyDetailUI.this.ocC.setVisibility(0);
                AppMethodBeat.o(42652);
            }
        };
        this.ocC.setMaxLength(25);
        this.odu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42653);
                LuckyMoneyDetailUI.this.ocC.setVisibility(0);
                AppMethodBeat.o(42653);
            }
        });
        ab.d("MicroMsg.LuckyMoneyDetailUI", "after initview");
        AppMethodBeat.o(42688);
    }

    public void onBackPressed() {
        AppMethodBeat.i(42689);
        super.onBackPressed();
        AppMethodBeat.o(42689);
    }

    private void bMv() {
        AppMethodBeat.i(42690);
        ((i) g.K(i.class)).a((Context) this, this.emo, this.odZ.Aq(), getString(R.string.ct3), new q.a() {
            public final void a(boolean z, String str, int i) {
                int i2 = 1;
                AppMethodBeat.i(42655);
                LuckyMoneyDetailUI.this.aqX();
                LuckyMoneyDetailUI.this.oed = new y();
                if (z) {
                    LuckyMoneyDetailUI.this.oed.cVT = 5;
                    LuckyMoneyDetailUI.this.oee = new z();
                    if (LuckyMoneyDetailUI.this.oef == 0 || LuckyMoneyDetailUI.this.oef == 2) {
                        if (!com.tencent.mm.plugin.emoji.h.b.x(LuckyMoneyDetailUI.this.odZ)) {
                            i2 = com.tencent.mm.plugin.emoji.h.b.w(LuckyMoneyDetailUI.this.odZ) ? 3 : 2;
                        }
                    } else if (LuckyMoneyDetailUI.this.oef != 1) {
                        i2 = 0;
                    }
                    LuckyMoneyDetailUI.this.oee.cYk = (long) i2;
                    LuckyMoneyDetailUI.this.oee.eV(LuckyMoneyDetailUI.this.odZ.Aq());
                    if (bo.isNullOrNil(str)) {
                        LuckyMoneyDetailUI.this.oee.cYm = 1;
                    } else {
                        LuckyMoneyDetailUI.this.oee.cYm = 2;
                    }
                    LuckyMoneyDetailUI.this.oee.ajK();
                    LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.this.emo, str, LuckyMoneyDetailUI.this.odZ.Aq());
                    LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 3);
                    s.a(LuckyMoneyDetailUI.this.mController.ylL.getResources().getString(R.string.cbn), LuckyMoneyDetailUI.this.mController.ylL);
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42654);
                            LuckyMoneyDetailUI.this.finish();
                            AppMethodBeat.o(42654);
                        }
                    }, 500);
                } else {
                    LuckyMoneyDetailUI.this.oed.cVT = 6;
                }
                LuckyMoneyDetailUI.this.oed.ajK();
                AppMethodBeat.o(42655);
            }
        });
        AppMethodBeat.o(42690);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(42691);
        super.onKeyboardStateChanged();
        ab.d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", Integer.valueOf(this.mController.ymc));
        AppMethodBeat.o(42691);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(42692);
        if (keyEvent.getKeyCode() == 4 && this.ocC.getVisibility() == 0) {
            this.ocC.setVisibility(8);
            AppMethodBeat.o(42692);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(42692);
        return dispatchKeyEvent;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(42693);
        ab.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + mVar.getType());
        if (mVar instanceof af) {
            if (i == 0 && i2 == 0) {
                af afVar = (af) mVar;
                k kVar = afVar.nYn;
                this.ocP = afVar.nYz;
                this.kWO = afVar.nYA;
                this.odX = afVar.nYB;
                this.oeb = afVar.nYC;
                a(kVar);
                AppMethodBeat.o(42693);
                return true;
            }
            com.tencent.mm.ui.base.h.bQ(this, str);
            AppMethodBeat.o(42693);
            return true;
        } else if (mVar instanceof am) {
            if (i == 0 && i2 == 0) {
                this.ocO.nSz = false;
                bMt();
                am amVar = (am) mVar;
                if (this.nSx != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= this.nSx.size()) {
                            break;
                        }
                        w wVar = (w) this.nSx.get(z2);
                        if (wVar.nWX.equalsIgnoreCase(amVar.nWX)) {
                            wVar.nYb = amVar.nSd;
                            this.ocO.notifyDataSetChanged();
                            break;
                        }
                        z = z2 + 1;
                    }
                    if (this.odv.getVisibility() == 0) {
                        this.odv.setVisibility(8);
                    }
                    this.ocO.ck(this.nSx);
                }
                AppMethodBeat.o(42693);
                return true;
            }
            com.tencent.mm.ui.base.h.bQ(this, str);
            AppMethodBeat.o(42693);
            return true;
        } else if (!(mVar instanceof ar)) {
            AppMethodBeat.o(42693);
            return false;
        } else if (i == 0 && i2 == 0) {
            com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.cbn));
            AppMethodBeat.o(42693);
            return true;
        } else {
            com.tencent.mm.ui.base.h.bQ(this, str);
            AppMethodBeat.o(42693);
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(42694);
        String stringExtra;
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bo.isNullOrNil(stringExtra)) {
                        if (this.ocL != null && this.ocL.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            ab.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            n(new ar(stringExtra.replaceAll(",", "|"), this.ocI, "v1.0"));
                            break;
                        }
                    }
                }
                break;
            case FaceManager.FACE_ACQUIRED_HACKER /*1111*/:
                if (i2 != -1) {
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
                    break;
                }
                stringExtra = "";
                if (intent != null) {
                    stringExtra = intent.getStringExtra("gif_md5");
                }
                if (!bo.isNullOrNil(stringExtra)) {
                    aP(2, stringExtra);
                    bMv();
                    break;
                }
                ab.i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(42694);
    }

    public void finish() {
        AppMethodBeat.i(42695);
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            boolean b = realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(42663);
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
                    LuckyMoneyDetailUI.E(LuckyMoneyDetailUI.this);
                    AppMethodBeat.o(42663);
                }
            });
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b) {
                super.finish();
            }
        } else {
            super.finish();
        }
        overridePendingTransition(R.anim.db, R.anim.dg);
        AppMethodBeat.o(42695);
    }

    public final int getLayoutId() {
        return R.layout.aa1;
    }

    private void iK(boolean z) {
        AppMethodBeat.i(42696);
        ab.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", Boolean.TRUE);
        this.odI.setVisibility(8);
        this.oex = 1;
        if (z) {
            this.oeu = 3;
        } else {
            this.oeu--;
            if (this.oeu == 0) {
                ab.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
                this.odJ.setVisibility(8);
                this.odI.setVisibility(0);
                this.oex = 2;
                AppMethodBeat.o(42696);
                return;
            }
        }
        this.kZa = j.getEmojiStorageMgr().xYn.aqi(this.kWO);
        if (this.kZa == null) {
            this.kZa = new EmojiInfo();
            this.kZa.field_md5 = this.kWO;
            this.kZa.field_type = this.odX;
        } else if (com.tencent.mm.vfs.e.asZ(this.kZa.dve()) > 0 || this.kZa.xy() || this.kZa.duS()) {
            this.odH.setVisibility(0);
            z(this.kZa);
            AppMethodBeat.o(42696);
            return;
        }
        if (z) {
            this.odH.setVisibility(8);
            this.odJ.setVisibility(0);
            this.odK.setImageResource(R.raw.lucky_money_newyear_creat_loading);
            j.bkh().kVj = this.kVj;
        }
        j.bkh().s(this.kZa);
        g.RO().eJo.a(697, this.oev);
        AppMethodBeat.o(42696);
    }

    private void z(EmojiInfo emojiInfo) {
        AppMethodBeat.i(42697);
        this.oex = 3;
        this.odH.setEmojiInfo(emojiInfo);
        this.oec = new aa();
        this.oec.cVT = 11;
        this.oec.ajK();
        AppMethodBeat.o(42697);
    }

    private void xY(int i) {
        AppMethodBeat.i(42698);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.odr.getLayoutParams();
        switch (i) {
            case 1:
                layoutParams.topMargin = -BackwardSupportUtil.b.b(this.mController.ylL, 80.0f);
                break;
            case 2:
                layoutParams.topMargin = -BackwardSupportUtil.b.b(this.mController.ylL, 238.0f);
                break;
            case 3:
                layoutParams.topMargin = -BackwardSupportUtil.b.b(this.mController.ylL, 204.0f);
                break;
            case 4:
                layoutParams.topMargin = -BackwardSupportUtil.b.b(this.mController.ylL, 363.0f);
                break;
        }
        this.oew = layoutParams.topMargin;
        this.odr.setLayoutParams(layoutParams);
        this.odr.requestLayout();
        AppMethodBeat.o(42698);
    }

    private boolean bMw() {
        AppMethodBeat.i(42699);
        if (bo.isNullOrNil(this.kWO) || !(bo.gW(this.oeb.nXp, 1) || bo.gW(this.oeb.nXq, 1))) {
            AppMethodBeat.o(42699);
            return false;
        }
        AppMethodBeat.o(42699);
        return true;
    }

    private void a(final k kVar) {
        AppMethodBeat.i(42700);
        if (kVar == null) {
            AppMethodBeat.o(42700);
            return;
        }
        String str;
        String str2;
        boolean e = e(kVar);
        if (f(kVar)) {
            if (bMw()) {
                if (e) {
                    xY(1);
                } else {
                    xY(3);
                }
            } else if (e) {
                xY(2);
            } else {
                xY(4);
            }
        } else if (e) {
            if (bMw()) {
                xY(1);
            } else {
                xY(2);
            }
        } else if (bMw()) {
            xY(3);
        } else {
            xY(4);
        }
        if (bMw()) {
            this.odG.setVisibility(0);
            iK(true);
        } else {
            this.odG.setVisibility(8);
        }
        if (!bo.gW(this.oeb.nXr, 0) && e(kVar) && this.oeg) {
            this.odM.setOnClickListener(this.oet);
            this.odM.setTag("nodelete");
            this.odR.setOnClickListener(this.oet);
            this.odU.setOnClickListener(this.oet);
            this.odQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42656);
                    LuckyMoneyDetailUI.this.oed = new y();
                    LuckyMoneyDetailUI.this.oed.cVT = 7;
                    LuckyMoneyDetailUI.this.oed.ajK();
                    LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
                    AppMethodBeat.o(42656);
                }
            });
            this.odP.setOnClickListener(this.oet);
            str = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, (Object) "");
            xZ(1);
            if (!bo.isNullOrNil(str)) {
                aP(2, str);
            }
        } else {
            xZ(0);
        }
        if (kVar.nXa == 1) {
            e = true;
        } else {
            e = false;
        }
        this.ocG = e;
        if (kVar != null) {
            Object obj;
            Object obj2 = ((kVar.cRU == 3 || kVar.cRU == 2) && kVar.nWZ == 1 && !this.ocG && kVar.nXc == 1) ? 1 : null;
            if (kVar.nXd == null || kVar.nXd.erD != 1 || bo.isNullOrNil(kVar.nXd.nWy)) {
                obj = null;
            } else {
                obj = 1;
            }
            this.odA = (TextView) this.kZq.findViewById(R.id.cua);
            if (obj2 == null && obj == null) {
                this.odA.setVisibility(8);
            } else {
                this.odA.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(42674);
                        h.pYm.e(11701, Integer.valueOf(LuckyMoneyDetailUI.ya(kVar.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                        x.a(LuckyMoneyDetailUI.this, 1, false);
                        AppMethodBeat.o(42674);
                    }
                });
                if (obj != null) {
                    this.ocL = kVar.nXd.nWy;
                    this.odA.setText(kVar.nXd.nWz);
                }
                h.pYm.e(11701, Integer.valueOf(xW(kVar.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                this.odA.setVisibility(0);
            }
            this.nXi = kVar.nXi;
            this.odB = (TextView) this.kZq.findViewById(R.id.cub);
            this.odB.setVisibility(8);
            if (!this.ocQ) {
                this.nSL.addFooterView(this.kZq);
                this.ocQ = true;
            }
        }
        if (this.Lp == 0) {
            Object obj3;
            this.ocJ = kVar.nWX;
            str2 = this.ocJ;
            if (kVar == null || kVar.cRT != 0 || kVar.nXj == null || kVar.nXj.size() <= 0 || !((w) kVar.nXj.get(0)).nWX.equals(str2) || kVar.nWY == 1) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (obj3 != null) {
                this.ocO.nSz = false;
                this.odv.setVisibility(0);
                this.odw.setVisibility(8);
            } else {
                this.odv.setVisibility(8);
                this.odw.setVisibility(0);
                if (f(kVar) && !e(kVar)) {
                    this.odx.setVisibility(8);
                    this.ody.setVisibility(8);
                    this.odz.setVisibility(8);
                }
                this.ocO.nSy = this.ocJ;
            }
            this.ocO.nSA = kVar.nXi;
            if (kVar != null) {
                Context context = this.mController.ylL;
                if (kVar.nXi == 2) {
                    this.nSM.setImageResource(R.drawable.b8q);
                    if (kVar.resourceId != 0) {
                        ab.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + kVar.resourceId);
                        final com.tencent.mm.sdk.b.b hqVar = new hq();
                        hqVar.cCx.cCz = kVar.resourceId;
                        hqVar.callback = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(42669);
                                if (hqVar.cCy.cCA) {
                                    ab.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + hqVar.cCy.cCB);
                                    x.m(LuckyMoneyDetailUI.this.nSM, hqVar.cCy.cCB);
                                    AppMethodBeat.o(42669);
                                    return;
                                }
                                ab.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                                x.b(LuckyMoneyDetailUI.this.nSM, kVar.nWR, kVar.nXl);
                                AppMethodBeat.o(42669);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xxA.a(hqVar, Looper.myLooper());
                    } else {
                        x.b(this.nSM, kVar.nWR, kVar.nXl);
                    }
                } else {
                    x.b(this.nSM, kVar.nWR, kVar.nXl);
                }
                String string = getString(R.string.cts, new Object[]{kVar.nWQ});
                this.nSN.setMaxWidth(((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() - BackwardSupportUtil.b.b(this.mController.ylL, 92.0f));
                x.a(context, this.nSN, string);
                x.a(context, this.nsq, kVar.nSd);
                if (kVar.cRT == 1) {
                    this.nSO.setVisibility(0);
                    this.nSO.setImageResource(R.drawable.b9s);
                } else if (kVar.cRT == 2) {
                    if (!t.mY(kVar.nXl)) {
                        com.tencent.mm.ah.h hVar = new com.tencent.mm.ah.h();
                        hVar.username = kVar.nXl;
                        o.act().b(hVar);
                    }
                    this.nSO.setVisibility(0);
                    this.nSO.setImageResource(R.drawable.b9j);
                } else {
                    this.nSO.setVisibility(8);
                }
                if (!bo.isNullOrNil(kVar.nXg)) {
                    x.l(this.odr, kVar.nXg);
                    this.odr.setScaleType(ScaleType.FIT_XY);
                }
                if (bo.isNullOrNil(kVar.nXh)) {
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
                    this.odD.setVisibility(8);
                } else {
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", kVar.nXh);
                    this.odD.setVisibility(4);
                    x.h(this.lBT, kVar.nXh);
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42670);
                            LuckyMoneyDetailUI.O(LuckyMoneyDetailUI.this);
                            LuckyMoneyDetailUI.this.odD.setVisibility(0);
                            AppMethodBeat.o(42670);
                        }
                    }, 500);
                }
                if (kVar.cRV != 2 || this.ocH == 3) {
                    this.nSP.setVisibility(8);
                } else {
                    this.nSD.setText(com.tencent.mm.wallet_core.ui.e.F(((double) kVar.cSh) / 100.0d));
                    this.ocO.nSz = false;
                    this.nSP.setVisibility(0);
                }
                if (bo.isNullOrNil(kVar.nUj)) {
                    ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                    this.nSQ.setVisibility(8);
                } else {
                    this.nSQ.setVisibility(0);
                    this.kGq.setText(kVar.nUj);
                    if (kVar.nUh == 1) {
                        ab.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", kVar.nXn);
                        if (bo.isNullOrNil(kVar.nXn)) {
                            this.odq.setVisibility(8);
                        } else {
                            this.odq.setUrl(kVar.nXn);
                            this.odq.setVisibility(0);
                        }
                        this.kGq.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(42673);
                                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, kVar);
                                AppMethodBeat.o(42673);
                            }
                        });
                    } else {
                        ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                        this.kGq.setTextColor(getResources().getColor(R.color.tu));
                    }
                }
                if (bo.isNullOrNil(kVar.nXb)) {
                    this.kEq.setText(null);
                    this.odw.setVisibility(8);
                } else {
                    this.kEq.setText(kVar.nXb);
                    this.odw.setVisibility(0);
                    if (f(kVar) && !e(kVar)) {
                        this.odx.setVisibility(8);
                        this.ody.setVisibility(8);
                        this.odz.setVisibility(8);
                    }
                }
            }
            if (kVar != null) {
                LinkedList linkedList = kVar.nXe;
                if (linkedList != null && linkedList.size() > 0) {
                    View findViewById = this.abB.findViewById(R.id.cus);
                    View findViewById2 = this.abB.findViewById(R.id.cuv);
                    View findViewById3 = this.abB.findViewById(R.id.cuy);
                    ViewGroup viewGroup = (ViewGroup) this.abB.findViewById(R.id.cut);
                    ViewGroup viewGroup2 = (ViewGroup) this.abB.findViewById(R.id.cuw);
                    ViewGroup viewGroup3 = (ViewGroup) this.abB.findViewById(R.id.cuz);
                    View findViewById4 = this.abB.findViewById(R.id.cuu);
                    View findViewById5 = this.abB.findViewById(R.id.cux);
                    h.c cVar = new h.c();
                    cVar.textColor = getResources().getColor(R.color.tw);
                    if (linkedList.size() > 0) {
                        h.a(this, viewGroup, (as) linkedList.get(0), cVar);
                        findViewById.setVisibility(0);
                    }
                    if (linkedList.size() > 1) {
                        h.a(this, viewGroup2, (as) linkedList.get(1), cVar);
                        findViewById2.setVisibility(0);
                    }
                    if (linkedList.size() > 2) {
                        h.a(this, viewGroup3, (as) linkedList.get(2), cVar);
                        findViewById3.setVisibility(0);
                    }
                    if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                        findViewById4.setVisibility(0);
                    }
                    if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                        findViewById5.setVisibility(0);
                    }
                    if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                        this.ocE.requestLayout();
                        this.ocE.setVisibility(0);
                    }
                }
                this.odC = (ViewGroup) this.kZq.findViewById(R.id.cuc);
                h.c cVar2 = new h.c();
                cVar2.textColor = getResources().getColor(R.color.rr);
                cVar2.textSize = getResources().getDimensionPixelSize(R.dimen.kr);
                h.a(this, this.odC, kVar.nXf, cVar2);
                cVar2 = new h.c();
                cVar2.textColor = Color.parseColor("#0C4F8E");
                cVar2.textSize = getResources().getDimensionPixelSize(R.dimen.kr);
                if (kVar.nXo != null) {
                    at Ql = at.Ql(kVar.nXo);
                    if (!(Ql == null || Ql.nZp == null)) {
                        cVar2.ogN = Ql.nWu;
                        h.a(this, this.odC, Ql.nZp, cVar2);
                        h hVar2 = h.pYm;
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(1);
                        objArr[1] = Ql.nZp.content;
                        objArr[2] = Ql.nWu != null ? Ql.nWu.wwP : "";
                        hVar2.e(16589, objArr);
                    }
                }
                if (!this.oep) {
                    this.oep = true;
                    this.kZq.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42675);
                            LuckyMoneyDetailUI.this.oeq = LuckyMoneyDetailUI.this.kZq.getHeight();
                            ab.d("MicroMsg.LuckyMoneyDetailUI", "get footer height: %s", Integer.valueOf(LuckyMoneyDetailUI.this.oeq));
                            AppMethodBeat.o(42675);
                        }
                    });
                }
                ab.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
                this.kZq.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42676);
                        if (LuckyMoneyDetailUI.this.odC.getVisibility() == 8 && LuckyMoneyDetailUI.this.odB.getVisibility() == 8 && LuckyMoneyDetailUI.this.odA.getVisibility() == 8) {
                            LuckyMoneyDetailUI.this.nSL.removeFooterView(LuckyMoneyDetailUI.this.kZq);
                            AppMethodBeat.o(42676);
                            return;
                        }
                        int ge = (com.tencent.mm.bz.a.ge(LuckyMoneyDetailUI.this.mController.ylL) - ak.hF(LuckyMoneyDetailUI.this)) - com.tencent.mm.pluginsdk.f.de(LuckyMoneyDetailUI.this);
                        int measuredHeight = LuckyMoneyDetailUI.this.nSL.getMeasuredHeight();
                        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(LuckyMoneyDetailUI.this.mController.ylL, 29);
                        int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(LuckyMoneyDetailUI.this.mController.ylL, 16);
                        if (measuredHeight < ge) {
                            LuckyMoneyDetailUI.this.kZq.setPadding(0, fromDPToPix + (ge - LuckyMoneyDetailUI.this.nSL.getMeasuredHeight()), 0, fromDPToPix2);
                        } else {
                            LuckyMoneyDetailUI.this.kZq.setPadding(0, fromDPToPix, 0, fromDPToPix2);
                        }
                        ab.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s showHeight:%s recordHeight:%s", Integer.valueOf(r0), Integer.valueOf(ge), Integer.valueOf(measuredHeight));
                        AppMethodBeat.o(42676);
                    }
                });
            }
            h.pYm.e(11701, Integer.valueOf(xW(kVar.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        }
        LinkedList linkedList2 = kVar.nXj;
        if (linkedList2 != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= linkedList2.size()) {
                    break;
                }
                w wVar = (w) linkedList2.get(i2);
                if (!this.ocN.containsKey(wVar.nWX)) {
                    this.nSx.add(linkedList2.get(i2));
                    this.ocN.put(wVar.nWX, Integer.valueOf(1));
                }
                i = i2 + 1;
            }
            this.Lp += linkedList2.size();
            this.hZu = false;
            if (this.odv.getVisibility() != 0) {
                this.ocO.ck(this.nSx);
            }
        }
        if (kVar.cRT == 2 && !bo.isNullOrNil(kVar.nWP)) {
            this.nTR = new SoundPool(2, 3, 0);
            this.odE = new int[2];
            try {
                this.odE[0] = this.nTR.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
                this.odE[1] = this.nTR.load(getResources().getAssets().openFd("whistle.m4a"), 0);
            } catch (IOException e2) {
                ab.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + e2.getMessage());
            }
            this.nTR.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                    AppMethodBeat.i(42666);
                    if (i2 == 0) {
                        if (i == LuckyMoneyDetailUI.this.odE[0]) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                            AppMethodBeat.o(42666);
                            return;
                        } else if (i == LuckyMoneyDetailUI.this.odE[1] && kVar.cSh >= 19000) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                    }
                    AppMethodBeat.o(42666);
                }
            });
            this.abB.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(42667);
                    ViewGroup J = LuckyMoneyDetailUI.this.odF;
                    b K = LuckyMoneyDetailUI.this.nVt;
                    com.tencent.mm.plugin.luckymoney.particles.a aVar = new com.tencent.mm.plugin.luckymoney.particles.a(J);
                    com.tencent.mm.plugin.luckymoney.particles.c aH = new com.tencent.mm.plugin.luckymoney.particles.c(J.getContext(), K, new com.tencent.mm.plugin.luckymoney.particles.d(-100, J.getHeight() / 2), J).R(600.0f, 150.0f).S(-1000.0f, 250.0f).aG(-200.0f).aH(1500.0f);
                    aH.oal = 600.0f;
                    aH.oam = 300.0f;
                    aH = aH.bLH();
                    aH.nZO = com.tencent.mm.plugin.luckymoney.particles.e.bLQ();
                    aVar.nZD = aH.bLI().bLJ();
                    aVar.P(100, 400);
                    J = LuckyMoneyDetailUI.this.odF;
                    K = LuckyMoneyDetailUI.this.nVt;
                    aVar = new com.tencent.mm.plugin.luckymoney.particles.a(J);
                    aH = new com.tencent.mm.plugin.luckymoney.particles.c(J.getContext(), K, new com.tencent.mm.plugin.luckymoney.particles.d(J.getWidth() + 100, J.getHeight() / 2), J).R(-600.0f, 150.0f).S(-1000.0f, 250.0f).aG(200.0f).aH(1500.0f);
                    aH.oal = 600.0f;
                    aH.oam = 300.0f;
                    aH = aH.bLH();
                    aH.nZO = com.tencent.mm.plugin.luckymoney.particles.e.bLQ();
                    aVar.nZD = aH.bLI().bLJ();
                    aVar.P(100, 400);
                    AppMethodBeat.o(42667);
                }
            }, 300);
        }
        com.tencent.mm.plugin.wallet_core.model.ab abVar = new com.tencent.mm.plugin.wallet_core.model.ab();
        abVar.field_mNativeUrl = this.ocK;
        abVar.field_hbType = kVar.cRT;
        abVar.field_receiveAmount = kVar.cSh;
        abVar.field_receiveTime = System.currentTimeMillis();
        abVar.field_hbStatus = kVar.cRU;
        abVar.field_receiveStatus = kVar.cRV;
        if (abVar.field_receiveAmount > 0) {
            r.cPF().a(abVar);
        }
        if (kVar.nXo != null) {
            at Ql2 = at.Ql(kVar.nXo);
            if (!(Ql2 == null || Ql2.nWu == null)) {
                ImageView imageView = (ImageView) findViewById(R.id.cvr);
                ImageView imageView2 = (ImageView) findViewById(R.id.cvs);
                this.abB.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42668);
                        ab.d("MicroMsg.LuckyMoneyDetailUI", "header height: %s", Integer.valueOf(BackwardSupportUtil.b.b(LuckyMoneyDetailUI.this.mController.ylL, 526.0f) + LuckyMoneyDetailUI.this.oew));
                        LayoutParams layoutParams = LuckyMoneyDetailUI.this.oer.getLayoutParams();
                        layoutParams.height = r0;
                        LuckyMoneyDetailUI.this.oer.setLayoutParams(layoutParams);
                        AppMethodBeat.o(42668);
                    }
                });
                ((com.tencent.mm.plugin.luckymoney.a.a) g.K(com.tencent.mm.plugin.luckymoney.a.a.class)).b(imageView, Ql2.nWu);
                imageView.setVisibility(0);
                imageView2.setVisibility(0);
                if (!this.odW) {
                    this.odW = true;
                    str = Ql2.nWu.wwQ != null ? Ql2.nWu.wwQ.wwX : "";
                    str2 = kVar.nXl;
                    h.pYm.e(16598, Integer.valueOf(3), Ql2.nWu.wwP, str, str2);
                }
            }
        }
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.hide();
        }
        AppMethodBeat.o(42700);
    }

    private void xZ(int i) {
        AppMethodBeat.i(42701);
        aP(i, "");
        AppMethodBeat.o(42701);
    }

    private void aP(int i, String str) {
        AppMethodBeat.i(42702);
        switch (i) {
            case 0:
                this.odL.setVisibility(8);
                AppMethodBeat.o(42702);
                return;
            case 1:
                this.odL.setVisibility(0);
                this.odM.setVisibility(0);
                this.odN.setVisibility(8);
                this.odO.setVisibility(8);
                g.RP().Ry().set(ac.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, (Object) "");
                AppMethodBeat.o(42702);
                return;
            case 2:
                if (!bo.isNullOrNil(str)) {
                    EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(str);
                    if (aqi != null) {
                        this.odZ = aqi;
                        g.RP().Ry().set(ac.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, this.odZ.Aq());
                        this.odP.setEmojiInfo(this.odZ);
                        this.odL.setVisibility(0);
                        this.odM.setVisibility(8);
                        this.odN.setVisibility(0);
                        this.odO.setVisibility(8);
                        break;
                    }
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
                    AppMethodBeat.o(42702);
                    return;
                }
                break;
        }
        AppMethodBeat.o(42702);
    }

    private boolean e(k kVar) {
        if (kVar.cRV != 2 || this.ocH == 3) {
            return false;
        }
        return true;
    }

    private static boolean f(k kVar) {
        if (kVar.nWZ == 1) {
            return true;
        }
        return false;
    }

    private void bMt() {
        AppMethodBeat.i(42703);
        if (!(this.ocC == null || this.ocC.getVisibility() == 8)) {
            this.ocC.setVisibility(8);
        }
        AppMethodBeat.o(42703);
    }

    public void onDestroy() {
        AppMethodBeat.i(42704);
        super.onDestroy();
        if (this.oex == 1 || this.oex == 2) {
            this.oec = new aa();
            this.oec.cVT = 12;
            this.oec.ajK();
        }
        if (this.ocC != null) {
            this.ocC.bMO();
        }
        if (this.nTR != null) {
            this.nTR.release();
            for (int unload : this.odE) {
                this.nTR.unload(unload);
            }
        }
        if (this.odY != null) {
            ab.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
            this.odY.onPause();
            this.odY.AC();
            this.odY.destroy();
        }
        j.bkh().kVj = null;
        g.RO().eJo.b(697, this.oev);
        AppMethodBeat.o(42704);
    }

    private static int xW(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }

    static /* synthetic */ void d(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(42705);
        luckyMoneyDetailUI.hZu = true;
        luckyMoneyDetailUI.gII = com.tencent.mm.ui.base.h.a(luckyMoneyDetailUI.mController.ylL, 3, luckyMoneyDetailUI.getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(42665);
                if (LuckyMoneyDetailUI.this.gII != null && LuckyMoneyDetailUI.this.gII.isShowing()) {
                    LuckyMoneyDetailUI.this.gII.dismiss();
                }
                LuckyMoneyDetailUI.this.ocz.bLz();
                if (LuckyMoneyDetailUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyDetailUI.this.mController.contentView.getVisibility() == 4) {
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "user cancel & finish");
                    LuckyMoneyDetailUI.this.finish();
                }
                AppMethodBeat.o(42665);
            }
        });
        if (luckyMoneyDetailUI.Lp <= 0 || luckyMoneyDetailUI.nSx.size() <= 0 || luckyMoneyDetailUI.nSx.get(luckyMoneyDetailUI.nSx.size() - 1) == null) {
            luckyMoneyDetailUI.ocP = "";
            luckyMoneyDetailUI.b(new af(luckyMoneyDetailUI.ocI, 11, luckyMoneyDetailUI.Lp, luckyMoneyDetailUI.ocK, "v1.0", luckyMoneyDetailUI.ocP), false);
            AppMethodBeat.o(42705);
            return;
        }
        luckyMoneyDetailUI.b(new af(luckyMoneyDetailUI.ocI, luckyMoneyDetailUI.Lp, luckyMoneyDetailUI.ocK, bo.getLong(((w) luckyMoneyDetailUI.nSx.get(luckyMoneyDetailUI.nSx.size() - 1)).nXN, 0), "v1.0", luckyMoneyDetailUI.ocP), false);
        AppMethodBeat.o(42705);
    }

    static /* synthetic */ void s(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(42711);
        com.tencent.mm.plugin.luckymoney.ui.a.a.a(luckyMoneyDetailUI, luckyMoneyDetailUI.odY);
        luckyMoneyDetailUI.odS.dismiss();
        AppMethodBeat.o(42711);
    }

    static /* synthetic */ void a(LuckyMoneyDetailUI luckyMoneyDetailUI, String str, String str2, String str3) {
        AppMethodBeat.i(42712);
        String str4 = "MicroMsg.LuckyMoneyDetailUI";
        String str5 = "doTransmitEmojiToFriend() toUser:%s customTex:%s emojiMd5:%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(str2 == null);
        objArr[2] = str3;
        ab.i(str4, str5, objArr);
        if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(luckyMoneyDetailUI, str, str3)) {
            ab.i("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() success!");
            if (!TextUtils.isEmpty(str2)) {
                qb qbVar = new qb();
                qbVar.cMq.cMr = str;
                qbVar.cMq.content = str2;
                qbVar.cMq.type = t.nK(str);
                qbVar.cMq.flags = 0;
                com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                AppMethodBeat.o(42712);
                return;
            }
        }
        ab.e("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() failed!");
        AppMethodBeat.o(42712);
    }

    static /* synthetic */ void C(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        int i;
        AppMethodBeat.i(42716);
        luckyMoneyDetailUI.oef = 2;
        luckyMoneyDetailUI.oed = new y();
        luckyMoneyDetailUI.oed.cVT = 3;
        luckyMoneyDetailUI.oed.ajK();
        luckyMoneyDetailUI.odS.show();
        if (bo.gW(luckyMoneyDetailUI.oeb.nXs, 0)) {
            i = ChatFooterPanel.vhp;
        } else {
            i = ChatFooterPanel.vhs;
        }
        com.tencent.mm.plugin.luckymoney.ui.a.a.a(luckyMoneyDetailUI.oea, luckyMoneyDetailUI.odY, i, new com.tencent.mm.api.t.a() {
            public final void a(com.tencent.mm.api.k kVar) {
                AppMethodBeat.i(42657);
                ab.i("MicroMsg.LuckyMoneyDetailUI", "[onSelectedEmoji] emojiInfo:%s", kVar);
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, kVar.Aq());
                LuckyMoneyDetailUI.B(LuckyMoneyDetailUI.this);
                LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(42657);
            }

            public final void onHide() {
                AppMethodBeat.i(138989);
                LuckyMoneyDetailUI.s(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(138989);
            }
        });
        AppMethodBeat.o(42716);
    }

    static /* synthetic */ void O(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(42718);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = luckyMoneyDetailUI.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            ab.i("MicroMsg.LuckyMoneyDetailUI", "hy: screen  width: %d, scale : %f, fixedHeight: %d", Integer.valueOf(displayMetrics.widthPixels), Double.valueOf(((double) displayMetrics.widthPixels) / 750.0d), Integer.valueOf((int) (240.0d * (((double) displayMetrics.widthPixels) / 750.0d))));
            luckyMoneyDetailUI.odD.setLayoutParams(new LinearLayout.LayoutParams(luckyMoneyDetailUI.odD.getLayoutParams().width, r1));
        }
        AppMethodBeat.o(42718);
    }
}
