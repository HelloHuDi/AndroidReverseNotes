package com.tencent.p177mm.svg.p610a;

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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVG;
import com.tencent.p177mm.svg.p611b.C5157b;
import com.tencent.p177mm.svg.p611b.C5159c;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.util.EncodingUtils;

/* renamed from: com.tencent.mm.svg.a.a */
public final class C5147a {
    private static String ycM = ".svg.code.drawable";
    protected static int ycN = 3;
    private static String ycO = "";
    private static Map<Integer, C5163c> ycP = new ConcurrentHashMap();
    private static Map<Integer, Picture> ycQ = new ConcurrentHashMap();
    private static Map<String, Picture> ycR = new ConcurrentHashMap();
    private static Float ycS;
    private TypedValue ycK = new TypedValue();
    private byte[] ycL = new byte[0];

    public C5147a() {
        AppMethodBeat.m2504i(70074);
        AppMethodBeat.m2505o(70074);
    }

    static {
        AppMethodBeat.m2504i(70088);
        AppMethodBeat.m2505o(70088);
    }

    /* renamed from: cY */
    public static void m7836cY(String str) {
        ycO = str;
    }

    /* renamed from: f */
    public static Drawable m7837f(Resources resources, int i) {
        AppMethodBeat.m2504i(70075);
        Drawable a = C5147a.m7828a(resources, i, 0.0f);
        AppMethodBeat.m2505o(70075);
        return a;
    }

