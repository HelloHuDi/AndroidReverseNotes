package com.tencent.p177mm.plugin.exdevice.p393ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.exdevice.model.C42995q;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.protocal.protobuf.aol;
import com.tencent.p177mm.protocal.protobuf.cmk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI */
public class ExdeviceRankDataSourceUI extends MMActivity implements C1202f {
    private C27886b lCZ;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI$1 */
    class C30001 implements OnMenuItemClickListener {
        C30001() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20114);
            ExdeviceRankDataSourceUI.m55822a(ExdeviceRankDataSourceUI.this);
            AppMethodBeat.m2505o(20114);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI$b */
    static final class C27886b extends BaseAdapter {
        List<C34064a> lDe = new LinkedList();
        private C25814c lyr;

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI$b$a */
        static class C27885a {
            TextView gxi;
            ImageView iqT;

            private C27885a() {
            }

            /* synthetic */ C27885a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(20123);
            C34064a uV = m44329uV(i);
            AppMethodBeat.m2505o(20123);
            return uV;
        }

        public C27886b() {
            AppMethodBeat.m2504i(20117);
            C17927a c17927a = new C17927a();
            c17927a.ePT = C25738R.drawable.b2y;
            this.lyr = c17927a.ahG();
            AppMethodBeat.m2505o(20117);
        }

        /* renamed from: KG */
        public final synchronized C34064a mo45784KG(String str) {
            C34064a c34064a;
            AppMethodBeat.m2504i(20118);
            if (!C5046bo.isNullOrNil(str)) {
                for (C34064a c34064a2 : this.lDe) {
                    if (str.equals(c34064a2.mac)) {
                        AppMethodBeat.m2505o(20118);
                        break;
                    }
                }
            }
            c34064a2 = null;
            AppMethodBeat.m2505o(20118);
            return c34064a2;
        }

        /* renamed from: dW */
        public final synchronized C34064a mo45785dW(String str, String str2) {
            C34064a c34064a;
            AppMethodBeat.m2504i(20119);
            for (C34064a c34064a2 : this.lDe) {
                if (c34064a2 != null && ExdeviceRankDataSourceUI.m55823a(str, str2, c34064a2.lDc)) {
                    AppMethodBeat.m2505o(20119);
                    break;
                }
            }
            c34064a2 = null;
            AppMethodBeat.m2505o(20119);
            return c34064a2;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(20120);
            int size = this.lDe.size();
            AppMethodBeat.m2505o(20120);
            return size;
        }

        /* renamed from: uV */
        private C34064a m44329uV(int i) {
            AppMethodBeat.m2504i(20121);
            C34064a c34064a = (C34064a) this.lDe.get(i);
            AppMethodBeat.m2505o(20121);
            return c34064a;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C27885a c27885a;
            AppMethodBeat.m2504i(20122);
            C34064a uV = m44329uV(i);
            if (view == null) {
                C27885a c27885a2 = new C27885a();
                view = View.inflate(viewGroup.getContext(), 2130969436, null);
                c27885a2.gxi = (TextView) view.findViewById(2131823625);
                c27885a2.iqT = (ImageView) view.findViewById(2131823624);
                view.setTag(c27885a2);
                c27885a = c27885a2;
            } else {
                c27885a = (C27885a) view.getTag();
            }
            C4990ab.m7411d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i), ExdeviceRankDataSourceUI.m55821a(uV), uV.mac);
            c27885a.gxi.setText(r1);
            C32291o.ahp().mo43766a(uV.lDc.IconUrl, c27885a.iqT, this.lyr);
            AppMethodBeat.m2505o(20122);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI$2 */
    class C340632 implements OnClickListener {
        C340632() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20115);
            ExdeviceRankDataSourceUI.this.startActivityForResult(new Intent(ExdeviceRankDataSourceUI.this.mController.ylL, ExdeviceAddDataSourceUI.class), 1);
            AppMethodBeat.m2505o(20115);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI$a */
    static class C34064a {
        cmk lDc;
        C11648b lDd;
        String mac;

        private C34064a() {
        }

