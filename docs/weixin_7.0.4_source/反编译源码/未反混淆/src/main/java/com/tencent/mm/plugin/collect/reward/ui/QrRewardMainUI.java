package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.s;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.view.d;

public class QrRewardMainUI extends QrRewardBaseUI {
    private int cIZ;
    private String cQY;
    private String desc;
    private String hHN;
    private boolean kEA;
    private final int kEg = a.fromDPToPix(this.mController.ylL, 200);
    private RelativeLayout kEh;
    private Button kEi;
    private ViewGroup kEj;
    private ViewGroup kEk;
    private RelativeLayout kEl;
    private CdnImageView kEm;
    private ImageView kEn;
    private ImageView kEo;
    private MMEditText kEp;
    private TextView kEq;
    private TextView kEr;
    private TextView kEs;
    private TextView kEt;
    private ScrollView kEu;
    private String kEv;
    private String kEw;
    private String kEx;
    private int kEy;
    private boolean kEz;
    private boolean mIsOpen = false;
    private String username;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrRewardMainUI() {
        AppMethodBeat.i(41102);
        AppMethodBeat.o(41102);
    }

    static /* synthetic */ void a(QrRewardMainUI qrRewardMainUI, String str, String str2) {
        AppMethodBeat.i(41123);
        qrRewardMainUI.n(str, str2, false);
        AppMethodBeat.o(41123);
    }

    static /* synthetic */ void bhe() {
    }

