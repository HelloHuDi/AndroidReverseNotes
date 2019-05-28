package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C38937e;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI */
public class ExdeviceLikeUI extends MMActivity {
    private ArrayList<C38937e> lAT;
    private boolean lAU;
    private ListView lAV;
    private C7754a lAW;
    private final int lAX = 30;
    private String mAppName;

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI$4 */
    class C29974 implements OnItemClickListener {
        C29974() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(19971);
            C38937e c38937e = (C38937e) ExdeviceLikeUI.this.lAT.get(i);
            Intent intent = new Intent();
            intent.putExtra("rank_id", c38937e.field_rankID);
            intent.putExtra("device_type", 1);
            intent.putExtra("locate_to_username", c38937e.field_username);
            intent.putExtra("app_username", C1854s.m3866mJ("gh_43f2581f6fd6"));
            C25985d.m41467b(ExdeviceLikeUI.this, "exdevice", ".ui.ExdeviceRankInfoUI", intent);
            AppMethodBeat.m2505o(19971);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI$2 */
    class C77522 implements OnMenuItemClickListener {
        C77522() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19969);
            ExdeviceLikeUI.this.finish();
            AppMethodBeat.m2505o(19969);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI$3 */
    class C77533 implements OnItemClickListener {
        C77533() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(19970);
            C38937e c38937e = (C38937e) ExdeviceLikeUI.this.lAW.getItem(i);
            Intent intent = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
            intent.putExtra("app_username", c38937e.field_appusername);
            intent.putExtra("rank_id", c38937e.field_rankID);
            intent.putExtra("device_type", 1);
            ExdeviceLikeUI.this.startActivity(intent);
            ExdeviceLikeUI.this.finish();
            AppMethodBeat.m2505o(19970);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI$a */
    class C7754a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI$a$a */
        class C7755a {
            ImageView eks;
            TextView gJE;
            NoMeasuredTextView lAZ;
            TextView timeTv;

            C7755a() {
            }
        }

