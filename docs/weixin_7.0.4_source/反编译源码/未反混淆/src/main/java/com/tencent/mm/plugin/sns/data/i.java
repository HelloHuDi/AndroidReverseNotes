package com.tencent.mm.plugin.sns.data;

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
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.o;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public final class i {
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

    public static String bc(int i, String str) {
        AppMethodBeat.i(35804);
        String str2 = i + "-" + str;
        AppMethodBeat.o(35804);
        return str2;
    }

    public static String dc(List<bau> list) {
        AppMethodBeat.i(35805);
        String str;
        if (list == null || list.size() == 0) {
            str = "";
            AppMethodBeat.o(35805);
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
            str = str + bau.Id;
            i = i2 + 1;
            if (i >= 4) {
                break;
            }
        }
        AppMethodBeat.o(35805);
        return str;
    }

    private static String c(bau bau) {
        AppMethodBeat.i(35806);
        String str;
        if (bo.isNullOrNil(bau.wEV)) {
            str = "";
            try {
                str = g.x(bau.toByteArray());
            } catch (Exception e) {
            }
            AppMethodBeat.o(35806);
            return str;
        }
        str = bau.wEV;
        AppMethodBeat.o(35806);
        return str;
    }

    public static String Xa(String str) {
        AppMethodBeat.i(35807);
        String str2 = "snst_" + Xm(str);
        AppMethodBeat.o(35807);
        return str2;
    }

    public static String Xb(String str) {
        AppMethodBeat.i(35808);
        String str2 = "snsu_" + Xm(str);
        AppMethodBeat.o(35808);
        return str2;
    }

    public static String Xc(String str) {
        AppMethodBeat.i(35809);
        String str2 = "snsb_" + Xm(str);
        AppMethodBeat.o(35809);
        return str2;
    }

    public static String d(bau bau) {
        AppMethodBeat.i(35810);
        String str = "snsb_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35810);
            return str;
        }
        AppMethodBeat.o(35810);
        return str;
    }

    public static String e(bau bau) {
        AppMethodBeat.i(35811);
        String str = "snst_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35811);
            return str;
        }
        AppMethodBeat.o(35811);
        return str;
    }

    public static String Xd(String str) {
        AppMethodBeat.i(35812);
        String str2 = "snsu_" + Xm(str);
        AppMethodBeat.o(35812);
        return str2;
    }

    public static String f(bau bau) {
        AppMethodBeat.i(35813);
        String str = "snsu_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35813);
            return str;
        }
        AppMethodBeat.o(35813);
        return str;
    }

    public static String g(bau bau) {
        AppMethodBeat.i(35814);
        String str = "snsblurt_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35814);
            return str;
        }
        AppMethodBeat.o(35814);
        return str;
    }

    public static String h(bau bau) {
        AppMethodBeat.i(35815);
        String str = "snsblurs_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35815);
            return str;
        }
        AppMethodBeat.o(35815);
        return str;
    }

    public static String i(bau bau) {
        AppMethodBeat.i(35816);
        String str = "snstblur_src_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35816);
            return str;
        }
        AppMethodBeat.o(35816);
        return str;
    }

    public static String j(bau bau) {
        AppMethodBeat.i(35817);
        String str = "sight_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35817);
            return str;
        }
        AppMethodBeat.o(35817);
        return str;
    }

    public static String k(bau bau) {
        AppMethodBeat.i(35818);
        String str = "sightad_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str, bau.wEU);
            AppMethodBeat.o(35818);
            return str;
        }
        AppMethodBeat.o(35818);
        return str;
    }

    public static String l(bau bau) {
        AppMethodBeat.i(35819);
        String str = "snsb_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35819);
            return str;
        }
        AppMethodBeat.o(35819);
        return str;
    }

    public static String m(bau bau) {
        AppMethodBeat.i(35820);
        String str = "sns_tmpb_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35820);
            return str;
        }
        AppMethodBeat.o(35820);
        return str;
    }

    public static String Xe(String str) {
        AppMethodBeat.i(35821);
        String str2 = "sns_tmpb_" + Xm(str);
        AppMethodBeat.o(35821);
        return str2;
    }

    public static String n(bau bau) {
        AppMethodBeat.i(35822);
        String str = "sns_tmpt_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35822);
            return str;
        }
        AppMethodBeat.o(35822);
        return str;
    }

    public static String Xf(String str) {
        AppMethodBeat.i(35823);
        String str2 = "sns_tmpt_" + Xm(str);
        AppMethodBeat.o(35823);
        return str2;
    }

    public static String o(bau bau) {
        AppMethodBeat.i(35824);
        String str = "sns_tmpu_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35824);
            return str;
        }
        AppMethodBeat.o(35824);
        return str;
    }

    public static String p(bau bau) {
        AppMethodBeat.i(35825);
        String str = "sns_tmps_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35825);
            return str;
        }
        AppMethodBeat.o(35825);
        return str;
    }

    public static String Xg(String str) {
        AppMethodBeat.i(35826);
        String str2 = "sns_tmps_" + Xm(str);
        AppMethodBeat.o(35826);
        return str2;
    }

    public static String q(bau bau) {
        AppMethodBeat.i(35827);
        String str = "sns_tmpsad_" + Xm(bau.Id);
        if (bau.wET == 1) {
            str = f.s(str + c(bau), bau.wEU);
            AppMethodBeat.o(35827);
            return str;
        }
        AppMethodBeat.o(35827);
        return str;
    }

    public static String bd(int i, String str) {
        AppMethodBeat.i(35828);
        String str2 = i + "-" + str;
        AppMethodBeat.o(35828);
        return str2;
    }

    public static String Xh(String str) {
        AppMethodBeat.i(35829);
        String concat = "9_".concat(String.valueOf(str));
        AppMethodBeat.o(35829);
        return concat;
    }

    public static void am(String str, long j) {
        AppMethodBeat.i(35830);
        ab.d("MicroMsg.SnsUtil", " name " + str + " allTime " + (System.currentTimeMillis() - j));
        AppMethodBeat.o(35830);
    }

    public static boolean B(Bitmap bitmap) {
        AppMethodBeat.i(35831);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(35831);
            return false;
        }
        AppMethodBeat.o(35831);
        return true;
    }

    public static boolean b(n nVar) {
        AppMethodBeat.i(35832);
        if (nVar == null || nVar.isRecycled()) {
            AppMethodBeat.o(35832);
            return false;
        }
        AppMethodBeat.o(35832);
        return true;
    }

    public static Bitmap s(String str, Bitmap bitmap) {
        AppMethodBeat.i(35833);
        if (bitmap == null) {
            AppMethodBeat.o(35833);
            return null;
        }
        String str2;
        if (bo.isNullOrNil(str)) {
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
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(35833);
            return bitmap;
        }
        int orientationInDegree;
        try {
            ab.i("MicroMsg.SnsUtil", "[changes below by tomys]parsing jpg, path: %s, size: %s", str, Long.valueOf(e.asZ(str)));
            Exif fromFile = Exif.fromFile(str);
            if (fromFile != null) {
                orientationInDegree = fromFile.getOrientationInDegree() % v2helper.VOIP_ENC_HEIGHT_LV1;
            } else {
                orientationInDegree = 0;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsUtil", e, "Failed parsing JPEG file: ".concat(String.valueOf(str2)), new Object[0]);
            orientationInDegree = 0;
        } catch (Throwable th) {
            AppMethodBeat.o(35833);
        }
        ab.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", str2, Integer.valueOf(orientationInDegree));
        bitmap = d.b(bitmap, (float) orientationInDegree);
        AppMethodBeat.o(35833);
        return bitmap;
    }

    public static n Xi(String str) {
        n nVar = null;
        AppMethodBeat.i(35834);
        try {
            ab.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + e.ct(str));
            if (e.ct(str)) {
                nVar = Xk(str);
                AppMethodBeat.o(35834);
            } else {
                AppMethodBeat.o(35834);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsUtil", e, "snsdecode error", new Object[0]);
            AppMethodBeat.o(35834);
        }
        return nVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d A:{SYNTHETIC, Splitter:B:36:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d A:{SYNTHETIC, Splitter:B:36:0x007d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap Xj(String str) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        AppMethodBeat.i(35835);
        try {
            if (e.ct(str)) {
                Options options = new Options();
                d.dnX();
                options.inSampleSize = 1;
                while (options.inSampleSize <= 10) {
                    try {
                        InputStream openRead = e.openRead(str);
                        try {
                            long yz = bo.yz();
                            Bitmap decodeStream = MMBitmapFactory.decodeStream(openRead, null, options);
                            yz = bo.az(yz);
                            if (options.inSampleSize > 1) {
                                ab.w("MicroMsg.SnsUtil", "decode succ in " + options.inSampleSize);
                            }
                            if (decodeStream != null) {
                                decodeStream = s(str, decodeStream);
                                c.an(str, yz);
                            }
                            if (openRead != null) {
                                try {
                                    openRead.close();
                                } catch (IOException e) {
                                }
                            }
                            AppMethodBeat.o(35835);
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
                                AppMethodBeat.o(35835);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream2 = openRead;
                            if (inputStream2 != null) {
                            }
                            AppMethodBeat.o(35835);
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
                        AppMethodBeat.o(35835);
                        throw th;
                    }
                }
                AppMethodBeat.o(35835);
                return null;
            }
            AppMethodBeat.o(35835);
            return null;
        } catch (Exception e6) {
            ab.printErrStackTrace("MicroMsg.SnsUtil", e6, "snsdecode error", new Object[0]);
            AppMethodBeat.o(35835);
            return null;
        }
    }

    public static n Xk(String str) {
        AppMethodBeat.i(35836);
        try {
            if (e.ct(str)) {
                Options options = new Options();
                d.dnX();
                options.inSampleSize = 1;
                while (options.inSampleSize <= 10) {
                    try {
                        long yz = bo.yz();
                        n c = a.c(str, options);
                        yz = bo.az(yz);
                        if (c != null) {
                            c.an(str, yz);
                        }
                        AppMethodBeat.o(35836);
                        return c;
                    } catch (OutOfMemoryError e) {
                        options.inSampleSize++;
                    }
                }
                AppMethodBeat.o(35836);
                return null;
            }
            AppMethodBeat.o(35836);
            return null;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SnsUtil", e2, "snsdecode error", new Object[0]);
            AppMethodBeat.o(35836);
            return null;
        }
    }

    public static String Xl(String str) {
        AppMethodBeat.i(35837);
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.length() < 25) {
            stringBuffer.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(35837);
        return stringBuffer2;
    }

    public static String jV(long j) {
        AppMethodBeat.i(35838);
        String bigInteger = new BigInteger(Long.toBinaryString(j), 2).toString();
        AppMethodBeat.o(35838);
        return bigInteger;
    }

    public static String jW(long j) {
        AppMethodBeat.i(35839);
        String str;
        if (j == 0) {
            str = "";
            AppMethodBeat.o(35839);
            return str;
        }
        str = Xl(new BigInteger(Long.toBinaryString(j), 2).toString());
        AppMethodBeat.o(35839);
        return str;
    }

    private static String Xm(String str) {
        AppMethodBeat.i(35840);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(35840);
            return str2;
        }
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) == '0') {
            i++;
        }
        str2 = str.substring(i);
        AppMethodBeat.o(35840);
        return str2;
    }

    private static Rect W(Bitmap bitmap) {
        AppMethodBeat.i(35841);
        int width = bitmap.getWidth();
        Rect rect = new Rect(width / 4, 0, (int) (((double) (width * 3)) / 4.0d), bitmap.getHeight());
        AppMethodBeat.o(35841);
        return rect;
    }

    private static Rect X(Bitmap bitmap) {
        AppMethodBeat.i(35842);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        AppMethodBeat.o(35842);
        return rect;
    }

    public static Bitmap p(List<n> list, int i) {
        int i2 = 0;
        AppMethodBeat.i(35843);
        for (n b : list) {
            if (!b(b)) {
                AppMethodBeat.o(35843);
                return null;
            }
        }
        if (i <= 0) {
            AppMethodBeat.o(35843);
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
                AppMethodBeat.o(35843);
            } else {
                Rect X;
                Bitmap Xi = ((n) list.get(i4)).Xi();
                rect = (Rect) linkedList.get(i4);
                switch (list.size()) {
                    case 1:
                        X = X(Xi);
                        break;
                    case 2:
                        X = W(Xi);
                        break;
                    case 3:
                        if (i4 != 0) {
                            X = X(Xi);
                            break;
                        }
                        X = W(Xi);
                        break;
                    default:
                        X = X(Xi);
                        break;
                }
                canvas.drawBitmap(Xi, X, rect, null);
                i2 = i4 + 1;
                i3++;
            }
        }
        canvas.save();
        canvas.restore();
        AppMethodBeat.o(35843);
        return createBitmap;
    }

    public static boolean Xn(String str) {
        AppMethodBeat.i(35844);
        boolean startsWith = str.startsWith(com.tencent.mm.compatible.util.e.eSl);
        AppMethodBeat.o(35844);
        return startsWith;
    }

    public static boolean Xo(String str) {
        AppMethodBeat.i(35845);
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i2 >= i * 2 || i >= i2 * 2) {
                AppMethodBeat.o(35845);
                return true;
            }
            AppMethodBeat.o(35845);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            AppMethodBeat.o(35845);
            return false;
        }
    }

    public static boolean Xp(String str) {
        AppMethodBeat.i(35846);
        int i = qGi;
        try {
            Options amj = d.amj(str);
            int i2 = amj.outWidth;
            int i3 = amj.outHeight;
            if (i3 <= 0 && i2 <= 0) {
                AppMethodBeat.o(35846);
                return false;
            } else if (i3 >= i2 * 2 || i2 >= i3 * 2) {
                AppMethodBeat.o(35846);
                return false;
            } else if (i3 * i2 > i) {
                AppMethodBeat.o(35846);
                return true;
            } else {
                AppMethodBeat.o(35846);
                return false;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            AppMethodBeat.o(35846);
            return false;
        }
    }

    public static boolean CM(int i) {
        AppMethodBeat.i(35847);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putInt("sns_control_flag", i).commit();
        AppMethodBeat.o(35847);
        return true;
    }

    public static int cmq() {
        AppMethodBeat.i(35848);
        int i = ah.getContext().getSharedPreferences(ah.doA(), 0).getInt("sns_control_flag", 0);
        AppMethodBeat.o(35848);
        return i;
    }

    public static boolean CN(int i) {
        AppMethodBeat.i(35849);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putInt("sns_respone_count", i).commit();
        AppMethodBeat.o(35849);
        return true;
    }

    public static int cmr() {
        AppMethodBeat.i(35850);
        int i = ah.getContext().getSharedPreferences(ah.doA(), 0).getInt("sns_respone_count", 20);
        AppMethodBeat.o(35850);
        return i;
    }

    public static String K(CharSequence charSequence) {
        int i = 0;
        AppMethodBeat.i(35851);
        String str;
        if (charSequence == null) {
            str = "";
            AppMethodBeat.o(35851);
            return str;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        o[] oVarArr = (o[]) spannableString.getSpans(0, spannableString.length(), o.class);
        ab.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", Integer.valueOf(oVarArr.length));
        while (i < oVarArr.length) {
            spannableString.removeSpan(oVarArr[i]);
            i++;
        }
        str = spannableString.toString();
        AppMethodBeat.o(35851);
        return str;
    }

    public static void b(View view, Context context) {
        AppMethodBeat.i(35852);
        if (view != null && com.tencent.mm.bz.a.dm(context) > 1.0f) {
            float dm = com.tencent.mm.bz.a.dm(context);
            LayoutParams layoutParams = view.getLayoutParams();
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 60);
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
        AppMethodBeat.o(35852);
    }

    public static int cms() {
        AppMethodBeat.i(35853);
        Context context = ah.getContext();
        if (at.is2G(context)) {
            AppMethodBeat.o(35853);
            return 1;
        } else if (at.is3G(context)) {
            AppMethodBeat.o(35853);
            return 2;
        } else if (at.is4G(context)) {
            AppMethodBeat.o(35853);
            return 3;
        } else if (at.isWifi(context)) {
            AppMethodBeat.o(35853);
            return 4;
        } else {
            AppMethodBeat.o(35853);
            return 0;
        }
    }

    public static boolean i(com.tencent.mm.plugin.sns.storage.n nVar) {
        if (nVar.field_type == 3 || nVar.field_type == 4 || nVar.field_type == 5 || nVar.field_type == 6 || nVar.field_type == 9 || nVar.field_type == 10 || nVar.field_type == 11 || nVar.field_type == 12 || nVar.field_type == 13 || nVar.field_type == 14 || nVar.field_type == 17 || nVar.field_type == 22 || nVar.field_type == 23) {
            return true;
        }
        return false;
    }

    public static long afB() {
        AppMethodBeat.i(35854);
        long rawOffset = ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
        AppMethodBeat.o(35854);
        return rawOffset;
    }

    public static SpannableString a(String str, Context context, TextView textView) {
        AppMethodBeat.i(35855);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(35855);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
        stringBuilder.append(str);
        SpannableString spannableString = new SpannableString(j.e(context, stringBuilder.toString(), (float) ((int) textView.getTextSize())));
        AppMethodBeat.o(35855);
        return spannableString;
    }

    public static String j(com.tencent.mm.plugin.sns.storage.n nVar) {
        AppMethodBeat.i(35856);
        String str;
        if (nVar == null) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            AppMethodBeat.o(35856);
            return str;
        }
        str = jV(nVar.field_snsId);
        AppMethodBeat.o(35856);
        return str;
    }

    public static long Xq(String str) {
        long j = 0;
        AppMethodBeat.i(35857);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(35857);
        } else {
            try {
                j = new BigInteger(str).longValue();
                ab.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", str, Long.valueOf(j));
            } catch (Exception e) {
            }
            AppMethodBeat.o(35857);
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int Xr(String str) {
        Throwable th;
        int i = 0;
        AppMethodBeat.i(35858);
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(35858);
            } else {
                ab.i("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds, path: %s", str);
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    i = bo.mA((long) bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                    mediaMetadataRetriever.release();
                    AppMethodBeat.o(35858);
                } catch (Throwable th2) {
                    try {
                        ab.e("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds error: %s", str);
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        AppMethodBeat.o(35858);
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        AppMethodBeat.o(35858);
                        throw th;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
            }
            AppMethodBeat.o(35858);
            throw th;
        }
        return i;
    }

    public static void a(SnsAdClick snsAdClick) {
        AppMethodBeat.i(35859);
        of ofVar = new of();
        ofVar.cKy.cKz = snsAdClick;
        com.tencent.mm.sdk.b.a.xxA.m(ofVar);
        AppMethodBeat.o(35859);
    }

    public static List<PointF> Xs(String str) {
        AppMethodBeat.i(35860);
        ArrayList arrayList = new ArrayList();
        if (!bo.isNullOrNil(str)) {
            for (String split : str.split("[|]")) {
                String[] split2 = split.split("[_]");
                if (split2.length != 2) {
                    ab.e("MicroMsg.SnsUtil", "invalid gesture str! %s", str);
                    arrayList.clear();
                    break;
                }
                float f = bo.getFloat(split2[0], -1.0f);
                float f2 = bo.getFloat(split2[1], -1.0f);
                if (f == -1.0f || f2 == -1.0f) {
                    ab.e("MicroMsg.SnsUtil", "invalid gesture str! %s", str);
                    arrayList.clear();
                    break;
                }
                arrayList.add(new PointF(f, f2));
            }
        }
        AppMethodBeat.o(35860);
        return arrayList;
    }

    public static void kI(boolean z) {
        AppMethodBeat.i(35861);
        qw qwVar = new qw();
        qwVar.cNc.enable = z;
        com.tencent.mm.sdk.b.a.xxA.m(qwVar);
        AppMethodBeat.o(35861);
    }

    public static String dd(List<PointF> list) {
        AppMethodBeat.i(35862);
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
        AppMethodBeat.o(35862);
        return stringBuilder2;
    }

    public static void e(long[] jArr) {
        AppMethodBeat.i(35863);
        try {
            if (kgA == null) {
                kgA = (Vibrator) ah.getContext().getSystemService("vibrator");
            }
            kgA.vibrate(jArr, -1);
            AppMethodBeat.o(35863);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsUtil", e, "vibrate error!", new Object[0]);
            AppMethodBeat.o(35863);
        }
    }
}