    private static String doR() {
        AppMethodBeat.m2504i(70076);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String str;
        if (stackTrace == null || stackTrace.length < 4) {
            str = "";
            AppMethodBeat.m2505o(70076);
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
        AppMethodBeat.m2505o(70076);
        return str;
    }

    /* renamed from: a */
    private static Drawable m7828a(Resources resources, int i, float f) {
        AppMethodBeat.m2504i(70077);
        Drawable c;
        if (i == 0) {
            C5159c.m7868e("MicroMsg.SVGCompat", "getSVGDrawable a invalid resource!!! %s", Integer.valueOf(i));
            C5159c.m7868e("MicroMsg.SVGCompat", "Why no log??", new Object[0]);
            C5159c.m7868e("MicroMsg.SVGCompat", "The stack : %s", C5147a.doR());
            C7314c c7314c = new C7314c(new Picture(), i);
            AppMethodBeat.m2505o(70077);
            return c7314c;
        } else if (C5157b.dvK()) {
            c = C5147a.m7834c(resources, i, f);
            AppMethodBeat.m2505o(70077);
            return c;
        } else {
            c = C5147a.m7829a(resources, i, ycO + ycM, f);
            AppMethodBeat.m2505o(70077);
            return c;
        }
    }

    /* renamed from: b */
    public static Bitmap m7831b(Resources resources, int i, float f) {
        AppMethodBeat.m2504i(70078);
        Drawable a = C5147a.m7828a(resources, i, f);
        if (a == null) {
            AppMethodBeat.m2505o(70078);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(a.getIntrinsicWidth(), a.getIntrinsicHeight(), Config.ARGB_8888);
        a.draw(new Canvas(createBitmap));
        AppMethodBeat.m2505o(70078);
        return createBitmap;
    }

    /* renamed from: g */
    public final boolean mo10586g(Resources resources, int i) {
        AppMethodBeat.m2504i(70079);
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
                        AppMethodBeat.m2505o(70079);
                    }
                }
                if (charSequence.endsWith(".svg")) {
                    return true;
                }
            }
            AppMethodBeat.m2505o(70079);
            return false;
        } catch (NotFoundException e) {
            C5159c.printErrStackTrace("MicroMsg.SVGCompat", e, "resource not found", new Object[0]);
            AppMethodBeat.m2505o(70079);
            return false;
        }
    }

    public static Map<Integer, C5163c> dvD() {
        return ycP;
    }

    /* renamed from: b */
    protected static boolean m7832b(View view, Paint paint) {
        AppMethodBeat.m2504i(70080);
        if (VERSION.SDK_INT > 10) {
            boolean c = C5147a.m7835c(view, paint);
            AppMethodBeat.m2505o(70080);
            return c;
        }
        AppMethodBeat.m2505o(70080);
        return false;
    }

    @TargetApi(11)
    /* renamed from: c */
    private static boolean m7835c(View view, Paint paint) {
        AppMethodBeat.m2504i(70081);
        if (view != null) {
            try {
                if (view.getLayerType() != 1) {
                    view.setLayerType(1, paint);
                }
            } catch (NullPointerException e) {
                C4990ab.printErrStackTrace("MicroMsg.SVGCompat", e, "", new Object[0]);
            }
            if (view.willNotCacheDrawing()) {
                view.setWillNotCacheDrawing(false);
                if (view.getWindowToken() != null) {
                    view.buildLayer();
                }
            }
            AppMethodBeat.m2505o(70081);
            return true;
        }
        AppMethodBeat.m2505o(70081);
        return false;
    }

    /* renamed from: w */
    protected static View m7838w(Drawable drawable) {
        AppMethodBeat.m2504i(70082);
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
                    AppMethodBeat.m2505o(70082);
                    return view;
                }
            }
            break;
        }
        AppMethodBeat.m2505o(70082);
        return null;
    }

    /* renamed from: c */
    private static Drawable m7834c(Resources resources, int i, float f) {
        AppMethodBeat.m2504i(70083);
        C5159c.m7867d("MicroMsg.SVGCompat", "Using wechat svg library.", new Object[0]);
        InputStream openRawResource = resources.openRawResource(i);
        try {
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.SVGCompat", e, "", new Object[0]);
                }
            }
            long parse = WeChatSVG.parse(EncodingUtils.getString(bArr, "UTF-8").toString());
            if (parse == 0) {
                C5159c.m7868e("MicroMsg.SVGCompat", "Parse SVG failed.", new Object[0]);
                AppMethodBeat.m2505o(70083);
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
            Drawable c7314c = new C7314c(picture, i);
            if (renderViewPort < 0) {
                C5159c.m7868e("MicroMsg.SVGCompat", "Render SVG failed. Reason : %s", Integer.valueOf(renderViewPort));
                AppMethodBeat.m2505o(70083);
                return null;
            }
            AppMethodBeat.m2505o(70083);
            return c7314c;
        } catch (IOException e2) {
            C4990ab.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
            C5159c.m7868e("MicroMsg.SVGCompat", "Get SVGPictureDrawable failed. Reason : IOException", new Object[0]);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.SVGCompat", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(70083);
            return null;
        } catch (Throwable th) {
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e3) {
                    C4990ab.printErrStackTrace("MicroMsg.SVGCompat", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(70083);
        }
    }

    /* renamed from: bm */
    private static float m7833bm(float f) {
        AppMethodBeat.m2504i(70084);
        if (ycS == null) {
            ycS = Float.valueOf(f / ((float) ycN));
        }
        float floatValue = ycS.floatValue();
        AppMethodBeat.m2505o(70084);
        return floatValue;
    }

    /* renamed from: a */
    private static Drawable m7829a(Resources resources, int i, String str, float f) {
        float f2;
        Drawable c7314c;
        AppMethodBeat.m2504i(70085);
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
                picture = C5147a.m7827a(f3, C5147a.m7830a(resources, i, str), f2);
                ycR.put(str2, picture);
            }
            c7314c = new C7314c(picture, i);
        } else {
            picture = (Picture) ycQ.get(Integer.valueOf(i));
            if (picture == null) {
                picture = C5147a.m7827a(f3, C5147a.m7830a(resources, i, str), f2);
                ycQ.put(Integer.valueOf(i), picture);
            }
            c7314c = new C7314c(picture, i);
        }
        AppMethodBeat.m2505o(70085);
        return c7314c;
    }

    /* renamed from: a */
    private static C5163c m7830a(Resources resources, int i, String str) {
        AppMethodBeat.m2504i(70086);
        Object obj = "";
        try {
            C5163c c5163c;
            if (ycP.containsKey(Integer.valueOf(i))) {
                c5163c = (C5163c) ycP.get(Integer.valueOf(i));
            } else {
                String resourceName = resources.getResourceName(i);
                if (resourceName == null) {
                    C5159c.m7868e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : resource not found", new Object[0]);
                    AppMethodBeat.m2505o(70086);
                    return null;
                }
                String str2;
                int indexOf = resourceName.indexOf("/");
                if (indexOf > 0) {
                    str2 = str + "." + resourceName.substring(indexOf + 1);
                } else {
                    str2 = str + "." + resourceName;
                }
                c5163c = (C5163c) Class.forName(str2).newInstance();
                ycP.put(Integer.valueOf(i), c5163c);
            }
            AppMethodBeat.m2505o(70086);
            return c5163c;
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.SVGCompat", e, "", new Object[0]);
            C5159c.m7868e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : ClassNotFoundException %s", obj);
            AppMethodBeat.m2505o(70086);
            return null;
        } catch (InstantiationException e2) {
            C5159c.m7868e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : InstantiationException %s", obj);
            C4990ab.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
            AppMethodBeat.m2505o(70086);
            return null;
        } catch (IllegalAccessException e3) {
            C5159c.m7868e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : IllegalAccessException %s", obj);
            C4990ab.printErrStackTrace("MicroMsg.SVGCompat", e3, "", new Object[0]);
            AppMethodBeat.m2505o(70086);
            return null;
        }
    }

    /* renamed from: a */
    private static Picture m7827a(float f, C5163c c5163c, float f2) {
        AppMethodBeat.m2504i(70087);
        Picture picture = new Picture();
        if (c5163c == null) {
            C5159c.m7868e("MicroMsg.SVGCompat", "fromCodeToPicture code is null!", new Object[0]);
            AppMethodBeat.m2505o(70087);
        } else {
            float bm = C5147a.m7833bm(f) * f2;
            Canvas beginRecording = picture.beginRecording((int) (((float) C5163c.m7875a(c5163c)) * bm), (int) (((float) C5163c.m7879b(c5163c)) * bm));
            beginRecording.save();
            beginRecording.scale(bm, bm);
            C5163c.m7877a(c5163c, beginRecording, Looper.myLooper());
            beginRecording.restore();
            picture.endRecording();
            AppMethodBeat.m2505o(70087);
        }
        return picture;
    }
}
