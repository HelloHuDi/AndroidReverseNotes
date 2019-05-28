package com.tencent.p177mm.p182ah;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.emoji.p725b.C27730c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.auk;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p605a.C4941c;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/* renamed from: com.tencent.mm.ah.c */
public final class C41731c implements C1202f {
    boolean frc = false;
    Set<String> frd = Collections.synchronizedSet(new HashSet());
    C1177f<String, C17878d> fre = new C7598c(400);
    Stack<C17880h> frf = new Stack();
    private C23498az frg = null;
    private C23498az frh = null;
    String fri = null;
    C1177f<String, String> frj = new C7598c(200);
    C7564ap frk = new C7564ap(Looper.getMainLooper(), new C322263(), false);

    /* renamed from: com.tencent.mm.ah.c$d */
    static class C17878d {
        public long eRt;
        public int eRu;

        private C17878d() {
            this.eRt = 0;
            this.eRu = 0;
        }

        /* synthetic */ C17878d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ah.c$c */
    class C31258c implements C23499a {
        Bitmap fru = null;
        String username = null;

        public C31258c(String str) {
            this.username = str;
        }

        public final boolean acf() {
            C17880h c17880h = null;
            int i = 0;
            AppMethodBeat.m2504i(77858);
            if (C5046bo.isNullOrNil(this.username)) {
                AppMethodBeat.m2505o(77858);
                return false;
            }
            boolean z;
            String str = this.username;
            if (str == null) {
                z = false;
            } else {
                z = str.startsWith("ammURL_");
            }
            if (z) {
                String str2 = (String) C41731c.this.frj.get(str);
                if (!C5046bo.isNullOrNil(str2)) {
                    C17880h qo = C17884o.act().mo33392qo(str);
                    if (qo == null || !str.equals(qo.getUsername())) {
                        C17881i act = C17884o.act();
                        Cursor a = act.fni.mo10104a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + C5046bo.m7586vA(str2) + "\"", null, 2);
                        if (a != null) {
                            if (a.moveToFirst()) {
                                a.moveToFirst();
                                c17880h = new C17880h();
                                c17880h.mo33386d(a);
                            }
                            a.close();
                        }
                        if (!(c17880h == null || C5046bo.isNullOrNil(c17880h.getUsername()))) {
                            C5730e.m8644y(C41730b.m73505pX(c17880h.getUsername()), C41730b.m73505pX(str));
                        }
                        c17880h = new C17880h();
                        c17880h.username = str;
                        c17880h.dtR = 3;
                        c17880h.frV = str2;
                        c17880h.frW = str2;
                        c17880h.bJt = 3;
                        c17880h.mo33385cB(true);
                        c17880h.bJt = 31;
                        C17884o.act().mo33391b(c17880h);
                    }
                }
            }
            C41732d acd = C41731c.acd();
            if (acd == null) {
                AppMethodBeat.m2505o(77858);
                return false;
            }
            if (C41732d.frx.containsKey(this.username)) {
                i = ((Integer) C41732d.frx.get(this.username)).intValue();
            }
            if (i != 0) {
                C17884o.acs();
                Context context = C17884o.getContext();
                if (context != null) {
                    acd.mo67505f(this.username, C1434a.decodeResource(context.getResources(), i));
                }
            }
            this.fru = C41732d.m73525qf(this.username);
            AppMethodBeat.m2505o(77858);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(77859);
            if (this.fru == null) {
                C17880h c17880h;
                C41731c c41731c = C41731c.this;
                String str = this.username;
                C4990ab.m7411d("MicroMsg.AvatarService", "avatar service push: %s", str);
                if (C5046bo.isNullOrNil(str)) {
                    c17880h = null;
                } else if (str.equals(c41731c.fri + "@bottle") && !C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(60, null), false)) {
                    c17880h = null;
                } else if (!str.equals(c41731c.fri) || C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(59, null), false)) {
                    long anT = C5046bo.anT();
                    C17878d c17878d = (C17878d) c41731c.fre.mo4404ai(str);
                    if (c17878d == null || c17878d.eRu < 5 || anT - c17878d.eRt >= 600) {
                        C17880h qb = C41731c.m73507qb(str);
                        if (qb == null) {
                            C4990ab.m7421w("MicroMsg.AvatarService", "checkUser block local no need: %s", str);
                            c17878d = new C17878d();
                            c17878d.eRu = 5;
                            c17878d.eRt = anT;
                            c41731c.fre.mo4412k(str, c17878d);
                            c17880h = null;
                        } else {
                            if (c17878d == null || anT - c17878d.eRt > 600) {
                                C4990ab.m7411d("MicroMsg.AvatarService", "new user: %s", str);
                                c17878d = new C17878d();
                                c17878d.eRu = 1;
                                c17878d.eRt = anT;
                                c41731c.fre.mo4412k(str, c17878d);
                            } else if (c17878d.eRu < 5) {
                                C4990ab.m7411d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", str, Integer.valueOf(c17878d.eRu), Long.valueOf(anT - c17878d.eRt));
                                c17878d.eRu++;
                                c17878d.eRt = anT;
                                c41731c.fre.mo4412k(str, c17878d);
                            }
                            c17880h = qb;
                        }
                    } else {
                        C4990ab.m7421w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", str);
                        c17880h = null;
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
                    c17880h = null;
                }
                if (c17880h == null) {
                    c41731c.frd.remove(str);
                } else if (C5046bo.isNullOrNil(c17880h.acl())) {
                    C4990ab.m7421w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(c17880h.dtR));
                    if (4 == c17880h.dtR) {
                        C4990ab.m7420w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
                    } else {
                        c41731c.frf.push(c17880h);
                        if (c41731c.frf.size() > 5) {
                            c41731c.frk.mo16770ae(0, 0);
                        } else {
                            c41731c.frk.mo16770ae(1000, 1000);
                        }
                    }
                } else {
                    c41731c.mo67492a(new C32228b(c17880h));
                }
                AppMethodBeat.m2505o(77859);
                return false;
            }
            C41732d acd = C41731c.acd();
            if (acd != null) {
                acd.mo67504e(this.username, this.fru);
            }
            C41731c.this.frd.remove(this.username);
            AppMethodBeat.m2505o(77859);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ah.c$3 */
    class C322263 implements C5015a {
        private long frn = 0;

