package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceRankDataSourceUI extends MMActivity implements f {
    private b lCZ;
    private ListView mListView;

    static final class b extends BaseAdapter {
        List<a> lDe = new LinkedList();
        private c lyr;

        static class a {
            TextView gxi;
            ImageView iqT;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(20123);
            a uV = uV(i);
            AppMethodBeat.o(20123);
            return uV;
        }

        public b() {
            AppMethodBeat.i(20117);
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePT = R.drawable.b2y;
            this.lyr = aVar.ahG();
            AppMethodBeat.o(20117);
        }

        public final synchronized a KG(String str) {
            a aVar;
            AppMethodBeat.i(20118);
            if (!bo.isNullOrNil(str)) {
                for (a aVar2 : this.lDe) {
                    if (str.equals(aVar2.mac)) {
                        AppMethodBeat.o(20118);
                        break;
                    }
                }
            }
            aVar2 = null;
            AppMethodBeat.o(20118);
            return aVar2;
        }

        public final synchronized a dW(String str, String str2) {
            a aVar;
            AppMethodBeat.i(20119);
            for (a aVar2 : this.lDe) {
                if (aVar2 != null && ExdeviceRankDataSourceUI.a(str, str2, aVar2.lDc)) {
                    AppMethodBeat.o(20119);
                    break;
                }
            }
            aVar2 = null;
            AppMethodBeat.o(20119);
            return aVar2;
        }

        public final int getCount() {
            AppMethodBeat.i(20120);
            int size = this.lDe.size();
            AppMethodBeat.o(20120);
            return size;
        }

        private a uV(int i) {
            AppMethodBeat.i(20121);
            a aVar = (a) this.lDe.get(i);
            AppMethodBeat.o(20121);
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(20122);
            a uV = uV(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.layout.wh, null);
                aVar2.gxi = (TextView) view.findViewById(R.id.bi_);
                aVar2.iqT = (ImageView) view.findViewById(R.id.bi9);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ab.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i), ExdeviceRankDataSourceUI.a(uV), uV.mac);
            aVar.gxi.setText(r1);
            o.ahp().a(uV.lDc.IconUrl, aVar.iqT, this.lyr);
            AppMethodBeat.o(20122);
            return view;
        }
    }

    static class a {
        cmk lDc;
        com.tencent.mm.plugin.exdevice.h.b lDd;
        String mac;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.wi;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20124);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20114);
                ExdeviceRankDataSourceUI.a(ExdeviceRankDataSourceUI.this);
                AppMethodBeat.o(20114);
                return true;
            }
        });
        setMMTitle((int) R.string.azd);
        aw.Rg().a(1267, (f) this);
        initView();
        aw.Rg().a(new q(), 0);
        AppMethodBeat.o(20124);
    }

    public final void initView() {
        AppMethodBeat.i(20125);
        this.mListView = (ListView) findViewById(R.id.a46);
        View inflate = View.inflate(this, R.layout.wk, null);
        View inflate2 = View.inflate(this, R.layout.wj, null);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(inflate2, null, false);
        this.lCZ = new b();
        this.mListView.setAdapter(this.lCZ);
        ((ScrollView) findViewById(R.id.b5j)).scrollTo(0, 0);
        inflate2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20115);
                ExdeviceRankDataSourceUI.this.startActivityForResult(new Intent(ExdeviceRankDataSourceUI.this.mController.ylL, ExdeviceAddDataSourceUI.class), 1);
                AppMethodBeat.o(20115);
            }
        });
        AppMethodBeat.o(20125);
    }

    public void onDestroy() {
        AppMethodBeat.i(20127);
        super.onDestroy();
        aw.Rg().b(1267, (f) this);
        AppMethodBeat.o(20127);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(20128);
        ab.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1 && i2 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("device_mac", 0);
            intent.getIntExtra("step", 0);
            if (longExtra == 0) {
                ab.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
                AppMethodBeat.o(20128);
                return;
            }
            String ie = com.tencent.mm.plugin.exdevice.j.b.ie(longExtra);
            if (ie == null) {
                ab.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", ie);
                AppMethodBeat.o(20128);
                return;
            } else if (this.lCZ.KG(ie) != null) {
                ab.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                AppMethodBeat.o(20128);
                return;
            } else {
                com.tencent.mm.plugin.exdevice.h.b id = ad.boW().id(longExtra);
                if (id == null) {
                    ab.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", Long.valueOf(longExtra));
                    AppMethodBeat.o(20128);
                    return;
                } else if (this.lCZ.dW(id.field_deviceID, id.field_deviceType) != null) {
                    ab.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                    AppMethodBeat.o(20128);
                    return;
                } else {
                    aw.Rg().a(1267, (f) this);
                    aw.Rg().a(new q(), 0);
                }
            }
        }
        AppMethodBeat.o(20128);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(20129);
        if (mVar == null) {
            ab.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
            AppMethodBeat.o(20129);
            return;
        }
        if (mVar instanceof q) {
            aw.Rg().b(1267, (f) this);
            if (i == 0 && i2 == 0) {
                aol aol = (aol) ((q) mVar).ehh.fsH.fsP;
                String str2 = "MicroMsg.ExdeviceRankDataSourceUI";
                String str3 = "onSceneEnd, get sport device list succ.(size : %d)";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(aol.wna != null ? aol.wna.size() : 0);
                ab.d(str2, str3, objArr);
                final LinkedList linkedList = aol.wna;
                runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20116);
                        b b = ExdeviceRankDataSourceUI.this.lCZ;
                        List<cmk> list = linkedList;
                        b.lDe.clear();
                        if (!(list == null || list.size() == 0)) {
                            for (cmk cmk : list) {
                                if (cmk != null) {
                                    b.lDe.add(ExdeviceRankDataSourceUI.a(cmk));
                                }
                            }
                        }
                        ExdeviceRankDataSourceUI.this.lCZ.notifyDataSetChanged();
                        AppMethodBeat.o(20116);
                    }
                });
            }
        }
        AppMethodBeat.o(20129);
    }

    public void onBackPressed() {
        AppMethodBeat.i(20126);
        finish();
        AppMethodBeat.o(20126);
    }

    static /* synthetic */ boolean a(String str, String str2, cmk cmk) {
        AppMethodBeat.i(20132);
        if (cmk == null || str == null || str2 == null || !str.equals(cmk.wbq) || !str2.equals(cmk.vIk)) {
            AppMethodBeat.o(20132);
            return false;
        }
        AppMethodBeat.o(20132);
        return true;
    }
}
