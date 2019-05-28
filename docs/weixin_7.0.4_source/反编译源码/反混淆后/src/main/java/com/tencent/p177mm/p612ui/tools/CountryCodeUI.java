package com.tencent.p177mm.p612ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar.C30374a;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.tools.CountryCodeUI */
public class CountryCodeUI extends MMActivity {
    private String countryCode;
    private C5601o elS;
    private String fHE;
    private String gBE;
    private String gtX = "";
    private List<C17951a> list;
    private boolean nBL = false;
    private ListView nCa;
    private String title = null;
    private C46694c zAL;
    private VerticalScrollBar zAM;
    private String[] zAN = null;
    private C30374a zkw;

    /* renamed from: com.tencent.mm.ui.tools.CountryCodeUI$2 */
    class C240232 implements Comparator<C17951a> {
        C240232() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C17951a) obj).fHG - ((C17951a) obj2).fHG;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CountryCodeUI$1 */
    class C307341 implements Comparator<C17951a> {
        C307341() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(34801);
            int compareTo = ((C17951a) obj).fHF.compareTo(((C17951a) obj2).fHF);
            AppMethodBeat.m2505o(34801);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CountryCodeUI$3 */
    class C307353 implements C5600b {
        C307353() {
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(34802);
            CountryCodeUI.this.gtX = str;
            CountryCodeUI.m70837a(CountryCodeUI.this);
            AppMethodBeat.m2505o(34802);
        }

        public final void apo() {
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

    /* renamed from: com.tencent.mm.ui.tools.CountryCodeUI$4 */
    class C363124 implements C30374a {
        C363124() {
        }

        /* renamed from: kp */
        public final void mo17482kp(String str) {
            int i = 0;
            AppMethodBeat.m2504i(34803);
            char charAt = str.charAt(0);
            if (CountryCodeUI.this.getString(C25738R.string.dz6).equals(str)) {
                CountryCodeUI.this.nCa.setSelection(0);
                AppMethodBeat.m2505o(34803);
                return;
            }
            int[] iArr = CountryCodeUI.this.zAL.nBK;
            if (iArr == null) {
                AppMethodBeat.m2505o(34803);
                return;
            }
            while (i < iArr.length) {
                if (iArr[i] == charAt) {
                    CountryCodeUI.this.nCa.setSelection(i + CountryCodeUI.this.nCa.getHeaderViewsCount());
                    AppMethodBeat.m2505o(34803);
                    return;
                }
                i++;
            }
            AppMethodBeat.m2505o(34803);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CountryCodeUI$5 */
    class C363135 implements C30374a {
        C363135() {
        }

        /* renamed from: kp */
        public final void mo17482kp(String str) {
            int i = 0;
            AppMethodBeat.m2504i(34804);
            if (CountryCodeUI.this.getString(C25738R.string.dz6).equals(str)) {
                CountryCodeUI.this.nCa.setSelection(0);
                AppMethodBeat.m2505o(34804);
                return;
            }
            int intValue = Integer.decode(str.substring(0, str.length() - 1)).intValue();
            int[] iArr = CountryCodeUI.this.zAL.nBK;
            if (iArr == null) {
                AppMethodBeat.m2505o(34804);
                return;
            }
            while (i < iArr.length) {
                if (iArr[i] == intValue) {
                    CountryCodeUI.this.nCa.setSelection(i + CountryCodeUI.this.nCa.getHeaderViewsCount());
                    AppMethodBeat.m2505o(34804);
                    return;
                }
                i++;
            }
            AppMethodBeat.m2505o(34804);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CountryCodeUI$7 */
    class C363147 implements OnItemClickListener {
        C363147() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(34806);
            Intent intent = new Intent();
            if (i >= CountryCodeUI.this.nCa.getHeaderViewsCount()) {
                C17951a c17951a = (C17951a) CountryCodeUI.this.zAL.getItem(i - CountryCodeUI.this.nCa.getHeaderViewsCount());
                intent.putExtra("country_name", c17951a.fHE);
                intent.putExtra("couttry_code", c17951a.fHD);
                intent.putExtra("iso_code", c17951a.fHC);
                CountryCodeUI.this.setResult(100, intent);
            }
            CountryCodeUI.this.finish();
            AppMethodBeat.m2505o(34806);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CountryCodeUI$6 */
    class C408806 implements OnMenuItemClickListener {
        C408806() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34805);
            CountryCodeUI.this.aqX();
            Intent intent = new Intent();
            intent.putExtra("country_name", CountryCodeUI.this.fHE);
            intent.putExtra("couttry_code", CountryCodeUI.this.countryCode);
            intent.putExtra("iso_code", CountryCodeUI.this.gBE);
            CountryCodeUI.this.setResult(100, intent);
            CountryCodeUI.this.finish();
            AppMethodBeat.m2505o(34805);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34807);
        super.onCreate(bundle);
        this.fHE = C42252ah.m74607bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = C42252ah.m74607bc(getIntent().getStringExtra("couttry_code"), "");
        this.gBE = C42252ah.m74607bc(getIntent().getStringExtra("iso_code"), "");
        this.nBL = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
        this.zAN = getIntent().getStringArrayExtra("exclude_countries_iso");
        this.title = getIntent().getStringExtra("ui_title");
        initView();
        AppMethodBeat.m2505o(34807);
    }

    public final int getLayoutId() {
        AppMethodBeat.m2504i(34808);
        if (C4988aa.dop()) {
            AppMethodBeat.m2505o(34808);
            return 2130969250;
        }
        AppMethodBeat.m2505o(34808);
        return 2130969249;
    }

    public void onPause() {
        AppMethodBeat.m2504i(34809);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.m2505o(34809);
    }

    private void dJB() {
        AppMethodBeat.m2504i(34810);
        this.list = C17950b.m28209G(this, getString(C25738R.string.b3_));
        if (this.zAN != null && this.zAN.length > 0) {
            for (int size = this.list.size() - 1; size >= 0; size--) {
                int i;
                String str = ((C17951a) this.list.get(size)).fHC;
                for (String equals : this.zAN) {
                    if (equals.equals(str)) {
                        C4990ab.m7417i("MicroMsg.CountryCodeUI", "exclude country: %s", str);
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i != 0) {
                    this.list.remove(size);
                }
            }
        }
        if (C4988aa.dop()) {
            Collections.sort(this.list, new C240232());
            AppMethodBeat.m2505o(34810);
            return;
        }
        Collections.sort(this.list, new C307341());
        AppMethodBeat.m2505o(34810);
    }

    public final void initView() {
        AppMethodBeat.m2504i(34811);
        if (C5046bo.isNullOrNil(this.title)) {
            setMMTitle((int) C25738R.string.f8783ev);
        } else {
            setMMTitle(this.title);
        }
        dJB();
        this.elS = new C5601o((byte) 0);
        this.elS.zHa = new C307353();
        mo17380a(this.elS);
        this.nCa = (ListView) findViewById(2131821054);
        this.zAL = new C46694c(this, this.list);
        this.zAL.nBL = this.nBL;
        this.nCa.setAdapter(this.zAL);
        this.nCa.setVisibility(0);
        this.zAM = (VerticalScrollBar) findViewById(2131821057);
        if (C4988aa.dop()) {
            this.zkw = new C363135();
        } else {
            this.zkw = new C363124();
        }
        this.zAM.setOnScrollBarTouchListener(this.zkw);
        setBackBtn(new C408806());
        this.nCa.setOnItemClickListener(new C363147());
        AppMethodBeat.m2505o(34811);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(34812);
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("country_name", this.fHE);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("iso_code", this.gBE);
            setResult(100, intent);
            finish();
            AppMethodBeat.m2505o(34812);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(34812);
        return onKeyUp;
    }

    /* renamed from: a */
    static /* synthetic */ void m70837a(CountryCodeUI countryCodeUI) {
        AppMethodBeat.m2504i(34813);
        if (countryCodeUI.zAL != null) {
            countryCodeUI.zAL.mo75002vM(countryCodeUI.gtX);
        }
        AppMethodBeat.m2505o(34813);
    }
}
