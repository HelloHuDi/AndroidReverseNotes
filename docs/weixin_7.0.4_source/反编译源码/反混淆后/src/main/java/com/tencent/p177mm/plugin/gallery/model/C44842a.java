package com.tencent.p177mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C28159d;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Comparator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.gallery.model.a */
public final class C44842a extends C44742b implements Comparator<MediaItem> {
    protected ContentResolver bpL = C4996ah.getContext().getContentResolver();
    private volatile boolean eVT = false;
    private C44843j mNo = new C44843j();
    private C28160n mNp = new C28160n();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(21222);
        int compare = Long.compare(((MediaItem) obj).mOl, ((MediaItem) obj2).mOl);
        AppMethodBeat.m2505o(21222);
        return compare;
    }

    public C44842a() {
        AppMethodBeat.m2504i(21218);
        AppMethodBeat.m2505o(21218);
    }

    /* renamed from: hB */
    public final String mo46082hB(boolean z) {
        AppMethodBeat.m2504i(21219);
        String str;
        if (z) {
            str = C44742b.mNt + " desc, _id desc";
            AppMethodBeat.m2505o(21219);
            return str;
        }
        str = C44742b.mNs + " desc, _id desc";
        AppMethodBeat.m2505o(21219);
        return str;
    }

    public final LinkedList<AlbumItem> bBS() {
        Cursor query;
        Cursor cursor = null;
        AppMethodBeat.m2504i(21220);
        LinkedList linkedList = new LinkedList();
        try {
            query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.bBU(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AllMediaQuery", "query video album list failed : [%s]", e.getMessage());
            query = cursor;
        }
        if (query == null) {
            C4990ab.m7410d("MicroMsg.AllMediaQuery", "no video folder now");
        } else {
            if (query.moveToFirst()) {
                AlbumItem a;
                MediaItem mediaItem = cursor;
                int i = 0;
                do {
                    a = C44742b.m81536a(query, 2, "bucket_display_name");
                    if (a != null) {
                        i += a.cyR;
                        if (mediaItem == null) {
                            mediaItem = a.oqq;
                        }
                    }
                } while (query.moveToNext());
                a = new AlbumItem(C4996ah.getContext().getString(C25738R.string.c35), i);
                a.oqq = mediaItem;
                linkedList.add(a);
            }
            query.close();
        }
        try {
            cursor = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.bBU(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.AllMediaQuery", "query image album list failed : [%s]", e2.getMessage());
        }
        if (cursor == null) {
            C4990ab.m7410d("MicroMsg.AllMediaQuery", "no image folder now");
        } else {
            if (cursor.moveToFirst()) {
                do {
                    AlbumItem a2 = C44742b.m81536a(cursor, 1, "bucket_display_name");
                    if (a2 != null) {
                        linkedList.add(a2);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        AppMethodBeat.m2505o(21220);
        return linkedList;
    }

    /* renamed from: a */
    public final LinkedList<MediaItem> mo46076a(String str, int i, C28159d c28159d, long j) {
        Cursor query;
        AppMethodBeat.m2504i(21221);
        long currentTimeMillis = System.currentTimeMillis();
        this.eVT = false;
        LinkedList<MediaItem> linkedList = new LinkedList();
        Cursor cursor = null;
        Cursor cursor2 = null;
        Cursor cursor3 = null;
        Cursor query2;
        if (C5046bo.isNullOrNil(str)) {
            if (i == 1 || i == 3) {
                cursor = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.getProjection(), this.mNo.mo46075a(this.mNr, false), null, this.mNo.mo46082hB(false));
                cursor2 = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.getProjection(), this.mNo.mo46075a(this.mNr, true), null, this.mNo.mo46082hB(true));
            }
            if (i == 2 || i == 3) {
                query2 = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.getProjection(), this.mNp.mo46075a(new String[]{this.mNr[0]}, false), null, this.mNp.mo46082hB(false));
                query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.getProjection(), this.mNp.mo46075a(new String[]{this.mNr[0]}, true), null, this.mNp.mo46082hB(true));
                cursor3 = query2;
            }
            query = null;
        } else {
            if (i == 1 || i == 3) {
                cursor = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.getProjection(), this.mNo.mo46077aP(str, false), null, this.mNo.mo46082hB(false));
                cursor2 = this.bpL.query(Images.Media.EXTERNAL_CONTENT_URI, this.mNo.getProjection(), this.mNo.mo46077aP(str, true), null, this.mNo.mo46082hB(true));
            }
            if (i == 2 || i == 3) {
                query2 = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.getProjection(), this.mNp.mo46077aP(str, false), null, this.mNp.mo46082hB(false));
                query = this.bpL.query(Media.EXTERNAL_CONTENT_URI, this.mNp.getProjection(), this.mNp.mo46077aP(str, true), null, this.mNp.mo46082hB(true));
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
        MediaItem b = C44742b.m81538b(cursor, 1);
        MediaItem b2 = C44742b.m81538b(cursor2, 1);
        MediaItem b3 = C44742b.m81538b(cursor3, 2);
        MediaItem b4 = C44742b.m81538b(query, 2);
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
                    b = C44742b.m81538b(cursor, 1);
                } else if (mediaItem == b2) {
                    cursor2.moveToNext();
                    b2 = C44742b.m81538b(cursor2, 1);
                } else if (mediaItem == b3) {
                    cursor3.moveToNext();
                    b3 = C44742b.m81538b(cursor3, 2);
                } else if (mediaItem == b4) {
                    query.moveToNext();
                    b4 = C44742b.m81538b(query, 2);
                }
                if (linkedList.size() + (1 % this.mNq) == 0) {
                    c28159d.mo46074c(linkedList, j);
                }
            } else {
                c28159d.mo46074c(linkedList, j);
                C4990ab.m7417i("MicroMsg.AllMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result size:%s ticket:%s cost:%s", str, Integer.valueOf(i), Integer.valueOf(linkedList.size()), Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(21221);
                return linkedList;
            }
        } while (!this.eVT);
        AppMethodBeat.m2505o(21221);
        return linkedList;
    }

    public final void bBT() {
        this.eVT = true;
    }
}
