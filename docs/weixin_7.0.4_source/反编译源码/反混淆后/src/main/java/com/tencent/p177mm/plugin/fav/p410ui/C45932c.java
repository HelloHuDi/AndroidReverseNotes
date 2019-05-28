package com.tencent.p177mm.plugin.fav.p410ui;

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
import android.support.p057v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24109b;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24112c;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C35985ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fav.ui.c */
public class C45932c {
    private static C1177f<String, Bitmap> mic = new C26399b(20, C45932c.class);
    private static Map<String, Integer> mid;

    /* renamed from: com.tencent.mm.plugin.fav.ui.c$1 */
    static class C341591 implements C24109b {
        C341591() {
        }

        public final void aIu() {
            AppMethodBeat.m2504i(73977);
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 35;
            C4879a.xxA.mo10055m(c37721gh);
            AppMethodBeat.m2505o(73977);
        }
    }

    /* renamed from: a */
    public static void m85258a(int i, Activity activity, C24109b c24109b) {
        AppMethodBeat.m2504i(73983);
        C45932c.m85257a(-1, i, activity, null, null, null, c24109b);
        AppMethodBeat.m2505o(73983);
    }

    /* renamed from: a */
    public static void m85257a(int i, int i2, Activity activity, Fragment fragment, C24112c c24112c, final OnClickListener onClickListener, C24109b c24109b) {
        AppMethodBeat.m2504i(73984);
        if (activity == null && fragment == null) {
            C4990ab.m7412e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
            AppMethodBeat.m2505o(73984);
            return;
        }
        C24109b c341591;
        if (c24109b == null) {
            c341591 = new C341591();
        } else {
            c341591 = c24109b;
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
                    C45932c.m85259a(activity2, fragment);
                    AppMethodBeat.m2505o(73984);
                    return;
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                    C45932c.m85256a(i, i2, activity2, fragment, onClickListener, c341591, c24112c);
                    AppMethodBeat.m2505o(73984);
                    return;
                case -2:
                    C45932c.m85260a((Context) activity2, onClickListener);
                    AppMethodBeat.m2505o(73984);
                    return;
                default:
                    C30379h.m48431a((Context) activity2, i2, 0, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(73978);
                            if (onClickListener != null) {
                                onClickListener.onClick(dialogInterface, -1);
                            }
                            AppMethodBeat.m2505o(73978);
                        }
                    });
                    break;
            }
        } else if (fragment != null) {
            C5670b.m8521a(fragment, fragment.getString(C25738R.string.bpv), fragment.getString(C25738R.string.bnm), c341591, c24112c);
            AppMethodBeat.m2505o(73984);
            return;
        } else if (activity != null) {
            C5670b.m8518a(activity, activity.getString(C25738R.string.bpv), activity.getString(C25738R.string.bnm), c341591, c24112c);
            AppMethodBeat.m2505o(73984);
            return;
        }
        AppMethodBeat.m2505o(73984);
    }

    /* renamed from: a */
    private static void m85259a(Activity activity, Fragment fragment) {
        Context activity2;
        AppMethodBeat.m2504i(73985);
        if (fragment != null) {
            activity2 = fragment.getActivity();
        }
        C23639t.makeText(activity2, C25738R.string.boq, 0).show();
        AppMethodBeat.m2505o(73985);
    }

    /* renamed from: a */
    private static void m85260a(final Context context, final OnClickListener onClickListener) {
        AppMethodBeat.m2504i(73986);
        C30379h.m48444a(context, context.getString(C25738R.string.boj), context.getString(C25738R.string.bok), context.getString(C25738R.string.bom), context.getString(C25738R.string.atb), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(73979);
                Intent intent = new Intent();
                intent.putExtra("key_enter_fav_cleanui_from", 3);
                C39037b.m66371b(context, ".ui.FavCleanUI", intent);
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -2);
                }
                AppMethodBeat.m2505o(73979);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(73980);
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -1);
                }
                AppMethodBeat.m2505o(73980);
            }
        }, (int) C25738R.color.a61);
        AppMethodBeat.m2505o(73986);
    }

    /* renamed from: a */
    private static void m85256a(int i, int i2, Activity activity, Fragment fragment, OnClickListener onClickListener, C24109b c24109b, C24112c c24112c) {
        Context context;
        String string;
        AppMethodBeat.m2504i(73987);
        String str = "";
        if (fragment == null) {
            context = activity;
        } else {
            context = fragment.getActivity();
        }
        if (i2 == -4) {
            switch (i) {
                case 2:
                    string = context.getString(C25738R.string.boe);
                    break;
                case 4:
                case 16:
                    string = context.getString(C25738R.string.bof);
                    break;
                case 8:
                    string = context.getString(C25738R.string.bod);
                    break;
                case 14:
                    string = context.getString(C25738R.string.bot);
                    break;
                default:
                    string = str;
                    break;
            }
        } else if (i2 == -5) {
            if (i != 14) {
                string = context.getString(C25738R.string.bnn);
            } else {
                string = context.getString(C25738R.string.bos);
            }
        } else if (i2 == -6) {
            string = context.getString(C25738R.string.bot);
        } else if (i2 == -7) {
            string = context.getString(C25738R.string.bos);
        } else if (i2 == -8) {
            string = context.getString(C25738R.string.bou);
        } else if (i2 != -9) {
            string = context.getString(C25738R.string.boh);
        } else if (fragment != null) {
            C5670b.m8521a(fragment, context.getString(C25738R.string.bpv), context.getString(C25738R.string.bnm), c24109b, c24112c);
            AppMethodBeat.m2505o(73987);
            return;
        } else {
            C5670b.m8518a(activity, context.getString(C25738R.string.bpv), context.getString(C25738R.string.bnm), c24109b, c24112c);
            AppMethodBeat.m2505o(73987);
            return;
        }
        String string2 = context.getString(C25738R.string.dcq);
        String string3 = context.getString(C25738R.string.atb);
        final OnClickListener onClickListener2 = onClickListener;
        final Fragment fragment2 = fragment;
        final C24109b c24109b2 = c24109b;
        final C24112c c24112c2 = c24112c;
        final Activity activity2 = activity;
        C118845 c118845 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(73981);
                dialogInterface.dismiss();
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, -2);
                }
                if (fragment2 != null) {
                    C5670b.m8521a(fragment2, fragment2.getActivity().getString(C25738R.string.bpv), fragment2.getActivity().getString(C25738R.string.bnm), c24109b2, c24112c2);
                    AppMethodBeat.m2505o(73981);
                    return;
                }
                C5670b.m8518a(activity2, activity2.getString(C25738R.string.bpv), activity2.getString(C25738R.string.bnm), c24109b2, c24112c2);
                AppMethodBeat.m2505o(73981);
            }
        };
        final OnClickListener onClickListener3 = onClickListener;
        C30379h.m48444a(context, string, "", string2, string3, (OnClickListener) c118845, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(73982);
                dialogInterface.dismiss();
                if (onClickListener3 != null) {
                    onClickListener3.onClick(dialogInterface, -1);
                }
                AppMethodBeat.m2505o(73982);
            }
        }, (int) C25738R.color.a61);
        AppMethodBeat.m2505o(73987);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static int m85255a(C7620bi c7620bi, C45316cl c45316cl, boolean z) {
        AppMethodBeat.m2504i(73988);
        String str = "";
        C4990ab.m7417i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", Integer.valueOf(c7620bi.getType()));
        int a;
        if (z || c45316cl.cvA.cvG <= 0) {
            boolean z2;
            if (c45316cl.cvA.type == 4 || c45316cl.cvA.type == 8 || c45316cl.cvA.type == 16 || c45316cl.cvA.type == 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (c45316cl.cvA.type == 14 && c45316cl.cvA.cvC.wiv.size() > 0) {
                aar aar = (aar) c45316cl.cvA.cvC.wiv.getLast();
                if (aar.dataType == 4 || aar.dataType == 8 || aar.dataType == 15 || aar.dataType == 2) {
                    z2 = false;
                }
            }
            C4990ab.m7417i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", Boolean.valueOf(z2));
            if (z2) {
                a = C45932c.m85254a(c45316cl, 0);
                AppMethodBeat.m2505o(73988);
                return a;
            } else if (c45316cl.cvA.cvC == null) {
                a = C45932c.m85254a(c45316cl, -1);
                AppMethodBeat.m2505o(73988);
                return a;
            } else if (c45316cl.cvA.cvC.wiv == null) {
                a = C45932c.m85254a(c45316cl, -1);
                AppMethodBeat.m2505o(73988);
                return a;
            } else {
                String str2;
                if (System.currentTimeMillis() - c7620bi.field_createTime > 259200000) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C4990ab.m7417i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", Boolean.valueOf(z2));
                if (1 <= c45316cl.cvA.cvC.wiv.size()) {
                    str2 = ((aar) c45316cl.cvA.cvC.wiv.getLast()).wgx;
                } else {
                    str2 = str;
                }
                if (z2) {
                    String str3;
                    if (C5046bo.isNullOrNil(str2) || !C5730e.m8628ct(str2)) {
                        if (c7620bi != null && (c7620bi.getType() == 43 || c7620bi.getType() == 44 || c7620bi.getType() == 62)) {
                            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
                            if (ut != null && ut.fXk == -1) {
                                str2 = ut.alv();
                                if (C5730e.m8628ct(str2)) {
                                    str3 = str2;
                                    if (C5046bo.isNullOrNil(str3)) {
                                        ((aar) c45316cl.cvA.cvC.wiv.getLast()).akV(str3);
                                    } else {
                                        a = C45932c.m85254a(c45316cl, -4);
                                        AppMethodBeat.m2505o(73988);
                                        return a;
                                    }
                                }
                            }
                        }
                        str3 = null;
                        if (C5046bo.isNullOrNil(str3)) {
                        }
                    } else {
                        str3 = str2;
                    }
                    if (C45932c.m85261a(c7620bi, c45316cl, str3, true)) {
                        a = C45932c.m85254a(c45316cl, -5);
                        AppMethodBeat.m2505o(73988);
                        return a;
                    }
                    C4990ab.m7416i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
                } else if (C45932c.m85261a(c7620bi, c45316cl, str2, false)) {
                    a = C45932c.m85254a(c45316cl, -5);
                    AppMethodBeat.m2505o(73988);
                    return a;
                }
                C4990ab.m7416i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
                a = C45932c.m85254a(c45316cl, 0);
                AppMethodBeat.m2505o(73988);
                return a;
            }
        }
        C4990ab.m7416i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
        a = C45932c.m85254a(c45316cl, c45316cl.cvA.cvG);
        AppMethodBeat.m2505o(73988);
        return a;
    }

    /* renamed from: a */
    private static int m85254a(C45316cl c45316cl, int i) {
        AppMethodBeat.m2504i(73989);
        if (c45316cl.cvA.cvC.wiv != null && c45316cl.cvA.cvC.wiv.size() > 0) {
            aar aar = (aar) c45316cl.cvA.cvC.wiv.getLast();
            if (i <= 0) {
                switch (i) {
                    case -5:
                        aar.mo27396LG(2);
                        aar.akV(null);
                        break;
                    case -4:
                        aar.mo27396LG(1);
                        aar.akV(null);
                        break;
                    default:
                        aar.mo27396LG(0);
                        break;
                }
            }
        }
        C45932c.m85263b(c45316cl, i);
        AppMethodBeat.m2505o(73989);
        return i;
    }

    /* renamed from: a */
    private static boolean m85261a(C7620bi c7620bi, C45316cl c45316cl, String str, boolean z) {
        C8910b X;
        AppMethodBeat.m2504i(73990);
        if (!C5046bo.isNullOrNil(str)) {
            C5728b c5728b = new C5728b(str);
            if (c5728b.exists()) {
                if (c5728b.length() > ((long) C42164b.m74341Nc())) {
                    C4990ab.m7416i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                    AppMethodBeat.m2505o(73990);
                    return true;
                }
                C4990ab.m7416i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
            } else if (!z) {
                C4990ab.m7416i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
                ((aar) c45316cl.cvA.cvC.wiv.getLast()).akV(null);
            }
        }
        String str2 = c7620bi.field_content;
        if (str2 != null) {
            X = C8910b.m16058X(str2, c7620bi.field_reserved);
        } else {
            X = null;
        }
        if (X != null) {
            if (X.fgs != 0 || X.fgo > C42164b.m74341Nc()) {
                C4990ab.m7416i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                AppMethodBeat.m2505o(73990);
                return true;
            } else if (!(C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str) || z)) {
                if (((long) X.fgo) > C5730e.asZ(str)) {
                    C4990ab.m7416i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
                    ((aar) c45316cl.cvA.cvC.wiv.getLast()).akV(null);
                }
            }
        }
        if (str2 == null || X == null) {
            C4990ab.m7416i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
        }
        AppMethodBeat.m2505o(73990);
        return false;
    }

    /* renamed from: b */
    private static void m85263b(C45316cl c45316cl, int i) {
        AppMethodBeat.m2504i(73991);
        if (c45316cl.cvA.cvC.wiv == null || c45316cl.cvA.cvC.wiv.size() == 0) {
            c45316cl.cvA.cvG = i;
            AppMethodBeat.m2505o(73991);
        } else if (c45316cl.cvA.cvG == -9) {
            AppMethodBeat.m2505o(73991);
        } else {
            Object obj;
            if (i > 0 || c45316cl.cvA.cvG > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < c45316cl.cvA.cvC.wiv.size(); i5++) {
                switch (((aar) c45316cl.cvA.cvC.wiv.get(i5)).whh) {
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
                    c45316cl.cvA.cvG = -9;
                    AppMethodBeat.m2505o(73991);
                    return;
                }
                c45316cl.cvA.cvG = i;
                AppMethodBeat.m2505o(73991);
            } else if (i3 <= 0) {
                if (i2 > 0) {
                    if (i4 == 0) {
                        c45316cl.cvA.cvG = -4;
                        AppMethodBeat.m2505o(73991);
                        return;
                    } else if (i4 > 0) {
                        c45316cl.cvA.cvG = -6;
                        AppMethodBeat.m2505o(73991);
                        return;
                    }
                }
                AppMethodBeat.m2505o(73991);
            } else if (i2 > 0) {
                c45316cl.cvA.cvG = -8;
                AppMethodBeat.m2505o(73991);
            } else if (i4 == 0) {
                c45316cl.cvA.cvG = -5;
                AppMethodBeat.m2505o(73991);
            } else if (i4 > 0) {
                c45316cl.cvA.cvG = -7;
                AppMethodBeat.m2505o(73991);
            } else {
                AppMethodBeat.m2505o(73991);
            }
        }
    }

    public static void bvC() {
        AppMethodBeat.m2504i(73992);
        mic = new C26399b(20, C45932c.class);
        AppMethodBeat.m2505o(73992);
    }

    static {
        AppMethodBeat.m2504i(73996);
        mid = new HashMap();
        HashMap hashMap = new HashMap();
        mid = hashMap;
        hashMap.put("avi", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("m4v", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("vob", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("mpeg", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("mpe", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("asx", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("asf", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("f4v", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("flv", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("mkv", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("wmv", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("wm", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("3gp", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("mp4", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("rmvb", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("rm", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("ra", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("ram", Integer.valueOf(C1318a.app_attach_file_icon_video));
        mid.put("mp3pro", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("vqf", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("cd", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("md", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("mod", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("vorbis", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("au", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("amr", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("silk", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("wma", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("mmf", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("mid", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("midi", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("mp3", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("aac", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("ape", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("aiff", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("aif", Integer.valueOf(C1318a.app_attach_file_icon_music));
        mid.put("jfif", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("tiff", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("tif", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("jpe", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("dib", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("jpeg", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("jpg", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("png", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("bmp", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("gif", Integer.valueOf(C1318a.app_attach_file_icon_pic));
        mid.put("rar", Integer.valueOf(C1318a.app_attach_file_icon_rar));
        mid.put("zip", Integer.valueOf(C1318a.app_attach_file_icon_rar));
        mid.put("7z", Integer.valueOf(C1318a.app_attach_file_icon_rar));
        mid.put("iso", Integer.valueOf(C1318a.app_attach_file_icon_rar));
        mid.put("cab", Integer.valueOf(C1318a.app_attach_file_icon_rar));
        mid.put("doc", Integer.valueOf(C1318a.app_attach_file_icon_word));
        mid.put("docx", Integer.valueOf(C1318a.app_attach_file_icon_word));
        mid.put("ppt", Integer.valueOf(C1318a.app_attach_file_icon_ppt));
        mid.put("pptx", Integer.valueOf(C1318a.app_attach_file_icon_ppt));
        mid.put("xls", Integer.valueOf(C1318a.app_attach_file_icon_excel));
        mid.put("xlsx", Integer.valueOf(C1318a.app_attach_file_icon_excel));
        mid.put("txt", Integer.valueOf(C1318a.app_attach_file_icon_txt));
        mid.put("rtf", Integer.valueOf(C1318a.app_attach_file_icon_txt));
        mid.put("pdf", Integer.valueOf(C1318a.app_attach_file_icon_pdf));
        mid.put("unknown", Integer.valueOf(C1318a.app_attach_file_icon_unknow));
        AppMethodBeat.m2505o(73996);
    }

    /* renamed from: aI */
    public static Bitmap m85262aI(String str, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(73993);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(73993);
            return null;
        }
        Bitmap bitmap = (Bitmap) mic.get(str);
        if (bitmap != null) {
            C4990ab.m7411d("MicroMsg.FavExportLogic", "get bm from cache %s", str);
            AppMethodBeat.m2505o(73993);
            return bitmap;
        } else if (z) {
            AppMethodBeat.m2505o(73993);
            return null;
        } else if (C5730e.m8628ct(str)) {
            int i;
            C4990ab.m7410d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                C4990ab.m7417i("MicroMsg.FavExportLogic", "bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            boolean z3 = C35985ad.m59194cJ(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!C35985ad.m59193cI(options.outWidth, options.outHeight) || options.outHeight <= 480) {
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
                C4990ab.m7421w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2));
            }
            i = ExifHelper.m7368bJ(str);
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.FavExportLogic";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                C4990ab.m7417i(str2, str3, objArr);
            } else {
                bitmap = C5056d.aml(str);
            }
            if (bitmap == null) {
                C4990ab.m7412e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(73993);
                return null;
            }
            bitmap = C5056d.m7648b(bitmap, (float) i);
            if (bitmap.getHeight() * bitmap.getWidth() > 20971520) {
                AppMethodBeat.m2505o(73993);
                return bitmap;
            }
            mic.put(str, bitmap);
            AppMethodBeat.m2505o(73993);
            return bitmap;
        } else {
            AppMethodBeat.m2505o(73993);
            return null;
        }
    }

    /* renamed from: LX */
    public static int m85252LX(String str) {
        AppMethodBeat.m2504i(73994);
        Integer num = (Integer) mid.get(str);
        int intValue;
        if (num == null) {
            intValue = ((Integer) mid.get("unknown")).intValue();
            AppMethodBeat.m2505o(73994);
            return intValue;
        }
        intValue = num.intValue();
        AppMethodBeat.m2505o(73994);
        return intValue;
    }

    @TargetApi(8)
    /* renamed from: LY */
    public static Bitmap m85253LY(String str) {
        AppMethodBeat.m2504i(73995);
        Bitmap bitmap = null;
        if (C1443d.m3068iW(8)) {
            bitmap = ThumbnailUtils.createVideoThumbnail(str, 1);
        }
        AppMethodBeat.m2505o(73995);
        return bitmap;
    }

    public static void bvD() {
    }
}
