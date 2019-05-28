package com.tencent.p177mm.plugin.gallery.model;

import com.tencent.p177mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.gallery.model.i */
public interface C43143i {

    /* renamed from: com.tencent.mm.plugin.gallery.model.i$d */
    public interface C28159d {
        /* renamed from: c */
        void mo46074c(LinkedList<MediaItem> linkedList, long j);
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.i$a */
    public interface C39158a {
        /* renamed from: V */
        void mo62060V(LinkedList<AlbumItem> linkedList);
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.i$c */
    public interface C43142c {
        /* renamed from: c */
        void mo62069c(LinkedList<MediaItem> linkedList, long j);
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.i$b */
    public interface C43144b {
        /* renamed from: b */
        void mo62070b(LinkedList<MediaItem> linkedList, long j);
    }

    /* renamed from: a */
    LinkedList<MediaItem> mo46076a(String str, int i, C28159d c28159d, long j);

    LinkedList<AlbumItem> bBS();

    void bBT();

    void bBV();
}
