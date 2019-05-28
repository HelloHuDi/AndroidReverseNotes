package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class AppAttachFileListUI extends MMActivity implements com.tencent.mm.plugin.messenger.foundation.a.a.h.a {
    private OnItemClickListener jMk = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(30331);
            Intent intent = new Intent();
            intent.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", ((c) AppAttachFileListUI.this.yGk.get(i)).cKd.field_msgId);
            intent.setFlags(67108864);
            AppAttachFileListUI.this.startActivity(intent);
            AppMethodBeat.o(30331);
        }
    };
    private int jaQ;
    private OnScrollListener kxp = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(30332);
            if (i == 0 && !AppAttachFileListUI.this.yGp && AppAttachFileListUI.this.yGo && absListView.getLastVisiblePosition() == AppAttachFileListUI.this.yGn.getCount()) {
                ab.d("MicroMsg.AppAttachFileListUI", "need to add item");
                int e = AppAttachFileListUI.this.jaQ;
                new a(AppAttachFileListUI.this, (byte) 0).execute(new Integer[]{Integer.valueOf(e), Integer.valueOf(20)});
                AppAttachFileListUI.f(AppAttachFileListUI.this);
            }
            AppMethodBeat.o(30332);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ArrayList<c> yGk;
    private HashSet<Long> yGl;
    private ListView yGm;
    private b yGn;
    private boolean yGo = true;
    private boolean yGp = false;
    private View yGq;

    class a extends AsyncTask<Integer, Integer, List<bi>> {
        private a() {
        }

        /* synthetic */ a(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(30334);
            Integer[] numArr = (Integer[]) objArr;
            int intValue = numArr[0].intValue();
            int intValue2 = numArr[1].intValue();
            String Yz = r.Yz();
            aw.ZK();
            List aa = com.tencent.mm.model.c.XO().aa(Yz, intValue, intValue2);
            AppAttachFileListUI.this.jaQ = intValue2 + AppAttachFileListUI.this.jaQ;
            AppMethodBeat.o(30334);
            return aa;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(30333);
            List list = (List) obj;
            super.onPostExecute(list);
            AppAttachFileListUI.g(AppAttachFileListUI.this);
            AppAttachFileListUI.a(AppAttachFileListUI.this, list);
            AppAttachFileListUI.this.yGn.notifyDataSetChanged();
            AppMethodBeat.o(30333);
        }
    }

    class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(30335);
            int size = AppAttachFileListUI.this.yGk.size();
            AppMethodBeat.o(30335);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(30336);
            Object obj = AppAttachFileListUI.this.yGk.get(i);
            AppMethodBeat.o(30336);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object dVar;
            String str;
            AppMethodBeat.i(30337);
            if (view == null) {
                view = AppAttachFileListUI.this.getLayoutInflater().inflate(R.layout.bb, viewGroup, false);
                Assert.assertNotNull(view);
                dVar = new d(AppAttachFileListUI.this, (byte) 0);
                dVar.yGt = (MMImageView) view.findViewById(R.id.of);
                dVar.yGu = (TextView) view.findViewById(R.id.og);
                dVar.yGv = (TextView) view.findViewById(R.id.oi);
                dVar.yGw = (TextView) view.findViewById(R.id.oh);
                view.setTag(dVar);
            } else {
                d dVar2 = (d) view.getTag();
            }
            Assert.assertNotNull(dVar2);
            c cVar = (c) AppAttachFileListUI.this.yGk.get(i);
            dVar2.yGu.setText(cVar.yGs.title);
            if (cVar.cKd.field_isSend == 1) {
                str = "自己";
            } else {
                str = s.mJ(cVar.yGs.cEV);
            }
            dVar2.yGv.setText(String.format("大小：%s，来自：%s", new Object[]{bo.ga((long) cVar.yGs.fgo), str}));
            dVar2.yGw.setText(h.c(AppAttachFileListUI.this, cVar.cKd.field_createTime, true));
            dVar2.yGt.setImageResource(o.aiD(cVar.yGs.fgp));
            AppMethodBeat.o(30337);
            return view;
        }
    }

    class c {
        public bi cKd;
        public com.tencent.mm.af.j.b yGs;

        private c() {
        }

        /* synthetic */ c(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }
    }

    class d {
        public MMImageView yGt;
        public TextView yGu;
        public TextView yGv;
        public TextView yGw;

        private d() {
        }

        /* synthetic */ d(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppAttachFileListUI() {
        AppMethodBeat.i(30338);
        AppMethodBeat.o(30338);
    }

    public final int getLayoutId() {
        return R.layout.bc;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30339);
        super.onCreate(bundle);
        setMMTitle((int) R.string.bt1);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30330);
                AppAttachFileListUI.this.finish();
                AppMethodBeat.o(30330);
                return true;
            }
        });
        this.yGm = (ListView) findViewById(R.id.oj);
        this.yGq = getLayoutInflater().inflate(R.layout.ba, null);
        this.yGm.addFooterView(this.yGq);
        this.yGq.setVisibility(8);
        this.yGk = new ArrayList();
        this.yGl = new HashSet();
        String Yz = r.Yz();
        aw.ZK();
        List aa = com.tencent.mm.model.c.XO().aa(Yz, 0, 20);
        this.jaQ += 20;
        eO(aa);
        this.yGn = new b(this, (byte) 0);
        this.yGm.setAdapter(this.yGn);
        this.yGm.setOnItemClickListener(this.jMk);
        this.yGm.setOnScrollListener(this.kxp);
        aw.ZK();
        com.tencent.mm.model.c.XO().a((com.tencent.mm.plugin.messenger.foundation.a.a.h.a) this, getMainLooper());
        AppMethodBeat.o(30339);
    }

    public void onResume() {
        AppMethodBeat.i(30340);
        super.onResume();
        AppMethodBeat.o(30340);
    }

    public void onDestroy() {
        AppMethodBeat.i(30341);
        aw.ZK();
        com.tencent.mm.model.c.XO().a((com.tencent.mm.plugin.messenger.foundation.a.a.h.a) this);
        super.onDestroy();
        AppMethodBeat.o(30341);
    }

    private void eO(List<bi> list) {
        AppMethodBeat.i(30342);
        if (list.size() < 20) {
            this.yGo = false;
            this.yGm.removeFooterView(this.yGq);
        }
        for (bi biVar : list) {
            c at = at(biVar);
            if (at != null && at.yGs.type == 6 && this.yGl.add(Long.valueOf(biVar.field_msgId))) {
                this.yGk.add(at);
            }
        }
        ab.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", Integer.valueOf(list.size()), Integer.valueOf(this.yGk.size()));
        AppMethodBeat.o(30342);
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h hVar, com.tencent.mm.plugin.messenger.foundation.a.a.h.c cVar) {
        AppMethodBeat.i(30344);
        if ("insert".equals(cVar.oqJ)) {
            ab.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
            for (int size = cVar.oqK.size() - 1; size >= 0; size--) {
                bi biVar = (bi) cVar.oqK.get(size);
                if (biVar.bAA()) {
                    c at = at(biVar);
                    if (at != null && at.yGs.type == 6) {
                        this.yGk.add(0, at);
                    }
                }
            }
            if (this.yGn != null) {
                this.yGn.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(30344);
    }

    private c at(bi biVar) {
        AppMethodBeat.i(30343);
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(biVar.field_content);
        if (me == null) {
            AppMethodBeat.o(30343);
            return null;
        }
        c cVar = new c(this, (byte) 0);
        cVar.cKd = biVar;
        cVar.yGs = me;
        AppMethodBeat.o(30343);
        return cVar;
    }

    static /* synthetic */ void f(AppAttachFileListUI appAttachFileListUI) {
        AppMethodBeat.i(30345);
        ab.d("MicroMsg.AppAttachFileListUI", "start to load");
        appAttachFileListUI.yGp = true;
        appAttachFileListUI.yGq.setVisibility(0);
        AppMethodBeat.o(30345);
    }

    static /* synthetic */ void g(AppAttachFileListUI appAttachFileListUI) {
        AppMethodBeat.i(30346);
        appAttachFileListUI.yGp = false;
        appAttachFileListUI.yGq.setVisibility(8);
        ab.d("MicroMsg.AppAttachFileListUI", "stop to load");
        AppMethodBeat.o(30346);
    }
}