        C322263() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(77853);
            long currentTimeMillis = System.currentTimeMillis();
            if (C41731c.this.frc && currentTimeMillis - this.frn > 60000) {
                C4990ab.m7421w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", Long.valueOf(currentTimeMillis - this.frn));
                C41731c.this.frc = false;
            }
            if (C41731c.this.frc) {
                C41731c.this.frk.mo16770ae(1000, 1000);
                AppMethodBeat.m2505o(77853);
            } else {
                this.frn = currentTimeMillis;
                C41731c.this.frc = true;
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < 5 && C41731c.this.frf.size() > 0; i++) {
                    C7060h.pYm.mo8378a(138, 42, 1, true);
                    linkedList.add(new bts().alV(C5046bo.nullAsNil(((C17880h) C41731c.this.frf.pop()).getUsername())));
                }
                C1720g.m3540Rg().mo14541a(new C25751j(linkedList), 0);
                C7060h.pYm.mo8378a(138, 44, 1, true);
                AppMethodBeat.m2505o(77853);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ah.c$a */
    class C32227a implements C23499a {
        C17880h fro;
        byte[] frp;
        boolean frq;
        byte[] frr;

        public C32227a(C17880h c17880h, byte[] bArr, boolean z) {
            this.fro = c17880h;
            this.frp = bArr;
            this.frq = z;
        }

