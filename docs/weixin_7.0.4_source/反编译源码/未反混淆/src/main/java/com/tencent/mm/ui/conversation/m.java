package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.Map;

public final class m {
    private static c zvu = null;

    static /* synthetic */ void ia(Context context) {
        AppMethodBeat.i(34589);
        C(context, true);
        AppMethodBeat.o(34589);
    }

    static /* synthetic */ void ib(Context context) {
        AppMethodBeat.i(34590);
        hZ(context);
        AppMethodBeat.o(34590);
    }

    public static void hY(Context context) {
        AppMethodBeat.i(34585);
        if (g.dnY()) {
            String value = com.tencent.mm.m.g.Nu().getValue("NewShowRating");
            if (bo.isNullOrNil(value)) {
                AppMethodBeat.o(34585);
                return;
            }
            Map z = br.z(value, "ShowRatingNode");
            value = (z == null || z.get(".ShowRatingNode.MinVer") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : (String) z.get(".ShowRatingNode.MinVer");
            int intValue = Integer.decode(value).intValue();
            value = (z == null || z.get(".ShowRatingNode.MaxVer") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : (String) z.get(".ShowRatingNode.MaxVer");
            int intValue2 = Integer.decode(value).intValue();
            value = (z == null || z.get(".ShowRatingNode.WaitDays") == null) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : (String) z.get(".ShowRatingNode.WaitDays");
            int intValue3 = Integer.decode(value).intValue();
            if (intValue > d.vxo || d.vxo > intValue2) {
                AppMethodBeat.o(34585);
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
                sharedPreferences.edit().putInt("show_rating_version", d.vxo).commit();
                sharedPreferences.edit().putInt("show_rating_flag", 0).commit();
                i = 0;
                j = System.currentTimeMillis();
                sharedPreferences.edit().putLong("show_rating_timestamp", j).commit();
                sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                sharedPreferences.edit().putInt("show_rating_wait_days", intValue3).commit();
                sharedPreferences.edit().putInt("show_rating_first_second_time", (int) (System.currentTimeMillis() / 1000)).commit();
                ab.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", Integer.valueOf(d.vxo), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(j2));
            }
            if (intValue <= d.vxo && d.vxo <= intValue2 && i == 0 && j != 0 && System.currentTimeMillis() >= j + j2) {
                ab.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
                String string = context.getString(R.string.ehn);
                String string2 = context.getString(R.string.ehm);
                final Context context2 = context;
                OnClickListener anonymousClass1 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34579);
                        sharedPreferences.edit().putInt("show_rating_flag", 1).commit();
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        m.zvu = null;
                        m.ia(context2);
                        ab.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
                        AppMethodBeat.o(34579);
                    }
                };
                context2 = context;
                zvu = h.a(context, false, context.getString(R.string.ehu), "", string, string2, anonymousClass1, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34580);
                        sharedPreferences.edit().putInt("show_rating_flag", 2).commit();
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        m.zvu = null;
                        m.ib(context2);
                        ab.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
                        AppMethodBeat.o(34580);
                    }
                });
                AppMethodBeat.o(34585);
                return;
            } else if (z2 && j != 0 && System.currentTimeMillis() >= (j + j2) + 345600000) {
                ab.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
                C(context, false);
                sharedPreferences.edit().putInt("show_rating_flag", 3).commit();
                AppMethodBeat.o(34585);
                return;
            } else if (i == 1) {
                C(context, true);
                AppMethodBeat.o(34585);
                return;
            } else if (i == 2) {
                hZ(context);
                AppMethodBeat.o(34585);
                return;
            } else {
                if (i == 3) {
                    C(context, false);
                }
                AppMethodBeat.o(34585);
                return;
            }
        }
        AppMethodBeat.o(34585);
    }

    private static void C(Context context, boolean z) {
        String string;
        String str;
        String str2;
        AppMethodBeat.i(34586);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string2;
        String string3;
        if (z) {
            string2 = context.getString(R.string.eht);
            string3 = context.getString(R.string.ehs);
            string = context.getString(R.string.ehr);
            str = string3;
            str2 = string2;
        } else {
            string2 = context.getString(R.string.ehq);
            string3 = context.getString(R.string.ehp);
            string = context.getString(R.string.eho);
            str = string3;
            str2 = string2;
        }
        final Context context2 = context;
        zvu = h.a(context, false, str2, "", str, string, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(34581);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                String str = "market://details?id=" + ah.getPackageName();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                context2.startActivity(intent);
                ab.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                m.zvu = null;
                if (z2) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(11216, Integer.valueOf(5), Integer.valueOf(i2), Integer.valueOf(i));
                    AppMethodBeat.o(34581);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(11216, Integer.valueOf(4), Integer.valueOf(i2), Integer.valueOf(i));
                AppMethodBeat.o(34581);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(34582);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (z2) {
                    sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                    com.tencent.mm.plugin.report.service.h.pYm.e(11216, Integer.valueOf(3), Integer.valueOf(i2), Integer.valueOf(i));
                } else {
                    ab.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
                    sharedPreferences.edit().putBoolean("show_rating_again", true).commit();
                    com.tencent.mm.plugin.report.service.h.pYm.e(11216, Integer.valueOf(6), Integer.valueOf(i2), Integer.valueOf(i));
                }
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                m.zvu = null;
                AppMethodBeat.o(34582);
            }
        });
        AppMethodBeat.o(34586);
    }

    private static void hZ(final Context context) {
        AppMethodBeat.i(34587);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string = context.getString(R.string.ehw);
        String string2 = context.getString(R.string.ehv);
        OnClickListener anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(34583);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                e.a(context, (int) System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
                m.zvu = null;
                com.tencent.mm.plugin.report.service.h.pYm.e(11216, Integer.valueOf(2), Integer.valueOf(i2), Integer.valueOf(i));
                AppMethodBeat.o(34583);
            }
        };
        OnClickListener anonymousClass6 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(34584);
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                m.zvu = null;
                com.tencent.mm.plugin.report.service.h.pYm.e(11216, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i));
                AppMethodBeat.o(34584);
            }
        };
        zvu = h.a(context, false, context.getString(R.string.ehx), "", string, string2, anonymousClass5, anonymousClass6);
        AppMethodBeat.o(34587);
    }

    public static void dIW() {
        AppMethodBeat.i(34588);
        if (zvu != null) {
            zvu.dismiss();
            zvu = null;
        }
        AppMethodBeat.o(34588);
    }
}
