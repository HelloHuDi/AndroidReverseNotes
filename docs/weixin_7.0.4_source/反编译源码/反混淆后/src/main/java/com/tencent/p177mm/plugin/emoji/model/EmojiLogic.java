package com.tencent.p177mm.plugin.emoji.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C45448b;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.protobuf.aik;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.baseutils.BaseTemplateParser;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.mm.plugin.emoji.model.EmojiLogic */
public class EmojiLogic {
    public static native boolean extractForeground(int[] iArr, int i, int i2);

    public static native boolean gifToMMAni(byte[] bArr, PByteArray pByteArray, int i);

    /* renamed from: aF */
    public static int m44079aF(byte[] bArr) {
        AppMethodBeat.m2504i(53004);
        int aF = C2933b.m5223aF(bArr);
        AppMethodBeat.m2505o(53004);
        return aF;
    }

    /* renamed from: Jf */
    public static String m44060Jf(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(53005);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(53005);
        } else {
            int asZ = (int) C5730e.asZ(str);
            if (asZ > 0) {
                byte[] e = C5730e.m8632e(str, 0, asZ);
                str2 = C1178g.m2591x(e);
                if (!(str2 == null && e == null)) {
                    C5730e.m8624b(C2933b.m5221Yb() + str2, e, e.length);
                    if (C5063r.m7677bS(e)) {
                        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48565a(str2, "", EmojiInfo.yau, EmojiInfo.zYS, e.length, "", "");
                    } else {
                        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48565a(str2, "", EmojiInfo.yau, EmojiInfo.zYR, e.length, "", "");
                    }
                }
                AppMethodBeat.m2505o(53005);
            } else {
                AppMethodBeat.m2505o(53005);
            }
        }
        return str2;
    }

    /* renamed from: b */
    public static String m44080b(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.m2504i(53006);
        if (wXMediaMessage.getType() != 8) {
            AppMethodBeat.m2505o(53006);
            return null;
        }
        WXEmojiObject wXEmojiObject = (WXEmojiObject) wXMediaMessage.mediaObject;
        if (!C5046bo.m7540cb(wXEmojiObject.emojiData)) {
            C4990ab.m7410d("MicroMsg.emoji.EmojiLogic", " fileData:" + wXEmojiObject.emojiData.length);
            String x = C1178g.m2591x(wXEmojiObject.emojiData);
            EmojiLogic.m44077a(context, wXMediaMessage.thumbData, x, wXEmojiObject.emojiData, str);
            AppMethodBeat.m2505o(53006);
            return x;
        } else if (C5046bo.isNullOrNil(wXEmojiObject.emojiPath)) {
            AppMethodBeat.m2505o(53006);
            return null;
        } else {
            int asZ = (int) C5730e.asZ(wXEmojiObject.emojiPath);
            if (asZ > 0) {
                byte[] e = C5730e.m8632e(wXEmojiObject.emojiPath, 0, asZ);
                String x2 = C1178g.m2591x(e);
                EmojiLogic.m44077a(context, wXMediaMessage.thumbData, x2, e, str);
                AppMethodBeat.m2505o(53006);
                return x2;
            }
            AppMethodBeat.m2505o(53006);
            return null;
        }
    }

    /* renamed from: a */
    private static void m44077a(Context context, byte[] bArr, String str, byte[] bArr2, String str2) {
        AppMethodBeat.m2504i(53007);
        if (str == null && bArr2 == null) {
            AppMethodBeat.m2505o(53007);
            return;
        }
        EmojiInfo a;
        String Yb = C2933b.m5221Yb();
        C5730e.m8624b(Yb + str, bArr2, bArr2.length);
        if (C5063r.m7677bS(bArr2)) {
            a = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48565a(str, "", EmojiInfo.yau, EmojiInfo.zYX, bArr2.length, str2, "");
        } else {
            a = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48565a(str, "", EmojiInfo.yau, EmojiInfo.zYY, bArr2.length, str2, "");
        }
        EmojiLogic.m44076a(context, bArr, str, Yb, a);
        AppMethodBeat.m2505o(53007);
    }

    /* renamed from: a */
    public static void m44076a(Context context, byte[] bArr, String str, String str2, EmojiInfo emojiInfo) {
        Bitmap hk;
        Bitmap bitmap;
        AppMethodBeat.m2504i(53008);
        if (bArr == null) {
            String str3 = "MicroMsg.emoji.EmojiLogic";
            String str4 = "insertEmoji: thumb is null, emojiInfo is null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(emojiInfo == null);
            C4990ab.m7411d(str3, str4, objArr);
            if (emojiInfo != null) {
                hk = emojiInfo.mo48542hk(context);
            } else {
                AppMethodBeat.m2505o(53008);
                return;
            }
        }
        hk = C5056d.m7652bQ(bArr);
        if (hk == null || (hk.getWidth() <= 300 && hk.getHeight() <= 300)) {
            bitmap = hk;
        } else {
            int width = hk.getWidth();
            int height = hk.getHeight();
            C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "cpan app msg width:%d height:%d", Integer.valueOf(width), Integer.valueOf(height));
            if (width > height) {
                float f = ((float) height) / ((float) width);
                height = 300;
                width = (int) (f * 300.0f);
            } else {
                float f2 = ((float) width) / ((float) height);
                width = 300;
                height = (int) (f2 * 300.0f);
            }
            C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "cpan app msg new width:%d new height:%d", Integer.valueOf(height), Integer.valueOf(width));
            bitmap = C5056d.m7615a(hk, width, height, false, true);
        }
        if (bitmap != null) {
            try {
                if (bitmap.getByteCount() > 65536) {
                    C5056d.m7625a(bitmap, 80, CompressFormat.JPEG, str2 + str + "_thumb", true);
                    C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is over size. save as jpg. size :%d", Integer.valueOf(bitmap.getByteCount()));
                    AppMethodBeat.m2505o(53008);
                    return;
                }
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, str2 + str + "_thumb", true);
                C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is in normal size. sav as png. size :%d", Integer.valueOf(bitmap.getByteCount()));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiLogic", e, "insertEmoji Error", new Object[0]);
                AppMethodBeat.m2505o(53008);
                return;
            }
        }
        AppMethodBeat.m2505o(53008);
    }

    /* renamed from: a */
    public static EmojiInfo m44074a(String str, String str2, C1282i c1282i) {
        AppMethodBeat.m2504i(53009);
        if (C1720g.m3536RP().isSDCardAvailable()) {
            EmojiInfo r = EmojiLogic.m44081r(str, 4, str2);
            if (r == null) {
                C32291o.ahp().mo43768a(str2, null, C20364g.m31462h(str, str2, new Object[0]), c1282i);
                C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "[cpan] get emoji info, try to load image:%s", str2);
            }
            AppMethodBeat.m2505o(53009);
            return r;
        } else if (C4996ah.getContext() == null) {
            AppMethodBeat.m2505o(53009);
            return null;
        } else if (C4996ah.getContext().getResources() == null) {
            AppMethodBeat.m2505o(53009);
            return null;
        } else {
            new EmojiInfo().field_type = EmojiInfo.zYR;
            AppMethodBeat.m2505o(53009);
            return null;
        }
    }

    /* renamed from: r */
    public static EmojiInfo m44081r(String str, int i, String str2) {
        int i2 = 0;
        AppMethodBeat.m2504i(53010);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7410d("MicroMsg.emoji.EmojiLogic", "getIcon : productId is null.");
            AppMethodBeat.m2505o(53010);
            return null;
        }
        EmojiInfo emojiInfo = new EmojiInfo();
        String K = EmojiLogic.m44072K(C2933b.m5221Yb(), str, str2);
        if (C5730e.m8628ct(K)) {
            C5728b c5728b = new C5728b(K);
            if (c5728b.exists()) {
                if (c5728b.length() < 1) {
                    c5728b.delete();
                } else {
                    emojiInfo.field_type = C2933b.m5223aF(C5730e.m8632e(K, 0, 10));
                    i2 = 1;
                }
            }
        }
        if (i2 == 0) {
            C4990ab.m7410d("MicroMsg.emoji.EmojiLogic", "banner icon does not exist. icon path :" + K + "...., icon type:" + i);
            AppMethodBeat.m2505o(53010);
            return null;
        }
        emojiInfo.field_md5 = EmojiLogic.getMD5(str, str2);
        emojiInfo.field_catalog = EmojiLogic.m44083ud(i);
        emojiInfo.field_groupId = str;
        emojiInfo.field_temp = 1;
        AppMethodBeat.m2505o(53010);
        return emojiInfo;
    }

    /* renamed from: ud */
    private static int m44083ud(int i) {
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
    /* renamed from: a */
    public static boolean m44078a(String str, String str2, String str3, EmojiGroupInfo emojiGroupInfo) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(53011);
        String str4 = C6457e.euQ + str;
        String str5 = C2933b.m5221Yb() + str;
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
                                C5728b c5728b = new C5728b(str5 + "/" + zipEntry.getName());
                                if (c5728b.isFile()) {
                                    c5728b.delete();
                                }
                                c5728b.dMC().mkdirs();
                                if (!toLowerCase.startsWith(".") && (toLowerCase.endsWith(".gif") || toLowerCase.endsWith(".png"))) {
                                    int read;
                                    if (zipEntry.getName().toLowerCase().contains("/large/")) {
                                        outputStream2 = C5730e.m8617L(str5 + "/" + toLowerCase, false);
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
                                            String atg = C5730e.atg(str5 + "/" + toLowerCase);
                                            C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "md5:%s index:%d", atg, Integer.valueOf(i));
                                            C5728b c5728b2 = new C5728b(str5 + "/" + toLowerCase);
                                            C5728b c5728b3 = new C5728b(str5 + "/" + atg);
                                            if (C5063r.amo(C5736j.m8649w(c5728b2.mUri))) {
                                                read = EmojiInfo.zYS;
                                            } else {
                                                read = EmojiInfo.zYR;
                                            }
                                            aqi = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.aqi(atg);
                                            if (aqi == null) {
                                                aqi = new EmojiInfo();
                                                aqi.field_catalog = 0;
                                            }
                                            aqi.field_name = toLowerCase;
                                            aqi.field_md5 = atg;
                                            aqi.field_size = (int) c5728b2.length();
                                            aqi.field_type = read;
                                            aqi.field_groupId = str;
                                            aqi.field_idx = i;
                                            arrayList.add(aqi);
                                            c5728b2.mo11675o(c5728b3);
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
                                                        C4990ab.m7412e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                                                        if (outputStream != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (zipFile != null) {
                                                        }
                                                        AppMethodBeat.m2505o(53011);
                                                        return false;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (outputStream != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (zipFile != null) {
                                                        }
                                                        AppMethodBeat.m2505o(53011);
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
                                                    AppMethodBeat.m2505o(53011);
                                                    throw th;
                                                }
                                            }
                                            i++;
                                            inputStream = inputStream2;
                                        } catch (Exception e3) {
                                            e = e3;
                                            outputStream = outputStream2;
                                            C4990ab.m7412e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                                            if (outputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (zipFile != null) {
                                            }
                                            AppMethodBeat.m2505o(53011);
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
                                            AppMethodBeat.m2505o(53011);
                                            throw th;
                                        }
                                    } else if (toLowerCase.startsWith("icon")) {
                                        outputStream2 = C5730e.m8617L(str5 + "/" + (C1178g.m2591x(str.getBytes()) + "_panel_enable"), false);
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
                        AppMethodBeat.m2505o(53011);
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
                            C5728b c5728b4 = new C5728b(str5 + "/" + zipEntry.getName());
                            if (c5728b4.isFile()) {
                                c5728b4.delete();
                            }
                            c5728b4.dMC().mkdirs();
                            if (zipEntry.getName().toLowerCase().contains("/thumb/")) {
                                int lastIndexOf = toLowerCase2.lastIndexOf(".") + 1;
                                toLowerCase2 = toLowerCase2.substring(0, lastIndexOf - 1) + "_cover." + toLowerCase2.substring(lastIndexOf);
                                outputStream2 = C5730e.m8617L(str5 + "/" + toLowerCase2, false);
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
                                    new C5728b(str5 + "/" + toLowerCase2).mo11675o(new C5728b(str5 + "/" + substring + "_cover"));
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
                    emojiGroupInfo = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYo.mo74770bZ(str, false);
                }
                emojiGroupInfo.field_productID = str;
                if (!C5046bo.isNullOrNil(str2)) {
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
                if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48584j(arrayList, str)) {
                    boolean c = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYo.mo74771c(emojiGroupInfo);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        aqi = (EmojiInfo) it.next();
                        aqi.field_reserved4 = 0;
                        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35642c(aqi, true);
                    }
                    C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "saveGroupFlag:%b saveEmojiFlag:%b", Boolean.valueOf(c), Boolean.valueOf(r6));
                } else {
                    C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "saveEmojiFlag:%b", Boolean.valueOf(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48584j(arrayList, str)));
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                zipFile.close();
                AppMethodBeat.m2505o(53011);
                return true;
            } catch (Exception e322) {
                e = e322;
                C4990ab.m7412e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                if (outputStream != null) {
                }
                if (inputStream != null) {
                }
                if (zipFile != null) {
                }
                AppMethodBeat.m2505o(53011);
                return false;
            }
        } catch (Exception e3222) {
            e = e3222;
            zipFile = null;
            C4990ab.m7412e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            AppMethodBeat.m2505o(53011);
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
            AppMethodBeat.m2505o(53011);
            throw th;
        }
    }

    public static aik bkd() {
        AppMethodBeat.m2504i(53012);
        aik aik = new aik();
        aik.wov = 1;
        aik.wox = 1;
        AppMethodBeat.m2505o(53012);
        return aik;
    }

    /* renamed from: Jt */
    public static String m44065Jt(String str) {
        AppMethodBeat.m2504i(53013);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(53013);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<productid>" + str + "</productid>");
        stringBuilder.append("</xml>");
        C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
        AppMethodBeat.m2505o(53013);
        return stringBuilder.toString();
    }

    /* renamed from: r */
    public static String m44082r(int i, String str, String str2) {
        AppMethodBeat.m2504i(53014);
        if (i != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<xml>");
            stringBuilder.append("<designeruin>" + i + "</designeruin>");
            stringBuilder.append("<designername>" + str + "</designername>");
            stringBuilder.append("<designerrediretcturl>" + str2 + "</designerrediretcturl>");
            stringBuilder.append("</xml>");
            C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
            AppMethodBeat.m2505o(53014);
            return stringBuilder.toString();
        }
        AppMethodBeat.m2505o(53014);
        return null;
    }

    /* renamed from: Jm */
    public static int m44063Jm(String str) {
        int cB;
        Exception e;
        AppMethodBeat.m2504i(53015);
        try {
            cB = C1183p.m2611cB((String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.designeruin"));
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", Integer.valueOf(cB));
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", e.toString());
                AppMethodBeat.m2505o(53015);
                return cB;
            }
        } catch (Exception e3) {
            e = e3;
            cB = 0;
        }
        AppMethodBeat.m2505o(53015);
        return cB;
    }

    /* renamed from: Jn */
    public static String m44064Jn(String str) {
        String str2;
        Exception e;
        AppMethodBeat.m2504i(53016);
        try {
            str2 = (String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.designername");
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", str2);
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", e.toString());
                AppMethodBeat.m2505o(53016);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", e.toString());
            AppMethodBeat.m2505o(53016);
            return str2;
        }
        AppMethodBeat.m2505o(53016);
        return str2;
    }

    /* renamed from: Ju */
    public static String m44066Ju(String str) {
        String str2;
        Exception e;
        AppMethodBeat.m2504i(53017);
        try {
            str2 = (String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.designerrediretcturl");
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "designerrediretcturl:%s", str2);
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", e.toString());
                AppMethodBeat.m2505o(53017);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", e.toString());
            AppMethodBeat.m2505o(53017);
            return str2;
        }
        AppMethodBeat.m2505o(53017);
        return str2;
    }

    /* renamed from: Jl */
    public static String m44062Jl(String str) {
        String str2;
        Exception e;
        AppMethodBeat.m2504i(53018);
        try {
            str2 = (String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.productid");
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "productId:%s", str2);
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", e.toString());
                AppMethodBeat.m2505o(53018);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", e.toString());
            AppMethodBeat.m2505o(53018);
            return str2;
        }
        AppMethodBeat.m2505o(53018);
        return str2;
    }

    /* renamed from: Jk */
    public static String m44061Jk(String str) {
        AppMethodBeat.m2504i(53019);
        C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "url:%s", str);
        String str2 = "";
        if (!TextUtils.isEmpty(str) && str.startsWith("http://weixin.qq.com/emoticonstore/")) {
            str2 = str.substring(str.lastIndexOf("/") + 1);
        }
        AppMethodBeat.m2505o(53019);
        return str2;
    }

    /* renamed from: a */
    public static String m44075a(int i, String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.m2504i(53020);
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
            C4990ab.m7417i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
            AppMethodBeat.m2505o(53020);
            return stringBuilder.toString();
        }
        AppMethodBeat.m2505o(53020);
        return null;
    }

    /* renamed from: Jv */
    public static int m44067Jv(String str) {
        int ank;
        Exception e;
        AppMethodBeat.m2504i(53021);
        try {
            ank = C5046bo.ank((String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.tid"));
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "tid:%s", Integer.valueOf(ank));
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", e.toString());
                AppMethodBeat.m2505o(53021);
                return ank;
            }
        } catch (Exception e3) {
            e = e3;
            ank = 0;
        }
        AppMethodBeat.m2505o(53021);
        return ank;
    }

    /* renamed from: Jw */
    public static String m44068Jw(String str) {
        String str2;
        Exception e;
        AppMethodBeat.m2504i(53022);
        try {
            str2 = (String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.title");
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "title:%s", str2);
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", e.toString());
                AppMethodBeat.m2505o(53022);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", e.toString());
            AppMethodBeat.m2505o(53022);
            return str2;
        }
        AppMethodBeat.m2505o(53022);
        return str2;
    }

    /* renamed from: Jx */
    public static String m44069Jx(String str) {
        String str2;
        Exception e;
        AppMethodBeat.m2504i(53023);
        try {
            str2 = (String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.desc");
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "desc:%s", str2);
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", e.toString());
                AppMethodBeat.m2505o(53023);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", e.toString());
            AppMethodBeat.m2505o(53023);
            return str2;
        }
        AppMethodBeat.m2505o(53023);
        return str2;
    }

    /* renamed from: Jy */
    public static String m44070Jy(String str) {
        String str2;
        Exception e;
        AppMethodBeat.m2504i(53024);
        try {
            str2 = (String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.iconUrl");
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "iconUrl:%s", str2);
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", e.toString());
                AppMethodBeat.m2505o(53024);
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", e.toString());
            AppMethodBeat.m2505o(53024);
            return str2;
        }
        AppMethodBeat.m2505o(53024);
        return str2;
    }

    /* renamed from: Jz */
    public static String m44071Jz(String str) {
        String bc;
        Exception e;
        AppMethodBeat.m2504i(53025);
        String str2 = "";
        try {
            bc = C5046bo.m7532bc((String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.secondUrl"), "");
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "secondUrl:%s", bc);
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", e.toString());
                AppMethodBeat.m2505o(53025);
                return bc;
            }
        } catch (Exception e3) {
            e = e3;
            bc = str2;
        }
        AppMethodBeat.m2505o(53025);
        return bc;
    }

    /* renamed from: JA */
    public static int m44058JA(String str) {
        int ank;
        Exception e;
        AppMethodBeat.m2504i(53026);
        try {
            ank = C5046bo.ank((String) C5049br.m7595z(str, BaseTemplateParser.POSTFIX_ORIG).get(".xml.pageType"));
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "pageType:%s", Integer.valueOf(ank));
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", e.toString());
                AppMethodBeat.m2505o(53026);
                return ank;
            }
        } catch (Exception e3) {
            e = e3;
            ank = 0;
        }
        AppMethodBeat.m2505o(53026);
        return ank;
    }

    /* renamed from: K */
    public static String m44072K(String str, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.m2504i(53027);
        if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(str3)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and url are null.");
            AppMethodBeat.m2505o(53027);
        } else {
            String md5 = EmojiLogic.getMD5(str2, str3);
            if (!C5046bo.isNullOrNil(md5)) {
                if (C5046bo.isNullOrNil(str2)) {
                    str4 = str + md5;
                } else {
                    str4 = str + str2 + "/" + md5;
                }
            }
            AppMethodBeat.m2505o(53027);
        }
        return str4;
    }

    /* renamed from: L */
    public static String m44073L(String str, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.m2504i(53028);
        if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(str3)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and md5 are null.");
            AppMethodBeat.m2505o(53028);
        } else {
            if (!C5046bo.isNullOrNil(str3)) {
                if (C5046bo.isNullOrNil(str2)) {
                    str4 = str + str3;
                } else {
                    str4 = str + str2 + "/" + str3;
                }
            }
            C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path. productid:%s md5:%s path:%s", str2, str3, str4);
            AppMethodBeat.m2505o(53028);
        }
        return str4;
    }

    private static String getMD5(String str, String str2) {
        AppMethodBeat.m2504i(53029);
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiLogic", "[cpan] product id and url are null.");
            AppMethodBeat.m2505o(53029);
            return null;
        }
        String x;
        if (C5046bo.isNullOrNil(str2)) {
            x = C1178g.m2591x(str.getBytes());
        } else {
            x = C1178g.m2591x(str2.getBytes());
        }
        AppMethodBeat.m2505o(53029);
        return x;
    }

    /* renamed from: JB */
    public static boolean m44059JB(String str) {
        AppMethodBeat.m2504i(53030);
        if (!C5046bo.isNullOrNil(str)) {
            try {
                if (C45448b.m83719rR(str)) {
                    C4990ab.m7411d("MicroMsg.emoji.EmojiLogic", "In Not Auto Download Time Range. timeRange:%s", str);
                    AppMethodBeat.m2505o(53030);
                    return true;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.emoji.EmojiLogic", "isInNotAutoDownloadTimeRange :%s", C5046bo.m7574l(e));
            }
        }
        AppMethodBeat.m2505o(53030);
        return false;
    }
}
