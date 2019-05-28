package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.view.d;

@a(3)
public class WebWXLogoutUI extends MMActivity implements f, as {
    private boolean jZK;
    private c qLL = new c<sk>() {
        {
            AppMethodBeat.i(26547);
            this.xxI = sk.class.getName().hashCode();
            AppMethodBeat.o(26547);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26548);
            sk skVar = (sk) bVar;
            ab.d("MicroMsg.WebWXLogoutUI", "status Notify function");
            if (skVar.cOH.czE == 8) {
                WebWXLogoutUI.this.finish();
            }
            AppMethodBeat.o(26548);
            return false;
        }
    };
    private ProgressDialog qlZ = null;
    private ImageView uLA;
    private int uLB;
    private int uLC;
    private int uLD;
    private Animator uLE;
    private int uLF;
    private boolean uLr = false;
    private boolean uLx;
    private ImageButton uLy;
    private ImageButton uLz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebWXLogoutUI() {
        AppMethodBeat.i(26549);
        AppMethodBeat.o(26549);
    }

    static /* synthetic */ void b(WebWXLogoutUI webWXLogoutUI, boolean z) {
        AppMethodBeat.i(26561);
        webWXLogoutUI.oh(z);
        AppMethodBeat.o(26561);
    }

    static /* synthetic */ boolean b(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.i(26562);
        boolean ddi = webWXLogoutUI.ddi();
        AppMethodBeat.o(26562);
        return ddi;
    }

    static /* synthetic */ void c(WebWXLogoutUI webWXLogoutUI, boolean z) {
        AppMethodBeat.i(26563);
        webWXLogoutUI.og(z);
        AppMethodBeat.o(26563);
    }

    static /* synthetic */ void h(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.i(26567);
        webWXLogoutUI.aMk();
        AppMethodBeat.o(26567);
    }

    public final int getLayoutId() {
        return R.layout.b7k;
    }

    public void finish() {
        AppMethodBeat.i(26550);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.ce);
        AppMethodBeat.o(26550);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26551);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.uLF = getIntent().getIntExtra("intent.key.online_version", 0);
        }
        initView();
        overridePendingTransition(R.anim.cg, R.anim.s);
        aw.Rg().a((int) d.MIC_PTU_TRANS_KONGCHENG, (f) this);
        aw.Rg().a(792, (f) this);
        aw.ZK();
        com.tencent.mm.model.c.a(this);
        com.tencent.mm.sdk.b.a.xxA.c(this.qLL);
        AppMethodBeat.o(26551);
    }

    public void onPause() {
        AppMethodBeat.i(26552);
        super.onPause();
        if (this.uLr && aw.RK()) {
            act act = new act();
            act.wkw = 27;
            act.pvD = r.ku(r.YF()) ? 1 : 2;
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new j.a(23, act));
            this.uLr = false;
        }
        AppMethodBeat.o(26552);
    }

    public void onDestroy() {
        AppMethodBeat.i(26553);
        super.onDestroy();
        overridePendingTransition(R.anim.s, R.anim.ce);
        aw.Rg().b((int) d.MIC_PTU_TRANS_KONGCHENG, (f) this);
        aw.Rg().b(792, (f) this);
        aw.ZK();
        com.tencent.mm.model.c.b(this);
        com.tencent.mm.sdk.b.a.xxA.d(this.qLL);
        AppMethodBeat.o(26553);
    }

    public final void initView() {
        AppMethodBeat.i(26554);
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26538);
                WebWXLogoutUI.this.finish();
                AppMethodBeat.o(26538);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        dyb();
        if (com.tencent.mm.m.a.MC()) {
            this.uLz = (ImageButton) findViewById(R.id.fkr);
            if (r.ku(r.YF())) {
                this.uLx = true;
            } else {
                this.uLx = false;
            }
            oh(this.uLx);
            this.uLz.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(26539);
                    WebWXLogoutUI.this.uLx = !WebWXLogoutUI.this.uLx;
                    WebWXLogoutUI.b(WebWXLogoutUI.this, WebWXLogoutUI.this.uLx);
                    WebWXLogoutUI.b(WebWXLogoutUI.this);
                    AppMethodBeat.o(26539);
                }
            });
        } else {
            findViewById(R.id.fkq).setVisibility(8);
            this.uLx = false;
        }
        this.uLA = (ImageView) findViewById(R.id.b9u);
        ab.d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + l.ajj());
        if (l.ajj()) {
            findViewById(R.id.fkt).setVisibility(8);
        } else {
            final Animator loadAnimator = AnimatorInflater.loadAnimator(this, R.animator.b);
            loadAnimator.setTarget(findViewById(R.id.fkv));
            this.uLE = AnimatorInflater.loadAnimator(this, R.animator.c);
            this.uLE.setTarget(findViewById(R.id.fkv));
            this.uLE.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(26540);
                    super.onAnimationEnd(animator);
                    WebWXLogoutUI.c(WebWXLogoutUI.this, WebWXLogoutUI.this.jZK);
                    AppMethodBeat.o(26540);
                }
            });
            this.jZK = l.ajh();
            this.uLy = (ImageButton) findViewById(R.id.fku);
            og(this.jZK);
            this.uLy.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(26541);
                    if (WebWXLogoutUI.this.jZK) {
                        WebWXLogoutUI.this.uLy.setImageResource(R.raw.connect_icon_lock_on_regular);
                    } else {
                        WebWXLogoutUI.this.uLy.setImageResource(R.raw.connect_icon_lock_off_regular);
                    }
                    WebWXLogoutUI.e(WebWXLogoutUI.this);
                    WebWXLogoutUI.this.findViewById(R.id.fkv).setVisibility(0);
                    loadAnimator.start();
                    AppMethodBeat.o(26541);
                }
            });
        }
        ImageButton imageButton = (ImageButton) findViewById(R.id.fkx);
        ab.d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + l.ajk());
        if (l.ajk()) {
            imageButton.setVisibility(8);
        } else {
            imageButton.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(26542);
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", "filehelper");
                    intent.putExtra("key_show_bottom_app_panel", true);
                    com.tencent.mm.plugin.webwx.a.gkE.d(intent, WebWXLogoutUI.this);
                    ab.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
                    WebWXLogoutUI.this.finish();
                    AppMethodBeat.o(26542);
                }
            });
        }
        Button button = (Button) findViewById(R.id.fky);
        button.setText(l.fOX);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26543);
                ab.d("MicroMsg.WebWXLogoutUI", "logout webwx");
                WebWXLogoutUI.f(WebWXLogoutUI.this);
                AppMethodBeat.o(26543);
            }
        });
        Drawable drawable;
        Drawable drawable2;
        if (l.ajf() == 1) {
            drawable = getResources().getDrawable(R.raw.connect_pc);
            drawable2 = getResources().getDrawable(R.raw.connect_pc_mute);
            if (!(drawable == null || drawable2 == null)) {
                this.uLB = drawable.getIntrinsicWidth();
                this.uLC = drawable2.getIntrinsicWidth();
            }
        } else if (l.ajf() == 2) {
            drawable = getResources().getDrawable(R.raw.connect_mac);
            drawable2 = getResources().getDrawable(R.raw.connect_mac_mute);
            if (!(drawable == null || drawable2 == null)) {
                this.uLB = drawable.getIntrinsicWidth();
                this.uLC = drawable2.getIntrinsicWidth();
            }
        }
        this.uLA.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26544);
                WebWXLogoutUI.this.uLD = WebWXLogoutUI.g(WebWXLogoutUI.this);
                WebWXLogoutUI.h(WebWXLogoutUI.this);
                AppMethodBeat.o(26544);
            }
        });
        AppMethodBeat.o(26554);
    }

    private void aMk() {
        AppMethodBeat.i(26555);
        if (!bo.isNullOrNil(l.fOP)) {
            ((TextView) findViewById(R.id.fko)).setText(l.fOP);
            if (l.ajf() == 1) {
                if (!this.uLx) {
                    this.uLA.setImageResource(R.raw.connect_pc_mute);
                    this.uLA.setPadding(this.uLC - this.uLB, this.uLD, 0, 0);
                    AppMethodBeat.o(26555);
                    return;
                }
            } else if (l.ajf() == 2) {
                if (this.uLx) {
                    ((TextView) findViewById(R.id.fkp)).setText(R.string.g06);
                } else if (!com.tencent.mm.m.a.MC()) {
                    ((TextView) findViewById(R.id.fkp)).setText("");
                }
                if (this.jZK) {
                    ((TextView) findViewById(R.id.fko)).setText(getString(R.string.fzq, new Object[]{"Mac"}));
                    this.uLA.setImageResource(R.raw.connect_mac_lock);
                    this.uLA.setPadding(0, this.uLD, 0, 0);
                    if (com.tencent.mm.m.a.MC() && !this.uLx) {
                        ((TextView) findViewById(R.id.fkp)).setText(R.string.fzm);
                        this.uLA.setImageResource(R.raw.connect_mac_mute_lock);
                        this.uLA.setPadding(this.uLC - this.uLB, this.uLD, 0, 0);
                        AppMethodBeat.o(26555);
                        return;
                    }
                }
                ((TextView) findViewById(R.id.fko)).setText(getString(R.string.fzt, new Object[]{"Mac"}));
                this.uLA.setImageResource(R.raw.connect_mac);
                this.uLA.setPadding(0, this.uLD, 0, 0);
                if (com.tencent.mm.m.a.MC() && !this.uLx) {
                    ((TextView) findViewById(R.id.fkp)).setText(R.string.fzm);
                    this.uLA.setImageResource(R.raw.connect_mac_mute);
                    this.uLA.setPadding(this.uLC - this.uLB, this.uLD, 0, 0);
                    AppMethodBeat.o(26555);
                    return;
                }
            } else if (l.ajf() == 3) {
                this.uLA.setImageResource(R.raw.connect_ipad);
                this.uLA.setPadding(0, this.uLD, 0, 0);
                AppMethodBeat.o(26555);
                return;
            }
            this.uLA.setImageResource(R.raw.connect_pc);
            this.uLA.setPadding(0, this.uLD, 0, 0);
        }
        AppMethodBeat.o(26555);
    }

    private void og(boolean z) {
        AppMethodBeat.i(26556);
        if (this.uLy != null) {
            if (z) {
                this.uLy.setImageResource(R.drawable.bm6);
                ((TextView) findViewById(R.id.fkw)).setText(R.string.g07);
                AppMethodBeat.o(26556);
                return;
            }
            this.uLy.setImageResource(R.drawable.bm4);
            ((TextView) findViewById(R.id.fkw)).setText(R.string.fzp);
        }
        AppMethodBeat.o(26556);
    }

    private void oh(boolean z) {
        AppMethodBeat.i(26557);
        if (this.uLz != null) {
            if (z) {
                this.uLz.setImageResource(R.drawable.bm2);
                AppMethodBeat.o(26557);
                return;
            }
            this.uLz.setImageResource(R.drawable.bm5);
        }
        AppMethodBeat.o(26557);
    }

    private boolean ddi() {
        AppMethodBeat.i(26558);
        if (aw.RK()) {
            int YF = r.YF();
            if (this.uLx) {
                YF |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            } else {
                YF &= -8193;
            }
            com.tencent.mm.m.f.iZ(YF);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(40, Integer.valueOf(YF));
            this.uLr = true;
            aMk();
            AppMethodBeat.o(26558);
            return true;
        }
        AppMethodBeat.o(26558);
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26559);
        if (this.qlZ != null) {
            this.qlZ.dismiss();
            this.qlZ = null;
        }
        if (mVar.getType() == d.MIC_PTU_TRANS_KONGCHENG) {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, R.string.g04, 1).show();
            }
            finish();
            AppMethodBeat.o(26559);
            return;
        }
        if (mVar.getType() == 792) {
            int i3 = ((com.tencent.mm.plugin.webwx.a.b) mVar).czE;
            if (this.uLE != null) {
                this.uLE.start();
            }
            if (i == 0 && i2 == 0) {
                this.jZK = i3 == 1;
                l.cR(this.jZK);
                aMk();
                String str2 = "MicroMsg.WebWXLogoutUI";
                String str3 = "%s extDevice success";
                Object[] objArr = new Object[1];
                objArr[0] = this.jZK ? "lock" : "unlock";
                ab.d(str2, str3, objArr);
            } else if (i3 == 1) {
                Toast.makeText(this, R.string.fzr, 0).show();
                AppMethodBeat.o(26559);
                return;
            } else {
                Toast.makeText(this, R.string.g08, 0).show();
                AppMethodBeat.o(26559);
                return;
            }
        }
        AppMethodBeat.o(26559);
    }

    public final void ZB() {
        AppMethodBeat.i(26560);
        aw.ZK();
        if (com.tencent.mm.model.c.XI()) {
            if (l.ajh() && !this.jZK) {
                ab.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
                this.jZK = true;
                og(this.jZK);
                aMk();
            }
            AppMethodBeat.o(26560);
            return;
        }
        finish();
        AppMethodBeat.o(26560);
    }

    static /* synthetic */ void e(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.i(26564);
        if (webWXLogoutUI.jZK) {
            aw.Rg().a(new com.tencent.mm.plugin.webwx.a.b(2), 0);
            ab.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : UNLOCK");
            AppMethodBeat.o(26564);
            return;
        }
        aw.Rg().a(new com.tencent.mm.plugin.webwx.a.b(1), 0);
        ab.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : LOCK");
        AppMethodBeat.o(26564);
    }

    static /* synthetic */ boolean f(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.i(26565);
        if (webWXLogoutUI.uLF == l.aji()) {
            h.d(webWXLogoutUI.mController.ylL, l.fOU, webWXLogoutUI.getString(R.string.tz), webWXLogoutUI.getString(R.string.g03), webWXLogoutUI.getString(R.string.or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(26546);
                    final m abVar = new com.tencent.mm.modelsimple.ab(1);
                    aw.Rg().a(abVar, 0);
                    WebWXLogoutUI webWXLogoutUI = WebWXLogoutUI.this;
                    Context context = WebWXLogoutUI.this.mController.ylL;
                    WebWXLogoutUI.this.getString(R.string.tz);
                    webWXLogoutUI.qlZ = h.b(context, null, true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(26545);
                            aw.Rg().c(abVar);
                            if (WebWXLogoutUI.this.qlZ != null) {
                                WebWXLogoutUI.this.qlZ.cancel();
                            }
                            AppMethodBeat.o(26545);
                        }
                    });
                    AppMethodBeat.o(26546);
                }
            }, null);
        } else {
            webWXLogoutUI.finish();
        }
        AppMethodBeat.o(26565);
        return true;
    }

    static /* synthetic */ int g(WebWXLogoutUI webWXLogoutUI) {
        AppMethodBeat.i(26566);
        int de = ak.de(webWXLogoutUI.mController.ylL);
        int hF = ak.hF(webWXLogoutUI.mController.ylL);
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        ab.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(hF), Integer.valueOf(point.y), Integer.valueOf(de));
        de = (((int) (((double) r2) / 4.0d)) - hF) - de;
        AppMethodBeat.o(26566);
        return de;
    }
}