        public final boolean acf() {
            byte[] bArr;
            AppMethodBeat.m2504i(77854);
            if (this.frq) {
                C4990ab.m7416i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
                C7060h.pYm.mo15419k(138, 51, 1);
                byte[] DecryptAvatar = UtilsJni.DecryptAvatar(this.frp);
                if (C5046bo.m7540cb(DecryptAvatar)) {
                    C7060h.pYm.mo15419k(138, 52, 1);
                    C4990ab.m7416i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
                    AppMethodBeat.m2505o(77854);
                    return false;
                }
                bArr = DecryptAvatar;
            } else {
                bArr = this.frp;
            }
            if (C5063r.m7679bU(bArr)) {
                C4990ab.m7416i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
                C7060h.pYm.mo15419k(138, 53, 1);
                this.frr = ((C27730c) C1720g.m3528K(C27730c.class)).mo45565aE(bArr);
                if (C5046bo.m7540cb(this.frr)) {
                    C7060h.pYm.mo15419k(138, 54, 1);
                    C4990ab.m7416i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
                    AppMethodBeat.m2505o(77854);
                    return false;
                }
            }
            this.frr = bArr;
            AppMethodBeat.m2505o(77854);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(77855);
            if (C5046bo.m7540cb(this.frr)) {
                C4990ab.m7416i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
                AppMethodBeat.m2505o(77855);
                return false;
            }
            C4990ab.m7417i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", Integer.valueOf(this.frr.length));
            C41731c.this.mo67492a(new C32229e(this.fro, this.frr));
            AppMethodBeat.m2505o(77855);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ah.c$b */
    class C32228b implements C23499a {
        public boolean frq = false;
        public C17880h frs = null;
        public byte[] frt = null;

        public C32228b(C17880h c17880h) {
            this.frs = c17880h;
        }

        public final boolean acf() {
            C7060h c7060h;
            Object[] objArr;
            AppMethodBeat.m2504i(77856);
            if (this.frs == null) {
                AppMethodBeat.m2505o(77856);
                return false;
            }
            String str;
            String str2;
            if (!C5023at.isNetworkConnected(C4996ah.getContext())) {
                C4990ab.m7420w("MicroMsg.HttpGetAvatar", "[tomys] network is unavailable, skip rest loading logic.");
                C4990ab.dot();
            }
            String acl = this.frs.acl();
            boolean biY = ((C27730c) C1720g.m3528K(C27730c.class)).biY();
            boolean a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_avatar_download_small_hevc, false);
            if (biY && a) {
                C4990ab.m7416i("MicroMsg.HttpGetAvatar", "HttpGetAvatar: get hevc");
                if (acl.contains("?")) {
                    str = acl + "&tp=wxpic";
                } else {
                    str = acl + "?tp=wxpic";
                }
                C7060h.pYm.mo15419k(138, 50, 1);
                str2 = str;
            } else {
                str2 = acl;
            }
            str = "";
            if (C1720g.m3534RN().mo5161QY()) {
                r1 = new Object[4];
                C1720g.m3534RN();
                r1[1] = C1183p.getString(C1668a.m3383QF());
                r1[2] = Integer.valueOf(C5023at.getNetTypeForStat(C4996ah.getContext()));
                r1[3] = Integer.valueOf(C5023at.getStrength(C4996ah.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r1);
            }
            C4990ab.m7411d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", this.frs.getUsername(), str);
            this.frt = null;
            C1936u c1936u = null;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = null;
            C7060h.pYm.mo8378a(138, 40, 1, true);
            try {
                c1936u = C1897b.m4020a(str2, null);
                c1936u.setRequestMethod("GET");
                c1936u.setRequestProperty("referer", str);
                c1936u.setConnectTimeout(5000);
                c1936u.setReadTimeout(5000);
                if (C1897b.m4017a(c1936u) != 0) {
                    int responseCode = c1936u.getResponseCode();
                    Map headerFields = c1936u.getHeaderFields();
                    List list = headerFields != null ? (List) headerFields.get("X-ErrNo") : null;
                    str = (list == null || list.size() <= 0) ? "" : (String) list.get(0);
                    C4990ab.m7413e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d xErr:%s", str2, Integer.valueOf(responseCode), str);
                    switch (responseCode) {
                        case 404:
                            C7060h.pYm.mo8378a(138, 2, 1, true);
                            C7060h.pYm.mo8381e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), c1936u.gdF, Integer.valueOf(c1936u.gcI), c1936u.url.getHost(), str2, str);
                            break;
                        case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                            C7060h.pYm.mo8378a(138, 3, 1, true);
                            C7060h.pYm.mo8381e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), c1936u.gdF, Integer.valueOf(c1936u.gcI), c1936u.url.getHost(), str2, str);
                            break;
                        case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                            C7060h.pYm.mo8378a(138, 4, 1, true);
                            C7060h.pYm.mo8381e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), c1936u.gdF, Integer.valueOf(c1936u.gcI), c1936u.url.getHost(), str2, str);
                            break;
                        case 504:
                            C7060h.pYm.mo8378a(138, 5, 1, true);
                            C7060h.pYm.mo8381e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), c1936u.gdF, Integer.valueOf(c1936u.gcI), c1936u.url.getHost(), str2, str);
                            break;
                        default:
                            C7060h.pYm.mo8378a(138, 6, 1, true);
                            C7060h.pYm.mo8381e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), c1936u.gdF, Integer.valueOf(c1936u.gcI), c1936u.url.getHost(), str2, str);
                            break;
                    }
                    AppMethodBeat.m2505o(77856);
                    return true;
                }
                if (c1936u.getHeaderFieldInt("X-Enc", 0) == 1) {
                    a = true;
                } else {
                    a = false;
                }
                this.frq = a;
                int contentLength = c1936u.connection.getContentLength();
                inputStream = c1936u.getInputStream();
                if (inputStream == null) {
                    C4990ab.m7411d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", str2);
                    AppMethodBeat.m2505o(77856);
                    return true;
                }
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                C7060h.pYm.mo8378a(138, 41, 1, true);
                if (C4872b.dnO()) {
                    C7060h.pYm.mo8381e(14058, Integer.valueOf(100001), Integer.valueOf(C1625i.sHCENCODEVIDEOTIMEOUT), "", Integer.valueOf(contentLength), this.frs.getUsername(), c1936u.gdF, Integer.valueOf(c1936u.gcI), c1936u.url.getHost(), str2, "");
                }
                this.frt = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                byteArrayOutputStream = null;
                c1936u.connection.disconnect();
                c1936u = null;
                inputStream.close();
                inputStream = null;
                if (contentLength > 0 && this.frt.length < contentLength) {
                    C7060h.pYm.mo8378a(138, 15, 1, true);
                    C4990ab.m7412e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
                }
                if (c1936u != null) {
                    try {
                        c1936u.connection.disconnect();
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.HttpGetAvatar", "exception:%s", C5046bo.m7574l(e));
                        C4990ab.m7413e("MicroMsg.HttpGetAvatar", "close conn failed : %s", e.getMessage());
                        C7060h.pYm.mo8378a(138, 9, 1, true);
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                AppMethodBeat.m2505o(77856);
                return true;
            } catch (ProtocolException e2) {
                ProtocolException protocolException = e2;
                C7060h.pYm.mo8378a(138, 1, 1, true);
                c7060h = C7060h.pYm;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10001);
                objArr[2] = protocolException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.frs.getUsername();
                if (c1936u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1936u.gdF;
                }
                objArr[5] = str;
                objArr[6] = c1936u == null ? BuildConfig.COMMAND : Integer.valueOf(c1936u.gcI);
                if (c1936u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1936u.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = "";
                c7060h.mo8381e(14058, objArr);
                C4990ab.m7413e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", str2, protocolException.getClass().getSimpleName(), protocolException.getMessage());
            } catch (SocketTimeoutException e3) {
                SocketTimeoutException socketTimeoutException = e3;
                C7060h.pYm.mo8378a(138, 8, 1, true);
                c7060h = C7060h.pYm;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10002);
                objArr[2] = socketTimeoutException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.frs.getUsername();
                if (c1936u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1936u.gdF;
                }
                objArr[5] = str;
                objArr[6] = c1936u == null ? BuildConfig.COMMAND : Integer.valueOf(c1936u.gcI);
                if (c1936u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1936u.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = "";
                c7060h.mo8381e(14058, objArr);
                C4990ab.m7413e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", str2, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
            } catch (IOException e4) {
                IOException iOException = e4;
                C7060h.pYm.mo8378a(138, 7, 1, true);
                c7060h = C7060h.pYm;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = iOException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.frs.getUsername();
                if (c1936u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1936u.gdF;
                }
                objArr[5] = str;
                objArr[6] = c1936u == null ? BuildConfig.COMMAND : Integer.valueOf(c1936u.gcI);
                if (c1936u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1936u.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = "";
                c7060h.mo8381e(14058, objArr);
                C4990ab.m7413e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", str2, iOException.getClass().getSimpleName(), iOException.getMessage());
            } catch (Exception e5) {
                Exception exception = e5;
                C7060h.pYm.mo8378a(138, 0, 1, true);
                c7060h = C7060h.pYm;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = exception.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.frs.getUsername();
                if (c1936u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1936u.gdF;
                }
                objArr[5] = str;
                objArr[6] = c1936u == null ? BuildConfig.COMMAND : Integer.valueOf(c1936u.gcI);
                if (c1936u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = c1936u.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = "";
                c7060h.mo8381e(14058, objArr);
                C4990ab.m7413e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", str2, exception.getClass().getSimpleName(), exception.getMessage());
            }
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(77857);
            if (this.frs == null || C5046bo.isNullOrNil(this.frs.getUsername())) {
                AppMethodBeat.m2505o(77857);
            } else if (C5046bo.m7540cb(this.frt)) {
                C41731c.this.frd.remove(this.frs.getUsername());
                C7060h.pYm.mo8378a(138, 10, 1, true);
                AppMethodBeat.m2505o(77857);
            } else {
                if (C26417a.flv != null) {
                    C26417a.flv.mo44184cm(this.frt.length, 0);
                }
                C41731c.this.mo67492a(new C32227a(this.frs, this.frt, this.frq));
                AppMethodBeat.m2505o(77857);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ah.c$e */
    class C32229e implements C23499a {
        Bitmap bitmap = null;
        byte[] buf;
        C17880h fro = null;

        public C32229e(C17880h c17880h, byte[] bArr) {
            this.fro = c17880h;
            this.buf = bArr;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(77860);
            if (this.fro == null || C5046bo.isNullOrNil(this.fro.getUsername())) {
                C4990ab.m7412e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
                C7060h.pYm.mo8378a(138, 13, 1, true);
                AppMethodBeat.m2505o(77860);
                return false;
            }
            if (C41731c.acd() != null) {
                this.bitmap = C41732d.m73522m(this.fro.getUsername(), this.buf);
                if (this.bitmap == null) {
                    C7060h.pYm.mo8378a(138, 14, 1, true);
                }
            }
            C17881i ace = C41731c.ace();
            if (ace != null) {
                this.fro.bJt = -1;
                this.fro.acm();
                ace.mo33391b(this.fro);
            }
            AppMethodBeat.m2505o(77860);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(77861);
            if (C5046bo.isNullOrNil(this.fro.getUsername())) {
                AppMethodBeat.m2505o(77861);
            } else {
                C41732d acd = C41731c.acd();
                if (!(acd == null || this.bitmap == null)) {
                    acd.mo67504e(this.fro.getUsername(), this.bitmap);
                }
                C41731c.this.frd.remove(this.fro.getUsername());
                AppMethodBeat.m2505o(77861);
            }
            return false;
        }
    }

    public C41731c() {
        AppMethodBeat.m2504i(77862);
        C1720g.m3540Rg().mo14539a(123, (C1202f) this);
        this.frc = false;
        this.fri = C1853r.m3846Yz();
        AppMethodBeat.m2505o(77862);
    }

    /* renamed from: b */
    public final Bitmap mo67493b(String str, boolean z, int i) {
        Bitmap bitmap;
        AppMethodBeat.m2504i(77863);
        C41732d acd = C41731c.acd();
        if (acd != null) {
            if (i < 0 || i <= 5) {
                bitmap = null;
            } else {
                bitmap = C41732d.m73523qd(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}));
                if (bitmap != null) {
                    C4990ab.m7417i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", Integer.valueOf(i));
                    AppMethodBeat.m2505o(77863);
                    return bitmap;
                }
                C4990ab.m7417i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", Integer.valueOf(i));
            }
            if (bitmap == null) {
                bitmap = C41732d.m73523qd(str);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (i >= 0 && i > 5) {
                C4990ab.m7417i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", Integer.valueOf(i));
                bitmap = C5056d.m7616a(bitmap, false, (float) i);
                acd.mo67504e(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}), bitmap);
            }
            AppMethodBeat.m2505o(77863);
            return bitmap;
        } else if (z) {
            AppMethodBeat.m2505o(77863);
            return null;
        } else {
            C4990ab.m7419v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", str);
            if (this.frd.contains(str)) {
                AppMethodBeat.m2505o(77863);
                return null;
            }
            this.frd.add(str);
            mo67492a(new C31258c(str));
            AppMethodBeat.m2505o(77863);
            return null;
        }
    }

    /* renamed from: pZ */
    public final void mo67495pZ(String str) {
        AppMethodBeat.m2504i(77864);
        mo67492a(new C31258c(str));
        AppMethodBeat.m2505o(77864);
    }

    /* renamed from: qa */
    public final void mo67496qa(final String str) {
        AppMethodBeat.m2504i(77865);
        C7305d.xDH.mo10142ak(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(77850);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(77850);
                } else if (str.equals(C41731c.this.fri)) {
                    AppMethodBeat.m2505o(77850);
                } else {
                    C17881i ace = C41731c.ace();
                    if (ace == null) {
                        AppMethodBeat.m2505o(77850);
                        return;
                    }
                    C17880h qo = ace.mo33392qo(str);
                    if (qo == null || !qo.getUsername().equals(str)) {
                        AppMethodBeat.m2505o(77850);
                        return;
                    }
                    int i;
                    if (C5046bo.anT() - (((long) qo.frY) * 60) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        AppMethodBeat.m2505o(77850);
                    } else if (C5046bo.isNullOrNil(qo.acl())) {
                        C4990ab.m7421w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", str);
                        AppMethodBeat.m2505o(77850);
                    } else if (C41731c.acd() == null) {
                        AppMethodBeat.m2505o(77850);
                    } else {
                        C41732d.m73516E(str, false);
                        C41732d.m73516E(str, true);
                        C41731c.this.mo67495pZ(str);
                        AppMethodBeat.m2505o(77850);
                    }
                }
            }

            public final String toString() {
                AppMethodBeat.m2504i(77851);
                String str = super.toString() + "|checkAvatarExpire";
                AppMethodBeat.m2505o(77851);
                return str;
            }
        });
        AppMethodBeat.m2505o(77865);
    }

    /* renamed from: qb */
    static C17880h m73507qb(String str) {
        AppMethodBeat.m2504i(77866);
        C17880h qo = C17884o.act().mo33392qo(str);
        if (qo == null || !qo.getUsername().equals(str)) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO == null || !aoO.field_username.equals(str)) {
                boolean z;
                String str2 = "MicroMsg.AvatarService";
                String str3 = "ct == null? :%s";
                Object[] objArr = new Object[2];
                if (aoO == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = str;
                C4990ab.m7411d(str2, str3, objArr);
                AppMethodBeat.m2505o(77866);
                return null;
            } else if (aoO.dtR == 4) {
                C41730b.m73489U(str, aoO.dtR);
                C4990ab.m7411d("MicroMsg.AvatarService", "ct imgFlag :%s", Integer.valueOf(aoO.dtR));
                AppMethodBeat.m2505o(77866);
                return null;
            } else {
                qo = new C17880h();
                qo.username = str;
                qo.dtR = 3;
                byte[] aoS = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoS(str);
                if (C5046bo.m7540cb(aoS)) {
                    C4990ab.m7417i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", str);
                    AppMethodBeat.m2505o(77866);
                    return qo;
                }
                C17880h a;
                try {
                    a = C41730b.m73491a(str, (bbv) new bbv().parseFrom(aoS));
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.AvatarService", "exception:%s", C5046bo.m7574l(e));
                    a = qo;
                }
                C4990ab.m7417i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", a.acl(), a.ack(), str);
                AppMethodBeat.m2505o(77866);
                return a;
            }
        }
        C4990ab.m7417i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", qo.acl(), str);
        AppMethodBeat.m2505o(77866);
        return qo;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(77867);
        while (this.frf.size() > 0) {
            this.frd.remove(this.frf.pop());
        }
        AppMethodBeat.m2505o(77867);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo67492a(final C23499a c23499a) {
        AppMethodBeat.m2504i(77868);
        C4941c c4941c = C7305d.xDH;
        C7305d.xDH.mo10142ak(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(77852);
                c23499a.acf();
                c23499a.acg();
                AppMethodBeat.m2505o(77852);
            }
        });
        AppMethodBeat.m2505o(77868);
        return 1;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(77869);
        if (c1207m == null) {
            AppMethodBeat.m2505o(77869);
        } else if (c1207m.getType() != 123) {
            AppMethodBeat.m2505o(77869);
        } else {
            if (!(i == 0 && i2 == 0)) {
                C7060h.pYm.mo8378a(138, 12, 1, true);
            }
            C7060h.pYm.mo8378a(138, 45, 1, true);
            C25751j c25751j = (C25751j) c1207m;
            HashSet hashSet = new HashSet();
            if (c25751j.fsb != null) {
                Iterator it = c25751j.fsb.iterator();
                while (it.hasNext()) {
                    auk auk = (auk) it.next();
                    String str2 = auk.wyu.wVI;
                    if (auk.vEF == null || auk.vEF.getBuffer() == null || auk.vEF.getBuffer().f1226wR == null) {
                        C7060h.pYm.mo8378a(138, 11, 1, true);
                    } else {
                        hashSet.add(str2);
                        C17880h c17880h = new C17880h();
                        c17880h.username = str2;
                        c17880h.dtR = 3;
                        C7060h.pYm.mo8378a(138, 43, 1, true);
                        mo67492a(new C32229e(c17880h, auk.vEF.getBuffer().f1226wR));
                    }
                }
            }
            if (c25751j.fsa != null) {
                Iterator it2 = c25751j.fsa.iterator();
                while (it2.hasNext()) {
                    bts bts = (bts) it2.next();
                    if (bts != null) {
                        String str3 = bts.wVI;
                        if (!hashSet.contains(str3)) {
                            this.frd.remove(str3);
                        }
                    }
                }
            }
            this.frc = false;
            if (this.frf.size() > 0) {
                this.frk.mo16770ae(0, 0);
            }
            AppMethodBeat.m2505o(77869);
        }
    }

    static C41732d acd() {
        AppMethodBeat.m2504i(77870);
        if (C1720g.m3534RN().mo5161QY()) {
            C41732d acd = C17884o.acd();
            AppMethodBeat.m2505o(77870);
            return acd;
        }
        AppMethodBeat.m2505o(77870);
        return null;
    }

    /* renamed from: qc */
    public final String mo67497qc(String str) {
        AppMethodBeat.m2504i(77871);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(77871);
            return str2;
        }
        try {
            str2 = String.format("%s%x_%s", new Object[]{"ammURL_", Integer.valueOf(str.hashCode()), str.substring(str.length() - 24, str.length() - 4)});
        } catch (Exception e) {
            str2 = String.format("%s%x_", new Object[]{"ammURL_", Integer.valueOf(str.hashCode())});
        }
        this.frj.put(str2, str);
        AppMethodBeat.m2505o(77871);
        return str2;
    }

    static /* synthetic */ C17881i ace() {
        AppMethodBeat.m2504i(77872);
        if (C1720g.m3534RN().mo5161QY()) {
            C17881i act = C17884o.act();
            AppMethodBeat.m2505o(77872);
            return act;
        }
        AppMethodBeat.m2505o(77872);
        return null;
    }
}
