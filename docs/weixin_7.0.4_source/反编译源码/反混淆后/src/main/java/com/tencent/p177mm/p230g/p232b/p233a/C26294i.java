package com.tencent.p177mm.p230g.p232b.p233a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.g.b.a.i */
public final class C26294i extends C46180a {
    public int cVl = 0;
    public int cVm = 0;
    public int cVn = 0;
    private String cVo;
    private String cVp;
    private String cVq;
    private String cVr;
    private String cVs;
    private String cVt;
    private String cVu;
    private String cVv;

    public final int getId() {
        return 15548;
    }

    /* renamed from: ew */
    public final C26294i mo44060ew(String str) {
        AppMethodBeat.m2504i(40561);
        this.cVo = mo74169t("EncryptKey", str, true);
        AppMethodBeat.m2505o(40561);
        return this;
    }

    /* renamed from: ex */
    public final C26294i mo44061ex(String str) {
        AppMethodBeat.m2504i(40562);
        this.cVp = mo74169t("EncryptUserinfo", str, true);
        AppMethodBeat.m2505o(40562);
        return this;
    }

    /* renamed from: ey */
    public final C26294i mo44062ey(String str) {
        AppMethodBeat.m2504i(40563);
        this.cVq = mo74169t("EncryptCellinfoLength", str, true);
        AppMethodBeat.m2505o(40563);
        return this;
    }

    /* renamed from: ez */
    public final C26294i mo44063ez(String str) {
        AppMethodBeat.m2504i(40564);
        this.cVr = mo74169t("EncryptCellinfo_01", str, true);
        AppMethodBeat.m2505o(40564);
        return this;
    }

    /* renamed from: eA */
    public final C26294i mo44056eA(String str) {
        AppMethodBeat.m2504i(40565);
        this.cVs = mo74169t("EncryptCellinfo_02", str, true);
        AppMethodBeat.m2505o(40565);
        return this;
    }

    /* renamed from: eB */
    public final C26294i mo44057eB(String str) {
        AppMethodBeat.m2504i(40566);
        this.cVt = mo74169t("EncryptCellinfo_03", str, true);
        AppMethodBeat.m2505o(40566);
        return this;
    }

    /* renamed from: eC */
    public final C26294i mo44058eC(String str) {
        AppMethodBeat.m2504i(40567);
        this.cVu = mo74169t("EncryptCellinfo_04", str, true);
        AppMethodBeat.m2505o(40567);
        return this;
    }

    /* renamed from: eD */
    public final C26294i mo44059eD(String str) {
        AppMethodBeat.m2504i(40568);
        this.cVv = mo74169t("EncryptCellinfo_05", str, true);
        AppMethodBeat.m2505o(40568);
        return this;
    }

    /* renamed from: Fj */
    public final String mo4982Fj() {
        AppMethodBeat.m2504i(40569);
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cVl);
        stringBuffer.append(str);
        stringBuffer.append(this.cVm);
        stringBuffer.append(str);
        stringBuffer.append(this.cVn);
        stringBuffer.append(str);
        stringBuffer.append(this.cVo);
        stringBuffer.append(str);
        stringBuffer.append(this.cVp);
        stringBuffer.append(str);
        stringBuffer.append(this.cVq);
        stringBuffer.append(str);
        stringBuffer.append(this.cVr);
        stringBuffer.append(str);
        stringBuffer.append(this.cVs);
        stringBuffer.append(str);
        stringBuffer.append(this.cVt);
        stringBuffer.append(str);
        stringBuffer.append(this.cVu);
        stringBuffer.append(str);
        stringBuffer.append(this.cVv);
        str = stringBuffer.toString();
        mo74164VX(str);
        AppMethodBeat.m2505o(40569);
        return str;
    }

    /* renamed from: Fk */
    public final String mo4983Fk() {
        AppMethodBeat.m2504i(40570);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CgiCmd:").append(this.cVl);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ErrType:").append(this.cVm);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("ErrCode:").append(this.cVn);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EncryptKey:").append(this.cVo);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EncryptUserinfo:").append(this.cVp);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EncryptCellinfoLength:").append(this.cVq);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EncryptCellinfo_01:").append(this.cVr);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EncryptCellinfo_02:").append(this.cVs);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EncryptCellinfo_03:").append(this.cVt);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EncryptCellinfo_04:").append(this.cVu);
        stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("EncryptCellinfo_05:").append(this.cVv);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(40570);
        return stringBuffer2;
    }
}
