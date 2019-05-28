package com.tencent.mm.plugin.fav.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.af.j;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static f<String, Bitmap> mic = new b(20, c.class);
    private static Map<String, Integer> mid;

    public static void a(int i, Activity activity, a.b bVar) {
        AppMethodBeat.i(73983);
        a(-1, i, activity, null, null, null, bVar);
        AppMethodBeat.o(73983);
    }

    public static void a(int i, int i2, Activity activity, Fragment fragment, com.tencent.mm.ui.widget.snackbar.a.c cVar, final OnClickListener onClickListener, a.b bVar) {
        AppMethodBeat.i(73984);
        if (activity == null && fragment == null) {
            ab.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
            AppMethodBeat.o(73984);
            return;
        }
        a.b anonymousClass1;
        if (bVar == null) {
            anonymousClass1 = new a.b() {
                public final void aIu() {
                    AppMethodBeat.i(73977);
                    gh ghVar = new gh();
                    ghVar.cAH.type = 35;
                    com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                    AppMethodBeat.o(73977);
                }
            };
        } else {
            anonymousClass1 = bVar;
        }
        if (i2 != 0) {
            Activity activity2;
            if (activity == null) {
                activity2 = fragment.getActivity();
            } else {
                activity2 = activity;
            }
            switch (i2) {
                case -10:
                    a(activity2, fragment);
                    AppMethodBeat.o(73984);
                    return;
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                    a(i, i2, activity2, fragment, onClickListener, anonymousClass1, cVar);
                    AppMethodBeat.o(73984);
                    return;
                case -2:
                    a((Context) activity2, onClickListener);
                    AppMethodBeat.o(73984);
                    return;
                default:
                    h.a((Context) activity2, i2, 0, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(73978);
                            if (onClickListener != null) {
                                onClickListener.onClick(dialogInterface, -1);
                            }
                            AppMethodBeat.o(73978);
                        }
                    });
                    break;
            }
        } else if (fragment != null) {
            com.tencent.mm.ui.widget.snackbar.b.a(fragment, fragment.getString(R.string.bpv), fragment.getString(R.string.bnm), anonymousClass1, cVar);
            AppMethodBeat.o(73984);
            return;
        } else if (activity != null) {
            com.tencent.mm.ui.widget.snackbar.b.a(activity, activity.getString(R.string.bpv), activity.getString(R.string.bnm), anonymousClass1, cVar);
            AppMethodBeat.o(73984);
            return;
        }
        AppMethodBeat.o(73984);
    }

    private static void a(Activity activity, Fragment fragment) {
        Context activity2;
        AppMethodBeat.i(73985);
        if (fragment != null) {
            activity2 = fragment.getActivity();
        }
        t.makeText(activity2, R.string.boq, 0).show();
        AppMethodBeat.o(73985);
    }

    private static void a(final Context context, final OnClickListener onClickListener) {
        AppMethodBeat.i(73986);
        h.a(context, context.getString(R.string.boj), context.getString(R.string.bok), context.getString(R.string.bom), context.getString(R.string.atb), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(73979);
                Intent intent = new Intent();
                intent.putExtra("key_enter_fav_cleanui_from", 3);
                com.tencent.mm.plugin.fav.a.b.b(context, ".ui.FavCleanUI", intent);
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -2);
                }
                AppMethodBeat.o(73979);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(73980);
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -1);
                }
                AppMethodBeat.o(73980);
            }
        }, (int) R.color.a61);
        AppMethodBeat.o(73986);
    }

    private static void a(int i, int i2, Activity activity, Fragment fragment, OnClickListener onClickListener, a.b bVar, com.tencent.mm.ui.widget.snackbar.a.c cVar) {
        Context context;
        String string;
        AppMethodBeat.i(73987);
        String str = "";
        if (fragment == null) {
            context = activity;
        } else {
            context = fragment.getActivity();
        }
        if (i2 == -4) {
            switch (i) {
                case 2:
                    string = context.getString(R.string.boe);
                    break;
                case 4:
                case 16:
                    string = context.getString(R.string.bof);
                    break;
                case 8:
                    string = context.getString(R.string.bod);
                    break;
                case 14:
                    string = context.getString(R.string.bot);
                    break;
                default:
                    string = str;
                    break;
            }
        } else if (i2 == -5) {
            if (i != 14) {
                string = context.getString(R.string.bnn);
            } else {
                string = context.getString(R.string.bos);
            }
        } else if (i2 == -6) {
            string = context.getString(R.string.bot);
        } else if (i2 == -7) {
            string = context.getString(R.string.bos);
        } else if (i2 == -8) {
            string = context.getString(R.string.bou);
        } else if (i2 != -9) {
            string = context.getString(R.string.boh);
        } else if (fragment != null) {
            com.tencent.mm.ui.widget.snackbar.b.a(fragment, context.getString(R.string.bpv), context.getString(R.string.bnm), bVar, cVar);
            AppMethodBeat.o(73987);
            return;
        } else {
            com.tencent.mm.ui.widget.snackbar.b.a(activity, context.getString(R.string.bpv), context.getString(R.string.bnm), bVar, cVar);
            AppMethodBeat.o(73987);
            return;
        }
        String string2 = context.getString(R.string.dcq);
        String string3 = context.getString(R.string.atb);
        final OnClickListener onClickListener2 = onClickListener;
        final Fragment fragment2 = fragment;
        final a.b bVar2 = bVar;
        final com.tencent.mm.ui.widget.snackbar.a.c cVar2 = cVar;
        final Activity activity2 = activity;
        AnonymousClass5 anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(73981);
                dialogInterface.dismiss();
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, -2);
                }
                if (fragment2 != null) {
                    com.tencent.mm.ui.widget.snackbar.b.a(fragment2, fragment2.getActivity().getString(R.string.bpv), fragment2.getActivity().getString(R.string.bnm), bVar2, cVar2);
                    AppMethodBeat.o(73981);
                    return;
                }
                com.tencent.mm.ui.widget.snackbar.b.a(activity2, activity2.getString(R.string.bpv), activity2.getString(R.string.bnm), bVar2, cVar2);
                AppMethodBeat.o(73981);
            }
        };
        final OnClickListener onClickListener3 = onClickListener;
        h.a(context, string, "", string2, string3, (OnClickListener) anonymousClass5, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(73982);
                dialogInterface.dismiss();
                if (onClickListener3 != null) {
                    onClickListener3.onClick(dialogInterface, -1);
                }
                AppMethodBeat.o(73982);
            }
        }, (int) R.color.a61);
        AppMethodBeat.o(73987);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(bi biVar, cl clVar, boolean z) {
        AppMethodBeat.i(73988);
        String str = "";
        ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", Integer.valueOf(biVar.getType()));
        int a;
        if (z || clVar.cvA.cvG <= 0) {
            boolean z2;
            if (clVar.cvA.type == 4 || clVar.cvA.type == 8 || clVar.cvA.type == 16 || clVar.cvA.type == 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (clVar.cvA.type == 14 && clVar.cvA.cvC.wiv.size() > 0) {
                aar aar = (aar) clVar.cvA.cvC.wiv.getLast();
                if (aar.dataType == 4 || aar.dataType == 8 || aar.dataType == 15 || aar.dataType == 2) {
                    z2 = false;
                }
            }
            ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", Boolean.valueOf(z2));
            if (z2) {
                a = a(clVar, 0);
                AppMethodBeat.o(73988);
                return a;
            } else if (clVar.cvA.cvC == null) {
                a = a(clVar, -1);
                AppMethodBeat.o(73988);
                return a;
            } else if (clVar.cvA.cvC.wiv == null) {
                a = a(clVar, -1);
                AppMethodBeat.o(73988);
                return a;
            } else {
                String str2;
                if (System.currentTimeMillis() - biVar.field_createTime > 259200000) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", Boolean.valueOf(z2));
                if (1 <= clVar.cvA.cvC.wiv.size()) {
                    str2 = ((aar) clVar.cvA.cvC.wiv.getLast()).wgx;
                } else {
                    str2 = str;
                }
                if (z2) {
                    String str3;
                    if (bo.isNullOrNil(str2) || !e.ct(str2)) {
                        if (biVar != null && (biVar.getType() == 43 || biVar.getType() == 44 || biVar.getType() == 62)) {
                            s ut = u.ut(biVar.field_imgPath);
                            if (ut != null && ut.fXk == -1) {
                                str2 = ut.alv();
                                if (e.ct(str2)) {
                                    str3 = str2;
                                    if (bo.isNullOrNil(str3)) {
                                        ((aar) clVar.cvA.cvC.wiv.getLast()).akV(str3);
                                    } else {
                                        a = a(clVar, -4);
                                        AppMethodBeat.o(73988);
                                        return a;
                                    }
                                }
                            }
                        }
                        str3 = null;
                        if (bo.isNullOrNil(str3)) {
                        }
                    } else {
                        str3 = str2;
                    }
                    if (a(biVar, clVar, str3, true)) {
                        a = a(clVar, -5);
                        AppMethodBeat.o(73988);
                        return a;
                    }
                    ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
                } else if (a(biVar, clVar, str2, false)) {
                    a = a(clVar, -5);
                    AppMethodBeat.o(73988);
                    return a;
                }
                ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
                a = a(clVar, 0);
                AppMethodBeat.o(73988);
                return a;
            }
        }
        ab.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
        a = a(clVar, clVar.cvA.cvG);
        AppMethodBeat.o(73988);
        return a;
    }

    private static int a(cl clVar, int i) {
        AppMethodBeat.i(73989);
        if (clVar.cvA.cvC.wiv != null && clVar.cvA.cvC.wiv.size() > 0) {
            aar aar = (aar) clVar.cvA.cvC.wiv.getLast();
            if (i <= 0) {
                switch (i) {
                    case -5:
                        aar.LG(2);
                        aar.akV(null);
                        break;
                    case -4:
                        aar.LG(1);
                        aar.akV(null);
                        break;
                    default:
                        aar.LG(0);
                        break;
                }
            }
        }
        b(clVar, i);
        AppMethodBeat.o(73989);
        return i;
    }

    private static boolean a(bi biVar, cl clVar, String str, boolean z) {
        j.b X;
        AppMethodBeat.i(73990);
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (bVar.exists()) {
                if (bVar.length() > ((long) com.tencent.mm.m.b.Nc())) {
                    ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                    AppMethodBeat.o(73990);
                    return true;
                }
                ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
            } else if (!z) {
                ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
                ((aar) clVar.cvA.cvC.wiv.getLast()).akV(null);
            }
        }
        String str2 = biVar.field_content;
        if (str2 != null) {
            X = j.b.X(str2, biVar.field_reserved);
        } else {
            X = null;
        }
        if (X != null) {
            if (X.fgs != 0 || X.fgo > com.tencent.mm.m.b.Nc()) {
                ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                AppMethodBeat.o(73990);
                return true;
            } else if (!(bo.isNullOrNil(str) || !e.ct(str) || z)) {
                if (((long) X.fgo) > e.asZ(str)) {
                    ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
                    ((aar) clVar.cvA.cvC.wiv.getLast()).akV(null);
                }
            }
        }
        if (str2 == null || X == null) {
            ab.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
        }
        AppMethodBeat.o(73990);
        return false;
    }

    private static void b(cl clVar, int i) {
        AppMethodBeat.i(73991);
        if (clVar.cvA.cvC.wiv == null || clVar.cvA.cvC.wiv.size() == 0) {
            clVar.cvA.cvG = i;
            AppMethodBeat.o(73991);
        } else if (clVar.cvA.cvG == -9) {
            AppMethodBeat.o(73991);
        } else {
            Object obj;
            if (i > 0 || clVar.cvA.cvG > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < clVar.cvA.cvC.wiv.size(); i5++) {
                switch (((aar) clVar.cvA.cvC.wiv.get(i5)).whh) {
                    case 0:
                        i4++;
                        break;
                    case 1:
                        i2++;
                        break;
                    case 2:
                        i3++;
                        break;
                    default:
                        break;
                }
            }
            if (obj > null) {
                if (i3 > 0 || i2 > 0) {
                    clVar.cvA.cvG = -9;
                    AppMethodBeat.o(73991);
                    return;
                }
                clVar.cvA.cvG = i;
                AppMethodBeat.o(73991);
            } else if (i3 <= 0) {
                if (i2 > 0) {
                    if (i4 == 0) {
                        clVar.cvA.cvG = -4;
                        AppMethodBeat.o(73991);
                        return;
                    } else if (i4 > 0) {
                        clVar.cvA.cvG = -6;
                        AppMethodBeat.o(73991);
                        return;
                    }
                }
                AppMethodBeat.o(73991);
            } else if (i2 > 0) {
                clVar.cvA.cvG = -8;
                AppMethodBeat.o(73991);
            } else if (i4 == 0) {
                clVar.cvA.cvG = -5;
                AppMethodBeat.o(73991);
            } else if (i4 > 0) {
                clVar.cvA.cvG = -7;
                AppMethodBeat.o(73991);
            } else {
                AppMethodBeat.o(73991);
            }
        }
    }

    public static void bvC() {
        AppMethodBeat.i(73992);
        mic = new b(20, c.class);
        AppMethodBeat.o(73992);
    }

    static {
        AppMethodBeat.i(73996);
        mid = new HashMap();
        HashMap hashMap = new HashMap();
        mid = hashMap;
        hashMap.put("avi", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("m4v", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("vob", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("mpeg", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("mpe", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("asx", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("asf", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("f4v", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("flv", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("mkv", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("wmv", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("wm", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("3gp", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("mp4", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("rmvb", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("rm", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("ra", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("ram", Integer.valueOf(R.raw.app_attach_file_icon_video));
        mid.put("mp3pro", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("vqf", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("cd", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("md", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("mod", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("vorbis", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("au", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("amr", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("silk", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("wma", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("mmf", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("mid", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("midi", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("mp3", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("aac", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("ape", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("aiff", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("aif", Integer.valueOf(R.raw.app_attach_file_icon_music));
        mid.put("jfif", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("tiff", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("tif", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("jpe", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("dib", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("jpeg", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("jpg", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("png", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("bmp", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("gif", Integer.valueOf(R.raw.app_attach_file_icon_pic));
        mid.put("rar", Integer.valueOf(R.raw.app_attach_file_icon_rar));
        mid.put("zip", Integer.valueOf(R.raw.app_attach_file_icon_rar));
        mid.put("7z", Integer.valueOf(R.raw.app_attach_file_icon_rar));
        mid.put("iso", Integer.valueOf(R.raw.app_attach_file_icon_rar));
        mid.put("cab", Integer.valueOf(R.raw.app_attach_file_icon_rar));
        mid.put("doc", Integer.valueOf(R.raw.app_attach_file_icon_word));
        mid.put("docx", Integer.valueOf(R.raw.app_attach_file_icon_word));
        mid.put("ppt", Integer.valueOf(R.raw.app_attach_file_icon_ppt));
        mid.put("pptx", Integer.valueOf(R.raw.app_attach_file_icon_ppt));
        mid.put("xls", Integer.valueOf(R.raw.app_attach_file_icon_excel));
        mid.put("xlsx", Integer.valueOf(R.raw.app_attach_file_icon_excel));
        mid.put("txt", Integer.valueOf(R.raw.app_attach_file_icon_txt));
        mid.put("rtf", Integer.valueOf(R.raw.app_attach_file_icon_txt));
        mid.put("pdf", Integer.valueOf(R.raw.app_attach_file_icon_pdf));
        mid.put("unknown", Integer.valueOf(R.raw.app_attach_file_icon_unknow));
        AppMethodBeat.o(73996);
    }

    public static Bitmap aI(String str, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(73993);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(73993);
            return null;
        }
        Bitmap bitmap = (Bitmap) mic.get(str);
        if (bitmap != null) {
            ab.d("MicroMsg.FavExportLogic", "get bm from cache %s", str);
            AppMethodBeat.o(73993);
            return bitmap;
        } else if (z) {
            AppMethodBeat.o(73993);
            return null;
        } else if (e.ct(str)) {
            int i;
            ab.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                ab.i("MicroMsg.FavExportLogic", "bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            boolean z3 = ad.cJ(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!ad.cI(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || z4) {
                int i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                ab.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2));
            }
            i = ExifHelper.bJ(str);
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.FavExportLogic";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                ab.i(str2, str3, objArr);
            } else {
                bitmap = d.aml(str);
            }
            if (bitmap == null) {
                ab.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
                AppMethodBeat.o(73993);
                return null;
            }
            bitmap = d.b(bitmap, (float) i);
            if (bitmap.getHeight() * bitmap.getWidth() > 20971520) {
                AppMethodBeat.o(73993);
                return bitmap;
            }
            mic.put(str, bitmap);
            AppMethodBeat.o(73993);
            return bitmap;
        } else {
            AppMethodBeat.o(73993);
            return null;
        }
    }

    public static int LX(String str) {
        AppMethodBeat.i(73994);
        Integer num = (Integer) mid.get(str);
        int intValue;
        if (num == null) {
            intValue = ((Integer) mid.get("unknown")).intValue();
            AppMethodBeat.o(73994);
            return intValue;
        }
        intValue = num.intValue();
        AppMethodBeat.o(73994);
        return intValue;
    }

    @TargetApi(8)
    public static Bitmap LY(String str) {
        AppMethodBeat.i(73995);
        Bitmap bitmap = null;
        if (com.tencent.mm.compatible.util.d.iW(8)) {
            bitmap = ThumbnailUtils.createVideoThumbnail(str, 1);
        }
        AppMethodBeat.o(73995);
        return bitmap;
    }

    public static void bvD() {
    }
}
