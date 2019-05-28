package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankRemitHistoryUI extends BankRemitBaseUI implements d {
    private boolean gno = false;
    private boolean gnp = false;
    private j icA;
    private List<atf> kPz = new ArrayList();
    private View leb;
    private int limit = 20;
    private int offset = 0;
    private ListView pNq;
    private a pNr;

    class b {
        TextView gnf;
        TextView hrg;
        TextView pNv;
        TextView pNw;
        TextView pNx;
        CdnImageView pNy;

        public b(View view) {
            AppMethodBeat.i(44619);
            this.pNv = (TextView) view.findViewById(R.id.a39);
            this.hrg = (TextView) view.findViewById(R.id.a3b);
            this.pNw = (TextView) view.findViewById(R.id.a3c);
            this.gnf = (TextView) view.findViewById(R.id.a3d);
            this.pNx = (TextView) view.findViewById(R.id.a3e);
            this.pNy = (CdnImageView) view.findViewById(R.id.a3a);
            AppMethodBeat.o(44619);
        }
    }

    class a extends BaseAdapter {
        private SimpleDateFormat pJi;

        private a() {
            AppMethodBeat.i(44614);
            this.pJi = new SimpleDateFormat(BankRemitHistoryUI.this.mController.ylL.getString(R.string.a4j));
            AppMethodBeat.o(44614);
        }

        /* synthetic */ a(BankRemitHistoryUI bankRemitHistoryUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(44615);
            int size = BankRemitHistoryUI.this.kPz.size();
            AppMethodBeat.o(44615);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(44616);
            Object obj = BankRemitHistoryUI.this.kPz.get(i);
            AppMethodBeat.o(44616);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            AppMethodBeat.i(44617);
            if (view == null) {
                view = LayoutInflater.from(BankRemitHistoryUI.this.mController.ylL).inflate(R.layout.fu, viewGroup, false);
                view.setTag(new b(view));
            }
            b bVar = (b) view.getTag();
            atf atf = (atf) getItem(i);
            String fQ = fQ(atf.wxg);
            if (i == 0) {
                z = true;
            } else if (fQ.equals(fQ(((atf) getItem(i - 1)).wxg))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                bVar.pNv.setText(fQ);
                bVar.pNv.setVisibility(0);
            } else {
                bVar.pNv.setVisibility(8);
            }
            bVar.pNy.setUrl(atf.pLH);
            bVar.hrg.setText(atf.title);
            bVar.pNw.setText(atf.wxh);
            bVar.gnf.setText(atf.wxf);
            if (bo.isNullOrNil(atf.wxi)) {
                bVar.pNx.setVisibility(8);
            } else {
                if (!bo.isNullOrNil(atf.wxj)) {
                    bVar.pNx.setTextColor(Color.parseColor(atf.wxj));
                }
                bVar.pNx.setText(atf.wxi);
                bVar.pNx.setVisibility(0);
            }
            AppMethodBeat.o(44617);
            return view;
        }

        private String fQ(long j) {
            AppMethodBeat.i(44618);
            String format = this.pJi.format(new Date(1000 * j));
            AppMethodBeat.o(44618);
            return format;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BankRemitHistoryUI() {
        AppMethodBeat.i(44620);
        AppMethodBeat.o(44620);
    }

    static /* synthetic */ void e(BankRemitHistoryUI bankRemitHistoryUI) {
        AppMethodBeat.i(44628);
        bankRemitHistoryUI.cfk();
        AppMethodBeat.o(44628);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44621);
        super.onCreate(bundle);
        nf(1511);
        nf(1737);
        setMMTitle((int) R.string.a4k);
        initView();
        cfk();
        AppMethodBeat.o(44621);
    }

    public final void initView() {
        AppMethodBeat.i(44622);
        this.pNq = (ListView) findViewById(R.id.a3f);
        this.leb = LayoutInflater.from(this).inflate(R.layout.f, null);
        this.icA = new j(this);
        this.pNr = new a(this, (byte) 0);
        this.pNq.addFooterView(this.leb);
        this.pNq.setAdapter(this.pNr);
        this.pNq.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44606);
                ab.d("MicroMsg.BankRemitHistoryUI", "click item, %s", ((atf) adapterView.getAdapter().getItem(i)).title);
                BankRemitHistoryUI.this.icA.a(view, i, j, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
                AppMethodBeat.o(44606);
                return false;
            }
        });
        this.pNq.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(44607);
                if (BankRemitHistoryUI.this.pNq.getLastVisiblePosition() == BankRemitHistoryUI.this.pNq.getCount() - 1 && BankRemitHistoryUI.this.pNq.getCount() > 0 && !BankRemitHistoryUI.this.gnp && !BankRemitHistoryUI.this.gno) {
                    BankRemitHistoryUI.e(BankRemitHistoryUI.this);
                }
                AppMethodBeat.o(44607);
            }
        });
        AppMethodBeat.o(44622);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(44623);
        contextMenu.add(0, 1, 0, R.string.a50);
        AppMethodBeat.o(44623);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.i(44624);
        atf atf = (atf) this.pNq.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (menuItem.getItemId() == 1 && atf != null) {
            ab.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", atf.vPX);
            m eVar = new e(r0);
            eVar.o(this);
            a(eVar, true, true);
        }
        AppMethodBeat.o(44624);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44625);
        if (mVar instanceof i) {
            final i iVar = (i) mVar;
            iVar.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44610);
                    if (iVar.pLA.wvw != null) {
                        ab.i("MicroMsg.BankRemitHistoryUI", "history size: %s", Integer.valueOf(iVar.pLA.wvw.size()));
                        if (iVar.pLA.wvw.size() < iVar.limit) {
                            ab.i("MicroMsg.BankRemitHistoryUI", "is last: %s", Integer.valueOf(BankRemitHistoryUI.this.offset));
                            BankRemitHistoryUI.this.gnp = true;
                            BankRemitHistoryUI.this.pNq.removeFooterView(BankRemitHistoryUI.this.leb);
                        }
                        if (iVar.pLA.wvw != null) {
                            BankRemitHistoryUI.this.offset = BankRemitHistoryUI.this.offset + iVar.pLA.wvw.size();
                            BankRemitHistoryUI.this.kPz.addAll(iVar.pLA.wvw);
                            BankRemitHistoryUI.this.pNr.notifyDataSetChanged();
                            AppMethodBeat.o(44610);
                            return;
                        }
                    }
                    ab.i("MicroMsg.BankRemitHistoryUI", "return history is null");
                    BankRemitHistoryUI.this.gnp = true;
                    BankRemitHistoryUI.this.pNq.removeFooterView(BankRemitHistoryUI.this.leb);
                    AppMethodBeat.o(44610);
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44609);
                    ab.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", Integer.valueOf(iVar.pLA.kCl), iVar.pLA.kCm);
                    AppMethodBeat.o(44609);
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44608);
                    ab.e("MicroMsg.BankRemitHistoryUI", "net error: %s", mVar);
                    AppMethodBeat.o(44608);
                }
            });
            this.gno = false;
        } else if (mVar instanceof e) {
            final e eVar = (e) mVar;
            eVar.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44613);
                    BankRemitHistoryUI.a(BankRemitHistoryUI.this, eVar.kBD);
                    AppMethodBeat.o(44613);
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44612);
                    ab.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", Integer.valueOf(eVar.pLw.kCl), eVar.pLw.kCm);
                    AppMethodBeat.o(44612);
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44611);
                    ab.e("MicroMsg.BankRemitHistoryUI", "net error: %s", mVar);
                    AppMethodBeat.o(44611);
                }
            });
        }
        AppMethodBeat.o(44625);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.fv;
    }

    public void onDestroy() {
        AppMethodBeat.i(44626);
        super.onDestroy();
        ng(1511);
        ng(1737);
        AppMethodBeat.o(44626);
    }

    private void cfk() {
        AppMethodBeat.i(44627);
        ab.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", Integer.valueOf(this.limit), Integer.valueOf(this.offset));
        this.gno = true;
        m iVar = new i(this.limit, this.offset);
        iVar.o(this);
        a(iVar, false, false);
        AppMethodBeat.o(44627);
    }
}
