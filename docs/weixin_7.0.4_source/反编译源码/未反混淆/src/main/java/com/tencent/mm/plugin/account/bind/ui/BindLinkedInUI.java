package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.contact.e;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class BindLinkedInUI extends MMActivity implements f {
    private String dun;
    private String duo;
    private ProgressDialog fsh;
    private boolean gqJ = false;
    private String gqK;
    private boolean gqL = false;
    private boolean gqM = false;
    private boolean gqN = false;
    private Bundle gqO;
    private boolean gqP = false;
    private boolean gqQ = false;
    private TextView gqR;
    private TextView gqS;
    private View gqT;
    private MMSwitchBtn gqU;
    private TextView gqV;
    private TextView gqW;
    private TextView gqX;
    private String gqY;
    private String gqZ;
    private String gra;
    private String grb;
    private String name;
    private int status;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.i(13418);
        bindLinkedInUI.goBack();
        AppMethodBeat.o(13418);
    }

    static /* synthetic */ void a(BindLinkedInUI bindLinkedInUI, boolean z, boolean z2) {
        AppMethodBeat.i(13421);
        bindLinkedInUI.m(z, z2);
        AppMethodBeat.o(13421);
    }

    static /* synthetic */ void e(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.i(13420);
        bindLinkedInUI.dh(false);
        AppMethodBeat.o(13420);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13401);
        super.onCreate(bundle);
        g.Rg().a((int) JsApiChooseMultiMedia.CTRL_INDEX, (f) this);
        g.Rg().a((int) e.CTRL_INDEX, (f) this);
        this.gqO = getIntent().getBundleExtra("qrcode_bundle");
        this.gqM = this.gqO != null;
        if (this.gqO != null) {
            this.dun = this.gqO.getString("i");
            this.duo = this.gqO.getString("n");
            this.gqY = this.gqO.getString("t");
            this.gqZ = this.gqO.getString("o");
            this.gra = this.gqO.getString("s");
            this.grb = this.gqO.getString("r");
            if (this.dun == null || this.duo == null || this.gqY == null || this.gra == null || this.grb == null) {
                h.a((Context) this, getString(R.string.ax6), null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(13387);
                        BindLinkedInUI.a(BindLinkedInUI.this);
                        AppMethodBeat.o(13387);
                    }
                });
            }
        }
        this.gqN = getIntent().getBooleanExtra("oversea_entry", false);
        Kh();
        if (this.gqM) {
            this.gqL = true;
        }
        initView();
        if (this.gqO != null && this.gqJ && this.gqK.equals(this.dun)) {
            this.gqP = true;
            dh(true);
        }
        AppMethodBeat.o(13401);
    }

    public void onDestroy() {
        AppMethodBeat.i(13402);
        g.Rg().b((int) e.CTRL_INDEX, (f) this);
        g.Rg().b((int) JsApiChooseMultiMedia.CTRL_INDEX, (f) this);
        super.onDestroy();
        AppMethodBeat.o(13402);
    }

    public void onResume() {
        AppMethodBeat.i(13403);
        super.onResume();
        AppMethodBeat.o(13403);
    }

    public void onPause() {
        AppMethodBeat.i(13404);
        super.onPause();
        AppMethodBeat.o(13404);
    }

    public final int getLayoutId() {
        return R.layout.gf;
    }

    private void Kh() {
        boolean z = true;
        AppMethodBeat.i(13405);
        this.gqK = (String) g.RP().Ry().get(286721, null);
        this.gqJ = !bo.isNullOrNil(this.gqK);
        this.name = (String) g.RP().Ry().get(286722, null);
        this.status = r.YD();
        if ((this.status & 4194304) == 0) {
            z = false;
        }
        this.gqL = z;
        AppMethodBeat.o(13405);
    }

    public final void initView() {
        AppMethodBeat.i(13406);
        if (this.gqM) {
            setMMTitle((int) R.string.axf);
        } else if (this.gqN) {
            setMMTitle((int) R.string.axi);
        } else {
            setMMTitle((int) R.string.ax9);
        }
        this.gqR = (TextView) findViewById(R.id.a5q);
        this.gqS = (TextView) findViewById(R.id.a5p);
        this.gqT = findViewById(R.id.a5r);
        this.gqU = (MMSwitchBtn) findViewById(R.id.a5s);
        this.gqV = (TextView) findViewById(R.id.a5t);
        this.gqW = (TextView) findViewById(R.id.a5u);
        this.gqX = (TextView) findViewById(R.id.a5v);
        this.gqR.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13390);
                String str = (String) g.RP().Ry().get(286723, null);
                if (!bo.isNullOrNil(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", r.Yz());
                    d.b(BindLinkedInUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(13390);
            }
        });
        this.gqV.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13392);
                if (!BindLinkedInUI.this.gqM) {
                    BindLinkedInUI.c(BindLinkedInUI.this);
                    AppMethodBeat.o(13392);
                } else if (BindLinkedInUI.this.gqJ) {
                    h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(R.string.ax5), null, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13391);
                            BindLinkedInUI.e(BindLinkedInUI.this);
                            AppMethodBeat.o(13391);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(13392);
                } else {
                    BindLinkedInUI.e(BindLinkedInUI.this);
                    AppMethodBeat.o(13392);
                }
            }
        });
        this.gqW.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13395);
                h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(R.string.ax7), null, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(13394);
                        final m cVar = new c();
                        BindLinkedInUI.this.fsh = h.b(BindLinkedInUI.this, BindLinkedInUI.this.getString(R.string.cn5), false, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(13393);
                                g.Rg().c(cVar);
                                AppMethodBeat.o(13393);
                            }
                        });
                        g.Rg().a(cVar, 0);
                        AppMethodBeat.o(13394);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(13395);
            }
        });
        this.gqX.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13396);
                BindLinkedInUI.a(BindLinkedInUI.this);
                AppMethodBeat.o(13396);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13397);
                BindLinkedInUI.a(BindLinkedInUI.this);
                AppMethodBeat.o(13397);
                return true;
            }
        });
        cu();
        AppMethodBeat.o(13406);
    }

    private void goBack() {
        AppMethodBeat.i(13407);
        if (!this.gqM) {
            setResult(-1);
            finish();
            AppMethodBeat.o(13407);
        } else if (this.gqQ) {
            Intent bh = a.gkE.bh(this);
            bh.addFlags(603979776);
            bh.putExtra("preferred_tab", 2);
            startActivity(bh);
            AppMethodBeat.o(13407);
        } else {
            setResult(-1);
            finish();
            AppMethodBeat.o(13407);
        }
    }

    private void dh(boolean z) {
        AppMethodBeat.i(13408);
        if (this.gqO == null) {
            ab.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
            AppMethodBeat.o(13408);
            return;
        }
        final m aVar = new com.tencent.mm.plugin.account.bind.a.a(this.gqU.zMU ? 1 : 2, this.dun, this.duo, "", this.gqY, this.gqZ, this.gra, this.grb);
        if (!z) {
            this.fsh = h.b((Context) this, getString(R.string.cn5), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(13398);
                    g.Rg().c(aVar);
                    AppMethodBeat.o(13398);
                }
            });
        }
        g.Rg().a(aVar, 0);
        AppMethodBeat.o(13408);
    }

    private void vK(String str) {
        AppMethodBeat.i(13409);
        int indexOf = getString(R.string.ax3).indexOf("%s");
        Spannable newSpannable = Factory.getInstance().newSpannable(getString(R.string.ax3, new Object[]{str}));
        newSpannable.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
            }

            public final void updateDrawState(TextPaint textPaint) {
                AppMethodBeat.i(13399);
                textPaint.setColor(BindLinkedInUI.this.getResources().getColor(R.color.t7));
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(13399);
            }
        }, indexOf, str.length() + indexOf, 33);
        this.gqR.setText(newSpannable);
        AppMethodBeat.o(13409);
    }

    private void d(boolean z, String str, boolean z2) {
        AppMethodBeat.i(13410);
        this.gqR.setVisibility(0);
        vK(str);
        this.gqT.setVisibility(0);
        this.gqW.setVisibility(8);
        if (z) {
            this.gqS.setVisibility(8);
            this.gqV.setVisibility(8);
            this.gqX.setVisibility(8);
            this.gqU.setCheck(z2);
            this.gqU.setSwitchListener(new MMSwitchBtn.a() {
                public final void di(boolean z) {
                    AppMethodBeat.i(13400);
                    BindLinkedInUI.a(BindLinkedInUI.this, z, true);
                    AppMethodBeat.o(13400);
                }
            });
            AppMethodBeat.o(13410);
            return;
        }
        this.gqS.setVisibility(0);
        this.gqV.setVisibility(0);
        this.gqX.setVisibility(0);
        this.gqU.setCheck(z2);
        this.gqU.setSwitchListener(new MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(13388);
                BindLinkedInUI.a(BindLinkedInUI.this, z, false);
                AppMethodBeat.o(13388);
            }
        });
        AppMethodBeat.o(13410);
    }

    private void a(boolean z, boolean z2, String str, boolean z3) {
        AppMethodBeat.i(13411);
        this.gqX.setVisibility(8);
        if (z) {
            this.gqS.setVisibility(8);
            this.gqR.setVisibility(0);
            vK(str);
            this.gqT.setVisibility(0);
            this.gqV.setVisibility(8);
            if (z2) {
                this.gqW.setVisibility(0);
            }
            this.gqU.setCheck(z3);
            this.gqU.setSwitchListener(new MMSwitchBtn.a() {
                public final void di(boolean z) {
                    AppMethodBeat.i(13389);
                    BindLinkedInUI.a(BindLinkedInUI.this, z, true);
                    AppMethodBeat.o(13389);
                }
            });
            AppMethodBeat.o(13411);
            return;
        }
        this.gqR.setVisibility(8);
        this.gqR.setText(getString(R.string.ax4));
        this.gqS.setVisibility(0);
        this.gqT.setVisibility(8);
        this.gqV.setVisibility(0);
        this.gqW.setVisibility(8);
        AppMethodBeat.o(13411);
    }

    private void cu() {
        boolean z = true;
        AppMethodBeat.i(13412);
        if (this.gqM && this.gqO == null) {
            ab.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
            AppMethodBeat.o(13412);
        } else if (this.gqN) {
            a(this.gqJ, false, this.name, this.gqL);
            AppMethodBeat.o(13412);
        } else if (this.gqM) {
            if (!(this.gqJ && this.gqK.equals(this.dun))) {
                z = false;
            }
            d(z, this.duo, this.gqL);
            AppMethodBeat.o(13412);
        } else {
            a(this.gqJ, true, this.name, this.gqL);
            AppMethodBeat.o(13412);
        }
    }

    private void m(boolean z, boolean z2) {
        AppMethodBeat.i(13413);
        if (z) {
            this.status |= 4194304;
        } else {
            this.status &= -4194305;
        }
        int i = z ? 1 : 2;
        g.RP().Ry().set(7, Integer.valueOf(this.status));
        if (z2) {
            act act = new act();
            act.wkw = 33;
            act.pvD = i;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
            a.gkF.BS();
        }
        AppMethodBeat.o(13413);
    }

    private boolean w(Intent intent) {
        AppMethodBeat.i(13414);
        Bundle bundleExtra = intent.getBundleExtra("result_data");
        String string = bundleExtra.getString("ret");
        Object string2 = bundleExtra.getString("limid");
        Object string3 = bundleExtra.getString("liname");
        Object string4 = bundleExtra.getString("liurl");
        String string5 = bundleExtra.getString("liswitch");
        if (bo.isNullOrNil(string)) {
            ab.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
            AppMethodBeat.o(13414);
            return false;
        }
        int ank = bo.ank(string);
        if (ank != 0) {
            int i;
            ab.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", Integer.valueOf(ank));
            if (ank == 1) {
                i = R.string.axd;
            } else {
                i = R.string.axc;
            }
            h.b((Context) this, getString(i), null, true);
            AppMethodBeat.o(13414);
            return false;
        } else if (bo.isNullOrNil(string2)) {
            ab.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
            AppMethodBeat.o(13414);
            return false;
        } else {
            ab.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", string2, string3, string4, string5);
            g.RP().Ry().set(286722, string3);
            g.RP().Ry().set(286721, string2);
            g.RP().Ry().set(286723, string4);
            if (!bo.isNullOrNil(string5)) {
                m(bo.ank(string5) == 1, false);
            }
            Kh();
            cu();
            string5 = getString(R.string.ax_);
            AnonymousClass4 anonymousClass4 = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.bQ(this, string5);
            AppMethodBeat.o(13414);
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13415);
        ab.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (intent == null) {
            AppMethodBeat.o(13415);
            return;
        }
        switch (i) {
            case 100:
                w(intent);
                AppMethodBeat.o(13415);
                return;
            default:
                ab.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
                AppMethodBeat.o(13415);
                return;
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(13416);
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        int i3;
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == JsApiChooseMultiMedia.CTRL_INDEX) {
                this.gqQ = true;
                if (this.gqP) {
                    i3 = R.string.axa;
                } else {
                    i3 = R.string.ax_;
                }
            } else if (mVar.getType() == e.CTRL_INDEX) {
                i3 = R.string.axk;
            } else {
                AppMethodBeat.o(13416);
                return;
            }
            String string = getString(i3);
            AnonymousClass5 anonymousClass5 = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.bQ(this, string);
            Kh();
            this.gqL = this.gqU.zMU;
            cu();
            AppMethodBeat.o(13416);
            return;
        }
        if (mVar.getType() == JsApiChooseMultiMedia.CTRL_INDEX) {
            if (i2 == 1) {
                i3 = R.string.axd;
            } else {
                i3 = R.string.axc;
            }
        } else if (mVar.getType() == e.CTRL_INDEX) {
            i3 = R.string.axe;
        } else {
            AppMethodBeat.o(13416);
            return;
        }
        h.b((Context) this, getString(i3), null, true);
        AppMethodBeat.o(13416);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13417);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(13417);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13417);
        return onKeyDown;
    }

    static /* synthetic */ void c(BindLinkedInUI bindLinkedInUI) {
        AppMethodBeat.i(13419);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", r.Yz());
        if (bindLinkedInUI.gqN) {
            intent.putExtra("geta8key_scene", 3);
        } else {
            intent.putExtra("geta8key_scene", 8);
        }
        d.b((Context) bindLinkedInUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
        AppMethodBeat.o(13419);
    }
}
