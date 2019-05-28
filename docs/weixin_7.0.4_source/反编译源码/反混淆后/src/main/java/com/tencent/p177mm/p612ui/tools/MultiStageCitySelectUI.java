package com.tencent.p177mm.p612ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelsimple.C32825j;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceCategory;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.p612ui.tools.ZoneSelectOtherCountryPreference.C15943a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.p177mm.storage.RegionCodeDecoder.Region;
import com.tencent.p177mm.vfs.C5730e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.tools.MultiStageCitySelectUI */
public class MultiStageCitySelectUI extends MMPreference implements C1202f {
    private static List<Region> zGy;
    private int cGC = 0;
    private String countryCode = null;
    private String eUt = null;
    private C42206a ecy = new C55671();
    private C15541f ehK;
    private C5601o elS = new C5601o((byte) 0);
    private String fHE = null;
    private String fno = null;
    private String fnp = null;
    private C26443d fwu;
    private boolean gwZ = true;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private boolean nPX;
    private Runnable zGA = new C363354();
    private String zGo = null;
    private boolean zGp = false;
    private int zGq = -1;
    private Region[] zGr;
    private boolean zGs = false;
    private boolean zGt = true;
    private boolean zGu = true;
    private boolean zGv = false;
    private boolean zGw = false;
    private ZoneRecommandPreference zGx;
    private String zGz;

    /* renamed from: com.tencent.mm.ui.tools.MultiStageCitySelectUI$1 */
    class C55671 implements C42206a {

