package com.tencent.mm.plugin.readerapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class c implements d {
    /* JADX WARNING: Removed duplicated region for block: B:191:0x083f  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b b(a aVar) {
        String str;
        String str2;
        Throwable e;
        AppMethodBeat.i(76756);
        cm cmVar = aVar.eAB;
        if (aVar.fsY == null) {
            ab.w("MicroMsg.ReaderAppMsgExtension", "[onPreAddMessage] fake! functionMsgId:%s", "fake#" + (System.currentTimeMillis() / 1000));
            str = str2;
        } else {
            str = ((d.b) aVar.fsY).fsT;
        }
        if (cmVar == null) {
            ab.e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(76756);
            return null;
        }
        h.pYm.e(13440, Integer.valueOf(1));
        bm cdZ = g.cdZ();
        ab.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", "delete from " + bm.kH(20) + " where reserved3 = " + com.tencent.mm.cd.h.escape(str));
        if (cdZ.fni.hY(bm.kH(20), "delete from " + bm.kH(20) + " where reserved3 = " + com.tencent.mm.cd.h.escape(str))) {
            cdZ.doNotify();
        }
        long j = ((long) cmVar.pcX) * 1000;
        ab.d("MicroMsg.ReaderAppMsgExtension", "parseMsg, createTime: %s, content: %s", Integer.valueOf(cmVar.pcX), aa.a(cmVar.vED));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        int i = 0;
        ArrayList<bl> arrayList = new ArrayList();
        int i2 = 0;
        int i3;
        int i4;
        try {
            Map z = br.z(aa.a(cmVar.vED), "mmreader");
            if (z == null) {
                AppMethodBeat.o(76756);
                return null;
            }
            String str3;
            bl blVar;
            Object obj;
            i = 0;
            int i5 = 0;
            while (i <= 0) {
                try {
                    String str4 = ".mmreader.category" + (i > 0 ? Integer.valueOf(i) : "");
                    i2 = bo.getInt((String) z.get(str4 + ".$type"), 0);
                    if (i2 != 0) {
                        if (i2 != 20 && i2 != 11) {
                            ab.e("MicroMsg.ReaderAppMsgExtension", "get " + str4 + ".$type  error Type:" + i2);
                            i3 = i;
                            break;
                        }
                        String str5 = (String) z.get(str4 + ".name");
                        if (bo.isNullOrNil(str5)) {
                            ab.e("MicroMsg.ReaderAppMsgExtension", "get " + str4 + ".name  error");
                            i5 = i2;
                            i3 = i;
                            break;
                        }
                        str3 = (String) z.get(str4 + ".topnew.cover");
                        String str6 = (String) z.get(str4 + ".topnew.digest");
                        int i6 = bo.getInt((String) z.get(str4 + ".$count"), 0);
                        if (i6 == 0) {
                            ab.e("MicroMsg.ReaderAppMsgExtension", "get " + str4 + ".$count  error");
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
                            bl blVar2 = new bl();
                            blVar2.fnf = (long) cmVar.ptD;
                            blVar2.title = (String) z.get(str7 + ".title");
                            if (i7 == 0) {
                                blVar2.fnd = 1;
                                blVar2.fjx = str3;
                                if (bo.isNullOrNil(str6)) {
                                    str2 = (String) z.get(str7 + ".digest");
                                } else {
                                    str2 = str6;
                                }
                                blVar2.fjz = str2;
                            } else {
                                blVar2.fjx = (String) z.get(str7 + ".cover");
                                blVar2.fjz = (String) z.get(str7 + ".digest");
                            }
                            if (z.containsKey(str7 + ".vedio")) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            blVar2.fne = i4;
                            blVar2.url = (String) z.get(str7 + ".url");
                            blVar2.fmY = (String) z.get(str7 + ".shorturl");
                            blVar2.fmZ = (String) z.get(str7 + ".longurl");
                            blVar2.fna = bo.getLong((String) z.get(str7 + ".pub_time"), 0);
                            str2 = (String) z.get(str7 + ".tweetid");
                            if (str2 == null || "".equals(str2)) {
                                str2 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i7)));
                                ab.d("MicroMsg.ReaderAppMsgExtension", "create tweetID = ".concat(String.valueOf(str2)));
                            }
                            blVar2.fmX = str2;
                            blVar2.fnb = (String) z.get(str7 + ".sources.source.name");
                            blVar2.fnc = (String) z.get(str7 + ".sources.source.icon");
                            blVar2.time = ((long) i) + j;
                            blVar2.type = i2;
                            blVar2.name = str5;
                            blVar2.fng = str;
                            arrayList.add(blVar2);
                            i7++;
                        }
                        i++;
                        i5 = i2;
                    } else {
                        ab.e("MicroMsg.ReaderAppMsgExtension", "get " + str4 + ".$type  error");
                        i3 = i;
                        break;
                    }
                } catch (Exception e2) {
                    e = e2;
                    i4 = i5;
                    i3 = i;
                    ab.printErrStackTrace("MicroMsg.ReaderAppMsgExtension", e, "", new Object[0]);
                    i5 = i4;
                    ab.d("MicroMsg.ReaderAppMsgExtension", "type = " + i5 + ", want to receive news? " + cdX());
                    for (bl blVar3 : arrayList) {
                    }
                    i4 = 1;
                    if (arrayList.size() > 0) {
                    }
                    AppMethodBeat.o(76756);
                    return null;
                }
            }
            i3 = i;
            ab.d("MicroMsg.ReaderAppMsgExtension", "type = " + i5 + ", want to receive news? " + cdX());
            for (bl blVar32 : arrayList) {
                if (!bo.isNullOrNil(blVar32.getTitle())) {
                    if (bo.isNullOrNil(blVar32.getUrl())) {
                        ab.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + blVar32.aaj() + ", type = " + blVar32.type);
                        obj = null;
                        break;
                    }
                }
                ab.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + blVar32.aaj() + ", type = " + blVar32.type);
                obj = null;
                break;
            }
            i4 = 1;
            if (arrayList.size() > 0 || obj == null) {
                AppMethodBeat.o(76756);
                return null;
            }
            int i8 = 0;
            bl blVar4 = null;
            i2 = 0;
            while (i2 < arrayList.size()) {
                bm cdZ2 = g.cdZ();
                blVar32 = (bl) arrayList.get(i2);
                if (blVar32 != null) {
                    String str8;
                    String str9;
                    blVar32.bJt = -1;
                    ContentValues contentValues = new ContentValues();
                    if ((blVar32.bJt & 1) != 0) {
                        contentValues.put("tweetid", blVar32.aaj());
                    }
                    if ((blVar32.bJt & 2) != 0) {
                        contentValues.put("time", Long.valueOf(blVar32.time));
                    }
                    if ((blVar32.bJt & 4) != 0) {
                        contentValues.put("type", Integer.valueOf(blVar32.type));
                    }
                    if ((blVar32.bJt & 8) != 0) {
                        contentValues.put("name", blVar32.getName());
                    }
                    if ((blVar32.bJt & 16) != 0) {
                        contentValues.put("title", blVar32.getTitle());
                    }
                    if ((blVar32.bJt & 32) != 0) {
                        contentValues.put("url", blVar32.getUrl());
                    }
                    if ((blVar32.bJt & 64) != 0) {
                        contentValues.put("shorturl", blVar32.aak());
                    }
                    if ((blVar32.bJt & 128) != 0) {
                        str8 = "longurl";
                        if (blVar32.fmZ == null) {
                            str9 = "";
                        } else {
                            str9 = blVar32.fmZ;
                        }
                        contentValues.put(str8, str9);
                    }
                    if ((blVar32.bJt & 256) != 0) {
                        contentValues.put("pubtime", Long.valueOf(blVar32.fna));
                    }
                    if ((blVar32.bJt & 512) != 0) {
                        contentValues.put("sourcename", blVar32.aal());
                    }
                    if ((blVar32.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                        contentValues.put("sourceicon", blVar32.aam());
                    }
                    if ((blVar32.bJt & 2048) != 0) {
                        contentValues.put("istop", Integer.valueOf(blVar32.fnd));
                    }
                    if ((blVar32.bJt & 4096) != 0) {
                        contentValues.put("cover", blVar32.aan());
                    }
                    if ((blVar32.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                        contentValues.put("digest", blVar32.getDigest());
                    }
                    if ((blVar32.bJt & 16384) != 0) {
                        contentValues.put("reserved1", Integer.valueOf(blVar32.fne));
                    }
                    if ((blVar32.bJt & 32768) != 0) {
                        contentValues.put("reserved2", Long.valueOf(blVar32.fnf));
                    }
                    if ((blVar32.bJt & 65536) != 0) {
                        str8 = "reserved3";
                        if (blVar32.fng == null) {
                            str9 = "";
                        } else {
                            str9 = blVar32.fng;
                        }
                        contentValues.put(str8, str9);
                    }
                    if ((blVar32.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                        str8 = "reserved4";
                        if (blVar32.fnh == null) {
                            str9 = "";
                        } else {
                            str9 = blVar32.fnh;
                        }
                        contentValues.put(str8, str9);
                    }
                    if (((int) cdZ2.fni.insert(bm.kH(blVar32.type), "tweetid", contentValues)) != -1) {
                        obj = 1;
                        if (obj == null) {
                            if (blVar4 == null) {
                                blVar32 = (bl) arrayList.get(i2);
                                blVar32.fnd = 1;
                            } else {
                                blVar32 = blVar4;
                            }
                            i8++;
                        } else {
                            blVar32 = blVar4;
                        }
                        i2++;
                        blVar4 = blVar32;
                    }
                }
                obj = null;
                if (obj == null) {
                }
                i2++;
                blVar4 = blVar32;
            }
            ab.i("MicroMsg.ReaderAppMsgExtension", "[onPreAddMessage] insertCount:%s catIdx:%s", Integer.valueOf(i8), Integer.valueOf(i3));
            if (i8 > 0) {
                ak aoZ = ((j) g.K(j.class)).XR().aoZ(bl.kG(i5));
                if (aoZ == null || !aoZ.field_username.equals(bl.kG(i5))) {
                    long anU;
                    ak akVar = new ak();
                    akVar.setUsername(bl.kG(i5));
                    akVar.setContent(blVar4 == null ? "" : blVar4.getTitle());
                    if (blVar4 == null) {
                        anU = bo.anU();
                    } else {
                        anU = blVar4.time;
                    }
                    akVar.eD(anU);
                    akVar.hO(0);
                    akVar.hM(i3);
                    ((j) g.K(j.class)).XR().d(akVar);
                } else {
                    aoZ.setContent(blVar4.getTitle());
                    aoZ.eD(blVar4.time);
                    aoZ.hO(0);
                    aoZ.hM(aoZ.field_unReadCount + i3);
                    ((j) g.K(j.class)).XR().a(aoZ, bl.kG(i5));
                }
                g.cdZ().doNotify();
                str3 = blVar4.getTitle();
                bi biVar = new bi();
                biVar.setContent(str3);
                biVar.ju(bl.kG(i5));
                biVar.setType(1);
                biVar.setMsgId(7377812);
                b bVar = new b(biVar, true);
                AppMethodBeat.o(76756);
                return bVar;
            }
            ab.e("MicroMsg.ReaderAppMsgExtension", "insert error");
            AppMethodBeat.o(76756);
            return null;
        } catch (Exception e3) {
            e = e3;
            i4 = i2;
            i3 = i;
        }
    }

    public static boolean cdX() {
        AppMethodBeat.i(76757);
        if ((r.YF() & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
            AppMethodBeat.o(76757);
            return true;
        }
        AppMethodBeat.o(76757);
        return false;
    }

    public final void a(com.tencent.mm.ai.e.c cVar) {
        AppMethodBeat.i(76758);
        ab.i("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] functionId:%s", (String) cVar.fsY);
        try {
            bm cdZ = g.cdZ();
            List<bl> R = cdZ.R(r0, 20);
            if (R == null || R.size() == 0) {
                AppMethodBeat.o(76758);
                return;
            }
            bl blVar = (bl) R.get(0);
            bl blVar2 = blVar;
            for (bl blVar3 : R) {
                if (blVar3.fnd != 1) {
                    blVar3 = blVar2;
                }
                blVar2 = blVar3;
            }
            if (cdZ.fni.delete(bm.kH(20), "reserved3=?", new String[]{r0}) >= 0) {
                cdZ.doNotify();
            }
            ab.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", bm.oH(bm.kH(20)) + " where istop = 1  group by time ORDER BY time DESC  limit 2");
            Cursor a = cdZ.fni.a(r0, null, 2);
            ak akVar;
            if (a.moveToFirst()) {
                ak aoZ = ((j) g.K(j.class)).XR().aoZ(bl.kG(20));
                if (aoZ == null) {
                    ab.e("MicroMsg.ReaderAppInfoStorage", "[processConversationAfterDeleteInfo] originConv[%s] is null!", bl.kG(20));
                    AppMethodBeat.o(76758);
                    return;
                }
                bl blVar4 = new bl();
                blVar4.d(a);
                a.close();
                akVar = new ak();
                akVar.setUsername(bl.kG(20));
                akVar.setContent(blVar4.getTitle());
                akVar.eD(blVar4.time);
                akVar.hO(0);
                if (aoZ.field_unReadCount <= 0 || blVar2 == null || !aoZ.field_content.equals(blVar2.getTitle())) {
                    akVar.hM(0);
                } else {
                    akVar.hM(aoZ.field_unReadCount - 1);
                }
                ((j) g.K(j.class)).XR().a(akVar, bl.kG(20));
                AppMethodBeat.o(76758);
                return;
            }
            a.close();
            akVar = new ak();
            akVar.setUsername(bl.kG(20));
            akVar.setContent("");
            akVar.eD(0);
            akVar.hO(0);
            akVar.hM(0);
            ((j) g.K(j.class)).XR().a(akVar, bl.kG(20));
            AppMethodBeat.o(76758);
        } catch (Exception e) {
            ab.e("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] Exception:%s", e);
            AppMethodBeat.o(76758);
        }
    }
}
