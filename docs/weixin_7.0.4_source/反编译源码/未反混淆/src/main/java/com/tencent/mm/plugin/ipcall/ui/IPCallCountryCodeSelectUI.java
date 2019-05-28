package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

@a(3)
public class IPCallCountryCodeSelectUI extends MMActivity {
    private String countryCode;
    private o elS;
    private String fHE;
    private String gtX = "";
    private List<a> list;
    public LinearLayout nBB;
    private boolean nBL = false;
    private ListView nCa;
    private f nCb;
    private IPCallCountryCodeScrollbar nCc;
    private IPCallCountryCodeScrollbar.a nCd;
    private boolean nCe = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22118);
        super.onCreate(bundle);
        this.list = new ArrayList();
        this.fHE = bo.bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bo.bc(getIntent().getStringExtra("couttry_code"), "");
        this.nBL = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22111);
                IPCallCountryCodeSelectUI.this.finish();
                AppMethodBeat.o(22111);
                return false;
            }
        });
        initView();
        AppMethodBeat.o(22118);
    }

    public void finish() {
        AppMethodBeat.i(22119);
        super.finish();
        overridePendingTransition(-1, R.anim.ce);
        AppMethodBeat.o(22119);
    }

    public final int getLayoutId() {
        return R.layout.a8k;
    }

    public void onPause() {
        AppMethodBeat.i(22120);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.o(22120);
    }

    public final void initView() {
        int intValue;
        AppMethodBeat.i(22121);
        setMMTitle((int) R.string.ev);
        this.elS = new o((byte) 0);
        this.elS.zHa = new b() {
            public final void vO(String str) {
                AppMethodBeat.i(22112);
                IPCallCountryCodeSelectUI.this.gtX = str;
                IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this);
                AppMethodBeat.o(22112);
            }

            public final void apo() {
                AppMethodBeat.i(22113);
                IPCallCountryCodeSelectUI.this.gtX = "";
                IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this);
                AppMethodBeat.o(22113);
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
        this.nCc = (IPCallCountryCodeScrollbar) findViewById(R.id.n6);
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (Integer intValue2 : c.bHc().bHf()) {
            intValue = intValue2.intValue();
            if (i >= 5) {
                break;
            }
            String Pq = com.tencent.mm.plugin.ipcall.b.a.Pq(String.valueOf(intValue));
            if (bo.isNullOrNil(Pq) || c.bHc().xf(intValue)) {
                intValue = i;
            } else {
                this.list.add(new a(Pq, String.valueOf(intValue), 0, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                intValue = i + 1;
            }
            i = intValue;
        }
        if (i > 0) {
            this.nCe = true;
        }
        com.tencent.mm.plugin.ipcall.b.b bVar;
        String str;
        if (aa.don()) {
            for (Entry entry : com.tencent.mm.plugin.ipcall.b.a.bIM().entrySet()) {
                entry.getKey();
                bVar = (com.tencent.mm.plugin.ipcall.b.b) entry.getValue();
                str = bVar.nHe;
                if (!(str == null || "".equals(str.trim()))) {
                    char[] toCharArray = str.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = toCharArray.length;
                    for (i = 0; i < length; i++) {
                        String r = SpellMap.r(toCharArray[i]);
                        if (bo.isNullOrNil(r)) {
                            stringBuffer.append(toCharArray[i]);
                        } else {
                            stringBuffer.append(r);
                        }
                    }
                    str = stringBuffer.toString();
                }
                str = str.toUpperCase();
                if (bo.isNullOrNil(str)) {
                    str = " ";
                }
                if (!c.bHc().xf(bo.getInt(bVar.nHd, 0))) {
                    this.list.add(new a(bVar.nHe, bVar.nHd, str.charAt(0), str));
                }
            }
        } else {
            for (Entry entry2 : com.tencent.mm.plugin.ipcall.b.a.bIM().entrySet()) {
                entry2.getKey();
                bVar = (com.tencent.mm.plugin.ipcall.b.b) entry2.getValue();
                str = bVar.nHe.toUpperCase();
                if (bo.isNullOrNil(str)) {
                    str = " ";
                }
                if (!c.bHc().xf(bo.getInt(bVar.nHd, 0))) {
                    this.list.add(new a(bVar.nHe, bVar.nHd, str.charAt(0), str));
                }
            }
        }
        Collections.sort(this.list, new Comparator<a>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(22117);
                int compareTo = ((a) obj).fHF.compareTo(((a) obj2).fHF);
                AppMethodBeat.o(22117);
                return compareTo;
            }
        });
        for (a bIc : this.list) {
            intValue = bIc.bIc();
            if (intValue != 0) {
                this.nCc.Pf(String.valueOf((char) intValue));
            }
        }
        ab.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.nBB = (LinearLayout) findViewById(R.id.cjf);
        this.nCa = (ListView) findViewById(R.id.n3);
        this.nCb = new f(this, this.list);
        this.nCb.nBL = this.nBL;
        this.nCb.nBM = this.nCe;
        this.nCa.setAdapter(this.nCb);
        this.nCa.setVisibility(0);
        this.nCd = new IPCallCountryCodeScrollbar.a() {
            public final void kp(String str) {
                int i = 0;
                AppMethodBeat.i(22114);
                char charAt = str.charAt(0);
                if ("↑".equals(str)) {
                    IPCallCountryCodeSelectUI.this.nCa.setSelection(0);
                    AppMethodBeat.o(22114);
                    return;
                }
                int[] iArr = IPCallCountryCodeSelectUI.this.nCb.nBK;
                if (iArr == null) {
                    AppMethodBeat.o(22114);
                    return;
                }
                while (i < iArr.length) {
                    if (iArr[i] == charAt) {
                        IPCallCountryCodeSelectUI.this.nCa.setSelection(i + IPCallCountryCodeSelectUI.this.nCa.getHeaderViewsCount());
                        AppMethodBeat.o(22114);
                        return;
                    }
                    i++;
                }
                AppMethodBeat.o(22114);
            }
        };
        this.nCc.setOnScrollBarTouchListener(this.nCd);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22115);
                IPCallCountryCodeSelectUI.this.aqX();
                Intent intent = new Intent();
                intent.putExtra("country_name", IPCallCountryCodeSelectUI.this.fHE);
                intent.putExtra("couttry_code", IPCallCountryCodeSelectUI.this.countryCode);
                IPCallCountryCodeSelectUI.this.setResult(100, intent);
                IPCallCountryCodeSelectUI.this.finish();
                AppMethodBeat.o(22115);
                return true;
            }
        });
        this.nCa.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(22116);
                Intent intent = new Intent();
                if (i >= IPCallCountryCodeSelectUI.this.nCa.getHeaderViewsCount()) {
                    a aVar = (a) IPCallCountryCodeSelectUI.this.nCb.getItem(i - IPCallCountryCodeSelectUI.this.nCa.getHeaderViewsCount());
                    intent.putExtra("country_name", aVar.fHE);
                    intent.putExtra("couttry_code", aVar.countryCode);
                    IPCallCountryCodeSelectUI.this.setResult(100, intent);
                }
                IPCallCountryCodeSelectUI.this.finish();
                AppMethodBeat.o(22116);
            }
        });
        AppMethodBeat.o(22121);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(22122);
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("country_name", this.fHE);
            intent.putExtra("couttry_code", this.countryCode);
            setResult(100, intent);
            finish();
            AppMethodBeat.o(22122);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(22122);
        return onKeyDown;
    }

    static /* synthetic */ void a(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        AppMethodBeat.i(22123);
        if (iPCallCountryCodeSelectUI.nCb != null) {
            iPCallCountryCodeSelectUI.nCb.vM(iPCallCountryCodeSelectUI.gtX);
        }
        AppMethodBeat.o(22123);
    }
}
