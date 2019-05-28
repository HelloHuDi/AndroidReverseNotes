package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.protocal.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bqw;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.TimeZone;

public class RegByMobileRegAIOUI extends MMActivity implements f {
    private String countryCode = null;
    private ImageView ejo;
    private String fHE = null;
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(125334);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(125334);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(125335);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(125335);
                return false;
            }
            ab.i("MicroMsg.RegByMobileRegAIOUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(125335);
            return true;
        }
    };
    private String gBE = null;
    private ba gBm = new ba();
    private ResizeLayout gCa;
    private TextView gDL;
    private Button gDN;
    private boolean gDT = true;
    private String gDV = null;
    private final int gDd = 128;
    private String gDp;
    private String gDq;
    private int gDr = 0;
    private String gDy;
    private int gEu;
    private EditText gFH;
    private TextView gFI;
    private MMFormInputView gFJ;
    private String gFK = null;
    private MMFormInputView gFL;
    private boolean gFM = false;
    private ImageView gFN;
    private MMFormInputView gFO;
    private Bitmap gFP;
    private ScrollView gFQ;
    private String gFR;
    private String gFS;
    private String gFT;
    private String gFU;
    private String gFV;
    private boolean gFW = true;
    private com.tencent.mm.ui.widget.a.c gFX = null;
    private boolean gFY = false;
    private int gFZ;
    private int gGa;
    private boolean gGb;
    private boolean gGc;
    private LinearLayout grF;
    private TextView grH;
    private String grJ = null;
    private String gsF;
    private p guc;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegByMobileRegAIOUI() {
        AppMethodBeat.i(125373);
        AppMethodBeat.o(125373);
    }

    static /* synthetic */ boolean b(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(125392);
        boolean arr = regByMobileRegAIOUI.arr();
        AppMethodBeat.o(125392);
        return arr;
    }

    static /* synthetic */ void d(RegByMobileRegAIOUI regByMobileRegAIOUI, String str) {
        AppMethodBeat.i(125394);
        regByMobileRegAIOUI.wv(str);
        AppMethodBeat.o(125394);
    }

    static /* synthetic */ void j(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(125393);
        regByMobileRegAIOUI.aro();
        AppMethodBeat.o(125393);
    }

    static /* synthetic */ void m(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(125395);
        regByMobileRegAIOUI.aoZ();
        AppMethodBeat.o(125395);
    }

    static /* synthetic */ void t(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(125396);
        regByMobileRegAIOUI.arp();
        AppMethodBeat.o(125396);
    }

    public final int getLayoutId() {
        return R.layout.ao2;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125374);
        super.onCreate(bundle);
        this.fHE = bo.bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = av.amO(bo.bc(getIntent().getStringExtra("couttry_code"), ""));
        this.gBE = bo.nullAsNil(getIntent().getStringExtra("iso_code"));
        this.grJ = bo.bc(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.gFR = getIntent().getStringExtra("register_title");
        this.gFU = getIntent().getStringExtra("register_nick_name");
        this.gFV = getIntent().getStringExtra("register_avatar");
        this.gFS = getIntent().getStringExtra("third_app_token");
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        initView();
        AppMethodBeat.o(125374);
    }

    public void onResume() {
        AppMethodBeat.i(125375);
        a.xxA.c(this.gAY);
        super.onResume();
        g.Rg().a(701, (f) this);
        g.Rg().a(252, (f) this);
        g.Rg().a(145, (f) this);
        g.Rg().a(132, (f) this);
        g.Rg().a(755, (f) this);
        g.Rg().a(252, (f) this);
        g.Rg().a(701, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE200_100")).append(",1").toString());
        this.gDr = 0;
        AppMethodBeat.o(125375);
    }

    public void onPause() {
        AppMethodBeat.i(125376);
        super.onPause();
        if (this.guc != null) {
            this.guc.dismiss();
        }
        a.xxA.d(this.gAY);
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        g.Rg().b(145, (f) this);
        g.Rg().b(132, (f) this);
        g.Rg().b(755, (f) this);
        g.Rg().b(252, (f) this);
        g.Rg().b(701, (f) this);
        com.tencent.mm.plugin.b.a.wz("RE200_100");
        AppMethodBeat.o(125376);
    }

    private void apc() {
        AppMethodBeat.i(125377);
        if (bo.isNullOrNil(this.fHE) || bo.isNullOrNil(this.countryCode)) {
            this.gBE = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            ab.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.gBE);
            if (bo.isNullOrNil(this.gBE)) {
                ab.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
                AppMethodBeat.o(125377);
                return;
            }
            com.tencent.mm.au.b.a k = com.tencent.mm.au.b.k(this, this.gBE, getString(R.string.b3_));
            if (k == null) {
                ab.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
                AppMethodBeat.o(125377);
                return;
            }
            this.fHE = k.fHE;
            this.countryCode = k.fHD;
            AppMethodBeat.o(125377);
            return;
        }
        AppMethodBeat.o(125377);
    }

    public final void initView() {
        AppMethodBeat.i(125378);
        this.grF = (LinearLayout) findViewById(R.id.a4x);
        this.grH = (TextView) findViewById(R.id.a4z);
        this.gFI = (TextView) findViewById(R.id.dxg);
        this.gFJ = (MMFormInputView) findViewById(R.id.dxm);
        this.gFJ.setInputType(3);
        this.gFH = this.gFJ.getContentEditText();
        this.gDL = (TextView) findViewById(R.id.dbu);
        this.gDN = (Button) findViewById(R.id.dxo);
        this.ejo = (ImageView) findViewById(R.id.dxk);
        this.gFN = (ImageView) findViewById(R.id.dxl);
        this.gFL = (MMFormInputView) findViewById(R.id.dxn);
        com.tencent.mm.ui.tools.b.c.d(this.gFL.getContentEditText()).PM(16).a(null);
        this.gFQ = (ScrollView) findViewById(R.id.jh);
        this.gCa = (ResizeLayout) findViewById(R.id.cq9);
        this.gFO = (MMFormInputView) findViewById(R.id.dxi);
        this.gCa.setOnSizeChanged(new ResizeLayout.a() {
            public final void aqZ() {
                AppMethodBeat.i(125354);
                RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(125354);
            }
        });
        String string = getString(R.string.cmf);
        String str = "  ";
        String string2;
        String string3;
        String string4;
        Spannable newSpannable;
        if (aa.doo()) {
            string2 = getString(R.string.cmg);
            string3 = getString(R.string.dei);
            string4 = getString(R.string.fq);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125360);
                    bo.M(RegByMobileRegAIOUI.this.mController.ylL, RegByMobileRegAIOUI.this.getString(R.string.ezj));
                    AppMethodBeat.o(125360);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(125361);
                    textPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.o(125361);
                }
            }, string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125362);
                    bo.M(RegByMobileRegAIOUI.this.mController.ylL, RegByMobileRegAIOUI.this.getString(R.string.g7o, new Object[]{aa.dor(), aa.doq(), "setting", Integer.valueOf(0), Integer.valueOf(0)}));
                    AppMethodBeat.o(125362);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(125363);
                    textPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.o(125363);
                }
            }, ((string.length() + str.length()) + string2.length()) + string4.length(), (((string.length() + str.length()) + string2.length()) + string4.length()) + string3.length(), 33);
            this.gDL.setText(newSpannable);
        } else {
            string2 = getString(R.string.cmk);
            string3 = getString(R.string.cmi);
            string4 = getString(R.string.fq);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125364);
                    bo.M(RegByMobileRegAIOUI.this.mController.ylL, RegByMobileRegAIOUI.this.getString(R.string.ezo));
                    AppMethodBeat.o(125364);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(125365);
                    textPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.o(125365);
                }
            }, string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125366);
                    bo.M(RegByMobileRegAIOUI.this.mController.ylL, RegByMobileRegAIOUI.this.getString(R.string.g7o, new Object[]{aa.dor(), aa.doq(), "reg", Integer.valueOf(1), Integer.valueOf(0)}));
                    AppMethodBeat.o(125366);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(125367);
                    textPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.o(125367);
                }
            }, ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            this.gDL.setText(newSpannable);
        }
        this.gDL.setMovementMethod(LinkMovementMethod.getInstance());
        final boolean[] zArr = new boolean[]{true};
        this.gFH.addTextChangedListener(new TextWatcher() {
            private av gGg = new av();

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125369);
                RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(125369);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(125370);
                if (zArr[0]) {
                    zArr[0] = false;
                    com.tencent.mm.plugin.normsg.a.b.oTO.TI("ie_reg");
                }
                com.tencent.mm.plugin.normsg.a.b.oTO.TJ("ie_reg");
                AppMethodBeat.o(125370);
            }
        });
        this.gFH.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(125371);
                if (z) {
                    zArr[0] = true;
                    AppMethodBeat.o(125371);
                    return;
                }
                com.tencent.mm.plugin.normsg.a.b.oTO.TK("ie_reg");
                AppMethodBeat.o(125371);
            }
        });
        this.gFL.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125372);
                RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(125372);
            }
        });
        this.gFO.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125336);
                RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(125336);
            }
        });
        zArr = new boolean[]{false};
        this.gDN.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(125337);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr[0] = true;
                        com.tencent.mm.plugin.normsg.a.b.oTO.fu("ce_reg", "<Reg>");
                        break;
                    case 1:
                    case 6:
                        com.tencent.mm.plugin.normsg.a.b.oTO.a("ce_reg", motionEvent);
                        com.tencent.mm.plugin.normsg.a.b.oTO.TN("ce_reg");
                        break;
                }
                AppMethodBeat.o(125337);
                return false;
            }
        });
        this.gDN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125341);
                if (zArr[0]) {
                    zArr[0] = false;
                } else {
                    com.tencent.mm.plugin.normsg.a.b.oTO.fu("ce_reg", "<Reg>");
                    com.tencent.mm.plugin.normsg.a.b.oTO.a("ce_reg", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, CdnLogic.kBizGeneric));
                    com.tencent.mm.plugin.normsg.a.b.oTO.TN("ce_reg");
                }
                com.tencent.mm.ui.tools.b.c hz = com.tencent.mm.ui.tools.b.c.d(RegByMobileRegAIOUI.this.gFO.getContentEditText()).hz(1, 32);
                hz.zIx = true;
                hz.a(new com.tencent.mm.ui.tools.b.c.a() {
                    public final void ki(String str) {
                        AppMethodBeat.i(125338);
                        RegByMobileRegAIOUI.this.gDV = av.amN(RegByMobileRegAIOUI.this.gFH.getText().toString());
                        RegByMobileRegAIOUI.this.gFK = av.amP(RegByMobileRegAIOUI.this.countryCode);
                        String str2 = RegByMobileRegAIOUI.this.gFK + RegByMobileRegAIOUI.this.gDV;
                        RegByMobileRegAIOUI.this.aqX();
                        if (RegByMobileRegAIOUI.this.gFW) {
                            if (bo.isNullOrNil(RegByMobileRegAIOUI.this.gBE)) {
                                RegByMobileRegAIOUI.this.gBE = com.tencent.mm.au.b.m(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.countryCode, RegByMobileRegAIOUI.this.getString(R.string.b3_));
                            }
                            com.tencent.mm.plugin.account.a.b.a.b(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.getString(R.string.g7o, new Object[]{aa.dor(), RegByMobileRegAIOUI.this.gBE, "reg", Integer.valueOf(1), Integer.valueOf(0)}), 30847, false);
                            AppMethodBeat.o(125338);
                        } else if (bo.isNullOrNil(RegByMobileRegAIOUI.this.gFS)) {
                            RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this, str2);
                            AppMethodBeat.o(125338);
                        } else {
                            RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this);
                            AppMethodBeat.o(125338);
                        }
                    }

                    public final void JW() {
                        AppMethodBeat.i(125339);
                        h.g(RegByMobileRegAIOUI.this, R.string.e8m, R.string.e8p);
                        AppMethodBeat.o(125339);
                    }

                    public final void JX() {
                        AppMethodBeat.i(125340);
                        h.g(RegByMobileRegAIOUI.this, R.string.e8n, R.string.e8p);
                        AppMethodBeat.o(125340);
                    }
                });
                AppMethodBeat.o(125341);
            }
        });
        this.gDN.setEnabled(false);
        if (bo.isNullOrNil(this.countryCode)) {
            this.fHE = getString(R.string.b3b);
            this.countryCode = av.amO(getString(R.string.b3a));
        } else {
            this.fHE = com.tencent.mm.au.b.l(this, this.countryCode, getString(R.string.b3_));
        }
        if (!bo.isNullOrNil(this.gFR)) {
            this.gFI.setText(this.gFR);
        }
        apc();
        arf();
        if (this.grJ == null || this.grJ.equals("")) {
            g.RS().a(new al.a() {
                String ekv;

                public final boolean acg() {
                    AppMethodBeat.i(125342);
                    if (bo.isNullOrNil((RegByMobileRegAIOUI.this.gFH.getText()).trim())) {
                        String Ps = av.Ps(this.ekv);
                        if (!bo.isNullOrNil(this.ekv) && "+86".equals(Ps)) {
                            RegByMobileRegAIOUI.this.gFH.setText(this.ekv.substring(3));
                        }
                    }
                    AppMethodBeat.o(125342);
                    return true;
                }

                public final boolean acf() {
                    AppMethodBeat.i(125343);
                    this.ekv = i.getPhoneNum(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.countryCode);
                    AppMethodBeat.o(125343);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(125344);
                    String str = super.toString() + "|initView1";
                    AppMethodBeat.o(125344);
                    return str;
                }
            });
        } else {
            this.gFH.setText(this.grJ);
        }
        this.grF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125345);
                Intent intent = new Intent();
                intent.putExtra("country_name", RegByMobileRegAIOUI.this.fHE);
                intent.putExtra("couttry_code", RegByMobileRegAIOUI.this.countryCode);
                com.tencent.mm.plugin.account.a.a.gkE.b(intent, RegByMobileRegAIOUI.this);
                AppMethodBeat.o(125345);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125346);
                RegByMobileRegAIOUI.this.aqX();
                RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this);
                RegByMobileRegAIOUI.this.finish();
                AppMethodBeat.o(125346);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        this.ejo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125347);
                com.tencent.mm.plugin.account.a.a.gkF.o(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(125347);
            }
        });
        if (bo.isNullOrNil(this.gFS)) {
            g.RS().a(new al.a() {
                String nickname;

                public final boolean acg() {
                    AppMethodBeat.i(125348);
                    if (!bo.isNullOrNil(this.nickname) && bo.isNullOrNil((RegByMobileRegAIOUI.this.gFO.getText()).trim())) {
                        RegByMobileRegAIOUI.this.gFO.setText(this.nickname);
                    }
                    if (com.tencent.mm.compatible.util.f.Mn()) {
                        if (!(RegByMobileRegAIOUI.this.gFP == null || RegByMobileRegAIOUI.this.gFP.isRecycled() || RegByMobileRegAIOUI.this.gFM)) {
                            RegByMobileRegAIOUI.this.ejo.setImageBitmap(RegByMobileRegAIOUI.this.gFP);
                            RegByMobileRegAIOUI.this.gFN.setVisibility(8);
                            RegByMobileRegAIOUI.this.gFM = true;
                        }
                        AppMethodBeat.o(125348);
                        return true;
                    }
                    ab.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
                    AppMethodBeat.o(125348);
                    return false;
                }

                public final boolean acf() {
                    AppMethodBeat.i(125349);
                    this.nickname = i.cj(RegByMobileRegAIOUI.this);
                    RegByMobileRegAIOUI.this.gFP = i.ck(RegByMobileRegAIOUI.this);
                    if (!(RegByMobileRegAIOUI.this.gFP == null || RegByMobileRegAIOUI.this.gFP.isRecycled())) {
                        try {
                            d.a(RegByMobileRegAIOUI.this.gFP, 100, CompressFormat.PNG, e.euY + "temp.avatar", false);
                        } catch (Exception e) {
                            ab.e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + e.getMessage());
                            ab.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(125349);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(125350);
                    String str = super.toString() + "|initView2";
                    AppMethodBeat.o(125350);
                    return str;
                }
            });
        } else {
            this.gFO.setText(this.gFU);
            g.RS().a(new al.a() {
                public final boolean acf() {
                    AppMethodBeat.i(125351);
                    InputStream inputStream = null;
                    try {
                        inputStream = new URL(RegByMobileRegAIOUI.this.gFV).openConnection().getInputStream();
                        RegByMobileRegAIOUI.this.gFP = d.decodeStream(inputStream);
                        if (!(RegByMobileRegAIOUI.this.gFP == null || RegByMobileRegAIOUI.this.gFP.isRecycled())) {
                            d.a(RegByMobileRegAIOUI.this.gFP, 100, CompressFormat.PNG, e.euY + "temp.avatar", false);
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "get avatar from http failed!", new Object[0]);
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        AppMethodBeat.o(125351);
                    }
                    AppMethodBeat.o(125351);
                    return true;
                }

                public final boolean acg() {
                    AppMethodBeat.i(125352);
                    if (!(RegByMobileRegAIOUI.this.gFM || RegByMobileRegAIOUI.this.gFP == null || RegByMobileRegAIOUI.this.gFP.isRecycled())) {
                        RegByMobileRegAIOUI.this.ejo.setImageBitmap(RegByMobileRegAIOUI.this.gFP);
                        RegByMobileRegAIOUI.this.gFN.setVisibility(8);
                        RegByMobileRegAIOUI.this.gFM = true;
                    }
                    AppMethodBeat.o(125352);
                    return true;
                }
            });
        }
        string = "";
        if (com.tencent.mm.protocal.d.vxr) {
            string = getString(R.string.ru) + getString(R.string.fk);
        }
        setMMTitle(string);
        xE(getResources().getColor(R.color.vy));
        dyb();
        if (com.tencent.mm.compatible.util.d.iW(23)) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.vs));
            dxW();
        }
        AppMethodBeat.o(125378);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125379);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.o(125379);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125379);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(125380);
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE200_100")).append(",2").toString());
        finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(125380);
    }

    private void aro() {
        AppMethodBeat.i(125381);
        if (!bo.isNullOrNil(this.gFS)) {
            if (this.guc != null) {
                this.guc.dismiss();
            }
            getString(R.string.tz);
            this.guc = h.b((Context) this, getString(R.string.un), true, null);
            g.Rg().a(new com.tencent.mm.plugin.account.model.g(this.gFS), 0);
        }
        AppMethodBeat.o(125381);
    }

    private void wv(String str) {
        AppMethodBeat.i(125382);
        if (com.tencent.mm.plugin.account.a.b.a.O(this, this.gFL.getText().toString())) {
            int i;
            if (this.guc != null) {
                this.guc.dismiss();
            }
            getString(R.string.tz);
            this.guc = h.b((Context) this, getString(R.string.un), true, null);
            String amN = av.amN(this.gFH.getText().toString().trim());
            if (this.gDp != null && this.gDq != null && !amN.equals(this.gDp) && amN.equals(this.gDq)) {
                i = 1;
            } else if (this.gDp == null || this.gDq == null || this.gDq.equals(this.gDp) || amN.equals(this.gDq)) {
                i = 0;
            } else {
                i = 2;
            }
            m aVar = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
            aVar.lo(this.gDr);
            aVar.lp(i);
            if (!bo.isNullOrNil(this.gFT)) {
                ((n.a) aVar.ftU.acF()).vyq.vLG = this.gFT;
            }
            if (com.tencent.mm.plugin.normsg.a.b.oTO.TL("ie_reg")) {
                com.tencent.mm.plugin.normsg.a.b.oTO.TK("ie_reg");
            }
            bqw bqw = new bqw();
            bqw.jCH = this.gFO.getText().toString();
            if (!(!this.gFM || this.gFP == null || this.gFP.isRecycled())) {
                bqw.wGk = ag.w(d.ai(this.gFP));
            }
            bqw.wTk = str;
            bqw.wTj = ag.ck(this.gFL.getText().toString());
            bqw.luP = bo.dpA();
            bqw.wTl = TimeZone.getDefault().getID();
            ab.i("MicroMsg.RegByMobileRegAIOUI", "%s,%s", bqw.luP, bqw.wTl);
            crs crs = new crs();
            crs.xpk = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.TM("ie_reg"));
            crs.xpl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.TP("ce_reg"));
            crs.xpm = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.Am(6));
            try {
                crs.xpn = new SKBuiltinBuffer_t().setBuffer(bqw.toByteArray());
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "convert to byte error ! %s", e.getMessage());
            }
            aVar.a(crs);
            g.Rg().a(aVar, 0);
            this.gDp = av.amN(this.gFH.getText().toString().trim());
            this.gDr++;
            AppMethodBeat.o(125382);
            return;
        }
        AppMethodBeat.o(125382);
    }

    private void arf() {
        AppMethodBeat.i(125383);
        if (bo.isNullOrNil(this.fHE) || bo.isNullOrNil(this.countryCode)) {
            this.grH.setText(getString(R.string.d03));
            AppMethodBeat.o(125383);
            return;
        }
        this.grH.setText(av.hS(this.fHE, this.countryCode));
        AppMethodBeat.o(125383);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(125384);
        super.onActivityResult(i, i2, intent);
        if (i != 30846) {
            if (i != 30847) {
                switch (i2) {
                    case 100:
                        this.fHE = bo.bc(intent.getStringExtra("country_name"), "");
                        this.countryCode = bo.bc(intent.getStringExtra("couttry_code"), "");
                        this.gBE = bo.bc(intent.getStringExtra("iso_code"), "");
                        if (!com.tencent.mm.au.b.sP(this.countryCode)) {
                            arf();
                            AppMethodBeat.o(125384);
                            return;
                        } else if (bo.isNullOrNil(this.gFS) || bo.isNullOrNil(this.gFU) || bo.isNullOrNil(this.gFV)) {
                            Intent intent2 = new Intent(this, MobileInputUI.class);
                            intent2.putExtra("mobile_input_purpose", 2);
                            intent2.putExtra("couttry_code", this.countryCode);
                            intent2.putExtra("country_name", this.fHE);
                            startActivity(intent2);
                            finish();
                            overridePendingTransition(R.anim.s, R.anim.s);
                            AppMethodBeat.o(125384);
                            return;
                        } else {
                            arf();
                            AppMethodBeat.o(125384);
                            return;
                        }
                    default:
                        this.gFP = com.tencent.mm.plugin.account.a.a.gkF.a((Activity) this, i, i2, intent);
                        if (this.gFP != null) {
                            this.ejo.setImageBitmap(this.gFP);
                            this.gFM = true;
                            this.gFN.setVisibility(8);
                            break;
                        }
                        break;
                }
            }
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                com.tencent.mm.plugin.report.service.h.pYm.a(712, 1, 1, false);
                AppMethodBeat.o(125384);
                return;
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(712, 2, 1, false);
            this.gFW = false;
            if (bo.isNullOrNil(this.gFS)) {
                wv(this.gFK + this.gDV);
                AppMethodBeat.o(125384);
                return;
            }
            aro();
            AppMethodBeat.o(125384);
            return;
        } else if (i2 == -1 && arr()) {
            arp();
            com.tencent.mm.plugin.b.a.wA("RE200_250");
            AppMethodBeat.o(125384);
            return;
        }
        AppMethodBeat.o(125384);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125385);
        ab.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.guc != null) {
            this.guc.dismiss();
            this.guc = null;
        }
        if (i2 == -75) {
            h.g(this, R.string.fn, R.string.djw);
            AppMethodBeat.o(125385);
            return;
        }
        com.tencent.mm.h.a jY;
        String agi;
        String str2;
        if (mVar.getType() == 145) {
            int Ah = ((com.tencent.mm.modelfriend.a) mVar).Ah();
            if (Ah == 12) {
                if (i2 == -41 || i2 == -59) {
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this, null, null);
                        AppMethodBeat.o(125385);
                        return;
                    }
                    h.g(this, R.string.dl6, R.string.dl7);
                    AppMethodBeat.o(125385);
                    return;
                }
                this.gDV = av.amN(this.gDV);
                this.gDq = this.gFK + this.gDV;
                this.gDy = ((com.tencent.mm.modelfriend.a) mVar).agt();
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    agi = ((com.tencent.mm.modelfriend.a) mVar).agi();
                    if (!bo.isNullOrNil(agi)) {
                        this.gDV = agi.trim();
                    }
                    com.tencent.mm.plugin.b.a.wz("RE200_100");
                    StringBuilder stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE200_200,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE200_200")).append(",1").toString());
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125353);
                                RegByMobileRegAIOUI.t(RegByMobileRegAIOUI.this);
                                com.tencent.mm.plugin.b.a.wA("RE200_250");
                                AppMethodBeat.o(125353);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125355);
                                StringBuilder stringBuilder = new StringBuilder();
                                g.RN();
                                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(RegByMobileRegAIOUI.this.getClass().getName()).append(",RE200_200,");
                                g.RN();
                                com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE200_200")).append(",2").toString());
                                com.tencent.mm.plugin.b.a.wA("RE200_100");
                                AppMethodBeat.o(125355);
                            }
                        });
                        AppMethodBeat.o(125385);
                        return;
                    }
                    arp();
                    com.tencent.mm.plugin.b.a.wA("RE200_250");
                    AppMethodBeat.o(125385);
                    return;
                } else if (i2 == -355) {
                    z.f(this, str, 30846);
                    this.gBm.daR = (long) this.gEu;
                    this.gBm.cVS = 5;
                    this.gBm.ajK();
                    AppMethodBeat.o(125385);
                    return;
                } else if (i2 == -34) {
                    h.b((Context) this, getString(R.string.a6k), "", true);
                    AppMethodBeat.o(125385);
                    return;
                } else if (com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
                    AppMethodBeat.o(125385);
                    return;
                } else {
                    Toast.makeText(this, getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (Ah == 14) {
                if (i2 == 0 || str == null) {
                    if (((com.tencent.mm.modelfriend.a) mVar).agj() == 1) {
                        str2 = this.gFK + this.gDV;
                        String agl = ((com.tencent.mm.modelfriend.a) mVar).agl();
                        agi = ((com.tencent.mm.modelfriend.a) mVar).agk();
                        Intent intent = new Intent(this, RegByMobileSendSmsUI.class);
                        intent.putExtra("regsession_id", this.gDy);
                        intent.putExtra("key_reg_style", 1);
                        intent.putExtra("from_mobile", str2);
                        intent.putExtra("to_mobile", agl);
                        intent.putExtra("verify_code", agi);
                        intent.putExtra("kintent_nickname", this.gFO.getText().toString());
                        intent.putExtra("kintent_password", this.gFL.getText().toString());
                        intent.putExtra("kintent_hasavatar", this.gFM);
                        intent.putExtra("reg_3d_app_type", this.gEu);
                        intent.putExtra("reg_3d_app_ticket", this.gFT);
                        startActivity(intent);
                    } else {
                        this.gFZ = ((com.tencent.mm.modelfriend.a) mVar).agn();
                        this.gGa = ((com.tencent.mm.modelfriend.a) mVar).ago();
                        this.gGb = ((com.tencent.mm.modelfriend.a) mVar).agp();
                        this.gGc = ((com.tencent.mm.modelfriend.a) mVar).agq();
                        arq();
                    }
                } else if (i2 == -41) {
                    h.g(this, R.string.dl6, R.string.dl7);
                    AppMethodBeat.o(125385);
                    return;
                } else if (i2 == -34) {
                    h.b((Context) this, getString(R.string.a6k), "", true);
                    AppMethodBeat.o(125385);
                    return;
                } else if (com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
                    AppMethodBeat.o(125385);
                    return;
                } else {
                    Toast.makeText(this, getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.o(125385);
                    return;
                }
            }
        } else if (mVar.getType() == 755) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.account.model.g gVar = (com.tencent.mm.plugin.account.model.g) mVar;
                str2 = "";
                if (gVar.ehh.fsH.fsP != null) {
                    agi = ((cgx) gVar.ehh.fsH.fsP).wIg;
                } else {
                    agi = str2;
                }
                this.gFT = agi;
                wv(this.gFK + this.gDV);
            } else if (i2 == -7) {
                this.gBm.daR = (long) this.gEu;
                this.gBm.cVS = 7;
                this.gBm.ajK();
                h.a((Context) this, getString(R.string.bml), getString(R.string.tz), getString(R.string.c9x), getString(R.string.or), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125356);
                        RegByMobileRegAIOUI.u(RegByMobileRegAIOUI.this);
                        RegByMobileRegAIOUI.this.gBm.daR = (long) RegByMobileRegAIOUI.this.gEu;
                        RegByMobileRegAIOUI.this.gBm.cVS = 8;
                        RegByMobileRegAIOUI.this.gBm.ajK();
                        AppMethodBeat.o(125356);
                    }
                }, null);
            }
        } else if ((mVar.getType() == 701 || mVar.getType() == 252) && i == 0 && i2 == 0) {
            this.gBm.daR = (long) this.gEu;
            this.gBm.cVS = 12;
            this.gBm.ajK();
            l.apX();
            z.vx(r.Yz());
            w.cm(this);
            z.showAddrBookUploadConfirm(this, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125357);
                    Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(RegByMobileRegAIOUI.this);
                    bh.addFlags(67108864);
                    RegByMobileRegAIOUI.this.startActivity(bh);
                    StringBuilder stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(RegByMobileRegAIOUI.this.getClass().getName()).append(",L14,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("L14")).append(",4").toString());
                    RegByMobileRegAIOUI.this.finish();
                    AppMethodBeat.o(125357);
                }
            }, false, 2);
            AppMethodBeat.o(125385);
            return;
        }
        if (com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
            AppMethodBeat.o(125385);
            return;
        }
        if (mVar.getType() == 252 || mVar.getType() == 701) {
            jY = com.tencent.mm.h.a.jY(str);
            if (jY != null && jY.a(this, null, null)) {
                AppMethodBeat.o(125385);
                return;
            }
        }
        AppMethodBeat.o(125385);
    }

    private void arp() {
        AppMethodBeat.i(125386);
        getString(R.string.tz);
        this.guc = h.b((Context) this, getString(R.string.dku), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        m aVar = new com.tencent.mm.modelfriend.a(this.gFK + this.gDV, 14, "", 0, "");
        aVar.rV(this.gDy);
        g.Rg().a(aVar, 0);
        AppMethodBeat.o(125386);
    }

    public void onDestroy() {
        AppMethodBeat.i(125387);
        com.tencent.mm.plugin.normsg.a.b.oTO.TK("ie_reg");
        if (this.gFX != null) {
            this.gFX.dismiss();
        }
        this.gBm.ajK();
        super.onDestroy();
        AppMethodBeat.o(125387);
    }

    private synchronized void arq() {
        AppMethodBeat.i(125388);
        if (!this.gFY) {
            this.gFY = true;
            finish();
            Intent intent = new Intent();
            intent.putExtra("bindmcontact_mobile", this.gFK + " " + this.gFH.getText().toString());
            intent.putExtra("bindmcontact_shortmobile", this.gDV);
            intent.putExtra("country_name", this.fHE);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("mobileverify_countdownsec", this.gFZ);
            intent.putExtra("mobileverify_countdownstyle", this.gGa);
            intent.putExtra("mobileverify_fb", this.gGb);
            intent.putExtra("mobileverify_reg_qq", this.gGc);
            intent.putExtra("kintent_nickname", this.gFO.getText().toString());
            intent.putExtra("kintent_password", this.gFL.getText().toString());
            intent.putExtra("kintent_hasavatar", this.gFM);
            intent.putExtra("key_reg_style", 1);
            intent.putExtra("regsession_id", this.gDy);
            intent.putExtra("reg_3d_app_ticket", this.gFT);
            intent.putExtra("reg_3d_app_type", this.gEu);
            intent.putExtra("mobile_verify_purpose", 2);
            a(MobileVerifyUI.class, intent);
        }
        AppMethodBeat.o(125388);
    }

    private boolean arr() {
        int i;
        AppMethodBeat.i(125389);
        if (bo.isNullOrNil(this.countryCode)) {
            i = 0;
        } else {
            i = 1;
        }
        i &= a(this.gFH.getText(), this.gFL.getText(), this.gFO.getText());
        if (i != 0) {
            this.gDN.setEnabled(true);
        } else {
            this.gDN.setEnabled(false);
        }
        AppMethodBeat.o(125389);
        return i;
    }

    private boolean a(Editable... editableArr) {
        boolean z;
        AppMethodBeat.i(125390);
        for (int i = 0; i < 3; i++) {
            Object obj = editableArr[i];
            if (obj == null || obj.toString().length() == 0) {
                z = false;
                break;
            }
        }
        z = true;
        if (z && this.gDT) {
            AppMethodBeat.o(125390);
            return true;
        }
        AppMethodBeat.o(125390);
        return false;
    }

    static /* synthetic */ void u(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(125397);
        regByMobileRegAIOUI.getString(R.string.tz);
        String string = regByMobileRegAIOUI.getString(R.string.cou);
        final m qVar = new q("facebook@wechat_auth", regByMobileRegAIOUI.gFS, 0, "", "", "", 0, "", true, false);
        regByMobileRegAIOUI.guc = h.b((Context) regByMobileRegAIOUI, string, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(125358);
                g.Rg().c(qVar);
                AppMethodBeat.o(125358);
            }
        });
        g.Rg().a(qVar, 0);
        AppMethodBeat.o(125397);
    }
}
