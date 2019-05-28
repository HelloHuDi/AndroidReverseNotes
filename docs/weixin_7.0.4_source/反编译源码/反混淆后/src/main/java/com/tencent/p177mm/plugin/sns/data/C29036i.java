package com.tencent.p177mm.plugin.sns.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.modelsfs.C1869f;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C9430of;
import com.tencent.p177mm.p230g.p231a.C9453qw;
import com.tencent.p177mm.plugin.sns.p1297d.C21879a;
import com.tencent.p177mm.plugin.sns.p517i.C39737c;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.plugin.sns.data.i */
public final class C29036i {
    public static String jrk = "<TimelineObject>";
    public static String jrl = "</TimelineObject>";
    private static Vibrator kgA;
    public static int qGd = BaseClientBuilder.API_PRIORITY_OTHER;
    public static String qGe = "/";
    private static String qGf = "snsb";
    private static int qGg = -1;
    private static int qGh = -1;
    public static int qGi = 4194304;
    public static int qGj = 1048576;

    /* renamed from: bc */
    public static String m46102bc(int i, String str) {
        AppMethodBeat.m2504i(35804);
        String str2 = i + "-" + str;
        AppMethodBeat.m2505o(35804);
        return str2;
    }

    /* renamed from: dc */
    public static String m46106dc(List<bau> list) {
        AppMethodBeat.m2504i(35805);
        String str;
        if (list == null || list.size() == 0) {
            str = "";
            AppMethodBeat.m2505o(35805);
            return str;
        }
        str = "";
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            bau bau = (bau) it.next();
            if (str.length() > 0) {
                str = str + "-";
            }
            str = str + bau.f17915Id;
            i = i2 + 1;
            if (i >= 4) {
                break;
            }
        }
        AppMethodBeat.m2505o(35805);
        return str;
    }

    /* renamed from: c */
    private static String m46104c(bau bau) {
        AppMethodBeat.m2504i(35806);
        String str;
        if (C5046bo.isNullOrNil(bau.wEV)) {
            str = "";
            try {
                str = C1178g.m2591x(bau.toByteArray());
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(35806);
            return str;
        }
        str = bau.wEV;
        AppMethodBeat.m2505o(35806);
        return str;
    }

    /* renamed from: Xa */
    public static String m46078Xa(String str) {
        AppMethodBeat.m2504i(35807);
        String str2 = "snst_" + C29036i.m46090Xm(str);
        AppMethodBeat.m2505o(35807);
        return str2;
    }

    /* renamed from: Xb */
    public static String m46079Xb(String str) {
        AppMethodBeat.m2504i(35808);
        String str2 = "snsu_" + C29036i.m46090Xm(str);
        AppMethodBeat.m2505o(35808);
        return str2;
    }

    /* renamed from: Xc */
    public static String m46080Xc(String str) {
        AppMethodBeat.m2504i(35809);
        String str2 = "snsb_" + C29036i.m46090Xm(str);
        AppMethodBeat.m2505o(35809);
        return str2;
    }

    /* renamed from: d */
    public static String m46105d(bau bau) {
        AppMethodBeat.m2504i(35810);
        String str = "snsb_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35810);
            return str;
        }
        AppMethodBeat.m2505o(35810);
        return str;
    }

    /* renamed from: e */
    public static String m46108e(bau bau) {
        AppMethodBeat.m2504i(35811);
        String str = "snst_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35811);
            return str;
        }
        AppMethodBeat.m2505o(35811);
        return str;
    }

    /* renamed from: Xd */
    public static String m46081Xd(String str) {
        AppMethodBeat.m2504i(35812);
        String str2 = "snsu_" + C29036i.m46090Xm(str);
        AppMethodBeat.m2505o(35812);
        return str2;
    }

    /* renamed from: f */
    public static String m46110f(bau bau) {
        AppMethodBeat.m2504i(35813);
        String str = "snsu_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35813);
            return str;
        }
        AppMethodBeat.m2505o(35813);
        return str;
    }

    /* renamed from: g */
    public static String m46111g(bau bau) {
        AppMethodBeat.m2504i(35814);
        String str = "snsblurt_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35814);
            return str;
        }
        AppMethodBeat.m2505o(35814);
        return str;
    }

    /* renamed from: h */
    public static String m46112h(bau bau) {
        AppMethodBeat.m2504i(35815);
        String str = "snsblurs_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35815);
            return str;
        }
        AppMethodBeat.m2505o(35815);
        return str;
    }

    /* renamed from: i */
    public static String m46113i(bau bau) {
        AppMethodBeat.m2504i(35816);
        String str = "snstblur_src_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35816);
            return str;
        }
        AppMethodBeat.m2505o(35816);
        return str;
    }

    /* renamed from: j */
    public static String m46116j(bau bau) {
        AppMethodBeat.m2504i(35817);
        String str = "sight_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35817);
            return str;
        }
        AppMethodBeat.m2505o(35817);
        return str;
    }

    /* renamed from: k */
    public static String m46119k(bau bau) {
        AppMethodBeat.m2504i(35818);
        String str = "sightad_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str, bau.wEU);
            AppMethodBeat.m2505o(35818);
            return str;
        }
        AppMethodBeat.m2505o(35818);
        return str;
    }

    /* renamed from: l */
    public static String m46121l(bau bau) {
        AppMethodBeat.m2504i(35819);
        String str = "snsb_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35819);
            return str;
        }
        AppMethodBeat.m2505o(35819);
        return str;
    }

    /* renamed from: m */
    public static String m46122m(bau bau) {
        AppMethodBeat.m2504i(35820);
        String str = "sns_tmpb_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35820);
            return str;
        }
        AppMethodBeat.m2505o(35820);
        return str;
    }

    /* renamed from: Xe */
    public static String m46082Xe(String str) {
        AppMethodBeat.m2504i(35821);
        String str2 = "sns_tmpb_" + C29036i.m46090Xm(str);
        AppMethodBeat.m2505o(35821);
        return str2;
    }

    /* renamed from: n */
    public static String m46123n(bau bau) {
        AppMethodBeat.m2504i(35822);
        String str = "sns_tmpt_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35822);
            return str;
        }
        AppMethodBeat.m2505o(35822);
        return str;
    }

    /* renamed from: Xf */
    public static String m46083Xf(String str) {
        AppMethodBeat.m2504i(35823);
        String str2 = "sns_tmpt_" + C29036i.m46090Xm(str);
        AppMethodBeat.m2505o(35823);
        return str2;
    }

    /* renamed from: o */
    public static String m46124o(bau bau) {
        AppMethodBeat.m2504i(35824);
        String str = "sns_tmpu_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35824);
            return str;
        }
        AppMethodBeat.m2505o(35824);
        return str;
    }

    /* renamed from: p */
    public static String m46126p(bau bau) {
        AppMethodBeat.m2504i(35825);
        String str = "sns_tmps_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35825);
            return str;
        }
        AppMethodBeat.m2505o(35825);
        return str;
    }

    /* renamed from: Xg */
    public static String m46084Xg(String str) {
        AppMethodBeat.m2504i(35826);
        String str2 = "sns_tmps_" + C29036i.m46090Xm(str);
        AppMethodBeat.m2505o(35826);
        return str2;
    }

    /* renamed from: q */
    public static String m46127q(bau bau) {
        AppMethodBeat.m2504i(35827);
        String str = "sns_tmpsad_" + C29036i.m46090Xm(bau.f17915Id);
        if (bau.wET == 1) {
            str = C1869f.m3980s(str + C29036i.m46104c(bau), bau.wEU);
            AppMethodBeat.m2505o(35827);
            return str;
        }
        AppMethodBeat.m2505o(35827);
        return str;
    }

    /* renamed from: bd */
    public static String m46103bd(int i, String str) {
        AppMethodBeat.m2504i(35828);
        String str2 = i + "-" + str;
        AppMethodBeat.m2505o(35828);
        return str2;
    }

    /* renamed from: Xh */
    public static String m46085Xh(String str) {
        AppMethodBeat.m2504i(35829);
        String concat = "9_".concat(String.valueOf(str));
        AppMethodBeat.m2505o(35829);
        return concat;
    }

    /* renamed from: am */
    public static void m46099am(String str, long j) {
        AppMethodBeat.m2504i(35830);
        C4990ab.m7410d("MicroMsg.SnsUtil", " name " + str + " allTime " + (System.currentTimeMillis() - j));
        AppMethodBeat.m2505o(35830);
    }

    /* renamed from: B */
    public static boolean m46072B(Bitmap bitmap) {
        AppMethodBeat.m2504i(35831);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(35831);
            return false;
        }
        AppMethodBeat.m2505o(35831);
        return true;
    }

    /* renamed from: b */
    public static boolean m46101b(C45434n c45434n) {
        AppMethodBeat.m2504i(35832);
        if (c45434n == null || c45434n.isRecycled()) {
            AppMethodBeat.m2505o(35832);
            return false;
        }
        AppMethodBeat.m2505o(35832);
        return true;
    }

    /* renamed from: s */
    public static Bitmap m46128s(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(35833);
        if (bitmap == null) {
            AppMethodBeat.m2505o(35833);
            return null;
        }
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
        } else {
            int lastIndexOf = str.lastIndexOf(qGe);
            if (lastIndexOf > 0 && lastIndexOf + 1 < str.length()) {
                str2 = str.substring(lastIndexOf + 1);
                if (str2.startsWith(qGf) || str2.startsWith("sns_tmpb_")) {
                    str2 = str;
                } else if (str2.startsWith("snst_") || str2.startsWith("snsu_")) {
                    str2 = "";
                }
            }
            str2 = str;
        }
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(35833);
            return bitmap;
        }
        int orientationInDegree;
        try {
            C4990ab.m7417i("MicroMsg.SnsUtil", "[changes below by tomys]parsing jpg, path: %s, size: %s", str, Long.valueOf(C5730e.asZ(str)));
            Exif fromFile = Exif.fromFile(str);
            if (fromFile != null) {
                orientationInDegree = fromFile.getOrientationInDegree() % v2helper.VOIP_ENC_HEIGHT_LV1;
            } else {
                orientationInDegree = 0;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsUtil", e, "Failed parsing JPEG file: ".concat(String.valueOf(str2)), new Object[0]);
            orientationInDegree = 0;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(35833);
        }
        C4990ab.m7411d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", str2, Integer.valueOf(orientationInDegree));
        bitmap = C5056d.m7648b(bitmap, (float) orientationInDegree);
        AppMethodBeat.m2505o(35833);
        return bitmap;
    }

    /* renamed from: Xi */
    public static C45434n m46086Xi(String str) {
        C45434n c45434n = null;
        AppMethodBeat.m2504i(35834);
        try {
            C4990ab.m7416i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + C5730e.m8628ct(str));
            if (C5730e.m8628ct(str)) {
                c45434n = C29036i.m46088Xk(str);
                AppMethodBeat.m2505o(35834);
            } else {
                AppMethodBeat.m2505o(35834);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsUtil", e, "snsdecode error", new Object[0]);
            AppMethodBeat.m2505o(35834);
        }
        return c45434n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d A:{SYNTHETIC, Splitter:B:36:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d A:{SYNTHETIC, Splitter:B:36:0x007d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Xj */
    public static Bitmap m46087Xj(String str) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        AppMethodBeat.m2504i(35835);
        try {
            if (C5730e.m8628ct(str)) {
                Options options = new Options();
                C5056d.dnX();
                options.inSampleSize = 1;
                while (options.inSampleSize <= 10) {
                    try {
                        InputStream openRead = C5730e.openRead(str);
                        try {
                            long yz = C5046bo.m7588yz();
                            Bitmap decodeStream = MMBitmapFactory.decodeStream(openRead, null, options);
                            yz = C5046bo.m7525az(yz);
                            if (options.inSampleSize > 1) {
                                C4990ab.m7420w("MicroMsg.SnsUtil", "decode succ in " + options.inSampleSize);
                            }
                            if (decodeStream != null) {
                                decodeStream = C29036i.m46128s(str, decodeStream);
                                C39737c.m67955an(str, yz);
                            }
                            if (openRead != null) {
                                try {
                                    openRead.close();
                                } catch (IOException e) {
                                }
                            }
                            AppMethodBeat.m2505o(35835);
                            return decodeStream;
                        } catch (OutOfMemoryError e2) {
                            inputStream = openRead;
                            try {
                                options.inSampleSize++;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                }
                                AppMethodBeat.m2505o(35835);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream2 = openRead;
                            if (inputStream2 != null) {
                            }
                            AppMethodBeat.m2505o(35835);
                            throw th;
                        }
                    } catch (OutOfMemoryError e4) {
                        inputStream = null;
                    } catch (Throwable th32) {
                        th = th32;
                        inputStream2 = null;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e5) {
                            }
                        }
                        AppMethodBeat.m2505o(35835);
                        throw th;
                    }
                }
                AppMethodBeat.m2505o(35835);
                return null;
            }
            AppMethodBeat.m2505o(35835);
            return null;
        } catch (Exception e6) {
            C4990ab.printErrStackTrace("MicroMsg.SnsUtil", e6, "snsdecode error", new Object[0]);
            AppMethodBeat.m2505o(35835);
            return null;
        }
    }

    /* renamed from: Xk */
    public static C45434n m46088Xk(String str) {
        AppMethodBeat.m2504i(35836);
        try {
            if (C5730e.m8628ct(str)) {
                Options options = new Options();
                C5056d.dnX();
                options.inSampleSize = 1;
                while (options.inSampleSize <= 10) {
                    try {
                        long yz = C5046bo.m7588yz();
                        C45434n c = C21879a.m33432c(str, options);
                        yz = C5046bo.m7525az(yz);
                        if (c != null) {
                            C39737c.m67955an(str, yz);
                        }
                        AppMethodBeat.m2505o(35836);
                        return c;
                    } catch (OutOfMemoryError e) {
                        options.inSampleSize++;
                    }
                }
                AppMethodBeat.m2505o(35836);
                return null;
            }
            AppMethodBeat.m2505o(35836);
            return null;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.SnsUtil", e2, "snsdecode error", new Object[0]);
            AppMethodBeat.m2505o(35836);
            return null;
        }
    }

    /* renamed from: Xl */
    public static String m46089Xl(String str) {
        AppMethodBeat.m2504i(35837);
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.length() < 25) {
            stringBuffer.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(35837);
        return stringBuffer2;
    }

    /* renamed from: jV */
    public static String m46117jV(long j) {
        AppMethodBeat.m2504i(35838);
        String bigInteger = new BigInteger(Long.toBinaryString(j), 2).toString();
        AppMethodBeat.m2505o(35838);
        return bigInteger;
    }

    /* renamed from: jW */
    public static String m46118jW(long j) {
        AppMethodBeat.m2504i(35839);
        String str;
        if (j == 0) {
            str = "";
            AppMethodBeat.m2505o(35839);
            return str;
        }
        str = C29036i.m46089Xl(new BigInteger(Long.toBinaryString(j), 2).toString());
        AppMethodBeat.m2505o(35839);
        return str;
    }

    /* renamed from: Xm */
    private static String m46090Xm(String str) {
        AppMethodBeat.m2504i(35840);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(35840);
            return str2;
        }
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) == '0') {
            i++;
        }
        str2 = str.substring(i);
        AppMethodBeat.m2505o(35840);
        return str2;
    }

    /* renamed from: W */
    private static Rect m46076W(Bitmap bitmap) {
        AppMethodBeat.m2504i(35841);
        int width = bitmap.getWidth();
        Rect rect = new Rect(width / 4, 0, (int) (((double) (width * 3)) / 4.0d), bitmap.getHeight());
        AppMethodBeat.m2505o(35841);
        return rect;
    }

    /* renamed from: X */
    private static Rect m46077X(Bitmap bitmap) {
        AppMethodBeat.m2504i(35842);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        AppMethodBeat.m2505o(35842);
        return rect;
    }

    /* renamed from: p */
    public static Bitmap m46125p(List<C45434n> list, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(35843);
        for (C45434n b : list) {
            if (!C29036i.m46101b(b)) {
                AppMethodBeat.m2505o(35843);
                return null;
            }
        }
        if (i <= 0) {
            AppMethodBeat.m2505o(35843);
            return null;
        }
        Rect rect;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
        int size = list.size();
        LinkedList linkedList = new LinkedList();
        int i3 = i >> 1;
        int i4 = i3 + 2;
        i3 -= 2;
        Rect rect2;
        Rect rect3;
        if (size == 2) {
            rect = new Rect(0, 0, i3, i);
            rect2 = new Rect(i4, 0, i, i);
            linkedList.add(rect);
            linkedList.add(rect2);
        } else if (size == 3) {
            rect = new Rect(0, 0, i3, i);
            rect3 = new Rect(i4, 0, i, i3);
            rect2 = new Rect(i4, i4, i, i);
            linkedList.add(rect);
            linkedList.add(rect3);
            linkedList.add(rect2);
        } else if (size >= 4) {
            rect = new Rect(0, 0, i3, i3);
            rect3 = new Rect(0, i4, i3, i);
            Rect rect4 = new Rect(i4, 0, i, i3);
            rect2 = new Rect(i4, i4, i, i);
            linkedList.add(rect);
            linkedList.add(rect3);
            linkedList.add(rect4);
            linkedList.add(rect2);
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        i3 = 0;
        while (true) {
            i4 = i2;
            if (i4 >= list.size() || i3 >= 4) {
                canvas.save();
                canvas.restore();
                AppMethodBeat.m2505o(35843);
            } else {
                Rect X;
                Bitmap Xi = ((C45434n) list.get(i4)).mo73230Xi();
                rect = (Rect) linkedList.get(i4);
                switch (list.size()) {
                    case 1:
                        X = C29036i.m46077X(Xi);
                        break;
                    case 2:
                        X = C29036i.m46076W(Xi);
                        break;
                    case 3:
                        if (i4 != 0) {
                            X = C29036i.m46077X(Xi);
                            break;
                        }
                        X = C29036i.m46076W(Xi);
                        break;
                    default:
                        X = C29036i.m46077X(Xi);
                        break;
                }
                canvas.drawBitmap(Xi, X, rect, null);
                i2 = i4 + 1;
                i3++;
            }
        }
        canvas.save();
        canvas.restore();
        AppMethodBeat.m2505o(35843);
        return createBitmap;
    }

    /* renamed from: Xn */
    public static boolean m46091Xn(String str) {
        AppMethodBeat.m2504i(35844);
        boolean startsWith = str.startsWith(C6457e.eSl);
        AppMethodBeat.m2505o(35844);
        return startsWith;
    }

    /* renamed from: Xo */
    public static boolean m46092Xo(String str) {
        AppMethodBeat.m2504i(35845);
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i2 >= i * 2 || i >= i2 * 2) {
                AppMethodBeat.m2505o(35845);
                return true;
            }
            AppMethodBeat.m2505o(35845);
            return false;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            AppMethodBeat.m2505o(35845);
            return false;
        }
    }

    /* renamed from: Xp */
    public static boolean m46093Xp(String str) {
        AppMethodBeat.m2504i(35846);
        int i = qGi;
        try {
            Options amj = C5056d.amj(str);
            int i2 = amj.outWidth;
            int i3 = amj.outHeight;
            if (i3 <= 0 && i2 <= 0) {
                AppMethodBeat.m2505o(35846);
                return false;
            } else if (i3 >= i2 * 2 || i2 >= i3 * 2) {
                AppMethodBeat.m2505o(35846);
                return false;
            } else if (i3 * i2 > i) {
                AppMethodBeat.m2505o(35846);
                return true;
            } else {
                AppMethodBeat.m2505o(35846);
                return false;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            AppMethodBeat.m2505o(35846);
            return false;
        }
    }

    /* renamed from: CM */
    public static boolean m46073CM(int i) {
        AppMethodBeat.m2504i(35847);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putInt("sns_control_flag", i).commit();
        AppMethodBeat.m2505o(35847);
        return true;
    }

    public static int cmq() {
        AppMethodBeat.m2504i(35848);
        int i = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getInt("sns_control_flag", 0);
        AppMethodBeat.m2505o(35848);
        return i;
    }

    /* renamed from: CN */
    public static boolean m46074CN(int i) {
        AppMethodBeat.m2504i(35849);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putInt("sns_respone_count", i).commit();
        AppMethodBeat.m2505o(35849);
        return true;
    }

    public static int cmr() {
        AppMethodBeat.m2504i(35850);
        int i = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).getInt("sns_respone_count", 20);
        AppMethodBeat.m2505o(35850);
        return i;
    }

    /* renamed from: K */
    public static String m46075K(CharSequence charSequence) {
        int i = 0;
        AppMethodBeat.m2504i(35851);
        String str;
        if (charSequence == null) {
            str = "";
            AppMethodBeat.m2505o(35851);
            return str;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        C24944o[] c24944oArr = (C24944o[]) spannableString.getSpans(0, spannableString.length(), C24944o.class);
        C4990ab.m7411d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", Integer.valueOf(c24944oArr.length));
        while (i < c24944oArr.length) {
            spannableString.removeSpan(c24944oArr[i]);
            i++;
        }
        str = spannableString.toString();
        AppMethodBeat.m2505o(35851);
        return str;
    }

    /* renamed from: b */
    public static void m46100b(View view, Context context) {
        AppMethodBeat.m2504i(35852);
        if (view != null && C1338a.m2860dm(context) > 1.0f) {
            float dm = C1338a.m2860dm(context);
            LayoutParams layoutParams = view.getLayoutParams();
            int fromDPToPix = C1338a.fromDPToPix(context, 60);
            if (layoutParams.width >= 0 && layoutParams.height >= 0) {
                int i = (int) (((float) layoutParams.width) * dm);
                int i2 = (int) (dm * ((float) layoutParams.height));
                if (i > fromDPToPix) {
                    i = fromDPToPix;
                }
                layoutParams.width = i;
                if (i2 <= fromDPToPix) {
                    fromDPToPix = i2;
                }
                layoutParams.height = fromDPToPix;
                view.setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.m2505o(35852);
    }

    public static int cms() {
        AppMethodBeat.m2504i(35853);
        Context context = C4996ah.getContext();
        if (C5023at.is2G(context)) {
            AppMethodBeat.m2505o(35853);
            return 1;
        } else if (C5023at.is3G(context)) {
            AppMethodBeat.m2505o(35853);
            return 2;
        } else if (C5023at.is4G(context)) {
            AppMethodBeat.m2505o(35853);
            return 3;
        } else if (C5023at.isWifi(context)) {
            AppMethodBeat.m2505o(35853);
            return 4;
        } else {
            AppMethodBeat.m2505o(35853);
            return 0;
        }
    }

    /* renamed from: i */
    public static boolean m46114i(C46236n c46236n) {
        if (c46236n.field_type == 3 || c46236n.field_type == 4 || c46236n.field_type == 5 || c46236n.field_type == 6 || c46236n.field_type == 9 || c46236n.field_type == 10 || c46236n.field_type == 11 || c46236n.field_type == 12 || c46236n.field_type == 13 || c46236n.field_type == 14 || c46236n.field_type == 17 || c46236n.field_type == 22 || c46236n.field_type == 23) {
            return true;
        }
        return false;
    }

    public static long afB() {
        AppMethodBeat.m2504i(35854);
        long rawOffset = ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
        AppMethodBeat.m2505o(35854);
        return rawOffset;
    }

    /* renamed from: a */
    public static SpannableString m46097a(String str, Context context, TextView textView) {
        AppMethodBeat.m2504i(35855);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(35855);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
        stringBuilder.append(str);
        SpannableString spannableString = new SpannableString(C44089j.m79303e(context, stringBuilder.toString(), (float) ((int) textView.getTextSize())));
        AppMethodBeat.m2505o(35855);
        return spannableString;
    }

    /* renamed from: j */
    public static String m46115j(C46236n c46236n) {
        AppMethodBeat.m2504i(35856);
        String str;
        if (c46236n == null) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.m2505o(35856);
            return str;
        }
        str = C29036i.m46117jV(c46236n.field_snsId);
        AppMethodBeat.m2505o(35856);
        return str;
    }

    /* renamed from: Xq */
    public static long m46094Xq(String str) {
        long j = 0;
        AppMethodBeat.m2504i(35857);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(35857);
        } else {
            try {
                j = new BigInteger(str).longValue();
                C4990ab.m7417i("MicroMsg.SnsUtil", "seq %s to snsId %d ", str, Long.valueOf(j));
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(35857);
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Xr */
    public static int m46095Xr(String str) {
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(35858);
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(35858);
            } else {
                C4990ab.m7417i("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds, path: %s", str);
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    i = C5046bo.m7576mA((long) C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                    mediaMetadataRetriever.release();
                    AppMethodBeat.m2505o(35858);
                } catch (Throwable th2) {
                    try {
                        C4990ab.m7413e("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds error: %s", str);
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        AppMethodBeat.m2505o(35858);
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        AppMethodBeat.m2505o(35858);
                        throw th;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
            }
            AppMethodBeat.m2505o(35858);
            throw th;
        }
        return i;
    }

    /* renamed from: a */
    public static void m46098a(SnsAdClick snsAdClick) {
        AppMethodBeat.m2504i(35859);
        C9430of c9430of = new C9430of();
        c9430of.cKy.cKz = snsAdClick;
        C4879a.xxA.mo10055m(c9430of);
        AppMethodBeat.m2505o(35859);
    }

    /* renamed from: Xs */
    public static List<PointF> m46096Xs(String str) {
        AppMethodBeat.m2504i(35860);
        ArrayList arrayList = new ArrayList();
        if (!C5046bo.isNullOrNil(str)) {
            for (String split : str.split("[|]")) {
                String[] split2 = split.split("[_]");
                if (split2.length != 2) {
                    C4990ab.m7413e("MicroMsg.SnsUtil", "invalid gesture str! %s", str);
                    arrayList.clear();
                    break;
                }
                float f = C5046bo.getFloat(split2[0], -1.0f);
                float f2 = C5046bo.getFloat(split2[1], -1.0f);
                if (f == -1.0f || f2 == -1.0f) {
                    C4990ab.m7413e("MicroMsg.SnsUtil", "invalid gesture str! %s", str);
                    arrayList.clear();
                    break;
                }
                arrayList.add(new PointF(f, f2));
            }
        }
        AppMethodBeat.m2505o(35860);
        return arrayList;
    }

    /* renamed from: kI */
    public static void m46120kI(boolean z) {
        AppMethodBeat.m2504i(35861);
        C9453qw c9453qw = new C9453qw();
        c9453qw.cNc.enable = z;
        C4879a.xxA.mo10055m(c9453qw);
        AppMethodBeat.m2505o(35861);
    }

    /* renamed from: dd */
    public static String m46107dd(List<PointF> list) {
        AppMethodBeat.m2504i(35862);
        StringBuilder stringBuilder = new StringBuilder("");
        for (PointF pointF : list) {
            stringBuilder.append(pointF.x);
            stringBuilder.append("_");
            stringBuilder.append(pointF.y);
            stringBuilder.append("|");
        }
        if (list.size() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(35862);
        return stringBuilder2;
    }

    /* renamed from: e */
    public static void m46109e(long[] jArr) {
        AppMethodBeat.m2504i(35863);
        try {
            if (kgA == null) {
                kgA = (Vibrator) C4996ah.getContext().getSystemService("vibrator");
            }
            kgA.vibrate(jArr, -1);
            AppMethodBeat.m2505o(35863);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsUtil", e, "vibrate error!", new Object[0]);
            AppMethodBeat.m2505o(35863);
        }
    }
}
