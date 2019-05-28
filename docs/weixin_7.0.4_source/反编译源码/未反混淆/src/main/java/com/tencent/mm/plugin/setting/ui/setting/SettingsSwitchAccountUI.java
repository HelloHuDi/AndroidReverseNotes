package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginVoiceUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@a(19)
public class SettingsSwitchAccountUI extends MMActivity implements f {
    private String gCZ;
    private TextView gqX;
    private SwitchAccountGridView qkN;
    private Map<String, SwitchAccountModel> qkR = new HashMap();
    private boolean qnu;
    private TextView qpa;
    private View qpb;
    private View qpc;
    private TextView qpd;
    private ValueAnimator qpe;
    private ap qpf;
    private boolean qpg;
    private boolean qph;
    private int scene;
    private TextView titleView;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsSwitchAccountUI() {
        AppMethodBeat.i(127509);
        AppMethodBeat.o(127509);
    }

    static /* synthetic */ void b(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.i(138715);
        settingsSwitchAccountUI.goBack();
        AppMethodBeat.o(138715);
    }

    static /* synthetic */ void cjf() {
        AppMethodBeat.i(138714);
        logout();
        AppMethodBeat.o(138714);
    }

    static /* synthetic */ void e(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.i(138716);
        settingsSwitchAccountUI.cjc();
        AppMethodBeat.o(138716);
    }

