package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Coffee {
    private static final String TAG = Coffee.class.getSimpleName();

    public static native String getDefaultSign();

    public static native boolean isSign(String str);

    private static native byte[] nDrink(byte[] bArr, int i, String str);

    private static native byte[] nDrinkios(byte[] bArr, int i, String str);

    static {
        AppMethodBeat.m2504i(50259);
        try {
            System.loadLibrary("pitu_tools");
            AppMethodBeat.m2505o(50259);
        } catch (UnsatisfiedLinkError e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(50259);
        } catch (RuntimeException e2) {
            LogUtils.m50206e(e2);
            AppMethodBeat.m2505o(50259);
        } catch (Exception e3) {
            LogUtils.m50206e(e3);
            AppMethodBeat.m2505o(50259);
        }
    }

    public static InputStream drinkACupOfCoffee(InputStream inputStream, boolean z) {
        AppMethodBeat.m2504i(50256);
        byte[] toByteArray = IOUtils.toByteArray(inputStream);
        if (z) {
            toByteArray = drink_ios(toByteArray, getDefaultSign());
        } else {
            toByteArray = drink(toByteArray, getDefaultSign());
        }
        InputStream toInputStream = IOUtils.toInputStream(toByteArray);
        AppMethodBeat.m2505o(50256);
        return toInputStream;
    }

    public static byte[] drink(byte[] bArr, String str) {
        AppMethodBeat.m2504i(50257);
        LogUtils.m50212v("Coffee", "drink(), sign = %s", str);
        byte[] nDrink = nDrink(bArr, bArr.length, str);
        if (nDrink[0] == (byte) 120 && nDrink[1] == (byte) -100) {
            Inflater inflater = new Inflater();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inflater.setInput(nDrink, 0, nDrink.length);
                nDrink = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(nDrink, 0, inflater.inflate(nDrink));
                }
                inflater.end();
            } catch (DataFormatException e) {
                inflater.end();
            } catch (Throwable th) {
                inflater.end();
                AppMethodBeat.m2505o(50257);
            }
            nDrink = byteArrayOutputStream.toByteArray();
            AppMethodBeat.m2505o(50257);
            return nDrink;
        }
        AppMethodBeat.m2505o(50257);
        return nDrink;
    }

    public static byte[] drink_ios(byte[] bArr, String str) {
        AppMethodBeat.m2504i(50258);
        LogUtils.m50212v("Coffee", "drink(), sign = %s", str);
        byte[] nDrinkios = nDrinkios(bArr, bArr.length, str);
        if (nDrinkios[0] == (byte) 120 && nDrinkios[1] == (byte) -100) {
            Inflater inflater = new Inflater();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inflater.setInput(nDrinkios, 0, nDrinkios.length);
                nDrinkios = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(nDrinkios, 0, inflater.inflate(nDrinkios));
                }
                inflater.end();
            } catch (DataFormatException e) {
                inflater.end();
            } catch (Throwable th) {
                inflater.end();
                AppMethodBeat.m2505o(50258);
            }
            nDrinkios = byteArrayOutputStream.toByteArray();
            AppMethodBeat.m2505o(50258);
            return nDrinkios;
        }
        AppMethodBeat.m2505o(50258);
        return nDrinkios;
    }
}
