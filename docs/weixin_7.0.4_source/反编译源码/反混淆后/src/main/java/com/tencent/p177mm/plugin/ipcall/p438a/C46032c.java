package com.tencent.p177mm.plugin.ipcall.p438a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.ipcall.a.c */
public final class C46032c {
    private static C46032c nvp;
    boolean bZi = false;
    private ArrayList<Integer> nvq = new ArrayList();
    ArrayList<Integer> nvr = new ArrayList();

    private C46032c() {
        AppMethodBeat.m2504i(21716);
        AppMethodBeat.m2505o(21716);
    }

    public static C46032c bHc() {
        AppMethodBeat.m2504i(21717);
        if (nvp == null) {
            nvp = new C46032c();
        }
        C46032c c46032c = nvp;
        AppMethodBeat.m2505o(21717);
        return c46032c;
    }

    /* renamed from: ih */
    public final void mo73924ih(boolean z) {
        Throwable e;
        InputStream inputStream = null;
        AppMethodBeat.m2504i(21718);
        if (!this.bZi || z) {
            bHe();
            try {
                File file = new File(C6457e.eSj + "ipcallCountryCodeConfig.cfg");
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
                                C4990ab.m7411d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", str);
                                m85614OM(str);
                                this.bZi = true;
                                C1173e.m2573p(fileInputStream);
                                AppMethodBeat.m2505o(21718);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = fileInputStream;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                            C4990ab.m7413e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", e.getMessage());
                            C1173e.m2573p(inputStream);
                            AppMethodBeat.m2505o(21718);
                            return;
                        } catch (Throwable th) {
                            e = th;
                            C1173e.m2573p(inputStream);
                            AppMethodBeat.m2505o(21718);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        C1173e.m2573p(inputStream);
                        AppMethodBeat.m2505o(21718);
                        throw e;
                    }
                }
                C4990ab.m7411d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", str);
                this.bZi = true;
                C1173e.m2573p(null);
                AppMethodBeat.m2505o(21718);
                return;
            } catch (Exception e3) {
                e = e3;
                C4990ab.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", e.getMessage());
                C1173e.m2573p(inputStream);
                AppMethodBeat.m2505o(21718);
                return;
            }
        }
        AppMethodBeat.m2505o(21718);
    }

    /* renamed from: OM */
    private void m85614OM(String str) {
        AppMethodBeat.m2504i(21719);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(21719);
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("restriction");
            C4990ab.m7411d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", Integer.valueOf(jSONArray.length()));
            this.nvr.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.nvr.add(Integer.valueOf(jSONArray.getInt(i)));
            }
            AppMethodBeat.m2505o(21719);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", e.getMessage());
            AppMethodBeat.m2505o(21719);
        }
    }

    private void bHd() {
        AppMethodBeat.m2504i(21720);
        this.nvq.clear();
        String value = C26373g.m41964Nu().getValue("WeChatOutTopCountryCode");
        C4990ab.m7411d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", value);
        if (!C5046bo.isNullOrNil(value)) {
            String[] split = value.trim().split(",");
            int length = split.length;
            try {
                for (String str : split) {
                    Integer valueOf = Integer.valueOf(C5046bo.getInt(str, 0));
                    this.nvq.add(valueOf);
                    C21088i.bHy().mo24093O(valueOf.intValue(), (long) length);
                    length--;
                }
                AppMethodBeat.m2505o(21720);
                return;
            } catch (NumberFormatException e) {
                C4990ab.m7413e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(21720);
    }

    private void bHe() {
        AppMethodBeat.m2504i(21721);
        ArrayList bIa = C21088i.bHy().bIa();
        if (bIa.size() > 0) {
            this.nvq = bIa;
            AppMethodBeat.m2505o(21721);
            return;
        }
        bHd();
        AppMethodBeat.m2505o(21721);
    }

    /* renamed from: ON */
    public final void mo73922ON(String str) {
        AppMethodBeat.m2504i(21722);
        if (!this.bZi) {
            mo73924ih(false);
        }
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(21722);
            return;
        }
        C21088i.bHy().mo24093O(C5046bo.getInt(str.replace("+", ""), 0), C5046bo.anU());
        bHe();
        AppMethodBeat.m2505o(21722);
    }

    public final List<Integer> bHf() {
        AppMethodBeat.m2504i(21723);
        if (!this.bZi) {
            mo73924ih(false);
        }
        ArrayList arrayList = this.nvq;
        AppMethodBeat.m2505o(21723);
        return arrayList;
    }

    /* renamed from: xf */
    public final boolean mo73925xf(int i) {
        AppMethodBeat.m2504i(21724);
        if (!this.bZi) {
            mo73924ih(false);
        }
        if (this.nvr == null || this.nvr.size() <= 0) {
            AppMethodBeat.m2505o(21724);
            return false;
        }
        boolean contains = this.nvr.contains(Integer.valueOf(i));
        AppMethodBeat.m2505o(21724);
        return contains;
    }
}
