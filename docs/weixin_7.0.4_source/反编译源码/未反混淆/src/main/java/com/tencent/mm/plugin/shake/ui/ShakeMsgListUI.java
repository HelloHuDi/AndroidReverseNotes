package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;

public class ShakeMsgListUI extends MMActivity {
    private int from;
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(24757);
            g a = ShakeMsgListUI.this.quO;
            ab.i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(a.bSd.delete(a.getTableName(), "svrid = '" + String.valueOf(ShakeMsgListUI.this.jvz) + "'", null))));
            ShakeMsgListUI.this.quP.a(null, null);
            AppMethodBeat.o(24757);
        }
    };
    private long jvz;
    private TextView kFs;
    private int limit = 0;
    private int mType;
    private int oQK = 0;
    private int oQL = 0;
    private g quO = null;
    private d quP;
    private ListView quQ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeMsgListUI() {
        AppMethodBeat.i(24758);
        AppMethodBeat.o(24758);
    }

    static /* synthetic */ void c(ShakeMsgListUI shakeMsgListUI) {
        AppMethodBeat.i(24765);
        shakeMsgListUI.ckB();
        AppMethodBeat.o(24765);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24759);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("shake_msg_type", 0);
        this.quO = m.cjT();
        this.oQL = this.quO.baS();
        this.limit = this.oQL == 0 ? 8 : this.oQL;
        this.oQK = this.quO.getCount();
        this.from = getIntent().getIntExtra("shake_msg_from", 1);
        if (this.from == 1) {
            h.pYm.e(11313, Integer.valueOf(this.oQL), e.ckT());
        } else {
            h.pYm.e(11315, Integer.valueOf(this.oQL), e.ckT());
        }
        g gVar = this.quO;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(1));
        gVar.bSd.update(gVar.getTableName(), contentValues, "status!=? ", new String[]{"1"});
        initView();
        AppMethodBeat.o(24759);
    }

    public void onResume() {
        AppMethodBeat.i(24760);
        super.onResume();
        if (this.oQK != this.quO.getCount()) {
            this.oQK = this.quO.getCount();
            if (this.oQK == 0) {
                ckB();
            }
            this.quP.KC();
        }
        this.quP.notifyDataSetChanged();
        AppMethodBeat.o(24760);
    }

    public void onDestroy() {
        AppMethodBeat.i(24761);
        this.quP.bIf();
        super.onDestroy();
        AppMethodBeat.o(24761);
    }

    public final int getLayoutId() {
        return R.layout.asd;
    }

    public final void initView() {
        AppMethodBeat.i(24762);
        setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24751);
                ShakeMsgListUI.this.aqX();
                ShakeMsgListUI.this.finish();
                AppMethodBeat.o(24751);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.ou), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24753);
                com.tencent.mm.ui.base.h.a(ShakeMsgListUI.this.mController.ylL, true, ShakeMsgListUI.this.getString(R.string.efc), "", ShakeMsgListUI.this.getString(R.string.dx2), ShakeMsgListUI.this.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(24752);
                        g a = ShakeMsgListUI.this.quO;
                        a.bSd.delete(a.getTableName(), null, null);
                        ShakeMsgListUI.this.quP.KC();
                        ShakeMsgListUI.c(ShakeMsgListUI.this);
                        AppMethodBeat.o(24752);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(24753);
                return true;
            }
        });
        this.kFs = (TextView) findViewById(R.id.a74);
        if (this.oQK == 0) {
            ckB();
        }
        this.quQ = (ListView) findViewById(R.id.ebn);
        final View inflate = getLayoutInflater().inflate(R.layout.ap5, null);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24754);
                ShakeMsgListUI.this.limit = ShakeMsgListUI.this.limit + 8;
                ShakeMsgListUI.this.quP.CA(ShakeMsgListUI.this.limit);
                if (ShakeMsgListUI.this.oQK <= ShakeMsgListUI.this.limit) {
                    ShakeMsgListUI.this.quQ.removeFooterView(inflate);
                }
                AppMethodBeat.o(24754);
            }
        });
        if (this.oQK > 0 && this.limit < this.oQK) {
            this.quQ.addFooterView(inflate);
        }
        this.quP = new d(this);
        this.quP.quL = this.limit;
        this.quQ.setAdapter(this.quP);
        this.quQ.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24755);
                f fVar = (f) ShakeMsgListUI.this.quP.getItem(i);
                if (!bo.isNullOrNil(fVar.field_tag)) {
                    h.pYm.X(11316, ShakeMsgListUI.this.from + "," + fVar.field_tag);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", fVar.field_tag);
                    com.tencent.mm.bp.d.b(ShakeMsgListUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(24755);
            }
        });
        final j jVar = new j(this);
        this.quQ.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24756);
                if (i < ShakeMsgListUI.this.quQ.getHeaderViewsCount()) {
                    ab.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
                    AppMethodBeat.o(24756);
                } else {
                    jVar.a(view, i, j, ShakeMsgListUI.this.mController.ylL, ShakeMsgListUI.this.jKa);
                    AppMethodBeat.o(24756);
                }
                return true;
            }
        });
        AppMethodBeat.o(24762);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(24763);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.jvz = ((f) this.quP.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.p4);
        AppMethodBeat.o(24763);
    }

    private void ckB() {
        AppMethodBeat.i(24764);
        this.kFs.setText(R.string.efd);
        this.kFs.setVisibility(0);
        enableOptionMenu(false);
        AppMethodBeat.o(24764);
    }
}
