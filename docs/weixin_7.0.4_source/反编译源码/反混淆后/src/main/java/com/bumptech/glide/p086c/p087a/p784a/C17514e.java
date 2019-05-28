package com.bumptech.glide.p086c.p087a.p784a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.p086c.C0776f;
import com.bumptech.glide.p086c.C0778g;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.bumptech.glide.c.a.a.e */
final class C17514e {
    private static final C41543a azE = new C41543a();
    private final C41543a azF;
    private final C25402d azG;
    private final List<C0776f> azH;
    private final C8515b azx;
    private final ContentResolver azy;

    static {
        AppMethodBeat.m2504i(91744);
        AppMethodBeat.m2505o(91744);
    }

    C17514e(List<C0776f> list, C25402d c25402d, C8515b c8515b, ContentResolver contentResolver) {
        this(list, azE, c25402d, c8515b, contentResolver);
    }

    private C17514e(List<C0776f> list, C41543a c41543a, C25402d c25402d, C8515b c8515b, ContentResolver contentResolver) {
        this.azF = c41543a;
        this.azG = c25402d;
        this.azx = c8515b;
        this.azy = contentResolver;
        this.azH = list;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A:{Catch:{ all -> 0x0051 }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037 A:{SYNTHETIC, Splitter:B:16:0x0037} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044 A:{SYNTHETIC, Splitter:B:22:0x0044} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A:{Catch:{ all -> 0x0051 }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037 A:{SYNTHETIC, Splitter:B:16:0x0037} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public final int mo31942i(Uri uri) {
        InputStream openInputStream;
        Throwable th;
        InputStream inputStream;
        AppMethodBeat.m2504i(91741);
        InputStream inputStream2 = null;
        try {
            openInputStream = this.azy.openInputStream(uri);
            try {
                int b = C0778g.m1773b(this.azH, openInputStream, this.azx);
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(91741);
                return b;
            } catch (IOException e2) {
                inputStream2 = openInputStream;
            } catch (NullPointerException e3) {
                try {
                    if (Log.isLoggable("ThumbStreamOpener", 3)) {
                        new StringBuilder("Failed to open uri: ").append(uri);
                    }
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.m2505o(91741);
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = openInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.m2505o(91741);
                    throw th;
                }
            }
        } catch (IOException e6) {
        } catch (NullPointerException e7) {
            openInputStream = null;
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
            }
            if (openInputStream != null) {
            }
            AppMethodBeat.m2505o(91741);
            return -1;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
            }
            AppMethodBeat.m2505o(91741);
            throw th;
        }
        openInputStream = inputStream2;
        if (Log.isLoggable("ThumbStreamOpener", 3)) {
        }
        if (openInputStream != null) {
        }
        AppMethodBeat.m2505o(91741);
        return -1;
    }

    /* renamed from: j */
    public final InputStream mo31943j(Uri uri) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(91742);
        String k = m27338k(uri);
        if (TextUtils.isEmpty(k)) {
            AppMethodBeat.m2505o(91742);
        } else {
            Object obj;
            File file = new File(k);
            if (!file.exists() || 0 >= file.length()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                AppMethodBeat.m2505o(91742);
            } else {
                Uri fromFile = Uri.fromFile(file);
                try {
                    inputStream = this.azy.openInputStream(fromFile);
                    AppMethodBeat.m2505o(91742);
                } catch (NullPointerException e) {
                    FileNotFoundException fileNotFoundException = (FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e);
                    AppMethodBeat.m2505o(91742);
                    throw fileNotFoundException;
                }
            }
        }
        return inputStream;
    }

    /* renamed from: k */
    private String m27338k(Uri uri) {
        AppMethodBeat.m2504i(91743);
        Cursor h = this.azG.mo18599h(uri);
        if (h != null) {
            try {
                if (h.moveToFirst()) {
                    String string = h.getString(0);
                    return string;
                }
            } finally {
                if (h != null) {
                    h.close();
                }
                AppMethodBeat.m2505o(91743);
            }
        }
        if (h != null) {
            h.close();
        }
        AppMethodBeat.m2505o(91743);
        return null;
    }
}
