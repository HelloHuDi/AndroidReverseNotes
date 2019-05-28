package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.aa.a.c.f;
import com.tencent.mm.plugin.aa.a.c.g;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

public class PaylistAAUI extends BaseAAPresenterActivity {
    private String cJH;
    private String cva;
    private View gnR;
    private Dialog gnn = null;
    private String gpA;
    private long gpB;
    private g gpl = ((g) V(g.class));
    private f gpm = ((f) Z(f.class));
    private LinearLayout gpn;
    private LinearLayout gpo;
    private LinearLayout gpp;
    private WalletTextView gpq;
    private Button gpr;
    private TextView gps;
    private TextView gpt;
    private TextView gpu;
    private TextView gpv;
    private String gpw;
    private String gpx;
    private String gpy;
    private int gpz;
    private String title;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PaylistAAUI() {
        AppMethodBeat.i(40885);
        AppMethodBeat.o(40885);
    }

    static /* synthetic */ void j(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(40903);
        paylistAAUI.aoL();
        AppMethodBeat.o(40903);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40886);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40864);
                PaylistAAUI.this.finish();
                AppMethodBeat.o(40864);
                return false;
            }
        });
        setMMTitle((int) R.string.cm5);
        this.gpx = getIntent().getStringExtra("chatroom");
        this.gpn = (LinearLayout) findViewById(R.id.dkz);
        this.gpo = (LinearLayout) findViewById(R.id.dl2);
        this.gpp = (LinearLayout) findViewById(R.id.dl_);
        this.gps = (TextView) findViewById(R.id.dl0);
        this.gpt = (TextView) findViewById(R.id.dl1);
        this.gnR = findViewById(R.id.bhm);
        this.gpu = (TextView) findViewById(R.id.dl8);
        this.gpu.setClickable(true);
        this.gpu.setOnTouchListener(new m(this));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.dbq));
        spannableStringBuilder.setSpan(new a(new a() {
            public final void aos() {
                AppMethodBeat.i(40873);
                int i = !t.kH(PaylistAAUI.this.gpx) ? R.string.ezf : R.string.eze;
                e.a aVar = new e.a(PaylistAAUI.this);
                aVar.al(PaylistAAUI.this.getString(R.string.ezg));
                View inflate = v.hu(PaylistAAUI.this).inflate(R.layout.b16, null);
                TextView textView = (TextView) inflate.findViewById(R.id.ct);
                ((ImageView) inflate.findViewById(R.id.bl)).setImageResource(R.drawable.bee);
                textView.setText(i);
                aVar.fo(inflate);
                aVar.Qg(R.string.tf);
                aVar.zQK = PaylistAAUI.this.getString(R.string.or);
                aVar.zQM = false;
                aVar.a(new c() {
                    public final void d(boolean z, String str) {
                    }
                }, new c() {
                    public final void d(boolean z, String str) {
                        AppMethodBeat.i(40872);
                        PaylistAAUI.b(PaylistAAUI.this);
                        AppMethodBeat.o(40872);
                    }
                });
                aVar.show();
                h.pYm.e(13721, Integer.valueOf(4), Integer.valueOf(7));
                AppMethodBeat.o(40873);
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.gpu.setText(spannableStringBuilder);
        this.gpv = (TextView) findViewById(R.id.dld);
        aoL();
        AppMethodBeat.o(40886);
    }

    private void aoL() {
        AppMethodBeat.i(40887);
        this.gnn = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
        this.gnR.setVisibility(4);
        this.gpl.gmS.aor().f(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.protocal.protobuf.v>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(40875);
                com.tencent.mm.protocal.protobuf.v vVar = (com.tencent.mm.protocal.protobuf.v) obj;
                if (vVar == null) {
                    ab.e("MicroMsg.PaylistAAUI", "queryDetailRes is null!!!");
                    PaylistAAUI.a(PaylistAAUI.this, null);
                } else {
                    ab.i("MicroMsg.PaylistAAUI", "get queryDetailRes: %s, billNo: %s, type: %s, state: %s, is_launcher: %s, role: %s, role_state: %s, payer_list.size: %s", vVar, vVar.vzL, Integer.valueOf(vVar.type), Integer.valueOf(vVar.state), Integer.valueOf(vVar.vAq), Integer.valueOf(vVar.vzW), Integer.valueOf(vVar.vAr), Integer.valueOf(vVar.vzQ.size()));
                    ab.i("MicroMsg.PaylistAAUI", "paid_num: %s, plan_num: %s, activity_amount: %s", Integer.valueOf(vVar.vAo), Integer.valueOf(vVar.vAm), Long.valueOf(vVar.vAy));
                    PaylistAAUI.this.gnR.setVisibility(0);
                    PaylistAAUI.this.gpy = vVar.vAk;
                    PaylistAAUI.this.gpz = vVar.vzQ.size() + 1;
                    PaylistAAUI.this.title = vVar.title;
                    PaylistAAUI.a(PaylistAAUI.this, vVar);
                    PaylistAAUI.b(PaylistAAUI.this, vVar);
                    PaylistAAUI.c(PaylistAAUI.this, vVar);
                    PaylistAAUI.d(PaylistAAUI.this, vVar);
                    PaylistAAUI.e(PaylistAAUI.this, vVar);
                    if (PaylistAAUI.this.gnn != null) {
                        PaylistAAUI.this.gnn.dismiss();
                        PaylistAAUI.this.gnn = null;
                    }
                }
                Void voidR = zXH;
                AppMethodBeat.o(40875);
                return voidR;
            }
        }).a((d.a) new d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(40874);
                ab.i("MicroMsg.PaylistAAUI", "onInterrupt: %s", obj);
                PaylistAAUI.a(PaylistAAUI.this, obj == null ? "" : obj.toString());
                AppMethodBeat.o(40874);
            }
        });
        AppMethodBeat.o(40887);
    }

    public void onDestroy() {
        AppMethodBeat.i(40888);
        super.onDestroy();
        AppMethodBeat.o(40888);
    }

    private static boolean K(int i, int i2, int i3) {
        return i == com.tencent.mm.plugin.aa.a.a.gld && i2 != com.tencent.mm.plugin.aa.a.a.glh && i3 == com.tencent.mm.plugin.aa.a.a.gkZ;
    }

    private void a(List<com.tencent.mm.protocal.protobuf.t> list, String str, boolean z) {
        AppMethodBeat.i(40889);
        ((TextView) findViewById(R.id.dl7)).setText(str);
        this.gpu.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.dl9);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z2;
            com.tencent.mm.protocal.protobuf.t tVar = (com.tencent.mm.protocal.protobuf.t) list.get(i);
            if (i >= list.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            a(linearLayout, tVar, z2);
        }
        AppMethodBeat.o(40889);
    }

    private void d(List<com.tencent.mm.protocal.protobuf.t> list, String str) {
        AppMethodBeat.i(40890);
        ((TextView) findViewById(R.id.dla)).setText(str);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.dlb);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z;
            com.tencent.mm.protocal.protobuf.t tVar = (com.tencent.mm.protocal.protobuf.t) list.get(i);
            if (i >= list.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            a(linearLayout, tVar, z);
        }
        AppMethodBeat.o(40890);
    }

    private void a(LinearLayout linearLayout, com.tencent.mm.protocal.protobuf.t tVar, boolean z) {
        AppMethodBeat.i(40891);
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(R.layout.ajy, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.dkt);
        TextView textView = (TextView) linearLayout2.findViewById(R.id.dku);
        TextView textView2 = (TextView) linearLayout2.findViewById(R.id.dkv);
        View findViewById = linearLayout2.findViewById(R.id.p3);
        if (z) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        b.b(imageView, tVar.vAh);
        textView.setText(j.b(this.mController.ylL, this.gpm.mJ(tVar.vAh), textView.getTextSize()));
        if (tVar.vAj == com.tencent.mm.plugin.aa.a.a.glk) {
            textView2.setText(getString(R.string.dbn, new Object[]{Double.valueOf(((double) tVar.vzU) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(R.color.wj));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
            AppMethodBeat.o(40891);
        } else if (tVar.vAj == com.tencent.mm.plugin.aa.a.a.glj) {
            textView2.setText(getString(R.string.dbd, new Object[]{Double.valueOf(((double) tVar.vzU) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(R.color.wl));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
            AppMethodBeat.o(40891);
        } else {
            textView2.setVisibility(8);
            linearLayout.addView(linearLayout2);
            AppMethodBeat.o(40891);
        }
    }

    public final int getLayoutId() {
        return R.layout.ajz;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(40892);
        super.onActivityResult(i, i2, intent);
        Intent intent2;
        String stringExtra;
        if (i == com.tencent.view.d.MIC_PTU_MEISHI) {
            if (i2 == -1) {
                ab.i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", this.cJH);
                RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                if (realnameGuideHelper != null) {
                    ab.i("MicroMsg.PaylistAAUI", "do realname guide");
                    intent2 = new Intent();
                    intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    com.tencent.mm.bp.d.b((Context) this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
                }
                com.tencent.mm.plugin.aa.a.h.vF(this.gpx);
                finish();
                com.tencent.mm.vending.g.f.h(this.cJH, this.gpy, this.gpA).c(this.gpl.gmU).f(new com.tencent.mm.vending.c.a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(40871);
                        ab.i("MicroMsg.PaylistAAUI", "insert msg finish");
                        Void voidR = zXH;
                        AppMethodBeat.o(40871);
                        return voidR;
                    }
                });
                h.pYm.a(407, 12, 1, false);
                stringExtra = intent.getStringExtra("key_trans_id");
                g.c cVar = this.gpl.gmV;
                long j = this.gpB;
                com.tencent.mm.vending.g.f.h(Long.valueOf(j), this.cva, stringExtra).c(cVar);
                AppMethodBeat.o(40892);
                return;
            }
        } else if (i == 222 && i2 == -1) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            ab.i("MicroMsg.PaylistAAUI", "select chatroom：%s", stringExtra);
            if (!bo.isNullOrNil(stringExtra)) {
                intent2 = new Intent(this.mController.ylL, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 3);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
        AppMethodBeat.o(40892);
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(40893);
        if (paylistAAUI.gnn != null) {
            paylistAAUI.gnn.dismiss();
        }
        paylistAAUI.gnn = com.tencent.mm.wallet_core.ui.g.a((Context) paylistAAUI, false, null);
        com.tencent.mm.vending.g.f.dMn().c(paylistAAUI.gpl.gmX).f(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(40870);
                Boolean bool = (Boolean) obj;
                if (PaylistAAUI.this.gnn != null) {
                    PaylistAAUI.this.gnn.dismiss();
                }
                if (bool.booleanValue()) {
                    ab.i("MicroMsg.PaylistAAUI", "urgeAAPay success");
                    Toast.makeText(PaylistAAUI.this, R.string.ezi, 1).show();
                } else {
                    ab.i("MicroMsg.PaylistAAUI", "urgeAAPay fail");
                    Toast.makeText(PaylistAAUI.this, R.string.ezh, 1).show();
                }
                Void voidR = zXH;
                AppMethodBeat.o(40870);
                return voidR;
            }
        }).a((d.a) new d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(40869);
                if (PaylistAAUI.this.gnn != null) {
                    PaylistAAUI.this.gnn.dismiss();
                }
                if (!(obj instanceof String) || obj.toString().equalsIgnoreCase("ok")) {
                    Toast.makeText(PaylistAAUI.this, R.string.ezh, 1).show();
                } else {
                    Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                }
                ab.e("MicroMsg.PaylistAAUI", "urgeAAPay fail");
                AppMethodBeat.o(40869);
            }
        });
        h.pYm.e(13721, Integer.valueOf(4), Integer.valueOf(8));
        AppMethodBeat.o(40893);
    }

    static /* synthetic */ void e(PaylistAAUI paylistAAUI, com.tencent.mm.protocal.protobuf.v vVar) {
        AppMethodBeat.i(40899);
        if (vVar.vzW == com.tencent.mm.plugin.aa.a.a.gld && vVar.vAk.equals(r.Yz())) {
            paylistAAUI.gpv.setVisibility(0);
        } else {
            paylistAAUI.gpv.setVisibility(8);
        }
        if (paylistAAUI.gpv.getVisibility() != 0) {
            ab.i("MicroMsg.PaylistAAUI", "no need to show bottom tv");
            AppMethodBeat.o(40899);
        } else if (bo.isNullOrNil(vVar.vAw)) {
            ab.i("MicroMsg.PaylistAAUI", "wording is null");
            AppMethodBeat.o(40899);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(vVar.vAw);
            if (vVar.vAx == 1) {
                paylistAAUI.gpv.setClickable(true);
                paylistAAUI.gpv.setOnTouchListener(new m(paylistAAUI));
                spannableStringBuilder.setSpan(new a(new a() {
                    public final void aos() {
                        AppMethodBeat.i(40876);
                        Intent intent = new Intent();
                        intent.putExtra("key_scene_balance_manager", 0);
                        com.tencent.mm.bp.d.b(PaylistAAUI.this, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
                        h.pYm.e(13721, Integer.valueOf(4), Integer.valueOf(4));
                        AppMethodBeat.o(40876);
                    }
                }), 0, spannableStringBuilder.length(), 18);
            }
            paylistAAUI.gpv.setText(spannableStringBuilder);
            paylistAAUI.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(40877);
                    int height = PaylistAAUI.this.getWindow().getDecorView().getHeight();
                    int[] iArr = new int[2];
                    View findViewById = PaylistAAUI.this.findViewById(R.id.dkw);
                    findViewById.getLocationInWindow(iArr);
                    int height2 = iArr[1] + findViewById.getHeight();
                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(PaylistAAUI.this.mController.ylL, 20);
                    int fromDPToPix2 = ((height - height2) - com.tencent.mm.bz.a.fromDPToPix(PaylistAAUI.this.mController.ylL, 24)) - com.tencent.mm.bz.a.fromDPToPix(PaylistAAUI.this.mController.ylL, 12);
                    if (fromDPToPix2 < fromDPToPix) {
                        fromDPToPix2 = fromDPToPix;
                    }
                    ab.d("MicroMsg.PaylistAAUI", "height: %s, h1: %s, topMargin: %s", Integer.valueOf(height), Integer.valueOf(height2), Integer.valueOf(fromDPToPix2));
                    LayoutParams layoutParams = (LayoutParams) PaylistAAUI.this.gpv.getLayoutParams();
                    layoutParams.topMargin = fromDPToPix2;
                    PaylistAAUI.this.gpv.setLayoutParams(layoutParams);
                    AppMethodBeat.o(40877);
                }
            });
            AppMethodBeat.o(40899);
        }
    }

    static /* synthetic */ void h(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(40900);
        if (paylistAAUI.gnn != null) {
            paylistAAUI.gnn.dismiss();
        }
        paylistAAUI.gnn = com.tencent.mm.wallet_core.ui.g.a((Context) paylistAAUI, false, null);
        com.tencent.mm.vending.g.f.dMn().c(paylistAAUI.gpl.gmW).f(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(40868);
                ab.i("MicroMsg.PaylistAAUI", "close pay list success: %s", (Boolean) obj);
                if (PaylistAAUI.this.gnn != null) {
                    PaylistAAUI.this.gnn.dismiss();
                }
                PaylistAAUI.this.gpy = null;
                PaylistAAUI.j(PaylistAAUI.this);
                PaylistAAUI.this.mController.removeAllOptionMenu();
                PaylistAAUI.k(PaylistAAUI.this);
                Void voidR = zXH;
                AppMethodBeat.o(40868);
                return voidR;
            }
        }).a((d.a) new d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(40867);
                ab.i("MicroMsg.PaylistAAUI", "close pay list failed: %s", obj);
                if (PaylistAAUI.this.gnn != null) {
                    PaylistAAUI.this.gnn.dismiss();
                }
                if (obj instanceof String) {
                    Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                    AppMethodBeat.o(40867);
                    return;
                }
                Toast.makeText(PaylistAAUI.this, R.string.ar6, 1).show();
                AppMethodBeat.o(40867);
            }
        });
        h.pYm.e(13721, Integer.valueOf(4), Integer.valueOf(6));
        AppMethodBeat.o(40900);
    }

    static /* synthetic */ void k(PaylistAAUI paylistAAUI) {
        AppMethodBeat.i(40904);
        Intent intent = new Intent();
        intent.putExtra("close_aa", true);
        intent.putExtra("item_position", paylistAAUI.getIntent().getIntExtra("item_position", 0));
        intent.putExtra("item_offset", paylistAAUI.getIntent().getIntExtra("item_offset", 0));
        paylistAAUI.setResult(-1, intent);
        AppMethodBeat.o(40904);
    }
}