        /* synthetic */ C34064a(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969437;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20124);
        super.onCreate(bundle);
        setBackBtn(new C30001());
        setMMTitle((int) C25738R.string.azd);
        C9638aw.m17182Rg().mo14539a(1267, (C1202f) this);
        initView();
        C9638aw.m17182Rg().mo14541a(new C42995q(), 0);
        AppMethodBeat.m2505o(20124);
    }

    public final void initView() {
        AppMethodBeat.m2504i(20125);
        this.mListView = (ListView) findViewById(2131821698);
        View inflate = View.inflate(this, 2130969439, null);
        View inflate2 = View.inflate(this, 2130969438, null);
        this.mListView.addHeaderView(inflate, null, false);
        this.mListView.addFooterView(inflate2, null, false);
        this.lCZ = new C27886b();
        this.mListView.setAdapter(this.lCZ);
        ((ScrollView) findViewById(2131823117)).scrollTo(0, 0);
        inflate2.setOnClickListener(new C340632());
        AppMethodBeat.m2505o(20125);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(20127);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(1267, (C1202f) this);
        AppMethodBeat.m2505o(20127);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(20128);
        C4990ab.m7411d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1 && i2 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("device_mac", 0);
            intent.getIntExtra("step", 0);
            if (longExtra == 0) {
                C4990ab.m7412e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
                AppMethodBeat.m2505o(20128);
                return;
            }
            String ie = C42992b.m76358ie(longExtra);
            if (ie == null) {
                C4990ab.m7413e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", ie);
                AppMethodBeat.m2505o(20128);
                return;
            } else if (this.lCZ.mo45784KG(ie) != null) {
                C4990ab.m7416i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                AppMethodBeat.m2505o(20128);
                return;
            } else {
                C11648b id = C45891ad.boW().mo45710id(longExtra);
                if (id == null) {
                    C4990ab.m7421w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", Long.valueOf(longExtra));
                    AppMethodBeat.m2505o(20128);
                    return;
                } else if (this.lCZ.mo45785dW(id.field_deviceID, id.field_deviceType) != null) {
                    C4990ab.m7416i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                    AppMethodBeat.m2505o(20128);
                    return;
                } else {
                    C9638aw.m17182Rg().mo14539a(1267, (C1202f) this);
                    C9638aw.m17182Rg().mo14541a(new C42995q(), 0);
                }
            }
        }
        AppMethodBeat.m2505o(20128);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(20129);
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
            AppMethodBeat.m2505o(20129);
            return;
        }
        if (c1207m instanceof C42995q) {
            C9638aw.m17182Rg().mo14546b(1267, (C1202f) this);
            if (i == 0 && i2 == 0) {
                aol aol = (aol) ((C42995q) c1207m).ehh.fsH.fsP;
                String str2 = "MicroMsg.ExdeviceRankDataSourceUI";
                String str3 = "onSceneEnd, get sport device list succ.(size : %d)";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(aol.wna != null ? aol.wna.size() : 0);
                C4990ab.m7411d(str2, str3, objArr);
                final LinkedList linkedList = aol.wna;
                runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(20116);
                        C27886b b = ExdeviceRankDataSourceUI.this.lCZ;
                        List<cmk> list = linkedList;
                        b.lDe.clear();
                        if (!(list == null || list.size() == 0)) {
                            for (cmk cmk : list) {
                                if (cmk != null) {
                                    b.lDe.add(ExdeviceRankDataSourceUI.m55820a(cmk));
                                }
                            }
                        }
                        ExdeviceRankDataSourceUI.this.lCZ.notifyDataSetChanged();
                        AppMethodBeat.m2505o(20116);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(20129);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(20126);
        finish();
        AppMethodBeat.m2505o(20126);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m55823a(String str, String str2, cmk cmk) {
        AppMethodBeat.m2504i(20132);
        if (cmk == null || str == null || str2 == null || !str.equals(cmk.wbq) || !str2.equals(cmk.vIk)) {
            AppMethodBeat.m2505o(20132);
            return false;
        }
        AppMethodBeat.m2505o(20132);
        return true;
    }
}
