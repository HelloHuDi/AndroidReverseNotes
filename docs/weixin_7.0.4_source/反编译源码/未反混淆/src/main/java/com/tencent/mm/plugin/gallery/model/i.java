package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import java.util.LinkedList;

public interface i {

    public interface d {
        void c(LinkedList<MediaItem> linkedList, long j);
    }

    public interface a {
        void V(LinkedList<AlbumItem> linkedList);
    }

    public interface c {
        void c(LinkedList<MediaItem> linkedList, long j);
    }

    public interface b {
        void b(LinkedList<MediaItem> linkedList, long j);
    }

    LinkedList<MediaItem> a(String str, int i, d dVar, long j);

    LinkedList<AlbumItem> bBS();

    void bBT();

    void bBV();
}
