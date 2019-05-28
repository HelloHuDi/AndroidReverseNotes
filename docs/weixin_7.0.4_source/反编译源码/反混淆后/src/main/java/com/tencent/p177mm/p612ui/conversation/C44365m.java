package com.tencent.p177mm.p612ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.conversation.m */
public final class C44365m {
    private static C5653c zvu = null;

    /* renamed from: ia */
    static /* synthetic */ void m80191ia(Context context) {
        AppMethodBeat.m2504i(34589);
        C44365m.m80188C(context, true);
        AppMethodBeat.m2505o(34589);
    }

    /* renamed from: ib */
    static /* synthetic */ void m80192ib(Context context) {
        AppMethodBeat.m2504i(34590);
        C44365m.m80190hZ(context);
        AppMethodBeat.m2505o(34590);
    }

    /* renamed from: hY */
    public static void m80189hY(Context context) {
        AppMethodBeat.m2504i(34585);
        if (C5059g.dnY()) {
            String value = C26373g.m41964Nu().getValue("NewShowRating");
            if (C5046bo.isNullOrNil(value)) {
                AppMethodBeat.m2505o(34585);
                return;
            }
            Map z = C5049br.m7595z(value, "ShowRatingNode");
            value = (z == null || z.get(".ShowRatingNode.MinVer") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : (String) z.get(".ShowRatingNode.MinVer");
            int intValue = Integer.decode(value).intValue();
            value = (z == null || z.get(".ShowRatingNode.MaxVer") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : (String) z.get(".ShowRatingNode.MaxVer");
            int intValue2 = Integer.decode(value).intValue();
            value = (z == null || z.get(".ShowRatingNode.WaitDays") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : (String) z.get(".ShowRatingNode.WaitDays");
            int intValue3 = Integer.decode(value).intValue();
            if (intValue > C7243d.vxo || C7243d.vxo > intValue2) {
                AppMethodBeat.m2505o(34585);
                return;
            }
            Object obj;
            final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
            int i = sharedPreferences.getInt("show_rating_flag", 0);
            int i2 = sharedPreferences.getInt("show_rating_version", 0);
            long j = sharedPreferences.getLong("show_rating_timestamp", 0);
            boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
            long j2 = ((long) (intValue3 == 0 ? 7 : intValue3)) * 86400000;
            if (i2 == 0 || intValue > i2 || i2 > intValue2) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                sharedPreferences.edit().putInt("show_rating_version", C7243d.vxo).commit();
                sharedPreferences.edit().putInt("show_rating_flag", 0).commit();
                i = 0;
                j = System.currentTimeMillis();
                sharedPreferences.edit().putLong("show_rating_timestamp", j).commit();
                sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                sharedPreferences.edit().putInt("show_rating_wait_days", intValue3).commit();
                sharedPreferences.edit().putInt("show_rating_first_second_time", (int) (System.currentTimeMillis() / 1000)).commit();
                C4990ab.m7417i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", Integer.valueOf(C7243d.vxo), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(j2));
            }
            if (intValue <= C7243d.vxo && C7243d.vxo <= intValue2 && i == 0 && j != 0 && System.currentTimeMillis() >= j + j2) {
                C4990ab.m7416i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
                String string = context.getString(C25738R.string.ehn);
                String string2 = context.getString(C25738R.string.ehm);
                final Context context2 = context;
                OnClickListener c443611 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(34579);
                        sharedPreferences.edit().putInt("show_rating_flag", 1).commit();
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        C44365m.zvu = null;
                        C44365m.m80191ia(context2);
                        C4990ab.m7410d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
                        AppMethodBeat.m2505o(34579);
                    }
                };
                context2 = context;
                zvu = C30379h.m48453a(context, false, context.getString(C25738R.string.ehu), "", string, string2, c443611, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(34580);
                        sharedPreferences.edit().putInt("show_rating_flag", 2).commit();
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        C44365m.zvu = null;
                        C44365m.m80192ib(context2);
                        C4990ab.m7410d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
                        AppMethodBeat.m2505o(34580);
                    }
                });
                AppMethodBeat.m2505o(34585);
                return;
            } else if (z2 && j != 0 && System.currentTimeMillis() >= (j + j2) + 345600000) {
                C4990ab.m7416i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
                C44365m.m80188C(context, false);
                sharedPreferences.edit().putInt("show_rating_flag", 3).commit();
                AppMethodBeat.m2505o(34585);
                return;
            } else if (i == 1) {
                C44365m.m80188C(context, true);
                AppMethodBeat.m2505o(34585);
                return;
            } else if (i == 2) {
                C44365m.m80190hZ(context);
                AppMethodBeat.m2505o(34585);
                return;
            } else {
                if (i == 3) {
                    C44365m.m80188C(context, false);
                }
                AppMethodBeat.m2505o(34585);
                return;
            }
        }
        AppMethodBeat.m2505o(34585);
    }

    /* renamed from: C */
    private static void m80188C(Context context, boolean z) {
        String string;
        String str;
        String str2;
        AppMethodBeat.m2504i(34586);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string2;
        String string3;
        if (z) {
            string2 = context.getString(C25738R.string.eht);
            string3 = context.getString(C25738R.string.ehs);
            string = context.getString(C25738R.string.ehr);
            str = string3;
            str2 = string2;
        } else {
            string2 = context.getString(C25738R.string.ehq);
            string3 = context.getString(C25738R.string.ehp);
            string = context.getString(C25738R.string.eho);
            str = string3;
            str2 = string2;
        }
        final Context context2 = context;
        zvu = C30379h.m48453a(context, false, str2, "", str, string, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34581);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                String str = "market://details?id=" + C4996ah.getPackageName();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                context2.startActivity(intent);
                C4990ab.m7410d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                C44365m.zvu = null;
                if (z2) {
                    C7060h.pYm.mo8381e(11216, Integer.valueOf(5), Integer.valueOf(i2), Integer.valueOf(i));
                    AppMethodBeat.m2505o(34581);
                    return;
                }
                C7060h.pYm.mo8381e(11216, Integer.valueOf(4), Integer.valueOf(i2), Integer.valueOf(i));
                AppMethodBeat.m2505o(34581);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34582);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (z2) {
                    sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                    C7060h.pYm.mo8381e(11216, Integer.valueOf(3), Integer.valueOf(i2), Integer.valueOf(i));
                } else {
                    C4990ab.m7410d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
                    sharedPreferences.edit().putBoolean("show_rating_again", true).commit();
                    C7060h.pYm.mo8381e(11216, Integer.valueOf(6), Integer.valueOf(i2), Integer.valueOf(i));
                }
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                C44365m.zvu = null;
                AppMethodBeat.m2505o(34582);
            }
        });
        AppMethodBeat.m2505o(34586);
    }

    /* renamed from: hZ */
    private static void m80190hZ(final Context context) {
        AppMethodBeat.m2504i(34587);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string = context.getString(C25738R.string.ehw);
        String string2 = context.getString(C25738R.string.ehv);
        OnClickListener c443645 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34583);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                C14827e.m23072a(context, (int) System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
                C44365m.zvu = null;
                C7060h.pYm.mo8381e(11216, Integer.valueOf(2), Integer.valueOf(i2), Integer.valueOf(i));
                AppMethodBeat.m2505o(34583);
            }
        };
        OnClickListener c239966 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34584);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                C44365m.zvu = null;
                C7060h.pYm.mo8381e(11216, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i));
                AppMethodBeat.m2505o(34584);
            }
        };
        zvu = C30379h.m48453a(context, false, context.getString(C25738R.string.ehx), "", string, string2, c443645, c239966);
        AppMethodBeat.m2505o(34587);
    }

    public static void dIW() {
        AppMethodBeat.m2504i(34588);
        if (zvu != null) {
            zvu.dismiss();
            zvu = null;
        }
        AppMethodBeat.m2505o(34588);
    }
}
