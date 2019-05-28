package com.tencent.mm.pluginsdk.i;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.Closeable;
import java.net.URLDecoder;

public final class e {
    public static final String a(ContentResolver contentResolver, Uri uri) {
        Throwable e;
        AppMethodBeat.i(27476);
        if (uri == null) {
            AppMethodBeat.o(27476);
            return null;
        }
        b bVar;
        String type = contentResolver.getType(uri);
        String ajn = ajn(type);
        String b = b(contentResolver, uri);
        if (bo.isNullOrNil(b)) {
            b = "share_file" + ajn(type);
        }
        b bVar2 = new b(com.tencent.mm.compatible.util.e.euQ, b);
        if (bVar2.exists()) {
            aw.ZK();
            bVar = new b(l.X(c.Ye(), b, ajn));
        } else {
            bVar = bVar2;
        }
        Closeable q;
        Closeable openInputStream;
        try {
            q = com.tencent.mm.vfs.e.q(bVar);
            try {
                openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    bo.b(openInputStream);
                    bo.b(q);
                    AppMethodBeat.o(27476);
                    return null;
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read > 0) {
                            q.write(bArr, 0, read);
                        } else {
                            b = j.w(bVar.dMD());
                            bo.b(openInputStream);
                            bo.b(q);
                            AppMethodBeat.o(27476);
                            return b;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                        bo.b(openInputStream);
                        bo.b(q);
                        AppMethodBeat.o(27476);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        bo.b(openInputStream);
                        bo.b(q);
                        AppMethodBeat.o(27476);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openInputStream = null;
            } catch (Throwable th2) {
                e = th2;
                openInputStream = null;
                bo.b(openInputStream);
                bo.b(q);
                AppMethodBeat.o(27476);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            openInputStream = null;
            q = null;
        } catch (Throwable th3) {
            e = th3;
            openInputStream = null;
            q = null;
            bo.b(openInputStream);
            bo.b(q);
            AppMethodBeat.o(27476);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String b(ContentResolver contentResolver, Uri uri) {
        String name;
        Throwable e;
        AppMethodBeat.i(27477);
        Cursor query;
        try {
            query = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        name = new b(query.getString(0)).getName();
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(27477);
                        return name;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.ShareUtil", e, "getFileName", new Object[0]);
                        String[] split = URLDecoder.decode(uri.toString(), "utf8").split("/");
                        name = split[split.length - 1];
                    } catch (Exception e3) {
                        ab.printErrStackTrace("MicroMsg.ShareUtil", e3, "getFileName From Uri", new Object[0]);
                        name = null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                        }
                        AppMethodBeat.o(27477);
                        throw e;
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(27477);
                    return name;
                }
            }
            name = null;
            if (query != null) {
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(27477);
            throw e;
        }
        AppMethodBeat.o(27477);
        return name;
    }

    public static final String a(ContentResolver contentResolver, Uri uri, int i) {
        Throwable e;
        Object obj;
        String str = null;
        AppMethodBeat.i(27478);
        if (uri == null) {
            AppMethodBeat.o(27478);
        } else {
            b bVar = new b(ah.getContext().getCacheDir(), "share_img_tmp_" + i + ajn(contentResolver.getType(uri)));
            bVar.delete();
            Closeable q;
            Closeable obj2;
            try {
                q = com.tencent.mm.vfs.e.q(bVar);
                try {
                    obj2 = contentResolver.openInputStream(uri);
                    if (obj2 == null) {
                        bo.b(obj2);
                        bo.b(q);
                        AppMethodBeat.o(27478);
                    } else {
                        try {
                            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = obj2.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                q.write(bArr, 0, read);
                            }
                            str = j.w(bVar.dMD());
                            bo.b(obj2);
                            bo.b(q);
                            AppMethodBeat.o(27478);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                ab.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                                bo.b(obj2);
                                bo.b(q);
                                AppMethodBeat.o(27478);
                                return str;
                            } catch (Throwable th) {
                                e = th;
                                bo.b(obj2);
                                bo.b(q);
                                AppMethodBeat.o(27478);
                                throw e;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    obj2 = str;
                } catch (Throwable th2) {
                    e = th2;
                    obj2 = str;
                    bo.b(obj2);
                    bo.b(q);
                    AppMethodBeat.o(27478);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                obj2 = str;
                Object obj3 = str;
            } catch (Throwable th3) {
                e = th3;
                obj2 = str;
                q = str;
                bo.b(obj2);
                bo.b(q);
                AppMethodBeat.o(27478);
                throw e;
            }
        }
        return str;
    }

    private static String ajn(String str) {
        AppMethodBeat.i(27479);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(27479);
            return str2;
        }
        Object extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType == null || extensionFromMimeType.length() == 0) {
            String[] split = str.split("/");
            if (split != null && split.length > 1) {
                extensionFromMimeType = split[1];
            }
        }
        str2 = ".".concat(String.valueOf(extensionFromMimeType));
        AppMethodBeat.o(27479);
        return str2;
    }
}
