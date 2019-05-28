package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.chatting.AppAttachFileListUI */
public class AppAttachFileListUI extends MMActivity implements C3457a {
    private OnItemClickListener jMk = new C442812();
    private int jaQ;
    private OnScrollListener kxp = new C442823();
    private ArrayList<C40695c> yGk;
    private HashSet<Long> yGl;
    private ListView yGm;
    private C30415b yGn;
    private boolean yGo = true;
    private boolean yGp = false;
    private View yGq;

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachFileListUI$a */
    class C23655a extends AsyncTask<Integer, Integer, List<C7620bi>> {
        private C23655a() {
        }

        /* synthetic */ C23655a(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(30334);
            Integer[] numArr = (Integer[]) objArr;
            int intValue = numArr[0].intValue();
            int intValue2 = numArr[1].intValue();
            String Yz = C1853r.m3846Yz();
            C9638aw.m17190ZK();
            List aa = C18628c.m29080XO().mo15292aa(Yz, intValue, intValue2);
            AppAttachFileListUI.this.jaQ = intValue2 + AppAttachFileListUI.this.jaQ;
            AppMethodBeat.m2505o(30334);
            return aa;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(30333);
            List list = (List) obj;
            super.onPostExecute(list);
            AppAttachFileListUI.m80015g(AppAttachFileListUI.this);
            AppAttachFileListUI.m80007a(AppAttachFileListUI.this, list);
            AppAttachFileListUI.this.yGn.notifyDataSetChanged();
            AppMethodBeat.m2505o(30333);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachFileListUI$b */
    class C30415b extends BaseAdapter {
        private C30415b() {
        }

        /* synthetic */ C30415b(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(30335);
            int size = AppAttachFileListUI.this.yGk.size();
            AppMethodBeat.m2505o(30335);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(30336);
            Object obj = AppAttachFileListUI.this.yGk.get(i);
            AppMethodBeat.m2505o(30336);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object c44283d;
            String str;
            AppMethodBeat.m2504i(30337);
            if (view == null) {
                view = AppAttachFileListUI.this.getLayoutInflater().inflate(2130968651, viewGroup, false);
                Assert.assertNotNull(view);
                c44283d = new C44283d(AppAttachFileListUI.this, (byte) 0);
                c44283d.yGt = (MMImageView) view.findViewById(2131821104);
                c44283d.yGu = (TextView) view.findViewById(2131821105);
                c44283d.yGv = (TextView) view.findViewById(2131821107);
                c44283d.yGw = (TextView) view.findViewById(2131821106);
                view.setTag(c44283d);
            } else {
                C44283d c44283d2 = (C44283d) view.getTag();
            }
            Assert.assertNotNull(c44283d2);
            C40695c c40695c = (C40695c) AppAttachFileListUI.this.yGk.get(i);
            c44283d2.yGu.setText(c40695c.yGs.title);
            if (c40695c.cKd.field_isSend == 1) {
                str = "自己";
            } else {
                str = C1854s.m3866mJ(c40695c.yGs.cEV);
            }
            c44283d2.yGv.setText(String.format("大小：%s，来自：%s", new Object[]{C5046bo.m7565ga((long) c40695c.yGs.fgo), str}));
            c44283d2.yGw.setText(C14835h.m23089c(AppAttachFileListUI.this, c40695c.cKd.field_createTime, true));
            c44283d2.yGt.setImageResource(C44065o.aiD(c40695c.yGs.fgp));
            AppMethodBeat.m2505o(30337);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachFileListUI$c */
    class C40695c {
        public C7620bi cKd;
        public C8910b yGs;

        private C40695c() {
        }

        /* synthetic */ C40695c(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachFileListUI$1 */
    class C442801 implements OnMenuItemClickListener {
        C442801() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30330);
            AppAttachFileListUI.this.finish();
            AppMethodBeat.m2505o(30330);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachFileListUI$2 */
    class C442812 implements OnItemClickListener {
        C442812() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(30331);
            Intent intent = new Intent();
            intent.setClassName(AppAttachFileListUI.this, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", ((C40695c) AppAttachFileListUI.this.yGk.get(i)).cKd.field_msgId);
            intent.setFlags(67108864);
            AppAttachFileListUI.this.startActivity(intent);
            AppMethodBeat.m2505o(30331);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachFileListUI$3 */
    class C442823 implements OnScrollListener {
        C442823() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(30332);
            if (i == 0 && !AppAttachFileListUI.this.yGp && AppAttachFileListUI.this.yGo && absListView.getLastVisiblePosition() == AppAttachFileListUI.this.yGn.getCount()) {
                C4990ab.m7410d("MicroMsg.AppAttachFileListUI", "need to add item");
                int e = AppAttachFileListUI.this.jaQ;
                new C23655a(AppAttachFileListUI.this, (byte) 0).execute(new Integer[]{Integer.valueOf(e), Integer.valueOf(20)});
                AppAttachFileListUI.m80014f(AppAttachFileListUI.this);
            }
            AppMethodBeat.m2505o(30332);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AppAttachFileListUI$d */
    class C44283d {
        public MMImageView yGt;
        public TextView yGu;
        public TextView yGv;
        public TextView yGw;

        private C44283d() {
        }

        /* synthetic */ C44283d(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AppAttachFileListUI() {
        AppMethodBeat.m2504i(30338);
        AppMethodBeat.m2505o(30338);
    }

    public final int getLayoutId() {
        return 2130968652;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30339);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bt1);
        setBackBtn(new C442801());
        this.yGm = (ListView) findViewById(2131821108);
        this.yGq = getLayoutInflater().inflate(2130968650, null);
        this.yGm.addFooterView(this.yGq);
        this.yGq.setVisibility(8);
        this.yGk = new ArrayList();
        this.yGl = new HashSet();
        String Yz = C1853r.m3846Yz();
        C9638aw.m17190ZK();
        List aa = C18628c.m29080XO().mo15292aa(Yz, 0, 20);
        this.jaQ += 20;
        m80013eO(aa);
        this.yGn = new C30415b(this, (byte) 0);
        this.yGm.setAdapter(this.yGn);
        this.yGm.setOnItemClickListener(this.jMk);
        this.yGm.setOnScrollListener(this.kxp);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15287a((C3457a) this, getMainLooper());
        AppMethodBeat.m2505o(30339);
    }

    public void onResume() {
        AppMethodBeat.m2504i(30340);
        super.onResume();
        AppMethodBeat.m2505o(30340);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30341);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15286a((C3457a) this);
        super.onDestroy();
        AppMethodBeat.m2505o(30341);
    }

    /* renamed from: eO */
    private void m80013eO(List<C7620bi> list) {
        AppMethodBeat.m2504i(30342);
        if (list.size() < 20) {
            this.yGo = false;
            this.yGm.removeFooterView(this.yGq);
        }
        for (C7620bi c7620bi : list) {
            C40695c at = m80008at(c7620bi);
            if (at != null && at.yGs.type == 6 && this.yGl.add(Long.valueOf(c7620bi.field_msgId))) {
                this.yGk.add(at);
            }
        }
        C4990ab.m7411d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", Integer.valueOf(list.size()), Integer.valueOf(this.yGk.size()));
        AppMethodBeat.m2505o(30342);
    }

    /* renamed from: a */
    public final void mo7913a(C6977h c6977h, C3460c c3460c) {
        AppMethodBeat.m2504i(30344);
        if ("insert".equals(c3460c.oqJ)) {
            C4990ab.m7410d("MicroMsg.AppAttachFileListUI", "reveive a msg");
            for (int size = c3460c.oqK.size() - 1; size >= 0; size--) {
                C7620bi c7620bi = (C7620bi) c3460c.oqK.get(size);
                if (c7620bi.bAA()) {
                    C40695c at = m80008at(c7620bi);
                    if (at != null && at.yGs.type == 6) {
                        this.yGk.add(0, at);
                    }
                }
            }
            if (this.yGn != null) {
                this.yGn.notifyDataSetChanged();
            }
        }
        AppMethodBeat.m2505o(30344);
    }

    /* renamed from: at */
    private C40695c m80008at(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30343);
        C8910b me = C8910b.m16064me(c7620bi.field_content);
        if (me == null) {
            AppMethodBeat.m2505o(30343);
            return null;
        }
        C40695c c40695c = new C40695c(this, (byte) 0);
        c40695c.cKd = c7620bi;
        c40695c.yGs = me;
        AppMethodBeat.m2505o(30343);
        return c40695c;
    }

    /* renamed from: f */
    static /* synthetic */ void m80014f(AppAttachFileListUI appAttachFileListUI) {
        AppMethodBeat.m2504i(30345);
        C4990ab.m7410d("MicroMsg.AppAttachFileListUI", "start to load");
        appAttachFileListUI.yGp = true;
        appAttachFileListUI.yGq.setVisibility(0);
        AppMethodBeat.m2505o(30345);
    }

    /* renamed from: g */
    static /* synthetic */ void m80015g(AppAttachFileListUI appAttachFileListUI) {
        AppMethodBeat.m2504i(30346);
        appAttachFileListUI.yGp = false;
        appAttachFileListUI.yGq.setVisibility(8);
        C4990ab.m7410d("MicroMsg.AppAttachFileListUI", "stop to load");
        AppMethodBeat.m2505o(30346);
    }
}
