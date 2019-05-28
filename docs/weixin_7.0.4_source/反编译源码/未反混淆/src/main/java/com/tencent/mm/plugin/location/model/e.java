package com.tencent.mm.plugin.location.model;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class e {
    public static PackageInfo aK(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(113304);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 1);
            AppMethodBeat.o(113304);
        } catch (NameNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.MapUtil", e, "", new Object[0]);
            AppMethodBeat.o(113304);
        } catch (ActivityNotFoundException e2) {
            ab.printErrStackTrace("MicroMsg.MapUtil", e2, "", new Object[0]);
            AppMethodBeat.o(113304);
        }
        return packageInfo;
    }

    public static String a(LocationInfo locationInfo) {
        AppMethodBeat.i(113305);
        if (locationInfo.cIK == null) {
            locationInfo.cIK = "";
        }
        String str = "<msg><location x=\"" + locationInfo.nJu + "\" y=\"" + locationInfo.nJv + "\" scale=\"" + locationInfo.nJw + "\" label=\"" + bo.ani(locationInfo.nJx) + "\" poiname=\"" + bo.ani(locationInfo.cIK) + "\" maptype=\"0\" /></msg>";
        AppMethodBeat.o(113305);
        return str;
    }

    public static String a(String str, String str2, View view) {
        OutputStream fileOutputStream;
        AppMethodBeat.i(113306);
        ab.d("MicroMsg.MapUtil", "w h " + view.getWidth() + " " + ((view.getHeight() / 2) + 20));
        String str3 = str + str2 + ".png";
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), (int) (((double) view.getHeight()) * 0.7d), Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        ab.d("MicroMsg.MapUtil", "saveMyBitmap ".concat(String.valueOf(str2)));
        File file = new File(str + str2 + ".png");
        file.createNewFile();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.MapUtil", e, "", new Object[0]);
            fileOutputStream = null;
        }
        try {
            ab.d("MicroMsg.MapUtil", "h " + createBitmap.getHeight() + " w:" + createBitmap.getWidth() + " ");
            createBitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.MapUtil", e2, "", new Object[0]);
                }
            }
            ab.i("MicroMsg.MapUtil", "bitmap recycle %s", createBitmap.toString());
            createBitmap.recycle();
            AppMethodBeat.o(113306);
            return str3;
        } catch (IOException e3) {
            ab.printErrStackTrace("MicroMsg.MapUtil", e3, "", new Object[0]);
            AppMethodBeat.o(113306);
            return null;
        }
    }

    public static boolean j(double d, double d2) {
        AppMethodBeat.i(113307);
        if (Math.abs(d2) > 180.0d || Math.abs(d) > 90.0d) {
            AppMethodBeat.o(113307);
            return false;
        }
        AppMethodBeat.o(113307);
        return true;
    }

    public static double[] c(double[] dArr) {
        Object obj;
        AppMethodBeat.i(113308);
        double d = dArr[0];
        double d2 = dArr[1];
        if (d < 72.004d || d > 137.8347d || d2 < 0.8293d || d2 > 55.8271d) {
            obj = 1;
        } else {
            obj = null;
        }
        double[] dArr2;
        if (obj != null) {
            dArr2 = new double[]{d, d2};
            AppMethodBeat.o(113308);
            return dArr2;
        }
        double d3 = d - 105.0d;
        double d4 = d2 - 35.0d;
        double sqrt = (((((((-100.0d + (2.0d * d3)) + (3.0d * d4)) + ((0.2d * d4) * d4)) + ((0.1d * d3) * d4)) + (0.2d * Math.sqrt(Math.abs(d3)))) + ((((20.0d * Math.sin((6.0d * d3) * 3.141592653589793d)) + (20.0d * Math.sin((2.0d * d3) * 3.141592653589793d))) * 2.0d) / 3.0d)) + ((((20.0d * Math.sin(3.141592653589793d * d4)) + (40.0d * Math.sin((d4 / 3.0d) * 3.141592653589793d))) * 2.0d) / 3.0d)) + ((((160.0d * Math.sin((d4 / 12.0d) * 3.141592653589793d)) + (320.0d * Math.sin((3.141592653589793d * d4) / 30.0d))) * 2.0d) / 3.0d);
        d3 = ((((Math.sin((d3 / 30.0d) * 3.141592653589793d) * 300.0d) + (150.0d * Math.sin((d3 / 12.0d) * 3.141592653589793d))) * 2.0d) / 3.0d) + (((((d4 * (0.1d * d3)) + (((300.0d + d3) + (2.0d * d4)) + ((0.1d * d3) * d3))) + (0.1d * Math.sqrt(Math.abs(d3)))) + ((((20.0d * Math.sin((6.0d * d3) * 3.141592653589793d)) + (20.0d * Math.sin((2.0d * d3) * 3.141592653589793d))) * 2.0d) / 3.0d)) + ((((20.0d * Math.sin(3.141592653589793d * d3)) + (40.0d * Math.sin((d3 / 3.0d) * 3.141592653589793d))) * 2.0d) / 3.0d));
        d4 = (d2 / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d4);
        sin = 1.0d - (sin * (0.006693421622965943d * sin));
        double sqrt2 = Math.sqrt(sin);
        sqrt = (sqrt * 180.0d) / ((6335552.717000426d / (sin * sqrt2)) * 3.141592653589793d);
        d3 = (d3 * 180.0d) / ((Math.cos(d4) * (6378245.0d / sqrt2)) * 3.141592653589793d);
        d4 = d2 + sqrt;
        sqrt = d + d3;
        dArr2 = new double[]{(d * 2.0d) - sqrt, (2.0d * d2) - d4};
        AppMethodBeat.o(113308);
        return dArr2;
    }
}
