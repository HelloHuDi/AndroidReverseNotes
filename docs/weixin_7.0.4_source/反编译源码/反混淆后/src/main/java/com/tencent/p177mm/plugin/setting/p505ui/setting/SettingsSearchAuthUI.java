package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12070a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20892a;
import com.tencent.p177mm.plugin.setting.model.C21739i;
import com.tencent.p177mm.plugin.setting.model.C43502c;
import com.tencent.p177mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
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

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI */
public class SettingsSearchAuthUI extends MMActivity implements C1202f {
    private ListView mListView;
    private ProgressDialog nEK;
    private byte[] qjF;
    private boolean qnu;
    private C43138a qoG;
    private View qoH;
    private TextView qoI;
    private TextView qoJ;
    private List<cmb> qoK = new ArrayList();
    private C13229a qoL;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$3 */
    class C38113 implements OnClickListener {
        C38113() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127443);
            Editable text = SettingsSearchAuthUI.this.qoG.getFtsEditText().getEditText().getText();
            if (!C5046bo.m7519ac(text)) {
                SettingsSearchAuthUI.m21232a(SettingsSearchAuthUI.this, text.toString().trim());
            }
            AppMethodBeat.m2505o(127443);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$4 */
    class C38124 implements OnItemClickListener {
        C38124() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(127444);
            if (!SettingsSearchAuthUI.this.qnu) {
                cmb Cm = SettingsSearchAuthUI.this.qoL.mo25281Cm(i);
                if (Cm != null) {
                    Intent intent = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
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
                    intent.putExtra("modify_scene", 2);
                    intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                    SettingsSearchAuthUI.this.startActivity(intent);
                }
            }
            AppMethodBeat.m2505o(127444);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$5 */
    class C132235 implements OnScrollListener {
        C132235() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(127445);
            if (i + i2 == i3) {
                C4990ab.m7416i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
                if (SettingsSearchAuthUI.this.qjF != null) {
                    SettingsSearchAuthUI.m21233a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.qjF);
                    SettingsSearchAuthUI.this.qjF = null;
                }
            }
            AppMethodBeat.m2505o(127445);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$2 */
    class C132242 implements C20892a {
        C132242() {
        }

        public final void bAR() {
        }

        /* renamed from: a */
        public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
            AppMethodBeat.m2504i(127439);
            C4990ab.m7417i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", str);
            if (C5046bo.isNullOrNil(str)) {
                SettingsSearchAuthUI.m21236c(SettingsSearchAuthUI.this);
                AppMethodBeat.m2505o(127439);
                return;
            }
            SettingsSearchAuthUI.m21231a(SettingsSearchAuthUI.this);
            String string = SettingsSearchAuthUI.this.getString(C25738R.string.f9220te);
            C44090k c44090k = new C44090k(string + " " + str.trim());
            c44090k.setSpan(new ForegroundColorSpan(SettingsSearchAuthUI.this.getResources().getColor(C25738R.color.f11795hi)), string.length(), c44090k.length(), 33);
            SettingsSearchAuthUI.this.qoI.setText(c44090k);
            AppMethodBeat.m2505o(127439);
        }

        /* renamed from: hz */
        public final void mo25276hz(boolean z) {
            AppMethodBeat.m2504i(127440);
            C4990ab.m7417i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", Boolean.valueOf(z));
            if (z) {
                SettingsSearchAuthUI.this.showVKB();
                AppMethodBeat.m2505o(127440);
                return;
            }
            SettingsSearchAuthUI.this.aqX();
            AppMethodBeat.m2505o(127440);
        }

        public final void onClickClearTextBtn(View view) {
            AppMethodBeat.m2504i(127441);
            C4990ab.m7416i("MicroMsg.SettingsSearchAuthUI", "clear search text");
            SettingsSearchAuthUI.m21236c(SettingsSearchAuthUI.this);
            AppMethodBeat.m2505o(127441);
        }

