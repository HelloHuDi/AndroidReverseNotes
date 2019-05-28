package com.tencent.mm.pluginsdk.h.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a {
    public static final String[] vfO = new String[]{"LDPI", "HDPI", "MDPI"};
    public String desc;
    public String device;
    public String fnT;
    public String fnU;
    public String id;
    public int pHl;
    public String platform;
    public String title;
    public String url;
    public boolean vfI;
    public boolean vfJ;
    public int vfK;
    public Rect vfL;
    public Rect vfM;
    public Map<String, String> vfN;

    public enum a {
        ASSET,
        DOWNLOAD,
        ERROR;

        static {
            AppMethodBeat.o(27450);
        }
    }

    private a(String str, String str2, String str3, boolean z, boolean z2) {
        this.id = str;
        this.platform = str2;
        this.device = str3;
        this.vfI = z;
        this.vfJ = z2;
    }

    private boolean diC() {
        AppMethodBeat.i(27451);
        long anU = bo.anU();
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            if (this.fnU != null) {
                j = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.fnU).getTime();
            }
            if (this.fnT != null) {
                j2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.fnT).getTime();
            }
            ab.d("MicroMsg.PushMessage", "CHECKTIME : [" + j2 + "," + j + "]");
            if (j <= anU) {
                AppMethodBeat.o(27451);
                return false;
            } else if (j2 > anU) {
                AppMethodBeat.o(27451);
                return false;
            } else {
                AppMethodBeat.o(27451);
                return true;
            }
        } catch (Exception e) {
            AppMethodBeat.o(27451);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.i(27452);
        String str = "ad.id=" + this.id + ", platform=" + this.platform + ", device=" + this.device + (this.vfI ? ", closable" : "") + (this.vfJ ? ", trans-closable" : "");
        AppMethodBeat.o(27452);
        return str;
    }

    public static String ajk(String str) {
        AppMethodBeat.i(27453);
        a ajl = ajl(str);
        if (ajl == a.ASSET) {
            AppMethodBeat.o(27453);
            return str;
        } else if (ajl == a.DOWNLOAD) {
            String str2;
            if (str == null) {
                str2 = null;
            } else {
                int lastIndexOf = str.lastIndexOf("/");
                if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
                    str2 = null;
                } else {
                    str2 = str.substring(lastIndexOf + 1);
                }
            }
            if (str2 == null) {
                AppMethodBeat.o(27453);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            aw.ZK();
            str = stringBuilder.append(c.XW()).append(str2).toString();
            AppMethodBeat.o(27453);
            return str;
        } else {
            AppMethodBeat.o(27453);
            return null;
        }
    }

    public static a ajl(String str) {
        AppMethodBeat.i(27454);
        a aVar;
        if (str.indexOf("tips/") == 0) {
            aVar = a.ASSET;
            AppMethodBeat.o(27454);
            return aVar;
        } else if (str.indexOf("weixin://") == 0) {
            aVar = a.DOWNLOAD;
            AppMethodBeat.o(27454);
            return aVar;
        } else {
            aVar = a.ERROR;
            AppMethodBeat.o(27454);
            return aVar;
        }
    }

    public static ArrayList<a> bA(Context context, String str) {
        AppMethodBeat.i(27455);
        if (str == null || str.length() < 0) {
            AppMethodBeat.o(27455);
            return null;
        }
        HashSet hashSet;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str2 = displayMetrics.heightPixels + VideoMaterialUtil.CRAZYFACE_X + displayMetrics.widthPixels;
        if (str2 == null) {
            hashSet = null;
        } else {
            HashSet hashSet2 = new HashSet();
            hashSet2.add(str2);
            str2 = b.gi(context);
            ab.d("MicroMsg.PushMessage", "getDisplaySizeType :".concat(String.valueOf(str2)));
            if (str2 != null) {
                String[] split = str2.split("_");
                if (split == null || split.length < 2) {
                    str2 = null;
                } else {
                    str2 = split[0];
                }
                hashSet2.add(str2 + "_L");
                hashSet2.add(str2 + "_P");
            }
            hashSet = hashSet2;
        }
        if (hashSet == null || hashSet.size() <= 0) {
            AppMethodBeat.o(27455);
            return null;
        }
        Map z = br.z(str, "tips");
        if (z == null) {
            AppMethodBeat.o(27455);
            return null;
        }
        ArrayList<a> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            String str3 = ".tips.tip" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (z.get(str3) == null) {
                break;
            }
            String str4 = (String) z.get(str3 + ".$id");
            ab.d("MicroMsg.PushMessage", "parseMessages id:".concat(String.valueOf(str4)));
            String str5 = (String) z.get(str3 + ".$platform");
            if (str5.equals("android")) {
                a aVar = new a(str4, str5, (String) z.get(str3 + ".$device"), bo.d(Boolean.valueOf((String) z.get(str3 + ".$enableclose"))), bo.d(Boolean.valueOf((String) z.get(str3 + ".$transparentclose"))));
                int i3 = bo.getInt((String) z.get(str3 + ".title.$x"), 0);
                int i4 = bo.getInt((String) z.get(str3 + ".title.$y"), 0);
                int i5 = bo.getInt((String) z.get(str3 + ".title.$width"), 0);
                int i6 = bo.getInt((String) z.get(str3 + ".title.$font"), 0);
                int anc = bo.anc((String) z.get(str3 + ".title.$color"));
                aVar.title = (String) z.get(str3 + ".title");
                aVar.vfK = anc;
                aVar.vfL = new Rect(i3, i4, i5 + i3, i6 + i4);
                i3 = bo.getInt((String) z.get(str3 + ".description.$x"), 0);
                i4 = bo.getInt((String) z.get(str3 + ".description.$y"), 0);
                i5 = bo.getInt((String) z.get(str3 + ".description.$width"), 0);
                i6 = bo.getInt((String) z.get(str3 + ".description.$font"), 0);
                anc = bo.anc((String) z.get(str3 + ".description.$color"));
                aVar.desc = (String) z.get(str3 + ".description");
                aVar.pHl = anc;
                aVar.vfM = new Rect(i3, i4, i5 + i3, i6 + i4);
                aVar.url = (String) z.get(str3 + ".url");
                aVar.fnT = (String) z.get(str3 + ".time.start");
                aVar.fnU = (String) z.get(str3 + ".time.end");
                ab.d("MicroMsg.PushMessage", "parseMessages id:" + aVar.id + " start:" + aVar.fnT + " end:" + aVar.fnU);
                HashMap hashMap = new HashMap();
                int i7 = 0;
                while (true) {
                    i4 = i7;
                    str5 = str3 + ".images.image" + (i4 > 0 ? Integer.valueOf(i4) : "");
                    str4 = (String) z.get(str5);
                    ab.d("MicroMsg.PushMessage", " img res:".concat(String.valueOf(str4)));
                    if (str4 == null) {
                        break;
                    }
                    str5 = (String) z.get(str5 + ".$type");
                    if (hashSet.contains(str5)) {
                        hashMap.put(str5, str4);
                    }
                    i7 = i4 + 1;
                }
                if (hashMap.size() > 0) {
                    aVar.vfN = hashMap;
                }
                ab.d("MicroMsg.PushMessage", "msgid :" + aVar.id);
                arrayList.add(aVar);
            }
            i = i2 + 1;
        }
        ab.d("MicroMsg.PushMessage", "msgs size: " + arrayList.size());
        if (arrayList.size() > 0) {
            AppMethodBeat.o(27455);
            return arrayList;
        }
        AppMethodBeat.o(27455);
        return null;
    }

    public static void diD() {
        AppMethodBeat.i(27456);
        aw.ZK();
        c.Ry().set(8193, (Object) "");
        aw.ZK();
        c.Ry().set(8449, Long.valueOf(0));
        AppMethodBeat.o(27456);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Missing block: B:26:0x0087, code skipped:
            if (r0.diC() != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a fO(Context context) {
        int i = 1;
        AppMethodBeat.i(27457);
        aw.ZK();
        long g = (long) bo.g(c.Ry().get(8449, null), 0);
        long anT = bo.anT() - g;
        if (g <= 0 || anT < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            aw.ZK();
            String str = (String) c.Ry().get(8193, null);
            if (!bo.isNullOrNil(str)) {
                if (str.contains("id=\"setavatar\"")) {
                    diD();
                } else {
                    a aVar;
                    if (!bo.isNullOrNil(str)) {
                        ArrayList bA = bA(context, str);
                        if (bA == null || bA.size() != 1) {
                            aVar = null;
                            if (aVar != null) {
                                diD();
                            } else {
                                AppMethodBeat.o(27457);
                                return aVar;
                            }
                        }
                        aVar = (a) bA.get(0);
                        if (aVar.vfN == null || aVar.vfN.size() <= 0) {
                            i = 0;
                        }
                        if (i != 0) {
                        }
                    }
                    aVar = null;
                    if (aVar != null) {
                    }
                }
            }
        } else {
            diD();
        }
        AppMethodBeat.o(27457);
        return null;
    }
}
