package com.tencent.p177mm.plugin.gallery.model;

import android.database.Cursor;
import com.tencent.p177mm.modelgeo.C42205a;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.gallery.model.b */
public abstract class C44742b implements C43143i {
    public static String mNs = "date_modified";
    public static String mNt = "datetaken";
    protected int mNq = 100;
    protected String[] mNr = new String[]{"camera", "screenshot", "download"};

    public String[] getProjection() {
        return new String[0];
    }

    /* renamed from: aP */
    public String mo46077aP(String str, boolean z) {
        return null;
    }

    /* renamed from: hB */
    public String mo46082hB(boolean z) {
        return null;
    }

    public String[] bBU() {
        return new String[0];
    }

    /* renamed from: a */
    public String mo46075a(String[] strArr, boolean z) {
        return null;
    }

    /* renamed from: b */
    protected static MediaItem m81538b(Cursor cursor, int i) {
        if (cursor == null || cursor.isAfterLast()) {
            return null;
        }
        while (!cursor.isAfterLast()) {
            Long valueOf = Long.valueOf(C5046bo.anl(cursor.getString(cursor.getColumnIndexOrThrow("_id"))));
            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow(mNs));
            String string3 = cursor.getString(cursor.getColumnIndexOrThrow(mNt));
            MediaItem N = MediaItem.m5514N(i, valueOf.longValue());
            N.fPT = string;
            C44742b.m81537a(string2, string3, i, N);
            if (C7243d.vxp) {
                C4990ab.m7418v("MicroMsg.BaseMediaQuery", "[mediaConvertFrom] [" + valueOf + " " + string2 + " " + string3 + "] | " + N.mOl + " " + i);
            } else {
                C4990ab.m7410d("MicroMsg.BaseMediaQuery", "[mediaConvertFrom] [" + valueOf + " " + string2 + " " + string3 + "] | " + N.mOl + " " + i);
            }
            if (C5046bo.isNullOrNil(N.fPT) && C5046bo.isNullOrNil(N.lZg)) {
                C4990ab.m7420w("MicroMsg.BaseMediaQuery", "thumb file and orignal file both not exist");
                cursor.moveToNext();
            } else {
                double d;
                String string4 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
                if (C5046bo.isNullOrNil(string4)) {
                    string4 = "";
                }
                N.mMimeType = string4;
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("latitude");
                if (cursor.getType(columnIndexOrThrow) != 0) {
                    d = cursor.getDouble(columnIndexOrThrow);
                    if (C42205a.m74464r(d)) {
                        N.bDG = d;
                    }
                }
                columnIndexOrThrow = cursor.getColumnIndexOrThrow("longitude");
                if (cursor.getType(columnIndexOrThrow) != 0) {
                    d = cursor.getDouble(columnIndexOrThrow);
                    if (C42205a.m74463q(d)) {
                        N.bDH = d;
                    }
                }
                return N;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m81537a(String str, String str2, int i, MediaItem mediaItem) {
        boolean z;
        long j;
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        long a = C44742b.m81535a(str, currentTimeMillis, z, true);
        if (i != 1) {
            z2 = false;
        }
        long a2 = C44742b.m81535a(str2, currentTimeMillis, z2, false);
        if (a > 0) {
            j = a;
        } else {
            j = a2;
        }
        mediaItem.mOl = j;
        mediaItem.mOm = a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static long m81535a(String str, long j, boolean z, boolean z2) {
        Throwable e;
        C7060h c7060h;
        long j2;
        long j3 = 0;
        if (!C5046bo.isNullOrNil(str)) {
            long j4;
            try {
                j4 = C5046bo.getLong(str, 0);
                if (j4 > 2147483647L) {
                    try {
                        j3 = TimeUnit.MILLISECONDS.convert(j4, TimeUnit.MILLISECONDS);
                    } catch (NumberFormatException e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.BaseMediaQuery", e, "", new Object[0]);
                            if (0 > j) {
                                if (z2) {
                                    C7060h.pYm.mo8378a(363, z ? 13 : 14, 1, false);
                                } else {
                                    C7060h.pYm.mo8378a(363, z ? 15 : 16, 1, false);
                                }
                            }
                            if (j4 <= 2147483647L) {
                                if (z2) {
                                    C7060h.pYm.mo8378a(363, z ? 9 : 10, 1, false);
                                }
                            } else if (!z2) {
                                C7060h.pYm.mo8378a(363, z ? 11 : 12, 1, false);
                            }
                            if (j4 <= 0) {
                                c7060h = C7060h.pYm;
                                if (z2) {
                                    j2 = 17;
                                } else {
                                    j2 = 18;
                                }
                                c7060h.mo8378a(363, j2, 1, false);
                            }
                            return j3;
                        } catch (Throwable th) {
                            e = th;
                            if (0 > j) {
                            }
                            if (j4 <= 2147483647L) {
                            }
                            if (j4 <= 0) {
                            }
                            throw e;
                        }
                    }
                }
                j3 = TimeUnit.MILLISECONDS.convert(j4, TimeUnit.SECONDS);
                if (j3 > j) {
                    if (z2) {
                        C7060h.pYm.mo8378a(363, z ? 13 : 14, 1, false);
                    } else {
                        C7060h.pYm.mo8378a(363, z ? 15 : 16, 1, false);
                    }
                }
                if (j4 > 2147483647L) {
                    if (z2) {
                        C7060h.pYm.mo8378a(363, z ? 9 : 10, 1, false);
                    }
                } else if (!z2) {
                    C7060h.pYm.mo8378a(363, z ? 11 : 12, 1, false);
                }
                if (j4 <= 0) {
                    C7060h.pYm.mo8378a(363, z2 ? 17 : 18, 1, false);
                }
            } catch (NumberFormatException e3) {
                e = e3;
                j4 = 0;
                C4990ab.printErrStackTrace("MicroMsg.BaseMediaQuery", e, "", new Object[0]);
                if (0 > j) {
                }
                if (j4 <= 2147483647L) {
                }
                if (j4 <= 0) {
                }
                return j3;
            } catch (Throwable th2) {
                e = th2;
                j4 = 0;
                if (0 > j) {
                    if (z2) {
                        C7060h.pYm.mo8378a(363, z ? 13 : 14, 1, false);
                    } else {
                        C7060h.pYm.mo8378a(363, z ? 15 : 16, 1, false);
                    }
                }
                if (j4 <= 2147483647L) {
                    if (z2) {
                        C7060h.pYm.mo8378a(363, z ? 9 : 10, 1, false);
                    }
                } else if (!z2) {
                    C7060h.pYm.mo8378a(363, z ? 11 : 12, 1, false);
                }
                if (j4 <= 0) {
                    c7060h = C7060h.pYm;
                    if (z2) {
                        j2 = 17;
                    } else {
                        j2 = 18;
                    }
                    c7060h.mo8378a(363, j2, 1, false);
                }
                throw e;
            }
        }
        return j3;
    }

    /* renamed from: a */
    protected static AlbumItem m81536a(Cursor cursor, int i, String str) {
        Long valueOf = Long.valueOf(C5046bo.anl(cursor.getString(cursor.getColumnIndexOrThrow("_id"))));
        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(str));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow(mNs));
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow(mNt));
        if (C5046bo.isNullOrNil(string2)) {
            C4990ab.m7412e("MicroMsg.BaseMediaQuery", "null or nill album name, ignore this folder");
            return null;
        }
        int i2 = cursor.getInt(3);
        C4990ab.m7417i("MicroMsg.BaseMediaQuery", "%s(%s) path:%s", string2, Integer.valueOf(i2), string);
        if (i2 == 0 || C5046bo.isNullOrNil(string)) {
            C4990ab.m7412e("MicroMsg.BaseMediaQuery", "query album failed, " + i2 + ", " + string);
            return null;
        }
        if (C5046bo.isNullOrNil(string)) {
            string = null;
        }
        int i3 = i;
        MediaItem a = MediaItem.m5515a(i3, valueOf.longValue(), string, null, cursor.getString(cursor.getColumnIndexOrThrow("mime_type")));
        C44742b.m81537a(string3, string4, i, a);
        AlbumItem albumItem = new AlbumItem(string2, i2);
        albumItem.oqq = a;
        return albumItem;
    }

    public final void bBV() {
        this.mNq = 1000;
    }
}
