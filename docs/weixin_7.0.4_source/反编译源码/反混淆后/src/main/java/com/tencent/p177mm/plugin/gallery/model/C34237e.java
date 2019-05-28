package com.tencent.p177mm.plugin.gallery.model;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.gallery.model.C20905d.C120804;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.plugin.gallery.stub.C34241a;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: com.tencent.mm.plugin.gallery.model.e */
public final class C34237e {
    private static int bGt = 0;
    private static C34237e mNO = null;
    public static boolean mNP = false;
    public static boolean mNQ = false;
    public static boolean mNR = false;
    public static boolean mNS = false;
    private C45980l mNJ;
    private C43141c mNK;
    private C20909g mNL;
    private ArrayList<MediaItem> mNM = null;
    private LinkedHashSet<MediaItem> mNN = new LinkedHashSet();
    private HashSet<MediaItem> mNT = new HashSet();
    private ArrayList<Bundle> mNU = new ArrayList();
    private HashMap<Integer, Boolean> mNV = new HashMap();

    /* renamed from: NB */
    public static MediaItem m56156NB(String str) {
        AppMethodBeat.m2504i(21245);
        MediaItem a = MediaItem.m5515a(0, 0, str, "", "");
        if (C34237e.bBX().mNM != null) {
            int indexOf = C34237e.bBX().mNM.indexOf(a);
            if (indexOf >= 0) {
                a = (MediaItem) C34237e.bBX().mNM.get(indexOf);
                AppMethodBeat.m2505o(21245);
                return a;
            }
        }
        AppMethodBeat.m2505o(21245);
        return null;
    }

    private C34237e() {
        AppMethodBeat.m2504i(21246);
        if (this.mNK == null) {
            this.mNK = new C43141c();
        }
        if (this.mNJ == null) {
            this.mNJ = new C45980l();
        }
        if (this.mNL == null) {
            this.mNL = new C20909g();
        }
        AppMethodBeat.m2505o(21246);
    }

    private static C34237e bBX() {
        AppMethodBeat.m2504i(21247);
        if (mNO == null) {
            mNO = new C34237e();
        }
        C34237e c34237e = mNO;
        AppMethodBeat.m2505o(21247);
        return c34237e;
    }

    public static C43141c bBY() {
        AppMethodBeat.m2504i(21248);
        C43141c c43141c = C34237e.bBX().mNK;
        AppMethodBeat.m2505o(21248);
        return c43141c;
    }

    public static C45980l bBZ() {
        AppMethodBeat.m2504i(21249);
        C45980l c45980l = C34237e.bBX().mNJ;
        AppMethodBeat.m2505o(21249);
        return c45980l;
    }

    public static C20909g bCa() {
        AppMethodBeat.m2504i(21250);
        C20909g c20909g = C34237e.bBX().mNL;
        AppMethodBeat.m2505o(21250);
        return c20909g;
    }

    public static void initialize() {
        synchronized (C34237e.class) {
            bGt++;
        }
    }

