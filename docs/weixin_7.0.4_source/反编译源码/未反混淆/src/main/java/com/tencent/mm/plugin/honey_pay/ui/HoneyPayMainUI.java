package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPayMainUI extends HoneyPayBaseUI {
    private ArrayList<HoneyPayCardLayout> nsA = new ArrayList();
    private LinearLayout nsu;
    private ImageView nsv;
    private RelativeLayout nsw;
    private Button nsx;
    private LinearLayout nsy;
    private TextView nsz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public HoneyPayMainUI() {
        AppMethodBeat.i(41894);
        AppMethodBeat.o(41894);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI, String str, String str2) {
        AppMethodBeat.i(41912);
        honeyPayMainUI.b(str, false, str2);
        AppMethodBeat.o(41912);
    }

    public final void initView() {
        AppMethodBeat.i(41896);
        this.nsy = (LinearLayout) findViewById(R.id.cg6);
        this.nsw = (RelativeLayout) findViewById(R.id.cg7);
        this.nsv = (ImageView) findViewById(R.id.cg9);
        this.nsx = (Button) findViewById(R.id.cgc);
        this.nsz = (TextView) findViewById(R.id.cgd);
        this.nsu = (LinearLayout) findViewById(R.id.cge);
        this.nsu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41882);
                ab.d(HoneyPayMainUI.this.TAG, "click add friend");
                HoneyPayMainUI.a(HoneyPayMainUI.this);
                AppMethodBeat.o(41882);
            }
        });
        this.nsx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41888);
                ab.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
                HoneyPayMainUI.a(HoneyPayMainUI.this);
                AppMethodBeat.o(41888);
            }
        });
        AppMethodBeat.o(41896);
    }

    public void onDestroy() {
        AppMethodBeat.i(41897);
        super.onDestroy();
        ng(2725);
        ng(2618);
        ng(2926);
        AppMethodBeat.o(41897);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41898);
        if (mVar instanceof f) {
            final f fVar = (f) mVar;
            fVar.a(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41891);
                    HoneyPayMainUI.b(HoneyPayMainUI.this);
                    HoneyPayMainUI.this.mController.removeAllOptionMenu();
                    if (fVar.nqC.wxk == null || fVar.nqC.wxk.isEmpty()) {
                        ab.i(HoneyPayMainUI.this.TAG, "empty card");
                        HoneyPayMainUI.a(HoneyPayMainUI.this, fVar.nqC.wxl);
                        HoneyPayMainUI.this.nsu.setVisibility(8);
                        HoneyPayMainUI.this.nqT = R.color.a69;
                        HoneyPayMainUI.this.setMMTitle("");
                    } else {
                        HoneyPayMainUI.d(HoneyPayMainUI.this);
                        HoneyPayMainUI.a(HoneyPayMainUI.this, fVar.nqC.wxk);
                        ab.i(HoneyPayMainUI.this.TAG, "show open card: %s", Boolean.valueOf(fVar.nqC.wxn));
                        if (fVar.nqC.wxn) {
                            HoneyPayMainUI.this.nsu.setVisibility(0);
                        } else {
                            HoneyPayMainUI.this.nsu.setVisibility(8);
                        }
                        HoneyPayMainUI.this.nqT = R.color.s2;
                        HoneyPayMainUI.this.setMMTitle((int) R.string.ccl);
                    }
                    HoneyPayMainUI.a(HoneyPayMainUI.this, fVar.nqC.wxo);
                    HoneyPayMainUI.this.bFY();
                    HoneyPayMainUI.this.findViewById(R.id.cg5).setBackgroundResource(HoneyPayMainUI.this.nqT);
                    c.b(HoneyPayMainUI.this, fVar.nqC.wxm, null, 0, null);
                    HoneyPayMainUI.this.findViewById(R.id.cgf).setVisibility(8);
                    h.pYm.k(875, 0, 1);
                    AppMethodBeat.o(41891);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41890);
                    h.pYm.k(875, 1, 1);
                    AppMethodBeat.o(41890);
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41889);
                    h.pYm.k(875, 1, 1);
                    AppMethodBeat.o(41889);
                }
            });
        } else if (mVar instanceof com.tencent.mm.plugin.honey_pay.a.a) {
            final com.tencent.mm.plugin.honey_pay.a.a aVar = (com.tencent.mm.plugin.honey_pay.a.a) mVar;
            aVar.a(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41893);
                    if (aVar.nqx.vYe != null) {
                        ab.i(HoneyPayMainUI.this.TAG, "do realname guide");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
                        c.a(HoneyPayMainUI.this, bundle, aVar.nqx.vYe, true);
                        AppMethodBeat.o(41893);
                        return;
                    }
                    HoneyPayMainUI.b(HoneyPayMainUI.this, aVar.nqx.vYf);
                    AppMethodBeat.o(41893);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41892);
                    if (aVar.nqx.vYe != null) {
                        ab.i(HoneyPayMainUI.this.TAG, "do realname guide");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
                        c.a(HoneyPayMainUI.this, bundle, aVar.nqx.vYe, true);
                    }
                    AppMethodBeat.o(41892);
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
        } else if (mVar instanceof b) {
            final b bVar = (b) mVar;
            bVar.a(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41883);
                    HoneyPayMainUI.a(HoneyPayMainUI.this, bVar.nqy.vYj, bVar.nqy.vYi, bVar.nqy.vYk, bVar.nqy.vYl, bVar.username);
                    AppMethodBeat.o(41883);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
        }
        AppMethodBeat.o(41898);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.a74;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(41899);
        ab.i(this.TAG, "on new intent");
        ab(intent);
        super.onNewIntent(intent);
        AppMethodBeat.o(41899);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41900);
        if (i == 3) {
            id(false);
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(41900);
    }

    private void ab(Intent intent) {
        AppMethodBeat.i(41901);
        boolean booleanExtra = intent.getBooleanExtra("key_create_succ", false);
        String stringExtra = intent.getStringExtra("key_card_no");
        String stringExtra2 = intent.getStringExtra("key_card_type");
        ab.i(this.TAG, "create succ: %s", Boolean.valueOf(booleanExtra));
        if (booleanExtra) {
            b(stringExtra, true, stringExtra2);
        }
        AppMethodBeat.o(41901);
    }

    private void id(boolean z) {
        AppMethodBeat.i(41902);
        ab.i(this.TAG, "get payer list");
        m fVar = new f();
        fVar.o(this);
        a(fVar, z, false);
        AppMethodBeat.o(41902);
    }

    private void b(String str, boolean z, String str2) {
        AppMethodBeat.i(41903);
        ab.i(this.TAG, "go to card manager: %s", str);
        Intent intent = new Intent(this, HoneyPayCardManagerUI.class);
        intent.putExtra("key_card_no", str);
        intent.putExtra("key_scene", 0);
        intent.putExtra("key_is_create", z);
        intent.putExtra("key_card_type", str2);
        startActivityForResult(intent, 3);
        AppMethodBeat.o(41903);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41895);
        this.yll = true;
        super.onCreate(bundle);
        nf(2725);
        nf(2618);
        nf(2926);
        ab(getIntent());
        initView();
        id(true);
        setMMTitle("");
        AppMethodBeat.o(41895);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.i(41904);
        ab.i(honeyPayMainUI.TAG, "do check payer");
        m aVar = new com.tencent.mm.plugin.honey_pay.a.a();
        aVar.o(honeyPayMainUI);
        honeyPayMainUI.a(aVar, true, false);
        AppMethodBeat.o(41904);
    }

    static /* synthetic */ void b(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.i(41905);
        Iterator it = honeyPayMainUI.nsA.iterator();
        while (it.hasNext()) {
            honeyPayMainUI.nsy.removeView((HoneyPayCardLayout) it.next());
        }
        honeyPayMainUI.nsA.clear();
        AppMethodBeat.o(41905);
    }

    static /* synthetic */ void d(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.i(41907);
        honeyPayMainUI.nsw.setVisibility(8);
        AppMethodBeat.o(41907);
    }

    static /* synthetic */ void b(HoneyPayMainUI honeyPayMainUI, List list) {
        AppMethodBeat.i(41910);
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.isEmpty())) {
            for (asj honeyPayCardType : list) {
                arrayList.add(new HoneyPayCardType(honeyPayCardType));
            }
        }
        Intent intent = new Intent(honeyPayMainUI, HoneyPaySelectCardTypeUI.class);
        intent.putParcelableArrayListExtra("key_card_type_list", arrayList);
        honeyPayMainUI.startActivity(intent);
        AppMethodBeat.o(41910);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI, long j, long j2, String str, String str2, String str3) {
        AppMethodBeat.i(41911);
        ab.i(honeyPayMainUI.TAG, "go to give card");
        Intent intent = new Intent(honeyPayMainUI, HoneyPayGiveCardUI.class);
        intent.putExtra("key_max_credit_line", j);
        intent.putExtra("key_min_credit_line", j2);
        intent.putExtra("key_true_name", str);
        intent.putExtra("key_take_message", str2);
        intent.putExtra("key_username", str3);
        honeyPayMainUI.startActivityForResult(intent, 2);
        AppMethodBeat.o(41911);
    }
}
