package com.tencent.mm.plugin.gallery.model;

import android.database.Cursor;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

public abstract class b implements i {
    public static String mNs = "date_modified";
    public static String mNt = "datetaken";
    protected int mNq = 100;
    protected String[] mNr = new String[]{"camera", "screenshot", "download"};

    public String[] getProjection() {
        return new String[0];
    }

    public String aP(String str, boolean z) {
        return null;
    }

    public String hB(boolean z) {
        return null;
    }

    public String[] bBU() {
        return new String[0];
    }

    public String a(String[] strArr, boolean z) {
        return null;
    }

    protected static MediaItem b(Cursor cursor, int i) {
        if (cursor == null || cursor.isAfterLast()) {
            return null;
        }
        while (!cursor.isAfterLast()) {
            Long valueOf = Long.valueOf(bo.anl(cursor.getString(cursor.getColumnIndexOrThrow("_id"))));
            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow(mNs));
            String string3 = cursor.getString(cursor.getColumnIndexOrThrow(mNt));
            MediaItem N = MediaItem.N(i, valueOf.longValue());
            N.fPT = string;
            a(string2, string3, i, N);
            if (d.vxp) {
                ab.v("MicroMsg.BaseMediaQuery", "[mediaConvertFrom] [" + valueOf + " " + string2 + " " + string3 + "] | " + N.mOl + " " + i);
            } else {
                ab.d("MicroMsg.BaseMediaQuery", "[mediaConvertFrom] [" + valueOf + " " + string2 + " " + string3 + "] | " + N.mOl + " " + i);
            }
            if (bo.isNullOrNil(N.fPT) && bo.isNullOrNil(N.lZg)) {
                ab.w("MicroMsg.BaseMediaQuery", "thumb file and orignal file both not exist");
                cursor.moveToNext();
            } else {
                double d;
                String string4 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
                if (bo.isNullOrNil(string4)) {
                    string4 = "";
                }
                N.mMimeType = string4;
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("latitude");
                if (cursor.getType(columnIndexOrThrow) != 0) {
                    d = cursor.getDouble(columnIndexOrThrow);
                    if (a.r(d)) {
                        N.bDG = d;
                    }
                }
                columnIndexOrThrow = cursor.getColumnIndexOrThrow("longitude");
                if (cursor.getType(columnIndexOrThrow) != 0) {
                    d = cursor.getDouble(columnIndexOrThrow);
                    if (a.q(d)) {
                        N.bDH = d;
                    }
                }
                return N;
            }
        }
        return null;
    }

    private static void a(String str, String str2, int i, MediaItem mediaItem) {
        boolean z;
        long j;
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        long a = a(str, currentTimeMillis, z, true);
        if (i != 1) {
            z2 = false;
        }
        long a2 = a(str2, currentTimeMillis, z2, false);
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
    private static long a(String str, long j, boolean z, boolean z2) {
        Throwable e;
        h hVar;
        long j2;
        long j3 = 0;
        if (!bo.isNullOrNil(str)) {
            long j4;
            try {
                j4 = bo.getLong(str, 0);
                if (j4 > 2147483647L) {
                    try {
                        j3 = TimeUnit.MILLISECONDS.convert(j4, TimeUnit.MILLISECONDS);
                    } catch (NumberFormatException e2) {
                        e = e2;
                        try {
                            ab.printErrStackTrace("MicroMsg.BaseMediaQuery", e, "", new Object[0]);
                            if (0 > j) {
                                if (z2) {
                                    h.pYm.a(363, z ? 13 : 14, 1, false);
                                } else {
                                    h.pYm.a(363, z ? 15 : 16, 1, false);
                                }
                            }
                            if (j4 <= 2147483647L) {
                                if (z2) {
                                    h.pYm.a(363, z ? 9 : 10, 1, false);
                                }
                            } else if (!z2) {
                                h.pYm.a(363, z ? 11 : 12, 1, false);
                            }
                            if (j4 <= 0) {
                                hVar = h.pYm;
                                if (z2) {
                                    j2 = 17;
                                } else {
                                    j2 = 18;
                                }
                                hVar.a(363, j2, 1, false);
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
                        h.pYm.a(363, z ? 13 : 14, 1, false);
                    } else {
                        h.pYm.a(363, z ? 15 : 16, 1, false);
                    }
                }
                if (j4 > 2147483647L) {
                    if (z2) {
                        h.pYm.a(363, z ? 9 : 10, 1, false);
                    }
                } else if (!z2) {
                    h.pYm.a(363, z ? 11 : 12, 1, false);
                }
                if (j4 <= 0) {
                    h.pYm.a(363, z2 ? 17 : 18, 1, false);
                }
            } catch (NumberFormatException e3) {
                e = e3;
                j4 = 0;
                ab.printErrStackTrace("MicroMsg.BaseMediaQuery", e, "", new Object[0]);
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
                        h.pYm.a(363, z ? 13 : 14, 1, false);
                    } else {
                        h.pYm.a(363, z ? 15 : 16, 1, false);
                    }
                }
                if (j4 <= 2147483647L) {
                    if (z2) {
                        h.pYm.a(363, z ? 9 : 10, 1, false);
                    }
                } else if (!z2) {
                    h.pYm.a(363, z ? 11 : 12, 1, false);
                }
                if (j4 <= 0) {
                    hVar = h.pYm;
                    if (z2) {
                        j2 = 17;
                    } else {
                        j2 = 18;
                    }
                    hVar.a(363, j2, 1, false);
                }
                throw e;
            }
        }
        return j3;
    }

    protected static AlbumItem a(Cursor cursor, int i, String str) {
        Long valueOf = Long.valueOf(bo.anl(cursor.getString(cursor.getColumnIndexOrThrow("_id"))));
        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(str));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow(mNs));
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow(mNt));
        if (bo.isNullOrNil(string2)) {
            ab.e("MicroMsg.BaseMediaQuery", "null or nill album name, ignore this folder");
            return null;
        }
        int i2 = cursor.getInt(3);
        ab.i("MicroMsg.BaseMediaQuery", "%s(%s) path:%s", string2, Integer.valueOf(i2), string);
        if (i2 == 0 || bo.isNullOrNil(string)) {
            ab.e("MicroMsg.BaseMediaQuery", "query album failed, " + i2 + ", " + string);
            return null;
        }
        if (bo.isNullOrNil(string)) {
            string = null;
        }
        int i3 = i;
        MediaItem a = MediaItem.a(i3, valueOf.longValue(), string, null, cursor.getString(cursor.getColumnIndexOrThrow("mime_type")));
        a(string3, string4, i, a);
        AlbumItem albumItem = new AlbumItem(string2, i2);
        albumItem.oqq = a;
        return albumItem;
    }

    public final void bBV() {
        this.mNq = 1000;
    }
}