        public final boolean aMo() {
            AppMethodBeat.m2504i(127442);
            C4990ab.m7416i("MicroMsg.SettingsSearchAuthUI", "search key down");
            Editable text = SettingsSearchAuthUI.this.qoG.getFtsEditText().getEditText().getText();
            SettingsSearchAuthUI.this.qoI.setVisibility(8);
            SettingsSearchAuthUI.this.qoG.getFtsEditText().getEditText().clearFocus();
            SettingsSearchAuthUI.this.aqX();
            SettingsSearchAuthUI.m21239e(SettingsSearchAuthUI.this);
            if (!C5046bo.m7519ac(text)) {
                SettingsSearchAuthUI.m21232a(SettingsSearchAuthUI.this, text.toString().trim());
            }
            AppMethodBeat.m2505o(127442);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$1 */
    class C132251 implements C12070a {
        C132251() {
        }

        public final void onClickBackBtn(View view) {
            AppMethodBeat.m2504i(127438);
            C4990ab.m7416i("MicroMsg.SettingsSearchAuthUI", "click search back");
            SettingsSearchAuthUI.this.finish();
            AppMethodBeat.m2505o(127438);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$6 */
    class C132266 implements OnMenuItemClickListener {
        C132266() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127446);
            if (menuItem.getItemId() == 700) {
                SettingsSearchAuthUI.this.qnu = false;
                SettingsSearchAuthUI.this.qoL.notifyDataSetChanged();
                SettingsSearchAuthUI.m21239e(SettingsSearchAuthUI.this);
            }
            AppMethodBeat.m2505o(127446);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$7 */
    class C132277 implements OnMenuItemClickListener {
        C132277() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127447);
            if (menuItem.getItemId() == 700) {
                SettingsSearchAuthUI.this.qnu = true;
                SettingsSearchAuthUI.this.qoL.notifyDataSetChanged();
                SettingsSearchAuthUI.m21239e(SettingsSearchAuthUI.this);
            }
            AppMethodBeat.m2505o(127447);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$a */
    class C13229a extends BaseAdapter {
        List<cmb> qnw;

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI$a$a */
        class C13232a {
            Button gzI;
            TextView iPD;
            TextView qnA;
            TextView qnB;

            private C13232a() {
            }

            /* synthetic */ C13232a(C13229a c13229a, byte b) {
                this();
            }
        }

        private C13229a() {
        }

        /* synthetic */ C13229a(SettingsSearchAuthUI settingsSearchAuthUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(127455);
            cmb Cm = mo25281Cm(i);
            AppMethodBeat.m2505o(127455);
            return Cm;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(127452);
            if (this.qnw == null || this.qnw.isEmpty()) {
                AppMethodBeat.m2505o(127452);
                return 0;
            }
            int size = this.qnw.size();
            AppMethodBeat.m2505o(127452);
            return size;
        }

        /* renamed from: Cm */
        public final cmb mo25281Cm(int i) {
            AppMethodBeat.m2504i(127453);
            if (i < 0 || i >= getCount()) {
                AppMethodBeat.m2505o(127453);
                return null;
            }
            cmb cmb = (cmb) this.qnw.get(i);
            AppMethodBeat.m2505o(127453);
            return cmb;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            C13232a c13232a;
            AppMethodBeat.m2504i(127454);
            if (view == null) {
                view = SettingsSearchAuthUI.this.getLayoutInflater().inflate(2130970632, null);
                C13232a c13232a2 = new C13232a(this, (byte) 0);
                view.setTag(c13232a2);
                c13232a = c13232a2;
            } else {
                c13232a = (C13232a) view.getTag();
            }
            c13232a.iPD = (TextView) view.findViewById(2131827384);
            c13232a.qnA = (TextView) view.findViewById(2131827385);
            c13232a.qnB = (TextView) view.findViewById(2131827386);
            c13232a.gzI = (Button) view.findViewById(2131827387);
            c13232a.gzI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(127451);
                    if (C13229a.this.mo25281Cm(i) != null) {
                        final C1207m c43502c = new C43502c(C13229a.this.mo25281Cm(i).csB, 2);
                        if (SettingsSearchAuthUI.this.nEK != null) {
                            SettingsSearchAuthUI.this.nEK.dismiss();
                        }
                        C1720g.m3540Rg().mo14541a(c43502c, 0);
                        SettingsSearchAuthUI.this.nEK = C30379h.m48458b(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(C25738R.string.f9222th), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(127450);
                                C1720g.m3540Rg().mo14547c(c43502c);
                                AppMethodBeat.m2505o(127450);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(127451);
                }
            });
            if (SettingsSearchAuthUI.this.qnu) {
                c13232a.gzI.setVisibility(0);
            } else {
                c13232a.gzI.setVisibility(8);
            }
            if (mo25281Cm(i) != null) {
                c13232a.iPD.setText(mo25281Cm(i).fhH);
                c13232a.qnA.setText(mo25281Cm(i).xjO);
                c13232a.qnB.setText(SettingsSearchAuthUI.m21237cY(mo25281Cm(i).xjN));
            }
            AppMethodBeat.m2505o(127454);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsSearchAuthUI() {
        AppMethodBeat.m2504i(127456);
        AppMethodBeat.m2505o(127456);
    }

    /* renamed from: e */
    static /* synthetic */ void m21239e(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.m2504i(127466);
        settingsSearchAuthUI.ciQ();
        AppMethodBeat.m2505o(127466);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127457);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127457);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127458);
        this.qoG = new C43138a(this);
        this.mListView = (ListView) findViewById(2131827394);
        this.qoL = new C13229a(this, (byte) 0);
        this.mListView.setAdapter(this.qoL);
        this.qoH = findViewById(2131827414);
        this.qoI = (TextView) findViewById(2131827415);
        this.qoJ = (TextView) findViewById(2131827416);
        ciQ();
        getSupportActionBar().setCustomView(this.qoG);
        this.qoG.setSearchViewListener(new C132251());
        this.qoG.getFtsEditText().setFtsEditTextListener(new C132242());
        this.qoI.setOnClickListener(new C38113());
        this.mListView.setOnItemClickListener(new C38124());
        this.mListView.setOnScrollListener(new C132235());
        AppMethodBeat.m2505o(127458);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127459);
        super.onResume();
        C1720g.m3540Rg().mo14539a(1169, (C1202f) this);
        C1720g.m3540Rg().mo14539a(1127, (C1202f) this);
        AppMethodBeat.m2505o(127459);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127460);
        super.onPause();
        C1720g.m3540Rg().mo14546b(1169, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1127, (C1202f) this);
        AppMethodBeat.m2505o(127460);
    }