    static /* synthetic */ void f(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41121);
        qrRewardMainUI.bhb();
        AppMethodBeat.o(41121);
    }

    static /* synthetic */ void i(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41124);
        qrRewardMainUI.bha();
        AppMethodBeat.o(41124);
    }

    static /* synthetic */ void j(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41125);
        qrRewardMainUI.bhc();
        AppMethodBeat.o(41125);
    }

    static /* synthetic */ void o(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41128);
        qrRewardMainUI.bhd();
        AppMethodBeat.o(41128);
    }

    static /* synthetic */ void q(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41130);
        qrRewardMainUI.bgX();
        AppMethodBeat.o(41130);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(41103);
        super.onCreate(bundle);
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        nf(1323);
        nf(1649);
        this.kEy = ((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR))).intValue();
        this.cIZ = ((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(s.CTRL_INDEX))).intValue();
        this.desc = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, (Object) "");
        this.kEv = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, (Object) "");
        this.kEw = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_BOTTOM_STR_STRING_SYNC, (Object) "");
        this.kEx = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_BOTTOM_URL_STRING_SYNC, (Object) "");
        this.hHN = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, (Object) "");
        if (!bo.isNullOrNil((String) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, (Object) ""))) {
            this.kEA = true;
        }
        this.username = r.Yz();
        setMMTitle((int) R.string.dfr);
        initView();
        if (com.tencent.mm.plugin.collect.reward.b.a.bgS().bgT() && this.kEA) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.QrRewardMainUI", "do get code: %s", Boolean.valueOf(z));
        m bVar = new b(z);
        bVar.z(this);
        if (z) {
            a(bVar, false, false);
            AppMethodBeat.o(41103);
            return;
        }
        a(bVar, true, false);
        AppMethodBeat.o(41103);
    }

    public final void initView() {
        AppMethodBeat.i(41104);
        this.kEh = (RelativeLayout) findViewById(R.id.dsi);
        this.kEi = (Button) findViewById(R.id.dsl);
        this.kEj = (ViewGroup) findViewById(R.id.dsk);
        this.kEk = (ViewGroup) findViewById(R.id.dsm);
        this.kEm = (CdnImageView) findViewById(R.id.dso);
        this.kEq = (TextView) findViewById(R.id.dss);
        this.kEn = (ImageView) findViewById(R.id.dsp);
        this.kEo = (ImageView) findViewById(R.id.dsr);
        this.kEl = (RelativeLayout) findViewById(R.id.dsn);
        this.kEp = (MMEditText) findViewById(R.id.dsq);
        this.kEr = (TextView) findViewById(R.id.dsu);
        this.kEt = (TextView) findViewById(R.id.dsv);
        this.kEs = (TextView) findViewById(R.id.dsw);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kEn, this.username, 0.03f, true);
        try {
            this.kEp.setText(j.b(this.mController.ylL, this.kEv, this.kEp.getTextSize()));
            this.kEp.setSelection(this.kEv.length());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.QrRewardMainUI", e, "", new Object[0]);
        }
        this.kEp.addTextChangedListener(new TextWatcher() {
            int kEB = 0;

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(41083);
                ab.d("MicroMsg.QrRewardMainUI", "s: %s, %s", editable.toString(), Integer.valueOf(editable.length()));
                String obj = editable.toString();
                if (bo.isNullOrNil(obj)) {
                    this.kEB = 0;
                } else if (this.kEB == 0) {
                    if (((com.tencent.mm.plugin.emoji.b.a) g.K(com.tencent.mm.plugin.emoji.b.a.class)).G(obj) || ((com.tencent.mm.plugin.emoji.b.a) g.K(com.tencent.mm.plugin.emoji.b.a.class)).H(obj)) {
                        this.kEB = editable.length();
                    } else {
                        this.kEB = 1;
                    }
                }
                editable.delete(this.kEB, editable.length());
                AppMethodBeat.o(41083);
            }
        });
        this.kEp.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(41093);
                ab.i("MicroMsg.QrRewardMainUI", "action: %s", Integer.valueOf(i));
                QrRewardMainUI.this.aqX();
                AppMethodBeat.o(41093);
                return false;
            }
        });
        this.kEo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41094);
                ab.d("MicroMsg.QrRewardMainUI", "click avatar");
                QrRewardMainUI.this.aqX();
                QrRewardMainUI.a(QrRewardMainUI.this);
                AppMethodBeat.o(41094);
            }
        });
        this.kEr.setClickable(true);
        this.kEr.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        o oVar = new o(new o.a() {
            public final void df(View view) {
                AppMethodBeat.i(41095);
                ab.i("MicroMsg.QrRewardMainUI", "click save code");
                QrRewardMainUI.b(QrRewardMainUI.this);
                h.pYm.e(14721, Integer.valueOf(1), Integer.valueOf(5));
                AppMethodBeat.o(41095);
            }
        });
        SpannableString spannableString = new SpannableString(getString(R.string.dfw));
        spannableString.setSpan(oVar, 0, spannableString.length(), 18);
        this.kEr.setText(spannableString);
        this.kEt.setClickable(true);
        this.kEt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        oVar = new o(new o.a() {
            public final void df(View view) {
                AppMethodBeat.i(41096);
                ab.i("MicroMsg.QrRewardMainUI", "click set code, %s", Boolean.valueOf(QrRewardMainUI.this.kEA));
                QrRewardMainUI.a(QrRewardMainUI.this, false);
                AppMethodBeat.o(41096);
            }
        });
        spannableString = new SpannableString(getString(R.string.dg6));
        spannableString.setSpan(oVar, 0, spannableString.length(), 18);
        this.kEt.setText(spannableString);
        bgX();
        bha();
        bhc();
        bhb();
        AppMethodBeat.o(41104);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41105);
        if (mVar instanceof b) {
            final b bVar = (b) mVar;
            bVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41100);
                    QrRewardMainUI.this.kEv = bVar.kDu.jMS;
                    QrRewardMainUI.this.kEy = bVar.kDu.vWw;
                    QrRewardMainUI.this.cIZ = bVar.kDu.vWs;
                    QrRewardMainUI.this.desc = bVar.kDu.desc;
                    QrRewardMainUI.this.cQY = bVar.kDu.twd;
                    QrRewardMainUI.this.mIsOpen = !bVar.kDu.vWq;
                    QrRewardMainUI.this.kEw = bVar.kDu.kdE;
                    QrRewardMainUI.this.kEx = bVar.kDu.vWu;
                    QrRewardMainUI.this.kEA = true;
                    QrRewardMainUI.f(QrRewardMainUI.this);
                    if (QrRewardMainUI.this.mIsOpen) {
                        QrRewardMainUI.a(QrRewardMainUI.this, bVar.kDu.pOy, bVar.kDu.vWr);
                        QrRewardMainUI.i(QrRewardMainUI.this);
                        QrRewardMainUI.j(QrRewardMainUI.this);
                    } else {
                        QrRewardMainUI.h(QrRewardMainUI.this);
                    }
                    QrRewardMainUI.this.hHN = bVar.kDu.pOy;
                    QrRewardMainUI.bhe();
                    ab.d("MicroMsg.QrRewardMainUI", "url: %s", QrRewardMainUI.this.hHN);
                    AppMethodBeat.o(41100);
                }
            }).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    boolean z = true;
                    AppMethodBeat.i(41099);
                    ab.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", Integer.valueOf(bVar.kDu.kCl), bVar.kDu.kCm);
                    if (bVar.kDu.kCl == 416) {
                        String str = "MicroMsg.QrRewardMainUI";
                        String str2 = "realNameInfo:%s";
                        Object[] objArr = new Object[1];
                        if (bVar.kDu.vWf != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        ab.d(str, str2, objArr);
                        QrRewardMainUI.this.kEh.setVisibility(4);
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
                        bundle.putString("realname_verify_process_jump_plugin", "collect");
                        Activity activity = QrRewardMainUI.this;
                        int i = bVar.kDu.kCl;
                        bpt bpt = bVar.kDu.vWf;
                        AnonymousClass1 anonymousClass1 = new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(41098);
                                ab.i("MicroMsg.QrRewardMainUI", "RealnameVerifyUtil cancel");
                                AppMethodBeat.o(41098);
                            }
                        };
                        com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, i, bpt, bundle, 1011);
                        AppMethodBeat.o(41099);
                        return;
                    }
                    if (!bo.isNullOrNil(bVar.kDu.kCm)) {
                        Toast.makeText(QrRewardMainUI.this, bVar.kDu.kCm, 0).show();
                    }
                    if (!bVar.kDv) {
                        QrRewardMainUI.a(QrRewardMainUI.this, false);
                    }
                    AppMethodBeat.o(41099);
                }
            }).c(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41097);
                    ab.e("MicroMsg.QrRewardMainUI", "net error: %s", mVar);
                    if (!bVar.kDv) {
                        QrRewardMainUI.a(QrRewardMainUI.this, false);
                    }
                    AppMethodBeat.o(41097);
                }
            });
            AppMethodBeat.o(41105);
        } else {
            if (mVar instanceof com.tencent.mm.plugin.collect.reward.a.h) {
                final com.tencent.mm.plugin.collect.reward.a.h hVar = (com.tencent.mm.plugin.collect.reward.a.h) mVar;
                hVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                    public final void j(m mVar) {
                        AppMethodBeat.i(41085);
                        ab.i("MicroMsg.QrRewardMainUI", "set succ: %s, %s", hVar.jMS, QrRewardMainUI.this.kEp.getText());
                        if (hVar.jMS.equals(QrRewardMainUI.this.kEv)) {
                            g.RP().Ry().set(ac.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, QrRewardMainUI.this.kEv);
                            QrRewardMainUI.j(QrRewardMainUI.this);
                        }
                        AppMethodBeat.o(41085);
                    }
                }).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                    public final void j(m mVar) {
                        AppMethodBeat.i(41084);
                        ab.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", Integer.valueOf(hVar.kDB.kCl), hVar.kDB.kCm);
                        QrRewardMainUI.this.kEv = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, (Object) "");
                        QrRewardMainUI.c(QrRewardMainUI.this, QrRewardMainUI.l(QrRewardMainUI.this));
                        QrRewardMainUI.this.kEp.setText("");
                        QrRewardMainUI.j(QrRewardMainUI.this);
                        if (!bo.isNullOrNil(hVar.kDB.kCm)) {
                            Toast.makeText(QrRewardMainUI.this, hVar.kDB.kCm, 0).show();
                        }
                        AppMethodBeat.o(41084);
                    }
                }).c(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                    public final void j(m mVar) {
                        AppMethodBeat.i(41101);
                        ab.e("MicroMsg.QrRewardMainUI", "net error: %s", mVar);
                        QrRewardMainUI.this.kEv = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, (Object) "");
                        QrRewardMainUI.c(QrRewardMainUI.this, QrRewardMainUI.l(QrRewardMainUI.this));
                        QrRewardMainUI.this.kEp.setText("");
                        QrRewardMainUI.j(QrRewardMainUI.this);
                        AppMethodBeat.o(41101);
                    }
                });
                this.kEp.clearFocus();
                this.kEp.setCursorVisible(false);
            }
            AppMethodBeat.o(41105);
        }
        return true;
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(41106);
        super.onKeyboardStateChanged();
        ab.i("MicroMsg.QrRewardMainUI", "key board changed: %s", Integer.valueOf(this.mController.ymc));
        if (this.mController.ymc == 2) {
            this.kEv = this.kEp.getText().toString();
            bhd();
            if (bo.isNullOrNil(this.kEv)) {
                fV(true);
            }
        }
        AppMethodBeat.o(41106);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41107);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            this.desc = intent.getStringExtra("key_desc");
            this.kEy = intent.getIntExtra("key_photo_width", TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
            this.cIZ = intent.getIntExtra("key_icon_width", s.CTRL_INDEX);
            ab.i("MicroMsg.QrRewardMainUI", "return from first: %s", Boolean.valueOf(intent.getBooleanExtra("key_return_from_first", true)));
            if (intent.getBooleanExtra("key_return_from_first", true)) {
                this.kEk.setVisibility(0);
                this.kEj.setVisibility(8);
            }
            this.kEA = true;
            bha();
            String stringExtra = intent.getStringExtra("key_photo_url");
            n(stringExtra, intent.getStringExtra("key_photo_aeskey"), true);
            this.hHN = stringExtra;
            AppMethodBeat.o(41107);
            return;
        }
        AppMethodBeat.o(41107);
    }

    public final int getLayoutId() {
        return R.layout.ama;
    }

    public void onDestroy() {
        AppMethodBeat.i(41108);
        super.onDestroy();
        ng(1323);
        ng(1649);
        com.tencent.mm.plugin.collect.reward.b.a bgS = com.tencent.mm.plugin.collect.reward.b.a.bgS();
        ab.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
        if (bgS.jxd != null) {
            ab.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", Integer.valueOf(bgS.jxd.size()));
            bgS.jxd.clear();
        }
        AppMethodBeat.o(41108);
    }

    public final boolean aoE() {
        return false;
    }

    private void n(String str, String str2, boolean z) {
        AppMethodBeat.i(41109);
        boolean z2 = this.hHN != null && this.hHN.equals(str);
        ab.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(com.tencent.mm.plugin.collect.reward.b.a.bgS().bgT()));
        if (!(!z && z2 && r3)) {
            com.tencent.mm.plugin.collect.reward.b.a.bgS().a(str, str2, new com.tencent.mm.plugin.collect.reward.b.a.a() {
                public final void P(String str, int i, int i2) {
                    AppMethodBeat.i(41089);
                    ab.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(i2));
                    if (i == 0 && i2 == 0) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(41088);
                                QrRewardMainUI.q(QrRewardMainUI.this);
                                AppMethodBeat.o(41088);
                            }
                        });
                    }
                    AppMethodBeat.o(41089);
                }
            });
        }
        AppMethodBeat.o(41109);
    }

    private void bgX() {
        AppMethodBeat.i(41110);
        if (com.tencent.mm.plugin.collect.reward.b.a.bgS().bgT()) {
            this.kEm.am(com.tencent.mm.plugin.collect.reward.b.a.bgS().bgV(), this.kEg, this.kEg);
            this.kEl.setVisibility(0);
            AppMethodBeat.o(41110);
            return;
        }
        this.kEl.setVisibility(4);
        AppMethodBeat.o(41110);
    }

    private void bgY() {
        AppMethodBeat.i(41111);
        int round = Math.round(((float) this.kEg) * ((((float) this.cIZ) * 1.0f) / ((float) this.kEy)));
        if (round <= 0) {
            round = d.MIC_PTU_ZIPAI_THURSDAY;
        }
        ViewGroup.LayoutParams layoutParams = this.kEo.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.kEo.setLayoutParams(layoutParams);
        layoutParams = this.kEn.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.kEn.setLayoutParams(layoutParams);
        layoutParams = this.kEp.getLayoutParams();
        layoutParams.width = round - 30;
        layoutParams.height = round - 30;
        this.kEp.setLayoutParams(layoutParams);
        this.kEp.setTextSize(0, (float) ((round * 2) / 3));
        this.kEk.requestLayout();
        AppMethodBeat.o(41111);
    }

    private void bgZ() {
        AppMethodBeat.i(41112);
        if (bo.isNullOrNil(this.desc)) {
            this.kEq.setText("");
            AppMethodBeat.o(41112);
            return;
        }
        this.kEq.setText(j.b((Context) this, getString(R.string.dg8, new Object[]{this.desc}), this.kEq.getTextSize()));
        AppMethodBeat.o(41112);
    }

    private void bha() {
        AppMethodBeat.i(41113);
        bgY();
        bgZ();
        fV(bo.isNullOrNil(this.kEv));
        AppMethodBeat.o(41113);
    }

    private void bhb() {
        AppMethodBeat.i(41114);
        if (bo.isNullOrNil(this.kEw)) {
            this.kEs.setVisibility(8);
            AppMethodBeat.o(41114);
            return;
        }
        this.kEs.setClickable(true);
        this.kEs.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        o oVar = new o(new o.a() {
            public final void df(View view) {
                AppMethodBeat.i(41090);
                ab.d("MicroMsg.QrRewardMainUI", "go to: %s", QrRewardMainUI.this.kEx);
                e.n(QrRewardMainUI.this.mController.ylL, QrRewardMainUI.this.kEx, false);
                h.pYm.e(14721, Integer.valueOf(1), Integer.valueOf(6));
                AppMethodBeat.o(41090);
            }
        });
        SpannableString spannableString = new SpannableString(this.kEw);
        spannableString.setSpan(oVar, 0, spannableString.length(), 18);
        this.kEs.setText(spannableString);
        this.kEs.setVisibility(0);
        AppMethodBeat.o(41114);
    }

    private void fV(boolean z) {
        AppMethodBeat.i(41115);
        ab.i("MicroMsg.QrRewardMainUI", "switch mode: %s", Boolean.valueOf(z));
        if (z) {
            this.kEn.setVisibility(0);
            this.kEp.setVisibility(4);
            com.tencent.mm.pluginsdk.ui.a.b.a(this.kEn, this.username, 0.03f, true);
            AppMethodBeat.o(41115);
            return;
        }
        this.kEn.setVisibility(4);
        this.kEp.setVisibility(0);
        AppMethodBeat.o(41115);
    }

    private void bhd() {
        AppMethodBeat.i(41117);
        ab.i("MicroMsg.QrRewardMainUI", "do set photo word");
        m hVar = new com.tencent.mm.plugin.collect.reward.a.h(this.kEv);
        hVar.z(this);
        a(hVar, true, false);
        AppMethodBeat.o(41117);
    }

    private void bhc() {
        AppMethodBeat.i(41116);
        if (!bo.isNullOrNil(this.kEv)) {
            this.kEp.setText(j.b(this.mController.ylL, this.kEv, this.kEp.getTextSize()));
            this.kEp.setSelection(this.kEv.length());
        }
        AppMethodBeat.o(41116);
    }

    static /* synthetic */ void a(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41118);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(qrRewardMainUI, 1, false);
        dVar.rBl = new c() {
            public final void a(l lVar) {
                AppMethodBeat.i(41086);
                lVar.a(1, QrRewardMainUI.this.getString(R.string.dfs), QrRewardMainUI.l(QrRewardMainUI.this) ? QrRewardMainUI.this.getString(R.string.dfy) : "");
                lVar.a(2, QrRewardMainUI.this.getString(R.string.dft), !QrRewardMainUI.l(QrRewardMainUI.this) ? QrRewardMainUI.this.getString(R.string.dfy) : "");
                AppMethodBeat.o(41086);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(41087);
                switch (menuItem.getItemId()) {
                    case 1:
                        QrRewardMainUI.this.kEv = "";
                        QrRewardMainUI.o(QrRewardMainUI.this);
                        QrRewardMainUI.c(QrRewardMainUI.this, true);
                        h.pYm.e(14721, Integer.valueOf(1), Integer.valueOf(3));
                        AppMethodBeat.o(41087);
                        return;
                    case 2:
                        QrRewardMainUI.c(QrRewardMainUI.this, false);
                        QrRewardMainUI.p(QrRewardMainUI.this);
                        h.pYm.e(14721, Integer.valueOf(1), Integer.valueOf(4));
                        AppMethodBeat.o(41087);
                        return;
                    default:
                        ab.i("MicroMsg.QrRewardMainUI", "unknown menu: %s", Integer.valueOf(menuItem.getItemId()));
                        QrRewardMainUI.c(QrRewardMainUI.this, true);
                        AppMethodBeat.o(41087);
                        return;
                }
            }
        };
        dVar.cpD();
        AppMethodBeat.o(41118);
    }

    static /* synthetic */ void b(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41119);
        if (!qrRewardMainUI.kEz) {
            qrRewardMainUI.kEu = (ScrollView) ((ViewStub) qrRewardMainUI.findViewById(R.id.dsx)).inflate();
            TextView textView = (TextView) qrRewardMainUI.kEu.findViewById(R.id.dt5);
            textView.setText(j.b((Context) qrRewardMainUI, qrRewardMainUI.getString(R.string.dfx, new Object[]{e.eK(e.mJ(qrRewardMainUI.username), 10)}), textView.getTextSize()));
            qrRewardMainUI.kEz = true;
        }
        final ImageView imageView = (ImageView) qrRewardMainUI.kEu.findViewById(R.id.dt3);
        final ViewGroup viewGroup = (ViewGroup) qrRewardMainUI.kEu.findViewById(R.id.dsz);
        if (!bo.isNullOrNil(qrRewardMainUI.desc)) {
            ((TextView) qrRewardMainUI.kEu.findViewById(R.id.dt4)).setText(j.b((Context) qrRewardMainUI, qrRewardMainUI.getString(R.string.dg8, new Object[]{qrRewardMainUI.desc}), qrRewardMainUI.kEq.getTextSize()));
        }
        qrRewardMainUI.kEu.setVisibility(4);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41091);
                ab.d("MicroMsg.QrRewardMainUI", "height: %d, width: %d", Integer.valueOf(viewGroup.getHeight()), Integer.valueOf(viewGroup.getWidth()));
                Bitmap createBitmap = Bitmap.createBitmap(QrRewardMainUI.this.kEl.getWidth(), QrRewardMainUI.this.kEl.getHeight(), Config.ARGB_8888);
                QrRewardMainUI.this.kEl.draw(new Canvas(createBitmap));
                imageView.setImageBitmap(createBitmap);
                Bitmap createBitmap2 = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Config.ARGB_8888);
                viewGroup.draw(new Canvas(createBitmap2));
                try {
                    String str = com.tencent.mm.pluginsdk.ui.tools.n.dly() + "mm_reward_qrcode_" + System.currentTimeMillis() + ".png";
                    com.tencent.mm.sdk.platformtools.d.a(createBitmap2, 100, CompressFormat.PNG, str, false);
                    Toast.makeText(QrRewardMainUI.this.mController.ylL, QrRewardMainUI.this.getString(R.string.b3r, new Object[]{str}), 1).show();
                    com.tencent.mm.pluginsdk.ui.tools.n.a(str, QrRewardMainUI.this.mController.ylL);
                } catch (Exception e) {
                    ab.w("MicroMsg.QrRewardMainUI", "save fixed amount qrcode failed!" + e.getMessage());
                }
                QrRewardMainUI.this.kEu.setVisibility(8);
                ab.i("MicroMsg.QrRewardMainUI", "bitmap recycle %s", createBitmap2.toString());
                createBitmap2.recycle();
                AppMethodBeat.o(41091);
            }
        }, 250);
        AppMethodBeat.o(41119);
    }

    static /* synthetic */ void h(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41122);
        ab.i("MicroMsg.QrRewardMainUI", "show first guide view");
        qrRewardMainUI.kEk.setVisibility(8);
        qrRewardMainUI.kEj.setVisibility(0);
        qrRewardMainUI.kEi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41092);
                ab.d("MicroMsg.QrRewardMainUI", "open click");
                QrRewardMainUI.a(QrRewardMainUI.this, true);
                h.pYm.e(14721, Integer.valueOf(1), Integer.valueOf(1));
                AppMethodBeat.o(41092);
            }
        });
        AppMethodBeat.o(41122);
    }

    static /* synthetic */ boolean l(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41126);
        boolean isNullOrNil = bo.isNullOrNil(qrRewardMainUI.kEv);
        AppMethodBeat.o(41126);
        return isNullOrNil;
    }

    static /* synthetic */ void p(QrRewardMainUI qrRewardMainUI) {
        AppMethodBeat.i(41129);
        qrRewardMainUI.kEp.setCursorVisible(true);
        qrRewardMainUI.kEp.requestFocus();
        qrRewardMainUI.kEp.requestFocusFromTouch();
        qrRewardMainUI.showVKB();
        AppMethodBeat.o(41129);
    }
}