        /* renamed from: com.tencent.mm.ui.tools.MultiStageCitySelectUI$1$1 */
        class C55681 implements OnClickListener {
            C55681() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34890);
                C26443d.m42103bX(MultiStageCitySelectUI.this);
                AppMethodBeat.m2505o(34890);
            }
        }

        C55671() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(34891);
            if (MultiStageCitySelectUI.this.fwu == null) {
                AppMethodBeat.m2505o(34891);
                return false;
            }
            if (z) {
                C4990ab.m7417i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
                C9638aw.m17182Rg().mo14541a(new C32825j((double) f2, (double) f), 0);
            } else {
                MultiStageCitySelectUI.m59803b(MultiStageCitySelectUI.this);
                if (!(MultiStageCitySelectUI.this.nPX || C26443d.agA())) {
                    MultiStageCitySelectUI.this.nPX = true;
                    C30379h.m48445a(MultiStageCitySelectUI.this, MultiStageCitySelectUI.this.getString(C25738R.string.c9z), MultiStageCitySelectUI.this.getString(C25738R.string.f9238tz), MultiStageCitySelectUI.this.getString(C25738R.string.ckr), MultiStageCitySelectUI.this.getString(C25738R.string.f9076or), false, new C55681(), null);
                }
            }
            if (MultiStageCitySelectUI.this.fwu != null) {
                MultiStageCitySelectUI.this.fwu.mo44208c(MultiStageCitySelectUI.this.ecy);
                MultiStageCitySelectUI.this.fwu = null;
            }
            AppMethodBeat.m2505o(34891);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MultiStageCitySelectUI$2 */
    class C363332 implements C15943a {
        C363332() {
        }

        public final void onClick() {
            AppMethodBeat.m2504i(34892);
            Intent intent = new Intent(MultiStageCitySelectUI.this, MultiStageCitySelectUI.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("GetAddress", MultiStageCitySelectUI.this.zGs);
            bundle.putBoolean("ShowSelectedLocation", MultiStageCitySelectUI.this.zGu);
            bundle.putBoolean("IsSelectNonChinaCountry", true);
            bundle.putBoolean("IsAutoPosition", false);
            bundle.putBoolean("IsNeedShowSearchBar", true);
            intent.putExtras(bundle);
            MultiStageCitySelectUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(34892);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MultiStageCitySelectUI$3 */
    class C363343 implements C5600b {
        C363343() {
        }

        public final void app() {
        }

        public final void apo() {
            AppMethodBeat.m2504i(34893);
            MultiStageCitySelectUI.this.aqX();
            MultiStageCitySelectUI.m59810i(MultiStageCitySelectUI.this);
            MultiStageCitySelectUI.this.ash();
            AppMethodBeat.m2505o(34893);
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(34894);
            if (!C5046bo.isNullOrNil(str)) {
                MultiStageCitySelectUI.this.zGz = str;
                MultiStageCitySelectUI.this.ehK.removeAll();
                MultiStageCitySelectUI.this.handler.removeCallbacks(MultiStageCitySelectUI.this.zGA);
                MultiStageCitySelectUI.this.handler.postDelayed(MultiStageCitySelectUI.this.zGA, 50);
            }
            AppMethodBeat.m2505o(34894);
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            AppMethodBeat.m2504i(34895);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(34895);
                return false;
            }
            MultiStageCitySelectUI.this.zGz = str;
            MultiStageCitySelectUI.this.ehK.removeAll();
            MultiStageCitySelectUI.this.handler.removeCallbacks(MultiStageCitySelectUI.this.zGA);
            MultiStageCitySelectUI.this.handler.postDelayed(MultiStageCitySelectUI.this.zGA, 50);
            AppMethodBeat.m2505o(34895);
            return true;
        }

        public final void apq() {
            AppMethodBeat.m2504i(34896);
            MultiStageCitySelectUI.m59810i(MultiStageCitySelectUI.this);
            MultiStageCitySelectUI.this.ash();
            AppMethodBeat.m2505o(34896);
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MultiStageCitySelectUI$4 */
    class C363354 implements Runnable {
        C363354() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34897);
            MultiStageCitySelectUI.m59814m(MultiStageCitySelectUI.this);
            AppMethodBeat.m2505o(34897);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MultiStageCitySelectUI$5 */
    class C363365 implements OnMenuItemClickListener {
        C363365() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34898);
            MultiStageCitySelectUI.m59815n(MultiStageCitySelectUI.this);
            MultiStageCitySelectUI.this.finish();
            AppMethodBeat.m2505o(34898);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MultiStageCitySelectUI() {
        AppMethodBeat.m2504i(34899);
        AppMethodBeat.m2505o(34899);
    }

    /* renamed from: b */
    static /* synthetic */ void m59803b(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.m2504i(34912);
        multiStageCitySelectUI.dJQ();
        AppMethodBeat.m2505o(34912);
    }

    /* renamed from: n */
    static /* synthetic */ void m59815n(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.m2504i(34914);
        multiStageCitySelectUI.dJO();
        AppMethodBeat.m2505o(34914);
    }

    private void dJO() {
        switch (this.cGC) {
            case 0:
                this.countryCode = null;
                return;
            case 1:
                this.fnp = null;
                return;
            case 2:
                this.fno = null;
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0153 A:{SYNTHETIC, Splitter:B:68:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0158 A:{SYNTHETIC, Splitter:B:71:0x0158} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015d A:{SYNTHETIC, Splitter:B:74:0x015d} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013d A:{SYNTHETIC, Splitter:B:56:0x013d} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142 A:{SYNTHETIC, Splitter:B:59:0x0142} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0147 A:{SYNTHETIC, Splitter:B:62:0x0147} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0153 A:{SYNTHETIC, Splitter:B:68:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0158 A:{SYNTHETIC, Splitter:B:71:0x0158} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015d A:{SYNTHETIC, Splitter:B:74:0x015d} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013d A:{SYNTHETIC, Splitter:B:56:0x013d} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142 A:{SYNTHETIC, Splitter:B:59:0x0142} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0147 A:{SYNTHETIC, Splitter:B:62:0x0147} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0153 A:{SYNTHETIC, Splitter:B:68:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0158 A:{SYNTHETIC, Splitter:B:71:0x0158} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015d A:{SYNTHETIC, Splitter:B:74:0x015d} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0153 A:{SYNTHETIC, Splitter:B:68:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0158 A:{SYNTHETIC, Splitter:B:71:0x0158} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015d A:{SYNTHETIC, Splitter:B:74:0x015d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static List<Region> dJP() {
        String str;
        InputStreamReader inputStreamReader;
        Exception e;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        AppMethodBeat.m2504i(34901);
        RegionCodeDecoder duj = RegionCodeDecoder.duj();
        duj.xZT = C4988aa.dor();
        String duk = duj.duk();
        if (C5046bo.isNullOrNil(duk)) {
            C4990ab.m7412e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + duj.xZT);
            str = null;
        } else {
            str = RegionCodeDecoder.xZS + duk;
        }
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(34901);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        InputStream openRead;
        try {
            openRead = C5730e.openRead(str);
            try {
                inputStreamReader = new InputStreamReader(openRead);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                inputStreamReader = null;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", e.getMessage());
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.m2505o(34901);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (openRead != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    AppMethodBeat.m2505o(34901);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = null;
                inputStreamReader = null;
                if (openRead != null) {
                }
                if (inputStreamReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.m2505o(34901);
                throw th;
            }
            try {
                bufferedReader2 = new BufferedReader(inputStreamReader);
                Region region = null;
                Region region2 = null;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        Region region3;
                        String[] split = readLine.split("\\|");
                        Region region4 = new Region();
                        if (split.length == 2) {
                            region4.setName(split[1]);
                            split = split[0].split("_");
                            String str2 = split[0];
                            region4.setCountryCode(str2);
                            if (!C5046bo.isNullOrNil(str2)) {
                                if (split.length == 1) {
                                    region4.setCode(str2);
                                    region4.setProvince(false);
                                    region4.setCity(false);
                                    region4.setCountry(true);
                                    region = region4;
                                    region3 = region2;
                                } else if (split.length == 2) {
                                    region4.setCode(split[1]);
                                    region4.setProvince(true);
                                    region4.setCountry(false);
                                    region4.setCity(false);
                                    if (region != null && region.getCountryCode().equals(region4.getCountryCode())) {
                                        region.setHasChildren(true);
                                        region4.setParent(region);
                                    }
                                    region3 = region4;
                                } else {
                                    if (split.length == 3) {
                                        region4.setCode(split[2]);
                                        region4.setCity(true);
                                        region4.setCountry(false);
                                        region4.setProvince(false);
                                        region4.setHasChildren(false);
                                        if (region2 != null && region2.getCode().equals(split[1])) {
                                            region4.setParent(region2);
                                            region2.setHasChildren(true);
                                        }
                                    }
                                    region3 = region2;
                                }
                                arrayList.add(region4);
                            }
                        } else {
                            region3 = region2;
                        }
                        region2 = region3;
                    } catch (Exception e6) {
                        e = e6;
                        bufferedReader = bufferedReader2;
                        C4990ab.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", e.getMessage());
                        if (openRead != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.m2505o(34901);
                        return arrayList;
                    } catch (Throwable th4) {
                        th = th4;
                        if (openRead != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        AppMethodBeat.m2505o(34901);
                        throw th;
                    }
                }
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e7) {
                    }
                }
                try {
                    inputStreamReader.close();
                } catch (IOException e8) {
                }
                try {
                    bufferedReader2.close();
                } catch (IOException e9) {
                }
            } catch (Exception e10) {
                e = e10;
                bufferedReader = null;
                C4990ab.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", e.getMessage());
                if (openRead != null) {
                }
                if (inputStreamReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(34901);
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader2 = null;
                if (openRead != null) {
                }
                if (inputStreamReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.m2505o(34901);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            bufferedReader = null;
            inputStreamReader = null;
            openRead = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader2 = null;
            inputStreamReader = null;
            openRead = null;
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e12) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e13) {
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e14) {
                }
            }
            AppMethodBeat.m2505o(34901);
            throw th;
        }
        AppMethodBeat.m2505o(34901);
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34902);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a(665, (C1202f) this);
        this.ehK = this.yCw;
        initView();
        if (this.zGw) {
            if (zGy == null || zGy.size() <= 0) {
                long yz = C5046bo.m7588yz();
                Region[] dul = RegionCodeDecoder.duj().dul();
                if (dul != null && dul.length > 0 && (zGy == null || zGy.size() <= 0)) {
                    List dJP = MultiStageCitySelectUI.dJP();
                    zGy = dJP;
                    if (dJP != null) {
                        C4990ab.m7417i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", Long.valueOf(C5046bo.m7525az(yz)), Integer.valueOf(zGy.size()));
                    }
                }
            }
            mo17380a(this.elS);
            this.elS.zHa = new C363343();
        }
        AppMethodBeat.m2505o(34902);
    }

    public void onResume() {
        AppMethodBeat.m2504i(34903);
        super.onResume();
        if (this.gwZ) {
            C4990ab.m7417i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
            if (C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                if (this.fwu == null) {
                    this.fwu = C26443d.agz();
                }
                this.fwu.mo44204a(this.ecy, true);
            }
        }
        AppMethodBeat.m2505o(34903);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34904);
        C9638aw.m17182Rg().mo14546b(665, (C1202f) this);
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(34904);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return 2130971253;
    }

    public final void initView() {
        AppMethodBeat.m2504i(34905);
        setMMTitle((int) C25738R.string.d4h);
        setBackBtn(new C363365());
        this.zGs = getIntent().getBooleanExtra("GetAddress", false);
        this.countryCode = getIntent().getStringExtra("Country");
        this.fnp = getIntent().getStringExtra("Provice");
        this.fHE = getIntent().getStringExtra("CountryName");
        this.zGo = getIntent().getStringExtra("ProviceName");
        this.zGt = getIntent().getBooleanExtra("IsAutoPosition", !C5046bo.m7558gT(this));
        this.zGp = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
        this.zGv = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
        this.zGw = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
        C4990ab.m7416i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.fnp + " city = " + this.fno + " " + this.fHE + " " + this.zGo + " " + this.zGp + " " + this.zGv);
        if (this.zGp) {
            this.cGC = 3;
        } else if (this.countryCode == null) {
            this.cGC = 0;
            this.fnp = null;
            this.fno = null;
        } else if (this.fnp == null) {
            this.cGC = 1;
            this.fno = null;
        } else {
            this.cGC = 2;
        }
        ash();
        AppMethodBeat.m2505o(34905);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        String str = null;
        AppMethodBeat.m2504i(34906);
        String countryCode;
        if (preference instanceof ZonePreference) {
            Region region = ((ZonePreference) preference).zIi;
            if (region == null || C5046bo.isNullOrNil(region.getCode())) {
                C4990ab.m7412e("MicroMsg.MultiStageCitySelectUI", "onPreferenceTreeClick error item, code:" + (region == null ? Integer.valueOf(-1) : region.getCode()) + " ,name:" + (region == null ? BuildConfig.COMMAND : region.getName()));
                AppMethodBeat.m2505o(34906);
                return false;
            }
            if (this.cGC == 3) {
                this.countryCode = "CN";
                this.fnp = region.getCode();
                this.zGo = region.getName();
            }
            if (this.cGC == 0) {
                this.countryCode = region.getCode();
                this.fHE = region.getName();
            } else if (this.cGC == 1) {
                this.fnp = region.getCode();
                this.zGo = region.getName();
            } else if (this.cGC == 2) {
                this.fno = region.getCode();
                this.eUt = region.getName();
                if ("CN".equalsIgnoreCase(this.countryCode) || "HK".equalsIgnoreCase(this.countryCode) || "MO".equalsIgnoreCase(this.countryCode) || "TW".equalsIgnoreCase(this.countryCode)) {
                    this.fHE = null;
                } else {
                    this.zGo = null;
                }
            } else if (this.cGC == 4) {
                if (region.getParent() != null && !region.hasChildren()) {
                    this.fno = region.getCode();
                    this.eUt = region.getName();
                    this.fnp = region.getParent().getCode();
                    this.zGo = region.getParent().getName();
                    this.countryCode = region.getCountryCode();
                    this.fHE = null;
                } else if (!region.hasChildren() || region.getParent() == null) {
                    this.countryCode = region.getCode();
                    this.fHE = region.getName();
                    this.fnp = null;
                    this.zGo = null;
                    this.fno = null;
                    this.eUt = null;
                } else {
                    this.fnp = region.getCode();
                    this.zGo = region.getName();
                    this.countryCode = region.getCountryCode();
                    this.fHE = null;
                }
            }
            if (region.hasChildren()) {
                Intent intent = new Intent(this, MultiStageCitySelectUI.class);
                Bundle bundle = new Bundle();
                bundle.putString("Country", this.countryCode);
                bundle.putString("Provice", this.fnp);
                bundle.putString("CountryName", this.fHE);
                bundle.putString("ProviceName", this.zGo);
                bundle.putBoolean("GetAddress", this.zGs);
                bundle.putBoolean("ShowSelectedLocation", this.zGu);
                if (this.zGp) {
                    countryCode = region.getCountryCode();
                    if (C5046bo.isNullOrNil(countryCode)) {
                        countryCode = this.countryCode;
                    }
                    if ("CN".equalsIgnoreCase(countryCode) || "HK".equalsIgnoreCase(countryCode) || "MO".equalsIgnoreCase(countryCode) || "TW".equalsIgnoreCase(countryCode)) {
                        bundle.putBoolean("IsNeedShowSearchBar", true);
                    }
                }
                intent.putExtras(bundle);
                aqX();
                startActivityForResult(intent, 1);
            } else {
                if (!this.zGs) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(12324, this.countryCode);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(12325, this.fnp);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(12326, this.fno);
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CountryName", this.fHE);
                intent2.putExtra("ProviceName", this.zGo);
                intent2.putExtra("CityName", this.eUt);
                intent2.putExtra("Country", this.countryCode);
                intent2.putExtra("Contact_Province", this.fnp);
                intent2.putExtra("Contact_City", this.fno);
                aqX();
                setResult(-1, intent2);
                finish();
            }
            AppMethodBeat.m2505o(34906);
            return true;
        }
        if (preference.mKey.equals("current_location")) {
            boolean z;
            if (this.zGx.status == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ZoneRecommandPreference zoneRecommandPreference = this.zGx;
                Region[] regionArr = new Region[]{zoneRecommandPreference.zIl, zoneRecommandPreference.zIm, zoneRecommandPreference.zIn};
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(12324, regionArr[0] == null ? null : regionArr[0].getCode());
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(12325, regionArr[1] == null ? null : regionArr[1].getCode());
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(12326, regionArr[2] == null ? null : regionArr[2].getCode());
                countryCode = regionArr[0] == null ? null : regionArr[0].getCode();
                String name = regionArr[0] == null ? null : regionArr[0].getName();
                String code = regionArr[1] == null ? null : regionArr[1].getCode();
                String name2 = regionArr[1] == null ? null : regionArr[1].getName();
                if ("CN".equalsIgnoreCase(countryCode) || "HK".equalsIgnoreCase(countryCode) || "MO".equalsIgnoreCase(countryCode) || "TW".equalsIgnoreCase(countryCode)) {
                    name = null;
                } else {
                    name2 = null;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CountryName", name);
                intent3.putExtra("ProviceName", name2);
                intent3.putExtra("CityName", regionArr[2] == null ? null : regionArr[2].getName());
                intent3.putExtra("Country", countryCode);
                intent3.putExtra("Contact_Province", code);
                countryCode = "Contact_City";
                if (regionArr[2] != null) {
                    str = regionArr[2].getCode();
                }
                intent3.putExtra(countryCode, str);
                aqX();
                setResult(-1, intent3);
                finish();
            }
        }
        AppMethodBeat.m2505o(34906);
        return false;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(34907);
        dJO();
        super.onBackPressed();
        AppMethodBeat.m2505o(34907);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(34908);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(34908);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(34909);
        if (i != 0 || i2 != 0) {
            dJQ();
        } else if (c1207m.getType() == 665) {
            Region region;
            Region region2;
            C32825j c32825j = (C32825j) c1207m;
            C4990ab.m7417i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", c32825j.country, c32825j.duc, c32825j.dud);
            for (Region region3 : RegionCodeDecoder.duj().dul()) {
                if (region3.getCode().equalsIgnoreCase(r2)) {
                    for (Region region4 : RegionCodeDecoder.duj().apS(region3.getCode())) {
                        if (region4.getCode().equalsIgnoreCase(r6)) {
                            for (Region region22 : RegionCodeDecoder.duj().mo10524ie(region3.getCode(), region4.getCode())) {
                                if (region22.getCode().equalsIgnoreCase(r7)) {
                                    break;
                                }
                            }
                            region22 = null;
                            if (region3 != null && region4 == null && region22 == null) {
                                if (this.zGx != null) {
                                    this.zGx.dKc();
                                    AppMethodBeat.m2505o(34909);
                                    return;
                                }
                            } else if (this.zGx != null) {
                                ZoneRecommandPreference zoneRecommandPreference = this.zGx;
                                zoneRecommandPreference.status = 1;
                                zoneRecommandPreference.zIl = region3;
                                zoneRecommandPreference.zIm = region4;
                                zoneRecommandPreference.zIn = region22;
                                zoneRecommandPreference.dKb();
                            }
                            AppMethodBeat.m2505o(34909);
                            return;
                        }
                    }
                    region22 = null;
                    region4 = null;
                    if (region3 != null) {
                    }
                    if (this.zGx != null) {
                    }
                    AppMethodBeat.m2505o(34909);
                    return;
                }
            }
            region22 = null;
            region4 = null;
            Region region32 = null;
            if (region32 != null) {
            }
            if (this.zGx != null) {
            }
            AppMethodBeat.m2505o(34909);
            return;
        }
        AppMethodBeat.m2505o(34909);
    }

    private void dJQ() {
        AppMethodBeat.m2504i(34910);
        if (this.zGx != null) {
            this.zGx.dKc();
        }
        AppMethodBeat.m2505o(34910);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(34911);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(34911);
            return;
        }
        C4990ab.m7417i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        if (iArr.length == 0) {
            AppMethodBeat.m2505o(34911);
            return;
        }
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    if (this.zGx != null) {
                        this.zGx.dKc();
                    }
                    this.gwZ = false;
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(34911);
    }

    public final void ash() {
        Region[] apS;
        int i;
        AppMethodBeat.m2504i(34900);
        if (this.cGC == 3) {
            apS = RegionCodeDecoder.duj().apS("CN");
        } else if (C5046bo.isNullOrNil(this.countryCode)) {
            apS = RegionCodeDecoder.duj().dul();
            if (this.zGv) {
                ArrayList arrayList = new ArrayList();
                if (apS != null) {
                    for (Region region : apS) {
                        if (!("CN".equalsIgnoreCase(region.getCode()) || "HK".equalsIgnoreCase(region.getCode()) || "TW".equalsIgnoreCase(region.getCode()) || "MO".equalsIgnoreCase(region.getCode()))) {
                            arrayList.add(region);
                        }
                    }
                }
                apS = new Region[arrayList.size()];
                arrayList.toArray(apS);
            }
        } else if (C5046bo.isNullOrNil(this.fnp)) {
            apS = RegionCodeDecoder.duj().apS(this.countryCode);
        } else {
            apS = RegionCodeDecoder.duj().mo10524ie(this.countryCode, this.fnp);
        }
        this.zGr = apS;
        if (this.zGr == null || this.zGr.length <= 0) {
            C4990ab.m7412e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
            AppMethodBeat.m2505o(34900);
            return;
        }
        this.ehK.removeAll();
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(12324, null);
        C9638aw.m17190ZK();
        String str2 = (String) C18628c.m29072Ry().get(12325, null);
        C9638aw.m17190ZK();
        String str3 = (String) C18628c.m29072Ry().get(12326, null);
        this.zGu = getIntent().getBooleanExtra("ShowSelectedLocation", true);
        i = 0;
        while (i < this.zGr.length) {
            if (!(this.zGr[i] == null || C5046bo.isNullOrNil(this.zGr[i].getCode()) || C5046bo.isNullOrNil(this.zGr[i].getName()))) {
                ZonePreference zonePreference = new ZonePreference(this);
                zonePreference.mo11311a(this.zGr[i]);
                if (!this.zGu) {
                    this.ehK.mo27713b(zonePreference);
                } else if (this.cGC == 0 && this.zGr[i].getCode().equalsIgnoreCase(str)) {
                    this.ehK.mo27708a(zonePreference, 0);
                    zonePreference.setSummary((int) C25738R.string.e55);
                } else if (this.cGC == 1 && this.zGr[i].getCode().equalsIgnoreCase(str2)) {
                    this.ehK.mo27708a(zonePreference, 0);
                    zonePreference.setSummary((int) C25738R.string.e55);
                } else if (this.cGC == 2 && this.zGr[i].getCode().equalsIgnoreCase(str3)) {
                    this.ehK.mo27708a(zonePreference, 0);
                    zonePreference.setSummary((int) C25738R.string.e55);
                } else {
                    this.ehK.mo27713b(zonePreference);
                }
            }
            i++;
        }
        if (this.cGC == 3) {
            ZoneSelectOtherCountryPreference zoneSelectOtherCountryPreference = new ZoneSelectOtherCountryPreference(this);
            zoneSelectOtherCountryPreference.text = getString(C25738R.string.e51);
            zoneSelectOtherCountryPreference.zIq = new C363332();
            this.ehK.mo27713b(zoneSelectOtherCountryPreference);
        }
        this.ehK.mo27713b(new PreferenceCategory(this.mController.ylL));
        if (this.cGC == 0 || this.cGC == 3) {
            PreferenceTitleCategory preferenceTitleCategory;
            if (this.zGt) {
                preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle((int) C25738R.string.e4z);
                this.ehK.mo27708a(preferenceTitleCategory, 0);
                this.zGx = new ZoneRecommandPreference(this);
                this.zGx.setKey("current_location");
                this.ehK.mo27708a(this.zGx, 1);
            }
            preferenceTitleCategory = new PreferenceTitleCategory(this);
            preferenceTitleCategory.setTitle((int) C25738R.string.e4y);
            if (this.zGt) {
                this.ehK.mo27708a(preferenceTitleCategory, 2);
                AppMethodBeat.m2505o(34900);
                return;
            }
            this.ehK.mo27708a(preferenceTitleCategory, 0);
        }
        AppMethodBeat.m2505o(34900);
    }

    /* renamed from: i */
    static /* synthetic */ void m59810i(MultiStageCitySelectUI multiStageCitySelectUI) {
        if (multiStageCitySelectUI.zGp) {
            multiStageCitySelectUI.cGC = 3;
        } else if (multiStageCitySelectUI.countryCode == null) {
            multiStageCitySelectUI.cGC = 0;
        } else if (multiStageCitySelectUI.fnp == null) {
            multiStageCitySelectUI.cGC = 1;
        } else {
            multiStageCitySelectUI.cGC = 2;
        }
    }

    /* renamed from: m */
    static /* synthetic */ void m59814m(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.m2504i(34913);
        if (!C5046bo.isNullOrNil(multiStageCitySelectUI.zGz)) {
            PreferenceTitleCategory preferenceTitleCategory;
            ArrayList arrayList = new ArrayList();
            ArrayList<Region> arrayList2 = new ArrayList();
            ArrayList<Region> arrayList3 = new ArrayList();
            ArrayList<Region> arrayList4 = new ArrayList();
            for (Region region : zGy) {
                if (region.getName() != null && region.getName().contains(multiStageCitySelectUI.zGz)) {
                    if ("CN".equalsIgnoreCase(region.getCountryCode()) || "HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode()) || ((region.getParent() == null || !region.hasChildren()) && (region.getParent() == null || region.hasChildren()))) {
                        if (region.getParent() == null || !("CN".equalsIgnoreCase(region.getCountryCode()) || "HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode()))) {
                            if (!(region.getParent() == null && ("HK".equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || "TW".equalsIgnoreCase(region.getCountryCode())))) {
                                arrayList2.add(region);
                            }
                        } else if (region.hasChildren() && region.getParent() != null) {
                            arrayList3.add(region);
                        } else if (!(region.hasChildren() || region.getParent() == null)) {
                            arrayList4.add(region);
                        }
                    }
                }
            }
            if (arrayList4.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle((int) C25738R.string.e52);
                multiStageCitySelectUI.ehK.mo27713b(preferenceTitleCategory);
                for (Region region2 : arrayList4) {
                    ZonePreference zonePreference = new ZonePreference(multiStageCitySelectUI);
                    region2.setHasChildren(false);
                    zonePreference.mo11311a(region2);
                    multiStageCitySelectUI.ehK.mo27714c(zonePreference);
                }
            }
            if (arrayList3.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle((int) C25738R.string.e54);
                multiStageCitySelectUI.ehK.mo27713b(preferenceTitleCategory);
                for (Region region22 : arrayList3) {
                    ZonePreference zonePreference2 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference2.mo11311a(region22);
                    multiStageCitySelectUI.ehK.mo27714c(zonePreference2);
                }
            }
            if (arrayList2.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle((int) C25738R.string.e53);
                multiStageCitySelectUI.ehK.mo27713b(preferenceTitleCategory);
                for (Region region222 : arrayList2) {
                    ZonePreference zonePreference3 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference3.mo11311a(region222);
                    multiStageCitySelectUI.ehK.mo27714c(zonePreference3);
                }
            }
            multiStageCitySelectUI.ehK.notifyDataSetChanged();
            multiStageCitySelectUI.zGq = multiStageCitySelectUI.cGC;
            multiStageCitySelectUI.cGC = 4;
        }
        AppMethodBeat.m2505o(34913);
    }
}
