package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class PluginResourceLoader extends Resources {
    public Resources euo;
    private Method eup;
    private Method euq;
    private HashMap<String, ZipFile> eur;
    private final b<WeakReference<ConstantState>> eus;

    private XmlResourceParser b(String str, int i, int i2, String str2) {
        AppMethodBeat.i(93028);
        try {
            XmlResourceParser xmlResourceParser = (XmlResourceParser) this.euq.invoke(this.euo, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
            AppMethodBeat.o(93028);
            return xmlResourceParser;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.PluginResourceLoader", e, "", new Object[0]);
            AppMethodBeat.o(93028);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Drawable loadDrawable(TypedValue typedValue, int i) {
        AppMethodBeat.i(93029);
        Drawable a = a(typedValue, i);
        AppMethodBeat.o(93029);
        return a;
    }

    /* Access modifiers changed, original: 0000 */
    public Drawable loadDrawable(TypedValue typedValue, int i, boolean z) {
        AppMethodBeat.i(93030);
        Drawable a = a(typedValue, i);
        AppMethodBeat.o(93030);
        return a;
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        InputStream openRawResource;
        InputStream inputStream = null;
        AppMethodBeat.i(93031);
        getValue(i, typedValue, true);
        try {
            openRawResource = super.openRawResource(i, typedValue);
        } catch (Exception e) {
            openRawResource = null;
        }
        if (openRawResource == null) {
            for (Entry value : this.eur.entrySet()) {
                inputStream = b((ZipFile) value.getValue(), typedValue);
                if (inputStream != null) {
                    break;
                }
            }
        }
        inputStream = openRawResource;
        AppMethodBeat.o(93031);
        return inputStream;
    }

    private Drawable a(TypedValue typedValue, int i) {
        XmlResourceParser b;
        AppMethodBeat.i(93032);
        Drawable drawable;
        try {
            drawable = (Drawable) this.eup.invoke(this.euo, new Object[]{typedValue, Integer.valueOf(i)});
            AppMethodBeat.o(93032);
            return drawable;
        } catch (Exception e) {
            try {
                if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
                    b = b(typedValue.string.toString(), i, typedValue.assetCookie, "drawable");
                    drawable = Drawable.createFromXml(this, b);
                    b.close();
                    AppMethodBeat.o(93032);
                    return drawable;
                }
            } catch (Exception e2) {
            }
            for (Entry value : this.eur.entrySet()) {
                drawable = a((ZipFile) value.getValue(), typedValue);
                if (drawable != null) {
                    AppMethodBeat.o(93032);
                    return drawable;
                }
            }
            ab.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
            AppMethodBeat.o(93032);
            return null;
        } catch (StackOverflowError e3) {
            ab.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
            b = b(typedValue.string.toString(), i, typedValue.assetCookie, "drawable");
            drawable = Drawable.createFromXml(this, b);
            b.close();
            AppMethodBeat.o(93032);
            return drawable;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Drawable a(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        AppMethodBeat.i(93033);
        if (typedValue.string == null) {
            AppMethodBeat.o(93033);
            return null;
        }
        InputStream inputStream2;
        Drawable newDrawable;
        long j = ((long) typedValue.data) | (((long) typedValue.assetCookie) << 32);
        b bVar = this.eus;
        int b = b.b(bVar.Lk, bVar.mSize, j);
        if (b < 0 || bVar.Ll[b] == b.Li) {
            inputStream2 = null;
        } else {
            inputStream2 = bVar.Ll[b];
        }
        WeakReference weakReference = (WeakReference) inputStream2;
        if (weakReference != null) {
            ConstantState constantState = (ConstantState) weakReference.get();
            if (constantState != null) {
                newDrawable = constantState.newDrawable(this);
                if (newDrawable == null) {
                    ab.v("MicroMsg.PluginResourceLoader", "get form cache");
                    AppMethodBeat.o(93033);
                    return newDrawable;
                }
                ZipEntry entry;
                Drawable drawable;
                String charSequence = typedValue.string.toString();
                try {
                    ab.v("MicroMsg.PluginResourceLoader", "try load drawable from zip, entry=%s, file=%s", charSequence, zipFile.getName());
                    entry = zipFile.getEntry(charSequence);
                    inputStream = zipFile.getInputStream(entry);
                    newDrawable = Drawable.createFromResourceStream(this, typedValue, inputStream, charSequence);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            drawable = newDrawable;
                        } catch (Exception e3) {
                            drawable = newDrawable;
                        }
                    }
                } catch (Exception e4) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                } catch (Exception e6) {
                    drawable = newDrawable;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    AppMethodBeat.o(93033);
                }
                if (newDrawable == null) {
                    inputStream = zipFile.getInputStream(entry);
                    newDrawable = Drawable.createFromStream(inputStream, charSequence);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            drawable = newDrawable;
                        } catch (Exception e8) {
                            drawable = newDrawable;
                        }
                        if (drawable != null) {
                            this.eus.put(j, new WeakReference(drawable.getConstantState()));
                        }
                        AppMethodBeat.o(93033);
                        return drawable;
                    }
                }
                drawable = newDrawable;
                if (drawable != null) {
                }
                AppMethodBeat.o(93033);
                return drawable;
            }
            bVar = this.eus;
            b = b.b(bVar.Lk, bVar.mSize, j);
            if (b >= 0 && bVar.Ll[b] != b.Li) {
                bVar.Ll[b] = b.Li;
                bVar.Lj = true;
            }
        }
        newDrawable = null;
        if (newDrawable == null) {
        }
    }

    private static InputStream b(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        AppMethodBeat.i(93034);
        if (typedValue.string == null) {
            AppMethodBeat.o(93034);
        } else {
            try {
                ab.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", typedValue.string.toString(), zipFile.getName());
                inputStream = zipFile.getInputStream(zipFile.getEntry(r1));
                AppMethodBeat.o(93034);
            } catch (Exception e) {
                AppMethodBeat.o(93034);
            }
        }
        return inputStream;
    }
}
