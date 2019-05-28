package com.tencent.mm.plugin.gallery.model;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class e {
    private static int bGt = 0;
    private static e mNO = null;
    public static boolean mNP = false;
    public static boolean mNQ = false;
    public static boolean mNR = false;
    public static boolean mNS = false;
    private l mNJ;
    private c mNK;
    private g mNL;
    private ArrayList<MediaItem> mNM = null;
    private LinkedHashSet<MediaItem> mNN = new LinkedHashSet();
    private HashSet<MediaItem> mNT = new HashSet();
    private ArrayList<Bundle> mNU = new ArrayList();
    private HashMap<Integer, Boolean> mNV = new HashMap();

    public static MediaItem NB(String str) {
        AppMethodBeat.i(21245);
        MediaItem a = MediaItem.a(0, 0, str, "", "");
        if (bBX().mNM != null) {
            int indexOf = bBX().mNM.indexOf(a);
            if (indexOf >= 0) {
                a = (MediaItem) bBX().mNM.get(indexOf);
                AppMethodBeat.o(21245);
                return a;
            }
        }
        AppMethodBeat.o(21245);
        return null;
    }

    private e() {
        AppMethodBeat.i(21246);
        if (this.mNK == null) {
            this.mNK = new c();
        }
        if (this.mNJ == null) {
            this.mNJ = new l();
        }
        if (this.mNL == null) {
            this.mNL = new g();
        }
        AppMethodBeat.o(21246);
    }

    private static e bBX() {
        AppMethodBeat.i(21247);
        if (mNO == null) {
            mNO = new e();
        }
        e eVar = mNO;
        AppMethodBeat.o(21247);
        return eVar;
    }

    public static c bBY() {
        AppMethodBeat.i(21248);
        c cVar = bBX().mNK;
        AppMethodBeat.o(21248);
        return cVar;
    }

    public static l bBZ() {
        AppMethodBeat.i(21249);
        l lVar = bBX().mNJ;
        AppMethodBeat.o(21249);
        return lVar;
    }

    public static g bCa() {
        AppMethodBeat.i(21250);
        g gVar = bBX().mNL;
        AppMethodBeat.o(21250);
        return gVar;
    }

    public static void initialize() {
        synchronized (e.class) {
            bGt++;
        }
    }

    public static void release(boolean z) {
        AppMethodBeat.i(21251);
        synchronized (e.class) {
            try {
                if (bGt > 0) {
                    bGt--;
                }
                if (z && bGt == 0) {
                    bBX().mNJ = null;
                    if (bBX().mNK != null) {
                        d dVar = bBX().mNK.mNv;
                        if (dVar.mNF != null) {
                            dVar.mNF.a(new a<String, a>() {
                            });
                            dVar.mNF = null;
                        }
                        if (dVar.mNG != null) {
                            f fVar = dVar.mNG;
                            fVar.bCi();
                            fVar.bCj();
                            fVar.bCl();
                            dVar.mNG = null;
                        }
                        bBX().mNK = null;
                    }
                    g gVar = bBX().mNL;
                    if (gVar.mOa != null) {
                        gVar.mOa.quit();
                        gVar.mOa = null;
                    }
                    gVar.mOd = null;
                    if (gVar.mOb != null) {
                        gVar.mOb.quit();
                        gVar.mOb = null;
                    }
                    gVar.mOe = null;
                    if (gVar.mOc != null) {
                        gVar.mOc.quit();
                        gVar.mOc = null;
                    }
                    gVar.mOf = null;
                    bBX().mNL = null;
                    mNO = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(21251);
            }
        }
    }

    public static ArrayList<MediaItem> bCb() {
        AppMethodBeat.i(139020);
        ArrayList arrayList = bBX().mNM;
        AppMethodBeat.o(139020);
        return arrayList;
    }

    public static HashSet<MediaItem> bCc() {
        AppMethodBeat.i(21253);
        HashSet hashSet = bBX().mNT;
        AppMethodBeat.o(21253);
        return hashSet;
    }

    public static ArrayList<Bundle> bCd() {
        AppMethodBeat.i(21254);
        ArrayList arrayList = bBX().mNU;
        AppMethodBeat.o(21254);
        return arrayList;
    }

    public static LinkedHashSet<MediaItem> bCe() {
        AppMethodBeat.i(21255);
        LinkedHashSet linkedHashSet = bBX().mNN;
        AppMethodBeat.o(21255);
        return linkedHashSet;
    }

    public static void B(ArrayList<MediaItem> arrayList) {
        AppMethodBeat.i(21256);
        bBX().mNM = arrayList;
        AppMethodBeat.o(21256);
    }

    public static void wk(int i) {
        AppMethodBeat.i(21257);
        bBX().mNV.put(Integer.valueOf(i), Boolean.TRUE);
        AppMethodBeat.o(21257);
    }

    public static void bCf() {
        AppMethodBeat.i(21258);
        bBX().mNV.clear();
        AppMethodBeat.o(21258);
    }

    public static int bCg() {
        AppMethodBeat.i(21259);
        int size = bBX().mNV.size();
        AppMethodBeat.o(21259);
        return size;
    }

    public static void a(com.tencent.mm.plugin.gallery.stub.a aVar, int i, boolean z, boolean z2) {
        AppMethodBeat.i(21260);
        ab.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", Integer.valueOf(i), Boolean.valueOf(z));
        if (aVar == null) {
            ab.e("MicroMsg.GalleryCore", "invoker is null");
            AppMethodBeat.o(21260);
            return;
        }
        int i2;
        int size;
        if (bBX().mNJ.hOZ == 3) {
            i2 = 1;
        } else if (bBX().mNJ.hOZ == 4) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (bBX().mNT != null) {
            size = bBX().mNT.size();
        } else {
            size = 0;
        }
        ab.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(size));
        if (size > 0) {
            aVar.aK(13858, i2 + "," + i + "," + size + ",0");
        }
        ab.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", Boolean.valueOf(aVar.hC(true)));
        Iterator it = bBX().mNU.iterator();
        while (it.hasNext()) {
            Bundle bundle = (Bundle) it.next();
            String string = bundle.getString("after_photo_edit");
            if (!(r4 && z2)) {
                ab.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", string);
                com.tencent.mm.vfs.e.deleteFile(string);
                com.tencent.mm.sdk.f.a.a(string, ah.getContext());
            }
            int i3 = bundle.getInt("report_info_emotion_count");
            int i4 = bundle.getInt("report_info_text_count");
            int i5 = bundle.getInt("report_info_mosaic_count");
            int i6 = bundle.getInt("report_info_doodle_count");
            boolean z3 = bundle.getBoolean("report_info_iscrop");
            int i7 = bundle.getInt("report_info_undo_count");
            boolean z4 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.GalleryCore";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i4);
            objArr[2] = Integer.valueOf(i5);
            objArr[3] = Integer.valueOf(i6);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            objArr[5] = Integer.valueOf(i7);
            objArr[6] = Integer.valueOf(z4 ? 1 : 0);
            ab.i(str, str2, objArr);
            if (size > 0) {
                try {
                    aVar.aK(13857, i2 + "," + z + "," + i3 + "," + i4 + "," + i5 + "," + i6 + "," + (z3 ? 1 : 0) + "," + i7 + ",2" + (z4 ? 1 : 0));
                } catch (RemoteException e) {
                    ab.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(21260);
    }

    public static void a(com.tencent.mm.plugin.gallery.stub.a aVar, String str, int[] iArr, boolean z, boolean z2) {
        int i = 2;
        AppMethodBeat.i(21261);
        switch (bBX().mNJ.hOZ) {
            case 3:
                i = 1;
                break;
            case 4:
                if (!bo.isNullOrNil(str) && str.equals(ah.getContext().getString(R.string.bnl))) {
                    i = 6;
                    break;
                }
            case 7:
            case 8:
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        ab.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", Integer.valueOf(r4));
        if (aVar == null) {
            ab.e("MicroMsg.GalleryCore", "invoker is null");
            AppMethodBeat.o(21261);
            return;
        }
        try {
            aVar.aK(14205, i + "," + i + "," + iArr[0] + "," + iArr[1] + "," + iArr[2] + "," + iArr[3] + "," + z + "," + z2 + "," + mNP + "," + mNQ + "," + mNR + "," + mNS);
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
        }
        mNP = false;
        mNQ = false;
        mNR = false;
        mNS = false;
        AppMethodBeat.o(21261);
    }
}
