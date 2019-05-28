package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.aa.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.g;
import java.util.List;

public class AAQueryListUI extends BaseAAPresenterActivity {
    private b gnk = ((b) V(b.class));
    private ListView gnl;
    private b gnm;
    private Dialog gnn;
    private boolean gno = false;
    private boolean gnp = false;
    private View gnq;
    private AAQueryListH5UrlFooterView gnr;
    private String gns;
    private int mode = 1;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AAQueryListUI() {
        AppMethodBeat.i(40737);
        AppMethodBeat.o(40737);
    }

    static /* synthetic */ void a(AAQueryListUI aAQueryListUI, boolean z, int i) {
        AppMethodBeat.i(40741);
        aAQueryListUI.h(z, i);
        AppMethodBeat.o(40741);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40738);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40728);
                AAQueryListUI.this.finish();
                AppMethodBeat.o(40728);
                return false;
            }
        });
        setMMTitle((int) R.string.bo);
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40733);
                d dVar = new d(AAQueryListUI.this, 1, false);
                dVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(40731);
                        lVar.add(0, 1, 1, (int) R.string.bp);
                        lVar.add(1, 2, 1, (int) R.string.bq);
                        AppMethodBeat.o(40731);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(40732);
                        switch (menuItem.getItemId()) {
                            case 1:
                                ab.i("MicroMsg.AAQueryListUI", "go to launch list: %d", Integer.valueOf(AAQueryListUI.this.mode));
                                if (AAQueryListUI.this.mode == 1) {
                                    AppMethodBeat.o(40732);
                                    return;
                                }
                                AAQueryListUI.this.mode = 1;
                                AAQueryListUI.this.setMMTitle((int) R.string.bo);
                                AAQueryListUI.this.gnm.mode = AAQueryListUI.this.mode;
                                AAQueryListUI.this.gnm.aot();
                                AAQueryListUI.this.gnm.notifyDataSetChanged();
                                AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.this.mode);
                                AppMethodBeat.o(40732);
                                return;
                            case 2:
                                ab.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", Integer.valueOf(AAQueryListUI.this.mode));
                                if (AAQueryListUI.this.mode != 2) {
                                    AAQueryListUI.this.setMMTitle((int) R.string.br);
                                    AAQueryListUI.this.gnm.mode = AAQueryListUI.this.mode;
                                    AAQueryListUI.this.gnm.aot();
                                    AAQueryListUI.this.gnm.notifyDataSetChanged();
                                    AAQueryListUI.this.mode = 2;
                                    AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.this.mode);
                                    break;
                                }
                                AppMethodBeat.o(40732);
                                return;
                        }
                        AppMethodBeat.o(40732);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(40733);
                return true;
            }
        });
        this.gnl = (ListView) findViewById(R.id.ir);
        this.gnl.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(40729);
                if (AAQueryListUI.this.gnl.getLastVisiblePosition() == AAQueryListUI.this.gnl.getCount() - 1 && AAQueryListUI.this.gnl.getCount() > 0 && !AAQueryListUI.this.gnp && !AAQueryListUI.this.gno) {
                    AAQueryListUI.this.gnl.addFooterView(AAQueryListUI.this.gnq);
                    AAQueryListUI.a(AAQueryListUI.this, false, AAQueryListUI.this.mode);
                }
                AppMethodBeat.o(40729);
            }
        });
        this.gnl.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(40730);
                if (AAQueryListUI.this.gnm != null) {
                    if (i < 0 || i >= AAQueryListUI.this.gnm.getCount()) {
                        ab.i("MicroMsg.AAQueryListUI", "click out of bound! %s", Integer.valueOf(i));
                        AppMethodBeat.o(40730);
                        return;
                    }
                    int top = view.getTop();
                    k kVar = (k) AAQueryListUI.this.gnm.getItem(i);
                    if (kVar != null) {
                        if (!bo.isNullOrNil(kVar.vzX)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", kVar.vzX);
                            com.tencent.mm.bp.d.b(AAQueryListUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (!bo.isNullOrNil(kVar.vzL)) {
                            String str = null;
                            if (kVar.vzW == 2) {
                                str = r.Yz();
                            }
                            Intent intent2 = new Intent(AAQueryListUI.this, PaylistAAUI.class);
                            intent2.putExtra("bill_no", kVar.vzL);
                            intent2.putExtra("launcher_user_name", str);
                            intent2.putExtra("enter_scene", 4);
                            intent2.putExtra("chatroom", kVar.vzM);
                            intent2.putExtra("item_position", i);
                            intent2.putExtra("item_offset", top);
                            AAQueryListUI.this.startActivityForResult(intent2, 1);
                        }
                    }
                }
                h.pYm.e(13721, Integer.valueOf(5), Integer.valueOf(3));
                AppMethodBeat.o(40730);
            }
        });
        this.gnq = new AAQueryListLoadingMoreView(this);
        this.gnr = new AAQueryListH5UrlFooterView(this);
        this.gnn = g.a((Context) this, false, null);
        this.gnm = new b(this, this.mode);
        this.gnl.setAdapter(this.gnm);
        this.gnl.setVisibility(4);
        h(false, this.mode);
        AppMethodBeat.o(40738);
    }

    private void h(final boolean z, int i) {
        AppMethodBeat.i(40739);
        if (this.gno) {
            ab.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
            AppMethodBeat.o(40739);
            return;
        }
        if (z) {
            this.gnp = false;
            this.gnl.removeFooterView(this.gnr);
        }
        this.gno = true;
        this.gnk.gmD.g(z, i).f(new a<Object, com.tencent.mm.vending.j.d<List, String, Boolean>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(40735);
                com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
                List list = (List) dVar.get(0);
                ab.i("MicroMsg.AAQueryListUI", "record list size: %s, h5Url: %s, lastFlag: %s", Integer.valueOf(list.size()), dVar.get(1), dVar.get(2));
                if (!bo.isNullOrNil((String) dVar.get(1))) {
                    AAQueryListUI.this.gns = (String) dVar.get(1);
                }
                if (z) {
                    AAQueryListUI.this.gnm.aot();
                }
                b f = AAQueryListUI.this.gnm;
                ab.i("MicroMsg.AAQueryListAdapter", "addNewRecord: %s", list);
                if (list != null && list.size() > 0) {
                    ab.i("MicroMsg.AAQueryListAdapter", "addNewRecord size: %s", Integer.valueOf(list.size()));
                    f.dataList.addAll(list);
                    f.notifyDataSetChanged();
                }
                if (AAQueryListUI.this.gnn != null) {
                    AAQueryListUI.this.gnn.dismiss();
                    AAQueryListUI.this.gnn = null;
                }
                if (AAQueryListUI.this.gnl.getVisibility() != 0) {
                    AAQueryListUI.this.gnl.setVisibility(0);
                }
                AAQueryListUI.this.gno = false;
                if (!((Boolean) dVar.get(2)).booleanValue()) {
                    AAQueryListUI.this.gnp = true;
                }
                if (AAQueryListUI.this.gnl.getFooterViewsCount() > 0) {
                    AAQueryListUI.this.gnl.removeFooterView(AAQueryListUI.this.gnq);
                }
                if (AAQueryListUI.this.gnp) {
                    AAQueryListUI.k(AAQueryListUI.this);
                    if (AAQueryListUI.this.gnr.getVisibility() == 0) {
                        AAQueryListUI.this.gnl.addFooterView(AAQueryListUI.this.gnr, null, false);
                    }
                }
                Void voidR = zXH;
                AppMethodBeat.o(40735);
                return voidR;
            }
        }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(40734);
                ab.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", obj);
                if (AAQueryListUI.this.gnn != null) {
                    AAQueryListUI.this.gnn.dismiss();
                    AAQueryListUI.this.gnn = null;
                }
                AAQueryListUI.this.gno = false;
                if (AAQueryListUI.this.gnl.getFooterViewsCount() > 0) {
                    AAQueryListUI.this.gnl.removeFooterView(AAQueryListUI.this.gnq);
                }
                if (obj instanceof String) {
                    Toast.makeText(AAQueryListUI.this, obj.toString(), 1).show();
                    AppMethodBeat.o(40734);
                    return;
                }
                Toast.makeText(AAQueryListUI.this, R.string.c9m, 1).show();
                AppMethodBeat.o(40734);
            }
        });
        AppMethodBeat.o(40739);
    }

    public final int getLayoutId() {
        return R.layout.d;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(40740);
        if (i == 1 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("close_aa", false);
            int intExtra = intent.getIntExtra("item_position", 0);
            int intExtra2 = intent.getIntExtra("item_offset", 0);
            if (booleanExtra) {
                this.gnl.setSelectionFromTop(intExtra, intExtra2);
                h(true, this.mode);
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(40740);
    }

    static /* synthetic */ void k(AAQueryListUI aAQueryListUI) {
        AppMethodBeat.i(40742);
        if (bo.isNullOrNil(aAQueryListUI.gns)) {
            ab.i("MicroMsg.AAQueryListUI", "empty h5 url!");
            aAQueryListUI.gnr.setVisibility(8);
            AppMethodBeat.o(40742);
            return;
        }
        TextView bottomLinkTv = aAQueryListUI.gnr.getBottomLinkTv();
        bottomLinkTv.setClickable(true);
        bottomLinkTv.setOnTouchListener(new m(aAQueryListUI));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aAQueryListUI.getString(R.string.b5));
        spannableStringBuilder.setSpan(new a(new a.a() {
            public final void aos() {
                AppMethodBeat.i(40736);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", AAQueryListUI.this.gns);
                com.tencent.mm.bp.d.b(AAQueryListUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(40736);
            }
        }), 0, spannableStringBuilder.length(), 18);
        bottomLinkTv.setText(spannableStringBuilder);
        AppMethodBeat.o(40742);
    }
}
