package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.setting.model.C43502c;
import com.tencent.p177mm.plugin.setting.model.C46191f;
import com.tencent.p177mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.p177mm.protocal.protobuf.cmb;
import com.tencent.p177mm.protocal.protobuf.cmc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI */
public class SettingsManageAuthUI extends MMActivity implements C1202f {
    private ListView mListView;
    private View mtk;
    private ProgressDialog nEK;
    private byte[] qjF;
    private C28947a qns;
    private List<cmb> qnt = new ArrayList();
    private boolean qnu;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$5 */
    class C38015 implements OnMenuItemClickListener {
        C38015() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127250);
            if (menuItem.getItemId() == 700) {
                SettingsManageAuthUI.this.qnu = false;
                SettingsManageAuthUI.this.qns.notifyDataSetChanged();
                SettingsManageAuthUI.m57267e(SettingsManageAuthUI.this);
            }
            AppMethodBeat.m2505o(127250);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$4 */
    class C132174 implements OnMenuItemClickListener {
        C132174() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127249);
            SettingsManageAuthUI.this.startActivity(new Intent(SettingsManageAuthUI.this, SettingsSearchAuthUI.class));
            C5274b.m8052hK(SettingsManageAuthUI.this);
            AppMethodBeat.m2505o(127249);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$6 */
    class C289446 implements OnMenuItemClickListener {
        C289446() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127251);
            if (menuItem.getItemId() == 700) {
                SettingsManageAuthUI.this.qnu = true;
                SettingsManageAuthUI.this.qns.notifyDataSetChanged();
                SettingsManageAuthUI.m57267e(SettingsManageAuthUI.this);
            }
            AppMethodBeat.m2505o(127251);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$a */
    class C28947a extends BaseAdapter {
        List<cmb> qnw;

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$a$a */
        class C28946a {
            Button gzI;
            TextView iPD;
            TextView qnA;
            TextView qnB;

            private C28946a() {
            }

            /* synthetic */ C28946a(C28947a c28947a, byte b) {
                this();
            }
        }

        private C28947a() {
        }

        /* synthetic */ C28947a(SettingsManageAuthUI settingsManageAuthUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(127257);
            cmb Cm = mo47051Cm(i);
            AppMethodBeat.m2505o(127257);
            return Cm;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(127254);
            if (this.qnw == null || this.qnw.isEmpty()) {
                AppMethodBeat.m2505o(127254);
                return 0;
            }
            int size = this.qnw.size();
            AppMethodBeat.m2505o(127254);
            return size;
        }

        /* renamed from: Cm */
        public final cmb mo47051Cm(int i) {
            AppMethodBeat.m2504i(127255);
            if (i < 0 || i >= getCount()) {
                AppMethodBeat.m2505o(127255);
                return null;
            }
            cmb cmb = (cmb) this.qnw.get(i);
            AppMethodBeat.m2505o(127255);
            return cmb;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            C28946a c28946a;
            AppMethodBeat.m2504i(127256);
            if (view == null) {
                view = SettingsManageAuthUI.this.getLayoutInflater().inflate(2130970632, null);
                C28946a c28946a2 = new C28946a(this, (byte) 0);
                view.setTag(c28946a2);
                c28946a = c28946a2;
            } else {
                c28946a = (C28946a) view.getTag();
            }
            c28946a.iPD = (TextView) view.findViewById(2131827384);
            c28946a.qnA = (TextView) view.findViewById(2131827385);
            c28946a.qnB = (TextView) view.findViewById(2131827386);
            c28946a.gzI = (Button) view.findViewById(2131827387);
            c28946a.gzI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(127253);
                    if (C28947a.this.mo47051Cm(i) != null) {
                        final C1207m c43502c = new C43502c(C28947a.this.mo47051Cm(i).csB, 1);
                        if (SettingsManageAuthUI.this.nEK != null) {
                            SettingsManageAuthUI.this.nEK.dismiss();
                        }
                        C1720g.m3540Rg().mo14541a(c43502c, 0);
                        SettingsManageAuthUI.this.nEK = C30379h.m48458b(SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(C25738R.string.f9222th), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(127252);
                                C1720g.m3540Rg().mo14547c(c43502c);
                                AppMethodBeat.m2505o(127252);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(127253);
                }
            });
            if (SettingsManageAuthUI.this.qnu) {
                c28946a.gzI.setVisibility(0);
            } else {
                c28946a.gzI.setVisibility(8);
            }
            if (mo47051Cm(i) != null) {
                c28946a.iPD.setText(mo47051Cm(i).fhH);
                c28946a.qnA.setText(mo47051Cm(i).xjO);
                c28946a.qnB.setText(SettingsManageAuthUI.m57265cX(mo47051Cm(i).xjN));
            }
            AppMethodBeat.m2505o(127256);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$1 */
    class C348731 implements OnScrollListener {
        C348731() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(127246);
            if (i + i2 == i3) {
                C4990ab.m7416i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
                if (SettingsManageAuthUI.this.qjF != null) {
                    SettingsManageAuthUI.m57263bh(SettingsManageAuthUI.this.qjF);
                    SettingsManageAuthUI.this.qjF = null;
                }
            }
            AppMethodBeat.m2505o(127246);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$2 */
    class C348742 implements OnItemClickListener {
        C348742() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(127247);
            if (!SettingsManageAuthUI.this.qnu) {
                cmb Cm = SettingsManageAuthUI.this.qns.mo47051Cm(i);
                if (Cm != null) {
                    Intent intent = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
                    UserAuthItemParcelable[] userAuthItemParcelableArr = (UserAuthItemParcelable[]) UserAuthItemParcelable.CREATOR.newArray(Cm.xjN.size());
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= Cm.xjN.size()) {
                            break;
                        }
                        cmc cmc = (cmc) Cm.xjN.get(i3);
                        UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
                        userAuthItemParcelable.scope = cmc.scope;
                        userAuthItemParcelable.qkh = cmc.qkh;
                        userAuthItemParcelable.state = cmc.state;
                        userAuthItemParcelable.qki = cmc.qki;
                        userAuthItemParcelableArr[i3] = userAuthItemParcelable;
                        i2 = i3 + 1;
                    }
                    intent.putExtra("app_id", Cm.csB);
                    intent.putExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, Cm.fhH);
                    intent.putExtra("modify_scene", 1);
                    intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                    SettingsManageAuthUI.this.startActivity(intent);
                }
            }
            AppMethodBeat.m2505o(127247);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI$3 */
    class C348753 implements OnMenuItemClickListener {
        C348753() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127248);
            SettingsManageAuthUI.this.finish();
            AppMethodBeat.m2505o(127248);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsManageAuthUI() {
        AppMethodBeat.m2504i(127258);
        AppMethodBeat.m2505o(127258);
    }