    static /* synthetic */ void i(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.i(138717);
        settingsSwitchAccountUI.cje();
        AppMethodBeat.o(138717);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127510);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127510);
    }

    public final void initView() {
        Intent intent;
        AppMethodBeat.i(127511);
        setMMTitle("");
        dyf();
        getSupportActionBar().hide();
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.qpb = findViewById(R.id.ea4);
        this.qpc = findViewById(R.id.ea3);
        this.titleView = (TextView) findViewById(R.id.ea7);
        this.qpd = (TextView) findViewById(R.id.ea6);
        this.qpa = (TextView) findViewById(R.id.ea9);
        this.gqX = (TextView) findViewById(R.id.ea2);
        this.qkN = (SwitchAccountGridView) findViewById(R.id.ea8);
        this.qkN.setRowCount(1);
        this.qkN.setOnClickAvatarListener(new b() {
            public final void Wy(String str) {
                AppMethodBeat.i(138704);
                if (bo.isNullOrNil(str)) {
                    ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
                    if (SettingsSwitchAccountUI.this.scene == 0) {
                        SettingsSwitchAccountUI.cjf();
                        AppMethodBeat.o(138704);
                        return;
                    }
                    Intent intent = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 1);
                    intent.putExtra("from_switch_account", true);
                    SettingsSwitchAccountUI.this.startActivity(intent);
                    com.tencent.mm.ui.base.b.hK(SettingsSwitchAccountUI.this);
                    AppMethodBeat.o(138704);
                } else if (SettingsSwitchAccountUI.this.scene == 0) {
                    SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, str);
                    AppMethodBeat.o(138704);
                } else {
                    SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, str);
                    AppMethodBeat.o(138704);
                }
            }
        });
        if (this.scene == 0) {
            this.gqX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(138706);
                    SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this);
                    AppMethodBeat.o(138706);
                }
            });
        } else {
            this.gqX.setVisibility(8);
        }
        Set<String> aat = bx.fnB.aat();
        g.RN();
        if (com.tencent.mm.kernel.a.QX()) {
            this.gCZ = (String) g.RP().Ry().get(2, null);
        } else {
            this.gCZ = av.fly.T("login_weixin_username", "");
        }
        ab.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", Integer.valueOf(this.scene), this.gCZ);
        if (bo.isNullOrNil(this.gCZ) || aat.contains(this.gCZ)) {
            if (!aat.isEmpty()) {
                for (String str : aat) {
                    this.qkR.put(str, new SwitchAccountModel(str, bx.fnB.getString(str, "login_user_name"), bx.fnB.getString(str, "last_avatar_path"), bx.fnB.getString(str, "last_logout_no_pwd_ticket"), bo.ank(bx.fnB.getString(str, "last_login_use_voice"))));
                }
            }
        } else if (this.scene != 2 || bx.fnB.oM(this.gCZ)) {
            this.qkR.put(this.gCZ, new SwitchAccountModel(this.gCZ, av.fly.T("login_user_name", ""), av.fly.ZC(), "", bo.ank(av.fly.T("last_login_use_voice", ""))));
        }
        if (this.qkR.size() == 0) {
            intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            intent.putExtra("can_finish", true);
            startActivity(intent);
            finish();
            com.tencent.mm.ui.base.b.hN(this);
        }
        aa(this.qkR);
        this.qkN.ab(this.qkR);
        if (this.scene == 1) {
            String string = ah.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "");
            ab.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", string);
            if (bo.isNullOrNil(string)) {
                this.qpg = false;
                intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("from_switch_account", true);
                startActivity(intent);
                com.tencent.mm.ui.base.b.hK(this);
            } else {
                g.RN();
                if (com.tencent.mm.kernel.a.QX()) {
                    ab.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
                    finish();
                } else {
                    Wx(string);
                }
            }
        } else if (this.scene == 0) {
            this.qkN.setLastLoginWxUsername(this.gCZ);
        }
        this.qkN.cjt();
        cjc();
        this.qkN.setOnDeleteAvatarListener(new c() {
            public final void Wz(final String str) {
                AppMethodBeat.i(138707);
                h.d(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(R.string.ebe, new Object[]{((SwitchAccountModel) SettingsSwitchAccountUI.this.qkR.get(str)).username}), SettingsSwitchAccountUI.this.getString(R.string.tz), SettingsSwitchAccountUI.this.getString(R.string.up), SettingsSwitchAccountUI.this.getString(R.string.s2), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(127502);
                        ab.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", str);
                        SettingsSwitchAccountUI.this.qph = true;
                        bx.fnB.oK(str);
                        SettingsSwitchAccountUI.this.qkR.remove(str);
                        SwitchAccountGridView d = SettingsSwitchAccountUI.this.qkN;
                        String str = str;
                        if (d.qrf.contains(str)) {
                            int indexOf = d.qrf.indexOf(str);
                            d.qrf.remove(str);
                            d.qrg.remove(indexOf);
                            d.qrh.remove(indexOf);
                        }
                        SettingsSwitchAccountUI.this.qkN.cjt();
                        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
                        if (SettingsSwitchAccountUI.this.scene == 0) {
                            if (bx.fnB.aat().size() > 0) {
                                com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(4), bx.fnB.aau());
                                AppMethodBeat.o(127502);
                                return;
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(0), Integer.valueOf(4), bx.fnB.aau());
                        }
                        AppMethodBeat.o(127502);
                    }
                }, null);
                AppMethodBeat.o(138707);
            }
        });
        cjb();
        AppMethodBeat.o(127511);
    }

    private void cjb() {
        AppMethodBeat.i(138712);
        this.qpe = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qpe.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(138708);
                SettingsSwitchAccountUI.this.qkN.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) SettingsSwitchAccountUI.this.qkN.getHeight()));
                AppMethodBeat.o(138708);
            }
        });
        this.qpe.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(138709);
                ab.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
                Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(SettingsSwitchAccountUI.this);
                bh.addFlags(67108864);
                SettingsSwitchAccountUI.this.startActivity(bh);
                SettingsSwitchAccountUI.this.finish();
                com.tencent.mm.ui.base.b.hM(SettingsSwitchAccountUI.this);
                AppMethodBeat.o(138709);
            }
        });
        this.qpe.setDuration(500);
        AppMethodBeat.o(138712);
    }

    private static void aa(Map<String, SwitchAccountModel> map) {
        AppMethodBeat.i(127512);
        if (map.size() == 2) {
            String[] strArr = new String[2];
            int i = 0;
            for (SwitchAccountModel switchAccountModel : map.values()) {
                int i2 = i + 1;
                strArr[i] = switchAccountModel.username;
                i = i2;
            }
            if (!bo.Q(strArr[0], strArr[1]) && strArr[0].equals(strArr[1])) {
                for (String oK : map.keySet()) {
                    bx.fnB.oK(oK);
                }
                NullPointerException nullPointerException = new NullPointerException(String.format("tow accounts have the same username!!! , %s, %s", new Object[]{strArr[0], strArr[1]}));
                AppMethodBeat.o(127512);
                throw nullPointerException;
            }
        }
        AppMethodBeat.o(127512);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(127513);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(127513);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(127513);
        return onKeyDown;
    }

    private void Wx(String str) {
        AppMethodBeat.i(127514);
        SwitchAccountModel switchAccountModel = (SwitchAccountModel) this.qkR.get(str);
        if (!(switchAccountModel == null || this.qpg)) {
            this.qpg = true;
            g.Rg().a(new q(str, switchAccountModel.username, switchAccountModel.qjL, ""), 0);
            this.qkN.setSwitchToWxUsername(str);
            this.qkN.cjt();
            cjc();
        }
        AppMethodBeat.o(127514);
    }

    private void cjc() {
        AppMethodBeat.i(127515);
        if (this.qpg) {
            this.qpa.setVisibility(8);
            AppMethodBeat.o(127515);
        } else if (this.qkR.size() <= 1 && this.scene == 0) {
            this.qpa.setVisibility(8);
            this.qnu = false;
            this.qkN.setDeleteState(false);
            AppMethodBeat.o(127515);
        } else if (this.qnu) {
            this.titleView.setText(R.string.ebg);
            this.qpd.setVisibility(0);
            if (this.qph) {
                this.qpa.setText(getString(R.string.qt));
                this.qpa.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(127506);
                        SettingsSwitchAccountUI.this.qnu = false;
                        SettingsSwitchAccountUI.this.qph = false;
                        SettingsSwitchAccountUI.this.qkN.setDeleteState(false);
                        SettingsSwitchAccountUI.this.qkN.cjt();
                        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
                        if (SettingsSwitchAccountUI.this.qkN.getAccountCount() == 0) {
                            if (bx.fnB.aat().size() > 1) {
                                com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(11), bx.fnB.aau());
                            } else {
                                com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(0), Integer.valueOf(11), bx.fnB.aau());
                            }
                            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(SettingsSwitchAccountUI.this);
                            bh.addFlags(67108864);
                            SettingsSwitchAccountUI.this.startActivity(bh);
                            SettingsSwitchAccountUI.this.finish();
                            com.tencent.mm.ui.base.b.hM(SettingsSwitchAccountUI.this);
                            SettingsSwitchAccountUI.this.qpg = false;
                        }
                        AppMethodBeat.o(127506);
                    }
                });
                AppMethodBeat.o(127515);
                return;
            }
            this.qpa.setText(getString(R.string.or));
            this.qpa.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(127507);
                    SettingsSwitchAccountUI.this.qnu = false;
                    SettingsSwitchAccountUI.this.qph = false;
                    SettingsSwitchAccountUI.this.qkN.setDeleteState(false);
                    SettingsSwitchAccountUI.this.qkN.cjt();
                    SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
                    AppMethodBeat.o(127507);
                }
            });
            AppMethodBeat.o(127515);
        } else {
            this.titleView.setText(R.string.ebi);
            this.qpd.setVisibility(8);
            this.qpa.setText(getString(R.string.ebg));
            this.qpa.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(138710);
                    if (!SettingsSwitchAccountUI.this.qnu) {
                        SettingsSwitchAccountUI.this.qnu = true;
                        SettingsSwitchAccountUI.this.qkN.setDeleteState(SettingsSwitchAccountUI.this.qnu);
                        SettingsSwitchAccountUI.this.qkN.cjt();
                        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
                        if (bx.fnB.aat().size() > 1) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(3), bx.fnB.aau());
                            AppMethodBeat.o(138710);
                            return;
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(0), Integer.valueOf(3), bx.fnB.aau());
                    }
                    AppMethodBeat.o(138710);
                }
            });
            AppMethodBeat.o(127515);
        }
    }

    public void onResume() {
        AppMethodBeat.i(127516);
        super.onResume();
        ab.i("MicroMsg.SettingsSwitchAccountUI", "onResume");
        if (this.scene == 1 || this.scene == 2) {
            g.Rg().a(701, (f) this);
            g.Rg().a(252, (f) this);
        }
        if (this.scene == 0) {
            g.Rg().a((int) d.MIC_PTU_TRANS_KONGCHENG, (f) this);
            g.Rg().a((int) d.MIC_PTU_BAIXI, (f) this);
            g.Rg().a(255, (f) this);
        }
        this.qkN.cjt();
        cjc();
        if ((this.scene == 1 || this.scene == 2) && g.RK() && g.RN().eJb) {
            ab.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
            this.qpg = true;
            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
            bh.addFlags(67108864);
            startActivity(bh);
            finish();
            com.tencent.mm.ui.base.b.hM(this);
        }
        AppMethodBeat.o(127516);
    }

    public void onStop() {
        AppMethodBeat.i(127517);
        super.onStop();
        ab.i("MicroMsg.SettingsSwitchAccountUI", "onStop");
        if (this.scene == 1) {
            SwitchAccountGridView switchAccountGridView = this.qkN;
            if (switchAccountGridView.qrd) {
                switchAccountGridView.qrd = false;
                if (switchAccountGridView.qre != null) {
                    switchAccountGridView.qre.end();
                }
            }
        }
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        g.Rg().b((int) d.MIC_PTU_TRANS_KONGCHENG, (f) this);
        g.Rg().b((int) d.MIC_PTU_BAIXI, (f) this);
        g.Rg().b(255, (f) this);
        AppMethodBeat.o(127517);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        String str2;
        AppMethodBeat.i(127518);
        ab.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", Integer.valueOf(i2), str, mVar, Integer.valueOf(mVar.getType()), this);
        if (mVar.getType() == 252 || mVar.getType() == 701) {
            if (i == 0 && i2 == 0) {
                this.qpb.setVisibility(4);
                this.qpc.setVisibility(4);
                SwitchAccountGridView switchAccountGridView = this.qkN;
                if (!switchAccountGridView.qrd) {
                    if (switchAccountGridView.qre == null && !bo.isNullOrNil(switchAccountGridView.qrc)) {
                        int min = Math.min(2, switchAccountGridView.qrf.size());
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.AnonymousClass4(min));
                        ofFloat.setDuration(200);
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.AnonymousClass5(min));
                        ofFloat2.setDuration(300);
                        switchAccountGridView.qre = new AnimatorSet();
                        switchAccountGridView.qre.addListener(new AnimatorListenerAdapter() {
                            public final void onAnimationEnd(Animator animator) {
                                AppMethodBeat.i(127707);
                                ab.i("MicroMsg.SwitchAccountGridView", "avatar animator end");
                                SwitchAccountGridView.this.qrd = false;
                                if (SwitchAccountGridView.this.qrj != null) {
                                    SwitchAccountGridView.this.qrj.cjg();
                                }
                                AppMethodBeat.o(127707);
                            }
                        });
                        switchAccountGridView.qre.playSequentially(new Animator[]{ofFloat, ofFloat2});
                    }
                    if (switchAccountGridView.qre != null) {
                        switchAccountGridView.qrd = true;
                        switchAccountGridView.qre.start();
                    }
                }
                com.tencent.mm.kernel.a.unhold();
                l.apX();
                w.cm(this);
                if (bx.fnB.aat().size() > 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(0), bx.fnB.aau());
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(0), Integer.valueOf(0), bx.fnB.aau());
                }
                this.qkN.setOnAnimatorEndListener(new SwitchAccountGridView.a() {
                    public final void cjg() {
                        AppMethodBeat.i(138711);
                        SettingsSwitchAccountUI.this.qkN.setLastLoginWxUsername(r.Yz());
                        SettingsSwitchAccountUI.this.qkN.setSwitchToWxUsername("");
                        SettingsSwitchAccountUI.this.qkN.cjt();
                        SettingsSwitchAccountUI.this.qpe.start();
                        AppMethodBeat.o(138711);
                    }
                });
            } else {
                this.qkN.setSwitchToWxUsername("");
                this.qpg = false;
                h.bQ(this, getString(R.string.ebh));
                str2 = ((q) mVar).fPk;
                if (!bo.isNullOrNil(str2) && this.qkR.containsKey(str2)) {
                    Intent intent = new Intent();
                    ab.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", str2, Integer.valueOf(((SwitchAccountModel) this.qkR.get(str2)).qjM));
                    if ((((SwitchAccountModel) this.qkR.get(str2)).qjM & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                        intent.setClass(this, LoginVoiceUI.class);
                    } else {
                        intent.setClass(this, LoginPasswordUI.class);
                    }
                    intent.putExtra("switch_login_wx_id", str2);
                    startActivity(intent);
                    com.tencent.mm.ui.base.b.hN(this);
                }
                if (bx.fnB.aat().size() > 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(1), bx.fnB.aau());
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(0), Integer.valueOf(1), bx.fnB.aau());
                }
            }
        }
        if (mVar.getType() == 255) {
            if (((com.tencent.mm.modelsimple.r) mVar).fPs == 2) {
                if (i == 0 && i2 == 0) {
                    cjd();
                    AppMethodBeat.o(127518);
                    return;
                } else if (i2 == -3 && i == 4) {
                    if (bx.fnB.aat().size() > 1) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(7), bx.fnB.aau());
                    } else {
                        com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(0), Integer.valueOf(7), bx.fnB.aau());
                    }
                    Intent intent2 = new Intent(this.mController.ylL, RegByMobileSetPwdUI.class);
                    intent2.putExtra("kintent_hint", getString(R.string.dlz));
                    startActivityForResult(intent2, 701);
                    AppMethodBeat.o(127518);
                    return;
                } else if (com.tencent.mm.plugin.setting.b.gkF.a((Context) this, i, i2, str)) {
                    AppMethodBeat.o(127518);
                    return;
                }
            }
        } else if (mVar.getType() == d.MIC_PTU_BAIXI) {
            g.RN();
            if (com.tencent.mm.kernel.a.QX()) {
                str2 = ((ayx) ((p) mVar).ehh.fsH.fsP).wCM;
                String str3 = "MicroMsg.SettingsSwitchAccountUI";
                String str4 = "logout return noPwdTicket[%s]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(str2 == null ? -1 : str2.length());
                ab.d(str3, str4, objArr);
                if (bo.isNullOrNil(str2)) {
                    ab.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
                }
                ab.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", r.Yz());
                bx.fnB.n(r0, "last_logout_no_pwd_ticket", str2);
                if (!(this.qpf == null || this.qpf.doT())) {
                    this.qpf.stopTimer();
                    cje();
                }
            }
        }
        AppMethodBeat.o(127518);
    }

    private void goBack() {
        AppMethodBeat.i(127519);
        ab.i("MicroMsg.SettingsSwitchAccountUI", "go back");
        if (this.scene == 2 || this.scene == 1) {
            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
            bh.addFlags(67108864);
            bh.putExtra("can_finish", true);
            startActivity(bh);
            finish();
            com.tencent.mm.ui.base.b.hM(this);
            this.qpg = false;
            AppMethodBeat.o(127519);
            return;
        }
        finish();
        AppMethodBeat.o(127519);
    }

    public final int getLayoutId() {
        return R.layout.as2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127521);
        super.onActivityResult(i, i2, intent);
        if (i == 701 && i2 == -1) {
            cjd();
        }
        AppMethodBeat.o(127521);
    }

    private static void logout() {
        AppMethodBeat.i(127522);
        if (!(g.Rg() == null || g.Rg().ftA == null)) {
            g.Rg().ftA.cG(false);
        }
        com.tencent.mm.sdk.b.a.xxA.m(new gj());
        Object[] objArr = new Object[1];
        g.RN();
        objArr[0] = Integer.valueOf(com.tencent.mm.kernel.a.QF());
        ab.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.modelstat.c.akc().commitNow();
        ((com.tencent.mm.plugin.expt.a.c) g.K(com.tencent.mm.plugin.expt.a.c.class)).logout();
        m rVar = new com.tencent.mm.modelsimple.r(2);
        rVar.fPr = 1;
        g.Rg().a(rVar, 0);
        AppMethodBeat.o(127522);
    }

    private void cjd() {
        AppMethodBeat.i(127523);
        if (com.tencent.mm.kernel.a.jP(g.RN().eIV)) {
            g.Rg().a(new com.tencent.mm.modelsimple.ab(2), 0);
        }
        g.Rg().a(new p(), 0);
        this.qkN.setLogoutState(true);
        this.qkN.cjt();
        if (this.qpf == null) {
            this.qpf = new ap(Looper.getMainLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(138705);
                    SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this);
                    AppMethodBeat.o(138705);
                    return false;
                }
            }, false);
            this.qpf.ae(8000, 8000);
        }
        AppMethodBeat.o(127523);
    }

    private void cje() {
        AppMethodBeat.i(127524);
        ab.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
        com.tencent.mm.plugin.setting.b.gkF.BY();
        this.gqX.setVisibility(8);
        this.qpa.setVisibility(8);
        jl jlVar = new jl();
        jlVar.cEK.status = 0;
        jlVar.cEK.boZ = 0;
        com.tencent.mm.sdk.b.a.xxA.m(jlVar);
        z zVar = new z();
        zVar.csU.csV = true;
        com.tencent.mm.sdk.b.a.xxA.m(zVar);
        aj.amB("show_whatsnew");
        com.tencent.mm.kernel.l.m(this, true);
        w.I(this, null);
        if (g.RK()) {
            av.fly.ou(com.tencent.mm.ah.b.pX(r.Yz()));
        }
        ab.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", av.fly.T("login_user_name", ""));
        Map Zg = r.Zg();
        if (bo.isNullOrNil((String) Zg.get("login_user_name"))) {
            Zg.put("login_user_name", av.fly.T("login_user_name", ""));
        }
        bx.fnB.g(r.Yz(), Zg);
        ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
        try {
            Bitmap eA = com.tencent.mm.sdk.platformtools.d.eA(this.mController.ylv);
            e.deleteFile(com.tencent.mm.ui.e.d.yfV);
            if (eA != null) {
                com.tencent.mm.sdk.platformtools.d.a(eA, 80, CompressFormat.JPEG, com.tencent.mm.ui.e.d.yfV, true);
            } else {
                ab.e("MicroMsg.SettingsSwitchAccountUI", "getBitmap from AccountGrid null!");
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SettingsSwitchAccountUI", "getBitmap from AccountGrid failed! %s", e.getMessage());
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        intent.putExtra("key_transit_to_switch_account", true);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.qkR.values());
        intent.putParcelableArrayListExtra("key_switch_account_users", arrayList);
        com.tencent.mm.plugin.setting.b.gkE.p(intent, this);
        finish();
        com.tencent.mm.ui.base.b.hN(this);
        AppMethodBeat.o(127524);
    }
}