    public void finish() {
        AppMethodBeat.m2504i(127462);
        super.finish();
        overridePendingTransition(C25738R.anim.f8367c9, C25738R.anim.f8293s);
        AppMethodBeat.m2505o(127462);
    }

    public final int getLayoutId() {
        return 2130970641;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127463);
        C4990ab.m7417i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.nEK != null) {
            this.nEK.dismiss();
        }
        if (i != 0 || i2 != 0) {
            C30379h.m48465bQ(this, str);
        } else if (c1207m.getType() == 1169) {
            byte[] bArr;
            int i3;
            Collection collection;
            C21739i c21739i = (C21739i) c1207m;
            if (c21739i.qjI == null || c21739i.qjI.wtv != 1) {
                bArr = null;
            } else {
                bArr = c21739i.qjI.wtt.toByteArray();
            }
            this.qjF = bArr;
            if (((C21739i) c1207m).qjF != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.qoK.clear();
            }
            List list = this.qoK;
            C21739i c21739i2 = (C21739i) c1207m;
            if (c21739i2.qjI != null) {
                collection = c21739i2.qjI.wtu;
            } else {
                collection = Collections.emptyList();
            }
            list.addAll(collection);
            if (this.qoK.isEmpty()) {
                this.qoH.setVisibility(0);
                this.qoI.setVisibility(8);
                this.qoJ.setVisibility(0);
                this.mListView.setVisibility(8);
                this.qoK.clear();
                ciQ();
                AppMethodBeat.m2505o(127463);
                return;
            }
            this.qoL.qnw = this.qoK;
            this.qoL.notifyDataSetChanged();
            this.qoH.setVisibility(8);
            this.mListView.setVisibility(0);
            ciQ();
            AppMethodBeat.m2505o(127463);
            return;
        } else if (c1207m.getType() == 1127) {
            String str2 = ((C43502c) c1207m).appId;
            if (!C5046bo.isNullOrNil(str2)) {
                if (!this.qoK.isEmpty()) {
                    Iterator it = this.qoK.iterator();
                    while (it.hasNext()) {
                        if (((cmb) it.next()).csB.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.qoL.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(127463);
            return;
        }
        AppMethodBeat.m2505o(127463);
    }

    private void ciQ() {
        AppMethodBeat.m2504i(127461);
        this.mController.removeAllOptionMenu();
        if (!this.qoK.isEmpty()) {
            if (this.qnu) {
                addTextOptionMenu(700, getString(C25738R.string.f9142qt), new C132266());
                AppMethodBeat.m2505o(127461);
                return;
            }
            addTextOptionMenu(700, getString(C25738R.string.f9163rh), new C132277());
        }
        AppMethodBeat.m2505o(127461);
    }

    /* renamed from: a */
    static /* synthetic */ void m21231a(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.m2504i(127464);
        settingsSearchAuthUI.qoH.setVisibility(0);
        settingsSearchAuthUI.qoI.setVisibility(0);
        settingsSearchAuthUI.qoJ.setVisibility(8);
        settingsSearchAuthUI.mListView.setVisibility(8);
        settingsSearchAuthUI.qoK.clear();
        settingsSearchAuthUI.ciQ();
        AppMethodBeat.m2505o(127464);
    }

    /* renamed from: c */
    static /* synthetic */ void m21236c(SettingsSearchAuthUI settingsSearchAuthUI) {
        AppMethodBeat.m2504i(127465);
        settingsSearchAuthUI.qoH.setVisibility(8);
        settingsSearchAuthUI.qoI.setText("");
        settingsSearchAuthUI.qoK.clear();
        settingsSearchAuthUI.mListView.setVisibility(8);
        settingsSearchAuthUI.ciQ();
        AppMethodBeat.m2505o(127465);
    }

    /* renamed from: cY */
    static /* synthetic */ String m21237cY(List list) {
        AppMethodBeat.m2504i(127469);
        StringBuilder stringBuilder = new StringBuilder();
        for (cmc cmc : list) {
            stringBuilder.append(cmc.qkh);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(127469);
        return stringBuilder2;
    }
}
