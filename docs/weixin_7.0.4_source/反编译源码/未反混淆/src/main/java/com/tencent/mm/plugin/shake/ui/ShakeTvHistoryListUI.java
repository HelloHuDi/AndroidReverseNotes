package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.j;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ShakeTvHistoryListUI extends MMActivity {
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(24897);
            switch (menuItem.getItemId()) {
                case 0:
                    int i2;
                    h.pYm.e(12662, Integer.valueOf(1), bo.nullAsNil(ShakeTvHistoryListUI.this.username));
                    o cjU = m.cjU();
                    String d = ShakeTvHistoryListUI.this.username;
                    if (bo.isNullOrNil(d)) {
                        i2 = -1;
                    } else {
                        i2 = cjU.bSd.delete(cjU.getTableName(), "username = '" + d + "'", null);
                        ab.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = ".concat(String.valueOf(i2)));
                    }
                    if (i2 < 0) {
                        ab.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", Integer.valueOf(i2));
                    } else {
                        aw.Rg().a(new c(1, ShakeTvHistoryListUI.this.username), 0);
                    }
                    ShakeTvHistoryListUI.this.qwv.a(null, null);
                    break;
            }
            AppMethodBeat.o(24897);
        }
    };
    private a qwv;
    private ListView qww;
    private String username;

    class a extends p<n> {
        private LayoutInflater mInflater;

        class a {
            TextView iDT;
            TextView nSC;
            MMImageView qwz;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(24902);
            n nVar = (n) obj;
            if (nVar == null) {
                nVar = new n();
            }
            nVar.d(cursor);
            AppMethodBeat.o(24902);
            return nVar;
        }

        public a(Context context) {
            super(context, new n());
            AppMethodBeat.i(24898);
            this.mInflater = LayoutInflater.from(context);
            AppMethodBeat.o(24898);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            AppMethodBeat.i(24899);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.ash, viewGroup, false);
                aVar = new a();
                aVar.qwz = (MMImageView) view.findViewById(R.id.ecv);
                aVar.iDT = (TextView) view.findViewById(R.id.ecw);
                aVar.nSC = (TextView) view.findViewById(R.id.ecx);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            n nVar = (n) getItem(i);
            e.a(aVar.qwz, nVar.field_iconurl, 0, true);
            aVar.iDT.setText(nVar.field_title);
            TextView textView = aVar.nSC;
            AppCompatActivity appCompatActivity = ShakeTvHistoryListUI.this.mController.ylL;
            long j = nVar.field_createtime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                charSequence = "";
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis <= 0 || timeInMillis > 86400000) {
                        charSequence = com.tencent.mm.pluginsdk.f.h.formatTime(appCompatActivity.getString(R.string.bxe), j / 1000);
                    } else {
                        charSequence = appCompatActivity.getString(R.string.byb);
                    }
                } else {
                    charSequence = com.tencent.mm.pluginsdk.f.h.formatTime(appCompatActivity.getString(R.string.bxq), j / 1000);
                }
            }
            textView.setText(charSequence);
            AppMethodBeat.o(24899);
            return view;
        }

        public final void KC() {
            AppMethodBeat.i(24900);
            setCursor(m.cjU().cky());
            super.notifyDataSetChanged();
            AppMethodBeat.o(24900);
        }

        public final void KD() {
            AppMethodBeat.i(24901);
            KC();
            AppMethodBeat.o(24901);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeTvHistoryListUI() {
        AppMethodBeat.i(24903);
        AppMethodBeat.o(24903);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24904);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(24904);
    }

    public void onDestroy() {
        AppMethodBeat.i(24905);
        this.qwv.bIf();
        super.onDestroy();
        AppMethodBeat.o(24905);
    }

    public final void initView() {
        AppMethodBeat.i(24906);
        setMMTitle((int) R.string.egk);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24892);
                ShakeTvHistoryListUI.this.aqX();
                ShakeTvHistoryListUI.this.finish();
                AppMethodBeat.o(24892);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.ou), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24894);
                com.tencent.mm.ui.base.h.a(ShakeTvHistoryListUI.this.mController.ylL, true, ShakeTvHistoryListUI.this.getString(R.string.egj), "", ShakeTvHistoryListUI.this.getString(R.string.dx2), ShakeTvHistoryListUI.this.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(24893);
                        h hVar = h.pYm;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(2);
                        o cjU = m.cjU();
                        ArrayList<n> arrayList = new ArrayList();
                        Cursor cky = cjU.cky();
                        if (cky != null) {
                            while (cky.moveToNext()) {
                                n nVar = new n();
                                nVar.d(cky);
                                arrayList.add(nVar);
                            }
                            cky.close();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (n nVar2 : arrayList) {
                            stringBuilder.append(nVar2.field_username);
                            stringBuilder.append("|");
                        }
                        objArr[1] = stringBuilder.toString();
                        hVar.e(12662, objArr);
                        m.cjU().bSd.delete("shaketvhistory", null, null);
                        aw.Rg().a(new c(2, null), 0);
                        ShakeTvHistoryListUI.this.qwv.KC();
                        ShakeTvHistoryListUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(24893);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(24894);
                return true;
            }
        });
        this.qww = (ListView) findViewById(R.id.ecy);
        this.qwv = new a(this);
        this.qww.setAdapter(this.qwv);
        this.qww.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24895);
                n nVar = (n) ShakeTvHistoryListUI.this.qwv.getItem(i);
                AppCompatActivity appCompatActivity = ShakeTvHistoryListUI.this.mController.ylL;
                if (nVar != null) {
                    if (bo.isNullOrNil(nVar.field_username) && bo.isNullOrNil(nVar.field_deeplink)) {
                        h.pYm.e(12108, bo.nullAsNil(nVar.field_username), Integer.valueOf(2), Integer.valueOf(0));
                        AppMethodBeat.o(24895);
                        return;
                    }
                    k.a(nVar.field_username, nVar.field_deeplink, 2, appCompatActivity);
                    ab.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
                }
                AppMethodBeat.o(24895);
            }
        });
        final j jVar = new j(this);
        this.qww.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(24896);
                if (i < ShakeTvHistoryListUI.this.qww.getHeaderViewsCount()) {
                    AppMethodBeat.o(24896);
                } else {
                    jVar.a(view, i, j, ShakeTvHistoryListUI.this.mController.ylL, ShakeTvHistoryListUI.this.jKa);
                    AppMethodBeat.o(24896);
                }
                return true;
            }
        });
        AppMethodBeat.o(24906);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(24907);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.username = ((n) this.qwv.getItem(adapterContextMenuInfo.position)).field_username;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.p4);
        AppMethodBeat.o(24907);
    }

    public final int getLayoutId() {
        return R.layout.asi;
    }
}
