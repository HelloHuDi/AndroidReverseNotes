package com.tencent.p177mm.plugin.qqmail.p486b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C19517g;
import com.tencent.p177mm.plugin.qqmail.p486b.C12891q.C12890a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.b.ab */
public final class C28730ab implements C1202f {
    String cEV;
    String ptN;
    String[] pur;
    String[] pus;
    private String[] put;
    C12882e pvc = null;
    String pve;
    Map<String, String> pvf = new HashMap();
    private Map<String, String> pvg = new LinkedHashMap();
    private Map<String, String> pvh = new LinkedHashMap();
    private C28733b pvi;
    public C12892z pvj;
    Map<String, String> pvk = new HashMap();
    C12883f pvl = null;
    private HashMap<Long, Integer> pvm = new HashMap();
    private HashMap<Long, String> pvn = new HashMap();
    private HashMap<String, Integer> pvo = new HashMap();
    private int pvp = 0;
    ArrayList<C28729g> pvq = new ArrayList();
    String pvr = null;
    String pvs = null;
    HashMap<String, String> pvt = new HashMap();
    C28734c pvu;
    C28735d pvv;
    int pvw = 0;
    C32231g pvx = new C287387();

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$4 */
    class C36464 implements C28735d {
        C36464() {
        }

        /* renamed from: e */
        public final void mo8236e(int i, int i2, String str, String str2) {
            AppMethodBeat.m2504i(68040);
            C4990ab.m7411d("MicroMsg.ShareModeMailAppService", "finishedSendOneFile, currentFileCount: %d, totalFileNum: %d", Integer.valueOf(i), Integer.valueOf(i2));
            C28730ab.this.pvk.put(str, str2);
            C28730ab.this.mo46884Br((int) (10.0f + (80.0f * (((float) i) / ((float) i2)))));
            AppMethodBeat.m2505o(68040);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$3 */
    class C128813 implements C28734c {
        C128813() {
        }

        public final void ccz() {
            AppMethodBeat.m2504i(68039);
            C4990ab.m7410d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
            C28730ab.this.mo46884Br(90);
            C28730ab c28730ab = C28730ab.this;
            if (c28730ab.pvq != null && c28730ab.pvq.size() > 0) {
                c28730ab.pvq.clear();
            }
            C28730ab.this.ccy();
            AppMethodBeat.m2505o(68039);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$e */
    public interface C12882e {
        /* renamed from: Vn */
        void mo24911Vn(String str);
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$f */
    public interface C12883f {
        /* renamed from: ad */
        void mo24912ad(String str, int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$2 */
    class C287282 implements C28733b {
        C287282() {
        }

        /* renamed from: a */
        public final void mo46883a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap) {
            C28730ab c28730ab;
            AppMethodBeat.m2504i(68038);
            C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()));
            if (arrayList.size() > 0) {
                c28730ab = C28730ab.this;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) c28730ab.pvf.get(String.valueOf((Long) it.next()));
                    C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", str);
                    if (!C5046bo.isNullOrNil(str)) {
                        if (c28730ab.pvq == null) {
                            c28730ab.pvq = new ArrayList();
                        }
                        c28730ab.pvq.add(new C28729g(str, str));
                    }
                }
            }
            if (hashMap.size() > 0) {
                C28730ab.m45655a(C28730ab.this, (HashMap) hashMap);
            }
            C28730ab.this.mo46884Br(10);
            c28730ab = C28730ab.this;
            C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", Integer.valueOf(c28730ab.pvq.size()));
            if (c28730ab.pvq == null) {
                c28730ab.pvq = new ArrayList();
            }
            if (c28730ab.pvq.size() > 0) {
                C128813 c128813 = new C128813();
                C36464 c36464 = new C36464();
                C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", Integer.valueOf(c28730ab.pvq.size()));
                c28730ab.pvu = c128813;
                c28730ab.pvv = c36464;
                c28730ab.pvw = c28730ab.pvq.size();
                if (c28730ab.pvq != null && c28730ab.pvq.size() > 0) {
                    C28729g c28729g = (C28729g) c28730ab.pvq.remove(0);
                    c28730ab.pvr = c28729g.fileId;
                    c28730ab.pvs = c28729g.fileName;
                    c28730ab.pvt = new HashMap();
                    C1720g.m3535RO().eJo.mo14541a(new C28745u(c28730ab.pvs, c28730ab.pvr, c28730ab.pvx), 0);
                }
                AppMethodBeat.m2505o(68038);
                return;
            }
            c28730ab.mo46884Br(90);
            c28730ab.ccy();
            AppMethodBeat.m2505o(68038);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$g */
    public static class C28729g {
        public String fileId;
        public String fileName;

        public C28729g(String str, String str2) {
            this.fileId = str;
            this.fileName = str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$6 */
    class C287316 implements Runnable {
        C287316() {
        }

        public final void run() {
            AppMethodBeat.m2504i(68042);
            C28730ab.this.pvc.mo24911Vn(C28730ab.this.ptN);
            AppMethodBeat.m2505o(68042);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$a */
    interface C28732a {
        void ccA();
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$b */
    public interface C28733b {
        /* renamed from: a */
        void mo46883a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap);
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$c */
    public interface C28734c {
        void ccz();
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$d */
    public interface C28735d {
        /* renamed from: e */
        void mo8236e(int i, int i2, String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$5 */
    class C287365 implements C28732a {
        C287365() {
        }

        public final void ccA() {
            AppMethodBeat.m2504i(68041);
            C28730ab.this.mo46884Br(100);
            AppMethodBeat.m2505o(68041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ab$7 */
    class C287387 implements C32231g {
        C287387() {
        }

        /* renamed from: a */
        public final void mo8280a(int i, int i2, C1207m c1207m) {
            AppMethodBeat.m2504i(68043);
            C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", C28730ab.this.pvr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(C28730ab.this.pvq.size()));
            if (i >= i2) {
                C28730ab.this.pvt.put(C28730ab.this.pvs, ((C28745u) c1207m).ccv().ptE);
                C34749ah ccv = ((C28745u) c1207m).ccv();
                if (C28730ab.this.pvv != null) {
                    C28730ab.this.pvv.mo8236e(C28730ab.this.pvw - C28730ab.this.pvq.size(), C28730ab.this.pvw, C28730ab.this.pvs, ccv.ptE);
                }
                if (C28730ab.this.pvq.isEmpty()) {
                    C4990ab.m7416i("MicroMsg.ShareModeMailAppService", "finished send all files");
                    if (C28730ab.this.pvu != null) {
                        C28730ab.this.pvu.ccz();
                    }
                    AppMethodBeat.m2505o(68043);
                    return;
                }
                C4990ab.m7416i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
                C28729g c28729g = (C28729g) C28730ab.this.pvq.remove(0);
                C28730ab.this.pvr = c28729g.fileId;
                C28730ab.this.pvs = c28729g.fileName;
                C1720g.m3535RO().eJo.mo14541a(new C28745u(C28730ab.this.pvs, C28730ab.this.pvr, this), 0);
            }
            AppMethodBeat.m2505o(68043);
        }
    }

    public C28730ab() {
        AppMethodBeat.m2504i(68045);
        C1720g.m3535RO().eJo.mo14539a((int) C19517g.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(484, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(485, (C1202f) this);
        AppMethodBeat.m2505o(68045);
    }

    /* renamed from: X */
    public final void mo46885X(Map<String, String> map) {
        AppMethodBeat.m2504i(68046);
        this.pvf = new HashMap();
        this.pvf.putAll(map);
        AppMethodBeat.m2505o(68046);
    }

    /* renamed from: Y */
    public final void mo46886Y(Map<String, String> map) {
        AppMethodBeat.m2504i(68047);
        this.pvg = new LinkedHashMap();
        this.pvg.putAll(map);
        AppMethodBeat.m2505o(68047);
    }

    /* renamed from: Z */
    public final void mo46887Z(Map<String, String> map) {
        AppMethodBeat.m2504i(68048);
        this.pvh = new LinkedHashMap();
        this.pvh.putAll(map);
        AppMethodBeat.m2505o(68048);
    }

    /* renamed from: Br */
    public final void mo46884Br(final int i) {
        AppMethodBeat.m2504i(68049);
        if (this.pvl != null) {
            C5004al.m7441d(new Runnable() {
                final /* synthetic */ int fFn = 100;

                public final void run() {
                    AppMethodBeat.m2504i(68037);
                    C28730ab.this.pvl.mo24912ad(C28730ab.this.ptN, i, this.fFn);
                    AppMethodBeat.m2505o(68037);
                }
            });
        }
        AppMethodBeat.m2505o(68049);
    }

    public final void clearData() {
        AppMethodBeat.m2504i(68050);
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
        AppMethodBeat.m2505o(68050);
    }

    /* renamed from: a */
    public final void mo46888a(C12883f c12883f, C12882e c12882e) {
        AppMethodBeat.m2504i(68051);
        this.pvl = c12883f;
        this.pvc = c12882e;
        if (this.pvf.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.pvf.keySet()) {
                C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", str);
                arrayList.add(Long.valueOf(C5046bo.getLong(str, 0)));
            }
            m45657a(arrayList, new C287282());
            AppMethodBeat.m2505o(68051);
            return;
        }
        mo46884Br(90);
        ccy();
        AppMethodBeat.m2505o(68051);
    }

    /* Access modifiers changed, original: final */
    public final void ccy() {
        C12890a[] c12890aArr;
        int i;
        int i2;
        String str;
        C12890a[] c12890aArr2;
        int i3;
        int i4;
        C12890a[] c12890aArr3;
        C12890a[] c12890aArr4;
        StringBuilder stringBuilder;
        String stringBuilder2;
        AppMethodBeat.m2504i(68052);
        int i5 = 0;
        int i6 = 0;
        if (this.pvg == null || this.pvg.size() <= 0) {
            c12890aArr = null;
        } else {
            C12890a[] c12890aArr5 = new C12890a[this.pvg.size()];
            Iterator it = this.pvg.keySet().iterator();
            while (true) {
                i = i6;
                i2 = i5;
                if (!it.hasNext()) {
                    break;
                }
                str = (String) it.next();
                C12890a c12890a = new C12890a();
                c12890a.pux = (String) this.pvg.get(str);
                c12890a.fileName = str;
                c12890a.name = (String) this.pvh.get(str);
                c12890a.fileSize = (int) C5730e.asZ(str);
                c12890aArr5[i2] = c12890a;
                C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", Integer.valueOf(i2), c12890a.pux, c12890a.fileName, c12890a.name, Integer.valueOf(c12890a.fileSize));
                i5 = i2 + 1;
                i6 = c12890a.fileSize + i;
            }
            c12890aArr = c12890aArr5;
            i6 = i;
        }
        i5 = 0;
        if (this.pvk == null || this.pvk.size() <= 0) {
            c12890aArr2 = null;
            i3 = i6;
        } else {
            C12890a[] c12890aArr6 = new C12890a[this.pvk.size()];
            Iterator it2 = this.pvk.keySet().iterator();
            while (true) {
                i = i6;
                i4 = i5;
                if (!it2.hasNext()) {
                    break;
                }
                str = (String) it2.next();
                C12890a c12890a2 = new C12890a();
                c12890a2.pux = (String) this.pvk.get(str);
                c12890a2.fileName = str;
                c12890a2.fileSize = C5046bo.m7512a((Integer) this.pvo.get(c12890a2.pux), 0);
                if (c12890a2.fileSize == 0) {
                    c12890a2.fileSize = (int) C5730e.asZ(str);
                }
                c12890aArr6[i4] = c12890a2;
                C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", Integer.valueOf(i4), c12890a2.pux, c12890a2.fileName, Integer.valueOf(c12890a2.fileSize));
                i5 = i4 + 1;
                i6 = c12890a2.fileSize + i;
            }
            c12890aArr2 = c12890aArr6;
            i3 = i;
        }
        C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", Integer.valueOf(i3));
        if (c12890aArr2 == null || c12890aArr2.length == 0) {
            c12890aArr3 = null;
        } else {
            c12890aArr3 = c12890aArr2;
        }
        if (c12890aArr == null || c12890aArr.length == 0) {
            c12890aArr4 = null;
        } else {
            c12890aArr4 = c12890aArr;
        }
        final C287365 c287365 = new C287365();
        C12891q c12891q = new C12891q(this.cEV, this.pur, this.pus, this.put, this.ptN);
        c12891q.puu = this.pve;
        if (c12890aArr4 == null || c12890aArr4.length <= 0) {
            c12891q.puw = null;
        } else {
            c12891q.puw = new C12890a[c12890aArr4.length];
            for (i5 = 0; i5 < c12891q.puw.length; i5++) {
                c12891q.puw[i5] = c12890aArr4[i5];
            }
            C4990ab.m7417i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", Integer.valueOf(c12891q.puw.length));
        }
        if (c12890aArr3 == null || c12890aArr3.length <= 0) {
            c12891q.puv = null;
        } else {
            c12891q.puv = c12890aArr3;
        }
        StringBuilder stringBuilder3 = new StringBuilder("");
        StringBuilder stringBuilder4 = new StringBuilder("");
        if (c12891q.cEV != null) {
            stringBuilder = new StringBuilder("");
            stringBuilder.append("From: ");
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(c12891q.cEV.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(c12891q.cEV);
            stringBuilder.append(">");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = null;
        }
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder2 = c12891q.ccr();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder2 = c12891q.ccs();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder2 = c12891q.cct();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder4.append("Subject: ");
        if (c12891q.ptN != null) {
            stringBuilder4.append(c12891q.ptN);
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
        stringBuilder.append(Base64.encodeToString(c12891q.puu.getBytes(), 0));
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        if (c12891q.puv != null && c12891q.puv.length > 0) {
            for (C12890a c12890a3 : c12891q.puv) {
                String str2 = c12890a3.pux;
                String str3 = c12890a3.fileName;
                int i7 = c12890a3.fileSize;
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
                stringBuilder5.append(String.format("QQMail-Key:%s", new Object[]{C12891q.m20885Vk(str2)}));
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder5.append("QQMail-LinkEnd");
                stringBuilder5.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder3.append(stringBuilder5.toString());
                stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        if (c12891q.puw != null && c12891q.puw.length > 0) {
            for (C12890a c12890a4 : c12891q.puw) {
                String str4 = c12890a4.pux;
                int i8 = c12890a4.fileSize;
                String str5 = c12890a4.name;
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
                stringBuilder6.append(String.format("QQMail-Key:%s", new Object[]{C12891q.m20885Vk(str4)}));
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder6.append("QQMail-LinkEnd");
                stringBuilder6.append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder3.append(stringBuilder6.toString());
                stringBuilder3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        stringBuilder3.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        C1720g.m3535RO().eJo.mo14541a(new C28743s(stringBuilder3.toString(), this.cEV, this.pur, i3, new C32231g() {
            /* renamed from: a */
            public final void mo8280a(int i, int i2, C1207m c1207m) {
                AppMethodBeat.m2504i(68044);
                C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i >= i2) {
                    C4990ab.m7416i("MicroMsg.ShareModeMailAppService", "finish send");
                    if (c287365 != null) {
                        c287365.ccA();
                    }
                }
                AppMethodBeat.m2505o(68044);
            }
        }), 0);
        AppMethodBeat.m2505o(68052);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(68053);
        C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0 || i2 != 0) {
            C4990ab.m7413e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (c1207m.getType() == C19517g.CTRL_INDEX) {
                m45656a((C21522r) c1207m);
                AppMethodBeat.m2505o(68053);
                return;
            }
            if (this.pvc != null) {
                C5004al.m7441d(new C287316());
            }
            AppMethodBeat.m2505o(68053);
        } else if (c1207m.getType() == C19517g.CTRL_INDEX) {
            m45656a((C21522r) c1207m);
            AppMethodBeat.m2505o(68053);
        } else {
            if (c1207m.getType() != 484) {
                c1207m.getType();
            }
            AppMethodBeat.m2505o(68053);
        }
    }

    /* renamed from: O */
    private void m45654O(ArrayList<Long> arrayList) {
        AppMethodBeat.m2504i(68054);
        if (this.pvm != null) {
            this.pvm.clear();
            this.pvm = null;
        }
        this.pvm = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.pvm.put(Long.valueOf(((Long) it.next()).longValue()), Integer.valueOf(1));
        }
        AppMethodBeat.m2505o(68054);
    }

    /* renamed from: a */
    private void m45657a(ArrayList<Long> arrayList, C28733b c28733b) {
        AppMethodBeat.m2504i(68055);
        C4990ab.m7416i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
        this.pvp = 0;
        m45654O(arrayList);
        if (this.pvn != null) {
            this.pvn.clear();
            this.pvn = null;
        }
        this.pvn = new HashMap();
        this.pvi = c28733b;
        C1720g.m3535RO().eJo.mo14541a(new C21522r(arrayList), 0);
        AppMethodBeat.m2505o(68055);
    }

    /* renamed from: m */
    private static ArrayList<Long> m45658m(HashMap<Long, Integer> hashMap) {
        AppMethodBeat.m2504i(68056);
        ArrayList arrayList = new ArrayList();
        for (Long add : hashMap.keySet()) {
            arrayList.add(add);
        }
        AppMethodBeat.m2505o(68056);
        return arrayList;
    }

    /* renamed from: a */
    private void m45656a(C21522r c21522r) {
        AppMethodBeat.m2504i(68057);
        this.pvp++;
        C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", Integer.valueOf(this.pvp));
        Iterator it = c21522r.ccu().iterator();
        while (it.hasNext()) {
            C46148g c46148g = (C46148g) it.next();
            long j = (long) c46148g.ptD;
            int i = c46148g.jBT;
            if (this.pvm.containsKey(Long.valueOf(j))) {
                C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", Long.valueOf(j), Integer.valueOf(i));
                if (i == 0) {
                    this.pvm.remove(Long.valueOf(j));
                    if (c46148g.ptE != null) {
                        C4990ab.m7417i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", Long.valueOf(j), c46148g.ptE);
                        this.pvn.put(Long.valueOf(j), c46148g.ptE);
                        this.pvo.put(c46148g.ptE, Integer.valueOf(c46148g.FileSize));
                    }
                } else {
                    this.pvm.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }
        if (this.pvm.isEmpty()) {
            C4990ab.m7416i("MicroMsg.ShareModeMailAppService", "all image is in server");
            if (this.pvi != null) {
                this.pvi.mo46883a(new ArrayList(), this.pvn);
            }
            AppMethodBeat.m2505o(68057);
        } else if (this.pvp < 3) {
            C4990ab.m7416i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
            C1720g.m3535RO().eJo.mo14541a(new C21522r(C28730ab.m45658m(this.pvm)), 0);
            AppMethodBeat.m2505o(68057);
        } else {
            this.pvi.mo46883a(C28730ab.m45658m(this.pvm), this.pvn);
            AppMethodBeat.m2505o(68057);
        }
    }
}
