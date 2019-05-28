package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.svg.WeChatSVG;
import com.tencent.mm.svg.b.b;
import com.tencent.mm.svg.c;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.util.EncodingUtils;

public final class a {
    private static String ycM = ".svg.code.drawable";
    protected static int ycN = 3;
    private static String ycO = "";
    private static Map<Integer, c> ycP = new ConcurrentHashMap();
    private static Map<Integer, Picture> ycQ = new ConcurrentHashMap();
    private static Map<String, Picture> ycR = new ConcurrentHashMap();
    private static Float ycS;
    private TypedValue ycK = new TypedValue();
    private byte[] ycL = new byte[0];

    public a() {
        AppMethodBeat.i(70074);
        AppMethodBeat.o(70074);
    }

    static {
        AppMethodBeat.i(70088);
        AppMethodBeat.o(70088);
    }

    public static void cY(String str) {
        ycO = str;
    }

    public static Drawable f(Resources resources, int i) {
        AppMethodBeat.i(70075);
        Drawable a = a(resources, i, 0.0f);
        AppMethodBeat.o(70075);
        return a;
    }

    private static String doR() {
        AppMethodBeat.i(70076);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String str;
        if (stackTrace == null || stackTrace.length < 4) {
            str = "";
            AppMethodBeat.o(70076);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 3;
        while (i < stackTrace.length) {
            if (stackTrace[i].getClassName().contains("com.tencent.mm") && !stackTrace[i].getClassName().contains("sdk.platformtools.Log")) {
                stringBuilder.append("[");
                stringBuilder.append(stackTrace[i].getClassName().substring(15));
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(stackTrace[i].getMethodName());
                stringBuilder.append("(" + stackTrace[i].getLineNumber() + ")]");
            }
            i++;
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(70076);
        return str;
    }

    private static Drawable a(Resources resources, int i, float f) {
        AppMethodBeat.i(70077);
        Drawable c;
        if (i == 0) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "getSVGDrawable a invalid resource!!! %s", Integer.valueOf(i));
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Why no log??", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "The stack : %s", doR());
            c cVar = new c(new Picture(), i);
            AppMethodBeat.o(70077);
            return cVar;
        } else if (b.dvK()) {
            c = c(resources, i, f);
            AppMethodBeat.o(70077);
            return c;
        } else {
            c = a(resources, i, ycO + ycM, f);
            AppMethodBeat.o(70077);
            return c;
        }
    }

    public static Bitmap b(Resources resources, int i, float f) {
        AppMethodBeat.i(70078);
        Drawable a = a(resources, i, f);
        if (a == null) {
            AppMethodBeat.o(70078);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(a.getIntrinsicWidth(), a.getIntrinsicHeight(), Config.ARGB_8888);
        a.draw(new Canvas(createBitmap));
        AppMethodBeat.o(70078);
        return createBitmap;
    }

    public final boolean g(Resources resources, int i) {
        AppMethodBeat.i(70079);
        try {
            if (resources.getResourceTypeName(i).equals("raw")) {
                String charSequence;
                synchronized (this.ycL) {
                    try {
                        TypedValue typedValue = this.ycK;
                        if (typedValue == null) {
                            typedValue = new TypedValue();
                            this.ycK = typedValue;
                        }
                        resources.getValue(i, typedValue, true);
                        charSequence = typedValue.string.toString();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(70079);
                    }
                }
                if (charSequence.endsWith(".svg")) {
                    return true;
                }
            }
            AppMethodBeat.o(70079);
            return false;
        } catch (NotFoundException e) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGCompat", e, "resource not found", new Object[0]);
            AppMethodBeat.o(70079);
            return false;
        }
    }

    public static Map<Integer, c> dvD() {
        return ycP;
    }

    protected static boolean b(View view, Paint paint) {
        AppMethodBeat.i(70080);
        if (VERSION.SDK_INT > 10) {
            boolean c = c(view, paint);
            AppMethodBeat.o(70080);
            return c;
        }
        AppMethodBeat.o(70080);
        return false;
    }

    @TargetApi(11)
    private static boolean c(View view, Paint paint) {
        AppMethodBeat.i(70081);
        if (view != null) {
            try {
                if (view.getLayerType() != 1) {
                    view.setLayerType(1, paint);
                }
            } catch (NullPointerException e) {
                ab.printErrStackTrace("MicroMsg.SVGCompat", e, "", new Object[0]);
            }
            if (view.willNotCacheDrawing()) {
                view.setWillNotCacheDrawing(false);
                if (view.getWindowToken() != null) {
                    view.buildLayer();
                }
            }
            AppMethodBeat.o(70081);
            return true;
        }
        AppMethodBeat.o(70081);
        return false;
    }

    protected static View w(Drawable drawable) {
        AppMethodBeat.i(70082);
        while (true) {
            Callback callback = drawable.getCallback();
            if (callback != null) {
                if (!(callback instanceof View)) {
                    if (!(callback instanceof Drawable)) {
                        break;
                    }
                    drawable = (Drawable) callback;
                } else {
                    View view = (View) callback;
                    AppMethodBeat.o(70082);
                    return view;
                }
            }
            break;
        }
        AppMethodBeat.o(70082);
        return null;
    }

