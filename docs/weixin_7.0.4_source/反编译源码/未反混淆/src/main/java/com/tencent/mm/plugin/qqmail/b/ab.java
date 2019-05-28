package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class ab implements com.tencent.mm.ai.f {
    String cEV;
    String ptN;
    String[] pur;
    String[] pus;
    private String[] put;
    e pvc = null;
    String pve;
    Map<String, String> pvf = new HashMap();
    private Map<String, String> pvg = new LinkedHashMap();
    private Map<String, String> pvh = new LinkedHashMap();
    private b pvi;
    public z pvj;
    Map<String, String> pvk = new HashMap();
    f pvl = null;
    private HashMap<Long, Integer> pvm = new HashMap();
    private HashMap<Long, String> pvn = new HashMap();
    private HashMap<String, Integer> pvo = new HashMap();
    private int pvp = 0;
    ArrayList<g> pvq = new ArrayList();
    String pvr = null;
    String pvs = null;
    HashMap<String, String> pvt = new HashMap();
    c pvu;
    d pvv;
    int pvw = 0;
    com.tencent.mm.ai.g pvx = new com.tencent.mm.ai.g() {
        public final void a(int i, int i2, m mVar) {
            AppMethodBeat.i(68043);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", ab.this.pvr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ab.this.pvq.size()));
            if (i >= i2) {
                ab.this.pvt.put(ab.this.pvs, ((u) mVar).ccv().ptE);
                ah ccv = ((u) mVar).ccv();
                if (ab.this.pvv != null) {
                    ab.this.pvv.e(ab.this.pvw - ab.this.pvq.size(), ab.this.pvw, ab.this.pvs, ccv.ptE);
                }
                if (ab.this.pvq.isEmpty()) {
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "finished send all files");
                    if (ab.this.pvu != null) {
                        ab.this.pvu.ccz();
                    }
                    AppMethodBeat.o(68043);
                    return;
                }
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
                g gVar = (g) ab.this.pvq.remove(0);
                ab.this.pvr = gVar.fileId;
                ab.this.pvs = gVar.fileName;
                com.tencent.mm.kernel.g.RO().eJo.a(new u(ab.this.pvs, ab.this.pvr, this), 0);
            }
            AppMethodBeat.o(68043);
        }
    };

    public interface e {
        void Vn(String str);
    }

    public interface f {
        void ad(String str, int i, int i2);
    }

    public static class g {
        public String fileId;
        public String fileName;

        public g(String str, String str2) {
            this.fileId = str;
            this.fileName = str2;
        }
    }

    interface a {
        void ccA();
    }

    public interface b {
        void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap);
    }

    public interface c {
        void ccz();
    }

    public interface d {
        void e(int i, int i2, String str, String str2);
    }

    public ab() {
        AppMethodBeat.i(68045);
        com.tencent.mm.kernel.g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.video.g.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.RO().eJo.a(484, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.RO().eJo.a(485, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(68045);
    }

    public final void X(Map<String, String> map) {
        AppMethodBeat.i(68046);
        this.pvf = new HashMap();
        this.pvf.putAll(map);
        AppMethodBeat.o(68046);
    }

    public final void Y(Map<String, String> map) {
        AppMethodBeat.i(68047);
        this.pvg = new LinkedHashMap();
        this.pvg.putAll(map);
        AppMethodBeat.o(68047);
    }

    public final void Z(Map<String, String> map) {
        AppMethodBeat.i(68048);
        this.pvh = new LinkedHashMap();
        this.pvh.putAll(map);
        AppMethodBeat.o(68048);
    }

    public final void Br(final int i) {
        AppMethodBeat.i(68049);
        if (this.pvl != null) {
            al.d(new Runnable() {
                final /* synthetic */ int fFn = 100;

                public final void run() {
                    AppMethodBeat.i(68037);
                    ab.this.pvl.ad(ab.this.ptN, i, this.fFn);
                    AppMethodBeat.o(68037);
                }
            });
        }
        AppMethodBeat.o(68049);
    }

    public final void clearData() {
        AppMethodBeat.i(68050);
        this.pvn.clear();
        this.put = null;
        this.pvp = 0;
        this.pvr = null;
        this.pvs = null;
        this.pvt.clear();
        this.pvq.clear();
        this.cEV = null;
        this.pvm.clear();
        this.pvf.clear();
        this.pve = null;
        this.ptN = null;
        this.pvw = 0;
        this.pur = null;
        this.pvg.clear();
        this.pvk.clear();
        this.pvo.clear();
        this.pvl = null;
        this.pvc = null;
        AppMethodBeat.o(68050);
    }

    public final void a(f fVar, e eVar) {
        AppMethodBeat.i(68051);
        this.pvl = fVar;
        this.pvc = eVar;
        if (this.pvf.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.pvf.keySet()) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", str);
                arrayList.add(Long.valueOf(bo.getLong(str, 0)));
            }
            a(arrayList, new b() {
                public final void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap) {
                    ab abVar;
                    AppMethodBeat.i(68038);
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()));
                    if (arrayList.size() > 0) {
                        abVar = ab.this;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = (String) abVar.pvf.get(String.valueOf((Long) it.next()));
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", str);
                            if (!bo.isNullOrNil(str)) {
                                if (abVar.pvq == null) {
                                    abVar.pvq = new ArrayList();
                                }
                                abVar.pvq.add(new g(str, str));
                            }
                        }
                    }
                    if (hashMap.size() > 0) {
                        ab.a(ab.this, (HashMap) hashMap);
                    }
                    ab.this.Br(10);
                    abVar = ab.this;
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", Integer.valueOf(abVar.pvq.size()));
                    if (abVar.pvq == null) {
                        abVar.pvq = new ArrayList();
                    }
                    if (abVar.pvq.size() > 0) {
                        AnonymousClass3 anonymousClass3 = new c() {
                            public final void ccz() {
                                AppMethodBeat.i(68039);
                                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
                                ab.this.Br(90);
                                ab abVar = ab.this;
                                if (abVar.pvq != null && abVar.pvq.size() > 0) {
                                    abVar.pvq.clear();
                                }
                                ab.this.ccy();
                                AppMethodBeat.o(68039);
                            }
                        };
                        AnonymousClass4 anonymousClass4 = new d() {
                            public final void e(int i, int i2, String str, String str2) {
                                AppMethodBeat.i(68040);
                                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ShareModeMailAppService", "finishedSendOneFile, currentFileCount: %d, totalFileNum: %d", Integer.valueOf(i), Integer.valueOf(i2));
                                ab.this.pvk.put(str, str2);
                                ab.this.Br((int) (10.0f + (80.0f * (((float) i) / ((float) i2)))));
                                AppMethodBeat.o(68040);
                            }
                        };
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", Integer.valueOf(abVar.pvq.size()));
                        abVar.pvu = anonymousClass3;
                        abVar.pvv = anonymousClass4;
                        abVar.pvw = abVar.pvq.size();
                        if (abVar.pvq != null && abVar.pvq.size() > 0) {
                            g gVar = (g) abVar.pvq.remove(0);
                            abVar.pvr = gVar.fileId;
                            abVar.pvs = gVar.fileName;
                            abVar.pvt = new HashMap();
                            com.tencent.mm.kernel.g.RO().eJo.a(new u(abVar.pvs, abVar.pvr, abVar.pvx), 0);
                        }
                        AppMethodBeat.o(68038);
                        return;
                    }
                    abVar.Br(90);
                    abVar.ccy();
                    AppMethodBeat.o(68038);
                }
            });
            AppMethodBeat.o(68051);
            return;
        }
        Br(90);
        ccy();
        AppMethodBeat.o(68051);
    }

    /* Access modifiers changed, original: final */
    public final void ccy() {
        com.tencent.mm.plugin.qqmail.b.q.a[] aVarArr;
        int i;
        int i2;
        String str;
        com.tencent.mm.plugin.qqmail.b.q.a[] aVarArr2;
        int i3;
        int i4;
        com.tencent.mm.plugin.qqmail.b.q.a[] aVarArr3;
        com.tencent.mm.plugin.qqmail.b.q.a[] aVarArr4;
        StringBuilder stringBuilder;
        String stringBuilder2;
        AppMethodBeat.i(68052);
        int i5 = 0;
        int i6 = 0;
        if (this.pvg == null || this.pvg.size() <= 0) {
            aVarArr = null;
        } else {
            com.tencent.mm.plugin.qqmail.b.q.a[] aVarArr5 = new com.tencent.mm.plugin.qqmail.b.q.a[this.pvg.size()];
            Iterator it = this.pvg.keySet().iterator();
            while (true) {
                i = i6;
                i2 = i5;
                if (!it.hasNext()) {
                    break;
                }
                str = (String) it.next();
                com.tencent.mm.plugin.qqmail.b.q.a aVar = new com.tencent.mm.plugin.qqmail.b.q.a();
                aVar.pux = (String) this.pvg.get(str);
                aVar.fileName = str;
                aVar.name = (String) this.pvh.get(str);
                aVar.fileSize = (int) com.tencent.mm.vfs.e.asZ(str);
                aVarArr5[i2] = aVar;
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", Integer.valueOf(i2), aVar.pux, aVar.fileName, aVar.name, Integer.valueOf(aVar.fileSize));
                i5 = i2 + 1;
                i6 = aVar.fileSize + i;
            }
            aVarArr = aVarArr5;
            i6 = i;
        }
        i5 = 0;
        if (this.pvk == null || this.pvk.size() <= 0) {
            aVarArr2 = null;
            i3 = i6;
        } else {
            com.tencent.mm.plugin.qqmail.b.q.a[] aVarArr6 = new com.tencent.mm.plugin.qqmail.b.q.a[this.pvk.size()];
            Iterator it2 = this.pvk.keySet().iterator();
            while (true) {
                i = i6;
                i4 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                str = (String) it2.next();
                com.tencent.mm.plugin.qqmail.b.q.a aVar2 = new com.tencent.mm.plugin.qqmail.b.q.a();
                aVar2.pux = (String) this.pvk.get(str);
                aVar2.fileName = str;
                aVar2.fileSize = bo.a((Integer) this.pvo.get(aVar2.pux), 0);
                if (aVar2.fileSize == 0) {
                    aVar2.fileSize = (int) com.tencent.mm.vfs.e.asZ(str);
                }
                aVarArr6[i4] = aVar2;
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", Integer.valueOf(i4), aVar2.pux, aVar2.fileName, Integer.valueOf(aVar2.fileSize));
                i5 = i4 + 1;
                i6 = aVar2.fileSize + i;
            }
            aVarArr2 = aVarArr6;
            i3 = i;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", Integer.valueOf(i3));
        if (aVarArr2 == null || aVarArr2.length == 0) {
            aVarArr3 = null;
        } else {
            aVarArr3 = aVarArr2;
        }
        if (aVarArr == null || aVarArr.length == 0) {
            aVarArr4 = null;
        } else {
            aVarArr4 = aVarArr;
        }
        final AnonymousClass5 anonymousClass5 = new a() {
            public final void ccA() {
                AppMethodBeat.i(68041);
                ab.this.Br(100);
                AppMethodBeat.o(68041);
            }
        };
        q qVar = new q(this.cEV, this.pur, this.pus, this.put, this.ptN);
        qVar.puu = this.pve;
        if (aVarArr4 == null || aVarArr4.length <= 0) {
            qVar.puw = null;
        } else {
            qVar.puw = new com.tencent.mm.plugin.qqmail.b.q.a[aVarArr4.length];
            for (i5 = 0; i5 < qVar.puw.length; i5++) {
                qVar.puw[i5] = aVarArr4[i5];
            }
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", Integer.valueOf(qVar.puw.length));
        }
        if (aVarArr3 == null || aVarArr3.length <= 0) {
            qVar.puv = null;
        } else {
            qVar.puv = aVarArr3;
        }
        StringBuilder stringBuilder3 = new StringBuilder("");
        StringBuilder stringBuilder4 = new StringBuilder("");
        if (qVar.cEV != null) {
            stringBuilder = new StringBuilder("");
            stringBuilder.append("From: ");
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(qVar.cEV.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(qVar.cEV);
            stringBuilder.append(">");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = null;
        }
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder2 = qVar.ccr();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder2 = qVar.ccs();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder2 = qVar.cct();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder4.append("Subject: ");
        if (qVar.ptN != null) {
            stringBuilder4.append(qVar.ptN);
        }
        stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder4.append("Mime-Version: 1.0");
        stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder4.append("Content-Type: multipart/mixed;boundary=\"----=_NextPart_5208D22F_0929AFA8_5112E4AB\"");
        stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder4.append("Content-Transfer-Encoding: 8Bit");
        stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder4.append("Date: ".concat(String.valueOf(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en")).format(new Date()))));
        stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder4.append("X-QQ-MIME: TCMime 1.0 by Tencent");
        stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder4.append("X-Mailer: QQMail 2.x");
        stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder4.append("X-QQ-Mailer: QQMail 2.x");
        stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuilder3.append("This is a multi-part message in MIME format.");
        stringBuilder3.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuilder = new StringBuilder("");
        stringBuilder.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Content-Type:text/html;charset=\"utf-8\"");
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Content-Transfer-Encoding:base64");
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuilder.append(Base64.encodeToString(qVar.puu.getBytes(), 0));
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        if (qVar.puv != null && qVar.puv.length > 0) {
            for (com.tencent.mm.plugin.qqmail.b.q.a aVar3 : qVar.puv) {
                String str2 = aVar3.pux;
                String str3 = aVar3.fileName;
                int i7 = aVar3.fileSize;
                StringBuilder stringBuilder5 = new StringBuilder("");
                stringBuilder5.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append(String.format("Content-Type:image/jpeg;name=\"%s\"", new Object[]{str3}));
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append("Content-Transfer-Encoding:base64");
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append(String.format("Content-ID:<%s>", new Object[]{str3}));
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                stringBuilder5.append(String.format("QQMail-LinkID:%s", new Object[]{str2}));
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i7)}));
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append("QQMail-LineLen:72");
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append("QQMail-BreakType:1");
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append(String.format("QQMail-Key:%s", new Object[]{q.Vk(str2)}));
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append("QQMail-LinkEnd");
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder3.append(stringBuilder5.toString());
                stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        if (qVar.puw != null && qVar.puw.length > 0) {
            for (com.tencent.mm.plugin.qqmail.b.q.a aVar4 : qVar.puw) {
                String str4 = aVar4.pux;
                int i8 = aVar4.fileSize;
                String str5 = aVar4.name;
                StringBuilder stringBuilder6 = new StringBuilder("");
                stringBuilder6.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append(String.format("Content-Type:application/octet-stream;charset=\"utf-8\";name=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str5.getBytes(), 2)}));
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append(String.format("Content-Disposition: attachment; filename=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str5.getBytes(), 2)}));
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append("Content-Transfer-Encoding:base64");
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append(String.format("Content-ID:<%s>", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                stringBuilder6.append(String.format("QQMail-LinkID:%s", new Object[]{str4}));
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i8)}));
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append("QQMail-LineLen:72");
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append("QQMail-BreakType:1");
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append(String.format("QQMail-Key:%s", new Object[]{q.Vk(str4)}));
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append("QQMail-LinkEnd");
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder3.append(stringBuilder6.toString());
                stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        stringBuilder3.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        com.tencent.mm.kernel.g.RO().eJo.a(new s(stringBuilder3.toString(), this.cEV, this.pur, i3, new com.tencent.mm.ai.g() {
            public final void a(int i, int i2, m mVar) {
                AppMethodBeat.i(68044);
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i >= i2) {
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "finish send");
                    if (anonymousClass5 != null) {
                        anonymousClass5.ccA();
                    }
                }
                AppMethodBeat.o(68044);
            }
        }), 0);
        AppMethodBeat.o(68052);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(68053);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0 || i2 != 0) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.video.g.CTRL_INDEX) {
                a((r) mVar);
                AppMethodBeat.o(68053);
                return;
            }
            if (this.pvc != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(68042);
                        ab.this.pvc.Vn(ab.this.ptN);
                        AppMethodBeat.o(68042);
                    }
                });
            }
            AppMethodBeat.o(68053);
        } else if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.video.g.CTRL_INDEX) {
            a((r) mVar);
            AppMethodBeat.o(68053);
        } else {
            if (mVar.getType() != 484) {
                mVar.getType();
            }
            AppMethodBeat.o(68053);
        }
    }

    private void O(ArrayList<Long> arrayList) {
        AppMethodBeat.i(68054);
        if (this.pvm != null) {
            this.pvm.clear();
            this.pvm = null;
        }
        this.pvm = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.pvm.put(Long.valueOf(((Long) it.next()).longValue()), Integer.valueOf(1));
        }
        AppMethodBeat.o(68054);
    }

    private void a(ArrayList<Long> arrayList, b bVar) {
        AppMethodBeat.i(68055);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
        this.pvp = 0;
        O(arrayList);
        if (this.pvn != null) {
            this.pvn.clear();
            this.pvn = null;
        }
        this.pvn = new HashMap();
        this.pvi = bVar;
        com.tencent.mm.kernel.g.RO().eJo.a(new r(arrayList), 0);
        AppMethodBeat.o(68055);
    }

    private static ArrayList<Long> m(HashMap<Long, Integer> hashMap) {
        AppMethodBeat.i(68056);
        ArrayList arrayList = new ArrayList();
        for (Long add : hashMap.keySet()) {
            arrayList.add(add);
        }
        AppMethodBeat.o(68056);
        return arrayList;
    }

    private void a(r rVar) {
        AppMethodBeat.i(68057);
        this.pvp++;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", Integer.valueOf(this.pvp));
        Iterator it = rVar.ccu().iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            long j = (long) gVar.ptD;
            int i = gVar.jBT;
            if (this.pvm.containsKey(Long.valueOf(j))) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", Long.valueOf(j), Integer.valueOf(i));
                if (i == 0) {
                    this.pvm.remove(Long.valueOf(j));
                    if (gVar.ptE != null) {
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", Long.valueOf(j), gVar.ptE);
                        this.pvn.put(Long.valueOf(j), gVar.ptE);
                        this.pvo.put(gVar.ptE, Integer.valueOf(gVar.FileSize));
                    }
                } else {
                    this.pvm.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }
        if (this.pvm.isEmpty()) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "all image is in server");
            if (this.pvi != null) {
                this.pvi.a(new ArrayList(), this.pvn);
            }
            AppMethodBeat.o(68057);
        } else if (this.pvp < 3) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
            com.tencent.mm.kernel.g.RO().eJo.a(new r(m(this.pvm)), 0);
            AppMethodBeat.o(68057);
        } else {
            this.pvi.a(m(this.pvm), this.pvn);
            AppMethodBeat.o(68057);
        }
    }
}
