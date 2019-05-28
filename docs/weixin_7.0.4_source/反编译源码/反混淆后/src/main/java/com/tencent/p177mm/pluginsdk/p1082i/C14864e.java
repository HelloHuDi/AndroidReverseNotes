package com.tencent.p177mm.pluginsdk.p1082i;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.Closeable;
import java.net.URLDecoder;

/* renamed from: com.tencent.mm.pluginsdk.i.e */
public final class C14864e {
    /* renamed from: a */
    public static final String m23125a(ContentResolver contentResolver, Uri uri) {
        Throwable e;
        AppMethodBeat.m2504i(27476);
        if (uri == null) {
            AppMethodBeat.m2505o(27476);
            return null;
        }
        C5728b c5728b;
        String type = contentResolver.getType(uri);
        String ajn = C14864e.ajn(type);
        String b = C14864e.m23127b(contentResolver, uri);
        if (C5046bo.isNullOrNil(b)) {
            b = "share_file" + C14864e.ajn(type);
        }
        C5728b c5728b2 = new C5728b(C6457e.euQ, b);
        if (c5728b2.exists()) {
            C9638aw.m17190ZK();
            c5728b = new C5728b(C4733l.m7083X(C18628c.m29096Ye(), b, ajn));
        } else {
            c5728b = c5728b2;
        }
        Closeable q;
        Closeable openInputStream;
        try {
            q = C5730e.m8641q(c5728b);
            try {
                openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    C5046bo.m7527b(openInputStream);
                    C5046bo.m7527b(q);
                    AppMethodBeat.m2505o(27476);
                    return null;
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read > 0) {
                            q.write(bArr, 0, read);
                        } else {
                            b = C5736j.m8649w(c5728b.dMD());
                            C5046bo.m7527b(openInputStream);
                            C5046bo.m7527b(q);
                            AppMethodBeat.m2505o(27476);
                            return b;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                        C5046bo.m7527b(openInputStream);
                        C5046bo.m7527b(q);
                        AppMethodBeat.m2505o(27476);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        C5046bo.m7527b(openInputStream);
                        C5046bo.m7527b(q);
                        AppMethodBeat.m2505o(27476);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openInputStream = null;
            } catch (Throwable th2) {
                e = th2;
                openInputStream = null;
                C5046bo.m7527b(openInputStream);
                C5046bo.m7527b(q);
                AppMethodBeat.m2505o(27476);
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
            C5046bo.m7527b(openInputStream);
            C5046bo.m7527b(q);
            AppMethodBeat.m2505o(27476);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static String m23127b(ContentResolver contentResolver, Uri uri) {
        String name;
        Throwable e;
        AppMethodBeat.m2504i(27477);
        Cursor query;
        try {
            query = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        name = new C5728b(query.getString(0)).getName();
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(27477);
                        return name;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.ShareUtil", e, "getFileName", new Object[0]);
                        String[] split = URLDecoder.decode(uri.toString(), "utf8").split("/");
                        name = split[split.length - 1];
                    } catch (Exception e3) {
                        C4990ab.printErrStackTrace("MicroMsg.ShareUtil", e3, "getFileName From Uri", new Object[0]);
                        name = null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                        }
                        AppMethodBeat.m2505o(27477);
                        throw e;
                    }
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(27477);
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
            AppMethodBeat.m2505o(27477);
            throw e;
        }
        AppMethodBeat.m2505o(27477);
        return name;
    }

    /* renamed from: a */
    public static final String m23126a(ContentResolver contentResolver, Uri uri, int i) {
        Throwable e;
        Object obj;
        String str = null;
        AppMethodBeat.m2504i(27478);
        if (uri == null) {
            AppMethodBeat.m2505o(27478);
        } else {
            C5728b c5728b = new C5728b(C4996ah.getContext().getCacheDir(), "share_img_tmp_" + i + C14864e.ajn(contentResolver.getType(uri)));
            c5728b.delete();
            Closeable q;
            Closeable obj2;
            try {
                q = C5730e.m8641q(c5728b);
                try {
                    obj2 = contentResolver.openInputStream(uri);
                    if (obj2 == null) {
                        C5046bo.m7527b(obj2);
                        C5046bo.m7527b(q);
                        AppMethodBeat.m2505o(27478);
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
                            str = C5736j.m8649w(c5728b.dMD());
                            C5046bo.m7527b(obj2);
                            C5046bo.m7527b(q);
                            AppMethodBeat.m2505o(27478);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                C4990ab.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                                C5046bo.m7527b(obj2);
                                C5046bo.m7527b(q);
                                AppMethodBeat.m2505o(27478);
                                return str;
                            } catch (Throwable th) {
                                e = th;
                                C5046bo.m7527b(obj2);
                                C5046bo.m7527b(q);
                                AppMethodBeat.m2505o(27478);
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
                    C5046bo.m7527b(obj2);
                    C5046bo.m7527b(q);
                    AppMethodBeat.m2505o(27478);
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
                C5046bo.m7527b(obj2);
                C5046bo.m7527b(q);
                AppMethodBeat.m2505o(27478);
                throw e;
            }
        }
        return str;
    }

    private static String ajn(String str) {
        AppMethodBeat.m2504i(27479);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(27479);
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
        AppMethodBeat.m2505o(27479);
        return str2;
    }
}
