package com.tencent.p177mm.pluginsdk.p1080h.p1081a;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.h.a.a */
public final class C14859a {
    public static final String[] vfO = new String[]{"LDPI", "HDPI", "MDPI"};
    public String desc;
    public String device;
    public String fnT;
    public String fnU;
    /* renamed from: id */
    public String f2970id;
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

    /* renamed from: com.tencent.mm.pluginsdk.h.a.a$a */
    public enum C14860a {
        ASSET,
        DOWNLOAD,
        ERROR;

        static {
            AppMethodBeat.m2505o(27450);
        }
    }

    private C14859a(String str, String str2, String str3, boolean z, boolean z2) {
        this.f2970id = str;
        this.platform = str2;
        this.device = str3;
        this.vfI = z;
        this.vfJ = z2;
    }

    private boolean diC() {
        AppMethodBeat.m2504i(27451);
        long anU = C5046bo.anU();
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            if (this.fnU != null) {
                j = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.fnU).getTime();
            }
            if (this.fnT != null) {
                j2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.fnT).getTime();
            }
            C4990ab.m7410d("MicroMsg.PushMessage", "CHECKTIME : [" + j2 + "," + j + "]");
            if (j <= anU) {
                AppMethodBeat.m2505o(27451);
                return false;
            } else if (j2 > anU) {
                AppMethodBeat.m2505o(27451);
                return false;
            } else {
                AppMethodBeat.m2505o(27451);
                return true;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(27451);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(27452);
        String str = "ad.id=" + this.f2970id + ", platform=" + this.platform + ", device=" + this.device + (this.vfI ? ", closable" : "") + (this.vfJ ? ", trans-closable" : "");
        AppMethodBeat.m2505o(27452);
        return str;
    }

    public static String ajk(String str) {
        AppMethodBeat.m2504i(27453);
        C14860a ajl = C14859a.ajl(str);
        if (ajl == C14860a.ASSET) {
            AppMethodBeat.m2505o(27453);
            return str;
        } else if (ajl == C14860a.DOWNLOAD) {
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
                AppMethodBeat.m2505o(27453);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            str = stringBuilder.append(C18628c.m29088XW()).append(str2).toString();
            AppMethodBeat.m2505o(27453);
            return str;
        } else {
            AppMethodBeat.m2505o(27453);
            return null;
        }
    }

    public static C14860a ajl(String str) {
        AppMethodBeat.m2504i(27454);
        C14860a c14860a;
        if (str.indexOf("tips/") == 0) {
            c14860a = C14860a.ASSET;
            AppMethodBeat.m2505o(27454);
            return c14860a;
        } else if (str.indexOf("weixin://") == 0) {
            c14860a = C14860a.DOWNLOAD;
            AppMethodBeat.m2505o(27454);
            return c14860a;
        } else {
            c14860a = C14860a.ERROR;
            AppMethodBeat.m2505o(27454);
            return c14860a;
        }
    }

    /* renamed from: bA */
    public static ArrayList<C14859a> m23123bA(Context context, String str) {
        AppMethodBeat.m2504i(27455);
        if (str == null || str.length() < 0) {
            AppMethodBeat.m2505o(27455);
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
            str2 = C4977b.m7373gi(context);
            C4990ab.m7410d("MicroMsg.PushMessage", "getDisplaySizeType :".concat(String.valueOf(str2)));
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
            AppMethodBeat.m2505o(27455);
            return null;
        }
        Map z = C5049br.m7595z(str, "tips");
        if (z == null) {
            AppMethodBeat.m2505o(27455);
            return null;
        }
        ArrayList<C14859a> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            String str3 = ".tips.tip" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (z.get(str3) == null) {
                break;
            }
            String str4 = (String) z.get(str3 + ".$id");
            C4990ab.m7410d("MicroMsg.PushMessage", "parseMessages id:".concat(String.valueOf(str4)));
            String str5 = (String) z.get(str3 + ".$platform");
            if (str5.equals("android")) {
                C14859a c14859a = new C14859a(str4, str5, (String) z.get(str3 + ".$device"), C5046bo.m7545d(Boolean.valueOf((String) z.get(str3 + ".$enableclose"))), C5046bo.m7545d(Boolean.valueOf((String) z.get(str3 + ".$transparentclose"))));
                int i3 = C5046bo.getInt((String) z.get(str3 + ".title.$x"), 0);
                int i4 = C5046bo.getInt((String) z.get(str3 + ".title.$y"), 0);
                int i5 = C5046bo.getInt((String) z.get(str3 + ".title.$width"), 0);
                int i6 = C5046bo.getInt((String) z.get(str3 + ".title.$font"), 0);
                int anc = C5046bo.anc((String) z.get(str3 + ".title.$color"));
                c14859a.title = (String) z.get(str3 + ".title");
                c14859a.vfK = anc;
                c14859a.vfL = new Rect(i3, i4, i5 + i3, i6 + i4);
                i3 = C5046bo.getInt((String) z.get(str3 + ".description.$x"), 0);
                i4 = C5046bo.getInt((String) z.get(str3 + ".description.$y"), 0);
                i5 = C5046bo.getInt((String) z.get(str3 + ".description.$width"), 0);
                i6 = C5046bo.getInt((String) z.get(str3 + ".description.$font"), 0);
                anc = C5046bo.anc((String) z.get(str3 + ".description.$color"));
                c14859a.desc = (String) z.get(str3 + ".description");
                c14859a.pHl = anc;
                c14859a.vfM = new Rect(i3, i4, i5 + i3, i6 + i4);
                c14859a.url = (String) z.get(str3 + ".url");
                c14859a.fnT = (String) z.get(str3 + ".time.start");
                c14859a.fnU = (String) z.get(str3 + ".time.end");
                C4990ab.m7410d("MicroMsg.PushMessage", "parseMessages id:" + c14859a.f2970id + " start:" + c14859a.fnT + " end:" + c14859a.fnU);
                HashMap hashMap = new HashMap();
                int i7 = 0;
                while (true) {
                    i4 = i7;
                    str5 = str3 + ".images.image" + (i4 > 0 ? Integer.valueOf(i4) : "");
                    str4 = (String) z.get(str5);
                    C4990ab.m7410d("MicroMsg.PushMessage", " img res:".concat(String.valueOf(str4)));
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
                    c14859a.vfN = hashMap;
                }
                C4990ab.m7410d("MicroMsg.PushMessage", "msgid :" + c14859a.f2970id);
                arrayList.add(c14859a);
            }
            i = i2 + 1;
        }
        C4990ab.m7410d("MicroMsg.PushMessage", "msgs size: " + arrayList.size());
        if (arrayList.size() > 0) {
            AppMethodBeat.m2505o(27455);
            return arrayList;
        }
        AppMethodBeat.m2505o(27455);
        return null;
    }

    public static void diD() {
        AppMethodBeat.m2504i(27456);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(8193, (Object) "");
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(8449, Long.valueOf(0));
        AppMethodBeat.m2505o(27456);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Missing block: B:26:0x0087, code skipped:
            if (r0.diC() != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: fO */
    public static C14859a m23124fO(Context context) {
        int i = 1;
        AppMethodBeat.m2504i(27457);
        C9638aw.m17190ZK();
        long g = (long) C5046bo.m7550g(C18628c.m29072Ry().get(8449, null), 0);
        long anT = C5046bo.anT() - g;
        if (g <= 0 || anT < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            C9638aw.m17190ZK();
            String str = (String) C18628c.m29072Ry().get(8193, null);
            if (!C5046bo.isNullOrNil(str)) {
                if (str.contains("id=\"setavatar\"")) {
                    C14859a.diD();
                } else {
                    C14859a c14859a;
                    if (!C5046bo.isNullOrNil(str)) {
                        ArrayList bA = C14859a.m23123bA(context, str);
                        if (bA == null || bA.size() != 1) {
                            c14859a = null;
                            if (c14859a != null) {
                                C14859a.diD();
                            } else {
                                AppMethodBeat.m2505o(27457);
                                return c14859a;
                            }
                        }
                        c14859a = (C14859a) bA.get(0);
                        if (c14859a.vfN == null || c14859a.vfN.size() <= 0) {
                            i = 0;
                        }
                        if (i != 0) {
                        }
                    }
                    c14859a = null;
                    if (c14859a != null) {
                    }
                }
            }
        } else {
            C14859a.diD();
        }
        AppMethodBeat.m2505o(27457);
        return null;
    }
}
