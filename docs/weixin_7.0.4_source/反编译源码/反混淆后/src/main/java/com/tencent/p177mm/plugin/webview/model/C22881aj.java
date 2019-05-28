package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.webview.model.C22888d.C14515b;
import com.tencent.p177mm.plugin.webview.model.C22888d.C22889a;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem.C14505a;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.protocal.protobuf.azh;
import com.tencent.p177mm.protocal.protobuf.azj;
import com.tencent.p177mm.protocal.protobuf.azn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.tencent.mm.plugin.webview.model.aj */
public final class C22881aj implements C1202f {
    private C1628a fFk = new C145091();
    private CopyOnWriteArraySet<C14515b> umu = new CopyOnWriteArraySet();
    private CopyOnWriteArraySet<C22889a> umv = new CopyOnWriteArraySet();

    /* renamed from: com.tencent.mm.plugin.webview.model.aj$1 */
    class C145091 implements C1628a {
        C145091() {
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.m2504i(6697);
            C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.m2505o(6697);
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            AppMethodBeat.m2504i(6698);
            C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.m2505o(6698);
            return null;
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            String str2;
            WebViewJSSDKFileItem webViewJSSDKFileItem;
            AppMethodBeat.m2504i(6699);
            String str3 = "MicroMsg.WebviewFileChooserCdnService";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = c18496c == null ? BuildConfig.COMMAND : c18496c.toString();
            if (c9545d == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = c9545d.toString();
            }
            objArr[3] = str2;
            C4990ab.m7417i(str3, str4, objArr);
            C29817ak cYF = C29833g.cYF();
            if (!C5046bo.isNullOrNil(str)) {
                for (WebViewJSSDKFileItem webViewJSSDKFileItem2 : cYF.umz.values()) {
                    if (C5046bo.nullAsNil(webViewJSSDKFileItem2.cHr).equals(str)) {
                        webViewJSSDKFileItem = webViewJSSDKFileItem2;
                        break;
                    }
                }
            }
            C4990ab.m7412e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
            webViewJSSDKFileItem = null;
            if (webViewJSSDKFileItem == null) {
                C4990ab.m7413e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", str);
                AppMethodBeat.m2505o(6699);
                return 0;
            } else if (i == -21005) {
                C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.m2505o(6699);
                return 0;
            } else if (i != 0) {
                C4990ab.m7413e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                C22881aj.m34723a(C22881aj.this, false, webViewJSSDKFileItem.czD, webViewJSSDKFileItem.cHr, null);
                AppMethodBeat.m2505o(6699);
                return 0;
            } else if (c18496c != null) {
                C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", c18496c.toString());
                int i2 = 0;
                if (c18496c.field_toltalLength > 0) {
                    i2 = (c18496c.field_finishedLength * 100) / c18496c.field_toltalLength;
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 100) {
                    i2 = 100;
                }
                C22881aj.this.mo38478b(webViewJSSDKFileItem.her, webViewJSSDKFileItem.cyQ, i2, webViewJSSDKFileItem.czD, webViewJSSDKFileItem.cHr);
                AppMethodBeat.m2505o(6699);
                return 0;
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(c9545d.field_retCode), c9545d);
                        C22881aj.m34723a(C22881aj.this, false, webViewJSSDKFileItem.czD, webViewJSSDKFileItem.cHr, null);
                    } else {
                        C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s", str);
                        if (webViewJSSDKFileItem != null) {
                            webViewJSSDKFileItem.mo26740c(c9545d);
                            if (webViewJSSDKFileItem.her && webViewJSSDKFileItem.het) {
                                C1202f c1202f = C22881aj.this;
                                if (webViewJSSDKFileItem == null) {
                                    C4990ab.m7412e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                                } else {
                                    azh azh = new azh();
                                    azh.woO = webViewJSSDKFileItem.uZU.field_aesKey;
                                    azh.vXd = webViewJSSDKFileItem.uZU.field_fileLength;
                                    azh.wDs = webViewJSSDKFileItem.uZU.field_fileId;
                                    azh.type = webViewJSSDKFileItem.cXK();
                                    C4990ab.m7411d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", webViewJSSDKFileItem.appId, webViewJSSDKFileItem.czD, azh.woO, Integer.valueOf(azh.vXd), azh.wDs);
                                    azh.wDt = webViewJSSDKFileItem.cXJ();
                                    C1720g.m3540Rg().mo14539a(1034, c1202f);
                                    C1720g.m3540Rg().mo14541a(new C29813ad(webViewJSSDKFileItem.appId, webViewJSSDKFileItem.czD, azh), 0);
                                }
                            } else {
                                C22881aj.m34723a(C22881aj.this, true, webViewJSSDKFileItem.czD, webViewJSSDKFileItem.hep, webViewJSSDKFileItem.uZU.field_fileUrl);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(6699);
                return 0;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m34723a(C22881aj c22881aj, boolean z, String str, String str2, String str3) {
        AppMethodBeat.m2504i(6713);
        c22881aj.m34724c(z, str, str2, str3);
        AppMethodBeat.m2505o(6713);
    }

    public C22881aj() {
        AppMethodBeat.m2504i(6700);
        AppMethodBeat.m2505o(6700);
    }

    /* renamed from: a */
    public final void mo38473a(C22889a c22889a) {
        AppMethodBeat.m2504i(6701);
        if (!(this.umv == null || c22889a == null || this.umv.contains(c22889a))) {
            this.umv.add(c22889a);
        }
        AppMethodBeat.m2505o(6701);
    }

    /* renamed from: a */
    public final void mo38474a(C14515b c14515b) {
        AppMethodBeat.m2504i(6702);
        if (!(this.umu == null || c14515b == null)) {
            this.umu.remove(c14515b);
        }
        AppMethodBeat.m2505o(6702);
    }

    /* renamed from: b */
    public final void mo38477b(C22889a c22889a) {
        AppMethodBeat.m2504i(6703);
        if (!(this.umv == null || c22889a == null)) {
            this.umv.remove(c22889a);
        }
        AppMethodBeat.m2505o(6703);
    }

    /* renamed from: c */
    private void m34724c(boolean z, String str, String str2, String str3) {
        AppMethodBeat.m2504i(6704);
        if (this.umu != null && this.umu.size() > 0) {
            Iterator it = this.umu.iterator();
            while (it.hasNext()) {
                ((C14515b) it.next()).mo26755b(z, str, str2, str3);
            }
        }
        AppMethodBeat.m2505o(6704);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo38478b(boolean z, int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(6705);
        C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
        if (this.umv != null && this.umv.size() > 0) {
            Iterator it = this.umv.iterator();
            while (it.hasNext()) {
                ((C22889a) it.next()).mo9642a(z, i, i2, str, str2);
            }
        }
        AppMethodBeat.m2505o(6705);
    }

    /* renamed from: a */
    public final boolean mo38476a(String str, String str2, C14515b c14515b) {
        AppMethodBeat.m2504i(6706);
        C29817ak cYF = C29833g.cYF();
        if (!C5046bo.isNullOrNil(str2)) {
            for (WebViewJSSDKFileItem webViewJSSDKFileItem : cYF.umz.values()) {
                if (C5046bo.nullAsNil(webViewJSSDKFileItem.hep).equals(str2)) {
                    break;
                }
            }
        }
        C4990ab.m7412e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
        WebViewJSSDKFileItem webViewJSSDKFileItem2 = null;
        if (webViewJSSDKFileItem2 != null) {
            webViewJSSDKFileItem2.appId = str;
            C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", str, str2, webViewJSSDKFileItem2.czD);
            c14515b.mo26755b(true, webViewJSSDKFileItem2.czD, webViewJSSDKFileItem2.hep, null);
            AppMethodBeat.m2505o(6706);
        } else {
            C1720g.m3540Rg().mo14539a(1035, (C1202f) this);
            C1720g.m3540Rg().mo14541a(new C43919j(str, str2), 0);
            this.umu.add(c14515b);
            AppMethodBeat.m2505o(6706);
        }
        return true;
    }

    /* renamed from: a */
    private void m34722a(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        AppMethodBeat.m2504i(6707);
        C42130g c42130g = new C42130g();
        c42130g.egl = this.fFk;
        c42130g.cRY = false;
        c42130g.field_mediaId = webViewJSSDKFileItem.cHr;
        c42130g.field_fullpath = webViewJSSDKFileItem.heo;
        c42130g.field_totalLen = webViewJSSDKFileItem.uZU.field_fileLength;
        c42130g.field_fileType = C42129a.MediaType_FILE;
        c42130g.field_fileId = webViewJSSDKFileItem.uZU.field_fileId;
        c42130g.field_aesKey = webViewJSSDKFileItem.uZU.field_aesKey;
        c42130g.field_priority = C42129a.efC;
        c42130g.field_needStorage = false;
        c42130g.field_isStreamMedia = false;
        C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", Boolean.valueOf(C37461f.afx().mo51222b(c42130g, -1)), webViewJSSDKFileItem.hep);
        if (!C37461f.afx().mo51222b(c42130g, -1)) {
            m34724c(false, null, null, null);
        }
        AppMethodBeat.m2505o(6707);
    }

    /* renamed from: a */
    public final boolean mo38475a(String str, String str2, int i, int i2, int i3, C14515b c14515b) {
        AppMethodBeat.m2504i(6708);
        WebViewJSSDKFileItem aex = C29833g.cYF().aex(str2);
        if (aex == null) {
            C4990ab.m7413e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", str2);
            AppMethodBeat.m2505o(6708);
            return false;
        }
        aex.appId = str;
        if (c14515b != null) {
            this.umu.add(c14515b);
        }
        if (i2 == 202) {
            aex.het = false;
        }
        aex.her = true;
        C42130g c42130g = new C42130g();
        c42130g.egl = this.fFk;
        c42130g.cRY = true;
        c42130g.field_mediaId = aex.cHr;
        c42130g.field_fullpath = aex.heo;
        c42130g.field_fileType = i;
        c42130g.field_talker = "weixin";
        c42130g.field_priority = C42129a.efC;
        if (i == C42129a.efH) {
            c42130g.field_needStorage = true;
        } else {
            c42130g.field_needStorage = false;
        }
        c42130g.field_isStreamMedia = false;
        c42130g.field_appType = i2;
        c42130g.field_bzScene = i3;
        c42130g.field_force_aeskeycdn = true;
        c42130g.field_trysafecdn = false;
        C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", Boolean.valueOf(C37461f.afx().mo51225e(c42130g)), Boolean.valueOf(c42130g.field_force_aeskeycdn), Boolean.valueOf(c42130g.field_trysafecdn), str2);
        AppMethodBeat.m2505o(6708);
        return C37461f.afx().mo51225e(c42130g);
    }

    /* renamed from: b */
    public final boolean mo38479b(String str, String str2, C14515b c14515b) {
        AppMethodBeat.m2504i(6709);
        boolean a = mo38475a(str, str2, C42129a.MediaType_FILE, 0, 0, c14515b);
        AppMethodBeat.m2505o(6709);
        return a;
    }

    /* renamed from: yC */
    public static boolean m34725yC(String str) {
        AppMethodBeat.m2504i(6710);
        WebViewJSSDKFileItem aex = C29833g.cYF().aex(str);
        if (aex == null) {
            C4990ab.m7413e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", str);
            AppMethodBeat.m2505o(6710);
            return false;
        }
        boolean rN = C37461f.afx().mo51227rN(aex.cHr);
        AppMethodBeat.m2505o(6710);
        return rN;
    }

    public static boolean aet(String str) {
        AppMethodBeat.m2504i(6711);
        C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", str);
        boolean rO = C37461f.afx().mo51228rO(str);
        AppMethodBeat.m2505o(6711);
        return rO;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(6712);
        C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c1207m.getType()));
        String str2;
        String str3;
        String str4;
        String str5;
        switch (c1207m.getType()) {
            case 1034:
                C1720g.m3540Rg().mo14546b(1034, (C1202f) this);
                C29813ad c29813ad = (C29813ad) c1207m;
                str2 = ((azn) c29813ad.ehh.fsH.fsP).wDu;
                str3 = c29813ad.appId;
                str4 = c29813ad.czD;
                WebViewJSSDKFileItem aex = C29833g.cYF().aex(str4);
                String str6 = "MicroMsg.WebviewFileChooserCdnService";
                str5 = "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b";
                Object[] objArr = new Object[4];
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = Boolean.valueOf(aex == null);
                C4990ab.m7417i(str6, str5, objArr);
                if (i != 0 || i2 != 0) {
                    C4990ab.m7412e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
                    if (aex != null) {
                        m34724c(false, aex.czD, aex.cHr, null);
                        AppMethodBeat.m2505o(6712);
                        return;
                    }
                } else if (!(C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str2) || aex == null)) {
                    aex.hep = str2;
                    mo38478b(true, aex.cyQ, 100, aex.czD, aex.hep);
                    m34724c(true, aex.czD, aex.hep, aex.uZU.field_fileUrl);
                    AppMethodBeat.m2505o(6712);
                    return;
                }
                break;
            case 1035:
                C1720g.m3540Rg().mo14546b(1035, (C1202f) this);
                if (i != 0 || i2 != 0) {
                    C4990ab.m7412e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
                    m34724c(false, null, null, null);
                    break;
                }
                C43919j c43919j = (C43919j) c1207m;
                str2 = c43919j.appId;
                str3 = c43919j.hep;
                azh azh = ((azj) c43919j.ehh.fsH.fsP).wDv;
                str5 = "MicroMsg.WebviewFileChooserCdnService";
                String str7 = "appid = %s, serverId = %s, cdninfo == null ? %b";
                Object[] objArr2 = new Object[3];
                objArr2[0] = str2;
                objArr2[1] = str3;
                objArr2[2] = Boolean.valueOf(azh == null);
                C4990ab.m7417i(str5, str7, objArr2);
                if (!(C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3) || azh == null)) {
                    str4 = azh.type;
                    C4990ab.m7417i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", str4);
                    if (!C5046bo.isNullOrNil(str4)) {
                        WebViewJSSDKFileItem aev;
                        if (str4.toLowerCase().equals("voice")) {
                            aev = WebViewJSSDKFileItem.aev(C43914ap.aeF(str2));
                        } else if (str4.toLowerCase().equals("video")) {
                            aev = WebViewJSSDKFileItem.aew(C43914ap.aez(C5046bo.anU()));
                        } else {
                            aev = WebViewJSSDKFileItem.aeu(C43914ap.aez(C5046bo.anU()));
                        }
                        aev.her = false;
                        aev.appId = str2;
                        aev.hep = str3;
                        if (aev.uZU == null) {
                            aev.uZU = new C14505a();
                        }
                        if (azh == null) {
                            C4990ab.m7412e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
                        } else {
                            aev.uZU.field_aesKey = azh.woO;
                            aev.uZU.field_fileId = azh.wDs;
                            aev.uZU.field_fileLength = azh.vXd;
                        }
                        C29833g.cYF().mo48046b(aev);
                        m34722a(aev);
                    }
                }
                AppMethodBeat.m2505o(6712);
                return;
                break;
        }
        AppMethodBeat.m2505o(6712);
    }
}
