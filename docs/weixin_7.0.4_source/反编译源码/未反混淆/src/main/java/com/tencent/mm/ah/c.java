package com.tencent.mm.ah;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.ad;
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

public final class c implements f {
    boolean frc = false;
    Set<String> frd = Collections.synchronizedSet(new HashSet());
    com.tencent.mm.a.f<String, d> fre = new com.tencent.mm.memory.a.c(400);
    Stack<h> frf = new Stack();
    private az frg = null;
    private az frh = null;
    String fri = null;
    com.tencent.mm.a.f<String, String> frj = new com.tencent.mm.memory.a.c(200);
    ap frk = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        private long frn = 0;

        public final boolean BI() {
            AppMethodBeat.i(77853);
            long currentTimeMillis = System.currentTimeMillis();
            if (c.this.frc && currentTimeMillis - this.frn > 60000) {
                ab.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", Long.valueOf(currentTimeMillis - this.frn));
                c.this.frc = false;
            }
            if (c.this.frc) {
                c.this.frk.ae(1000, 1000);
                AppMethodBeat.o(77853);
            } else {
                this.frn = currentTimeMillis;
                c.this.frc = true;
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < 5 && c.this.frf.size() > 0; i++) {
                    h.pYm.a(138, 42, 1, true);
                    linkedList.add(new bts().alV(bo.nullAsNil(((h) c.this.frf.pop()).getUsername())));
                }
                g.Rg().a(new j(linkedList), 0);
                h.pYm.a(138, 44, 1, true);
                AppMethodBeat.o(77853);
            }
            return false;
        }
    }, false);

    static class d {
        public long eRt;
        public int eRu;

        private d() {
            this.eRt = 0;
            this.eRu = 0;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    class c implements com.tencent.mm.sdk.platformtools.az.a {
        Bitmap fru = null;
        String username = null;

        public c(String str) {
            this.username = str;
        }

        public final boolean acf() {
            h hVar = null;
            int i = 0;
            AppMethodBeat.i(77858);
            if (bo.isNullOrNil(this.username)) {
                AppMethodBeat.o(77858);
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
                String str2 = (String) c.this.frj.get(str);
                if (!bo.isNullOrNil(str2)) {
                    h qo = o.act().qo(str);
                    if (qo == null || !str.equals(qo.getUsername())) {
                        i act = o.act();
                        Cursor a = act.fni.a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bo.vA(str2) + "\"", null, 2);
                        if (a != null) {
                            if (a.moveToFirst()) {
                                a.moveToFirst();
                                hVar = new h();
                                hVar.d(a);
                            }
                            a.close();
                        }
                        if (!(hVar == null || bo.isNullOrNil(hVar.getUsername()))) {
                            com.tencent.mm.vfs.e.y(b.pX(hVar.getUsername()), b.pX(str));
                        }
                        hVar = new h();
                        hVar.username = str;
                        hVar.dtR = 3;
                        hVar.frV = str2;
                        hVar.frW = str2;
                        hVar.bJt = 3;
                        hVar.cB(true);
                        hVar.bJt = 31;
                        o.act().b(hVar);
                    }
                }
            }
            d acd = c.acd();
            if (acd == null) {
                AppMethodBeat.o(77858);
                return false;
            }
            if (d.frx.containsKey(this.username)) {
                i = ((Integer) d.frx.get(this.username)).intValue();
            }
            if (i != 0) {
                o.acs();
                Context context = o.getContext();
                if (context != null) {
                    acd.f(this.username, com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), i));
                }
            }
            this.fru = d.qf(this.username);
            AppMethodBeat.o(77858);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(77859);
            if (this.fru == null) {
                h hVar;
                c cVar = c.this;
                String str = this.username;
                ab.d("MicroMsg.AvatarService", "avatar service push: %s", str);
                if (bo.isNullOrNil(str)) {
                    hVar = null;
                } else if (str.equals(cVar.fri + "@bottle") && !bo.a((Boolean) g.RP().Ry().get(60, null), false)) {
                    hVar = null;
                } else if (!str.equals(cVar.fri) || bo.a((Boolean) g.RP().Ry().get(59, null), false)) {
                    long anT = bo.anT();
                    d dVar = (d) cVar.fre.ai(str);
                    if (dVar == null || dVar.eRu < 5 || anT - dVar.eRt >= 600) {
                        h qb = c.qb(str);
                        if (qb == null) {
                            ab.w("MicroMsg.AvatarService", "checkUser block local no need: %s", str);
                            dVar = new d();
                            dVar.eRu = 5;
                            dVar.eRt = anT;
                            cVar.fre.k(str, dVar);
                            hVar = null;
                        } else {
                            if (dVar == null || anT - dVar.eRt > 600) {
                                ab.d("MicroMsg.AvatarService", "new user: %s", str);
                                dVar = new d();
                                dVar.eRu = 1;
                                dVar.eRt = anT;
                                cVar.fre.k(str, dVar);
                            } else if (dVar.eRu < 5) {
                                ab.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", str, Integer.valueOf(dVar.eRu), Long.valueOf(anT - dVar.eRt));
                                dVar.eRu++;
                                dVar.eRt = anT;
                                cVar.fre.k(str, dVar);
                            }
                            hVar = qb;
                        }
                    } else {
                        ab.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", str);
                        hVar = null;
                    }
                } else {
                    ab.w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
                    hVar = null;
                }
                if (hVar == null) {
                    cVar.frd.remove(str);
                } else if (bo.isNullOrNil(hVar.acl())) {
                    ab.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(hVar.dtR));
                    if (4 == hVar.dtR) {
                        ab.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
                    } else {
                        cVar.frf.push(hVar);
                        if (cVar.frf.size() > 5) {
                            cVar.frk.ae(0, 0);
                        } else {
                            cVar.frk.ae(1000, 1000);
                        }
                    }
                } else {
                    cVar.a(new b(hVar));
                }
                AppMethodBeat.o(77859);
                return false;
            }
            d acd = c.acd();
            if (acd != null) {
                acd.e(this.username, this.fru);
            }
            c.this.frd.remove(this.username);
            AppMethodBeat.o(77859);
            return false;
        }
    }

    class a implements com.tencent.mm.sdk.platformtools.az.a {
        h fro;
        byte[] frp;
        boolean frq;
        byte[] frr;

        public a(h hVar, byte[] bArr, boolean z) {
            this.fro = hVar;
            this.frp = bArr;
            this.frq = z;
        }

        public final boolean acf() {
            byte[] bArr;
            AppMethodBeat.i(77854);
            if (this.frq) {
                ab.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
                h.pYm.k(138, 51, 1);
                byte[] DecryptAvatar = UtilsJni.DecryptAvatar(this.frp);
                if (bo.cb(DecryptAvatar)) {
                    h.pYm.k(138, 52, 1);
                    ab.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
                    AppMethodBeat.o(77854);
                    return false;
                }
                bArr = DecryptAvatar;
            } else {
                bArr = this.frp;
            }
            if (r.bU(bArr)) {
                ab.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
                h.pYm.k(138, 53, 1);
                this.frr = ((com.tencent.mm.plugin.emoji.b.c) g.K(com.tencent.mm.plugin.emoji.b.c.class)).aE(bArr);
                if (bo.cb(this.frr)) {
                    h.pYm.k(138, 54, 1);
                    ab.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
                    AppMethodBeat.o(77854);
                    return false;
                }
            }
            this.frr = bArr;
            AppMethodBeat.o(77854);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(77855);
            if (bo.cb(this.frr)) {
                ab.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
                AppMethodBeat.o(77855);
                return false;
            }
            ab.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", Integer.valueOf(this.frr.length));
            c.this.a(new e(this.fro, this.frr));
            AppMethodBeat.o(77855);
            return true;
        }
    }

    class b implements com.tencent.mm.sdk.platformtools.az.a {
        public boolean frq = false;
        public h frs = null;
        public byte[] frt = null;

        public b(h hVar) {
            this.frs = hVar;
        }

        public final boolean acf() {
            h hVar;
            Object[] objArr;
            AppMethodBeat.i(77856);
            if (this.frs == null) {
                AppMethodBeat.o(77856);
                return false;
            }
            String str;
            String str2;
            if (!at.isNetworkConnected(ah.getContext())) {
                ab.w("MicroMsg.HttpGetAvatar", "[tomys] network is unavailable, skip rest loading logic.");
                ab.dot();
            }
            String acl = this.frs.acl();
            boolean biY = ((com.tencent.mm.plugin.emoji.b.c) g.K(com.tencent.mm.plugin.emoji.b.c.class)).biY();
            boolean a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_avatar_download_small_hevc, false);
            if (biY && a) {
                ab.i("MicroMsg.HttpGetAvatar", "HttpGetAvatar: get hevc");
                if (acl.contains("?")) {
                    str = acl + "&tp=wxpic";
                } else {
                    str = acl + "?tp=wxpic";
                }
                h.pYm.k(138, 50, 1);
                str2 = str;
            } else {
                str2 = acl;
            }
            str = "";
            if (g.RN().QY()) {
                r1 = new Object[4];
                g.RN();
                r1[1] = p.getString(com.tencent.mm.kernel.a.QF());
                r1[2] = Integer.valueOf(at.getNetTypeForStat(ah.getContext()));
                r1[3] = Integer.valueOf(at.getStrength(ah.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r1);
            }
            ab.d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", this.frs.getUsername(), str);
            this.frt = null;
            u uVar = null;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = null;
            h.pYm.a(138, 40, 1, true);
            try {
                uVar = com.tencent.mm.network.b.a(str2, null);
                uVar.setRequestMethod("GET");
                uVar.setRequestProperty("referer", str);
                uVar.setConnectTimeout(5000);
                uVar.setReadTimeout(5000);
                if (com.tencent.mm.network.b.a(uVar) != 0) {
                    int responseCode = uVar.getResponseCode();
                    Map headerFields = uVar.getHeaderFields();
                    List list = headerFields != null ? (List) headerFields.get("X-ErrNo") : null;
                    str = (list == null || list.size() <= 0) ? "" : (String) list.get(0);
                    ab.e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d xErr:%s", str2, Integer.valueOf(responseCode), str);
                    switch (responseCode) {
                        case 404:
                            h.pYm.a(138, 2, 1, true);
                            h.pYm.e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), uVar.gdF, Integer.valueOf(uVar.gcI), uVar.url.getHost(), str2, str);
                            break;
                        case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /*502*/:
                            h.pYm.a(138, 3, 1, true);
                            h.pYm.e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), uVar.gdF, Integer.valueOf(uVar.gcI), uVar.url.getHost(), str2, str);
                            break;
                        case ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /*503*/:
                            h.pYm.a(138, 4, 1, true);
                            h.pYm.e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), uVar.gdF, Integer.valueOf(uVar.gcI), uVar.url.getHost(), str2, str);
                            break;
                        case 504:
                            h.pYm.a(138, 5, 1, true);
                            h.pYm.e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), uVar.gdF, Integer.valueOf(uVar.gcI), uVar.url.getHost(), str2, str);
                            break;
                        default:
                            h.pYm.a(138, 6, 1, true);
                            h.pYm.e(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.frs.getUsername(), uVar.gdF, Integer.valueOf(uVar.gcI), uVar.url.getHost(), str2, str);
                            break;
                    }
                    AppMethodBeat.o(77856);
                    return true;
                }
                if (uVar.getHeaderFieldInt("X-Enc", 0) == 1) {
                    a = true;
                } else {
                    a = false;
                }
                this.frq = a;
                int contentLength = uVar.connection.getContentLength();
                inputStream = uVar.getInputStream();
                if (inputStream == null) {
                    ab.d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", str2);
                    AppMethodBeat.o(77856);
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
                h.pYm.a(138, 41, 1, true);
                if (com.tencent.mm.sdk.a.b.dnO()) {
                    h.pYm.e(14058, Integer.valueOf(100001), Integer.valueOf(i.sHCENCODEVIDEOTIMEOUT), "", Integer.valueOf(contentLength), this.frs.getUsername(), uVar.gdF, Integer.valueOf(uVar.gcI), uVar.url.getHost(), str2, "");
                }
                this.frt = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                byteArrayOutputStream = null;
                uVar.connection.disconnect();
                uVar = null;
                inputStream.close();
                inputStream = null;
                if (contentLength > 0 && this.frt.length < contentLength) {
                    h.pYm.a(138, 15, 1, true);
                    ab.e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
                }
                if (uVar != null) {
                    try {
                        uVar.connection.disconnect();
                    } catch (Exception e) {
                        ab.e("MicroMsg.HttpGetAvatar", "exception:%s", bo.l(e));
                        ab.e("MicroMsg.HttpGetAvatar", "close conn failed : %s", e.getMessage());
                        h.pYm.a(138, 9, 1, true);
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                AppMethodBeat.o(77856);
                return true;
            } catch (ProtocolException e2) {
                ProtocolException protocolException = e2;
                h.pYm.a(138, 1, 1, true);
                hVar = h.pYm;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10001);
                objArr[2] = protocolException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.frs.getUsername();
                if (uVar == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = uVar.gdF;
                }
                objArr[5] = str;
                objArr[6] = uVar == null ? BuildConfig.COMMAND : Integer.valueOf(uVar.gcI);
                if (uVar == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = uVar.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = "";
                hVar.e(14058, objArr);
                ab.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", str2, protocolException.getClass().getSimpleName(), protocolException.getMessage());
            } catch (SocketTimeoutException e3) {
                SocketTimeoutException socketTimeoutException = e3;
                h.pYm.a(138, 8, 1, true);
                hVar = h.pYm;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10002);
                objArr[2] = socketTimeoutException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.frs.getUsername();
                if (uVar == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = uVar.gdF;
                }
                objArr[5] = str;
                objArr[6] = uVar == null ? BuildConfig.COMMAND : Integer.valueOf(uVar.gcI);
                if (uVar == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = uVar.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = "";
                hVar.e(14058, objArr);
                ab.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", str2, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
            } catch (IOException e4) {
                IOException iOException = e4;
                h.pYm.a(138, 7, 1, true);
                hVar = h.pYm;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = iOException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.frs.getUsername();
                if (uVar == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = uVar.gdF;
                }
                objArr[5] = str;
                objArr[6] = uVar == null ? BuildConfig.COMMAND : Integer.valueOf(uVar.gcI);
                if (uVar == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = uVar.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = "";
                hVar.e(14058, objArr);
                ab.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", str2, iOException.getClass().getSimpleName(), iOException.getMessage());
            } catch (Exception e5) {
                Exception exception = e5;
                h.pYm.a(138, 0, 1, true);
                hVar = h.pYm;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = exception.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.frs.getUsername();
                if (uVar == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = uVar.gdF;
                }
                objArr[5] = str;
                objArr[6] = uVar == null ? BuildConfig.COMMAND : Integer.valueOf(uVar.gcI);
                if (uVar == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = uVar.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = str2;
                objArr[9] = "";
                hVar.e(14058, objArr);
                ab.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", str2, exception.getClass().getSimpleName(), exception.getMessage());
            }
        }

        public final boolean acg() {
            AppMethodBeat.i(77857);
            if (this.frs == null || bo.isNullOrNil(this.frs.getUsername())) {
                AppMethodBeat.o(77857);
            } else if (bo.cb(this.frt)) {
                c.this.frd.remove(this.frs.getUsername());
                h.pYm.a(138, 10, 1, true);
                AppMethodBeat.o(77857);
            } else {
                if (com.tencent.mm.model.ao.a.flv != null) {
                    com.tencent.mm.model.ao.a.flv.cm(this.frt.length, 0);
                }
                c.this.a(new a(this.frs, this.frt, this.frq));
                AppMethodBeat.o(77857);
            }
            return false;
        }
    }

    class e implements com.tencent.mm.sdk.platformtools.az.a {
        Bitmap bitmap = null;
        byte[] buf;
        h fro = null;

        public e(h hVar, byte[] bArr) {
            this.fro = hVar;
            this.buf = bArr;
        }

        public final boolean acf() {
            AppMethodBeat.i(77860);
            if (this.fro == null || bo.isNullOrNil(this.fro.getUsername())) {
                ab.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
                h.pYm.a(138, 13, 1, true);
                AppMethodBeat.o(77860);
                return false;
            }
            if (c.acd() != null) {
                this.bitmap = d.m(this.fro.getUsername(), this.buf);
                if (this.bitmap == null) {
                    h.pYm.a(138, 14, 1, true);
                }
            }
            i ace = c.ace();
            if (ace != null) {
                this.fro.bJt = -1;
                this.fro.acm();
                ace.b(this.fro);
            }
            AppMethodBeat.o(77860);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(77861);
            if (bo.isNullOrNil(this.fro.getUsername())) {
                AppMethodBeat.o(77861);
            } else {
                d acd = c.acd();
                if (!(acd == null || this.bitmap == null)) {
                    acd.e(this.fro.getUsername(), this.bitmap);
                }
                c.this.frd.remove(this.fro.getUsername());
                AppMethodBeat.o(77861);
            }
            return false;
        }
    }

    public c() {
        AppMethodBeat.i(77862);
        g.Rg().a(123, (f) this);
        this.frc = false;
        this.fri = com.tencent.mm.model.r.Yz();
        AppMethodBeat.o(77862);
    }

    public final Bitmap b(String str, boolean z, int i) {
        Bitmap bitmap;
        AppMethodBeat.i(77863);
        d acd = acd();
        if (acd != null) {
            if (i < 0 || i <= 5) {
                bitmap = null;
            } else {
                bitmap = d.qd(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}));
                if (bitmap != null) {
                    ab.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", Integer.valueOf(i));
                    AppMethodBeat.o(77863);
                    return bitmap;
                }
                ab.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", Integer.valueOf(i));
            }
            if (bitmap == null) {
                bitmap = d.qd(str);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (i >= 0 && i > 5) {
                ab.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", Integer.valueOf(i));
                bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) i);
                acd.e(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}), bitmap);
            }
            AppMethodBeat.o(77863);
            return bitmap;
        } else if (z) {
            AppMethodBeat.o(77863);
            return null;
        } else {
            ab.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", str);
            if (this.frd.contains(str)) {
                AppMethodBeat.o(77863);
                return null;
            }
            this.frd.add(str);
            a(new c(str));
            AppMethodBeat.o(77863);
            return null;
        }
    }

    public final void pZ(String str) {
        AppMethodBeat.i(77864);
        a(new c(str));
        AppMethodBeat.o(77864);
    }

    public final void qa(final String str) {
        AppMethodBeat.i(77865);
        com.tencent.mm.sdk.g.d.xDH.ak(new Runnable() {
            public final void run() {
                AppMethodBeat.i(77850);
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(77850);
                } else if (str.equals(c.this.fri)) {
                    AppMethodBeat.o(77850);
                } else {
                    i ace = c.ace();
                    if (ace == null) {
                        AppMethodBeat.o(77850);
                        return;
                    }
                    h qo = ace.qo(str);
                    if (qo == null || !qo.getUsername().equals(str)) {
                        AppMethodBeat.o(77850);
                        return;
                    }
                    int i;
                    if (bo.anT() - (((long) qo.frY) * 60) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        AppMethodBeat.o(77850);
                    } else if (bo.isNullOrNil(qo.acl())) {
                        ab.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", str);
                        AppMethodBeat.o(77850);
                    } else if (c.acd() == null) {
                        AppMethodBeat.o(77850);
                    } else {
                        d.E(str, false);
                        d.E(str, true);
                        c.this.pZ(str);
                        AppMethodBeat.o(77850);
                    }
                }
            }

            public final String toString() {
                AppMethodBeat.i(77851);
                String str = super.toString() + "|checkAvatarExpire";
                AppMethodBeat.o(77851);
                return str;
            }
        });
        AppMethodBeat.o(77865);
    }

    static h qb(String str) {
        AppMethodBeat.i(77866);
        h qo = o.act().qo(str);
        if (qo == null || !qo.getUsername().equals(str)) {
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
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
                ab.d(str2, str3, objArr);
                AppMethodBeat.o(77866);
                return null;
            } else if (aoO.dtR == 4) {
                b.U(str, aoO.dtR);
                ab.d("MicroMsg.AvatarService", "ct imgFlag :%s", Integer.valueOf(aoO.dtR));
                AppMethodBeat.o(77866);
                return null;
            } else {
                qo = new h();
                qo.username = str;
                qo.dtR = 3;
                byte[] aoS = ((j) g.K(j.class)).XM().aoS(str);
                if (bo.cb(aoS)) {
                    ab.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", str);
                    AppMethodBeat.o(77866);
                    return qo;
                }
                h a;
                try {
                    a = b.a(str, (bbv) new bbv().parseFrom(aoS));
                } catch (Exception e) {
                    ab.e("MicroMsg.AvatarService", "exception:%s", bo.l(e));
                    a = qo;
                }
                ab.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", a.acl(), a.ack(), str);
                AppMethodBeat.o(77866);
                return a;
            }
        }
        ab.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", qo.acl(), str);
        AppMethodBeat.o(77866);
        return qo;
    }

    public final void cancel() {
        AppMethodBeat.i(77867);
        while (this.frf.size() > 0) {
            this.frd.remove(this.frf.pop());
        }
        AppMethodBeat.o(77867);
    }

    /* Access modifiers changed, original: final */
    public final int a(final com.tencent.mm.sdk.platformtools.az.a aVar) {
        AppMethodBeat.i(77868);
        com.tencent.mm.sdk.g.a.c cVar = com.tencent.mm.sdk.g.d.xDH;
        com.tencent.mm.sdk.g.d.xDH.ak(new Runnable() {
            public final void run() {
                AppMethodBeat.i(77852);
                aVar.acf();
                aVar.acg();
                AppMethodBeat.o(77852);
            }
        });
        AppMethodBeat.o(77868);
        return 1;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(77869);
        if (mVar == null) {
            AppMethodBeat.o(77869);
        } else if (mVar.getType() != 123) {
            AppMethodBeat.o(77869);
        } else {
            if (!(i == 0 && i2 == 0)) {
                h.pYm.a(138, 12, 1, true);
            }
            h.pYm.a(138, 45, 1, true);
            j jVar = (j) mVar;
            HashSet hashSet = new HashSet();
            if (jVar.fsb != null) {
                Iterator it = jVar.fsb.iterator();
                while (it.hasNext()) {
                    auk auk = (auk) it.next();
                    String str2 = auk.wyu.wVI;
                    if (auk.vEF == null || auk.vEF.getBuffer() == null || auk.vEF.getBuffer().wR == null) {
                        h.pYm.a(138, 11, 1, true);
                    } else {
                        hashSet.add(str2);
                        h hVar = new h();
                        hVar.username = str2;
                        hVar.dtR = 3;
                        h.pYm.a(138, 43, 1, true);
                        a(new e(hVar, auk.vEF.getBuffer().wR));
                    }
                }
            }
            if (jVar.fsa != null) {
                Iterator it2 = jVar.fsa.iterator();
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
                this.frk.ae(0, 0);
            }
            AppMethodBeat.o(77869);
        }
    }

    static d acd() {
        AppMethodBeat.i(77870);
        if (g.RN().QY()) {
            d acd = o.acd();
            AppMethodBeat.o(77870);
            return acd;
        }
        AppMethodBeat.o(77870);
        return null;
    }

    public final String qc(String str) {
        AppMethodBeat.i(77871);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(77871);
            return str2;
        }
        try {
            str2 = String.format("%s%x_%s", new Object[]{"ammURL_", Integer.valueOf(str.hashCode()), str.substring(str.length() - 24, str.length() - 4)});
        } catch (Exception e) {
            str2 = String.format("%s%x_", new Object[]{"ammURL_", Integer.valueOf(str.hashCode())});
        }
        this.frj.put(str2, str);
        AppMethodBeat.o(77871);
        return str2;
    }

    static /* synthetic */ i ace() {
        AppMethodBeat.i(77872);
        if (g.RN().QY()) {
            i act = o.act();
            AppMethodBeat.o(77872);
            return act;
        }
        AppMethodBeat.o(77872);
        return null;
    }
}
