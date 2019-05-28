package com.tencent.tinker.lib.service;

import com.tencent.ttpic.baseutils.IOUtils;
import java.io.Serializable;

/* renamed from: com.tencent.tinker.lib.service.a */
public final class C46819a implements Serializable {
    public String ABv;
    public String ABw;
    public Throwable Arh;
    public boolean cxT;
    public long iBv;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPatchResult: \n");
        stringBuffer.append("isSuccess:" + this.cxT + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("rawPatchFilePath:" + this.ABv + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("costTime:" + this.iBv + IOUtils.LINE_SEPARATOR_UNIX);
        if (this.ABw != null) {
            stringBuffer.append("patchVersion:" + this.ABw + IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.Arh != null) {
            stringBuffer.append("Throwable:" + this.Arh.getMessage() + IOUtils.LINE_SEPARATOR_UNIX);
        }
        return stringBuffer.toString();
    }
}
