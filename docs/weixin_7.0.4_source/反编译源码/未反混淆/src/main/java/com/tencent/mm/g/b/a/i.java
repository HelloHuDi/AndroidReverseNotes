package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.ttpic.baseutils.IOUtils;

public final class i extends a {
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

    public final i ew(String str) {
        AppMethodBeat.i(40561);
        this.cVo = t("EncryptKey", str, true);
        AppMethodBeat.o(40561);
        return this;
    }

    public final i ex(String str) {
        AppMethodBeat.i(40562);
        this.cVp = t("EncryptUserinfo", str, true);
        AppMethodBeat.o(40562);
        return this;
    }

    public final i ey(String str) {
        AppMethodBeat.i(40563);
        this.cVq = t("EncryptCellinfoLength", str, true);
        AppMethodBeat.o(40563);
        return this;
    }

    public final i ez(String str) {
        AppMethodBeat.i(40564);
        this.cVr = t("EncryptCellinfo_01", str, true);
        AppMethodBeat.o(40564);
        return this;
    }

    public final i eA(String str) {
        AppMethodBeat.i(40565);
        this.cVs = t("EncryptCellinfo_02", str, true);
        AppMethodBeat.o(40565);
        return this;
    }

    public final i eB(String str) {
        AppMethodBeat.i(40566);
        this.cVt = t("EncryptCellinfo_03", str, true);
        AppMethodBeat.o(40566);
        return this;
    }

    public final i eC(String str) {
        AppMethodBeat.i(40567);
        this.cVu = t("EncryptCellinfo_04", str, true);
        AppMethodBeat.o(40567);
        return this;
    }

    public final i eD(String str) {
        AppMethodBeat.i(40568);
        this.cVv = t("EncryptCellinfo_05", str, true);
        AppMethodBeat.o(40568);
        return this;
    }

    public final String Fj() {
        AppMethodBeat.i(40569);
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
        VX(str);
        AppMethodBeat.o(40569);
        return str;
    }

    public final String Fk() {
        AppMethodBeat.i(40570);
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
        AppMethodBeat.o(40570);
        return stringBuffer2;
    }
}
