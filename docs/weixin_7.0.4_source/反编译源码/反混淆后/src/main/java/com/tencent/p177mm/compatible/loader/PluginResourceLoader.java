package com.tencent.p177mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.mm.compatible.loader.PluginResourceLoader */
public class PluginResourceLoader extends Resources {
    public Resources euo;
    private Method eup;
    private Method euq;
    private HashMap<String, ZipFile> eur;
    private final C45292b<WeakReference<ConstantState>> eus;

    /* renamed from: b */
    private XmlResourceParser m28615b(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(93028);
        try {
            XmlResourceParser xmlResourceParser = (XmlResourceParser) this.euq.invoke(this.euo, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
            AppMethodBeat.m2505o(93028);
            return xmlResourceParser;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.PluginResourceLoader", e, "", new Object[0]);
            AppMethodBeat.m2505o(93028);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Drawable loadDrawable(TypedValue typedValue, int i) {
        AppMethodBeat.m2504i(93029);
        Drawable a = m28613a(typedValue, i);
        AppMethodBeat.m2505o(93029);
        return a;
    }

    /* Access modifiers changed, original: 0000 */
    public Drawable loadDrawable(TypedValue typedValue, int i, boolean z) {
        AppMethodBeat.m2504i(93030);
        Drawable a = m28613a(typedValue, i);
        AppMethodBeat.m2505o(93030);
        return a;
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        InputStream openRawResource;
        InputStream inputStream = null;
        AppMethodBeat.m2504i(93031);
        getValue(i, typedValue, true);
        try {
            openRawResource = super.openRawResource(i, typedValue);
        } catch (Exception e) {
            openRawResource = null;
        }
        if (openRawResource == null) {
            for (Entry value : this.eur.entrySet()) {
                inputStream = PluginResourceLoader.m28616b((ZipFile) value.getValue(), typedValue);
                if (inputStream != null) {
                    break;
                }
            }
        }
        inputStream = openRawResource;
        AppMethodBeat.m2505o(93031);
        return inputStream;
    }

    /* renamed from: a */
    private Drawable m28613a(TypedValue typedValue, int i) {
        XmlResourceParser b;
        AppMethodBeat.m2504i(93032);
        Drawable drawable;
        try {
            drawable = (Drawable) this.eup.invoke(this.euo, new Object[]{typedValue, Integer.valueOf(i)});
            AppMethodBeat.m2505o(93032);
            return drawable;
        } catch (Exception e) {
            try {
                if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
                    b = m28615b(typedValue.string.toString(), i, typedValue.assetCookie, "drawable");
                    drawable = Drawable.createFromXml(this, b);
                    b.close();
                    AppMethodBeat.m2505o(93032);
                    return drawable;
                }
            } catch (Exception e2) {
            }
            for (Entry value : this.eur.entrySet()) {
                drawable = m28614a((ZipFile) value.getValue(), typedValue);
                if (drawable != null) {
                    AppMethodBeat.m2505o(93032);
                    return drawable;
                }
            }
            C4990ab.m7410d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
            AppMethodBeat.m2505o(93032);
            return null;
        } catch (StackOverflowError e3) {
            C4990ab.m7412e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
            b = m28615b(typedValue.string.toString(), i, typedValue.assetCookie, "drawable");
            drawable = Drawable.createFromXml(this, b);
            b.close();
            AppMethodBeat.m2505o(93032);
            return drawable;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private Drawable m28614a(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(93033);
        if (typedValue.string == null) {
            AppMethodBeat.m2505o(93033);
            return null;
        }
        InputStream inputStream2;
        Drawable newDrawable;
        long j = ((long) typedValue.data) | (((long) typedValue.assetCookie) << 32);
        C45292b c45292b = this.eus;
        int b = C45292b.m83516b(c45292b.f17876Lk, c45292b.mSize, j);
        if (b < 0 || c45292b.f17877Ll[b] == C45292b.f17874Li) {
            inputStream2 = null;
        } else {
            inputStream2 = c45292b.f17877Ll[b];
        }
        WeakReference weakReference = (WeakReference) inputStream2;
        if (weakReference != null) {
            ConstantState constantState = (ConstantState) weakReference.get();
            if (constantState != null) {
                newDrawable = constantState.newDrawable(this);
                if (newDrawable == null) {
                    C4990ab.m7418v("MicroMsg.PluginResourceLoader", "get form cache");
                    AppMethodBeat.m2505o(93033);
                    return newDrawable;
                }
                ZipEntry entry;
                Drawable drawable;
                String charSequence = typedValue.string.toString();
                try {
                    C4990ab.m7419v("MicroMsg.PluginResourceLoader", "try load drawable from zip, entry=%s, file=%s", charSequence, zipFile.getName());
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
                    AppMethodBeat.m2505o(93033);
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
                        AppMethodBeat.m2505o(93033);
                        return drawable;
                    }
                }
                drawable = newDrawable;
                if (drawable != null) {
                }
                AppMethodBeat.m2505o(93033);
                return drawable;
            }
            c45292b = this.eus;
            b = C45292b.m83516b(c45292b.f17876Lk, c45292b.mSize, j);
            if (b >= 0 && c45292b.f17877Ll[b] != C45292b.f17874Li) {
                c45292b.f17877Ll[b] = C45292b.f17874Li;
                c45292b.f17875Lj = true;
            }
        }
        newDrawable = null;
        if (newDrawable == null) {
        }
    }

    /* renamed from: b */
    private static InputStream m28616b(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(93034);
        if (typedValue.string == null) {
            AppMethodBeat.m2505o(93034);
        } else {
            try {
                C4990ab.m7411d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", typedValue.string.toString(), zipFile.getName());
                inputStream = zipFile.getInputStream(zipFile.getEntry(r1));
                AppMethodBeat.m2505o(93034);
            } catch (Exception e) {
                AppMethodBeat.m2505o(93034);
            }
        }
        return inputStream;
    }
}