    private static Drawable c(Resources resources, int i, float f) {
        AppMethodBeat.i(70083);
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGCompat", "Using wechat svg library.", new Object[0]);
        InputStream openRawResource = resources.openRawResource(i);
        try {
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.SVGCompat", e, "", new Object[0]);
                }
            }
            long parse = WeChatSVG.parse(EncodingUtils.getString(bArr, "UTF-8").toString());
            if (parse == 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Parse SVG failed.", new Object[0]);
                AppMethodBeat.o(70083);
                return null;
            }
            float[] viewPort = WeChatSVG.getViewPort(parse);
            float f2 = resources.getDisplayMetrics().density;
            float f3 = (f > 0.0f ? f : 1.0f) * ((viewPort[0] / ((float) ycN)) * f2);
            float f4 = (viewPort[1] / ((float) ycN)) * f2;
            if (f <= 0.0f) {
                f = 1.0f;
            }
            float f5 = f4 * f;
            Picture picture = new Picture();
            int renderViewPort = WeChatSVG.renderViewPort(parse, picture.beginRecording((int) f3, (int) f5), (float) ((int) f3), (float) ((int) f5));
            picture.endRecording();
            WeChatSVG.release(parse);
            Drawable cVar = new c(picture, i);
            if (renderViewPort < 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Render SVG failed. Reason : %s", Integer.valueOf(renderViewPort));
                AppMethodBeat.o(70083);
                return null;
            }
            AppMethodBeat.o(70083);
            return cVar;
        } catch (IOException e2) {
            ab.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGPictureDrawable failed. Reason : IOException", new Object[0]);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e22) {
                    ab.printErrStackTrace("MicroMsg.SVGCompat", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.o(70083);
            return null;
        } catch (Throwable th) {
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e3) {
                    ab.printErrStackTrace("MicroMsg.SVGCompat", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.o(70083);
        }
    }

    private static float bm(float f) {
        AppMethodBeat.i(70084);
        if (ycS == null) {
            ycS = Float.valueOf(f / ((float) ycN));
        }
        float floatValue = ycS.floatValue();
        AppMethodBeat.o(70084);
        return floatValue;
    }

    private static Drawable a(Resources resources, int i, String str, float f) {
        float f2;
        Drawable cVar;
        AppMethodBeat.i(70085);
        float f3 = resources.getDisplayMetrics().density;
        if (f > 0.0f) {
            f2 = f;
        } else {
            f2 = 1.0f;
        }
        Picture picture;
        if (f > 0.0f) {
            String str2 = i + "_scale_" + f;
            picture = (Picture) ycR.get(str2);
            if (picture == null) {
                picture = a(f3, a(resources, i, str), f2);
                ycR.put(str2, picture);
            }
            cVar = new c(picture, i);
        } else {
            picture = (Picture) ycQ.get(Integer.valueOf(i));
            if (picture == null) {
                picture = a(f3, a(resources, i, str), f2);
                ycQ.put(Integer.valueOf(i), picture);
            }
            cVar = new c(picture, i);
        }
        AppMethodBeat.o(70085);
        return cVar;
    }

    private static c a(Resources resources, int i, String str) {
        AppMethodBeat.i(70086);
        Object obj = "";
        try {
            c cVar;
            if (ycP.containsKey(Integer.valueOf(i))) {
                cVar = (c) ycP.get(Integer.valueOf(i));
            } else {
                String resourceName = resources.getResourceName(i);
                if (resourceName == null) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : resource not found", new Object[0]);
                    AppMethodBeat.o(70086);
                    return null;
                }
                String str2;
                int indexOf = resourceName.indexOf("/");
                if (indexOf > 0) {
                    str2 = str + "." + resourceName.substring(indexOf + 1);
                } else {
                    str2 = str + "." + resourceName;
                }
                cVar = (c) Class.forName(str2).newInstance();
                ycP.put(Integer.valueOf(i), cVar);
            }
            AppMethodBeat.o(70086);
            return cVar;
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.SVGCompat", e, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : ClassNotFoundException %s", obj);
            AppMethodBeat.o(70086);
            return null;
        } catch (InstantiationException e2) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : InstantiationException %s", obj);
            ab.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
            AppMethodBeat.o(70086);
            return null;
        } catch (IllegalAccessException e3) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : IllegalAccessException %s", obj);
            ab.printErrStackTrace("MicroMsg.SVGCompat", e3, "", new Object[0]);
            AppMethodBeat.o(70086);
            return null;
        }
    }

    private static Picture a(float f, c cVar, float f2) {
        AppMethodBeat.i(70087);
        Picture picture = new Picture();
        if (cVar == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "fromCodeToPicture code is null!", new Object[0]);
            AppMethodBeat.o(70087);
        } else {
            float bm = bm(f) * f2;
            Canvas beginRecording = picture.beginRecording((int) (((float) c.a(cVar)) * bm), (int) (((float) c.b(cVar)) * bm));
            beginRecording.save();
            beginRecording.scale(bm, bm);
            c.a(cVar, beginRecording, Looper.myLooper());
            beginRecording.restore();
            picture.endRecording();
            AppMethodBeat.o(70087);
        }
        return picture;
    }
}
