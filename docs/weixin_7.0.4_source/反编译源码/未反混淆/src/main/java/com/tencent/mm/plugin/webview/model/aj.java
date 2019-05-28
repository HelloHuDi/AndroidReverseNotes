package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class aj implements f {
    private a fFk = new a() {
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(6697);
            ab.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.o(6697);
        }

        public final byte[] l(String str, byte[] bArr) {
            AppMethodBeat.i(6698);
            ab.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.o(6698);
            return null;
        }

        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            String str2;
            WebViewJSSDKFileItem webViewJSSDKFileItem;
            AppMethodBeat.i(6699);
            String str3 = "MicroMsg.WebviewFileChooserCdnService";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = cVar == null ? BuildConfig.COMMAND : cVar.toString();
            if (dVar == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = dVar.toString();
            }
            objArr[3] = str2;
            ab.i(str3, str4, objArr);
            ak cYF = g.cYF();
            if (!bo.isNullOrNil(str)) {
                for (WebViewJSSDKFileItem webViewJSSDKFileItem2 : cYF.umz.values()) {
                    if (bo.nullAsNil(webViewJSSDKFileItem2.cHr).equals(str)) {
                        webViewJSSDKFileItem = webViewJSSDKFileItem2;
                        break;
                    }
                }
            }
            ab.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
            webViewJSSDKFileItem = null;
            if (webViewJSSDKFileItem == null) {
                ab.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", str);
                AppMethodBeat.o(6699);
                return 0;
            } else if (i == -21005) {
                ab.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(6699);
                return 0;
            } else if (i != 0) {
                ab.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                aj.a(aj.this, false, webViewJSSDKFileItem.czD, webViewJSSDKFileItem.cHr, null);
                AppMethodBeat.o(6699);
                return 0;
            } else if (cVar != null) {
                ab.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", cVar.toString());
                int i2 = 0;
                if (cVar.field_toltalLength > 0) {
                    i2 = (cVar.field_finishedLength * 100) / cVar.field_toltalLength;
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 100) {
                    i2 = 100;
                }
                aj.this.b(webViewJSSDKFileItem.her, webViewJSSDKFileItem.cyQ, i2, webViewJSSDKFileItem.czD, webViewJSSDKFileItem.cHr);
                AppMethodBeat.o(6699);
                return 0;
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        aj.a(aj.this, false, webViewJSSDKFileItem.czD, webViewJSSDKFileItem.cHr, null);
                    } else {
                        ab.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s", str);
                        if (webViewJSSDKFileItem != null) {
                            webViewJSSDKFileItem.c(dVar);
                            if (webViewJSSDKFileItem.her && webViewJSSDKFileItem.het) {
                                f fVar = aj.this;
                                if (webViewJSSDKFileItem == null) {
                                    ab.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                                } else {
                                    azh azh = new azh();
                                    azh.woO = webViewJSSDKFileItem.uZU.field_aesKey;
                                    azh.vXd = webViewJSSDKFileItem.uZU.field_fileLength;
                                    azh.wDs = webViewJSSDKFileItem.uZU.field_fileId;
                                    azh.type = webViewJSSDKFileItem.cXK();
                                    ab.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", webViewJSSDKFileItem.appId, webViewJSSDKFileItem.czD, azh.woO, Integer.valueOf(azh.vXd), azh.wDs);
                                    azh.wDt = webViewJSSDKFileItem.cXJ();
                                    com.tencent.mm.kernel.g.Rg().a(1034, fVar);
                                    com.tencent.mm.kernel.g.Rg().a(new ad(webViewJSSDKFileItem.appId, webViewJSSDKFileItem.czD, azh), 0);
                                }
                            } else {
                                aj.a(aj.this, true, webViewJSSDKFileItem.czD, webViewJSSDKFileItem.hep, webViewJSSDKFileItem.uZU.field_fileUrl);
                            }
                        }
                    }
                }
                AppMethodBeat.o(6699);
                return 0;
            }
        }
    };
    private CopyOnWriteArraySet<b> umu = new CopyOnWriteArraySet();
    private CopyOnWriteArraySet<d.a> umv = new CopyOnWriteArraySet();

    static /* synthetic */ void a(aj ajVar, boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(6713);
        ajVar.c(z, str, str2, str3);
        AppMethodBeat.o(6713);
    }

    public aj() {
        AppMethodBeat.i(6700);
        AppMethodBeat.o(6700);
    }

    public final void a(d.a aVar) {
        AppMethodBeat.i(6701);
        if (!(this.umv == null || aVar == null || this.umv.contains(aVar))) {
            this.umv.add(aVar);
        }
        AppMethodBeat.o(6701);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(6702);
        if (!(this.umu == null || bVar == null)) {
            this.umu.remove(bVar);
        }
        AppMethodBeat.o(6702);
    }

    public final void b(d.a aVar) {
        AppMethodBeat.i(6703);
        if (!(this.umv == null || aVar == null)) {
            this.umv.remove(aVar);
        }
        AppMethodBeat.o(6703);
    }

    private void c(boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(6704);
        if (this.umu != null && this.umu.size() > 0) {
            Iterator it = this.umu.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(z, str, str2, str3);
            }
        }
        AppMethodBeat.o(6704);
    }

    /* Access modifiers changed, original: final */
    public final void b(boolean z, int i, int i2, String str, String str2) {
        AppMethodBeat.i(6705);
        ab.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2);
        if (this.umv != null && this.umv.size() > 0) {
            Iterator it = this.umv.iterator();
            while (it.hasNext()) {
                ((d.a) it.next()).a(z, i, i2, str, str2);
            }
        }
        AppMethodBeat.o(6705);
    }

    public final boolean a(String str, String str2, b bVar) {
        AppMethodBeat.i(6706);
        ak cYF = g.cYF();
        if (!bo.isNullOrNil(str2)) {
            for (WebViewJSSDKFileItem webViewJSSDKFileItem : cYF.umz.values()) {
                if (bo.nullAsNil(webViewJSSDKFileItem.hep).equals(str2)) {
                    break;
                }
            }
        }
        ab.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
        WebViewJSSDKFileItem webViewJSSDKFileItem2 = null;
        if (webViewJSSDKFileItem2 != null) {
            webViewJSSDKFileItem2.appId = str;
            ab.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", str, str2, webViewJSSDKFileItem2.czD);
            bVar.b(true, webViewJSSDKFileItem2.czD, webViewJSSDKFileItem2.hep, null);
            AppMethodBeat.o(6706);
        } else {
            com.tencent.mm.kernel.g.Rg().a(1035, (f) this);
            com.tencent.mm.kernel.g.Rg().a(new j(str, str2), 0);
            this.umu.add(bVar);
            AppMethodBeat.o(6706);
        }
        return true;
    }

    private void a(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        AppMethodBeat.i(6707);
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.egl = this.fFk;
        gVar.cRY = false;
        gVar.field_mediaId = webViewJSSDKFileItem.cHr;
        gVar.field_fullpath = webViewJSSDKFileItem.heo;
        gVar.field_totalLen = webViewJSSDKFileItem.uZU.field_fileLength;
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
        gVar.field_fileId = webViewJSSDKFileItem.uZU.field_fileId;
        gVar.field_aesKey = webViewJSSDKFileItem.uZU.field_aesKey;
        gVar.field_priority = com.tencent.mm.i.a.efC;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        ab.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", Boolean.valueOf(com.tencent.mm.al.f.afx().b(gVar, -1)), webViewJSSDKFileItem.hep);
        if (!com.tencent.mm.al.f.afx().b(gVar, -1)) {
            c(false, null, null, null);
        }
        AppMethodBeat.o(6707);
    }

    public final boolean a(String str, String str2, int i, int i2, int i3, b bVar) {
        AppMethodBeat.i(6708);
        WebViewJSSDKFileItem aex = g.cYF().aex(str2);
        if (aex == null) {
            ab.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", str2);
            AppMethodBeat.o(6708);
            return false;
        }
        aex.appId = str;
        if (bVar != null) {
            this.umu.add(bVar);
        }
        if (i2 == 202) {
            aex.het = false;
        }
        aex.her = true;
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.egl = this.fFk;
        gVar.cRY = true;
        gVar.field_mediaId = aex.cHr;
        gVar.field_fullpath = aex.heo;
        gVar.field_fileType = i;
        gVar.field_talker = "weixin";
        gVar.field_priority = com.tencent.mm.i.a.efC;
        if (i == com.tencent.mm.i.a.efH) {
            gVar.field_needStorage = true;
        } else {
            gVar.field_needStorage = false;
        }
        gVar.field_isStreamMedia = false;
        gVar.field_appType = i2;
        gVar.field_bzScene = i3;
        gVar.field_force_aeskeycdn = true;
        gVar.field_trysafecdn = false;
        ab.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", Boolean.valueOf(com.tencent.mm.al.f.afx().e(gVar)), Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), str2);
        AppMethodBeat.o(6708);
        return com.tencent.mm.al.f.afx().e(gVar);
    }

    public final boolean b(String str, String str2, b bVar) {
        AppMethodBeat.i(6709);
        boolean a = a(str, str2, com.tencent.mm.i.a.MediaType_FILE, 0, 0, bVar);
        AppMethodBeat.o(6709);
        return a;
    }

    public static boolean yC(String str) {
        AppMethodBeat.i(6710);
        WebViewJSSDKFileItem aex = g.cYF().aex(str);
        if (aex == null) {
            ab.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", str);
            AppMethodBeat.o(6710);
            return false;
        }
        boolean rN = com.tencent.mm.al.f.afx().rN(aex.cHr);
        AppMethodBeat.o(6710);
        return rN;
    }

    public static boolean aet(String str) {
        AppMethodBeat.i(6711);
        ab.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", str);
        boolean rO = com.tencent.mm.al.f.afx().rO(str);
        AppMethodBeat.o(6711);
        return rO;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(6712);
        ab.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mVar.getType()));
        String str2;
        String str3;
        String str4;
        String str5;
        switch (mVar.getType()) {
            case 1034:
                com.tencent.mm.kernel.g.Rg().b(1034, (f) this);
                ad adVar = (ad) mVar;
                str2 = ((azn) adVar.ehh.fsH.fsP).wDu;
                str3 = adVar.appId;
                str4 = adVar.czD;
                WebViewJSSDKFileItem aex = g.cYF().aex(str4);
                String str6 = "MicroMsg.WebviewFileChooserCdnService";
                str5 = "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b";
                Object[] objArr = new Object[4];
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = Boolean.valueOf(aex == null);
                ab.i(str6, str5, objArr);
                if (i != 0 || i2 != 0) {
                    ab.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
                    if (aex != null) {
                        c(false, aex.czD, aex.cHr, null);
                        AppMethodBeat.o(6712);
                        return;
                    }
                } else if (!(bo.isNullOrNil(str3) || bo.isNullOrNil(str2) || aex == null)) {
                    aex.hep = str2;
                    b(true, aex.cyQ, 100, aex.czD, aex.hep);
                    c(true, aex.czD, aex.hep, aex.uZU.field_fileUrl);
                    AppMethodBeat.o(6712);
                    return;
                }
                break;
            case 1035:
                com.tencent.mm.kernel.g.Rg().b(1035, (f) this);
                if (i != 0 || i2 != 0) {
                    ab.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
                    c(false, null, null, null);
                    break;
                }
                j jVar = (j) mVar;
                str2 = jVar.appId;
                str3 = jVar.hep;
                azh azh = ((azj) jVar.ehh.fsH.fsP).wDv;
                str5 = "MicroMsg.WebviewFileChooserCdnService";
                String str7 = "appid = %s, serverId = %s, cdninfo == null ? %b";
                Object[] objArr2 = new Object[3];
                objArr2[0] = str2;
                objArr2[1] = str3;
                objArr2[2] = Boolean.valueOf(azh == null);
                ab.i(str5, str7, objArr2);
                if (!(bo.isNullOrNil(str2) || bo.isNullOrNil(str3) || azh == null)) {
                    str4 = azh.type;
                    ab.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", str4);
                    if (!bo.isNullOrNil(str4)) {
                        WebViewJSSDKFileItem aev;
                        if (str4.toLowerCase().equals("voice")) {
                            aev = WebViewJSSDKFileItem.aev(ap.aeF(str2));
                        } else if (str4.toLowerCase().equals("video")) {
                            aev = WebViewJSSDKFileItem.aew(ap.aez(bo.anU()));
                        } else {
                            aev = WebViewJSSDKFileItem.aeu(ap.aez(bo.anU()));
                        }
                        aev.her = false;
                        aev.appId = str2;
                        aev.hep = str3;
                        if (aev.uZU == null) {
                            aev.uZU = new WebViewJSSDKFileItem.a();
                        }
                        if (azh == null) {
                            ab.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
                        } else {
                            aev.uZU.field_aesKey = azh.woO;
                            aev.uZU.field_fileId = azh.wDs;
                            aev.uZU.field_fileLength = azh.vXd;
                        }
                        g.cYF().b(aev);
                        a(aev);
                    }
                }
                AppMethodBeat.o(6712);
                return;
                break;
        }
        AppMethodBeat.o(6712);
    }
}
