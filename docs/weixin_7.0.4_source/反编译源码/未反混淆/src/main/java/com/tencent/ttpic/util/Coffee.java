package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
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
        AppMethodBeat.i(50259);
        try {
            System.loadLibrary("pitu_tools");
            AppMethodBeat.o(50259);
        } catch (UnsatisfiedLinkError e) {
            LogUtils.e(e);
            AppMethodBeat.o(50259);
        } catch (RuntimeException e2) {
            LogUtils.e(e2);
            AppMethodBeat.o(50259);
        } catch (Exception e3) {
            LogUtils.e(e3);
            AppMethodBeat.o(50259);
        }
    }

    public static InputStream drinkACupOfCoffee(InputStream inputStream, boolean z) {
        AppMethodBeat.i(50256);
        byte[] toByteArray = IOUtils.toByteArray(inputStream);
        if (z) {
            toByteArray = drink_ios(toByteArray, getDefaultSign());
        } else {
            toByteArray = drink(toByteArray, getDefaultSign());
        }
        InputStream toInputStream = IOUtils.toInputStream(toByteArray);
        AppMethodBeat.o(50256);
        return toInputStream;
    }

    public static byte[] drink(byte[] bArr, String str) {
        AppMethodBeat.i(50257);
        LogUtils.v("Coffee", "drink(), sign = %s", str);
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
                AppMethodBeat.o(50257);
            }
            nDrink = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(50257);
            return nDrink;
        }
        AppMethodBeat.o(50257);
        return nDrink;
    }

    public static byte[] drink_ios(byte[] bArr, String str) {
        AppMethodBeat.i(50258);
        LogUtils.v("Coffee", "drink(), sign = %s", str);
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
                AppMethodBeat.o(50258);
            }
            nDrinkios = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(50258);
            return nDrinkios;
        }
        AppMethodBeat.o(50258);
        return nDrinkios;
    }
}
