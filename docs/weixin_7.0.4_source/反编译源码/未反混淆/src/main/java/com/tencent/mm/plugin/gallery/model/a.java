package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Comparator;
import java.util.LinkedList;

public final class a extends b implements Comparator<MediaItem> {
    protected ContentResolver bpL = ah.getContext().getContentResolver();
    private volatile boolean eVT = false;
    private j mNo = new j();
    private n mNp = new n();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(21222);
        int compare = Long.compare(((MediaItem) obj).mOl, ((MediaItem) obj2).mOl);
        AppMethodBeat.o(21222);
        return compare;
    }

    public a() {
        AppMethodBeat.i(21218);
        AppMethodBeat.o(21218);
    }

    public final String hB(boolean z) {
        AppMethodBeat.i(21219);
        String str;
        if (z) {
            str = b.mNt + " desc, _id desc";
            AppMethodBeat.o(21219);
            return str;
        }
        str = b.mNs + " desc, _id desc";
        AppMethodBeat.o(21219);
        return str;
    }

    public final LinkedList<AlbumItem> bBS() {
        Cursor query;
        Cursor cursor = null;
        AppMethodBeat.i(21220);
        LinkedList linkedList = new LinkedList();
        try {
            query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.bBU(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
        } catch (Exception e) {
            ab.e("MicroMsg.AllMediaQuery", "query video album list failed : [%s]", e.getMessage());
            query = cursor;
        }
        if (query == null) {
            ab.d("MicroMsg.AllMediaQuery", "no video folder now");
        } else {
            if (query.moveToFirst()) {
                AlbumItem a;
                MediaItem mediaItem = cursor;
                int i = 0;
                do {
                    a = b.a(query, 2, "bucket_display_name");
                    if (a != null) {
                        i += a.cyR;
                        if (mediaItem == null) {
                            mediaItem = a.oqq;
                        }
                    }
                } while (query.moveToNext());
                a = new AlbumItem(ah.getContext().getString(R.string.c35), i);
                a.oqq = mediaItem;
                linkedList.add(a);
            }
            query.close();
        }
        try {
            cursor = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.bBU(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
        } catch (Exception e2) {
            ab.e("MicroMsg.AllMediaQuery", "query image album list failed : [%s]", e2.getMessage());
        }
        if (cursor == null) {
            ab.d("MicroMsg.AllMediaQuery", "no image folder now");
        } else {
            if (cursor.moveToFirst()) {
                do {
                    AlbumItem a2 = b.a(cursor, 1, "bucket_display_name");
                    if (a2 != null) {
                        linkedList.add(a2);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        AppMethodBeat.o(21220);
        return linkedList;
    }

    public final LinkedList<MediaItem> a(String str, int i, d dVar, long j) {
        Cursor query;
        AppMethodBeat.i(21221);
        long currentTimeMillis = System.currentTimeMillis();
        this.eVT = false;
        LinkedList<MediaItem> linkedList = new LinkedList();
        Cursor cursor = null;
        Cursor cursor2 = null;
        Cursor cursor3 = null;
        Cursor query2;
        if (bo.isNullOrNil(str)) {
            if (i == 1 || i == 3) {
                cursor = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.getProjection(), this.mNo.a(this.mNr, false), null, this.mNo.hB(false));
                cursor2 = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.getProjection(), this.mNo.a(this.mNr, true), null, this.mNo.hB(true));
            }
            if (i == 2 || i == 3) {
                query2 = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.getProjection(), this.mNp.a(new String[]{this.mNr[0]}, false), null, this.mNp.hB(false));
                query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.getProjection(), this.mNp.a(new String[]{this.mNr[0]}, true), null, this.mNp.hB(true));
                cursor3 = query2;
            }
            query = null;
        } else {
            if (i == 1 || i == 3) {
                cursor = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.getProjection(), this.mNo.aP(str, false), null, this.mNo.hB(false));
                cursor2 = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.getProjection(), this.mNo.aP(str, true), null, this.mNo.hB(true));
            }
            if (i == 2 || i == 3) {
                query2 = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.getProjection(), this.mNp.aP(str, false), null, this.mNp.hB(false));
                query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.getProjection(), this.mNp.aP(str, true), null, this.mNp.hB(true));
                cursor3 = query2;
            }
            query = null;
        }
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if (cursor2 != null) {
            cursor2.moveToFirst();
        }
        if (cursor3 != null) {
            cursor3.moveToFirst();
        }
        if (query != null) {
            query.moveToFirst();
        }
        MediaItem b = b.b(cursor, 1);
        MediaItem b2 = b.b(cursor2, 1);
        MediaItem b3 = b.b(cursor3, 2);
        MediaItem b4 = b.b(query, 2);
        do {
            MediaItem mediaItem = null;
            if (b != null) {
                mediaItem = b;
            }
            if (b2 != null && (r8 == null || r8.mOl < b2.mOl)) {
                mediaItem = b2;
            }
            if (b3 != null && (r8 == null || r8.mOl < b3.mOl)) {
                mediaItem = b3;
            }
            if (b4 != null && (r8 == null || r8.mOl < b4.mOl)) {
                mediaItem = b4;
            }
            if (mediaItem != null) {
                linkedList.add(mediaItem);
                if (mediaItem == b) {
                    cursor.moveToNext();
                    b = b.b(cursor, 1);
                } else if (mediaItem == b2) {
                    cursor2.moveToNext();
                    b2 = b.b(cursor2, 1);
                } else if (mediaItem == b3) {
                    cursor3.moveToNext();
                    b3 = b.b(cursor3, 2);
                } else if (mediaItem == b4) {
                    query.moveToNext();
                    b4 = b.b(query, 2);
                }
                if (linkedList.size() + (1 % this.mNq) == 0) {
                    dVar.c(linkedList, j);
                }
            } else {
                dVar.c(linkedList, j);
                ab.i("MicroMsg.AllMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result size:%s ticket:%s cost:%s", str, Integer.valueOf(i), Integer.valueOf(linkedList.size()), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(21221);
                return linkedList;
            }
        } while (!this.eVT);
        AppMethodBeat.o(21221);
        return linkedList;
    }

    public final void bBT() {
        this.eVT = true;
    }
}