        C7754a() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(19972);
            if (ExdeviceLikeUI.this.lAT == null) {
                AppMethodBeat.m2505o(19972);
                return 0;
            }
            int size = ExdeviceLikeUI.this.lAT.size();
            AppMethodBeat.m2505o(19972);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(19973);
            Object obj = ExdeviceLikeUI.this.lAT.get(i);
            AppMethodBeat.m2505o(19973);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            C7755a c7755a;
            AppMethodBeat.m2504i(19974);
            C38937e c38937e = (C38937e) ExdeviceLikeUI.this.lAT.get(i);
            if (view == null) {
                if (ExdeviceLikeUI.this.lAU) {
                    inflate = LayoutInflater.from(ExdeviceLikeUI.this).inflate(2130969422, viewGroup, false);
                } else {
                    inflate = LayoutInflater.from(ExdeviceLikeUI.this).inflate(2130969421, viewGroup, false);
                }
                C7755a c7755a2 = new C7755a();
                c7755a2.eks = (ImageView) inflate.findViewById(2131823658);
                c7755a2.lAZ = (NoMeasuredTextView) inflate.findViewById(2131823660);
                c7755a2.gJE = (TextView) inflate.findViewById(2131823661);
                c7755a2.timeTv = (TextView) inflate.findViewById(2131823659);
                c7755a2.lAZ.setTextSize(0, ExdeviceLikeUI.this.getResources().getDimension(C25738R.dimen.f9980m5));
                c7755a2.lAZ.setTextColor(ExdeviceLikeUI.this.getResources().getColor(C25738R.color.f11782h4));
                c7755a2.lAZ.setSingleLine(true);
                c7755a2.lAZ.setShouldEllipsize(true);
                inflate.setTag(c7755a2);
                c7755a = c7755a2;
            } else {
                c7755a = (C7755a) view.getTag();
                inflate = view;
            }
            C40460b.m69438s(c7755a.eks, c38937e.field_username);
            c7755a.lAZ.setText(C44089j.m79293b(ExdeviceLikeUI.this, C1854s.m3866mJ(c38937e.field_username), c7755a.lAZ.getTextSize()));
            if (!C5046bo.isNullOrNil(c38937e.field_liketips) && c7755a.gJE != null) {
                c7755a.gJE.setVisibility(0);
                c7755a.gJE.setText(c38937e.field_liketips);
            } else if (c7755a.gJE != null) {
                c7755a.gJE.setVisibility(8);
            }
            if (((int) ((((System.currentTimeMillis() / 1000) - ((long) c38937e.field_timestamp)) / 60) + 1)) <= 30) {
                c7755a.timeTv.setText(ExdeviceLikeUI.this.getString(C25738R.string.bgo, new Object[]{Integer.valueOf(r3)}));
            } else {
                c7755a.timeTv.setText(C14835h.m23089c(ExdeviceLikeUI.this, ((long) c38937e.field_timestamp) * 1000, true));
            }
            AppMethodBeat.m2505o(19974);
            return inflate;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI$1 */
    class C77561 implements OnMenuItemClickListener {
        C77561() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(19968);
            Intent intent = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
            intent.putExtra("app_username", ExdeviceLikeUI.this.mAppName);
            intent.putExtra("rank_id", "#");
            intent.putExtra("key_is_latest", true);
            intent.putExtra("device_type", 1);
            ExdeviceLikeUI.this.startActivity(intent);
            ExdeviceLikeUI.this.finish();
            AppMethodBeat.m2505o(19968);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(19975);
        super.onCreate(bundle);
        this.mAppName = getIntent().getStringExtra("app_username");
        String stringExtra = getIntent().getStringExtra("key_rank_info");
        String stringExtra2 = getIntent().getStringExtra("key_rank_semi");
        this.lAU = getIntent().getBooleanExtra("key_is_like_read_only", false);
        if (C5046bo.isNullOrNil(stringExtra)) {
            boolean z;
            stringExtra2 = getIntent().getStringExtra("rank_id");
            if (C5046bo.isNullOrNil(stringExtra2)) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(z);
            this.lAT = C45891ad.bpb().mo35789Ks(stringExtra2);
        } else {
            ArrayList arrayList;
            String str = this.mAppName;
            C4990ab.m7410d("MicroMsg.ExdeviceMsgXmlParser", stringExtra);
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7412e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
            } else {
                C8910b X = C8910b.m16058X(stringExtra, stringExtra2);
                if (X != null) {
                    Map map = X.fgm;
                    ArrayList arrayList2 = new ArrayList();
                    if (!(map == null || map.isEmpty())) {
                        int i = 0;
                        while (true) {
                            stringExtra = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                            if (C5046bo.isNullOrNil(stringExtra)) {
                                break;
                            }
                            stringExtra2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".rankid");
                            String str2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".liketip");
                            String str3 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".timestamp");
                            C38937e c38937e = new C38937e();
                            c38937e.field_appusername = str;
                            c38937e.field_rankID = stringExtra2;
                            c38937e.field_username = stringExtra;
                            c38937e.field_timestamp = C5046bo.getInt(str3, 0);
                            c38937e.field_liketips = str2;
                            arrayList2.add(c38937e);
                            i++;
                        }
                        C4990ab.m7417i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i));
                        arrayList = arrayList2;
                        this.lAT = arrayList;
                    }
                }
            }
            arrayList = null;
            this.lAT = arrayList;
        }
        this.lAV = (ListView) findViewById(2131823662);
        this.lAV.setEmptyView(findViewById(2131821749));
        this.lAW = new C7754a();
        this.lAV.setAdapter(this.lAW);
        if (!this.lAU) {
            this.lAV.setOnItemClickListener(new C77533());
        }
        this.lAV.setOnItemClickListener(new C29974());
        setMMTitle((int) C25738R.string.bgp);
        if (!this.lAU) {
            addTextOptionMenu(0, getString(C25738R.string.bgn), new C77561());
        }
        setBackBtn(new C77522());
        AppMethodBeat.m2505o(19975);
    }

    public final int getLayoutId() {
        return 2130969423;
    }
}
