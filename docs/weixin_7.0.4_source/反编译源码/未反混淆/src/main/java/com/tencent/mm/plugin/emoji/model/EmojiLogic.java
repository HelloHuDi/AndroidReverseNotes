package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.a.p;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.o;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.baseutils.BaseTemplateParser;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class EmojiLogic {
    public static native boolean extractForeground(int[] iArr, int i, int i2);

    public static native boolean gifToMMAni(byte[] bArr, PByteArray pByteArray, int i);

    public static int aF(byte[] bArr) {
        AppMethodBeat.i(53004);
        int aF = b.aF(bArr);
        AppMethodBeat.o(53004);
        return aF;
    }

    public static String Jf(String str) {
        String str2 = null;
        AppMethodBeat.i(53005);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(53005);
        } else {
            int asZ = (int) e.asZ(str);
            if (asZ > 0) {
                byte[] e = e.e(str, 0, asZ);
                str2 = g.x(e);
                if (!(str2 == null && e == null)) {
                    e.b(b.Yb() + str2, e, e.length);
                    if (r.bS(e)) {
                        ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYn.a(str2, "", EmojiInfo.yau, EmojiInfo.zYS, e.length, "", "");
                    } else {
                        ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYn.a(str2, "", EmojiInfo.yau, EmojiInfo.zYR, e.length, "", "");
                    }
                }
                AppMethodBeat.o(53005);
            } else {
                AppMethodBeat.o(53005);
            }
        }
        return str2;
    }

    public static String b(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(53006);
        if (wXMediaMessage.getType() != 8) {
            AppMethodBeat.o(53006);
            return null;
        }
        WXEmojiObject wXEmojiObject = (WXEmojiObject) wXMediaMessage.mediaObject;
        if (!bo.cb(wXEmojiObject.emojiData)) {
            ab.d("MicroMsg.emoji.EmojiLogic", " fileData:" + wXEmojiObject.emojiData.length);
            String x = g.x(wXEmojiObject.emojiData);
            a(context, wXMediaMessage.thumbData, x, wXEmojiObject.emojiData, str);
            AppMethodBeat.o(53006);
            return x;
        } else if (bo.isNullOrNil(wXEmojiObject.emojiPath)) {
            AppMethodBeat.o(53006);
            return null;
        } else {
            int asZ = (int) e.asZ(wXEmojiObject.emojiPath);
            if (asZ > 0) {
                byte[] e = e.e(wXEmojiObject.emojiPath, 0, asZ);
                String x2 = g.x(e);
                a(context, wXMediaMessage.thumbData, x2, e, str);
                AppMethodBeat.o(53006);
                return x2;
            }
            AppMethodBeat.o(53006);
            return null;
        }
    }

    private static void a(Context context, byte[] bArr, String str, byte[] bArr2, String str2) {
        AppMethodBeat.i(53007);
        if (str == null && bArr2 == null) {
            AppMethodBeat.o(53007);
            return;
        }
        EmojiInfo a;
        String Yb = b.Yb();
        e.b(Yb + str, bArr2, bArr2.length);
        if (r.bS(bArr2)) {
            a = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYn.a(str, "", EmojiInfo.yau, EmojiInfo.zYX, bArr2.length, str2, "");
        } else {
            a = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYn.a(str, "", EmojiInfo.yau, EmojiInfo.zYY, bArr2.length, str2, "");
        }
        a(context, bArr, str, Yb, a);
        AppMethodBeat.o(53007);
    }

    public static void a(Context context, byte[] bArr, String str, String str2, EmojiInfo emojiInfo) {
        Bitmap hk;
        Bitmap bitmap;
        AppMethodBeat.i(53008);
        if (bArr == null) {
            String str3 = "MicroMsg.emoji.EmojiLogic";
            String str4 = "insertEmoji: thumb is null, emojiInfo is null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(emojiInfo == null);
            ab.d(str3, str4, objArr);
            if (emojiInfo != null) {
                hk = emojiInfo.hk(context);
            } else {
                AppMethodBeat.o(53008);
                return;
            }
        }
        hk = com.tencent.mm.sdk.platformtools.d.bQ(bArr);
        if (hk == null || (hk.getWidth() <= 300 && hk.getHeight() <= 300)) {
            bitmap = hk;
        } else {
            int width = hk.getWidth();
            int height = hk.getHeight();
            ab.i("MicroMsg.emoji.EmojiLogic", "cpan app msg width:%d height:%d", Integer.valueOf(width), Integer.valueOf(height));
            if (width > height) {
                float f = ((float) height) / ((float) width);
                height = 300;
                width = (int) (f * 300.0f);
            } else {
                float f2 = ((float) width) / ((float) height);
                width = 300;
                height = (int) (f2 * 300.0f);
            }
            ab.i("MicroMsg.emoji.EmojiLogic", "cpan app msg new width:%d new height:%d", Integer.valueOf(height), Integer.valueOf(width));
            bitmap = com.tencent.mm.sdk.platformtools.d.a(hk, width, height, false, true);
        }
        if (bitmap != null) {
            try {
                if (bitmap.getByteCount() > 65536) {
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 80, CompressFormat.JPEG, str2 + str + "_thumb", true);
                    ab.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is over size. save as jpg. size :%d", Integer.valueOf(bitmap.getByteCount()));
                    AppMethodBeat.o(53008);
                    return;
                }
                com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, str2 + str + "_thumb", true);
                ab.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is in normal size. sav as png. size :%d", Integer.valueOf(bitmap.getByteCount()));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.emoji.EmojiLogic", e, "insertEmoji Error", new Object[0]);
                AppMethodBeat.o(53008);
                return;
            }
        }
        AppMethodBeat.o(53008);
    }

    public static EmojiInfo a(String str, String str2, i iVar) {
        AppMethodBeat.i(53009);
        if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            EmojiInfo r = r(str, 4, str2);
            if (r == null) {
                o.ahp().a(str2, null, com.tencent.mm.plugin.emoji.e.g.h(str, str2, new Object[0]), iVar);
                ab.i("MicroMsg.emoji.EmojiLogic", "[cpan] get emoji info, try to load image:%s", str2);
            }
            AppMethodBeat.o(53009);
            return r;
        } else if (ah.getContext() == null) {
            AppMethodBeat.o(53009);
            return null;
        } else if (ah.getContext().getResources() == null) {
            AppMethodBeat.o(53009);
            return null;
        } else {
            new EmojiInfo().field_type = EmojiInfo.zYR;
            AppMethodBeat.o(53009);
            return null;
        }
    }

    public static EmojiInfo r(String str, int i, String str2) {
        int i2 = 0;
        AppMethodBeat.i(53010);
        if (TextUtils.isEmpty(str)) {
            ab.d("MicroMsg.emoji.EmojiLogic", "getIcon : productId is null.");
            AppMethodBeat.o(53010);
            return null;
        }
        EmojiInfo emojiInfo = new EmojiInfo();
        String K = K(b.Yb(), str, str2);
        if (e.ct(K)) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(K);
            if (bVar.exists()) {
                if (bVar.length() < 1) {
                    bVar.delete();
                } else {
                    emojiInfo.field_type = b.aF(e.e(K, 0, 10));
                    i2 = 1;
                }
            }
        }
        if (i2 == 0) {
            ab.d("MicroMsg.emoji.EmojiLogic", "banner icon does not exist. icon path :" + K + "...., icon type:" + i);
            AppMethodBeat.o(53010);
            return null;
        }
        emojiInfo.field_md5 = getMD5(str, str2);
        emojiInfo.field_catalog = ud(i);
        emojiInfo.field_groupId = str;
        emojiInfo.field_temp = 1;
        AppMethodBeat.o(53010);
        return emojiInfo;
    }

    private static int ud(int i) {
        switch (i) {
            case 2:
                return 82;
            case 4:
                return 83;
            case 8:
                return 84;
            default:
                return EmojiInfo.yax;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x021f A:{SYNTHETIC, Splitter:B:58:0x021f} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x021f A:{SYNTHETIC, Splitter:B:58:0x021f} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x028c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(String str, String str2, String str3, EmojiGroupInfo emojiGroupInfo) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(53011);
        String str4 = com.tencent.mm.compatible.util.e.euQ + str;
        String str5 = b.Yb() + str;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str4);
            try {
                ZipEntry zipEntry;
                byte[] bArr;
                EmojiInfo aqi;
                InputStream inputStream2;
                Enumeration entries = zipFile.entries();
                int i = 0;
                OutputStream outputStream2 = null;
                while (entries.hasMoreElements()) {
                    try {
                        zipEntry = (ZipEntry) entries.nextElement();
                        if (!(zipEntry.getName().contains("../") || zipEntry.getName().contains("..\\"))) {
                            if (!zipEntry.isDirectory()) {
                                inputStream = zipFile.getInputStream(zipEntry);
                                String toLowerCase = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str5 + "/" + zipEntry.getName());
                                if (bVar.isFile()) {
                                    bVar.delete();
                                }
                                bVar.dMC().mkdirs();
                                if (!toLowerCase.startsWith(".") && (toLowerCase.endsWith(".gif") || toLowerCase.endsWith(".png"))) {
                                    int read;
                                    if (zipEntry.getName().toLowerCase().contains("/large/")) {
                                        outputStream2 = e.L(str5 + "/" + toLowerCase, false);
                                        try {
                                            bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                            while (true) {
                                                read = inputStream.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream2.write(bArr, 0, read);
                                            }
                                            outputStream2.close();
                                            outputStream2 = null;
                                            String atg = e.atg(str5 + "/" + toLowerCase);
                                            ab.i("MicroMsg.emoji.EmojiLogic", "md5:%s index:%d", atg, Integer.valueOf(i));
                                            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str5 + "/" + toLowerCase);
                                            com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(str5 + "/" + atg);
                                            if (r.amo(j.w(bVar2.mUri))) {
                                                read = EmojiInfo.zYS;
                                            } else {
                                                read = EmojiInfo.zYR;
                                            }
                                            aqi = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYn.aqi(atg);
                                            if (aqi == null) {
                                                aqi = new EmojiInfo();
                                                aqi.field_catalog = 0;
                                            }
                                            aqi.field_name = toLowerCase;
                                            aqi.field_md5 = atg;
                                            aqi.field_size = (int) bVar2.length();
                                            aqi.field_type = read;
                                            aqi.field_groupId = str;
                                            aqi.field_idx = i;
                                            arrayList.add(aqi);
                                            bVar2.o(bVar3);
                                            hashMap.put(toLowerCase.substring(0, toLowerCase.length() - 4), atg);
                                            inputStream2 = inputStream;
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                    inputStream2 = null;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    outputStream = outputStream2;
                                                    inputStream = inputStream2;
                                                    try {
                                                        ab.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                                                        if (outputStream != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (zipFile != null) {
                                                        }
                                                        AppMethodBeat.o(53011);
                                                        return false;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (outputStream != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (zipFile != null) {
                                                        }
                                                        AppMethodBeat.o(53011);
                                                        throw th;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    outputStream = outputStream2;
                                                    inputStream = inputStream2;
                                                    if (outputStream != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (zipFile != null) {
                                                    }
                                                    AppMethodBeat.o(53011);
                                                    throw th;
                                                }
                                            }
                                            i++;
                                            inputStream = inputStream2;
                                        } catch (Exception e3) {
                                            e = e3;
                                            outputStream = outputStream2;
                                            ab.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                                            if (outputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (zipFile != null) {
                                            }
                                            AppMethodBeat.o(53011);
                                            return false;
                                        } catch (Throwable th22) {
                                            th = th22;
                                            outputStream = outputStream2;
                                            if (outputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (zipFile != null) {
                                            }
                                            AppMethodBeat.o(53011);
                                            throw th;
                                        }
                                    } else if (toLowerCase.startsWith("icon")) {
                                        outputStream2 = e.L(str5 + "/" + (g.x(str.getBytes()) + "_panel_enable"), false);
                                        bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                        while (true) {
                                            read = inputStream.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            }
                                            outputStream2.write(bArr, 0, read);
                                        }
                                        outputStream2.close();
                                        outputStream2 = null;
                                        inputStream2 = inputStream;
                                        if (inputStream2 != null) {
                                        }
                                        i++;
                                        inputStream = inputStream2;
                                    }
                                }
                            }
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                            }
                            i++;
                            inputStream = inputStream2;
                        }
                    } catch (Exception e32) {
                        e = e32;
                        outputStream = outputStream2;
                    } catch (Throwable th222) {
                        th = th222;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        AppMethodBeat.o(53011);
                        throw th;
                    }
                }
                Enumeration entries2 = zipFile.entries();
                while (entries2.hasMoreElements()) {
                    zipEntry = (ZipEntry) entries2.nextElement();
                    if (!(zipEntry.getName().contains("../") || zipEntry.getName().contains("..\\"))) {
                        if (!zipEntry.isDirectory()) {
                            inputStream = zipFile.getInputStream(zipEntry);
                            String toLowerCase2 = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                            com.tencent.mm.vfs.b bVar4 = new com.tencent.mm.vfs.b(str5 + "/" + zipEntry.getName());
                            if (bVar4.isFile()) {
                                bVar4.delete();
                            }
                            bVar4.dMC().mkdirs();
                            if (zipEntry.getName().toLowerCase().contains("/thumb/")) {
                                int lastIndexOf = toLowerCase2.lastIndexOf(".") + 1;
                                toLowerCase2 = toLowerCase2.substring(0, lastIndexOf - 1) + "_cover." + toLowerCase2.substring(lastIndexOf);
                                outputStream2 = e.L(str5 + "/" + toLowerCase2, false);
                                bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                while (true) {
                                    int read2 = inputStream.read(bArr);
                                    if (read2 <= 0) {
                                        break;
                                    }
                                    outputStream2.write(bArr, 0, read2);
                                }
                                outputStream2.close();
                                outputStream2 = null;
                                String substring = toLowerCase2.substring(0, toLowerCase2.lastIndexOf("_cover."));
                                if (hashMap.containsKey(substring)) {
                                    substring = (String) hashMap.get(substring);
                                    new com.tencent.mm.vfs.b(str5 + "/" + toLowerCase2).o(new com.tencent.mm.vfs.b(str5 + "/" + substring + "_cover"));
                                    hashMap.put(toLowerCase2, substring);
                                }
                            }
                        }
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            inputStream2.close();
                            inputStream2 = null;
                        }
                        inputStream = inputStream2;
                    }
                }
                hashMap.clear();
                if (emojiGroupInfo == null) {
                    emojiGroupInfo = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYo.bZ(str, false);
                }
                emojiGroupInfo.field_productID = str;
                if (!bo.isNullOrNil(str2)) {
                    emojiGroupInfo.field_packName = str2;
                }
                emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                emojiGroupInfo.field_status = 7;
                emojiGroupInfo.field_packStatus = 1;
                emojiGroupInfo.field_type = EmojiGroupInfo.yao;
                emojiGroupInfo.field_recommand = 0;
                emojiGroupInfo.field_sync = 2;
                emojiGroupInfo.field_count = arrayList.size();
                emojiGroupInfo.field_packIconUrl = str3;
                if (((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYn.j(arrayList, str)) {
                    boolean c = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYo.c(emojiGroupInfo);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        aqi = (EmojiInfo) it.next();
                        aqi.field_reserved4 = 0;
                        ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().c(aqi, true);
                    }
                    ab.i("MicroMsg.emoji.EmojiLogic", "saveGroupFlag:%b saveEmojiFlag:%b", Boolean.valueOf(c), Boolean.valueOf(r6));
                } else {
                    ab.i("MicroMsg.emoji.EmojiLogic", "saveEmojiFlag:%b", Boolean.valueOf(((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiStorageMgr().xYn.j(arrayList, str)));
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                zipFile.close();
                AppMethodBeat.o(53011);
                return true;
            } catch (Exception e322) {
                e = e322;
                ab.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                if (outputStream != null) {
                }
                if (inputStream != null) {
                }
                if (zipFile != null) {
                }
                AppMethodBeat.o(53011);
                return false;
            }
        } catch (Exception e3222) {
            e = e3222;
            zipFile = null;
            ab.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            AppMethodBeat.o(53011);
            return false;
        } catch (Throwable th2222) {
            th = th2222;
            zipFile = null;
            if (outputStream != null) {
            }
            if (inputStream != null) {
            }
            if (zipFile != null) {
            }
            AppMethodBeat.o(53011);
            throw th;
        }
    }

    public static aik bkd() {
        AppMethodBeat.i(53012);
        aik aik = new aik();
        aik.wov = 1;
        aik.wox = 1;
        AppMethodBeat.o(53012);
        return aik;
    }

    public static String Jt(String str) {
        AppMethodBeat.i(53013);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(53013);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<productid>" + str + "</productid>");
        stringBuilder.append("</xml>");
        ab.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
        AppMethodBeat.o(53013);
        return stringBuilder.toString();
    }

    public static String r(int i, String str, String str2) {
        AppMethodBeat.i(53014);
        if (i != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<xml>");
            stringBuilder.append("<designeruin>" + i + "</designeruin>");
            stringBuilder.append("<designername>" + str + "</designername>");
            stringBuilder.append("<designerrediretcturl>" + str2 + "</designerrediretcturl>");
            stringBuilder.append("</xml>");
            ab.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
            AppMethodBeat.o(53014);
            return stringBuilder.toString();
        }
        AppMethodBeat.o(53014);
        return null;
    }

    public static int Jm(String str) {
        int cB;
        Exception e;
        AppMethodBeat.i(53015);
        try {
            cB = p.cB((String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.designeruin"));
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", Integer.valueOf(cB));
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", e.toString());
                AppMethodBeat.o(53015);
                return cB;
            }
        } catch (Exception e3) {
            e = e3;
            cB = 0;
        }
        AppMethodBeat.o(53015);
        return cB;
    }

    public static String Jn(String str) {
        String str2;
        Exception e;
        AppMethodBeat.i(53016);
        try {
            str2 = (String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.designername");
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", str2);
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", e.toString());
                AppMethodBeat.o(53016);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            ab.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", e.toString());
            AppMethodBeat.o(53016);
            return str2;
        }
        AppMethodBeat.o(53016);
        return str2;
    }

    public static String Ju(String str) {
        String str2;
        Exception e;
        AppMethodBeat.i(53017);
        try {
            str2 = (String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.designerrediretcturl");
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "designerrediretcturl:%s", str2);
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", e.toString());
                AppMethodBeat.o(53017);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            ab.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", e.toString());
            AppMethodBeat.o(53017);
            return str2;
        }
        AppMethodBeat.o(53017);
        return str2;
    }

    public static String Jl(String str) {
        String str2;
        Exception e;
        AppMethodBeat.i(53018);
        try {
            str2 = (String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.productid");
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "productId:%s", str2);
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", e.toString());
                AppMethodBeat.o(53018);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            ab.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", e.toString());
            AppMethodBeat.o(53018);
            return str2;
        }
        AppMethodBeat.o(53018);
        return str2;
    }

    public static String Jk(String str) {
        AppMethodBeat.i(53019);
        ab.d("MicroMsg.emoji.EmojiLogic", "url:%s", str);
        String str2 = "";
        if (!TextUtils.isEmpty(str) && str.startsWith("http://weixin.qq.com/emoticonstore/")) {
            str2 = str.substring(str.lastIndexOf("/") + 1);
        }
        AppMethodBeat.o(53019);
        return str2;
    }

    public static String a(int i, String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(53020);
        if (i > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<xml>");
            stringBuilder.append("<tid>" + i + "</tid>");
            stringBuilder.append("<title>" + str + "</title>");
            stringBuilder.append("<desc>" + str2 + "</desc>");
            stringBuilder.append("<iconUrl>" + str3 + "</iconUrl>");
            stringBuilder.append("<secondUrl>" + str4 + "</secondUrl>");
            stringBuilder.append("<pageType>" + i2 + "</pageType>");
            stringBuilder.append("</xml>");
            ab.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
            AppMethodBeat.o(53020);
            return stringBuilder.toString();
        }
        AppMethodBeat.o(53020);
        return null;
    }

    public static int Jv(String str) {
        int ank;
        Exception e;
        AppMethodBeat.i(53021);
        try {
            ank = bo.ank((String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.tid"));
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "tid:%s", Integer.valueOf(ank));
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", e.toString());
                AppMethodBeat.o(53021);
                return ank;
            }
        } catch (Exception e3) {
            e = e3;
            ank = 0;
        }
        AppMethodBeat.o(53021);
        return ank;
    }

    public static String Jw(String str) {
        String str2;
        Exception e;
        AppMethodBeat.i(53022);
        try {
            str2 = (String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.title");
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "title:%s", str2);
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", e.toString());
                AppMethodBeat.o(53022);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", e.toString());
            AppMethodBeat.o(53022);
            return str2;
        }
        AppMethodBeat.o(53022);
        return str2;
    }

    public static String Jx(String str) {
        String str2;
        Exception e;
        AppMethodBeat.i(53023);
        try {
            str2 = (String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.desc");
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "desc:%s", str2);
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", e.toString());
                AppMethodBeat.o(53023);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", e.toString());
            AppMethodBeat.o(53023);
            return str2;
        }
        AppMethodBeat.o(53023);
        return str2;
    }

    public static String Jy(String str) {
        String str2;
        Exception e;
        AppMethodBeat.i(53024);
        try {
            str2 = (String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.iconUrl");
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "iconUrl:%s", str2);
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", e.toString());
                AppMethodBeat.o(53024);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", e.toString());
            AppMethodBeat.o(53024);
            return str2;
        }
        AppMethodBeat.o(53024);
        return str2;
    }

    public static String Jz(String str) {
        String bc;
        Exception e;
        AppMethodBeat.i(53025);
        String str2 = "";
        try {
            bc = bo.bc((String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.secondUrl"), "");
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "secondUrl:%s", bc);
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", e.toString());
                AppMethodBeat.o(53025);
                return bc;
            }
        } catch (Exception e3) {
            e = e3;
            bc = str2;
        }
        AppMethodBeat.o(53025);
        return bc;
    }

    public static int JA(String str) {
        int ank;
        Exception e;
        AppMethodBeat.i(53026);
        try {
            ank = bo.ank((String) br.z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.pageType"));
            try {
                ab.d("MicroMsg.emoji.EmojiLogic", "pageType:%s", Integer.valueOf(ank));
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", e.toString());
                AppMethodBeat.o(53026);
                return ank;
            }
        } catch (Exception e3) {
            e = e3;
            ank = 0;
        }
        AppMethodBeat.o(53026);
        return ank;
    }

    public static String K(String str, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.i(53027);
        if (bo.isNullOrNil(str2) && bo.isNullOrNil(str3)) {
            ab.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and url are null.");
            AppMethodBeat.o(53027);
        } else {
            String md5 = getMD5(str2, str3);
            if (!bo.isNullOrNil(md5)) {
                if (bo.isNullOrNil(str2)) {
                    str4 = str + md5;
                } else {
                    str4 = str + str2 + "/" + md5;
                }
            }
            AppMethodBeat.o(53027);
        }
        return str4;
    }

    public static String L(String str, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.i(53028);
        if (bo.isNullOrNil(str2) && bo.isNullOrNil(str3)) {
            ab.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and md5 are null.");
            AppMethodBeat.o(53028);
        } else {
            if (!bo.isNullOrNil(str3)) {
                if (bo.isNullOrNil(str2)) {
                    str4 = str + str3;
                } else {
                    str4 = str + str2 + "/" + str3;
                }
            }
            ab.d("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path. productid:%s md5:%s path:%s", str2, str3, str4);
            AppMethodBeat.o(53028);
        }
        return str4;
    }

    private static String getMD5(String str, String str2) {
        AppMethodBeat.i(53029);
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.emoji.EmojiLogic", "[cpan] product id and url are null.");
            AppMethodBeat.o(53029);
            return null;
        }
        String x;
        if (bo.isNullOrNil(str2)) {
            x = g.x(str.getBytes());
        } else {
            x = g.x(str2.getBytes());
        }
        AppMethodBeat.o(53029);
        return x;
    }

    public static boolean JB(String str) {
        AppMethodBeat.i(53030);
        if (!bo.isNullOrNil(str)) {
            try {
                if (com.tencent.mm.modelcontrol.b.rR(str)) {
                    ab.d("MicroMsg.emoji.EmojiLogic", "In Not Auto Download Time Range. timeRange:%s", str);
                    AppMethodBeat.o(53030);
                    return true;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.emoji.EmojiLogic", "isInNotAutoDownloadTimeRange :%s", bo.l(e));
            }
        }
        AppMethodBeat.o(53030);
        return false;
    }
}
