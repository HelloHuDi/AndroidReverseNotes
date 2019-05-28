package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.mm.vfs.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MultiStageCitySelectUI extends MMPreference implements f {
    private static List<Region> zGy;
    private int cGC = 0;
    private String countryCode = null;
    private String eUt = null;
    private a ecy = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(34891);
            if (MultiStageCitySelectUI.this.fwu == null) {
                AppMethodBeat.o(34891);
                return false;
            }
            if (z) {
                ab.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
                aw.Rg().a(new j((double) f2, (double) f), 0);
            } else {
                MultiStageCitySelectUI.b(MultiStageCitySelectUI.this);
                if (!(MultiStageCitySelectUI.this.nPX || d.agA())) {
                    MultiStageCitySelectUI.this.nPX = true;
                    h.a(MultiStageCitySelectUI.this, MultiStageCitySelectUI.this.getString(R.string.c9z), MultiStageCitySelectUI.this.getString(R.string.tz), MultiStageCitySelectUI.this.getString(R.string.ckr), MultiStageCitySelectUI.this.getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(34890);
                            d.bX(MultiStageCitySelectUI.this);
                            AppMethodBeat.o(34890);
                        }
                    }, null);
                }
            }
            if (MultiStageCitySelectUI.this.fwu != null) {
                MultiStageCitySelectUI.this.fwu.c(MultiStageCitySelectUI.this.ecy);
                MultiStageCitySelectUI.this.fwu = null;
            }
            AppMethodBeat.o(34891);
            return false;
        }
    };
    private com.tencent.mm.ui.base.preference.f ehK;
    private o elS = new o((byte) 0);
    private String fHE = null;
    private String fno = null;
    private String fnp = null;
    private d fwu;
    private boolean gwZ = true;
    private ak handler = new ak(Looper.getMainLooper());
    private boolean nPX;
    private Runnable zGA = new Runnable() {
        public final void run() {
            AppMethodBeat.i(34897);
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this);
            AppMethodBeat.o(34897);
        }
    };
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MultiStageCitySelectUI() {
        AppMethodBeat.i(34899);
        AppMethodBeat.o(34899);
    }

    static /* synthetic */ void b(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.i(34912);
        multiStageCitySelectUI.dJQ();
        AppMethodBeat.o(34912);
    }

    static /* synthetic */ void n(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.i(34914);
        multiStageCitySelectUI.dJO();
        AppMethodBeat.o(34914);
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
        AppMethodBeat.i(34901);
        RegionCodeDecoder duj = RegionCodeDecoder.duj();
        duj.xZT = aa.dor();
        String duk = duj.duk();
        if (bo.isNullOrNil(duk)) {
            ab.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + duj.xZT);
            str = null;
        } else {
            str = RegionCodeDecoder.xZS + duk;
        }
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(34901);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        InputStream openRead;
        try {
            openRead = e.openRead(str);
            try {
                inputStreamReader = new InputStreamReader(openRead);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                inputStreamReader = null;
                try {
                    ab.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", e.getMessage());
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
                    AppMethodBeat.o(34901);
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
                    AppMethodBeat.o(34901);
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
                AppMethodBeat.o(34901);
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
                            if (!bo.isNullOrNil(str2)) {
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
                        ab.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", e.getMessage());
                        if (openRead != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.o(34901);
                        return arrayList;
                    } catch (Throwable th4) {
                        th = th4;
                        if (openRead != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        AppMethodBeat.o(34901);
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
                ab.printErrStackTrace("MicroMsg.MultiStageCitySelectUI", e, "buildSearchRegionMap error: %s", e.getMessage());
                if (openRead != null) {
                }
                if (inputStreamReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(34901);
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
                AppMethodBeat.o(34901);
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
            AppMethodBeat.o(34901);
            throw th;
        }
        AppMethodBeat.o(34901);
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34902);
        super.onCreate(bundle);
        aw.Rg().a(665, (f) this);
        this.ehK = this.yCw;
        initView();
        if (this.zGw) {
            if (zGy == null || zGy.size() <= 0) {
                long yz = bo.yz();
                Region[] dul = RegionCodeDecoder.duj().dul();
                if (dul != null && dul.length > 0 && (zGy == null || zGy.size() <= 0)) {
                    List dJP = dJP();
                    zGy = dJP;
                    if (dJP != null) {
                        ab.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", Long.valueOf(bo.az(yz)), Integer.valueOf(zGy.size()));
                    }
                }
            }
            a(this.elS);
            this.elS.zHa = new b() {
                public final void app() {
                }

                public final void apo() {
                    AppMethodBeat.i(34893);
                    MultiStageCitySelectUI.this.aqX();
                    MultiStageCitySelectUI.i(MultiStageCitySelectUI.this);
                    MultiStageCitySelectUI.this.ash();
                    AppMethodBeat.o(34893);
                }

                public final void vO(String str) {
                    AppMethodBeat.i(34894);
                    if (!bo.isNullOrNil(str)) {
                        MultiStageCitySelectUI.this.zGz = str;
                        MultiStageCitySelectUI.this.ehK.removeAll();
                        MultiStageCitySelectUI.this.handler.removeCallbacks(MultiStageCitySelectUI.this.zGA);
                        MultiStageCitySelectUI.this.handler.postDelayed(MultiStageCitySelectUI.this.zGA, 50);
                    }
                    AppMethodBeat.o(34894);
                }

                public final boolean vN(String str) {
                    AppMethodBeat.i(34895);
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(34895);
                        return false;
                    }
                    MultiStageCitySelectUI.this.zGz = str;
                    MultiStageCitySelectUI.this.ehK.removeAll();
                    MultiStageCitySelectUI.this.handler.removeCallbacks(MultiStageCitySelectUI.this.zGA);
                    MultiStageCitySelectUI.this.handler.postDelayed(MultiStageCitySelectUI.this.zGA, 50);
                    AppMethodBeat.o(34895);
                    return true;
                }

                public final void apq() {
                    AppMethodBeat.i(34896);
                    MultiStageCitySelectUI.i(MultiStageCitySelectUI.this);
                    MultiStageCitySelectUI.this.ash();
                    AppMethodBeat.o(34896);
                }

                public final void apr() {
                }
            };
        }
        AppMethodBeat.o(34902);
    }

    public void onResume() {
        AppMethodBeat.i(34903);
        super.onResume();
        if (this.gwZ) {
            ab.i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                if (this.fwu == null) {
                    this.fwu = d.agz();
                }
                this.fwu.a(this.ecy, true);
            }
        }
        AppMethodBeat.o(34903);
    }

    public void onDestroy() {
        AppMethodBeat.i(34904);
        aw.Rg().b(665, (f) this);
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        super.onDestroy();
        AppMethodBeat.o(34904);
    }

    public final int JC() {
        return R.layout.b8f;
    }

    public final void initView() {
        AppMethodBeat.i(34905);
        setMMTitle((int) R.string.d4h);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34898);
                MultiStageCitySelectUI.n(MultiStageCitySelectUI.this);
                MultiStageCitySelectUI.this.finish();
                AppMethodBeat.o(34898);
                return true;
            }
        });
        this.zGs = getIntent().getBooleanExtra("GetAddress", false);
        this.countryCode = getIntent().getStringExtra("Country");
        this.fnp = getIntent().getStringExtra("Provice");
        this.fHE = getIntent().getStringExtra("CountryName");
        this.zGo = getIntent().getStringExtra("ProviceName");
        this.zGt = getIntent().getBooleanExtra("IsAutoPosition", !bo.gT(this));
        this.zGp = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
        this.zGv = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
        this.zGw = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
        ab.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.fnp + " city = " + this.fno + " " + this.fHE + " " + this.zGo + " " + this.zGp + " " + this.zGv);
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
        AppMethodBeat.o(34905);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        String str = null;
        AppMethodBeat.i(34906);
        String countryCode;
        if (preference instanceof ZonePreference) {
            Region region = ((ZonePreference) preference).zIi;
            if (region == null || bo.isNullOrNil(region.getCode())) {
                ab.e("MicroMsg.MultiStageCitySelectUI", "onPreferenceTreeClick error item, code:" + (region == null ? Integer.valueOf(-1) : region.getCode()) + " ,name:" + (region == null ? BuildConfig.COMMAND : region.getName()));
                AppMethodBeat.o(34906);
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
                    if (bo.isNullOrNil(countryCode)) {
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
                    aw.ZK();
                    c.Ry().set(12324, this.countryCode);
                    aw.ZK();
                    c.Ry().set(12325, this.fnp);
                    aw.ZK();
                    c.Ry().set(12326, this.fno);
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
            AppMethodBeat.o(34906);
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
                aw.ZK();
                c.Ry().set(12324, regionArr[0] == null ? null : regionArr[0].getCode());
                aw.ZK();
                c.Ry().set(12325, regionArr[1] == null ? null : regionArr[1].getCode());
                aw.ZK();
                c.Ry().set(12326, regionArr[2] == null ? null : regionArr[2].getCode());
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
        AppMethodBeat.o(34906);
        return false;
    }

    public void onBackPressed() {
        AppMethodBeat.i(34907);
        dJO();
        super.onBackPressed();
        AppMethodBeat.o(34907);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(34908);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.o(34908);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(34909);
        if (i != 0 || i2 != 0) {
            dJQ();
        } else if (mVar.getType() == 665) {
            Region region;
            Region region2;
            j jVar = (j) mVar;
            ab.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", jVar.country, jVar.duc, jVar.dud);
            for (Region region3 : RegionCodeDecoder.duj().dul()) {
                if (region3.getCode().equalsIgnoreCase(r2)) {
                    for (Region region4 : RegionCodeDecoder.duj().apS(region3.getCode())) {
                        if (region4.getCode().equalsIgnoreCase(r6)) {
                            for (Region region22 : RegionCodeDecoder.duj().ie(region3.getCode(), region4.getCode())) {
                                if (region22.getCode().equalsIgnoreCase(r7)) {
                                    break;
                                }
                            }
                            region22 = null;
                            if (region3 != null && region4 == null && region22 == null) {
                                if (this.zGx != null) {
                                    this.zGx.dKc();
                                    AppMethodBeat.o(34909);
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
                            AppMethodBeat.o(34909);
                            return;
                        }
                    }
                    region22 = null;
                    region4 = null;
                    if (region3 != null) {
                    }
                    if (this.zGx != null) {
                    }
                    AppMethodBeat.o(34909);
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
            AppMethodBeat.o(34909);
            return;
        }
        AppMethodBeat.o(34909);
    }

    private void dJQ() {
        AppMethodBeat.i(34910);
        if (this.zGx != null) {
            this.zGx.dKc();
        }
        AppMethodBeat.o(34910);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(34911);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(34911);
            return;
        }
        ab.i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        if (iArr.length == 0) {
            AppMethodBeat.o(34911);
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
        AppMethodBeat.o(34911);
    }

    public final void ash() {
        Region[] apS;
        int i;
        AppMethodBeat.i(34900);
        if (this.cGC == 3) {
            apS = RegionCodeDecoder.duj().apS("CN");
        } else if (bo.isNullOrNil(this.countryCode)) {
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
        } else if (bo.isNullOrNil(this.fnp)) {
            apS = RegionCodeDecoder.duj().apS(this.countryCode);
        } else {
            apS = RegionCodeDecoder.duj().ie(this.countryCode, this.fnp);
        }
        this.zGr = apS;
        if (this.zGr == null || this.zGr.length <= 0) {
            ab.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
            AppMethodBeat.o(34900);
            return;
        }
        this.ehK.removeAll();
        aw.ZK();
        String str = (String) c.Ry().get(12324, null);
        aw.ZK();
        String str2 = (String) c.Ry().get(12325, null);
        aw.ZK();
        String str3 = (String) c.Ry().get(12326, null);
        this.zGu = getIntent().getBooleanExtra("ShowSelectedLocation", true);
        i = 0;
        while (i < this.zGr.length) {
            if (!(this.zGr[i] == null || bo.isNullOrNil(this.zGr[i].getCode()) || bo.isNullOrNil(this.zGr[i].getName()))) {
                ZonePreference zonePreference = new ZonePreference(this);
                zonePreference.a(this.zGr[i]);
                if (!this.zGu) {
                    this.ehK.b(zonePreference);
                } else if (this.cGC == 0 && this.zGr[i].getCode().equalsIgnoreCase(str)) {
                    this.ehK.a(zonePreference, 0);
                    zonePreference.setSummary((int) R.string.e55);
                } else if (this.cGC == 1 && this.zGr[i].getCode().equalsIgnoreCase(str2)) {
                    this.ehK.a(zonePreference, 0);
                    zonePreference.setSummary((int) R.string.e55);
                } else if (this.cGC == 2 && this.zGr[i].getCode().equalsIgnoreCase(str3)) {
                    this.ehK.a(zonePreference, 0);
                    zonePreference.setSummary((int) R.string.e55);
                } else {
                    this.ehK.b(zonePreference);
                }
            }
            i++;
        }
        if (this.cGC == 3) {
            ZoneSelectOtherCountryPreference zoneSelectOtherCountryPreference = new ZoneSelectOtherCountryPreference(this);
            zoneSelectOtherCountryPreference.text = getString(R.string.e51);
            zoneSelectOtherCountryPreference.zIq = new ZoneSelectOtherCountryPreference.a() {
                public final void onClick() {
                    AppMethodBeat.i(34892);
                    Intent intent = new Intent(MultiStageCitySelectUI.this, MultiStageCitySelectUI.class);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("GetAddress", MultiStageCitySelectUI.this.zGs);
                    bundle.putBoolean("ShowSelectedLocation", MultiStageCitySelectUI.this.zGu);
                    bundle.putBoolean("IsSelectNonChinaCountry", true);
                    bundle.putBoolean("IsAutoPosition", false);
                    bundle.putBoolean("IsNeedShowSearchBar", true);
                    intent.putExtras(bundle);
                    MultiStageCitySelectUI.this.startActivityForResult(intent, 1);
                    AppMethodBeat.o(34892);
                }
            };
            this.ehK.b(zoneSelectOtherCountryPreference);
        }
        this.ehK.b(new PreferenceCategory(this.mController.ylL));
        if (this.cGC == 0 || this.cGC == 3) {
            PreferenceTitleCategory preferenceTitleCategory;
            if (this.zGt) {
                preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle((int) R.string.e4z);
                this.ehK.a(preferenceTitleCategory, 0);
                this.zGx = new ZoneRecommandPreference(this);
                this.zGx.setKey("current_location");
                this.ehK.a(this.zGx, 1);
            }
            preferenceTitleCategory = new PreferenceTitleCategory(this);
            preferenceTitleCategory.setTitle((int) R.string.e4y);
            if (this.zGt) {
                this.ehK.a(preferenceTitleCategory, 2);
                AppMethodBeat.o(34900);
                return;
            }
            this.ehK.a(preferenceTitleCategory, 0);
        }
        AppMethodBeat.o(34900);
    }

    static /* synthetic */ void i(MultiStageCitySelectUI multiStageCitySelectUI) {
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

    static /* synthetic */ void m(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.i(34913);
        if (!bo.isNullOrNil(multiStageCitySelectUI.zGz)) {
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
                preferenceTitleCategory.setTitle((int) R.string.e52);
                multiStageCitySelectUI.ehK.b(preferenceTitleCategory);
                for (Region region2 : arrayList4) {
                    ZonePreference zonePreference = new ZonePreference(multiStageCitySelectUI);
                    region2.setHasChildren(false);
                    zonePreference.a(region2);
                    multiStageCitySelectUI.ehK.c(zonePreference);
                }
            }
            if (arrayList3.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle((int) R.string.e54);
                multiStageCitySelectUI.ehK.b(preferenceTitleCategory);
                for (Region region22 : arrayList3) {
                    ZonePreference zonePreference2 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference2.a(region22);
                    multiStageCitySelectUI.ehK.c(zonePreference2);
                }
            }
            if (arrayList2.size() > 0) {
                preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle((int) R.string.e53);
                multiStageCitySelectUI.ehK.b(preferenceTitleCategory);
                for (Region region222 : arrayList2) {
                    ZonePreference zonePreference3 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference3.a(region222);
                    multiStageCitySelectUI.ehK.c(zonePreference3);
                }
            }
            multiStageCitySelectUI.ehK.notifyDataSetChanged();
            multiStageCitySelectUI.zGq = multiStageCitySelectUI.cGC;
            multiStageCitySelectUI.cGC = 4;
        }
        AppMethodBeat.o(34913);
    }
}
