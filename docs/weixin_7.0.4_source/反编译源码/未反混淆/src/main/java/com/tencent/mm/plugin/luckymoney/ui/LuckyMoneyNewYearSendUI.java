package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t;
import com.tencent.mm.emoji.d.b;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.l;
import com.tencent.mm.g.b.a.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@a(3)
public class LuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    public static int mState;
    public static int ogj = 0;
    private int cKs = 0;
    private Dialog gII = null;
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(42813);
            if (view.getId() == R.id.cy1) {
                h.pYm.e(13079, Integer.valueOf(5), Integer.valueOf(1));
                ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
                LuckyMoneyNewYearSendUI.b(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(42813);
            } else if (view.getId() == R.id.cy2) {
                LuckyMoneyNewYearSendUI.this.finish();
                h.pYm.e(13079, Integer.valueOf(6), Integer.valueOf(1));
                LuckyMoneyNewYearSendUI.this.ofZ = new l();
                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 11;
                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(42813);
            } else if (view.getId() == R.id.cxo || view.getId() == R.id.cxp) {
                LuckyMoneyNewYearSendUI.this.ofZ = new l();
                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 3;
                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(42813);
            } else if (view.getId() == R.id.cxt) {
                LuckyMoneyNewYearSendUI.this.kZa = null;
                LuckyMoneyNewYearSendUI.this.ofY = null;
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
                g.RP().Ry().set(ac.a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, (Object) "");
                h.pYm.e(13079, Integer.valueOf(3), Integer.valueOf(1));
                LuckyMoneyNewYearSendUI.this.ofZ = new l();
                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 5;
                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                AppMethodBeat.o(42813);
            } else if (view.getId() == R.id.cy0) {
                LuckyMoneyAutoScrollView h = LuckyMoneyNewYearSendUI.this.ofi;
                h.ocw = false;
                h.ock.setVisibility(0);
                h.ocl.setVisibility(0);
                h.ocm.setVisibility(0);
                h.ocq.setVisibility(4);
                h.ocr.setVisibility(4);
                h.ocs.setVisibility(4);
                LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
                h.pYm.e(13079, Integer.valueOf(4), Integer.valueOf(1));
                LuckyMoneyNewYearSendUI.this.ofZ = new l();
                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 2;
                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                AppMethodBeat.o(42813);
            } else if (view.getId() == R.id.cxu) {
                d dVar = d.eAh;
                d.eY(LuckyMoneyNewYearSendUI.this.ogh);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, false);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 4);
                AppMethodBeat.o(42813);
            } else {
                if (view.getId() == R.id.cxs) {
                    LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
                }
                AppMethodBeat.o(42813);
            }
        }
    };
    private EmojiInfo kZa;
    private Button leS;
    private ak mHandler = new ak();
    private String nYD;
    private int nYF;
    private int nYM = 0;
    private LinkedList<u> nYP;
    private TextView nsq;
    private int obG;
    private String obK;
    private int obL;
    private String ocI = "";
    private a odS;
    private View odT;
    private ChatFooterPanel odY;
    private ViewGroup oea;
    private int oef = 0;
    private View ofJ;
    private View ofK;
    private TextView ofL;
    private ImageView ofM;
    private TextView ofN;
    private ImageView ofO;
    private ImageView ofP;
    private TextView ofQ;
    private LinearLayout ofR;
    private MMAnimateView ofS;
    private LinearLayout ofT;
    private String ofU;
    private boolean ofV = true;
    private int ofW = 0;
    private int ofX = 0;
    private EmojiInfo ofY;
    private l ofZ;
    private LuckyMoneyAutoScrollView ofi;
    private TextView ofj;
    private ImageView ofw;
    private View ofx;
    private BaseEmojiView ofy;
    private m oga;
    private int ogb = 1;
    private int ogc = 0;
    private int ogd = 0;
    private int oge = 0;
    private int ogf = 0;
    private int ogg = 0;
    private long ogh = 0;
    private String ogi = "";
    private int ogk = 0;
    private com.tencent.mm.emoji.d.a ogl = new com.tencent.mm.emoji.d.a() {
        public final void a(long j, boolean z, String str) {
            int i = 0;
            AppMethodBeat.i(42811);
            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", Long.valueOf(LuckyMoneyNewYearSendUI.this.ogh), Long.valueOf(j), Boolean.valueOf(z), str);
            if (bo.af(LuckyMoneyNewYearSendUI.this.ogh, j)) {
                if (z) {
                    LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, str);
                } else {
                    if (bo.gW(LuckyMoneyNewYearSendUI.this.ogk, 0)) {
                        EmojiInfo mU = at.dsZ().xYn.mU(LuckyMoneyNewYearSendUI.this.ogh);
                        if (mU != null && mU.duZ() == EmojiInfo.a.STATUS_UPLOAD_FAIL) {
                            switch (com.tencent.mm.plugin.emoji.h.b.AnonymousClass1.lgJ[mU.dvc().ordinal()]) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    i = 1;
                                    break;
                            }
                        }
                        if (i != 0) {
                            LuckyMoneyNewYearSendUI.this.ogk = LuckyMoneyNewYearSendUI.this.ogk + 1;
                            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 3);
                            AppMethodBeat.o(42811);
                            return;
                        }
                    }
                    LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 5);
                }
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, true);
                b bVar = b.ezV;
                b.b(LuckyMoneyNewYearSendUI.this.ogh, LuckyMoneyNewYearSendUI.this.ogl);
            }
            AppMethodBeat.o(42811);
        }
    };
    private String ogm = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyNewYearSendUI() {
        AppMethodBeat.i(42823);
        AppMethodBeat.o(42823);
    }

    static /* synthetic */ void d(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(42839);
        luckyMoneyNewYearSendUI.yd(2);
        AppMethodBeat.o(42839);
    }

    static /* synthetic */ void i(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(42842);
        luckyMoneyNewYearSendUI.bMG();
        AppMethodBeat.o(42842);
    }

    static /* synthetic */ void n(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(42845);
        luckyMoneyNewYearSendUI.bMF();
        AppMethodBeat.o(42845);
    }

    static /* synthetic */ void w(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(42846);
        luckyMoneyNewYearSendUI.yf(1);
        AppMethodBeat.o(42846);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42824);
        super.onCreate(bundle);
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
        this.ofU = getIntent().getStringExtra("key_username");
        this.obG = getIntent().getIntExtra("key_way", 0);
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        if (bo.isNullOrNil(this.ofU)) {
            ab.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        initView();
        n(new ag("v1.0", ((Integer) g.RP().Ry().get(ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(0))).intValue()));
        h.pYm.e(13079, Integer.valueOf(1), Integer.valueOf(1));
        AppMethodBeat.o(42824);
    }

    public void onDestroy() {
        AppMethodBeat.i(42825);
        super.onDestroy();
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
        }
        if (this.odY != null) {
            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
            this.odY.onPause();
            this.odY.AC();
            this.odY.destroy();
        }
        b bVar = b.ezV;
        b.b(this.ogh, this.ogl);
        AppMethodBeat.o(42825);
    }

    public final void initView() {
        AppMethodBeat.i(42826);
        xE(-839716110);
        AM(8);
        this.ofJ = findViewById(R.id.cxl);
        this.ofj = (TextView) findViewById(R.id.cxz);
        this.ofi = (LuckyMoneyAutoScrollView) findViewById(R.id.cxy);
        this.nsq = (TextView) findViewById(R.id.cxx);
        this.leS = (Button) findViewById(R.id.cy1);
        this.leS.setOnClickListener(this.gKK);
        ((ImageView) findViewById(R.id.cy2)).setOnClickListener(this.gKK);
        this.ofw = (ImageView) findViewById(R.id.cxm);
        this.ofK = findViewById(R.id.cxn);
        this.ofL = (TextView) findViewById(R.id.cxp);
        this.ofM = (ImageView) findViewById(R.id.cxo);
        this.ofM.setOnClickListener(this.gKK);
        this.ofN = (TextView) findViewById(R.id.cxp);
        this.ofN.setOnClickListener(this.gKK);
        this.ofx = findViewById(R.id.cxq);
        this.ofy = (BaseEmojiView) findViewById(R.id.cxs);
        this.ofy.setOnClickListener(this.gKK);
        this.ofP = (ImageView) findViewById(R.id.cxt);
        this.ofP.setOnClickListener(this.gKK);
        this.ofO = (ImageView) findViewById(R.id.cxr);
        this.ofQ = (TextView) findViewById(R.id.cxu);
        this.ofQ.setOnClickListener(this.gKK);
        this.ofR = (LinearLayout) findViewById(R.id.cxv);
        this.ofS = (MMAnimateView) findViewById(R.id.cxw);
        this.ofT = (LinearLayout) findViewById(R.id.cy0);
        this.ofT.setOnClickListener(this.gKK);
        this.odS = new a(this);
        this.odT = getLayoutInflater().inflate(R.layout.aa3, null);
        this.odS.setContentView(this.odT, new LayoutParams(-1, -1));
        this.odT.findViewById(R.id.cvw).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42808);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(42808);
            }
        });
        this.odS.obT = new a() {
            public final void bMl() {
                AppMethodBeat.i(42812);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(42812);
            }
        };
        this.oea = (ViewGroup) this.odT.findViewById(R.id.cvy);
        this.odY = e.vom.dF(this.mController.ylL);
        com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.odY);
        AppMethodBeat.o(42826);
    }

    public void onBackPressed() {
        AppMethodBeat.i(42827);
        yd(2);
        finish();
        AppMethodBeat.o(42827);
    }

    private void yd(int i) {
        AppMethodBeat.i(42828);
        this.oga = new m();
        this.oga.cVU = (long) i;
        this.oga.cVV = (long) this.ogb;
        this.oga.cVW = (long) this.ogc;
        this.oga.cVX = (long) this.ogd;
        this.oga.cVY = (long) this.oge;
        this.oga.cWb = (long) this.ogf;
        this.oga.cVZ = (long) this.ogg;
        this.oga.eE(this.kZa == null ? "" : this.kZa.Aq());
        this.oga.ajK();
        AppMethodBeat.o(42828);
    }

    private void bMF() {
        int i;
        AppMethodBeat.i(42829);
        this.ofZ = new l();
        this.ofZ.cVT = 10;
        this.ofZ.ajK();
        this.oef = 2;
        this.odS.show();
        if (bo.gW(this.ofW, 1)) {
            i = ChatFooterPanel.vhq;
        } else {
            i = ChatFooterPanel.vhn;
        }
        com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.oea, this.odY, i, new t.a() {
            public final void a(k kVar) {
                AppMethodBeat.i(42814);
                ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", kVar);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, kVar);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(42814);
            }

            public final void onHide() {
                AppMethodBeat.i(138990);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(138990);
            }
        });
        AppMethodBeat.o(42829);
    }

    private void Qo(String str) {
        AppMethodBeat.i(42830);
        this.kZa = j.getEmojiStorageMgr().xYn.aqi(str);
        this.ofy.setEmojiInfo(this.kZa);
        ye(2);
        g.RP().Ry().set(ac.a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, (Object) str);
        AppMethodBeat.o(42830);
    }

    private void ye(int i) {
        AppMethodBeat.i(42831);
        if (ogj != 0) {
            i = mState;
        }
        if (bo.gW(this.nYM, 0)) {
            this.ofw.setVisibility(0);
            this.ofK.setVisibility(8);
            this.ofx.setVisibility(8);
            AppMethodBeat.o(42831);
            return;
        }
        this.ofw.setVisibility(8);
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", Integer.valueOf(i));
        switch (i) {
            case 0:
                this.ofK.setVisibility(0);
                this.ofL.setText(R.string.cpy);
                this.ofx.setVisibility(8);
                AppMethodBeat.o(42831);
                return;
            case 1:
                this.ofK.setVisibility(8);
                this.ofx.setVisibility(0);
                this.ofO.setVisibility(0);
                this.ofy.setVisibility(8);
                this.ofP.setVisibility(8);
                this.ofQ.setVisibility(8);
                this.ofR.setVisibility(8);
                AppMethodBeat.o(42831);
                return;
            case 2:
                if (this.ofY != null) {
                    this.ofZ = new l();
                    this.ofZ.cVT = 4;
                    this.ofZ.ajK();
                }
                this.ofY = this.kZa;
                if (this.oef == 0) {
                    if (com.tencent.mm.plugin.emoji.h.b.x(this.kZa)) {
                        this.ogb = 2;
                    } else if (com.tencent.mm.plugin.emoji.h.b.w(this.kZa)) {
                        this.ogb = 4;
                    } else {
                        this.ogb = 3;
                    }
                } else if (this.oef == 1) {
                    this.ogb = 2;
                    this.ogd++;
                } else if (this.oef == 2) {
                    if (com.tencent.mm.plugin.emoji.h.b.x(this.kZa)) {
                        this.ogb = 2;
                        this.ogg++;
                    } else if (com.tencent.mm.plugin.emoji.h.b.w(this.kZa)) {
                        this.ogb = 4;
                        this.ogf++;
                    } else {
                        this.ogb = 3;
                        this.oge++;
                    }
                }
                this.ofK.setVisibility(8);
                this.ofx.setVisibility(0);
                this.ofO.setVisibility(8);
                this.ofy.setVisibility(0);
                this.ofP.setVisibility(0);
                this.ofQ.setVisibility(8);
                this.ofR.setVisibility(8);
                AppMethodBeat.o(42831);
                return;
            case 3:
                this.ofK.setVisibility(8);
                this.ofx.setVisibility(0);
                this.ofO.setVisibility(8);
                this.ofy.setVisibility(8);
                this.ofP.setVisibility(8);
                this.ofQ.setVisibility(0);
                this.ofR.setVisibility(8);
                AppMethodBeat.o(42831);
                return;
            case 4:
                this.ofK.setVisibility(8);
                this.ofx.setVisibility(0);
                this.ofO.setVisibility(8);
                this.ofy.setVisibility(8);
                this.ofP.setVisibility(8);
                this.ofQ.setVisibility(8);
                this.ofR.setVisibility(0);
                this.ofS.setImageResource(R.raw.lucky_money_newyear_creat_loading);
                AppMethodBeat.o(42831);
                return;
            case 5:
                this.ofK.setVisibility(0);
                this.ofL.setText(R.string.crt);
                this.ofx.setVisibility(8);
                break;
        }
        AppMethodBeat.o(42831);
    }

    public final int getLayoutId() {
        return R.layout.aad;
    }

    private void yf(int i) {
        AppMethodBeat.i(42832);
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
        h.pYm.e(11701, Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
        if (this.gII == null) {
            this.gII = com.tencent.mm.wallet_core.ui.g.a(this.mController.ylL, true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(42818);
                    if (LuckyMoneyNewYearSendUI.this.gII != null && LuckyMoneyNewYearSendUI.this.gII.isShowing()) {
                        LuckyMoneyNewYearSendUI.this.gII.dismiss();
                    }
                    if (LuckyMoneyNewYearSendUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyNewYearSendUI.this.mController.contentView.getVisibility() == 4) {
                        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
                        LuckyMoneyNewYearSendUI.this.finish();
                    }
                    LuckyMoneyNewYearSendUI.this.ocz.bLz();
                    AppMethodBeat.o(42818);
                }
            });
        } else if (!this.gII.isShowing()) {
            this.gII.show();
        }
        String Yz = r.Yz();
        String str = "";
        int i2 = 0;
        if (this.kZa != null) {
            str = this.kZa.Aq();
            i2 = this.kZa.field_type;
        }
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", this.ogi, Integer.valueOf(i), Integer.valueOf(this.cKs), this.ocI);
        b(new ap(this.nYF, this.nYD, x.Qj(Yz), this.ofU, Yz, r.YB(), this.obG, str, i2, this.ogi, i, this.cKs, this.ocI), false);
        AppMethodBeat.o(42832);
    }

    private void bMG() {
        int i;
        AppMethodBeat.i(42833);
        this.ogc++;
        if (this.nYP == null || this.nYP.size() <= 0) {
            ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
            i = -1;
        } else {
            g.RQ();
            g.RN();
            i = com.tencent.mm.kernel.a.QF();
            int size = this.nYP.size();
            i = (new Random((long) i).nextInt(size) + ((int) (System.currentTimeMillis() % ((long) size)))) % size;
            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
        }
        this.ofX = i;
        if (this.ofX >= 0 && this.ofX < this.nYP.size()) {
            this.nYF = ((u) this.nYP.get(this.ofX)).nXX;
            this.nYD = ((u) this.nYP.get(this.ofX)).nXY;
        }
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.ofX + " randomAmount:" + this.nYF + " randomWishing:" + this.nYD);
        this.ofi.setFinalText(com.tencent.mm.wallet_core.ui.e.F(((double) this.nYF) / 100.0d));
        iM(false);
        this.ofi.setFocusable(false);
        this.ofi.setContentDescription("");
        this.ofi.a(new LuckyMoneyAutoScrollView.a() {
            public final void bMo() {
                AppMethodBeat.i(42820);
                if (LuckyMoneyNewYearSendUI.this.ofV) {
                    LuckyMoneyNewYearSendUI.this.nsq.setVisibility(4);
                    x.a(LuckyMoneyNewYearSendUI.this.mController.ylL, LuckyMoneyNewYearSendUI.this.nsq, LuckyMoneyNewYearSendUI.this.nYD);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500);
                    alphaAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.i(42819);
                            LuckyMoneyNewYearSendUI.this.nsq.setVisibility(0);
                            AppMethodBeat.o(42819);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                        }
                    });
                    LuckyMoneyNewYearSendUI.this.nsq.startAnimation(alphaAnimation);
                    LuckyMoneyNewYearSendUI.this.ofV = false;
                } else {
                    x.a(LuckyMoneyNewYearSendUI.this.mController.ylL, LuckyMoneyNewYearSendUI.this.nsq, LuckyMoneyNewYearSendUI.this.nYD);
                    LuckyMoneyNewYearSendUI.this.nsq.invalidate();
                }
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, true);
                LuckyMoneyNewYearSendUI.this.ofi.setFocusable(true);
                LuckyMoneyNewYearSendUI.this.ofi.setContentDescription((((double) LuckyMoneyNewYearSendUI.this.nYF) / 100.0d));
                AppMethodBeat.o(42820);
            }
        });
        AppMethodBeat.o(42833);
    }

    private void iM(boolean z) {
        AppMethodBeat.i(42834);
        this.leS.setClickable(z);
        if (z) {
            this.leS.getBackground().mutate().setAlpha(255);
            this.leS.setTextColor(getResources().getColor(R.color.u_));
            AppMethodBeat.o(42834);
            return;
        }
        this.leS.getBackground().mutate().setAlpha(128);
        this.leS.setTextColor(getResources().getColor(R.color.ua));
        AppMethodBeat.o(42834);
    }

    public final boolean c(int i, int i2, String str, final com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(42835);
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + mVar.getType());
        PayInfo payInfo;
        if (mVar instanceof ag) {
            if (i == 0 && i2 == 0) {
                ag agVar = (ag) mVar;
                this.nYF = agVar.nYF;
                this.nYD = agVar.nYD;
                this.ofW = agVar.nYL;
                this.nYM = agVar.nYM;
                this.ogi = agVar.few;
                this.nYP = agVar.nYP;
                ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", Integer.valueOf(this.ofW));
                bMG();
                ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
                if (this.nYP == null || this.nYP.size() <= 0) {
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
                    this.ofT.setVisibility(8);
                } else {
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
                    this.ofT.setVisibility(0);
                }
                this.nsq.getLayoutParams();
                this.nsq.setTextSize(1, 21.0f);
                this.ofj.setTextSize(1, 15.0f);
                this.ofi.eu(getResources().getDimensionPixelOffset(R.dimen.a58), getResources().getDimensionPixelOffset(R.dimen.a54));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ofi.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.a4r);
                this.ofi.setLayoutParams(layoutParams);
                this.ofi.invalidate();
                layoutParams = (LinearLayout.LayoutParams) this.ofT.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.a4u);
                this.ofT.setLayoutParams(layoutParams);
                this.ofT.invalidate();
                String str2 = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, (Object) "");
                if (bo.isNullOrNil(str2)) {
                    ye(0);
                } else {
                    Qo(str2);
                }
                AM(0);
                x.a(this.ofJ, null);
                AppMethodBeat.o(42835);
                return true;
            }
            finish();
        } else if (mVar instanceof ao) {
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.dismiss();
            }
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ao aoVar = (ao) mVar;
                this.obK = aoVar.nYY;
                payInfo = new PayInfo();
                payInfo.czZ = aoVar.nYX;
                payInfo.cIf = 37;
                payInfo.cIb = this.obL;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 1);
                AppMethodBeat.o(42835);
                return true;
            }
            ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        } else if (mVar instanceof ap) {
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.dismiss();
            }
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ap apVar = (ap) mVar;
                this.obK = apVar.nYY;
                this.ocI = apVar.nSX;
                if (apVar.bLD()) {
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
                    apVar.nYe.a((Activity) this, new com.tencent.mm.wallet_core.c.g() {
                        public final void aQ(int i, String str) {
                            AppMethodBeat.i(42821);
                            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
                            if (bo.gW(i, 2) && bo.isEqual(str, "requestwxhb")) {
                                LuckyMoneyNewYearSendUI.w(LuckyMoneyNewYearSendUI.this);
                                AppMethodBeat.o(42821);
                                return;
                            }
                            if (bo.gW(i, 1)) {
                                com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyNewYearSendUI.this, str, 0, true);
                            }
                            AppMethodBeat.o(42821);
                        }

                        public final void onCancel() {
                            AppMethodBeat.i(42822);
                            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
                            AppMethodBeat.o(42822);
                        }
                    });
                    AppMethodBeat.o(42835);
                    return true;
                }
                payInfo = new PayInfo();
                payInfo.czZ = apVar.nYX;
                payInfo.cIf = 37;
                payInfo.cIb = this.obL;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 1);
                AppMethodBeat.o(42835);
                return true;
            } else if (i2 == 268502454) {
                com.tencent.mm.ui.base.h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(42809);
                        if (ao.m(mVar)) {
                            LuckyMoneyNewYearSendUI.this.finish();
                            AppMethodBeat.o(42809);
                            return;
                        }
                        AppMethodBeat.o(42809);
                    }
                });
                AppMethodBeat.o(42835);
                return true;
            } else {
                ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
            }
        } else if (mVar instanceof al) {
            AppMethodBeat.o(42835);
            return true;
        }
        AppMethodBeat.o(42835);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098 A:{SYNTHETIC, Splitter:B:21:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(42836);
        switch (i) {
            case 1:
                com.tencent.mm.ai.m alVar;
                if (i2 == -1) {
                    int i3;
                    Map z;
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
                    h.pYm.e(11701, Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2));
                    if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                        RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                        if (realnameGuideHelper != null) {
                            int i4;
                            if (realnameGuideHelper.b(this, null, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(42810);
                                    LuckyMoneyNewYearSendUI.this.finish();
                                    AppMethodBeat.o(42810);
                                }
                            })) {
                                i4 = 0;
                            } else {
                                i4 = 1;
                            }
                            i3 = i4;
                            if (this.kZa != null) {
                                ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
                            } else {
                                try {
                                    i4 = this.obK.indexOf("<wcpayinfo>");
                                    if (i4 > 0 && i4 < this.obK.length()) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        x.a(stringBuilder, this.kZa);
                                        StringBuilder stringBuilder2 = new StringBuilder(this.obK.substring(0, i4));
                                        stringBuilder2.append(stringBuilder).append(this.obK.substring(i4).trim());
                                        this.obK = stringBuilder2.toString();
                                    }
                                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
                                } catch (Exception e) {
                                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", e.getMessage());
                                }
                            }
                            z = br.z(this.obK, "msg");
                            if (z != null) {
                                ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "luckymoneyNewYearSendUI onActivityResult values is null");
                                finish();
                                AppMethodBeat.o(42836);
                                return;
                            }
                            if (com.tencent.mm.plugin.luckymoney.b.a.bKN().bKQ().Qh((String) z.get(".msg.appmsg.wcpayinfo.paymsgid"))) {
                                ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", this.obK);
                                x.E(this.obK, this.ofU, 3);
                            } else {
                                ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
                            }
                            if (i3 == 0) {
                                finish();
                            }
                            this.ofZ = new l();
                            if (this.ogb == 1) {
                                this.ofZ.cVT = 8;
                            } else if (this.ogb == 2) {
                                this.ofZ.cVT = 6;
                            } else if (this.ogb == 3) {
                                this.ofZ.cVT = 7;
                            } else if (this.ogb == 4) {
                                this.ofZ.cVT = 14;
                            }
                            this.ofZ.ajK();
                            yd(1);
                        }
                    }
                    i3 = 0;
                    if (this.kZa != null) {
                    }
                    z = br.z(this.obK, "msg");
                    if (z != null) {
                    }
                } else {
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
                }
                String Yz = r.Yz();
                if (i2 == -1) {
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
                    this.cKs = 1;
                    this.ogm = "";
                    alVar = new al(this.ocI, this.ogi, 1, Yz, bo.nullAsNil(this.ofU));
                } else {
                    if (intent != null) {
                        this.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
                    } else {
                        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
                        this.cKs = 3;
                    }
                    this.ogm = this.ocI;
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", Integer.valueOf(this.cKs));
                    alVar = new al(this.ocI, this.ogi, this.cKs, Yz, bo.nullAsNil(this.ofU));
                }
                g.RO().eJo.a(alVar, 0);
                AppMethodBeat.o(42836);
                return;
            case FaceManager.FACE_ACQUIRED_HACKER /*1111*/:
                if (i2 != -1) {
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
                    break;
                }
                if (intent != null) {
                    this.ogh = intent.getLongExtra("key_enter_time", 0);
                }
                if (bo.af(this.ogh, 0)) {
                    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
                    AppMethodBeat.o(42836);
                    return;
                }
                ye(4);
                iM(false);
                b bVar = b.ezV;
                b.a(this.ogh, this.ogl);
                AppMethodBeat.o(42836);
                return;
        }
        AppMethodBeat.o(42836);
    }

    static /* synthetic */ void a(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(42837);
        com.tencent.mm.plugin.luckymoney.ui.a.a.a(luckyMoneyNewYearSendUI, luckyMoneyNewYearSendUI.odY);
        luckyMoneyNewYearSendUI.odS.dismiss();
        AppMethodBeat.o(42837);
    }

    static /* synthetic */ void b(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(42838);
        luckyMoneyNewYearSendUI.yf(0);
        AppMethodBeat.o(42838);
    }

    static /* synthetic */ void e(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(42840);
        if (bo.gW(luckyMoneyNewYearSendUI.nYM, 1)) {
            if (bo.gW(luckyMoneyNewYearSendUI.ofW, 1)) {
                com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(luckyMoneyNewYearSendUI.mController.ylL, 1, false);
                dVar.rBl = new c() {
                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        AppMethodBeat.i(42816);
                        if (bo.gW(LuckyMoneyNewYearSendUI.this.ofW, 1)) {
                            lVar.hi(1, R.string.cry);
                        }
                        lVar.hi(2, R.string.csz);
                        AppMethodBeat.o(42816);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(42817);
                        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
                        switch (menuItem.getItemId()) {
                            case 1:
                                LuckyMoneyNewYearSendUI.this.ogk = 0;
                                com.tencent.mm.plugin.emojicapture.api.c.h(LuckyMoneyNewYearSendUI.this, null, 3);
                                LuckyMoneyNewYearSendUI.this.oef = 1;
                                LuckyMoneyNewYearSendUI.this.ofZ = new l();
                                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 9;
                                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                                AppMethodBeat.o(42817);
                                return;
                            case 2:
                                LuckyMoneyNewYearSendUI.n(LuckyMoneyNewYearSendUI.this);
                                break;
                        }
                        AppMethodBeat.o(42817);
                    }
                };
                dVar.cpD();
            } else {
                luckyMoneyNewYearSendUI.bMF();
                AppMethodBeat.o(42840);
                return;
            }
        }
        AppMethodBeat.o(42840);
    }
}
