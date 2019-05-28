package com.tencent.p177mm.p235i;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.i.h */
public final class C44686h extends C42130g {
    public String cEV;
    public int cEX;
    public String cFc = "";
    public long cKK = 0;
    public String cdx = "";
    public int concurrentCount = 1;
    public long egA;
    public String egB;
    public int egC;
    public int egD;
    public String egE;
    public int egF;
    public int egG = 0;
    public long egH = 0;
    public int egI = 0;
    public long egJ = 0;
    public C26326a egK;
    public String[] ege;
    public String filename;
    public String host;
    public boolean isColdSnsData = false;
    public String referer;
    public String signalQuality = "";
    public String snsScene = "";
    public String url;

    /* renamed from: com.tencent.mm.i.h$a */
    public interface C26326a {
        /* renamed from: a */
        void mo8705a(String str, int i, C9545d c9545d);

        /* renamed from: h */
        void mo8706h(String str, int i, int i2);

        void onDataAvailable(String str, int i, int i2);

        void onMoovReady(String str, int i, int i2);
    }

    public final String toString() {
        AppMethodBeat.m2504i(128597);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("isPlayMode: ").append(this.egD);
        stringBuffer.append(" videoFormat: ").append(this.field_requestVideoFormat);
        stringBuffer.append(" initialDownloadLength : ").append(this.initialDownloadLength);
        stringBuffer.append(" initialDownloadOffset : ").append(this.initialDownloadOffset);
        stringBuffer.append(" videoXmlTotalLen : ").append(this.egC);
        stringBuffer.append(" videoTaskType : ").append(this.egy);
        stringBuffer.append(" filename : ").append(this.filename);
        if (mo67675Jp()) {
            stringBuffer.append(" url : ").append(this.url);
            stringBuffer.append(" host : ").append(this.host);
            stringBuffer.append(" referer : ").append(this.referer);
            stringBuffer.append(" ip size : ").append(this.ege != null ? this.ege.length : 0);
            stringBuffer.append(" isColdSnsData : ").append(this.isColdSnsData);
            stringBuffer.append(" signalQuality : ").append(this.signalQuality);
            stringBuffer.append(" snsScene : ").append(this.snsScene);
            stringBuffer.append(" snsId : ").append(this.cFc);
        } else {
            stringBuffer.append(" field_mediaId : ").append(this.field_mediaId);
        }
        stringBuffer.append(" fileid : ").append(this.field_fileId);
        stringBuffer.append(" fileaeskey: ").append(this.field_aesKey);
        stringBuffer.append(" field_preloadRatio:").append(this.field_preloadRatio);
        stringBuffer.append(" newmd5: ").append(this.cdx);
        stringBuffer.append("}");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(128597);
        return stringBuffer2;
    }
}
