package com.bumptech.glide.c.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

final class e {
    private static final a azE = new a();
    private final a azF;
    private final d azG;
    private final List<f> azH;
    private final b azx;
    private final ContentResolver azy;

    static {
        AppMethodBeat.i(91744);
        AppMethodBeat.o(91744);
    }

    e(List<f> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, azE, dVar, bVar, contentResolver);
    }

    private e(List<f> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.azF = aVar;
        this.azG = dVar;
        this.azx = bVar;
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
    public final int i(Uri uri) {
        InputStream openInputStream;
        Throwable th;
        InputStream inputStream;
        AppMethodBeat.i(91741);
        InputStream inputStream2 = null;
        try {
            openInputStream = this.azy.openInputStream(uri);
            try {
                int b = g.b(this.azH, openInputStream, this.azx);
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.o(91741);
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
                    AppMethodBeat.o(91741);
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
                    AppMethodBeat.o(91741);
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
            AppMethodBeat.o(91741);
            return -1;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
            }
            AppMethodBeat.o(91741);
            throw th;
        }
        openInputStream = inputStream2;
        if (Log.isLoggable("ThumbStreamOpener", 3)) {
        }
        if (openInputStream != null) {
        }
        AppMethodBeat.o(91741);
        return -1;
    }

    public final InputStream j(Uri uri) {
        InputStream inputStream = null;
        AppMethodBeat.i(91742);
        String k = k(uri);
        if (TextUtils.isEmpty(k)) {
            AppMethodBeat.o(91742);
        } else {
            Object obj;
            File file = new File(k);
            if (!file.exists() || 0 >= file.length()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                AppMethodBeat.o(91742);
            } else {
                Uri fromFile = Uri.fromFile(file);
                try {
                    inputStream = this.azy.openInputStream(fromFile);
                    AppMethodBeat.o(91742);
                } catch (NullPointerException e) {
                    FileNotFoundException fileNotFoundException = (FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e);
                    AppMethodBeat.o(91742);
                    throw fileNotFoundException;
                }
            }
        }
        return inputStream;
    }

    private String k(Uri uri) {
        AppMethodBeat.i(91743);
        Cursor h = this.azG.h(uri);
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
                AppMethodBeat.o(91743);
            }
        }
        if (h != null) {
            h.close();
        }
        AppMethodBeat.o(91743);
        return null;
    }
}
