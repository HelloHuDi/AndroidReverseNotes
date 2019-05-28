package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static c nvp;
    boolean bZi = false;
    private ArrayList<Integer> nvq = new ArrayList();
    ArrayList<Integer> nvr = new ArrayList();

    private c() {
        AppMethodBeat.i(21716);
        AppMethodBeat.o(21716);
    }

    public static c bHc() {
        AppMethodBeat.i(21717);
        if (nvp == null) {
            nvp = new c();
        }
        c cVar = nvp;
        AppMethodBeat.o(21717);
        return cVar;
    }

    public final void ih(boolean z) {
        Throwable e;
        InputStream inputStream = null;
        AppMethodBeat.i(21718);
        if (!this.bZi || z) {
            bHe();
            try {
                File file = new File(e.eSj + "ipcallCountryCodeConfig.cfg");
                String str;
                if (file.exists()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        str = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                str = str + readLine;
                            } else {
                                ab.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", str);
                                OM(str);
                                this.bZi = true;
                                com.tencent.mm.a.e.p(fileInputStream);
                                AppMethodBeat.o(21718);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = fileInputStream;
                        try {
                            ab.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                            ab.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", e.getMessage());
                            com.tencent.mm.a.e.p(inputStream);
                            AppMethodBeat.o(21718);
                            return;
                        } catch (Throwable th) {
                            e = th;
                            com.tencent.mm.a.e.p(inputStream);
                            AppMethodBeat.o(21718);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        com.tencent.mm.a.e.p(inputStream);
                        AppMethodBeat.o(21718);
                        throw e;
                    }
                }
                ab.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", str);
                this.bZi = true;
                com.tencent.mm.a.e.p(null);
                AppMethodBeat.o(21718);
                return;
            } catch (Exception e3) {
                e = e3;
                ab.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                ab.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", e.getMessage());
                com.tencent.mm.a.e.p(inputStream);
                AppMethodBeat.o(21718);
                return;
            }
        }
        AppMethodBeat.o(21718);
    }

    private void OM(String str) {
        AppMethodBeat.i(21719);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(21719);
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("restriction");
            ab.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", Integer.valueOf(jSONArray.length()));
            this.nvr.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.nvr.add(Integer.valueOf(jSONArray.getInt(i)));
            }
            AppMethodBeat.o(21719);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
            ab.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", e.getMessage());
            AppMethodBeat.o(21719);
        }
    }

    private void bHd() {
        AppMethodBeat.i(21720);
        this.nvq.clear();
        String value = g.Nu().getValue("WeChatOutTopCountryCode");
        ab.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", value);
        if (!bo.isNullOrNil(value)) {
            String[] split = value.trim().split(",");
            int length = split.length;
            try {
                for (String str : split) {
                    Integer valueOf = Integer.valueOf(bo.getInt(str, 0));
                    this.nvq.add(valueOf);
                    i.bHy().O(valueOf.intValue(), (long) length);
                    length--;
                }
                AppMethodBeat.o(21720);
                return;
            } catch (NumberFormatException e) {
                ab.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(21720);
    }

    private void bHe() {
        AppMethodBeat.i(21721);
        ArrayList bIa = i.bHy().bIa();
        if (bIa.size() > 0) {
            this.nvq = bIa;
            AppMethodBeat.o(21721);
            return;
        }
        bHd();
        AppMethodBeat.o(21721);
    }

    public final void ON(String str) {
        AppMethodBeat.i(21722);
        if (!this.bZi) {
            ih(false);
        }
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(21722);
            return;
        }
        i.bHy().O(bo.getInt(str.replace("+", ""), 0), bo.anU());
        bHe();
        AppMethodBeat.o(21722);
    }

    public final List<Integer> bHf() {
        AppMethodBeat.i(21723);
        if (!this.bZi) {
            ih(false);
        }
        ArrayList arrayList = this.nvq;
        AppMethodBeat.o(21723);
        return arrayList;
    }

    public final boolean xf(int i) {
        AppMethodBeat.i(21724);
        if (!this.bZi) {
            ih(false);
        }
        if (this.nvr == null || this.nvr.size() <= 0) {
            AppMethodBeat.o(21724);
            return false;
        }
        boolean contains = this.nvr.contains(Integer.valueOf(i));
        AppMethodBeat.o(21724);
        return contains;
    }
}
