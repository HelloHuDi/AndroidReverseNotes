package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.platformtools.SpellMap;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34381b;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C46032c;
import com.tencent.p177mm.plugin.ipcall.p442ui.IPCallCountryCodeScrollbar.C28341a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI */
public class IPCallCountryCodeSelectUI extends MMActivity {
    private String countryCode;
    private C5601o elS;
    private String fHE;
    private String gtX = "";
    private List<C28349a> list;
    public LinearLayout nBB;
    private boolean nBL = false;
    private ListView nCa;
    private C43231f nCb;
    private IPCallCountryCodeScrollbar nCc;
    private C28341a nCd;
    private boolean nCe = false;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI$2 */
    class C122642 implements C5600b {
        C122642() {
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(22112);
            IPCallCountryCodeSelectUI.this.gtX = str;
            IPCallCountryCodeSelectUI.m44975a(IPCallCountryCodeSelectUI.this);
            AppMethodBeat.m2505o(22112);
        }

        public final void apo() {
            AppMethodBeat.m2504i(22113);
            IPCallCountryCodeSelectUI.this.gtX = "";
            IPCallCountryCodeSelectUI.m44975a(IPCallCountryCodeSelectUI.this);
            AppMethodBeat.m2505o(22113);
        }

        public final void app() {
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI$4 */
    class C211094 implements OnMenuItemClickListener {
        C211094() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22115);
            IPCallCountryCodeSelectUI.this.aqX();
            Intent intent = new Intent();
            intent.putExtra("country_name", IPCallCountryCodeSelectUI.this.fHE);
            intent.putExtra("couttry_code", IPCallCountryCodeSelectUI.this.countryCode);
            IPCallCountryCodeSelectUI.this.setResult(100, intent);
            IPCallCountryCodeSelectUI.this.finish();
            AppMethodBeat.m2505o(22115);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI$1 */
    class C283421 implements OnMenuItemClickListener {
        C283421() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22111);
            IPCallCountryCodeSelectUI.this.finish();
            AppMethodBeat.m2505o(22111);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI$3 */
    class C283433 implements C28341a {
        C283433() {
        }

        /* renamed from: kp */
        public final void mo46274kp(String str) {
            int i = 0;
            AppMethodBeat.m2504i(22114);
            char charAt = str.charAt(0);
            if ("↑".equals(str)) {
                IPCallCountryCodeSelectUI.this.nCa.setSelection(0);
                AppMethodBeat.m2505o(22114);
                return;
            }
            int[] iArr = IPCallCountryCodeSelectUI.this.nCb.nBK;
            if (iArr == null) {
                AppMethodBeat.m2505o(22114);
                return;
            }
            while (i < iArr.length) {
                if (iArr[i] == charAt) {
                    IPCallCountryCodeSelectUI.this.nCa.setSelection(i + IPCallCountryCodeSelectUI.this.nCa.getHeaderViewsCount());
                    AppMethodBeat.m2505o(22114);
                    return;
                }
                i++;
            }
            AppMethodBeat.m2505o(22114);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI$5 */
    class C283445 implements OnItemClickListener {
        C283445() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22116);
            Intent intent = new Intent();
            if (i >= IPCallCountryCodeSelectUI.this.nCa.getHeaderViewsCount()) {
                C28349a c28349a = (C28349a) IPCallCountryCodeSelectUI.this.nCb.getItem(i - IPCallCountryCodeSelectUI.this.nCa.getHeaderViewsCount());
                intent.putExtra("country_name", c28349a.fHE);
                intent.putExtra("couttry_code", c28349a.countryCode);
                IPCallCountryCodeSelectUI.this.setResult(100, intent);
            }
            IPCallCountryCodeSelectUI.this.finish();
            AppMethodBeat.m2505o(22116);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI$6 */
    class C283456 implements Comparator<C28349a> {
        C283456() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(22117);
            int compareTo = ((C28349a) obj).fHF.compareTo(((C28349a) obj2).fHF);
            AppMethodBeat.m2505o(22117);
            return compareTo;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22118);
        super.onCreate(bundle);
        this.list = new ArrayList();
        this.fHE = C5046bo.m7532bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = C5046bo.m7532bc(getIntent().getStringExtra("couttry_code"), "");
        this.nBL = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
        setBackBtn(new C283421());
        initView();
        AppMethodBeat.m2505o(22118);
    }

    public void finish() {
        AppMethodBeat.m2504i(22119);
        super.finish();
        overridePendingTransition(-1, C25738R.anim.f8373ce);
        AppMethodBeat.m2505o(22119);
    }

    public final int getLayoutId() {
        return 2130969885;
    }

    public void onPause() {
        AppMethodBeat.m2504i(22120);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.m2505o(22120);
    }

    public final void initView() {
        int intValue;
        AppMethodBeat.m2504i(22121);
        setMMTitle((int) C25738R.string.f8783ev);
        this.elS = new C5601o((byte) 0);
        this.elS.zHa = new C122642();
        mo17380a(this.elS);
        this.nCc = (IPCallCountryCodeScrollbar) findViewById(2131821057);
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (Integer intValue2 : C46032c.bHc().bHf()) {
            intValue = intValue2.intValue();
            if (i >= 5) {
                break;
            }
            String Pq = C46041a.m85631Pq(String.valueOf(intValue));
            if (C5046bo.isNullOrNil(Pq) || C46032c.bHc().mo73925xf(intValue)) {
                intValue = i;
            } else {
                this.list.add(new C28349a(Pq, String.valueOf(intValue), 0, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                intValue = i + 1;
            }
            i = intValue;
        }
        if (i > 0) {
            this.nCe = true;
        }
        C34381b c34381b;
        String str;
        if (C4988aa.don()) {
            for (Entry entry : C46041a.bIM().entrySet()) {
                entry.getKey();
                c34381b = (C34381b) entry.getValue();
                str = c34381b.nHe;
                if (!(str == null || "".equals(str.trim()))) {
                    char[] toCharArray = str.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = toCharArray.length;
                    for (i = 0; i < length; i++) {
                        String r = SpellMap.m42342r(toCharArray[i]);
                        if (C5046bo.isNullOrNil(r)) {
                            stringBuffer.append(toCharArray[i]);
                        } else {
                            stringBuffer.append(r);
                        }
                    }
                    str = stringBuffer.toString();
                }
                str = str.toUpperCase();
                if (C5046bo.isNullOrNil(str)) {
                    str = " ";
                }
                if (!C46032c.bHc().mo73925xf(C5046bo.getInt(c34381b.nHd, 0))) {
                    this.list.add(new C28349a(c34381b.nHe, c34381b.nHd, str.charAt(0), str));
                }
            }
        } else {
            for (Entry entry2 : C46041a.bIM().entrySet()) {
                entry2.getKey();
                c34381b = (C34381b) entry2.getValue();
                str = c34381b.nHe.toUpperCase();
                if (C5046bo.isNullOrNil(str)) {
                    str = " ";
                }
                if (!C46032c.bHc().mo73925xf(C5046bo.getInt(c34381b.nHd, 0))) {
                    this.list.add(new C28349a(c34381b.nHe, c34381b.nHd, str.charAt(0), str));
                }
            }
        }
        Collections.sort(this.list, new C283456());
        for (C28349a bIc : this.list) {
            intValue = bIc.bIc();
            if (intValue != 0) {
                this.nCc.mo62163Pf(String.valueOf((char) intValue));
            }
        }
        C4990ab.m7411d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.nBB = (LinearLayout) findViewById(2131825037);
        this.nCa = (ListView) findViewById(2131821054);
        this.nCb = new C43231f(this, this.list);
        this.nCb.nBL = this.nBL;
        this.nCb.nBM = this.nCe;
        this.nCa.setAdapter(this.nCb);
        this.nCa.setVisibility(0);
        this.nCd = new C283433();
        this.nCc.setOnScrollBarTouchListener(this.nCd);
        setBackBtn(new C211094());
        this.nCa.setOnItemClickListener(new C283445());
        AppMethodBeat.m2505o(22121);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(22122);
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("country_name", this.fHE);
            intent.putExtra("couttry_code", this.countryCode);
            setResult(100, intent);
            finish();
            AppMethodBeat.m2505o(22122);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(22122);
        return onKeyDown;
    }

    /* renamed from: a */
    static /* synthetic */ void m44975a(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        AppMethodBeat.m2504i(22123);
        if (iPCallCountryCodeSelectUI.nCb != null) {
            iPCallCountryCodeSelectUI.nCb.mo68746vM(iPCallCountryCodeSelectUI.gtX);
        }
        AppMethodBeat.m2505o(22123);
    }
}