    public static void release(boolean z) {
        AppMethodBeat.m2504i(21251);
        synchronized (C34237e.class) {
            try {
                if (bGt > 0) {
                    bGt--;
                }
                if (z && bGt == 0) {
                    C34237e.bBX().mNJ = null;
                    if (C34237e.bBX().mNK != null) {
                        C20905d c20905d = C34237e.bBX().mNK.mNv;
                        if (c20905d.mNF != null) {
                            c20905d.mNF.mo4403a(new C120804());
                            c20905d.mNF = null;
                        }
                        if (c20905d.mNG != null) {
                            C20908f c20908f = c20905d.mNG;
                            c20908f.bCi();
                            c20908f.bCj();
                            c20908f.bCl();
                            c20905d.mNG = null;
                        }
                        C34237e.bBX().mNK = null;
                    }
                    C20909g c20909g = C34237e.bBX().mNL;
                    if (c20909g.mOa != null) {
                        c20909g.mOa.quit();
                        c20909g.mOa = null;
                    }
                    c20909g.mOd = null;
                    if (c20909g.mOb != null) {
                        c20909g.mOb.quit();
                        c20909g.mOb = null;
                    }
                    c20909g.mOe = null;
                    if (c20909g.mOc != null) {
                        c20909g.mOc.quit();
                        c20909g.mOc = null;
                    }
                    c20909g.mOf = null;
                    C34237e.bBX().mNL = null;
                    mNO = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(21251);
            }
        }
    }

    public static ArrayList<MediaItem> bCb() {
        AppMethodBeat.m2504i(139020);
        ArrayList arrayList = C34237e.bBX().mNM;
        AppMethodBeat.m2505o(139020);
        return arrayList;
    }

    public static HashSet<MediaItem> bCc() {
        AppMethodBeat.m2504i(21253);
        HashSet hashSet = C34237e.bBX().mNT;
        AppMethodBeat.m2505o(21253);
        return hashSet;
    }

    public static ArrayList<Bundle> bCd() {
        AppMethodBeat.m2504i(21254);
        ArrayList arrayList = C34237e.bBX().mNU;
        AppMethodBeat.m2505o(21254);
        return arrayList;
    }

    public static LinkedHashSet<MediaItem> bCe() {
        AppMethodBeat.m2504i(21255);
        LinkedHashSet linkedHashSet = C34237e.bBX().mNN;
        AppMethodBeat.m2505o(21255);
        return linkedHashSet;
    }

    /* renamed from: B */
    public static void m56155B(ArrayList<MediaItem> arrayList) {
        AppMethodBeat.m2504i(21256);
        C34237e.bBX().mNM = arrayList;
        AppMethodBeat.m2505o(21256);
    }

    /* renamed from: wk */
    public static void m56159wk(int i) {
        AppMethodBeat.m2504i(21257);
        C34237e.bBX().mNV.put(Integer.valueOf(i), Boolean.TRUE);
        AppMethodBeat.m2505o(21257);
    }

    public static void bCf() {
        AppMethodBeat.m2504i(21258);
        C34237e.bBX().mNV.clear();
        AppMethodBeat.m2505o(21258);
    }

    public static int bCg() {
        AppMethodBeat.m2504i(21259);
        int size = C34237e.bBX().mNV.size();
        AppMethodBeat.m2505o(21259);
        return size;
    }

    /* renamed from: a */
    public static void m56157a(C34241a c34241a, int i, boolean z, boolean z2) {
        AppMethodBeat.m2504i(21260);
        C4990ab.m7417i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", Integer.valueOf(i), Boolean.valueOf(z));
        if (c34241a == null) {
            C4990ab.m7412e("MicroMsg.GalleryCore", "invoker is null");
            AppMethodBeat.m2505o(21260);
            return;
        }
        int i2;
        int size;
        if (C34237e.bBX().mNJ.hOZ == 3) {
            i2 = 1;
        } else if (C34237e.bBX().mNJ.hOZ == 4) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (C34237e.bBX().mNT != null) {
            size = C34237e.bBX().mNT.size();
        } else {
            size = 0;
        }
        C4990ab.m7417i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(size));
        if (size > 0) {
            c34241a.mo36247aK(13858, i2 + "," + i + "," + size + ",0");
        }
        C4990ab.m7417i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", Boolean.valueOf(c34241a.mo36249hC(true)));
        Iterator it = C34237e.bBX().mNU.iterator();
        while (it.hasNext()) {
            Bundle bundle = (Bundle) it.next();
            String string = bundle.getString("after_photo_edit");
            if (!(r4 && z2)) {
                C4990ab.m7417i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", string);
                C5730e.deleteFile(string);
                C40612a.m70043a(string, C4996ah.getContext());
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
            C4990ab.m7417i(str, str2, objArr);
            if (size > 0) {
                try {
                    c34241a.mo36247aK(13857, i2 + "," + z + "," + i3 + "," + i4 + "," + i5 + "," + i6 + "," + (z3 ? 1 : 0) + "," + i7 + ",2" + (z4 ? 1 : 0));
                } catch (RemoteException e) {
                    C4990ab.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(21260);
    }

    /* renamed from: a */
    public static void m56158a(C34241a c34241a, String str, int[] iArr, boolean z, boolean z2) {
        int i = 2;
        AppMethodBeat.m2504i(21261);
        switch (C34237e.bBX().mNJ.hOZ) {
            case 3:
                i = 1;
                break;
            case 4:
                if (!C5046bo.isNullOrNil(str) && str.equals(C4996ah.getContext().getString(C25738R.string.bnl))) {
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
        C4990ab.m7417i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", Integer.valueOf(r4));
        if (c34241a == null) {
            C4990ab.m7412e("MicroMsg.GalleryCore", "invoker is null");
            AppMethodBeat.m2505o(21261);
            return;
        }
        try {
            c34241a.mo36247aK(14205, i + "," + i + "," + iArr[0] + "," + iArr[1] + "," + iArr[2] + "," + iArr[3] + "," + z + "," + z2 + "," + mNP + "," + mNQ + "," + mNR + "," + mNS);
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
        }
        mNP = false;
        mNQ = false;
        mNR = false;
        mNS = false;
        AppMethodBeat.m2505o(21261);
    }
}
