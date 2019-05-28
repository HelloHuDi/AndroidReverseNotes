package com.tencent.mm.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI extends MMActivity {
    private String countryCode;
    private o elS;
    private String fHE;
    private String gBE;
    private String gtX = "";
    private List<a> list;
    private boolean nBL = false;
    private ListView nCa;
    private String title = null;
    private c zAL;
    private VerticalScrollBar zAM;
    private String[] zAN = null;
    private VerticalScrollBar.a zkw;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34807);
        super.onCreate(bundle);
        this.fHE = ah.bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = ah.bc(getIntent().getStringExtra("couttry_code"), "");
        this.gBE = ah.bc(getIntent().getStringExtra("iso_code"), "");
        this.nBL = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
        this.zAN = getIntent().getStringArrayExtra("exclude_countries_iso");
        this.title = getIntent().getStringExtra("ui_title");
        initView();
        AppMethodBeat.o(34807);
    }

    public final int getLayoutId() {
        AppMethodBeat.i(34808);
        if (aa.dop()) {
            AppMethodBeat.o(34808);
            return R.layout.rg;
        }
        AppMethodBeat.o(34808);
        return R.layout.rf;
    }

    public void onPause() {
        AppMethodBeat.i(34809);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.o(34809);
    }

    private void dJB() {
        AppMethodBeat.i(34810);
        this.list = b.G(this, getString(R.string.b3_));
        if (this.zAN != null && this.zAN.length > 0) {
            for (int size = this.list.size() - 1; size >= 0; size--) {
                int i;
                String str = ((a) this.list.get(size)).fHC;
                for (String equals : this.zAN) {
                    if (equals.equals(str)) {
                        ab.i("MicroMsg.CountryCodeUI", "exclude country: %s", str);
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
        if (aa.dop()) {
            Collections.sort(this.list, new Comparator<a>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((a) obj).fHG - ((a) obj2).fHG;
                }
            });
            AppMethodBeat.o(34810);
            return;
        }
        Collections.sort(this.list, new Comparator<a>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(34801);
                int compareTo = ((a) obj).fHF.compareTo(((a) obj2).fHF);
                AppMethodBeat.o(34801);
                return compareTo;
            }
        });
        AppMethodBeat.o(34810);
    }

    public final void initView() {
        AppMethodBeat.i(34811);
        if (bo.isNullOrNil(this.title)) {
            setMMTitle((int) R.string.ev);
        } else {
            setMMTitle(this.title);
        }
        dJB();
        this.elS = new o((byte) 0);
        this.elS.zHa = new o.b() {
            public final void vO(String str) {
                AppMethodBeat.i(34802);
                CountryCodeUI.this.gtX = str;
                CountryCodeUI.a(CountryCodeUI.this);
                AppMethodBeat.o(34802);
            }

            public final void apo() {
            }

            public final void app() {
            }

            public final boolean vN(String str) {
                return false;
            }

            public final void apq() {
            }

            public final void apr() {
            }
        };
        a(this.elS);
        this.nCa = (ListView) findViewById(R.id.n3);
        this.zAL = new c(this, this.list);
        this.zAL.nBL = this.nBL;
        this.nCa.setAdapter(this.zAL);
        this.nCa.setVisibility(0);
        this.zAM = (VerticalScrollBar) findViewById(R.id.n6);
        if (aa.dop()) {
            this.zkw = new VerticalScrollBar.a() {
                public final void kp(String str) {
                    int i = 0;
                    AppMethodBeat.i(34804);
                    if (CountryCodeUI.this.getString(R.string.dz6).equals(str)) {
                        CountryCodeUI.this.nCa.setSelection(0);
                        AppMethodBeat.o(34804);
                        return;
                    }
                    int intValue = Integer.decode(str.substring(0, str.length() - 1)).intValue();
                    int[] iArr = CountryCodeUI.this.zAL.nBK;
                    if (iArr == null) {
                        AppMethodBeat.o(34804);
                        return;
                    }
                    while (i < iArr.length) {
                        if (iArr[i] == intValue) {
                            CountryCodeUI.this.nCa.setSelection(i + CountryCodeUI.this.nCa.getHeaderViewsCount());
                            AppMethodBeat.o(34804);
                            return;
                        }
                        i++;
                    }
                    AppMethodBeat.o(34804);
                }
            };
        } else {
            this.zkw = new VerticalScrollBar.a() {
                public final void kp(String str) {
                    int i = 0;
                    AppMethodBeat.i(34803);
                    char charAt = str.charAt(0);
                    if (CountryCodeUI.this.getString(R.string.dz6).equals(str)) {
                        CountryCodeUI.this.nCa.setSelection(0);
                        AppMethodBeat.o(34803);
                        return;
                    }
                    int[] iArr = CountryCodeUI.this.zAL.nBK;
                    if (iArr == null) {
                        AppMethodBeat.o(34803);
                        return;
                    }
                    while (i < iArr.length) {
                        if (iArr[i] == charAt) {
                            CountryCodeUI.this.nCa.setSelection(i + CountryCodeUI.this.nCa.getHeaderViewsCount());
                            AppMethodBeat.o(34803);
                            return;
                        }
                        i++;
                    }
                    AppMethodBeat.o(34803);
                }
            };
        }
        this.zAM.setOnScrollBarTouchListener(this.zkw);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34805);
                CountryCodeUI.this.aqX();
                Intent intent = new Intent();
                intent.putExtra("country_name", CountryCodeUI.this.fHE);
                intent.putExtra("couttry_code", CountryCodeUI.this.countryCode);
                intent.putExtra("iso_code", CountryCodeUI.this.gBE);
                CountryCodeUI.this.setResult(100, intent);
                CountryCodeUI.this.finish();
                AppMethodBeat.o(34805);
                return true;
            }
        });
        this.nCa.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(34806);
                Intent intent = new Intent();
                if (i >= CountryCodeUI.this.nCa.getHeaderViewsCount()) {
                    a aVar = (a) CountryCodeUI.this.zAL.getItem(i - CountryCodeUI.this.nCa.getHeaderViewsCount());
                    intent.putExtra("country_name", aVar.fHE);
                    intent.putExtra("couttry_code", aVar.fHD);
                    intent.putExtra("iso_code", aVar.fHC);
                    CountryCodeUI.this.setResult(100, intent);
                }
                CountryCodeUI.this.finish();
                AppMethodBeat.o(34806);
            }
        });
        AppMethodBeat.o(34811);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(34812);
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("country_name", this.fHE);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("iso_code", this.gBE);
            setResult(100, intent);
            finish();
            AppMethodBeat.o(34812);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(34812);
        return onKeyUp;
    }

    static /* synthetic */ void a(CountryCodeUI countryCodeUI) {
        AppMethodBeat.i(34813);
        if (countryCodeUI.zAL != null) {
            countryCodeUI.zAL.vM(countryCodeUI.gtX);
        }
        AppMethodBeat.o(34813);
    }
}