    /* renamed from: bh */
    static /* synthetic */ void m57263bh(byte[] bArr) {
        AppMethodBeat.m2504i(127266);
        SettingsManageAuthUI.m57262bg(bArr);
        AppMethodBeat.m2505o(127266);
    }

    /* renamed from: e */
    static /* synthetic */ void m57267e(SettingsManageAuthUI settingsManageAuthUI) {
        AppMethodBeat.m2504i(127267);
        settingsManageAuthUI.ciQ();
        AppMethodBeat.m2505o(127267);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127259);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127259);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127260);
        this.mListView = (ListView) findViewById(2131827394);
        this.mtk = findViewById(2131827395);
        this.qns = new C28947a(this, (byte) 0);
        this.mListView.setAdapter(this.qns);
        this.mListView.setOnScrollListener(new C348731());
        this.mListView.setOnItemClickListener(new C348742());
        ciQ();
        setMMTitle((int) C25738R.string.e5p);
        setBackBtn(new C348753());
        AppMethodBeat.m2505o(127260);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127262);
        super.onResume();
        C1720g.m3540Rg().mo14539a(1146, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1127, (C1202f) this);
        SettingsManageAuthUI.m57262bg(null);
        AppMethodBeat.m2505o(127262);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127263);
        super.onPause();
        C1720g.m3540Rg().mo14546b(1146, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1127, (C1202f) this);
        AppMethodBeat.m2505o(127263);
    }

    public final int getLayoutId() {
        return 2130970635;
    }

    /* renamed from: bg */
    private static void m57262bg(byte[] bArr) {
        AppMethodBeat.m2504i(127264);
        C1720g.m3540Rg().mo14541a(new C46191f(bArr), 0);
        AppMethodBeat.m2505o(127264);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127265);
        C4990ab.m7417i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.nEK != null) {
            this.nEK.dismiss();
        }
        if (i != 0 || i2 != 0) {
            C30379h.m48465bQ(this, str);
        } else if (c1207m.getType() == 1146) {
            byte[] bArr;
            int i3;
            Collection collection;
            C46191f c46191f = (C46191f) c1207m;
            if (c46191f.qjE == null || c46191f.qjE.wtv != 1) {
                bArr = null;
            } else {
                bArr = c46191f.qjE.wtt.toByteArray();
            }
            this.qjF = bArr;
            if (((C46191f) c1207m).qjF != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.qnt.clear();
            }
            List list = this.qnt;
            C46191f c46191f2 = (C46191f) c1207m;
            if (c46191f2.qjE != null) {
                collection = c46191f2.qjE.wtu;
            } else {
                collection = Collections.emptyList();
            }
            list.addAll(collection);
            this.qns.qnw = this.qnt;
            this.qns.notifyDataSetChanged();
            ciQ();
            AppMethodBeat.m2505o(127265);
            return;
        } else if (c1207m.getType() == 1127) {
            String str2 = ((C43502c) c1207m).appId;
            if (!C5046bo.isNullOrNil(str2)) {
                if (!this.qnt.isEmpty()) {
                    Iterator it = this.qnt.iterator();
                    while (it.hasNext()) {
                        if (((cmb) it.next()).csB.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.qns.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(127265);
            return;
        }
        AppMethodBeat.m2505o(127265);
    }

    private void ciQ() {
        AppMethodBeat.m2504i(127261);
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(800, C1318a.actionbar_search_icon, new C132174());
        if (this.qnt.isEmpty()) {
            this.mtk.setVisibility(0);
            AppMethodBeat.m2505o(127261);
            return;
        }
        this.mtk.setVisibility(8);
        if (this.qnu) {
            addTextOptionMenu(700, getString(C25738R.string.f9142qt), new C38015());
            AppMethodBeat.m2505o(127261);
            return;
        }
        addTextOptionMenu(700, getString(C25738R.string.f9163rh), new C289446());
        AppMethodBeat.m2505o(127261);
    }

    /* renamed from: cX */
    static /* synthetic */ String m57265cX(List list) {
        AppMethodBeat.m2504i(127268);
        StringBuilder stringBuilder = new StringBuilder();
        for (cmc cmc : list) {
            stringBuilder.append(cmc.qkh);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(127268);
        return stringBuilder2;
    }
}
