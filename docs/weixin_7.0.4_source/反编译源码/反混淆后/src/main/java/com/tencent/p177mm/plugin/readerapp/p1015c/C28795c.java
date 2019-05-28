package com.tencent.p177mm.plugin.readerapp.p1015c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C32779bl;
import com.tencent.p177mm.model.C32780bm;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p183ai.C37443d;
import com.tencent.p177mm.p183ai.C37443d.C37444b;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.readerapp.c.c */
public final class C28795c implements C37443d {
    /* JADX WARNING: Removed duplicated region for block: B:191:0x083f  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        String str;
        String str2;
        Throwable e;
        AppMethodBeat.m2504i(76756);
        C7254cm c7254cm = c1197a.eAB;
        if (c1197a.fsY == null) {
            C4990ab.m7421w("MicroMsg.ReaderAppMsgExtension", "[onPreAddMessage] fake! functionMsgId:%s", "fake#" + (System.currentTimeMillis() / 1000));
            str = str2;
        } else {
            str = ((C37444b) c1197a.fsY).fsT;
        }
        if (c7254cm == null) {
            C4990ab.m7412e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.m2505o(76756);
            return null;
        }
        C7060h.pYm.mo8381e(13440, Integer.valueOf(1));
        C32780bm cdZ = C39565g.cdZ();
        C4990ab.m7411d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", "delete from " + C32780bm.m53549kH(20) + " where reserved3 = " + C7480h.escape(str));
        if (cdZ.fni.mo10108hY(C32780bm.m53549kH(20), "delete from " + C32780bm.m53549kH(20) + " where reserved3 = " + C7480h.escape(str))) {
            cdZ.doNotify();
        }
        long j = ((long) c7254cm.pcX) * 1000;
        C4990ab.m7411d("MicroMsg.ReaderAppMsgExtension", "parseMsg, createTime: %s, content: %s", Integer.valueOf(c7254cm.pcX), C1946aa.m4148a(c7254cm.vED));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        int i = 0;
        ArrayList<C32779bl> arrayList = new ArrayList();
        int i2 = 0;
        int i3;
        int i4;
        try {
            Map z = C5049br.m7595z(C1946aa.m4148a(c7254cm.vED), "mmreader");
            if (z == null) {
                AppMethodBeat.m2505o(76756);
                return null;
            }
            String str3;
            C32779bl c32779bl;
            Object obj;
            i = 0;
            int i5 = 0;
            while (i <= 0) {
                try {
                    String str4 = ".mmreader.category" + (i > 0 ? Integer.valueOf(i) : "");
                    i2 = C5046bo.getInt((String) z.get(str4 + ".$type"), 0);
                    if (i2 != 0) {
                        if (i2 != 20 && i2 != 11) {
                            C4990ab.m7412e("MicroMsg.ReaderAppMsgExtension", "get " + str4 + ".$type  error Type:" + i2);
                            i3 = i;
                            break;
                        }
                        String str5 = (String) z.get(str4 + ".name");
                        if (C5046bo.isNullOrNil(str5)) {
                            C4990ab.m7412e("MicroMsg.ReaderAppMsgExtension", "get " + str4 + ".name  error");
                            i5 = i2;
                            i3 = i;
                            break;
                        }
                        str3 = (String) z.get(str4 + ".topnew.cover");
                        String str6 = (String) z.get(str4 + ".topnew.digest");
                        int i6 = C5046bo.getInt((String) z.get(str4 + ".$count"), 0);
                        if (i6 == 0) {
                            C4990ab.m7412e("MicroMsg.ReaderAppMsgExtension", "get " + str4 + ".$count  error");
                            i5 = i2;
                            i3 = i;
                            break;
                        }
                        if (i6 > 1) {
                            str4 = str4 + (i2 == 20 ? ".newitem" : ".item");
                        } else {
                            str4 = str4 + ".item";
                        }
                        int i7 = 0;
                        while (i7 < i6) {
                            String str7 = str4 + (i7 > 0 ? Integer.valueOf(i7) : "");
                            C32779bl c32779bl2 = new C32779bl();
                            c32779bl2.fnf = (long) c7254cm.ptD;
                            c32779bl2.title = (String) z.get(str7 + ".title");
                            if (i7 == 0) {
                                c32779bl2.fnd = 1;
                                c32779bl2.fjx = str3;
                                if (C5046bo.isNullOrNil(str6)) {
                                    str2 = (String) z.get(str7 + ".digest");
                                } else {
                                    str2 = str6;
                                }
                                c32779bl2.fjz = str2;
                            } else {
                                c32779bl2.fjx = (String) z.get(str7 + ".cover");
                                c32779bl2.fjz = (String) z.get(str7 + ".digest");
                            }
                            if (z.containsKey(str7 + ".vedio")) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            c32779bl2.fne = i4;
                            c32779bl2.url = (String) z.get(str7 + ".url");
                            c32779bl2.fmY = (String) z.get(str7 + ".shorturl");
                            c32779bl2.fmZ = (String) z.get(str7 + ".longurl");
                            c32779bl2.fna = C5046bo.getLong((String) z.get(str7 + ".pub_time"), 0);
                            str2 = (String) z.get(str7 + ".tweetid");
                            if (str2 == null || "".equals(str2)) {
                                str2 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i7)));
                                C4990ab.m7410d("MicroMsg.ReaderAppMsgExtension", "create tweetID = ".concat(String.valueOf(str2)));
                            }
                            c32779bl2.fmX = str2;
                            c32779bl2.fnb = (String) z.get(str7 + ".sources.source.name");
                            c32779bl2.fnc = (String) z.get(str7 + ".sources.source.icon");
                            c32779bl2.time = ((long) i) + j;
                            c32779bl2.type = i2;
                            c32779bl2.name = str5;
                            c32779bl2.fng = str;
                            arrayList.add(c32779bl2);
                            i7++;
                        }
                        i++;
                        i5 = i2;
                    } else {
                        C4990ab.m7412e("MicroMsg.ReaderAppMsgExtension", "get " + str4 + ".$type  error");
                        i3 = i;
                        break;
                    }
                } catch (Exception e2) {
                    e = e2;
                    i4 = i5;
                    i3 = i;
                    C4990ab.printErrStackTrace("MicroMsg.ReaderAppMsgExtension", e, "", new Object[0]);
                    i5 = i4;
                    C4990ab.m7410d("MicroMsg.ReaderAppMsgExtension", "type = " + i5 + ", want to receive news? " + C28795c.cdX());
                    for (C32779bl c32779bl3 : arrayList) {
                    }
                    i4 = 1;
                    if (arrayList.size() > 0) {
                    }
                    AppMethodBeat.m2505o(76756);
                    return null;
                }
            }
            i3 = i;
            C4990ab.m7410d("MicroMsg.ReaderAppMsgExtension", "type = " + i5 + ", want to receive news? " + C28795c.cdX());
            for (C32779bl c32779bl32 : arrayList) {
                if (!C5046bo.isNullOrNil(c32779bl32.getTitle())) {
                    if (C5046bo.isNullOrNil(c32779bl32.getUrl())) {
                        C4990ab.m7412e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + c32779bl32.aaj() + ", type = " + c32779bl32.type);
                        obj = null;
                        break;
                    }
                }
                C4990ab.m7412e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + c32779bl32.aaj() + ", type = " + c32779bl32.type);
                obj = null;
                break;
            }
            i4 = 1;
            if (arrayList.size() > 0 || obj == null) {
                AppMethodBeat.m2505o(76756);
                return null;
            }
            int i8 = 0;
            C32779bl c32779bl4 = null;
            i2 = 0;
            while (i2 < arrayList.size()) {
                C32780bm cdZ2 = C39565g.cdZ();
                c32779bl32 = (C32779bl) arrayList.get(i2);
                if (c32779bl32 != null) {
                    String str8;
                    String str9;
                    c32779bl32.bJt = -1;
                    ContentValues contentValues = new ContentValues();
                    if ((c32779bl32.bJt & 1) != 0) {
                        contentValues.put("tweetid", c32779bl32.aaj());
                    }
                    if ((c32779bl32.bJt & 2) != 0) {
                        contentValues.put("time", Long.valueOf(c32779bl32.time));
                    }
                    if ((c32779bl32.bJt & 4) != 0) {
                        contentValues.put("type", Integer.valueOf(c32779bl32.type));
                    }
                    if ((c32779bl32.bJt & 8) != 0) {
                        contentValues.put("name", c32779bl32.getName());
                    }
                    if ((c32779bl32.bJt & 16) != 0) {
                        contentValues.put("title", c32779bl32.getTitle());
                    }
                    if ((c32779bl32.bJt & 32) != 0) {
                        contentValues.put("url", c32779bl32.getUrl());
                    }
                    if ((c32779bl32.bJt & 64) != 0) {
                        contentValues.put("shorturl", c32779bl32.aak());
                    }
                    if ((c32779bl32.bJt & 128) != 0) {
                        str8 = "longurl";
                        if (c32779bl32.fmZ == null) {
                            str9 = "";
                        } else {
                            str9 = c32779bl32.fmZ;
                        }
                        contentValues.put(str8, str9);
                    }
                    if ((c32779bl32.bJt & 256) != 0) {
                        contentValues.put("pubtime", Long.valueOf(c32779bl32.fna));
                    }
                    if ((c32779bl32.bJt & 512) != 0) {
                        contentValues.put("sourcename", c32779bl32.aal());
                    }
                    if ((c32779bl32.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                        contentValues.put("sourceicon", c32779bl32.aam());
                    }
                    if ((c32779bl32.bJt & 2048) != 0) {
                        contentValues.put("istop", Integer.valueOf(c32779bl32.fnd));
                    }
                    if ((c32779bl32.bJt & 4096) != 0) {
                        contentValues.put("cover", c32779bl32.aan());
                    }
                    if ((c32779bl32.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                        contentValues.put("digest", c32779bl32.getDigest());
                    }
                    if ((c32779bl32.bJt & 16384) != 0) {
                        contentValues.put("reserved1", Integer.valueOf(c32779bl32.fne));
                    }
                    if ((c32779bl32.bJt & 32768) != 0) {
                        contentValues.put("reserved2", Long.valueOf(c32779bl32.fnf));
                    }
                    if ((c32779bl32.bJt & 65536) != 0) {
                        str8 = "reserved3";
                        if (c32779bl32.fng == null) {
                            str9 = "";
                        } else {
                            str9 = c32779bl32.fng;
                        }
                        contentValues.put(str8, str9);
                    }
                    if ((c32779bl32.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                        str8 = "reserved4";
                        if (c32779bl32.fnh == null) {
                            str9 = "";
                        } else {
                            str9 = c32779bl32.fnh;
                        }
                        contentValues.put(str8, str9);
                    }
                    if (((int) cdZ2.fni.insert(C32780bm.m53549kH(c32779bl32.type), "tweetid", contentValues)) != -1) {
                        obj = 1;
                        if (obj == null) {
                            if (c32779bl4 == null) {
                                c32779bl32 = (C32779bl) arrayList.get(i2);
                                c32779bl32.fnd = 1;
                            } else {
                                c32779bl32 = c32779bl4;
                            }
                            i8++;
                        } else {
                            c32779bl32 = c32779bl4;
                        }
                        i2++;
                        c32779bl4 = c32779bl32;
                    }
                }
                obj = null;
                if (obj == null) {
                }
                i2++;
                c32779bl4 = c32779bl32;
            }
            C4990ab.m7417i("MicroMsg.ReaderAppMsgExtension", "[onPreAddMessage] insertCount:%s catIdx:%s", Integer.valueOf(i8), Integer.valueOf(i3));
            if (i8 > 0) {
                C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(C32779bl.m53547kG(i5));
                if (aoZ == null || !aoZ.field_username.equals(C32779bl.m53547kG(i5))) {
                    long anU;
                    C7617ak c7617ak = new C7617ak();
                    c7617ak.setUsername(C32779bl.m53547kG(i5));
                    c7617ak.setContent(c32779bl4 == null ? "" : c32779bl4.getTitle());
                    if (c32779bl4 == null) {
                        anU = C5046bo.anU();
                    } else {
                        anU = c32779bl4.time;
                    }
                    c7617ak.mo14742eD(anU);
                    c7617ak.mo14750hO(0);
                    c7617ak.mo14748hM(i3);
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(c7617ak);
                } else {
                    aoZ.setContent(c32779bl4.getTitle());
                    aoZ.mo14742eD(c32779bl4.time);
                    aoZ.mo14750hO(0);
                    aoZ.mo14748hM(aoZ.field_unReadCount + i3);
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, C32779bl.m53547kG(i5));
                }
                C39565g.cdZ().doNotify();
                str3 = c32779bl4.getTitle();
                C7620bi c7620bi = new C7620bi();
                c7620bi.setContent(str3);
                c7620bi.mo14794ju(C32779bl.m53547kG(i5));
                c7620bi.setType(1);
                c7620bi.setMsgId(7377812);
                C1198b c1198b = new C1198b(c7620bi, true);
                AppMethodBeat.m2505o(76756);
                return c1198b;
            }
            C4990ab.m7412e("MicroMsg.ReaderAppMsgExtension", "insert error");
            AppMethodBeat.m2505o(76756);
            return null;
        } catch (Exception e3) {
            e = e3;
            i4 = i2;
            i3 = i;
        }
    }

    public static boolean cdX() {
        AppMethodBeat.m2504i(76757);
        if ((C1853r.m3824YF() & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
            AppMethodBeat.m2505o(76757);
            return true;
        }
        AppMethodBeat.m2505o(76757);
        return false;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
        AppMethodBeat.m2504i(76758);
        C4990ab.m7417i("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] functionId:%s", (String) c1199c.fsY);
        try {
            C32780bm cdZ = C39565g.cdZ();
            List<C32779bl> R = cdZ.mo53335R(r0, 20);
            if (R == null || R.size() == 0) {
                AppMethodBeat.m2505o(76758);
                return;
            }
            C32779bl c32779bl = (C32779bl) R.get(0);
            C32779bl c32779bl2 = c32779bl;
            for (C32779bl c32779bl3 : R) {
                if (c32779bl3.fnd != 1) {
                    c32779bl3 = c32779bl2;
                }
                c32779bl2 = c32779bl3;
            }
            if (cdZ.fni.delete(C32780bm.m53549kH(20), "reserved3=?", new String[]{r0}) >= 0) {
                cdZ.doNotify();
            }
            C4990ab.m7417i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", C32780bm.m53550oH(C32780bm.m53549kH(20)) + " where istop = 1  group by time ORDER BY time DESC  limit 2");
            Cursor a = cdZ.fni.mo10104a(r0, null, 2);
            C7617ak c7617ak;
            if (a.moveToFirst()) {
                C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(C32779bl.m53547kG(20));
                if (aoZ == null) {
                    C4990ab.m7413e("MicroMsg.ReaderAppInfoStorage", "[processConversationAfterDeleteInfo] originConv[%s] is null!", C32779bl.m53547kG(20));
                    AppMethodBeat.m2505o(76758);
                    return;
                }
                C32779bl c32779bl4 = new C32779bl();
                c32779bl4.mo53329d(a);
                a.close();
                c7617ak = new C7617ak();
                c7617ak.setUsername(C32779bl.m53547kG(20));
                c7617ak.setContent(c32779bl4.getTitle());
                c7617ak.mo14742eD(c32779bl4.time);
                c7617ak.mo14750hO(0);
                if (aoZ.field_unReadCount <= 0 || c32779bl2 == null || !aoZ.field_content.equals(c32779bl2.getTitle())) {
                    c7617ak.mo14748hM(0);
                } else {
                    c7617ak.mo14748hM(aoZ.field_unReadCount - 1);
                }
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(c7617ak, C32779bl.m53547kG(20));
                AppMethodBeat.m2505o(76758);
                return;
            }
            a.close();
            c7617ak = new C7617ak();
            c7617ak.setUsername(C32779bl.m53547kG(20));
            c7617ak.setContent("");
            c7617ak.mo14742eD(0);
            c7617ak.mo14750hO(0);
            c7617ak.mo14748hM(0);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(c7617ak, C32779bl.m53547kG(20));
            AppMethodBeat.m2505o(76758);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] Exception:%s", e);
            AppMethodBeat.m2505o(76758);
        }
    }
}
