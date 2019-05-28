package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p;
import java.util.HashMap;

public class EnterpriseBizContactPlainListUI extends MMActivity {
    private String fuO;
    private ListView gGW;
    private a jMi;
    private long jMj;
    private OnItemClickListener jMk;
    private int scene;

    class a extends p<lk> implements b {
        com.tencent.mm.ui.applet.b gvm = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a() {
            public final Bitmap wd(String str) {
                AppMethodBeat.i(13985);
                Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
                AppMethodBeat.o(13985);
                return a;
            }
        });
        private com.tencent.mm.ui.applet.b.b gvn = null;

        class a {
            TextView gtG;
            ImageView gvq;

            a() {
            }

            public final void clear() {
                AppMethodBeat.i(13989);
                if (this.gvq != null) {
                    this.gvq.setImageDrawable(null);
                    this.gvq.setVisibility(8);
                }
                if (this.gtG != null) {
                    this.gtG.setText("");
                    this.gtG.setVisibility(8);
                }
                AppMethodBeat.o(13989);
            }
        }

        public a(Context context) {
            super(context, new lk());
            AppMethodBeat.i(13990);
            KC();
            AppMethodBeat.o(13990);
        }

        public final void a(String str, m mVar) {
            AppMethodBeat.i(13991);
            ab.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(13986);
                    a.this.KD();
                    TextView textView = (TextView) EnterpriseBizContactPlainListUI.this.findViewById(R.id.bi3);
                    if (!(EnterpriseBizContactPlainListUI.this.gGW == null || textView == null)) {
                        ad aoO = ((j) g.K(j.class)).XM().aoO(EnterpriseBizContactPlainListUI.this.fuO);
                        if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                            EnterpriseBizContactPlainListUI.this.gGW.setVisibility(8);
                            textView.setVisibility(0);
                        } else if (EnterpriseBizContactPlainListUI.this.jMi.getCount() <= 0) {
                            EnterpriseBizContactPlainListUI.this.gGW.setVisibility(8);
                            textView.setVisibility(0);
                        } else {
                            EnterpriseBizContactPlainListUI.this.gGW.setVisibility(0);
                            textView.setVisibility(8);
                            EnterpriseBizContactPlainListUI.this.gGW.setAdapter(EnterpriseBizContactPlainListUI.this.jMi);
                            EnterpriseBizContactPlainListUI.this.gGW.setOnItemClickListener(EnterpriseBizContactPlainListUI.this.jMk);
                        }
                    }
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(13986);
                }
            });
            AppMethodBeat.o(13991);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(13992);
            if (this.gvn == null) {
                this.gvn = new com.tencent.mm.ui.applet.b.b() {
                    public final String mW(int i) {
                        AppMethodBeat.i(13987);
                        if (i < 0 || i >= a.this.getCount()) {
                            ab.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
                            AppMethodBeat.o(13987);
                            return null;
                        }
                        lk lkVar = (lk) a.this.getItem(i);
                        if (lkVar == null) {
                            AppMethodBeat.o(13987);
                            return null;
                        }
                        String str = lkVar.userName;
                        AppMethodBeat.o(13987);
                        return str;
                    }

                    public final int apO() {
                        AppMethodBeat.i(13988);
                        int count = a.this.getCount();
                        AppMethodBeat.o(13988);
                        return count;
                    }
                };
            }
            if (this.gvm != null) {
                this.gvm.a(i, this.gvn);
            }
            if (view == null) {
                aVar = new a();
                view = View.inflate(this.context, R.layout.vc, null);
                aVar.gvq = (ImageView) view.findViewById(R.id.bi0);
                aVar.gtG = (TextView) view.findViewById(R.id.bi1);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            lk lkVar = (lk) getItem(i);
            if (lkVar == null) {
                aVar.clear();
                AppMethodBeat.o(13992);
            } else {
                aVar.clear();
                int paddingBottom = view.getPaddingBottom();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingLeft = view.getPaddingLeft();
                view.setBackgroundDrawable(com.tencent.mm.bz.a.g(this.context, R.drawable.k5));
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                aVar.gtG.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, bo.nullAsNil(lkVar.ehM.Oi()), aVar.gtG.getTextSize()));
                aVar.gtG.setVisibility(0);
                aVar.gvq.setVisibility(0);
                if (bo.isNullOrNil(lkVar.ehM.field_username)) {
                    aVar.gvq.setImageDrawable(null);
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.b(aVar.gvq, lkVar.ehM.field_username);
                }
                AppMethodBeat.o(13992);
            }
            return view;
        }

        public final void KD() {
            AppMethodBeat.i(138967);
            KC();
            AppMethodBeat.o(138967);
        }

        public final void KC() {
            AppMethodBeat.i(13994);
            if (g.RK()) {
                bIf();
                Cursor cursor = null;
                switch (EnterpriseBizContactPlainListUI.this.scene) {
                    case 1:
                        z.aeR();
                        cursor = e.V(EnterpriseBizContactPlainListUI.this.fuO, 25);
                        break;
                    case 2:
                        z.aeR();
                        cursor = e.qR(EnterpriseBizContactPlainListUI.this.fuO);
                        break;
                    case 3:
                        z.aeR();
                        cursor = e.V(EnterpriseBizContactPlainListUI.this.fuO, 128);
                        break;
                    case 4:
                        d qX = f.qX(EnterpriseBizContactPlainListUI.this.fuO);
                        if (!(qX == null || qX.field_enterpriseFather == null)) {
                            cursor = z.aeR().qQ(qX.field_enterpriseFather);
                            break;
                        }
                    default:
                        z.aeR();
                        cursor = e.F(EnterpriseBizContactPlainListUI.this.fuO, true);
                        break;
                }
                setCursor(cursor);
                AppMethodBeat.o(13994);
                return;
            }
            ab.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
            AppMethodBeat.o(13994);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13996);
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("enterprise_scene", 2);
        this.fuO = getIntent().getStringExtra("enterprise_biz_name");
        this.jMj = getIntent().getLongExtra("biz_chat_chat_id", -1);
        ab.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", this.fuO);
        initView();
        z.aeR().c(this.jMi);
        ((j) g.K(j.class)).XM().a(this.jMi);
        AppMethodBeat.o(13996);
    }

    public final void initView() {
        AppMethodBeat.i(13997);
        this.gGW = (ListView) findViewById(R.id.bi2);
        if (this.jMi == null) {
            this.jMi = new a(this);
            this.jMk = new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(13980);
                    ab.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", Integer.valueOf(i));
                    EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this, i);
                    AppMethodBeat.o(13980);
                }
            };
        }
        ab.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", Integer.valueOf(this.jMi.getCount()));
        ad aoO = ((j) g.K(j.class)).XM().aoO(this.fuO);
        if (this.scene == 2) {
            setMMTitle((int) R.string.bdp);
        } else if (aoO != null) {
            setMMTitle(aoO.Oi());
        }
        if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type) || this.jMi.getCount() <= 0) {
            this.gGW.setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.bi3);
            textView.setText(R.string.bdv);
            textView.setVisibility(0);
        } else {
            this.gGW.setVisibility(0);
            this.gGW.setAdapter(this.jMi);
            this.gGW.setOnItemClickListener(this.jMk);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13981);
                EnterpriseBizContactPlainListUI.this.aqX();
                EnterpriseBizContactPlainListUI.this.finish();
                AppMethodBeat.o(13981);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13982);
                c.a(EnterpriseBizContactPlainListUI.this.gGW);
                AppMethodBeat.o(13982);
            }
        };
        AppMethodBeat.o(13997);
    }

    public void onResume() {
        AppMethodBeat.i(13998);
        super.onResume();
        if (t.mY(this.fuO)) {
            AppMethodBeat.o(13998);
            return;
        }
        ab.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", this.fuO);
        finish();
        AppMethodBeat.o(13998);
    }

    public void onPause() {
        AppMethodBeat.i(13999);
        super.onPause();
        AppMethodBeat.o(13999);
    }

    public void onDestroy() {
        AppMethodBeat.i(14000);
        z.aeR().d(this.jMi);
        ((j) g.K(j.class)).XM().b(this.jMi);
        this.jMi.bIf();
        a aVar = this.jMi;
        if (aVar.gvm != null) {
            aVar.gvm.detach();
            aVar.gvm = null;
        }
        super.onDestroy();
        AppMethodBeat.o(14000);
    }

    public final int getLayoutId() {
        return R.layout.ve;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(14001);
        super.onActivityResult(i, i2, intent);
        if (this.scene == 4) {
            finish();
        }
        AppMethodBeat.o(14001);
    }

    static /* synthetic */ void a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, int i) {
        AppMethodBeat.i(14002);
        final lk lkVar = (lk) enterpriseBizContactPlainListUI.jMi.getItem(i);
        if (lkVar == null || lkVar.userName == null) {
            ab.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "item is null.");
            AppMethodBeat.o(14002);
        } else if (enterpriseBizContactPlainListUI.scene == 1) {
            ((i) g.K(i.class)).a(enterpriseBizContactPlainListUI.mController, lkVar.userName, enterpriseBizContactPlainListUI.getString(R.string.dr7), s.mI(lkVar.userName), null, enterpriseBizContactPlainListUI.getString(R.string.tf), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                public final void a(boolean z, String str, int i) {
                    AppMethodBeat.i(13983);
                    if (z) {
                        Intent intent = EnterpriseBizContactPlainListUI.this.getIntent();
                        intent.putExtra("enterprise_biz_name", lkVar.userName);
                        EnterpriseBizContactPlainListUI.this.setResult(-1, intent);
                        EnterpriseBizContactPlainListUI.this.finish();
                    }
                    AppMethodBeat.o(13983);
                }
            });
            AppMethodBeat.o(14002);
        } else if (enterpriseBizContactPlainListUI.scene == 2) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", lkVar.userName);
            com.tencent.mm.plugin.brandservice.b.gkE.c(intent, enterpriseBizContactPlainListUI);
            AppMethodBeat.o(14002);
        } else if (enterpriseBizContactPlainListUI.scene == 3) {
            HashMap hashMap = (HashMap) enterpriseBizContactPlainListUI.getIntent().getSerializableExtra("enterprise_extra_params");
            String str = (String) hashMap.get("img_url");
            String str2 = (String) hashMap.get("desc");
            String str3 = (String) hashMap.get("title");
            final String str4 = lkVar.userName;
            com.tencent.mm.pluginsdk.ui.applet.t.a.vlq.a(enterpriseBizContactPlainListUI.mController, str3, str, str2, false, enterpriseBizContactPlainListUI.getResources().getString(R.string.tf), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                public final void a(boolean z, String str, int i) {
                    AppMethodBeat.i(13984);
                    if (z) {
                        if (EnterpriseBizContactPlainListUI.this.scene == 3) {
                            Intent intent = EnterpriseBizContactPlainListUI.this.getIntent();
                            intent.putExtra("enterprise_biz_name", str4);
                            EnterpriseBizContactPlainListUI.this.setResult(-1, intent);
                            EnterpriseBizContactPlainListUI.this.finish();
                        }
                        AppMethodBeat.o(13984);
                        return;
                    }
                    AppMethodBeat.o(13984);
                }
            });
            AppMethodBeat.o(14002);
        } else {
            if (enterpriseBizContactPlainListUI.scene == 4) {
                d qX = f.qX(lkVar.userName);
                String adW = qX == null ? null : qX.adW();
                if (!bo.isNullOrNil(adW)) {
                    int i2;
                    int i3;
                    com.tencent.mm.aj.b qC = z.afa().qC(qX.adX());
                    if (qC != null) {
                        i2 = qC.field_qyUin;
                    } else {
                        i2 = 0;
                    }
                    if (qC != null) {
                        i3 = qC.field_userUin;
                    } else {
                        i3 = 0;
                    }
                    int qE = z.afa().qE(qX.field_username);
                    h.pYm.e(13419, Integer.valueOf(i2), Integer.valueOf(qE), Integer.valueOf(i3), Integer.valueOf(1));
                    ab.d("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizEnterpriseActive report fatherUin:%d,childUin:%d,userUin:%d,scene:%d", Integer.valueOf(i2), Integer.valueOf(qE), Integer.valueOf(i3), Integer.valueOf(1));
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", adW);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", lkVar.userName);
                    intent2.putExtra("enterprise_biz_name", enterpriseBizContactPlainListUI.fuO);
                    intent2.putExtra("biz_chat_chat_id", enterpriseBizContactPlainListUI.jMj);
                    com.tencent.mm.bp.d.b(enterpriseBizContactPlainListUI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent2, 1);
                }
            }
            AppMethodBeat.o(14002);
        }
    }
}
